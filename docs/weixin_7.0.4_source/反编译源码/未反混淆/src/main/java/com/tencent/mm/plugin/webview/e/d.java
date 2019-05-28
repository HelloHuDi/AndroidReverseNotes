package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.s.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class d extends s {
    private List<a> kCH = new LinkedList();
    public long startTime = 0;

    public d() {
        AppMethodBeat.i(10144);
        AppMethodBeat.o(10144);
    }

    public final void ddc() {
        AppMethodBeat.i(10145);
        if (bo.ek(this.kCH)) {
            AppMethodBeat.o(10145);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (a aVar : this.kCH) {
            stringBuilder.append("[");
            stringBuilder.append(aVar.key);
            stringBuilder.append(": ");
            stringBuilder.append(aVar.time);
            if (aVar.time > this.startTime) {
                stringBuilder.append(", ").append(aVar.time - this.startTime);
            }
            if (!bo.isNullOrNil(aVar.detail)) {
                stringBuilder.append(", ").append(aVar.detail);
            }
            stringBuilder.append("] ");
        }
        ab.i("MicroMsg.WebViewPerformanceHelper", "webview Performance: %s", stringBuilder.toString());
        this.kCH.clear();
        AppMethodBeat.o(10145);
    }
}
