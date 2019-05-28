package com.tencent.p177mm.p612ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.chatting.ao */
public final class C44290ao {
    private static LinkedList<View> yMJ = new LinkedList();
    private static LinkedList<View> yMK = new LinkedList();
    private static LinkedList<View> yML = new LinkedList();

    static {
        AppMethodBeat.m2504i(70052);
        AppMethodBeat.m2505o(70052);
    }

    /* renamed from: Ot */
    public static View m80046Ot(int i) {
        AppMethodBeat.m2504i(70049);
        LinkedList linkedList = i == 1 ? yMJ : i == 2 ? yMK : yML;
        if (linkedList.size() != 0) {
            View view = (View) linkedList.removeFirst();
            AppMethodBeat.m2505o(70049);
            return view;
        }
        AppMethodBeat.m2505o(70049);
        return null;
    }

    /* renamed from: aj */
    public static void m80047aj(View view, int i) {
        AppMethodBeat.m2504i(70050);
        LinkedList linkedList = i == 1 ? yMJ : i == 2 ? yMK : yML;
        if (linkedList.size() >= 35) {
            linkedList.removeFirst();
        }
        linkedList.addLast(view);
        AppMethodBeat.m2505o(70050);
    }

    public static void clear() {
        AppMethodBeat.m2504i(70051);
        yMJ.clear();
        yMK.clear();
        yML.clear();
        AppMethodBeat.m2505o(70051);
    }
}
