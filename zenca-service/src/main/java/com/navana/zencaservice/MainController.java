package com.navana.zencaservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

class RequestListInfo
{
    String uri;
    String sql;
}

@RestController
@RequestMapping("/v1")
public class MainController {

    public ArrayList<RequestListInfo> requestList = null;

    public MainController()
    {
        RequestListInfo info = new RequestListInfo();
        info.uri = "/v1/test/123";
        info.sql = "SELECT * FROM NAME";

        requestList = new <RequestListInfo> ArrayList();
        requestList.add(info);
    }

    @GetMapping("/**")
    public String foo(HttpServletRequest request) {
        String requestURI = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);


        for (int i=0; i< requestList.size(); i++)
        {
            String uri = requestList.get(i).uri;
            String sql = requestList.get(i).sql;

            if(requestURI.equals(uri) == true)
            {
                return sql;
            }
        }
        return "2";
    }

}