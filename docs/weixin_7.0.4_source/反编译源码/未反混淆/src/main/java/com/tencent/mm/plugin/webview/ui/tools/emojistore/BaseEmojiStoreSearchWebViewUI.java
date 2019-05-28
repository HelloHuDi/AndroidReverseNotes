package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass59;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import org.xwalk.core.XWalkCoreWrapper;

public class BaseEmojiStoreSearchWebViewUI extends WebViewUI implements b {
    private o jKT;
    String query;
    private int type;
    private boolean uzU;
    private boolean uzV = true;
    private int uzW;

    class a extends h {
        private a() {
            super();
        }

        /* synthetic */ a(BaseEmojiStoreSearchWebViewUI baseEmojiStoreSearchWebViewUI, byte b) {
            this();
        }

        public final void b(WebView webView, String str) {
            AppMethodBeat.i(8291);
            ab.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", str);
            super.b(webView, str);
            BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
            BaseEmojiStoreSearchWebViewUI.this.jKT.setSearchContent(BaseEmojiStoreSearchWebViewUI.this.query);
            AppMethodBeat.o(8291);
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(8292);
            super.b(webView, str, bitmap);
            BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
            AppMethodBeat.o(8292);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void aMh() {
        AppMethodBeat.i(8293);
        super.aMh();
        this.query = getIntent().getStringExtra("keyword");
        this.type = getIntent().getIntExtra("type", 0);
        this.uzU = getIntent().getBooleanExtra("showkeyboard", false);
        this.uzW = getIntent().getIntExtra("sence", 0);
        this.pzf.setWebViewClient(new a(this, (byte) 0));
        this.pzf.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(8288);
                BaseEmojiStoreSearchWebViewUI.this.aqX();
                AppMethodBeat.o(8288);
                return false;
            }
        });
        this.jKT = new o();
        a(this.jKT);
        this.jKT.qQ(false);
        this.jKT.zHa = this;
        showOptionMenu(false);
        if (dao() != null) {
            dao().nM(true);
        }
        this.pzf.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                return true;
            }
        });
        AppMethodBeat.o(8293);
    }

    public final void app() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(8294);
        if (this.jKT != null) {
            this.jKT.a((FragmentActivity) this, menu);
            this.jKT.setHint(getString(R.string.b_v));
        }
        AppMethodBeat.o(8294);
        return true;
    }

    public final void apo() {
        AppMethodBeat.i(8295);
        finish();
        AppMethodBeat.o(8295);
    }

    public final void vO(String str) {
        AppMethodBeat.i(8296);
        if (this.uzV && bo.isNullOrNil(str)) {
            this.uzV = false;
            if (this.uzU) {
                this.jKT.dJt();
                showVKB();
            } else {
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8289);
                        BaseEmojiStoreSearchWebViewUI.this.jKT.clearFocus();
                        BaseEmojiStoreSearchWebViewUI.this.aqX();
                        AppMethodBeat.o(8289);
                    }
                }, 500);
                AppMethodBeat.o(8296);
                return;
            }
        }
        AppMethodBeat.o(8296);
    }

    public final boolean vN(String str) {
        AppMethodBeat.i(8297);
        if (str != null) {
            str = str.trim();
        }
        this.query = str;
        if (!bo.isNullOrNil(str)) {
            this.query = str;
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8290);
                    if (BaseEmojiStoreSearchWebViewUI.this.uhz != null) {
                        BaseEmojiStoreSearchWebViewUI.this.uhz.dcn();
                    }
                    AppMethodBeat.o(8290);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putInt("type", this.type);
            bundle.putString("nextPageBuffer", "");
            bundle.putString("keyword", this.query);
            bundle.putInt("webview_instance_id", hashCode());
            bundle.putLong("searchID", this.uhz.dcp());
            try {
                if (this.icy != null) {
                    this.icy.r(1, bundle);
                } else {
                    ab.e("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "invoker should not be null");
                }
            } catch (RemoteException e) {
                ab.printErrStackTrace("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", e, "doSearch", new Object[0]);
            }
        }
        aqX();
        String str2 = "";
        if (!bo.isNullOrNil(str)) {
            str2 = str.replace(",", " ");
        }
        com.tencent.mm.plugin.report.service.h.pYm.e(13054, Integer.valueOf(this.uzW), Integer.valueOf(1), str2);
        AppMethodBeat.o(8297);
        return false;
    }

    public final void apq() {
        AppMethodBeat.i(8298);
        this.jKT.dJt();
        showVKB();
        AppMethodBeat.o(8298);
    }

    public final void apr() {
    }

    public void t(int i, Bundle bundle) {
        AppMethodBeat.i(8299);
        ab.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", Integer.valueOf(i));
        switch (i) {
            case XWalkCoreWrapper.INVOKE_RUNTIME_ID_CONTEXT_CHANGED /*80001*/:
                String string = bundle.getString("emoji_store_json_data");
                boolean z = bundle.getBoolean("emoji_store_new_query", true);
                String string2 = bundle.getString("emoji_store_page_buf");
                long j = bundle.getLong("emoji_store_search_id");
                d dVar = this.uhz;
                if (dVar.ready) {
                    ab.i("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData success, ready");
                    HashMap hashMap = new HashMap();
                    hashMap.put("json", string);
                    hashMap.put("newQuery", Boolean.valueOf(z));
                    hashMap.put("nextPageBuffer", string2);
                    ab.d("MicroMsg.JsApiHandler", "cpan emoji set SearchID:%d", Long.valueOf(j));
                    dVar.uFH = j;
                    ab.i("MicroMsg.JsApiHandler", "event:%s", com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("getSearchEmotionDataCallBack", hashMap, dVar.uFv, dVar.uFw));
                    al.d(new AnonymousClass59(string));
                    AppMethodBeat.o(8299);
                    return;
                }
                ab.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, not ready");
                AppMethodBeat.o(8299);
                return;
            case 80002:
                this.uhz.dcn();
                AppMethodBeat.o(8299);
                return;
            default:
                super.t(i, bundle);
                AppMethodBeat.o(8299);
                return;
        }
    }

    public final void dai() {
        AppMethodBeat.i(8300);
        finish();
        AppMethodBeat.o(8300);
    }

    public final int getLayoutId() {
        return R.layout.v7;
    }

    public void onDestroy() {
        AppMethodBeat.i(8301);
        super.onDestroy();
        AppMethodBeat.o(8301);
    }

    public final boolean day() {
        return true;
    }
}
