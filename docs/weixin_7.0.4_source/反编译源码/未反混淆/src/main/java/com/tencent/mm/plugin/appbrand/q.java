package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.k;
import com.tencent.mm.plugin.appbrand.h.o;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.page.i;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public class q extends d {
    private volatile boolean eMP = false;
    public volatile boolean gPH = false;
    private volatile i gPI;
    public w gPJ;
    protected LinkedList<a> gPK = new LinkedList();
    private volatile boolean mDestroyed = false;

    static class a {
        String ctq;
        String data;
        int src;

        a(String str, String str2, int i) {
            this.ctq = str;
            this.data = str2;
            this.src = i;
        }
    }

    public q() {
        AppMethodBeat.i(86747);
        AppMethodBeat.o(86747);
    }

    public final void Dw() {
        AppMethodBeat.i(86748);
        aCd();
        atX();
        ab.d("MicroMsg.AppBrandService", "preInjectConfig");
        JSONObject aue = aue();
        aBx().evaluateJavascript(String.format("var __wxConfig = %s;", new Object[]{aue.toString()}), null);
        this.gPH = true;
        atV();
        if (aBx().af(o.class) != null) {
            ((o) aBx().af(o.class)).setJsRuntimeTitle("https://servicewechat.com/preload/js-engine");
        }
        AppMethodBeat.o(86748);
    }

    public final boolean atU() {
        AppMethodBeat.i(86749);
        if (getRuntime() != null || this.mDestroyed) {
            AppMethodBeat.o(86749);
            return false;
        }
        AppMethodBeat.o(86749);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void atV() {
    }

    public void m(i iVar) {
        AppMethodBeat.i(86750);
        this.gPI = iVar;
        com.tencent.mm.plugin.appbrand.r.a.gPN.a(this);
        AppMethodBeat.o(86750);
    }

    /* Access modifiers changed, original: protected */
    public void atW() {
        AppMethodBeat.i(86751);
        if (isRunning()) {
            new h().A(this.gPI);
            AppMethodBeat.o(86751);
            return;
        }
        ab.w("MicroMsg.AppBrandService", "onRuntimePause but not running appId %s", getAppId());
        AppMethodBeat.o(86751);
    }

    /* Access modifiers changed, original: protected */
    public void dw(boolean z) {
        AppMethodBeat.i(86752);
        if (isRunning()) {
            new i().a(this.gPI, z);
            AppMethodBeat.o(86752);
            return;
        }
        ab.w("MicroMsg.AppBrandService", "onRuntimeResume but not running, appId %s, willRelaunch %b", getAppId(), Boolean.valueOf(z));
        AppMethodBeat.o(86752);
    }

    private void atX() {
        AppMethodBeat.i(86753);
        if (this.gPJ == null) {
            this.gPJ = atY();
        }
        AppMethodBeat.o(86753);
    }

    /* Access modifiers changed, original: protected */
    public w atY() {
        AppMethodBeat.i(86754);
        w wVar = new w(this);
        AppMethodBeat.o(86754);
        return wVar;
    }

    public final void init() {
        AppMethodBeat.i(86755);
        super.init();
        atX();
        this.eMP = true;
        e(this.gPI.gNI);
        wO();
        if (aBx().af(o.class) != null) {
            ((o) aBx().af(o.class)).setJsRuntimeTitle(String.format("https://servicewechat.com/%s/js-engine", new Object[]{getAppId()}));
        }
        AppMethodBeat.o(86755);
    }

    /* Access modifiers changed, original: protected */
    public void wO() {
        AppMethodBeat.i(86756);
        aud();
        atZ();
        AppMethodBeat.o(86756);
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void atZ() {
        AppMethodBeat.i(86757);
        Iterator it = this.gPK.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            super.h(aVar.ctq, aVar.data, aVar.src);
        }
        this.gPK = null;
        AppMethodBeat.o(86757);
    }

    /* Access modifiers changed, original: protected|final */
    @Deprecated
    public final void bo(String str, String str2) {
        AppMethodBeat.i(86758);
        super.h(str, str2, 0);
        AppMethodBeat.o(86758);
    }

    public void h(String str, String str2, int i) {
        AppMethodBeat.i(86759);
        synchronized (this) {
            try {
                if (this.gPK != null) {
                    this.gPK.add(new a(str, str2, i));
                } else {
                    super.h(str, str2, i);
                    AppMethodBeat.o(86759);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86759);
            }
        }
    }

    public final void a(String str, String str2, int[] iArr) {
        AppMethodBeat.i(86760);
        if (isRunning()) {
            this.gPI.asV().c(str, str2, iArr);
            AppMethodBeat.o(86760);
            return;
        }
        AppMethodBeat.o(86760);
    }

    public final boolean isRunning() {
        AppMethodBeat.i(86761);
        if (this.eMP && super.isRunning()) {
            AppMethodBeat.o(86761);
            return true;
        }
        AppMethodBeat.o(86761);
        return false;
    }

    public u getCurrentPageView() {
        AppMethodBeat.i(86762);
        u ac = ac(u.class);
        AppMethodBeat.o(86762);
        return ac;
    }

    public final <T extends u> T ac(Class<T> cls) {
        AppMethodBeat.i(86763);
        if (this.gPI == null) {
            AppMethodBeat.o(86763);
            return null;
        }
        n currentPage = this.gPI.asV().getCurrentPage();
        if (currentPage == null) {
            AppMethodBeat.o(86763);
            return null;
        }
        T currentPageView = currentPage.getCurrentPageView();
        if (cls.isInstance(currentPageView)) {
            AppMethodBeat.o(86763);
            return currentPageView;
        }
        AppMethodBeat.o(86763);
        return null;
    }

    public final Context getContext() {
        AppMethodBeat.i(86764);
        Context context;
        if (this.gPI == null) {
            context = ah.getContext();
            AppMethodBeat.o(86764);
            return context;
        }
        context = this.gPI.getContext();
        AppMethodBeat.o(86764);
        return context;
    }

    public final <T extends Activity> T ad(Class<T> cls) {
        Object context;
        AppMethodBeat.i(86765);
        if (getCurrentPageView() == null) {
            context = getContext();
        } else {
            context = getCurrentPageView().mContext;
        }
        if (cls.isInstance(context)) {
            Activity activity = (Activity) context;
            AppMethodBeat.o(86765);
            return activity;
        }
        AppMethodBeat.o(86765);
        return null;
    }

    public i getRuntime() {
        return this.gPI;
    }

    public com.tencent.mm.plugin.appbrand.h.i aua() {
        AppMethodBeat.i(86766);
        c cVar = new c();
        AppMethodBeat.o(86766);
        return cVar;
    }

    public Map<String, m> aub() {
        AppMethodBeat.i(86767);
        Map emptyMap = Collections.emptyMap();
        AppMethodBeat.o(86767);
        return emptyMap;
    }

    public void cleanup() {
        AppMethodBeat.i(86768);
        super.cleanup();
        this.gPI = null;
        this.eMP = false;
        this.mDestroyed = true;
        AppMethodBeat.o(86768);
    }

    public final String auc() {
        return "AppBrandService";
    }

    /* Access modifiers changed, original: protected */
    public void aud() {
        AppMethodBeat.i(86769);
        JSONObject xW = xW();
        String str = this.gPI.getAppConfig().hfg;
        aBx().evaluateJavascript(String.format(";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);var __wxIndexPage = \"%s\";", new Object[]{xW.toString(), str}), null);
        AppMethodBeat.o(86769);
    }

    public JSONObject xW() {
        AppMethodBeat.i(86770);
        JSONObject xW = super.xW();
        com.tencent.mm.plugin.appbrand.config.h ye = this.gPI.ye();
        com.tencent.mm.plugin.appbrand.config.a appConfig = this.gPI.getAppConfig();
        if (ye == null || appConfig == null) {
            JSONObject jSONObject = new JSONObject();
            AppMethodBeat.o(86770);
            return jSONObject;
        }
        JSONObject jSONObject2 = appConfig.hff;
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                xW.putOpt(str, jSONObject2.opt(str));
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrandService", e.getMessage());
            }
        }
        b(xW, "env", new JSONObject());
        AppMethodBeat.o(86770);
        return xW;
    }

    public final JSONObject aue() {
        AppMethodBeat.i(86771);
        JSONObject aue = super.aue();
        AppMethodBeat.o(86771);
        return aue;
    }

    public void h(JSONObject jSONObject) {
        AppMethodBeat.i(86772);
        super.h(jSONObject);
        if (aBx() != null) {
            b(jSONObject, "nativeBufferEnabled", Boolean.valueOf(aBx().af(k.class) != null));
        }
        AppMethodBeat.o(86772);
    }

    public String auf() {
        return "";
    }

    public String aug() {
        return "";
    }

    public String xc(String str) {
        return "";
    }
}
