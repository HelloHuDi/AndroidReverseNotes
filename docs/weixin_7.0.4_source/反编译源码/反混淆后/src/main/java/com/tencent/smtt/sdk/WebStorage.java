package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class WebStorage {
    /* renamed from: a */
    private static WebStorage f16284a;

    @Deprecated
    public interface QuotaUpdater {
        void updateQuota(long j);
    }

    /* renamed from: a */
    private static synchronized WebStorage m71052a() {
        WebStorage webStorage;
        synchronized (WebStorage.class) {
            AppMethodBeat.m2504i(64830);
            if (f16284a == null) {
                f16284a = new WebStorage();
            }
            webStorage = f16284a;
            AppMethodBeat.m2505o(64830);
        }
        return webStorage;
    }

    public static WebStorage getInstance() {
        AppMethodBeat.m2504i(64829);
        WebStorage a = m71052a();
        AppMethodBeat.m2505o(64829);
        return a;
    }

    public void deleteAllData() {
        AppMethodBeat.m2504i(64828);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebStorage.getInstance().deleteAllData();
            AppMethodBeat.m2505o(64828);
            return;
        }
        a.mo64922c().mo57609n();
        AppMethodBeat.m2505o(64828);
    }

    public void deleteOrigin(String str) {
        AppMethodBeat.m2504i(64827);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebStorage.getInstance().deleteOrigin(str);
            AppMethodBeat.m2505o(64827);
            return;
        }
        a.mo64922c().mo57588e(str);
        AppMethodBeat.m2505o(64827);
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        AppMethodBeat.m2504i(64823);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
            AppMethodBeat.m2505o(64823);
            return;
        }
        a.mo64922c().mo57563a((ValueCallback) valueCallback);
        AppMethodBeat.m2505o(64823);
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        AppMethodBeat.m2504i(64825);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
            AppMethodBeat.m2505o(64825);
            return;
        }
        a.mo64922c().mo57577b(str, valueCallback);
        AppMethodBeat.m2505o(64825);
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        AppMethodBeat.m2504i(64824);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
            AppMethodBeat.m2505o(64824);
            return;
        }
        a.mo64922c().mo57565a(str, (ValueCallback) valueCallback);
        AppMethodBeat.m2505o(64824);
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j) {
        AppMethodBeat.m2504i(64826);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j);
            AppMethodBeat.m2505o(64826);
            return;
        }
        a.mo64922c().mo57564a(str, j);
        AppMethodBeat.m2505o(64826);
    }
}
