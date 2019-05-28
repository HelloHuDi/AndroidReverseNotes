package com.tencent.p177mm.plugin.fts.p424ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.fts.ui.widget.a */
public final class C43138a extends LinearLayout {
    private View mMp = findViewById(2131820977);
    private FTSEditTextView mMq;
    private C12070a mMr;

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.a$a */
    public interface C12070a {
        void onClickBackBtn(View view);
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.a$b */
    public interface C12071b extends Comparable {
        String getTagName();
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.a$1 */
    class C342351 implements OnClickListener {
        C342351() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(62157);
            if (C43138a.this.mMr != null) {
                C43138a.this.mMr.onClickBackBtn(view);
            }
            AppMethodBeat.m2505o(62157);
        }
    }

    public C43138a(Context context) {
        super(context);
        AppMethodBeat.m2504i(62158);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130969604, this, true);
        this.mMp.setOnClickListener(new C342351());
        this.mMq = (FTSEditTextView) findViewById(2131824183);
        AppMethodBeat.m2505o(62158);
    }

    public final void setSearchViewListener(C12070a c12070a) {
        this.mMr = c12070a;
    }

    public final FTSEditTextView getFtsEditText() {
        return this.mMq;
    }
}
