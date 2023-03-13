package patterns;

public class Bridge {
    public static void main(String[] args) {
//        Computer-->OS структура
    }
}

abstract class Computer{
    OS currentOS;
    void startPC() {
        currentOS.prepareFileSystem();
        currentOS.boot();
    }
    void resetPC() {}

    class Macbook extends Computer{}
    class Dellbook extends Computer{}
    class Sonybook extends Computer{}
}

abstract class OS{
    abstract void boot();
    abstract void prepareFileSystem();

    class Windows extends OS{
        @Override
        void boot() {new String("BIOS");}
        @Override
        void prepareFileSystem() {new String("GPT");}
    }
    class MacOS extends OS{
        @Override
        void boot() {new String("EFI");}
        @Override
        void prepareFileSystem() {new String("MBR");}
    }
}


