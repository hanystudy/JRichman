package main.jrichman;

import javax.xml.bind.JAXBIntrospector;

/**
 * Created with IntelliJ IDEA.
 * User: hanyi
 * Date: 2/10/13
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerStatus {

    private String nickname;
    private int money;
    private int point;
    private String abbrname;
    private int mascot = 0;

    private PlayerState state = PlayerState.ACTIVE;
    private int lastDays = 0;

    public int getLastDays() {
        return lastDays;
    }

    public void setLastDays(int lastDays) {
        this.lastDays = lastDays;
    }

    public void update()
    {
        if( mascot > 0 )
            --mascot;
        if( state == PlayerState.ILL || state == PlayerState.JAIL )
        {
            --lastDays;
            if(lastDays == 0)
                state = PlayerState.ACTIVE;
        }
    }

    public void setState(PlayerState state) {
        this.state = state;
        if( state == PlayerState.ILL )
            lastDays += 3;
        else if( state == PlayerState.JAIL )
        {
            lastDays += 2;
        }
    }

    public PlayerState getState() {
        return state;
    }

    public PlayerStatus(String nn, String an, int mn, int po)
    {
        nickname = nn;
        abbrname = an;
        money = mn;
        point = po;
    }

    public String getNickname()
    {
        return nickname;
    }

    public int getMoney()
    {
        return money;
    }

    public int getPoint()
    {
        return point;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setNickname(String nickname) {

        this.nickname = nickname;
    }

    public String getAbbrname() {
        return abbrname;
    }

    public void setAbbrname(String abbrname) {
        this.abbrname = abbrname;
    }

    public int getMascot() {
        return mascot;
    }

    public void setMascot(int mascot) {
        this.mascot = mascot;
    }
}
