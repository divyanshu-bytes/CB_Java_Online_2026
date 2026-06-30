public class QueueDemo{
	public static void main(String[] args){
		Queue q = new Queue(5);
		q.offer(3);
		q.offer(1);
		q.offer(2);
		q.offer(6);
		q.offer(5);
		q.offer(9);

		System.out.println("Front: " + q.peek());
		int poppedEl = q.poll();
		System.out.println("Popped Element: " + poppedEl);
		System.out.println("Front: " + q.peek());

		poppedEl = q.poll();
		System.out.println("Popped Element: " + poppedEl);
		System.out.println("Front: " + q.peek());

		poppedEl = q.poll();
		System.out.println("Popped Element: " + poppedEl);
		System.out.println("Front: " + q.peek());

		poppedEl = q.poll();
		System.out.println("Popped Element: " + poppedEl);
		System.out.println("Front: " + q.peek());

		poppedEl = q.poll();
		System.out.println("Popped Element: " + poppedEl);
		System.out.println("Front: " + q.peek());

		poppedEl = q.poll();
		System.out.println("Popped Element: " + poppedEl);
		System.out.println("Front: " + q.peek());


	}
}