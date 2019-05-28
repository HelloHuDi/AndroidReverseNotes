package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.l */
public final class C39148l extends C3154a {
    CharSequence mKU;
    private C3156b mKV = new C39150b();
    C3155a mKW = new C39149a();

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.l$a */
    public class C39149a extends C3155a {
        public View mKk;
        public TextView mKx;

        public C39149a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.l$b */
    public class C39150b extends C3156b {
        public C39150b() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(62009);
            View inflate = LayoutInflater.from(context).inflate(2130969625, viewGroup, false);
            C39149a c39149a = (C39149a) C39148l.this.mKW;
            c39149a.mKx = (TextView) inflate.findViewById(2131824214);
            c39149a.mKk = inflate.findViewById(2131820896);
            inflate.setTag(c39149a);
            AppMethodBeat.m2505o(62009);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(62010);
            C39149a c39149a = (C39149a) c3155a;
            C3201m.m5501a(C39148l.this.mKU, c39149a.mKx);
            if (C39148l.this.position == 0) {
                c39149a.mKk.setVisibility(8);
                AppMethodBeat.m2505o(62010);
                return;
            }
            c39149a.mKk.setVisibility(0);
            AppMethodBeat.m2505o(62010);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            return false;
        }
    }

    public C39148l(int i) {
        super(18, i);
        AppMethodBeat.m2504i(62011);
        AppMethodBeat.m2505o(62011);
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.mKV;
    }

    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        AppMethodBeat.m2504i(62012);
        String charSequence = TextUtils.ellipsize(this.mDz.mDY, C3197c.mHz, 400.0f, TruncateAt.MIDDLE).toString();
        this.mKU = C34204f.m56087a(context.getString(C25738R.string.dzw), context.getString(C25738R.string.dzv), C39127d.m66573b(charSequence, charSequence)).mDR;
        AppMethodBeat.m2505o(62012);
    }
}
