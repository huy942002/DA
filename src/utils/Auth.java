/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Entity.*;
//
///**
// *
// * @author User
// */
public class Auth {
    public static NhanVien user = null;
    public static VaiTro vaitro = null;
    public static void clear(){
      Auth.user = null;
    }
    public static boolean isLogin() {
        return Auth.user != null;
    }
    public static boolean isManager() {
        return Auth.isLogin()&&vaitro.isVaiTro();
    }
    public static int iSMaNV(){
        if (Auth.isLogin())return Auth.user.getManv();
        return 0;
    } 
            
}
