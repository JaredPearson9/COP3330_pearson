public class Decrypter {

    public static String decrypt(String input){

        //Translates a string into a sequences of integers and decrypts them
        int[] num = importAndDecrypt(input);

        //swaps the integers back to their original positions
        num = swap(num);

        //produces the decrypted string from the sequence of integers
        String decryptedNum = "";
        for(int i =0; i<4; i++) {
            decryptedNum = decryptedNum + num[i];
        }

        return decryptedNum;
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

    public static int [] importAndDecrypt(String input){
        int[] num;
        num = new int[input.length()];

        char [] arr = input.toCharArray();

        for(int index = 0; index < 4; index++){

            int temp1 = arr[index] - '0';

            if(temp1 > 6)
                temp1 = temp1 -7;
            else {
                temp1 = (temp1 +10) - 7;
            }

            num[index] = temp1;

        }

        return num;
    }
}