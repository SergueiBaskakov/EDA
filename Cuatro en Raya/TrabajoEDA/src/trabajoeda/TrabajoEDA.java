/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoeda;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class TrabajoEDA {

    /**
     * @param args the command line arguments
     */
    public static void print(int [][] a){
    //imprime una matriz 
        System.out.println("   0 1 2 3 4 5 6");
        for (int i=0; i!=a.length;i++){
            System.out.print((char)(65+i)+" ");
            for (int j=0; j!=a[0].length;j++){
                switch (a[i][j]) {
                    case 1:
                        System.out.print("|R");
                        break;
                    case 2:
                        System.out.print("|Y");
                        break;
                    default:
                        System.out.print("| ");
                        break;
                }
            }
            System.out.println("|");
        }
    }
    public static void RP(Scanner scan, int[] b, int[][]t){
    //coloca una ficha roja en la columna a
        int a=7;
        while ((a<0 || a>6) || b[a]==6){
            System.out.print("Ingrese el numero de la columna(jugador rojo):");
            a=scan.nextInt(); 
        }           
        t[5-b[a]][a]=1;
        b[a]++;
    }
    public static void YP(Scanner scan, int[] b, int[][]t){
    //coloca una ficha amarilla en la columna a
        int a=7;
        while ((a<0 || a>6) || b[a]==6){
            System.out.print("Ingrese el numero de la columna(jugador amarillo):");
            a=scan.nextInt();          
        }
        t[5-b[a]][a]=2;
        b[a]++;  
    }
    public static int check(int[][]t, int[]n){
      //revisa empate
      if(n[0]==6 && n[1]==6 && n[2]==6 && n[3]==6 && n[4]==6 && n[5]==6 && n[6]==6){
            return 3;
      }
      else{
        //revisa ganador creando una sub-matriz de 4*4
        for (int i=0; i!=3; i++){
            for (int j=0; j!=4; j++){
                //revisa si gano el rojo
                if((t[i][j]==1 && t[1+i][j]==1 && t[2+i][j]==1 && t[3+i][j]==1)||(t[i][3+j]==1 && t[1+i][3+j]==1 && t[2+i][3+j]==1 && t[3+i][3+j]==1)||//vertical
                  (t[i][j]==1 && t[i][1+j]==1 && t[i][2+j]==1 && t[i][3+j]==1)||(t[3+i][j]==1 && t[3+i][1+j]==1 && t[3+i][2+j]==1 && t[3+i][3+j]==1)||//horizontal
                  (t[i][j]==1 && t[1+i][1+j]==1 && t[2+i][2+j]==1 && t[3+i][3+j]==1)||(t[3+i][j]==1 && t[2+i][1+j]==1 && t[1+i][2+j]==1 && t[i][3+j]==1)){//diagonal
                    return 1;
                }
                //revisa si gano el amarillo
                else if((t[i][j]==2 && t[1+i][j]==2 && t[2+i][j]==2 && t[3+i][j]==2)||(t[i][3+j]==2 && t[1+i][3+j]==2 && t[2+i][3+j]==2 && t[3+i][3+j]==2)||//vertical
                  (t[i][j]==2 && t[i][1+j]==2 && t[i][2+j]==2 && t[i][3+j]==2)||(t[3+i][j]==2 && t[3+i][1+j]==2 && t[3+i][2+j]==2 && t[3+i][3+j]==2)||//horizontal
                  (t[i][j]==2 && t[1+i][1+j]==2 && t[2+i][2+j]==2 && t[3+i][3+j]==2)||(t[3+i][j]==2 && t[2+i][1+j]==2 && t[1+i][2+j]==2 && t[i][3+j]==2)){//diagonal
                    return 2;
                }
            }
        }
      }
        return 0;
    
}
    public static void CPUR(int[]b, int[][]t){
        //coloca una ficha roja en la columna a
        int a=7;
        while (b[a]==6){
            a=(int)(Math.random()*7); 
        }           
        t[5-b[a]][a]=1;
        b[a]++;
    }
    public static void CPUA(int[]b, int[][]t){
        //coloca una ficha amarilla en la columna a
        int a=7;
        while (b[a]==6){
            a=(int)(Math.random()*7); 
        }           
        t[5-b[a]][a]=2;
        b[a]++;
    }
    public static void main(String[] args) {
    // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int tablero[][] = new int[6][7];
        int n[] = new int[8]; //numero de fichas por columna
        int a=-1,b=0,c;//b=numero del turno
        n[7]=6;
        //
        while(a!=0 && a!=1 && a!=2){
         System.out.println("Elija el modo de juego:");
         System.out.println("  Dos jugadores (0)");
         System.out.println("  Jugador(rojo) contra CPU (1)");
         System.out.println("  Jugador(amarillo) contra CPU (2)");
         a=scan.nextInt();
        }
        if(a==0){
        OUTER:
        while (1==1) {//juego jugador contra jugador
            b++;
            print(tablero);
            a=check(tablero,n);
            switch (a) {
                case 1:
                    System.out.println("Gano el jugador rojo");
                    break OUTER;
                case 2:
                    System.out.println("Gano el jugador amarillo");
                    break OUTER;
                case 3:
                    System.out.println("Empate");
                    break OUTER;
                default:
                    if (b%2==1){
                        RP(scan,n,tablero);
                    }
                    else{
                        YP(scan,n,tablero);
                    }   
                    break;
            }
        }
        }
        else if(a==1){
        OUTER:
        while (1==1) {//juego jugador rojo contra CPU
            b++;
            print(tablero);
            a=check(tablero,n);
            switch (a) {
                case 1:
                    System.out.println("Gano el jugador rojo");
                    break OUTER;
                case 2:
                    System.out.println("Gano el jugador amarillo");
                    break OUTER;
                case 3:
                    System.out.println("Empate");
                    break OUTER;
                default:
                    if (b%2==1){
                        RP(scan,n,tablero);
                    }
                    else{
                        CPUA(n,tablero);
                    }   
                    break;
            }
        }
        }
        else{
        OUTER:
        while (1==1) {//juego jugador amarillo contra CPU
            b++;
            print(tablero);
            a=check(tablero,n);
            switch (a) {
                case 1:
                    System.out.println("Gano el jugador rojo");
                    break OUTER;
                case 2:
                    System.out.println("Gano el jugador amarillo");
                    break OUTER;
                case 3:
                    System.out.println("Empate");
                    break OUTER;
                default:
                    if (b%2==1){
                        CPUR(n,tablero);
                    }
                    else{
                        YP(scan,n,tablero);
                    }   
                    break;
            }
        }
        }
        
    }
    
}