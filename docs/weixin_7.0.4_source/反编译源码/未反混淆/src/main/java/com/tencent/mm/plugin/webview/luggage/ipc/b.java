package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class b {
    public static <T extends c> void a(Context context, Bundle bundle, Class<T> cls) {
        AppMethodBeat.i(6247);
        Intent intent = new Intent();
        intent.putExtra("task_class_name", cls.getName());
        intent.putExtra("input_data", bundle);
        intent.putExtra("orientation", -1);
        d.b(context, "webview", ".luggage.ipc.IpcProxyUI", intent);
        AppMethodBeat.o(6247);
    }

    public static <T extends c> void a(MMActivity mMActivity, Bundle bundle, Class<T> cls, final a aVar) {
        AppMethodBeat.i(6248);
        Intent intent = new Intent();
        intent.putExtra("task_class_name", cls.getName());
        intent.putExtra("input_data", bundle);
        intent.putExtra("orientation", -1);
        mMActivity.ifE = new a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(6246);
                if (i == 3456) {
                    if (intent == null || aVar == null) {
                        AppMethodBeat.o(6246);
                        return;
                    } else {
                        aVar.l(intent.getBundleExtra("input_data"));
                    }
                }
                AppMethodBeat.o(6246);
            }
        };
        d.b((Context) mMActivity, "webview", ".luggage.ipc.IpcProxyUI", intent, 3456);
        AppMethodBeat.o(6248);
    }
}
