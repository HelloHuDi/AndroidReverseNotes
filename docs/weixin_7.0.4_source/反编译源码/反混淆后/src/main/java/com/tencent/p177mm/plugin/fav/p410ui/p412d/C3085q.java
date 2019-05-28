package com.tencent.p177mm.plugin.fav.p410ui.p412d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.protocal.protobuf.abh;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.q */
public final class C3085q extends C20714a {

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.q$a */
    public static class C3086a extends C3084b {
        TextView gnB;
    }

    public C3085q(C45939l c45939l) {
        super(c45939l);
    }

    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        C3084b c3084b;
        CharSequence string;
        AppMethodBeat.m2504i(74661);
        Context context = viewGroup.getContext();
        if (view == null) {
            C3084b c3086a = new C3086a();
            view = mo36015a(View.inflate(context, 2130969516, null), c3086a, c27966g);
            c3086a.gnB = (TextView) view.findViewById(2131820619);
            c3084b = c3086a;
        } else {
            C3086a c3084b2 = (C3086a) view.getTag();
        }
        mo36016a(c3084b2, c27966g);
        int fY = (int) C39037b.m66394fY((long) C39037b.m66378c(c27966g).duration);
        TextView textView = c3084b2.gnB;
        context = this.mhy.context;
        if (fY <= 0) {
            string = context.getString(C25738R.string.bsa, new Object[]{Integer.valueOf(0)});
        } else {
            string = context.getString(C25738R.string.bsa, new Object[]{Integer.valueOf(fY)});
        }
        textView.setText(string);
        AppMethodBeat.m2505o(74661);
        return view;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74662);
        C3086a c3086a = (C3086a) view.getTag();
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c3086a.mgf, abh);
        AppMethodBeat.m2505o(74662);
    }
}
