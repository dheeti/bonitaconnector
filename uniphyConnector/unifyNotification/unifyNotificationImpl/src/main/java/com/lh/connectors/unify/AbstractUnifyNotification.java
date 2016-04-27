package com.lh.connectors.unify;

import org.bonitasoft.engine.connector.AbstractConnector;
import org.bonitasoft.engine.connector.ConnectorValidationException;

public abstract class AbstractUnifyNotification extends AbstractConnector
{

   protected final static String SUBJECT_INPUT_PARAMETER = "subject";
   protected final static String PARTICIPANT_INPUT_PARAMETER = "participant";
   protected final static String CONTENT_INPUT_PARAMETER = "content";
   protected final static String URGENT_INPUT_PARAMETER = "urgent";
   protected final String RESULT_OUTPUT_PARAMETER = "result";

   protected final String getSubject()
   {
      return (java.lang.String) getInputParameter(SUBJECT_INPUT_PARAMETER);
   }

   protected final String getParticipant()
   {
      return (java.lang.String) getInputParameter(PARTICIPANT_INPUT_PARAMETER);
   }

   protected final String getContent()
   {
      return (java.lang.String) getInputParameter(CONTENT_INPUT_PARAMETER);
   }

   protected final String getUrgent()
   {
      return (java.lang.String) getInputParameter(URGENT_INPUT_PARAMETER);
   }

   protected final void setResult(String result)
   {
      setOutputParameter(RESULT_OUTPUT_PARAMETER, result);
   }

   public void validateInputParameters() throws ConnectorValidationException
   {
      try
      {
         getSubject();
      }
      catch (ClassCastException cce)
      {
         throw new ConnectorValidationException("subject type is invalid");
      }
      try
      {
         getParticipant();
      }
      catch (ClassCastException cce)
      {
         throw new ConnectorValidationException(
               "participant type is invalid");
      }
      try
      {
         getContent();
      }
      catch (ClassCastException cce)
      {
         throw new ConnectorValidationException("content type is invalid");
      }
      try
      {
         getUrgent();
      }
      catch (ClassCastException cce)
      {
         throw new ConnectorValidationException("urgent type is invalid");
      }
   }
}