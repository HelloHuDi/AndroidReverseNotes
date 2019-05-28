package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static final String[] mvj = new String[]{"ssid", "bssid", "rssi", "isWechatWifi", "wechatShopName", "maxApCount", "intervalSeconds"};
    private static final String[] mvk = new String[]{"errcode", "errmsg", "maxApCount", "intervalSeconds"};
    private int mvl;
    private int mvm;
    private long mvn;

    static class a {
        private static c mvs = new c();

        static {
            AppMethodBeat.i(20674);
            AppMethodBeat.o(20674);
        }
    }

    /* synthetic */ c(byte b) {
        this();
    }

    static /* synthetic */ void a(c cVar, fh fhVar, int i, String str) {
        AppMethodBeat.i(20681);
        cVar.a(fhVar, i, str);
        AppMethodBeat.o(20681);
    }

    private c() {
        this.mvl = 200;
        this.mvm = 180;
        this.mvn = 0;
    }

    public static c byA() {
        AppMethodBeat.i(20675);
        c byE = a.mvs;
        AppMethodBeat.o(20675);
        return byE;
    }

    public final synchronized void a(final fh fhVar) {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(20676);
            ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "method getWifiList called. reqMaxApCount=" + byB() + "; reqIntervalSeconds=" + byC());
            String[] strArr = fhVar.cyW.cyY;
            if (strArr == null || strArr.length == 0) {
                a(fhVar, 1101, "Args is empty.");
                AppMethodBeat.o(20676);
            } else {
                int i2;
                StringBuilder stringBuilder = new StringBuilder();
                for (i2 = 0; i2 < strArr.length; i2++) {
                    stringBuilder.append("args[" + i2 + "] = " + strArr[i2]);
                }
                ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "args: " + stringBuilder.toString());
                try {
                    if (Integer.valueOf(strArr[0]).intValue() != 1) {
                        a(fhVar, 1103, "Wechant installed currently only supports version 1.");
                        AppMethodBeat.o(20676);
                    } else if (strArr.length != 3) {
                        a(fhVar, 1104, "Args.length should be 3, but now it is " + strArr.length + ".");
                        AppMethodBeat.o(20676);
                    } else {
                        try {
                            i2 = Integer.valueOf(strArr[2]).intValue();
                            if (i2 != 1 && i2 != 2) {
                                a(fhVar, 1106, "Args[2] should be integer 1 (from setting) or integer 2 (from background).");
                                AppMethodBeat.o(20676);
                            } else if (byD() != 0 && System.currentTimeMillis() - byD() < ((long) byC()) && i2 == 2) {
                                a(fhVar, FaceManager.FACE_ACQUIRED_SHIFTING, "Request frequence is out of limit. The time btween two background request should be more than  " + this.mvm + " seconds.");
                                AppMethodBeat.o(20676);
                            } else if (m.isEmpty(strArr[1])) {
                                a(fhVar, 1105, "Args[1] should be an ap list json string, but now it is empty.");
                                AppMethodBeat.o(20676);
                            } else {
                                final LinkedList linkedList = new LinkedList();
                                try {
                                    JSONArray jSONArray = new JSONArray(strArr[1]);
                                    if (jSONArray.length() > byB()) {
                                        a(fhVar, FaceManager.FACE_ACQUIRED_DARK, "jsonArray.length()=" + jSONArray.length() + ". Too many ap. The number of ap requested per time should be between 1 and " + byB() + ".");
                                        AppMethodBeat.o(20676);
                                    } else if (jSONArray.length() == 0) {
                                        a(fhVar, FaceManager.FACE_ACQUIRED_DARK, "jsonArray.length()=" + jSONArray.length() + ". Too many ap. The number of ap requested per time should be between 1 and " + byB() + ".");
                                        AppMethodBeat.o(20676);
                                    } else {
                                        while (i < jSONArray.length()) {
                                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                                            bak bak = new bak();
                                            bak.ssid = m.Mv(jSONObject.getString("ssid"));
                                            bak.bssid = jSONObject.getString("bssid");
                                            bak.cyC = jSONObject.getInt("rssi");
                                            linkedList.add(bak);
                                            i++;
                                        }
                                        new j(linkedList, i2).c(new f() {
                                            /* JADX WARNING: Removed duplicated region for block: B:48:0x02bb A:{SYNTHETIC, Splitter:B:48:0x02bb} */
                                            /* Code decompiled incorrectly, please refer to instructions dump. */
                                            public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                                                Exception e;
                                                AppMethodBeat.i(20673);
                                                synchronized (c.this) {
                                                    try {
                                                        baj bzp = ((j) mVar).bzp();
                                                        c.this.iM(System.currentTimeMillis());
                                                        c.this.vQ(bzp.mvm <= 0 ? 180 : bzp.mvm);
                                                        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "resp.reqMaxApCount=" + bzp.mvl);
                                                        int i3 = bzp.mvl <= 0 ? 200 : bzp.mvl;
                                                        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "_reqMaxApCount = ".concat(String.valueOf(i3)));
                                                        c.this.vP(i3);
                                                        if (i == 0 && i2 == 0) {
                                                            LinkedList linkedList = bzp.wEg;
                                                            MatrixCursor matrixCursor = null;
                                                            try {
                                                                MatrixCursor matrixCursor2 = new MatrixCursor(c.mvj);
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
                                                                            matrixCursor2.addRow(new Object[]{bal2.ssid, bal2.bssid, Integer.valueOf(bal2.cyC), Integer.valueOf(bal2.wEh), bal2.wEi, Integer.valueOf(c.this.byB()), Integer.valueOf(c.this.byC())});
                                                                            ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", bal2.ssid, bal2.bssid, Integer.valueOf(bal2.cyC), Integer.valueOf(bal2.wEh), bal2.wEi, Integer.valueOf(c.this.byB()), Integer.valueOf(c.this.byC()));
                                                                            if (bal2.wEh == 1 && i2 == 1) {
                                                                                a.mve.e(bal2.ssid, bal2.bssid, bal2.cuH, bal2.mue);
                                                                                ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cached : ssid=%s, bssid=%s, apKey=%s, protocolType=%d. ", bal2.ssid, bal2.bssid, bal2.cuH, Integer.valueOf(bal2.mue));
                                                                            }
                                                                        } else {
                                                                            matrixCursor2.addRow(new Object[]{bal2.ssid, bal2.bssid, Integer.valueOf(bal2.cyC), Integer.valueOf(0), null, Integer.valueOf(c.this.byB()), Integer.valueOf(c.this.byC())});
                                                                            ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", bal2.ssid, bal2.bssid, Integer.valueOf(bal2.cyC), Integer.valueOf(0), null, Integer.valueOf(c.this.byB()), Integer.valueOf(c.this.byC()));
                                                                        }
                                                                    }
                                                                    c.a(fhVar, matrixCursor2);
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                    matrixCursor = matrixCursor2;
                                                                    if (matrixCursor != null) {
                                                                        matrixCursor.close();
                                                                    }
                                                                    ab.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", e);
                                                                    c.a(c.this, fhVar, FaceManager.FACE_ACQUIRED_NO_FACE, "cursor exception.");
                                                                    AppMethodBeat.o(20673);
                                                                }
                                                            } catch (Exception e3) {
                                                                e = e3;
                                                                if (matrixCursor != null) {
                                                                }
                                                                ab.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", e);
                                                                c.a(c.this, fhVar, FaceManager.FACE_ACQUIRED_NO_FACE, "cursor exception.");
                                                                AppMethodBeat.o(20673);
                                                            }
                                                        } else if (i2 == -30035) {
                                                            c.a(c.this, fhVar, FaceManager.FACE_ACQUIRED_DARK, "Too many ap. The number of ap requested per time should be between 1 and " + c.this.byB() + ".");
                                                            AppMethodBeat.o(20673);
                                                        } else {
                                                            c.a(c.this, fhVar, FaceManager.FACE_ACQUIRED_MULTI_FACE, "Server returns errtype= " + i + ", errcode=" + i2 + ", errMsg=" + m.Mw(str) + ".");
                                                            AppMethodBeat.o(20673);
                                                        }
                                                    } finally {
                                                        while (true) {
                                                        }
                                                        AppMethodBeat.o(20673);
                                                    }
                                                }
                                            }
                                        });
                                        AppMethodBeat.o(20676);
                                    }
                                } catch (Exception e) {
                                    a(fhVar, 1105, "Args[1] is not a valid json array value and it should be a string like  [  {    \"ssid\": \"SSID_NAME\",    \"bssid\": \"0e:00:00:00:00:00\",    \"rssi\": -45  }].");
                                    AppMethodBeat.o(20676);
                                }
                            }
                        } catch (Exception e2) {
                            a(fhVar, 1107, "Args[2] is not a valid int value.");
                            AppMethodBeat.o(20676);
                        }
                    }
                } catch (Exception e3) {
                    a(fhVar, 1102, "Args[0] is not an integer.");
                    AppMethodBeat.o(20676);
                }
            }
        }
        return;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(fh fhVar, int i, String str) {
        Exception e;
        AppMethodBeat.i(20677);
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setErrorResult. errorcode=%d, errmsg=%s", Integer.valueOf(i), str);
        MatrixCursor matrixCursor;
        try {
            matrixCursor = new MatrixCursor(mvk);
            try {
                matrixCursor.addRow(new Object[]{Integer.valueOf(i), str, Integer.valueOf(byB()), Integer.valueOf(byC())});
                fhVar.cyX.cyZ = matrixCursor;
                fhVar.cyX.cyD = 1;
                if (fhVar.callback != null) {
                    fhVar.callback.run();
                }
                AppMethodBeat.o(20677);
            } catch (Exception e2) {
                e = e2;
                if (matrixCursor != null) {
                }
                ab.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", e);
                fhVar.cyX.cyZ = null;
                fhVar.cyX.cyD = 1;
                if (fhVar.callback != null) {
                }
                AppMethodBeat.o(20677);
            }
        } catch (Exception e3) {
            e = e3;
            matrixCursor = null;
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            ab.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", e);
            fhVar.cyX.cyZ = null;
            fhVar.cyX.cyD = 1;
            if (fhVar.callback != null) {
                fhVar.callback.run();
            }
            AppMethodBeat.o(20677);
        }
    }

    public final synchronized int byB() {
        int i;
        AppMethodBeat.i(20678);
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "getReqMaxApCount() returns " + this.mvl);
        i = this.mvl;
        AppMethodBeat.o(20678);
        return i;
    }

    public final synchronized void vP(int i) {
        AppMethodBeat.i(20679);
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() param reqMaxApCount = ".concat(String.valueOf(i)));
        this.mvl = i;
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() this.reqMaxApCount = " + this.mvl);
        AppMethodBeat.o(20679);
    }

    public final synchronized int byC() {
        return this.mvm;
    }

    public final synchronized void vQ(int i) {
        this.mvm = i;
    }

    private synchronized long byD() {
        return this.mvn;
    }

    public final synchronized void iM(long j) {
        this.mvn = j;
    }

    static /* synthetic */ void a(fh fhVar, MatrixCursor matrixCursor) {
        AppMethodBeat.i(20680);
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setResult. errorcode=%d, errmsg=%s", Integer.valueOf(1), null);
        fhVar.cyX.cyZ = matrixCursor;
        fhVar.cyX.cyD = 1;
        if (fhVar.callback != null) {
            fhVar.callback.run();
        }
        AppMethodBeat.o(20680);
    }
}
