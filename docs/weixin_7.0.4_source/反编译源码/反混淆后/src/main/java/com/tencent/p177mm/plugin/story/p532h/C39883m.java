package com.tencent.p177mm.plugin.story.p532h;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18477es;
import com.tencent.p177mm.plugin.story.p532h.C39882l.C39881a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u0017B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rJ\u001c\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "droptable", "", "dumpinfo", "", "get", "roomName", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "set", "", "info", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.h.m */
public final class C39883m extends C7563j<C39882l> implements C4931a {
    private static final String TAG = TAG;
    private static final String[] fnj;
    private static final String sdP = sdP;
    private static final String sdR = ("select * from " + sdP);
    public static final C4122a sen = new C4122a();
    private final C4927e bSd;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SelectAllData", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.h.m$a */
    public static final class C4122a {
        private C4122a() {
        }

        public /* synthetic */ C4122a(byte b) {
            this();
        }
    }

    public C39883m(C4927e c4927e) {
        C25052j.m39376p(c4927e, UserDataStore.DATE_OF_BIRTH);
        C39881a c39881a = C39882l.sel;
        super(c4927e, C39882l.ccO, sdP, C18477es.diI);
        AppMethodBeat.m2504i(109973);
        this.bSd = c4927e;
        AppMethodBeat.m2505o(109973);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
    }

    static {
        AppMethodBeat.m2504i(109974);
        String[] strArr = new String[1];
        C39881a c39881a = C39882l.sel;
        strArr[0] = C7563j.m13217a(C39882l.ccO, sdP);
        fnj = strArr;
        AppMethodBeat.m2505o(109974);
    }

    public final C39882l abc(String str) {
        AppMethodBeat.m2504i(109971);
        C25052j.m39376p(str, "roomName");
        C39882l c39882l = new C39882l();
        c39882l.field_roomname = str;
        super.mo10102b((C4925c) c39882l, new String[0]);
        AppMethodBeat.m2505o(109971);
        return c39882l;
    }

    public final void cqH() {
        AppMethodBeat.m2504i(109972);
        C4990ab.m7416i(TAG, "dropTable ".concat(String.valueOf(this.bSd.delete(sdP, null, null))));
        AppMethodBeat.m2505o(109972);
    }
}
