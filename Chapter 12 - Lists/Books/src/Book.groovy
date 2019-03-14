
class Book {
	def title
	def author
	def isbn
	
	@Override
	String toString() {
		"$title : $author"
	}
	
}