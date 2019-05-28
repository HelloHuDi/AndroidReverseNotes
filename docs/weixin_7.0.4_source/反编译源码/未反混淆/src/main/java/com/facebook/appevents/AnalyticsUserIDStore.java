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

    AnalyticsUserIDStore() {
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(71863);
        initAndWait();
        AppMethodBeat.o(71863);
    }

    static {
        AppMethodBeat.i(71864);
        AppMethodBeat.o(71864);
    }

    public static void initStore() {
        AppMethodBeat.i(71859);
        if (initialized) {
            AppMethodBeat.o(71859);
            return;
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(71857);
                AnalyticsUserIDStore.access$000();
                AppMethodBeat.o(71857);
            }
        });
        AppMethodBeat.o(71859);
    }

    public static void setUserID(final String str) {
        AppMethodBeat.i(71860);
        AppEventUtility.assertIsNotMainThread();
        if (!initialized) {
            initAndWait();
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(71858);
                AnalyticsUserIDStore.lock.writeLock().lock();
                try {
                    AnalyticsUserIDStore.userID = str;
                    Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
                    edit.putString(AnalyticsUserIDStore.ANALYTICS_USER_ID_KEY, AnalyticsUserIDStore.userID);
                    edit.apply();
                } finally {
                    AnalyticsUserIDStore.lock.writeLock().unlock();
                    AppMethodBeat.o(71858);
                }
            }
        });
        AppMethodBeat.o(71860);
    }

    public static String getUserID() {
        AppMethodBeat.i(71861);
        if (!initialized) {
            initAndWait();
        }
        lock.readLock().lock();
        try {
            String str = userID;
            return str;
        } finally {
            lock.readLock().unlock();
            AppMethodBeat.o(71861);
        }
    }

    private static void initAndWait() {
        AppMethodBeat.i(71862);
        if (initialized) {
            AppMethodBeat.o(71862);
            return;
        }
        lock.writeLock().lock();
        try {
            if (!initialized) {
                userID = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString(ANALYTICS_USER_ID_KEY, null);
                initialized = true;
                lock.writeLock().unlock();
                AppMethodBeat.o(71862);
            }
        } finally {
            lock.writeLock().unlock();
            AppMethodBeat.o(71862);
        }
    }
}
