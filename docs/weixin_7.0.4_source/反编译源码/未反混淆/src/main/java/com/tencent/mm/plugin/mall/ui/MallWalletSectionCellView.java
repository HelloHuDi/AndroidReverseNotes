package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.utils.e;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac;
import org.json.JSONObject;

public class MallWalletSectionCellView extends LinearLayout {
    static final int koS = a.fromDPToPix(ah.getContext(), 16);
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

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView$2 */
    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ cgd onK;
        final /* synthetic */ JSONObject onL;

        AnonymousClass2(cgd cgd, JSONObject jSONObject) {
            this.onK = cgd;
            this.onL = jSONObject;
        }

        public final void onClick(View view) {
            int i;
            AppMethodBeat.i(43250);
            e.a(MallWalletSectionCellView.this.getContext(), this.onK.vCP);
            MallWalletSectionCellView.a(MallWalletSectionCellView.this);
            if (!(this.onL == null || this.onK.xfj == null)) {
                this.onL.remove(this.onK.xfj.wpJ);
                this.onL.remove(String.format("%s_expiretime", new Object[]{this.onK.xfj.wpJ}));
                g.RP().Ry().set(ac.a.USERINFO_WALLET_New_MALL_UI_ITEM_REDDOT_CONFIG_STRING_SYNC, this.onL.toString());
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
            h.pYm.e(16502, Integer.valueOf(2), str, Integer.valueOf(i));
            AppMethodBeat.o(43250);
        }
    }

    static /* synthetic */ void a(MallWalletSectionCellView mallWalletSectionCellView) {
        AppMethodBeat.i(43257);
        mallWalletSectionCellView.bNs();
        AppMethodBeat.o(43257);
    }

    static {
        AppMethodBeat.i(43258);
        AppMethodBeat.o(43258);
    }

    public MallWalletSectionCellView(Context context) {
        super(context);
        AppMethodBeat.i(43251);
        init(context);
        AppMethodBeat.o(43251);
    }

    public MallWalletSectionCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(43252);
        init(context);
        AppMethodBeat.o(43252);
    }

    public MallWalletSectionCellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(43253);
        init(context);
        AppMethodBeat.o(43253);
    }

    private void init(Context context) {
        AppMethodBeat.i(43254);
        this.iym = LayoutInflater.from(context).inflate(R.layout.ace, this, true);
        this.onz = (CdnImageView) this.iym.findViewById(R.id.d6s);
        this.onA = (TextView) this.iym.findViewById(R.id.d6t);
        this.onB = (TextView) this.iym.findViewById(R.id.d6y);
        this.onC = (CdnImageView) this.iym.findViewById(R.id.d70);
        this.onD = (TextView) this.iym.findViewById(R.id.d6z);
        this.onE = (ImageView) this.iym.findViewById(R.id.d6v);
        this.onF = (TextView) this.iym.findViewById(R.id.d6w);
        this.onG = (TextView) this.iym.findViewById(R.id.d6x);
        this.kiH = this.iym.findViewById(R.id.d71);
        this.onH = (ViewGroup) this.iym.findViewById(R.id.d6r);
        this.onI = (TextView) this.iym.findViewById(R.id.d6u);
        AppMethodBeat.o(43254);
    }

    /* Access modifiers changed, original: final */
    public final int aN(float f) {
        AppMethodBeat.i(43255);
        int fromDPToPix = a.fromDPToPix(getContext(), (int) f);
        AppMethodBeat.o(43255);
        return fromDPToPix;
    }

    /* Access modifiers changed, original: final */
    public final void bNs() {
        AppMethodBeat.i(43256);
        this.onF.setVisibility(8);
        this.onE.setVisibility(8);
        this.onG.setVisibility(8);
        AppMethodBeat.o(43256);
    }
}
