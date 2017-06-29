package com.sarvenaz;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.concurrent.Semaphore;;

public class RWproblem {

	static Semaphore reader = new Semaphore(1);
	static Semaphore writer = new Semaphore(1);

	static Random r = new Random();

	static int rand;

	static int counter;

	public static void main(String[] args) {

		Thread thread1 = null;
		Thread thread2 = null;
		Thread thread3 = null;
		Thread thread4 = null;
		Thread thread5 = null;
		Thread thread6 = null;
		Thread thread7 = null;

		Reading reading = new Reading();
		Writing writing = new Writing();

		for (int i = 0; i < 4; i++) {
			rand = r.nextInt(6) + 1;
			if (rand % 2 == 0) {
				thread1 = new Thread(reading);
				thread1.setName("1");
				thread1.start();
			} else {
				thread1 = new Thread(writing);
				thread1.setName("1");
				thread1.start();
			}
			
		}

		for (int i = 0; i < 4; i++) {
			rand = r.nextInt(6) + 1;
			if (rand % 2 == 0) {
				thread2 = new Thread(reading);
				thread2.setName("2");
				thread2.start();
			} else {
				thread2 = new Thread(writing);
				thread2.setName("2");
				thread2.start();
			}
			
		}

		for (int i = 0; i < 4; i++) {
			rand = r.nextInt(6) + 1;
			if (rand % 2 == 0) {
				thread3 = new Thread(reading);
				thread3.setName("3");
				thread3.start();
			} else {
				thread3 = new Thread(writing);
				thread3.setName("3");
				thread3.start();
			}
			
		}

		for (int i = 0; i < 4; i++) {
			rand = r.nextInt(6) + 1;
			if (rand % 2 == 0) {
				thread4 = new Thread(reading);
				thread4.setName("4");
				thread4.start();
			} else {
				thread4 = new Thread(writing);
				thread4.setName("4");
				thread4.start();
			}
			
		}

		for (int i = 0; i < 4; i++) {
			rand = r.nextInt(6) + 1;
			if (rand % 2 == 0) {
				thread5 = new Thread(reading);
				thread5.setName("5");
				thread5.start();
			} else {
				thread5 = new Thread(writing);
				thread5.setName("5");
				thread5.start();
			}
			
		}

		for (int i = 0; i < 4; i++) {
			rand = r.nextInt(6) + 1;
			if (rand % 2 == 0) {
				thread6 = new Thread(reading);
				thread6.setName("6");
				thread6.start();
			} else {
				thread6 = new Thread(writing);
				thread6.setName("6");
				thread6.start();
			}
			
		}

		for (int i = 0; i < 4; i++) {
			rand = r.nextInt(6) + 1;
			if (rand % 2 == 0) {
				thread7 = new Thread(reading);
				thread7.setName("7");
				thread7.start();
			} else {
				thread7 = new Thread(writing);
				thread7.setName("7");
				thread7.start();
			}
			
		}

	}

	static class Reading implements Runnable {

		public void run() {

			try {

				reader.acquire();
				counter++;

				if (counter == 1) {
					writer.acquire();
				}

				reader.release();
				System.out.println("Thread " + Thread.currentThread().getName() + " now is ready to read the shared location");
				Thread.sleep(500);
				System.out.println("Thread " + Thread.currentThread().getName() + " now has finished reading the shared location");

				reader.acquire();

				counter--;

				if (counter == 0) {
					writer.release();
				}

				reader.release();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	static class Writing implements Runnable {

		public void run() {

			try {

				writer.acquire();
				System.out.println("Thread " + Thread.currentThread().getName() + " now is ready to write the shared location");
				Thread.sleep(1000);
				System.out.println("Thread " + Thread.currentThread().getName() + " now has finished writing the shared location");
				writer.release();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch
				e.printStackTrace();
			}

		}

	}
}
