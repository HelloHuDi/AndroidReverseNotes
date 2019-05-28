package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class c {

    public enum a {
        HVGAME_MENU_ACTION_DEFAULT(0),
        HVGAME_MENU_ACTION_JUMP_H5(1),
        HVGAME_MENU_ACTION_EXIT(2),
        HVGAME_MENU_ACTION_SHARE_TO_FRIEND(3),
        HVGAME_MENU_ACTION_COLLECT(4),
        HVGAME_MENU_ACTION_REFRESH(7),
        HVGAME_MENU_ACTION_ADD_TO_DESKTOP(8),
        HVGAME_MENU_ACTION_COMPLAINT(9),
        HVGAME_MENU_ACTION_CUSTOM(10);
        
        private static EnumMap<a, Integer> uEG;
        int code;

        static {
            uEG = new EnumMap(a.class);
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                uEG.put(aVar, Integer.valueOf(aVar.code));
            }
            AppMethodBeat.o(8815);
        }

        private a(int i) {
            this.code = i;
        }

        public static boolean JH(int i) {
            AppMethodBeat.i(8813);
            boolean containsValue = uEG.containsValue(Integer.valueOf(i));
            AppMethodBeat.o(8813);
            return containsValue;
        }

        public static a JI(int i) {
            a aVar;
            AppMethodBeat.i(8814);
            for (Entry entry : uEG.entrySet()) {
                if (((Integer) entry.getValue()).intValue() == i) {
                    aVar = (a) entry.getKey();
                    AppMethodBeat.o(8814);
                    return aVar;
                }
            }
            aVar = HVGAME_MENU_ACTION_DEFAULT;
            AppMethodBeat.o(8814);
            return aVar;
        }
    }

    public static l c(Context context, List<bbb> list) {
        AppMethodBeat.i(8816);
        if (bo.ek(list)) {
            AppMethodBeat.o(8816);
            return null;
        }
        ArrayList<bbb> arrayList = new ArrayList();
        for (bbb bbb : list) {
            if (bbb != null && a.JH(bbb.wkB)) {
                arrayList.add(bbb);
            }
        }
        if (bo.ek(arrayList)) {
            AppMethodBeat.o(8816);
            return null;
        }
        Collections.sort(arrayList, new Comparator<bbb>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((bbb) obj).wFR - ((bbb) obj2).wFR;
            }
        });
        int i = ((bbb) arrayList.get(arrayList.size() - 1)).wFR;
        ArrayList<bbb> arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList2.add(null);
        }
        for (bbb bbb2 : arrayList) {
            if (bbb2.wFR > 0 && bbb2.wFR <= arrayList2.size()) {
                arrayList2.set(bbb2.wFR - 1, bbb2);
            }
        }
        l lVar = new l(context);
        for (bbb bbb22 : arrayList2) {
            if (bbb22 == null) {
                lVar.e(-1, "");
            } else {
                lVar.e(bbb22.wFQ, bbb22.Title + "__" + bbb22.ThumbUrl);
            }
        }
        AppMethodBeat.o(8816);
        return lVar;
    }
}
