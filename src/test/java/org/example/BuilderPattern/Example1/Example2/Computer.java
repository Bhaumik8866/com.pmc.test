package org.example.BuilderPattern.Example1.Example2;

public class Computer {

    private String HDD;
    private String RAM;
    private String OS;
    private String screenType;
    private boolean graphicsCard;
    private boolean bluetooth;

    public void setHDD(String HDD) {
        this.HDD = HDD;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public void setGraphicsCard(boolean graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    Computer(ComputerBuilder builder){
        this.RAM= builder.RAM;
        this.HDD= builder.HDD;
        this.OS= builder.OS;
        this.screenType= builder.screenType;
        this.graphicsCard= builder.graphicsCard;
        this.bluetooth= builder.bluetooth;
    }
    //Builder class
    public static class ComputerBuilder {

        private String HDD;
        private String RAM;
        private String OS;
        private String screenType;
        private boolean graphicsCard;
        private boolean bluetooth;

        public ComputerBuilder setHDD(String hdd){this.HDD=hdd; return this;}
        public ComputerBuilder setRAM(String ram){this.RAM=ram; return this;}
        public ComputerBuilder setOS(String os){this.OS=os;return this;}
        public ComputerBuilder setScreenType(String screen){this.screenType=screen;return this;}
        public ComputerBuilder setGraphicsCard(boolean graphics){this.graphicsCard=graphics;return this;}
        public ComputerBuilder setBluetooth(boolean bt){this.bluetooth=bt;return this;}

        public Computer Build()
        {
            return new Computer(this);
        }

        @Override
        public String toString() {
            return "ComputerBuilder{" +
                    "HDD='" + HDD + '\'' +
                    ", RAM='" + RAM + '\'' +
                    ", OS='" + OS + '\'' +
                    ", screenType='" + screenType + '\'' +
                    ", graphicsCard=" + graphicsCard +
                    ", bluetooth=" + bluetooth +
                    '}';
        }
    }
}
