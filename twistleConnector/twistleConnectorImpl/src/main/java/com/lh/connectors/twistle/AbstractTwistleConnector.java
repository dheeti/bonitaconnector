package com.lh.connectors.twistle;

import org.bonitasoft.engine.connector.AbstractConnector;
import org.bonitasoft.engine.connector.ConnectorValidationException;

public abstract class AbstractTwistleConnector extends AbstractConnector implements StringConstants
{


   protected final String getSystemId(){
      return (java.lang.String) getInputParameter(SYSTEMID);
   }

   protected final String getPassword(){
      return (java.lang.String) getInputParameter(PASSWORD);
   }

   protected final String getMessageId(){
      return (java.lang.String) getInputParameter(MESSAGEID);
   }

   protected final String getRecipientId(){
      return (java.lang.String) getInputParameter(RECEPIENTID);
   }

   protected final String getContent(){
      return (java.lang.String) getInputParameter(CONTENT);
   }

   protected final String getAttachments(){
      return (java.lang.String) getInputParameter(ATTACHMENTS);
   }

   protected final void setResult(String result)
   {
      setOutputParameter(RESULT, result);
   }

   public void validateInputParameters() throws ConnectorValidationException
   {
      try
      {
         getSystemId();
         getPassword();
         getMessageId();
         getRecipientId();
         getContent();
         getAttachments();
      }
      catch (ClassCastException cce)
      {
         throw new ConnectorValidationException("input type is invalid");
      }
   }
}