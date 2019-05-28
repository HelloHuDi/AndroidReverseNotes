package com.tencent.p177mm.plugin.radar.p488b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.radar.p489ui.C39561g;
import com.tencent.p177mm.protocal.protobuf.bpb;
import com.tencent.p177mm.protocal.protobuf.bpc;
import com.tencent.p177mm.protocal.protobuf.bpd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J>\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u000b2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opCode", "", "latitude", "", "longitude", "precision", "gpsSource", "macAddr", "", "cellId", "(IFFIILjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpCode", "()I", "radarSearchMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMembers", "()Ljava/util/LinkedList;", "radarSearchMembersCount", "getRadarSearchMembersCount", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.b.b */
public final class C39546b extends C1207m implements C1918k {
    private static final String TAG = TAG;
    public static final C12928a pAL = new C12928a();
    private final float cEB;
    private final float cGm;
    private final int cGn;
    private final int cGo;
    private final String cGp;
    private final String cGq;
    final int czE;
    C7472b ehh;
    private C1202f ehi;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.b$a */
    public static final class C12928a {
        private C12928a() {
        }

        public /* synthetic */ C12928a(byte b) {
            this();
        }
    }

    public /* synthetic */ C39546b() {
        this(2, 0.0f, 0.0f, 0, 0, "", "");
        AppMethodBeat.m2504i(102867);
        AppMethodBeat.m2505o(102867);
    }

    public C39546b(int i, float f, float f2, int i2, int i3, String str, String str2) {
        C25052j.m39376p(str, "macAddr");
        C25052j.m39376p(str2, "cellId");
        AppMethodBeat.m2504i(102866);
        this.czE = i;
        this.cEB = f;
        this.cGm = f2;
        this.cGn = i2;
        this.cGo = i3;
        this.cGp = str;
        this.cGq = str2;
        if (this.czE == 0) {
            C4990ab.m7412e(TAG, "opcode is wrong!");
        }
        AppMethodBeat.m2505o(102866);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(102864);
        C4990ab.m7410d(TAG, "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (this.czE == 1 && i2 == 0) {
            ArrayList arrayList = new ArrayList();
            C7472b c7472b = this.ehh;
            C1331a acA = c7472b != null ? c7472b.acA() : null;
            if (!(acA instanceof bpd)) {
                acA = null;
            }
            bpd bpd = (bpd) acA;
            if (bpd != null) {
                LinkedList<bpb> linkedList = bpd.vEh;
                if (linkedList != null) {
                    for (bpb bpb : linkedList) {
                        C17880h c17880h = new C17880h();
                        C39561g c39561g = C39561g.pDK;
                        C25052j.m39375o(bpb, "member");
                        c17880h.setUsername(C39561g.m67618b(bpb));
                        c17880h.mo33388qn(bpb.SmallImgUrl);
                        c17880h.mo33385cB(true);
                        arrayList.add(c17880h);
                    }
                }
            }
            C17884o.act().mo33390aa(arrayList);
        }
        C1202f c1202f = this.ehi;
        if (c1202f != null) {
            c1202f.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(102864);
            return;
        }
        AppMethodBeat.m2505o(102864);
    }

    public final int getType() {
        return 425;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(102865);
        C25052j.m39376p(c1902e, "dispatcher");
        C25052j.m39376p(c1202f, "callback");
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(new bpc());
        c1196a.mo4446b(new bpd());
        c1196a.mo4450qq("/cgi-bin/micromsg-bin/mmradarsearch");
        c1196a.mo4447kU(425);
        c1196a.mo4448kV(209);
        c1196a.mo4449kW(1000000209);
        this.ehh = c1196a.acD();
        C7472b c7472b = this.ehh;
        if (c7472b == null) {
            C25052j.dWJ();
        }
        C1331a acz = c7472b.acz();
        if (acz == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
            AppMethodBeat.m2505o(102865);
            throw c44941v;
        }
        bpc bpc = (bpc) acz;
        bpc.OpCode = this.czE;
        bpc.wfI = this.cGq;
        bpc.wfJ = this.cGo;
        bpc.vRq = this.cEB;
        bpc.vRp = this.cGm;
        bpc.wfH = this.cGp;
        bpc.wfG = this.cGn;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(102865);
        return a;
    }

    static {
        AppMethodBeat.m2504i(102868);
        AppMethodBeat.m2505o(102868);
    }
}
