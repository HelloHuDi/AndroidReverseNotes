package com.tencent.p177mm.plugin.story.p532h;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p230g.p711c.C18475eq;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35186d;
import com.tencent.p177mm.plugin.story.p532h.C39878d.C29295a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import java.io.Closeable;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;
import p000a.p1582e.C41372b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000ej\b\u0012\u0004\u0012\u00020\f`\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "cleanDirtyData", "", "cleanNullData", "timeStamp", "", "getAllDataIfNoMix", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getByLocalId", "localId", "getByTimeStamp", "getLastDataIfNoMix", "updateByLocal", "id", "editorData", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.h.e */
public final class C7610e extends C7563j<C39878d> {
    private static final String[] sdG;
    public static final C7611a sdH = new C7611a();
    public final C4927e bSd;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage$Companion;", "", "()V", "SqlCreate", "", "", "kotlin.jvm.PlatformType", "getSqlCreate", "()[Ljava/lang/String;", "[Ljava/lang/String;", "Table", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.h.e$a */
    public static final class C7611a {
        private C7611a() {
        }

        public /* synthetic */ C7611a(byte b) {
            this();
        }
    }

    public C7610e(C4927e c4927e) {
        C25052j.m39376p(c4927e, UserDataStore.DATE_OF_BIRTH);
        C29295a c29295a = C39878d.sdF;
        super(c4927e, C39878d.ccO, "StoryEditorInfo", C18475eq.diI);
        AppMethodBeat.m2504i(109868);
        this.bSd = c4927e;
        AppMethodBeat.m2505o(109868);
    }

    static {
        AppMethodBeat.m2504i(109869);
        String[] strArr = new String[1];
        C29295a c29295a = C39878d.sdF;
        strArr[0] = C7563j.m13217a(C39878d.ccO, "StoryEditorInfo");
        sdG = strArr;
        AppMethodBeat.m2505o(109869);
    }

    /* renamed from: ls */
    public final C39878d mo17051ls(long j) {
        C39878d c39878d = null;
        AppMethodBeat.m2504i(109865);
        C29295a c29295a = C39878d.sdF;
        Cursor query = this.bSd.query("StoryEditorInfo", C39878d.ccO.columns, "rowid=".concat(String.valueOf(j)), null, null, null, null);
        if (query != null) {
            if (query.moveToFirst()) {
                c39878d = new C39878d();
                c39878d.mo8995d(query);
            }
            query.close();
        }
        AppMethodBeat.m2505o(109865);
        return c39878d;
    }

    /* renamed from: b */
    public final long mo17049b(long j, C39878d c39878d) {
        AppMethodBeat.m2504i(109866);
        C25052j.m39376p(c39878d, "editorData");
        ContentValues Hl = c39878d.mo10098Hl();
        Hl.remove("rowid");
        long update = (long) this.bSd.update("StoryEditorInfo", Hl, "rowid=?", new String[]{String.valueOf(j)});
        AppMethodBeat.m2505o(109866);
        return update;
    }

    public final C39878d cBH() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.m2504i(109867);
        long aaE = C1839cb.aaE() - 86400000;
        StringBuilder stringBuilder = new StringBuilder("select rowid, * from StoryEditorInfo where mixFlag&");
        C35186d c35186d = C35186d.sdv;
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.append(C35186d.cBx()).append("!=0  and timeStamp > ").append(aaE).append(" limit 1 ").toString(), null);
        if (rawQuery != null) {
            Closeable closeable = rawQuery;
            try {
                if (rawQuery.moveToFirst()) {
                    C39878d c39878d = new C39878d();
                    c39878d.mo8995d(rawQuery);
                    C41372b.m72155a(closeable, null);
                    AppMethodBeat.m2505o(109867);
                    return c39878d;
                }
                C37091y c37091y = C37091y.AUy;
                C41372b.m72155a(closeable, null);
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                C41372b.m72155a(closeable, th2);
                AppMethodBeat.m2505o(109867);
                throw th;
            }
        }
        AppMethodBeat.m2505o(109867);
        return null;
    }
}
