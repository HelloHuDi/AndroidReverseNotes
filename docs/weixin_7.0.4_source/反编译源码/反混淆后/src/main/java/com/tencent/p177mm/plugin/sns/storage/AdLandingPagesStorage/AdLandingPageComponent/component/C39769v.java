package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C31416t;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v */
public final class C39769v extends C13437h {
    TextView exj;
    private RelativeLayout rbB;
    ImageView rbC;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v$1 */
    class C290771 implements C3951a {
        C290771() {
        }

        public final void cpu() {
        }

        public final void cmD() {
        }

        /* renamed from: YJ */
        public final void mo8627YJ(String str) {
            AppMethodBeat.m2504i(37257);
            try {
                C39769v.this.rbC.setImageBitmap(BitmapFactory.decodeFile(str));
                TextView textView = C39769v.this.exj;
                Paint paint = new Paint();
                String charSequence = textView.getText().toString();
                paint.setTextSize(textView.getTextSize());
                float measureText = (C39769v.this.qZo.qWU - paint.measureText(charSequence, 0, charSequence.length())) - TypedValue.applyDimension(1, 3.0f, C39769v.this.context.getResources().getDisplayMetrics());
                int i = (int) (measureText - (((C31416t) C39769v.this.qZo).value * measureText));
                LayoutParams layoutParams = (LayoutParams) C39769v.this.rbC.getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, i, layoutParams.leftMargin);
                C39769v.this.rbC.setLayoutParams(layoutParams);
                AppMethodBeat.m2505o(37257);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + C5046bo.m7574l(e));
                AppMethodBeat.m2505o(37257);
            }
        }
    }

    public C39769v(Context context, C31416t c31416t, ViewGroup viewGroup) {
        super(context, c31416t, viewGroup);
        this.qZo = c31416t;
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970727;
    }

    public final void coZ() {
        AppMethodBeat.m2504i(37258);
        super.coZ();
        AppMethodBeat.m2505o(37258);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37259);
        this.exj.setText(((C31416t) this.qZo).label);
        this.exj.setTextSize(0, ((C31416t) this.qZo).fontSize);
        if (((C31416t) this.qZo).hfo != null && ((C31416t) this.qZo).hfo.length() > 0) {
            this.rbB.setBackgroundColor(Color.parseColor(((C31416t) this.qZo).hfo));
        }
        C13473h.m21619a(((C31416t) this.qZo).qXe, ((C31416t) this.qZo).qWP, new C290771());
        AppMethodBeat.m2505o(37259);
    }

    public final void cpk() {
        AppMethodBeat.m2504i(37260);
        View view = this.contentView;
        view.setBackgroundColor(this.backgroundColor);
        this.exj = (TextView) view.findViewById(2131827638);
        this.rbB = (RelativeLayout) view.findViewById(2131827639);
        this.rbC = (ImageView) view.findViewById(2131827640);
        AppMethodBeat.m2505o(37260);
    }

    public final void cpa() {
        AppMethodBeat.m2504i(37261);
        super.cpa();
        AppMethodBeat.m2505o(37261);
    }

    public final void cpb() {
        AppMethodBeat.m2504i(37262);
        super.cpb();
        AppMethodBeat.m2505o(37262);
    }
}
