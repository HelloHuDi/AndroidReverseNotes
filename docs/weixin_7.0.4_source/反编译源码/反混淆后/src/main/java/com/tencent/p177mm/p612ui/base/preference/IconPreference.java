package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
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

/* renamed from: com.tencent.mm.ui.base.preference.IconPreference */
public class IconPreference extends Preference {
    private Context context;
    private String desc;
    public Drawable drawable;
    private int height;
    private TextView hrg;
    private View mView;
    protected ImageView olR;
    private String pnJ;
    private String pnK;
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
    protected ImageView yBV;
    private boolean yBW;
    public boolean yBX;
    private int yBY;
    public boolean yBZ;
    protected int yeV;
    private Bitmap yhX;

    public IconPreference(Context context) {
        this(context, null);
    }

    public IconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107166);
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
        this.yBE = 0;
        this.yBF = 8;
        this.yBQ = 8;
        this.yBG = null;
        this.yBH = null;
        this.yBR = null;
        this.yBS = null;
        this.height = -1;
        this.yBW = false;
        this.yBX = false;
        this.yBY = -1;
        this.yBZ = false;
        this.context = context;
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(107166);
    }

    /* Access modifiers changed, original: protected */
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107167);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130970151, viewGroup2);
        this.mView = onCreateView;
        View view = this.mView;
        AppMethodBeat.m2505o(107167);
        return view;
    }

    /* renamed from: ey */
    public final void mo48774ey(String str, int i) {
        this.pnJ = str;
        this.qle = i;
    }

    /* renamed from: ez */
    public final void mo48775ez(String str, int i) {
        AppMethodBeat.m2504i(107168);
        mo48771av(str, i, this.yBO);
        AppMethodBeat.m2505o(107168);
    }

    public final void setDesc(String str) {
        AppMethodBeat.m2504i(107169);
        this.desc = str;
        if (this.hrg != null) {
            this.hrg.setText(str);
        }
        AppMethodBeat.m2505o(107169);
    }

    /* renamed from: av */
    public final void mo48771av(String str, int i, int i2) {
        AppMethodBeat.m2504i(107170);
        this.pnK = str;
        this.yBM = i;
        this.yBO = i2;
        if (this.yBT != null) {
            this.yBT.setText(str);
            if (i != -1) {
                this.yBT.setBackgroundDrawable(this.context.getResources().getDrawable(i));
            }
            if (i2 != -1) {
                this.yBT.setTextColor(i2);
            }
        }
        AppMethodBeat.m2505o(107170);
    }

    /* renamed from: NL */
    public final void mo48763NL(int i) {
        AppMethodBeat.m2504i(107171);
        this.qlf = i;
        if (this.yBU != null) {
            this.yBU.setVisibility(i);
        }
        AppMethodBeat.m2505o(107171);
    }

    /* renamed from: NM */
    public final void mo48764NM(int i) {
        AppMethodBeat.m2504i(107172);
        this.yBN = i;
        if (this.yBT != null) {
            this.yBT.setVisibility(i);
        }
        AppMethodBeat.m2505o(107172);
    }

    public final void dAy() {
        AppMethodBeat.m2504i(107173);
        this.yBL = 0;
        if (this.hrg != null) {
            this.hrg.setVisibility(0);
        }
        AppMethodBeat.m2505o(107173);
    }

    /* renamed from: qh */
    public final void mo48778qh(boolean z) {
        AppMethodBeat.m2504i(107174);
        this.yBW = z;
        if (this.yBT != null) {
            if (z) {
                this.yBT.setCompoundDrawablesWithIntrinsicBounds(0, 0, C25738R.drawable.a4h, 0);
                this.yBT.setCompoundDrawablePadding((int) this.context.getResources().getDimension(C25738R.dimen.f10011nc));
                AppMethodBeat.m2505o(107174);
                return;
            }
            this.yBT.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        AppMethodBeat.m2505o(107174);
    }

    /* renamed from: NN */
    public final void mo48765NN(int i) {
        AppMethodBeat.m2504i(107175);
        this.yBD = i;
        if (this.yBG != null) {
            this.yBG.setVisibility(i);
        }
        AppMethodBeat.m2505o(107175);
    }

    /* renamed from: hm */
    public final void mo48776hm(int i, int i2) {
        this.yBD = i;
        this.yBY = i2;
    }

    /* renamed from: ap */
    public final void mo48770ap(Bitmap bitmap) {
        AppMethodBeat.m2504i(107176);
        this.yhX = bitmap;
        this.yeV = -1;
        if (this.olR != null) {
            this.olR.setImageBitmap(bitmap);
        }
        AppMethodBeat.m2505o(107176);
    }

    /* renamed from: NO */
    public final void mo48766NO(int i) {
        AppMethodBeat.m2504i(107177);
        this.yeV = i;
        this.yhX = null;
        if (this.olR != null) {
            this.olR.setImageResource(i);
        }
        AppMethodBeat.m2505o(107177);
    }

    /* renamed from: NP */
    public final void mo48767NP(int i) {
        AppMethodBeat.m2504i(107178);
        this.yBP = i;
        if (this.olR != null) {
            this.olR.setVisibility(this.yBP);
        }
        AppMethodBeat.m2505o(107178);
    }

    /* renamed from: NQ */
    public final void mo48768NQ(int i) {
        AppMethodBeat.m2504i(107179);
        this.yBE = i;
        if (this.yBH != null) {
            this.yBH.setVisibility(this.yBE);
        }
        AppMethodBeat.m2505o(107179);
    }

    /* renamed from: NR */
    public final void mo48769NR(int i) {
        AppMethodBeat.m2504i(107180);
        this.yBF = i;
        if (this.yBR != null) {
            this.yBR.setVisibility(this.yBF);
        }
        AppMethodBeat.m2505o(107180);
    }

    /* renamed from: hn */
    public final void mo48777hn(int i, int i2) {
        AppMethodBeat.m2504i(107181);
        this.yBK = new LayoutParams(i, i2);
        this.yBK.addRule(13);
        if (this.olR == null) {
            AppMethodBeat.m2505o(107181);
            return;
        }
        this.olR.setLayoutParams(this.yBK);
        AppMethodBeat.m2505o(107181);
    }

    /* Access modifiers changed, original: protected */
    public void onBindView(View view) {
        boolean z;
        AppMethodBeat.m2504i(107182);
        super.onBindView(view);
        this.yBV = (ImageView) view.findViewById(2131822184);
        if (this.yBV != null) {
            if (this.drawable != null) {
                this.yBV.setImageDrawable(this.drawable);
                this.yBV.setVisibility(0);
            } else if (this.f4433ZV != 0) {
                ImageView imageView = this.yBV;
                Drawable drawable = this.mContext.getResources().getDrawable(this.f4433ZV);
                this.drawable = drawable;
                imageView.setImageDrawable(drawable);
                this.yBV.setVisibility(0);
            } else {
                this.yBV.setVisibility(8);
            }
            if (this.yDb != 0) {
                this.yBV.getDrawable().setColorFilter(this.yDb, Mode.SRC_ATOP);
            } else if (this.yBV.getDrawable() != null) {
                this.yBV.getDrawable().clearColorFilter();
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131822347);
        linearLayout.setMinimumHeight(view.getResources().getDimensionPixelSize(C25738R.dimen.f9956lc));
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
        AppMethodBeat.m2505o(107182);
    }

    public final ImageView dAz() {
        return this.olR;
    }
}
