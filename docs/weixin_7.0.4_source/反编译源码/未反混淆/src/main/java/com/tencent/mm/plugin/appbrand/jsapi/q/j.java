package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.app.Activity;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class j extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setKeepScreenOn";
    private static boolean hXH = false;
    private c hxS;
    WakeLock wakeLock;

    static /* synthetic */ boolean a(j jVar) {
        AppMethodBeat.i(126426);
        boolean isHeld = jVar.isHeld();
        AppMethodBeat.o(126426);
        return isHeld;
    }

    static /* synthetic */ boolean b(j jVar) {
        AppMethodBeat.i(126427);
        boolean release = jVar.release();
        AppMethodBeat.o(126427);
        return release;
    }

    static /* synthetic */ boolean c(j jVar) {
        AppMethodBeat.i(126428);
        boolean aEV = jVar.aEV();
        AppMethodBeat.o(126428);
        return aEV;
    }

    public final void a(final c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126422);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn data is null");
            cVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(126422);
        } else if (cVar.getContext() == null) {
            ab.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is nul");
            cVar.M(i, j("fail:context is null", null));
            AppMethodBeat.o(126422);
        } else if (cVar.getContext() instanceof Activity) {
            boolean optBoolean = jSONObject.optBoolean("keepScreenOn", false);
            hXH = optBoolean;
            ab.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, keepScreenOn:%b, appId:%s", Boolean.valueOf(optBoolean), cVar.getAppId());
            synchronized (this) {
                try {
                    this.hxS = cVar;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(126422);
                }
            }
            if (optBoolean) {
                g.a(cVar.getAppId(), new g.c() {
                    public final void onDestroy() {
                        AppMethodBeat.i(126419);
                        ab.i("MicroMsg.JsApiSetKeepScreenOn", "onDestroy");
                        if (j.a(j.this)) {
                            j.b(j.this);
                        }
                        g.b(cVar.getAppId(), this);
                        AppMethodBeat.o(126419);
                    }

                    public final void a(d dVar) {
                        AppMethodBeat.i(126420);
                        ab.i("MicroMsg.JsApiSetKeepScreenOn", "onPause");
                        if (j.a(j.this)) {
                            j.b(j.this);
                        }
                        AppMethodBeat.o(126420);
                    }

                    public final void onResume() {
                        AppMethodBeat.i(126421);
                        ab.i("MicroMsg.JsApiSetKeepScreenOn", "onResume");
                        if (j.hXH) {
                            j.c(j.this);
                        }
                        AppMethodBeat.o(126421);
                    }
                });
                optBoolean = aEV();
            } else if (isHeld()) {
                ab.i("MicroMsg.JsApiSetKeepScreenOn", "reset screen off");
                optBoolean = release();
            } else {
                ab.e("MicroMsg.JsApiSetKeepScreenOn", "fail, has not set screen");
                cVar.M(i, j("fail:has not set screen", null));
                AppMethodBeat.o(126422);
                return;
            }
            if (optBoolean) {
                ab.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn ok");
                cVar.M(i, j("ok", null));
                return;
            }
            ab.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn fail");
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(126422);
        } else {
            ab.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is not activity, don't do invoke");
            cVar.M(i, j("fail:context is null", null));
            AppMethodBeat.o(126422);
        }
    }

    private synchronized boolean aEV() {
        boolean z;
        AppMethodBeat.i(126423);
        if (this.hxS.getContext() == null) {
            ab.e("MicroMsg.JsApiSetKeepScreenOn", "acquire fail, server context is nul");
            z = false;
            AppMethodBeat.o(126423);
        } else {
            ab.e("MicroMsg.JsApiSetKeepScreenOn", "acquire ok");
            Activity activity = (Activity) this.hxS.getContext();
            if (this.wakeLock == null) {
                this.wakeLock = ((PowerManager) activity.getSystemService("power")).newWakeLock(536870922, "MicroMsg.JsApiSetKeepScreenOn");
            }
            if (this.wakeLock.isHeld()) {
                ab.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock has held ");
            } else {
                this.wakeLock.acquire();
                ab.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock acquire");
            }
            z = true;
            AppMethodBeat.o(126423);
        }
        return z;
    }

    private synchronized boolean release() {
        boolean z;
        AppMethodBeat.i(126424);
        ab.e("MicroMsg.JsApiSetKeepScreenOn", "release");
        if (this.wakeLock == null || !this.wakeLock.isHeld()) {
            ab.e("MicroMsg.JsApiSetKeepScreenOn", "wakeLock is  null");
            z = false;
            AppMethodBeat.o(126424);
        } else {
            this.wakeLock.release();
            this.wakeLock = null;
            z = true;
            AppMethodBeat.o(126424);
        }
        return z;
    }

    private synchronized boolean isHeld() {
        boolean z;
        AppMethodBeat.i(126425);
        if (this.wakeLock == null || !this.wakeLock.isHeld()) {
            z = false;
            AppMethodBeat.o(126425);
        } else {
            z = true;
            AppMethodBeat.o(126425);
        }
        return z;
    }
}
