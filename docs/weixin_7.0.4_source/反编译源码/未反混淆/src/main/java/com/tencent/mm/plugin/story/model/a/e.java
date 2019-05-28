package com.tencent.mm.plugin.story.model.a;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.i.i;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.protocal.protobuf.cec;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\u001a\u0010(\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010+\u001a\u00020\u0010H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J>\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00102\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000e¨\u0006:"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "date", "(Ljava/lang/String;JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "forSameMd5Count", "", "fp", "", "getFp", "()Z", "setFp", "(Z)V", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "insertList", "", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryDateDetailResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class e extends m implements k {
    private static final String TAG = TAG;
    public static final a rUQ = new a();
    private int cvp;
    private b ehh;
    private f ehi;
    private boolean qIW;
    private long qIX = 0;
    private long qIY;
    private String qJA;
    private long qKi;
    private String qkq;
    private long rUP;
    public String userName;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public e(String str, String str2) {
        boolean z = false;
        j.p(str, "userName");
        j.p(str2, FFmpegMetadataRetriever.METADATA_KEY_DATE);
        AppMethodBeat.i(109219);
        this.userName = str;
        this.qkq = str2;
        this.qJA = "";
        if (this.qIX == 0) {
            ab.i(TAG, "fp mUserName " + this.userName);
        } else {
            ab.i(TAG, "np mUserName " + this.userName);
        }
        com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
        this.cvp = com.tencent.mm.plugin.story.h.a.scw;
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.a(new ceb());
        aVar2.b(new cec());
        aVar2.qq("/cgi-bin/micromsg-bin/mmstorydatedetail");
        aVar2.kU(i.CTRL_INDEX);
        aVar2.kV(0);
        aVar2.kW(0);
        b acD = aVar2.acD();
        j.o(acD, "builder.buildInstance()");
        this.ehh = acD;
        com.tencent.mm.bt.a acz = this.ehh.acz();
        if (acz == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailRequest");
            AppMethodBeat.o(109219);
            throw vVar;
        }
        int parseFloat;
        ceb ceb;
        ceb ceb2 = (ceb) acz;
        ceb2.jBB = this.userName;
        ceb2.wZU = this.qIX;
        try {
            String dpA = bo.dpA();
            j.o(dpA, "Util.getTimeZoneOffset()");
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
        ab.i(TAG, "req.mUserName:" + ceb2.jBB + " req.MaxId:" + ceb2.wZU + " req.TimeZone:" + ceb2.lvg + " req.Date:" + ceb2.xdK);
        AppMethodBeat.o(109219);
    }

    static {
        AppMethodBeat.i(109220);
        AppMethodBeat.o(109220);
    }

    public final int getType() {
        return i.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(109217);
        j.p(fVar, "callback");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(109217);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(109218);
        ab.d(TAG, "netId=" + i + " errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
        com.tencent.mm.bt.a acA = this.ehh.acA();
        if (acA == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailResponse");
            AppMethodBeat.o(109218);
            throw vVar;
        }
        cec cec = (cec) acA;
        this.qKi = cec.xdM;
        ab.i(TAG, "objCount: " + cec.xds + ", expiredTime: " + cec.vAR);
        f fVar;
        if (cec.xdL.isEmpty()) {
            ab.d(TAG, "error: server give size zero");
            fVar = this.ehi;
            if (fVar == null) {
                j.avw("callback");
            }
            fVar.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(109218);
            return;
        }
        com.tencent.mm.plugin.story.model.n.a aVar = n.rTi;
        com.tencent.mm.plugin.story.model.n.a.b(this.userName, cec.xdL, this.cvp);
        if (this.qIX == 0) {
            LinkedList linkedList = cec.xdL;
            j.o(linkedList, "resp.StoryList");
            this.qIX = ((cer) linkedList.getFirst()).vQE;
        }
        ab.i(TAG, "insertList mUserName %s maxId %s minId %s", this.userName, Long.valueOf(this.qIX), Long.valueOf(this.qIY));
        fVar = this.ehi;
        if (fVar == null) {
            j.avw("callback");
        }
        fVar.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(109218);
    }
}
