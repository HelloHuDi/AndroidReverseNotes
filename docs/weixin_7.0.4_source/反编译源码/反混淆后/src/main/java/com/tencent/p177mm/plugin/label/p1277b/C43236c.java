package com.tencent.p177mm.plugin.label.p1277b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.plugin.label.C21160e;
import com.tencent.p177mm.protocal.protobuf.ahr;
import com.tencent.p177mm.protocal.protobuf.ahs;
import com.tencent.p177mm.protocal.protobuf.axj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C46619af;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.label.b.c */
public final class C43236c extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C43236c() {
        AppMethodBeat.m2504i(22527);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ahr();
        c1196a.fsK = new ahs();
        c1196a.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(22527);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        int i4 = 0;
        AppMethodBeat.m2504i(22528);
        C4990ab.m7411d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(209408, Long.valueOf(System.currentTimeMillis()));
            ahs ahs = (ahs) this.ehh.fsH.fsP;
            if (!(ahs == null || ahs.vEm == null)) {
                LinkedList linkedList = ahs.vEm;
                ArrayList arrayList = new ArrayList();
                int size = linkedList.size();
                while (i4 < size) {
                    axj axj = (axj) linkedList.get(i4);
                    C46619af c46619af = new C46619af();
                    c46619af.field_labelID = axj.wBr;
                    c46619af.field_labelName = axj.wBq;
                    c46619af.field_labelPYFull = C9790g.m17432vo(axj.wBq);
                    c46619af.field_labelPYShort = C9790g.m17433vp(axj.wBq);
                    arrayList.add(c46619af);
                    i4++;
                }
                C21160e.bIZ().mo64080er(arrayList);
                C21160e.bIZ().mo64081es(C21160e.bIZ().mo64082et(arrayList));
            }
        } else {
            C4990ab.m7420w("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] getcontactlabellist fail.");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(22528);
    }

    public final int getType() {
        return 639;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(22529);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(22529);
        return a;
    }
}
