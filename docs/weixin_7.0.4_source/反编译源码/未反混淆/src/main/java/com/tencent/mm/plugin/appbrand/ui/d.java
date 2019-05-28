package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;

public final class d {

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.d$1 */
    public static class AnonymousClass1 implements OnCancelListener {
        final /* synthetic */ i iGU;
        final /* synthetic */ Context val$context;

        public AnonymousClass1(Context context, i iVar) {
            this.val$context = context;
            this.iGU = iVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(132988);
            if (this.val$context instanceof MMActivity) {
                ((MMActivity) this.val$context).finish();
            }
            this.iGU.setOnCancelListener(null);
            AppMethodBeat.o(132988);
        }
    }
}
