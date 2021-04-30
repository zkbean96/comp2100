public class Ability {
    // pokemon's ability name
    private String name;
    // ability's attack damage
    // damage pts is depend on the Type
    private int atkDmg;

    // default ability constructor
    public Ability() {
        name = "Normal Attack";
        atkDmg = 10;
    }

    // initialized ability constructor
    public Ability(String name, int atkDmg){
        this.name = name;
        this.atkDmg = atkDmg;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAtkDmg(int dmg) {
        atkDmg = dmg;
    }

    // getters
    public String getName(){
        return name;
    }

    public int getAtkDmg(){
        return atkDmg;
    }

}
