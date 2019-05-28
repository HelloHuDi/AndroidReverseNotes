package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.preference.Preference;

public abstract class AbsStoryPreference extends Preference {
    public abstract void a(d dVar);

    public abstract void cwO();

    public abstract void cwP();

    public abstract void cwQ();

    public abstract void onCreate(String str);

    public abstract void onDestroy();

    public AbsStoryPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbsStoryPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
