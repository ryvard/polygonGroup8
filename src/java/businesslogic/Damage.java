package businesslogic;

/**
 *
 * @author miaryvard
 */
public class Damage
{

    private int bRoom;
    private int bFloorID;
    private String damageInRoom;
    private String when;
    private String where;
    private String what;
    private String repaired;
    private String damage;
    private String otherDamage;

    public Damage(int bRoom, int bFloorID, String damageInRoom, String when, String where, String what, String repaired, String damage)
    {
        this.bRoom = bRoom;
        this.bFloorID = bFloorID;
        this.damageInRoom = damageInRoom;
        this.when = when;
        this.where = where;
        this.what = what;
        this.repaired = repaired;
        this.damage = damage;
    }

    public Damage(int bRoom, int bFloorID, String damageInRoom, String when, String where, String what, String repaired, String damage, String otherDamage)
    {
        this.bRoom = bRoom;
        this.bFloorID = bFloorID;
        this.damageInRoom = damageInRoom;
        this.when = when;
        this.where = where;
        this.what = what;
        this.repaired = repaired;
        this.damage = damage;
        this.otherDamage = otherDamage;
    }

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

    public int getbFloorID()
    {
        return bFloorID;
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
