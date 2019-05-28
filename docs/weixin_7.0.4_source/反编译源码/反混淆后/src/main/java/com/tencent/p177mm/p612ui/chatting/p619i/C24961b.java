package com.tencent.p177mm.p612ui.chatting.p619i;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoiceaddr.p875ui.C42239b.C9756a;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C23698ah;
import com.tencent.p177mm.p612ui.chatting.C23698ah.C23699a;
import com.tencent.p177mm.p612ui.chatting.C44308i;
import com.tencent.p177mm.p612ui.chatting.C46660k;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C23689f;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30455b;
import com.tencent.p177mm.p612ui.chatting.p1092e.C15633b.C15634a;
import com.tencent.p177mm.p612ui.chatting.p1092e.C15633b.C15635b;
import com.tencent.p177mm.p612ui.chatting.view.C23815a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C40444g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/* renamed from: com.tencent.mm.ui.chatting.i.b */
public abstract class C24961b implements C23689f, C15634a {
    protected String emo;
    protected ArrayList<C30455b> iPr = null;
    private LinearLayoutManager jop;
    private boolean kuU = false;
    protected Context mContext;
    private long yUK = 0;
    protected C15635b yYY;
    C30452c yYZ;
    protected ArrayList<C30455b> yZa = null;

    /* renamed from: com.tencent.mm.ui.chatting.i.b$2 */
    class C249622 implements C9756a {
        private C7564ap emH = new C7564ap(C9638aw.m17180RS().oAl.getLooper(), new C249631(), false);
        String yNK = "";

        /* renamed from: com.tencent.mm.ui.chatting.i.b$2$1 */
        class C249631 implements C5015a {

            /* renamed from: com.tencent.mm.ui.chatting.i.b$2$1$2 */
            class C53452 implements Runnable {
                C53452() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(32528);
                    if (C24961b.this.yYY != null) {
                        C24961b.this.yYZ.aop.notifyChanged();
                        C24961b.this.yYY.mo27867ch(C249622.this.yNK, C24961b.this.iPr.isEmpty());
                    }
                    AppMethodBeat.m2505o(32528);
                }
            }

            /* renamed from: com.tencent.mm.ui.chatting.i.b$2$1$1 */
            class C249641 implements Runnable {
                C249641() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(32527);
                    if (C24961b.this.yYY != null) {
                        C24961b.this.yYY.mo27867ch(C249622.this.yNK, false);
                        C24961b.this.yYZ.aop.notifyChanged();
                    }
                    AppMethodBeat.m2505o(32527);
                }
            }

            C249631() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(32529);
                String str = "MicroMsg.BaseHistoryListPresenter";
                String str2 = "[onTimerExpired]  mDataListCache is null?:%s mSearchText is null?:%s";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(C24961b.this.yZa == null);
                objArr[1] = Boolean.valueOf(C5046bo.isNullOrNil(C249622.this.yNK));
                C4990ab.m7417i(str, str2, objArr);
                if (C5046bo.isNullOrNil(C249622.this.yNK)) {
                    C24961b.this.yYZ.yNK = C249622.this.yNK;
                    if (C24961b.this.yZa == null) {
                        C24961b.this.dFH();
                    } else {
                        C24961b.this.iPr = C24961b.this.yZa;
                        C5004al.m7441d(new C249641());
                    }
                    AppMethodBeat.m2505o(32529);
                } else {
                    C24961b.this.iPr = C24961b.this.yZa;
                    ArrayList arrayList = new ArrayList();
                    Iterator it = C24961b.this.iPr.iterator();
                    while (it.hasNext()) {
                        C30455b c30455b = (C30455b) it.next();
                        if (c30455b.arg(C249622.this.yNK)) {
                            arrayList.add(c30455b);
                        }
                    }
                    C24961b.this.iPr = arrayList;
                    C24961b.this.yYZ.yNK = C249622.this.yNK;
                    C5004al.m7441d(new C53452());
                    AppMethodBeat.m2505o(32529);
                }
                return false;
            }
        }

        C249622() {
            AppMethodBeat.m2504i(32530);
            AppMethodBeat.m2505o(32530);
        }

        public final void amJ() {
        }

        /* renamed from: a */
        public final void mo21125a(boolean z, String[] strArr, long j, int i) {
        }

        public final void app() {
        }

        public final void apo() {
            AppMethodBeat.m2504i(32531);
            C4990ab.m7410d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
            if (C24961b.this.yYY != null) {
                C24961b.this.yYY.onFinish();
            }
            AppMethodBeat.m2505o(32531);
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(32532);
            if (!this.yNK.equals(str)) {
                this.yNK = str;
                this.emH.stopTimer();
                this.emH.mo16770ae(500, 500);
            }
            AppMethodBeat.m2505o(32532);
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            return false;
        }

        public final void apq() {
        }

        public final void apr() {
            AppMethodBeat.m2504i(32533);
            C4990ab.m7416i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
            AppMethodBeat.m2505o(32533);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.b$3 */
    class C249653 implements C23698ah {
        C249653() {
        }

        public final void dCI() {
        }

        /* renamed from: a */
        public final void mo27932a(C23699a c23699a) {
        }

        /* renamed from: b */
        public final void mo27933b(C23699a c23699a) {
        }

        public final boolean dCJ() {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.b$1 */
    class C249671 extends C25373h {
        int kvg = C24961b.this.mContext.getResources().getColor(C25738R.color.f11995ov);
        ColorDrawable kvh = new ColorDrawable(this.kvg);
        int mSize = ((int) C24961b.this.mContext.getResources().getDimension(C25738R.dimen.f9723do));

        C249671() {
            AppMethodBeat.m2504i(32525);
            AppMethodBeat.m2505o(32525);
        }

        /* renamed from: a */
        public final void mo6920a(Canvas canvas, RecyclerView recyclerView, C31880s c31880s) {
            AppMethodBeat.m2504i(32526);
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt.getTag() != null) {
                    C30455b Oy = C24961b.this.mo39522Oy(((Integer) childAt.getTag()).intValue() + 1);
                    if (Oy == null || Oy.getType() != BaseClientBuilder.API_PRIORITY_OTHER) {
                        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                        int bottom = layoutParams.bottomMargin + childAt.getBottom();
                        this.kvh.setBounds(paddingLeft, bottom, width, this.mSize + bottom);
                        this.kvh.draw(canvas);
                    }
                }
            }
            AppMethodBeat.m2505o(32526);
        }
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo39610a(C23815a c23815a) {
        C15635b c15635b = (C15635b) c23815a;
        this.yYY = c15635b;
        c15635b.mo27875a(this);
    }

    public C24961b(Context context) {
        this.mContext = context;
        this.iPr = new ArrayList();
    }

    public final void onDetach() {
        this.yYY.mo27875a(null);
        this.yYY = null;
        if (this.yYZ != null) {
            C30452c.yNI = null;
            C30452c.yNJ = null;
        }
    }

    public final C25373h dFG() {
        return new C249671();
    }

    /* renamed from: Oy */
    public final C30455b mo39522Oy(int i) {
        if (this.iPr == null || this.iPr.size() <= i) {
            return null;
        }
        return (C30455b) this.iPr.get(i);
    }

    public final C41523a aru(String str) {
        this.emo = str;
        this.yYZ = new C30452c(this.mContext, this);
        C30452c.yNI = dFI();
        return this.yYZ;
    }

    public final int getCount() {
        if (this.iPr == null) {
            return 0;
        }
        return this.iPr.size();
    }

    public final C9756a dFJ() {
        return new C249622();
    }

    /* renamed from: b */
    protected static String m39082b(C7620bi c7620bi, boolean z) {
        String str = null;
        if (c7620bi == null) {
            return null;
        }
        if (c7620bi.field_isSend == 1) {
            return C1853r.m3846Yz();
        }
        if (z) {
            str = C1829bf.m3762oy(c7620bi.field_content);
        }
        if (C5046bo.isNullOrNil(str)) {
            return c7620bi.field_talker;
        }
        return str;
    }

    /* renamed from: d */
    public final void mo41865d(int i, C7620bi c7620bi) {
        C4990ab.m7417i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", Integer.valueOf(i));
        switch (i) {
            case 0:
                m39084bI(c7620bi);
                return;
            case 1:
                m39083bH(c7620bi);
                return;
            case 2:
                m39085bJ(c7620bi);
                return;
            default:
                return;
        }
    }

    /* renamed from: bH */
    private void m39083bH(C7620bi c7620bi) {
        C45316cl c45316cl = new C45316cl();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(c7620bi);
        if (C40444g.m69402a(this.mContext, c45316cl, this.emo, arrayList, false)) {
            m39086c(c45316cl);
        } else {
            C4990ab.m7412e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
        }
    }

    /* renamed from: c */
    private void m39086c(C45316cl c45316cl) {
        c45316cl.cvA.cvH = 45;
        c45316cl.cvA.activity = (Activity) this.mContext;
        C4879a.xxA.mo10055m(c45316cl);
        if (c45316cl.cvB.ret != -2 && c45316cl.cvB.ret <= 0 && c45316cl.cvB.ret <= 0) {
            if (14 != c45316cl.cvA.type) {
                C4990ab.m7410d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
            } else if (c45316cl.cvA.cvD == null) {
                C4990ab.m7412e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
            } else {
                C7060h.pYm.mo8381e(11142, Integer.valueOf(c45316cl.cvA.cvD.wiK), Integer.valueOf(c45316cl.cvA.cvD.wiL), Integer.valueOf(c45316cl.cvA.cvD.wiM), Integer.valueOf(c45316cl.cvA.cvD.wiN), Integer.valueOf(c45316cl.cvA.cvD.wiO), Integer.valueOf(c45316cl.cvA.cvD.wiP), Integer.valueOf(c45316cl.cvA.cvD.wiQ), Integer.valueOf(c45316cl.cvA.cvD.fileCount), Integer.valueOf(c45316cl.cvA.cvD.wiR), Integer.valueOf(c45316cl.cvA.cvD.wiS), Integer.valueOf(c45316cl.cvA.cvD.wiT), Integer.valueOf(c45316cl.cvA.cvD.wiU), Integer.valueOf(c45316cl.cvA.cvD.wiV), Integer.valueOf(c45316cl.cvA.cvD.wiW), Integer.valueOf(c45316cl.cvA.cvD.wiX));
            }
        }
    }

    /* renamed from: bI */
    private void m39084bI(C7620bi c7620bi) {
        C7060h.pYm.mo8378a(219, 19, 1, true);
        boolean endsWith = this.emo.toLowerCase().endsWith("@chatroom");
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(c7620bi);
        C46660k.m88358a(this.mContext, arrayList, endsWith, this.emo, new C249653());
    }

    /* renamed from: bJ */
    private void m39085bJ(final C7620bi c7620bi) {
        C7060h.pYm.mo8381e(11627, Integer.valueOf(5));
        final TreeSet treeSet = new TreeSet();
        treeSet.add(Long.valueOf(c7620bi.field_msgId));
        C30379h.m48466d(this.mContext, this.mContext.getString(C25738R.string.at7), "", this.mContext.getString(C25738R.string.b59), this.mContext.getString(C25738R.string.f9076or), new OnClickListener() {

            /* renamed from: com.tencent.mm.ui.chatting.i.b$4$1 */
            class C156891 implements C23698ah {

                /* renamed from: com.tencent.mm.ui.chatting.i.b$4$1$1 */
                class C156901 extends C30455b {
                    C156901() {
                    }

                    public final int getType() {
                        return -1;
                    }
                }

                C156891() {
                }

                public final void dCI() {
                }

                /* renamed from: a */
                public final void mo27932a(C23699a c23699a) {
                    AppMethodBeat.m2504i(32534);
                    if (c23699a == C23699a.del) {
                        C156901 c156901 = new C156901();
                        c156901.cvx = c7620bi.field_msgId;
                        C24961b.this.iPr.remove(c156901);
                        C24961b.this.yZa.remove(c156901);
                    }
                    AppMethodBeat.m2505o(32534);
                }

                /* renamed from: b */
                public final void mo27933b(C23699a c23699a) {
                    AppMethodBeat.m2504i(32535);
                    C4990ab.m7417i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", Thread.currentThread(), c23699a);
                    if (c23699a == C23699a.del) {
                        C24961b.this.yYZ.aop.notifyChanged();
                    }
                    AppMethodBeat.m2505o(32535);
                }

                public final boolean dCJ() {
                    return true;
                }
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(32536);
                C4990ab.m7416i("MicroMsg.BaseHistoryListPresenter", "delete message");
                C44308i.m80089a(C24961b.this.mContext, treeSet, new C156891());
                AppMethodBeat.m2505o(32536);
            }
        }, null);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dFS() {
        long j = this.yUK + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        this.yUK = currentTimeMillis;
        if (j < currentTimeMillis) {
            C9638aw.m17190ZK();
            this.kuU = C18628c.isSDCardAvailable();
        }
        return this.kuU;
    }

    public final /* synthetic */ C17480i bfC() {
        if (this.jop == null) {
            this.jop = new LinearLayoutManager();
        }
        return this.jop;
    }
}
