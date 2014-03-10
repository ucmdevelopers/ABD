package observable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class Observable<C> implements Iterable<C> {

	private Set<C> observers;
	protected Observable(){
		setObservers(new HashSet<C>());
	}
	protected boolean addObserver(C observer) {
		return getObservers().add(observer);
	}
	public boolean removeObserver(C observer) {
		return getObservers().remove(observer);
	}

	public Iterator<C> iterator(){
		return getObservers().iterator();
	}

	public Set<C> getObservers(){
		return observers;
	}
	public void setObservers(Set<C> observers) {
		this.observers = observers;
	}
}
