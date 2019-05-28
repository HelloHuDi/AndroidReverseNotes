package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.ui.base.preference.PreferenceHeaderCategory */
public class PreferenceHeaderCategory extends Preference {
    public PreferenceHeaderCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceHeaderCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107279);
        setLayoutResource(2130970178);
        AppMethodBeat.m2505o(107279);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107280);
        View onCreateView = super.onCreateView(viewGroup);
        onCreateView.findViewById(16908310).setBackgroundResource(C25738R.drawable.a_r);
        AppMethodBeat.m2505o(107280);
        return onCreateView;
    }
}
