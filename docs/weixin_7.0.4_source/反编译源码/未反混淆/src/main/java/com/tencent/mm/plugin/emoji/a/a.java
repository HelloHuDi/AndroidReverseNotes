package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class a {
    private final String TAG;
    protected TextView iDT;
    private int kRA;
    public f kRB;
    protected View kRC;
    protected ImageView kRD;
    protected ImageView kRE;
    protected TextView kRF;
    protected TextView kRG;
    protected ProgressBar kRH;
    protected ViewGroup kRI;
    protected View kRJ;
    protected TextView kRK;
    protected ImageView kRL;
    protected View kRM;
    protected ProgressBar kRN;
    protected TextView kRO;
    protected TextView kRP;
    protected FrameLayout kRQ;
    protected View kRR;
    private View kRv;
    private final int kRw;
    private final int kRx;
    private final int kRy;
    private int[] kRz;
    Context mContext;
    private LayoutInflater mLayoutInflater;
    public int mPosition;

    public enum a {
        LIST,
        GRID_MAIN,
        GRID_RECOMMEND;

        static {
            AppMethodBeat.o(52718);
        }
    }

    public abstract void bje();

    public abstract int[] bjf();

    public abstract int bjg();

    public abstract boolean bjp();

    public a(Context context, View view) {
        this(context, view, a.LIST);
    }

    private a(Context context, View view, a aVar) {
        this.TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
        this.kRw = R.layout.tt;
        this.kRx = R.layout.ui;
        this.kRy = R.layout.uj;
        this.kRz = new int[]{-1, -1};
        this.kRA = -1;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
        if (view == null) {
            switch (aVar) {
                case LIST:
                    view = tR(this.kRw);
                    break;
                case GRID_MAIN:
                    view = tR(this.kRy);
                    break;
                case GRID_RECOMMEND:
                    view = tR(this.kRx);
                    break;
                default:
                    view = tR(this.kRw);
                    break;
            }
        }
        this.kRR = view;
        if (view != null) {
            this.kRv = view;
            this.kRC = this.kRv.findViewById(R.id.be6);
            this.kRE = (ImageView) this.kRv.findViewById(R.id.beh);
            this.kRD = (ImageView) this.kRv.findViewById(R.id.be7);
            this.iDT = (TextView) this.kRv.findViewById(R.id.ba3);
            this.kRF = (TextView) this.kRv.findViewById(R.id.bea);
            this.kRG = (TextView) this.kRv.findViewById(R.id.be_);
            this.kRH = (ProgressBar) this.kRv.findViewById(R.id.bee);
            this.kRJ = this.kRv.findViewById(R.id.be9);
            this.kRI = (ViewGroup) this.kRv.findViewById(R.id.beb);
            this.kRK = (TextView) this.kRv.findViewById(R.id.bec);
            this.kRL = (ImageView) this.kRv.findViewById(R.id.bed);
            this.kRM = this.kRv.findViewById(R.id.bef);
            this.kRN = (ProgressBar) this.kRv.findViewById(R.id.beg);
            this.kRO = (TextView) this.kRv.findViewById(R.id.be4);
            this.kRP = (TextView) this.kRv.findViewById(R.id.bgf);
            this.kRQ = (FrameLayout) this.kRv.findViewById(R.id.be5);
        }
        bje();
        if (aVar == a.LIST) {
            int[] bjf = bjf();
            if (this.kRD != null && bjf[0] >= 0 && bjf[1] >= 0 && !(bjf[0] == this.kRz[0] && bjf[1] == this.kRz[1])) {
                LayoutParams layoutParams = this.kRD.getLayoutParams();
                layoutParams.width = bjf[0];
                layoutParams.height = bjf[1];
                this.kRD.setLayoutParams(layoutParams);
                this.kRz = bjf;
            }
            int bjg = bjg();
            if (!(this.kRv == null || bjg < 0 || this.kRA == bjg)) {
                this.kRv.setMinimumHeight(bjg);
                if (this.kRC != null) {
                    this.kRC.setMinimumHeight(bjg);
                }
            }
        }
        view.setTag(this);
    }

    private View tR(int i) {
        if (this.mLayoutInflater == null || i <= 0) {
            return null;
        }
        return this.mLayoutInflater.inflate(i, null);
    }

    public final void setTitle(String str) {
        this.iDT.setText(str);
    }

    public final void bjh() {
        this.iDT.setText(R.string.bca);
    }

    public final ImageView bji() {
        return this.kRD;
    }

    public final void bjj() {
        this.kRD.setImageResource(R.drawable.icon_002_cover);
    }

    public final ImageView bjk() {
        return this.kRE;
    }

    public final void tS(int i) {
        this.kRE.setVisibility(i);
    }

    public final void bjl() {
        this.kRE.setImageResource(R.drawable.adr);
    }

    public final void tT(int i) {
        this.kRJ.setVisibility(i);
    }

    public final void bjm() {
        this.kRF.setVisibility(8);
        this.kRG.setVisibility(8);
    }

    public final void IQ(String str) {
        this.kRF.setText(str);
    }

    public final void IR(String str) {
        if (bo.isNullOrNil(str)) {
            this.kRG.setVisibility(8);
            return;
        }
        this.kRG.setVisibility(0);
        this.kRG.setText(str);
    }

    public final void a(final com.tencent.mm.plugin.emoji.model.i.a aVar) {
        if (this.kRJ != null) {
            this.kRJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(52714);
                    if (a.this.a(aVar, view)) {
                        a.this.b(aVar, view);
                    }
                    AppMethodBeat.o(52714);
                }
            });
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean a(com.tencent.mm.plugin.emoji.model.i.a aVar, View view) {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void b(com.tencent.mm.plugin.emoji.model.i.a aVar, View view) {
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final String getProductId() {
        return (this.kRB == null || this.kRB.kTb == null) ? null : this.kRB.kTb.ProductID;
    }

    public final int bjn() {
        Integer num;
        if (this.kRB == null) {
            num = null;
        } else {
            num = Integer.valueOf(this.kRB.mStatus);
        }
        return num.intValue();
    }

    public final String bjo() {
        return (this.kRB == null || this.kRB.kTb == null) ? null : this.kRB.kTb.PackPrice;
    }

    public final int getProgress() {
        return this.kRB == null ? 0 : this.kRB.EV;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bjq() {
        this.kRH.setVisibility(8);
        this.kRI.setVisibility(8);
        this.kRJ.setEnabled(false);
        this.kRL.setVisibility(8);
        this.kRN.setVisibility(0);
        this.kRN.setProgress(getProgress());
        if (this.kRM == null) {
            this.kRN.setVisibility(0);
        } else {
            this.kRM.setVisibility(0);
        }
    }

    private void bjr() {
        this.kRH.setVisibility(8);
        this.kRI.setBackgroundResource(R.drawable.fp);
        this.kRI.setVisibility(0);
        this.kRJ.setEnabled(true);
        this.kRK.setText("");
        if (this.kRM == null) {
            this.kRN.setVisibility(4);
        } else {
            this.kRM.setVisibility(4);
        }
        this.kRK.setVisibility(0);
        this.kRK.setText(R.string.bai);
        this.kRK.setTextColor(this.mContext.getResources().getColorStateList(R.color.a8m));
        this.kRL.setVisibility(8);
    }

    public void bjs() {
        if (this.kRB != null && bjp()) {
            this.kRK.setVisibility(8);
            this.kRK.setTextColor(this.mContext.getResources().getColorStateList(R.color.a73));
            switch (bjn()) {
                case 0:
                    bjr();
                    return;
                case 3:
                    bjr();
                    return;
                case 4:
                case 12:
                    this.kRH.setVisibility(8);
                    this.kRI.setBackgroundResource(R.drawable.fu);
                    this.kRI.setVisibility(0);
                    if (this.kRM == null) {
                        this.kRN.setVisibility(4);
                    } else {
                        this.kRM.setVisibility(4);
                    }
                    this.kRJ.setEnabled(true);
                    this.kRL.setVisibility(4);
                    this.kRK.setVisibility(0);
                    if (this.kRB.kTb != null) {
                        this.kRK.setText(this.kRB.kTb.PackPrice);
                        return;
                    }
                    return;
                case 6:
                    bjq();
                    return;
                case 7:
                    if (this.kRB.kTf) {
                        ab.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
                        this.kRH.setVisibility(8);
                        this.kRI.setBackgroundResource(R.drawable.fp);
                        this.kRI.setVisibility(0);
                        this.kRI.setTag(getProductId());
                        this.kRJ.setEnabled(true);
                        this.kRK.setVisibility(0);
                        this.kRK.setText(R.string.bcc);
                        this.kRK.setTextColor(this.mContext.getResources().getColorStateList(R.color.a8m));
                        this.kRL.setVisibility(4);
                        if (this.kRM == null) {
                            this.kRN.setVisibility(4);
                            return;
                        } else {
                            this.kRM.setVisibility(4);
                            return;
                        }
                    } else if (this.kRB.kTh && e.dR(this.kRB.kTb.PackFlag, 64)) {
                        this.kRI.setVisibility(0);
                        this.kRI.setBackgroundResource(R.drawable.fs);
                        this.kRK.setVisibility(0);
                        this.kRK.setText(R.string.bbe);
                        this.kRK.setTextColor(this.mContext.getResources().getColorStateList(R.color.a8m));
                        this.kRL.setVisibility(4);
                        this.kRJ.setEnabled(true);
                        if (this.kRM == null) {
                            this.kRN.setVisibility(4);
                            return;
                        } else {
                            this.kRM.setVisibility(4);
                            return;
                        }
                    } else {
                        this.kRH.setVisibility(8);
                        this.kRI.setVisibility(0);
                        this.kRI.setBackgroundResource(R.drawable.fu);
                        this.kRK.setVisibility(0);
                        this.kRK.setText(R.string.bak);
                        this.kRK.setTextColor(this.mContext.getResources().getColorStateList(R.color.h8));
                        this.kRL.setVisibility(4);
                        this.kRJ.setEnabled(false);
                        if (this.kRM == null) {
                            this.kRN.setVisibility(4);
                            return;
                        } else {
                            this.kRM.setVisibility(4);
                            return;
                        }
                    }
                case 8:
                    this.kRH.setVisibility(8);
                    this.kRI.setBackgroundDrawable(null);
                    this.kRI.setVisibility(0);
                    this.kRJ.setEnabled(false);
                    this.kRK.setVisibility(0);
                    this.kRK.setText(R.string.bal);
                    this.kRL.setVisibility(4);
                    if (this.kRM == null) {
                        this.kRN.setVisibility(4);
                        return;
                    } else {
                        this.kRM.setVisibility(4);
                        return;
                    }
                case 10:
                    this.kRH.setVisibility(8);
                    this.kRI.setBackgroundResource(R.drawable.fu);
                    this.kRI.setVisibility(0);
                    this.kRK.setVisibility(0);
                    this.kRK.setText(R.string.bb6);
                    this.kRL.setVisibility(4);
                    this.kRJ.setEnabled(true);
                    if (this.kRM == null) {
                        this.kRN.setVisibility(4);
                        return;
                    } else {
                        this.kRM.setVisibility(4);
                        return;
                    }
                case 11:
                    this.kRH.setVisibility(0);
                    this.kRI.setBackgroundResource(R.drawable.fu);
                    this.kRI.setVisibility(0);
                    this.kRK.setVisibility(0);
                    this.kRK.setText("");
                    this.kRJ.setEnabled(false);
                    this.kRL.setVisibility(4);
                    if (this.kRM == null) {
                        this.kRN.setVisibility(4);
                        return;
                    } else {
                        this.kRM.setVisibility(4);
                        return;
                    }
                default:
                    ab.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", Integer.valueOf(bjn()));
                    return;
            }
        }
    }

    public final View bjt() {
        return this.kRR;
    }
}
