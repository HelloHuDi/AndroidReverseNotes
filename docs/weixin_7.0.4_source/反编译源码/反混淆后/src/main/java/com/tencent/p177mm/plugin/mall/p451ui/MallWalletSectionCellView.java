package com.tencent.p177mm.plugin.mall.p451ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.utils.C35520e;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.cgd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView */
public class MallWalletSectionCellView extends LinearLayout {
    static final int koS = C1338a.fromDPToPix(C4996ah.getContext(), 16);
    public View iym;
    public View kiH;
    public TextView onA;
    public TextView onB;
    public CdnImageView onC;
    public TextView onD;
    public ImageView onE;
    public TextView onF;
    public TextView onG;
    public ViewGroup onH;
    public TextView onI;
    public CdnImageView onz;

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView$1 */
    class C124851 implements Runnable {
        C124851() {
        }

        public final void run() {
            AppMethodBeat.m2504i(43249);
            C4990ab.m7411d("MicroMsg.MallWalletSectionCellView", "x: %s, left: %s", Float.valueOf(MallWalletSectionCellView.this.onA.getX()), Integer.valueOf(MallWalletSectionCellView.this.onA.getLeft()));
            LayoutParams layoutParams = new LayoutParams(-1, 1);
            layoutParams.leftMargin = MallWalletSectionCellView.this.onA.getLeft();
            MallWalletSectionCellView.this.kiH.setLayoutParams(layoutParams);
            MallWalletSectionCellView.this.kiH.setVisibility(0);
            AppMethodBeat.m2505o(43249);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView$2 */
    class C124862 implements OnClickListener {
        final /* synthetic */ cgd onK;
        final /* synthetic */ JSONObject onL;

        C124862(cgd cgd, JSONObject jSONObject) {
            this.onK = cgd;
            this.onL = jSONObject;
        }

        public final void onClick(View view) {
            int i;
            AppMethodBeat.m2504i(43250);
            C35520e.m58290a(MallWalletSectionCellView.this.getContext(), this.onK.vCP);
            MallWalletSectionCellView.m45143a(MallWalletSectionCellView.this);
            if (!(this.onL == null || this.onK.xfj == null)) {
                this.onL.remove(this.onK.xfj.wpJ);
                this.onL.remove(String.format("%s_expiretime", new Object[]{this.onK.xfj.wpJ}));
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MALL_UI_ITEM_REDDOT_CONFIG_STRING_SYNC, this.onL.toString());
            }
            String str = "";
            if (this.onK.vCP.type == 1) {
                str = this.onK.vCP.url;
                i = 1;
            } else if (this.onK.vCP.type == 2) {
                if (this.onK.vCP.wVC != null) {
                    str = this.onK.vCP.wVC.username;
                }
                i = 2;
            } else if (this.onK.vCP.type == 4) {
                str = this.onK.vCP.url;
                i = 3;
            } else {
                i = 0;
            }
            C7060h.pYm.mo8381e(16502, Integer.valueOf(2), str, Integer.valueOf(i));
            AppMethodBeat.m2505o(43250);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m45143a(MallWalletSectionCellView mallWalletSectionCellView) {
        AppMethodBeat.m2504i(43257);
        mallWalletSectionCellView.bNs();
        AppMethodBeat.m2505o(43257);
    }

    static {
        AppMethodBeat.m2504i(43258);
        AppMethodBeat.m2505o(43258);
    }

    public MallWalletSectionCellView(Context context) {
        super(context);
        AppMethodBeat.m2504i(43251);
        init(context);
        AppMethodBeat.m2505o(43251);
    }

    public MallWalletSectionCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(43252);
        init(context);
        AppMethodBeat.m2505o(43252);
    }

    public MallWalletSectionCellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(43253);
        init(context);
        AppMethodBeat.m2505o(43253);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(43254);
        this.iym = LayoutInflater.from(context).inflate(2130970064, this, true);
        this.onz = (CdnImageView) this.iym.findViewById(2131825900);
        this.onA = (TextView) this.iym.findViewById(2131825901);
        this.onB = (TextView) this.iym.findViewById(2131825906);
        this.onC = (CdnImageView) this.iym.findViewById(2131825908);
        this.onD = (TextView) this.iym.findViewById(2131825907);
        this.onE = (ImageView) this.iym.findViewById(2131825903);
        this.onF = (TextView) this.iym.findViewById(2131825904);
        this.onG = (TextView) this.iym.findViewById(2131825905);
        this.kiH = this.iym.findViewById(2131825909);
        this.onH = (ViewGroup) this.iym.findViewById(2131825899);
        this.onI = (TextView) this.iym.findViewById(2131825902);
        AppMethodBeat.m2505o(43254);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aN */
    public final int mo46449aN(float f) {
        AppMethodBeat.m2504i(43255);
        int fromDPToPix = C1338a.fromDPToPix(getContext(), (int) f);
        AppMethodBeat.m2505o(43255);
        return fromDPToPix;
    }

    /* Access modifiers changed, original: final */
    public final void bNs() {
        AppMethodBeat.m2504i(43256);
        this.onF.setVisibility(8);
        this.onE.setVisibility(8);
        this.onG.setVisibility(8);
        AppMethodBeat.m2505o(43256);
    }
}
