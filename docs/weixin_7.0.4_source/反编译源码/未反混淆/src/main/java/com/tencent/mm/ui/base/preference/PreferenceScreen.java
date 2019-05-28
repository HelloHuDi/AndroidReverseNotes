package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;

public class PreferenceScreen extends Preference {
    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceScreen(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
