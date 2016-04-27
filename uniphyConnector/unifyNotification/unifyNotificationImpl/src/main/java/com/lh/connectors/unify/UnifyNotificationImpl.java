package com.lh.connectors.unify;

import com.lh.connectors.dto.UnifyNotificationDTO;
import com.sun.jersey.api.client.filter.LoggingFilter;
import org.bonitasoft.engine.connector.ConnectorException;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The connector execution will follow the steps: 
 * <ol>
 * <li>setInputParameters() --> the connector receives input parameters values</li>
 * <li>validateInputParameters() --> the connector can validate input parameters values</li>
 * <li>connect() --> the connector can establish a connection to a remote server (if necessary)</li>
 * <li>executeBusinessLogic() --> execute the connector</li>
 * <li>getOutputParameters() --> output are retrieved from connector</li>
 * <li>disconnect() --> the connector can close connection to remote server (if any)</li>
 * </ol>
 */
public class UnifyNotificationImpl extends AbstractUnifyNotification
{

   /**
    * This method is where you define the business logic of you connector
    * <p>
    * Get access to the connector input parameters using AbstractUnifyNotification getter methods
    * <p>
    * Use AbstractUnifyNotification setter methods to set connector Outputs
    * <p>
    * WARNING: if outputs are not set, connector execution will fail
    */
   @Override
   protected void executeBusinessLogic() throws ConnectorException
   {
      String subject = getSubject();
      String participant = getParticipant();
      String content = getContent();
      String urgent = getUrgent();
      String success = null;

      String request = "";

      UnifyNotificationDTO unifyNotificationDTO = new UnifyNotificationDTO();

      this.populateDTO(unifyNotificationDTO);
      HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("scc_care@uniphyhealth.com", "D^yh@Lv3$");

      Client client = ClientBuilder.newClient();
      client.register(feature);
      WebTarget target = client.target("https://www.myuniphy.com/core-api/v1/contentwrapper/conversations");
      target.register(new LoggingFilter(System.out));
      System.out.println("before invoke");

      /*String requestString = target.request(MediaType.APPLICATION_JSON)
              .post(
                      Entity.entity(
                              unifyNotificationDTO,
                              MediaType.APPLICATION_JSON
                      ),
                      String.class
              );*/
      String requestString = generateRequestString(unifyNotificationDTO);
      String requestString1  ="{\"content\":\"testing Uniphy from Connector\",\"createdBy\" : \"56d07f7fe4b045807ecdbbab\",\"participants\":[{\"participantUserId\":\"56d07f7fe4b045807ecdbbab" +
              "\"},{\"participantUserId\":\"56981416e4b0fa694eee5aff\"}],\"shareable\":true,\"messages\":[{\"content\":\"Hi Mark, This is JJ testing Unify REST Service now from Connector.2nd Message\",\"hasAttachment\":\"false\",\"attachmentList\":[],\"urgent\":true}]}";
      String result = target.request(MediaType.APPLICATION_JSON).post(Entity.json(requestString),String.class);
      if (!((result==null)||(result.equals(""))))
         success="success";
      else
         success = "failure";
      setResult(result);
   }

   private String generateRequestString(UnifyNotificationDTO unifyNotificationDTO) {
      String requestString = null;
      StringBuilder tempBuilder = new StringBuilder();
      tempBuilder.append("{\"content\":\"");
      tempBuilder.append(unifyNotificationDTO.getContent());
      tempBuilder.append("\",\"createdBy\" : \"");
      tempBuilder.append(unifyNotificationDTO.getDefaultParticipant());
      tempBuilder.append("\",\"participants\":[{\"participantUserId\":\"");
      tempBuilder.append(unifyNotificationDTO.getDefaultParticipant());
      tempBuilder.append(("\"},{\"participantUserId\":\""));


      return requestString;
   }

   private UnifyNotificationDTO populateDTO(UnifyNotificationDTO unifyNotificationDTO) {
      unifyNotificationDTO.setContent("Testing UniphyConnector");
      unifyNotificationDTO.setCreatedBy("56d07f7fe4b045807ecdbbab");

      HashMap <String,String>participantHashMap = new HashMap();
      participantHashMap.put("participantUserId","56d07f7fe4b045807ecdbbab");
      participantHashMap.put("participantUserId",getParticipant());
      unifyNotificationDTO.setParticipants(participantHashMap);
      unifyNotificationDTO.setShareable("true");

      HashMap<String,Object> messages = new HashMap<String,Object>();
      messages.put("content","Test message sent at"+System.currentTimeMillis());
      messages.put("hasAttachment","false");
      messages.put("attachmentList",null);
      messages.put("urgent","true");
      unifyNotificationDTO.setMessages(messages);

      return unifyNotificationDTO;
   }

   /**
    * [Optional] Open a connection to remote server
    */
   @Override
   public void connect() throws ConnectorException
   {
   }

   /**
    * [Optional] Close a connection to remote server
    */
   @Override
   public void disconnect() throws ConnectorException
   {
   }
}