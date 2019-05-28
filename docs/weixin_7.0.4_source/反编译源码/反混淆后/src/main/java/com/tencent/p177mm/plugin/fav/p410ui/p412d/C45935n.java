package com.tencent.p177mm.plugin.fav.p410ui.p412d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.protocal.protobuf.abh;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.n */
public final class C45935n extends C20714a {
    public C45935n(C45939l c45939l) {
        super(c45939l);
    }

    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        AppMethodBeat.m2504i(74653);
        View view2 = new View(viewGroup.getContext());
        AppMethodBeat.m2505o(74653);
        return view2;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74654);
        if (view != null) {
            Toast.makeText(view.getContext(), C25738R.string.bs6, 0).show();
        }
        AppMethodBeat.m2505o(74654);
    }
}
