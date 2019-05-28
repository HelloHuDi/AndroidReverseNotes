package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.b;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletIbgAdapterUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47838);
        super.onCreate(bundle);
        AM(4);
        this.Ahr.nf(1564);
        a(new b(), true, false);
        AppMethodBeat.o(47838);
    }

    public void onResume() {
        AppMethodBeat.i(47839);
        super.onResume();
        AppMethodBeat.o(47839);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47840);
        if (i == 0 && i2 == 0 && (mVar instanceof b)) {
            int i3 = ((b) mVar).tuH;
            String str2 = ((b) mVar).jumpUrl;
            ab.i("MicroMsg.WalletH5AdapterUI", "hy: get success! url is: %s, download x5 = %b", str2, Integer.valueOf(i3));
            if (i3 == 1) {
                ab.i("MicroMsg.WalletH5AdapterUI", "now status = %d", Integer.valueOf(v.a.dhq()));
                switch (v.a.dhq()) {
                    case 1:
                    case 4:
                        i3 = 1;
                        break;
                    case 2:
                    case 3:
                        g.RQ();
                        if (((Boolean) g.RP().Ry().get(ac.a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                            Toast.makeText(this, getString(R.string.fzh), 1).show();
                            v.a.dhr();
                            finish();
                        } else {
                            cSv();
                        }
                        i3 = 0;
                        break;
                    default:
                        cSv();
                        i3 = 0;
                        break;
                }
                if (i3 != 0) {
                    adg(str2);
                    finish();
                    AppMethodBeat.o(47840);
                }
                AppMethodBeat.o(47840);
            } else {
                adg(str2);
                finish();
                AppMethodBeat.o(47840);
            }
        } else {
            com.tencent.mm.wallet_core.a.b((Activity) this, null, 0);
            AppMethodBeat.o(47840);
        }
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.i(47841);
        this.Ahr.ng(1564);
        super.onDestroy();
        AppMethodBeat.o(47841);
    }

    private void adg(String str) {
        AppMethodBeat.i(47842);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(47842);
    }

    private void cSv() {
        AppMethodBeat.i(47843);
        g.RQ();
        g.RP().Ry().set(ac.a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.TRUE);
        h.a((Context) this, false, getString(R.string.fzk), "", getString(R.string.fzf), getString(R.string.fze), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(47836);
                v.a.dhr();
                Toast.makeText(WalletIbgAdapterUI.this, WalletIbgAdapterUI.this.getString(R.string.fzg), 1).show();
                WalletIbgAdapterUI.this.finish();
                AppMethodBeat.o(47836);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(47837);
                WalletIbgAdapterUI.this.finish();
                AppMethodBeat.o(47837);
            }
        });
        AppMethodBeat.o(47843);
    }

    public final int getLayoutId() {
        return -1;
    }
}
