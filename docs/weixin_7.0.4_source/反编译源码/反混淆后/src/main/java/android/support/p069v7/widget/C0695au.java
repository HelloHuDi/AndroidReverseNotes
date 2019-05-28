package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.app.ActionBar.C0556a;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.view.C0602a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.widget.au */
public final class C0695au extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator aqx = new DecelerateInterpolator();
    int acy;
    Runnable aqq;
    LinearLayoutCompat aqr;
    private Spinner aqs;
    private boolean aqt;
    int aqu;
    int aqv;
    private int aqw;

    /* renamed from: android.support.v7.widget.au$a */
    class C0693a extends BaseAdapter {
        C0693a() {
        }

        public final int getCount() {
            return C0695au.this.aqr.getChildCount();
        }

        public final Object getItem(int i) {
            return ((C0694b) C0695au.this.aqr.getChildAt(i)).aqB;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                C0695au c0695au = C0695au.this;
                C0694b c0694b = new C0694b(c0695au.getContext(), (C0556a) getItem(i));
                c0694b.setBackgroundDrawable(null);
                c0694b.setLayoutParams(new LayoutParams(-1, c0695au.acy));
                return c0694b;
            }
            C0694b c0694b2 = (C0694b) view;
            c0694b2.aqB = (C0556a) getItem(i);
            c0694b2.update();
            return view;
        }
    }

    /* renamed from: android.support.v7.widget.au$b */
    class C0694b extends LinearLayout {
        private final int[] aqA = new int[]{16842964};
        C0556a aqB;
        /* renamed from: sQ */
        private View f1013sQ;
        /* renamed from: sW */
        private TextView f1014sW;
        /* renamed from: sX */
        private ImageView f1015sX;

        public C0694b(Context context, C0556a c0556a) {
            super(context, null, C25738R.attr.f5608dn);
            this.aqB = c0556a;
            C0699bc a = C0699bc.m1555a(context, null, this.aqA, C25738R.attr.f5608dn, 0);
            if (a.hasValue(0)) {
                setBackgroundDrawable(a.getDrawable(0));
            }
            a.atG.recycle();
            setGravity(8388627);
            update();
        }

        public final void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0556a.class.getName());
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(C0556a.class.getName());
        }

        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (C0695au.this.aqu > 0 && getMeasuredWidth() > C0695au.this.aqu) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(C0695au.this.aqu, ErrorDialogData.SUPPRESSED), i2);
            }
        }

        public final void update() {
            C0556a c0556a = this.aqB;
            View customView = c0556a.getCustomView();
            if (customView != null) {
                C0694b parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(customView);
                    }
                    addView(customView);
                }
                this.f1013sQ = customView;
                if (this.f1014sW != null) {
                    this.f1014sW.setVisibility(8);
                }
                if (this.f1015sX != null) {
                    this.f1015sX.setVisibility(8);
                    this.f1015sX.setImageDrawable(null);
                    return;
                }
                return;
            }
            LinearLayout.LayoutParams layoutParams;
            int i;
            CharSequence charSequence;
            if (this.f1013sQ != null) {
                removeView(this.f1013sQ);
                this.f1013sQ = null;
            }
            Drawable icon = c0556a.getIcon();
            CharSequence text = c0556a.getText();
            if (icon != null) {
                if (this.f1015sX == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f1015sX = appCompatImageView;
                }
                this.f1015sX.setImageDrawable(icon);
                this.f1015sX.setVisibility(0);
            } else if (this.f1015sX != null) {
                this.f1015sX.setVisibility(8);
                this.f1015sX.setImageDrawable(null);
            }
            if (TextUtils.isEmpty(text)) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                if (this.f1014sW == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, C25738R.attr.f5610dp);
                    appCompatTextView.setEllipsize(TruncateAt.END);
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams);
                    addView(appCompatTextView);
                    this.f1014sW = appCompatTextView;
                }
                this.f1014sW.setText(text);
                this.f1014sW.setVisibility(0);
            } else if (this.f1014sW != null) {
                this.f1014sW.setVisibility(8);
                this.f1014sW.setText(null);
            }
            if (this.f1015sX != null) {
                this.f1015sX.setContentDescription(c0556a.getContentDescription());
            }
            if (i != 0) {
                charSequence = null;
            } else {
                charSequence = c0556a.getContentDescription();
            }
            C0701be.m1558a(this, charSequence);
        }
    }

    public final void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == ErrorDialogData.SUPPRESSED;
        setFillViewport(z);
        int childCount = this.aqr.getChildCount();
        if (childCount <= 1 || !(mode == ErrorDialogData.SUPPRESSED || mode == C8415j.INVALID_ID)) {
            this.aqu = -1;
        } else {
            if (childCount > 2) {
                this.aqu = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.aqu = MeasureSpec.getSize(i) / 2;
            }
            this.aqu = Math.min(this.aqu, this.aqv);
        }
        mode = MeasureSpec.makeMeasureSpec(this.acy, ErrorDialogData.SUPPRESSED);
        if (z || !this.aqt) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.aqr.measure(0, mode);
            if (this.aqr.getMeasuredWidth() <= MeasureSpec.getSize(i)) {
                m1548kB();
            } else if (!m1547kA()) {
                if (this.aqs == null) {
                    AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, C25738R.attr.f5642ek);
                    appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                    appCompatSpinner.setOnItemSelectedListener(this);
                    this.aqs = appCompatSpinner;
                }
                removeView(this.aqr);
                addView(this.aqs, new ViewGroup.LayoutParams(-2, -1));
                if (this.aqs.getAdapter() == null) {
                    this.aqs.setAdapter(new C0693a());
                }
                if (this.aqq != null) {
                    removeCallbacks(this.aqq);
                    this.aqq = null;
                }
                this.aqs.setSelection(this.aqw);
            }
        } else {
            m1548kB();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.aqw);
        }
    }

    /* renamed from: kA */
    private boolean m1547kA() {
        return this.aqs != null && this.aqs.getParent() == this;
    }

    public final void setAllowCollapse(boolean z) {
        this.aqt = z;
    }

    /* renamed from: kB */
    private boolean m1548kB() {
        if (m1547kA()) {
            removeView(this.aqs);
            addView(this.aqr, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.aqs.getSelectedItemPosition());
        }
        return false;
    }

    public final void setTabSelected(int i) {
        this.aqw = i;
        int childCount = this.aqr.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.aqr.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                final View childAt2 = this.aqr.getChildAt(i);
                if (this.aqq != null) {
                    removeCallbacks(this.aqq);
                }
                this.aqq = new Runnable() {
                    public final void run() {
                        C0695au.this.smoothScrollTo(childAt2.getLeft() - ((C0695au.this.getWidth() - childAt2.getWidth()) / 2), 0);
                        C0695au.this.aqq = null;
                    }
                };
                post(this.aqq);
            }
        }
        if (this.aqs != null && i >= 0) {
            this.aqs.setSelection(i);
        }
    }

    public final void setContentHeight(int i) {
        this.acy = i;
        requestLayout();
    }

    /* Access modifiers changed, original: protected|final */
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0602a X = C0602a.m1303X(getContext());
        TypedArray obtainStyledAttributes = X.mContext.obtainStyledAttributes(null, C0554a.ActionBar, C25738R.attr.f5614dt, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(0, 0);
        Resources resources = X.mContext.getResources();
        if (!X.mo1482fZ()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C25738R.dimen.f10069p7));
        }
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.aqv = X.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10070p8);
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aqq != null) {
            post(this.aqq);
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aqq != null) {
            removeCallbacks(this.aqq);
        }
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
