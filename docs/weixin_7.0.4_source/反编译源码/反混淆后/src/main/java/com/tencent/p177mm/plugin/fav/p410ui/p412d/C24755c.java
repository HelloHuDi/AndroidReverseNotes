package com.tencent.p177mm.plugin.fav.p410ui.p412d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.c */
public final class C24755c extends C20714a {

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.c$a */
    public static class C24756a extends C3084b {
        TextView gnB;
        TextView gnC;
        ImageView iqT;
    }

    public C24755c(C45939l c45939l) {
        super(c45939l);
    }

    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        C3084b c3084b;
        AppMethodBeat.m2504i(74618);
        Context context = viewGroup.getContext();
        if (view == null) {
            C3084b c24756a = new C24756a();
            view = mo36015a(View.inflate(context, 2130969507, null), c24756a, c27966g);
            c24756a.iqT = (ImageView) view.findViewById(2131821479);
            c24756a.gnB = (TextView) view.findViewById(2131820619);
            c24756a.gnC = (TextView) view.findViewById(2131820603);
            c3084b = c24756a;
        } else {
            C24756a c3084b2 = (C24756a) view.getTag();
        }
        mo36016a(c3084b2, c27966g);
        aar c = C39037b.m66378c(c27966g);
        CharSequence charSequence = c27966g.field_favProto.title;
        if (C5046bo.isNullOrNil(charSequence)) {
            charSequence = c.title;
        }
        c3084b2.gnB.setText(charSequence);
        c3084b2.gnC.setText(C39037b.m66368aC((float) c.wgu));
        if (c.whh == 2) {
            c3084b2.gnC.setText(">25MB");
        }
        c3084b2.iqT.setImageResource(C45932c.m85252LX(c.wgo));
        AppMethodBeat.m2505o(74618);
        return view;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74619);
        C27966g c27966g = ((C24756a) view.getTag()).mgf;
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c27966g, abh);
        AppMethodBeat.m2505o(74619);
    }
}
