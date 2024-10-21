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
from app.models import Notification
from app.services.database import db_session
from app.utils.logger import app_logger
from datetime import datetime

def create_notification(user_id, message):
    app_logger.info(f'Creating notification for user {user_id}')
    try:
        notification = Notification(user_id=user_id, message=message, created_at=datetime.utcnow())
        db_session.add(notification)
        db_session.commit()
        app_logger.info(f'Notification created successfully: {notification.id}')
        return notification
    except Exception as e:
        app_logger.error(f'Error creating notification: {str(e)}')
        db_session.rollback()
        raise

def get_notifications(user_id):
    app_logger.info(f'Fetching notifications for user {user_id}')
    try:
        notifications = Notification.query.filter_by(user_id=user_id).all()
        app_logger.info(f'Retrieved {len(notifications)} notifications for user {user_id}')
        return notifications
    except Exception as e:
        app_logger.error(f'Error fetching notifications: {str(e)}')
        raise