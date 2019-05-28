package com.tencent.mm.plugin.story.h;

import a.f.b.j;
import a.l;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eq;

@l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020,H\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00118FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00168F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00168F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR$\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00168F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR$\u0010\"\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015¨\u0006."}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "Lcom/tencent/mm/autogen/table/BaseStoryEditorInfo;", "()V", "value", "", "available", "getAvailable", "()Z", "setAvailable", "(Z)V", "", "baseItemData", "getBaseItemData", "()[B", "setBaseItemData", "([B)V", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "", "mixFlag", "getMixFlag", "()I", "setMixFlag", "(I)V", "mixRetryTime", "getMixRetryTime", "setMixRetryTime", "storyLocalId", "getStoryLocalId", "setStoryLocalId", "timeStamp", "getTimeStamp", "setTimeStamp", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "", "Companion", "plugin-story_release"})
public final class d extends eq {
    private static final com.tencent.mm.sdk.e.c.a ccO = eq.Hm();
    public static final a sdF = new a();
    private long fDy;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryEditorData$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(109864);
        AppMethodBeat.o(109864);
    }

    public final boolean cBG() {
        return this.field_available != 0;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(109861);
        j.p(cursor, "cu");
        super.d(cursor);
        this.fDy = this.xDa;
        AppMethodBeat.o(109861);
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        AppMethodBeat.i(109862);
        com.tencent.mm.sdk.e.c.a aVar = ccO;
        j.o(aVar, "info");
        AppMethodBeat.o(109862);
        return aVar;
    }

    public final String toString() {
        AppMethodBeat.i(109863);
        String str = this.field_timeStamp + ", " + this.xDa + ", " + this.field_mixFlag;
        AppMethodBeat.o(109863);
        return str;
    }
}
