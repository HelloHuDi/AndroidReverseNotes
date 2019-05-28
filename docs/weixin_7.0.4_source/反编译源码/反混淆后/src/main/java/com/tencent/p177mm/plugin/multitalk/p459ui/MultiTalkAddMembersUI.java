package com.tencent.p177mm.plugin.multitalk.p459ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.multitalk.p459ui.widget.C43320b;
import com.tencent.p177mm.pluginsdk.p597ui.MultiSelectContactView;

/* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkAddMembersUI */
public class MultiTalkAddMembersUI extends MultiTalkSelectContactUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void initView() {
        AppMethodBeat.m2504i(54117);
        super.initView();
        this.opo.setBackgroundResource(C25738R.color.f11915li);
        MultiSelectContactView multiSelectContactView = this.opo;
        int i = C43320b.oIc;
        multiSelectContactView.setPadding(i, i, C43320b.oIc, 0);
        AppMethodBeat.m2505o(54117);
    }
}
