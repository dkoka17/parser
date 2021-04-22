package com.company;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
	// write your code here
        Item item = new Item();
        byte[] bt = new byte[0];
        Parser.parse(bt,item);
        System.out.println(item.toString());
    }
}
