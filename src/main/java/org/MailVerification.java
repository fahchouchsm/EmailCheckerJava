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
//        checking length
        if (email.substring(0 ,email.indexOf('@')).length() < 3){
            return false;
        }
        String domain = email.substring(email.indexOf('@'));
        if(domain.substring(0, domain.indexOf('.')).length() < 3){
            return false;
        }
        else if (calcAChar(email, '@') != 1) { //algorithm
            return false;
        }else if(calcAChar(email.substring(email.indexOf('@')), '.') != 1){
            return false;
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
        MailVerification m = new MailVerification("si.mofff0@qq.com");
        String email = m.getEmail();
        String domain = email.substring(email.indexOf('@'));
        if(domain.substring(0, domain.indexOf('.')).length() < 3){
            System.out.println("here");
        }

        if (m.verifyEmail()) {
            System.out.println("all good");
        } else {
            System.out.println("error");
        }
    }

}
