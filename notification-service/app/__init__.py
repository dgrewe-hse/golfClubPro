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
from flask import Flask
from app.services.database import db_session, init_db
from app.utils.logger import app_logger

def create_app():
    app = Flask(__name__)
    
    app_logger.info('Creating application instance')
    
    with app.app_context():
        app_logger.info('Initializing database')
        init_db()
    
    from app.api import routes
    app.register_blueprint(routes.bp)
    app_logger.info('Registered API routes')

    @app.teardown_appcontext
    def shutdown_session(exception=None):
        db_session.remove()

    app_logger.info('Application instance created')
    return app