package com.tinkerboots.sdk.tinker.b;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.b.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tinkerboots.sdk.b.d;
import java.io.File;

public final class b extends a {
    public b(Context context) {
        super(context);
    }

    public final int eI(String str, String str2) {
        int i = 0;
        AppMethodBeat.i(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST);
        File file = new File(str);
        com.tencent.tinker.lib.util.a.i("Tinker.TinkerServerPatchListener", "receive a patch file: %s, file size:%d", str, Long.valueOf(SharePatchFileUtil.ar(file)));
        int eI = super.eI(str, str2);
        if (eI != 0) {
            i = eI;
        } else if (d.dWn()) {
            i = -20;
        }
        AppMethodBeat.o(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST);
        return i;
    }
}
