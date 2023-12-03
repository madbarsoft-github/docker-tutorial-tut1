const express = require('express');
const axios = require('axios');

const app = express();
const port = process.env.NODE_APP_PORT || 3000;
const appHost = process.env.APP_HOST || 'localhost';
const appPort = process.env.APP_PORT || 80;

app.get('/', async (req, res) => {
  try {
    // Make a GET request to the /query API of the Python app
    const response = await axios.get(`http://${appHost}:${appPort}/book`);

    // Extract the data from the response
    const data = response.data;

    // Render an HTML page with a table for the book data
    res.send(`
      <html>
        <head>
          <title>My Book Library</title>
        </head>
        <body bgcolor="#87CEEB">
          <h1>Book Data</h1>
          <table border="1">
            <thead>
              <tr>
                <th>ID</th>
                <th>Title</th>
              </tr>
            </thead>
            <tbody>
              ${data.map(book => `
                <tr>
                  <td>${book.id}</td>
                  <td>${book.name}</td>
                </tr>
              `).join('')}
            </tbody>
          </table>
        </body>
      </html>
    `);
  } catch (error) {
    console.error('Error fetching data:', error.message);
    res.status(500).send('Internal Server Error');
  }
});

app.listen(port, () => {
  console.log(`Node.js app listening at http://localhost:${port}`);
});
