package com.tencent.p177mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C41525c;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView */
public class LoadMoreRecyclerView extends MRecyclerView {
    private View emz;
    private C11052a joG;
    boolean joH;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView$a */
    public interface C11052a {
        void aMC();
    }

    public LoadMoreRecyclerView(Context context) {
        super(context);
        AppMethodBeat.m2504i(77481);
        init();
        AppMethodBeat.m2505o(77481);
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(77482);
        init();
        AppMethodBeat.m2505o(77482);
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(77483);
        init();
        AppMethodBeat.m2505o(77483);
    }

    /* Access modifiers changed, original: protected */
    public LinearLayoutManager aNm() {
        AppMethodBeat.m2504i(77484);
        getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        AppMethodBeat.m2505o(77484);
        return linearLayoutManager;
    }

    private void init() {
        AppMethodBeat.m2504i(77485);
        final LinearLayoutManager aNm = aNm();
        super.setLayoutManager(aNm);
        mo66332a((C41530m) new C41530m() {
            int joI = 0;

            /* renamed from: c */
            public final void mo6643c(RecyclerView recyclerView, int i) {
                AppMethodBeat.m2504i(77478);
                super.mo6643c(recyclerView, i);
                if (i == 0 && LoadMoreRecyclerView.this.joH && this.joI == LoadMoreRecyclerView.this.joL.getItemCount() - 1 && LoadMoreRecyclerView.this.joG != null) {
                    LoadMoreRecyclerView.this.joG.aMC();
                }
                AppMethodBeat.m2505o(77478);
            }

            /* renamed from: a */
            public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
                AppMethodBeat.m2504i(77479);
                super.mo6642a(recyclerView, i, i2);
                this.joI = aNm.mo1782iS();
                AppMethodBeat.m2505o(77479);
            }
        });
        this.joL.mo66307a((C41525c) new C41525c() {
            /* renamed from: ax */
            public final void mo6644ax(int i, int i2) {
                AppMethodBeat.m2504i(77480);
                super.mo6644ax(i, i2);
                if (LoadMoreRecyclerView.this.joH && aNm.mo1782iS() == LoadMoreRecyclerView.this.joL.getItemCount() - 1 && LoadMoreRecyclerView.this.joG != null) {
                    LoadMoreRecyclerView.this.joG.aMC();
                }
                AppMethodBeat.m2505o(77480);
            }
        });
        AppMethodBeat.m2505o(77485);
    }

    public final void addFooterView(View view) {
        AppMethodBeat.m2504i(77486);
        int footerViewCount = this.joL.getFooterViewCount() - 1;
        if (this.emz == null || footerViewCount < 0) {
            super.addFooterView(view);
            AppMethodBeat.m2505o(77486);
            return;
        }
        super.mo61464b(footerViewCount, view);
        AppMethodBeat.m2505o(77486);
    }

    public void setLayoutManager(C17480i c17480i) {
    }

    public void setLoadingView(View view) {
        AppMethodBeat.m2504i(77487);
        if (this.emz == view) {
            AppMethodBeat.m2505o(77487);
            return;
        }
        if (!(this.emz == null || this.emz.equals(view))) {
            mo61466cW(this.emz);
        }
        this.emz = view;
        if (this.emz != null) {
            addFooterView(this.emz);
            this.emz.setVisibility(this.joH ? 0 : 8);
        }
        AppMethodBeat.m2505o(77487);
    }

    public void setLoadingView(int i) {
        AppMethodBeat.m2504i(77488);
        setLoadingView(LayoutInflater.from(getContext()).inflate(i, this, false));
        AppMethodBeat.m2505o(77488);
    }

    /* renamed from: fh */
    public final void mo22757fh(boolean z) {
        AppMethodBeat.m2504i(77489);
        if (this.joH == z) {
            AppMethodBeat.m2505o(77489);
            return;
        }
        this.joH = z;
        if (this.emz != null) {
            this.emz.setVisibility(this.joH ? 0 : 8);
        }
        AppMethodBeat.m2505o(77489);
    }

    public void setOnLoadingStateChangedListener(C11052a c11052a) {
        this.joG = c11052a;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aSc() {
        AppMethodBeat.m2504i(77490);
        if (this.emz == null) {
            boolean aSc = super.aSc();
            AppMethodBeat.m2505o(77490);
            return aSc;
        } else if (this.joL.getItemCount() == 1 && this.joL.getFooterViewCount() == 1) {
            AppMethodBeat.m2505o(77490);
            return true;
        } else {
            AppMethodBeat.m2505o(77490);
            return false;
        }
    }
}
