import { Customer } from "./Customer";
import { Product } from "./Product";

export class Bms{

    public id:number=0;
    
    public quantity:number=0;

    public unitPrice:number=0;

    public customerAmt:number=0;

    public totalAmt:number=0;

    public balanceAmt:number=0;

    public customerId:number=0;
    
    public productId:number=0;
    public dateCreated:Date= new Date();
    public customerName:string="";
    public productName:string="";

    


}