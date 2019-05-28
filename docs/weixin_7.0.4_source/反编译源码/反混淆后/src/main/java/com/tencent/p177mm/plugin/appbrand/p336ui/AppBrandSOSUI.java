package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelappbrand.C45445b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12071b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20890b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.fts.FTSSOSMoreWebViewUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandSOSUI */
public class AppBrandSOSUI extends FTSSOSMoreWebViewUI {
    private View iIv;
    private String iIw;
    private String iIx;
    private int scene;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandSOSUI$1 */
    class C24751 implements OnClickListener {
        C24751() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(17073);
            if (TextUtils.isEmpty(AppBrandSOSUI.this.iIw)) {
                AppMethodBeat.m2505o(17073);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", AppBrandSOSUI.this.iIw);
            intent.putExtra("geta8key_scene", 41);
            intent.putExtra("show_long_click_popup_menu", false);
            C25985d.m41467b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(17073);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17074);
        super.onCreate(bundle);
        overridePendingTransition(C25738R.anim.f8362c4, 0);
        this.iIx = getIntent().getStringExtra("key_session_id");
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        C4990ab.m7417i("MicroMsg.AppBrandSOSUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", this.iIx);
        C7060h.pYm.mo8381e(13929, this.iIx, "", Integer.valueOf(1), Integer.valueOf(this.scene));
        Intent intent = new Intent();
        intent.putExtra("key_session_id", this.iIx);
        intent.putExtra("ftsbizscene", this.scene);
        setResult(-1, intent);
        AppMethodBeat.m2505o(17074);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(17075);
        if (this.scene == 3 || this.scene == 16) {
            C7060h.pYm.mo8381e(13929, this.iIx, C45445b.fpE, Integer.valueOf(2), Integer.valueOf(this.scene));
        }
        super.onDestroy();
        AppMethodBeat.m2505o(17075);
    }

    public final boolean aMo() {
        AppMethodBeat.m2504i(17076);
        this.iIv.setVisibility(8);
        boolean aMo = super.aMo();
        AppMethodBeat.m2505o(17076);
        return aMo;
    }

    /* renamed from: a */
    public final void mo6403a(String str, String str2, List<C12071b> list, C20890b c20890b) {
        AppMethodBeat.m2504i(17077);
        if (!TextUtils.isEmpty(str2)) {
            this.iIv.setVisibility(8);
        }
        try {
            this.icy.mo15575g(10001, null);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.AppBrandSOSUI", "refresh keyword id error : %s", e);
        }
        super.mo6403a(str, str2, list, c20890b);
        AppMethodBeat.m2505o(17077);
    }

    public final void dealContentView(View view) {
        AppMethodBeat.m2504i(17078);
        super.dealContentView(view);
        this.iIw = getIntent().getStringExtra("key_nearby_url");
        getIntent().getStringExtra("key_nearby_list_id");
        this.iIv = getLayoutInflater().inflate(2130968730, (ViewGroup) view, false);
        View findViewById = this.iIv.findViewById(2131821365);
        findViewById.setOnClickListener(new C24751());
        if (TextUtils.isEmpty(this.iIw)) {
            findViewById.setVisibility(8);
            this.iIv.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            this.iIv.setVisibility(0);
        }
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.iIv);
            AppMethodBeat.m2505o(17078);
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
        AppMethodBeat.m2505o(17078);
    }

    private int aMp() {
        int i = 0;
        AppMethodBeat.m2504i(17079);
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = getResources().getDimensionPixelSize(C5046bo.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(17079);
        return i;
    }

    public final String getHint() {
        AppMethodBeat.m2504i(17080);
        String stringExtra = getIntent().getStringExtra("key_search_place_holder");
        if (stringExtra == null || stringExtra.length() <= 0) {
            stringExtra = super.getHint();
            AppMethodBeat.m2505o(17080);
            return stringExtra;
        }
        AppMethodBeat.m2505o(17080);
        return stringExtra;
    }
}
