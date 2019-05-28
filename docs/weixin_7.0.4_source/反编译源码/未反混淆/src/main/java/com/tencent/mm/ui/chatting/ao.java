package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ao {
    private static LinkedList<View> yMJ = new LinkedList();
    private static LinkedList<View> yMK = new LinkedList();
    private static LinkedList<View> yML = new LinkedList();

    static {
        AppMethodBeat.i(70052);
        AppMethodBeat.o(70052);
    }

    public static View Ot(int i) {
        AppMethodBeat.i(70049);
        LinkedList linkedList = i == 1 ? yMJ : i == 2 ? yMK : yML;
        if (linkedList.size() != 0) {
            View view = (View) linkedList.removeFirst();
            AppMethodBeat.o(70049);
            return view;
        }
        AppMethodBeat.o(70049);
        return null;
    }

    public static void aj(View view, int i) {
        AppMethodBeat.i(70050);
        LinkedList linkedList = i == 1 ? yMJ : i == 2 ? yMK : yML;
        if (linkedList.size() >= 35) {
            linkedList.removeFirst();
        }
        linkedList.addLast(view);
        AppMethodBeat.o(70050);
    }

    public static void clear() {
        AppMethodBeat.i(70051);
        yMJ.clear();
        yMK.clear();
        yML.clear();
        AppMethodBeat.o(70051);
    }
}
