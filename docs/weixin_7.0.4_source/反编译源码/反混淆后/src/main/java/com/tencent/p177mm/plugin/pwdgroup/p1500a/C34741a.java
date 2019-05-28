package com.tencent.p177mm.plugin.pwdgroup.p1500a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aal;
import com.tencent.p177mm.protocal.protobuf.aam;
import com.tencent.p177mm.protocal.protobuf.aan;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.pwdgroup.a.a */
public final class C34741a extends C1207m implements C1918k {
    public int czW;
    private C7472b ehh;
    private C1202f ehi;

    public C34741a(int i, String str, String str2, float f, float f2, int i2, int i3, String str3, String str4) {
        AppMethodBeat.m2504i(23980);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aal();
        c1196a.fsK = new aam();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
        this.ehh = c1196a.acD();
        aal aal = (aal) this.ehh.fsG.fsP;
        this.czW = i;
        aal.OpCode = i;
        aal.wfF = str;
        aal.wdB = str2;
        aal.vRp = f2;
        aal.vRq = f;
        aal.wfG = i2;
        if (!C5046bo.isNullOrNil(str3)) {
            aal.wfH = str3;
        }
        if (!C5046bo.isNullOrNil(str4)) {
            aal.wfI = str4;
        }
        aal.wfJ = i3;
        C4990ab.m7411d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", Integer.valueOf(i), str2, Float.valueOf(f2), Float.valueOf(f), Integer.valueOf(i2), str3, str4, Integer.valueOf(i3));
        C18698o.m29222a(TXLiveConstants.PLAY_EVT_PLAY_LOADING, f2, f, i2);
        AppMethodBeat.m2505o(23980);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(23981);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(23981);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(23982);
        C4990ab.m7411d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.czW == 0) {
            aam cbS = cbS();
            if (cbS != null) {
                LinkedList linkedList = cbS.vEh;
                if (linkedList != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int size = linkedList.size();
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < size; i4++) {
                        aan aan = (aan) linkedList.get(i4);
                        C17880h c17880h = new C17880h();
                        if (C5046bo.isNullOrNil(aan.jBB)) {
                            c17880h.username = aan.wfK;
                        } else {
                            c17880h.username = aan.jBB;
                        }
                        C4990ab.m7411d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", aan.jBB, aan.SmallImgUrl);
                        c17880h.frV = aan.SmallImgUrl;
                        c17880h.mo33385cB(true);
                        arrayList.add(c17880h);
                    }
                    C17884o.act().mo33390aa(arrayList);
                    C4990ab.m7411d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(23982);
    }

    public final int getType() {
        return 653;
    }

    public final aam cbS() {
        return (aam) this.ehh.fsH.fsP;
    }
}
