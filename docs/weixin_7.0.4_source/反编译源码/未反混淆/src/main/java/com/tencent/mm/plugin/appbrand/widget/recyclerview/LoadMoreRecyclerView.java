package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LoadMoreRecyclerView extends MRecyclerView {
    private View emz;
    private a joG;
    boolean joH;

    public interface a {
        void aMC();
    }

    public LoadMoreRecyclerView(Context context) {
        super(context);
        AppMethodBeat.i(77481);
        init();
        AppMethodBeat.o(77481);
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(77482);
        init();
        AppMethodBeat.o(77482);
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(77483);
        init();
        AppMethodBeat.o(77483);
    }

    /* Access modifiers changed, original: protected */
    public LinearLayoutManager aNm() {
        AppMethodBeat.i(77484);
        getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        AppMethodBeat.o(77484);
        return linearLayoutManager;
    }

    private void init() {
        AppMethodBeat.i(77485);
        final LinearLayoutManager aNm = aNm();
        super.setLayoutManager(aNm);
        a((m) new m() {
            int joI = 0;

            public final void c(RecyclerView recyclerView, int i) {
                AppMethodBeat.i(77478);
                super.c(recyclerView, i);
                if (i == 0 && LoadMoreRecyclerView.this.joH && this.joI == LoadMoreRecyclerView.this.joL.getItemCount() - 1 && LoadMoreRecyclerView.this.joG != null) {
                    LoadMoreRecyclerView.this.joG.aMC();
                }
                AppMethodBeat.o(77478);
            }

            public final void a(RecyclerView recyclerView, int i, int i2) {
                AppMethodBeat.i(77479);
                super.a(recyclerView, i, i2);
                this.joI = aNm.iS();
                AppMethodBeat.o(77479);
            }
        });
        this.joL.a((c) new c() {
            public final void ax(int i, int i2) {
                AppMethodBeat.i(77480);
                super.ax(i, i2);
                if (LoadMoreRecyclerView.this.joH && aNm.iS() == LoadMoreRecyclerView.this.joL.getItemCount() - 1 && LoadMoreRecyclerView.this.joG != null) {
                    LoadMoreRecyclerView.this.joG.aMC();
                }
                AppMethodBeat.o(77480);
            }
        });
        AppMethodBeat.o(77485);
    }

    public final void addFooterView(View view) {
        AppMethodBeat.i(77486);
        int footerViewCount = this.joL.getFooterViewCount() - 1;
        if (this.emz == null || footerViewCount < 0) {
            super.addFooterView(view);
            AppMethodBeat.o(77486);
            return;
        }
        super.b(footerViewCount, view);
        AppMethodBeat.o(77486);
    }

    public void setLayoutManager(i iVar) {
    }

    public void setLoadingView(View view) {
        AppMethodBeat.i(77487);
        if (this.emz == view) {
            AppMethodBeat.o(77487);
            return;
        }
        if (!(this.emz == null || this.emz.equals(view))) {
            cW(this.emz);
        }
        this.emz = view;
        if (this.emz != null) {
            addFooterView(this.emz);
            this.emz.setVisibility(this.joH ? 0 : 8);
        }
        AppMethodBeat.o(77487);
    }

    public void setLoadingView(int i) {
        AppMethodBeat.i(77488);
        setLoadingView(LayoutInflater.from(getContext()).inflate(i, this, false));
        AppMethodBeat.o(77488);
    }

    public final void fh(boolean z) {
        AppMethodBeat.i(77489);
        if (this.joH == z) {
            AppMethodBeat.o(77489);
            return;
        }
        this.joH = z;
        if (this.emz != null) {
            this.emz.setVisibility(this.joH ? 0 : 8);
        }
        AppMethodBeat.o(77489);
    }

    public void setOnLoadingStateChangedListener(a aVar) {
        this.joG = aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aSc() {
        AppMethodBeat.i(77490);
        if (this.emz == null) {
            boolean aSc = super.aSc();
            AppMethodBeat.o(77490);
            return aSc;
        } else if (this.joL.getItemCount() == 1 && this.joL.getFooterViewCount() == 1) {
            AppMethodBeat.o(77490);
            return true;
        } else {
            AppMethodBeat.o(77490);
            return false;
        }
    }
}
