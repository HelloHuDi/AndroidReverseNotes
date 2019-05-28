package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsNotifyBanner */
public class SnsNotifyBanner extends RelativeLayout {
    /* renamed from: WL */
    private View f2938WL;
    private LayoutInflater mInflater;
    private TextView ruS;
    private ImageView ruT;
    int ruU = 0;
    private C13542a ruV;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsNotifyBanner$a */
    public interface C13542a {
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsNotifyBanner$1 */
    class C135431 implements OnClickListener {
        C135431() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39136);
            SnsNotifyBanner.this.setVisibility(8);
            AppMethodBeat.m2505o(39136);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsNotifyBanner$2 */
    class C135442 implements OnClickListener {
        C135442() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39137);
            if (SnsNotifyBanner.this.ruV == null) {
                AppMethodBeat.m2505o(39137);
                return;
            }
            if (SnsNotifyBanner.this.ruU > 0) {
                SnsNotifyBanner.this.ruU = 0;
                SnsNotifyBanner.this.ruV;
            } else {
                SnsNotifyBanner.this.ruV;
            }
            SnsNotifyBanner.this.setVisibility(8);
            AppMethodBeat.m2505o(39137);
        }
    }

    public SnsNotifyBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(39138);
        init();
        AppMethodBeat.m2505o(39138);
    }

    public SnsNotifyBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(39139);
        init();
        AppMethodBeat.m2505o(39139);
    }

    private void init() {
        AppMethodBeat.m2504i(39140);
        this.mInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.f2938WL = this.mInflater.inflate(2130970785, this, true);
        this.ruS = (TextView) this.f2938WL.findViewById(2131827814);
        this.ruT = (ImageView) this.f2938WL.findViewById(2131827815);
        this.ruT.setOnClickListener(new C135431());
        AppMethodBeat.m2505o(39140);
    }

    public void setOnClickNotify(C13542a c13542a) {
        AppMethodBeat.m2504i(39141);
        this.ruV = c13542a;
        this.ruS.setOnClickListener(new C135442());
        AppMethodBeat.m2505o(39141);
    }
}
