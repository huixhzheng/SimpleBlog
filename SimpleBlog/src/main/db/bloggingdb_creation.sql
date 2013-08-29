drop table tag_blog_reference;
drop table tags;
drop table comments;
drop table blog_entries;
drop table favourite_reads;

create table blog_entries (
	id INT NOT NULL AUTO_INCREMENT,
	title varchar(100) NOT NULL,
	content mediumtext NOT NULL,
	author varchar(100) NOT NULL,
	author_contact varchar(100),
	publish_date date NOT NULL,
	
	PRIMARY KEY(id)	
);

create table tags (

	id INT NOT NULL AUTO_INCREMENT,
	text varchar(50) NOT NULL,
	
	PRIMARY KEY(id)
);
	
create table comments(
	id INT NOT NULL AUTO_INCREMENT,
	comment varchar(255) NOT NULL,
	commenter_name varchar(100) NOT NULL,
	commenter_email varchar(100),
	post_date date NOT NULL,
	parent_blog_id INT,
	PRIMARY KEY (id)
);


create table tag_blog_reference (
	id INT NOT NULL AUTO_INCREMENT,
	tags_id INT,
	blog_id INT,
	
	PRIMARY KEY(id)
);

create table favourite_reads (
	id INT NOT NULL AUTO_INCREMENT,
	text varchar(200) NOT NULL,
	web_link varchar(500) NOT NULL,
	
	PRIMARY KEY (id)
);

ALTER TABLE comments ADD FOREIGN KEY (parent_blog_id) REFERENCES blog_entries(id) ON DELETE CASCADE;
ALTER TABLE tag_blog_reference ADD FOREIGN KEY(tags_id) REFERENCES tags(id) ON DELETE CASCADE;
ALTER TABLE tag_blog_reference ADD FOREIGN KEY(blog_id) REFERENCES blog_entries(id) ON DELETE CASCADE;



