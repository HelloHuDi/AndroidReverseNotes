package com.tencent.p177mm.plugin.mall.p451ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.plugin.mall.p450a.C46067i;
import com.tencent.p177mm.plugin.mall.p450a.C46067i.C3432a;
import com.tencent.p177mm.plugin.mall.p451ui.MallWalletSectionCellView.C124851;
import com.tencent.p177mm.plugin.mall.p451ui.MallWalletSectionCellView.C124862;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.utils.C35520e;
import com.tencent.p177mm.plugin.wallet_core.utils.C35520e.C143342;
import com.tencent.p177mm.plugin.wallet_core.utils.C35520e.C143353;
import com.tencent.p177mm.plugin.wallet_core.utils.C35520e.C355165;
import com.tencent.p177mm.plugin.wallet_core.utils.C35520e.C355176;
import com.tencent.p177mm.plugin.wallet_core.utils.C35520e.C35519a;
import com.tencent.p177mm.plugin.wallet_core.utils.C35520e.C355227;
import com.tencent.p177mm.plugin.wallet_core.utils.C35520e.C44694;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.C30232ux;
import com.tencent.p177mm.protocal.protobuf.C40547mt;
import com.tencent.p177mm.protocal.protobuf.C46566ms;
import com.tencent.p177mm.protocal.protobuf.ave;
import com.tencent.p177mm.protocal.protobuf.bdq;
import com.tencent.p177mm.protocal.protobuf.bdr;
import com.tencent.p177mm.protocal.protobuf.bif;
import com.tencent.p177mm.protocal.protobuf.bol;
import com.tencent.p177mm.protocal.protobuf.btq;
import com.tencent.p177mm.protocal.protobuf.btr;
import com.tencent.p177mm.protocal.protobuf.cfy;
import com.tencent.p177mm.protocal.protobuf.cgd;
import com.tencent.p177mm.protocal.protobuf.cge;
import com.tencent.p177mm.protocal.protobuf.cgv;
import com.tencent.p177mm.protocal.protobuf.cnv;
import com.tencent.p177mm.protocal.protobuf.cnx;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.mall.ui.MallWalletUI */
public class MallWalletUI extends WalletBaseUI {
    private static final int onM = C1338a.fromDPToPix(C4996ah.getContext(), 8);
    private Dialog msu;
    private boolean ohG = false;
    private LinearLayout onN;
    private LinearLayout onO;
    private cge onP;
    private Dialog onQ;
    private C3432a onR;

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallWalletUI$2 */
    class C34422 implements C35519a {
        C34422() {
        }

        /* renamed from: a */
        public final void mo7894a(btr btr) {
            AppMethodBeat.m2504i(43266);
            C7060h.pYm.mo8381e(16502, Integer.valueOf(1));
            AppMethodBeat.m2505o(43266);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallWalletUI$3 */
    class C212673 implements C35519a {
        C212673() {
        }

        /* renamed from: a */
        public final void mo7894a(btr btr) {
            int i;
            AppMethodBeat.m2504i(43267);
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
            C7060h.pYm.mo8381e(16502, Integer.valueOf(2), str, Integer.valueOf(i));
            AppMethodBeat.m2505o(43267);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallWalletUI$1 */
    class C345201 implements C3432a {
        C345201() {
        }

        /* renamed from: a */
        public final void mo7872a(cge cge) {
            AppMethodBeat.m2504i(43264);
            C4990ab.m7417i("MicroMsg.MallWalletUI", "cache callback: %s", cge);
            if (MallWalletUI.this.msu != null) {
                MallWalletUI.this.msu.dismiss();
                MallWalletUI.this.msu = null;
            }
            MallWalletUI.this.onP = cge;
            MallWalletUI.m67102c(MallWalletUI.this);
            AppMethodBeat.m2505o(43264);
        }

        /* renamed from: b */
        public final void mo7873b(final bol bol) {
            AppMethodBeat.m2504i(43265);
            C4990ab.m7417i("MicroMsg.MallWalletUI", "net callback: %s", bol);
            if (MallWalletUI.this.msu != null) {
                MallWalletUI.this.msu.dismiss();
                MallWalletUI.this.msu = null;
            }
            if (bol != null) {
                if (bol.wRp != null) {
                    MallWalletUI.this.onP = bol.wRp;
                    MallWalletUI.m67102c(MallWalletUI.this);
                }
                if (bol.vCP != null && bol.vCP.type == 13) {
                    MallWalletUI.this.runOnUiThread(new Runnable() {

                        /* renamed from: com.tencent.mm.plugin.mall.ui.MallWalletUI$1$1$1 */
                        class C34411 implements OnClickListener {
                            C34411() {
                            }

                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(43262);
                                MallWalletUI.this.onQ.dismiss();
                                C7060h.pYm.mo8381e(16500, Integer.valueOf(5));
                                AppMethodBeat.m2505o(43262);
                            }
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:64:0x02b4  */
                        /* JADX WARNING: Removed duplicated region for block: B:111:0x00f3 A:{SYNTHETIC} */
                        /* JADX WARNING: Removed duplicated region for block: B:69:0x02ca  */
                        /* JADX WARNING: Removed duplicated region for block: B:49:0x01b2  */
                        /* JADX WARNING: Removed duplicated region for block: B:64:0x02b4  */
                        /* JADX WARNING: Removed duplicated region for block: B:69:0x02ca  */
                        /* JADX WARNING: Removed duplicated region for block: B:111:0x00f3 A:{SYNTHETIC} */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            AppMethodBeat.m2504i(43263);
                            if (!((MallWalletUI.this.onQ != null && MallWalletUI.this.onQ.isShowing()) || MallWalletUI.this.isFinishing() || MallWalletUI.this.ohG)) {
                                Dialog dialog;
                                MallWalletUI mallWalletUI = MallWalletUI.this;
                                Context context = MallWalletUI.this;
                                C30232ux c30232ux = bol.vCP.wVG;
                                C34411 c34411 = new C34411();
                                if (c30232ux == null) {
                                    dialog = null;
                                } else {
                                    Dialog dialog2 = new Dialog(context, C25738R.style.f11415zt);
                                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(2130971086, null, false);
                                    if (!(c30232ux.wcs == null || c30232ux.wcs.wHt == null)) {
                                        CdnImageView cdnImageView = (CdnImageView) viewGroup.findViewById(2131828768);
                                        bdr bdr = c30232ux.wcs.wHt;
                                        if (bdr.type == 1) {
                                            C35520e.m58297a(cdnImageView, bdr.vQK, C25738R.drawable.b73, true);
                                            int b = C4977b.m7371b(context, 50.0f);
                                            C5046bo.m7582n(cdnImageView, b, b, b, b);
                                            cdnImageView.setOnClickListener(new C143342(dialog2));
                                        }
                                    }
                                    LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(2131828769);
                                    if (!(c30232ux.wcu == null || c30232ux.wcu.isEmpty())) {
                                        Iterator it = c30232ux.wcu.iterator();
                                        while (it.hasNext()) {
                                            cnv cnv = (cnv) it.next();
                                            MarginLayoutParams layoutParams = new LayoutParams(-2, -2);
                                            View textView;
                                            if (cnv.type == 1) {
                                                textView = new TextView(linearLayout.getContext());
                                                C35520e.m58294a((TextView) textView, cnv.wbo, null);
                                                C35520e.m58291a(textView, layoutParams, cnv.xlr);
                                                linearLayout.addView(textView, layoutParams);
                                            } else if (cnv.type == 11) {
                                                textView = new CdnImageView(linearLayout.getContext());
                                                int fromDPToPix = C1338a.fromDPToPix(linearLayout.getContext(), 64);
                                                C35520e.m58297a(textView, cnv.vQK, -1, false);
                                                textView.setMinimumWidth(fromDPToPix);
                                                textView.setMinimumHeight(fromDPToPix);
                                                C35520e.m58291a(textView, layoutParams, cnv.xlr);
                                                linearLayout.addView(textView, layoutParams);
                                            } else if (cnv.type == 20) {
                                                C40547mt c40547mt = cnv.xlq;
                                                cnx cnx = cnv.xlr;
                                                if (c40547mt != null) {
                                                    linearLayout.setGravity(1);
                                                    if (c40547mt.vQM != null) {
                                                        View mMSwitchBtn;
                                                        TextView textView2;
                                                        Context context2;
                                                        C46566ms c46566ms;
                                                        View button;
                                                        LayoutParams layoutParams2;
                                                        LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
                                                        linearLayout2.setGravity(48);
                                                        linearLayout2.setOrientation(0);
                                                        Context context3 = linearLayout.getContext();
                                                        cfy cfy = c40547mt.vQM.wbn;
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
                                                                mMSwitchBtn.setBackgroundResource(C25738R.drawable.f6884ub);
                                                                if (cfy.wRi == 0) {
                                                                    mMSwitchBtn.setChecked(false);
                                                                } else if (cfy.wRi == 1) {
                                                                    mMSwitchBtn.setChecked(true);
                                                                } else {
                                                                    mMSwitchBtn.setEnabled(false);
                                                                }
                                                            }
                                                            textView2 = new TextView(linearLayout.getContext());
                                                            C35520e.m58294a(textView2, c40547mt.vQM.wbo, null);
                                                            context2 = linearLayout.getContext();
                                                            c46566ms = c40547mt.vQN;
                                                            if (c46566ms != null) {
                                                                if (c46566ms.vQJ == 1) {
                                                                    button = new Button(context2);
                                                                    button.setTextSize(0, (float) C1338a.m2856al(context2, C25738R.dimen.f9945l2));
                                                                    button.setTextColor(context2.getResources().getColor(C25738R.color.a8m));
                                                                    button.setBackgroundResource(C25738R.drawable.f6484fp);
                                                                    button.setGravity(17);
                                                                    button.setAllCaps(true);
                                                                    button.setPadding(C1338a.m2856al(context2, C25738R.dimen.f10005n7), 0, C1338a.m2856al(context2, C25738R.dimen.f10005n7), 0);
                                                                    button.setWidth(C1338a.fromDPToPix(context2, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE));
                                                                    button.setHeight(C1338a.fromDPToPix(context2, 40));
                                                                    if (c46566ms.state == 1) {
                                                                        button.setEnabled(true);
                                                                    } else {
                                                                        button.setEnabled(false);
                                                                    }
                                                                    button.setText(c46566ms.text);
                                                                    if (c46566ms.kdC == 1) {
                                                                        button.setOnClickListener(new C355165(context2, c46566ms, c34411));
                                                                    }
                                                                } else if (c46566ms.vQJ == 0) {
                                                                    CdnImageView button2 = new CdnImageView(context2);
                                                                    C35520e.m58295a(button2, c46566ms.vQK);
                                                                    if (c46566ms.state == 1) {
                                                                        button2.setEnabled(true);
                                                                    } else {
                                                                        button2.setEnabled(false);
                                                                    }
                                                                    if (c46566ms.kdC == 1) {
                                                                        button2.setOnClickListener(new C355176(context2, c46566ms, c34411));
                                                                    }
                                                                }
                                                                layoutParams2 = new LayoutParams(-2, -2);
                                                                if (!(cnx == null || cnx.xlt == null)) {
                                                                    layoutParams2.topMargin = C1338a.fromDPToPix(C4996ah.getContext(), (int) cnx.xlt.top);
                                                                }
                                                                layoutParams2.bottomMargin = C1338a.fromDPToPix(C4996ah.getContext(), 32);
                                                                linearLayout.addView(linearLayout2, layoutParams2);
                                                                if (mMSwitchBtn != null) {
                                                                    linearLayout2.addView(mMSwitchBtn);
                                                                    if (mMSwitchBtn instanceof MMSwitchBtn) {
                                                                        ((MMSwitchBtn) mMSwitchBtn).setSwitchListener(new C143353(button2));
                                                                    } else if (mMSwitchBtn instanceof CheckBox) {
                                                                        ((CheckBox) mMSwitchBtn).setOnCheckedChangeListener(new C44694(button2));
                                                                    }
                                                                }
                                                                linearLayout2.addView(textView2);
                                                                if (button2 != null) {
                                                                    LayoutParams layoutParams3 = new LayoutParams(-2, -2);
                                                                    if (!(cnx == null || cnx.xlt == null)) {
                                                                        layoutParams3.bottomMargin = C1338a.fromDPToPix(C4996ah.getContext(), (int) cnx.xlt.bottom);
                                                                    }
                                                                    linearLayout.addView(button2, layoutParams3);
                                                                }
                                                            }
                                                            button2 = null;
                                                            layoutParams2 = new LayoutParams(-2, -2);
                                                            layoutParams2.topMargin = C1338a.fromDPToPix(C4996ah.getContext(), (int) cnx.xlt.top);
                                                            layoutParams2.bottomMargin = C1338a.fromDPToPix(C4996ah.getContext(), 32);
                                                            linearLayout.addView(linearLayout2, layoutParams2);
                                                            if (mMSwitchBtn != null) {
                                                            }
                                                            linearLayout2.addView(textView2);
                                                            if (button2 != null) {
                                                            }
                                                        }
                                                        mMSwitchBtn = null;
                                                        textView2 = new TextView(linearLayout.getContext());
                                                        C35520e.m58294a(textView2, c40547mt.vQM.wbo, null);
                                                        context2 = linearLayout.getContext();
                                                        c46566ms = c40547mt.vQN;
                                                        if (c46566ms != null) {
                                                        }
                                                        button2 = null;
                                                        layoutParams2 = new LayoutParams(-2, -2);
                                                        layoutParams2.topMargin = C1338a.fromDPToPix(C4996ah.getContext(), (int) cnx.xlt.top);
                                                        layoutParams2.bottomMargin = C1338a.fromDPToPix(C4996ah.getContext(), 32);
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
                            AppMethodBeat.m2505o(43263);
                        }
                    });
                }
            }
            AppMethodBeat.m2505o(43265);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static {
        AppMethodBeat.m2504i(43278);
        AppMethodBeat.m2505o(43278);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130970066;
    }

    public final void initView() {
        AppMethodBeat.m2504i(43269);
        this.onN = (LinearLayout) findViewById(2131825910);
        this.onO = (LinearLayout) findViewById(2131825911);
        AppMethodBeat.m2505o(43269);
    }

    public void onResume() {
        AppMethodBeat.m2504i(43270);
        super.onResume();
        AppMethodBeat.m2505o(43270);
    }

    public void onPause() {
        AppMethodBeat.m2504i(43271);
        super.onPause();
        AppMethodBeat.m2505o(43271);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(43272);
        super.onDestroy();
        C46067i.m85826a(this.onR);
        AppMethodBeat.m2505o(43272);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(43273);
        C4990ab.m7417i("MicroMsg.MallWalletUI", "requestCode: %s, resultCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 65281 || i == 65286) {
            bNt();
            AppMethodBeat.m2505o(43273);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(43273);
    }

    private void bNt() {
        AppMethodBeat.m2504i(43274);
        C4990ab.m7416i("MicroMsg.MallWalletUI", "do query wechat wallet");
        this.msu = C30901g.m49318b(this, false, null);
        C46067i.m85827a(this.onR, true);
        AppMethodBeat.m2505o(43274);
    }

    /* renamed from: co */
    private void m67103co(List<cgv> list) {
        AppMethodBeat.m2504i(43275);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(43275);
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
                C35520e.m58294a(textView, cgv, new C212673());
                LayoutParams layoutParams = new LayoutParams(-2, -2);
                if (i2 != 0) {
                    layoutParams.topMargin = C1338a.fromDPToPix(this, 8);
                }
                this.onO.addView(textView, layoutParams);
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(43275);
                return;
            }
        }
    }

    /* renamed from: a */
    private void m67100a(LinearLayout linearLayout, ave ave) {
        AppMethodBeat.m2504i(43276);
        if (ave.wzb != null) {
            int size = ave.wzb.size();
            JSONObject jSONObject = null;
            C1720g.m3537RQ();
            String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_New_MALL_UI_ITEM_REDDOT_CONFIG_STRING_SYNC, (Object) "");
            if (!C5046bo.isNullOrNil(str)) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.MallWalletUI", e, "", new Object[0]);
                }
            }
            C4990ab.m7417i("MicroMsg.MallWalletUI", "cell size: %s", Integer.valueOf(size));
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
                C35520e.m58295a(mallWalletSectionCellView.onz, cgd.xff);
                if (cgd.xfi == null || C5046bo.isNullOrNil(cgd.xfi.url)) {
                    mallWalletSectionCellView.onC.setImageResource(C25738R.drawable.bkf);
                } else {
                    C35520e.m58297a(mallWalletSectionCellView.onC, cgd.xfi, C25738R.drawable.bkf, true);
                }
                if (cgd.xfg == null || cgd.xfg.size() <= 0) {
                    mallWalletSectionCellView.onA.setText("");
                } else {
                    C35520e.m58294a(mallWalletSectionCellView.onA, (cgv) cgd.xfg.get(0), null);
                }
                if (cgd.xfk != null) {
                    View view = mallWalletSectionCellView.onI;
                    btq btq = cgd.xfk;
                    if (!(btq == null || view == null)) {
                        C35520e.m58294a((TextView) view, btq.wbo, null);
                        C35520e.m58292a(view, btq.wVz);
                        i2 = (int) btq.wVB;
                        if ((btq.wVB & -16777216) == 0) {
                            i2 = (int) (btq.wVB | -16777216);
                        }
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setShape(0);
                        if (btq.wVA > 0.0f) {
                            gradientDrawable.setCornerRadius((float) C1338a.fromDPToPix(view.getContext(), (int) btq.wVA));
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
                    C35520e.m58294a(mallWalletSectionCellView.onB, (cgv) cgd.xfh.get(0), null);
                }
                if (cgd.xfh == null || cgd.xfh.size() <= 1) {
                    mallWalletSectionCellView.onD.setVisibility(8);
                } else {
                    C35520e.m58294a(mallWalletSectionCellView.onD, (cgv) cgd.xfh.get(1), null);
                }
                if (cgd.xfj == null || jSONObject == null) {
                    mallWalletSectionCellView.bNs();
                } else {
                    Object obj2 = jSONObject.optInt(cgd.xfj.wpJ, 0) == 1 ? 1 : null;
                    long optLong = jSONObject.optLong(String.format("%s_expiretime", new Object[]{cgd.xfj.wpJ}), 0);
                    if (optLong > 0 && System.currentTimeMillis() > optLong) {
                        C4990ab.m7417i("MicroMsg.MallWalletSectionCellView", "red dot expired: %s, %s", cgd.xfj.wpJ, Long.valueOf(optLong));
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
                        mallWalletSectionCellView.onG.setText(C35520e.m58289a(mallWalletSectionCellView.getContext(), cgd.xfj.wbo));
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
                        i2 = mallWalletSectionCellView.mo46449aN(bif.left);
                    }
                    if (bif.right > 0.0f) {
                        i4 = mallWalletSectionCellView.mo46449aN(bif.right);
                    }
                    if (bif.top > 0.0f) {
                        i3 = mallWalletSectionCellView.mo46449aN(bif.top);
                    }
                    if (bif.bottom > 0.0f) {
                        i5 = mallWalletSectionCellView.mo46449aN(bif.bottom);
                    }
                    mallWalletSectionCellView.onH.setPadding(i2, i3, i4, i5);
                }
                if (obj != null) {
                    mallWalletSectionCellView.onA.post(new C124851());
                } else {
                    mallWalletSectionCellView.kiH.setVisibility(8);
                }
                if (cgd.vCP != null) {
                    mallWalletSectionCellView.setOnClickListener(new C124862(cgd, jSONObject));
                }
                linearLayout.addView(mallWalletSectionCellView);
                i++;
            }
        }
        AppMethodBeat.m2505o(43276);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(43268);
        this.yll = true;
        super.onCreate(bundle);
        mo17446xE(Color.parseColor("#f7f7f7"));
        dyb();
        setMMTitle("");
        initView();
        this.onR = new C345201();
        bNt();
        AppMethodBeat.m2505o(43268);
    }

    /* renamed from: c */
    static /* synthetic */ void m67102c(MallWalletUI mallWalletUI) {
        AppMethodBeat.m2504i(43277);
        if (mallWalletUI.onP != null) {
            bdq bdq = mallWalletUI.onP.xfl;
            if (bdq != null) {
                mallWalletUI.mo17368M(C35520e.m58288a((Context) mallWalletUI, bdq.vCN, null));
                bdr bdr = bdq.wHs;
                C34422 c34422 = new C34422();
                if (bdr.type == 2 && bdr.wbo != null) {
                    mallWalletUI.addTextOptionMenu(0, C35520e.m58289a((Context) mallWalletUI, bdr.wbo), new C355227(bdr, c34422, mallWalletUI));
                }
            }
            C4990ab.m7417i("MicroMsg.MallWalletUI", "section size: %s", mallWalletUI.onP.xfm);
            mallWalletUI.onN.removeAllViews();
            Iterator it = mallWalletUI.onP.xfm.iterator();
            while (it.hasNext()) {
                ave ave = (ave) it.next();
                LinearLayout linearLayout = new LinearLayout(mallWalletUI);
                linearLayout.setOrientation(1);
                mallWalletUI.m67100a(linearLayout, ave);
                LayoutParams layoutParams = new LayoutParams(-1, -2);
                layoutParams.topMargin = onM;
                linearLayout.setLayoutParams(layoutParams);
                mallWalletUI.onN.addView(linearLayout, layoutParams);
            }
            mallWalletUI.m67103co(mallWalletUI.onP.xfn);
        }
        AppMethodBeat.m2505o(43277);
    }
}
