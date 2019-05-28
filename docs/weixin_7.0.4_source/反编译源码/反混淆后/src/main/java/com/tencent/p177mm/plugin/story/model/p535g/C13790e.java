package com.tencent.p177mm.plugin.story.model.p535g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.loader.p864g.C26365c;
import com.tencent.p177mm.loader.p864g.C45423h;
import com.tencent.p177mm.p230g.p232b.p233a.C1584ak;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.plugin.story.model.C29309l;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C43649s;
import com.tencent.p177mm.plugin.story.model.C46284g;
import com.tencent.p177mm.plugin.story.model.C46284g.C22238a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29275c;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29275c.C29276a;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C29292g;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35188e;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.protocal.protobuf.cel;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "call", "", "checkRemuxVideo", "", "filePath", "", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "doUploadStory", "uniqueId", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.g.e */
public final class C13790e extends C26365c {
    private static final String TAG = TAG;
    public static final C13791a rXU = new C13791a();
    private C39879j rXz;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/story/model/upload/UploadTask$doUploadStory$sightUpload$1", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "onSightUpLoadEnd", "", "errorCode", "", "isOk", "", "upload", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.e$d */
    public static final class C13789d implements C22238a {
        final /* synthetic */ C13790e rXX;

        C13789d(C13790e c13790e) {
            this.rXX = c13790e;
        }

        /* renamed from: a */
        public final void mo25980a(int i, boolean z, C46284g c46284g) {
            AppMethodBeat.m2504i(109478);
            C25052j.m39376p(c46284g, "upload");
            C22212h c22212h = C22212h.scu;
            C22212h.cAC().mo4992aW((long) i);
            c22212h = C22212h.scu;
            C1584ak cAC = C22212h.cAC();
            long currentTimeMillis = System.currentTimeMillis();
            C22212h c22212h2 = C22212h.scu;
            cAC.mo4991aV(currentTimeMillis - C22212h.cAC().mo4988Fu());
            c22212h = C22212h.scu;
            C22212h.cAD();
            if (z) {
                this.rXX.mo44157a(C45423h.OK);
                AppMethodBeat.m2505o(109478);
                return;
            }
            this.rXX.mo44157a(C45423h.Fail);
            AppMethodBeat.m2505o(109478);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/UploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.e$a */
    public static final class C13791a {
        private C13791a() {
        }

        public /* synthetic */ C13791a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.e$b */
    static final class C13792b extends C25053k implements C31214a<C37091y> {
        public static final C13792b rXV = new C13792b();

        static {
            AppMethodBeat.m2504i(109476);
            AppMethodBeat.m2505o(109476);
        }

        C13792b() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return C37091y.AUy;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.e$c */
    static final class C13793c extends C25053k implements C31214a<C37091y> {
        public static final C13793c rXW = new C13793c();

        static {
            AppMethodBeat.m2504i(109477);
            AppMethodBeat.m2505o(109477);
        }

        C13793c() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return C37091y.AUy;
        }
    }

    public C13790e(C39879j c39879j) {
        C25052j.m39376p(c39879j, "storyInfo");
        AppMethodBeat.m2504i(109481);
        this.rXz = c39879j;
        AppMethodBeat.m2505o(109481);
    }

    static {
        AppMethodBeat.m2504i(109482);
        AppMethodBeat.m2505o(109482);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0198  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Pa */
    public final void mo9026Pa() {
        AppMethodBeat.m2504i(109479);
        cel cBU = this.rXz.cBU();
        cek cek = (cek) this.rXz.cBR().xeA.wbK.get(0);
        C29309l c29309l = C29309l.rTg;
        String aat = C29309l.aat(cek.f4416Id);
        c29309l = C29309l.rTg;
        String aas = C29309l.aas(cek.f4416Id);
        int i = cBU.wFD;
        C35188e c35188e = C35188e.sdz;
        C13794f c13794f;
        if (i == C35188e.cBz()) {
            mo44157a(C45423h.OK);
            AppMethodBeat.m2505o(109479);
        } else if (cBU.eRu > 5) {
            c13794f = C13794f.rXY;
            C13794f.m21945a(this.rXz, -1, "", C13792b.rXV);
            mo44157a(C45423h.Fail);
            AppMethodBeat.m2505o(109479);
        } else if (C5730e.asZ(aat) < 0) {
            c13794f = C13794f.rXY;
            C13794f.m21945a(this.rXz, -1, "", C13793c.rXW);
            mo44157a(C45423h.Fail);
            AppMethodBeat.m2505o(109479);
        } else {
            Object obj;
            C35188e c35188e2 = C35188e.sdz;
            cBU.wFD = C35188e.cBB();
            C39879j c39879j = this.rXz;
            byte[] toByteArray = cBU.toByteArray();
            C25052j.m39375o(toByteArray, "postInfo.toByteArray()");
            c39879j.mo63083bk(toByteArray);
            C4133a c4133a = C43644j.rST;
            C4133a.cxT().mo74398a((int) this.rXz.xDa, this.rXz);
            C43649s c43649s = C43649s.rTV;
            String a = C43649s.m78154a(cek);
            C1694a K = C1720g.m3528K(C7234a.class);
            C25052j.m39375o(K, "MMKernel.service<IConfig…onfigService::class.java)");
            if (C5046bo.getInt(((C7234a) K).mo15608Nu().getValue("StoryCheckSendVideoBitrateExceed"), 0) == 1 && !C5046bo.isNullOrNil(a)) {
                C4990ab.m7416i(TAG, "checkRemuxVideo, filePath:".concat(String.valueOf(a)));
                C29276a c29276a = (C29276a) C29275c.rRk.mo53288Uw();
                if (a == null) {
                    C25052j.dWJ();
                }
                if (c29276a.aab(a)) {
                    C4990ab.m7416i(TAG, "checkRemuxVideo, exceed bitrate:".concat(String.valueOf(a)));
                    C29292g c29292g = C29292g.sbU;
                    C29292g.cAk();
                    c29276a.aaa(a);
                    String str = a + ".remux";
                    C4990ab.m7416i(TAG, "remux outputFilepath:".concat(String.valueOf(str)));
                    long yz = C5046bo.m7588yz();
                    int remuxing = SightVideoJNI.remuxing(a, str, c29276a.eTi, c29276a.eTj, c29276a.videoBitrate, C29014b.qwY, 8, 2, 25.0f, (float) c29276a.eTk, null, 0, C29014b.qwX);
                    C4990ab.m7416i(TAG, "remux cost:" + C5046bo.m7525az(yz) + "ms, ret:" + remuxing);
                    if (remuxing >= 0) {
                        C5730e.m8623aQ(str, a);
                    } else {
                        cBU.eRu++;
                        C39879j c39879j2 = this.rXz;
                        toByteArray = cBU.toByteArray();
                        C25052j.m39375o(toByteArray, "postInfo.toByteArray()");
                        c39879j2.mo63083bk(toByteArray);
                        C4133a c4133a2 = C43644j.rST;
                        C4133a.cxT().mo74398a((int) this.rXz.xDa, this.rXz);
                        C5730e.deleteFile(str);
                        mo44157a(C45423h.Fail);
                        obj = 1;
                        if (obj == null) {
                            C22212h c22212h = C22212h.scu;
                            C22212h.cAC().mo4991aV(System.currentTimeMillis());
                            new C35214b(this.rXz, aat, aas, new C13789d(this)).cne();
                        }
                        AppMethodBeat.m2505o(109479);
                    }
                }
                C4990ab.m7416i(TAG, "checkRemuxVideo, no need remux");
            }
            obj = null;
            if (obj == null) {
            }
            AppMethodBeat.m2505o(109479);
        }
    }

    /* renamed from: Pc */
    public final String mo9027Pc() {
        AppMethodBeat.m2504i(109480);
        String valueOf = String.valueOf((int) this.rXz.xDa);
        AppMethodBeat.m2505o(109480);
        return valueOf;
    }
}
