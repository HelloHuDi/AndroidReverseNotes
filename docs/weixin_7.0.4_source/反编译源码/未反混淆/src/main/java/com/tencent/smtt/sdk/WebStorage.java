package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class WebStorage {
    private static WebStorage a;

    @Deprecated
    public interface QuotaUpdater {
        void updateQuota(long j);
    }

    private static synchronized WebStorage a() {
        WebStorage webStorage;
        synchronized (WebStorage.class) {
            AppMethodBeat.i(64830);
            if (a == null) {
                a = new WebStorage();
            }
            webStorage = a;
            AppMethodBeat.o(64830);
        }
        return webStorage;
    }

    public static WebStorage getInstance() {
        AppMethodBeat.i(64829);
        WebStorage a = a();
        AppMethodBeat.o(64829);
        return a;
    }

    public void deleteAllData() {
        AppMethodBeat.i(64828);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebStorage.getInstance().deleteAllData();
            AppMethodBeat.o(64828);
            return;
        }
        a.c().n();
        AppMethodBeat.o(64828);
    }

    public void deleteOrigin(String str) {
        AppMethodBeat.i(64827);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebStorage.getInstance().deleteOrigin(str);
            AppMethodBeat.o(64827);
            return;
        }
        a.c().e(str);
        AppMethodBeat.o(64827);
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        AppMethodBeat.i(64823);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
            AppMethodBeat.o(64823);
            return;
        }
        a.c().a((ValueCallback) valueCallback);
        AppMethodBeat.o(64823);
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        AppMethodBeat.i(64825);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
            AppMethodBeat.o(64825);
            return;
        }
        a.c().b(str, valueCallback);
        AppMethodBeat.o(64825);
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        AppMethodBeat.i(64824);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
            AppMethodBeat.o(64824);
            return;
        }
        a.c().a(str, (ValueCallback) valueCallback);
        AppMethodBeat.o(64824);
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j) {
        AppMethodBeat.i(64826);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j);
            AppMethodBeat.o(64826);
            return;
        }
        a.c().a(str, j);
        AppMethodBeat.o(64826);
    }
}
