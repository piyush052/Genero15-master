package com.dexterous.genero15.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import me.grantland.widget.AutofitTextView;

/**
 * Created by Honey on 9/25/2015.
 */
public class NorthwoordHigh extends AutofitTextView {
    private static Typeface sRoboto;

    public NorthwoordHigh(Context paramContext) {
        super(paramContext);
        if (isInEditMode()) {
            return;
        }
        setTypeface();
    }

    public NorthwoordHigh(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        if (isInEditMode()) {
            return;
        }
        setTypeface();
    }

    public NorthwoordHigh(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        if (isInEditMode()) {
            return;
        }
        setTypeface();
    }

    private void setTypeface() {
        if (sRoboto == null) {
            sRoboto = Typeface.createFromAsset(getContext().getAssets(), "fonts/Northwood_High.ttf");
        }
        setTypeface(sRoboto);
    }
}
