from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField


class PostForm(FlaskForm):
	title = StringField('Title')
	content = StringField('Content')
	submit = SubmitField('Add')