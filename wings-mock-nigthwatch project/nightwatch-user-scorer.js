const fs = require("fs");
const path = require("path");
const config = require("./nightwatch.conf");

const reportDir = path.join(__dirname, "report");
const reportFiles = fs.existsSync(reportDir) ? fs.readdirSync(reportDir) : [];

function findReportFile(extension) {
  return reportFiles.find((file) =>
    file.toLowerCase().endsWith(extension.toLowerCase()),
  );
}

function parseXmlReport(xmlText) {
  const testsuiteMatch = xmlText.match(/<testsuite[^>]*>/i);
  if (!testsuiteMatch) return null;

  const attrs = {};
  const attrRegex = /(\w+)="(\d+)"/g;
  let match;

  while ((match = attrRegex.exec(testsuiteMatch[0])) !== null) {
    attrs[match[1]] = Number(match[2]);
  }

  return {
    tests: attrs.tests || 0,
    failures: attrs.failures || 0,
    errors: attrs.errors || 0,
    skipped: attrs.skipped || 0,
  };
}

function parseJsonReport(jsonText) {
  try {
    const data = JSON.parse(jsonText);
    if (data.report && typeof data.report === "object") {
      const report = data.report;
      return {
        tests:
          typeof report.testsCount === "number"
            ? report.testsCount
            : report.passedCount +
              report.failedCount +
              report.errorsCount +
              report.skippedCount,
        failures:
          typeof report.failedCount === "number" ? report.failedCount : 0,
        errors: typeof report.errorsCount === "number" ? report.errorsCount : 0,
        skipped:
          typeof report.skippedCount === "number" ? report.skippedCount : 0,
        passed:
          typeof report.passedCount === "number"
            ? report.passedCount
            : typeof report.testsCount === "number"
              ? report.testsCount -
                (report.failedCount || 0) -
                (report.errorsCount || 0) -
                (report.skippedCount || 0)
              : undefined,
      };
    }
  } catch (error) {
    return null;
  }
  return null;
}

function assert(condition, message) {
  if (condition) {
    console.log(`passed - ${message}`);
    return true;
  }
  console.log(`failed - ${message}`);
  return false;
}

function run() {
  let score = 0;
  let checks = 0;

  console.log("Test 0: Checking if Nightwatch report files were generated");
  checks += 1;
  const xmlReport = findReportFile(".xml");
  const jsonReport = findReportFile(".json");
  const reportGenerated = Boolean(xmlReport || jsonReport);
  if (assert(reportGenerated, "report files exist in ./report/")) score += 1;

  console.log("Test 1: Checking if Nightwatch config launch_url is configured");
  checks += 1;
  const launchUrl = config.test_settings?.default?.launch_url;
  const launchUrlValid =
    typeof launchUrl === "string" && launchUrl.startsWith("http://localhost");
  if (assert(launchUrlValid, `launch_url is set to ${launchUrl}`)) score += 1;

  console.log("Test 2: Checking if app page contains Manage Products heading");
  checks += 1;
  const htmlPath = path.join(__dirname, "app", "index.html");
  const htmlContent = fs.existsSync(htmlPath)
    ? fs.readFileSync(htmlPath, "utf8")
    : "";
  if (
    assert(
      htmlContent.includes("Manage Products"),
      "app/index.html contains Manage Products",
    )
  )
    score += 1;

  console.log(
    "Test 3: Checking if test file validates product table selectors",
  );
  checks += 1;
  const testPath = path.join(__dirname, "test", "App.test.js");
  const testContent = fs.existsSync(testPath)
    ? fs.readFileSync(testPath, "utf8")
    : "";
  const selectorsPresent = [
    "nav",
    "#mps-ordered > table > tbody > tr:nth-child(1) > td:nth-child(1)",
    "#mps-dispatched > table > tbody > tr:nth-child(1) > td:nth-child(1)",
    "#mps-outfordelivery > table > tbody > tr:nth-child(1) > td:nth-child(1)",
  ].every((selector) => testContent.includes(selector));
  if (
    assert(selectorsPresent, "App.test.js contains expected product selectors")
  )
    score += 1;

  console.log("Test 4: Checking whether the report shows all tests passing");
  checks += 1;
  let reportSuccess = false;

  if (xmlReport) {
    const xmlText = fs.readFileSync(path.join(reportDir, xmlReport), "utf8");
    const parsed = parseXmlReport(xmlText);
    if (parsed) {
      reportSuccess =
        parsed.tests > 0 && parsed.failures === 0 && parsed.errors === 0;
      assert(
        reportSuccess,
        `${xmlReport} reports ${parsed.tests} tests, ${parsed.failures} failures, ${parsed.errors} errors`,
      );
    }
  }

  if (!reportSuccess && jsonReport) {
    const jsonText = fs.readFileSync(path.join(reportDir, jsonReport), "utf8");
    const parsed = parseJsonReport(jsonText);
    if (parsed) {
      reportSuccess =
        parsed.tests > 0 && parsed.failures === 0 && parsed.errors === 0;
      assert(
        reportSuccess,
        `${jsonReport} reports ${parsed.tests} tests, ${parsed.failures} failures, ${parsed.errors} errors`,
      );
    }
  }

  if (reportSuccess) score += 1;

  console.log(`\nSummary: ${score}/${checks} checks passed`);
  process.exit(score === checks ? 0 : 1);
}

run();
