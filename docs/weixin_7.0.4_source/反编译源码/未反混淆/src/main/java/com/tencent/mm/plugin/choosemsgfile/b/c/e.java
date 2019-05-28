package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.database.Cursor;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.b.b.i;
import com.tencent.mm.plugin.choosemsgfile.b.b.k;
import com.tencent.mm.plugin.choosemsgfile.b.b.n;
import com.tencent.mm.plugin.choosemsgfile.b.c.g.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public final class e extends b {
    protected List<a> iJL = new ArrayList();
    public LinearLayoutManager jop;
    d kuY;

    public e(com.tencent.mm.plugin.choosemsgfile.ui.a aVar) {
        super(aVar);
        AppMethodBeat.i(54350);
        AppMethodBeat.o(54350);
    }

    public final RecyclerView.a bfB() {
        AppMethodBeat.i(54351);
        this.kuY = new d(this.kuT, this.iJL);
        a.kuW = new b() {
        };
        this.kuY.kuV = new g.a() {
            public final void a(boolean z, final a aVar, final v vVar) {
                AppMethodBeat.i(54345);
                if (aVar == null) {
                    ab.e("MicroMsg.ChooseMsgFileListUIController", "[onCheck] item is null, err");
                    AppMethodBeat.o(54345);
                    return;
                }
                ab.i("MicroMsg.ChooseMsgFileListUIController", "[onCheck] isChecked :%b", Boolean.valueOf(z));
                if (z) {
                    aVar.bfq();
                    e.a(e.this).gX(aVar.kua.field_msgId);
                    com.tencent.mm.plugin.choosemsgfile.b.a.b.a(aVar, new com.tencent.mm.plugin.choosemsgfile.b.a.a() {
                        public final void a(MsgFile msgFile) {
                            AppMethodBeat.i(54339);
                            ab.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadSuccess msgFile:%s", aVar, msgFile);
                            e.a(e.this).gY(aVar.kua.field_msgId);
                            e.a(e.this).a(aVar.kua.field_msgId, msgFile);
                            if (e.a(e.this).bfD()) {
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(54338);
                                        e.this.kuY.aop.notifyChanged();
                                        AppMethodBeat.o(54338);
                                    }
                                });
                            }
                            e.this.kuT.bfG();
                            aVar.bfr();
                            a aVar = (a) ((n) vVar).kuD.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.T(vVar);
                            }
                            AppMethodBeat.o(54339);
                        }

                        public final void bfe() {
                            AppMethodBeat.i(54340);
                            ab.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadFails", aVar);
                            e.a(e.this).gY(aVar.kua.field_msgId);
                            aVar.bft();
                            a aVar = (a) ((n) vVar).kuD.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.T(vVar);
                            }
                            AppMethodBeat.o(54340);
                        }

                        public final void bff() {
                            AppMethodBeat.i(54341);
                            ab.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadPause", aVar);
                            e.a(e.this).gY(aVar.kua.field_msgId);
                            aVar.bfu();
                            a aVar = (a) ((n) vVar).kuD.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.T(vVar);
                            }
                            AppMethodBeat.o(54341);
                        }

                        public final void bfg() {
                            AppMethodBeat.i(54342);
                            ab.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onExpireFail", aVar);
                            e.a(e.this).gY(aVar.kua.field_msgId);
                            aVar.bfs();
                            a aVar = (a) ((n) vVar).kuD.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.T(vVar);
                            }
                            AppMethodBeat.o(54342);
                        }

                        public final void dK(int i, int i2) {
                            AppMethodBeat.i(54343);
                            ab.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", aVar, Integer.valueOf(i), Integer.valueOf(i2));
                            aVar.dM(i, i2);
                            a aVar = (a) ((n) vVar).kuD.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.T(vVar);
                            }
                            AppMethodBeat.o(54343);
                        }
                    }, e.this.bfA());
                } else {
                    aVar.bfu();
                    e.a(e.this).gY(aVar.kua.field_msgId);
                    e.a(e.this).gV(aVar.kua.field_msgId);
                    if (e.a(e.this).bfD()) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(54344);
                                e.this.kuY.aop.notifyChanged();
                                AppMethodBeat.o(54344);
                            }
                        });
                    }
                    e.this.kuT.bfG();
                }
                aVar.T(vVar);
                AppMethodBeat.o(54345);
            }
        };
        d dVar = this.kuY;
        AppMethodBeat.o(54351);
        return dVar;
    }

    public final void b(final boolean z, String str, final String str2) {
        AppMethodBeat.i(54352);
        ab.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] isFirst:%s", Boolean.valueOf(z));
        this.kuT.fO(z);
        if (z) {
            this.iJL.clear();
        }
        g.RQ();
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(54347);
                LinkedList linkedList = new LinkedList();
                Cursor cu = ((j) g.K(j.class)).bOr().cu(e.this.edV, -1);
                if (cu == null) {
                    ab.e("MicroMsg.ChooseMsgFileListUIController", "[loadData] cursor is null!");
                    AppMethodBeat.o(54347);
                    return;
                }
                List<String> HJ = com.tencent.mm.plugin.choosemsgfile.b.d.b.HJ(str2);
                long j = 0;
                while (cu.moveToNext()) {
                    try {
                        long b;
                        bi biVar = new bi();
                        biVar.d(cu);
                        String str = biVar.field_content;
                        if (str != null) {
                            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
                            if (me != null && me.type == 6) {
                                int i;
                                k kVar = new k(e.this.kuY, biVar, e.this.edV);
                                if (HJ.size() == 0) {
                                    i = 1;
                                } else {
                                    for (String str2 : HJ) {
                                        if (kVar.getFileName().endsWith(str2)) {
                                            i = 1;
                                            break;
                                        }
                                    }
                                    i = 0;
                                }
                                if (i != 0) {
                                    b = com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(biVar.field_createTime));
                                    if (j != b) {
                                        linkedList.add(new i(e.this.kuY, biVar.field_createTime));
                                    }
                                    linkedList.add(kVar);
                                    j = b;
                                }
                            }
                        }
                        b = j;
                        j = b;
                    } catch (Throwable th) {
                        cu.close();
                        AppMethodBeat.o(54347);
                    }
                }
                cu.close();
                e.this.iJL.addAll(linkedList);
                linkedList.clear();
                ab.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] data:%s", Integer.valueOf(e.this.iJL.size()));
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(54346);
                        if (e.this.kuT != null) {
                            e.this.kuT.p(z, e.this.iJL.size());
                        }
                        AppMethodBeat.o(54346);
                    }
                });
                AppMethodBeat.o(54347);
            }
        });
        AppMethodBeat.o(54352);
    }

    static /* synthetic */ com.tencent.mm.plugin.choosemsgfile.b.d.a a(e eVar) {
        AppMethodBeat.i(54353);
        com.tencent.mm.plugin.choosemsgfile.b.d.a bfn = eVar.kuT.bfn();
        AppMethodBeat.o(54353);
        return bfn;
    }
}
