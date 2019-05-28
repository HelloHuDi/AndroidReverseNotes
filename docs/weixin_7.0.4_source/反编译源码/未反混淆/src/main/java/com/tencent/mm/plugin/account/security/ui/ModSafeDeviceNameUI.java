package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.b;

public class ModSafeDeviceNameUI extends MMActivity implements f {
    private long createTime;
    private String cws;
    private ProgressDialog ehJ = null;
    private EditText gzq;
    private String gzr;
    private String gzs;
    private String gzt;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69867);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(69867);
    }

    public void onResume() {
        AppMethodBeat.i(69868);
        g.Rg().a(361, (f) this);
        super.onResume();
        AppMethodBeat.o(69868);
    }

    public void onPause() {
        AppMethodBeat.i(69869);
        g.Rg().b(361, (f) this);
        super.onPause();
        AppMethodBeat.o(69869);
    }

    public final void initView() {
        AppMethodBeat.i(69870);
        this.gzr = getIntent().getStringExtra("safe_device_name");
        this.gzt = getIntent().getStringExtra("safe_device_uid");
        this.cws = getIntent().getStringExtra("safe_device_type");
        setMMTitle(a.an(this, R.string.dwb));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69862);
                ModSafeDeviceNameUI.this.finish();
                AppMethodBeat.o(69862);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.tc), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69864);
                ModSafeDeviceNameUI.this.gzs = ModSafeDeviceNameUI.this.gzq.getText().toString();
                if (bo.isNullOrNil(ModSafeDeviceNameUI.this.gzs)) {
                    AppMethodBeat.o(69864);
                } else {
                    ModSafeDeviceNameUI.this.aqX();
                    final m cVar = new c(ModSafeDeviceNameUI.this.gzt, ModSafeDeviceNameUI.this.gzs, ModSafeDeviceNameUI.this.cws);
                    g.Rg().a(cVar, 0);
                    ModSafeDeviceNameUI.this.ehJ = h.b(ModSafeDeviceNameUI.this, a.an(ModSafeDeviceNameUI.this, R.string.un), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(69863);
                            g.Rg().c(cVar);
                            AppMethodBeat.o(69863);
                        }
                    });
                    AppMethodBeat.o(69864);
                }
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new b() {
            public final void aqH() {
                AppMethodBeat.i(69865);
                if (ModSafeDeviceNameUI.this.gzq.getText().toString().trim().length() > 0) {
                    ModSafeDeviceNameUI.this.enableOptionMenu(true);
                    AppMethodBeat.o(69865);
                    return;
                }
                ModSafeDeviceNameUI.this.enableOptionMenu(false);
                AppMethodBeat.o(69865);
            }
        };
        this.gzq = (EditText) findViewById(R.id.dcb);
        MMEditText.c cVar = new MMEditText.c(this.gzq, null, 32);
        cVar.zMo = anonymousClass3;
        this.gzq.addTextChangedListener(cVar);
        if (bo.isNullOrNil(this.gzr)) {
            enableOptionMenu(false);
            AppMethodBeat.o(69870);
            return;
        }
        this.gzq.setText(this.gzr);
        AppMethodBeat.o(69870);
    }

    public final int getLayoutId() {
        return R.layout.ah9;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(69871);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 0 && i2 == 0) {
            d dVar = new d();
            dVar.field_devicetype = this.cws;
            dVar.field_name = this.gzs;
            dVar.field_uid = this.gzt;
            dVar.field_createtime = this.createTime;
            com.tencent.mm.plugin.account.security.a.g.aqG().c(dVar, new String[0]);
            h.bQ(this, a.an(this, R.string.dwf));
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(69866);
                    ModSafeDeviceNameUI.this.finish();
                    AppMethodBeat.o(69866);
                }
            }, 1000);
            AppMethodBeat.o(69871);
        } else if (com.tencent.mm.plugin.account.a.a.gkF.a((Context) this, i, i2, str)) {
            AppMethodBeat.o(69871);
        } else {
            AppMethodBeat.o(69871);
        }
    }
}
