package com.tencent.p177mm.plugin.story.p532h;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18478et;
import com.tencent.p177mm.plugin.story.p532h.C29298n.C22216a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0017B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteByStoryId", "", "storyId", "", "droptable", "dumpinfo", "", "getAllData", "", "getByStoryId", "insert", "", "item", "update", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.h.o */
public final class C13765o extends C7563j<C29298n> {
    private static final String TAG = TAG;
    private static final String[] sdG;
    public static final C13766a sep = new C13766a();
    public final C4927e bSd;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage$Companion;", "", "()V", "SqlCreate", "", "", "kotlin.jvm.PlatformType", "getSqlCreate", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "getTAG", "()Ljava/lang/String;", "Table", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.h.o$a */
    public static final class C13766a {
        private C13766a() {
        }

        public /* synthetic */ C13766a(byte b) {
            this();
        }
    }

    public C13765o(C4927e c4927e) {
        C25052j.m39376p(c4927e, UserDataStore.DATE_OF_BIRTH);
        C22216a c22216a = C29298n.seo;
        super(c4927e, C29298n.ccO, "StoryVideoCacheInfo", C18478et.diI);
        AppMethodBeat.m2504i(109984);
        this.bSd = c4927e;
        AppMethodBeat.m2505o(109984);
    }

    static {
        AppMethodBeat.m2504i(109985);
        String[] strArr = new String[1];
        C22216a c22216a = C29298n.seo;
        strArr[0] = C7563j.m13217a(C29298n.ccO, "StoryVideoCacheInfo");
        sdG = strArr;
        AppMethodBeat.m2505o(109985);
    }

    /* renamed from: a */
    public final boolean mo25973a(C29298n c29298n) {
        AppMethodBeat.m2504i(109979);
        C25052j.m39376p(c29298n, "item");
        boolean b = super.mo10101b((C4925c) c29298n);
        AppMethodBeat.m2505o(109979);
        return b;
    }

    /* renamed from: b */
    public final boolean mo25974b(C29298n c29298n) {
        AppMethodBeat.m2504i(109981);
        C25052j.m39376p(c29298n, "item");
        boolean c = super.mo10103c(c29298n, new String[0]);
        AppMethodBeat.m2505o(109981);
        return c;
    }

    /* renamed from: lz */
    public final C29298n mo25976lz(long j) {
        C29298n c29298n = null;
        AppMethodBeat.m2504i(109982);
        if (j == 0) {
            C4990ab.m7416i(TAG, "Test get mediaId error " + j + ' ' + C5046bo.dpG());
            AppMethodBeat.m2505o(109982);
        } else {
            Cursor rawQuery = this.bSd.rawQuery("select * from StoryVideoCacheInfo  where storyId = '" + j + "' ", null);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    c29298n = new C29298n();
                    c29298n.mo8995d(rawQuery);
                }
                rawQuery.close();
            }
            AppMethodBeat.m2505o(109982);
        }
        return c29298n;
    }

    public final void cqH() {
        AppMethodBeat.m2504i(109983);
        C4990ab.m7416i(TAG, "dropTable ".concat(String.valueOf(this.bSd.delete("StoryVideoCacheInfo", null, null))));
        AppMethodBeat.m2505o(109983);
    }
}
