package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class b implements com.tencent.mm.plugin.welab.a.a.b {
    public final void f(Activity activity, String str) {
        AppMethodBeat.i(26579);
        if (aa.HU(0)) {
            Intent cVd = aa.cVd();
            cVd.putExtra("ftsbizscene", 20);
            Map d = aa.d(20, true, 0);
            cVd.putExtra("ftsneedkeyboard", true);
            cVd.putExtra("rawUrl", aa.E(d));
            d.b((Context) activity, "webview", ".ui.tools.fts.FTSSearchOneSearchWebViewUI", cVd);
            AppMethodBeat.o(26579);
            return;
        }
        ab.e("MicroMsg.FTS.SearchOneSearchOpener", "fts h5 template not avail");
        AppMethodBeat.o(26579);
    }

    public final String ddq() {
        AppMethodBeat.i(26580);
        String optString = ac.adL("discoverSearchEntry").optString("labIcon");
        AppMethodBeat.o(26580);
        return optString;
    }

    public final String ddr() {
        AppMethodBeat.i(26581);
        String optString = ac.adL("discoverSearchEntry").optString("wording");
        if (bo.isNullOrNil(optString)) {
            optString = ah.getContext().getString(R.string.btu);
            AppMethodBeat.o(26581);
            return optString;
        }
        AppMethodBeat.o(26581);
        return optString;
    }
}
