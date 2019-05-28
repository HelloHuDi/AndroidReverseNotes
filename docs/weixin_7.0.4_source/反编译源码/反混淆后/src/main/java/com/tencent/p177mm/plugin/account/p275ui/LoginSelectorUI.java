package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C5059g;

@Deprecated
/* renamed from: com.tencent.mm.plugin.account.ui.LoginSelectorUI */
public class LoginSelectorUI extends MMActivity implements OnClickListener {
    private TextView gCN;
    private View gCO;

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginSelectorUI$1 */
    class C99511 implements OnClickListener {
        C99511() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125007);
            Intent intent = new Intent();
            intent.putExtra("not_auth_setting", true);
            C24679a.gkE.mo38930o(intent, LoginSelectorUI.this.mController.ylL);
            AppMethodBeat.m2505o(125007);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125008);
        super.onCreate(bundle);
        setTitleVisibility(8);
        C24679a.gkF.mo38846BV();
        C1720g.m3534RN();
        C1668a.m3398Rc();
        initView();
        AppMethodBeat.m2505o(125008);
    }

    public final int getLayoutId() {
        return 2130970595;
    }

    public void onResume() {
        AppMethodBeat.m2504i(125009);
        super.onResume();
        C1720g.m3534RN();
        C1668a.m3398Rc();
        AppMethodBeat.m2505o(125009);
    }

    public final void initView() {
        AppMethodBeat.m2504i(125010);
        Button button = (Button) findViewById(2131827314);
        Button button2 = (Button) findViewById(2131827313);
        this.gCN = (TextView) findViewById(2131827316);
        this.gCO = findViewById(2131827315);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        this.gCN.setText(C4988aa.m7404gx(this.mController.ylL));
        this.gCO.setOnClickListener(new C99511());
        if (C5059g.xyf) {
            C24679a.gkF.mo38871p(this);
            AppMethodBeat.m2505o(125010);
            return;
        }
        C24679a.gkF.mo38862bc(this);
        AppMethodBeat.m2505o(125010);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(125011);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Intent bh = C24679a.gkE.mo38909bh(this);
            bh.addFlags(67108864);
            bh.putExtra("can_finish", true);
            startActivity(bh);
            finish();
            C5274b.m8054hM(this);
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(125011);
        return onKeyDown;
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(125012);
        if (2131827314 == view.getId()) {
            Intent intent = new Intent(this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 1);
            startActivity(intent);
            AppMethodBeat.m2505o(125012);
            return;
        }
        if (2131827313 == view.getId()) {
            if (C7243d.vxr) {
                String string = getString(C25738R.string.b3m, new Object[]{"0x" + Integer.toHexString(C7243d.vxo), C4988aa.dor()});
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", string);
                intent2.putExtra("showShare", false);
                intent2.putExtra("show_bottom", false);
                intent2.putExtra("needRedirect", false);
                intent2.putExtra("neverGetA8Key", true);
                intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                C24679a.gkE.mo38924i(intent2, this);
                AppMethodBeat.m2505o(125012);
                return;
            }
            startActivity(new Intent(this, RegByMobileRegAIOUI.class));
        }
        AppMethodBeat.m2505o(125012);
    }
}
