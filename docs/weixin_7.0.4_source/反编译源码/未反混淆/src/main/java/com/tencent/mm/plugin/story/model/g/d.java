package com.tencent.mm.plugin.story.model.g;

import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.ab.b;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.e.c;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.m;
import com.tencent.mm.plugin.story.model.q;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

@l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0010J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u000eJ\u000e\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0010J\u000e\u0010$\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper;", "", "()V", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "timelineInfo", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "checkToCreateDir", "", "newVideoPath", "", "commit", "", "createStory", "", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "thumbPath", "path", "videoMd5", "setEditorData", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "setFavorite", "favorite", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "setPublishObjId", "publishObjId", "setScope", "scope", "setSightExtInfo", "Companion", "plugin-story_release"})
public final class d {
    private static final String TAG = TAG;
    private static final Pattern gIU = Pattern.compile("(\n){3,}");
    public static final a rXT = new a();
    private cel rXR;
    private cfb rXS;
    private j rXz = new j();
    private baa rkB;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper$Companion;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getPATTERN", "()Ljava/util/regex/Pattern;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public d() {
        AppMethodBeat.i(109474);
        this.rXz.cBS();
        j jVar = this.rXz;
        com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
        int cAO = com.tencent.mm.plugin.story.h.a.scw;
        com.tencent.mm.plugin.story.h.a.a aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
        jVar.DF(cAO | com.tencent.mm.plugin.story.h.a.scy);
        jVar = this.rXz;
        com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
        jVar.field_userName = com.tencent.mm.plugin.story.model.j.a.cnk();
        this.rXz.field_createTime = cb.aaF();
        this.rXR = new cel();
        this.rkB = new baa();
        cel cel = this.rXR;
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.story.model.j.a aVar4 = com.tencent.mm.plugin.story.model.j.rST;
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.plugin.story.model.j.a.cnk()).append(bo.yz()).append(cb.aaE()).toString();
        Charset charset = a.k.d.UTF_8;
        if (stringBuilder2 == null) {
            v vVar = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(109474);
            throw vVar;
        }
        byte[] bytes = stringBuilder2.getBytes(charset);
        a.f.b.j.o(bytes, "(this as java.lang.String).getBytes(charset)");
        cel.ptv = g.x(bytes);
        com.tencent.mm.plugin.story.model.q.a aVar5 = q.rTk;
        this.rXS = com.tencent.mm.plugin.story.model.q.a.cyq();
        cfb cfb = this.rXS;
        aVar3 = com.tencent.mm.plugin.story.model.j.rST;
        cfb.jBB = com.tencent.mm.plugin.story.model.j.a.cnk();
        this.rXS.pcX = this.rXz.field_createTime;
        h hVar = h.scu;
        Object Fv = h.cAm().Fv();
        if (Fv == null) {
            Fv = "";
        }
        a.f.b.j.p(Fv, "publishObjId");
        this.rXS.xeB = Fv;
        ab.d(TAG, "storyInfo.createTime=%s timelineInfo.CreateTime=%s", Integer.valueOf(this.rXz.field_createTime), Integer.valueOf(this.rXS.pcX));
        AppMethodBeat.o(109474);
    }

    static {
        AppMethodBeat.i(109475);
        AppMethodBeat.o(109475);
    }

    private static void Yw(String str) {
        AppMethodBeat.i(109468);
        e.tf(e.atb(str));
        AppMethodBeat.o(109468);
    }

    public final int commit() {
        j jVar;
        AppMethodBeat.i(109469);
        try {
            this.rXR.wFi = (long) cb.aaF();
            this.rXR.eRu = 0;
            jVar = this.rXz;
            byte[] toByteArray = this.rXR.toByteArray();
            a.f.b.j.o(toByteArray, "postInfo.toByteArray()");
            jVar.bk(toByteArray);
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
        }
        this.rXz.b(this.rXS);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        int d = com.tencent.mm.plugin.story.model.j.a.cxT().d(this.rXz);
        aVar = com.tencent.mm.plugin.story.model.j.rST;
        c cya = com.tencent.mm.plugin.story.model.j.a.cya();
        b.a(new e(cya, d));
        cya.checkPost();
        com.tencent.mm.plugin.story.model.m.a aVar2 = m.rTh;
        jVar = this.rXz;
        a.f.b.j.p(jVar, "storyInfo");
        if (d != -1) {
            com.tencent.mm.plugin.story.e.b.a aVar3 = com.tencent.mm.plugin.story.e.b.rRO;
            String j = com.tencent.mm.plugin.story.e.b.a.j(Integer.valueOf(jVar.field_createTime));
            ab.d(m.TAG, "insertByLocalStory date=".concat(String.valueOf(j)));
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.h aaZ = com.tencent.mm.plugin.story.model.j.a.cxZ().aaZ(j);
            if (aaZ == null) {
                aaZ = new com.tencent.mm.plugin.story.h.h();
            }
            a.f.b.j.p(j, "value");
            aaZ.field_date = j;
            aaZ.field_count++;
            ab.d(m.TAG, "storyHistory.count=" + aaZ.field_count);
            com.tencent.mm.plugin.story.model.j.a aVar4 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxZ().a(aaZ);
        }
        ab.d(TAG, "save story to db: ".concat(String.valueOf(d)));
        AppMethodBeat.o(109469);
        return d;
    }

    public final void b(baa baa) {
        AppMethodBeat.i(109470);
        a.f.b.j.p(baa, IssueStorage.COLUMN_EXT_INFO);
        this.rkB = baa;
        AppMethodBeat.o(109470);
    }

    public final d a(cei cei) {
        if (cei != null) {
            this.rXS.xez = cei;
        }
        return this;
    }

    public final void a(cej cej) {
        AppMethodBeat.i(109471);
        a.f.b.j.p(cej, "editorInfo");
        this.rXR.xej = cej;
        AppMethodBeat.o(109471);
    }

    public final void EM(int i) {
        this.rXS.xeC = i;
    }

    public final void EN(int i) {
        AppMethodBeat.i(138797);
        this.rXS.xeD = i;
        if (i == 1) {
            j jVar = this.rXz;
            com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
            jVar.Fc(com.tencent.mm.plugin.story.h.a.sde);
        }
        AppMethodBeat.o(138797);
    }

    public final boolean am(String str, String str2, String str3) {
        AppMethodBeat.i(109472);
        a.f.b.j.p(str, "path");
        a.f.b.j.p(str2, "thumbPath");
        a.f.b.j.p(str3, "videoMd5");
        com.tencent.mm.plugin.story.model.q.a aVar = q.rTk;
        cek cek = new cek();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.story.e.c.a aVar2 = c.rRS;
        stringBuilder = stringBuilder.append(c.rRP);
        String str4 = cb.aaE() + '-' + bo.yz();
        Charset charset = a.k.d.UTF_8;
        if (str4 == null) {
            v vVar = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(109472);
            throw vVar;
        }
        byte[] bytes = str4.getBytes(charset);
        a.f.b.j.o(bytes, "(this as java.lang.String).getBytes(charset)");
        cek.Id = stringBuilder.append(g.x(bytes)).toString();
        com.tencent.mm.plugin.story.model.l lVar = com.tencent.mm.plugin.story.model.l.rTg;
        String aat = com.tencent.mm.plugin.story.model.l.aat(cek.Id);
        com.tencent.mm.plugin.story.model.l lVar2 = com.tencent.mm.plugin.story.model.l.rTg;
        str4 = com.tencent.mm.plugin.story.model.l.aas(cek.Id);
        com.tencent.mm.plugin.story.model.l lVar3 = com.tencent.mm.plugin.story.model.l.rTg;
        com.tencent.mm.plugin.story.model.l.aax(aat);
        lVar3 = com.tencent.mm.plugin.story.model.l.rTg;
        com.tencent.mm.plugin.story.model.l.aax(str4);
        Yw(aat);
        Yw(str4);
        e.y(str, aat);
        e.y(str2, str4);
        cek.duration = ((float) com.tencent.mm.plugin.sight.base.d.WR(aat).eWK) / 1000.0f;
        this.rXS.xeA.wbK.add(cek);
        AppMethodBeat.o(109472);
        return true;
    }

    public final boolean a(com.tencent.mm.plugin.story.h.d dVar, String str) {
        AppMethodBeat.i(109473);
        a.f.b.j.p(dVar, "storyEditorData");
        a.f.b.j.p(str, "thumbPath");
        com.tencent.mm.plugin.story.model.q.a aVar = q.rTk;
        cek cek = new cek();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.story.e.c.a aVar2 = c.rRS;
        stringBuilder = stringBuilder.append(c.rRP);
        String str2 = cb.aaE() + '-' + bo.yz();
        Charset charset = a.k.d.UTF_8;
        if (str2 == null) {
            v vVar = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(109473);
            throw vVar;
        }
        byte[] bytes = str2.getBytes(charset);
        a.f.b.j.o(bytes, "(this as java.lang.String).getBytes(charset)");
        cek.Id = stringBuilder.append(g.x(bytes)).toString();
        com.tencent.mm.plugin.story.model.l lVar = com.tencent.mm.plugin.story.model.l.rTg;
        String aas = com.tencent.mm.plugin.story.model.l.aas(cek.Id);
        Yw(aas);
        e.y(str, aas);
        cek.cNE = (int) dVar.xDa;
        this.rXS.xeA.wbK.add(cek);
        j jVar = this.rXz;
        int i = jVar.field_localFlag;
        com.tencent.mm.plugin.story.h.a.c cVar = com.tencent.mm.plugin.story.h.a.c.sds;
        jVar.field_localFlag = i | com.tencent.mm.plugin.story.h.a.c.cBw();
        jVar = this.rXz;
        i = jVar.field_localFlag;
        cVar = com.tencent.mm.plugin.story.h.a.c.sds;
        jVar.field_localFlag = i & (com.tencent.mm.plugin.story.h.a.c.cBu() ^ -1);
        AppMethodBeat.o(109473);
        return true;
    }
}
