#from __future__ import with_statement # needed for python 2.5
from fabric.api import *

# globals
env.project_name = 'FirstBlog'
env.use_photologue = False # django-photologue gallery module

# environments

def localhost():
    #"Use the local virtual server"
    env.hosts = ['localhost']
    env.user = 'vagrant'
    env.password = 'vagrant'
    env.path = '/home/%(user)s/project/MM/%(project_name)s' % env
    env.virtualhost_path = env.path
    local('echo --Localhost Method--')
    
# tasks
#@task
def test():
    local('echo --Test Method--')
@task
def setup():
    local('echo --Setup Method--')


def deploy():
    local('echo --Deploy Method--')
    