package com.tencent.p177mm.plugin.freewifi.p973b;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C6480fh;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.p416d.C28077j;
import com.tencent.p177mm.plugin.freewifi.p973b.C43103a.C20778a;
import com.tencent.p177mm.protocal.protobuf.baj;
import com.tencent.p177mm.protocal.protobuf.bak;
import com.tencent.p177mm.protocal.protobuf.bal;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.freewifi.b.c */
public final class C28070c {
    private static final String[] mvj = new String[]{"ssid", "bssid", "rssi", "isWechatWifi", "wechatShopName", "maxApCount", "intervalSeconds"};
    private static final String[] mvk = new String[]{"errcode", "errmsg", "maxApCount", "intervalSeconds"};
    private int mvl;
    private int mvm;
    private long mvn;

    /* renamed from: com.tencent.mm.plugin.freewifi.b.c$a */
    static class C28072a {
        private static C28070c mvs = new C28070c();

        static {
            AppMethodBeat.m2504i(20674);
            AppMethodBeat.m2505o(20674);
        }
    }

    /* synthetic */ C28070c(byte b) {
        this();
    }

    /* renamed from: a */
    static /* synthetic */ void m44625a(C28070c c28070c, C6480fh c6480fh, int i, String str) {
        AppMethodBeat.m2504i(20681);
        c28070c.m44623a(c6480fh, i, str);
        AppMethodBeat.m2505o(20681);
    }

    private C28070c() {
        this.mvl = 200;
        this.mvm = 180;
        this.mvn = 0;
    }

    public static C28070c byA() {
        AppMethodBeat.m2504i(20675);
        C28070c byE = C28072a.mvs;
        AppMethodBeat.m2505o(20675);
        return byE;
    }

    /* renamed from: a */
    public final synchronized void mo45991a(final C6480fh c6480fh) {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(20676);
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "method getWifiList called. reqMaxApCount=" + byB() + "; reqIntervalSeconds=" + byC());
            String[] strArr = c6480fh.cyW.cyY;
            if (strArr == null || strArr.length == 0) {
                m44623a(c6480fh, 1101, "Args is empty.");
                AppMethodBeat.m2505o(20676);
            } else {
                int i2;
                StringBuilder stringBuilder = new StringBuilder();
                for (i2 = 0; i2 < strArr.length; i2++) {
                    stringBuilder.append("args[" + i2 + "] = " + strArr[i2]);
                }
                C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "args: " + stringBuilder.toString());
                try {
                    if (Integer.valueOf(strArr[0]).intValue() != 1) {
                        m44623a(c6480fh, 1103, "Wechant installed currently only supports version 1.");
                        AppMethodBeat.m2505o(20676);
                    } else if (strArr.length != 3) {
                        m44623a(c6480fh, 1104, "Args.length should be 3, but now it is " + strArr.length + ".");
                        AppMethodBeat.m2505o(20676);
                    } else {
                        try {
                            i2 = Integer.valueOf(strArr[2]).intValue();
                            if (i2 != 1 && i2 != 2) {
                                m44623a(c6480fh, 1106, "Args[2] should be integer 1 (from setting) or integer 2 (from background).");
                                AppMethodBeat.m2505o(20676);
                            } else if (byD() != 0 && System.currentTimeMillis() - byD() < ((long) byC()) && i2 == 2) {
                                m44623a(c6480fh, FaceManager.FACE_ACQUIRED_SHIFTING, "Request frequence is out of limit. The time btween two background request should be more than  " + this.mvm + " seconds.");
                                AppMethodBeat.m2505o(20676);
                            } else if (C34189m.isEmpty(strArr[1])) {
                                m44623a(c6480fh, 1105, "Args[1] should be an ap list json string, but now it is empty.");
                                AppMethodBeat.m2505o(20676);
                            } else {
                                final LinkedList linkedList = new LinkedList();
                                try {
                                    JSONArray jSONArray = new JSONArray(strArr[1]);
                                    if (jSONArray.length() > byB()) {
                                        m44623a(c6480fh, FaceManager.FACE_ACQUIRED_DARK, "jsonArray.length()=" + jSONArray.length() + ". Too many ap. The number of ap requested per time should be between 1 and " + byB() + ".");
                                        AppMethodBeat.m2505o(20676);
                                    } else if (jSONArray.length() == 0) {
                                        m44623a(c6480fh, FaceManager.FACE_ACQUIRED_DARK, "jsonArray.length()=" + jSONArray.length() + ". Too many ap. The number of ap requested per time should be between 1 and " + byB() + ".");
                                        AppMethodBeat.m2505o(20676);
                                    } else {
                                        while (i < jSONArray.length()) {
                                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                                            bak bak = new bak();
                                            bak.ssid = C34189m.m56057Mv(jSONObject.getString("ssid"));
                                            bak.bssid = jSONObject.getString("bssid");
                                            bak.cyC = jSONObject.getInt("rssi");
                                            linkedList.add(bak);
                                            i++;
                                        }
                                        new C28077j(linkedList, i2).mo68619c(new C1202f() {
                                            /* JADX WARNING: Removed duplicated region for block: B:48:0x02bb A:{SYNTHETIC, Splitter:B:48:0x02bb} */
                                            /* Code decompiled incorrectly, please refer to instructions dump. */
                                            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                                                Exception e;
                                                AppMethodBeat.m2504i(20673);
                                                synchronized (C28070c.this) {
                                                    try {
                                                        baj bzp = ((C28077j) c1207m).bzp();
                                                        C28070c.this.mo45994iM(System.currentTimeMillis());
                                                        C28070c.this.mo45996vQ(bzp.mvm <= 0 ? 180 : bzp.mvm);
                                                        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "resp.reqMaxApCount=" + bzp.mvl);
                                                        int i3 = bzp.mvl <= 0 ? 200 : bzp.mvl;
                                                        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "_reqMaxApCount = ".concat(String.valueOf(i3)));
                                                        C28070c.this.mo45995vP(i3);
                                                        if (i == 0 && i2 == 0) {
                                                            LinkedList linkedList = bzp.wEg;
                                                            MatrixCursor matrixCursor = null;
                                                            try {
                                                                MatrixCursor matrixCursor2 = new MatrixCursor(C28070c.mvj);
                                                                try {
                                                                    HashMap hashMap = new HashMap();
                                                                    i3 = 0;
                                                                    while (true) {
                                                                        int i4 = i3;
                                                                        if (i4 >= linkedList.size()) {
                                                                            break;
                                                                        }
                                                                        bal bal = (bal) linkedList.get(i4);
                                                                        hashMap.put(bal.ssid + "-" + bal.bssid, Integer.valueOf(i4));
                                                                        i3 = i4 + 1;
                                                                    }
                                                                    for (int i5 = 0; i5 < linkedList.size(); i5++) {
                                                                        bak bak = (bak) linkedList.get(i5);
                                                                        bal bal2 = new bal();
                                                                        bal2.ssid = bak.ssid;
                                                                        bal2.bssid = bak.bssid;
                                                                        bal2.cyC = bak.cyC;
                                                                        bal2.wEh = 0;
                                                                        bal2.wEi = null;
                                                                        bal2.mue = 0;
                                                                        bal2.cuH = null;
                                                                        if (hashMap.get(bal2.ssid + "-" + bal2.bssid) != null) {
                                                                            Integer num = (Integer) hashMap.get(bal2.ssid + "-" + bal2.bssid);
                                                                            if (linkedList.get(num.intValue()) != null) {
                                                                                bal2.wEh = ((bal) linkedList.get(num.intValue())).wEh;
                                                                                bal2.wEi = ((bal) linkedList.get(num.intValue())).wEi;
                                                                                bal2.mue = ((bal) linkedList.get(num.intValue())).mue;
                                                                                bal2.cuH = ((bal) linkedList.get(num.intValue())).cuH;
                                                                            }
                                                                        }
                                                                        if (bal2.mue == 4 || bal2.mue == 31) {
                                                                            matrixCursor2.addRow(new Object[]{bal2.ssid, bal2.bssid, Integer.valueOf(bal2.cyC), Integer.valueOf(bal2.wEh), bal2.wEi, Integer.valueOf(C28070c.this.byB()), Integer.valueOf(C28070c.this.byC())});
                                                                            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", bal2.ssid, bal2.bssid, Integer.valueOf(bal2.cyC), Integer.valueOf(bal2.wEh), bal2.wEi, Integer.valueOf(C28070c.this.byB()), Integer.valueOf(C28070c.this.byC()));
                                                                            if (bal2.wEh == 1 && i2 == 1) {
                                                                                C20778a.mve.mo68615e(bal2.ssid, bal2.bssid, bal2.cuH, bal2.mue);
                                                                                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cached : ssid=%s, bssid=%s, apKey=%s, protocolType=%d. ", bal2.ssid, bal2.bssid, bal2.cuH, Integer.valueOf(bal2.mue));
                                                                            }
                                                                        } else {
                                                                            matrixCursor2.addRow(new Object[]{bal2.ssid, bal2.bssid, Integer.valueOf(bal2.cyC), Integer.valueOf(0), null, Integer.valueOf(C28070c.this.byB()), Integer.valueOf(C28070c.this.byC())});
                                                                            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", bal2.ssid, bal2.bssid, Integer.valueOf(bal2.cyC), Integer.valueOf(0), null, Integer.valueOf(C28070c.this.byB()), Integer.valueOf(C28070c.this.byC()));
                                                                        }
                                                                    }
                                                                    C28070c.m44624a(c6480fh, matrixCursor2);
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                    matrixCursor = matrixCursor2;
                                                                    if (matrixCursor != null) {
                                                                        matrixCursor.close();
                                                                    }
                                                                    C4990ab.m7413e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", e);
                                                                    C28070c.m44625a(C28070c.this, c6480fh, FaceManager.FACE_ACQUIRED_NO_FACE, "cursor exception.");
                                                                    AppMethodBeat.m2505o(20673);
                                                                }
                                                            } catch (Exception e3) {
                                                                e = e3;
                                                                if (matrixCursor != null) {
                                                                }
                                                                C4990ab.m7413e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", e);
                                                                C28070c.m44625a(C28070c.this, c6480fh, FaceManager.FACE_ACQUIRED_NO_FACE, "cursor exception.");
                                                                AppMethodBeat.m2505o(20673);
                                                            }
                                                        } else if (i2 == -30035) {
                                                            C28070c.m44625a(C28070c.this, c6480fh, FaceManager.FACE_ACQUIRED_DARK, "Too many ap. The number of ap requested per time should be between 1 and " + C28070c.this.byB() + ".");
                                                            AppMethodBeat.m2505o(20673);
                                                        } else {
                                                            C28070c.m44625a(C28070c.this, c6480fh, FaceManager.FACE_ACQUIRED_MULTI_FACE, "Server returns errtype= " + i + ", errcode=" + i2 + ", errMsg=" + C34189m.m56058Mw(str) + ".");
                                                            AppMethodBeat.m2505o(20673);
                                                        }
                                                    } finally {
                                                        while (true) {
                                                        }
                                                        AppMethodBeat.m2505o(20673);
                                                    }
                                                }
                                            }
                                        });
                                        AppMethodBeat.m2505o(20676);
                                    }
                                } catch (Exception e) {
                                    m44623a(c6480fh, 1105, "Args[1] is not a valid json array value and it should be a string like  [  {    \"ssid\": \"SSID_NAME\",    \"bssid\": \"0e:00:00:00:00:00\",    \"rssi\": -45  }].");
                                    AppMethodBeat.m2505o(20676);
                                }
                            }
                        } catch (Exception e2) {
                            m44623a(c6480fh, 1107, "Args[2] is not a valid int value.");
                            AppMethodBeat.m2505o(20676);
                        }
                    }
                } catch (Exception e3) {
                    m44623a(c6480fh, 1102, "Args[0] is not an integer.");
                    AppMethodBeat.m2505o(20676);
                }
            }
        }
        return;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m44623a(C6480fh c6480fh, int i, String str) {
        Exception e;
        AppMethodBeat.m2504i(20677);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setErrorResult. errorcode=%d, errmsg=%s", Integer.valueOf(i), str);
        MatrixCursor matrixCursor;
        try {
            matrixCursor = new MatrixCursor(mvk);
            try {
                matrixCursor.addRow(new Object[]{Integer.valueOf(i), str, Integer.valueOf(byB()), Integer.valueOf(byC())});
                c6480fh.cyX.cyZ = matrixCursor;
                c6480fh.cyX.cyD = 1;
                if (c6480fh.callback != null) {
                    c6480fh.callback.run();
                }
                AppMethodBeat.m2505o(20677);
            } catch (Exception e2) {
                e = e2;
                if (matrixCursor != null) {
                }
                C4990ab.m7413e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", e);
                c6480fh.cyX.cyZ = null;
                c6480fh.cyX.cyD = 1;
                if (c6480fh.callback != null) {
                }
                AppMethodBeat.m2505o(20677);
            }
        } catch (Exception e3) {
            e = e3;
            matrixCursor = null;
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            C4990ab.m7413e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", e);
            c6480fh.cyX.cyZ = null;
            c6480fh.cyX.cyD = 1;
            if (c6480fh.callback != null) {
                c6480fh.callback.run();
            }
            AppMethodBeat.m2505o(20677);
        }
    }

    public final synchronized int byB() {
        int i;
        AppMethodBeat.m2504i(20678);
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "getReqMaxApCount() returns " + this.mvl);
        i = this.mvl;
        AppMethodBeat.m2505o(20678);
        return i;
    }

    /* renamed from: vP */
    public final synchronized void mo45995vP(int i) {
        AppMethodBeat.m2504i(20679);
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() param reqMaxApCount = ".concat(String.valueOf(i)));
        this.mvl = i;
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() this.reqMaxApCount = " + this.mvl);
        AppMethodBeat.m2505o(20679);
    }

    public final synchronized int byC() {
        return this.mvm;
    }

    /* renamed from: vQ */
    public final synchronized void mo45996vQ(int i) {
        this.mvm = i;
    }

    private synchronized long byD() {
        return this.mvn;
    }

    /* renamed from: iM */
    public final synchronized void mo45994iM(long j) {
        this.mvn = j;
    }

    /* renamed from: a */
    static /* synthetic */ void m44624a(C6480fh c6480fh, MatrixCursor matrixCursor) {
        AppMethodBeat.m2504i(20680);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setResult. errorcode=%d, errmsg=%s", Integer.valueOf(1), null);
        c6480fh.cyX.cyZ = matrixCursor;
        c6480fh.cyX.cyD = 1;
        if (c6480fh.callback != null) {
            c6480fh.callback.run();
        }
        AppMethodBeat.m2505o(20680);
    }
}
