from flask import render_template, request
from __init__ import app
import requests

@app.errorhandler(404)  # catch for URL not found
def page_not_found(e):
    # note that we set the 404 status explicitly
    return render_template('404.html'), 404

@app.route('/')  # connects default URL to index() function
def index():
    return render_template("index.html")

if __name__ == "__main__":
    app.run(debug=True, port=8081)