import javax.swing.JOptionPane;

public class MasaCorporalA {
	
	String  nombres [];
    double  tallas [];
    double pesos [] ;
	int edades [] ;
	double  imc [] ;
	String mensaje ="";
	
	public MasaCorporalA() {
    
	}
	

	public void iniciar() {
		System.out.println("iniciar");

		String menu = "Gestion IMC\n";
		menu += "1. registrar Personas\n";
		menu += "2. Imprimir Resultados\n";
		menu+="3. Buscar por nombre\n";
		menu+="4. Eliminar \n";
		menu+="5. Actualizar\n";
		menu+="6. limpiar\n";
		menu+="7. Salir\n";
		menu+="Ingrese una opcion:\n";

		int opc = 0;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			validarMenu(opc);
		} while (opc != 8);
		
	}
	

	public void validarMenu(int op) {
		switch (op) {
		case 1:
			registraPersona();

			break;
		case 2:
			if (validarArreglo()) {
				imprimirResultados();
			}
			
			break;
		case 3:
				buscarPersona(); 
			
			break;
		case 4:
				eliminarPersona();
			
			break;
		case 5:
				actualizarPersona();
			
			break;
		case 6:
				limpiarLista();
			
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "Salir, gracias por la atencion");
			break;
		default:
			break;
		}
	}
	
	public boolean validarArreglo() {
		if (nombres != null) {
			return true;
		} else {
			System.out.println("Debe primero llenar datos");
			return false;
		}
	}

	public void registraPersona() {
		 
		int cant=Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidadde personas a registrar"));
		nombres = new String[cant];
		 edades = new int[cant];
	        pesos = new double[cant];
	        tallas = new double[cant];
	    for (int i = 0; i < nombres.length; i++) {
	    	 nombres[i] = JOptionPane.showInputDialog("Ingrese el nombre");
	    	 edades[i] = Integer.parseInt(JOptionPane.showInputDialog("ingrese la edad "));
	    	 pesos[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso"));
	    	 tallas[i]  = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura"));
	    	
	         
	       
	        
	    }
	}


	public void imprimirResultados() {
		System.out.println("<<<<<<Estas son las personas registratradas>>>>>");
		
		for (int i = 0; i < nombres.length; i++) {
			
			System.out.println("la persona identificada como " +nombres[i]+ ", con una edad de " +edades[i]
					+ " años, con un peso de " +pesos[i]+ " y con una altura de "+ tallas[i]);
			
		}
	}



	public void eliminarPersona() {
		System.out.println("<<<Nombre eliminar>>> " + nombres.length);
		String nombre = JOptionPane.showInputDialog("ingrese el usuario a eliminar");
		int conta = 0;
		int eli= -1;
		for (int i = 0; i < nombres.length; i++) {
			if (nombres[i].equalsIgnoreCase(nombre)) {
				eli=i;
				JOptionPane.showMessageDialog(null, "ELIMINADO CON EXITO");
				
				conta++;
				break;
				
			}
		}
		if (conta == 0) {
			JOptionPane.showMessageDialog(null, "VALOR NO EXISTE");
		}
		System.out.println(nombres);

	}
	

	public void actualizarPersona() {
		System.out.println("<<<Nombre actualizzar>>> " + nombres.length);
		
		String actual = JOptionPane.showInputDialog("ingresa el nombre para actualizar datos");
		for (int i = 0; i < nombres.length; i++) {
			if (nombres[i].equalsIgnoreCase(actual)) {
	            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre para " + actual);
	            int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad para " + actual));
	            double nuevaAltura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nueva altura para " + actual));
	            double nuevoPeso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo peso para " + actual));
	            
	            nombres[i]= nuevoNombre;
	            edades[i]= nuevaEdad;
	            tallas[i]= nuevaAltura;
	            pesos[i]= nuevoPeso;
	            
	            System.out.println("Los datos de " + actual + " se han actualizado:");
	            System.out.println("Nombre: " + nuevoNombre);
	            System.out.println("Edad: " + nuevaEdad);
	            System.out.println("Altura: " + nuevaAltura);
	            System.out.println("Peso: " + nuevoPeso);
	            System.out.println();
	            
	            System.out.print(nombres);
	            
	            return; 
			}

		}
		
	}

	public void limpiarLista() {
		
		for(int i=0; i<nombres.length; i++) {
			nombres[i] = 0 +"";
			System.out.println(nombres);
		}
		
		for(int i=0; i<edades.length; i++) {
			edades[i] = 0;
			System.out.println(edades);
		}
		
		for(int i=0; i<pesos.length; i++) {
			pesos[i] = 0 ;
			System.out.println(pesos);
		}
		
		for(int i=0; i<tallas.length; i++) {
			tallas[i] = 0 ;
			System.out.println(tallas);
		}
	}
	public void buscarPersona() {
		System.out.println();
		System.out.println("<<<Nombre buscar>>> " + nombres);
		
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario: ");
		String mensaje = "";
		boolean encontrado = false;
		for (int i = 0; i < nombres.length; i++) {
			if (nombres[i].equalsIgnoreCase(nombre)) {
				double imc = (pesos[i] / (tallas[i]*tallas[i]));

				if (imc < 18) {
					mensaje = "ANOREXIA";
				} else if (imc >= 18 && imc <= 20) {
					mensaje = "DELGADES";
				} else if (imc >= 20 && imc < 25) {
					mensaje = "NORMAL";
				} else if (imc >= 25 && imc <= 30) {
					mensaje = "OBECIDAD GRADO1";
				} else if (imc >= 30 && imc < 35) {
					mensaje = "OBECIDAD GRADO 2";
				} else if (imc >= 35 && imc < 40) {
					mensaje = "OBECIDAD GRADO 3";
				}else if (imc >= 40) {
					mensaje = "OBECIDAD MORFIDA";
				}
				System.out.println( "la persona es "+ nombres[i]+ "con la edad de "
						+ edades[i]+ "un peso de "+ pesos[i]+ "una altura de "+ tallas[i]+ "con un imc de "+ imc
						+ "y se encuntra en un estado de "+ mensaje);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
		}
	}

}
