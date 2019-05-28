package com.tencent.p177mm.plugin.location.p446ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.MMGridPaper;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.location.ui.b */
public final class C46047b {
    private Context mContext = null;
    private C15532i nLl = null;
    private MMGridPaper nLm = null;
    private C39290a nLn = null;
    private ViewGroup nLo = null;
    private RelativeLayout nLp = null;
    private ArrayList<String> nLq = null;
    private int nLr = 0;

    private C46047b(Context context) {
        AppMethodBeat.m2504i(113423);
        this.mContext = context;
        this.nLl = new C15532i(this.mContext, C25738R.style.a0n);
        this.nLo = (ViewGroup) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2130968793, null);
        this.nLm = (MMGridPaper) this.nLo.findViewById(2131821562);
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
        this.nLn = new C39290a();
        this.nLm.setGridPaperAdapter(this.nLn);
        AppMethodBeat.m2505o(113423);
    }

    /* renamed from: b */
    public static void m85713b(Context context, ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(113424);
        C4990ab.m7411d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", Integer.valueOf(arrayList.size()));
        C46047b c46047b = new C46047b(context);
        c46047b.nLq = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c46047b.nLq.add((String) it.next());
        }
        if (c46047b.nLq.size() < 3) {
            c46047b.nLm.setMaxCol(c46047b.nLq.size());
        } else {
            c46047b.nLm.setMaxCol(3);
        }
        LayoutParams layoutParams = c46047b.nLm.getLayoutParams();
        c46047b.nLr = C1338a.fromDPToPix(c46047b.mContext, 70);
        int fromDPToPix = C1338a.fromDPToPix(c46047b.mContext, 8);
        if (c46047b.nLq.size() <= 0) {
            fromDPToPix = 0;
        } else if (c46047b.nLq.size() < 3) {
            fromDPToPix = (fromDPToPix * (c46047b.nLq.size() - 1)) + (c46047b.nLr * c46047b.nLq.size());
        } else {
            fromDPToPix = (fromDPToPix * 2) + (c46047b.nLr * 3);
        }
        String gi = C4977b.m7373gi(c46047b.mContext);
        C4990ab.m7411d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", Integer.valueOf(fromDPToPix), Integer.valueOf(c46047b.nLq.size()), Integer.valueOf(c46047b.nLr), gi);
        layoutParams.width = fromDPToPix;
        c46047b.nLr = C1338a.fromDPToPix(c46047b.mContext, 70);
        fromDPToPix = C1338a.fromDPToPix(c46047b.mContext, 15);
        if (c46047b.nLq.size() > 0) {
            if (c46047b.nLq.size() <= 3) {
                fromDPToPix += c46047b.nLr;
            } else if (c46047b.nLq.size() <= 6) {
                fromDPToPix += c46047b.nLr * 2;
            } else {
                fromDPToPix = ((fromDPToPix * 2) + (c46047b.nLr * 3)) + C1338a.fromDPToPix(c46047b.mContext, 10);
            }
            C4990ab.m7411d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", Integer.valueOf(fromDPToPix));
        } else {
            fromDPToPix = 0;
        }
        layoutParams.height = fromDPToPix;
        c46047b.nLm.setLayoutParams(layoutParams);
        c46047b.nLm.requestLayout();
        c46047b.nLn.mo62192F(c46047b.nLq);
        c46047b.nLl.show();
        AppMethodBeat.m2505o(113424);
    }
}
