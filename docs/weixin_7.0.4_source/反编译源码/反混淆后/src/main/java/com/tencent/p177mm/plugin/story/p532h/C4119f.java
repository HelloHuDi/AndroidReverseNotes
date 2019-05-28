package com.tencent.p177mm.plugin.story.p532h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p230g.p711c.C18476er;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.protocal.protobuf.cfc;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020HH\u0014J\u0006\u0010I\u001a\u00020\u000bJ\u0006\u0010J\u001a\u00020\u000bJ\u0006\u0010K\u001a\u00020\u000bJ\u001e\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u0011J\b\u0010P\u001a\u00020DH\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u00020\u00118FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R$\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f8F@FX\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR$\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR$\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR$\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR$\u00101\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f8F@FX\u000e¢\u0006\f\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R$\u00104\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR(\u00108\u001a\u0004\u0018\u0001072\b\u0010\u0003\u001a\u0004\u0018\u0001078F@FX\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f8F@FX\u000e¢\u0006\f\u001a\u0004\b>\u0010\"\"\u0004\b?\u0010$R$\u0010@\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f8F@FX\u000e¢\u0006\f\u001a\u0004\bA\u0010\"\"\u0004\bB\u0010$¨\u0006R"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "Lcom/tencent/mm/autogen/table/BaseStoryExtItem;", "()V", "value", "", "duration", "getDuration", "()J", "setDuration", "(J)V", "isContact", "", "()Ljava/lang/Boolean;", "setContact", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "localId", "", "getLocalId", "()I", "setLocalId", "(I)V", "oneDayCount", "getOneDayCount", "setOneDayCount", "postTime", "getPostTime", "setPostTime", "preLoadCache", "getPreLoadCache", "setPreLoadCache", "", "preloadMediaId", "getPreloadMediaId", "()Ljava/lang/String;", "setPreloadMediaId", "(Ljava/lang/String;)V", "preloadStoryId", "getPreloadStoryId", "setPreloadStoryId", "readId", "getReadId", "setReadId", "readTime", "getReadTime", "setReadTime", "syncId", "getSyncId", "setSyncId", "thumbUrl", "getThumbUrl", "setThumbUrl", "updateTime", "getUpdateTime", "setUpdateTime", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "userInfo", "getUserInfo", "()Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "setUserInfo", "(Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;)V", "userName", "getUserName", "setUserName", "videoUrl", "getVideoUrl", "setVideoUrl", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "hasUnread", "isEmpty", "isValid", "markPreloadCompleted", "storyId", "mediaId", "cacheSize", "resetPreLoad", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.h.f */
public final class C4119f extends C18476er {
    private static final String TAG = TAG;
    private static final C4924a ccO = C18476er.m28762Hm();
    private static final C31591m<Long, Long, Boolean> sdI = C4121b.sdK;
    public static final C4120a sdJ = new C4120a();
    private int cNE;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006RA\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryExtInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "compareUnsignedLong", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "i", "j", "", "getCompareUnsignedLong", "()Lkotlin/jvm/functions/Function2;", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.h.f$a */
    public static final class C4120a {
        private C4120a() {
        }

        public /* synthetic */ C4120a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "i", "", "j", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.h.f$b */
    static final class C4121b extends C25053k implements C31591m<Long, Long, Boolean> {
        public static final C4121b sdK = new C4121b();

        static {
            AppMethodBeat.m2504i(109871);
            AppMethodBeat.m2505o(109871);
        }

        C4121b() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            int i;
            int i2;
            int i3 = 1;
            AppMethodBeat.m2504i(109870);
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
            AppMethodBeat.m2505o(109870);
            return valueOf;
        }
    }

    public C4119f() {
        AppMethodBeat.m2504i(109881);
        setUserName("");
        AppMethodBeat.m2505o(109881);
    }

    static {
        AppMethodBeat.m2504i(109882);
        AppMethodBeat.m2505o(109882);
    }

    public final String getUserName() {
        AppMethodBeat.m2504i(109872);
        String str = this.field_userName;
        C25052j.m39375o(str, "field_userName");
        AppMethodBeat.m2505o(109872);
        return str;
    }

    public final void setUserName(String str) {
        AppMethodBeat.m2504i(109873);
        C25052j.m39376p(str, "value");
        this.field_userName = str;
        AppMethodBeat.m2505o(109873);
    }

    public final String cBJ() {
        String str = this.field_newVideoUrl;
        return str == null ? "" : str;
    }

    public final String cBK() {
        String str = this.field_newThumbUrl;
        return str == null ? "" : str;
    }

    public final void aaT(String str) {
        AppMethodBeat.m2504i(109874);
        C25052j.m39376p(str, "value");
        this.field_preloadMediaId = str;
        AppMethodBeat.m2505o(109874);
    }

    public final cfc cBM() {
        AppMethodBeat.m2504i(109875);
        cfc cfc;
        if (this.field_userInfo == null) {
            cfc = new cfc();
            AppMethodBeat.m2505o(109875);
            return cfc;
        }
        try {
            C1331a parseFrom = new cfc().parseFrom(this.field_userInfo);
            if (parseFrom == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserInfo");
                AppMethodBeat.m2505o(109875);
                throw c44941v;
            }
            cfc = (cfc) parseFrom;
            AppMethodBeat.m2505o(109875);
            return cfc;
        } catch (Exception e) {
            C4990ab.m7412e(TAG, "error get storyUserInfo!");
            cfc = new cfc();
        }
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(109877);
        C25052j.m39376p(cursor, "cu");
        super.mo8995d(cursor);
        this.cNE = (int) this.xDa;
        AppMethodBeat.m2505o(109877);
    }

    public final boolean cBN() {
        AppMethodBeat.m2504i(109878);
        if (isValid() && ((Boolean) sdI.mo212m(Long.valueOf(this.field_readId), Long.valueOf(this.field_syncId))).booleanValue()) {
            C31591m c31591m = sdI;
            C4133a c4133a = C43644j.rST;
            if (((Boolean) c31591m.mo212m(Long.valueOf(C4133a.cyh()), Long.valueOf(this.field_updateTime))).booleanValue()) {
                AppMethodBeat.m2505o(109878);
                return true;
            }
        }
        AppMethodBeat.m2505o(109878);
        return false;
    }

    public final boolean isValid() {
        AppMethodBeat.m2504i(109879);
        if (this.field_syncId == 0 || this.field_storyPostTime + 86400 < C1839cb.aaF()) {
            AppMethodBeat.m2505o(109879);
            return false;
        }
        AppMethodBeat.m2505o(109879);
        return true;
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        AppMethodBeat.m2504i(109880);
        C4924a c4924a = ccO;
        C25052j.m39375o(c4924a, "StoryExtInfo.info");
        AppMethodBeat.m2505o(109880);
        return c4924a;
    }

    public final long cBL() {
        return this.field_preloadStoryId == this.field_syncId ? this.field_preLoadResource : 0;
    }

    /* renamed from: b */
    public final boolean mo8989b(long j, String str, int i) {
        AppMethodBeat.m2504i(109876);
        C25052j.m39376p(str, "mediaId");
        if (j == this.field_syncId) {
            this.field_preloadStoryId = j;
            aaT(str);
            this.field_preLoadResource = (long) i;
            AppMethodBeat.m2505o(109876);
            return true;
        }
        AppMethodBeat.m2505o(109876);
        return false;
    }
}
