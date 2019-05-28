package com.tencent.sqlitelint.config;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLint;
import com.tencent.sqlitelint.SQLiteLint.InstallEnv;
import com.tencent.sqlitelint.SQLiteLint.Options;
import com.tencent.sqlitelint.SQLiteLint.SqlExecutionCallbackMode;
import com.tencent.sqlitelint.SimpleSQLiteExecutionDelegate;
import java.util.ArrayList;
import java.util.List;

public final class SQLiteLintConfig {
    private final List<ConcernDb> sConcernDbList = new ArrayList();

    public static final class ConcernDb {
        static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteLintConfig.class.desiredAssertionStatus());
        private static final String AVOID_AUTO_INCREMENT_CHECKER_NAME = "AvoidAutoIncrementChecker";
        private static final String AVOID_SELECT_ALL_CHECKER_NAME = "AvoidSelectAllChecker";
        private static final String EXPLAIN_QUERY_PLAN_CHECKER_NAME = "ExplainQueryPlanChecker";
        private static final String PREPARED_STATEMENT_BETTER_CHECKER_NAME = "PreparedStatementBetterChecker";
        private static final String REDUNDANT_INDEX_CHECKER_NAME = "RedundantIndexChecker";
        private static final String WITHOUT_ROWID_BETTER_CHECKER_NAME = "WithoutRowIdBetterChecker";
        private final List<String> mEnableCheckerList = new ArrayList();
        private final InstallEnv mInstallEnv;
        private final Options mOptions;
        private int mWhiteListXmlResId;

        static {
            AppMethodBeat.i(94105);
            AppMethodBeat.o(94105);
        }

        public ConcernDb(InstallEnv installEnv, Options options) {
            AppMethodBeat.i(94095);
            this.mInstallEnv = installEnv;
            this.mOptions = options;
            AppMethodBeat.o(94095);
        }

        public ConcernDb(SQLiteDatabase sQLiteDatabase) {
            AppMethodBeat.i(94096);
            if ($assertionsDisabled || sQLiteDatabase != null) {
                this.mInstallEnv = new InstallEnv(sQLiteDatabase.getPath(), new SimpleSQLiteExecutionDelegate(sQLiteDatabase));
                this.mOptions = Options.LAX;
                AppMethodBeat.o(94096);
                return;
            }
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(94096);
            throw assertionError;
        }

        public final ConcernDb setWhiteListXml(int i) {
            this.mWhiteListXmlResId = i;
            return this;
        }

        public final InstallEnv getInstallEnv() {
            return this.mInstallEnv;
        }

        public final Options getOptions() {
            return this.mOptions;
        }

        public final int getWhiteListXmlResId() {
            return this.mWhiteListXmlResId;
        }

        public final ConcernDb enableAllCheckers() {
            AppMethodBeat.i(94097);
            ConcernDb enableRedundantIndexChecker = enableExplainQueryPlanChecker().enableAvoidSelectAllChecker().enableWithoutRowIdBetterChecker().enableAvoidAutoIncrementChecker().enablePreparedStatementBetterChecker().enableRedundantIndexChecker();
            AppMethodBeat.o(94097);
            return enableRedundantIndexChecker;
        }

        public final ConcernDb enableExplainQueryPlanChecker() {
            AppMethodBeat.i(94098);
            ConcernDb enableChecker = enableChecker(EXPLAIN_QUERY_PLAN_CHECKER_NAME);
            AppMethodBeat.o(94098);
            return enableChecker;
        }

        public final ConcernDb enableAvoidSelectAllChecker() {
            AppMethodBeat.i(94099);
            ConcernDb enableChecker = enableChecker(AVOID_SELECT_ALL_CHECKER_NAME);
            AppMethodBeat.o(94099);
            return enableChecker;
        }

        public final ConcernDb enableWithoutRowIdBetterChecker() {
            AppMethodBeat.i(94100);
            ConcernDb enableChecker = enableChecker(WITHOUT_ROWID_BETTER_CHECKER_NAME);
            AppMethodBeat.o(94100);
            return enableChecker;
        }

        public final ConcernDb enableAvoidAutoIncrementChecker() {
            AppMethodBeat.i(94101);
            ConcernDb enableChecker = enableChecker(AVOID_AUTO_INCREMENT_CHECKER_NAME);
            AppMethodBeat.o(94101);
            return enableChecker;
        }

        public final ConcernDb enablePreparedStatementBetterChecker() {
            AppMethodBeat.i(94102);
            ConcernDb enableChecker = enableChecker(PREPARED_STATEMENT_BETTER_CHECKER_NAME);
            AppMethodBeat.o(94102);
            return enableChecker;
        }

        public final ConcernDb enableRedundantIndexChecker() {
            AppMethodBeat.i(94103);
            ConcernDb enableChecker = enableChecker(REDUNDANT_INDEX_CHECKER_NAME);
            AppMethodBeat.o(94103);
            return enableChecker;
        }

        public final List<String> getEnableCheckerList() {
            return this.mEnableCheckerList;
        }

        private ConcernDb enableChecker(String str) {
            AppMethodBeat.i(94104);
            this.mEnableCheckerList.add(str);
            AppMethodBeat.o(94104);
            return this;
        }
    }

    public SQLiteLintConfig(SqlExecutionCallbackMode sqlExecutionCallbackMode) {
        AppMethodBeat.i(94106);
        SQLiteLint.setSqlExecutionCallbackMode(sqlExecutionCallbackMode);
        AppMethodBeat.o(94106);
    }

    public final void addConcernDB(ConcernDb concernDb) {
        AppMethodBeat.i(94107);
        if (concernDb == null) {
            AppMethodBeat.o(94107);
        } else if (concernDb.mInstallEnv == null) {
            AppMethodBeat.o(94107);
        } else {
            String concernedDbPath = concernDb.mInstallEnv.getConcernedDbPath();
            if (TextUtils.isEmpty(concernedDbPath)) {
                AppMethodBeat.o(94107);
                return;
            }
            for (int i = 0; i < this.sConcernDbList.size(); i++) {
                if (concernedDbPath.equals(concernDb.mInstallEnv.getConcernedDbPath())) {
                    AppMethodBeat.o(94107);
                    return;
                }
            }
            this.sConcernDbList.add(concernDb);
            AppMethodBeat.o(94107);
        }
    }

    public final List<ConcernDb> getConcernDbList() {
        return this.sConcernDbList;
    }
}
