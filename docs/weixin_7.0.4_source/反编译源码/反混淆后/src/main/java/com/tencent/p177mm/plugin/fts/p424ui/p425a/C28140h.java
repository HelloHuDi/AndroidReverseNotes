package com.tencent.p177mm.plugin.fts.p424ui.p425a;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C28147b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.h */
public final class C28140h extends C3154a {
    CharSequence mKB;
    private C28142b mKC = new C28142b(this, (byte) 0);
    C28141a mKD = new C28141a(this, (byte) 0);

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.h$a */
    class C28141a extends C3155a {
        TextView gnC;

        private C28141a() {
            super();
        }

        /* synthetic */ C28141a(C28140h c28140h, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.h$b */
    class C28142b extends C3156b {
        private C28142b() {
            super();
        }

        /* synthetic */ C28142b(C28140h c28140h, byte b) {
            this();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(61990);
            View inflate = LayoutInflater.from(context).inflate(2130969616, viewGroup, false);
            C28141a c28141a = C28140h.this.mKD;
            c28141a.gnC = (TextView) inflate.findViewById(2131820991);
            inflate.setTag(c28141a);
            AppMethodBeat.m2505o(61990);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(61991);
            C3201m.m5501a(C28140h.this.mKB, ((C28141a) c3155a).gnC);
            AppMethodBeat.m2505o(61991);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            AppMethodBeat.m2504i(61992);
            Intent intent = new Intent();
            intent.putExtra("query_phrase_list", C5046bo.m7508P(C28140h.this.mDz.mEa));
            intent.putExtra("go_to_chatroom_direct", true);
            intent.putExtra("scene_from", 3);
            C25985d.m41473f(context, ".ui.transmit.MMCreateChatroomUI", intent);
            AppMethodBeat.m2505o(61992);
            return true;
        }
    }

    public C28140h(int i) {
        super(17, i);
        AppMethodBeat.m2504i(61993);
        AppMethodBeat.m2505o(61993);
    }

    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        AppMethodBeat.m2504i(61994);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (CharSequence charSequence : this.mDz.mEa) {
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new ForegroundColorSpan(C28147b.mHr), 0, charSequence.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append("、");
        }
        this.mKB = TextUtils.concat(new CharSequence[]{context.getString(C25738R.string.e20), spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1), context.getString(C25738R.string.e1z)});
        AppMethodBeat.m2505o(61994);
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.mKC;
    }
}
