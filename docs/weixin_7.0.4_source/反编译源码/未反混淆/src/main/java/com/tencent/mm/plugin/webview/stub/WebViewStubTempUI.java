package com.tencent.mm.plugin.webview.stub;

import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.webview.ui.tools.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

@a(7)
public class WebViewStubTempUI extends MMActivity implements android.support.v4.app.a.a, MMActivity.a {
    private int uqI = 0;
    private boolean uqJ = false;
    private Dialog uqK = null;

    static final class StartActivityForResultTask implements Parcelable {
        public static final Creator<StartActivityForResultTask> CREATOR = new Creator<StartActivityForResultTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartActivityForResultTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(7222);
                StartActivityForResultTask startActivityForResultTask = new StartActivityForResultTask(parcel);
                AppMethodBeat.o(7222);
                return startActivityForResultTask;
            }
        };
        String qiZ;
        int requestCode;
        int unN;
        String uqP;
        Intent uqQ;
        boolean uqR;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(7223);
            parcel.writeString(this.qiZ);
            parcel.writeString(this.uqP);
            parcel.writeParcelable(this.uqQ, i);
            parcel.writeInt(this.requestCode);
            parcel.writeByte(this.uqR ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.unN);
            AppMethodBeat.o(7223);
        }

        StartActivityForResultTask() {
        }

        StartActivityForResultTask(Parcel parcel) {
            AppMethodBeat.i(7224);
            this.qiZ = parcel.readString();
            this.uqP = parcel.readString();
            this.uqQ = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
            this.requestCode = parcel.readInt();
            this.uqR = parcel.readByte() != (byte) 0;
            this.unN = parcel.readInt();
            AppMethodBeat.o(7224);
        }

        static {
            AppMethodBeat.i(7225);
            AppMethodBeat.o(7225);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static void a(Context context, String str, String str2, Intent intent, int i) {
        AppMethodBeat.i(7226);
        Intent intent2 = new Intent(context, WebViewStubTempUI.class);
        if (context instanceof Service) {
            intent2.addFlags(268435456);
        }
        intent2.putExtra("key_action_code", 2);
        StartActivityForResultTask startActivityForResultTask = new StartActivityForResultTask();
        startActivityForResultTask.qiZ = str;
        startActivityForResultTask.uqP = str2;
        startActivityForResultTask.uqQ = intent;
        startActivityForResultTask.requestCode = 15;
        startActivityForResultTask.uqR = false;
        startActivityForResultTask.unN = i;
        intent2.putExtra("key_activity_result_task", startActivityForResultTask);
        context.startActivity(intent2);
        AppMethodBeat.o(7226);
    }

    private static Intent b(Context context, String str, String str2, String str3, String str4, final OnClickListener onClickListener, final OnClickListener onClickListener2) {
        AppMethodBeat.i(7227);
        Intent intent = new Intent(context, WebViewStubTempUI.class);
        if (context instanceof Service) {
            intent.addFlags(268435456);
        }
        intent.putExtra("key_action_code", 0);
        intent.putExtra("key_alert_cancelable", false);
        intent.putExtra("key_alert_message", str);
        intent.putExtra("key_alert_title", str2);
        intent.putExtra("key_alert_yes", str3);
        intent.putExtra("key_alert_no", str4);
        intent.putExtra("key_alert_result_receiver", new ResultReceiver(ak.fetchFreeHandler()) {
            /* Access modifiers changed, original: protected|final */
            public final void onReceiveResult(int i, Bundle bundle) {
                AppMethodBeat.i(7218);
                switch (i) {
                    case 0:
                        onClickListener.onClick(null, 0);
                        AppMethodBeat.o(7218);
                        return;
                    case 1:
                        onClickListener2.onClick(null, 0);
                        break;
                }
                AppMethodBeat.o(7218);
            }
        });
        AppMethodBeat.o(7227);
        return intent;
    }

    public static void c(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(7228);
        context.startActivity(b(context, str, str2, str3, str4, onClickListener, onClickListener2));
        AppMethodBeat.o(7228);
    }

    public static void a(Context context, e eVar, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(7229);
        g.a(b(context, str, str2, str3, str4, onClickListener, onClickListener2).getExtras(), "webview", ".stub.WebViewStubTempUI", eVar, null);
        AppMethodBeat.o(7229);
    }

    public static boolean a(Context context, e eVar, String[] strArr, int i, int i2) {
        AppMethodBeat.i(7230);
        if (context == null) {
            AppMethodBeat.o(7230);
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 <= 0; i3++) {
            String str = strArr[0];
            if (b.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.o(7230);
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_action_code", 1);
        bundle.putStringArray("key_permission_types", (String[]) arrayList.toArray(new String[arrayList.size()]));
        bundle.putInt("key_permission_request_code", i);
        bundle.putInt("key_binder_id", i2);
        g.a(bundle, "webview", ".stub.WebViewStubTempUI", eVar, null);
        AppMethodBeat.o(7230);
        return false;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7231);
        super.onCreate(bundle);
        switch (getIntent().getIntExtra("key_action_code", -1)) {
            case 0:
                final ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("key_alert_result_receiver");
                if (resultReceiver == null) {
                    finish();
                    AppMethodBeat.o(7231);
                    return;
                }
                this.uqK = h.a((Context) this, getIntent().getBooleanExtra("key_alert_cancelable", false), getIntent().getStringExtra("key_alert_message"), getIntent().getStringExtra("key_alert_title"), getIntent().getStringExtra("key_alert_yes"), getIntent().getStringExtra("key_alert_no"), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(7219);
                        resultReceiver.send(0, null);
                        WebViewStubTempUI.this.finish();
                        AppMethodBeat.o(7219);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(7220);
                        resultReceiver.send(1, null);
                        WebViewStubTempUI.this.finish();
                        AppMethodBeat.o(7220);
                    }
                });
                this.uqK.setOnCancelListener(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(7221);
                        WebViewStubTempUI.this.finish();
                        AppMethodBeat.o(7221);
                    }
                });
                AppMethodBeat.o(7231);
                return;
            case 1:
                android.support.v4.app.a.a(this, getIntent().getStringArrayExtra("key_permission_types"), getIntent().getIntExtra("key_permission_request_code", 0));
                AppMethodBeat.o(7231);
                return;
            case 2:
                StartActivityForResultTask startActivityForResultTask = (StartActivityForResultTask) getIntent().getParcelableExtra("key_activity_result_task");
                this.uqI = startActivityForResultTask.unN;
                this.uqJ = true;
                this.ifE = this;
                d.a((Context) this, startActivityForResultTask.qiZ, startActivityForResultTask.uqP, startActivityForResultTask.uqQ, startActivityForResultTask.requestCode, startActivityForResultTask.uqR);
                AppMethodBeat.o(7231);
                return;
            default:
                finish();
                AppMethodBeat.o(7231);
                return;
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(7232);
        super.onDestroy();
        if (this.uqK != null) {
            this.uqK.dismiss();
        }
        AppMethodBeat.o(7232);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(7233);
        int intExtra = getIntent().getIntExtra("key_binder_id", 0);
        switch (i) {
            case c.CTRL_INDEX /*72*/:
            case 113:
            case 115:
            case 116:
            case com.tencent.view.d.MIC_ALPHA_ADJUST_REAL /*117*/:
            case 118:
                if (iArr[0] != 0) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.JR(intExtra).c(i, 0, null);
                    break;
                } else {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.JR(intExtra).c(i, -1, null);
                    break;
                }
        }
        finish();
        AppMethodBeat.o(7233);
    }

    public final void c(int i, int i2, Intent intent) {
        AppMethodBeat.i(7234);
        if (this.uqJ) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.JR(this.uqI);
            if (JR != null) {
                JR.c(i, i2, intent);
            }
        }
        finish();
        AppMethodBeat.o(7234);
    }

    public final int getLayoutId() {
        return -1;
    }
}
