package com.andro.myfoodz;

import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
    public List<MenuModel> menuList;

    public FoodMenu() {
        menuList = new ArrayList<>();

        // Paneer Dishes
        menuList.add(new MenuModel(R.drawable.paneer, "Paneer Tikka Masala", "600"));
        menuList.add(new MenuModel(R.drawable.paneer, "Schezwan Paneer", "550"));
        menuList.add(new MenuModel(R.drawable.paneer, "Paneer Makhani", "650"));
        menuList.add(new MenuModel(R.drawable.paneer, "Paneer Tikka Pizza", "950"));
        menuList.add(new MenuModel(R.drawable.paneer, "Stuffed Paneer Kulcha", "350"));

        // Broccoli & Cheese & Mushroom
        menuList.add(new MenuModel(R.drawable.broccoli, "Tandoori Broccoli", "450"));
        menuList.add(new MenuModel(R.drawable.broccoli, "Broccoli & Cheese Casserole", "500"));
        menuList.add(new MenuModel(R.drawable.broccoli, "Spicy Broccoli Stir Fry", "480"));
        menuList.add(new MenuModel(R.drawable.broccoli, "Mushroom & Water Chestnut Dim Sum", "650"));
        menuList.add(new MenuModel(R.drawable.broccoli, "Mushroom Fried Rice", "550"));
        menuList.add(new MenuModel(R.drawable.broccoli, "Truffle Mushroom Risotto", "700"));

        // Rice
        menuList.add(new MenuModel(R.drawable.rice, "Chai-Infused Emperor's Green Rice", "600"));
        menuList.add(new MenuModel(R.drawable.rice, "Steamed Jasmine Rice", "300"));
        menuList.add(new MenuModel(R.drawable.rice, "Mushroom Fried Rice", "550"));
        menuList.add(new MenuModel(R.drawable.rice, "Schezwan Fried Rice", "500"));
        menuList.add(new MenuModel(R.drawable.rice, "Jeera Rice with Dal Bukhara", "700"));
        menuList.add(new MenuModel(R.drawable.rice, "Paneer Rice with Veg Manchurian", "800"));

        // Lassi
        menuList.add(new MenuModel(R.drawable.lassi, "Classic Mango Lassi", "250"));
        menuList.add(new MenuModel(R.drawable.lassi, "Rose-Flavored Lassi", "270"));
        menuList.add(new MenuModel(R.drawable.lassi, "Saffron Cardamom Lassi", "290"));
        menuList.add(new MenuModel(R.drawable.lassi, "Banana Almond Lassi", "320"));
        menuList.add(new MenuModel(R.drawable.lassi, "Kesar Pista Lassi", "350"));

        // Masala
        menuList.add(new MenuModel(R.drawable.masala_dish, "Dal Bukhara", "700"));
        menuList.add(new MenuModel(R.drawable.masala_dish, "Paneer Butter Masala", "650"));
        menuList.add(new MenuModel(R.drawable.masala_dish, "Classic Rajma Masala", "400"));
        menuList.add(new MenuModel(R.drawable.masala_dish, "Aloo Dum Kashmiri", "550"));
        menuList.add(new MenuModel(R.drawable.masala_dish, "Vegetable Kadhai Masala", "600"));

        // Street Food
        menuList.add(new MenuModel(R.drawable.streetfood, "Stuffed Kulcha with Chole", "350"));
        menuList.add(new MenuModel(R.drawable.streetfood, "Crispy Papdi Chaat", "320"));
        menuList.add(new MenuModel(R.drawable.streetfood, "Classic Bombay Vada Pav", "280"));
        menuList.add(new MenuModel(R.drawable.streetfood, "Spicy Dahi Puri", "330"));
        menuList.add(new MenuModel(R.drawable.streetfood, "Tangy Golgappa with Spiced Water", "300"));

        // Dessert
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Company Baug Laddoo", "400"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Banana Asharfi", "550"));
        menuList.add(new MenuModel(R.drawable.menu_pic2, "Rasgulla with Saffron Syrup", "450"));
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Classic Gulab Jamun", "300"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Mysore Pak", "350"));

        // Chai & Coffee
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Masala Chai", "200"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Kadak Chai", "220"));
        menuList.add(new MenuModel(R.drawable.menu_pic2, "Doodh Patti Chai", "250"));
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Classic Espresso Coffee", "180"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Cappuccino Coffee", "280"));
        menuList.add(new MenuModel(R.drawable.menu_pic2, "Mocha Latte Coffee", "320"));
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Vietnamese Iced Coffee", "350"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Spanish Latte Coffee", "400"));
        menuList.add(new MenuModel(R.drawable.menu_pic2, "Affogato Coffee", "450"));

        // Drinks
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Shikanji (Indian Lemonade)", "180"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Nimbu Soda", "200"));
        menuList.add(new MenuModel(R.drawable.menu_pic2, "Kadha Herbal Tea", "250"));
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Kombucha", "300"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Hot Chocolate", "350"));
        menuList.add(new MenuModel(R.drawable.menu_pic2, "Mixed Berry Shake", "400"));
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Peanut Butter Shake", "450"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Protein Shake", "500"));
    }
}
