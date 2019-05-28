package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public enum l {
    ;
    
    private String appId;
    private int errCode;
    private int errType;

    private l(String str) {
        this.appId = null;
        this.errType = 0;
        this.errCode = 0;
    }

    static {
        AppMethodBeat.o(59346);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void l(String str, String str2, int i, int i2) {
        int i3;
        AppMethodBeat.i(59345);
        ab.d("MicroMsg.SoterReportManager", "SoterReportManager functionName: %s, appId: %s, errType: %d, errCode: %d", str, str2, Integer.valueOf(i), Integer.valueOf(i2));
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
                ab.e("MicroMsg.SoterReportManager", "unknown soter jsapi function name");
                i3 = -1;
                break;
        }
        ab.i("MicroMsg.SoterReportManager", "functionNameCode: %d", Integer.valueOf(i3));
        if (i3 != -1) {
            h.pYm.e(13711, Integer.valueOf(i3), str2, Integer.valueOf(i), Integer.valueOf(i2));
        }
        AppMethodBeat.o(59345);
    }
}
