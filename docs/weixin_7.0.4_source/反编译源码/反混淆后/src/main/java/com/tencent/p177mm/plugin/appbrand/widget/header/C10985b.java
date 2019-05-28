package com.tencent.p177mm.plugin.appbrand.widget.header;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.header.b */
public abstract class C10985b implements OnTouchListener, OnScrollListener {
    protected List<C10986a> jdb = new LinkedList();
    private int jdc = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.header.b$a */
    public interface C10986a {
        void aPs();

        void aPt();

        /* renamed from: qj */
        void mo22635qj(int i);

        /* renamed from: qk */
        void mo22636qk(int i);
    }

    /* renamed from: F */
    public abstract void mo22615F(MotionEvent motionEvent);

    public abstract void aOS();

    public abstract boolean aOV();

    /* renamed from: cD */
    public abstract void mo22621cD(View view);

    /* renamed from: e */
    public abstract void mo22622e(View view, View view2);

    /* renamed from: gY */
    public abstract void mo22625gY();

    public abstract void onDestroy();

    /* renamed from: qh */
    public abstract void mo22628qh(int i);

    public abstract void setActionBarUpdateCallback(C10984a c10984a);

    public abstract void setStatusBarMaskView(View view);

    public abstract void setTabView(View view);

    public void onResume() {
    }

    /* renamed from: c */
    public void mo22620c(long j, int i, boolean z) {
    }

    /* renamed from: a */
    public final void mo22616a(C10986a c10986a) {
        if (!this.jdb.contains(c10986a)) {
            this.jdb.add(c10986a);
        }
    }

    /* renamed from: t */
    public final void mo22632t(boolean z, boolean z2) {
        mo22619b(z, z2, 0);
    }

    /* renamed from: b */
    public final void mo22619b(boolean z, boolean z2, int i) {
        C4990ab.m7417i("MicroMsg.HeaderAnimController", "alvinluo notifyCallback isOpen: %b, isDrag: %b, reason: %d", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i));
        if (z) {
            mo22623eQ(z2);
            if ((this.jdc & 2) == 0) {
                this.jdc |= 2;
                this.jdc &= -5;
            } else {
                return;
            }
        }
        mo22624eR(z2);
        if ((this.jdc & 4) == 0) {
            this.jdc |= 4;
            this.jdc &= -3;
        } else {
            return;
        }
        for (C10986a c10986a : this.jdb) {
            if (z) {
                if (z2) {
                    c10986a.aPt();
                } else {
                    c10986a.aPs();
                }
            } else if (z2) {
                c10986a.mo22636qk(i);
            } else {
                c10986a.mo22635qj(i);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: eQ */
    public void mo22623eQ(boolean z) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: eR */
    public void mo22624eR(boolean z) {
    }
}
