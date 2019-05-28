package com.tencent.mm.plugin.story.h;

import a.e.b;
import a.l;
import a.y;
import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eq;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.h.a.d;
import com.tencent.mm.sdk.e.j;
import java.io.Closeable;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000ej\b\u0012\u0004\u0012\u00020\f`\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "cleanDirtyData", "", "cleanNullData", "timeStamp", "", "getAllDataIfNoMix", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getByLocalId", "localId", "getByTimeStamp", "getLastDataIfNoMix", "updateByLocal", "id", "editorData", "Companion", "plugin-story_release"})
public final class e extends j<d> {
    private static final String[] sdG;
    public static final a sdH = new a();
    public final com.tencent.mm.sdk.e.e bSd;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage$Companion;", "", "()V", "SqlCreate", "", "", "kotlin.jvm.PlatformType", "getSqlCreate", "()[Ljava/lang/String;", "[Ljava/lang/String;", "Table", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        a.f.b.j.p(eVar, UserDataStore.DATE_OF_BIRTH);
        com.tencent.mm.plugin.story.h.d.a aVar = d.sdF;
        super(eVar, d.ccO, "StoryEditorInfo", eq.diI);
        AppMethodBeat.i(109868);
        this.bSd = eVar;
        AppMethodBeat.o(109868);
    }

    static {
        AppMethodBeat.i(109869);
        String[] strArr = new String[1];
        com.tencent.mm.plugin.story.h.d.a aVar = d.sdF;
        strArr[0] = j.a(d.ccO, "StoryEditorInfo");
        sdG = strArr;
        AppMethodBeat.o(109869);
    }

    public final d ls(long j) {
        d dVar = null;
        AppMethodBeat.i(109865);
        com.tencent.mm.plugin.story.h.d.a aVar = d.sdF;
        Cursor query = this.bSd.query("StoryEditorInfo", d.ccO.columns, "rowid=".concat(String.valueOf(j)), null, null, null, null);
        if (query != null) {
            if (query.moveToFirst()) {
                dVar = new d();
                dVar.d(query);
            }
            query.close();
        }
        AppMethodBeat.o(109865);
        return dVar;
    }

    public final long b(long j, d dVar) {
        AppMethodBeat.i(109866);
        a.f.b.j.p(dVar, "editorData");
        ContentValues Hl = dVar.Hl();
        Hl.remove("rowid");
        long update = (long) this.bSd.update("StoryEditorInfo", Hl, "rowid=?", new String[]{String.valueOf(j)});
        AppMethodBeat.o(109866);
        return update;
    }

    public final d cBH() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(109867);
        long aaE = cb.aaE() - 86400000;
        StringBuilder stringBuilder = new StringBuilder("select rowid, * from StoryEditorInfo where mixFlag&");
        d dVar = d.sdv;
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.append(d.cBx()).append("!=0  and timeStamp > ").append(aaE).append(" limit 1 ").toString(), null);
        if (rawQuery != null) {
            Closeable closeable = rawQuery;
            try {
                if (rawQuery.moveToFirst()) {
                    d dVar2 = new d();
                    dVar2.d(rawQuery);
                    b.a(closeable, null);
                    AppMethodBeat.o(109867);
                    return dVar2;
                }
                y yVar = y.AUy;
                b.a(closeable, null);
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                b.a(closeable, th2);
                AppMethodBeat.o(109867);
                throw th;
            }
        }
        AppMethodBeat.o(109867);
        return null;
    }
}
