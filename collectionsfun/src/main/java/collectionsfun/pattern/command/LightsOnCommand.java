package collectionsfun.pattern.command;

//Concrete Command
public class LightsOnCommand implements Command {
	// reference to the light
	Light light;

	public LightsOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		System.out.println("switchOn");
		light.switchOn();
	}
}