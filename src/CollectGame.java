
import java.util.Locale;
import java.util.Scanner;

public class CollectGame {
    static MyMap map;
    static int posx, posy;

    public static void main(String[] args) throws Exception {
        System.out.println("welcome to the treasure collection game!");
        String file = "src/src/map.txt";
        map = MyMap.readMap(file);
        System.out.println("here is the map: (. is road\t" +
                "    # is barrier\t" +
                "    @ is a thing that to be collected ) ");
        for (int i = 0; i < map.getLength(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                System.out.print(map.getMap(i, j));
            }
            System.out.println("");
        }
        System.out.println("the length of map is " + map.getLength() + ", and  the width of the map is " + map.getWidth());
        System.out.println("\n At first , you are in the lower  left  corner of the map and your coordinates is (" + (map.getLength() - 1) + " , 0)");
        posx = map.getLength() - 1;
        posy = 0;
        while (true) {
            String strDir = prompt();
            Direction direction = Direction.getDirection(strDir);
            if(direction == null){
                System.out.println("I can not understand your words~ plz input again!");
                continue;
            }
            int[] changes = direction.getChange();

            if (!isValid(posx + changes[0], posy + changes[1])) {
                System.out.println("you will be out of the map or you will encounter a barrier , plz input again~ ");
                showPositon();
                continue;
            } else {
                posx = posx + changes[0];
                posy = posy + changes[1];
                MyMap.Type type = map.getTypeByPosition(posx, posy);
                showPositon();
                System.out.println("type = " + type);
                System.out.println("now , you encounter a " + type);
                switch (type) {
                    case ROAD:
                        System.out.println("Wow ! you are in another road ! ");
                        break;
                    case TREASURE:
                        System.out.println("Oops!!! you take the treasure !");
                        map.setMap(posx, posy, '.');  // treasure become a road after it has been taken
                        break;
                }
            }
        }

    }

    static void showPositon() {
        System.out.println("You are in the (" + posx + "," + posy + ") now!");
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < map.getLength() && y >= 0 && y < map.getWidth()
                && map.getTypeByPosition(x, y) == MyMap.Type.ROAD ||
                map.getTypeByPosition(x, y) == MyMap.Type.TREASURE ? true : false;
    }

    static String prompt() {
        System.out.println("***********************************************************************");
        System.out.println("plz input a direction you want to move : (north , south , east , west) ");
        System.out.println("***********************************************************************");
        String in = new Scanner(System.in).nextLine();
        return in.trim();
    }

    public enum Direction {
        NORTH("north", -1, 0), SOUTH("south", 1, 0),
        EAST("east", 0, 1), WEST("west", 0, -1);

        String dir;
        int xchange, ychange;

        Direction(String dir, int xchange, int ychange) {
            this.dir = dir;
            this.xchange = xchange;
            this.ychange = ychange;
        }

        int[] getChange() {
            int[] res = new int[2];
            res[0] = this.xchange;
            res[1] = this.ychange;
      /*       switch (direction){
                 case EAST:
                     res[0] = EAST.xchange;
                     res[1] = EAST.ychange;
                     break;
                 case WEST:
                     res[0]= WEST.xchange;
                     res[1] = WEST.ychange;
                     break;
                 case NORTH:
                     res[0] = NORTH.xchange;
                     res[1] = NORTH.ychange;
                 case SOUTH:
                     res[0] = SOUTH.xchange;
                     res[1] = SOUTH.ychange;
                     break;
             }*/
            return res;
        }

        static Direction getDirection(String str) {
            switch (str.toLowerCase(Locale.ROOT)) {
                case "west":
                    return WEST;
                case "east":
                    return EAST;
                case "north":
                    return NORTH;
                case "south":
                    return SOUTH;
            }
            return null ;
        }
    }
}
