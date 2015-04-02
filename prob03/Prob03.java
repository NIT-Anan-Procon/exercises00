import java.util.Scanner;

class Prob03{

    static void factorization(int n){
	System.out.print(n + " = ");
	for(int i = 2; i < n; i++){
	    while(n%i == 0){
		System.out.print(i + " * ");
		n /= i;
	    }
	}
	System.out.println(n);
    }

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.print("素因数分解する数：");
	factorization(sc.nextInt());
    }
}
