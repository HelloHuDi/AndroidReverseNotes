package com.google.android.flexbox;

import android.support.v4.widget.j;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b {
    int apt;
    int bti;
    int btj;
    int btk;
    int btl;
    float btm;
    float btn;
    int bto;
    int btp;
    List<Integer> btq = new ArrayList();
    int btr;
    int bts;
    int xJ = BaseClientBuilder.API_PRIORITY_OTHER;
    int xL = BaseClientBuilder.API_PRIORITY_OTHER;
    int xM = j.INVALID_ID;
    int xN = j.INVALID_ID;

    b() {
        AppMethodBeat.i(54677);
        AppMethodBeat.o(54677);
    }

    public final int uk() {
        return this.apt - this.btl;
    }

    /* Access modifiers changed, original: final */
    public final void m(View view, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(54678);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.xJ = Math.min(this.xJ, (view.getLeft() - flexItem.ug()) - i);
        this.xL = Math.min(this.xL, (view.getTop() - flexItem.uh()) - i2);
        this.xM = Math.max(this.xM, (view.getRight() + flexItem.ui()) + i3);
        this.xN = Math.max(this.xN, (flexItem.uj() + view.getBottom()) + i4);
        AppMethodBeat.o(54678);
    }
}
