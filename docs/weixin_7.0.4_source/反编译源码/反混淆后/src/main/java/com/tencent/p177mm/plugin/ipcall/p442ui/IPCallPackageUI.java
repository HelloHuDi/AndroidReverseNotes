package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.ipcall.p438a.p441e.C21079f;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C12252j;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C34371e;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.aqm;
import com.tencent.p177mm.protocal.protobuf.crx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI */
public class IPCallPackageUI extends MMActivity implements C1202f {
    private ListView nDI = null;
    private TextView nDJ = null;
    private ProgressDialog nDK = null;
    private ProgressDialog nDL = null;
    private C3311a nDM = null;
    private C34371e nDN = null;
    private C12252j nDO = null;
    private C21079f nDP = new C21079f();

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI$a */
    static class C3311a extends BaseAdapter {
        private IPCallPackageUI nDR = null;
        List<crx> ngC = null;

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI$a$1 */
        class C33121 implements OnClickListener {

            /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI$a$1$2 */
            class C33142 implements DialogInterface.OnClickListener {
                C33142() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(22225);
                    C21079f b = C3311a.this.nDR.nDP;
                    b.nyU++;
                    C3311a.this.nDR.nDP.finish();
                    AppMethodBeat.m2505o(22225);
                }
            }

            C33121() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(22226);
                final crx crx = (crx) C3311a.this.getItem(((Integer) view.getTag()).intValue());
                if (crx == null || C5046bo.isNullOrNil(crx.ProductID)) {
                    C4990ab.m7412e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
                    AppMethodBeat.m2505o(22226);
                    return;
                }
                C3311a.this.nDR.nDP.start();
                C21079f b = C3311a.this.nDR.nDP;
                b.nyS++;
                C3311a.this.nDR.nDP.nyW = crx.ProductID;
                C30379h.m48445a(C3311a.this.nDR, C3311a.this.nDR.getString(C25738R.string.cj4, new Object[]{crx.wOs, crx.Title}), C3311a.this.nDR.getString(C25738R.string.cj5), C3311a.this.nDR.getString(C25738R.string.cj2), C3311a.this.nDR.getString(C25738R.string.cj3), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(22224);
                        C21079f b = C3311a.this.nDR.nDP;
                        b.nyT++;
                        IPCallPackageUI.m32454a(C3311a.this.nDR, crx.ProductID);
                        AppMethodBeat.m2505o(22224);
                    }
                }, new C33142());
                AppMethodBeat.m2505o(22226);
            }
        }

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI$a$a */
        class C3315a {
            TextView gtb;
            TextView hrg;
            CdnImageView nDV;
            TextView nDW;
            TextView nDX;
            Button nDY;

            private C3315a() {
            }

            /* synthetic */ C3315a(C3311a c3311a, byte b) {
                this();
            }
        }

        public C3311a(IPCallPackageUI iPCallPackageUI) {
            this.nDR = iPCallPackageUI;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(22227);
            if (this.ngC == null) {
                AppMethodBeat.m2505o(22227);
                return 0;
            }
            int size = this.ngC.size();
            AppMethodBeat.m2505o(22227);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(22228);
            if (this.ngC != null) {
                Object obj = this.ngC.get(i);
                AppMethodBeat.m2505o(22228);
                return obj;
            }
            AppMethodBeat.m2505o(22228);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C3315a c3315a;
            AppMethodBeat.m2504i(22229);
            if (view == null) {
                view = ((LayoutInflater) this.nDR.getSystemService("layout_inflater")).inflate(2130969902, viewGroup, false);
                c3315a = new C3315a(this, (byte) 0);
                c3315a.nDV = (CdnImageView) view.findViewById(2131825171);
                c3315a.gtb = (TextView) view.findViewById(2131825172);
                c3315a.nDW = (TextView) view.findViewById(2131825177);
                c3315a.nDX = (TextView) view.findViewById(2131825178);
                c3315a.hrg = (TextView) view.findViewById(2131825053);
                c3315a.nDY = (Button) view.findViewById(2131825175);
                view.setTag(c3315a);
            } else {
                c3315a = (C3315a) view.getTag();
            }
            crx crx = (crx) getItem(i);
            if (crx == null) {
                AppMethodBeat.m2505o(22229);
            } else {
                c3315a.gtb.setText(crx.Title);
                c3315a.nDW.setText(crx.wOs);
                c3315a.hrg.setText(crx.Desc);
                c3315a.nDX.setText(crx.nzz);
                c3315a.nDV.setVisibility(0);
                c3315a.nDV.setUrl(crx.xpy);
                if (crx.vEq == 0) {
                    c3315a.nDY.setEnabled(true);
                } else {
                    c3315a.nDY.setEnabled(false);
                }
                c3315a.nDY.setTag(Integer.valueOf(i));
                c3315a.nDY.setOnClickListener(new C33121());
                AppMethodBeat.m2505o(22229);
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI$4 */
    class C122764 implements DialogInterface.OnClickListener {
        C122764() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22222);
            C21079f b = IPCallPackageUI.this.nDP;
            b.nyX++;
            IPCallPackageUI.this.nDP.finish();
            Intent intent = new Intent();
            intent.setClass(IPCallPackageUI.this.mController.ylL, IPCallRechargeUI.class);
            IPCallPackageUI.this.startActivity(intent);
            IPCallPackageUI.this.finish();
            AppMethodBeat.m2505o(22222);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI$5 */
    class C211225 implements DialogInterface.OnClickListener {
        C211225() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22223);
            C21079f b = IPCallPackageUI.this.nDP;
            b.nyY++;
            IPCallPackageUI.this.nDP.finish();
            AppMethodBeat.m2505o(22223);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI$2 */
    class C211232 implements OnCancelListener {
        C211232() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(22221);
            try {
                if (IPCallPackageUI.this.nDN != null) {
                    C9638aw.m17182Rg().mo14547c(IPCallPackageUI.this.nDN);
                }
                IPCallPackageUI.this.finish();
                AppMethodBeat.m2505o(22221);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IPCallPackageUI", "cancel getPackageProductListNetScene error: %s", e.getMessage());
                AppMethodBeat.m2505o(22221);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI$1 */
    class C211241 implements OnMenuItemClickListener {
        C211241() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22220);
            IPCallPackageUI.this.finish();
            AppMethodBeat.m2505o(22220);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI$3 */
    class C211253 implements OnCancelListener {
        C211253() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public IPCallPackageUI() {
        AppMethodBeat.m2504i(22230);
        AppMethodBeat.m2505o(22230);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22231);
        super.onCreate(bundle);
        C9638aw.m17182Rg().mo14539a(831, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(277, (C1202f) this);
        this.nDP.start();
        C21079f c21079f = this.nDP;
        c21079f.nyR++;
        this.nDP.finish();
        setMMTitle((int) C25738R.string.cj_);
        setBackBtn(new C211241());
        this.nDI = (ListView) findViewById(2131825179);
        this.nDM = new C3311a(this);
        this.nDI.setAdapter(this.nDM);
        this.nDJ = (TextView) findViewById(2131825180);
        bIr();
        AppMethodBeat.m2505o(22231);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22232);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b(831, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(277, (C1202f) this);
        AppMethodBeat.m2505o(22232);
    }

    public final int getLayoutId() {
        return 2130969903;
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void bIr() {
        AppMethodBeat.m2504i(22233);
        C4990ab.m7416i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
        if (this.nDM != null) {
            this.nDM.ngC = null;
            this.nDM.notifyDataSetChanged();
        }
        if (this.nDI != null) {
            this.nDI.setVisibility(8);
        }
        if (this.nDJ != null) {
            this.nDJ.setVisibility(8);
        }
        bIs();
        this.nDN = new C34371e();
        C9638aw.m17182Rg().mo14541a(this.nDN, 0);
        AppMethodBeat.m2505o(22233);
    }

    private void bIs() {
        AppMethodBeat.m2504i(22234);
        if (this.nDK == null) {
            Context context = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.nDK = C30379h.m48458b(context, getString(C25738R.string.ch0), true, new C211232());
            AppMethodBeat.m2505o(22234);
            return;
        }
        this.nDK.show();
        AppMethodBeat.m2505o(22234);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(22235);
        if (this.nDK != null && this.nDK.isShowing()) {
            this.nDK.dismiss();
        }
        if (this.nDL != null && this.nDL.isShowing()) {
            this.nDL.dismiss();
        }
        if (c1207m instanceof C34371e) {
            C4990ab.m7417i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                aqm aqm = ((C34371e) c1207m).nyo;
                if (aqm == null || aqm.wuh == null || aqm.wuh.size() <= 0) {
                    this.nDM.ngC = null;
                    this.nDM.notifyDataSetChanged();
                    this.nDJ.setVisibility(0);
                    AppMethodBeat.m2505o(22235);
                    return;
                }
                this.nDM.ngC = aqm.wuh;
                this.nDM.notifyDataSetChanged();
                this.nDI.setVisibility(0);
                AppMethodBeat.m2505o(22235);
                return;
            }
            Toast.makeText(this.mController.ylL, getString(C25738R.string.cgx), 0).show();
            finish();
            AppMethodBeat.m2505o(22235);
        } else if (c1207m instanceof C12252j) {
            C4990ab.m7417i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallPurchasePackage errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
            this.nDP.nyV = i2;
            if (i == 0 && i2 == 0) {
                this.nDP.finish();
                Toast.makeText(this.mController.ylL, getString(C25738R.string.cjb), 0).show();
                bIr();
                AppMethodBeat.m2505o(22235);
            } else if (i2 == 101) {
                String str2;
                crx crx;
                C3311a c3311a = this.nDM;
                C12252j c12252j = (C12252j) c1207m;
                if (c12252j.nyy != null) {
                    str2 = c12252j.nyy.ProductID;
                } else {
                    str2 = "";
                }
                if (!(C5046bo.isNullOrNil(str2) || c3311a.ngC == null)) {
                    for (crx crx2 : c3311a.ngC) {
                        if (crx2 != null && crx2.ProductID.equals(str2)) {
                            crx = crx2;
                            break;
                        }
                    }
                }
                crx = null;
                if (crx == null) {
                    C4990ab.m7412e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
                    this.nDP.finish();
                    Toast.makeText(this.mController.ylL, getString(C25738R.string.cj6), 0).show();
                    AppMethodBeat.m2505o(22235);
                    return;
                }
                C30379h.m48445a(this.mController.ylL, this.mController.ylL.getString(C25738R.string.cj8, new Object[]{crx.wOs, crx.Title}), this.mController.ylL.getString(C25738R.string.cj9), this.mController.ylL.getString(C25738R.string.chh), this.mController.ylL.getString(C25738R.string.cj3), false, new C122764(), new C211225());
                AppMethodBeat.m2505o(22235);
            } else {
                this.nDP.finish();
                Toast.makeText(this.mController.ylL, getString(C25738R.string.cj6), 0).show();
                bIr();
                AppMethodBeat.m2505o(22235);
            }
        } else {
            C4990ab.m7417i("MicroMsg.IPCallPackageUI", "onSceneEnd errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
            AppMethodBeat.m2505o(22235);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m32454a(IPCallPackageUI iPCallPackageUI, String str) {
        AppMethodBeat.m2504i(22236);
        C4990ab.m7417i("MicroMsg.IPCallPackageUI", "startPurchasePackage productID:%s", str);
        if (iPCallPackageUI.nDL == null) {
            Context context = iPCallPackageUI.mController.ylL;
            iPCallPackageUI.getString(C25738R.string.f9238tz);
            iPCallPackageUI.nDL = C30379h.m48458b(context, iPCallPackageUI.getString(C25738R.string.cja), false, new C211253());
        } else {
            iPCallPackageUI.nDL.show();
        }
        iPCallPackageUI.nDO = new C12252j(str);
        C9638aw.m17182Rg().mo14541a(iPCallPackageUI.nDO, 0);
        AppMethodBeat.m2505o(22236);
    }
}
