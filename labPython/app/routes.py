from app import app
from flask import render_template, url_for, redirect, flash
from app.models import Post
from app import db
from werkzeug.urls import url_parse
from app.forms import PostForm
from flask import request

@app.route('/')
@app.route('/index')
def index():
	posts = Post.query.all()
	return render_template('index.html', title="ORM", posts=posts)


@app.route('/add_post', methods=['GET', 'POST'])
def add_post():
	form = PostForm()

	if request.method == 'POST':
		post_to_add = Post(title=form.title.data, content=form.content.data)
		db.session.add(post_to_add)
		db.session.commit()
		flash("Dodano post")
		return redirect(url_for('index'))



	return render_template('add_post.html', title='Add Post', form=form)
