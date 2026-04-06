# Webdesign - Manage Product Status

A simple product status web app with Nightwatch end-to-end automation.

## What this project includes

- A static product page under `app/index.html`
- Styling in `app/css/index.css`
- Tab-based product state navigation for Ordered, Dispatched, and Out For Delivery
- Nightwatch tests in `test/App.test.js`
- Local server implementation in `server.js`
- Nightwatch runner helper in `runPlayground.js`
- Result report output in `report/`
- A scoring helper in `nightwatch-user-scorer.js`

## Prerequisites

- Node.js installed on your machine
- Chrome available for Nightwatch to launch via Chromedriver

## Setup

From the project root:

```bash
cd "c:\T12 automation\Projects\Webdesign"
npm install
```

## Run the app locally

Start the static app server:

```bash
npm start
```

Then open the browser at:

```text
http://localhost:8000
```

If port `8000` is already in use, the server will automatically find the next available port.

## Run Nightwatch tests

This starts the local server and executes the Nightwatch test suite:

```bash
npm test
```

If you want to start the app server and run Nightwatch explicitly with the same helper, you can also run:

```bash
npm run playground
```

## Score the test results

After the Nightwatch run completes, use the scorer helper to validate the generated report and page configuration:

```bash
npm run score
```

This verifies:

- report files were generated in `report/`
- the launch URL is configured
- `app/index.html` contains the product page heading
- the test file uses the expected product selectors
- the report shows no failures or errors

## File structure

- `app/` - product page HTML, CSS, and JS
- `test/` - Nightwatch automation test file
- `report/` - test output artifacts
- `nightwatch.conf.js` - Nightwatch configuration
- `server.js` - local static server
- `runPlayground.js` - start server then run Nightwatch
- `nightwatch-user-scorer.js` - validate test/report quality

## Shell helpers

- `install.sh` - installs project dependencies
- `run.sh` - starts the local web server
- `test.sh` - runs the Nightwatch tests
