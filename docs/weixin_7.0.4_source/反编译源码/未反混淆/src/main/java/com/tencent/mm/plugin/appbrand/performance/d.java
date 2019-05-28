package com.tencent.mm.plugin.appbrand.performance;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class d {
    public static final int[] ivQ = new int[4];
    public static final SparseArray<Integer> ivR = new SparseArray();

    static {
        AppMethodBeat.i(114390);
        ivQ[0] = R.string.ld;
        ivQ[1] = R.string.lq;
        ivQ[2] = R.string.lw;
        ivQ[3] = R.string.lu;
        ivR.put(101, Integer.valueOf(R.string.le));
        ivR.put(102, Integer.valueOf(R.string.ls));
        ivR.put(103, Integer.valueOf(R.string.lt));
        ivR.put(201, Integer.valueOf(R.string.lh));
        ivR.put(202, Integer.valueOf(R.string.lr));
        ivR.put(203, Integer.valueOf(R.string.ly));
        ivR.put(301, Integer.valueOf(R.string.lo));
        ivR.put(302, Integer.valueOf(R.string.lv));
        ivR.put(303, Integer.valueOf(R.string.lp));
        ivR.put(401, Integer.valueOf(R.string.lx));
        ivR.put(402, Integer.valueOf(R.string.m0));
        ivR.put(403, Integer.valueOf(R.string.m1));
        ivR.put(404, Integer.valueOf(R.string.m2));
        ivR.put(405, Integer.valueOf(R.string.m3));
        ivR.put(406, Integer.valueOf(R.string.m4));
        ivR.put(407, Integer.valueOf(R.string.m5));
        AppMethodBeat.o(114390);
    }
}
