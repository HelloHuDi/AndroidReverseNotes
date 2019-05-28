package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public class CookieSyncManager {
    private static android.webkit.CookieSyncManager a;
    private static CookieSyncManager b;
    private static boolean c = false;

    private CookieSyncManager(Context context) {
        AppMethodBeat.i(63889);
        bv a = bv.a();
        if (a != null && a.b()) {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[]{Context.class}, context);
            c = true;
        }
        AppMethodBeat.o(63889);
    }

    public static synchronized CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            AppMethodBeat.i(63887);
            a = android.webkit.CookieSyncManager.createInstance(context);
            if (b == null || !c) {
                b = new CookieSyncManager(context.getApplicationContext());
            }
            cookieSyncManager = b;
            AppMethodBeat.o(63887);
        }
        return cookieSyncManager;
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            AppMethodBeat.i(63888);
            if (b == null) {
                IllegalStateException illegalStateException = new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
                AppMethodBeat.o(63888);
                throw illegalStateException;
            }
            cookieSyncManager = b;
            AppMethodBeat.o(63888);
        }
        return cookieSyncManager;
    }

    public void startSync() {
        AppMethodBeat.i(63892);
        bv a = bv.a();
        if (a == null || !a.b()) {
            a.startSync();
            try {
                Field declaredField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
                declaredField.setAccessible(true);
                ((Thread) declaredField.get(a)).setUncaughtExceptionHandler(new p());
                AppMethodBeat.o(63892);
                return;
            } catch (Exception e) {
                AppMethodBeat.o(63892);
                return;
            }
        }
        a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
        AppMethodBeat.o(63892);
    }

    public void stopSync() {
        AppMethodBeat.i(63891);
        bv a = bv.a();
        if (a == null || !a.b()) {
            a.stopSync();
            AppMethodBeat.o(63891);
            return;
        }
        a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        AppMethodBeat.o(63891);
    }

    public void sync() {
        AppMethodBeat.i(63890);
        bv a = bv.a();
        if (a == null || !a.b()) {
            a.sync();
            AppMethodBeat.o(63890);
            return;
        }
        a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
        AppMethodBeat.o(63890);
    }
}
