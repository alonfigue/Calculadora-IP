package com.calculadoraIP.alonso;

import java.sql.Timestamp;
import java.util.ArrayList;



public class Ip4c {

	private int oct1;
	private int oct2;
	private int oct3;
	private int oct4;
	private int pre;
	private int bitMasc;
	
	
	
	public Ip4c() {
		
	}
 
	public Ip4c(int oct1, int oct2, int oct3, int oct4, int pre) {
		
		this.oct1 = oct1;
		this.oct2 = oct2;
		this.oct3 = oct3;
		this.oct4 = oct4;
		this.pre = pre;
		
	}

	


	public int getOct1() {
		return oct1;
	}

	public void setOct1(int oct1) {
		this.oct1 = oct1;
	}

	public int getOct2() {
		return oct2;
	}

	public void setOct2(int oct2) {
		this.oct2 = oct2;
	}

	public int getOct3() {
		return oct3;
	}

	public void setOct3(int oct3) {
		this.oct3 = oct3;
	}

	public int getOct4() {
		return oct4;
	}

	public void setOct4(int oct4) {
		this.oct4 = oct4;
	}

	public int getPre() {
		return pre;
	}

	public void setPre(int pre) {
		this.pre = pre;
	}

	
	
	
	public ArrayList tipoIp(Ip4c ip) {
		
		String tipo = "";
		String clase = "";
		String error = "";
		String red = "";
		String gateway = "";
		String broadcast = "";
		String rango = "";
		String mascara = "";
		
		int octeto1 = ip.getOct1();
		int octeto2 = ip.getOct2();
		int octeto3 = ip.getOct3();
		int octeto4 = ip.getOct4();
		
		//Tratamiento de la dirección a binario
		String binOct1 = Integer.toBinaryString(octeto1);
		String binOct2 = Integer.toBinaryString(octeto2);
		String binOct3 = Integer.toBinaryString(octeto3);
		String binOct4 = Integer.toBinaryString(octeto4);
		
		String bo1 = String.format("%08d", Integer.parseInt(binOct1));
		String bo2 = String.format("%08d", Integer.parseInt(binOct2));
		String bo3 = String.format("%08d", Integer.parseInt(binOct3));
		String bo4 = String.format("%08d", Integer.parseInt(binOct4));
		//*****************************************
		
		String dirIp = octeto1+"."+octeto2+"."+octeto3+"."+octeto4;
		
		if (ip.getPre()<33 && ip.getPre()!=0) {
			bitMasc = Integer.valueOf(ip.getPre());
			
			
		}
		else {
			error="mascara incorrecta";
		}
		
		//hacer un total de 32 bit de la direccion IP
		int ipTotalB = Integer.parseInt(bo1+bo2+bo3,2);// solo 24bits por el limite de 31 bit del metodo parseInt
		
		ipTotalB = (ipTotalB << 8)+ Integer.parseInt(bo4,2); // para poder anadir los otros 8 bits
		
		
		
		//hacer un total de 32 bits de la mascara
		int totalMasc = ~0 << (32-bitMasc);
		
		
		//calculo de la red en binario
		int redBin = ipTotalB & totalMasc;
		
		
		//Direccion de broadcast en binario
		int broadBin = ipTotalB | ~totalMasc;
		
		//uno binario
		int uno = Integer.parseInt("1",2);
		int prim = redBin + uno;
		int ult = broadBin - uno;
		
		//separar con puntos
		String cadIpBin = Integer.toBinaryString(ipTotalB);
		cadIpBin = String.format("%32s", cadIpBin).replace(" ", "0");
		String[] cadPuBi = cadIpBin.split("(?<=\\G........)");
		
		String cadMascBin = Integer.toBinaryString(totalMasc);
		cadMascBin = String.format("%32s", cadMascBin).replace(" ", "0");
		String[] cadMaBi = cadMascBin.split("(?<=\\G........)");
		
		String cadRedBin = Integer.toBinaryString(redBin);
		cadRedBin = String.format("%32s", cadRedBin).replace(" ", "0");
		String[] cadReBi = cadRedBin.split("(?<=\\G........)");
		
		String cadBroadBin = Integer.toBinaryString(broadBin);
		cadBroadBin = String.format("%32s", cadBroadBin).replace(" ", "0");
		String[] cadBrBi = cadBroadBin.split("(?<=\\G........)");
		
		String cadPrim = Integer.toBinaryString(prim);
		cadPrim = String.format("%32s", cadPrim).replace(" ", "0");
		String[] cadPr = cadPrim.split("(?<=\\G........)");
		
		String cadUlt = Integer.toBinaryString(ult);
		cadUlt = String.format("%32s", cadUlt).replace(" ", "0");
		String[] cadUl = cadUlt.split("(?<=\\G........)");
		
		//Mascara de subred en decimal
		mascara=String.valueOf(Integer.parseInt(cadMaBi[0],2))+"."+String.valueOf(Integer.parseInt(cadMaBi[1],2))+"."+String.valueOf(Integer.parseInt(cadMaBi[2],2))+"."+String.valueOf(Integer.parseInt(cadMaBi[3],2));
		//Red en Decimal
		red = String.valueOf(Integer.parseInt(cadReBi[0],2))+"."+String.valueOf(Integer.parseInt(cadReBi[1],2))+"."+String.valueOf(Integer.parseInt(cadReBi[2],2))+"."+String.valueOf(Integer.parseInt(cadReBi[3],2));
		//Broadcast en Decimal
		broadcast=String.valueOf(Integer.parseInt(cadBrBi[0],2))+"."+String.valueOf(Integer.parseInt(cadBrBi[1],2))+"."+String.valueOf(Integer.parseInt(cadBrBi[2],2))+"."+String.valueOf(Integer.parseInt(cadBrBi[3],2));
		//Hosts disponibles OK
		String hosts = String.valueOf(~totalMasc - 1);
		//Redes disponibles
		String redes = String.valueOf(~(~0 << bitMasc) +1);
		
		//Rango de direcciones IP
    	String primera = String.valueOf(Integer.parseInt(cadPr[0],2))+"."+String.valueOf(Integer.parseInt(cadPr[1],2))+"."+String.valueOf(Integer.parseInt(cadPr[2],2))+"."+String.valueOf(Integer.parseInt(cadPr[3],2));
		
		String ultima = String.valueOf(Integer.parseInt(cadUl[0],2))+"."+String.valueOf(Integer.parseInt(cadUl[1],2))+"."+String.valueOf(Integer.parseInt(cadUl[2],2))+"."+String.valueOf(Integer.parseInt(cadUl[3],2));
		
		rango = primera+"-"+ultima;
		
				
		//tipo de IP
		if(octeto1>255 || octeto1>255 || octeto2 >255 || octeto3>255 ||  octeto4>255) {
			error = "Direccion IP incorrecta";
		}
		else if(octeto1 == 0 && octeto2 == 0 && octeto3 == 0 && octeto4 == 0) {
			tipo = "Reservada por IANA ident. local";
		}
		else if(octeto1 > 223 && octeto1 < 239) {
			tipo = "Pública";
			clase = "Multicast";
		}
		else if(octeto1 >239) {
			tipo = "Pública";
			clase ="Experimental";
		}
		
		else if(octeto1 < 128){
			tipo = "Pública";
			clase = "A";
			
			if (octeto1 == 10) {
				tipo ="Privada";
				clase ="A";
			}
			
			if(octeto1 == 127) {
				tipo = "Loopback-Reservada";
				clase ="A";
			}
			
			if(octeto1 == 100 && octeto2 >63 && octeto2 <128) {
				tipo = "Espacio de direcciones compartido";
				clase = "A";
			}
					
		}
		else if(octeto1 > 127 && octeto1 < 192) {
			tipo = "Pública";
			clase = "B";
			if(octeto1 == 172 && octeto2>15 && octeto2<32) {
				tipo ="Privada";
				clase = "B";
			}
			if(octeto1 == 169 && octeto2 == 254) {
				tipo = "APIPA";
				clase = "B";
			}
		}
		else if(octeto1 >191 && octeto1 <224) {
			tipo = "Pública";
			clase = "C";
			if(octeto1 == 192 && octeto2 == 168) {
				tipo ="Privada";
				clase = "C";
			}
			if(octeto1 == 192 && octeto2 == 0 && octeto3 == 2) {
				tipo ="TEST-NET-Reservada";
				clase = "C";
			}
					
		}
		else {
			error = "incorrecta";
		}
		
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());		
		
		
		ArrayList str = new ArrayList();
		str.add(tipo);
		str.add(clase);
		str.add(error);
		str.add(red);
		str.add(mascara);
		str.add(broadcast);
		str.add(rango);
		str.add(hosts);
		str.add(redes);
		str.add(dirIp);
		str.add(timestamp.toString());
		
		System.out.print(timestamp);
		
		DB db = DB.getInstances();
		
		db.dbPrepareStatement("insert into ip4(ip, mascara, tipo, clase, red, broadcast, rango, hosts, fecha) values( ?, ?, ? , ?, ?,?,?,?,?)", str);
		//*******
		
		
		
		return str;
		
		
	}
	
	
}
