package businesslogic;

/**
 *
 * @author miaryvard
 */
public class DatasourceLayerException extends Exception 
{
    /**
     * Thrown when an exeption is cought in the data source layer
     * @param message 
     */
    public DatasourceLayerException(String message)
    {
        super(message);
    }
}
