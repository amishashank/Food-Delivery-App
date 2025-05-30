package com.andro.myfoodz;

public class MenuModel {
    private int menu_image;
    private String menu_name;
    private String menu_price;

    public MenuModel(int menu_image, String menu_name, String menu_price) {
        this.menu_image = menu_image;
        this.menu_name = menu_name;
        this.menu_price = menu_price;
    }

    public int getMenu_image() {
        return menu_image;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public String getMenu_price() {
        return menu_price;
    }

    public void setMenu_image(int menu_image) {
        this.menu_image = menu_image;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public void setMenu_price(String menu_price) {
        this.menu_price = menu_price;
    }
}
