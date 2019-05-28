package com.tencent.mm.plugin.misc.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.content.b;
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
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class a implements f, c, com.tencent.mm.kernel.b.c {
    private static volatile a ore;
    private Handler mHandler = new Handler();

    static class a {
        public boolean bUt;
        public String org;
        public String orh;
        public String ori;
        public String orj;
        public int ork;
        public String type;
    }

    public a() {
        AppMethodBeat.i(50505);
        AppMethodBeat.o(50505);
    }

    public static synchronized a bOM() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(50506);
            if (ore == null) {
                ore = new a();
            }
            aVar = ore;
            AppMethodBeat.o(50506);
        }
        return aVar;
    }

    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(50507);
        g.Rg().a(-1, (f) this);
        AppMethodBeat.o(50507);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(50508);
        g.Rg().b(-1, (f) this);
        AppMethodBeat.o(50508);
    }

    public final void onSceneEnd(final int i, final int i2, String str, final m mVar) {
        AppMethodBeat.i(50509);
        if (str == null || !str.startsWith("autoauth_errmsg_")) {
            this.mHandler.post(new Runnable() {
                /* JADX WARNING: Missing block: B:12:0x0038, code skipped:
            if (r3.startsWith("/cgi-bin/mmpay-bin/") != false) goto L_0x001e;
     */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    int i = 1;
                    AppMethodBeat.i(50504);
                    int type = mVar.getType();
                    q qVar = mVar.ftl;
                    if (!(type == 1616 || type == 1518 || type == 385)) {
                        if (qVar != null) {
                            String uri = qVar.getUri();
                            if (uri != null) {
                            }
                        }
                        i = 0;
                    }
                    a.A(i, i, i2, type);
                    AppMethodBeat.o(50504);
                }
            });
            AppMethodBeat.o(50509);
            return;
        }
        AppMethodBeat.o(50509);
    }

    public static void A(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(50510);
        try {
            if (!at.isMobile(ah.getContext())) {
                AppMethodBeat.o(50510);
            } else if (b.checkSelfPermission(ah.getContext(), "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                AppMethodBeat.o(50510);
            } else {
                boolean z;
                if (i2 == 0 && i3 == 0) {
                    z = true;
                } else {
                    z = false;
                }
                List<a> et = et(ah.getContext());
                if (et.size() == 0) {
                    AppMethodBeat.o(50510);
                    return;
                }
                int i5;
                int i6;
                a aVar = (a) et.get(0);
                for (a aVar2 : et) {
                    if (aVar2.bUt) {
                        break;
                    }
                }
                a aVar22 = aVar;
                String str = aVar22.org;
                String str2 = aVar22.orh;
                String str3 = aVar22.orj;
                String str4 = aVar22.ori;
                String str5 = aVar22.type;
                int i7 = aVar22.ork;
                if (i == 1) {
                    i5 = 3;
                } else if (z) {
                    i5 = 1;
                } else {
                    i5 = 2;
                }
                ab.i("MicroMsg.NetworkOptReport", "reportCellInfo mcc[%s] mnc[%s] lac[%s] cellid[%s] netType[%s] dbm[%d] type[%d] success[%s] errType[%d] errCode[%d] cmdid[%d] reportType[%d]", str, str2, str3, str4, str5, Integer.valueOf(i7), Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
                h hVar = h.pYm;
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
                str = h.s(objArr);
                if (!ah.bqo()) {
                    h.a(15608, i5, str, false, false);
                    AppMethodBeat.o(50510);
                } else if (com.tencent.mm.plugin.report.a.c.pXd) {
                    long j = (long) i5;
                    boolean z2 = com.tencent.mm.plugin.report.a.c.pXe;
                    com.tencent.mm.plugin.report.service.e.a(15608, j, str, z2, z2, false);
                    AppMethodBeat.o(50510);
                } else {
                    com.tencent.mm.plugin.report.service.e.a(15608, (long) i5, str, false, false, false);
                    AppMethodBeat.o(50510);
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.NetworkOptReport", "getNetType : %s", bo.l(e));
            AppMethodBeat.o(50510);
        }
    }

    private static synchronized List<a> et(Context context) {
        LinkedList linkedList;
        synchronized (a.class) {
            AppMethodBeat.i(50511);
            linkedList = new LinkedList();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int i = VERSION.SDK_INT;
            try {
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    for (CellInfo cellInfo : allCellInfo) {
                        int i2;
                        a aVar = new a();
                        int mnc;
                        if (cellInfo instanceof CellInfoGsm) {
                            CellSignalStrengthGsm cellSignalStrength = ((CellInfoGsm) cellInfo).getCellSignalStrength();
                            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                            mnc = cellIdentity.getMnc();
                            aVar.ori = cellIdentity.getCid();
                            aVar.org = cellIdentity.getMcc();
                            aVar.orh = cellIdentity.getMnc();
                            aVar.orj = cellIdentity.getLac();
                            aVar.ork = cellSignalStrength.getDbm();
                            aVar.bUt = cellInfo.isRegistered();
                            aVar.type = "gsm";
                            i2 = mnc;
                        } else if (cellInfo instanceof CellInfoCdma) {
                            CellSignalStrengthCdma cellSignalStrength2 = ((CellInfoCdma) cellInfo).getCellSignalStrength();
                            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                            mnc = cellIdentity2.getSystemId();
                            aVar.ori = cellIdentity2.getBasestationId();
                            aVar.orh = cellIdentity2.getSystemId();
                            aVar.orj = cellIdentity2.getNetworkId();
                            aVar.ork = cellSignalStrength2.getDbm();
                            aVar.bUt = cellInfo.isRegistered();
                            aVar.type = "cdma";
                            i2 = mnc;
                        } else if (cellInfo instanceof CellInfoLte) {
                            CellSignalStrengthLte cellSignalStrength3 = ((CellInfoLte) cellInfo).getCellSignalStrength();
                            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
                            mnc = cellIdentity3.getMnc();
                            aVar.ori = cellIdentity3.getCi();
                            aVar.org = cellIdentity3.getMcc();
                            aVar.orh = cellIdentity3.getMnc();
                            aVar.orj = cellIdentity3.getTac();
                            aVar.ork = cellSignalStrength3.getDbm();
                            aVar.bUt = cellInfo.isRegistered();
                            aVar.type = "lte";
                            i2 = mnc;
                        } else if (i < 18 || !(cellInfo instanceof CellInfoWcdma)) {
                            ab.i("MicroMsg.NetworkOptReport", "Unknown type of cell signal!\n ClassName: " + cellInfo.getClass().getSimpleName() + "\n ToString: " + cellInfo.toString());
                            i2 = 0;
                        } else {
                            CellSignalStrengthWcdma cellSignalStrength4 = ((CellInfoWcdma) cellInfo).getCellSignalStrength();
                            CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            mnc = cellIdentity4.getMnc();
                            aVar.ori = cellIdentity4.getCid();
                            aVar.org = cellIdentity4.getMcc();
                            aVar.orh = cellIdentity4.getMnc();
                            aVar.orj = cellIdentity4.getLac();
                            aVar.ork = cellSignalStrength4.getDbm();
                            aVar.bUt = cellInfo.isRegistered();
                            aVar.type = "wcdma";
                            i2 = mnc;
                        }
                        if (aVar.orh.length() == 1) {
                            aVar.orh = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_NO).append(aVar.orh).toString();
                        }
                        if (i2 != Integer.MAX_VALUE) {
                            linkedList.add(aVar);
                        }
                    }
                }
            } catch (Exception e) {
                ab.e("MicroMsg.NetworkOptReport", "loadCellInfo: Unable to obtain cell signal information: ", e);
            }
            AppMethodBeat.o(50511);
        }
        return linkedList;
    }
}
