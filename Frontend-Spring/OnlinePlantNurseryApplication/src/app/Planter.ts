import { Plant } from "./Plant";
import { Seed } from "./Seed";

export class Planter{
    planterId :number;
	planterheight:number;
	planterCapacity:number;
	drinageHoles:number;
	planterColor:string;
	planterShape:string;
	planterStock:number;
	 planterCost:number;
	
	plants:Plant[]=[];
	

	seeds:Seed[]=[];
}