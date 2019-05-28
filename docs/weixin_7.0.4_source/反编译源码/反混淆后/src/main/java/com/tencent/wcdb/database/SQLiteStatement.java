package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteStatement extends SQLiteProgram {
    SQLiteStatement(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) {
        super(sQLiteDatabase, str, objArr, null);
    }

    public final void execute() {
        AppMethodBeat.m2504i(12629);
        execute(null);
        AppMethodBeat.m2505o(12629);
    }

    public final void execute(CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12630);
        acquireReference();
        try {
            getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.m2505o(12630);
        } catch (SQLiteException e) {
            checkCorruption(e);
            AppMethodBeat.m2505o(12630);
            throw e;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.m2505o(12630);
        }
    }

    public final int executeUpdateDelete() {
        AppMethodBeat.m2504i(12631);
        int executeUpdateDelete = executeUpdateDelete(null);
        AppMethodBeat.m2505o(12631);
        return executeUpdateDelete;
    }

    public final int executeUpdateDelete(CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12632);
        acquireReference();
        try {
            int executeForChangedRowCount = getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.m2505o(12632);
            return executeForChangedRowCount;
        } catch (SQLiteDatabaseCorruptException e) {
            checkCorruption(e);
            AppMethodBeat.m2505o(12632);
            throw e;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.m2505o(12632);
        }
    }

    public final long executeInsert() {
        AppMethodBeat.m2504i(12633);
        long executeInsert = executeInsert(null);
        AppMethodBeat.m2505o(12633);
        return executeInsert;
    }

    public final long executeInsert(CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12634);
        acquireReference();
        try {
            long executeForLastInsertedRowId = getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.m2505o(12634);
            return executeForLastInsertedRowId;
        } catch (SQLiteDatabaseCorruptException e) {
            checkCorruption(e);
            AppMethodBeat.m2505o(12634);
            throw e;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.m2505o(12634);
        }
    }

    public final long simpleQueryForLong() {
        AppMethodBeat.m2504i(12635);
        long simpleQueryForLong = simpleQueryForLong(null);
        AppMethodBeat.m2505o(12635);
        return simpleQueryForLong;
    }

    public final long simpleQueryForLong(CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12636);
        acquireReference();
        try {
            long executeForLong = getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.m2505o(12636);
            return executeForLong;
        } catch (SQLiteDatabaseCorruptException e) {
            checkCorruption(e);
            AppMethodBeat.m2505o(12636);
            throw e;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.m2505o(12636);
        }
    }

    public final String simpleQueryForString() {
        AppMethodBeat.m2504i(12637);
        String simpleQueryForString = simpleQueryForString(null);
        AppMethodBeat.m2505o(12637);
        return simpleQueryForString;
    }

    public final String simpleQueryForString(CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12638);
        acquireReference();
        try {
            String executeForString = getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.m2505o(12638);
            return executeForString;
        } catch (SQLiteDatabaseCorruptException e) {
            checkCorruption(e);
            AppMethodBeat.m2505o(12638);
            throw e;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.m2505o(12638);
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(12639);
        String str = "SQLiteProgram: " + getSql();
        AppMethodBeat.m2505o(12639);
        return str;
    }
}
