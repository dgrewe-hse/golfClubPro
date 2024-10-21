# Use an official Python runtime as the parent image
FROM python:3.9-slim

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install any needed packages specified in requirements.txt
RUN pip install --no-cache-dir --upgrade pip && \
    pip install --no-cache-dir -r requirements.txt && \
    mkdir -p /app/app/services && \
    mkdir -p /app/logs && \
    chmod 777 /app/app/services /app/logs

# Make port 8082 available to the world outside this container
EXPOSE 8082

# Define environment variable
ENV FLASK_APP=run.py
ENV PYTHONPATH=/app

# Run app.py when the container launches
CMD ["python", "run.py"]