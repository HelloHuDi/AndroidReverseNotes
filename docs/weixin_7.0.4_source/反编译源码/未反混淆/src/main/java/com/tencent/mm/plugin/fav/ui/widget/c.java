package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class c extends LinearLayout {
    private View mpJ;
    public View mpK;
    public View mpL;
    private a mpM;
    private boolean mpN = false;
    private boolean mpO = false;
    private int mpP;

    public interface a {
        void bvR();
    }

    public c(Context context) {
        super(context);
        AppMethodBeat.i(74678);
        setOrientation(1);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        this.mpJ = View.inflate(getContext(), R.layout.ys, null);
        View inflate = View.inflate(getContext(), R.layout.y8, null);
        inflate.findViewById(R.id.bpi).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(74676);
                if (c.this.mpP == 1 || c.this.mpP == 3) {
                    ab.i("MicroMsg.FavHeaderView", "click clear fav item");
                    if (c.this.mpM != null) {
                        c.this.mpM.bvR();
                    }
                }
                AppMethodBeat.o(74676);
            }
        });
        this.mpK = inflate;
        inflate = View.inflate(getContext(), R.layout.yr, null);
        inflate.findViewById(R.id.br0).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(74677);
                ab.i("MicroMsg.FavHeaderView", "click retry item");
                List<g> buX = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().buX();
                if (buX == null || buX.isEmpty()) {
                    AppMethodBeat.o(74677);
                    return;
                }
                for (g gVar : buX) {
                    if (gVar.bux()) {
                        b.l(gVar);
                    } else {
                        ab.w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", Integer.valueOf(gVar.field_id));
                    }
                }
                c.this.mpL.setVisibility(8);
                c.this.mpK.setVisibility(8);
                AppMethodBeat.o(74677);
            }
        });
        this.mpL = inflate;
        addView(this.mpJ, new LayoutParams(layoutParams));
        addView(this.mpK, new LayoutParams(layoutParams));
        addView(this.mpL, new LayoutParams(layoutParams));
        AppMethodBeat.o(74678);
    }

    public final void hn(boolean z) {
        AppMethodBeat.i(74679);
        this.mpJ.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(74679);
    }

    private void vI(int i) {
        AppMethodBeat.i(74680);
        this.mpP = i;
        ab.i("MicroMsg.FavHeaderView", "showStatusBar status:".concat(String.valueOf(i)));
        if (i == 0) {
            this.mpL.setVisibility(8);
            this.mpK.setVisibility(8);
            AppMethodBeat.o(74680);
        } else if (i == 1) {
            if (!this.mpN) {
                h.pYm.e(14109, Integer.valueOf(1));
            }
            this.mpN = true;
            this.mpL.setVisibility(8);
            this.mpK.setVisibility(0);
            this.mpK.findViewById(R.id.bpl).setVisibility(0);
            this.mpK.findViewById(R.id.bpm).setVisibility(8);
            AppMethodBeat.o(74680);
        } else if (i == 2) {
            this.mpL.setVisibility(0);
            this.mpK.setVisibility(8);
            AppMethodBeat.o(74680);
        } else {
            if (i == 3) {
                if (!this.mpO) {
                    h.pYm.e(14109, Integer.valueOf(0));
                }
                this.mpO = true;
                this.mpL.setVisibility(8);
                this.mpK.setVisibility(0);
                this.mpK.findViewById(R.id.bpl).setVisibility(8);
                this.mpK.findViewById(R.id.bpm).setVisibility(0);
            }
            AppMethodBeat.o(74680);
        }
    }

    public final void bwA() {
        long j;
        int i;
        AppMethodBeat.i(74681);
        List<g> buX = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().buX();
        if (buX != null) {
            j = 0;
            i = 0;
            for (g a : buX) {
                j = b.a(a) + j;
                i = 1;
            }
            ab.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", Integer.valueOf(buX.size()), Long.valueOf(j));
        } else {
            j = 0;
            i = 0;
        }
        if (i != 0) {
            if (j > b.buh()) {
                vI(1);
                AppMethodBeat.o(74681);
                return;
            }
            vI(2);
            AppMethodBeat.o(74681);
        } else if (b.buk()) {
            vI(3);
            AppMethodBeat.o(74681);
        } else {
            vI(0);
            AppMethodBeat.o(74681);
        }
    }

    public final void setCleanFavSpace(a aVar) {
        this.mpM = aVar;
    }
}
