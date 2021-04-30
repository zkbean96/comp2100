import java.util.Random;

public class Pokemon {
    /*
    Fire attacks:
    Fire: 1/2x damage
    GRASS: 2x damage
    WATER: 1/2x damage

    GRASS attacks:
    Fire: 1/2x damage
    GRASS: 1/2x damage
    WATER: 2x damage

    WATER attacks:
    Fire: 2x damage
    GRASS: 1/2x damage
    WATER: 1/2x damage
    */

    public enum Type
    {
       FIRE,GRASS,WATER
    }

    /*
    Ok: normal
    Burn(BRN): halves damage dealt by an opponent
    Paralysis(PAR): reduces an opponent's speed by 20% if been attacked
    Freeze(FRZ): a Pokémon is unable to use moves
    Poison(PSN): damage equal to 1/16 of its maximum HP every turn
    */
    public enum Status
    {
        OK,BRN,PAR,FRZ,PSN
    }

    // total number of Pokémons that players have collected
    public static int pokeCount = 0;
    // Pokemon name
    private String nickname;

    // Pokemon health points
    public int hp;

    public int attack;

    public int defense;

    // Pokemon energy to attack
    // 1 energy = 10 atk power
    protected int energy = 5;

    // Pokemon abilities
    // an ability might be stronger but will need more energy
    protected Ability uniqueAbility;

    // Level and experience pts
    int level,exp;

    // default pokemon constructor
    public Pokemon(){
        nickname = Integer.toString(++pokeCount);
        hp = 100;
        uniqueAbility = new Ability();
        // System.out.println("A new pokemon has been created!");
    }

    // pokemon constructor
    public Pokemon(String nickname, int hp, Ability ab) {
        this.nickname = nickname;
        this.hp = hp;
        uniqueAbility = ab;
        // System.out.println("A new pokemon has been created!");
    }


    // setters
    // name
    public void setName(String nickname){
        this.nickname = nickname;
    }
    // hp
    public void setHp(int hp) {
        this.hp = hp;
    }
    // attack
    public void setAttack(int attack) {
        this.attack = attack;
    }
    // attack
    public void setDefense(int attack) {
        this.defense = defense;
    }
    // energy
    public void setEnergy(int e){
        energy = e;
    }
    // ability
    public void setAbility(Ability ab){
        uniqueAbility = ab;
    }


    // getters
    public String getName(){
        return nickname;
    }

    public int getHp(){
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getEnergy(){
        return energy;
    }

    public Ability getAbility(){
        return uniqueAbility;
    }


    // other methods
    // prints the pokemon's information
    public void printPokemon(){
        System.out.println("Pokemon created:");
        System.out.println("Name: " + nickname);
        System.out.println("Hp: " + hp);
        System.out.println("Energy: " + energy);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Ability: " + uniqueAbility.getName());
        System.out.println("Ability attack power: " + uniqueAbility.getAtkDmg());

    }


    // deals damage to another pokemon
    public int attack(Pokemon poke){
        // create a random generator
        Random r = new Random();
        int energyUsed = 0;
        // if there's enough energy
        // randomly choose the amount of energy to use
        // otherwise no damage will be considered because not enough energy
        if(energy > 1){
            // System.out.println("Energy before:" + energy);
            energyUsed = r.nextInt(energy) + 1;
        }
        else {
            System.out.println(nickname + " doesn't have enough energy!");
        }

        // multiply the amount of energy by 10
        int dealtDmg = energyUsed * 10;

        // substract energyUsed from the total energy
        // adds 1 energy per turn
        energy = energy - energyUsed + 1;
        // System.out.println("Pke energy:" + energy);

        // set the other poke's hp
        poke.setHp(poke.getHp() - dealtDmg);

        return dealtDmg;
    }
}
