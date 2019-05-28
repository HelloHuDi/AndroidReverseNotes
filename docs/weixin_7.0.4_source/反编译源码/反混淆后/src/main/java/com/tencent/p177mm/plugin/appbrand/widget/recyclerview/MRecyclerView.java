package com.tencent.p177mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41525c;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView */
public class MRecyclerView extends RecyclerView {
    /* renamed from: Ek */
    private View f16157Ek;
    protected C19925a joL;
    private C2594a joM;
    private C11053b joN;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView$a */
    public interface C2594a {
        /* renamed from: I */
        void mo6645I(View view, int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView$b */
    public interface C11053b {
        /* renamed from: L */
        boolean mo7100L(View view, int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView$2 */
    class C336492 implements C19928b {
        C336492() {
        }

        /* renamed from: J */
        public final void mo35179J(View view, int i) {
            AppMethodBeat.m2504i(77492);
            if (MRecyclerView.this.joM != null) {
                MRecyclerView.this.joM.mo6645I(view, i);
            }
            AppMethodBeat.m2505o(77492);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView$3 */
    class C336503 implements C27431c {
        C336503() {
        }

        /* renamed from: K */
        public final boolean mo45203K(View view, int i) {
            AppMethodBeat.m2504i(77493);
            if (MRecyclerView.this.joN != null) {
                boolean L = MRecyclerView.this.joN.mo7100L(view, i);
                AppMethodBeat.m2505o(77493);
                return L;
            }
            AppMethodBeat.m2505o(77493);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView$1 */
    class C386241 extends C41525c {
        C386241() {
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(77491);
            if (MRecyclerView.this.f16157Ek != null) {
                MRecyclerView.this.f16157Ek.setVisibility(MRecyclerView.this.aSc() ? 0 : 8);
            }
            AppMethodBeat.m2505o(77491);
        }
    }

    public MRecyclerView(Context context) {
        super(context);
        AppMethodBeat.m2504i(77494);
        init();
        AppMethodBeat.m2505o(77494);
    }

    public MRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(77495);
        init();
        AppMethodBeat.m2505o(77495);
    }

    public MRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(77496);
        init();
        AppMethodBeat.m2505o(77496);
    }

    private void init() {
        AppMethodBeat.m2504i(77497);
        this.joL = new C19925a();
        if (aSd()) {
            this.joL.mo66319jR();
        }
        super.setAdapter(this.joL);
        this.joL.mo66307a((C41525c) new C386241());
        AppMethodBeat.m2505o(77497);
    }

    /* renamed from: S */
    public final int mo61462S(C41531v c41531v) {
        AppMethodBeat.m2504i(77498);
        if (this.joL == null) {
            AppMethodBeat.m2505o(77498);
            return -1;
        }
        C19925a c19925a = this.joL;
        if (c41531v == null) {
            AppMethodBeat.m2505o(77498);
            return -1;
        } else if (c41531v.mo66454kj() == -1) {
            AppMethodBeat.m2505o(77498);
            return -1;
        } else {
            int i;
            int kj = c41531v.mo66454kj();
            if (c19925a.joz.isEmpty()) {
                i = 0;
            } else {
                i = 1;
            }
            i = kj - i;
            AppMethodBeat.m2505o(77498);
            return i;
        }
    }

    public void setAdapter(C41523a c41523a) {
        AppMethodBeat.m2504i(77499);
        C19925a c19925a = this.joL;
        if (c19925a.f4365Yq != null) {
            if (!c19925a.f4365Yq.equals(c41523a)) {
                c19925a.f4365Yq.mo66313b(c19925a.joD);
            }
            AppMethodBeat.m2505o(77499);
        }
        c19925a.f4365Yq = c41523a;
        if (c19925a.f4365Yq != null) {
            c19925a.f4365Yq.mo66307a(c19925a.joD);
        }
        AppMethodBeat.m2505o(77499);
    }

    public C41523a getAdapter() {
        return this.joL;
    }

    /* renamed from: bY */
    public final void mo61465bY(int i) {
        AppMethodBeat.m2504i(77500);
        super.mo61465bY(i);
        AppMethodBeat.m2505o(77500);
    }

    public final void addHeaderView(View view) {
        AppMethodBeat.m2504i(77501);
        C19925a c19925a = this.joL;
        c19925a.joz.add(view);
        c19925a.mo66308ar(0, 1);
        AppMethodBeat.m2505o(77501);
    }

    public void addFooterView(View view) {
        AppMethodBeat.m2504i(77502);
        this.joL.addFooterView(view);
        AppMethodBeat.m2505o(77502);
    }

    /* renamed from: b */
    public final void mo61464b(int i, View view) {
        AppMethodBeat.m2504i(77503);
        this.joL.mo35174b(i, view);
        AppMethodBeat.m2505o(77503);
    }

    /* renamed from: cW */
    public final void mo61466cW(View view) {
        AppMethodBeat.m2504i(77504);
        this.joL.mo35175cW(view);
        AppMethodBeat.m2505o(77504);
    }

    public void setEmptyView(View view) {
        AppMethodBeat.m2504i(77505);
        if (this.f16157Ek == view) {
            AppMethodBeat.m2505o(77505);
            return;
        }
        this.f16157Ek = view;
        if (this.f16157Ek != null) {
            this.f16157Ek.setVisibility(aSc() ? 0 : 8);
        }
        AppMethodBeat.m2505o(77505);
    }

    public View getEmptyView() {
        return this.f16157Ek;
    }

    public void setOnItemClickListener(C2594a c2594a) {
        AppMethodBeat.m2504i(77506);
        this.joM = c2594a;
        this.joL.joB = new C336492();
        AppMethodBeat.m2505o(77506);
    }

    public void setOnItemLongClickListener(C11053b c11053b) {
        AppMethodBeat.m2504i(77507);
        this.joN = c11053b;
        this.joL.joC = new C336503();
        AppMethodBeat.m2505o(77507);
    }

    /* Access modifiers changed, original: protected */
    public boolean aSc() {
        AppMethodBeat.m2504i(77508);
        if (this.joL.getItemCount() == 0) {
            AppMethodBeat.m2505o(77508);
            return true;
        }
        AppMethodBeat.m2505o(77508);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean aSd() {
        return true;
    }
}
