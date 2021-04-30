import java.io.BufferedReader;
import java.io.FileReader;

public class MyMap {

    /**
     * . is road
     * # is barrier
     * @ is a thing that to be collected
     */

    /**
     * the cnt of treasure
     */
    private int treasureCnt;
    /**
     * the width of map ,
     * the length of map
     */
    private int width, length;

    private char map[][];

    /**
     * the x position of pokeman
     * the y position of pokeman
     */
    int x, y;

    public enum Type {
        ROAD("road", '*'),
        BARRIER("barrier", '#'),
        TREASURE("treasure", '@');
        String describe;
        char symbol;

        Type(String describe, char c) {
            this.describe = describe;
            this.symbol = c;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public char getSymbol() {
            return symbol;
        }

        public void setSymbol(char symbol) {
            this.symbol = symbol;
        }

        static Type getBySymbol(char c) {
            if (c == '.') {
                return ROAD;
            } else if (c == '#') {
                return BARRIER;
            }
            return TREASURE;
        }
    }

    public void setMap(int x, int y, char ch) {
        map[x][y] = ch;
    }

    public char getMap(int x, int y) {
        return map[x][y];
    }

    public MyMap(int width, int length) {
        this.width = width;
        this.length = length;
        //   System.out.println("ccc w l "+width+"  " +length);
        map = new char[length + 1][width + 1];
    }

    public int getTreasureCnt() {
        return treasureCnt;
    }

    public void setTreasureCnt(int treasureCnt) {
        this.treasureCnt = treasureCnt;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Type getTypeByPosition(int x, int y) {
        return Type.getBySymbol(map[x][y]);
    }


    static public MyMap readMap(String file) throws Exception {

        FileReader reader = new FileReader(file);

        int width = -1, length = 0;

        BufferedReader bf = new BufferedReader(reader);
        String line = "";
        while ((line = bf.readLine()) != null) {
            //  System.out.println(line);
            width = line.trim().length();
            length++;
        }

        MyMap map = new MyMap(width, length);

        reader = new FileReader(file);
        bf = new BufferedReader(reader);
        line = "";
        int index = 0;
        char t[][] = new char[length + 1][width + 1];
        while ((line = bf.readLine()) != null) {
            // System.out.println(line);
            t[index++] = line.toCharArray();
        }
        map.setMap(t);

        return map;
    }

}
