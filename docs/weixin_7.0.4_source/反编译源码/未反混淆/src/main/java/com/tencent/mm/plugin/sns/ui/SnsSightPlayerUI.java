package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.m.g;
import com.tencent.mm.model.d;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.a.b.j.c;
import com.tencent.mm.plugin.sns.a.b.j.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

@a(3)
public class SnsSightPlayerUI extends MMActivity implements d.a, b {
    private float aKM = 0.0f;
    private float aKN = 0.0f;
    private boolean bZi = false;
    private bau cNr = null;
    private int cPL = 0;
    public j contextMenuHelper;
    private int cvd = 0;
    private String czD = "";
    private int duration = 0;
    private String ePJ = "";
    private boolean foa = false;
    private d iaf;
    private GestureDetector iay;
    private String imagePath = "";
    n.d jOb = new n.d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(39254);
            Intent intent;
            switch (menuItem.getItemId()) {
                case 1:
                    intent = new Intent();
                    com.tencent.mm.plugin.sns.storage.n YT = af.cnF().YT(SnsSightPlayerUI.this.czD);
                    if (YT != null) {
                        ab.i("MicroMsg.SnsSightPlayerUI", "expose id " + YT.cqA());
                    }
                    intent.putExtra("k_expose_msg_id", YT == null ? Integer.valueOf(0) : YT.cqA());
                    intent.putExtra("k_username", YT == null ? "" : YT.field_userName);
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                    com.tencent.mm.bp.d.b(SnsSightPlayerUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(39254);
                    return;
                case 2:
                    com.tencent.mm.plugin.sns.storage.n YT2 = af.cnF().YT(SnsSightPlayerUI.this.czD);
                    if (YT2 == null) {
                        AppMethodBeat.o(39254);
                        return;
                    }
                    cl clVar = new cl();
                    com.tencent.mm.plugin.sns.j.a.a(clVar, YT2);
                    clVar.cvA.activity = SnsSightPlayerUI.this;
                    clVar.cvA.cvH = 17;
                    com.tencent.mm.sdk.b.a.xxA.m(clVar);
                    if (SnsSightPlayerUI.this.qFG) {
                        i.a(new SnsAdClick(SnsSightPlayerUI.this.cvd, 5, YT2.field_snsId, 11, 0));
                        com.tencent.mm.plugin.sns.a.b.j.a(com.tencent.mm.plugin.sns.a.b.j.d.Sight, c.Fav, e.Full, 0, YT2, SnsSightPlayerUI.this.cvd);
                    }
                    if (SnsSightPlayerUI.this.cvd == 0) {
                        rb rbVar = new rb();
                        rbVar.cNg.cwT = YT2.cqU();
                        rbVar.cNg.cFc = i.j(YT2);
                        com.tencent.mm.sdk.b.a.xxA.m(rbVar);
                    }
                    AppMethodBeat.o(39254);
                    return;
                case 3:
                    SnsSightPlayerUI.this.ruY = true;
                    Intent intent2 = new Intent();
                    intent2.putExtra("Select_Conv_Type", 3);
                    intent2.putExtra("select_is_ret", true);
                    intent2.putExtra("mutil_select_is_ret", true);
                    intent2.putExtra("image_path", SnsSightPlayerUI.this.imagePath);
                    intent2.putExtra("Retr_Msg_Type", 11);
                    com.tencent.mm.bp.d.b(SnsSightPlayerUI.this, ".ui.transmit.SelectConversationUI", intent2, 4097);
                    AppMethodBeat.o(39254);
                    return;
                case 4:
                    com.tencent.mm.plugin.sns.storage.n YT3 = af.cnF().YT(SnsSightPlayerUI.this.czD);
                    if (YT3 == null) {
                        AppMethodBeat.o(39254);
                        return;
                    }
                    intent = new Intent();
                    if (YT3.cqu().xfI.wbJ != 15 || ((bau) YT3.cqu().xfI.wbK.get(0)) != null) {
                        intent.putExtra("exdevice_open_scene_type", 2);
                        intent.putExtra("sns_local_id", SnsSightPlayerUI.this.czD);
                        intent.putExtra("sns_send_data_ui_activity", true);
                        com.tencent.mm.bp.d.f(SnsSightPlayerUI.this, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        break;
                    }
                    ab.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
                    AppMethodBeat.o(39254);
                    return;
                    break;
            }
            AppMethodBeat.o(39254);
        }
    };
    Bundle jWy;
    private boolean jYD = false;
    com.tencent.mm.ui.tools.e jYE;
    private int kkq = 0;
    private int kkr = 0;
    private int kks = 0;
    private int kkt = 0;
    com.tencent.mm.pluginsdk.ui.tools.e klq = null;
    private VelocityTracker mVelocityTracker;
    private int mik = 0;
    private TextView mlK = null;
    private boolean mlN = false;
    private ImageView mmX;
    private boolean qFG = false;
    private int qxZ = 0;
    private TextView qyR = null;
    private boolean qyS = false;
    ViewGroup qzb;
    private int qzj = 0;
    private int qzk = 0;
    public int qzr = 0;
    private com.tencent.mm.plugin.sns.storage.n ros = null;
    private int rpA = 0;
    private int rpB = 0;
    private float rpz = 1.0f;
    private boolean ruY = false;
    private boolean rvb = false;
    private boolean rvc = false;
    private boolean rvd = false;
    private h rwL = new h("SnsSightPlayerUI");
    private String rwM = "";
    private TextView rwN = null;
    private MMPinProgressBtn rwO = null;
    private com.tencent.mm.plugin.sns.storage.a rwP = null;
    private String rwQ = "";
    private RelativeLayout rwR;
    OnCreateContextMenuListener rwS = new OnCreateContextMenuListener() {
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x009d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            int i;
            AppMethodBeat.i(39253);
            if (bo.ank(g.Nu().getValue("SIGHTCannotTransmitForFav")) == 0) {
                ab.i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", Boolean.valueOf(com.tencent.mm.vfs.e.ct(SnsSightPlayerUI.this.imagePath)), Boolean.valueOf(com.tencent.mm.vfs.e.ct(SnsSightPlayerUI.this.ePJ)));
                if (com.tencent.mm.vfs.e.ct(SnsSightPlayerUI.this.imagePath) && r3) {
                    contextMenu.add(0, 3, 0, SnsSightPlayerUI.this.getString(R.string.ejf));
                    i = 1;
                    if (com.tencent.mm.bp.d.afj("favorite")) {
                        contextMenu.add(0, 2, 0, SnsSightPlayerUI.this.getString(R.string.dcq));
                    }
                    if (i != 0) {
                        dq dqVar = new dq();
                        dqVar.cxc.cwT = SnsSightPlayerUI.this.czD;
                        com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                        if (dqVar.cxd.cwB) {
                            contextMenu.add(0, 4, 0, SnsSightPlayerUI.this.getString(R.string.s7));
                        }
                    }
                    if (!SnsSightPlayerUI.this.qFG) {
                        contextMenu.add(0, 1, 0, SnsSightPlayerUI.this.mController.ylL.getString(R.string.epl));
                    }
                    AppMethodBeat.o(39253);
                }
            }
            i = 0;
            if (com.tencent.mm.bp.d.afj("favorite")) {
            }
            if (i != 0) {
            }
            if (SnsSightPlayerUI.this.qFG) {
            }
            AppMethodBeat.o(39253);
        }
    };
    private String thumbPath = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsSightPlayerUI() {
        AppMethodBeat.i(39269);
        AppMethodBeat.o(39269);
    }

    public void onCreate(Bundle bundle) {
        String fZ;
        AppMethodBeat.i(39270);
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        this.cvd = getIntent().getIntExtra("intent_from_scene", -1);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.mController.hideTitleView();
        af.cnA().a((b) this);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.h4));
        }
        if (com.tencent.mm.compatible.util.d.iW(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.jWy = bundle;
        this.iaf = new d();
        this.ePJ = getIntent().getStringExtra("intent_videopath");
        this.imagePath = getIntent().getStringExtra("intent_thumbpath");
        this.czD = getIntent().getStringExtra("intent_localid");
        this.qFG = getIntent().getBooleanExtra("intent_isad", false);
        this.ros = af.cnF().YT(this.czD);
        if (this.qFG) {
            boolean z;
            if (this.ros == null) {
                z = false;
            } else {
                this.cNr = (bau) this.ros.cqu().xfI.wbK.get(0);
                fZ = an.fZ(af.getAccSnsPath(), this.cNr.Id);
                this.rwQ = fZ + i.k(this.cNr);
                this.thumbPath = fZ + i.e(this.cNr);
                z = true;
            }
            if (!z) {
                finish();
                AppMethodBeat.o(39270);
                return;
            }
        }
        if (com.tencent.mm.r.a.Cc() != null) {
            com.tencent.mm.r.a.Cc().Id();
        }
        com.tencent.mm.plugin.sns.storage.a cqr = this.ros != null ? this.cvd == 2 ? this.ros.cqr() : this.ros.cqq() : null;
        this.rwP = cqr;
        this.rwL.qEm = bo.yz();
        this.rwR = (RelativeLayout) findViewById(R.id.um);
        this.rwR.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(39247);
                SnsSightPlayerUI.this.bcW();
                AppMethodBeat.o(39247);
                return true;
            }
        });
        ab.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.g.Mp() + " initView: fullpath:" + this.ePJ + ", imagepath:" + this.imagePath);
        this.jYE = new com.tencent.mm.ui.tools.e(this.mController.ylL);
        this.mmX = (ImageView) findViewById(R.id.adg);
        this.mmX.setLayerType(2, null);
        this.qyR = (TextView) findViewById(R.id.bn0);
        this.rwO = (MMPinProgressBtn) findViewById(R.id.eda);
        this.qzb = (ViewGroup) findViewById(R.id.bs7);
        this.klq = q.fT(this.mController.ylL);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        this.mlK = (TextView) findViewById(R.id.ee0);
        this.qzb.addView((View) this.klq, 0, layoutParams);
        this.rwN = (TextView) findViewById(R.id.elc);
        this.rwN.setText("");
        if (!this.qFG) {
            this.rwN.setVisibility(8);
        }
        if (this.qFG) {
            if (this.cNr == null) {
                this.mlK.setVisibility(8);
            } else if (bo.isNullOrNil(this.cNr.wEO)) {
                ab.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
                final TimeLineObject cqu = this.ros.cqu();
                com.tencent.mm.plugin.sns.storage.b cqo = this.ros.cqo();
                String str = cqo.qUo;
                final String str2 = cqo.qUp;
                if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                    this.mlK.setVisibility(8);
                } else {
                    this.mlK.setVisibility(0);
                    this.mlK.setText(str);
                    this.mlK.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(39256);
                            if (com.tencent.mm.plugin.sns.a.b.j.b.Sight.value != 0) {
                                com.tencent.mm.plugin.sns.a.b.j.a(com.tencent.mm.plugin.sns.a.b.j.a.DetailInVideo, cqu.Id, SnsSightPlayerUI.this.rwP == null ? "" : SnsSightPlayerUI.this.rwP.qPj, 1, com.tencent.mm.plugin.sns.a.b.j.b.Sight.value, cqu.jBB, null, cqu.Id, 0, 0, 0);
                            }
                            final Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putString("key_snsad_statextstr", cqu.rjC);
                            intent.putExtra("jsapiargs", bundle);
                            intent.putExtra("rawUrl", str2);
                            intent.putExtra("useJs", true);
                            i.a(new SnsAdClick(SnsSightPlayerUI.this.cvd, 5, SnsSightPlayerUI.this.ros.field_snsId, 18, 0));
                            new ak(Looper.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(39255);
                                    com.tencent.mm.plugin.sns.c.a.gkE.i(intent, SnsSightPlayerUI.this);
                                    SnsSightPlayerUI.this.finish();
                                    AppMethodBeat.o(39255);
                                }
                            });
                            AppMethodBeat.o(39256);
                        }
                    });
                }
            } else {
                fZ = getResources().getString(R.string.ej7);
                if (this.cNr.rEd / 60 > 0) {
                    fZ = fZ + getResources().getString(R.string.ej9, new Object[]{Integer.valueOf(this.cNr.rEd / 60)});
                }
                if (this.cNr.rEd % 60 > 0) {
                    fZ = fZ + getResources().getString(R.string.ej_, new Object[]{Integer.valueOf(this.cNr.rEd % 60)});
                }
                this.mlK.setText(fZ + getResources().getString(R.string.ej8));
                this.mlK.setVisibility(0);
                this.mlK.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        com.tencent.mm.modelsns.b lY;
                        AppMethodBeat.i(39257);
                        if (SnsSightPlayerUI.this.ros.DI(32)) {
                            com.tencent.mm.plugin.sns.a.b.j.a(com.tencent.mm.plugin.sns.a.b.j.b.Sight, com.tencent.mm.plugin.sns.a.b.j.a.EnterCompleteVideo, SnsSightPlayerUI.this.ros, SnsSightPlayerUI.this.cvd);
                        }
                        Intent intent = new Intent();
                        String fZ = an.fZ(af.getAccSnsPath(), SnsSightPlayerUI.this.cNr.Id);
                        String k = i.k(SnsSightPlayerUI.this.cNr);
                        intent.setClass(SnsSightPlayerUI.this, VideoAdPlayerUI.class);
                        intent.putExtra("KFullVideoPath", fZ + k);
                        intent.putExtra("KThumbPath", SnsSightPlayerUI.this.imagePath);
                        intent.putExtra("IsAd", true);
                        intent.putExtra("KStremVideoUrl", SnsSightPlayerUI.this.cNr.wEO);
                        intent.putExtra("KThumUrl", bo.isNullOrNil(SnsSightPlayerUI.this.cNr.wER) ? SnsSightPlayerUI.this.cNr.wEH : SnsSightPlayerUI.this.cNr.wER);
                        intent.putExtra("KMediaId", SnsSightPlayerUI.this.cNr.Id);
                        intent.putExtra("KUrl", SnsSightPlayerUI.this.cNr.Url);
                        intent.putExtra("KViewId", SnsSightPlayerUI.this.rwP.hnw);
                        TimeLineObject cqu = SnsSightPlayerUI.this.ros.cqu();
                        String str = "KSta_StremVideoAduxInfo";
                        if (SnsSightPlayerUI.this.rwP == null) {
                            fZ = "";
                        } else {
                            fZ = SnsSightPlayerUI.this.rwP.qPj;
                        }
                        intent.putExtra(str, fZ);
                        intent.putExtra("KSta_StremVideoPublishId", cqu.Id);
                        intent.putExtra("KSta_SourceType", 1);
                        intent.putExtra("KSta_Scene", com.tencent.mm.plugin.sns.a.b.j.b.Sight.value);
                        intent.putExtra("KSta_FromUserName", cqu.jBB);
                        intent.putExtra("KSta_SnSId", cqu.Id);
                        intent.putExtra("KSta_SnsStatExtStr", cqu.rjC);
                        intent.putExtra("KMediaVideoTime", SnsSightPlayerUI.this.cNr.rEd);
                        if (bo.isNullOrNil(SnsSightPlayerUI.this.cNr.wES)) {
                            fZ = cqu.xfF;
                        } else {
                            fZ = SnsSightPlayerUI.this.cNr.wES;
                        }
                        intent.putExtra("KMediaTitle", fZ);
                        com.tencent.mm.plugin.sns.storage.b cqo = SnsSightPlayerUI.this.ros.cqo();
                        if (cqo != null && cqo.qUn == 0) {
                            intent.putExtra("StreamWording", cqo.qUo);
                            intent.putExtra("StremWebUrl", cqo.qUp);
                        }
                        com.tencent.mm.plugin.sns.storage.n YT = af.cnF().YT(SnsSightPlayerUI.this.czD);
                        if (SnsSightPlayerUI.this.cvd == 0) {
                            lY = com.tencent.mm.modelsns.b.lY(747);
                        } else {
                            lY = com.tencent.mm.modelsns.b.lZ(747);
                        }
                        lY.tx(i.j(YT)).mb(YT.field_type).cS(true).tx(YT.crc()).mb(SnsSightPlayerUI.this.cNr.rEd);
                        lY.ajK();
                        if (SnsSightPlayerUI.this.cvd == 0) {
                            lY = com.tencent.mm.modelsns.b.lY(748);
                        } else {
                            lY = com.tencent.mm.modelsns.b.lZ(748);
                        }
                        lY.tx(i.j(YT)).mb(YT.field_type).cS(true).tx(YT.crc()).mb(SnsSightPlayerUI.this.cNr.rEd);
                        lY.b(intent, "intent_key_StatisticsOplog");
                        SnsSightPlayerUI.this.startActivity(intent);
                        i.a(new SnsAdClick(SnsSightPlayerUI.this.cvd, 5, YT.field_snsId, 14, 0));
                        if (SnsSightPlayerUI.this.cvd == 0) {
                            qx qxVar = new qx();
                            qxVar.cNd.cFy = true;
                            com.tencent.mm.sdk.b.a.xxA.m(qxVar);
                        }
                        AppMethodBeat.o(39257);
                    }
                });
            }
            p.a(this.mlK, (VideoSightView) this.klq);
        } else {
            this.mlK.setVisibility(8);
        }
        this.klq.setVideoCallback(new com.tencent.mm.pluginsdk.ui.tools.e.a() {
            public final void pL() {
                AppMethodBeat.i(39260);
                ab.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.g.Mp() + " onPrepared");
                SnsSightPlayerUI.a(SnsSightPlayerUI.this, true);
                AppMethodBeat.o(39260);
            }

            public final void onError(int i, int i2) {
                AppMethodBeat.i(39261);
                ab.e("MicroMsg.SnsSightPlayerUI", "on play video error, what %d extra %d", Integer.valueOf(i), Integer.valueOf(i2));
                SnsSightPlayerUI.this.klq.stop();
                if (SnsSightPlayerUI.this.mlN) {
                    AppMethodBeat.o(39261);
                    return;
                }
                SnsSightPlayerUI.this.mlN = true;
                com.tencent.mm.sdk.a.b.A(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.ckW() + "[SnsSightPlayerUI] on play video error, what " + i + " extra " + i2 + ", path=" + bo.bc(SnsSightPlayerUI.this.imagePath, "")).getBytes(), 2), "FullScreenPlaySight");
                final String e = SnsSightPlayerUI.this.imagePath;
                final Bitmap a = o.ahl().a(e, com.tencent.mm.bz.a.getDensity(SnsSightPlayerUI.this.mController.ylL), SnsSightPlayerUI.this.mController.ylL, -1);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(39258);
                        ImageView imageView = (ImageView) SnsSightPlayerUI.this.findViewById(R.id.bs8);
                        if (imageView != null) {
                            imageView.setImageBitmap(a);
                            imageView.setVisibility(0);
                        }
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        k.a(SnsSightPlayerUI.this.mController.ylL, intent, com.tencent.mm.vfs.e.asY(e), "video/*");
                        try {
                            SnsSightPlayerUI.this.mController.ylL.startActivity(Intent.createChooser(intent, SnsSightPlayerUI.this.mController.ylL.getString(R.string.bs9)));
                            AppMethodBeat.o(39258);
                        } catch (Exception e) {
                            ab.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
                            com.tencent.mm.ui.base.h.g(SnsSightPlayerUI.this.mController.ylL, R.string.bpq, R.string.bpr);
                            AppMethodBeat.o(39258);
                        }
                    }
                });
                AppMethodBeat.o(39261);
            }

            public final void EA() {
                AppMethodBeat.i(39262);
                ab.d("MicroMsg.SnsSightPlayerUI", "on completion");
                if (!SnsSightPlayerUI.this.qFG) {
                    SnsSightPlayerUI.this.qyR.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(39259);
                            if (SnsSightPlayerUI.this.qyR.getVisibility() != 0) {
                                SnsSightPlayerUI.this.qyR.setVisibility(0);
                                SnsSightPlayerUI.this.qyR.startAnimation(AnimationUtils.loadAnimation(SnsSightPlayerUI.this.mController.ylL, R.anim.b5));
                            }
                            AppMethodBeat.o(39259);
                        }
                    });
                }
                SnsSightPlayerUI.this.klq.setLoop(true);
                com.tencent.mm.plugin.sns.a.b.a.a aVar = SnsSightPlayerUI.this.rwL.qEs;
                aVar.qFp++;
                SnsSightPlayerUI.a(SnsSightPlayerUI.this, false);
                AppMethodBeat.o(39262);
            }

            public final int dG(int i, int i2) {
                return 0;
            }

            public final void dH(int i, int i2) {
            }
        });
        findViewById(R.id.bs7).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39263);
                SnsSightPlayerUI.this.bcW();
                AppMethodBeat.o(39263);
            }
        });
        ((View) this.klq).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39264);
                SnsSightPlayerUI.this.bcW();
                AppMethodBeat.o(39264);
            }
        });
        this.iay = new GestureDetector(this.mController.ylL, new SimpleOnGestureListener() {
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                AppMethodBeat.i(39265);
                float translationX = (((View) SnsSightPlayerUI.this.klq).getTranslationX() + motionEvent2.getX()) - motionEvent.getX();
                float translationY = (((View) SnsSightPlayerUI.this.klq).getTranslationY() + motionEvent2.getY()) - motionEvent.getY();
                if (SnsSightPlayerUI.this.rvb) {
                    ((View) SnsSightPlayerUI.this.klq).setTranslationX(translationX);
                    ((View) SnsSightPlayerUI.this.klq).setTranslationY(translationY);
                }
                AppMethodBeat.o(39265);
                return true;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(39266);
                SnsSightPlayerUI.this.rvd = true;
                super.onLongPress(motionEvent);
                AppMethodBeat.o(39266);
            }
        });
        ((View) this.klq).setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                float f = 1.0f;
                AppMethodBeat.i(39267);
                SnsSightPlayerUI.this.iay.onTouchEvent(motionEvent);
                if (SnsSightPlayerUI.this.mVelocityTracker == null) {
                    SnsSightPlayerUI.this.mVelocityTracker = VelocityTracker.obtain();
                }
                SnsSightPlayerUI.this.mVelocityTracker.addMovement(motionEvent);
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        SnsSightPlayerUI.this.aKM = motionEvent.getX();
                        SnsSightPlayerUI.this.aKN = motionEvent.getY();
                        break;
                    case 1:
                        if (SnsSightPlayerUI.this.rvc) {
                            ((View) SnsSightPlayerUI.this.klq).setPivotX((float) (SnsSightPlayerUI.this.qzb.getWidth() / 2));
                            ((View) SnsSightPlayerUI.this.klq).setPivotY((float) (SnsSightPlayerUI.this.qzb.getHeight() / 2));
                            ((View) SnsSightPlayerUI.this.klq).setScaleX(1.0f);
                            ((View) SnsSightPlayerUI.this.klq).setScaleY(1.0f);
                            ((View) SnsSightPlayerUI.this.klq).setTranslationX(0.0f);
                            ((View) SnsSightPlayerUI.this.klq).setTranslationY(0.0f);
                            SnsSightPlayerUI snsSightPlayerUI = SnsSightPlayerUI.this;
                            if (snsSightPlayerUI.contextMenuHelper == null) {
                                snsSightPlayerUI.contextMenuHelper = new j(snsSightPlayerUI.mController.ylL);
                            }
                            snsSightPlayerUI.contextMenuHelper.a((View) snsSightPlayerUI.klq, snsSightPlayerUI.rwS, snsSightPlayerUI.jOb);
                            if (SnsSightPlayerUI.this.mlK != null) {
                                SnsSightPlayerUI.this.mlK.setVisibility(0);
                            }
                            SnsSightPlayerUI.this.rvb = false;
                            SnsSightPlayerUI.this.rvd = false;
                            break;
                        } else if (!SnsSightPlayerUI.this.rvb || SnsSightPlayerUI.this.rvd) {
                            SnsSightPlayerUI.this.rvd = false;
                            break;
                        } else {
                            SnsSightPlayerUI.this.bcW();
                            SnsSightPlayerUI.this.rvd = false;
                            AppMethodBeat.o(39267);
                            return true;
                        }
                        break;
                    case 2:
                        float translationX = ((View) SnsSightPlayerUI.this.klq).getTranslationX();
                        float translationY = ((View) SnsSightPlayerUI.this.klq).getTranslationY();
                        VelocityTracker o = SnsSightPlayerUI.this.mVelocityTracker;
                        o.computeCurrentVelocity(1000);
                        int xVelocity = (int) o.getXVelocity();
                        int yVelocity = (int) o.getYVelocity();
                        if ((Math.abs(translationX) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || SnsSightPlayerUI.this.rvd) && !SnsSightPlayerUI.this.rvb) {
                            SnsSightPlayerUI.this.rvb = false;
                        } else {
                            float height = 1.0f - (translationY / ((float) SnsSightPlayerUI.this.qzb.getHeight()));
                            if (height <= 1.0f) {
                                f = height;
                            }
                            if (((yVelocity > 0 && f < SnsSightPlayerUI.this.rpz) || yVelocity < 0) && ((double) f) >= 0.5d) {
                                SnsSightPlayerUI.this.rpA = (int) translationX;
                                SnsSightPlayerUI.this.rpB = (int) translationY;
                                SnsSightPlayerUI.this.rpz = f;
                                if (SnsSightPlayerUI.this.mlK != null) {
                                    SnsSightPlayerUI.this.mlK.setVisibility(8);
                                }
                                ((View) SnsSightPlayerUI.this.klq).setPivotX((float) (SnsSightPlayerUI.this.qzb.getWidth() / 2));
                                ((View) SnsSightPlayerUI.this.klq).setPivotY((float) (SnsSightPlayerUI.this.qzb.getHeight() / 2));
                                ((View) SnsSightPlayerUI.this.klq).setScaleX(f);
                                ((View) SnsSightPlayerUI.this.klq).setScaleY(f);
                                SnsSightPlayerUI.this.mmX.setAlpha(f);
                            }
                            SnsSightPlayerUI.this.rvb = true;
                        }
                        if (translationY > 200.0f) {
                            SnsSightPlayerUI.this.rvc = false;
                        } else if (translationY > 10.0f) {
                            SnsSightPlayerUI.this.rvc = true;
                        }
                        if (translationY > 50.0f) {
                            ((View) SnsSightPlayerUI.this.klq).setOnLongClickListener(null);
                        }
                        if (SnsSightPlayerUI.this.mVelocityTracker != null) {
                            SnsSightPlayerUI.this.mVelocityTracker.recycle();
                            SnsSightPlayerUI.this.mVelocityTracker = null;
                        }
                        if (SnsSightPlayerUI.this.rvb) {
                            AppMethodBeat.o(39267);
                            return true;
                        }
                        break;
                }
                AppMethodBeat.o(39267);
                return false;
            }
        });
        if (com.tencent.mm.vfs.e.ct(this.ePJ)) {
            if (this.ePJ != null) {
                this.klq.stop();
                this.klq.setVideoPath(this.ePJ);
            }
            this.rwO.setVisibility(8);
            this.rwL.qEk = 1;
        } else {
            af.cnA().a(this.cNr, 6, null, az.xYU);
            this.rwO.setVisibility(0);
            this.rwO.dKB();
            this.rwL.qEk = 0;
        }
        ab.d("MicroMsg.SnsSightPlayerUI", (System.currentTimeMillis() - currentTimeMillis) + " initView end");
        tn tnVar = new tn();
        tnVar.cPI.type = 1;
        com.tencent.mm.sdk.b.a.xxA.m(tnVar);
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new j(this.mController.ylL);
        }
        this.contextMenuHelper.a((View) this.klq, this.rwS, this.jOb);
        ((View) this.klq).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39268);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                SnsSightPlayerUI.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                if (SnsSightPlayerUI.this.klq instanceof VideoSightView) {
                    ((VideoSightView) SnsSightPlayerUI.this.klq).setDrawableWidth(displayMetrics.widthPixels);
                }
                ((View) SnsSightPlayerUI.this.klq).requestLayout();
                ((View) SnsSightPlayerUI.this.klq).postInvalidate();
                AppMethodBeat.o(39268);
            }
        });
        AppMethodBeat.o(39270);
    }

    public void finish() {
        AppMethodBeat.i(39271);
        if (!this.foa) {
            super.finish();
            this.foa = true;
        }
        AppMethodBeat.o(39271);
    }

    private void kB(boolean z) {
        AppMethodBeat.i(39272);
        this.klq.start();
        this.duration = this.klq.getDuration();
        ab.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
        this.iaf.a(this);
        if (z) {
            this.rwL.qEs.qFt = getResources().getConfiguration().orientation == 2 ? 2 : 1;
            this.rwL.qEs.qFu = bo.yz();
            this.rwL.qEs.qFs = 2;
        }
        AppMethodBeat.o(39272);
    }

    private void cpN() {
        AppMethodBeat.i(39273);
        ab.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
        this.klq.pause();
        this.klq.onDetach();
        this.iaf.cy(false);
        AppMethodBeat.o(39273);
    }

    public final int getLayoutId() {
        return R.layout.aw8;
    }

    public void onDestroy() {
        AppMethodBeat.i(39274);
        super.onDestroy();
        if (this.qFG) {
            String str = this.ros == null ? "" : this.rwP.hnw;
            if (this.ros != null) {
                com.tencent.mm.bt.b cqz;
                String cmf = this.rwL.cmf();
                int cre = this.ros == null ? 0 : this.ros.cre();
                long j = ((long) this.rwL.qEl) - this.rwL.fQe;
                if (j < 0) {
                    ab.e("MicroMsg.SnsSightPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", Integer.valueOf(this.rwL.qEl), Long.valueOf(this.rwL.fQe));
                    j = (long) this.rwL.qEl;
                }
                int i = (int) j;
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.ai.p pVar = com.tencent.mm.kernel.g.RO().eJo;
                int i2 = this.cvd == 0 ? 1 : 2;
                int i3 = this.rwL.qEl;
                com.tencent.mm.bt.b cqy = this.cvd == 2 ? this.ros.crd().cqy() : this.ros.crd().cqw();
                if (this.cvd == 2) {
                    cqz = this.ros.crd().cqz();
                } else {
                    cqz = this.ros.crd().cqx();
                }
                pVar.a(new com.tencent.mm.plugin.sns.a.b.d(str, i2, 2, i3, null, null, 2, cmf, -1, cre, i, i, 0, cqy, cqz), 0);
            }
        }
        ab.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
        if (this.qFG && this.ros != null && this.ros.DI(32)) {
            com.tencent.mm.plugin.sns.a.b.j.a(com.tencent.mm.plugin.sns.a.b.j.b.Sight, com.tencent.mm.plugin.sns.a.b.j.a.LeavelFullScreen, this.ros, this.cvd);
        }
        af.cnA().b((b) this);
        com.tencent.mm.modelsns.b u = com.tencent.mm.modelsns.b.u(getIntent());
        if (u != null) {
            if (this.qFG) {
                u.cS(!bo.isNullOrNil(this.cNr.wEO));
            } else {
                u.cS(false);
            }
            u.update();
            u.ajK();
        }
        if (com.tencent.mm.r.a.Cc() != null) {
            com.tencent.mm.r.a.Cc().Ic();
        }
        if (this.klq != null) {
            this.klq.setVideoCallback(null);
            this.klq.stop();
            this.klq.onDetach();
        }
        if (!this.qyS) {
            tn tnVar = new tn();
            tnVar.cPI.type = 0;
            tnVar.cPI.cPJ = this.qxZ;
            tnVar.cPI.cPK = this.mik;
            tnVar.cPI.cPL = this.cPL;
            com.tencent.mm.sdk.b.a.xxA.m(tnVar);
        }
        this.iaf.cy(false);
        AppMethodBeat.o(39274);
    }

    public void onStart() {
        AppMethodBeat.i(39275);
        Bundle bundle = this.jWy;
        if (!this.jYD) {
            this.jYD = true;
            if (VERSION.SDK_INT >= 12) {
                this.kkq = getIntent().getIntExtra("img_gallery_top", 0);
                this.kkr = getIntent().getIntExtra("img_gallery_left", 0);
                this.kks = getIntent().getIntExtra("img_gallery_width", 0);
                this.kkt = getIntent().getIntExtra("img_gallery_height", 0);
                this.jYE.L(this.kkr, this.kkq, this.kks, this.kkt);
                if (bundle == null) {
                    this.qzb.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                        public final boolean onPreDraw() {
                            AppMethodBeat.i(39249);
                            SnsSightPlayerUI.this.qzb.getViewTreeObserver().removeOnPreDrawListener(this);
                            SnsSightPlayerUI.this.jYE.a(SnsSightPlayerUI.this.qzb, SnsSightPlayerUI.this.mmX, null);
                            AppMethodBeat.o(39249);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
        AppMethodBeat.o(39275);
    }

    public void onResume() {
        AppMethodBeat.i(39276);
        super.onResume();
        if (!this.bZi) {
            ab.i("MicroMsg.SnsSightPlayerUI", "initOrientation ".concat(String.valueOf(getResources().getConfiguration().orientation)));
            if (getResources().getConfiguration().orientation == 2) {
                ag(getResources().getConfiguration().orientation, true);
            }
            this.bZi = true;
        }
        if (this.qzk == 0 || this.qzj == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.qzk = displayMetrics.heightPixels;
            this.qzj = displayMetrics.widthPixels;
        }
        if (this.ruY && com.tencent.mm.vfs.e.ct(this.ePJ)) {
            kB(false);
            this.ruY = false;
        }
        if (this.rwL != null) {
            this.rwL.onResume();
        }
        AppMethodBeat.o(39276);
    }

    public void onPause() {
        AppMethodBeat.i(39277);
        super.onPause();
        int i = getResources().getConfiguration().orientation;
        ab.i("MicroMsg.SnsSightPlayerUI", "onpause  ".concat(String.valueOf(i)));
        Ef(i);
        if (this.ruY) {
            cpN();
        } else {
            cpN();
            ab.v("check", "onclick");
            new ak().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(39248);
                    SnsSightPlayerUI.this.finish();
                    AppMethodBeat.o(39248);
                }
            });
        }
        if (this.rwL != null) {
            this.rwL.fQd = bo.yz();
        }
        AppMethodBeat.o(39277);
    }

    public final void bcW() {
        AppMethodBeat.i(39278);
        int width = this.qzb.getWidth();
        int height = this.qzb.getHeight();
        if (!(this.kks == 0 || this.kkt == 0)) {
            height = (int) ((((float) width) / ((float) this.kks)) * ((float) this.kkt));
        }
        this.jYE.hw(width, height);
        this.jYE.L(this.kkr, this.kkq, this.kks, this.kkt);
        if (((double) this.rpz) != 1.0d) {
            width = ae.fr(this.mController.ylL);
            this.jYE.zEZ = 1.0f / this.rpz;
            if (!(this.rpA == 0 && this.rpB == 0)) {
                this.jYE.hy(((int) (((float) (this.qzb.getWidth() / 2)) * (1.0f - this.rpz))) + this.rpA, (int) ((((float) ((width + this.qzb.getHeight()) / 2)) - (((float) (height / 2)) * this.rpz)) + ((float) this.rpB)));
            }
        }
        this.jYE.a(this.qzb, this.mmX, new com.tencent.mm.ui.tools.e.b() {
            public final void onAnimationStart() {
                AppMethodBeat.i(39251);
                if (SnsSightPlayerUI.this.mlK != null) {
                    SnsSightPlayerUI.this.mlK.setVisibility(8);
                }
                AppMethodBeat.o(39251);
            }

            public final void onAnimationEnd() {
                AppMethodBeat.i(39252);
                new ak().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(39250);
                        SnsSightPlayerUI.this.finish();
                        SnsSightPlayerUI.this.overridePendingTransition(0, 0);
                        AppMethodBeat.o(39250);
                    }
                });
                AppMethodBeat.o(39252);
            }
        }, null);
        AppMethodBeat.o(39278);
    }

    public void onBackPressed() {
        AppMethodBeat.i(39279);
        bcW();
        AppMethodBeat.o(39279);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(39280);
        if (4097 == i) {
            if (-1 == i2) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str : bo.P(stringExtra.split(","))) {
                    if (this.cvd == 0) {
                        com.tencent.mm.plugin.sns.storage.n YT = af.cnF().YT(this.czD);
                        if (YT != null) {
                            if (t.kH(str)) {
                                rf rfVar = new rf();
                                rfVar.cNk.cFc = i.j(YT);
                                rfVar.cNk.cwT = YT.cqU();
                                com.tencent.mm.sdk.b.a.xxA.m(rfVar);
                            } else {
                                rg rgVar = new rg();
                                rgVar.cNl.cFc = i.j(YT);
                                rgVar.cNl.cwT = YT.cqU();
                                com.tencent.mm.sdk.b.a.xxA.m(rgVar);
                            }
                        }
                    }
                    TimeLineObject cqu = this.ros.cqu();
                    if (this.qFG) {
                        com.tencent.mm.plugin.sns.storage.b cqo = this.ros.cqo();
                        cfh cfh = new cfh();
                        cfh.wid = this.cNr.rEd;
                        cfh.fiG = this.cNr.wEO;
                        if (cqu.xfI.wbJ == 15) {
                            cfh.fiM = this.rwP.qPj;
                            cfh.fiN = cqu.Id;
                        } else {
                            cfh.fiM = cqu.xfN.fiM;
                            cfh.fiN = cqu.xfN.fiN;
                        }
                        cfh.fiI = bo.isNullOrNil(this.cNr.wES) ? cqu.xfF : this.cNr.wES;
                        if (bo.isNullOrNil(this.cNr.wER)) {
                            stringExtra = this.cNr.wEH;
                        } else {
                            stringExtra = this.cNr.wER;
                        }
                        cfh.fiL = stringExtra;
                        if (cqo != null && cqo.qUn == 0) {
                            cfh.fiK = cqo.qUp;
                            cfh.fiJ = cqo.qUo;
                        }
                        if (cqo != null) {
                            cfh.fiK = cqo.qTA;
                        }
                        ab.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", str, this.ePJ, this.imagePath, this.cNr.wEO, Integer.valueOf(this.cNr.rEd), cfh.fiL, Integer.valueOf(i.Xr(this.ePJ)));
                        com.tencent.mm.plugin.messenger.a.g.bOk().a(this, str, this.ePJ, this.imagePath, 43, r6, cfh, cqu.rjC);
                    } else {
                        ab.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", str, this.ePJ, this.imagePath, Integer.valueOf(i.Xr(this.ePJ)));
                        com.tencent.mm.plugin.messenger.a.g.bOk().a(this, str, this.ePJ, this.imagePath, 43, r6, cqu.rjC);
                    }
                    if (stringExtra2 != null) {
                        com.tencent.mm.plugin.messenger.a.g.bOk().eZ(stringExtra2, str);
                    }
                    com.tencent.mm.ui.widget.snackbar.b.i(this, getString(R.string.cbn));
                    if (this.qFG) {
                        c cVar;
                        int mA;
                        i.a(new SnsAdClick(this.cvd, 5, this.ros.field_snsId, 12, 0));
                        boolean kH = t.kH(str);
                        com.tencent.mm.plugin.sns.a.b.j.d dVar = com.tencent.mm.plugin.sns.a.b.j.d.Sight;
                        if (kH) {
                            cVar = c.Chatroom;
                        } else {
                            cVar = c.Chat;
                        }
                        e eVar = e.Full;
                        if (kH) {
                            mA = com.tencent.mm.model.n.mA(str);
                        } else {
                            mA = 0;
                        }
                        com.tencent.mm.plugin.sns.a.b.j.a(dVar, cVar, eVar, mA, this.ros, this.cvd);
                    }
                }
            } else if (this.qFG) {
                i.a(new SnsAdClick(this.cvd, 5, this.ros.field_snsId, 13, 0));
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(39280);
    }

    public final void Xw(String str) {
    }

    public final void bj(String str, boolean z) {
    }

    public final void cmu() {
    }

    public final void bk(String str, boolean z) {
        AppMethodBeat.i(39281);
        ab.i("MicroMsg.SnsSightPlayerUI", "onSightFinish ".concat(String.valueOf(str)));
        if (this.qFG && !bo.isNullOrNil(str) && this.cNr != null && str.equals(this.cNr.Id) && com.tencent.mm.vfs.e.ct(this.ePJ)) {
            this.rwL.qEk = 1;
            this.klq.setVideoPath(this.ePJ);
            kB(true);
            if (this.rwO != null) {
                this.rwO.setVisibility(8);
            }
        }
        AppMethodBeat.o(39281);
    }

    public final int getForceOrientation() {
        return 7;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(39282);
        super.onConfigurationChanged(configuration);
        ab.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + configuration.orientation + " " + this.qzr);
        if (this.qzr == configuration.orientation) {
            AppMethodBeat.o(39282);
            return;
        }
        int i = configuration.orientation;
        ag(configuration.orientation, false);
        this.qzr = configuration.orientation;
        AppMethodBeat.o(39282);
    }

    private void ag(int i, boolean z) {
        AppMethodBeat.i(39283);
        if (this.qzk == 0 || this.qzj == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.qzk = displayMetrics.heightPixels;
            this.qzj = displayMetrics.widthPixels;
        }
        ViewGroup.LayoutParams layoutParams = this.qzb.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.rwN.getLayoutParams();
        LayoutParams layoutParams3 = new LayoutParams(-1, -2);
        if (i == 1) {
            layoutParams3.width = this.qzj;
            layoutParams3.height = (int) (((((double) this.qzj) * 1.0d) * 240.0d) / 320.0d);
            layoutParams2.addRule(12, 0);
            layoutParams2.addRule(1, 0);
            layoutParams2.addRule(11, -1);
            layoutParams2.addRule(3, this.qzb.getId());
            findViewById(R.id.bn0).setVisibility(0);
        } else {
            layoutParams3.height = this.qzj;
            layoutParams3.width = (int) (((((double) this.qzj) * 1.0d) * 320.0d) / 240.0d);
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(3, 0);
            layoutParams2.addRule(12, -1);
            layoutParams2.addRule(1, this.qzb.getId());
            findViewById(R.id.bn0).setVisibility(8);
        }
        ab.i("MicroMsg.SnsSightPlayerUI", "orientation " + i + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.klq).setLayoutParams(layoutParams3);
        if (this.klq instanceof com.tencent.mm.plugin.sight.decode.a.a) {
            ((com.tencent.mm.plugin.sight.decode.a.a) this.klq).fi(layoutParams3.width, layoutParams3.height);
        }
        layoutParams.height = layoutParams3.height;
        layoutParams.width = layoutParams3.width;
        this.qyR.setLayoutParams(layoutParams2);
        this.qzb.setLayoutParams(layoutParams);
        ((View) this.klq).requestLayout();
        if (!z) {
            Ef(i);
        }
        AppMethodBeat.o(39283);
    }

    private void Ef(int i) {
        AppMethodBeat.i(39284);
        if (this.qFG) {
            if (this.klq.isPlaying()) {
                if (this.duration == 0) {
                    this.duration = this.klq.getDuration();
                }
                this.rwL.CI(this.duration);
                this.rwL.qEs.qFu = bo.yz();
                this.rwL.qEs.qFt = i == 2 ? 2 : 1;
                this.rwL.qEs.qFs = 2;
                ab.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.rwL.qEs.qFt);
            }
            AppMethodBeat.o(39284);
            return;
        }
        AppMethodBeat.o(39284);
    }
}
