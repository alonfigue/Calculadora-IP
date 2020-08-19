package com.calculadoraIP.alonso;

import java.util.regex.Pattern;


public class Ip6c {

	
	public String ipstr;
	public String tipo;
	
	
	public Ip6c() {
		
	}
	
	public Ip6c(String ip6) {
		this.ipstr = ip6;
	}
	
		
	
	public String getIpstr() {
		return ipstr;
	}

	public void setIpstr(String ipstr) {
		this.ipstr = ipstr;
	}




	
	public static final String IPV6_REG_IPV4 = "\\A((?:[0-9A-Fa-f]{1,4}:){6,6})(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\z";
	public static final String IPV6_COMP = "\\A((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)\\z";
	public static final String IPV6_REG = "\\A(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}\\z";



	public String verificarIP(Ip6c ip6) {
		
		String iver = ip6.getIpstr();
		String sub = "";
		
		if (Pattern.matches(IPV6_COMP, iver)) {
			System.out.print("direccion comprimida valida");
			tipo = Comprimida(iver);
			
		}
		else if (Pattern.matches(IPV6_REG, iver)) {
			System.out.print("regular");
			tipo = Regular(iver);
			
		
		}
		else if (Pattern.matches(IPV6_REG_IPV4, iver)) {
			System.out.print("ip4");
			tipo = "IPv4 compatible";
		}
		else {
			tipo = "direccion IP invalida";
		}
		
		
		
		
		
		
		
		
		
		return tipo;
			
	}

	
	public String Comprimida(String iver) {

		String hext1a = iver.substring(0,iver.indexOf(":"));
		
		String hext1 = String.format("%4s", hext1a).replace(" ", "0");
	
		
		String tipoIp ="";
		
		//unicast
		if(iver.contentEquals("::")) {
			tipoIp = "UNICAST-sin especificar";
		}
		else if (iver.contentEquals("::1")) {
			tipoIp = "UNICAST-Loopback";
		}
		else if (hext1.substring(0,2).equalsIgnoreCase("fc") || hext1.substring(0,2).equalsIgnoreCase("fd")) {
			tipoIp = "UNICAST-Local unica";
		}
		else if (hext1.substring(0,2).equalsIgnoreCase("fe")) {
			if (hext1.substring(2,3).equalsIgnoreCase("8") || hext1.substring(2,3).equalsIgnoreCase("9") || hext1.substring(2,3).equalsIgnoreCase("a") || hext1.substring(2,3).equalsIgnoreCase("b")) {
				tipoIp = "UNICAST-Link Local";
			}
		}
		else if (hext1.substring(0,1).equalsIgnoreCase("2") || hext1.substring(0,1).equalsIgnoreCase("3")) {
			tipoIp = "UNICAST-Global";
		}
		
		
		//Multicast comienzan por FFxx::
		else if(hext1.substring(0,2).equalsIgnoreCase("ff")) {
			
			//asignada
				
				if (hext1.equalsIgnoreCase("ff02")) {
					
					String lt = iver.substring(iver.lastIndexOf("::")+2);
					String hext8 = String.format("%4s", lt).replace(" ", "0");
					
					if(lt.isEmpty()) {
						//nodo solicitado FF02:0:0:0:0:0:FF00:: prefijo 104
						String ln = iver.substring(iver.lastIndexOf("::")-4 , iver.lastIndexOf("::") );
						if(ln.equalsIgnoreCase("FF00")) {
							tipoIp = "MULTICAST-Nodo Solicitado";
						}
					}
					//de todos los nodos FF02::1 
					else if(hext8.contentEquals("0001")) {
						tipoIp = "MULTICAST- Asignada de todos los nodos";
					}
					//de todos los routers FF02::2
					else if(hext8.contentEquals("0002")) {
						tipoIp = "MULTICAST- Asignada de todos los routers";
					}
					
				}
				
			
			
		}
		return tipoIp;
		
		
	}
	
	public String Regular(String iver) {
        String hext1a = iver.substring(0,iver.indexOf(":"));
        
        String[] h =iver.split(":");
        
		
		String hext1 = String.format("%4s", h[0]).replace(" ", "0");
		String hext2 = String.format("%4s", h[1]).replace(" ", "0");
		String hext3 = String.format("%4s", h[2]).replace(" ", "0");
		String hext4 = String.format("%4s", h[3]).replace(" ", "0");
		String hext5 = String.format("%4s", h[4]).replace(" ", "0");
		String hext6 = String.format("%4s", h[5]).replace(" ", "0");
		String hext7 = String.format("%4s", h[6]).replace(" ", "0");
		String hext8 = String.format("%4s", h[7]).replace(" ", "0");
		
	
		
		String tipoIp ="";
		
		//unicast
		if(hext1.contentEquals("0000") && hext2.contentEquals("0000") && hext3.contentEquals("0000") && hext4.contentEquals("0000") && hext5.contentEquals("0000") && hext6.contentEquals("0000") && hext7.contentEquals("0000") && hext8.contentEquals("0000")) {
			tipoIp = "UNICAST-sin especificar";
		}
		else if (hext1.contentEquals("0000") && hext2.contentEquals("0000") && hext3.contentEquals("0000") && hext4.contentEquals("0000") && hext5.contentEquals("0000") && hext6.contentEquals("0000") && hext7.contentEquals("0000") && hext8.contentEquals("0001")) {
			tipoIp = "UNICAST-Loopback";
		} 
		else if (hext1.substring(0,2).equalsIgnoreCase("fc") || hext1.substring(0,2).equalsIgnoreCase("fd")) {
			tipoIp = "UNICAST-Local unica";
		}
		else if (hext1.substring(0,2).equalsIgnoreCase("fe")) {
			if (hext1.substring(2,3).equalsIgnoreCase("8") || hext1.substring(2,3).equalsIgnoreCase("9") || hext1.substring(2,3).equalsIgnoreCase("a") || hext1.substring(2,3).equalsIgnoreCase("b")) {
				tipoIp = "UNICAST-Link Local";
			}
		}
		else if (hext1.substring(0,1).equalsIgnoreCase("2") || hext1.substring(0,1).equalsIgnoreCase("3")) {
			tipoIp = "UNICAST-Global";
		}
		
		
		//Multicast comienzan por FFxx::
		else if(hext1.substring(0,2).equalsIgnoreCase("ff")) {
			
			//asignada
				
				if (hext1.equalsIgnoreCase("ff02")) {
					
					String lt = iver.substring(iver.lastIndexOf("::")+2);
					
					if(hext8.equalsIgnoreCase("0000")) {
						//nodo solicitado FF02:0:0:0:0:0:FF00:0 prefijo 104
						
						if(hext7.equalsIgnoreCase("FF00")) {
							tipoIp = "MULTICAST-Nodo Solicitado";
						}
					}
					//de todos los nodos FF02::1 
					else if(hext8.contentEquals("0001")) {
						tipoIp = "MULTICAST- Asignada de todos los nodos";
					}
					//de todos los routers FF02::2
					else if(hext8.contentEquals("0002")) {
						tipoIp = "MULTICAST- Asignada de todos los routers";
					}
					
				}
				
			
			
		}
		return tipoIp;
	}
}


