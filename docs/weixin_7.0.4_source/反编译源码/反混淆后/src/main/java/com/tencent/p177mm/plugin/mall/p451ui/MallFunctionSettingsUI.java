package com.tencent.p177mm.plugin.mall.p451ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.plugin.mall.p450a.C41294a;
import com.tencent.p177mm.plugin.mall.p450a.C46066b;
import com.tencent.p177mm.plugin.wallet_core.model.C29634m;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.C30190hx;
import com.tencent.p177mm.protocal.protobuf.amd;
import com.tencent.p177mm.protocal.protobuf.biu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI */
public class MallFunctionSettingsUI extends WalletBaseUI {
    int cQG;
    private ListView omf;
    private final int omg = C1338a.fromDPToPix(C4996ah.getContext(), 40);
    private TextView omh;
    private TextView omi;
    private C34510a omj;
    private List<C34511b> omk = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI$1 */
    class C284691 implements C5681a<Object, C37441a<amd>> {
        C284691() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(43151);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.MallFunctionSettingsUI", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                MallFunctionSettingsUI.m56570a(MallFunctionSettingsUI.this, (amd) c37441a.fsy);
                MallFunctionSettingsUI.m56571a(MallFunctionSettingsUI.this, ((amd) c37441a.fsy).wrh);
                MallFunctionSettingsUI.this.omj.notifyDataSetChanged();
            } else {
                C29634m.m47002a(true, c37441a.errCode, 0, c37441a.aIm).mo47880y(MallFunctionSettingsUI.this.mController.ylL, true);
            }
            AppMethodBeat.m2505o(43151);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI$2 */
    class C284702 implements C5681a<Object, C37441a<C30190hx>> {
        final /* synthetic */ C41294a omm;

        C284702(C41294a c41294a) {
            this.omm = c41294a;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(43152);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.MallFunctionSettingsUI", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C4990ab.m7417i("MicroMsg.MallFunctionSettingsUI", "retcode: %s, retmsg: %s", Integer.valueOf(((C30190hx) c37441a.fsy).vKp), ((C30190hx) c37441a.fsy).vKq);
                if (((C30190hx) c37441a.fsy).vKp != 0) {
                    for (biu biu : this.omm.okJ) {
                        biu.jBT = biu.jBT == 0 ? 1 : 0;
                    }
                    MallFunctionSettingsUI.this.omj.notifyDataSetChanged();
                    C29634m.m47002a(true, ((C30190hx) c37441a.fsy).vKp, 0, ((C30190hx) c37441a.fsy).vKq).mo47880y(MallFunctionSettingsUI.this.mController.ylL, true);
                }
            } else {
                for (biu biu2 : this.omm.okJ) {
                    biu2.jBT = biu2.jBT == 0 ? 1 : 0;
                }
                MallFunctionSettingsUI.this.omj.notifyDataSetChanged();
                C29634m.m47003gi(c37441a.errCode, c37441a.errType).mo47880y(MallFunctionSettingsUI.this.mController.ylL, true);
            }
            AppMethodBeat.m2505o(43152);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI$c */
    class C28471c {
        TextView iDT;
        ViewGroup iMc;
        TextView kEq;
        View lBD;
        CdnImageView ntk;
        MMSwitchBtn omp;
        View omq;

        /* renamed from: com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI$c$1 */
        class C284721 implements C30795a {
            final /* synthetic */ biu omr;

            C284721(biu biu) {
                this.omr = biu;
            }

            /* renamed from: di */
            public final void mo6646di(boolean z) {
                AppMethodBeat.m2504i(43158);
                C4990ab.m7417i("MicroMsg.MallFunctionSettingsUI", "click switch: %s, id: %s", Boolean.valueOf(z), this.omr.wMe);
                if (z) {
                    this.omr.jBT = 0;
                } else {
                    this.omr.jBT = 1;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.omr);
                MallFunctionSettingsUI mallFunctionSettingsUI = MallFunctionSettingsUI.this;
                C4990ab.m7416i("MicroMsg.MallFunctionSettingsUI", "do batch function operate");
                C41294a c41294a = new C41294a(linkedList, mallFunctionSettingsUI.cQG);
                c41294a.acy().mo60487b(new C284702(c41294a));
                AppMethodBeat.m2505o(43158);
            }
        }

        private C28471c() {
        }

        /* synthetic */ C28471c(MallFunctionSettingsUI mallFunctionSettingsUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI$a */
    class C34510a extends BaseAdapter {
        private C34510a() {
        }

        /* synthetic */ C34510a(MallFunctionSettingsUI mallFunctionSettingsUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(43157);
            C34511b yp = m56575yp(i);
            AppMethodBeat.m2505o(43157);
            return yp;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(43153);
            int size = MallFunctionSettingsUI.this.omk.size();
            AppMethodBeat.m2505o(43153);
            return size;
        }

        /* renamed from: yp */
        private C34511b m56575yp(int i) {
            AppMethodBeat.m2504i(43154);
            C34511b c34511b = (C34511b) MallFunctionSettingsUI.this.omk.get(i);
            AppMethodBeat.m2505o(43154);
            return c34511b;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(43155);
            int i2 = ((C34511b) MallFunctionSettingsUI.this.omk.get(i)).type;
            AppMethodBeat.m2505o(43155);
            return i2;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(43156);
            if (view == null) {
                View inflate;
                int itemViewType = getItemViewType(i);
                C28471c c28471c = new C28471c(MallFunctionSettingsUI.this, (byte) 0);
                if (itemViewType == 1) {
                    inflate = LayoutInflater.from(MallFunctionSettingsUI.this.mController.ylL).inflate(2130970026, viewGroup, false);
                    c28471c.ntk = (CdnImageView) inflate.findViewById(2131825749);
                    c28471c.iDT = (TextView) inflate.findViewById(2131825750);
                    c28471c.kEq = (TextView) inflate.findViewById(2131825751);
                    c28471c.omp = (MMSwitchBtn) inflate.findViewById(2131825752);
                    c28471c.lBD = inflate.findViewById(2131825754);
                    c28471c.omq = inflate.findViewById(2131825753);
                    c28471c.iMc = (ViewGroup) inflate;
                    c28471c.ntk.setUseSdcardCache(true);
                } else {
                    inflate = LayoutInflater.from(MallFunctionSettingsUI.this.mController.ylL).inflate(2130970027, viewGroup, false);
                    c28471c.iDT = (TextView) inflate.findViewById(2131825755);
                    c28471c.iMc = (ViewGroup) inflate;
                }
                inflate.setTag(c28471c);
                view = inflate;
            }
            C34511b yp = m56575yp(i);
            C28471c c28471c2 = (C28471c) view.getTag();
            if (yp.type == 1) {
                biu biu = yp.omn;
                if (biu.wMg != null) {
                    c28471c2.ntk.setUrl(biu.wMg.dlY());
                }
                if (biu.wMf != null) {
                    c28471c2.iDT.setText(biu.wMf.dlY());
                }
                if (biu.wMh == null || C5046bo.isNullOrNil(biu.wMh.dlY())) {
                    c28471c2.kEq.setVisibility(8);
                } else {
                    c28471c2.kEq.setText(biu.wMh.dlY());
                    c28471c2.kEq.setVisibility(0);
                }
                if (biu.jBT == 0) {
                    c28471c2.omp.setCheck(true);
                    c28471c2.omp.setEnabled(true);
                    c28471c2.iDT.setTextColor(MallFunctionSettingsUI.this.mController.ylL.getResources().getColor(C25738R.color.f11784h6));
                    c28471c2.omq.setVisibility(8);
                } else if (biu.jBT == 1) {
                    c28471c2.omp.setCheck(false);
                    c28471c2.omp.setEnabled(true);
                    c28471c2.iDT.setTextColor(MallFunctionSettingsUI.this.mController.ylL.getResources().getColor(C25738R.color.f11784h6));
                    c28471c2.omq.setVisibility(8);
                } else if (biu.jBT == 2) {
                    c28471c2.omp.setCheck(false);
                    c28471c2.omp.setEnabled(false);
                    c28471c2.omq.setVisibility(0);
                }
                c28471c2.omp.setSwitchListener(new C284721(biu));
                LayoutParams layoutParams = (LayoutParams) c28471c2.lBD.getLayoutParams();
                if (yp.omo) {
                    layoutParams.leftMargin = 0;
                } else {
                    layoutParams.leftMargin = MallFunctionSettingsUI.this.omg;
                }
                c28471c2.lBD.setLayoutParams(layoutParams);
            } else if (yp.type == 0) {
                c28471c2.iDT.setText(yp.title);
            }
            AppMethodBeat.m2505o(43156);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI$b */
    static class C34511b {
        biu omn;
        boolean omo;
        String title;
        int type;

        private C34511b() {
            this.omo = false;
        }

        /* synthetic */ C34511b(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MallFunctionSettingsUI() {
        AppMethodBeat.m2504i(43159);
        AppMethodBeat.m2505o(43159);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(43160);
        super.onCreate(bundle);
        mo17446xE(getResources().getColor(C25738R.color.a69));
        dyb();
        this.cQG = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        C4990ab.m7417i("MicroMsg.MallFunctionSettingsUI", "wallet region: %s", Integer.valueOf(this.cQG));
        initView();
        setMMTitle("");
        C4990ab.m7416i("MicroMsg.MallFunctionSettingsUI", "do get function list");
        new C46066b(this.cQG).acy().mo60487b(new C284691());
        AppMethodBeat.m2505o(43160);
    }

    public final void initView() {
        AppMethodBeat.m2504i(43161);
        this.omf = (ListView) findViewById(2131825756);
        this.omj = new C34510a(this, (byte) 0);
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, 2130970025, null);
        this.omf.addHeaderView(viewGroup, null, false);
        LinearLayout linearLayout = new LinearLayout(this.mController.ylL);
        linearLayout.setMinimumHeight(C1338a.fromDPToPix(this.mController.ylL, 80));
        this.omf.addFooterView(linearLayout, null, false);
        this.omf.setAdapter(this.omj);
        this.omh = (TextView) viewGroup.findViewById(2131825746);
        this.omi = (TextView) viewGroup.findViewById(2131825747);
        AppMethodBeat.m2505o(43161);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(43162);
        super.onDestroy();
        AppMethodBeat.m2505o(43162);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130970028;
    }
}
