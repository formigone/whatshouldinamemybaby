package com.formigone.namemybaby.client;

import java.util.List;

import com.formigone.namemybaby.models.Vote;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("babyService")
public interface BabyService extends RemoteService {
	List<Vote> getVotes(int maxVotes);
}
