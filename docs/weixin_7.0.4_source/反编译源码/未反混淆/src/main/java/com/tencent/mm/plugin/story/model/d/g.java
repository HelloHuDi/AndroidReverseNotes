package com.tencent.mm.plugin.story.model.d;

import a.a.p;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.h.c;
import com.tencent.mm.plugin.story.h.d;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.q;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u0010\u0010%\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010&\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010(\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyTImeline", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;)V", "TAG", "", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getComment", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyId", "", "getStoryId", "()J", "getStoryItemScene", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "getStoryTImeline", "()Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "convertFromFakeDB", "", "timeStamp", "convertFromStoryInfo", "equals", "other", "toString", "Companion", "plugin-story_release"})
public final class g {
    public static final a rWe = new a();
    private final String TAG;
    public final long rUJ;
    public final i rVZ;
    public final f rWa;
    public final j rWb;
    private final cfb rWc;
    public final h rWd;
    public String userName;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem$Companion;", "", "()V", "createStoryGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "createStoryGalleryItemForSns", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static /* synthetic */ g c(j jVar) {
            AppMethodBeat.i(138771);
            g a = a(jVar, h.NORMAL);
            AppMethodBeat.o(138771);
            return a;
        }

        public static g a(j jVar, h hVar) {
            AppMethodBeat.i(138770);
            a.f.b.j.p(jVar, "story");
            a.f.b.j.p(hVar, "storyItemScene");
            g gVar = new g(jVar, jVar.cBR(), hVar);
            AppMethodBeat.o(138770);
            return gVar;
        }

        public static g a(f fVar) {
            AppMethodBeat.i(109313);
            a.f.b.j.p(fVar, IssueStorage.COLUMN_EXT_INFO);
            j jVar = new j();
            jVar.field_storyID = fVar.field_syncId;
            jVar.field_createTime = fVar.field_storyPostTime;
            jVar.field_userName = fVar.getUserName();
            com.tencent.mm.plugin.story.model.q.a aVar = q.rTk;
            cfb cyq = com.tencent.mm.plugin.story.model.q.a.cyq();
            cyq.jBB = fVar.getUserName();
            cyq.pcX = fVar.field_storyPostTime;
            aVar = q.rTk;
            cek cek = new cek();
            cek.Id = "empty_" + cb.aaE();
            cek.wEH = fVar.cBK();
            cek.Url = fVar.cBJ();
            cek.duration = fVar.field_duration > 0 ? (float) (((double) fVar.field_duration) / 1000.0d) : 0.0f;
            cyq.xeA.wbK.add(cek);
            jVar.c(cyq);
            g gVar = new g(jVar, cyq);
            AppMethodBeat.o(109313);
            return gVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class b<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            AppMethodBeat.i(138772);
            int a = a.b.b.a(Integer.valueOf(((com.tencent.mm.plugin.story.model.b.a) t).fDG), Integer.valueOf(((com.tencent.mm.plugin.story.model.b.a) t2).fDG));
            AppMethodBeat.o(138772);
            return a;
        }
    }

    static {
        AppMethodBeat.i(109319);
        AppMethodBeat.o(109319);
    }

    public /* synthetic */ g(j jVar, cfb cfb) {
        this(jVar, cfb, h.NORMAL);
        AppMethodBeat.i(109318);
        AppMethodBeat.o(109318);
    }

    public g(j jVar, cfb cfb, h hVar) {
        a.f.b.j.p(jVar, "story");
        a.f.b.j.p(cfb, "storyTImeline");
        a.f.b.j.p(hVar, "storyItemScene");
        AppMethodBeat.i(138773);
        this.rWb = jVar;
        this.rWc = cfb;
        this.rWd = hVar;
        this.TAG = "MicroMsg.StoryGalleryItem";
        this.rUJ = this.rWb.field_storyID;
        int i = (int) this.rWb.xDa;
        long j = this.rWb.field_storyID;
        int i2 = this.rWb.field_createTime;
        String str = this.rWb.field_userName;
        if (str == null) {
            str = "";
        }
        i iVar = new i(i, j, i2, str);
        cfb cfb2 = this.rWc;
        if (cfb2.xeA.wbK.size() > 0) {
            Object obj = cfb2.xeA.wbK.get(0);
            a.f.b.j.o(obj, "timeline.ContentObj.MediaObjList[0]");
            cek cek = (cek) obj;
            a.f.b.j.p(cek, "<set-?>");
            iVar.rWj = cek;
        }
        iVar.rWk = cfb2.xez;
        this.rVZ = iVar;
        this.rWa = new f();
        b(this.rWb);
        AppMethodBeat.o(138773);
    }

    /* JADX WARNING: Missing block: B:54:0x014f, code skipped:
            if (com.tencent.mm.vfs.e.ct(com.tencent.mm.plugin.story.model.s.a(r11.rVZ.rWj)) != false) goto L_0x0151;
     */
    /* JADX WARNING: Missing block: B:64:0x01c7, code skipped:
            if (r0 == null) goto L_0x01c9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean b(j jVar) {
        com.tencent.mm.plugin.story.model.j.a aVar;
        int i;
        cdv cdv;
        com.tencent.mm.plugin.story.model.b.a aVar2;
        String str;
        boolean z;
        int i2 = 0;
        AppMethodBeat.i(109315);
        cer cer = new cer();
        try {
            cer.parseFrom(jVar.field_attrBuf);
        } catch (Exception e) {
        }
        f fVar = this.rWa;
        Object obj = jVar.field_userName;
        if (obj == null) {
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            obj = com.tencent.mm.plugin.story.model.j.a.cnk();
        }
        a.f.b.j.p(obj, "<set-?>");
        fVar.rVl = obj;
        this.rWa.rUJ = jVar.field_storyID;
        this.rWa.rqw = 0;
        aVar = com.tencent.mm.plugin.story.model.j.rST;
        c lr = com.tencent.mm.plugin.story.model.j.a.cxW().lr(jVar.field_storyID);
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
            a.f.b.j.o(cdv, "commentDetail");
            aVar2 = new com.tencent.mm.plugin.story.model.b.a(cdv);
            if (lr != null && lr.field_readCommentTime > 0 && aVar2.fDG > lr.field_readCommentTime) {
                str = aVar2.cEV;
                com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
                if (!bo.isEqual(str, com.tencent.mm.plugin.story.model.j.a.cnk())) {
                    aVar2.rVh = true;
                    z3 = true;
                    this.rWa.rrj.add(aVar2);
                    aVar2.aaG(this.rWa.rVl);
                    aVar2.rVn = jVar.cBX();
                    z2 = z3;
                }
            }
            z3 = z2;
            this.rWa.rrj.add(aVar2);
            aVar2.aaG(this.rWa.rVl);
            aVar2.rVn = jVar.cBX();
            z2 = z3;
        }
        it = cer.xeq.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            cdv = (cdv) it.next();
            a.f.b.j.o(cdv, "bubleDetail");
            aVar2 = new com.tencent.mm.plugin.story.model.b.a(cdv);
            if (lr != null && lr.field_readCommentTime > 0 && aVar2.fDG > lr.field_readCommentTime) {
                str = aVar2.cEV;
                com.tencent.mm.plugin.story.model.j.a aVar4 = com.tencent.mm.plugin.story.model.j.rST;
                if (!bo.isEqual(str, com.tencent.mm.plugin.story.model.j.a.cnk())) {
                    aVar2.rVh = true;
                    z2 = true;
                    this.rWa.rrj.add(aVar2);
                    aVar2.aaG(this.rWa.rVl);
                    aVar2.rVn = jVar.cBX();
                }
            }
            z2 = z;
            this.rWa.rrj.add(aVar2);
            aVar2.aaG(this.rWa.rVl);
            aVar2.rVn = jVar.cBX();
        }
        List list = this.rWa.rrj;
        if (list.size() > 1) {
            p.a(list, new b());
        }
        if (i != 0 && this.rWa.rrj.size() > 0) {
            com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
            long j = this.rUJ;
            obj = this.rWa.rrj.get(0);
            a.f.b.j.o(obj, "comment.commentList[0]");
            com.tencent.mm.plugin.story.model.b.b.a(j, (com.tencent.mm.plugin.story.model.b.a) obj);
        }
        this.rWa.rVh = z;
        if (jVar != null) {
            str = jVar.field_userName;
        } else {
            str = null;
        }
        this.userName = str;
        s sVar = s.rTV;
        cek cek = this.rVZ.rWj;
        str = jVar.field_userName;
        if (str == null) {
            str = "";
        }
        if (!e.ct(s.a(cek, str))) {
            sVar = s.rTV;
        }
        i2 = 1;
        if (i2 == 0 && this.rVZ.rWj.cNE >= 0) {
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            d ls = com.tencent.mm.plugin.story.model.j.a.cxY().ls((long) this.rVZ.rWj.cNE);
            if (ls != null) {
                String str2 = this.TAG;
                StringBuilder append = new StringBuilder("find fake video ").append(this.rVZ).append(" media ");
                com.tencent.mm.plugin.story.e.c.a aVar5 = com.tencent.mm.plugin.story.e.c.rRS;
                cek cek2 = this.rVZ.rWj;
                if (cek2 != null) {
                    str = "Media localId " + cek2.cNE + " url " + cek2.Url + " thumb " + cek2.wEH + " duration " + cek2.duration;
                }
                str = "";
                ab.i(str2, append.append(str).toString());
                long j2 = ls.field_timeStamp;
                com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.sac;
                cee lh = com.tencent.mm.plugin.story.f.l.lh(j2);
                if (lh != null) {
                    i iVar = this.rVZ;
                    j jVar2 = j.Fake;
                    a.f.b.j.p(jVar2, "<set-?>");
                    iVar.rWi = jVar2;
                    this.rVZ.timeStamp = lh.timeStamp;
                    this.rVZ.rWj.wEH = lh.thumbPath;
                    this.rVZ.rWj.Id = "fake_" + lh.timeStamp;
                    this.rVZ.rWk = lh.smk;
                    if (e.ct(lh.videoPath)) {
                        iVar = this.rVZ;
                        lVar = com.tencent.mm.plugin.story.f.l.sac;
                        iVar.rWl = com.tencent.mm.plugin.story.f.l.lh(lh.timeStamp);
                    } else {
                        com.tencent.mm.plugin.story.f.l lVar2 = com.tencent.mm.plugin.story.f.l.sac;
                        com.tencent.mm.plugin.story.f.l.li(lh.timeStamp);
                    }
                }
            }
        }
        ab.i(this.TAG, "LogStory: ".concat(String.valueOf(this)));
        AppMethodBeat.o(109315);
        return true;
    }

    public final String toString() {
        AppMethodBeat.i(109316);
        String str = "StoryGalleryItem(videoItem=" + this.rVZ + ", comment=" + this.rWa + ')';
        AppMethodBeat.o(109316);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(109317);
        if (!(obj instanceof g)) {
            AppMethodBeat.o(109317);
            return false;
        } else if (this == obj) {
            AppMethodBeat.o(109317);
            return true;
        } else if (this.rUJ == ((g) obj).rUJ && a.f.b.j.j(this.rVZ, ((g) obj).rVZ) && a.f.b.j.j(this.rWa, ((g) obj).rWa) && this.rWb.cBU().eRu == ((g) obj).rWb.cBU().eRu) {
            AppMethodBeat.o(109317);
            return true;
        } else {
            AppMethodBeat.o(109317);
            return false;
        }
    }
}
