package com.example.proyecto_final_grupo3;


import android.util.Base64;
import android.util.Log;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;


public class AES256 {
    private static final String TAG = "AESCrypt";
    private static final String AES_MODE = "AES/ECB/ZeroBytePadding";
    private static final String CHARSET = "UTF-8";
    public static boolean DEBUG_LOG_ENABLED = false;


    private static SecretKeySpec generateKey(final String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] key = password.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        return secretKeySpec;
    }



    /**
     * Decrypt and decode ciphertext using 256-bit AES with key generated from password
     *
     * @param password used to generated key
     * @param base64EncodedCipherText the encrpyted message encoded with base64
     * @return message in Plain text (String UTF-8)
     * @throws GeneralSecurityException if there's an issue decrypting
     */
    public static String decrypt(final String password, String base64EncodedCipherText)
            throws GeneralSecurityException {

        try {
            final SecretKeySpec key = generateKey(password);
            log("base64EncodedCipherText", base64EncodedCipherText);
            byte[] decodedCipherText = android.util.Base64.decode(base64EncodedCipherText, Base64.DEFAULT);
            log("decodedCipherText", decodedCipherText);
            byte[] decryptedBytes = decrypt(key, decodedCipherText);
            log("decryptedBytes", decryptedBytes);
            String message = new String(decryptedBytes, CHARSET);
            log("message", message);
            return message;
        } catch (UnsupportedEncodingException e) {
            if (DEBUG_LOG_ENABLED)
                Log.e(TAG, "UnsupportedEncodingException ", e);
            throw new GeneralSecurityException(e);
        }
    }


    /**
     * More flexible AES decrypt that doesn't encode
     *
     * @param key AES key typically 128, 192 or 256 bit
     * @param decodedCipherText in bytes (assumed it's already been decoded)
     * @return Decrypted message cipher text (not encoded)
     * @throws GeneralSecurityException if something goes wrong during encryption
     */
    public static byte[] decrypt(final SecretKeySpec key, final byte[] decodedCipherText)
            throws GeneralSecurityException {
        final Cipher cipher = Cipher.getInstance(AES_MODE );

        cipher.init(Cipher.DECRYPT_MODE, key);//, ivSpec
        byte[] decryptedBytes = cipher.doFinal(decodedCipherText);
        log("decryptedBytes", decryptedBytes);
        return decryptedBytes;
    }




    private static void log(String what, byte[] bytes) {
        if (DEBUG_LOG_ENABLED)
            Log.d(TAG, what + "[" + bytes.length + "] [" + bytesToHex(bytes) + "]");
    }

    private static void log(String what, String value) {
        if (DEBUG_LOG_ENABLED)
            Log.d(TAG, what + "[" + value.length() + "] [" + value + "]");
    }


    /**
     * Converts byte array to hexidecimal useful for logging and fault finding
     * @param bytes
     * @return
     */
    private static String bytesToHex(byte[] bytes) {
        final char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
                '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

}
