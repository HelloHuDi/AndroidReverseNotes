package com.tencent.p177mm.pluginsdk.p597ui.preference;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p230g.p231a.C9349ga;
import com.tencent.p177mm.p230g.p711c.C6571cp;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2206au;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42464aa;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C41338bt;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7570bf;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.pluginsdk.ui.preference.b */
public final class C14957b {
    public boolean cRY;
    public String fjz;
    public String gta;
    /* renamed from: id */
    public long f2975id;
    public String nickname;
    public int qvb;
    public String username;
    public String vqC;

    /* renamed from: b */
    public static C14957b m23244b(Context context, C7569ax c7569ax) {
        AppMethodBeat.m2504i(28053);
        C14957b a = C14957b.m23235a(context, c7569ax.xDa, c7569ax.dtf(), c7569ax.field_talker, c7569ax.field_msgContent, c7569ax.field_type);
        AppMethodBeat.m2505o(28053);
        return a;
    }

    /* renamed from: a */
    private static C14957b m23235a(Context context, long j, boolean z, String str, String str2, int i) {
        AppMethodBeat.m2504i(28054);
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i2 = 0;
        if (i == 0) {
            C5135a apC = C5135a.apC(str2);
            str3 = apC.svN;
            str4 = apC.nickname;
            str5 = apC.xZi;
            str6 = apC.xZj;
            i2 = apC.scene;
        } else if (z) {
            C5138d apF = C5138d.apF(str2);
            str3 = apF.svN;
            str4 = apF.nickname;
            str7 = apF.content;
            if (apF.xZy == 1) {
                str8 = apF.xZA;
            }
        }
        C14957b a = C14957b.m23236a(context, j, z, str, str2, i, str3, str4, str5, str6, str7, i2);
        a.vqC = str8;
        AppMethodBeat.m2505o(28054);
        return a;
    }

    /* renamed from: a */
    public static C14957b m23236a(Context context, long j, boolean z, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, int i2) {
        AppMethodBeat.m2504i(28055);
        C14957b c14957b = new C14957b();
        c14957b.f2975id = j;
        c14957b.cRY = !z;
        C4990ab.m7411d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", Integer.valueOf(i), str, Integer.valueOf(i2));
        if (i == 0) {
            if (str2 != null) {
                c14957b.username = str3;
                c14957b.nickname = str4;
                switch (i2) {
                    case 4:
                        c14957b.fjz = context.getString(C25738R.string.akl);
                        break;
                    case 10:
                    case 11:
                        C9349ga c9349ga = new C9349ga();
                        c9349ga.cAj.cAg = str5;
                        c9349ga.cAj.cAh = str6;
                        C4879a.xxA.mo10055m(c9349ga);
                        c14957b.fjz = context.getString(C25738R.string.akq, new Object[]{C5046bo.m7532bc(c9349ga.cAk.cAl, "")});
                        break;
                    case 31:
                        c14957b.fjz = context.getString(C25738R.string.al1);
                        break;
                    case 32:
                        c14957b.fjz = context.getString(C25738R.string.akv);
                        break;
                    case C42464aa.CTRL_INDEX /*58*/:
                    case C2206au.CTRL_INDEX /*59*/:
                    case 60:
                        c14957b.gta = C5135a.apC(str2).gta;
                        c14957b.fjz = context.getString(C25738R.string.ako);
                        break;
                    default:
                        c14957b.fjz = context.getString(C25738R.string.aku);
                        break;
                }
            }
            C4990ab.m7412e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(28055);
            return null;
        } else if (z) {
            c14957b.username = str3;
            c14957b.nickname = str4;
            if (str7 == null || str7.trim().equals("")) {
                c14957b.fjz = context.getString(C25738R.string.d9s);
            } else {
                c14957b.fjz = str7;
            }
        } else {
            c14957b.username = str;
            c14957b.fjz = str2;
        }
        AppMethodBeat.m2505o(28055);
        return c14957b;
    }

    /* renamed from: a */
    public static C14957b m23237a(Context context, C6571cp c6571cp) {
        AppMethodBeat.m2504i(28056);
        C4990ab.m7410d("MicroMsg.FMessageProvider", "build lbs, talker = " + c6571cp.field_sayhiuser + ", scene = " + c6571cp.field_scene);
        C14957b c14957b = new C14957b();
        c14957b.f2975id = c6571cp.xDa;
        c14957b.cRY = c6571cp.field_isSend == 1;
        c14957b.username = c6571cp.field_sayhiuser;
        c14957b.qvb = c6571cp.field_scene;
        if (c6571cp.field_isSend == 1) {
            c14957b.fjz = c6571cp.field_content;
        } else {
            C5138d apF = C5138d.apF(c6571cp.field_content);
            if (apF.content == null || apF.content.trim().equals("")) {
                c14957b.fjz = context.getString(C25738R.string.al3);
            } else {
                c14957b.fjz = apF.content;
            }
            c14957b.nickname = apF.nickname;
        }
        AppMethodBeat.m2505o(28056);
        return c14957b;
    }

    /* renamed from: a */
    public static C14957b m23238a(Context context, C41338bt c41338bt) {
        AppMethodBeat.m2504i(28057);
        C4990ab.m7410d("MicroMsg.FMessageProvider", "build shake, talker = " + c41338bt.field_talker + ", scene = " + c41338bt.field_scene);
        C14957b c14957b = new C14957b();
        c14957b.f2975id = c41338bt.xDa;
        c14957b.cRY = c41338bt.field_isSend == 1;
        c14957b.username = c41338bt.field_sayhiuser;
        c14957b.qvb = c41338bt.field_scene;
        if (c41338bt.field_isSend == 1) {
            c14957b.fjz = c41338bt.field_content;
        } else {
            C5138d apF = C5138d.apF(c41338bt.field_content);
            if (apF.content == null || apF.content.trim().equals("")) {
                c14957b.fjz = context.getString(C25738R.string.al3);
            } else {
                c14957b.fjz = apF.content;
            }
            c14957b.nickname = apF.nickname;
        }
        AppMethodBeat.m2505o(28057);
        return c14957b;
    }

    /* renamed from: a */
    public static C14957b[] m23242a(Context context, C7569ax[] c7569axArr) {
        AppMethodBeat.m2504i(28058);
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert fmsgList, talker = ");
        String str2 = (c7569axArr == null || c7569axArr.length == 0 || c7569axArr[0] == null) ? BuildConfig.COMMAND : c7569axArr[0].field_talker;
        C4990ab.m7410d(str, stringBuilder.append(str2).toString());
        if (c7569axArr == null || c7569axArr.length == 0) {
            C4990ab.m7412e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
            AppMethodBeat.m2505o(28058);
            return null;
        }
        C14957b[] c14957bArr = new C14957b[c7569axArr.length];
        for (int i = 0; i < c14957bArr.length; i++) {
            c14957bArr[(c14957bArr.length - i) - 1] = C14957b.m23244b(context, c7569axArr[i]);
        }
        AppMethodBeat.m2505o(28058);
        return c14957bArr;
    }

    /* renamed from: a */
    public static C14957b[] m23241a(Context context, C6571cp[] c6571cpArr) {
        AppMethodBeat.m2504i(28059);
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert lbsList, talker = ");
        String str2 = (c6571cpArr == null || c6571cpArr.length == 0 || c6571cpArr[0] == null) ? BuildConfig.COMMAND : c6571cpArr[0].field_sayhiuser;
        C4990ab.m7410d(str, stringBuilder.append(str2).toString());
        if (c6571cpArr == null || c6571cpArr.length == 0) {
            C4990ab.m7412e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
            AppMethodBeat.m2505o(28059);
            return null;
        }
        C14957b[] c14957bArr = new C14957b[c6571cpArr.length];
        for (int i = 0; i < c14957bArr.length; i++) {
            c14957bArr[(c14957bArr.length - i) - 1] = C14957b.m23237a(context, c6571cpArr[i]);
        }
        AppMethodBeat.m2505o(28059);
        return c14957bArr;
    }

    /* renamed from: a */
    public static C14957b[] m23243a(Context context, C41338bt[] c41338btArr) {
        AppMethodBeat.m2504i(28060);
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert shakeList, talker = ");
        String str2 = (c41338btArr == null || c41338btArr.length == 0 || c41338btArr[0] == null) ? BuildConfig.COMMAND : c41338btArr[0].field_sayhiuser;
        C4990ab.m7410d(str, stringBuilder.append(str2).toString());
        if (c41338btArr == null || c41338btArr.length == 0) {
            C4990ab.m7412e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
            AppMethodBeat.m2505o(28060);
            return null;
        }
        C14957b[] c14957bArr = new C14957b[c41338btArr.length];
        for (int i = 0; i < c14957bArr.length; i++) {
            c14957bArr[(c14957bArr.length - i) - 1] = C14957b.m23238a(context, c41338btArr[i]);
        }
        AppMethodBeat.m2505o(28060);
        return c14957bArr;
    }

    /* renamed from: a */
    public static String m23240a(Context context, int i, int i2, String str, boolean z) {
        AppMethodBeat.m2504i(28061);
        C4990ab.m7411d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
        if (i == 0) {
            if (str != null) {
                C5135a apC = C5135a.apC(str);
                switch (apC.scene) {
                    case 4:
                        str = context.getString(C25738R.string.akl);
                        break;
                    case 10:
                    case 11:
                        C9349ga c9349ga = new C9349ga();
                        c9349ga.cAj.cAg = apC.xZi;
                        c9349ga.cAj.cAh = apC.xZj;
                        C4879a.xxA.mo10055m(c9349ga);
                        str = context.getString(C25738R.string.akq, new Object[]{C5046bo.m7532bc(c9349ga.cAk.cAl, "")});
                        break;
                    case 31:
                        str = context.getString(C25738R.string.al1);
                        break;
                    case 32:
                        str = context.getString(C25738R.string.akv);
                        break;
                    case C42464aa.CTRL_INDEX /*58*/:
                    case C2206au.CTRL_INDEX /*59*/:
                    case 60:
                        str = context.getString(C25738R.string.ako);
                        break;
                    default:
                        str = context.getString(C25738R.string.aku);
                        break;
                }
            }
            C4990ab.m7412e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
            AppMethodBeat.m2505o(28061);
            return null;
        } else if (!z) {
            C5138d apF = C5138d.apF(str);
            if (apF.content == null || apF.content.trim().equals("")) {
                str = context.getString(C25738R.string.bw7);
            } else {
                str = apF.content;
            }
        }
        AppMethodBeat.m2505o(28061);
        return str;
    }

    /* renamed from: bG */
    public static void m23245bG(String str, int i) {
        C14957b[] a;
        C41338bt[] c41338btArr;
        C7569ax[] c7569axArr;
        AppMethodBeat.m2504i(28062);
        C7570bf[] c7570bfArr = null;
        if (i == 26 || i == 27 || i == 28 || i == 29) {
            C4990ab.m7410d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
            C41338bt[] apY = C41789d.akR().apY(str);
            a = C14957b.m23243a(C4996ah.getContext(), apY);
            c41338btArr = apY;
            c7569axArr = null;
        } else if (i == 18) {
            C4990ab.m7410d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
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
            AppMethodBeat.m2505o(28062);
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
            C4990ab.m7416i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(Z)));
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
        C4990ab.m7416i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(C18628c.m29080XO().mo15281Z(c7620bi2))));
        AppMethodBeat.m2505o(28062);
    }

    /* renamed from: a */
    public static C7616ad m23239a(C7569ax c7569ax) {
        AppMethodBeat.m2504i(28063);
        C7616ad c7616ad = new C7616ad();
        if (c7569ax == null) {
            AppMethodBeat.m2505o(28063);
            return c7616ad;
        } else if (c7569ax.field_type == 0) {
            c7616ad = C14957b.ajM(c7569ax.field_msgContent);
            AppMethodBeat.m2505o(28063);
            return c7616ad;
        } else {
            c7616ad = C14957b.ajN(c7569ax.field_msgContent);
            AppMethodBeat.m2505o(28063);
            return c7616ad;
        }
    }

    private static C7616ad ajM(String str) {
        AppMethodBeat.m2504i(28064);
        C5135a apC = C5135a.apC(str);
        C7616ad c7616ad = new C7616ad();
        c7616ad.setUsername(apC.svN);
        c7616ad.mo14728iy(apC.dFl);
        c7616ad.mo14703iB(apC.getDisplayName());
        c7616ad.mo14704iC(apC.gwF);
        c7616ad.mo14705iD(apC.gwG);
        c7616ad.mo14685hA(apC.dtS);
        c7616ad.mo14719iR(apC.getProvince());
        c7616ad.mo14720iS(apC.getCity());
        c7616ad.mo14718iQ(apC.signature);
        c7616ad.mo14698hw(apC.ufB);
        c7616ad.mo14723iV(apC.duh);
        c7616ad.mo14734je(apC.vqs);
        AppMethodBeat.m2505o(28064);
        return c7616ad;
    }

    private static C7616ad ajN(String str) {
        AppMethodBeat.m2504i(28065);
        C5138d apF = C5138d.apF(str);
        C7616ad c7616ad = new C7616ad();
        c7616ad.setUsername(apF.svN);
        c7616ad.mo14728iy(apF.dFl);
        c7616ad.mo14703iB(apF.nickname);
        c7616ad.mo14704iC(apF.gwF);
        c7616ad.mo14705iD(apF.gwG);
        c7616ad.mo14685hA(apF.dtS);
        c7616ad.mo14718iQ(apF.signature);
        c7616ad.mo14719iR(apF.getProvince());
        c7616ad.mo14720iS(apF.getCity());
        AppMethodBeat.m2505o(28065);
        return c7616ad;
    }
}
