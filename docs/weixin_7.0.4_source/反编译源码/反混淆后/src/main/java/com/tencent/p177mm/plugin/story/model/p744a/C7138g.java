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
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cem;
import com.tencent.p177mm.protocal.protobuf.cen;
import com.tencent.p177mm.protocal.protobuf.ceo;
import com.tencent.p177mm.protocal.protobuf.cep;
import com.tencent.p177mm.protocal.protobuf.ces;
import com.tencent.p177mm.protocal.protobuf.cet;
import com.tencent.p177mm.protocal.protobuf.ceu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0019\u001a\u00020\u0007H\u0016J>\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opList", "", "Lcom/tencent/mm/plugin/story/model/cgi/BaseStoryOpItem;", "localId", "", "(Ljava/util/List;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getLocalId", "()I", "getOpList", "()Ljava/util/List;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getOp", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.a.g */
public final class C7138g extends C1207m implements C1918k {
    private static final String TAG = TAG;
    public static final C7139a rUT = new C7139a();
    public final int cNE;
    private final C7472b ehh;
    public C1202f ehi;
    private final List<C39885a> rUS;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.a.g$a */
    public static final class C7139a {
        private C7139a() {
        }

        public /* synthetic */ C7139a(byte b) {
            this();
        }
    }

    public C7138g(List<? extends C39885a> list, int i) {
        C25052j.m39376p(list, "opList");
        AppMethodBeat.m2504i(109233);
        this.rUS = list;
        this.cNE = i;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(new cet());
        c1196a.mo4446b(new ceu());
        c1196a.mo4450qq("/cgi-bin/micromsg-bin/mmstoryobjectop");
        c1196a.mo4447kU(764);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        C7472b acD = c1196a.acD();
        C25052j.m39375o(acD, "builder.buildInstance()");
        this.ehh = acD;
        C1331a acz = this.ehh.acz();
        if (acz == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpRequest");
            AppMethodBeat.m2505o(109233);
            throw c44941v;
        }
        cet cet = (cet) acz;
        cet.xaL = this.rUS.size();
        for (C39885a c39885a : this.rUS) {
            ces ces = new ces();
            ces.xdq = c39885a.rUJ;
            ces.nbk = c39885a.type;
            C4990ab.m7416i(TAG, "op.id:" + c39885a.rUJ + " op.type:" + c39885a.type);
            if (c39885a instanceof C35198m) {
                ceo ceo = new ceo();
                ceo.xdq = c39885a.rUJ;
                ces.xet = new SKBuiltinBuffer_t().setBuffer(ceo.toByteArray());
            } else if (c39885a instanceof C35196k) {
                cem cem = new cem();
                cem.wZG = ((C35196k) c39885a).rVd;
                ces.xet = new SKBuiltinBuffer_t().setBuffer(cem.toByteArray());
            } else if (c39885a instanceof C29300n) {
                cep cep = new cep();
                cep.xel = ((C29300n) c39885a).rVf;
                cep.xdq = c39885a.rUJ;
                ces.xet = new SKBuiltinBuffer_t().setBuffer(cep.toByteArray());
            } else if (c39885a instanceof C35197l) {
                cen cen = new cen();
                cen.xek = ((C35197l) c39885a).rVe;
                cen.xdq = c39885a.rUJ;
                ces.xet = new SKBuiltinBuffer_t().setBuffer(cen.toByteArray());
            }
            cet.xaM.add(ces);
        }
        AppMethodBeat.m2505o(109233);
    }

    static {
        AppMethodBeat.m2504i(109234);
        AppMethodBeat.m2505o(109234);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(109230);
        C25052j.m39376p(c1902e, "dispatcher");
        C25052j.m39376p(c1202f, "callback");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(109230);
        return a;
    }

    public final int getType() {
        return 764;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(109231);
        C4990ab.m7416i(TAG, "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        C1331a acA = this.ehh.acA();
        if (acA == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpResponse");
            AppMethodBeat.m2505o(109231);
            throw c44941v;
        }
        C4990ab.m7416i(TAG, "respCount=".concat(String.valueOf(((ceu) acA).xeu)));
        C1202f c1202f = this.ehi;
        if (c1202f == null) {
            C25052j.avw("callback");
        }
        c1202f.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(109231);
    }

    public final C39885a cyX() {
        AppMethodBeat.m2504i(109232);
        if (this.rUS != null) {
            int i;
            if (this.rUS.isEmpty()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                C39885a c39885a = (C39885a) this.rUS.get(0);
                AppMethodBeat.m2505o(109232);
                return c39885a;
            }
        }
        AppMethodBeat.m2505o(109232);
        return null;
    }
}
