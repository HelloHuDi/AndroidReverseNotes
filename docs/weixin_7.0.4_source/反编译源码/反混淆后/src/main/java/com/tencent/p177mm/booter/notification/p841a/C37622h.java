package com.tencent.p177mm.booter.notification.p841a;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C18176o;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C37963q;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.p181af.C25746b;
import com.tencent.p177mm.p181af.C32222n;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p181af.p1175a.C25744a;
import com.tencent.p177mm.p186ak.C1235a;
import com.tencent.p177mm.p186ak.C1235a.C1236a;
import com.tencent.p177mm.p211cb.C37626b;
import com.tencent.p177mm.p612ui.chatting.viewitems.C23850j.C23852a;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C19410e;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.C7620bi.C5137c;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import junit.framework.Assert;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.booter.notification.a.h */
public final class C37622h {
    private static WeakReference<TextPaint> eeQ;
    private static int eeR = 0;
    private static int eeS = 0;
    public String eeO = "";
    public String eeP = "";
    public String mTitle = "";

    /* renamed from: a */
    public static String m63522a(Context context, String str, String str2, int i) {
        AppMethodBeat.m2504i(16038);
        String ajP = C44089j.ajP(C37626b.dqD().anU(C37622h.m63519a(0, str2, str, i, context)));
        AppMethodBeat.m2505o(16038);
        return ajP;
    }

    /* renamed from: g */
    public static String m63532g(Context context, String str, String str2) {
        String oy;
        AppMethodBeat.m2504i(16039);
        if (C1855t.m3896kH(str)) {
            oy = C1829bf.m3762oy(str2);
            if (oy != null) {
                oy = C1854s.m3866mJ(oy.trim());
            } else {
                oy = C1854s.m3866mJ(str);
            }
        } else {
            oy = C1854s.m3866mJ(str);
        }
        if (str.contains("@bottle")) {
            oy = context.getResources().getQuantityString(C25738R.plurals.f9609v, 1, new Object[]{Integer.valueOf(1)});
            AppMethodBeat.m2505o(16039);
            return oy;
        }
        if (C5046bo.isNullOrNil(oy) && C1855t.m3896kH(str)) {
            oy = context.getString(C25738R.string.ao1);
        }
        oy = C37626b.dqD().anU(oy);
        AppMethodBeat.m2505o(16039);
        return oy;
    }

    /* renamed from: b */
    public static String m63527b(C7616ad c7616ad) {
        AppMethodBeat.m2504i(16040);
        Context context = C4996ah.getContext();
        String string;
        if (c7616ad == null) {
            string = context.getString(C25738R.string.ab0);
            AppMethodBeat.m2505o(16040);
            return string;
        } else if (RegionCodeDecoder.apQ(c7616ad.getCountryCode())) {
            string = c7616ad.getCity();
            if (C5046bo.isNullOrNil(string)) {
                string = C1854s.m3868mL(c7616ad.getProvince());
                if (C5046bo.isNullOrNil(string)) {
                    RegionCodeDecoder.duj();
                    string = RegionCodeDecoder.getLocName(c7616ad.getCountryCode());
                    AppMethodBeat.m2505o(16040);
                    return string;
                }
                AppMethodBeat.m2505o(16040);
                return string;
            }
            AppMethodBeat.m2505o(16040);
            return string;
        } else {
            string = C1854s.m3868mL(c7616ad.getProvince());
            if (C5046bo.isNullOrNil(string)) {
                string = context.getString(C25738R.string.ab0);
                AppMethodBeat.m2505o(16040);
                return string;
            }
            AppMethodBeat.m2505o(16040);
            return string;
        }
    }

    /* renamed from: b */
    public static String m63528b(C7620bi c7620bi, PString pString, PString pString2, PInt pInt, boolean z) {
        String dtW;
        AppMethodBeat.m2504i(16041);
        if (c7620bi.dtv()) {
            dtW = c7620bi.dtW();
        } else {
            dtW = c7620bi.field_content;
        }
        dtW = C5046bo.nullAsNil(C37622h.m63523a(c7620bi.field_imgPath, c7620bi.field_isSend, c7620bi.field_talker, C44089j.ajP(dtW), c7620bi.getType(), C4996ah.getContext(), pString, pString2, pInt, true, z));
        AppMethodBeat.m2505o(16041);
        return dtW;
    }

    /* renamed from: a */
    public static String m63519a(int i, String str, String str2, int i2, Context context) {
        AppMethodBeat.m2504i(16042);
        String nullAsNil = C5046bo.nullAsNil(C37622h.m63523a(null, i, str, str2, i2, context, new PString(), new PString(), new PInt(), false, false));
        AppMethodBeat.m2505o(16042);
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
    /* renamed from: a */
    private static String m63523a(String str, int i, String str2, String str3, int i2, Context context, PString pString, PString pString2, PInt pInt, boolean z, boolean z2) {
        Object obj;
        AppMethodBeat.m2504i(16043);
        Assert.assertTrue("context is null", context != null);
        String str4 = "username is null";
        boolean z3 = str2 != null && str2.length() > 0;
        Assert.assertTrue(str4, z3);
        if (!z) {
            if (!C1855t.m3936ne(str2) || C1853r.m3836YR()) {
                if (C1855t.m3938ng(str2)) {
                    if ((C1853r.m3822YD() & 64) != 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        obj = 1;
                    }
                }
                if (!C1855t.m3942nk(str2) || C1853r.m3839YU()) {
                    obj = null;
                } else {
                    obj = 1;
                }
            } else {
                obj = 1;
            }
            if (obj != null) {
                str = context.getString(C25738R.string.e_7);
                AppMethodBeat.m2505o(16043);
                return str;
            }
        }
        if (!C1855t.m3942nk(str2)) {
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
                str3 = C37622h.m63536jV(str3);
                obj2 = 1;
            }
            pString.value = str3;
            if (i == 0 && (C1855t.m3896kH(str2) || C1855t.m3903mP(str2))) {
                int ox = C1829bf.m3761ox(str3);
                if (ox > 0) {
                    str4 = str3.substring(0, ox).trim();
                    displayName = C1854s.getDisplayName(str4, str2);
                    str5 = str4;
                    substring = (str3 + " ").substring(ox + 1);
                    obj = null;
                    if (!C1855t.m3956ny(str2) || C1855t.m3922nH(str2)) {
                        indexOf = str3.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        if (indexOf != -1) {
                            pString2.value = str3.substring(0, indexOf);
                            str3 = str3.substring(indexOf + 1);
                        }
                        obj3 = null;
                        str6 = str3;
                    } else {
                        C9638aw.m17190ZK();
                        C7617ak aoZ = C18628c.m29083XR().aoZ(str2);
                        if ((aoZ != null && aoZ.mo16714jl(2097152)) || z2) {
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
                    C8910b me;
                    int ox2;
                    C8910b me2;
                    switch (i2) {
                        case -1879048191:
                        case -1879048190:
                        case -1879048189:
                            str = context.getString(C25738R.string.f9257ui);
                            str10 = null;
                            obj4 = null;
                            str7 = "";
                            break;
                        case -1879048188:
                            str = context.getString(C25738R.string.f9259ul);
                            str10 = null;
                            obj4 = null;
                            str7 = "";
                            break;
                        case -1879048186:
                            me = C8910b.m16064me(C5046bo.anj(substring));
                            if (me != null) {
                                str = "";
                                str8 = str5.length() > 0 ? str5 + ": " + me.title : me.title;
                                if (!C1855t.m3956ny(str2) && obj32 == null) {
                                    pString2.value = str5;
                                }
                                pString.value = str5.length() > 0 ? "%s: " + me.title : me.title;
                                str10 = null;
                                obj4 = null;
                                str7 = str8;
                                break;
                            }
                            C4990ab.m7412e("MicroMsg.Notification.Wording", "decode msg content failed");
                            str = "";
                            AppMethodBeat.m2505o(16043);
                            return str;
                        case -1879048185:
                        case -1879048183:
                        case -1879048176:
                            str = context.getString(C25738R.string.f8820fy);
                            str8 = str5.length() > 0 ? str5 + ": " : "";
                            if (!C1855t.m3956ny(str2) && obj32 == null) {
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
                            str = context.getString(C25738R.string.f9199sn);
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
                            str7 = C37622h.m63520a(context, i, str2, str6, null, pString, pString2);
                            break;
                        case 13:
                        case 39:
                            str = str9;
                            str10 = null;
                            obj4 = null;
                            str7 = C37622h.m63520a(context, i, str2, str6, context.getString(C25738R.string.f9199sn), pString, pString2);
                            break;
                        case 34:
                            if (!C7616ad.aou(str2) && !C7616ad.aow(str2) && !C1855t.m3936ne(str2) && !C1855t.m3938ng(str2)) {
                                if (!(str6 == null || str6.length() <= 0 || C1855t.m3937nf(str2))) {
                                    if (C1855t.m3896kH(str2)) {
                                        C42230n c42230n = new C42230n(str6);
                                        str6 = c42230n.alt() + ": ";
                                        pString.value = "%s:";
                                        pString2.value = c42230n.alt();
                                    } else {
                                        str6 = "";
                                    }
                                }
                                str = context.getString(C25738R.string.f9256ug);
                                str10 = null;
                                obj4 = null;
                                str7 = str6;
                                break;
                            }
                            str = str9;
                            str10 = null;
                            obj4 = null;
                            str7 = C37622h.m63520a(context, i, str2, str6, context.getString(C25738R.string.f9256ug), pString, pString2);
                            break;
                            break;
                        case 35:
                            if (C5046bo.nullAsNil(str6).length() > 0) {
                                C9638aw.m17190ZK();
                                C5137c Rl = C18628c.m29080XO().mo15258Rl(str6);
                                str8 = context.getString(C25738R.string.byc, new Object[]{Rl.fOt, Rl.title});
                                pString.value = str8;
                                str = str9;
                                str10 = null;
                                obj4 = null;
                                str7 = str8;
                                break;
                            }
                        case C2275g.CTRL_INDEX /*37*/:
                            if (str6 != null && str6.length() > 0) {
                                C5138d apF = C5138d.apF(str6);
                                if (apF.dtY() != null && apF.dtY().length() > 0) {
                                    switch (apF.scene) {
                                        case 18:
                                            str = str9;
                                            str10 = null;
                                            obj4 = null;
                                            str7 = context.getString(C25738R.string.byj, new Object[]{apF.getDisplayName()});
                                            break;
                                        case 22:
                                        case 23:
                                        case 24:
                                        case 26:
                                        case 27:
                                        case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                                        case 29:
                                            str = str9;
                                            str10 = null;
                                            obj4 = null;
                                            str7 = context.getString(C25738R.string.byt, new Object[]{apF.getDisplayName()});
                                            break;
                                        case 25:
                                            str8 = context.getString(C25738R.string.bwp, new Object[]{apF.getDisplayName()});
                                            pString.value = str8;
                                            str = str9;
                                            str10 = null;
                                            obj4 = null;
                                            str7 = str8;
                                            break;
                                        default:
                                            str6 = context.getString(C25738R.string.bz2, new Object[]{apF.getDisplayName()});
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
                                C5135a apC = C5135a.apC(str6);
                                if (apC.dtY() != null && apC.dtY().length() > 0) {
                                    str6 = context.getString(C25738R.string.bxd, new Object[]{apC.getDisplayName()});
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
                            if (C5046bo.nullAsNil(str6).length() > 0) {
                                if (C1855t.m3896kH(str2)) {
                                    str8 = C1829bf.m3762oy(str6);
                                    break;
                                }
                                str8 = str2;
                                C9638aw.m17190ZK();
                                C5135a Rn = C18628c.m29080XO().mo15260Rn(str6);
                                C9638aw.m17190ZK();
                                str4 = C18628c.m29078XM().aoO(str8).mo16707Oj();
                                if (C1855t.m3896kH(str4)) {
                                    str4 = C37921n.m64045T(C37921n.m64061mB(str4));
                                }
                                if (i != 1) {
                                    str6 = context.getString(C25738R.string.bwr, new Object[]{str4, Rn.getDisplayName()});
                                    pString.value = context.getString(C25738R.string.bwr, new Object[]{"%s", Rn.getDisplayName()});
                                    pString2.value = str8;
                                    str = str9;
                                    str10 = null;
                                    obj4 = null;
                                    str7 = str6;
                                    break;
                                }
                                str6 = context.getString(C25738R.string.bwq, new Object[]{str4, Rn.getDisplayName()});
                                pString.value = context.getString(C25738R.string.bwq, new Object[]{"%s", Rn.getDisplayName()});
                                pString2.value = str8;
                                str = str9;
                                str10 = null;
                                obj4 = null;
                                str7 = str6;
                                break;
                            }
                        case 43:
                        case 62:
                            if (!C7616ad.aou(str2) && !C7616ad.aow(str2) && !C1855t.m3936ne(str2) && !C1855t.m3938ng(str2)) {
                                if (!(str6 == null || str6.length() <= 0 || C1855t.m3937nf(str2))) {
                                    if (C1855t.m3896kH(str2)) {
                                        C37963q c37963q = new C37963q(str6);
                                        str6 = c37963q.alt() + ": ";
                                        pString.value = "%s:";
                                        pString2.value = c37963q.alt();
                                    } else {
                                        str6 = "";
                                    }
                                }
                                str = context.getString(C25738R.string.f9253ud);
                                str10 = null;
                                obj4 = null;
                                str7 = str6;
                                break;
                            }
                            str = str9;
                            str10 = null;
                            obj4 = null;
                            str7 = C37622h.m63520a(context, i, str2, str6, context.getString(C25738R.string.f9253ud), pString, pString2);
                            break;
                        case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                        case 1048625:
                            C44218ap aps = C44218ap.aps(str6);
                            str8 = aps.fWW + ": ";
                            if (str == null || str.length() != 32) {
                                str = context.getString(C25738R.string.f9100ph);
                            }
                            pString.value = "";
                            pString2.value = aps.fWW;
                            str10 = null;
                            obj4 = null;
                            str7 = str8;
                            break;
                        case 48:
                            if (C5046bo.nullAsNil(str6).length() > 0) {
                                if (C1855t.m3896kH(str2)) {
                                    ox2 = C1829bf.m3761ox(str6);
                                    if (ox2 != -1) {
                                        str8 = str6.substring(0, ox2).trim();
                                    } else {
                                        str8 = str2;
                                    }
                                    C1829bf.m3763oz(str6);
                                    str4 = str8;
                                } else {
                                    str4 = str2;
                                }
                                if (i != 1) {
                                    str8 = context.getString(C25738R.string.cn7);
                                    pString.value = context.getString(C25738R.string.cn7);
                                    pString2.value = str4;
                                    str = str9;
                                    str10 = null;
                                    obj4 = null;
                                    str7 = str8;
                                    break;
                                }
                                str8 = context.getString(C25738R.string.cn7);
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
                            str8 = C5046bo.anj(substring);
                            C8910b me3 = C8910b.m16064me(str8);
                            if (me3 != null) {
                                int obj42;
                                switch (me3.type) {
                                    case 1:
                                        str = "";
                                        str8 = str5.length() > 0 ? str5 + ": " + me3.title : me3.title;
                                        if (!C1855t.m3956ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " + me3.title : me3.title;
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 2:
                                        str = context.getString(C25738R.string.f9199sn);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!C1855t.m3956ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 3:
                                        str = context.getString(C25738R.string.f9174rs);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!C1855t.m3956ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = me3.title;
                                        obj42 = 1;
                                        str7 = str8;
                                        break;
                                    case 4:
                                        str = context.getString(C25738R.string.f9253ud);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!C1855t.m3956ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = me3.title;
                                        obj42 = 1;
                                        str7 = str8;
                                        break;
                                    case 5:
                                        str = context.getString(C25738R.string.f9248u9);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!(C1855t.m3956ny(str2) || obj32 != null || C1855t.m3922nH(str2))) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = me3.getTitle();
                                        obj42 = 1;
                                        str7 = str8;
                                        break;
                                    case 6:
                                        str = context.getString(C25738R.string.f9140qr);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!C1855t.m3956ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = me3.title;
                                        obj42 = 1;
                                        str7 = str8;
                                        break;
                                    case 7:
                                        str = context.getString(C25738R.string.f8820fy);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!C1855t.m3956ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 8:
                                        str = context.getString(C25738R.string.f9101pi);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!C1855t.m3956ny(str2) && obj32 == null) {
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
                                        str = context.getString(C25738R.string.f9102pj);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!C1855t.m3956ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = "";
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 16:
                                        str = "";
                                        str4 = context.getString(C25738R.string.ag8);
                                        str8 = str5.length() > 0 ? str5 + ": " + str4 + me3.title : str4 + me3.title;
                                        if (!C1855t.m3956ny(str2) && obj32 == null) {
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
                                        if (!C1855t.m3956ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " + me3.title : me3.title;
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 19:
                                        str = context.getString(C25738R.string.f9212t5);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!C1855t.m3956ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 24:
                                        str8 = "";
                                        if (!C5046bo.isNullOrNil(me3.description)) {
                                            ox2 = me3.description.indexOf(IOUtils.LINE_SEPARATOR_UNIX);
                                            str4 = me3.description;
                                            if (ox2 <= 0) {
                                                ox2 = me3.description.length();
                                            }
                                            str8 = str4.substring(0, ox2);
                                        }
                                        str = context.getString(C25738R.string.bse) + str8;
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!C1855t.m3956ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " : "";
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 25:
                                        str = context.getString(C25738R.string.f9090p6);
                                        str8 = str5.length() > 0 ? str5 + ": " : "";
                                        if (!C1855t.m3956ny(str2) && obj32 == null) {
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
                                        str4 = context.getString(C25738R.string.f8870ho);
                                        str8 = str5.length() > 0 ? str5 + ": " + str4 + me3.title : str4 + me3.title;
                                        if (!(C1855t.m3956ny(str2) || obj32 != null || C1855t.m3922nH(str2))) {
                                            pString2.value = str5;
                                        }
                                        pString.value = str5.length() > 0 ? "%s: " + str4 + me3.title : str4 + me3.title;
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str8;
                                        break;
                                    case 34:
                                        str = "";
                                        str8 = context.getString(C25738R.string.ag8);
                                        if (i == 1) {
                                            str4 = str8 + me3.fhJ;
                                            pString.value = str5.length() > 0 ? "%s: ".concat(String.valueOf(str4)) : String.valueOf(str4);
                                            str8 = str4;
                                        } else {
                                            str4 = str8 + me3.fhI;
                                            pString.value = str5.length() > 0 ? "%s: ".concat(String.valueOf(str4)) : String.valueOf(str4);
                                            str8 = str4;
                                        }
                                        if (!C1855t.m3956ny(str2) && obj32 == null) {
                                            pString2.value = str5;
                                            str10 = null;
                                            obj42 = null;
                                            str7 = str8;
                                            break;
                                        }
                                    case 40:
                                        if (C32222n.m52572mj(str8).fju != 19) {
                                            str = context.getString(C25738R.string.f8820fy);
                                            str10 = null;
                                            obj42 = null;
                                            str7 = str6;
                                            break;
                                        }
                                        str = context.getString(C25738R.string.f9212t5);
                                        str10 = null;
                                        obj42 = null;
                                        str7 = str6;
                                        break;
                                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                                        if (!me3.mo20336cw(false)) {
                                            str = context.getString(C25738R.string.f8820fy);
                                            str10 = null;
                                            obj42 = null;
                                            str7 = "";
                                            break;
                                        }
                                        str = "";
                                        str4 = me3.mo20339p(context, true);
                                        if (!C5046bo.isNullOrNil(str4)) {
                                            str8 = str5.length() > 0 ? str5 + ": " + str4 + me3.title : str4 + me3.title;
                                            pString2.value = str5;
                                            pString.value = str5.length() > 0 ? "%s: " + str4 + me3.title : str4 + me3.title;
                                            str10 = null;
                                            obj42 = null;
                                            str7 = str8;
                                            break;
                                        }
                                        str = context.getString(C25738R.string.f8820fy);
                                        str10 = null;
                                        obj42 = null;
                                        str7 = "";
                                        break;
                                    case 46:
                                        str = context.getString(C25738R.string.f8820fy);
                                        str10 = null;
                                        obj42 = null;
                                        str7 = "";
                                        break;
                                    default:
                                        str = context.getString(C25738R.string.f8820fy);
                                        str10 = null;
                                        obj42 = null;
                                        str7 = "";
                                        break;
                                }
                            }
                            C4990ab.m7412e("MicroMsg.Notification.Wording", "decode msg content failed");
                            str = "";
                            AppMethodBeat.m2505o(16043);
                            return str;
                        case 50:
                        case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                            if (!str6.equals(C7620bi.xZc)) {
                                if (str6.equals(C7620bi.xZb)) {
                                    str = context.getString(C25738R.string.f9259ul);
                                    str10 = null;
                                    obj42 = null;
                                    str7 = "";
                                    break;
                                }
                            }
                            str = context.getString(C25738R.string.f9258uj);
                            str10 = null;
                            obj42 = null;
                            str7 = "";
                            break;
                        case 52:
                            str = context.getString(C25738R.string.f9258uj);
                            str10 = null;
                            obj42 = null;
                            str7 = "";
                            break;
                        case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                        case C19410e.CTRL_INDEX /*57*/:
                            str8 = C1235a.m2672b(C1236a.m2673rE(str6));
                            pString.value = str8;
                            str = str9;
                            str10 = null;
                            obj42 = null;
                            str7 = str8;
                            break;
                        case 12299999:
                            str = context.getString(C25738R.string.f9258uj);
                            str10 = null;
                            obj42 = null;
                            str7 = "";
                            break;
                        case 285212721:
                            if (obj2 != null) {
                                str6 = C37622h.m63537jW(str6);
                            }
                            str8 = ((C27500a) C1720g.m3528K(C27500a.class)).mo35249mi(str6);
                            if (obj2 != null) {
                                str8 = C37622h.m63536jV(str8);
                            }
                            pString.value = str8;
                            str = str9;
                            str10 = null;
                            obj42 = null;
                            str7 = str8;
                            break;
                        case 318767153:
                            pString.value = ((C27500a) C1720g.m3528K(C27500a.class)).mo35248mh(str6);
                            C4990ab.m7417i("MicroMsg.Notification.Wording", "[parseMsgContentToShow] type:%s suffix:%s", Integer.valueOf(318767153), pString.value);
                            str = str8;
                            str10 = null;
                            obj42 = null;
                            str7 = "";
                            break;
                        case 335544369:
                            me2 = C8910b.m16064me(C5046bo.anj(substring));
                            if (me2.fgP != 0) {
                                if (me2.fgP == 1) {
                                    str8 = context.getString(C25738R.string.dyl);
                                } else if (me2.fgP == 2) {
                                    str8 = context.getString(C25738R.string.dyn);
                                } else if (me2.fgP == 3) {
                                    str8 = context.getString(C25738R.string.dym);
                                }
                                pString2.value = str5;
                                pString.value = "";
                                str = str8;
                                str10 = null;
                                obj42 = null;
                                str7 = "";
                                break;
                            }
                            str8 = context.getString(C25738R.string.dyo);
                            pString2.value = str5;
                            pString.value = "";
                            str = str8;
                            str10 = null;
                            obj42 = null;
                            str7 = "";
                        case 369098801:
                            switch (C8910b.m16064me(C5046bo.anj(substring)).fgP) {
                                case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                                    str8 = context.getString(C25738R.string.f9202st);
                                    break;
                                case C1625i.sHCENCODEVIDEOTIMEOUT /*20000*/:
                                    str8 = context.getString(C25738R.string.f9204sv);
                                    break;
                                default:
                                    str8 = context.getString(C25738R.string.f9201ss);
                                    break;
                            }
                            str4 = str5.length() > 0 ? str5 + ": " : "";
                            if (!C1855t.m3956ny(str2) && obj32 == null) {
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
                            me = C8910b.m16064me(C5046bo.anj(substring));
                            if (me != null) {
                                pString.value = context.getString(C25738R.string.dz1) + C5046bo.nullAsNil(me.title);
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
                            me = C8910b.m16064me(C5046bo.anj(substring));
                            if (me != null) {
                                obj = i == 1 ? 1 : null;
                                switch (me.fhv) {
                                    case 1:
                                        if (obj == null) {
                                            pString.value = context.getString(C25738R.string.f9336x0);
                                            break;
                                        }
                                        pString.value = context.getString(C25738R.string.f9333wx);
                                        break;
                                    case 3:
                                        if (obj == null) {
                                            pString.value = context.getString(C25738R.string.f9331wv);
                                            break;
                                        }
                                        pString.value = context.getString(C25738R.string.f9334wy);
                                        break;
                                    case 4:
                                        if (obj == null) {
                                            pString.value = context.getString(C25738R.string.f9332ww);
                                            break;
                                        }
                                        pString.value = context.getString(C25738R.string.f9335wz);
                                        break;
                                    default:
                                        pString.value = C5046bo.nullAsNil(me.title);
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
                            me = C8910b.m16064me(C5046bo.anj(substring));
                            if (me != null) {
                                if (i == 1) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                                if (obj != null) {
                                    pString.value = "[" + me.fhW + "]" + me.fhT;
                                } else if (C5046bo.isNullOrNil(displayName)) {
                                    pString.value = "[" + me.fhW + "]" + me.fhS;
                                } else {
                                    pString.value = C5046bo.nullAsNil(displayName) + ": [" + me.fhW + "]" + me.fhS;
                                }
                                str8 = pString.value;
                            }
                            if (!C1855t.m3956ny(str2) && obj32 == null) {
                                pString2.value = str5;
                                str10 = null;
                                obj42 = null;
                                str7 = str8;
                                break;
                            }
                        case 452984881:
                            me = C8910b.m16064me(C5046bo.anj(substring));
                            if (me != null) {
                                str = "";
                                str10 = context.getString(C25738R.string.ag8);
                                str8 = str5.length() > 0 ? str5 + ": " + str10 + me.title : str10 + me.title;
                                if (!C1855t.m3956ny(str2) && obj32 == null) {
                                    pString2.value = str5;
                                }
                                pString.value = str5.length() > 0 ? "%s: " + str10 + me.title : str10 + me.title;
                                str10 = null;
                                obj42 = null;
                                str7 = str8;
                                break;
                            }
                            C4990ab.m7412e("MicroMsg.Notification.Wording", "decode msg content failed");
                            str = "";
                            AppMethodBeat.m2505o(16043);
                            return str;
                        case 503316529:
                            str8 = "";
                            me = C8910b.m16064me(substring);
                            if (me != null) {
                                try {
                                    str8 = C44089j.ajP(URLDecoder.decode(me.content, "UTF-8"));
                                    pString.value = str8;
                                    str = str9;
                                    str10 = null;
                                    obj42 = null;
                                    str7 = str8;
                                    break;
                                } catch (Exception e) {
                                    C4990ab.printErrStackTrace("MicroMsg.Notification.Wording", e, "", new Object[0]);
                                    str = str9;
                                    str10 = null;
                                    obj42 = null;
                                    str7 = str8;
                                    break;
                                }
                            }
                        case 520093745:
                            me2 = C8910b.m16064me(C5046bo.anj(substring));
                            if (me2 != null) {
                                str = "";
                                str4 = context.getString(C25738R.string.ag8);
                                if (i == 1) {
                                    str4 = str4 + me2.fhJ;
                                    pString.value = str5.length() > 0 ? "%s: ".concat(String.valueOf(str4)) : String.valueOf(str4);
                                    str8 = str4;
                                } else {
                                    str4 = str4 + me2.fhI;
                                    pString.value = str5.length() > 0 ? "%s: ".concat(String.valueOf(str4)) : String.valueOf(str4);
                                    str8 = str4;
                                }
                                if (!C1855t.m3956ny(str2) && obj32 == null) {
                                    pString2.value = str5;
                                    str10 = null;
                                    obj42 = null;
                                    str7 = str8;
                                    break;
                                }
                            }
                            C4990ab.m7412e("MicroMsg.Notification.Wording", "decode msg content failed");
                            str = "";
                            AppMethodBeat.m2505o(16043);
                            return str;
                        case 536870961:
                            str = "";
                            str8 = "";
                            me = C8910b.m16064me(C5046bo.anj(substring));
                            if (me != null) {
                                C25746b c25746b = (C25746b) me.mo20333X(C25746b.class);
                                if ((i == 1 ? 1 : null) != null) {
                                    pString.value = context.getString(C25738R.string.ccz, new Object[]{c25746b.ffF});
                                } else {
                                    pString.value = context.getString(C25738R.string.ccz, new Object[]{c25746b.ffG});
                                }
                                str8 = pString.value;
                                pString2.value = str5;
                                str10 = null;
                                obj42 = null;
                                str7 = str8;
                                break;
                            }
                        case 570425393:
                            CharSequence QD = ((C12514e) C1720g.m3528K(C12514e.class)).mo24436QD(str6);
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
                            str8 = C25744a.m40872mk(str6).content;
                            if (C5046bo.isNullOrNil(str8)) {
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
                            me = C8910b.m16064me(C5046bo.anj(substring));
                            if (me != null) {
                                if (((C23852a) me.mo20333X(C23852a.class)).state == 1) {
                                    str8 = context.getString(C25738R.string.b7g, new Object[]{((C23852a) me.mo20333X(C23852a.class)).appName});
                                } else {
                                    str8 = context.getString(C25738R.string.b7y, new Object[]{((C23852a) me.mo20333X(C23852a.class)).appName});
                                }
                            }
                            pString.value = str8;
                            str = str9;
                            str10 = null;
                            obj42 = null;
                            str7 = str8;
                            break;
                        case 704643121:
                            me2 = C8910b.m16064me(C5046bo.anj(substring));
                            if (me2 != null) {
                                str = "";
                                try {
                                    str6 = URLDecoder.decode(me2.content, "UTF-8");
                                    str8 = C44089j.ajP(str6);
                                } catch (Exception e2) {
                                    str8 = str6;
                                    C4990ab.printErrStackTrace("MicroMsg.Notification.Wording", e2, "", new Object[0]);
                                }
                                if (!C1855t.m3956ny(str2) && obj32 == null) {
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
                            C4990ab.m7412e("MicroMsg.Notification.Wording", "decode msg content failed");
                            str = "";
                            AppMethodBeat.m2505o(16043);
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
                    if (C1855t.m3937nf(str2)) {
                        if (C5046bo.isNullOrNil(str7)) {
                            pString.value = "";
                        }
                        if (C5046bo.isNullOrNil(str5)) {
                            if (C1855t.m3956ny(str2) || obj32 != null || C1855t.m3922nH(str2)) {
                                if (str != null && str.length() > 0) {
                                    str7 = str;
                                }
                                if (C5046bo.isNullOrNil(str7)) {
                                    pString.value = "";
                                    pString2.value = "";
                                    str = "";
                                    AppMethodBeat.m2505o(16043);
                                    return str;
                                }
                                if (i == 0) {
                                    pString.value = "%s:".concat(String.valueOf(str7));
                                } else {
                                    pString.value = context.getString(C25738R.string.f9164ri) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str7;
                                }
                                if (z) {
                                    C37622h.m63524a(i2, pString, pString2, pInt);
                                    str8 = str7;
                                } else {
                                    str = C1854s.m3866mJ(pString2.value) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str7;
                                    AppMethodBeat.m2505o(16043);
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
                                C37622h.m63524a(i2, pString, pString2, pInt);
                            }
                            if (!(obj42 == null || str10 == null)) {
                                str8 = str8.concat(" ".concat(String.valueOf(str10)));
                            }
                            if (obj2 != null) {
                                str8 = C37622h.m63537jW(str8);
                            }
                            str = C5046bo.nullAsNil(str8);
                            AppMethodBeat.m2505o(16043);
                            return str;
                        }
                        if (displayName != null && displayName.length() > 0) {
                            str7 = C37622h.m63533i(str7, str5, displayName);
                        }
                        if (C5046bo.isNullOrNil(pString2.value)) {
                            pString.value = C37622h.m63533i(pString.value, str5, "%s");
                            pString2.value = str5;
                        }
                        str8 = C18176o.m28621kz(str7);
                        pString.value = C18176o.m28621kz(pString.value);
                        str8 = str8 + str;
                        pString.value += str;
                        if (z && !C37622h.m63526a(i2, pString, str8)) {
                            C37622h.m63524a(i2, pString, pString2, pInt);
                        }
                        if (obj42 != null) {
                            str8 = str8.concat(" " + C5046bo.nullAsNil(str10));
                        }
                        str = C5046bo.nullAsNil(str8);
                        AppMethodBeat.m2505o(16043);
                        return str;
                    } else if (1 != i) {
                        str8 = null;
                        String[] split = str7.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        if (split == null || split.length <= 0) {
                            pString.value = "";
                            AppMethodBeat.m2505o(16043);
                            return null;
                        }
                        str4 = split[0];
                        if (!C5046bo.isNullOrNil(str4)) {
                            C9638aw.m17190ZK();
                            C7616ad aoO = C18628c.m29078XM().aoO(str4);
                            if (!(aoO == null || aoO.getCity() == null)) {
                                str8 = aoO.getCity();
                            }
                            if (str8 == null || str8.length() <= 0) {
                                str8 = aoO.getProvince();
                            }
                        }
                        if (C5046bo.isNullOrNil(str)) {
                            split = str7.split("@bottle:");
                            if (split.length > 1) {
                                pString.value = str8 + ": " + split[1];
                                str = str8 + ": " + split[1];
                                AppMethodBeat.m2505o(16043);
                                return str;
                            }
                            pString.value = str8;
                            AppMethodBeat.m2505o(16043);
                            return str8;
                        }
                        pString.value = str8 + ": " + str;
                        str = str8 + ": " + str;
                        AppMethodBeat.m2505o(16043);
                        return str;
                    } else if (C5046bo.isNullOrNil(str)) {
                        String[] split2 = str7.split("@bottle:");
                        if (split2.length > 1) {
                            pString.value = split2[1];
                            str = split2[1];
                            AppMethodBeat.m2505o(16043);
                            return str;
                        }
                        pString.value = "";
                        AppMethodBeat.m2505o(16043);
                        return null;
                    } else {
                        pString.value = str;
                        AppMethodBeat.m2505o(16043);
                        return str;
                    }
                }
            }
            displayName = str4;
            str5 = str10;
            substring = str3;
            obj = null;
            if (C1855t.m3956ny(str2)) {
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
                case C2275g.CTRL_INDEX /*37*/:
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
                case C19410e.CTRL_INDEX /*57*/:
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
            if (C1855t.m3937nf(str2)) {
            }
        } else if (z) {
            str = "";
            AppMethodBeat.m2505o(16043);
            return str;
        } else {
            str = C37622h.m63529bx(context);
            AppMethodBeat.m2505o(16043);
            return str;
        }
    }

    /* renamed from: a */
    private static String m63520a(Context context, int i, String str, String str2, String str3, PString pString, PString pString2) {
        StringBuilder append;
        int i2 = C25738R.string.byg;
        AppMethodBeat.m2504i(16044);
        String str4 = "";
        if (C1855t.m3936ne(str) || C1855t.m3938ng(str)) {
            if (str2 != null) {
                int indexOf = str2.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (indexOf >= 0 && indexOf < str2.length()) {
                    String substring = str2.substring(0, indexOf);
                    if (C7616ad.aou(substring) || C7616ad.aow(substring)) {
                        str4 = C1854s.m3866mJ(substring);
                        pString2.value = substring;
                        str2 = str2.substring(indexOf + 1);
                    }
                }
            }
        } else if (C7616ad.aou(str) || C7616ad.aow(str)) {
            C1854s.m3866mJ(str);
            pString2.value = str;
            if (i == 1) {
                append = new StringBuilder().append(context.getString(C25738R.string.byg, new Object[]{""}));
                if (str3 != null) {
                    str2 = str3;
                }
                pString.value = append.append(str2).toString();
                pString2.value = "";
                str4 = pString.value;
                AppMethodBeat.m2505o(16044);
                return str4;
            }
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            pString2.value = "";
            str4 = pString.value;
            AppMethodBeat.m2505o(16044);
            return str4;
        }
        if (C5046bo.nullAsNil(str4).length() <= 0) {
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            str4 = pString.value;
            AppMethodBeat.m2505o(16044);
            return str4;
        }
        pString.value = context.getString(i == 1 ? C25738R.string.byg : C25738R.string.byq) + (str3 == null ? str2 : str3);
        StringBuilder stringBuilder = new StringBuilder();
        if (i != 1) {
            i2 = C25738R.string.byq;
        }
        append = stringBuilder.append(context.getString(i2, new Object[]{str4}));
        if (str3 != null) {
            str2 = str3;
        }
        str4 = append.append(str2).toString();
        AppMethodBeat.m2505o(16044);
        return str4;
    }

    /* renamed from: bx */
    private static String m63529bx(Context context) {
        AppMethodBeat.m2504i(16045);
        boolean YU = C1853r.m3839YU();
        C9638aw.m17190ZK();
        long a = C5046bo.m7514a((Long) C18628c.m29072Ry().get(65793, null), 0);
        String string;
        if (!YU) {
            string = context.getString(C25738R.string.e_7);
            AppMethodBeat.m2505o(16045);
            return string;
        } else if (a == 0) {
            string = context.getString(C25738R.string.bye);
            AppMethodBeat.m2505o(16045);
            return string;
        } else if (C5046bo.m7549fp(a) * 1000 > 1209600000) {
            string = context.getString(C25738R.string.byd, new Object[]{Long.valueOf((C5046bo.m7549fp(a) * 1000) / 86400000)});
            AppMethodBeat.m2505o(16045);
            return string;
        } else {
            string = "";
            AppMethodBeat.m2505o(16045);
            return string;
        }
    }

    /* renamed from: jV */
    private static String m63536jV(String str) {
        AppMethodBeat.m2504i(16046);
        if (str != null) {
            str = str.replaceAll("%", "%%");
            AppMethodBeat.m2505o(16046);
            return str;
        }
        AppMethodBeat.m2505o(16046);
        return str;
    }

    /* renamed from: i */
    private static String m63533i(String str, String str2, String str3) {
        AppMethodBeat.m2504i(16047);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
            AppMethodBeat.m2505o(16047);
            return str;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf < 0) {
            AppMethodBeat.m2505o(16047);
            return str;
        }
        str = str.substring(0, indexOf) + str3 + str.substring(indexOf + str2.length());
        AppMethodBeat.m2505o(16047);
        return str;
    }

    /* renamed from: a */
    private static boolean m63526a(int i, PString pString, String str) {
        AppMethodBeat.m2504i(16048);
        if (pString.value.length() == 32 && (i == 47 || i == 1048625)) {
            pString.value = str;
            AppMethodBeat.m2505o(16048);
            return true;
        }
        AppMethodBeat.m2505o(16048);
        return false;
    }

    /* renamed from: jW */
    private static String m63537jW(String str) {
        AppMethodBeat.m2504i(16049);
        if (str != null) {
            str = str.replaceAll("%%", "%");
            AppMethodBeat.m2505o(16049);
            return str;
        }
        AppMethodBeat.m2505o(16049);
        return str;
    }

    /* renamed from: jX */
    public static String m63538jX(String str) {
        AppMethodBeat.m2504i(16050);
        if (str == null) {
            str = "";
            AppMethodBeat.m2505o(16050);
            return str;
        } else if (str.length() < 150) {
            AppMethodBeat.m2505o(16050);
            return str;
        } else {
            str = str.substring(0, 150) + "...";
            AppMethodBeat.m2505o(16050);
            return str;
        }
    }

    /* renamed from: a */
    private static void m63524a(int i, PString pString, PString pString2, PInt pInt) {
        AppMethodBeat.m2504i(16051);
        if (pString.value.length() == 32 && (i == 47 || i == 1048625)) {
            AppMethodBeat.m2505o(16051);
            return;
        }
        if (pString.value.length() >= 150) {
            pString.value = pString.value.substring(0, C37622h.m63516C(pString.value, 150));
        }
        TextPaint textPaint = C37622h.getTextPaint();
        if (pString.value.replace("%%", "").contains("%s") || textPaint == null) {
            pInt.value = 0;
            AppMethodBeat.m2505o(16051);
            return;
        }
        String format;
        try {
            format = String.format(pString.value, new Object[]{pString2.value});
        } catch (Exception e) {
            format = pString.value;
        }
        pString.value = C37622h.m63518a(format, textPaint).toString();
        pInt.value = 1;
        AppMethodBeat.m2505o(16051);
    }

    /* renamed from: a */
    private static CharSequence m63518a(String str, TextPaint textPaint) {
        AppMethodBeat.m2504i(16052);
        CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, (float) C37622h.m63517Ja(), TruncateAt.END);
        AppMethodBeat.m2505o(16052);
        return ellipsize;
    }

    /* renamed from: Ja */
    private static int m63517Ja() {
        AppMethodBeat.m2504i(16053);
        int i;
        if (eeR > 0) {
            i = eeR;
            AppMethodBeat.m2505o(16053);
            return i;
        }
        i = C4977b.m7371b(C4996ah.getContext(), 200.0f);
        AppMethodBeat.m2505o(16053);
        return i;
    }

    /* renamed from: C */
    private static int m63516C(String str, int i) {
        AppMethodBeat.m2504i(16054);
        while (i < str.length()) {
            if (str.charAt(i) != '%') {
                AppMethodBeat.m2505o(16054);
                return i;
            }
            i++;
        }
        i = str.length();
        AppMethodBeat.m2505o(16054);
        return i;
    }

    private static TextPaint getTextPaint() {
        AppMethodBeat.m2504i(16055);
        if (eeQ == null) {
            AppMethodBeat.m2505o(16055);
            return null;
        }
        TextPaint textPaint = (TextPaint) eeQ.get();
        AppMethodBeat.m2505o(16055);
        return textPaint;
    }

    /* renamed from: iv */
    public static void m63534iv(int i) {
        eeR = i;
    }

    /* renamed from: iw */
    public static void m63535iw(int i) {
        eeS = i;
    }

    /* renamed from: a */
    public static void m63525a(TextPaint textPaint) {
        AppMethodBeat.m2504i(16056);
        if (eeQ == null || eeQ.get() == null) {
            eeQ = new WeakReference(textPaint);
        }
        AppMethodBeat.m2505o(16056);
    }

    /* renamed from: d */
    public static String m63530d(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(16057);
        String anU = C37626b.dqD().anU(str);
        if (z) {
            AppMethodBeat.m2505o(16057);
            return anU;
        }
        anU = context.getString(C25738R.string.ce1);
        AppMethodBeat.m2505o(16057);
        return anU;
    }

    /* renamed from: a */
    public static String m63521a(Context context, String str, int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(16058);
        String anU;
        if (z) {
            anU = C37626b.dqD().anU(str);
            if (i3 > 1) {
                anU = context.getResources().getQuantityString(C25738R.plurals.f9610w, i3, new Object[]{Integer.valueOf(i3)}) + anU;
            }
            AppMethodBeat.m2505o(16058);
            return anU;
        }
        anU = context.getResources().getQuantityString(C25738R.plurals.f9611x, i, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        AppMethodBeat.m2505o(16058);
        return anU;
    }

    /* renamed from: e */
    public static String m63531e(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(16059);
        String anU;
        if (z) {
            anU = C37626b.dqD().anU(str);
            AppMethodBeat.m2505o(16059);
            return anU;
        }
        anU = context.getString(C25738R.string.d_3);
        AppMethodBeat.m2505o(16059);
        return anU;
    }
}
