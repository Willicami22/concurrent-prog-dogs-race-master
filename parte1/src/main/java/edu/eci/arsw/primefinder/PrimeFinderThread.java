package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread{

	
	int a,b;
	boolean flag = false;
	
	private List<Integer> primes=new LinkedList<Integer>();
	
	public PrimeFinderThread(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public void run(){
		for (int i = a; i <= b; i++) {
			Wait();
			if (isPrime(i)) {
				primes.add(i);
				}
			}
		}

	
	boolean isPrime(int n) {
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	public synchronized void Wait() {
		while (flag){
			try {
				wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void cont(){
		flag=false;
		notifyAll();
	}

	public void setFlag() {
		flag=true;
	}

	public List<Integer> getPrimes() {
		return primes;
	}

}
