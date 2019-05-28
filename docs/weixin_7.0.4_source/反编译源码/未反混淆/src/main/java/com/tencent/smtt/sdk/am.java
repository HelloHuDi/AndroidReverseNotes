package com.tencent.smtt.sdk;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.TbsCoreSettings;
import java.util.HashMap;
import java.util.Map;

class am {
    public boolean a;
    public boolean b;
    private Map<String, String> c;

    public am() {
        AppMethodBeat.i(64391);
        this.a = false;
        this.b = false;
        this.c = null;
        this.c = new HashMap();
        AppMethodBeat.o(64391);
    }

    public synchronized void a(String str, byte b) {
        AppMethodBeat.i(64392);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(64392);
        } else {
            String str2 = "";
            if (b == (byte) 1) {
                str2 = "_begin";
            } else if (b == (byte) 2) {
                str2 = "_end";
            }
            this.c.put(str + str2, String.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(64392);
        }
    }

    public synchronized void a(String str, long j) {
        AppMethodBeat.i(64393);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(64393);
        } else {
            this.c.put(str, String.valueOf(j));
            AppMethodBeat.o(64393);
        }
    }

    public synchronized boolean a(int i, String str) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(64394);
            bv a = bv.a();
            if (!a.b()) {
                AppMethodBeat.o(64394);
                z = false;
            } else if ((this.b && this.a) || System.currentTimeMillis() % 10 == 0) {
                this.b = true;
                this.a = true;
                this.c.put("is_first_init_tbs", String.valueOf(this.b));
                this.c.put("is_first_init_x5", String.valueOf(this.a));
                this.c.put("x5_webview_id", Integer.toString(i));
                this.c.put("current_url", str);
                if (QbSdk.n != null && QbSdk.n.containsKey(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID)) {
                    this.c.put(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID, QbSdk.n.get(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID));
                }
                a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setTbsInitPerformanceData", new Class[]{Integer.TYPE, Map.class}, Integer.valueOf(i), this.c);
                AppMethodBeat.o(64394);
            } else {
                AppMethodBeat.o(64394);
            }
        }
        return z;
    }
}
