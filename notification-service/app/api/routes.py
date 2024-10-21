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
from flask import Blueprint, jsonify, request
from app.services.notification_service import create_notification, get_notifications
from app.utils.logger import app_logger

bp = Blueprint('api', __name__)

@bp.route('/notifications', methods=['POST'])
def add_notification():
    app_logger.info('Received request to add notification')
    data = request.json
    try:
        notification = create_notification(data['user_id'], data['message'])
        app_logger.info(f'Notification added successfully: {notification.id}')
        return jsonify({"id": notification.id, "message": "Notification created"}), 201
    except Exception as e:
        app_logger.error(f'Error adding notification: {str(e)}')
        return jsonify({"error": "Failed to create notification"}), 500

@bp.route('/notifications/<int:user_id>', methods=['GET'])
def list_notifications(user_id):
    app_logger.info(f'Received request to list notifications for user {user_id}')
    try:
        notifications = get_notifications(user_id)
        app_logger.info(f'Retrieved {len(notifications)} notifications for user {user_id}')
        return jsonify([{"id": n.id, "message": n.message} for n in notifications])
    except Exception as e:
        app_logger.error(f'Error listing notifications: {str(e)}')
        return jsonify({"error": "Failed to retrieve notifications"}), 500