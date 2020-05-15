import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * @program: 2020513
 * @description
 * 扑克牌游戏
 * @author: mrs.yang
 * @create: 2020 -05 -14 12 :12
 */
class Card{
    public String suits;//花色
    public int rank;//牌面值

    @Override
    public String toString() {

        return String.format("[%s,%d]",suits,rank);
    }

    public Card( int rank,String suits) {
        this.suits = suits;
        this.rank = rank;
    }
}

public class CardDemo {
    public static final String[] SUITS={"♥","♦","♠","♣"};//初始化
    //1.买牌52  1-->13
    public static List<Card> buyCard(){
        List<Card> deck=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                int rank=j;
                String suits=SUITS[i];
                Card card=new Card(rank,suits);
                deck.add(card);
            }
        }
        return deck;
    }
    private static void swap(List<Card> deck,int index,int i){
        //tmp=[index] [index]=[i]  [i]=[index]
        Card tmp=deck.get(index);
        deck.set(index,deck.get(i));
        deck.set(i,tmp);
    }
//洗牌,随机排序，从后往前随机替换
    public static void shuffle(List<Card> deck){
        for (int i = deck.size()-1; i >0 ; i--) {
            Random random=new Random();
            int index=random.nextInt(i);//[0,i)
            swap(deck,index,i);
        }
    }
    public static void main(String[] args) {
      List<Card> deck=buyCard();
        System.out.println(deck);
        shuffle(deck);
        System.out.println(deck);
        //将每个人手中的牌各存放在一个数组中
        //揭牌  3个人轮流每人揭5张
        List<List<Card>> hand=new ArrayList<>();
        List<Card> hands1=new ArrayList<>();
        List<Card> hands2=new ArrayList<>();
        List<Card> hands3=new ArrayList<>();
        hand.add(hands1);
        hand.add(hands2);
        hand.add(hands3);
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <3 ; j++) {
                Card card=deck.remove(0);
                hand.get(j).add(card);
            }
        }
        System.out.println("第1个人的牌");
        System.out.println(hands1);
        System.out.println("第2个人的牌");
        System.out.println(hands2);
        System.out.println("第3个人的牌");
        System.out.println(hands3);

    }
}
