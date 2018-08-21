package Siker.Allegro;

import com.google.gson.annotations.SerializedName;

import java.util.List;


class Title
{
    String text;
    boolean bold;
    boolean superSeller;


    @Override
    public String toString()
    {
        return "Title{" + "text='" + text + '\'' + ", bold=" + bold + ", superSeller=" +
                        superSeller + '}';
    }
}


class Thumbnails
{
    String s128;


    @Override
    public String toString()
    {
        return "Thumbnails{" + "url='" + s128 + '\'' + '}';
    }
}


class Price
{
    @SerializedName( "normal" )
    public NormalPrice normal;


    @Override
    public String toString()
    {
        return "Price{" + "normal=" + normal + '}';
    }
}


class NormalPrice
{
    public String amount;
    public String currency;


    @Override
    public String toString()
    {
        return "NormalPrice{" + "amount='" + amount + '\'' + ", currency='" + currency + '\'' + '}';
    }
}


class Item
{
    Title title;
    Thumbnails thumbnails;
    String url;
    Price price;


    @Override
    public String toString()
    {
        return "Item{" + "title=" + title + ", thumbnails=" + thumbnails + ", url=" + url +
                        ", price=" + price + '}';
    }
}


class Group
{
    String title;
    List<Item> items;
    boolean sponsored;


    @Override
    public String toString()
    {
        return "Group{" + "title='" + title + '\'' + ", items=" + items + ", sponsored=" +
                        sponsored + '}';
    }
}


class Groups
{
    List<Group> itemsGroups;


    @Override
    public String toString()
    {
        return "Groups{" + "itemsGroups=" + itemsGroups + '}';
    }
}


class Items
{
    Groups items;


    @Override
    public String toString()
    {
        return "Items{" + "items=" + items + '}';
    }
}
