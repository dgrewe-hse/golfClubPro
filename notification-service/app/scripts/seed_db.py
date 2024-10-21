# Copyright (c) 2024. All rights reserved.
# DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
#
# This code is free software; you can redistribute it and/or modify it
#nder the terms of the GNU General Public License version 3 only, as
# published by the Free Software Foundation.  
#
# This code is distributed for educational purposes only, but WITHOUT
# ANY WARRANTY; See the GNU General Public License version 3 for more 
# details (a copy is included in the LICENSE file that
# accompanied this code).
from app.services.database import db_session
from app.models.user import User
from app.models.notification import Notification
from datetime import datetime

def seed_database():
    # Create some users
    user1 = User(username="john_doe", email="john@example.com")
    user2 = User(username="jane_doe", email="jane@example.com")
    db_session.add_all([user1, user2])
    db_session.commit()

    # Create some notifications
    notification1 = Notification(message="Welcome to the service!", user_id=user1.id, created_at=datetime.utcnow())
    notification2 = Notification(message="You have a new message.", user_id=user2.id, created_at=datetime.utcnow())
    db_session.add_all([notification1, notification2])
    db_session.commit()

    print("Database seeded with initial data.")

if __name__ == '__main__':
    seed_database()