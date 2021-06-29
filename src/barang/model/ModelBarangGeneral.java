
package barang.model;

import barang.controller.ControllerBarang;
import barang.database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelBarangGeneral {
    private Connection connection;
    private Statement statement;

    public ModelBarangGeneral(){
        DBConnect dbConnect = new DBConnect();
        connection = dbConnect.getConnection();
    }
     public String getData(String column, String table, String where, String value){
        try{
            String data = new String();
            statement = connection.createStatement();
            String query = "select "+column+" from "+table+" where "+where+" = '" + value + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data = resultSet.getString(column);
            }
            return data;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public String[] getData(String column, String table){
        try{
            int row = 1;
            String[] data = new String[numRows("barang")+1];
            statement = connection.createStatement();
            String query = "select "+column+" from "+table;
            ResultSet resultSet = statement.executeQuery(query);
            data[0] = "";
            while (resultSet.next()){
                data[row] = resultSet.getString(column);
                row++;
            }
            return data;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public int numRows(String table){
        int jmlData = 0;
        try{
            statement = connection.createStatement();
            String query = "select * from " + table;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public void updateData(String[] data){
        try{
            statement = connection.createStatement();
            String query = "update barang set nama = ?, massa = ?, harga = ? where id = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (4, data[0]);
            preparedStmt.setString (1, data[1]);
            preparedStmt.setDouble (2,Double.parseDouble(data[2]));
            preparedStmt.setDouble (3,Double.parseDouble(data[3])); //out of bound
            preparedStmt.execute();
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(String id){
        try {
            String query = " delete from barang where id = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, id);
            preparedStmt.execute();

            connection.close();

            JOptionPane.showMessageDialog(null, "Hapus Berhasil");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal! ");
        }
        ControllerBarang controllerBarang = new ControllerBarang();
        controllerBarang.readBarang();
    }

    public int numRows(String table, String where, String value){
        int jmlData = 0;
        try{
            statement = connection.createStatement();
            String query = "select * from " + table + " where " + where + " = '" + value + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }
}
