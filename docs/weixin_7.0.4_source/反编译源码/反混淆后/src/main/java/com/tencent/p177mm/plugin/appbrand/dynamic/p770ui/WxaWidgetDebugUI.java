package com.tencent.p177mm.plugin.appbrand.dynamic.p770ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C9687e;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.plugin.appbrand.dynamic.html.C19188a;
import com.tencent.p177mm.plugin.appbrand.dynamic.html.C33162b;
import com.tencent.p177mm.plugin.appbrand.dynamic.html.CustomURLSpan;
import com.tencent.p177mm.plugin.appbrand.dynamic.widget.C33173b;
import com.tencent.p177mm.plugin.appbrand.widget.C33638l;
import com.tencent.p177mm.plugin.appbrand.widget.C33639m;
import com.tencent.p177mm.plugin.appbrand.widget.p1473a.C33574a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI */
public class WxaWidgetDebugUI extends MMActivity {
    String appId;
    int cBc;
    int gVu;
    MMSwitchBtn hpc;
    C33638l hpd;
    /* renamed from: id */
    String f4348id;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI$1 */
    class C192011 implements OnMenuItemClickListener {
        C192011() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(11010);
            WxaWidgetDebugUI.this.finish();
            AppMethodBeat.m2505o(11010);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI$2 */
    class C192022 implements C30795a {
        C192022() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_ERROR_ALLADDRESS_FAILED);
            WxaWidgetDebugUI.this.hpd.field_openDebug = z;
            C33639m auR = ((C33574a) C1720g.m3528K(C33574a.class)).auR();
            C33638l c33638l = WxaWidgetDebugUI.this.hpd;
            if (!(c33638l == null || C5046bo.isNullOrNil(c33638l.field_appId))) {
                c33638l.field_appIdHash = c33638l.field_appId.hashCode();
                auR.mo10099a(c33638l);
            }
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_ERROR_ALLADDRESS_FAILED);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI$3 */
    class C192033 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI$3$1 */
        class C192001 implements Runnable {
            C192001() {
            }

            public final void run() {
                AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_ERROR_NET_DISCONNECT);
                Toast.makeText(WxaWidgetDebugUI.this.mController.ylL, C25738R.string.g3m, 1).show();
                AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_ERROR_NET_DISCONNECT);
            }
        }

        C192033() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_DATA);
            ((C9687e) C1720g.m3528K(C9687e.class)).aby().restart();
            C26006a.m41507r(new C192001(), 1000);
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_DATA);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI$4 */
    class C192044 implements OnClickListener {
        C192044() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(11014);
            Intent intent = new Intent(WxaWidgetDebugUI.this.mController.ylL, WxaWidgetSettingsUI.class);
            intent.putExtra("app_id", WxaWidgetDebugUI.this.appId);
            intent.putExtra("pkg_type", WxaWidgetDebugUI.this.cBc);
            intent.putExtra("pkg_version", WxaWidgetDebugUI.this.gVu);
            WxaWidgetDebugUI.this.startActivity(intent);
            AppMethodBeat.m2505o(11014);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        String format;
        AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_NETWORK);
        super.onCreate(bundle);
        setBackBtn(new C192011());
        Object[] objArr = new Object[1];
        if (((C9687e) C1720g.m3528K(C9687e.class)).abz().abF()) {
            format = String.format("(%s)", new Object[]{C33173b.aAm()});
        } else {
            format = "";
        }
        objArr[0] = format;
        setMMTitle(getString(C25738R.string.g3d, objArr));
        Intent intent = getIntent();
        this.f4348id = intent.getStringExtra("id");
        this.appId = intent.getStringExtra("app_id");
        this.cBc = intent.getIntExtra("pkg_type", 0);
        this.gVu = intent.getIntExtra("pkg_version", 0);
        setMMSubTitle(String.format("(%s)", new Object[]{this.f4348id}));
        this.hpc = (MMSwitchBtn) findViewById(2131829240);
        this.hpd = ((C33574a) C1720g.m3528K(C33574a.class)).auR().mo54196Ev(this.appId);
        if (this.hpd == null) {
            this.hpd = new C33638l();
            this.hpd.field_appId = this.appId;
        }
        this.hpc.setCheck(this.hpd.field_openDebug);
        this.hpc.setSwitchListener(new C192022());
        TextView textView = (TextView) findViewById(2131829241);
        CharSequence fromHtml = Html.fromHtml(getString(C25738R.string.g3j), new C19188a(), new C33162b());
        if (fromHtml instanceof Spannable) {
            Spannable spannable = (Spannable) fromHtml;
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, fromHtml.length(), URLSpan.class);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
            for (Object obj : uRLSpanArr) {
                spannableStringBuilder.removeSpan(obj);
                spannableStringBuilder.setSpan(new CustomURLSpan(obj.getURL()), spannable.getSpanStart(obj), spannable.getSpanEnd(obj), 34);
            }
            fromHtml = spannableStringBuilder;
        }
        textView.setText(fromHtml);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        findViewById(2131827404).setOnClickListener(new C192033());
        View findViewById = findViewById(2131829242);
        if (((C9687e) C1720g.m3528K(C9687e.class)).abz().abF()) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new C192044());
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_NETWORK);
            return;
        }
        findViewById.setVisibility(8);
        AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_NETWORK);
    }

    public final int getLayoutId() {
        return 2130971249;
    }
}
