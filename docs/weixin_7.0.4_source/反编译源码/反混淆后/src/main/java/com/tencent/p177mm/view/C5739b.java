package com.tencent.p177mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C25784s.C25785a;
import com.tencent.p177mm.api.C32247e;
import com.tencent.p177mm.view.footer.C16070a;
import com.tencent.p177mm.view.footer.C30848b;
import com.tencent.p177mm.view.p1096b.C30844a;
import com.tencent.p177mm.view.p1096b.C40924b;

/* renamed from: com.tencent.mm.view.b */
public final class C5739b extends C16051a {
    public C5739b(Context context, C25785a c25785a) {
        super(context, c25785a);
    }

    /* Access modifiers changed, original: protected|final */
    public final C30844a dMG() {
        AppMethodBeat.m2504i(116386);
        C40924b c40924b = new C40924b(getContext(), getPresenter());
        AppMethodBeat.m2505o(116386);
        return c40924b;
    }

    /* Access modifiers changed, original: protected|final */
    public final C16070a dMH() {
        AppMethodBeat.m2504i(116387);
        C30848b c30848b = new C30848b(getContext(), getPresenter());
        AppMethodBeat.m2505o(116387);
        return c30848b;
    }

    public final C32247e[] getFeatures() {
        if (this.zZM == null) {
            this.zZM = new C32247e[]{C32247e.DOODLE, C32247e.EMOJI, C32247e.TEXT, C32247e.MOSAIC, C32247e.CROP_PHOTO};
        }
        return this.zZM;
    }
}
