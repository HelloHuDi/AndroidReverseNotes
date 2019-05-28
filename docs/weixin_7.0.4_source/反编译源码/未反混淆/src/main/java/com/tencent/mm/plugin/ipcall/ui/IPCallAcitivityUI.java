package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class IPCallAcitivityUI extends MMActivity {
    private FrameLayout nAo;
    private TextView nAp;
    private TextView nAq;
    private Button nAr;
    private CdnImageView nAs;
    private boolean nAt = false;
    private com.tencent.mm.plugin.ipcall.a.g.a nAu;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return R.layout.a8r;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21989);
        super.onCreate(bundle);
        getWindow().addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.mController.hideTitleView();
        initView();
        AppMethodBeat.o(21989);
    }

    public void onDestroy() {
        AppMethodBeat.i(21990);
        super.onDestroy();
        AppMethodBeat.o(21990);
    }

    public final void initView() {
        AppMethodBeat.i(21991);
        this.nAo = (FrameLayout) findViewById(R.id.clh);
        this.nAp = (TextView) findViewById(R.id.clj);
        this.nAq = (TextView) findViewById(R.id.cll);
        this.nAr = (Button) findViewById(R.id.cln);
        this.nAs = (CdnImageView) findViewById(R.id.clm);
        ard();
        this.nAo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21986);
                IPCallAcitivityUI.this.finish();
                AppMethodBeat.o(21986);
            }
        });
        this.nAr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21987);
                if (IPCallAcitivityUI.this.nAu.jCt == 1) {
                    ab.i("MicroMsg.IPCallAcitivityUI", "click activity, go to IPCallPackageUI");
                    Intent intent = new Intent();
                    intent.setClass(IPCallAcitivityUI.this.mController.ylL, IPCallShareCouponUI.class);
                    IPCallAcitivityUI.this.startActivity(intent);
                    intent = new Intent();
                    intent.setClass(IPCallAcitivityUI.this.mController.ylL, IPCallPackageUI.class);
                    IPCallAcitivityUI.this.startActivity(intent);
                }
                IPCallAcitivityUI.this.nAt = true;
                IPCallAcitivityUI.this.finish();
                AppMethodBeat.o(21987);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21988);
                IPCallAcitivityUI.this.finish();
                AppMethodBeat.o(21988);
                return true;
            }
        });
        AppMethodBeat.o(21991);
    }

    private void ard() {
        AppMethodBeat.i(21992);
        aw.ZK();
        String str = (String) c.Ry().get(ac.a.USERFINO_IPCALL_ACTIVITY_STRING, (Object) "");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.IPCallAcitivityUI", "xml is empty");
            finish();
            AppMethodBeat.o(21992);
            return;
        }
        this.nAu = com.tencent.mm.plugin.ipcall.a.g.a.OO(str);
        if (this.nAu == null) {
            ab.e("MicroMsg.IPCallAcitivityUI", "mMsgInfo is null");
            finish();
            AppMethodBeat.o(21992);
            return;
        }
        this.nAp.setText(this.nAu.Title);
        this.nAq.setText(this.nAu.Desc);
        this.nAr.setText(this.nAu.nzv);
        this.nAs.setUrl(this.nAu.ImgUrl);
        AppMethodBeat.o(21992);
    }

    public void finish() {
        AppMethodBeat.i(21993);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.c9);
        if (this.nAt) {
            com.tencent.mm.plugin.ipcall.a.e.c.xl(1);
            AppMethodBeat.o(21993);
            return;
        }
        com.tencent.mm.plugin.ipcall.a.e.c.xl(0);
        AppMethodBeat.o(21993);
    }

    public void onBackPressed() {
        AppMethodBeat.i(21994);
        super.onBackPressed();
        AppMethodBeat.o(21994);
    }
}
