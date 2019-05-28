package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.bo;

public final class h extends com.tencent.mm.plugin.fts.a.d.a.a {
    CharSequence mKB;
    private b mKC = new b(this, (byte) 0);
    a mKD = new a(this, (byte) 0);

    class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        TextView gnC;

        private a() {
            super();
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }
    }

    class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        private b() {
            super();
        }

        /* synthetic */ b(h hVar, byte b) {
            this();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(61990);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a1a, viewGroup, false);
            a aVar = h.this.mKD;
            aVar.gnC = (TextView) inflate.findViewById(R.id.ld);
            inflate.setTag(aVar);
            AppMethodBeat.o(61990);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(61991);
            m.a(h.this.mKB, ((a) aVar).gnC);
            AppMethodBeat.o(61991);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(61992);
            Intent intent = new Intent();
            intent.putExtra("query_phrase_list", bo.P(h.this.mDz.mEa));
            intent.putExtra("go_to_chatroom_direct", true);
            intent.putExtra("scene_from", 3);
            d.f(context, ".ui.transmit.MMCreateChatroomUI", intent);
            AppMethodBeat.o(61992);
            return true;
        }
    }

    public h(int i) {
        super(17, i);
        AppMethodBeat.i(61993);
        AppMethodBeat.o(61993);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        AppMethodBeat.i(61994);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (CharSequence charSequence : this.mDz.mEa) {
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new ForegroundColorSpan(com.tencent.mm.plugin.fts.ui.b.b.mHr), 0, charSequence.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append("、");
        }
        this.mKB = TextUtils.concat(new CharSequence[]{context.getString(R.string.e20), spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1), context.getString(R.string.e1z)});
        AppMethodBeat.o(61994);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mKC;
    }
}
