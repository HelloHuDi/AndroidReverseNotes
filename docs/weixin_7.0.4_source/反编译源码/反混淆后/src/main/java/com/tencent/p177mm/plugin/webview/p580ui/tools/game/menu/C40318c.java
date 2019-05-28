package com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.protocal.protobuf.bbb;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.c */
public final class C40318c {

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.c$1 */
    static class C229791 implements Comparator<bbb> {
        C229791() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((bbb) obj).wFR - ((bbb) obj2).wFR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.c$a */
    public enum C22980a {
        HVGAME_MENU_ACTION_DEFAULT(0),
        HVGAME_MENU_ACTION_JUMP_H5(1),
        HVGAME_MENU_ACTION_EXIT(2),
        HVGAME_MENU_ACTION_SHARE_TO_FRIEND(3),
        HVGAME_MENU_ACTION_COLLECT(4),
        HVGAME_MENU_ACTION_REFRESH(7),
        HVGAME_MENU_ACTION_ADD_TO_DESKTOP(8),
        HVGAME_MENU_ACTION_COMPLAINT(9),
        HVGAME_MENU_ACTION_CUSTOM(10);
        
        private static EnumMap<C22980a, Integer> uEG;
        int code;

        static {
            uEG = new EnumMap(C22980a.class);
            Iterator it = EnumSet.allOf(C22980a.class).iterator();
            while (it.hasNext()) {
                C22980a c22980a = (C22980a) it.next();
                uEG.put(c22980a, Integer.valueOf(c22980a.code));
            }
            AppMethodBeat.m2505o(8815);
        }

        private C22980a(int i) {
            this.code = i;
        }

        /* renamed from: JH */
        public static boolean m34854JH(int i) {
            AppMethodBeat.m2504i(8813);
            boolean containsValue = uEG.containsValue(Integer.valueOf(i));
            AppMethodBeat.m2505o(8813);
            return containsValue;
        }

        /* renamed from: JI */
        public static C22980a m34855JI(int i) {
            C22980a c22980a;
            AppMethodBeat.m2504i(8814);
            for (Entry entry : uEG.entrySet()) {
                if (((Integer) entry.getValue()).intValue() == i) {
                    c22980a = (C22980a) entry.getKey();
                    AppMethodBeat.m2505o(8814);
                    return c22980a;
                }
            }
            c22980a = HVGAME_MENU_ACTION_DEFAULT;
            AppMethodBeat.m2505o(8814);
            return c22980a;
        }
    }

    /* renamed from: c */
    public static C44273l m69161c(Context context, List<bbb> list) {
        AppMethodBeat.m2504i(8816);
        if (C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(8816);
            return null;
        }
        ArrayList<bbb> arrayList = new ArrayList();
        for (bbb bbb : list) {
            if (bbb != null && C22980a.m34854JH(bbb.wkB)) {
                arrayList.add(bbb);
            }
        }
        if (C5046bo.m7548ek(arrayList)) {
            AppMethodBeat.m2505o(8816);
            return null;
        }
        Collections.sort(arrayList, new C229791());
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
        C44273l c44273l = new C44273l(context);
        for (bbb bbb22 : arrayList2) {
            if (bbb22 == null) {
                c44273l.mo70068e(-1, "");
            } else {
                c44273l.mo70068e(bbb22.wFQ, bbb22.Title + "__" + bbb22.ThumbUrl);
            }
        }
        AppMethodBeat.m2505o(8816);
        return c44273l;
    }
}
