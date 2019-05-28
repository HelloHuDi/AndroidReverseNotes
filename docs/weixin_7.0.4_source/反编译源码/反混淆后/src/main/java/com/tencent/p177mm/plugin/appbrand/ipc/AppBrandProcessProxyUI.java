package com.tencent.p177mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.C19247b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.C19248a;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.p177mm.plugin.appbrand.p336ui.C19808s;
import com.tencent.p177mm.plugin.appbrand.p336ui.C27334r;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI */
public class AppBrandProcessProxyUI extends MMActivity implements C10273b {
    public static String huY = "appbrand_report_key_target_url";
    public static String huZ = "appbrand_report_key_target_activity";
    private int huR = 0;
    private AppBrandProxyUIProcessTask huS;
    private ProcessRequest huT;
    private boolean huU = false;
    private volatile boolean huV = false;
    private C5653c huW;
    private C10271a huX;

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI$a */
    class C10271a implements OnClickListener, OnDismissListener {
        private boolean hvk;

        private C10271a() {
            this.hvk = false;
        }

        /* synthetic */ C10271a(AppBrandProcessProxyUI appBrandProcessProxyUI, byte b) {
            this();
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(73129);
            m17923nX(i);
            AppMethodBeat.m2505o(73129);
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(73130);
            m17923nX(-2);
            AppBrandProcessProxyUI.this.mo21712a(null);
            AppMethodBeat.m2505o(73130);
        }

        /* renamed from: nX */
        private void m17923nX(int i) {
            AppMethodBeat.m2504i(73131);
            if (this.hvk) {
                AppMethodBeat.m2505o(73131);
                return;
            }
            this.hvk = true;
            ResultReceiver resultReceiver = (ResultReceiver) AppBrandProcessProxyUI.this.getIntent().getParcelableExtra("key_result_receiver");
            if (resultReceiver != null) {
                resultReceiver.send(i, null);
            }
            AppMethodBeat.m2505o(73131);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: B */
    public static boolean m64712B(Intent intent) {
        AppMethodBeat.m2504i(73132);
        if (intent != null) {
            try {
                if (intent.getComponent() != null && intent.getComponent().getShortClassName().equals(".plugin.appbrand.ipc.AppBrandProcessProxyUI") && intent.getIntExtra("key_running_mode", -1) == Downloads.MIN_WAIT_FOR_NETWORK) {
                    AppMethodBeat.m2505o(73132);
                    return true;
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(73132);
                return false;
            }
        }
        AppMethodBeat.m2505o(73132);
        return false;
    }

    /* renamed from: n */
    public static void m64718n(Context context, Intent intent) {
        AppMethodBeat.m2504i(73133);
        if (!(context instanceof C19808s) || (context instanceof C27334r)) {
            context.startActivity(intent);
            AppMethodBeat.m2505o(73133);
            return;
        }
        context.startActivity(new Intent(context, AppBrandProcessProxyUI.class).putExtra("key_running_mode", Downloads.MIN_WAIT_FOR_NETWORK).putExtra("key_proxy_launch_target_intent", intent).putExtra("key_proxy_launch_appbrand_ui_class", context.getClass()).addFlags(268435456));
        AppMethodBeat.m2505o(73133);
    }

    /* renamed from: a */
    static <_Req extends ProcessRequest, _Result extends ProcessResult> void m64714a(Context context, final Class<? extends AppBrandProcessProxyUI> cls, _Req _req, final C19247b<_Result> c19247b, Intent intent) {
        Context context2;
        Class cls2;
        Parcelable parcelable;
        AppMethodBeat.m2504i(73134);
        if (context == null) {
            context2 = C4996ah.getContext();
        } else {
            context2 = context;
        }
        String name = _req.aCa().getName();
        if (cls == null) {
            cls2 = AppBrandProcessProxyUI.class;
        } else {
            Class<? extends AppBrandProcessProxyUI> cls22 = cls;
        }
        Intent putExtra = new Intent(context2, cls22).putExtra("key_model_class_name", name);
        String str = "key_result_receiver";
        if (c19247b == null) {
            parcelable = null;
        } else {
            parcelable = new ResultReceiver(C7306ak.fetchFreeHandler(Looper.getMainLooper())) {
                /* Access modifiers changed, original: protected|final */
                public final void onReceiveResult(int i, Bundle bundle) {
                    AppMethodBeat.m2504i(73124);
                    if (bundle == null) {
                        c19247b.mo6053c(null);
                        AppMethodBeat.m2505o(73124);
                        return;
                    }
                    bundle.setClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
                    c19247b.mo6053c((ProcessResult) bundle.getParcelable("key_result_parcel"));
                    AppMethodBeat.m2505o(73124);
                }
            };
        }
        putExtra = putExtra.putExtra(str, parcelable).putExtra(huZ, _req.aBZ()).putExtra("key_running_mode", 1);
        putExtra.putExtra("key_request_parcel", _req);
        if (context2 instanceof Activity) {
            putExtra.putExtra("key_need_light_status", C42696n.m75618b(((Activity) context2).getWindow()));
        } else {
            putExtra.addFlags(268435456);
        }
        if (intent != null) {
            putExtra.addFlags(intent.getFlags());
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(73125);
                if (AppBrandProcessProxyUI.class == cls || !(context2 instanceof Activity)) {
                    context2.startActivity(putExtra);
                    AppMethodBeat.m2505o(73125);
                    return;
                }
                ((Activity) context2).startActivityForResult(putExtra, 0);
                AppMethodBeat.m2505o(73125);
            }
        });
        AppMethodBeat.m2505o(73134);
    }

    /* renamed from: a */
    static void m64715a(Context context, Class<? extends AppBrandProcessProxyUI> cls, String str, String str2, String str3, String str4, final OnClickListener onClickListener, final OnClickListener onClickListener2, final OnClickListener onClickListener3) {
        AppMethodBeat.m2504i(73135);
        if (context == null) {
            context = C4996ah.getContext();
        }
        Intent putExtra = new Intent(context, cls).putExtra("key_running_mode", 2).putExtra("key_result_receiver", new ResultReceiver(C7306ak.fetchFreeHandler(Looper.getMainLooper())) {
            /* Access modifiers changed, original: protected|final */
            public final void onReceiveResult(int i, Bundle bundle) {
                AppMethodBeat.m2504i(73126);
                if (-1 == i && onClickListener != null) {
                    onClickListener.onClick(null, i);
                }
                if (-2 == i && onClickListener2 != null) {
                    onClickListener2.onClick(null, i);
                }
                if (-3 == i && onClickListener3 != null) {
                    onClickListener3.onClick(null, i);
                }
                AppMethodBeat.m2505o(73126);
            }
        }).putExtra("key_alert_message", str).putExtra("key_alert_title", str2).putExtra("key_alert_confirm", str3).putExtra("key_alert_deny", str4);
        if (!(context instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        context.startActivity(putExtra);
        AppMethodBeat.m2505o(73135);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.m2504i(73136);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(1);
        AppMethodBeat.m2505o(73136);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.m2504i(73137);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        C42696n.m75615a(getWindow());
        C42696n.m75616a(getWindow(), getIntent().getBooleanExtra("key_need_light_status", false));
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getIntent() == null) {
            finish();
            AppMethodBeat.m2505o(73137);
            return;
        }
        String stringExtra;
        switch (getIntent().getIntExtra("key_running_mode", 0)) {
            case 1:
                getIntent().setExtrasClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
                stringExtra = getIntent().getStringExtra("key_model_class_name");
                C4990ab.m7417i("MicroMsg.AppBrandProcessProxyUI", "onCreate, modelClass = %s", stringExtra);
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    this.huS = C19248a.m29899AG(stringExtra);
                    if (this.huS == null) {
                        C4990ab.m7413e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown model class = %s", stringExtra);
                    } else if (getIntent().getBooleanExtra("key_request_need_params", true)) {
                        this.huT = (ProcessRequest) getIntent().getParcelableExtra("key_request_parcel");
                        if (this.huT == null) {
                            C4990ab.m7413e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown request class = %s", stringExtra);
                        } else {
                            this.huS.hvt = this;
                            this.huS.mo6047a(this.huT);
                            i = 1;
                        }
                    } else {
                        this.huT = null;
                    }
                }
                if (i == 0) {
                    finish();
                    AppMethodBeat.m2505o(73137);
                    return;
                }
                break;
            case 2:
                String bZ = AppBrandProcessProxyUI.m64717bZ(getIntent().getStringExtra("key_alert_title"), "");
                stringExtra = AppBrandProcessProxyUI.m64717bZ(getIntent().getStringExtra("key_alert_message"), getString(C25738R.string.f9238tz));
                String bZ2 = AppBrandProcessProxyUI.m64717bZ(getIntent().getStringExtra("key_alert_confirm"), "");
                final String bZ3 = AppBrandProcessProxyUI.m64717bZ(getIntent().getStringExtra("key_alert_deny"), "");
                this.huX = new C10271a(this, (byte) 0);
                this.huW = C30379h.m48445a((Context) this, stringExtra, bZ, bZ2, bZ3, false, this.huX, this.huX);
                this.huW.setOnDismissListener(this.huX);
                this.huW.setOnKeyListener(new OnKeyListener() {
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        AppMethodBeat.m2504i(73127);
                        if (i == 4 && keyEvent.getAction() == 1) {
                            if (!C5046bo.isNullOrNil(bZ3)) {
                                AppBrandProcessProxyUI.this.huX.onClick(AppBrandProcessProxyUI.this.huW, -3);
                                dialogInterface.dismiss();
                            }
                            AppBrandProcessProxyUI.this.mo21712a(null);
                        }
                        AppMethodBeat.m2505o(73127);
                        return false;
                    }
                });
                AppMethodBeat.m2505o(73137);
                return;
            case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                Intent intent = (Intent) getIntent().getParcelableExtra("key_proxy_launch_target_intent");
                if (intent != null) {
                    if (intent.getComponent() != null) {
                        try {
                            Class.forName(intent.getComponent().getClassName());
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.AppBrandProcessProxyUI", "proxyLaunch, Class.forName %s, e = %s", intent.getComponent().getClassName(), e);
                        }
                    }
                    try {
                        startActivity(intent);
                        AppMethodBeat.m2505o(73137);
                        return;
                    } catch (Exception e2) {
                        try {
                            C4990ab.m7413e("MicroMsg.AppBrandProcessProxyUI", "start targetActivity, %s, e = %s", intent, e2);
                            AppMethodBeat.m2505o(73137);
                            return;
                        } catch (Exception e3) {
                            AppMethodBeat.m2505o(73137);
                            return;
                        }
                    }
                }
                finish();
                AppMethodBeat.m2505o(73137);
                return;
            default:
                finish();
                break;
        }
        AppMethodBeat.m2505o(73137);
    }

    /* renamed from: bZ */
    private static String m64717bZ(String str, String str2) {
        AppMethodBeat.m2504i(73138);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(73138);
            return str2;
        }
        AppMethodBeat.m2505o(73138);
        return str;
    }

    public void onResume() {
        AppMethodBeat.m2504i(73139);
        super.onResume();
        int intExtra = getIntent().getIntExtra("key_running_mode", 0);
        if (intExtra == Downloads.MIN_WAIT_FOR_NETWORK) {
            intExtra = this.huR + 1;
            this.huR = intExtra;
            if (intExtra > 1) {
                try {
                    Class cls = (Class) getIntent().getSerializableExtra("key_proxy_launch_appbrand_ui_class");
                    if (cls == null) {
                        finish();
                        AppMethodBeat.m2505o(73139);
                        return;
                    }
                    startActivity(new Intent(this, cls).putExtra("key_appbrand_bring_ui_to_front", true).addFlags(268435456));
                    finish();
                    AppMethodBeat.m2505o(73139);
                    return;
                } catch (Exception e) {
                    finish();
                }
            }
            AppMethodBeat.m2505o(73139);
        } else if (intExtra == 2) {
            C4990ab.m7410d("MicroMsg.AppBrandProcessProxyUI", "onResume, RUNNING_MODE_SHOW_ALERT");
            AppMethodBeat.m2505o(73139);
        } else {
            C4990ab.m7411d("MicroMsg.AppBrandProcessProxyUI", "onResume, mFinishOnNextResume = %b, finishing = %b, request = %s", Boolean.valueOf(this.huU), Boolean.valueOf(aBR()), this.huT.getClass().getName());
            if (this.huU && this.huT.aBY() && !r0) {
                mo21712a(null);
            }
            this.huU = true;
            AppMethodBeat.m2505o(73139);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(73140);
        super.onDestroy();
        if (this.huW != null && this.huW.isShowing()) {
            this.huW.dismiss();
            this.huW = null;
            this.huX = null;
        }
        AppMethodBeat.m2505o(73140);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(73141);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7411d("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, requestCode = %d, resultCode = %d, request = %s", Integer.valueOf(i), Integer.valueOf(i2), this.huT.getClass().getName());
        this.huU = false;
        AppMethodBeat.m2505o(73141);
    }

    public void finish() {
        AppMethodBeat.m2504i(73142);
        super.finish();
        overridePendingTransition(0, 0);
        if (this.huS != null) {
            this.huS.aBX();
        }
        AppMethodBeat.m2505o(73142);
    }

    public final MMActivity aBQ() {
        return this;
    }

    /* renamed from: a */
    public final void mo21712a(final ProcessResult processResult) {
        AppMethodBeat.m2504i(73143);
        this.huV = true;
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(73128);
                AppBrandProcessProxyUI.this.finish();
                AppBrandProcessProxyUI.this.mo21715b(processResult);
                AppMethodBeat.m2505o(73128);
            }
        });
        AppMethodBeat.m2505o(73143);
    }

    public void initActivityCloseAnimation() {
    }

    /* renamed from: b */
    public final void mo21715b(ProcessResult processResult) {
        AppMethodBeat.m2504i(73145);
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("key_result_receiver");
        if (!(resultReceiver == null || processResult == null)) {
            Bundle bundle = new Bundle(2);
            bundle.putParcelable("key_result_parcel", processResult);
            resultReceiver.send(0, bundle);
        }
        AppMethodBeat.m2505o(73145);
    }

    public final boolean aBR() {
        AppMethodBeat.m2504i(73144);
        if (this.uiu || isFinishing() || this.huV) {
            AppMethodBeat.m2505o(73144);
            return true;
        }
        AppMethodBeat.m2505o(73144);
        return false;
    }
}
