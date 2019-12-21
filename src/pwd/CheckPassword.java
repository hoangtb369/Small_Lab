/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwd;

import java.util.Scanner;

/**
 *
 * @author Hoang
 */
public class CheckPassword {

    public String checkPassword() {
        String password = "";
        Scanner sc = new Scanner(System.in);
        int character = 0, number = 0;
        while (true) {
            password = sc.nextLine();
            //Vong lap chay tung ki tu trong password
            for (int i = 0; i < password.length(); i++) {
                //kiem tra xem password co ki tu la chu khong
                if ((int) password.charAt(i) >= 65 && (int) password.charAt(i) <= 90) {
                    character += 1;
                } else if ((int) password.charAt(i) >= 97 && (int) password.charAt(i) <= 122) {
                    character += 1;
                } // kiem tra xem password co ki tu la so khong
                else if ((int) password.charAt(i) >= 48 && (int) password.charAt(i) <= 57) {
                    number += 1;
                }
            }
            //neu do dai password khong dung, hien loi va nhap lai password
            if (password.length() < 8 || password.length() > 31) {
                System.out.println("Password lentgh must be 8 to 31");
            }//neu password khong co so va chu, hien loi va nhap lai password
            else if (character == 0 || number == 0) {
                System.out.println("Password must include character and number");
            } else {    
                return password;
            }
        }

    }

    public static void main(String[] args) {
        String a = new CheckPassword().checkPassword();
    }

}
