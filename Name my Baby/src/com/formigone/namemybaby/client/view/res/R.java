package com.formigone.namemybaby.client.view.res;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

public interface R extends ClientBundle {

	interface Style extends CssResource {
		String nameCard();
		String nameCardBoy();
		String nameCardGirl();
		String vote();
		String voteUp();
		String voteDown();
		String name();
		String percent();
		String percentPositive();
		String percentNegative();
		String namesContainer();
		String inputContainer();
		String inputBox();
		String genderSelect();
		String genderSelectBoy();
		String genderSelectGirl();
		String genderSelectBoyDown();
		String genderSelectGirlDown();
		String body();
		String header();
	}

	@Source("css/style.css")
	Style css();

	@Source("img/gender-boy-down.png")
	ImageResource genderBoyDown();

	@Source("img/gender-boy.png")
	ImageResource genderBoy();

	@Source("img/gender-girl-down.png")
	ImageResource genderGirlDown();

	@Source("img/gender-girl.png")
	ImageResource genderGirl();

	@Source("img/name-card-boy.png")
	ImageResource nameCardBoy();

	@Source("img/name-card-girl.png")
	ImageResource nameCardGirl();

	@Source("img/searchbox.png")
	ImageResource searchbox();

	@Source("img/vote-down-boy.png")
	ImageResource voteDownBoy();

	@Source("img/vote-down-girl.png")
	ImageResource voteDownGirl();

	@Source("img/vote-down-hover.png")
	ImageResource voteDownHover();

	@Source("img/vote-down.png")
	ImageResource voteDown();

	@Source("img/vote-up-boy.png")
	ImageResource voteUpBoy();

	@Source("img/vote-up-girl.png")
	ImageResource voteUpGirl();

	@Source("img/vote-up-hover.png")
	ImageResource voteUpHover();

	@Source("img/vote-up.png")
	ImageResource voteUp();
	
	@Source("img/background.png")
	@ImageOptions(repeatStyle=RepeatStyle.Horizontal)
	ImageResource background();
	
	@Source("img/dotted-pattern.png")
	@ImageOptions(repeatStyle=RepeatStyle.Both)
	ImageResource dottedPattern();
	
	@Source("img/pregnant-woman.png")
	ImageResource pregnantWoman();
}
