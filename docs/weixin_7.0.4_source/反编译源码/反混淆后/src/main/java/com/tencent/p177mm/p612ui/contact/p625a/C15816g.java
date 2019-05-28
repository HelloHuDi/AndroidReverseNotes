package com.tencent.p177mm.p612ui.contact.p625a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5447b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C28147b;

/* renamed from: com.tencent.mm.ui.contact.a.g */
public final class C15816g extends C5445a {
    private CharSequence mKB;
    private C5447b zpZ = new C5448b();
    C5446a zqa = new C15817a();

    /* renamed from: com.tencent.mm.ui.contact.a.g$b */
    public class C5448b extends C5447b {
        public C5448b() {
            super();
        }

        /* renamed from: a */
        public final View mo11086a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(105289);
            View inflate = LayoutInflater.from(context).inflate(2130970607, viewGroup, false);
            C15817a c15817a = (C15817a) C15816g.this.zqa;
            c15817a.gnC = (TextView) inflate.findViewById(2131820991);
            c15817a.pqm = inflate.findViewById(2131827337);
            inflate.setTag(c15817a);
            AppMethodBeat.m2505o(105289);
            return inflate;
        }

        /* renamed from: a */
        public final void mo11087a(Context context, C5446a c5446a, C5445a c5445a, boolean z, boolean z2) {
            AppMethodBeat.m2504i(105290);
            C15817a c15817a = (C15817a) c5446a;
            C3201m.m5501a(((C15816g) c5445a).mKB, c15817a.gnC);
            if (C15816g.this.position == 0) {
                c15817a.pqm.setVisibility(8);
                AppMethodBeat.m2505o(105290);
                return;
            }
            c15817a.pqm.setVisibility(0);
            AppMethodBeat.m2505o(105290);
        }

        public final boolean aov() {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.a.g$a */
    public class C15817a extends C5446a {
        public TextView gnC;
        public View pqm;

        public C15817a() {
            super();
        }
    }

    public C15816g(int i) {
        super(5, i);
        AppMethodBeat.m2504i(105291);
        AppMethodBeat.m2505o(105291);
    }

    /* renamed from: a */
    public final void mo11082a(Context context, C5446a c5446a) {
        AppMethodBeat.m2504i(105292);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (CharSequence charSequence : this.mDz.mEa) {
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new ForegroundColorSpan(C28147b.mHr), 0, charSequence.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append("、");
        }
        this.mKB = TextUtils.concat(new CharSequence[]{context.getString(C25738R.string.e1c), spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1), context.getString(C25738R.string.e1c)});
        AppMethodBeat.m2505o(105292);
    }

    public final C5447b aou() {
        return this.zpZ;
    }
}
