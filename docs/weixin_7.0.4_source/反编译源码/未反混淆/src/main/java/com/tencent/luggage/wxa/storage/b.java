package com.tencent.luggage.wxa.storage;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, dWq = {"Lcom/tencent/luggage/wxa/storage/CriticalAuthorityResolver;", "", "()V", "resolveAuthority", "", "data-storage_release"})
public final class b {
    public static final b bSa = new b();

    static {
        AppMethodBeat.i(94161);
        AppMethodBeat.o(94161);
    }

    private b() {
    }

    public static final String ym() {
        AppMethodBeat.i(94160);
        StringBuilder stringBuilder = new StringBuilder();
        Context context = ah.getContext();
        j.o(context, "MMApplicationContext.getContext()");
        String stringBuilder2 = stringBuilder.append(context.getPackageName()).append(".wxa_critical_content").toString();
        AppMethodBeat.o(94160);
        return stringBuilder2;
    }
}
