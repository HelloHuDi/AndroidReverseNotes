package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.g.b;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;

public class ClearCacheUI extends MMBaseActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29169);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_message");
        final long longExtra = getIntent().getLongExtra("key_mask", 0);
        h.a((Context) this, stringExtra, getString(R.string.ar0), getString(R.string.aqz), getString(R.string.aqx), false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(29165);
                ClearCacheUI.a(ClearCacheUI.this, longExtra);
                ClearCacheUI.this.finish();
                AppMethodBeat.o(29165);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(29166);
                ClearCacheUI.this.finish();
                AppMethodBeat.o(29166);
            }
        });
        AppMethodBeat.o(29169);
    }

    static /* synthetic */ void a(ClearCacheUI clearCacheUI, final long j) {
        AppMethodBeat.i(29170);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(29168);
                ab.w("MicroMsg.ClearCacheUI", "doClearCache flag %d", Long.valueOf(j));
                if ((j & 1) != 0) {
                    e.N(c.bGF(), true);
                }
                if ((j & 2) != 0) {
                    e.N(b.eSG, true);
                }
                if ((j & 4) != 0) {
                    e.N(com.tencent.mm.compatible.util.e.euX, true);
                }
                if ((j & 8) != 0) {
                    aw.ZK();
                    e.N(com.tencent.mm.model.c.Yf(), true);
                }
                if ((j & 16) != 0) {
                    e.N(com.tencent.mm.plugin.avatar.c.aSn(), true);
                }
                if ((j & 32) != 0) {
                    aw.ZK();
                    e.N(com.tencent.mm.model.c.Ya(), true);
                }
                if ((j & 64) != 0) {
                    aw.ZK();
                    e.N(com.tencent.mm.model.c.getAccSnsPath(), true);
                }
                bq bqVar = new bq();
                bqVar.cuL.cuM = j;
                a.xxA.m(bqVar);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29167);
                        Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.aqy), 0).show();
                        AppMethodBeat.o(29167);
                    }
                });
                AppMethodBeat.o(29168);
            }
        }, "CleanCacheUIThread");
        AppMethodBeat.o(29170);
    }
}
