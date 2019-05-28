package com.tencent.p177mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C27279r.C27280a;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.config.C38163a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.p297h.C17090c;
import com.tencent.p177mm.plugin.appbrand.p297h.C26901k;
import com.tencent.p177mm.plugin.appbrand.p297h.C38236o;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.page.C19639h;
import com.tencent.p177mm.plugin.appbrand.page.C19640n;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.page.C45664i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.q */
public class C38492q extends C2119d {
    private volatile boolean eMP = false;
    public volatile boolean gPH = false;
    private volatile C6750i gPI;
    public C42701w gPJ;
    protected LinkedList<C33512a> gPK = new LinkedList();
    private volatile boolean mDestroyed = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.q$a */
    static class C33512a {
        String ctq;
        String data;
        int src;

        C33512a(String str, String str2, int i) {
            this.ctq = str;
            this.data = str2;
            this.src = i;
        }
    }

    public C38492q() {
        AppMethodBeat.m2504i(86747);
        AppMethodBeat.m2505o(86747);
    }

    /* renamed from: Dw */
    public final void mo61195Dw() {
        AppMethodBeat.m2504i(86748);
        aCd();
        atX();
        C4990ab.m7410d("MicroMsg.AppBrandService", "preInjectConfig");
        JSONObject aue = aue();
        aBx().evaluateJavascript(String.format("var __wxConfig = %s;", new Object[]{aue.toString()}), null);
        this.gPH = true;
        atV();
        if (aBx().mo14970af(C38236o.class) != null) {
            ((C38236o) aBx().mo14970af(C38236o.class)).setJsRuntimeTitle("https://servicewechat.com/preload/js-engine");
        }
        AppMethodBeat.m2505o(86748);
    }

    public final boolean atU() {
        AppMethodBeat.m2504i(86749);
        if (getRuntime() != null || this.mDestroyed) {
            AppMethodBeat.m2505o(86749);
            return false;
        }
        AppMethodBeat.m2505o(86749);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void atV() {
    }

    /* renamed from: m */
    public void mo34952m(C6750i c6750i) {
        AppMethodBeat.m2504i(86750);
        this.gPI = c6750i;
        C27280a.gPN.mo44964a(this);
        AppMethodBeat.m2505o(86750);
    }

    /* Access modifiers changed, original: protected */
    public void atW() {
        AppMethodBeat.m2504i(86751);
        if (isRunning()) {
            new C19639h().mo34864A(this.gPI);
            AppMethodBeat.m2505o(86751);
            return;
        }
        C4990ab.m7421w("MicroMsg.AppBrandService", "onRuntimePause but not running appId %s", getAppId());
        AppMethodBeat.m2505o(86751);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: dw */
    public void mo34948dw(boolean z) {
        AppMethodBeat.m2504i(86752);
        if (isRunning()) {
            new C45664i().mo73457a(this.gPI, z);
            AppMethodBeat.m2505o(86752);
            return;
        }
        C4990ab.m7421w("MicroMsg.AppBrandService", "onRuntimeResume but not running, appId %s, willRelaunch %b", getAppId(), Boolean.valueOf(z));
        AppMethodBeat.m2505o(86752);
    }

    private void atX() {
        AppMethodBeat.m2504i(86753);
        if (this.gPJ == null) {
            this.gPJ = atY();
        }
        AppMethodBeat.m2505o(86753);
    }

    /* Access modifiers changed, original: protected */
    public C42701w atY() {
        AppMethodBeat.m2504i(86754);
        C42701w c42701w = new C42701w(this);
        AppMethodBeat.m2505o(86754);
        return c42701w;
    }

    public final void init() {
        AppMethodBeat.m2504i(86755);
        super.init();
        atX();
        this.eMP = true;
        mo53812e(this.gPI.gNI);
        mo34953wO();
        if (aBx().mo14970af(C38236o.class) != null) {
            ((C38236o) aBx().mo14970af(C38236o.class)).setJsRuntimeTitle(String.format("https://servicewechat.com/%s/js-engine", new Object[]{getAppId()}));
        }
        AppMethodBeat.m2505o(86755);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: wO */
    public void mo34953wO() {
        AppMethodBeat.m2504i(86756);
        aud();
        atZ();
        AppMethodBeat.m2505o(86756);
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void atZ() {
        AppMethodBeat.m2504i(86757);
        Iterator it = this.gPK.iterator();
        while (it.hasNext()) {
            C33512a c33512a = (C33512a) it.next();
            super.mo51255h(c33512a.ctq, c33512a.data, c33512a.src);
        }
        this.gPK = null;
        AppMethodBeat.m2505o(86757);
    }

    /* Access modifiers changed, original: protected|final */
    @Deprecated
    /* renamed from: bo */
    public final void mo61200bo(String str, String str2) {
        AppMethodBeat.m2504i(86758);
        super.mo51255h(str, str2, 0);
        AppMethodBeat.m2505o(86758);
    }

    /* renamed from: h */
    public void mo51255h(String str, String str2, int i) {
        AppMethodBeat.m2504i(86759);
        synchronized (this) {
            try {
                if (this.gPK != null) {
                    this.gPK.add(new C33512a(str, str2, i));
                } else {
                    super.mo51255h(str, str2, i);
                    AppMethodBeat.m2505o(86759);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86759);
            }
        }
    }

    /* renamed from: a */
    public final void mo6109a(String str, String str2, int[] iArr) {
        AppMethodBeat.m2504i(86760);
        if (isRunning()) {
            this.gPI.asV().mo21672c(str, str2, iArr);
            AppMethodBeat.m2505o(86760);
            return;
        }
        AppMethodBeat.m2505o(86760);
    }

    public final boolean isRunning() {
        AppMethodBeat.m2504i(86761);
        if (this.eMP && super.isRunning()) {
            AppMethodBeat.m2505o(86761);
            return true;
        }
        AppMethodBeat.m2505o(86761);
        return false;
    }

    public C44709u getCurrentPageView() {
        AppMethodBeat.m2504i(86762);
        C44709u ac = mo61196ac(C44709u.class);
        AppMethodBeat.m2505o(86762);
        return ac;
    }

    /* renamed from: ac */
    public final <T extends C44709u> T mo61196ac(Class<T> cls) {
        AppMethodBeat.m2504i(86763);
        if (this.gPI == null) {
            AppMethodBeat.m2505o(86763);
            return null;
        }
        C19640n currentPage = this.gPI.asV().getCurrentPage();
        if (currentPage == null) {
            AppMethodBeat.m2505o(86763);
            return null;
        }
        T currentPageView = currentPage.getCurrentPageView();
        if (cls.isInstance(currentPageView)) {
            AppMethodBeat.m2505o(86763);
            return currentPageView;
        }
        AppMethodBeat.m2505o(86763);
        return null;
    }

    public final Context getContext() {
        AppMethodBeat.m2504i(86764);
        Context context;
        if (this.gPI == null) {
            context = C4996ah.getContext();
            AppMethodBeat.m2505o(86764);
            return context;
        }
        context = this.gPI.getContext();
        AppMethodBeat.m2505o(86764);
        return context;
    }

    /* renamed from: ad */
    public final <T extends Activity> T mo61197ad(Class<T> cls) {
        Object context;
        AppMethodBeat.m2504i(86765);
        if (getCurrentPageView() == null) {
            context = getContext();
        } else {
            context = getCurrentPageView().mContext;
        }
        if (cls.isInstance(context)) {
            Activity activity = (Activity) context;
            AppMethodBeat.m2505o(86765);
            return activity;
        }
        AppMethodBeat.m2505o(86765);
        return null;
    }

    public C6750i getRuntime() {
        return this.gPI;
    }

    public C6747i aua() {
        AppMethodBeat.m2504i(86766);
        C17090c c17090c = new C17090c();
        AppMethodBeat.m2505o(86766);
        return c17090c;
    }

    public Map<String, C45608m> aub() {
        AppMethodBeat.m2504i(86767);
        Map emptyMap = Collections.emptyMap();
        AppMethodBeat.m2505o(86767);
        return emptyMap;
    }

    public void cleanup() {
        AppMethodBeat.m2504i(86768);
        super.cleanup();
        this.gPI = null;
        this.eMP = false;
        this.mDestroyed = true;
        AppMethodBeat.m2505o(86768);
    }

    public final String auc() {
        return "AppBrandService";
    }

    /* Access modifiers changed, original: protected */
    public void aud() {
        AppMethodBeat.m2504i(86769);
        JSONObject xW = mo21959xW();
        String str = this.gPI.getAppConfig().hfg;
        aBx().evaluateJavascript(String.format(";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);var __wxIndexPage = \"%s\";", new Object[]{xW.toString(), str}), null);
        AppMethodBeat.m2505o(86769);
    }

    /* renamed from: xW */
    public JSONObject mo21959xW() {
        AppMethodBeat.m2504i(86770);
        JSONObject xW = super.mo21959xW();
        C16597h ye = this.gPI.mo15034ye();
        C38163a appConfig = this.gPI.getAppConfig();
        if (ye == null || appConfig == null) {
            JSONObject jSONObject = new JSONObject();
            AppMethodBeat.m2505o(86770);
            return jSONObject;
        }
        JSONObject jSONObject2 = appConfig.hff;
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                xW.putOpt(str, jSONObject2.opt(str));
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.AppBrandService", e.getMessage());
            }
        }
        mo21956b(xW, "env", new JSONObject());
        AppMethodBeat.m2505o(86770);
        return xW;
    }

    public final JSONObject aue() {
        AppMethodBeat.m2504i(86771);
        JSONObject aue = super.aue();
        AppMethodBeat.m2505o(86771);
        return aue;
    }

    /* renamed from: h */
    public void mo21957h(JSONObject jSONObject) {
        AppMethodBeat.m2504i(86772);
        super.mo21957h(jSONObject);
        if (aBx() != null) {
            mo21956b(jSONObject, "nativeBufferEnabled", Boolean.valueOf(aBx().mo14970af(C26901k.class) != null));
        }
        AppMethodBeat.m2505o(86772);
    }

    public String auf() {
        return "";
    }

    public String aug() {
        return "";
    }

    /* renamed from: xc */
    public String mo61201xc(String str) {
        return "";
    }
}
