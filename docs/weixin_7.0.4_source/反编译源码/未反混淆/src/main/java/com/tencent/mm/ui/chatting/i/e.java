package com.tencent.mm.ui.chatting.i;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.d.a;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.gallery.h.b;
import com.tencent.mm.ui.chatting.gallery.j;
import com.tencent.mm.ui.chatting.k;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public final class e implements a, t.a, com.tencent.mm.ui.chatting.e.a.a, b {
    static int count = 0;
    private String emo;
    private ArrayList<c> iPr = null;
    private com.tencent.mm.sdk.b.c kvj = new com.tencent.mm.sdk.b.c<gs>() {
        {
            AppMethodBeat.i(32568);
            this.xxI = gs.class.getName().hashCode();
            AppMethodBeat.o(32568);
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(32569);
            gs gsVar = (gs) bVar;
            e.a(e.this, gsVar.cBr.cvx, gsVar);
            AppMethodBeat.o(32569);
            return false;
        }
    };
    private GridLayoutManager kvk;
    private Context mContext;
    private ak mHandler = new ak(Looper.getMainLooper());
    boolean moy = false;
    private int moz = 0;
    private long yNB;
    private int yZg = 0;
    private com.tencent.mm.ui.chatting.e.a.b yZk;
    com.tencent.mm.ui.chatting.a.b yZl;
    private int yZm = 0;
    private boolean yZn = false;

    static /* synthetic */ void fj(List list) {
        AppMethodBeat.i(32609);
        fh(list);
        AppMethodBeat.o(32609);
    }

    static /* synthetic */ boolean g(e eVar) {
        AppMethodBeat.i(32607);
        boolean dGW = eVar.dGW();
        AppMethodBeat.o(32607);
        return dGW;
    }

    public e(Context context) {
        AppMethodBeat.i(32576);
        this.mContext = context;
        this.iPr = new ArrayList();
        AppMethodBeat.o(32576);
    }

    public final void onDetach() {
        AppMethodBeat.i(32577);
        this.kvj.dead();
        this.yZk.a(null);
        this.yZk = null;
        o.ahm().a((a) this);
        com.tencent.mm.modelvideo.o.all().a(this);
        h.a.yVE.detach();
        k.dCa();
        AppMethodBeat.o(32577);
    }

    public final <T extends i> T bfC() {
        AppMethodBeat.i(32578);
        if (this.kvk == null) {
            this.kvk = new GridLayoutManager(4);
            this.kvk.akZ = new GridLayoutManager.b() {
                public final int bU(int i) {
                    AppMethodBeat.i(32552);
                    if (((c) e.this.iPr.get(i)).type == BaseClientBuilder.API_PRIORITY_OTHER) {
                        AppMethodBeat.o(32552);
                        return 4;
                    }
                    AppMethodBeat.o(32552);
                    return 1;
                }
            };
        }
        GridLayoutManager gridLayoutManager = this.kvk;
        AppMethodBeat.o(32578);
        return gridLayoutManager;
    }

    public final RecyclerView.h dN(final Context context) {
        AppMethodBeat.i(32579);
        AnonymousClass8 anonymousClass8 = new RecyclerView.h() {
            public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
                AppMethodBeat.i(32567);
                int dimension = (int) context.getResources().getDimension(R.dimen.m7);
                rect.bottom = dimension;
                rect.top = dimension;
                rect.left = dimension;
                rect.right = dimension;
                AppMethodBeat.o(32567);
            }
        };
        AppMethodBeat.o(32579);
        return anonymousClass8;
    }

    public final RecyclerView.a aT(String str, long j) {
        AppMethodBeat.i(32580);
        this.emo = str;
        this.yNB = j;
        if (j == -1) {
            this.yZl = new com.tencent.mm.ui.chatting.a.b(this.mContext, this.iPr, str);
        } else {
            this.yZl = new com.tencent.mm.ui.chatting.a.b(this.mContext, this.iPr, str, j);
        }
        this.yZl.yNC = new com.tencent.mm.ui.chatting.a.b.b() {
            public final void a(boolean z, c cVar, int i) {
                AppMethodBeat.i(32570);
                ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", Boolean.valueOf(z), Integer.valueOf(i));
                if (!z || h.a.yVE.mnX.size() < 9) {
                    if (z) {
                        h.a.yVE.bC(cVar.cKd);
                    } else {
                        h.a.yVE.bD(cVar.cKd);
                    }
                    e.this.yZk.vF(h.a.yVE.mnX.size());
                    AppMethodBeat.o(32570);
                    return;
                }
                Toast.makeText(e.this.mContext, e.this.mContext.getResources().getString(R.string.c3z, new Object[]{Integer.valueOf(9)}), 1).show();
                e.this.yZl.cg(i);
                AppMethodBeat.o(32570);
            }
        };
        com.tencent.mm.ui.chatting.a.b bVar = this.yZl;
        AppMethodBeat.o(32580);
        return bVar;
    }

    public final String aoy() {
        AppMethodBeat.i(32581);
        String string = this.mContext.getString(R.string.fg);
        AppMethodBeat.o(32581);
        return string;
    }

    public final void vH(int i) {
        AppMethodBeat.i(32582);
        ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", Integer.valueOf(i));
        ArrayList<bi> arrayList = h.a.yVE.mnX;
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.h.pYm.a(219, 19, 1, true);
                k.a(this.mContext, arrayList, com.tencent.mm.model.t.kH(this.emo), this.emo, new ah() {
                    public final void dCI() {
                    }

                    public final void a(ah.a aVar) {
                    }

                    public final void b(ah.a aVar) {
                    }

                    public final boolean dCJ() {
                        return true;
                    }
                });
                this.yZk.bwr();
                AppMethodBeat.o(32582);
                return;
            case 1:
                ff(arrayList);
                AppMethodBeat.o(32582);
                return;
            case 2:
                fg(arrayList);
                break;
            case 3:
                this.yZk.dFD();
                final ArrayList arrayList2 = new ArrayList();
                for (bi biVar : arrayList) {
                    if (!(com.tencent.mm.ui.chatting.gallery.c.bp(biVar) || com.tencent.mm.ui.chatting.gallery.c.bq(biVar))) {
                        arrayList2.add(biVar);
                    }
                }
                if (arrayList2.size() != arrayList.size()) {
                    com.tencent.mm.ui.base.h.a(this.mContext, (int) R.string.c3v, (int) R.string.tz, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(32575);
                            e.a(e.this, arrayList2);
                            AppMethodBeat.o(32575);
                        }
                    }, null);
                    AppMethodBeat.o(32582);
                    return;
                }
                fe(arrayList2);
                AppMethodBeat.o(32582);
                return;
        }
        AppMethodBeat.o(32582);
    }

    public final void onResume() {
        AppMethodBeat.i(32587);
        if (this.moy && h.a.yVE.mnY) {
            this.yZk.vF(h.a.yVE.mnX.size());
            this.yZl.aop.notifyChanged();
        }
        AppMethodBeat.o(32587);
    }

    public final void dFU() {
        this.moy = true;
    }

    public final void clear() {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, m mVar) {
        AppMethodBeat.i(32588);
        ab.d("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskProgress] offset:%s totalLen:%s", Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(32588);
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, m mVar) {
        AppMethodBeat.i(32589);
        ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskEnd] mNeedDownloadCount:%s imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", Integer.valueOf(this.yZm), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.yZk.dFF()) {
            this.yZm--;
            aw.ZK();
            if (!com.tencent.mm.ui.chatting.gallery.c.b(this.mContext, com.tencent.mm.model.c.XO().jf(j2), false)) {
                this.yZn = true;
            }
            if (dGW()) {
                if (this.yZn) {
                    this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(32572);
                            if (e.this.yZk != null) {
                                e.this.yZk.OI(R.string.c46);
                            }
                            AppMethodBeat.o(32572);
                        }
                    });
                } else {
                    this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(32571);
                            if (e.this.yZk != null) {
                                e.this.yZk.dFE();
                            }
                            AppMethodBeat.o(32571);
                        }
                    });
                    AppMethodBeat.o(32589);
                    return;
                }
            }
            AppMethodBeat.o(32589);
            return;
        }
        AppMethodBeat.o(32589);
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }

    public final void dFC() {
        AppMethodBeat.i(32590);
        o.ahm().a((a) this);
        com.tencent.mm.modelvideo.o.all().a(this);
        this.yZk.dFC();
        AppMethodBeat.o(32590);
    }

    public final void a(t.a.a aVar) {
        AppMethodBeat.i(32591);
        if (this.yZk.dFF()) {
            com.tencent.mm.modelvideo.s ut = u.ut(aVar.fileName);
            ab.d("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] mNeedDownloadCount:%s statusType:%s %s", Integer.valueOf(this.yZm), aVar.fXu, aVar.fileName);
            if (ut == null) {
                ab.e("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] videoInfo is null!");
                dFC();
                this.yZk.OI(0);
            } else if (ut.alz()) {
                this.yZm--;
                aw.ZK();
                com.tencent.mm.ui.chatting.gallery.c.a(this.mContext, com.tencent.mm.model.c.XO().jf((long) ut.fXe), false);
            }
            if (dGW()) {
                if (this.yZn) {
                    this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(32573);
                            if (e.this.yZk != null) {
                                e.this.yZk.OI(R.string.c46);
                            }
                            AppMethodBeat.o(32573);
                        }
                    });
                    AppMethodBeat.o(32591);
                    return;
                }
                this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(32574);
                        if (e.this.yZk != null) {
                            e.this.yZk.dFE();
                        }
                        AppMethodBeat.o(32574);
                    }
                });
            }
            AppMethodBeat.o(32591);
            return;
        }
        AppMethodBeat.o(32591);
    }

    private void fe(final List<bi> list) {
        AppMethodBeat.i(32592);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(32557);
                int fi = e.fi(list);
                if (list.size() == fi) {
                    e.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(32553);
                            e.this.yZk.OI(R.string.c45);
                            AppMethodBeat.o(32553);
                        }
                    });
                    AppMethodBeat.o(32557);
                    return;
                }
                e.this.yZn = fi > 0;
                LinkedList<bi> b = e.b(e.this, list);
                LinkedList<bi> c = e.c(e.this, list);
                ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[innerHandleSave] needDownloadImageList size:%s needDownloadVideoList:%s", Integer.valueOf(b.size()), Integer.valueOf(c.size()));
                e.this.yZm = b.size() + c.size();
                if (at.isWifi(com.tencent.mm.sdk.platformtools.ah.getContext()) || e.this.yZm != list.size()) {
                    for (bi biVar : b) {
                        e.a(e.this, biVar, com.tencent.mm.ui.chatting.gallery.e.d(biVar));
                    }
                    for (bi biVar2 : c) {
                        e.a(e.this, biVar2);
                    }
                    if (e.this.yZn) {
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(32555);
                                e.this.yZk.OI(R.string.c46);
                                AppMethodBeat.o(32555);
                            }
                        });
                    }
                    if (e.g(e.this) && !e.this.yZn) {
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(32556);
                                if (e.this.yZk != null) {
                                    e.this.yZk.dFE();
                                }
                                AppMethodBeat.o(32556);
                            }
                        });
                    }
                    AppMethodBeat.o(32557);
                    return;
                }
                e.this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(32554);
                        e.this.yZk.OI(R.string.c45);
                        AppMethodBeat.o(32554);
                    }
                });
                AppMethodBeat.o(32557);
            }
        }, "handleSave");
        AppMethodBeat.o(32592);
    }

    private boolean dGW() {
        return this.yZm == 0;
    }

    private void ff(final List<bi> list) {
        AppMethodBeat.i(32594);
        for (bi aO : list) {
            if (!ac.aO(aO)) {
                com.tencent.mm.ui.base.t.makeText(this.mContext, R.string.boq, 0).show();
                AppMethodBeat.o(32594);
                return;
            }
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(219, 18, 1, true);
        final cl clVar = new cl();
        if (g.a(this.mContext, clVar, this.emo, list, false)) {
            c(clVar);
            fh(list);
        } else if (list.size() > 1) {
            String string;
            Context context = this.mContext;
            String string2 = clVar.cvA.cvG >= 0 ? this.mContext.getString(R.string.bov) : this.mContext.getString(R.string.bou);
            String str = "";
            if (clVar.cvA.cvG >= 0) {
                string = this.mContext.getString(R.string.atd);
            } else {
                string = this.mContext.getString(R.string.dcq);
            }
            com.tencent.mm.ui.base.h.d(context, string2, str, string, this.mContext.getString(R.string.atb), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(32561);
                    if (clVar.cvA.type == 14 && clVar.cvA.cvC.wiv.size() == 0) {
                        AppMethodBeat.o(32561);
                        return;
                    }
                    e.a(e.this, clVar);
                    e.fj(list);
                    AppMethodBeat.o(32561);
                }
            }, null);
        } else {
            com.tencent.mm.ui.base.h.g(this.mContext, clVar.cvA.cvG, 0);
        }
        this.yZk.bwr();
        AppMethodBeat.o(32594);
    }

    private void fg(final List<bi> list) {
        AppMethodBeat.i(32595);
        com.tencent.mm.plugin.report.service.h.pYm.e(11627, Integer.valueOf(5));
        final TreeSet treeSet = new TreeSet();
        for (bi biVar : list) {
            treeSet.add(Long.valueOf(biVar.field_msgId));
        }
        com.tencent.mm.ui.base.h.d(this.mContext, this.mContext.getString(R.string.at7), "", this.mContext.getString(R.string.b59), this.mContext.getString(R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(32564);
                ab.i("MicroMsg.MediaHistoryGalleryPresenter", "delete message");
                com.tencent.mm.ui.chatting.i.a(e.this.mContext, treeSet, new ah() {
                    public final void dCI() {
                    }

                    public final void a(ah.a aVar) {
                        AppMethodBeat.i(32562);
                        if (aVar == ah.a.del) {
                            e.this.iPr.removeAll(list);
                        }
                        AppMethodBeat.o(32562);
                    }

                    public final void b(ah.a aVar) {
                        AppMethodBeat.i(32563);
                        ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[requestExitSelectedMode] %s del size:%s job:%s", Thread.currentThread(), Integer.valueOf(list.size()), aVar);
                        if (aVar == ah.a.del) {
                            e.this.yZk.bwr();
                        }
                        AppMethodBeat.o(32563);
                    }

                    public final boolean dCJ() {
                        return true;
                    }
                });
                AppMethodBeat.o(32564);
            }
        }, null);
        AppMethodBeat.o(32595);
    }

    private static void fh(List<bi> list) {
        AppMethodBeat.i(32596);
        for (bi a : list) {
            com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.Fav, com.tencent.mm.ui.chatting.a.d.Samll, a, 0);
        }
        AppMethodBeat.o(32596);
    }

    private void c(cl clVar) {
        AppMethodBeat.i(32597);
        clVar.cvA.cvH = 45;
        clVar.cvA.activity = (Activity) this.mContext;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        if (clVar.cvB.ret == -2 || clVar.cvB.ret > 0) {
            AppMethodBeat.o(32597);
            return;
        }
        if (clVar.cvB.ret <= 0) {
            if (14 != clVar.cvA.type) {
                ab.d("MicroMsg.MediaHistoryGalleryPresenter", "not record type, do not report");
                AppMethodBeat.o(32597);
                return;
            } else if (clVar.cvA.cvD == null) {
                ab.e("MicroMsg.MediaHistoryGalleryPresenter", "want to report record fav, but type count is null");
                AppMethodBeat.o(32597);
                return;
            } else {
                com.tencent.mm.plugin.report.service.h.pYm.e(11142, Integer.valueOf(clVar.cvA.cvD.wiK), Integer.valueOf(clVar.cvA.cvD.wiL), Integer.valueOf(clVar.cvA.cvD.wiM), Integer.valueOf(clVar.cvA.cvD.wiN), Integer.valueOf(clVar.cvA.cvD.wiO), Integer.valueOf(clVar.cvA.cvD.wiP), Integer.valueOf(clVar.cvA.cvD.wiQ), Integer.valueOf(clVar.cvA.cvD.fileCount), Integer.valueOf(clVar.cvA.cvD.wiR), Integer.valueOf(clVar.cvA.cvD.wiS), Integer.valueOf(clVar.cvA.cvD.wiT), Integer.valueOf(clVar.cvA.cvD.wiU), Integer.valueOf(clVar.cvA.cvD.wiV), Integer.valueOf(clVar.cvA.cvD.wiW), Integer.valueOf(clVar.cvA.cvD.wiX));
            }
        }
        AppMethodBeat.o(32597);
    }

    public final void s(final boolean z, final int i) {
        AppMethodBeat.i(32598);
        if (z || this.moz + this.yZg != this.iPr.size()) {
            this.yZl.kuX = true;
            this.yZk.fO(z);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                public final void run() {
                    Cursor ab;
                    AppMethodBeat.i(32566);
                    if (z) {
                        e eVar;
                        if (e.this.yNB == -1) {
                            eVar = e.this;
                            aw.ZK();
                            eVar.moz = com.tencent.mm.model.c.XO().Rq(e.this.emo);
                        } else {
                            eVar = e.this;
                            aw.ZK();
                            eVar.moz = com.tencent.mm.model.c.XP().aS(e.this.emo, e.this.yNB);
                        }
                    }
                    int k = (i < 0 || e.this.moz - i <= 200) ? 200 : e.this.moz - i;
                    ab.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", Integer.valueOf(i), Integer.valueOf(k));
                    LinkedList linkedList = new LinkedList();
                    if (e.this.yNB == -1) {
                        aw.ZK();
                        ab = com.tencent.mm.model.c.XO().ab(e.this.emo, e.this.iPr.size() - e.this.yZg, k);
                    } else {
                        aw.ZK();
                        ab = com.tencent.mm.model.c.XP().b(e.this.emo, e.this.yNB, e.this.iPr.size() - e.this.yZg, k);
                    }
                    if (ab == null) {
                        ab.e("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] NULL == cursor ");
                        AppMethodBeat.o(32566);
                        return;
                    }
                    bi biVar;
                    long b;
                    long j = 0;
                    while (ab.moveToNext()) {
                        try {
                            biVar = new bi();
                            biVar.d(ab);
                            b = com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(biVar.field_createTime));
                            if (j != b) {
                                linkedList.add(new c(biVar.field_createTime));
                                e.this.yZg = e.this.yZg + 1;
                            }
                            linkedList.add(new c(biVar));
                            j = b;
                        } catch (Throwable th) {
                            ab.close();
                            AppMethodBeat.o(32566);
                        }
                    }
                    ab.close();
                    LinkedList linkedList2 = new LinkedList();
                    if (linkedList.size() - e.this.yZg == k) {
                        Cursor p;
                        long j2 = ((c) linkedList.get(0)).timeStamp;
                        com.tencent.mm.ui.gridviewheaders.a.dJg();
                        b = com.tencent.mm.ui.gridviewheaders.a.nv(j2);
                        ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] list size:%s start:%s end:%s", Integer.valueOf(linkedList.size()), Long.valueOf(b), Long.valueOf(j2));
                        if (e.this.yNB == -1) {
                            aw.ZK();
                            p = com.tencent.mm.model.c.XO().p(e.this.emo, b, j2);
                        } else {
                            aw.ZK();
                            p = com.tencent.mm.model.c.XP().c(e.this.emo, e.this.yNB, b, j2);
                        }
                        Date date = new Date(j2);
                        j2 = com.tencent.mm.ui.gridviewheaders.a.dJg().b(date);
                        while (p != null) {
                            try {
                                if (!p.moveToNext()) {
                                    break;
                                }
                                biVar = new bi();
                                biVar.d(p);
                                b = com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(biVar.field_createTime));
                                if (j2 == b || com.tencent.mm.ui.gridviewheaders.a.dJg().b(date) == b) {
                                    if (linkedList.size() > 0 && linkedList2.size() == 0) {
                                        linkedList2.add(0, linkedList.remove(0));
                                    }
                                    b = j2;
                                } else {
                                    linkedList2.add(new c(biVar.field_createTime));
                                    e.this.yZg = e.this.yZg + 1;
                                }
                                linkedList2.add(new c(biVar));
                                j2 = b;
                            } catch (Throwable th2) {
                                if (p != null) {
                                    p.close();
                                }
                                AppMethodBeat.o(32566);
                            }
                        }
                        if (p != null) {
                            p.close();
                        }
                    }
                    final int size = linkedList.size() + linkedList2.size();
                    e.this.iPr.addAll(0, linkedList2);
                    e.this.iPr.addAll(linkedList2.size(), linkedList);
                    linkedList.clear();
                    linkedList2.clear();
                    e.this.yZg = 0;
                    ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", Integer.valueOf(e.this.iPr.size()));
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(32565);
                            e.this.yZl.kuX = false;
                            if (e.this.yZk != null) {
                                e.this.yZk.p(z, size);
                            }
                            AppMethodBeat.o(32565);
                        }
                    });
                    AppMethodBeat.o(32566);
                }
            });
            AppMethodBeat.o(32598);
            return;
        }
        ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] that's all msg :%s offset:%s", Integer.valueOf(this.moz), Integer.valueOf(i));
        AppMethodBeat.o(32598);
    }

    public final int dFB() {
        AppMethodBeat.i(32583);
        int size = h.a.yVE.mnX.size();
        AppMethodBeat.o(32583);
        return size;
    }

    public final void bwq() {
        AppMethodBeat.i(32584);
        this.yZl.mod = true;
        h.a.yVE.mnY = true;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) bfC();
        int iQ = gridLayoutManager.iQ();
        this.yZl.c(iQ, (gridLayoutManager.iS() - iQ) + 1, Integer.valueOf(0));
        AppMethodBeat.o(32584);
    }

    public final void bwr() {
        AppMethodBeat.i(32585);
        this.yZl.mod = false;
        h.a.yVE.clear();
        h.a.yVE.mnY = false;
        this.yZl.aop.notifyChanged();
        AppMethodBeat.o(32585);
    }

    public final boolean bwy() {
        AppMethodBeat.i(32586);
        boolean z = h.a.yVE.mnY;
        AppMethodBeat.o(32586);
        return z;
    }

    private static String c(bi biVar, com.tencent.mm.modelvideo.s sVar) {
        String alv;
        AppMethodBeat.i(32593);
        if (sVar.fXk == -1) {
            alv = sVar.alv();
            if (!com.tencent.mm.vfs.e.ct(alv)) {
                com.tencent.mm.modelvideo.o.all();
                alv = t.uh(biVar.field_imgPath);
            }
        } else {
            com.tencent.mm.modelvideo.o.all();
            alv = t.uh(biVar.field_imgPath);
            if (biVar.field_isSend == 1 && sVar.fXn != null && sVar.fXn.wDP) {
                try {
                    String atb = com.tencent.mm.vfs.e.atb(alv);
                    if (!atb.endsWith("/")) {
                        atb = atb + "/";
                    }
                    atb = atb + com.tencent.mm.vfs.e.atd(alv) + "_hd.mp4";
                    ab.i("MicroMsg.MediaHistoryGalleryPresenter", "local capture video, hdFilePath: %s, exist: %s", atb, Boolean.valueOf(com.tencent.mm.vfs.e.ct(atb)));
                    if (!com.tencent.mm.vfs.e.ct(atb)) {
                        atb = alv;
                    }
                    alv = atb;
                } catch (Exception e) {
                    ab.e("MicroMsg.MediaHistoryGalleryPresenter", "try to get hd filePath error: %s", e.getMessage());
                }
            }
        }
        AppMethodBeat.o(32593);
        return alv;
    }

    public final /* bridge */ /* synthetic */ RecyclerView.a bwx() {
        return this.yZl;
    }

    /* JADX WARNING: Missing block: B:29:0x00ba, code skipped:
            if (com.tencent.mm.vfs.e.ct(com.tencent.mm.ui.chatting.gallery.c.e(r0)) == false) goto L_0x00bc;
     */
    /* JADX WARNING: Missing block: B:39:0x00fe, code skipped:
            if (com.tencent.mm.vfs.e.ct(r0) != false) goto L_0x00bf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int fi(List list) {
        AppMethodBeat.i(32602);
        if (list == null) {
            AppMethodBeat.o(32602);
            return 0;
        }
        int i = 0;
        for (bi biVar : list) {
            String c;
            if (biVar.dtH() || bh.o(biVar)) {
                i++;
            } else if (com.tencent.mm.ui.chatting.gallery.c.f(biVar)) {
                int i2;
                com.tencent.mm.modelvideo.s bG = j.bG(biVar);
                if (bG != null) {
                    ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] getStatus:%s", Integer.valueOf(bG.status));
                    c = c(biVar, bG);
                } else {
                    c = null;
                }
                if (bG == null || bG.status == com.tencent.mm.plugin.appbrand.jsapi.k.o.CTRL_INDEX || !com.tencent.mm.vfs.e.ct(c)) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            } else {
                com.tencent.mm.at.e d = com.tencent.mm.ui.chatting.gallery.e.d(biVar);
                if (d != null) {
                    ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] getStatus:%s", Integer.valueOf(d.status));
                }
                if (biVar.getType() == 268435505) {
                    ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] is appmsg! null?%s,exists:%s", Boolean.valueOf(bo.isNullOrNil(c)), Boolean.valueOf(new com.tencent.mm.vfs.b(bo.bc(com.tencent.mm.ui.chatting.gallery.c.e(biVar), "")).exists()));
                } else {
                    if (d != null) {
                        c = com.tencent.mm.ui.chatting.gallery.e.a(biVar, d);
                    } else {
                        c = null;
                    }
                    ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] null?%s,exists:%s", Boolean.valueOf(bo.isNullOrNil(c)), Boolean.valueOf(new com.tencent.mm.vfs.b(bo.bc(c, "")).exists()));
                    if (d != null) {
                        if (d.status != -1) {
                        }
                    }
                }
                i++;
                i = i;
            }
        }
        ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] count:%s size:%s", Integer.valueOf(i), Integer.valueOf(list.size()));
        AppMethodBeat.o(32602);
        return i;
    }
}
