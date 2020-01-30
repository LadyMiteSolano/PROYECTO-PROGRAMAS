import java.util.Scanner;
import java.util.Random;
public class BatallaAcorazado
{
	public static String A[][]=new String[10][10], B[][]=new String[10][10];
	public static Random r = new Random();
	public static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) 
    {	int x=0, y=0;
		presentacion();
		String cad;//cadena de caracteres para q valide el ingreso de un numero del 1 al 10
		inicializar();
		System.out.println("       ***************************************************");  
		System.out.println("       *      Donde le gustaria colocar sus barcos       *");
		System.out.println("       ***************************************************");
		System.out.println(" ");
		for(int i=1;i<6;i++)
		{	System.out.println("|-------------------------------------------------|");
			System.out.println("|     Ingrese coordenadas (1-10) del barco " + i+ "      |");
			System.out.println("|-------------------------------------------------|");
			do
			{
				System.out.print("  Coordenada X: ");
				cad = sc.nextLine();
			}while( !( cad.equals("1") || cad.equals("2") || cad.equals("3") || cad.equals("4") || cad.equals("5") || cad.equals("6") || cad.equals("7") || cad.equals("8") || cad.equals("9") || cad.equals("10") ) );
			x = Integer.parseInt(cad);
			do
			{
				System.out.print("  Coordenada Y: ");
				cad = sc.nextLine();
			}while( !( cad.equals("1") || cad.equals("2") || cad.equals("3") || cad.equals("4") || cad.equals("5") || cad.equals("6") || cad.equals("7") || cad.equals("8") || cad.equals("9") || cad.equals("10") ) );
			y = Integer.parseInt(cad);
			if((B[x-1][y-1]).equals("     1"))
			{
				System.out.println("  Coordenada ocupada");
				System.out.println("");
				System.out.println("");
				i--;
			}
			B[x-1][y-1]="     1";	A[x-1][y-1]="     1";
			mostrarMatriz();
		}
		llenarCPU();
		atacar();
	}
	
	public static void inicializar()
    {
		int i=0, j=0;
		A[0][0] = " ";
		B[0][0] = " ";
		for(i=0;i<10;i++)
		{
			for(j=0;j<10;j++)
			{
				A[i][j] = "     @";
				B[i][j] = "     @";
			}
		}
    }
	
    public static void llenarCPU()
    {
		int x, y;
		for(int i=1;i<6;i++)
		{	x = r.nextInt(10)+1;
			y = r.nextInt(10)+1;
			if((A[x-1][y-1]).equals("     1") || (A[x-1][y-1]).equals("     2"))
				i--;
			else
				A[x-1][y-1] = "     2";
		}
	}
	
	public static void atacar()
    {
		int x=0, y=0, cont=0, i, j, p1=5, p2=5, atk=0;
		String cad;
		System.out.println(" ");
		System.out.println("           	    |-----------------------------------|");
		System.out.println("        	    |  !Es hora de comenzar la batalla! |");
		System.out.println("        	    |-----------------------------------|");
		System.out.println(" ");
		while(true)
		{	//ataca jugador
			cont++;	
			do
			{	System.out.println("|---------------------------------------------------------|");
				System.out.println("      Ingrese coordenadas para realizar ataque #" + cont);
				System.out.println("|---------------------------------------------------------|");
				do
				{
					System.out.print("Coordenada X: ");
					cad = sc.nextLine();
				}while( !( cad.equals("1") || cad.equals("2") || cad.equals("3") || cad.equals("4") || cad.equals("5") || cad.equals("6") || cad.equals("7") || cad.equals("8") || cad.equals("9") || cad.equals("10") ) );
				x = Integer.parseInt(cad);
				do
				{
					System.out.print("Coordenada Y: ");
					cad = sc.nextLine();
				}while( !( cad.equals("1") || cad.equals("2") || cad.equals("3") || cad.equals("4") || cad.equals("5") || cad.equals("6") || cad.equals("7") || cad.equals("8") || cad.equals("9") || cad.equals("10") ) );
				y = Integer.parseInt(cad);
				if((A[x-1][y-1]).equals("     -") || (A[x-1][y-1]).equals("     !") || (A[x-1][y-1]).equals("     X"))
					System.out.println("------No se puede atacar cordenada repetida-----");
					System.out.println("");
					System.out.println("");
			}while((A[x-1][y-1]).equals("     -") || (A[x-1][y-1]).equals("     X") || (A[x-1][y-1]).equals("     !"));
			

				if((A[x-1][y-1]).equals("     2"))
				{	System.out.println("|/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-|");
			        System.out.println("|   ¡Boom! ¡Haz hundido el barco!    |"); p2--;
					System.out.println("|/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-|");
					A[x-1][y-1]="     !";
					B[x-1][y-1]="     !";
					if(p2==0)
					{
						mostrarMatrizFin();
						atk = (2*cont)-1;
						System.out.print("-|-|-|-Juego terminado Gana Jugador 1 en " + cont + " turnos, se realizaron " + atk + " ataques-|-|-|");
						System.out.println("");
						System.out.println("");
						break;
					}
				}
				else if((A[x-1][y-1]).equals("     1"))
				{	System.out.println("| /-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/- |");
					System.out.println("| !Oh no!, hundiste tu propio barco :( |");
					System.out.println("| /-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/- |");					p1--;
					System.out.println("");
					System.out.println("");
					A[x-1][y-1]="     X";
					B[x-1][y-1]="     X";
					if(p1==0)
					{	
						mostrarMatrizFin();
						atk = (2*cont)-1;
						System.out.print("-|-|-|Juego terminado Gana Jugador 2 en " + cont + " turnos, se realizaron " + atk + " ataques-|-|-|");
						System.out.println("");
						System.out.println("");
						break;
					}
				}
				else
				{
					System.out.println("------Lo siento, te lo perdiste-----");
					System.out.println("");
					System.out.println("");
					A[x-1][y-1]="     -";
					B[x-1][y-1]="     -";
				}
				System.out.println("------Turno CPU, espere....------"); mostrarMatriz();
				System.out.println("");
				System.out.println("");
				//ataca CPU
				do
				{
					x = r.nextInt(10)+1;
					y = r.nextInt(10)+1;
				}while((A[x-1][y-1]).equals("     -") || (A[x-1][y-1]).equals("     X") || (A[x-1][y-1]).equals("     !"));
				
				if((A[x-1][y-1]).equals("     1"))
				{	System.out.println("^^^^^^!La computadora hundio uno de tus barcos!^^^^^^"); p1--;
					System.out.println("");
					System.out.println("");
					A[x-1][y-1]="     X";
					B[x-1][y-1]="     X";
					if(p1==0)
					{
						mostrarMatrizFin();
						atk = (2*cont);
						System.out.print("-|-|-|-Juego terminado Gana Jugador 2 en " + cont + " turnos, se realizaron " + atk + " ataques-|-|-|-");
						System.out.println("");
					    System.out.println("");
						break;
					}
				}
				else if((A[x-1][y-1]).equals("     2"))
				{
					System.out.println("^^^^^La computadora hundio uno de sus propios barcos^^^^^");	p2--;
					System.out.println("");
					System.out.println("");
					A[x-1][y-1]="     !";
					B[x-1][y-1]="     !";
					if(p2==0)
					{
						mostrarMatrizFin();
						atk = (2*cont);
						System.out.print("-|-|-|-Juego terminado Gana Jugador 1 en " + cont + " turnos, se realizaron " + atk + " ataques-|-|-|-");
						System.out.println("");
					System.out.println("");
						break;
					}
				}
				else
				{
					System.out.println("-----Ordenador perdido-----");
					System.out.println("");
					System.out.println("");
					A[x-1][y-1]="     -";
					B[x-1][y-1]="     -";
				}
				mostrarMatriz();
		}
	}
	public static void presentacion(){
		System.out.println("       ***************************************************");
		System.out.println("       *   PROYECTO DE PROGRAMACION ORIENTADA A OBJETOS  *");
		System.out.println("       ***************************************************"); 
		System.out.println("       *                                                 *");
        System.out.println("       *               Batalla de Acorazados             *");
		System.out.println("       *                                                 *");
		System.out.println("       ***************************************************"); 
		System.out.println("       *                   INTEGRANTES:                  *");
		System.out.println("       ***************************************************"); 
		System.out.println("       *                                                 *");
		System.out.println("       *               Anthony Del Valle Lino            *");
		System.out.println("       *                                                 *");
	    System.out.println("       *                  Lady Mite Solano               *");
		System.out.println("       *                                                 *");
	    System.out.println("       *            	 Peter Lozano Robles             *");
		System.out.println("       *                                                 *");
	    System.out.println("       ***************************************************");        	                                   
		System.out.println(" ");
		System.out.println(" ");
}
	
	public static void mostrarMatriz()
    {	int i=0, j=0;
		System.out.println("|-------------------------------------------------------------------------------|");
        System.out.println("|    1  ||   2   ||  3   ||  4   ||  5  ||   6  ||   7  ||   8  ||   9  ||   10 |");
        System.out.println("|-------------------------------------------------------------------------------|");
		for(i=0;i<10;i++)
		{	for(j=0;j<10;j++)		//para mostrar las naves aliadas y enemigas usar A, para mostrar aliadas B
			{
				if(j==0)
				{	
					if(i==10)
						System.out.print(B[i][j] + "\t");
					else
						System.out.print(B[i][j] + "\t");
				}
				else
					System.out.print(B[i][j] + "\t");
			}
			System.out.println("");
		}
    }
	public static void mostrarMatrizFin()
    {	
		int i=0, j=0;
		for(i=0;i<10;i++)
		{	for(j=0;j<10;j++)
			{
				if(j==0)
				{	
					if(i==10)
						System.out.print(A[i][j] + "\t");
					else
						System.out.print(A[i][j] + "\t");
				}
				else
					System.out.print(A[i][j] + "\t");
			}
			System.out.println("");
		}
    }
}