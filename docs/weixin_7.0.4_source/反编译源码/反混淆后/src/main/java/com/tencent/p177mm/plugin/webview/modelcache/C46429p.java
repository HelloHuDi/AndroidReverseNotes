package com.tencent.p177mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.p */
public final class C46429p {
    private final C14522k unY;
    public final SparseArray<Object> unZ;
    public final SparseArray<Boolean> uoa;

    /* renamed from: com.tencent.mm.plugin.webview.modelcache.p$a */
    public static final class C40275a {
        private static final C46429p uob = new C46429p();

        static {
            AppMethodBeat.m2504i(6864);
            AppMethodBeat.m2505o(6864);
        }
    }

    /* synthetic */ C46429p(byte b) {
        this();
    }

    private C46429p() {
        AppMethodBeat.m2504i(6865);
        this.unY = new C14522k();
        this.unZ = new SparseArray();
        this.uoa = new SparseArray();
        AppMethodBeat.m2505o(6865);
    }

    public static boolean aeI(String str) {
        AppMethodBeat.m2504i(6866);
        C40275a.uob;
        C5046bo.isNullOrNil(str);
        AppMethodBeat.m2505o(6866);
        return false;
    }
}
