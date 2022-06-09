/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.dao;

import java.util.List;
import java.util.Optional;

/**
 *
 *@author Tan_Tan_Chin 
 */
public interface Dao<T> {
    List<T> getAll();
    Optional<T> get(int id);
    Optional<T> get(String id);
    int insert(T t);
    int update(T t);
    int delete(T t);
    int delete(String t);
    List<T> find(String t);
    List<T> find(T t);
    List<T> getList();
    int delete(String t,String x);
    int findT(String t);
    String getData(String dataIn,String colIn);
    List<T> find(String data,String colName);
    
    
}
