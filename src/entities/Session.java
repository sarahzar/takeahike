 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author asus-pc
 */
public class Session {
    private static Utilisateur user ;

	public static Utilisateur getUser() {
		return user;
	}

	public static void setUser(Utilisateur user) {
		Session.user = user;
	}
}
