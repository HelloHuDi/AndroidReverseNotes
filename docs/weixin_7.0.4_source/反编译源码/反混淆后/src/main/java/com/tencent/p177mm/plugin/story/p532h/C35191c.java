package com.tencent.p177mm.plugin.story.p532h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18474ep;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35185b;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "Lcom/tencent/mm/autogen/table/BaseStoryCommentSync;", "()V", "fromUser", "", "getFromUser", "()Ljava/lang/String;", "setFromUser", "(Ljava/lang/String;)V", "storyOwner", "getStoryOwner", "setStoryOwner", "addUnreadFlag", "", "checkUnreadFlag", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isUnread", "removeUnreadFlag", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.h.c */
public final class C35191c extends C18474ep {
    private static final C4924a ccO = C18474ep.m28756Hm();
    public static final C35192a sdE = new C35192a();
    public String cEV = "";
    public String rVl = "";

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryCommentSync$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.h.c$a */
    public static final class C35192a {
        private C35192a() {
        }

        public /* synthetic */ C35192a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(109860);
        AppMethodBeat.m2505o(109860);
    }

    public final void aaS(String str) {
        AppMethodBeat.m2504i(138840);
        C25052j.m39376p(str, "<set-?>");
        this.cEV = str;
        AppMethodBeat.m2505o(138840);
    }

    public final void aaG(String str) {
        AppMethodBeat.m2504i(138841);
        C25052j.m39376p(str, "<set-?>");
        this.rVl = str;
        AppMethodBeat.m2505o(138841);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        AppMethodBeat.m2504i(109859);
        C4924a c4924a = ccO;
        C25052j.m39375o(c4924a, "info");
        AppMethodBeat.m2505o(109859);
        return c4924a;
    }

    public final void cBE() {
        AppMethodBeat.m2504i(138842);
        int i = this.field_commentFlag;
        C35185b c35185b = C35185b.sdo;
        this.field_commentFlag = i & (C35185b.cBt() ^ -1);
        AppMethodBeat.m2505o(138842);
    }
}
