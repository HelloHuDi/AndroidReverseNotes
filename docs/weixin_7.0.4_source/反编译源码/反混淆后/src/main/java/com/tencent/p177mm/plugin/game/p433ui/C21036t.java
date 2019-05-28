package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C34293ag;
import com.tencent.p177mm.plugin.game.model.C39212av;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.t */
public final class C21036t implements OnClickListener, C1202f {
    private Context mContext;
    private C20992c mVZ = null;
    int mXC;
    DialogInterface.OnClickListener nmX = null;

    /* renamed from: com.tencent.mm.plugin.game.ui.t$a */
    public static class C21037a {
        public String message;
        public String nmZ;
        public String nna;
        public String url;
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.t$b */
    public static class C21038b {
        public String content;
        public Boolean nnb;
        public C21037a nnc;
        public String title;
    }

    public C21036t(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(112214);
        if (view.getTag() instanceof C20992c) {
            this.mVZ = (C20992c) view.getTag();
            C4990ab.m7416i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.mVZ.field_appId);
            C1720g.m3540Rg().mo14539a(1219, (C1202f) this);
            C1720g.m3540Rg().mo14541a(new C39212av(this.mVZ.field_appId, C4988aa.dor(), this.mVZ.ctu, this.mVZ.mVw), 0);
            AppMethodBeat.m2505o(112214);
            return;
        }
        C4990ab.m7412e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
        AppMethodBeat.m2505o(112214);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(112215);
        if (i == 0 && i2 == 0 && c1207m.getType() == 1219) {
            C1720g.m3540Rg().mo14546b(1219, (C1202f) this);
            C34293ag c34293ag = new C34293ag(((C39212av) c1207m).lty.fsH.fsP);
            C21038b c21038b = new C21038b();
            c21038b.nnb = Boolean.valueOf(c34293ag.mYl.mZy);
            c21038b.title = c34293ag.mYl.Title;
            c21038b.content = c34293ag.mYl.mZR;
            if (c34293ag.mYl.ndD != null) {
                c21038b.nnc = new C21037a();
                c21038b.nnc.message = c34293ag.mYl.ndD.mZR;
                c21038b.nnc.nmZ = c34293ag.mYl.ndD.mZS;
                c21038b.nnc.nna = c34293ag.mYl.ndD.mZT;
                c21038b.nnc.url = c34293ag.mYl.ndD.Url;
            }
            this.mVZ.mVo = c21038b.nnb.booleanValue();
            if (C5046bo.isNullOrNil(c21038b.title)) {
                AppMethodBeat.m2505o(112215);
                return;
            } else if (c21038b.nnc != null) {
                final String str2 = c21038b.nnc.url;
                C5652a c5652a = new C5652a(this.mContext);
                c5652a.asD(c21038b.title);
                c5652a.asE(c21038b.nnc.message);
                c5652a.mo11482rc(false);
                c5652a.asJ(c21038b.nnc.nmZ).mo11462a(true, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(112213);
                        C46001c.m85455ax(C21036t.this.mContext, str2);
                        C34277b.m56212a(C21036t.this.mContext, C21036t.this.mVZ.scene, C21036t.this.mVZ.cKG, C21036t.this.mVZ.position, 17, C21036t.this.mVZ.field_appId, C21036t.this.mXC, C21036t.this.mVZ.ctu, C21036t.this.mVZ.mVB);
                        AppMethodBeat.m2505o(112213);
                    }
                });
                c5652a.asK(c21038b.nnc.nna).mo11476b(this.nmX);
                c5652a.aMb().show();
                AppMethodBeat.m2505o(112215);
                return;
            } else if (C5046bo.isNullOrNil(c21038b.content)) {
                AppMethodBeat.m2505o(112215);
                return;
            } else {
                C5652a c5652a2 = new C5652a(this.mContext);
                c5652a2.asD(c21038b.title);
                c5652a2.asE(c21038b.content);
                c5652a2.mo11482rc(false);
                c5652a2.mo11453Qc(C25738R.string.c86).mo11457a(this.nmX);
                c5652a2.aMb().show();
                AppMethodBeat.m2505o(112215);
                return;
            }
        }
        C5652a c5652a3 = new C5652a(this.mContext);
        c5652a3.mo11450PZ(C25738R.string.c87);
        c5652a3.mo11453Qc(C25738R.string.c86);
        c5652a3.aMb().show();
        AppMethodBeat.m2505o(112215);
    }
}
