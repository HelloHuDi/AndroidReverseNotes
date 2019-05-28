package com.tencent.mm.plugin.radar.b;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.radar.ui.g;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.protocal.protobuf.bpc;
import com.tencent.mm.protocal.protobuf.bpd;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J>\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u000b2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opCode", "", "latitude", "", "longitude", "precision", "gpsSource", "macAddr", "", "cellId", "(IFFIILjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpCode", "()I", "radarSearchMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMembers", "()Ljava/util/LinkedList;", "radarSearchMembersCount", "getRadarSearchMembersCount", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-radar_release"})
public final class b extends m implements k {
    private static final String TAG = TAG;
    public static final a pAL = new a();
    private final float cEB;
    private final float cGm;
    private final int cGn;
    private final int cGo;
    private final String cGp;
    private final String cGq;
    final int czE;
    com.tencent.mm.ai.b ehh;
    private f ehi;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public /* synthetic */ b() {
        this(2, 0.0f, 0.0f, 0, 0, "", "");
        AppMethodBeat.i(102867);
        AppMethodBeat.o(102867);
    }

    public b(int i, float f, float f2, int i2, int i3, String str, String str2) {
        j.p(str, "macAddr");
        j.p(str2, "cellId");
        AppMethodBeat.i(102866);
        this.czE = i;
        this.cEB = f;
        this.cGm = f2;
        this.cGn = i2;
        this.cGo = i3;
        this.cGp = str;
        this.cGq = str2;
        if (this.czE == 0) {
            ab.e(TAG, "opcode is wrong!");
        }
        AppMethodBeat.o(102866);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(102864);
        ab.d(TAG, "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (this.czE == 1 && i2 == 0) {
            ArrayList arrayList = new ArrayList();
            com.tencent.mm.ai.b bVar = this.ehh;
            com.tencent.mm.bt.a acA = bVar != null ? bVar.acA() : null;
            if (!(acA instanceof bpd)) {
                acA = null;
            }
            bpd bpd = (bpd) acA;
            if (bpd != null) {
                LinkedList<bpb> linkedList = bpd.vEh;
                if (linkedList != null) {
                    for (bpb bpb : linkedList) {
                        h hVar = new h();
                        g gVar = g.pDK;
                        j.o(bpb, "member");
                        hVar.setUsername(g.b(bpb));
                        hVar.qn(bpb.SmallImgUrl);
                        hVar.cB(true);
                        arrayList.add(hVar);
                    }
                }
            }
            o.act().aa(arrayList);
        }
        f fVar = this.ehi;
        if (fVar != null) {
            fVar.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(102864);
            return;
        }
        AppMethodBeat.o(102864);
    }

    public final int getType() {
        return 425;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(102865);
        j.p(eVar, "dispatcher");
        j.p(fVar, "callback");
        this.ehi = fVar;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(new bpc());
        aVar.b(new bpd());
        aVar.qq("/cgi-bin/micromsg-bin/mmradarsearch");
        aVar.kU(425);
        aVar.kV(209);
        aVar.kW(1000000209);
        this.ehh = aVar.acD();
        com.tencent.mm.ai.b bVar = this.ehh;
        if (bVar == null) {
            j.dWJ();
        }
        com.tencent.mm.bt.a acz = bVar.acz();
        if (acz == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
            AppMethodBeat.o(102865);
            throw vVar;
        }
        bpc bpc = (bpc) acz;
        bpc.OpCode = this.czE;
        bpc.wfI = this.cGq;
        bpc.wfJ = this.cGo;
        bpc.vRq = this.cEB;
        bpc.vRp = this.cGm;
        bpc.wfH = this.cGp;
        bpc.wfG = this.cGn;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(102865);
        return a;
    }

    static {
        AppMethodBeat.i(102868);
        AppMethodBeat.o(102868);
    }
}
