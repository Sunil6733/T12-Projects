module.exports = {
  "Manage Product Status": function (browser) {
    const baseUrl = browser.launchUrl || "http://localhost:8000";

    browser
      .url(baseUrl)
      .waitForElementVisible("body", 2000)
      .assert.containsText("nav", "Manage Products")
      .assert.containsText(
        "#mps-ordered > table > tbody > tr:nth-child(1) > td:nth-child(1)",
        "#productid1",
      )
      .click("#dispatched-tab")
      .waitForElementVisible("#mps-dispatched", 1000)
      .assert.containsText(
        "#mps-dispatched > table > tbody > tr:nth-child(1) > td:nth-child(1)",
        "#productid4",
      )
      .click("#outfordelivery-tab")
      .waitForElementVisible("#mps-outfordelivery", 1000)
      .assert.containsText(
        "#mps-outfordelivery > table > tbody > tr:nth-child(1) > td:nth-child(1)",
        "#productid7",
      )
      .end();
  },
};
