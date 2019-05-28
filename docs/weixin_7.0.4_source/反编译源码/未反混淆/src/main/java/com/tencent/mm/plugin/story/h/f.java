package com.tencent.mm.plugin.story.h;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.er;
import com.tencent.mm.model.cb;
import com.tencent.mm.protocal.protobuf.cfc;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020HH\u0014J\u0006\u0010I\u001a\u00020\u000bJ\u0006\u0010J\u001a\u00020\u000bJ\u0006\u0010K\u001a\u00020\u000bJ\u001e\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u0011J\b\u0010P\u001a\u00020DH\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u00020\u00118FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R$\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f8F@FX\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR$\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR$\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR$\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR$\u00101\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f8F@FX\u000e¢\u0006\f\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R$\u00104\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR(\u00108\u001a\u0004\u0018\u0001072\b\u0010\u0003\u001a\u0004\u0018\u0001078F@FX\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f8F@FX\u000e¢\u0006\f\u001a\u0004\b>\u0010\"\"\u0004\b?\u0010$R$\u0010@\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f8F@FX\u000e¢\u0006\f\u001a\u0004\bA\u0010\"\"\u0004\bB\u0010$¨\u0006R"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "Lcom/tencent/mm/autogen/table/BaseStoryExtItem;", "()V", "value", "", "duration", "getDuration", "()J", "setDuration", "(J)V", "isContact", "", "()Ljava/lang/Boolean;", "setContact", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "localId", "", "getLocalId", "()I", "setLocalId", "(I)V", "oneDayCount", "getOneDayCount", "setOneDayCount", "postTime", "getPostTime", "setPostTime", "preLoadCache", "getPreLoadCache", "setPreLoadCache", "", "preloadMediaId", "getPreloadMediaId", "()Ljava/lang/String;", "setPreloadMediaId", "(Ljava/lang/String;)V", "preloadStoryId", "getPreloadStoryId", "setPreloadStoryId", "readId", "getReadId", "setReadId", "readTime", "getReadTime", "setReadTime", "syncId", "getSyncId", "setSyncId", "thumbUrl", "getThumbUrl", "setThumbUrl", "updateTime", "getUpdateTime", "setUpdateTime", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "userInfo", "getUserInfo", "()Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "setUserInfo", "(Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;)V", "userName", "getUserName", "setUserName", "videoUrl", "getVideoUrl", "setVideoUrl", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "hasUnread", "isEmpty", "isValid", "markPreloadCompleted", "storyId", "mediaId", "cacheSize", "resetPreLoad", "Companion", "plugin-story_release"})
public final class f extends er {
    private static final String TAG = TAG;
    private static final com.tencent.mm.sdk.e.c.a ccO = er.Hm();
    private static final m<Long, Long, Boolean> sdI = b.sdK;
    public static final a sdJ = new a();
    private int cNE;

    @l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006RA\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryExtInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "compareUnsignedLong", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "i", "j", "", "getCompareUnsignedLong", "()Lkotlin/jvm/functions/Function2;", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "i", "", "j", "invoke"})
    static final class b extends k implements m<Long, Long, Boolean> {
        public static final b sdK = new b();

        static {
            AppMethodBeat.i(109871);
            AppMethodBeat.o(109871);
        }

        b() {
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            int i;
            int i2;
            int i3 = 1;
            AppMethodBeat.i(109870);
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
            AppMethodBeat.o(109870);
            return valueOf;
        }
    }

    public f() {
        AppMethodBeat.i(109881);
        setUserName("");
        AppMethodBeat.o(109881);
    }

    static {
        AppMethodBeat.i(109882);
        AppMethodBeat.o(109882);
    }

    public final String getUserName() {
        AppMethodBeat.i(109872);
        String str = this.field_userName;
        j.o(str, "field_userName");
        AppMethodBeat.o(109872);
        return str;
    }

    public final void setUserName(String str) {
        AppMethodBeat.i(109873);
        j.p(str, "value");
        this.field_userName = str;
        AppMethodBeat.o(109873);
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
        AppMethodBeat.i(109874);
        j.p(str, "value");
        this.field_preloadMediaId = str;
        AppMethodBeat.o(109874);
    }

    public final cfc cBM() {
        AppMethodBeat.i(109875);
        cfc cfc;
        if (this.field_userInfo == null) {
            cfc = new cfc();
            AppMethodBeat.o(109875);
            return cfc;
        }
        try {
            com.tencent.mm.bt.a parseFrom = new cfc().parseFrom(this.field_userInfo);
            if (parseFrom == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserInfo");
                AppMethodBeat.o(109875);
                throw vVar;
            }
            cfc = (cfc) parseFrom;
            AppMethodBeat.o(109875);
            return cfc;
        } catch (Exception e) {
            ab.e(TAG, "error get storyUserInfo!");
            cfc = new cfc();
        }
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(109877);
        j.p(cursor, "cu");
        super.d(cursor);
        this.cNE = (int) this.xDa;
        AppMethodBeat.o(109877);
    }

    public final boolean cBN() {
        AppMethodBeat.i(109878);
        if (isValid() && ((Boolean) sdI.m(Long.valueOf(this.field_readId), Long.valueOf(this.field_syncId))).booleanValue()) {
            m mVar = sdI;
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            if (((Boolean) mVar.m(Long.valueOf(com.tencent.mm.plugin.story.model.j.a.cyh()), Long.valueOf(this.field_updateTime))).booleanValue()) {
                AppMethodBeat.o(109878);
                return true;
            }
        }
        AppMethodBeat.o(109878);
        return false;
    }

    public final boolean isValid() {
        AppMethodBeat.i(109879);
        if (this.field_syncId == 0 || this.field_storyPostTime + 86400 < cb.aaF()) {
            AppMethodBeat.o(109879);
            return false;
        }
        AppMethodBeat.o(109879);
        return true;
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        AppMethodBeat.i(109880);
        com.tencent.mm.sdk.e.c.a aVar = ccO;
        j.o(aVar, "StoryExtInfo.info");
        AppMethodBeat.o(109880);
        return aVar;
    }

    public final long cBL() {
        return this.field_preloadStoryId == this.field_syncId ? this.field_preLoadResource : 0;
    }

    public final boolean b(long j, String str, int i) {
        AppMethodBeat.i(109876);
        j.p(str, "mediaId");
        if (j == this.field_syncId) {
            this.field_preloadStoryId = j;
            aaT(str);
            this.field_preLoadResource = (long) i;
            AppMethodBeat.o(109876);
            return true;
        }
        AppMethodBeat.o(109876);
        return false;
    }
}
