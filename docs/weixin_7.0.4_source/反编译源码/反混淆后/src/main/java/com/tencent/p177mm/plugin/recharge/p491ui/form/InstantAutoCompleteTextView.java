package com.tencent.p177mm.plugin.recharge.p491ui.form;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView */
public class InstantAutoCompleteTextView extends AutoCompleteTextView {
    private boolean pIf;

    public InstantAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InstantAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void dismissDropDown() {
        AppMethodBeat.m2504i(44364);
        super.dismissDropDown();
        C4990ab.m7410d("TestAutoCompleteTextView", "dismiss");
        AppMethodBeat.m2505o(44364);
    }

    public void setShowAlways(boolean z) {
        this.pIf = z;
    }

    public boolean enoughToFilter() {
        AppMethodBeat.m2504i(44365);
        if (this.pIf || super.enoughToFilter()) {
            AppMethodBeat.m2505o(44365);
            return true;
        }
        AppMethodBeat.m2505o(44365);
        return false;
    }
}
