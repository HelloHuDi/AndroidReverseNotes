package com.tencent.mm.plugin.appbrand.phonenumber;

import a.v;
import a.y;
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
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.be;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;
import java.util.Map;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u0000 =2\u00020\u0001:\u0003=>?B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0012\u0010*\u001a\u00020(2\b\b\u0002\u0010+\u001a\u00020,H\u0002J\u001c\u0010-\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020\u0005H\u0002J$\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u00104\u001a\u00020(2\u0006\u00103\u001a\u00020\u000fH\u0002J\b\u00105\u001a\u00020(H\u0002J\u0010\u00106\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u00107\u001a\u00020(H\u0002J\b\u00108\u001a\u00020(H\u0002J\b\u00109\u001a\u00020(H\u0002J\b\u0010:\u001a\u00020(H\u0002J\u0006\u0010;\u001a\u00020(J\b\u0010<\u001a\u00020(H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0018\u00010&R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;", "", "context", "Landroid/content/Context;", "appId", "", "report", "Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "ext_desc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onVerifyCallback", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;)V", "INTERVAL_UPDATE_TIME", "", "MAX_WAIT_TIME", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getExt_desc", "mobileTV", "Landroid/widget/TextView;", "getOnVerifyCallback", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "getPhoneItem", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getReport", "()Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "setReport", "(Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;)V", "sendCodeTV", "smsEditView", "Lcom/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView;", "verifyCodeView", "Landroid/view/View;", "verifyTime", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "doFailCallback", "", "errMsg", "doSendVerifyCode", "isFirst", "", "doSuccessCallback", "encryptedData", "iv", "doVerifyCode", "code", "handleCheckVerifyCodeStatus", "status", "handleSendVerifyCodeStatus", "hideVKB", "showErrorTips", "showVKB", "showVerifyMobileDialog", "startSmsListener", "stopSmsListener", "tryShow", "updateSendText", "Companion", "OnVerifyCallback", "VertifyTimer", "plugin-appbrand-integration_release"})
public final class m {
    public static final a izc = new a();
    private final String appId;
    final Context context;
    private TextView gsq;
    be ixV;
    private View iyT;
    private EditVerifyCodeView iyU;
    private TextView iyV;
    private c iyW;
    private final int iyX = 60000;
    private final int iyY = 1000;
    private final String iyZ;
    final PhoneItem iza;
    private final b izb;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "", "onVerifyCallback", "", "isSuccess", "", "result", "", "", "plugin-appbrand-integration_release"})
    public interface b {
        void a(boolean z, Map<String, String> map);
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "plugin-appbrand-integration_release"})
    public final class c extends CountDownTimer {
        public c(long j, long j2) {
            super(j, j2);
        }

        public final void onTick(long j) {
            AppMethodBeat.i(134896);
            TextView b = m.this.iyV;
            if (b != null) {
                b.setText(m.this.context.getString(R.string.j3, new Object[]{(j / 1000)}));
                AppMethodBeat.o(134896);
                return;
            }
            AppMethodBeat.o(134896);
        }

        public final void onFinish() {
            AppMethodBeat.i(134897);
            m.c(m.this);
            AppMethodBeat.o(134897);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class i implements Runnable {
        final /* synthetic */ m izd;

        i(m mVar) {
            this.izd = mVar;
        }

        public final void run() {
            AppMethodBeat.i(134911);
            Context context = this.izd.context;
            if (context == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(134911);
                throw vVar;
            }
            ((MMActivity) context).aqX();
            AppMethodBeat.o(134911);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class k implements Runnable {
        final /* synthetic */ m izd;

        k(m mVar) {
            this.izd = mVar;
        }

        public final void run() {
            AppMethodBeat.i(134913);
            Context context = this.izd.context;
            if (context == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(134913);
                throw vVar;
            }
            ((MMActivity) context).showVKB();
            AppMethodBeat.o(134913);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class l implements OnDismissListener {
        final /* synthetic */ m izd;

        l(m mVar) {
            this.izd = mVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(134914);
            ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
            m.d(this.izd);
            m.e(this.izd);
            AppMethodBeat.o(134914);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class h implements OnClickListener {
        final /* synthetic */ m izd;

        h(m mVar) {
            this.izd = mVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(134910);
            dialogInterface.dismiss();
            ab.e("MicroMsg.PhoneNumberVerifyCodeDialog", "verify code is error, do send the right code");
            m.g(this.izd);
            AppMethodBeat.o(134910);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class j implements OnClickListener {
        final /* synthetic */ m izd;

        j(m mVar) {
            this.izd = mVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(134912);
            dialogInterface.dismiss();
            m.c(this.izd, "fail");
            AppMethodBeat.o(134912);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "kotlin.jvm.PlatformType", "call"})
    static final class d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ boolean iyR;
        final /* synthetic */ m izd;
        final /* synthetic */ p ize;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$d$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ d izf;

            AnonymousClass1(d dVar) {
                this.izf = dVar;
            }

            public final void run() {
                AppMethodBeat.i(134898);
                m mVar = this.izf.izd;
                com.tencent.mm.plugin.appbrand.phonenumber.g.a aVar = g.ixv;
                m.a(mVar, g.ixg);
                AppMethodBeat.o(134898);
            }
        }

        d(m mVar, p pVar, boolean z) {
            this.izd = mVar;
            this.ize = pVar;
            this.iyR = z;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(134900);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            this.ize.dismiss();
            if (aVar.errType == 0 && aVar.errCode == 0 && aVar.fsy != null) {
                btd btd = aVar.fsy;
                if (btd == null) {
                    v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SendVerifyCodeResp");
                    AppMethodBeat.o(134900);
                    throw vVar;
                }
                final bwy bwy = (bwy) btd;
                ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "SendVerifyCode cgi success");
                al.d(new Runnable(this) {
                    final /* synthetic */ d izf;

                    public final void run() {
                        AppMethodBeat.i(134899);
                        if (this.izf.iyR) {
                            m.g(this.izf.izd);
                        }
                        m.a(this.izf.izd, bwy.status);
                        AppMethodBeat.o(134899);
                    }
                });
            } else {
                ab.e("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber SendVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm, aVar.fsy);
                al.d(new AnonymousClass1(this));
                m.c(this.izd, "SendVerifyCode cgi fail");
            }
            y yVar = y.AUy;
            AppMethodBeat.o(134900);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "kotlin.jvm.PlatformType", "call"})
    static final class e<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ boolean iyR;
        final /* synthetic */ m izd;
        final /* synthetic */ p ize;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$e$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ e izh;

            AnonymousClass1(e eVar) {
                this.izh = eVar;
            }

            public final void run() {
                AppMethodBeat.i(134901);
                m mVar = this.izh.izd;
                com.tencent.mm.plugin.appbrand.phonenumber.g.a aVar = g.ixv;
                m.a(mVar, g.ixg);
                AppMethodBeat.o(134901);
            }
        }

        e(m mVar, p pVar, boolean z) {
            this.izd = mVar;
            this.ize = pVar;
            this.iyR = z;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(134903);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            this.ize.dismiss();
            if (aVar.errType == 0 && aVar.errCode == 0 && aVar.fsy != null) {
                btd btd = aVar.fsy;
                if (btd == null) {
                    v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SendVerifyCodeResp");
                    AppMethodBeat.o(134903);
                    throw vVar;
                }
                final bwy bwy = (bwy) btd;
                ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "SendVerifyCode cgi success");
                al.d(new Runnable(this) {
                    final /* synthetic */ e izh;

                    public final void run() {
                        AppMethodBeat.i(134902);
                        if (this.izh.iyR) {
                            m.g(this.izh.izd);
                        }
                        m.a(this.izh.izd, bwy.status);
                        AppMethodBeat.o(134902);
                    }
                });
            } else {
                ab.e("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber SendVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm, aVar.fsy);
                m.c(this.izd, "SendVerifyCode cgi fail");
                al.d(new AnonymousClass1(this));
            }
            y yVar = y.AUy;
            AppMethodBeat.o(134903);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "kotlin.jvm.PlatformType", "call"})
    static final class f<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ m izd;
        final /* synthetic */ p ize;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$f$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ f izi;

            AnonymousClass1(f fVar) {
                this.izi = fVar;
            }

            public final void run() {
                AppMethodBeat.i(134904);
                m mVar = this.izi.izd;
                com.tencent.mm.plugin.appbrand.phonenumber.g.a aVar = g.ixv;
                m.a(mVar, g.ixg, "", "");
                AppMethodBeat.o(134904);
            }
        }

        f(m mVar, p pVar) {
            this.izd = mVar;
            this.ize = pVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(134906);
            final com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            this.ize.dismiss();
            if (aVar.errType == 0 && aVar.errCode == 0 && aVar.fsy != null) {
                ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "checkVerifyCode success");
                if (aVar.fsy == null) {
                    v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CheckVerifyCodeResp");
                    AppMethodBeat.o(134906);
                    throw vVar;
                }
                al.d(new Runnable(this) {
                    final /* synthetic */ f izi;

                    public final void run() {
                        AppMethodBeat.i(134905);
                        m.a(this.izi.izd, ((se) aVar.fsy).status, ((se) aVar.fsy).ixJ, ((se) aVar.fsy).biC);
                        AppMethodBeat.o(134905);
                    }
                });
            } else {
                ab.e("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber checkVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm, aVar.fsy);
                m.c(this.izd, "checkVerifyCode cgi fail");
                be beVar = this.izd.ixV;
                if (beVar != null) {
                    be beVar2 = this.izd.ixV;
                    Long valueOf = beVar2 != null ? Long.valueOf(beVar2.GU()) : null;
                    if (valueOf == null) {
                        a.f.b.j.dWJ();
                    }
                    beVar.dk(valueOf.longValue() + 1);
                }
                al.d(new AnonymousClass1(this));
            }
            y yVar = y.AUy;
            AppMethodBeat.o(134906);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "kotlin.jvm.PlatformType", "call"})
    static final class g<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ m izd;
        final /* synthetic */ p ize;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.m$g$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ g izj;

            AnonymousClass1(g gVar) {
                this.izj = gVar;
            }

            public final void run() {
                AppMethodBeat.i(134907);
                m mVar = this.izj.izd;
                com.tencent.mm.plugin.appbrand.phonenumber.g.a aVar = g.ixv;
                m.a(mVar, g.ixg, "", "");
                AppMethodBeat.o(134907);
            }
        }

        g(m mVar, p pVar) {
            this.izd = mVar;
            this.ize = pVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(134909);
            final com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            this.ize.dismiss();
            if (aVar.errType == 0 && aVar.errCode == 0 && aVar.fsy != null) {
                ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "checkVerifyCode success");
                al.d(new Runnable(this) {
                    final /* synthetic */ g izj;

                    public final void run() {
                        AppMethodBeat.i(134908);
                        m.a(this.izj.izd, ((se) aVar.fsy).status, ((se) aVar.fsy).ixJ, ((se) aVar.fsy).biC);
                        AppMethodBeat.o(134908);
                    }
                });
            } else {
                ab.e("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber checkVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm, aVar.fsy);
                m.c(this.izd, "checkVerifyCode cgi fail");
                be beVar = this.izd.ixV;
                if (beVar != null) {
                    be beVar2 = this.izd.ixV;
                    Long valueOf = beVar2 != null ? Long.valueOf(beVar2.GU()) : null;
                    if (valueOf == null) {
                        a.f.b.j.dWJ();
                    }
                    beVar.dk(valueOf.longValue() + 1);
                }
                al.d(new AnonymousClass1(this));
            }
            y yVar = y.AUy;
            AppMethodBeat.o(134909);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class m implements OnClickListener {
        final /* synthetic */ m izd;

        m(m mVar) {
            this.izd = mVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0077  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00a6  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(DialogInterface dialogInterface, int i) {
            String text;
            Integer valueOf;
            Integer num = null;
            AppMethodBeat.i(134915);
            String str = "MicroMsg.PhoneNumberVerifyCodeDialog";
            String str2 = "to verify sms %s";
            Object[] objArr = new Object[1];
            EditVerifyCodeView f = this.izd.iyU;
            objArr[0] = f != null ? f.getText() : null;
            ab.i(str, str2, objArr);
            f = this.izd.iyU;
            if (f != null) {
                text = f.getText();
                if (text != null && text.length() == 6) {
                    Object text2;
                    dialogInterface.dismiss();
                    m.d(this.izd);
                    m.e(this.izd);
                    m mVar = this.izd;
                    EditVerifyCodeView f2 = this.izd.iyU;
                    if (f2 != null) {
                        text2 = f2.getText();
                    }
                    m.a(mVar, String.valueOf(text2));
                    AppMethodBeat.o(134915);
                    return;
                }
            }
            f = this.izd.iyU;
            if (f != null) {
                text = f.getText();
                if (text != null) {
                    valueOf = Integer.valueOf(text.length());
                    if (valueOf == null) {
                        a.f.b.j.dWJ();
                    }
                    if (valueOf.intValue() >= 6) {
                        ab.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is length is < 6");
                        m.d(this.izd);
                        com.tencent.mm.ui.base.h.bN(this.izd.context, this.izd.context.getString(R.string.j_));
                        AppMethodBeat.o(134915);
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
                        a.f.b.j.dWJ();
                    }
                    if (num.intValue() == 0) {
                        ab.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is empty");
                        m.d(this.izd);
                        com.tencent.mm.ui.base.h.bN(this.izd.context, this.izd.context.getString(R.string.j9));
                    }
                    AppMethodBeat.o(134915);
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

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class n implements OnClickListener {
        final /* synthetic */ m izd;

        n(m mVar) {
            this.izd = mVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(134916);
            ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
            dialogInterface.dismiss();
            m.d(this.izd);
            m.e(this.izd);
            AppMethodBeat.o(134916);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$updateSendText$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "arg0", "Landroid/view/View;", "plugin-appbrand-integration_release"})
    public static final class o extends ClickableSpan {
        final /* synthetic */ m izd;

        o(m mVar) {
            this.izd = mVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(134917);
            a.f.b.j.p(view, "arg0");
            ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "click the resend spanBuilder, do resend sms");
            if (this.izd.iza.ixL) {
                m.a(this.izd);
                AppMethodBeat.o(134917);
                return;
            }
            ab.e("MicroMsg.PhoneNumberVerifyCodeDialog", "allow_send_sms is false, show send_verify_code_frequent error");
            m mVar = this.izd;
            String string = this.izd.context.getString(R.string.j6);
            a.f.b.j.o(string, "context.getString(R.stri…end_verify_code_frequent)");
            m.b(mVar, string);
            AppMethodBeat.o(134917);
        }
    }

    static {
        AppMethodBeat.i(134924);
        AppMethodBeat.o(134924);
    }

    public m(Context context, String str, be beVar, String str2, PhoneItem phoneItem, b bVar) {
        a.f.b.j.p(context, "context");
        a.f.b.j.p(str, "appId");
        a.f.b.j.p(str2, "ext_desc");
        a.f.b.j.p(phoneItem, "phoneItem");
        AppMethodBeat.i(134923);
        this.context = context;
        this.appId = str;
        this.ixV = beVar;
        this.iyZ = str2;
        this.iza = phoneItem;
        this.izb = bVar;
        Object systemService = this.context.getSystemService("layout_inflater");
        if (systemService == null) {
            v vVar = new v("null cannot be cast to non-null type android.view.LayoutInflater");
            AppMethodBeat.o(134923);
            throw vVar;
        }
        EditVerifyCodeView editVerifyCodeView;
        TextView textView;
        this.iyT = ((LayoutInflater) systemService).inflate(R.layout.ds, null);
        View view = this.iyT;
        if (view != null) {
            editVerifyCodeView = (EditVerifyCodeView) view.findViewById(R.id.wf);
        } else {
            editVerifyCodeView = null;
        }
        this.iyU = editVerifyCodeView;
        view = this.iyT;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.we);
        } else {
            textView = null;
        }
        this.gsq = textView;
        view = this.iyT;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.wg);
        } else {
            textView = null;
        }
        this.iyV = textView;
        AppMethodBeat.o(134923);
    }

    public static final /* synthetic */ void b(m mVar, String str) {
        AppMethodBeat.i(134929);
        mVar.Dv(str);
        AppMethodBeat.o(134929);
    }

    public static final /* synthetic */ void c(m mVar) {
        AppMethodBeat.i(134925);
        mVar.aKU();
        AppMethodBeat.o(134925);
    }

    public static final /* synthetic */ void d(m mVar) {
        AppMethodBeat.i(134926);
        mVar.aKV();
        AppMethodBeat.o(134926);
    }

    private final void aKU() {
        AppMethodBeat.i(134918);
        String string = this.context.getString(R.string.j2);
        String string2 = this.context.getString(R.string.j4);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(string);
        spannableStringBuilder.append(string2);
        int length = string.length();
        int length2 = string2.length();
        spannableStringBuilder.setSpan(new o(this), length, length + length2, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.t7)), length, length2 + length, 17);
        TextView textView = this.iyV;
        if (textView != null) {
            textView.setText(spannableStringBuilder);
        }
        TextView textView2 = this.iyV;
        if (textView2 != null) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            AppMethodBeat.o(134918);
            return;
        }
        AppMethodBeat.o(134918);
    }

    private final void aKV() {
        AppMethodBeat.i(134919);
        ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "stopSmsListener");
        c cVar = this.iyW;
        if (cVar != null) {
            cVar.cancel();
            AppMethodBeat.o(134919);
            return;
        }
        AppMethodBeat.o(134919);
    }

    static /* synthetic */ void a(m mVar) {
        AppMethodBeat.i(134921);
        mVar.ez(false);
        AppMethodBeat.o(134921);
    }

    /* Access modifiers changed, original: final */
    public final void ez(boolean z) {
        AppMethodBeat.i(134920);
        ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "doSendVerifyCode");
        Context context = this.context;
        this.context.getString(R.string.tz);
        p b = com.tencent.mm.ui.base.h.b(context, this.context.getString(R.string.wa), true, null);
        if (this.iza.ixM) {
            new e(this.appId, this.iza.cFl).acy().h(new d(this, b, z));
            AppMethodBeat.o(134920);
            return;
        }
        new d(this.appId, this.iza.cFl).acy().h(new e(this, b, z));
        AppMethodBeat.o(134920);
    }

    private final void Dv(String str) {
        AppMethodBeat.i(134922);
        aKV();
        com.tencent.mm.ui.base.h.a(this.context, str, "", false, (OnClickListener) new j(this));
        AppMethodBeat.o(134922);
    }

    public static final /* synthetic */ void e(m mVar) {
        AppMethodBeat.i(134927);
        View view = mVar.iyT;
        if (view != null) {
            view.post(new i(mVar));
            AppMethodBeat.o(134927);
            return;
        }
        AppMethodBeat.o(134927);
    }

    public static final /* synthetic */ void c(m mVar, String str) {
        AppMethodBeat.i(134931);
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", str);
        b bVar = mVar.izb;
        if (bVar != null) {
            bVar.a(false, hashMap);
            AppMethodBeat.o(134931);
            return;
        }
        AppMethodBeat.o(134931);
    }

    public static final /* synthetic */ void g(m mVar) {
        AppMethodBeat.i(134932);
        EditVerifyCodeView editVerifyCodeView = mVar.iyU;
        if (editVerifyCodeView != null) {
            editVerifyCodeView.setText("");
        }
        TextView textView = mVar.gsq;
        if (textView != null) {
            textView.setText(mVar.context.getString(R.string.jb, new Object[]{mVar.iyZ}));
        }
        mVar.aKU();
        if (mVar.iyT != null) {
            ViewParent parent;
            View view = mVar.iyT;
            if (view != null) {
                parent = view.getParent();
            } else {
                parent = null;
            }
            if (parent instanceof ViewGroup) {
                view = mVar.iyT;
                if (view != null) {
                    parent = view.getParent();
                } else {
                    parent = null;
                }
                if (parent == null) {
                    v vVar = new v("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.o(134932);
                    throw vVar;
                }
                ((ViewGroup) parent).removeView(mVar.iyT);
            }
        }
        com.tencent.mm.ui.widget.a.c a = com.tencent.mm.ui.base.h.a(mVar.context, mVar.iyT, mVar.context.getString(R.string.jc));
        if (a == null) {
            ab.e("MicroMsg.PhoneNumberVerifyCodeDialog", "smsDialog is null, return");
            AppMethodBeat.o(134932);
            return;
        }
        a.setOnDismissListener(new l(mVar));
        a.a(mVar.context.getString(R.string.s6), false, new m(mVar));
        a.b(mVar.context.getString(R.string.or), true, new n(mVar));
        View view2 = mVar.iyT;
        if (view2 != null) {
            view2.post(new k(mVar));
            AppMethodBeat.o(134932);
            return;
        }
        AppMethodBeat.o(134932);
    }

    public static final /* synthetic */ void a(m mVar, int i, String str, String str2) {
        Long l = null;
        AppMethodBeat.i(134933);
        ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "handleCheckVerifyCodeStatus:%d", Integer.valueOf(i));
        com.tencent.mm.plugin.appbrand.phonenumber.g.a aVar = g.ixv;
        be beVar;
        be beVar2;
        if (i == g.ixn) {
            Object str3;
            Object str22;
            beVar = mVar.ixV;
            if (beVar != null) {
                beVar2 = mVar.ixV;
                if (beVar2 != null) {
                    l = Long.valueOf(beVar2.GT());
                }
                if (l == null) {
                    a.f.b.j.dWJ();
                }
                beVar.dj(l.longValue() + 1);
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
            b bVar = mVar.izb;
            if (bVar != null) {
                bVar.a(true, hashMap);
                AppMethodBeat.o(134933);
                return;
            }
            AppMethodBeat.o(134933);
            return;
        }
        aVar = g.ixv;
        String string;
        if (i == g.ixo) {
            string = mVar.context.getString(R.string.j6);
            a.f.b.j.o(string, "context.getString(R.stri…end_verify_code_frequent)");
            mVar.Dv(string);
            beVar = mVar.ixV;
            if (beVar != null) {
                beVar2 = mVar.ixV;
                if (beVar2 != null) {
                    l = Long.valueOf(beVar2.GU());
                }
                if (l == null) {
                    a.f.b.j.dWJ();
                }
                beVar.dk(l.longValue() + 1);
                AppMethodBeat.o(134933);
                return;
            }
            AppMethodBeat.o(134933);
            return;
        }
        aVar = g.ixv;
        if (i != g.ixq) {
            aVar = g.ixv;
            if (i != g.ixr) {
                string = mVar.context.getString(R.string.ja);
                a.f.b.j.o(string, "context.getString(R.stri…_number_verify_code_fail)");
                mVar.Dv(string);
                beVar2 = mVar.ixV;
                if (beVar2 != null) {
                    beVar = mVar.ixV;
                    Long valueOf = beVar != null ? Long.valueOf(beVar.GU()) : null;
                    if (valueOf == null) {
                        a.f.b.j.dWJ();
                    }
                    beVar2.dk(valueOf.longValue() + 1);
                    AppMethodBeat.o(134933);
                    return;
                }
                AppMethodBeat.o(134933);
                return;
            }
        }
        com.tencent.mm.ui.base.h.a(mVar.context, mVar.context.getString(R.string.j8), "", false, (OnClickListener) new h(mVar));
        beVar = mVar.ixV;
        if (beVar != null) {
            beVar2 = mVar.ixV;
            if (beVar2 != null) {
                l = Long.valueOf(beVar2.GU());
            }
            if (l == null) {
                a.f.b.j.dWJ();
            }
            beVar.dk(l.longValue() + 1);
            AppMethodBeat.o(134933);
            return;
        }
        AppMethodBeat.o(134933);
    }
}
