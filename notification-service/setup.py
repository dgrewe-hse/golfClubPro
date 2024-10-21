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

from setuptools import setup, find_packages

setup(
    name='golfClubPro-notification_service',
    version='0.1',
    description='Notification service for GolfClubPro Application',
    author='Dennis Grewe',
    author_email='dennis.grewe@hs-esslingen.com',
    packages=find_packages(),
    install_requires=[
        'Flask',
        'SQLAlchemy',
        'pydantic',
        'pytest',
        # Add other dependencies
    ],
    entry_points={
        'console_scripts': [
            'run-notification-service=run:main',
        ],
    },
)