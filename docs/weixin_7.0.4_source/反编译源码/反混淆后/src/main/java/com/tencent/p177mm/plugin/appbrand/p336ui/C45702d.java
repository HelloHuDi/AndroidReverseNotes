package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C15532i;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.d */
public final class C45702d {

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.d$1 */
    public static class C385321 implements OnCancelListener {
        final /* synthetic */ C15532i iGU;
        final /* synthetic */ Context val$context;

        public C385321(Context context, C15532i c15532i) {
            this.val$context = context;
            this.iGU = c15532i;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(132988);
            if (this.val$context instanceof MMActivity) {
                ((MMActivity) this.val$context).finish();
            }
            this.iGU.setOnCancelListener(null);
            AppMethodBeat.m2505o(132988);
        }
    }
}
