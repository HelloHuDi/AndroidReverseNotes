package com.tencent.sqlitelint;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.behaviour.report.IssueReportBehaviour.IReportDelegate;
import com.tencent.sqlitelint.util.SQLite3ProfileHooker;
import java.util.List;

public class SQLiteLint {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteLint.class.desiredAssertionStatus());
    private static final int BEHAVIOUR_ALERT = 1;
    private static final int BEHAVIOUR_REPORT = 2;
    public static String sPackageName = null;
    static IReportDelegate sReportDelegate;
    private static SqlExecutionCallbackMode sSqlExecutionCallbackMode = null;

    public static final class InstallEnv {
        static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteLint.class.desiredAssertionStatus());
        private final String mConcernedDbPath;
        private final ISQLiteExecutionDelegate mSQLiteExecutionDelegate;

        static {
            AppMethodBeat.i(93977);
            AppMethodBeat.o(93977);
        }

        public InstallEnv(String str, ISQLiteExecutionDelegate iSQLiteExecutionDelegate) {
            AppMethodBeat.i(93976);
            AssertionError assertionError;
            if (!$assertionsDisabled && str == null) {
                assertionError = new AssertionError();
                AppMethodBeat.o(93976);
                throw assertionError;
            } else if ($assertionsDisabled || iSQLiteExecutionDelegate != null) {
                this.mConcernedDbPath = str;
                this.mSQLiteExecutionDelegate = iSQLiteExecutionDelegate;
                AppMethodBeat.o(93976);
            } else {
                assertionError = new AssertionError();
                AppMethodBeat.o(93976);
                throw assertionError;
            }
        }

        public final String getConcernedDbPath() {
            return this.mConcernedDbPath;
        }

        public final ISQLiteExecutionDelegate getSQLiteExecutionDelegate() {
            return this.mSQLiteExecutionDelegate;
        }
    }

    public static final class Options {
        public static final Options LAX = new Builder().build();
        private int behaviourMask;

        public static final class Builder {
            private int mBehaviourMask;

            public Builder() {
                AppMethodBeat.i(93978);
                this.mBehaviourMask |= 1;
                AppMethodBeat.o(93978);
            }

            public final Builder setAlertBehaviour(boolean z) {
                if (z) {
                    this.mBehaviourMask |= 1;
                } else {
                    this.mBehaviourMask &= -2;
                }
                return this;
            }

            public final Builder setReportBehaviour(boolean z) {
                if (z) {
                    this.mBehaviourMask |= 2;
                } else {
                    this.mBehaviourMask &= -3;
                }
                return this;
            }

            public final Options build() {
                AppMethodBeat.i(93979);
                Options options = new Options();
                options.behaviourMask = this.mBehaviourMask;
                AppMethodBeat.o(93979);
                return options;
            }
        }

        static {
            AppMethodBeat.i(93980);
            AppMethodBeat.o(93980);
        }

        public final boolean isAlertBehaviourEnable() {
            return (this.behaviourMask & 1) > 0;
        }

        public final boolean isReportBehaviourEnable() {
            return (this.behaviourMask & 2) > 0;
        }
    }

    public enum SqlExecutionCallbackMode {
        HOOK,
        CUSTOM_NOTIFY;

        static {
            AppMethodBeat.o(93983);
        }
    }

    static {
        AppMethodBeat.i(93992);
        SQLiteLintNativeBridge.loadLibrary();
        AppMethodBeat.o(93992);
    }

    private SQLiteLint() {
    }

    public static void setSqlExecutionCallbackMode(SqlExecutionCallbackMode sqlExecutionCallbackMode) {
        AppMethodBeat.i(93984);
        if (sSqlExecutionCallbackMode != null) {
            AppMethodBeat.o(93984);
            return;
        }
        sSqlExecutionCallbackMode = sqlExecutionCallbackMode;
        if (sqlExecutionCallbackMode == SqlExecutionCallbackMode.HOOK) {
            SQLite3ProfileHooker.hook();
        }
        AppMethodBeat.o(93984);
    }

    public static SqlExecutionCallbackMode getSqlExecutionCallbackMode() {
        return sSqlExecutionCallbackMode;
    }

    public static void install(Context context, SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(93985);
        AssertionError assertionError;
        if (!$assertionsDisabled && sQLiteDatabase == null) {
            assertionError = new AssertionError();
            AppMethodBeat.o(93985);
            throw assertionError;
        } else if ($assertionsDisabled || sSqlExecutionCallbackMode != null) {
            SQLiteLintAndroidCoreManager.INSTANCE.install(context, new InstallEnv(sQLiteDatabase.getPath(), new SimpleSQLiteExecutionDelegate(sQLiteDatabase)), Options.LAX);
            AppMethodBeat.o(93985);
        } else {
            assertionError = new AssertionError("SqlExecutionCallbackMode not set！setSqlExecutionCallbackMode must be called before install");
            AppMethodBeat.o(93985);
            throw assertionError;
        }
    }

    public static void install(Context context, InstallEnv installEnv, Options options) {
        AppMethodBeat.i(93986);
        AssertionError assertionError;
        if (!$assertionsDisabled && installEnv == null) {
            assertionError = new AssertionError();
            AppMethodBeat.o(93986);
            throw assertionError;
        } else if ($assertionsDisabled || sSqlExecutionCallbackMode != null) {
            if (options == null) {
                options = Options.LAX;
            }
            SQLiteLintAndroidCoreManager.INSTANCE.install(context, installEnv, options);
            AppMethodBeat.o(93986);
        } else {
            assertionError = new AssertionError("SqlExecutionCallbackMode is UNKNOWN！setSqlExecutionCallbackMode must be called before install");
            AppMethodBeat.o(93986);
            throw assertionError;
        }
    }

    public static void notifySqlExecution(String str, String str2, int i) {
        AppMethodBeat.i(93987);
        if (SQLiteLintAndroidCoreManager.INSTANCE.get(str) == null) {
            AppMethodBeat.o(93987);
            return;
        }
        SQLiteLintAndroidCoreManager.INSTANCE.get(str).notifySqlExecution(str, str2, (long) i);
        AppMethodBeat.o(93987);
    }

    public static void uninstall(String str) {
        AppMethodBeat.i(93988);
        SQLiteLintAndroidCoreManager.INSTANCE.get(str).release();
        SQLiteLintAndroidCoreManager.INSTANCE.remove(str);
        AppMethodBeat.o(93988);
    }

    public static void setWhiteList(String str, int i) {
        AppMethodBeat.i(93989);
        if (SQLiteLintAndroidCoreManager.INSTANCE.get(str) == null) {
            AppMethodBeat.o(93989);
            return;
        }
        SQLiteLintAndroidCoreManager.INSTANCE.get(str).setWhiteList(i);
        AppMethodBeat.o(93989);
    }

    public static void enableCheckers(String str, List<String> list) {
        AppMethodBeat.i(93990);
        if (SQLiteLintAndroidCoreManager.INSTANCE.get(str) == null) {
            AppMethodBeat.o(93990);
        } else if (list == null || list.isEmpty()) {
            AppMethodBeat.o(93990);
        } else {
            SQLiteLintAndroidCoreManager.INSTANCE.get(str).enableCheckers(list);
            AppMethodBeat.o(93990);
        }
    }

    static void setReportDelegate(IReportDelegate iReportDelegate) {
        sReportDelegate = iReportDelegate;
    }

    public static void setPackageName(Context context) {
        AppMethodBeat.i(93991);
        if (sPackageName == null) {
            sPackageName = context.getPackageName();
        }
        AppMethodBeat.o(93991);
    }
}
