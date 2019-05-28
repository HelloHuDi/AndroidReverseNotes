package com.tencent.p177mm.plugin.story.model.p535g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.story.model.C22242m;
import com.tencent.p177mm.plugin.story.model.C22242m.C22243a;
import com.tencent.p177mm.plugin.story.model.C29309l;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C43647q;
import com.tencent.p177mm.plugin.story.model.C43647q.C39911a;
import com.tencent.p177mm.plugin.story.model.p535g.C7149c.C7155e;
import com.tencent.p177mm.plugin.story.p1303e.C22177b;
import com.tencent.p177mm.plugin.story.p1303e.C22177b.C22178a;
import com.tencent.p177mm.plugin.story.p1303e.C29282c;
import com.tencent.p177mm.plugin.story.p1303e.C29282c.C29283a;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p532h.C22213h;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35187c;
import com.tencent.p177mm.plugin.story.p532h.C39878d;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.protocal.protobuf.cei;
import com.tencent.p177mm.protocal.protobuf.cej;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.protocal.protobuf.cel;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C17355d;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0010J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u000eJ\u000e\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0010J\u000e\u0010$\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper;", "", "()V", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "timelineInfo", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "checkToCreateDir", "", "newVideoPath", "", "commit", "", "createStory", "", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "thumbPath", "path", "videoMd5", "setEditorData", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "setFavorite", "favorite", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "setPublishObjId", "publishObjId", "setScope", "scope", "setSightExtInfo", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.g.d */
public final class C4131d {
    private static final String TAG = TAG;
    private static final Pattern gIU = Pattern.compile("(\n){3,}");
    public static final C4132a rXT = new C4132a();
    private cel rXR;
    private cfb rXS;
    private C39879j rXz = new C39879j();
    private baa rkB;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper$Companion;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getPATTERN", "()Ljava/util/regex/Pattern;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.d$a */
    public static final class C4132a {
        private C4132a() {
        }

        public /* synthetic */ C4132a(byte b) {
            this();
        }
    }

    public C4131d() {
        AppMethodBeat.m2504i(109474);
        this.rXz.cBS();
        C39879j c39879j = this.rXz;
        C35184a c35184a = C35183a.sdm;
        int cAO = C35183a.scw;
        C35184a c35184a2 = C35183a.sdm;
        c39879j.mo63079DF(cAO | C35183a.scy);
        c39879j = this.rXz;
        C4133a c4133a = C43644j.rST;
        c39879j.field_userName = C4133a.cnk();
        this.rXz.field_createTime = C1839cb.aaF();
        this.rXR = new cel();
        this.rkB = new baa();
        cel cel = this.rXR;
        StringBuilder stringBuilder = new StringBuilder();
        C4133a c4133a2 = C43644j.rST;
        String stringBuilder2 = stringBuilder.append(C4133a.cnk()).append(C5046bo.m7588yz()).append(C1839cb.aaE()).toString();
        Charset charset = C17355d.UTF_8;
        if (stringBuilder2 == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.m2505o(109474);
            throw c44941v;
        }
        byte[] bytes = stringBuilder2.getBytes(charset);
        C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
        cel.ptv = C1178g.m2591x(bytes);
        C39911a c39911a = C43647q.rTk;
        this.rXS = C39911a.cyq();
        cfb cfb = this.rXS;
        c4133a = C43644j.rST;
        cfb.jBB = C4133a.cnk();
        this.rXS.pcX = this.rXz.field_createTime;
        C22212h c22212h = C22212h.scu;
        Object Fv = C22212h.cAm().mo4993Fv();
        if (Fv == null) {
            Fv = "";
        }
        C25052j.m39376p(Fv, "publishObjId");
        this.rXS.xeB = Fv;
        C4990ab.m7411d(TAG, "storyInfo.createTime=%s timelineInfo.CreateTime=%s", Integer.valueOf(this.rXz.field_createTime), Integer.valueOf(this.rXS.pcX));
        AppMethodBeat.m2505o(109474);
    }

    static {
        AppMethodBeat.m2504i(109475);
        AppMethodBeat.m2505o(109475);
    }

    /* renamed from: Yw */
    private static void m6455Yw(String str) {
        AppMethodBeat.m2504i(109468);
        C5730e.m8643tf(C5730e.atb(str));
        AppMethodBeat.m2505o(109468);
    }

    public final int commit() {
        C39879j c39879j;
        AppMethodBeat.m2504i(109469);
        try {
            this.rXR.wFi = (long) C1839cb.aaF();
            this.rXR.eRu = 0;
            c39879j = this.rXz;
            byte[] toByteArray = this.rXR.toByteArray();
            C25052j.m39375o(toByteArray, "postInfo.toByteArray()");
            c39879j.mo63083bk(toByteArray);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
        }
        this.rXz.mo63082b(this.rXS);
        C4133a c4133a = C43644j.rST;
        int d = C4133a.cxT().mo74411d(this.rXz);
        c4133a = C43644j.rST;
        C7149c cya = C4133a.cya();
        C8902b.m16042a(new C7155e(cya, d));
        cya.checkPost();
        C22243a c22243a = C22242m.rTh;
        c39879j = this.rXz;
        C25052j.m39376p(c39879j, "storyInfo");
        if (d != -1) {
            C22178a c22178a = C22177b.rRO;
            String j = C22178a.m33804j(Integer.valueOf(c39879j.field_createTime));
            C4990ab.m7410d(C22242m.TAG, "insertByLocalStory date=".concat(String.valueOf(j)));
            c4133a = C43644j.rST;
            C22213h aaZ = C4133a.cxZ().aaZ(j);
            if (aaZ == null) {
                aaZ = new C22213h();
            }
            C25052j.m39376p(j, "value");
            aaZ.field_date = j;
            aaZ.field_count++;
            C4990ab.m7410d(C22242m.TAG, "storyHistory.count=" + aaZ.field_count);
            C4133a c4133a2 = C43644j.rST;
            C4133a.cxZ().mo74392a(aaZ);
        }
        C4990ab.m7410d(TAG, "save story to db: ".concat(String.valueOf(d)));
        AppMethodBeat.m2505o(109469);
        return d;
    }

    /* renamed from: b */
    public final void mo9011b(baa baa) {
        AppMethodBeat.m2504i(109470);
        C25052j.m39376p(baa, IssueStorage.COLUMN_EXT_INFO);
        this.rkB = baa;
        AppMethodBeat.m2505o(109470);
    }

    /* renamed from: a */
    public final C4131d mo9007a(cei cei) {
        if (cei != null) {
            this.rXS.xez = cei;
        }
        return this;
    }

    /* renamed from: a */
    public final void mo9008a(cej cej) {
        AppMethodBeat.m2504i(109471);
        C25052j.m39376p(cej, "editorInfo");
        this.rXR.xej = cej;
        AppMethodBeat.m2505o(109471);
    }

    /* renamed from: EM */
    public final void mo9005EM(int i) {
        this.rXS.xeC = i;
    }

    /* renamed from: EN */
    public final void mo9006EN(int i) {
        AppMethodBeat.m2504i(138797);
        this.rXS.xeD = i;
        if (i == 1) {
            C39879j c39879j = this.rXz;
            C35184a c35184a = C35183a.sdm;
            c39879j.mo63080Fc(C35183a.sde);
        }
        AppMethodBeat.m2505o(138797);
    }

    /* renamed from: am */
    public final boolean mo9010am(String str, String str2, String str3) {
        AppMethodBeat.m2504i(109472);
        C25052j.m39376p(str, "path");
        C25052j.m39376p(str2, "thumbPath");
        C25052j.m39376p(str3, "videoMd5");
        C39911a c39911a = C43647q.rTk;
        cek cek = new cek();
        StringBuilder stringBuilder = new StringBuilder();
        C29283a c29283a = C29282c.rRS;
        stringBuilder = stringBuilder.append(C29282c.rRP);
        String str4 = C1839cb.aaE() + '-' + C5046bo.m7588yz();
        Charset charset = C17355d.UTF_8;
        if (str4 == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.m2505o(109472);
            throw c44941v;
        }
        byte[] bytes = str4.getBytes(charset);
        C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
        cek.f4416Id = stringBuilder.append(C1178g.m2591x(bytes)).toString();
        C29309l c29309l = C29309l.rTg;
        String aat = C29309l.aat(cek.f4416Id);
        C29309l c29309l2 = C29309l.rTg;
        str4 = C29309l.aas(cek.f4416Id);
        C29309l c29309l3 = C29309l.rTg;
        C29309l.aax(aat);
        c29309l3 = C29309l.rTg;
        C29309l.aax(str4);
        C4131d.m6455Yw(aat);
        C4131d.m6455Yw(str4);
        C5730e.m8644y(str, aat);
        C5730e.m8644y(str2, str4);
        cek.duration = ((float) C21846d.m33388WR(aat).eWK) / 1000.0f;
        this.rXS.xeA.wbK.add(cek);
        AppMethodBeat.m2505o(109472);
        return true;
    }

    /* renamed from: a */
    public final boolean mo9009a(C39878d c39878d, String str) {
        AppMethodBeat.m2504i(109473);
        C25052j.m39376p(c39878d, "storyEditorData");
        C25052j.m39376p(str, "thumbPath");
        C39911a c39911a = C43647q.rTk;
        cek cek = new cek();
        StringBuilder stringBuilder = new StringBuilder();
        C29283a c29283a = C29282c.rRS;
        stringBuilder = stringBuilder.append(C29282c.rRP);
        String str2 = C1839cb.aaE() + '-' + C5046bo.m7588yz();
        Charset charset = C17355d.UTF_8;
        if (str2 == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.m2505o(109473);
            throw c44941v;
        }
        byte[] bytes = str2.getBytes(charset);
        C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
        cek.f4416Id = stringBuilder.append(C1178g.m2591x(bytes)).toString();
        C29309l c29309l = C29309l.rTg;
        String aas = C29309l.aas(cek.f4416Id);
        C4131d.m6455Yw(aas);
        C5730e.m8644y(str, aas);
        cek.cNE = (int) c39878d.xDa;
        this.rXS.xeA.wbK.add(cek);
        C39879j c39879j = this.rXz;
        int i = c39879j.field_localFlag;
        C35187c c35187c = C35187c.sds;
        c39879j.field_localFlag = i | C35187c.cBw();
        c39879j = this.rXz;
        i = c39879j.field_localFlag;
        c35187c = C35187c.sds;
        c39879j.field_localFlag = i & (C35187c.cBu() ^ -1);
        AppMethodBeat.m2505o(109473);
        return true;
    }
}
