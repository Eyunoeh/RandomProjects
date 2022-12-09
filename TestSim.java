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
        HashMap<String, String> que_n_ans = new HashMap<>();

        que_n_ans.put("What are the four gathering techniques: ","survey interview observation documentation and records");
        que_n_ans.put("Is defined as the act of examining a process or questioning a selected sample of individuals to obtain data about a service,product, or process: ","survey");
        que_n_ans.put("Are used to collect data from a small group of subjects on a broad range of topics: ","interview");
        que_n_ans.put("Are comparable to a questionnaire, with the same questions in the same orderfor each subject and with multiple choice answers: ","structured interview");
        que_n_ans.put("Is a way of gathering data by watching behaviour, events, or noting physicalcharacteristics in their natural setting.","observation");
        que_n_ans.put("Based research uses existing data for a study","documentation and record");
        que_n_ans.put("It's the internal language that someone can use to make the RDBMS performvarious operations on its data: ","structured query language");
        que_n_ans.put("Relation name and attribute list (Beers(Name, Manf).","relation schema");
        que_n_ans.put("Collection of relation: ","database");
        que_n_ans.put("set of all relation schema in the database: ","database schema");
        que_n_ans.put("Which deals with database schemas and descriptions of how the datashould reside in the database: ","data definition language");
        que_n_ans.put("which deals with data manipulation and it is used to store, modify, retrieve,delete and update data in a database: ","data manipulation language");
        que_n_ans.put("Command used for viewing the list of databases: ","show databases;");
        que_n_ans.put("Command used to select which database to be used for other queries: ","use db_name");
        que_n_ans.put("Command used to create the database: ","create databases;");
        que_n_ans.put("Command used to show tables on the selected database: ","show tables;");
        que_n_ans.put("Ensures that the field cannot have a null value: ","not null");
        que_n_ans.put("Ensures that all values in a column are different: ","unique");
        que_n_ans.put("Uniquely identifies each record in a table: ","primary key");
        que_n_ans.put("Is a key used to link two tables together: ","foreign key");
        que_n_ans.put("Ensures that all values in a field satisfies a specific condition: ","check");
        que_n_ans.put("Is used to provide a default value for a column: ","default");

        mock_test(que_n_ans);


    }
}
