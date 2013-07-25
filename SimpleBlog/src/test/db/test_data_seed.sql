insert into blog_entries (title,content,author,author_contact,publish_date) 
	values('My first blog entry',
	'This is my first blog entry, only a few words, no tags',
	'Matt Duell','mkduell@gmail.com',
	STR_TO_DATE('15-07-2013','%d-%m-%Y'));


insert into blog_entries (title,content,author,author_contact,publish_date) 
	values('My SECOND blog entry',
	'This is my SECOND blog entry, only a few words, no tags',
	'Matt Duell','mkduell@gmail.com',
	STR_TO_DATE('15-07-2013','%d-%m-%Y'));
	
	insert into blog_entries (title,content,author,author_contact,publish_date) 
	values('My THIRD blog entry',
	'This is my third blog entry, going to be a long one! bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla ',
	'Matt Duell','mkduell@gmail.com',
	STR_TO_DATE('15-07-2013','%d-%m-%Y'));

insert into blog_entries (title,content,author,author_contact,publish_date) 
	values('My FOURTH blog entry',
	'This is my FOURTH blog entry, only a few words, no tags',
	'Matt Duell','mkduell@gmail.com',
	STR_TO_DATE('15-07-2013','%d-%m-%Y'));
	
	insert into blog_entries (title,content,author,author_contact,publish_date) 
	values('My FIFTH blog entry',
	'This is my FIFTH blog entry, only a few words, no tags',
	'Matt Duell','mkduell@gmail.com',
	STR_TO_DATE('15-07-2013','%d-%m-%Y'));
	
	insert into blog_entries (title,content,author,author_contact,publish_date) 
	values('My SIXTH blog entry',
	'This is my SIXTH blog entry, only a few words, no tags',
	'Matt Duell','mkduell@gmail.com',
	STR_TO_DATE('15-07-2013','%d-%m-%Y'));
	
	insert into blog_entries (title,content,author,author_contact,publish_date) 
	values('My SEVENTH blog entry',
	'This is my SEVENTH blog entry, only a few words, no tags',
	'Matt Duell','mkduell@gmail.com',
	STR_TO_DATE('15-07-2013','%d-%m-%Y'));
	
	insert into blog_entries (title,content,author,author_contact,publish_date) 
	values('My EIGHTH blog entry',
	'This is my EIGHTH blog entry, only a few words, no tags',
	'Matt Duell','mkduell@gmail.com',
	STR_TO_DATE('15-07-2013','%d-%m-%Y'));

	insert into blog_entries (title,content,author,author_contact,publish_date) 
	values('My NINTH blog entry',
	'This is my NINTH blog entry, only a few words, no tags',
	'Matt Duell','mkduell@gmail.com',
	STR_TO_DATE('15-07-2013','%d-%m-%Y'));
	
	insert into blog_entries (title,content,author,author_contact,publish_date) 
	values('My TENTH blog entry',
	'This is my TENTH blog entry, only a few words, no tags',
	'Matt Duell','mkduell@gmail.com',
	STR_TO_DATE('15-07-2013','%d-%m-%Y'));
	
insert into comments (comment,commenter_name,commenter_email,parent_blog_id,post_date) 
	values('cool blogz yo',
	'blog commenter 1',
	'mkduell@gmail.com',
	1,
	STR_TO_DATE('15-07-2013','%d-%m-%Y'));
	
	
	insert into comments (comment,commenter_name,commenter_email,parent_blog_id,post_date) 
	values ('I like kitties','the kitty','mkduell@gmail.com',1,STR_TO_DATE('15-07-2013','%d-%m-%Y'));
	
	insert into comments (comment,commenter_name,commenter_email,parent_blog_id,post_date) 
	values ('om nom nom','george','mkduell@gmail.com',1,STR_TO_DATE('15-07-2013','%d-%m-%Y'));
	insert into comments (comment,commenter_name,commenter_email,parent_blog_id,post_date) 
	
	values ('poop','poopy mc poopies','mkduell@gmail.com',1,STR_TO_DATE('15-07-2013','%d-%m-%Y'));
	
insert into tags (text) values('java');
insert into tags (text) values('mvc');
insert into tags (text) values('coffee');
insert into tags (text) values('blogs');
insert into tags (text) values('spring');
insert into tags (text) values('hibernate');

insert into tag_blog_reference(tags_id,blog_id) values(1,1),(2,1),(4,1),(3,2),(1,2),(6,1),(6,2);

