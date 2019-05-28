package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C30225sr;
import com.tencent.p177mm.protocal.protobuf.chb;
import com.tencent.p177mm.protocal.protobuf.chc;
import com.tencent.p177mm.protocal.protobuf.chd;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C46627q;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g */
public final class C11246g extends C1207m implements C1918k {
    C7472b ehh;
    private C1202f ehi;

    public C11246g() {
        LinkedList linkedList = null;
        AppMethodBeat.m2504i(14359);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new chb();
        c1196a.fsK = new chc();
        c1196a.uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_often_read_biz";
        this.ehh = c1196a.acD();
        chb chb = (chb) this.ehh.fsG.fsP;
        chc aWL = C42822d.aWL();
        if (aWL != null) {
            LinkedList linkedList2 = aWL.xfW;
            if (!C5046bo.m7548ek(linkedList2)) {
                LinkedList linkedList3 = new LinkedList();
                Iterator it = linkedList2.iterator();
                while (it.hasNext()) {
                    chd chd = (chd) it.next();
                    if (chd != null) {
                        C30225sr c30225sr = new C30225sr();
                        c30225sr.vGE = chd.vGE;
                        C46627q mE = C41747z.aeX().mo64115mE(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoP(chd.vGE));
                        if (mE != null) {
                            c30225sr.wag = (int) (mE.field_createTime / 1000);
                        }
                        linkedList3.add(c30225sr);
                    }
                }
                linkedList = linkedList3;
            }
        }
        chb.xfV = linkedList;
        AppMethodBeat.m2505o(14359);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(14360);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(14360);
    }

    public final int getType() {
        return 2768;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(14361);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(14361);
        return a;
    }
}
