package com.tencent.mm.plugin.story.h;

import a.l;
import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.m;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteByDate", "", "date", "", "getStoryHistoryByDate", "isDateExist", "onNotifyChange", "", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "replaceHistoryInfoByDate", "storyHistoryInfo", "set", "info", "Companion", "plugin-story_release"})
public final class i extends j<h> implements com.tencent.mm.sdk.e.k.a {
    private static final String TAG = TAG;
    private static final String[] fnj;
    public static final String sdP = sdP;
    private static final String sdR = ("select * from " + sdP + ' ');
    public static final a sdU = new a();
    public final e bSd;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SelectAllData", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public i(e eVar) {
        a.f.b.j.p(eVar, UserDataStore.DATE_OF_BIRTH);
        com.tencent.mm.plugin.story.h.h.a aVar = h.sdT;
        super(eVar, h.ccO, sdP, cw.diI);
        AppMethodBeat.i(109911);
        this.bSd = eVar;
        AppMethodBeat.o(109911);
    }

    public final void a(String str, m mVar) {
    }

    static {
        AppMethodBeat.i(109912);
        String[] strArr = new String[1];
        com.tencent.mm.plugin.story.h.h.a aVar = h.sdT;
        strArr[0] = j.a(h.ccO, sdP);
        fnj = strArr;
        AppMethodBeat.o(109912);
    }

    public final boolean a(h hVar) {
        AppMethodBeat.i(109907);
        a.f.b.j.p(hVar, "storyHistoryInfo");
        boolean c;
        if (aaY(hVar.cBQ())) {
            c = c(hVar, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            AppMethodBeat.o(109907);
            return c;
        }
        c = b(hVar);
        AppMethodBeat.o(109907);
        return c;
    }

    private boolean aaY(String str) {
        AppMethodBeat.i(109908);
        a.f.b.j.p(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
        Cursor rawQuery = this.bSd.rawQuery(sdR + " WHERE " + sdP + ".date = '" + str + '\'', null);
        a.f.b.j.o(rawQuery, "cu");
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 0) {
            AppMethodBeat.o(109908);
            return true;
        }
        AppMethodBeat.o(109908);
        return false;
    }

    public final h aaZ(String str) {
        AppMethodBeat.i(109909);
        a.f.b.j.p(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
        Cursor rawQuery = this.bSd.rawQuery(sdR + " WHERE " + sdP + ".date = '" + str + '\'', null);
        if (rawQuery.moveToFirst()) {
            h hVar = new h();
            hVar.d(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(109909);
            return hVar;
        }
        rawQuery.close();
        AppMethodBeat.o(109909);
        return null;
    }

    private boolean b(h hVar) {
        AppMethodBeat.i(109910);
        a.f.b.j.p(hVar, "info");
        boolean a = super.a(hVar);
        AppMethodBeat.o(109910);
        return a;
    }
}
