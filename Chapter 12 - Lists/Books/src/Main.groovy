
def books = []

def book1 = new Book(title: "The Curious Gardener", author: "Pavord, Anna", isbn: "1408810069")	
def book2 = new Book(title: "Studying Shakespeare's Contemporaries", author: "Engle, Lars", isbn: "1405132442")
def book3 = new Book(title: "Whatever Makes You Happy", author: "Sutcliffe, William", isbn: "0747596522")
def book4 = new Book(title: "When Changing a Lightbulb Just Isn't Enough", author: "Anderson, Emily", isbn: "1588167488")
def book5 = new Book(title: "Get Fit While You Sit: Easy Workouts from Your Chair", author: "Torkelson, Charlene", isbn:"0897932536")
def book6 = new Book(title: "Paradise Postponed", author: "Mortimer, John", isbn: "0141193395")
def book7 = new Book(title: "The Sport of Olympic-Style Weightlifting", author: "Miller, Carl", isbn: "0865348111")
def book8 = new Book(title: "The Rolex Story", author: "Heel, Franz-Christoph", isbn: "0764345974")
def book9 = new Book(title: "The Night Circus", author: "Morgenstern, Erin", isbn: "0099554798")
def book10 = new Book(title: "Management of Hospitality Operation", author: "Lockwood, Andrew", isbn: "1844806928")

books << book1 << book2 << book3 << book4 << book5 << book6 << book7 << book8 << book9 << book10

//edit our list of books to keep only those with the word "The" in the title
books.retainAll {it.title.contains("The")}


//edit our list of books to remove any by authors with names beginning with M
books.removeAll {it.author[0] == "M"}


println "There are ${books.size()} books left:"
books.each {println it}