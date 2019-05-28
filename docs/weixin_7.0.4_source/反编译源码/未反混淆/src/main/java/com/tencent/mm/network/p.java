package com.tencent.mm.network;

import com.tencent.mars.magicbox.IPxxLogic.ICallBack;
import com.tencent.mars.mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class p implements ICallBack {
    private static long gcN = 0;
    private static int gcO = 0;
    private final String TAG = "IPxxCallback";

    public final String getUplodLogExtrasInfo() {
        AppMethodBeat.i(58528);
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Device:").append(d.vxj).append(" ").append(d.vxk).append(IOUtils.LINE_SEPARATOR_UNIX);
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(58528);
            return stringBuffer2;
        } catch (Exception e) {
            AppMethodBeat.o(58528);
            return null;
        }
    }

    public final void setNewDnsDebugHostInfo(String str, int i) {
        AppMethodBeat.i(58529);
        MMLogic.setNewDnsDebugHost(str, String.valueOf(i));
        AppMethodBeat.o(58529);
    }

    public final String getCrashFilePath(int i) {
        AppMethodBeat.i(58530);
        Date date = new Date(System.currentTimeMillis() - (((long) i) * 86400000));
        String str = e.eSo + "crash_" + new SimpleDateFormat("yyyyMMdd").format(date) + ".txt";
        if (com.tencent.mm.a.e.ct(str)) {
            AppMethodBeat.o(58530);
            return str;
        }
        AppMethodBeat.o(58530);
        return null;
    }

    public final void recoverLinkAddrs() {
        AppMethodBeat.i(58531);
        MMLogic.recoverLinkAddrs();
        AppMethodBeat.o(58531);
    }

    public final void uploadLogResponse(long j, long j2) {
        AppMethodBeat.i(58532);
        ab.i("IPxxCallback", "ipxx progress totalSize:%d uploadSize:%d lastPercent:%d ", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(gcO));
        long anT = bo.anT();
        if (anT - 1 < gcN) {
            AppMethodBeat.o(58532);
            return;
        }
        gcN = anT;
        int i = 0;
        if (j2 >= 0 && j > 0 && j2 < j) {
            i = (int) ((100 * j2) / j);
        }
        if (i > 100) {
            i = 100;
        }
        if (gcO > i) {
            i = gcO;
        }
        gcO = i;
        my(i);
        AppMethodBeat.o(58532);
    }

    public final void uploadLogFail() {
        AppMethodBeat.i(58533);
        gcO = 0;
        my(-1);
        AppMethodBeat.o(58533);
    }

    public final void uploadLogSuccess() {
        AppMethodBeat.i(58534);
        gcO = 0;
        my(100);
        AppMethodBeat.o(58534);
    }

    private static void my(int i) {
        AppMethodBeat.i(58535);
        try {
            aa.ano().mz(i);
            AppMethodBeat.o(58535);
        } catch (Exception e) {
            ab.e("IPxxCallback", "exception:%s", bo.l(e));
            AppMethodBeat.o(58535);
        }
    }
}
