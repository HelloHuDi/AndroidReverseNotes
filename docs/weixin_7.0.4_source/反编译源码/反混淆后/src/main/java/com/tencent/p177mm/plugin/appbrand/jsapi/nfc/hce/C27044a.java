package com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.p633a.C30800f;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce.p1471a.C33384d;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@TargetApi(19)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a */
public final class C27044a {
    public static C27044a hSt;
    /* renamed from: JF */
    ResultReceiver f13674JF;
    private int hSj = 0;
    boolean hSk = false;
    boolean hSl = false;
    boolean hSm = false;
    Timer hSn;
    TimerTask hSo;
    ComponentName hSp;
    Activity hSq;
    C30800f hSr;
    private C5653c hSs = null;
    private final Handler mHandler = new Handler();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a$2 */
    class C270452 implements OnClickListener {
        C270452() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(137886);
            C27044a.m42993f(C27044a.this);
            AppMethodBeat.m2505o(137886);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a$3 */
    class C270463 implements OnClickListener {
        C270463() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(137887);
            C4990ab.m7416i("MicroMsg.HCEActivityMgr", "alvinluo user click cancel button of NFC tips dialog.");
            C27044a.m42987a(C27044a.this, "system NFC switch not opened");
            AppMethodBeat.m2505o(137887);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a$1 */
    class C270481 extends TimerTask {

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a$1$1 */
        class C104971 implements Runnable {
            C104971() {
            }

            public final void run() {
                AppMethodBeat.m2504i(137884);
                if (C27044a.this.hSj > 10) {
                    C4990ab.m7417i("MicroMsg.HCEActivityMgr", "alvinluo loop check count exceed max limit: %d", Integer.valueOf(10));
                    C27044a.m42990c(C27044a.this);
                    C27044a.m42991d(C27044a.this);
                    AppMethodBeat.m2505o(137884);
                    return;
                }
                if (C33384d.aEC()) {
                    C4990ab.m7416i("MicroMsg.HCEActivityMgr", "alvinluo loopCheck NFC switch is opened, and cancel task");
                    C27044a.m42990c(C27044a.this);
                    C27044a.m42992e(C27044a.this);
                }
                AppMethodBeat.m2505o(137884);
            }
        }

        C270481() {
        }

        public final void run() {
            AppMethodBeat.m2504i(137885);
            C4990ab.m7417i("MicroMsg.HCEActivityMgr", "alvinluo loop check NFC switch currentCount: %d", Integer.valueOf(C27044a.this.hSj));
            C27044a.this.hSj = C27044a.this.hSj + 1;
            C45673m.runOnUiThread(new C104971());
            AppMethodBeat.m2505o(137885);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a$4 */
    class C270494 implements OnCancelListener {
        C270494() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(137888);
            C4990ab.m7416i("MicroMsg.HCEActivityMgr", "alvinluo cancel by pressing back");
            C27044a.m42987a(C27044a.this, "system NFC switch not opened");
            AppMethodBeat.m2505o(137888);
        }
    }

    public C27044a() {
        AppMethodBeat.m2504i(137891);
        AppMethodBeat.m2505o(137891);
    }

    /* renamed from: a */
    static /* synthetic */ void m42986a(C27044a c27044a, int i, String str) {
        AppMethodBeat.m2504i(137905);
        c27044a.m42984V(i, str);
        AppMethodBeat.m2505o(137905);
    }

    /* renamed from: d */
    static /* synthetic */ void m42991d(C27044a c27044a) {
        AppMethodBeat.m2504i(137901);
        c27044a.aEu();
        AppMethodBeat.m2505o(137901);
    }

    /* renamed from: e */
    static /* synthetic */ void m42992e(C27044a c27044a) {
        AppMethodBeat.m2504i(137902);
        c27044a.aEv();
        AppMethodBeat.m2505o(137902);
    }

    static {
        AppMethodBeat.m2504i(137906);
        hSt = null;
        hSt = new C27044a();
        AppMethodBeat.m2505o(137906);
    }

    private void aDw() {
        AppMethodBeat.m2504i(137892);
        if (this.hSr != null) {
            this.hSr.dismiss();
            this.hSr = null;
        }
        AppMethodBeat.m2505o(137892);
    }

    /* Access modifiers changed, original: final */
    public final void aEu() {
        AppMethodBeat.m2504i(137893);
        if (!C33384d.aEB()) {
            m42983U(13000, "not support NFC");
            AppMethodBeat.m2505o(137893);
        } else if (!C33384d.aEA()) {
            m42983U(13002, "not support HCE");
            AppMethodBeat.m2505o(137893);
        } else if (C33384d.aEC()) {
            aEv();
            AppMethodBeat.m2505o(137893);
        } else if (this.hSq == null) {
            C4990ab.m7412e("MicroMsg.HCEActivityMgr", "alvinluo showOpenNFCDialog mHceActivity is null");
            AppMethodBeat.m2505o(137893);
        } else if (this.hSk) {
            C4990ab.m7416i("MicroMsg.HCEActivityMgr", "alvinluo has shown open NFC dialog");
            m42996p(13001, "system NFC switch not opened", this.hSq.getString(C25738R.string.cuo));
            AppMethodBeat.m2505o(137893);
        } else {
            boolean z;
            C5652a c5652a = new C5652a(this.hSq);
            c5652a.asE(this.hSq.getString(C25738R.string.cuq)).asJ(this.hSq.getString(C25738R.string.cum)).mo11457a(new C270452());
            if (this.hSq == null) {
                C4990ab.m7412e("MicroMsg.HCEActivityMgr", "alvinluo isCanJumpNFCSetting mHceActivity is null");
                z = false;
            } else {
                List queryIntentActivities = this.hSq.getPackageManager().queryIntentActivities(new Intent("android.settings.NFC_SETTINGS"), 65536);
                if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                    C4990ab.m7412e("MicroMsg.HCEActivityMgr", "alvinluo Cannot jump to NFC setting");
                    z = false;
                } else {
                    C4990ab.m7416i("MicroMsg.HCEActivityMgr", "alvinluo NFC activity not null, activities size: " + queryIntentActivities.size());
                    for (int i = 0; i < queryIntentActivities.size(); i++) {
                        C4990ab.m7417i("MicroMsg.HCEActivityMgr", "alvinluo NFC activity: %s", ((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name);
                    }
                    z = true;
                }
            }
            if (z) {
                c5652a.asK(this.hSq.getString(C25738R.string.cu_)).mo11476b(new C270463());
            } else {
                c5652a.asJ(this.hSq.getString(C25738R.string.cua));
            }
            c5652a.mo11478f(new C270494());
            this.hSs = c5652a.aMb();
            this.hSs.setCanceledOnTouchOutside(false);
            this.hSs.show();
            this.hSk = true;
            AppMethodBeat.m2505o(137893);
        }
    }

    @TargetApi(19)
    private void aEv() {
        AppMethodBeat.m2504i(137894);
        if (this.hSq == null) {
            C4990ab.m7412e("MicroMsg.HCEActivityMgr", "alvinluo checkDefaultNFCApplication mHceActivity is null");
            AppMethodBeat.m2505o(137894);
            return;
        }
        CardEmulation instance = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(this.hSq));
        C4990ab.m7416i("MicroMsg.HCEActivityMgr", "alvinluo component name: " + this.hSp);
        if (instance.isDefaultServiceForCategory(this.hSp, "payment")) {
            C4990ab.m7416i("MicroMsg.HCEActivityMgr", "alvinluo now is NFC Default Application");
            m42984V(0, "NFC switch has opened and now is NFC default application");
            AppMethodBeat.m2505o(137894);
            return;
        }
        C4990ab.m7417i("MicroMsg.HCEActivityMgr", "alvinluo not NFC Default Application, isAutoSet: %b", Boolean.TRUE);
        m42989b(this.hSp);
        AppMethodBeat.m2505o(137894);
    }

    @TargetApi(19)
    /* renamed from: b */
    private void m42989b(final ComponentName componentName) {
        AppMethodBeat.m2504i(137895);
        if (this.hSq == null) {
            C4990ab.m7412e("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication mHceActivity is null");
            AppMethodBeat.m2505o(137895);
            return;
        }
        C4990ab.m7417i("MicroMsg.HCEActivityMgr", "alvinluo request set default NFC application, hasRequestSetDefault: %b", Boolean.valueOf(this.hSm));
        if (this.hSm) {
            C4990ab.m7416i("MicroMsg.HCEActivityMgr", "alvinluo has request set default NFC application");
            m42996p(13004, "not set default NFC application", this.hSq.getString(C25738R.string.cup));
            AppMethodBeat.m2505o(137895);
            return;
        }
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(137889);
                C27044a.this.hSm = true;
                Intent intent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
                intent.putExtra("category", "payment");
                intent.putExtra("component", componentName);
                C27044a.this.hSq.startActivityForResult(intent, 2);
                AppMethodBeat.m2505o(137889);
            }
        }, 200);
        AppMethodBeat.m2505o(137895);
    }

    /* renamed from: p */
    private void m42996p(final int i, final String str, String str2) {
        AppMethodBeat.m2504i(137896);
        dismissDialog();
        if (this.hSq == null) {
            C4990ab.m7412e("MicroMsg.HCEActivityMgr", "alvinluo showErrorDialog mHceActivity is null");
            AppMethodBeat.m2505o(137896);
            return;
        }
        C5652a c5652a = new C5652a(this.hSq);
        c5652a.asD("");
        c5652a.asE(str2);
        c5652a.asJ(this.hSq.getString(C25738R.string.cua)).mo11457a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(137890);
                C27044a.m42986a(C27044a.this, i, str);
                AppMethodBeat.m2505o(137890);
            }
        });
        c5652a.mo11482rc(true);
        this.hSs = c5652a.aMb();
        this.hSs.setCanceledOnTouchOutside(false);
        this.hSs.show();
        AppMethodBeat.m2505o(137896);
    }

    public final void dismissDialog() {
        AppMethodBeat.m2504i(137897);
        if (this.hSs != null && this.hSs.isShowing()) {
            this.hSs.dismiss();
            this.hSs = null;
        }
        aDw();
        AppMethodBeat.m2505o(137897);
    }

    /* renamed from: U */
    private void m42983U(int i, String str) {
        AppMethodBeat.m2504i(137898);
        Bundle bundle = new Bundle();
        bundle.putInt("errCode", i);
        bundle.putString("errMsg", str);
        this.f13674JF.send(10001, bundle);
        AppMethodBeat.m2505o(137898);
    }

    /* renamed from: V */
    private void m42984V(int i, String str) {
        AppMethodBeat.m2504i(137899);
        Bundle bundle = new Bundle();
        bundle.putInt("errCode", i);
        bundle.putString("errMsg", str);
        this.f13674JF.send(10001, bundle);
        if (this.hSq != null) {
            this.hSq.finish();
        }
        AppMethodBeat.m2505o(137899);
    }

    /* renamed from: c */
    static /* synthetic */ void m42990c(C27044a c27044a) {
        AppMethodBeat.m2504i(137900);
        c27044a.dismissDialog();
        if (c27044a.hSn != null) {
            c27044a.hSn.cancel();
        }
        AppMethodBeat.m2505o(137900);
    }

    /* renamed from: f */
    static /* synthetic */ void m42993f(C27044a c27044a) {
        AppMethodBeat.m2504i(137903);
        if (c27044a.hSq == null) {
            C4990ab.m7412e("MicroMsg.HCEActivityMgr", "alvinluo jumpNFCSetting mHceActivity is null");
            AppMethodBeat.m2505o(137903);
            return;
        }
        c27044a.hSq.startActivityForResult(new Intent("android.settings.NFC_SETTINGS"), 1);
        AppMethodBeat.m2505o(137903);
    }

    /* renamed from: a */
    static /* synthetic */ void m42987a(C27044a c27044a, String str) {
        AppMethodBeat.m2504i(137904);
        c27044a.m42984V(13001, str);
        AppMethodBeat.m2505o(137904);
    }
}
