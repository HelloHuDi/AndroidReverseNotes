package com.tencent.p177mm.console.p845a.p1459a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.console.a.a.b */
public final class C37660b implements C44041a {
    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(16153);
        C4990ab.m7417i("MicroMsg.HCSettingCommand", "hcsetting args[%s] [%s]", Integer.valueOf(strArr.length), strArr[0]);
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mm.ui.tools.HardCoderSettingUI");
        context.startActivity(intent);
        AppMethodBeat.m2505o(16153);
        return true;
    }
}
