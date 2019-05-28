package com.tencent.mm.plugin.exdevice.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.du;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class ExdeviceWCLanSDKUtil {
    BroadcastReceiver jIA;
    HashMap<String, byte[]> lsL;
    HashMap<String, Boolean> lsN;
    a lsO;
    a lsQ;
    private int lte;
    private int ltf;
    a ltg;
    a lth;
    HashMap<String, String> lti;
    boolean ltj;
    boolean ltk;
    boolean ltl;
    int ltm;
    Context mContext;

    public class LanStateChangeReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(19289);
            if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra != null) {
                    boolean z = ((NetworkInfo) parcelableExtra).getState() == State.CONNECTED;
                    ab.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "isConnected =".concat(String.valueOf(z)));
                    if (ExdeviceWCLanSDKUtil.this.ltk || ExdeviceWCLanSDKUtil.this.ltj != z) {
                        dx dxVar = new dx();
                        dxVar.cxw.cxx = z;
                        com.tencent.mm.sdk.b.a.xxA.m(dxVar);
                        ExdeviceWCLanSDKUtil.this.ltk = false;
                        ExdeviceWCLanSDKUtil.this.ltj = z;
                    }
                }
            }
            AppMethodBeat.o(19289);
        }
    }

    public ExdeviceWCLanSDKUtil() {
        AppMethodBeat.i(19290);
        this.lte = 0;
        this.ltf = 0;
        this.lsL = new HashMap();
        this.lsN = new HashMap();
        this.lti = new HashMap();
        this.mContext = null;
        this.ltj = false;
        this.ltk = false;
        this.ltl = false;
        this.ltj = true;
        this.ltk = true;
        this.lsL.clear();
        this.lsN.clear();
        this.lti.clear();
        this.mContext = ah.getContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        if (this.jIA == null) {
            this.jIA = new LanStateChangeReceiver();
        }
        this.mContext.registerReceiver(this.jIA, intentFilter);
        this.ltg = new a() {
            public final void g(int i, Object... objArr) {
                String string;
                Throwable e;
                AppMethodBeat.i(19284);
                if (i != 10 || objArr == null) {
                    AppMethodBeat.o(19284);
                    return;
                }
                String string2;
                try {
                    JSONObject jSONObject = new JSONObject(new String((byte[]) objArr[0]));
                    JSONObject jSONObject2 = jSONObject.getJSONObject("deviceInfo");
                    string = jSONObject2.getString("deviceType");
                    try {
                        string2 = jSONObject2.getString("deviceId");
                    } catch (Exception e2) {
                        e = e2;
                        string2 = null;
                    }
                    try {
                        if (!jSONObject.isNull("manufacturerData")) {
                            ExdeviceWCLanSDKUtil.this.lti.put(string2, jSONObject.getString("manufacturerData"));
                        }
                        dw dwVar = new dw();
                        dwVar.cxu.ceI = string2;
                        if (ExdeviceWCLanSDKUtil.this.lti.containsKey(string2)) {
                            String str = (String) ExdeviceWCLanSDKUtil.this.lti.get(string2);
                            if (!bo.isNullOrNil(str)) {
                                dwVar.cxu.cxv = str.getBytes();
                            }
                            ExdeviceWCLanSDKUtil.this.lti.remove(string2);
                        }
                        dwVar.cxu.bcU = false;
                        com.tencent.mm.sdk.b.a.xxA.m(dwVar);
                    } catch (Exception e3) {
                        e = e3;
                        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                        ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "json decode failed in disc package callback!");
                        if (string != null) {
                        }
                        ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
                        AppMethodBeat.o(19284);
                        return;
                    }
                } catch (Exception e4) {
                    e = e4;
                    string2 = null;
                    string = null;
                }
                if (string != null || string2 == null) {
                    ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
                    AppMethodBeat.o(19284);
                    return;
                }
                AppMethodBeat.o(19284);
            }
        };
        this.lsO = new a() {
            public final void g(int i, Object... objArr) {
                String string;
                Exception e;
                String str = null;
                AppMethodBeat.i(19285);
                if (i != 14 || objArr == null || objArr.length <= 0 || !(objArr[0] instanceof byte[])) {
                    AppMethodBeat.o(19285);
                    return;
                }
                JSONObject jSONObject;
                try {
                    jSONObject = new JSONObject(new String((byte[]) objArr[0])).getJSONObject("deviceInfo");
                    try {
                        string = jSONObject.getString("deviceType");
                        try {
                            str = jSONObject.getString("deviceId");
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        string = str;
                    }
                } catch (Exception e4) {
                    e = e4;
                    jSONObject = str;
                    string = str;
                }
                if (string != null || str == null) {
                    ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                    AppMethodBeat.o(19285);
                }
                ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get device deviceType =" + string + ",deviceId = " + str);
                if (ad.boW().Kv(str) == null) {
                    ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "hdInfo null, %s", str);
                    AppMethodBeat.o(19285);
                    return;
                }
                ExdeviceWCLanSDKUtil.this.lsL.put(str, jSONObject.toString().getBytes());
                dw dwVar = new dw();
                dwVar.cxu.ceI = str;
                if (ExdeviceWCLanSDKUtil.this.lti.containsKey(str)) {
                    String str2 = (String) ExdeviceWCLanSDKUtil.this.lti.get(str);
                    if (!bo.isNullOrNil(str2)) {
                        dwVar.cxu.cxv = str2.getBytes();
                    }
                    ExdeviceWCLanSDKUtil.this.lti.remove(str);
                }
                dwVar.cxu.bcU = false;
                com.tencent.mm.sdk.b.a.xxA.m(dwVar);
                AppMethodBeat.o(19285);
                return;
                ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in get device profile callback %s", e);
                if (string != null) {
                }
                ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                AppMethodBeat.o(19285);
            }
        };
        this.lsQ = new a() {
            /* JADX WARNING: Removed duplicated region for block: B:16:0x0049  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x00a5  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void g(int i, Object... objArr) {
                int intValue;
                Throwable e;
                String str = null;
                AppMethodBeat.i(19286);
                if (i == 13 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof Integer)) {
                    Object string;
                    String str2 = (String) objArr[0];
                    intValue = ((Integer) objArr[1]).intValue();
                    try {
                        JSONObject jSONObject = new JSONObject(new String(str2));
                        string = jSONObject.getString("deviceId");
                        try {
                            str = jSONObject.getString("deviceType");
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        string = str;
                    }
                    switch (intValue) {
                        case 1:
                            ExdeviceWCLanSDKUtil.this.ltm = 2;
                            ExdeviceWCLanSDKUtil.this.lsN.put(string, Boolean.TRUE);
                            ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                            break;
                        default:
                            ExdeviceWCLanSDKUtil.this.ltm = 0;
                            ExdeviceWCLanSDKUtil.this.lsN.put(string, Boolean.FALSE);
                            ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                            break;
                    }
                    if (ExdeviceWCLanSDKUtil.this.ltl) {
                        if (ExdeviceWCLanSDKUtil.this.ltm == 2) {
                            ExdeviceWCLanSDKUtil.this.l(true, string);
                        }
                        du duVar = new du();
                        duVar.cxr.ceI = string;
                        duVar.cxr.cxs = ExdeviceWCLanSDKUtil.this.ltm;
                        duVar.cxr.cwz = str;
                        com.tencent.mm.sdk.b.a.xxA.m(duVar);
                    }
                    AppMethodBeat.o(19286);
                }
                AppMethodBeat.o(19286);
                return;
                ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in device ConnState notify callback");
                switch (intValue) {
                    case 1:
                        break;
                    default:
                        break;
                }
                if (ExdeviceWCLanSDKUtil.this.ltl) {
                }
                AppMethodBeat.o(19286);
            }
        };
        this.lth = new a() {
            public final void g(int i, Object... objArr) {
                byte[] bArr;
                String string;
                String string2;
                Throwable e;
                dv dvVar;
                AppMethodBeat.i(19287);
                if (i == 16 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof byte[])) {
                    bArr = (byte[]) objArr[1];
                    try {
                        JSONObject jSONObject = new JSONObject(new String((String) objArr[0]));
                        string = jSONObject.getString("deviceType");
                        try {
                            string2 = jSONObject.getString("deviceId");
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        string = null;
                    }
                    ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = ".concat(String.valueOf(new String(bArr))));
                    dvVar = new dv();
                    dvVar.cxt.ceI = string2;
                    dvVar.cxt.data = bArr;
                    dvVar.cxt.cwz = string;
                    com.tencent.mm.sdk.b.a.xxA.m(dvVar);
                    AppMethodBeat.o(19287);
                }
                AppMethodBeat.o(19287);
                return;
                ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in receive notify callback");
                string2 = null;
                ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = ".concat(String.valueOf(new String(bArr))));
                dvVar = new dv();
                dvVar.cxt.ceI = string2;
                dvVar.cxt.data = bArr;
                dvVar.cxt.cwz = string;
                com.tencent.mm.sdk.b.a.xxA.m(dvVar);
                AppMethodBeat.o(19287);
            }
        };
        AppMethodBeat.o(19290);
    }

    public final boolean l(boolean z, String str) {
        AppMethodBeat.i(19291);
        if (str == null || !this.lsL.containsKey(str)) {
            ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in openOrCloseDevice");
            AppMethodBeat.o(19291);
            return false;
        }
        byte[] bArr = (byte[]) this.lsL.get(str);
        try {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "open device!");
                jSONObject.put("cmd", "open");
            } else {
                ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "close device!");
                jSONObject.put("cmd", "close");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("wxmsg_jsapi", jSONObject);
            jSONObject = new JSONObject();
            jSONObject.put("services", jSONObject2);
            this.ltf = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject.toString().getBytes());
            if (this.ltf != 0) {
                ab.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get openOrCloseDevice mCallBackCmdId =" + this.ltf);
            } else {
                ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "openOrCloseDevice error!");
            }
            AppMethodBeat.o(19291);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
            ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in openOrCloseDevice");
            AppMethodBeat.o(19291);
            return false;
        }
    }

    public final boolean ax(String str, boolean z) {
        AppMethodBeat.i(19292);
        if (str == null || !this.lsL.containsKey(str)) {
            ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in connectWCLanDevice");
            AppMethodBeat.o(19292);
            return false;
        }
        byte[] bArr = (byte[]) this.lsL.get(str);
        this.ltl = true;
        if (z) {
            try {
                String string = new JSONObject(new String(bArr)).getString("deviceType");
                ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice deviceId: ".concat(String.valueOf(str)));
                if (Java2CExDevice.connectWCLanDevice(bArr, false) != 0) {
                    ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice error!");
                    AppMethodBeat.o(19292);
                    return false;
                }
                du duVar = new du();
                duVar.cxr.ceI = str;
                duVar.cxr.cxs = 1;
                duVar.cxr.cwz = string;
                com.tencent.mm.sdk.b.a.xxA.m(duVar);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in connectWCLanDevice!");
                AppMethodBeat.o(19292);
                return false;
            }
        }
        l(false, str);
        ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "disconnectWCLanDevice...");
        Java2CExDevice.disconnectWCLanDevice(bArr);
        AppMethodBeat.o(19292);
        return true;
    }

    public final boolean dR(String str, String str2) {
        AppMethodBeat.i(19293);
        if (!Ki(str)) {
            ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceId " + str + " not connected!");
            AppMethodBeat.o(19293);
            return false;
        } else if (str == null || !this.lsL.containsKey(str)) {
            ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in useWCLanDeviceService");
            AppMethodBeat.o(19293);
            return false;
        } else {
            byte[] bArr = (byte[]) this.lsL.get(str);
            this.lte = 0;
            try {
                boolean z;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", str2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("wxmsg_jsapi", jSONObject);
                jSONObject = new JSONObject();
                jSONObject.put("services", jSONObject2);
                this.lte = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject.toString().getBytes());
                if (this.lte != 0) {
                    z = true;
                    ab.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get useWCLanDeviceService mCallBackCmdId =" + this.lte);
                } else {
                    ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "useWCLanDeviceService error!");
                    z = false;
                }
                AppMethodBeat.o(19293);
                return z;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in useWCLanDeviceService");
                AppMethodBeat.o(19293);
                return false;
            }
        }
    }

    public final boolean Ki(String str) {
        AppMethodBeat.i(19294);
        if (str == null || !this.lsN.containsKey(str)) {
            AppMethodBeat.o(19294);
            return false;
        }
        boolean booleanValue = ((Boolean) this.lsN.get(str)).booleanValue();
        AppMethodBeat.o(19294);
        return booleanValue;
    }
}
