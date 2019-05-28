package com.tencent.p177mm.plugin.story.p532h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p230g.p711c.C45394cx;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.story.model.C43647q;
import com.tencent.p177mm.plugin.story.model.C43647q.C39911a;
import com.tencent.p177mm.plugin.story.p1303e.C22177b;
import com.tencent.p177mm.plugin.story.p1303e.C22177b.C22178a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35187c;
import com.tencent.p177mm.protocal.protobuf.cel;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u0000 O2\u00020\u0001:\u0001OB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020(J\u0006\u0010+\u001a\u00020#J\u0006\u0010,\u001a\u00020#J\u0010\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u000201H\u0014J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u00020(J\u0006\u00107\u001a\u00020(J\u0006\u00108\u001a\u00020(J\u0006\u00109\u001a\u00020(J\u0006\u0010:\u001a\u00020(J\u0016\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0013J\u0006\u0010>\u001a\u00020(J\u000e\u0010?\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u000205J\u0006\u0010C\u001a\u00020#J\u000e\u0010D\u001a\u00020#2\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020#J\u0006\u0010H\u001a\u00020#J\u0006\u0010I\u001a\u00020#J\u0006\u0010J\u001a\u00020#J\u0006\u0010K\u001a\u00020#J\u000e\u0010L\u001a\u00020#2\u0006\u0010M\u001a\u000205J\u0006\u0010N\u001a\u00020#R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001c8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006P"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryInfo;", "()V", "value", "", "createTime", "getCreateTime", "()I", "setCreateTime", "(I)V", "date", "getDate", "setDate", "localId", "getLocalId", "setLocalId", "readCount", "getReadCount", "setReadCount", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "type", "getType", "setType", "", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "addSourceFlag", "", "mmsourceType", "addStoryItemFlag", "storyItemFlag", "checkFavorite", "", "checkNotifySns", "checkVisiableSelfOnly", "cleanPostFinish", "clearItemDie", "convertFrom", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "getTimeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "isDeprecated", "isDeprecatedForFav", "isItemDie", "isItemFinish", "isReadStatus", "isTimeLimit", "tryCount", "startTime", "isUnreadStatus", "removeSourceFlag", "removeStoryItemFlag", "setContent", "contentObj", "setItemDie", "setPostBuf", "postBuf", "", "setPostFinish", "setPostMixFinish", "setPostMixWaiting", "setPostWaiting", "setReadStatus", "setTimeLine", "timeline", "setUnreadStatus", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.h.j */
public final class C39879j extends C45394cx {
    private static final String TAG = TAG;
    private static final C4924a ccO = C45394cx.m83580Hm();
    private static final String sdW = sdW;
    private static final String sdX = sdX;
    private static final String sdY = sdY;
    private static final String sdZ = sdZ;
    public static final C22215a sea = new C22215a();
    public int cNE;
    public int sdV;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0019\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/story/storage/StoryInfo$Companion;", "", "()V", "COL_ROWID", "", "getCOL_ROWID", "()Ljava/lang/String;", "TABLEINDEXUSERNAME", "getTABLEINDEXUSERNAME", "TAG", "getTAG", "TableIndexUsernameCreateTime", "getTableIndexUsernameCreateTime", "TableIndexUsernameTime", "getTableIndexUsernameTime", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.h.j$a */
    public static final class C22215a {
        private C22215a() {
        }

        public /* synthetic */ C22215a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(109928);
        AppMethodBeat.m2505o(109928);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        AppMethodBeat.m2504i(109913);
        C4924a c4924a = ccO;
        C25052j.m39375o(c4924a, "info");
        AppMethodBeat.m2505o(109913);
        return c4924a;
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(109914);
        C25052j.m39376p(cursor, "cu");
        super.mo8995d(cursor);
        this.cNE = (int) this.xDa;
        C22178a c22178a = C22177b.rRO;
        this.sdV = C22178a.m33805kX(((long) this.field_createTime) * 1000);
        AppMethodBeat.m2505o(109914);
    }

    public final cfb cBR() {
        AppMethodBeat.m2504i(109915);
        C39911a c39911a;
        cfb cyq;
        if (this.field_content == null) {
            c39911a = C43647q.rTk;
            cyq = C39911a.cyq();
            AppMethodBeat.m2505o(109915);
            return cyq;
        }
        try {
            C1331a parseFrom = new cfb().parseFrom(this.field_content);
            if (parseFrom == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryTimelineObject");
                AppMethodBeat.m2505o(109915);
                throw c44941v;
            }
            cyq = (cfb) parseFrom;
            AppMethodBeat.m2505o(109915);
            return cyq;
        } catch (Exception e) {
            C4990ab.m7412e(TAG, "error get storyinfo timeline!");
            c39911a = C43647q.rTk;
            cyq = C39911a.cyq();
            AppMethodBeat.m2505o(109915);
            return cyq;
        }
    }

    /* renamed from: b */
    public final void mo63082b(cfb cfb) {
        AppMethodBeat.m2504i(109916);
        C25052j.m39376p(cfb, "timeline");
        try {
            this.field_content = cfb.toByteArray();
            AppMethodBeat.m2505o(109916);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.m2505o(109916);
        }
    }

    /* renamed from: bk */
    public final void mo63083bk(byte[] bArr) {
        AppMethodBeat.m2504i(109917);
        C25052j.m39376p(bArr, "postBuf");
        this.field_postBuf = bArr;
        AppMethodBeat.m2505o(109917);
    }

    public final void cBS() {
        AppMethodBeat.m2504i(109918);
        int i = this.field_localFlag;
        C35187c c35187c = C35187c.sds;
        this.field_localFlag = i | C35187c.cBu();
        AppMethodBeat.m2505o(109918);
    }

    public final void cqY() {
        AppMethodBeat.m2504i(109919);
        int i = this.field_localFlag;
        C35187c c35187c = C35187c.sds;
        this.field_localFlag = i | C35187c.cBv();
        AppMethodBeat.m2505o(109919);
    }

    public final void cqX() {
        AppMethodBeat.m2504i(109920);
        int i = this.field_localFlag;
        C35187c c35187c = C35187c.sds;
        this.field_localFlag = i & (C35187c.cBv() ^ -1);
        AppMethodBeat.m2505o(109920);
    }

    public final boolean cBT() {
        AppMethodBeat.m2504i(109921);
        int i = this.field_localFlag;
        C35187c c35187c = C35187c.sds;
        if ((i & C35187c.cBv()) != 0) {
            AppMethodBeat.m2505o(109921);
            return true;
        }
        AppMethodBeat.m2505o(109921);
        return false;
    }

    /* renamed from: c */
    public final boolean mo63084c(cfb cfb) {
        AppMethodBeat.m2504i(109922);
        C25052j.m39376p(cfb, "contentObj");
        try {
            this.field_content = cfb.toByteArray();
            AppMethodBeat.m2505o(109922);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.m2505o(109922);
            return false;
        }
    }

    public final cel cBU() {
        AppMethodBeat.m2504i(109923);
        cel cel = new cel();
        if (this.field_postBuf == null) {
            AppMethodBeat.m2505o(109923);
            return cel;
        }
        try {
            C1331a parseFrom = new cel().parseFrom(this.field_postBuf);
            if (parseFrom == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
                AppMethodBeat.m2505o(109923);
                throw c44941v;
            }
            cel = (cel) parseFrom;
            AppMethodBeat.m2505o(109923);
            return cel;
        } catch (Exception e) {
            C4990ab.m7412e(TAG, "error get StoryMediaPostInfo " + this.field_storyID);
            cel = new cel();
            AppMethodBeat.m2505o(109923);
            return cel;
        }
    }

    /* renamed from: DF */
    public final void mo63079DF(int i) {
        this.field_sourceType |= i;
    }

    /* renamed from: Fc */
    public final void mo63080Fc(int i) {
        this.field_itemStoryFlag |= i;
    }

    /* renamed from: Fd */
    public final void mo63081Fd(int i) {
        this.field_itemStoryFlag &= i ^ -1;
    }

    public final boolean cBV() {
        AppMethodBeat.m2504i(109924);
        int i = this.field_itemStoryFlag;
        C35184a c35184a = C35183a.sdm;
        boolean cf = C8902b.m16046cf(i, C35183a.sdd);
        AppMethodBeat.m2505o(109924);
        return cf;
    }

    public final boolean cBW() {
        AppMethodBeat.m2504i(109925);
        int i = this.field_itemStoryFlag;
        C35184a c35184a = C35183a.sdm;
        boolean cf = C8902b.m16046cf(i, C35183a.sde);
        AppMethodBeat.m2505o(109925);
        return cf;
    }

    /* renamed from: ac */
    public static boolean m68297ac(int i, long j) {
        boolean z = true;
        AppMethodBeat.m2504i(109926);
        if (C1947ae.gjB) {
            C4990ab.m7416i(TAG, "Android Test time limit fail " + C1947ae.gjB);
            AppMethodBeat.m2505o(109926);
        } else {
            boolean z2;
            int aaF = C1839cb.aaF() - ((int) j);
            C35184a c35184a = C35183a.sdm;
            boolean z3 = aaF > C35183a.scX;
            if (i > 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!(z3 || z2)) {
                z = false;
            }
            if (z) {
                C4990ab.m7416i(TAG, "isTimeLimit " + z3 + "  " + z2 + " tryCount:" + i + " startTime " + j + "  svr: " + C1839cb.aaF());
            }
            AppMethodBeat.m2505o(109926);
        }
        return z;
    }

    public final boolean cBX() {
        AppMethodBeat.m2504i(109927);
        if (this.field_createTime <= C1839cb.aaF() - 86400) {
            AppMethodBeat.m2505o(109927);
            return true;
        }
        AppMethodBeat.m2505o(109927);
        return false;
    }
}
