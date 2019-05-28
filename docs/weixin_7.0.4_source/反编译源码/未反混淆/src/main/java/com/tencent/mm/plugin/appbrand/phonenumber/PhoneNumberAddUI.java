package com.tencent.mm.plugin.appbrand.phonenumber;

import a.l;
import a.y;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.be;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMSwitchBtn;

@com.tencent.mm.ui.base.a(3)
@l(dWo = {1, 1, 13}, dWp = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020+H\u0014J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020-H\u0014J\b\u00101\u001a\u00020-H\u0014J\b\u00102\u001a\u00020-H\u0002J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\u0004H\u0002J\b\u00105\u001a\u00020-H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00067"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "finishBtn", "Landroid/widget/Button;", "getFinishBtn", "()Landroid/widget/Button;", "setFinishBtn", "(Landroid/widget/Button;)V", "formInputView", "Lcom/tencent/mm/ui/base/MMFormVerifyCodeInputView;", "getFormInputView", "()Lcom/tencent/mm/ui/base/MMFormVerifyCodeInputView;", "setFormInputView", "(Lcom/tencent/mm/ui/base/MMFormVerifyCodeInputView;)V", "formVerifyCodeInputView", "Lcom/tencent/mm/ui/base/MMFormInputView;", "getFormVerifyCodeInputView", "()Lcom/tencent/mm/ui/base/MMFormInputView;", "setFormVerifyCodeInputView", "(Lcom/tencent/mm/ui/base/MMFormInputView;)V", "mobile", "getMobile", "setMobile", "report", "Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "getReport", "()Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "setReport", "(Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;)V", "switchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "getSwitchBtn", "()Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "setSwitchBtn", "(Lcom/tencent/mm/ui/widget/MMSwitchBtn;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "sendSms", "showErrorTips", "errMsg", "verifyCode", "Companion", "plugin-appbrand-integration_release"})
public final class PhoneNumberAddUI extends MMActivity {
    public static final a ixW = new a();
    String appId = "";
    String cFl = "";
    MMFormVerifyCodeInputView ixR;
    MMFormInputView ixS;
    MMSwitchBtn ixT;
    Button ixU;
    be ixV;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, dWq = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "call", "(Lkotlin/Unit;)V"})
    static final class k<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ p iyc;

        k(p pVar) {
            this.iyc = pVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(134835);
            this.iyc.dismiss();
            y yVar = y.AUy;
            AppMethodBeat.o(134835);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI$onCreate$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-appbrand-integration_release"})
    public static final class c implements TextWatcher {
        final /* synthetic */ PhoneNumberAddUI ixX;

        c(PhoneNumberAddUI phoneNumberAddUI) {
            this.ixX = phoneNumberAddUI;
        }

        /* JADX WARNING: Missing block: B:7:0x001c, code skipped:
            if (r0.length() == 0) goto L_0x0038;
     */
        /* JADX WARNING: Missing block: B:13:0x002e, code skipped:
            if (r0.length() == 0) goto L_0x0038;
     */
        /* JADX WARNING: Missing block: B:16:0x0038, code skipped:
            r0 = false;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(134818);
            Button button = this.ixX.ixU;
            if (button != null) {
                Editable text;
                MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.ixX.ixR;
                if (mMFormVerifyCodeInputView != null) {
                    text = mMFormVerifyCodeInputView.getText();
                    if (text != null) {
                    }
                }
                MMFormInputView mMFormInputView = this.ixX.ixS;
                if (mMFormInputView != null) {
                    text = mMFormInputView.getText();
                    if (text != null) {
                    }
                }
                boolean z = true;
                button.setEnabled(z);
                AppMethodBeat.o(134818);
                return;
            }
            AppMethodBeat.o(134818);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI$onCreate$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-appbrand-integration_release"})
    public static final class d implements TextWatcher {
        final /* synthetic */ PhoneNumberAddUI ixX;

        d(PhoneNumberAddUI phoneNumberAddUI) {
            this.ixX = phoneNumberAddUI;
        }

        /* JADX WARNING: Missing block: B:7:0x0022, code skipped:
            if (r0.length() == 0) goto L_0x003e;
     */
        /* JADX WARNING: Missing block: B:13:0x0034, code skipped:
            if (r0.length() == 0) goto L_0x003e;
     */
        /* JADX WARNING: Missing block: B:16:0x003e, code skipped:
            r0 = false;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(134819);
            a.f.b.j.p(charSequence, "s");
            Button button = this.ixX.ixU;
            if (button != null) {
                Editable text;
                MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.ixX.ixR;
                if (mMFormVerifyCodeInputView != null) {
                    text = mMFormVerifyCodeInputView.getText();
                    if (text != null) {
                    }
                }
                MMFormInputView mMFormInputView = this.ixX.ixS;
                if (mMFormInputView != null) {
                    text = mMFormInputView.getText();
                    if (text != null) {
                    }
                }
                boolean z = true;
                button.setEnabled(z);
                AppMethodBeat.o(134819);
                return;
            }
            AppMethodBeat.o(134819);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(134820);
            a.f.b.j.p(charSequence, "s");
            AppMethodBeat.o(134820);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(134821);
            a.f.b.j.p(editable, "s");
            AppMethodBeat.o(134821);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements OnClickListener {
        final /* synthetic */ PhoneNumberAddUI ixX;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$b$1 */
        static final class AnonymousClass1 implements DialogInterface.OnClickListener {
            final /* synthetic */ b ixY;

            AnonymousClass1(b bVar) {
                this.ixY = bVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(134815);
                PhoneNumberAddUI.a(this.ixY.ixX);
                AppMethodBeat.o(134815);
            }
        }

        b(PhoneNumberAddUI phoneNumberAddUI) {
            this.ixX = phoneNumberAddUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(134817);
            PhoneNumberAddUI phoneNumberAddUI = this.ixX;
            MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.ixX.ixR;
            phoneNumberAddUI.iN(String.valueOf(mMFormVerifyCodeInputView != null ? mMFormVerifyCodeInputView.getText() : null));
            if (bo.isNullOrNil(this.ixX.cFl)) {
                com.tencent.mm.ui.base.h.g(this.ixX, R.string.w0, R.string.w1);
                ab.e("MicroMsg.PhoneNumberAddUI", "mobile:%s isn't phone", this.ixX.cFl);
                AppMethodBeat.o(134817);
                return;
            }
            com.tencent.mm.ui.base.h.d(this.ixX, this.ixX.getString(R.string.jt) + this.ixX.cFl, this.ixX.getString(R.string.jo), this.ixX.getString(R.string.s6), this.ixX.getString(R.string.or), new AnonymousClass1(this), AnonymousClass2.ixZ);
            AppMethodBeat.o(134817);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements OnClickListener {
        final /* synthetic */ PhoneNumberAddUI ixX;

        e(PhoneNumberAddUI phoneNumberAddUI) {
            this.ixX = phoneNumberAddUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(134822);
            PhoneNumberAddUI phoneNumberAddUI = this.ixX;
            MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.ixX.ixR;
            phoneNumberAddUI.iN(String.valueOf(mMFormVerifyCodeInputView != null ? mMFormVerifyCodeInputView.getText() : null));
            if (!bo.isNullOrNil(this.ixX.cFl)) {
                PhoneNumberAddUI.b(this.ixX);
            }
            AppMethodBeat.o(134822);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, dWq = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "call", "(Lkotlin/Unit;)V"})
    static final class h<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ p iyc;

        h(p pVar) {
            this.iyc = pVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(134827);
            this.iyc.dismiss();
            y yVar = y.AUy;
            AppMethodBeat.o(134827);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI$Companion;", "", "()V", "APPID", "", "TAG", "addPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static void X(Context context, String str) {
            AppMethodBeat.i(134814);
            a.f.b.j.p(context, "context");
            a.f.b.j.p(str, "appId");
            Intent intent = new Intent(context, PhoneNumberAddUI.class);
            intent.putExtra("APPID", str);
            context.startActivity(intent);
            AppMethodBeat.o(134814);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class f implements OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberAddUI ixX;

        f(PhoneNumberAddUI phoneNumberAddUI) {
            this.ixX = phoneNumberAddUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(134823);
            this.ixX.finish();
            AppMethodBeat.o(134823);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "kotlin.jvm.PlatformType", "call"})
    static final class j<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ PhoneNumberAddUI ixX;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$j$2 */
        static final class AnonymousClass2 implements Runnable {
            final /* synthetic */ j iye;

            AnonymousClass2(j jVar) {
                this.iye = jVar;
            }

            public final void run() {
                AppMethodBeat.i(134833);
                be beVar = this.iye.ixX.ixV;
                if (beVar != null) {
                    be beVar2 = this.iye.ixX.ixV;
                    Long valueOf = beVar2 != null ? Long.valueOf(beVar2.GL()) : null;
                    if (valueOf == null) {
                        a.f.b.j.dWJ();
                    }
                    beVar.db(valueOf.longValue() + 1);
                }
                PhoneNumberAddUI phoneNumberAddUI = this.iye.ixX;
                String string = this.iye.ixX.dxU().getString(R.string.ja);
                a.f.b.j.o(string, "context.getString(R.stri…_number_verify_code_fail)");
                PhoneNumberAddUI.a(phoneNumberAddUI, string);
                AppMethodBeat.o(134833);
            }
        }

        j(PhoneNumberAddUI phoneNumberAddUI) {
            this.ixX = phoneNumberAddUI;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(134834);
            final com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.PhoneNumberAddUI", "verifyCode errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                ab.i("MicroMsg.PhoneNumberAddUI", "checkVerifyCode:%d", Integer.valueOf(((se) aVar.fsy).status));
                al.d(new Runnable(this) {
                    final /* synthetic */ j iye;

                    public final void run() {
                        Long l = null;
                        AppMethodBeat.i(134832);
                        int i = ((se) aVar.fsy).status;
                        com.tencent.mm.plugin.appbrand.phonenumber.g.a aVar = g.ixv;
                        be beVar;
                        be beVar2;
                        Long valueOf;
                        if (i == g.ixn) {
                            Boolean valueOf2;
                            beVar = this.iye.ixX.ixV;
                            if (beVar != null) {
                                beVar2 = this.iye.ixX.ixV;
                                valueOf = beVar2 != null ? Long.valueOf(beVar2.GK()) : null;
                                if (valueOf == null) {
                                    a.f.b.j.dWJ();
                                }
                                beVar.da(valueOf.longValue() + 1);
                            }
                            final String str = ((se) aVar.fsy).ixJ;
                            final String str2 = ((se) aVar.fsy).biC;
                            final String str3 = ((se) aVar.fsy).vZw;
                            MMSwitchBtn mMSwitchBtn = this.iye.ixX.ixT;
                            if (mMSwitchBtn != null) {
                                valueOf2 = Boolean.valueOf(mMSwitchBtn.dKD());
                            }
                            if (valueOf2 == null) {
                                a.f.b.j.dWJ();
                            }
                            if (valueOf2.booleanValue()) {
                                new f(this.iye.ixX.appId, this.iye.ixX.cFl, 0).acy().h(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                                    final /* synthetic */ AnonymousClass1 iyf;

                                    public final /* synthetic */ Object call(Object obj) {
                                        AppMethodBeat.i(134830);
                                        com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                                        ab.i("MicroMsg.PhoneNumberAddUI", "updateUserPhone errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
                                        if (aVar.errType == 0 && aVar.errCode == 0) {
                                            com.tencent.mm.plugin.appbrand.phonenumber.j.a aVar2 = j.ixQ;
                                            String str = this.iyf.iye.ixX.cFl;
                                            String str2 = str3;
                                            a.f.b.j.o(str2, "showMobile");
                                            String str3 = str;
                                            a.f.b.j.o(str3, "encryptedData");
                                            String str4 = str2;
                                            a.f.b.j.o(str4, "iv");
                                            aVar2.a(new PhoneItem(str, str2, str3, str4));
                                            this.iyf.iye.ixX.finish();
                                        }
                                        y yVar = y.AUy;
                                        AppMethodBeat.o(134830);
                                        return yVar;
                                    }
                                });
                                AppMethodBeat.o(134832);
                                return;
                            }
                            com.tencent.mm.plugin.appbrand.phonenumber.j.a aVar2 = j.ixQ;
                            String str4 = this.iye.ixX.cFl;
                            a.f.b.j.o(str3, "showMobile");
                            a.f.b.j.o(str, "encryptedData");
                            a.f.b.j.o(str2, "iv");
                            aVar2.a(new PhoneItem(str4, str3, str, str2));
                            this.iye.ixX.finish();
                            AppMethodBeat.o(134832);
                            return;
                        }
                        aVar = g.ixv;
                        PhoneNumberAddUI phoneNumberAddUI;
                        String string;
                        if (i == g.ixo) {
                            beVar2 = this.iye.ixX.ixV;
                            if (beVar2 != null) {
                                beVar = this.iye.ixX.ixV;
                                if (beVar != null) {
                                    l = Long.valueOf(beVar.GL());
                                }
                                if (l == null) {
                                    a.f.b.j.dWJ();
                                }
                                beVar2.db(l.longValue() + 1);
                            }
                            phoneNumberAddUI = this.iye.ixX;
                            string = this.iye.ixX.dxU().getString(R.string.j6);
                            a.f.b.j.o(string, "context.getString(R.stri…end_verify_code_frequent)");
                            PhoneNumberAddUI.a(phoneNumberAddUI, string);
                            AppMethodBeat.o(134832);
                            return;
                        }
                        aVar = g.ixv;
                        if (i == g.ixq) {
                            beVar2 = this.iye.ixX.ixV;
                            if (beVar2 != null) {
                                beVar = this.iye.ixX.ixV;
                                if (beVar != null) {
                                    l = Long.valueOf(beVar.GL());
                                }
                                if (l == null) {
                                    a.f.b.j.dWJ();
                                }
                                beVar2.db(l.longValue() + 1);
                            }
                            com.tencent.mm.ui.base.h.a((Context) this.iye.ixX.dxU(), this.iye.ixX.dxU().getString(R.string.j8), "", false, (DialogInterface.OnClickListener) AnonymousClass2.iyj);
                            AppMethodBeat.o(134832);
                            return;
                        }
                        beVar = this.iye.ixX.ixV;
                        if (beVar != null) {
                            beVar2 = this.iye.ixX.ixV;
                            if (beVar2 != null) {
                                valueOf = Long.valueOf(beVar2.GL());
                            } else {
                                valueOf = null;
                            }
                            if (valueOf == null) {
                                a.f.b.j.dWJ();
                            }
                            beVar.db(valueOf.longValue() + 1);
                        }
                        phoneNumberAddUI = this.iye.ixX;
                        string = this.iye.ixX.dxU().getString(R.string.ja);
                        a.f.b.j.o(string, "context.getString(R.stri…_number_verify_code_fail)");
                        PhoneNumberAddUI.a(phoneNumberAddUI, string);
                        AppMethodBeat.o(134832);
                    }
                });
            } else {
                al.d(new AnonymousClass2(this));
            }
            y yVar = y.AUy;
            AppMethodBeat.o(134834);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "kotlin.jvm.PlatformType", "call"})
    static final class g<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ PhoneNumberAddUI ixX;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$g$2 */
        static final class AnonymousClass2 implements Runnable {
            final /* synthetic */ g iya;

            AnonymousClass2(g gVar) {
                this.iya = gVar;
            }

            public final void run() {
                AppMethodBeat.i(134825);
                be beVar = this.iya.ixX.ixV;
                if (beVar != null) {
                    be beVar2 = this.iya.ixX.ixV;
                    Long valueOf = beVar2 != null ? Long.valueOf(beVar2.GI()) : null;
                    if (valueOf == null) {
                        a.f.b.j.dWJ();
                    }
                    beVar.cY(valueOf.longValue() + 1);
                }
                PhoneNumberAddUI phoneNumberAddUI = this.iya.ixX;
                String string = this.iya.ixX.dxU().getString(R.string.j5);
                a.f.b.j.o(string, "context.getString(R.stri…er_send_verify_code_fail)");
                PhoneNumberAddUI.a(phoneNumberAddUI, string);
                AppMethodBeat.o(134825);
            }
        }

        g(PhoneNumberAddUI phoneNumberAddUI) {
            this.ixX = phoneNumberAddUI;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(134826);
            final com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.PhoneNumberAddUI", "sendSms errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                ab.i("MicroMsg.PhoneNumberAddUI", "sendSms:%d", Integer.valueOf(((bwy) aVar.fsy).status));
                al.d(new Runnable(this) {
                    final /* synthetic */ g iya;

                    public final void run() {
                        Long l = null;
                        AppMethodBeat.i(134824);
                        int i = ((bwy) aVar.fsy).status;
                        com.tencent.mm.plugin.appbrand.phonenumber.g.a aVar = g.ixv;
                        be beVar;
                        be beVar2;
                        if (i == g.ixh) {
                            beVar = this.iya.ixX.ixV;
                            if (beVar != null) {
                                beVar2 = this.iya.ixX.ixV;
                                if (beVar2 != null) {
                                    l = Long.valueOf(beVar2.GH());
                                }
                                if (l == null) {
                                    a.f.b.j.dWJ();
                                }
                                beVar.cX(l.longValue() + 1);
                                AppMethodBeat.o(134824);
                                return;
                            }
                            AppMethodBeat.o(134824);
                            return;
                        }
                        aVar = g.ixv;
                        PhoneNumberAddUI phoneNumberAddUI;
                        String string;
                        if (i == g.ixi) {
                            beVar = this.iya.ixX.ixV;
                            if (beVar != null) {
                                beVar2 = this.iya.ixX.ixV;
                                if (beVar2 != null) {
                                    l = Long.valueOf(beVar2.GI());
                                }
                                if (l == null) {
                                    a.f.b.j.dWJ();
                                }
                                beVar.cY(l.longValue() + 1);
                            }
                            phoneNumberAddUI = this.iya.ixX;
                            string = this.iya.ixX.dxU().getString(R.string.j5);
                            a.f.b.j.o(string, "context.getString(R.stri…er_send_verify_code_fail)");
                            PhoneNumberAddUI.a(phoneNumberAddUI, string);
                            AppMethodBeat.o(134824);
                            return;
                        }
                        aVar = g.ixv;
                        if (i == g.ixj) {
                            beVar = this.iya.ixX.ixV;
                            if (beVar != null) {
                                beVar2 = this.iya.ixX.ixV;
                                if (beVar2 != null) {
                                    l = Long.valueOf(beVar2.GI());
                                }
                                if (l == null) {
                                    a.f.b.j.dWJ();
                                }
                                beVar.cY(l.longValue() + 1);
                            }
                            phoneNumberAddUI = this.iya.ixX;
                            string = this.iya.ixX.dxU().getString(R.string.j6);
                            a.f.b.j.o(string, "context.getString(R.stri…end_verify_code_frequent)");
                            PhoneNumberAddUI.a(phoneNumberAddUI, string);
                            AppMethodBeat.o(134824);
                            return;
                        }
                        beVar2 = this.iya.ixX.ixV;
                        if (beVar2 != null) {
                            Long valueOf;
                            beVar = this.iya.ixX.ixV;
                            if (beVar != null) {
                                valueOf = Long.valueOf(beVar.GI());
                            } else {
                                valueOf = null;
                            }
                            if (valueOf == null) {
                                a.f.b.j.dWJ();
                            }
                            beVar2.cY(valueOf.longValue() + 1);
                        }
                        phoneNumberAddUI = this.iya.ixX;
                        string = this.iya.ixX.dxU().getString(R.string.j5);
                        a.f.b.j.o(string, "context.getString(R.stri…er_send_verify_code_fail)");
                        PhoneNumberAddUI.a(phoneNumberAddUI, string);
                        AppMethodBeat.o(134824);
                    }
                });
            } else {
                al.d(new AnonymousClass2(this));
            }
            y yVar = y.AUy;
            AppMethodBeat.o(134826);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class i implements DialogInterface.OnClickListener {
        public static final i iyd = new i();

        static {
            AppMethodBeat.i(134829);
            AppMethodBeat.o(134829);
        }

        i() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(134828);
            dialogInterface.dismiss();
            AppMethodBeat.o(134828);
        }
    }

    static {
        AppMethodBeat.i(134840);
        AppMethodBeat.o(134840);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void iN(String str) {
        AppMethodBeat.i(134836);
        a.f.b.j.p(str, "<set-?>");
        this.cFl = str;
        AppMethodBeat.o(134836);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(134837);
        super.onCreate(bundle);
        xE(-1);
        getContentView().setBackgroundColor(dyd());
        String stringExtra = getIntent().getStringExtra("APPID");
        a.f.b.j.o(stringExtra, "intent.getStringExtra(APPID)");
        this.appId = stringExtra;
        ab.i("MicroMsg.PhoneNumberAddUI", "onCreate() appId:%s", this.appId);
        this.ixV = b.a.a.a.a.a.a.a.a.BTg.awB(this.appId);
        this.ixT = (MMSwitchBtn) findViewById(R.id.sd);
        this.ixU = (Button) findViewById(R.id.se);
        this.ixR = (MMFormVerifyCodeInputView) findViewById(R.id.sb);
        MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.ixR;
        if (mMFormVerifyCodeInputView != null) {
            mMFormVerifyCodeInputView.setInputType(3);
        }
        MMFormVerifyCodeInputView mMFormVerifyCodeInputView2 = this.ixR;
        if (mMFormVerifyCodeInputView2 != null) {
            mMFormVerifyCodeInputView2.setSendSmsBtnClickListener(new b(this));
        }
        mMFormVerifyCodeInputView2 = this.ixR;
        if (mMFormVerifyCodeInputView2 != null) {
            mMFormVerifyCodeInputView2.addTextChangedListener(new c(this));
        }
        this.ixS = (MMFormInputView) findViewById(R.id.sc);
        MMFormInputView mMFormInputView = this.ixS;
        if (mMFormInputView != null) {
            mMFormInputView.setInputType(3);
        }
        MMFormInputView mMFormInputView2 = this.ixS;
        if (mMFormInputView2 != null) {
            mMFormInputView2.addTextChangedListener(new d(this));
        }
        Button button = this.ixU;
        if (button != null) {
            button.setOnClickListener(new e(this));
            AppMethodBeat.o(134837);
            return;
        }
        AppMethodBeat.o(134837);
    }

    public final int getLayoutId() {
        return R.layout.cn;
    }

    public final void onResume() {
        AppMethodBeat.i(134838);
        super.onResume();
        setMMTitle((int) R.string.vs);
        dyb();
        setBackBtn(new f(this));
        AppMethodBeat.o(134838);
    }

    public final void onDestroy() {
        AppMethodBeat.i(134839);
        super.onDestroy();
        MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.ixR;
        if (mMFormVerifyCodeInputView != null) {
            mMFormVerifyCodeInputView.reset();
            AppMethodBeat.o(134839);
            return;
        }
        AppMethodBeat.o(134839);
    }

    public static final /* synthetic */ void a(PhoneNumberAddUI phoneNumberAddUI) {
        AppMethodBeat.i(134841);
        ab.i("MicroMsg.PhoneNumberAddUI", "sendSms appId:%s, mobile:%s", phoneNumberAddUI.appId, phoneNumberAddUI.cFl);
        MMFormVerifyCodeInputView mMFormVerifyCodeInputView = phoneNumberAddUI.ixR;
        if (mMFormVerifyCodeInputView != null) {
            mMFormVerifyCodeInputView.dzH();
        }
        Context dxU = phoneNumberAddUI.dxU();
        phoneNumberAddUI.getString(R.string.tz);
        p b = com.tencent.mm.ui.base.h.b(dxU, phoneNumberAddUI.getString(R.string.wa), true, null);
        be beVar = phoneNumberAddUI.ixV;
        if (beVar != null) {
            be beVar2 = phoneNumberAddUI.ixV;
            Long valueOf = beVar2 != null ? Long.valueOf(beVar2.GG()) : null;
            if (valueOf == null) {
                a.f.b.j.dWJ();
            }
            beVar.cW(valueOf.longValue() + 1);
        }
        new d(phoneNumberAddUI.appId, phoneNumberAddUI.cFl).acy().h(new g(phoneNumberAddUI)).b((com.tencent.mm.vending.c.a) new h(b));
        AppMethodBeat.o(134841);
    }

    public static final /* synthetic */ void b(PhoneNumberAddUI phoneNumberAddUI) {
        be beVar;
        Long valueOf;
        Boolean valueOf2;
        Object text;
        AppMethodBeat.i(134842);
        be beVar2 = phoneNumberAddUI.ixV;
        if (beVar2 != null) {
            beVar = phoneNumberAddUI.ixV;
            valueOf = beVar != null ? Long.valueOf(beVar.GJ()) : null;
            if (valueOf == null) {
                a.f.b.j.dWJ();
            }
            beVar2.cZ(valueOf.longValue() + 1);
        }
        MMSwitchBtn mMSwitchBtn = phoneNumberAddUI.ixT;
        if (mMSwitchBtn != null) {
            valueOf2 = Boolean.valueOf(mMSwitchBtn.dKD());
        } else {
            valueOf2 = null;
        }
        if (valueOf2 == null) {
            a.f.b.j.dWJ();
        }
        if (valueOf2.booleanValue()) {
            beVar2 = phoneNumberAddUI.ixV;
            if (beVar2 != null) {
                beVar = phoneNumberAddUI.ixV;
                if (beVar != null) {
                    valueOf = Long.valueOf(beVar.GM());
                } else {
                    valueOf = null;
                }
                if (valueOf == null) {
                    a.f.b.j.dWJ();
                }
                beVar2.dc(valueOf.longValue() + 1);
            }
        } else {
            beVar2 = phoneNumberAddUI.ixV;
            if (beVar2 != null) {
                beVar = phoneNumberAddUI.ixV;
                valueOf = beVar != null ? Long.valueOf(beVar.GN()) : null;
                if (valueOf == null) {
                    a.f.b.j.dWJ();
                }
                beVar2.dd(valueOf.longValue() + 1);
            }
        }
        MMFormInputView mMFormInputView = phoneNumberAddUI.ixS;
        if (mMFormInputView != null) {
            text = mMFormInputView.getText();
        } else {
            text = null;
        }
        ab.i("MicroMsg.PhoneNumberAddUI", "verifyCode appId:%s, mobile:%s code:%s", phoneNumberAddUI.appId, phoneNumberAddUI.cFl, String.valueOf(text));
        Context dxU = phoneNumberAddUI.dxU();
        phoneNumberAddUI.getString(R.string.tz);
        new a(phoneNumberAddUI.appId, phoneNumberAddUI.cFl, r2).acy().h(new j(phoneNumberAddUI)).b((com.tencent.mm.vending.c.a) new k(com.tencent.mm.ui.base.h.b(dxU, phoneNumberAddUI.getString(R.string.wc), true, null)));
        AppMethodBeat.o(134842);
    }

    public static final /* synthetic */ void a(PhoneNumberAddUI phoneNumberAddUI, String str) {
        AppMethodBeat.i(134843);
        com.tencent.mm.ui.base.h.a((Context) phoneNumberAddUI.dxU(), str, "", true, (DialogInterface.OnClickListener) i.iyd);
        AppMethodBeat.o(134843);
    }
}
