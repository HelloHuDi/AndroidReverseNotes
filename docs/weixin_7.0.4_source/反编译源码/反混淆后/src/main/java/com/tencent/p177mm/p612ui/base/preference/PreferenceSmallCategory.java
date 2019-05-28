package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.base.preference.PreferenceSmallCategory */
public class PreferenceSmallCategory extends PreferenceCategory {
    public PreferenceSmallCategory(Context context) {
        this(context, null);
    }

    public PreferenceSmallCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceSmallCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107283);
        setLayoutResource(2130970178);
        AppMethodBeat.m2505o(107283);
    }
}
