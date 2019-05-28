package com.tencent.p177mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.C6276a;
import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.plugin.appbrand.config.C42409s;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.d */
public class C27164d implements Runnable {
    protected volatile String appId;
    protected final int gVu;
    protected final int har;
    protected final String hgC;
    private final C27163a ifN;
    protected AppBrandStatObject ifO;
    protected final ActivityStarterIpcDelegate ifP;
    protected final String username;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.d$a */
    public interface C27163a<T extends AppBrandInitConfigLU> {
        /* renamed from: a */
        void mo44834a(T t, AppBrandStatObject appBrandStatObject, int i);
    }

    public C27164d(LaunchParcel launchParcel, C27163a c27163a) {
        this.ifN = c27163a;
        this.har = launchParcel.har;
        this.appId = launchParcel.appId;
        this.username = launchParcel.username;
        this.gVu = launchParcel.version;
        this.ifO = launchParcel.ijy;
        this.hgC = launchParcel.hgC;
        this.ifP = launchParcel.ifP;
    }

    public final void aHb() {
        AppMethodBeat.m2504i(138194);
        C7305d.xDG.mo10151b(this, String.format(Locale.US, "Luggage.AppBrandPreLaunchProcess|appId[%s]", new Object[]{this.appId}));
        AppMethodBeat.m2505o(138194);
    }

    public void run() {
        AppMethodBeat.m2504i(102096);
        WxaAttributes wxaAttributes = (WxaAttributes) aHc().first;
        if (wxaAttributes == null) {
            C4990ab.m7416i("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
            onError();
            AppMethodBeat.m2505o(102096);
        } else if (mo44838e(wxaAttributes)) {
            onError();
            AppMethodBeat.m2505o(102096);
        } else {
            AppBrandInitConfigLU a = C6276a.m10270xw().mo14505a(wxaAttributes);
            a.gVs = this.har;
            this.appId = a.appId;
            if (this.har == 0) {
                a.hfh = wxaAttributes.ayL().hij;
                a.bQk = wxaAttributes.ayL().bQk;
            } else {
                a.extInfo = ((C42611l) ((C0997b) C37384e.m62985B(C0997b.class)).mo3973E(C42611l.class)).mo68052bn(this.appId, this.har);
                try {
                    JSONObject lw = C41725h.m73457lw(a.extInfo);
                    a.hfh = lw.optString("device_orientation");
                    a.bQk = lw.optString("client_js_ext_info");
                    a.bQf = lw.optBoolean("open_remote", false);
                } catch (Exception e) {
                }
            }
            a.bQg = C27164d.m43171Cf(a.bQk);
            if (this.ifO == null) {
                this.ifO = new AppBrandStatObject();
            }
            mo44835a(a, this.ifO);
            AppMethodBeat.m2505o(102096);
        }
    }

    /* Access modifiers changed, original: protected */
    public Pair<WxaAttributes, Boolean> aHc() {
        AppMethodBeat.m2504i(102097);
        C42409s.ayO();
        String[] strArr = new String[0];
        Pair pair = new Pair(C42409s.m75085zB(this.appId), Boolean.FALSE);
        AppMethodBeat.m2505o(102097);
        return pair;
    }

    /* renamed from: Cf */
    protected static boolean m43171Cf(String str) {
        AppMethodBeat.m2504i(102098);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(102098);
            return false;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("call_plugin_info");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                AppMethodBeat.m2505o(102098);
                return false;
            }
            AppMethodBeat.m2505o(102098);
            return true;
        } catch (Exception e) {
            AppMethodBeat.m2505o(102098);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: e */
    public boolean mo44838e(WxaAttributes wxaAttributes) {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onError() {
        AppMethodBeat.m2504i(102099);
        if (this.ifN != null) {
            this.ifN.mo44834a(null, null, 2);
        }
        AppMethodBeat.m2505o(102099);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo44835a(AppBrandInitConfigLU appBrandInitConfigLU, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(102100);
        if (this.ifN != null) {
            this.ifN.mo44834a(appBrandInitConfigLU, appBrandStatObject, 1);
        }
        AppMethodBeat.m2505o(102100);
    }
}
