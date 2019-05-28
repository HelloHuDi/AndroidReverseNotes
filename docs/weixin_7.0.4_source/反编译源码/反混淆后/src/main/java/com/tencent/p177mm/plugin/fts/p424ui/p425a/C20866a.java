package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.a */
public final class C20866a extends C3154a {
    public CharSequence mJP;
    private C20868b mJQ = new C20868b();
    private C20867a mJR = new C20867a();

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.a$a */
    public class C20867a extends C3155a {
        public View contentView;
        public ImageView iqT;
        public TextView mJS;

        public C20867a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.a$b */
    public class C20868b extends C3156b {
        public C20868b() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(61968);
            View inflate = LayoutInflater.from(context).inflate(2130969638, viewGroup, false);
            C20867a c20867a = new C20867a();
            c20867a.iqT = (ImageView) inflate.findViewById(2131821226);
            c20867a.mJS = (TextView) inflate.findViewById(2131821051);
            c20867a.contentView = inflate.findViewById(2131821182);
            inflate.setTag(c20867a);
            AppMethodBeat.m2505o(61968);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(61969);
            C20867a c20867a = (C20867a) c3155a;
            C3201m.m5503p(c20867a.contentView, C20866a.this.mFk);
            C3201m.m5501a(C20866a.this.mJP, c20867a.mJS);
            c20867a.iqT.setImageResource(C1318a.search_add_icon_green);
            AppMethodBeat.m2505o(61969);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            return false;
        }
    }

    public C20866a(int i) {
        super(10, i);
        AppMethodBeat.m2504i(61970);
        AppMethodBeat.m2505o(61970);
    }

    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        AppMethodBeat.m2504i(61971);
        this.mJP = C34204f.m56087a(context.getResources().getString(C25738R.string.c1e), "", C39127d.m66573b(this.mDz.mDY, this.mDz.mDY)).mDR;
        AppMethodBeat.m2505o(61971);
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.mJQ;
    }
}
