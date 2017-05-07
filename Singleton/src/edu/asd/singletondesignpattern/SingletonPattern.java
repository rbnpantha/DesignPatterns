package edu.asd.singletondesignpattern;

public class SingletonPattern {
	public static void main(String[] args) {
		BillPlughSingleton bps = BillPlughSingleton.getInstance();
		BillPlughSingleton bps1 = BillPlughSingleton.getInstance();
		System.out.println(bps);
		System.out.println(bps.hashCode() + "\t" + bps1.hashCode());
	}
}

// Eager initialization
class EagerInitializedSingleton {
	private static final EagerInitializedSingleton INSTANCE = new EagerInitializedSingleton();

	private EagerInitializedSingleton() {
	};

	public static EagerInitializedSingleton getInstance() {
		return INSTANCE;
	}
}

// Static block initialization
class StaticBlockSingleton {
	private static final StaticBlockSingleton INSTANCE;

	private StaticBlockSingleton() {
	};

	static {
		try {
			INSTANCE = new StaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton class");
		}
	}

	public static StaticBlockSingleton getInstance() {
		return INSTANCE;
	}
}

// Lazy initialization
class LazyInitializedSingleton {
	private static LazyInitializedSingleton INSTANCE;

	private LazyInitializedSingleton() {
	};

	public static LazyInitializedSingleton getInstance() {
		if (INSTANCE == null)
			INSTANCE = new LazyInitializedSingleton();
		return INSTANCE;
	}
}

// Thread safe singleton
class ThreadSafeSingleton {
	private static ThreadSafeSingleton INSTANCE;

	private ThreadSafeSingleton() {
	};

	public synchronized static ThreadSafeSingleton getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ThreadSafeSingleton();
		return INSTANCE;
	}

	public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
		if (INSTANCE == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (INSTANCE == null)
					INSTANCE = new ThreadSafeSingleton();
			}
		}
		return INSTANCE;
	}
}

// Bill Plugh singleton implementation
class BillPlughSingleton {
	private BillPlughSingleton() {
	};

	private static class SingletonHelper {
		private static final BillPlughSingleton INSTANCE = new BillPlughSingleton();
	}

	@Override
	public String toString() {
		return "I'm a singleton!";
	}

	public static BillPlughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}

}
