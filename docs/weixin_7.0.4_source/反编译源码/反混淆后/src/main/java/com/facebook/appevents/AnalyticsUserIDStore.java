package com.facebook.appevents;

import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class AnalyticsUserIDStore {
    private static final String ANALYTICS_USER_ID_KEY = "com.facebook.appevents.AnalyticsUserIDStore.userID";
    private static final String TAG = AnalyticsUserIDStore.class.getSimpleName();
    private static volatile boolean initialized = false;
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static String userID;

    /* renamed from: com.facebook.appevents.AnalyticsUserIDStore$1 */
    static class C175801 implements Runnable {
        C175801() {
        }

        public final void run() {
            AppMethodBeat.m2504i(71857);
            AnalyticsUserIDStore.access$000();
            AppMethodBeat.m2505o(71857);
        }
    }

    AnalyticsUserIDStore() {
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.m2504i(71863);
        initAndWait();
        AppMethodBeat.m2505o(71863);
    }

    static {
        AppMethodBeat.m2504i(71864);
        AppMethodBeat.m2505o(71864);
    }

    public static void initStore() {
        AppMethodBeat.m2504i(71859);
        if (initialized) {
            AppMethodBeat.m2505o(71859);
            return;
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new C175801());
        AppMethodBeat.m2505o(71859);
    }

    public static void setUserID(final String str) {
        AppMethodBeat.m2504i(71860);
        AppEventUtility.assertIsNotMainThread();
        if (!initialized) {
            initAndWait();
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(71858);
                AnalyticsUserIDStore.lock.writeLock().lock();
                try {
                    AnalyticsUserIDStore.userID = str;
                    Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
                    edit.putString(AnalyticsUserIDStore.ANALYTICS_USER_ID_KEY, AnalyticsUserIDStore.userID);
                    edit.apply();
                } finally {
                    AnalyticsUserIDStore.lock.writeLock().unlock();
                    AppMethodBeat.m2505o(71858);
                }
            }
        });
        AppMethodBeat.m2505o(71860);
    }

    public static String getUserID() {
        AppMethodBeat.m2504i(71861);
        if (!initialized) {
            initAndWait();
        }
        lock.readLock().lock();
        try {
            String str = userID;
            return str;
        } finally {
            lock.readLock().unlock();
            AppMethodBeat.m2505o(71861);
        }
    }

    private static void initAndWait() {
        AppMethodBeat.m2504i(71862);
        if (initialized) {
            AppMethodBeat.m2505o(71862);
            return;
        }
        lock.writeLock().lock();
        try {
            if (!initialized) {
                userID = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString(ANALYTICS_USER_ID_KEY, null);
                initialized = true;
                lock.writeLock().unlock();
                AppMethodBeat.m2505o(71862);
            }
        } finally {
            lock.writeLock().unlock();
            AppMethodBeat.m2505o(71862);
        }
    }
}
