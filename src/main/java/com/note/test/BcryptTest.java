package com.note.test;

import org.mindrot.jbcrypt.BCrypt;

public class BcryptTest {

	public static void main(String[] args) {
		
		String rawPassword = "123";
		String hashedPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
		System.out.println("Hashed Password: " + hashedPassword); // $2a$10$wFm2rFKJTrEIcTk.IG1nNeA24/3qKN8yQzCXX3UPlarXCv3fBDP16

		String candidatePassword = "123";
		boolean isPasswordMatch = BCrypt.checkpw(candidatePassword, hashedPassword);
		System.out.println("Password Match: " + isPasswordMatch);
	}

}
