package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class LuckyMoneyAutoScrollView extends RelativeLayout implements b {
    private View contentView;
    private Context mContext;
    private RelativeLayout och;
    private RelativeLayout oci;
    private RelativeLayout ocj;
    LuckyMoneyAutoScrollItem ock;
    LuckyMoneyAutoScrollItem ocl;
    LuckyMoneyAutoScrollItem ocm;
    private RelativeLayout ocn;
    private RelativeLayout oco;
    private RelativeLayout ocp;
    ImageView ocq;
    ImageView ocr;
    ImageView ocs;
    private String oct;
    private String ocu;
    private String ocv;
    boolean ocw;
    private a ocx;

    public interface a {
        void bMo();
    }

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(42570);
        this.oct = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.ocu = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.ocv = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.ocw = false;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.a_s, this);
        this.contentView = inflate;
        this.ock = (LuckyMoneyAutoScrollItem) inflate.findViewById(R.id.css);
        this.ocl = (LuckyMoneyAutoScrollItem) inflate.findViewById(R.id.csw);
        this.ocm = (LuckyMoneyAutoScrollItem) inflate.findViewById(R.id.ct0);
        s.o(this.ock, 2);
        s.o(this.ocl, 2);
        s.o(this.ocm, 2);
        this.ocn = (RelativeLayout) inflate.findViewById(R.id.cst);
        this.oco = (RelativeLayout) inflate.findViewById(R.id.csx);
        this.ocp = (RelativeLayout) inflate.findViewById(R.id.ct1);
        this.ocq = (ImageView) inflate.findViewById(R.id.csq);
        this.ocr = (ImageView) inflate.findViewById(R.id.csv);
        this.ocs = (ImageView) inflate.findViewById(R.id.csz);
        this.och = (RelativeLayout) inflate.findViewById(R.id.csr);
        this.oci = (RelativeLayout) inflate.findViewById(R.id.csu);
        this.ocj = (RelativeLayout) inflate.findViewById(R.id.csy);
        AppMethodBeat.o(42570);
    }

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setFinalText(String str) {
        AppMethodBeat.i(42571);
        ab.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", str);
        this.oct = str.substring(0, 1);
        this.ocu = str.substring(2, 3);
        this.ocv = str.substring(3, 4);
        this.ock.setFinalNumber(bo.getInt(this.oct, 0));
        this.ocl.setFinalNumber(bo.getInt(this.ocu, 0));
        this.ocm.setFinalNumber(bo.getInt(this.ocv, 0));
        this.ocq.setImageResource(((Integer) LuckyMoneyAutoScrollItem.ocb.get(bo.getInt(this.oct, 0))).intValue());
        this.ocr.setImageResource(((Integer) LuckyMoneyAutoScrollItem.ocb.get(bo.getInt(this.ocu, 0))).intValue());
        this.ocs.setImageResource(((Integer) LuckyMoneyAutoScrollItem.ocb.get(bo.getInt(this.ocv, 0))).intValue());
        this.ocq.setVisibility(4);
        this.ocr.setVisibility(4);
        this.ocs.setVisibility(4);
        this.ock.setOnScrollEndListener(this);
        this.ocl.setOnScrollEndListener(this);
        this.ocm.setOnScrollEndListener(this);
        ab.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", this.oct, this.ocu, this.ocv);
        AppMethodBeat.o(42571);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(42572);
        this.ocx = aVar;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(42568);
                LuckyMoneyAutoScrollView.this.ocn.setVisibility(0);
                LuckyMoneyAutoScrollView.this.oco.setVisibility(0);
                LuckyMoneyAutoScrollView.this.ocp.setVisibility(0);
                LuckyMoneyAutoScrollView.this.ock.bMm();
                LuckyMoneyAutoScrollView.this.ocl.bMm();
                LuckyMoneyAutoScrollView.this.ocm.bMm();
                AppMethodBeat.o(42568);
            }
        });
        AppMethodBeat.o(42572);
    }

    public final void bMn() {
        AppMethodBeat.i(42573);
        this.ock.setVisibility(8);
        this.ocl.setVisibility(8);
        this.ocm.setVisibility(8);
        this.ocq.setVisibility(0);
        this.ocr.setVisibility(0);
        this.ocs.setVisibility(0);
        AppMethodBeat.o(42573);
    }

    public final void aQe() {
        AppMethodBeat.i(42574);
        if (!this.ocw) {
            this.ocw = true;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(42569);
                    LuckyMoneyAutoScrollView.this.ocn.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.oco.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.ocp.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.ock.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.ocl.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.ocm.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.ocq.setVisibility(0);
                    LuckyMoneyAutoScrollView.this.ocr.setVisibility(0);
                    LuckyMoneyAutoScrollView.this.ocs.setVisibility(0);
                    if (LuckyMoneyAutoScrollView.this.ocx != null) {
                        LuckyMoneyAutoScrollView.this.ocx.bMo();
                    }
                    AppMethodBeat.o(42569);
                }
            });
        }
        AppMethodBeat.o(42574);
    }

    public final void eu(int i, int i2) {
        AppMethodBeat.i(42575);
        if (i > 0 && i2 > 0) {
            LayoutParams layoutParams = (LayoutParams) this.contentView.getLayoutParams();
            layoutParams.height = i2;
            this.contentView.setLayoutParams(layoutParams);
            this.contentView.invalidate();
            layoutParams = (LayoutParams) this.och.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.och.setLayoutParams(layoutParams);
            this.och.invalidate();
            layoutParams = (LayoutParams) this.oci.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.oci.setLayoutParams(layoutParams);
            this.oci.invalidate();
            layoutParams = (LayoutParams) this.ocj.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            layoutParams.leftMargin = 0;
            this.ocj.setLayoutParams(layoutParams);
            this.ocj.invalidate();
        }
        AppMethodBeat.o(42575);
    }
}
