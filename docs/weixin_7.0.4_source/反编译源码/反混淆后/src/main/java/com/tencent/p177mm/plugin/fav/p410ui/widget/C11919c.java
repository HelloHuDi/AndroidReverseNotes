package com.tencent.p177mm.plugin.fav.p410ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.ui.widget.c */
public final class C11919c extends LinearLayout {
    private View mpJ;
    public View mpK;
    public View mpL;
    private C11922a mpM;
    private boolean mpN = false;
    private boolean mpO = false;
    private int mpP;

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.c$1 */
    class C119201 implements OnClickListener {
        C119201() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74676);
            if (C11919c.this.mpP == 1 || C11919c.this.mpP == 3) {
                C4990ab.m7416i("MicroMsg.FavHeaderView", "click clear fav item");
                if (C11919c.this.mpM != null) {
                    C11919c.this.mpM.bvR();
                }
            }
            AppMethodBeat.m2505o(74676);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.c$2 */
    class C119212 implements OnClickListener {
        C119212() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74677);
            C4990ab.m7416i("MicroMsg.FavHeaderView", "click retry item");
            List<C27966g> buX = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().buX();
            if (buX == null || buX.isEmpty()) {
                AppMethodBeat.m2505o(74677);
                return;
            }
            for (C27966g c27966g : buX) {
                if (c27966g.bux()) {
                    C39037b.m66410l(c27966g);
                } else {
                    C4990ab.m7421w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", Integer.valueOf(c27966g.field_id));
                }
            }
            C11919c.this.mpL.setVisibility(8);
            C11919c.this.mpK.setVisibility(8);
            AppMethodBeat.m2505o(74677);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.c$a */
    public interface C11922a {
        void bvR();
    }

    public C11919c(Context context) {
        super(context);
        AppMethodBeat.m2504i(74678);
        setOrientation(1);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        this.mpJ = View.inflate(getContext(), 2130969521, null);
        View inflate = View.inflate(getContext(), 2130969500, null);
        inflate.findViewById(2131823893).setOnClickListener(new C119201());
        this.mpK = inflate;
        inflate = View.inflate(getContext(), 2130969520, null);
        inflate.findViewById(2131823948).setOnClickListener(new C119212());
        this.mpL = inflate;
        addView(this.mpJ, new LayoutParams(layoutParams));
        addView(this.mpK, new LayoutParams(layoutParams));
        addView(this.mpL, new LayoutParams(layoutParams));
        AppMethodBeat.m2505o(74678);
    }

    /* renamed from: hn */
    public final void mo23770hn(boolean z) {
        AppMethodBeat.m2504i(74679);
        this.mpJ.setVisibility(z ? 0 : 8);
        AppMethodBeat.m2505o(74679);
    }

    /* renamed from: vI */
    private void m19805vI(int i) {
        AppMethodBeat.m2504i(74680);
        this.mpP = i;
        C4990ab.m7416i("MicroMsg.FavHeaderView", "showStatusBar status:".concat(String.valueOf(i)));
        if (i == 0) {
            this.mpL.setVisibility(8);
            this.mpK.setVisibility(8);
            AppMethodBeat.m2505o(74680);
        } else if (i == 1) {
            if (!this.mpN) {
                C7060h.pYm.mo8381e(14109, Integer.valueOf(1));
            }
            this.mpN = true;
            this.mpL.setVisibility(8);
            this.mpK.setVisibility(0);
            this.mpK.findViewById(2131823896).setVisibility(0);
            this.mpK.findViewById(2131823897).setVisibility(8);
            AppMethodBeat.m2505o(74680);
        } else if (i == 2) {
            this.mpL.setVisibility(0);
            this.mpK.setVisibility(8);
            AppMethodBeat.m2505o(74680);
        } else {
            if (i == 3) {
                if (!this.mpO) {
                    C7060h.pYm.mo8381e(14109, Integer.valueOf(0));
                }
                this.mpO = true;
                this.mpL.setVisibility(8);
                this.mpK.setVisibility(0);
                this.mpK.findViewById(2131823896).setVisibility(8);
                this.mpK.findViewById(2131823897).setVisibility(0);
            }
            AppMethodBeat.m2505o(74680);
        }
    }

    public final void bwA() {
        long j;
        int i;
        AppMethodBeat.m2504i(74681);
        List<C27966g> buX = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().buX();
        if (buX != null) {
            j = 0;
            i = 0;
            for (C27966g a : buX) {
                j = C39037b.m66344a(a) + j;
                i = 1;
            }
            C4990ab.m7417i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", Integer.valueOf(buX.size()), Long.valueOf(j));
        } else {
            j = 0;
            i = 0;
        }
        if (i != 0) {
            if (j > C39037b.buh()) {
                m19805vI(1);
                AppMethodBeat.m2505o(74681);
                return;
            }
            m19805vI(2);
            AppMethodBeat.m2505o(74681);
        } else if (C39037b.buk()) {
            m19805vI(3);
            AppMethodBeat.m2505o(74681);
        } else {
            m19805vI(0);
            AppMethodBeat.m2505o(74681);
        }
    }

    public final void setCleanFavSpace(C11922a c11922a) {
        this.mpM = c11922a;
    }
}
