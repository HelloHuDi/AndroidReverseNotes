package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14224ae;
import com.tencent.p177mm.protocal.protobuf.bcj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletDelayTransferSettingUI */
public class WalletDelayTransferSettingUI extends MMPreference implements C1202f {
    private C15541f ehK;
    private long kFU;
    private String mTitle;
    private String pRz;
    private Preference trh;
    private Preference tri;
    private Preference trj;
    private Preference trk;
    private String trl;
    private int trm = 0;

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletDelayTransferSettingUI$2 */
    class C296062 implements OnMenuItemClickListener {
        C296062() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(46240);
            WalletDelayTransferSettingUI.this.finish();
            AppMethodBeat.m2505o(46240);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletDelayTransferSettingUI$1 */
    class C296071 implements OnMenuItemClickListener {
        C296071() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(46239);
            C36391e.m60016n(WalletDelayTransferSettingUI.this.mController.ylL, WalletDelayTransferSettingUI.this.pRz, false);
            AppMethodBeat.m2505o(46239);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    private void cOv() {
        AppMethodBeat.m2504i(46242);
        if (this.trm != 1 || C5046bo.isNullOrNil(this.pRz)) {
            this.mController.removeAllOptionMenu();
            AppMethodBeat.m2505o(46242);
            return;
        }
        addIconOptionMenu(0, C25738R.drawable.bli, new C296071());
        AppMethodBeat.m2505o(46242);
    }

    public final void initView() {
        AppMethodBeat.m2504i(46243);
        this.trh = this.ehK.aqO("wallet_transfer_realtime");
        this.tri = this.ehK.aqO("wallet_transfer_2h");
        this.trj = this.ehK.aqO("wallet_transfer_24h");
        this.trk = this.ehK.aqO("wallet_transfer_title_tips");
        this.trh.mo39406NW(8);
        this.tri.mo39406NW(8);
        this.trj.mo39406NW(8);
        cOw();
        setBackBtn(new C296062());
        AppMethodBeat.m2505o(46243);
    }

    public void onDestroy() {
        int i = 1;
        AppMethodBeat.m2504i(46244);
        super.onDestroy();
        C4990ab.m7417i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", Long.valueOf(this.kFU));
        if (!m46959Be(16)) {
            i = m46959Be(32) ? 2 : 0;
        }
        bcj bcj = new bcj();
        bcj.pXD = i;
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(205, bcj));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
        AppMethodBeat.m2505o(46244);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return -1;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46246);
        if (c1207m instanceof C14224ae) {
            if (i == 0 && i2 == 0) {
                this.trl = ((C14224ae) c1207m).tuC;
                this.mTitle = ((C14224ae) c1207m).tuB;
                this.pRz = ((C14224ae) c1207m).tuE;
                this.trm = ((C14224ae) c1207m).tuF;
                if (C5046bo.isNullOrNil(this.trl)) {
                    C4990ab.m7416i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
                    this.trk.setTitle((int) C25738R.string.fe8);
                } else {
                    this.trk.setTitle(this.trl);
                }
                if (C5046bo.isNullOrNil(this.mTitle)) {
                    C4990ab.m7416i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
                    setMMTitle((int) C25738R.string.fmb);
                } else {
                    setMMTitle(this.mTitle);
                }
                cOv();
            } else {
                C4990ab.m7416i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
                this.trk.setTitle((int) C25738R.string.fe8);
                setMMTitle((int) C25738R.string.fmb);
            }
            this.ehK.notifyDataSetChanged();
            AppMethodBeat.m2505o(46246);
            return;
        }
        C4990ab.m7416i("MicroMsg.WalletDelayTransferSettingUI", "other scene");
        AppMethodBeat.m2505o(46246);
    }

    /* renamed from: Be */
    private boolean m46959Be(int i) {
        return (this.kFU & ((long) i)) != 0;
    }

    private void cOw() {
        AppMethodBeat.m2504i(46247);
        if (m46959Be(16)) {
            cOy();
            AppMethodBeat.m2505o(46247);
        } else if (m46959Be(32)) {
            cOz();
            AppMethodBeat.m2505o(46247);
        } else {
            cOx();
            AppMethodBeat.m2505o(46247);
        }
    }

    private void cOx() {
        AppMethodBeat.m2504i(46248);
        this.trh.setWidgetLayoutResource(2130970197);
        this.tri.setWidgetLayoutResource(2130970198);
        this.trj.setWidgetLayoutResource(2130970198);
        AppMethodBeat.m2505o(46248);
    }

    private void cOy() {
        AppMethodBeat.m2504i(46249);
        this.trh.setWidgetLayoutResource(2130970198);
        this.tri.setWidgetLayoutResource(2130970197);
        this.trj.setWidgetLayoutResource(2130970198);
        AppMethodBeat.m2505o(46249);
    }

    private void cOz() {
        AppMethodBeat.m2504i(46250);
        this.trh.setWidgetLayoutResource(2130970198);
        this.tri.setWidgetLayoutResource(2130970198);
        this.trj.setWidgetLayoutResource(2130970197);
        AppMethodBeat.m2505o(46250);
    }

    public void onCreate(Bundle bundle) {
        boolean a;
        AppMethodBeat.m2504i(46241);
        this.yll = true;
        super.onCreate(bundle);
        mo17446xE(this.mController.dyj());
        this.ehK = this.yCw;
        this.ehK.addPreferencesFromResource(C25738R.xml.f8577cq);
        C1720g.m3537RQ();
        this.kFU = ((Long) C1720g.m3536RP().mo5239Ry().get(147457, Long.valueOf(0))).longValue();
        initView();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(385, (C1202f) this);
        C1720g.m3537RQ();
        this.trl = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_DELAY_TRANSFER_REMIND_WORDING_STRING, (Object) "");
        C1720g.m3537RQ();
        this.mTitle = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_DELAY_TRANSFER_SWITCH_WORDING_STRING, (Object) "");
        C1720g.m3537RQ();
        this.pRz = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_DELAY_TRANSFER_DESC_URL_STRING, (Object) "");
        C1720g.m3537RQ();
        this.trm = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT, Integer.valueOf(0))).intValue();
        if (C5046bo.isNullOrNil(this.trl) || C5046bo.isNullOrNil(this.mTitle) || C5046bo.isNullOrNil(this.pRz)) {
            a = C14224ae.m22423a(true, null);
        } else {
            this.trk.setTitle(this.trl);
            setMMTitle(this.mTitle);
            cOv();
            a = C14224ae.m22423a(false, null);
        }
        C36391e.dOJ();
        if (!a) {
            C4990ab.m7416i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
        }
        AppMethodBeat.m2505o(46241);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(46245);
        String str = preference.mKey;
        if ("wallet_transfer_realtime".equals(str)) {
            this.kFU &= -17;
            this.kFU &= -33;
        } else if ("wallet_transfer_2h".equals(str)) {
            this.kFU &= -33;
            this.kFU |= 16;
        } else if ("wallet_transfer_24h".equals(str)) {
            this.kFU &= -17;
            this.kFU |= 32;
        }
        cOw();
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(147457, Long.valueOf(this.kFU));
        finish();
        AppMethodBeat.m2505o(46245);
        return true;
    }
}
