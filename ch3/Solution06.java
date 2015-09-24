package Ch3;

import java.util.LinkedList;

/*An animal shelter, which holds only dogs and cats, operates on a strictly "firts in, first out" basis.
 * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like.
 * Create the data structures to maintain this system and implement operations such as 
 * enqueue, dequeueAny, dequeueDog, and dequeueCat.
 * You may use the built-in LinkedList data structure.
 */
public class Solution06 {
	abstract class Animal { // Define the abstract father class Animal.
		private int order;
		protected String name;

		public Animal(String n) {
			name = n;
		}

		public void setOrder(int ord) {
			order = ord;
		}

		public int getOrder() {
			return order;
		}

		public boolean isOlderThan(Animal a) {
			return this.order < a.getOrder();
		}
	}

	public class Dog extends Animal {
		public Dog(String n) {
			super(n);
		}
	}

	public class Cat extends Animal {
		public Cat(String n) {
			super(n);
		}
	}

	static class AnimalQueue { // Put the Animals into the queues and have an order
						// sort.
		LinkedList<Dog> dogs = new LinkedList<Dog>();
		LinkedList<Cat> cats = new LinkedList<Cat>();
		private int order = 0;

		public void enqueue(Animal a) {
			a.setOrder(order);
			order++;
			if (a instanceof Dog) {
				dogs.addLast((Dog) a);
			} else if (a instanceof Cat) {
				cats.addLast((Cat) a);
			}
		}

		public Animal dequeueAny() {
			if (dogs.size() == 0) {
				return dequeueCats();
			} else if (cats.size() == 0) {
				return dequeueDogs();
			}
			Dog dog = dogs.peek();
			Cat cat = cats.peek();
			if (dog.isOlderThan(cat)) {
				return dequeueDogs();
			} else {
				return dequeueCats();
			}
		}

		public Dog dequeueDogs() {
			return dogs.poll();
		}

		public Cat dequeueCats() {
			return cats.poll(); // Remove and feedback the first element.
		}
	}

	public static void main(String args[]) throws Exception {
		LinkedList<Dog> dogs = new LinkedList<Dog>();
		Dog a1 = new Solution06().new Dog("a1");
		Dog b1 = new Solution06().new Dog("b1");
		Dog c1 = new Solution06().new Dog("c1");
		a1.setOrder(1);
		b1.setOrder(3);
		c1.setOrder(5);
		dogs.add(a1);
		dogs.add(b1);
		dogs.add(c1);

		LinkedList<Cat> cats = new LinkedList<Cat>();
		Cat a2 = new Solution06().new Cat("a2");
		Cat b2 = new Solution06().new Cat("b2");
		Cat c2 = new Solution06().new Cat("c2");
		a2.setOrder(2);
		b2.setOrder(4);
		c2.setOrder(6);
		cats.add(a2);
		cats.add(b2);
		cats.add(c2);

		AnimalQueue zoo = new AnimalQueue();
		zoo.enqueue(a1);
		zoo.enqueue(a2);
		zoo.enqueue(b1);
		zoo.enqueue(b2);
		zoo.enqueue(c1);
		zoo.enqueue(c2);
		System.out.println(zoo.dequeueAny().name);
		System.out.println(zoo.dequeueCats().name);
		System.out.println(zoo.dequeueDogs().name);

	}
}
