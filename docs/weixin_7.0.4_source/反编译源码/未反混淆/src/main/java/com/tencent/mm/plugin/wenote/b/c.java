package com.tencent.mm.plugin.wenote.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.util.ActUtil;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class c {
    public static HashMap<String, String> uSF = new HashMap();
    public static HashMap<String, r> uSG = new HashMap();
    public static c uSH = null;
    private static f<String, Integer> uSI = new com.tencent.mm.memory.a.c(30);

    static {
        AppMethodBeat.i(26993);
        AppMethodBeat.o(26993);
    }

    public static String hs(String str, String str2) {
        String str3;
        int i = ActUtil.HEIGHT;
        AppMethodBeat.i(26981);
        if (bo.isNullOrNil(str2)) {
            str3 = an.bvm() + "/" + (g.x((str + System.currentTimeMillis()).getBytes()) + "_HD");
        } else {
            str3 = str2;
        }
        if (!e.ct(str3)) {
            Options amj = d.amj(str);
            if (amj == null || amj.outWidth <= 0 || amj.outHeight <= 0) {
                ab.e("MicroMsg.WNNoteUtil", "GetImageOptions Error");
                AppMethodBeat.o(26981);
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
            if (ad.amy(str) > 0) {
                i3 = amj.outHeight;
                i2 = amj.outWidth;
            }
            d.c(str, i3, i2, CompressFormat.JPEG, 95, str3);
        }
        AppMethodBeat.o(26981);
        return str3;
    }

    public static String ht(String str, String str2) {
        String str3;
        int i = 800;
        AppMethodBeat.i(26982);
        if (bo.isNullOrNil(str2)) {
            str3 = an.bvm() + "/" + (g.x((str + System.currentTimeMillis()).getBytes()) + "_TH");
        } else {
            str3 = str2;
        }
        if (!e.ct(str3)) {
            Options amj = d.amj(str);
            if (amj == null || amj.outWidth <= 0 || amj.outHeight <= 0) {
                ab.e("MicroMsg.WNNoteUtil", "GetImageOptions Error,use orignal file");
                AppMethodBeat.o(26982);
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
            d.c(str, i3, i2, CompressFormat.JPEG, 95, str3);
        }
        AppMethodBeat.o(26982);
        return str3;
    }

    public static Bitmap ahk(String str) {
        AppMethodBeat.i(26983);
        Bitmap aI = com.tencent.mm.plugin.fav.ui.c.aI(str, false);
        if (aI != null) {
            AppMethodBeat.o(26983);
            return aI;
        } else if (bo.isNullOrNil(null)) {
            AppMethodBeat.o(26983);
            return null;
        } else {
            aI = com.tencent.mm.plugin.fav.ui.c.aI(null, false);
            AppMethodBeat.o(26983);
            return aI;
        }
    }

    public static com.tencent.mm.plugin.wenote.model.a.c c(com.tencent.mm.plugin.wenote.model.a.c cVar) {
        AppMethodBeat.i(26984);
        if (cVar == null) {
            AppMethodBeat.o(26984);
            return null;
        }
        com.tencent.mm.plugin.wenote.model.a.c hVar;
        switch (cVar.getType()) {
            case -1:
                hVar = new h();
                break;
            case 1:
                hVar = new i();
                ((i) hVar).content = ((i) cVar).content;
                break;
            case 2:
                hVar = new com.tencent.mm.plugin.wenote.model.a.f();
                ((com.tencent.mm.plugin.wenote.model.a.f) hVar).uOq = ((com.tencent.mm.plugin.wenote.model.a.f) cVar).uOq;
                break;
            case 3:
                hVar = new com.tencent.mm.plugin.wenote.model.a.g();
                com.tencent.mm.plugin.wenote.model.a.g gVar = (com.tencent.mm.plugin.wenote.model.a.g) hVar;
                com.tencent.mm.plugin.wenote.model.a.g gVar2 = (com.tencent.mm.plugin.wenote.model.a.g) cVar;
                gVar.lat = gVar2.lat;
                gVar.lng = gVar2.lng;
                gVar.scale = gVar2.scale;
                gVar.fBg = gVar2.fBg;
                gVar.eUu = gVar2.eUu;
                break;
            case 4:
                hVar = new l();
                l lVar = (l) hVar;
                l lVar2 = (l) cVar;
                lVar.uOD = lVar2.uOD;
                lVar.length = lVar2.length;
                lVar.uOC = lVar2.uOC;
                lVar.hNN = lVar2.hNN;
                lVar.cAP = lVar2.cAP;
                lVar.cAO = lVar2.cAO;
                lVar.uOf = lVar2.uOf;
                break;
            case 5:
                hVar = new com.tencent.mm.plugin.wenote.model.a.d();
                com.tencent.mm.plugin.wenote.model.a.d dVar = (com.tencent.mm.plugin.wenote.model.a.d) hVar;
                com.tencent.mm.plugin.wenote.model.a.d dVar2 = (com.tencent.mm.plugin.wenote.model.a.d) cVar;
                dVar.title = dVar2.title;
                dVar.content = dVar2.content;
                dVar.hNN = dVar2.hNN;
                dVar.uOf = dVar2.uOf;
                break;
            case 6:
                hVar = new k();
                k kVar = (k) hVar;
                k kVar2 = (k) cVar;
                kVar.thumbPath = kVar2.thumbPath;
                kVar.duration = kVar2.duration;
                kVar.uOf = kVar2.uOf;
                break;
            default:
                hVar = null;
                break;
        }
        if (hVar == null) {
            AppMethodBeat.o(26984);
            return null;
        }
        ((o) hVar).type = ((o) cVar).type;
        ((o) hVar).uOp = ((o) cVar).uOp;
        ((o) hVar).cHg = ((o) cVar).cHg;
        AppMethodBeat.o(26984);
        return hVar;
    }

    public static String d(com.tencent.mm.plugin.wenote.model.a.c cVar) {
        AppMethodBeat.i(26985);
        String str;
        if (cVar == null) {
            str = "";
            AppMethodBeat.o(26985);
            return str;
        } else if (cVar.getType() == 2) {
            str = ((com.tencent.mm.plugin.wenote.model.a.f) cVar).uOq;
            AppMethodBeat.o(26985);
            return str;
        } else {
            str = ((o) cVar).cHg;
            AppMethodBeat.o(26985);
            return str;
        }
    }

    public static String e(com.tencent.mm.plugin.wenote.model.a.c cVar) {
        AppMethodBeat.i(26986);
        String str;
        if (cVar == null) {
            str = "";
            AppMethodBeat.o(26986);
            return str;
        } else if (cVar.getType() == 2) {
            str = ((com.tencent.mm.plugin.wenote.model.a.f) cVar).cHg;
            AppMethodBeat.o(26986);
            return str;
        } else if (cVar.getType() == 6) {
            str = ((k) cVar).thumbPath;
            AppMethodBeat.o(26986);
            return str;
        } else {
            str = "";
            AppMethodBeat.o(26986);
            return str;
        }
    }

    public static int ahl(String str) {
        AppMethodBeat.i(26987);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(26987);
            return 0;
        }
        int ahn = ahn(b.ahh(str));
        AppMethodBeat.o(26987);
        return ahn;
    }

    public static int c(String str, int i, int i2, boolean z) {
        AppMethodBeat.i(26988);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(26988);
            return 0;
        }
        Spanned ahb = a.ahb(str);
        if (ahb == null) {
            AppMethodBeat.o(26988);
            return 0;
        }
        if (z) {
            i2 = ahb.length();
        }
        if (i < 0 || i > ahb.length() || i2 < 0 || i2 > ahb.length() || i > i2) {
            AppMethodBeat.o(26988);
            return 0;
        }
        ahb = (Spanned) ahb.subSequence(i, i2);
        if (ahb == null) {
            AppMethodBeat.o(26988);
            return 0;
        }
        int ahn = ahn(ahb.toString());
        AppMethodBeat.o(26988);
        return ahn;
    }

    public static int ahm(String str) {
        AppMethodBeat.i(26989);
        int intValue;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(26989);
            return 0;
        } else if (uSI.aj(str)) {
            intValue = ((Integer) uSI.get(str)).intValue();
            AppMethodBeat.o(26989);
            return intValue;
        } else {
            intValue = ahn(str);
            uSI.put(str, Integer.valueOf(intValue));
            AppMethodBeat.o(26989);
            return intValue;
        }
    }

    private static int ahn(String str) {
        int i = 0;
        AppMethodBeat.i(26990);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(26990);
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < str.length()) {
                i = x(str.charAt(i2)) + i3;
                i2++;
            } else {
                AppMethodBeat.o(26990);
                return i3;
            }
        }
    }

    private static int x(char c) {
        if (c <= 127) {
            return 1;
        }
        return 2;
    }

    public static String a(Context context, com.tencent.mm.plugin.wenote.model.a.c cVar) {
        AppMethodBeat.i(26991);
        String str;
        if (cVar == null) {
            str = "";
            AppMethodBeat.o(26991);
            return str;
        }
        int type = cVar.getType();
        if (type == 1) {
            str = ((i) cVar).content;
            AppMethodBeat.o(26991);
            return str;
        } else if (type == 3) {
            str = context.getString(R.string.g1a);
            AppMethodBeat.o(26991);
            return str;
        } else if (type == 2) {
            str = context.getString(R.string.g1_);
            AppMethodBeat.o(26991);
            return str;
        } else if (type == 6) {
            str = context.getString(R.string.g1b);
            AppMethodBeat.o(26991);
            return str;
        } else if (type == 4) {
            str = context.getString(R.string.g1c);
            AppMethodBeat.o(26991);
            return str;
        } else if (type == 5) {
            str = context.getString(R.string.g19);
            AppMethodBeat.o(26991);
            return str;
        } else {
            str = "";
            AppMethodBeat.o(26991);
            return str;
        }
    }

    public static String aho(String str) {
        AppMethodBeat.i(26992);
        String replaceAll = Pattern.compile("wa-b>", 2).matcher(Pattern.compile("<[/]?w(x|n)-[^>]*>", 2).matcher(Pattern.compile("</wn-todo>", 2).matcher(Pattern.compile("</wx-li>", 2).matcher(Pattern.compile("wx-b>", 2).matcher(str).replaceAll("wa-b>")).replaceAll("<br/>")).replaceAll("<br/>")).replaceAll("")).replaceAll("wx-b>");
        AppMethodBeat.o(26992);
        return replaceAll;
    }
}
