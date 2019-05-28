package com.tencent.p177mm.plugin.story.p532h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18475eq;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020,H\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00118FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00168F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00168F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR$\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00168F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR$\u0010\"\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015¨\u0006."}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "Lcom/tencent/mm/autogen/table/BaseStoryEditorInfo;", "()V", "value", "", "available", "getAvailable", "()Z", "setAvailable", "(Z)V", "", "baseItemData", "getBaseItemData", "()[B", "setBaseItemData", "([B)V", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "", "mixFlag", "getMixFlag", "()I", "setMixFlag", "(I)V", "mixRetryTime", "getMixRetryTime", "setMixRetryTime", "storyLocalId", "getStoryLocalId", "setStoryLocalId", "timeStamp", "getTimeStamp", "setTimeStamp", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.h.d */
public final class C39878d extends C18475eq {
    private static final C4924a ccO = C18475eq.m28759Hm();
    public static final C29295a sdF = new C29295a();
    private long fDy;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryEditorData$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.h.d$a */
    public static final class C29295a {
        private C29295a() {
        }

        public /* synthetic */ C29295a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(109864);
        AppMethodBeat.m2505o(109864);
    }

    public final boolean cBG() {
        return this.field_available != 0;
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(109861);
        C25052j.m39376p(cursor, "cu");
        super.mo8995d(cursor);
        this.fDy = this.xDa;
        AppMethodBeat.m2505o(109861);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        AppMethodBeat.m2504i(109862);
        C4924a c4924a = ccO;
        C25052j.m39375o(c4924a, "info");
        AppMethodBeat.m2505o(109862);
        return c4924a;
    }

    public final String toString() {
        AppMethodBeat.m2504i(109863);
        String str = this.field_timeStamp + ", " + this.xDa + ", " + this.field_mixFlag;
        AppMethodBeat.m2505o(109863);
        return str;
    }
}
