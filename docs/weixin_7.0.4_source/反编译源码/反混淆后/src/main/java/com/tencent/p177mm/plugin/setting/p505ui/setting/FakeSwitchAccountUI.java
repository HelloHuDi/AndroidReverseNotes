package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5536q;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.p177mm.plugin.setting.p505ui.widget.SwitchAccountGridView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5040bk;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI */
public class FakeSwitchAccountUI extends MMActivity {
    private int count;
    private String country;
    private int ecI;
    private float fontScale;
    private String gCZ;
    private SwitchAccountGridView qkN;
    private View qkO;
    private View qkP;
    private ArrayList<SwitchAccountModel> qkQ;
    private Map<String, SwitchAccountModel> qkR = new HashMap();
    private C7564ap qkS;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI$1 */
    class C70821 implements C5015a {
        C70821() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(126954);
            int a = FakeSwitchAccountUI.m86351a(FakeSwitchAccountUI.this);
            C4990ab.m7417i("MicroMsg.FakeSwitchAccountUI", "oldPid %d, mm pid %d", Integer.valueOf(FakeSwitchAccountUI.this.ecI), Integer.valueOf(a));
            if (FakeSwitchAccountUI.this.ecI == 0 || a == 0 || FakeSwitchAccountUI.this.ecI == a) {
                FakeSwitchAccountUI.this.count = FakeSwitchAccountUI.this.count + 1;
                if (FakeSwitchAccountUI.this.count <= 20) {
                    AppMethodBeat.m2505o(126954);
                    return true;
                }
                FakeSwitchAccountUI.m86355e(FakeSwitchAccountUI.this);
                AppMethodBeat.m2505o(126954);
                return false;
            } else if (FakeSwitchAccountUI.this.count <= 0) {
                FakeSwitchAccountUI.this.count = FakeSwitchAccountUI.this.count + 1;
                AppMethodBeat.m2505o(126954);
                return true;
            } else {
                FakeSwitchAccountUI.m86355e(FakeSwitchAccountUI.this);
                AppMethodBeat.m2505o(126954);
                return false;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FakeSwitchAccountUI() {
        AppMethodBeat.m2504i(126955);
        AppMethodBeat.m2505o(126955);
    }

    /* renamed from: a */
    static /* synthetic */ int m86351a(FakeSwitchAccountUI fakeSwitchAccountUI) {
        AppMethodBeat.m2504i(126963);
        int ciu = fakeSwitchAccountUI.ciu();
        AppMethodBeat.m2505o(126963);
        return ciu;
    }

    public final int getLayoutId() {
        return 2130970644;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(126956);
        super.onCreate(bundle);
        this.country = getIntent().getStringExtra("key_langauage_code");
        this.fontScale = getIntent().getFloatExtra("key_font_scale_size", 1.0f);
        if (!C5046bo.isNullOrNil(this.country)) {
            C4990ab.m7417i("MicroMsg.FakeSwitchAccountUI", "country %s", this.country);
            C5040bk.setProperty("language_key", this.country);
            C5536q.m8327bM(C4996ah.getContext(), this.country);
        }
        C4990ab.m7417i("MicroMsg.FakeSwitchAccountUI", "fontScale %f", Float.valueOf(this.fontScale));
        C1338a.m2871h(C4996ah.getContext(), this.fontScale);
        initView();
        AppMethodBeat.m2505o(126956);
    }

    public final void initView() {
        AppMethodBeat.m2504i(126957);
        C4990ab.m7416i("MicroMsg.FakeSwitchAccountUI", "FakeSwitchAccount onCreate");
        setMMTitle("");
        getSupportActionBar().hide();
        this.qkN = (SwitchAccountGridView) findViewById(2131827433);
        this.qkN.setRowCount(1);
        this.qkN.setClickable(false);
        this.ecI = getIntent().getIntExtra("key_mm_process_pid", 0);
        this.gCZ = getIntent().getStringExtra("key_switch_from_wx_username");
        C4990ab.m7417i("MicroMsg.FakeSwitchAccountUI", "title %s", getResources().getString(C25738R.string.ebi));
        this.qkQ = getIntent().getParcelableArrayListExtra("key_switch_account_users");
        if (this.qkQ != null) {
            Iterator it = this.qkQ.iterator();
            while (it.hasNext()) {
                SwitchAccountModel switchAccountModel = (SwitchAccountModel) it.next();
                this.qkR.put(switchAccountModel.qjK, switchAccountModel);
            }
        }
        this.qkO = findViewById(2131827434);
        this.qkO.setVisibility(8);
        this.qkP = findViewById(2131827427);
        this.qkP.setVisibility(8);
        C4990ab.m7417i("MicroMsg.FakeSwitchAccountUI", "account count %d", Integer.valueOf(this.qkR.size()));
        this.qkN.setUseSystemDecoder(true);
        this.qkN.mo69065ab(this.qkR);
        this.qkN.setLastLoginWxUsername(this.gCZ);
        this.qkN.setLogoutState(true);
        this.qkN.cjt();
        this.qkS = new C7564ap(Looper.myLooper(), new C70821(), true);
        if (this.qkS != null) {
            this.qkS.mo16770ae(1500, 500);
        }
        AppMethodBeat.m2505o(126957);
    }

    private int ciu() {
        AppMethodBeat.m2504i(126958);
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals("com.tencent.mm")) {
                    C4990ab.m7417i("MicroMsg.FakeSwitchAccountUI", "process %s, %s", runningAppProcessInfo.processName, Integer.valueOf(runningAppProcessInfo.pid));
                    int i = runningAppProcessInfo.pid;
                    AppMethodBeat.m2505o(126958);
                    return i;
                }
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Exception: " + e.toString());
        } catch (Error e2) {
            C4990ab.m7412e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Error: " + e2.toString());
        }
        AppMethodBeat.m2505o(126958);
        return 0;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(126959);
        if (i == 4) {
            AppMethodBeat.m2505o(126959);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(126959);
        return onKeyDown;
    }

    public void onResume() {
        AppMethodBeat.m2504i(126960);
        super.onResume();
        C4990ab.m7416i("MicroMsg.FakeSwitchAccountUI", "fake switch account resume");
        AppMethodBeat.m2505o(126960);
    }

    public void onStop() {
        AppMethodBeat.m2504i(126961);
        super.onStop();
        C4990ab.m7416i("MicroMsg.FakeSwitchAccountUI", "fake switch account stop");
        AppMethodBeat.m2505o(126961);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(126962);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.FakeSwitchAccountUI", "fake switch account destroy");
        AppMethodBeat.m2505o(126962);
    }

    /* renamed from: e */
    static /* synthetic */ void m86355e(FakeSwitchAccountUI fakeSwitchAccountUI) {
        AppMethodBeat.m2504i(126964);
        C4990ab.m7416i("MicroMsg.FakeSwitchAccountUI", "jump to launcher");
        fakeSwitchAccountUI.qkS.stopTimer();
        Intent intent = new Intent();
        intent.setClassName(fakeSwitchAccountUI, "com.tencent.mm.ui.LauncherUI");
        intent.addFlags(67108864);
        intent.putExtra("LauncherUI.jump_switch_account", true);
        fakeSwitchAccountUI.startActivity(intent);
        fakeSwitchAccountUI.finish();
        C5274b.m8055hN(fakeSwitchAccountUI);
        AppMethodBeat.m2505o(126964);
    }
}
