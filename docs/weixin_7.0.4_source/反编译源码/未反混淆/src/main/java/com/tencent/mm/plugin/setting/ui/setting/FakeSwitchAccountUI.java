package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@a(3)
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
    private ap qkS;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FakeSwitchAccountUI() {
        AppMethodBeat.i(126955);
        AppMethodBeat.o(126955);
    }

    static /* synthetic */ int a(FakeSwitchAccountUI fakeSwitchAccountUI) {
        AppMethodBeat.i(126963);
        int ciu = fakeSwitchAccountUI.ciu();
        AppMethodBeat.o(126963);
        return ciu;
    }

    public final int getLayoutId() {
        return R.layout.as2;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(126956);
        super.onCreate(bundle);
        this.country = getIntent().getStringExtra("key_langauage_code");
        this.fontScale = getIntent().getFloatExtra("key_font_scale_size", 1.0f);
        if (!bo.isNullOrNil(this.country)) {
            ab.i("MicroMsg.FakeSwitchAccountUI", "country %s", this.country);
            bk.setProperty("language_key", this.country);
            q.bM(ah.getContext(), this.country);
        }
        ab.i("MicroMsg.FakeSwitchAccountUI", "fontScale %f", Float.valueOf(this.fontScale));
        com.tencent.mm.bz.a.h(ah.getContext(), this.fontScale);
        initView();
        AppMethodBeat.o(126956);
    }

    public final void initView() {
        AppMethodBeat.i(126957);
        ab.i("MicroMsg.FakeSwitchAccountUI", "FakeSwitchAccount onCreate");
        setMMTitle("");
        getSupportActionBar().hide();
        this.qkN = (SwitchAccountGridView) findViewById(R.id.ea8);
        this.qkN.setRowCount(1);
        this.qkN.setClickable(false);
        this.ecI = getIntent().getIntExtra("key_mm_process_pid", 0);
        this.gCZ = getIntent().getStringExtra("key_switch_from_wx_username");
        ab.i("MicroMsg.FakeSwitchAccountUI", "title %s", getResources().getString(R.string.ebi));
        this.qkQ = getIntent().getParcelableArrayListExtra("key_switch_account_users");
        if (this.qkQ != null) {
            Iterator it = this.qkQ.iterator();
            while (it.hasNext()) {
                SwitchAccountModel switchAccountModel = (SwitchAccountModel) it.next();
                this.qkR.put(switchAccountModel.qjK, switchAccountModel);
            }
        }
        this.qkO = findViewById(R.id.ea9);
        this.qkO.setVisibility(8);
        this.qkP = findViewById(R.id.ea2);
        this.qkP.setVisibility(8);
        ab.i("MicroMsg.FakeSwitchAccountUI", "account count %d", Integer.valueOf(this.qkR.size()));
        this.qkN.setUseSystemDecoder(true);
        this.qkN.ab(this.qkR);
        this.qkN.setLastLoginWxUsername(this.gCZ);
        this.qkN.setLogoutState(true);
        this.qkN.cjt();
        this.qkS = new ap(Looper.myLooper(), new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(126954);
                int a = FakeSwitchAccountUI.a(FakeSwitchAccountUI.this);
                ab.i("MicroMsg.FakeSwitchAccountUI", "oldPid %d, mm pid %d", Integer.valueOf(FakeSwitchAccountUI.this.ecI), Integer.valueOf(a));
                if (FakeSwitchAccountUI.this.ecI == 0 || a == 0 || FakeSwitchAccountUI.this.ecI == a) {
                    FakeSwitchAccountUI.this.count = FakeSwitchAccountUI.this.count + 1;
                    if (FakeSwitchAccountUI.this.count <= 20) {
                        AppMethodBeat.o(126954);
                        return true;
                    }
                    FakeSwitchAccountUI.e(FakeSwitchAccountUI.this);
                    AppMethodBeat.o(126954);
                    return false;
                } else if (FakeSwitchAccountUI.this.count <= 0) {
                    FakeSwitchAccountUI.this.count = FakeSwitchAccountUI.this.count + 1;
                    AppMethodBeat.o(126954);
                    return true;
                } else {
                    FakeSwitchAccountUI.e(FakeSwitchAccountUI.this);
                    AppMethodBeat.o(126954);
                    return false;
                }
            }
        }, true);
        if (this.qkS != null) {
            this.qkS.ae(1500, 500);
        }
        AppMethodBeat.o(126957);
    }

    private int ciu() {
        AppMethodBeat.i(126958);
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals("com.tencent.mm")) {
                    ab.i("MicroMsg.FakeSwitchAccountUI", "process %s, %s", runningAppProcessInfo.processName, Integer.valueOf(runningAppProcessInfo.pid));
                    int i = runningAppProcessInfo.pid;
                    AppMethodBeat.o(126958);
                    return i;
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Exception: " + e.toString());
        } catch (Error e2) {
            ab.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Error: " + e2.toString());
        }
        AppMethodBeat.o(126958);
        return 0;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(126959);
        if (i == 4) {
            AppMethodBeat.o(126959);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(126959);
        return onKeyDown;
    }

    public void onResume() {
        AppMethodBeat.i(126960);
        super.onResume();
        ab.i("MicroMsg.FakeSwitchAccountUI", "fake switch account resume");
        AppMethodBeat.o(126960);
    }

    public void onStop() {
        AppMethodBeat.i(126961);
        super.onStop();
        ab.i("MicroMsg.FakeSwitchAccountUI", "fake switch account stop");
        AppMethodBeat.o(126961);
    }

    public void onDestroy() {
        AppMethodBeat.i(126962);
        super.onDestroy();
        ab.i("MicroMsg.FakeSwitchAccountUI", "fake switch account destroy");
        AppMethodBeat.o(126962);
    }

    static /* synthetic */ void e(FakeSwitchAccountUI fakeSwitchAccountUI) {
        AppMethodBeat.i(126964);
        ab.i("MicroMsg.FakeSwitchAccountUI", "jump to launcher");
        fakeSwitchAccountUI.qkS.stopTimer();
        Intent intent = new Intent();
        intent.setClassName(fakeSwitchAccountUI, "com.tencent.mm.ui.LauncherUI");
        intent.addFlags(67108864);
        intent.putExtra("LauncherUI.jump_switch_account", true);
        fakeSwitchAccountUI.startActivity(intent);
        fakeSwitchAccountUI.finish();
        b.hN(fakeSwitchAccountUI);
        AppMethodBeat.o(126964);
    }
}
