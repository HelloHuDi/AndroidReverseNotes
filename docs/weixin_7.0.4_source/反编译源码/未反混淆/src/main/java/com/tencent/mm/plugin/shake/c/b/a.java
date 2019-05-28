package com.tencent.mm.plugin.shake.c.b;

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
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public final class a extends i {
    private static final String kdH = (e.eSn + "card");
    private ProgressBar gHA;
    private boolean gHY;
    private OnClickListener gKK = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(24548);
            if (view.getId() == R.id.eb8) {
                a.this.dismiss();
                if (a.this.qte != null) {
                    a.this.qte.ckg();
                }
                ab.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
                AppMethodBeat.o(24548);
                return;
            }
            if (view.getId() == R.id.a_e) {
                if (a.this.qtd == a.PRE_ACCEPT) {
                    a.this.qtd = a.ACCEPTING;
                    a.a(a.this, 0);
                    a.c(a.this);
                    a.d(a.this);
                    AppMethodBeat.o(24548);
                    return;
                } else if (a.this.qtd != a.ACCEPTING) {
                    if (a.this.qtd == a.ACCEPTED_FAIL) {
                        a.d(a.this);
                        AppMethodBeat.o(24548);
                        return;
                    } else if (a.this.qtd == a.ACCEPTED_SUCCES) {
                        com.tencent.mm.sdk.b.a.xxA.c(a.this.qtf);
                        a.f(a.this);
                    }
                }
            }
            AppMethodBeat.o(24548);
        }
    };
    private View jcl;
    private String kaE = "";
    private ImageView kgH;
    private Button kgI;
    private Resources mResources;
    private ImageView nVJ;
    private TextView pUz;
    private View pou;
    private com.tencent.mm.plugin.shake.c.a.e qsJ;
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
    private com.tencent.mm.g.a.qj.b qtc;
    private a qtd = a.PRE_ACCEPT;
    private b qte;
    private c qtf = new c<qk>() {
        {
            AppMethodBeat.i(24546);
            this.xxI = qk.class.getName().hashCode();
            AppMethodBeat.o(24546);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(24547);
            a.this.dismiss();
            if (a.this.qte != null) {
                a.this.qte.ckg();
            }
            ab.i("MicroMsg.ShakeCardDialog", "gift event come, do close ShakeCardDialog");
            AppMethodBeat.o(24547);
            return false;
        }
    };

    enum a {
        PRE_ACCEPT,
        ACCEPTING,
        ACCEPTED_SUCCES,
        ACCEPTED_FAIL;

        static {
            AppMethodBeat.o(24552);
        }
    }

    public interface b {
        void ckg();
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(24563);
        aVar.cke();
        AppMethodBeat.o(24563);
    }

    static /* synthetic */ void h(a aVar) {
        AppMethodBeat.i(24566);
        aVar.updateLayout();
        AppMethodBeat.o(24566);
    }

    static /* synthetic */ void k(a aVar) {
        AppMethodBeat.i(24568);
        aVar.ckf();
        AppMethodBeat.o(24568);
    }

    static {
        AppMethodBeat.i(24569);
        AppMethodBeat.o(24569);
    }

    private a(Context context) {
        super(context, R.style.zu);
        AppMethodBeat.i(24553);
        ab.i("MicroMsg.ShakeCardDialog", "init shake card dialog");
        this.mResources = context.getResources();
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.jcl = View.inflate(context, R.layout.as7, null);
        this.qsN = this.jcl.findViewById(R.id.eaz);
        this.qsO = (TextView) this.jcl.findViewById(R.id.eb1);
        this.qsP = (TextView) this.jcl.findViewById(R.id.akd);
        this.qsQ = (TextView) this.jcl.findViewById(R.id.eb2);
        this.nVJ = (ImageView) this.jcl.findViewById(R.id.eb8);
        this.kgI = (Button) this.jcl.findViewById(R.id.a_e);
        this.qsR = (TextView) this.jcl.findViewById(R.id.eb7);
        this.gHA = (ProgressBar) this.jcl.findViewById(R.id.eb6);
        this.nVJ.setOnClickListener(this.gKK);
        this.kgI.setOnClickListener(this.gKK);
        this.pou = this.jcl.findViewById(R.id.eb0);
        this.qsS = this.jcl.findViewById(R.id.abc);
        this.qsT = this.jcl.findViewById(R.id.eb9);
        this.kgH = (ImageView) this.jcl.findViewById(R.id.eb_);
        this.qsU = (TextView) this.jcl.findViewById(R.id.abf);
        this.qsV = (TextView) this.jcl.findViewById(R.id.a_1);
        this.qsW = (TextView) this.jcl.findViewById(R.id.ebc);
        this.qsX = this.jcl.findViewById(R.id.eb3);
        this.qsY = (ImageView) this.jcl.findViewById(R.id.eb4);
        this.pUz = (TextView) this.jcl.findViewById(R.id.eb5);
        this.qtb = com.tencent.mm.plugin.shake.c.c.a.ckk();
        AppMethodBeat.o(24553);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(24554);
        if (i == 4) {
            ab.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
            dismiss();
            if (this.qte != null) {
                this.qte.ckg();
            }
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(24554);
        return onKeyUp;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(24555);
        super.onCreate(bundle);
        setContentView(this.jcl);
        AppMethodBeat.o(24555);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.i(24556);
        super.setCancelable(z);
        this.gHY = z;
        setCanceledOnTouchOutside(this.gHY);
        AppMethodBeat.o(24556);
    }

    public final void dismiss() {
        AppMethodBeat.i(24557);
        try {
            if (this.qte != null) {
                this.qte.ckg();
            }
            if (!(this.qtd == a.ACCEPTED_SUCCES || this.qta)) {
                this.qta = true;
                ab.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
                aw.Rg().a(new com.tencent.mm.plugin.shake.c.a.a(this.qsJ.kbU, this.qsJ.cMD), 0);
            }
            com.tencent.mm.sdk.b.a.xxA.d(this.qtf);
            ab.i("MicroMsg.ShakeCardDialog", "dismiss ShakeCardDialog");
            super.dismiss();
            AppMethodBeat.o(24557);
        } catch (Exception e) {
            ab.e("MicroMsg.ShakeCardDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.o(24557);
        }
    }

    private void updateLayout() {
        AppMethodBeat.i(24558);
        if (this.qtd == a.ACCEPTED_SUCCES) {
            this.pou.setVisibility(8);
            this.qsX.setVisibility(0);
            AppMethodBeat.o(24558);
            return;
        }
        if (this.qtd == a.PRE_ACCEPT || this.qtd == a.ACCEPTING || this.qtd == a.ACCEPTED_FAIL) {
            this.pou.setVisibility(0);
            this.qsX.setVisibility(8);
        }
        AppMethodBeat.o(24558);
    }

    private void cke() {
        AppMethodBeat.i(24559);
        if (this.qtd == a.PRE_ACCEPT || this.qtd == a.ACCEPTED_FAIL) {
            if (TextUtils.isEmpty(this.qsJ.qst)) {
                this.kgI.setText(R.string.acs);
                AppMethodBeat.o(24559);
                return;
            }
            this.kgI.setText(this.qsJ.qst);
            AppMethodBeat.o(24559);
        } else if (this.qtd == a.ACCEPTING) {
            this.kgI.setText("");
            AppMethodBeat.o(24559);
        } else {
            if (this.qtd == a.ACCEPTED_SUCCES) {
                this.kgI.setText(R.string.eec);
            }
            AppMethodBeat.o(24559);
        }
    }

    private void ckf() {
        AppMethodBeat.i(24560);
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.a8_);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f}, null, null));
        shapeDrawable.getPaint().setColor(com.tencent.mm.plugin.shake.c.c.a.Hn(this.qsJ.color));
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
            dimensionPixelOffset = getContext().getResources().getDimensionPixelSize(R.dimen.a89);
            ImageView imageView = this.kgH;
            String str = this.qsJ.kbV;
            if (!(imageView == null || TextUtils.isEmpty(str))) {
                if (TextUtils.isEmpty(str)) {
                    imageView.setImageResource(R.raw.shake_card_package_defaultlogo);
                } else {
                    com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                    aVar.ePK = e.eSn;
                    o.ahq();
                    aVar.ePY = null;
                    aVar.ePJ = String.format("%s/%s", new Object[]{kdH, g.x(str.getBytes())});
                    aVar.ePH = true;
                    aVar.eQf = true;
                    aVar.ePF = true;
                    aVar.ePO = dimensionPixelOffset;
                    aVar.ePN = dimensionPixelOffset;
                    aVar.ePT = R.raw.shake_card_package_defaultlogo;
                    o.ahp().a(str, imageView, aVar.ahG());
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
            this.qsW.setText(getContext().getString(R.string.aie, new Object[]{com.tencent.mm.plugin.shake.c.c.a.fQ((long) this.qsJ.kbZ)}));
        }
        if (this.qtd == a.ACCEPTED_FAIL) {
            this.qsR.setVisibility(0);
            AppMethodBeat.o(24560);
            return;
        }
        this.qsR.setVisibility(8);
        AppMethodBeat.o(24560);
    }

    public static a a(Context context, com.tencent.mm.plugin.shake.c.a.e eVar, OnCancelListener onCancelListener, b bVar) {
        AppMethodBeat.i(24561);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.o(24561);
            return null;
        }
        a aVar = new a(context);
        aVar.setOnCancelListener(onCancelListener);
        aVar.setCancelable(true);
        aVar.qsJ = eVar;
        if (aVar.qsJ == null) {
            ab.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
        } else {
            if (TextUtils.isEmpty(aVar.qsJ.title)) {
                aVar.qsO.setText(aVar.qsJ.title);
            }
            ab.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
            aVar.qtd = a.PRE_ACCEPT;
            aVar.updateLayout();
            aVar.ckf();
            if (aVar.qtb == 0) {
                aVar.qsN.setBackgroundResource(R.drawable.zn);
                aVar.qsS.setBackgroundResource(R.drawable.zo);
                aVar.qsO.setTextColor(aVar.mResources.getColor(R.color.h4));
                aVar.qsP.setTextColor(aVar.mResources.getColor(R.color.vr));
                aVar.qsQ.setTextColor(aVar.mResources.getColor(R.color.vr));
                aVar.pUz.setTextColor(aVar.getContext().getResources().getColor(R.color.h4));
                aVar.kgI.setBackgroundResource(R.drawable.fp);
                aVar.kgI.setTextColor(aVar.getContext().getResources().getColor(R.color.a69));
                aVar.qsR.setTextColor(aVar.getContext().getResources().getColor(R.color.vx));
            }
        }
        aVar.qte = bVar;
        aVar.show();
        h.a(context, aVar);
        AppMethodBeat.o(24561);
        return aVar;
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(24564);
        ab.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept()");
        if (TextUtils.isEmpty(aVar.qsJ.kbU)) {
            ab.e("MicroMsg.ShakeCardDialog", "card_tp_id is empty befor doNetSceneAccept");
            AppMethodBeat.o(24564);
            return;
        }
        final com.tencent.mm.sdk.b.b qjVar = new qj();
        qjVar.cMB = null;
        qjVar.cMA.cMC = aVar.qsJ.kbU;
        qjVar.cMA.cMD = aVar.qsJ.cMD;
        qjVar.cMA.cME = 15;
        qjVar.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(24549);
                ab.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback");
                a.this.qtc = qjVar.cMB;
                if (a.this.qtc != null) {
                    a.a(a.this, 8);
                    if (a.this.qtc != null) {
                        a.this.kaE = a.this.qtc.cMC;
                    }
                    if (a.this.qtc == null || !a.this.qtc.cxT) {
                        a.this.qtd = a.ACCEPTED_FAIL;
                        a.h(a.this);
                        a.k(a.this);
                        AppMethodBeat.o(24549);
                        return;
                    }
                    a.this.qtd = a.ACCEPTED_SUCCES;
                    a.h(a.this);
                    a.i(a.this);
                    a.this.qsZ = true;
                    if (a.this.qte != null) {
                        a.this.qte.ckg();
                        AppMethodBeat.o(24549);
                        return;
                    }
                }
                ab.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback, mCardAcceptResult == null");
                AppMethodBeat.o(24549);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.a(qjVar, Looper.getMainLooper());
        AppMethodBeat.o(24564);
    }

    static /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(24565);
        ab.i("MicroMsg.ShakeCardDialog", "goCardDetailUI ShakeCardDialog");
        com.tencent.mm.plugin.report.service.h.pYm.X(11665, aVar.kaE);
        com.tencent.mm.plugin.shake.c.c.a.u(aVar.getContext(), aVar.kaE, aVar.qsJ.cMD);
        AppMethodBeat.o(24565);
    }

    static /* synthetic */ void i(a aVar) {
        AppMethodBeat.i(24567);
        aVar.cke();
        if (aVar.qtd == a.ACCEPTED_SUCCES) {
            aVar.pUz.setText(R.string.edw);
            if (aVar.qtb == 1) {
                aVar.qsY.setImageResource(R.raw.shake_success_icon);
                AppMethodBeat.o(24567);
                return;
            }
            aVar.qsY.setImageResource(R.raw.shake_success_icon_no_activity);
        }
        AppMethodBeat.o(24567);
    }
}
