package com.tencent.p177mm.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.api.u */
public final class C41757u {
    public static C17919a cda;

    /* renamed from: com.tencent.mm.api.u$a */
    public interface C17919a {
        /* renamed from: AI */
        C17918t mo33432AI();

        /* renamed from: aS */
        SmileyPanel mo33433aS(Context context);

        /* renamed from: j */
        SmileyPanel mo33434j(Context context, boolean z);
    }

    /* renamed from: aR */
    public static SmileyPanel m73612aR(Context context) {
        AppMethodBeat.m2504i(123958);
        SmileyPanel aS = cda.mo33433aS(context);
        AppMethodBeat.m2505o(123958);
        return aS;
    }

    /* renamed from: i */
    public static SmileyPanel m73613i(Context context, boolean z) {
        AppMethodBeat.m2504i(123959);
        SmileyPanel j = cda.mo33434j(context, z);
        AppMethodBeat.m2505o(123959);
        return j;
    }

    /* renamed from: AH */
    public static C17918t m73611AH() {
        AppMethodBeat.m2504i(123960);
        C17918t AI = cda.mo33432AI();
        AppMethodBeat.m2505o(123960);
        return AI;
    }
}
