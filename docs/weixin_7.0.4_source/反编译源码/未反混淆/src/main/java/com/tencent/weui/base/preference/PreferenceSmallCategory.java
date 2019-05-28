package com.tencent.weui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class PreferenceSmallCategory extends PreferenceCategory {
    public PreferenceSmallCategory(Context context) {
        this(context, null);
    }

    public PreferenceSmallCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceSmallCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(113257);
        setLayoutResource(R.layout.afh);
        AppMethodBeat.o(113257);
    }
}
