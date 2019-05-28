package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.sns.storage.C13479t;
import com.tencent.p177mm.plugin.sns.storage.C29097l;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cbz;
import com.tencent.p177mm.protocal.protobuf.cca;
import com.tencent.p177mm.protocal.protobuf.ccb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.model.v */
public final class C7108v extends C1207m implements C1918k {
    private String cvZ;
    private int czE;
    private C7472b ehh;
    public C1202f ehi;
    public LinkedList<cbz> qJN = null;
    public int qJO;

    public C7108v(int i) {
        String str;
        AppMethodBeat.m2504i(36323);
        this.czE = i;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cca();
        c1196a.fsK = new ccb();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
        c1196a.fsI = 292;
        c1196a.fsL = 116;
        c1196a.fsM = 1000000116;
        this.ehh = c1196a.acD();
        String str2 = C13373af.cnJ().mo69179YX("@__weixintsnstag").field_md5;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        this.cvZ = str;
        cca cca = (cca) this.ehh.fsG.fsP;
        cca.OpCode = i;
        cca.xbu = str;
        AppMethodBeat.m2505o(36323);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36324);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36324);
        return a;
    }

    public final int getType() {
        return 292;
    }

    /* renamed from: a */
    public static C13479t m11908a(C13479t c13479t, cbz cbz) {
        AppMethodBeat.m2504i(36325);
        c13479t.field_tagId = cbz.xbt;
        c13479t.field_tagName = C5046bo.m7532bc(cbz.ncF, "");
        c13479t.field_count = cbz.jBv;
        c13479t.mo25636do(cbz.jBw);
        C4990ab.m7410d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + cbz.toString());
        AppMethodBeat.m2505o(36325);
        return c13479t;
    }

    /* renamed from: a */
    private static boolean m11909a(List<Long> list, Long l) {
        AppMethodBeat.m2504i(36326);
        for (Long longValue : list) {
            if (longValue.longValue() == l.longValue()) {
                AppMethodBeat.m2505o(36326);
                return true;
            }
        }
        AppMethodBeat.m2505o(36326);
        return false;
    }

    /* renamed from: kk */
    public final List<String> mo15446kk(long j) {
        AppMethodBeat.m2504i(36327);
        LinkedList linkedList = new LinkedList();
        if (this.qJN == null) {
            AppMethodBeat.m2505o(36327);
            return linkedList;
        }
        Iterator it = this.qJN.iterator();
        while (it.hasNext()) {
            cbz cbz = (cbz) it.next();
            if (cbz.xbt == j) {
                it = cbz.jBw.iterator();
                while (it.hasNext()) {
                    linkedList.add(((bts) it.next()).wVI);
                }
                AppMethodBeat.m2505o(36327);
                return linkedList;
            }
        }
        AppMethodBeat.m2505o(36327);
        return linkedList;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36328);
        C4990ab.m7410d("MicroMsg.NetSceneSnsTagList", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            ccb ccb = (ccb) ((C7472b) c1929q).fsH.fsP;
            C4990ab.m7411d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", Integer.valueOf(this.qJO));
            this.qJO = ccb.qJO;
            this.qJN = ccb.jBw;
            String str2 = ccb.xbu;
            if (this.cvZ.equals(str2)) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(36328);
                return;
            }
            List cru = C13373af.cnL().cru();
            if (this.czE != 3) {
                Iterator it = cru.iterator();
                while (it.hasNext()) {
                    Object obj;
                    Long l = (Long) it.next();
                    Iterator it2 = ccb.jBw.iterator();
                    while (it2.hasNext()) {
                        if (l.longValue() == ((cbz) it2.next()).xbt) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        it.remove();
                        C13373af.cnL().mo55580kG(l.longValue());
                    }
                }
            }
            Iterator it3 = ccb.jBw.iterator();
            while (it3.hasNext()) {
                cbz cbz = (cbz) it3.next();
                C13479t kF;
                if (C7108v.m11909a(cru, Long.valueOf(cbz.xbt))) {
                    kF = C13373af.cnL().mo55579kF(cbz.xbt);
                    if ((kF.field_tagName != null && !kF.field_tagName.equals(cbz.ncF)) || kF.field_count != cbz.jBv || C7108v.m11910b(kF, cbz)) {
                        C7108v.m11908a(kF, cbz);
                        C13373af.cnL().mo55576a(kF);
                    }
                } else {
                    kF = new C13479t();
                    C7108v.m11908a(kF, cbz);
                    C13373af.cnL().mo55576a(kF);
                }
            }
            C29097l YX = C13373af.cnJ().mo69179YX("@__weixintsnstag");
            YX.field_md5 = str2;
            C13373af.cnJ().mo69180a(YX);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(36328);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(36328);
    }

    /* renamed from: b */
    private static boolean m11910b(C13479t c13479t, cbz cbz) {
        boolean z = false;
        AppMethodBeat.m2504i(36329);
        String[] split = c13479t.field_memberList.split(",");
        Iterator it = cbz.jBw.iterator();
        while (it.hasNext()) {
            boolean z2;
            bts bts = (bts) it.next();
            for (String equals : split) {
                if (equals.equals(bts)) {
                    z2 = true;
                    continue;
                    break;
                }
            }
            z2 = false;
            continue;
            if (!z2) {
                z = true;
                break;
            }
        }
        AppMethodBeat.m2505o(36329);
        return z;
    }
}
