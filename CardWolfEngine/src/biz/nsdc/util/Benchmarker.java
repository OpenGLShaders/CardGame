package biz.nsdc.util;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;

public class Benchmarker {
	private PrintStream out;
	private boolean started = false;
	private long startTime = 0;
	private long endTime = 0;
	
	private boolean startedLoop = false;
	private BigInteger totalNS = new BigInteger("0");
	private int totalLoops = 0;
	private ArrayList<Long> times = new ArrayList<>();
	
	
	/**
	 * 
	 * @param out
	 */
	public Benchmarker(PrintStream out) {
		this.out = out;
	}
	
	/**
	 * Tells the benchmarker that all future calls to start() and end() should be
	 * counted as iterations of a loop. Exit the loop caching by calling endLoop().
	 */
	public void startLoop() {
		if (startedLoop) {
			throw new IllegalStateException("Cannot call startLoop when it has already been called and "
					+ "endLoop hasn't been called!!");
		}
		startedLoop = true;
		totalNS = BigInteger.ZERO;
		totalLoops = 0;
	}
	
	/**
	 * Ends the loop and prints diagnostic data to the specified location. 
	 */
	public void endLoop() {
		if (!startedLoop) {
			throw new IllegalStateException("Cannot call endLoop before startLoop!!");
		}
		startedLoop = false;
		long average = totalNS.divide(new BigInteger(totalLoops + "")).longValueExact();
		
		long variance = 0;
		
		out.println("Times in ns: \n");
		long min = Long.MAX_VALUE;
		long max = 0;
		
		
		for (Long time : times) {
			out.println(time);
		
			//Calculate variance
			long v0 = time - average;
			
			//Square the number and add it to the variance. Math.pow was giving me issues, and this was 
			//the simpler, more performant solution
			variance += (v0 * v0);
		
			//See if this time was a new maximum
			if (time > max) {
				max = time;
			}
			
			//See if this time was a new minimum
			if (time < min) {
				min = time;
			}
		}
		
		variance /= totalLoops;
		long stdDev = (long) Math.sqrt(variance);
		
		//Print out diagnosic info
		out.println("Average time: " + average + " ns");
		out.println("Min: " + min + " ns.");
		out.println("Max: " + max + " ns.");
		out.println("Total loops: " + totalLoops);
		out.println("Variance: " + variance);
		out.println("Standard Deviation: " + stdDev);
	}
	
	/**
	 * Starts a benchmarking test. 
	 */
	public void start() {
		if (started) {
			throw new IllegalStateException("Cannot call start when it has already been called!!");
		}
		started = true;
		startTime = System.nanoTime();
	}
	
	/**
	 * Finishes a benchmark test. 
	 */
	public long end() {
		if (!started) {
			throw new IllegalStateException("Cannot call end before start!!");
		}
		started = false;
		endTime = System.nanoTime();
		long timeTaken = endTime - startTime;

		if (startedLoop) {
			totalLoops++;
		
			BigInteger time = new BigInteger(timeTaken + "");
			totalNS = totalNS.add(time);
			times.add(timeTaken);
		}
		
		return timeTaken;
	}
}