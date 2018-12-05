/**
 * this project consists of giving solution to the backpack problem using the gredy methodology
 */
package practical_exercise2;
import java.io.*;
/**
 *
 * @author Johan Benavides Arias
 */
public class Knapsack_Problem {
    
     static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
     static BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
     
    public int[] readArrayFronConsole()throws IOException	
        {
        String[] numbers = br.readLine().split(" ");
        int[] arrayNumbers = new int[numbers.length];     
	    for(int i = 0; i < numbers.length; i++)
		arrayNumbers[i] = Integer.parseInt( numbers[i] );                
            return arrayNumbers;	
	}    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        try{
           
            Knapsack_Problem m = new Knapsack_Problem();

            int total_benefit=0;
            int knapsack_volume=0;

            bw.write("Ingrese el tamaño de la mochila: ");
                bw.flush();
                    String vol_max=br.readLine();
                        int max_vol=Integer.parseInt(vol_max);
            bw.write("\nIngrese la cantidad de elementos: ");
                bw.flush();
                    String N=br.readLine();
                        int n = Integer.parseInt(N);

            bw.write("\nIngrese beneficios\n");
                bw.flush();
                    int []Benefits=m.readArrayFronConsole();
            
            bw.write("\nIngrese volumenes\n");
                bw.flush();
                    int []volumes=m.readArrayFronConsole();

            //array config created and inicializated
            int []config= new int[n];        
                for (int i = 0; i < config.length; i++) {
                    config[i]=0;            
                }
                
            int temp; //variable where a temporary data is stored 
            int temp2;//variable where a temporary data is stored

            //buble mod to order volumenes and benefec
            for(int i=0; i < n; i++){//travel of the array of numbers  
                for(int j=1; j < (n-i); j++){//compare to adjacent elements  
                    if(Benefits[j-1] < Benefits[j]){//ordering of numbers  
                        //swap elements  
                        temp = Benefits[j-1];  
                        Benefits[j-1] = Benefits[j];
                        Benefits[j] = temp;

                        temp2 = volumes[j-1];  
                        volumes[j-1] = volumes[j];
                        volumes[j] = temp2;  
                    }                           
                }  
            }
            
            bw.write("\nBeneficios ordenados:\n");
            bw.flush();
            for (int j = 0; j < Benefits.length; j++) {
                bw.write(Benefits[j]+" ");
                    bw.flush();
            }
            
            bw.write("\nVolumenes ordenados:\n");
                bw.flush();
                    for (int j = 0; j < volumes.length; j++) {
                        bw.write(volumes[j]+" ");
                            bw.flush();
                    }

            int i=0;
            //while the volume of the backpack is less than the volume of the objects entered,     
            while(knapsack_volume<max_vol&&i<n){                
                
                if(volumes[i]<=(max_vol-knapsack_volume)){
                    total_benefit+=Benefits[i];
                    knapsack_volume+=volumes[i];
                    config[i]=1;
                }
            i++;   
            }
            
            bw.write("\nConfiguración obtenida:\n");
                bw.flush();
                    for (int j = 0; j < config.length; j++) {
                        bw.write(config[j]+" ");
                        bw.flush();
                    }
            bw.write("\n\nBeneficio obtenido: "+total_benefit+"\n");
                bw.flush();
        }catch (IOException ex) {}
            
    }
    
}
