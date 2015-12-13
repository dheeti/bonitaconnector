package com.lh.connectors.twistle;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.bonitasoft.engine.connector.AbstractConnector;
import org.bonitasoft.engine.connector.ConnectorException;
import org.bonitasoft.engine.connector.ConnectorValidationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwistleConnectorImpl extends AbstractTwistleConnector implements StringConstants{


public static String TWISTLE_STATUS="TWISTLE_STATUS";
  public static String ENDPOINT = "send_message";

private String systemId;
private String password;
private String messageId;
private String recipientId;
private String content;
private String attachments;


public void setSystemId(String systemId){
  this.systemId = systemId;
}

public void setPassword(String password){
  this.password = password;
}

public void setMessageId(String messageId){
  this.messageId = messageId;
}

public void setRecipientId(String recipientId){
  this.recipientId = recipientId;
}

public void setContent(String content){
  this.content = content;
}

public void setAttachments(String attachments){
  this.attachments = attachments;
}

private  List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();


    @Override
    protected void executeBusinessLogic() throws ConnectorException {
      String result = null;

      systemId = getSystemId();
      password = getPassword();
      messageId = getMessageId();
      recipientId = getRecipientId();
      content = getContent();
      attachments = getAttachments();

      nameValuePairs.add(new BasicNameValuePair(SYSTEMID,getSystemId()));
      nameValuePairs.add(new BasicNameValuePair(PASSWORD,getPassword()));
      nameValuePairs.add(new BasicNameValuePair(MESSAGEID,getMessageId()));
      nameValuePairs.add(new BasicNameValuePair(RECEPIENTID,getRecipientId()));
      nameValuePairs.add(new BasicNameValuePair(CONTENT,getContent()));
      nameValuePairs.add(new BasicNameValuePair(ATTACHMENTS,getAttachments()));

      RestClient client = new RestClient();
      /*nameValuePairs.add(new BasicNameValuePair(SYSTEMID,"jj@learninghealth.io"));
      nameValuePairs.add(new BasicNameValuePair(PASSWORD,"Kmfpakx@1"));
      nameValuePairs.add(new BasicNameValuePair(MESSAGEID,"LH"+System.currentTimeMillis()));
      nameValuePairs.add(new BasicNameValuePair(RECEPIENTID,"jj@learninghealth.io"));
      nameValuePairs.add(new BasicNameValuePair(CONTENT,"Testing from Code"+System.currentTimeMillis()));*/
      result = client.execute(nameValuePairs,ENDPOINT);
      setResult(result);
    }
  
   @Override
   public void connect() throws ConnectorException
   {
   }

   @Override
   public void disconnect() throws ConnectorException
   {
   }
}    