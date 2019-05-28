package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.widget.j;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ae;
import android.support.v7.widget.be;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;

public class ActionMenuItemView extends AppCompatTextView implements android.support.v7.view.menu.p.a, android.support.v7.widget.ActionMenuView.a, OnClickListener {
    private CharSequence IT;
    android.support.v7.view.menu.h.b aac;
    private ae aad;
    b aae;
    private boolean aaf;
    private boolean aag;
    private int aah;
    private int aai;
    private int dg;
    j kY;
    private Drawable rP;

    public static abstract class b {
        public abstract s gm();
    }

    class a extends ae {
        public a() {
            super(ActionMenuItemView.this);
        }

        public final s gm() {
            if (ActionMenuItemView.this.aae != null) {
                return ActionMenuItemView.this.aae.gm();
            }
            return null;
        }

        public final boolean gn() {
            if (ActionMenuItemView.this.aac == null || !ActionMenuItemView.this.aac.f(ActionMenuItemView.this.kY)) {
                return false;
            }
            s gm = gm();
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
        this.aaf = gi();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.a.a.a.ActionMenuItemView, i, 0);
        this.dg = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.aai = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.aah = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aaf = gi();
        gj();
    }

    private boolean gi() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || ((i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.aah = i;
        super.setPadding(i, i2, i3, i4);
    }

    public j getItemData() {
        return this.kY;
    }

    public final void a(j jVar) {
        this.kY = jVar;
        setIcon(jVar.getIcon());
        setTitle(jVar.a((android.support.v7.view.menu.p.a) this));
        setId(jVar.getItemId());
        setVisibility(jVar.isVisible() ? 0 : 8);
        setEnabled(jVar.isEnabled());
        if (jVar.hasSubMenu() && this.aad == null) {
            this.aad = new a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kY.hasSubMenu() && this.aad != null && this.aad.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.aac != null) {
            this.aac.f(this.kY);
        }
    }

    public void setItemInvoker(android.support.v7.view.menu.h.b bVar) {
        this.aac = bVar;
    }

    public void setPopupCallback(b bVar) {
        this.aae = bVar;
    }

    public final boolean br() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.aag != z) {
            this.aag = z;
            if (this.kY != null) {
                this.kY.lo.gA();
            }
        }
    }

    private void gj() {
        CharSequence charSequence;
        int i = 0;
        CharSequence charSequence2 = null;
        int i2 = !TextUtils.isEmpty(this.IT) ? 1 : 0;
        if (this.rP == null || (this.kY.gM() && (this.aaf || this.aag))) {
            i = 1;
        }
        int i3 = i2 & i;
        if (i3 != 0) {
            charSequence = this.IT;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        charSequence = this.kY.getContentDescription();
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(i3 != 0 ? null : this.kY.getTitle());
        } else {
            setContentDescription(charSequence);
        }
        charSequence = this.kY.getTooltipText();
        if (TextUtils.isEmpty(charSequence)) {
            if (i3 == 0) {
                charSequence2 = this.kY.getTitle();
            }
            be.a(this, charSequence2);
            return;
        }
        be.a(this, charSequence);
    }

    public void setIcon(Drawable drawable) {
        this.rP = drawable;
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
        gj();
    }

    public final boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.IT = charSequence;
        gj();
    }

    public final boolean gk() {
        return hasText() && this.kY.getIcon() == null;
    }

    public final boolean gl() {
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
        size = mode == j.INVALID_ID ? Math.min(size, this.dg) : this.dg;
        if (mode != ErrorDialogData.SUPPRESSED && this.dg > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, ErrorDialogData.SUPPRESSED), i2);
        }
        if (!hasText && this.rP != null) {
            super.setPadding((getMeasuredWidth() - this.rP.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
