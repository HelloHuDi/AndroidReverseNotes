package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.wallet_core.ui.e;

public class WalletDelayTransferSettingUI extends MMPreference implements f {
    private com.tencent.mm.ui.base.preference.f ehK;
    private long kFU;
    private String mTitle;
    private String pRz;
    private Preference trh;
    private Preference tri;
    private Preference trj;
    private Preference trk;
    private String trl;
    private int trm = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    private void cOv() {
        AppMethodBeat.i(46242);
        if (this.trm != 1 || bo.isNullOrNil(this.pRz)) {
            this.mController.removeAllOptionMenu();
            AppMethodBeat.o(46242);
            return;
        }
        addIconOptionMenu(0, R.drawable.bli, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(46239);
                e.n(WalletDelayTransferSettingUI.this.mController.ylL, WalletDelayTransferSettingUI.this.pRz, false);
                AppMethodBeat.o(46239);
                return false;
            }
        });
        AppMethodBeat.o(46242);
    }

    public final void initView() {
        AppMethodBeat.i(46243);
        this.trh = this.ehK.aqO("wallet_transfer_realtime");
        this.tri = this.ehK.aqO("wallet_transfer_2h");
        this.trj = this.ehK.aqO("wallet_transfer_24h");
        this.trk = this.ehK.aqO("wallet_transfer_title_tips");
        this.trh.NW(8);
        this.tri.NW(8);
        this.trj.NW(8);
        cOw();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(46240);
                WalletDelayTransferSettingUI.this.finish();
                AppMethodBeat.o(46240);
                return false;
            }
        });
        AppMethodBeat.o(46243);
    }

    public void onDestroy() {
        int i = 1;
        AppMethodBeat.i(46244);
        super.onDestroy();
        ab.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", Long.valueOf(this.kFU));
        if (!Be(16)) {
            i = Be(32) ? 2 : 0;
        }
        bcj bcj = new bcj();
        bcj.pXD = i;
        ((j) g.K(j.class)).XL().c(new a(205, bcj));
        g.RQ();
        g.RO().eJo.b(385, (f) this);
        AppMethodBeat.o(46244);
    }

    public final int JC() {
        return -1;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46246);
        if (mVar instanceof ae) {
            if (i == 0 && i2 == 0) {
                this.trl = ((ae) mVar).tuC;
                this.mTitle = ((ae) mVar).tuB;
                this.pRz = ((ae) mVar).tuE;
                this.trm = ((ae) mVar).tuF;
                if (bo.isNullOrNil(this.trl)) {
                    ab.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
                    this.trk.setTitle((int) R.string.fe8);
                } else {
                    this.trk.setTitle(this.trl);
                }
                if (bo.isNullOrNil(this.mTitle)) {
                    ab.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
                    setMMTitle((int) R.string.fmb);
                } else {
                    setMMTitle(this.mTitle);
                }
                cOv();
            } else {
                ab.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
                this.trk.setTitle((int) R.string.fe8);
                setMMTitle((int) R.string.fmb);
            }
            this.ehK.notifyDataSetChanged();
            AppMethodBeat.o(46246);
            return;
        }
        ab.i("MicroMsg.WalletDelayTransferSettingUI", "other scene");
        AppMethodBeat.o(46246);
    }

    private boolean Be(int i) {
        return (this.kFU & ((long) i)) != 0;
    }

    private void cOw() {
        AppMethodBeat.i(46247);
        if (Be(16)) {
            cOy();
            AppMethodBeat.o(46247);
        } else if (Be(32)) {
            cOz();
            AppMethodBeat.o(46247);
        } else {
            cOx();
            AppMethodBeat.o(46247);
        }
    }

    private void cOx() {
        AppMethodBeat.i(46248);
        this.trh.setWidgetLayoutResource(R.layout.ag0);
        this.tri.setWidgetLayoutResource(R.layout.ag1);
        this.trj.setWidgetLayoutResource(R.layout.ag1);
        AppMethodBeat.o(46248);
    }

    private void cOy() {
        AppMethodBeat.i(46249);
        this.trh.setWidgetLayoutResource(R.layout.ag1);
        this.tri.setWidgetLayoutResource(R.layout.ag0);
        this.trj.setWidgetLayoutResource(R.layout.ag1);
        AppMethodBeat.o(46249);
    }

    private void cOz() {
        AppMethodBeat.i(46250);
        this.trh.setWidgetLayoutResource(R.layout.ag1);
        this.tri.setWidgetLayoutResource(R.layout.ag1);
        this.trj.setWidgetLayoutResource(R.layout.ag0);
        AppMethodBeat.o(46250);
    }

    public void onCreate(Bundle bundle) {
        boolean a;
        AppMethodBeat.i(46241);
        this.yll = true;
        super.onCreate(bundle);
        xE(this.mController.dyj());
        this.ehK = this.yCw;
        this.ehK.addPreferencesFromResource(R.xml.cq);
        g.RQ();
        this.kFU = ((Long) g.RP().Ry().get(147457, Long.valueOf(0))).longValue();
        initView();
        g.RQ();
        g.RO().eJo.a(385, (f) this);
        g.RQ();
        this.trl = (String) g.RP().Ry().get(ac.a.USERINFO_DELAY_TRANSFER_REMIND_WORDING_STRING, (Object) "");
        g.RQ();
        this.mTitle = (String) g.RP().Ry().get(ac.a.USERINFO_DELAY_TRANSFER_SWITCH_WORDING_STRING, (Object) "");
        g.RQ();
        this.pRz = (String) g.RP().Ry().get(ac.a.USERINFO_DELAY_TRANSFER_DESC_URL_STRING, (Object) "");
        g.RQ();
        this.trm = ((Integer) g.RP().Ry().get(ac.a.USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT, Integer.valueOf(0))).intValue();
        if (bo.isNullOrNil(this.trl) || bo.isNullOrNil(this.mTitle) || bo.isNullOrNil(this.pRz)) {
            a = ae.a(true, null);
        } else {
            this.trk.setTitle(this.trl);
            setMMTitle(this.mTitle);
            cOv();
            a = ae.a(false, null);
        }
        e.dOJ();
        if (!a) {
            ab.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
            g.RQ();
            g.RO().eJo.b(385, (f) this);
        }
        AppMethodBeat.o(46241);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(46245);
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
        g.RQ();
        g.RP().Ry().set(147457, Long.valueOf(this.kFU));
        finish();
        AppMethodBeat.o(46245);
        return true;
    }
}
