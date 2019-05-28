package android.support.p069v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.view.menu.C0630p.C0629a;
import android.support.p069v7.widget.C0699bc;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.view.menu.ListMenuItemView */
public class ListMenuItemView extends LinearLayout implements C0629a {
    /* renamed from: TF */
    private TextView f1885TF;
    private boolean aaK;
    private RadioButton aaX;
    private CheckBox aaY;
    private TextView aaZ;
    private ImageView aba;
    private Drawable abb;
    private Context abc;
    private boolean abd;
    private Drawable abe;
    private int abf;
    /* renamed from: kY */
    private C6239j f1886kY;
    /* renamed from: lN */
    private int f1887lN;
    private LayoutInflater mInflater;
    /* renamed from: sX */
    private ImageView f1888sX;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5711gf);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        C0699bc a = C0699bc.m1555a(getContext(), attributeSet, C0554a.MenuView, i, 0);
        this.abb = a.getDrawable(5);
        this.f1887lN = a.getResourceId(1, -1);
        this.abd = a.getBoolean(7, false);
        this.abc = context;
        this.abe = a.getDrawable(8);
        a.atG.recycle();
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        C0477s.m904a((View) this, this.abb);
        this.f1885TF = (TextView) findViewById(2131820678);
        if (this.f1887lN != -1) {
            this.f1885TF.setTextAppearance(this.abc, this.f1887lN);
        }
        this.aaZ = (TextView) findViewById(2131820933);
        this.aba = (ImageView) findViewById(2131820935);
        if (this.aba != null) {
            this.aba.setImageDrawable(this.abe);
        }
    }

    /* renamed from: a */
    public final void mo1609a(C6239j c6239j) {
        int i = 0;
        this.f1886kY = c6239j;
        this.abf = 0;
        setVisibility(c6239j.isVisible() ? 0 : 8);
        setTitle(c6239j.mo14169a((C0629a) this));
        setCheckable(c6239j.isCheckable());
        if (!(c6239j.mo14173gH() && this.f1886kY.mo14173gH())) {
            i = 8;
        }
        if (i == 0) {
            CharSequence charSequence;
            TextView textView = this.aaZ;
            char gG = this.f1886kY.mo14172gG();
            if (gG == 0) {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(C6239j.abW);
                switch (gG) {
                    case 8:
                        stringBuilder.append(C6239j.abY);
                        break;
                    case 10:
                        stringBuilder.append(C6239j.abX);
                        break;
                    case ' ':
                        stringBuilder.append(C6239j.abZ);
                        break;
                    default:
                        stringBuilder.append(gG);
                        break;
                }
                charSequence = stringBuilder.toString();
            }
            textView.setText(charSequence);
        }
        if (this.aaZ.getVisibility() != i) {
            this.aaZ.setVisibility(i);
        }
        setIcon(c6239j.getIcon());
        setEnabled(c6239j.isEnabled());
        setSubMenuArrowVisible(c6239j.hasSubMenu());
        setContentDescription(c6239j.getContentDescription());
    }

    public void setForceShowIcon(boolean z) {
        this.aaK = z;
        this.abd = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1885TF.setText(charSequence);
            if (this.f1885TF.getVisibility() != 0) {
                this.f1885TF.setVisibility(0);
            }
        } else if (this.f1885TF.getVisibility() != 8) {
            this.f1885TF.setVisibility(8);
        }
    }

    public C6239j getItemData() {
        return this.f1886kY;
    }

    public void setCheckable(boolean z) {
        if (z || this.aaX != null || this.aaY != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f1886kY.mo14174gI()) {
                if (this.aaX == null) {
                    m10047gr();
                }
                compoundButton = this.aaX;
                compoundButton2 = this.aaY;
            } else {
                if (this.aaY == null) {
                    m10048gs();
                }
                compoundButton = this.aaY;
                compoundButton2 = this.aaX;
            }
            if (z) {
                int i;
                compoundButton.setChecked(this.f1886kY.isChecked());
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.aaY != null) {
                this.aaY.setVisibility(8);
            }
            if (this.aaX != null) {
                this.aaX.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1886kY.mo14174gI()) {
            if (this.aaX == null) {
                m10047gr();
            }
            compoundButton = this.aaX;
        } else {
            if (this.aaY == null) {
                m10048gs();
            }
            compoundButton = this.aaY;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.aba != null) {
            this.aba.setVisibility(z ? 0 : 8);
        }
    }

    private void setShortcut$25d965e(boolean z) {
        int i;
        if (z && this.f1886kY.mo14173gH()) {
            i = 0;
        } else {
            i = 8;
        }
        if (i == 0) {
            CharSequence charSequence;
            TextView textView = this.aaZ;
            char gG = this.f1886kY.mo14172gG();
            if (gG == 0) {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(C6239j.abW);
                switch (gG) {
                    case 8:
                        stringBuilder.append(C6239j.abY);
                        break;
                    case 10:
                        stringBuilder.append(C6239j.abX);
                        break;
                    case ' ':
                        stringBuilder.append(C6239j.abZ);
                        break;
                    default:
                        stringBuilder.append(gG);
                        break;
                }
                charSequence = stringBuilder.toString();
            }
            textView.setText(charSequence);
        }
        if (this.aaZ.getVisibility() != i) {
            this.aaZ.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f1886kY.f1928lo.abF || this.aaK;
        if (!z && !this.abd) {
            return;
        }
        if (this.f1888sX != null || drawable != null || this.abd) {
            if (this.f1888sX == null) {
                this.f1888sX = (ImageView) getInflater().inflate(2130968598, this, false);
                addView(this.f1888sX, 0);
            }
            if (drawable != null || this.abd) {
                ImageView imageView = this.f1888sX;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f1888sX.getVisibility() != 0) {
                    this.f1888sX.setVisibility(0);
                    return;
                }
                return;
            }
            this.f1888sX.setVisibility(8);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        if (this.f1888sX != null && this.abd) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1888sX.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: gr */
    private void m10047gr() {
        this.aaX = (RadioButton) getInflater().inflate(2130968600, this, false);
        addView(this.aaX);
    }

    /* renamed from: gs */
    private void m10048gs() {
        this.aaY = (CheckBox) getInflater().inflate(2130968597, this, false);
        addView(this.aaY);
    }

    /* renamed from: br */
    public final boolean mo1610br() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getContext());
        }
        return this.mInflater;
    }
}
