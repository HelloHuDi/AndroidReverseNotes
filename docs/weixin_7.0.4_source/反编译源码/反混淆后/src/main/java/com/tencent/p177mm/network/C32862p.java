package com.tencent.p177mm.network;

import com.tencent.mars.magicbox.IPxxLogic.ICallBack;
import com.tencent.mars.p150mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.tencent.mm.network.p */
public final class C32862p implements ICallBack {
    private static long gcN = 0;
    private static int gcO = 0;
    private final String TAG = "IPxxCallback";

    public final String getUplodLogExtrasInfo() {
        AppMethodBeat.m2504i(58528);
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Device:").append(C7243d.vxj).append(" ").append(C7243d.vxk).append(IOUtils.LINE_SEPARATOR_UNIX);
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.m2505o(58528);
            return stringBuffer2;
        } catch (Exception e) {
            AppMethodBeat.m2505o(58528);
            return null;
        }
    }

    public final void setNewDnsDebugHostInfo(String str, int i) {
        AppMethodBeat.m2504i(58529);
        MMLogic.setNewDnsDebugHost(str, String.valueOf(i));
        AppMethodBeat.m2505o(58529);
    }

    public final String getCrashFilePath(int i) {
        AppMethodBeat.m2504i(58530);
        Date date = new Date(System.currentTimeMillis() - (((long) i) * 86400000));
        String str = C6457e.eSo + "crash_" + new SimpleDateFormat("yyyyMMdd").format(date) + ".txt";
        if (C1173e.m2561ct(str)) {
            AppMethodBeat.m2505o(58530);
            return str;
        }
        AppMethodBeat.m2505o(58530);
        return null;
    }

    public final void recoverLinkAddrs() {
        AppMethodBeat.m2504i(58531);
        MMLogic.recoverLinkAddrs();
        AppMethodBeat.m2505o(58531);
    }

    public final void uploadLogResponse(long j, long j2) {
        AppMethodBeat.m2504i(58532);
        C4990ab.m7417i("IPxxCallback", "ipxx progress totalSize:%d uploadSize:%d lastPercent:%d ", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(gcO));
        long anT = C5046bo.anT();
        if (anT - 1 < gcN) {
            AppMethodBeat.m2505o(58532);
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
        C32862p.m53760my(i);
        AppMethodBeat.m2505o(58532);
    }

    public final void uploadLogFail() {
        AppMethodBeat.m2504i(58533);
        gcO = 0;
        C32862p.m53760my(-1);
        AppMethodBeat.m2505o(58533);
    }

    public final void uploadLogSuccess() {
        AppMethodBeat.m2504i(58534);
        gcO = 0;
        C32862p.m53760my(100);
        AppMethodBeat.m2505o(58534);
    }

    /* renamed from: my */
    private static void m53760my(int i) {
        AppMethodBeat.m2504i(58535);
        try {
            C1892aa.ano().mo53439mz(i);
            AppMethodBeat.m2505o(58535);
        } catch (Exception e) {
            C4990ab.m7413e("IPxxCallback", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58535);
        }
    }
}
