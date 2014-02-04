package com.imaginea;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author Nitin Gurram [nitin.gurram@imaginea.com]
 * 
 */
public class MinimumCostPicker {
    public static String run(String[] args) throws Exception {

        List<Restaurant> restaurantList = getRestaurantsDetails(args[0]);
        List<Item> itemsToSearch = new ArrayList<Item>();

        for (int i = 1; i < args.length; i++) {
            itemsToSearch.add(new Item(args[i]));
        }

        return findRestaurant(restaurantList, itemsToSearch);

    }

    /**
     * @param restaurantList
     * @param itemsToSearch
     */
    private static String findRestaurant(List<Restaurant> restaurantList, List<Item> itemsToSearch) {
        double minPrice = Double.MAX_VALUE;
        Restaurant minPriceRest = null;
        for (Restaurant restaurant : restaurantList) {
            double price = 0;
            for (Item item : itemsToSearch) {
                if (restaurant.getItems().indexOf(item) >= 0) {
                    price += restaurant.getItems().get(restaurant.getItems().indexOf(item)).getPrice();
                } else {
                    price = Double.MAX_VALUE;
                    break;
                }
            }
            if (price < minPrice) {
                minPrice = price;
                minPriceRest = restaurant;
            }
        }

        if (minPriceRest != null)
            return minPriceRest.getName() + " " + minPrice;
        return null;
    }

    /**
     * @param restaurantList
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static List<Restaurant> getRestaurantsDetails(String fileName) throws FileNotFoundException, IOException {
        List<Restaurant> restaurantList = new ArrayList<Restaurant>();
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(fileName));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Restaurant restaurant = new Restaurant();
                restaurant.setName(StringUtils.trim(nextLine[0]));
                restaurant.setItems(new ArrayList<Item>());
                if (!restaurantList.contains(restaurant)) {
                    restaurantList.add(restaurant);
                } else {
                    restaurant = restaurantList.get(restaurantList.indexOf(restaurant));
                }
                Item item = new Item();
                item.setPrice(Double.parseDouble(nextLine[1]));
                StringBuffer sb = new StringBuffer();
                for (int i = 2; i < nextLine.length; i++) {
                    sb.append(StringUtils.trim(nextLine[i]) + ",");
                }
                sb.replace(sb.length() - 1, sb.length(), "");
                item.setName(sb.toString());

                restaurant.getItems().add(item);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return restaurantList;
    }
}
