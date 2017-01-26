# CryptographyAndroid
CryptographyAndroid is a complements ```javax.crypto.Cipher``` and ```java.security.KeyStore``` to make it much easier to encrypt and decrypt
your data. CryptographyAndroid stores cryptographic keys in the **keyStore**. 


#RSA and AES
CryptographyAndroid uses **RSA** and **AES** to cryptography your data.
* **<a href="https://developer.android.com/reference/javax/crypto/Cipher.html">AES</a>**
is a symmetric cryptographic algorithm. symmetric means there is one key will be used for encryption and decryption.
AES supports a block length of 128 bits and key lengths of 128, 192, and 256 bits.
  * AES in CryptographyAndroid library uses **128 bits** as key length.
* **<a href="https://developer.android.com/reference/javax/crypto/Cipher.html">RSA</a>**
is an asymmetric cryptographic algorithm. Asymmetric means that there are two different keys
  * **Puplic key** is used to encrypt messages, can be known to everyone.
  * **Private key** is used to decrypt messages, must be kept in a secure place.
  
  
#KeyStore
**<a href="https://developer.android.com/training/articles/keystore.html">KeyStore</a>**
represents a storage facility for cryptographic keys and certificates.
KeyStore stores cryptographic keys in a container to make it more difficult to extract from the device


#EXAMPLE:
```java 
    private String message = "i want to encrypt this message, it is very important message";
    private static final String MESSAGE_KEY_STORE_ALIAS = "keyStoreAliasForMessage";
    
    
    CryptographyManager cryptographyManager = new CryptographyManager(this);

        try {
            String cipherMessage = cryptographyManager.encrypt(message, MESSAGE_KEY_STORE_ALIAS);
            Toast.makeText(this, cipherMessage, Toast.LENGTH_SHORT).show();

            String decryptedMessage = cryptographyManager.decrypt(cipherMessage, MESSAGE_KEY_STORE_ALIAS);

            Toast.makeText(this, decryptedMessage, Toast.LENGTH_SHORT).show();

            Log.i(TAG, " Does decrypted message equals the original one : " 
            + Boolean.toString(message.equals(decryptedMessage)));

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
        
```
#Download
  * **Via maven**
  ```xml
  <dependency>
  <groupId>com.github.fhdalotaibi</groupId>
  <artifactId>android-cryptography</artifactId>
  <version>1.0.0</version>
  <type>aar</type>
  </dependency> 
```
  * **via gradle**
  ``` 
  compile 'com.github.fhdalotaibi:android-cryptography:1.0.0'
  ```
