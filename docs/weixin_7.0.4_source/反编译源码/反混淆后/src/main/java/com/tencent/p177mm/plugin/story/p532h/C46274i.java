package com.tencent.p177mm.plugin.story.p532h;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42106cw;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.story.p532h.C22213h.C13764a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7563j;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteByDate", "", "date", "", "getStoryHistoryByDate", "isDateExist", "onNotifyChange", "", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "replaceHistoryInfoByDate", "storyHistoryInfo", "set", "info", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.h.i */
public final class C46274i extends C7563j<C22213h> implements C4931a {
    private static final String TAG = TAG;
    private static final String[] fnj;
    public static final String sdP = sdP;
    private static final String sdR = ("select * from " + sdP + ' ');
    public static final C22214a sdU = new C22214a();
    public final C4927e bSd;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SelectAllData", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.h.i$a */
    public static final class C22214a {
        private C22214a() {
        }

        public /* synthetic */ C22214a(byte b) {
            this();
        }
    }

    public C46274i(C4927e c4927e) {
        C25052j.m39376p(c4927e, UserDataStore.DATE_OF_BIRTH);
        C13764a c13764a = C22213h.sdT;
        super(c4927e, C22213h.ccO, sdP, C42106cw.diI);
        AppMethodBeat.m2504i(109911);
        this.bSd = c4927e;
        AppMethodBeat.m2505o(109911);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
    }

    static {
        AppMethodBeat.m2504i(109912);
        String[] strArr = new String[1];
        C13764a c13764a = C22213h.sdT;
        strArr[0] = C7563j.m13217a(C22213h.ccO, sdP);
        fnj = strArr;
        AppMethodBeat.m2505o(109912);
    }

    /* renamed from: a */
    public final boolean mo74392a(C22213h c22213h) {
        AppMethodBeat.m2504i(109907);
        C25052j.m39376p(c22213h, "storyHistoryInfo");
        boolean c;
        if (aaY(c22213h.cBQ())) {
            c = mo10103c(c22213h, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            AppMethodBeat.m2505o(109907);
            return c;
        }
        c = m86712b(c22213h);
        AppMethodBeat.m2505o(109907);
        return c;
    }

    private boolean aaY(String str) {
        AppMethodBeat.m2504i(109908);
        C25052j.m39376p(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
        Cursor rawQuery = this.bSd.rawQuery(sdR + " WHERE " + sdP + ".date = '" + str + '\'', null);
        C25052j.m39375o(rawQuery, "cu");
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 0) {
            AppMethodBeat.m2505o(109908);
            return true;
        }
        AppMethodBeat.m2505o(109908);
        return false;
    }

    public final C22213h aaZ(String str) {
        AppMethodBeat.m2504i(109909);
        C25052j.m39376p(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
        Cursor rawQuery = this.bSd.rawQuery(sdR + " WHERE " + sdP + ".date = '" + str + '\'', null);
        if (rawQuery.moveToFirst()) {
            C22213h c22213h = new C22213h();
            c22213h.mo8995d(rawQuery);
            rawQuery.close();
            AppMethodBeat.m2505o(109909);
            return c22213h;
        }
        rawQuery.close();
        AppMethodBeat.m2505o(109909);
        return null;
    }

    /* renamed from: b */
    private boolean m86712b(C22213h c22213h) {
        AppMethodBeat.m2504i(109910);
        C25052j.m39376p(c22213h, "info");
        boolean a = super.mo10099a(c22213h);
        AppMethodBeat.m2505o(109910);
        return a;
    }
}
