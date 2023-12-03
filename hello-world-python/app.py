from flask import Flask, jsonify
import mysql.connector
import os

app = Flask(__name__)

# MySQL Database Configuration
db_config = {
    'host': os.environ.get('MYSQL_HOST', 'localhost'),
    'user': os.environ.get('MYSQL_USER', 'root'),
    'password': os.environ.get('MYSQL_PASSWORD', 'root'),
    'database': os.environ.get('MYSQL_DATABASE', 'simpledb'),
    'port': int(os.environ.get('MYSQL_PORT', 3306)),
}

# MySQL Connection
db_connection = mysql.connector.connect(**db_config)
cursor = db_connection.cursor()

# API endpoint to execute a sample query
@app.route('/', methods=['GET'])
def execute_query():
    try:
        # Sample MySQL query
        query = "SELECT * FROM book;"
        cursor.execute(query)
        results = cursor.fetchall()
        result_list = []
        for row in results:
            result_list.append({'id': row[0], 'name': row[1]})


        return jsonify(result_list)

    except Exception as e:
        return jsonify({'error': str(e)})

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=80)