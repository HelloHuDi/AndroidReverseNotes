package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.c */
public final class C43127c extends C39152n {
    public boolean mJY;
    private C43128b mJZ = new C43128b();
    C39145a mKa = new C39145a();
    public int resId;

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.c$a */
    public class C39145a extends C3155a {
        public TextView mKb;
        public ImageView mKc;

        public C39145a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.c$b */
    public class C43128b extends C3156b {
        public C43128b() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(61972);
            View inflate = LayoutInflater.from(context).inflate(2130969612, viewGroup, false);
            C39145a c39145a = C43127c.this.mKa;
            c39145a.mKb = (TextView) inflate.findViewById(2131824209);
            c39145a.mKc = (ImageView) inflate.findViewById(2131824210);
            inflate.setTag(c39145a);
            AppMethodBeat.m2505o(61972);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(61973);
            C39145a c39145a = (C39145a) c3155a;
            C43127c c43127c = (C43127c) c3154a;
            Resources resources = context.getResources();
            if (C43127c.this.mJY) {
                C3201m.m5502b(resources.getString(C25738R.string.e0s, new Object[]{resources.getString(c43127c.resId)}), c39145a.mKb);
                c39145a.mKc.setRotation(0.0f);
                AppMethodBeat.m2505o(61973);
                return;
            }
            C3201m.m5502b(resources.getString(C25738R.string.e0t), c39145a.mKb);
            c39145a.mKc.setRotation(180.0f);
            AppMethodBeat.m2505o(61973);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            return false;
        }
    }

    public C43127c(int i) {
        super(i);
        AppMethodBeat.m2504i(61974);
        AppMethodBeat.m2505o(61974);
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.mJZ;
    }
}
