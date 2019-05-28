package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.bind.p1217a.C18797c;
import com.tencent.p177mm.plugin.account.bind.p1217a.C38018a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C16657e;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI */
public class BindLinkedInUI extends MMActivity implements C1202f {
    private String dun;
    private String duo;
    private ProgressDialog fsh;
    private boolean gqJ = false;
    private String gqK;
    private boolean gqL = false;
    private boolean gqM = false;
    private boolean gqN = false;
    private Bundle gqO;
    private boolean gqP = false;
    private boolean gqQ = false;
    private TextView gqR;
    private TextView gqS;
    private View gqT;
    private MMSwitchBtn gqU;
    private TextView gqV;
    private TextView gqW;
    private TextView gqX;
    private String gqY;
    private String gqZ;
    private String gra;
    private String grb;
    private String name;
    private int status;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$6 */
    class C19676 implements OnClickListener {
        C19676() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13390);
            String str = (String) C1720g.m3536RP().mo5239Ry().get(286723, null);
            if (!C5046bo.isNullOrNil(str)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("geta8key_username", C1853r.m3846Yz());
                C25985d.m41467b(BindLinkedInUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(13390);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$13 */
    class C983013 implements C30795a {
        C983013() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(13400);
            BindLinkedInUI.m17488a(BindLinkedInUI.this, z, true);
            AppMethodBeat.m2505o(13400);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$3 */
    class C98313 implements C30795a {
        C98313() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(13389);
            BindLinkedInUI.m17488a(BindLinkedInUI.this, z, true);
            AppMethodBeat.m2505o(13389);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$5 */
    class C98325 implements OnDismissListener {
        C98325() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$12 */
    class C983312 extends ClickableSpan {
        C983312() {
        }

        public final void onClick(View view) {
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(13399);
            textPaint.setColor(BindLinkedInUI.this.getResources().getColor(C25738R.color.f12123t7));
            textPaint.setUnderlineText(false);
            AppMethodBeat.m2505o(13399);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$4 */
    class C98344 implements OnDismissListener {
        C98344() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$7 */
    class C98357 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$7$2 */
        class C98362 implements DialogInterface.OnClickListener {
            C98362() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$7$1 */
        class C98371 implements DialogInterface.OnClickListener {
            C98371() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(13391);
                BindLinkedInUI.m17496e(BindLinkedInUI.this);
                AppMethodBeat.m2505o(13391);
            }
        }

        C98357() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13392);
            if (!BindLinkedInUI.this.gqM) {
                BindLinkedInUI.m17491c(BindLinkedInUI.this);
                AppMethodBeat.m2505o(13392);
            } else if (BindLinkedInUI.this.gqJ) {
                C30379h.m48440a(BindLinkedInUI.this, BindLinkedInUI.this.getString(C25738R.string.ax5), null, new C98371(), new C98362());
                AppMethodBeat.m2505o(13392);
            } else {
                BindLinkedInUI.m17496e(BindLinkedInUI.this);
                AppMethodBeat.m2505o(13392);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$9 */
    class C98389 implements OnClickListener {
        C98389() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13396);
            BindLinkedInUI.m17487a(BindLinkedInUI.this);
            AppMethodBeat.m2505o(13396);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$10 */
    class C983910 implements OnMenuItemClickListener {
        C983910() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13397);
            BindLinkedInUI.m17487a(BindLinkedInUI.this);
            AppMethodBeat.m2505o(13397);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$1 */
    class C98411 implements DialogInterface.OnClickListener {
        C98411() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13387);
            BindLinkedInUI.m17487a(BindLinkedInUI.this);
            AppMethodBeat.m2505o(13387);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$8 */
    class C98428 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$8$2 */
        class C98432 implements DialogInterface.OnClickListener {
            C98432() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$8$1 */
        class C98441 implements DialogInterface.OnClickListener {
            C98441() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(13394);
                final C1207m c18797c = new C18797c();
                BindLinkedInUI.this.fsh = C30379h.m48458b(BindLinkedInUI.this, BindLinkedInUI.this.getString(C25738R.string.cn5), false, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(13393);
                        C1720g.m3540Rg().mo14547c(c18797c);
                        AppMethodBeat.m2505o(13393);
                    }
                });
                C1720g.m3540Rg().mo14541a(c18797c, 0);
                AppMethodBeat.m2505o(13394);
            }
        }

        C98428() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13395);
            C30379h.m48440a(BindLinkedInUI.this, BindLinkedInUI.this.getString(C25738R.string.ax7), null, new C98441(), new C98432());
            AppMethodBeat.m2505o(13395);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI$2 */
    class C98462 implements C30795a {
        C98462() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(13388);
            BindLinkedInUI.m17488a(BindLinkedInUI.this, z, false);
            AppMethodBeat.m2505o(13388);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m17487a(BindLinkedInUI bindLinkedInUI) {
        AppMethodBeat.m2504i(13418);
        bindLinkedInUI.goBack();
        AppMethodBeat.m2505o(13418);
    }

    /* renamed from: a */
    static /* synthetic */ void m17488a(BindLinkedInUI bindLinkedInUI, boolean z, boolean z2) {
        AppMethodBeat.m2504i(13421);
        bindLinkedInUI.m17497m(z, z2);
        AppMethodBeat.m2505o(13421);
    }

    /* renamed from: e */
    static /* synthetic */ void m17496e(BindLinkedInUI bindLinkedInUI) {
        AppMethodBeat.m2504i(13420);
        bindLinkedInUI.m17495dh(false);
        AppMethodBeat.m2505o(13420);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13401);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a((int) JsApiChooseMultiMedia.CTRL_INDEX, (C1202f) this);
        C1720g.m3540Rg().mo14539a((int) C16657e.CTRL_INDEX, (C1202f) this);
        this.gqO = getIntent().getBundleExtra("qrcode_bundle");
        this.gqM = this.gqO != null;
        if (this.gqO != null) {
            this.dun = this.gqO.getString("i");
            this.duo = this.gqO.getString("n");
            this.gqY = this.gqO.getString("t");
            this.gqZ = this.gqO.getString("o");
            this.gra = this.gqO.getString("s");
            this.grb = this.gqO.getString("r");
            if (this.dun == null || this.duo == null || this.gqY == null || this.gra == null || this.grb == null) {
                C30379h.m48448a((Context) this, getString(C25738R.string.ax6), null, false, new C98411());
            }
        }
        this.gqN = getIntent().getBooleanExtra("oversea_entry", false);
        m17485Kh();
        if (this.gqM) {
            this.gqL = true;
        }
        initView();
        if (this.gqO != null && this.gqJ && this.gqK.equals(this.dun)) {
            this.gqP = true;
            m17495dh(true);
        }
        AppMethodBeat.m2505o(13401);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13402);
        C1720g.m3540Rg().mo14546b((int) C16657e.CTRL_INDEX, (C1202f) this);
        C1720g.m3540Rg().mo14546b((int) JsApiChooseMultiMedia.CTRL_INDEX, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(13402);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13403);
        super.onResume();
        AppMethodBeat.m2505o(13403);
    }

    public void onPause() {
        AppMethodBeat.m2504i(13404);
        super.onPause();
        AppMethodBeat.m2505o(13404);
    }

    public final int getLayoutId() {
        return 2130968840;
    }

    /* renamed from: Kh */
    private void m17485Kh() {
        boolean z = true;
        AppMethodBeat.m2504i(13405);
        this.gqK = (String) C1720g.m3536RP().mo5239Ry().get(286721, null);
        this.gqJ = !C5046bo.isNullOrNil(this.gqK);
        this.name = (String) C1720g.m3536RP().mo5239Ry().get(286722, null);
        this.status = C1853r.m3822YD();
        if ((this.status & 4194304) == 0) {
            z = false;
        }
        this.gqL = z;
        AppMethodBeat.m2505o(13405);
    }

    public final void initView() {
        AppMethodBeat.m2504i(13406);
        if (this.gqM) {
            setMMTitle((int) C25738R.string.axf);
        } else if (this.gqN) {
            setMMTitle((int) C25738R.string.axi);
        } else {
            setMMTitle((int) C25738R.string.ax9);
        }
        this.gqR = (TextView) findViewById(2131821756);
        this.gqS = (TextView) findViewById(2131821755);
        this.gqT = findViewById(2131821757);
        this.gqU = (MMSwitchBtn) findViewById(2131821758);
        this.gqV = (TextView) findViewById(2131821759);
        this.gqW = (TextView) findViewById(2131821760);
        this.gqX = (TextView) findViewById(2131821761);
        this.gqR.setOnClickListener(new C19676());
        this.gqV.setOnClickListener(new C98357());
        this.gqW.setOnClickListener(new C98428());
        this.gqX.setOnClickListener(new C98389());
        setBackBtn(new C983910());
        m17492cu();
        AppMethodBeat.m2505o(13406);
    }

    private void goBack() {
        AppMethodBeat.m2504i(13407);
        if (!this.gqM) {
            setResult(-1);
            finish();
            AppMethodBeat.m2505o(13407);
        } else if (this.gqQ) {
            Intent bh = C24679a.gkE.mo38909bh(this);
            bh.addFlags(603979776);
            bh.putExtra("preferred_tab", 2);
            startActivity(bh);
            AppMethodBeat.m2505o(13407);
        } else {
            setResult(-1);
            finish();
            AppMethodBeat.m2505o(13407);
        }
    }

    /* renamed from: dh */
    private void m17495dh(boolean z) {
        AppMethodBeat.m2504i(13408);
        if (this.gqO == null) {
            C4990ab.m7412e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
            AppMethodBeat.m2505o(13408);
            return;
        }
        final C1207m c38018a = new C38018a(this.gqU.zMU ? 1 : 2, this.dun, this.duo, "", this.gqY, this.gqZ, this.gra, this.grb);
        if (!z) {
            this.fsh = C30379h.m48458b((Context) this, getString(C25738R.string.cn5), false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(13398);
                    C1720g.m3540Rg().mo14547c(c38018a);
                    AppMethodBeat.m2505o(13398);
                }
            });
        }
        C1720g.m3540Rg().mo14541a(c38018a, 0);
        AppMethodBeat.m2505o(13408);
    }

    /* renamed from: vK */
    private void m17498vK(String str) {
        AppMethodBeat.m2504i(13409);
        int indexOf = getString(C25738R.string.ax3).indexOf("%s");
        Spannable newSpannable = Factory.getInstance().newSpannable(getString(C25738R.string.ax3, new Object[]{str}));
        newSpannable.setSpan(new C983312(), indexOf, str.length() + indexOf, 33);
        this.gqR.setText(newSpannable);
        AppMethodBeat.m2505o(13409);
    }

    /* renamed from: d */
    private void m17493d(boolean z, String str, boolean z2) {
        AppMethodBeat.m2504i(13410);
        this.gqR.setVisibility(0);
        m17498vK(str);
        this.gqT.setVisibility(0);
        this.gqW.setVisibility(8);
        if (z) {
            this.gqS.setVisibility(8);
            this.gqV.setVisibility(8);
            this.gqX.setVisibility(8);
            this.gqU.setCheck(z2);
            this.gqU.setSwitchListener(new C983013());
            AppMethodBeat.m2505o(13410);
            return;
        }
        this.gqS.setVisibility(0);
        this.gqV.setVisibility(0);
        this.gqX.setVisibility(0);
        this.gqU.setCheck(z2);
        this.gqU.setSwitchListener(new C98462());
        AppMethodBeat.m2505o(13410);
    }

    /* renamed from: a */
    private void m17489a(boolean z, boolean z2, String str, boolean z3) {
        AppMethodBeat.m2504i(13411);
        this.gqX.setVisibility(8);
        if (z) {
            this.gqS.setVisibility(8);
            this.gqR.setVisibility(0);
            m17498vK(str);
            this.gqT.setVisibility(0);
            this.gqV.setVisibility(8);
            if (z2) {
                this.gqW.setVisibility(0);
            }
            this.gqU.setCheck(z3);
            this.gqU.setSwitchListener(new C98313());
            AppMethodBeat.m2505o(13411);
            return;
        }
        this.gqR.setVisibility(8);
        this.gqR.setText(getString(C25738R.string.ax4));
        this.gqS.setVisibility(0);
        this.gqT.setVisibility(8);
        this.gqV.setVisibility(0);
        this.gqW.setVisibility(8);
        AppMethodBeat.m2505o(13411);
    }

    /* renamed from: cu */
    private void m17492cu() {
        boolean z = true;
        AppMethodBeat.m2504i(13412);
        if (this.gqM && this.gqO == null) {
            C4990ab.m7412e("MicroMsg.BindLinkedInUI", "bindBundle is null");
            AppMethodBeat.m2505o(13412);
        } else if (this.gqN) {
            m17489a(this.gqJ, false, this.name, this.gqL);
            AppMethodBeat.m2505o(13412);
        } else if (this.gqM) {
            if (!(this.gqJ && this.gqK.equals(this.dun))) {
                z = false;
            }
            m17493d(z, this.duo, this.gqL);
            AppMethodBeat.m2505o(13412);
        } else {
            m17489a(this.gqJ, true, this.name, this.gqL);
            AppMethodBeat.m2505o(13412);
        }
    }

    /* renamed from: m */
    private void m17497m(boolean z, boolean z2) {
        AppMethodBeat.m2504i(13413);
        if (z) {
            this.status |= 4194304;
        } else {
            this.status &= -4194305;
        }
        int i = z ? 1 : 2;
        C1720g.m3536RP().mo5239Ry().set(7, Integer.valueOf(this.status));
        if (z2) {
            act act = new act();
            act.wkw = 33;
            act.pvD = i;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(23, act));
            C24679a.gkF.mo38844BS();
        }
        AppMethodBeat.m2505o(13413);
    }

    /* renamed from: w */
    private boolean m17499w(Intent intent) {
        AppMethodBeat.m2504i(13414);
        Bundle bundleExtra = intent.getBundleExtra("result_data");
        String string = bundleExtra.getString("ret");
        Object string2 = bundleExtra.getString("limid");
        Object string3 = bundleExtra.getString("liname");
        Object string4 = bundleExtra.getString("liurl");
        String string5 = bundleExtra.getString("liswitch");
        if (C5046bo.isNullOrNil(string)) {
            C4990ab.m7412e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
            AppMethodBeat.m2505o(13414);
            return false;
        }
        int ank = C5046bo.ank(string);
        if (ank != 0) {
            int i;
            C4990ab.m7413e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", Integer.valueOf(ank));
            if (ank == 1) {
                i = C25738R.string.axd;
            } else {
                i = C25738R.string.axc;
            }
            C30379h.m48461b((Context) this, getString(i), null, true);
            AppMethodBeat.m2505o(13414);
            return false;
        } else if (C5046bo.isNullOrNil(string2)) {
            C4990ab.m7412e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
            AppMethodBeat.m2505o(13414);
            return false;
        } else {
            C4990ab.m7411d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", string2, string3, string4, string5);
            C1720g.m3536RP().mo5239Ry().set(286722, string3);
            C1720g.m3536RP().mo5239Ry().set(286721, string2);
            C1720g.m3536RP().mo5239Ry().set(286723, string4);
            if (!C5046bo.isNullOrNil(string5)) {
                m17497m(C5046bo.ank(string5) == 1, false);
            }
            m17485Kh();
            m17492cu();
            string5 = getString(C25738R.string.ax_);
            C98344 c98344 = new C98344();
            C30379h.m48465bQ(this, string5);
            AppMethodBeat.m2505o(13414);
            return true;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(13415);
        C4990ab.m7410d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (intent == null) {
            AppMethodBeat.m2505o(13415);
            return;
        }
        switch (i) {
            case 100:
                m17499w(intent);
                AppMethodBeat.m2505o(13415);
                return;
            default:
                C4990ab.m7412e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
                AppMethodBeat.m2505o(13415);
                return;
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(13416);
        if (this.fsh != null) {
            this.fsh.dismiss();
            this.fsh = null;
        }
        int i3;
        if (i == 0 && i2 == 0) {
            if (c1207m.getType() == JsApiChooseMultiMedia.CTRL_INDEX) {
                this.gqQ = true;
                if (this.gqP) {
                    i3 = C25738R.string.axa;
                } else {
                    i3 = C25738R.string.ax_;
                }
            } else if (c1207m.getType() == C16657e.CTRL_INDEX) {
                i3 = C25738R.string.axk;
            } else {
                AppMethodBeat.m2505o(13416);
                return;
            }
            String string = getString(i3);
            C98325 c98325 = new C98325();
            C30379h.m48465bQ(this, string);
            m17485Kh();
            this.gqL = this.gqU.zMU;
            m17492cu();
            AppMethodBeat.m2505o(13416);
            return;
        }
        if (c1207m.getType() == JsApiChooseMultiMedia.CTRL_INDEX) {
            if (i2 == 1) {
                i3 = C25738R.string.axd;
            } else {
                i3 = C25738R.string.axc;
            }
        } else if (c1207m.getType() == C16657e.CTRL_INDEX) {
            i3 = C25738R.string.axe;
        } else {
            AppMethodBeat.m2505o(13416);
            return;
        }
        C30379h.m48461b((Context) this, getString(i3), null, true);
        AppMethodBeat.m2505o(13416);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(13417);
        if (i == 4) {
            goBack();
            AppMethodBeat.m2505o(13417);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(13417);
        return onKeyDown;
    }

    /* renamed from: c */
    static /* synthetic */ void m17491c(BindLinkedInUI bindLinkedInUI) {
        AppMethodBeat.m2504i(13419);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "http://www.linkedin.com/bind/plugin/");
        intent.putExtra("geta8key_username", C1853r.m3846Yz());
        if (bindLinkedInUI.gqN) {
            intent.putExtra("geta8key_scene", 3);
        } else {
            intent.putExtra("geta8key_scene", 8);
        }
        C25985d.m41468b((Context) bindLinkedInUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 100);
        AppMethodBeat.m2505o(13419);
    }
}
