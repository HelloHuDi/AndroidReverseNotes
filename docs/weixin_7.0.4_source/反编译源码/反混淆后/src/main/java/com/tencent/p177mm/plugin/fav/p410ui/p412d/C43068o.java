package com.tencent.p177mm.plugin.fav.p410ui.p412d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.pluginsdk.C30034d;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.o */
public final class C43068o extends C20714a {
    private final int moM;

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.o$a */
    public static class C6909a extends C3084b {
        TextView gnB;
        ImageView iqT;
    }

    public C43068o(C45939l c45939l) {
        super(c45939l);
        AppMethodBeat.m2504i(74655);
        this.moM = C1338a.m2856al(c45939l.context, C25738R.dimen.f9852hw);
        AppMethodBeat.m2505o(74655);
    }

    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        C3084b c6909a;
        AppMethodBeat.m2504i(74656);
        Context context = viewGroup.getContext();
        if (view == null) {
            c6909a = new C6909a();
            view = mo36015a(View.inflate(context, 2130969506, null), c6909a, c27966g);
            c6909a.iqT = (ImageView) view.findViewById(2131821479);
            c6909a.gnB = (TextView) view.findViewById(2131820619);
            c6909a.gnB.setMaxLines(2);
        } else {
            c6909a = (C6909a) view.getTag();
        }
        mo36016a(c6909a, c27966g);
        aar c = C39037b.m66378c(c27966g);
        abu abu = c27966g.field_favProto.whA;
        TextView textView = c6909a.gnB;
        aar c2 = C39037b.m66378c(c27966g);
        String str = "";
        if (abu != null) {
            str = abu.title;
        }
        if (C5046bo.isNullOrNil(str) && c2 != null) {
            str = c2.title;
        }
        if (C5046bo.isNullOrNil(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
        int ail = C30034d.ail(c.wgo);
        C45939l c45939l = this.mhy;
        ImageView imageView = c6909a.iqT;
        if (ail == C30034d.dgO()) {
            ail = C1318a.app_attach_file_icon_webpage;
        }
        c45939l.mo73786a(imageView, c, c27966g, ail, this.moM, this.moM);
        AppMethodBeat.m2505o(74656);
        return view;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74657);
        C6909a c6909a = (C6909a) view.getTag();
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c6909a.mgf, abh);
        AppMethodBeat.m2505o(74657);
    }
}
