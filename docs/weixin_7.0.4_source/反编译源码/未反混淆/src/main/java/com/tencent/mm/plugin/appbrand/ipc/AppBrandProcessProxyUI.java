package com.tencent.mm.plugin.appbrand.ipc;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.appbrand.ui.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

@com.tencent.mm.ui.base.a(7)
public class AppBrandProcessProxyUI extends MMActivity implements b {
    public static String huY = "appbrand_report_key_target_url";
    public static String huZ = "appbrand_report_key_target_activity";
    private int huR = 0;
    private AppBrandProxyUIProcessTask huS;
    private ProcessRequest huT;
    private boolean huU = false;
    private volatile boolean huV = false;
    private c huW;
    private a huX;

    class a implements OnClickListener, OnDismissListener {
        private boolean hvk;

        private a() {
            this.hvk = false;
        }

        /* synthetic */ a(AppBrandProcessProxyUI appBrandProcessProxyUI, byte b) {
            this();
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(73129);
            nX(i);
            AppMethodBeat.o(73129);
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(73130);
            nX(-2);
            AppBrandProcessProxyUI.this.a(null);
            AppMethodBeat.o(73130);
        }

        private void nX(int i) {
            AppMethodBeat.i(73131);
            if (this.hvk) {
                AppMethodBeat.o(73131);
                return;
            }
            this.hvk = true;
            ResultReceiver resultReceiver = (ResultReceiver) AppBrandProcessProxyUI.this.getIntent().getParcelableExtra("key_result_receiver");
            if (resultReceiver != null) {
                resultReceiver.send(i, null);
            }
            AppMethodBeat.o(73131);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static boolean B(Intent intent) {
        AppMethodBeat.i(73132);
        if (intent != null) {
            try {
                if (intent.getComponent() != null && intent.getComponent().getShortClassName().equals(".plugin.appbrand.ipc.AppBrandProcessProxyUI") && intent.getIntExtra("key_running_mode", -1) == Downloads.MIN_WAIT_FOR_NETWORK) {
                    AppMethodBeat.o(73132);
                    return true;
                }
            } catch (Exception e) {
                AppMethodBeat.o(73132);
                return false;
            }
        }
        AppMethodBeat.o(73132);
        return false;
    }

    public static void n(Context context, Intent intent) {
        AppMethodBeat.i(73133);
        if (!(context instanceof s) || (context instanceof r)) {
            context.startActivity(intent);
            AppMethodBeat.o(73133);
            return;
        }
        context.startActivity(new Intent(context, AppBrandProcessProxyUI.class).putExtra("key_running_mode", Downloads.MIN_WAIT_FOR_NETWORK).putExtra("key_proxy_launch_target_intent", intent).putExtra("key_proxy_launch_appbrand_ui_class", context.getClass()).addFlags(268435456));
        AppMethodBeat.o(73133);
    }

    static <_Req extends ProcessRequest, _Result extends ProcessResult> void a(Context context, final Class<? extends AppBrandProcessProxyUI> cls, _Req _req, final b<_Result> bVar, Intent intent) {
        Context context2;
        Class cls2;
        Parcelable parcelable;
        AppMethodBeat.i(73134);
        if (context == null) {
            context2 = ah.getContext();
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
        if (bVar == null) {
            parcelable = null;
        } else {
            parcelable = new ResultReceiver(ak.fetchFreeHandler(Looper.getMainLooper())) {
                /* Access modifiers changed, original: protected|final */
                public final void onReceiveResult(int i, Bundle bundle) {
                    AppMethodBeat.i(73124);
                    if (bundle == null) {
                        bVar.c(null);
                        AppMethodBeat.o(73124);
                        return;
                    }
                    bundle.setClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
                    bVar.c((ProcessResult) bundle.getParcelable("key_result_parcel"));
                    AppMethodBeat.o(73124);
                }
            };
        }
        putExtra = putExtra.putExtra(str, parcelable).putExtra(huZ, _req.aBZ()).putExtra("key_running_mode", 1);
        putExtra.putExtra("key_request_parcel", _req);
        if (context2 instanceof Activity) {
            putExtra.putExtra("key_need_light_status", n.b(((Activity) context2).getWindow()));
        } else {
            putExtra.addFlags(268435456);
        }
        if (intent != null) {
            putExtra.addFlags(intent.getFlags());
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(73125);
                if (AppBrandProcessProxyUI.class == cls || !(context2 instanceof Activity)) {
                    context2.startActivity(putExtra);
                    AppMethodBeat.o(73125);
                    return;
                }
                ((Activity) context2).startActivityForResult(putExtra, 0);
                AppMethodBeat.o(73125);
            }
        });
        AppMethodBeat.o(73134);
    }

    static void a(Context context, Class<? extends AppBrandProcessProxyUI> cls, String str, String str2, String str3, String str4, final OnClickListener onClickListener, final OnClickListener onClickListener2, final OnClickListener onClickListener3) {
        AppMethodBeat.i(73135);
        if (context == null) {
            context = ah.getContext();
        }
        Intent putExtra = new Intent(context, cls).putExtra("key_running_mode", 2).putExtra("key_result_receiver", new ResultReceiver(ak.fetchFreeHandler(Looper.getMainLooper())) {
            /* Access modifiers changed, original: protected|final */
            public final void onReceiveResult(int i, Bundle bundle) {
                AppMethodBeat.i(73126);
                if (-1 == i && onClickListener != null) {
                    onClickListener.onClick(null, i);
                }
                if (-2 == i && onClickListener2 != null) {
                    onClickListener2.onClick(null, i);
                }
                if (-3 == i && onClickListener3 != null) {
                    onClickListener3.onClick(null, i);
                }
                AppMethodBeat.o(73126);
            }
        }).putExtra("key_alert_message", str).putExtra("key_alert_title", str2).putExtra("key_alert_confirm", str3).putExtra("key_alert_deny", str4);
        if (!(context instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        context.startActivity(putExtra);
        AppMethodBeat.o(73135);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(73136);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(1);
        AppMethodBeat.o(73136);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.i(73137);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        n.a(getWindow());
        n.a(getWindow(), getIntent().getBooleanExtra("key_need_light_status", false));
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(73137);
            return;
        }
        String stringExtra;
        switch (getIntent().getIntExtra("key_running_mode", 0)) {
            case 1:
                getIntent().setExtrasClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
                stringExtra = getIntent().getStringExtra("key_model_class_name");
                ab.i("MicroMsg.AppBrandProcessProxyUI", "onCreate, modelClass = %s", stringExtra);
                if (!bo.isNullOrNil(stringExtra)) {
                    this.huS = a.AG(stringExtra);
                    if (this.huS == null) {
                        ab.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown model class = %s", stringExtra);
                    } else if (getIntent().getBooleanExtra("key_request_need_params", true)) {
                        this.huT = (ProcessRequest) getIntent().getParcelableExtra("key_request_parcel");
                        if (this.huT == null) {
                            ab.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown request class = %s", stringExtra);
                        } else {
                            this.huS.hvt = this;
                            this.huS.a(this.huT);
                            i = 1;
                        }
                    } else {
                        this.huT = null;
                    }
                }
                if (i == 0) {
                    finish();
                    AppMethodBeat.o(73137);
                    return;
                }
                break;
            case 2:
                String bZ = bZ(getIntent().getStringExtra("key_alert_title"), "");
                stringExtra = bZ(getIntent().getStringExtra("key_alert_message"), getString(R.string.tz));
                String bZ2 = bZ(getIntent().getStringExtra("key_alert_confirm"), "");
                final String bZ3 = bZ(getIntent().getStringExtra("key_alert_deny"), "");
                this.huX = new a(this, (byte) 0);
                this.huW = h.a((Context) this, stringExtra, bZ, bZ2, bZ3, false, this.huX, this.huX);
                this.huW.setOnDismissListener(this.huX);
                this.huW.setOnKeyListener(new OnKeyListener() {
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        AppMethodBeat.i(73127);
                        if (i == 4 && keyEvent.getAction() == 1) {
                            if (!bo.isNullOrNil(bZ3)) {
                                AppBrandProcessProxyUI.this.huX.onClick(AppBrandProcessProxyUI.this.huW, -3);
                                dialogInterface.dismiss();
                            }
                            AppBrandProcessProxyUI.this.a(null);
                        }
                        AppMethodBeat.o(73127);
                        return false;
                    }
                });
                AppMethodBeat.o(73137);
                return;
            case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                Intent intent = (Intent) getIntent().getParcelableExtra("key_proxy_launch_target_intent");
                if (intent != null) {
                    if (intent.getComponent() != null) {
                        try {
                            Class.forName(intent.getComponent().getClassName());
                        } catch (Exception e) {
                            ab.e("MicroMsg.AppBrandProcessProxyUI", "proxyLaunch, Class.forName %s, e = %s", intent.getComponent().getClassName(), e);
                        }
                    }
                    try {
                        startActivity(intent);
                        AppMethodBeat.o(73137);
                        return;
                    } catch (Exception e2) {
                        try {
                            ab.e("MicroMsg.AppBrandProcessProxyUI", "start targetActivity, %s, e = %s", intent, e2);
                            AppMethodBeat.o(73137);
                            return;
                        } catch (Exception e3) {
                            AppMethodBeat.o(73137);
                            return;
                        }
                    }
                }
                finish();
                AppMethodBeat.o(73137);
                return;
            default:
                finish();
                break;
        }
        AppMethodBeat.o(73137);
    }

    private static String bZ(String str, String str2) {
        AppMethodBeat.i(73138);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(73138);
            return str2;
        }
        AppMethodBeat.o(73138);
        return str;
    }

    public void onResume() {
        AppMethodBeat.i(73139);
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
                        AppMethodBeat.o(73139);
                        return;
                    }
                    startActivity(new Intent(this, cls).putExtra("key_appbrand_bring_ui_to_front", true).addFlags(268435456));
                    finish();
                    AppMethodBeat.o(73139);
                    return;
                } catch (Exception e) {
                    finish();
                }
            }
            AppMethodBeat.o(73139);
        } else if (intExtra == 2) {
            ab.d("MicroMsg.AppBrandProcessProxyUI", "onResume, RUNNING_MODE_SHOW_ALERT");
            AppMethodBeat.o(73139);
        } else {
            ab.d("MicroMsg.AppBrandProcessProxyUI", "onResume, mFinishOnNextResume = %b, finishing = %b, request = %s", Boolean.valueOf(this.huU), Boolean.valueOf(aBR()), this.huT.getClass().getName());
            if (this.huU && this.huT.aBY() && !r0) {
                a(null);
            }
            this.huU = true;
            AppMethodBeat.o(73139);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(73140);
        super.onDestroy();
        if (this.huW != null && this.huW.isShowing()) {
            this.huW.dismiss();
            this.huW = null;
            this.huX = null;
        }
        AppMethodBeat.o(73140);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(73141);
        super.onActivityResult(i, i2, intent);
        ab.d("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, requestCode = %d, resultCode = %d, request = %s", Integer.valueOf(i), Integer.valueOf(i2), this.huT.getClass().getName());
        this.huU = false;
        AppMethodBeat.o(73141);
    }

    public void finish() {
        AppMethodBeat.i(73142);
        super.finish();
        overridePendingTransition(0, 0);
        if (this.huS != null) {
            this.huS.aBX();
        }
        AppMethodBeat.o(73142);
    }

    public final MMActivity aBQ() {
        return this;
    }

    public final void a(final ProcessResult processResult) {
        AppMethodBeat.i(73143);
        this.huV = true;
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(73128);
                AppBrandProcessProxyUI.this.finish();
                AppBrandProcessProxyUI.this.b(processResult);
                AppMethodBeat.o(73128);
            }
        });
        AppMethodBeat.o(73143);
    }

    public void initActivityCloseAnimation() {
    }

    public final void b(ProcessResult processResult) {
        AppMethodBeat.i(73145);
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("key_result_receiver");
        if (!(resultReceiver == null || processResult == null)) {
            Bundle bundle = new Bundle(2);
            bundle.putParcelable("key_result_parcel", processResult);
            resultReceiver.send(0, bundle);
        }
        AppMethodBeat.o(73145);
    }

    public final boolean aBR() {
        AppMethodBeat.i(73144);
        if (this.uiu || isFinishing() || this.huV) {
            AppMethodBeat.o(73144);
            return true;
        }
        AppMethodBeat.o(73144);
        return false;
    }
}
