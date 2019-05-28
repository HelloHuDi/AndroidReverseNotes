package com.tencent.p177mm.plugin.story.p532h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18478et;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.vfs.C5730e;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\b\u0010\u001f\u001a\u00020 H\u0014J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\nH\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00108F@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR$\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "Lcom/tencent/mm/autogen/table/BaseStoryVideoCacheInfo;", "()V", "value", "", "cacheSize", "getCacheSize", "()I", "setCacheSize", "(I)V", "", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "totalSize", "getTotalSize", "setTotalSize", "url", "getUrl", "setUrl", "downloadFinish", "", "downloadFinishAndCheckFile", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "resetVideo", "", "toString", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.h.n */
public final class C29298n extends C18478et {
    private static final C4924a ccO = C18478et.m28768Hm();
    public static final C22216a seo = new C22216a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryVideoCache$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.h.n$a */
    public static final class C22216a {
        private C22216a() {
        }

        public /* synthetic */ C22216a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(109978);
        AppMethodBeat.m2505o(109978);
    }

    /* renamed from: Jo */
    public final boolean mo47507Jo() {
        return this.field_totalSize > 0 && this.field_cacheSize == this.field_totalSize;
    }

    public final boolean cCd() {
        AppMethodBeat.m2504i(109975);
        if (mo47507Jo() && C5730e.m8628ct(this.field_filePath)) {
            AppMethodBeat.m2505o(109975);
            return true;
        }
        AppMethodBeat.m2505o(109975);
        return false;
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        AppMethodBeat.m2504i(109976);
        C4924a c4924a = ccO;
        C25052j.m39375o(c4924a, "info");
        AppMethodBeat.m2505o(109976);
        return c4924a;
    }

    public final String toString() {
        AppMethodBeat.m2504i(109977);
        String str = this.field_storyId + ", " + this.field_filePath + ", cacheSize:" + this.field_cacheSize + ", totalSize:" + this.field_totalSize;
        AppMethodBeat.m2505o(109977);
        return str;
    }

    public final void cCe() {
        this.field_cacheSize = 0;
        this.field_totalSize = 0;
    }
}
