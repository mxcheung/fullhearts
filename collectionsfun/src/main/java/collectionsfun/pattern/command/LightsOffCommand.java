package collectionsfun.pattern.command;

//Concrete Command
public class LightsOffCommand implements Command {
	// reference to the light
	Light light;

public LightsOffCommand(Light light){
  this.light = light;
}

	public void execute() {
		System.out.println("switchOff");
		light.switchOff();
	}
}