package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NormalIconPreference extends IconPreference {
    public NormalIconPreference(Context context) {
        this(context, null);
    }

    public NormalIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NormalIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(107249);
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.o(107249);
        return onCreateView;
    }
}
