package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.c.b;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.model.e.a;

public final class c {
    boolean oMX = false;
    boolean oMY = false;
    boolean oMZ = false;
    boolean oNa = false;
    boolean oNb = false;
    boolean oNc = false;
    boolean oNd = false;
    boolean oNe = false;
    boolean oNf = false;
    int oNg = 0;
    b oNh;

    /* Access modifiers changed, original: final */
    public final String getMimeType() {
        String str;
        AppMethodBeat.i(105010);
        String str2 = "";
        if (this.oNh != null) {
            str = this.oNh.mimeType;
        } else {
            str = str2;
        }
        if (TextUtils.isEmpty(str)) {
            a bTU = ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTU();
            if (bTU != null) {
                str = bTU.field_mimetype;
            }
        }
        AppMethodBeat.o(105010);
        return str;
    }
}
