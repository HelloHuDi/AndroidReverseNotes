package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsimple.BindWordingContent;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18288hy;
import com.tencent.p177mm.p230g.p231a.C32647tt;
import com.tencent.p177mm.p230g.p231a.C6494hz;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.account.friend.p272a.C38037x;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI */
public class BindMobileVerifyUI extends MMWizardActivity implements C1202f {
    private String cFl;
    private int fromScene;
    private EditText grL;
    private Button grN;
    private BindWordingContent grY;
    private int grZ;
    private boolean gsa;
    private boolean gsb;
    private TextView gsq;
    private TextView gsr;
    private Integer gss = Integer.valueOf(15);
    private Timer mTimer;
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI$2 */
    class C67082 implements OnMenuItemClickListener {
        C67082() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13530);
            String trim = BindMobileVerifyUI.this.grL.getText().toString().trim();
            if (trim.equals("")) {
                C30379h.m48467g(BindMobileVerifyUI.this, C25738R.string.a7z, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(13530);
            } else {
                BindMobileVerifyUI.this.aqX();
                C18288hy c18288hy = new C18288hy();
                c18288hy.cCS.context = BindMobileVerifyUI.this;
                C4879a.xxA.mo10055m(c18288hy);
                String str = c18288hy.cCT.cCU;
                C6494hz c6494hz = new C6494hz();
                C4879a.xxA.mo10055m(c6494hz);
                final C1207m c38037x = new C38037x(BindMobileVerifyUI.this.cFl, 2, trim, "", str, c6494hz.cCV.cCW);
                C1720g.m3540Rg().mo14541a(c38037x, 0);
                BindMobileVerifyUI bindMobileVerifyUI = BindMobileVerifyUI.this;
                Context context = BindMobileVerifyUI.this;
                BindMobileVerifyUI.this.getString(C25738R.string.f9238tz);
                bindMobileVerifyUI.tipDialog = C30379h.m48458b(context, BindMobileVerifyUI.this.getString(C25738R.string.a7n), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(13529);
                        C1720g.m3540Rg().mo14547c(c38037x);
                        AppMethodBeat.m2505o(13529);
                    }
                });
                AppMethodBeat.m2505o(13530);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI$3 */
    class C67103 implements OnMenuItemClickListener {
        C67103() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13531);
            BindMobileVerifyUI.this.finish();
            AppMethodBeat.m2505o(13531);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI$4 */
    class C67114 implements OnClickListener {
        C67114() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13532);
            BindMobileVerifyUI.this.aqX();
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("bindmcontact_mobile", BindMobileVerifyUI.this.cFl);
            bundle.putInt("voice_verify_type", 4);
            intent.putExtras(bundle);
            C24679a.gkE.mo38918f(BindMobileVerifyUI.this, intent);
            AppMethodBeat.m2505o(13532);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI$6 */
    class C67126 implements Runnable {
        C67126() {
        }

        public final void run() {
            AppMethodBeat.m2504i(13534);
            BindMobileVerifyUI.this.gss;
            BindMobileVerifyUI.this.gss = Integer.valueOf(BindMobileVerifyUI.this.gss.intValue() - 1);
            if (BindMobileVerifyUI.this.gss.intValue() > 0) {
                BindMobileVerifyUI.this.gsr.setText(BindMobileVerifyUI.this.getResources().getQuantityString(C25738R.plurals.f9607t, BindMobileVerifyUI.this.gss.intValue(), new Object[]{BindMobileVerifyUI.this.gss}));
                AppMethodBeat.m2505o(13534);
                return;
            }
            BindMobileVerifyUI.this.gsr.setText(BindMobileVerifyUI.this.getResources().getQuantityString(C25738R.plurals.f9607t, 0, new Object[]{Integer.valueOf(0)}));
            BindMobileVerifyUI.m11142f(BindMobileVerifyUI.this);
            AppMethodBeat.m2505o(13534);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI$5 */
    class C67135 extends TimerTask {
        C67135() {
        }

        public final void run() {
            AppMethodBeat.m2504i(13533);
            if (BindMobileVerifyUI.this.gsr != null) {
                BindMobileVerifyUI.m11140d(BindMobileVerifyUI.this);
            }
            AppMethodBeat.m2505o(13533);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI$1 */
    class C67141 implements InputFilter {
        C67141() {
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AppMethodBeat.m2504i(13528);
            CharSequence ad = C5046bo.m7520ad(charSequence);
            AppMethodBeat.m2505o(13528);
            return ad;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BindMobileVerifyUI() {
        AppMethodBeat.m2504i(13535);
        AppMethodBeat.m2505o(13535);
    }

    /* renamed from: f */
    static /* synthetic */ void m11142f(BindMobileVerifyUI bindMobileVerifyUI) {
        AppMethodBeat.m2504i(13545);
        bindMobileVerifyUI.ape();
        AppMethodBeat.m2505o(13545);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13536);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a(132, (C1202f) this);
        setMMTitle((int) C25738R.string.a7b);
        this.grY = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.grZ = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.gsa = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.gsb = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        initView();
        AppMethodBeat.m2505o(13536);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13537);
        C1720g.m3540Rg().mo14546b(132, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(13537);
    }

    public void onStop() {
        AppMethodBeat.m2504i(13538);
        ape();
        super.onStop();
        AppMethodBeat.m2505o(13538);
    }

    public final int getLayoutId() {
        return 2130968844;
    }

    public final void initView() {
        AppMethodBeat.m2504i(13539);
        this.cFl = (String) C1720g.m3536RP().mo5239Ry().get(4097, null);
        this.grL = (EditText) findViewById(2131821771);
        this.gsq = (TextView) findViewById(2131821770);
        this.gsr = (TextView) findViewById(2131821774);
        Button button = (Button) findViewById(2131821772);
        if (this.cFl == null || this.cFl.equals("")) {
            this.cFl = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        }
        if (this.cFl != null && this.cFl.length() > 0) {
            this.gsq.setVisibility(0);
            this.gsq.setText(this.cFl);
        }
        this.grL.setFilters(new InputFilter[]{new C67141()});
        this.grN = (Button) findViewById(2131821735);
        button.setVisibility(8);
        this.gsr.setText(getResources().getQuantityString(C25738R.plurals.f9607t, this.gss.intValue(), new Object[]{this.gss}));
        apd();
        addTextOptionMenu(0, getString(C25738R.string.f9182s1), new C67082());
        setBackBtn(new C67103());
        this.grN.setVisibility(C17950b.m28214sM(this.cFl) ? 0 : 8);
        this.grN.setOnClickListener(new C67114());
        AppMethodBeat.m2505o(13539);
    }

    private void apd() {
        AppMethodBeat.m2504i(13540);
        if (this.mTimer == null) {
            this.mTimer = new Timer();
            C67135 c67135 = new C67135();
            if (this.mTimer != null) {
                this.mTimer.schedule(c67135, 1000, 1000);
            }
        }
        AppMethodBeat.m2505o(13540);
    }

    private void ape() {
        AppMethodBeat.m2504i(13541);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        AppMethodBeat.m2505o(13541);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(13542);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            mo27541Ni(1);
            AppMethodBeat.m2505o(13542);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(13542);
        return onKeyDown;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        boolean z = true;
        AppMethodBeat.m2504i(13543);
        C4990ab.m7416i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((C38037x) c1207m).mo60786Ah() != 2) {
            AppMethodBeat.m2505o(13543);
            return;
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        boolean z2;
        if (i == 0 && i2 == 0) {
            if (((C38037x) c1207m).mo60786Ah() == 2) {
                Intent intent;
                switch (this.fromScene) {
                    case 1:
                        if (!C1853r.m3826YH()) {
                            C32647tt c32647tt = new C32647tt();
                            c32647tt.cPS.cPT = true;
                            c32647tt.cPS.cPU = true;
                            C4879a.xxA.mo10055m(c32647tt);
                        }
                        mo27541Ni(1);
                        intent = new Intent();
                        intent.addFlags(67108864);
                        C24679a.gkE.mo38916e((Context) this, intent);
                        AppMethodBeat.m2505o(13543);
                        return;
                    case 6:
                        if (this.gsa) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (this.gsb) {
                            z = false;
                        }
                        BindMobileStatusUI.m83832c(this, z2, z);
                        exit(-1);
                        AppMethodBeat.m2505o(13543);
                        return;
                    default:
                        if (this.fromScene == 0 || this.fromScene == 3) {
                            ((C7599a) C1720g.m3530M(C7599a.class)).syncAddrBookAndUpload();
                        }
                        intent = new Intent(this, BindMobileStatusUI.class);
                        intent.putExtra("kstyle_bind_wording", this.grY);
                        intent.putExtra("kstyle_bind_recommend_show", this.grZ);
                        intent.putExtra("Kfind_friend_by_mobile_flag", this.gsa);
                        intent.putExtra("Krecom_friends_by_mobile_flag", this.gsb);
                        intent.putExtra("bind_scene", this.fromScene);
                        MMWizardActivity.m23791J(this, intent);
                        break;
                }
            }
            AppMethodBeat.m2505o(13543);
            return;
        }
        if (!C24679a.gkF.mo38859a((Context) this, i, i2, str)) {
            switch (i2) {
                case -214:
                    C42124a jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        jY.mo67668a(this, null, null);
                    }
                    z2 = true;
                    break;
                case -43:
                    Toast.makeText(this, C25738R.string.a6h, 0).show();
                    z2 = true;
                    break;
                case -41:
                    Toast.makeText(this, C25738R.string.a6j, 0).show();
                    z2 = true;
                    break;
                case -36:
                    Toast.makeText(this, C25738R.string.a6m, 0).show();
                    z2 = true;
                    break;
                case -35:
                    Toast.makeText(this, C25738R.string.a6i, 0).show();
                    z2 = true;
                    break;
                case -34:
                    Toast.makeText(this, C25738R.string.a6k, 0).show();
                    z2 = true;
                    break;
                case -33:
                    C30379h.m48431a((Context) this, (int) C25738R.string.a7s, (int) C25738R.string.a7y, null);
                    z2 = true;
                    break;
                case -32:
                    C30379h.m48431a((Context) this, (int) C25738R.string.a7t, (int) C25738R.string.a7y, null);
                    z2 = true;
                    break;
                default:
                    z2 = false;
                    break;
            }
        }
        z2 = true;
        if (z2) {
            AppMethodBeat.m2505o(13543);
            return;
        }
        Toast.makeText(this, getString(C25738R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        AppMethodBeat.m2505o(13543);
    }

    /* renamed from: d */
    static /* synthetic */ void m11140d(BindMobileVerifyUI bindMobileVerifyUI) {
        AppMethodBeat.m2504i(13544);
        bindMobileVerifyUI.gsr.post(new C67126());
        AppMethodBeat.m2505o(13544);
    }
}
