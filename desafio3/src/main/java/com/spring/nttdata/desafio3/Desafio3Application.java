package com.spring.nttdata.desafio3;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.nttdata.desafio3.entities.Cliente;
import com.spring.nttdata.desafio3.services.ClienteService;
import com.spring.nttdata.desafio3.services.GestionClientesService;

@SpringBootApplication
public class Desafio3Application implements CommandLineRunner {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private GestionClientesService gestionClientesService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio3Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
			
		
		//Creo un cliente
		Cliente cliente = new Cliente();
		cliente.setDni("11111111A");
		cliente.setName("Rafael");
		cliente.setLastName("Liebana Fuentes");
		cliente.setId(1);
		
		Calendar ca = Calendar.getInstance();
        ca.set(Calendar.MONTH, 04);
        ca.set(Calendar.DATE, 29);
        ca.set(Calendar.YEAR, 1994);
        Date fecha = ca.getTime();
		
		cliente.setBirthDate(fecha);
		
		//Guardando en bbdd
		this.gestionClientesService.save(cliente);
			
		//Búsqueda por Nombre
		System.out.println("================================");
		System.out.println("***Búsqueda por nombre***");
		Cliente clienteEnBBDD = this.clienteService.findByName("Rafael");
		System.out.println(clienteEnBBDD.getName()); //Mostramos
		System.out.println("================================");
		
		//Búsqueda por Apellidos
		System.out.println("================================");
		System.out.println("***Búsqueda por apellidos***");
		Cliente clienteEnBBDD2 = this.clienteService.findByLastName("Liebana Fuentes");
		System.out.println(clienteEnBBDD2.getName()); //Mostramos
		System.out.println("================================");
		
		//Búsqueda por Nombre y Apellidos
		System.out.println("================================");
		System.out.println("***Búsqueda por nombre y apellidos***");
		Cliente clienteEnBBDD3 = this.clienteService.findByNameAndLastName("Rafael", "Liebana Fuentes");
		System.out.println(clienteEnBBDD3.getName()); //Mostramos
		System.out.println("================================");
		
		//Actualizando cliente
		
		Cliente actualizado = this.clienteService.findByName("Rafael");
		
		actualizado.setName("Rafa Actualizado");
			
		this.gestionClientesService.update(actualizado);
		
		//Búsqueda Actualizada
		
		System.out.println("================================");
		System.out.println("***Búsqueda por nombre***");
		Cliente clienteEnBBDD4 = this.clienteService.findByName("Rafa Actualizado");
		System.out.println(clienteEnBBDD4.getName()); //Mostramos
		System.out.println("================================");
		
		//Delete cliente
		
		this.gestionClientesService.delete(clienteEnBBDD4);
		
	}

}
