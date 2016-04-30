package businesslogic;

/**
 *
 * @author miaryvard
 */
public class Condition
{
    int condition;
    String description;
    String function;
    /**
     * Constructor for conditions
     * @param condition
     * @param description
     * @param function 
     */
    public Condition(int condition, String description, String function)
    {
        this.condition = condition;
        this.description = description;
        this.function = function;
    }

    public int getCondition()
    {
        return condition;
    }

    public String getDescription()
    {
        return description;
    }

    public String getFunction()
    {
        return function;
    }
}
