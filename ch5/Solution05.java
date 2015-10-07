package Ch5;
//Debugger: Explain what the following code does: ((n&(n-1))==0).

/* Answer:
 * When n=0, n-1=111....1 in binary, which is suitable for n&(n-1))==0
 * When n!=0, since for any number n which is a power of 2 in binary, it is formed as 100...0, 
 * and then the number n-1 is formed as 011...1;
 * At that time we can find that n&(n-1)==0;
 * Thus, n&(n-1))==0 means the n is the power of 2 or n=0. */
