package com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.protocal.protobuf.bqr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout */
public class WalletLqtArriveTimeLayout extends LinearLayout {
    private OnClickListener nij = new C295561();
    List<bqr> thU = new ArrayList();
    List<WeakReference<C22507b>> thV = new ArrayList();
    bqr thW;
    private C29555a thX;
    boolean thY = false;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout$b */
    static class C22507b {
        public RadioButton aaX;
        public TextView iDT;
        public int index;
        public View jcl;
        public TextView kEq;

        private C22507b() {
        }

        /* synthetic */ C22507b(byte b) {
            this();
        }

        public final void cNg() {
            AppMethodBeat.m2504i(45504);
            this.iDT.setTextColor(C4996ah.getContext().getResources().getColorStateList(C25738R.color.a8l));
            AppMethodBeat.m2505o(45504);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout$a */
    public interface C29555a {
        void cNf();
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout$1 */
    class C295561 implements OnClickListener {
        C295561() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45503);
            WalletLqtArriveTimeLayout.m46905a(WalletLqtArriveTimeLayout.this);
            C22507b c22507b = (C22507b) view.getTag();
            if (WalletLqtArriveTimeLayout.this.thU == null || WalletLqtArriveTimeLayout.this.thU.size() <= c22507b.index) {
                WalletLqtArriveTimeLayout.this.thW = null;
            } else {
                c22507b.aaX.setChecked(true);
                WalletLqtArriveTimeLayout.this.thW = (bqr) WalletLqtArriveTimeLayout.this.thU.get(c22507b.index);
            }
            WalletLqtArriveTimeLayout.m46907c(WalletLqtArriveTimeLayout.this);
            C4990ab.m7417i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", Integer.valueOf(c22507b.index), c22507b.iDT.getText());
            AppMethodBeat.m2505o(45503);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m46907c(WalletLqtArriveTimeLayout walletLqtArriveTimeLayout) {
        AppMethodBeat.m2504i(45512);
        walletLqtArriveTimeLayout.cNe();
        AppMethodBeat.m2505o(45512);
    }

    public WalletLqtArriveTimeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(45505);
        AppMethodBeat.m2505o(45505);
    }

    public WalletLqtArriveTimeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(45506);
        AppMethodBeat.m2505o(45506);
    }

    public void setCallback(C29555a c29555a) {
        this.thX = c29555a;
    }

    private void cNe() {
        AppMethodBeat.m2504i(45507);
        if (this.thX != null) {
            this.thX.cNf();
        }
        AppMethodBeat.m2505o(45507);
    }

    public bqr getSelectRedeemType() {
        return this.thW;
    }

    public List<bqr> getRedeemTypeList() {
        return this.thU;
    }

    public void setRedeemTypeList(List<bqr> list) {
        AppMethodBeat.m2504i(45508);
        this.thY = true;
        this.thU.addAll(list);
        this.thV.clear();
        removeAllViews();
        setVisibility(0);
        if (!(this.thU == null || this.thU.isEmpty())) {
            int i = 0;
            for (bqr bqr : this.thU) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(2130971119, this, false);
                C22507b c22507b = new C22507b();
                c22507b.jcl = linearLayout;
                c22507b.iDT = (TextView) linearLayout.findViewById(2131828855);
                c22507b.kEq = (TextView) linearLayout.findViewById(2131828856);
                c22507b.aaX = (RadioButton) linearLayout.findViewById(2131828857);
                C4990ab.m7411d("MicroMsg.WalletLqtArriveTimeLayout", "arrive wording: %s", bqr.wTb);
                c22507b.iDT.setText(bqr.wTb);
                if (C5046bo.isNullOrNil(bqr.wTc)) {
                    c22507b.kEq.setVisibility(8);
                } else {
                    c22507b.kEq.setText(bqr.wTc);
                }
                if (i == 0) {
                    c22507b.aaX.setChecked(true);
                    this.thW = bqr;
                }
                int i2 = i + 1;
                c22507b.index = i;
                linearLayout.setTag(c22507b);
                linearLayout.setOnClickListener(this.nij);
                this.thV.add(new WeakReference(c22507b));
                addView(linearLayout);
                i = i2;
            }
        }
        AppMethodBeat.m2505o(45508);
    }

    /* renamed from: a */
    private static void m46904a(C22507b c22507b, boolean z) {
        AppMethodBeat.m2504i(45509);
        c22507b.aaX.setEnabled(z);
        c22507b.iDT.setEnabled(z);
        c22507b.kEq.setEnabled(z);
        c22507b.jcl.setEnabled(z);
        AppMethodBeat.m2505o(45509);
    }

    public final void acj(String str) {
        AppMethodBeat.m2504i(45510);
        C4990ab.m7417i("MicroMsg.WalletLqtArriveTimeLayout", "input money: %s", str);
        if (this.thU == null || this.thU.isEmpty()) {
            AppMethodBeat.m2505o(45510);
            return;
        }
        this.thW = null;
        for (WeakReference weakReference : this.thV) {
            if (weakReference.get() != null) {
                ((C22507b) weakReference.get()).aaX.setEnabled(true);
                ((C22507b) weakReference.get()).aaX.setChecked(false);
            }
        }
        int iy = C36391e.m60012iy(str, "100");
        int i = 0;
        for (bqr bqr : this.thU) {
            if (bqr.wTd < 0 || iy <= bqr.wTd) {
                C22507b c22507b = (C22507b) ((WeakReference) this.thV.get(i)).get();
                if (c22507b != null) {
                    WalletLqtArriveTimeLayout.m46904a(c22507b, true);
                    if (this.thW == null) {
                        C4990ab.m7417i("MicroMsg.WalletLqtArriveTimeLayout", "auto select type: %s", Integer.valueOf(bqr.wOl));
                        c22507b.aaX.setChecked(true);
                        this.thW = bqr;
                        cNe();
                        if (i > 0) {
                            c22507b.iDT.setTextColor(C4996ah.getContext().getResources().getColor(C25738R.color.f12069r8));
                        } else {
                            c22507b.cNg();
                        }
                    } else {
                        c22507b.cNg();
                    }
                }
            } else {
                C4990ab.m7417i("MicroMsg.WalletLqtArriveTimeLayout", "disable item: %s, %s", Integer.valueOf(i), Integer.valueOf(bqr.wTd));
                C22507b c22507b2 = (C22507b) ((WeakReference) this.thV.get(i)).get();
                if (c22507b2 != null) {
                    c22507b2.aaX.setChecked(false);
                    WalletLqtArriveTimeLayout.m46904a(c22507b2, false);
                    this.thW = null;
                    cNe();
                }
            }
            i++;
        }
        AppMethodBeat.m2505o(45510);
    }

    /* renamed from: a */
    static /* synthetic */ void m46905a(WalletLqtArriveTimeLayout walletLqtArriveTimeLayout) {
        AppMethodBeat.m2504i(45511);
        for (WeakReference weakReference : walletLqtArriveTimeLayout.thV) {
            if (weakReference.get() != null && ((C22507b) weakReference.get()).aaX.isEnabled()) {
                ((C22507b) weakReference.get()).aaX.setChecked(false);
            }
        }
        AppMethodBeat.m2505o(45511);
    }
}
