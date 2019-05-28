package com.tencent.mm.plugin.appbrand.widget.header;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public abstract class b implements OnTouchListener, OnScrollListener {
    protected List<a> jdb = new LinkedList();
    private int jdc = 0;

    public interface a {
        void aPs();

        void aPt();

        void qj(int i);

        void qk(int i);
    }

    public abstract void F(MotionEvent motionEvent);

    public abstract void aOS();

    public abstract boolean aOV();

    public abstract void cD(View view);

    public abstract void e(View view, View view2);

    public abstract void gY();

    public abstract void onDestroy();

    public abstract void qh(int i);

    public abstract void setActionBarUpdateCallback(a aVar);

    public abstract void setStatusBarMaskView(View view);

    public abstract void setTabView(View view);

    public void onResume() {
    }

    public void c(long j, int i, boolean z) {
    }

    public final void a(a aVar) {
        if (!this.jdb.contains(aVar)) {
            this.jdb.add(aVar);
        }
    }

    public final void t(boolean z, boolean z2) {
        b(z, z2, 0);
    }

    public final void b(boolean z, boolean z2, int i) {
        ab.i("MicroMsg.HeaderAnimController", "alvinluo notifyCallback isOpen: %b, isDrag: %b, reason: %d", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i));
        if (z) {
            eQ(z2);
            if ((this.jdc & 2) == 0) {
                this.jdc |= 2;
                this.jdc &= -5;
            } else {
                return;
            }
        }
        eR(z2);
        if ((this.jdc & 4) == 0) {
            this.jdc |= 4;
            this.jdc &= -3;
        } else {
            return;
        }
        for (a aVar : this.jdb) {
            if (z) {
                if (z2) {
                    aVar.aPt();
                } else {
                    aVar.aPs();
                }
            } else if (z2) {
                aVar.qk(i);
            } else {
                aVar.qj(i);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void eQ(boolean z) {
    }

    /* Access modifiers changed, original: protected */
    public void eR(boolean z) {
    }
}
