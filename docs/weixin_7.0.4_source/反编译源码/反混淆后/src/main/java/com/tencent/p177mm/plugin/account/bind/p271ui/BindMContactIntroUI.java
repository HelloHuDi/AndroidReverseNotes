package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsimple.C9706r;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1179au.C17950b.C17951a;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32647tt;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.friend.p272a.C32970y;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.account.friend.p272a.C38037x;
import com.tencent.p177mm.plugin.account.friend.p273ui.C6725i;
import com.tencent.p177mm.plugin.account.friend.p273ui.C6725i.C6726a;
import com.tencent.p177mm.plugin.account.friend.p273ui.C6725i.C6727b;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI */
public class BindMContactIntroUI extends MMWizardActivity implements C1202f {
    private String cFl;
    private boolean gqB = false;
    private ImageView gri;
    private TextView grj;
    private TextView grk;
    private Button grl;
    private Button grm;
    private C38034a grn;
    private C6725i gro;
    private String grp = null;
    private String grq = null;
    private int grr;
    private int grs = 0;
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$1 */
    class C19681 implements OnClickListener {
        C19681() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13422);
            BindMContactIntroUI.m25436a(BindMContactIntroUI.this);
            AppMethodBeat.m2505o(13422);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$4 */
    class C19694 implements DialogInterface.OnClickListener {
        C19694() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$14 */
    class C984714 implements DialogInterface.OnClickListener {
        C984714() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$16 */
    class C984816 implements DialogInterface.OnClickListener {
        C984816() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$17 */
    class C984917 implements DialogInterface.OnClickListener {
        C984917() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$2 */
    class C98512 implements DialogInterface.OnClickListener {
        C98512() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13423);
            Intent intent = new Intent();
            intent.putExtra("kintent_hint", BindMContactIntroUI.this.getString(C25738R.string.ecb));
            intent.putExtra("from_unbind", true);
            C25985d.m41468b(BindMContactIntroUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
            AppMethodBeat.m2505o(13423);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$3 */
    class C98523 implements DialogInterface.OnClickListener {
        C98523() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$21 */
    class C1654521 implements OnMenuItemClickListener {
        C1654521() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13429);
            BindMContactIntroUI.m25438c(BindMContactIntroUI.this);
            AppMethodBeat.m2505o(13429);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$22 */
    class C1654622 implements OnMenuItemClickListener {
        C1654622() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13430);
            BindMContactIntroUI.m25438c(BindMContactIntroUI.this);
            AppMethodBeat.m2505o(13430);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$9 */
    class C165479 implements DialogInterface.OnClickListener {
        C165479() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$15 */
    class C1654815 implements DialogInterface.OnClickListener {
        C1654815() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$18 */
    class C1654918 implements Runnable {
        C1654918() {
        }

        public final void run() {
            AppMethodBeat.m2504i(13427);
            if (C38033l.apQ()) {
                BindMContactIntroUI.apa();
                BindMContactIntroUI.this.grl.setText(BindMContactIntroUI.this.getString(C25738R.string.a6s));
                BindMContactIntroUI.this.grn = C38034a.SUCC;
                boolean a = C5046bo.m7517a((Boolean) C1720g.m3536RP().mo5239Ry().get(12322, Boolean.FALSE), false);
                if (BindMContactIntroUI.this.gqB && a) {
                    C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(3), Integer.valueOf(3));
                }
            }
            AppMethodBeat.m2505o(13427);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$12 */
    class C1655012 implements OnClickListener {
        C1655012() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13426);
            BindMContactIntroUI.m25437b(BindMContactIntroUI.this);
            AppMethodBeat.m2505o(13426);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$19 */
    class C1655119 implements OnCancelListener {
        C1655119() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$6 */
    class C165536 implements DialogInterface.OnClickListener {
        C165536() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$8 */
    class C165548 implements DialogInterface.OnClickListener {
        C165548() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$11 */
    class C1655611 implements DialogInterface.OnClickListener {
        C1655611() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13425);
            Intent intent = new Intent();
            intent.putExtra("kintent_hint", BindMContactIntroUI.this.getString(C25738R.string.ecb));
            intent.putExtra("from_unbind", true);
            C25985d.m41468b(BindMContactIntroUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
            AppMethodBeat.m2505o(13425);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$24 */
    class C1656024 implements DialogInterface.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$24$1 */
        class C165611 implements OnCancelListener {
            C165611() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }

        C1656024() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13434);
            if (BindMContactIntroUI.this.cFl == null || BindMContactIntroUI.this.cFl.equals("")) {
                AppMethodBeat.m2505o(13434);
                return;
            }
            C1720g.m3540Rg().mo14541a(new C32970y(C32970y.gvW), 0);
            BindMContactIntroUI bindMContactIntroUI = BindMContactIntroUI.this;
            Context context = BindMContactIntroUI.this;
            BindMContactIntroUI.this.getString(C25738R.string.f9238tz);
            bindMContactIntroUI.tipDialog = C30379h.m48458b(context, BindMContactIntroUI.this.getString(C25738R.string.f9160rd), true, new C165611());
            AppMethodBeat.m2505o(13434);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$13 */
    class C1656213 implements DialogInterface.OnClickListener {
        C1656213() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$26 */
    class C1656326 implements DialogInterface.OnClickListener {
        C1656326() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13436);
            MMWizardActivity.m23791J(BindMContactIntroUI.this, new Intent(BindMContactIntroUI.this, BindMContactStatusUI.class));
            AppMethodBeat.m2505o(13436);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$5 */
    class C165645 implements DialogInterface.OnClickListener {
        C165645() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$7 */
    class C165657 implements DialogInterface.OnClickListener {
        C165657() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: c */
    static /* synthetic */ void m25438c(BindMContactIntroUI bindMContactIntroUI) {
        AppMethodBeat.m2504i(13450);
        bindMContactIntroUI.aoZ();
        AppMethodBeat.m2505o(13450);
    }

    public final int getLayoutId() {
        return 2130968842;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13438);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a(132, (C1202f) this);
        C1720g.m3540Rg().mo14539a(255, (C1202f) this);
        C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_ZIPAI_LIGHTRED, (C1202f) this);
        setMMTitle((int) C25738R.string.a7a);
        AppMethodBeat.m2505o(13438);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13439);
        C1720g.m3540Rg().mo14546b(132, (C1202f) this);
        C1720g.m3540Rg().mo14546b(255, (C1202f) this);
        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_ZIPAI_LIGHTRED, (C1202f) this);
        if (this.gro != null) {
            this.gro.recycle();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(13439);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13440);
        super.onResume();
        initView();
        AppMethodBeat.m2505o(13440);
    }

    public final void initView() {
        AppMethodBeat.m2504i(13441);
        this.grr = getIntent().getIntExtra("bind_scene", 0);
        this.gqB = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.grs = getIntent().getIntExtra("key_upload_scene", 0);
        this.grn = C38033l.apS();
        C4990ab.m7410d("MicroMsg.BindMContactIntroUI", "state " + this.grn);
        this.cFl = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        if (this.cFl == null || this.cFl.equals("")) {
            this.cFl = (String) C1720g.m3536RP().mo5239Ry().get(4097, null);
        }
        this.gri = (ImageView) findViewById(2131821763);
        this.grj = (TextView) findViewById(2131821764);
        this.grk = (TextView) findViewById(2131821765);
        this.grl = (Button) findViewById(2131821766);
        this.grm = (Button) findViewById(2131821767);
        this.grl.setOnClickListener(new C19681());
        this.grm.setOnClickListener(new C1655012());
        if (getIntent().getBooleanExtra("skip", false)) {
            addTextOptionMenu(0, getString(C25738R.string.f9154r7), new C1654521());
        } else {
            setBackBtn(new C1654622());
        }
        if (this.grn == C38034a.SUCC_UNLOAD || this.grn == C38034a.SUCC) {
            String value = C26373g.m41964Nu().getValue("ShowUnbindPhone");
            int i = 2;
            if (!C5046bo.isNullOrNil(value)) {
                i = C5046bo.ank(value);
            }
            if (i != 0) {
                addIconOptionMenu(1, C25738R.drawable.f6899uu, new OnMenuItemClickListener() {

                    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$23$1 */
                    class C165581 implements C36073c {
                        C165581() {
                        }

                        /* renamed from: a */
                        public final void mo5746a(C44273l c44273l) {
                            AppMethodBeat.m2504i(13431);
                            c44273l.setHeaderTitle((int) C25738R.string.a6z);
                            if ((i & 2) != 0) {
                                c44273l.mo70072hi(0, C25738R.string.a7h);
                            }
                            if ((i & 1) != 0) {
                                c44273l.mo70072hi(1, C25738R.string.a6e);
                            }
                            AppMethodBeat.m2505o(13431);
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI$23$2 */
                    class C165592 implements C5279d {
                        C165592() {
                        }

                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.m2504i(13432);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    BindMContactIntroUI.m25440d(BindMContactIntroUI.this);
                                    AppMethodBeat.m2505o(13432);
                                    return;
                                case 1:
                                    Intent intent = new Intent();
                                    intent.putExtra("need_matte_high_light_item", "settings_find_me_by_mobile");
                                    C25985d.m41467b(BindMContactIntroUI.this, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                                    break;
                            }
                            AppMethodBeat.m2505o(13432);
                        }
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.m2504i(13433);
                        C46696j c46696j = new C46696j(BindMContactIntroUI.this.mController.ylL);
                        c46696j.rBl = new C165581();
                        c46696j.rBm = new C165592();
                        c46696j.cuu();
                        AppMethodBeat.m2505o(13433);
                        return false;
                    }
                });
            }
        }
        m25439cu();
        AppMethodBeat.m2505o(13441);
    }

    /* renamed from: cu */
    private void m25439cu() {
        AppMethodBeat.m2504i(13442);
        switch (this.grn) {
            case NO_INIT:
                showOptionMenu(1, false);
                this.gri.setImageResource(C1318a.mobile_unbind_icon);
                this.grk.setVisibility(0);
                this.grm.setVisibility(8);
                this.grj.setText(C25738R.string.a6u);
                this.grk.setText(C25738R.string.a6t);
                this.grl.setText(C25738R.string.a65);
                AppMethodBeat.m2505o(13442);
                return;
            case SET_MOBILE:
                showOptionMenu(1, false);
                this.gri.setImageResource(C1318a.mobile_unbind_icon);
                this.grk.setVisibility(0);
                this.grm.setVisibility(0);
                this.grj.setText(String.format(getString(C25738R.string.a7v), new Object[]{this.cFl}));
                this.grk.setText(C25738R.string.a7l);
                this.grl.setText(C25738R.string.a7p);
                this.grm.setText(C25738R.string.a6f);
                AppMethodBeat.m2505o(13442);
                return;
            case SUCC_UNLOAD:
                showOptionMenu(1, true);
                this.gri.setImageResource(C1318a.mobile_binded_icon);
                this.grk.setVisibility(0);
                this.grm.setVisibility(0);
                this.grj.setText(String.format(getString(C25738R.string.a7v), new Object[]{this.cFl}));
                this.grk.setText(C25738R.string.a6b);
                this.grl.setText(C25738R.string.a7m);
                this.grm.setText(C25738R.string.a6d);
                AppMethodBeat.m2505o(13442);
                return;
            case SUCC:
                showOptionMenu(1, true);
                this.gri.setImageResource(C1318a.mobile_binded_icon);
                this.grk.setVisibility(0);
                this.grm.setVisibility(0);
                this.grj.setText(String.format(getString(C25738R.string.a7v), new Object[]{this.cFl}));
                this.grk.setText(C25738R.string.a6b);
                this.grl.setText(C25738R.string.a6s);
                this.grm.setText(C25738R.string.a6d);
                break;
        }
        AppMethodBeat.m2505o(13442);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(13443);
        if (i == 4) {
            aoZ();
            AppMethodBeat.m2505o(13443);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(13443);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.m2504i(13444);
        aqX();
        if (this.grr == 2) {
            cancel();
            finish();
            AppMethodBeat.m2505o(13444);
            return;
        }
        mo27541Ni(1);
        AppMethodBeat.m2505o(13444);
    }

    /* renamed from: dj */
    private void m25441dj(boolean z) {
        AppMethodBeat.m2504i(13445);
        Intent intent = new Intent(this, BindMContactUI.class);
        if (z) {
            intent.putExtra("bind_scene", 3);
        } else {
            intent.putExtra("bind_scene", 0);
        }
        String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
        if (!C5046bo.isNullOrNil(simCountryIso)) {
            C17951a k = C17950b.m28210k(this, simCountryIso, getString(C25738R.string.b3_));
            if (k != null) {
                intent.putExtra("country_name", k.fHE);
                intent.putExtra("couttry_code", k.fHD);
            }
        }
        MMWizardActivity.m23791J(this, intent);
        AppMethodBeat.m2505o(13445);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(13446);
        C4990ab.m7416i("MicroMsg.BindMContactIntroUI", "summerunbind onSceneEnd type: " + c1207m.getType() + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (c1207m.getType() == 132 && i == 0 && i2 == 0) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (((C38037x) c1207m).mo60786Ah() == 3) {
                ((C7599a) C1720g.m3530M(C7599a.class)).removeSelfAccount(this);
                if (C5046bo.isNullOrNil(this.grq)) {
                    MMWizardActivity.m23791J(this, new Intent(this, BindMContactStatusUI.class));
                } else {
                    C30379h.m48443a((Context) this, this.grq, "", getString(C25738R.string.f9151r4), new C1656326());
                    AppMethodBeat.m2505o(13446);
                    return;
                }
            }
            AppMethodBeat.m2505o(13446);
            return;
        }
        Object obj;
        if (!C24679a.gkF.mo38859a((Context) this, i, i2, str)) {
            obj = null;
            switch (i2) {
                case -214:
                    C42124a jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        jY.mo67668a(this, null, null);
                    }
                    obj = 1;
                    break;
                case -43:
                    Toast.makeText(this, C25738R.string.a6h, 0).show();
                    obj = 1;
                    break;
                case -41:
                    Toast.makeText(this, C25738R.string.a6j, 0).show();
                    obj = 1;
                    break;
                case -36:
                    Toast.makeText(this, C25738R.string.a6m, 0).show();
                    obj = 1;
                    break;
                case -35:
                    Toast.makeText(this, C25738R.string.a6i, 0).show();
                    obj = 1;
                    break;
                case -34:
                    Toast.makeText(this, C25738R.string.a6k, 0).show();
                    obj = 1;
                    break;
            }
        }
        obj = 1;
        if (obj != null) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            AppMethodBeat.m2505o(13446);
            return;
        }
        final C1207m c38037x;
        Context context;
        if (c1207m.getType() == C31128d.MIC_PTU_ZIPAI_LIGHTRED) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i == 0 && i2 == 0) {
                this.grq = ((C32970y) c1207m).aqe().vZs;
                this.grp = ((C32970y) c1207m).aqd();
                if (C5046bo.isNullOrNil(this.grq)) {
                    C1720g.m3540Rg().mo14541a(new C9706r(2), 0);
                    AppMethodBeat.m2505o(13446);
                    return;
                }
                c38037x = new C38037x(this.cFl, 3, "", 0, "");
                C1720g.m3540Rg().mo14541a(c38037x, 0);
                context = this.mController.ylL;
                getString(C25738R.string.f9238tz);
                this.tipDialog = C30379h.m48458b(context, getString(C25738R.string.a7k), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(13437);
                        C1720g.m3540Rg().mo14547c(c38037x);
                        AppMethodBeat.m2505o(13437);
                    }
                });
                AppMethodBeat.m2505o(13446);
                return;
            } else if (i2 == -3) {
                C4990ab.m7410d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                C30379h.m48445a(this.mController.ylL, getString(C25738R.string.ecd), null, getString(C25738R.string.ece), getString(C25738R.string.ecc), true, new C98512(), new C98523());
            } else if (i2 == -81) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4q, (int) C25738R.string.f9238tz, new C19694());
            } else if (i2 == -82) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4r, (int) C25738R.string.f9238tz, new C165645());
            } else if (i2 == -83) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4o, (int) C25738R.string.f9238tz, new C165536());
            } else if (i2 == -84) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4p, (int) C25738R.string.f9238tz, new C165657());
            } else if (i2 == -85) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4l, (int) C25738R.string.f9238tz, new C165548());
            } else if (i2 == -86) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4t, (int) C25738R.string.f9238tz, new C165479());
            }
        }
        if (c1207m.getType() == 255) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i2 == 0) {
                c38037x = new C38037x(this.cFl, 3, "", 0, "");
                C1720g.m3540Rg().mo14541a(c38037x, 0);
                context = this.mController.ylL;
                getString(C25738R.string.f9238tz);
                this.tipDialog = C30379h.m48458b(context, getString(C25738R.string.a7k), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(13424);
                        C1720g.m3540Rg().mo14547c(c38037x);
                        AppMethodBeat.m2505o(13424);
                    }
                });
            } else {
                C4990ab.m7416i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
                C30379h.m48445a(this.mController.ylL, getString(C25738R.string.ecd), null, getString(C25738R.string.ece), getString(C25738R.string.ecc), true, new C1655611(), new C1656213());
            }
        }
        if (c1207m.getType() == 132) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (((C38037x) c1207m).mo60786Ah() == 3) {
                if (i2 == -82) {
                    C30379h.m48431a((Context) this, (int) C25738R.string.e4r, (int) C25738R.string.f9238tz, new C984714());
                    AppMethodBeat.m2505o(13446);
                    return;
                } else if (i2 == -83) {
                    C30379h.m48431a((Context) this, (int) C25738R.string.e4o, (int) C25738R.string.f9238tz, new C1654815());
                    AppMethodBeat.m2505o(13446);
                    return;
                } else if (i2 == -84) {
                    C30379h.m48431a((Context) this, (int) C25738R.string.e4p, (int) C25738R.string.f9238tz, new C984816());
                    AppMethodBeat.m2505o(13446);
                    return;
                } else if (i2 == -85) {
                    C30379h.m48431a((Context) this, (int) C25738R.string.e4l, (int) C25738R.string.f9238tz, new C984917());
                    AppMethodBeat.m2505o(13446);
                    return;
                } else {
                    Toast.makeText(this, getString(C25738R.string.a7g, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        }
        AppMethodBeat.m2505o(13446);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(13447);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7411d("MicroMsg.BindMContactIntroUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    C4990ab.m7416i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.cFl);
                    C1720g.m3540Rg().mo14541a(new C32970y(C32970y.gvW), 0);
                    getString(C25738R.string.f9238tz);
                    this.tipDialog = C30379h.m48458b((Context) this, getString(C25738R.string.f9160rd), true, new C1655119());
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(13447);
    }

    /* renamed from: a */
    static /* synthetic */ void m25436a(BindMContactIntroUI bindMContactIntroUI) {
        boolean z = false;
        AppMethodBeat.m2504i(13448);
        switch (bindMContactIntroUI.grn) {
            case NO_INIT:
                bindMContactIntroUI.m25441dj(false);
                AppMethodBeat.m2505o(13448);
                return;
            case SET_MOBILE:
                final String str = bindMContactIntroUI.cFl;
                if (bindMContactIntroUI.gro == null) {
                    bindMContactIntroUI.gro = new C6725i(C6727b.BINDMOBILE, bindMContactIntroUI, new C6726a() {
                        /* renamed from: e */
                        public final void mo14957e(int i, Bundle bundle) {
                            AppMethodBeat.m2504i(13435);
                            Intent intent;
                            if (i == 2) {
                                if (BindMContactIntroUI.this.grr == 1) {
                                    if (!C1853r.m3826YH()) {
                                        C32647tt c32647tt = new C32647tt();
                                        c32647tt.cPS.cPT = true;
                                        c32647tt.cPS.cPU = true;
                                        C4879a.xxA.mo10055m(c32647tt);
                                    }
                                    BindMContactIntroUI.m25444g(BindMContactIntroUI.this);
                                    intent = new Intent();
                                    intent.addFlags(67108864);
                                    C24679a.gkE.mo38916e(BindMContactIntroUI.this, intent);
                                    AppMethodBeat.m2505o(13435);
                                    return;
                                }
                                MMWizardActivity.m23791J(BindMContactIntroUI.this, new Intent(BindMContactIntroUI.this, BindMContactStatusUI.class).putExtra("bind_scene", BindMContactIntroUI.this.grr));
                                if (BindMContactIntroUI.this.gqB) {
                                    if (BindMContactIntroUI.this.grr == 2) {
                                        C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(3), Integer.valueOf(3));
                                        AppMethodBeat.m2505o(13435);
                                        return;
                                    }
                                    C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(1), Integer.valueOf(2));
                                    AppMethodBeat.m2505o(13435);
                                    return;
                                }
                            } else if (i == 1) {
                                intent = new Intent(BindMContactIntroUI.this, BindMContactVerifyUI.class);
                                intent.putExtra("bindmcontact_mobile", str);
                                intent.putExtra("bind_scene", BindMContactIntroUI.this.grr);
                                intent.putExtra("KEnterFromBanner", BindMContactIntroUI.this.gqB);
                                MMWizardActivity.m23791J(BindMContactIntroUI.this, intent);
                            }
                            AppMethodBeat.m2505o(13435);
                        }
                    });
                }
                C6725i c6725i = bindMContactIntroUI.gro;
                if (bindMContactIntroUI.grr == 0 || bindMContactIntroUI.grr == 3) {
                    z = true;
                }
                c6725i.gys = z;
                bindMContactIntroUI.gro.mo14956wn(str);
                AppMethodBeat.m2505o(13448);
                return;
            case SUCC_UNLOAD:
                C1720g.m3536RP().mo5239Ry().set(12322, Boolean.FALSE);
                ((C7599a) C1720g.m3530M(C7599a.class)).showAddrBookUploadConfirm(bindMContactIntroUI, new C1654918(), true, bindMContactIntroUI.grs);
                break;
            case SUCC:
                bindMContactIntroUI.startActivity(new Intent(bindMContactIntroUI, MobileFriendUI.class));
                AppMethodBeat.m2505o(13448);
                return;
        }
        AppMethodBeat.m2505o(13448);
    }

    /* renamed from: b */
    static /* synthetic */ void m25437b(BindMContactIntroUI bindMContactIntroUI) {
        AppMethodBeat.m2504i(13449);
        switch (bindMContactIntroUI.grn) {
            case NO_INIT:
                AppMethodBeat.m2505o(13449);
                return;
            case SET_MOBILE:
                C38033l.apT();
                bindMContactIntroUI.initView();
                AppMethodBeat.m2505o(13449);
                return;
            case SUCC_UNLOAD:
                bindMContactIntroUI.m25441dj(true);
                break;
            case SUCC:
                bindMContactIntroUI.m25441dj(true);
                AppMethodBeat.m2505o(13449);
                return;
        }
        AppMethodBeat.m2505o(13449);
    }

    /* renamed from: d */
    static /* synthetic */ void m25440d(BindMContactIntroUI bindMContactIntroUI) {
        AppMethodBeat.m2504i(13451);
        C30379h.m48466d(bindMContactIntroUI.mController.ylL, bindMContactIntroUI.getString(C25738R.string.a7e), bindMContactIntroUI.getString(C25738R.string.a7f), bindMContactIntroUI.getString(C25738R.string.f9076or), bindMContactIntroUI.getString(C25738R.string.a7d), null, new C1656024());
        AppMethodBeat.m2505o(13451);
    }

    /* renamed from: g */
    static /* synthetic */ void m25444g(BindMContactIntroUI bindMContactIntroUI) {
        AppMethodBeat.m2504i(13452);
        bindMContactIntroUI.mo27541Ni(1);
        AppMethodBeat.m2505o(13452);
    }

    static /* synthetic */ void apa() {
        AppMethodBeat.m2504i(13453);
        int YD = C1853r.m3822YD();
        C38033l.apP();
        C1720g.m3536RP().mo5239Ry().set(7, Integer.valueOf(YD & -131073));
        C24679a.gkF.mo38844BS();
        AppMethodBeat.m2505o(13453);
    }
}
