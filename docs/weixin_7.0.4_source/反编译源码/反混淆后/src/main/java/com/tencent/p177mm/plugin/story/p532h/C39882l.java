package com.tencent.p177mm.plugin.story.p532h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18477es;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import p000a.C0220l;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0014R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR0\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfo;", "Lcom/tencent/mm/autogen/table/BaseStoryRoomInfo;", "()V", "value", "", "extBuf", "getExtBuf", "()[B", "setExtBuf", "([B)V", "", "", "newStoryList", "getNewStoryList", "()Ljava/util/List;", "setNewStoryList", "(Ljava/util/List;)V", "", "nextSyncTime", "getNextSyncTime", "()J", "setNextSyncTime", "(J)V", "roomName", "getRoomName", "()Ljava/lang/String;", "setRoomName", "(Ljava/lang/String;)V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.h.l */
public final class C39882l extends C18477es {
    private static final String TAG = TAG;
    private static final C4924a ccO = C18477es.m28765Hm();
    private static final C31591m<Long, Long, Boolean> sdI = C31429b.sem;
    public static final C39881a sel = new C39881a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "i", "", "j", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.h.l$b */
    static final class C31429b extends C25053k implements C31591m<Long, Long, Boolean> {
        public static final C31429b sem = new C31429b();

        static {
            AppMethodBeat.m2504i(109967);
            AppMethodBeat.m2505o(109967);
        }

        C31429b() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            int i;
            int i2;
            int i3 = 1;
            AppMethodBeat.m2504i(109966);
            long longValue = ((Number) obj).longValue();
            long longValue2 = ((Number) obj2).longValue();
            if (longValue < longValue2) {
                i = 1;
            } else {
                i = 0;
            }
            if (longValue < 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i2 ^= i;
            if (longValue2 >= 0) {
                i3 = 0;
            }
            Boolean valueOf = Boolean.valueOf(i3 ^ i2);
            AppMethodBeat.m2505o(109966);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006RA\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "compareUnsignedLong", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "i", "j", "", "getCompareUnsignedLong", "()Lkotlin/jvm/functions/Function2;", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.h.l$a */
    public static final class C39881a {
        private C39881a() {
        }

        public /* synthetic */ C39881a(byte b) {
            this();
        }
    }

    public C39882l() {
        AppMethodBeat.m2504i(109969);
        String str = "";
        C25052j.m39376p(str, "value");
        this.field_roomname = str;
        AppMethodBeat.m2505o(109969);
    }

    static {
        AppMethodBeat.m2504i(109970);
        AppMethodBeat.m2505o(109970);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        AppMethodBeat.m2504i(109968);
        C4924a c4924a = ccO;
        C25052j.m39375o(c4924a, "StoryRoomInfo.info");
        AppMethodBeat.m2505o(109968);
        return c4924a;
    }
}
