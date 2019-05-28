package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class m extends com.tencent.mm.ai.m implements k {
    public int cAd;
    public final b ehh;
    private f ehi;
    public String gwh;
    public List<String> vbm;
    public String vbn;
    private List<String> vbo;

    private m(String str, String str2, int i) {
        AppMethodBeat.i(79217);
        this.vbm = null;
        this.cAd = 0;
        this.vbo = null;
        Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
        this.vbm = new LinkedList();
        this.vbm.add(str);
        this.cAd = 3;
        a aVar = new a();
        aVar.fsJ = new cnh();
        aVar.fsK = new cni();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyuser";
        aVar.fsI = 137;
        aVar.fsL = 44;
        aVar.fsM = 1000000044;
        this.ehh = aVar.acD();
        cnh cnh = (cnh) this.ehh.fsG.fsP;
        cnh.vIJ = 3;
        cnh.wsM = "";
        LinkedList linkedList = new LinkedList();
        cnf cnf = new cnf();
        cnf.pXM = str;
        cnf.xkE = str2;
        cnf.wlF = com.tencent.mm.plugin.c.a.ask().Yn().aoh(str);
        cnf.wVn = null;
        linkedList.add(cnf);
        cnh.xkN = linkedList;
        cnh.xkM = linkedList.size();
        linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(i));
        cnh.xkP = linkedList;
        cnh.xkO = linkedList.size();
        cnh.vIl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.oTO.bVS());
        ab.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify scene:%d user:%d ticket:%s anti:%s", Integer.valueOf(cnh.xkN.size()), Integer.valueOf(cnh.xkP.size()), str2, cnf.wlF);
        AppMethodBeat.o(79217);
    }

    public m(int i, List<String> list, List<Integer> list2, List<String> list3, String str, String str2, Map<String, Integer> map, String str3, String str4) {
        List list32;
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(79218);
        this.vbm = null;
        this.cAd = 0;
        this.vbo = null;
        Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", i != 3);
        this.cAd = i;
        this.vbm = list;
        if (list32 == null || list32.size() == 0) {
            list32 = new LinkedList();
        }
        a aVar = new a();
        aVar.fsJ = new cnh();
        aVar.fsK = new cni();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyuser";
        aVar.fsI = 137;
        aVar.fsL = 44;
        aVar.fsM = 1000000044;
        this.ehh = aVar.acD();
        if (list32 != null && list32.size() > 0) {
            if (list32.size() == list.size()) {
                i2 = 0;
                while (true) {
                    i3 = i2;
                    if (i3 >= list32.size()) {
                        break;
                    }
                    com.tencent.mm.plugin.c.a.ask().Yn().x((String) list.get(i3), 2147483633, (String) list32.get(i3));
                    i2 = i3 + 1;
                }
            } else {
                ab.e("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify Error lstAntispamTicket:%d lstVerifyUser:%d", Integer.valueOf(list32.size()), Integer.valueOf(list.size()));
            }
        }
        if (i == 2) {
            i2 = 0;
            while (true) {
                i4 = i2;
                if (i4 >= list.size()) {
                    break;
                }
                list32.add(bo.bc(com.tencent.mm.plugin.c.a.ask().Yn().aoh((String) list.get(i4)), ""));
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
                g Yn = com.tencent.mm.plugin.c.a.ask().Yn();
                String str6 = cnf.pXM;
                ((Integer) list2.get(i3)).intValue();
                cnf.wlF = bo.bc(Yn.aoh(str6), "");
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
                ab.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s", Integer.valueOf(this.cAd), Integer.valueOf(i3), cnf.pXM, cnf.wlF, str3, str4);
                linkedList.add(cnf);
                i4 = i3 + 1;
            } else {
                cnh.xkN = linkedList;
                cnh.xkM = linkedList.size();
                LinkedList linkedList2 = new LinkedList();
                linkedList2.addAll(list2);
                cnh.xkP = linkedList2;
                cnh.xkO = linkedList2.size();
                cnh.vIl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.oTO.bVS());
                ab.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", Integer.valueOf(this.cAd), Integer.valueOf(cnh.xkN.size()), Integer.valueOf(cnh.xkP.size()), bo.c(list32, ","), str3, bo.dpG());
                AppMethodBeat.o(79218);
                return;
            }
        }
    }

    public m(List<String> list, List<Integer> list2, String str, String str2, Map<String, Integer> map, String str3) {
        this(2, list, list2, null, str, str2, map, str3, "");
    }

    public m(String str, String str2, int i, byte b) {
        this(str, str2, i);
    }

    public m(int i, List<String> list, List<Integer> list2, String str, String str2) {
        this(i, list, list2, null, str, str2, null, null, "");
    }

    public final void hB(String str, String str2) {
        AppMethodBeat.i(79219);
        Iterator it = ((cnh) this.ehh.fsG.fsP).xkN.iterator();
        while (it.hasNext()) {
            cnf cnf = (cnf) it.next();
            cnf.xkG = str;
            cnf.xkH = str2;
        }
        AppMethodBeat.o(79219);
    }

    public final void tq(String str) {
        AppMethodBeat.i(79220);
        Iterator it = ((cnh) this.ehh.fsG.fsP).xkN.iterator();
        while (it.hasNext()) {
            ((cnf) it.next()).wlx = str;
        }
        AppMethodBeat.o(79220);
    }

    public final void lV(int i) {
        AppMethodBeat.i(79221);
        Iterator it = ((cnh) this.ehh.fsG.fsP).xkN.iterator();
        while (it.hasNext()) {
            ((cnf) it.next()).vGB = i;
        }
        AppMethodBeat.o(79221);
    }

    public final String dhl() {
        if (this.ehh == null || this.ehh.fsH == null) {
            return "";
        }
        return ((cni) this.ehh.fsH.fsP).jBB;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(79222);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(79222);
        return a;
    }

    public final int dhm() {
        return this.cAd;
    }

    public final int getType() {
        return 30;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(79223);
        if (!(i2 == 0 && i3 == 0)) {
            ab.e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(79223);
    }
}
