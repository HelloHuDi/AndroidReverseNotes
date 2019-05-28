package com.tencent.mm.pluginsdk.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d implements OnScrollListener {
    private OnScrollListener vgR;
    private ArrayList<WeakReference<a>> vgS;

    public interface a {
        void onScrollStateChanged(boolean z);
    }

    public d() {
        this(null);
    }

    public d(OnScrollListener onScrollListener) {
        AppMethodBeat.i(79676);
        this.vgS = new ArrayList();
        this.vgR = onScrollListener;
        AppMethodBeat.o(79676);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.i(79677);
        if (this.vgR != null) {
            this.vgR.onScroll(absListView, i, i2, i3);
        }
        AppMethodBeat.o(79677);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(79678);
        if (i == 2) {
            ow(true);
        } else {
            ow(false);
        }
        if (this.vgR != null) {
            this.vgR.onScrollStateChanged(absListView, i);
        }
        AppMethodBeat.o(79678);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(79679);
        this.vgS.add(new WeakReference(aVar));
        AppMethodBeat.o(79679);
    }

    private void ow(boolean z) {
        AppMethodBeat.i(79680);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.vgS.size()) {
                WeakReference weakReference = (WeakReference) this.vgS.get(i2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.onScrollStateChanged(z);
                    } else {
                        this.vgS.remove(i2);
                    }
                } else {
                    this.vgS.remove(i2);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(79680);
                return;
            }
        }
    }
}
