from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField
from wtforms.widgets import TextArea

class PostForm(FlaskForm):
	title = StringField('Title')
	content = StringField('Content', widget=TextArea())
	submit = SubmitField('Add')