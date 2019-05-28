package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.a.d;
import com.tencent.mm.plugin.ipcall.a.d.g;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.j;

public class IPCallAddressUI extends MMActivity implements f {
    private View nAU;
    private ListView nBg;
    private e nBh = null;
    private int nBi = 0;
    private boolean nBj = false;
    private boolean nBk = true;
    private boolean nBl = false;
    private c nBm = new c<ir>() {
        {
            AppMethodBeat.i(22049);
            this.xxI = ir.class.getName().hashCode();
            AppMethodBeat.o(22049);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(22050);
            if (IPCallAddressUI.this.nBh != null) {
                IPCallAddressUI.this.nBh.bIh();
            }
            AppMethodBeat.o(22050);
            return true;
        }
    };
    private Runnable nBn = new Runnable() {
        public final void run() {
            AppMethodBeat.i(22052);
            a.bHb().a(null, true);
            AppMethodBeat.o(22052);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallAddressUI() {
        AppMethodBeat.i(22055);
        AppMethodBeat.o(22055);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22056);
        super.onCreate(bundle);
        aw.ZK();
        if (((Boolean) com.tencent.mm.model.c.Ry().get(ac.a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.FALSE);
            Intent intent = new Intent();
            intent.setClass(this.mController.ylL, IPCallAcitivityUI.class);
            this.mController.ylL.startActivity(intent);
            overridePendingTransition(R.anim.df, R.anim.dc);
            this.nBk = false;
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22051);
                if (IPCallAddressUI.this.nBi == 1) {
                    com.tencent.mm.plugin.ipcall.b.gkE.p(new Intent(), IPCallAddressUI.this);
                } else {
                    IPCallAddressUI.this.finish();
                }
                AppMethodBeat.o(22051);
                return true;
            }
        });
        if (this.nBk) {
            this.nBl = true;
            bIj();
        }
        aw.ZK();
        this.nBj = ((Boolean) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.TRUE)).booleanValue();
        setMMTitle((int) R.string.cgr);
        this.nBg = (ListView) findViewById(R.id.cje);
        this.nAU = findViewById(R.id.cjf);
        this.nBh = new e(this, this.nBg, this.nAU);
        e eVar = this.nBh;
        eVar.nAT = new h(eVar.nAV);
        ViewGroup viewGroup = (ViewGroup) View.inflate(eVar.nAV, R.layout.a8s, null);
        eVar.nAS.addHeaderView(viewGroup, null, false);
        eVar.nAS.setAdapter(eVar.nAT);
        eVar.nAX = (TextView) viewGroup.findViewById(R.id.clp);
        eVar.nAY = (TextView) viewGroup.findViewById(R.id.clq);
        eVar.nAZ = (LinearLayout) viewGroup.findViewById(R.id.clr);
        eVar.nBa = (TextView) viewGroup.findViewById(R.id.clt);
        eVar.nBb = (ImageView) viewGroup.findViewById(R.id.cls);
        viewGroup.findViewById(R.id.clo).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                int i;
                Object obj;
                AppMethodBeat.i(22033);
                aw.ZK();
                boolean booleanValue = ((Boolean) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue();
                if (booleanValue) {
                    aw.ZK();
                    i.Z(2, ((Integer) com.tencent.mm.model.c.Ry().get(ac.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_TYPE_INT, Integer.valueOf(-1))).intValue(), -1);
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_TYPE_INT, Integer.valueOf(-1));
                    ab.i("MicroMsg.IPCallAddressController", "set red dot type from %d to -1", Integer.valueOf(i));
                }
                if (booleanValue) {
                    obj = "true";
                } else {
                    String obj2 = "false";
                }
                aw.ZK();
                String str = (String) com.tencent.mm.model.c.Ry().get(ac.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, (Object) "");
                ab.i("MicroMsg.IPCallAddressController", "set show red dot from %s to false, set account string from %s to null", obj2, str);
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, (Object) "");
                aw.ZK();
                if (((Integer) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_CLEAR_TYPE_INT, Integer.valueOf(0))).intValue() == 1) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    aw.ZK();
                    ab.i("MicroMsg.IPCallAddressController", "set account activity string from %s to null", (String) com.tencent.mm.model.c.Ry().get(ac.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, (Object) ""));
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, (Object) "");
                }
                h.pYm.e(12061, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                e.this.bIh();
                Intent intent = new Intent();
                intent.setClass(e.this.nAV, IPCallShareCouponUI.class);
                e.this.nAV.startActivity(intent);
                AppMethodBeat.o(22033);
            }
        });
        viewGroup.findViewById(R.id.clv).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22034);
                Intent intent = new Intent();
                intent.setClass(e.this.nAV, IPCallContactUI.class);
                e.this.nAV.startActivity(intent);
                AppMethodBeat.o(22034);
            }
        });
        viewGroup.findViewById(R.id.clw).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22035);
                Intent intent = new Intent(e.this.nAV, IPCallDialUI.class);
                intent.putExtra("IPCallTalkUI_dialScene", 1);
                e.this.nAV.startActivityForResult(intent, 1001);
                AppMethodBeat.o(22035);
            }
        });
        eVar.nAS.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(22036);
                if (e.this.nAT.wK(i)) {
                    AppMethodBeat.o(22036);
                    return;
                }
                if (adapterView instanceof ListView) {
                    k xt = e.this.nAT.xt(i - ((ListView) adapterView).getHeaderViewsCount());
                    if (xt == null) {
                        AppMethodBeat.o(22036);
                        return;
                    }
                    com.tencent.mm.plugin.ipcall.a.g.c cVar = null;
                    if (xt.field_addressId > 0) {
                        cVar = com.tencent.mm.plugin.ipcall.a.i.bHw().iU(xt.field_addressId);
                    }
                    Intent intent = new Intent(e.this.nAV, IPCallUserProfileUI.class);
                    if (cVar != null) {
                        intent.putExtra("IPCallProfileUI_contactid", cVar.field_contactId);
                        intent.putExtra("IPCallProfileUI_systemUsername", cVar.field_systemAddressBookUsername);
                        intent.putExtra("IPCallProfileUI_wechatUsername", cVar.field_wechatUsername);
                    } else {
                        intent.putExtra("IPCallProfileUI_phonenumber", xt.field_phonenumber);
                    }
                    intent.putExtra("IPCallProfileUI_isNeedShowRecord", true);
                    e.this.nAV.startActivity(intent);
                }
                AppMethodBeat.o(22036);
            }
        });
        eVar.nAS.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(22037);
                h hVar = e.this.nAT;
                if (hVar.nDZ == null) {
                    hVar.nDZ = m.bIb();
                }
                k xt = e.this.nAT.xt(i - ((ListView) adapterView).getHeaderViewsCount());
                e eVar = e.this;
                int headerViewsCount = i - ((ListView) adapterView).getHeaderViewsCount();
                if (xt != null) {
                    j jVar = new j(eVar.nAV);
                    jVar.rBl = new n.c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(22040);
                            lVar.add((int) R.string.p4);
                            AppMethodBeat.o(22040);
                        }
                    };
                    jVar.rBm = new AnonymousClass9(xt, headerViewsCount);
                    jVar.cuu();
                }
                AppMethodBeat.o(22037);
                return true;
            }
        });
        aw.ZK();
        if (((Boolean) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            d.bHg().ii(true);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.FALSE);
        } else {
            d.bHg().ii(false);
        }
        if (eVar.nAT.getCount() > 0) {
            eVar.nAU.setVisibility(8);
        } else {
            eVar.nAU.setVisibility(0);
        }
        eVar.bIi();
        eVar.bIh();
        eVar.nAW = true;
        aw.Rg().a((int) com.tencent.view.d.MIC_PTU_ZIPAI_TOKYO, (f) this);
        com.tencent.mm.sdk.b.a.xxA.c(this.nBm);
        this.nBi = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
        h.pYm.a(257, 0, 1, true);
        AppMethodBeat.o(22056);
    }

    public final int getLayoutId() {
        return R.layout.a8g;
    }

    private void bIj() {
        AppMethodBeat.i(22057);
        ab.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bo.dpG());
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            com.tencent.mm.sdk.g.d.post(this.nBn, "IPCallAddressUI_LoadSystemAddressBook");
        }
        AppMethodBeat.o(22057);
    }

    public void onDestroy() {
        AppMethodBeat.i(22058);
        super.onDestroy();
        if (this.nBh != null) {
            e eVar = this.nBh;
            eVar.nAS.setOnItemClickListener(null);
            eVar.nAS.setOnItemLongClickListener(null);
            o.acd().b(eVar.nAT);
        }
        aw.Rg().b((int) com.tencent.view.d.MIC_PTU_ZIPAI_TOKYO, (f) this);
        com.tencent.mm.sdk.b.a.xxA.d(this.nBm);
        AppMethodBeat.o(22058);
    }

    public void onResume() {
        AppMethodBeat.i(22059);
        super.onResume();
        if (this.nBh != null) {
            e eVar = this.nBh;
            if (!(eVar.nAT == null || eVar.nAW)) {
                eVar.nAT.notifyDataSetChanged();
                if (eVar.nAT.getCount() > 0) {
                    eVar.nAU.setVisibility(8);
                } else {
                    eVar.nAU.setVisibility(0);
                }
            }
            eVar.nAW = false;
        }
        supportInvalidateOptionsMenu();
        com.tencent.mm.plugin.ipcall.a.f.b.bHU().it(true);
        if (!this.nBl) {
            this.nBl = true;
            bIj();
        }
        AppMethodBeat.o(22059);
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(22060);
        if ((mVar instanceof g) && i == 0 && i2 == 0 && this.nBh != null) {
            this.nBh.bIi();
        }
        AppMethodBeat.o(22060);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(22061);
        ab.d("MicroMsg.IPCallAddressUI", "onCreateOptionsMenu");
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        AppMethodBeat.o(22061);
        return onCreateOptionsMenu;
    }

    public void onBackPressed() {
        AppMethodBeat.i(22062);
        if (this.nBi == 1) {
            com.tencent.mm.plugin.ipcall.b.gkE.p(new Intent(), this);
            AppMethodBeat.o(22062);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(22062);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(22063);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(22063);
            return;
        }
        ab.i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0 && this.nBj) {
                    this.nBj = false;
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dbu), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22053);
                            dialogInterface.dismiss();
                            IPCallAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(22053);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22054);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(22054);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.o(22063);
    }
}
