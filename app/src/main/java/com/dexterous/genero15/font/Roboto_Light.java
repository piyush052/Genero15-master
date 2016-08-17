package com.dexterous.genero15.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Honey on 9/28/2015.
 */
public class Roboto_Light extends TextView {
    private static Typeface sRoboto;

    public Roboto_Light(Context paramContext) {
        super(paramContext);
        if (isInEditMode()) {
            return;
        }
        setTypeface();
    }

    public Roboto_Light(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        if (isInEditMode()) {
            return;
        }
        setTypeface();
    }

    public Roboto_Light(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        if (isInEditMode()) {
            return;
        }
        setTypeface();
    }

    private void setTypeface() {
        if (sRoboto == null) {
            sRoboto = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto_Light.ttf");
        }
        setTypeface(sRoboto);
    }
}
