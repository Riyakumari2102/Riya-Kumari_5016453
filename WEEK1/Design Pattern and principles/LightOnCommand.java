// Command.java

/**
 * An interface representing a command.
 */
public interface Command {
    void execute();
}

// LightOnCommand.java

/**
 * A concrete class representing a light on command that implements Command.
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// LightOffCommand.java

/**
 * A concrete class representing a light off command that implements Command.
 */
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// RemoteControl.java

/**
 * A class representing a remote control that holds a reference to a Command and
 * a method to execute the command.
 */
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Light.java

/**
 * A class representing a light with methods to turn on and off.
 */
public class Light {
    public void turnOn() {
        System.out.println("Light is on");
    }

    public void turnOff() {
        System.out.println("Light is off");
    }
}

// CommandPatternExample.java

/**
 * A test class to demonstrate issuing commands using the RemoteControl.
 */
public class CommandPatternExample {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(new LightOnCommand(light));
        remoteControl.pressButton();

        remoteControl.setCommand(new LightOffCommand(light));
        remoteControl.pressButton();
    }
}