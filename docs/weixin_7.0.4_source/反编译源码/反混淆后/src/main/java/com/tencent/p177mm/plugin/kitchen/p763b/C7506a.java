package com.tencent.p177mm.plugin.kitchen.p763b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.kitchen.p733a.C6956a;
import com.tencent.p177mm.plugin.kitchen.p986ui.KvInfoUI;

/* renamed from: com.tencent.mm.plugin.kitchen.b.a */
public final class C7506a implements C6956a {
    /* renamed from: w */
    public final void mo15198w(Context context, Intent intent) {
        AppMethodBeat.m2504i(114439);
        intent.setClass(context, KvInfoUI.class);
        context.startActivity(intent);
        AppMethodBeat.m2505o(114439);
    }
}
