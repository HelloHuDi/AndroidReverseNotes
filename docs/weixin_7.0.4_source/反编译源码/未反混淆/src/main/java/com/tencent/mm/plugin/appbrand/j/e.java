package com.tencent.mm.plugin.appbrand.j;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.widget.b.g;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class e implements DialogInterface {
    private OnCancelListener Ue;
    private ap gGo;
    private g inM;
    private boolean mDismissed = false;
    private boolean xH = false;

    e() {
    }

    /* Access modifiers changed, original: final */
    public final void x(final i iVar) {
        AppMethodBeat.i(102147);
        if (al.isMainThread()) {
            this.gGo = new ap(Looper.getMainLooper(), new a() {
                public final boolean BI() {
                    AppMethodBeat.i(102146);
                    if (e.this.xH || e.this.mDismissed) {
                        AppMethodBeat.o(102146);
                    } else {
                        g gVar = new g(iVar.getContext());
                        gVar.setMessage(iVar.getContext().getString(R.string.cu7));
                        gVar.setOnCancelListener(e.this.Ue);
                        gVar.setCanceledOnTouchOutside(false);
                        iVar.gNG.b(gVar);
                        e.this.inM = gVar;
                        AppMethodBeat.o(102146);
                    }
                    return false;
                }
            }, false);
            this.gGo.ae(500, 500);
            AppMethodBeat.o(102147);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(102145);
                e.this.x(iVar);
                AppMethodBeat.o(102145);
            }
        });
        AppMethodBeat.o(102147);
    }

    /* Access modifiers changed, original: final */
    public final e a(OnCancelListener onCancelListener) {
        AppMethodBeat.i(102148);
        this.Ue = onCancelListener;
        if (this.inM != null) {
            this.inM.setOnCancelListener(this.Ue);
        }
        AppMethodBeat.o(102148);
        return this;
    }

    public final void cancel() {
        AppMethodBeat.i(102149);
        this.xH = true;
        if (this.inM != null) {
            this.inM.cancel();
            AppMethodBeat.o(102149);
            return;
        }
        if (this.Ue != null) {
            this.Ue.onCancel(this);
        }
        AppMethodBeat.o(102149);
    }

    public final void dismiss() {
        AppMethodBeat.i(102150);
        this.mDismissed = true;
        if (this.inM != null) {
            this.inM.dismiss();
        }
        AppMethodBeat.o(102150);
    }
}
