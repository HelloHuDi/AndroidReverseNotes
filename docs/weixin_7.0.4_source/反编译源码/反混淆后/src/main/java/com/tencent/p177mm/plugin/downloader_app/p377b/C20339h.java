package com.tencent.p177mm.plugin.downloader_app.p377b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.downloader_app.b.h */
public final class C20339h<E extends C20337e> extends LinkedList<E> {
    /* renamed from: a */
    public final int mo35575a(E e) {
        int i;
        Object obj;
        AppMethodBeat.m2504i(136144);
        for (int i2 = 0; i2 < size(); i2++) {
            if (e.biK() < ((C20337e) get(i2)).biK()) {
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
        AppMethodBeat.m2505o(136144);
        return i;
    }

    /* renamed from: tP */
    public final int mo35576tP(int i) {
        AppMethodBeat.m2504i(136145);
        int i2 = 0;
        for (int i3 = 0; i3 < size(); i3++) {
            if (((C20337e) get(i3)).biK() == i) {
                i2++;
            }
        }
        AppMethodBeat.m2505o(136145);
        return i2;
    }
}
