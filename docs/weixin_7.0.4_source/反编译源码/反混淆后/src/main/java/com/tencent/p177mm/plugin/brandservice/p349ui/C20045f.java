package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.sortview.C46635a;
import com.tencent.p177mm.plugin.brandservice.p349ui.C42811c.C38690a;
import com.tencent.p177mm.plugin.brandservice.p349ui.C42811c.C38691b;
import com.tencent.p177mm.plugin.brandservice.p349ui.base.C11208a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C35934mh;
import com.tencent.p177mm.protocal.protobuf.bqh;
import com.tencent.p177mm.protocal.protobuf.bvn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.f */
public final class C20045f extends C42811c {
    List<bqh> jMx = null;
    private SparseArray<C11208a> jMy = new SparseArray();
    private int jMz;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.f$1 */
    class C200461 implements C38691b {
        C200461() {
        }

        /* renamed from: a */
        public final void mo35292a(C42811c c42811c, C46635a c46635a, int i, String str, int i2, int i3) {
            AppMethodBeat.m2504i(14031);
            C35934mh sa = C20045f.this.mo68274sa(i3);
            String str2 = C5046bo.nullAsNil(C20045f.this.jKW) + "," + i + "," + C5046bo.nullAsNil(str) + "," + i2 + "," + c42811c.jLe + "," + (sa == null ? "" : sa.vQg + ",0");
            C7060h.pYm.mo8374X(10866, str2);
            C4990ab.m7410d("MicroMsg.SearchOrRecommendBizAdapter", "report : ".concat(String.valueOf(str2)));
            AppMethodBeat.m2505o(14031);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(14039);
        C46635a se = mo35291se(i);
        AppMethodBeat.m2505o(14039);
        return se;
    }

    public C20045f(Context context) {
        super(context);
        AppMethodBeat.m2504i(14032);
        setReporter(new C200461());
        AppMethodBeat.m2505o(14032);
    }

    /* renamed from: h */
    public final void mo35289h(String str, List<C35934mh> list) {
        AppMethodBeat.m2504i(14033);
        super.mo35289h(str, list);
        this.jMz = super.getCount();
        AppMethodBeat.m2505o(14033);
    }

    /* renamed from: a */
    public final void mo35285a(C35934mh c35934mh, boolean z) {
        AppMethodBeat.m2504i(14034);
        super.mo35285a(c35934mh, z);
        if (this.jMz == 0) {
            this.jMz = super.getCount();
        }
        AppMethodBeat.m2505o(14034);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(14035);
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
        AppMethodBeat.m2505o(14035);
        return count;
    }

    public final void aWb() {
        AppMethodBeat.m2504i(14036);
        super.aWb();
        AppMethodBeat.m2505o(14036);
    }

    /* renamed from: se */
    public final C46635a mo35291se(int i) {
        AppMethodBeat.m2504i(14037);
        int count = super.getCount();
        C46635a se;
        if (count != 0) {
            se = super.mo35291se(i);
            AppMethodBeat.m2505o(14037);
            return se;
        }
        se = (C11208a) this.jMy.get(i);
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
            C46635a c42810b = new C42810b(obj2, bts);
            c42810b.mo22910sf(i);
            c42810b.setPosition(i);
            this.jMy.put(i, c42810b);
            se = c42810b;
        }
        AppMethodBeat.m2505o(14037);
        return se;
    }

    /* renamed from: sc */
    public final Object[] mo35290sc(int i) {
        AppMethodBeat.m2504i(14038);
        C38690a rZ = mo68273rZ(i);
        C35934mh sa = mo68274sa(i);
        if (rZ != null) {
            Object[] objArr = new Object[4];
            objArr[0] = this;
            objArr[1] = rZ.jLi;
            objArr[2] = Integer.valueOf(i < this.jMz ? 39 : 56);
            objArr[3] = sa != null ? sa.vQg : "";
            AppMethodBeat.m2505o(14038);
            return objArr;
        }
        Object[] sc = super.mo35290sc(i);
        AppMethodBeat.m2505o(14038);
        return sc;
    }
}
