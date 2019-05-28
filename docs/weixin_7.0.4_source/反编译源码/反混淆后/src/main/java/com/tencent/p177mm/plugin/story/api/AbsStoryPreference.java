package com.tencent.p177mm.plugin.story.api;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.story.api.AbsStoryPreference */
public abstract class AbsStoryPreference extends Preference {
    /* renamed from: a */
    public abstract void mo41694a(C4109d c4109d);

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
