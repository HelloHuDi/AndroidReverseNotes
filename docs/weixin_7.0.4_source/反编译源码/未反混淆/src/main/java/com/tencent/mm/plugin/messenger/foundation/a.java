package com.tencent.mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.vending.b.b;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class a implements r {
    private static final a opU = new a();

    static final class a extends com.tencent.mm.ci.a<c> implements c {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(ad adVar, ad adVar2, bbv bbv, byte[] bArr, boolean z) {
            AppMethodBeat.i(1018);
            final ad adVar3 = adVar;
            final ad adVar4 = adVar2;
            final bbv bbv2 = bbv;
            final byte[] bArr2 = bArr;
            final boolean z2 = z;
            a(new com.tencent.mm.ci.a.a<c>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(1016);
                    ((c) obj).a(adVar3, adVar4, bbv2, bArr2, z2);
                    AppMethodBeat.o(1016);
                }
            });
            AppMethodBeat.o(1018);
        }

        public final void b(ad adVar, ad adVar2, bbv bbv, byte[] bArr, boolean z) {
            AppMethodBeat.i(1019);
            final ad adVar3 = adVar;
            final ad adVar4 = adVar2;
            final bbv bbv2 = bbv;
            final byte[] bArr2 = bArr;
            final boolean z2 = z;
            a(new com.tencent.mm.ci.a.a<c>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(1017);
                    ((c) obj).b(adVar3, adVar4, bbv2, bArr2, z2);
                    AppMethodBeat.o(1017);
                }
            });
            AppMethodBeat.o(1019);
        }
    }

    static {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_SHAKA_ADD_4);
        AppMethodBeat.o(FilterEnum4Shaka.MIC_SHAKA_ADD_4);
    }

    public static b a(c cVar) {
        AppMethodBeat.i(1020);
        b aD = opU.aD(cVar);
        AppMethodBeat.o(1020);
        return aD;
    }

    public final void a(tb tbVar, byte[] bArr, boolean z, t tVar) {
        AppMethodBeat.i(TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER);
        switch (tbVar.wat) {
            case 2:
            case 17:
                bbv bbv = (bbv) new bbv().parseFrom(bArr);
                String str = "";
                if (!z) {
                    bArr = null;
                }
                a(bbv, str, bArr, false, z);
                AppMethodBeat.o(TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER);
                return;
            case 4:
                vl vlVar = (vl) new vl().parseFrom(bArr);
                String a = aa.a(vlVar.wcB);
                ab.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", a);
                ((j) g.K(j.class)).XR().aoX(a);
                com.tencent.mm.model.t.nb(a);
                u.b(4, vlVar);
                break;
        }
        AppMethodBeat.o(TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER);
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
    public static void a(bbv bbv, String str, byte[] bArr, boolean z, boolean z2) {
        AppMethodBeat.i(1022);
        if (bbv == null) {
            ab.f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
            AppMethodBeat.o(1022);
            return;
        }
        String a = aa.a(bbv.wcB);
        String nullAsNil = bo.nullAsNil(bbv.wGl);
        if (bo.isNullOrNil(a) && bo.isNullOrNil(nullAsNil)) {
            ab.e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", a, nullAsNil);
            AppMethodBeat.o(1022);
            return;
        }
        ab.i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s", bbv.wcB, bbv.wGo, bbv.wGp);
        com.tencent.mm.n.a aoO = ((j) g.K(j.class)).XM().aoO(a);
        if (aoO == null || !a.equals(aoO.field_encryptUsername)) {
            com.tencent.mm.n.a dsl;
            String str2;
            String str3;
            Object[] objArr;
            int i;
            String str4;
            ad adVar = null;
            if (aoO != null) {
                dsl = aoO.dsl();
                if (dsl != null) {
                    adVar = aoO;
                    if (adVar == null) {
                        adVar = new ad(a);
                    }
                    adVar.setUsername(a);
                    adVar.iy(bbv.guS);
                    adVar.setType(bbv.wbu & bbv.wbv);
                    if (z && dsl != null && ((int) dsl.ewQ) > 0) {
                        ab.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", a, Integer.valueOf(dsl.field_type), Integer.valueOf(adVar.field_type));
                        adVar.setType(adVar.field_type | dsl.field_type);
                    }
                    if (bo.isNullOrNil(nullAsNil)) {
                        adVar.iH(nullAsNil);
                    } else if (dsl != null && ((int) dsl.ewQ) > 0) {
                        adVar.iH(dsl.field_encryptUsername);
                    }
                    adVar.ewQ = dsl != null ? 0 : (long) ((int) dsl.ewQ);
                    adVar.iB(aa.a(bbv.wyX));
                    adVar.iC(aa.a(bbv.wce));
                    adVar.iD(aa.a(bbv.wcf));
                    adVar.hA(bbv.guN);
                    adVar.hD(bbv.wbA);
                    adVar.iA(aa.a(bbv.wGf));
                    adVar.hE(bbv.wbE);
                    adVar.hF(bbv.guR);
                    adVar.iW(RegionCodeDecoder.aC(bbv.guW, bbv.guO, bbv.guP));
                    adVar.iQ(bbv.guQ);
                    adVar.hw(bbv.wBT);
                    adVar.iV(bbv.wBU);
                    adVar.setSource(bbv.vFH);
                    adVar.hv(bbv.wBX);
                    adVar.iE(bbv.wBW);
                    if (com.tencent.mm.model.t.nO(bbv.wBV)) {
                        adVar.iU(bbv.wBV);
                    }
                    if (adVar.dsi()) {
                        adVar.hH((int) bo.anT());
                    }
                    if (!TextUtils.isEmpty(str)) {
                        adVar.je(str);
                    }
                    adVar.iz(aa.a(bbv.wFK));
                    adVar.iF(aa.a(bbv.wFM));
                    adVar.iG(aa.a(bbv.wFL));
                    adVar.iI(bbv.wcD);
                    adVar.iX(bbv.vEA);
                    adVar.iY(bbv.wGv);
                    if (bo.cb(bArr)) {
                        ((j) g.K(j.class)).XM().F(a, bArr);
                    } else {
                        ((j) g.K(j.class)).XM().aoT(a);
                        ab.e("MicroMsg.ContactSyncExtension", "[processModContact] cmdBuf is null! user:%s", a);
                    }
                    adVar.hy(bbv.wGu);
                    if (!(bbv.wGq == null || bbv.wGq.vEU == null)) {
                        adVar.iZ(bbv.wGq.vEU.vLl);
                        adVar.ja(bbv.wGq.vEU.vLm);
                        adVar.jb(bbv.wGq.vEU.vLn);
                    }
                    if (com.tencent.mm.model.t.nI(a)) {
                        adVar.NK();
                    }
                    if (adVar.dsf()) {
                        adVar.NN();
                    }
                    adVar.jc(bbv.duq);
                    adVar.hJ(bbv.wGz);
                    str2 = "MicroMsg.ContactSyncExtension";
                    str3 = "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)";
                    objArr = new Object[20];
                    objArr[0] = a;
                    objArr[1] = nullAsNil;
                    objArr[2] = Integer.valueOf((int) adVar.ewQ);
                    objArr[3] = adVar.field_nickname;
                    objArr[4] = adVar.Hu();
                    objArr[5] = Integer.valueOf(adVar.field_deleteFlag);
                    objArr[6] = Integer.valueOf(adVar.field_type);
                    objArr[7] = Integer.valueOf(bbv.wbu);
                    objArr[8] = Integer.valueOf(bbv.wbv);
                    objArr[9] = Integer.valueOf(adVar.dtX);
                    objArr[10] = Integer.valueOf(adVar.dua);
                    objArr[11] = bbv.guW;
                    objArr[12] = bbv.guO;
                    objArr[13] = bbv.guP;
                    objArr[14] = Integer.valueOf(adVar.getSource());
                    objArr[15] = adVar.field_contactLabelIds;
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
                        str4 = bo.anv(bbv.vEA);
                    }
                    objArr[19] = str4;
                    ab.i(str2, str3, objArr);
                    opU.a(adVar, dsl, bbv, bArr, z2);
                    if (bo.isNullOrNil(nullAsNil)) {
                        ((j) g.K(j.class)).XM().c(nullAsNil, adVar);
                    } else {
                        ((j) g.K(j.class)).XM().Y(adVar);
                    }
                    opU.b(adVar, dsl, bbv, bArr, z2);
                    if ((adVar.field_type & 2048) == 0) {
                        if (dsl == null || (dsl.field_type & 2048) != (adVar.field_type & 2048)) {
                            ((j) g.K(j.class)).XR().apf(adVar.field_username);
                        }
                    } else if (dsl == null || (dsl.field_type & 2048) != (adVar.field_type & 2048)) {
                        ((j) g.K(j.class)).XR().apg(adVar.field_username);
                    }
                    ab.i("MicroMsg.ContactSyncExtension", "operationModSnsBlackContact username:%s isSnsBlackContact:%s", a, Boolean.valueOf(adVar.Od()));
                    AppMethodBeat.o(1022);
                    return;
                }
            }
            dsl = aoO;
            if (adVar == null) {
            }
            adVar.setUsername(a);
            adVar.iy(bbv.guS);
            adVar.setType(bbv.wbu & bbv.wbv);
            ab.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", a, Integer.valueOf(dsl.field_type), Integer.valueOf(adVar.field_type));
            adVar.setType(adVar.field_type | dsl.field_type);
            if (bo.isNullOrNil(nullAsNil)) {
            }
            if (dsl != null) {
            }
            adVar.ewQ = dsl != null ? 0 : (long) ((int) dsl.ewQ);
            adVar.iB(aa.a(bbv.wyX));
            adVar.iC(aa.a(bbv.wce));
            adVar.iD(aa.a(bbv.wcf));
            adVar.hA(bbv.guN);
            adVar.hD(bbv.wbA);
            adVar.iA(aa.a(bbv.wGf));
            adVar.hE(bbv.wbE);
            adVar.hF(bbv.guR);
            adVar.iW(RegionCodeDecoder.aC(bbv.guW, bbv.guO, bbv.guP));
            adVar.iQ(bbv.guQ);
            adVar.hw(bbv.wBT);
            adVar.iV(bbv.wBU);
            adVar.setSource(bbv.vFH);
            adVar.hv(bbv.wBX);
            adVar.iE(bbv.wBW);
            if (com.tencent.mm.model.t.nO(bbv.wBV)) {
            }
            if (adVar.dsi()) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            adVar.iz(aa.a(bbv.wFK));
            adVar.iF(aa.a(bbv.wFM));
            adVar.iG(aa.a(bbv.wFL));
            adVar.iI(bbv.wcD);
            adVar.iX(bbv.vEA);
            adVar.iY(bbv.wGv);
            if (bo.cb(bArr)) {
            }
            adVar.hy(bbv.wGu);
            adVar.iZ(bbv.wGq.vEU.vLl);
            adVar.ja(bbv.wGq.vEU.vLm);
            adVar.jb(bbv.wGq.vEU.vLn);
            if (com.tencent.mm.model.t.nI(a)) {
            }
            if (adVar.dsf()) {
            }
            adVar.jc(bbv.duq);
            adVar.hJ(bbv.wGz);
            str2 = "MicroMsg.ContactSyncExtension";
            str3 = "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)";
            objArr = new Object[20];
            objArr[0] = a;
            objArr[1] = nullAsNil;
            objArr[2] = Integer.valueOf((int) adVar.ewQ);
            objArr[3] = adVar.field_nickname;
            objArr[4] = adVar.Hu();
            objArr[5] = Integer.valueOf(adVar.field_deleteFlag);
            objArr[6] = Integer.valueOf(adVar.field_type);
            objArr[7] = Integer.valueOf(bbv.wbu);
            objArr[8] = Integer.valueOf(bbv.wbv);
            objArr[9] = Integer.valueOf(adVar.dtX);
            objArr[10] = Integer.valueOf(adVar.dua);
            objArr[11] = bbv.guW;
            objArr[12] = bbv.guO;
            objArr[13] = bbv.guP;
            objArr[14] = Integer.valueOf(adVar.getSource());
            objArr[15] = adVar.field_contactLabelIds;
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
            ab.i(str2, str3, objArr);
            opU.a(adVar, dsl, bbv, bArr, z2);
            if (bo.isNullOrNil(nullAsNil)) {
            }
            opU.b(adVar, dsl, bbv, bArr, z2);
            if ((adVar.field_type & 2048) == 0) {
            }
            ab.i("MicroMsg.ContactSyncExtension", "operationModSnsBlackContact username:%s isSnsBlackContact:%s", a, Boolean.valueOf(adVar.Od()));
            AppMethodBeat.o(1022);
            return;
        }
        ab.w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", a);
        AppMethodBeat.o(1022);
    }
}
