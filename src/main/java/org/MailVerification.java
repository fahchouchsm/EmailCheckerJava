package org;

public class MailVerification {
    private String email;

    MailVerification(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean estValide() {
        if(email == null || email.isEmpty()) {
            System.out.println(0);
            return false;
        }
        email = email.toLowerCase().trim();

        if (calcAChar(email, '@') != 1) { // check if there is one at
            System.out.println(2);
            return false;
        }

        if(email.indexOf('@') < 2) {
            return false;
        }


        if (email.substring(0 ,email.indexOf('@')).length() < 3){ //check the name length is 2 char before @
            System.out.println(1);
            return false;
        }

        String domain = email.substring(email.indexOf('@'));
        String subDomains = domain.substring(domain.indexOf('.') + 1);
        String[] subDomainsArr = subDomains.split("\\.");


        if(calcAChar(domain, '.') == 0) {
            return false;
        }
        if(domain.substring(0, domain.indexOf('.')).length() < 2){ // check if there is 2 char between @ and .
            System.out.println(3);
            return false;
        }

        if(calcAChar(domain, '.') == 0){ // if there is . in the domain
            System.out.println(subDomains);
            System.out.println(4);
            return false;
        }

        for(String c:subDomainsArr) { // checking length of subdomains 2 char
            if(c == null || c.length() < 2){
            System.out.println(5);
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
        String mail = "user@example.com";
        MailVerification m = new MailVerification(mail);
        System.out.println(mail);
        System.out.println(m.estValide());
    }
}
