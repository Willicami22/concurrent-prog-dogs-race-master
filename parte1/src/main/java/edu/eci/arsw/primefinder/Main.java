package edu.eci.arsw.primefinder;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		PrimeFinderThread pft1=new PrimeFinderThread(0, 10000000);
		PrimeFinderThread pft2=new PrimeFinderThread(10000001, 20000000);
		PrimeFinderThread pft3=new PrimeFinderThread(20000001, 30000000);

		int primes=0;
		
		pft1.start();
		pft2.start();
		pft3.start();

		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		pft1.setFlag();
		pft2.setFlag();
		pft3.setFlag();


		primes = pft1.getPrimes().size()+ pft2.getPrimes().size()+ pft3.getPrimes().size();
		System.out.println("El numero de primos encontrados es: "+primes);

		System.out.println("Presione ENTER para reanudar...");
		new Scanner(System.in).nextLine();

		pft1.cont();
		pft2.cont();
		pft3.cont();

		try{
			pft1.join();
			pft2.join();
			pft3.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		primes = pft1.getPrimes().size()+ pft2.getPrimes().size()+ pft3.getPrimes().size();
		System.out.println("El numero total de primos es:"+primes);

	}
	
}
