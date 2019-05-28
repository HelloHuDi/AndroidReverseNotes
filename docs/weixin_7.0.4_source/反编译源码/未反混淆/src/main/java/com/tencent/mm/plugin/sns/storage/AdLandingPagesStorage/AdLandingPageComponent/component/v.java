package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class v extends h {
    TextView exj;
    private RelativeLayout rbB;
    ImageView rbC;

    public v(Context context, t tVar, ViewGroup viewGroup) {
        super(context, tVar, viewGroup);
        this.qZo = tVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.aua;
    }

    public final void coZ() {
        AppMethodBeat.i(37258);
        super.coZ();
        AppMethodBeat.o(37258);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37259);
        this.exj.setText(((t) this.qZo).label);
        this.exj.setTextSize(0, ((t) this.qZo).fontSize);
        if (((t) this.qZo).hfo != null && ((t) this.qZo).hfo.length() > 0) {
            this.rbB.setBackgroundColor(Color.parseColor(((t) this.qZo).hfo));
        }
        h.a(((t) this.qZo).qXe, ((t) this.qZo).qWP, new a() {
            public final void cpu() {
            }

            public final void cmD() {
            }

            public final void YJ(String str) {
                AppMethodBeat.i(37257);
                try {
                    v.this.rbC.setImageBitmap(BitmapFactory.decodeFile(str));
                    TextView textView = v.this.exj;
                    Paint paint = new Paint();
                    String charSequence = textView.getText().toString();
                    paint.setTextSize(textView.getTextSize());
                    float measureText = (v.this.qZo.qWU - paint.measureText(charSequence, 0, charSequence.length())) - TypedValue.applyDimension(1, 3.0f, v.this.context.getResources().getDisplayMetrics());
                    int i = (int) (measureText - (((t) v.this.qZo).value * measureText));
                    LayoutParams layoutParams = (LayoutParams) v.this.rbC.getLayoutParams();
                    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, i, layoutParams.leftMargin);
                    v.this.rbC.setLayoutParams(layoutParams);
                    AppMethodBeat.o(37257);
                } catch (Exception e) {
                    ab.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + bo.l(e));
                    AppMethodBeat.o(37257);
                }
            }
        });
        AppMethodBeat.o(37259);
    }

    public final void cpk() {
        AppMethodBeat.i(37260);
        View view = this.contentView;
        view.setBackgroundColor(this.backgroundColor);
        this.exj = (TextView) view.findViewById(R.id.efr);
        this.rbB = (RelativeLayout) view.findViewById(R.id.efs);
        this.rbC = (ImageView) view.findViewById(R.id.eft);
        AppMethodBeat.o(37260);
    }

    public final void cpa() {
        AppMethodBeat.i(37261);
        super.cpa();
        AppMethodBeat.o(37261);
    }

    public final void cpb() {
        AppMethodBeat.i(37262);
        super.cpb();
        AppMethodBeat.o(37262);
    }
}
