package com.tencent.mm.plugin.story.h;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ep;
import com.tencent.mm.plugin.story.h.a.b;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "Lcom/tencent/mm/autogen/table/BaseStoryCommentSync;", "()V", "fromUser", "", "getFromUser", "()Ljava/lang/String;", "setFromUser", "(Ljava/lang/String;)V", "storyOwner", "getStoryOwner", "setStoryOwner", "addUnreadFlag", "", "checkUnreadFlag", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isUnread", "removeUnreadFlag", "Companion", "plugin-story_release"})
public final class c extends ep {
    private static final com.tencent.mm.sdk.e.c.a ccO = ep.Hm();
    public static final a sdE = new a();
    public String cEV = "";
    public String rVl = "";

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryCommentSync$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(109860);
        AppMethodBeat.o(109860);
    }

    public final void aaS(String str) {
        AppMethodBeat.i(138840);
        j.p(str, "<set-?>");
        this.cEV = str;
        AppMethodBeat.o(138840);
    }

    public final void aaG(String str) {
        AppMethodBeat.i(138841);
        j.p(str, "<set-?>");
        this.rVl = str;
        AppMethodBeat.o(138841);
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        AppMethodBeat.i(109859);
        com.tencent.mm.sdk.e.c.a aVar = ccO;
        j.o(aVar, "info");
        AppMethodBeat.o(109859);
        return aVar;
    }

    public final void cBE() {
        AppMethodBeat.i(138842);
        int i = this.field_commentFlag;
        b bVar = b.sdo;
        this.field_commentFlag = i & (b.cBt() ^ -1);
        AppMethodBeat.o(138842);
    }
}
