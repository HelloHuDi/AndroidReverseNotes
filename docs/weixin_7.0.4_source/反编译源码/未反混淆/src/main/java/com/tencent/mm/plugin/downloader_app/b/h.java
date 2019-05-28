package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h<E extends e> extends LinkedList<E> {
    public final int a(E e) {
        int i;
        Object obj;
        AppMethodBeat.i(136144);
        for (int i2 = 0; i2 < size(); i2++) {
            if (e.biK() < ((e) get(i2)).biK()) {
                i = i2;
                obj = 1;
                break;
            }
        }
        i = 0;
        obj = null;
        if (obj == null) {
            i = size();
        }
        add(i, e);
        AppMethodBeat.o(136144);
        return i;
    }

    public final int tP(int i) {
        AppMethodBeat.i(136145);
        int i2 = 0;
        for (int i3 = 0; i3 < size(); i3++) {
            if (((e) get(i3)).biK() == i) {
                i2++;
            }
        }
        AppMethodBeat.o(136145);
        return i2;
    }
}
