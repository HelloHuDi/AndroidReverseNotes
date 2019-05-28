package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public interface j {
    public static final int[] gSu = new int[]{0, 10002, 10102, 14};
    public static final int[] gSv = new int[]{1, 2, 999, Downloads.MIN_WAIT_FOR_NETWORK, 10001, 10100, 10101};

    public enum a {
        ;

        public static boolean np(int i) {
            AppMethodBeat.i(101717);
            boolean contains = com.tencent.mm.compatible.loader.a.contains(j.gSu, i);
            AppMethodBeat.o(101717);
            return contains;
        }

        public static boolean kR(int i) {
            AppMethodBeat.i(101718);
            boolean contains = com.tencent.mm.compatible.loader.a.contains(j.gSv, i);
            AppMethodBeat.o(101718);
            return contains;
        }
    }
}
