package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.customize.b;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class d implements Runnable {
    protected volatile String appId;
    protected final int gVu;
    protected final int har;
    protected final String hgC;
    private final a ifN;
    protected AppBrandStatObject ifO;
    protected final ActivityStarterIpcDelegate ifP;
    protected final String username;

    public interface a<T extends AppBrandInitConfigLU> {
        void a(T t, AppBrandStatObject appBrandStatObject, int i);
    }

    public d(LaunchParcel launchParcel, a aVar) {
        this.ifN = aVar;
        this.har = launchParcel.har;
        this.appId = launchParcel.appId;
        this.username = launchParcel.username;
        this.gVu = launchParcel.version;
        this.ifO = launchParcel.ijy;
        this.hgC = launchParcel.hgC;
        this.ifP = launchParcel.ifP;
    }

    public final void aHb() {
        AppMethodBeat.i(138194);
        com.tencent.mm.sdk.g.d.xDG.b(this, String.format(Locale.US, "Luggage.AppBrandPreLaunchProcess|appId[%s]", new Object[]{this.appId}));
        AppMethodBeat.o(138194);
    }

    public void run() {
        AppMethodBeat.i(102096);
        WxaAttributes wxaAttributes = (WxaAttributes) aHc().first;
        if (wxaAttributes == null) {
            ab.i("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
            onError();
            AppMethodBeat.o(102096);
        } else if (e(wxaAttributes)) {
            onError();
            AppMethodBeat.o(102096);
        } else {
            AppBrandInitConfigLU a = com.tencent.luggage.sdk.config.a.xw().a(wxaAttributes);
            a.gVs = this.har;
            this.appId = a.appId;
            if (this.har == 0) {
                a.hfh = wxaAttributes.ayL().hij;
                a.bQk = wxaAttributes.ayL().bQk;
            } else {
                a.extInfo = ((l) ((b) e.B(b.class)).E(l.class)).bn(this.appId, this.har);
                try {
                    JSONObject lw = h.lw(a.extInfo);
                    a.hfh = lw.optString("device_orientation");
                    a.bQk = lw.optString("client_js_ext_info");
                    a.bQf = lw.optBoolean("open_remote", false);
                } catch (Exception e) {
                }
            }
            a.bQg = Cf(a.bQk);
            if (this.ifO == null) {
                this.ifO = new AppBrandStatObject();
            }
            a(a, this.ifO);
            AppMethodBeat.o(102096);
        }
    }

    /* Access modifiers changed, original: protected */
    public Pair<WxaAttributes, Boolean> aHc() {
        AppMethodBeat.i(102097);
        s.ayO();
        String[] strArr = new String[0];
        Pair pair = new Pair(s.zB(this.appId), Boolean.FALSE);
        AppMethodBeat.o(102097);
        return pair;
    }

    protected static boolean Cf(String str) {
        AppMethodBeat.i(102098);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(102098);
            return false;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("call_plugin_info");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                AppMethodBeat.o(102098);
                return false;
            }
            AppMethodBeat.o(102098);
            return true;
        } catch (Exception e) {
            AppMethodBeat.o(102098);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean e(WxaAttributes wxaAttributes) {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onError() {
        AppMethodBeat.i(102099);
        if (this.ifN != null) {
            this.ifN.a(null, null, 2);
        }
        AppMethodBeat.o(102099);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(AppBrandInitConfigLU appBrandInitConfigLU, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(102100);
        if (this.ifN != null) {
            this.ifN.a(appBrandInitConfigLU, appBrandStatObject, 1);
        }
        AppMethodBeat.o(102100);
    }
}
