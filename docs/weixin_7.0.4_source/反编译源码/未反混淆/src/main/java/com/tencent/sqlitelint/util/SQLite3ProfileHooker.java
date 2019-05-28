package com.tencent.sqlitelint.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class SQLite3ProfileHooker {
    private static final String TAG = "SQLiteLint.SQLite3ProfileHooker";
    private static volatile boolean sIsTryHook;

    private static native boolean nativeDoHook();

    private static native void nativeStartProfile();

    private static native void nativeStopProfile();

    public static void hook() {
        AppMethodBeat.i(94115);
        SLog.i(TAG, "hook sIsTryHook: %b", Boolean.valueOf(sIsTryHook));
        nativeStartProfile();
        if (!sIsTryHook) {
            boolean doHook = doHook();
            SLog.i(TAG, "hook hookRet: %b", Boolean.valueOf(doHook));
            sIsTryHook = true;
        }
        AppMethodBeat.o(94115);
    }

    public static void unHook() {
        AppMethodBeat.i(94116);
        if (sIsTryHook) {
            boolean doUnHook = doUnHook();
            SLog.i(TAG, "unHook unHookRet: %b", Boolean.valueOf(doUnHook));
            sIsTryHook = false;
        }
        AppMethodBeat.o(94116);
    }

    private static boolean doHook() {
        AppMethodBeat.i(94117);
        if (hookOpenSQLite3Profile()) {
            boolean nativeDoHook = nativeDoHook();
            AppMethodBeat.o(94117);
            return nativeDoHook;
        }
        SLog.i(TAG, "doHook hookOpenSQLite3Profile failed", new Object[0]);
        AppMethodBeat.o(94117);
        return false;
    }

    private static boolean doUnHook() {
        AppMethodBeat.i(94118);
        unHookOpenSQLite3Profile();
        nativeStopProfile();
        AppMethodBeat.o(94118);
        return true;
    }

    private static boolean hookOpenSQLite3Profile() {
        AppMethodBeat.i(94119);
        try {
            Class cls = Class.forName("android.database.sqlite.SQLiteDebug");
            Field declaredField = cls.getDeclaredField("DEBUG_SQL_TIME");
            declaredField.setAccessible(true);
            declaredField.setBoolean(cls, true);
            declaredField.setAccessible(false);
            AppMethodBeat.o(94119);
            return true;
        } catch (ClassNotFoundException e) {
            SLog.e(TAG, "prepareHookBeforeOpenDatabase: e=%s", e.getLocalizedMessage());
            AppMethodBeat.o(94119);
            return false;
        } catch (IllegalAccessException e2) {
            SLog.e(TAG, "prepareHookBeforeOpenDatabase: e=%s", e2.getLocalizedMessage());
            AppMethodBeat.o(94119);
            return false;
        } catch (NoSuchFieldException e3) {
            SLog.e(TAG, "prepareHookBeforeOpenDatabase: e=%s", e3.getLocalizedMessage());
            AppMethodBeat.o(94119);
            return false;
        }
    }

    private static boolean unHookOpenSQLite3Profile() {
        AppMethodBeat.i(94120);
        try {
            Class cls = Class.forName("android.database.sqlite.SQLiteDebug");
            Field declaredField = cls.getDeclaredField("DEBUG_SQL_TIME");
            declaredField.setAccessible(true);
            declaredField.setBoolean(cls, false);
            declaredField.setAccessible(false);
            AppMethodBeat.o(94120);
            return true;
        } catch (ClassNotFoundException e) {
            SLog.e(TAG, "unHookOpenSQLite3Profile: e=%s", e.getLocalizedMessage());
            AppMethodBeat.o(94120);
            return false;
        } catch (IllegalAccessException e2) {
            SLog.e(TAG, "unHookOpenSQLite3Profile: e=%s", e2.getLocalizedMessage());
            AppMethodBeat.o(94120);
            return false;
        } catch (NoSuchFieldException e3) {
            SLog.e(TAG, "unHookOpenSQLite3Profile: e=%s", e3.getLocalizedMessage());
            AppMethodBeat.o(94120);
            return false;
        }
    }
}
