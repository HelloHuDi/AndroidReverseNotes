package com.tencent.p177mm.plugin.appbrand.phonenumber;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p230g.p232b.p233a.C26275be;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MMFormInputView;
import com.tencent.p177mm.p612ui.base.MMFormVerifyCodeInputView;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.plugin.appbrand.phonenumber.C27268g.C27269a;
import com.tencent.p177mm.plugin.appbrand.phonenumber.C45670j.C45669a;
import com.tencent.p177mm.protocal.protobuf.C44165se;
import com.tencent.p177mm.protocal.protobuf.bwy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;
import p1439b.p1440a.p1441a.p1442a.p1443a.p1444a.p1445a.p1446a.C31900a;

@C5271a(3)
@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020+H\u0014J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020-H\u0014J\b\u00101\u001a\u00020-H\u0014J\b\u00102\u001a\u00020-H\u0002J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\u0004H\u0002J\b\u00105\u001a\u00020-H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00067"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "finishBtn", "Landroid/widget/Button;", "getFinishBtn", "()Landroid/widget/Button;", "setFinishBtn", "(Landroid/widget/Button;)V", "formInputView", "Lcom/tencent/mm/ui/base/MMFormVerifyCodeInputView;", "getFormInputView", "()Lcom/tencent/mm/ui/base/MMFormVerifyCodeInputView;", "setFormInputView", "(Lcom/tencent/mm/ui/base/MMFormVerifyCodeInputView;)V", "formVerifyCodeInputView", "Lcom/tencent/mm/ui/base/MMFormInputView;", "getFormVerifyCodeInputView", "()Lcom/tencent/mm/ui/base/MMFormInputView;", "setFormVerifyCodeInputView", "(Lcom/tencent/mm/ui/base/MMFormInputView;)V", "mobile", "getMobile", "setMobile", "report", "Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "getReport", "()Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "setReport", "(Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;)V", "switchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "getSwitchBtn", "()Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "setSwitchBtn", "(Lcom/tencent/mm/ui/widget/MMSwitchBtn;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "sendSms", "showErrorTips", "errMsg", "verifyCode", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI */
public final class PhoneNumberAddUI extends MMActivity {
    public static final C42657a ixW = new C42657a();
    String appId = "";
    String cFl = "";
    MMFormVerifyCodeInputView ixR;
    MMFormInputView ixS;
    MMSwitchBtn ixT;
    Button ixU;
    C26275be ixV;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, dWq = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "call", "(Lkotlin/Unit;)V"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$k */
    static final class C10690k<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ C44275p iyc;

        C10690k(C44275p c44275p) {
            this.iyc = c44275p;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(134835);
            this.iyc.dismiss();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134835);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI$onCreate$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$c */
    public static final class C19664c implements TextWatcher {
        final /* synthetic */ PhoneNumberAddUI ixX;

        C19664c(PhoneNumberAddUI phoneNumberAddUI) {
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
            AppMethodBeat.m2504i(134818);
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
                AppMethodBeat.m2505o(134818);
                return;
            }
            AppMethodBeat.m2505o(134818);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI$onCreate$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$d */
    public static final class C19665d implements TextWatcher {
        final /* synthetic */ PhoneNumberAddUI ixX;

        C19665d(PhoneNumberAddUI phoneNumberAddUI) {
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
            AppMethodBeat.m2504i(134819);
            C25052j.m39376p(charSequence, "s");
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
                AppMethodBeat.m2505o(134819);
                return;
            }
            AppMethodBeat.m2505o(134819);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(134820);
            C25052j.m39376p(charSequence, "s");
            AppMethodBeat.m2505o(134820);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(134821);
            C25052j.m39376p(editable, "s");
            AppMethodBeat.m2505o(134821);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$b */
    static final class C27263b implements OnClickListener {
        final /* synthetic */ PhoneNumberAddUI ixX;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$b$1 */
        static final class C106881 implements DialogInterface.OnClickListener {
            final /* synthetic */ C27263b ixY;

            C106881(C27263b c27263b) {
                this.ixY = c27263b;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(134815);
                PhoneNumberAddUI.m75530a(this.ixY.ixX);
                AppMethodBeat.m2505o(134815);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$b$2 */
        static final class C272622 implements DialogInterface.OnClickListener {
            public static final C272622 ixZ = new C272622();

            static {
                AppMethodBeat.m2504i(134816);
                AppMethodBeat.m2505o(134816);
            }

            C272622() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C27263b(PhoneNumberAddUI phoneNumberAddUI) {
            this.ixX = phoneNumberAddUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(134817);
            PhoneNumberAddUI phoneNumberAddUI = this.ixX;
            MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.ixX.ixR;
            phoneNumberAddUI.mo68083iN(String.valueOf(mMFormVerifyCodeInputView != null ? mMFormVerifyCodeInputView.getText() : null));
            if (C5046bo.isNullOrNil(this.ixX.cFl)) {
                C30379h.m48467g(this.ixX, C25738R.string.f9301w0, C25738R.string.f9302w1);
                C4990ab.m7413e("MicroMsg.PhoneNumberAddUI", "mobile:%s isn't phone", this.ixX.cFl);
                AppMethodBeat.m2505o(134817);
                return;
            }
            C30379h.m48466d(this.ixX, this.ixX.getString(C25738R.string.f8932jt) + this.ixX.cFl, this.ixX.getString(C25738R.string.f8929jo), this.ixX.getString(C25738R.string.f9187s6), this.ixX.getString(C25738R.string.f9076or), new C106881(this), C272622.ixZ);
            AppMethodBeat.m2505o(134817);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$e */
    static final class C27264e implements OnClickListener {
        final /* synthetic */ PhoneNumberAddUI ixX;

        C27264e(PhoneNumberAddUI phoneNumberAddUI) {
            this.ixX = phoneNumberAddUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(134822);
            PhoneNumberAddUI phoneNumberAddUI = this.ixX;
            MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.ixX.ixR;
            phoneNumberAddUI.mo68083iN(String.valueOf(mMFormVerifyCodeInputView != null ? mMFormVerifyCodeInputView.getText() : null));
            if (!C5046bo.isNullOrNil(this.ixX.cFl)) {
                PhoneNumberAddUI.m75532b(this.ixX);
            }
            AppMethodBeat.m2505o(134822);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, dWq = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "call", "(Lkotlin/Unit;)V"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$h */
    static final class C38489h<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ C44275p iyc;

        C38489h(C44275p c44275p) {
            this.iyc = c44275p;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(134827);
            this.iyc.dismiss();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134827);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI$Companion;", "", "()V", "APPID", "", "TAG", "addPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$a */
    public static final class C42657a {
        private C42657a() {
        }

        public /* synthetic */ C42657a(byte b) {
            this();
        }

        /* renamed from: X */
        public static void m75529X(Context context, String str) {
            AppMethodBeat.m2504i(134814);
            C25052j.m39376p(context, "context");
            C25052j.m39376p(str, "appId");
            Intent intent = new Intent(context, PhoneNumberAddUI.class);
            intent.putExtra("APPID", str);
            context.startActivity(intent);
            AppMethodBeat.m2505o(134814);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$f */
    static final class C42658f implements OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberAddUI ixX;

        C42658f(PhoneNumberAddUI phoneNumberAddUI) {
            this.ixX = phoneNumberAddUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(134823);
            this.ixX.finish();
            AppMethodBeat.m2505o(134823);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$j */
    static final class C42660j<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ PhoneNumberAddUI ixX;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$j$2 */
        static final class C426612 implements Runnable {
            final /* synthetic */ C42660j iye;

            C426612(C42660j c42660j) {
                this.iye = c42660j;
            }

            public final void run() {
                AppMethodBeat.m2504i(134833);
                C26275be c26275be = this.iye.ixX.ixV;
                if (c26275be != null) {
                    C26275be c26275be2 = this.iye.ixX.ixV;
                    Long valueOf = c26275be2 != null ? Long.valueOf(c26275be2.mo43980GL()) : null;
                    if (valueOf == null) {
                        C25052j.dWJ();
                    }
                    c26275be.mo44009db(valueOf.longValue() + 1);
                }
                PhoneNumberAddUI phoneNumberAddUI = this.iye.ixX;
                String string = this.iye.ixX.dxU().getString(C25738R.string.f8915ja);
                C25052j.m39375o(string, "context.getString(R.stri…_number_verify_code_fail)");
                PhoneNumberAddUI.m75531a(phoneNumberAddUI, string);
                AppMethodBeat.m2505o(134833);
            }
        }

        C42660j(PhoneNumberAddUI phoneNumberAddUI) {
            this.ixX = phoneNumberAddUI;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(134834);
            final C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.PhoneNumberAddUI", "verifyCode errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C4990ab.m7417i("MicroMsg.PhoneNumberAddUI", "checkVerifyCode:%d", Integer.valueOf(((C44165se) c37441a.fsy).status));
                C5004al.m7441d(new Runnable(this) {
                    final /* synthetic */ C42660j iye;

                    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
                    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$j$1$2 */
                    static final class C106892 implements DialogInterface.OnClickListener {
                        public static final C106892 iyj = new C106892();

                        static {
                            AppMethodBeat.m2504i(134831);
                            AppMethodBeat.m2505o(134831);
                        }

                        C106892() {
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }

                    public final void run() {
                        Long l = null;
                        AppMethodBeat.m2504i(134832);
                        int i = ((C44165se) c37441a.fsy).status;
                        C27269a c27269a = C27268g.ixv;
                        C26275be c26275be;
                        C26275be c26275be2;
                        Long valueOf;
                        if (i == C27268g.ixn) {
                            Boolean valueOf2;
                            c26275be = this.iye.ixX.ixV;
                            if (c26275be != null) {
                                c26275be2 = this.iye.ixX.ixV;
                                valueOf = c26275be2 != null ? Long.valueOf(c26275be2.mo43979GK()) : null;
                                if (valueOf == null) {
                                    C25052j.dWJ();
                                }
                                c26275be.mo44008da(valueOf.longValue() + 1);
                            }
                            final String str = ((C44165se) c37441a.fsy).ixJ;
                            final String str2 = ((C44165se) c37441a.fsy).biC;
                            final String str3 = ((C44165se) c37441a.fsy).vZw;
                            MMSwitchBtn mMSwitchBtn = this.iye.ixX.ixT;
                            if (mMSwitchBtn != null) {
                                valueOf2 = Boolean.valueOf(mMSwitchBtn.dKD());
                            }
                            if (valueOf2 == null) {
                                C25052j.dWJ();
                            }
                            if (valueOf2.booleanValue()) {
                                new C10698f(this.iye.ixX.appId, this.iye.ixX.cFl, 0).acy().mo60492h(new C5681a<_Ret, _Var>(this) {
                                    final /* synthetic */ C426591 iyf;

                                    public final /* synthetic */ Object call(Object obj) {
                                        AppMethodBeat.m2504i(134830);
                                        C37441a c37441a = (C37441a) obj;
                                        C4990ab.m7417i("MicroMsg.PhoneNumberAddUI", "updateUserPhone errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
                                        if (c37441a.errType == 0 && c37441a.errCode == 0) {
                                            C45669a c45669a = C45670j.ixQ;
                                            String str = this.iyf.iye.ixX.cFl;
                                            String str2 = str3;
                                            C25052j.m39375o(str2, "showMobile");
                                            String str3 = str;
                                            C25052j.m39375o(str3, "encryptedData");
                                            String str4 = str2;
                                            C25052j.m39375o(str4, "iv");
                                            c45669a.mo73459a(new PhoneItem(str, str2, str3, str4));
                                            this.iyf.iye.ixX.finish();
                                        }
                                        C37091y c37091y = C37091y.AUy;
                                        AppMethodBeat.m2505o(134830);
                                        return c37091y;
                                    }
                                });
                                AppMethodBeat.m2505o(134832);
                                return;
                            }
                            C45669a c45669a = C45670j.ixQ;
                            String str4 = this.iye.ixX.cFl;
                            C25052j.m39375o(str3, "showMobile");
                            C25052j.m39375o(str, "encryptedData");
                            C25052j.m39375o(str2, "iv");
                            c45669a.mo73459a(new PhoneItem(str4, str3, str, str2));
                            this.iye.ixX.finish();
                            AppMethodBeat.m2505o(134832);
                            return;
                        }
                        c27269a = C27268g.ixv;
                        PhoneNumberAddUI phoneNumberAddUI;
                        String string;
                        if (i == C27268g.ixo) {
                            c26275be2 = this.iye.ixX.ixV;
                            if (c26275be2 != null) {
                                c26275be = this.iye.ixX.ixV;
                                if (c26275be != null) {
                                    l = Long.valueOf(c26275be.mo43980GL());
                                }
                                if (l == null) {
                                    C25052j.dWJ();
                                }
                                c26275be2.mo44009db(l.longValue() + 1);
                            }
                            phoneNumberAddUI = this.iye.ixX;
                            string = this.iye.ixX.dxU().getString(C25738R.string.f8910j6);
                            C25052j.m39375o(string, "context.getString(R.stri…end_verify_code_frequent)");
                            PhoneNumberAddUI.m75531a(phoneNumberAddUI, string);
                            AppMethodBeat.m2505o(134832);
                            return;
                        }
                        c27269a = C27268g.ixv;
                        if (i == C27268g.ixq) {
                            c26275be2 = this.iye.ixX.ixV;
                            if (c26275be2 != null) {
                                c26275be = this.iye.ixX.ixV;
                                if (c26275be != null) {
                                    l = Long.valueOf(c26275be.mo43980GL());
                                }
                                if (l == null) {
                                    C25052j.dWJ();
                                }
                                c26275be2.mo44009db(l.longValue() + 1);
                            }
                            C30379h.m48448a((Context) this.iye.ixX.dxU(), this.iye.ixX.dxU().getString(C25738R.string.f8912j8), "", false, (DialogInterface.OnClickListener) C106892.iyj);
                            AppMethodBeat.m2505o(134832);
                            return;
                        }
                        c26275be = this.iye.ixX.ixV;
                        if (c26275be != null) {
                            c26275be2 = this.iye.ixX.ixV;
                            if (c26275be2 != null) {
                                valueOf = Long.valueOf(c26275be2.mo43980GL());
                            } else {
                                valueOf = null;
                            }
                            if (valueOf == null) {
                                C25052j.dWJ();
                            }
                            c26275be.mo44009db(valueOf.longValue() + 1);
                        }
                        phoneNumberAddUI = this.iye.ixX;
                        string = this.iye.ixX.dxU().getString(C25738R.string.f8915ja);
                        C25052j.m39375o(string, "context.getString(R.stri…_number_verify_code_fail)");
                        PhoneNumberAddUI.m75531a(phoneNumberAddUI, string);
                        AppMethodBeat.m2505o(134832);
                    }
                });
            } else {
                C5004al.m7441d(new C426612(this));
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134834);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$g */
    static final class C42662g<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ PhoneNumberAddUI ixX;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$g$2 */
        static final class C24322 implements Runnable {
            final /* synthetic */ C42662g iya;

            C24322(C42662g c42662g) {
                this.iya = c42662g;
            }

            public final void run() {
                AppMethodBeat.m2504i(134825);
                C26275be c26275be = this.iya.ixX.ixV;
                if (c26275be != null) {
                    C26275be c26275be2 = this.iya.ixX.ixV;
                    Long valueOf = c26275be2 != null ? Long.valueOf(c26275be2.mo43977GI()) : null;
                    if (valueOf == null) {
                        C25052j.dWJ();
                    }
                    c26275be.mo44006cY(valueOf.longValue() + 1);
                }
                PhoneNumberAddUI phoneNumberAddUI = this.iya.ixX;
                String string = this.iya.ixX.dxU().getString(C25738R.string.f8909j5);
                C25052j.m39375o(string, "context.getString(R.stri…er_send_verify_code_fail)");
                PhoneNumberAddUI.m75531a(phoneNumberAddUI, string);
                AppMethodBeat.m2505o(134825);
            }
        }

        C42662g(PhoneNumberAddUI phoneNumberAddUI) {
            this.ixX = phoneNumberAddUI;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(134826);
            final C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.PhoneNumberAddUI", "sendSms errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C4990ab.m7417i("MicroMsg.PhoneNumberAddUI", "sendSms:%d", Integer.valueOf(((bwy) c37441a.fsy).status));
                C5004al.m7441d(new Runnable(this) {
                    final /* synthetic */ C42662g iya;

                    public final void run() {
                        Long l = null;
                        AppMethodBeat.m2504i(134824);
                        int i = ((bwy) c37441a.fsy).status;
                        C27269a c27269a = C27268g.ixv;
                        C26275be c26275be;
                        C26275be c26275be2;
                        if (i == C27268g.ixh) {
                            c26275be = this.iya.ixX.ixV;
                            if (c26275be != null) {
                                c26275be2 = this.iya.ixX.ixV;
                                if (c26275be2 != null) {
                                    l = Long.valueOf(c26275be2.mo43976GH());
                                }
                                if (l == null) {
                                    C25052j.dWJ();
                                }
                                c26275be.mo44005cX(l.longValue() + 1);
                                AppMethodBeat.m2505o(134824);
                                return;
                            }
                            AppMethodBeat.m2505o(134824);
                            return;
                        }
                        c27269a = C27268g.ixv;
                        PhoneNumberAddUI phoneNumberAddUI;
                        String string;
                        if (i == C27268g.ixi) {
                            c26275be = this.iya.ixX.ixV;
                            if (c26275be != null) {
                                c26275be2 = this.iya.ixX.ixV;
                                if (c26275be2 != null) {
                                    l = Long.valueOf(c26275be2.mo43977GI());
                                }
                                if (l == null) {
                                    C25052j.dWJ();
                                }
                                c26275be.mo44006cY(l.longValue() + 1);
                            }
                            phoneNumberAddUI = this.iya.ixX;
                            string = this.iya.ixX.dxU().getString(C25738R.string.f8909j5);
                            C25052j.m39375o(string, "context.getString(R.stri…er_send_verify_code_fail)");
                            PhoneNumberAddUI.m75531a(phoneNumberAddUI, string);
                            AppMethodBeat.m2505o(134824);
                            return;
                        }
                        c27269a = C27268g.ixv;
                        if (i == C27268g.ixj) {
                            c26275be = this.iya.ixX.ixV;
                            if (c26275be != null) {
                                c26275be2 = this.iya.ixX.ixV;
                                if (c26275be2 != null) {
                                    l = Long.valueOf(c26275be2.mo43977GI());
                                }
                                if (l == null) {
                                    C25052j.dWJ();
                                }
                                c26275be.mo44006cY(l.longValue() + 1);
                            }
                            phoneNumberAddUI = this.iya.ixX;
                            string = this.iya.ixX.dxU().getString(C25738R.string.f8910j6);
                            C25052j.m39375o(string, "context.getString(R.stri…end_verify_code_frequent)");
                            PhoneNumberAddUI.m75531a(phoneNumberAddUI, string);
                            AppMethodBeat.m2505o(134824);
                            return;
                        }
                        c26275be2 = this.iya.ixX.ixV;
                        if (c26275be2 != null) {
                            Long valueOf;
                            c26275be = this.iya.ixX.ixV;
                            if (c26275be != null) {
                                valueOf = Long.valueOf(c26275be.mo43977GI());
                            } else {
                                valueOf = null;
                            }
                            if (valueOf == null) {
                                C25052j.dWJ();
                            }
                            c26275be2.mo44006cY(valueOf.longValue() + 1);
                        }
                        phoneNumberAddUI = this.iya.ixX;
                        string = this.iya.ixX.dxU().getString(C25738R.string.f8909j5);
                        C25052j.m39375o(string, "context.getString(R.stri…er_send_verify_code_fail)");
                        PhoneNumberAddUI.m75531a(phoneNumberAddUI, string);
                        AppMethodBeat.m2505o(134824);
                    }
                });
            } else {
                C5004al.m7441d(new C24322(this));
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134826);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI$i */
    static final class C42663i implements DialogInterface.OnClickListener {
        public static final C42663i iyd = new C42663i();

        static {
            AppMethodBeat.m2504i(134829);
            AppMethodBeat.m2505o(134829);
        }

        C42663i() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(134828);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(134828);
        }
    }

    static {
        AppMethodBeat.m2504i(134840);
        AppMethodBeat.m2505o(134840);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: iN */
    public final void mo68083iN(String str) {
        AppMethodBeat.m2504i(134836);
        C25052j.m39376p(str, "<set-?>");
        this.cFl = str;
        AppMethodBeat.m2505o(134836);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(134837);
        super.onCreate(bundle);
        mo17446xE(-1);
        getContentView().setBackgroundColor(dyd());
        String stringExtra = getIntent().getStringExtra("APPID");
        C25052j.m39375o(stringExtra, "intent.getStringExtra(APPID)");
        this.appId = stringExtra;
        C4990ab.m7417i("MicroMsg.PhoneNumberAddUI", "onCreate() appId:%s", this.appId);
        this.ixV = C31900a.BTg.awB(this.appId);
        this.ixT = (MMSwitchBtn) findViewById(2131821250);
        this.ixU = (Button) findViewById(2131821251);
        this.ixR = (MMFormVerifyCodeInputView) findViewById(2131821248);
        MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.ixR;
        if (mMFormVerifyCodeInputView != null) {
            mMFormVerifyCodeInputView.setInputType(3);
        }
        MMFormVerifyCodeInputView mMFormVerifyCodeInputView2 = this.ixR;
        if (mMFormVerifyCodeInputView2 != null) {
            mMFormVerifyCodeInputView2.setSendSmsBtnClickListener(new C27263b(this));
        }
        mMFormVerifyCodeInputView2 = this.ixR;
        if (mMFormVerifyCodeInputView2 != null) {
            mMFormVerifyCodeInputView2.addTextChangedListener(new C19664c(this));
        }
        this.ixS = (MMFormInputView) findViewById(2131821249);
        MMFormInputView mMFormInputView = this.ixS;
        if (mMFormInputView != null) {
            mMFormInputView.setInputType(3);
        }
        MMFormInputView mMFormInputView2 = this.ixS;
        if (mMFormInputView2 != null) {
            mMFormInputView2.addTextChangedListener(new C19665d(this));
        }
        Button button = this.ixU;
        if (button != null) {
            button.setOnClickListener(new C27264e(this));
            AppMethodBeat.m2505o(134837);
            return;
        }
        AppMethodBeat.m2505o(134837);
    }

    public final int getLayoutId() {
        return 2130968700;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(134838);
        super.onResume();
        setMMTitle((int) C25738R.string.f9294vs);
        dyb();
        setBackBtn(new C42658f(this));
        AppMethodBeat.m2505o(134838);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(134839);
        super.onDestroy();
        MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.ixR;
        if (mMFormVerifyCodeInputView != null) {
            mMFormVerifyCodeInputView.reset();
            AppMethodBeat.m2505o(134839);
            return;
        }
        AppMethodBeat.m2505o(134839);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m75530a(PhoneNumberAddUI phoneNumberAddUI) {
        AppMethodBeat.m2504i(134841);
        C4990ab.m7417i("MicroMsg.PhoneNumberAddUI", "sendSms appId:%s, mobile:%s", phoneNumberAddUI.appId, phoneNumberAddUI.cFl);
        MMFormVerifyCodeInputView mMFormVerifyCodeInputView = phoneNumberAddUI.ixR;
        if (mMFormVerifyCodeInputView != null) {
            mMFormVerifyCodeInputView.dzH();
        }
        Context dxU = phoneNumberAddUI.dxU();
        phoneNumberAddUI.getString(C25738R.string.f9238tz);
        C44275p b = C30379h.m48458b(dxU, phoneNumberAddUI.getString(C25738R.string.f9311wa), true, null);
        C26275be c26275be = phoneNumberAddUI.ixV;
        if (c26275be != null) {
            C26275be c26275be2 = phoneNumberAddUI.ixV;
            Long valueOf = c26275be2 != null ? Long.valueOf(c26275be2.mo43975GG()) : null;
            if (valueOf == null) {
                C25052j.dWJ();
            }
            c26275be.mo44004cW(valueOf.longValue() + 1);
        }
        new C41250d(phoneNumberAddUI.appId, phoneNumberAddUI.cFl).acy().mo60492h(new C42662g(phoneNumberAddUI)).mo60487b((C5681a) new C38489h(b));
        AppMethodBeat.m2505o(134841);
    }

    /* renamed from: b */
    public static final /* synthetic */ void m75532b(PhoneNumberAddUI phoneNumberAddUI) {
        C26275be c26275be;
        Long valueOf;
        Boolean valueOf2;
        Object text;
        AppMethodBeat.m2504i(134842);
        C26275be c26275be2 = phoneNumberAddUI.ixV;
        if (c26275be2 != null) {
            c26275be = phoneNumberAddUI.ixV;
            valueOf = c26275be != null ? Long.valueOf(c26275be.mo43978GJ()) : null;
            if (valueOf == null) {
                C25052j.dWJ();
            }
            c26275be2.mo44007cZ(valueOf.longValue() + 1);
        }
        MMSwitchBtn mMSwitchBtn = phoneNumberAddUI.ixT;
        if (mMSwitchBtn != null) {
            valueOf2 = Boolean.valueOf(mMSwitchBtn.dKD());
        } else {
            valueOf2 = null;
        }
        if (valueOf2 == null) {
            C25052j.dWJ();
        }
        if (valueOf2.booleanValue()) {
            c26275be2 = phoneNumberAddUI.ixV;
            if (c26275be2 != null) {
                c26275be = phoneNumberAddUI.ixV;
                if (c26275be != null) {
                    valueOf = Long.valueOf(c26275be.mo43981GM());
                } else {
                    valueOf = null;
                }
                if (valueOf == null) {
                    C25052j.dWJ();
                }
                c26275be2.mo44010dc(valueOf.longValue() + 1);
            }
        } else {
            c26275be2 = phoneNumberAddUI.ixV;
            if (c26275be2 != null) {
                c26275be = phoneNumberAddUI.ixV;
                valueOf = c26275be != null ? Long.valueOf(c26275be.mo43982GN()) : null;
                if (valueOf == null) {
                    C25052j.dWJ();
                }
                c26275be2.mo44011dd(valueOf.longValue() + 1);
            }
        }
        MMFormInputView mMFormInputView = phoneNumberAddUI.ixS;
        if (mMFormInputView != null) {
            text = mMFormInputView.getText();
        } else {
            text = null;
        }
        C4990ab.m7417i("MicroMsg.PhoneNumberAddUI", "verifyCode appId:%s, mobile:%s code:%s", phoneNumberAddUI.appId, phoneNumberAddUI.cFl, String.valueOf(text));
        Context dxU = phoneNumberAddUI.dxU();
        phoneNumberAddUI.getString(C25738R.string.f9238tz);
        new C45667a(phoneNumberAddUI.appId, phoneNumberAddUI.cFl, r2).acy().mo60492h(new C42660j(phoneNumberAddUI)).mo60487b((C5681a) new C10690k(C30379h.m48458b(dxU, phoneNumberAddUI.getString(C25738R.string.f9313wc), true, null)));
        AppMethodBeat.m2505o(134842);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m75531a(PhoneNumberAddUI phoneNumberAddUI, String str) {
        AppMethodBeat.m2504i(134843);
        C30379h.m48448a((Context) phoneNumberAddUI.dxU(), str, "", true, (DialogInterface.OnClickListener) C42663i.iyd);
        AppMethodBeat.m2505o(134843);
    }
}
