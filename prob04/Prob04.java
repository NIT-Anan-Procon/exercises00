import java.io.*;

class Prob04{
    static int count;
    static int sum;
    
    public static void main(String[] args){
	count = 0;
	sum = 0;
	
        Prob04 p4 = new Prob04();
        try {
            if (System.in.available() != 0) {
                p4.printInputStream(System.in, "UTF-8");
            } else {
                System.out.println("Not Found: pipied input");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void printInputStream(InputStream is, String charsetName) throws IOException {
        InputStreamReader isr = new InputStreamReader(is, charsetName);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null ) {
	    count++;
	    sum += Integer.parseInt(line);
        }
	System.out.println((count+1)*count/2 - sum);
    }
}
