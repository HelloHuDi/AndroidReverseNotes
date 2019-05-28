package com.tencent.mm.plugin.appbrand.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.r.r;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.e.l;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;
import java.util.List;

public class AppBrandSearchUI extends FTSSearchTabWebViewUI {
    private View iIv;
    private String iIw;
    private String iIx;
    private int scene;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17083);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(17083);
            return;
        }
        aa.HW(r.aLE());
        this.iIx = getIntent().getStringExtra("key_session_id");
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        ab.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", this.iIx);
        h.pYm.e(13929, this.iIx, "", Integer.valueOf(1), Integer.valueOf(this.scene));
        Intent intent = new Intent();
        intent.putExtra("key_session_id", this.iIx);
        intent.putExtra("ftsbizscene", this.scene);
        setResult(-1, intent);
        if (getIntent().getBooleanExtra("key_alpha_in", false)) {
            overridePendingTransition(R.anim.n, R.anim.s);
        }
        AppMethodBeat.o(17083);
    }

    public final void initView() {
        AppMethodBeat.i(17084);
        super.initView();
        xE(-855310);
        aMq();
        AppMethodBeat.o(17084);
    }

    public final void aMh() {
        AppMethodBeat.i(17085);
        super.aMh();
        aMq();
        AppMethodBeat.o(17085);
    }

    private void aMq() {
        AppMethodBeat.i(17086);
        if (this.mIr != null) {
            ((ImageView) this.mIr.findViewById(R.id.l1)).getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            FTSEditTextView fTSEditTextView = (FTSEditTextView) this.mIr.findViewById(R.id.bxc);
            fTSEditTextView.getIconView().setImageResource(R.raw.appbrand_actionbar_search_view_icon_black);
            ((ImageButton) fTSEditTextView.findViewById(R.id.kz)).getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            fTSEditTextView.getEditText().setHintTextColor(getResources().getColor(R.color.sy));
            fTSEditTextView.getEditText().setTextColor(WebView.NIGHT_MODE_COLOR);
            p.b(this);
        }
        AppMethodBeat.o(17086);
    }

    public void onResume() {
        AppMethodBeat.i(17087);
        super.onResume();
        try {
            if (((com.tencent.mm.kernel.b.h) g.RM().Rn()).SG()) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                sendBroadcast(intent);
            }
            AppMethodBeat.o(17087);
        } catch (Exception e) {
            AppMethodBeat.o(17087);
        }
    }

    public final int aMi() {
        AppMethodBeat.i(17088);
        int i;
        if (VERSION.SDK_INT >= 23 && (!com.tencent.mm.compatible.util.h.Ms() || !AppBrandNearbyWebViewUI.Mt())) {
            ae.f(getWindow());
            AppMethodBeat.o(17088);
            return -855310;
        } else if (VERSION.SDK_INT >= 21) {
            i = com.tencent.mm.plugin.appbrand.aa.gQs;
            AppMethodBeat.o(17088);
            return i;
        } else {
            i = super.aMi();
            AppMethodBeat.o(17088);
            return i;
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(17089);
        if (this.scene == 3 || this.scene == 16) {
            h.pYm.e(13929, this.iIx, b.fpE, Integer.valueOf(2), Integer.valueOf(this.scene));
        }
        super.onDestroy();
        AppMethodBeat.o(17089);
    }

    public final boolean aMo() {
        AppMethodBeat.i(17090);
        this.iIv.setVisibility(8);
        boolean aMo = super.aMo();
        AppMethodBeat.o(17090);
        return aMo;
    }

    public final void a(String str, String str2, List<a.b> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(17091);
        if (!TextUtils.isEmpty(str2)) {
            this.iIv.setVisibility(8);
        }
        try {
            this.icy.g(10001, null);
        } catch (RemoteException e) {
            ab.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", e);
        }
        super.a(str, str2, list, bVar);
        AppMethodBeat.o(17091);
    }

    public final void dealContentView(View view) {
        AppMethodBeat.i(17092);
        super.dealContentView(view);
        this.iIw = getIntent().getStringExtra("key_nearby_url");
        getIntent().getStringExtra("key_nearby_list_id");
        this.iIv = getLayoutInflater().inflate(R.layout.dg, (ViewGroup) view, false);
        View findViewById = this.iIv.findViewById(R.id.vh);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(17081);
                if (TextUtils.isEmpty(AppBrandSearchUI.this.iIw)) {
                    AppMethodBeat.o(17081);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", AppBrandSearchUI.this.iIw);
                intent.putExtra("geta8key_scene", 41);
                intent.putExtra("show_long_click_popup_menu", false);
                d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(17081);
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
            AppMethodBeat.o(17092);
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
        AppMethodBeat.o(17092);
    }

    private int aMp() {
        int i = 0;
        AppMethodBeat.i(17093);
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = getResources().getDimensionPixelSize(bo.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Exception e) {
        }
        AppMethodBeat.o(17093);
        return i;
    }

    public final void j(int i, Bundle bundle) {
        AppMethodBeat.i(17094);
        super.j(i, bundle);
        switch (i) {
            case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                final String string = bundle.getString("fts_key_json_data");
                final int i2 = bundle.getInt("fts_key_is_cache_data", 0);
                final int i3 = bundle.getInt("fts_key_is_expired", 1);
                final int i4 = bundle.getInt("fts_key_is_preload", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(17082);
                        if (AppBrandSearchUI.this.uhz != null) {
                            AppBrandSearchUI.this.uhz.m(string, i2, i3, i4);
                        }
                        AppMethodBeat.o(17082);
                    }
                });
                break;
        }
        AppMethodBeat.o(17094);
    }

    public final String getHint() {
        AppMethodBeat.i(17095);
        String stringExtra = getIntent().getStringExtra("key_search_place_holder");
        if (stringExtra == null || stringExtra.length() <= 0) {
            stringExtra = super.getHint();
            AppMethodBeat.o(17095);
            return stringExtra;
        }
        AppMethodBeat.o(17095);
        return stringExtra;
    }
}
