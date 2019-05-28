package com.tencent.p177mm.plugin.wenote.p1333b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.fav.p407a.C11851an;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1074a.C14724a;
import com.tencent.p177mm.plugin.wenote.model.p585a.C23178g;
import com.tencent.p177mm.plugin.wenote.model.p585a.C24930f;
import com.tencent.p177mm.plugin.wenote.model.p585a.C29978o;
import com.tencent.p177mm.plugin.wenote.model.p585a.C31480h;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40365i;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40366k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40367r;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44002d;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44003l;
import com.tencent.p177mm.sdk.platformtools.C35985ad;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.ActUtil;
import java.util.HashMap;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.wenote.b.c */
public final class C29977c {
    public static HashMap<String, String> uSF = new HashMap();
    public static HashMap<String, C40367r> uSG = new HashMap();
    public static C29977c uSH = null;
    private static C1177f<String, Integer> uSI = new C7598c(30);

    static {
        AppMethodBeat.m2504i(26993);
        AppMethodBeat.m2505o(26993);
    }

    /* renamed from: hs */
    public static String m47431hs(String str, String str2) {
        String str3;
        int i = ActUtil.HEIGHT;
        AppMethodBeat.m2504i(26981);
        if (C5046bo.isNullOrNil(str2)) {
            str3 = C11851an.bvm() + "/" + (C1178g.m2591x((str + System.currentTimeMillis()).getBytes()) + "_HD");
        } else {
            str3 = str2;
        }
        if (!C5730e.m8628ct(str3)) {
            Options amj = C5056d.amj(str);
            if (amj == null || amj.outWidth <= 0 || amj.outHeight <= 0) {
                C4990ab.m7412e("MicroMsg.WNNoteUtil", "GetImageOptions Error");
                AppMethodBeat.m2505o(26981);
                return null;
            }
            int i2;
            int i3 = amj.outHeight;
            int i4 = amj.outWidth;
            if (i4 > ActUtil.HEIGHT) {
                i4 = ActUtil.HEIGHT;
            }
            if (i3 <= ActUtil.HEIGHT) {
                i = i3;
            }
            if (amj.outHeight < amj.outWidth) {
                i2 = i;
                i3 = i4;
            } else {
                i2 = i4;
                i3 = i;
            }
            if (C35985ad.amy(str) > 0) {
                i3 = amj.outHeight;
                i2 = amj.outWidth;
            }
            C5056d.m7656c(str, i3, i2, CompressFormat.JPEG, 95, str3);
        }
        AppMethodBeat.m2505o(26981);
        return str3;
    }

    /* renamed from: ht */
    public static String m47432ht(String str, String str2) {
        String str3;
        int i = 800;
        AppMethodBeat.m2504i(26982);
        if (C5046bo.isNullOrNil(str2)) {
            str3 = C11851an.bvm() + "/" + (C1178g.m2591x((str + System.currentTimeMillis()).getBytes()) + "_TH");
        } else {
            str3 = str2;
        }
        if (!C5730e.m8628ct(str3)) {
            Options amj = C5056d.amj(str);
            if (amj == null || amj.outWidth <= 0 || amj.outHeight <= 0) {
                C4990ab.m7412e("MicroMsg.WNNoteUtil", "GetImageOptions Error,use orignal file");
                AppMethodBeat.m2505o(26982);
                return null;
            }
            int i2;
            int i3 = amj.outHeight;
            int i4 = amj.outWidth;
            while (i4 * i3 > 2764800) {
                i4 >>= 1;
                i3 >>= 1;
            }
            if (i4 > 800) {
                i4 = 800;
            }
            if (i3 <= 800) {
                i = i3;
            }
            if (amj.outHeight < amj.outWidth) {
                i2 = i;
                i3 = i4;
            } else {
                i2 = i4;
                i3 = i;
            }
            C5056d.m7656c(str, i3, i2, CompressFormat.JPEG, 95, str3);
        }
        AppMethodBeat.m2505o(26982);
        return str3;
    }

    public static Bitmap ahk(String str) {
        AppMethodBeat.m2504i(26983);
        Bitmap aI = C45932c.m85262aI(str, false);
        if (aI != null) {
            AppMethodBeat.m2505o(26983);
            return aI;
        } else if (C5046bo.isNullOrNil(null)) {
            AppMethodBeat.m2505o(26983);
            return null;
        } else {
            aI = C45932c.m85262aI(null, false);
            AppMethodBeat.m2505o(26983);
            return aI;
        }
    }

    /* renamed from: c */
    public static C44001c m47428c(C44001c c44001c) {
        AppMethodBeat.m2504i(26984);
        if (c44001c == null) {
            AppMethodBeat.m2505o(26984);
            return null;
        }
        C44001c c31480h;
        switch (c44001c.getType()) {
            case -1:
                c31480h = new C31480h();
                break;
            case 1:
                c31480h = new C40365i();
                ((C40365i) c31480h).content = ((C40365i) c44001c).content;
                break;
            case 2:
                c31480h = new C24930f();
                ((C24930f) c31480h).uOq = ((C24930f) c44001c).uOq;
                break;
            case 3:
                c31480h = new C23178g();
                C23178g c23178g = (C23178g) c31480h;
                C23178g c23178g2 = (C23178g) c44001c;
                c23178g.lat = c23178g2.lat;
                c23178g.lng = c23178g2.lng;
                c23178g.scale = c23178g2.scale;
                c23178g.fBg = c23178g2.fBg;
                c23178g.eUu = c23178g2.eUu;
                break;
            case 4:
                c31480h = new C44003l();
                C44003l c44003l = (C44003l) c31480h;
                C44003l c44003l2 = (C44003l) c44001c;
                c44003l.uOD = c44003l2.uOD;
                c44003l.length = c44003l2.length;
                c44003l.uOC = c44003l2.uOC;
                c44003l.hNN = c44003l2.hNN;
                c44003l.cAP = c44003l2.cAP;
                c44003l.cAO = c44003l2.cAO;
                c44003l.uOf = c44003l2.uOf;
                break;
            case 5:
                c31480h = new C44002d();
                C44002d c44002d = (C44002d) c31480h;
                C44002d c44002d2 = (C44002d) c44001c;
                c44002d.title = c44002d2.title;
                c44002d.content = c44002d2.content;
                c44002d.hNN = c44002d2.hNN;
                c44002d.uOf = c44002d2.uOf;
                break;
            case 6:
                c31480h = new C40366k();
                C40366k c40366k = (C40366k) c31480h;
                C40366k c40366k2 = (C40366k) c44001c;
                c40366k.thumbPath = c40366k2.thumbPath;
                c40366k.duration = c40366k2.duration;
                c40366k.uOf = c40366k2.uOf;
                break;
            default:
                c31480h = null;
                break;
        }
        if (c31480h == null) {
            AppMethodBeat.m2505o(26984);
            return null;
        }
        ((C29978o) c31480h).type = ((C29978o) c44001c).type;
        ((C29978o) c31480h).uOp = ((C29978o) c44001c).uOp;
        ((C29978o) c31480h).cHg = ((C29978o) c44001c).cHg;
        AppMethodBeat.m2505o(26984);
        return c31480h;
    }

    /* renamed from: d */
    public static String m47429d(C44001c c44001c) {
        AppMethodBeat.m2504i(26985);
        String str;
        if (c44001c == null) {
            str = "";
            AppMethodBeat.m2505o(26985);
            return str;
        } else if (c44001c.getType() == 2) {
            str = ((C24930f) c44001c).uOq;
            AppMethodBeat.m2505o(26985);
            return str;
        } else {
            str = ((C29978o) c44001c).cHg;
            AppMethodBeat.m2505o(26985);
            return str;
        }
    }

    /* renamed from: e */
    public static String m47430e(C44001c c44001c) {
        AppMethodBeat.m2504i(26986);
        String str;
        if (c44001c == null) {
            str = "";
            AppMethodBeat.m2505o(26986);
            return str;
        } else if (c44001c.getType() == 2) {
            str = ((C24930f) c44001c).cHg;
            AppMethodBeat.m2505o(26986);
            return str;
        } else if (c44001c.getType() == 6) {
            str = ((C40366k) c44001c).thumbPath;
            AppMethodBeat.m2505o(26986);
            return str;
        } else {
            str = "";
            AppMethodBeat.m2505o(26986);
            return str;
        }
    }

    public static int ahl(String str) {
        AppMethodBeat.m2504i(26987);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(26987);
            return 0;
        }
        int ahn = C29977c.ahn(C23176b.ahh(str));
        AppMethodBeat.m2505o(26987);
        return ahn;
    }

    /* renamed from: c */
    public static int m47427c(String str, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(26988);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(26988);
            return 0;
        }
        Spanned ahb = C14724a.ahb(str);
        if (ahb == null) {
            AppMethodBeat.m2505o(26988);
            return 0;
        }
        if (z) {
            i2 = ahb.length();
        }
        if (i < 0 || i > ahb.length() || i2 < 0 || i2 > ahb.length() || i > i2) {
            AppMethodBeat.m2505o(26988);
            return 0;
        }
        ahb = (Spanned) ahb.subSequence(i, i2);
        if (ahb == null) {
            AppMethodBeat.m2505o(26988);
            return 0;
        }
        int ahn = C29977c.ahn(ahb.toString());
        AppMethodBeat.m2505o(26988);
        return ahn;
    }

    public static int ahm(String str) {
        AppMethodBeat.m2504i(26989);
        int intValue;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(26989);
            return 0;
        } else if (uSI.mo4405aj(str)) {
            intValue = ((Integer) uSI.get(str)).intValue();
            AppMethodBeat.m2505o(26989);
            return intValue;
        } else {
            intValue = C29977c.ahn(str);
            uSI.put(str, Integer.valueOf(intValue));
            AppMethodBeat.m2505o(26989);
            return intValue;
        }
    }

    private static int ahn(String str) {
        int i = 0;
        AppMethodBeat.m2504i(26990);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(26990);
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < str.length()) {
                i = C29977c.m47433x(str.charAt(i2)) + i3;
                i2++;
            } else {
                AppMethodBeat.m2505o(26990);
                return i3;
            }
        }
    }

    /* renamed from: x */
    private static int m47433x(char c) {
        if (c <= 127) {
            return 1;
        }
        return 2;
    }

    /* renamed from: a */
    public static String m47426a(Context context, C44001c c44001c) {
        AppMethodBeat.m2504i(26991);
        String str;
        if (c44001c == null) {
            str = "";
            AppMethodBeat.m2505o(26991);
            return str;
        }
        int type = c44001c.getType();
        if (type == 1) {
            str = ((C40365i) c44001c).content;
            AppMethodBeat.m2505o(26991);
            return str;
        } else if (type == 3) {
            str = context.getString(C25738R.string.g1a);
            AppMethodBeat.m2505o(26991);
            return str;
        } else if (type == 2) {
            str = context.getString(C25738R.string.g1_);
            AppMethodBeat.m2505o(26991);
            return str;
        } else if (type == 6) {
            str = context.getString(C25738R.string.g1b);
            AppMethodBeat.m2505o(26991);
            return str;
        } else if (type == 4) {
            str = context.getString(C25738R.string.g1c);
            AppMethodBeat.m2505o(26991);
            return str;
        } else if (type == 5) {
            str = context.getString(C25738R.string.g19);
            AppMethodBeat.m2505o(26991);
            return str;
        } else {
            str = "";
            AppMethodBeat.m2505o(26991);
            return str;
        }
    }

    public static String aho(String str) {
        AppMethodBeat.m2504i(26992);
        String replaceAll = Pattern.compile("wa-b>", 2).matcher(Pattern.compile("<[/]?w(x|n)-[^>]*>", 2).matcher(Pattern.compile("</wn-todo>", 2).matcher(Pattern.compile("</wx-li>", 2).matcher(Pattern.compile("wx-b>", 2).matcher(str).replaceAll("wa-b>")).replaceAll("<br/>")).replaceAll("<br/>")).replaceAll("")).replaceAll("wx-b>");
        AppMethodBeat.m2505o(26992);
        return replaceAll;
    }
}
