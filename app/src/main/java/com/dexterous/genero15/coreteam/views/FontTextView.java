package com.dexterous.genero15.coreteam.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import java.io.File;

import me.grantland.widget.AutofitTextView;

/**
 * @author Yalantis
 */
public class FontTextView extends AutofitTextView {

    public FontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        parseAttributes(context, attrs);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttributes(context, attrs);
    }

    public FontTextView(Context context) {
        super(context);
    }

    private void parseAttributes(Context context, AttributeSet attrs) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts" + File.separator + "Roboto_Light.ttf"));
    }
}
