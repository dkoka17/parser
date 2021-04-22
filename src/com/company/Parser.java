package com.company;

public class Parser {

    public static void parse(byte[] mass, Item item) throws NoSuchFieldException, IllegalAccessException {
        String[]  fields =  Item.getParsableAnnotation();
        for(String field : fields){
            Parse parse = Item.getCustomAnnotation(field);
            String value = readData(mass,parse.order(),parse.length());
            item.setData(field,value);
        }
    }

    private static String readData(byte[] mass, int order, int length){
        return  "data: " + Integer.toString(order) + " / " + Integer.toString(length);
    }
}
