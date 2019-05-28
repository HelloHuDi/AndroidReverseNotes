package android.support.p069v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.support.p069v7.widget.C0681ab;
import android.support.p069v7.widget.C7461ak;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.view.menu.t */
final class C7458t extends C6244m implements C0628o, OnKeyListener, OnItemClickListener, OnDismissListener {
    /* renamed from: TO */
    private boolean f2100TO;
    private final OnAttachStateChangeListener aaA = new C06342();
    private int aaD = 0;
    View aaE;
    private C0627a aaL;
    private ViewTreeObserver aaM;
    private OnDismissListener aaN;
    private final int aat;
    private final int aau;
    private final boolean aav;
    private final OnGlobalLayoutListener aaz = new C06331();
    private final C0622g acl;
    private final int acm;
    final C7461ak acn;
    private boolean aco;
    private boolean acp;
    private int acq;
    /* renamed from: lo */
    private final C6236h f2101lo;
    private final Context mContext;
    /* renamed from: pP */
    private View f2102pP;

    /* renamed from: android.support.v7.view.menu.t$1 */
    class C06331 implements OnGlobalLayoutListener {
        C06331() {
        }

        public final void onGlobalLayout() {
            if (C7458t.this.isShowing() && !C7458t.this.acn.amG) {
                View view = C7458t.this.aaE;
                if (view == null || !view.isShown()) {
                    C7458t.this.dismiss();
                } else {
                    C7458t.this.acn.show();
                }
            }
        }
    }

    /* renamed from: android.support.v7.view.menu.t$2 */
    class C06342 implements OnAttachStateChangeListener {
        C06342() {
        }

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            if (C7458t.this.aaM != null) {
                if (!C7458t.this.aaM.isAlive()) {
                    C7458t.this.aaM = view.getViewTreeObserver();
                }
                C7458t.this.aaM.removeGlobalOnLayoutListener(C7458t.this.aaz);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public C7458t(Context context, C6236h c6236h, View view, int i, int i2, boolean z) {
        this.mContext = context;
        this.f2101lo = c6236h;
        this.aav = z;
        this.acl = new C0622g(c6236h, LayoutInflater.from(context), this.aav);
        this.aat = i;
        this.aau = i2;
        Resources resources = context.getResources();
        this.acm = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C25738R.dimen.f9648a6));
        this.f2102pP = view;
        this.acn = new C7461ak(this.mContext, this.aat, this.aau);
        c6236h.mo14115a((C0628o) this, context);
    }

    public final void setForceShowIcon(boolean z) {
        this.acl.aaK = z;
    }

    public final void setGravity(int i) {
        this.aaD = i;
    }

    public final void show() {
        boolean z = true;
        if (!isShowing()) {
            if (this.aco || this.f2102pP == null) {
                z = false;
            } else {
                this.aaE = this.f2102pP;
                this.acn.setOnDismissListener(this);
                this.acn.amz = this;
                this.acn.setModal(true);
                View view = this.aaE;
                boolean z2 = this.aaM == null;
                this.aaM = view.getViewTreeObserver();
                if (z2) {
                    this.aaM.addOnGlobalLayoutListener(this.aaz);
                }
                view.addOnAttachStateChangeListener(this.aaA);
                this.acn.amx = view;
                this.acn.aaD = this.aaD;
                if (!this.acp) {
                    this.acq = C6244m.m10138a(this.acl, null, this.mContext, this.acm);
                    this.acp = true;
                }
                this.acn.setContentWidth(this.acq);
                this.acn.mo14390iZ();
                this.acn.ach = this.ach;
                this.acn.show();
                C0681ab c0681ab = this.acn.amk;
                c0681ab.setOnKeyListener(this);
                if (this.f2100TO && this.f2101lo.abz != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(2130968601, c0681ab, false);
                    TextView textView = (TextView) frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.f2101lo.abz);
                    }
                    frameLayout.setEnabled(false);
                    c0681ab.addHeaderView(frameLayout, null, false);
                }
                this.acn.setAdapter(this.acl);
                this.acn.show();
            }
        }
        if (!z) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public final void dismiss() {
        if (isShowing()) {
            this.acn.dismiss();
        }
    }

    /* renamed from: f */
    public final void mo14219f(C6236h c6236h) {
    }

    public final boolean isShowing() {
        return !this.aco && this.acn.amH.isShowing();
    }

    public final void onDismiss() {
        this.aco = true;
        this.f2101lo.close();
        if (this.aaM != null) {
            if (!this.aaM.isAlive()) {
                this.aaM = this.aaE.getViewTreeObserver();
            }
            this.aaM.removeGlobalOnLayoutListener(this.aaz);
            this.aaM = null;
        }
        this.aaE.removeOnAttachStateChangeListener(this.aaA);
        if (this.aaN != null) {
            this.aaN.onDismiss();
        }
    }

    /* renamed from: n */
    public final void mo1606n(boolean z) {
        this.acp = false;
        if (this.acl != null) {
            this.acl.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public final void mo1600a(C0627a c0627a) {
        this.aaL = c0627a;
    }

    /* renamed from: a */
    public final boolean mo1601a(C7459u c7459u) {
        if (c7459u.hasVisibleItems()) {
            boolean z;
            C0626n c0626n = new C0626n(this.mContext, c7459u, this.aaE, this.aav, this.aat, this.aau);
            c0626n.mo1589c(this.aaL);
            c0626n.setForceShowIcon(C6244m.m10140h(c7459u));
            c0626n.aaD = this.aaD;
            c0626n.aaN = this.aaN;
            this.aaN = null;
            this.f2101lo.mo14110U(false);
            int i = this.acn.amm;
            int verticalOffset = this.acn.getVerticalOffset();
            if (c0626n.isShowing()) {
                z = true;
            } else if (c0626n.f997pP == null) {
                z = false;
            } else {
                c0626n.mo1588b(i, verticalOffset, true, true);
                z = true;
            }
            if (z) {
                if (this.aaL != null) {
                    this.aaL.mo1597d(c7459u);
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void mo1599a(C6236h c6236h, boolean z) {
        if (c6236h == this.f2101lo) {
            dismiss();
            if (this.aaL != null) {
                this.aaL.mo1596a(c6236h, z);
            }
        }
    }

    /* renamed from: bt */
    public final boolean mo1603bt() {
        return false;
    }

    public final Parcelable onSaveInstanceState() {
        return null;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
    }

    public final void setAnchorView(View view) {
        this.f2102pP = view;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.aaN = onDismissListener;
    }

    public final ListView getListView() {
        return this.acn.amk;
    }

    public final void setHorizontalOffset(int i) {
        this.acn.amm = i;
    }

    public final void setVerticalOffset(int i) {
        this.acn.setVerticalOffset(i);
    }

    public final void setShowTitle(boolean z) {
        this.f2100TO = z;
    }
}
