package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class g extends a {
    public static final int CTRL_INDEX = 217;
    public static final String NAME = "saveImageToPhotosAlbum";

    /* Access modifiers changed, original: final */
    public final boolean Bk(String str) {
        AppMethodBeat.i(114367);
        boolean contains = bo.nullAsNil(str).toLowerCase().contains("image");
        AppMethodBeat.o(114367);
        return contains;
    }

    /* Access modifiers changed, original: final */
    public final String Bl(String str) {
        AppMethodBeat.i(114368);
        String RL = a.RL(str);
        AppMethodBeat.o(114368);
        return RL;
    }

    /* Access modifiers changed, original: final */
    public final void Bm(String str) {
        AppMethodBeat.i(114369);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(114366);
                Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.b3r, new Object[]{a.dlz()}), 1).show();
                AppMethodBeat.o(114366);
            }
        });
        AppMethodBeat.o(114369);
    }
}
