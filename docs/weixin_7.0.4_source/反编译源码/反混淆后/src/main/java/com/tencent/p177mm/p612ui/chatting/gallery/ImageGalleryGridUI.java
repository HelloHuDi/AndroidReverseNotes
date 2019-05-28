package com.tencent.p177mm.p612ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.p177mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32599lz;
import com.tencent.p177mm.p230g.p231a.C32607ok;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C9362gs;
import com.tencent.p177mm.p230g.p231a.C9365gt;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.chatting.C15584as;
import com.tencent.p177mm.p612ui.chatting.C23698ah;
import com.tencent.p177mm.p612ui.chatting.C23698ah.C23699a;
import com.tencent.p177mm.p612ui.chatting.C40707a;
import com.tencent.p177mm.p612ui.chatting.C40707a.C23688d;
import com.tencent.p177mm.p612ui.chatting.C40707a.C40706c;
import com.tencent.p177mm.p612ui.chatting.C40707a.C40708b;
import com.tencent.p177mm.p612ui.chatting.C44308i;
import com.tencent.p177mm.p612ui.chatting.C46660k;
import com.tencent.p177mm.p612ui.chatting.gallery.C15659h.C15660a;
import com.tencent.p177mm.p612ui.chatting.gallery.C15659h.C15661b;
import com.tencent.p177mm.p612ui.chatting.gallery.C46938d.C44307a;
import com.tencent.p177mm.p612ui.gridviewheaders.C15894a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.game.p1268a.C43155a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C40444g;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

@C5271a(19)
/* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI */
public class ImageGalleryGridUI extends MMActivity implements OnMenuItemClickListener, OnClickListener, OnPreDrawListener, OnItemClickListener, C23698ah, C15661b {
    protected C7306ak handler;
    public long jMj;
    private boolean kuU = false;
    private C4884c kvj = new C443064();
    private boolean mIsPause = true;
    public boolean mgP;
    private boolean mnK = false;
    private Animation qzp;
    private String talker;
    public int yUA;
    private GridView yUB;
    C46938d yUC;
    private WeakReference<C44307a> yUD;
    private Boolean yUE;
    private Boolean yUF;
    private TextView yUG;
    private TextView yUH;
    private Runnable yUI = new C237671();
    private Runnable yUJ = new C407543();
    private long yUK = 0;
    Runnable yUL = new C156488();
    public View yUM = null;
    private View yUN;
    private int yUO = -1;
    private View yUP;
    private View yUQ;
    private View yUR;
    private View yUS;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI$8 */
    class C156488 implements Runnable {
        C156488() {
        }

        @TargetApi(12)
        public final void run() {
            AppMethodBeat.m2504i(32046);
            if (ImageGalleryGridUI.this.yUM != null) {
                ImageGalleryGridUI.this.yUM.setVisibility(8);
                ImageGalleryGridUI.this.yUM = null;
            }
            AppMethodBeat.m2505o(32046);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI$1 */
    class C237671 implements Runnable {
        C237671() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32034);
            if (!(ImageGalleryGridUI.this.yUB == null || ImageGalleryGridUI.this.yUB.getVisibility() == 4)) {
                ImageGalleryGridUI.this.yUB.setVisibility(4);
            }
            AppMethodBeat.m2505o(32034);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI$3 */
    class C407543 implements Runnable {
        C407543() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32036);
            if (!(ImageGalleryGridUI.this.yUB == null || ImageGalleryGridUI.this.yUB.getVisibility() == 0)) {
                ImageGalleryGridUI.this.yUB.setVisibility(0);
            }
            AppMethodBeat.m2505o(32036);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI$5 */
    class C407555 implements OnMenuItemClickListener {
        C407555() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(32039);
            ImageGalleryGridUI.this.onBackPressed();
            AppMethodBeat.m2505o(32039);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI$6 */
    class C443056 implements OnScrollListener {
        private Runnable kvR = new C156461();

        /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI$6$1 */
        class C156461 implements Runnable {
            C156461() {
            }

            public final void run() {
                AppMethodBeat.m2504i(32040);
                ImageGalleryGridUI.this.yUG.startAnimation(AnimationUtils.loadAnimation(ImageGalleryGridUI.this.mController.ylL, C25738R.anim.f8333b6));
                ImageGalleryGridUI.this.yUG.setVisibility(8);
                AppMethodBeat.m2505o(32040);
            }
        }

        C443056() {
            AppMethodBeat.m2504i(32041);
            AppMethodBeat.m2505o(32041);
        }

        /* renamed from: fQ */
        private void m80071fQ(boolean z) {
            AppMethodBeat.m2504i(32042);
            if (z) {
                ImageGalleryGridUI.this.yUG.removeCallbacks(this.kvR);
                if (ImageGalleryGridUI.this.yUG.getVisibility() != 0) {
                    ImageGalleryGridUI.this.yUG.clearAnimation();
                    Animation loadAnimation = AnimationUtils.loadAnimation(ImageGalleryGridUI.this.mController.ylL, C25738R.anim.f8332b5);
                    ImageGalleryGridUI.this.yUG.setVisibility(0);
                    ImageGalleryGridUI.this.yUG.startAnimation(loadAnimation);
                    AppMethodBeat.m2505o(32042);
                    return;
                }
            }
            ImageGalleryGridUI.this.yUG.removeCallbacks(this.kvR);
            ImageGalleryGridUI.this.yUG.postDelayed(this.kvR, 256);
            AppMethodBeat.m2505o(32042);
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(32043);
            if (1 == i) {
                m80071fQ(true);
            } else if (i == 0) {
                m80071fQ(false);
            }
            C32291o.ahp().mo43773cm(i);
            AppMethodBeat.m2505o(32043);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            CharSequence charSequence;
            AppMethodBeat.m2504i(32044);
            ImageGalleryGridUI imageGalleryGridUI = ImageGalleryGridUI.this;
            C7620bi c7620bi = (C7620bi) imageGalleryGridUI.yUC.getItem(i);
            if (c7620bi == null) {
                charSequence = null;
            } else {
                charSequence = C15894a.dJg().mo28137a(new Date(c7620bi.field_createTime), imageGalleryGridUI);
            }
            ImageGalleryGridUI.this.yUG.setText(charSequence);
            AppMethodBeat.m2505o(32044);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI$4 */
    class C443064 extends C4884c<C9362gs> {
        C443064() {
            AppMethodBeat.m2504i(32037);
            this.xxI = C9362gs.class.getName().hashCode();
            AppMethodBeat.m2505o(32037);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(32038);
            C9362gs c9362gs = (C9362gs) c4883b;
            ImageGalleryGridUI.m80074a(ImageGalleryGridUI.this, c9362gs.cBr.cBu, c9362gs);
            AppMethodBeat.m2505o(32038);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ImageGalleryGridUI() {
        AppMethodBeat.m2504i(32049);
        AppMethodBeat.m2505o(32049);
    }

    /* renamed from: fc */
    static /* synthetic */ void m80085fc(List list) {
        AppMethodBeat.m2504i(32082);
        ImageGalleryGridUI.m80083eY(list);
        AppMethodBeat.m2505o(32082);
    }

    public final int getLayoutId() {
        return 2130969850;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(32050);
        super.onCreate(bundle);
        this.mnK = true;
        this.handler = new C7306ak();
        m80072OW(0);
        C4879a.xxA.mo10052c(this.kvj);
        AppMethodBeat.m2505o(32050);
    }

    public final boolean dxT() {
        return true;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(32051);
        this.handler.removeCallbacks(this.yUJ);
        this.handler = null;
        C32291o.ahp().mo43773cm(0);
        C4879a.xxA.mo10053d(this.kvj);
        super.onDestroy();
        AppMethodBeat.m2505o(32051);
    }

    private void handleIntent(Intent intent) {
        boolean z = true;
        AppMethodBeat.m2504i(32054);
        if (intent.getIntExtra("kintent_intent_source", 0) != 1) {
            z = false;
        }
        this.yUE = Boolean.valueOf(z);
        this.talker = intent.getStringExtra("kintent_talker");
        this.yUA = intent.getIntExtra("kintent_image_index", 0);
        this.mgP = intent.getBooleanExtra("key_is_biz_chat", false);
        this.jMj = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.yUF = Boolean.TRUE;
        AppMethodBeat.m2505o(32054);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(32055);
        setIntent(intent);
        super.onNewIntent(intent);
        m80072OW(1);
        AppMethodBeat.m2505o(32055);
    }

    @TargetApi(11)
    /* renamed from: OW */
    private void m80072OW(int i) {
        AppMethodBeat.m2504i(32057);
        handleIntent(getIntent());
        setMMTitle(getString(C25738R.string.f8802ff));
        setBackBtn(new C407555());
        this.yUN = findViewById(2131824973);
        View findViewById = findViewById(2131824974);
        this.yUP = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(2131823944);
        this.yUQ = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(2131824975);
        this.yUR = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(2131822772);
        this.yUS = findViewById;
        findViewById.setOnClickListener(this);
        this.yUG = (TextView) findViewById(2131823946);
        this.yUH = (TextView) findViewById(2131824972);
        if (i == 0) {
            this.yUB = (GridView) findViewById(2131824971);
            this.yUB.setOnItemClickListener(this);
            this.yUB.setNumColumns(3);
            C7620bi c7620bi = new C7620bi();
            if (this.mgP) {
                c7620bi.mo14776eK(this.jMj);
            }
            this.yUC = new C46938d(this, c7620bi, this.talker);
            if (this.yUC.getCount() == 0) {
                this.yUH.setVisibility(0);
                AppMethodBeat.m2505o(32057);
                return;
            }
            this.yUH.setVisibility(8);
            this.yUB.setAdapter(this.yUC);
            dFR();
        } else if (this.yUC != null) {
            this.yUC.notifyDataSetChanged();
            dFR();
        }
        this.yUB.setOnScrollListener(new C443056());
        AppMethodBeat.m2505o(32057);
    }

    private void dFR() {
        AppMethodBeat.m2504i(32058);
        int firstVisiblePosition = this.yUB.getFirstVisiblePosition();
        int lastVisiblePosition = this.yUB.getLastVisiblePosition();
        int i = this.yUA;
        if (i < firstVisiblePosition || i > lastVisiblePosition) {
            this.yUB.setSelection(i);
            AppMethodBeat.m2505o(32058);
            return;
        }
        AppMethodBeat.m2505o(32058);
    }

    public void finish() {
        AppMethodBeat.m2504i(32059);
        super.finish();
        C15660a.yVE.detach();
        AppMethodBeat.m2505o(32059);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C8910b X;
        AppMethodBeat.m2504i(32060);
        C7620bi c7620bi = (C7620bi) this.yUC.getItem(i);
        String str = c7620bi.field_content;
        if (str != null) {
            X = C8910b.m16058X(str, c7620bi.field_reserved);
        } else {
            X = null;
        }
        String B;
        String str2;
        int i2;
        long j2;
        String by;
        PackageInfo packageInfo;
        Intent intent;
        Bundle bundle;
        Intent intent2;
        String C;
        String str3;
        if (X != null && X.type == 6) {
            m80081bz(c7620bi);
            AppMethodBeat.m2505o(32060);
        } else if (X != null && X.type == 3) {
            str = C35799p.m58684B(X.url, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            B = C35799p.m58684B(X.fgn, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            PackageInfo packageInfo2 = ImageGalleryGridUI.getPackageInfo(this.mController.ylL, X.appId);
            if (packageInfo2 == null) {
                str2 = null;
            } else {
                str2 = packageInfo2.versionName;
            }
            if (packageInfo2 == null) {
                i2 = 0;
            } else {
                i2 = packageInfo2.versionCode;
            }
            String str4 = X.appId;
            j2 = c7620bi.field_msgId;
            long j3 = c7620bi.field_msgSvrId;
            if ((str == null || str.length() == 0) && (B == null || B.length() == 0)) {
                C4990ab.m7412e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
                AppMethodBeat.m2505o(32060);
                return;
            }
            if (C5023at.isMobile(this.mController.ylL) ? B != null && B.length() > 0 : str == null || str.length() <= 0) {
                str = B;
            }
            Intent intent3 = new Intent();
            intent3.putExtra("msg_id", j2);
            intent3.putExtra("rawUrl", str);
            intent3.putExtra("version_name", str2);
            intent3.putExtra("version_code", i2);
            intent3.putExtra("usePlugin", true);
            intent3.putExtra("geta8key_username", this.talker);
            intent3.putExtra("KPublisherId", "msg_" + Long.toString(j3));
            intent3.putExtra("KAppId", str4);
            by = m80080by(c7620bi);
            intent3.putExtra("pre_username", by);
            intent3.putExtra("prePublishId", "msg_" + Long.toString(j3));
            if (c7620bi != null) {
                intent3.putExtra("preUsername", by);
            }
            intent3.putExtra("preChatName", this.talker);
            intent3.putExtra("preChatTYPE", C32798u.m53583ad(by, this.talker));
            intent3.putExtra("preMsgIndex", 0);
            C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent3);
            AppMethodBeat.m2505o(32060);
        } else if (X != null && X.type == 5) {
            if (!(X.url == null || X.url.equals(""))) {
                by = C35799p.m58684B(X.url, C1855t.m3896kH(this.talker) ? "groupmessage" : "singlemessage");
                str = X.url;
                packageInfo = ImageGalleryGridUI.getPackageInfo(this.mController.ylL, X.appId);
                intent = new Intent();
                intent.putExtra("rawUrl", by);
                intent.putExtra("webpageTitle", X.title);
                if (X.appId != null && ("wx751a1acca5688ba3".equals(X.appId) || "wxfbc915ff7c30e335".equals(X.appId) || "wx482a4001c37e2b74".equals(X.appId))) {
                    bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", X.appId);
                    intent.putExtra("jsapiargs", bundle);
                }
                if (C5046bo.isNullOrNil(str)) {
                    intent.putExtra("shortUrl", X.url);
                } else {
                    intent.putExtra("shortUrl", str);
                }
                intent.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
                intent.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
                if (!C5046bo.isNullOrNil(X.cMg)) {
                    intent.putExtra("srcUsername", X.cMg);
                    intent.putExtra("srcDisplayname", X.cMh);
                }
                intent.putExtra("msg_id", c7620bi.field_msgId);
                intent.putExtra("KPublisherId", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                intent.putExtra("KAppId", X.appId);
                intent.putExtra("geta8key_username", this.talker);
                by = m80080by(c7620bi);
                intent.putExtra("pre_username", by);
                intent.putExtra("prePublishId", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                intent.putExtra("preUsername", by);
                intent.putExtra("preChatName", this.talker);
                intent.putExtra("preChatTYPE", C32798u.m53583ad(by, this.talker));
                intent.putExtra("preMsgIndex", 0);
                C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(32060);
        } else if (X != null && X.type == 19) {
            intent2 = new Intent();
            intent2.putExtra("message_id", c7620bi.field_msgId);
            intent2.putExtra("record_xml", X.fgU);
            C25985d.m41467b(this.mController.ylL, "record", ".ui.RecordMsgDetailUI", intent2);
            AppMethodBeat.m2505o(32060);
        } else if (X != null && X.type == 24) {
            C32599lz c32599lz = new C32599lz();
            c32599lz.cHO.context = this.mController.ylL;
            c32599lz.cHO.cvx = c7620bi.field_msgId;
            c32599lz.cHO.cHP = X.fgU;
            C4879a.xxA.mo10055m(c32599lz);
            AppMethodBeat.m2505o(32060);
        } else if (X != null && X.type == 7) {
            C40439f bT = C46494g.m87739bT(X.appId, false);
            if (bT != null) {
                Object obj;
                by = this.talker;
                if (C1855t.m3896kH(by)) {
                    by = C1829bf.m3762oy(c7620bi.field_content);
                }
                j2 = c7620bi.field_msgSvrId;
                int i3 = (bT == null || !C35799p.m58695u(this.mController.ylL, bT.field_packageName)) ? 6 : 3;
                if (X.type == 2) {
                    i3 = 4;
                } else if (X.type == 5) {
                    i3 = 1;
                }
                C32607ok c32607ok = new C32607ok();
                c32607ok.cKI.context = this.mController.ylL;
                c32607ok.cKI.scene = 1;
                c32607ok.cKI.csB = X.appId;
                c32607ok.cKI.packageName = bT == null ? null : bT.field_packageName;
                c32607ok.cKI.msgType = X.type;
                c32607ok.cKI.cEV = by;
                c32607ok.cKI.cKJ = i3;
                c32607ok.cKI.mediaTagName = X.mediaTagName;
                c32607ok.cKI.cKK = j2;
                c32607ok.cKI.cKL = "";
                c32607ok.cKI.cst = this.talker;
                C4879a.xxA.mo10055m(c32607ok);
                C43155a bDb = C20928a.bDb();
                if (C46494g.m87726a(this.mController.ylL, bT) || bDb == null) {
                    obj = null;
                } else {
                    if (!C5046bo.isNullOrNil(bT.dng)) {
                        C4990ab.m7417i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", bT.dng, Boolean.valueOf(C35800q.m58699by(this.mController.ylL, bT.dng)));
                        if (C35800q.m58699by(this.mController.ylL, bT.dng)) {
                            obj = 1;
                        }
                    }
                    C9365gt c9365gt = new C9365gt();
                    c9365gt.cBv.actionCode = 2;
                    c9365gt.cBv.scene = 1;
                    c9365gt.cBv.appId = bT.field_appId;
                    c9365gt.cBv.context = this.mController.ylL;
                    C4879a.xxA.mo10055m(c9365gt);
                    Intent intent4 = new Intent();
                    bDb.mo36272W(bT.field_appId, 1, 1);
                    obj = 1;
                }
                if (obj == null) {
                    if (X.csD == null || X.csD.length() == 0) {
                        by = c7620bi.field_content;
                        if (c7620bi.field_isSend == 0) {
                            i3 = c7620bi.field_isSend;
                            if (!this.mgP && C1855t.m3896kH(this.talker) && by != null && i3 == 0) {
                                by = C1829bf.m3763oz(by);
                            }
                        }
                        C8910b me = C8910b.m16064me(by);
                        C40439f bT2 = C46494g.m87739bT(me.appId, true);
                        if (bT2 == null || !C35799p.m58695u(this.mController.ylL, bT2.field_packageName)) {
                            C = C35799p.m58685C(this.mController.ylL, me.appId, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                            intent2 = new Intent();
                            intent2.putExtra("rawUrl", C);
                            C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent2);
                        } else if (bT2.field_status == 3) {
                            C4990ab.m7412e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + bT2.field_packageName);
                            AppMethodBeat.m2505o(32060);
                            return;
                        } else if (!C35799p.m58689b(this.mController.ylL, bT2)) {
                            C4990ab.m7413e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", bT2.field_appName);
                            Toast.makeText(this.mController.ylL, getString(C25738R.string.c62, new Object[]{C46494g.m87733b(this.mController.ylL, bT2, null)}), 1).show();
                            AppMethodBeat.m2505o(32060);
                            return;
                        } else if (!m80076a(c7620bi, bT2)) {
                            WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                            wXAppExtendObject.extInfo = me.extInfo;
                            if (me.csD != null && me.csD.length() > 0) {
                                C30065b aiE = C14877am.aUq().aiE(me.csD);
                                wXAppExtendObject.filePath = aiE == null ? null : aiE.field_fileFullPath;
                            }
                            WXMediaMessage wXMediaMessage = new WXMediaMessage();
                            wXMediaMessage.sdkVer = Build.SDK_INT;
                            wXMediaMessage.mediaObject = wXAppExtendObject;
                            wXMediaMessage.title = me.title;
                            wXMediaMessage.description = me.description;
                            wXMediaMessage.messageAction = me.messageAction;
                            wXMediaMessage.messageExt = me.messageExt;
                            wXMediaMessage.thumbData = C5730e.m8632e(C32291o.ahl().mo73119sj(c7620bi.field_imgPath), 0, -1);
                            new C15584as(this).mo27752a(bT2.field_packageName, wXMediaMessage, bT2.field_appId, bT2.field_openId);
                            AppMethodBeat.m2505o(32060);
                            return;
                        }
                        AppMethodBeat.m2505o(32060);
                        return;
                    } else if (this.kuU) {
                        intent2 = new Intent();
                        intent2.setClassName(this.mController.ylL, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                        intent2.putExtra("app_msg_id", c7620bi.field_msgId);
                        startActivityForResult(intent2, 210);
                    } else {
                        C23639t.m36492hO(this.mController.ylL);
                        AppMethodBeat.m2505o(32060);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(32060);
        } else if (c7620bi.bws() || c7620bi.drE() || c7620bi.bwt() || c7620bi.dtA()) {
            Object obj2;
            if (X == null || C5046bo.isNullOrNil(X.fiG)) {
                obj2 = null;
            } else {
                int i4;
                by = c7620bi.field_imgPath;
                intent = new Intent();
                intent.putExtra("IsAd", false);
                intent.putExtra("KStremVideoUrl", X.fiG);
                intent.putExtra("KThumUrl", X.fiL);
                intent.putExtra("KThumbPath", by);
                intent.putExtra("KMediaId", "fakeid_" + c7620bi.field_msgId);
                intent.putExtra("KMediaVideoTime", X.fiH);
                intent.putExtra("StremWebUrl", X.fiK);
                intent.putExtra("StreamWording", X.fiJ);
                intent.putExtra("KMediaTitle", X.title);
                str = c7620bi.field_talker;
                boolean kH = C1855t.m3896kH(str);
                by = kH ? C1829bf.m3762oy(c7620bi.field_content) : str;
                intent.putExtra("KSta_StremVideoAduxInfo", X.fiM);
                intent.putExtra("KSta_StremVideoPublishId", X.fiN);
                intent.putExtra("KSta_SourceType", 1);
                String str5 = "KSta_Scene";
                if (kH) {
                    i4 = C40708b.TalkChat.value;
                } else {
                    i4 = C40708b.Chat.value;
                }
                intent.putExtra(str5, i4);
                intent.putExtra("KSta_FromUserName", by);
                intent.putExtra("KSta_ChatName", str);
                intent.putExtra("KSta_MsgId", c7620bi.field_msgSvrId);
                intent.putExtra("KSta_SnsStatExtStr", X.cMn);
                if (kH) {
                    intent.putExtra("KSta_ChatroomMembercount", C37921n.m64060mA(str));
                }
                C25985d.m41467b(this.mController.ylL, "sns", ".ui.VideoAdPlayerUI", intent);
                obj2 = 1;
            }
            if (obj2 != null) {
                AppMethodBeat.m2505o(32060);
                return;
            }
            m80078ak(view, i);
            AppMethodBeat.m2505o(32060);
        } else if (X != null && X.type == 15) {
            CharSequence charSequence = X.fgX;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35603Jk(X.url);
            }
            if (TextUtils.isEmpty(charSequence)) {
                Intent intent5 = new Intent();
                intent5.putExtra("geta8key_username", C1853r.m3846Yz());
                intent5.putExtra("rawUrl", X.url);
                C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent5);
                AppMethodBeat.m2505o(32060);
                return;
            }
            C4990ab.m7410d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
            intent2 = new Intent();
            intent2.putExtra("extra_id", charSequence);
            intent2.putExtra("preceding_scence", 123);
            intent2.putExtra("download_entrance_scene", 23);
            C25985d.m41467b(this.mController.ylL, "emoji", ".ui.EmojiStoreDetailUI", intent2);
            C7060h.pYm.mo8381e(10993, Integer.valueOf(2), charSequence);
            AppMethodBeat.m2505o(32060);
        } else if (X != null && X.type == 26) {
            i2 = X.tid;
            str = X.fiE;
            B = X.desc;
            str2 = X.iconUrl;
            str3 = X.secondUrl;
            if (i2 != 0) {
                Intent intent6 = new Intent();
                intent6.putExtra("geta8key_username", m80080by(c7620bi));
                intent6.putExtra("rawUrl", X.dJv);
                intent6.putExtra("topic_id", i2);
                intent6.putExtra("topic_name", str);
                intent6.putExtra("topic_desc", B);
                intent6.putExtra("topic_icon_url", str2);
                intent6.putExtra("topic_ad_url", str3);
                intent6.putExtra("extra_scence", 23);
                C25985d.m41467b(this.mController.ylL, "emoji", ".ui.EmojiStoreTopicUI", intent6);
                AppMethodBeat.m2505o(32060);
                return;
            }
            C4990ab.m7416i("MicroMsg.GalleryGridUI", "topic id is zero.");
            AppMethodBeat.m2505o(32060);
        } else if (X == null || X.type != 27) {
            C4990ab.m7417i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", c7620bi.field_talker, Long.valueOf(c7620bi.field_msgId), Integer.valueOf(c7620bi.getType()), c7620bi.field_content);
            if (!(X.url == null || X.url.equals("") || X.url == null || X.url.equals(""))) {
                by = C35799p.m58684B(X.url, C1855t.m3896kH(this.talker) ? "groupmessage" : "singlemessage");
                str = X.url;
                packageInfo = ImageGalleryGridUI.getPackageInfo(this.mController.ylL, X.appId);
                intent = new Intent();
                intent.putExtra("rawUrl", by);
                intent.putExtra("webpageTitle", X.title);
                if (X.appId != null && ("wx751a1acca5688ba3".equals(X.appId) || "wxfbc915ff7c30e335".equals(X.appId) || "wx482a4001c37e2b74".equals(X.appId))) {
                    bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", X.appId);
                    intent.putExtra("jsapiargs", bundle);
                }
                if (C5046bo.isNullOrNil(str)) {
                    intent.putExtra("shortUrl", X.url);
                } else {
                    intent.putExtra("shortUrl", str);
                }
                intent.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
                intent.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
                if (!C5046bo.isNullOrNil(X.cMg)) {
                    intent.putExtra("srcUsername", X.cMg);
                    intent.putExtra("srcDisplayname", X.cMh);
                }
                intent.putExtra("msg_id", c7620bi.field_msgId);
                intent.putExtra("KPublisherId", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                intent.putExtra("KAppId", X.appId);
                intent.putExtra("geta8key_username", C1853r.m3846Yz());
                intent.putExtra("pre_username", m80080by(c7620bi));
                intent.putExtra("prePublishId", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                C = m80080by(c7620bi);
                by = C1853r.m3846Yz();
                intent.putExtra("preUsername", C);
                intent.putExtra("preChatName", by);
                intent.putExtra("preChatTYPE", C32798u.m53583ad(C, by));
                intent.putExtra("preMsgIndex", 0);
                C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(32060);
        } else {
            i2 = X.tid;
            str = X.fiE;
            B = X.desc;
            str2 = X.iconUrl;
            str3 = X.secondUrl;
            int i5 = X.pageType;
            if (i2 != 0) {
                Intent intent7 = new Intent();
                intent7.putExtra("geta8key_username", m80080by(c7620bi));
                intent7.putExtra("rawUrl", X.dJv);
                intent7.putExtra("set_id", i2);
                intent7.putExtra("set_title", str);
                intent7.putExtra("set_iconURL", str2);
                intent7.putExtra("set_desc", B);
                intent7.putExtra("headurl", str3);
                intent7.putExtra("pageType", i5);
                C25985d.m41467b(this.mController.ylL, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent7);
                AppMethodBeat.m2505o(32060);
                return;
            }
            C4990ab.m7416i("MicroMsg.GalleryGridUI", "topic id is zero.");
            AppMethodBeat.m2505o(32060);
        }
    }

    /* renamed from: aO */
    private static String m80077aO(Context context, String str) {
        String str2;
        AppMethodBeat.m2504i(32062);
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                str2 = resolveInfo.activityInfo.name;
                AppMethodBeat.m2505o(32062);
                return str2;
            }
        } catch (NameNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
        }
        str2 = null;
        AppMethodBeat.m2505o(32062);
        return str2;
    }

    /* JADX WARNING: Missing block: B:7:0x0028, code skipped:
            if (r0.length() > 0) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: by */
    private String m80080by(C7620bi c7620bi) {
        AppMethodBeat.m2504i(32063);
        String bc = C5046bo.m7532bc(this.talker, "");
        boolean kH = C1855t.m3896kH(this.talker);
        if (kH) {
            String oy;
            if (kH) {
                oy = C1829bf.m3762oy(c7620bi.field_content);
                if (oy != null) {
                }
            }
            oy = bc;
            AppMethodBeat.m2505o(32063);
            return oy;
        }
        AppMethodBeat.m2505o(32063);
        return bc;
    }

    private boolean dFS() {
        AppMethodBeat.m2504i(32065);
        long j = this.yUK + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        this.yUK = currentTimeMillis;
        if (j < currentTimeMillis) {
            C9638aw.m17190ZK();
            this.kuU = C18628c.isSDCardAvailable();
        }
        boolean z = this.kuU;
        AppMethodBeat.m2505o(32065);
        return z;
    }

    /* renamed from: bz */
    private void m80081bz(C7620bi c7620bi) {
        AppMethodBeat.m2504i(32066);
        if (dFS()) {
            Intent intent = new Intent();
            intent.setClassName(this.mController.ylL, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", c7620bi.field_msgId);
            startActivity(intent);
            AppMethodBeat.m2505o(32066);
            return;
        }
        C23639t.m36492hO(this.mController.ylL);
        AppMethodBeat.m2505o(32066);
    }

    /* renamed from: ak */
    private void m80078ak(View view, int i) {
        AppMethodBeat.m2504i(32067);
        if (this.yUC == null) {
            AppMethodBeat.m2505o(32067);
            return;
        }
        Intent intent = new Intent(this, ImageGalleryUI.class);
        intent.putExtra("key_biz_chat_id", this.jMj);
        intent.putExtra("key_is_biz_chat", this.mgP);
        intent.putExtra("intent.key.with.footer", true);
        C7620bi c7620bi = (C7620bi) this.yUC.getItem(i);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(32067);
            return;
        }
        int i2 = getResources().getConfiguration().orientation;
        int i3 = 0;
        int i4 = 0;
        int[] iArr = new int[2];
        if (view != null) {
            i3 = view.getWidth();
            i4 = view.getHeight();
            view.getLocationInWindow(iArr);
        }
        intent.addFlags(536870912);
        intent.putExtra("img_gallery_msg_id", c7620bi.field_msgId).putExtra("img_gallery_msg_svr_id", c7620bi.field_msgSvrId).putExtra("img_gallery_talker", c7620bi.field_talker).putExtra("img_gallery_chatroom_name", c7620bi.field_talker).putExtra("img_gallery_orientation", i2);
        if (view != null) {
            intent.putExtra("img_gallery_width", i3).putExtra("img_gallery_height", i4).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
        } else {
            intent.putExtra("img_gallery_back_from_grid", true);
        }
        startActivity(intent);
        overridePendingTransition(0, 0);
        AppMethodBeat.m2505o(32067);
    }

    public boolean onPreDraw() {
        AppMethodBeat.m2504i(32068);
        C44307a c44307a = (C44307a) this.yUD.get();
        if (c44307a == null) {
            AppMethodBeat.m2505o(32068);
        } else {
            ViewTreeObserver viewTreeObserver = c44307a.mok.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
                int measuredWidth = c44307a.mok.getMeasuredWidth();
                int measuredHeight = c44307a.mok.getMeasuredHeight();
                if (measuredWidth <= 0 || measuredHeight <= 0) {
                    AppMethodBeat.m2505o(32068);
                } else {
                    LayoutParams layoutParams = (LayoutParams) c44307a.mom.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    c44307a.mom.setLayoutParams(layoutParams);
                    final ImageView imageView = c44307a.mom;
                    final DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
                    if (VERSION.SDK_INT >= 12) {
                        this.yUM = imageView;
                        this.handler.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(32045);
                                if (VERSION.SDK_INT >= 16) {
                                    imageView.animate().setDuration(500).alpha(0.0f).withEndAction(ImageGalleryGridUI.this.yUL).withLayer().setInterpolator(decelerateInterpolator);
                                    AppMethodBeat.m2505o(32045);
                                } else if (ImageGalleryGridUI.this.handler == null) {
                                    AppMethodBeat.m2505o(32045);
                                } else {
                                    imageView.animate().setDuration(500).alpha(0.0f).setInterpolator(decelerateInterpolator);
                                    ImageGalleryGridUI.this.handler.postDelayed(ImageGalleryGridUI.this.yUL, 500);
                                    AppMethodBeat.m2505o(32045);
                                }
                            }
                        }, 700);
                    }
                    AppMethodBeat.m2505o(32068);
                }
            } else {
                AppMethodBeat.m2505o(32068);
            }
        }
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        AppMethodBeat.m2504i(32069);
        if (menuItem.getTitle().equals(getString(C25738R.string.c39))) {
            C15660a.yVE.clear();
            bwq();
        } else {
            bwr();
        }
        AppMethodBeat.m2505o(32069);
        return false;
    }

    private void bwq() {
        AppMethodBeat.m2504i(32070);
        setMMTitle(getString(C25738R.string.c47, new Object[]{Integer.valueOf(C15660a.yVE.mnX.size())}));
        C15660a.yVE.mnY = true;
        if (this.yUC == null) {
            AppMethodBeat.m2505o(32070);
            return;
        }
        if (this.qzp == null) {
            this.qzp = AnimationUtils.loadAnimation(this, C25738R.anim.f8375cg);
        }
        this.yUC.bwq();
        this.yUN.setVisibility(0);
        this.yUN.startAnimation(this.qzp);
        this.yUP.setEnabled(false);
        this.yUQ.setEnabled(false);
        this.yUR.setEnabled(false);
        this.yUS.setEnabled(false);
        this.yUO = this.yUB.getPaddingBottom();
        this.yUB.setPadding(this.yUB.getPaddingLeft(), this.yUB.getPaddingTop(), this.yUB.getPaddingRight(), C1338a.m2856al(this.mController.ylL, C25738R.dimen.f10010nb));
        C7060h.pYm.mo8381e(11627, Integer.valueOf(2));
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(C25738R.string.c38), this);
        AppMethodBeat.m2505o(32070);
    }

    /* renamed from: eY */
    private static void m80083eY(List<C7620bi> list) {
        AppMethodBeat.m2504i(32074);
        for (C7620bi a : list) {
            C40707a.m70380a(C40706c.Fav, C23688d.Samll, a, 0);
        }
        AppMethodBeat.m2505o(32074);
    }

    /* renamed from: fb */
    private static List<C7620bi> m80084fb(List<C7620bi> list) {
        AppMethodBeat.m2504i(32075);
        ArrayList arrayList = new ArrayList();
        for (C7620bi c7620bi : list) {
            if (!(C40775c.m70565bp(c7620bi) || C40775c.m70566bq(c7620bi))) {
                arrayList.add(c7620bi);
            }
        }
        AppMethodBeat.m2505o(32075);
        return arrayList;
    }

    /* renamed from: c */
    private void m80082c(C45316cl c45316cl) {
        AppMethodBeat.m2504i(32076);
        c45316cl.cvA.activity = this;
        c45316cl.cvA.cvH = 45;
        C4879a.xxA.mo10055m(c45316cl);
        if (c45316cl.cvB.ret == -2 || c45316cl.cvB.ret > 0) {
            AppMethodBeat.m2505o(32076);
            return;
        }
        if (c45316cl.cvB.ret <= 0) {
            bwr();
            if (14 != c45316cl.cvA.type) {
                C4990ab.m7410d("MicroMsg.GalleryGridUI", "not record type, do not report");
                AppMethodBeat.m2505o(32076);
                return;
            } else if (c45316cl.cvA.cvD == null) {
                C4990ab.m7412e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
                AppMethodBeat.m2505o(32076);
                return;
            } else {
                C7060h.pYm.mo8381e(11142, Integer.valueOf(c45316cl.cvA.cvD.wiK), Integer.valueOf(c45316cl.cvA.cvD.wiL), Integer.valueOf(c45316cl.cvA.cvD.wiM), Integer.valueOf(c45316cl.cvA.cvD.wiN), Integer.valueOf(c45316cl.cvA.cvD.wiO), Integer.valueOf(c45316cl.cvA.cvD.wiP), Integer.valueOf(c45316cl.cvA.cvD.wiQ), Integer.valueOf(c45316cl.cvA.cvD.fileCount), Integer.valueOf(c45316cl.cvA.cvD.wiR), Integer.valueOf(c45316cl.cvA.cvD.wiS), Integer.valueOf(c45316cl.cvA.cvD.wiT), Integer.valueOf(c45316cl.cvA.cvD.wiU), Integer.valueOf(c45316cl.cvA.cvD.wiV), Integer.valueOf(c45316cl.cvA.cvD.wiW), Integer.valueOf(c45316cl.cvA.cvD.wiX));
            }
        }
        AppMethodBeat.m2505o(32076);
    }

    public final void dFU() {
        AppMethodBeat.m2504i(32077);
        if (this.yUC != null && this.mIsPause) {
            this.yUC.yUt = true;
        }
        setMMTitle(getString(C25738R.string.c47, new Object[]{Integer.valueOf(C15660a.yVE.mnX.size())}));
        dFT();
        AppMethodBeat.m2505o(32077);
    }

    public final void clear() {
        AppMethodBeat.m2504i(32078);
        if (this.yUC != null && this.mIsPause) {
            this.yUC.yUt = true;
        }
        dFT();
        AppMethodBeat.m2505o(32078);
    }

    public final void dCI() {
    }

    /* renamed from: a */
    public final void mo27932a(C23699a c23699a) {
    }

    public final boolean dCJ() {
        return true;
    }

    /* renamed from: b */
    public final void mo27933b(C23699a c23699a) {
        AppMethodBeat.m2504i(32079);
        if (c23699a == C23699a.del) {
            this.yUC.mo6869KC();
            this.yUC.notifyDataSetChanged();
        }
        bwr();
        AppMethodBeat.m2505o(32079);
    }

    public void onResume() {
        AppMethodBeat.m2504i(32052);
        C15660a.yVE.mo27886a(this);
        this.mIsPause = false;
        if (this.mnK) {
            if (C15660a.yVE.mnY) {
                bwq();
            } else {
                bwr();
            }
        }
        this.handler.postDelayed(this.yUJ, 300);
        super.onResume();
        if (this.yUC != null) {
            this.yUC.yUt = true;
            C46938d c46938d = this.yUC;
            if (c46938d.yUt) {
                c46938d.notifyDataSetChanged();
            }
            if (C15660a.yVE.mnY) {
                setMMTitle(getString(C25738R.string.c47, new Object[]{Integer.valueOf(C15660a.yVE.mnX.size())}));
            }
        }
        this.mnK = false;
        dFT();
        AppMethodBeat.m2505o(32052);
    }

    public void onPause() {
        AppMethodBeat.m2504i(32053);
        C15660a.yVE.mnZ.remove(this);
        this.mIsPause = true;
        super.onPause();
        AppMethodBeat.m2505o(32053);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(32056);
        if (C15660a.yVE.mnY) {
            bwr();
            AppMethodBeat.m2505o(32056);
        } else if (this.yUE.booleanValue()) {
            super.onBackPressed();
            AppMethodBeat.m2505o(32056);
        } else {
            if (this.yUA >= 0) {
                m80078ak(null, this.yUA);
            }
            finish();
            AppMethodBeat.m2505o(32056);
        }
    }

    /* renamed from: a */
    private boolean m80076a(C7620bi c7620bi, C40439f c40439f) {
        AppMethodBeat.m2504i(32061);
        if (c7620bi.field_talker.endsWith("@qqim") && c40439f.field_packageName.equals(TbsConfig.APP_QQ)) {
            int i;
            C4990ab.m7410d("MicroMsg.GalleryGridUI", "jacks open QQ");
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setClassName(TbsConfig.APP_QQ, ImageGalleryGridUI.m80077aO(this.mController.ylL, TbsConfig.APP_QQ));
            intent.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
            C9638aw.m17190ZK();
            Object obj = C18628c.m29072Ry().get(9, null);
            if (obj == null || !(obj instanceof Integer)) {
                i = 0;
            } else {
                i = ((Integer) obj).intValue();
            }
            if (i != 0) {
                try {
                    byte[] bytes = String.valueOf(i).getBytes(ProtocolPackage.ServerEncoding);
                    byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                    int length = bytes2.length;
                    i = 0;
                    int i2 = 0;
                    while (i < length) {
                        byte b = bytes2[i];
                        if (i2 >= bytes.length) {
                            break;
                        }
                        int i3 = i2 + 1;
                        bytes[i2] = (byte) (b ^ bytes[i2]);
                        i++;
                        i2 = i3;
                    }
                    intent.putExtra("tencent_gif", bytes);
                } catch (UnsupportedEncodingException e) {
                    C4990ab.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
                }
            }
            try {
                startActivity(intent);
            } catch (Exception e2) {
            }
            AppMethodBeat.m2505o(32061);
            return true;
        }
        AppMethodBeat.m2505o(32061);
        return false;
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        AppMethodBeat.m2504i(32064);
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            C40439f bT = C46494g.m87739bT(str, true);
            if (bT == null) {
                Object str22 = packageInfo;
            } else {
                str22 = bT.field_packageName;
            }
        }
        if (str22 == null) {
            AppMethodBeat.m2505o(32064);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str22, 0);
                AppMethodBeat.m2505o(32064);
            } catch (NameNotFoundException e) {
                C4990ab.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
                AppMethodBeat.m2505o(32064);
            }
        }
        return packageInfo;
    }

    private void dFT() {
        AppMethodBeat.m2504i(32071);
        boolean z = !C15660a.yVE.mnX.isEmpty() && C15660a.yVE.mnY;
        if (z) {
            this.yUP.setEnabled(true);
            this.yUQ.setEnabled(true);
            this.yUR.setEnabled(true);
            this.yUS.setEnabled(true);
            AppMethodBeat.m2505o(32071);
            return;
        }
        this.yUP.setEnabled(false);
        this.yUQ.setEnabled(false);
        this.yUR.setEnabled(false);
        this.yUS.setEnabled(false);
        AppMethodBeat.m2505o(32071);
    }

    public final void bwr() {
        AppMethodBeat.m2504i(32072);
        C15660a.yVE.mnY = false;
        setMMTitle(getString(C25738R.string.f8802ff));
        if (this.yUC == null) {
            AppMethodBeat.m2505o(32072);
            return;
        }
        this.yUC.notifyDataSetChanged();
        if (this.yUO >= 0) {
            this.yUB.setPadding(this.yUB.getPaddingLeft(), this.yUB.getPaddingTop(), this.yUB.getPaddingRight(), this.yUO);
        }
        this.yUN.setVisibility(8);
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(C25738R.string.c39), this);
        AppMethodBeat.m2505o(32072);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(32073);
        if (C15660a.yVE.mnX.isEmpty()) {
            AppMethodBeat.m2505o(32073);
            return;
        }
        boolean kH = C1855t.m3896kH(this.talker);
        final List<C7620bi> list = C15660a.yVE.mnX;
        C7620bi c7620bi;
        String str;
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(32073);
        } else if (view.getId() == 2131822772) {
            C7060h.pYm.mo8381e(11627, Integer.valueOf(5));
            final TreeSet treeSet = new TreeSet();
            for (C7620bi c7620bi2 : list) {
                treeSet.add(Long.valueOf(c7620bi2.field_msgId));
            }
            C30379h.m48466d(this, getString(C25738R.string.at7), "", getString(C25738R.string.b59), getString(C25738R.string.f9076or), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(32047);
                    C4990ab.m7416i("MicroMsg.GalleryGridUI", "delete message");
                    C44308i.m80089a(ImageGalleryGridUI.this, treeSet, ImageGalleryGridUI.this);
                    ImageGalleryGridUI.this.bwr();
                    AppMethodBeat.m2505o(32047);
                }
            }, null);
            AppMethodBeat.m2505o(32073);
        } else if (view.getId() == 2131824974) {
            C7060h.pYm.mo8378a(219, 18, 1, true);
            final C45316cl c45316cl = new C45316cl();
            if (C40444g.m69402a(this.mController.ylL, c45316cl, this.talker, list, false)) {
                m80082c(c45316cl);
                ImageGalleryGridUI.m80083eY(list);
                AppMethodBeat.m2505o(32073);
            } else if (list.size() > 1) {
                String string;
                String string2;
                AppCompatActivity appCompatActivity = this.mController.ylL;
                if (c45316cl.cvA.cvG >= 0) {
                    string = this.mController.ylL.getString(C25738R.string.bov);
                } else {
                    string = this.mController.ylL.getString(C25738R.string.bou);
                }
                str = "";
                if (c45316cl.cvA.cvG >= 0) {
                    string2 = this.mController.ylL.getString(C25738R.string.atd);
                } else {
                    string2 = this.mController.ylL.getString(C25738R.string.dcq);
                }
                C30379h.m48466d(appCompatActivity, string, str, string2, this.mController.ylL.getString(C25738R.string.atb), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(32048);
                        if (c45316cl.cvA.type == 14 && c45316cl.cvA.cvC.wiv.size() == 0) {
                            ImageGalleryGridUI.this.bwr();
                            AppMethodBeat.m2505o(32048);
                            return;
                        }
                        ImageGalleryGridUI.m80075a(ImageGalleryGridUI.this, c45316cl);
                        ImageGalleryGridUI.m80085fc(list);
                        AppMethodBeat.m2505o(32048);
                    }
                }, null);
                AppMethodBeat.m2505o(32073);
            } else {
                C30379h.m48467g(this.mController.ylL, c45316cl.cvA.cvG, 0);
                AppMethodBeat.m2505o(32073);
            }
        } else if (view.getId() == 2131823944) {
            C7060h.pYm.mo8378a(219, 19, 1, true);
            C46660k.m88358a(this, list, kH, this.talker, this);
            bwr();
            AppMethodBeat.m2505o(32073);
        } else {
            C7060h.pYm.mo8381e(11627, Integer.valueOf(3));
            final List fb = ImageGalleryGridUI.m80084fb(list);
            if (fb.size() != list.size()) {
                C30379h.m48432a(this.mController.ylL, (int) C25738R.string.c3v, (int) C25738R.string.f9238tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(32035);
                        C40775c.m70573f(ImageGalleryGridUI.this.mController.ylL, fb);
                        ImageGalleryGridUI.this.bwr();
                        AppMethodBeat.m2505o(32035);
                    }
                }, null);
                AppMethodBeat.m2505o(32073);
                return;
            }
            c7620bi2 = (C7620bi) fb.get(0);
            if (list.size() == 1 && c7620bi2 != null && c7620bi2.bAA()) {
                str = c7620bi2.field_content;
                C8910b c8910b = null;
                if (str != null) {
                    c8910b = C8910b.m16058X(str, c7620bi2.field_reserved);
                }
                if (c8910b != null && c8910b.type == 6) {
                    m80081bz(c7620bi2);
                }
                AppMethodBeat.m2505o(32073);
                return;
            }
            C40775c.m70573f((Context) this, (List) list);
            bwr();
            AppMethodBeat.m2505o(32073);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m80074a(ImageGalleryGridUI imageGalleryGridUI, int i, C9362gs c9362gs) {
        AppMethodBeat.m2504i(32080);
        if (imageGalleryGridUI.yUB != null) {
            int firstVisiblePosition = imageGalleryGridUI.yUB.getFirstVisiblePosition();
            int lastVisiblePosition = imageGalleryGridUI.yUB.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = imageGalleryGridUI.yUB.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    c9362gs.cBs.ctT = iArr[0];
                    c9362gs.cBs.ctU = iArr[1];
                    c9362gs.cBs.ctV = childAt.getWidth();
                    c9362gs.cBs.ctW = childAt.getHeight();
                }
            }
        }
        AppMethodBeat.m2505o(32080);
    }
}
