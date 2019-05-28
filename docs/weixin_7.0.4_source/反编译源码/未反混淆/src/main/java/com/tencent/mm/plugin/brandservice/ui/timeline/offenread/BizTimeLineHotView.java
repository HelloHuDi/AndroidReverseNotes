package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.support.v7.widget.RecyclerView.h;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.v;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BizTimeLineHotView extends LinearLayout implements f, b {
    private int iWJ = 0;
    public e jQg = new e();
    WeakReference<Activity> jQk;
    private BizTimeLineHotListView jQl;
    private boolean jQm = false;
    private List<b> jQn = new ArrayList();
    private c jQo;
    private int jQp = 0;
    public c jQq = new c<ah>() {
        {
            AppMethodBeat.i(14307);
            this.xxI = ah.class.getName().hashCode();
            AppMethodBeat.o(14307);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(14308);
            final ah ahVar = (ah) bVar;
            if (!(ahVar == null || ahVar.ctf == null || bo.isNullOrNil(ahVar.ctf.userName) || BizTimeLineHotView.this.jQn == null)) {
                com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(14306);
                        for (Object obj : BizTimeLineHotView.this.jQn) {
                            if (ahVar.ctf.userName.equals(obj.vGE)) {
                                break;
                            }
                        }
                        Object obj2 = null;
                        if (obj2 != null) {
                            BizTimeLineHotView.this.jQn.remove(obj2);
                        }
                        BizTimeLineHotView.b(BizTimeLineHotView.this);
                        AppMethodBeat.o(14306);
                    }
                }, 0);
            }
            AppMethodBeat.o(14308);
            return false;
        }
    };
    private boolean jQr = true;
    private IdleHandler jQs = new IdleHandler() {
        public final boolean queueIdle() {
            AppMethodBeat.i(14312);
            Looper.myQueue().removeIdleHandler(BizTimeLineHotView.this.jQs);
            if (BizTimeLineHotView.this.jQk.get() == null || ((Activity) BizTimeLineHotView.this.jQk.get()).isFinishing()) {
                AppMethodBeat.o(14312);
            } else {
                BizTimeLineHotView.this.jQl.aZ(BizTimeLineHotView.this.jQn);
                AppMethodBeat.o(14312);
            }
            return false;
        }
    };
    private TextView jao;

    public BizTimeLineHotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(14314);
        init(context);
        AppMethodBeat.o(14314);
    }

    public BizTimeLineHotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(14315);
        init(context);
        AppMethodBeat.o(14315);
    }

    public final void d(q qVar) {
        AppMethodBeat.i(14316);
        if (qVar != null) {
            q mE = z.aeX().mE((long) qVar.field_talkerId);
            if (mE != null && mE.field_msgId == qVar.field_msgId) {
                ((j) g.K(j.class)).XR().apb(qVar.field_talker);
                FF(qVar.field_talker);
            }
        }
        AppMethodBeat.o(14316);
    }

    private void FF(final String str) {
        AppMethodBeat.i(14317);
        com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                AppMethodBeat.i(14305);
                if (BizTimeLineHotView.this.jQn == null) {
                    AppMethodBeat.o(14305);
                } else if (str == null || t.ny(str)) {
                    AppMethodBeat.o(14305);
                } else {
                    for (b bVar : BizTimeLineHotView.this.jQn) {
                        if (str.equals(bVar.vGE)) {
                            if (BizTimeLineHotView.a(bVar)) {
                                BizTimeLineHotView.a(BizTimeLineHotView.this, bVar);
                                AppMethodBeat.o(14305);
                                return;
                            }
                            AppMethodBeat.o(14305);
                        }
                    }
                    AppMethodBeat.o(14305);
                }
            }
        }, 0);
        AppMethodBeat.o(14317);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(14318);
        if (obj == null || !(obj instanceof String)) {
            ab.e("MicroMsg.BizTimeLineHotList", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(14318);
            return;
        }
        FF((String) obj);
        AppMethodBeat.o(14318);
    }

    public int getItemPadding() {
        AppMethodBeat.i(14319);
        int dj = a.dj(getContext());
        AppMethodBeat.o(14319);
        return dj;
    }

    private void init(Context context) {
        AppMethodBeat.i(14320);
        g.Rg().a(2768, (f) this);
        this.jQk = new WeakReference((Activity) context);
        a.init(context);
        this.iWJ = getItemPadding();
        View inflate = v.hu(context).inflate(R.layout.h1, this);
        this.jQl = (BizTimeLineHotListView) inflate.findViewById(R.id.a7f);
        this.jao = (TextView) inflate.findViewById(R.id.a7d);
        this.jQo = new c(this.iWJ);
        this.jQl.b((h) this.jQo);
        this.jQl.a(context, this.jQn, this.jQg);
        getLocalOftenReadData();
        getOftenRead();
        ((j) g.K(j.class)).XR().a(this);
        a.xxA.c(this.jQq);
        AppMethodBeat.o(14320);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(14321);
        super.onConfigurationChanged(configuration);
        if (this.jQp != configuration.orientation) {
            if (this.jQo != null) {
                this.iWJ = getItemPadding();
                this.jQo.padding = this.iWJ;
            }
            this.jQp = configuration.orientation;
            Looper.myQueue().addIdleHandler(this.jQs);
        }
        AppMethodBeat.o(14321);
    }

    public void setTitlePaddingLeft(int i) {
        AppMethodBeat.i(14322);
        if (this.jao != null) {
            TextView textView = this.jao;
            textView.setPadding(i, textView.getPaddingTop(), this.jao.getPaddingRight(), this.jao.getPaddingBottom());
        }
        AppMethodBeat.o(14322);
    }

    private void getLocalOftenReadData() {
        AppMethodBeat.i(14323);
        if (bo.ek(this.jQn)) {
            a(d.aWL());
            AppMethodBeat.o(14323);
            return;
        }
        AppMethodBeat.o(14323);
    }

    private void getOftenRead() {
        AppMethodBeat.i(14324);
        com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                AppMethodBeat.i(14309);
                BizTimeLineHotView.c(BizTimeLineHotView.this);
                AppMethodBeat.o(14309);
            }
        }, 0);
        AppMethodBeat.o(14324);
    }

    private void a(final chc chc) {
        AppMethodBeat.i(14325);
        if (chc != null) {
            com.tencent.mm.plugin.brandservice.ui.b.a.gP((long) (chc.xfZ * 1000));
            com.tencent.mm.plugin.brandservice.ui.b.a.gQ((long) chc.xfX);
        }
        if (chc == null || bo.ek(chc.xfW)) {
            if (bo.ek(this.jQn)) {
                setVisibility(8);
            }
            ab.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size is null");
            AppMethodBeat.o(14325);
            return;
        }
        ab.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size %d,server_rank:%d,display_ctrl_flag:%d", Integer.valueOf(chc.xfW.size()), Integer.valueOf(chc.xfY), Integer.valueOf(chc.xfX));
        if (com.tencent.mm.plugin.brandservice.ui.b.a.sG(4)) {
            setVisibility(8);
            AppMethodBeat.o(14325);
            return;
        }
        com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                boolean z = false;
                AppMethodBeat.i(14310);
                BizTimeLineHotView.this.jQn = new ArrayList();
                Iterator it = chc.xfW.iterator();
                int i = 0;
                while (it.hasNext()) {
                    chd chd = (chd) it.next();
                    i++;
                    if (i > 12) {
                        break;
                    }
                    b bVar = new b();
                    if (t.mY(chd.vGE)) {
                        bVar.vGE = chd.vGE;
                        BizTimeLineHotView.this.jQn.add(bVar);
                    }
                }
                BizTimeLineHotView.this.aWK();
                BizTimeLineHotView bizTimeLineHotView = BizTimeLineHotView.this;
                if (chc.xfY == 1) {
                    z = true;
                }
                BizTimeLineHotView.a(bizTimeLineHotView, z);
                BizTimeLineHotView.b(BizTimeLineHotView.this);
                AppMethodBeat.o(14310);
            }
        }, 0);
        AppMethodBeat.o(14325);
    }

    public final void aWK() {
        AppMethodBeat.i(14326);
        if (bo.ek(this.jQn)) {
            AppMethodBeat.o(14326);
            return;
        }
        for (b a : this.jQn) {
            a(a);
        }
        AppMethodBeat.o(14326);
    }

    public static boolean a(b bVar) {
        AppMethodBeat.i(14327);
        long aoP = ((j) g.K(j.class)).XM().aoP(bVar.vGE);
        q mE = z.aeX().mE(aoP);
        if (mE == null) {
            AppMethodBeat.o(14327);
            return false;
        }
        bVar.jrh = mE.field_createTime;
        ak aoZ = ((j) g.K(j.class)).XR().aoZ(bVar.vGE);
        boolean z = bVar.jQz;
        bVar.jQz = false;
        if (aoZ != null && aoZ.field_unReadCount > 0 && System.currentTimeMillis() - bVar.jrh < com.tencent.mm.plugin.brandservice.ui.b.a.aYQ() && aoZ.field_unReadCount > z.aeY().mN(aoP)) {
            bVar.jQz = true;
        }
        if (z != bVar.jQz) {
            AppMethodBeat.o(14327);
            return true;
        }
        AppMethodBeat.o(14327);
        return false;
    }

    public final void aWJ() {
        AppMethodBeat.i(14328);
        if (getVisibility() != 0 || bo.ek(this.jQn)) {
            AppMethodBeat.o(14328);
            return;
        }
        this.jQl.aWJ();
        AppMethodBeat.o(14328);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(14329);
        ab.i("MicroMsg.BizTimeLineHotList", "onSceneEnd, type %d, errType = %d, errCode = %d", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            if (mVar instanceof g) {
                chc chc = (chc) ((g) mVar).ehh.fsH.fsP;
                if (this.jQk.get() != null && ((Activity) this.jQk.get()).isFinishing()) {
                    AppMethodBeat.o(14329);
                    return;
                } else if (com.tencent.mm.plugin.brandservice.ui.b.c.b(chc, d.aWL())) {
                    ab.d("MicroMsg.BizTimeLineHotList", "onSceneEnd nothing change");
                    AppMethodBeat.o(14329);
                    return;
                } else {
                    d.jQA = chc;
                    try {
                        g.RP().Ry().set(ac.a.USERINFO_BIZ_TIME_LINE_OFTEN_READ_STRING_SYNC, Base64.encodeToString(chc.toByteArray(), 0));
                    } catch (IOException e) {
                        ab.e("MicroMsg.BizTimeLineOftenReadHelper", "resetOftenRead exp: %s", e.getMessage());
                        g.RP().Ry().set(ac.a.USERINFO_BIZ_TIME_LINE_OFTEN_READ_STRING_SYNC, (Object) "");
                    }
                    a(chc);
                }
            }
            AppMethodBeat.o(14329);
            return;
        }
        AppMethodBeat.o(14329);
    }

    static /* synthetic */ void b(BizTimeLineHotView bizTimeLineHotView) {
        AppMethodBeat.i(14331);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(14311);
                if (BizTimeLineHotView.this.jQk.get() != null && ((Activity) BizTimeLineHotView.this.jQk.get()).isFinishing()) {
                    AppMethodBeat.o(14311);
                } else if (bo.ek(BizTimeLineHotView.this.jQn)) {
                    BizTimeLineHotView.this.setVisibility(8);
                    AppMethodBeat.o(14311);
                } else {
                    if (BizTimeLineHotView.this.getVisibility() != 0) {
                        BizTimeLineHotView.this.setVisibility(0);
                    }
                    if (BizTimeLineHotView.this.jQr) {
                        BizTimeLineHotView.this.jQr = false;
                        BizTimeLineHotView.this.jQl.aZ(BizTimeLineHotView.this.jQn);
                        AppMethodBeat.o(14311);
                        return;
                    }
                    Looper.myQueue().removeIdleHandler(BizTimeLineHotView.this.jQs);
                    Looper.myQueue().addIdleHandler(BizTimeLineHotView.this.jQs);
                    AppMethodBeat.o(14311);
                }
            }
        });
        AppMethodBeat.o(14331);
    }

    static /* synthetic */ void c(BizTimeLineHotView bizTimeLineHotView) {
        AppMethodBeat.i(14332);
        if (!bizTimeLineHotView.jQm) {
            bizTimeLineHotView.jQm = true;
            g.Rg().a(new g(), 0);
        }
        AppMethodBeat.o(14332);
    }
}
