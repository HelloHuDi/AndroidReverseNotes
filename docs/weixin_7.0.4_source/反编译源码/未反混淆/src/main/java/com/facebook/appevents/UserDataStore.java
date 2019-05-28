package com.facebook.appevents;

import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

public class UserDataStore {
    public static final String CITY = "ct";
    public static final String COUNTRY = "country";
    public static final String DATE_OF_BIRTH = "db";
    public static final String EMAIL = "em";
    public static final String FIRST_NAME = "fn";
    public static final String GENDER = "ge";
    public static final String LAST_NAME = "ln";
    public static final String PHONE = "ph";
    public static final String STATE = "st";
    private static final String TAG = UserDataStore.class.getSimpleName();
    private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
    public static final String ZIP = "zp";
    private static String hashedUserData;
    private static volatile boolean initialized = false;
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(72037);
        initAndWait();
        AppMethodBeat.o(72037);
    }

    static /* synthetic */ String access$300(Bundle bundle) {
        AppMethodBeat.i(72038);
        String hashUserData = hashUserData(bundle);
        AppMethodBeat.o(72038);
        return hashUserData;
    }

    static {
        AppMethodBeat.i(72039);
        AppMethodBeat.o(72039);
    }

    public static void initStore() {
        AppMethodBeat.i(72028);
        if (initialized) {
            AppMethodBeat.o(72028);
            return;
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(72026);
                UserDataStore.access$000();
                AppMethodBeat.o(72026);
            }
        });
        AppMethodBeat.o(72028);
    }

    public static void setUserDataAndHash(final Bundle bundle) {
        AppMethodBeat.i(72029);
        if (!initialized) {
            initAndWait();
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(72027);
                UserDataStore.lock.writeLock().lock();
                try {
                    UserDataStore.hashedUserData = UserDataStore.access$300(bundle);
                    Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
                    edit.putString(UserDataStore.USER_DATA_KEY, UserDataStore.hashedUserData);
                    edit.apply();
                } finally {
                    UserDataStore.lock.writeLock().unlock();
                    AppMethodBeat.o(72027);
                }
            }
        });
        AppMethodBeat.o(72029);
    }

    public static void setUserDataAndHash(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        AppMethodBeat.i(72030);
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString(EMAIL, str);
        }
        if (str2 != null) {
            bundle.putString(FIRST_NAME, str2);
        }
        if (str3 != null) {
            bundle.putString(LAST_NAME, str3);
        }
        if (str4 != null) {
            bundle.putString(PHONE, str4);
        }
        if (str5 != null) {
            bundle.putString(DATE_OF_BIRTH, str5);
        }
        if (str6 != null) {
            bundle.putString(GENDER, str6);
        }
        if (str7 != null) {
            bundle.putString(CITY, str7);
        }
        if (str8 != null) {
            bundle.putString(STATE, str8);
        }
        if (str9 != null) {
            bundle.putString(ZIP, str9);
        }
        if (str10 != null) {
            bundle.putString(COUNTRY, str10);
        }
        setUserDataAndHash(bundle);
        AppMethodBeat.o(72030);
    }

    public static String getHashedUserData() {
        AppMethodBeat.i(72031);
        if (!initialized) {
            initAndWait();
        }
        lock.readLock().lock();
        try {
            String str = hashedUserData;
            return str;
        } finally {
            lock.readLock().unlock();
            AppMethodBeat.o(72031);
        }
    }

    private static void initAndWait() {
        AppMethodBeat.i(72032);
        if (initialized) {
            AppMethodBeat.o(72032);
            return;
        }
        lock.writeLock().lock();
        try {
            if (!initialized) {
                hashedUserData = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString(USER_DATA_KEY, null);
                initialized = true;
                lock.writeLock().unlock();
                AppMethodBeat.o(72032);
            }
        } finally {
            lock.writeLock().unlock();
            AppMethodBeat.o(72032);
        }
    }

    private static String hashUserData(Bundle bundle) {
        AppMethodBeat.i(72033);
        if (bundle == null) {
            AppMethodBeat.o(72033);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                String obj = bundle.get(str).toString();
                if (maybeSHA256Hashed(obj)) {
                    jSONObject.put(str, obj.toLowerCase());
                } else {
                    obj = encryptData(normalizeData(str, bundle.get(str).toString()));
                    if (obj != null) {
                        jSONObject.put(str, obj);
                    }
                }
            } catch (JSONException e) {
            }
        }
        String str2 = jSONObject.toString();
        AppMethodBeat.o(72033);
        return str2;
    }

    private static String encryptData(String str) {
        String str2 = null;
        AppMethodBeat.i(72034);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(72034);
            return str2;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM);
            instance.update(str.getBytes());
            str2 = AppEventUtility.bytesToHex(instance.digest());
            AppMethodBeat.o(72034);
            return str2;
        } catch (NoSuchAlgorithmException e) {
            AppMethodBeat.o(72034);
            return str2;
        }
    }

    private static String normalizeData(String str, String str2) {
        AppMethodBeat.i(72035);
        String str3 = "";
        int i = -1;
        switch (str.hashCode()) {
            case 3185:
                if (str.equals(CITY)) {
                    i = 3;
                    break;
                }
                break;
            case 3240:
                if (str.equals(EMAIL)) {
                    i = 0;
                    break;
                }
                break;
            case 3272:
                if (str.equals(FIRST_NAME)) {
                    i = 1;
                    break;
                }
                break;
            case 3294:
                if (str.equals(GENDER)) {
                    i = 7;
                    break;
                }
                break;
            case 3458:
                if (str.equals(LAST_NAME)) {
                    i = 2;
                    break;
                }
                break;
            case 3576:
                if (str.equals(PHONE)) {
                    i = 6;
                    break;
                }
                break;
            case 3681:
                if (str.equals(STATE)) {
                    i = 4;
                    break;
                }
                break;
            case 957831062:
                if (str.equals(COUNTRY)) {
                    i = 5;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                str3 = str2.trim().toLowerCase();
                break;
            case 6:
                str3 = str2.trim().replaceAll("[^0-9]", "");
                break;
            case 7:
                str3 = str2.trim().toLowerCase();
                if (str3.length() <= 0) {
                    str3 = "";
                    break;
                }
                str3 = str3.substring(0, 1);
                break;
        }
        AppMethodBeat.o(72035);
        return str3;
    }

    private static boolean maybeSHA256Hashed(String str) {
        AppMethodBeat.i(72036);
        boolean matches = str.matches("[A-Fa-f0-9]{64}");
        AppMethodBeat.o(72036);
        return matches;
    }
}
