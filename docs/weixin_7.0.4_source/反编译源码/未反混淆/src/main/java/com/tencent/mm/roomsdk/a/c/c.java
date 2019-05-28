package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;

public final class c extends a {
    com.tencent.mm.sdk.b.c ekk = new com.tencent.mm.sdk.b.c<mc>() {
        {
            AppMethodBeat.i(80263);
            this.xxI = mc.class.getName().hashCode();
            AppMethodBeat.o(80263);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(80264);
            final mc mcVar = (mc) bVar;
            c.this.ekk.dead();
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(80262);
                    if (c.this.xvd) {
                        AppMethodBeat.o(80262);
                        return;
                    }
                    c.this.xvd = true;
                    String str = mcVar.cHU.cHV;
                    String str2 = mcVar.cHU.cHW;
                    int i = mcVar.cHU.ret;
                    if (c.this.xva != null) {
                        if (c.this.xva instanceof e) {
                            e eVar = (e) c.this.xva;
                            eVar.title = str;
                            eVar.ret = i;
                            eVar.content = str2;
                        }
                        c.this.xva.a(0, i, "", c.this.xva);
                    }
                    if (c.this.tipDialog != null) {
                        c.this.tipDialog.dismiss();
                    }
                    AppMethodBeat.o(80262);
                }
            });
            AppMethodBeat.o(80264);
            return false;
        }
    };
    public j.b xvc;
    boolean xvd = false;
    a xve = new a() {
        public final void x(int i, String str, String str2) {
            AppMethodBeat.i(80265);
            ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XL().b(c.this.xvc.getCmdId(), c.this.xve);
            if (c.this.xvd) {
                AppMethodBeat.o(80265);
                return;
            }
            c.this.xvd = true;
            if (c.this.xva != null) {
                if (c.this.xva instanceof e) {
                    e eVar = (e) c.this.xva;
                    eVar.ret = i;
                    eVar.title = str;
                    eVar.content = str2;
                }
                c.this.xva.a(0, i, "", c.this.xva);
            }
            if (c.this.tipDialog != null) {
                c.this.tipDialog.dismiss();
            }
            AppMethodBeat.o(80265);
        }
    };

    public c(boolean z) {
        AppMethodBeat.i(80266);
        this.xuX = z;
        AppMethodBeat.o(80266);
    }

    public final void cancel() {
        AppMethodBeat.i(80267);
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XL().d(this.xvc);
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XL().b(this.xvc.getCmdId(), this.xve);
        this.ekk.dead();
        AppMethodBeat.o(80267);
    }

    public final void dmX() {
        AppMethodBeat.i(80268);
        ab.i("MicroMsg.RoomCallbackFactory", "request oplog %s", this.xvc);
        if (!(this.xuY == null && this.xuZ == null && this.xva == null)) {
            this.ekk.dnU();
            ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XL().a(this.xvc.getCmdId(), this.xve);
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XL().c(this.xvc);
        AppMethodBeat.o(80268);
    }

    public final void a(Context context, String str, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.i(80269);
        this.tipDialog = h.b(context, str, z, onCancelListener);
        dmX();
        AppMethodBeat.o(80269);
    }
}
