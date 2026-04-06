module.exports = {
  src_folders: ["test"],
  output_folder: "report",
  webdriver: {
    start_process: true,
    server_path:
      require.resolve("chromedriver/lib/chromedriver/chromedriver.exe"),
  },
  test_settings: {
    default: {
      launch_url: process.env.LAUNCH_URL || "http://localhost:8000",
      desiredCapabilities: {
        browserName: "chrome",
        chromeOptions: {
          args: [
            "--headless=new",
            "--no-sandbox",
            "--disable-dev-shm-usage",
            "--window-size=1280,1024",
          ],
        },
      },
    },
  },
};
