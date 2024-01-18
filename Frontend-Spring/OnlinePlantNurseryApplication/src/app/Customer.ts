import { Address } from "./Address";
import { Order } from "./Order";

export class Customer{
    customerId:number;
	customerName:string;
	customerEmail:string;
	username:string;
	password:string;
	address:Address=new Address();
	orders:Order[];
	
}