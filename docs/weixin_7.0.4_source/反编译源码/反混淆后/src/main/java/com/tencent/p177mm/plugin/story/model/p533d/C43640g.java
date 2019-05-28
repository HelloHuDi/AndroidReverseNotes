package com.tencent.p177mm.plugin.story.model.p533d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C43647q;
import com.tencent.p177mm.plugin.story.model.C43647q.C39911a;
import com.tencent.p177mm.plugin.story.model.C43649s;
import com.tencent.p177mm.plugin.story.model.p1035b.C39889a;
import com.tencent.p177mm.plugin.story.model.p1035b.C46279b;
import com.tencent.p177mm.plugin.story.p1303e.C29282c;
import com.tencent.p177mm.plugin.story.p1303e.C29282c.C29283a;
import com.tencent.p177mm.plugin.story.p530f.C22210l;
import com.tencent.p177mm.plugin.story.p532h.C35191c;
import com.tencent.p177mm.plugin.story.p532h.C39878d;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.protocal.protobuf.cdv;
import com.tencent.p177mm.protocal.protobuf.cee;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.protocal.protobuf.cer;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import p000a.C0220l;
import p000a.p001a.C41363p;
import p000a.p005f.p007b.C25052j;
import p000a.p772b.C7992b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u0010\u0010%\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010&\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010(\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyTImeline", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;)V", "TAG", "", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getComment", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyId", "", "getStoryId", "()J", "getStoryItemScene", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "getStoryTImeline", "()Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "convertFromFakeDB", "", "timeStamp", "convertFromStoryInfo", "equals", "other", "toString", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.d.g */
public final class C43640g {
    public static final C4126a rWe = new C4126a();
    private final String TAG;
    public final long rUJ;
    public final C35201i rVZ;
    public final C43639f rWa;
    public final C39879j rWb;
    private final cfb rWc;
    public final C22234h rWd;
    public String userName;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem$Companion;", "", "()V", "createStoryGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "createStoryGalleryItemForSns", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.d.g$a */
    public static final class C4126a {
        private C4126a() {
        }

        public /* synthetic */ C4126a(byte b) {
            this();
        }

        /* renamed from: c */
        public static /* synthetic */ C43640g m6453c(C39879j c39879j) {
            AppMethodBeat.m2504i(138771);
            C43640g a = C4126a.m6452a(c39879j, C22234h.NORMAL);
            AppMethodBeat.m2505o(138771);
            return a;
        }

        /* renamed from: a */
        public static C43640g m6452a(C39879j c39879j, C22234h c22234h) {
            AppMethodBeat.m2504i(138770);
            C25052j.m39376p(c39879j, "story");
            C25052j.m39376p(c22234h, "storyItemScene");
            C43640g c43640g = new C43640g(c39879j, c39879j.cBR(), c22234h);
            AppMethodBeat.m2505o(138770);
            return c43640g;
        }

        /* renamed from: a */
        public static C43640g m6451a(C4119f c4119f) {
            AppMethodBeat.m2504i(109313);
            C25052j.m39376p(c4119f, IssueStorage.COLUMN_EXT_INFO);
            C39879j c39879j = new C39879j();
            c39879j.field_storyID = c4119f.field_syncId;
            c39879j.field_createTime = c4119f.field_storyPostTime;
            c39879j.field_userName = c4119f.getUserName();
            C39911a c39911a = C43647q.rTk;
            cfb cyq = C39911a.cyq();
            cyq.jBB = c4119f.getUserName();
            cyq.pcX = c4119f.field_storyPostTime;
            c39911a = C43647q.rTk;
            cek cek = new cek();
            cek.f4416Id = "empty_" + C1839cb.aaE();
            cek.wEH = c4119f.cBK();
            cek.Url = c4119f.cBJ();
            cek.duration = c4119f.field_duration > 0 ? (float) (((double) c4119f.field_duration) / 1000.0d) : 0.0f;
            cyq.xeA.wbK.add(cek);
            c39879j.mo63084c(cyq);
            C43640g c43640g = new C43640g(c39879j, cyq);
            AppMethodBeat.m2505o(109313);
            return c43640g;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    /* renamed from: com.tencent.mm.plugin.story.model.d.g$b */
    public static final class C4127b<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            AppMethodBeat.m2504i(138772);
            int a = C7992b.m14176a(Integer.valueOf(((C39889a) t).fDG), Integer.valueOf(((C39889a) t2).fDG));
            AppMethodBeat.m2505o(138772);
            return a;
        }
    }

    static {
        AppMethodBeat.m2504i(109319);
        AppMethodBeat.m2505o(109319);
    }

    public /* synthetic */ C43640g(C39879j c39879j, cfb cfb) {
        this(c39879j, cfb, C22234h.NORMAL);
        AppMethodBeat.m2504i(109318);
        AppMethodBeat.m2505o(109318);
    }

    public C43640g(C39879j c39879j, cfb cfb, C22234h c22234h) {
        C25052j.m39376p(c39879j, "story");
        C25052j.m39376p(cfb, "storyTImeline");
        C25052j.m39376p(c22234h, "storyItemScene");
        AppMethodBeat.m2504i(138773);
        this.rWb = c39879j;
        this.rWc = cfb;
        this.rWd = c22234h;
        this.TAG = "MicroMsg.StoryGalleryItem";
        this.rUJ = this.rWb.field_storyID;
        int i = (int) this.rWb.xDa;
        long j = this.rWb.field_storyID;
        int i2 = this.rWb.field_createTime;
        String str = this.rWb.field_userName;
        if (str == null) {
            str = "";
        }
        C35201i c35201i = new C35201i(i, j, i2, str);
        cfb cfb2 = this.rWc;
        if (cfb2.xeA.wbK.size() > 0) {
            Object obj = cfb2.xeA.wbK.get(0);
            C25052j.m39375o(obj, "timeline.ContentObj.MediaObjList[0]");
            cek cek = (cek) obj;
            C25052j.m39376p(cek, "<set-?>");
            c35201i.rWj = cek;
        }
        c35201i.rWk = cfb2.xez;
        this.rVZ = c35201i;
        this.rWa = new C43639f();
        m78107b(this.rWb);
        AppMethodBeat.m2505o(138773);
    }

    /* JADX WARNING: Missing block: B:54:0x014f, code skipped:
            if (com.tencent.p177mm.vfs.C5730e.m8628ct(com.tencent.p177mm.plugin.story.model.C43649s.m78154a(r11.rVZ.rWj)) != false) goto L_0x0151;
     */
    /* JADX WARNING: Missing block: B:64:0x01c7, code skipped:
            if (r0 == null) goto L_0x01c9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final boolean m78107b(C39879j c39879j) {
        C4133a c4133a;
        int i;
        cdv cdv;
        C39889a c39889a;
        String str;
        boolean z;
        int i2 = 0;
        AppMethodBeat.m2504i(109315);
        cer cer = new cer();
        try {
            cer.parseFrom(c39879j.field_attrBuf);
        } catch (Exception e) {
        }
        C43639f c43639f = this.rWa;
        Object obj = c39879j.field_userName;
        if (obj == null) {
            c4133a = C43644j.rST;
            obj = C4133a.cnk();
        }
        C25052j.m39376p(obj, "<set-?>");
        c43639f.rVl = obj;
        this.rWa.rUJ = c39879j.field_storyID;
        this.rWa.rqw = 0;
        c4133a = C43644j.rST;
        C35191c lr = C4133a.cxW().mo55842lr(c39879j.field_storyID);
        if (lr == null || lr.field_readCommentTime == 0) {
            i = true;
        } else {
            i = 0;
        }
        Iterator it = cer.xeo.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            boolean z3;
            cdv = (cdv) it.next();
            C25052j.m39375o(cdv, "commentDetail");
            c39889a = new C39889a(cdv);
            if (lr != null && lr.field_readCommentTime > 0 && c39889a.fDG > lr.field_readCommentTime) {
                str = c39889a.cEV;
                C4133a c4133a2 = C43644j.rST;
                if (!C5046bo.isEqual(str, C4133a.cnk())) {
                    c39889a.rVh = true;
                    z3 = true;
                    this.rWa.rrj.add(c39889a);
                    c39889a.aaG(this.rWa.rVl);
                    c39889a.rVn = c39879j.cBX();
                    z2 = z3;
                }
            }
            z3 = z2;
            this.rWa.rrj.add(c39889a);
            c39889a.aaG(this.rWa.rVl);
            c39889a.rVn = c39879j.cBX();
            z2 = z3;
        }
        it = cer.xeq.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            cdv = (cdv) it.next();
            C25052j.m39375o(cdv, "bubleDetail");
            c39889a = new C39889a(cdv);
            if (lr != null && lr.field_readCommentTime > 0 && c39889a.fDG > lr.field_readCommentTime) {
                str = c39889a.cEV;
                C4133a c4133a3 = C43644j.rST;
                if (!C5046bo.isEqual(str, C4133a.cnk())) {
                    c39889a.rVh = true;
                    z2 = true;
                    this.rWa.rrj.add(c39889a);
                    c39889a.aaG(this.rWa.rVl);
                    c39889a.rVn = c39879j.cBX();
                }
            }
            z2 = z;
            this.rWa.rrj.add(c39889a);
            c39889a.aaG(this.rWa.rVl);
            c39889a.rVn = c39879j.cBX();
        }
        List list = this.rWa.rrj;
        if (list.size() > 1) {
            C41363p.m72150a(list, new C4127b());
        }
        if (i != 0 && this.rWa.rrj.size() > 0) {
            C46279b c46279b = C46279b.rVw;
            long j = this.rUJ;
            obj = this.rWa.rrj.get(0);
            C25052j.m39375o(obj, "comment.commentList[0]");
            C46279b.m86756a(j, (C39889a) obj);
        }
        this.rWa.rVh = z;
        if (c39879j != null) {
            str = c39879j.field_userName;
        } else {
            str = null;
        }
        this.userName = str;
        C43649s c43649s = C43649s.rTV;
        cek cek = this.rVZ.rWj;
        str = c39879j.field_userName;
        if (str == null) {
            str = "";
        }
        if (!C5730e.m8628ct(C43649s.m78155a(cek, str))) {
            c43649s = C43649s.rTV;
        }
        i2 = 1;
        if (i2 == 0 && this.rVZ.rWj.cNE >= 0) {
            c4133a = C43644j.rST;
            C39878d ls = C4133a.cxY().mo17051ls((long) this.rVZ.rWj.cNE);
            if (ls != null) {
                String str2 = this.TAG;
                StringBuilder append = new StringBuilder("find fake video ").append(this.rVZ).append(" media ");
                C29283a c29283a = C29282c.rRS;
                cek cek2 = this.rVZ.rWj;
                if (cek2 != null) {
                    str = "Media localId " + cek2.cNE + " url " + cek2.Url + " thumb " + cek2.wEH + " duration " + cek2.duration;
                }
                str = "";
                C4990ab.m7416i(str2, append.append(str).toString());
                long j2 = ls.field_timeStamp;
                C22210l c22210l = C22210l.sac;
                cee lh = C22210l.m33884lh(j2);
                if (lh != null) {
                    C35201i c35201i = this.rVZ;
                    C22235j c22235j = C22235j.Fake;
                    C25052j.m39376p(c22235j, "<set-?>");
                    c35201i.rWi = c22235j;
                    this.rVZ.timeStamp = lh.timeStamp;
                    this.rVZ.rWj.wEH = lh.thumbPath;
                    this.rVZ.rWj.f4416Id = "fake_" + lh.timeStamp;
                    this.rVZ.rWk = lh.smk;
                    if (C5730e.m8628ct(lh.videoPath)) {
                        c35201i = this.rVZ;
                        c22210l = C22210l.sac;
                        c35201i.rWl = C22210l.m33884lh(lh.timeStamp);
                    } else {
                        C22210l c22210l2 = C22210l.sac;
                        C22210l.m33885li(lh.timeStamp);
                    }
                }
            }
        }
        C4990ab.m7416i(this.TAG, "LogStory: ".concat(String.valueOf(this)));
        AppMethodBeat.m2505o(109315);
        return true;
    }

    public final String toString() {
        AppMethodBeat.m2504i(109316);
        String str = "StoryGalleryItem(videoItem=" + this.rVZ + ", comment=" + this.rWa + ')';
        AppMethodBeat.m2505o(109316);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(109317);
        if (!(obj instanceof C43640g)) {
            AppMethodBeat.m2505o(109317);
            return false;
        } else if (this == obj) {
            AppMethodBeat.m2505o(109317);
            return true;
        } else if (this.rUJ == ((C43640g) obj).rUJ && C25052j.m39373j(this.rVZ, ((C43640g) obj).rVZ) && C25052j.m39373j(this.rWa, ((C43640g) obj).rWa) && this.rWb.cBU().eRu == ((C43640g) obj).rWb.cBU().eRu) {
            AppMethodBeat.m2505o(109317);
            return true;
        } else {
            AppMethodBeat.m2505o(109317);
            return false;
        }
    }
}
