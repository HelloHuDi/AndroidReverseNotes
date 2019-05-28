package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior.C24632a;
import android.support.p057v4.view.C0449a;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.app.C6218i;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.design.widget.c */
public class C17391c extends C6218i {
    boolean mCancelable;
    /* renamed from: nA */
    private BottomSheetBehavior<FrameLayout> f3790nA;
    /* renamed from: nB */
    boolean f3791nB;
    /* renamed from: nC */
    boolean f3792nC;
    /* renamed from: nD */
    private C24632a f3793nD;

    /* renamed from: android.support.design.widget.c$1 */
    class C83431 implements OnClickListener {
        C83431() {
        }

        public final void onClick(View view) {
            if (C17391c.this.mCancelable && C17391c.this.isShowing()) {
                C17391c c17391c = C17391c.this;
                if (!c17391c.f3792nC) {
                    if (VERSION.SDK_INT < 11) {
                        c17391c.f3791nB = true;
                    } else {
                        TypedArray obtainStyledAttributes = c17391c.getContext().obtainStyledAttributes(new int[]{16843611});
                        c17391c.f3791nB = obtainStyledAttributes.getBoolean(0, true);
                        obtainStyledAttributes.recycle();
                    }
                    c17391c.f3792nC = true;
                }
                if (c17391c.f3791nB) {
                    C17391c.this.cancel();
                }
            }
        }
    }

    /* renamed from: android.support.design.widget.c$2 */
    class C83442 extends C0449a {
        C83442() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, C0445b c0445b) {
            super.onInitializeAccessibilityNodeInfo(view, c0445b);
            if (C17391c.this.mCancelable) {
                c0445b.addAction(1048576);
                c0445b.setDismissable(true);
                return;
            }
            c0445b.setDismissable(false);
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (i != 1048576 || !C17391c.this.mCancelable) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            C17391c.this.cancel();
            return true;
        }
    }

    /* renamed from: android.support.design.widget.c$3 */
    class C173923 implements OnTouchListener {
        C173923() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: android.support.design.widget.c$4 */
    class C173934 extends C24632a {
        C173934() {
        }

        /* renamed from: O */
        public final void mo31604O(int i) {
            if (i == 5) {
                C17391c.this.cancel();
            }
        }

        /* renamed from: h */
        public final void mo31605h(float f) {
        }
    }

    public C17391c(Context context) {
        this(context, 0);
    }

    public C17391c(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(C25738R.attr.f5833jq, typedValue, true)) {
                i = typedValue.resourceId;
            } else {
                i = C25738R.style.f11254uf;
            }
        }
        super(context, i);
        this.mCancelable = true;
        this.f3791nB = true;
        this.f3793nD = new C173934();
        mo14042fA();
    }

    public void setContentView(int i) {
        super.setContentView(m27007a(i, null, null));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(C8415j.INVALID_ID);
            }
            window.setLayout(-1, -1);
        }
    }

    public void setContentView(View view) {
        super.setContentView(m27007a(0, view, null));
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(m27007a(0, view, layoutParams));
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.mCancelable != z) {
            this.mCancelable = z;
            if (this.f3790nA != null) {
                this.f3790nA.f4913nj = z;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onStart() {
        super.onStart();
        if (this.f3790nA != null) {
            this.f3790nA.setState(4);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.mCancelable) {
            this.mCancelable = true;
        }
        this.f3791nB = z;
        this.f3792nC = true;
    }

    /* renamed from: a */
    private View m27007a(int i, View view, LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), 2130969272, null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(2131823262);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, coordinatorLayout, false);
        }
        View view2 = (FrameLayout) coordinatorLayout.findViewById(2131823264);
        this.f3790nA = BottomSheetBehavior.m38322j(view2);
        this.f3790nA.f4922ns = this.f3793nD;
        this.f3790nA.f4913nj = this.mCancelable;
        if (layoutParams == null) {
            view2.addView(view);
        } else {
            view2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(2131823263).setOnClickListener(new C83431());
        C0477s.m905a(view2, new C83442());
        view2.setOnTouchListener(new C173923());
        return frameLayout;
    }
}
