package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.f;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@TargetApi(19)
public final class a {
    public static a hSt;
    ResultReceiver JF;
    private int hSj = 0;
    boolean hSk = false;
    boolean hSl = false;
    boolean hSm = false;
    Timer hSn;
    TimerTask hSo;
    ComponentName hSp;
    Activity hSq;
    f hSr;
    private c hSs = null;
    private final Handler mHandler = new Handler();

    public a() {
        AppMethodBeat.i(137891);
        AppMethodBeat.o(137891);
    }

    static /* synthetic */ void a(a aVar, int i, String str) {
        AppMethodBeat.i(137905);
        aVar.V(i, str);
        AppMethodBeat.o(137905);
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(137901);
        aVar.aEu();
        AppMethodBeat.o(137901);
    }

    static /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(137902);
        aVar.aEv();
        AppMethodBeat.o(137902);
    }

    static {
        AppMethodBeat.i(137906);
        hSt = null;
        hSt = new a();
        AppMethodBeat.o(137906);
    }

    private void aDw() {
        AppMethodBeat.i(137892);
        if (this.hSr != null) {
            this.hSr.dismiss();
            this.hSr = null;
        }
        AppMethodBeat.o(137892);
    }

    /* Access modifiers changed, original: final */
    public final void aEu() {
        AppMethodBeat.i(137893);
        if (!d.aEB()) {
            U(13000, "not support NFC");
            AppMethodBeat.o(137893);
        } else if (!d.aEA()) {
            U(13002, "not support HCE");
            AppMethodBeat.o(137893);
        } else if (d.aEC()) {
            aEv();
            AppMethodBeat.o(137893);
        } else if (this.hSq == null) {
            ab.e("MicroMsg.HCEActivityMgr", "alvinluo showOpenNFCDialog mHceActivity is null");
            AppMethodBeat.o(137893);
        } else if (this.hSk) {
            ab.i("MicroMsg.HCEActivityMgr", "alvinluo has shown open NFC dialog");
            p(13001, "system NFC switch not opened", this.hSq.getString(R.string.cuo));
            AppMethodBeat.o(137893);
        } else {
            boolean z;
            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this.hSq);
            aVar.asE(this.hSq.getString(R.string.cuq)).asJ(this.hSq.getString(R.string.cum)).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(137886);
                    a.f(a.this);
                    AppMethodBeat.o(137886);
                }
            });
            if (this.hSq == null) {
                ab.e("MicroMsg.HCEActivityMgr", "alvinluo isCanJumpNFCSetting mHceActivity is null");
                z = false;
            } else {
                List queryIntentActivities = this.hSq.getPackageManager().queryIntentActivities(new Intent("android.settings.NFC_SETTINGS"), 65536);
                if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                    ab.e("MicroMsg.HCEActivityMgr", "alvinluo Cannot jump to NFC setting");
                    z = false;
                } else {
                    ab.i("MicroMsg.HCEActivityMgr", "alvinluo NFC activity not null, activities size: " + queryIntentActivities.size());
                    for (int i = 0; i < queryIntentActivities.size(); i++) {
                        ab.i("MicroMsg.HCEActivityMgr", "alvinluo NFC activity: %s", ((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name);
                    }
                    z = true;
                }
            }
            if (z) {
                aVar.asK(this.hSq.getString(R.string.cu_)).b(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(137887);
                        ab.i("MicroMsg.HCEActivityMgr", "alvinluo user click cancel button of NFC tips dialog.");
                        a.a(a.this, "system NFC switch not opened");
                        AppMethodBeat.o(137887);
                    }
                });
            } else {
                aVar.asJ(this.hSq.getString(R.string.cua));
            }
            aVar.f(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(137888);
                    ab.i("MicroMsg.HCEActivityMgr", "alvinluo cancel by pressing back");
                    a.a(a.this, "system NFC switch not opened");
                    AppMethodBeat.o(137888);
                }
            });
            this.hSs = aVar.aMb();
            this.hSs.setCanceledOnTouchOutside(false);
            this.hSs.show();
            this.hSk = true;
            AppMethodBeat.o(137893);
        }
    }

    @TargetApi(19)
    private void aEv() {
        AppMethodBeat.i(137894);
        if (this.hSq == null) {
            ab.e("MicroMsg.HCEActivityMgr", "alvinluo checkDefaultNFCApplication mHceActivity is null");
            AppMethodBeat.o(137894);
            return;
        }
        CardEmulation instance = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(this.hSq));
        ab.i("MicroMsg.HCEActivityMgr", "alvinluo component name: " + this.hSp);
        if (instance.isDefaultServiceForCategory(this.hSp, "payment")) {
            ab.i("MicroMsg.HCEActivityMgr", "alvinluo now is NFC Default Application");
            V(0, "NFC switch has opened and now is NFC default application");
            AppMethodBeat.o(137894);
            return;
        }
        ab.i("MicroMsg.HCEActivityMgr", "alvinluo not NFC Default Application, isAutoSet: %b", Boolean.TRUE);
        b(this.hSp);
        AppMethodBeat.o(137894);
    }

    @TargetApi(19)
    private void b(final ComponentName componentName) {
        AppMethodBeat.i(137895);
        if (this.hSq == null) {
            ab.e("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication mHceActivity is null");
            AppMethodBeat.o(137895);
            return;
        }
        ab.i("MicroMsg.HCEActivityMgr", "alvinluo request set default NFC application, hasRequestSetDefault: %b", Boolean.valueOf(this.hSm));
        if (this.hSm) {
            ab.i("MicroMsg.HCEActivityMgr", "alvinluo has request set default NFC application");
            p(13004, "not set default NFC application", this.hSq.getString(R.string.cup));
            AppMethodBeat.o(137895);
            return;
        }
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(137889);
                a.this.hSm = true;
                Intent intent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
                intent.putExtra("category", "payment");
                intent.putExtra("component", componentName);
                a.this.hSq.startActivityForResult(intent, 2);
                AppMethodBeat.o(137889);
            }
        }, 200);
        AppMethodBeat.o(137895);
    }

    private void p(final int i, final String str, String str2) {
        AppMethodBeat.i(137896);
        dismissDialog();
        if (this.hSq == null) {
            ab.e("MicroMsg.HCEActivityMgr", "alvinluo showErrorDialog mHceActivity is null");
            AppMethodBeat.o(137896);
            return;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this.hSq);
        aVar.asD("");
        aVar.asE(str2);
        aVar.asJ(this.hSq.getString(R.string.cua)).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(137890);
                a.a(a.this, i, str);
                AppMethodBeat.o(137890);
            }
        });
        aVar.rc(true);
        this.hSs = aVar.aMb();
        this.hSs.setCanceledOnTouchOutside(false);
        this.hSs.show();
        AppMethodBeat.o(137896);
    }

    public final void dismissDialog() {
        AppMethodBeat.i(137897);
        if (this.hSs != null && this.hSs.isShowing()) {
            this.hSs.dismiss();
            this.hSs = null;
        }
        aDw();
        AppMethodBeat.o(137897);
    }

    private void U(int i, String str) {
        AppMethodBeat.i(137898);
        Bundle bundle = new Bundle();
        bundle.putInt("errCode", i);
        bundle.putString("errMsg", str);
        this.JF.send(10001, bundle);
        AppMethodBeat.o(137898);
    }

    private void V(int i, String str) {
        AppMethodBeat.i(137899);
        Bundle bundle = new Bundle();
        bundle.putInt("errCode", i);
        bundle.putString("errMsg", str);
        this.JF.send(10001, bundle);
        if (this.hSq != null) {
            this.hSq.finish();
        }
        AppMethodBeat.o(137899);
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(137900);
        aVar.dismissDialog();
        if (aVar.hSn != null) {
            aVar.hSn.cancel();
        }
        AppMethodBeat.o(137900);
    }

    static /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(137903);
        if (aVar.hSq == null) {
            ab.e("MicroMsg.HCEActivityMgr", "alvinluo jumpNFCSetting mHceActivity is null");
            AppMethodBeat.o(137903);
            return;
        }
        aVar.hSq.startActivityForResult(new Intent("android.settings.NFC_SETTINGS"), 1);
        AppMethodBeat.o(137903);
    }

    static /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(137904);
        aVar.V(13001, str);
        AppMethodBeat.o(137904);
    }
}
