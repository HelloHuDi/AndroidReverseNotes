package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.ui.widget.b;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;

public class MultiTalkAddMembersUI extends MultiTalkSelectContactUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void initView() {
        AppMethodBeat.i(54117);
        super.initView();
        this.opo.setBackgroundResource(R.color.li);
        MultiSelectContactView multiSelectContactView = this.opo;
        int i = b.oIc;
        multiSelectContactView.setPadding(i, i, b.oIc, 0);
        AppMethodBeat.o(54117);
    }
}
