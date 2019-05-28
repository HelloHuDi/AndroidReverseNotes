package com.tencent.mm.ui.chatting.gallery;

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
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.as;
import com.tencent.mm.ui.chatting.gallery.h.b;
import com.tencent.mm.ui.chatting.i;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.vfs.e;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

@a(19)
public class ImageGalleryGridUI extends MMActivity implements OnMenuItemClickListener, OnClickListener, OnPreDrawListener, OnItemClickListener, ah, b {
    protected ak handler;
    public long jMj;
    private boolean kuU = false;
    private c kvj = new c<gs>() {
        {
            AppMethodBeat.i(32037);
            this.xxI = gs.class.getName().hashCode();
            AppMethodBeat.o(32037);
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(32038);
            gs gsVar = (gs) bVar;
            ImageGalleryGridUI.a(ImageGalleryGridUI.this, gsVar.cBr.cBu, gsVar);
            AppMethodBeat.o(32038);
            return false;
        }
    };
    private boolean mIsPause = true;
    public boolean mgP;
    private boolean mnK = false;
    private Animation qzp;
    private String talker;
    public int yUA;
    private GridView yUB;
    d yUC;
    private WeakReference<a> yUD;
    private Boolean yUE;
    private Boolean yUF;
    private TextView yUG;
    private TextView yUH;
    private Runnable yUI = new Runnable() {
        public final void run() {
            AppMethodBeat.i(32034);
            if (!(ImageGalleryGridUI.this.yUB == null || ImageGalleryGridUI.this.yUB.getVisibility() == 4)) {
                ImageGalleryGridUI.this.yUB.setVisibility(4);
            }
            AppMethodBeat.o(32034);
        }
    };
    private Runnable yUJ = new Runnable() {
        public final void run() {
            AppMethodBeat.i(32036);
            if (!(ImageGalleryGridUI.this.yUB == null || ImageGalleryGridUI.this.yUB.getVisibility() == 0)) {
                ImageGalleryGridUI.this.yUB.setVisibility(0);
            }
            AppMethodBeat.o(32036);
        }
    };
    private long yUK = 0;
    Runnable yUL = new Runnable() {
        @TargetApi(12)
        public final void run() {
            AppMethodBeat.i(32046);
            if (ImageGalleryGridUI.this.yUM != null) {
                ImageGalleryGridUI.this.yUM.setVisibility(8);
                ImageGalleryGridUI.this.yUM = null;
            }
            AppMethodBeat.o(32046);
        }
    };
    public View yUM = null;
    private View yUN;
    private int yUO = -1;
    private View yUP;
    private View yUQ;
    private View yUR;
    private View yUS;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ImageGalleryGridUI() {
        AppMethodBeat.i(32049);
        AppMethodBeat.o(32049);
    }

    static /* synthetic */ void fc(List list) {
        AppMethodBeat.i(32082);
        eY(list);
        AppMethodBeat.o(32082);
    }

    public final int getLayoutId() {
        return R.layout.a7m;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(32050);
        super.onCreate(bundle);
        this.mnK = true;
        this.handler = new ak();
        OW(0);
        com.tencent.mm.sdk.b.a.xxA.c(this.kvj);
        AppMethodBeat.o(32050);
    }

    public final boolean dxT() {
        return true;
    }

    public void onDestroy() {
        AppMethodBeat.i(32051);
        this.handler.removeCallbacks(this.yUJ);
        this.handler = null;
        o.ahp().cm(0);
        com.tencent.mm.sdk.b.a.xxA.d(this.kvj);
        super.onDestroy();
        AppMethodBeat.o(32051);
    }

    private void handleIntent(Intent intent) {
        boolean z = true;
        AppMethodBeat.i(32054);
        if (intent.getIntExtra("kintent_intent_source", 0) != 1) {
            z = false;
        }
        this.yUE = Boolean.valueOf(z);
        this.talker = intent.getStringExtra("kintent_talker");
        this.yUA = intent.getIntExtra("kintent_image_index", 0);
        this.mgP = intent.getBooleanExtra("key_is_biz_chat", false);
        this.jMj = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.yUF = Boolean.TRUE;
        AppMethodBeat.o(32054);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(32055);
        setIntent(intent);
        super.onNewIntent(intent);
        OW(1);
        AppMethodBeat.o(32055);
    }

    @TargetApi(11)
    private void OW(int i) {
        AppMethodBeat.i(32057);
        handleIntent(getIntent());
        setMMTitle(getString(R.string.ff));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(32039);
                ImageGalleryGridUI.this.onBackPressed();
                AppMethodBeat.o(32039);
                return true;
            }
        });
        this.yUN = findViewById(R.id.chp);
        View findViewById = findViewById(R.id.chq);
        this.yUP = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.id.bqw);
        this.yUQ = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.id.chr);
        this.yUR = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.id.aw8);
        this.yUS = findViewById;
        findViewById.setOnClickListener(this);
        this.yUG = (TextView) findViewById(R.id.bqy);
        this.yUH = (TextView) findViewById(R.id.cho);
        if (i == 0) {
            this.yUB = (GridView) findViewById(R.id.chn);
            this.yUB.setOnItemClickListener(this);
            this.yUB.setNumColumns(3);
            bi biVar = new bi();
            if (this.mgP) {
                biVar.eK(this.jMj);
            }
            this.yUC = new d(this, biVar, this.talker);
            if (this.yUC.getCount() == 0) {
                this.yUH.setVisibility(0);
                AppMethodBeat.o(32057);
                return;
            }
            this.yUH.setVisibility(8);
            this.yUB.setAdapter(this.yUC);
            dFR();
        } else if (this.yUC != null) {
            this.yUC.notifyDataSetChanged();
            dFR();
        }
        this.yUB.setOnScrollListener(new OnScrollListener() {
            private Runnable kvR = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(32040);
                    ImageGalleryGridUI.this.yUG.startAnimation(AnimationUtils.loadAnimation(ImageGalleryGridUI.this.mController.ylL, R.anim.b6));
                    ImageGalleryGridUI.this.yUG.setVisibility(8);
                    AppMethodBeat.o(32040);
                }
            };

            {
                AppMethodBeat.i(32041);
                AppMethodBeat.o(32041);
            }

            private void fQ(boolean z) {
                AppMethodBeat.i(32042);
                if (z) {
                    ImageGalleryGridUI.this.yUG.removeCallbacks(this.kvR);
                    if (ImageGalleryGridUI.this.yUG.getVisibility() != 0) {
                        ImageGalleryGridUI.this.yUG.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(ImageGalleryGridUI.this.mController.ylL, R.anim.b5);
                        ImageGalleryGridUI.this.yUG.setVisibility(0);
                        ImageGalleryGridUI.this.yUG.startAnimation(loadAnimation);
                        AppMethodBeat.o(32042);
                        return;
                    }
                }
                ImageGalleryGridUI.this.yUG.removeCallbacks(this.kvR);
                ImageGalleryGridUI.this.yUG.postDelayed(this.kvR, 256);
                AppMethodBeat.o(32042);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(32043);
                if (1 == i) {
                    fQ(true);
                } else if (i == 0) {
                    fQ(false);
                }
                o.ahp().cm(i);
                AppMethodBeat.o(32043);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                CharSequence charSequence;
                AppMethodBeat.i(32044);
                ImageGalleryGridUI imageGalleryGridUI = ImageGalleryGridUI.this;
                bi biVar = (bi) imageGalleryGridUI.yUC.getItem(i);
                if (biVar == null) {
                    charSequence = null;
                } else {
                    charSequence = com.tencent.mm.ui.gridviewheaders.a.dJg().a(new Date(biVar.field_createTime), imageGalleryGridUI);
                }
                ImageGalleryGridUI.this.yUG.setText(charSequence);
                AppMethodBeat.o(32044);
            }
        });
        AppMethodBeat.o(32057);
    }

    private void dFR() {
        AppMethodBeat.i(32058);
        int firstVisiblePosition = this.yUB.getFirstVisiblePosition();
        int lastVisiblePosition = this.yUB.getLastVisiblePosition();
        int i = this.yUA;
        if (i < firstVisiblePosition || i > lastVisiblePosition) {
            this.yUB.setSelection(i);
            AppMethodBeat.o(32058);
            return;
        }
        AppMethodBeat.o(32058);
    }

    public void finish() {
        AppMethodBeat.i(32059);
        super.finish();
        h.a.yVE.detach();
        AppMethodBeat.o(32059);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j.b X;
        AppMethodBeat.i(32060);
        bi biVar = (bi) this.yUC.getItem(i);
        String str = biVar.field_content;
        if (str != null) {
            X = j.b.X(str, biVar.field_reserved);
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
            bz(biVar);
            AppMethodBeat.o(32060);
        } else if (X != null && X.type == 3) {
            str = p.B(X.url, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            B = p.B(X.fgn, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            PackageInfo packageInfo2 = getPackageInfo(this.mController.ylL, X.appId);
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
            j2 = biVar.field_msgId;
            long j3 = biVar.field_msgSvrId;
            if ((str == null || str.length() == 0) && (B == null || B.length() == 0)) {
                ab.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
                AppMethodBeat.o(32060);
                return;
            }
            if (at.isMobile(this.mController.ylL) ? B != null && B.length() > 0 : str == null || str.length() <= 0) {
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
            by = by(biVar);
            intent3.putExtra("pre_username", by);
            intent3.putExtra("prePublishId", "msg_" + Long.toString(j3));
            if (biVar != null) {
                intent3.putExtra("preUsername", by);
            }
            intent3.putExtra("preChatName", this.talker);
            intent3.putExtra("preChatTYPE", u.ad(by, this.talker));
            intent3.putExtra("preMsgIndex", 0);
            d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent3);
            AppMethodBeat.o(32060);
        } else if (X != null && X.type == 5) {
            if (!(X.url == null || X.url.equals(""))) {
                by = p.B(X.url, t.kH(this.talker) ? "groupmessage" : "singlemessage");
                str = X.url;
                packageInfo = getPackageInfo(this.mController.ylL, X.appId);
                intent = new Intent();
                intent.putExtra("rawUrl", by);
                intent.putExtra("webpageTitle", X.title);
                if (X.appId != null && ("wx751a1acca5688ba3".equals(X.appId) || "wxfbc915ff7c30e335".equals(X.appId) || "wx482a4001c37e2b74".equals(X.appId))) {
                    bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", X.appId);
                    intent.putExtra("jsapiargs", bundle);
                }
                if (bo.isNullOrNil(str)) {
                    intent.putExtra("shortUrl", X.url);
                } else {
                    intent.putExtra("shortUrl", str);
                }
                intent.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
                intent.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
                if (!bo.isNullOrNil(X.cMg)) {
                    intent.putExtra("srcUsername", X.cMg);
                    intent.putExtra("srcDisplayname", X.cMh);
                }
                intent.putExtra("msg_id", biVar.field_msgId);
                intent.putExtra("KPublisherId", "msg_" + Long.toString(biVar.field_msgSvrId));
                intent.putExtra("KAppId", X.appId);
                intent.putExtra("geta8key_username", this.talker);
                by = by(biVar);
                intent.putExtra("pre_username", by);
                intent.putExtra("prePublishId", "msg_" + Long.toString(biVar.field_msgSvrId));
                intent.putExtra("preUsername", by);
                intent.putExtra("preChatName", this.talker);
                intent.putExtra("preChatTYPE", u.ad(by, this.talker));
                intent.putExtra("preMsgIndex", 0);
                d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.o(32060);
        } else if (X != null && X.type == 19) {
            intent2 = new Intent();
            intent2.putExtra("message_id", biVar.field_msgId);
            intent2.putExtra("record_xml", X.fgU);
            d.b(this.mController.ylL, "record", ".ui.RecordMsgDetailUI", intent2);
            AppMethodBeat.o(32060);
        } else if (X != null && X.type == 24) {
            lz lzVar = new lz();
            lzVar.cHO.context = this.mController.ylL;
            lzVar.cHO.cvx = biVar.field_msgId;
            lzVar.cHO.cHP = X.fgU;
            com.tencent.mm.sdk.b.a.xxA.m(lzVar);
            AppMethodBeat.o(32060);
        } else if (X != null && X.type == 7) {
            f bT = g.bT(X.appId, false);
            if (bT != null) {
                Object obj;
                by = this.talker;
                if (t.kH(by)) {
                    by = bf.oy(biVar.field_content);
                }
                j2 = biVar.field_msgSvrId;
                int i3 = (bT == null || !p.u(this.mController.ylL, bT.field_packageName)) ? 6 : 3;
                if (X.type == 2) {
                    i3 = 4;
                } else if (X.type == 5) {
                    i3 = 1;
                }
                ok okVar = new ok();
                okVar.cKI.context = this.mController.ylL;
                okVar.cKI.scene = 1;
                okVar.cKI.csB = X.appId;
                okVar.cKI.packageName = bT == null ? null : bT.field_packageName;
                okVar.cKI.msgType = X.type;
                okVar.cKI.cEV = by;
                okVar.cKI.cKJ = i3;
                okVar.cKI.mediaTagName = X.mediaTagName;
                okVar.cKI.cKK = j2;
                okVar.cKI.cKL = "";
                okVar.cKI.cst = this.talker;
                com.tencent.mm.sdk.b.a.xxA.m(okVar);
                com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
                if (g.a(this.mController.ylL, bT) || bDb == null) {
                    obj = null;
                } else {
                    if (!bo.isNullOrNil(bT.dng)) {
                        ab.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", bT.dng, Boolean.valueOf(q.by(this.mController.ylL, bT.dng)));
                        if (q.by(this.mController.ylL, bT.dng)) {
                            obj = 1;
                        }
                    }
                    gt gtVar = new gt();
                    gtVar.cBv.actionCode = 2;
                    gtVar.cBv.scene = 1;
                    gtVar.cBv.appId = bT.field_appId;
                    gtVar.cBv.context = this.mController.ylL;
                    com.tencent.mm.sdk.b.a.xxA.m(gtVar);
                    Intent intent4 = new Intent();
                    bDb.W(bT.field_appId, 1, 1);
                    obj = 1;
                }
                if (obj == null) {
                    if (X.csD == null || X.csD.length() == 0) {
                        by = biVar.field_content;
                        if (biVar.field_isSend == 0) {
                            i3 = biVar.field_isSend;
                            if (!this.mgP && t.kH(this.talker) && by != null && i3 == 0) {
                                by = bf.oz(by);
                            }
                        }
                        j.b me = j.b.me(by);
                        f bT2 = g.bT(me.appId, true);
                        if (bT2 == null || !p.u(this.mController.ylL, bT2.field_packageName)) {
                            C = p.C(this.mController.ylL, me.appId, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                            intent2 = new Intent();
                            intent2.putExtra("rawUrl", C);
                            d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent2);
                        } else if (bT2.field_status == 3) {
                            ab.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + bT2.field_packageName);
                            AppMethodBeat.o(32060);
                            return;
                        } else if (!p.b(this.mController.ylL, bT2)) {
                            ab.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", bT2.field_appName);
                            Toast.makeText(this.mController.ylL, getString(R.string.c62, new Object[]{g.b(this.mController.ylL, bT2, null)}), 1).show();
                            AppMethodBeat.o(32060);
                            return;
                        } else if (!a(biVar, bT2)) {
                            WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                            wXAppExtendObject.extInfo = me.extInfo;
                            if (me.csD != null && me.csD.length() > 0) {
                                com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(me.csD);
                                wXAppExtendObject.filePath = aiE == null ? null : aiE.field_fileFullPath;
                            }
                            WXMediaMessage wXMediaMessage = new WXMediaMessage();
                            wXMediaMessage.sdkVer = Build.SDK_INT;
                            wXMediaMessage.mediaObject = wXAppExtendObject;
                            wXMediaMessage.title = me.title;
                            wXMediaMessage.description = me.description;
                            wXMediaMessage.messageAction = me.messageAction;
                            wXMediaMessage.messageExt = me.messageExt;
                            wXMediaMessage.thumbData = e.e(o.ahl().sj(biVar.field_imgPath), 0, -1);
                            new as(this).a(bT2.field_packageName, wXMediaMessage, bT2.field_appId, bT2.field_openId);
                            AppMethodBeat.o(32060);
                            return;
                        }
                        AppMethodBeat.o(32060);
                        return;
                    } else if (this.kuU) {
                        intent2 = new Intent();
                        intent2.setClassName(this.mController.ylL, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                        intent2.putExtra("app_msg_id", biVar.field_msgId);
                        startActivityForResult(intent2, 210);
                    } else {
                        com.tencent.mm.ui.base.t.hO(this.mController.ylL);
                        AppMethodBeat.o(32060);
                        return;
                    }
                }
            }
            AppMethodBeat.o(32060);
        } else if (biVar.bws() || biVar.drE() || biVar.bwt() || biVar.dtA()) {
            Object obj2;
            if (X == null || bo.isNullOrNil(X.fiG)) {
                obj2 = null;
            } else {
                int i4;
                by = biVar.field_imgPath;
                intent = new Intent();
                intent.putExtra("IsAd", false);
                intent.putExtra("KStremVideoUrl", X.fiG);
                intent.putExtra("KThumUrl", X.fiL);
                intent.putExtra("KThumbPath", by);
                intent.putExtra("KMediaId", "fakeid_" + biVar.field_msgId);
                intent.putExtra("KMediaVideoTime", X.fiH);
                intent.putExtra("StremWebUrl", X.fiK);
                intent.putExtra("StreamWording", X.fiJ);
                intent.putExtra("KMediaTitle", X.title);
                str = biVar.field_talker;
                boolean kH = t.kH(str);
                by = kH ? bf.oy(biVar.field_content) : str;
                intent.putExtra("KSta_StremVideoAduxInfo", X.fiM);
                intent.putExtra("KSta_StremVideoPublishId", X.fiN);
                intent.putExtra("KSta_SourceType", 1);
                String str5 = "KSta_Scene";
                if (kH) {
                    i4 = com.tencent.mm.ui.chatting.a.b.TalkChat.value;
                } else {
                    i4 = com.tencent.mm.ui.chatting.a.b.Chat.value;
                }
                intent.putExtra(str5, i4);
                intent.putExtra("KSta_FromUserName", by);
                intent.putExtra("KSta_ChatName", str);
                intent.putExtra("KSta_MsgId", biVar.field_msgSvrId);
                intent.putExtra("KSta_SnsStatExtStr", X.cMn);
                if (kH) {
                    intent.putExtra("KSta_ChatroomMembercount", n.mA(str));
                }
                d.b(this.mController.ylL, "sns", ".ui.VideoAdPlayerUI", intent);
                obj2 = 1;
            }
            if (obj2 != null) {
                AppMethodBeat.o(32060);
                return;
            }
            ak(view, i);
            AppMethodBeat.o(32060);
        } else if (X != null && X.type == 15) {
            CharSequence charSequence = X.fgX;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jk(X.url);
            }
            if (TextUtils.isEmpty(charSequence)) {
                Intent intent5 = new Intent();
                intent5.putExtra("geta8key_username", r.Yz());
                intent5.putExtra("rawUrl", X.url);
                d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent5);
                AppMethodBeat.o(32060);
                return;
            }
            ab.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
            intent2 = new Intent();
            intent2.putExtra("extra_id", charSequence);
            intent2.putExtra("preceding_scence", 123);
            intent2.putExtra("download_entrance_scene", 23);
            d.b(this.mController.ylL, "emoji", ".ui.EmojiStoreDetailUI", intent2);
            h.pYm.e(10993, Integer.valueOf(2), charSequence);
            AppMethodBeat.o(32060);
        } else if (X != null && X.type == 26) {
            i2 = X.tid;
            str = X.fiE;
            B = X.desc;
            str2 = X.iconUrl;
            str3 = X.secondUrl;
            if (i2 != 0) {
                Intent intent6 = new Intent();
                intent6.putExtra("geta8key_username", by(biVar));
                intent6.putExtra("rawUrl", X.dJv);
                intent6.putExtra("topic_id", i2);
                intent6.putExtra("topic_name", str);
                intent6.putExtra("topic_desc", B);
                intent6.putExtra("topic_icon_url", str2);
                intent6.putExtra("topic_ad_url", str3);
                intent6.putExtra("extra_scence", 23);
                d.b(this.mController.ylL, "emoji", ".ui.EmojiStoreTopicUI", intent6);
                AppMethodBeat.o(32060);
                return;
            }
            ab.i("MicroMsg.GalleryGridUI", "topic id is zero.");
            AppMethodBeat.o(32060);
        } else if (X == null || X.type != 27) {
            ab.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", biVar.field_talker, Long.valueOf(biVar.field_msgId), Integer.valueOf(biVar.getType()), biVar.field_content);
            if (!(X.url == null || X.url.equals("") || X.url == null || X.url.equals(""))) {
                by = p.B(X.url, t.kH(this.talker) ? "groupmessage" : "singlemessage");
                str = X.url;
                packageInfo = getPackageInfo(this.mController.ylL, X.appId);
                intent = new Intent();
                intent.putExtra("rawUrl", by);
                intent.putExtra("webpageTitle", X.title);
                if (X.appId != null && ("wx751a1acca5688ba3".equals(X.appId) || "wxfbc915ff7c30e335".equals(X.appId) || "wx482a4001c37e2b74".equals(X.appId))) {
                    bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", X.appId);
                    intent.putExtra("jsapiargs", bundle);
                }
                if (bo.isNullOrNil(str)) {
                    intent.putExtra("shortUrl", X.url);
                } else {
                    intent.putExtra("shortUrl", str);
                }
                intent.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
                intent.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
                if (!bo.isNullOrNil(X.cMg)) {
                    intent.putExtra("srcUsername", X.cMg);
                    intent.putExtra("srcDisplayname", X.cMh);
                }
                intent.putExtra("msg_id", biVar.field_msgId);
                intent.putExtra("KPublisherId", "msg_" + Long.toString(biVar.field_msgSvrId));
                intent.putExtra("KAppId", X.appId);
                intent.putExtra("geta8key_username", r.Yz());
                intent.putExtra("pre_username", by(biVar));
                intent.putExtra("prePublishId", "msg_" + Long.toString(biVar.field_msgSvrId));
                C = by(biVar);
                by = r.Yz();
                intent.putExtra("preUsername", C);
                intent.putExtra("preChatName", by);
                intent.putExtra("preChatTYPE", u.ad(C, by));
                intent.putExtra("preMsgIndex", 0);
                d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.o(32060);
        } else {
            i2 = X.tid;
            str = X.fiE;
            B = X.desc;
            str2 = X.iconUrl;
            str3 = X.secondUrl;
            int i5 = X.pageType;
            if (i2 != 0) {
                Intent intent7 = new Intent();
                intent7.putExtra("geta8key_username", by(biVar));
                intent7.putExtra("rawUrl", X.dJv);
                intent7.putExtra("set_id", i2);
                intent7.putExtra("set_title", str);
                intent7.putExtra("set_iconURL", str2);
                intent7.putExtra("set_desc", B);
                intent7.putExtra("headurl", str3);
                intent7.putExtra("pageType", i5);
                d.b(this.mController.ylL, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent7);
                AppMethodBeat.o(32060);
                return;
            }
            ab.i("MicroMsg.GalleryGridUI", "topic id is zero.");
            AppMethodBeat.o(32060);
        }
    }

    private static String aO(Context context, String str) {
        String str2;
        AppMethodBeat.i(32062);
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                str2 = resolveInfo.activityInfo.name;
                AppMethodBeat.o(32062);
                return str2;
            }
        } catch (NameNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
        }
        str2 = null;
        AppMethodBeat.o(32062);
        return str2;
    }

    /* JADX WARNING: Missing block: B:7:0x0028, code skipped:
            if (r0.length() > 0) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private String by(bi biVar) {
        AppMethodBeat.i(32063);
        String bc = bo.bc(this.talker, "");
        boolean kH = t.kH(this.talker);
        if (kH) {
            String oy;
            if (kH) {
                oy = bf.oy(biVar.field_content);
                if (oy != null) {
                }
            }
            oy = bc;
            AppMethodBeat.o(32063);
            return oy;
        }
        AppMethodBeat.o(32063);
        return bc;
    }

    private boolean dFS() {
        AppMethodBeat.i(32065);
        long j = this.yUK + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        this.yUK = currentTimeMillis;
        if (j < currentTimeMillis) {
            aw.ZK();
            this.kuU = com.tencent.mm.model.c.isSDCardAvailable();
        }
        boolean z = this.kuU;
        AppMethodBeat.o(32065);
        return z;
    }

    private void bz(bi biVar) {
        AppMethodBeat.i(32066);
        if (dFS()) {
            Intent intent = new Intent();
            intent.setClassName(this.mController.ylL, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", biVar.field_msgId);
            startActivity(intent);
            AppMethodBeat.o(32066);
            return;
        }
        com.tencent.mm.ui.base.t.hO(this.mController.ylL);
        AppMethodBeat.o(32066);
    }

    private void ak(View view, int i) {
        AppMethodBeat.i(32067);
        if (this.yUC == null) {
            AppMethodBeat.o(32067);
            return;
        }
        Intent intent = new Intent(this, ImageGalleryUI.class);
        intent.putExtra("key_biz_chat_id", this.jMj);
        intent.putExtra("key_is_biz_chat", this.mgP);
        intent.putExtra("intent.key.with.footer", true);
        bi biVar = (bi) this.yUC.getItem(i);
        if (biVar == null) {
            AppMethodBeat.o(32067);
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
        intent.putExtra("img_gallery_msg_id", biVar.field_msgId).putExtra("img_gallery_msg_svr_id", biVar.field_msgSvrId).putExtra("img_gallery_talker", biVar.field_talker).putExtra("img_gallery_chatroom_name", biVar.field_talker).putExtra("img_gallery_orientation", i2);
        if (view != null) {
            intent.putExtra("img_gallery_width", i3).putExtra("img_gallery_height", i4).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
        } else {
            intent.putExtra("img_gallery_back_from_grid", true);
        }
        startActivity(intent);
        overridePendingTransition(0, 0);
        AppMethodBeat.o(32067);
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(32068);
        a aVar = (a) this.yUD.get();
        if (aVar == null) {
            AppMethodBeat.o(32068);
        } else {
            ViewTreeObserver viewTreeObserver = aVar.mok.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
                int measuredWidth = aVar.mok.getMeasuredWidth();
                int measuredHeight = aVar.mok.getMeasuredHeight();
                if (measuredWidth <= 0 || measuredHeight <= 0) {
                    AppMethodBeat.o(32068);
                } else {
                    LayoutParams layoutParams = (LayoutParams) aVar.mom.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    aVar.mom.setLayoutParams(layoutParams);
                    final ImageView imageView = aVar.mom;
                    final DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
                    if (VERSION.SDK_INT >= 12) {
                        this.yUM = imageView;
                        this.handler.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(32045);
                                if (VERSION.SDK_INT >= 16) {
                                    imageView.animate().setDuration(500).alpha(0.0f).withEndAction(ImageGalleryGridUI.this.yUL).withLayer().setInterpolator(decelerateInterpolator);
                                    AppMethodBeat.o(32045);
                                } else if (ImageGalleryGridUI.this.handler == null) {
                                    AppMethodBeat.o(32045);
                                } else {
                                    imageView.animate().setDuration(500).alpha(0.0f).setInterpolator(decelerateInterpolator);
                                    ImageGalleryGridUI.this.handler.postDelayed(ImageGalleryGridUI.this.yUL, 500);
                                    AppMethodBeat.o(32045);
                                }
                            }
                        }, 700);
                    }
                    AppMethodBeat.o(32068);
                }
            } else {
                AppMethodBeat.o(32068);
            }
        }
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        AppMethodBeat.i(32069);
        if (menuItem.getTitle().equals(getString(R.string.c39))) {
            h.a.yVE.clear();
            bwq();
        } else {
            bwr();
        }
        AppMethodBeat.o(32069);
        return false;
    }

    private void bwq() {
        AppMethodBeat.i(32070);
        setMMTitle(getString(R.string.c47, new Object[]{Integer.valueOf(h.a.yVE.mnX.size())}));
        h.a.yVE.mnY = true;
        if (this.yUC == null) {
            AppMethodBeat.o(32070);
            return;
        }
        if (this.qzp == null) {
            this.qzp = AnimationUtils.loadAnimation(this, R.anim.cg);
        }
        this.yUC.bwq();
        this.yUN.setVisibility(0);
        this.yUN.startAnimation(this.qzp);
        this.yUP.setEnabled(false);
        this.yUQ.setEnabled(false);
        this.yUR.setEnabled(false);
        this.yUS.setEnabled(false);
        this.yUO = this.yUB.getPaddingBottom();
        this.yUB.setPadding(this.yUB.getPaddingLeft(), this.yUB.getPaddingTop(), this.yUB.getPaddingRight(), com.tencent.mm.bz.a.al(this.mController.ylL, R.dimen.nb));
        h.pYm.e(11627, Integer.valueOf(2));
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(R.string.c38), this);
        AppMethodBeat.o(32070);
    }

    private static void eY(List<bi> list) {
        AppMethodBeat.i(32074);
        for (bi a : list) {
            com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.Fav, com.tencent.mm.ui.chatting.a.d.Samll, a, 0);
        }
        AppMethodBeat.o(32074);
    }

    private static List<bi> fb(List<bi> list) {
        AppMethodBeat.i(32075);
        ArrayList arrayList = new ArrayList();
        for (bi biVar : list) {
            if (!(c.bp(biVar) || c.bq(biVar))) {
                arrayList.add(biVar);
            }
        }
        AppMethodBeat.o(32075);
        return arrayList;
    }

    private void c(cl clVar) {
        AppMethodBeat.i(32076);
        clVar.cvA.activity = this;
        clVar.cvA.cvH = 45;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        if (clVar.cvB.ret == -2 || clVar.cvB.ret > 0) {
            AppMethodBeat.o(32076);
            return;
        }
        if (clVar.cvB.ret <= 0) {
            bwr();
            if (14 != clVar.cvA.type) {
                ab.d("MicroMsg.GalleryGridUI", "not record type, do not report");
                AppMethodBeat.o(32076);
                return;
            } else if (clVar.cvA.cvD == null) {
                ab.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
                AppMethodBeat.o(32076);
                return;
            } else {
                h.pYm.e(11142, Integer.valueOf(clVar.cvA.cvD.wiK), Integer.valueOf(clVar.cvA.cvD.wiL), Integer.valueOf(clVar.cvA.cvD.wiM), Integer.valueOf(clVar.cvA.cvD.wiN), Integer.valueOf(clVar.cvA.cvD.wiO), Integer.valueOf(clVar.cvA.cvD.wiP), Integer.valueOf(clVar.cvA.cvD.wiQ), Integer.valueOf(clVar.cvA.cvD.fileCount), Integer.valueOf(clVar.cvA.cvD.wiR), Integer.valueOf(clVar.cvA.cvD.wiS), Integer.valueOf(clVar.cvA.cvD.wiT), Integer.valueOf(clVar.cvA.cvD.wiU), Integer.valueOf(clVar.cvA.cvD.wiV), Integer.valueOf(clVar.cvA.cvD.wiW), Integer.valueOf(clVar.cvA.cvD.wiX));
            }
        }
        AppMethodBeat.o(32076);
    }

    public final void dFU() {
        AppMethodBeat.i(32077);
        if (this.yUC != null && this.mIsPause) {
            this.yUC.yUt = true;
        }
        setMMTitle(getString(R.string.c47, new Object[]{Integer.valueOf(h.a.yVE.mnX.size())}));
        dFT();
        AppMethodBeat.o(32077);
    }

    public final void clear() {
        AppMethodBeat.i(32078);
        if (this.yUC != null && this.mIsPause) {
            this.yUC.yUt = true;
        }
        dFT();
        AppMethodBeat.o(32078);
    }

    public final void dCI() {
    }

    public final void a(ah.a aVar) {
    }

    public final boolean dCJ() {
        return true;
    }

    public final void b(ah.a aVar) {
        AppMethodBeat.i(32079);
        if (aVar == ah.a.del) {
            this.yUC.KC();
            this.yUC.notifyDataSetChanged();
        }
        bwr();
        AppMethodBeat.o(32079);
    }

    public void onResume() {
        AppMethodBeat.i(32052);
        h.a.yVE.a(this);
        this.mIsPause = false;
        if (this.mnK) {
            if (h.a.yVE.mnY) {
                bwq();
            } else {
                bwr();
            }
        }
        this.handler.postDelayed(this.yUJ, 300);
        super.onResume();
        if (this.yUC != null) {
            this.yUC.yUt = true;
            d dVar = this.yUC;
            if (dVar.yUt) {
                dVar.notifyDataSetChanged();
            }
            if (h.a.yVE.mnY) {
                setMMTitle(getString(R.string.c47, new Object[]{Integer.valueOf(h.a.yVE.mnX.size())}));
            }
        }
        this.mnK = false;
        dFT();
        AppMethodBeat.o(32052);
    }

    public void onPause() {
        AppMethodBeat.i(32053);
        h.a.yVE.mnZ.remove(this);
        this.mIsPause = true;
        super.onPause();
        AppMethodBeat.o(32053);
    }

    public void onBackPressed() {
        AppMethodBeat.i(32056);
        if (h.a.yVE.mnY) {
            bwr();
            AppMethodBeat.o(32056);
        } else if (this.yUE.booleanValue()) {
            super.onBackPressed();
            AppMethodBeat.o(32056);
        } else {
            if (this.yUA >= 0) {
                ak(null, this.yUA);
            }
            finish();
            AppMethodBeat.o(32056);
        }
    }

    private boolean a(bi biVar, f fVar) {
        AppMethodBeat.i(32061);
        if (biVar.field_talker.endsWith("@qqim") && fVar.field_packageName.equals(TbsConfig.APP_QQ)) {
            int i;
            ab.d("MicroMsg.GalleryGridUI", "jacks open QQ");
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setClassName(TbsConfig.APP_QQ, aO(this.mController.ylL, TbsConfig.APP_QQ));
            intent.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
            aw.ZK();
            Object obj = com.tencent.mm.model.c.Ry().get(9, null);
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
                    ab.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
                }
            }
            try {
                startActivity(intent);
            } catch (Exception e2) {
            }
            AppMethodBeat.o(32061);
            return true;
        }
        AppMethodBeat.o(32061);
        return false;
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        AppMethodBeat.i(32064);
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            f bT = g.bT(str, true);
            if (bT == null) {
                Object str22 = packageInfo;
            } else {
                str22 = bT.field_packageName;
            }
        }
        if (str22 == null) {
            AppMethodBeat.o(32064);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str22, 0);
                AppMethodBeat.o(32064);
            } catch (NameNotFoundException e) {
                ab.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
                AppMethodBeat.o(32064);
            }
        }
        return packageInfo;
    }

    private void dFT() {
        AppMethodBeat.i(32071);
        boolean z = !h.a.yVE.mnX.isEmpty() && h.a.yVE.mnY;
        if (z) {
            this.yUP.setEnabled(true);
            this.yUQ.setEnabled(true);
            this.yUR.setEnabled(true);
            this.yUS.setEnabled(true);
            AppMethodBeat.o(32071);
            return;
        }
        this.yUP.setEnabled(false);
        this.yUQ.setEnabled(false);
        this.yUR.setEnabled(false);
        this.yUS.setEnabled(false);
        AppMethodBeat.o(32071);
    }

    public final void bwr() {
        AppMethodBeat.i(32072);
        h.a.yVE.mnY = false;
        setMMTitle(getString(R.string.ff));
        if (this.yUC == null) {
            AppMethodBeat.o(32072);
            return;
        }
        this.yUC.notifyDataSetChanged();
        if (this.yUO >= 0) {
            this.yUB.setPadding(this.yUB.getPaddingLeft(), this.yUB.getPaddingTop(), this.yUB.getPaddingRight(), this.yUO);
        }
        this.yUN.setVisibility(8);
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(R.string.c39), this);
        AppMethodBeat.o(32072);
    }

    public void onClick(View view) {
        AppMethodBeat.i(32073);
        if (h.a.yVE.mnX.isEmpty()) {
            AppMethodBeat.o(32073);
            return;
        }
        boolean kH = t.kH(this.talker);
        final List<bi> list = h.a.yVE.mnX;
        bi biVar;
        String str;
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(32073);
        } else if (view.getId() == R.id.aw8) {
            h.pYm.e(11627, Integer.valueOf(5));
            final TreeSet treeSet = new TreeSet();
            for (bi biVar2 : list) {
                treeSet.add(Long.valueOf(biVar2.field_msgId));
            }
            com.tencent.mm.ui.base.h.d(this, getString(R.string.at7), "", getString(R.string.b59), getString(R.string.or), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(32047);
                    ab.i("MicroMsg.GalleryGridUI", "delete message");
                    i.a(ImageGalleryGridUI.this, treeSet, ImageGalleryGridUI.this);
                    ImageGalleryGridUI.this.bwr();
                    AppMethodBeat.o(32047);
                }
            }, null);
            AppMethodBeat.o(32073);
        } else if (view.getId() == R.id.chq) {
            h.pYm.a(219, 18, 1, true);
            final cl clVar = new cl();
            if (com.tencent.mm.pluginsdk.model.g.a(this.mController.ylL, clVar, this.talker, list, false)) {
                c(clVar);
                eY(list);
                AppMethodBeat.o(32073);
            } else if (list.size() > 1) {
                String string;
                String string2;
                AppCompatActivity appCompatActivity = this.mController.ylL;
                if (clVar.cvA.cvG >= 0) {
                    string = this.mController.ylL.getString(R.string.bov);
                } else {
                    string = this.mController.ylL.getString(R.string.bou);
                }
                str = "";
                if (clVar.cvA.cvG >= 0) {
                    string2 = this.mController.ylL.getString(R.string.atd);
                } else {
                    string2 = this.mController.ylL.getString(R.string.dcq);
                }
                com.tencent.mm.ui.base.h.d(appCompatActivity, string, str, string2, this.mController.ylL.getString(R.string.atb), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(32048);
                        if (clVar.cvA.type == 14 && clVar.cvA.cvC.wiv.size() == 0) {
                            ImageGalleryGridUI.this.bwr();
                            AppMethodBeat.o(32048);
                            return;
                        }
                        ImageGalleryGridUI.a(ImageGalleryGridUI.this, clVar);
                        ImageGalleryGridUI.fc(list);
                        AppMethodBeat.o(32048);
                    }
                }, null);
                AppMethodBeat.o(32073);
            } else {
                com.tencent.mm.ui.base.h.g(this.mController.ylL, clVar.cvA.cvG, 0);
                AppMethodBeat.o(32073);
            }
        } else if (view.getId() == R.id.bqw) {
            h.pYm.a(219, 19, 1, true);
            k.a(this, list, kH, this.talker, this);
            bwr();
            AppMethodBeat.o(32073);
        } else {
            h.pYm.e(11627, Integer.valueOf(3));
            final List fb = fb(list);
            if (fb.size() != list.size()) {
                com.tencent.mm.ui.base.h.a(this.mController.ylL, (int) R.string.c3v, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(32035);
                        c.f(ImageGalleryGridUI.this.mController.ylL, fb);
                        ImageGalleryGridUI.this.bwr();
                        AppMethodBeat.o(32035);
                    }
                }, null);
                AppMethodBeat.o(32073);
                return;
            }
            biVar2 = (bi) fb.get(0);
            if (list.size() == 1 && biVar2 != null && biVar2.bAA()) {
                str = biVar2.field_content;
                j.b bVar = null;
                if (str != null) {
                    bVar = j.b.X(str, biVar2.field_reserved);
                }
                if (bVar != null && bVar.type == 6) {
                    bz(biVar2);
                }
                AppMethodBeat.o(32073);
                return;
            }
            c.f((Context) this, (List) list);
            bwr();
            AppMethodBeat.o(32073);
        }
    }

    static /* synthetic */ void a(ImageGalleryGridUI imageGalleryGridUI, int i, gs gsVar) {
        AppMethodBeat.i(32080);
        if (imageGalleryGridUI.yUB != null) {
            int firstVisiblePosition = imageGalleryGridUI.yUB.getFirstVisiblePosition();
            int lastVisiblePosition = imageGalleryGridUI.yUB.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = imageGalleryGridUI.yUB.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    gsVar.cBs.ctT = iArr[0];
                    gsVar.cBs.ctU = iArr[1];
                    gsVar.cBs.ctV = childAt.getWidth();
                    gsVar.cBs.ctW = childAt.getHeight();
                }
            }
        }
        AppMethodBeat.o(32080);
    }
}
