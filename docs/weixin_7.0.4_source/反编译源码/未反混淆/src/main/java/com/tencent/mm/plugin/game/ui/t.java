package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.av;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class t implements OnClickListener, f {
    private Context mContext;
    private c mVZ = null;
    int mXC;
    DialogInterface.OnClickListener nmX = null;

    public static class a {
        public String message;
        public String nmZ;
        public String nna;
        public String url;
    }

    public static class b {
        public String content;
        public Boolean nnb;
        public a nnc;
        public String title;
    }

    public t(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(112214);
        if (view.getTag() instanceof c) {
            this.mVZ = (c) view.getTag();
            ab.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.mVZ.field_appId);
            g.Rg().a(1219, (f) this);
            g.Rg().a(new av(this.mVZ.field_appId, aa.dor(), this.mVZ.ctu, this.mVZ.mVw), 0);
            AppMethodBeat.o(112214);
            return;
        }
        ab.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
        AppMethodBeat.o(112214);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(112215);
        if (i == 0 && i2 == 0 && mVar.getType() == 1219) {
            g.Rg().b(1219, (f) this);
            ag agVar = new ag(((av) mVar).lty.fsH.fsP);
            b bVar = new b();
            bVar.nnb = Boolean.valueOf(agVar.mYl.mZy);
            bVar.title = agVar.mYl.Title;
            bVar.content = agVar.mYl.mZR;
            if (agVar.mYl.ndD != null) {
                bVar.nnc = new a();
                bVar.nnc.message = agVar.mYl.ndD.mZR;
                bVar.nnc.nmZ = agVar.mYl.ndD.mZS;
                bVar.nnc.nna = agVar.mYl.ndD.mZT;
                bVar.nnc.url = agVar.mYl.ndD.Url;
            }
            this.mVZ.mVo = bVar.nnb.booleanValue();
            if (bo.isNullOrNil(bVar.title)) {
                AppMethodBeat.o(112215);
                return;
            } else if (bVar.nnc != null) {
                final String str2 = bVar.nnc.url;
                com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this.mContext);
                aVar.asD(bVar.title);
                aVar.asE(bVar.nnc.message);
                aVar.rc(false);
                aVar.asJ(bVar.nnc.nmZ).a(true, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(112213);
                        com.tencent.mm.plugin.game.f.c.ax(t.this.mContext, str2);
                        com.tencent.mm.plugin.game.e.b.a(t.this.mContext, t.this.mVZ.scene, t.this.mVZ.cKG, t.this.mVZ.position, 17, t.this.mVZ.field_appId, t.this.mXC, t.this.mVZ.ctu, t.this.mVZ.mVB);
                        AppMethodBeat.o(112213);
                    }
                });
                aVar.asK(bVar.nnc.nna).b(this.nmX);
                aVar.aMb().show();
                AppMethodBeat.o(112215);
                return;
            } else if (bo.isNullOrNil(bVar.content)) {
                AppMethodBeat.o(112215);
                return;
            } else {
                com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(this.mContext);
                aVar2.asD(bVar.title);
                aVar2.asE(bVar.content);
                aVar2.rc(false);
                aVar2.Qc(R.string.c86).a(this.nmX);
                aVar2.aMb().show();
                AppMethodBeat.o(112215);
                return;
            }
        }
        com.tencent.mm.ui.widget.a.c.a aVar3 = new com.tencent.mm.ui.widget.a.c.a(this.mContext);
        aVar3.PZ(R.string.c87);
        aVar3.Qc(R.string.c86);
        aVar3.aMb().show();
        AppMethodBeat.o(112215);
    }
}
