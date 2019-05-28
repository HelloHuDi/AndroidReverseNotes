package com.tencent.p177mm.plugin.fav.p410ui.p412d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p410ui.C34172k;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.e */
public final class C45933e extends C20714a {

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.e$a */
    public static class C28008a extends C3084b {
        TextView gnB;
        TextView gnC;
        ImageView iqT;
    }

    public C45933e(C45939l c45939l) {
        super(c45939l);
    }

    @SuppressLint({"ResourceType"})
    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        C3084b c3084b;
        AppMethodBeat.m2504i(74623);
        Context context = viewGroup.getContext();
        if (view == null) {
            C3084b c28008a = new C28008a();
            view = mo36015a(View.inflate(context, 2130969507, null), c28008a, c27966g);
            c28008a.iqT = (ImageView) view.findViewById(2131821479);
            c28008a.gnB = (TextView) view.findViewById(2131820619);
            c28008a.gnC = (TextView) view.findViewById(2131820603);
            c3084b = c28008a;
        } else {
            C28008a c3084b2 = (C28008a) view.getTag();
        }
        mo36016a(c3084b2, c27966g);
        c3084b2.iqT.setImageResource(C1318a.app_attach_file_icon_location);
        aay aay = c27966g.field_favProto.why;
        CharSequence charSequence = c27966g.field_favProto.hHV;
        if (!C5046bo.isNullOrNil(charSequence)) {
            c3084b2.gnB.setText(C44089j.m79293b(c3084b2.gnB.getContext(), charSequence, c3084b2.gnB.getTextSize()));
            if (C34172k.m56022Md(aay.cIK)) {
                c3084b2.gnC.setText(aay.cIK);
                AppMethodBeat.m2505o(74623);
                return view;
            }
        } else if (C34172k.m56022Md(aay.cIK)) {
            c3084b2.gnB.setText(aay.cIK);
        } else {
            c3084b2.gnB.setText(aay.label);
            c3084b2.gnC.setVisibility(8);
            AppMethodBeat.m2505o(74623);
            return view;
        }
        c3084b2.gnC.setText(aay.label);
        AppMethodBeat.m2505o(74623);
        return view;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74624);
        C28008a c28008a = (C28008a) view.getTag();
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c28008a.mgf, abh);
        AppMethodBeat.m2505o(74624);
    }
}
