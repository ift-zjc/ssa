//package com.ift.web.controller;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.sql.ResultSet;
//import java.text.DecimalFormat;
//import java.text.DecimalFormatSymbols;
//import java.util.Locale;
//
//public class SatelliteController {
//
//    //Create Json Array from database
//  public static JSONArray convertResultSetIntoJSON(ResultSet resultSet) throws Exception {
//      JSONArray jsonArray = new JSONArray();
//      while (resultSet.next()){
//          int total_rows = resultSet.getMetaData().getColumnCount();
//          JSONObject obj = new JSONObject();
//          for (int i = 0; i < total_rows; i++) {
//              String columnName = resultSet.getMetaData().getColumnLabel(i+1).toLowerCase();
//              Object columnValue = resultSet.getObject(i+1);
//
//              if (columnValue == null){
//                  columnValue = "null";
//              }
//
//              if (obj.has(columnName)){
//                  columnName += "1";
//              }
//              obj.put(columnName, columnValue);
//          }
//          jsonArray.put(obj);
//      }
//      return jsonArray;
//  }
//
//  public static int convertBooleanIntoInt(boolean boo1){
//      if(boo1) return 1;
//      else return 0;
//  }
//
//  public static int convertBooleanStringIntoInt(String boo1){
//      if (boo1.equals("false")) return 0;
//      else if (boo1.equals("true")) return 1;
//      else {
//          throw new IllegalArgumentException("wrong value is passed to the method. Value is " + boo1);
//      }
//  }
//
//  public static double getDoubleOutOfString(String value, String format, Locale locale){
//      DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(locale);
//      otherSymbols.setDecimalSeparator('.');
//      DecimalFormat f = new DecimalFormat(format,otherSymbols);
//      String formattedValue = f.format(Double.parseDouble(value));
//      double number = Double.parseDouble(formattedValue);
//      return Math.round(number*100.0) / 100.0;
//  }
//}
