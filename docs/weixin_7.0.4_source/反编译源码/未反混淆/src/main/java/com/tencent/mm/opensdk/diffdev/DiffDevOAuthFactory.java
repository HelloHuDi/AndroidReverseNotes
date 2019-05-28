package com.tencent.mm.opensdk.diffdev;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;

public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    private static IDiffDevOAuth v1Instance = null;

    private DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        AppMethodBeat.i(128058);
        IDiffDevOAuth diffDevOAuth = getDiffDevOAuth(1);
        AppMethodBeat.o(128058);
        return diffDevOAuth;
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i) {
        AppMethodBeat.i(128059);
        Log.v(TAG, "getDiffDevOAuth, version = ".concat(String.valueOf(i)));
        if (i > 1) {
            Log.e(TAG, "getDiffDevOAuth fail, unsupported version = ".concat(String.valueOf(i)));
            AppMethodBeat.o(128059);
            return null;
        }
        switch (i) {
            case 1:
                if (v1Instance == null) {
                    v1Instance = new a();
                }
                IDiffDevOAuth iDiffDevOAuth = v1Instance;
                AppMethodBeat.o(128059);
                return iDiffDevOAuth;
            default:
                AppMethodBeat.o(128059);
                return null;
        }
    }
}
