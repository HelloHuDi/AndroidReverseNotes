package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.loader.C32473a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.j */
public interface C45515j {
    public static final int[] gSu = new int[]{0, 10002, 10102, 14};
    public static final int[] gSv = new int[]{1, 2, 999, Downloads.MIN_WAIT_FOR_NETWORK, 10001, 10100, 10101};

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.j$a */
    public enum C33097a {
        ;

        /* renamed from: np */
        public static boolean m54090np(int i) {
            AppMethodBeat.m2504i(101717);
            boolean contains = C32473a.contains(C45515j.gSu, i);
            AppMethodBeat.m2505o(101717);
            return contains;
        }

        /* renamed from: kR */
        public static boolean m54089kR(int i) {
            AppMethodBeat.m2504i(101718);
            boolean contains = C32473a.contains(C45515j.gSv, i);
            AppMethodBeat.m2505o(101718);
            return contains;
        }
    }
}
