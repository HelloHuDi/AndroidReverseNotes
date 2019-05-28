package com.tencent.smtt.sdk;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.TbsCoreSettings;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.smtt.sdk.am */
class C30943am {
    /* renamed from: a */
    public boolean f13899a;
    /* renamed from: b */
    public boolean f13900b;
    /* renamed from: c */
    private Map<String, String> f13901c;

    public C30943am() {
        AppMethodBeat.m2504i(64391);
        this.f13899a = false;
        this.f13900b = false;
        this.f13901c = null;
        this.f13901c = new HashMap();
        AppMethodBeat.m2505o(64391);
    }

    /* renamed from: a */
    public synchronized void mo50045a(String str, byte b) {
        AppMethodBeat.m2504i(64392);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(64392);
        } else {
            String str2 = "";
            if (b == (byte) 1) {
                str2 = "_begin";
            } else if (b == (byte) 2) {
                str2 = "_end";
            }
            this.f13901c.put(str + str2, String.valueOf(System.currentTimeMillis()));
            AppMethodBeat.m2505o(64392);
        }
    }

    /* renamed from: a */
    public synchronized void mo50046a(String str, long j) {
        AppMethodBeat.m2504i(64393);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(64393);
        } else {
            this.f13901c.put(str, String.valueOf(j));
            AppMethodBeat.m2505o(64393);
        }
    }

    /* renamed from: a */
    public synchronized boolean mo50047a(int i, String str) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(64394);
            C40978bv a = C40978bv.m71073a();
            if (!a.mo64921b()) {
                AppMethodBeat.m2505o(64394);
                z = false;
            } else if ((this.f13900b && this.f13899a) || System.currentTimeMillis() % 10 == 0) {
                this.f13900b = true;
                this.f13899a = true;
                this.f13901c.put("is_first_init_tbs", String.valueOf(this.f13900b));
                this.f13901c.put("is_first_init_x5", String.valueOf(this.f13899a));
                this.f13901c.put("x5_webview_id", Integer.toString(i));
                this.f13901c.put("current_url", str);
                if (QbSdk.f16252n != null && QbSdk.f16252n.containsKey(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID)) {
                    this.f13901c.put(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID, QbSdk.f16252n.get(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID));
                }
                a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setTbsInitPerformanceData", new Class[]{Integer.TYPE, Map.class}, Integer.valueOf(i), this.f13901c);
                AppMethodBeat.m2505o(64394);
            } else {
                AppMethodBeat.m2505o(64394);
            }
        }
        return z;
    }
}
