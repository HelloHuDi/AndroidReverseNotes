package com.tencent.mm.ui.chatting.l.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.f.d;
import com.tencent.mm.ui.chatting.f.d.c;
import com.tencent.mm.ui.chatting.l.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import org.xwalk.core.Log;

public abstract class a implements com.tencent.mm.ui.chatting.f.b.a {
    com.tencent.mm.ui.chatting.d.a cgL;
    long yZQ;
    long yZR;
    public d zae;
    int zaf;
    int zag;
    long zah;
    long zai;
    int zaj = 3;

    public abstract e a(com.tencent.mm.ui.chatting.f.d.a aVar, Bundle bundle, d.d dVar);

    public a(com.tencent.mm.ui.chatting.d.a aVar, d dVar) {
        this.cgL = aVar;
        this.zae = dVar;
    }

    public void a(final com.tencent.mm.ui.chatting.f.d.a aVar, boolean z, final Bundle bundle) {
        Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] action:" + aVar + " isBlock:" + z + " username:" + this.cgL.getTalkerUserName());
        if (bo.isNullOrNil(this.cgL.getTalkerUserName())) {
            Log.w("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] username is null!");
            return;
        }
        g.BN(13);
        ((h) this.cgL.aF(h.class)).dCU();
        this.zae.a(aVar, z, new c<bi>() {
            public final e b(d.d<bi> dVar) {
                AppMethodBeat.i(32713);
                dVar.yYz = bundle;
                e a = a.this.a(aVar, bundle, (d.d) dVar);
                AppMethodBeat.o(32713);
                return a;
            }

            public final void c(d.d<bi> dVar) {
                AppMethodBeat.i(32714);
                a.this.zaf = dVar.enb;
                a.this.zag = dVar.yYC;
                if (dVar.yYB.size() > 0) {
                    bi biVar = (bi) dVar.yYB.get(0);
                    if (biVar != null) {
                        a.this.yZQ = biVar.field_createTime;
                        a.this.zai = biVar.field_msgSeq;
                    }
                    biVar = (bi) dVar.yYB.get(dVar.yYB.size() - 1);
                    if (biVar != null) {
                        a.this.yZR = biVar.field_createTime;
                        a.this.zah = biVar.field_msgSeq;
                    }
                }
                AppMethodBeat.o(32714);
            }
        });
    }

    public void a(MMChattingListView mMChattingListView, d.d<bi> dVar) {
        g.BO(13);
        mMChattingListView.getBaseAdapter().notifyDataSetChanged();
        ((h) this.cgL.aF(h.class)).dCV();
        if (dVar.yYA == com.tencent.mm.ui.chatting.f.d.a.ACTION_UPDATE) {
            this.cgL.yTx.cch();
        }
    }

    public String toString() {
        return getClass().getName();
    }

    /* Access modifiers changed, original: protected|final */
    public final void Pj(final int i) {
        this.zaj = 3;
        this.cgL.Oq(i);
        this.cgL.getListView().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(32715);
                if (a.this.cgL.getFirstVisiblePosition() > i || i > a.this.cgL.getLastVisiblePosition()) {
                    Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] pos:" + i + " reTryCount:" + a.this.zaj);
                    a.this.cgL.ho(i, 0);
                    a aVar = a.this;
                    aVar.zaj--;
                    if (a.this.zaj >= 0) {
                        a.this.cgL.getListView().postDelayed(this, 20);
                        AppMethodBeat.o(32715);
                        return;
                    }
                }
                Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] successfully! pos:" + i);
                AppMethodBeat.o(32715);
            }
        }, 200);
    }
}
