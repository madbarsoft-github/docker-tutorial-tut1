# Use a base image with Python
FROM python:3.8-slim

# Set the working directory inside the container
WORKDIR /app

# Install Flask and mysql-connector-python
RUN pip install --no-cache-dir Flask mysql-connector-python


COPY app.py /app/

EXPOSE 80

CMD ["python", "app.py"]