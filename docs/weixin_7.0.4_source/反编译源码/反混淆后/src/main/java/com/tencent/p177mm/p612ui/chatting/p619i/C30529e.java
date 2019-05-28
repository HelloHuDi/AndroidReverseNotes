package com.tencent.p177mm.p612ui.chatting.p619i;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Looper;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.GridLayoutManager.C8440b;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.modelvideo.C9720t.C9721a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C9362gs;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C23696ac;
import com.tencent.p177mm.p612ui.chatting.C23698ah;
import com.tencent.p177mm.p612ui.chatting.C23698ah.C23699a;
import com.tencent.p177mm.p612ui.chatting.C40707a;
import com.tencent.p177mm.p612ui.chatting.C40707a.C23688d;
import com.tencent.p177mm.p612ui.chatting.C40707a.C40706c;
import com.tencent.p177mm.p612ui.chatting.C44308i;
import com.tencent.p177mm.p612ui.chatting.C46660k;
import com.tencent.p177mm.p612ui.chatting.gallery.C15659h.C15660a;
import com.tencent.p177mm.p612ui.chatting.gallery.C15659h.C15661b;
import com.tencent.p177mm.p612ui.chatting.gallery.C15663j;
import com.tencent.p177mm.p612ui.chatting.gallery.C40775c;
import com.tencent.p177mm.p612ui.chatting.gallery.C40780e;
import com.tencent.p177mm.p612ui.chatting.p1089a.C15565b;
import com.tencent.p177mm.p612ui.chatting.p1089a.C15565b.C15564b;
import com.tencent.p177mm.p612ui.chatting.p1089a.C15565b.C15569c;
import com.tencent.p177mm.p612ui.chatting.p1092e.C30496a.C30497b;
import com.tencent.p177mm.p612ui.chatting.p1092e.C30496a.C30499a;
import com.tencent.p177mm.p612ui.gridviewheaders.C15894a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C40444g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/* renamed from: com.tencent.mm.ui.chatting.i.e */
public final class C30529e implements C9017a, C9721a, C30499a, C15661b {
    static int count = 0;
    private String emo;
    private ArrayList<C15569c> iPr = null;
    private C4884c kvj = new C305339();
    private GridLayoutManager kvk;
    private Context mContext;
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper());
    boolean moy = false;
    private int moz = 0;
    private long yNB;
    private int yZg = 0;
    private C30497b yZk;
    C15565b yZl;
    private int yZm = 0;
    private boolean yZn = false;

    /* renamed from: com.tencent.mm.ui.chatting.i.e$13 */
    class C1569113 implements Runnable {
        C1569113() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32573);
            if (C30529e.this.yZk != null) {
                C30529e.this.yZk.mo48891OI(C25738R.string.c46);
            }
            AppMethodBeat.m2505o(32573);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.e$1 */
    class C237861 extends C8440b {
        C237861() {
        }

        /* renamed from: bU */
        public final int mo18459bU(int i) {
            AppMethodBeat.m2504i(32552);
            if (((C15569c) C30529e.this.iPr.get(i)).type == BaseClientBuilder.API_PRIORITY_OTHER) {
                AppMethodBeat.m2505o(32552);
                return 4;
            }
            AppMethodBeat.m2505o(32552);
            return 1;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.e$12 */
    class C3052512 implements Runnable {
        C3052512() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32572);
            if (C30529e.this.yZk != null) {
                C30529e.this.yZk.mo48891OI(C25738R.string.c46);
            }
            AppMethodBeat.m2505o(32572);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.e$14 */
    class C3052614 implements Runnable {
        C3052614() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32574);
            if (C30529e.this.yZk != null) {
                C30529e.this.yZk.dFE();
            }
            AppMethodBeat.m2505o(32574);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.e$10 */
    class C3053010 implements C15564b {
        C3053010() {
        }

        /* renamed from: a */
        public final void mo27740a(boolean z, C15569c c15569c, int i) {
            AppMethodBeat.m2504i(32570);
            C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", Boolean.valueOf(z), Integer.valueOf(i));
            if (!z || C15660a.yVE.mnX.size() < 9) {
                if (z) {
                    C15660a.yVE.mo27887bC(c15569c.cKd);
                } else {
                    C15660a.yVE.mo27888bD(c15569c.cKd);
                }
                C30529e.this.yZk.mo48900vF(C15660a.yVE.mnX.size());
                AppMethodBeat.m2505o(32570);
                return;
            }
            Toast.makeText(C30529e.this.mContext, C30529e.this.mContext.getResources().getString(C25738R.string.c3z, new Object[]{Integer.valueOf(9)}), 1).show();
            C30529e.this.yZl.mo66316cg(i);
            AppMethodBeat.m2505o(32570);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.e$9 */
    class C305339 extends C4884c<C9362gs> {
        C305339() {
            AppMethodBeat.m2504i(32568);
            this.xxI = C9362gs.class.getName().hashCode();
            AppMethodBeat.m2505o(32568);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(32569);
            C9362gs c9362gs = (C9362gs) c4883b;
            C30529e.m48633a(C30529e.this, c9362gs.cBr.cvx, c9362gs);
            AppMethodBeat.m2505o(32569);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.e$11 */
    class C3053411 implements Runnable {
        C3053411() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32571);
            if (C30529e.this.yZk != null) {
                C30529e.this.yZk.dFE();
            }
            AppMethodBeat.m2505o(32571);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.e$6 */
    class C305386 implements C23698ah {
        C305386() {
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

    /* renamed from: fj */
    static /* synthetic */ void m48654fj(List list) {
        AppMethodBeat.m2504i(32609);
        C30529e.m48652fh(list);
        AppMethodBeat.m2505o(32609);
    }

    /* renamed from: g */
    static /* synthetic */ boolean m48655g(C30529e c30529e) {
        AppMethodBeat.m2504i(32607);
        boolean dGW = c30529e.dGW();
        AppMethodBeat.m2505o(32607);
        return dGW;
    }

    public C30529e(Context context) {
        AppMethodBeat.m2504i(32576);
        this.mContext = context;
        this.iPr = new ArrayList();
        AppMethodBeat.m2505o(32576);
    }

    public final void onDetach() {
        AppMethodBeat.m2504i(32577);
        this.kvj.dead();
        this.yZk.mo27875a(null);
        this.yZk = null;
        C32291o.ahm().mo33465a((C9017a) this);
        C37961o.all().mo21052a(this);
        C15660a.yVE.detach();
        C46660k.dCa();
        AppMethodBeat.m2505o(32577);
    }

    public final <T extends C17480i> T bfC() {
        AppMethodBeat.m2504i(32578);
        if (this.kvk == null) {
            this.kvk = new GridLayoutManager(4);
            this.kvk.akZ = new C237861();
        }
        GridLayoutManager gridLayoutManager = this.kvk;
        AppMethodBeat.m2505o(32578);
        return gridLayoutManager;
    }

    /* renamed from: dN */
    public final C25373h mo48910dN(final Context context) {
        AppMethodBeat.m2504i(32579);
        C156948 c156948 = new C25373h() {
            /* renamed from: a */
            public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
                AppMethodBeat.m2504i(32567);
                int dimension = (int) context.getResources().getDimension(C25738R.dimen.f9981m7);
                rect.bottom = dimension;
                rect.top = dimension;
                rect.left = dimension;
                rect.right = dimension;
                AppMethodBeat.m2505o(32567);
            }
        };
        AppMethodBeat.m2505o(32579);
        return c156948;
    }

    /* renamed from: aT */
    public final C41523a mo48901aT(String str, long j) {
        AppMethodBeat.m2504i(32580);
        this.emo = str;
        this.yNB = j;
        if (j == -1) {
            this.yZl = new C15565b(this.mContext, this.iPr, str);
        } else {
            this.yZl = new C15565b(this.mContext, this.iPr, str, j);
        }
        this.yZl.yNC = new C3053010();
        C15565b c15565b = this.yZl;
        AppMethodBeat.m2505o(32580);
        return c15565b;
    }

    public final String aoy() {
        AppMethodBeat.m2504i(32581);
        String string = this.mContext.getString(C25738R.string.f8803fg);
        AppMethodBeat.m2505o(32581);
        return string;
    }

    /* renamed from: vH */
    public final void mo48913vH(int i) {
        AppMethodBeat.m2504i(32582);
        C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", Integer.valueOf(i));
        ArrayList<C7620bi> arrayList = C15660a.yVE.mnX;
        switch (i) {
            case 0:
                C7060h.pYm.mo8378a(219, 19, 1, true);
                C46660k.m88358a(this.mContext, arrayList, C1855t.m3896kH(this.emo), this.emo, new C305386());
                this.yZk.bwr();
                AppMethodBeat.m2505o(32582);
                return;
            case 1:
                m48650ff(arrayList);
                AppMethodBeat.m2505o(32582);
                return;
            case 2:
                m48651fg(arrayList);
                break;
            case 3:
                this.yZk.dFD();
                final ArrayList arrayList2 = new ArrayList();
                for (C7620bi c7620bi : arrayList) {
                    if (!(C40775c.m70565bp(c7620bi) || C40775c.m70566bq(c7620bi))) {
                        arrayList2.add(c7620bi);
                    }
                }
                if (arrayList2.size() != arrayList.size()) {
                    C30379h.m48432a(this.mContext, (int) C25738R.string.c3v, (int) C25738R.string.f9238tz, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(32575);
                            C30529e.m48637a(C30529e.this, arrayList2);
                            AppMethodBeat.m2505o(32575);
                        }
                    }, null);
                    AppMethodBeat.m2505o(32582);
                    return;
                }
                m48649fe(arrayList2);
                AppMethodBeat.m2505o(32582);
                return;
        }
        AppMethodBeat.m2505o(32582);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(32587);
        if (this.moy && C15660a.yVE.mnY) {
            this.yZk.mo48900vF(C15660a.yVE.mnX.size());
            this.yZl.aop.notifyChanged();
        }
        AppMethodBeat.m2505o(32587);
    }

    public final void dFU() {
        this.moy = true;
    }

    public final void clear() {
    }

    /* renamed from: a */
    public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
        AppMethodBeat.m2504i(32588);
        C4990ab.m7411d("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskProgress] offset:%s totalLen:%s", Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.m2505o(32588);
    }

    /* renamed from: a */
    public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(32589);
        C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskEnd] mNeedDownloadCount:%s imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", Integer.valueOf(this.yZm), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.yZk.dFF()) {
            this.yZm--;
            C9638aw.m17190ZK();
            if (!C40775c.m70563b(this.mContext, C18628c.m29080XO().mo15340jf(j2), false)) {
                this.yZn = true;
            }
            if (dGW()) {
                if (this.yZn) {
                    this.mHandler.post(new C3052512());
                } else {
                    this.mHandler.post(new C3053411());
                    AppMethodBeat.m2505o(32589);
                    return;
                }
            }
            AppMethodBeat.m2505o(32589);
            return;
        }
        AppMethodBeat.m2505o(32589);
    }

    /* renamed from: a */
    public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
    }

    public final void dFC() {
        AppMethodBeat.m2504i(32590);
        C32291o.ahm().mo33465a((C9017a) this);
        C37961o.all().mo21052a(this);
        this.yZk.dFC();
        AppMethodBeat.m2505o(32590);
    }

    /* renamed from: a */
    public final void mo11381a(C9718a c9718a) {
        AppMethodBeat.m2504i(32591);
        if (this.yZk.dFF()) {
            C26493s ut = C26494u.m42268ut(c9718a.fileName);
            C4990ab.m7411d("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] mNeedDownloadCount:%s statusType:%s %s", Integer.valueOf(this.yZm), c9718a.fXu, c9718a.fileName);
            if (ut == null) {
                C4990ab.m7412e("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] videoInfo is null!");
                dFC();
                this.yZk.mo48891OI(0);
            } else if (ut.alz()) {
                this.yZm--;
                C9638aw.m17190ZK();
                C40775c.m70562a(this.mContext, C18628c.m29080XO().mo15340jf((long) ut.fXe), false);
            }
            if (dGW()) {
                if (this.yZn) {
                    this.mHandler.post(new C1569113());
                    AppMethodBeat.m2505o(32591);
                    return;
                }
                this.mHandler.post(new C3052614());
            }
            AppMethodBeat.m2505o(32591);
            return;
        }
        AppMethodBeat.m2505o(32591);
    }

    /* renamed from: fe */
    private void m48649fe(final List<C7620bi> list) {
        AppMethodBeat.m2504i(32592);
        C7305d.post(new Runnable() {

            /* renamed from: com.tencent.mm.ui.chatting.i.e$2$2 */
            class C237872 implements Runnable {
                C237872() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(32554);
                    C30529e.this.yZk.mo48891OI(C25738R.string.c45);
                    AppMethodBeat.m2505o(32554);
                }
            }

            /* renamed from: com.tencent.mm.ui.chatting.i.e$2$3 */
            class C305273 implements Runnable {
                C305273() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(32555);
                    C30529e.this.yZk.mo48891OI(C25738R.string.c46);
                    AppMethodBeat.m2505o(32555);
                }
            }

            /* renamed from: com.tencent.mm.ui.chatting.i.e$2$4 */
            class C305284 implements Runnable {
                C305284() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(32556);
                    if (C30529e.this.yZk != null) {
                        C30529e.this.yZk.dFE();
                    }
                    AppMethodBeat.m2505o(32556);
                }
            }

            /* renamed from: com.tencent.mm.ui.chatting.i.e$2$1 */
            class C305321 implements Runnable {
                C305321() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(32553);
                    C30529e.this.yZk.mo48891OI(C25738R.string.c45);
                    AppMethodBeat.m2505o(32553);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(32557);
                int fi = C30529e.m48653fi(list);
                if (list.size() == fi) {
                    C30529e.this.mHandler.post(new C305321());
                    AppMethodBeat.m2505o(32557);
                    return;
                }
                C30529e.this.yZn = fi > 0;
                LinkedList<C7620bi> b = C30529e.m48641b(C30529e.this, list);
                LinkedList<C7620bi> c = C30529e.m48644c(C30529e.this, list);
                C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[innerHandleSave] needDownloadImageList size:%s needDownloadVideoList:%s", Integer.valueOf(b.size()), Integer.valueOf(c.size()));
                C30529e.this.yZm = b.size() + c.size();
                if (C5023at.isWifi(C4996ah.getContext()) || C30529e.this.yZm != list.size()) {
                    for (C7620bi c7620bi : b) {
                        C30529e.m48636a(C30529e.this, c7620bi, C40780e.m70619d(c7620bi));
                    }
                    for (C7620bi c7620bi2 : c) {
                        C30529e.m48635a(C30529e.this, c7620bi2);
                    }
                    if (C30529e.this.yZn) {
                        C30529e.this.mHandler.post(new C305273());
                    }
                    if (C30529e.m48655g(C30529e.this) && !C30529e.this.yZn) {
                        C30529e.this.mHandler.post(new C305284());
                    }
                    AppMethodBeat.m2505o(32557);
                    return;
                }
                C30529e.this.mHandler.post(new C237872());
                AppMethodBeat.m2505o(32557);
            }
        }, "handleSave");
        AppMethodBeat.m2505o(32592);
    }

    private boolean dGW() {
        return this.yZm == 0;
    }

    /* renamed from: ff */
    private void m48650ff(final List<C7620bi> list) {
        AppMethodBeat.m2504i(32594);
        for (C7620bi aO : list) {
            if (!C23696ac.m36535aO(aO)) {
                C23639t.makeText(this.mContext, C25738R.string.boq, 0).show();
                AppMethodBeat.m2505o(32594);
                return;
            }
        }
        C7060h.pYm.mo8378a(219, 18, 1, true);
        final C45316cl c45316cl = new C45316cl();
        if (C40444g.m69402a(this.mContext, c45316cl, this.emo, list, false)) {
            m48645c(c45316cl);
            C30529e.m48652fh(list);
        } else if (list.size() > 1) {
            String string;
            Context context = this.mContext;
            String string2 = c45316cl.cvA.cvG >= 0 ? this.mContext.getString(C25738R.string.bov) : this.mContext.getString(C25738R.string.bou);
            String str = "";
            if (c45316cl.cvA.cvG >= 0) {
                string = this.mContext.getString(C25738R.string.atd);
            } else {
                string = this.mContext.getString(C25738R.string.dcq);
            }
            C30379h.m48466d(context, string2, str, string, this.mContext.getString(C25738R.string.atb), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(32561);
                    if (c45316cl.cvA.type == 14 && c45316cl.cvA.cvC.wiv.size() == 0) {
                        AppMethodBeat.m2505o(32561);
                        return;
                    }
                    C30529e.m48634a(C30529e.this, c45316cl);
                    C30529e.m48654fj(list);
                    AppMethodBeat.m2505o(32561);
                }
            }, null);
        } else {
            C30379h.m48467g(this.mContext, c45316cl.cvA.cvG, 0);
        }
        this.yZk.bwr();
        AppMethodBeat.m2505o(32594);
    }

    /* renamed from: fg */
    private void m48651fg(final List<C7620bi> list) {
        AppMethodBeat.m2504i(32595);
        C7060h.pYm.mo8381e(11627, Integer.valueOf(5));
        final TreeSet treeSet = new TreeSet();
        for (C7620bi c7620bi : list) {
            treeSet.add(Long.valueOf(c7620bi.field_msgId));
        }
        C30379h.m48466d(this.mContext, this.mContext.getString(C25738R.string.at7), "", this.mContext.getString(C25738R.string.b59), this.mContext.getString(C25738R.string.f9076or), new OnClickListener() {

            /* renamed from: com.tencent.mm.ui.chatting.i.e$5$1 */
            class C305371 implements C23698ah {
                C305371() {
                }

                public final void dCI() {
                }

                /* renamed from: a */
                public final void mo27932a(C23699a c23699a) {
                    AppMethodBeat.m2504i(32562);
                    if (c23699a == C23699a.del) {
                        C30529e.this.iPr.removeAll(list);
                    }
                    AppMethodBeat.m2505o(32562);
                }

                /* renamed from: b */
                public final void mo27933b(C23699a c23699a) {
                    AppMethodBeat.m2504i(32563);
                    C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[requestExitSelectedMode] %s del size:%s job:%s", Thread.currentThread(), Integer.valueOf(list.size()), c23699a);
                    if (c23699a == C23699a.del) {
                        C30529e.this.yZk.bwr();
                    }
                    AppMethodBeat.m2505o(32563);
                }

                public final boolean dCJ() {
                    return true;
                }
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(32564);
                C4990ab.m7416i("MicroMsg.MediaHistoryGalleryPresenter", "delete message");
                C44308i.m80089a(C30529e.this.mContext, treeSet, new C305371());
                AppMethodBeat.m2505o(32564);
            }
        }, null);
        AppMethodBeat.m2505o(32595);
    }

    /* renamed from: fh */
    private static void m48652fh(List<C7620bi> list) {
        AppMethodBeat.m2504i(32596);
        for (C7620bi a : list) {
            C40707a.m70380a(C40706c.Fav, C23688d.Samll, a, 0);
        }
        AppMethodBeat.m2505o(32596);
    }

    /* renamed from: c */
    private void m48645c(C45316cl c45316cl) {
        AppMethodBeat.m2504i(32597);
        c45316cl.cvA.cvH = 45;
        c45316cl.cvA.activity = (Activity) this.mContext;
        C4879a.xxA.mo10055m(c45316cl);
        if (c45316cl.cvB.ret == -2 || c45316cl.cvB.ret > 0) {
            AppMethodBeat.m2505o(32597);
            return;
        }
        if (c45316cl.cvB.ret <= 0) {
            if (14 != c45316cl.cvA.type) {
                C4990ab.m7410d("MicroMsg.MediaHistoryGalleryPresenter", "not record type, do not report");
                AppMethodBeat.m2505o(32597);
                return;
            } else if (c45316cl.cvA.cvD == null) {
                C4990ab.m7412e("MicroMsg.MediaHistoryGalleryPresenter", "want to report record fav, but type count is null");
                AppMethodBeat.m2505o(32597);
                return;
            } else {
                C7060h.pYm.mo8381e(11142, Integer.valueOf(c45316cl.cvA.cvD.wiK), Integer.valueOf(c45316cl.cvA.cvD.wiL), Integer.valueOf(c45316cl.cvA.cvD.wiM), Integer.valueOf(c45316cl.cvA.cvD.wiN), Integer.valueOf(c45316cl.cvA.cvD.wiO), Integer.valueOf(c45316cl.cvA.cvD.wiP), Integer.valueOf(c45316cl.cvA.cvD.wiQ), Integer.valueOf(c45316cl.cvA.cvD.fileCount), Integer.valueOf(c45316cl.cvA.cvD.wiR), Integer.valueOf(c45316cl.cvA.cvD.wiS), Integer.valueOf(c45316cl.cvA.cvD.wiT), Integer.valueOf(c45316cl.cvA.cvD.wiU), Integer.valueOf(c45316cl.cvA.cvD.wiV), Integer.valueOf(c45316cl.cvA.cvD.wiW), Integer.valueOf(c45316cl.cvA.cvD.wiX));
            }
        }
        AppMethodBeat.m2505o(32597);
    }

    /* renamed from: s */
    public final void mo48912s(final boolean z, final int i) {
        AppMethodBeat.m2504i(32598);
        if (z || this.moz + this.yZg != this.iPr.size()) {
            this.yZl.kuX = true;
            this.yZk.mo48897fO(z);
            C1720g.m3537RQ();
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    Cursor ab;
                    AppMethodBeat.m2504i(32566);
                    if (z) {
                        C30529e c30529e;
                        if (C30529e.this.yNB == -1) {
                            c30529e = C30529e.this;
                            C9638aw.m17190ZK();
                            c30529e.moz = C18628c.m29080XO().mo15263Rq(C30529e.this.emo);
                        } else {
                            c30529e = C30529e.this;
                            C9638aw.m17190ZK();
                            c30529e.moz = C18628c.m29081XP().mo74798aS(C30529e.this.emo, C30529e.this.yNB);
                        }
                    }
                    int k = (i < 0 || C30529e.this.moz - i <= 200) ? 200 : C30529e.this.moz - i;
                    C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", Integer.valueOf(i), Integer.valueOf(k));
                    LinkedList linkedList = new LinkedList();
                    if (C30529e.this.yNB == -1) {
                        C9638aw.m17190ZK();
                        ab = C18628c.m29080XO().mo15296ab(C30529e.this.emo, C30529e.this.iPr.size() - C30529e.this.yZg, k);
                    } else {
                        C9638aw.m17190ZK();
                        ab = C18628c.m29081XP().mo74799b(C30529e.this.emo, C30529e.this.yNB, C30529e.this.iPr.size() - C30529e.this.yZg, k);
                    }
                    if (ab == null) {
                        C4990ab.m7412e("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] NULL == cursor ");
                        AppMethodBeat.m2505o(32566);
                        return;
                    }
                    C7620bi c7620bi;
                    long b;
                    long j = 0;
                    while (ab.moveToNext()) {
                        try {
                            c7620bi = new C7620bi();
                            c7620bi.mo8995d(ab);
                            b = C15894a.dJg().mo28138b(new Date(c7620bi.field_createTime));
                            if (j != b) {
                                linkedList.add(new C15569c(c7620bi.field_createTime));
                                C30529e.this.yZg = C30529e.this.yZg + 1;
                            }
                            linkedList.add(new C15569c(c7620bi));
                            j = b;
                        } catch (Throwable th) {
                            ab.close();
                            AppMethodBeat.m2505o(32566);
                        }
                    }
                    ab.close();
                    LinkedList linkedList2 = new LinkedList();
                    if (linkedList.size() - C30529e.this.yZg == k) {
                        Cursor p;
                        long j2 = ((C15569c) linkedList.get(0)).timeStamp;
                        C15894a.dJg();
                        b = C15894a.m24213nv(j2);
                        C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] list size:%s start:%s end:%s", Integer.valueOf(linkedList.size()), Long.valueOf(b), Long.valueOf(j2));
                        if (C30529e.this.yNB == -1) {
                            C9638aw.m17190ZK();
                            p = C18628c.m29080XO().mo15347p(C30529e.this.emo, b, j2);
                        } else {
                            C9638aw.m17190ZK();
                            p = C18628c.m29081XP().mo74801c(C30529e.this.emo, C30529e.this.yNB, b, j2);
                        }
                        Date date = new Date(j2);
                        j2 = C15894a.dJg().mo28138b(date);
                        while (p != null) {
                            try {
                                if (!p.moveToNext()) {
                                    break;
                                }
                                c7620bi = new C7620bi();
                                c7620bi.mo8995d(p);
                                b = C15894a.dJg().mo28138b(new Date(c7620bi.field_createTime));
                                if (j2 == b || C15894a.dJg().mo28138b(date) == b) {
                                    if (linkedList.size() > 0 && linkedList2.size() == 0) {
                                        linkedList2.add(0, linkedList.remove(0));
                                    }
                                    b = j2;
                                } else {
                                    linkedList2.add(new C15569c(c7620bi.field_createTime));
                                    C30529e.this.yZg = C30529e.this.yZg + 1;
                                }
                                linkedList2.add(new C15569c(c7620bi));
                                j2 = b;
                            } catch (Throwable th2) {
                                if (p != null) {
                                    p.close();
                                }
                                AppMethodBeat.m2505o(32566);
                            }
                        }
                        if (p != null) {
                            p.close();
                        }
                    }
                    final int size = linkedList.size() + linkedList2.size();
                    C30529e.this.iPr.addAll(0, linkedList2);
                    C30529e.this.iPr.addAll(linkedList2.size(), linkedList);
                    linkedList.clear();
                    linkedList2.clear();
                    C30529e.this.yZg = 0;
                    C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", Integer.valueOf(C30529e.this.iPr.size()));
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(32565);
                            C30529e.this.yZl.kuX = false;
                            if (C30529e.this.yZk != null) {
                                C30529e.this.yZk.mo48899p(z, size);
                            }
                            AppMethodBeat.m2505o(32565);
                        }
                    });
                    AppMethodBeat.m2505o(32566);
                }
            });
            AppMethodBeat.m2505o(32598);
            return;
        }
        C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] that's all msg :%s offset:%s", Integer.valueOf(this.moz), Integer.valueOf(i));
        AppMethodBeat.m2505o(32598);
    }

    public final int dFB() {
        AppMethodBeat.m2504i(32583);
        int size = C15660a.yVE.mnX.size();
        AppMethodBeat.m2505o(32583);
        return size;
    }

    public final void bwq() {
        AppMethodBeat.m2504i(32584);
        this.yZl.mod = true;
        C15660a.yVE.mnY = true;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) bfC();
        int iQ = gridLayoutManager.mo1780iQ();
        this.yZl.mo66315c(iQ, (gridLayoutManager.mo1782iS() - iQ) + 1, Integer.valueOf(0));
        AppMethodBeat.m2505o(32584);
    }

    public final void bwr() {
        AppMethodBeat.m2504i(32585);
        this.yZl.mod = false;
        C15660a.yVE.clear();
        C15660a.yVE.mnY = false;
        this.yZl.aop.notifyChanged();
        AppMethodBeat.m2505o(32585);
    }

    public final boolean bwy() {
        AppMethodBeat.m2504i(32586);
        boolean z = C15660a.yVE.mnY;
        AppMethodBeat.m2505o(32586);
        return z;
    }

    /* renamed from: c */
    private static String m48643c(C7620bi c7620bi, C26493s c26493s) {
        String alv;
        AppMethodBeat.m2504i(32593);
        if (c26493s.fXk == -1) {
            alv = c26493s.alv();
            if (!C5730e.m8628ct(alv)) {
                C37961o.all();
                alv = C9720t.m17303uh(c7620bi.field_imgPath);
            }
        } else {
            C37961o.all();
            alv = C9720t.m17303uh(c7620bi.field_imgPath);
            if (c7620bi.field_isSend == 1 && c26493s.fXn != null && c26493s.fXn.wDP) {
                try {
                    String atb = C5730e.atb(alv);
                    if (!atb.endsWith("/")) {
                        atb = atb + "/";
                    }
                    atb = atb + C5730e.atd(alv) + "_hd.mp4";
                    C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "local capture video, hdFilePath: %s, exist: %s", atb, Boolean.valueOf(C5730e.m8628ct(atb)));
                    if (!C5730e.m8628ct(atb)) {
                        atb = alv;
                    }
                    alv = atb;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.MediaHistoryGalleryPresenter", "try to get hd filePath error: %s", e.getMessage());
                }
            }
        }
        AppMethodBeat.m2505o(32593);
        return alv;
    }

    public final /* bridge */ /* synthetic */ C41523a bwx() {
        return this.yZl;
    }

    /* JADX WARNING: Missing block: B:29:0x00ba, code skipped:
            if (com.tencent.p177mm.vfs.C5730e.m8628ct(com.tencent.p177mm.p612ui.chatting.gallery.C40775c.m70572e(r0)) == false) goto L_0x00bc;
     */
    /* JADX WARNING: Missing block: B:39:0x00fe, code skipped:
            if (com.tencent.p177mm.vfs.C5730e.m8628ct(r0) != false) goto L_0x00bf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: fi */
    static /* synthetic */ int m48653fi(List list) {
        AppMethodBeat.m2504i(32602);
        if (list == null) {
            AppMethodBeat.m2505o(32602);
            return 0;
        }
        int i = 0;
        for (C7620bi c7620bi : list) {
            String c;
            if (c7620bi.dtH() || C1831bh.m3770o(c7620bi)) {
                i++;
            } else if (C40775c.m70574f(c7620bi)) {
                int i2;
                C26493s bG = C15663j.m23963bG(c7620bi);
                if (bG != null) {
                    C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] getStatus:%s", Integer.valueOf(bG.status));
                    c = C30529e.m48643c(c7620bi, bG);
                } else {
                    c = null;
                }
                if (bG == null || bG.status == C27011o.CTRL_INDEX || !C5730e.m8628ct(c)) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            } else {
                C25822e d = C40780e.m70619d(c7620bi);
                if (d != null) {
                    C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] getStatus:%s", Integer.valueOf(d.status));
                }
                if (c7620bi.getType() == 268435505) {
                    C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] is appmsg! null?%s,exists:%s", Boolean.valueOf(C5046bo.isNullOrNil(c)), Boolean.valueOf(new C5728b(C5046bo.m7532bc(C40775c.m70572e(c7620bi), "")).exists()));
                } else {
                    if (d != null) {
                        c = C40780e.m70601a(c7620bi, d);
                    } else {
                        c = null;
                    }
                    C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] null?%s,exists:%s", Boolean.valueOf(C5046bo.isNullOrNil(c)), Boolean.valueOf(new C5728b(C5046bo.m7532bc(c, "")).exists()));
                    if (d != null) {
                        if (d.status != -1) {
                        }
                    }
                }
                i++;
                i = i;
            }
        }
        C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] count:%s size:%s", Integer.valueOf(i), Integer.valueOf(list.size()));
        AppMethodBeat.m2505o(32602);
        return i;
    }
}
