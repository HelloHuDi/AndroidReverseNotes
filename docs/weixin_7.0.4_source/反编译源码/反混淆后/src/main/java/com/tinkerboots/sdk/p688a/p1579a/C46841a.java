package com.tinkerboots.sdk.p688a.p1579a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.util.C31098b;
import com.tencent.tinker.lib.util.C5952a;
import com.tinkerboots.sdk.p1355b.C24572a;
import com.tinkerboots.sdk.p1355b.C31174c;
import com.tinkerboots.sdk.p1355b.C44601d;
import java.util.Map;

/* renamed from: com.tinkerboots.sdk.a.a.a */
public class C46841a implements C41146b {
    public boolean bGs() {
        AppMethodBeat.m2504i(65530);
        Context context = C31174c.getContext();
        C31097a iX = C31097a.m50180iX(context);
        if (!C24572a.isConnected(context)) {
            C5952a.m9284i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, not connect to internet", new Object[0]);
            AppMethodBeat.m2505o(65530);
            return false;
        } else if (C31098b.m50187iZ(context)) {
            C5952a.m9284i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, tinker service is running", new Object[0]);
            AppMethodBeat.m2505o(65530);
            return false;
        } else if (!iX.rNw) {
            C5952a.m9284i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, only request on the main process", new Object[0]);
            AppMethodBeat.m2505o(65530);
            return false;
        } else if (C44601d.dWn()) {
            C5952a.m9283e("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, is in ignore channel, current channel:%s", C44601d.dWm());
            AppMethodBeat.m2505o(65530);
            return false;
        } else {
            AppMethodBeat.m2505o(65530);
            return true;
        }
    }

    /* renamed from: L */
    public void mo36395L(Map<String, String> map) {
    }

    public void bGt() {
    }
}
