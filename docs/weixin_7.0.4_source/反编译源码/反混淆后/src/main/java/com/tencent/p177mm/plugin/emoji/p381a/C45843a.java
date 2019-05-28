package com.tencent.p177mm.plugin.emoji.p381a;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.emoji.model.C42951i.C11558a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C27727e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.emoji.a.a */
public abstract class C45843a {
    private final String TAG;
    protected TextView iDT;
    private int kRA;
    public C11546f kRB;
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

    /* renamed from: com.tencent.mm.plugin.emoji.a.a$a */
    public enum C20354a {
        LIST,
        GRID_MAIN,
        GRID_RECOMMEND;

        static {
            AppMethodBeat.m2505o(52718);
        }
    }

    public abstract void bje();

    public abstract int[] bjf();

    public abstract int bjg();

    public abstract boolean bjp();

    public C45843a(Context context, View view) {
        this(context, view, C20354a.LIST);
    }

    private C45843a(Context context, View view, C20354a c20354a) {
        this.TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
        this.kRw = 2130969337;
        this.kRx = 2130969363;
        this.kRy = 2130969364;
        this.kRz = new int[]{-1, -1};
        this.kRA = -1;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
        if (view == null) {
            switch (c20354a) {
                case LIST:
                    view = m84868tR(this.kRw);
                    break;
                case GRID_MAIN:
                    view = m84868tR(this.kRy);
                    break;
                case GRID_RECOMMEND:
                    view = m84868tR(this.kRx);
                    break;
                default:
                    view = m84868tR(this.kRw);
                    break;
            }
        }
        this.kRR = view;
        if (view != null) {
            this.kRv = view;
            this.kRC = this.kRv.findViewById(2131823473);
            this.kRE = (ImageView) this.kRv.findViewById(2131823485);
            this.kRD = (ImageView) this.kRv.findViewById(2131823474);
            this.iDT = (TextView) this.kRv.findViewById(2131823322);
            this.kRF = (TextView) this.kRv.findViewById(2131823478);
            this.kRG = (TextView) this.kRv.findViewById(2131823477);
            this.kRH = (ProgressBar) this.kRv.findViewById(2131823482);
            this.kRJ = this.kRv.findViewById(2131823476);
            this.kRI = (ViewGroup) this.kRv.findViewById(2131823479);
            this.kRK = (TextView) this.kRv.findViewById(2131823480);
            this.kRL = (ImageView) this.kRv.findViewById(2131823481);
            this.kRM = this.kRv.findViewById(2131823483);
            this.kRN = (ProgressBar) this.kRv.findViewById(2131823484);
            this.kRO = (TextView) this.kRv.findViewById(2131823471);
            this.kRP = (TextView) this.kRv.findViewById(2131823557);
            this.kRQ = (FrameLayout) this.kRv.findViewById(2131823472);
        }
        bje();
        if (c20354a == C20354a.LIST) {
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

    /* renamed from: tR */
    private View m84868tR(int i) {
        if (this.mLayoutInflater == null || i <= 0) {
            return null;
        }
        return this.mLayoutInflater.inflate(i, null);
    }

    public final void setTitle(String str) {
        this.iDT.setText(str);
    }

    public final void bjh() {
        this.iDT.setText(C25738R.string.bca);
    }

    public final ImageView bji() {
        return this.kRD;
    }

    public final void bjj() {
        this.kRD.setImageResource(C25738R.drawable.icon_002_cover);
    }

    public final ImageView bjk() {
        return this.kRE;
    }

    /* renamed from: tS */
    public final void mo73662tS(int i) {
        this.kRE.setVisibility(i);
    }

    public final void bjl() {
        this.kRE.setImageResource(C25738R.drawable.adr);
    }

    /* renamed from: tT */
    public final void mo73663tT(int i) {
        this.kRJ.setVisibility(i);
    }

    public final void bjm() {
        this.kRF.setVisibility(8);
        this.kRG.setVisibility(8);
    }

    /* renamed from: IQ */
    public final void mo73646IQ(String str) {
        this.kRF.setText(str);
    }

    /* renamed from: IR */
    public final void mo73647IR(String str) {
        if (C5046bo.isNullOrNil(str)) {
            this.kRG.setVisibility(8);
            return;
        }
        this.kRG.setVisibility(0);
        this.kRG.setText(str);
    }

    /* renamed from: a */
    public final void mo73648a(final C11558a c11558a) {
        if (this.kRJ != null) {
            this.kRJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(52714);
                    if (C45843a.this.mo58600a(c11558a, view)) {
                        C45843a.this.mo58601b(c11558a, view);
                    }
                    AppMethodBeat.m2505o(52714);
                }
            });
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public boolean mo58600a(C11558a c11558a, View view) {
        return true;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo58601b(C11558a c11558a, View view) {
        if (c11558a != null) {
            c11558a.mo23265a(this);
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
        return this.kRB == null ? 0 : this.kRB.f2905EV;
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
        this.kRI.setBackgroundResource(C25738R.drawable.f6484fp);
        this.kRI.setVisibility(0);
        this.kRJ.setEnabled(true);
        this.kRK.setText("");
        if (this.kRM == null) {
            this.kRN.setVisibility(4);
        } else {
            this.kRM.setVisibility(4);
        }
        this.kRK.setVisibility(0);
        this.kRK.setText(C25738R.string.bai);
        this.kRK.setTextColor(this.mContext.getResources().getColorStateList(C25738R.color.a8m));
        this.kRL.setVisibility(8);
    }

    public void bjs() {
        if (this.kRB != null && bjp()) {
            this.kRK.setVisibility(8);
            this.kRK.setTextColor(this.mContext.getResources().getColorStateList(C25738R.color.a73));
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
                    this.kRI.setBackgroundResource(C25738R.drawable.f6489fu);
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
                        C4990ab.m7410d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
                        this.kRH.setVisibility(8);
                        this.kRI.setBackgroundResource(C25738R.drawable.f6484fp);
                        this.kRI.setVisibility(0);
                        this.kRI.setTag(getProductId());
                        this.kRJ.setEnabled(true);
                        this.kRK.setVisibility(0);
                        this.kRK.setText(C25738R.string.bcc);
                        this.kRK.setTextColor(this.mContext.getResources().getColorStateList(C25738R.color.a8m));
                        this.kRL.setVisibility(4);
                        if (this.kRM == null) {
                            this.kRN.setVisibility(4);
                            return;
                        } else {
                            this.kRM.setVisibility(4);
                            return;
                        }
                    } else if (this.kRB.kTh && C27727e.m44040dR(this.kRB.kTb.PackFlag, 64)) {
                        this.kRI.setVisibility(0);
                        this.kRI.setBackgroundResource(C25738R.drawable.f6487fs);
                        this.kRK.setVisibility(0);
                        this.kRK.setText(C25738R.string.bbe);
                        this.kRK.setTextColor(this.mContext.getResources().getColorStateList(C25738R.color.a8m));
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
                        this.kRI.setBackgroundResource(C25738R.drawable.f6489fu);
                        this.kRK.setVisibility(0);
                        this.kRK.setText(C25738R.string.bak);
                        this.kRK.setTextColor(this.mContext.getResources().getColorStateList(C25738R.color.f11786h8));
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
                    this.kRK.setText(C25738R.string.bal);
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
                    this.kRI.setBackgroundResource(C25738R.drawable.f6489fu);
                    this.kRI.setVisibility(0);
                    this.kRK.setVisibility(0);
                    this.kRK.setText(C25738R.string.bb6);
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
                    this.kRI.setBackgroundResource(C25738R.drawable.f6489fu);
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
                    C4990ab.m7421w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", Integer.valueOf(bjn()));
                    return;
            }
        }
    }

    public final View bjt() {
        return this.kRR;
    }
}
