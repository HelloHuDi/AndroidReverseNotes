package com.tencent.mm.plugin.appbrand.dynamic.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.dynamic.html.CustomURLSpan;
import com.tencent.mm.plugin.appbrand.dynamic.widget.b;
import com.tencent.mm.plugin.appbrand.widget.a.a;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetDebugUI extends MMActivity {
    String appId;
    int cBc;
    int gVu;
    MMSwitchBtn hpc;
    l hpd;
    String id;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        String format;
        AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_NETWORK);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(11010);
                WxaWidgetDebugUI.this.finish();
                AppMethodBeat.o(11010);
                return false;
            }
        });
        Object[] objArr = new Object[1];
        if (((e) g.K(e.class)).abz().abF()) {
            format = String.format("(%s)", new Object[]{b.aAm()});
        } else {
            format = "";
        }
        objArr[0] = format;
        setMMTitle(getString(R.string.g3d, objArr));
        Intent intent = getIntent();
        this.id = intent.getStringExtra("id");
        this.appId = intent.getStringExtra("app_id");
        this.cBc = intent.getIntExtra("pkg_type", 0);
        this.gVu = intent.getIntExtra("pkg_version", 0);
        setMMSubTitle(String.format("(%s)", new Object[]{this.id}));
        this.hpc = (MMSwitchBtn) findViewById(R.id.fm2);
        this.hpd = ((a) g.K(a.class)).auR().Ev(this.appId);
        if (this.hpd == null) {
            this.hpd = new l();
            this.hpd.field_appId = this.appId;
        }
        this.hpc.setCheck(this.hpd.field_openDebug);
        this.hpc.setSwitchListener(new MMSwitchBtn.a() {
            public final void di(boolean z) {
                AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_ERROR_ALLADDRESS_FAILED);
                WxaWidgetDebugUI.this.hpd.field_openDebug = z;
                m auR = ((a) g.K(a.class)).auR();
                l lVar = WxaWidgetDebugUI.this.hpd;
                if (!(lVar == null || bo.isNullOrNil(lVar.field_appId))) {
                    lVar.field_appIdHash = lVar.field_appId.hashCode();
                    auR.a(lVar);
                }
                AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_ERROR_ALLADDRESS_FAILED);
            }
        });
        TextView textView = (TextView) findViewById(R.id.fm3);
        CharSequence fromHtml = Html.fromHtml(getString(R.string.g3j), new com.tencent.mm.plugin.appbrand.dynamic.html.a(), new com.tencent.mm.plugin.appbrand.dynamic.html.b());
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
        findViewById(R.id.e_f).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_DATA);
                ((e) g.K(e.class)).aby().restart();
                com.tencent.mm.ce.a.r(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_ERROR_NET_DISCONNECT);
                        Toast.makeText(WxaWidgetDebugUI.this.mController.ylL, R.string.g3m, 1).show();
                        AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_ERROR_NET_DISCONNECT);
                    }
                }, 1000);
                AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_DATA);
            }
        });
        View findViewById = findViewById(R.id.fm4);
        if (((e) g.K(e.class)).abz().abF()) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(11014);
                    Intent intent = new Intent(WxaWidgetDebugUI.this.mController.ylL, WxaWidgetSettingsUI.class);
                    intent.putExtra("app_id", WxaWidgetDebugUI.this.appId);
                    intent.putExtra("pkg_type", WxaWidgetDebugUI.this.cBc);
                    intent.putExtra("pkg_version", WxaWidgetDebugUI.this.gVu);
                    WxaWidgetDebugUI.this.startActivity(intent);
                    AppMethodBeat.o(11014);
                }
            });
            AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_NETWORK);
            return;
        }
        findViewById.setVisibility(8);
        AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_NETWORK);
    }

    public final int getLayoutId() {
        return R.layout.b8b;
    }
}
