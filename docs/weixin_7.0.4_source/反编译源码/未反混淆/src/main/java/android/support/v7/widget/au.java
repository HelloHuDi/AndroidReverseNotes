package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.j;
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
import com.tencent.mm.R;

public final class au extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator aqx = new DecelerateInterpolator();
    int acy;
    Runnable aqq;
    LinearLayoutCompat aqr;
    private Spinner aqs;
    private boolean aqt;
    int aqu;
    int aqv;
    private int aqw;

    class a extends BaseAdapter {
        a() {
        }

        public final int getCount() {
            return au.this.aqr.getChildCount();
        }

        public final Object getItem(int i) {
            return ((b) au.this.aqr.getChildAt(i)).aqB;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                au auVar = au.this;
                b bVar = new b(auVar.getContext(), (android.support.v7.app.ActionBar.a) getItem(i));
                bVar.setBackgroundDrawable(null);
                bVar.setLayoutParams(new LayoutParams(-1, auVar.acy));
                return bVar;
            }
            b bVar2 = (b) view;
            bVar2.aqB = (android.support.v7.app.ActionBar.a) getItem(i);
            bVar2.update();
            return view;
        }
    }

    class b extends LinearLayout {
        private final int[] aqA = new int[]{16842964};
        android.support.v7.app.ActionBar.a aqB;
        private View sQ;
        private TextView sW;
        private ImageView sX;

        public b(Context context, android.support.v7.app.ActionBar.a aVar) {
            super(context, null, R.attr.dn);
            this.aqB = aVar;
            bc a = bc.a(context, null, this.aqA, R.attr.dn, 0);
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
            accessibilityEvent.setClassName(android.support.v7.app.ActionBar.a.class.getName());
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(android.support.v7.app.ActionBar.a.class.getName());
        }

        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (au.this.aqu > 0 && getMeasuredWidth() > au.this.aqu) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(au.this.aqu, ErrorDialogData.SUPPRESSED), i2);
            }
        }

        public final void update() {
            android.support.v7.app.ActionBar.a aVar = this.aqB;
            View customView = aVar.getCustomView();
            if (customView != null) {
                b parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(customView);
                    }
                    addView(customView);
                }
                this.sQ = customView;
                if (this.sW != null) {
                    this.sW.setVisibility(8);
                }
                if (this.sX != null) {
                    this.sX.setVisibility(8);
                    this.sX.setImageDrawable(null);
                    return;
                }
                return;
            }
            LinearLayout.LayoutParams layoutParams;
            int i;
            CharSequence charSequence;
            if (this.sQ != null) {
                removeView(this.sQ);
                this.sQ = null;
            }
            Drawable icon = aVar.getIcon();
            CharSequence text = aVar.getText();
            if (icon != null) {
                if (this.sX == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.sX = appCompatImageView;
                }
                this.sX.setImageDrawable(icon);
                this.sX.setVisibility(0);
            } else if (this.sX != null) {
                this.sX.setVisibility(8);
                this.sX.setImageDrawable(null);
            }
            if (TextUtils.isEmpty(text)) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                if (this.sW == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.dp);
                    appCompatTextView.setEllipsize(TruncateAt.END);
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams);
                    addView(appCompatTextView);
                    this.sW = appCompatTextView;
                }
                this.sW.setText(text);
                this.sW.setVisibility(0);
            } else if (this.sW != null) {
                this.sW.setVisibility(8);
                this.sW.setText(null);
            }
            if (this.sX != null) {
                this.sX.setContentDescription(aVar.getContentDescription());
            }
            if (i != 0) {
                charSequence = null;
            } else {
                charSequence = aVar.getContentDescription();
            }
            be.a(this, charSequence);
        }
    }

    public final void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == ErrorDialogData.SUPPRESSED;
        setFillViewport(z);
        int childCount = this.aqr.getChildCount();
        if (childCount <= 1 || !(mode == ErrorDialogData.SUPPRESSED || mode == j.INVALID_ID)) {
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
                kB();
            } else if (!kA()) {
                if (this.aqs == null) {
                    AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.ek);
                    appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                    appCompatSpinner.setOnItemSelectedListener(this);
                    this.aqs = appCompatSpinner;
                }
                removeView(this.aqr);
                addView(this.aqs, new ViewGroup.LayoutParams(-2, -1));
                if (this.aqs.getAdapter() == null) {
                    this.aqs.setAdapter(new a());
                }
                if (this.aqq != null) {
                    removeCallbacks(this.aqq);
                    this.aqq = null;
                }
                this.aqs.setSelection(this.aqw);
            }
        } else {
            kB();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.aqw);
        }
    }

    private boolean kA() {
        return this.aqs != null && this.aqs.getParent() == this;
    }

    public final void setAllowCollapse(boolean z) {
        this.aqt = z;
    }

    private boolean kB() {
        if (kA()) {
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
                        au.this.smoothScrollTo(childAt2.getLeft() - ((au.this.getWidth() - childAt2.getWidth()) / 2), 0);
                        au.this.aqq = null;
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
        android.support.v7.view.a X = android.support.v7.view.a.X(getContext());
        TypedArray obtainStyledAttributes = X.mContext.obtainStyledAttributes(null, android.support.v7.a.a.a.ActionBar, R.attr.dt, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(0, 0);
        Resources resources = X.mContext.getResources();
        if (!X.fZ()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.p7));
        }
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.aqv = X.mContext.getResources().getDimensionPixelSize(R.dimen.p8);
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
