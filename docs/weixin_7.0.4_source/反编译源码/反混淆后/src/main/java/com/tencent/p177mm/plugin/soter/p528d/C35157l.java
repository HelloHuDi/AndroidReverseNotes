package com.tencent.p177mm.plugin.soter.p528d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.soter.d.l */
public enum C35157l {
    ;
    
    private String appId;
    private int errCode;
    private int errType;

    private C35157l(String str) {
        this.appId = null;
        this.errType = 0;
        this.errCode = 0;
    }

    static {
        AppMethodBeat.m2505o(59346);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: l */
    public static void m57791l(String str, String str2, int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(59345);
        C4990ab.m7411d("MicroMsg.SoterReportManager", "SoterReportManager functionName: %s, appId: %s, errType: %d, errCode: %d", str, str2, Integer.valueOf(i), Integer.valueOf(i2));
        switch (str.hashCode()) {
            case -1378849968:
                if (str.equals("requireSoterBiometricAuthentication")) {
                    i3 = 0;
                    break;
                }
            case 70807596:
                if (str.equals("getSupportSoter")) {
                    i3 = 1;
                    break;
                }
            default:
                i3 = -1;
                break;
        }
        switch (i3) {
            case 0:
                i3 = 0;
                break;
            case 1:
                i3 = 1;
                break;
            default:
                C4990ab.m7412e("MicroMsg.SoterReportManager", "unknown soter jsapi function name");
                i3 = -1;
                break;
        }
        C4990ab.m7417i("MicroMsg.SoterReportManager", "functionNameCode: %d", Integer.valueOf(i3));
        if (i3 != -1) {
            C7060h.pYm.mo8381e(13711, Integer.valueOf(i3), str2, Integer.valueOf(i), Integer.valueOf(i2));
        }
        AppMethodBeat.m2505o(59345);
    }
}
