package com.tencent.mm.plugin.appbrand.appcache.b.d;

import a.e.b;
import a.l;
import a.o;
import a.y;
import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\tJ \u0010\u0012\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStatStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStats;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "checkReportOnLocalPkgFound", "", "appId", "", "version", "", "delete", "", "increaseHitCount", "pruneOutdatedRecords", "setSource", "source", "Companion", "plugin-appbrand-integration_release"})
public final class a extends c<b> {
    public static final String[] fjY = new String[]{j.a(b.fjX, "AppBrandWxaPkgPreDownloadStatistics")};
    @Deprecated
    public static final a gWr = new a();
    private final e bSd;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStatStorage$Companion;", "", "()V", "TABLE_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public a(e eVar) {
        a.f.b.j.p(eVar, UserDataStore.DATE_OF_BIRTH);
        super(eVar, b.fjX, "AppBrandWxaPkgPreDownloadStatistics", b.diI);
        AppMethodBeat.i(134477);
        this.bSd = eVar;
        AppMethodBeat.o(134477);
    }

    static {
        AppMethodBeat.i(134478);
        AppMethodBeat.o(134478);
    }

    public final boolean pI(String str) {
        Object obj;
        AppMethodBeat.i(134474);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.o(134474);
            return false;
        }
        boolean hY = this.bSd.hY("AppBrandWxaPkgPreDownloadStatistics", "delete from AppBrandWxaPkgPreDownloadStatistics where appId='" + str + '\'');
        AppMethodBeat.o(134474);
        return hY;
    }

    public final void aww() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(134475);
        LinkedList linkedList = new LinkedList();
        Cursor a = this.bSd.a("select AppBrandWxaPkgPreDownloadStatistics.appId, AppBrandWxaPkgPreDownloadStatistics.version from AppBrandWxaPkgPreDownloadStatistics left outer join AppBrandWxaPkgManifestRecord  on (     AppBrandWxaPkgPreDownloadStatistics.appId=AppBrandWxaPkgManifestRecord.appId      and AppBrandWxaPkgPreDownloadStatistics.version=AppBrandWxaPkgManifestRecord.version      and AppBrandWxaPkgManifestRecord.debugType=0) where AppBrandWxaPkgManifestRecord.versionMd5 is null", null, 2);
        if (a != null) {
            Closeable closeable = a;
            try {
                Cursor cursor = (Cursor) closeable;
                y yVar;
                if (cursor.isClosed() || !cursor.moveToFirst()) {
                    yVar = y.AUy;
                    b.a(closeable, null);
                } else {
                    do {
                        linkedList.add(new o(cursor.getString(0), Integer.valueOf(cursor.getInt(1))));
                    } while (cursor.moveToNext());
                    yVar = y.AUy;
                    b.a(closeable, null);
                }
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                b.a(closeable, th2);
                AppMethodBeat.o(134475);
                throw th;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            String str = (String) oVar.first;
            this.bSd.hY("AppBrandWxaPkgPreDownloadStatistics", "delete from AppBrandWxaPkgPreDownloadStatistics where appId='" + str + "' AND version=" + ((Number) oVar.second).intValue());
        }
        AppMethodBeat.o(134475);
    }

    public final void ay(String str, int i) {
        AppMethodBeat.i(134476);
        CharSequence charSequence = str;
        int i2 = (charSequence == null || charSequence.length() == 0) ? 1 : 0;
        if (i2 != 0) {
            AppMethodBeat.o(134476);
            return;
        }
        b bVar = new b();
        bVar.field_appId = str;
        bVar.field_version = i;
        bVar.field_hitCount = 0;
        bVar.field_source = 0;
        bVar.field_reportId = 0;
        boolean b = b(bVar, new String[0]);
        if (bVar.field_source == 1) {
            if (bVar.field_hitCount > 0) {
                i2 = 57;
            } else {
                i2 = 56;
            }
            com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.cO(bVar.field_reportId, i2);
        }
        bVar.field_hitCount++;
        if (b) {
            c(bVar, new String[0]);
            AppMethodBeat.o(134476);
            return;
        }
        b((com.tencent.mm.sdk.e.c) bVar);
        AppMethodBeat.o(134476);
    }
}
