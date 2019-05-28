package com.tencent.mm.plugin.appbrand.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public class AppBrandSOSUI extends FTSSOSMoreWebViewUI {
    private View iIv;
    private String iIw;
    private String iIx;
    private int scene;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17074);
        super.onCreate(bundle);
        overridePendingTransition(R.anim.c4, 0);
        this.iIx = getIntent().getStringExtra("key_session_id");
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        ab.i("MicroMsg.AppBrandSOSUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", this.iIx);
        h.pYm.e(13929, this.iIx, "", Integer.valueOf(1), Integer.valueOf(this.scene));
        Intent intent = new Intent();
        intent.putExtra("key_session_id", this.iIx);
        intent.putExtra("ftsbizscene", this.scene);
        setResult(-1, intent);
        AppMethodBeat.o(17074);
    }

    public void onDestroy() {
        AppMethodBeat.i(17075);
        if (this.scene == 3 || this.scene == 16) {
            h.pYm.e(13929, this.iIx, b.fpE, Integer.valueOf(2), Integer.valueOf(this.scene));
        }
        super.onDestroy();
        AppMethodBeat.o(17075);
    }

    public final boolean aMo() {
        AppMethodBeat.i(17076);
        this.iIv.setVisibility(8);
        boolean aMo = super.aMo();
        AppMethodBeat.o(17076);
        return aMo;
    }

    public final void a(String str, String str2, List<a.b> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(17077);
        if (!TextUtils.isEmpty(str2)) {
            this.iIv.setVisibility(8);
        }
        try {
            this.icy.g(10001, null);
        } catch (RemoteException e) {
            ab.e("MicroMsg.AppBrandSOSUI", "refresh keyword id error : %s", e);
        }
        super.a(str, str2, list, bVar);
        AppMethodBeat.o(17077);
    }

    public final void dealContentView(View view) {
        AppMethodBeat.i(17078);
        super.dealContentView(view);
        this.iIw = getIntent().getStringExtra("key_nearby_url");
        getIntent().getStringExtra("key_nearby_list_id");
        this.iIv = getLayoutInflater().inflate(R.layout.dg, (ViewGroup) view, false);
        View findViewById = this.iIv.findViewById(R.id.vh);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(17073);
                if (TextUtils.isEmpty(AppBrandSOSUI.this.iIw)) {
                    AppMethodBeat.o(17073);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", AppBrandSOSUI.this.iIw);
                intent.putExtra("geta8key_scene", 41);
                intent.putExtra("show_long_click_popup_menu", false);
                d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(17073);
            }
        });
        if (TextUtils.isEmpty(this.iIw)) {
            findViewById.setVisibility(8);
            this.iIv.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            this.iIv.setVisibility(0);
        }
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.iIv);
            AppMethodBeat.o(17078);
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
        AppMethodBeat.o(17078);
    }

    private int aMp() {
        int i = 0;
        AppMethodBeat.i(17079);
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = getResources().getDimensionPixelSize(bo.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Exception e) {
        }
        AppMethodBeat.o(17079);
        return i;
    }

    public final String getHint() {
        AppMethodBeat.i(17080);
        String stringExtra = getIntent().getStringExtra("key_search_place_holder");
        if (stringExtra == null || stringExtra.length() <= 0) {
            stringExtra = super.getHint();
            AppMethodBeat.o(17080);
            return stringExtra;
        }
        AppMethodBeat.o(17080);
        return stringExtra;
    }
}
