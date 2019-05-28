package com.tencent.p177mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p217ci.C6454a;
import com.tencent.p177mm.p217ci.C6454a.C1387a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C12525c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21279r;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21280t;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21281u;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.C7286vl;
import com.tencent.p177mm.protocal.protobuf.bbv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import com.tencent.p177mm.vending.p636b.C7358b;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.messenger.foundation.a */
public final class C39368a implements C21279r {
    private static final C39369a opU = new C39369a();

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.a$a */
    static final class C39369a extends C6454a<C12525c> implements C12525c {
        private C39369a() {
        }

        /* synthetic */ C39369a(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo24446a(C7616ad c7616ad, C7616ad c7616ad2, bbv bbv, byte[] bArr, boolean z) {
            AppMethodBeat.m2504i(1018);
            final C7616ad c7616ad3 = c7616ad;
            final C7616ad c7616ad4 = c7616ad2;
            final bbv bbv2 = bbv;
            final byte[] bArr2 = bArr;
            final boolean z2 = z;
            mo14669a(new C1387a<C12525c>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(1016);
                    ((C12525c) obj).mo24446a(c7616ad3, c7616ad4, bbv2, bArr2, z2);
                    AppMethodBeat.m2505o(1016);
                }
            });
            AppMethodBeat.m2505o(1018);
        }

        /* renamed from: b */
        public final void mo24447b(C7616ad c7616ad, C7616ad c7616ad2, bbv bbv, byte[] bArr, boolean z) {
            AppMethodBeat.m2504i(1019);
            final C7616ad c7616ad3 = c7616ad;
            final C7616ad c7616ad4 = c7616ad2;
            final bbv bbv2 = bbv;
            final byte[] bArr2 = bArr;
            final boolean z2 = z;
            mo14669a(new C1387a<C12525c>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(1017);
                    ((C12525c) obj).mo24447b(c7616ad3, c7616ad4, bbv2, bArr2, z2);
                    AppMethodBeat.m2505o(1017);
                }
            });
            AppMethodBeat.m2505o(1019);
        }
    }

    static {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_SHAKA_ADD_4);
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_SHAKA_ADD_4);
    }

    /* renamed from: a */
    public static C7358b m67137a(C12525c c12525c) {
        AppMethodBeat.m2504i(1020);
        C7358b aD = opU.mo14670aD(c12525c);
        AppMethodBeat.m2505o(1020);
        return aD;
    }

    /* renamed from: a */
    public final void mo36640a(C40573tb c40573tb, byte[] bArr, boolean z, C21280t c21280t) {
        AppMethodBeat.m2504i(TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER);
        switch (c40573tb.wat) {
            case 2:
            case 17:
                bbv bbv = (bbv) new bbv().parseFrom(bArr);
                String str = "";
                if (!z) {
                    bArr = null;
                }
                C39368a.m67138a(bbv, str, bArr, false, z);
                AppMethodBeat.m2505o(TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER);
                return;
            case 4:
                C7286vl c7286vl = (C7286vl) new C7286vl().parseFrom(bArr);
                String a = C1946aa.m4148a(c7286vl.wcB);
                C4990ab.m7417i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", a);
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX(a);
                C1855t.m3933nb(a);
                C21281u.m32653b(4, c7286vl);
                break;
        }
        AppMethodBeat.m2505o(TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x031a A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0361  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0372 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x02dc A:{SKIP} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m67138a(bbv bbv, String str, byte[] bArr, boolean z, boolean z2) {
        AppMethodBeat.m2504i(1022);
        if (bbv == null) {
            C4990ab.m7414f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
            AppMethodBeat.m2505o(1022);
            return;
        }
        String a = C1946aa.m4148a(bbv.wcB);
        String nullAsNil = C5046bo.nullAsNil(bbv.wGl);
        if (C5046bo.isNullOrNil(a) && C5046bo.isNullOrNil(nullAsNil)) {
            C4990ab.m7413e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", a, nullAsNil);
            AppMethodBeat.m2505o(1022);
            return;
        }
        C4990ab.m7417i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s", bbv.wcB, bbv.wGo, bbv.wGp);
        C7486a aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(a);
        if (aoO == null || !a.equals(aoO.field_encryptUsername)) {
            C7486a dsl;
            String str2;
            String str3;
            Object[] objArr;
            int i;
            String str4;
            C7616ad c7616ad = null;
            if (aoO != null) {
                dsl = aoO.dsl();
                if (dsl != null) {
                    c7616ad = aoO;
                    if (c7616ad == null) {
                        c7616ad = new C7616ad(a);
                    }
                    c7616ad.setUsername(a);
                    c7616ad.mo14728iy(bbv.guS);
                    c7616ad.setType(bbv.wbu & bbv.wbv);
                    if (z && dsl != null && ((int) dsl.ewQ) > 0) {
                        C4990ab.m7421w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", a, Integer.valueOf(dsl.field_type), Integer.valueOf(c7616ad.field_type));
                        c7616ad.setType(c7616ad.field_type | dsl.field_type);
                    }
                    if (C5046bo.isNullOrNil(nullAsNil)) {
                        c7616ad.mo14709iH(nullAsNil);
                    } else if (dsl != null && ((int) dsl.ewQ) > 0) {
                        c7616ad.mo14709iH(dsl.field_encryptUsername);
                    }
                    c7616ad.ewQ = dsl != null ? 0 : (long) ((int) dsl.ewQ);
                    c7616ad.mo14703iB(C1946aa.m4148a(bbv.wyX));
                    c7616ad.mo14704iC(C1946aa.m4148a(bbv.wce));
                    c7616ad.mo14705iD(C1946aa.m4148a(bbv.wcf));
                    c7616ad.mo14685hA(bbv.guN);
                    c7616ad.mo14688hD(bbv.wbA);
                    c7616ad.mo14702iA(C1946aa.m4148a(bbv.wGf));
                    c7616ad.mo14689hE(bbv.wbE);
                    c7616ad.mo14690hF(bbv.guR);
                    c7616ad.mo14724iW(RegionCodeDecoder.m7796aC(bbv.guW, bbv.guO, bbv.guP));
                    c7616ad.mo14718iQ(bbv.guQ);
                    c7616ad.mo14698hw(bbv.wBT);
                    c7616ad.mo14723iV(bbv.wBU);
                    c7616ad.setSource(bbv.vFH);
                    c7616ad.mo14697hv(bbv.wBX);
                    c7616ad.mo14706iE(bbv.wBW);
                    if (C1855t.m3929nO(bbv.wBV)) {
                        c7616ad.mo14722iU(bbv.wBV);
                    }
                    if (c7616ad.dsi()) {
                        c7616ad.mo14692hH((int) C5046bo.anT());
                    }
                    if (!TextUtils.isEmpty(str)) {
                        c7616ad.mo14734je(str);
                    }
                    c7616ad.mo14729iz(C1946aa.m4148a(bbv.wFK));
                    c7616ad.mo14707iF(C1946aa.m4148a(bbv.wFM));
                    c7616ad.mo14708iG(C1946aa.m4148a(bbv.wFL));
                    c7616ad.mo14710iI(bbv.wcD);
                    c7616ad.mo14725iX(bbv.vEA);
                    c7616ad.mo14726iY(bbv.wGv);
                    if (C5046bo.m7540cb(bArr)) {
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15698F(a, bArr);
                    } else {
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoT(a);
                        C4990ab.m7413e("MicroMsg.ContactSyncExtension", "[processModContact] cmdBuf is null! user:%s", a);
                    }
                    c7616ad.mo14700hy(bbv.wGu);
                    if (!(bbv.wGq == null || bbv.wGq.vEU == null)) {
                        c7616ad.mo14727iZ(bbv.wGq.vEU.vLl);
                        c7616ad.mo14730ja(bbv.wGq.vEU.vLm);
                        c7616ad.mo14731jb(bbv.wGq.vEU.vLn);
                    }
                    if (C1855t.m3923nI(a)) {
                        c7616ad.mo16685NK();
                    }
                    if (c7616ad.dsf()) {
                        c7616ad.mo16688NN();
                    }
                    c7616ad.mo14732jc(bbv.duq);
                    c7616ad.mo14694hJ(bbv.wGz);
                    str2 = "MicroMsg.ContactSyncExtension";
                    str3 = "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)";
                    objArr = new Object[20];
                    objArr[0] = a;
                    objArr[1] = nullAsNil;
                    objArr[2] = Integer.valueOf((int) c7616ad.ewQ);
                    objArr[3] = c7616ad.field_nickname;
                    objArr[4] = c7616ad.mo14677Hu();
                    objArr[5] = Integer.valueOf(c7616ad.field_deleteFlag);
                    objArr[6] = Integer.valueOf(c7616ad.field_type);
                    objArr[7] = Integer.valueOf(bbv.wbu);
                    objArr[8] = Integer.valueOf(bbv.wbv);
                    objArr[9] = Integer.valueOf(c7616ad.dtX);
                    objArr[10] = Integer.valueOf(c7616ad.dua);
                    objArr[11] = bbv.guW;
                    objArr[12] = bbv.guO;
                    objArr[13] = bbv.guP;
                    objArr[14] = Integer.valueOf(c7616ad.getSource());
                    objArr[15] = c7616ad.field_contactLabelIds;
                    objArr[16] = Boolean.valueOf(z);
                    objArr[17] = Boolean.valueOf(bbv.vEA != null);
                    if (bbv.vEA != null) {
                        i = 0;
                    } else {
                        i = bbv.vEA.length();
                    }
                    objArr[18] = Integer.valueOf(i);
                    if (bbv.vEA != null) {
                        str4 = "";
                    } else {
                        str4 = C5046bo.anv(bbv.vEA);
                    }
                    objArr[19] = str4;
                    C4990ab.m7417i(str2, str3, objArr);
                    opU.mo24446a(c7616ad, dsl, bbv, bArr, z2);
                    if (C5046bo.isNullOrNil(nullAsNil)) {
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15732c(nullAsNil, c7616ad);
                    } else {
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15701Y(c7616ad);
                    }
                    opU.mo24447b(c7616ad, dsl, bbv, bArr, z2);
                    if ((c7616ad.field_type & 2048) == 0) {
                        if (dsl == null || (dsl.field_type & 2048) != (c7616ad.field_type & 2048)) {
                            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apf(c7616ad.field_username);
                        }
                    } else if (dsl == null || (dsl.field_type & 2048) != (c7616ad.field_type & 2048)) {
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apg(c7616ad.field_username);
                    }
                    C4990ab.m7417i("MicroMsg.ContactSyncExtension", "operationModSnsBlackContact username:%s isSnsBlackContact:%s", a, Boolean.valueOf(c7616ad.mo16701Od()));
                    AppMethodBeat.m2505o(1022);
                    return;
                }
            }
            dsl = aoO;
            if (c7616ad == null) {
            }
            c7616ad.setUsername(a);
            c7616ad.mo14728iy(bbv.guS);
            c7616ad.setType(bbv.wbu & bbv.wbv);
            C4990ab.m7421w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", a, Integer.valueOf(dsl.field_type), Integer.valueOf(c7616ad.field_type));
            c7616ad.setType(c7616ad.field_type | dsl.field_type);
            if (C5046bo.isNullOrNil(nullAsNil)) {
            }
            if (dsl != null) {
            }
            c7616ad.ewQ = dsl != null ? 0 : (long) ((int) dsl.ewQ);
            c7616ad.mo14703iB(C1946aa.m4148a(bbv.wyX));
            c7616ad.mo14704iC(C1946aa.m4148a(bbv.wce));
            c7616ad.mo14705iD(C1946aa.m4148a(bbv.wcf));
            c7616ad.mo14685hA(bbv.guN);
            c7616ad.mo14688hD(bbv.wbA);
            c7616ad.mo14702iA(C1946aa.m4148a(bbv.wGf));
            c7616ad.mo14689hE(bbv.wbE);
            c7616ad.mo14690hF(bbv.guR);
            c7616ad.mo14724iW(RegionCodeDecoder.m7796aC(bbv.guW, bbv.guO, bbv.guP));
            c7616ad.mo14718iQ(bbv.guQ);
            c7616ad.mo14698hw(bbv.wBT);
            c7616ad.mo14723iV(bbv.wBU);
            c7616ad.setSource(bbv.vFH);
            c7616ad.mo14697hv(bbv.wBX);
            c7616ad.mo14706iE(bbv.wBW);
            if (C1855t.m3929nO(bbv.wBV)) {
            }
            if (c7616ad.dsi()) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            c7616ad.mo14729iz(C1946aa.m4148a(bbv.wFK));
            c7616ad.mo14707iF(C1946aa.m4148a(bbv.wFM));
            c7616ad.mo14708iG(C1946aa.m4148a(bbv.wFL));
            c7616ad.mo14710iI(bbv.wcD);
            c7616ad.mo14725iX(bbv.vEA);
            c7616ad.mo14726iY(bbv.wGv);
            if (C5046bo.m7540cb(bArr)) {
            }
            c7616ad.mo14700hy(bbv.wGu);
            c7616ad.mo14727iZ(bbv.wGq.vEU.vLl);
            c7616ad.mo14730ja(bbv.wGq.vEU.vLm);
            c7616ad.mo14731jb(bbv.wGq.vEU.vLn);
            if (C1855t.m3923nI(a)) {
            }
            if (c7616ad.dsf()) {
            }
            c7616ad.mo14732jc(bbv.duq);
            c7616ad.mo14694hJ(bbv.wGz);
            str2 = "MicroMsg.ContactSyncExtension";
            str3 = "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)";
            objArr = new Object[20];
            objArr[0] = a;
            objArr[1] = nullAsNil;
            objArr[2] = Integer.valueOf((int) c7616ad.ewQ);
            objArr[3] = c7616ad.field_nickname;
            objArr[4] = c7616ad.mo14677Hu();
            objArr[5] = Integer.valueOf(c7616ad.field_deleteFlag);
            objArr[6] = Integer.valueOf(c7616ad.field_type);
            objArr[7] = Integer.valueOf(bbv.wbu);
            objArr[8] = Integer.valueOf(bbv.wbv);
            objArr[9] = Integer.valueOf(c7616ad.dtX);
            objArr[10] = Integer.valueOf(c7616ad.dua);
            objArr[11] = bbv.guW;
            objArr[12] = bbv.guO;
            objArr[13] = bbv.guP;
            objArr[14] = Integer.valueOf(c7616ad.getSource());
            objArr[15] = c7616ad.field_contactLabelIds;
            objArr[16] = Boolean.valueOf(z);
            if (bbv.vEA != null) {
            }
            objArr[17] = Boolean.valueOf(bbv.vEA != null);
            if (bbv.vEA != null) {
            }
            objArr[18] = Integer.valueOf(i);
            if (bbv.vEA != null) {
            }
            objArr[19] = str4;
            C4990ab.m7417i(str2, str3, objArr);
            opU.mo24446a(c7616ad, dsl, bbv, bArr, z2);
            if (C5046bo.isNullOrNil(nullAsNil)) {
            }
            opU.mo24447b(c7616ad, dsl, bbv, bArr, z2);
            if ((c7616ad.field_type & 2048) == 0) {
            }
            C4990ab.m7417i("MicroMsg.ContactSyncExtension", "operationModSnsBlackContact username:%s isSnsBlackContact:%s", a, Boolean.valueOf(c7616ad.mo16701Od()));
            AppMethodBeat.m2505o(1022);
            return;
        }
        C4990ab.m7421w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", a);
        AppMethodBeat.m2505o(1022);
    }
}
