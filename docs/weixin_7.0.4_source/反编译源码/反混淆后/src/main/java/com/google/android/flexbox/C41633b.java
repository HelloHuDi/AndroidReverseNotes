package com.google.android.flexbox;

import android.support.p057v4.widget.C8415j;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.flexbox.b */
public final class C41633b {
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
    /* renamed from: xJ */
    int f16873xJ = BaseClientBuilder.API_PRIORITY_OTHER;
    /* renamed from: xL */
    int f16874xL = BaseClientBuilder.API_PRIORITY_OTHER;
    /* renamed from: xM */
    int f16875xM = C8415j.INVALID_ID;
    /* renamed from: xN */
    int f16876xN = C8415j.INVALID_ID;

    C41633b() {
        AppMethodBeat.m2504i(54677);
        AppMethodBeat.m2505o(54677);
    }

    /* renamed from: uk */
    public final int mo66770uk() {
        return this.apt - this.btl;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: m */
    public final void mo66769m(View view, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(54678);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f16873xJ = Math.min(this.f16873xJ, (view.getLeft() - flexItem.mo19318ug()) - i);
        this.f16874xL = Math.min(this.f16874xL, (view.getTop() - flexItem.mo19319uh()) - i2);
        this.f16875xM = Math.max(this.f16875xM, (view.getRight() + flexItem.mo19320ui()) + i3);
        this.f16876xN = Math.max(this.f16876xN, (flexItem.mo19321uj() + view.getBottom()) + i4);
        AppMethodBeat.m2505o(54678);
    }
}
