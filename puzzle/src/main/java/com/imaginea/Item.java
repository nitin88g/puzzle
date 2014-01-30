package com.imaginea;

/**
 * @author Nitin Gurram [nitin.gurram@imaginea.com]
 * 
 */
public class Item implements Comparable<Item> {
    private String name;
    private double price;

    public Item() {
        // do nothing
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * @param name
     */
    public Item(String name) {
        this(name, 0);
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Item itemObj) {
        if (itemObj == null) {
            return 1;
        }
        return getName().compareTo(itemObj.getName());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (this.name == null) {
            if (other.name != null)
                return false;
        } else if (other.name.contains(this.name)) {
            return true;
        } else if (!this.name.equals(other.name)) {
            return false;
        }

        return true;
    }

}
