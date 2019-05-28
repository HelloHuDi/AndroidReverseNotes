package com.tencent.p177mm.plugin.exdevice.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32537dv;
import com.tencent.p177mm.p230g.p231a.C32538dw;
import com.tencent.p177mm.p230g.p231a.C32539dx;
import com.tencent.p177mm.p230g.p231a.C37706du;
import com.tencent.p177mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.p177mm.plugin.exdevice.model.C38956j.C34038a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil */
public final class ExdeviceWCLanSDKUtil {
    BroadcastReceiver jIA;
    HashMap<String, byte[]> lsL;
    HashMap<String, Boolean> lsN;
    C34038a lsO;
    C34038a lsQ;
    private int lte;
    private int ltf;
    C34038a ltg;
    C34038a lth;
    HashMap<String, String> lti;
    boolean ltj;
    boolean ltk;
    boolean ltl;
    int ltm;
    Context mContext;

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil$1 */
    class C204751 implements C34038a {
        C204751() {
        }

        /* renamed from: g */
        public final void mo7189g(int i, Object... objArr) {
            String string;
            Throwable e;
            AppMethodBeat.m2504i(19284);
            if (i != 10 || objArr == null) {
                AppMethodBeat.m2505o(19284);
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
                    C32538dw c32538dw = new C32538dw();
                    c32538dw.cxu.ceI = string2;
                    if (ExdeviceWCLanSDKUtil.this.lti.containsKey(string2)) {
                        String str = (String) ExdeviceWCLanSDKUtil.this.lti.get(string2);
                        if (!C5046bo.isNullOrNil(str)) {
                            c32538dw.cxu.cxv = str.getBytes();
                        }
                        ExdeviceWCLanSDKUtil.this.lti.remove(string2);
                    }
                    c32538dw.cxu.bcU = false;
                    C4879a.xxA.mo10055m(c32538dw);
                } catch (Exception e3) {
                    e = e3;
                    C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "json decode failed in disc package callback!");
                    if (string != null) {
                    }
                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
                    AppMethodBeat.m2505o(19284);
                    return;
                }
            } catch (Exception e4) {
                e = e4;
                string2 = null;
                string = null;
            }
            if (string != null || string2 == null) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
                AppMethodBeat.m2505o(19284);
                return;
            }
            AppMethodBeat.m2505o(19284);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil$2 */
    class C204762 implements C34038a {
        C204762() {
        }

        /* renamed from: g */
        public final void mo7189g(int i, Object... objArr) {
            String string;
            Exception e;
            String str = null;
            AppMethodBeat.m2504i(19285);
            if (i != 14 || objArr == null || objArr.length <= 0 || !(objArr[0] instanceof byte[])) {
                AppMethodBeat.m2505o(19285);
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
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                AppMethodBeat.m2505o(19285);
            }
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get device deviceType =" + string + ",deviceId = " + str);
            if (C45891ad.boW().mo45701Kv(str) == null) {
                C4990ab.m7413e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "hdInfo null, %s", str);
                AppMethodBeat.m2505o(19285);
                return;
            }
            ExdeviceWCLanSDKUtil.this.lsL.put(str, jSONObject.toString().getBytes());
            C32538dw c32538dw = new C32538dw();
            c32538dw.cxu.ceI = str;
            if (ExdeviceWCLanSDKUtil.this.lti.containsKey(str)) {
                String str2 = (String) ExdeviceWCLanSDKUtil.this.lti.get(str);
                if (!C5046bo.isNullOrNil(str2)) {
                    c32538dw.cxu.cxv = str2.getBytes();
                }
                ExdeviceWCLanSDKUtil.this.lti.remove(str);
            }
            c32538dw.cxu.bcU = false;
            C4879a.xxA.mo10055m(c32538dw);
            AppMethodBeat.m2505o(19285);
            return;
            C4990ab.m7413e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in get device profile callback %s", e);
            if (string != null) {
            }
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
            AppMethodBeat.m2505o(19285);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil$5 */
    class C204775 implements Runnable {
        C204775() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19288);
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "releaseWCLanDeviceLib...");
            Java2CExDevice.releaseWCLanDeviceLib();
            AppMethodBeat.m2505o(19288);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil$3 */
    class C204783 implements C34038a {
        C204783() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: g */
        public final void mo7189g(int i, Object... objArr) {
            int intValue;
            Throwable e;
            String str = null;
            AppMethodBeat.m2504i(19286);
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
                        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                        break;
                    default:
                        ExdeviceWCLanSDKUtil.this.ltm = 0;
                        ExdeviceWCLanSDKUtil.this.lsN.put(string, Boolean.FALSE);
                        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                        break;
                }
                if (ExdeviceWCLanSDKUtil.this.ltl) {
                    if (ExdeviceWCLanSDKUtil.this.ltm == 2) {
                        ExdeviceWCLanSDKUtil.this.mo35794l(true, string);
                    }
                    C37706du c37706du = new C37706du();
                    c37706du.cxr.ceI = string;
                    c37706du.cxr.cxs = ExdeviceWCLanSDKUtil.this.ltm;
                    c37706du.cxr.cwz = str;
                    C4879a.xxA.mo10055m(c37706du);
                }
                AppMethodBeat.m2505o(19286);
            }
            AppMethodBeat.m2505o(19286);
            return;
            C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in device ConnState notify callback");
            switch (intValue) {
                case 1:
                    break;
                default:
                    break;
            }
            if (ExdeviceWCLanSDKUtil.this.ltl) {
            }
            AppMethodBeat.m2505o(19286);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil$4 */
    class C204794 implements C34038a {
        C204794() {
        }

        /* renamed from: g */
        public final void mo7189g(int i, Object... objArr) {
            byte[] bArr;
            String string;
            String string2;
            Throwable e;
            C32537dv c32537dv;
            AppMethodBeat.m2504i(19287);
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
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = ".concat(String.valueOf(new String(bArr))));
                c32537dv = new C32537dv();
                c32537dv.cxt.ceI = string2;
                c32537dv.cxt.data = bArr;
                c32537dv.cxt.cwz = string;
                C4879a.xxA.mo10055m(c32537dv);
                AppMethodBeat.m2505o(19287);
            }
            AppMethodBeat.m2505o(19287);
            return;
            C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in receive notify callback");
            string2 = null;
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = ".concat(String.valueOf(new String(bArr))));
            c32537dv = new C32537dv();
            c32537dv.cxt.ceI = string2;
            c32537dv.cxt.data = bArr;
            c32537dv.cxt.cwz = string;
            C4879a.xxA.mo10055m(c32537dv);
            AppMethodBeat.m2505o(19287);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil$LanStateChangeReceiver */
    public class LanStateChangeReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(19289);
            if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra != null) {
                    boolean z = ((NetworkInfo) parcelableExtra).getState() == State.CONNECTED;
                    C4990ab.m7410d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "isConnected =".concat(String.valueOf(z)));
                    if (ExdeviceWCLanSDKUtil.this.ltk || ExdeviceWCLanSDKUtil.this.ltj != z) {
                        C32539dx c32539dx = new C32539dx();
                        c32539dx.cxw.cxx = z;
                        C4879a.xxA.mo10055m(c32539dx);
                        ExdeviceWCLanSDKUtil.this.ltk = false;
                        ExdeviceWCLanSDKUtil.this.ltj = z;
                    }
                }
            }
            AppMethodBeat.m2505o(19289);
        }
    }

    public ExdeviceWCLanSDKUtil() {
        AppMethodBeat.m2504i(19290);
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
        this.mContext = C4996ah.getContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        if (this.jIA == null) {
            this.jIA = new LanStateChangeReceiver();
        }
        this.mContext.registerReceiver(this.jIA, intentFilter);
        this.ltg = new C204751();
        this.lsO = new C204762();
        this.lsQ = new C204783();
        this.lth = new C204794();
        AppMethodBeat.m2505o(19290);
    }

    /* renamed from: l */
    public final boolean mo35794l(boolean z, String str) {
        AppMethodBeat.m2504i(19291);
        if (str == null || !this.lsL.containsKey(str)) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in openOrCloseDevice");
            AppMethodBeat.m2505o(19291);
            return false;
        }
        byte[] bArr = (byte[]) this.lsL.get(str);
        try {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "open device!");
                jSONObject.put("cmd", "open");
            } else {
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "close device!");
                jSONObject.put("cmd", "close");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("wxmsg_jsapi", jSONObject);
            jSONObject = new JSONObject();
            jSONObject.put("services", jSONObject2);
            this.ltf = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject.toString().getBytes());
            if (this.ltf != 0) {
                C4990ab.m7410d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get openOrCloseDevice mCallBackCmdId =" + this.ltf);
            } else {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "openOrCloseDevice error!");
            }
            AppMethodBeat.m2505o(19291);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in openOrCloseDevice");
            AppMethodBeat.m2505o(19291);
            return false;
        }
    }

    /* renamed from: ax */
    public final boolean mo35792ax(String str, boolean z) {
        AppMethodBeat.m2504i(19292);
        if (str == null || !this.lsL.containsKey(str)) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in connectWCLanDevice");
            AppMethodBeat.m2505o(19292);
            return false;
        }
        byte[] bArr = (byte[]) this.lsL.get(str);
        this.ltl = true;
        if (z) {
            try {
                String string = new JSONObject(new String(bArr)).getString("deviceType");
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice deviceId: ".concat(String.valueOf(str)));
                if (Java2CExDevice.connectWCLanDevice(bArr, false) != 0) {
                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice error!");
                    AppMethodBeat.m2505o(19292);
                    return false;
                }
                C37706du c37706du = new C37706du();
                c37706du.cxr.ceI = str;
                c37706du.cxr.cxs = 1;
                c37706du.cxr.cwz = string;
                C4879a.xxA.mo10055m(c37706du);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in connectWCLanDevice!");
                AppMethodBeat.m2505o(19292);
                return false;
            }
        }
        mo35794l(false, str);
        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "disconnectWCLanDevice...");
        Java2CExDevice.disconnectWCLanDevice(bArr);
        AppMethodBeat.m2505o(19292);
        return true;
    }

    /* renamed from: dR */
    public final boolean mo35793dR(String str, String str2) {
        AppMethodBeat.m2504i(19293);
        if (!mo35791Ki(str)) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceId " + str + " not connected!");
            AppMethodBeat.m2505o(19293);
            return false;
        } else if (str == null || !this.lsL.containsKey(str)) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in useWCLanDeviceService");
            AppMethodBeat.m2505o(19293);
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
                    C4990ab.m7410d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get useWCLanDeviceService mCallBackCmdId =" + this.lte);
                } else {
                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "useWCLanDeviceService error!");
                    z = false;
                }
                AppMethodBeat.m2505o(19293);
                return z;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in useWCLanDeviceService");
                AppMethodBeat.m2505o(19293);
                return false;
            }
        }
    }

    /* renamed from: Ki */
    public final boolean mo35791Ki(String str) {
        AppMethodBeat.m2504i(19294);
        if (str == null || !this.lsN.containsKey(str)) {
            AppMethodBeat.m2505o(19294);
            return false;
        }
        boolean booleanValue = ((Boolean) this.lsN.get(str)).booleanValue();
        AppMethodBeat.m2505o(19294);
        return booleanValue;
    }
}
