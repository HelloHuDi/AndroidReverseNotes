package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.p;

public final class c implements f, g {
    public Context context;
    public m cwn;
    public a gyH;
    private ak handler = new ak(Looper.getMainLooper());
    public p tipDialog;

    public interface a {
        void aqC();
    }

    public c(Context context, a aVar) {
        AppMethodBeat.i(124673);
        this.context = context;
        this.gyH = aVar;
        AppMethodBeat.o(124673);
    }

    public final void a(int i, int i2, m mVar) {
        AppMethodBeat.i(124674);
        final int i3 = i2 != 0 ? (int) ((((long) i) * 100) / ((long) i2)) : 0;
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(124672);
                if (c.this.tipDialog != null) {
                    c.this.tipDialog.setMessage(c.this.context.getString(R.string.re) + i3 + "%");
                }
                AppMethodBeat.o(124672);
            }
        });
        AppMethodBeat.o(124674);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124675);
        if (mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX) {
            com.tencent.mm.kernel.g.Rg().b((int) com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX, (f) this);
        } else if (mVar.getType() == 138) {
            com.tencent.mm.kernel.g.Rg().b(138, (f) this);
        }
        if (i2 == 0 && i == 0) {
            this.gyH.aqC();
        } else {
            ab.e("MicroMsg.DoInit", "do init failed, err=" + i + "," + i2);
            this.gyH.aqC();
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(124675);
    }
}
