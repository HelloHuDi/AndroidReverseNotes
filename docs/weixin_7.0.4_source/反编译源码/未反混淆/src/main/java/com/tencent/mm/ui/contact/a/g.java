package com.tencent.mm.ui.contact.a;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.ui.m;

public final class g extends a {
    private CharSequence mKB;
    private com.tencent.mm.ui.contact.a.a.b zpZ = new b();
    com.tencent.mm.ui.contact.a.a.a zqa = new a();

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(105289);
            View inflate = LayoutInflater.from(context).inflate(R.layout.ar2, viewGroup, false);
            a aVar = (a) g.this.zqa;
            aVar.gnC = (TextView) inflate.findViewById(R.id.ld);
            aVar.pqm = inflate.findViewById(R.id.e8m);
            inflate.setTag(aVar);
            AppMethodBeat.o(105289);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(105290);
            a aVar3 = (a) aVar;
            m.a(((g) aVar2).mKB, aVar3.gnC);
            if (g.this.position == 0) {
                aVar3.pqm.setVisibility(8);
                AppMethodBeat.o(105290);
                return;
            }
            aVar3.pqm.setVisibility(0);
            AppMethodBeat.o(105290);
        }

        public final boolean aov() {
            return false;
        }
    }

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public TextView gnC;
        public View pqm;

        public a() {
            super();
        }
    }

    public g(int i) {
        super(5, i);
        AppMethodBeat.i(105291);
        AppMethodBeat.o(105291);
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar) {
        AppMethodBeat.i(105292);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (CharSequence charSequence : this.mDz.mEa) {
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new ForegroundColorSpan(com.tencent.mm.plugin.fts.ui.b.b.mHr), 0, charSequence.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append("、");
        }
        this.mKB = TextUtils.concat(new CharSequence[]{context.getString(R.string.e1c), spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1), context.getString(R.string.e1c)});
        AppMethodBeat.o(105292);
    }

    public final com.tencent.mm.ui.contact.a.a.b aou() {
        return this.zpZ;
    }
}
