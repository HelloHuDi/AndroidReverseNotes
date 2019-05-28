package com.tencent.p177mm.plugin.story.p532h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42106cw;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0004H\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryHistoryItem;", "()V", "value", "", "date", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "", "storyCount", "getStoryCount", "()I", "setStoryCount", "(I)V", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.h.h */
public final class C22213h extends C42106cw {
    private static final String TAG = TAG;
    private static final C4924a ccO = C42106cw.m74227Hm();
    public static final C13764a sdT = new C13764a();
    public C39879j rXz = new C39879j();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "fromItem", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "item", "Lcom/tencent/mm/protocal/protobuf/StoryHistoryItem;", "fromStoryInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.h.h$a */
    public static final class C13764a {
        private C13764a() {
        }

        public /* synthetic */ C13764a(byte b) {
            this();
        }
    }

    public C22213h() {
        AppMethodBeat.m2504i(109905);
        AppMethodBeat.m2505o(109905);
    }

    public final String cBQ() {
        AppMethodBeat.m2504i(109902);
        String str = this.field_date;
        C25052j.m39375o(str, "field_date");
        AppMethodBeat.m2505o(109902);
        return str;
    }

    static {
        AppMethodBeat.m2504i(109906);
        Class cls = C39879j.class;
        AppMethodBeat.m2505o(109906);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        AppMethodBeat.m2504i(109903);
        C4924a c4924a = ccO;
        C25052j.m39375o(c4924a, "StoryHistoryInfo.info");
        AppMethodBeat.m2505o(109903);
        return c4924a;
    }

    public final String toString() {
        AppMethodBeat.m2504i(109904);
        StringBuilder stringBuilder = new StringBuilder("StoryHistoryInfo[localId:");
        C39879j c39879j = this.rXz;
        String stringBuilder2 = stringBuilder.append((c39879j != null ? Integer.valueOf((int) c39879j.xDa) : null).intValue()).append(" date:").append(cBQ()).append(" count:").append(this.field_count).append(']').toString();
        AppMethodBeat.m2505o(109904);
        return stringBuilder2;
    }
}
