package recom;
 
import java.util.*;
 
public class Demo {
 
    public static void main(String[] args) {
 
        //输入用户总量
        UserSet userSet = new UserSet();
        userSet.put("张三")
                .set("华为手机", 50)
                .set("雷蛇鼠标", 30)
                .set("魅族手机", 45)
                .set("散热器", 50)
                .set("苹果手机", 30)
                .set("眼镜", 45)
                .set("vr眼镜", 50)
                .create();
 
        userSet.put("李四")
                .set("红米手机", 40)
                .set("魅族手机", 30)
                .set("苹果手机", 50)
                .set("眼镜", 50)
                .set("vr眼镜", 30)
                .set("vivo手机", 30)
                .create();
 
 
        userSet.put("小阳")
                .set("红米手机", 20)
                .set("华为手机", 50)
                .set("苹果手机", 30)
                .set("散热器", 50)
                .set("眼镜", 45)
                .set("oppo手机", 50)
                .create();
 
        userSet.put("王五")
                .set("红米手机", 50)
                .set("华为手机", 30)
                .set("苹果手机", 40)
                .set("ipad", 40)
                .set("oppo手机", 35)
                .set("vr眼镜", 35)
                .set("vivo手机", 45)
                .create();
 
        userSet.put("六爷")
                .set("红米手机", 20)
                .set("华为手机", 40)
                .set("魅族手机", 45)
                .set("散热器", 50)
                .set("苹果手机", 20)
                .create();
 
        userSet.put("三胖")
                .set("魅族手机", 50)
                .set("拯救者笔记本", 50)
                .set("苹果手机", 30)
                .set("oppo手机", 50)
                .set("雷柏键盘", 45)
                .set("散热器", 40)
                .set("vivo手机", 35)
                .create();
 
        userSet.put("Ross")
                .set("魅族手机", 50)
                .set("华为手机", 40)
                .set("苹果手机", 10)
                .set("Phoenix", 50)
                .set("MacBook", 40)
                .set("铁三角鼠标", 50)
                .create();
 
        userSet.put("Jay")
                .set("红米手机", 40)
                .set("苹果手机", 45)
                .set("ipad", 45)
                .set("MacBook", 25)
                .set("铁三角鼠标", 30)
                .create();
 
 
        Recommend recommend = new Recommend();
        List<UserSet.Set> recommendations = recommend.recommend("Jay", userSet);
        System.out.println("-----------------------");
        for (UserSet.Set set : recommendations) {
            System.out.println(set.username+" "+set.score);
        }
    }
 
 
}