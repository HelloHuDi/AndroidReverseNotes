package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.km;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.g.c.cp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.bbw;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bv;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class c implements f, com.tencent.mm.plugin.messenger.foundation.a.c {
    private static void a(bbv bbv, String str, ad adVar, boolean z) {
        AppMethodBeat.i(18237);
        String Yz = r.Yz();
        if (!(Yz == null || Yz.equals(str))) {
            d qP = z.aeR().qP(str);
            qP.field_username = str;
            qP.field_brandList = bbv.guX;
            uy uyVar = bbv.wCa;
            if (uyVar != null) {
                qP.field_brandFlag = uyVar.gvb;
                qP.field_brandInfo = uyVar.gvd;
                qP.field_brandIconURL = uyVar.gve;
                qP.field_extInfo = uyVar.gvc;
                if (z) {
                    qP.field_attrSyncVersion = null;
                    qP.field_incrementUpdateTime = 0;
                    ab.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", str);
                }
                if (!bo.isNullOrNil(qP.field_extInfo)) {
                    qP.cJ(true);
                }
            }
            if (!(qP.cJ(false) == null || qP.cJ(false).getServiceType() != 3 || qP.cJ(false).aer() == null || bo.isNullOrNil(qP.adX()))) {
                qP.field_enterpriseFather = qP.adX();
                ab.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", str, qP.field_enterpriseFather);
            }
            if (!z.aeR().e(qP)) {
                z.aeR().d(qP);
            }
            adVar.hI(qP.field_type);
        }
        AppMethodBeat.o(18237);
    }

    public static boolean a(ad adVar, bbv bbv, boolean z) {
        AppMethodBeat.i(18238);
        if (adVar == null || bo.isNullOrNil(adVar.field_username)) {
            ab.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
            AppMethodBeat.o(18238);
            return false;
        }
        String str = adVar.field_username;
        String str2 = adVar.field_encryptUsername;
        o.act().b(b.a(str, bbv));
        ccl ccl = bbv.wBZ;
        if (!(adVar.field_username.endsWith("@chatroom") || ccl == null)) {
            ab.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + ccl.guY + " " + bbv.wcB);
            ab.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + ccl.guZ);
            ab.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ccl.gva);
            ab.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ccl.xbQ);
            ab.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ccl.xbR);
            if (n.qFy != null) {
                n.qFy.a(adVar.field_username, ccl);
            }
        }
        if (a.jh(adVar.field_type)) {
            boolean ep = com.tencent.mm.bi.d.akP().ep(str, 1);
            if (ep) {
                ab.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = ".concat(String.valueOf(str)));
            } else {
                ep = com.tencent.mm.bi.d.akP().ep(str2, 1);
                ab.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = ".concat(String.valueOf(str2)));
            }
            ab.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = ".concat(String.valueOf(ep)));
        }
        if (a.jh(adVar.field_type) && (adVar.getSource() == 10 || adVar.getSource() == 13)) {
            w.n(ah.getContext(), adVar.field_username, adVar.field_encryptUsername);
            com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(adVar.field_encryptUsername);
            if (!(vT == null || bo.isNullOrNil(vT.guM))) {
                vT.username = adVar.field_username;
                ab.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr ".concat(String.valueOf(com.tencent.mm.plugin.account.a.getAddrUploadStg().a(vT.guM, vT))));
            }
        }
        a(bbv, str, adVar, z);
        AppMethodBeat.o(18238);
        return true;
    }

    private static boolean a(ad adVar, bv bvVar) {
        AppMethodBeat.i(18239);
        boolean z = false;
        if (!bo.isNullOrNil(bvVar.field_conDescription)) {
            adVar.iX(bvVar.field_conDescription);
        }
        if (!t.mX(adVar.field_username) && a.jh(adVar.field_type)) {
            z = true;
            if (!bo.isNullOrNil(bvVar.field_conDescription)) {
                bbw bbw = new bbw();
                bbw.wGA = adVar.field_username;
                bbw.Desc = bvVar.field_conDescription;
                aw.ZK();
                com.tencent.mm.model.c.XL().c(new j.a(54, bbw));
            }
        }
        AppMethodBeat.o(18239);
        return z;
    }

    private static void D(ad adVar) {
        AppMethodBeat.i(18240);
        if (!(adVar == null || !com.tencent.mm.aj.f.rb(adVar.field_username) || com.tencent.mm.aj.f.kq(adVar.field_username))) {
            aw.ZK();
            ak aoZ = com.tencent.mm.model.c.XR().aoZ(adVar.field_username);
            d qP = z.aeR().qP(adVar.field_username);
            if (!com.tencent.mm.aj.f.re(qP.field_username)) {
                AppMethodBeat.o(18240);
                return;
            } else if (aoZ == null) {
                aoZ = new ak(qP.field_username);
                ab.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", qP.adX(), qP.field_username);
                aoZ.jj(bo.nullAsNil(qP.adX()));
                aoZ.dsI();
                aw.ZK();
                com.tencent.mm.model.c.XR().d(aoZ);
            }
        }
        AppMethodBeat.o(18240);
    }

    private static void bG(String str, int i) {
        com.tencent.mm.pluginsdk.ui.preference.b[] a;
        bt[] btVarArr;
        ax[] axVarArr;
        AppMethodBeat.i(18241);
        bf[] bfVarArr = null;
        if (i == 26 || i == 27 || i == 28 || i == 29) {
            ab.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
            bt[] apY = com.tencent.mm.bi.d.akR().apY(str);
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(ah.getContext(), apY);
            btVarArr = apY;
            axVarArr = null;
        } else if (i == 18) {
            ab.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
            cp[] bfVarArr2 = com.tencent.mm.bi.d.akQ().apz(str);
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(ah.getContext(), bfVarArr2);
            btVarArr = null;
            axVarArr = null;
        } else {
            ax[] apv = com.tencent.mm.bi.d.akO().apv(str);
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(ah.getContext(), apv);
            btVarArr = null;
            axVarArr = apv;
        }
        if (a == null) {
            AppMethodBeat.o(18241);
            return;
        }
        int i2 = 0;
        int length = a.length;
        int i3 = 0;
        while (i3 < length) {
            int i4;
            com.tencent.mm.pluginsdk.ui.preference.b bVar = a[i3];
            bi biVar = new bi();
            biVar.setContent(bVar.fjz);
            int nK = t.nK(bVar.username);
            if (axVarArr != null) {
                i4 = i2 + 1;
                biVar.eJ(axVarArr[i2].field_createTime);
            } else if (bfVarArr2 != null) {
                i4 = i2 + 1;
                biVar.eJ(bfVarArr2[i2].field_createtime * 1000);
            } else if (btVarArr != null) {
                i4 = i2 + 1;
                biVar.eJ(btVarArr[i2].field_createtime * 1000);
            } else {
                i4 = i2;
            }
            biVar.ju(bVar.username);
            biVar.setType(nK);
            if (bVar.cRY) {
                biVar.setStatus(2);
                biVar.hO(1);
            } else {
                biVar.setStatus(6);
                biVar.hO(0);
            }
            aw.ZK();
            long Z = com.tencent.mm.model.c.XO().Z(biVar);
            Assert.assertTrue(Z != -1);
            ab.i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = ".concat(String.valueOf(Z)));
            i3++;
            i2 = i4;
        }
        bi biVar2 = new bi();
        if (axVarArr != null) {
            biVar2.eJ(axVarArr[0].field_createTime + 1);
        } else if (bfVarArr2 != null) {
            biVar2.eJ((bfVarArr2[0].field_createtime * 1000) + 1);
        } else if (btVarArr != null) {
            biVar2.eJ((btVarArr[0].field_createtime * 1000) + 1);
        }
        biVar2.ju(str);
        biVar2.setContent(ah.getContext().getString(R.string.exy));
        biVar2.setType(Downloads.MIN_WAIT_FOR_NETWORK);
        biVar2.setStatus(6);
        biVar2.hO(0);
        aw.ZK();
        com.tencent.mm.model.c.XO().Z(biVar2);
        AppMethodBeat.o(18241);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(18242);
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "onsceneEnd errType:%d,errCode:%d,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar.getType() != 681) {
            AppMethodBeat.o(18242);
        } else if (i != 0 || i2 != 0) {
            AppMethodBeat.o(18242);
        } else if (g.RN().eJb) {
            List<j.b> list = ((com.tencent.mm.az.b) mVar).fLs;
            HashSet<String> hashSet = new HashSet();
            try {
                for (j.b bVar : list) {
                    if (bVar.getCmdId() == 2) {
                        hashSet.add(aa.a(((bbv) new bbv().parseFrom(bVar.getBuffer())).wcB));
                    } else if (bVar.getCmdId() == 54) {
                        hashSet.add(((bbw) new bbw().parseFrom(bVar.getBuffer())).wGA);
                    } else if (bVar.getCmdId() == 60) {
                        hashSet.add(((bck) new bck().parseFrom(bVar.getBuffer())).wGA);
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", e, "BaseProtoBuf parseFrom error!", new Object[0]);
            }
            for (String str2 : hashSet) {
                if (!bo.isNullOrNil(str2)) {
                    ao.a.flu.a(str2, null, null);
                }
            }
            AppMethodBeat.o(18242);
        } else {
            ab.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
            AppMethodBeat.o(18242);
        }
    }

    public final void a(ad adVar, ad adVar2, bbv bbv, byte[] bArr, boolean z) {
        Object obj;
        String str;
        AppMethodBeat.i(18235);
        String str2 = adVar.field_username;
        String str3 = adVar.field_encryptUsername;
        if (!(adVar2 == null || bo.nullAsNil(adVar2.dum).equals(bo.nullAsNil(bbv.wGv)))) {
            com.tencent.mm.bc.c.aiB();
            com.tencent.mm.bc.c.sY(str2);
        }
        if (bo.cb(bArr)) {
            a(adVar, bbv, true);
        } else if (ad.Mn(adVar.field_verifyFlag)) {
            a(bbv, str2, adVar, true);
        }
        if (adVar2 == null || a.jh(adVar2.field_type) || !a.jh(adVar.field_type)) {
            obj = null;
        } else {
            obj = 1;
        }
        String str4 = "MicroMsg.BigBallContactAssemblerImpl";
        String str5 = "username:%s PhoneNumList size:%s";
        Object[] objArr = new Object[2];
        objArr[0] = adVar.field_username;
        if (bbv.wGw == null) {
            str = "";
        } else {
            str = Integer.valueOf(bo.h(Integer.valueOf(bbv.wGw.wNu.size())));
        }
        objArr[1] = str;
        ab.i(str4, str5, objArr);
        StringBuffer stringBuffer = new StringBuffer();
        if (!(bbv.wGw == null || bbv.wGw.wNu == null)) {
            Iterator it = bbv.wGw.wNu.iterator();
            while (it.hasNext()) {
                bkf bkf = (bkf) it.next();
                if (bkf.wNt != null) {
                    stringBuffer.append(bkf.wNt + ",");
                }
            }
        }
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", adVar.field_username, stringBuffer.toString());
        str = null;
        Object obj2 = null;
        if (adVar2 != null) {
            str = adVar2.dur;
        }
        if (str == null || str.equals("")) {
            aw.ZK();
            bv RB = com.tencent.mm.model.c.XN().RB(str3);
            if (RB != null) {
                str = RB.field_conPhone;
            }
        }
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", adVar.field_username, bo.nullAsNil(str));
        if (!bo.isNullOrNil(str)) {
            int i;
            Object obj3 = null;
            for (String str6 : str.split(",")) {
                if (!bo.isNullOrNil(stringBuffer.toString())) {
                    String[] split = stringBuffer.toString().split(",");
                    int length = split.length;
                    int i2 = 0;
                    while (i2 < length) {
                        if (str6.equals(split[i2])) {
                            obj3 = null;
                            break;
                        } else {
                            obj3 = 1;
                            i2++;
                        }
                    }
                    if (obj3 != null) {
                        stringBuffer.append(str6);
                        obj2 = 1;
                    }
                }
            }
            if (obj2 != null) {
                bck bck = new bck();
                bck.wGA = adVar.field_username;
                bkg bkg = new bkg();
                if (!bo.isNullOrNil(stringBuffer.toString())) {
                    String[] split2 = stringBuffer.toString().split(",");
                    bkg.jBv = split2.length;
                    bkg.wNu = new LinkedList();
                    for (String str7 : split2) {
                        bkf bkf2 = new bkf();
                        bkf2.wNt = str7;
                        bkg.wNu.add(bkf2);
                    }
                    bck.wGw = bkg;
                    aw.ZK();
                    com.tencent.mm.model.c.XL().c(new j.a(60, bck));
                }
            }
            if (!(obj == null || 15 != bbv.vFH || bo.isNullOrNil(adVar.field_username))) {
                com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(adVar.field_username);
                if (vT != null) {
                    h hVar = h.pYm;
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = adVar.field_username;
                    objArr2[1] = Integer.valueOf(3);
                    objArr2[2] = Integer.valueOf(bo.isNullOrNil(vT.Aq()) ? 0 : 1);
                    if (stringBuffer.toString().split(",").length >= 5) {
                        i = 5;
                    } else {
                        i = stringBuffer.toString().split(",").length;
                    }
                    objArr2[3] = Integer.valueOf(i);
                    hVar.e(12040, objArr2);
                }
            }
        }
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", adVar.field_username, stringBuffer.toString());
        str = stringBuffer.toString();
        if (!bo.isNullOrNil(str)) {
            ab.i("MicroMsg.BigBallContactAssemblerImpl", str);
            adVar.jd(str);
        }
        if (!(t.kH(str2) || bbv.wnN == null)) {
            com.tencent.mm.model.n.a(str2, bbv.wnN);
        }
        boolean z2 = false;
        aw.ZK();
        bv RB2 = com.tencent.mm.model.c.XN().RB(adVar.field_username);
        if (bo.isNullOrNil(adVar.field_conRemark)) {
            if ((RB2 == null || bo.isNullOrNil(RB2.field_encryptUsername)) && !bo.isNullOrNil(str3)) {
                aw.ZK();
                RB2 = com.tencent.mm.model.c.XN().RB(str3);
            }
            if (!(RB2 == null || bo.isNullOrNil(RB2.field_encryptUsername))) {
                ab.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + RB2.field_encryptUsername);
                adVar.iz(RB2.field_conRemark);
                adVar.iF(com.tencent.mm.platformtools.g.vo(RB2.field_conRemark));
                adVar.iG(com.tencent.mm.platformtools.g.vp(RB2.field_conRemark));
                z2 = a(adVar, RB2);
            }
            switch (adVar.getSource()) {
                case 10:
                case 11:
                case 13:
                    com.tencent.mm.plugin.account.friend.a.a aVar = null;
                    if (bbv != null && !bo.isNullOrNil(bbv.wGo)) {
                        ab.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", bbv.wGo, bbv.wGp);
                        com.tencent.mm.plugin.account.friend.a.b addrUploadStg = com.tencent.mm.plugin.account.a.getAddrUploadStg();
                        String str8 = bbv.wGo;
                        str5 = bbv.wGp;
                        aVar = addrUploadStg.vW(str8);
                        if (aVar == null) {
                            aVar = addrUploadStg.vW(str5);
                        }
                    } else if (!bo.isNullOrNil(str3)) {
                        aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(str3);
                    }
                    if (aVar == null) {
                        ab.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
                    } else {
                        ab.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", bo.nullAsNil(aVar.apA()), bo.nullAsNil(aVar.getUsername()), Boolean.valueOf(aVar.apI()));
                    }
                    if (!(aVar == null || bo.isNullOrNil(aVar.apA()) || !aVar.apI())) {
                        ab.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", aVar.apA(), aVar.getUsername(), Boolean.valueOf(z2));
                        aVar.username = adVar.field_username;
                        aVar.status = 2;
                        aVar.apH();
                        if (!z2) {
                            adVar.iz(aVar.apA());
                            adVar.iF(com.tencent.mm.platformtools.g.vo(aVar.apA()));
                            adVar.iG(com.tencent.mm.platformtools.g.vp(aVar.apA()));
                            z2 = true;
                        }
                        if (a.jh(adVar.field_type)) {
                            ab.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", aVar.apA(), aVar.getUsername(), Boolean.valueOf(z2));
                            com.tencent.mm.plugin.account.a.getAddrUploadStg().a(aVar.Aq(), aVar);
                            break;
                        }
                    }
                    break;
            }
        }
        if (!(RB2 == null || bo.isNullOrNil(adVar.dul) || adVar.dul.equals(RB2.field_conDescription))) {
            a(adVar, RB2);
        }
        z2 = false;
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", adVar.field_username, Boolean.valueOf(z2), str3);
        if (z2) {
            t.v(adVar);
        }
        str = null;
        aw.ZK();
        RB2 = com.tencent.mm.model.c.XN().RB(adVar.field_encryptUsername);
        if (RB2 != null) {
            str = RB2.field_contactLabels;
        }
        if (bo.isNullOrNil(str)) {
            aw.ZK();
            RB2 = com.tencent.mm.model.c.XN().RB(adVar.field_username);
            if (RB2 != null) {
                str = RB2.field_contactLabels;
            }
        }
        if (!bo.isNullOrNil(str)) {
            com.tencent.mm.plugin.label.a.a.bJa().eQ(adVar.field_username, str);
            RB2.field_contactLabels = "";
            aw.ZK();
            com.tencent.mm.model.c.XN().a(RB2);
        }
        AppMethodBeat.o(18235);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0662 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0257 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x027a A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x03d8  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0418  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(ad adVar, ad adVar2, bbv bbv, byte[] bArr, boolean z) {
        Object obj;
        int i;
        Object obj2;
        d qP;
        je jeVar;
        AppMethodBeat.i(18236);
        String str = adVar.field_username;
        String str2 = adVar.field_encryptUsername;
        if (t.kH(str)) {
            String akN;
            if (bbv.wnN != null) {
                Iterator it;
                qf qfVar;
                LinkedList linkedList = bbv.wnN.vXi;
                if (com.tencent.mm.bh.d.fUv == null) {
                    obj = null;
                } else {
                    akN = com.tencent.mm.bh.d.fUv.akN();
                    if (!bo.isNullOrNil(akN) && akN.equals(str) && t.kH(str)) {
                        if (linkedList != null) {
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                                qfVar = (qf) it.next();
                                if (!bo.isNullOrNil(qfVar.jBB) && qfVar.jBB.equals(r.Yz())) {
                                    obj = null;
                                    break;
                                }
                            }
                        }
                        if (com.tencent.mm.bh.d.fUu != null) {
                            if (com.tencent.mm.bh.d.fUu.aV(str, r.Yz())) {
                                ab.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
                                tg tgVar = new tg();
                                tgVar.cPx.userName = str;
                                com.tencent.mm.sdk.b.a.xxA.m(tgVar);
                            }
                            com.tencent.mm.bh.d.fUu.a(str, null, 0.0d, 0.0d, "", "", "");
                        }
                        if (!(com.tencent.mm.bh.d.fUv == null || bo.isNullOrNil(com.tencent.mm.bh.d.fUu.akM()))) {
                            ab.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", com.tencent.mm.bh.d.fUv.akN());
                            ez ezVar = new ez();
                            ezVar.cys.username = com.tencent.mm.bh.d.fUv.akN();
                            com.tencent.mm.sdk.b.a.xxA.m(ezVar);
                        }
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                if (obj == null) {
                    linkedList = bbv.wnN.vXi;
                    sz szVar = new sz();
                    szVar.cPf.cPh = true;
                    com.tencent.mm.sdk.b.a.xxA.m(szVar);
                    if (!bo.isNullOrNil(str) && t.kH(str) && !bo.isNullOrNil(szVar.cPg.cPj) && str.equals(szVar.cPg.cPj)) {
                        if (linkedList != null) {
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                                qfVar = (qf) it.next();
                                if (!bo.isNullOrNil(qfVar.jBB)) {
                                    if (qfVar.jBB.equals(r.Yz())) {
                                        break;
                                    }
                                }
                            }
                        }
                        if (com.tencent.mm.bg.g.fUs != null) {
                            com.tencent.mm.bg.g.fUs.a(str, null, "", "", 0);
                        }
                        sz szVar2 = new sz();
                        szVar2.cPf.cPi = true;
                        com.tencent.mm.sdk.b.a.xxA.m(szVar2);
                        sy syVar = new sy();
                        syVar.cPd.cPe = true;
                        com.tencent.mm.sdk.b.a.xxA.m(syVar);
                    }
                }
                linkedList = bbv.wnN.vXi;
                if (linkedList != null) {
                    it = linkedList.iterator();
                    while (it.hasNext()) {
                        qfVar = (qf) it.next();
                        if (bo.isNullOrNil(qfVar.jBB) || !qfVar.jBB.equals(r.Yz())) {
                        }
                    }
                    obj = 1;
                    if (obj != null) {
                        ((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RU(str);
                    }
                }
                obj = null;
                if (obj != null) {
                }
            }
            akN = "MicroMsg.BigBallContactAssemblerImpl";
            String str3 = "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s ver:%d infomask:%d ";
            Object[] objArr = new Object[9];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(bbv.wnN == null ? 0 : bbv.wnN.ehB);
            objArr[2] = bbv.wGj;
            objArr[3] = bbv.wGi;
            objArr[4] = Integer.valueOf(bbv.wGt);
            objArr[5] = Integer.valueOf(bbv.wGs);
            objArr[6] = bbv.ndT;
            objArr[7] = Integer.valueOf(bbv.wGr);
            if (bbv.wnN == null) {
                i = -1;
            } else {
                i = bbv.wnN.vXj;
            }
            objArr[8] = Integer.valueOf(i);
            ab.i(akN, str3, objArr);
            if (!(bbv.wnN == null || bbv.wnN.ehB == 0)) {
                com.tencent.mm.j.a.a.a aVar = new com.tencent.mm.j.a.a.a();
                aVar.type = bbv.wGt;
                aVar.ehD = bbv.wGs;
                aVar.eox = bbv.ndT;
                aVar.eoy = bbv.wGr;
                if (bbv.wnN.vXj == 0) {
                    aVar.cGj = bbv.wGr;
                }
                if (com.tencent.mm.model.n.N(str, bbv.wGr)) {
                    com.tencent.mm.sdk.b.a.xxA.m(new hj());
                    com.tencent.mm.model.n.O(str, bbv.wGt);
                }
                km kmVar = new km();
                kmVar.cGi.chatroomName = str;
                kmVar.cGi.cGj = aVar.cGj;
                com.tencent.mm.model.n.a(str, bbv.wGi, bbv.wnN, bbv.wGy, r.Yz(), aVar, kmVar);
            }
        }
        if (!(a.jh(adVar.field_type) || adVar.NY() || ad.mR(adVar.field_username) || t.kH(adVar.field_username))) {
            ab.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", adVar.field_username, Integer.valueOf(adVar.field_type));
            aw.ZK();
            com.tencent.mm.model.c.XR().aoX(adVar.field_username);
        }
        if ((adVar.field_type & 2048) != 0) {
            if (adVar2 == null || (adVar2.field_type & 2048) != (adVar.field_type & 2048)) {
                if (com.tencent.mm.aj.f.rb(adVar.field_username) && !com.tencent.mm.aj.f.kq(adVar.field_username)) {
                    D(adVar);
                } else if (adVar.dsf() && com.tencent.mm.aj.f.qZ(adVar.field_username) && adVar != null && adVar.dsf() && com.tencent.mm.aj.f.qZ(adVar.field_username)) {
                    ab.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + adVar.field_username);
                    aw.ZK();
                    ak aoZ = com.tencent.mm.model.c.XR().aoZ(adVar.field_username);
                    z.aeR().qP(adVar.field_username);
                    if (aoZ == null) {
                        aw.ZK();
                        if (com.tencent.mm.model.c.XR().aoZ("officialaccounts") == null) {
                            aoZ = new ak("officialaccounts");
                            aoZ.dsI();
                            aw.ZK();
                            com.tencent.mm.model.c.XR().d(aoZ);
                        }
                        aoZ = new ak(adVar.field_username);
                        aoZ.jj("officialaccounts");
                        aw.ZK();
                        com.tencent.mm.model.c.XR().d(aoZ);
                    }
                }
            }
        } else if ((adVar2 == null || (adVar2.field_type & 2048) != (adVar.field_type & 2048)) && com.tencent.mm.aj.f.rb(adVar.field_username) && !com.tencent.mm.aj.f.kq(adVar.field_username)) {
            D(adVar);
        }
        if (adVar2 == null || a.jh(adVar2.field_type) || !a.jh(adVar.field_type)) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (a.jh(adVar.field_type)) {
            aw.ZK();
            bv RB = com.tencent.mm.model.c.XN().RB(str);
            if ((RB == null || bo.isNullOrNil(RB.field_encryptUsername)) && !bo.isNullOrNil(str2)) {
                aw.ZK();
                RB = com.tencent.mm.model.c.XN().RB(str2);
            }
            if (!(RB == null || bo.isNullOrNil(RB.field_encryptUsername))) {
                aw.ZK();
                com.tencent.mm.model.c.XN().RC(RB.field_encryptUsername);
            }
        }
        if (com.tencent.mm.aj.f.ra(adVar.field_username)) {
            z.afa();
            com.tencent.mm.aj.c.a(adVar.field_username, null);
            if (obj2 != null && com.tencent.mm.aj.f.rb(adVar.field_username)) {
                if (com.tencent.mm.aj.f.kq(adVar.field_username)) {
                    z.aeZ();
                    com.tencent.mm.aj.a.h.a(adVar.field_username, null);
                } else if (com.tencent.mm.aj.f.re(adVar.field_username)) {
                    aw.ZK();
                    if (com.tencent.mm.model.c.XR().aoZ(adVar.field_username) == null) {
                        qP = z.aeR().qP(adVar.field_username);
                        ak akVar = new ak(adVar.field_username);
                        if (qP.adR()) {
                            akVar.jj(null);
                        } else {
                            ab.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", qP.adX(), adVar.field_username);
                            akVar.jj(bo.nullAsNil(qP.adX()));
                        }
                        akVar.dsI();
                        aw.ZK();
                        com.tencent.mm.model.c.XR().d(akVar);
                    }
                }
            }
        }
        qP = com.tencent.mm.aj.f.qX(adVar.field_username);
        if (qP != null) {
            d.b cJ = qP.cJ(false);
            if (cJ != null) {
                i = 0;
                if (cJ.fvc != null) {
                    i = cJ.fvc.optInt("WXAppType", 0);
                }
                if (i != 0) {
                    obj = 1;
                    if (obj != null) {
                        z.afd();
                        com.tencent.mm.aj.a.qy(adVar.field_username);
                    }
                    if ((adVar.field_type & 8) == 0) {
                        if (adVar2 == null || (adVar2.field_type & 8) != (adVar.field_type & 8)) {
                            aw.ZK();
                            com.tencent.mm.model.c.XR().c(new String[]{adVar.field_username}, "@blacklist");
                        }
                    } else if (adVar2 == null || (adVar2.field_type & 8) != (adVar.field_type & 8)) {
                        aw.ZK();
                        com.tencent.mm.model.c.XR().c(new String[]{adVar.field_username}, "");
                    }
                    if (!z) {
                        if (adVar != null && adVar.dsf() && a.jh(adVar.field_type)) {
                            long currentTimeMillis = System.currentTimeMillis();
                            aw.ZK();
                            ak aoZ2 = com.tencent.mm.model.c.XR().aoZ(adVar.field_username);
                            if (aoZ2 != null && aoZ2.jl(4194304)) {
                                aw.ZK();
                                boolean a = com.tencent.mm.model.c.XR().a(adVar.field_username, 4194304, false, aoZ2.field_attrflag);
                                ab.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", adVar.field_username, Boolean.valueOf(a), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            }
                        }
                        if (adVar2 != null && ((int) adVar2.ewQ) > 0 && adVar2.duj != 0 && adVar2.duk == 0 && adVar.duk == 1) {
                            ab.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", adVar.field_username);
                            aw.ZK();
                            com.tencent.mm.model.c.XR().app(adVar.field_username);
                            aw.ZK();
                            ak aoZ3 = com.tencent.mm.model.c.XR().aoZ("officialaccounts");
                            if (aoZ3 != null) {
                                aw.ZK();
                                aoZ3.hM(com.tencent.mm.model.c.XR().dsQ());
                                ab.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", Integer.valueOf(aoZ3.field_unReadCount));
                                aw.ZK();
                                String apm = com.tencent.mm.model.c.XR().apm("officialaccounts");
                                aw.ZK();
                                bi Rb = com.tencent.mm.model.c.XO().Rb(apm);
                                if (Rb == null || Rb.field_msgId <= 0) {
                                    aoZ3.dsI();
                                } else {
                                    aoZ3.ap(Rb);
                                    aoZ3.setContent(Rb.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Rb.field_content);
                                    aoZ3.jg(Integer.toString(Rb.getType()));
                                    aw.ZK();
                                    be.b Cb = com.tencent.mm.model.c.XR().Cb();
                                    if (Cb != null) {
                                        PString pString = new PString();
                                        PString pString2 = new PString();
                                        PInt pInt = new PInt();
                                        Rb.ju("officialaccounts");
                                        Rb.setContent(aoZ3.field_content);
                                        Cb.a(Rb, pString, pString2, pInt, true);
                                        aoZ3.jh(pString.value);
                                        aoZ3.ji(pString2.value);
                                        aoZ3.hP(pInt.value);
                                    }
                                }
                                aw.ZK();
                                com.tencent.mm.model.c.XR().a(aoZ3, aoZ3.field_username);
                            }
                        }
                    }
                    if (obj2 != null) {
                        jy jyVar = new jy();
                        jyVar.cFk.username = adVar.field_username;
                        jyVar.cFk.cFl = adVar.cFl;
                        com.tencent.mm.sdk.b.a.xxA.m(jyVar);
                    }
                    if (obj2 != null && bbv.vFH == 18) {
                        jeVar = new je();
                        jeVar.cEq.cEr = adVar.field_encryptUsername;
                        jeVar.cEq.type = 2;
                        com.tencent.mm.bi.d.akQ().QU(jeVar.cEq.cEr);
                        com.tencent.mm.sdk.b.a.xxA.m(jeVar);
                    }
                    if (obj2 != null) {
                        bG(adVar.field_username, bbv.vFH);
                    }
                    com.tencent.mm.plugin.label.a.a.bJa().ahw();
                    AppMethodBeat.o(18236);
                }
            }
        }
        obj = null;
        if (obj != null) {
        }
        if ((adVar.field_type & 8) == 0) {
        }
        if (z) {
        }
        if (obj2 != null) {
        }
        jeVar = new je();
        jeVar.cEq.cEr = adVar.field_encryptUsername;
        jeVar.cEq.type = 2;
        com.tencent.mm.bi.d.akQ().QU(jeVar.cEq.cEr);
        com.tencent.mm.sdk.b.a.xxA.m(jeVar);
        if (obj2 != null) {
        }
        com.tencent.mm.plugin.label.a.a.bJa().ahw();
        AppMethodBeat.o(18236);
    }
}
