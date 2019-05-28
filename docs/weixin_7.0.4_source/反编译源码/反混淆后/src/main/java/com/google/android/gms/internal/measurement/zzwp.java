package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzwp {
    private static final ConcurrentHashMap<Uri, zzwp> zzbmt = new ConcurrentHashMap();
    private static final String[] zzbna = new String[]{"key", "value"};
    private final Uri uri;
    private final ContentResolver zzbmu;
    private final ContentObserver zzbmv;
    private final Object zzbmw = new Object();
    private volatile Map<String, String> zzbmx;
    private final Object zzbmy = new Object();
    private final List<zzwr> zzbmz = new ArrayList();

    static {
        AppMethodBeat.m2504i(69759);
        AppMethodBeat.m2505o(69759);
    }

    private zzwp(ContentResolver contentResolver, Uri uri) {
        AppMethodBeat.m2504i(69753);
        this.zzbmu = contentResolver;
        this.uri = uri;
        this.zzbmv = new zzwq(this, null);
        AppMethodBeat.m2505o(69753);
    }

    public static zzwp zza(ContentResolver contentResolver, Uri uri) {
        AppMethodBeat.m2504i(69754);
        zzwp zzwp = (zzwp) zzbmt.get(uri);
        if (zzwp == null) {
            zzwp zzwp2 = new zzwp(contentResolver, uri);
            zzwp = (zzwp) zzbmt.putIfAbsent(uri, zzwp2);
            if (zzwp == null) {
                zzwp2.zzbmu.registerContentObserver(zzwp2.uri, false, zzwp2.zzbmv);
                zzwp = zzwp2;
            }
        }
        AppMethodBeat.m2505o(69754);
        return zzwp;
    }

    static /* synthetic */ void zza(zzwp zzwp) {
        AppMethodBeat.m2504i(69758);
        zzwp.zzrw();
        AppMethodBeat.m2505o(69758);
    }

    private final Map<String, String> zzrv() {
        AppMethodBeat.m2504i(69756);
        Cursor query;
        try {
            HashMap hashMap = new HashMap();
            query = this.zzbmu.query(this.uri, zzbna, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    hashMap.put(query.getString(0), query.getString(1));
                }
                query.close();
            }
            AppMethodBeat.m2505o(69756);
            return hashMap;
        } catch (SQLiteException | SecurityException e) {
            AppMethodBeat.m2505o(69756);
            return null;
        } catch (Throwable th) {
            query.close();
            AppMethodBeat.m2505o(69756);
        }
    }

    private final void zzrw() {
        AppMethodBeat.m2504i(69757);
        synchronized (this.zzbmy) {
            try {
                for (zzwr zzrx : this.zzbmz) {
                    zzrx.zzrx();
                }
            } finally {
                AppMethodBeat.m2505o(69757);
            }
        }
    }

    public final Map<String, String> zzrt() {
        AppMethodBeat.m2504i(69755);
        Map<String, String> zzrv = zzws.zzd("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? zzrv() : this.zzbmx;
        if (zzrv == null) {
            synchronized (this.zzbmw) {
                try {
                    zzrv = this.zzbmx;
                    if (zzrv == null) {
                        zzrv = zzrv();
                        this.zzbmx = zzrv;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(69755);
                    }
                }
            }
        }
        if (zzrv != null) {
            AppMethodBeat.m2505o(69755);
            return zzrv;
        }
        Map emptyMap = Collections.emptyMap();
        AppMethodBeat.m2505o(69755);
        return emptyMap;
    }

    public final void zzru() {
        synchronized (this.zzbmw) {
            this.zzbmx = null;
        }
    }
}
