package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior.a;
import android.support.v4.view.a.b;
import android.support.v4.view.s;
import android.support.v4.widget.j;
import android.support.v7.app.i;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mm.R;

public class c extends i {
    boolean mCancelable;
    private BottomSheetBehavior<FrameLayout> nA;
    boolean nB;
    boolean nC;
    private a nD;

    public c(Context context) {
        this(context, 0);
    }

    public c(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R.attr.jq, typedValue, true)) {
                i = typedValue.resourceId;
            } else {
                i = R.style.uf;
            }
        }
        super(context, i);
        this.mCancelable = true;
        this.nB = true;
        this.nD = new a() {
            public final void O(int i) {
                if (i == 5) {
                    c.this.cancel();
                }
            }

            public final void h(float f) {
            }
        };
        fA();
    }

    public void setContentView(int i) {
        super.setContentView(a(i, null, null));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(j.INVALID_ID);
            }
            window.setLayout(-1, -1);
        }
    }

    public void setContentView(View view) {
        super.setContentView(a(0, view, null));
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.mCancelable != z) {
            this.mCancelable = z;
            if (this.nA != null) {
                this.nA.nj = z;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onStart() {
        super.onStart();
        if (this.nA != null) {
            this.nA.setState(4);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.mCancelable) {
            this.mCancelable = true;
        }
        this.nB = z;
        this.nC = true;
    }

    private View a(int i, View view, LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.s2, null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(R.id.b9g);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, coordinatorLayout, false);
        }
        View view2 = (FrameLayout) coordinatorLayout.findViewById(R.id.b9i);
        this.nA = BottomSheetBehavior.j(view2);
        this.nA.ns = this.nD;
        this.nA.nj = this.mCancelable;
        if (layoutParams == null) {
            view2.addView(view);
        } else {
            view2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.b9h).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (c.this.mCancelable && c.this.isShowing()) {
                    c cVar = c.this;
                    if (!cVar.nC) {
                        if (VERSION.SDK_INT < 11) {
                            cVar.nB = true;
                        } else {
                            TypedArray obtainStyledAttributes = cVar.getContext().obtainStyledAttributes(new int[]{16843611});
                            cVar.nB = obtainStyledAttributes.getBoolean(0, true);
                            obtainStyledAttributes.recycle();
                        }
                        cVar.nC = true;
                    }
                    if (cVar.nB) {
                        c.this.cancel();
                    }
                }
            }
        });
        s.a(view2, new android.support.v4.view.a() {
            public final void onInitializeAccessibilityNodeInfo(View view, b bVar) {
                super.onInitializeAccessibilityNodeInfo(view, bVar);
                if (c.this.mCancelable) {
                    bVar.addAction(1048576);
                    bVar.setDismissable(true);
                    return;
                }
                bVar.setDismissable(false);
            }

            public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                if (i != 1048576 || !c.this.mCancelable) {
                    return super.performAccessibilityAction(view, i, bundle);
                }
                c.this.cancel();
                return true;
            }
        });
        view2.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        return frameLayout;
    }
}
