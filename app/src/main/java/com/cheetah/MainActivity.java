package com.cheetah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.cheetah.cryptography.CryptographyManager;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    private String message = "i want to encrypt this message, it is very important message";
    private static final String MESSAGE_KEY_STORE_ALIAS = "keyStoreAliasForMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CryptographyManager cryptographyManager = new CryptographyManager(this);

        try {
            String cipherMessage = cryptographyManager.encrypt(message, MESSAGE_KEY_STORE_ALIAS);
            Toast.makeText(this, cipherMessage, Toast.LENGTH_SHORT).show();

            String decryptedMessage = cryptographyManager.decrypt(cipherMessage, MESSAGE_KEY_STORE_ALIAS);

            Toast.makeText(this, decryptedMessage, Toast.LENGTH_SHORT).show();

            Log.i(TAG, " Does decrypted message equals the original one : " + Boolean.toString(message.equals(decryptedMessage)));

        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (UnrecoverableEntryException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }


    }
}
