/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

/**
 *
 * @author miaryvard
 */
public class Damage
{
    int bRoom;
    String damageInRoom;
    String when;
    String where;
    String what;
    String repaired;
    String damage;
    String otherDamage;

    public Damage(int bRoom, String damageInRoom, String when, String where, String what, String repaired, String damage, String otherDamage)
    {
        this.bRoom = bRoom;
        this.damageInRoom = damageInRoom;
        this.when = when;
        this.where = where;
        this.what = what;
        this.repaired = repaired;
        this.damage = damage;
        this.otherDamage = otherDamage;
    }

    public void setbRoom(int bRoom)
    {
        this.bRoom = bRoom;
    }

    public void setDamageInRoom(String damageInRoom)
    {
        this.damageInRoom = damageInRoom;
    }

    public void setWhen(String when)
    {
        this.when = when;
    }

    public void setWhere(String where)
    {
        this.where = where;
    }

    public void setWhat(String what)
    {
        this.what = what;
    }

    public void setRepaired(String repaired)
    {
        this.repaired = repaired;
    }

    public void setDamage(String damage)
    {
        this.damage = damage;
    }

    public void setOtherDamage(String otherDamage)
    {
        this.otherDamage = otherDamage;
    }

    public int getbRoom()
    {
        return bRoom;
    }

    public String getDamageInRoom()
    {
        return damageInRoom;
    }

    public String getWhen()
    {
        return when;
    }

    public String getWhere()
    {
        return where;
    }

    public String getWhat()
    {
        return what;
    }

    public String getRepaired()
    {
        return repaired;
    }

    public String getDamage()
    {
        return damage;
    }

    public String getOtherDamage()
    {
        return otherDamage;
    }
    
    
}
