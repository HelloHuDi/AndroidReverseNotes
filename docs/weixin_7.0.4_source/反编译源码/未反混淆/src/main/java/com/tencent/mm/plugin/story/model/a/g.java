package com.tencent.mm.plugin.story.model.a;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0019\u001a\u00020\u0007H\u0016J>\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opList", "", "Lcom/tencent/mm/plugin/story/model/cgi/BaseStoryOpItem;", "localId", "", "(Ljava/util/List;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getLocalId", "()I", "getOpList", "()Ljava/util/List;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getOp", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class g extends m implements k {
    private static final String TAG = TAG;
    public static final a rUT = new a();
    public final int cNE;
    private final b ehh;
    public f ehi;
    private final List<a> rUS;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public g(List<? extends a> list, int i) {
        j.p(list, "opList");
        AppMethodBeat.i(109233);
        this.rUS = list;
        this.cNE = i;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(new cet());
        aVar.b(new ceu());
        aVar.qq("/cgi-bin/micromsg-bin/mmstoryobjectop");
        aVar.kU(764);
        aVar.kV(0);
        aVar.kW(0);
        b acD = aVar.acD();
        j.o(acD, "builder.buildInstance()");
        this.ehh = acD;
        com.tencent.mm.bt.a acz = this.ehh.acz();
        if (acz == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpRequest");
            AppMethodBeat.o(109233);
            throw vVar;
        }
        cet cet = (cet) acz;
        cet.xaL = this.rUS.size();
        for (a aVar2 : this.rUS) {
            ces ces = new ces();
            ces.xdq = aVar2.rUJ;
            ces.nbk = aVar2.type;
            ab.i(TAG, "op.id:" + aVar2.rUJ + " op.type:" + aVar2.type);
            if (aVar2 instanceof m) {
                ceo ceo = new ceo();
                ceo.xdq = aVar2.rUJ;
                ces.xet = new SKBuiltinBuffer_t().setBuffer(ceo.toByteArray());
            } else if (aVar2 instanceof k) {
                cem cem = new cem();
                cem.wZG = ((k) aVar2).rVd;
                ces.xet = new SKBuiltinBuffer_t().setBuffer(cem.toByteArray());
            } else if (aVar2 instanceof n) {
                cep cep = new cep();
                cep.xel = ((n) aVar2).rVf;
                cep.xdq = aVar2.rUJ;
                ces.xet = new SKBuiltinBuffer_t().setBuffer(cep.toByteArray());
            } else if (aVar2 instanceof l) {
                cen cen = new cen();
                cen.xek = ((l) aVar2).rVe;
                cen.xdq = aVar2.rUJ;
                ces.xet = new SKBuiltinBuffer_t().setBuffer(cen.toByteArray());
            }
            cet.xaM.add(ces);
        }
        AppMethodBeat.o(109233);
    }

    static {
        AppMethodBeat.i(109234);
        AppMethodBeat.o(109234);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(109230);
        j.p(eVar, "dispatcher");
        j.p(fVar, "callback");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(109230);
        return a;
    }

    public final int getType() {
        return 764;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(109231);
        ab.i(TAG, "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        com.tencent.mm.bt.a acA = this.ehh.acA();
        if (acA == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpResponse");
            AppMethodBeat.o(109231);
            throw vVar;
        }
        ab.i(TAG, "respCount=".concat(String.valueOf(((ceu) acA).xeu)));
        f fVar = this.ehi;
        if (fVar == null) {
            j.avw("callback");
        }
        fVar.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(109231);
    }

    public final a cyX() {
        AppMethodBeat.i(109232);
        if (this.rUS != null) {
            int i;
            if (this.rUS.isEmpty()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                a aVar = (a) this.rUS.get(0);
                AppMethodBeat.o(109232);
                return aVar;
            }
        }
        AppMethodBeat.o(109232);
        return null;
    }
}
