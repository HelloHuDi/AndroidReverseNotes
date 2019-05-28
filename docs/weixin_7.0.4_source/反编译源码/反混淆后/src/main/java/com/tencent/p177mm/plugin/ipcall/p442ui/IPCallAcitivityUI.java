package com.tencent.p177mm.plugin.ipcall.p442ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.ipcall.p438a.p441e.C39259c;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C43224a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAcitivityUI */
public class IPCallAcitivityUI extends MMActivity {
    private FrameLayout nAo;
    private TextView nAp;
    private TextView nAq;
    private Button nAr;
    private CdnImageView nAs;
    private boolean nAt = false;
    private C43224a nAu;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAcitivityUI$1 */
    class C122581 implements OnClickListener {
        C122581() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21986);
            IPCallAcitivityUI.this.finish();
            AppMethodBeat.m2505o(21986);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAcitivityUI$3 */
    class C122593 implements OnMenuItemClickListener {
        C122593() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(21988);
            IPCallAcitivityUI.this.finish();
            AppMethodBeat.m2505o(21988);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAcitivityUI$2 */
    class C122602 implements OnClickListener {
        C122602() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21987);
            if (IPCallAcitivityUI.this.nAu.jCt == 1) {
                C4990ab.m7416i("MicroMsg.IPCallAcitivityUI", "click activity, go to IPCallPackageUI");
                Intent intent = new Intent();
                intent.setClass(IPCallAcitivityUI.this.mController.ylL, IPCallShareCouponUI.class);
                IPCallAcitivityUI.this.startActivity(intent);
                intent = new Intent();
                intent.setClass(IPCallAcitivityUI.this.mController.ylL, IPCallPackageUI.class);
                IPCallAcitivityUI.this.startActivity(intent);
            }
            IPCallAcitivityUI.this.nAt = true;
            IPCallAcitivityUI.this.finish();
            AppMethodBeat.m2505o(21987);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return 2130969892;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21989);
        super.onCreate(bundle);
        getWindow().addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.mController.hideTitleView();
        initView();
        AppMethodBeat.m2505o(21989);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(21990);
        super.onDestroy();
        AppMethodBeat.m2505o(21990);
    }

    public final void initView() {
        AppMethodBeat.m2504i(21991);
        this.nAo = (FrameLayout) findViewById(2131825113);
        this.nAp = (TextView) findViewById(2131825115);
        this.nAq = (TextView) findViewById(2131825117);
        this.nAr = (Button) findViewById(2131825119);
        this.nAs = (CdnImageView) findViewById(2131825118);
        ard();
        this.nAo.setOnClickListener(new C122581());
        this.nAr.setOnClickListener(new C122602());
        setBackBtn(new C122593());
        AppMethodBeat.m2505o(21991);
    }

    private void ard() {
        AppMethodBeat.m2504i(21992);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_ACTIVITY_STRING, (Object) "");
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.IPCallAcitivityUI", "xml is empty");
            finish();
            AppMethodBeat.m2505o(21992);
            return;
        }
        this.nAu = C43224a.m76873OO(str);
        if (this.nAu == null) {
            C4990ab.m7412e("MicroMsg.IPCallAcitivityUI", "mMsgInfo is null");
            finish();
            AppMethodBeat.m2505o(21992);
            return;
        }
        this.nAp.setText(this.nAu.Title);
        this.nAq.setText(this.nAu.Desc);
        this.nAr.setText(this.nAu.nzv);
        this.nAs.setUrl(this.nAu.ImgUrl);
        AppMethodBeat.m2505o(21992);
    }

    public void finish() {
        AppMethodBeat.m2504i(21993);
        super.finish();
        overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8367c9);
        if (this.nAt) {
            C39259c.m66908xl(1);
            AppMethodBeat.m2505o(21993);
            return;
        }
        C39259c.m66908xl(0);
        AppMethodBeat.m2505o(21993);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(21994);
        super.onBackPressed();
        AppMethodBeat.m2505o(21994);
    }
}
