package com.tencent.p177mm.plugin.emoji.p381a.p946a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f.C11547a;
import com.tencent.p177mm.pluginsdk.model.C23249h;
import com.tencent.p177mm.pluginsdk.model.C23249h.C14889a;
import com.tencent.p177mm.pluginsdk.model.C44064n;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C44221ar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.emoji.a.a.b */
public final class C33945b {
    /* renamed from: tZ */
    private static boolean m55560tZ(int i) {
        return i == 7;
    }

    /* renamed from: ua */
    private static boolean m55561ua(int i) {
        return i == 6;
    }

    /* renamed from: a */
    public static void m55558a(C45842c c45842c, C14889a c14889a) {
        AppMethodBeat.m2504i(52774);
        if (!C1853r.m3830YL()) {
            AppMethodBeat.m2505o(52774);
        } else if (c45842c == null || c45842c.size() <= 0) {
            AppMethodBeat.m2505o(52774);
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = c45842c.iterator();
            while (it.hasNext()) {
                C11546f c11546f = (C11546f) it.next();
                if (!(c11546f == null || c11546f.kTa == C11547a.cellset)) {
                    EmotionSummary emotionSummary = c11546f.kTb;
                    boolean b = C27727e.m44037b(emotionSummary);
                    boolean a = C27727e.m44036a(emotionSummary);
                    if (!(b || a)) {
                        arrayList.add(emotionSummary.ProductID);
                        C44221ar IW = c45842c.mo73638IW(emotionSummary.ProductID);
                        if (IW != null) {
                            IW.xXX = 11;
                        }
                    }
                }
            }
            Context context = C4996ah.getContext();
            if (arrayList.size() > 0) {
                C23249h.m35678a(context, (String[]) arrayList.toArray(new String[arrayList.size()]), c14889a);
            }
            AppMethodBeat.m2505o(52774);
        }
    }

    /* renamed from: a */
    public static void m55559a(ArrayList<C44064n> arrayList, C45842c c45842c) {
        AppMethodBeat.m2504i(52775);
        if (!C1853r.m3830YL()) {
            AppMethodBeat.m2505o(52775);
        } else if (c45842c == null || arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.m2505o(52775);
        } else {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C44064n c44064n = (C44064n) it.next();
                if (c44064n != null) {
                    C4990ab.m7417i("MicroMsg.EmojiGoogleMarketTool", "endSeachGoogleMarket: %s", c44064n);
                    C44221ar IW = c45842c.mo73638IW(c44064n.cwg);
                    if (IW != null) {
                        int i;
                        if (c44064n.vbt == 10232) {
                            IW.xYb = c44064n.vbq;
                            IW.xXZ = c44064n.vbr;
                            IW.xYa = new BigDecimal(c44064n.vbs).divide(new BigDecimal(1000000)).toString();
                            IW.xXX = 12;
                            i = IW.xXV;
                            if (!(C33945b.m55560tZ(i) || C33945b.m55561ua(i))) {
                                IW.mo69859Mo(4);
                            }
                        } else {
                            IW.xXX = 10;
                            IW.xXY = c44064n.vbt;
                            i = IW.xXV;
                            if (!(C33945b.m55560tZ(i) || C33945b.m55561ua(i))) {
                                if (i == 3) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                if (i == 0) {
                                    IW.mo69859Mo(10);
                                }
                            }
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(52775);
        }
    }
}
