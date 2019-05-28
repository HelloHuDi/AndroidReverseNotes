package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/AppMsgContextEx;", "", "()V", "testClear", "", "plugin-brandservice_release"})
public final class a {
    public static final a jQI = new a();

    static {
        AppMethodBeat.i(14779);
        AppMethodBeat.o(14779);
    }

    private a() {
    }

    public static final void aWM() {
        AppMethodBeat.i(14778);
        long aWQ = (long) b.jQK;
        if (1 <= aWQ) {
            long j = 1;
            while (true) {
                b.gK(j).clear();
                if (j == aWQ) {
                    break;
                }
                j++;
            }
        }
        AppMethodBeat.o(14778);
    }
}
