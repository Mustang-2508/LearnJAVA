package org.javaeight.methodAndConstructorRef;

public class Product {
    private String name;
    private Integer serialNo;


    public Product() {
    }

    public Product(String name, Integer serialNo) {
        this.name = name;
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String Save(String name, Integer serialNo){
        System.out.println("Save :: Saved Product ["+name+" : "+serialNo+"]");
        return "Ok";
    }

    public String customSave(String name, Integer serialNo, String topSpeed){
        System.out.println("customSave :: Saved Product ["+name+" : "+serialNo+" "+topSpeed+"]");
        return "Ok";
    }

    public static void saveObject(Product product){
        System.out.println("saveObject :: Saved Product ["+product.name+" : "+product.serialNo+"]");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  String saveObjectAndReturn(){
        System.out.println("saveObjectAndReturn :: Saved Product ["+name+" : "+serialNo+"]");
        return name;
    }
}
