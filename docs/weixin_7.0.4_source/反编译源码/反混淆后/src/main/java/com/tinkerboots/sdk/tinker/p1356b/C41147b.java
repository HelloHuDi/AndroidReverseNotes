package com.tinkerboots.sdk.tinker.p1356b;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.p1577b.C46816a;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tinkerboots.sdk.p1355b.C44601d;
import java.io.File;

/* renamed from: com.tinkerboots.sdk.tinker.b.b */
public final class C41147b extends C46816a {
    public C41147b(Context context) {
        super(context);
    }

    /* renamed from: eI */
    public final int mo65729eI(String str, String str2) {
        int i = 0;
        AppMethodBeat.m2504i(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST);
        File file = new File(str);
        C5952a.m9284i("Tinker.TinkerServerPatchListener", "receive a patch file: %s, file size:%d", str, Long.valueOf(SharePatchFileUtil.m9372ar(file)));
        int eI = super.mo65729eI(str, str2);
        if (eI != 0) {
            i = eI;
        } else if (C44601d.dWn()) {
            i = -20;
        }
        AppMethodBeat.m2505o(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST);
        return i;
    }
}
