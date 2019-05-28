package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Context;
import android.support.p057v4.view.C0477s;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyAutoScrollItem.C34462b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView */
public class LuckyMoneyAutoScrollView extends RelativeLayout implements C34462b {
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
    private C43266a ocx;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView$2 */
    class C124362 implements Runnable {
        C124362() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42569);
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
            AppMethodBeat.m2505o(42569);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView$1 */
    class C344631 implements Runnable {
        C344631() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42568);
            LuckyMoneyAutoScrollView.this.ocn.setVisibility(0);
            LuckyMoneyAutoScrollView.this.oco.setVisibility(0);
            LuckyMoneyAutoScrollView.this.ocp.setVisibility(0);
            LuckyMoneyAutoScrollView.this.ock.bMm();
            LuckyMoneyAutoScrollView.this.ocl.bMm();
            LuckyMoneyAutoScrollView.this.ocm.bMm();
            AppMethodBeat.m2505o(42568);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView$a */
    public interface C43266a {
        void bMo();
    }

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(42570);
        this.oct = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.ocu = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.ocv = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.ocw = false;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(2130969967, this);
        this.contentView = inflate;
        this.ock = (LuckyMoneyAutoScrollItem) inflate.findViewById(2131825382);
        this.ocl = (LuckyMoneyAutoScrollItem) inflate.findViewById(2131825386);
        this.ocm = (LuckyMoneyAutoScrollItem) inflate.findViewById(2131825390);
        C0477s.m949o(this.ock, 2);
        C0477s.m949o(this.ocl, 2);
        C0477s.m949o(this.ocm, 2);
        this.ocn = (RelativeLayout) inflate.findViewById(2131825383);
        this.oco = (RelativeLayout) inflate.findViewById(2131825387);
        this.ocp = (RelativeLayout) inflate.findViewById(2131825391);
        this.ocq = (ImageView) inflate.findViewById(2131825380);
        this.ocr = (ImageView) inflate.findViewById(2131825385);
        this.ocs = (ImageView) inflate.findViewById(2131825389);
        this.och = (RelativeLayout) inflate.findViewById(2131825381);
        this.oci = (RelativeLayout) inflate.findViewById(2131825384);
        this.ocj = (RelativeLayout) inflate.findViewById(2131825388);
        AppMethodBeat.m2505o(42570);
    }

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setFinalText(String str) {
        AppMethodBeat.m2504i(42571);
        C4990ab.m7417i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", str);
        this.oct = str.substring(0, 1);
        this.ocu = str.substring(2, 3);
        this.ocv = str.substring(3, 4);
        this.ock.setFinalNumber(C5046bo.getInt(this.oct, 0));
        this.ocl.setFinalNumber(C5046bo.getInt(this.ocu, 0));
        this.ocm.setFinalNumber(C5046bo.getInt(this.ocv, 0));
        this.ocq.setImageResource(((Integer) LuckyMoneyAutoScrollItem.ocb.get(C5046bo.getInt(this.oct, 0))).intValue());
        this.ocr.setImageResource(((Integer) LuckyMoneyAutoScrollItem.ocb.get(C5046bo.getInt(this.ocu, 0))).intValue());
        this.ocs.setImageResource(((Integer) LuckyMoneyAutoScrollItem.ocb.get(C5046bo.getInt(this.ocv, 0))).intValue());
        this.ocq.setVisibility(4);
        this.ocr.setVisibility(4);
        this.ocs.setVisibility(4);
        this.ock.setOnScrollEndListener(this);
        this.ocl.setOnScrollEndListener(this);
        this.ocm.setOnScrollEndListener(this);
        C4990ab.m7417i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", this.oct, this.ocu, this.ocv);
        AppMethodBeat.m2505o(42571);
    }

    /* renamed from: a */
    public final void mo68803a(C43266a c43266a) {
        AppMethodBeat.m2504i(42572);
        this.ocx = c43266a;
        C5004al.m7441d(new C344631());
        AppMethodBeat.m2505o(42572);
    }

    public final void bMn() {
        AppMethodBeat.m2504i(42573);
        this.ock.setVisibility(8);
        this.ocl.setVisibility(8);
        this.ocm.setVisibility(8);
        this.ocq.setVisibility(0);
        this.ocr.setVisibility(0);
        this.ocs.setVisibility(0);
        AppMethodBeat.m2505o(42573);
    }

    public final void aQe() {
        AppMethodBeat.m2504i(42574);
        if (!this.ocw) {
            this.ocw = true;
            C5004al.m7441d(new C124362());
        }
        AppMethodBeat.m2505o(42574);
    }

    /* renamed from: eu */
    public final void mo68805eu(int i, int i2) {
        AppMethodBeat.m2504i(42575);
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
        AppMethodBeat.m2505o(42575);
    }
}
