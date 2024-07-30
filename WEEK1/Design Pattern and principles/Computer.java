public class Computer {
    private final String cpu;
    private final int ram;
    private final int storage;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    // Getters
    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public static class ComputerBuilder {
        private String cpu;
        private int ram;
        private int storage;

        public ComputerBuilder withCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder withRam(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder withStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder()
                .withCpu("Intel i7")
                .withRam(16)
                .withStorage(512)
                .build();

        System.out.println(computer.getCpu());
        System.out.println(computer.getRam());
        System.out.println(computer.getStorage());
    }
}
