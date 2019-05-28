package com.tencent.p177mm.chatroom.p216ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.MMWebView.C30798a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C46945h;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.WebView;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
@Deprecated
/* renamed from: com.tencent.mm.chatroom.ui.RoomAnnouncementUI */
public class RoomAnnouncementUI extends MMActivity {
    private String ehq;
    private WebView ejN;
    private boolean ejO;

    /* renamed from: com.tencent.mm.chatroom.ui.RoomAnnouncementUI$2 */
    class C13782 extends C36592s {
        C13782() {
        }

        /* renamed from: a */
        public final boolean mo4762a(WebView webView, String str) {
            AppMethodBeat.m2504i(104138);
            if (str.equals("weixin://chatroom/upgradeagree")) {
                C26041b.m41590a(RoomAnnouncementUI.this, RoomAnnouncementUI.this.ehq, RoomAnnouncementUI.this.ejO);
                AppMethodBeat.m2505o(104138);
                return true;
            }
            AppMethodBeat.m2505o(104138);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomAnnouncementUI$1 */
    class C64511 extends C6031l {

        /* renamed from: com.tencent.mm.chatroom.ui.RoomAnnouncementUI$1$1 */
        class C64521 implements OnClickListener {
            C64521() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(104136);
                RoomAnnouncementUI.this.ejN.requestFocus();
                AppMethodBeat.m2505o(104136);
            }
        }

        C64511() {
        }

        /* renamed from: a */
        public final boolean mo13207a(WebView webView, String str, String str2, C46945h c46945h) {
            AppMethodBeat.m2504i(104137);
            C30379h.m48438a(RoomAnnouncementUI.this, str2, null, new C64521());
            c46945h.cancel();
            AppMethodBeat.m2505o(104137);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomAnnouncementUI$3 */
    class C181393 implements OnMenuItemClickListener {
        C181393() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104139);
            RoomAnnouncementUI.this.setResult(0);
            RoomAnnouncementUI.this.finish();
            AppMethodBeat.m2505o(104139);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104140);
        super.onCreate(bundle);
        this.ejO = getIntent().getBooleanExtra("need_bind_mobile", false);
        this.ehq = getIntent().getStringExtra("RoomInfo_Id");
        initView();
        AppMethodBeat.m2505o(104140);
    }

    public void onResume() {
        AppMethodBeat.m2504i(104141);
        super.onResume();
        AppMethodBeat.m2505o(104141);
    }

    public void onPause() {
        AppMethodBeat.m2504i(104142);
        super.onPause();
        AppMethodBeat.m2505o(104142);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104143);
        if (this.ejN != null) {
            this.ejN.setVisibility(8);
            ((ViewGroup) this.ejN.getParent()).removeView(this.ejN);
            this.ejN.removeAllViews();
            this.ejN.destroy();
            this.ejN = null;
            System.gc();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(104143);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void initView() {
        AppMethodBeat.m2504i(104144);
        setMMTitle((int) C25738R.string.dve);
        this.ejN = C30798a.m49146n(this, 2131822360);
        this.ejN.getSettings().setJavaScriptEnabled(true);
        this.ejN.getSettings().dUh();
        this.ejN.getSettings().setBuiltInZoomControls(true);
        this.ejN.getSettings().setUseWideViewPort(true);
        this.ejN.getSettings().setLoadWithOverviewMode(true);
        this.ejN.getSettings().dUc();
        this.ejN.getSettings().dUb();
        this.ejN.getSettings().setGeolocationEnabled(false);
        this.ejN.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        this.ejN.setWebChromeClient(new C64511());
        this.ejN.setWebViewClient(new C13782());
        setBackBtn(new C181393());
        this.ejN.loadUrl(getString(C25738R.string.ajt, new Object[]{C4988aa.dor()}));
        AppMethodBeat.m2505o(104144);
    }

    public final int getLayoutId() {
        return 2130969005;
    }
}
