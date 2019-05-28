package com.tencent.p177mm.plugin.address.p276ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelgeo.Addr;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.address.model.C26686h;
import com.tencent.p177mm.plugin.address.model.C42318c;
import com.tencent.p177mm.plugin.address.model.C42322l;
import com.tencent.p177mm.plugin.address.model.RcptItem;
import com.tencent.p177mm.plugin.address.p1218e.C42316a;
import com.tencent.p177mm.plugin.address.p1467a.C33045a;
import com.tencent.p177mm.plugin.address.p1534d.C38090b;
import com.tencent.p177mm.plugin.address.p1534d.C45505a;
import com.tencent.p177mm.plugin.address.p276ui.AddrEditView.C26689a;
import com.tencent.p177mm.plugin.address.p276ui.AddrEditView.C26690b;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI */
public class WalletAddAddressUI extends MMActivity implements C1202f, C26690b {
    private String cJo = "";
    private Dialog gII = null;
    private int gJi = 0;
    private AddrEditView gKO;
    private AddrEditView gKP;
    private AddrEditView gKQ;
    private AddrEditView gKR;
    private AddrEditView gKS;
    private C38090b gKT = null;
    private C38090b gKU = new C38090b();

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$5 */
    class C20425 implements OnClickListener {
        C20425() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16934);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(16934);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$6 */
    class C20436 implements OnClickListener {
        C20436() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16935);
            dialogInterface.dismiss();
            WalletAddAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(16935);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$7 */
    class C20447 implements OnClickListener {
        C20447() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16936);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(16936);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$15 */
    class C1002715 implements OnClickListener {
        C1002715() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16943);
            WalletAddAddressUI.this.setResult(0);
            WalletAddAddressUI.this.finish();
            AppMethodBeat.m2505o(16943);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$8 */
    class C100288 implements C26689a {
        C100288() {
        }

        public final void onClick() {
            AppMethodBeat.m2504i(16937);
            C4990ab.m7417i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a(WalletAddAddressUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
            if (C35805b.m58707a(WalletAddAddressUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                WalletAddAddressUI.m17614b(WalletAddAddressUI.this);
                AppMethodBeat.m2505o(16937);
                return;
            }
            AppMethodBeat.m2505o(16937);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$13 */
    class C1002913 implements OnClickListener {
        C1002913() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16942);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(16942);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$14 */
    class C1003014 implements OnClickListener {
        C1003014() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$1 */
    class C100311 implements C26689a {
        C100311() {
        }

        public final void onClick() {
            AppMethodBeat.m2504i(16932);
            C4990ab.m7417i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(C35805b.m58707a(WalletAddAddressUI.this, "android.permission.READ_CONTACTS", 48, null, null)), C5046bo.dpG());
            if (C35805b.m58707a(WalletAddAddressUI.this, "android.permission.READ_CONTACTS", 48, null, null)) {
                WalletAddAddressUI.m17612a(WalletAddAddressUI.this);
                AppMethodBeat.m2505o(16932);
                return;
            }
            AppMethodBeat.m2505o(16932);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$2 */
    class C100322 implements OnCancelListener {
        C100322() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$3 */
    class C100333 implements OnCancelListener {
        C100333() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$9 */
    class C100349 implements View.OnClickListener {
        C100349() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(16938);
            WalletAddAddressUI.m17615c(WalletAddAddressUI.this);
            AppMethodBeat.m2505o(16938);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$11 */
    class C1003511 implements OnMenuItemClickListener {
        C1003511() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(16940);
            if (WalletAddAddressUI.m17617e(WalletAddAddressUI.this)) {
                if (WalletAddAddressUI.this.gJi != 0) {
                    WalletAddAddressUI.this.gKT = C33045a.arS().mo67843ne(WalletAddAddressUI.this.gJi);
                    C4990ab.m7410d("MicroMsg.WalletAddAddressUI", "get addr " + WalletAddAddressUI.this.gKT.toString());
                    WalletAddAddressUI.m17613b(WalletAddAddressUI.this.gKT, WalletAddAddressUI.this.gKU);
                } else {
                    WalletAddAddressUI.this.gKT = new C38090b();
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
                if (!C5046bo.isNullOrNil(WalletAddAddressUI.this.cJo)) {
                    WalletAddAddressUI.this.gKU.gJh = WalletAddAddressUI.this.cJo;
                }
                WalletAddAddressUI.m17627o(WalletAddAddressUI.this);
                AppMethodBeat.m2505o(16940);
            } else {
                AppMethodBeat.m2505o(16940);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$10 */
    class C1003610 implements OnMenuItemClickListener {
        C1003610() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(16939);
            WalletAddAddressUI.m17616d(WalletAddAddressUI.this);
            AppMethodBeat.m2505o(16939);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$12 */
    class C1003712 implements OnClickListener {
        C1003712() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16941);
            WalletAddAddressUI.this.finish();
            AppMethodBeat.m2505o(16941);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletAddAddressUI$4 */
    class C100384 implements OnClickListener {
        C100384() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16933);
            dialogInterface.dismiss();
            WalletAddAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(16933);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletAddAddressUI() {
        AppMethodBeat.m2504i(16944);
        AppMethodBeat.m2505o(16944);
    }

    /* renamed from: a */
    static /* synthetic */ void m17612a(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.m2504i(16957);
        walletAddAddressUI.asf();
        AppMethodBeat.m2505o(16957);
    }

    /* renamed from: b */
    static /* synthetic */ void m17613b(C38090b c38090b, C38090b c38090b2) {
        AppMethodBeat.m2504i(16962);
        WalletAddAddressUI.m17611a(c38090b, c38090b2);
        AppMethodBeat.m2505o(16962);
    }

    /* renamed from: b */
    static /* synthetic */ void m17614b(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.m2504i(16958);
        walletAddAddressUI.asg();
        AppMethodBeat.m2505o(16958);
    }

    /* renamed from: d */
    static /* synthetic */ void m17616d(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.m2504i(16960);
        walletAddAddressUI.arY();
        AppMethodBeat.m2505o(16960);
    }

    /* renamed from: e */
    static /* synthetic */ boolean m17617e(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.m2504i(16961);
        boolean arW = walletAddAddressUI.arW();
        AppMethodBeat.m2505o(16961);
        return arW;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(16945);
        super.onCreate(bundle);
        C9638aw.m17182Rg().mo14539a(415, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(418, (C1202f) this);
        C4990ab.m7410d("MicroMsg.WalletAddAddressUI", "index Oncreate");
        C4990ab.m7406LZ(0);
        this.gJi = getIntent().getIntExtra("address_id", 0);
        if (this.gJi == 0) {
            setMMTitle((int) C25738R.string.f8733dg);
        } else {
            setMMTitle((int) C25738R.string.f8761e9);
        }
        initView();
        AppMethodBeat.m2505o(16945);
    }

    public final void initView() {
        AppMethodBeat.m2504i(16946);
        C33045a.arS().arT();
        MMScrollView mMScrollView = (MMScrollView) findViewById(2131823366);
        mMScrollView.mo67850a(mMScrollView, mMScrollView);
        this.gKO = (AddrEditView) findViewById(2131828580);
        this.gKP = (AddrEditView) findViewById(2131828582);
        this.gKQ = (AddrEditView) findViewById(2131828583);
        this.gKR = (AddrEditView) findViewById(2131828584);
        this.gKS = (AddrEditView) findViewById(2131828581);
        this.gKO.setOnInputValidChangeListener(this);
        this.gKP.setOnInputValidChangeListener(this);
        this.gKQ.setOnInputValidChangeListener(this);
        this.gKR.setOnInputValidChangeListener(this);
        this.gKS.setOnInputValidChangeListener(this);
        this.gKO.setInfoIvOnClickListener(new C100311());
        this.gKP.setInfoIvOnClickListener(new C100288());
        this.gKP.setOnClickListener(new C100349());
        if (this.gJi != 0) {
            this.gKT = C33045a.arS().mo67843ne(this.gJi);
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
        setBackBtn(new C1003610());
        mo17379a(0, getString(C25738R.string.f9218tc), (OnMenuItemClickListener) new C1003511(), C5535b.GREEN);
        arW();
        AppMethodBeat.m2505o(16946);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(16947);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b(415, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(418, (C1202f) this);
        C42322l arS = C33045a.arS();
        C4990ab.m7416i("MicroMsg.WalletAddrMgr", "clean data");
        for (List clear : arS.gIS.values()) {
            clear.clear();
        }
        for (List clear2 : arS.gIT.values()) {
            clear2.clear();
        }
        arS.gIR.clear();
        arS.gIS.clear();
        arS.gIT.clear();
        AppMethodBeat.m2505o(16947);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(16948);
        String stringExtra;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    stringExtra = intent.getStringExtra("karea_result");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        C4990ab.m7410d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:".concat(String.valueOf(stringExtra)));
                        this.gKP.setValStr(stringExtra);
                    }
                    stringExtra = intent.getStringExtra("kpost_code");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        C4990ab.m7410d("MicroMsg.WalletAddAddressUI", "post:".concat(String.valueOf(stringExtra)));
                        this.gKR.setValStr(stringExtra);
                    }
                    this.cJo = intent.getStringExtra("kwcode");
                    AppMethodBeat.m2505o(16948);
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data == null) {
                        C4990ab.m7410d("MicroMsg.WalletAddAddressUI", "uri == null");
                        AppMethodBeat.m2505o(16948);
                        return;
                    }
                    String str;
                    String[] f = C46482a.m87693f(getBaseContext(), data);
                    if (f == null || f.length != 2) {
                        C30379h.m48461b((Context) this, getString(C25738R.string.f8790f3), "", true);
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
                        AppMethodBeat.m2505o(16948);
                        return;
                    }
                    C30379h.m48461b((Context) this, getString(C25738R.string.f8790f3), "", true);
                    AppMethodBeat.m2505o(16948);
                    return;
                }
                break;
            case 3:
                if (i2 != -1) {
                    C4990ab.m7416i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
                    break;
                }
                Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
                if (addr != null) {
                    C4990ab.m7410d("MicroMsg.WalletAddAddressUI", "addr: " + addr.toString());
                    if (addr != null) {
                        StringBuilder stringBuilder;
                        if (C33045a.arS().mo67849z(addr.fBh, addr.fBj, addr.fBk)) {
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
                        if (!C5046bo.isNullOrNil(addr.fBp) || C5046bo.isNullOrNil(addr.fBg)) {
                            this.gKQ.setValStr(stringBuilder.toString());
                        } else {
                            this.gKQ.setValStr(addr.fBg);
                        }
                        RcptItem y = C33045a.arS().mo67848y(addr.fBh, addr.fBj, addr.fBk);
                        if (y != null) {
                            this.gKR.setValStr(y.gIO);
                            this.cJo = y.code;
                        }
                    }
                }
                AppMethodBeat.m2505o(16948);
                return;
                break;
        }
        AppMethodBeat.m2505o(16948);
    }

    public final int getLayoutId() {
        return 2130971039;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(16949);
        if (this.gII != null) {
            this.gII.dismiss();
        }
        if (i == 0 && i2 == 0) {
            C45505a c45505a = C33045a.arS().gIQ;
            if (c45505a.gIY.size() > 0) {
                WalletAddAddressUI.m17611a(this.gKU, this.gKT);
                C38090b c38090b = (C38090b) c45505a.gIY.getFirst();
                if (c38090b != null) {
                    setResult(-1, C42316a.m74836b(c38090b));
                } else {
                    setResult(0);
                }
            } else {
                setResult(0);
            }
            finish();
            AppMethodBeat.m2505o(16949);
            return;
        }
        switch (i2) {
            case -3104:
            case -3103:
            case -3102:
                C30379h.m48438a((Context) this, str, "", new C1002913());
                AppMethodBeat.m2505o(16949);
                return;
            case -3100:
                C30379h.m48433a((Context) this, (int) C25738R.string.f8732df, 0, false, new C1003712());
                AppMethodBeat.m2505o(16949);
                return;
            default:
                C30379h.m48433a((Context) this, (int) C25738R.string.f8730dd, 0, false, new C1003014());
                AppMethodBeat.m2505o(16949);
                return;
        }
    }

    private boolean arW() {
        boolean z = false;
        AppMethodBeat.m2504i(16950);
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
        AppMethodBeat.m2505o(16950);
        return z;
    }

    public final void arX() {
        AppMethodBeat.m2504i(16951);
        arW();
        AppMethodBeat.m2505o(16951);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(16952);
        if (i == 4) {
            arY();
            AppMethodBeat.m2505o(16952);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(16952);
        return onKeyUp;
    }

    private void arY() {
        int i;
        int i2 = 1;
        AppMethodBeat.m2504i(16953);
        int i3 = C25738R.string.f8736dj;
        if (this.gJi == 0) {
            i3 = C25738R.string.f8735di;
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
            C30379h.m48432a((Context) this, i3, (int) C25738R.string.f9238tz, new C1002715(), null);
            AppMethodBeat.m2505o(16953);
            return;
        }
        setResult(0);
        finish();
        AppMethodBeat.m2505o(16953);
    }

    private void asf() {
        AppMethodBeat.m2504i(16954);
        Intent intent = new Intent("android.intent.action.PICK", Contacts.CONTENT_URI);
        if (C5046bo.m7572k((Context) this, intent)) {
            startActivityForResult(intent, 2);
            AppMethodBeat.m2505o(16954);
            return;
        }
        C4990ab.m7420w("MicroMsg.WalletAddAddressUI", "intent not available");
        AppMethodBeat.m2505o(16954);
    }

    private void asg() {
        AppMethodBeat.m2504i(16955);
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
        C25985d.m41468b((Context) this, C8741b.LOCATION, ".ui.RedirectUI", intent, 3);
        AppMethodBeat.m2505o(16955);
    }

    /* renamed from: a */
    private static void m17611a(C38090b c38090b, C38090b c38090b2) {
        if (c38090b != null && c38090b2 != null) {
            c38090b2.f16139id = c38090b.f16139id;
            c38090b2.gJa = c38090b.gJa;
            c38090b2.gJb = c38090b.gJb;
            c38090b2.gJc = c38090b.gJc;
            c38090b2.gJe = c38090b.gJe;
            c38090b2.gJf = c38090b.gJf;
            c38090b2.gJg = c38090b.gJg;
            c38090b2.gJd = c38090b.gJd;
            c38090b2.gJh = c38090b.gJh;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(16956);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(16956);
            return;
        }
        C4990ab.m7417i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    asf();
                    AppMethodBeat.m2505o(16956);
                    return;
                }
                C30379h.m48445a((Context) this, getString(C25738R.string.dbu), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C100384(), new C20425());
                AppMethodBeat.m2505o(16956);
                return;
            case 64:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C20436(), new C20447());
                    break;
                }
                asg();
                AppMethodBeat.m2505o(16956);
                return;
        }
        AppMethodBeat.m2505o(16956);
    }

    /* renamed from: c */
    static /* synthetic */ void m17615c(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.m2504i(16959);
        walletAddAddressUI.startActivityForResult(new Intent(walletAddAddressUI, WalletMultiRcptSelectUI.class), 1);
        AppMethodBeat.m2505o(16959);
    }

    /* renamed from: o */
    static /* synthetic */ void m17627o(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.m2504i(16963);
        if (walletAddAddressUI.gJi != 0) {
            C4990ab.m7410d("MicroMsg.WalletAddAddressUI", "modify save addr " + walletAddAddressUI.gKU.toString());
            C33045a.arS().arU();
            C9638aw.m17182Rg().mo14541a(new C26686h(walletAddAddressUI.gKU), 0);
            walletAddAddressUI.gII = C30379h.m48458b((Context) walletAddAddressUI, "", true, new C100322());
            AppMethodBeat.m2505o(16963);
            return;
        }
        C4990ab.m7410d("MicroMsg.WalletAddAddressUI", "add save addr " + walletAddAddressUI.gKU.toString());
        C9638aw.m17182Rg().mo14541a(new C42318c(walletAddAddressUI.gKU), 0);
        walletAddAddressUI.gII = C30379h.m48458b((Context) walletAddAddressUI, "", true, new C100333());
        AppMethodBeat.m2505o(16963);
    }
}
