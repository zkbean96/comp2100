import java.io.*;


public class Test {
    public static void main(String[] args) throws Exception {
        String file = "src/src/map.txt";
        MyMap map = MyMap.readMap(file);
        System.out.println("-----------------");

        System.out.println(map.getWidth() + "  " + map.getLength());

        for (int i = 0; i < map.getLength(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                System.out.print(map.getMap(i, j));
            }
            System.out.println("");
        }
    }


}
