package vct.freshshop.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {

	HashMap items = null;
	int numberOfItems = 0;
	double total = 0.0;
	public ShoppingCart() {
		items = new HashMap();
	}

	public synchronized void add(int id, Product p) {
		if (items.containsKey(id)) {
			OderItem scitem = (OderItem) items.get(id);
			scitem.incrementQuantity();
			System.out.println("in add1, quantity is " + scitem.getQuantity());
		} else {
			OderItem newItem = new OderItem(p);
			items.put(id, newItem);
			System.out.println("in add2, quantity is " + newItem.getQuantity());
		}

	}

	public synchronized void remove(int id) {
		if (items.containsKey(id)) {
			OderItem scitem = (OderItem) items.get(id);
			scitem.decrementQuantity();

			if (scitem.getQuantity() <= 0) {
				items.remove(id);
			}
			numberOfItems--;
		}
	}

	public synchronized void update(int id, int quantity) {
		if (items.containsKey(id)) {
			OderItem scitem = (OderItem) items.get(id);
			scitem.setQuantity(quantity);
		}
	}
	public synchronized List<OderItem> getItems() {
		List results = new ArrayList();
		results.addAll(this.items.values());
		return results;
	}

	protected void finalize() throws Throwable {
		items.clear();
	}

	public synchronized int getNumberOfItems() {
		numberOfItems = 0;

		for (Iterator i = getItems().iterator(); i.hasNext();) {
			OderItem item = (OderItem) i.next();
			numberOfItems += item.getQuantity();
			System.out.println("number of items is " + numberOfItems);
		}

		return numberOfItems;
	}

	public synchronized double getTotal() {
		double amount = 0.0;

		for (Iterator i = getItems().iterator(); i.hasNext();) {
			OderItem item = (OderItem) i.next();
			Product b = (Product) item.getProduct();

			amount += (item.getQuantity() * b.getPrice());
		}
		total = roundOff(amount);
		return total;
	}

	private double roundOff(double x) {
		long val = Math.round(x * 100); // cents
		return val / 100.0;
	}

	public synchronized void clear() {
		System.err.println("Clearing cart.");
		items.clear();
		numberOfItems = 0;
	}

	@Override
	public String toString() {
		String re = "";
		List list = getItems();
		for (Object object : list) {
			re += object.toString() + "\n";
		}
		return re;
	}
}
