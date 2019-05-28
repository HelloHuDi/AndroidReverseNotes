package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.account.friend.a.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

public final class g implements f {
    private Context context;
    private ProgressDialog fsh;
    a gyh;
    private boolean gyi = true;
    String gyj = "";

    public interface a {
        void e(boolean z, String str);
    }

    public g(Context context, a aVar) {
        this.context = context;
        this.gyh = aVar;
        this.gyi = true;
    }

    public g(Context context, a aVar, byte b) {
        this.context = context;
        this.gyh = aVar;
        this.gyi = false;
    }

    public final void m(int[] iArr) {
        AppMethodBeat.i(108650);
        com.tencent.mm.kernel.g.Rg().a(116, (f) this);
        final m ahVar = new ah(iArr);
        com.tencent.mm.kernel.g.Rg().a(ahVar, 0);
        if (this.gyi) {
            Context context = this.context;
            this.context.getString(R.string.cev);
            this.fsh = h.b(context, this.context.getString(R.string.cet), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(108648);
                    com.tencent.mm.kernel.g.Rg().c(ahVar);
                    g.this.gyh.e(false, g.this.gyj);
                    AppMethodBeat.o(108648);
                }
            });
        }
        AppMethodBeat.o(108650);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(108651);
        if (mVar.getType() != 116) {
            AppMethodBeat.o(108651);
            return;
        }
        if (this.fsh != null) {
            this.fsh.dismiss();
            this.fsh = null;
        }
        com.tencent.mm.kernel.g.Rg().b(116, (f) this);
        if (i == 0 && i2 == 0) {
            ab.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
            if (this.gyi) {
                h.a(this.context, (int) R.string.ces, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(108649);
                        g.this.gyh.e(true, g.this.gyj);
                        AppMethodBeat.o(108649);
                    }
                });
                AppMethodBeat.o(108651);
                return;
            }
            this.gyh.e(true, this.gyj);
            AppMethodBeat.o(108651);
            return;
        }
        ab.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
        this.gyh.e(false, this.gyj);
        AppMethodBeat.o(108651);
    }
}
