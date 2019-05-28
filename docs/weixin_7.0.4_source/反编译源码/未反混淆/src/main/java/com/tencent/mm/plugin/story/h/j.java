package com.tencent.mm.plugin.story.h;

import a.l;
import a.v;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cx;
import com.tencent.mm.model.cb;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.story.e.b;
import com.tencent.mm.plugin.story.h.a.c;
import com.tencent.mm.plugin.story.model.q;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u0000 O2\u00020\u0001:\u0001OB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020(J\u0006\u0010+\u001a\u00020#J\u0006\u0010,\u001a\u00020#J\u0010\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u000201H\u0014J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u00020(J\u0006\u00107\u001a\u00020(J\u0006\u00108\u001a\u00020(J\u0006\u00109\u001a\u00020(J\u0006\u0010:\u001a\u00020(J\u0016\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0013J\u0006\u0010>\u001a\u00020(J\u000e\u0010?\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u000205J\u0006\u0010C\u001a\u00020#J\u000e\u0010D\u001a\u00020#2\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020#J\u0006\u0010H\u001a\u00020#J\u0006\u0010I\u001a\u00020#J\u0006\u0010J\u001a\u00020#J\u0006\u0010K\u001a\u00020#J\u000e\u0010L\u001a\u00020#2\u0006\u0010M\u001a\u000205J\u0006\u0010N\u001a\u00020#R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001c8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006P"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryInfo;", "()V", "value", "", "createTime", "getCreateTime", "()I", "setCreateTime", "(I)V", "date", "getDate", "setDate", "localId", "getLocalId", "setLocalId", "readCount", "getReadCount", "setReadCount", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "type", "getType", "setType", "", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "addSourceFlag", "", "mmsourceType", "addStoryItemFlag", "storyItemFlag", "checkFavorite", "", "checkNotifySns", "checkVisiableSelfOnly", "cleanPostFinish", "clearItemDie", "convertFrom", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "getTimeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "isDeprecated", "isDeprecatedForFav", "isItemDie", "isItemFinish", "isReadStatus", "isTimeLimit", "tryCount", "startTime", "isUnreadStatus", "removeSourceFlag", "removeStoryItemFlag", "setContent", "contentObj", "setItemDie", "setPostBuf", "postBuf", "", "setPostFinish", "setPostMixFinish", "setPostMixWaiting", "setPostWaiting", "setReadStatus", "setTimeLine", "timeline", "setUnreadStatus", "Companion", "plugin-story_release"})
public final class j extends cx {
    private static final String TAG = TAG;
    private static final com.tencent.mm.sdk.e.c.a ccO = cx.Hm();
    private static final String sdW = sdW;
    private static final String sdX = sdX;
    private static final String sdY = sdY;
    private static final String sdZ = sdZ;
    public static final a sea = new a();
    public int cNE;
    public int sdV;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0019\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryInfo$Companion;", "", "()V", "COL_ROWID", "", "getCOL_ROWID", "()Ljava/lang/String;", "TABLEINDEXUSERNAME", "getTABLEINDEXUSERNAME", "TAG", "getTAG", "TableIndexUsernameCreateTime", "getTableIndexUsernameCreateTime", "TableIndexUsernameTime", "getTableIndexUsernameTime", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(109928);
        AppMethodBeat.o(109928);
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        AppMethodBeat.i(109913);
        com.tencent.mm.sdk.e.c.a aVar = ccO;
        a.f.b.j.o(aVar, "info");
        AppMethodBeat.o(109913);
        return aVar;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(109914);
        a.f.b.j.p(cursor, "cu");
        super.d(cursor);
        this.cNE = (int) this.xDa;
        com.tencent.mm.plugin.story.e.b.a aVar = b.rRO;
        this.sdV = com.tencent.mm.plugin.story.e.b.a.kX(((long) this.field_createTime) * 1000);
        AppMethodBeat.o(109914);
    }

    public final cfb cBR() {
        AppMethodBeat.i(109915);
        com.tencent.mm.plugin.story.model.q.a aVar;
        cfb cyq;
        if (this.field_content == null) {
            aVar = q.rTk;
            cyq = com.tencent.mm.plugin.story.model.q.a.cyq();
            AppMethodBeat.o(109915);
            return cyq;
        }
        try {
            com.tencent.mm.bt.a parseFrom = new cfb().parseFrom(this.field_content);
            if (parseFrom == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryTimelineObject");
                AppMethodBeat.o(109915);
                throw vVar;
            }
            cyq = (cfb) parseFrom;
            AppMethodBeat.o(109915);
            return cyq;
        } catch (Exception e) {
            ab.e(TAG, "error get storyinfo timeline!");
            aVar = q.rTk;
            cyq = com.tencent.mm.plugin.story.model.q.a.cyq();
            AppMethodBeat.o(109915);
            return cyq;
        }
    }

    public final void b(cfb cfb) {
        AppMethodBeat.i(109916);
        a.f.b.j.p(cfb, "timeline");
        try {
            this.field_content = cfb.toByteArray();
            AppMethodBeat.o(109916);
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.o(109916);
        }
    }

    public final void bk(byte[] bArr) {
        AppMethodBeat.i(109917);
        a.f.b.j.p(bArr, "postBuf");
        this.field_postBuf = bArr;
        AppMethodBeat.o(109917);
    }

    public final void cBS() {
        AppMethodBeat.i(109918);
        int i = this.field_localFlag;
        c cVar = c.sds;
        this.field_localFlag = i | c.cBu();
        AppMethodBeat.o(109918);
    }

    public final void cqY() {
        AppMethodBeat.i(109919);
        int i = this.field_localFlag;
        c cVar = c.sds;
        this.field_localFlag = i | c.cBv();
        AppMethodBeat.o(109919);
    }

    public final void cqX() {
        AppMethodBeat.i(109920);
        int i = this.field_localFlag;
        c cVar = c.sds;
        this.field_localFlag = i & (c.cBv() ^ -1);
        AppMethodBeat.o(109920);
    }

    public final boolean cBT() {
        AppMethodBeat.i(109921);
        int i = this.field_localFlag;
        c cVar = c.sds;
        if ((i & c.cBv()) != 0) {
            AppMethodBeat.o(109921);
            return true;
        }
        AppMethodBeat.o(109921);
        return false;
    }

    public final boolean c(cfb cfb) {
        AppMethodBeat.i(109922);
        a.f.b.j.p(cfb, "contentObj");
        try {
            this.field_content = cfb.toByteArray();
            AppMethodBeat.o(109922);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.o(109922);
            return false;
        }
    }

    public final cel cBU() {
        AppMethodBeat.i(109923);
        cel cel = new cel();
        if (this.field_postBuf == null) {
            AppMethodBeat.o(109923);
            return cel;
        }
        try {
            com.tencent.mm.bt.a parseFrom = new cel().parseFrom(this.field_postBuf);
            if (parseFrom == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
                AppMethodBeat.o(109923);
                throw vVar;
            }
            cel = (cel) parseFrom;
            AppMethodBeat.o(109923);
            return cel;
        } catch (Exception e) {
            ab.e(TAG, "error get StoryMediaPostInfo " + this.field_storyID);
            cel = new cel();
            AppMethodBeat.o(109923);
            return cel;
        }
    }

    public final void DF(int i) {
        this.field_sourceType |= i;
    }

    public final void Fc(int i) {
        this.field_itemStoryFlag |= i;
    }

    public final void Fd(int i) {
        this.field_itemStoryFlag &= i ^ -1;
    }

    public final boolean cBV() {
        AppMethodBeat.i(109924);
        int i = this.field_itemStoryFlag;
        com.tencent.mm.plugin.story.h.a.a aVar = a.sdm;
        boolean cf = com.tencent.mm.ab.b.cf(i, a.sdd);
        AppMethodBeat.o(109924);
        return cf;
    }

    public final boolean cBW() {
        AppMethodBeat.i(109925);
        int i = this.field_itemStoryFlag;
        com.tencent.mm.plugin.story.h.a.a aVar = a.sdm;
        boolean cf = com.tencent.mm.ab.b.cf(i, a.sde);
        AppMethodBeat.o(109925);
        return cf;
    }

    public static boolean ac(int i, long j) {
        boolean z = true;
        AppMethodBeat.i(109926);
        if (ae.gjB) {
            ab.i(TAG, "Android Test time limit fail " + ae.gjB);
            AppMethodBeat.o(109926);
        } else {
            boolean z2;
            int aaF = cb.aaF() - ((int) j);
            com.tencent.mm.plugin.story.h.a.a aVar = a.sdm;
            boolean z3 = aaF > a.scX;
            if (i > 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!(z3 || z2)) {
                z = false;
            }
            if (z) {
                ab.i(TAG, "isTimeLimit " + z3 + "  " + z2 + " tryCount:" + i + " startTime " + j + "  svr: " + cb.aaF());
            }
            AppMethodBeat.o(109926);
        }
        return z;
    }

    public final boolean cBX() {
        AppMethodBeat.i(109927);
        if (this.field_createTime <= cb.aaF() - 86400) {
            AppMethodBeat.o(109927);
            return true;
        }
        AppMethodBeat.o(109927);
        return false;
    }
}
