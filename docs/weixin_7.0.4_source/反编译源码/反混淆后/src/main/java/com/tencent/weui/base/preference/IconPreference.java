package com.tencent.weui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

public class IconPreference extends Preference {
    private Context context;
    private String desc;
    private Drawable drawable;
    private int height;
    private TextView hrg;
    protected ImageView olR;
    private String pnJ;
    private String pnK;
    private ImageView qZa;
    private int qle;
    private int qlf;
    private int yBD;
    private int yBE;
    private int yBF;
    private ImageView yBG;
    private ViewGroup yBH;
    private TextView yBI;
    LayoutParams yBK;
    private int yBL;
    private int yBM;
    private int yBN;
    private int yBO;
    private int yBP;
    private int yBQ;
    private View yBR;
    private View yBS;
    private TextView yBT;
    private TextView yBU;
    private ImageView yBV;
    private boolean yBW;
    private boolean yBX;
    private int yBY;
    private boolean yBZ;
    private int yDi;
    protected int yeV;
    private Bitmap yhX;

    public IconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(113253);
        this.yeV = -1;
        this.olR = null;
        this.pnJ = "";
        this.qle = -1;
        this.qlf = 8;
        this.yBD = 8;
        this.yBL = 8;
        this.desc = "";
        this.pnK = "";
        this.yBM = -1;
        this.yBN = 8;
        this.yBO = -1;
        this.yhX = null;
        this.yBP = 8;
        this.yBE = 8;
        this.yBF = 8;
        this.yBQ = 8;
        this.yDi = 0;
        this.yBG = null;
        this.yBH = null;
        this.yBR = null;
        this.yBS = null;
        this.qZa = null;
        this.height = -1;
        this.yBW = false;
        this.yBX = false;
        this.yBY = -1;
        this.yBZ = false;
        this.context = context;
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(113253);
    }

    /* Access modifiers changed, original: protected */
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(113254);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(getContext(), 2130970374, viewGroup2);
        AppMethodBeat.m2505o(113254);
        return onCreateView;
    }

    /* Access modifiers changed, original: protected */
    public void onBindView(View view) {
        boolean z;
        AppMethodBeat.m2504i(113255);
        super.onBindView(view);
        this.yBV = (ImageView) view.findViewById(2131822184);
        if (this.yBV != null) {
            if (this.drawable != null) {
                this.yBV.setImageDrawable(this.drawable);
                this.yBV.setVisibility(0);
            } else if (getIcon() != null) {
                ImageView imageView = this.yBV;
                Drawable icon = getIcon();
                this.drawable = icon;
                imageView.setImageDrawable(icon);
                this.yBV.setVisibility(0);
            } else {
                this.yBV.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131822347);
        linearLayout.setMinimumHeight(view.getResources().getDimensionPixelSize(C25738R.dimen.f10010nb));
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        this.yBU = (TextView) view.findViewById(2131822348);
        if (this.yBU != null) {
            if (this.yBX) {
                this.yBU.setCompoundDrawablesWithIntrinsicBounds(C25738R.drawable.a4h, 0, 0, 0);
                this.yBU.setCompoundDrawablePadding((int) this.context.getResources().getDimension(C25738R.dimen.f10011nc));
            } else {
                this.yBU.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            this.yBU.setVisibility(this.qlf);
            this.yBU.setText(this.pnJ);
            if (this.qle != -1) {
                this.yBU.setBackgroundDrawable(this.context.getResources().getDrawable(this.qle));
            }
        }
        this.yBT = (TextView) view.findViewById(2131822350);
        if (this.yBT != null) {
            this.yBT.setVisibility(this.yBN);
            this.yBT.setText(this.pnK);
            if (this.yBM != -1) {
                this.yBT.setBackgroundDrawable(this.context.getResources().getDrawable(this.yBM));
            }
            if (this.yBO != -1) {
                this.yBT.setTextColor(this.yBO);
            }
            if (this.yBW) {
                this.yBT.setCompoundDrawablesWithIntrinsicBounds(0, 0, C25738R.drawable.a4h, 0);
                this.yBT.setCompoundDrawablePadding((int) this.context.getResources().getDimension(C25738R.dimen.f10011nc));
            } else {
                this.yBT.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        this.yBG = (ImageView) view.findViewById(2131822349);
        this.yBG.setVisibility(this.yBD);
        if (this.yBY != -1) {
            this.yBG.setImageResource(this.yBY);
        }
        this.olR = (ImageView) view.findViewById(2131822352);
        this.yBH = (ViewGroup) view.findViewById(2131822351);
        this.yBS = view.findViewById(2131822354);
        this.yBS.setVisibility(this.yBQ);
        this.yBR = view.findViewById(2131822353);
        this.yBR.setVisibility(this.yBF);
        this.qZa = (ImageView) view.findViewById(2131821517);
        this.qZa.setVisibility(this.yDi);
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
        this.yBI = (TextView) view.findViewById(16908310);
        this.hrg = (TextView) view.findViewById(2131821095);
        if (this.hrg != null) {
            this.hrg.setVisibility(this.yBL);
            this.hrg.setText(this.desc);
            if (this.yBZ) {
                this.hrg.setTextColor(this.context.getResources().getColor(C25738R.color.f11943mh));
            } else {
                this.hrg.setTextColor(this.context.getResources().getColor(C25738R.color.f12092s0));
            }
        }
        if (this.yBI != null) {
            if (this.yBZ) {
                this.yBI.setTextColor(this.context.getResources().getColor(C25738R.color.f11943mh));
            } else {
                this.yBI.setTextColor(this.context.getResources().getColor(C25738R.color.f12212w4));
            }
        }
        if (this.yBZ) {
            z = false;
        } else {
            z = true;
        }
        view.setEnabled(z);
        AppMethodBeat.m2505o(113255);
    }
}
