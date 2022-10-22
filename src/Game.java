import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Game {
    private String[][] table;
    private int maxGeneration;
    private List<Rabbit> rabbitArray;
    private List<Fox> foxArray;

    public Game(int maxGeneration){
        table = new String[20][20];
        this.maxGeneration = maxGeneration;
        rabbitArray = new ArrayList<Rabbit>();
        foxArray = new ArrayList<Fox>(); 
    }

    public void start() throws InterruptedException{
        startTable();
        startFR();

        while(true){  
            updateFR();  
            printTable();
            Thread.sleep(700);
            clearConsole();
        }
    };

    public void printTable(){
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                System.out.printf("%s ", table[i][j]);
            }
            System.out.println();
        }
    }

    public void startFR(){
        for(int i = 0; i < 20; i++){
            if(i < 7) foxArray.add(new Fox(5, 3));
            rabbitArray.add(new Rabbit(3));
        }
    }

    public void startTable(){
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                table[i][j] = ConsoleColors.GREEN + "-";
            }
        }
    }

    public void updateFR(){

        for (Fox fox : foxArray){
            if(fox.isAlive()){
                table[fox.getX()][fox.getY()] = ConsoleColors.GREEN + "-";
                fox.walk(20, 20);
                table[fox.getX()][fox.getY()] =  ConsoleColors.YELLOW_BOLD +"F";
            }
            else{
                table[fox.getX()][fox.getY()] = ConsoleColors.GREEN + "-";
                foxArray.remove(fox);
            }
        }

        for (Rabbit rabbit : rabbitArray){
            if(rabbit.isAlive()){
                table[rabbit.getX()][rabbit.getY()] = ConsoleColors.GREEN + "-";
                rabbit.walk(20,20);
                table[rabbit.getX()][rabbit.getY()] = ConsoleColors.WHITE_BOLD + "R";
            } else{
                table[rabbit.getX()][rabbit.getY()] = ConsoleColors.GREEN + "-";
                rabbitArray.remove(rabbit);
            }
        }
    }

    public void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


}
