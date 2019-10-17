package com.flip.test;

class MultithreadingDemo extends Thread 
{ 
    public void run() 
    { 
        try
        { 
            // Displaying the thread that is running 
            System.out.println ("Thread " + 
                  Thread.currentThread().getId() + 
                  " is running"); 
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
    
    public class TwoSums {
        
        private int sum1 = 0;
        private int sum2 = 0;
        
        public void add(int val1, int val2){
            synchronized(this){
                this.sum1 += val1;   
                this.sum2 += val2;
            }
        }
    }

} 

public class ConcurrencyTest extends Thread {
	public static void main(String[] args) 
    { 

        for (int i=0; i<8; i++) 
        { 
            MultithreadingDemo object = new MultithreadingDemo(); 
            object.start(); 
        } 
    } 
	
	
}
