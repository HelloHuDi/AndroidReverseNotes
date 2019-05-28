package com.tencent.mm.plugin.mall.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.mall.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.utils.e;
import com.tencent.mm.plugin.wallet_core.utils.e.AnonymousClass4;
import com.tencent.mm.plugin.wallet_core.utils.e.AnonymousClass5;
import com.tencent.mm.plugin.wallet_core.utils.e.AnonymousClass6;
import com.tencent.mm.plugin.wallet_core.utils.e.AnonymousClass7;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ave;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.btq;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.cge;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cnv;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.protocal.protobuf.ms;
import com.tencent.mm.protocal.protobuf.mt;
import com.tencent.mm.protocal.protobuf.ux;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MallWalletUI extends WalletBaseUI {
    private static final int onM = a.fromDPToPix(ah.getContext(), 8);
    private Dialog msu;
    private boolean ohG = false;
    private LinearLayout onN;
    private LinearLayout onO;
    private cge onP;
    private Dialog onQ;
    private i.a onR;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(43278);
        AppMethodBeat.o(43278);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.acg;
    }

    public final void initView() {
        AppMethodBeat.i(43269);
        this.onN = (LinearLayout) findViewById(R.id.d72);
        this.onO = (LinearLayout) findViewById(R.id.d73);
        AppMethodBeat.o(43269);
    }

    public void onResume() {
        AppMethodBeat.i(43270);
        super.onResume();
        AppMethodBeat.o(43270);
    }

    public void onPause() {
        AppMethodBeat.i(43271);
        super.onPause();
        AppMethodBeat.o(43271);
    }

    public void onDestroy() {
        AppMethodBeat.i(43272);
        super.onDestroy();
        i.a(this.onR);
        AppMethodBeat.o(43272);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(43273);
        ab.i("MicroMsg.MallWalletUI", "requestCode: %s, resultCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 65281 || i == 65286) {
            bNt();
            AppMethodBeat.o(43273);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(43273);
    }

    private void bNt() {
        AppMethodBeat.i(43274);
        ab.i("MicroMsg.MallWalletUI", "do query wechat wallet");
        this.msu = g.b(this, false, null);
        i.a(this.onR, true);
        AppMethodBeat.o(43274);
    }

    private void co(List<cgv> list) {
        AppMethodBeat.i(43275);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(43275);
            return;
        }
        this.onO.removeAllViews();
        int i = 0;
        list.size();
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                cgv cgv = (cgv) it.next();
                TextView textView = new TextView(this);
                e.a(textView, cgv, new e.a() {
                    public final void a(btr btr) {
                        int i;
                        AppMethodBeat.i(43267);
                        String str = "";
                        if (btr.type == 1) {
                            str = btr.url;
                            i = 1;
                        } else if (btr.type == 2 && btr.wVC != null) {
                            str = btr.wVC.username;
                            i = 2;
                        } else if (btr.type == 4 || btr.type == 5) {
                            str = btr.url;
                            i = 3;
                        } else {
                            i = 0;
                        }
                        h.pYm.e(16502, Integer.valueOf(2), str, Integer.valueOf(i));
                        AppMethodBeat.o(43267);
                    }
                });
                LayoutParams layoutParams = new LayoutParams(-2, -2);
                if (i2 != 0) {
                    layoutParams.topMargin = a.fromDPToPix(this, 8);
                }
                this.onO.addView(textView, layoutParams);
                i = i2 + 1;
            } else {
                AppMethodBeat.o(43275);
                return;
            }
        }
    }

    private void a(LinearLayout linearLayout, ave ave) {
        AppMethodBeat.i(43276);
        if (ave.wzb != null) {
            int size = ave.wzb.size();
            JSONObject jSONObject = null;
            com.tencent.mm.kernel.g.RQ();
            String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_WALLET_New_MALL_UI_ITEM_REDDOT_CONFIG_STRING_SYNC, (Object) "");
            if (!bo.isNullOrNil(str)) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.MallWalletUI", e, "", new Object[0]);
                }
            }
            ab.i("MicroMsg.MallWalletUI", "cell size: %s", Integer.valueOf(size));
            Iterator it = ave.wzb.iterator();
            int i = 0;
            while (it.hasNext()) {
                Object obj;
                int i2;
                cgd cgd = (cgd) it.next();
                MallWalletSectionCellView mallWalletSectionCellView = new MallWalletSectionCellView(this.mController.ylL);
                if (i < size - 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                e.a(mallWalletSectionCellView.onz, cgd.xff);
                if (cgd.xfi == null || bo.isNullOrNil(cgd.xfi.url)) {
                    mallWalletSectionCellView.onC.setImageResource(R.drawable.bkf);
                } else {
                    e.a(mallWalletSectionCellView.onC, cgd.xfi, R.drawable.bkf, true);
                }
                if (cgd.xfg == null || cgd.xfg.size() <= 0) {
                    mallWalletSectionCellView.onA.setText("");
                } else {
                    e.a(mallWalletSectionCellView.onA, (cgv) cgd.xfg.get(0), null);
                }
                if (cgd.xfk != null) {
                    View view = mallWalletSectionCellView.onI;
                    btq btq = cgd.xfk;
                    if (!(btq == null || view == null)) {
                        e.a((TextView) view, btq.wbo, null);
                        e.a(view, btq.wVz);
                        i2 = (int) btq.wVB;
                        if ((btq.wVB & -16777216) == 0) {
                            i2 = (int) (btq.wVB | -16777216);
                        }
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setShape(0);
                        if (btq.wVA > 0.0f) {
                            gradientDrawable.setCornerRadius((float) a.fromDPToPix(view.getContext(), (int) btq.wVA));
                        }
                        gradientDrawable.setColor(i2);
                        view.setBackground(gradientDrawable);
                    }
                    mallWalletSectionCellView.onI.setVisibility(0);
                } else {
                    mallWalletSectionCellView.onI.setVisibility(8);
                }
                if (cgd.xfh == null || cgd.xfh.size() <= 0) {
                    mallWalletSectionCellView.onB.setText("");
                } else {
                    e.a(mallWalletSectionCellView.onB, (cgv) cgd.xfh.get(0), null);
                }
                if (cgd.xfh == null || cgd.xfh.size() <= 1) {
                    mallWalletSectionCellView.onD.setVisibility(8);
                } else {
                    e.a(mallWalletSectionCellView.onD, (cgv) cgd.xfh.get(1), null);
                }
                if (cgd.xfj == null || jSONObject == null) {
                    mallWalletSectionCellView.bNs();
                } else {
                    Object obj2 = jSONObject.optInt(cgd.xfj.wpJ, 0) == 1 ? 1 : null;
                    long optLong = jSONObject.optLong(String.format("%s_expiretime", new Object[]{cgd.xfj.wpJ}), 0);
                    if (optLong > 0 && System.currentTimeMillis() > optLong) {
                        ab.i("MicroMsg.MallWalletSectionCellView", "red dot expired: %s, %s", cgd.xfj.wpJ, Long.valueOf(optLong));
                        obj2 = null;
                    }
                    if (obj2 == null) {
                        mallWalletSectionCellView.bNs();
                    } else if (cgd.xfj.type == 1) {
                        mallWalletSectionCellView.onE.setVisibility(0);
                        mallWalletSectionCellView.onF.setVisibility(8);
                        mallWalletSectionCellView.onG.setVisibility(8);
                    } else if (cgd.xfj.type == 2) {
                        mallWalletSectionCellView.onE.setVisibility(8);
                        mallWalletSectionCellView.onF.setVisibility(0);
                        mallWalletSectionCellView.onG.setVisibility(8);
                    } else if (cgd.xfj.type == 3) {
                        mallWalletSectionCellView.onG.setText(e.a(mallWalletSectionCellView.getContext(), cgd.xfj.wbo));
                        mallWalletSectionCellView.onE.setVisibility(8);
                        mallWalletSectionCellView.onF.setVisibility(8);
                        mallWalletSectionCellView.onG.setVisibility(0);
                    } else {
                        mallWalletSectionCellView.bNs();
                    }
                }
                i2 = MallWalletSectionCellView.koS;
                int i3 = MallWalletSectionCellView.koS;
                int i4 = MallWalletSectionCellView.koS;
                int i5 = MallWalletSectionCellView.koS;
                if (cgd.wVz != null) {
                    bif bif = cgd.wVz;
                    if (bif.left > 0.0f) {
                        i2 = mallWalletSectionCellView.aN(bif.left);
                    }
                    if (bif.right > 0.0f) {
                        i4 = mallWalletSectionCellView.aN(bif.right);
                    }
                    if (bif.top > 0.0f) {
                        i3 = mallWalletSectionCellView.aN(bif.top);
                    }
                    if (bif.bottom > 0.0f) {
                        i5 = mallWalletSectionCellView.aN(bif.bottom);
                    }
                    mallWalletSectionCellView.onH.setPadding(i2, i3, i4, i5);
                }
                if (obj != null) {
                    mallWalletSectionCellView.onA.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(43249);
                            ab.d("MicroMsg.MallWalletSectionCellView", "x: %s, left: %s", Float.valueOf(MallWalletSectionCellView.this.onA.getX()), Integer.valueOf(MallWalletSectionCellView.this.onA.getLeft()));
                            LayoutParams layoutParams = new LayoutParams(-1, 1);
                            layoutParams.leftMargin = MallWalletSectionCellView.this.onA.getLeft();
                            MallWalletSectionCellView.this.kiH.setLayoutParams(layoutParams);
                            MallWalletSectionCellView.this.kiH.setVisibility(0);
                            AppMethodBeat.o(43249);
                        }
                    });
                } else {
                    mallWalletSectionCellView.kiH.setVisibility(8);
                }
                if (cgd.vCP != null) {
                    mallWalletSectionCellView.setOnClickListener(new com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView.AnonymousClass2(cgd, jSONObject));
                }
                linearLayout.addView(mallWalletSectionCellView);
                i++;
            }
        }
        AppMethodBeat.o(43276);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(43268);
        this.yll = true;
        super.onCreate(bundle);
        xE(Color.parseColor("#f7f7f7"));
        dyb();
        setMMTitle("");
        initView();
        this.onR = new i.a() {
            public final void a(cge cge) {
                AppMethodBeat.i(43264);
                ab.i("MicroMsg.MallWalletUI", "cache callback: %s", cge);
                if (MallWalletUI.this.msu != null) {
                    MallWalletUI.this.msu.dismiss();
                    MallWalletUI.this.msu = null;
                }
                MallWalletUI.this.onP = cge;
                MallWalletUI.c(MallWalletUI.this);
                AppMethodBeat.o(43264);
            }

            public final void b(final bol bol) {
                AppMethodBeat.i(43265);
                ab.i("MicroMsg.MallWalletUI", "net callback: %s", bol);
                if (MallWalletUI.this.msu != null) {
                    MallWalletUI.this.msu.dismiss();
                    MallWalletUI.this.msu = null;
                }
                if (bol != null) {
                    if (bol.wRp != null) {
                        MallWalletUI.this.onP = bol.wRp;
                        MallWalletUI.c(MallWalletUI.this);
                    }
                    if (bol.vCP != null && bol.vCP.type == 13) {
                        MallWalletUI.this.runOnUiThread(new Runnable() {
                            /* JADX WARNING: Removed duplicated region for block: B:64:0x02b4  */
                            /* JADX WARNING: Removed duplicated region for block: B:111:0x00f3 A:{SYNTHETIC} */
                            /* JADX WARNING: Removed duplicated region for block: B:69:0x02ca  */
                            /* JADX WARNING: Removed duplicated region for block: B:49:0x01b2  */
                            /* JADX WARNING: Removed duplicated region for block: B:64:0x02b4  */
                            /* JADX WARNING: Removed duplicated region for block: B:69:0x02ca  */
                            /* JADX WARNING: Removed duplicated region for block: B:111:0x00f3 A:{SYNTHETIC} */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void run() {
                                AppMethodBeat.i(43263);
                                if (!((MallWalletUI.this.onQ != null && MallWalletUI.this.onQ.isShowing()) || MallWalletUI.this.isFinishing() || MallWalletUI.this.ohG)) {
                                    Dialog dialog;
                                    MallWalletUI mallWalletUI = MallWalletUI.this;
                                    Context context = MallWalletUI.this;
                                    ux uxVar = bol.vCP.wVG;
                                    AnonymousClass1 anonymousClass1 = new OnClickListener() {
                                        public final void onClick(View view) {
                                            AppMethodBeat.i(43262);
                                            MallWalletUI.this.onQ.dismiss();
                                            h.pYm.e(16500, Integer.valueOf(5));
                                            AppMethodBeat.o(43262);
                                        }
                                    };
                                    if (uxVar == null) {
                                        dialog = null;
                                    } else {
                                        Dialog dialog2 = new Dialog(context, R.style.zt);
                                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.b3x, null, false);
                                        if (!(uxVar.wcs == null || uxVar.wcs.wHt == null)) {
                                            CdnImageView cdnImageView = (CdnImageView) viewGroup.findViewById(R.id.f_a);
                                            bdr bdr = uxVar.wcs.wHt;
                                            if (bdr.type == 1) {
                                                e.a(cdnImageView, bdr.vQK, R.drawable.b73, true);
                                                int b = b.b(context, 50.0f);
                                                bo.n(cdnImageView, b, b, b, b);
                                                cdnImageView.setOnClickListener(new com.tencent.mm.plugin.wallet_core.utils.e.AnonymousClass2(dialog2));
                                            }
                                        }
                                        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.f_b);
                                        if (!(uxVar.wcu == null || uxVar.wcu.isEmpty())) {
                                            Iterator it = uxVar.wcu.iterator();
                                            while (it.hasNext()) {
                                                cnv cnv = (cnv) it.next();
                                                MarginLayoutParams layoutParams = new LayoutParams(-2, -2);
                                                View textView;
                                                if (cnv.type == 1) {
                                                    textView = new TextView(linearLayout.getContext());
                                                    e.a((TextView) textView, cnv.wbo, null);
                                                    e.a(textView, layoutParams, cnv.xlr);
                                                    linearLayout.addView(textView, layoutParams);
                                                } else if (cnv.type == 11) {
                                                    textView = new CdnImageView(linearLayout.getContext());
                                                    int fromDPToPix = a.fromDPToPix(linearLayout.getContext(), 64);
                                                    e.a(textView, cnv.vQK, -1, false);
                                                    textView.setMinimumWidth(fromDPToPix);
                                                    textView.setMinimumHeight(fromDPToPix);
                                                    e.a(textView, layoutParams, cnv.xlr);
                                                    linearLayout.addView(textView, layoutParams);
                                                } else if (cnv.type == 20) {
                                                    mt mtVar = cnv.xlq;
                                                    cnx cnx = cnv.xlr;
                                                    if (mtVar != null) {
                                                        linearLayout.setGravity(1);
                                                        if (mtVar.vQM != null) {
                                                            View mMSwitchBtn;
                                                            TextView textView2;
                                                            Context context2;
                                                            ms msVar;
                                                            View button;
                                                            LayoutParams layoutParams2;
                                                            LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
                                                            linearLayout2.setGravity(48);
                                                            linearLayout2.setOrientation(0);
                                                            Context context3 = linearLayout.getContext();
                                                            cfy cfy = mtVar.vQM.wbn;
                                                            if (cfy != null) {
                                                                if (cfy.xeY == 0) {
                                                                    mMSwitchBtn = new MMSwitchBtn(context3);
                                                                    if (cfy.wRi == 0) {
                                                                        mMSwitchBtn.setCheck(false);
                                                                    } else if (cfy.wRi == 1) {
                                                                        mMSwitchBtn.setCheck(true);
                                                                    } else {
                                                                        mMSwitchBtn.setEnabled(false);
                                                                    }
                                                                } else if (cfy.xeY == 1) {
                                                                    mMSwitchBtn = new CheckBox(context3);
                                                                    mMSwitchBtn.setBackgroundResource(R.drawable.ub);
                                                                    if (cfy.wRi == 0) {
                                                                        mMSwitchBtn.setChecked(false);
                                                                    } else if (cfy.wRi == 1) {
                                                                        mMSwitchBtn.setChecked(true);
                                                                    } else {
                                                                        mMSwitchBtn.setEnabled(false);
                                                                    }
                                                                }
                                                                textView2 = new TextView(linearLayout.getContext());
                                                                e.a(textView2, mtVar.vQM.wbo, null);
                                                                context2 = linearLayout.getContext();
                                                                msVar = mtVar.vQN;
                                                                if (msVar != null) {
                                                                    if (msVar.vQJ == 1) {
                                                                        button = new Button(context2);
                                                                        button.setTextSize(0, (float) a.al(context2, R.dimen.l2));
                                                                        button.setTextColor(context2.getResources().getColor(R.color.a8m));
                                                                        button.setBackgroundResource(R.drawable.fp);
                                                                        button.setGravity(17);
                                                                        button.setAllCaps(true);
                                                                        button.setPadding(a.al(context2, R.dimen.n7), 0, a.al(context2, R.dimen.n7), 0);
                                                                        button.setWidth(a.fromDPToPix(context2, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE));
                                                                        button.setHeight(a.fromDPToPix(context2, 40));
                                                                        if (msVar.state == 1) {
                                                                            button.setEnabled(true);
                                                                        } else {
                                                                            button.setEnabled(false);
                                                                        }
                                                                        button.setText(msVar.text);
                                                                        if (msVar.kdC == 1) {
                                                                            button.setOnClickListener(new AnonymousClass5(context2, msVar, anonymousClass1));
                                                                        }
                                                                    } else if (msVar.vQJ == 0) {
                                                                        CdnImageView button2 = new CdnImageView(context2);
                                                                        e.a(button2, msVar.vQK);
                                                                        if (msVar.state == 1) {
                                                                            button2.setEnabled(true);
                                                                        } else {
                                                                            button2.setEnabled(false);
                                                                        }
                                                                        if (msVar.kdC == 1) {
                                                                            button2.setOnClickListener(new AnonymousClass6(context2, msVar, anonymousClass1));
                                                                        }
                                                                    }
                                                                    layoutParams2 = new LayoutParams(-2, -2);
                                                                    if (!(cnx == null || cnx.xlt == null)) {
                                                                        layoutParams2.topMargin = a.fromDPToPix(ah.getContext(), (int) cnx.xlt.top);
                                                                    }
                                                                    layoutParams2.bottomMargin = a.fromDPToPix(ah.getContext(), 32);
                                                                    linearLayout.addView(linearLayout2, layoutParams2);
                                                                    if (mMSwitchBtn != null) {
                                                                        linearLayout2.addView(mMSwitchBtn);
                                                                        if (mMSwitchBtn instanceof MMSwitchBtn) {
                                                                            ((MMSwitchBtn) mMSwitchBtn).setSwitchListener(new com.tencent.mm.plugin.wallet_core.utils.e.AnonymousClass3(button2));
                                                                        } else if (mMSwitchBtn instanceof CheckBox) {
                                                                            ((CheckBox) mMSwitchBtn).setOnCheckedChangeListener(new AnonymousClass4(button2));
                                                                        }
                                                                    }
                                                                    linearLayout2.addView(textView2);
                                                                    if (button2 != null) {
                                                                        LayoutParams layoutParams3 = new LayoutParams(-2, -2);
                                                                        if (!(cnx == null || cnx.xlt == null)) {
                                                                            layoutParams3.bottomMargin = a.fromDPToPix(ah.getContext(), (int) cnx.xlt.bottom);
                                                                        }
                                                                        linearLayout.addView(button2, layoutParams3);
                                                                    }
                                                                }
                                                                button2 = null;
                                                                layoutParams2 = new LayoutParams(-2, -2);
                                                                layoutParams2.topMargin = a.fromDPToPix(ah.getContext(), (int) cnx.xlt.top);
                                                                layoutParams2.bottomMargin = a.fromDPToPix(ah.getContext(), 32);
                                                                linearLayout.addView(linearLayout2, layoutParams2);
                                                                if (mMSwitchBtn != null) {
                                                                }
                                                                linearLayout2.addView(textView2);
                                                                if (button2 != null) {
                                                                }
                                                            }
                                                            mMSwitchBtn = null;
                                                            textView2 = new TextView(linearLayout.getContext());
                                                            e.a(textView2, mtVar.vQM.wbo, null);
                                                            context2 = linearLayout.getContext();
                                                            msVar = mtVar.vQN;
                                                            if (msVar != null) {
                                                            }
                                                            button2 = null;
                                                            layoutParams2 = new LayoutParams(-2, -2);
                                                            layoutParams2.topMargin = a.fromDPToPix(ah.getContext(), (int) cnx.xlt.top);
                                                            layoutParams2.bottomMargin = a.fromDPToPix(ah.getContext(), 32);
                                                            linearLayout.addView(linearLayout2, layoutParams2);
                                                            if (mMSwitchBtn != null) {
                                                            }
                                                            linearLayout2.addView(textView2);
                                                            if (button2 != null) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        dialog2.setContentView(viewGroup);
                                        dialog2.setCancelable(true);
                                        dialog2.setCanceledOnTouchOutside(false);
                                        dialog = dialog2;
                                    }
                                    mallWalletUI.onQ = dialog;
                                    MallWalletUI.this.addDialog(MallWalletUI.this.onQ);
                                    MallWalletUI.this.onQ.show();
                                    MallWalletUI.this.ohG = true;
                                }
                                AppMethodBeat.o(43263);
                            }
                        });
                    }
                }
                AppMethodBeat.o(43265);
            }
        };
        bNt();
        AppMethodBeat.o(43268);
    }

    static /* synthetic */ void c(MallWalletUI mallWalletUI) {
        AppMethodBeat.i(43277);
        if (mallWalletUI.onP != null) {
            bdq bdq = mallWalletUI.onP.xfl;
            if (bdq != null) {
                mallWalletUI.M(e.a((Context) mallWalletUI, bdq.vCN, null));
                bdr bdr = bdq.wHs;
                AnonymousClass2 anonymousClass2 = new e.a() {
                    public final void a(btr btr) {
                        AppMethodBeat.i(43266);
                        h.pYm.e(16502, Integer.valueOf(1));
                        AppMethodBeat.o(43266);
                    }
                };
                if (bdr.type == 2 && bdr.wbo != null) {
                    mallWalletUI.addTextOptionMenu(0, e.a((Context) mallWalletUI, bdr.wbo), new AnonymousClass7(bdr, anonymousClass2, mallWalletUI));
                }
            }
            ab.i("MicroMsg.MallWalletUI", "section size: %s", mallWalletUI.onP.xfm);
            mallWalletUI.onN.removeAllViews();
            Iterator it = mallWalletUI.onP.xfm.iterator();
            while (it.hasNext()) {
                ave ave = (ave) it.next();
                LinearLayout linearLayout = new LinearLayout(mallWalletUI);
                linearLayout.setOrientation(1);
                mallWalletUI.a(linearLayout, ave);
                LayoutParams layoutParams = new LayoutParams(-1, -2);
                layoutParams.topMargin = onM;
                linearLayout.setLayoutParams(layoutParams);
                mallWalletUI.onN.addView(linearLayout, layoutParams);
            }
            mallWalletUI.co(mallWalletUI.onP.xfn);
        }
        AppMethodBeat.o(43277);
    }
}
