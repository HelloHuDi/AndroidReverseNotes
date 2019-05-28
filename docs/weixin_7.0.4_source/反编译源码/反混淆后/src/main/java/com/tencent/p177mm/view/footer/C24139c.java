package com.tencent.p177mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C32247e;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p204br.C18117b;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.view.footer.c */
public final class C24139c extends C16070a {
    private Bitmap Adg;
    private Bitmap Adh;

    /* Access modifiers changed, original: protected|final */
    public final void dMO() {
        AppMethodBeat.m2504i(116446);
        super.dMO();
        this.Adg = C5056d.m7668v(getResources().getDrawable(C1318a.crop_video_unselected));
        this.Adh = C5056d.m7668v(getResources().getDrawable(C1318a.crop_video_selected));
        AppMethodBeat.m2505o(116446);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final Bitmap mo28488a(C32247e c32247e, boolean z) {
        if (c32247e == C32247e.CROP_VIDEO) {
            return z ? this.Adh : this.Adg;
        } else {
            return null;
        }
    }

    public C24139c(Context context, C18117b c18117b) {
        super(context, c18117b);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: QG */
    public final boolean mo28487QG(int i) {
        AppMethodBeat.m2504i(116447);
        boolean QG = super.mo28487QG(i);
        switch (mo28486QF(i)) {
            case CROP_VIDEO:
                QG = false;
                break;
        }
        AppMethodBeat.m2505o(116447);
        return QG;
    }
}
