package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    public static String aC(float f) {
        AppMethodBeat.i(26605);
        String format;
        if (f < 1024.0f) {
            format = String.format("%.1fB", new Object[]{Float.valueOf(f)});
            AppMethodBeat.o(26605);
            return format;
        } else if (f < 1048576.0f) {
            format = String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
            AppMethodBeat.o(26605);
            return format;
        } else if (f < 1.07374182E9f) {
            format = String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
            AppMethodBeat.o(26605);
            return format;
        } else {
            format = String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
            AppMethodBeat.o(26605);
            return format;
        }
    }

    public static float fY(long j) {
        float f = 1.0f;
        AppMethodBeat.i(26606);
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        f = (float) Math.round(f);
        AppMethodBeat.o(26606);
        return f;
    }

    public static String K(Context context, int i) {
        AppMethodBeat.i(26607);
        gh ghVar = new gh();
        ghVar.cAH.type = 21;
        ghVar.cAH.context = context;
        ghVar.cAH.cAP = i;
        a.xxA.m(ghVar);
        String str = ghVar.cAI.path;
        AppMethodBeat.o(26607);
        return str;
    }

    public static String agW(String str) {
        AppMethodBeat.i(26608);
        String x = g.x((str + 18 + System.currentTimeMillis()).getBytes());
        AppMethodBeat.o(26608);
        return x;
    }

    public static String c(aar aar) {
        AppMethodBeat.i(26609);
        gh ghVar = new gh();
        ghVar.cAH.type = 27;
        ghVar.cAH.cAJ = aar;
        a.xxA.m(ghVar);
        String str = ghVar.cAI.thumbPath;
        AppMethodBeat.o(26609);
        return str;
    }

    public static String o(aar aar) {
        AppMethodBeat.i(26610);
        gh ghVar = new gh();
        ghVar.cAH.type = 27;
        ghVar.cAH.cAJ = aar;
        a.xxA.m(ghVar);
        String str = ghVar.cAI.path;
        AppMethodBeat.o(26610);
        return str;
    }

    public static com.tencent.mm.plugin.fav.a.g jD(long j) {
        AppMethodBeat.i(26611);
        com.tencent.mm.plugin.fav.a.g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(j);
        AppMethodBeat.o(26611);
        return iE;
    }

    public static void y(long j, String str) {
        AppMethodBeat.i(26612);
        if (j <= 0) {
            AppMethodBeat.o(26612);
            return;
        }
        gh ghVar = new gh();
        ghVar.cAH.type = 34;
        ghVar.cAH.cvv = j;
        a.xxA.m(ghVar);
        if (ghVar.cAH.cvC == null) {
            AppMethodBeat.o(26612);
        } else if (ghVar.cAH.cvC.wiv == null || ghVar.cAH.cvC.wiv.size() <= 1) {
            AppMethodBeat.o(26612);
        } else if (((aar) ghVar.cAH.cvC.wiv.get(0)).whb != null) {
            AppMethodBeat.o(26612);
        } else {
            ab.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
            if (!bo.isNullOrNil(str) && e.ct(str)) {
                try {
                    a(ghVar.cAH.cvC, j, e.cy(str));
                    AppMethodBeat.o(26612);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.WNNoteFavLogic", "Note: FileNotFoundException :%s", e.getMessage());
                }
            }
            AppMethodBeat.o(26612);
        }
    }

    private static void a(abf abf, long j, String str) {
        AppMethodBeat.i(26613);
        ArrayList arrayList = new ArrayList();
        if (bo.isNullOrNil(str) || str.length() == 0) {
            AppMethodBeat.o(26613);
            return;
        }
        int indexOf;
        Matcher matcher = Pattern.compile("<object[^>]*>", 2).matcher(str);
        String str2 = "WeNote_";
        while (matcher.find()) {
            String group = matcher.group();
            int indexOf2 = group.indexOf(str2);
            if (indexOf2 == -1) {
                break;
            }
            int indexOf3 = group.indexOf("\"", indexOf2 + 1);
            if (indexOf3 == -1) {
                break;
            }
            indexOf = group.indexOf(" ", indexOf2 + 1);
            if (indexOf == -1) {
                break;
            }
            if (indexOf3 >= indexOf) {
                indexOf3 = indexOf;
            }
            arrayList.add(group.substring(indexOf2, indexOf3));
        }
        LinkedList linkedList = new LinkedList();
        Iterator it = abf.wiv.iterator();
        indexOf = 0;
        int i = 0;
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            int i2;
            if (i == 0) {
                aar.ale("WeNoteHtmlFile");
                i2 = i + 1;
                linkedList.add(aar);
                i = i2;
            } else {
                if (aar.dataType == 1) {
                    aar.ale("-1");
                } else {
                    i2 = indexOf + 1;
                    aar.ale((String) arrayList.get(indexOf));
                    indexOf = i2;
                }
                linkedList.add(aar);
            }
        }
        gh ghVar = new gh();
        ghVar.cAH.type = 33;
        ghVar.cAH.cvC = abf;
        ghVar.cAH.cvC.wiv = linkedList;
        ghVar.cAH.cvv = j;
        a.xxA.m(ghVar);
        AppMethodBeat.o(26613);
    }

    public static void ad(ArrayList<String> arrayList) {
        int i = 0;
        AppMethodBeat.i(26614);
        if (c.ddG().uMN == null) {
            ab.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
            AppMethodBeat.o(26614);
            return;
        }
        abf abf = c.ddG().uMN.uMZ;
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        if (abf == null) {
            ab.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
            AppMethodBeat.o(26614);
            return;
        }
        aar aar;
        Iterator it = abf.wiv.iterator();
        while (it.hasNext()) {
            aar = (aar) it.next();
            if (!(bo.isNullOrNil(aar.whb) || aar.whb.contains("WeNoteHtmlFile") || aar.whb.contains("-1"))) {
                arrayList2.add(aar.whb);
                hashMap.put(aar.whb, aar);
            }
        }
        if (arrayList.size() == arrayList2.size() && arrayList2.containsAll(arrayList) && arrayList.containsAll(arrayList2)) {
            int i2;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                if (!((String) arrayList2.get(i3)).trim().equals(((String) arrayList.get(i3)).trim())) {
                    i2 = 1;
                    break;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                LinkedList linkedList = new LinkedList();
                while (i < arrayList.size()) {
                    linkedList.add(hashMap.get(arrayList.get(i)));
                    i++;
                }
                abf.aE(linkedList);
                ddI();
                hashMap.clear();
            }
            AppMethodBeat.o(26614);
            return;
        }
        arrayList2.removeAll(arrayList);
        if (arrayList2.size() == 0) {
            AppMethodBeat.o(26614);
            return;
        }
        ArrayList<aar> arrayList3 = new ArrayList();
        Iterator it2 = abf.wiv.iterator();
        while (it2.hasNext()) {
            aar = (aar) it2.next();
            if (arrayList2.contains(aar.whb)) {
                arrayList3.add(aar);
            }
        }
        for (aar aar2 : arrayList3) {
            abf.wiv.remove(aar2);
        }
        ddI();
        AppMethodBeat.o(26614);
    }

    private static void ddI() {
        AppMethodBeat.i(26615);
        gh ghVar = new gh();
        ghVar.cAH.type = 30;
        if (c.ddG().uMN != null) {
            ghVar.cAH.cvC = c.ddG().uMN.uMZ;
            a.xxA.m(ghVar);
            c.ddG().uMN.agU(ghVar.cAI.path);
        }
        AppMethodBeat.o(26615);
    }
}
