import { Planter } from "./Planter";

export class Order{
    bookingOrderId:number;
	OrderDate:Date;
	transactionMode:string;
	quantity:number;
	totalCost:number;
	planters:Planter[];
}