package com.tencent.p177mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C25784s.C25785a;
import com.tencent.p177mm.api.C32247e;
import com.tencent.p177mm.view.footer.C16070a;
import com.tencent.p177mm.view.footer.C24139c;
import com.tencent.p177mm.view.p1096b.C30844a;
import com.tencent.p177mm.view.p1096b.C46717c;

/* renamed from: com.tencent.mm.view.d */
public final class C46718d extends C16051a {
    public C46718d(Context context, C25785a c25785a) {
        super(context, c25785a);
    }

    /* Access modifiers changed, original: protected|final */
    public final C30844a dMG() {
        AppMethodBeat.m2504i(116393);
        C46717c c46717c = new C46717c(getContext(), getPresenter());
        AppMethodBeat.m2505o(116393);
        return c46717c;
    }

    /* Access modifiers changed, original: protected|final */
    public final C16070a dMH() {
        AppMethodBeat.m2504i(116394);
        C24139c c24139c = new C24139c(getContext(), getPresenter());
        AppMethodBeat.m2505o(116394);
        return c24139c;
    }

    public final C32247e[] getFeatures() {
        if (this.zZM == null) {
            this.zZM = new C32247e[]{C32247e.DOODLE, C32247e.EMOJI, C32247e.TEXT, C32247e.CROP_VIDEO};
        }
        return this.zZM;
    }
}
