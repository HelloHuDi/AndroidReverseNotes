package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.s;
import android.support.v4.view.w;
import android.support.v4.widget.j;
import android.support.v7.a.a.a;
import android.support.v7.view.b;
import android.support.v7.view.menu.h;
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
import com.tencent.mm.R;

public class ActionBarContextView extends a {
    private CharSequence IT;
    private CharSequence IU;
    private TextView TF;
    private View acM;
    private LinearLayout acN;
    private TextView acO;
    private int acP;
    private int acQ;
    public boolean acR;
    private int acS;
    private View sQ;

    public final /* bridge */ /* synthetic */ w c(int i, long j) {
        return super.c(i, j);
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
        this(context, attributeSet, R.attr.e2);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bc a = bc.a(context, attributeSet, a.ActionMode, i, 0);
        s.a((View) this, a.getDrawable(3));
        this.acP = a.getResourceId(1, 0);
        this.acQ = a.getResourceId(2, 0);
        this.acy = a.getLayoutDimension(0, 0);
        this.acS = a.getResourceId(5, R.layout.n);
        a.atG.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.acx != null) {
            this.acx.hideOverflowMenu();
            this.acx.hb();
        }
    }

    public void setContentHeight(int i) {
        this.acy = i;
    }

    public void setCustomView(View view) {
        if (this.sQ != null) {
            removeView(this.sQ);
        }
        this.sQ = view;
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
        this.IT = charSequence;
        gQ();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.IU = charSequence;
        gQ();
    }

    public CharSequence getTitle() {
        return this.IT;
    }

    public CharSequence getSubtitle() {
        return this.IU;
    }

    private void gQ() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.acN == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.i, this);
            this.acN = (LinearLayout) getChildAt(getChildCount() - 1);
            this.TF = (TextView) this.acN.findViewById(R.id.j5);
            this.acO = (TextView) this.acN.findViewById(R.id.j6);
            if (this.acP != 0) {
                this.TF.setTextAppearance(getContext(), this.acP);
            }
            if (this.acQ != 0) {
                this.acO.setTextAppearance(getContext(), this.acQ);
            }
        }
        this.TF.setText(this.IT);
        this.acO.setText(this.IU);
        Object obj2 = !TextUtils.isEmpty(this.IT) ? 1 : null;
        if (TextUtils.isEmpty(this.IU)) {
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

    public final void c(final b bVar) {
        if (this.acM == null) {
            this.acM = LayoutInflater.from(getContext()).inflate(this.acS, this, false);
            addView(this.acM);
        } else if (this.acM.getParent() == null) {
            addView(this.acM);
        }
        this.acM.findViewById(R.id.j7).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                bVar.finish();
            }
        });
        h hVar = (h) bVar.getMenu();
        if (this.acx != null) {
            this.acx.ha();
        }
        this.acx = new ActionMenuPresenter(getContext());
        this.acx.gZ();
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        hVar.a(this.acx, this.acv);
        this.acw = (ActionMenuView) this.acx.f(this);
        s.a(this.acw, null);
        addView(this.acw, layoutParams);
    }

    public final void gR() {
        if (this.acM == null) {
            gS();
        }
    }

    public final void gS() {
        removeAllViews();
        this.sQ = null;
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
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, j.INVALID_ID);
            if (this.acM != null) {
                j = a.j(this.acM, paddingLeft, makeMeasureSpec);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.acM.getLayoutParams();
                paddingLeft = j - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.acw != null && this.acw.getParent() == this) {
                paddingLeft = a.j(this.acw, paddingLeft, makeMeasureSpec);
            }
            if (this.acN != null && this.sQ == null) {
                if (this.acR) {
                    this.acN.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    j = this.acN.getMeasuredWidth();
                    makeMeasureSpec = j <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= j;
                    }
                    this.acN.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = a.j(this.acN, paddingLeft, makeMeasureSpec);
                }
            }
            if (this.sQ != null) {
                int min;
                LayoutParams layoutParams = this.sQ.getLayoutParams();
                makeMeasureSpec = layoutParams.width != -2 ? ErrorDialogData.SUPPRESSED : j.INVALID_ID;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = j.INVALID_ID;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i5);
                } else {
                    min = i5;
                }
                this.sQ.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
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
        boolean bW = bk.bW(this);
        int paddingRight = bW ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (!(this.acM == null || this.acM.getVisibility() == 8)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.acM.getLayoutParams();
            int i6 = bW ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            i5 = bW ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            paddingRight = a.c(paddingRight, i6, bW);
            paddingRight = a.c(paddingRight + a.a(this.acM, paddingRight, paddingTop, paddingTop2, bW), i5, bW);
        }
        if (!(this.acN == null || this.sQ != null || this.acN.getVisibility() == 8)) {
            paddingRight += a.a(this.acN, paddingRight, paddingTop, paddingTop2, bW);
        }
        if (this.sQ != null) {
            a.a(this.sQ, paddingRight, paddingTop, paddingTop2, bW);
        }
        i5 = bW ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.acw != null) {
            a.a(this.acw, i5, paddingTop, paddingTop2, !bW);
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
            accessibilityEvent.setContentDescription(this.IT);
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
