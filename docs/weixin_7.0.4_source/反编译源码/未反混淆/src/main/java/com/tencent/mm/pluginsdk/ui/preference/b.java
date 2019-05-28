package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.g.c.cp;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bt;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import junit.framework.Assert;

public final class b {
    public boolean cRY;
    public String fjz;
    public String gta;
    public long id;
    public String nickname;
    public int qvb;
    public String username;
    public String vqC;

    public static b b(Context context, ax axVar) {
        AppMethodBeat.i(28053);
        b a = a(context, axVar.xDa, axVar.dtf(), axVar.field_talker, axVar.field_msgContent, axVar.field_type);
        AppMethodBeat.o(28053);
        return a;
    }

    private static b a(Context context, long j, boolean z, String str, String str2, int i) {
        AppMethodBeat.i(28054);
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i2 = 0;
        if (i == 0) {
            a apC = a.apC(str2);
            str3 = apC.svN;
            str4 = apC.nickname;
            str5 = apC.xZi;
            str6 = apC.xZj;
            i2 = apC.scene;
        } else if (z) {
            d apF = d.apF(str2);
            str3 = apF.svN;
            str4 = apF.nickname;
            str7 = apF.content;
            if (apF.xZy == 1) {
                str8 = apF.xZA;
            }
        }
        b a = a(context, j, z, str, str2, i, str3, str4, str5, str6, str7, i2);
        a.vqC = str8;
        AppMethodBeat.o(28054);
        return a;
    }

    public static b a(Context context, long j, boolean z, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, int i2) {
        AppMethodBeat.i(28055);
        b bVar = new b();
        bVar.id = j;
        bVar.cRY = !z;
        ab.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", Integer.valueOf(i), str, Integer.valueOf(i2));
        if (i == 0) {
            if (str2 != null) {
                bVar.username = str3;
                bVar.nickname = str4;
                switch (i2) {
                    case 4:
                        bVar.fjz = context.getString(R.string.akl);
                        break;
                    case 10:
                    case 11:
                        ga gaVar = new ga();
                        gaVar.cAj.cAg = str5;
                        gaVar.cAj.cAh = str6;
                        com.tencent.mm.sdk.b.a.xxA.m(gaVar);
                        bVar.fjz = context.getString(R.string.akq, new Object[]{bo.bc(gaVar.cAk.cAl, "")});
                        break;
                    case 31:
                        bVar.fjz = context.getString(R.string.al1);
                        break;
                    case 32:
                        bVar.fjz = context.getString(R.string.akv);
                        break;
                    case aa.CTRL_INDEX /*58*/:
                    case au.CTRL_INDEX /*59*/:
                    case 60:
                        bVar.gta = a.apC(str2).gta;
                        bVar.fjz = context.getString(R.string.ako);
                        break;
                    default:
                        bVar.fjz = context.getString(R.string.aku);
                        break;
                }
            }
            ab.e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = ".concat(String.valueOf(str)));
            AppMethodBeat.o(28055);
            return null;
        } else if (z) {
            bVar.username = str3;
            bVar.nickname = str4;
            if (str7 == null || str7.trim().equals("")) {
                bVar.fjz = context.getString(R.string.d9s);
            } else {
                bVar.fjz = str7;
            }
        } else {
            bVar.username = str;
            bVar.fjz = str2;
        }
        AppMethodBeat.o(28055);
        return bVar;
    }

    public static b a(Context context, cp cpVar) {
        AppMethodBeat.i(28056);
        ab.d("MicroMsg.FMessageProvider", "build lbs, talker = " + cpVar.field_sayhiuser + ", scene = " + cpVar.field_scene);
        b bVar = new b();
        bVar.id = cpVar.xDa;
        bVar.cRY = cpVar.field_isSend == 1;
        bVar.username = cpVar.field_sayhiuser;
        bVar.qvb = cpVar.field_scene;
        if (cpVar.field_isSend == 1) {
            bVar.fjz = cpVar.field_content;
        } else {
            d apF = d.apF(cpVar.field_content);
            if (apF.content == null || apF.content.trim().equals("")) {
                bVar.fjz = context.getString(R.string.al3);
            } else {
                bVar.fjz = apF.content;
            }
            bVar.nickname = apF.nickname;
        }
        AppMethodBeat.o(28056);
        return bVar;
    }

    public static b a(Context context, bt btVar) {
        AppMethodBeat.i(28057);
        ab.d("MicroMsg.FMessageProvider", "build shake, talker = " + btVar.field_talker + ", scene = " + btVar.field_scene);
        b bVar = new b();
        bVar.id = btVar.xDa;
        bVar.cRY = btVar.field_isSend == 1;
        bVar.username = btVar.field_sayhiuser;
        bVar.qvb = btVar.field_scene;
        if (btVar.field_isSend == 1) {
            bVar.fjz = btVar.field_content;
        } else {
            d apF = d.apF(btVar.field_content);
            if (apF.content == null || apF.content.trim().equals("")) {
                bVar.fjz = context.getString(R.string.al3);
            } else {
                bVar.fjz = apF.content;
            }
            bVar.nickname = apF.nickname;
        }
        AppMethodBeat.o(28057);
        return bVar;
    }

    public static b[] a(Context context, ax[] axVarArr) {
        AppMethodBeat.i(28058);
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert fmsgList, talker = ");
        String str2 = (axVarArr == null || axVarArr.length == 0 || axVarArr[0] == null) ? BuildConfig.COMMAND : axVarArr[0].field_talker;
        ab.d(str, stringBuilder.append(str2).toString());
        if (axVarArr == null || axVarArr.length == 0) {
            ab.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
            AppMethodBeat.o(28058);
            return null;
        }
        b[] bVarArr = new b[axVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[(bVarArr.length - i) - 1] = b(context, axVarArr[i]);
        }
        AppMethodBeat.o(28058);
        return bVarArr;
    }

    public static b[] a(Context context, cp[] cpVarArr) {
        AppMethodBeat.i(28059);
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert lbsList, talker = ");
        String str2 = (cpVarArr == null || cpVarArr.length == 0 || cpVarArr[0] == null) ? BuildConfig.COMMAND : cpVarArr[0].field_sayhiuser;
        ab.d(str, stringBuilder.append(str2).toString());
        if (cpVarArr == null || cpVarArr.length == 0) {
            ab.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
            AppMethodBeat.o(28059);
            return null;
        }
        b[] bVarArr = new b[cpVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[(bVarArr.length - i) - 1] = a(context, cpVarArr[i]);
        }
        AppMethodBeat.o(28059);
        return bVarArr;
    }

    public static b[] a(Context context, bt[] btVarArr) {
        AppMethodBeat.i(28060);
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert shakeList, talker = ");
        String str2 = (btVarArr == null || btVarArr.length == 0 || btVarArr[0] == null) ? BuildConfig.COMMAND : btVarArr[0].field_sayhiuser;
        ab.d(str, stringBuilder.append(str2).toString());
        if (btVarArr == null || btVarArr.length == 0) {
            ab.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
            AppMethodBeat.o(28060);
            return null;
        }
        b[] bVarArr = new b[btVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[(bVarArr.length - i) - 1] = a(context, btVarArr[i]);
        }
        AppMethodBeat.o(28060);
        return bVarArr;
    }

    public static String a(Context context, int i, int i2, String str, boolean z) {
        AppMethodBeat.i(28061);
        ab.d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
        if (i == 0) {
            if (str != null) {
                a apC = a.apC(str);
                switch (apC.scene) {
                    case 4:
                        str = context.getString(R.string.akl);
                        break;
                    case 10:
                    case 11:
                        ga gaVar = new ga();
                        gaVar.cAj.cAg = apC.xZi;
                        gaVar.cAj.cAh = apC.xZj;
                        com.tencent.mm.sdk.b.a.xxA.m(gaVar);
                        str = context.getString(R.string.akq, new Object[]{bo.bc(gaVar.cAk.cAl, "")});
                        break;
                    case 31:
                        str = context.getString(R.string.al1);
                        break;
                    case 32:
                        str = context.getString(R.string.akv);
                        break;
                    case aa.CTRL_INDEX /*58*/:
                    case au.CTRL_INDEX /*59*/:
                    case 60:
                        str = context.getString(R.string.ako);
                        break;
                    default:
                        str = context.getString(R.string.aku);
                        break;
                }
            }
            ab.e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
            AppMethodBeat.o(28061);
            return null;
        } else if (!z) {
            d apF = d.apF(str);
            if (apF.content == null || apF.content.trim().equals("")) {
                str = context.getString(R.string.bw7);
            } else {
                str = apF.content;
            }
        }
        AppMethodBeat.o(28061);
        return str;
    }

    public static void bG(String str, int i) {
        b[] a;
        bt[] btVarArr;
        ax[] axVarArr;
        AppMethodBeat.i(28062);
        bf[] bfVarArr = null;
        if (i == 26 || i == 27 || i == 28 || i == 29) {
            ab.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
            bt[] apY = com.tencent.mm.bi.d.akR().apY(str);
            a = a(ah.getContext(), apY);
            btVarArr = apY;
            axVarArr = null;
        } else if (i == 18) {
            ab.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
            cp[] bfVarArr2 = com.tencent.mm.bi.d.akQ().apz(str);
            a = a(ah.getContext(), bfVarArr2);
            btVarArr = null;
            axVarArr = null;
        } else {
            ax[] apv = com.tencent.mm.bi.d.akO().apv(str);
            a = a(ah.getContext(), apv);
            btVarArr = null;
            axVarArr = apv;
        }
        if (a == null) {
            AppMethodBeat.o(28062);
            return;
        }
        int i2 = 0;
        int length = a.length;
        int i3 = 0;
        while (i3 < length) {
            int i4;
            b bVar = a[i3];
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
            long Z = c.XO().Z(biVar);
            Assert.assertTrue(Z != -1);
            ab.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(Z)));
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
        ab.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(c.XO().Z(biVar2))));
        AppMethodBeat.o(28062);
    }

    public static ad a(ax axVar) {
        AppMethodBeat.i(28063);
        ad adVar = new ad();
        if (axVar == null) {
            AppMethodBeat.o(28063);
            return adVar;
        } else if (axVar.field_type == 0) {
            adVar = ajM(axVar.field_msgContent);
            AppMethodBeat.o(28063);
            return adVar;
        } else {
            adVar = ajN(axVar.field_msgContent);
            AppMethodBeat.o(28063);
            return adVar;
        }
    }

    private static ad ajM(String str) {
        AppMethodBeat.i(28064);
        a apC = a.apC(str);
        ad adVar = new ad();
        adVar.setUsername(apC.svN);
        adVar.iy(apC.dFl);
        adVar.iB(apC.getDisplayName());
        adVar.iC(apC.gwF);
        adVar.iD(apC.gwG);
        adVar.hA(apC.dtS);
        adVar.iR(apC.getProvince());
        adVar.iS(apC.getCity());
        adVar.iQ(apC.signature);
        adVar.hw(apC.ufB);
        adVar.iV(apC.duh);
        adVar.je(apC.vqs);
        AppMethodBeat.o(28064);
        return adVar;
    }

    private static ad ajN(String str) {
        AppMethodBeat.i(28065);
        d apF = d.apF(str);
        ad adVar = new ad();
        adVar.setUsername(apF.svN);
        adVar.iy(apF.dFl);
        adVar.iB(apF.nickname);
        adVar.iC(apF.gwF);
        adVar.iD(apF.gwG);
        adVar.hA(apF.dtS);
        adVar.iQ(apF.signature);
        adVar.iR(apF.getProvince());
        adVar.iS(apF.getCity());
        AppMethodBeat.o(28065);
        return adVar;
    }
}
