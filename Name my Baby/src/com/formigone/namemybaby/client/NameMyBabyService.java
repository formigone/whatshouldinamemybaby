package com.formigone.namemybaby.client;

import java.util.List;

import com.formigone.namemybaby.shared.model.Baby;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("nameMyBabyService")
public interface NameMyBabyService extends RemoteService {
	Baby addBaby(Baby baby);
	List<Baby> getBabies(int max);
	Baby upVote(Baby baby);
	Baby downVote(Baby baby);
}
