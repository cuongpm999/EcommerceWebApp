package vn.ptit.utils;

import com.github.slugify.Slugify;

public class CreateSlug {
	public String create(final String text) {
		Slugify slg = new Slugify();
		String result = slg.slugify(text + "-" + (System.currentTimeMillis()));
		return result;
	}
}
