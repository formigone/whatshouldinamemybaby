package com.formigone.movies.client.presernters;

import com.google.gwt.user.client.ui.Panel;

public interface Presenter {
	public void go(Panel container);
	public void onMovieCardClick(PresenterView sender);
	public void onSearch(String query);
}
