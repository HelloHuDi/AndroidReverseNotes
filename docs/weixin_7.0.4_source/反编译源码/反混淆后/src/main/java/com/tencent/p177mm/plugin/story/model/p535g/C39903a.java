package com.tencent.p177mm.plugin.story.model.p535g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.p864g.C26365c;
import com.tencent.p177mm.loader.p864g.C26366d;
import com.tencent.p177mm.loader.p864g.C42155f;
import com.tencent.p177mm.loader.p864g.C45423h;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.story.api.C22174j;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C43646p;
import com.tencent.p177mm.plugin.story.model.C43646p.C13798a;
import com.tencent.p177mm.plugin.story.model.p744a.C7140h;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35188e;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.protocal.protobuf.cel;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;
import java.util.Iterator;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0011\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J,\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019H\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020\u0019H\u0016R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "uploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/loader/loader/LoaderCore;)V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1;", "call", "", "notifyError", "errType", "", "errMsg", "", "mediaLocalId", "notifyEventUI", "localId", "isOk", "", "onSceneEnd", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLoadPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "startPost", "storyPost", "content", "clientId", "tryPost", "postInfo", "uniqueId", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.g.a */
public final class C39903a extends C26365c implements C1202f {
    public static final C39904a rXB = new C39904a();
    private final HashSet<C22174j> listeners = new HashSet();
    private final C26366d<C13790e> rXA;
    private final C39905g rXy = new C39905g();
    C39879j rXz;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/model/upload/PostTask$tryPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.a$f */
    public static final class C13787f implements C42155f<C13790e> {
        final /* synthetic */ C39903a rXC;

        C13787f(C39903a c39903a) {
            this.rXC = c39903a;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo9004a(C26365c c26365c, C45423h c45423h) {
            AppMethodBeat.m2504i(109431);
            C25052j.m39376p((C13790e) c26365c, "task");
            C25052j.m39376p(c45423h, "status");
            if (c45423h == C45423h.OK) {
                this.rXC.mo9026Pa();
                AppMethodBeat.m2505o(109431);
                return;
            }
            this.rXC.mo44157a(C45423h.Wait);
            AppMethodBeat.m2505o(109431);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.a$d */
    static final class C22239d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C39903a rXC;
        final /* synthetic */ int rXD;
        final /* synthetic */ boolean rXE = false;

        C22239d(C39903a c39903a, int i) {
            this.rXC = c39903a;
            this.rXD = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109429);
            C4133a c4133a = C43644j.rST;
            if (C4133a.cnn()) {
                C4990ab.m7412e("MicroMsg.StoryPostTask", "is invalid to getstoryInfoStorage");
            } else {
                Iterator it = this.rXC.listeners.iterator();
                while (it.hasNext()) {
                    C22174j c22174j = (C22174j) it.next();
                    if (c22174j != null) {
                        c22174j.cwW();
                    }
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109429);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.a$c */
    static final class C31572c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C39903a rXC;

        C31572c(C39903a c39903a) {
            this.rXC = c39903a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109428);
            this.rXC.mo44157a(C45423h.Fail);
            C39903a.m68327a(this.rXC, (int) this.rXC.rXz.xDa);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109428);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.a$e */
    static final class C35213e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ String rVA;
        final /* synthetic */ C39903a rXC;
        final /* synthetic */ String rXF;

        C35213e(C39903a c39903a, String str, String str2) {
            this.rXC = c39903a;
            this.rVA = str;
            this.rXF = str2;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109430);
            C4133a c4133a = C43644j.rST;
            if (C4133a.cnn()) {
                C4990ab.m7412e("MicroMsg.StoryPostTask", "is invalid to getstoryInfoStorage");
            } else {
                cel a = C39903a.m68326a(this.rXC);
                a.eRu++;
                C39879j c39879j = this.rXC.rXz;
                byte[] toByteArray = a.toByteArray();
                C25052j.m39375o(toByteArray, "postInfo.toByteArray()");
                c39879j.mo63083bk(toByteArray);
                c4133a = C43644j.rST;
                C4133a.cxT().mo74398a((int) this.rXC.rXz.xDa, this.rXC.rXz);
                c4133a = C43644j.rST;
                if (C4133a.cxT().abb(((int) this.rXC.rXz.xDa) + '_' + this.rXC.rXz.field_createTime)) {
                    this.rXC.mo44157a(C45423h.OK);
                } else {
                    C7140h c7140h = new C7140h(this.rVA, this.rXF, (int) this.rXC.rXz.xDa);
                    C1682b RO = C1720g.m3535RO();
                    C25052j.m39375o(RO, "MMKernel.network()");
                    RO.mo5186Rg().mo14539a(351, (C1202f) this.rXC);
                    RO = C1720g.m3535RO();
                    C25052j.m39375o(RO, "MMKernel.network()");
                    RO.mo5186Rg().mo14552d((C1207m) c7140h);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109430);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.a$b */
    static final class C39902b extends C25053k implements C17126b<Exception, C37091y> {
        final /* synthetic */ C39903a rXC;

        C39902b(C39903a c39903a) {
            this.rXC = c39903a;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(109427);
            Exception exception = (Exception) obj;
            C25052j.m39376p(exception, "it");
            C39903a c39903a = this.rXC;
            C35184a c35184a = C35183a.sdm;
            C39903a.m68328a(c39903a, C35183a.scS, "MediaPostInfo parser error:" + exception.getMessage());
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109427);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/PostTask$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.a$a */
    public static final class C39904a {
        private C39904a() {
        }

        public /* synthetic */ C39904a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.g.a$g */
    public static final class C39905g implements C42155f<C26365c> {
        C39905g() {
        }

        /* renamed from: a */
        public final void mo9004a(C26365c c26365c, C45423h c45423h) {
            AppMethodBeat.m2504i(109432);
            C25052j.m39376p(c26365c, "task");
            C25052j.m39376p(c45423h, "status");
            AppMethodBeat.m2505o(109432);
        }
    }

    static {
        AppMethodBeat.m2504i(109440);
        AppMethodBeat.m2505o(109440);
    }

    public C39903a(C39879j c39879j, C26366d<C13790e> c26366d) {
        C25052j.m39376p(c39879j, "storyInfo");
        C25052j.m39376p(c26366d, "uploadQueue");
        AppMethodBeat.m2504i(109439);
        this.rXz = c39879j;
        this.rXA = c26366d;
        AppMethodBeat.m2505o(109439);
    }

    /* renamed from: a */
    public static final /* synthetic */ cel m68326a(C39903a c39903a) {
        AppMethodBeat.m2504i(109441);
        cel czu = c39903a.czu();
        AppMethodBeat.m2505o(109441);
        return czu;
    }

    private final cel czu() {
        AppMethodBeat.m2504i(109433);
        C1331a parseFrom = new cel().parseFrom(this.rXz.field_postBuf);
        if (parseFrom == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
            AppMethodBeat.m2505o(109433);
            throw c44941v;
        }
        cel cel = (cel) parseFrom;
        C39879j c39879j = this.rXz;
        byte[] toByteArray = cel.toByteArray();
        C25052j.m39375o(toByteArray, "postInfo.toByteArray()");
        c39879j.mo63083bk(toByteArray);
        C4133a c4133a = C43644j.rST;
        C4133a.cxT().mo74398a((int) this.rXz.xDa, this.rXz);
        AppMethodBeat.m2505o(109433);
        return cel;
    }

    /* renamed from: Pa */
    public final void mo9026Pa() {
        AppMethodBeat.m2504i(109434);
        cel cel = (cel) C8902b.m16040a(new cel(), this.rXz.field_postBuf, new C39902b(this));
        if (cel != null) {
            if (C39879j.m68297ac(cel.eRu, cel.wFi)) {
                C35184a c35184a = C35183a.sdm;
                m68330bk(C35183a.scW, "this item isTimeLimit");
                C4990ab.m7416i("MicroMsg.StoryPostTask", "StoryInfo localId it time limit " + ((int) this.rXz.xDa) + " is die count " + cel.eRu + " time: " + cel.wFi);
                AppMethodBeat.m2505o(109434);
                return;
            }
            int i = cel.wFD;
            C35188e c35188e = C35188e.sdz;
            if (i == C35188e.cBz()) {
                cel czu = czu();
                C35184a c35184a2;
                if (C39879j.m68297ac(czu.eRu, czu.wFi)) {
                    c35184a2 = C35183a.sdm;
                    m68330bk(C35183a.scW, "this item isTimeLimit");
                    C4990ab.m7416i("MicroMsg.StoryPostTask", "storyInfo localId it time limit " + ((int) this.rXz.xDa) + " is die ");
                    AppMethodBeat.m2505o(109434);
                    return;
                }
                cfb cBR = this.rXz.cBR();
                C13798a c13798a = C43646p.rTj;
                String a = C13798a.m21948a(cBR, czu.xej);
                C4990ab.m7416i("MicroMsg.StoryPostTask", "startPost content " + a + "  testValue " + C1947ae.gjA);
                if (C25052j.m39373j(a, "")) {
                    c35184a2 = C35183a.sdm;
                    m68330bk(C35183a.scV, "content is error");
                    AppMethodBeat.m2505o(109434);
                    return;
                }
                String str;
                if (C1947ae.gjA) {
                    str = "<Test>Android Test Fail</Test>";
                } else {
                    str = a;
                }
                String str2 = czu.ptv;
                C25052j.m39375o(str2, "postInfo.ClientId");
                C8902b.m16042a(new C35213e(this, str, str2));
                AppMethodBeat.m2505o(109434);
                return;
            }
            C35188e c35188e2 = C35188e.sdz;
            this.rXA.mo44159a(new C13790e(this.rXz), new C13787f(this));
        }
        AppMethodBeat.m2505o(109434);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(109435);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14546b(351, (C1202f) this);
        mo44157a(C45423h.OK);
        AppMethodBeat.m2505o(109435);
    }

    /* renamed from: Pc */
    public final String mo9027Pc() {
        AppMethodBeat.m2504i(109436);
        String valueOf = String.valueOf((int) this.rXz.xDa);
        AppMethodBeat.m2505o(109436);
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ void m68328a(C39903a c39903a, int i, String str) {
        AppMethodBeat.m2504i(109438);
        c39903a.m68330bk(i, str);
        AppMethodBeat.m2505o(109438);
    }

    /* renamed from: bk */
    private final void m68330bk(int i, String str) {
        AppMethodBeat.m2504i(109437);
        C4990ab.m7416i("MicroMsg.StoryPostTask", "processError localId " + ((int) this.rXz.xDa) + " processError " + i + " errMsg: " + str);
        C13794f c13794f = C13794f.rXY;
        C13794f.m21945a(this.rXz, i, str, new C31572c(this));
        AppMethodBeat.m2505o(109437);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m68327a(C39903a c39903a, int i) {
        AppMethodBeat.m2504i(109442);
        C8902b.m16042a(new C22239d(c39903a, i));
        AppMethodBeat.m2505o(109442);
    }
}
