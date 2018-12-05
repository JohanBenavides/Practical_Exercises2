/**
 *this program consists of buying shares considering that you can not sell before buying
 * 
 *@autor Johan Benavides Arias
 */
package practical_exercise2;
import java.io.*;

public class Buy__Shares {
        
        static int n_shares=1;
        static int purchases =0;
        static int sales = 0;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
        
	public int[] readArrayFronConsole()throws IOException{//read console text and split by space	
        
            String[] numbers = br.readLine().split(" ");
            int[] arrayNumbers = new int[numbers.length];     
                for(int i = 0; i < numbers.length; i++)
                    arrayNumbers[i] = Integer.parseInt( numbers[i] );
                
            return arrayNumbers;	
	}	
	/**
	 * This function find the day that the user should purchase the action 
	 * @param values
	 * @return
	 */
	static int find_purchase (int [] values) {
            int lower = values [0];//find purchase, lower is the lowest price initialized on day 1
            int index = 0;//Create a variable that will be save the index of lower price
            for (int i = 0; i < values.length - 2; i++) {//Go trhough the array, except the last position
                    if (lower > values[i+1]) {
                            lower = values[i+1];//Save the value of the lower price
                            index = (i + 1);//Save the index of the lower price
                    }
            }
            purchases+=values[index];//accumulation of purchases
            return index;
	}
        /**
	 * This function find the day that the user should sell the action 
	 * @param values
         * @param day
	 * @return
	 */
	static int find_Sale(int [] values, int day) {
            int higher = values [day];//Create a variable that takes the position "day" of the values array
            int index = 0;//Create a variable that will be save the index of higher price
            for (int i = day; i < values.length - 1; i++) {//Go trhough the array, except the last position
                    
                if (higher < values[i+1]) {
                            higher = values[i+1];//Save the value of the higher price
                            index = (i + 1);//Save the index of the higher price
                    }
            }
            sales+=values[index];//sales accumulation
            return index;
	}
        public String day (int d){
            if (d==0){
                return "lunes";}
            if (d==1){
                return "martes";}
            if (d==2){
                return "miercoles";}
            if (d==3){
                return "jueves";}
            if (d==4){
                return "viernes";}
            else
                return "sabado";        
    }			
	/**
	 * 
	 * @param args
	 */
	public static void main (String [] args) {
                                        
            Buy__Shares mth = new Buy__Shares();                

            try {			
                bw.write("Ingrese la cantidad de semanas: ");
                bw.flush();
                int weeks = Integer.parseInt(br.readLine()); // Read the number of the weeks

                int[][] sem = new int[weeks][6];        

                for (int i =0;i<weeks;i++){

                    bw.write("\nIngrese los 6 valores de la semana "+(i+1)+" separados por espacio:\n\n");
                    bw.flush();
                    sem[i] = mth.readArrayFronConsole();

                    int purchase = find_purchase(sem[i]);//Calls the find_pruchase function and saves the index
                    int sale = find_Sale(sem[i], purchase);//Calls the find_Sale function and saves the index
                    bw.write("\nCompro el dia "+mth.day(purchase)+" cuando costo $"+sem[i][purchase]+" y vendio el día "+mth.day(sale)+" cuando costo $"+sem[i][sale]+" para obtener una mayor ganancia\n");
                    bw.write("\nCOMPRA TOTAL: $"+(purchases));
                    bw.write("\nVENTA TOTAL: $"+(sales)+"\n");
                    bw.write("\nGANANCIA TOTAL: $"+((sales*n_shares)-(purchases*n_shares))+"\n");
                    bw.flush();

                }

            }catch (IOException ex) {}		
	}
}
