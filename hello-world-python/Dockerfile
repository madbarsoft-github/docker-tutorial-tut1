# Dockerfile
FROM python:3.8-slim

WORKDIR /app

# Install Flask directly without using requirements.txt
RUN pip install Flask==2.0.1 Werkzeug==2.0.1

COPY . .

CMD ["python", "app.py"]