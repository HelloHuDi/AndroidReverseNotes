package com.tencent.p177mm.plugin.multitalk.p459ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;

/* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.d */
public final class C39422d implements OnClickListener {
    private Context context;
    private View mKk;
    private int oIA = (C43320b.oIb * 4);
    public int oIB;
    private int oIb = C43320b.oIb;
    private int oIh = C43320b.oIh;
    private LinearLayout oIt;
    public LinearLayout oIu;
    public LinearLayout oIv;
    private int oIw;
    private int oIx;
    private int oIy = (C43320b.oIb + C43320b.oIa);
    private int oIz = ((C43320b.oIb * 2) + C43320b.oIa);
    public int size = 0;

    public C39422d(Activity activity) {
        AppMethodBeat.m2504i(54192);
        this.context = activity.getBaseContext();
        int gd = C1338a.m2868gd(this.context) - (this.oIA * 2);
        this.oIw = (gd - (this.oIy * 10)) / 5;
        this.oIx = (gd - (this.oIz * 10)) / 5;
        gd = (this.oIx * 2) + (this.oIb * 12);
        this.mKk = activity.findViewById(2131820896);
        this.mKk.getLayoutParams().height = gd;
        this.oIt = (LinearLayout) activity.findViewById(2131826247);
        LayoutParams layoutParams = (LayoutParams) this.oIt.getLayoutParams();
        layoutParams.topMargin = this.oIb * 2;
        layoutParams.bottomMargin = this.oIb * 2;
        layoutParams.leftMargin = this.oIA;
        layoutParams.rightMargin = this.oIA;
        this.oIt.setLayoutParams(layoutParams);
        this.oIu = new LinearLayout(this.context);
        this.oIv = new LinearLayout(this.context);
        this.oIu.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.oIv.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        relativeLayout.addView(this.oIv);
        relativeLayout.setLayoutParams(layoutParams2);
        this.oIt.addView(this.oIu);
        this.oIt.addView(relativeLayout);
        AppMethodBeat.m2505o(54192);
    }

    public final void setVisible(boolean z) {
        AppMethodBeat.m2504i(54193);
        if (z) {
            this.mKk.setVisibility(0);
            AppMethodBeat.m2505o(54193);
            return;
        }
        this.mKk.setVisibility(8);
        AppMethodBeat.m2505o(54193);
    }

    /* renamed from: Sp */
    public final void mo62366Sp(String str) {
        AppMethodBeat.m2504i(54194);
        this.size++;
        ImageView imageView = new ImageView(this.context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setTag(str);
        imageView.setOnClickListener(this);
        C40460b.m69434b(imageView, str);
        if (this.size <= 5) {
            this.oIu.addView(imageView);
        } else {
            this.oIv.addView(imageView);
        }
        mo62369zj(this.size);
        mo62370zk(this.size);
        AppMethodBeat.m2505o(54194);
    }

    /* renamed from: zj */
    public final void mo62369zj(int i) {
        AppMethodBeat.m2504i(54195);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oIu.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) this.oIv.getLayoutParams();
        if (i <= 5) {
            layoutParams.height = this.oIw;
            this.oIv.setVisibility(8);
            AppMethodBeat.m2505o(54195);
            return;
        }
        layoutParams.height = this.oIx;
        layoutParams.topMargin = this.oIb * 2;
        layoutParams.bottomMargin = this.oIb * 2;
        this.oIv.setVisibility(0);
        layoutParams2.height = this.oIx;
        layoutParams2.topMargin = this.oIb * 2;
        layoutParams2.bottomMargin = this.oIb * 2;
        AppMethodBeat.m2505o(54195);
    }

    /* renamed from: zk */
    public final void mo62370zk(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(54196);
        int i3;
        LinearLayout.LayoutParams layoutParams;
        if (i <= 5) {
            for (i3 = 0; i3 < this.oIu.getChildCount(); i3++) {
                layoutParams = (LinearLayout.LayoutParams) this.oIu.getChildAt(i3).getLayoutParams();
                layoutParams.width = this.oIw;
                layoutParams.height = this.oIw;
                layoutParams.rightMargin = this.oIy;
                layoutParams.leftMargin = this.oIy;
            }
            while (i2 < this.oIv.getChildCount()) {
                layoutParams = (LinearLayout.LayoutParams) this.oIv.getChildAt(i2).getLayoutParams();
                layoutParams.width = this.oIx;
                layoutParams.height = this.oIx;
                layoutParams.rightMargin = this.oIy;
                layoutParams.leftMargin = this.oIy;
                i2++;
            }
            AppMethodBeat.m2505o(54196);
            return;
        }
        for (i3 = 0; i3 < this.oIu.getChildCount(); i3++) {
            layoutParams = (LinearLayout.LayoutParams) this.oIu.getChildAt(i3).getLayoutParams();
            layoutParams.width = this.oIx;
            layoutParams.height = this.oIx;
            layoutParams.rightMargin = this.oIz;
            layoutParams.leftMargin = this.oIz;
        }
        while (i2 < this.oIv.getChildCount()) {
            layoutParams = (LinearLayout.LayoutParams) this.oIv.getChildAt(i2).getLayoutParams();
            layoutParams.width = this.oIx;
            layoutParams.height = this.oIx;
            layoutParams.rightMargin = this.oIz;
            layoutParams.leftMargin = this.oIz;
            i2++;
        }
        AppMethodBeat.m2505o(54196);
    }

    public final void onClick(View view) {
        this.oIB++;
    }
}
