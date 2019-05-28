package com.tencent.p177mm.plugin.appbrand.jsapi.media;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.p1574f.C40612a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.h */
public final class C27036h extends C19443a {
    public static final int CTRL_INDEX = 216;
    public static final String NAME = "saveVideoToPhotosAlbum";

    /* Access modifiers changed, original: final */
    /* renamed from: Bk */
    public final boolean mo34579Bk(String str) {
        AppMethodBeat.m2504i(114371);
        boolean contains = C5046bo.nullAsNil(str).toLowerCase().contains("video");
        AppMethodBeat.m2505o(114371);
        return contains;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Bl */
    public final String mo34580Bl(String str) {
        AppMethodBeat.m2504i(114372);
        String RL = C40612a.m70042RL("mp4");
        AppMethodBeat.m2505o(114372);
        return RL;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Bm */
    public final void mo34581Bm(final String str) {
        AppMethodBeat.m2504i(114373);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(114370);
                Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.f1d, new Object[]{str}), 1).show();
                AppMethodBeat.m2505o(114370);
            }
        });
        AppMethodBeat.m2505o(114373);
    }
}
