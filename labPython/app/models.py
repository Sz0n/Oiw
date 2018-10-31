from app import db

class Post(db.Model):
	id = db.Column(db.Integer, primary_key=True)
	title = db.Column(db.String(40), index=True)
	content = db.Column(db.String(255))

	def __repr__(self):
		return '<Post {}>'.format(self.content)