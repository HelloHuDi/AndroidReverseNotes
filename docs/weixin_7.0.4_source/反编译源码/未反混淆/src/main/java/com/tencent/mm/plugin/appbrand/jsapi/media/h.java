package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class h extends a {
    public static final int CTRL_INDEX = 216;
    public static final String NAME = "saveVideoToPhotosAlbum";

    /* Access modifiers changed, original: final */
    public final boolean Bk(String str) {
        AppMethodBeat.i(114371);
        boolean contains = bo.nullAsNil(str).toLowerCase().contains("video");
        AppMethodBeat.o(114371);
        return contains;
    }

    /* Access modifiers changed, original: final */
    public final String Bl(String str) {
        AppMethodBeat.i(114372);
        String RL = a.RL("mp4");
        AppMethodBeat.o(114372);
        return RL;
    }

    /* Access modifiers changed, original: final */
    public final void Bm(final String str) {
        AppMethodBeat.i(114373);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(114370);
                Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.f1d, new Object[]{str}), 1).show();
                AppMethodBeat.o(114370);
            }
        });
        AppMethodBeat.o(114373);
    }
}
