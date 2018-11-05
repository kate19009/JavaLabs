import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<T> implements Iterable<T>
{
	private Node<T> first;

	public void add(T data)
	{
		Node<T> node = new Node<>();
		node.data = data;
		node.next = first;
		first = node;
	}

	@Override
	public String toString()
	{
		String s = "[";
		Node temp = first;
		while (temp != null)
		{
			s += temp.data;
			s += ", ";
			temp = temp.next;
		}
		return s + "]";
	}

	@Override
	public Iterator<T> iterator()
	{
		Iterator<T> it = new Iterator<T>()
		{
			Node<T> first = MyList.this.first;
			@Override
			public T next() throws NoSuchElementException
			{
				if (!hasNext())
				{
					throw new NoSuchElementException();
				}
				else
				{
					Node<T> temp = first;
					first = first.next;
					return temp.data;
				}
			}

			@Override
			public boolean hasNext()
			{
				return !(first == null);
			}
		};
		return it;
	}

	public static class StaticIterator<T> implements Iterator<T>
	{
		Node<T> first;
		public StaticIterator(MyList<T> myList)
		{
			first = myList.first;
		}

		@Override
		public T next() throws NoSuchElementException
		{
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			else
			{
				Node<T> temp = first;
				first = first.next;
				return temp.data;
			}
		}
		@Override
		public boolean hasNext()
		{
			return !(first == null);
		}
	}

	public class InnerIterator implements Iterator<T>
	{
		Node<T> first = MyList.this.first;
		@Override
		public T next() throws NoSuchElementException
		{
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			else
			{
				Node<T> temp = first;
				first = first.next;
				return temp.data;
			}
		}
		@Override
		public boolean hasNext()
		{
			return !(first == null);
		}
	}
}