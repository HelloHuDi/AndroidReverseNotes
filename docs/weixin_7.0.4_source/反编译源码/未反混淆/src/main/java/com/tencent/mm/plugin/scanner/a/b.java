package com.tencent.mm.plugin.scanner.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class b {
    Activity mActivity;
    String pZu;
    e pZv;
    a pZw;
    e.a pZx = new e.a() {
        public final void o(int i, Bundle bundle) {
            AppMethodBeat.i(80824);
            ab.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", Integer.valueOf(i));
            kv kvVar = new kv();
            kvVar.cGM.cGK = i;
            kvVar.cGM.activity = b.this.mActivity;
            kvVar.cGM.ctB = b.this.pZu;
            kvVar.cGM.cGN = bundle;
            com.tencent.mm.sdk.b.a.xxA.m(kvVar);
            AppMethodBeat.o(80824);
        }
    };
    public c pZy = new c<cf>() {
        {
            AppMethodBeat.i(80825);
            this.xxI = cf.class.getName().hashCode();
            AppMethodBeat.o(80825);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            int i = 2;
            AppMethodBeat.i(80826);
            cf cfVar = (cf) bVar;
            if (cfVar == null || !(cfVar instanceof cf)) {
                ab.e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a DealQBarStrEvent instance");
            } else {
                b.this.cgE();
                b.this.pZu = cfVar.cvm.ctB;
                b.this.mActivity = cfVar.cvm.activity;
                ab.i("MicroMsg.ExternRequestDealQBarStrHandler", "request deal qbar, activity:%s, str:%s, codeType: %s, codeVersion: %s, from : %d", b.this.mActivity, b.this.pZu, Integer.valueOf(cfVar.cvm.cvn), Integer.valueOf(cfVar.cvm.cvo), Integer.valueOf(cfVar.cvm.from));
                if (cfVar.cvm.cvn == 19 || cfVar.cvm.cvn == 22) {
                    b.this.pZv = new e();
                    b.this.pZv.cvp = cfVar.cvm.cvp;
                    b.this.pZv.imagePath = cfVar.cvm.imagePath;
                    b.this.pZv.cvr = cfVar.cvm.cvr;
                    b.this.pZv.source = cfVar.cvm.source;
                    if (cfVar.cvm.from >= 0) {
                        i = 3;
                    }
                    if (cfVar.cvm.scene > 0) {
                        b.this.pZv.jSW = cfVar.cvm.scene;
                    }
                    if (i == 3) {
                        b.this.pZv.appId = cfVar.cvm.cvq;
                    }
                    b.this.pZv.a(b.this.mActivity, b.this.pZu, i, cfVar.cvm.cvn, cfVar.cvm.cvo, b.this.pZx, cfVar.cvm.cvs);
                } else {
                    b.this.pZw = new a();
                    f fVar = b.this.pZw;
                    Context context = b.this.mActivity;
                    String str = b.this.pZu;
                    int i2 = cfVar.cvm.cvn;
                    int i3 = cfVar.cvm.cvo;
                    Bundle bundle = cfVar.cvm.cvs;
                    if (!bo.isNullOrNil(str)) {
                        String[] split = str.split(",");
                        if (split == null || split.length < 2) {
                            ab.e("MicroMsg.BarcodeStringHandler", "wrong zbar format");
                        } else {
                            fVar.czX = context;
                            fVar.cvs = bundle;
                            m gVar = new g(r.Ws(split[0]), split[1], i2, i3);
                            g.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_QINSHUI, fVar);
                            g.Rg().a(gVar, 0);
                            context.getString(R.string.tz);
                            fVar.ehJ = h.b(context, context.getString(R.string.dgn), true, new com.tencent.mm.plugin.scanner.util.a.AnonymousClass1(gVar));
                        }
                    }
                }
            }
            AppMethodBeat.o(80826);
            return false;
        }
    };
    public c pZz = new c<am>() {
        {
            AppMethodBeat.i(80827);
            this.xxI = am.class.getName().hashCode();
            AppMethodBeat.o(80827);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(80828);
            am amVar = (am) bVar;
            if (amVar == null || !(amVar instanceof am)) {
                ab.e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a CancelDealQBarStrEvent instance");
                AppMethodBeat.o(80828);
            } else {
                ab.i("MicroMsg.ExternRequestDealQBarStrHandler", "cancel deal qbar, activity:%s, str:%s", b.this.mActivity, b.this.pZu);
                if (amVar.ctA.activity == b.this.mActivity && amVar.ctA.ctB.equals(b.this.pZu)) {
                    b.this.cgE();
                    AppMethodBeat.o(80828);
                } else {
                    ab.e("MicroMsg.ExternRequestDealQBarStrHandler", "not same as string that are dealing");
                    AppMethodBeat.o(80828);
                }
            }
            return false;
        }
    };

    public b() {
        AppMethodBeat.i(80829);
        AppMethodBeat.o(80829);
    }

    public final void cgE() {
        AppMethodBeat.i(80830);
        if (this.pZv != null) {
            this.pZv.chU();
            this.pZv = null;
        }
        this.mActivity = null;
        this.pZu = null;
        AppMethodBeat.o(80830);
    }
}
