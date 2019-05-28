package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class PreferenceHeaderCategory extends Preference {
    public PreferenceHeaderCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceHeaderCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107279);
        setLayoutResource(R.layout.afh);
        AppMethodBeat.o(107279);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(107280);
        View onCreateView = super.onCreateView(viewGroup);
        onCreateView.findViewById(16908310).setBackgroundResource(R.drawable.a_r);
        AppMethodBeat.o(107280);
        return onCreateView;
    }
}
