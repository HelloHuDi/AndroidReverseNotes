package com.tencent.p177mm.plugin.appbrand.jsapi.nfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.C19456a;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce.p1471a.C33383c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.d */
public final class C33381d extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 352;
    public static final String NAME = "startHCE";
    private JSONObject bOf;
    private int bOs = -1;
    boolean eTM = false;
    Activity gNy = null;
    private Class<?> hSd = null;
    Class<?> hSe = null;
    private int hSf;
    private ResultReceiver hSg = new JsApiNFCStartHCE$5(this, C7306ak.fetchFreeHandler(Looper.getMainLooper()));
    C2241c hzz = null;
    final Object mLock = new Object();
    long mStartTime = -1;
    Timer mTimer;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.d$1 */
    class C194571 implements C19456a {
        C194571() {
        }

        /* renamed from: T */
        public final void mo34591T(int i, String str) {
            AppMethodBeat.m2504i(137872);
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(i));
            if (i == 0) {
                C33381d c33381d = C33381d.this;
                if (c33381d.hzz.getContext() instanceof Activity) {
                    c33381d.gNy = (Activity) c33381d.hzz.getContext();
                    Intent intent = new Intent(c33381d.gNy, c33381d.hSe);
                    intent.putExtra("HCE_Result_Receiver", new JsApiNFCStartHCE$2(c33381d, C7306ak.fetchFreeHandler(Looper.getMainLooper())));
                    c33381d.gNy.startActivity(intent);
                    AppMethodBeat.m2505o(137872);
                    return;
                }
                c33381d.mo53857AR(c33381d.mo73394j("fail: unknown error", null));
                AppMethodBeat.m2505o(137872);
                return;
            }
            C33383c.m54578G(C33381d.this.hzz.getAppId(), i, -1);
            C33381d.this.mo53857AR(C33381d.this.mo73394j("fail: ".concat(String.valueOf(str)), hashMap));
            AppMethodBeat.m2505o(137872);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.d$2 */
    class C194582 extends C33186c {
        C194582() {
        }

        public final void onDestroy() {
            AppMethodBeat.m2504i(137874);
            C4990ab.m7416i("MicroMsg.JsApiNFCStartHCE", "alvinluo AppBrandLifeCycle onDestroy");
            HCEEventLogic.m75351eo(true);
            AppMethodBeat.m2505o(137874);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.d$3 */
    class C270423 extends TimerTask {
        C270423() {
        }

        public final void run() {
            boolean z;
            AppMethodBeat.m2504i(137875);
            C33381d c33381d = C33381d.this;
            synchronized (c33381d.mLock) {
                try {
                    z = c33381d.eTM;
                    if (!z) {
                        c33381d.eTM = true;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(137875);
                }
            }
            if (z) {
                C4990ab.m7416i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
            } else if (HCEEventLogic.aEt()) {
                C4990ab.m7416i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
                AppMethodBeat.m2505o(137875);
            } else {
                C4990ab.m7417i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", Integer.valueOf(10));
                HCEEventLogic.m75351eo(true);
                if (c33381d.hzz != null) {
                    C33383c.m54578G(c33381d.hzz.getAppId(), 13007, -2);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(13007));
                c33381d.mo53857AR(c33381d.mo73394j("fail: start HCEService failed", hashMap));
                AppMethodBeat.m2505o(137875);
            }
        }
    }

    public C33381d(Class<?> cls, Class<?> cls2) {
        AppMethodBeat.m2504i(137877);
        this.hSd = cls;
        this.hSe = cls2;
        AppMethodBeat.m2505o(137877);
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(137878);
        C4990ab.m7417i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", jSONObject.toString());
        this.hzz = c2241c;
        this.bOs = i;
        this.bOf = jSONObject;
        synchronized (this.mLock) {
            try {
                this.eTM = false;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(137878);
                }
            }
        }
        if (this.hSd == null || this.hSe == null) {
            mo53857AR(mo73394j("fail: HostApduService or HCETransparentUI is nil", null));
            AppMethodBeat.m2505o(137878);
            return;
        }
        this.hSf = this.bOf.optInt("time_limit", 1500);
        mo34590a(new C194571());
        AppMethodBeat.m2505o(137878);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: AR */
    public final void mo53857AR(String str) {
        AppMethodBeat.m2504i(137879);
        C4990ab.m7417i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", str);
        if (this.hzz != null) {
            this.hzz.mo6107M(this.bOs, str);
        }
        AppMethodBeat.m2505o(137879);
    }

    /* Access modifiers changed, original: final */
    public final void onSuccess() {
        AppMethodBeat.m2504i(137880);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = this.bOf.getJSONArray("aid_list");
            C4990ab.m7417i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", this.bOf.toString(), jSONArray.toString(), Integer.valueOf(jSONArray.length()));
            for (int i = 0; i < r5; i++) {
                arrayList.add(jSONArray.get(i).toString());
            }
            C33183g.m54274a(this.hzz.getAppId(), new C194582());
            Intent intent = new Intent(this.gNy, this.hSd);
            intent.putExtra("HCE_Result_Receiver", this.hSg);
            intent.putExtra("key_appid", this.hzz.getAppId());
            intent.putExtra("key_time_limit", this.hSf);
            intent.putStringArrayListExtra("key_aid_list", arrayList);
            HCEEventLogic.m75351eo(false);
            this.gNy.startService(intent);
            this.mStartTime = System.currentTimeMillis();
            C270423 c270423 = new C270423();
            this.mTimer = new Timer();
            this.mTimer.schedule(c270423, 10000);
            AppMethodBeat.m2505o(137880);
        } catch (Exception e) {
            hashMap.put("errCode", Integer.valueOf(13003));
            mo53857AR(mo73394j("fail: aid_list invalid", hashMap));
            C33383c.m54578G(this.hzz.getAppId(), 13003, -1);
            AppMethodBeat.m2505o(137880);
        }
    }
}
