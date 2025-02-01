package StreamDemo;

public class Game {
    public static void main(String[] args) {
        //目标：开发一个斗地主游戏
        //1.准备牌类，每张牌都是一个对象
        //2.游戏房间也是一个对象，定义房间类
        Room room = new Room();
        room.start();

    }
}
