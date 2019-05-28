package com.tencent.mm.console.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class b implements a {
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(16153);
        ab.i("MicroMsg.HCSettingCommand", "hcsetting args[%s] [%s]", Integer.valueOf(strArr.length), strArr[0]);
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mm.ui.tools.HardCoderSettingUI");
        context.startActivity(intent);
        AppMethodBeat.o(16153);
        return true;
    }
}
