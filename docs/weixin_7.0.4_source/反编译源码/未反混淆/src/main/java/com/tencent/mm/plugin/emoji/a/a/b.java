package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.pluginsdk.model.h.a;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    private static boolean tZ(int i) {
        return i == 7;
    }

    private static boolean ua(int i) {
        return i == 6;
    }

    public static void a(c cVar, a aVar) {
        AppMethodBeat.i(52774);
        if (!r.YL()) {
            AppMethodBeat.o(52774);
        } else if (cVar == null || cVar.size() <= 0) {
            AppMethodBeat.o(52774);
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = cVar.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (!(fVar == null || fVar.kTa == f.a.cellset)) {
                    EmotionSummary emotionSummary = fVar.kTb;
                    boolean b = e.b(emotionSummary);
                    boolean a = e.a(emotionSummary);
                    if (!(b || a)) {
                        arrayList.add(emotionSummary.ProductID);
                        ar IW = cVar.IW(emotionSummary.ProductID);
                        if (IW != null) {
                            IW.xXX = 11;
                        }
                    }
                }
            }
            Context context = ah.getContext();
            if (arrayList.size() > 0) {
                h.a(context, (String[]) arrayList.toArray(new String[arrayList.size()]), aVar);
            }
            AppMethodBeat.o(52774);
        }
    }

    public static void a(ArrayList<n> arrayList, c cVar) {
        AppMethodBeat.i(52775);
        if (!r.YL()) {
            AppMethodBeat.o(52775);
        } else if (cVar == null || arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.o(52775);
        } else {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                if (nVar != null) {
                    ab.i("MicroMsg.EmojiGoogleMarketTool", "endSeachGoogleMarket: %s", nVar);
                    ar IW = cVar.IW(nVar.cwg);
                    if (IW != null) {
                        int i;
                        if (nVar.vbt == 10232) {
                            IW.xYb = nVar.vbq;
                            IW.xXZ = nVar.vbr;
                            IW.xYa = new BigDecimal(nVar.vbs).divide(new BigDecimal(1000000)).toString();
                            IW.xXX = 12;
                            i = IW.xXV;
                            if (!(tZ(i) || ua(i))) {
                                IW.Mo(4);
                            }
                        } else {
                            IW.xXX = 10;
                            IW.xXY = nVar.vbt;
                            i = IW.xXV;
                            if (!(tZ(i) || ua(i))) {
                                if (i == 3) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                if (i == 0) {
                                    IW.Mo(10);
                                }
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(52775);
        }
    }
}
