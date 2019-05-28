package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Looper;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.se;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.xq;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.xweb.util.d;
import d.a.a.a;
import d.a.a.c;
import d.a.a.f;
import d.a.a.g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class WalletSuccPageAwardWidget extends FrameLayout {
    private static final String tOJ = (e.eSn + "wallet/images/");
    private ak fbD = new ak(Looper.getMainLooper());
    private TextView gtb;
    private TextView hrg;
    private String kBE;
    private CdnImageView kqn;
    private c pSK;
    private boolean qgo = true;
    private ViewGroup sis;
    private WalletScratchShakeView tOA;
    private WalletAwardShakeAnimView tOB;
    private g tOC;
    private WalletBaseUI tOD;
    private boolean tOE = false;
    private boolean tOF = false;
    private boolean tOG = false;
    private a tOH = null;
    private boolean tOI = false;
    private Button tOx;
    private ImageView tOy;
    private ImageView tOz;
    private boolean ttT;

    static /* synthetic */ void cSO() {
    }

    static {
        AppMethodBeat.i(47982);
        AppMethodBeat.o(47982);
    }

    public static boolean a(c cVar) {
        AppMethodBeat.i(47957);
        if (cVar == null || ((cVar.wew == null || cVar.wew.size() <= 0) && cVar.BTF == null)) {
            AppMethodBeat.o(47957);
            return false;
        }
        AppMethodBeat.o(47957);
        return true;
    }

    public WalletSuccPageAwardWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(47958);
        init(context);
        AppMethodBeat.o(47958);
    }

    public WalletSuccPageAwardWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(47959);
        init(context);
        AppMethodBeat.o(47959);
    }

    private void init(Context context) {
        AppMethodBeat.i(47960);
        v.hu(context).inflate(R.layout.b68, this, true);
        this.sis = (ViewGroup) findViewById(R.id.a3u);
        this.kqn = (CdnImageView) findViewById(R.id.fh9);
        this.gtb = (TextView) findViewById(R.id.rr);
        this.hrg = (TextView) findViewById(R.id.ld);
        this.tOx = (Button) findViewById(R.id.i3);
        this.tOA = (WalletScratchShakeView) findViewById(R.id.fh_);
        this.tOy = (ImageView) findViewById(R.id.btd);
        this.tOB = (WalletAwardShakeAnimView) findViewById(R.id.fha);
        this.kqn.setRoundCorner(true);
        this.kqn.setUseSdcardCache(true);
        AppMethodBeat.o(47960);
    }

    public final void a(WalletBaseUI walletBaseUI, c cVar, String str, boolean z, ImageView imageView) {
        boolean z2 = true;
        AppMethodBeat.i(47961);
        String str2 = "MicroMsg.WalletSuccPageAwardWidget";
        String str3 = "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s";
        Object[] objArr = new Object[5];
        objArr[0] = b(cVar);
        boolean z3 = cVar == null || cVar.BTD == null;
        objArr[1] = Boolean.valueOf(z3);
        if (imageView != null) {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Boolean.valueOf(this.tOE);
        objArr[4] = Boolean.valueOf(z);
        ab.i(str2, str3, objArr);
        this.tOD = walletBaseUI;
        this.pSK = cVar;
        this.ttT = z;
        this.kBE = str;
        this.tOz = imageView;
        cSG();
        AppMethodBeat.o(47961);
    }

    private void cSG() {
        int i = 2;
        AppMethodBeat.i(47962);
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", b(this.pSK), Boolean.valueOf(this.qgo));
        if (this.pSK == null) {
            ab.e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
            AppMethodBeat.o(47962);
            return;
        }
        ab.c("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", Integer.valueOf(this.pSK.BTB), Integer.valueOf(this.pSK.wew.size()), Boolean.valueOf(this.tOE));
        if (this.pSK.BTB <= 0 || this.pSK.BTB > 5) {
            AppMethodBeat.o(47962);
        } else if (a(this.pSK)) {
            if (this.pSK.BTB == 4) {
                cSK();
            } else if (this.pSK.BTB == 1 || this.pSK.BTB == 2 || this.pSK.BTB == 3) {
                cSJ();
            } else if (this.pSK.BTB == 5) {
                cSL();
            }
            if (this.qgo || this.tOE) {
                h hVar = h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(3);
                if (!this.tOE) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                hVar.e(15225, objArr);
            }
            this.qgo = false;
            AppMethodBeat.o(47962);
        } else {
            AppMethodBeat.o(47962);
        }
    }

    private void cSH() {
        AppMethodBeat.i(47963);
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
        LayoutParams layoutParams = (LayoutParams) this.gtb.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) this.hrg.getLayoutParams();
        layoutParams.addRule(15, -1);
        layoutParams2.addRule(15, 0);
        this.gtb.setLayoutParams(layoutParams);
        this.hrg.setLayoutParams(layoutParams2);
        this.gtb.setVisibility(0);
        this.hrg.setVisibility(8);
        this.gtb.setText(R.string.ftj);
        this.gtb.setTextColor(Color.parseColor("#353535"));
        this.hrg.setTextColor(Color.parseColor("#B2B2B2"));
        this.tOy.setVisibility(8);
        findViewById(R.id.dz8).setVisibility(0);
        findViewById(R.id.dzc).setVisibility(0);
        this.tOx.setVisibility(8);
        this.kqn.setVisibility(0);
        this.kqn.setImageResource(R.drawable.blg);
        this.tOA.setVisibility(8);
        this.tOA.onDestroy();
        this.tOB.setVisibility(8);
        this.tOB.destroy();
        AppMethodBeat.o(47963);
    }

    public final void init() {
        AppMethodBeat.i(47964);
        if (this.tOD != null) {
            ab.i("MicroMsg.WalletSuccPageAwardWidget", "init");
            this.tOD.nf(1859);
            this.tOD.nf(2547);
            this.tOD.nf(2803);
            this.tOD.nf(2508);
            this.tOD.nf(2529);
            this.tOD.nf(2888);
        }
        AppMethodBeat.o(47964);
    }

    public final void onDestroy() {
        int i = 2;
        AppMethodBeat.i(47965);
        if (this.tOD != null) {
            this.tOD.ng(1859);
            this.tOD.ng(2547);
            this.tOD.ng(2803);
            this.tOD.ng(2508);
            this.tOD.ng(2529);
            this.tOD.ng(2888);
            ab.i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", Boolean.valueOf(this.tOF), Boolean.valueOf(this.tOG));
            if (!(this.tOF || this.tOG)) {
                h hVar = h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(6);
                if (!this.tOE) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                hVar.e(15225, objArr);
                ab.i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
                this.tOD.a(new com.tencent.mm.plugin.wallet_core.c.g(this.pSK.wdr, 4, this.ttT), false, false);
            }
        }
        if (this.tOA != null) {
            this.tOA.onDestroy();
        }
        if (this.tOB != null) {
            this.tOB.destroy();
        }
        AppMethodBeat.o(47965);
    }

    public final void onResume() {
        AppMethodBeat.i(47966);
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "onResume, isClickH5OrTinyApp: %s, exposureInfo: %s, isMiniAppReturn: %s", Boolean.valueOf(this.tOE), b(this.pSK), Boolean.valueOf(this.tOI));
        if (!this.tOI) {
            this.tOI = true;
            cSI();
        }
        AppMethodBeat.o(47966);
    }

    private void cSI() {
        AppMethodBeat.i(47967);
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "updateViewAfterMiniAppReturn");
        if (!(this.pSK.BTF == null || this.pSK.BTF.xis == 1)) {
            this.tOA.setVisibility(8);
            this.tOA.onDestroy();
            this.tOB.setVisibility(8);
            this.tOB.destroy();
        }
        cSN();
        AppMethodBeat.o(47967);
    }

    private void cSJ() {
        AppMethodBeat.i(47968);
        cSM();
        if (this.tOB.getVisibility() != 8) {
            this.tOB.setVisibility(8);
            this.tOB.destroy();
        }
        if (this.tOA.getVisibility() != 0) {
            this.tOA.setVisibility(0);
            this.tOA.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(47940);
                    if (WalletSuccPageAwardWidget.this.tOA.getHeight() != WalletSuccPageAwardWidget.this.getHeight()) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) WalletSuccPageAwardWidget.this.tOA.getLayoutParams();
                        layoutParams.width = WalletSuccPageAwardWidget.this.sis.getWidth();
                        layoutParams.height = WalletSuccPageAwardWidget.this.sis.getHeight();
                        WalletSuccPageAwardWidget.this.tOA.setLayoutParams(layoutParams);
                    }
                    WalletSuccPageAwardWidget.c(WalletSuccPageAwardWidget.this);
                    AppMethodBeat.o(47940);
                }
            });
        }
        AppMethodBeat.o(47968);
    }

    private void cSK() {
        AppMethodBeat.i(47969);
        cSM();
        if (this.tOA.getVisibility() != 8) {
            this.tOA.setVisibility(8);
            this.tOA.onDestroy();
        }
        if (this.tOB.getVisibility() != 8) {
            this.tOB.setVisibility(8);
            this.tOB.destroy();
        }
        AppMethodBeat.o(47969);
    }

    private void cSL() {
        AppMethodBeat.i(47970);
        cSM();
        if (this.tOA.getVisibility() != 8) {
            this.tOA.setVisibility(8);
            this.tOA.onDestroy();
        }
        if (this.pSK.BTF != null) {
            ab.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, op_type: %s", Integer.valueOf(this.pSK.BTF.xis));
            switch (this.pSK.BTF.xis) {
                case 1:
                    if (this.tOB.getVisibility() != 0) {
                        this.tOB.setVisibility(0);
                        this.tOB.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(47944);
                                if (WalletSuccPageAwardWidget.this.tOB.getHeight() != WalletSuccPageAwardWidget.this.getHeight()) {
                                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) WalletSuccPageAwardWidget.this.tOB.getLayoutParams();
                                    layoutParams.width = WalletSuccPageAwardWidget.this.sis.getWidth();
                                    layoutParams.height = WalletSuccPageAwardWidget.this.sis.getHeight() - com.tencent.mm.bz.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 2);
                                    layoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                                    layoutParams.bottomMargin = com.tencent.mm.bz.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                                    WalletSuccPageAwardWidget.this.tOB.setLayoutParams(layoutParams);
                                }
                                AppMethodBeat.o(47944);
                            }
                        });
                    }
                    this.tOB.destroy();
                    if (!bo.isNullOrNil(this.pSK.BTF.BTw)) {
                        ab.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording: %s", this.pSK.BTF.BTw);
                        this.tOB.setShakeHintWording(this.pSK.BTF.BTw);
                    }
                    if (!bo.isNullOrNil(this.pSK.BTF.BTx)) {
                        try {
                            ab.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording_color: %s", this.pSK.BTF.BTx);
                            this.tOB.setShakeHintWordingColor(Color.parseColor(this.pSK.BTF.BTx));
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e, "parse animation_wording_color %s error %s", this.pSK.BTF.BTx, e.getMessage());
                        }
                    }
                    if (!bo.isNullOrNil(this.pSK.BTF.BTy)) {
                        ab.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording: %s", this.pSK.BTF.BTy);
                        this.tOB.setAfterHintWording(this.pSK.BTF.BTy);
                    }
                    if (!bo.isNullOrNil(this.pSK.BTF.BTz)) {
                        ab.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording_color: %s", this.pSK.BTF.BTz);
                        try {
                            this.tOB.setAfterHintWordingColor(Color.parseColor(this.pSK.BTF.BTz));
                        } catch (Exception e2) {
                            ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e2, "parse after_animation_wording_color %s error %s", this.pSK.BTF.BTz, e2.getMessage());
                        }
                    }
                    this.tOB.setShakeOrClickCallback(new WalletAwardShakeAnimView.a() {
                        public final void ns(boolean z) {
                            AppMethodBeat.i(47945);
                            ab.i("MicroMsg.WalletSuccPageAwardWidget", "onStartShakeOrClick, isShake: %s, isClickH5OrTinyApp: %s", Boolean.valueOf(z), Boolean.valueOf(WalletSuccPageAwardWidget.this.tOE));
                            h hVar;
                            Object[] objArr;
                            if (z) {
                                hVar = h.pYm;
                                objArr = new Object[2];
                                objArr[0] = Integer.valueOf(4);
                                objArr[1] = Integer.valueOf(WalletSuccPageAwardWidget.this.tOE ? 2 : 1);
                                hVar.e(15225, objArr);
                            } else {
                                hVar = h.pYm;
                                objArr = new Object[2];
                                objArr[0] = Integer.valueOf(7);
                                objArr[1] = Integer.valueOf(WalletSuccPageAwardWidget.this.tOE ? 2 : 1);
                                hVar.e(15225, objArr);
                            }
                            WalletSuccPageAwardWidget.this.tOB.setShakeHintWording(WalletSuccPageAwardWidget.this.getContext().getString(R.string.ftk));
                            WalletSuccPageAwardWidget.this.tOB.setShakeHintWordingColor(Color.parseColor("#9C9C9C"));
                            WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 2, false);
                            WalletSuccPageAwardWidget.this.tOF = true;
                            AppMethodBeat.o(47945);
                        }
                    });
                    this.tOB.cSw();
                    AppMethodBeat.o(47970);
                    return;
                case 2:
                    f fVar = this.pSK.BTF.BTv;
                    if (fVar != null) {
                        ab.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, jump tiny app, userName: %s, path: %s, version: %s", fVar.wMk, fVar.wMl, Integer.valueOf(fVar.wMm));
                        se seVar = new se();
                        seVar.cOf.userName = fVar.wMk;
                        seVar.cOf.cOh = bo.bc(fVar.wMl, "");
                        seVar.cOf.scene = 1060;
                        seVar.cOf.cst = this.kBE;
                        seVar.cOf.cOi = 0;
                        if (fVar.wMm > 0) {
                            seVar.cOf.axy = fVar.wMm;
                        }
                        seVar.cOf.context = this.tOD;
                        com.tencent.mm.sdk.b.a.xxA.m(seVar);
                        this.tOE = true;
                        this.tOI = false;
                        this.fbD.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(47946);
                                WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
                                AppMethodBeat.o(47946);
                            }
                        }, 3000);
                        AppMethodBeat.o(47970);
                        return;
                    }
                    break;
                case 3:
                    ab.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, goto h5, url: %s", this.pSK.BTF.url);
                    com.tencent.mm.wallet_core.ui.e.n(this.tOD, this.pSK.BTF.url, false);
                    this.tOE = true;
                    this.tOI = false;
                    this.fbD.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(47947);
                            WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
                            AppMethodBeat.o(47947);
                        }
                    }, 3000);
                    AppMethodBeat.o(47970);
                    return;
                case 4:
                    ab.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, directly show info");
                    this.tOA.setVisibility(8);
                    this.tOA.onDestroy();
                    break;
                default:
                    this.tOB.setVisibility(8);
                    this.tOB.destroy();
                    AppMethodBeat.o(47970);
                    return;
            }
        }
        this.tOB.setVisibility(8);
        this.tOB.destroy();
        AppMethodBeat.o(47970);
    }

    private static String adh(String str) {
        AppMethodBeat.i(47971);
        if (bo.Q(new String[0])) {
            AppMethodBeat.o(47971);
            return null;
        }
        com.tencent.mm.vfs.e.tf(tOJ);
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "buildImagePathByUrl, url: %s, path: %s", str, tOJ + d.x(str.getBytes()));
        AppMethodBeat.o(47971);
        return tOJ + d.x(str.getBytes());
    }

    private void cSM() {
        com.tencent.mm.at.a.a.c.a aVar;
        AppMethodBeat.i(47972);
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "initBaseLotteryView");
        LinkedList linkedList = this.pSK.wew;
        String str = "MicroMsg.WalletSuccPageAwardWidget";
        String str2 = "singleExposureInfoList %s, size: %s";
        Object[] objArr = new Object[2];
        objArr[0] = linkedList;
        objArr[1] = Integer.valueOf(linkedList != null ? linkedList.size() : 0);
        ab.i(str, str2, objArr);
        if (linkedList != null && linkedList.size() > 0) {
            int i;
            this.tOC = (g) linkedList.get(0);
            ab.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", Integer.valueOf(0), this.tOC.BTP, this.tOC.BTQ, this.tOC.pia);
            this.kqn.setUrl(this.tOC.pia);
            if (!bo.isNullOrNil(this.tOC.pia)) {
                this.kqn.setVisibility(0);
            }
            if (bo.isNullOrNil(this.tOC.BTP)) {
                i = 0;
            } else {
                this.gtb.setText(this.tOC.BTP);
                this.gtb.setVisibility(0);
                try {
                    if (!bo.isNullOrNil(this.tOC.BTS)) {
                        this.gtb.setTextColor(Color.parseColor(this.tOC.BTS));
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e, "parse award_name_color error: %s", e.getMessage());
                }
                i = 1;
            }
            if (!bo.isNullOrNil(this.tOC.BTQ)) {
                this.hrg.setText(this.tOC.BTQ);
                this.hrg.setVisibility(0);
                try {
                    if (!bo.isNullOrNil(this.tOC.BTT)) {
                        this.hrg.setTextColor(Color.parseColor(this.tOC.BTT));
                    }
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e2, "parse award_description_color error: %s", e2.getMessage());
                }
                i = 1;
            }
            if (i != 0) {
                LayoutParams layoutParams = (LayoutParams) this.gtb.getLayoutParams();
                LayoutParams layoutParams2 = (LayoutParams) this.hrg.getLayoutParams();
                if (!bo.isNullOrNil(this.tOC.BTP) && bo.isNullOrNil(this.tOC.BTQ)) {
                    layoutParams.addRule(15, -1);
                    layoutParams2.addRule(15, 0);
                    this.gtb.setLayoutParams(layoutParams);
                    this.hrg.setLayoutParams(layoutParams2);
                    this.gtb.setVisibility(0);
                    this.hrg.setVisibility(8);
                } else if (!bo.isNullOrNil(this.tOC.BTP) || bo.isNullOrNil(this.tOC.BTQ)) {
                    layoutParams.addRule(15, 0);
                    layoutParams2.addRule(15, 0);
                    this.gtb.setLayoutParams(layoutParams);
                    this.hrg.setLayoutParams(layoutParams2);
                    this.gtb.setVisibility(0);
                    this.hrg.setVisibility(0);
                } else {
                    layoutParams.addRule(15, 0);
                    layoutParams2.addRule(15, -1);
                    this.gtb.setLayoutParams(layoutParams);
                    this.hrg.setLayoutParams(layoutParams2);
                    this.gtb.setVisibility(8);
                    this.hrg.setVisibility(0);
                }
            }
            if (bo.isNullOrNil(this.tOC.BTR)) {
                this.tOy.setVisibility(8);
                findViewById(R.id.dz8).setVisibility(0);
                findViewById(R.id.dzc).setVisibility(0);
            } else {
                ab.i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", this.tOC.BTR);
                aVar = new com.tencent.mm.at.a.a.c.a();
                aVar.ePH = true;
                aVar.ePG = true;
                aVar.ePJ = adh(this.tOC.BTR);
                o.ahp().a(this.tOC.BTR, null, aVar.ahG(), new i() {
                    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(47950);
                        ab.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", str, bitmap);
                        if (!(bitmap == null || WalletSuccPageAwardWidget.this.tOC == null || bo.isNullOrNil(WalletSuccPageAwardWidget.this.tOC.BTR) || !WalletSuccPageAwardWidget.this.tOC.BTR.equals(str))) {
                            final NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(WalletSuccPageAwardWidget.this.getResources(), new NinePatch(bitmap, WalletSuccPageAwardWidget.ac(bitmap), "widget_bg"));
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(47949);
                                    WalletSuccPageAwardWidget.this.tOy.setImageDrawable(ninePatchDrawable);
                                    WalletSuccPageAwardWidget.this.tOy.setVisibility(0);
                                    WalletSuccPageAwardWidget.this.tOy.post(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(47948);
                                            ViewGroup.LayoutParams layoutParams = WalletSuccPageAwardWidget.this.tOy.getLayoutParams();
                                            layoutParams.height = WalletSuccPageAwardWidget.this.sis.getHeight();
                                            layoutParams.width = WalletSuccPageAwardWidget.this.sis.getWidth();
                                            WalletSuccPageAwardWidget.this.tOy.setLayoutParams(layoutParams);
                                            WalletSuccPageAwardWidget.this.findViewById(R.id.dz8).setVisibility(8);
                                            WalletSuccPageAwardWidget.this.findViewById(R.id.dzc).setVisibility(8);
                                            AppMethodBeat.o(47948);
                                        }
                                    });
                                    AppMethodBeat.o(47949);
                                }
                            });
                        }
                        AppMethodBeat.o(47950);
                    }
                });
            }
        }
        String str3 = "MicroMsg.WalletSuccPageAwardWidget";
        str = "is_show_btn: %s, btn_info: %s, btn_words: %s";
        Object[] objArr2 = new Object[3];
        objArr2[0] = Integer.valueOf(this.pSK.wex);
        objArr2[1] = this.pSK.wey;
        objArr2[2] = this.pSK.wey != null ? this.pSK.wey.BTs : "";
        ab.i(str3, str, objArr2);
        if (this.pSK.wex == 0 || this.pSK.wey == null || bo.isNullOrNil(this.pSK.wey.BTs)) {
            this.tOx.setVisibility(8);
        } else {
            a aVar2 = this.pSK.wey;
            if (aVar2 != null) {
                ab.i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", aVar2.BTs, Integer.valueOf(aVar2.BTu), aVar2.BTt, aVar2.url);
                this.tOx.setText(aVar2.BTs);
                if (!bo.isNullOrNil(aVar2.BTt)) {
                    Drawable drawable = getContext().getResources().getDrawable(R.drawable.fp);
                    drawable.setColorFilter(Color.parseColor(aVar2.BTt), Mode.SRC);
                    this.tOx.setBackground(drawable);
                }
                this.tOx.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        int i = 2;
                        AppMethodBeat.i(47953);
                        if (!(WalletSuccPageAwardWidget.this.pSK == null || WalletSuccPageAwardWidget.this.pSK.wey == null)) {
                            WalletSuccPageAwardWidget.this.tOH = WalletSuccPageAwardWidget.this.pSK.wey;
                            ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", Integer.valueOf(WalletSuccPageAwardWidget.this.tOH.BTu));
                            if (WalletSuccPageAwardWidget.this.tOH.BTu == 1) {
                                ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", Integer.valueOf(WalletSuccPageAwardWidget.this.tOH.BTu), WalletSuccPageAwardWidget.this.tOH.url);
                                com.tencent.mm.wallet_core.ui.e.n(WalletSuccPageAwardWidget.this.tOD, WalletSuccPageAwardWidget.this.tOH.url, false);
                                WalletSuccPageAwardWidget.this.tOE = true;
                                WalletSuccPageAwardWidget.this.tOG = true;
                                WalletSuccPageAwardWidget.this.tOI = false;
                                WalletSuccPageAwardWidget.this.fbD.postDelayed(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(47951);
                                        WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
                                        AppMethodBeat.o(47951);
                                    }
                                }, 3000);
                            } else if (WalletSuccPageAwardWidget.this.tOH.BTu == 2) {
                                f fVar = WalletSuccPageAwardWidget.this.tOH.BTv;
                                if (fVar != null) {
                                    ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", fVar.wMk, fVar.wMl, Integer.valueOf(fVar.wMm));
                                    se seVar = new se();
                                    seVar.cOf.userName = fVar.wMk;
                                    seVar.cOf.cOh = bo.bc(fVar.wMl, "");
                                    seVar.cOf.scene = 1060;
                                    seVar.cOf.cst = WalletSuccPageAwardWidget.this.kBE;
                                    seVar.cOf.cOi = 0;
                                    if (fVar.wMm > 0) {
                                        seVar.cOf.axy = fVar.wMm;
                                    }
                                    seVar.cOf.context = WalletSuccPageAwardWidget.this.tOD;
                                    com.tencent.mm.sdk.b.a.xxA.m(seVar);
                                    WalletSuccPageAwardWidget.this.tOE = true;
                                    WalletSuccPageAwardWidget.this.tOI = false;
                                    WalletSuccPageAwardWidget.this.fbD.postDelayed(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(47952);
                                            WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
                                            AppMethodBeat.o(47952);
                                        }
                                    }, 3000);
                                }
                                WalletSuccPageAwardWidget.this.tOG = true;
                            } else if (WalletSuccPageAwardWidget.this.tOH.BTu == 3) {
                                ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
                                WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                                WalletSuccPageAwardWidget.this.tOG = true;
                            } else if (WalletSuccPageAwardWidget.this.tOH.BTu == 5) {
                                ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
                            } else if (WalletSuccPageAwardWidget.this.tOH.BTu == 6) {
                                ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
                                WalletSuccPageAwardWidget.this.tOG = true;
                            } else if (WalletSuccPageAwardWidget.this.tOH.BTu == 7) {
                                ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
                                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 3, true);
                                WalletSuccPageAwardWidget.this.tOG = true;
                            } else if (WalletSuccPageAwardWidget.this.tOH.BTu == 8) {
                                WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                                ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", Integer.valueOf(WalletSuccPageAwardWidget.this.tOH.BTu), WalletSuccPageAwardWidget.this.tOH.url);
                                WalletSuccPageAwardWidget.this.tOG = true;
                            } else if (WalletSuccPageAwardWidget.this.tOH.BTu == 9) {
                                WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                                WalletSuccPageAwardWidget.this.tOG = true;
                            }
                            h hVar = h.pYm;
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(2);
                            if (!WalletSuccPageAwardWidget.this.tOE) {
                                i = 1;
                            }
                            objArr[1] = Integer.valueOf(i);
                            hVar.e(15225, objArr);
                        }
                        AppMethodBeat.o(47953);
                    }
                });
                this.tOx.setVisibility(0);
                if (this.qgo || this.tOE) {
                    h hVar = h.pYm;
                    objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(1);
                    objArr2[1] = Integer.valueOf(this.tOE ? 2 : 1);
                    hVar.e(15225, objArr2);
                }
            }
        }
        if (this.gtb.getVisibility() == 0) {
            this.gtb.setSingleLine();
            this.gtb.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(47954);
                    try {
                        if (WalletSuccPageAwardWidget.this.tOx.getVisibility() == 0 && WalletSuccPageAwardWidget.this.gtb.getRight() > 0 && WalletSuccPageAwardWidget.this.tOx.getLeft() > 0 && WalletSuccPageAwardWidget.this.gtb.getRight() >= WalletSuccPageAwardWidget.this.tOx.getLeft() && !bo.ac(WalletSuccPageAwardWidget.this.gtb.getText())) {
                            float textSize = WalletSuccPageAwardWidget.this.gtb.getTextSize();
                            ab.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv size exceed, nameTv.getRight(): %s, button.getLeft(): %s", Integer.valueOf(WalletSuccPageAwardWidget.this.gtb.getRight()), Integer.valueOf(WalletSuccPageAwardWidget.this.tOx.getLeft()));
                            Paint paint = new Paint();
                            paint.setTextSize(textSize);
                            String charSequence = WalletSuccPageAwardWidget.this.gtb.getText().toString();
                            float left = (float) (WalletSuccPageAwardWidget.this.tOx.getLeft() - WalletSuccPageAwardWidget.this.gtb.getLeft());
                            int i = 1;
                            while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > left && i <= charSequence.length() - 1) {
                                i++;
                            }
                            ab.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv, exceed len, final search count: %s, text.length: %s", Integer.valueOf(i), Integer.valueOf(charSequence.length()));
                            CharSequence substring = charSequence.substring(0, (charSequence.length() - i) - 1);
                            if (charSequence.length() > 9 && substring.length() < 9) {
                                substring = charSequence.substring(0, 9);
                            }
                            WalletSuccPageAwardWidget.this.gtb.setText(substring);
                            WalletSuccPageAwardWidget.this.gtb.append("...");
                        }
                        AppMethodBeat.o(47954);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e, "calc nameTv len error: %s", e.getMessage());
                        AppMethodBeat.o(47954);
                    }
                }
            });
        }
        if (this.tOx.getVisibility() != 0) {
            this.gtb.setEllipsize(TruncateAt.END);
        }
        if (this.pSK.BTC != 0) {
            ab.i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", Integer.valueOf(this.pSK.BTC));
        }
        if (!bo.isNullOrNil(this.pSK.BTE)) {
            ab.i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", this.pSK.BTE);
            if (this.tOz != null) {
                this.tOz.setVisibility(0);
                aVar = new com.tencent.mm.at.a.a.c.a();
                aVar.ePH = true;
                aVar.ePG = true;
                aVar.ePJ = adh(this.pSK.BTE);
                o.ahp().a(this.pSK.BTE, null, aVar.ahG(), new i() {
                    public final void a(String str, View view, final Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(47956);
                        ab.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img_whole finish, url: %s, bitmap: %s", str, bitmap);
                        if (!(bitmap == null || WalletSuccPageAwardWidget.this.pSK == null || bo.isNullOrNil(WalletSuccPageAwardWidget.this.pSK.BTE) || !WalletSuccPageAwardWidget.this.pSK.BTE.equals(str))) {
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(47955);
                                    WalletSuccPageAwardWidget.this.tOz.setScaleType(ScaleType.CENTER_CROP);
                                    WalletSuccPageAwardWidget.this.tOz.setImageBitmap(bitmap);
                                    AppMethodBeat.o(47955);
                                }
                            });
                        }
                        AppMethodBeat.o(47956);
                    }
                });
            }
        }
        AppMethodBeat.o(47972);
    }

    private void cSN() {
        AppMethodBeat.i(47973);
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", Boolean.valueOf(this.tOE));
        if (this.tOE) {
            this.tOD.a(new j(this.pSK.wev, this.ttT), false, false);
        }
        AppMethodBeat.o(47973);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        int i3 = 0;
        AppMethodBeat.i(47974);
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar);
        int i4;
        String str2;
        String str3;
        Object[] objArr;
        if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.i) {
            com.tencent.mm.plugin.wallet_core.c.i iVar = (com.tencent.mm.plugin.wallet_core.c.i) mVar;
            if (i == 0 && i2 == 0) {
                akm akm = iVar.ttY;
                if (akm == null) {
                    ab.e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
                    AppMethodBeat.o(47974);
                    return true;
                }
                ab.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", Integer.valueOf(akm.kdT), akm.kdU, akm.wmt, akm.tBw);
                if (akm.kdT != 0) {
                    ab.i("MicroMsg.WalletSuccPageAwardWidget", "getLotteryFailed");
                } else if (bo.isNullOrNil(akm.wmt)) {
                    if (akm.tBw != null) {
                        i4 = this.pSK.wey != null ? this.pSK.wey.BTu : 0;
                        this.pSK = akm.tBw;
                        if (!(akm.tBw.wey == null || this.pSK.wey == null)) {
                            ab.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", Integer.valueOf(akm.tBw.wey.BTu));
                            if (akm.tBw.wey.BTu == 4) {
                                ab.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                                this.pSK.wey.BTu = i4;
                            }
                        }
                        ab.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
                        cSG();
                    }
                    if (this.tOH != null && this.tOG) {
                        if (this.tOH.BTu == 8) {
                            ab.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
                            com.tencent.mm.wallet_core.ui.e.n(this.tOD, this.tOH.url, false);
                            this.tOE = true;
                        } else if (this.tOH.BTu == 9) {
                            f fVar = this.tOH.BTv;
                            if (fVar != null) {
                                ab.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", fVar.wMk, fVar.wMl, Integer.valueOf(fVar.wMm));
                                se seVar = new se();
                                seVar.cOf.userName = fVar.wMk;
                                seVar.cOf.cOh = bo.bc(fVar.wMl, "");
                                seVar.cOf.scene = 1060;
                                seVar.cOf.cst = this.kBE;
                                seVar.cOf.cOi = 0;
                                if (fVar.wMm > 0) {
                                    seVar.cOf.axy = fVar.wMm;
                                }
                                seVar.cOf.context = this.tOD;
                                com.tencent.mm.sdk.b.a.xxA.m(seVar);
                                this.tOE = true;
                                this.tOI = false;
                                this.fbD.postDelayed(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(47943);
                                        WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
                                        AppMethodBeat.o(47943);
                                    }
                                }, 3000);
                            }
                        }
                    }
                    this.tOH = null;
                    AppMethodBeat.o(47974);
                    return true;
                } else {
                    Toast.makeText(getContext(), akm.wmt, 1).show();
                    AppMethodBeat.o(47974);
                    return true;
                }
            }
            cSH();
            AppMethodBeat.o(47974);
            return true;
        } else if (mVar instanceof j) {
            j jVar = (j) mVar;
            if (i == 0 && i2 == 0) {
                zc zcVar = jVar.tua;
                if (zcVar == null) {
                    ab.e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
                    AppMethodBeat.o(47974);
                    return true;
                }
                str2 = "MicroMsg.WalletSuccPageAwardWidget";
                str3 = "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s";
                objArr = new Object[6];
                objArr[0] = Integer.valueOf(zcVar.kdT);
                objArr[1] = zcVar.kdU;
                objArr[2] = zcVar.wew;
                objArr[3] = Integer.valueOf(zcVar.wex);
                objArr[4] = zcVar.wey;
                objArr[5] = Integer.valueOf(zcVar.wey != null ? zcVar.wey.BTu : 0);
                ab.i(str2, str3, objArr);
                if (zcVar.kdT == 0) {
                    this.pSK.wew = zcVar.wew;
                    this.pSK.wex = zcVar.wex;
                    if (this.pSK.wey != null) {
                        i4 = this.pSK.wey.BTu;
                    } else {
                        i4 = 0;
                    }
                    if (zcVar.wey != null) {
                        this.pSK.wey = zcVar.wey;
                        if (this.pSK.wey != null && zcVar.wey.BTu == 4) {
                            ab.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                            this.pSK.wey.BTu = i4;
                        }
                    }
                    ab.i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", b(this.pSK));
                    cSM();
                }
            }
            this.tOE = false;
            AppMethodBeat.o(47974);
            return true;
        } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.g) {
            com.tencent.mm.plugin.wallet_core.c.g gVar = (com.tencent.mm.plugin.wallet_core.c.g) mVar;
            if (i == 0 && i2 == 0) {
                xq xqVar = gVar.ttS;
                if (xqVar == null) {
                    ab.e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
                    AppMethodBeat.o(47974);
                    return true;
                }
                str2 = "MicroMsg.WalletSuccPageAwardWidget";
                str3 = "drawLottery end, retcode: %s, retmsg: %s, exposure_info: %s, single_exposure_info_list: %s";
                objArr = new Object[4];
                objArr[0] = Integer.valueOf(xqVar.kdT);
                objArr[1] = xqVar.kdU;
                objArr[2] = xqVar.tBw;
                objArr[3] = xqVar.tBw != null ? xqVar.tBw.wew : "";
                ab.i(str2, str3, objArr);
                if (xqVar.tBw == null || xqVar.tBw.wew == null || xqVar.tBw.wew.size() <= 0) {
                    cSH();
                } else {
                    str2 = "MicroMsg.WalletSuccPageAwardWidget";
                    str3 = "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s";
                    objArr = new Object[3];
                    objArr[0] = xqVar.tBw;
                    objArr[1] = xqVar.tBw.wey;
                    if (xqVar.tBw.wey != null) {
                        i4 = xqVar.tBw.wey.BTu;
                    } else {
                        i4 = 0;
                    }
                    objArr[2] = Integer.valueOf(i4);
                    ab.i(str2, str3, objArr);
                    if (this.pSK.wey != null) {
                        i3 = this.pSK.wey.BTu;
                    }
                    this.pSK = xqVar.tBw;
                    if (!(this.pSK.wey == null || xqVar.tBw.wey == null || xqVar.tBw.wey.BTu != 4)) {
                        ab.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                        this.pSK.wey.BTu = i3;
                    }
                    cSG();
                }
            } else {
                cSH();
            }
            AppMethodBeat.o(47974);
            return true;
        } else {
            AppMethodBeat.o(47974);
            return false;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(47975);
        if (this.tOA != null && this.tOA.getVisibility() == 0) {
            if (this.tOA != null) {
                boolean K;
                WalletScratchShakeView walletScratchShakeView = this.tOA;
                if (walletScratchShakeView.tNW != null) {
                    K = walletScratchShakeView.tNW.K(motionEvent);
                } else {
                    K = false;
                }
                if (K) {
                }
                walletScratchShakeView = this.tOA;
                if (walletScratchShakeView.tNW != null) {
                    K = walletScratchShakeView.tNW.tOq;
                } else {
                    K = true;
                }
                if (!K) {
                    z = this.tOA.dispatchTouchEvent(motionEvent);
                }
            }
            if (!(this.sis == null || z)) {
                z = this.sis.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(47975);
                return z;
            }
        }
        z = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(47975);
        return z;
    }

    private static String b(c cVar) {
        AppMethodBeat.i(47976);
        String jSONObject;
        if (cVar != null) {
            try {
                JSONObject jSONObject2;
                JSONObject jSONObject3 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                if (cVar.wew != null && cVar.wew.size() > 0) {
                    Iterator it = cVar.wew.iterator();
                    while (it.hasNext()) {
                        g gVar = (g) it.next();
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("logo", gVar.pia);
                        jSONObject4.put("award_name", gVar.BTP);
                        jSONObject4.put("award_description", gVar.BTQ);
                        jSONObject4.put("background_img", gVar.BTR);
                        jSONObject4.put("award_name_color", gVar.BTS);
                        jSONObject4.put("award_description_color", gVar.BTT);
                        jSONArray.put(jSONObject4);
                    }
                }
                jSONObject3.put("single_exposure_info_list", jSONArray);
                jSONObject3.put("is_query_others", cVar.BTA);
                jSONObject3.put("draw_lottery_params", cVar.wdr);
                jSONObject3.put("is_show_btn", cVar.wex);
                JSONObject jSONObject5 = new JSONObject();
                if (cVar.wey != null) {
                    jSONObject5.put("btn_words", cVar.wey.BTs);
                    jSONObject5.put("btn_color", cVar.wey.BTt);
                    jSONObject5.put("btn_op_type", cVar.wey.BTu);
                    jSONObject5.put("url", cVar.wey.url);
                    jSONObject2 = new JSONObject();
                    if (cVar.wey.BTv != null) {
                        jSONObject2.put("activity_tinyapp_username", cVar.wey.BTv.wMk);
                        jSONObject2.put("activity_tinyapp_path", cVar.wey.BTv.wMl);
                        jSONObject2.put("activity_tinyapp_version", cVar.wey.BTv.wMm);
                    }
                    jSONObject5.put("mini_app_info", jSONObject2);
                    jSONObject5.put("get_lottery_params", cVar.wey.wqf);
                }
                jSONObject3.put("btn_info", jSONObject5);
                jSONObject3.put("exposure_info_modify_params", cVar.wev);
                jSONObject3.put("user_opertaion_type", cVar.BTB);
                jSONObject3.put("is_show_layer", cVar.BTC);
                jSONObject3.put("background_img_whole", cVar.BTE);
                if (cVar.BTF != null) {
                    jSONObject5 = new JSONObject();
                    jSONObject5.put("animation_wording", cVar.BTF.BTw);
                    jSONObject5.put("animation_wording_color", cVar.BTF.BTx);
                    jSONObject5.put("url", cVar.BTF.url);
                    jSONObject5.put("op_type", cVar.BTF.xis);
                    jSONObject5.put("after_animation_wording", cVar.BTF.BTy);
                    jSONObject5.put("after_animation_wording_color", cVar.BTF.BTz);
                    jSONObject2 = new JSONObject();
                    if (cVar.BTF.BTv != null) {
                        jSONObject2.put("activity_tinyapp_username", cVar.BTF.BTv.wMk);
                        jSONObject2.put("activity_tinyapp_path", cVar.BTF.BTv.wMl);
                        jSONObject2.put("activity_tinyapp_version", cVar.BTF.BTv.wMm);
                    }
                    jSONObject5.put("mini_app_info", jSONObject2);
                    jSONObject3.put("draw_lottery_info", jSONObject5);
                }
                jSONObject = jSONObject3.toString();
                AppMethodBeat.o(47976);
                return jSONObject;
            } catch (Exception e) {
                jSONObject = "";
                AppMethodBeat.o(47976);
                return jSONObject;
            }
        }
        jSONObject = "";
        AppMethodBeat.o(47976);
        return jSONObject;
    }

    static /* synthetic */ void c(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        boolean z;
        AppMethodBeat.i(47977);
        boolean z2 = walletSuccPageAwardWidget.pSK.BTB == 1 || walletSuccPageAwardWidget.pSK.BTB == 3;
        if (walletSuccPageAwardWidget.pSK.BTB == 2 || walletSuccPageAwardWidget.pSK.BTB == 3) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "initScratchShakeView, canScratch: %s, canShrake: %s", Boolean.valueOf(z2), Boolean.valueOf(z));
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(walletSuccPageAwardWidget.getContext(), 50);
        WalletScratchShakeView walletScratchShakeView = walletSuccPageAwardWidget.tOA;
        float f = (float) fromDPToPix;
        fromDPToPix /= 2;
        ab.i("MicroMsg.WalletScratchShakeView", "init canShake: %s, canScratch: %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        walletScratchShakeView.tNY = z2;
        walletScratchShakeView.tNX = z;
        if (walletScratchShakeView.tNW != null) {
            walletScratchShakeView.removeView(walletScratchShakeView.tNW);
            walletScratchShakeView.tNW = null;
        }
        walletScratchShakeView.tNW = new b(walletScratchShakeView.getContext());
        walletScratchShakeView.addView(walletScratchShakeView.tNW, new ViewGroup.LayoutParams(-1, -1));
        b bVar = walletScratchShakeView.tNW;
        ab.i("MicroMsg.WalletScratchShakeView", "init inner view");
        bVar.aKf = new Paint();
        bVar.aKf.setAntiAlias(true);
        bVar.aKf.setDither(true);
        Bitmap decodeResource = BitmapFactory.decodeResource(bVar.getResources(), R.drawable.blr);
        bVar.tOb = new NinePatchDrawable(bVar.getResources(), new NinePatch(decodeResource, b.ab(decodeResource), "shake_bg"));
        bVar.tOc = new Paint();
        bVar.tOc.setAntiAlias(true);
        bVar.tOc.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        bVar.tOc.setStyle(Style.STROKE);
        bVar.tOc.setStrokeCap(Cap.ROUND);
        bVar.tOc.setStrokeWidth(f);
        bVar.tOd = new Paint();
        bVar.tOd.setAntiAlias(true);
        bVar.tOd.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        bVar.tOd.setStyle(Style.FILL);
        bVar.tOd.setStrokeCap(Cap.ROUND);
        bVar.tOe = new Path();
        bVar.tOf = new Path();
        bVar.tOn = 0.0f;
        bVar.tOm = 0.0f;
        bVar.nfE = ViewConfiguration.get(bVar.getContext()).getScaledTouchSlop();
        bVar.tOk = false;
        bVar.tOl = false;
        bVar.tOo = fromDPToPix;
        if (WalletScratchShakeView.this.tNX) {
            bVar.oOS = new com.tencent.mm.pluginsdk.i.d(bVar.getContext());
            bVar.oOS.a(new com.tencent.mm.pluginsdk.i.d.a() {
                public final void bUT() {
                    AppMethodBeat.i(47923);
                    long az = bo.az(b.this.mfT);
                    if (b.this.tND) {
                        if (az < 80) {
                            AppMethodBeat.o(47923);
                            return;
                        }
                    } else if (az < 1200) {
                        AppMethodBeat.o(47923);
                        return;
                    }
                    b.this.mfT = bo.yz();
                    b.this.tND = true;
                    b.d(b.this);
                    AppMethodBeat.o(47923);
                }
            });
            bVar.mfT = bo.yz();
        }
        bVar.invalidate();
        walletScratchShakeView.setClipChildren(false);
        walletSuccPageAwardWidget.tOA.setScratchShakeCallback(new WalletScratchShakeView.a() {
            public final void nt(boolean z) {
                int i = 2;
                AppMethodBeat.i(47941);
                ab.i("MicroMsg.WalletSuccPageAwardWidget", "onStartScratchOrShake, isScratch: %s", Boolean.valueOf(z));
                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, z ? 1 : 2, false);
                h hVar;
                Object[] objArr;
                if (z) {
                    hVar = h.pYm;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(5);
                    if (!WalletSuccPageAwardWidget.this.tOE) {
                        i = 1;
                    }
                    objArr[1] = Integer.valueOf(i);
                    hVar.e(15225, objArr);
                } else {
                    hVar = h.pYm;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(4);
                    if (!WalletSuccPageAwardWidget.this.tOE) {
                        i = 1;
                    }
                    objArr[1] = Integer.valueOf(i);
                    hVar.e(15225, objArr);
                }
                WalletSuccPageAwardWidget.this.tOF = true;
                AppMethodBeat.o(47941);
            }

            public final void cSD() {
                AppMethodBeat.i(47942);
                ab.i("MicroMsg.WalletSuccPageAwardWidget", "onFinishScratchOrShake");
                if (WalletSuccPageAwardWidget.this.pSK.BTC != 0) {
                    WalletSuccPageAwardWidget.cSO();
                }
                AppMethodBeat.o(47942);
            }
        });
        AppMethodBeat.o(47977);
    }

    static /* synthetic */ void a(WalletSuccPageAwardWidget walletSuccPageAwardWidget, int i, boolean z) {
        AppMethodBeat.i(47978);
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "doDrawLottery, is_query_other: %s", Integer.valueOf(walletSuccPageAwardWidget.pSK.BTA));
        if (walletSuccPageAwardWidget.pSK.BTA != 0) {
            walletSuccPageAwardWidget.tOD.a(new com.tencent.mm.plugin.wallet_core.c.g(walletSuccPageAwardWidget.pSK.wdr, i, walletSuccPageAwardWidget.ttT), z, false);
        }
        AppMethodBeat.o(47978);
    }

    static /* synthetic */ void g(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        AppMethodBeat.i(47979);
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "delayCheckStartMiniApp, isMiniAppReturn: %s", Boolean.valueOf(walletSuccPageAwardWidget.tOI));
        if (!walletSuccPageAwardWidget.tOI) {
            walletSuccPageAwardWidget.cSI();
            walletSuccPageAwardWidget.tOI = true;
        }
        AppMethodBeat.o(47979);
    }

    static /* synthetic */ byte[] ac(Bitmap bitmap) {
        int i = 0;
        AppMethodBeat.i(47980);
        int[] iArr = new int[]{(bitmap.getWidth() / 2) - 3, (bitmap.getWidth() / 2) + 3};
        int[] iArr2 = new int[]{(bitmap.getHeight() / 2) - 3, (bitmap.getHeight() / 2) + 3};
        ByteBuffer order = ByteBuffer.allocate(84).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) 2);
        order.put((byte) 2);
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(iArr[0]);
        order.putInt(iArr[1]);
        order.putInt(iArr2[0]);
        order.putInt(iArr2[1]);
        while (i < 9) {
            order.putInt(1);
            i++;
        }
        byte[] array = order.array();
        AppMethodBeat.o(47980);
        return array;
    }

    static /* synthetic */ void r(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        AppMethodBeat.i(47981);
        walletSuccPageAwardWidget.tOD.a(new com.tencent.mm.plugin.wallet_core.c.i(walletSuccPageAwardWidget.pSK.wey.wqf, walletSuccPageAwardWidget.ttT), true, true);
        AppMethodBeat.o(47981);
    }
}
