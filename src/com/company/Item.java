package com.company;


import java.lang.reflect.Field;

@Parsable(fields = {"status","name","price","weight"})
public class Item {

    @Parse(order = 1,length = 1)
    private String status;

    @Parse(order = 2,length = 3)
    private String name;

    @Parse(order = 3,length = 2)
    private String price;

    @Parse(order = 4,length = 1)
    private String weight;

    public void setData(String key, String value) throws NoSuchFieldException, IllegalAccessException {
        Field field = Item.class.getDeclaredField(key);
        field.set(this,value);
    }

    public static String[] getParsableAnnotation(){
        try {
            Class c = Item.class;
            Parsable parsable = (Parsable) c.getAnnotation(Parsable.class);
            String[] fields = parsable.fields();
            return fields;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new String[0];
    }

    public static Parse getCustomAnnotation(String fieldName) {
        try {
            Class c = Item.class;
            Field field =  c.getDeclaredField(fieldName);
            Parse parse = field.getAnnotation(Parse.class);
            return parse;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Item{" +
                "status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
