package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;

@Deprecated
public class LoginSelectorUI extends MMActivity implements OnClickListener {
    private TextView gCN;
    private View gCO;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125008);
        super.onCreate(bundle);
        setTitleVisibility(8);
        a.gkF.BV();
        g.RN();
        com.tencent.mm.kernel.a.Rc();
        initView();
        AppMethodBeat.o(125008);
    }

    public final int getLayoutId() {
        return R.layout.aqq;
    }

    public void onResume() {
        AppMethodBeat.i(125009);
        super.onResume();
        g.RN();
        com.tencent.mm.kernel.a.Rc();
        AppMethodBeat.o(125009);
    }

    public final void initView() {
        AppMethodBeat.i(125010);
        Button button = (Button) findViewById(R.id.e80);
        Button button2 = (Button) findViewById(R.id.e7z);
        this.gCN = (TextView) findViewById(R.id.e82);
        this.gCO = findViewById(R.id.e81);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        this.gCN.setText(aa.gx(this.mController.ylL));
        this.gCO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125007);
                Intent intent = new Intent();
                intent.putExtra("not_auth_setting", true);
                a.gkE.o(intent, LoginSelectorUI.this.mController.ylL);
                AppMethodBeat.o(125007);
            }
        });
        if (com.tencent.mm.sdk.platformtools.g.xyf) {
            a.gkF.p(this);
            AppMethodBeat.o(125010);
            return;
        }
        a.gkF.bc(this);
        AppMethodBeat.o(125010);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(125011);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Intent bh = a.gkE.bh(this);
            bh.addFlags(67108864);
            bh.putExtra("can_finish", true);
            startActivity(bh);
            finish();
            b.hM(this);
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(125011);
        return onKeyDown;
    }

    public void onClick(View view) {
        AppMethodBeat.i(125012);
        if (R.id.e80 == view.getId()) {
            Intent intent = new Intent(this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 1);
            startActivity(intent);
            AppMethodBeat.o(125012);
            return;
        }
        if (R.id.e7z == view.getId()) {
            if (d.vxr) {
                String string = getString(R.string.b3m, new Object[]{"0x" + Integer.toHexString(d.vxo), aa.dor()});
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", string);
                intent2.putExtra("showShare", false);
                intent2.putExtra("show_bottom", false);
                intent2.putExtra("needRedirect", false);
                intent2.putExtra("neverGetA8Key", true);
                intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                a.gkE.i(intent2, this);
                AppMethodBeat.o(125012);
                return;
            }
            startActivity(new Intent(this, RegByMobileRegAIOUI.class));
        }
        AppMethodBeat.o(125012);
    }
}
