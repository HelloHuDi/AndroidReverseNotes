package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public class CookieSyncManager {
    /* renamed from: a */
    private static android.webkit.CookieSyncManager f17962a;
    /* renamed from: b */
    private static CookieSyncManager f17963b;
    /* renamed from: c */
    private static boolean f17964c = false;

    private CookieSyncManager(Context context) {
        AppMethodBeat.m2504i(63889);
        C40978bv a = C40978bv.m71073a();
        if (a != null && a.mo64921b()) {
            a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[]{Context.class}, context);
            f17964c = true;
        }
        AppMethodBeat.m2505o(63889);
    }

    public static synchronized CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            AppMethodBeat.m2504i(63887);
            f17962a = android.webkit.CookieSyncManager.createInstance(context);
            if (f17963b == null || !f17964c) {
                f17963b = new CookieSyncManager(context.getApplicationContext());
            }
            cookieSyncManager = f17963b;
            AppMethodBeat.m2505o(63887);
        }
        return cookieSyncManager;
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            AppMethodBeat.m2504i(63888);
            if (f17963b == null) {
                IllegalStateException illegalStateException = new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
                AppMethodBeat.m2505o(63888);
                throw illegalStateException;
            }
            cookieSyncManager = f17963b;
            AppMethodBeat.m2505o(63888);
        }
        return cookieSyncManager;
    }

    public void startSync() {
        AppMethodBeat.m2504i(63892);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            f17962a.startSync();
            try {
                Field declaredField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
                declaredField.setAccessible(true);
                ((Thread) declaredField.get(f17962a)).setUncaughtExceptionHandler(new C36439p());
                AppMethodBeat.m2505o(63892);
                return;
            } catch (Exception e) {
                AppMethodBeat.m2505o(63892);
                return;
            }
        }
        a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(63892);
    }

    public void stopSync() {
        AppMethodBeat.m2504i(63891);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            f17962a.stopSync();
            AppMethodBeat.m2505o(63891);
            return;
        }
        a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(63891);
    }

    public void sync() {
        AppMethodBeat.m2504i(63890);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            f17962a.sync();
            AppMethodBeat.m2505o(63890);
            return;
        }
        a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(63890);
    }
}
