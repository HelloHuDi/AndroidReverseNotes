package com.tencent.mm.chatroom.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.h;
import com.tencent.xweb.l;
import com.tencent.xweb.s;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
@Deprecated
public class RoomAnnouncementUI extends MMActivity {
    private String ehq;
    private WebView ejN;
    private boolean ejO;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104140);
        super.onCreate(bundle);
        this.ejO = getIntent().getBooleanExtra("need_bind_mobile", false);
        this.ehq = getIntent().getStringExtra("RoomInfo_Id");
        initView();
        AppMethodBeat.o(104140);
    }

    public void onResume() {
        AppMethodBeat.i(104141);
        super.onResume();
        AppMethodBeat.o(104141);
    }

    public void onPause() {
        AppMethodBeat.i(104142);
        super.onPause();
        AppMethodBeat.o(104142);
    }

    public void onDestroy() {
        AppMethodBeat.i(104143);
        if (this.ejN != null) {
            this.ejN.setVisibility(8);
            ((ViewGroup) this.ejN.getParent()).removeView(this.ejN);
            this.ejN.removeAllViews();
            this.ejN.destroy();
            this.ejN = null;
            System.gc();
        }
        super.onDestroy();
        AppMethodBeat.o(104143);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void initView() {
        AppMethodBeat.i(104144);
        setMMTitle((int) R.string.dve);
        this.ejN = a.n(this, R.id.al2);
        this.ejN.getSettings().setJavaScriptEnabled(true);
        this.ejN.getSettings().dUh();
        this.ejN.getSettings().setBuiltInZoomControls(true);
        this.ejN.getSettings().setUseWideViewPort(true);
        this.ejN.getSettings().setLoadWithOverviewMode(true);
        this.ejN.getSettings().dUc();
        this.ejN.getSettings().dUb();
        this.ejN.getSettings().setGeolocationEnabled(false);
        this.ejN.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        this.ejN.setWebChromeClient(new l() {
            public final boolean a(WebView webView, String str, String str2, h hVar) {
                AppMethodBeat.i(104137);
                com.tencent.mm.ui.base.h.a(RoomAnnouncementUI.this, str2, null, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(104136);
                        RoomAnnouncementUI.this.ejN.requestFocus();
                        AppMethodBeat.o(104136);
                    }
                });
                hVar.cancel();
                AppMethodBeat.o(104137);
                return true;
            }
        });
        this.ejN.setWebViewClient(new s() {
            public final boolean a(WebView webView, String str) {
                AppMethodBeat.i(104138);
                if (str.equals("weixin://chatroom/upgradeagree")) {
                    b.a(RoomAnnouncementUI.this, RoomAnnouncementUI.this.ehq, RoomAnnouncementUI.this.ejO);
                    AppMethodBeat.o(104138);
                    return true;
                }
                AppMethodBeat.o(104138);
                return false;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104139);
                RoomAnnouncementUI.this.setResult(0);
                RoomAnnouncementUI.this.finish();
                AppMethodBeat.o(104139);
                return true;
            }
        });
        this.ejN.loadUrl(getString(R.string.ajt, new Object[]{aa.dor()}));
        AppMethodBeat.o(104144);
    }

    public final int getLayoutId() {
        return R.layout.kw;
    }
}
