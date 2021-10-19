package com.aptemui.testrail;

import java.io.IOException;
import java.util.HashMap;

import com.aptemui.extent.ExtentTestManager;
import com.aptemui.utils.ResourceHandler;


public class TestRailResultsManager {

	private String testRunId;
	private String serverURL;
	private String serverUsername;
	private String serverPassword;
	
	public TestRailResultsManager(){
		testRunId=ResourceHandler.getPropValue("testRunId");
		serverURL=ResourceHandler.getPropValue("serverURL");
		serverUsername=ResourceHandler.getPropValue("serverUsername");
		serverPassword=ResourceHandler.getPropValue("serverPassword");
	}
	
	public void postResult(String tcId, int testStatus, String comment){
		try {
		APIClient client = new APIClient(serverURL);
		client.setUser(serverUsername);
		client.setPassword(serverPassword);

		
		String requestType="add_result_for_case";
		String request=requestType+"/"+testRunId+"/"+tcId;
		
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("status_id", new Integer(testStatus));
			data.put("comment", comment);
			client.sendPost(request, data);
			ExtentTestManager.logEventToReport("pass", testStatus, tcId+" "+comment+" updated in TestRail successfully");
			//client.sendPost("add_result_for_case/" + runId + "/" + caseId, data);
		} catch (IOException | APIException e) {
			e.printStackTrace();
		}

	}
}
