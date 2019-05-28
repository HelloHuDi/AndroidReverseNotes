package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class IconSummaryPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int height;
    private ImageView olR;
    private String pnJ;
    private int qle;
    public int qlf;
    private int yBE;
    private int yBF;
    private ViewGroup yBH;
    LayoutParams yBK;
    private int yBP;
    private View yBR;
    private int yCa;
    private TextView yCb;
    private int yCc;
    private int yeV;
    private Bitmap yhX;

    public IconSummaryPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconSummaryPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107183);
        this.pnJ = "";
        this.qle = -1;
        this.qlf = 8;
        this.yhX = null;
        this.yeV = -1;
        this.yBP = 8;
        this.yBE = 0;
        this.yBF = 8;
        this.yCa = 8;
        this.olR = null;
        this.yBH = null;
        this.yBR = null;
        this.yCb = null;
        this.yCc = -1;
        this.height = -1;
        this.context = context;
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(107183);
    }

    /* Access modifiers changed, original: protected */
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(107184);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.aes, viewGroup2);
        AppMethodBeat.o(107184);
        return onCreateView;
    }

    public final void aqR(String str) {
        this.pnJ = str;
        this.qle = R.drawable.w3;
    }

    public final void setSummary(CharSequence charSequence) {
        AppMethodBeat.i(107185);
        super.setSummary(charSequence);
        if (!(this.yCb == null || getSummary() == null || getSummary().length() <= 0)) {
            this.yCb.setText(getSummary());
        }
        AppMethodBeat.o(107185);
    }

    public final void setSummary(int i) {
        AppMethodBeat.i(107186);
        super.setSummary(i);
        if (!(this.yCb == null || getSummary() == null || getSummary().length() <= 0)) {
            this.yCb.setText(getSummary());
        }
        AppMethodBeat.o(107186);
    }

    public final void dAA() {
        AppMethodBeat.i(107187);
        this.yCa = 0;
        if (this.yCb != null) {
            this.yCb.setVisibility(this.yCa);
        }
        AppMethodBeat.o(107187);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.i(107188);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.aga);
        if (imageView != null) {
            imageView.setVisibility(8);
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.rP != null) {
                imageView.setImageDrawable(this.rP);
                imageView.setVisibility(0);
            } else if (this.ZV != 0) {
                imageView.setImageResource(this.ZV);
                imageView.setVisibility(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.akp);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        TextView textView = (TextView) view.findViewById(R.id.akq);
        if (textView != null) {
            textView.setVisibility(this.qlf);
            textView.setText(this.pnJ);
            if (this.qle != -1) {
                textView.setBackgroundDrawable(a.g(this.context, this.qle));
            }
        }
        if (this.olR == null) {
            this.olR = (ImageView) view.findViewById(R.id.aku);
        }
        if (this.yBH == null) {
            this.yBH = (ViewGroup) view.findViewById(R.id.akt);
        }
        if (this.yBR == null) {
            this.yBR = view.findViewById(R.id.akv);
        }
        this.yBR.setVisibility(this.yBF);
        if (this.yhX != null) {
            this.olR.setImageBitmap(this.yhX);
        } else if (this.yeV != -1) {
            this.olR.setImageResource(this.yeV);
        }
        this.olR.setVisibility(this.yBP);
        this.yBH.setVisibility(this.yBE);
        if (this.yBK != null) {
            this.olR.setLayoutParams(this.yBK);
        }
        this.yCb = (TextView) view.findViewById(R.id.d_j);
        if (!(this.yCb == null || getSummary() == null || getSummary().length() <= 0)) {
            this.yCb.setText(getSummary());
            this.yCb.setVisibility(this.yCa);
        }
        if (!(this.yCb == null || this.yCc == -1)) {
            this.yCb.setCompoundDrawablesWithIntrinsicBounds(this.yCc, 0, 0, 0);
            this.yCb.setCompoundDrawablePadding(b.b(this.mContext, 2.0f));
            this.yCb.setVisibility(this.yCa);
        }
        AppMethodBeat.o(107188);
    }
}
