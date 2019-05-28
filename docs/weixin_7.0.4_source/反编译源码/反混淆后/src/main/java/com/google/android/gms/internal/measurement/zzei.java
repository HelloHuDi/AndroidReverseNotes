package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.p057v4.p065f.C6197a;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzei extends zzjq {
    private static final String[] zzaev = new String[]{"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};
    private static final String[] zzaew = new String[]{C8741b.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzaex = new String[]{"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;"};
    private static final String[] zzaey = new String[]{"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzaez = new String[]{"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzafa = new String[]{"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzel zzafb = new zzel(this, getContext(), "google_app_measurement.db");
    private final zzjm zzafc = new zzjm(zzbt());

    zzei(zzjr zzjr) {
        super(zzjr);
        AppMethodBeat.m2504i(68638);
        AppMethodBeat.m2505o(68638);
    }

    private final long zza(String str, String[] strArr) {
        AppMethodBeat.m2504i(68642);
        Cursor cursor = null;
        SQLiteException sQLiteException;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(68642);
                return j;
            }
            sQLiteException = new SQLiteException("Database returned empty set");
            AppMethodBeat.m2505o(68642);
            throw sQLiteException;
        } catch (SQLiteException sQLiteException2) {
            zzge().zzim().zze("Database error", str, sQLiteException2);
            AppMethodBeat.m2505o(68642);
            throw sQLiteException2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(68642);
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        AppMethodBeat.m2504i(68643);
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(68643);
            } else {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(68643);
            }
            return j;
        } catch (SQLiteException e) {
            zzge().zzim().zze("Database error", str, e);
            AppMethodBeat.m2505o(68643);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(68643);
        }
    }

    @VisibleForTesting
    private final Object zza(Cursor cursor, int i) {
        AppMethodBeat.m2504i(68676);
        int type = cursor.getType(i);
        switch (type) {
            case 0:
                zzge().zzim().log("Loaded invalid null value from database");
                AppMethodBeat.m2505o(68676);
                return null;
            case 1:
                Long valueOf = Long.valueOf(cursor.getLong(i));
                AppMethodBeat.m2505o(68676);
                return valueOf;
            case 2:
                Double valueOf2 = Double.valueOf(cursor.getDouble(i));
                AppMethodBeat.m2505o(68676);
                return valueOf2;
            case 3:
                String string = cursor.getString(i);
                AppMethodBeat.m2505o(68676);
                return string;
            case 4:
                zzge().zzim().log("Loaded invalid blob type value, ignoring it");
                AppMethodBeat.m2505o(68676);
                return null;
            default:
                zzge().zzim().zzg("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                AppMethodBeat.m2505o(68676);
                return null;
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        AppMethodBeat.m2504i(68675);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
            AppMethodBeat.m2505o(68675);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
            AppMethodBeat.m2505o(68675);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
            AppMethodBeat.m2505o(68675);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid value type");
            AppMethodBeat.m2505o(68675);
            throw illegalArgumentException;
        }
    }

    static void zza(zzfg zzfg, SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.m2504i(68693);
        if (zzfg == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Monitor must not be null");
            AppMethodBeat.m2505o(68693);
            throw illegalArgumentException;
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            zzfg.zzip().log("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzfg.zzip().log("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzfg.zzip().log("Failed to turn on database read permission for owner");
        }
        if (!file.setWritable(true, true)) {
            zzfg.zzip().log("Failed to turn on database write permission for owner");
        }
        AppMethodBeat.m2505o(68693);
    }

    static void zza(zzfg zzfg, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) {
        SQLiteException e;
        int i = 0;
        AppMethodBeat.m2504i(68692);
        IllegalArgumentException illegalArgumentException;
        if (zzfg == null) {
            illegalArgumentException = new IllegalArgumentException("Monitor must not be null");
            AppMethodBeat.m2505o(68692);
            throw illegalArgumentException;
        }
        if (!zza(zzfg, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        if (zzfg == null) {
            try {
                illegalArgumentException = new IllegalArgumentException("Monitor must not be null");
                AppMethodBeat.m2505o(68692);
                throw illegalArgumentException;
            } catch (SQLiteException e2) {
                zzfg.zzim().zzg("Failed to verify columns on table that was just created", str);
                AppMethodBeat.m2505o(68692);
                throw e2;
            }
        }
        Set zzb = zzb(sQLiteDatabase, str);
        String[] split = str3.split(",");
        int length = split.length;
        int i2 = 0;
        while (i2 < length) {
            Object obj = split[i2];
            if (zzb.remove(obj)) {
                i2++;
            } else {
                e2 = new SQLiteException(new StringBuilder((String.valueOf(str).length() + 35) + String.valueOf(obj).length()).append("Table ").append(str).append(" is missing required column: ").append(obj).toString());
                AppMethodBeat.m2505o(68692);
                throw e2;
            }
        }
        if (strArr != null) {
            while (i < strArr.length) {
                if (!zzb.remove(strArr[i])) {
                    sQLiteDatabase.execSQL(strArr[i + 1]);
                }
                i += 2;
            }
        }
        if (!zzb.isEmpty()) {
            zzfg.zzip().zze("Table has extra columns. table, columns", str, TextUtils.join(", ", zzb));
        }
        AppMethodBeat.m2505o(68692);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zza(zzfg zzfg, SQLiteDatabase sQLiteDatabase, String str) {
        Cursor query;
        Object e;
        Throwable th;
        Cursor cursor = null;
        AppMethodBeat.m2504i(68690);
        if (zzfg == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Monitor must not be null");
            AppMethodBeat.m2505o(68690);
            throw illegalArgumentException;
        }
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            try {
                boolean moveToFirst = query.moveToFirst();
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68690);
                return moveToFirst;
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
            }
            AppMethodBeat.m2505o(68690);
            throw th;
        }
        try {
            zzfg.zzip().zze("Error querying for table", str, e);
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(68690);
            return false;
        } catch (Throwable th3) {
            th = th3;
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(68690);
            throw th;
        }
    }

    private final boolean zza(String str, int i, zzke zzke) {
        AppMethodBeat.m2504i(68669);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzke);
        if (TextUtils.isEmpty(zzke.zzarq)) {
            zzge().zzip().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzfg.zzbm(str), Integer.valueOf(i), String.valueOf(zzke.zzarp));
            AppMethodBeat.m2505o(68669);
            return false;
        }
        try {
            byte[] bArr = new byte[zzke.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzke.zza(zzb);
            zzb.zzve();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzke.zzarp);
            contentValues.put("event_name", zzke.zzarq);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    zzge().zzim().zzg("Failed to insert event filter (got -1). appId", zzfg.zzbm(str));
                }
                AppMethodBeat.m2505o(68669);
                return true;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing event filter. appId", zzfg.zzbm(str), e);
                AppMethodBeat.m2505o(68669);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Configuration loss. Failed to serialize event filter. appId", zzfg.zzbm(str), e2);
            AppMethodBeat.m2505o(68669);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzkh zzkh) {
        AppMethodBeat.m2504i(68670);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzkh);
        if (TextUtils.isEmpty(zzkh.zzasf)) {
            zzge().zzip().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzfg.zzbm(str), Integer.valueOf(i), String.valueOf(zzkh.zzarp));
            AppMethodBeat.m2505o(68670);
            return false;
        }
        try {
            byte[] bArr = new byte[zzkh.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkh.zza(zzb);
            zzb.zzve();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzkh.zzarp);
            contentValues.put("property_name", zzkh.zzasf);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) == -1) {
                    zzge().zzim().zzg("Failed to insert property filter (got -1). appId", zzfg.zzbm(str));
                    AppMethodBeat.m2505o(68670);
                    return false;
                }
                AppMethodBeat.m2505o(68670);
                return true;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing property filter. appId", zzfg.zzbm(str), e);
                AppMethodBeat.m2505o(68670);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Configuration loss. Failed to serialize property filter. appId", zzfg.zzbm(str), e2);
            AppMethodBeat.m2505o(68670);
            return false;
        }
    }

    private final boolean zza(String str, List<Integer> list) {
        AppMethodBeat.m2504i(68673);
        Preconditions.checkNotEmpty(str);
        zzch();
        zzab();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            if (zza("select count(1) from audience_filter_values where app_id=?", new String[]{str}) <= ((long) Math.max(0, Math.min(2000, zzgg().zzb(str, zzew.zzahn))))) {
                AppMethodBeat.m2505o(68673);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = (Integer) list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    AppMethodBeat.m2505o(68673);
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            join = new StringBuilder(String.valueOf(join).length() + 2).append("(").append(join).append(")").toString();
            if (writableDatabase.delete("audience_filter_values", new StringBuilder(String.valueOf(join).length() + 140).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(join).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(r5)}) > 0) {
                AppMethodBeat.m2505o(68673);
                return true;
            }
            AppMethodBeat.m2505o(68673);
            return false;
        } catch (SQLiteException e) {
            zzge().zzim().zze("Database error querying filters. appId", zzfg.zzbm(str), e);
            AppMethodBeat.m2505o(68673);
            return false;
        }
    }

    private static Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        AppMethodBeat.m2504i(68691);
        Set<String> hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
            AppMethodBeat.m2505o(68691);
        }
    }

    private final boolean zzhv() {
        AppMethodBeat.m2504i(68689);
        boolean exists = getContext().getDatabasePath("google_app_measurement.db").exists();
        AppMethodBeat.m2505o(68689);
        return exists;
    }

    public final void beginTransaction() {
        AppMethodBeat.m2504i(68639);
        zzch();
        getWritableDatabase().beginTransaction();
        AppMethodBeat.m2505o(68639);
    }

    public final void endTransaction() {
        AppMethodBeat.m2504i(68641);
        zzch();
        getWritableDatabase().endTransaction();
        AppMethodBeat.m2505o(68641);
    }

    /* Access modifiers changed, original: final */
    @VisibleForTesting
    public final SQLiteDatabase getWritableDatabase() {
        AppMethodBeat.m2504i(68644);
        zzab();
        try {
            SQLiteDatabase writableDatabase = this.zzafb.getWritableDatabase();
            AppMethodBeat.m2505o(68644);
            return writableDatabase;
        } catch (SQLiteException e) {
            zzge().zzip().zzg("Error opening database", e);
            AppMethodBeat.m2505o(68644);
            throw e;
        }
    }

    public final void setTransactionSuccessful() {
        AppMethodBeat.m2504i(68640);
        zzch();
        getWritableDatabase().setTransactionSuccessful();
        AppMethodBeat.m2505o(68640);
    }

    public final long zza(zzkq zzkq) {
        AppMethodBeat.m2504i(68680);
        zzab();
        zzch();
        Preconditions.checkNotNull(zzkq);
        Preconditions.checkNotEmpty(zzkq.zzti);
        try {
            long j;
            byte[] bArr = new byte[zzkq.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkq.zza(zzb);
            zzb.zzve();
            zzka zzgb = zzgb();
            Preconditions.checkNotNull(bArr);
            zzgb.zzab();
            MessageDigest messageDigest = zzka.getMessageDigest("MD5");
            if (messageDigest == null) {
                zzgb.zzge().zzim().log("Failed to get MD5");
                j = 0;
            } else {
                j = zzka.zzc(messageDigest.digest(bArr));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzkq.zzti);
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("metadata", bArr);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                AppMethodBeat.m2505o(68680);
                return j;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing raw event metadata. appId", zzfg.zzbm(zzkq.zzti), e);
                AppMethodBeat.m2505o(68680);
                throw e;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Data loss. Failed to serialize event metadata. appId", zzfg.zzbm(zzkq.zzti), e2);
            AppMethodBeat.m2505o(68680);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Pair<zzkn, Long> zza(String str, Long l) {
        Cursor rawQuery;
        Object e;
        Throwable th;
        Pair<zzkn, Long> pair = null;
        AppMethodBeat.m2504i(68686);
        zzab();
        zzch();
        try {
            rawQuery = getWritableDatabase().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
            try {
                if (rawQuery.moveToFirst()) {
                    byte[] blob = rawQuery.getBlob(0);
                    Long valueOf = Long.valueOf(rawQuery.getLong(1));
                    zzabv zza = zzabv.zza(blob, 0, blob.length);
                    zzkn zzkn = new zzkn();
                    try {
                        zzkn.zzb(zza);
                        pair = Pair.create(zzkn, valueOf);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        AppMethodBeat.m2505o(68686);
                    } catch (IOException e2) {
                        zzge().zzim().zzd("Failed to merge main event. appId, eventId", zzfg.zzbm(str), l, e2);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        AppMethodBeat.m2505o(68686);
                    }
                } else {
                    zzge().zzit().log("Main event not found");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.m2505o(68686);
                }
            } catch (SQLiteException e3) {
                e = e3;
            }
        } catch (SQLiteException e4) {
            e = e4;
            rawQuery = pair;
        } catch (Throwable th2) {
            th = th2;
            rawQuery = pair;
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.m2505o(68686);
            throw th;
        }
        return pair;
        try {
            zzge().zzim().zzg("Error selecting main event", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.m2505o(68686);
            return pair;
        } catch (Throwable th3) {
            th = th3;
            if (rawQuery != null) {
            }
            AppMethodBeat.m2505o(68686);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final zzej zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Object e;
        Throwable th;
        AppMethodBeat.m2504i(68660);
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        String[] strArr = new String[]{str};
        zzej zzej = new zzej();
        Cursor query;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            query = writableDatabase.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        zzej.zzafe = query.getLong(1);
                        zzej.zzafd = query.getLong(2);
                        zzej.zzaff = query.getLong(3);
                        zzej.zzafg = query.getLong(4);
                        zzej.zzafh = query.getLong(5);
                    }
                    if (z) {
                        zzej.zzafe++;
                    }
                    if (z2) {
                        zzej.zzafd++;
                    }
                    if (z3) {
                        zzej.zzaff++;
                    }
                    if (z4) {
                        zzej.zzafg++;
                    }
                    if (z5) {
                        zzej.zzafh++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(zzej.zzafd));
                    contentValues.put("daily_events_count", Long.valueOf(zzej.zzafe));
                    contentValues.put("daily_conversions_count", Long.valueOf(zzej.zzaff));
                    contentValues.put("daily_error_events_count", Long.valueOf(zzej.zzafg));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(zzej.zzafh));
                    writableDatabase.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68660);
                    return zzej;
                }
                zzge().zzip().zzg("Not updating daily counts, app is not known. appId", zzfg.zzbm(str));
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68660);
                return zzej;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzge().zzim().zze("Error updating daily counts. appId", zzfg.zzbm(str), e);
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68660);
                    return zzej;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68660);
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(68660);
            throw th;
        }
    }

    public final void zza(zzdy zzdy) {
        AppMethodBeat.m2504i(68658);
        Preconditions.checkNotNull(zzdy);
        zzab();
        zzch();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzdy.zzah());
        contentValues.put("app_instance_id", zzdy.getAppInstanceId());
        contentValues.put("gmp_app_id", zzdy.getGmpAppId());
        contentValues.put("resettable_device_id_hash", zzdy.zzgi());
        contentValues.put("last_bundle_index", Long.valueOf(zzdy.zzgq()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzdy.zzgk()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzdy.zzgl()));
        contentValues.put("app_version", zzdy.zzag());
        contentValues.put("app_store", zzdy.zzgn());
        contentValues.put("gmp_version", Long.valueOf(zzdy.zzgo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzdy.zzgp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzdy.isMeasurementEnabled()));
        contentValues.put("day", Long.valueOf(zzdy.zzgu()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzdy.zzgv()));
        contentValues.put("daily_events_count", Long.valueOf(zzdy.zzgw()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzdy.zzgx()));
        contentValues.put("config_fetched_time", Long.valueOf(zzdy.zzgr()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzdy.zzgs()));
        contentValues.put("app_version_int", Long.valueOf(zzdy.zzgm()));
        contentValues.put("firebase_instance_id", zzdy.zzgj());
        contentValues.put("daily_error_events_count", Long.valueOf(zzdy.zzgz()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzdy.zzgy()));
        contentValues.put("health_monitor_sample", zzdy.zzha());
        contentValues.put("android_id", Long.valueOf(zzdy.zzhc()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzdy.zzhd()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzdy.zzhe()));
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (((long) writableDatabase.update("apps", contentValues, "app_id = ?", new String[]{zzdy.zzah()})) == 0 && writableDatabase.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update app (got -1). appId", zzfg.zzbm(zzdy.zzah()));
            }
            AppMethodBeat.m2505o(68658);
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing app. appId", zzfg.zzbm(zzdy.zzah()), e);
            AppMethodBeat.m2505o(68658);
        }
    }

    public final void zza(zzeq zzeq) {
        Long l = null;
        AppMethodBeat.m2504i(68646);
        Preconditions.checkNotNull(zzeq);
        zzab();
        zzch();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzeq.zzti);
        contentValues.put("name", zzeq.name);
        contentValues.put("lifetime_count", Long.valueOf(zzeq.zzafr));
        contentValues.put("current_bundle_count", Long.valueOf(zzeq.zzafs));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzeq.zzaft));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzeq.zzafu));
        contentValues.put("last_sampled_complex_event_id", zzeq.zzafv);
        contentValues.put("last_sampling_rate", zzeq.zzafw);
        if (zzeq.zzafx != null && zzeq.zzafx.booleanValue()) {
            l = Long.valueOf(1);
        }
        contentValues.put("last_exempt_from_sampling", l);
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update event aggregates (got -1). appId", zzfg.zzbm(zzeq.zzti));
            }
            AppMethodBeat.m2505o(68646);
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing event aggregates. appId", zzfg.zzbm(zzeq.zzti), e);
            AppMethodBeat.m2505o(68646);
        }
    }

    /* Access modifiers changed, original: final */
    public final void zza(String str, zzkd[] zzkdArr) {
        int i = 0;
        AppMethodBeat.m2504i(68668);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzkdArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            int i2;
            zzch();
            zzab();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            writableDatabase2.delete("property_filters", "app_id=?", new String[]{str});
            writableDatabase2.delete("event_filters", "app_id=?", new String[]{str});
            for (Object obj : zzkdArr) {
                zzch();
                zzab();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(obj);
                Preconditions.checkNotNull(obj.zzarn);
                Preconditions.checkNotNull(obj.zzarm);
                if (obj.zzarl == null) {
                    zzge().zzip().zzg("Audience with no ID. appId", zzfg.zzbm(str));
                } else {
                    int intValue = obj.zzarl.intValue();
                    for (zzke zzke : obj.zzarn) {
                        if (zzke.zzarp == null) {
                            zzge().zzip().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", zzfg.zzbm(str), obj.zzarl);
                            break;
                        }
                    }
                    for (zzkh zzkh : obj.zzarm) {
                        if (zzkh.zzarp == null) {
                            zzge().zzip().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", zzfg.zzbm(str), obj.zzarl);
                            break;
                        }
                    }
                    for (zzke zzke2 : obj.zzarn) {
                        if (!zza(str, intValue, zzke2)) {
                            i2 = 0;
                            break;
                        }
                    }
                    i2 = 1;
                    if (i2 != 0) {
                        for (zzkh zzkh2 : obj.zzarm) {
                            if (!zza(str, intValue, zzkh2)) {
                                i2 = 0;
                                break;
                            }
                        }
                    }
                    if (i2 == 0) {
                        zzch();
                        zzab();
                        Preconditions.checkNotEmpty(str);
                        SQLiteDatabase writableDatabase3 = getWritableDatabase();
                        writableDatabase3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                        writableDatabase3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                    }
                }
            }
            List arrayList = new ArrayList();
            i2 = zzkdArr.length;
            while (i < i2) {
                arrayList.add(zzkdArr[i].zzarl);
                i++;
            }
            zza(str, arrayList);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
            AppMethodBeat.m2505o(68668);
        }
    }

    public final boolean zza(zzed zzed) {
        AppMethodBeat.m2504i(68652);
        Preconditions.checkNotNull(zzed);
        zzab();
        zzch();
        if (zzh(zzed.packageName, zzed.zzaep.name) == null) {
            if (zza("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzed.packageName}) >= 1000) {
                AppMethodBeat.m2505o(68652);
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzed.packageName);
        contentValues.put(C8741b.ORIGIN, zzed.origin);
        contentValues.put("name", zzed.zzaep.name);
        zza(contentValues, "value", zzed.zzaep.getValue());
        contentValues.put("active", Boolean.valueOf(zzed.active));
        contentValues.put("trigger_event_name", zzed.triggerEventName);
        contentValues.put("trigger_timeout", Long.valueOf(zzed.triggerTimeout));
        zzgb();
        contentValues.put("timed_out_event", zzka.zza(zzed.zzaeq));
        contentValues.put("creation_timestamp", Long.valueOf(zzed.creationTimestamp));
        zzgb();
        contentValues.put("triggered_event", zzka.zza(zzed.zzaer));
        contentValues.put("triggered_timestamp", Long.valueOf(zzed.zzaep.zzaqz));
        contentValues.put("time_to_live", Long.valueOf(zzed.timeToLive));
        zzgb();
        contentValues.put("expired_event", zzka.zza(zzed.zzaes));
        try {
            if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update conditional user property (got -1)", zzfg.zzbm(zzed.packageName));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing conditional user property", zzfg.zzbm(zzed.packageName), e);
        }
        AppMethodBeat.m2505o(68652);
        return true;
    }

    public final boolean zza(zzep zzep, long j, boolean z) {
        AppMethodBeat.m2504i(68688);
        zzab();
        zzch();
        Preconditions.checkNotNull(zzep);
        Preconditions.checkNotEmpty(zzep.zzti);
        zzkn zzkn = new zzkn();
        zzkn.zzatc = Long.valueOf(zzep.zzafp);
        zzkn.zzata = new zzko[zzep.zzafq.size()];
        Iterator it = zzep.zzafq.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            zzko zzko = new zzko();
            int i2 = i + 1;
            zzkn.zzata[i] = zzko;
            zzko.name = str;
            zzgb().zza(zzko, zzep.zzafq.get(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[zzkn.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkn.zza(zzb);
            zzb.zzve();
            zzge().zzit().zze("Saving event, name, data size", zzga().zzbj(zzep.name), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzep.zzti);
            contentValues.put("name", zzep.name);
            contentValues.put(Param.TIMESTAMP, Long.valueOf(zzep.timestamp));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) == -1) {
                    zzge().zzim().zzg("Failed to insert raw event (got -1). appId", zzfg.zzbm(zzep.zzti));
                    AppMethodBeat.m2505o(68688);
                    return false;
                }
                AppMethodBeat.m2505o(68688);
                return true;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing raw event. appId", zzfg.zzbm(zzep.zzti), e);
                AppMethodBeat.m2505o(68688);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Data loss. Failed to serialize event params/data. appId", zzfg.zzbm(zzep.zzti), e2);
            AppMethodBeat.m2505o(68688);
            return false;
        }
    }

    public final boolean zza(zzjz zzjz) {
        AppMethodBeat.m2504i(68648);
        Preconditions.checkNotNull(zzjz);
        zzab();
        zzch();
        if (zzh(zzjz.zzti, zzjz.name) == null) {
            if (zzka.zzcc(zzjz.name)) {
                if (zza("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzjz.zzti}) >= 25) {
                    AppMethodBeat.m2505o(68648);
                    return false;
                }
            }
            if (zza("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzjz.zzti, zzjz.origin}) >= 25) {
                AppMethodBeat.m2505o(68648);
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzjz.zzti);
        contentValues.put(C8741b.ORIGIN, zzjz.origin);
        contentValues.put("name", zzjz.name);
        contentValues.put("set_timestamp", Long.valueOf(zzjz.zzaqz));
        zza(contentValues, "value", zzjz.value);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update user property (got -1). appId", zzfg.zzbm(zzjz.zzti));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing user property. appId", zzfg.zzbm(zzjz.zzti), e);
        }
        AppMethodBeat.m2505o(68648);
        return true;
    }

    public final boolean zza(zzkq zzkq, boolean z) {
        AppMethodBeat.m2504i(68662);
        zzab();
        zzch();
        Preconditions.checkNotNull(zzkq);
        Preconditions.checkNotEmpty(zzkq.zzti);
        Preconditions.checkNotNull(zzkq.zzatm);
        zzhp();
        long currentTimeMillis = zzbt().currentTimeMillis();
        if (zzkq.zzatm.longValue() < currentTimeMillis - zzef.zzhh() || zzkq.zzatm.longValue() > zzef.zzhh() + currentTimeMillis) {
            zzge().zzip().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzfg.zzbm(zzkq.zzti), Long.valueOf(currentTimeMillis), zzkq.zzatm);
        }
        try {
            byte[] bArr = new byte[zzkq.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkq.zza(zzb);
            zzb.zzve();
            bArr = zzgb().zza(bArr);
            zzge().zzit().zzg("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzkq.zzti);
            contentValues.put("bundle_end_timestamp", zzkq.zzatm);
            contentValues.put("data", bArr);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzkq.zzauj != null) {
                contentValues.put("retry_count", zzkq.zzauj);
            }
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) == -1) {
                    zzge().zzim().zzg("Failed to insert bundle (got -1). appId", zzfg.zzbm(zzkq.zzti));
                    AppMethodBeat.m2505o(68662);
                    return false;
                }
                AppMethodBeat.m2505o(68662);
                return true;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing bundle. appId", zzfg.zzbm(zzkq.zzti), e);
                AppMethodBeat.m2505o(68662);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Data loss. Failed to serialize bundle. appId", zzfg.zzbm(zzkq.zzti), e2);
            AppMethodBeat.m2505o(68662);
            return false;
        }
    }

    public final boolean zza(String str, Long l, long j, zzkn zzkn) {
        AppMethodBeat.m2504i(68687);
        zzab();
        zzch();
        Preconditions.checkNotNull(zzkn);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        try {
            byte[] bArr = new byte[zzkn.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkn.zza(zzb);
            zzb.zzve();
            zzge().zzit().zze("Saving complex main event, appId, data size", zzga().zzbj(str), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("event_id", l);
            contentValues.put("children_to_process", Long.valueOf(j));
            contentValues.put("main_event", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                    zzge().zzim().zzg("Failed to insert complex main event (got -1). appId", zzfg.zzbm(str));
                    AppMethodBeat.m2505o(68687);
                    return false;
                }
                AppMethodBeat.m2505o(68687);
                return true;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing complex main event. appId", zzfg.zzbm(str), e);
                AppMethodBeat.m2505o(68687);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zzd("Data loss. Failed to serialize event params/data. appId, eventId", zzfg.zzbm(str), l, e2);
            AppMethodBeat.m2505o(68687);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String zzab(long j) {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        AppMethodBeat.m2504i(68684);
        zzab();
        zzch();
        try {
            rawQuery = getWritableDatabase().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.m2505o(68684);
                } else {
                    zzge().zzit().log("No expired configs for apps with pending events");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.m2505o(68684);
                }
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = str;
        } catch (Throwable th2) {
            th = th2;
            rawQuery = str;
            if (rawQuery != null) {
            }
            AppMethodBeat.m2505o(68684);
            throw th;
        }
        return str;
        try {
            zzge().zzim().zzg("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.m2505o(68684);
            return str;
        } catch (Throwable th3) {
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.m2505o(68684);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0116  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<Pair<zzkq, Long>> zzb(String str, int i, int i2) {
        List<Pair<zzkq, Long>> arrayList;
        Object e;
        Cursor cursor;
        Throwable th;
        boolean z = true;
        AppMethodBeat.m2504i(68665);
        zzab();
        zzch();
        Preconditions.checkArgument(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkNotEmpty(str);
        Cursor query;
        try {
            query = getWritableDatabase().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        long j = query.getLong(0);
                        int length;
                        try {
                            byte[] zzb = zzgb().zzb(query.getBlob(1));
                            if (!arrayList.isEmpty() && zzb.length + i3 > i2) {
                                break;
                            }
                            zzabv zza = zzabv.zza(zzb, 0, zzb.length);
                            zzkq zzkq = new zzkq();
                            try {
                                zzkq.zzb(zza);
                                if (!query.isNull(2)) {
                                    zzkq.zzauj = Integer.valueOf(query.getInt(2));
                                }
                                length = zzb.length + i3;
                                arrayList.add(Pair.create(zzkq, Long.valueOf(j)));
                            } catch (IOException e2) {
                                zzge().zzim().zze("Failed to merge queued bundle. appId", zzfg.zzbm(str), e2);
                                length = i3;
                            }
                            if (!query.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e22) {
                            zzge().zzim().zze("Failed to unzip queued bundle. appId", zzfg.zzbm(str), e22);
                            length = i3;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68665);
                } else {
                    arrayList = Collections.emptyList();
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68665);
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
                try {
                    zzge().zzim().zze("Error querying bundles. appId", zzfg.zzbm(str), e);
                    arrayList = Collections.emptyList();
                    if (cursor != null) {
                        cursor.close();
                    }
                    AppMethodBeat.m2505o(68665);
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68665);
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(68665);
            throw th;
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0126 A:{Splitter:B:9:0x008d, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:45:0x0126, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:46:0x0127, code skipped:
            r10 = r7;
     */
    /* JADX WARNING: Missing block: B:51:0x012f, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:52:0x0130, code skipped:
            r1 = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<zzjz> zzb(String str, String str2, String str3) {
        Object obj;
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        AppMethodBeat.m2504i(68651);
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList arrayList2 = new ArrayList(3);
            arrayList2.add(str);
            StringBuilder stringBuilder = new StringBuilder("app_id=?");
            if (!TextUtils.isEmpty(str2)) {
                arrayList2.add(str2);
                stringBuilder.append(" and origin=?");
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList2.add(String.valueOf(str3).concat("*"));
                stringBuilder.append(" and name glob ?");
            }
            String[] strArr = new String[]{"name", "set_timestamp", "value", C8741b.ORIGIN};
            Cursor query = getWritableDatabase().query("user_attributes", strArr, stringBuilder.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", "1001");
            String string;
            try {
                if (query.moveToFirst()) {
                    while (arrayList.size() < 1000) {
                        String string2 = query.getString(0);
                        long j = query.getLong(1);
                        Object zza = zza(query, 2);
                        string = query.getString(3);
                        if (zza == null) {
                            zzge().zzim().zzd("(2)Read invalid user property value, ignoring it", zzfg.zzbm(str), string, str3);
                        } else {
                            arrayList.add(new zzjz(str, string, string2, j, zza));
                        }
                        if (!query.moveToNext()) {
                            break;
                        }
                        obj = string;
                    }
                    zzge().zzim().zzg("Read more than the max allowed user properties, ignoring excess", Integer.valueOf(1000));
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68651);
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68651);
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                obj = string;
            } catch (Throwable th2) {
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                zzge().zzim().zzd("(2)Error querying user properties", zzfg.zzbm(str), obj, e);
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(68651);
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                AppMethodBeat.m2505o(68651);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            AppMethodBeat.m2505o(68651);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x018f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<zzed> zzb(String str, String[] strArr) {
        Cursor query;
        Object e;
        Cursor cursor;
        Throwable th;
        AppMethodBeat.m2504i(68656);
        zzab();
        zzch();
        ArrayList arrayList = new ArrayList();
        try {
            query = getWritableDatabase().query("conditional_properties", new String[]{"app_id", C8741b.ORIGIN, "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
            try {
                if (query.moveToFirst()) {
                    do {
                        if (arrayList.size() >= 1000) {
                            zzge().zzim().zzg("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf(1000));
                            break;
                        }
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object zza = zza(query, 3);
                        boolean z = query.getInt(4) != 0;
                        String string4 = query.getString(5);
                        long j = query.getLong(6);
                        zzeu zzeu = (zzeu) zzgb().zza(query.getBlob(7), zzeu.CREATOR);
                        long j2 = query.getLong(8);
                        zzeu zzeu2 = (zzeu) zzgb().zza(query.getBlob(9), zzeu.CREATOR);
                        long j3 = query.getLong(10);
                        ArrayList arrayList2 = arrayList;
                        arrayList2.add(new zzed(string, string2, new zzjx(string3, j3, zza, string2), j2, z, string4, zzeu, j, zzeu2, query.getLong(11), (zzeu) zzgb().zza(query.getBlob(12), zzeu.CREATOR)));
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68656);
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68656);
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                }
                AppMethodBeat.m2505o(68656);
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(68656);
            throw th;
        }
        try {
            zzge().zzim().zzg("Error querying conditional user property value", e);
            List emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(68656);
            return emptyList;
        } catch (Throwable th4) {
            th = th4;
            query = cursor;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<zzjz> zzbb(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        AppMethodBeat.m2504i(68650);
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        ArrayList arrayList = new ArrayList();
        try {
            Cursor query = getWritableDatabase().query("user_attributes", new String[]{"name", C8741b.ORIGIN, "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        long j = query.getLong(2);
                        Object zza = zza(query, 3);
                        if (zza == null) {
                            zzge().zzim().zzg("Read invalid user property value, ignoring it. appId", zzfg.zzbm(str));
                        } else {
                            arrayList.add(new zzjz(str, string2, string, j, zza));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68650);
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68650);
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
                if (cursor2 != null) {
                }
                AppMethodBeat.m2505o(68650);
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            AppMethodBeat.m2505o(68650);
            throw th;
        }
        try {
            zzge().zzim().zze("Error querying user properties. appId", zzfg.zzbm(str), e);
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(68650);
            return null;
        } catch (Throwable th4) {
            th = th4;
            cursor2 = cursor;
            if (cursor2 != null) {
            }
            AppMethodBeat.m2505o(68650);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0251  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final zzdy zzbc(String str) {
        Cursor query;
        Object e;
        Throwable th;
        AppMethodBeat.m2504i(68657);
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        try {
            query = getWritableDatabase().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    zzdy zzdy = new zzdy(this.zzajp.zzla(), str);
                    zzdy.zzal(query.getString(0));
                    zzdy.zzam(query.getString(1));
                    zzdy.zzan(query.getString(2));
                    zzdy.zzr(query.getLong(3));
                    zzdy.zzm(query.getLong(4));
                    zzdy.zzn(query.getLong(5));
                    zzdy.setAppVersion(query.getString(6));
                    zzdy.zzap(query.getString(7));
                    zzdy.zzp(query.getLong(8));
                    zzdy.zzq(query.getLong(9));
                    boolean z = query.isNull(10) || query.getInt(10) != 0;
                    zzdy.setMeasurementEnabled(z);
                    zzdy.zzu(query.getLong(11));
                    zzdy.zzv(query.getLong(12));
                    zzdy.zzw(query.getLong(13));
                    zzdy.zzx(query.getLong(14));
                    zzdy.zzs(query.getLong(15));
                    zzdy.zzt(query.getLong(16));
                    zzdy.zzo(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                    zzdy.zzao(query.getString(18));
                    zzdy.zzz(query.getLong(19));
                    zzdy.zzy(query.getLong(20));
                    zzdy.zzaq(query.getString(21));
                    zzdy.zzaa(query.isNull(22) ? 0 : query.getLong(22));
                    z = query.isNull(23) || query.getInt(23) != 0;
                    zzdy.zzd(z);
                    z = query.isNull(24) || query.getInt(24) != 0;
                    zzdy.zze(z);
                    zzdy.zzgh();
                    if (query.moveToNext()) {
                        zzge().zzim().zzg("Got multiple records for app, expected one. appId", zzfg.zzbm(str));
                    }
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68657);
                    return zzdy;
                }
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68657);
                return null;
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            th = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(68657);
            throw th;
        }
        try {
            zzge().zzim().zze("Error querying app. appId", zzfg.zzbm(str), e);
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(68657);
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (query != null) {
            }
            AppMethodBeat.m2505o(68657);
            throw th;
        }
    }

    public final long zzbd(String str) {
        AppMethodBeat.m2504i(68659);
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String valueOf = String.valueOf(Math.max(0, Math.min(1000000, zzgg().zzb(str, zzew.zzagx))));
            long delete = (long) writableDatabase.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
            AppMethodBeat.m2505o(68659);
            return delete;
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error deleting over the limit events. appId", zzfg.zzbm(str), e);
            AppMethodBeat.m2505o(68659);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzbe(String str) {
        Cursor query;
        Object e;
        Throwable th;
        AppMethodBeat.m2504i(68661);
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        try {
            query = getWritableDatabase().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        zzge().zzim().zzg("Got multiple records for app config, expected one. appId", zzfg.zzbm(str));
                    }
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68661);
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68661);
                return null;
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            th = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(68661);
            throw th;
        }
        try {
            zzge().zzim().zze("Error querying remote config. appId", zzfg.zzbm(str), e);
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(68661);
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (query != null) {
            }
            AppMethodBeat.m2505o(68661);
            throw th;
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Map<Integer, zzkr> zzbf(String str) {
        Cursor query;
        Object e;
        Throwable th;
        AppMethodBeat.m2504i(68674);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        try {
            query = getWritableDatabase().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    C6197a c6197a = new C6197a();
                    do {
                        int i = query.getInt(0);
                        byte[] blob = query.getBlob(1);
                        zzabv zza = zzabv.zza(blob, 0, blob.length);
                        zzkr zzkr = new zzkr();
                        try {
                            zzkr.zzb(zza);
                            c6197a.put(Integer.valueOf(i), zzkr);
                        } catch (IOException e2) {
                            zzge().zzim().zzd("Failed to merge filter results. appId, audienceId, error", zzfg.zzbm(str), Integer.valueOf(i), e2);
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68674);
                    return c6197a;
                }
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68674);
                return null;
            } catch (SQLiteException e3) {
                e = e3;
            }
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
        } catch (Throwable th2) {
            th = th2;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(68674);
            throw th;
        }
        try {
            zzge().zzim().zze("Database error querying filter results. appId", zzfg.zzbm(str), e);
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(68674);
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(68674);
            throw th;
        }
    }

    public final long zzbg(String str) {
        AppMethodBeat.m2504i(68683);
        Preconditions.checkNotEmpty(str);
        long zza = zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
        AppMethodBeat.m2505o(68683);
        return zza;
    }

    public final List<zzed> zzc(String str, String str2, String str3) {
        AppMethodBeat.m2504i(68655);
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder stringBuilder = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            stringBuilder.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            stringBuilder.append(" and name glob ?");
        }
        List zzb = zzb(stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
        AppMethodBeat.m2505o(68655);
        return zzb;
    }

    /* Access modifiers changed, original: final */
    @VisibleForTesting
    public final void zzc(List<Long> list) {
        AppMethodBeat.m2504i(68667);
        zzab();
        zzch();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzhv()) {
            String join = TextUtils.join(",", list);
            join = new StringBuilder(String.valueOf(join).length() + 2).append("(").append(join).append(")").toString();
            if (zza(new StringBuilder(String.valueOf(join).length() + 80).append("SELECT COUNT(1) FROM queue WHERE rowid IN ").append(join).append(" AND retry_count =  2147483647 LIMIT 1").toString(), null) > 0) {
                zzge().zzip().log("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                getWritableDatabase().execSQL(new StringBuilder(String.valueOf(join).length() + C31128d.MIC_SketchMark).append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ").append(join).append(" AND (retry_count IS NULL OR retry_count < 2147483647)").toString());
                AppMethodBeat.m2505o(68667);
                return;
            } catch (SQLiteException e) {
                zzge().zzim().zzg("Error incrementing retry count. error", e);
                AppMethodBeat.m2505o(68667);
                return;
            }
        }
        AppMethodBeat.m2505o(68667);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x013e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final zzeq zzf(String str, String str2) {
        Cursor query;
        Object e;
        Cursor cursor;
        Throwable th;
        AppMethodBeat.m2504i(68645);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            query = getWritableDatabase().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    long j = query.getLong(0);
                    long j2 = query.getLong(1);
                    long j3 = query.getLong(2);
                    long j4 = query.isNull(3) ? 0 : query.getLong(3);
                    Long valueOf = query.isNull(4) ? null : Long.valueOf(query.getLong(4));
                    Long valueOf2 = query.isNull(5) ? null : Long.valueOf(query.getLong(5));
                    Boolean bool = null;
                    if (!query.isNull(6)) {
                        bool = Boolean.valueOf(query.getLong(6) == 1);
                    }
                    zzeq zzeq = new zzeq(str, str2, j, j2, j3, j4, valueOf, valueOf2, bool);
                    if (query.moveToNext()) {
                        zzge().zzim().zzg("Got multiple records for event aggregates, expected one. appId", zzfg.zzbm(str));
                    }
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68645);
                    return zzeq;
                }
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68645);
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68645);
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(68645);
            throw th;
        }
        try {
            zzge().zzim().zzd("Error querying events. appId", zzfg.zzbm(str), zzga().zzbj(str2), e);
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(68645);
            return null;
        } catch (Throwable th4) {
            th = th4;
            query = cursor;
            if (query != null) {
            }
            AppMethodBeat.m2505o(68645);
            throw th;
        }
    }

    public final void zzg(String str, String str2) {
        AppMethodBeat.m2504i(68647);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            zzge().zzit().zzg("Deleted user attribute rows", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
            AppMethodBeat.m2505o(68647);
        } catch (SQLiteException e) {
            zzge().zzim().zzd("Error deleting user attribute. appId", zzfg.zzbm(str), zzga().zzbl(str2), e);
            AppMethodBeat.m2505o(68647);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final zzjz zzh(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        AppMethodBeat.m2504i(68649);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            Cursor query = getWritableDatabase().query("user_attributes", new String[]{"set_timestamp", "value", C8741b.ORIGIN}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    String str3 = str;
                    zzjz zzjz = new zzjz(str3, query.getString(2), str2, query.getLong(0), zza(query, 1));
                    if (query.moveToNext()) {
                        zzge().zzim().zzg("Got multiple records for user property, expected one. appId", zzfg.zzbm(str));
                    }
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68649);
                    return zzjz;
                }
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68649);
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                AppMethodBeat.m2505o(68649);
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            AppMethodBeat.m2505o(68649);
            throw th;
        }
        try {
            zzge().zzim().zzd("Error querying user property. appId", zzfg.zzbm(str), zzga().zzbl(str2), e);
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(68649);
            return null;
        } catch (Throwable th4) {
            th = th4;
            cursor2 = cursor;
            if (cursor2 != null) {
            }
            AppMethodBeat.m2505o(68649);
            throw th;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String zzhn() {
        Object e;
        Throwable th;
        String str = null;
        AppMethodBeat.m2504i(68663);
        Cursor rawQuery;
        try {
            rawQuery = getWritableDatabase().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.m2505o(68663);
                } else {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.m2505o(68663);
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzge().zzim().zzg("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.m2505o(68663);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.m2505o(68663);
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
            }
            AppMethodBeat.m2505o(68663);
            throw th;
        }
        return str;
    }

    public final boolean zzho() {
        AppMethodBeat.m2504i(68664);
        if (zza("select count(1) > 0 from queue where has_realtime = 1", null) != 0) {
            AppMethodBeat.m2505o(68664);
            return true;
        }
        AppMethodBeat.m2505o(68664);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void zzhp() {
        AppMethodBeat.m2504i(68666);
        zzab();
        zzch();
        if (zzhv()) {
            long j = zzgf().zzajx.get();
            long elapsedRealtime = zzbt().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > ((Long) zzew.zzahg.get()).longValue()) {
                zzgf().zzajx.set(elapsedRealtime);
                zzab();
                zzch();
                if (zzhv()) {
                    int delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzbt().currentTimeMillis()), String.valueOf(zzef.zzhh())});
                    if (delete > 0) {
                        zzge().zzit().zzg("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
            AppMethodBeat.m2505o(68666);
            return;
        }
        AppMethodBeat.m2505o(68666);
    }

    public final long zzhq() {
        AppMethodBeat.m2504i(68677);
        long zza = zza("select max(bundle_end_timestamp) from queue", null, 0);
        AppMethodBeat.m2505o(68677);
        return zza;
    }

    public final long zzhr() {
        AppMethodBeat.m2504i(68679);
        long zza = zza("select max(timestamp) from raw_events", null, 0);
        AppMethodBeat.m2505o(68679);
        return zza;
    }

    public final boolean zzhs() {
        AppMethodBeat.m2504i(68681);
        if (zza("select count(1) > 0 from raw_events", null) != 0) {
            AppMethodBeat.m2505o(68681);
            return true;
        }
        AppMethodBeat.m2505o(68681);
        return false;
    }

    public final boolean zzht() {
        AppMethodBeat.m2504i(68682);
        if (zza("select count(1) > 0 from raw_events where realtime = 1", null) != 0) {
            AppMethodBeat.m2505o(68682);
            return true;
        }
        AppMethodBeat.m2505o(68682);
        return false;
    }

    public final long zzhu() {
        long j = -1;
        Cursor cursor = null;
        AppMethodBeat.m2504i(68685);
        try {
            cursor = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(68685);
            }
        } catch (SQLiteException e) {
            zzge().zzim().zzg("Error querying raw events", e);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(68685);
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0174  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final zzed zzi(String str, String str2) {
        Cursor query;
        Object e;
        Cursor cursor;
        Throwable th;
        AppMethodBeat.m2504i(68653);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            query = getWritableDatabase().query("conditional_properties", new String[]{C8741b.ORIGIN, "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(0);
                    Object zza = zza(query, 1);
                    boolean z = query.getInt(2) != 0;
                    String string2 = query.getString(3);
                    long j = query.getLong(4);
                    zzeu zzeu = (zzeu) zzgb().zza(query.getBlob(5), zzeu.CREATOR);
                    long j2 = query.getLong(6);
                    zzeu zzeu2 = (zzeu) zzgb().zza(query.getBlob(7), zzeu.CREATOR);
                    long j3 = query.getLong(8);
                    zzed zzed = new zzed(str, string, new zzjx(str2, j3, zza, string), j2, z, string2, zzeu, j, zzeu2, query.getLong(9), (zzeu) zzgb().zza(query.getBlob(10), zzeu.CREATOR));
                    if (query.moveToNext()) {
                        zzge().zzim().zze("Got multiple records for conditional property, expected one", zzfg.zzbm(str), zzga().zzbl(str2));
                    }
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68653);
                    return zzed;
                }
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68653);
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                }
                AppMethodBeat.m2505o(68653);
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(68653);
            throw th;
        }
        try {
            zzge().zzim().zzd("Error querying conditional property", zzfg.zzbm(str), zzga().zzbl(str2), e);
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(68653);
            return null;
        } catch (Throwable th4) {
            th = th4;
            query = cursor;
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(68653);
            throw th;
        }
    }

    public final int zzj(String str, String str2) {
        int i = 0;
        AppMethodBeat.m2504i(68654);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            i = getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
            AppMethodBeat.m2505o(68654);
        } catch (SQLiteException e) {
            zzge().zzim().zzd("Error deleting conditional property", zzfg.zzbm(str), zzga().zzbl(str2), e);
            AppMethodBeat.m2505o(68654);
        }
        return i;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Map<Integer, List<zzke>> zzk(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        AppMethodBeat.m2504i(68671);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        C6197a c6197a = new C6197a();
        try {
            query = getWritableDatabase().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    do {
                        byte[] blob = query.getBlob(1);
                        zzabv zza = zzabv.zza(blob, 0, blob.length);
                        zzke zzke = new zzke();
                        try {
                            zzke.zzb(zza);
                            int i = query.getInt(0);
                            List list = (List) c6197a.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                c6197a.put(Integer.valueOf(i), list);
                            }
                            list.add(zzke);
                        } catch (IOException e2) {
                            zzge().zzim().zze("Failed to merge filter. appId", zzfg.zzbm(str), e2);
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68671);
                    return c6197a;
                }
                Map emptyMap = Collections.emptyMap();
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68671);
                return emptyMap;
            } catch (SQLiteException e3) {
                e = e3;
            }
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
        } catch (Throwable th2) {
            th = th2;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(68671);
            throw th;
        }
        try {
            zzge().zzim().zze("Database error querying filters. appId", zzfg.zzbm(str), e);
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(68671);
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(68671);
            throw th;
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Map<Integer, List<zzkh>> zzl(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        AppMethodBeat.m2504i(68672);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        C6197a c6197a = new C6197a();
        try {
            query = getWritableDatabase().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    do {
                        byte[] blob = query.getBlob(1);
                        zzabv zza = zzabv.zza(blob, 0, blob.length);
                        zzkh zzkh = new zzkh();
                        try {
                            zzkh.zzb(zza);
                            int i = query.getInt(0);
                            List list = (List) c6197a.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                c6197a.put(Integer.valueOf(i), list);
                            }
                            list.add(zzkh);
                        } catch (IOException e2) {
                            zzge().zzim().zze("Failed to merge filter", zzfg.zzbm(str), e2);
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(68672);
                    return c6197a;
                }
                Map emptyMap = Collections.emptyMap();
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(68672);
                return emptyMap;
            } catch (SQLiteException e3) {
                e = e3;
            }
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
        } catch (Throwable th2) {
            th = th2;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(68672);
            throw th;
        }
        try {
            zzge().zzim().zze("Database error querying filters. appId", zzfg.zzbm(str), e);
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(68672);
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(68672);
            throw th;
        }
    }

    /* Access modifiers changed, original: protected|final */
    @VisibleForTesting
    public final long zzm(String str, String str2) {
        Object e;
        AppMethodBeat.m2504i(68678);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        long zza;
        try {
            zza = zza(new StringBuilder(String.valueOf(str2).length() + 32).append("select ").append(str2).append(" from app2 where app_id=?").toString(), new String[]{str}, -1);
            if (zza == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", Integer.valueOf(0));
                contentValues.put("previous_install_count", Integer.valueOf(0));
                if (writableDatabase.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    zzge().zzim().zze("Failed to insert column (got -1). appId", zzfg.zzbm(str), str2);
                    writableDatabase.endTransaction();
                    AppMethodBeat.m2505o(68678);
                    return -1;
                }
                zza = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + zza));
                if (((long) writableDatabase.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    zzge().zzim().zze("Failed to update column (got 0). appId", zzfg.zzbm(str), str2);
                    writableDatabase.endTransaction();
                    AppMethodBeat.m2505o(68678);
                    return -1;
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                AppMethodBeat.m2505o(68678);
                return zza;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzge().zzim().zzd("Error inserting column. appId", zzfg.zzbm(str), str2, e);
                    writableDatabase.endTransaction();
                    AppMethodBeat.m2505o(68678);
                    return zza;
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    AppMethodBeat.m2505o(68678);
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            zza = 0;
            zzge().zzim().zzd("Error inserting column. appId", zzfg.zzbm(str), str2, e);
            writableDatabase.endTransaction();
            AppMethodBeat.m2505o(68678);
            return zza;
        }
    }
}
