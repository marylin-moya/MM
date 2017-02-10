# MM - Blog Web site

##Requeriments
Blog Web site requires to have installed the the following tools:

* sudo apt-get -y update -q
* sudo apt-get -y install python-pip -q
* sudo apt-get -y install python-dev -q
* sudo apt-get -y install python-django -q
* sudo debconf-set-selections <<< 'mysql-server mysql-server/root_password password mysql@123'
* sudo debconf-set-selections <<< 'mysql-server mysql-server/root_password_again password mysql@123'
* sudo apt-get -y install mysql-server -q
* sudo apt-get -y install python-mysqldb -q

##Steps to have Blog Web Site running
Follow below steps to have running the site

1. Copy [MM] project folder
2. Create a MySQL database
	* mysql -u root -p 
	* CREATE DATABASE firstblog;
	* quit
3. Run the following command to have the Blog Web site running
	* Sync the Database:
		python MM/manage.py syncdb
	* Add your IP machine in settings.py like the following:
		ALLOWED_HOSTS = ['192.168.33.100']
	* Start Django with the IP configured on settings.py
		python MM/manage.py runserver 192.168.33.100:8000
4. Open Blog Web site running
	http://192.168.33.100:8000/