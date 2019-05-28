package com.tencent.p177mm.plugin.story.model.p744a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.story.model.C22242m;
import com.tencent.p177mm.plugin.story.model.C22242m.C22243a;
import com.tencent.p177mm.plugin.story.model.C22244o.C22245a;
import com.tencent.p177mm.plugin.story.model.C29310n;
import com.tencent.p177mm.plugin.story.model.C29310n.C29311a;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C43647q;
import com.tencent.p177mm.plugin.story.model.C43647q.C39911a;
import com.tencent.p177mm.plugin.story.p532h.C22213h;
import com.tencent.p177mm.plugin.story.p532h.C22213h.C13764a;
import com.tencent.p177mm.plugin.story.p532h.C29296g;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C46275k;
import com.tencent.p177mm.protocal.protobuf.cef;
import com.tencent.p177mm.protocal.protobuf.ceg;
import com.tencent.p177mm.protocal.protobuf.ceh;
import com.tencent.p177mm.protocal.protobuf.cer;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C17355d;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0006H\u0002J\u001a\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0006H\u0002J\b\u0010.\u001a\u00020\rH\u0016J\u0010\u0010/\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0002J>\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\r2\b\u00106\u001a\u0004\u0018\u00010\u00042\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0010\"\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u000e\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006<"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "(Ljava/lang/String;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "deleteFaultdData", "", "storyId", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "existFaultData", "getType", "insertList", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryHistoryPageResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.a.f */
public final class C7136f extends C1207m implements C1918k {
    private static final String TAG = TAG;
    public static final C7137a rUR = new C7137a();
    private int cvp;
    private boolean czr;
    private C7472b ehh;
    private C1202f ehi;
    public boolean qIW;
    private long qIX;
    private long qIY;
    private String qJA = "";
    public long qKi;
    private long rUP;
    public String userName;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.a.f$a */
    public static final class C7137a {
        private C7137a() {
        }

        public /* synthetic */ C7137a(byte b) {
            this();
        }
    }

    public C7136f(String str, long j, boolean z) {
        long j2 = 0;
        int i = 0;
        C25052j.m39376p(str, "userName");
        AppMethodBeat.m2504i(109228);
        this.userName = str;
        this.qIX = j;
        this.czr = z;
        if (this.qIX == 0) {
            C4990ab.m7416i(TAG, "fp mUserName " + this.userName);
        } else {
            C4990ab.m7416i(TAG, "np mUserName " + this.userName);
        }
        C35184a c35184a = C35183a.sdm;
        int cAQ = C35183a.scy;
        C35184a c35184a2 = C35183a.sdm;
        this.cvp = cAQ | C35183a.scw;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(new ceg());
        c1196a.mo4446b(new ceh());
        c1196a.mo4450qq("/cgi-bin/micromsg-bin/mmstoryhistorypage");
        c1196a.mo4447kU(191);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        C7472b acD = c1196a.acD();
        C25052j.m39375o(acD, "builder.buildInstance()");
        this.ehh = acD;
        C1331a acz = this.ehh.acz();
        if (acz == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageRequest");
            AppMethodBeat.m2505o(109228);
            throw c44941v;
        }
        ceg ceg;
        ceg ceg2 = (ceg) acz;
        ceg2.jBB = this.userName;
        ceg2.wZU = this.qIX;
        this.qIW = this.qIX == 0;
        C4133a c4133a = C43644j.rST;
        C4133a.cyd();
        int aaC = C22245a.aaC(this.userName);
        C4133a c4133a2 = C43644j.rST;
        C46275k cxT = C4133a.cxT();
        if (!this.qIW) {
            j2 = this.qIX;
        }
        this.qIY = cxT.mo74395E(j2, aaC);
        ceg2.xbw = this.qIY;
        ceg2.xbx = 0;
        try {
            String dpA = C5046bo.dpA();
            C25052j.m39375o(dpA, "Util.getTimeZoneOffset()");
            i = (int) Float.parseFloat(dpA);
            ceg = ceg2;
        } catch (Exception e) {
            ceg = ceg2;
        }
        ceg.lvg = i;
        if (this.qIW) {
            c4133a = C43644j.rST;
            C29296g cxU = C4133a.cxU();
            C35184a c35184a3 = C35183a.sdm;
            this.qJA = cxU.aaV(C35183a.scD);
            if (this.qJA == null) {
                this.qJA = "";
            }
            ceg2.wZT = this.qJA;
        }
        this.rUP = this.qIX;
        C4990ab.m7416i(TAG, "req.mUserName:" + ceg2.jBB + " req.MaxId:" + ceg2.wZU + " req.MinFilterId:" + ceg2.xbw + " req.LastRequestTime:" + ceg2.xbx + " req.FirstPageMd5:" + ceg2.wZT + " req.TimeZone:" + ceg2.lvg);
        AppMethodBeat.m2505o(109228);
    }

    static {
        AppMethodBeat.m2504i(109229);
        AppMethodBeat.m2505o(109229);
    }

    public final int getType() {
        return 191;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(109225);
        C25052j.m39376p(c1202f, "callback");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(109225);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(109226);
        C4990ab.m7410d(TAG, "netId=" + i + " errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
        C1331a acA = this.ehh.acA();
        if (acA == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageResponse");
            AppMethodBeat.m2505o(109226);
            throw c44941v;
        }
        ceh ceh = (ceh) acA;
        this.qKi = ceh.xdM;
        String str2 = ceh.wZT;
        if (str2 == null) {
            str2 = "";
        }
        C4990ab.m7416i(TAG, "objCount:" + ceh.xec + " firstPageMd5:" + str2 + ", expiredTime:" + ceh.vAR);
        C1202f c1202f;
        if (ceh.xed.isEmpty()) {
            C4990ab.m7410d(TAG, "error: server give size zero");
            c1202f = this.ehi;
            if (c1202f == null) {
                C25052j.avw("callback");
            }
            c1202f.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(109226);
            return;
        }
        C4133a c4133a = C43644j.rST;
        C29296g cxU = C4133a.cxU();
        C35184a c35184a = C35183a.sdm;
        cxU.mo47505gB(C35183a.scD, str2);
        if (this.qIX == 0) {
            Object obj;
            long j = ((cef) ceh.xed.get(ceh.xed.size() - 1)).vQE;
            C29311a c29311a = C29310n.rTi;
            if (j > C29311a.aaB(this.userName).field_storyID) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                j = ((cef) ceh.xed.get(ceh.xed.size() - 1)).vQE;
                str2 = this.userName;
                C4133a c4133a2 = C43644j.rST;
                if (C5046bo.isEqual(str2, C4133a.cnk())) {
                    c29311a = C29310n.rTi;
                    str2 = this.userName;
                    C25052j.m39376p(str2, "userName");
                    c4133a2 = C43644j.rST;
                    C46275k cxT = C4133a.cxT();
                    C25052j.m39376p(str2, "userName");
                    C4990ab.m7410d(C46275k.TAG, "deleteStoryByIdBefore " + str2 + ' ' + j + " res " + cxT.bSd.mo10108hY(C46275k.sdP, "DELETE FROM " + C46275k.sdP + " where " + C46275k.sdP + ".userName='" + C5046bo.m7586vA(str2) + "' AND " + C46275k.sdP + ".storyID<" + j));
                }
            }
        }
        m11944a(ceh);
        c1202f = this.ehi;
        if (c1202f == null) {
            C25052j.avw("callback");
        }
        c1202f.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(109226);
    }

    /* renamed from: a */
    private final void m11944a(ceh ceh) {
        LinkedList linkedList;
        AppMethodBeat.m2504i(109227);
        LinkedList<cef> linkedList2 = ceh.xed;
        C25052j.m39375o(linkedList2, "resp.HistoryItemList");
        for (cef cef : linkedList2) {
            C4990ab.m7410d(TAG, "date=" + cef.xdK + " count=" + cef.xds + " id=" + cef.vQE);
            C29311a c29311a = C29310n.rTi;
            String str = this.userName;
            cer cer = cef.xdJ;
            C25052j.m39375o(cer, "it.StoryObject");
            int i = this.cvp;
            C25052j.m39376p(str, "userName");
            C25052j.m39376p(cer, "storyObj");
            C4133a c4133a = C43644j.rST;
            C46275k cxT = C4133a.cxT();
            C4990ab.m7410d(C29310n.TAG, "insertStory storyObj.id:" + cer.vQE);
            C39879j lt = cxT.mo74415lt(cer.vQE);
            if (lt == null) {
                lt = new C39879j();
            }
            C25052j.m39376p(lt, "storyInfo");
            C25052j.m39376p(cer, "storyObj");
            C25052j.m39376p(str, "userName");
            if (cer.xen == null || cer.xen.getBuffer() == null) {
                C4990ab.m7416i(C29310n.TAG, "object desc is null");
            } else {
                byte[] toByteArray = cer.xen.getBuffer().toByteArray();
                C25052j.m39375o(toByteArray, "storyObj.ObjDesc.getBuffer().toByteArray()");
                String str2 = new String(toByteArray, C17355d.UTF_8);
                C4990ab.m7411d(C29310n.TAG, "from server %d \n%s", Long.valueOf(cer.vQE), str2);
                C39911a c39911a = C43647q.rTk;
                cfb aaE = C39911a.aaE(str2);
                if (!(C5046bo.isNullOrNil(str2) || aaE == null || !lt.mo63084c(aaE))) {
                    C4990ab.m7411d(C29310n.TAG, "from server xml ok %d \n ".concat(String.valueOf(str2)), Long.valueOf(cer.vQE));
                    cer.xen.setBuffer(new byte[0]);
                    lt.field_userName = cer.jBB;
                    lt.field_createTime = cer.pcX;
                    lt.field_storyID = cer.vQE;
                    if (!cer.xeo.isEmpty()) {
                        lt.field_attrBuf = cer.toByteArray();
                    }
                    C4990ab.m7416i(C29310n.TAG, "id:" + lt.field_storyID + " createTime:" + lt.field_createTime + " CommentListSize:" + cer.xeo.size() + " BubbleListSize:" + cer.xeq.size());
                    lt.mo63079DF(i);
                    aaE = lt.cBR();
                    aaE.jBB = cer.jBB;
                    lt.mo63082b(aaE);
                    C4133a c4133a2 = C43644j.rST;
                    if (C4133a.cxT().mo74414kv(cer.vQE)) {
                        c4133a2 = C43644j.rST;
                        C4133a.cxT().mo74405b(cer.vQE, lt);
                        c4133a = C43644j.rST;
                        C4133a.cxT().mo74417lx(cer.vQE);
                    } else {
                        c4133a2 = C43644j.rST;
                        C4133a.cxT().mo74411d(lt);
                    }
                }
            }
            C22243a c22243a = C22242m.rTh;
            C25052j.m39375o(cef, "it");
            C25052j.m39376p(cef, "item");
            C13764a c13764a = C22213h.sdT;
            C25052j.m39376p(cef, "item");
            C22213h c22213h = new C22213h();
            String str3 = cef.xdK;
            if (str3 == null) {
                str3 = "";
            }
            c22213h.field_date = str3;
            c22213h.field_count = cef.xds;
            C4133a c4133a3 = C43644j.rST;
            C4133a.cxZ().mo74392a(c22213h);
        }
        if (this.qIX == 0) {
            linkedList = ceh.xed;
            C25052j.m39375o(linkedList, "resp.HistoryItemList");
            this.qIX = ((cef) linkedList.getFirst()).vQE;
        }
        linkedList = ceh.xed;
        C25052j.m39375o(linkedList, "resp.HistoryItemList");
        this.qIY = ((cef) linkedList.getLast()).vQE;
        C4990ab.m7417i(TAG, "insertList mUserName %s maxId %s minId %s NewRequestTime %s", this.userName, Long.valueOf(this.qIX), Long.valueOf(this.qIY), Integer.valueOf(ceh.xbC));
        AppMethodBeat.m2505o(109227);
    }
}
