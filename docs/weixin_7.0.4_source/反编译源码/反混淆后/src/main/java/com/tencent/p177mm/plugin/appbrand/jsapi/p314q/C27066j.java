package com.tencent.p177mm.plugin.appbrand.jsapi.p314q;

import android.app.Activity;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.j */
public final class C27066j extends C10296a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setKeepScreenOn";
    private static boolean hXH = false;
    private C2241c hxS;
    WakeLock wakeLock;

    /* renamed from: a */
    static /* synthetic */ boolean m43011a(C27066j c27066j) {
        AppMethodBeat.m2504i(126426);
        boolean isHeld = c27066j.isHeld();
        AppMethodBeat.m2505o(126426);
        return isHeld;
    }

    /* renamed from: b */
    static /* synthetic */ boolean m43012b(C27066j c27066j) {
        AppMethodBeat.m2504i(126427);
        boolean release = c27066j.release();
        AppMethodBeat.m2505o(126427);
        return release;
    }

    /* renamed from: c */
    static /* synthetic */ boolean m43013c(C27066j c27066j) {
        AppMethodBeat.m2504i(126428);
        boolean aEV = c27066j.aEV();
        AppMethodBeat.m2505o(126428);
        return aEV;
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126422);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn data is null");
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(126422);
        } else if (c2241c.getContext() == null) {
            C4990ab.m7412e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is nul");
            c2241c.mo6107M(i, mo73394j("fail:context is null", null));
            AppMethodBeat.m2505o(126422);
        } else if (c2241c.getContext() instanceof Activity) {
            boolean optBoolean = jSONObject.optBoolean("keepScreenOn", false);
            hXH = optBoolean;
            C4990ab.m7417i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, keepScreenOn:%b, appId:%s", Boolean.valueOf(optBoolean), c2241c.getAppId());
            synchronized (this) {
                try {
                    this.hxS = c2241c;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(126422);
                }
            }
            if (optBoolean) {
                C33183g.m54274a(c2241c.getAppId(), new C33186c() {
                    public final void onDestroy() {
                        AppMethodBeat.m2504i(126419);
                        C4990ab.m7416i("MicroMsg.JsApiSetKeepScreenOn", "onDestroy");
                        if (C27066j.m43011a(C27066j.this)) {
                            C27066j.m43012b(C27066j.this);
                        }
                        C33183g.m54276b(c2241c.getAppId(), this);
                        AppMethodBeat.m2505o(126419);
                    }

                    /* renamed from: a */
                    public final void mo6074a(C33184d c33184d) {
                        AppMethodBeat.m2504i(126420);
                        C4990ab.m7416i("MicroMsg.JsApiSetKeepScreenOn", "onPause");
                        if (C27066j.m43011a(C27066j.this)) {
                            C27066j.m43012b(C27066j.this);
                        }
                        AppMethodBeat.m2505o(126420);
                    }

                    public final void onResume() {
                        AppMethodBeat.m2504i(126421);
                        C4990ab.m7416i("MicroMsg.JsApiSetKeepScreenOn", "onResume");
                        if (C27066j.hXH) {
                            C27066j.m43013c(C27066j.this);
                        }
                        AppMethodBeat.m2505o(126421);
                    }
                });
                optBoolean = aEV();
            } else if (isHeld()) {
                C4990ab.m7416i("MicroMsg.JsApiSetKeepScreenOn", "reset screen off");
                optBoolean = release();
            } else {
                C4990ab.m7412e("MicroMsg.JsApiSetKeepScreenOn", "fail, has not set screen");
                c2241c.mo6107M(i, mo73394j("fail:has not set screen", null));
                AppMethodBeat.m2505o(126422);
                return;
            }
            if (optBoolean) {
                C4990ab.m7416i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn ok");
                c2241c.mo6107M(i, mo73394j("ok", null));
                return;
            }
            C4990ab.m7412e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn fail");
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(126422);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is not activity, don't do invoke");
            c2241c.mo6107M(i, mo73394j("fail:context is null", null));
            AppMethodBeat.m2505o(126422);
        }
    }

    private synchronized boolean aEV() {
        boolean z;
        AppMethodBeat.m2504i(126423);
        if (this.hxS.getContext() == null) {
            C4990ab.m7412e("MicroMsg.JsApiSetKeepScreenOn", "acquire fail, server context is nul");
            z = false;
            AppMethodBeat.m2505o(126423);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiSetKeepScreenOn", "acquire ok");
            Activity activity = (Activity) this.hxS.getContext();
            if (this.wakeLock == null) {
                this.wakeLock = ((PowerManager) activity.getSystemService("power")).newWakeLock(536870922, "MicroMsg.JsApiSetKeepScreenOn");
            }
            if (this.wakeLock.isHeld()) {
                C4990ab.m7416i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock has held ");
            } else {
                this.wakeLock.acquire();
                C4990ab.m7416i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock acquire");
            }
            z = true;
            AppMethodBeat.m2505o(126423);
        }
        return z;
    }

    private synchronized boolean release() {
        boolean z;
        AppMethodBeat.m2504i(126424);
        C4990ab.m7412e("MicroMsg.JsApiSetKeepScreenOn", "release");
        if (this.wakeLock == null || !this.wakeLock.isHeld()) {
            C4990ab.m7412e("MicroMsg.JsApiSetKeepScreenOn", "wakeLock is  null");
            z = false;
            AppMethodBeat.m2505o(126424);
        } else {
            this.wakeLock.release();
            this.wakeLock = null;
            z = true;
            AppMethodBeat.m2505o(126424);
        }
        return z;
    }

    private synchronized boolean isHeld() {
        boolean z;
        AppMethodBeat.m2504i(126425);
        if (this.wakeLock == null || !this.wakeLock.isHeld()) {
            z = false;
            AppMethodBeat.m2505o(126425);
        } else {
            z = true;
            AppMethodBeat.m2505o(126425);
        }
        return z;
    }
}
