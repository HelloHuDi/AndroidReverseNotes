package com.tencent.p177mm.plugin.webview.p580ui.tools.emojistore;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.p057v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI.C14579h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i.C23124a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C4479059;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import org.xwalk.core.XWalkCoreWrapper;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI */
public class BaseEmojiStoreSearchWebViewUI extends WebViewUI implements C5600b {
    private C5601o jKT;
    String query;
    private int type;
    private boolean uzU;
    private boolean uzV = true;
    private int uzW;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI$a */
    class C4596a extends C14579h {
        private C4596a() {
            super();
        }

        /* synthetic */ C4596a(BaseEmojiStoreSearchWebViewUI baseEmojiStoreSearchWebViewUI, byte b) {
            this();
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(8291);
            C4990ab.m7417i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", str);
            super.mo5992b(webView, str);
            BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
            BaseEmojiStoreSearchWebViewUI.this.jKT.setSearchContent(BaseEmojiStoreSearchWebViewUI.this.query);
            AppMethodBeat.m2505o(8291);
        }

        /* renamed from: b */
        public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(8292);
            super.mo7562b(webView, str, bitmap);
            BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
            AppMethodBeat.m2505o(8292);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI$1 */
    class C298851 implements OnTouchListener {
        C298851() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(8288);
            BaseEmojiStoreSearchWebViewUI.this.aqX();
            AppMethodBeat.m2505o(8288);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI$3 */
    class C298863 implements Runnable {
        C298863() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8289);
            BaseEmojiStoreSearchWebViewUI.this.jKT.clearFocus();
            BaseEmojiStoreSearchWebViewUI.this.aqX();
            AppMethodBeat.m2505o(8289);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI$4 */
    class C298874 implements Runnable {
        C298874() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8290);
            if (BaseEmojiStoreSearchWebViewUI.this.uhz != null) {
                BaseEmojiStoreSearchWebViewUI.this.uhz.dcn();
            }
            AppMethodBeat.m2505o(8290);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI$2 */
    class C298882 implements OnLongClickListener {
        C298882() {
        }

        public final boolean onLongClick(View view) {
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void aMh() {
        AppMethodBeat.m2504i(8293);
        super.aMh();
        this.query = getIntent().getStringExtra("keyword");
        this.type = getIntent().getIntExtra("type", 0);
        this.uzU = getIntent().getBooleanExtra("showkeyboard", false);
        this.uzW = getIntent().getIntExtra("sence", 0);
        this.pzf.setWebViewClient(new C4596a(this, (byte) 0));
        this.pzf.setOnTouchListener(new C298851());
        this.jKT = new C5601o();
        mo17380a(this.jKT);
        this.jKT.mo11371qQ(false);
        this.jKT.zHa = this;
        showOptionMenu(false);
        if (dao() != null) {
            dao().mo69669nM(true);
        }
        this.pzf.setOnLongClickListener(new C298882());
        AppMethodBeat.m2505o(8293);
    }

    public final void app() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(8294);
        if (this.jKT != null) {
            this.jKT.mo11359a((FragmentActivity) this, menu);
            this.jKT.setHint(getString(C25738R.string.b_v));
        }
        AppMethodBeat.m2505o(8294);
        return true;
    }

    public final void apo() {
        AppMethodBeat.m2504i(8295);
        finish();
        AppMethodBeat.m2505o(8295);
    }

    /* renamed from: vO */
    public final void mo7460vO(String str) {
        AppMethodBeat.m2504i(8296);
        if (this.uzV && C5046bo.isNullOrNil(str)) {
            this.uzV = false;
            if (this.uzU) {
                this.jKT.dJt();
                showVKB();
            } else {
                C5004al.m7442n(new C298863(), 500);
                AppMethodBeat.m2505o(8296);
                return;
            }
        }
        AppMethodBeat.m2505o(8296);
    }

    /* renamed from: vN */
    public final boolean mo7459vN(String str) {
        AppMethodBeat.m2504i(8297);
        if (str != null) {
            str = str.trim();
        }
        this.query = str;
        if (!C5046bo.isNullOrNil(str)) {
            this.query = str;
            this.handler.post(new C298874());
            Bundle bundle = new Bundle();
            bundle.putInt("type", this.type);
            bundle.putString("nextPageBuffer", "");
            bundle.putString("keyword", this.query);
            bundle.putInt("webview_instance_id", hashCode());
            bundle.putLong("searchID", this.uhz.dcp());
            try {
                if (this.icy != null) {
                    this.icy.mo15589r(1, bundle);
                } else {
                    C4990ab.m7412e("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "invoker should not be null");
                }
            } catch (RemoteException e) {
                C4990ab.printErrStackTrace("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", e, "doSearch", new Object[0]);
            }
        }
        aqX();
        String str2 = "";
        if (!C5046bo.isNullOrNil(str)) {
            str2 = str.replace(",", " ");
        }
        C7060h.pYm.mo8381e(13054, Integer.valueOf(this.uzW), Integer.valueOf(1), str2);
        AppMethodBeat.m2505o(8297);
        return false;
    }

    public final void apq() {
        AppMethodBeat.m2504i(8298);
        this.jKT.dJt();
        showVKB();
        AppMethodBeat.m2505o(8298);
    }

    public final void apr() {
    }

    /* renamed from: t */
    public void mo9678t(int i, Bundle bundle) {
        AppMethodBeat.m2504i(8299);
        C4990ab.m7417i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", Integer.valueOf(i));
        switch (i) {
            case XWalkCoreWrapper.INVOKE_RUNTIME_ID_CONTEXT_CHANGED /*80001*/:
                String string = bundle.getString("emoji_store_json_data");
                boolean z = bundle.getBoolean("emoji_store_new_query", true);
                String string2 = bundle.getString("emoji_store_page_buf");
                long j = bundle.getLong("emoji_store_search_id");
                C44786d c44786d = this.uhz;
                if (c44786d.ready) {
                    C4990ab.m7416i("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData success, ready");
                    HashMap hashMap = new HashMap();
                    hashMap.put("json", string);
                    hashMap.put("newQuery", Boolean.valueOf(z));
                    hashMap.put("nextPageBuffer", string2);
                    C4990ab.m7411d("MicroMsg.JsApiHandler", "cpan emoji set SearchID:%d", Long.valueOf(j));
                    c44786d.uFH = j;
                    C4990ab.m7417i("MicroMsg.JsApiHandler", "event:%s", C23124a.m35500b("getSearchEmotionDataCallBack", hashMap, c44786d.uFv, c44786d.uFw));
                    C5004al.m7441d(new C4479059(string));
                    AppMethodBeat.m2505o(8299);
                    return;
                }
                C4990ab.m7412e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, not ready");
                AppMethodBeat.m2505o(8299);
                return;
            case 80002:
                this.uhz.dcn();
                AppMethodBeat.m2505o(8299);
                return;
            default:
                super.mo9678t(i, bundle);
                AppMethodBeat.m2505o(8299);
                return;
        }
    }

    public final void dai() {
        AppMethodBeat.m2504i(8300);
        finish();
        AppMethodBeat.m2505o(8300);
    }

    public final int getLayoutId() {
        return 2130969388;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(8301);
        super.onDestroy();
        AppMethodBeat.m2505o(8301);
    }

    public final boolean day() {
        return true;
    }
}
