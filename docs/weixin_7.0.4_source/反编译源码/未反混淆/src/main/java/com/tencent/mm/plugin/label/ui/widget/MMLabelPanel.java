package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMTagPanel;

public class MMLabelPanel extends MMTagPanel {
    public MMLabelPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMLabelPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void bwC() {
        AppMethodBeat.i(22716);
        ab.d("MicroMsg.Label.MMLabelPanel", "cpan[onPreDelTag]");
        if (getTagCount() > 0) {
            AppMethodBeat.o(22716);
        } else {
            AppMethodBeat.o(22716);
        }
    }
}
