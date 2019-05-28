package com.tencent.p177mm.plugin.webview.stub;

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
import android.support.p057v4.app.C6184a;
import android.support.p057v4.app.C6184a.C0315a;
import android.support.p057v4.content.C0380b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C33279c;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C29916g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C23018g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29944h;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.view.C31128d;
import java.util.ArrayList;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubTempUI */
public class WebViewStubTempUI extends MMActivity implements C0315a, C5186a {
    private int uqI = 0;
    private boolean uqJ = false;
    private Dialog uqK = null;

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubTempUI$4 */
    class C356224 implements OnCancelListener {
        C356224() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(7221);
            WebViewStubTempUI.this.finish();
            AppMethodBeat.m2505o(7221);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubTempUI$StartActivityForResultTask */
    static final class StartActivityForResultTask implements Parcelable {
        public static final Creator<StartActivityForResultTask> CREATOR = new C402791();
        String qiZ;
        int requestCode;
        int unN;
        String uqP;
        Intent uqQ;
        boolean uqR;

        /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubTempUI$StartActivityForResultTask$1 */
        static class C402791 implements Creator<StartActivityForResultTask> {
            C402791() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartActivityForResultTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(7222);
                StartActivityForResultTask startActivityForResultTask = new StartActivityForResultTask(parcel);
                AppMethodBeat.m2505o(7222);
                return startActivityForResultTask;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(7223);
            parcel.writeString(this.qiZ);
            parcel.writeString(this.uqP);
            parcel.writeParcelable(this.uqQ, i);
            parcel.writeInt(this.requestCode);
            parcel.writeByte(this.uqR ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.unN);
            AppMethodBeat.m2505o(7223);
        }

        StartActivityForResultTask() {
        }

        StartActivityForResultTask(Parcel parcel) {
            AppMethodBeat.m2504i(7224);
            this.qiZ = parcel.readString();
            this.uqP = parcel.readString();
            this.uqQ = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
            this.requestCode = parcel.readInt();
            this.uqR = parcel.readByte() != (byte) 0;
            this.unN = parcel.readInt();
            AppMethodBeat.m2505o(7224);
        }

        static {
            AppMethodBeat.m2504i(7225);
            AppMethodBeat.m2505o(7225);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    public static void m69060a(Context context, String str, String str2, Intent intent, int i) {
        AppMethodBeat.m2504i(7226);
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
        AppMethodBeat.m2505o(7226);
    }

    /* renamed from: b */
    private static Intent m69062b(Context context, String str, String str2, String str3, String str4, final OnClickListener onClickListener, final OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(7227);
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
        intent.putExtra("key_alert_result_receiver", new ResultReceiver(C7306ak.fetchFreeHandler()) {
            /* Access modifiers changed, original: protected|final */
            public final void onReceiveResult(int i, Bundle bundle) {
                AppMethodBeat.m2504i(7218);
                switch (i) {
                    case 0:
                        onClickListener.onClick(null, 0);
                        AppMethodBeat.m2505o(7218);
                        return;
                    case 1:
                        onClickListener2.onClick(null, 0);
                        break;
                }
                AppMethodBeat.m2505o(7218);
            }
        });
        AppMethodBeat.m2505o(7227);
        return intent;
    }

    /* renamed from: c */
    public static void m69063c(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(7228);
        context.startActivity(WebViewStubTempUI.m69062b(context, str, str2, str3, str4, onClickListener, onClickListener2));
        AppMethodBeat.m2505o(7228);
    }

    /* renamed from: a */
    public static void m69059a(Context context, C40281e c40281e, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(7229);
        C29916g.m47393a(WebViewStubTempUI.m69062b(context, str, str2, str3, str4, onClickListener, onClickListener2).getExtras(), "webview", ".stub.WebViewStubTempUI", c40281e, null);
        AppMethodBeat.m2505o(7229);
    }

    /* renamed from: a */
    public static boolean m69061a(Context context, C40281e c40281e, String[] strArr, int i, int i2) {
        AppMethodBeat.m2504i(7230);
        if (context == null) {
            AppMethodBeat.m2505o(7230);
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 <= 0; i3++) {
            String str = strArr[0];
            if (C0380b.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.m2505o(7230);
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_action_code", 1);
        bundle.putStringArray("key_permission_types", (String[]) arrayList.toArray(new String[arrayList.size()]));
        bundle.putInt("key_permission_request_code", i);
        bundle.putInt("key_binder_id", i2);
        C29916g.m47393a(bundle, "webview", ".stub.WebViewStubTempUI", c40281e, null);
        AppMethodBeat.m2505o(7230);
        return false;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(7231);
        super.onCreate(bundle);
        switch (getIntent().getIntExtra("key_action_code", -1)) {
            case 0:
                final ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("key_alert_result_receiver");
                if (resultReceiver == null) {
                    finish();
                    AppMethodBeat.m2505o(7231);
                    return;
                }
                this.uqK = C30379h.m48453a((Context) this, getIntent().getBooleanExtra("key_alert_cancelable", false), getIntent().getStringExtra("key_alert_message"), getIntent().getStringExtra("key_alert_title"), getIntent().getStringExtra("key_alert_yes"), getIntent().getStringExtra("key_alert_no"), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(7219);
                        resultReceiver.send(0, null);
                        WebViewStubTempUI.this.finish();
                        AppMethodBeat.m2505o(7219);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(7220);
                        resultReceiver.send(1, null);
                        WebViewStubTempUI.this.finish();
                        AppMethodBeat.m2505o(7220);
                    }
                });
                this.uqK.setOnCancelListener(new C356224());
                AppMethodBeat.m2505o(7231);
                return;
            case 1:
                C6184a.m9880a(this, getIntent().getStringArrayExtra("key_permission_types"), getIntent().getIntExtra("key_permission_request_code", 0));
                AppMethodBeat.m2505o(7231);
                return;
            case 2:
                StartActivityForResultTask startActivityForResultTask = (StartActivityForResultTask) getIntent().getParcelableExtra("key_activity_result_task");
                this.uqI = startActivityForResultTask.unN;
                this.uqJ = true;
                this.ifE = this;
                C25985d.m41453a((Context) this, startActivityForResultTask.qiZ, startActivityForResultTask.uqP, startActivityForResultTask.uqQ, startActivityForResultTask.requestCode, startActivityForResultTask.uqR);
                AppMethodBeat.m2505o(7231);
                return;
            default:
                finish();
                AppMethodBeat.m2505o(7231);
                return;
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(7232);
        super.onDestroy();
        if (this.uqK != null) {
            this.uqK.dismiss();
        }
        AppMethodBeat.m2505o(7232);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(7233);
        int intExtra = getIntent().getIntExtra("key_binder_id", 0);
        switch (i) {
            case C33279c.CTRL_INDEX /*72*/:
            case 113:
            case 115:
            case 116:
            case C31128d.MIC_ALPHA_ADJUST_REAL /*117*/:
            case 118:
                if (iArr[0] != 0) {
                    C29944h.m47401JR(intExtra).mo6069c(i, 0, null);
                    break;
                } else {
                    C29944h.m47401JR(intExtra).mo6069c(i, -1, null);
                    break;
                }
        }
        finish();
        AppMethodBeat.m2505o(7233);
    }

    /* renamed from: c */
    public final void mo6069c(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(7234);
        if (this.uqJ) {
            C23018g JR = C29944h.m47401JR(this.uqI);
            if (JR != null) {
                JR.mo6069c(i, i2, intent);
            }
        }
        finish();
        AppMethodBeat.m2505o(7234);
    }

    public final int getLayoutId() {
        return -1;
    }
}
