package com.tencent.p177mm.plugin.label.p445ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMTagPanel;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.label.ui.widget.MMLabelPanel */
public class MMLabelPanel extends MMTagPanel {
    public MMLabelPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMLabelPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void bwC() {
        AppMethodBeat.m2504i(22716);
        C4990ab.m7410d("MicroMsg.Label.MMLabelPanel", "cpan[onPreDelTag]");
        if (getTagCount() > 0) {
            AppMethodBeat.m2505o(22716);
        } else {
            AppMethodBeat.m2505o(22716);
        }
    }
}
