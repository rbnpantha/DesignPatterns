package edu.asd.iteratordesignpattern;

class IteratorPattern {

	public static void main(String[] args) {
		BooksCollection books = new BooksCollection();
		IIterator iterator = books.createIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}

interface IContainer {

	public IIterator createIterator();

}

interface IIterator {

	public boolean hasNext();

	public Object next();

}

class BooksCollection implements IContainer {

	private String titles[] = { "Design Patterns", "1", "2", "3", "4" };

	public IIterator createIterator() {
		return new BookIterator();
	}

	private class BookIterator implements IIterator {
		private int position = 0;

		public boolean hasNext() {
			return (position < titles.length);
		}

		public Object next() {
			if (this.hasNext()) {
				return titles[position++];
			} else {
				return null;
			}
		}
	}

}
