package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MRecyclerView extends RecyclerView {
    private View Ek;
    protected a joL;
    private a joM;
    private b joN;

    public interface a {
        void I(View view, int i);
    }

    public interface b {
        boolean L(View view, int i);
    }

    public MRecyclerView(Context context) {
        super(context);
        AppMethodBeat.i(77494);
        init();
        AppMethodBeat.o(77494);
    }

    public MRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(77495);
        init();
        AppMethodBeat.o(77495);
    }

    public MRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(77496);
        init();
        AppMethodBeat.o(77496);
    }

    private void init() {
        AppMethodBeat.i(77497);
        this.joL = new a();
        if (aSd()) {
            this.joL.jR();
        }
        super.setAdapter(this.joL);
        this.joL.a((c) new c() {
            public final void onChanged() {
                AppMethodBeat.i(77491);
                if (MRecyclerView.this.Ek != null) {
                    MRecyclerView.this.Ek.setVisibility(MRecyclerView.this.aSc() ? 0 : 8);
                }
                AppMethodBeat.o(77491);
            }
        });
        AppMethodBeat.o(77497);
    }

    public final int S(v vVar) {
        AppMethodBeat.i(77498);
        if (this.joL == null) {
            AppMethodBeat.o(77498);
            return -1;
        }
        a aVar = this.joL;
        if (vVar == null) {
            AppMethodBeat.o(77498);
            return -1;
        } else if (vVar.kj() == -1) {
            AppMethodBeat.o(77498);
            return -1;
        } else {
            int i;
            int kj = vVar.kj();
            if (aVar.joz.isEmpty()) {
                i = 0;
            } else {
                i = 1;
            }
            i = kj - i;
            AppMethodBeat.o(77498);
            return i;
        }
    }

    public void setAdapter(android.support.v7.widget.RecyclerView.a aVar) {
        AppMethodBeat.i(77499);
        a aVar2 = this.joL;
        if (aVar2.Yq != null) {
            if (!aVar2.Yq.equals(aVar)) {
                aVar2.Yq.b(aVar2.joD);
            }
            AppMethodBeat.o(77499);
        }
        aVar2.Yq = aVar;
        if (aVar2.Yq != null) {
            aVar2.Yq.a(aVar2.joD);
        }
        AppMethodBeat.o(77499);
    }

    public android.support.v7.widget.RecyclerView.a getAdapter() {
        return this.joL;
    }

    public final void bY(int i) {
        AppMethodBeat.i(77500);
        super.bY(i);
        AppMethodBeat.o(77500);
    }

    public final void addHeaderView(View view) {
        AppMethodBeat.i(77501);
        a aVar = this.joL;
        aVar.joz.add(view);
        aVar.ar(0, 1);
        AppMethodBeat.o(77501);
    }

    public void addFooterView(View view) {
        AppMethodBeat.i(77502);
        this.joL.addFooterView(view);
        AppMethodBeat.o(77502);
    }

    public final void b(int i, View view) {
        AppMethodBeat.i(77503);
        this.joL.b(i, view);
        AppMethodBeat.o(77503);
    }

    public final void cW(View view) {
        AppMethodBeat.i(77504);
        this.joL.cW(view);
        AppMethodBeat.o(77504);
    }

    public void setEmptyView(View view) {
        AppMethodBeat.i(77505);
        if (this.Ek == view) {
            AppMethodBeat.o(77505);
            return;
        }
        this.Ek = view;
        if (this.Ek != null) {
            this.Ek.setVisibility(aSc() ? 0 : 8);
        }
        AppMethodBeat.o(77505);
    }

    public View getEmptyView() {
        return this.Ek;
    }

    public void setOnItemClickListener(a aVar) {
        AppMethodBeat.i(77506);
        this.joM = aVar;
        this.joL.joB = new b() {
            public final void J(View view, int i) {
                AppMethodBeat.i(77492);
                if (MRecyclerView.this.joM != null) {
                    MRecyclerView.this.joM.I(view, i);
                }
                AppMethodBeat.o(77492);
            }
        };
        AppMethodBeat.o(77506);
    }

    public void setOnItemLongClickListener(b bVar) {
        AppMethodBeat.i(77507);
        this.joN = bVar;
        this.joL.joC = new c() {
            public final boolean K(View view, int i) {
                AppMethodBeat.i(77493);
                if (MRecyclerView.this.joN != null) {
                    boolean L = MRecyclerView.this.joN.L(view, i);
                    AppMethodBeat.o(77493);
                    return L;
                }
                AppMethodBeat.o(77493);
                return false;
            }
        };
        AppMethodBeat.o(77507);
    }

    /* Access modifiers changed, original: protected */
    public boolean aSc() {
        AppMethodBeat.i(77508);
        if (this.joL.getItemCount() == 0) {
            AppMethodBeat.o(77508);
            return true;
        }
        AppMethodBeat.o(77508);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean aSd() {
        return true;
    }
}
