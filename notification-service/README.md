# GolfClubPro Notification Service

This Python service is designed to notify golf club members about upcoming tournaments. It retrieves tournament data from a MySQL database and sends email notifications using Flask-Mail.

## Project Structure

    notification-service/
    │
    ├── app/
    │   ├── __init__.py                 # Initialize Flask app
    │   ├── models/
    │   │   ├── __init__.py             # Import all models
    │   │   ├── notification.py         # Notification model
    │   │   └── user.py                 # User model (if needed)
    │   ├── api/
    │   │   ├── __init__.py             # API package initializer
    │   │   ├── routes.py               # API endpoints
    │   │   └── schemas.py              # Pydantic schemas for request/response
    │   ├── services/
    │   │   ├── __init__.py             # Services package initializer
    │   │   ├── database.py             # Database connection and session management
    │   │   └── notification_service.py # Business logic for notifications
    │   ├── utils/
    │   │   ├── __init__.py             # Utils package initializer
    │   │   └── logger.py               # Logging configuration
    │   └── config.py                   # Configuration settings
    │
    ├── scripts/
    │   ├── init_db.py                  # Initialize the database
    │   └── seed_db.py                  # Seed the database with initial data
    │
    ├── tests/
    │   ├── __init__.py                 # Test package initializer
    │   ├── TODO                        # TODO list
    │
    ├── .env.test                       # Environment variables
    ├── .gitignore                      # Specifies intentionally untracked files to ignore
    ├── README.md                       # Project documentation
    ├── requirements.txt                # Project dependencies
    ├── setup.py                        # Package and distribution management
    ├── Dockerfile                      # Instructions for Docker image creation
    └── run.py                          # Entry point to run the application

## Setup and Installation

### Prerequisites

- Python 3.8 or higher
- Mail server configuration (e.g., Gmail)
- see [golfClubPro Prerequisits](../README.md)

2. Set up a virtual environment:
   ```
   python -m venv venv
   source venv/bin/activate  # On Windows use `venv\Scripts\activate`
   ```

3. Install dependencies:
   ```
   pip install -r requirements.txt
   ```

4. Set up the database:
   ```
   python scripts/init_db.py
   python scripts/seed_db.py
   ```

5. Run the application:
   ```
   python run.py
   ```

## Running Tests

To run tests, use the following command:

```
pytest
```

## Build Docker container

```bash
$ docker build -t golfclubpro-notification-service .
$ docker run -p 8082:8082 notification-service
```

