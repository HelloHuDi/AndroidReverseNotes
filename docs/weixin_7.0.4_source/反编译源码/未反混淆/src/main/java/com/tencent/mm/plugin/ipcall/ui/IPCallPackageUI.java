package com.tencent.mm.plugin.ipcall.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.d.e;
import com.tencent.mm.plugin.ipcall.a.d.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public class IPCallPackageUI extends MMActivity implements f {
    private ListView nDI = null;
    private TextView nDJ = null;
    private ProgressDialog nDK = null;
    private ProgressDialog nDL = null;
    private a nDM = null;
    private e nDN = null;
    private j nDO = null;
    private com.tencent.mm.plugin.ipcall.a.e.f nDP = new com.tencent.mm.plugin.ipcall.a.e.f();

    static class a extends BaseAdapter {
        private IPCallPackageUI nDR = null;
        List<crx> ngC = null;

        class a {
            TextView gtb;
            TextView hrg;
            CdnImageView nDV;
            TextView nDW;
            TextView nDX;
            Button nDY;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        public a(IPCallPackageUI iPCallPackageUI) {
            this.nDR = iPCallPackageUI;
        }

        public final int getCount() {
            AppMethodBeat.i(22227);
            if (this.ngC == null) {
                AppMethodBeat.o(22227);
                return 0;
            }
            int size = this.ngC.size();
            AppMethodBeat.o(22227);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(22228);
            if (this.ngC != null) {
                Object obj = this.ngC.get(i);
                AppMethodBeat.o(22228);
                return obj;
            }
            AppMethodBeat.o(22228);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(22229);
            if (view == null) {
                view = ((LayoutInflater) this.nDR.getSystemService("layout_inflater")).inflate(R.layout.a91, viewGroup, false);
                aVar = new a(this, (byte) 0);
                aVar.nDV = (CdnImageView) view.findViewById(R.id.cn2);
                aVar.gtb = (TextView) view.findViewById(R.id.cn3);
                aVar.nDW = (TextView) view.findViewById(R.id.cn8);
                aVar.nDX = (TextView) view.findViewById(R.id.cn9);
                aVar.hrg = (TextView) view.findViewById(R.id.cjv);
                aVar.nDY = (Button) view.findViewById(R.id.cn6);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            crx crx = (crx) getItem(i);
            if (crx == null) {
                AppMethodBeat.o(22229);
            } else {
                aVar.gtb.setText(crx.Title);
                aVar.nDW.setText(crx.wOs);
                aVar.hrg.setText(crx.Desc);
                aVar.nDX.setText(crx.nzz);
                aVar.nDV.setVisibility(0);
                aVar.nDV.setUrl(crx.xpy);
                if (crx.vEq == 0) {
                    aVar.nDY.setEnabled(true);
                } else {
                    aVar.nDY.setEnabled(false);
                }
                aVar.nDY.setTag(Integer.valueOf(i));
                aVar.nDY.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(22226);
                        final crx crx = (crx) a.this.getItem(((Integer) view.getTag()).intValue());
                        if (crx == null || bo.isNullOrNil(crx.ProductID)) {
                            ab.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
                            AppMethodBeat.o(22226);
                            return;
                        }
                        a.this.nDR.nDP.start();
                        com.tencent.mm.plugin.ipcall.a.e.f b = a.this.nDR.nDP;
                        b.nyS++;
                        a.this.nDR.nDP.nyW = crx.ProductID;
                        h.a(a.this.nDR, a.this.nDR.getString(R.string.cj4, new Object[]{crx.wOs, crx.Title}), a.this.nDR.getString(R.string.cj5), a.this.nDR.getString(R.string.cj2), a.this.nDR.getString(R.string.cj3), false, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(22224);
                                com.tencent.mm.plugin.ipcall.a.e.f b = a.this.nDR.nDP;
                                b.nyT++;
                                IPCallPackageUI.a(a.this.nDR, crx.ProductID);
                                AppMethodBeat.o(22224);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(22225);
                                com.tencent.mm.plugin.ipcall.a.e.f b = a.this.nDR.nDP;
                                b.nyU++;
                                a.this.nDR.nDP.finish();
                                AppMethodBeat.o(22225);
                            }
                        });
                        AppMethodBeat.o(22226);
                    }
                });
                AppMethodBeat.o(22229);
            }
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallPackageUI() {
        AppMethodBeat.i(22230);
        AppMethodBeat.o(22230);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22231);
        super.onCreate(bundle);
        aw.Rg().a(831, (f) this);
        aw.Rg().a(277, (f) this);
        this.nDP.start();
        com.tencent.mm.plugin.ipcall.a.e.f fVar = this.nDP;
        fVar.nyR++;
        this.nDP.finish();
        setMMTitle((int) R.string.cj_);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22220);
                IPCallPackageUI.this.finish();
                AppMethodBeat.o(22220);
                return true;
            }
        });
        this.nDI = (ListView) findViewById(R.id.cn_);
        this.nDM = new a(this);
        this.nDI.setAdapter(this.nDM);
        this.nDJ = (TextView) findViewById(R.id.cna);
        bIr();
        AppMethodBeat.o(22231);
    }

    public void onDestroy() {
        AppMethodBeat.i(22232);
        super.onDestroy();
        aw.Rg().b(831, (f) this);
        aw.Rg().b(277, (f) this);
        AppMethodBeat.o(22232);
    }

    public final int getLayoutId() {
        return R.layout.a92;
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void bIr() {
        AppMethodBeat.i(22233);
        ab.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
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
        this.nDN = new e();
        aw.Rg().a(this.nDN, 0);
        AppMethodBeat.o(22233);
    }

    private void bIs() {
        AppMethodBeat.i(22234);
        if (this.nDK == null) {
            Context context = this.mController.ylL;
            getString(R.string.tz);
            this.nDK = h.b(context, getString(R.string.ch0), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(22221);
                    try {
                        if (IPCallPackageUI.this.nDN != null) {
                            aw.Rg().c(IPCallPackageUI.this.nDN);
                        }
                        IPCallPackageUI.this.finish();
                        AppMethodBeat.o(22221);
                    } catch (Exception e) {
                        ab.e("MicroMsg.IPCallPackageUI", "cancel getPackageProductListNetScene error: %s", e.getMessage());
                        AppMethodBeat.o(22221);
                    }
                }
            });
            AppMethodBeat.o(22234);
            return;
        }
        this.nDK.show();
        AppMethodBeat.o(22234);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(22235);
        if (this.nDK != null && this.nDK.isShowing()) {
            this.nDK.dismiss();
        }
        if (this.nDL != null && this.nDL.isShowing()) {
            this.nDL.dismiss();
        }
        if (mVar instanceof e) {
            ab.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                aqm aqm = ((e) mVar).nyo;
                if (aqm == null || aqm.wuh == null || aqm.wuh.size() <= 0) {
                    this.nDM.ngC = null;
                    this.nDM.notifyDataSetChanged();
                    this.nDJ.setVisibility(0);
                    AppMethodBeat.o(22235);
                    return;
                }
                this.nDM.ngC = aqm.wuh;
                this.nDM.notifyDataSetChanged();
                this.nDI.setVisibility(0);
                AppMethodBeat.o(22235);
                return;
            }
            Toast.makeText(this.mController.ylL, getString(R.string.cgx), 0).show();
            finish();
            AppMethodBeat.o(22235);
        } else if (mVar instanceof j) {
            ab.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallPurchasePackage errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
            this.nDP.nyV = i2;
            if (i == 0 && i2 == 0) {
                this.nDP.finish();
                Toast.makeText(this.mController.ylL, getString(R.string.cjb), 0).show();
                bIr();
                AppMethodBeat.o(22235);
            } else if (i2 == 101) {
                String str2;
                crx crx;
                a aVar = this.nDM;
                j jVar = (j) mVar;
                if (jVar.nyy != null) {
                    str2 = jVar.nyy.ProductID;
                } else {
                    str2 = "";
                }
                if (!(bo.isNullOrNil(str2) || aVar.ngC == null)) {
                    for (crx crx2 : aVar.ngC) {
                        if (crx2 != null && crx2.ProductID.equals(str2)) {
                            crx = crx2;
                            break;
                        }
                    }
                }
                crx = null;
                if (crx == null) {
                    ab.e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
                    this.nDP.finish();
                    Toast.makeText(this.mController.ylL, getString(R.string.cj6), 0).show();
                    AppMethodBeat.o(22235);
                    return;
                }
                h.a(this.mController.ylL, this.mController.ylL.getString(R.string.cj8, new Object[]{crx.wOs, crx.Title}), this.mController.ylL.getString(R.string.cj9), this.mController.ylL.getString(R.string.chh), this.mController.ylL.getString(R.string.cj3), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(22222);
                        com.tencent.mm.plugin.ipcall.a.e.f b = IPCallPackageUI.this.nDP;
                        b.nyX++;
                        IPCallPackageUI.this.nDP.finish();
                        Intent intent = new Intent();
                        intent.setClass(IPCallPackageUI.this.mController.ylL, IPCallRechargeUI.class);
                        IPCallPackageUI.this.startActivity(intent);
                        IPCallPackageUI.this.finish();
                        AppMethodBeat.o(22222);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(22223);
                        com.tencent.mm.plugin.ipcall.a.e.f b = IPCallPackageUI.this.nDP;
                        b.nyY++;
                        IPCallPackageUI.this.nDP.finish();
                        AppMethodBeat.o(22223);
                    }
                });
                AppMethodBeat.o(22235);
            } else {
                this.nDP.finish();
                Toast.makeText(this.mController.ylL, getString(R.string.cj6), 0).show();
                bIr();
                AppMethodBeat.o(22235);
            }
        } else {
            ab.i("MicroMsg.IPCallPackageUI", "onSceneEnd errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
            AppMethodBeat.o(22235);
        }
    }

    static /* synthetic */ void a(IPCallPackageUI iPCallPackageUI, String str) {
        AppMethodBeat.i(22236);
        ab.i("MicroMsg.IPCallPackageUI", "startPurchasePackage productID:%s", str);
        if (iPCallPackageUI.nDL == null) {
            Context context = iPCallPackageUI.mController.ylL;
            iPCallPackageUI.getString(R.string.tz);
            iPCallPackageUI.nDL = h.b(context, iPCallPackageUI.getString(R.string.cja), false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        } else {
            iPCallPackageUI.nDL.show();
        }
        iPCallPackageUI.nDO = new j(str);
        aw.Rg().a(iPCallPackageUI.nDO, 0);
        AppMethodBeat.o(22236);
    }
}
