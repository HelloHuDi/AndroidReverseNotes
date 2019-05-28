package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.roomsdk.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

public final class b extends a {
    f fur = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(80257);
            g.RQ();
            g.RO().eJo.b(mVar.getType(), b.this.fur);
            if (b.this.tipDialog != null) {
                b.this.tipDialog.dismiss();
            }
            if (b.this.tRR.equals(mVar)) {
                if (mVar instanceof a) {
                    ((a) mVar).a(b.this.xva);
                }
                if (b.this.xva != null) {
                    b.this.xva.a(i, i2, str, b.this.xva);
                }
                if (i == 0 && i2 == 0) {
                    if (b.this.xuY != null) {
                        b.this.xuY.a(i, i2, str, b.this.xuY);
                        AppMethodBeat.o(80257);
                        return;
                    }
                } else if (b.this.xuZ != null) {
                    b.this.xuZ.a(i, i2, str, b.this.xuZ);
                }
            }
            AppMethodBeat.o(80257);
        }
    };
    public m tRR;

    public b(boolean z) {
        AppMethodBeat.i(80258);
        this.xuX = z;
        AppMethodBeat.o(80258);
    }

    public final void cancel() {
        AppMethodBeat.i(80259);
        if (this.tRR == null) {
            AppMethodBeat.o(80259);
            return;
        }
        g.RQ();
        g.RO().eJo.c(this.tRR);
        g.RQ();
        g.RO().eJo.b(this.tRR.getType(), this.fur);
        AppMethodBeat.o(80259);
    }

    public final void dmX() {
        AppMethodBeat.i(80260);
        if (this.tRR == null) {
            AppMethodBeat.o(80260);
            return;
        }
        ab.i("MicroMsg.RoomCallbackFactory", "request scene %s", this.tRR);
        if (!(this.tipDialog == null && this.xuY == null && this.xuZ == null && this.xva == null)) {
            g.RQ();
            g.RO().eJo.a(this.tRR.getType(), this.fur);
        }
        g.RQ();
        g.RO().eJo.a(this.tRR, 0);
        AppMethodBeat.o(80260);
    }

    public final void a(Context context, String str, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.i(80261);
        if (this.tRR == null) {
            AppMethodBeat.o(80261);
            return;
        }
        this.tipDialog = h.b(context, str, z, onCancelListener);
        dmX();
        AppMethodBeat.o(80261);
    }
}
