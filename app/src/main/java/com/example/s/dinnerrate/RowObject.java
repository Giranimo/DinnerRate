package com.example.s.dinnerrate;

/**
 * Created by Administrator on 31-10-2014.
 */
public class RowObject {
    private  String RestuarentName ="";
    private  String Rating ="";
    private  int Image;



    public void setRestuarentName(String CompanyName)
    {
        this.RestuarentName = CompanyName;
    }

    public void setImage(int Image)
    {
        this.Image = Image;
    }

    public void setRating(String Url)
    {
        this.Rating = Url;
    }



    public String getRestuarentName()
    {
        return this.RestuarentName;
    }

    public int getImage()
    {
        return this.Image;
    }

    public String getRating()
    {
        return this.Rating;
    }
}

