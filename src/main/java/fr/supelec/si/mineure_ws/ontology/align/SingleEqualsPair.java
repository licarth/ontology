package fr.supelec.si.mineure_ws.ontology.align;

public class SingleEqualsPair<T> {

	private T left;
	private T right;
	
	public SingleEqualsPair(T left, T right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SingleEqualsPair)) return false;
		else {
			SingleEqualsPair<T> o = (SingleEqualsPair<T>) obj;
			return (o.left.equals(this.left) || o.left.equals(this.right) || o.right.equals(this.left) || o.right.equals(this.right));
		}
	}

	public T getLeft() {
		return left;
	}

	public void setLeft(T left) {
		this.left = left;
	}

	public T getRight() {
		return right;
	}

	public void setRight(T right) {
		this.right = right;
	}


}
