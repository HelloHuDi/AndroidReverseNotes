package com.tencent.p177mm.plugin.music.model.p466d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.plugin.music.p1282c.C21339b;
import com.tencent.p177mm.plugin.music.p462e.C28559e;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;

/* renamed from: com.tencent.mm.plugin.music.model.d.c */
public final class C3540c {
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
    C21339b oNh;

    /* Access modifiers changed, original: final */
    public final String getMimeType() {
        String str;
        AppMethodBeat.m2504i(105010);
        String str2 = "";
        if (this.oNh != null) {
            str = this.oNh.mimeType;
        } else {
            str = str2;
        }
        if (TextUtils.isEmpty(str)) {
            C28575a bTU = ((C28559e) C43329b.m77295ar(C28559e.class)).bTU();
            if (bTU != null) {
                str = bTU.field_mimetype;
            }
        }
        AppMethodBeat.m2505o(105010);
        return str;
    }
}
