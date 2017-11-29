package introduction;

public class Pokemon {

	private int level;
	private int hp;
	private String name;
	private boolean poisoned;

	public Pokemon(String name, int level) {
		this.name = name;
		this.level = level;
		hp = 100;
		poisoned = false;
	}
	
	public void levelUp(Effect e) {
		this.level++;
		e.happens();
	}

	public void iChooseYou() {
		System.out.println(name + " " + name);
	}

	public int getHP() {
		return hp;
	}

	public void setHP(int newHP) {
		hp = newHP;
	}

	public String getName() {
		return name;
	}

	public void setPoisoned(boolean b) {
		poisoned = b;
	}

	public void lapse() {
		if(poisoned) {
			hp -= 15;
		}
	}
	public static void main(String[] args) {
		Pokemon squirtle = new Pokemon("Squirtle", 26);
		Pokemon bulbasaur = new Pokemon("Bulbasaur", 26);
		squirtle.iChooseYou();
		bulbasaur.iChooseYou();
		System.out.println("Squirtle is preparing to attack with water blast.");
		squirtle.attack(bulbasaur, new Attack() {

			public void attack(Pokemon target) {
				int hp = target.getHP();
				target.setHP(hp/2);
			}
			
		});
		System.out.println("Bulbasaur is preparing to attack with poison.");
		bulbasaur.attack(squirtle, new Attack() {

			public void attack(Pokemon target) {
				target.setPoisoned(true);
			}
			
		});
		squirtle.lapse();
		bulbasaur.lapse();
		printScore(squirtle, bulbasaur);
		System.out.println("Squirtle is attacking again.");
		squirtle.attack(bulbasaur, new Attack() {
			
			public void attack(Pokemon target) {
				int old = target.getHP();
				target.setHP(old - 1);
			}
			
		});
		printScore(squirtle, bulbasaur); 
		squirtle.levelUp(new Effect() {
			
			public void happens(Pokemon pokemon) {
				
			}
			
		});
	}

	public static void printScore(Pokemon a, Pokemon b) {
		System.out.println(a.getName() + ", HP = " + a.getHP());
		System.out.println(b.getName() + ", HP = " + b.getHP());
	}

	public void attack(Pokemon target, Attack attack){
		if(Math.random() < .9){
			attack.attack(target);
			System.out.println("The attack hit!");
		}else{
			System.out.println("The attack missed!");
		}
	}

}
