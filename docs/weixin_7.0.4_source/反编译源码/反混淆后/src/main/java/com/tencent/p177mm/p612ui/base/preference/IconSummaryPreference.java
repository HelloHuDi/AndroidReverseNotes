package com.tencent.p177mm.p612ui.base.preference;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;

/* renamed from: com.tencent.mm.ui.base.preference.IconSummaryPreference */
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
        AppMethodBeat.m2504i(107183);
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
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(107183);
    }

    /* Access modifiers changed, original: protected */
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107184);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130970152, viewGroup2);
        AppMethodBeat.m2505o(107184);
        return onCreateView;
    }

    public final void aqR(String str) {
        this.pnJ = str;
        this.qle = C25738R.drawable.f6940w3;
    }

    public final void setSummary(CharSequence charSequence) {
        AppMethodBeat.m2504i(107185);
        super.setSummary(charSequence);
        if (!(this.yCb == null || getSummary() == null || getSummary().length() <= 0)) {
            this.yCb.setText(getSummary());
        }
        AppMethodBeat.m2505o(107185);
    }

    public final void setSummary(int i) {
        AppMethodBeat.m2504i(107186);
        super.setSummary(i);
        if (!(this.yCb == null || getSummary() == null || getSummary().length() <= 0)) {
            this.yCb.setText(getSummary());
        }
        AppMethodBeat.m2505o(107186);
    }

    public final void dAA() {
        AppMethodBeat.m2504i(107187);
        this.yCa = 0;
        if (this.yCb != null) {
            this.yCb.setVisibility(this.yCa);
        }
        AppMethodBeat.m2505o(107187);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.m2504i(107188);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(2131822184);
        if (imageView != null) {
            imageView.setVisibility(8);
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.f4434rP != null) {
                imageView.setImageDrawable(this.f4434rP);
                imageView.setVisibility(0);
            } else if (this.f4433ZV != 0) {
                imageView.setImageResource(this.f4433ZV);
                imageView.setVisibility(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131822347);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        TextView textView = (TextView) view.findViewById(2131822348);
        if (textView != null) {
            textView.setVisibility(this.qlf);
            textView.setText(this.pnJ);
            if (this.qle != -1) {
                textView.setBackgroundDrawable(C1338a.m2864g(this.context, this.qle));
            }
        }
        if (this.olR == null) {
            this.olR = (ImageView) view.findViewById(2131822352);
        }
        if (this.yBH == null) {
            this.yBH = (ViewGroup) view.findViewById(2131822351);
        }
        if (this.yBR == null) {
            this.yBR = view.findViewById(2131822353);
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
        this.yCb = (TextView) view.findViewById(2131826039);
        if (!(this.yCb == null || getSummary() == null || getSummary().length() <= 0)) {
            this.yCb.setText(getSummary());
            this.yCb.setVisibility(this.yCa);
        }
        if (!(this.yCb == null || this.yCc == -1)) {
            this.yCb.setCompoundDrawablesWithIntrinsicBounds(this.yCc, 0, 0, 0);
            this.yCb.setCompoundDrawablePadding(C4977b.m7371b(this.mContext, 2.0f));
            this.yCb.setVisibility(this.yCa);
        }
        AppMethodBeat.m2505o(107188);
    }
}
