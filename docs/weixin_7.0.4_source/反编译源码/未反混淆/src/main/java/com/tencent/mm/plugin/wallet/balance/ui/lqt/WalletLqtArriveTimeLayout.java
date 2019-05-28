package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WalletLqtArriveTimeLayout extends LinearLayout {
    private OnClickListener nij = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(45503);
            WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
            b bVar = (b) view.getTag();
            if (WalletLqtArriveTimeLayout.this.thU == null || WalletLqtArriveTimeLayout.this.thU.size() <= bVar.index) {
                WalletLqtArriveTimeLayout.this.thW = null;
            } else {
                bVar.aaX.setChecked(true);
                WalletLqtArriveTimeLayout.this.thW = (bqr) WalletLqtArriveTimeLayout.this.thU.get(bVar.index);
            }
            WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
            ab.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", Integer.valueOf(bVar.index), bVar.iDT.getText());
            AppMethodBeat.o(45503);
        }
    };
    List<bqr> thU = new ArrayList();
    List<WeakReference<b>> thV = new ArrayList();
    bqr thW;
    private a thX;
    boolean thY = false;

    static class b {
        public RadioButton aaX;
        public TextView iDT;
        public int index;
        public View jcl;
        public TextView kEq;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void cNg() {
            AppMethodBeat.i(45504);
            this.iDT.setTextColor(ah.getContext().getResources().getColorStateList(R.color.a8l));
            AppMethodBeat.o(45504);
        }
    }

    public interface a {
        void cNf();
    }

    static /* synthetic */ void c(WalletLqtArriveTimeLayout walletLqtArriveTimeLayout) {
        AppMethodBeat.i(45512);
        walletLqtArriveTimeLayout.cNe();
        AppMethodBeat.o(45512);
    }

    public WalletLqtArriveTimeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(45505);
        AppMethodBeat.o(45505);
    }

    public WalletLqtArriveTimeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(45506);
        AppMethodBeat.o(45506);
    }

    public void setCallback(a aVar) {
        this.thX = aVar;
    }

    private void cNe() {
        AppMethodBeat.i(45507);
        if (this.thX != null) {
            this.thX.cNf();
        }
        AppMethodBeat.o(45507);
    }

    public bqr getSelectRedeemType() {
        return this.thW;
    }

    public List<bqr> getRedeemTypeList() {
        return this.thU;
    }

    public void setRedeemTypeList(List<bqr> list) {
        AppMethodBeat.i(45508);
        this.thY = true;
        this.thU.addAll(list);
        this.thV.clear();
        removeAllViews();
        setVisibility(0);
        if (!(this.thU == null || this.thU.isEmpty())) {
            int i = 0;
            for (bqr bqr : this.thU) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.b4t, this, false);
                b bVar = new b();
                bVar.jcl = linearLayout;
                bVar.iDT = (TextView) linearLayout.findViewById(R.id.fbn);
                bVar.kEq = (TextView) linearLayout.findViewById(R.id.fbo);
                bVar.aaX = (RadioButton) linearLayout.findViewById(R.id.fbp);
                ab.d("MicroMsg.WalletLqtArriveTimeLayout", "arrive wording: %s", bqr.wTb);
                bVar.iDT.setText(bqr.wTb);
                if (bo.isNullOrNil(bqr.wTc)) {
                    bVar.kEq.setVisibility(8);
                } else {
                    bVar.kEq.setText(bqr.wTc);
                }
                if (i == 0) {
                    bVar.aaX.setChecked(true);
                    this.thW = bqr;
                }
                int i2 = i + 1;
                bVar.index = i;
                linearLayout.setTag(bVar);
                linearLayout.setOnClickListener(this.nij);
                this.thV.add(new WeakReference(bVar));
                addView(linearLayout);
                i = i2;
            }
        }
        AppMethodBeat.o(45508);
    }

    private static void a(b bVar, boolean z) {
        AppMethodBeat.i(45509);
        bVar.aaX.setEnabled(z);
        bVar.iDT.setEnabled(z);
        bVar.kEq.setEnabled(z);
        bVar.jcl.setEnabled(z);
        AppMethodBeat.o(45509);
    }

    public final void acj(String str) {
        AppMethodBeat.i(45510);
        ab.i("MicroMsg.WalletLqtArriveTimeLayout", "input money: %s", str);
        if (this.thU == null || this.thU.isEmpty()) {
            AppMethodBeat.o(45510);
            return;
        }
        this.thW = null;
        for (WeakReference weakReference : this.thV) {
            if (weakReference.get() != null) {
                ((b) weakReference.get()).aaX.setEnabled(true);
                ((b) weakReference.get()).aaX.setChecked(false);
            }
        }
        int iy = e.iy(str, "100");
        int i = 0;
        for (bqr bqr : this.thU) {
            if (bqr.wTd < 0 || iy <= bqr.wTd) {
                b bVar = (b) ((WeakReference) this.thV.get(i)).get();
                if (bVar != null) {
                    a(bVar, true);
                    if (this.thW == null) {
                        ab.i("MicroMsg.WalletLqtArriveTimeLayout", "auto select type: %s", Integer.valueOf(bqr.wOl));
                        bVar.aaX.setChecked(true);
                        this.thW = bqr;
                        cNe();
                        if (i > 0) {
                            bVar.iDT.setTextColor(ah.getContext().getResources().getColor(R.color.r8));
                        } else {
                            bVar.cNg();
                        }
                    } else {
                        bVar.cNg();
                    }
                }
            } else {
                ab.i("MicroMsg.WalletLqtArriveTimeLayout", "disable item: %s, %s", Integer.valueOf(i), Integer.valueOf(bqr.wTd));
                b bVar2 = (b) ((WeakReference) this.thV.get(i)).get();
                if (bVar2 != null) {
                    bVar2.aaX.setChecked(false);
                    a(bVar2, false);
                    this.thW = null;
                    cNe();
                }
            }
            i++;
        }
        AppMethodBeat.o(45510);
    }

    static /* synthetic */ void a(WalletLqtArriveTimeLayout walletLqtArriveTimeLayout) {
        AppMethodBeat.i(45511);
        for (WeakReference weakReference : walletLqtArriveTimeLayout.thV) {
            if (weakReference.get() != null && ((b) weakReference.get()).aaX.isEnabled()) {
                ((b) weakReference.get()).aaX.setChecked(false);
            }
        }
        AppMethodBeat.o(45511);
    }
}
