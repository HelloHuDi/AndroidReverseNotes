package com.tencent.p177mm.plugin.wear.model.p1419b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.wear.model.b.a */
public final class C29723a {
    /* renamed from: S */
    public static void m47126S(Bundle bundle) {
        AppMethodBeat.m2504i(26368);
        Intent intent = new Intent();
        intent.setPackage(C4996ah.getContext().getPackageName());
        intent.setAction("com.tencent.mm.wear.message");
        intent.putExtras(bundle);
        C4996ah.getContext().sendBroadcast(intent);
        AppMethodBeat.m2505o(26368);
    }
}
