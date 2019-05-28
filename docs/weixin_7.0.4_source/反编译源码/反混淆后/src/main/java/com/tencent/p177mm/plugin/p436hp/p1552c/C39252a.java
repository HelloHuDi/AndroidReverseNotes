package com.tencent.p177mm.plugin.p436hp.p1552c;

import android.os.Build.VERSION;
import com.facebook.internal.ServerProtocol;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.boots.p348a.C20015c;
import com.tencent.p177mm.plugin.boots.p348a.C2678a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.bhv;
import com.tencent.p177mm.protocal.protobuf.bhw;
import com.tencent.p177mm.protocal.protobuf.bhx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.hp.c.a */
public class C39252a extends C1207m implements C1918k {
    protected final C7472b ehh;
    protected C1202f ehi;
    protected int gOW = 0;
    protected LinkedList<bhw> kdX = new LinkedList();
    protected String ntS;
    protected String ntT;
    protected LinkedList<bhv> ntU = new LinkedList();
    protected int ntV = 0;
    protected String type;

    public C39252a() {
        AppMethodBeat.m2504i(90616);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bhw();
        c1196a.fsK = new bhx();
        c1196a.uri = "/cgi-bin/micromsg-bin/prconfig";
        c1196a.fsI = 3899;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(90616);
    }

    public final int getType() {
        return 3899;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(90617);
        this.ehi = c1202f;
        bhw bhw = (bhw) this.ehh.fsG.fsP;
        bhw.wLb = this.ntS;
        bhw.pdA = this.ntT;
        bhw.wLc = this.ntU;
        bhw.type = this.type;
        bhw.tOS = this.kdX;
        bhw.wLd = this.ntV;
        bhw.wLe = this.gOW;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(90617);
        return a;
    }

    /* renamed from: a */
    public void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(90618);
        C4990ab.m7417i("MicroMsg.Tinker.NetSceneBaseCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(90618);
    }

    public static LinkedList<bhv> bGn() {
        AppMethodBeat.m2504i(90619);
        LinkedList linkedList = new LinkedList();
        long j = 0;
        try {
            j = ((long) C1668a.m3396Ra()) & 4294967295L;
            C4990ab.m7417i("MicroMsg.Tinker.NetSceneBaseCheckTinkerUpdate", "uin is %s", C5046bo.anv(String.valueOf(j)));
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseCheckTinkerUpdate", e, "tinker patch manager get uin failed.", new Object[0]);
        }
        linkedList.add(C39252a.m66897eH("code-version", C5058f.CLIENT_VERSION));
        linkedList.add(C39252a.m66897eH("code-reversion", C5058f.REV));
        linkedList.add(C39252a.m66897eH(ServerProtocol.DIALOG_PARAM_SDK_VERSION, String.valueOf(VERSION.SDK_INT)));
        linkedList.add(C39252a.m66897eH("os-name", C7243d.vxl));
        linkedList.add(C39252a.m66897eH("device-brand", C7243d.vxi));
        linkedList.add(C39252a.m66897eH("device-name", C7243d.DEVICE_NAME));
        linkedList.add(C39252a.m66897eH(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j)));
        linkedList.add(C39252a.m66897eH(TencentLocation.NETWORK_PROVIDER, String.valueOf(C5023at.isWifi(C4996ah.getContext()) ? 3 : 2)));
        List<C2678a> aVJ = ((C20015c) C1720g.m3528K(C20015c.class)).aVJ();
        if (aVJ != null) {
            for (C2678a c2678a : aVJ) {
                linkedList.add(C39252a.m66897eH(Integer.toHexString(c2678a.field_key), String.valueOf(c2678a.field_dau)));
            }
        }
        AppMethodBeat.m2505o(90619);
        return linkedList;
    }

    /* renamed from: eH */
    private static bhv m66897eH(String str, String str2) {
        AppMethodBeat.m2504i(90620);
        bhv bhv = new bhv();
        bhv.key = str;
        bhv.value = str2;
        AppMethodBeat.m2505o(90620);
        return bhv;
    }
}
