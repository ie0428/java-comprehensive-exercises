package StreamDemo;

import java.util.*;

public class Room {
   //1.准备好54张牌，定义一个集合用来存放54张牌
    private List<Card> allCards=new ArrayList<>();
    //2.来初始化54张牌,使用代码块
    {
        //准备花色
        String[] colors={"♥", "♦", "♣", "♠"};
        //准备点数
        String[] sizes={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
    //3.将花色和点数组合得到54张牌存放到集合中
        int num = 0;
        for (String size : sizes) {
            num++;
            for (String color : colors) {
                // 创建牌对象
                Card card = new Card(size, color,num);
                // 加入到集合中去
                allCards.add(card);
            }
        }
        //添加大小王
        allCards.add(new Card("","🃏",++num));
        allCards.add(new Card("","👲",++num));
        //Collections.addAll(allCards, new Card("", "🃏", ++num), new Card("", "👲", ++num));
        System.out.println("新牌是："+allCards);
    }
    //4.游戏开始
    public void start(){
        //1.洗牌
        Collections.shuffle(allCards);
        System.out.println("洗牌后："+allCards);
        //2.定义三个玩家集合
        List<Card> player1=new ArrayList<>();
        List<Card> player2=new ArrayList<>();
        List<Card> player3=new ArrayList<>();
        //3.发牌，定义map集合用来储存玩家和牌
        Map<String,List<Card>> players=new HashMap<>();
        players.put("player1",player1);
        players.put("player2",player2);
        players.put("player3",player3);
        // allCards = [7♠, 6♣, K♦, J♠, 2♠, 2♥, 9♠, 10♣, J♣, 8♦, 7♣, 8♣, 7♦, 3♥, 10 ...
        // 只发出去51张：0   1    2   3   4   5   6   7 ...
        for (int i = 0; i < allCards.size()-3; i++) {
            //获取当前遍历的牌
            Card card = allCards.get(i);
            //判断这张牌属于谁
            if(i%3==0){
                player1.add(card);
            }else if(i%3==1){
                player2.add(card);
            }else{
                player3.add(card);
            }

        }
        //4.获取底牌
        List<Card> lastCards = allCards.subList(allCards.size()-3, allCards.size());
        System.out.println("底牌是："+lastCards);
        //抢地主,随机一个人为地主
        String key = players.keySet().toArray()[new Random().nextInt(players.size())].toString();
        //将牌添加给地主
        players.get(key).addAll(lastCards);
        //5.对牌排序
        sortCards(player1);
        sortCards(player2);
        sortCards(player3);

        //6.遍历map集合，打印出玩家的牌
        for (Map.Entry<String, List<Card>> entry : players.entrySet()) {
            System.out.println(entry.getKey()+"的牌是："+entry.getValue());
        }

    }

    private void sortCards(List<Card> cards) {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o2.getNum() - o1.getNum();
                }
            });
        }
    }

