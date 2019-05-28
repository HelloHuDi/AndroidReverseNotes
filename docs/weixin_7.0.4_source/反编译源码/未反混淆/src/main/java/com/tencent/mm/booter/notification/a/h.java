package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.b;
import com.tencent.mm.compatible.util.o;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.wav.WavFileHeader;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import junit.framework.Assert;
import org.xwalk.core.XWalkEnvironment;

public final class h {
    private static WeakReference<TextPaint> eeQ;
    private static int eeR = 0;
    private static int eeS = 0;
    public String eeO = "";
    public String eeP = "";
    public String mTitle = "";

    public static String a(Context context, String str, String str2, int i) {
        AppMethodBeat.i(16038);
        String ajP = j.ajP(b.dqD().anU(a(0, str2, str, i, context)));
        AppMethodBeat.o(16038);
        return ajP;
    }

    public static String g(Context context, String str, String str2) {
        String oy;
        AppMethodBeat.i(16039);
        if (t.kH(str)) {
            oy = bf.oy(str2);
            if (oy != null) {
                oy = s.mJ(oy.trim());
            } else {
                oy = s.mJ(str);
            }
        } else {
            oy = s.mJ(str);
        }
        if (str.contains("@bottle")) {
            oy = context.getResources().getQuantityString(R.plurals.v, 1, new Object[]{Integer.valueOf(1)});
            AppMethodBeat.o(16039);
            return oy;
        }
        if (bo.isNullOrNil(oy) && t.kH(str)) {
            oy = context.getString(R.string.ao1);
        }
        oy = b.dqD().anU(oy);
        AppMethodBeat.o(16039);
        return oy;
    }

    public static String b(ad adVar) {
        AppMethodBeat.i(16040);
        Context context = ah.getContext();
        String string;
        if (adVar == null) {
            string = context.getString(R.string.ab0);
            AppMethodBeat.o(16040);
            return string;
        } else if (RegionCodeDecoder.apQ(adVar.getCountryCode())) {
            string = adVar.getCity();
            if (bo.isNullOrNil(string)) {
                string = s.mL(adVar.getProvince());
                if (bo.isNullOrNil(string)) {
                    RegionCodeDecoder.duj();
                    string = RegionCodeDecoder.getLocName(adVar.getCountryCode());
                    AppMethodBeat.o(16040);
                    return string;
                }
                AppMethodBeat.o(16040);
                return string;
            }
            AppMethodBeat.o(16040);
            return string;
        } else {
            string = s.mL(adVar.getProvince());
            if (bo.isNullOrNil(string)) {
                string = context.getString(R.string.ab0);
                AppMethodBeat.o(16040);
                return string;
            }
            AppMethodBeat.o(16040);
            return string;
        }
    }

    public static String b(bi biVar, PString pString, PString pString2, PInt pInt, boolean z) {
        String dtW;
        AppMethodBeat.i(16041);
        if (biVar.dtv()) {
            dtW = biVar.dtW();
        } else {
            dtW = biVar.field_content;
        }
        dtW = bo.nullAsNil(a(biVar.field_imgPath, biVar.field_isSend, biVar.field_talker, j.ajP(dtW), biVar.getType(), ah.getContext(), pString, pString2, pInt, true, z));
        AppMethodBeat.o(16041);
        return dtW;
    }

    public static String a(int i, String str, String str2, int i2, Context context) {
        AppMethodBeat.i(16042);
        String nullAsNil = bo.nullAsNil(a(null, i, str, str2, i2, context, new PString(), new PString(), new PInt(), false, false));
        AppMethodBeat.o(16042);
        return nullAsNil;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0115 A:{FALL_THROUGH} */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x035a  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0a1d  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a91  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x03ce A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0463 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x04d5  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x059c  */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x0b40  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x03a6  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x124a  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x11ee  */
    /* JADX WARNING: Removed duplicated region for block: B:602:0x1212  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x05fc  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0876  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0654  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0696  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0725  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x08d9  */
    /* JADX WARNING: Removed duplicated region for block: B:604:0x125e  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x0980  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x07d2  */
    /* JADX WARNING: Removed duplicated region for block: B:611:0x1295  */
    /* JADX WARNING: Removed duplicated region for block: B:616:0x12b7  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x082d  */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x0adb  */
    /* JADX WARNING: Removed duplicated region for block: B:648:0x13e5  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0121  */
    /* JADX WARNING: Missing block: B:174:0x04ed, code skipped:
            if (android.text.TextUtils.isEmpty(r4) != false) goto L_0x04ef;
     */
    /* JADX WARNING: Missing block: B:699:0x1582, code skipped:
            r6 = null;
            r8 = null;
            r9 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String a(String str, int i, String str2, String str3, int i2, Context context, PString pString, PString pString2, PInt pInt, boolean z, boolean z2) {
        Object obj;
        AppMethodBeat.i(16043);
        Assert.assertTrue("context is null", context != null);
        String str4 = "username is null";
        boolean z3 = str2 != null && str2.length() > 0;
        Assert.assertTrue(str4, z3);
        if (!z) {
            if (!t.ne(str2) || r.YR()) {
                if (t.ng(str2)) {
                    if ((r.YD() & 64) != 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        obj = 1;
                    }
                }
                if (!t.nk(str2) || r.YU()) {
                    obj = null;
                } else {
                    obj = 1;
                }
            } else {
                obj = 1;
            }
            if (obj != null) {
                str = context.getString(R.string.e_7);
                AppMethodBeat.o(16043);
                return str;
            }
        }
        if (!t.nk(str2)) {
            Object obj2;
            String displayName;
            String str5;
            String substring;
            int indexOf;
            Object obj3;
            String str6;
            Object obj4;
            String str7;
            String str8;
            String str9 = "";
            String str10 = "";
            str4 = "";
            if (str3 == null || !z) {
                obj2 = null;
            } else {
                str3 = jV(str3);
                obj2 = 1;
            }
            pString.value = str3;
            if (i == 0 && (t.kH(str2) || t.mP(str2))) {
                int ox = bf.ox(str3);
                if (ox > 0) {
                    str4 = str3.substring(0, ox).trim();
                    displayName = s.getDisplayName(str4, str2);
                    str5 = str4;
                    substring = (str3 + " ").substring(ox + 1);
                    obj = null;
                    if (!t.ny(str2) || t.nH(str2)) {
                        indexOf = str3.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        if (indexOf != -1) {
                            pString2.value = str3.substring(0, indexOf);
                            str3 = str3.substring(indexOf + 1);
                        }
                        obj3 = null;
                        str6 = str3;
                    } else {
                        aw.ZK();
                        ak aoZ = c.XR().aoZ(str2);
                        if ((aoZ != null && aoZ.jl(2097152)) || z2) {
                            obj = 1;
                            if (str3 != null) {
                                indexOf = str3.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                                if (indexOf != -1) {
                                    pString2.value = str3.substring(0, indexOf);
                                    int obj32 = 1;
                                    str6 = str3.substring(indexOf + 1);
                                }
                            }
                        }
                        obj32 = obj;
                        str6 = str3;
                    }
                    com.tencent.mm.af.j.b me;
                    int ox2;
                    com.tencent.mm.af.j.b me2;
                    switch (i2) {
                        case -1879048191:
                        case -1879048190:
                        case -1879048189:
                            str = context.getString(R.string.ui);
                            str10 = null;
                            obj4 = null;
                            str7 = "";
                            break;
                        case -1879048188:
                            str = context.getString(R.string.ul);
                            str10 = null;
                            obj4 = null;
                            str7 = "";
                            break;
                        case -1879048186:
                            me = com.tencent.mm.af.j.b.me(bo.anj(substring));
                            if (me != null) {
                                str = "";
                                str8 = str5.length() > 0 ? str5 + ": " + me.title : me.title;
                                if (!t.ny(str2) && obj32 == null) {
                                    pString2.value = str5;
                                }
                                pString.value = str5.length() > 0 ? "%s: " + me.title : me.title;
                                str10 = null;
                                obj4 = null;
                                str7 = str8;
                                break;
                            }
                            ab.e("MicroMsg.Notification.Wording", "decode msg content failed");
                            str = "";
                            AppMethodBeat.o(16043);
                            return str;
                        case -1879048185:
                        case -1879048183:
                        case -1879048176:
                            str = context.getString(R.string.fy);
                            str8 = str5.length() > 0 ? str5 + ": " : "";
                            if (!t.ny(str2) && obj32 == null) {
                                pString2.value = str5;
                            }
                            pString.value = str5.length() > 0 ? "%s: " : "";
                            str10 = null;
                            obj4 = null;
                            str7 = str8;
                            break;
                        case 3:
                        case 23:
                        case 33:
                            str = context.getString(R.string.sn);
                            str8 = str5.length() > 0 ? str5 + ": " : "";
                            pString.value = str5.length() > 0 ? "%s: " : "";
                            str10 = null;
                            obj4 = null;
                            str7 = str8;
                            break;
                        case 11:
                        case 36:
                            str = str9;
                            str10 = null;
                            obj4 = null;
                            str7 = a(context, i, str2, str6, null, pString, pString2);
                            break;
                        case 13:
                        case 39:
                            str = str9;
                            str10 = null;
                            obj4 = null;
                            str7 = a(context, i, str2, str6, context.getString(R.string.sn), pString, pString2);
                            break;
                        case 34:
                            if (!ad.aou(str2) && !ad.aow(str2) && !t.ne(str2) && !t.ng(str2)) {
                                if (!(str6 == null || str6.length() <= 0 || t.nf(str2))) {
                                    if (t.kH(str2)) {
                                        n nVar = new n(str6);
                                        str6 = nVar.alt() + ": ";
                                        pString.value = "%s:";
                                        pString2.value = nVar.alt();
                                    } else {
                                        str6 = "";
                                    }
                                }
                                str = context.getString(R.string.ug);
                                str10 = null;
                                obj4 = null;
                                str7 = str6;
                                break;
                            }
                            str = str9;
                            str10 = null;
                            obj4 = null;
                            str7 = a(context, i, str2, str6, context.getString(R.string.ug), pString, pString2);
                            break;
                            break;
                        case 35:
                            if (bo.nullAsNil(str6).length() > 0) {
                                aw.ZK();
                                bi.c Rl = c.XO().Rl(str6);
                                str8 = context.getString(R.string.byc, new Object[]{Rl.fOt, Rl.title});
                                pString.value = str8;
                                str = str9;
                                str10 = null;
                                obj4 = null;
                                str7 = str8;
                                break;
                            }
                        case g.CTRL_INDEX /*37*/:
                            if (str6 != null && str6.length() > 0) {
                                d apF = d.apF(str6);
                                if (apF.dtY() != null && apF.dtY().length() > 0) {
                                    switch (apF.scene) {
                                        case 18:
                                            str = str9;
                                            str10 = null;
                                            obj4 = null;
                                            str7 = context.getString(R.string.byj, new Object[]{apF.getDisplayName()});
                                            break;
                                        case 22:
                                        case 23:
                                        case 24:
                                        case 26:
                                        case 27:
                                        case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                                        case 29:
                                            str = str9;
                                            str10 = null;
                                            obj4 = null;
                                            str7 = context.getString(R.string.byt, new Object[]{apF.getDisplayName()});
                                            break;
                                        case 25:
                                            str8 = context.getString(R.string.bwp, new Object[]{apF.getDisplayName()});
                                            pString.value = str8;
                                            str = str9;
                                            str10 = null;
                                            obj4 = null;
                                            str7 = str8;
                                            break;
                                        default:
                                            str6 = context.getString(R.string.bz2, new Object[]{apF.getDisplayName()});
                                            pString.value = str6;
                                            break;
                                    }
                                }
                                str = str9;
                                str10 = null;
                                obj4 = null;
                                str7 = str6;
                                break;
                            }
                        case 40:
                            if (str6 != null && str6.length() > 0) {
                                a apC = a.apC(str6);
                                if (apC.dtY() != null && apC.dtY().length() > 0) {
                                    str6 = context.getString(R.string.bxd, new Object[]{apC.getDisplayName()});
                                    pString.value = str6;
                                }
                                str = str9;
                                str10 = null;
                                obj4 = null;
                                str7 = str6;
                                break;
                            }
                        case 42:
                        case 66:
                            if (bo.nullAsNil(str6).length() > 0) {
                                if (t.kH(str2)) {
                                    str8 = bf.oy(str6);
                                    break;
                                }
                                str8 = str2;
                                aw.ZK();
                                a Rn = c.XO().Rn(str6);
                                aw.ZK();
                                str4 = c.XM().aoO(str8).Oj();
                                if (t.kH(str4)) {
                                    str4 = com.tencent.mm.model.n.T(com.tencent.mm.model.n.mB(str4));
                                }
                                if (i != 1) {
                                    str6 = context.getString(R.string.bwr, new Object[]{str4, Rn.getDisplayName()});
                                    pString.value = context.getString(R.string.bwr, new Object[]{"%s", Rn.getDisplayName()});
                                    pString2.value = str8;
                                    str = str9;
                                    str10 = null;
                                    obj4 = null;
                                    str7 = str6;
                                    break;
                                }
                                str6 = context.getString(R.string.bwq, new Object[]{str4, Rn.getDisplayName()});
                                pString.value = context.getString(R.string.bwq, new Object[]{"%s", Rn.getDisplayName()});
                                pString2.value = str8;
                                str = str9;
                                str10 = null;
                                obj4 = null;
                                str7 = str6;
                                break;
                            }
                        case 43:
                        case 62:
                            if (!ad.aou(str2) && !ad.aow(str2) && !t.ne(str2) && !t.ng(str2)) {
                                if (!(str6 == null || str6.length() <= 0 || t.nf(str2))) {
                                    if (t.kH(str2)) {
                                        q qVar = new q(str6);
                                        str6 = qVar.alt() + ": ";
                                        pString.value = "%s:";
                                        pString2.value = qVar.alt();
                                    } else {
                                        str6 = "";
                                    }
                                }
                                str = context.getString(R.string.ud);
                                str10 = null;
                                obj4 = null;
                                str7 = str6;
                                break;
                            }
                            str = str9;
                            str10 = null;
                            obj4 = null;
                            str7 = a(context, i, str2, str6, context.getString(R.string.ud), pString, pString2);
                            break;
                        case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                        case 1048625:
                            ap aps = ap.aps(str6);
                            str8 = aps.fWW + ": ";
                            if (str == null || str.length() != 32) {
                                str = context.getString(R.string.ph);
                            }
                            pString.value = "";
                            pString2.value = aps.fWW;
                            str10 = null;
                            obj4 = null;
                            str7 = str8;
                            break;
                        case 48:
                            if (bo.nullAsNil(str6).length() > 0) {
                                if (t.kH(str2)) {
                                    ox2 = bf.ox(str6);
                                    if (ox2 != -1) {
                                        str8 = str6.substring(0, ox2).trim();
                                    } else {
                                        str8 = str2;
                                    }
                                    bf.oz(str6);
                                    str4 = str8;
                                } else {
                                    str4 = str2;
                                }
                                if (i != 1) {
                                    str8 = context.getString(R.string.cn7);
                                    pString.value = context.getString(R.string.cn7);
                                    pString2.value = str4;
                                    str = str9;
                                    str10 = null;
                                    obj4 = null;
                                    str7 = str8;
                                    break;
                                }
                                str8 = context.getString(R.string.cn7);
                                pString.value = str8;
                                str = str9;
                                str10 = null;
                                obj4 = null;
                                str7 = str8;
                                break;
                            }
                        case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                        case 16777265:
                        case 268435505:
                        case 553648177:
                        case 587202609:
                        case 687865905:
                            str8 = bo.anj(substring);
                            com.tencent.mm.af.j.b me3 = com.tencent.mm.af.j.b.me(str8);
                            if (me3 != null) {
                                int obj42;
                                switch (me3.type) {
                                    case 1:
                                        str = "";
                                        str8 = str5.length() > 0 ? str5 + ": " + me3.title : me3.title;
                                        if (!t.ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " + me3.title : me3.title;
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 2:
                                        str = context.getString(R.string.sn);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!t.ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 3:
                                        str = context.getString(R.string.rs);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!t.ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = me3.title;
                                        obj42 = 1;
                                        str7 = str8;
                                        break;
                                    case 4:
                                        str = context.getString(R.string.ud);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!t.ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = me3.title;
                                        obj42 = 1;
                                        str7 = str8;
                                        break;
                                    case 5:
                                        str = context.getString(R.string.u9);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!(t.ny(str2) || obj32 != null || t.nH(str2))) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = me3.getTitle();
                                        obj42 = 1;
                                        str7 = str8;
                                        break;
                                    case 6:
                                        str = context.getString(R.string.qr);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!t.ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = me3.title;
                                        obj42 = 1;
                                        str7 = str8;
                                        break;
                                    case 7:
                                        str = context.getString(R.string.fy);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!t.ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 8:
                                        str = context.getString(R.string.pi);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!t.ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = "";
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 15:
                                    case 26:
                                    case 27:
                                        str = context.getString(R.string.pj);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!t.ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = "";
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 16:
                                        str = "";
                                        str4 = context.getString(R.string.ag8);
                                        str8 = str5.length() > 0 ? str5 + ": " + str4 + me3.title : str4 + me3.title;
                                        if (!t.ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: ".concat(String.valueOf(str4)) : String.valueOf(str4);
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 17:
                                        str = "";
                                        str8 = str5.length() > 0 ? str5 + ": " + me3.title : me3.title;
                                        if (!t.ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " + me3.title : me3.title;
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 19:
                                        str = context.getString(R.string.t5);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!t.ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 24:
                                        str8 = "";
                                        if (!bo.isNullOrNil(me3.description)) {
                                            ox2 = me3.description.indexOf(IOUtils.LINE_SEPARATOR_UNIX);
                                            str4 = me3.description;
                                            if (ox2 <= 0) {
                                                ox2 = me3.description.length();
                                            }
                                            str8 = str4.substring(0, ox2);
                                        }
                                        str = context.getString(R.string.bse) + str8;
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!t.ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 25:
                                        str = context.getString(R.string.p6);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!t.ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = "";
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 33:
                                    case 36:
                                        str = "";
                                        str4 = context.getString(R.string.ho);
                                        str8 = str5.length() > 0 ? str5 + ": " + str4 + me3.title : str4 + me3.title;
                                        if (!(t.ny(str2) || obj32 != null || t.nH(str2))) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " + str4 + me3.title : str4 + me3.title;
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 34:
                                        str = "";
                                        str8 = context.getString(R.string.ag8);
                                        if (i == 1) {
                                            str4 = str8 + me3.fhJ;
                                            pString.value = str5.length() > 0 ? "%s: ".concat(String.valueOf(str4)) : String.valueOf(str4);
                                            str8 = str4;
                                        } else {
                                            str4 = str8 + me3.fhI;
                                            pString.value = str5.length() > 0 ? "%s: ".concat(String.valueOf(str4)) : String.valueOf(str4);
                                            str8 = str4;
                                        }
                                        if (!t.ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                            str10 = null;
                                            obj42 = null;
                                            str7 = str8;
                                            break;
                                        }
                                    case 40:
                                        if (com.tencent.mm.af.n.mj(str8).fju != 19) {
                                            str = context.getString(R.string.fy);
                                            str10 = null;
                                            obj42 = null;
                                            str7 = str6;
                                            break;
                                        }
                                        str = context.getString(R.string.t5);
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str6;
                                        break;
                                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                                        if (!me3.cw(false)) {
                                            str = context.getString(R.string.fy);
                                            str10 = null;
                                            obj42 = null;
                                            str7 = "";
                                            break;
                                        }
                                        str = "";
                                        str4 = me3.p(context, true);
                                        if (!bo.isNullOrNil(str4)) {
                                            str8 = str5.length() > 0 ? str5 + ": " + str4 + me3.title : str4 + me3.title;
                                            pString2.value = str5;
                                            pString.value = str5.length() > 0 ? "%s: " + str4 + me3.title : str4 + me3.title;
                                            str10 = null;
                                            obj42 = null;
                                            str7 = str8;
                                            break;
                                        }
                                        str = context.getString(R.string.fy);
                                        str10 = null;
                                        obj42 = null;
                                        str7 = "";
                                        break;
                                    case 46:
                                        str = context.getString(R.string.fy);
                                        str10 = null;
                                        obj42 = null;
                                        str7 = "";
                                        break;
                                    default:
                                        str = context.getString(R.string.fy);
                                        str10 = null;
                                        obj42 = null;
                                        str7 = "";
                                        break;
                                }
                            }
                            ab.e("MicroMsg.Notification.Wording", "decode msg content failed");
                            str = "";
                            AppMethodBeat.o(16043);
                            return str;
                        case 50:
                        case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                            if (!str6.equals(bi.xZc)) {
                                if (str6.equals(bi.xZb)) {
                                    str = context.getString(R.string.ul);
                                    str10 = null;
                                    obj42 = null;
                                    str7 = "";
                                    break;
                                }
                            }
                            str = context.getString(R.string.uj);
                            str10 = null;
                            obj42 = null;
                            str7 = "";
                            break;
                        case 52:
                            str = context.getString(R.string.uj);
                            str10 = null;
                            obj42 = null;
                            str7 = "";
                            break;
                        case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                        case e.CTRL_INDEX /*57*/:
                            str8 = com.tencent.mm.ak.a.b(com.tencent.mm.ak.a.a.rE(str6));
                            pString.value = str8;
                            str = str9;
                            str10 = null;
                            obj42 = null;
                            str7 = str8;
                            break;
                        case 12299999:
                            str = context.getString(R.string.uj);
                            str10 = null;
                            obj42 = null;
                            str7 = "";
                            break;
                        case 285212721:
                            if (obj2 != null) {
                                str6 = jW(str6);
                            }
                            str8 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.biz.a.a.class)).mi(str6);
                            if (obj2 != null) {
                                str8 = jV(str8);
                            }
                            pString.value = str8;
                            str = str9;
                            str10 = null;
                            obj42 = null;
                            str7 = str8;
                            break;
                        case 318767153:
                            pString.value = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.biz.a.a.class)).mh(str6);
                            ab.i("MicroMsg.Notification.Wording", "[parseMsgContentToShow] type:%s suffix:%s", Integer.valueOf(318767153), pString.value);
                            str = str8;
                            str10 = null;
                            obj42 = null;
                            str7 = "";
                            break;
                        case 335544369:
                            me2 = com.tencent.mm.af.j.b.me(bo.anj(substring));
                            if (me2.fgP != 0) {
                                if (me2.fgP == 1) {
                                    str8 = context.getString(R.string.dyl);
                                } else if (me2.fgP == 2) {
                                    str8 = context.getString(R.string.dyn);
                                } else if (me2.fgP == 3) {
                                    str8 = context.getString(R.string.dym);
                                }
                                pString2.value = str5;
                                pString.value = "";
                                str = str8;
                                str10 = null;
                                obj42 = null;
                                str7 = "";
                                break;
                            }
                            str8 = context.getString(R.string.dyo);
                            pString2.value = str5;
                            pString.value = "";
                            str = str8;
                            str10 = null;
                            obj42 = null;
                            str7 = "";
                        case 369098801:
                            switch (com.tencent.mm.af.j.b.me(bo.anj(substring)).fgP) {
                                case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                                    str8 = context.getString(R.string.st);
                                    break;
                                case i.sHCENCODEVIDEOTIMEOUT /*20000*/:
                                    str8 = context.getString(R.string.sv);
                                    break;
                                default:
                                    str8 = context.getString(R.string.ss);
                                    break;
                            }
                            str4 = str5.length() > 0 ? str5 + ": " : "";
                            if (!t.ny(str2) && obj32 == null) {
                                pString2.value = str5;
                            }
                            pString.value = "";
                            str = str8;
                            str10 = null;
                            obj42 = null;
                            str7 = str4;
                            break;
                        case 402653233:
                            str = "";
                            str8 = "";
                            me = com.tencent.mm.af.j.b.me(bo.anj(substring));
                            if (me != null) {
                                pString.value = context.getString(R.string.dz1) + bo.nullAsNil(me.title);
                                str8 = pString.value;
                            }
                            pString2.value = str5;
                            str10 = null;
                            obj42 = null;
                            str7 = str8;
                            break;
                        case 419430449:
                            str = "";
                            str8 = "";
                            me = com.tencent.mm.af.j.b.me(bo.anj(substring));
                            if (me != null) {
                                obj = i == 1 ? 1 : null;
                                switch (me.fhv) {
                                    case 1:
                                        if (obj == null) {
                                            pString.value = context.getString(R.string.x0);
                                            break;
                                        }
                                        pString.value = context.getString(R.string.wx);
                                        break;
                                    case 3:
                                        if (obj == null) {
                                            pString.value = context.getString(R.string.wv);
                                            break;
                                        }
                                        pString.value = context.getString(R.string.wy);
                                        break;
                                    case 4:
                                        if (obj == null) {
                                            pString.value = context.getString(R.string.ww);
                                            break;
                                        }
                                        pString.value = context.getString(R.string.wz);
                                        break;
                                    default:
                                        pString.value = bo.nullAsNil(me.title);
                                        break;
                                }
                                str8 = pString.value;
                            }
                            pString2.value = str5;
                            str10 = null;
                            obj42 = null;
                            str7 = str8;
                            break;
                        case 436207665:
                        case 469762097:
                            str = "";
                            str8 = "";
                            me = com.tencent.mm.af.j.b.me(bo.anj(substring));
                            if (me != null) {
                                if (i == 1) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                                if (obj != null) {
                                    pString.value = "[" + me.fhW + "]" + me.fhT;
                                } else if (bo.isNullOrNil(displayName)) {
                                    pString.value = "[" + me.fhW + "]" + me.fhS;
                                } else {
                                    pString.value = bo.nullAsNil(displayName) + ": [" + me.fhW + "]" + me.fhS;
                                }
                                str8 = pString.value;
                            }
                            if (!t.ny(str2) && obj32 == null) {
                                pString2.value = str5;
                                str10 = null;
                                obj42 = null;
                                str7 = str8;
                                break;
                            }
                        case 452984881:
                            me = com.tencent.mm.af.j.b.me(bo.anj(substring));
                            if (me != null) {
                                str = "";
                                str10 = context.getString(R.string.ag8);
                                str8 = str5.length() > 0 ? str5 + ": " + str10 + me.title : str10 + me.title;
                                if (!t.ny(str2) && obj32 == null) {
                                    pString2.value = str5;
                                }
                                pString.value = str5.length() > 0 ? "%s: " + str10 + me.title : str10 + me.title;
                                str10 = null;
                                obj42 = null;
                                str7 = str8;
                                break;
                            }
                            ab.e("MicroMsg.Notification.Wording", "decode msg content failed");
                            str = "";
                            AppMethodBeat.o(16043);
                            return str;
                        case 503316529:
                            str8 = "";
                            me = com.tencent.mm.af.j.b.me(substring);
                            if (me != null) {
                                try {
                                    str8 = j.ajP(URLDecoder.decode(me.content, "UTF-8"));
                                    pString.value = str8;
                                    str = str9;
                                    str10 = null;
                                    obj42 = null;
                                    str7 = str8;
                                    break;
                                } catch (Exception e) {
                                    ab.printErrStackTrace("MicroMsg.Notification.Wording", e, "", new Object[0]);
                                    str = str9;
                                    str10 = null;
                                    obj42 = null;
                                    str7 = str8;
                                    break;
                                }
                            }
                        case 520093745:
                            me2 = com.tencent.mm.af.j.b.me(bo.anj(substring));
                            if (me2 != null) {
                                str = "";
                                str4 = context.getString(R.string.ag8);
                                if (i == 1) {
                                    str4 = str4 + me2.fhJ;
                                    pString.value = str5.length() > 0 ? "%s: ".concat(String.valueOf(str4)) : String.valueOf(str4);
                                    str8 = str4;
                                } else {
                                    str4 = str4 + me2.fhI;
                                    pString.value = str5.length() > 0 ? "%s: ".concat(String.valueOf(str4)) : String.valueOf(str4);
                                    str8 = str4;
                                }
                                if (!t.ny(str2) && obj32 == null) {
                                    pString2.value = str5;
                                    str10 = null;
                                    obj42 = null;
                                    str7 = str8;
                                    break;
                                }
                            }
                            ab.e("MicroMsg.Notification.Wording", "decode msg content failed");
                            str = "";
                            AppMethodBeat.o(16043);
                            return str;
                        case 536870961:
                            str = "";
                            str8 = "";
                            me = com.tencent.mm.af.j.b.me(bo.anj(substring));
                            if (me != null) {
                                com.tencent.mm.af.b bVar = (com.tencent.mm.af.b) me.X(com.tencent.mm.af.b.class);
                                if ((i == 1 ? 1 : null) != null) {
                                    pString.value = context.getString(R.string.ccz, new Object[]{bVar.ffF});
                                } else {
                                    pString.value = context.getString(R.string.ccz, new Object[]{bVar.ffG});
                                }
                                str8 = pString.value;
                                pString2.value = str5;
                                str10 = null;
                                obj42 = null;
                                str7 = str8;
                                break;
                            }
                        case 570425393:
                            CharSequence QD = ((com.tencent.mm.plugin.messenger.a.e) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.e.class)).QD(str6);
                            if (QD != null) {
                                str8 = QD.toString();
                            } else {
                                str8 = "";
                            }
                            pString.value = str8;
                            str = str9;
                            str10 = null;
                            obj42 = null;
                            str7 = str8;
                            break;
                        case 603979825:
                            str8 = com.tencent.mm.af.a.a.mk(str6).content;
                            if (bo.isNullOrNil(str8)) {
                                str8 = "";
                            }
                            pString.value = str8;
                            str = str9;
                            str10 = null;
                            obj42 = null;
                            str7 = str8;
                            break;
                        case 671088689:
                            str8 = "";
                            me = com.tencent.mm.af.j.b.me(bo.anj(substring));
                            if (me != null) {
                                if (((com.tencent.mm.ui.chatting.viewitems.j.a) me.X(com.tencent.mm.ui.chatting.viewitems.j.a.class)).state == 1) {
                                    str8 = context.getString(R.string.b7g, new Object[]{((com.tencent.mm.ui.chatting.viewitems.j.a) me.X(com.tencent.mm.ui.chatting.viewitems.j.a.class)).appName});
                                } else {
                                    str8 = context.getString(R.string.b7y, new Object[]{((com.tencent.mm.ui.chatting.viewitems.j.a) me.X(com.tencent.mm.ui.chatting.viewitems.j.a.class)).appName});
                                }
                            }
                            pString.value = str8;
                            str = str9;
                            str10 = null;
                            obj42 = null;
                            str7 = str8;
                            break;
                        case 704643121:
                            me2 = com.tencent.mm.af.j.b.me(bo.anj(substring));
                            if (me2 != null) {
                                str = "";
                                try {
                                    str6 = URLDecoder.decode(me2.content, "UTF-8");
                                    str8 = j.ajP(str6);
                                } catch (Exception e2) {
                                    str8 = str6;
                                    ab.printErrStackTrace("MicroMsg.Notification.Wording", e2, "", new Object[0]);
                                }
                                if (!t.ny(str2) && obj32 == null) {
                                    pString2.value = str5;
                                }
                                if (str5.length() > 0) {
                                    str4 = "%s: ".concat(String.valueOf(str8));
                                } else {
                                    str4 = str8;
                                }
                                pString.value = str4;
                                str10 = null;
                                obj42 = null;
                                str7 = str8;
                                break;
                            }
                            ab.e("MicroMsg.Notification.Wording", "decode msg content failed");
                            str = "";
                            AppMethodBeat.o(16043);
                            return str;
                        default:
                            str = str9;
                            str10 = null;
                            obj42 = null;
                            str7 = str6;
                            break;
                    }
                    str = str9;
                    str10 = null;
                    obj42 = null;
                    str7 = str8;
                    if (t.nf(str2)) {
                        if (bo.isNullOrNil(str7)) {
                            pString.value = "";
                        }
                        if (bo.isNullOrNil(str5)) {
                            if (t.ny(str2) || obj32 != null || t.nH(str2)) {
                                if (str != null && str.length() > 0) {
                                    str7 = str;
                                }
                                if (bo.isNullOrNil(str7)) {
                                    pString.value = "";
                                    pString2.value = "";
                                    str = "";
                                    AppMethodBeat.o(16043);
                                    return str;
                                }
                                if (i == 0) {
                                    pString.value = "%s:".concat(String.valueOf(str7));
                                } else {
                                    pString.value = context.getString(R.string.ri) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str7;
                                }
                                if (z) {
                                    a(i2, pString, pString2, pInt);
                                    str8 = str7;
                                } else {
                                    str = s.mJ(pString2.value) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str7;
                                    AppMethodBeat.o(16043);
                                    return str;
                                }
                            }
                            if (str == null || str.length() <= 0) {
                                str8 = str7;
                            } else {
                                pString.value = str;
                                str8 = str;
                            }
                            if (z) {
                                a(i2, pString, pString2, pInt);
                            }
                            if (!(obj42 == null || str10 == null)) {
                                str8 = str8.concat(" ".concat(String.valueOf(str10)));
                            }
                            if (obj2 != null) {
                                str8 = jW(str8);
                            }
                            str = bo.nullAsNil(str8);
                            AppMethodBeat.o(16043);
                            return str;
                        }
                        if (displayName != null && displayName.length() > 0) {
                            str7 = i(str7, str5, displayName);
                        }
                        if (bo.isNullOrNil(pString2.value)) {
                            pString.value = i(pString.value, str5, "%s");
                            pString2.value = str5;
                        }
                        str8 = o.kz(str7);
                        pString.value = o.kz(pString.value);
                        str8 = str8 + str;
                        pString.value += str;
                        if (z && !a(i2, pString, str8)) {
                            a(i2, pString, pString2, pInt);
                        }
                        if (obj42 != null) {
                            str8 = str8.concat(" " + bo.nullAsNil(str10));
                        }
                        str = bo.nullAsNil(str8);
                        AppMethodBeat.o(16043);
                        return str;
                    } else if (1 != i) {
                        str8 = null;
                        String[] split = str7.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        if (split == null || split.length <= 0) {
                            pString.value = "";
                            AppMethodBeat.o(16043);
                            return null;
                        }
                        str4 = split[0];
                        if (!bo.isNullOrNil(str4)) {
                            aw.ZK();
                            ad aoO = c.XM().aoO(str4);
                            if (!(aoO == null || aoO.getCity() == null)) {
                                str8 = aoO.getCity();
                            }
                            if (str8 == null || str8.length() <= 0) {
                                str8 = aoO.getProvince();
                            }
                        }
                        if (bo.isNullOrNil(str)) {
                            split = str7.split("@bottle:");
                            if (split.length > 1) {
                                pString.value = str8 + ": " + split[1];
                                str = str8 + ": " + split[1];
                                AppMethodBeat.o(16043);
                                return str;
                            }
                            pString.value = str8;
                            AppMethodBeat.o(16043);
                            return str8;
                        }
                        pString.value = str8 + ": " + str;
                        str = str8 + ": " + str;
                        AppMethodBeat.o(16043);
                        return str;
                    } else if (bo.isNullOrNil(str)) {
                        String[] split2 = str7.split("@bottle:");
                        if (split2.length > 1) {
                            pString.value = split2[1];
                            str = split2[1];
                            AppMethodBeat.o(16043);
                            return str;
                        }
                        pString.value = "";
                        AppMethodBeat.o(16043);
                        return null;
                    } else {
                        pString.value = str;
                        AppMethodBeat.o(16043);
                        return str;
                    }
                }
            }
            displayName = str4;
            str5 = str10;
            substring = str3;
            obj = null;
            if (t.ny(str2)) {
            }
            indexOf = str3.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (indexOf != -1) {
            }
            obj32 = null;
            str6 = str3;
            switch (i2) {
                case -1879048191:
                case -1879048190:
                case -1879048189:
                    break;
                case -1879048188:
                    break;
                case -1879048186:
                    break;
                case -1879048185:
                case -1879048183:
                case -1879048176:
                    break;
                case 3:
                case 23:
                case 33:
                    break;
                case 11:
                case 36:
                    break;
                case 13:
                case 39:
                    break;
                case 34:
                    break;
                case 35:
                    break;
                case g.CTRL_INDEX /*37*/:
                    break;
                case 40:
                    break;
                case 42:
                case 66:
                    break;
                case 43:
                case 62:
                    break;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                case 1048625:
                    break;
                case 48:
                    break;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                case 16777265:
                case 268435505:
                case 553648177:
                case 587202609:
                case 687865905:
                    break;
                case 50:
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    break;
                case 52:
                    break;
                case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                case e.CTRL_INDEX /*57*/:
                    break;
                case 12299999:
                    break;
                case 285212721:
                    break;
                case 318767153:
                    break;
                case 335544369:
                    break;
                case 369098801:
                    break;
                case 402653233:
                    break;
                case 419430449:
                    break;
                case 436207665:
                case 469762097:
                    break;
                case 452984881:
                    break;
                case 503316529:
                    break;
                case 520093745:
                    break;
                case 536870961:
                    break;
                case 570425393:
                    break;
                case 603979825:
                    break;
                case 671088689:
                    break;
                case 704643121:
                    break;
                default:
                    break;
            }
            str = str9;
            str10 = null;
            obj42 = null;
            str7 = str8;
            if (t.nf(str2)) {
            }
        } else if (z) {
            str = "";
            AppMethodBeat.o(16043);
            return str;
        } else {
            str = bx(context);
            AppMethodBeat.o(16043);
            return str;
        }
    }

    private static String a(Context context, int i, String str, String str2, String str3, PString pString, PString pString2) {
        StringBuilder append;
        int i2 = R.string.byg;
        AppMethodBeat.i(16044);
        String str4 = "";
        if (t.ne(str) || t.ng(str)) {
            if (str2 != null) {
                int indexOf = str2.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (indexOf >= 0 && indexOf < str2.length()) {
                    String substring = str2.substring(0, indexOf);
                    if (ad.aou(substring) || ad.aow(substring)) {
                        str4 = s.mJ(substring);
                        pString2.value = substring;
                        str2 = str2.substring(indexOf + 1);
                    }
                }
            }
        } else if (ad.aou(str) || ad.aow(str)) {
            s.mJ(str);
            pString2.value = str;
            if (i == 1) {
                append = new StringBuilder().append(context.getString(R.string.byg, new Object[]{""}));
                if (str3 != null) {
                    str2 = str3;
                }
                pString.value = append.append(str2).toString();
                pString2.value = "";
                str4 = pString.value;
                AppMethodBeat.o(16044);
                return str4;
            }
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            pString2.value = "";
            str4 = pString.value;
            AppMethodBeat.o(16044);
            return str4;
        }
        if (bo.nullAsNil(str4).length() <= 0) {
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            str4 = pString.value;
            AppMethodBeat.o(16044);
            return str4;
        }
        pString.value = context.getString(i == 1 ? R.string.byg : R.string.byq) + (str3 == null ? str2 : str3);
        StringBuilder stringBuilder = new StringBuilder();
        if (i != 1) {
            i2 = R.string.byq;
        }
        append = stringBuilder.append(context.getString(i2, new Object[]{str4}));
        if (str3 != null) {
            str2 = str3;
        }
        str4 = append.append(str2).toString();
        AppMethodBeat.o(16044);
        return str4;
    }

    private static String bx(Context context) {
        AppMethodBeat.i(16045);
        boolean YU = r.YU();
        aw.ZK();
        long a = bo.a((Long) c.Ry().get(65793, null), 0);
        String string;
        if (!YU) {
            string = context.getString(R.string.e_7);
            AppMethodBeat.o(16045);
            return string;
        } else if (a == 0) {
            string = context.getString(R.string.bye);
            AppMethodBeat.o(16045);
            return string;
        } else if (bo.fp(a) * 1000 > 1209600000) {
            string = context.getString(R.string.byd, new Object[]{Long.valueOf((bo.fp(a) * 1000) / 86400000)});
            AppMethodBeat.o(16045);
            return string;
        } else {
            string = "";
            AppMethodBeat.o(16045);
            return string;
        }
    }

    private static String jV(String str) {
        AppMethodBeat.i(16046);
        if (str != null) {
            str = str.replaceAll("%", "%%");
            AppMethodBeat.o(16046);
            return str;
        }
        AppMethodBeat.o(16046);
        return str;
    }

    private static String i(String str, String str2, String str3) {
        AppMethodBeat.i(16047);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
            AppMethodBeat.o(16047);
            return str;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf < 0) {
            AppMethodBeat.o(16047);
            return str;
        }
        str = str.substring(0, indexOf) + str3 + str.substring(indexOf + str2.length());
        AppMethodBeat.o(16047);
        return str;
    }

    private static boolean a(int i, PString pString, String str) {
        AppMethodBeat.i(16048);
        if (pString.value.length() == 32 && (i == 47 || i == 1048625)) {
            pString.value = str;
            AppMethodBeat.o(16048);
            return true;
        }
        AppMethodBeat.o(16048);
        return false;
    }

    private static String jW(String str) {
        AppMethodBeat.i(16049);
        if (str != null) {
            str = str.replaceAll("%%", "%");
            AppMethodBeat.o(16049);
            return str;
        }
        AppMethodBeat.o(16049);
        return str;
    }

    public static String jX(String str) {
        AppMethodBeat.i(16050);
        if (str == null) {
            str = "";
            AppMethodBeat.o(16050);
            return str;
        } else if (str.length() < 150) {
            AppMethodBeat.o(16050);
            return str;
        } else {
            str = str.substring(0, 150) + "...";
            AppMethodBeat.o(16050);
            return str;
        }
    }

    private static void a(int i, PString pString, PString pString2, PInt pInt) {
        AppMethodBeat.i(16051);
        if (pString.value.length() == 32 && (i == 47 || i == 1048625)) {
            AppMethodBeat.o(16051);
            return;
        }
        if (pString.value.length() >= 150) {
            pString.value = pString.value.substring(0, C(pString.value, 150));
        }
        TextPaint textPaint = getTextPaint();
        if (pString.value.replace("%%", "").contains("%s") || textPaint == null) {
            pInt.value = 0;
            AppMethodBeat.o(16051);
            return;
        }
        String format;
        try {
            format = String.format(pString.value, new Object[]{pString2.value});
        } catch (Exception e) {
            format = pString.value;
        }
        pString.value = a(format, textPaint).toString();
        pInt.value = 1;
        AppMethodBeat.o(16051);
    }

    private static CharSequence a(String str, TextPaint textPaint) {
        AppMethodBeat.i(16052);
        CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, (float) Ja(), TruncateAt.END);
        AppMethodBeat.o(16052);
        return ellipsize;
    }

    private static int Ja() {
        AppMethodBeat.i(16053);
        int i;
        if (eeR > 0) {
            i = eeR;
            AppMethodBeat.o(16053);
            return i;
        }
        i = BackwardSupportUtil.b.b(ah.getContext(), 200.0f);
        AppMethodBeat.o(16053);
        return i;
    }

    private static int C(String str, int i) {
        AppMethodBeat.i(16054);
        while (i < str.length()) {
            if (str.charAt(i) != '%') {
                AppMethodBeat.o(16054);
                return i;
            }
            i++;
        }
        i = str.length();
        AppMethodBeat.o(16054);
        return i;
    }

    private static TextPaint getTextPaint() {
        AppMethodBeat.i(16055);
        if (eeQ == null) {
            AppMethodBeat.o(16055);
            return null;
        }
        TextPaint textPaint = (TextPaint) eeQ.get();
        AppMethodBeat.o(16055);
        return textPaint;
    }

    public static void iv(int i) {
        eeR = i;
    }

    public static void iw(int i) {
        eeS = i;
    }

    public static void a(TextPaint textPaint) {
        AppMethodBeat.i(16056);
        if (eeQ == null || eeQ.get() == null) {
            eeQ = new WeakReference(textPaint);
        }
        AppMethodBeat.o(16056);
    }

    public static String d(Context context, String str, boolean z) {
        AppMethodBeat.i(16057);
        String anU = b.dqD().anU(str);
        if (z) {
            AppMethodBeat.o(16057);
            return anU;
        }
        anU = context.getString(R.string.ce1);
        AppMethodBeat.o(16057);
        return anU;
    }

    public static String a(Context context, String str, int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(16058);
        String anU;
        if (z) {
            anU = b.dqD().anU(str);
            if (i3 > 1) {
                anU = context.getResources().getQuantityString(R.plurals.w, i3, new Object[]{Integer.valueOf(i3)}) + anU;
            }
            AppMethodBeat.o(16058);
            return anU;
        }
        anU = context.getResources().getQuantityString(R.plurals.x, i, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        AppMethodBeat.o(16058);
        return anU;
    }

    public static String e(Context context, String str, boolean z) {
        AppMethodBeat.i(16059);
        String anU;
        if (z) {
            anU = b.dqD().anU(str);
            AppMethodBeat.o(16059);
            return anU;
        }
        anU = context.getString(R.string.d_3);
        AppMethodBeat.o(16059);
        return anU;
    }
}
