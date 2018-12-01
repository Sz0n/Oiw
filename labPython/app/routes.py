from app import app
from flask import render_template, url_for, redirect, flash
from app.models import Post
from app import db
from werkzeug.urls import url_parse
from app.forms import PostForm
from flask import request
from flask_login import current_user, login_user
from app.models import User
from flask_login import logout_user
from app.forms import LoginForm
from app.forms import RegistrationForm

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

@app.route('/login', methods=['GET', 'POST'])
def login():
    if current_user.is_authenticated:
        return redirect(url_for('index'))
    form = LoginForm()
    if form.validate_on_submit():
        user = User.query.filter_by(username=form.username.data).first()
        if user is None or not user.check_password(form.password.data):
            flash('Invalid username or password')
            return redirect(url_for('login'))
        login_user(user, remember=form.remember_me.data)
        return redirect(url_for('index'))
    return render_template('login.html', title='Sign In', form=form)

@app.route('/logout')
def logout():
    logout_user()
    return redirect(url_for('index'))    

@app.route('/register', methods=['GET', 'POST'])
def register():
    if current_user.is_authenticated:
        return redirect(url_for('index'))
    form = RegistrationForm()
    if form.validate_on_submit():
        user = User(username=form.username.data, email=form.email.data)
        user.set_password(form.password.data)
        db.session.add(user)
        db.session.commit()
        flash('Registered')
        return redirect(url_for('login'))
    return render_template('register.html', title='Register', form=form)