package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.p177mm.plugin.exdevice.model.C38956j;
import com.tencent.p177mm.plugin.exdevice.model.C38956j.C34038a;
import com.tencent.p177mm.plugin.exdevice.p953d.C11642b;
import com.tencent.p177mm.plugin.exdevice.p953d.C27830a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI */
public class ExdeviceConnectWifiUI extends MMActivity {
    private TextWatcher arx;
    private EditText gBJ;
    private String kWl = "";
    private C11704b lAa;
    private C1923n lAb;
    private C34038a lAc;
    private MulticastLock lAd;
    private Runnable lAe = new C116941();
    private View lzG;
    private TextView lzH;
    private View lzI;
    private View lzJ;
    private C44275p lzK;
    private String lzL;
    private C27830a lzM;
    private boolean lzN;
    private boolean lzO;
    private boolean lzP;
    private int lzQ;
    private byte[] lzR;
    private int lzS;
    private int lzT;
    private int lzU;
    private String lzV = "";
    private int lzW;
    private long lzX;
    boolean lzY = false;
    private C11642b lzZ;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$10 */
    class C1168510 implements OnMenuItemClickListener {
        C1168510() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(19886);
            if (!ExdeviceConnectWifiUI.this.lzP) {
                boolean z;
                Intent intent = new Intent();
                String str = "is_wifi_connected";
                if (ExdeviceConnectWifiUI.this.lAa != C11704b.NO_WIFI_CONNECTED) {
                    z = true;
                } else {
                    z = false;
                }
                intent.putExtra(str, z);
                ExdeviceConnectWifiUI.this.setResult(0, intent);
                ExdeviceConnectWifiUI.this.finish();
            }
            AppMethodBeat.m2505o(19886);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$12 */
    class C1168612 implements OnTouchListener {
        C1168612() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(19888);
            ExdeviceConnectWifiUI.this.gBJ.clearFocus();
            ExdeviceConnectWifiUI.this.aqX();
            AppMethodBeat.m2505o(19888);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$13 */
    class C1168713 implements OnClickListener {
        C1168713() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(19889);
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onClick connectBtn.");
            ExdeviceConnectWifiUI.m19508k(ExdeviceConnectWifiUI.this);
            AppMethodBeat.m2505o(19889);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$4 */
    class C116894 implements Runnable {
        C116894() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19875);
            ExdeviceConnectWifiUI.m19514q(ExdeviceConnectWifiUI.this);
            AppMethodBeat.m2505o(19875);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$5 */
    class C116905 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$5$1 */
        class C116911 implements OnCancelListener {
            C116911() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(19876);
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "On progress cancel, stop airkiss");
                if (ExdeviceConnectWifiUI.this.lAa != C11704b.FINISH) {
                    ExdeviceConnectWifiUI.m19515r(ExdeviceConnectWifiUI.this);
                }
                AppMethodBeat.m2505o(19876);
            }
        }

        C116905() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19877);
            ExdeviceConnectWifiUI exdeviceConnectWifiUI = ExdeviceConnectWifiUI.this;
            Context context = ExdeviceConnectWifiUI.this.mController.ylL;
            ExdeviceConnectWifiUI.this.getString(C25738R.string.f9238tz);
            exdeviceConnectWifiUI.lzK = C30379h.m48458b(context, ExdeviceConnectWifiUI.this.getString(C25738R.string.bi4), true, new C116911());
            AppMethodBeat.m2505o(19877);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$11 */
    class C1169211 implements TextWatcher {
        C1169211() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(19887);
            if (editable.length() > 31) {
                ExdeviceConnectWifiUI.this.lzI.setVisibility(0);
                ExdeviceConnectWifiUI.this.lzJ.setEnabled(false);
                AppMethodBeat.m2505o(19887);
                return;
            }
            ExdeviceConnectWifiUI.this.lzI.setVisibility(8);
            ExdeviceConnectWifiUI.this.lzJ.setEnabled(true);
            AppMethodBeat.m2505o(19887);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$3 */
    class C116933 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$3$1 */
        class C116841 implements Runnable {
            C116841() {
            }

            public final void run() {
                AppMethodBeat.m2504i(19873);
                ExdeviceConnectWifiUI.this.showVKB();
                AppMethodBeat.m2505o(19873);
            }
        }

        C116933() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19874);
            try {
                StringBuilder stringBuilder = new StringBuilder();
                C9638aw.m17190ZK();
                byte[] e = C5730e.m8632e(stringBuilder.append(C18628c.getAccPath()).append("exdevice_wifi_infos").toString(), 0, BaseClientBuilder.API_PRIORITY_OTHER);
                if (e != null) {
                    ExdeviceConnectWifiUI.this.lzZ.parseFrom(e);
                    ExdeviceConnectWifiUI.m19513p(ExdeviceConnectWifiUI.this);
                }
            } catch (Exception e2) {
                C4990ab.m7410d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e2.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", e2, "", new Object[0]);
            }
            C5004al.m7442n(new C116841(), 500);
            AppMethodBeat.m2505o(19874);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$1 */
    class C116941 implements Runnable {
        C116941() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19871);
            if (C5046bo.isNullOrNil(ExdeviceConnectWifiUI.m19495a(ExdeviceConnectWifiUI.this))) {
                ExdeviceConnectWifiUI.this.gBJ.setText(ExdeviceConnectWifiUI.this.lzM.luH);
                Editable text = ExdeviceConnectWifiUI.this.gBJ.getText();
                if (text != null) {
                    Selection.setSelection(text, text.length());
                }
                AppMethodBeat.m2505o(19871);
                return;
            }
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "User has input password.");
            AppMethodBeat.m2505o(19871);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$8 */
    class C116958 extends C1924a {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$8$1 */
        class C116961 implements Runnable {
            C116961() {
            }

            public final void run() {
                AppMethodBeat.m2504i(19880);
                if (ExdeviceConnectWifiUI.this.lAa != C11704b.FINISH) {
                    ExdeviceConnectWifiUI.m19500e(ExdeviceConnectWifiUI.this);
                }
                AppMethodBeat.m2505o(19880);
            }
        }

        C116958() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(19881);
            C5004al.m7441d(new C116961());
            AppMethodBeat.m2505o(19881);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$a */
    static class C11697a {
        /* renamed from: av */
        public static String m19519av(int i, String str) {
            AppMethodBeat.m2504i(19892);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(19892);
                return null;
            }
            String str2 = i + "@" + str.hashCode();
            AppMethodBeat.m2505o(19892);
            return str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$14 */
    class C1169814 implements OnEditorActionListener {
        C1169814() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(19890);
            if (i == 6 || i == 5) {
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "on next Key down.");
                ExdeviceConnectWifiUI.m19508k(ExdeviceConnectWifiUI.this);
                AppMethodBeat.m2505o(19890);
                return true;
            }
            AppMethodBeat.m2505o(19890);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$6 */
    class C116996 implements Runnable {
        C116996() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19878);
            if (ExdeviceConnectWifiUI.this.lzK != null && ExdeviceConnectWifiUI.this.lzK.isShowing()) {
                ExdeviceConnectWifiUI.this.lzK.dismiss();
            }
            AppMethodBeat.m2505o(19878);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$9 */
    class C117009 implements C34038a {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$9$1 */
        class C117011 implements Runnable {
            C117011() {
            }

            public final void run() {
                AppMethodBeat.m2504i(19882);
                ExdeviceConnectWifiUI.this.mo23446a(C11704b.FINISH);
                AppMethodBeat.m2505o(19882);
            }
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$9$2 */
        class C117022 implements Runnable {

            /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$9$2$1 */
            class C117031 implements DialogInterface.OnClickListener {
                C117031() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(19883);
                    ExdeviceConnectWifiUI.this.mo23446a(C11704b.TIMEOUT);
                    AppMethodBeat.m2505o(19883);
                }
            }

            C117022() {
            }

            public final void run() {
                AppMethodBeat.m2504i(19884);
                ExdeviceConnectWifiUI.this.lzK.dismiss();
                C30379h.m48445a(ExdeviceConnectWifiUI.this.mController.ylL, ExdeviceConnectWifiUI.this.mController.ylL.getString(C25738R.string.bec), "", ExdeviceConnectWifiUI.this.mController.ylL.getString(C25738R.string.bfn), "", false, new C117031(), null).show();
                AppMethodBeat.m2505o(19884);
            }
        }

        C117009() {
        }

        /* renamed from: g */
        public final void mo7189g(int i, Object... objArr) {
            AppMethodBeat.m2504i(19885);
            if (i == 0 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof Integer)) {
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                if (ExdeviceConnectWifiUI.this.lAd.isHeld()) {
                    ExdeviceConnectWifiUI.this.lAd.release();
                }
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "AirKiss jni callback (%d, %d)", Integer.valueOf(intValue), Integer.valueOf(intValue2));
                if (intValue == 0 && intValue2 == 0) {
                    C5004al.m7441d(new C117011());
                    AppMethodBeat.m2505o(19885);
                    return;
                }
                ExdeviceConnectWifiUI.this.runOnUiThread(new C117022());
                AppMethodBeat.m2505o(19885);
                return;
            }
            AppMethodBeat.m2505o(19885);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$b */
    public enum C11704b {
        NORMAL,
        NO_WIFI_CONNECTED,
        SETTING,
        FINISH,
        TIMEOUT;

        static {
            AppMethodBeat.m2505o(19895);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$15 */
    class C1170515 implements OnKeyListener {
        C1170515() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(19891);
            if (66 == i && keyEvent.getAction() == 0) {
                ExdeviceConnectWifiUI.m19508k(ExdeviceConnectWifiUI.this);
                AppMethodBeat.m2505o(19891);
                return true;
            }
            AppMethodBeat.m2505o(19891);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ExdeviceConnectWifiUI() {
        AppMethodBeat.m2504i(19896);
        AppMethodBeat.m2505o(19896);
    }

    /* renamed from: e */
    static /* synthetic */ void m19500e(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.m2504i(19912);
        exdeviceConnectWifiUI.m19504gO(true);
        AppMethodBeat.m2505o(19912);
    }

    /* renamed from: p */
    static /* synthetic */ void m19513p(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.m2504i(19914);
        exdeviceConnectWifiUI.bpG();
        AppMethodBeat.m2505o(19914);
    }

    public final int getLayoutId() {
        return 2130969416;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(19897);
        super.onCreate(bundle);
        this.lAb = new C116958();
        this.lAa = C11704b.NORMAL;
        if (C9638aw.m17179RK()) {
            this.lzZ = new C11642b();
            this.lzM = new C27830a();
            C9638aw.m17190ZK();
            this.lzQ = C18628c.m29064QF();
            String stringExtra = getIntent().getStringExtra("encryptKey");
            this.lzS = getIntent().getIntExtra("procInterval", 0);
            this.lzT = getIntent().getIntExtra("dataInterval", 0);
            C4990ab.m7410d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.lzS + " Data interval:" + this.lzT);
            if (!C5046bo.isNullOrNil(stringExtra)) {
                this.lzR = Base64.decode(stringExtra, 0);
                this.lzW = 1;
            }
            this.lzY = false;
            this.lzU = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
            if (this.lzU == 2) {
                this.lzV = getIntent().getStringExtra("device_brand_name");
                this.kWl = getIntent().getStringExtra("device_category_id");
            }
            this.lAc = new C117009();
            C38956j.boN().mo61836a(0, this.lAc);
            initView();
            C9638aw.m17180RS().mo10302aa(new C116933());
            m19516uP(1);
            this.lAd = ((WifiManager) getApplicationContext().getSystemService("wifi")).createMulticastLock("localWifi");
            AppMethodBeat.m2505o(19897);
            return;
        }
        finish();
        AppMethodBeat.m2505o(19897);
    }

    public void onResume() {
        AppMethodBeat.m2504i(19898);
        super.onResume();
        m19504gO(false);
        C9638aw.m17198a(this.lAb);
        if (this.lzO) {
            bpG();
            this.lzO = false;
        }
        AppMethodBeat.m2505o(19898);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(19899);
        super.onDestroy();
        if (!this.lzY) {
            m19516uP(2);
        }
        C38956j.boN().mo61837b(0, this.lAc);
        AppMethodBeat.m2505o(19899);
    }

    public void onStop() {
        AppMethodBeat.m2504i(19900);
        super.onStop();
        C9638aw.m17200b(this.lAb);
        AppMethodBeat.m2505o(19900);
    }

    public final void initView() {
        AppMethodBeat.m2504i(19901);
        setMMTitle((int) C25738R.string.bfr);
        setBackBtn(new C1168510());
        this.lzG = findViewById(2131823643);
        this.lzH = (TextView) findViewById(2131823625);
        this.lzI = findViewById(2131823645);
        this.gBJ = (EditText) findViewById(2131823644);
        this.lzJ = findViewById(2131823648);
        this.arx = new C1169211();
        this.lzG.setOnTouchListener(new C1168612());
        this.lzJ.setOnClickListener(new C1168713());
        this.gBJ.setTransformationMethod(new PasswordTransformationMethod());
        this.gBJ.addTextChangedListener(this.arx);
        this.gBJ.setOnEditorActionListener(new C1169814());
        this.gBJ.setOnKeyListener(new C1170515());
        this.gBJ.requestFocus();
        AppMethodBeat.m2505o(19901);
    }

    /* renamed from: uP */
    private void m19516uP(int i) {
        AppMethodBeat.m2504i(19902);
        long j = 0;
        if (i == 4) {
            j = System.currentTimeMillis() - this.lzX;
        }
        C7060h.pYm.mo8381e(13503, Integer.valueOf(i), Integer.valueOf(this.lzU), Long.valueOf(j), this.lzV, this.kWl, Integer.valueOf(this.lzW));
        AppMethodBeat.m2505o(19902);
    }

    /* renamed from: au */
    private C27830a m19496au(int i, String str) {
        AppMethodBeat.m2504i(19903);
        if (C5046bo.isNullOrNil(str) || this.lzZ == null) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
            AppMethodBeat.m2505o(19903);
            return null;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.lzZ.luI.size()) {
                C27830a c27830a = (C27830a) this.lzZ.luI.get(i3);
                if (c27830a == null) {
                    i2 = i3 - 1;
                    this.lzZ.luI.remove(i3);
                    this.lzN = true;
                    i3 = i2;
                } else if (c27830a.luF == i && str.equals(c27830a.luG)) {
                    AppMethodBeat.m2505o(19903);
                    return c27830a;
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(19903);
                return null;
            }
        }
    }

    private void bpG() {
        AppMethodBeat.m2504i(19904);
        this.lzM.luH = "";
        this.lzM.luG = "";
        String str = this.lzL;
        C27830a au = m19496au(this.lzQ, str);
        if (au == null || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(19904);
        } else if (C5046bo.isNullOrNil(au.luH)) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
            this.lzZ.luI.remove(au);
            this.lzN = true;
            AppMethodBeat.m2505o(19904);
        } else {
            this.lzM.luH = C42781b.m75867da(au.luH, C11697a.m19519av(this.lzQ, au.luG));
            this.lzM.luG = au.luG;
            C5004al.m7441d(this.lAe);
            AppMethodBeat.m2505o(19904);
        }
    }

    private String getPassword() {
        AppMethodBeat.m2504i(19905);
        if (this.gBJ.getText() != null) {
            String obj = this.gBJ.getText().toString();
            AppMethodBeat.m2505o(19905);
            return obj;
        }
        AppMethodBeat.m2505o(19905);
        return null;
    }

    /* renamed from: gO */
    private void m19504gO(boolean z) {
        AppMethodBeat.m2504i(19906);
        C11704b c11704b = z ? C11704b.NORMAL : this.lAa;
        if (C5023at.getNetType(this) != 0) {
            c11704b = C11704b.NO_WIFI_CONNECTED;
        } else {
            this.lzL = C5023at.m7474gE(C4996ah.getContext());
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", this.lzL);
            if (C5046bo.isNullOrNil(this.lzL)) {
                this.lzH.setText("");
            } else {
                this.lzH.setText(this.lzL);
            }
        }
        mo23446a(c11704b);
        AppMethodBeat.m2505o(19906);
    }

    /* renamed from: a */
    public final synchronized void mo23446a(C11704b c11704b) {
        AppMethodBeat.m2504i(19907);
        if (c11704b == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Status is null.");
            AppMethodBeat.m2505o(19907);
        } else {
            this.lAa = c11704b;
            switch (c11704b) {
                case NORMAL:
                    m19503g(true, false, false);
                    break;
                case SETTING:
                    m19503g(true, true, false);
                    break;
                case NO_WIFI_CONNECTED:
                    m19503g(false, false, false);
                    break;
                case TIMEOUT:
                    m19516uP(5);
                    this.lzP = true;
                    setResult(1);
                    break;
                case FINISH:
                    m19516uP(4);
                    m19503g(true, false, true);
                    this.lzP = true;
                    setResult(-1);
                    C9638aw.m17180RS().mo10302aa(new C116894());
                    if (getIntent().getBooleanExtra("jumpToBindDevice", false)) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", getIntent().getStringExtra("device_scan_mode"));
                        intent.putExtra("device_scan_conn_proto", getIntent().getStringExtra("device_scan_conn_proto"));
                        intent.putExtra("device_id", getIntent().getStringExtra("device_id"));
                        intent.putExtra("device_type", getIntent().getStringExtra("device_type"));
                        intent.putExtra("device_title", getIntent().getStringExtra("device_title"));
                        intent.putExtra("device_desc", getIntent().getStringExtra("device_desc"));
                        intent.putExtra("device_icon_url", getIntent().getStringExtra("device_icon_url"));
                        intent.putExtra("device_category_id", getIntent().getStringExtra("device_category_id"));
                        intent.putExtra("device_brand_name", getIntent().getStringExtra("device_brand_name"));
                        intent.putExtra("bind_ticket", getIntent().getStringExtra("bind_ticket"));
                        C25985d.m41467b(this.mController.ylL, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                        break;
                    }
                    break;
            }
            finish();
            if (c11704b != C11704b.NORMAL) {
                this.gBJ.clearFocus();
                aqX();
            }
            AppMethodBeat.m2505o(19907);
        }
    }

    private void bpH() {
        AppMethodBeat.m2504i(19908);
        runOnUiThread(new C116905());
        AppMethodBeat.m2505o(19908);
    }

    private void bpD() {
        AppMethodBeat.m2504i(19909);
        runOnUiThread(new C116996());
        if (this.lAd.isHeld()) {
            this.lAd.release();
        }
        AppMethodBeat.m2505o(19909);
    }

    /* renamed from: g */
    private void m19503g(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(19910);
        this.lzG.setVisibility(z ? 0 : 8);
        if (z2) {
            bpH();
        } else {
            bpD();
        }
        if (z3) {
            Toast.makeText(this.mController.ylL, C25738R.string.bfu, 0).show();
        }
        AppMethodBeat.m2505o(19910);
    }

    /* renamed from: k */
    static /* synthetic */ void m19508k(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.m2504i(19913);
        exdeviceConnectWifiUI.lzY = true;
        exdeviceConnectWifiUI.lzX = System.currentTimeMillis();
        exdeviceConnectWifiUI.m19516uP(3);
        final String password = exdeviceConnectWifiUI.getPassword();
        final String str = exdeviceConnectWifiUI.lzL;
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "do start AirKiss, ssid(%s).", str);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is invalid");
            Toast.makeText(exdeviceConnectWifiUI.mController.ylL, "SSID is invalid", 0).show();
            AppMethodBeat.m2505o(19913);
            return;
        }
        exdeviceConnectWifiUI.mo23446a(C11704b.SETTING);
        C9638aw.m17180RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(19872);
                ExdeviceConnectWifiUI.this.lAd.acquire();
                int startAirKissWithInter = Java2CExDevice.startAirKissWithInter(password, str, ExdeviceConnectWifiUI.this.lzR, 60000, ExdeviceConnectWifiUI.this.lzS, ExdeviceConnectWifiUI.this.lzT);
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Start AirKiss result (%d). input ssid = %s", Integer.valueOf(startAirKissWithInter), str);
                AppMethodBeat.m2505o(19872);
            }
        });
        AppMethodBeat.m2505o(19913);
    }

    /* renamed from: q */
    static /* synthetic */ void m19514q(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.m2504i(19915);
        String str = exdeviceConnectWifiUI.lzL;
        String nullAsNil = C5046bo.nullAsNil(exdeviceConnectWifiUI.getPassword());
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is null or nil.");
            AppMethodBeat.m2505o(19915);
            return;
        }
        if (C5046bo.isNullOrNil(exdeviceConnectWifiUI.lzM.luG) || (str.equals(exdeviceConnectWifiUI.lzM.luG) && !nullAsNil.equals(exdeviceConnectWifiUI.lzM.luH))) {
            C27830a au = exdeviceConnectWifiUI.m19496au(exdeviceConnectWifiUI.lzQ, str);
            if (au == null) {
                au = new C27830a();
                au.luG = str;
                au.luF = exdeviceConnectWifiUI.lzQ;
                exdeviceConnectWifiUI.lzZ.luI.add(au);
            }
            au.luH = C42781b.m75867da(nullAsNil, C11697a.m19519av(exdeviceConnectWifiUI.lzQ, str));
        } else if (!exdeviceConnectWifiUI.lzN) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "password hasn't changed, so do not need to save.");
            AppMethodBeat.m2505o(19915);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        str = stringBuilder.append(C18628c.getAccPath()).append("exdevice_wifi_infos").toString();
        try {
            byte[] toByteArray = exdeviceConnectWifiUI.lzZ.toByteArray();
            C5730e.m8624b(str, toByteArray, toByteArray.length);
        } catch (IOException e) {
            C4990ab.m7410d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", e, "", new Object[0]);
        }
        C4990ab.m7419v("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Current wifiInfo was save to file(%s).", str);
        AppMethodBeat.m2505o(19915);
    }

    /* renamed from: r */
    static /* synthetic */ void m19515r(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.m2504i(19916);
        Java2CExDevice.stopAirKiss();
        exdeviceConnectWifiUI.m19504gO(true);
        if (exdeviceConnectWifiUI.lAd.isHeld()) {
            exdeviceConnectWifiUI.lAd.release();
        }
        AppMethodBeat.m2505o(19916);
    }
}
