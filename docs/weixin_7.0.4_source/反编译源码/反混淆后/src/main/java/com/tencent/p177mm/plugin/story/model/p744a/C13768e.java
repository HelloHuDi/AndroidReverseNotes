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
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C27003i;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.story.model.C29310n;
import com.tencent.p177mm.plugin.story.model.C29310n.C29311a;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.protocal.protobuf.ceb;
import com.tencent.p177mm.protocal.protobuf.cec;
import com.tencent.p177mm.protocal.protobuf.cer;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\u001a\u0010(\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010+\u001a\u00020\u0010H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J>\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00102\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000e¨\u0006:"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "date", "(Ljava/lang/String;JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "forSameMd5Count", "", "fp", "", "getFp", "()Z", "setFp", "(Z)V", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "insertList", "", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryDateDetailResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.a.e */
public final class C13768e extends C1207m implements C1918k {
    private static final String TAG = TAG;
    public static final C13769a rUQ = new C13769a();
    private int cvp;
    private C7472b ehh;
    private C1202f ehi;
    private boolean qIW;
    private long qIX = 0;
    private long qIY;
    private String qJA;
    private long qKi;
    private String qkq;
    private long rUP;
    public String userName;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.a.e$a */
    public static final class C13769a {
        private C13769a() {
        }

        public /* synthetic */ C13769a(byte b) {
            this();
        }
    }

    public C13768e(String str, String str2) {
        boolean z = false;
        C25052j.m39376p(str, "userName");
        C25052j.m39376p(str2, FFmpegMetadataRetriever.METADATA_KEY_DATE);
        AppMethodBeat.m2504i(109219);
        this.userName = str;
        this.qkq = str2;
        this.qJA = "";
        if (this.qIX == 0) {
            C4990ab.m7416i(TAG, "fp mUserName " + this.userName);
        } else {
            C4990ab.m7416i(TAG, "np mUserName " + this.userName);
        }
        C35184a c35184a = C35183a.sdm;
        this.cvp = C35183a.scw;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(new ceb());
        c1196a.mo4446b(new cec());
        c1196a.mo4450qq("/cgi-bin/micromsg-bin/mmstorydatedetail");
        c1196a.mo4447kU(C27003i.CTRL_INDEX);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        C7472b acD = c1196a.acD();
        C25052j.m39375o(acD, "builder.buildInstance()");
        this.ehh = acD;
        C1331a acz = this.ehh.acz();
        if (acz == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailRequest");
            AppMethodBeat.m2505o(109219);
            throw c44941v;
        }
        int parseFloat;
        ceb ceb;
        ceb ceb2 = (ceb) acz;
        ceb2.jBB = this.userName;
        ceb2.wZU = this.qIX;
        try {
            String dpA = C5046bo.dpA();
            C25052j.m39375o(dpA, "Util.getTimeZoneOffset()");
            parseFloat = (int) Float.parseFloat(dpA);
            ceb = ceb2;
        } catch (Exception e) {
            ceb = ceb2;
            parseFloat = 0;
        }
        ceb.lvg = parseFloat;
        ceb2.xdK = this.qkq;
        if (this.qIX == 0) {
            z = true;
        }
        this.qIW = z;
        this.rUP = this.qIX;
        C4990ab.m7416i(TAG, "req.mUserName:" + ceb2.jBB + " req.MaxId:" + ceb2.wZU + " req.TimeZone:" + ceb2.lvg + " req.Date:" + ceb2.xdK);
        AppMethodBeat.m2505o(109219);
    }

    static {
        AppMethodBeat.m2504i(109220);
        AppMethodBeat.m2505o(109220);
    }

    public final int getType() {
        return C27003i.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(109217);
        C25052j.m39376p(c1202f, "callback");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(109217);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(109218);
        C4990ab.m7410d(TAG, "netId=" + i + " errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
        C1331a acA = this.ehh.acA();
        if (acA == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailResponse");
            AppMethodBeat.m2505o(109218);
            throw c44941v;
        }
        cec cec = (cec) acA;
        this.qKi = cec.xdM;
        C4990ab.m7416i(TAG, "objCount: " + cec.xds + ", expiredTime: " + cec.vAR);
        C1202f c1202f;
        if (cec.xdL.isEmpty()) {
            C4990ab.m7410d(TAG, "error: server give size zero");
            c1202f = this.ehi;
            if (c1202f == null) {
                C25052j.avw("callback");
            }
            c1202f.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(109218);
            return;
        }
        C29311a c29311a = C29310n.rTi;
        C29311a.m46534b(this.userName, cec.xdL, this.cvp);
        if (this.qIX == 0) {
            LinkedList linkedList = cec.xdL;
            C25052j.m39375o(linkedList, "resp.StoryList");
            this.qIX = ((cer) linkedList.getFirst()).vQE;
        }
        C4990ab.m7417i(TAG, "insertList mUserName %s maxId %s minId %s", this.userName, Long.valueOf(this.qIX), Long.valueOf(this.qIY));
        c1202f = this.ehi;
        if (c1202f == null) {
            C25052j.avw("callback");
        }
        c1202f.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(109218);
    }
}
