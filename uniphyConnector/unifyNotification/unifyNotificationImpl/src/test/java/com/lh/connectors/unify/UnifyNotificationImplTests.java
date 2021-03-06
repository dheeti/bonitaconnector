package com.lh.connectors.unify;

import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.bonitasoft.engine.api.APIAccessor;
import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.connector.ConnectorException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;

/**
 * This auto-generated class aims to be an introduction on how to test your connector.
 * <p>
 * It shows how to use Mockito framework to mock services used during the
 * <p>
 * connector execution (like Bonita Engine APIs or external services).
 * Verifies that input and output connector parameters are used and that connect() and disconnect() methods do not raise exceptions.
 */
@RunWith(MockitoJUnitRunner.class)
public class UnifyNotificationImplTests
{

   @Spy
   private UnifyNotificationImpl connector;
   @Mock
   private APIAccessor apiAccessor;
   @Mock
   private ProcessAPI processAPI;

   /**
    * The setup method is called before each test is executed:
    * <ul>
    * <li>it first  creates a new instance of the connector implementation to test</li>
    * <li>then creates mock objects for each field type</li>
    * <li>then it defines that the processAPI mocked service will be returned when calling the apiAccessor and
    * ends up injecting the mocked apiAccessor in the connector to make use of it (instead of the real API)</li>
    * </ul>
    */
   @Before
   public void setup()
   {
      when(apiAccessor.getProcessAPI()).thenReturn(processAPI);
      connector.setAPIAccessor(apiAccessor);
   }

   /**
    * Verify 'subject' input parameter is used during connector execution
    * @throws ConnectorException
    */
   @Test
   public void unifyNotificationImpl_verifySubject_isUsed()
         throws ConnectorException
   {
      connector.execute();
      verify(connector).getSubject();
   }

   /**
    * Verify 'participant' input parameter is used during connector execution
    * @throws ConnectorException
    */
   @Test
   public void unifyNotificationImpl_verifyParticipant_isUsed()
         throws ConnectorException
   {
      connector.execute();
      verify(connector).getParticipant();
   }

   /**
    * Verify 'content' input parameter is used during connector execution
    * @throws ConnectorException
    */
   @Test
   public void unifyNotificationImpl_verifyContent_isUsed()
         throws ConnectorException
   {
      connector.execute();
      verify(connector).getContent();
   }

   /**
    * Verify 'urgent' input parameter is used during connector execution
    * @throws ConnectorException
    */
   @Test
   public void unifyNotificationImpl_verifyUrgent_isUsed()
         throws ConnectorException
   {
      connector.execute();
      verify(connector).getUrgent();
   }

   /**
    * Test 'connect' business logic
    * @throws ConnectorException
    */
   @Test
   public void unifyNotificationImpl_onConnect() throws ConnectorException
   {
      connector.connect();
   }

   /**
    * Test 'disconnect' business logic
    * @throws ConnectorException
    */
   @Test
   public void unifyNotificationImpl_onDisconnect() throws ConnectorException
   {
      connector.disconnect();
   }
}