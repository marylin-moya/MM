from django.test import TestCase
from blog.models import posts
#import xmlrunner
#import unittest
# Create your tests here.

class UnitTestCases(TestCase):
    def setUp(self):
        posts.objects.create(author="Bob",title="Hello World",bodytext="Lorem Ipsum",timestamp="2017-2-12 16:30")
   
    
    def getPostFromDB(self):
        entries = posts.objects.filter(author="Bob")
        #entry = posts.objects.all()[:10]
        #entries = posts.objects.raw('SELECT author, title, bodytext FROM blog_posts')
        #print(entry.count())
        print('***************')
        #for entry in entries:
        print('----------------'+entries[0].author)
            
        self.assertEqual("Bob", entries[0].author)
        self.assertEqual("Hello World", entries[0].title)
        self.assertEqual("Lorem Ipsum", entries[0].bodytext)