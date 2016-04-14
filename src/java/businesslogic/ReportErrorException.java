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
public class ReportErrorException extends Exception 
{
    public ReportErrorException(String message)
    {
        super(message);
    }
}
