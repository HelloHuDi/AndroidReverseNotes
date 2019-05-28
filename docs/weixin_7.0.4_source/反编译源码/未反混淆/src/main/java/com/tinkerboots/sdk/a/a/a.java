package com.tinkerboots.sdk.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.util.b;
import com.tinkerboots.sdk.b.c;
import com.tinkerboots.sdk.b.d;
import java.util.Map;

public class a implements b {
    public boolean bGs() {
        AppMethodBeat.i(65530);
        Context context = c.getContext();
        com.tencent.tinker.lib.e.a iX = com.tencent.tinker.lib.e.a.iX(context);
        if (!com.tinkerboots.sdk.b.a.isConnected(context)) {
            com.tencent.tinker.lib.util.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, not connect to internet", new Object[0]);
            AppMethodBeat.o(65530);
            return false;
        } else if (b.iZ(context)) {
            com.tencent.tinker.lib.util.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, tinker service is running", new Object[0]);
            AppMethodBeat.o(65530);
            return false;
        } else if (!iX.rNw) {
            com.tencent.tinker.lib.util.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, only request on the main process", new Object[0]);
            AppMethodBeat.o(65530);
            return false;
        } else if (d.dWn()) {
            com.tencent.tinker.lib.util.a.e("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, is in ignore channel, current channel:%s", d.dWm());
            AppMethodBeat.o(65530);
            return false;
        } else {
            AppMethodBeat.o(65530);
            return true;
        }
    }

    public void L(Map<String, String> map) {
    }

    public void bGt() {
    }
}
