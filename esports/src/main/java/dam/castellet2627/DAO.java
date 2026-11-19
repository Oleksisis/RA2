/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package dam.castellet2627;


import java.util.List;

public interface DAO<T> {
   void add(T item);
   List<T> getAll();
   // List<T> getAll(String filter);
   // boolean checkPass(String name, String pass);
   // delete 
   // update
}
