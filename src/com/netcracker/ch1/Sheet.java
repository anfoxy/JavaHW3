package com.netcracker.ch1;

public class Sheet {

   private int width ;
   private int height;
   private String name;

   public Sheet() {
       width =  841;
       height = 1189;
       name = "A0";
   }


    @Override
    public String toString() {
        return "Sheet{" +
                "width=" + width +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }

    public Sheet cutInHalf(){

      Sheet sheet =  new Sheet();
      if(height>width) {
          sheet.setHeight(this.width);
          sheet.setWidth(this.height / 2);
      }
      else {
          sheet.setWidth(this.height);
          sheet.setHeight(this.width / 2);
      }

      int newName =  Integer.parseInt(name.substring(name.length() - 1))+1;
      sheet.setName("A"+newName);
      return sheet;
    }

    private void setWidth(int width) {
        this.width = width;
    }

    private void setHeight(int height) {
        this.height = height;
    }

    private void setName(String name) {
        this.name = name;
    }
}
