package com.tencent.mm.plugin.mall.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.protocal.protobuf.biu;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MallFunctionSettingsUI extends WalletBaseUI {
    int cQG;
    private ListView omf;
    private final int omg = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 40);
    private TextView omh;
    private TextView omi;
    private a omj;
    private List<b> omk = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI$2 */
    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Object, com.tencent.mm.ai.a.a<hx>> {
        final /* synthetic */ com.tencent.mm.plugin.mall.a.a omm;

        AnonymousClass2(com.tencent.mm.plugin.mall.a.a aVar) {
            this.omm = aVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(43152);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.MallFunctionSettingsUI", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                ab.i("MicroMsg.MallFunctionSettingsUI", "retcode: %s, retmsg: %s", Integer.valueOf(((hx) aVar.fsy).vKp), ((hx) aVar.fsy).vKq);
                if (((hx) aVar.fsy).vKp != 0) {
                    for (biu biu : this.omm.okJ) {
                        biu.jBT = biu.jBT == 0 ? 1 : 0;
                    }
                    MallFunctionSettingsUI.this.omj.notifyDataSetChanged();
                    m.a(true, ((hx) aVar.fsy).vKp, 0, ((hx) aVar.fsy).vKq).y(MallFunctionSettingsUI.this.mController.ylL, true);
                }
            } else {
                for (biu biu2 : this.omm.okJ) {
                    biu2.jBT = biu2.jBT == 0 ? 1 : 0;
                }
                MallFunctionSettingsUI.this.omj.notifyDataSetChanged();
                m.gi(aVar.errCode, aVar.errType).y(MallFunctionSettingsUI.this.mController.ylL, true);
            }
            AppMethodBeat.o(43152);
            return null;
        }
    }

    class c {
        TextView iDT;
        ViewGroup iMc;
        TextView kEq;
        View lBD;
        CdnImageView ntk;
        MMSwitchBtn omp;
        View omq;

        /* renamed from: com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI$c$1 */
        class AnonymousClass1 implements com.tencent.mm.ui.widget.MMSwitchBtn.a {
            final /* synthetic */ biu omr;

            AnonymousClass1(biu biu) {
                this.omr = biu;
            }

            public final void di(boolean z) {
                AppMethodBeat.i(43158);
                ab.i("MicroMsg.MallFunctionSettingsUI", "click switch: %s, id: %s", Boolean.valueOf(z), this.omr.wMe);
                if (z) {
                    this.omr.jBT = 0;
                } else {
                    this.omr.jBT = 1;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.omr);
                MallFunctionSettingsUI mallFunctionSettingsUI = MallFunctionSettingsUI.this;
                ab.i("MicroMsg.MallFunctionSettingsUI", "do batch function operate");
                com.tencent.mm.plugin.mall.a.a aVar = new com.tencent.mm.plugin.mall.a.a(linkedList, mallFunctionSettingsUI.cQG);
                aVar.acy().b(new AnonymousClass2(aVar));
                AppMethodBeat.o(43158);
            }
        }

        private c() {
        }

        /* synthetic */ c(MallFunctionSettingsUI mallFunctionSettingsUI, byte b) {
            this();
        }
    }

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(MallFunctionSettingsUI mallFunctionSettingsUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(43157);
            b yp = yp(i);
            AppMethodBeat.o(43157);
            return yp;
        }

        public final int getCount() {
            AppMethodBeat.i(43153);
            int size = MallFunctionSettingsUI.this.omk.size();
            AppMethodBeat.o(43153);
            return size;
        }

        private b yp(int i) {
            AppMethodBeat.i(43154);
            b bVar = (b) MallFunctionSettingsUI.this.omk.get(i);
            AppMethodBeat.o(43154);
            return bVar;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(43155);
            int i2 = ((b) MallFunctionSettingsUI.this.omk.get(i)).type;
            AppMethodBeat.o(43155);
            return i2;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(43156);
            if (view == null) {
                View inflate;
                int itemViewType = getItemViewType(i);
                c cVar = new c(MallFunctionSettingsUI.this, (byte) 0);
                if (itemViewType == 1) {
                    inflate = LayoutInflater.from(MallFunctionSettingsUI.this.mController.ylL).inflate(R.layout.abd, viewGroup, false);
                    cVar.ntk = (CdnImageView) inflate.findViewById(R.id.d2p);
                    cVar.iDT = (TextView) inflate.findViewById(R.id.d2q);
                    cVar.kEq = (TextView) inflate.findViewById(R.id.d2r);
                    cVar.omp = (MMSwitchBtn) inflate.findViewById(R.id.d2s);
                    cVar.lBD = inflate.findViewById(R.id.d2u);
                    cVar.omq = inflate.findViewById(R.id.d2t);
                    cVar.iMc = (ViewGroup) inflate;
                    cVar.ntk.setUseSdcardCache(true);
                } else {
                    inflate = LayoutInflater.from(MallFunctionSettingsUI.this.mController.ylL).inflate(R.layout.abe, viewGroup, false);
                    cVar.iDT = (TextView) inflate.findViewById(R.id.d2v);
                    cVar.iMc = (ViewGroup) inflate;
                }
                inflate.setTag(cVar);
                view = inflate;
            }
            b yp = yp(i);
            c cVar2 = (c) view.getTag();
            if (yp.type == 1) {
                biu biu = yp.omn;
                if (biu.wMg != null) {
                    cVar2.ntk.setUrl(biu.wMg.dlY());
                }
                if (biu.wMf != null) {
                    cVar2.iDT.setText(biu.wMf.dlY());
                }
                if (biu.wMh == null || bo.isNullOrNil(biu.wMh.dlY())) {
                    cVar2.kEq.setVisibility(8);
                } else {
                    cVar2.kEq.setText(biu.wMh.dlY());
                    cVar2.kEq.setVisibility(0);
                }
                if (biu.jBT == 0) {
                    cVar2.omp.setCheck(true);
                    cVar2.omp.setEnabled(true);
                    cVar2.iDT.setTextColor(MallFunctionSettingsUI.this.mController.ylL.getResources().getColor(R.color.h6));
                    cVar2.omq.setVisibility(8);
                } else if (biu.jBT == 1) {
                    cVar2.omp.setCheck(false);
                    cVar2.omp.setEnabled(true);
                    cVar2.iDT.setTextColor(MallFunctionSettingsUI.this.mController.ylL.getResources().getColor(R.color.h6));
                    cVar2.omq.setVisibility(8);
                } else if (biu.jBT == 2) {
                    cVar2.omp.setCheck(false);
                    cVar2.omp.setEnabled(false);
                    cVar2.omq.setVisibility(0);
                }
                cVar2.omp.setSwitchListener(new AnonymousClass1(biu));
                LayoutParams layoutParams = (LayoutParams) cVar2.lBD.getLayoutParams();
                if (yp.omo) {
                    layoutParams.leftMargin = 0;
                } else {
                    layoutParams.leftMargin = MallFunctionSettingsUI.this.omg;
                }
                cVar2.lBD.setLayoutParams(layoutParams);
            } else if (yp.type == 0) {
                cVar2.iDT.setText(yp.title);
            }
            AppMethodBeat.o(43156);
            return view;
        }
    }

    static class b {
        biu omn;
        boolean omo;
        String title;
        int type;

        private b() {
            this.omo = false;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallFunctionSettingsUI() {
        AppMethodBeat.i(43159);
        AppMethodBeat.o(43159);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(43160);
        super.onCreate(bundle);
        xE(getResources().getColor(R.color.a69));
        dyb();
        this.cQG = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        ab.i("MicroMsg.MallFunctionSettingsUI", "wallet region: %s", Integer.valueOf(this.cQG));
        initView();
        setMMTitle("");
        ab.i("MicroMsg.MallFunctionSettingsUI", "do get function list");
        new com.tencent.mm.plugin.mall.a.b(this.cQG).acy().b(new com.tencent.mm.vending.c.a<Object, com.tencent.mm.ai.a.a<amd>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(43151);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                ab.i("MicroMsg.MallFunctionSettingsUI", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    MallFunctionSettingsUI.a(MallFunctionSettingsUI.this, (amd) aVar.fsy);
                    MallFunctionSettingsUI.a(MallFunctionSettingsUI.this, ((amd) aVar.fsy).wrh);
                    MallFunctionSettingsUI.this.omj.notifyDataSetChanged();
                } else {
                    m.a(true, aVar.errCode, 0, aVar.aIm).y(MallFunctionSettingsUI.this.mController.ylL, true);
                }
                AppMethodBeat.o(43151);
                return null;
            }
        });
        AppMethodBeat.o(43160);
    }

    public final void initView() {
        AppMethodBeat.i(43161);
        this.omf = (ListView) findViewById(R.id.d2w);
        this.omj = new a(this, (byte) 0);
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, R.layout.abc, null);
        this.omf.addHeaderView(viewGroup, null, false);
        LinearLayout linearLayout = new LinearLayout(this.mController.ylL);
        linearLayout.setMinimumHeight(com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 80));
        this.omf.addFooterView(linearLayout, null, false);
        this.omf.setAdapter(this.omj);
        this.omh = (TextView) viewGroup.findViewById(R.id.d2m);
        this.omi = (TextView) viewGroup.findViewById(R.id.d2n);
        AppMethodBeat.o(43161);
    }

    public void onDestroy() {
        AppMethodBeat.i(43162);
        super.onDestroy();
        AppMethodBeat.o(43162);
    }

    public final boolean c(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.abf;
    }
}
