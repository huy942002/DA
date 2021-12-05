/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author User
 */
public abstract class DAO<E, K> {

    public abstract  void insert(E entity);

    public abstract  void update(E entity);

    public abstract  void delete(K id);

    public abstract List<E> selecALL();

    public abstract E selectById(K key);

    public abstract List<E> selectBySql(String sql, Object... args);

}
