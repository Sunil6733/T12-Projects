const http = require("http");
const fs = require("fs");
const path = require("path");
const url = require("url");

const PORT = process.env.PORT || 8000;
const publicDir = path.join(__dirname, "public");

const server = http.createServer((req, res) => {
  const urlParts = url.parse(req.url, true);
  let filePath = path.join(
    publicDir,
    urlParts.pathname === "/" ? "index.html" : urlParts.pathname,
  );

  // Prevent directory traversal
  if (!filePath.startsWith(publicDir)) {
    res.writeHead(403, { "Content-Type": "text/plain" });
    res.end("Forbidden");
    return;
  }

  // Default to index.html if directory requested
  if (fs.existsSync(filePath) && fs.statSync(filePath).isDirectory()) {
    filePath = path.join(filePath, "index.html");
  }

  // Serve the file
  fs.readFile(filePath, (err, content) => {
    if (err) {
      if (err.code === "ENOENT") {
        res.writeHead(404, { "Content-Type": "text/html" });
        res.end("<h1>404 - File Not Found</h1>", "utf-8");
      } else {
        res.writeHead(500, { "Content-Type": "text/plain" });
        res.end("Server Error", "utf-8");
      }
      return;
    }

    // Set content type
    const ext = path.extname(filePath).toLowerCase();
    let contentType = "text/plain";
    switch (ext) {
      case ".html":
        contentType = "text/html";
        break;
      case ".css":
        contentType = "text/css";
        break;
      case ".js":
        contentType = "application/javascript";
        break;
      case ".json":
        contentType = "application/json";
        break;
      case ".png":
        contentType = "image/png";
        break;
      case ".jpg":
        contentType = "image/jpeg";
        break;
    }

    res.writeHead(200, { "Content-Type": contentType });
    res.end(content);
  });
});

server.listen(PORT, () => {
  console.log(
    `✓ Flight Booking Application Server running on http://localhost:${PORT}`,
  );
});

server.on("error", (error) => {
  console.error("Server error:", error);
  process.exit(1);
});
