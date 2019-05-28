package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.c;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.plugin.address.ui.AddrEditView.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.q;
import java.util.List;

public class WalletAddAddressUI extends MMActivity implements f, b {
    private String cJo = "";
    private Dialog gII = null;
    private int gJi = 0;
    private AddrEditView gKO;
    private AddrEditView gKP;
    private AddrEditView gKQ;
    private AddrEditView gKR;
    private AddrEditView gKS;
    private com.tencent.mm.plugin.address.d.b gKT = null;
    private com.tencent.mm.plugin.address.d.b gKU = new com.tencent.mm.plugin.address.d.b();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletAddAddressUI() {
        AppMethodBeat.i(16944);
        AppMethodBeat.o(16944);
    }

    static /* synthetic */ void a(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.i(16957);
        walletAddAddressUI.asf();
        AppMethodBeat.o(16957);
    }

    static /* synthetic */ void b(com.tencent.mm.plugin.address.d.b bVar, com.tencent.mm.plugin.address.d.b bVar2) {
        AppMethodBeat.i(16962);
        a(bVar, bVar2);
        AppMethodBeat.o(16962);
    }

    static /* synthetic */ void b(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.i(16958);
        walletAddAddressUI.asg();
        AppMethodBeat.o(16958);
    }

    static /* synthetic */ void d(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.i(16960);
        walletAddAddressUI.arY();
        AppMethodBeat.o(16960);
    }

    static /* synthetic */ boolean e(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.i(16961);
        boolean arW = walletAddAddressUI.arW();
        AppMethodBeat.o(16961);
        return arW;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(16945);
        super.onCreate(bundle);
        aw.Rg().a(415, (f) this);
        aw.Rg().a(418, (f) this);
        ab.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
        ab.LZ(0);
        this.gJi = getIntent().getIntExtra("address_id", 0);
        if (this.gJi == 0) {
            setMMTitle((int) R.string.dg);
        } else {
            setMMTitle((int) R.string.e9);
        }
        initView();
        AppMethodBeat.o(16945);
    }

    public final void initView() {
        AppMethodBeat.i(16946);
        a.arS().arT();
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.id.bb_);
        mMScrollView.a(mMScrollView, mMScrollView);
        this.gKO = (AddrEditView) findViewById(R.id.f58);
        this.gKP = (AddrEditView) findViewById(R.id.f5_);
        this.gKQ = (AddrEditView) findViewById(R.id.f5a);
        this.gKR = (AddrEditView) findViewById(R.id.f5b);
        this.gKS = (AddrEditView) findViewById(R.id.f59);
        this.gKO.setOnInputValidChangeListener(this);
        this.gKP.setOnInputValidChangeListener(this);
        this.gKQ.setOnInputValidChangeListener(this);
        this.gKR.setOnInputValidChangeListener(this);
        this.gKS.setOnInputValidChangeListener(this);
        this.gKO.setInfoIvOnClickListener(new AddrEditView.a() {
            public final void onClick() {
                AppMethodBeat.i(16932);
                ab.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(WalletAddAddressUI.this, "android.permission.READ_CONTACTS", 48, null, null)), bo.dpG());
                if (com.tencent.mm.pluginsdk.permission.b.a(WalletAddAddressUI.this, "android.permission.READ_CONTACTS", 48, null, null)) {
                    WalletAddAddressUI.a(WalletAddAddressUI.this);
                    AppMethodBeat.o(16932);
                    return;
                }
                AppMethodBeat.o(16932);
            }
        });
        this.gKP.setInfoIvOnClickListener(new AddrEditView.a() {
            public final void onClick() {
                AppMethodBeat.i(16937);
                ab.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(WalletAddAddressUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
                if (com.tencent.mm.pluginsdk.permission.b.a(WalletAddAddressUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                    WalletAddAddressUI.b(WalletAddAddressUI.this);
                    AppMethodBeat.o(16937);
                    return;
                }
                AppMethodBeat.o(16937);
            }
        });
        this.gKP.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(16938);
                WalletAddAddressUI.c(WalletAddAddressUI.this);
                AppMethodBeat.o(16938);
            }
        });
        if (this.gJi != 0) {
            this.gKT = a.arS().ne(this.gJi);
            this.gKO.setValStr(this.gKT.gJf);
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(this.gKT.gJa)) {
                stringBuilder.append(this.gKT.gJa);
            }
            if (!TextUtils.isEmpty(this.gKT.gJb)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.gKT.gJb);
            }
            if (!TextUtils.isEmpty(this.gKT.gJc)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.gKT.gJc);
            }
            this.gKP.setValStr(stringBuilder.toString());
            this.gKQ.setValStr(this.gKT.gJe);
            this.gKR.setValStr(this.gKT.gJd);
            this.gKS.setValStr(this.gKT.gJg);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(16939);
                WalletAddAddressUI.d(WalletAddAddressUI.this);
                AppMethodBeat.o(16939);
                return true;
            }
        });
        a(0, getString(R.string.tc), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(16940);
                if (WalletAddAddressUI.e(WalletAddAddressUI.this)) {
                    if (WalletAddAddressUI.this.gJi != 0) {
                        WalletAddAddressUI.this.gKT = a.arS().ne(WalletAddAddressUI.this.gJi);
                        ab.d("MicroMsg.WalletAddAddressUI", "get addr " + WalletAddAddressUI.this.gKT.toString());
                        WalletAddAddressUI.b(WalletAddAddressUI.this.gKT, WalletAddAddressUI.this.gKU);
                    } else {
                        WalletAddAddressUI.this.gKT = new com.tencent.mm.plugin.address.d.b();
                    }
                    String text = WalletAddAddressUI.this.gKO.getText();
                    String text2 = WalletAddAddressUI.this.gKP.getText();
                    String text3 = WalletAddAddressUI.this.gKQ.getText();
                    String text4 = WalletAddAddressUI.this.gKR.getText();
                    String text5 = WalletAddAddressUI.this.gKS.getText();
                    String[] split = text2.split(" ");
                    if (split.length > 0) {
                        WalletAddAddressUI.this.gKU.gJa = split[0];
                    }
                    if (split.length >= 2) {
                        WalletAddAddressUI.this.gKU.gJb = split[1];
                    }
                    if (split.length >= 3) {
                        WalletAddAddressUI.this.gKU.gJc = split[2];
                    } else {
                        WalletAddAddressUI.this.gKU.gJc = "";
                    }
                    WalletAddAddressUI.this.gKU.gJe = text3;
                    WalletAddAddressUI.this.gKU.gJf = text;
                    WalletAddAddressUI.this.gKU.gJg = text5;
                    WalletAddAddressUI.this.gKU.gJd = text4;
                    if (!bo.isNullOrNil(WalletAddAddressUI.this.cJo)) {
                        WalletAddAddressUI.this.gKU.gJh = WalletAddAddressUI.this.cJo;
                    }
                    WalletAddAddressUI.o(WalletAddAddressUI.this);
                    AppMethodBeat.o(16940);
                } else {
                    AppMethodBeat.o(16940);
                }
                return true;
            }
        }, q.b.GREEN);
        arW();
        AppMethodBeat.o(16946);
    }

    public void onDestroy() {
        AppMethodBeat.i(16947);
        super.onDestroy();
        aw.Rg().b(415, (f) this);
        aw.Rg().b(418, (f) this);
        l arS = a.arS();
        ab.i("MicroMsg.WalletAddrMgr", "clean data");
        for (List clear : arS.gIS.values()) {
            clear.clear();
        }
        for (List clear2 : arS.gIT.values()) {
            clear2.clear();
        }
        arS.gIR.clear();
        arS.gIS.clear();
        arS.gIT.clear();
        AppMethodBeat.o(16947);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(16948);
        String stringExtra;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    stringExtra = intent.getStringExtra("karea_result");
                    if (!bo.isNullOrNil(stringExtra)) {
                        ab.d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:".concat(String.valueOf(stringExtra)));
                        this.gKP.setValStr(stringExtra);
                    }
                    stringExtra = intent.getStringExtra("kpost_code");
                    if (!bo.isNullOrNil(stringExtra)) {
                        ab.d("MicroMsg.WalletAddAddressUI", "post:".concat(String.valueOf(stringExtra)));
                        this.gKR.setValStr(stringExtra);
                    }
                    this.cJo = intent.getStringExtra("kwcode");
                    AppMethodBeat.o(16948);
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data == null) {
                        ab.d("MicroMsg.WalletAddAddressUI", "uri == null");
                        AppMethodBeat.o(16948);
                        return;
                    }
                    String str;
                    String[] f = com.tencent.mm.pluginsdk.a.f(getBaseContext(), data);
                    if (f == null || f.length != 2) {
                        h.b((Context) this, getString(R.string.f3), "", true);
                        stringExtra = null;
                        str = null;
                    } else {
                        stringExtra = f[0];
                        str = f[1];
                    }
                    this.gKO.setValStr(stringExtra);
                    this.gKS.setValStr(str);
                    if (PhoneNumberUtils.isGlobalPhoneNumber(str)) {
                        arW();
                        AppMethodBeat.o(16948);
                        return;
                    }
                    h.b((Context) this, getString(R.string.f3), "", true);
                    AppMethodBeat.o(16948);
                    return;
                }
                break;
            case 3:
                if (i2 != -1) {
                    ab.i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
                    break;
                }
                Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
                if (addr != null) {
                    ab.d("MicroMsg.WalletAddAddressUI", "addr: " + addr.toString());
                    if (addr != null) {
                        StringBuilder stringBuilder;
                        if (a.arS().z(addr.fBh, addr.fBj, addr.fBk)) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(addr.fBh);
                            stringBuilder.append(" ");
                            stringBuilder.append(addr.fBj);
                            if (!TextUtils.isEmpty(addr.fBk)) {
                                stringBuilder.append(" ");
                                stringBuilder.append(addr.fBk);
                            }
                            this.gKP.setValStr(stringBuilder.toString());
                        } else {
                            this.gKP.setValStr("");
                        }
                        stringBuilder = new StringBuilder();
                        if (!TextUtils.isEmpty(addr.fBl)) {
                            stringBuilder.append(addr.fBl);
                        }
                        if (!TextUtils.isEmpty(addr.fBm)) {
                            stringBuilder.append(addr.fBm);
                        }
                        if (!TextUtils.isEmpty(addr.fBn)) {
                            stringBuilder.append(addr.fBn);
                        }
                        if (!TextUtils.isEmpty(addr.fBp)) {
                            stringBuilder.append(" ");
                            stringBuilder.append(addr.fBp);
                        }
                        if (!bo.isNullOrNil(addr.fBp) || bo.isNullOrNil(addr.fBg)) {
                            this.gKQ.setValStr(stringBuilder.toString());
                        } else {
                            this.gKQ.setValStr(addr.fBg);
                        }
                        RcptItem y = a.arS().y(addr.fBh, addr.fBj, addr.fBk);
                        if (y != null) {
                            this.gKR.setValStr(y.gIO);
                            this.cJo = y.code;
                        }
                    }
                }
                AppMethodBeat.o(16948);
                return;
                break;
        }
        AppMethodBeat.o(16948);
    }

    public final int getLayoutId() {
        return R.layout.b2n;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(16949);
        if (this.gII != null) {
            this.gII.dismiss();
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.address.d.a aVar = a.arS().gIQ;
            if (aVar.gIY.size() > 0) {
                a(this.gKU, this.gKT);
                com.tencent.mm.plugin.address.d.b bVar = (com.tencent.mm.plugin.address.d.b) aVar.gIY.getFirst();
                if (bVar != null) {
                    setResult(-1, com.tencent.mm.plugin.address.e.a.b(bVar));
                } else {
                    setResult(0);
                }
            } else {
                setResult(0);
            }
            finish();
            AppMethodBeat.o(16949);
            return;
        }
        switch (i2) {
            case -3104:
            case -3103:
            case -3102:
                h.a((Context) this, str, "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(16942);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(16942);
                    }
                });
                AppMethodBeat.o(16949);
                return;
            case -3100:
                h.a((Context) this, (int) R.string.df, 0, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(16941);
                        WalletAddAddressUI.this.finish();
                        AppMethodBeat.o(16941);
                    }
                });
                AppMethodBeat.o(16949);
                return;
            default:
                h.a((Context) this, (int) R.string.dd, 0, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(16949);
                return;
        }
    }

    private boolean arW() {
        boolean z = false;
        AppMethodBeat.i(16950);
        boolean z2 = true;
        if (!this.gKO.asa()) {
            z2 = false;
        }
        if (!this.gKQ.asa()) {
            z2 = false;
        }
        if (!this.gKP.asa()) {
            z2 = false;
        }
        if (!this.gKR.asa()) {
            z2 = false;
        }
        if (this.gKS.asa()) {
            z = z2;
        }
        enableOptionMenu(z);
        AppMethodBeat.o(16950);
        return z;
    }

    public final void arX() {
        AppMethodBeat.i(16951);
        arW();
        AppMethodBeat.o(16951);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(16952);
        if (i == 4) {
            arY();
            AppMethodBeat.o(16952);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(16952);
        return onKeyUp;
    }

    private void arY() {
        int i;
        int i2 = 1;
        AppMethodBeat.i(16953);
        int i3 = R.string.dj;
        if (this.gJi == 0) {
            i3 = R.string.di;
        }
        if (this.gKO.asb()) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.gKQ.asb()) {
            i = 1;
        }
        if (this.gKP.asb()) {
            i = 1;
        }
        if (this.gKR.asb()) {
            i = 1;
        }
        if (!this.gKS.asb()) {
            i2 = i;
        }
        if (i2 != 0) {
            h.a((Context) this, i3, (int) R.string.tz, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(16943);
                    WalletAddAddressUI.this.setResult(0);
                    WalletAddAddressUI.this.finish();
                    AppMethodBeat.o(16943);
                }
            }, null);
            AppMethodBeat.o(16953);
            return;
        }
        setResult(0);
        finish();
        AppMethodBeat.o(16953);
    }

    private void asf() {
        AppMethodBeat.i(16954);
        Intent intent = new Intent("android.intent.action.PICK", Contacts.CONTENT_URI);
        if (bo.k((Context) this, intent)) {
            startActivityForResult(intent, 2);
            AppMethodBeat.o(16954);
            return;
        }
        ab.w("MicroMsg.WalletAddAddressUI", "intent not available");
        AppMethodBeat.o(16954);
    }

    private void asg() {
        AppMethodBeat.i(16955);
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.gKP.getText())) {
            stringBuilder.append(this.gKP.getText());
        }
        if (!TextUtils.isEmpty(this.gKQ.getText())) {
            stringBuilder.append(this.gKQ.getText());
        }
        Intent intent = new Intent();
        intent.putExtra("wallet_address", stringBuilder.toString());
        intent.putExtra("map_view_type", 8);
        d.b((Context) this, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent, 3);
        AppMethodBeat.o(16955);
    }

    private static void a(com.tencent.mm.plugin.address.d.b bVar, com.tencent.mm.plugin.address.d.b bVar2) {
        if (bVar != null && bVar2 != null) {
            bVar2.id = bVar.id;
            bVar2.gJa = bVar.gJa;
            bVar2.gJb = bVar.gJb;
            bVar2.gJc = bVar.gJc;
            bVar2.gJe = bVar.gJe;
            bVar2.gJf = bVar.gJf;
            bVar2.gJg = bVar.gJg;
            bVar2.gJd = bVar.gJd;
            bVar2.gJh = bVar.gJh;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(16956);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(16956);
            return;
        }
        ab.i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    asf();
                    AppMethodBeat.o(16956);
                    return;
                }
                h.a((Context) this, getString(R.string.dbu), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(16933);
                        dialogInterface.dismiss();
                        WalletAddAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        AppMethodBeat.o(16933);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(16934);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(16934);
                    }
                });
                AppMethodBeat.o(16956);
                return;
            case 64:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(16935);
                            dialogInterface.dismiss();
                            WalletAddAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(16935);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(16936);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(16936);
                        }
                    });
                    break;
                }
                asg();
                AppMethodBeat.o(16956);
                return;
        }
        AppMethodBeat.o(16956);
    }

    static /* synthetic */ void c(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.i(16959);
        walletAddAddressUI.startActivityForResult(new Intent(walletAddAddressUI, WalletMultiRcptSelectUI.class), 1);
        AppMethodBeat.o(16959);
    }

    static /* synthetic */ void o(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.i(16963);
        if (walletAddAddressUI.gJi != 0) {
            ab.d("MicroMsg.WalletAddAddressUI", "modify save addr " + walletAddAddressUI.gKU.toString());
            a.arS().arU();
            aw.Rg().a(new com.tencent.mm.plugin.address.model.h(walletAddAddressUI.gKU), 0);
            walletAddAddressUI.gII = h.b((Context) walletAddAddressUI, "", true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            AppMethodBeat.o(16963);
            return;
        }
        ab.d("MicroMsg.WalletAddAddressUI", "add save addr " + walletAddAddressUI.gKU.toString());
        aw.Rg().a(new c(walletAddAddressUI.gKU), 0);
        walletAddAddressUI.gII = h.b((Context) walletAddAddressUI, "", true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(16963);
    }
}
