package android.support.p069v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.view.menu.C0630p.C0629a;
import android.support.p069v7.view.menu.C6236h.C0624b;
import android.support.p069v7.widget.ActionMenuView.C0642a;
import android.support.p069v7.widget.AppCompatTextView;
import android.support.p069v7.widget.C0687ae;
import android.support.p069v7.widget.C0701be;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;

/* renamed from: android.support.v7.view.menu.ActionMenuItemView */
public class ActionMenuItemView extends AppCompatTextView implements C0629a, C0642a, OnClickListener {
    /* renamed from: IT */
    private CharSequence f2094IT;
    C0624b aac;
    private C0687ae aad;
    C0615b aae;
    private boolean aaf;
    private boolean aag;
    private int aah;
    private int aai;
    /* renamed from: dg */
    private int f2095dg;
    /* renamed from: kY */
    C6239j f2096kY;
    /* renamed from: rP */
    private Drawable f2097rP;

    /* renamed from: android.support.v7.view.menu.ActionMenuItemView$b */
    public static abstract class C0615b {
        /* renamed from: gm */
        public abstract C0632s mo1567gm();
    }

    /* renamed from: android.support.v7.view.menu.ActionMenuItemView$a */
    class C6230a extends C0687ae {
        public C6230a() {
            super(ActionMenuItemView.this);
        }

        /* renamed from: gm */
        public final C0632s mo1948gm() {
            if (ActionMenuItemView.this.aae != null) {
                return ActionMenuItemView.this.aae.mo1567gm();
            }
            return null;
        }

        /* renamed from: gn */
        public final boolean mo1949gn() {
            if (ActionMenuItemView.this.aac == null || !ActionMenuItemView.this.aac.mo1586f(ActionMenuItemView.this.f2096kY)) {
                return false;
            }
            C0632s gm = mo1948gm();
            if (gm == null || !gm.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.aaf = m12766gi();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0554a.ActionMenuItemView, i, 0);
        this.f2095dg = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.aai = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.aah = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aaf = m12766gi();
        m12767gj();
    }

    /* renamed from: gi */
    private boolean m12766gi() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || ((i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.aah = i;
        super.setPadding(i, i2, i3, i4);
    }

    public C6239j getItemData() {
        return this.f2096kY;
    }

    /* renamed from: a */
    public final void mo1609a(C6239j c6239j) {
        this.f2096kY = c6239j;
        setIcon(c6239j.getIcon());
        setTitle(c6239j.mo14169a((C0629a) this));
        setId(c6239j.getItemId());
        setVisibility(c6239j.isVisible() ? 0 : 8);
        setEnabled(c6239j.isEnabled());
        if (c6239j.hasSubMenu() && this.aad == null) {
            this.aad = new C6230a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f2096kY.hasSubMenu() && this.aad != null && this.aad.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.aac != null) {
            this.aac.mo1586f(this.f2096kY);
        }
    }

    public void setItemInvoker(C0624b c0624b) {
        this.aac = c0624b;
    }

    public void setPopupCallback(C0615b c0615b) {
        this.aae = c0615b;
    }

    /* renamed from: br */
    public final boolean mo1610br() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.aag != z) {
            this.aag = z;
            if (this.f2096kY != null) {
                this.f2096kY.f1928lo.mo14137gA();
            }
        }
    }

    /* renamed from: gj */
    private void m12767gj() {
        CharSequence charSequence;
        int i = 0;
        CharSequence charSequence2 = null;
        int i2 = !TextUtils.isEmpty(this.f2094IT) ? 1 : 0;
        if (this.f2097rP == null || (this.f2096kY.mo14178gM() && (this.aaf || this.aag))) {
            i = 1;
        }
        int i3 = i2 & i;
        if (i3 != 0) {
            charSequence = this.f2094IT;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        charSequence = this.f2096kY.getContentDescription();
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(i3 != 0 ? null : this.f2096kY.getTitle());
        } else {
            setContentDescription(charSequence);
        }
        charSequence = this.f2096kY.getTooltipText();
        if (TextUtils.isEmpty(charSequence)) {
            if (i3 == 0) {
                charSequence2 = this.f2096kY.getTitle();
            }
            C0701be.m1558a(this, charSequence2);
            return;
        }
        C0701be.m1558a(this, charSequence);
    }

    public void setIcon(Drawable drawable) {
        this.f2097rP = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.aai) {
                f = ((float) this.aai) / ((float) intrinsicWidth);
                intrinsicWidth = this.aai;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.aai) {
                f = ((float) this.aai) / ((float) intrinsicHeight);
                intrinsicHeight = this.aai;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m12767gj();
    }

    public final boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f2094IT = charSequence;
        m12767gj();
    }

    /* renamed from: gk */
    public final boolean mo1653gk() {
        return hasText() && this.f2096kY.getIcon() == null;
    }

    /* renamed from: gl */
    public final boolean mo1654gl() {
        return hasText();
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        boolean hasText = hasText();
        if (hasText && this.aah >= 0) {
            super.setPadding(this.aah, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == C8415j.INVALID_ID ? Math.min(size, this.f2095dg) : this.f2095dg;
        if (mode != ErrorDialogData.SUPPRESSED && this.f2095dg > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, ErrorDialogData.SUPPRESSED), i2);
        }
        if (!hasText && this.f2097rP != null) {
            super.setPadding((getMeasuredWidth() - this.f2097rP.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
