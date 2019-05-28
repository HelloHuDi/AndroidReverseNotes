package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.m;
import com.tencent.mm.plugin.choosemsgfile.ui.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import java.util.Date;
import java.util.LinkedList;

public final class f extends b {
    int Lp = 0;
    public c kvi;
    private c kvj = new c<gs>() {
        {
            AppMethodBeat.i(54354);
            this.xxI = gs.class.getName().hashCode();
            AppMethodBeat.o(54354);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(54355);
            gs gsVar = (gs) bVar;
            f.a(f.this, gsVar.cBr.cvx, gsVar);
            AppMethodBeat.o(54355);
            return false;
        }
    };
    private GridLayoutManager kvk;
    int kvl = 0;

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.f$4 */
    public class AnonymousClass4 extends h {
        final /* synthetic */ Context val$context;

        public AnonymousClass4(Context context) {
            this.val$context = context;
        }

        public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
            AppMethodBeat.i(54365);
            int dimension = (int) this.val$context.getResources().getDimension(R.dimen.m7);
            rect.bottom = dimension;
            rect.top = dimension;
            rect.left = dimension;
            rect.right = dimension;
            AppMethodBeat.o(54365);
        }
    }

    public f(a aVar) {
        super(aVar);
        AppMethodBeat.i(54368);
        AppMethodBeat.o(54368);
    }

    public final void dx(String str, String str2) {
        AppMethodBeat.i(54369);
        ab.i("MicroMsg.ChooseMsgFileUIController", "onCreate");
        this.kvj.dnU();
        b(true, str, str2);
        AppMethodBeat.o(54369);
    }

    public final void onResume() {
        AppMethodBeat.i(54370);
        ab.i("MicroMsg.ChooseMsgFileUIController", "onResume");
        this.kvi.aop.notifyChanged();
        AppMethodBeat.o(54370);
    }

    public final void onPause() {
        AppMethodBeat.i(54371);
        ab.i("MicroMsg.ChooseMsgFileUIController", "onPause");
        AppMethodBeat.o(54371);
    }

    public final void onDestroy() {
        AppMethodBeat.i(54372);
        ab.i("MicroMsg.ChooseMsgFileUIController", "onDestroy");
        this.kvj.dead();
        AppMethodBeat.o(54372);
    }

    public final RecyclerView.a bfB() {
        AppMethodBeat.i(54373);
        this.kvi = new c(this.kuT, this.iPr);
        this.kvi.kuV = new g.a() {
            public final void a(boolean z, final com.tencent.mm.plugin.choosemsgfile.b.b.a aVar, final v vVar) {
                AppMethodBeat.i(54363);
                if (aVar == null) {
                    ab.e("MicroMsg.ChooseMsgFileUIController", "[onCheck] item is null, err");
                    AppMethodBeat.o(54363);
                    return;
                }
                ab.i("MicroMsg.ChooseMsgFileUIController", "[onCheck] isChecked:%b", Boolean.valueOf(z));
                if (z) {
                    aVar.bfq();
                    f.a(f.this).gX(aVar.kua.field_msgId);
                    com.tencent.mm.plugin.choosemsgfile.b.a.b.a(aVar, new com.tencent.mm.plugin.choosemsgfile.b.a.a() {
                        public final void a(MsgFile msgFile) {
                            AppMethodBeat.i(54357);
                            ab.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadSuccess msgFile:%s", aVar, msgFile);
                            f.a(f.this).gY(aVar.kua.field_msgId);
                            f.a(f.this).a(aVar.kua.field_msgId, msgFile);
                            if (f.a(f.this).bfD()) {
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(54356);
                                        f.this.kvi.aop.notifyChanged();
                                        AppMethodBeat.o(54356);
                                    }
                                });
                            }
                            f.this.kuT.bfG();
                            aVar.bfr();
                            com.tencent.mm.plugin.choosemsgfile.b.b.a aVar = (com.tencent.mm.plugin.choosemsgfile.b.b.a) ((m) vVar).kuG.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.T(vVar);
                            }
                            AppMethodBeat.o(54357);
                        }

                        public final void bfe() {
                            AppMethodBeat.i(54358);
                            ab.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadFails", aVar);
                            f.a(f.this).gY(aVar.kua.field_msgId);
                            aVar.bft();
                            com.tencent.mm.plugin.choosemsgfile.b.b.a aVar = (com.tencent.mm.plugin.choosemsgfile.b.b.a) ((m) vVar).kuG.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.T(vVar);
                            }
                            AppMethodBeat.o(54358);
                        }

                        public final void bff() {
                            AppMethodBeat.i(54359);
                            ab.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadPause", aVar);
                            f.a(f.this).gY(aVar.kua.field_msgId);
                            aVar.bfu();
                            com.tencent.mm.plugin.choosemsgfile.b.b.a aVar = (com.tencent.mm.plugin.choosemsgfile.b.b.a) ((m) vVar).kuG.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.T(vVar);
                            }
                            AppMethodBeat.o(54359);
                        }

                        public final void bfg() {
                            AppMethodBeat.i(54360);
                            ab.e("MicroMsg.ChooseMsgFileUIController", "item:%s onExpireFail", aVar);
                            f.a(f.this).gY(aVar.kua.field_msgId);
                            aVar.bfs();
                            com.tencent.mm.plugin.choosemsgfile.b.b.a aVar = (com.tencent.mm.plugin.choosemsgfile.b.b.a) ((m) vVar).kuG.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.T(vVar);
                            }
                            AppMethodBeat.o(54360);
                        }

                        public final void dK(int i, int i2) {
                            AppMethodBeat.i(54361);
                            ab.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", aVar, Integer.valueOf(i), Integer.valueOf(i2));
                            aVar.dM(i, i2);
                            com.tencent.mm.plugin.choosemsgfile.b.b.a aVar = (com.tencent.mm.plugin.choosemsgfile.b.b.a) ((m) vVar).kuG.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.T(vVar);
                            }
                            AppMethodBeat.o(54361);
                        }
                    }, f.this.bfA());
                } else {
                    aVar.bfu();
                    f.a(f.this).gY(aVar.kua.field_msgId);
                    f.a(f.this).gV(aVar.kua.field_msgId);
                    if (f.a(f.this).bfD()) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(54362);
                                f.this.kvi.aop.notifyChanged();
                                AppMethodBeat.o(54362);
                            }
                        });
                    }
                    f.this.kuT.bfG();
                }
                aVar.T(vVar);
                AppMethodBeat.o(54363);
            }
        };
        c cVar = this.kvi;
        AppMethodBeat.o(54373);
        return cVar;
    }

    public final <T extends i> T bfC() {
        AppMethodBeat.i(54374);
        if (this.kvk == null) {
            this.kvk = new GridLayoutManager(4);
            this.kvk.akZ = new GridLayoutManager.b() {
                public final int bU(int i) {
                    AppMethodBeat.i(54364);
                    if (((com.tencent.mm.plugin.choosemsgfile.b.b.a) f.this.iPr.get(i)).getType() == 0) {
                        AppMethodBeat.o(54364);
                        return 4;
                    }
                    AppMethodBeat.o(54364);
                    return 1;
                }
            };
        }
        GridLayoutManager gridLayoutManager = this.kvk;
        AppMethodBeat.o(54374);
        return gridLayoutManager;
    }

    public final void b(final boolean z, final String str, final String str2) {
        AppMethodBeat.i(54375);
        if (z) {
            this.iPr.clear();
            this.Lp = 0;
        }
        this.kvi.kuX = true;
        this.kuT.fO(z);
        g.RQ();
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(54367);
                LinkedList linkedList = new LinkedList();
                Cursor cw = ((j) g.K(j.class)).bOr().cw(f.this.edV, f.this.Lp);
                if (cw == null) {
                    ab.e("MicroMsg.ChooseMsgFileUIController", "[loadData] NULL == cursor ");
                    AppMethodBeat.o(54367);
                    return;
                }
                long b;
                long j = 0;
                while (cw.moveToNext()) {
                    try {
                        f.this.Lp = f.this.Lp + 1;
                        bi biVar = new bi();
                        biVar.d(cw);
                        com.tencent.mm.plugin.choosemsgfile.b.b.a a = com.tencent.mm.plugin.choosemsgfile.b.d.b.a(f.this.kvi, biVar, f.this.edV, str, str2);
                        if (a != null) {
                            b = com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(biVar.field_createTime));
                            if (j != b) {
                                linkedList.add(new com.tencent.mm.plugin.choosemsgfile.b.b.c(f.this.kvi, biVar.field_createTime));
                                f.this.kvl = f.this.kvl + 1;
                            }
                            linkedList.add(a);
                        } else {
                            b = j;
                        }
                        j = b;
                    } catch (Throwable th) {
                        cw.close();
                        AppMethodBeat.o(54367);
                    }
                }
                cw.close();
                LinkedList linkedList2 = new LinkedList();
                if (linkedList.size() - f.this.kvl == 200) {
                    long timeStamp = ((com.tencent.mm.plugin.choosemsgfile.b.b.a) linkedList.get(0)).getTimeStamp();
                    com.tencent.mm.ui.gridviewheaders.a.dJg();
                    ab.i("MicroMsg.ChooseMsgFileUIController", "[loadData] list size:%s start:%s end:%s", Integer.valueOf(linkedList.size()), Long.valueOf(com.tencent.mm.ui.gridviewheaders.a.nv(timeStamp)), Long.valueOf(timeStamp));
                    Cursor q = ((j) g.K(j.class)).bOr().q(f.this.edV, j, timeStamp);
                    Date date = new Date(timeStamp);
                    b = com.tencent.mm.ui.gridviewheaders.a.dJg().b(date);
                    while (q != null) {
                        try {
                            if (!q.moveToNext()) {
                                break;
                            }
                            f.this.Lp = f.this.Lp + 1;
                            bi biVar2 = new bi();
                            biVar2.d(q);
                            com.tencent.mm.plugin.choosemsgfile.b.b.a a2 = com.tencent.mm.plugin.choosemsgfile.b.d.b.a(f.this.kvi, biVar2, f.this.edV, str, str2);
                            if (a2 != null) {
                                j = com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(biVar2.field_createTime));
                                if (b != j && com.tencent.mm.ui.gridviewheaders.a.dJg().b(date) != j) {
                                    linkedList2.add(new com.tencent.mm.plugin.choosemsgfile.b.b.c(f.this.kvi, biVar2.field_createTime));
                                    f.this.kvl = f.this.kvl + 1;
                                    b = j;
                                } else if (linkedList.size() > 0 && linkedList2.size() == 0) {
                                    linkedList2.add(0, linkedList.remove(0));
                                }
                                linkedList2.add(a2);
                            }
                        } catch (Throwable th2) {
                            if (q != null) {
                                q.close();
                            }
                            AppMethodBeat.o(54367);
                        }
                    }
                    if (q != null) {
                        q.close();
                    }
                }
                final int size = linkedList.size() + linkedList2.size();
                f.this.iPr.addAll(0, linkedList2);
                f.this.iPr.addAll(linkedList2.size(), linkedList);
                linkedList.clear();
                linkedList2.clear();
                f.this.kvl = 0;
                ab.i("MicroMsg.ChooseMsgFileUIController", "[loadData] %s", Integer.valueOf(f.this.iPr.size()));
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(54366);
                        f.this.kvi.kuX = false;
                        f.this.kuT.p(z, size);
                        AppMethodBeat.o(54366);
                    }
                });
                AppMethodBeat.o(54367);
            }
        });
        AppMethodBeat.o(54375);
    }

    static /* synthetic */ void a(f fVar, long j, gs gsVar) {
        AppMethodBeat.i(54376);
        int gU = fVar.kvi.gU(j);
        GridLayoutManager gridLayoutManager = (GridLayoutManager) fVar.bfC();
        int iQ = gridLayoutManager.iQ();
        ab.i("MicroMsg.ChooseMsgFileUIController", "[getPhotoInfo] msgId:%s pos:%s [%s:%s]", Long.valueOf(j), Integer.valueOf(gU), Integer.valueOf(iQ), Integer.valueOf(gridLayoutManager.iS()));
        if (gU >= iQ && gU <= r2) {
            View childAt = fVar.kuT.getChildAt(gU - iQ);
            if (childAt != null) {
                int[] iArr = new int[2];
                childAt.getLocationInWindow(iArr);
                gsVar.cBs.ctT = iArr[0];
                gsVar.cBs.ctU = iArr[1];
                gsVar.cBs.ctV = childAt.getWidth();
                gsVar.cBs.ctW = childAt.getHeight();
            }
        }
        AppMethodBeat.o(54376);
    }

    static /* synthetic */ com.tencent.mm.plugin.choosemsgfile.b.d.a a(f fVar) {
        AppMethodBeat.i(54377);
        com.tencent.mm.plugin.choosemsgfile.b.d.a bfn = fVar.kuT.bfn();
        AppMethodBeat.o(54377);
        return bfn;
    }
}
