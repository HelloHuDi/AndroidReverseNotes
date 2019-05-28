package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMGridPaper;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    private Context mContext = null;
    private i nLl = null;
    private MMGridPaper nLm = null;
    private a nLn = null;
    private ViewGroup nLo = null;
    private RelativeLayout nLp = null;
    private ArrayList<String> nLq = null;
    private int nLr = 0;

    private b(Context context) {
        AppMethodBeat.i(113423);
        this.mContext = context;
        this.nLl = new i(this.mContext, R.style.a0n);
        this.nLo = (ViewGroup) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.f6, null);
        this.nLm = (MMGridPaper) this.nLo.findViewById(R.id.a0h);
        this.nLm.dzJ();
        this.nLm.setDialogMode(true);
        this.nLm.dzI();
        this.nLm.setMaxRow(3);
        this.nLm.setMaxCol(3);
        this.nLm.setHeaderView(null);
        this.nLm.dzJ();
        this.nLm.setItemWidthInDp(70);
        this.nLm.setItemHeightInDp(70);
        this.nLl.setCanceledOnTouchOutside(true);
        this.nLl.setContentView(this.nLo);
        this.nLn = new a();
        this.nLm.setGridPaperAdapter(this.nLn);
        AppMethodBeat.o(113423);
    }

    public static void b(Context context, ArrayList<String> arrayList) {
        AppMethodBeat.i(113424);
        ab.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", Integer.valueOf(arrayList.size()));
        b bVar = new b(context);
        bVar.nLq = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bVar.nLq.add((String) it.next());
        }
        if (bVar.nLq.size() < 3) {
            bVar.nLm.setMaxCol(bVar.nLq.size());
        } else {
            bVar.nLm.setMaxCol(3);
        }
        LayoutParams layoutParams = bVar.nLm.getLayoutParams();
        bVar.nLr = a.fromDPToPix(bVar.mContext, 70);
        int fromDPToPix = a.fromDPToPix(bVar.mContext, 8);
        if (bVar.nLq.size() <= 0) {
            fromDPToPix = 0;
        } else if (bVar.nLq.size() < 3) {
            fromDPToPix = (fromDPToPix * (bVar.nLq.size() - 1)) + (bVar.nLr * bVar.nLq.size());
        } else {
            fromDPToPix = (fromDPToPix * 2) + (bVar.nLr * 3);
        }
        String gi = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.gi(bVar.mContext);
        ab.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", Integer.valueOf(fromDPToPix), Integer.valueOf(bVar.nLq.size()), Integer.valueOf(bVar.nLr), gi);
        layoutParams.width = fromDPToPix;
        bVar.nLr = a.fromDPToPix(bVar.mContext, 70);
        fromDPToPix = a.fromDPToPix(bVar.mContext, 15);
        if (bVar.nLq.size() > 0) {
            if (bVar.nLq.size() <= 3) {
                fromDPToPix += bVar.nLr;
            } else if (bVar.nLq.size() <= 6) {
                fromDPToPix += bVar.nLr * 2;
            } else {
                fromDPToPix = ((fromDPToPix * 2) + (bVar.nLr * 3)) + a.fromDPToPix(bVar.mContext, 10);
            }
            ab.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", Integer.valueOf(fromDPToPix));
        } else {
            fromDPToPix = 0;
        }
        layoutParams.height = fromDPToPix;
        bVar.nLm.setLayoutParams(layoutParams);
        bVar.nLm.requestLayout();
        bVar.nLn.F(bVar.nLq);
        bVar.nLl.show();
        AppMethodBeat.o(113424);
    }
}
