const { spawn } = require("child_process");
const { startServer } = require("./server");

const nightwatchCli = require.resolve("nightwatch/bin/nightwatch");
const args = [nightwatchCli, "--config", "nightwatch.conf.js"];

startServer()
  .then(({ server, port }) => {
    const launchUrl = process.env.LAUNCH_URL || `http://localhost:${port}`;
    process.env.LAUNCH_URL = launchUrl;

    const runner = spawn(process.execPath, args, { stdio: "inherit" });

    runner.on("exit", (code) => {
      server.close(() => process.exit(code));
    });

    process.on("SIGINT", () => {
      runner.kill("SIGINT");
      server.close(() => process.exit(0));
    });
  })
  .catch((error) => {
    console.error(`Failed to start server: ${error.message}`);
    process.exit(1);
  });
