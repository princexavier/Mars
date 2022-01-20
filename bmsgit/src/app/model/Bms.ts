import { Customer } from "./Customer";
import { Product } from "./Product";

export class Bms{

    public id:number=0;
    
    public quantity:number=0;

    public unitPrice:number=0;

    public customerAmt:number=0;

    public totalAmt:number=0;

    public balanceAmt:number=0;

    public customers:Customer[]=[];
    
    public products:Product[]=[];
    public dateCreated:Date= new Date();


}