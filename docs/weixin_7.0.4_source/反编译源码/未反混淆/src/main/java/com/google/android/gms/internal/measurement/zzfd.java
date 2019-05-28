package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
final class zzfd extends SQLiteOpenHelper {
    private final /* synthetic */ zzfc zzaii;

    zzfd(zzfc zzfc, Context context, String str) {
        this.zzaii = zzfc;
        super(context, str, null, 1);
    }

    public final SQLiteDatabase getWritableDatabase() {
        AppMethodBeat.i(68829);
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = super.getWritableDatabase();
            AppMethodBeat.o(68829);
            return writableDatabase;
        } catch (SQLiteDatabaseLockedException e) {
            AppMethodBeat.o(68829);
            throw e;
        } catch (SQLiteException e2) {
            this.zzaii.zzge().zzim().log("Opening the local database failed, dropping and recreating it");
            String str = "google_app_measurement_local.db";
            if (!this.zzaii.getContext().getDatabasePath(str).delete()) {
                this.zzaii.zzge().zzim().zzg("Failed to delete corrupted local db file", str);
            }
            try {
                writableDatabase = super.getWritableDatabase();
                AppMethodBeat.o(68829);
                return writableDatabase;
            } catch (SQLiteException e3) {
                this.zzaii.zzge().zzim().zzg("Failed to open local database. Events will bypass local storage", e3);
                AppMethodBeat.o(68829);
                return null;
            }
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(68831);
        zzei.zza(this.zzaii.zzge(), sQLiteDatabase);
        AppMethodBeat.o(68831);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        Cursor cursor = null;
        AppMethodBeat.i(68830);
        if (VERSION.SDK_INT < 15) {
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = rawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    AppMethodBeat.o(68830);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        zzei.zza(this.zzaii.zzge(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
        AppMethodBeat.o(68830);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
