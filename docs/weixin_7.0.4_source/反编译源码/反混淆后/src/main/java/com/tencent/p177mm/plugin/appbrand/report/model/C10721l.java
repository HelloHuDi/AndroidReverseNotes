package com.tencent.p177mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.report.C42673i;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.l */
public final class C10721l {
    private String cst;
    public C10720b iBL;
    public int iBM;
    public String iBN;
    private long iBO;
    public C10722a iBP;

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.l$b */
    public enum C10720b {
        DESKTOP_SEARCH(1),
        RESUME_FROM_WEAPP_EXIT(2),
        BOTTOM_ENTRANCE_IN_DESKTOP(3),
        TOP_ENTRANCE_IN_DESKTOP(4);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(132642);
        }

        private C10720b(int i) {
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.l$a */
    public enum C10722a {
        NEARBY_H5(1),
        EMPTY_PAGE(2),
        LBS_NOT_ALLOW(3),
        NEARBY_MINI_PROGRAM(4);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(132639);
        }

        private C10722a(int i) {
            this.value = i;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(132643);
        String str = "kv_13917{scene=" + this.iBL.value + ", appCount=" + this.iBM + ", nearbyListId='" + this.iBN + '\'' + ", clickTime=" + this.iBO + ", sceneNote='" + this.cst + '\'' + ", openType=" + this.iBP.value + '}';
        AppMethodBeat.m2505o(132643);
        return str;
    }

    /* renamed from: IF */
    public final void mo22274IF() {
        AppMethodBeat.m2504i(132644);
        if (this.iBL == null || this.iBP == null) {
            AppMethodBeat.m2505o(132644);
            return;
        }
        C4990ab.m7416i("MicroMsg.AppBrand.kv_13917", "report " + toString());
        this.iBO = C5046bo.anU();
        C7060h.pYm.mo8381e(13917, C42673i.m75575k(Integer.valueOf(this.iBL.value), Integer.valueOf(this.iBM), this.iBN, Long.valueOf(this.iBO), this.cst, Integer.valueOf(this.iBP.value)));
        AppMethodBeat.m2505o(132644);
    }
}
