package utilities;

import java.security.MessageDigest;

public class MotdePasseCryteur {
	/*
	private static MotdePasseCryteur uniqueInstance = null;
    private BasicTextEncryptor textEncryptor;

    
    private MotdePasseCryteur() {
    	this.textEncryptor = new BasicTextEncryptor();
        this.textEncryptor.setPassword("keyMDPEncryptor"); // Clé secrete

    }
    
    public static MotdePasseCryteur getInstance() {
    	if(uniqueInstance == null) {
			uniqueInstance = new MotdePasseCryteur();
		}
		
		return uniqueInstance;
    }
    
    public String crypter(String mdp) {
        return this.textEncryptor.encrypt(mdp);
    }
    
    public String decrypter(String mdpChiffre) {
    	return this.textEncryptor.decrypt(mdpChiffre);
    }
    */
	public static void main(String[] args) {
        String password = "secret";
        String algorithm = "SHA";

        byte[] plainText = password.getBytes();

        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);

            md.reset();
            md.update(plainText);
            byte[] encodedPassword = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < encodedPassword.length; i++) {
                if ((encodedPassword[i] & 0xff) < 0x10) {
                    sb.append("0");
                }

                sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
            }

            System.out.println("Plain    : " + password);
            System.out.println("Encrypted: " + sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
