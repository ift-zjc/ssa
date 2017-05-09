package com.ift.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeromq.ZMQ;

/**
 * Created by chen3 on 5/1/17.
 */

@Service
public class ZeroMQService {

    private String zeromqServerUrl;
    private ZMQ.Context context;

    @Autowired
    public ZeroMQService(ZeroMQProperties zeroMQProperties){
        zeromqServerUrl = zeroMQProperties.getUrl();
    }


    /**
     * Send data to remote zeromq server, then disconnected (no need to wait for response)
     * @param jsonData
     * @throws Exception
     */
    public void sendData(byte[] jsonData) throws Exception{

        if (context==null) context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.REQ);
        // Connect to server
        socket.connect(zeromqServerUrl);

        socket.send(jsonData);

        context.term();
        context.close();
    }
}
