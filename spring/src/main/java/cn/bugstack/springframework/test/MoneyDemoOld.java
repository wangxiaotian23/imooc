package cn.bugstack.springframework.test;

import java.text.DecimalFormat;

/**
 * @Auther: 李清依
 * @Date: 2022/11/4 16:42
 * @Description:
 */
interface IMoneyFormate {
    String formate(int money);
}

class MyMoney1 {
    private final int money;
    public MyMoney1(int money) {
        this.money = money;
    }
    public void printMoney(IMoneyFormate moneyFormat) {
        System.out.println("我的存款：" + moneyFormat.formate(this.money));
    }
}

public class MoneyDemoOld {
    public static void main(String[] args) {
        MyMoney1 me = new MyMoney1(99999999);
        me.printMoney( i -> new DecimalFormat("#,###")
                .format(i));
    }
}
