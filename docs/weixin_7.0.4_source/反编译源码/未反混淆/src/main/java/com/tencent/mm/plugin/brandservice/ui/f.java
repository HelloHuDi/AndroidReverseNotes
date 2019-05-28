package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.base.a;
import com.tencent.mm.plugin.brandservice.ui.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

public final class f extends c {
    List<bqh> jMx = null;
    private SparseArray<a> jMy = new SparseArray();
    private int jMz;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(14039);
        com.tencent.mm.ui.base.sortview.a se = se(i);
        AppMethodBeat.o(14039);
        return se;
    }

    public f(Context context) {
        super(context);
        AppMethodBeat.i(14032);
        setReporter(new b() {
            public final void a(c cVar, com.tencent.mm.ui.base.sortview.a aVar, int i, String str, int i2, int i3) {
                AppMethodBeat.i(14031);
                mh sa = f.this.sa(i3);
                String str2 = bo.nullAsNil(f.this.jKW) + "," + i + "," + bo.nullAsNil(str) + "," + i2 + "," + cVar.jLe + "," + (sa == null ? "" : sa.vQg + ",0");
                h.pYm.X(10866, str2);
                ab.d("MicroMsg.SearchOrRecommendBizAdapter", "report : ".concat(String.valueOf(str2)));
                AppMethodBeat.o(14031);
            }
        });
        AppMethodBeat.o(14032);
    }

    public final void h(String str, List<mh> list) {
        AppMethodBeat.i(14033);
        super.h(str, list);
        this.jMz = super.getCount();
        AppMethodBeat.o(14033);
    }

    public final void a(mh mhVar, boolean z) {
        AppMethodBeat.i(14034);
        super.a(mhVar, z);
        if (this.jMz == 0) {
            this.jMz = super.getCount();
        }
        AppMethodBeat.o(14034);
    }

    public final int getCount() {
        AppMethodBeat.i(14035);
        int count = super.getCount();
        if (count == 0 && this.jMx != null) {
            int i;
            Iterator it = this.jMx.iterator();
            while (true) {
                i = count;
                if (!it.hasNext()) {
                    break;
                }
                bqh bqh = (bqh) it.next();
                if (!(bqh == null || bqh.wSC == null)) {
                    i += bqh.wSC.size();
                }
                count = i;
            }
            count = i;
        }
        AppMethodBeat.o(14035);
        return count;
    }

    public final void aWb() {
        AppMethodBeat.i(14036);
        super.aWb();
        AppMethodBeat.o(14036);
    }

    public final com.tencent.mm.ui.base.sortview.a se(int i) {
        AppMethodBeat.i(14037);
        int count = super.getCount();
        com.tencent.mm.ui.base.sortview.a se;
        if (count != 0) {
            se = super.se(i);
            AppMethodBeat.o(14037);
            return se;
        }
        se = (a) this.jMy.get(i);
        if (se == null && this.jMx.size() > 0) {
            String bts;
            Object obj;
            for (bqh bqh : this.jMx) {
                if (count == i) {
                    bts = bqh.wSA == null ? null : bqh.wSA.toString();
                    obj = (bvn) bqh.wSC.get(0);
                } else if (i < bqh.wSC.size() + count) {
                    bvn obj2 = (bvn) bqh.wSC.get(i - count);
                    bts = null;
                    break;
                } else {
                    count = bqh.wSC.size() + count;
                }
            }
            bts = null;
            obj2 = null;
            com.tencent.mm.ui.base.sortview.a bVar = new b(obj2, bts);
            bVar.sf(i);
            bVar.setPosition(i);
            this.jMy.put(i, bVar);
            se = bVar;
        }
        AppMethodBeat.o(14037);
        return se;
    }

    public final Object[] sc(int i) {
        AppMethodBeat.i(14038);
        a rZ = rZ(i);
        mh sa = sa(i);
        if (rZ != null) {
            Object[] objArr = new Object[4];
            objArr[0] = this;
            objArr[1] = rZ.jLi;
            objArr[2] = Integer.valueOf(i < this.jMz ? 39 : 56);
            objArr[3] = sa != null ? sa.vQg : "";
            AppMethodBeat.o(14038);
            return objArr;
        }
        Object[] sc = super.sc(i);
        AppMethodBeat.o(14038);
        return sc;
    }
}
