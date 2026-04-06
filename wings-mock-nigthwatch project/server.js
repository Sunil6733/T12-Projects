const http = require("http");
const fs = require("fs");
const path = require("path");

const publicFolder = path.join(__dirname, "app");

function getContentType(filePath) {
  const ext = path.extname(filePath).toLowerCase();
  switch (ext) {
    case ".html":
      return "text/html";
    case ".css":
      return "text/css";
    case ".js":
      return "application/javascript";
    default:
      return "application/octet-stream";
  }
}

function createServer() {
  return http.createServer((req, res) => {
    const urlPath = req.url === "/" ? "/index.html" : req.url;
    const safePath = path.normalize(urlPath).replace(/^\.+/, "");
    const filePath = path.join(publicFolder, safePath.split("?")[0]);

    if (fs.existsSync(filePath) && fs.statSync(filePath).isFile()) {
      res.writeHead(200, { "Content-Type": getContentType(filePath) });
      res.end(fs.readFileSync(filePath));
      return;
    }

    res.writeHead(404, { "Content-Type": "text/plain" });
    res.end("Not found");
  });
}

function startServer() {
  const startPort = Number(process.env.PORT) || 8000;
  const maxAttempts = 10;

  return new Promise((resolve, reject) => {
    let port = startPort;

    function tryStart() {
      const server = createServer();

      server.on("error", (error) => {
        if (error.code === "EADDRINUSE" && port < startPort + maxAttempts - 1) {
          port += 1;
          tryStart();
          return;
        }

        reject(error);
      });

      server.listen(port, () => {
        console.log(`Webdesign server running on http://localhost:${port}`);
        resolve({ server, port });
      });
    }

    tryStart();
  });
}

module.exports = { startServer };
