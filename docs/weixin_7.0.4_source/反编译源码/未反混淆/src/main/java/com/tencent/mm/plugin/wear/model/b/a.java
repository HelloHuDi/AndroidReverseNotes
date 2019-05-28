package com.tencent.mm.plugin.wear.model.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class a {
    public static void S(Bundle bundle) {
        AppMethodBeat.i(26368);
        Intent intent = new Intent();
        intent.setPackage(ah.getContext().getPackageName());
        intent.setAction("com.tencent.mm.wear.message");
        intent.putExtras(bundle);
        ah.getContext().sendBroadcast(intent);
        AppMethodBeat.o(26368);
    }
}
