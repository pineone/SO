package com.pineone.icbms.so.virtualobject.proxy;

import com.pineone.icbms.so.device.util.ClientProfile;
import com.pineone.icbms.so.device.util.ClientService;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class VirtualObjectSDAProxy implements VirtualObjectProxy{
    /**
     * SDA에 DeviceID와 Service로 Functionality를 얻는다.
     */

    private ClientService clientService = new ClientService();

    @Override
    public String findFunctionality(String deviceId, String deviceService){
        //
        String requestUri = ClientProfile.SDA_DATAREQUEST_URI + ClientProfile.SDA_DEVICE;
        JSONObject obj = new JSONObject();
        obj.put("deviceId", deviceId);
        obj.put("deviceService", deviceService);
        String requestData = obj.toString();

        String responseData = clientService.requestPostService(requestUri, requestData);

        return responseData;
    }

}
