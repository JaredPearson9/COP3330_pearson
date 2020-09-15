public class Encrypter {

    public static String encrypt(String input){

        //Translates a string into a sequences of integers and encrypts them
        int[] num = importAndEncrypt(input);

        //swaps the sequence of integers according to the encryption algorithm
        num = swap(num);

        //produces the encrypted string from the sequence of integers
        String encryptedNum = "";
        for(int i =0; i<4; i++) {
            encryptedNum = encryptedNum + num[i];
        }
        return encryptedNum;
    }

    public static int[] swap(int[] num){
        int temp = 0;
        temp= num[0];
        num[0]=num[2];
        num[2]= temp;

        temp= num[1];
        num[1]=num[3];
        num[3]= temp;

        return num;
    }

    public static int [] importAndEncrypt(String input){
        int[] num = new int[input.length()];
        char [] digits = input.toCharArray();

        for(int index = 0; index < 4; index++){

            int temp1 = digits[index] - '0';

            temp1 = temp1 + 7;
            temp1 = temp1 % 10;

            num[index] = temp1;
        }

        return num;
    }
}