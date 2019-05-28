package com.tencent.p177mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.wenote.model.f */
public final class C14719f {
    /* renamed from: aC */
    public static String m22905aC(float f) {
        AppMethodBeat.m2504i(26605);
        String format;
        if (f < 1024.0f) {
            format = String.format("%.1fB", new Object[]{Float.valueOf(f)});
            AppMethodBeat.m2505o(26605);
            return format;
        } else if (f < 1048576.0f) {
            format = String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
            AppMethodBeat.m2505o(26605);
            return format;
        } else if (f < 1.07374182E9f) {
            format = String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
            AppMethodBeat.m2505o(26605);
            return format;
        } else {
            format = String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
            AppMethodBeat.m2505o(26605);
            return format;
        }
    }

    /* renamed from: fY */
    public static float m22908fY(long j) {
        float f = 1.0f;
        AppMethodBeat.m2504i(26606);
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        f = (float) Math.round(f);
        AppMethodBeat.m2505o(26606);
        return f;
    }

    /* renamed from: K */
    public static String m22903K(Context context, int i) {
        AppMethodBeat.m2504i(26607);
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 21;
        c37721gh.cAH.context = context;
        c37721gh.cAH.cAP = i;
        C4879a.xxA.mo10055m(c37721gh);
        String str = c37721gh.cAI.path;
        AppMethodBeat.m2505o(26607);
        return str;
    }

    public static String agW(String str) {
        AppMethodBeat.m2504i(26608);
        String x = C1178g.m2591x((str + 18 + System.currentTimeMillis()).getBytes());
        AppMethodBeat.m2505o(26608);
        return x;
    }

    /* renamed from: c */
    public static String m22907c(aar aar) {
        AppMethodBeat.m2504i(26609);
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 27;
        c37721gh.cAH.cAJ = aar;
        C4879a.xxA.mo10055m(c37721gh);
        String str = c37721gh.cAI.thumbPath;
        AppMethodBeat.m2505o(26609);
        return str;
    }

    /* renamed from: o */
    public static String m22910o(aar aar) {
        AppMethodBeat.m2504i(26610);
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 27;
        c37721gh.cAH.cAJ = aar;
        C4879a.xxA.mo10055m(c37721gh);
        String str = c37721gh.cAI.path;
        AppMethodBeat.m2505o(26610);
        return str;
    }

    /* renamed from: jD */
    public static C27966g m22909jD(long j) {
        AppMethodBeat.m2504i(26611);
        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(j);
        AppMethodBeat.m2505o(26611);
        return iE;
    }

    /* renamed from: y */
    public static void m22911y(long j, String str) {
        AppMethodBeat.m2504i(26612);
        if (j <= 0) {
            AppMethodBeat.m2505o(26612);
            return;
        }
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 34;
        c37721gh.cAH.cvv = j;
        C4879a.xxA.mo10055m(c37721gh);
        if (c37721gh.cAH.cvC == null) {
            AppMethodBeat.m2505o(26612);
        } else if (c37721gh.cAH.cvC.wiv == null || c37721gh.cAH.cvC.wiv.size() <= 1) {
            AppMethodBeat.m2505o(26612);
        } else if (((aar) c37721gh.cAH.cvC.wiv.get(0)).whb != null) {
            AppMethodBeat.m2505o(26612);
        } else {
            C4990ab.m7416i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
            if (!C5046bo.isNullOrNil(str) && C5730e.m8628ct(str)) {
                try {
                    C14719f.m22904a(c37721gh.cAH.cvC, j, C5730e.m8631cy(str));
                    AppMethodBeat.m2505o(26612);
                    return;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.WNNoteFavLogic", "Note: FileNotFoundException :%s", e.getMessage());
                }
            }
            AppMethodBeat.m2505o(26612);
        }
    }

    /* renamed from: a */
    private static void m22904a(abf abf, long j, String str) {
        AppMethodBeat.m2504i(26613);
        ArrayList arrayList = new ArrayList();
        if (C5046bo.isNullOrNil(str) || str.length() == 0) {
            AppMethodBeat.m2505o(26613);
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
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 33;
        c37721gh.cAH.cvC = abf;
        c37721gh.cAH.cvC.wiv = linkedList;
        c37721gh.cAH.cvv = j;
        C4879a.xxA.mo10055m(c37721gh);
        AppMethodBeat.m2505o(26613);
    }

    /* renamed from: ad */
    public static void m22906ad(ArrayList<String> arrayList) {
        int i = 0;
        AppMethodBeat.m2504i(26614);
        if (C46453c.ddG().uMN == null) {
            C4990ab.m7412e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
            AppMethodBeat.m2505o(26614);
            return;
        }
        abf abf = C46453c.ddG().uMN.uMZ;
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        if (abf == null) {
            C4990ab.m7412e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
            AppMethodBeat.m2505o(26614);
            return;
        }
        aar aar;
        Iterator it = abf.wiv.iterator();
        while (it.hasNext()) {
            aar = (aar) it.next();
            if (!(C5046bo.isNullOrNil(aar.whb) || aar.whb.contains("WeNoteHtmlFile") || aar.whb.contains("-1"))) {
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
                abf.mo74738aE(linkedList);
                C14719f.ddI();
                hashMap.clear();
            }
            AppMethodBeat.m2505o(26614);
            return;
        }
        arrayList2.removeAll(arrayList);
        if (arrayList2.size() == 0) {
            AppMethodBeat.m2505o(26614);
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
        C14719f.ddI();
        AppMethodBeat.m2505o(26614);
    }

    private static void ddI() {
        AppMethodBeat.m2504i(26615);
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 30;
        if (C46453c.ddG().uMN != null) {
            c37721gh.cAH.cvC = C46453c.ddG().uMN.uMZ;
            C4879a.xxA.mo10055m(c37721gh);
            C46453c.ddG().uMN.agU(c37721gh.cAI.path);
        }
        AppMethodBeat.m2505o(26615);
    }
}
