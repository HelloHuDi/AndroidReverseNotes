package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.view.menu.o.a;
import android.support.v7.widget.ak;
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
import com.tencent.mm.R;

final class t extends m implements o, OnKeyListener, OnItemClickListener, OnDismissListener {
    private boolean TO;
    private final OnAttachStateChangeListener aaA = new OnAttachStateChangeListener() {
        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            if (t.this.aaM != null) {
                if (!t.this.aaM.isAlive()) {
                    t.this.aaM = view.getViewTreeObserver();
                }
                t.this.aaM.removeGlobalOnLayoutListener(t.this.aaz);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int aaD = 0;
    View aaE;
    private a aaL;
    private ViewTreeObserver aaM;
    private OnDismissListener aaN;
    private final int aat;
    private final int aau;
    private final boolean aav;
    private final OnGlobalLayoutListener aaz = new OnGlobalLayoutListener() {
        public final void onGlobalLayout() {
            if (t.this.isShowing() && !t.this.acn.amG) {
                View view = t.this.aaE;
                if (view == null || !view.isShown()) {
                    t.this.dismiss();
                } else {
                    t.this.acn.show();
                }
            }
        }
    };
    private final g acl;
    private final int acm;
    final ak acn;
    private boolean aco;
    private boolean acp;
    private int acq;
    private final h lo;
    private final Context mContext;
    private View pP;

    public t(Context context, h hVar, View view, int i, int i2, boolean z) {
        this.mContext = context;
        this.lo = hVar;
        this.aav = z;
        this.acl = new g(hVar, LayoutInflater.from(context), this.aav);
        this.aat = i;
        this.aau = i2;
        Resources resources = context.getResources();
        this.acm = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.a6));
        this.pP = view;
        this.acn = new ak(this.mContext, this.aat, this.aau);
        hVar.a((o) this, context);
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
            if (this.aco || this.pP == null) {
                z = false;
            } else {
                this.aaE = this.pP;
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
                    this.acq = m.a(this.acl, null, this.mContext, this.acm);
                    this.acp = true;
                }
                this.acn.setContentWidth(this.acq);
                this.acn.iZ();
                this.acn.ach = this.ach;
                this.acn.show();
                ab abVar = this.acn.amk;
                abVar.setOnKeyListener(this);
                if (this.TO && this.lo.abz != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.z, abVar, false);
                    TextView textView = (TextView) frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.lo.abz);
                    }
                    frameLayout.setEnabled(false);
                    abVar.addHeaderView(frameLayout, null, false);
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

    public final void f(h hVar) {
    }

    public final boolean isShowing() {
        return !this.aco && this.acn.amH.isShowing();
    }

    public final void onDismiss() {
        this.aco = true;
        this.lo.close();
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

    public final void n(boolean z) {
        this.acp = false;
        if (this.acl != null) {
            this.acl.notifyDataSetChanged();
        }
    }

    public final void a(a aVar) {
        this.aaL = aVar;
    }

    public final boolean a(u uVar) {
        if (uVar.hasVisibleItems()) {
            boolean z;
            n nVar = new n(this.mContext, uVar, this.aaE, this.aav, this.aat, this.aau);
            nVar.c(this.aaL);
            nVar.setForceShowIcon(m.h(uVar));
            nVar.aaD = this.aaD;
            nVar.aaN = this.aaN;
            this.aaN = null;
            this.lo.U(false);
            int i = this.acn.amm;
            int verticalOffset = this.acn.getVerticalOffset();
            if (nVar.isShowing()) {
                z = true;
            } else if (nVar.pP == null) {
                z = false;
            } else {
                nVar.b(i, verticalOffset, true, true);
                z = true;
            }
            if (z) {
                if (this.aaL != null) {
                    this.aaL.d(uVar);
                }
                return true;
            }
        }
        return false;
    }

    public final void a(h hVar, boolean z) {
        if (hVar == this.lo) {
            dismiss();
            if (this.aaL != null) {
                this.aaL.a(hVar, z);
            }
        }
    }

    public final boolean bt() {
        return false;
    }

    public final Parcelable onSaveInstanceState() {
        return null;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
    }

    public final void setAnchorView(View view) {
        this.pP = view;
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
        this.TO = z;
    }
}
