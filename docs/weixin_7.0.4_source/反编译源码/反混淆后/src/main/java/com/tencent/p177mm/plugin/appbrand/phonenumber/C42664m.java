package com.tencent.p177mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p230g.p232b.p233a.C26275be;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.appbrand.phonenumber.C27268g.C27269a;
import com.tencent.p177mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.p177mm.protocal.protobuf.C44165se;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.protocal.protobuf.bwy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.HashMap;
import java.util.Map;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u0000 =2\u00020\u0001:\u0003=>?B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0012\u0010*\u001a\u00020(2\b\b\u0002\u0010+\u001a\u00020,H\u0002J\u001c\u0010-\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020\u0005H\u0002J$\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u00104\u001a\u00020(2\u0006\u00103\u001a\u00020\u000fH\u0002J\b\u00105\u001a\u00020(H\u0002J\u0010\u00106\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u00107\u001a\u00020(H\u0002J\b\u00108\u001a\u00020(H\u0002J\b\u00109\u001a\u00020(H\u0002J\b\u0010:\u001a\u00020(H\u0002J\u0006\u0010;\u001a\u00020(J\b\u0010<\u001a\u00020(H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0018\u00010&R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;", "", "context", "Landroid/content/Context;", "appId", "", "report", "Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "ext_desc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onVerifyCallback", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;)V", "INTERVAL_UPDATE_TIME", "", "MAX_WAIT_TIME", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getExt_desc", "mobileTV", "Landroid/widget/TextView;", "getOnVerifyCallback", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "getPhoneItem", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getReport", "()Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "setReport", "(Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;)V", "sendCodeTV", "smsEditView", "Lcom/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView;", "verifyCodeView", "Landroid/view/View;", "verifyTime", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "doFailCallback", "", "errMsg", "doSendVerifyCode", "isFirst", "", "doSuccessCallback", "encryptedData", "iv", "doVerifyCode", "code", "handleCheckVerifyCodeStatus", "status", "handleSendVerifyCodeStatus", "hideVKB", "showErrorTips", "showVKB", "showVerifyMobileDialog", "startSmsListener", "stopSmsListener", "tryShow", "updateSendText", "Companion", "OnVerifyCallback", "VertifyTimer", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m */
public final class C42664m {
    public static final C33504a izc = new C33504a();
    private final String appId;
    final Context context;
    private TextView gsq;
    C26275be ixV;
    private View iyT;
    private EditVerifyCodeView iyU;
    private TextView iyV;
    private C2435c iyW;
    private final int iyX = 60000;
    private final int iyY = 1000;
    private final String iyZ;
    final PhoneItem iza;
    private final C2434b izb;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "", "onVerifyCallback", "", "isSuccess", "", "result", "", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$b */
    public interface C2434b {
        /* renamed from: a */
        void mo6348a(boolean z, Map<String, String> map);
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$c */
    public final class C2435c extends CountDownTimer {
        public C2435c(long j, long j2) {
            super(j, j2);
        }

        public final void onTick(long j) {
            AppMethodBeat.m2504i(134896);
            TextView b = C42664m.this.iyV;
            if (b != null) {
                b.setText(C42664m.this.context.getString(C25738R.string.f8907j3, new Object[]{(j / 1000)}));
                AppMethodBeat.m2505o(134896);
                return;
            }
            AppMethodBeat.m2505o(134896);
        }

        public final void onFinish() {
            AppMethodBeat.m2504i(134897);
            C42664m.m75541c(C42664m.this);
            AppMethodBeat.m2505o(134897);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$i */
    static final class C10702i implements Runnable {
        final /* synthetic */ C42664m izd;

        C10702i(C42664m c42664m) {
            this.izd = c42664m;
        }

        public final void run() {
            AppMethodBeat.m2504i(134911);
            Context context = this.izd.context;
            if (context == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.m2505o(134911);
                throw c44941v;
            }
            ((MMActivity) context).aqX();
            AppMethodBeat.m2505o(134911);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$k */
    static final class C10703k implements Runnable {
        final /* synthetic */ C42664m izd;

        C10703k(C42664m c42664m) {
            this.izd = c42664m;
        }

        public final void run() {
            AppMethodBeat.m2504i(134913);
            Context context = this.izd.context;
            if (context == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.m2505o(134913);
                throw c44941v;
            }
            ((MMActivity) context).showVKB();
            AppMethodBeat.m2505o(134913);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$l */
    static final class C10704l implements OnDismissListener {
        final /* synthetic */ C42664m izd;

        C10704l(C42664m c42664m) {
            this.izd = c42664m;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(134914);
            C4990ab.m7416i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
            C42664m.m75543d(this.izd);
            C42664m.m75544e(this.izd);
            AppMethodBeat.m2505o(134914);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$h */
    static final class C27274h implements OnClickListener {
        final /* synthetic */ C42664m izd;

        C27274h(C42664m c42664m) {
            this.izd = c42664m;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(134910);
            dialogInterface.dismiss();
            C4990ab.m7412e("MicroMsg.PhoneNumberVerifyCodeDialog", "verify code is error, do send the right code");
            C42664m.m75546g(this.izd);
            AppMethodBeat.m2505o(134910);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$j */
    static final class C27275j implements OnClickListener {
        final /* synthetic */ C42664m izd;

        C27275j(C42664m c42664m) {
            this.izd = c42664m;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(134912);
            dialogInterface.dismiss();
            C42664m.m75542c(this.izd, "fail");
            AppMethodBeat.m2505o(134912);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$a */
    public static final class C33504a {
        private C33504a() {
        }

        public /* synthetic */ C33504a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$d */
    static final class C33505d<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ boolean iyR;
        final /* synthetic */ C42664m izd;
        final /* synthetic */ C44275p ize;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$d$1 */
        static final class C335061 implements Runnable {
            final /* synthetic */ C33505d izf;

            C335061(C33505d c33505d) {
                this.izf = c33505d;
            }

            public final void run() {
                AppMethodBeat.m2504i(134898);
                C42664m c42664m = this.izf.izd;
                C27269a c27269a = C27268g.ixv;
                C42664m.m75536a(c42664m, C27268g.ixg);
                AppMethodBeat.m2505o(134898);
            }
        }

        C33505d(C42664m c42664m, C44275p c44275p, boolean z) {
            this.izd = c42664m;
            this.ize = c44275p;
            this.iyR = z;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(134900);
            C37441a c37441a = (C37441a) obj;
            this.ize.dismiss();
            if (c37441a.errType == 0 && c37441a.errCode == 0 && c37441a.fsy != null) {
                btd btd = c37441a.fsy;
                if (btd == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SendVerifyCodeResp");
                    AppMethodBeat.m2505o(134900);
                    throw c44941v;
                }
                final bwy bwy = (bwy) btd;
                C4990ab.m7416i("MicroMsg.PhoneNumberVerifyCodeDialog", "SendVerifyCode cgi success");
                C5004al.m7441d(new Runnable(this) {
                    final /* synthetic */ C33505d izf;

                    public final void run() {
                        AppMethodBeat.m2504i(134899);
                        if (this.izf.iyR) {
                            C42664m.m75546g(this.izf.izd);
                        }
                        C42664m.m75536a(this.izf.izd, bwy.status);
                        AppMethodBeat.m2505o(134899);
                    }
                });
            } else {
                C4990ab.m7413e("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber SendVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm, c37441a.fsy);
                C5004al.m7441d(new C335061(this));
                C42664m.m75542c(this.izd, "SendVerifyCode cgi fail");
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134900);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$e */
    static final class C33509e<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ boolean iyR;
        final /* synthetic */ C42664m izd;
        final /* synthetic */ C44275p ize;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$e$1 */
        static final class C335081 implements Runnable {
            final /* synthetic */ C33509e izh;

            C335081(C33509e c33509e) {
                this.izh = c33509e;
            }

            public final void run() {
                AppMethodBeat.m2504i(134901);
                C42664m c42664m = this.izh.izd;
                C27269a c27269a = C27268g.ixv;
                C42664m.m75536a(c42664m, C27268g.ixg);
                AppMethodBeat.m2505o(134901);
            }
        }

        C33509e(C42664m c42664m, C44275p c44275p, boolean z) {
            this.izd = c42664m;
            this.ize = c44275p;
            this.iyR = z;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(134903);
            C37441a c37441a = (C37441a) obj;
            this.ize.dismiss();
            if (c37441a.errType == 0 && c37441a.errCode == 0 && c37441a.fsy != null) {
                btd btd = c37441a.fsy;
                if (btd == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SendVerifyCodeResp");
                    AppMethodBeat.m2505o(134903);
                    throw c44941v;
                }
                final bwy bwy = (bwy) btd;
                C4990ab.m7416i("MicroMsg.PhoneNumberVerifyCodeDialog", "SendVerifyCode cgi success");
                C5004al.m7441d(new Runnable(this) {
                    final /* synthetic */ C33509e izh;

                    public final void run() {
                        AppMethodBeat.m2504i(134902);
                        if (this.izh.iyR) {
                            C42664m.m75546g(this.izh.izd);
                        }
                        C42664m.m75536a(this.izh.izd, bwy.status);
                        AppMethodBeat.m2505o(134902);
                    }
                });
            } else {
                C4990ab.m7413e("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber SendVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm, c37441a.fsy);
                C42664m.m75542c(this.izd, "SendVerifyCode cgi fail");
                C5004al.m7441d(new C335081(this));
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134903);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$f */
    static final class C33510f<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ C42664m izd;
        final /* synthetic */ C44275p ize;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$f$1 */
        static final class C24361 implements Runnable {
            final /* synthetic */ C33510f izi;

            C24361(C33510f c33510f) {
                this.izi = c33510f;
            }

            public final void run() {
                AppMethodBeat.m2504i(134904);
                C42664m c42664m = this.izi.izd;
                C27269a c27269a = C27268g.ixv;
                C42664m.m75537a(c42664m, C27268g.ixg, "", "");
                AppMethodBeat.m2505o(134904);
            }
        }

        C33510f(C42664m c42664m, C44275p c44275p) {
            this.izd = c42664m;
            this.ize = c44275p;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(134906);
            final C37441a c37441a = (C37441a) obj;
            this.ize.dismiss();
            if (c37441a.errType == 0 && c37441a.errCode == 0 && c37441a.fsy != null) {
                C4990ab.m7416i("MicroMsg.PhoneNumberVerifyCodeDialog", "checkVerifyCode success");
                if (c37441a.fsy == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CheckVerifyCodeResp");
                    AppMethodBeat.m2505o(134906);
                    throw c44941v;
                }
                C5004al.m7441d(new Runnable(this) {
                    final /* synthetic */ C33510f izi;

                    public final void run() {
                        AppMethodBeat.m2504i(134905);
                        C42664m.m75537a(this.izi.izd, ((C44165se) c37441a.fsy).status, ((C44165se) c37441a.fsy).ixJ, ((C44165se) c37441a.fsy).biC);
                        AppMethodBeat.m2505o(134905);
                    }
                });
            } else {
                C4990ab.m7413e("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber checkVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm, c37441a.fsy);
                C42664m.m75542c(this.izd, "checkVerifyCode cgi fail");
                C26275be c26275be = this.izd.ixV;
                if (c26275be != null) {
                    C26275be c26275be2 = this.izd.ixV;
                    Long valueOf = c26275be2 != null ? Long.valueOf(c26275be2.mo43989GU()) : null;
                    if (valueOf == null) {
                        C25052j.dWJ();
                    }
                    c26275be.mo44018dk(valueOf.longValue() + 1);
                }
                C5004al.m7441d(new C24361(this));
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134906);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$g */
    static final class C33511g<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ C42664m izd;
        final /* synthetic */ C44275p ize;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$g$1 */
        static final class C107011 implements Runnable {
            final /* synthetic */ C33511g izj;

            C107011(C33511g c33511g) {
                this.izj = c33511g;
            }

            public final void run() {
                AppMethodBeat.m2504i(134907);
                C42664m c42664m = this.izj.izd;
                C27269a c27269a = C27268g.ixv;
                C42664m.m75537a(c42664m, C27268g.ixg, "", "");
                AppMethodBeat.m2505o(134907);
            }
        }

        C33511g(C42664m c42664m, C44275p c44275p) {
            this.izd = c42664m;
            this.ize = c44275p;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(134909);
            final C37441a c37441a = (C37441a) obj;
            this.ize.dismiss();
            if (c37441a.errType == 0 && c37441a.errCode == 0 && c37441a.fsy != null) {
                C4990ab.m7416i("MicroMsg.PhoneNumberVerifyCodeDialog", "checkVerifyCode success");
                C5004al.m7441d(new Runnable(this) {
                    final /* synthetic */ C33511g izj;

                    public final void run() {
                        AppMethodBeat.m2504i(134908);
                        C42664m.m75537a(this.izj.izd, ((C44165se) c37441a.fsy).status, ((C44165se) c37441a.fsy).ixJ, ((C44165se) c37441a.fsy).biC);
                        AppMethodBeat.m2505o(134908);
                    }
                });
            } else {
                C4990ab.m7413e("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber checkVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm, c37441a.fsy);
                C42664m.m75542c(this.izd, "checkVerifyCode cgi fail");
                C26275be c26275be = this.izd.ixV;
                if (c26275be != null) {
                    C26275be c26275be2 = this.izd.ixV;
                    Long valueOf = c26275be2 != null ? Long.valueOf(c26275be2.mo43989GU()) : null;
                    if (valueOf == null) {
                        C25052j.dWJ();
                    }
                    c26275be.mo44018dk(valueOf.longValue() + 1);
                }
                C5004al.m7441d(new C107011(this));
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134909);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$m */
    static final class C38490m implements OnClickListener {
        final /* synthetic */ C42664m izd;

        C38490m(C42664m c42664m) {
            this.izd = c42664m;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0077  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00a6  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(DialogInterface dialogInterface, int i) {
            String text;
            Integer valueOf;
            Integer num = null;
            AppMethodBeat.m2504i(134915);
            String str = "MicroMsg.PhoneNumberVerifyCodeDialog";
            String str2 = "to verify sms %s";
            Object[] objArr = new Object[1];
            EditVerifyCodeView f = this.izd.iyU;
            objArr[0] = f != null ? f.getText() : null;
            C4990ab.m7417i(str, str2, objArr);
            f = this.izd.iyU;
            if (f != null) {
                text = f.getText();
                if (text != null && text.length() == 6) {
                    Object text2;
                    dialogInterface.dismiss();
                    C42664m.m75543d(this.izd);
                    C42664m.m75544e(this.izd);
                    C42664m c42664m = this.izd;
                    EditVerifyCodeView f2 = this.izd.iyU;
                    if (f2 != null) {
                        text2 = f2.getText();
                    }
                    C42664m.m75538a(c42664m, String.valueOf(text2));
                    AppMethodBeat.m2505o(134915);
                    return;
                }
            }
            f = this.izd.iyU;
            if (f != null) {
                text = f.getText();
                if (text != null) {
                    valueOf = Integer.valueOf(text.length());
                    if (valueOf == null) {
                        C25052j.dWJ();
                    }
                    if (valueOf.intValue() >= 6) {
                        C4990ab.m7412e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is length is < 6");
                        C42664m.m75543d(this.izd);
                        C30379h.m48462bN(this.izd.context, this.izd.context.getString(C25738R.string.f8914j_));
                        AppMethodBeat.m2505o(134915);
                        return;
                    }
                    f = this.izd.iyU;
                    if (f != null) {
                        text = f.getText();
                        if (text != null) {
                            num = Integer.valueOf(text.length());
                        }
                    }
                    if (num == null) {
                        C25052j.dWJ();
                    }
                    if (num.intValue() == 0) {
                        C4990ab.m7412e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is empty");
                        C42664m.m75543d(this.izd);
                        C30379h.m48462bN(this.izd.context, this.izd.context.getString(C25738R.string.f8913j9));
                    }
                    AppMethodBeat.m2505o(134915);
                    return;
                }
            }
            valueOf = null;
            if (valueOf == null) {
            }
            if (valueOf.intValue() >= 6) {
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$n */
    static final class C38491n implements OnClickListener {
        final /* synthetic */ C42664m izd;

        C38491n(C42664m c42664m) {
            this.izd = c42664m;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(134916);
            C4990ab.m7416i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
            dialogInterface.dismiss();
            C42664m.m75543d(this.izd);
            C42664m.m75544e(this.izd);
            AppMethodBeat.m2505o(134916);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$updateSendText$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "arg0", "Landroid/view/View;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$o */
    public static final class C42665o extends ClickableSpan {
        final /* synthetic */ C42664m izd;

        C42665o(C42664m c42664m) {
            this.izd = c42664m;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(134917);
            C25052j.m39376p(view, "arg0");
            C4990ab.m7416i("MicroMsg.PhoneNumberVerifyCodeDialog", "click the resend spanBuilder, do resend sms");
            if (this.izd.iza.ixL) {
                C42664m.m75535a(this.izd);
                AppMethodBeat.m2505o(134917);
                return;
            }
            C4990ab.m7412e("MicroMsg.PhoneNumberVerifyCodeDialog", "allow_send_sms is false, show send_verify_code_frequent error");
            C42664m c42664m = this.izd;
            String string = this.izd.context.getString(C25738R.string.f8910j6);
            C25052j.m39375o(string, "context.getString(R.stri…end_verify_code_frequent)");
            C42664m.m75540b(c42664m, string);
            AppMethodBeat.m2505o(134917);
        }
    }

    static {
        AppMethodBeat.m2504i(134924);
        AppMethodBeat.m2505o(134924);
    }

    public C42664m(Context context, String str, C26275be c26275be, String str2, PhoneItem phoneItem, C2434b c2434b) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(str2, "ext_desc");
        C25052j.m39376p(phoneItem, "phoneItem");
        AppMethodBeat.m2504i(134923);
        this.context = context;
        this.appId = str;
        this.ixV = c26275be;
        this.iyZ = str2;
        this.iza = phoneItem;
        this.izb = c2434b;
        Object systemService = this.context.getSystemService("layout_inflater");
        if (systemService == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.LayoutInflater");
            AppMethodBeat.m2505o(134923);
            throw c44941v;
        }
        EditVerifyCodeView editVerifyCodeView;
        TextView textView;
        this.iyT = ((LayoutInflater) systemService).inflate(2130968742, null);
        View view = this.iyT;
        if (view != null) {
            editVerifyCodeView = (EditVerifyCodeView) view.findViewById(2131821400);
        } else {
            editVerifyCodeView = null;
        }
        this.iyU = editVerifyCodeView;
        view = this.iyT;
        if (view != null) {
            textView = (TextView) view.findViewById(2131821399);
        } else {
            textView = null;
        }
        this.gsq = textView;
        view = this.iyT;
        if (view != null) {
            textView = (TextView) view.findViewById(2131821401);
        } else {
            textView = null;
        }
        this.iyV = textView;
        AppMethodBeat.m2505o(134923);
    }

    /* renamed from: b */
    public static final /* synthetic */ void m75540b(C42664m c42664m, String str) {
        AppMethodBeat.m2504i(134929);
        c42664m.m75534Dv(str);
        AppMethodBeat.m2505o(134929);
    }

    /* renamed from: c */
    public static final /* synthetic */ void m75541c(C42664m c42664m) {
        AppMethodBeat.m2504i(134925);
        c42664m.aKU();
        AppMethodBeat.m2505o(134925);
    }

    /* renamed from: d */
    public static final /* synthetic */ void m75543d(C42664m c42664m) {
        AppMethodBeat.m2504i(134926);
        c42664m.aKV();
        AppMethodBeat.m2505o(134926);
    }

    private final void aKU() {
        AppMethodBeat.m2504i(134918);
        String string = this.context.getString(C25738R.string.f8906j2);
        String string2 = this.context.getString(C25738R.string.f8908j4);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(string);
        spannableStringBuilder.append(string2);
        int length = string.length();
        int length2 = string2.length();
        spannableStringBuilder.setSpan(new C42665o(this), length, length + length2, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(C25738R.color.f12123t7)), length, length2 + length, 17);
        TextView textView = this.iyV;
        if (textView != null) {
            textView.setText(spannableStringBuilder);
        }
        TextView textView2 = this.iyV;
        if (textView2 != null) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            AppMethodBeat.m2505o(134918);
            return;
        }
        AppMethodBeat.m2505o(134918);
    }

    private final void aKV() {
        AppMethodBeat.m2504i(134919);
        C4990ab.m7416i("MicroMsg.PhoneNumberVerifyCodeDialog", "stopSmsListener");
        C2435c c2435c = this.iyW;
        if (c2435c != null) {
            c2435c.cancel();
            AppMethodBeat.m2505o(134919);
            return;
        }
        AppMethodBeat.m2505o(134919);
    }

    /* renamed from: a */
    static /* synthetic */ void m75535a(C42664m c42664m) {
        AppMethodBeat.m2504i(134921);
        c42664m.mo68085ez(false);
        AppMethodBeat.m2505o(134921);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ez */
    public final void mo68085ez(boolean z) {
        AppMethodBeat.m2504i(134920);
        C4990ab.m7416i("MicroMsg.PhoneNumberVerifyCodeDialog", "doSendVerifyCode");
        Context context = this.context;
        this.context.getString(C25738R.string.f9238tz);
        C44275p b = C30379h.m48458b(context, this.context.getString(C25738R.string.f9311wa), true, null);
        if (this.iza.ixM) {
            new C27267e(this.appId, this.iza.cFl).acy().mo60492h(new C33505d(this, b, z));
            AppMethodBeat.m2505o(134920);
            return;
        }
        new C41250d(this.appId, this.iza.cFl).acy().mo60492h(new C33509e(this, b, z));
        AppMethodBeat.m2505o(134920);
    }

    /* renamed from: Dv */
    private final void m75534Dv(String str) {
        AppMethodBeat.m2504i(134922);
        aKV();
        C30379h.m48448a(this.context, str, "", false, (OnClickListener) new C27275j(this));
        AppMethodBeat.m2505o(134922);
    }

    /* renamed from: e */
    public static final /* synthetic */ void m75544e(C42664m c42664m) {
        AppMethodBeat.m2504i(134927);
        View view = c42664m.iyT;
        if (view != null) {
            view.post(new C10702i(c42664m));
            AppMethodBeat.m2505o(134927);
            return;
        }
        AppMethodBeat.m2505o(134927);
    }

    /* renamed from: c */
    public static final /* synthetic */ void m75542c(C42664m c42664m, String str) {
        AppMethodBeat.m2504i(134931);
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", str);
        C2434b c2434b = c42664m.izb;
        if (c2434b != null) {
            c2434b.mo6348a(false, hashMap);
            AppMethodBeat.m2505o(134931);
            return;
        }
        AppMethodBeat.m2505o(134931);
    }

    /* renamed from: g */
    public static final /* synthetic */ void m75546g(C42664m c42664m) {
        AppMethodBeat.m2504i(134932);
        EditVerifyCodeView editVerifyCodeView = c42664m.iyU;
        if (editVerifyCodeView != null) {
            editVerifyCodeView.setText("");
        }
        TextView textView = c42664m.gsq;
        if (textView != null) {
            textView.setText(c42664m.context.getString(C25738R.string.f8916jb, new Object[]{c42664m.iyZ}));
        }
        c42664m.aKU();
        if (c42664m.iyT != null) {
            ViewParent parent;
            View view = c42664m.iyT;
            if (view != null) {
                parent = view.getParent();
            } else {
                parent = null;
            }
            if (parent instanceof ViewGroup) {
                view = c42664m.iyT;
                if (view != null) {
                    parent = view.getParent();
                } else {
                    parent = null;
                }
                if (parent == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.m2505o(134932);
                    throw c44941v;
                }
                ((ViewGroup) parent).removeView(c42664m.iyT);
            }
        }
        C5653c a = C30379h.m48434a(c42664m.context, c42664m.iyT, c42664m.context.getString(C25738R.string.f8917jc));
        if (a == null) {
            C4990ab.m7412e("MicroMsg.PhoneNumberVerifyCodeDialog", "smsDialog is null, return");
            AppMethodBeat.m2505o(134932);
            return;
        }
        a.setOnDismissListener(new C10704l(c42664m));
        a.mo11489a(c42664m.context.getString(C25738R.string.f9187s6), false, new C38490m(c42664m));
        a.mo11491b(c42664m.context.getString(C25738R.string.f9076or), true, new C38491n(c42664m));
        View view2 = c42664m.iyT;
        if (view2 != null) {
            view2.post(new C10703k(c42664m));
            AppMethodBeat.m2505o(134932);
            return;
        }
        AppMethodBeat.m2505o(134932);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m75537a(C42664m c42664m, int i, String str, String str2) {
        Long l = null;
        AppMethodBeat.m2504i(134933);
        C4990ab.m7417i("MicroMsg.PhoneNumberVerifyCodeDialog", "handleCheckVerifyCodeStatus:%d", Integer.valueOf(i));
        C27269a c27269a = C27268g.ixv;
        C26275be c26275be;
        C26275be c26275be2;
        if (i == C27268g.ixn) {
            Object str3;
            Object str22;
            c26275be = c42664m.ixV;
            if (c26275be != null) {
                c26275be2 = c42664m.ixV;
                if (c26275be2 != null) {
                    l = Long.valueOf(c26275be2.mo43988GT());
                }
                if (l == null) {
                    C25052j.dWJ();
                }
                c26275be.mo44017dj(l.longValue() + 1);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("errMsg", "ok");
            Map map = hashMap;
            String str4 = "encryptedData";
            if (str3 == null) {
                str3 = "";
            }
            map.put(str4, str3);
            map = hashMap;
            str4 = "iv";
            if (str22 == null) {
                str22 = "";
            }
            map.put(str4, str22);
            C2434b c2434b = c42664m.izb;
            if (c2434b != null) {
                c2434b.mo6348a(true, hashMap);
                AppMethodBeat.m2505o(134933);
                return;
            }
            AppMethodBeat.m2505o(134933);
            return;
        }
        c27269a = C27268g.ixv;
        String string;
        if (i == C27268g.ixo) {
            string = c42664m.context.getString(C25738R.string.f8910j6);
            C25052j.m39375o(string, "context.getString(R.stri…end_verify_code_frequent)");
            c42664m.m75534Dv(string);
            c26275be = c42664m.ixV;
            if (c26275be != null) {
                c26275be2 = c42664m.ixV;
                if (c26275be2 != null) {
                    l = Long.valueOf(c26275be2.mo43989GU());
                }
                if (l == null) {
                    C25052j.dWJ();
                }
                c26275be.mo44018dk(l.longValue() + 1);
                AppMethodBeat.m2505o(134933);
                return;
            }
            AppMethodBeat.m2505o(134933);
            return;
        }
        c27269a = C27268g.ixv;
        if (i != C27268g.ixq) {
            c27269a = C27268g.ixv;
            if (i != C27268g.ixr) {
                string = c42664m.context.getString(C25738R.string.f8915ja);
                C25052j.m39375o(string, "context.getString(R.stri…_number_verify_code_fail)");
                c42664m.m75534Dv(string);
                c26275be2 = c42664m.ixV;
                if (c26275be2 != null) {
                    c26275be = c42664m.ixV;
                    Long valueOf = c26275be != null ? Long.valueOf(c26275be.mo43989GU()) : null;
                    if (valueOf == null) {
                        C25052j.dWJ();
                    }
                    c26275be2.mo44018dk(valueOf.longValue() + 1);
                    AppMethodBeat.m2505o(134933);
                    return;
                }
                AppMethodBeat.m2505o(134933);
                return;
            }
        }
        C30379h.m48448a(c42664m.context, c42664m.context.getString(C25738R.string.f8912j8), "", false, (OnClickListener) new C27274h(c42664m));
        c26275be = c42664m.ixV;
        if (c26275be != null) {
            c26275be2 = c42664m.ixV;
            if (c26275be2 != null) {
                l = Long.valueOf(c26275be2.mo43989GU());
            }
            if (l == null) {
                C25052j.dWJ();
            }
            c26275be.mo44018dk(l.longValue() + 1);
            AppMethodBeat.m2505o(134933);
            return;
        }
        AppMethodBeat.m2505o(134933);
    }
}
