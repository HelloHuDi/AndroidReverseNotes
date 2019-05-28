package com.tencent.luggage.wxa.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, dWq = {"Lcom/tencent/luggage/wxa/storage/CriticalAuthorityResolver;", "", "()V", "resolveAuthority", "", "data-storage_release"})
/* renamed from: com.tencent.luggage.wxa.storage.b */
public final class C41715b {
    public static final C41715b bSa = new C41715b();

    static {
        AppMethodBeat.m2504i(94161);
        AppMethodBeat.m2505o(94161);
    }

    private C41715b() {
    }

    /* renamed from: ym */
    public static final String m73396ym() {
        AppMethodBeat.m2504i(94160);
        StringBuilder stringBuilder = new StringBuilder();
        Context context = C4996ah.getContext();
        C25052j.m39375o(context, "MMApplicationContext.getContext()");
        String stringBuilder2 = stringBuilder.append(context.getPackageName()).append(".wxa_critical_content").toString();
        AppMethodBeat.m2505o(94160);
        return stringBuilder2;
    }
}
