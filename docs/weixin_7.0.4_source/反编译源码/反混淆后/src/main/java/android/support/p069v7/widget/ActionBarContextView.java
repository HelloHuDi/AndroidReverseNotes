package android.support.p069v7.widget;

import android.content.Context;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C0497w;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.view.C0604b;
import android.support.p069v7.view.menu.C6236h;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.widget.ActionBarContextView */
public class ActionBarContextView extends C0677a {
    /* renamed from: IT */
    private CharSequence f1929IT;
    /* renamed from: IU */
    private CharSequence f1930IU;
    /* renamed from: TF */
    private TextView f1931TF;
    private View acM;
    private LinearLayout acN;
    private TextView acO;
    private int acP;
    private int acQ;
    public boolean acR;
    private int acS;
    /* renamed from: sQ */
    private View f1932sQ;

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ C0497w mo1920c(int i, long j) {
        return super.mo1920c(i, j);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5623e2);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0699bc a = C0699bc.m1555a(context, attributeSet, C0554a.ActionMode, i, 0);
        C0477s.m904a((View) this, a.getDrawable(3));
        this.acP = a.getResourceId(1, 0);
        this.acQ = a.getResourceId(2, 0);
        this.acy = a.getLayoutDimension(0, 0);
        this.acS = a.getResourceId(5, 2130968589);
        a.atG.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.acx != null) {
            this.acx.hideOverflowMenu();
            this.acx.mo16480hb();
        }
    }

    public void setContentHeight(int i) {
        this.acy = i;
    }

    public void setCustomView(View view) {
        if (this.f1932sQ != null) {
            removeView(this.f1932sQ);
        }
        this.f1932sQ = view;
        if (!(view == null || this.acN == null)) {
            removeView(this.acN);
            this.acN = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1929IT = charSequence;
        m10146gQ();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1930IU = charSequence;
        m10146gQ();
    }

    public CharSequence getTitle() {
        return this.f1929IT;
    }

    public CharSequence getSubtitle() {
        return this.f1930IU;
    }

    /* renamed from: gQ */
    private void m10146gQ() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.acN == null) {
            LayoutInflater.from(getContext()).inflate(2130968584, this);
            this.acN = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1931TF = (TextView) this.acN.findViewById(2131820908);
            this.acO = (TextView) this.acN.findViewById(2131820909);
            if (this.acP != 0) {
                this.f1931TF.setTextAppearance(getContext(), this.acP);
            }
            if (this.acQ != 0) {
                this.acO.setTextAppearance(getContext(), this.acQ);
            }
        }
        this.f1931TF.setText(this.f1929IT);
        this.acO.setText(this.f1930IU);
        Object obj2 = !TextUtils.isEmpty(this.f1929IT) ? 1 : null;
        if (TextUtils.isEmpty(this.f1930IU)) {
            obj = null;
        }
        TextView textView = this.acO;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.acN;
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.acN.getParent() == null) {
            addView(this.acN);
        }
    }

    /* renamed from: c */
    public final void mo14229c(final C0604b c0604b) {
        if (this.acM == null) {
            this.acM = LayoutInflater.from(getContext()).inflate(this.acS, this, false);
            addView(this.acM);
        } else if (this.acM.getParent() == null) {
            addView(this.acM);
        }
        this.acM.findViewById(2131820910).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                c0604b.finish();
            }
        });
        C6236h c6236h = (C6236h) c0604b.getMenu();
        if (this.acx != null) {
            this.acx.mo16479ha();
        }
        this.acx = new ActionMenuPresenter(getContext());
        this.acx.mo16478gZ();
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        c6236h.mo14115a(this.acx, this.acv);
        this.acw = (ActionMenuView) this.acx.mo14104f(this);
        C0477s.m904a(this.acw, null);
        addView(this.acw, layoutParams);
    }

    /* renamed from: gR */
    public final void mo14230gR() {
        if (this.acM == null) {
            mo14231gS();
        }
    }

    /* renamed from: gS */
    public final void mo14231gS() {
        removeAllViews();
        this.f1932sQ = null;
        this.acw = null;
    }

    public final boolean showOverflowMenu() {
        if (this.acx != null) {
            return this.acx.showOverflowMenu();
        }
        return false;
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3 = ErrorDialogData.SUPPRESSED;
        if (MeasureSpec.getMode(i) != ErrorDialogData.SUPPRESSED) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        } else {
            int i4;
            int j;
            int size = MeasureSpec.getSize(i);
            if (this.acy > 0) {
                i4 = this.acy;
            } else {
                i4 = MeasureSpec.getSize(i2);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = i4 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, C8415j.INVALID_ID);
            if (this.acM != null) {
                j = C0677a.m1522j(this.acM, paddingLeft, makeMeasureSpec);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.acM.getLayoutParams();
                paddingLeft = j - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.acw != null && this.acw.getParent() == this) {
                paddingLeft = C0677a.m1522j(this.acw, paddingLeft, makeMeasureSpec);
            }
            if (this.acN != null && this.f1932sQ == null) {
                if (this.acR) {
                    this.acN.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    j = this.acN.getMeasuredWidth();
                    makeMeasureSpec = j <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= j;
                    }
                    this.acN.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = C0677a.m1522j(this.acN, paddingLeft, makeMeasureSpec);
                }
            }
            if (this.f1932sQ != null) {
                int min;
                LayoutParams layoutParams = this.f1932sQ.getLayoutParams();
                makeMeasureSpec = layoutParams.width != -2 ? ErrorDialogData.SUPPRESSED : C8415j.INVALID_ID;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = C8415j.INVALID_ID;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i5);
                } else {
                    min = i5;
                }
                this.f1932sQ.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
            }
            if (this.acy <= 0) {
                i3 = getChildCount();
                makeMeasureSpec = 0;
                i4 = 0;
                while (makeMeasureSpec < i3) {
                    paddingLeft = getChildAt(makeMeasureSpec).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= i4) {
                        paddingLeft = i4;
                    }
                    makeMeasureSpec++;
                    i4 = paddingLeft;
                }
                setMeasuredDimension(size, i4);
                return;
            }
            setMeasuredDimension(size, i4);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean bW = C0709bk.m1576bW(this);
        int paddingRight = bW ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (!(this.acM == null || this.acM.getVisibility() == 8)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.acM.getLayoutParams();
            int i6 = bW ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            i5 = bW ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            paddingRight = C0677a.m1521c(paddingRight, i6, bW);
            paddingRight = C0677a.m1521c(paddingRight + C0677a.m1518a(this.acM, paddingRight, paddingTop, paddingTop2, bW), i5, bW);
        }
        if (!(this.acN == null || this.f1932sQ != null || this.acN.getVisibility() == 8)) {
            paddingRight += C0677a.m1518a(this.acN, paddingRight, paddingTop, paddingTop2, bW);
        }
        if (this.f1932sQ != null) {
            C0677a.m1518a(this.f1932sQ, paddingRight, paddingTop, paddingTop2, bW);
        }
        i5 = bW ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.acw != null) {
            C0677a.m1518a(this.acw, i5, paddingTop, paddingTop2, !bW);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1929IT);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.acR) {
            requestLayout();
        }
        this.acR = z;
    }
}
