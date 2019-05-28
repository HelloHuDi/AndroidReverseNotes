package com.tencent.p177mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.p930c.C20118a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cnf;
import com.tencent.p177mm.protocal.protobuf.cnh;
import com.tencent.p177mm.protocal.protobuf.cni;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C36003g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.pluginsdk.model.m */
public class C46498m extends C1207m implements C1918k {
    public int cAd;
    public final C7472b ehh;
    private C1202f ehi;
    public String gwh;
    public List<String> vbm;
    public String vbn;
    private List<String> vbo;

    private C46498m(String str, String str2, int i) {
        AppMethodBeat.m2504i(79217);
        this.vbm = null;
        this.cAd = 0;
        this.vbo = null;
        Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
        this.vbm = new LinkedList();
        this.vbm.add(str);
        this.cAd = 3;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cnh();
        c1196a.fsK = new cni();
        c1196a.uri = "/cgi-bin/micromsg-bin/verifyuser";
        c1196a.fsI = 137;
        c1196a.fsL = 44;
        c1196a.fsM = 1000000044;
        this.ehh = c1196a.acD();
        cnh cnh = (cnh) this.ehh.fsG.fsP;
        cnh.vIJ = 3;
        cnh.wsM = "";
        LinkedList linkedList = new LinkedList();
        cnf cnf = new cnf();
        cnf.pXM = str;
        cnf.xkE = str2;
        cnf.wlF = C20118a.ask().mo35364Yn().aoh(str);
        cnf.wVn = null;
        linkedList.add(cnf);
        cnh.xkN = linkedList;
        cnh.xkM = linkedList.size();
        linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(i));
        cnh.xkP = linkedList;
        cnh.xkO = linkedList.size();
        cnh.vIl = new SKBuiltinBuffer_t().setBuffer(C6998b.oTO.bVS());
        C4990ab.m7417i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify scene:%d user:%d ticket:%s anti:%s", Integer.valueOf(cnh.xkN.size()), Integer.valueOf(cnh.xkP.size()), str2, cnf.wlF);
        AppMethodBeat.m2505o(79217);
    }

    public C46498m(int i, List<String> list, List<Integer> list2, List<String> list3, String str, String str2, Map<String, Integer> map, String str3, String str4) {
        List list32;
        int i2;
        int i3;
        int i4;
        AppMethodBeat.m2504i(79218);
        this.vbm = null;
        this.cAd = 0;
        this.vbo = null;
        Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", i != 3);
        this.cAd = i;
        this.vbm = list;
        if (list32 == null || list32.size() == 0) {
            list32 = new LinkedList();
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cnh();
        c1196a.fsK = new cni();
        c1196a.uri = "/cgi-bin/micromsg-bin/verifyuser";
        c1196a.fsI = 137;
        c1196a.fsL = 44;
        c1196a.fsM = 1000000044;
        this.ehh = c1196a.acD();
        if (list32 != null && list32.size() > 0) {
            if (list32.size() == list.size()) {
                i2 = 0;
                while (true) {
                    i3 = i2;
                    if (i3 >= list32.size()) {
                        break;
                    }
                    C20118a.ask().mo35364Yn().mo56748x((String) list.get(i3), 2147483633, (String) list32.get(i3));
                    i2 = i3 + 1;
                }
            } else {
                C4990ab.m7413e("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify Error lstAntispamTicket:%d lstVerifyUser:%d", Integer.valueOf(list32.size()), Integer.valueOf(list.size()));
            }
        }
        if (i == 2) {
            i2 = 0;
            while (true) {
                i4 = i2;
                if (i4 >= list.size()) {
                    break;
                }
                list32.add(C5046bo.m7532bc(C20118a.ask().mo35364Yn().aoh((String) list.get(i4)), ""));
                i2 = i4 + 1;
            }
        }
        cnh cnh = (cnh) this.ehh.fsG.fsP;
        cnh.vIJ = i;
        cnh.wsM = str;
        this.vbn = str;
        LinkedList linkedList = new LinkedList();
        i4 = 0;
        while (true) {
            i3 = i4;
            if (i3 < list.size()) {
                String str5;
                cnf cnf = new cnf();
                cnf.pXM = (String) list.get(i3);
                if (str2 == null) {
                    str5 = "";
                } else {
                    str5 = str2;
                }
                cnf.xkE = str5;
                C36003g Yn = C20118a.ask().mo35364Yn();
                String str6 = cnf.pXM;
                ((Integer) list2.get(i3)).intValue();
                cnf.wlF = C5046bo.m7532bc(Yn.aoh(str6), "");
                if (TextUtils.isEmpty(cnf.wlF) && list32 != null && list32.size() > i3) {
                    cnf.wlF = (String) list32.get(i3);
                }
                cnf.wVn = str3;
                if (map != null) {
                    if (map.containsKey(cnf.pXM)) {
                        cnf.xkF = ((Integer) map.get(cnf.pXM)).intValue();
                    }
                }
                cnf.xkJ = str4;
                C4990ab.m7417i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s", Integer.valueOf(this.cAd), Integer.valueOf(i3), cnf.pXM, cnf.wlF, str3, str4);
                linkedList.add(cnf);
                i4 = i3 + 1;
            } else {
                cnh.xkN = linkedList;
                cnh.xkM = linkedList.size();
                LinkedList linkedList2 = new LinkedList();
                linkedList2.addAll(list2);
                cnh.xkP = linkedList2;
                cnh.xkO = linkedList2.size();
                cnh.vIl = new SKBuiltinBuffer_t().setBuffer(C6998b.oTO.bVS());
                C4990ab.m7417i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", Integer.valueOf(this.cAd), Integer.valueOf(cnh.xkN.size()), Integer.valueOf(cnh.xkP.size()), C5046bo.m7536c(list32, ","), str3, C5046bo.dpG());
                AppMethodBeat.m2505o(79218);
                return;
            }
        }
    }

    public C46498m(List<String> list, List<Integer> list2, String str, String str2, Map<String, Integer> map, String str3) {
        this(2, list, list2, null, str, str2, map, str3, "");
    }

    public C46498m(String str, String str2, int i, byte b) {
        this(str, str2, i);
    }

    public C46498m(int i, List<String> list, List<Integer> list2, String str, String str2) {
        this(i, list, list2, null, str, str2, null, null, "");
    }

    /* renamed from: hB */
    public final void mo74715hB(String str, String str2) {
        AppMethodBeat.m2504i(79219);
        Iterator it = ((cnh) this.ehh.fsG.fsP).xkN.iterator();
        while (it.hasNext()) {
            cnf cnf = (cnf) it.next();
            cnf.xkG = str;
            cnf.xkH = str2;
        }
        AppMethodBeat.m2505o(79219);
    }

    /* renamed from: tq */
    public final void mo74717tq(String str) {
        AppMethodBeat.m2504i(79220);
        Iterator it = ((cnh) this.ehh.fsG.fsP).xkN.iterator();
        while (it.hasNext()) {
            ((cnf) it.next()).wlx = str;
        }
        AppMethodBeat.m2505o(79220);
    }

    /* renamed from: lV */
    public final void mo74716lV(int i) {
        AppMethodBeat.m2504i(79221);
        Iterator it = ((cnh) this.ehh.fsG.fsP).xkN.iterator();
        while (it.hasNext()) {
            ((cnf) it.next()).vGB = i;
        }
        AppMethodBeat.m2505o(79221);
    }

    public final String dhl() {
        if (this.ehh == null || this.ehh.fsH == null) {
            return "";
        }
        return ((cni) this.ehh.fsH.fsP).jBB;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(79222);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(79222);
        return a;
    }

    public final int dhm() {
        return this.cAd;
    }

    public final int getType() {
        return 30;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(79223);
        if (!(i2 == 0 && i3 == 0)) {
            C4990ab.m7413e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(79223);
    }
}
