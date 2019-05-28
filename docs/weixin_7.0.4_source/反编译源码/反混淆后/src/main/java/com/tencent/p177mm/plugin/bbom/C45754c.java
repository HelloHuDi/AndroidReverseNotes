package com.tencent.p177mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1185bc.C17974c;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C32237a;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.C8927c;
import com.tencent.p177mm.p184aj.p185a.C25759h;
import com.tencent.p177mm.p201az.C32323b;
import com.tencent.p177mm.p203bg.C32337g;
import com.tencent.p177mm.p230g.p231a.C42017jy;
import com.tencent.p177mm.p230g.p231a.C42061sy;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p230g.p231a.C45322ez;
import com.tencent.p177mm.p230g.p231a.C45332hj;
import com.tencent.p177mm.p230g.p231a.C45339km;
import com.tencent.p177mm.p230g.p231a.C6497je;
import com.tencent.p177mm.p230g.p231a.C9480tg;
import com.tencent.p177mm.p230g.p711c.C6571cp;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p712j.p713a.p714a.C6592a;
import com.tencent.p177mm.p837bh.C25859d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18818b;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C12525c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.multitalk.model.C39419a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.pluginsdk.p597ui.preference.C14957b;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.protobuf.C7281qf;
import com.tencent.p177mm.protocal.protobuf.C7285uy;
import com.tencent.p177mm.protocal.protobuf.bbv;
import com.tencent.p177mm.protocal.protobuf.bbw;
import com.tencent.p177mm.protocal.protobuf.bck;
import com.tencent.p177mm.protocal.protobuf.bkf;
import com.tencent.p177mm.protocal.protobuf.bkg;
import com.tencent.p177mm.protocal.protobuf.ccl;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C41338bt;
import com.tencent.p177mm.storage.C7310be.C5133b;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7570bf;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.bbom.c */
public final class C45754c implements C1202f, C12525c {
    /* renamed from: a */
    private static void m84562a(bbv bbv, String str, C7616ad c7616ad, boolean z) {
        AppMethodBeat.m2504i(18237);
        String Yz = C1853r.m3846Yz();
        if (!(Yz == null || Yz.equals(str))) {
            C16527d qP = C41747z.aeR().mo43729qP(str);
            qP.field_username = str;
            qP.field_brandList = bbv.guX;
            C7285uy c7285uy = bbv.wCa;
            if (c7285uy != null) {
                qP.field_brandFlag = c7285uy.gvb;
                qP.field_brandInfo = c7285uy.gvd;
                qP.field_brandIconURL = c7285uy.gve;
                qP.field_extInfo = c7285uy.gvc;
                if (z) {
                    qP.field_attrSyncVersion = null;
                    qP.field_incrementUpdateTime = 0;
                    C4990ab.m7417i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", str);
                }
                if (!C5046bo.isNullOrNil(qP.field_extInfo)) {
                    qP.mo30481cJ(true);
                }
            }
            if (!(qP.mo30481cJ(false) == null || qP.mo30481cJ(false).getServiceType() != 3 || qP.mo30481cJ(false).aer() == null || C5046bo.isNullOrNil(qP.adX()))) {
                qP.field_enterpriseFather = qP.adX();
                C4990ab.m7411d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", str, qP.field_enterpriseFather);
            }
            if (!C41747z.aeR().mo43726e(qP)) {
                C41747z.aeR().mo43724d(qP);
            }
            c7616ad.mo14693hI(qP.field_type);
        }
        AppMethodBeat.m2505o(18237);
    }

    /* renamed from: a */
    public static boolean m84563a(C7616ad c7616ad, bbv bbv, boolean z) {
        AppMethodBeat.m2504i(18238);
        if (c7616ad == null || C5046bo.isNullOrNil(c7616ad.field_username)) {
            C4990ab.m7412e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
            AppMethodBeat.m2505o(18238);
            return false;
        }
        String str = c7616ad.field_username;
        String str2 = c7616ad.field_encryptUsername;
        C17884o.act().mo33391b(C41730b.m73491a(str, bbv));
        ccl ccl = bbv.wBZ;
        if (!(c7616ad.field_username.endsWith("@chatroom") || ccl == null)) {
            C4990ab.m7416i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + ccl.guY + " " + bbv.wcB);
            C4990ab.m7416i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + ccl.guZ);
            C4990ab.m7416i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ccl.gva);
            C4990ab.m7416i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ccl.xbQ);
            C4990ab.m7416i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ccl.xbR);
            if (C21877n.qFy != null) {
                C21877n.qFy.mo47112a(c7616ad.field_username, ccl);
            }
        }
        if (C7486a.m12942jh(c7616ad.field_type)) {
            boolean ep = C41789d.akP().mo17076ep(str, 1);
            if (ep) {
                C4990ab.m7410d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = ".concat(String.valueOf(str)));
            } else {
                ep = C41789d.akP().mo17076ep(str2, 1);
                C4990ab.m7410d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = ".concat(String.valueOf(str2)));
            }
            C4990ab.m7416i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = ".concat(String.valueOf(ep)));
        }
        if (C7486a.m12942jh(c7616ad.field_type) && (c7616ad.getSource() == 10 || c7616ad.getSource() == 13)) {
            C26529w.m42364n(C4996ah.getContext(), c7616ad.field_username, c7616ad.field_encryptUsername);
            C18817a vT = C32923a.getAddrUploadStg().mo34089vT(c7616ad.field_encryptUsername);
            if (!(vT == null || C5046bo.isNullOrNil(vT.guM))) {
                vT.username = c7616ad.field_username;
                C4990ab.m7410d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr ".concat(String.valueOf(C32923a.getAddrUploadStg().mo34084a(vT.guM, vT))));
            }
        }
        C45754c.m84562a(bbv, str, c7616ad, z);
        AppMethodBeat.m2505o(18238);
        return true;
    }

    /* renamed from: a */
    private static boolean m84564a(C7616ad c7616ad, C7575bv c7575bv) {
        AppMethodBeat.m2504i(18239);
        boolean z = false;
        if (!C5046bo.isNullOrNil(c7575bv.field_conDescription)) {
            c7616ad.mo14725iX(c7575bv.field_conDescription);
        }
        if (!C1855t.m3911mX(c7616ad.field_username) && C7486a.m12942jh(c7616ad.field_type)) {
            z = true;
            if (!C5046bo.isNullOrNil(c7575bv.field_conDescription)) {
                bbw bbw = new bbw();
                bbw.wGA = c7616ad.field_username;
                bbw.Desc = c7575bv.field_conDescription;
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C3465a(54, bbw));
            }
        }
        AppMethodBeat.m2505o(18239);
        return z;
    }

    /* renamed from: D */
    private static void m84561D(C7616ad c7616ad) {
        AppMethodBeat.m2504i(18240);
        if (!(c7616ad == null || !C17903f.m28108rb(c7616ad.field_username) || C17903f.m28103kq(c7616ad.field_username))) {
            C9638aw.m17190ZK();
            C7617ak aoZ = C18628c.m29083XR().aoZ(c7616ad.field_username);
            C16527d qP = C41747z.aeR().mo43729qP(c7616ad.field_username);
            if (!C17903f.m28111re(qP.field_username)) {
                AppMethodBeat.m2505o(18240);
                return;
            } else if (aoZ == null) {
                aoZ = new C7617ak(qP.field_username);
                C4990ab.m7417i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", qP.adX(), qP.field_username);
                aoZ.mo14760jj(C5046bo.nullAsNil(qP.adX()));
                aoZ.dsI();
                C9638aw.m17190ZK();
                C18628c.m29083XR().mo15807d(aoZ);
            }
        }
        AppMethodBeat.m2505o(18240);
    }

    /* renamed from: bG */
    private static void m84565bG(String str, int i) {
        C14957b[] a;
        C41338bt[] c41338btArr;
        C7569ax[] c7569axArr;
        AppMethodBeat.m2504i(18241);
        C7570bf[] c7570bfArr = null;
        if (i == 26 || i == 27 || i == 28 || i == 29) {
            C4990ab.m7410d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
            C41338bt[] apY = C41789d.akR().apY(str);
            a = C14957b.m23243a(C4996ah.getContext(), apY);
            c41338btArr = apY;
            c7569axArr = null;
        } else if (i == 18) {
            C4990ab.m7410d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
            C6571cp[] c7570bfArr2 = C41789d.akQ().apz(str);
            a = C14957b.m23241a(C4996ah.getContext(), c7570bfArr2);
            c41338btArr = null;
            c7569axArr = null;
        } else {
            C7569ax[] apv = C41789d.akO().apv(str);
            a = C14957b.m23242a(C4996ah.getContext(), apv);
            c41338btArr = null;
            c7569axArr = apv;
        }
        if (a == null) {
            AppMethodBeat.m2505o(18241);
            return;
        }
        int i2 = 0;
        int length = a.length;
        int i3 = 0;
        while (i3 < length) {
            int i4;
            C14957b c14957b = a[i3];
            C7620bi c7620bi = new C7620bi();
            c7620bi.setContent(c14957b.fjz);
            int nK = C1855t.m3925nK(c14957b.username);
            if (c7569axArr != null) {
                i4 = i2 + 1;
                c7620bi.mo14775eJ(c7569axArr[i2].field_createTime);
            } else if (c7570bfArr2 != null) {
                i4 = i2 + 1;
                c7620bi.mo14775eJ(c7570bfArr2[i2].field_createtime * 1000);
            } else if (c41338btArr != null) {
                i4 = i2 + 1;
                c7620bi.mo14775eJ(c41338btArr[i2].field_createtime * 1000);
            } else {
                i4 = i2;
            }
            c7620bi.mo14794ju(c14957b.username);
            c7620bi.setType(nK);
            if (c14957b.cRY) {
                c7620bi.setStatus(2);
                c7620bi.mo14781hO(1);
            } else {
                c7620bi.setStatus(6);
                c7620bi.mo14781hO(0);
            }
            C9638aw.m17190ZK();
            long Z = C18628c.m29080XO().mo15281Z(c7620bi);
            Assert.assertTrue(Z != -1);
            C4990ab.m7416i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = ".concat(String.valueOf(Z)));
            i3++;
            i2 = i4;
        }
        C7620bi c7620bi2 = new C7620bi();
        if (c7569axArr != null) {
            c7620bi2.mo14775eJ(c7569axArr[0].field_createTime + 1);
        } else if (c7570bfArr2 != null) {
            c7620bi2.mo14775eJ((c7570bfArr2[0].field_createtime * 1000) + 1);
        } else if (c41338btArr != null) {
            c7620bi2.mo14775eJ((c41338btArr[0].field_createtime * 1000) + 1);
        }
        c7620bi2.mo14794ju(str);
        c7620bi2.setContent(C4996ah.getContext().getString(C25738R.string.exy));
        c7620bi2.setType(Downloads.MIN_WAIT_FOR_NETWORK);
        c7620bi2.setStatus(6);
        c7620bi2.mo14781hO(0);
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15281Z(c7620bi2);
        AppMethodBeat.m2505o(18241);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(18242);
        C4990ab.m7417i("MicroMsg.BigBallContactAssemblerImpl", "onsceneEnd errType:%d,errCode:%d,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m.getType() != 681) {
            AppMethodBeat.m2505o(18242);
        } else if (i != 0 || i2 != 0) {
            AppMethodBeat.m2505o(18242);
        } else if (C1720g.m3534RN().eJb) {
            List<C3463b> list = ((C32323b) c1207m).fLs;
            HashSet<String> hashSet = new HashSet();
            try {
                for (C3463b c3463b : list) {
                    if (c3463b.getCmdId() == 2) {
                        hashSet.add(C1946aa.m4148a(((bbv) new bbv().parseFrom(c3463b.getBuffer())).wcB));
                    } else if (c3463b.getCmdId() == 54) {
                        hashSet.add(((bbw) new bbw().parseFrom(c3463b.getBuffer())).wGA);
                    } else if (c3463b.getCmdId() == 60) {
                        hashSet.add(((bck) new bck().parseFrom(c3463b.getBuffer())).wGA);
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", e, "BaseProtoBuf parseFrom error!", new Object[0]);
            }
            for (String str2 : hashSet) {
                if (!C5046bo.isNullOrNil(str2)) {
                    C26417a.flu.mo20966a(str2, null, null);
                }
            }
            AppMethodBeat.m2505o(18242);
        } else {
            C4990ab.m7420w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
            AppMethodBeat.m2505o(18242);
        }
    }

    /* renamed from: a */
    public final void mo24446a(C7616ad c7616ad, C7616ad c7616ad2, bbv bbv, byte[] bArr, boolean z) {
        Object obj;
        String str;
        AppMethodBeat.m2504i(18235);
        String str2 = c7616ad.field_username;
        String str3 = c7616ad.field_encryptUsername;
        if (!(c7616ad2 == null || C5046bo.nullAsNil(c7616ad2.dum).equals(C5046bo.nullAsNil(bbv.wGv)))) {
            C17974c.aiB();
            C17974c.m28284sY(str2);
        }
        if (C5046bo.m7540cb(bArr)) {
            C45754c.m84563a(c7616ad, bbv, true);
        } else if (C7616ad.m13547Mn(c7616ad.field_verifyFlag)) {
            C45754c.m84562a(bbv, str2, c7616ad, true);
        }
        if (c7616ad2 == null || C7486a.m12942jh(c7616ad2.field_type) || !C7486a.m12942jh(c7616ad.field_type)) {
            obj = null;
        } else {
            obj = 1;
        }
        String str4 = "MicroMsg.BigBallContactAssemblerImpl";
        String str5 = "username:%s PhoneNumList size:%s";
        Object[] objArr = new Object[2];
        objArr[0] = c7616ad.field_username;
        if (bbv.wGw == null) {
            str = "";
        } else {
            str = Integer.valueOf(C5046bo.m7567h(Integer.valueOf(bbv.wGw.wNu.size())));
        }
        objArr[1] = str;
        C4990ab.m7417i(str4, str5, objArr);
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
        C4990ab.m7417i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", c7616ad.field_username, stringBuffer.toString());
        str = null;
        Object obj2 = null;
        if (c7616ad2 != null) {
            str = c7616ad2.dur;
        }
        if (str == null || str.equals("")) {
            C9638aw.m17190ZK();
            C7575bv RB = C18628c.m29079XN().mo15364RB(str3);
            if (RB != null) {
                str = RB.field_conPhone;
            }
        }
        C4990ab.m7417i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", c7616ad.field_username, C5046bo.nullAsNil(str));
        if (!C5046bo.isNullOrNil(str)) {
            int i;
            Object obj3 = null;
            for (String str6 : str.split(",")) {
                if (!C5046bo.isNullOrNil(stringBuffer.toString())) {
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
                bck.wGA = c7616ad.field_username;
                bkg bkg = new bkg();
                if (!C5046bo.isNullOrNil(stringBuffer.toString())) {
                    String[] split2 = stringBuffer.toString().split(",");
                    bkg.jBv = split2.length;
                    bkg.wNu = new LinkedList();
                    for (String str7 : split2) {
                        bkf bkf2 = new bkf();
                        bkf2.wNt = str7;
                        bkg.wNu.add(bkf2);
                    }
                    bck.wGw = bkg;
                    C9638aw.m17190ZK();
                    C18628c.m29077XL().mo7920c(new C3465a(60, bck));
                }
            }
            if (!(obj == null || 15 != bbv.vFH || C5046bo.isNullOrNil(c7616ad.field_username))) {
                C18817a vT = C32923a.getAddrUploadStg().mo34089vT(c7616ad.field_username);
                if (vT != null) {
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = c7616ad.field_username;
                    objArr2[1] = Integer.valueOf(3);
                    objArr2[2] = Integer.valueOf(C5046bo.isNullOrNil(vT.mo34067Aq()) ? 0 : 1);
                    if (stringBuffer.toString().split(",").length >= 5) {
                        i = 5;
                    } else {
                        i = stringBuffer.toString().split(",").length;
                    }
                    objArr2[3] = Integer.valueOf(i);
                    c7060h.mo8381e(12040, objArr2);
                }
            }
        }
        C4990ab.m7417i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", c7616ad.field_username, stringBuffer.toString());
        str = stringBuffer.toString();
        if (!C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.BigBallContactAssemblerImpl", str);
            c7616ad.mo14733jd(str);
        }
        if (!(C1855t.m3896kH(str2) || bbv.wnN == null)) {
            C37921n.m64052a(str2, bbv.wnN);
        }
        boolean z2 = false;
        C9638aw.m17190ZK();
        C7575bv RB2 = C18628c.m29079XN().mo15364RB(c7616ad.field_username);
        if (C5046bo.isNullOrNil(c7616ad.field_conRemark)) {
            if ((RB2 == null || C5046bo.isNullOrNil(RB2.field_encryptUsername)) && !C5046bo.isNullOrNil(str3)) {
                C9638aw.m17190ZK();
                RB2 = C18628c.m29079XN().mo15364RB(str3);
            }
            if (!(RB2 == null || C5046bo.isNullOrNil(RB2.field_encryptUsername))) {
                C4990ab.m7416i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + RB2.field_encryptUsername);
                c7616ad.mo14729iz(RB2.field_conRemark);
                c7616ad.mo14707iF(C9790g.m17432vo(RB2.field_conRemark));
                c7616ad.mo14708iG(C9790g.m17433vp(RB2.field_conRemark));
                z2 = C45754c.m84564a(c7616ad, RB2);
            }
            switch (c7616ad.getSource()) {
                case 10:
                case 11:
                case 13:
                    C18817a c18817a = null;
                    if (bbv != null && !C5046bo.isNullOrNil(bbv.wGo)) {
                        C4990ab.m7417i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", bbv.wGo, bbv.wGp);
                        C18818b addrUploadStg = C32923a.getAddrUploadStg();
                        String str8 = bbv.wGo;
                        str5 = bbv.wGp;
                        c18817a = addrUploadStg.mo34092vW(str8);
                        if (c18817a == null) {
                            c18817a = addrUploadStg.mo34092vW(str5);
                        }
                    } else if (!C5046bo.isNullOrNil(str3)) {
                        c18817a = C32923a.getAddrUploadStg().mo34089vT(str3);
                    }
                    if (c18817a == null) {
                        C4990ab.m7416i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
                    } else {
                        C4990ab.m7417i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", C5046bo.nullAsNil(c18817a.apA()), C5046bo.nullAsNil(c18817a.getUsername()), Boolean.valueOf(c18817a.apI()));
                    }
                    if (!(c18817a == null || C5046bo.isNullOrNil(c18817a.apA()) || !c18817a.apI())) {
                        C4990ab.m7417i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", c18817a.apA(), c18817a.getUsername(), Boolean.valueOf(z2));
                        c18817a.username = c7616ad.field_username;
                        c18817a.status = 2;
                        c18817a.apH();
                        if (!z2) {
                            c7616ad.mo14729iz(c18817a.apA());
                            c7616ad.mo14707iF(C9790g.m17432vo(c18817a.apA()));
                            c7616ad.mo14708iG(C9790g.m17433vp(c18817a.apA()));
                            z2 = true;
                        }
                        if (C7486a.m12942jh(c7616ad.field_type)) {
                            C4990ab.m7417i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", c18817a.apA(), c18817a.getUsername(), Boolean.valueOf(z2));
                            C32923a.getAddrUploadStg().mo34084a(c18817a.mo34067Aq(), c18817a);
                            break;
                        }
                    }
                    break;
            }
        }
        if (!(RB2 == null || C5046bo.isNullOrNil(c7616ad.dul) || c7616ad.dul.equals(RB2.field_conDescription))) {
            C45754c.m84564a(c7616ad, RB2);
        }
        z2 = false;
        C4990ab.m7417i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", c7616ad.field_username, Boolean.valueOf(z2), str3);
        if (z2) {
            C1855t.m3965v(c7616ad);
        }
        str = null;
        C9638aw.m17190ZK();
        RB2 = C18628c.m29079XN().mo15364RB(c7616ad.field_encryptUsername);
        if (RB2 != null) {
            str = RB2.field_contactLabels;
        }
        if (C5046bo.isNullOrNil(str)) {
            C9638aw.m17190ZK();
            RB2 = C18628c.m29079XN().mo15364RB(c7616ad.field_username);
            if (RB2 != null) {
                str = RB2.field_contactLabels;
            }
        }
        if (!C5046bo.isNullOrNil(str)) {
            C21156a.bJa().mo41641eQ(c7616ad.field_username, str);
            RB2.field_contactLabels = "";
            C9638aw.m17190ZK();
            C18628c.m29079XN().mo10099a(RB2);
        }
        AppMethodBeat.m2505o(18235);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0662 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0257 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x027a A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x03d8  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0418  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final void mo24447b(C7616ad c7616ad, C7616ad c7616ad2, bbv bbv, byte[] bArr, boolean z) {
        Object obj;
        int i;
        Object obj2;
        C16527d qP;
        C6497je c6497je;
        AppMethodBeat.m2504i(18236);
        String str = c7616ad.field_username;
        String str2 = c7616ad.field_encryptUsername;
        if (C1855t.m3896kH(str)) {
            String akN;
            if (bbv.wnN != null) {
                Iterator it;
                C7281qf c7281qf;
                LinkedList linkedList = bbv.wnN.vXi;
                if (C25859d.fUv == null) {
                    obj = null;
                } else {
                    akN = C25859d.fUv.akN();
                    if (!C5046bo.isNullOrNil(akN) && akN.equals(str) && C1855t.m3896kH(str)) {
                        if (linkedList != null) {
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                                c7281qf = (C7281qf) it.next();
                                if (!C5046bo.isNullOrNil(c7281qf.jBB) && c7281qf.jBB.equals(C1853r.m3846Yz())) {
                                    obj = null;
                                    break;
                                }
                            }
                        }
                        if (C25859d.fUu != null) {
                            if (C25859d.fUu.mo20560aV(str, C1853r.m3846Yz())) {
                                C4990ab.m7416i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
                                C9480tg c9480tg = new C9480tg();
                                c9480tg.cPx.userName = str;
                                C4879a.xxA.mo10055m(c9480tg);
                            }
                            C25859d.fUu.mo20559a(str, null, 0.0d, 0.0d, "", "", "");
                        }
                        if (!(C25859d.fUv == null || C5046bo.isNullOrNil(C25859d.fUu.akM()))) {
                            C4990ab.m7417i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", C25859d.fUv.akN());
                            C45322ez c45322ez = new C45322ez();
                            c45322ez.cys.username = C25859d.fUv.akN();
                            C4879a.xxA.mo10055m(c45322ez);
                        }
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                if (obj == null) {
                    linkedList = bbv.wnN.vXi;
                    C42062sz c42062sz = new C42062sz();
                    c42062sz.cPf.cPh = true;
                    C4879a.xxA.mo10055m(c42062sz);
                    if (!C5046bo.isNullOrNil(str) && C1855t.m3896kH(str) && !C5046bo.isNullOrNil(c42062sz.cPg.cPj) && str.equals(c42062sz.cPg.cPj)) {
                        if (linkedList != null) {
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                                c7281qf = (C7281qf) it.next();
                                if (!C5046bo.isNullOrNil(c7281qf.jBB)) {
                                    if (c7281qf.jBB.equals(C1853r.m3846Yz())) {
                                        break;
                                    }
                                }
                            }
                        }
                        if (C32337g.fUs != null) {
                            C32337g.fUs.mo4621a(str, null, "", "", 0);
                        }
                        C42062sz c42062sz2 = new C42062sz();
                        c42062sz2.cPf.cPi = true;
                        C4879a.xxA.mo10055m(c42062sz2);
                        C42061sy c42061sy = new C42061sy();
                        c42061sy.cPd.cPe = true;
                        C4879a.xxA.mo10055m(c42061sy);
                    }
                }
                linkedList = bbv.wnN.vXi;
                if (linkedList != null) {
                    it = linkedList.iterator();
                    while (it.hasNext()) {
                        c7281qf = (C7281qf) it.next();
                        if (C5046bo.isNullOrNil(c7281qf.jBB) || !c7281qf.jBB.equals(C1853r.m3846Yz())) {
                        }
                    }
                    obj = 1;
                    if (obj != null) {
                        ((C39419a) C1720g.m3528K(C39419a.class)).mo55109RU(str);
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
            C4990ab.m7417i(akN, str3, objArr);
            if (!(bbv.wnN == null || bbv.wnN.ehB == 0)) {
                C6592a c6592a = new C6592a();
                c6592a.type = bbv.wGt;
                c6592a.ehD = bbv.wGs;
                c6592a.eox = bbv.ndT;
                c6592a.eoy = bbv.wGr;
                if (bbv.wnN.vXj == 0) {
                    c6592a.cGj = bbv.wGr;
                }
                if (C37921n.m64043N(str, bbv.wGr)) {
                    C4879a.xxA.mo10055m(new C45332hj());
                    C37921n.m64044O(str, bbv.wGt);
                }
                C45339km c45339km = new C45339km();
                c45339km.cGi.chatroomName = str;
                c45339km.cGi.cGj = c6592a.cGj;
                C37921n.m64054a(str, bbv.wGi, bbv.wnN, bbv.wGy, C1853r.m3846Yz(), c6592a, c45339km);
            }
        }
        if (!(C7486a.m12942jh(c7616ad.field_type) || c7616ad.mo16694NY() || C7616ad.m13548mR(c7616ad.field_username) || C1855t.m3896kH(c7616ad.field_username))) {
            C4990ab.m7421w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", c7616ad.field_username, Integer.valueOf(c7616ad.field_type));
            C9638aw.m17190ZK();
            C18628c.m29083XR().aoX(c7616ad.field_username);
        }
        if ((c7616ad.field_type & 2048) != 0) {
            if (c7616ad2 == null || (c7616ad2.field_type & 2048) != (c7616ad.field_type & 2048)) {
                if (C17903f.m28108rb(c7616ad.field_username) && !C17903f.m28103kq(c7616ad.field_username)) {
                    C45754c.m84561D(c7616ad);
                } else if (c7616ad.dsf() && C17903f.m28106qZ(c7616ad.field_username) && c7616ad != null && c7616ad.dsf() && C17903f.m28106qZ(c7616ad.field_username)) {
                    C4990ab.m7416i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + c7616ad.field_username);
                    C9638aw.m17190ZK();
                    C7617ak aoZ = C18628c.m29083XR().aoZ(c7616ad.field_username);
                    C41747z.aeR().mo43729qP(c7616ad.field_username);
                    if (aoZ == null) {
                        C9638aw.m17190ZK();
                        if (C18628c.m29083XR().aoZ("officialaccounts") == null) {
                            aoZ = new C7617ak("officialaccounts");
                            aoZ.dsI();
                            C9638aw.m17190ZK();
                            C18628c.m29083XR().mo15807d(aoZ);
                        }
                        aoZ = new C7617ak(c7616ad.field_username);
                        aoZ.mo14760jj("officialaccounts");
                        C9638aw.m17190ZK();
                        C18628c.m29083XR().mo15807d(aoZ);
                    }
                }
            }
        } else if ((c7616ad2 == null || (c7616ad2.field_type & 2048) != (c7616ad.field_type & 2048)) && C17903f.m28108rb(c7616ad.field_username) && !C17903f.m28103kq(c7616ad.field_username)) {
            C45754c.m84561D(c7616ad);
        }
        if (c7616ad2 == null || C7486a.m12942jh(c7616ad2.field_type) || !C7486a.m12942jh(c7616ad.field_type)) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (C7486a.m12942jh(c7616ad.field_type)) {
            C9638aw.m17190ZK();
            C7575bv RB = C18628c.m29079XN().mo15364RB(str);
            if ((RB == null || C5046bo.isNullOrNil(RB.field_encryptUsername)) && !C5046bo.isNullOrNil(str2)) {
                C9638aw.m17190ZK();
                RB = C18628c.m29079XN().mo15364RB(str2);
            }
            if (!(RB == null || C5046bo.isNullOrNil(RB.field_encryptUsername))) {
                C9638aw.m17190ZK();
                C18628c.m29079XN().mo15365RC(RB.field_encryptUsername);
            }
        }
        if (C17903f.m28107ra(c7616ad.field_username)) {
            C41747z.afa();
            C8927c.m16090a(c7616ad.field_username, null);
            if (obj2 != null && C17903f.m28108rb(c7616ad.field_username)) {
                if (C17903f.m28103kq(c7616ad.field_username)) {
                    C41747z.aeZ();
                    C25759h.m40920a(c7616ad.field_username, null);
                } else if (C17903f.m28111re(c7616ad.field_username)) {
                    C9638aw.m17190ZK();
                    if (C18628c.m29083XR().aoZ(c7616ad.field_username) == null) {
                        qP = C41747z.aeR().mo43729qP(c7616ad.field_username);
                        C7617ak c7617ak = new C7617ak(c7616ad.field_username);
                        if (qP.adR()) {
                            c7617ak.mo14760jj(null);
                        } else {
                            C4990ab.m7417i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", qP.adX(), c7616ad.field_username);
                            c7617ak.mo14760jj(C5046bo.nullAsNil(qP.adX()));
                        }
                        c7617ak.dsI();
                        C9638aw.m17190ZK();
                        C18628c.m29083XR().mo15807d(c7617ak);
                    }
                }
            }
        }
        qP = C17903f.m28104qX(c7616ad.field_username);
        if (qP != null) {
            C16529b cJ = qP.mo30481cJ(false);
            if (cJ != null) {
                i = 0;
                if (cJ.fvc != null) {
                    i = cJ.fvc.optInt("WXAppType", 0);
                }
                if (i != 0) {
                    obj = 1;
                    if (obj != null) {
                        C41747z.afd();
                        C32237a.m52584qy(c7616ad.field_username);
                    }
                    if ((c7616ad.field_type & 8) == 0) {
                        if (c7616ad2 == null || (c7616ad2.field_type & 8) != (c7616ad.field_type & 8)) {
                            C9638aw.m17190ZK();
                            C18628c.m29083XR().mo15806c(new String[]{c7616ad.field_username}, "@blacklist");
                        }
                    } else if (c7616ad2 == null || (c7616ad2.field_type & 8) != (c7616ad.field_type & 8)) {
                        C9638aw.m17190ZK();
                        C18628c.m29083XR().mo15806c(new String[]{c7616ad.field_username}, "");
                    }
                    if (!z) {
                        if (c7616ad != null && c7616ad.dsf() && C7486a.m12942jh(c7616ad.field_type)) {
                            long currentTimeMillis = System.currentTimeMillis();
                            C9638aw.m17190ZK();
                            C7617ak aoZ2 = C18628c.m29083XR().aoZ(c7616ad.field_username);
                            if (aoZ2 != null && aoZ2.mo16714jl(4194304)) {
                                C9638aw.m17190ZK();
                                boolean a = C18628c.m29083XR().mo15777a(c7616ad.field_username, 4194304, false, aoZ2.field_attrflag);
                                C4990ab.m7417i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", c7616ad.field_username, Boolean.valueOf(a), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            }
                        }
                        if (c7616ad2 != null && ((int) c7616ad2.ewQ) > 0 && c7616ad2.duj != 0 && c7616ad2.duk == 0 && c7616ad.duk == 1) {
                            C4990ab.m7411d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", c7616ad.field_username);
                            C9638aw.m17190ZK();
                            C18628c.m29083XR().app(c7616ad.field_username);
                            C9638aw.m17190ZK();
                            C7617ak aoZ3 = C18628c.m29083XR().aoZ("officialaccounts");
                            if (aoZ3 != null) {
                                C9638aw.m17190ZK();
                                aoZ3.mo14748hM(C18628c.m29083XR().dsQ());
                                C4990ab.m7411d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", Integer.valueOf(aoZ3.field_unReadCount));
                                C9638aw.m17190ZK();
                                String apm = C18628c.m29083XR().apm("officialaccounts");
                                C9638aw.m17190ZK();
                                C7620bi Rb = C18628c.m29080XO().mo15248Rb(apm);
                                if (Rb == null || Rb.field_msgId <= 0) {
                                    aoZ3.dsI();
                                } else {
                                    aoZ3.mo17068ap(Rb);
                                    aoZ3.setContent(Rb.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Rb.field_content);
                                    aoZ3.mo14757jg(Integer.toString(Rb.getType()));
                                    C9638aw.m17190ZK();
                                    C5133b Cb = C18628c.m29083XR().mo15765Cb();
                                    if (Cb != null) {
                                        PString pString = new PString();
                                        PString pString2 = new PString();
                                        PInt pInt = new PInt();
                                        Rb.mo14794ju("officialaccounts");
                                        Rb.setContent(aoZ3.field_content);
                                        Cb.mo10533a(Rb, pString, pString2, pInt, true);
                                        aoZ3.mo14758jh(pString.value);
                                        aoZ3.mo14759ji(pString2.value);
                                        aoZ3.mo14751hP(pInt.value);
                                    }
                                }
                                C9638aw.m17190ZK();
                                C18628c.m29083XR().mo15767a(aoZ3, aoZ3.field_username);
                            }
                        }
                    }
                    if (obj2 != null) {
                        C42017jy c42017jy = new C42017jy();
                        c42017jy.cFk.username = c7616ad.field_username;
                        c42017jy.cFk.cFl = c7616ad.cFl;
                        C4879a.xxA.mo10055m(c42017jy);
                    }
                    if (obj2 != null && bbv.vFH == 18) {
                        c6497je = new C6497je();
                        c6497je.cEq.cEr = c7616ad.field_encryptUsername;
                        c6497je.cEq.type = 2;
                        C41789d.akQ().mo15230QU(c6497je.cEq.cEr);
                        C4879a.xxA.mo10055m(c6497je);
                    }
                    if (obj2 != null) {
                        C45754c.m84565bG(c7616ad.field_username, bbv.vFH);
                    }
                    C21156a.bJa().ahw();
                    AppMethodBeat.m2505o(18236);
                }
            }
        }
        obj = null;
        if (obj != null) {
        }
        if ((c7616ad.field_type & 8) == 0) {
        }
        if (z) {
        }
        if (obj2 != null) {
        }
        c6497je = new C6497je();
        c6497je.cEq.cEr = c7616ad.field_encryptUsername;
        c6497je.cEq.type = 2;
        C41789d.akQ().mo15230QU(c6497je.cEq.cEr);
        C4879a.xxA.mo10055m(c6497je);
        if (obj2 != null) {
        }
        C21156a.bJa().ahw();
        AppMethodBeat.m2505o(18236);
    }
}
