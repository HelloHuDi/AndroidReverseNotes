package com.tencent.p177mm.plugin.webview.luggage.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;

/* renamed from: com.tencent.mm.plugin.webview.luggage.ipc.b */
public final class C4542b {
    /* renamed from: a */
    public static <T extends C35590c> void m6918a(Context context, Bundle bundle, Class<T> cls) {
        AppMethodBeat.m2504i(6247);
        Intent intent = new Intent();
        intent.putExtra("task_class_name", cls.getName());
        intent.putExtra("input_data", bundle);
        intent.putExtra("orientation", -1);
        C25985d.m41467b(context, "webview", ".luggage.ipc.IpcProxyUI", intent);
        AppMethodBeat.m2505o(6247);
    }

    /* renamed from: a */
    public static <T extends C35590c> void m6919a(MMActivity mMActivity, Bundle bundle, Class<T> cls, final C4541a c4541a) {
        AppMethodBeat.m2504i(6248);
        Intent intent = new Intent();
        intent.putExtra("task_class_name", cls.getName());
        intent.putExtra("input_data", bundle);
        intent.putExtra("orientation", -1);
        mMActivity.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(6246);
                if (i == 3456) {
                    if (intent == null || c4541a == null) {
                        AppMethodBeat.m2505o(6246);
                        return;
                    } else {
                        c4541a.mo9613l(intent.getBundleExtra("input_data"));
                    }
                }
                AppMethodBeat.m2505o(6246);
            }
        };
        C25985d.m41468b((Context) mMActivity, "webview", ".luggage.ipc.IpcProxyUI", intent, 3456);
        AppMethodBeat.m2505o(6248);
    }
}
