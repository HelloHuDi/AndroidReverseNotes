package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.s;
import android.support.v7.view.menu.p.a;
import android.support.v7.widget.bc;
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
import com.tencent.mm.R;

public class ListMenuItemView extends LinearLayout implements a {
    private TextView TF;
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
    private j kY;
    private int lN;
    private LayoutInflater mInflater;
    private ImageView sX;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.gf);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        bc a = bc.a(getContext(), attributeSet, android.support.v7.a.a.a.MenuView, i, 0);
        this.abb = a.getDrawable(5);
        this.lN = a.getResourceId(1, -1);
        this.abd = a.getBoolean(7, false);
        this.abc = context;
        this.abe = a.getDrawable(8);
        a.atG.recycle();
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        s.a((View) this, this.abb);
        this.TF = (TextView) findViewById(R.id.cx);
        if (this.lN != -1) {
            this.TF.setTextAppearance(this.abc, this.lN);
        }
        this.aaZ = (TextView) findViewById(R.id.jt);
        this.aba = (ImageView) findViewById(R.id.jv);
        if (this.aba != null) {
            this.aba.setImageDrawable(this.abe);
        }
    }

    public final void a(j jVar) {
        int i = 0;
        this.kY = jVar;
        this.abf = 0;
        setVisibility(jVar.isVisible() ? 0 : 8);
        setTitle(jVar.a((a) this));
        setCheckable(jVar.isCheckable());
        if (!(jVar.gH() && this.kY.gH())) {
            i = 8;
        }
        if (i == 0) {
            CharSequence charSequence;
            TextView textView = this.aaZ;
            char gG = this.kY.gG();
            if (gG == 0) {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(j.abW);
                switch (gG) {
                    case 8:
                        stringBuilder.append(j.abY);
                        break;
                    case 10:
                        stringBuilder.append(j.abX);
                        break;
                    case ' ':
                        stringBuilder.append(j.abZ);
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
        setIcon(jVar.getIcon());
        setEnabled(jVar.isEnabled());
        setSubMenuArrowVisible(jVar.hasSubMenu());
        setContentDescription(jVar.getContentDescription());
    }

    public void setForceShowIcon(boolean z) {
        this.aaK = z;
        this.abd = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.TF.setText(charSequence);
            if (this.TF.getVisibility() != 0) {
                this.TF.setVisibility(0);
            }
        } else if (this.TF.getVisibility() != 8) {
            this.TF.setVisibility(8);
        }
    }

    public j getItemData() {
        return this.kY;
    }

    public void setCheckable(boolean z) {
        if (z || this.aaX != null || this.aaY != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.kY.gI()) {
                if (this.aaX == null) {
                    gr();
                }
                compoundButton = this.aaX;
                compoundButton2 = this.aaY;
            } else {
                if (this.aaY == null) {
                    gs();
                }
                compoundButton = this.aaY;
                compoundButton2 = this.aaX;
            }
            if (z) {
                int i;
                compoundButton.setChecked(this.kY.isChecked());
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
        if (this.kY.gI()) {
            if (this.aaX == null) {
                gr();
            }
            compoundButton = this.aaX;
        } else {
            if (this.aaY == null) {
                gs();
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
        if (z && this.kY.gH()) {
            i = 0;
        } else {
            i = 8;
        }
        if (i == 0) {
            CharSequence charSequence;
            TextView textView = this.aaZ;
            char gG = this.kY.gG();
            if (gG == 0) {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(j.abW);
                switch (gG) {
                    case 8:
                        stringBuilder.append(j.abY);
                        break;
                    case 10:
                        stringBuilder.append(j.abX);
                        break;
                    case ' ':
                        stringBuilder.append(j.abZ);
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
        boolean z = this.kY.lo.abF || this.aaK;
        if (!z && !this.abd) {
            return;
        }
        if (this.sX != null || drawable != null || this.abd) {
            if (this.sX == null) {
                this.sX = (ImageView) getInflater().inflate(R.layout.w, this, false);
                addView(this.sX, 0);
            }
            if (drawable != null || this.abd) {
                ImageView imageView = this.sX;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.sX.getVisibility() != 0) {
                    this.sX.setVisibility(0);
                    return;
                }
                return;
            }
            this.sX.setVisibility(8);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        if (this.sX != null && this.abd) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.sX.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void gr() {
        this.aaX = (RadioButton) getInflater().inflate(R.layout.y, this, false);
        addView(this.aaX);
    }

    private void gs() {
        this.aaY = (CheckBox) getInflater().inflate(R.layout.v, this, false);
        addView(this.aaY);
    }

    public final boolean br() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getContext());
        }
        return this.mInflater;
    }
}
