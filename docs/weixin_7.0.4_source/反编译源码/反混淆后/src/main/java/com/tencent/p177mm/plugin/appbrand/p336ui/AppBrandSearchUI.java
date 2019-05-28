package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.modelappbrand.C45445b;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5510e.C5505l;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C10049aa;
import com.tencent.p177mm.plugin.appbrand.p328r.C27278r;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12071b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20890b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.webview.p580ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI */
public class AppBrandSearchUI extends FTSSearchTabWebViewUI {
    private View iIv;
    private String iIw;
    private String iIx;
    private int scene;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI$1 */
    class C197501 implements OnClickListener {
        C197501() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(17081);
            if (TextUtils.isEmpty(AppBrandSearchUI.this.iIw)) {
                AppMethodBeat.m2505o(17081);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", AppBrandSearchUI.this.iIw);
            intent.putExtra("geta8key_scene", 41);
            intent.putExtra("show_long_click_popup_menu", false);
            C25985d.m41467b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(17081);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17083);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.m2505o(17083);
            return;
        }
        C46400aa.m87306HW(C27278r.aLE());
        this.iIx = getIntent().getStringExtra("key_session_id");
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        C4990ab.m7417i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", this.iIx);
        C7060h.pYm.mo8381e(13929, this.iIx, "", Integer.valueOf(1), Integer.valueOf(this.scene));
        Intent intent = new Intent();
        intent.putExtra("key_session_id", this.iIx);
        intent.putExtra("ftsbizscene", this.scene);
        setResult(-1, intent);
        if (getIntent().getBooleanExtra("key_alpha_in", false)) {
            overridePendingTransition(C25738R.anim.f8288n, C25738R.anim.f8293s);
        }
        AppMethodBeat.m2505o(17083);
    }

    public final void initView() {
        AppMethodBeat.m2504i(17084);
        super.initView();
        mo17446xE(-855310);
        aMq();
        AppMethodBeat.m2505o(17084);
    }

    public final void aMh() {
        AppMethodBeat.m2504i(17085);
        super.aMh();
        aMq();
        AppMethodBeat.m2505o(17085);
    }

    private void aMq() {
        AppMethodBeat.m2504i(17086);
        if (this.mIr != null) {
            ((ImageView) this.mIr.findViewById(2131820978)).getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            FTSEditTextView fTSEditTextView = (FTSEditTextView) this.mIr.findViewById(2131824183);
            fTSEditTextView.getIconView().setImageResource(C1318a.appbrand_actionbar_search_view_icon_black);
            ((ImageButton) fTSEditTextView.findViewById(2131820976)).getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            fTSEditTextView.getEditText().setHintTextColor(getResources().getColor(C25738R.color.f12116sy));
            fTSEditTextView.getEditText().setTextColor(WebView.NIGHT_MODE_COLOR);
            C42698p.m75626b(this);
        }
        AppMethodBeat.m2505o(17086);
    }

    public void onResume() {
        AppMethodBeat.m2504i(17087);
        super.onResume();
        try {
            if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(C5505l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                sendBroadcast(intent);
            }
            AppMethodBeat.m2505o(17087);
        } catch (Exception e) {
            AppMethodBeat.m2505o(17087);
        }
    }

    public final int aMi() {
        AppMethodBeat.m2504i(17088);
        int i;
        if (VERSION.SDK_INT >= 23 && (!C1448h.m3076Ms() || !AppBrandNearbyWebViewUI.m4708Mt())) {
            C5222ae.m7941f(getWindow());
            AppMethodBeat.m2505o(17088);
            return -855310;
        } else if (VERSION.SDK_INT >= 21) {
            i = C10049aa.gQs;
            AppMethodBeat.m2505o(17088);
            return i;
        } else {
            i = super.aMi();
            AppMethodBeat.m2505o(17088);
            return i;
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(17089);
        if (this.scene == 3 || this.scene == 16) {
            C7060h.pYm.mo8381e(13929, this.iIx, C45445b.fpE, Integer.valueOf(2), Integer.valueOf(this.scene));
        }
        super.onDestroy();
        AppMethodBeat.m2505o(17089);
    }

    public final boolean aMo() {
        AppMethodBeat.m2504i(17090);
        this.iIv.setVisibility(8);
        boolean aMo = super.aMo();
        AppMethodBeat.m2505o(17090);
        return aMo;
    }

    /* renamed from: a */
    public final void mo6403a(String str, String str2, List<C12071b> list, C20890b c20890b) {
        AppMethodBeat.m2504i(17091);
        if (!TextUtils.isEmpty(str2)) {
            this.iIv.setVisibility(8);
        }
        try {
            this.icy.mo15575g(10001, null);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", e);
        }
        super.mo6403a(str, str2, list, c20890b);
        AppMethodBeat.m2505o(17091);
    }

    public final void dealContentView(View view) {
        AppMethodBeat.m2504i(17092);
        super.dealContentView(view);
        this.iIw = getIntent().getStringExtra("key_nearby_url");
        getIntent().getStringExtra("key_nearby_list_id");
        this.iIv = getLayoutInflater().inflate(2130968730, (ViewGroup) view, false);
        View findViewById = this.iIv.findViewById(2131821365);
        findViewById.setOnClickListener(new C197501());
        if (TextUtils.isEmpty(this.iIw)) {
            findViewById.setVisibility(8);
            this.iIv.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            this.iIv.setVisibility(0);
        }
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.iIv);
            AppMethodBeat.m2505o(17092);
            return;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (getWindow().hasFeature(9)) {
            View view2 = this.iIv;
            int paddingLeft = this.iIv.getPaddingLeft();
            Rect rect = new Rect();
            int actionBarHeight = getActionBarHeight();
            View decorView = getWindow().getDecorView();
            decorView.getWindowVisibleDisplayFrame(rect);
            int height = decorView.getHeight();
            int[] iArr = new int[2];
            decorView.getLocationOnScreen(iArr);
            if (height == 0) {
                actionBarHeight += aMp();
            }
            if (height - rect.height() < 0 || iArr[1] <= 200) {
                actionBarHeight += rect.top;
            } else {
                actionBarHeight += height - rect.height();
            }
            view2.setPadding(paddingLeft, actionBarHeight + this.iIv.getPaddingTop(), this.iIv.getPaddingRight(), this.iIv.getPaddingBottom());
        }
        addContentView(this.iIv, layoutParams);
        AppMethodBeat.m2505o(17092);
    }

    private int aMp() {
        int i = 0;
        AppMethodBeat.m2504i(17093);
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = getResources().getDimensionPixelSize(C5046bo.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(17093);
        return i;
    }

    /* renamed from: j */
    public final void mo9685j(int i, Bundle bundle) {
        AppMethodBeat.m2504i(17094);
        super.mo9685j(i, bundle);
        switch (i) {
            case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                final String string = bundle.getString("fts_key_json_data");
                final int i2 = bundle.getInt("fts_key_is_cache_data", 0);
                final int i3 = bundle.getInt("fts_key_is_expired", 1);
                final int i4 = bundle.getInt("fts_key_is_preload", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(17082);
                        if (AppBrandSearchUI.this.uhz != null) {
                            AppBrandSearchUI.this.uhz.mo71935m(string, i2, i3, i4);
                        }
                        AppMethodBeat.m2505o(17082);
                    }
                });
                break;
        }
        AppMethodBeat.m2505o(17094);
    }

    public final String getHint() {
        AppMethodBeat.m2504i(17095);
        String stringExtra = getIntent().getStringExtra("key_search_place_holder");
        if (stringExtra == null || stringExtra.length() <= 0) {
            stringExtra = super.getHint();
            AppMethodBeat.m2505o(17095);
            return stringExtra;
        }
        AppMethodBeat.m2505o(17095);
        return stringExtra;
    }
}
