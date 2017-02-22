from __future__ import with_statement # needed for python 2.5
from fabric.api import *
import os

# globals
env.project_name = 'FirstBlog'
env.use_photologue = False # django-photologue gallery module
env.projectContainer = os.environ['CONTAINER']
print("CONTAINER " + env.projectContainer)
# environments

def localhost():
    #"Use the local virtual server"
    env.hosts = ['localhost']
    env.user = 'vagrant'
    env.password = 'vagrant'
    env.path = '/home/%(user)s/project/' + env.projectContainer + '/%(project_name)s' % env
    env.virtualhost_path = env.path
    local('echo --Localhost Method--')

# tasks
@task
def setup():
    local('echo --Starting Compile Task--')
    local('python -m compileall .')
    local('ls')
    local('echo --Create a new directory with compiled files--')
    local('rsync -av --exclude=*.py ../' + env.projectContainer + ' MM_compiled')

@task
def test():
    local('echo ---Starting Unit Test---')
    local('pwd')
    local('ls')
    local('echo updated')
    local('python manage.py test blog.UnitTestCases.getPostObject')
    #local('python manage.py test')

@task
def package():
    local('echo --Create Package--')
    local('ls')
    local('tar -czvf mm_blog.tar.gz MM_compiled')
    local('ls ..')
    