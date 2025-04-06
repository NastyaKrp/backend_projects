package com.example.fib;

import javax.crypto.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Cr{
    public static void DeEncr(String path, Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher_deencrypted = Cipher.getInstance("AES");
        cipher_deencrypted.init(Cipher.DECRYPT_MODE, key);
        byte[] cipher_deencrypted_Text = cipher_deencrypted.doFinal(new FileInputStream(path).readAllBytes());
        FileOutputStream fileOutputStream = new FileOutputStream("de" + path);
        fileOutputStream.write(cipher_deencrypted_Text);
        fileOutputStream.close();
    }

    public static Key Encr(String path) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher_encrypted = Cipher.getInstance("AES");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        Key key = keyGenerator.generateKey();
        cipher_encrypted.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher_encrypted.doFinal(new FileInputStream(path).readAllBytes());
        FileOutputStream fileOutputStream = new FileOutputStream("en" + path);
        fileOutputStream.write(cipherText);
        fileOutputStream.close();
        return key;
    }

    public static Key Encr(String path, String res_name) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher_encrypted = Cipher.getInstance("AES");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        Key key = keyGenerator.generateKey();
        cipher_encrypted.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher_encrypted.doFinal(new FileInputStream(path).readAllBytes());
        FileOutputStream fileOutputStream = new FileOutputStream(res_name);
        fileOutputStream.write(cipherText);
        fileOutputStream.close();
        return key;
    }
}
