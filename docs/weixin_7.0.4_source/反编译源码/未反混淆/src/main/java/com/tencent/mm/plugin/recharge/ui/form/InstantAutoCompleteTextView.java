package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class InstantAutoCompleteTextView extends AutoCompleteTextView {
    private boolean pIf;

    public InstantAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InstantAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void dismissDropDown() {
        AppMethodBeat.i(44364);
        super.dismissDropDown();
        ab.d("TestAutoCompleteTextView", "dismiss");
        AppMethodBeat.o(44364);
    }

    public void setShowAlways(boolean z) {
        this.pIf = z;
    }

    public boolean enoughToFilter() {
        AppMethodBeat.i(44365);
        if (this.pIf || super.enoughToFilter()) {
            AppMethodBeat.o(44365);
            return true;
        }
        AppMethodBeat.o(44365);
        return false;
    }
}
