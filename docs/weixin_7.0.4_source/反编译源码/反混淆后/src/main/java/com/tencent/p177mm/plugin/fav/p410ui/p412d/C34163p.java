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
import com.tencent.p177mm.plugin.fav.p410ui.C34171j;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abh;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.p */
public final class C34163p extends C20714a {
    final int moM;

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.p$a */
    public static class C34164a extends C3084b {
        ImageView moN;
        TextView mps;
    }

    public C34163p(C45939l c45939l) {
        super(c45939l);
        AppMethodBeat.m2504i(74658);
        this.moM = C1338a.m2856al(c45939l.context, C25738R.dimen.f9853hx);
        AppMethodBeat.m2505o(74658);
    }

    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        C34164a c34164a;
        AppMethodBeat.m2504i(74659);
        Context context = viewGroup.getContext();
        if (view == null) {
            c34164a = new C34164a();
            view = mo36015a(View.inflate(context, 2130969513, null), (C3084b) c34164a, c27966g);
            c34164a.moN = (ImageView) view.findViewById(2131823917);
            c34164a.mps = (TextView) view.findViewById(2131823925);
        } else {
            c34164a = (C34164a) view.getTag();
        }
        c34164a.mps.setVisibility(0);
        LinkedList linkedList = c27966g.field_favProto.wiv;
        if (linkedList.size() <= 0 || ((aar) linkedList.getFirst()).duration <= 0) {
            c34164a.mps.setText("");
        } else {
            c34164a.mps.setText(C34171j.m56018B(context, ((aar) linkedList.getFirst()).duration));
        }
        mo36016a((C3084b) c34164a, c27966g);
        this.mhy.mo73786a(c34164a.moN, C39037b.m66378c(c27966g), c27966g, (int) C1318a.app_attach_file_icon_video, this.moM, this.moM);
        AppMethodBeat.m2505o(74659);
        return view;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74660);
        C34164a c34164a = (C34164a) view.getTag();
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c34164a.mgf, abh);
        AppMethodBeat.m2505o(74660);
    }
}
