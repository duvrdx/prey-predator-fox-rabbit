public abstract class Animal{
    private int procreateGen;
    private int actualGen;
    private boolean isAlive;  
    private int x;
    private int y;

    public boolean isAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

    public int getProcreateGen() {
        return this.procreateGen;
    }

    public void setProcreateGen(int procreateGen) {
        this.procreateGen = procreateGen;
    }

    public int getActualGen() {
        return this.actualGen;
    }

    public void setActualGen(int actualGen) {
        this.actualGen = actualGen;
    }

    public Animal(int procreateGen){
        this.procreateGen = procreateGen;
        actualGen = 0;
        this.isAlive = true;
    }

    // Methods

    protected int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void move(int vertical, int horizontal){
        this.x += horizontal;
        this.y += vertical; 
    }

    public void walk(int xLimit, int yLimit){
        int choice = getRandomNumber(0,4);
        
        switch(choice){
            case 1:
                if(x + 1 < xLimit) x++;
                else x--;
                break;
            case 2:
                if(y + 1 < yLimit) y++;
                else y--;
                break;
            case 3:
                if(x - 1 >= 0) x--;
                else x++;
                break;
            case 0:
                if(y - 1 >= 0) y--;
                else y++;
                break;
        }

    }

    public void die(){
        this.isAlive = false;
    }

    public void setCoords(int x, int y){
        this.x = x;
        this.y = y;
    }
}