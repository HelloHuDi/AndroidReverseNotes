package com.tencent.p177mm.p612ui.contact.p625a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5447b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;

/* renamed from: com.tencent.mm.ui.contact.a.j */
public final class C15821j extends C5445a {
    public boolean mJY;
    public int resId;
    C5446a zqg = new C15822a();
    private C15823b zqi = new C15823b();

    /* renamed from: com.tencent.mm.ui.contact.a.j$a */
    public class C15822a extends C5446a {
        public TextView mKb;
        public ImageView mKc;

        public C15822a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.a.j$b */
    public class C15823b extends C5447b {
        public C15823b() {
            super();
        }

        /* renamed from: a */
        public final View mo11086a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(105300);
            View inflate = LayoutInflater.from(context).inflate(2130970610, viewGroup, false);
            C15822a c15822a = (C15822a) C15821j.this.zqg;
            c15822a.mKb = (TextView) inflate.findViewById(2131824209);
            c15822a.mKc = (ImageView) inflate.findViewById(2131824210);
            inflate.setTag(c15822a);
            AppMethodBeat.m2505o(105300);
            return inflate;
        }

        /* renamed from: a */
        public final void mo11087a(Context context, C5446a c5446a, C5445a c5445a, boolean z, boolean z2) {
            AppMethodBeat.m2504i(105301);
            C15822a c15822a = (C15822a) c5446a;
            C15821j c15821j = (C15821j) c5445a;
            Resources resources = context.getResources();
            if (C15821j.this.mJY) {
                C3201m.m5502b(resources.getString(C25738R.string.e0s, new Object[]{resources.getString(c15821j.resId)}), c15822a.mKb);
                c15822a.mKc.setRotation(0.0f);
                AppMethodBeat.m2505o(105301);
                return;
            }
            C3201m.m5502b(resources.getString(C25738R.string.e0t), c15822a.mKb);
            c15822a.mKc.setRotation(180.0f);
            AppMethodBeat.m2505o(105301);
        }

        public final boolean aov() {
            return false;
        }
    }

    public C15821j(int i) {
        super(1, i);
        AppMethodBeat.m2504i(105302);
        AppMethodBeat.m2505o(105302);
    }

    /* renamed from: a */
    public final void mo11082a(Context context, C5446a c5446a) {
    }

    public final C5447b aou() {
        return this.zqi;
    }
}
