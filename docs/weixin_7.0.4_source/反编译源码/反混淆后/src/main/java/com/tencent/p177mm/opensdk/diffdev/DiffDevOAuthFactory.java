package com.tencent.p177mm.opensdk.diffdev;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.diffdev.p1214a.C42250a;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.diffdev.DiffDevOAuthFactory */
public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    private static IDiffDevOAuth v1Instance = null;

    private DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        AppMethodBeat.m2504i(128058);
        IDiffDevOAuth diffDevOAuth = DiffDevOAuthFactory.getDiffDevOAuth(1);
        AppMethodBeat.m2505o(128058);
        return diffDevOAuth;
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i) {
        AppMethodBeat.m2504i(128059);
        Log.m4142v(TAG, "getDiffDevOAuth, version = ".concat(String.valueOf(i)));
        if (i > 1) {
            Log.m4140e(TAG, "getDiffDevOAuth fail, unsupported version = ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(128059);
            return null;
        }
        switch (i) {
            case 1:
                if (v1Instance == null) {
                    v1Instance = new C42250a();
                }
                IDiffDevOAuth iDiffDevOAuth = v1Instance;
                AppMethodBeat.m2505o(128059);
                return iDiffDevOAuth;
            default:
                AppMethodBeat.m2505o(128059);
                return null;
        }
    }
}
