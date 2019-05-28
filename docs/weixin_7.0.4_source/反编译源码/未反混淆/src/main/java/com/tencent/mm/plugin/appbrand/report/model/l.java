package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class l {
    private String cst;
    public b iBL;
    public int iBM;
    public String iBN;
    private long iBO;
    public a iBP;

    public enum b {
        DESKTOP_SEARCH(1),
        RESUME_FROM_WEAPP_EXIT(2),
        BOTTOM_ENTRANCE_IN_DESKTOP(3),
        TOP_ENTRANCE_IN_DESKTOP(4);
        
        public final int value;

        static {
            AppMethodBeat.o(132642);
        }

        private b(int i) {
            this.value = i;
        }
    }

    public enum a {
        NEARBY_H5(1),
        EMPTY_PAGE(2),
        LBS_NOT_ALLOW(3),
        NEARBY_MINI_PROGRAM(4);
        
        public final int value;

        static {
            AppMethodBeat.o(132639);
        }

        private a(int i) {
            this.value = i;
        }
    }

    public final String toString() {
        AppMethodBeat.i(132643);
        String str = "kv_13917{scene=" + this.iBL.value + ", appCount=" + this.iBM + ", nearbyListId='" + this.iBN + '\'' + ", clickTime=" + this.iBO + ", sceneNote='" + this.cst + '\'' + ", openType=" + this.iBP.value + '}';
        AppMethodBeat.o(132643);
        return str;
    }

    public final void IF() {
        AppMethodBeat.i(132644);
        if (this.iBL == null || this.iBP == null) {
            AppMethodBeat.o(132644);
            return;
        }
        ab.i("MicroMsg.AppBrand.kv_13917", "report " + toString());
        this.iBO = bo.anU();
        h.pYm.e(13917, i.k(Integer.valueOf(this.iBL.value), Integer.valueOf(this.iBM), this.iBN, Long.valueOf(this.iBO), this.cst, Integer.valueOf(this.iBP.value)));
        AppMethodBeat.o(132644);
    }
}
