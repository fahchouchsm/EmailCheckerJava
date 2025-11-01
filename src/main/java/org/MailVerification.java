package org;

public class MailVerification {
    private String email;

    MailVerification(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public boolean verifyEmail() {
        if(email == null || email.isEmpty()) return false;
        email = email.toLowerCase().trim();

        if (email.substring(0 ,email.indexOf('@')).length() < 3){ //check the name length is 2 char before @
            return false;
        }

        String domain = email.substring(email.indexOf('@'));
        String subDomains = domain.substring(domain.indexOf('.') + 1);
        String[] subDomainsArr = subDomains.split("\\.");

        if (calcAChar(email, '@') != 1) { // check if there is one at
            return false;
        }

        if(domain.substring(0, domain.indexOf('.')).length() < 2){ // check if there is 2 char between @ and .
            return false;
        }

        if(calcAChar(subDomains, '.') == 0){ // if there is . in the domain
            return false;
        }

        for(String c:subDomainsArr) { // checking length of subdomains 2 char
            if(c == null || c.length() < 2){
                return false;
            }
        }

        return true;
    }

    private int calcAChar(String s, char c) {
        int count = 0;
        for(char e: s.toCharArray()) {
            if(e == c) count++;
        }
        return count;
    }

    public static void main(String[] args){
        MailVerification m = new MailVerification("si.mofff0@qq.com.ja");

        if (m.verifyEmail()) {
            System.out.println("all good");
        } else {
            System.out.println("error");
        }
    }

}
