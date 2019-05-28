package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteStatement extends SQLiteProgram {
    SQLiteStatement(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) {
        super(sQLiteDatabase, str, objArr, null);
    }

    public final void execute() {
        AppMethodBeat.i(12629);
        execute(null);
        AppMethodBeat.o(12629);
    }

    public final void execute(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12630);
        acquireReference();
        try {
            getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.o(12630);
        } catch (SQLiteException e) {
            checkCorruption(e);
            AppMethodBeat.o(12630);
            throw e;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(12630);
        }
    }

    public final int executeUpdateDelete() {
        AppMethodBeat.i(12631);
        int executeUpdateDelete = executeUpdateDelete(null);
        AppMethodBeat.o(12631);
        return executeUpdateDelete;
    }

    public final int executeUpdateDelete(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12632);
        acquireReference();
        try {
            int executeForChangedRowCount = getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.o(12632);
            return executeForChangedRowCount;
        } catch (SQLiteDatabaseCorruptException e) {
            checkCorruption(e);
            AppMethodBeat.o(12632);
            throw e;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(12632);
        }
    }

    public final long executeInsert() {
        AppMethodBeat.i(12633);
        long executeInsert = executeInsert(null);
        AppMethodBeat.o(12633);
        return executeInsert;
    }

    public final long executeInsert(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12634);
        acquireReference();
        try {
            long executeForLastInsertedRowId = getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.o(12634);
            return executeForLastInsertedRowId;
        } catch (SQLiteDatabaseCorruptException e) {
            checkCorruption(e);
            AppMethodBeat.o(12634);
            throw e;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(12634);
        }
    }

    public final long simpleQueryForLong() {
        AppMethodBeat.i(12635);
        long simpleQueryForLong = simpleQueryForLong(null);
        AppMethodBeat.o(12635);
        return simpleQueryForLong;
    }

    public final long simpleQueryForLong(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12636);
        acquireReference();
        try {
            long executeForLong = getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.o(12636);
            return executeForLong;
        } catch (SQLiteDatabaseCorruptException e) {
            checkCorruption(e);
            AppMethodBeat.o(12636);
            throw e;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(12636);
        }
    }

    public final String simpleQueryForString() {
        AppMethodBeat.i(12637);
        String simpleQueryForString = simpleQueryForString(null);
        AppMethodBeat.o(12637);
        return simpleQueryForString;
    }

    public final String simpleQueryForString(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12638);
        acquireReference();
        try {
            String executeForString = getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.o(12638);
            return executeForString;
        } catch (SQLiteDatabaseCorruptException e) {
            checkCorruption(e);
            AppMethodBeat.o(12638);
            throw e;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(12638);
        }
    }

    public final String toString() {
        AppMethodBeat.i(12639);
        String str = "SQLiteProgram: " + getSql();
        AppMethodBeat.o(12639);
        return str;
    }
}
