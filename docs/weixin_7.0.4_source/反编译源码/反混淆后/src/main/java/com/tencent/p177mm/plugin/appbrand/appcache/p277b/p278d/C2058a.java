package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p278d;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.plugin.appbrand.p911q.C19678c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C31826o;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;
import p000a.p1582e.C41372b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\tJ \u0010\u0012\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStatStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStats;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "checkReportOnLocalPkgFound", "", "appId", "", "version", "", "delete", "", "increaseHitCount", "pruneOutdatedRecords", "setSource", "source", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.d.a */
public final class C2058a extends C19678c<C33091b> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C33091b.fjX, "AppBrandWxaPkgPreDownloadStatistics")};
    @Deprecated
    public static final C2059a gWr = new C2059a();
    private final C4927e bSd;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStatStorage$Companion;", "", "()V", "TABLE_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.d.a$a */
    static final class C2059a {
        private C2059a() {
        }

        public /* synthetic */ C2059a(byte b) {
            this();
        }
    }

    public C2058a(C4927e c4927e) {
        C25052j.m39376p(c4927e, UserDataStore.DATE_OF_BIRTH);
        super(c4927e, C33091b.fjX, "AppBrandWxaPkgPreDownloadStatistics", C33091b.diI);
        AppMethodBeat.m2504i(134477);
        this.bSd = c4927e;
        AppMethodBeat.m2505o(134477);
    }

    static {
        AppMethodBeat.m2504i(134478);
        AppMethodBeat.m2505o(134478);
    }

    /* renamed from: pI */
    public final boolean mo5824pI(String str) {
        Object obj;
        AppMethodBeat.m2504i(134474);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.m2505o(134474);
            return false;
        }
        boolean hY = this.bSd.mo10108hY("AppBrandWxaPkgPreDownloadStatistics", "delete from AppBrandWxaPkgPreDownloadStatistics where appId='" + str + '\'');
        AppMethodBeat.m2505o(134474);
        return hY;
    }

    public final void aww() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.m2504i(134475);
        LinkedList linkedList = new LinkedList();
        Cursor a = this.bSd.mo10104a("select AppBrandWxaPkgPreDownloadStatistics.appId, AppBrandWxaPkgPreDownloadStatistics.version from AppBrandWxaPkgPreDownloadStatistics left outer join AppBrandWxaPkgManifestRecord  on (     AppBrandWxaPkgPreDownloadStatistics.appId=AppBrandWxaPkgManifestRecord.appId      and AppBrandWxaPkgPreDownloadStatistics.version=AppBrandWxaPkgManifestRecord.version      and AppBrandWxaPkgManifestRecord.debugType=0) where AppBrandWxaPkgManifestRecord.versionMd5 is null", null, 2);
        if (a != null) {
            Closeable closeable = a;
            try {
                Cursor cursor = (Cursor) closeable;
                C37091y c37091y;
                if (cursor.isClosed() || !cursor.moveToFirst()) {
                    c37091y = C37091y.AUy;
                    C41372b.m72155a(closeable, null);
                } else {
                    do {
                        linkedList.add(new C31826o(cursor.getString(0), Integer.valueOf(cursor.getInt(1))));
                    } while (cursor.moveToNext());
                    c37091y = C37091y.AUy;
                    C41372b.m72155a(closeable, null);
                }
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                C41372b.m72155a(closeable, th2);
                AppMethodBeat.m2505o(134475);
                throw th;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C31826o c31826o = (C31826o) it.next();
            String str = (String) c31826o.first;
            this.bSd.mo10108hY("AppBrandWxaPkgPreDownloadStatistics", "delete from AppBrandWxaPkgPreDownloadStatistics where appId='" + str + "' AND version=" + ((Number) c31826o.second).intValue());
        }
        AppMethodBeat.m2505o(134475);
    }

    /* renamed from: ay */
    public final void mo5823ay(String str, int i) {
        AppMethodBeat.m2504i(134476);
        CharSequence charSequence = str;
        int i2 = (charSequence == null || charSequence.length() == 0) ? 1 : 0;
        if (i2 != 0) {
            AppMethodBeat.m2505o(134476);
            return;
        }
        C33091b c33091b = new C33091b();
        c33091b.field_appId = str;
        c33091b.field_version = i;
        c33091b.field_hitCount = 0;
        c33091b.field_source = 0;
        c33091b.field_reportId = 0;
        boolean b = mo10102b(c33091b, new String[0]);
        if (c33091b.field_source == 1) {
            if (c33091b.field_hitCount > 0) {
                i2 = 57;
            } else {
                i2 = 56;
            }
            C19050a c19050a = C19050a.gWl;
            C19050a.m29622cO(c33091b.field_reportId, i2);
        }
        c33091b.field_hitCount++;
        if (b) {
            mo10103c(c33091b, new String[0]);
            AppMethodBeat.m2505o(134476);
            return;
        }
        mo10101b((C4925c) c33091b);
        AppMethodBeat.m2505o(134476);
    }
}
