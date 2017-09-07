import java.util.*;
import java.lang.*;
import java.io.*;

// eelis autio

class Goldbach 
{
	private static boolean isPrime(int n) 
    {
    	if (n <= 1) return false;
      	else if (n <= 3) return true;
      	else if (n % 2 == 0 || n % 3 == 0) return false;
      	int i = 5;
        while (i * i <= n)
        {
        	if (n % i == 0 || n % (i + 2) == 0) return false;
        	i += 6;
        }
    	return true;
	}
  
  	private static int[] getPrimes(int until_n)
    {
      	int search = 2;
      	int size = 0;
      	List<Integer> primelist = new ArrayList<Integer>();
      	while (search <= until_n)
        {
          	if (isPrime(search))
            {
              	size++;
              	primelist.add(search);
            }
           	search++;
        }
      	int primes[] = new int[size];
      	primes = primelist.stream().mapToInt(i -> i).toArray();
      	return primes;
    }

    public static void main(String[] args) 
    {
      	int wanted = 100000;
      
    	int[] primes = getPrimes(wanted);
      	int lower_primes[] = new int[primes.length];
      	int upper_primes[] = new int[primes.length];
      	int low_i = 0;
      	int up_i = 0;
      	for (int i = 0; i < primes.length; i++)
        {
        	if (primes[i] < (wanted / 2))
            {
            	lower_primes[low_i] = primes[i];
              	low_i++;
            }
          	else
          	{
            	upper_primes[up_i] = primes[i];
              	up_i++;
            }
        }
      	int result = 0;
      	for (int i = 0; i < lower_primes.length; i++)
        {
          	if (lower_primes[i] == 0) break;
          	int lower = lower_primes[i];
        	for (int j = 0; j < upper_primes.length; j++)
            {
              	if (upper_primes[j] == 0) break;
              	int upper = upper_primes[j];
				if (lower + upper == wanted)
                	result += 1;
            } 	
        }
      	System.out.println("Result: " + result);
    }
}
