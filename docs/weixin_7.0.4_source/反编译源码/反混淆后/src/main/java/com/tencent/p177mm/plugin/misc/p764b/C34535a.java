package com.tencent.p177mm.plugin.misc.p764b;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.p057v4.content.C0380b;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p241b.C6617c;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.report.p498a.C3730c;
import com.tencent.p177mm.plugin.report.service.C3744e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.misc.b.a */
public final class C34535a implements C1202f, C1671c, C6617c {
    private static volatile C34535a ore;
    private Handler mHandler = new Handler();

    /* renamed from: com.tencent.mm.plugin.misc.b.a$a */
    static class C12535a {
        public boolean bUt;
        public String org;
        public String orh;
        public String ori;
        public String orj;
        public int ork;
        public String type;
    }

    public C34535a() {
        AppMethodBeat.m2504i(50505);
        AppMethodBeat.m2505o(50505);
    }

    public static synchronized C34535a bOM() {
        C34535a c34535a;
        synchronized (C34535a.class) {
            AppMethodBeat.m2504i(50506);
            if (ore == null) {
                ore = new C34535a();
            }
            c34535a = ore;
            AppMethodBeat.m2505o(50506);
        }
        return c34535a;
    }

    public final void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(50507);
        C1720g.m3540Rg().mo14539a(-1, (C1202f) this);
        AppMethodBeat.m2505o(50507);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(50508);
        C1720g.m3540Rg().mo14546b(-1, (C1202f) this);
        AppMethodBeat.m2505o(50508);
    }

    public final void onSceneEnd(final int i, final int i2, String str, final C1207m c1207m) {
        AppMethodBeat.m2504i(50509);
        if (str == null || !str.startsWith("autoauth_errmsg_")) {
            this.mHandler.post(new Runnable() {
                /* JADX WARNING: Missing block: B:12:0x0038, code skipped:
            if (r3.startsWith("/cgi-bin/mmpay-bin/") != false) goto L_0x001e;
     */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    int i = 1;
                    AppMethodBeat.m2504i(50504);
                    int type = c1207m.getType();
                    C1929q c1929q = c1207m.ftl;
                    if (!(type == 1616 || type == 1518 || type == 385)) {
                        if (c1929q != null) {
                            String uri = c1929q.getUri();
                            if (uri != null) {
                            }
                        }
                        i = 0;
                    }
                    C34535a.m56627A(i, i, i2, type);
                    AppMethodBeat.m2505o(50504);
                }
            });
            AppMethodBeat.m2505o(50509);
            return;
        }
        AppMethodBeat.m2505o(50509);
    }

    /* renamed from: A */
    public static void m56627A(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(50510);
        try {
            if (!C5023at.isMobile(C4996ah.getContext())) {
                AppMethodBeat.m2505o(50510);
            } else if (C0380b.checkSelfPermission(C4996ah.getContext(), "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                AppMethodBeat.m2505o(50510);
            } else {
                boolean z;
                if (i2 == 0 && i3 == 0) {
                    z = true;
                } else {
                    z = false;
                }
                List<C12535a> et = C34535a.m56628et(C4996ah.getContext());
                if (et.size() == 0) {
                    AppMethodBeat.m2505o(50510);
                    return;
                }
                int i5;
                int i6;
                C12535a c12535a = (C12535a) et.get(0);
                for (C12535a c12535a2 : et) {
                    if (c12535a2.bUt) {
                        break;
                    }
                }
                C12535a c12535a22 = c12535a;
                String str = c12535a22.org;
                String str2 = c12535a22.orh;
                String str3 = c12535a22.orj;
                String str4 = c12535a22.ori;
                String str5 = c12535a22.type;
                int i7 = c12535a22.ork;
                if (i == 1) {
                    i5 = 3;
                } else if (z) {
                    i5 = 1;
                } else {
                    i5 = 2;
                }
                C4990ab.m7417i("MicroMsg.NetworkOptReport", "reportCellInfo mcc[%s] mnc[%s] lac[%s] cellid[%s] netType[%s] dbm[%d] type[%d] success[%s] errType[%d] errCode[%d] cmdid[%d] reportType[%d]", str, str2, str3, str4, str5, Integer.valueOf(i7), Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[13];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = str3;
                objArr[3] = str4;
                objArr[4] = str5;
                objArr[5] = Integer.valueOf(i);
                if (z) {
                    i6 = 0;
                } else {
                    i6 = 1;
                }
                objArr[6] = Integer.valueOf(i6);
                objArr[7] = Integer.valueOf(0);
                objArr[8] = Integer.valueOf(i7);
                objArr[9] = Integer.valueOf(i2);
                objArr[10] = Integer.valueOf(i3);
                objArr[11] = Integer.valueOf(i4);
                objArr[12] = Integer.valueOf(i5);
                str = C7060h.m11804s(objArr);
                if (!C4996ah.bqo()) {
                    C7060h.m11790a(15608, i5, str, false, false);
                    AppMethodBeat.m2505o(50510);
                } else if (C3730c.pXd) {
                    long j = (long) i5;
                    boolean z2 = C3730c.pXe;
                    C3744e.m6057a(15608, j, str, z2, z2, false);
                    AppMethodBeat.m2505o(50510);
                } else {
                    C3744e.m6057a(15608, (long) i5, str, false, false, false);
                    AppMethodBeat.m2505o(50510);
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NetworkOptReport", "getNetType : %s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(50510);
        }
    }

    /* renamed from: et */
    private static synchronized List<C12535a> m56628et(Context context) {
        LinkedList linkedList;
        synchronized (C34535a.class) {
            AppMethodBeat.m2504i(50511);
            linkedList = new LinkedList();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int i = VERSION.SDK_INT;
            try {
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    for (CellInfo cellInfo : allCellInfo) {
                        int i2;
                        C12535a c12535a = new C12535a();
                        int mnc;
                        if (cellInfo instanceof CellInfoGsm) {
                            CellSignalStrengthGsm cellSignalStrength = ((CellInfoGsm) cellInfo).getCellSignalStrength();
                            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                            mnc = cellIdentity.getMnc();
                            c12535a.ori = cellIdentity.getCid();
                            c12535a.org = cellIdentity.getMcc();
                            c12535a.orh = cellIdentity.getMnc();
                            c12535a.orj = cellIdentity.getLac();
                            c12535a.ork = cellSignalStrength.getDbm();
                            c12535a.bUt = cellInfo.isRegistered();
                            c12535a.type = "gsm";
                            i2 = mnc;
                        } else if (cellInfo instanceof CellInfoCdma) {
                            CellSignalStrengthCdma cellSignalStrength2 = ((CellInfoCdma) cellInfo).getCellSignalStrength();
                            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                            mnc = cellIdentity2.getSystemId();
                            c12535a.ori = cellIdentity2.getBasestationId();
                            c12535a.orh = cellIdentity2.getSystemId();
                            c12535a.orj = cellIdentity2.getNetworkId();
                            c12535a.ork = cellSignalStrength2.getDbm();
                            c12535a.bUt = cellInfo.isRegistered();
                            c12535a.type = "cdma";
                            i2 = mnc;
                        } else if (cellInfo instanceof CellInfoLte) {
                            CellSignalStrengthLte cellSignalStrength3 = ((CellInfoLte) cellInfo).getCellSignalStrength();
                            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
                            mnc = cellIdentity3.getMnc();
                            c12535a.ori = cellIdentity3.getCi();
                            c12535a.org = cellIdentity3.getMcc();
                            c12535a.orh = cellIdentity3.getMnc();
                            c12535a.orj = cellIdentity3.getTac();
                            c12535a.ork = cellSignalStrength3.getDbm();
                            c12535a.bUt = cellInfo.isRegistered();
                            c12535a.type = "lte";
                            i2 = mnc;
                        } else if (i < 18 || !(cellInfo instanceof CellInfoWcdma)) {
                            C4990ab.m7416i("MicroMsg.NetworkOptReport", "Unknown type of cell signal!\n ClassName: " + cellInfo.getClass().getSimpleName() + "\n ToString: " + cellInfo.toString());
                            i2 = 0;
                        } else {
                            CellSignalStrengthWcdma cellSignalStrength4 = ((CellInfoWcdma) cellInfo).getCellSignalStrength();
                            CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            mnc = cellIdentity4.getMnc();
                            c12535a.ori = cellIdentity4.getCid();
                            c12535a.org = cellIdentity4.getMcc();
                            c12535a.orh = cellIdentity4.getMnc();
                            c12535a.orj = cellIdentity4.getLac();
                            c12535a.ork = cellSignalStrength4.getDbm();
                            c12535a.bUt = cellInfo.isRegistered();
                            c12535a.type = "wcdma";
                            i2 = mnc;
                        }
                        if (c12535a.orh.length() == 1) {
                            c12535a.orh = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_NO).append(c12535a.orh).toString();
                        }
                        if (i2 != Integer.MAX_VALUE) {
                            linkedList.add(c12535a);
                        }
                    }
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.NetworkOptReport", "loadCellInfo: Unable to obtain cell signal information: ", e);
            }
            AppMethodBeat.m2505o(50511);
        }
        return linkedList;
    }
}
