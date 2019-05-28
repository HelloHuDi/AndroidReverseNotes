package com.tencent.mm.plugin.story.h;

import a.l;
import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.et;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0017B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteByStoryId", "", "storyId", "", "droptable", "dumpinfo", "", "getAllData", "", "getByStoryId", "insert", "", "item", "update", "Companion", "plugin-story_release"})
public final class o extends j<n> {
    private static final String TAG = TAG;
    private static final String[] sdG;
    public static final a sep = new a();
    public final e bSd;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage$Companion;", "", "()V", "SqlCreate", "", "", "kotlin.jvm.PlatformType", "getSqlCreate", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "getTAG", "()Ljava/lang/String;", "Table", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public o(e eVar) {
        a.f.b.j.p(eVar, UserDataStore.DATE_OF_BIRTH);
        com.tencent.mm.plugin.story.h.n.a aVar = n.seo;
        super(eVar, n.ccO, "StoryVideoCacheInfo", et.diI);
        AppMethodBeat.i(109984);
        this.bSd = eVar;
        AppMethodBeat.o(109984);
    }

    static {
        AppMethodBeat.i(109985);
        String[] strArr = new String[1];
        com.tencent.mm.plugin.story.h.n.a aVar = n.seo;
        strArr[0] = j.a(n.ccO, "StoryVideoCacheInfo");
        sdG = strArr;
        AppMethodBeat.o(109985);
    }

    public final boolean a(n nVar) {
        AppMethodBeat.i(109979);
        a.f.b.j.p(nVar, "item");
        boolean b = super.b((c) nVar);
        AppMethodBeat.o(109979);
        return b;
    }

    public final boolean b(n nVar) {
        AppMethodBeat.i(109981);
        a.f.b.j.p(nVar, "item");
        boolean c = super.c(nVar, new String[0]);
        AppMethodBeat.o(109981);
        return c;
    }

    public final n lz(long j) {
        n nVar = null;
        AppMethodBeat.i(109982);
        if (j == 0) {
            ab.i(TAG, "Test get mediaId error " + j + ' ' + bo.dpG());
            AppMethodBeat.o(109982);
        } else {
            Cursor rawQuery = this.bSd.rawQuery("select * from StoryVideoCacheInfo  where storyId = '" + j + "' ", null);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    nVar = new n();
                    nVar.d(rawQuery);
                }
                rawQuery.close();
            }
            AppMethodBeat.o(109982);
        }
        return nVar;
    }

    public final void cqH() {
        AppMethodBeat.i(109983);
        ab.i(TAG, "dropTable ".concat(String.valueOf(this.bSd.delete("StoryVideoCacheInfo", null, null))));
        AppMethodBeat.o(109983);
    }
}
