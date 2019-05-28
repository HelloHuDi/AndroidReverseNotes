package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.d;
import android.support.v4.view.s;
import android.support.v7.view.menu.o.a;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.R;

public class n {
    protected int aaD;
    private boolean aaK;
    private a aaL;
    OnDismissListener aaN;
    private final int aat;
    private final int aau;
    private final boolean aav;
    private m aci;
    private final OnDismissListener acj;
    private final h lo;
    private final Context mContext;
    protected View pP;

    public n(Context context, h hVar, View view, boolean z) {
        this(context, hVar, view, z, R.attr.dr, 0);
    }

    public n(Context context, h hVar, View view, boolean z, int i, int i2) {
        this.aaD = 8388611;
        this.acj = new OnDismissListener() {
            public final void onDismiss() {
                n.this.onDismiss();
            }
        };
        this.mContext = context;
        this.lo = hVar;
        this.pP = view;
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

    public final m gO() {
        if (this.aci == null) {
            m eVar;
            Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            if (VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
            if ((Math.min(point.x, point.y) >= this.mContext.getResources().getDimensionPixelSize(R.dimen.pi) ? 1 : null) != null) {
                eVar = new e(this.mContext, this.pP, this.aat, this.aau, this.aav);
            } else {
                eVar = new t(this.mContext, this.lo, this.pP, this.aat, this.aau, this.aav);
            }
            eVar.f(this.lo);
            eVar.setOnDismissListener(this.acj);
            eVar.setAnchorView(this.pP);
            eVar.a(this.aaL);
            eVar.setForceShowIcon(this.aaK);
            eVar.setGravity(this.aaD);
            this.aci = eVar;
        }
        return this.aci;
    }

    public final boolean gP() {
        if (isShowing()) {
            return true;
        }
        if (this.pP == null) {
            return false;
        }
        b(0, 0, false, false);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void b(int i, int i2, boolean z, boolean z2) {
        m gO = gO();
        gO.setShowTitle(z2);
        if (z) {
            if ((d.getAbsoluteGravity(this.aaD, s.T(this.pP)) & 7) == 5) {
                i += this.pP.getWidth();
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

    public final void c(a aVar) {
        this.aaL = aVar;
        if (this.aci != null) {
            this.aci.a(aVar);
        }
    }
}
