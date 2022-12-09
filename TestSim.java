package TestSim;
import java.util.*;

public class TestSim {
    static void mock_test(HashMap<String, String> questions){
        Scanner que = new Scanner(System.in);
        int total_score, score,number;

        total_score = questions.size();
        score = 0;
        number = 0;
        int counter = questions.size();
        Set<String> keySet = questions.keySet();//get all the key from the hashmap
        ArrayList<String> keyList = new ArrayList<>(keySet);//convert to arraylist
        while (counter > 0){
            number+=1;
            int size = keyList.size();//get the size of the arraylist
            int randIdx = new Random().nextInt(size);//then pick a random index number from the arraylist

            String rand_que = keyList.get(randIdx);//this line use to map the key/value pair from the hashmap and
            System.out.print(number+ ".)"+rand_que);// display to get the user answer
            String user_ans = que.nextLine();//user answer store here

            String answer = questions.get(rand_que);// get the correct answer by mapping the rand_que value from the hashmap

            if (Objects.equals(user_ans, answer)){//check the user answer if equal to the mapped value from the hashmap

                score+=1;
                System.out.println("Correct");

            }else{
                System.out.println("Wrong");
            }
            keyList.remove(rand_que);//once the key from the list is picked in rand_que, remove it the list of keys
            // to avoid repetition

            counter--;// everytime the loops run the counter is decrement to exit the loop
        }
        System.out.println(score + "/" + total_score);
    }
    public static void main(String[]args){
        //sample input
        HashMap<String, String> que_n_ans = new HashMap<>();
        que_n_ans.put("what is the meaning of pc: ", "personal computer");
        que_n_ans.put("1+1", "2");

        mock_test(que_n_ans);


    }
}
