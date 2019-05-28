package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.bg;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cyf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class ae extends x {
    private int egi;
    LinkedList<f> vct;
    private LinkedList<f> vcu;
    private LinkedList<String> vcv;

    public ae(String str, LinkedList<String> linkedList) {
        AppMethodBeat.i(79384);
        ab.i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0, limit = 20, lang = " + str + "installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ab.i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", (String) it.next());
        }
        this.egi = 3;
        a aVar = new a();
        aVar.fsJ = new aos();
        aVar.fsK = new aot();
        aVar.uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
        aVar.fsI = 409;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.lty = aVar.acD();
        aos aos = (aos) this.lty.fsG.fsP;
        aos.mZF = 3;
        aos.ncn = 0;
        aos.nco = 20;
        aos.nbs = str;
        LinkedList aD = aD(linkedList);
        aos.wsQ = aD.size();
        aos.nbX = aD;
        this.vct = new LinkedList();
        this.vcu = new LinkedList();
        this.vcv = new LinkedList();
        this.vcv.addAll(linkedList);
        AppMethodBeat.o(79384);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(79385);
        ab.i("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            aot aot = (aot) this.lty.fsH.fsP;
            if (aot == null) {
                ab.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
                AppMethodBeat.o(79385);
                return;
            }
            ab.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", Integer.valueOf(aot.wsR), Integer.valueOf(this.egi));
            i bYO = com.tencent.mm.plugin.s.a.a.a.bYQ().bYO();
            b(bYO, aot.wsS);
            a(bYO, aot.ncU);
            AppMethodBeat.o(79385);
            return;
        }
        ab.e("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.o(79385);
    }

    private void a(i iVar, LinkedList<bg> linkedList) {
        AppMethodBeat.i(79386);
        if (linkedList != null && linkedList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bg bgVar = (bg) it.next();
                f bT = g.bT(bgVar.mZr, true);
                if (bT != null) {
                    a(bT, bgVar);
                    iVar.a(bT, new String[0]);
                } else {
                    bT = new f();
                    bT.field_appId = bgVar.mZr;
                    a(bT, bgVar);
                    iVar.n(bT);
                }
                this.vcu.add(bT);
            }
        }
        AppMethodBeat.o(79386);
    }

    private void b(i iVar, LinkedList<bpe> linkedList) {
        AppMethodBeat.i(79387);
        if (linkedList != null && linkedList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bpe bpe = (bpe) it.next();
                if (bo.isNullOrNil(bpe.mZr)) {
                    ab.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
                } else {
                    Object obj;
                    boolean z = true;
                    boolean z2 = false;
                    f bT = g.bT(bpe.mZr, true);
                    String str;
                    String str2;
                    Object[] objArr;
                    boolean z3;
                    if (bT != null) {
                        a(bT, bpe);
                        if (this.egi == 3) {
                            bT.field_status = 5;
                            if (bo.isNullOrNil(bT.dni) || bo.isNullOrNil(bT.dnh)) {
                                str = "MicroMsg.NetSceneGetSuggestionAppList";
                                str2 = "wrong suggestion params1, has IntroUrl %s, has IconUrl %s";
                                objArr = new Object[2];
                                if (bT.dni != null) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                objArr[0] = Boolean.valueOf(z3);
                                objArr[1] = Boolean.valueOf(bT.dnh != null);
                                ab.e(str, str2, objArr);
                                z = false;
                                z3 = false;
                                ab.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", bpe.mZr, Boolean.valueOf(z3), Boolean.valueOf(z));
                                obj = bT;
                            }
                        }
                        z3 = iVar.a(bT, new String[0]);
                        ab.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", bpe.mZr, Boolean.valueOf(z3), Boolean.valueOf(z));
                        obj = bT;
                    } else {
                        f obj2;
                        bT = new f();
                        bT.field_appId = bpe.mZr;
                        a(bT, bpe);
                        if (this.egi == 3) {
                            bT.field_status = 5;
                            if (bo.isNullOrNil(bT.dni) || bo.isNullOrNil(bT.dnh)) {
                                str = "MicroMsg.NetSceneGetSuggestionAppList";
                                str2 = "wrong suggestion params2, has IntroUrl %s, has IconUrl %s";
                                objArr = new Object[2];
                                if (bT.dni != null) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                objArr[0] = Boolean.valueOf(z3);
                                objArr[1] = Boolean.valueOf(bT.dnh != null);
                                ab.e(str, str2, objArr);
                                z = false;
                                ab.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", bpe.mZr, Boolean.valueOf(z2), Boolean.valueOf(z));
                                obj2 = bT;
                            }
                        }
                        z2 = iVar.n(bT);
                        ab.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", bpe.mZr, Boolean.valueOf(z2), Boolean.valueOf(z));
                        obj2 = bT;
                    }
                    if (!(!z || this.vcv.contains(bpe.mZr) || this.vct.contains(obj2))) {
                        this.vct.add(obj2);
                    }
                }
            }
        }
        AppMethodBeat.o(79387);
    }

    private static LinkedList<bts> aD(LinkedList<String> linkedList) {
        AppMethodBeat.i(79388);
        LinkedList<bts> linkedList2 = new LinkedList();
        if (linkedList == null) {
            AppMethodBeat.o(79388);
            return linkedList2;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!bo.isNullOrNil(str)) {
                linkedList2.add(aa.vy(str));
            }
        }
        AppMethodBeat.o(79388);
        return linkedList2;
    }

    private static void a(f fVar, bpe bpe) {
        AppMethodBeat.i(79389);
        fVar.ih(bpe.vDl);
        fVar.field_appIconUrl = bpe.vDm;
        fVar.ig(bpe.wRy);
        fVar.field_appName = bpe.ncH;
        fVar.ii(bpe.vDn);
        fVar.field_appType = bpe.vME;
        fVar.ik(bpe.nad);
        fVar.field_packageName = bpe.vDo;
        fVar.il(bpe.vDp);
        if (!bo.isNullOrNil(bpe.vDp)) {
            ab.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", bpe.vDp, Integer.valueOf(bpe.wRI));
            fVar.hq(bpe.wRI);
        }
        fVar.im(bpe.wRF);
        fVar.in(bpe.wRG);
        a(fVar, bpe.vDq);
        o(fVar);
        AppMethodBeat.o(79389);
    }

    private static void o(f fVar) {
        AppMethodBeat.i(79390);
        if (!bo.isNullOrNil(fVar.field_appType) && (fVar.field_appType.startsWith("1") || fVar.field_appType.startsWith("6"))) {
            if (!fVar.field_appType.endsWith(",")) {
                fVar.field_appType += ",";
            }
            fVar.field_appType = "," + fVar.field_appType;
        }
        AppMethodBeat.o(79390);
    }

    private static void a(f fVar, cyf cyf) {
        AppMethodBeat.i(79391);
        ab.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", fVar.field_appId);
        if (cyf != null) {
            fVar.hq(cyf.xtB);
            fVar.iq(cyf.vMJ);
            fVar.ir(cyf.ndR);
            fVar.io(cyf.xtC);
            fVar.ip(cyf.ndT);
            fVar.is(cyf.ndU);
            fVar.hr(cyf.ndV);
            ab.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", Integer.valueOf(cyf.xtB), cyf.vMJ, cyf.ndR, cyf.xtC, cyf.ndT, cyf.ndU, Integer.valueOf(cyf.ndV));
        }
        AppMethodBeat.o(79391);
    }

    private static void a(f fVar, bg bgVar) {
        AppMethodBeat.i(79392);
        fVar.ih(bgVar.vDl);
        fVar.ik(bgVar.nad);
        fVar.ii(bgVar.vDn);
        fVar.field_appName = bgVar.ncH;
        fVar.field_appIconUrl = bgVar.vDm;
        fVar.il(bgVar.vDp);
        fVar.it(bgVar.vDr);
        a(fVar, bgVar.vDq);
        AppMethodBeat.o(79392);
    }

    public final int dhJ() {
        return ((aot) this.lty.fsH.fsP).wsR;
    }

    public final byte[] dhj() {
        AppMethodBeat.i(79393);
        try {
            byte[] ZT = ((b) this.lty.acF()).ZT();
            AppMethodBeat.o(79393);
            return ZT;
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneGetSuggestionAppList", e.getMessage());
            ab.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", e, "", new Object[0]);
            AppMethodBeat.o(79393);
            return null;
        }
    }

    public final void bG(byte[] bArr) {
        AppMethodBeat.i(79394);
        if (bArr == null) {
            ab.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
            AppMethodBeat.o(79394);
            return;
        }
        try {
            this.lty.fsH.P(bArr);
            AppMethodBeat.o(79394);
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneGetSuggestionAppList", e.getMessage());
            ab.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", e, "", new Object[0]);
            AppMethodBeat.o(79394);
        }
    }

    public final int getType() {
        return 4;
    }
}
