package com.tencent.p177mm.plugin.shake.p506c.p508b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C18376qk;
import com.tencent.p177mm.p230g.p231a.C42046qj;
import com.tencent.p177mm.p230g.p231a.C42046qj.C42045b;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.shake.p506c.p1411c.C28999a;
import com.tencent.p177mm.plugin.shake.p506c.p507a.C21829e;
import com.tencent.p177mm.plugin.shake.p506c.p507a.C39692a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.shake.c.b.a */
public final class C43523a extends C15532i {
    private static final String kdH = (C6457e.eSn + "card");
    private ProgressBar gHA;
    private boolean gHY;
    private OnClickListener gKK = new C132572();
    private View jcl;
    private String kaE = "";
    private ImageView kgH;
    private Button kgI;
    private Resources mResources;
    private ImageView nVJ;
    private TextView pUz;
    private View pou;
    private C21829e qsJ;
    private View qsN;
    private TextView qsO;
    private TextView qsP;
    private TextView qsQ;
    private TextView qsR;
    private View qsS;
    private View qsT;
    private TextView qsU;
    private TextView qsV;
    private TextView qsW;
    private View qsX;
    private ImageView qsY;
    public boolean qsZ = false;
    private boolean qta = false;
    private int qtb = 0;
    private C42045b qtc;
    private C34895a qtd = C34895a.PRE_ACCEPT;
    private C39694b qte;
    private C4884c qtf = new C435241();

    /* renamed from: com.tencent.mm.plugin.shake.c.b.a$2 */
    class C132572 implements OnClickListener {
        C132572() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24548);
            if (view.getId() == 2131827470) {
                C43523a.this.dismiss();
                if (C43523a.this.qte != null) {
                    C43523a.this.qte.ckg();
                }
                C4990ab.m7416i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
                AppMethodBeat.m2505o(24548);
                return;
            }
            if (view.getId() == 2131821929) {
                if (C43523a.this.qtd == C34895a.PRE_ACCEPT) {
                    C43523a.this.qtd = C34895a.ACCEPTING;
                    C43523a.m77767a(C43523a.this, 0);
                    C43523a.m77769c(C43523a.this);
                    C43523a.m77770d(C43523a.this);
                    AppMethodBeat.m2505o(24548);
                    return;
                } else if (C43523a.this.qtd != C34895a.ACCEPTING) {
                    if (C43523a.this.qtd == C34895a.ACCEPTED_FAIL) {
                        C43523a.m77770d(C43523a.this);
                        AppMethodBeat.m2505o(24548);
                        return;
                    } else if (C43523a.this.qtd == C34895a.ACCEPTED_SUCCES) {
                        C4879a.xxA.mo10052c(C43523a.this.qtf);
                        C43523a.m77772f(C43523a.this);
                    }
                }
            }
            AppMethodBeat.m2505o(24548);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.c.b.a$a */
    enum C34895a {
        PRE_ACCEPT,
        ACCEPTING,
        ACCEPTED_SUCCES,
        ACCEPTED_FAIL;

        static {
            AppMethodBeat.m2505o(24552);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.c.b.a$b */
    public interface C39694b {
        void ckg();
    }

    /* renamed from: com.tencent.mm.plugin.shake.c.b.a$1 */
    class C435241 extends C4884c<C18376qk> {
        C435241() {
            AppMethodBeat.m2504i(24546);
            this.xxI = C18376qk.class.getName().hashCode();
            AppMethodBeat.m2505o(24546);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(24547);
            C43523a.this.dismiss();
            if (C43523a.this.qte != null) {
                C43523a.this.qte.ckg();
            }
            C4990ab.m7416i("MicroMsg.ShakeCardDialog", "gift event come, do close ShakeCardDialog");
            AppMethodBeat.m2505o(24547);
            return false;
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m77769c(C43523a c43523a) {
        AppMethodBeat.m2504i(24563);
        c43523a.cke();
        AppMethodBeat.m2505o(24563);
    }

    /* renamed from: h */
    static /* synthetic */ void m77774h(C43523a c43523a) {
        AppMethodBeat.m2504i(24566);
        c43523a.updateLayout();
        AppMethodBeat.m2505o(24566);
    }

    /* renamed from: k */
    static /* synthetic */ void m77777k(C43523a c43523a) {
        AppMethodBeat.m2504i(24568);
        c43523a.ckf();
        AppMethodBeat.m2505o(24568);
    }

    static {
        AppMethodBeat.m2504i(24569);
        AppMethodBeat.m2505o(24569);
    }

    private C43523a(Context context) {
        super(context, C25738R.style.f11416zu);
        AppMethodBeat.m2504i(24553);
        C4990ab.m7416i("MicroMsg.ShakeCardDialog", "init shake card dialog");
        this.mResources = context.getResources();
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.jcl = View.inflate(context, 2130970649, null);
        this.qsN = this.jcl.findViewById(2131827461);
        this.qsO = (TextView) this.jcl.findViewById(2131827463);
        this.qsP = (TextView) this.jcl.findViewById(2131822335);
        this.qsQ = (TextView) this.jcl.findViewById(2131827464);
        this.nVJ = (ImageView) this.jcl.findViewById(2131827470);
        this.kgI = (Button) this.jcl.findViewById(2131821929);
        this.qsR = (TextView) this.jcl.findViewById(2131827469);
        this.gHA = (ProgressBar) this.jcl.findViewById(2131827468);
        this.nVJ.setOnClickListener(this.gKK);
        this.kgI.setOnClickListener(this.gKK);
        this.pou = this.jcl.findViewById(2131827462);
        this.qsS = this.jcl.findViewById(2131822001);
        this.qsT = this.jcl.findViewById(2131827471);
        this.kgH = (ImageView) this.jcl.findViewById(2131827472);
        this.qsU = (TextView) this.jcl.findViewById(2131822004);
        this.qsV = (TextView) this.jcl.findViewById(2131821915);
        this.qsW = (TextView) this.jcl.findViewById(2131827475);
        this.qsX = this.jcl.findViewById(2131827465);
        this.qsY = (ImageView) this.jcl.findViewById(2131827466);
        this.pUz = (TextView) this.jcl.findViewById(2131827467);
        this.qtb = C28999a.ckk();
        AppMethodBeat.m2505o(24553);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(24554);
        if (i == 4) {
            C4990ab.m7416i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
            dismiss();
            if (this.qte != null) {
                this.qte.ckg();
            }
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(24554);
        return onKeyUp;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(24555);
        super.onCreate(bundle);
        setContentView(this.jcl);
        AppMethodBeat.m2505o(24555);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.m2504i(24556);
        super.setCancelable(z);
        this.gHY = z;
        setCanceledOnTouchOutside(this.gHY);
        AppMethodBeat.m2505o(24556);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(24557);
        try {
            if (this.qte != null) {
                this.qte.ckg();
            }
            if (!(this.qtd == C34895a.ACCEPTED_SUCCES || this.qta)) {
                this.qta = true;
                C4990ab.m7416i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
                C9638aw.m17182Rg().mo14541a(new C39692a(this.qsJ.kbU, this.qsJ.cMD), 0);
            }
            C4879a.xxA.mo10053d(this.qtf);
            C4990ab.m7416i("MicroMsg.ShakeCardDialog", "dismiss ShakeCardDialog");
            super.dismiss();
            AppMethodBeat.m2505o(24557);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ShakeCardDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.m2505o(24557);
        }
    }

    private void updateLayout() {
        AppMethodBeat.m2504i(24558);
        if (this.qtd == C34895a.ACCEPTED_SUCCES) {
            this.pou.setVisibility(8);
            this.qsX.setVisibility(0);
            AppMethodBeat.m2505o(24558);
            return;
        }
        if (this.qtd == C34895a.PRE_ACCEPT || this.qtd == C34895a.ACCEPTING || this.qtd == C34895a.ACCEPTED_FAIL) {
            this.pou.setVisibility(0);
            this.qsX.setVisibility(8);
        }
        AppMethodBeat.m2505o(24558);
    }

    private void cke() {
        AppMethodBeat.m2504i(24559);
        if (this.qtd == C34895a.PRE_ACCEPT || this.qtd == C34895a.ACCEPTED_FAIL) {
            if (TextUtils.isEmpty(this.qsJ.qst)) {
                this.kgI.setText(C25738R.string.acs);
                AppMethodBeat.m2505o(24559);
                return;
            }
            this.kgI.setText(this.qsJ.qst);
            AppMethodBeat.m2505o(24559);
        } else if (this.qtd == C34895a.ACCEPTING) {
            this.kgI.setText("");
            AppMethodBeat.m2505o(24559);
        } else {
            if (this.qtd == C34895a.ACCEPTED_SUCCES) {
                this.kgI.setText(C25738R.string.eec);
            }
            AppMethodBeat.m2505o(24559);
        }
    }

    private void ckf() {
        AppMethodBeat.m2504i(24560);
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(C25738R.dimen.a8_);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f}, null, null));
        shapeDrawable.getPaint().setColor(C28999a.m46036Hn(this.qsJ.color));
        this.qsT.setBackgroundDrawable(shapeDrawable);
        cke();
        if (!TextUtils.isEmpty(this.qsJ.qsr)) {
            this.qsO.setText(this.qsJ.qsr);
        }
        if (!TextUtils.isEmpty(this.qsJ.qsv)) {
            this.qsP.setText(this.qsJ.qsv);
            this.qsP.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.qsJ.qss)) {
            this.qsQ.setText(this.qsJ.qss);
            this.qsQ.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.qsJ.kbV)) {
            dimensionPixelOffset = getContext().getResources().getDimensionPixelSize(C25738R.dimen.a89);
            ImageView imageView = this.kgH;
            String str = this.qsJ.kbV;
            if (!(imageView == null || TextUtils.isEmpty(str))) {
                if (TextUtils.isEmpty(str)) {
                    imageView.setImageResource(C1318a.shake_card_package_defaultlogo);
                } else {
                    C17927a c17927a = new C17927a();
                    c17927a.ePK = C6457e.eSn;
                    C32291o.ahq();
                    c17927a.ePY = null;
                    c17927a.ePJ = String.format("%s/%s", new Object[]{kdH, C1178g.m2591x(str.getBytes())});
                    c17927a.ePH = true;
                    c17927a.eQf = true;
                    c17927a.ePF = true;
                    c17927a.ePO = dimensionPixelOffset;
                    c17927a.ePN = dimensionPixelOffset;
                    c17927a.ePT = C1318a.shake_card_package_defaultlogo;
                    C32291o.ahp().mo43766a(str, imageView, c17927a.ahG());
                }
            }
        }
        if (!TextUtils.isEmpty(this.qsJ.title)) {
            this.qsU.setText(this.qsJ.title);
        }
        if (!TextUtils.isEmpty(this.qsJ.kdg)) {
            this.qsV.setText(this.qsJ.kdg);
        }
        if (this.qsJ.kbZ > 0) {
            this.qsW.setText(getContext().getString(C25738R.string.aie, new Object[]{C28999a.m46037fQ((long) this.qsJ.kbZ)}));
        }
        if (this.qtd == C34895a.ACCEPTED_FAIL) {
            this.qsR.setVisibility(0);
            AppMethodBeat.m2505o(24560);
            return;
        }
        this.qsR.setVisibility(8);
        AppMethodBeat.m2505o(24560);
    }

    /* renamed from: a */
    public static C43523a m77765a(Context context, C21829e c21829e, OnCancelListener onCancelListener, C39694b c39694b) {
        AppMethodBeat.m2504i(24561);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(24561);
            return null;
        }
        C43523a c43523a = new C43523a(context);
        c43523a.setOnCancelListener(onCancelListener);
        c43523a.setCancelable(true);
        c43523a.qsJ = c21829e;
        if (c43523a.qsJ == null) {
            C4990ab.m7412e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
        } else {
            if (TextUtils.isEmpty(c43523a.qsJ.title)) {
                c43523a.qsO.setText(c43523a.qsJ.title);
            }
            C4990ab.m7416i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
            c43523a.qtd = C34895a.PRE_ACCEPT;
            c43523a.updateLayout();
            c43523a.ckf();
            if (c43523a.qtb == 0) {
                c43523a.qsN.setBackgroundResource(C25738R.drawable.f7050zn);
                c43523a.qsS.setBackgroundResource(C25738R.drawable.f7051zo);
                c43523a.qsO.setTextColor(c43523a.mResources.getColor(C25738R.color.f11782h4));
                c43523a.qsP.setTextColor(c43523a.mResources.getColor(C25738R.color.f12199vr));
                c43523a.qsQ.setTextColor(c43523a.mResources.getColor(C25738R.color.f12199vr));
                c43523a.pUz.setTextColor(c43523a.getContext().getResources().getColor(C25738R.color.f11782h4));
                c43523a.kgI.setBackgroundResource(C25738R.drawable.f6484fp);
                c43523a.kgI.setTextColor(c43523a.getContext().getResources().getColor(C25738R.color.a69));
                c43523a.qsR.setTextColor(c43523a.getContext().getResources().getColor(C25738R.color.f12205vx));
            }
        }
        c43523a.qte = c39694b;
        c43523a.show();
        C30379h.m48455a(context, c43523a);
        AppMethodBeat.m2505o(24561);
        return c43523a;
    }

    /* renamed from: d */
    static /* synthetic */ void m77770d(C43523a c43523a) {
        AppMethodBeat.m2504i(24564);
        C4990ab.m7416i("MicroMsg.ShakeCardDialog", "doNetSceneAccept()");
        if (TextUtils.isEmpty(c43523a.qsJ.kbU)) {
            C4990ab.m7412e("MicroMsg.ShakeCardDialog", "card_tp_id is empty befor doNetSceneAccept");
            AppMethodBeat.m2505o(24564);
            return;
        }
        final C4883b c42046qj = new C42046qj();
        c42046qj.cMB = null;
        c42046qj.cMA.cMC = c43523a.qsJ.kbU;
        c42046qj.cMA.cMD = c43523a.qsJ.cMD;
        c42046qj.cMA.cME = 15;
        c42046qj.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(24549);
                C4990ab.m7416i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback");
                C43523a.this.qtc = c42046qj.cMB;
                if (C43523a.this.qtc != null) {
                    C43523a.m77767a(C43523a.this, 8);
                    if (C43523a.this.qtc != null) {
                        C43523a.this.kaE = C43523a.this.qtc.cMC;
                    }
                    if (C43523a.this.qtc == null || !C43523a.this.qtc.cxT) {
                        C43523a.this.qtd = C34895a.ACCEPTED_FAIL;
                        C43523a.m77774h(C43523a.this);
                        C43523a.m77777k(C43523a.this);
                        AppMethodBeat.m2505o(24549);
                        return;
                    }
                    C43523a.this.qtd = C34895a.ACCEPTED_SUCCES;
                    C43523a.m77774h(C43523a.this);
                    C43523a.m77775i(C43523a.this);
                    C43523a.this.qsZ = true;
                    if (C43523a.this.qte != null) {
                        C43523a.this.qte.ckg();
                        AppMethodBeat.m2505o(24549);
                        return;
                    }
                }
                C4990ab.m7416i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback, mCardAcceptResult == null");
                AppMethodBeat.m2505o(24549);
            }
        };
        C4879a.xxA.mo10048a(c42046qj, Looper.getMainLooper());
        AppMethodBeat.m2505o(24564);
    }

    /* renamed from: f */
    static /* synthetic */ void m77772f(C43523a c43523a) {
        AppMethodBeat.m2504i(24565);
        C4990ab.m7416i("MicroMsg.ShakeCardDialog", "goCardDetailUI ShakeCardDialog");
        C7060h.pYm.mo8374X(11665, c43523a.kaE);
        C28999a.m46038u(c43523a.getContext(), c43523a.kaE, c43523a.qsJ.cMD);
        AppMethodBeat.m2505o(24565);
    }

    /* renamed from: i */
    static /* synthetic */ void m77775i(C43523a c43523a) {
        AppMethodBeat.m2504i(24567);
        c43523a.cke();
        if (c43523a.qtd == C34895a.ACCEPTED_SUCCES) {
            c43523a.pUz.setText(C25738R.string.edw);
            if (c43523a.qtb == 1) {
                c43523a.qsY.setImageResource(C1318a.shake_success_icon);
                AppMethodBeat.m2505o(24567);
                return;
            }
            c43523a.qsY.setImageResource(C1318a.shake_success_icon_no_activity);
        }
        AppMethodBeat.m2505o(24567);
    }
}
