package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.List;

public final class zzfc extends zzhh {
    private final zzfd zzaig = new zzfd(this, getContext(), "google_app_measurement_local.db");
    private boolean zzaih;

    zzfc(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(68802);
        AppMethodBeat.o(68802);
    }

    @VisibleForTesting
    private final SQLiteDatabase getWritableDatabase() {
        AppMethodBeat.i(68809);
        if (this.zzaih) {
            AppMethodBeat.o(68809);
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzaig.getWritableDatabase();
        if (writableDatabase == null) {
            this.zzaih = true;
            AppMethodBeat.o(68809);
            return null;
        }
        AppMethodBeat.o(68809);
        return writableDatabase;
    }

    private final boolean zza(int i, byte[] bArr) {
        AppMethodBeat.i(68804);
        zzab();
        if (this.zzaih) {
            AppMethodBeat.o(68804);
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 5;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < 5) {
                SQLiteDatabase sQLiteDatabase = null;
                Cursor cursor = null;
                try {
                    sQLiteDatabase = getWritableDatabase();
                    if (sQLiteDatabase == null) {
                        this.zzaih = true;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        AppMethodBeat.o(68804);
                        return false;
                    }
                    sQLiteDatabase.beginTransaction();
                    long j = 0;
                    cursor = sQLiteDatabase.rawQuery("select count(1) from messages", null);
                    if (cursor != null && cursor.moveToFirst()) {
                        j = cursor.getLong(0);
                    }
                    if (j >= 100000) {
                        zzge().zzim().log("Data loss, local db full");
                        j = (100000 - j) + 1;
                        long delete = (long) sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j)});
                        if (delete != j) {
                            zzge().zzim().zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j), Long.valueOf(delete), Long.valueOf(j - delete));
                        }
                    }
                    sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    AppMethodBeat.o(68804);
                    return true;
                } catch (SQLiteFullException e) {
                    zzge().zzim().zzg("Error writing entry to local database", e);
                    this.zzaih = true;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                } catch (SQLiteDatabaseLockedException e2) {
                    SystemClock.sleep((long) i2);
                    i2 += 20;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                } catch (SQLiteException e3) {
                    if (sQLiteDatabase != null) {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                    zzge().zzim().zzg("Error writing entry to local database", e3);
                    this.zzaih = true;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    AppMethodBeat.o(68804);
                }
            } else {
                zzge().zzip().log("Failed to write entry to local database");
                AppMethodBeat.o(68804);
                return false;
            }
            i3 = i4 + 1;
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(68820);
        Context context = super.getContext();
        AppMethodBeat.o(68820);
        return context;
    }

    public final void resetAnalyticsData() {
        AppMethodBeat.i(68803);
        zzab();
        try {
            int delete = getWritableDatabase().delete("messages", null, null) + 0;
            if (delete > 0) {
                zzge().zzit().zzg("Reset local analytics data. records", Integer.valueOf(delete));
            }
            AppMethodBeat.o(68803);
        } catch (SQLiteException e) {
            zzge().zzim().zzg("Error resetting local analytics data. error", e);
            AppMethodBeat.o(68803);
        }
    }

    public final boolean zza(zzeu zzeu) {
        AppMethodBeat.i(68805);
        Parcel obtain = Parcel.obtain();
        zzeu.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            zzge().zzip().log("Event is too long for local database. Sending event directly to service");
            AppMethodBeat.o(68805);
            return false;
        }
        boolean zza = zza(0, marshall);
        AppMethodBeat.o(68805);
        return zza;
    }

    public final boolean zza(zzjx zzjx) {
        AppMethodBeat.i(68806);
        Parcel obtain = Parcel.obtain();
        zzjx.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            zzge().zzip().log("User property too long for local database. Sending directly to service");
            AppMethodBeat.o(68806);
            return false;
        }
        boolean zza = zza(1, marshall);
        AppMethodBeat.o(68806);
        return zza;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(68812);
        super.zzab();
        AppMethodBeat.o(68812);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(68819);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(68819);
        return zzbt;
    }

    public final boolean zzc(zzed zzed) {
        AppMethodBeat.i(68807);
        zzgb();
        byte[] zza = zzka.zza((Parcelable) zzed);
        if (zza.length > WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            zzge().zzip().log("Conditional user property too long for local database. Sending directly to service");
            AppMethodBeat.o(68807);
            return false;
        }
        boolean zza2 = zza(2, zza);
        AppMethodBeat.o(68807);
        return zza2;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(68810);
        super.zzfr();
        AppMethodBeat.o(68810);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(68811);
        super.zzfs();
        AppMethodBeat.o(68811);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(68813);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(68813);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(68814);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(68814);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(68815);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(68815);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(68816);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(68816);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(68817);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(68817);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(68818);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(68818);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(68821);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(68821);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(68822);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(68822);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(68823);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(68823);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(68824);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(68824);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(68825);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(68825);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(68826);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(68826);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(68827);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(68827);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(68828);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(68828);
        return zzgg;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x00d2 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010d A:{SYNTHETIC, Splitter:B:68:0x010d} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x00d2 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010d A:{SYNTHETIC, Splitter:B:68:0x010d} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<AbstractSafeParcelable> zzp(int i) {
        Object e;
        Cursor cursor;
        int i2;
        Throwable th;
        AppMethodBeat.i(68808);
        zzab();
        if (this.zzaih) {
            AppMethodBeat.o(68808);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (getContext().getDatabasePath("google_app_measurement_local.db").exists()) {
            int i3 = 5;
            int i4 = 0;
            while (i4 < 5) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    if (writableDatabase == null) {
                        try {
                            this.zzaih = true;
                            if (writableDatabase != null) {
                                writableDatabase.close();
                            }
                            AppMethodBeat.o(68808);
                            return null;
                        } catch (SQLiteFullException e2) {
                            e = e2;
                            cursor = null;
                            sQLiteDatabase = writableDatabase;
                        } catch (SQLiteDatabaseLockedException e3) {
                            cursor = null;
                            sQLiteDatabase = writableDatabase;
                            SystemClock.sleep((long) i3);
                            i2 = i3 + 20;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            i4++;
                            i3 = i2;
                        } catch (SQLiteException e4) {
                            e = e4;
                            cursor = null;
                            sQLiteDatabase = writableDatabase;
                            if (sQLiteDatabase != null) {
                            }
                            zzge().zzim().zzg("Error reading entries from local database", e);
                            this.zzaih = true;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            i2 = i3;
                            i4++;
                            i3 = i2;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = null;
                            sQLiteDatabase = writableDatabase;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            AppMethodBeat.o(68808);
                            throw th;
                        }
                    }
                    writableDatabase.beginTransaction();
                    cursor = writableDatabase.query("messages", new String[]{"rowid", "type", "entry"}, null, null, null, null, "rowid asc", Integer.toString(100));
                    long j = -1;
                    while (cursor.moveToNext()) {
                        try {
                            j = cursor.getLong(0);
                            int i5 = cursor.getInt(1);
                            byte[] blob = cursor.getBlob(2);
                            Parcel obtain;
                            if (i5 == 0) {
                                Parcel obtain2 = Parcel.obtain();
                                try {
                                    obtain2.unmarshall(blob, 0, blob.length);
                                    obtain2.setDataPosition(0);
                                    zzeu zzeu = (zzeu) zzeu.CREATOR.createFromParcel(obtain2);
                                    obtain2.recycle();
                                    if (zzeu != null) {
                                        arrayList.add(zzeu);
                                    }
                                } catch (ParseException e5) {
                                    zzge().zzim().log("Failed to load event from local database");
                                    obtain2.recycle();
                                } catch (Throwable th3) {
                                    obtain2.recycle();
                                    AppMethodBeat.o(68808);
                                }
                            } else if (i5 == 1) {
                                obtain = Parcel.obtain();
                                try {
                                    obtain.unmarshall(blob, 0, blob.length);
                                    obtain.setDataPosition(0);
                                    e = (zzjx) zzjx.CREATOR.createFromParcel(obtain);
                                    obtain.recycle();
                                } catch (ParseException e6) {
                                    zzge().zzim().log("Failed to load user property from local database");
                                    obtain.recycle();
                                    e = null;
                                } catch (Throwable th4) {
                                    obtain.recycle();
                                    AppMethodBeat.o(68808);
                                }
                                if (e != null) {
                                    arrayList.add(e);
                                }
                            } else if (i5 == 2) {
                                obtain = Parcel.obtain();
                                try {
                                    obtain.unmarshall(blob, 0, blob.length);
                                    obtain.setDataPosition(0);
                                    e = (zzed) zzed.CREATOR.createFromParcel(obtain);
                                    obtain.recycle();
                                } catch (ParseException e7) {
                                    zzge().zzim().log("Failed to load user property from local database");
                                    obtain.recycle();
                                    e = null;
                                } catch (Throwable th5) {
                                    obtain.recycle();
                                    AppMethodBeat.o(68808);
                                }
                                if (e != null) {
                                    arrayList.add(e);
                                }
                            } else {
                                zzge().zzim().log("Unknown record type in local database");
                            }
                        } catch (SQLiteFullException e8) {
                            e = e8;
                            sQLiteDatabase = writableDatabase;
                            try {
                                zzge().zzim().zzg("Error reading entries from local database", e);
                                this.zzaih = true;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                    i2 = i3;
                                    i4++;
                                    i3 = i2;
                                }
                                i2 = i3;
                                i4++;
                                i3 = i2;
                            } catch (Throwable th6) {
                                th = th6;
                                if (cursor != null) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                AppMethodBeat.o(68808);
                                throw th;
                            }
                        } catch (SQLiteDatabaseLockedException e9) {
                            sQLiteDatabase = writableDatabase;
                            SystemClock.sleep((long) i3);
                            i2 = i3 + 20;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i4++;
                            i3 = i2;
                        } catch (SQLiteException e10) {
                            e = e10;
                            sQLiteDatabase = writableDatabase;
                            if (sQLiteDatabase != null) {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            }
                            zzge().zzim().zzg("Error reading entries from local database", e);
                            this.zzaih = true;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                                i2 = i3;
                                i4++;
                                i3 = i2;
                            }
                            i2 = i3;
                            i4++;
                            i3 = i2;
                        } catch (Throwable th7) {
                            th = th7;
                            sQLiteDatabase = writableDatabase;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            AppMethodBeat.o(68808);
                            throw th;
                        }
                    }
                    if (writableDatabase.delete("messages", "rowid <= ?", new String[]{Long.toString(j)}) < arrayList.size()) {
                        zzge().zzim().log("Fewer entries removed from local database than expected");
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    AppMethodBeat.o(68808);
                    return arrayList;
                } catch (SQLiteFullException e11) {
                    SQLiteFullException e12 = e11;
                    cursor = null;
                } catch (SQLiteDatabaseLockedException e13) {
                    cursor = null;
                    SystemClock.sleep((long) i3);
                    i2 = i3 + 20;
                    if (cursor != null) {
                    }
                    if (sQLiteDatabase != null) {
                    }
                    i4++;
                    i3 = i2;
                } catch (SQLiteException e14) {
                    SQLiteException e15 = e14;
                    cursor = null;
                    if (sQLiteDatabase != null) {
                    }
                    zzge().zzim().zzg("Error reading entries from local database", e12);
                    this.zzaih = true;
                    if (cursor != null) {
                    }
                    if (sQLiteDatabase != null) {
                    }
                    i2 = i3;
                    i4++;
                    i3 = i2;
                } catch (Throwable th62) {
                    th = th62;
                    cursor = null;
                    if (cursor != null) {
                    }
                    if (sQLiteDatabase != null) {
                    }
                    AppMethodBeat.o(68808);
                    throw th;
                }
            }
            zzge().zzip().log("Failed to read events from database in reasonable time");
            AppMethodBeat.o(68808);
            return null;
        }
        AppMethodBeat.o(68808);
        return arrayList;
    }
}
