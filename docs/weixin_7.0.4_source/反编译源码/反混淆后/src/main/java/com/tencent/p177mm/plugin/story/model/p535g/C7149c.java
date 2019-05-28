package com.tencent.p177mm.plugin.story.model.p535g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p864g.C26365c;
import com.tencent.p177mm.loader.p864g.C26366d;
import com.tencent.p177mm.loader.p864g.C42155f;
import com.tencent.p177mm.loader.p864g.C45423h;
import com.tencent.p177mm.loader.p864g.p1196a.C18536g;
import com.tencent.p177mm.loader.p864g.p1196a.C18537h;
import com.tencent.p177mm.loader.p864g.p1196a.C46886a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.story.api.C22174j;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p744a.C7140h;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.proxy.C4140c;
import com.tencent.p177mm.plugin.story.proxy.C4140c.C4141a;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\n\u0010\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0014\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0018\u001a\u00020\bH\u0002J\u0006\u0010\u0019\u001a\u00020\bJ\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010\u0015\u001a\u00020\bJ,\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0006\u0010(\u001a\u00020\bJ\u0010\u0010)\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\u0006\u0010*\u001a\u00020\bJ\u000e\u0010+\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010,\u001a\u00020\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\rX\u000e¢\u0006\u0002\n\u0000¨\u0006."}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "onFakeDataUpdateCallback", "Lkotlin/Function0;", "", "postCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1;", "uploadQueue", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "addFakeDataListener", "onFakeDataUpdate", "addPostEndListener", "listener", "checkMixStory", "checkPost", "notifyEndPost", "localId", "", "isOk", "", "notifyEventPost", "notifyStartPost", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "removeFakeDataListener", "removePostEndListener", "start", "startPost", "stop", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.g.c */
public final class C7149c implements C1202f {
    public static final C7150a rXO = new C7150a();
    private final HashSet<C22174j> listeners = new HashSet();
    public C26366d<C13790e> rXA = new C26366d(new C18536g(new C46886a(100), new C18537h(), "storyUpload"));
    public C26366d<C39903a> rXK = new C26366d(new C18536g(new C46886a(100), new C18537h(), "storyPost"));
    public C31214a<C37091y> rXL;
    public final C7154f rXM = new C7154f(this);
    public final C4130h rXN = new C4130h();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.c$b */
    static final class C4129b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C7149c rXP;
        final /* synthetic */ C22174j rXQ;

        C4129b(C7149c c7149c, C22174j c22174j) {
            this.rXP = c7149c;
            this.rXQ = c22174j;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109450);
            if (this.rXQ != null) {
                this.rXP.listeners.add(this.rXQ);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109450);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.c$h */
    public static final class C4130h implements C42155f<C13790e> {
        C4130h() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo9004a(C26365c c26365c, C45423h c45423h) {
            AppMethodBeat.m2504i(109456);
            C25052j.m39376p((C13790e) c26365c, "task");
            C25052j.m39376p(c45423h, "status");
            AppMethodBeat.m2505o(109456);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/UploadManager$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.c$a */
    public static final class C7150a {
        private C7150a() {
        }

        public /* synthetic */ C7150a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.c$c */
    static final class C7151c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ int rXD;
        final /* synthetic */ boolean rXE;
        final /* synthetic */ C7149c rXP;

        C7151c(C7149c c7149c, int i, boolean z) {
            this.rXP = c7149c;
            this.rXD = i;
            this.rXE = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109451);
            C4133a c4133a = C43644j.rST;
            if (C4133a.cnn()) {
                C4990ab.m7412e("MicroMsg.StoryUploadTask", "is invalid to getSnsInfoStorage");
            } else {
                for (C22174j cwW : this.rXP.listeners) {
                    cwW.cwW();
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109451);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.c$d */
    static final class C7152d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ int rXD;
        final /* synthetic */ boolean rXE = false;
        final /* synthetic */ C7149c rXP;

        C7152d(C7149c c7149c, int i) {
            this.rXP = c7149c;
            this.rXD = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109452);
            C4133a c4133a = C43644j.rST;
            if (C4133a.cnn()) {
                C4990ab.m7412e("MicroMsg.StoryUploadTask", "is invalid to getSnsInfoStorage");
            } else {
                for (C22174j cwX : this.rXP.listeners) {
                    cwX.cwX();
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109452);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.c$g */
    static final class C7153g extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C7149c rXP;
        final /* synthetic */ C22174j rXQ;

        C7153g(C7149c c7149c, C22174j c22174j) {
            this.rXP = c7149c;
            this.rXQ = c22174j;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109455);
            if (this.rXQ != null) {
                this.rXP.listeners.remove(this.rXQ);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109455);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.c$f */
    public static final class C7154f implements C42155f<C39903a> {
        final /* synthetic */ C7149c rXP;

        C7154f(C7149c c7149c) {
            this.rXP = c7149c;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo9004a(C26365c c26365c, C45423h c45423h) {
            AppMethodBeat.m2504i(109454);
            C39903a c39903a = (C39903a) c26365c;
            C25052j.m39376p(c39903a, "task");
            C25052j.m39376p(c45423h, "status");
            if (c45423h == C45423h.OK) {
                this.rXP.checkPost();
                AppMethodBeat.m2505o(109454);
                return;
            }
            C7149c.m11960a(this.rXP, (int) c39903a.rXz.xDa);
            AppMethodBeat.m2505o(109454);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.c$e */
    static final class C7155e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ int rXD;
        final /* synthetic */ C7149c rXP;

        C7155e(C7149c c7149c, int i) {
            this.rXP = c7149c;
            this.rXD = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109453);
            C4133a c4133a = C43644j.rST;
            if (C4133a.cnn()) {
                C4990ab.m7412e("MicroMsg.StoryUploadTask", "is invalid to getSnsInfoStorage");
            } else {
                for (C22174j EI : this.rXP.listeners) {
                    EI.mo9102EI(this.rXD);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109453);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(109466);
        AppMethodBeat.m2505o(109466);
    }

    public C7149c() {
        AppMethodBeat.m2504i(109465);
        AppMethodBeat.m2505o(109465);
    }

    public final void checkPost() {
        AppMethodBeat.m2504i(109457);
        C7149c.czw();
        C4133a c4133a = C43644j.rST;
        C39879j cCc = C4133a.cxT().cCc();
        if (cCc == null) {
            C4990ab.m7410d("MicroMsg.StoryUploadTask", "All has post");
            AppMethodBeat.m2505o(109457);
            return;
        }
        C4990ab.m7410d("MicroMsg.StoryUploadTask", "checking story from db, will post: " + cCc.field_storyID + ' ' + ((int) cCc.xDa) + ' ' + cCc.field_userName + ' ' + cCc.cBU().eRu);
        this.rXK.mo44158a((C26365c) new C39903a(cCc, this.rXA));
        C22212h c22212h = C22212h.scu;
        C22212h.m33889EY((int) cCc.xDa).mo67626co(C5046bo.anU());
        c22212h = C22212h.scu;
        C22212h.m33889EY((int) cCc.xDa).mo67625cG((long) C5023at.m7472gC(C4996ah.getContext()));
        AppMethodBeat.m2505o(109457);
    }

    private static void czw() {
        AppMethodBeat.m2504i(109458);
        C4141a c4141a = C4140c.saU;
        C4141a.czN().czM();
        AppMethodBeat.m2505o(109458);
    }

    /* renamed from: e */
    public final void mo15487e(C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(109459);
        C25052j.m39376p(c31214a, "onFakeDataUpdate");
        this.rXL = c31214a;
        AppMethodBeat.m2505o(109459);
    }

    public final void czx() {
        AppMethodBeat.m2504i(109460);
        C31214a c31214a = this.rXL;
        if (c31214a != null) {
            c31214a.invoke();
            AppMethodBeat.m2505o(109460);
            return;
        }
        AppMethodBeat.m2505o(109460);
    }

    /* renamed from: a */
    public final void mo15483a(C22174j c22174j) {
        AppMethodBeat.m2504i(109461);
        C8902b.m16042a(new C4129b(this, c22174j));
        AppMethodBeat.m2505o(109461);
    }

    /* renamed from: b */
    public final void mo15484b(C22174j c22174j) {
        AppMethodBeat.m2504i(109462);
        C8902b.m16042a(new C7153g(this, c22174j));
        AppMethodBeat.m2505o(109462);
    }

    /* renamed from: ah */
    private final void m11961ah(int i, boolean z) {
        AppMethodBeat.m2504i(109463);
        C8902b.m16042a(new C7151c(this, i, z));
        AppMethodBeat.m2505o(109463);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        C1207m c1207m2;
        AppMethodBeat.m2504i(109464);
        if (c1207m instanceof C7140h) {
            c1207m2 = c1207m;
        } else {
            c1207m2 = null;
        }
        C7140h c7140h = (C7140h) c1207m2;
        if (c7140h != null) {
            if (i == 4 || i2 == 0) {
                m11961ah(c7140h.cNE, true);
                C37091y c37091y;
                try {
                    C4133a c4133a = C43644j.rST;
                    C39879j Fe = C4133a.cxT().mo74397Fe(c7140h.cNE);
                    if (Fe != null) {
                        C22212h c22212h = C22212h.scu;
                        C22212h.m33889EY(c7140h.cNE).mo67640fQ(String.valueOf(Fe.field_storyID));
                        c22212h = C22212h.scu;
                        C22212h.m33889EY(c7140h.cNE).mo67638fO(((cek) Fe.cBR().xeA.wbK.get(0)).Url);
                        C22212h c22212h2 = C22212h.scu;
                        C22212h.m33889EY(c7140h.cNE).mo67627cp(C5046bo.anU());
                        c22212h2 = C22212h.scu;
                        C22212h.m33890EZ(c7140h.cNE);
                        c37091y = C37091y.AUy;
                        AppMethodBeat.m2505o(109464);
                        return;
                    }
                    AppMethodBeat.m2505o(109464);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.StoryUploadTask", e, "upload error", new Object[0]);
                    c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(109464);
                    return;
                }
            }
            m11961ah(c7140h.cNE, false);
        }
        AppMethodBeat.m2505o(109464);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m11960a(C7149c c7149c, int i) {
        AppMethodBeat.m2504i(109467);
        C8902b.m16042a(new C7152d(c7149c, i));
        AppMethodBeat.m2505o(109467);
    }
}
