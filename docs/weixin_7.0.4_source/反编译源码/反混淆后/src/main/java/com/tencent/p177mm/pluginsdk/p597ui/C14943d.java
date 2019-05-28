package com.tencent.p177mm.pluginsdk.p597ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.pluginsdk.ui.d */
public final class C14943d implements OnScrollListener {
    private OnScrollListener vgR;
    private ArrayList<WeakReference<C4757a>> vgS;

    /* renamed from: com.tencent.mm.pluginsdk.ui.d$a */
    public interface C4757a {
        void onScrollStateChanged(boolean z);
    }

    public C14943d() {
        this(null);
    }

    public C14943d(OnScrollListener onScrollListener) {
        AppMethodBeat.m2504i(79676);
        this.vgS = new ArrayList();
        this.vgR = onScrollListener;
        AppMethodBeat.m2505o(79676);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.m2504i(79677);
        if (this.vgR != null) {
            this.vgR.onScroll(absListView, i, i2, i3);
        }
        AppMethodBeat.m2505o(79677);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(79678);
        if (i == 2) {
            m23220ow(true);
        } else {
            m23220ow(false);
        }
        if (this.vgR != null) {
            this.vgR.onScrollStateChanged(absListView, i);
        }
        AppMethodBeat.m2505o(79678);
    }

    /* renamed from: a */
    public final void mo27290a(C4757a c4757a) {
        AppMethodBeat.m2504i(79679);
        this.vgS.add(new WeakReference(c4757a));
        AppMethodBeat.m2505o(79679);
    }

    /* renamed from: ow */
    private void m23220ow(boolean z) {
        AppMethodBeat.m2504i(79680);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.vgS.size()) {
                WeakReference weakReference = (WeakReference) this.vgS.get(i2);
                if (weakReference != null) {
                    C4757a c4757a = (C4757a) weakReference.get();
                    if (c4757a != null) {
                        c4757a.onScrollStateChanged(z);
                    } else {
                        this.vgS.remove(i2);
                    }
                } else {
                    this.vgS.remove(i2);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(79680);
                return;
            }
        }
    }
}
