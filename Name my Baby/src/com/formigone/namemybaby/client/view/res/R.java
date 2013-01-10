package com.formigone.namemybaby.client.view.res;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface R extends ClientBundle {
	
	public static final R GET = GWT.create(R.class);

	@Source("gender-boy-down.png")
	ImageResource genderBoyDown();

	@Source("gender-boy.png")
	ImageResource genderBoy();

	@Source("gender-girl-down.png")
	ImageResource genderGirlDown();

	@Source("gender-girl.png")
	ImageResource genderGirl();

	@Source("name-card-boy.png")
	ImageResource nameCardBoy();

	@Source("name-card-girl.png")
	ImageResource nameCardGirl();

	ImageResource searchbox();

	@Source("vote-down-boy.png")
	ImageResource voteDownBoy();

	@Source("vote-down-girl.png")
	ImageResource voteDownGirl();

	@Source("vote-down-hover.png")
	ImageResource voteDownHover();

	@Source("vote-down.png")
	ImageResource voteDown();

	@Source("vote-up-boy.png")
	ImageResource voteUpBoy();

	@Source("vote-up-girl.png")
	ImageResource voteUpGirl();

	@Source("vote-up-hover.png")
	ImageResource voteUpHover();

	@Source("vote-up.png")
	ImageResource voteUp();
}
