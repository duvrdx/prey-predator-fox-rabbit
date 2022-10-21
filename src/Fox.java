public class Fox extends Animal{
    private int hungerGenMax;
    private int hungerGen;

    public int getHungerGenMax() {
        return this.hungerGenMax;
    }

    public void setHungerGenMax(int hungerGenMax) {
        this.hungerGenMax = hungerGenMax;
    }

    public int getHungerGen() {
        return this.hungerGen;
    }

    public void setHungerGen(int hungerGen) {
        this.hungerGen = hungerGen;
    }

    Fox(int procreateGen, int hungerGenMax){
        super(procreateGen);
        this.hungerGenMax = hungerGenMax;
        hungerGen = 0;
    }

    public void eat(){
        this.hungerGen = 0;
    }

}
