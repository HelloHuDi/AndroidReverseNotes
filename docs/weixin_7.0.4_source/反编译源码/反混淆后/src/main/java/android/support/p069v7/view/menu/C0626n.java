package android.support.p069v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.p057v4.view.C0456d;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.view.menu.n */
public class C0626n {
    protected int aaD;
    private boolean aaK;
    private C0627a aaL;
    OnDismissListener aaN;
    private final int aat;
    private final int aau;
    private final boolean aav;
    private C6244m aci;
    private final OnDismissListener acj;
    /* renamed from: lo */
    private final C6236h f996lo;
    private final Context mContext;
    /* renamed from: pP */
    protected View f997pP;

    /* renamed from: android.support.v7.view.menu.n$1 */
    class C06251 implements OnDismissListener {
        C06251() {
        }

        public final void onDismiss() {
            C0626n.this.onDismiss();
        }
    }

    public C0626n(Context context, C6236h c6236h, View view, boolean z) {
        this(context, c6236h, view, z, C25738R.attr.f5612dr, 0);
    }

    public C0626n(Context context, C6236h c6236h, View view, boolean z, int i, int i2) {
        this.aaD = 8388611;
        this.acj = new C06251();
        this.mContext = context;
        this.f996lo = c6236h;
        this.f997pP = view;
        this.aav = z;
        this.aat = i;
        this.aau = i2;
    }

    public final void setForceShowIcon(boolean z) {
        this.aaK = z;
        if (this.aci != null) {
            this.aci.setForceShowIcon(z);
        }
    }

    /* renamed from: gO */
    public final C6244m mo1591gO() {
        if (this.aci == null) {
            C6244m c7454e;
            Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            if (VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
            if ((Math.min(point.x, point.y) >= this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10080pi) ? 1 : null) != null) {
                c7454e = new C7454e(this.mContext, this.f997pP, this.aat, this.aau, this.aav);
            } else {
                c7454e = new C7458t(this.mContext, this.f996lo, this.f997pP, this.aat, this.aau, this.aav);
            }
            c7454e.mo14219f(this.f996lo);
            c7454e.setOnDismissListener(this.acj);
            c7454e.setAnchorView(this.f997pP);
            c7454e.mo1600a(this.aaL);
            c7454e.setForceShowIcon(this.aaK);
            c7454e.setGravity(this.aaD);
            this.aci = c7454e;
        }
        return this.aci;
    }

    /* renamed from: gP */
    public final boolean mo1592gP() {
        if (isShowing()) {
            return true;
        }
        if (this.f997pP == null) {
            return false;
        }
        mo1588b(0, 0, false, false);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo1588b(int i, int i2, boolean z, boolean z2) {
        C6244m gO = mo1591gO();
        gO.setShowTitle(z2);
        if (z) {
            if ((C0456d.getAbsoluteGravity(this.aaD, C0477s.m893T(this.f997pP)) & 7) == 5) {
                i += this.f997pP.getWidth();
            }
            gO.setHorizontalOffset(i);
            gO.setVerticalOffset(i2);
            int i3 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            gO.ach = new Rect(i - i3, i2 - i3, i + i3, i3 + i2);
        }
        gO.show();
    }

    public final void dismiss() {
        if (isShowing()) {
            this.aci.dismiss();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDismiss() {
        this.aci = null;
        if (this.aaN != null) {
            this.aaN.onDismiss();
        }
    }

    public final boolean isShowing() {
        return this.aci != null && this.aci.isShowing();
    }

    /* renamed from: c */
    public final void mo1589c(C0627a c0627a) {
        this.aaL = c0627a;
        if (this.aci != null) {
            this.aci.mo1600a(c0627a);
        }
    }
}
