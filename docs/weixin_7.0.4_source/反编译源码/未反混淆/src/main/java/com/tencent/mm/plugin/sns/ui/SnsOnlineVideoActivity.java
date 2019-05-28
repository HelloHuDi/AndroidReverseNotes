package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.m.g;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.e;

@a(3)
public class SnsOnlineVideoActivity extends MMActivity {
    private float aKM = 0.0f;
    private float aKN = 0.0f;
    private bau cNr;
    private String czD;
    private String ePJ;
    private boolean eif;
    private GestureDetector iay;
    d jOb = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            boolean z = false;
            AppMethodBeat.i(39149);
            Intent intent;
            sb sbVar;
            switch (menuItem.getItemId()) {
                case 1:
                    intent = new Intent();
                    n YT = af.cnF().YT(SnsOnlineVideoActivity.this.czD);
                    if (YT != null) {
                        ab.i("MicroMsg.SnsOnlineVideoActivity", "expose id " + YT.cqA());
                    }
                    intent.putExtra("k_expose_msg_id", YT == null ? Integer.valueOf(0) : YT.cqA());
                    intent.putExtra("k_username", YT == null ? "" : YT.field_userName);
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                    com.tencent.mm.bp.d.b(SnsOnlineVideoActivity.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(39149);
                    return;
                case 2:
                    sb sbVar2 = new sb();
                    sbVar2.cNV.cAd = 2;
                    sbVar2.cNV.cNW = 17;
                    sb.a aVar = sbVar2.cNV;
                    if (SnsOnlineVideoActivity.this.scene == 0) {
                        z = true;
                    }
                    aVar.cNX = z;
                    sbVar2.cNV.czD = SnsOnlineVideoActivity.this.czD;
                    com.tencent.mm.sdk.b.a.xxA.m(sbVar2);
                    AppMethodBeat.o(39149);
                    return;
                case 3:
                    SnsOnlineVideoActivity.this.ruY = true;
                    sbVar = new sb();
                    sbVar.cNV.cAd = 1;
                    sbVar.cNV.cNY = 4097;
                    sbVar.cNV.czD = SnsOnlineVideoActivity.this.czD;
                    com.tencent.mm.sdk.b.a.xxA.m(sbVar);
                    AppMethodBeat.o(39149);
                    return;
                case 4:
                    n YT2 = af.cnF().YT(SnsOnlineVideoActivity.this.czD);
                    if (YT2 == null) {
                        AppMethodBeat.o(39149);
                        return;
                    }
                    intent = new Intent();
                    if (YT2.cqu().xfI.wbJ == 15 && ((bau) YT2.cqu().xfI.wbK.get(0)) == null) {
                        ab.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
                        AppMethodBeat.o(39149);
                        return;
                    }
                    intent.putExtra("exdevice_open_scene_type", 2);
                    intent.putExtra("sns_local_id", SnsOnlineVideoActivity.this.czD);
                    intent.putExtra("sns_send_data_ui_activity", true);
                    com.tencent.mm.bp.d.f(SnsOnlineVideoActivity.this, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                    AppMethodBeat.o(39149);
                    return;
                case 5:
                    sbVar = new sb();
                    sbVar.cNV.cAd = 3;
                    sbVar.cNV.czD = SnsOnlineVideoActivity.this.czD;
                    com.tencent.mm.sdk.b.a.xxA.m(sbVar);
                    break;
            }
            AppMethodBeat.o(39149);
        }
    };
    private Bundle jWy;
    private boolean jYD = false;
    private e jYE;
    private int kkq = 0;
    private int kkr = 0;
    private int kks = 0;
    private int kkt = 0;
    private boolean mOO;
    private VelocityTracker mVelocityTracker;
    private boolean mmD = true;
    private RelativeLayout mmW;
    private ImageView mmX;
    private boolean osu;
    private com.tencent.mm.ui.widget.a.d riy;
    private boolean rkM = false;
    private n ros;
    private int rpA = 0;
    private int rpB = 0;
    private boolean rpn = true;
    private Button rpq;
    private float rpz = 1.0f;
    private OnlineVideoView ruX;
    private boolean ruY = false;
    private boolean ruZ;
    private boolean rva = false;
    private boolean rvb = false;
    private boolean rvc = false;
    private boolean rvd = false;
    c rve = new c() {
        /* JADX WARNING: Missing block: B:4:0x0054, code skipped:
            if (r3 != false) goto L_0x0056;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(l lVar) {
            int i = 1;
            AppMethodBeat.i(39148);
            if (bo.ank(g.Nu().getValue("SIGHTCannotTransmitForFav")) == 0) {
                ab.i("MicroMsg.SnsOnlineVideoActivity", "config can forward sight, thumb existed %B, video existed %B", Boolean.valueOf(com.tencent.mm.vfs.e.ct(SnsOnlineVideoActivity.this.thumbPath)), Boolean.valueOf(com.tencent.mm.vfs.e.ct(SnsOnlineVideoActivity.this.ePJ)));
                lVar.add(0, 3, 0, SnsOnlineVideoActivity.this.getString(R.string.ejf));
                if (com.tencent.mm.vfs.e.ct(SnsOnlineVideoActivity.this.thumbPath)) {
                }
            }
            i = 0;
            if (com.tencent.mm.bp.d.afj("favorite")) {
                lVar.add(0, 2, 0, SnsOnlineVideoActivity.this.getString(R.string.dcq));
            }
            lVar.add(0, 5, 0, SnsOnlineVideoActivity.this.getString(R.string.dx0));
            if (i != 0) {
                dq dqVar = new dq();
                dqVar.cxc.cwT = SnsOnlineVideoActivity.this.czD;
                com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                if (dqVar.cxd.cwB) {
                    lVar.add(0, 4, 0, SnsOnlineVideoActivity.this.getString(R.string.s7));
                }
            }
            AppMethodBeat.o(39148);
        }
    };
    private int scene = 0;
    private String thumbPath;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsOnlineVideoActivity() {
        AppMethodBeat.i(39162);
        AppMethodBeat.o(39162);
    }

    static /* synthetic */ void i(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        AppMethodBeat.i(39174);
        snsOnlineVideoActivity.bdd();
        AppMethodBeat.o(39174);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39163);
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        super.onCreate(bundle);
        this.jWy = bundle;
        this.thumbPath = getIntent().getStringExtra("intent_thumbpath");
        this.czD = getIntent().getStringExtra("intent_localid");
        this.scene = getIntent().getIntExtra("intent_from_scene", -1);
        this.mOO = getIntent().getBooleanExtra("intent_ispreview", false);
        this.eif = getIntent().getBooleanExtra("intent_ismute", false);
        this.rkM = getIntent().getBooleanExtra("KBlockAdd", false);
        ab.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", this.thumbPath, this.czD, Integer.valueOf(this.scene), Boolean.valueOf(this.mOO), Boolean.valueOf(this.eif), getIntent().getStringExtra("intent_videopath"));
        if (this.mOO) {
            this.ePJ = r0;
        } else {
            try {
                this.ros = af.cnF().YT(this.czD);
                this.cNr = (bau) this.ros.cqu().xfI.wbK.get(0);
                this.ePJ = an.fZ(af.getAccSnsPath(), this.cNr.Id) + i.j(this.cNr);
                ab.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", this.ros.cqU());
            } catch (Exception e) {
                ab.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + e.toString());
            }
        }
        try {
            if (com.tencent.mm.compatible.util.d.iW(19)) {
                if (!this.mOO) {
                    getWindow().setFlags(201327616, 201327616);
                }
                this.osu = true;
            } else {
                if (!this.mOO) {
                    getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                }
                this.osu = false;
            }
            getWindow().addFlags(128);
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", e2, "", new Object[0]);
        }
        this.mmW = (RelativeLayout) findViewById(R.id.aew);
        this.ruX = (OnlineVideoView) findViewById(R.id.wh);
        if (this.mOO) {
            OnlineVideoView onlineVideoView = this.ruX;
            String str = this.ePJ;
            String str2 = this.thumbPath;
            onlineVideoView.rlg = str;
            onlineVideoView.mOO = true;
            onlineVideoView.mmB.setImageBitmap(b.i(str2, 1.0f));
            ab.i("MicroMsg.OnlineVideoView", "%d set preview video %s isPreview %b ", Integer.valueOf(onlineVideoView.hashCode()), str, Boolean.valueOf(onlineVideoView.mOO));
        } else {
            this.ruX.a(this.cNr, this.ros.cqU(), this.ros.field_createTime);
        }
        this.ruX.setMute(this.eif);
        this.mmX = (ImageView) findViewById(R.id.adg);
        this.mmX.setLayerType(2, null);
        if (this.mOO) {
            setMMTitle((int) R.string.g1);
            this.ruX.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    int i;
                    boolean z = false;
                    AppMethodBeat.i(39142);
                    SnsOnlineVideoActivity snsOnlineVideoActivity = SnsOnlineVideoActivity.this;
                    if (SnsOnlineVideoActivity.this.rpn) {
                        i = 8;
                    } else {
                        i = 0;
                    }
                    snsOnlineVideoActivity.setTitleVisibility(i);
                    SnsOnlineVideoActivity snsOnlineVideoActivity2 = SnsOnlineVideoActivity.this;
                    if (!SnsOnlineVideoActivity.this.rpn) {
                        z = true;
                    }
                    snsOnlineVideoActivity2.rpn = z;
                    AppMethodBeat.o(39142);
                }
            });
        } else {
            this.mController.hideTitleView();
            this.mmW.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(39150);
                    SnsOnlineVideoActivity.this.bcW();
                    AppMethodBeat.o(39150);
                    return true;
                }
            });
        }
        this.iay = new GestureDetector(this.mController.ylL, new SimpleOnGestureListener() {
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                AppMethodBeat.i(39151);
                float rawX = motionEvent2.getRawX() - motionEvent.getRawX();
                float rawY = motionEvent2.getRawY() - motionEvent.getRawY();
                if (Math.abs(rawX) <= ((float) SnsOnlineVideoActivity.this.mmW.getWidth()) && Math.abs(rawY) <= ((float) SnsOnlineVideoActivity.this.mmW.getHeight()) && SnsOnlineVideoActivity.this.rvb) {
                    SnsOnlineVideoActivity.this.ruX.setTranslationX(rawX);
                    SnsOnlineVideoActivity.this.ruX.setTranslationY(rawY);
                }
                AppMethodBeat.o(39151);
                return true;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(39152);
                SnsOnlineVideoActivity.this.rvd = true;
                super.onLongPress(motionEvent);
                AppMethodBeat.o(39152);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(39153);
                if (!SnsOnlineVideoActivity.this.mOO) {
                    SnsOnlineVideoActivity.this.bcW();
                }
                boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
                AppMethodBeat.o(39153);
                return onSingleTapUp;
            }
        });
        this.ruX.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                float f = 1.0f;
                AppMethodBeat.i(39154);
                SnsOnlineVideoActivity.this.iay.onTouchEvent(motionEvent);
                if (SnsOnlineVideoActivity.this.mVelocityTracker == null) {
                    SnsOnlineVideoActivity.this.mVelocityTracker = VelocityTracker.obtain();
                }
                if (SnsOnlineVideoActivity.this.mVelocityTracker != null) {
                    SnsOnlineVideoActivity.this.mVelocityTracker.addMovement(motionEvent);
                }
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        SnsOnlineVideoActivity.this.aKM = motionEvent.getX();
                        SnsOnlineVideoActivity.this.aKN = motionEvent.getY();
                        if (SnsOnlineVideoActivity.this.rvc) {
                            SnsOnlineVideoActivity.i(SnsOnlineVideoActivity.this);
                            SnsOnlineVideoActivity.this.rvc = false;
                            break;
                        }
                        break;
                    case 1:
                        if (SnsOnlineVideoActivity.this.rvc) {
                            SnsOnlineVideoActivity.this.ruX.setPivotX((float) (SnsOnlineVideoActivity.this.mmW.getWidth() / 2));
                            SnsOnlineVideoActivity.this.ruX.setPivotY((float) (SnsOnlineVideoActivity.this.mmW.getHeight() / 2));
                            SnsOnlineVideoActivity.this.ruX.setScaleX(1.0f);
                            SnsOnlineVideoActivity.this.ruX.setScaleY(1.0f);
                            SnsOnlineVideoActivity.this.ruX.setTranslationX(0.0f);
                            SnsOnlineVideoActivity.this.ruX.setTranslationY(0.0f);
                            SnsOnlineVideoActivity.this.mmX.setAlpha(1.0f);
                            SnsOnlineVideoActivity.this.rpz = 1.0f;
                            SnsOnlineVideoActivity.this.rvb = false;
                            SnsOnlineVideoActivity.this.rvd = false;
                            AppMethodBeat.o(39154);
                            return true;
                        } else if (!SnsOnlineVideoActivity.this.rvb || SnsOnlineVideoActivity.this.rvd) {
                            SnsOnlineVideoActivity.this.rvd = false;
                            break;
                        } else {
                            SnsOnlineVideoActivity.this.bcW();
                            SnsOnlineVideoActivity.this.rvd = false;
                            AppMethodBeat.o(39154);
                            return true;
                        }
                        break;
                    case 2:
                        VelocityTracker g = SnsOnlineVideoActivity.this.mVelocityTracker;
                        g.computeCurrentVelocity(1000);
                        int xVelocity = (int) g.getXVelocity();
                        int yVelocity = (int) g.getYVelocity();
                        float translationX = SnsOnlineVideoActivity.this.ruX.getTranslationX();
                        float translationY = SnsOnlineVideoActivity.this.ruX.getTranslationY();
                        SnsOnlineVideoActivity.this.rpA = (int) translationX;
                        SnsOnlineVideoActivity.this.rpB = (int) translationY;
                        ab.d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", Boolean.valueOf(SnsOnlineVideoActivity.this.rvb), Float.valueOf(translationX), Float.valueOf(translationY), Integer.valueOf(xVelocity), Integer.valueOf(yVelocity));
                        if ((Math.abs(translationX) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || SnsOnlineVideoActivity.this.rvd) && !SnsOnlineVideoActivity.this.rvb) {
                            SnsOnlineVideoActivity.this.rvb = false;
                        } else {
                            translationX = 1.0f - (translationY / ((float) SnsOnlineVideoActivity.this.mmW.getHeight()));
                            if (translationX <= 1.0f) {
                                f = translationX;
                            }
                            if (((yVelocity > 0 && f < SnsOnlineVideoActivity.this.rpz) || yVelocity < 0) && ((double) f) >= 0.5d) {
                                ab.d("MicroMsg.SnsOnlineVideoActivity", "dancy scale:%s", Float.valueOf(f));
                                SnsOnlineVideoActivity.this.rpz = f;
                                SnsOnlineVideoActivity.this.ruX.setPivotX((float) (SnsOnlineVideoActivity.this.mmW.getWidth() / 2));
                                SnsOnlineVideoActivity.this.ruX.setPivotY((float) (SnsOnlineVideoActivity.this.mmW.getHeight() / 2));
                                SnsOnlineVideoActivity.this.ruX.setScaleX(f);
                                SnsOnlineVideoActivity.this.ruX.setScaleY(f);
                                SnsOnlineVideoActivity.this.ruX.setTranslationY(translationY);
                                SnsOnlineVideoActivity.this.mmX.setAlpha(f);
                            }
                            SnsOnlineVideoActivity.this.rvb = true;
                        }
                        if (translationY > 200.0f) {
                            SnsOnlineVideoActivity.this.rvc = false;
                        } else if (translationY > 10.0f) {
                            SnsOnlineVideoActivity.this.rvc = true;
                        }
                        if (translationY > 50.0f) {
                            SnsOnlineVideoActivity.this.ruX.setOnLongClickListener(null);
                        }
                        if (SnsOnlineVideoActivity.this.mVelocityTracker != null) {
                            SnsOnlineVideoActivity.this.mVelocityTracker.recycle();
                            SnsOnlineVideoActivity.this.mVelocityTracker = null;
                        }
                        if (SnsOnlineVideoActivity.this.rvb) {
                            AppMethodBeat.o(39154);
                            return true;
                        }
                        break;
                }
                AppMethodBeat.o(39154);
                return false;
            }
        });
        this.jYE = new e(this.mController.ylL);
        n nVar = this.ros;
        if (nVar == null) {
            ab.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
        } else {
            this.rpq = (Button) findViewById(R.id.eh7);
            final TimeLineObject cqu = nVar.cqu();
            final av avVar = cqu != null ? cqu.qNO : null;
            av avVar2 = new av();
            af.a(this, avVar2, cqu.qNO);
            if (avVar2.rBh) {
                this.rpq.setVisibility(0);
                this.rpq.setText(avVar2.rBi);
                this.rpq.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(39158);
                        if (avVar.vCy == null) {
                            AppMethodBeat.o(39158);
                            return;
                        }
                        SnsOnlineVideoActivity.this.ruZ = true;
                        String df = com.tencent.mm.plugin.sns.c.a.gkF.df(avVar.vCy.fKh);
                        int i = 0;
                        if (cqu.xfI.wbJ == 1) {
                            i = 2;
                        } else if (cqu.xfI.wbJ == 3) {
                            i = 5;
                        } else if (cqu.xfI.wbJ == 15) {
                            i = 38;
                        }
                        if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(cqu, SnsOnlineVideoActivity.this)) {
                            com.tencent.mm.plugin.sns.c.a.gkF.a(SnsOnlineVideoActivity.this, avVar.vCy.fKh, df, cqu.jBB, i, 19, 9, avVar.vCy.vCs, cqu.Id);
                            AppMethodBeat.o(39158);
                            return;
                        }
                        gt gtVar;
                        switch (avVar.jCt) {
                            case 4:
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", avVar.Url);
                                com.tencent.mm.plugin.sns.c.a.gkE.i(intent, SnsOnlineVideoActivity.this);
                                com.tencent.mm.plugin.sns.c.a.gkF.a(SnsOnlineVideoActivity.this, avVar.vCy.fKh, df, cqu.jBB, i, 19, 1, avVar.vCy.vCs, cqu.Id);
                                AppMethodBeat.o(39158);
                                return;
                            case 5:
                                if (avVar.Scene == 1) {
                                    gtVar = new gt();
                                    gtVar.cBv.actionCode = 2;
                                    gtVar.cBv.scene = 3;
                                    gtVar.cBv.appId = avVar.vCy.fKh;
                                    gtVar.cBv.context = SnsOnlineVideoActivity.this;
                                    com.tencent.mm.sdk.b.a.xxA.m(gtVar);
                                    com.tencent.mm.plugin.sns.c.a.gkF.a(SnsOnlineVideoActivity.this, avVar.vCy.fKh, df, cqu.jBB, i, 19, 6, avVar.vCy.vCs, cqu.Id);
                                    AppMethodBeat.o(39158);
                                    return;
                                }
                                break;
                            case 6:
                                int a = af.a(SnsOnlineVideoActivity.this, avVar);
                                if (a != 1) {
                                    if (a == 2) {
                                        gt gtVar2 = new gt();
                                        gtVar2.cBv.context = SnsOnlineVideoActivity.this;
                                        gtVar2.cBv.actionCode = 1;
                                        gtVar2.cBv.appId = avVar.vCy.fKh;
                                        gtVar2.cBv.messageAction = avVar.vCy.vCu;
                                        gtVar2.cBv.messageExt = avVar.vCy.vCt;
                                        gtVar2.cBv.scene = 3;
                                        com.tencent.mm.sdk.b.a.xxA.m(gtVar2);
                                        com.tencent.mm.plugin.sns.c.a.gkF.a(SnsOnlineVideoActivity.this, avVar.vCy.fKh, df, cqu.jBB, i, 19, 3, avVar.vCy.vCs, cqu.Id);
                                        break;
                                    }
                                }
                                gtVar = new gt();
                                gtVar.cBv.context = SnsOnlineVideoActivity.this;
                                gtVar.cBv.actionCode = 2;
                                gtVar.cBv.appId = avVar.vCy.fKh;
                                gtVar.cBv.messageAction = avVar.vCy.vCu;
                                gtVar.cBv.messageExt = avVar.vCy.vCt;
                                gtVar.cBv.scene = 3;
                                com.tencent.mm.sdk.b.a.xxA.m(gtVar);
                                com.tencent.mm.plugin.sns.c.a.gkF.a(SnsOnlineVideoActivity.this, avVar.vCy.fKh, df, cqu.jBB, i, 19, 6, avVar.vCy.vCs, cqu.Id);
                                AppMethodBeat.o(39158);
                                return;
                                break;
                        }
                        AppMethodBeat.o(39158);
                    }
                });
                if (getRequestedOrientation() != 0) {
                    ctH();
                }
            } else {
                this.rpq.setVisibility(8);
            }
        }
        if (this.mOO) {
            if (!this.rkM) {
                addIconOptionMenu(0, R.string.p4, R.drawable.aiy, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(39156);
                        h.a(SnsOnlineVideoActivity.this, (int) R.string.eqa, (int) R.string.tz, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(39155);
                                SnsOnlineVideoActivity.this.rva = true;
                                SnsOnlineVideoActivity.this.bcW();
                                AppMethodBeat.o(39155);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AppMethodBeat.o(39156);
                        return true;
                    }
                });
            }
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(39157);
                    SnsOnlineVideoActivity.this.bcW();
                    AppMethodBeat.o(39157);
                    return true;
                }
            });
        }
        bdd();
        tn tnVar = new tn();
        tnVar.cPI.type = 1;
        com.tencent.mm.sdk.b.a.xxA.m(tnVar);
        AppMethodBeat.o(39163);
    }

    public final int getLayoutId() {
        return R.layout.ax4;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(39164);
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            ab.d("MicroMsg.SnsOnlineVideoActivity", "vertical orientation");
            ctH();
            AppMethodBeat.o(39164);
        } else if (configuration.orientation == 2) {
            ab.d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
            if (this.rpq != null && this.rpq.getVisibility() == 0) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.rpq.getLayoutParams();
                if (marginLayoutParams.bottomMargin != getResources().getDimensionPixelSize(R.dimen.a96)) {
                    marginLayoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.a96);
                    this.rpq.setLayoutParams(marginLayoutParams);
                }
            }
            AppMethodBeat.o(39164);
        } else {
            AppMethodBeat.o(39164);
        }
    }

    private void ctH() {
        AppMethodBeat.i(39165);
        boolean hw = ae.hw(this);
        int fr = ae.fr(this);
        if (this.osu && hw && this.rpq != null && this.rpq.getVisibility() == 0) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.rpq.getLayoutParams();
            marginLayoutParams.bottomMargin = fr + marginLayoutParams.bottomMargin;
            this.rpq.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(39165);
    }

    private void bdd() {
        AppMethodBeat.i(39166);
        if (this.mOO) {
            ab.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
            AppMethodBeat.o(39166);
            return;
        }
        this.ruX.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(39160);
                SnsOnlineVideoActivity.this.riy = new com.tencent.mm.ui.widget.a.d(SnsOnlineVideoActivity.this.mController.ylL, 1, false);
                SnsOnlineVideoActivity.this.riy.rBl = SnsOnlineVideoActivity.this.rve;
                SnsOnlineVideoActivity.this.riy.rBm = SnsOnlineVideoActivity.this.jOb;
                SnsOnlineVideoActivity.this.riy.zQf = new com.tencent.mm.ui.widget.a.d.a() {
                    public final void onDismiss() {
                        AppMethodBeat.i(39159);
                        SnsOnlineVideoActivity.this.riy = null;
                        AppMethodBeat.o(39159);
                    }
                };
                SnsOnlineVideoActivity.this.riy.cpD();
                AppMethodBeat.o(39160);
                return true;
            }
        });
        AppMethodBeat.o(39166);
    }

    public void onStart() {
        AppMethodBeat.i(39167);
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
                    this.ruX.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                        public final boolean onPreDraw() {
                            AppMethodBeat.i(39145);
                            SnsOnlineVideoActivity.this.ruX.getViewTreeObserver().removeOnPreDrawListener(this);
                            SnsOnlineVideoActivity.this.jYE.a(SnsOnlineVideoActivity.this.ruX, SnsOnlineVideoActivity.this.mmX, new e.b() {
                                public final void onAnimationStart() {
                                }

                                public final void onAnimationEnd() {
                                    AppMethodBeat.i(39144);
                                    if (SnsOnlineVideoActivity.this.ruX != null) {
                                        SnsOnlineVideoActivity.this.ruX.onResume();
                                    }
                                    AppMethodBeat.o(39144);
                                }
                            });
                            AppMethodBeat.o(39145);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
        AppMethodBeat.o(39167);
    }

    public void onResume() {
        AppMethodBeat.i(39168);
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        if (!this.mmD) {
            this.ruX.onResume();
        }
        this.mmD = false;
        if (this.ruY) {
            this.ruY = false;
        }
        super.onResume();
        o.JV(1);
        AppMethodBeat.o(39168);
    }

    public void onPause() {
        AppMethodBeat.i(39169);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        this.ruX.onPause();
        if (!this.ruY) {
            ab.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
            if (this.ruZ) {
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(39161);
                        SnsOnlineVideoActivity.this.finish();
                        AppMethodBeat.o(39161);
                    }
                }, 500);
            } else {
                new ak().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(39143);
                        SnsOnlineVideoActivity.this.finish();
                        AppMethodBeat.o(39143);
                    }
                });
            }
        }
        super.onPause();
        o.JV(2);
        AppMethodBeat.o(39169);
    }

    public void onDestroy() {
        AppMethodBeat.i(39170);
        this.ruX.onDestroy();
        try {
            getWindow().clearFlags(128);
        } catch (Exception e) {
        }
        super.onDestroy();
        if (this.ros != null && this.ros.cqu().xfI.wbK.size() > 0) {
            String str = ((bau) this.ros.cqu().xfI.wbK.get(0)).Url;
            int i = this.ros.cqu().xfP;
            u.a(aq.D((bau) this.ros.cqu().xfI.wbK.get(0)), new PInt(), new PInt());
            int playVideoDuration = this.ruX.getPlayVideoDuration();
            com.tencent.mm.plugin.report.service.h.pYm.e(15534, str, this.ros.cqu().Id, Integer.valueOf(i), Integer.valueOf(r3.value * 1000), Integer.valueOf(playVideoDuration * 1000));
        }
        AppMethodBeat.o(39170);
    }

    public final void bcW() {
        AppMethodBeat.i(39171);
        if (this.rpq != null && this.rpq.getVisibility() == 0) {
            this.rpq.setVisibility(8);
        }
        int width = this.mmW.getWidth();
        int height = this.mmW.getHeight();
        if (!(this.kks == 0 || this.kkt == 0)) {
            height = (int) ((((float) width) / ((float) this.kks)) * ((float) this.kkt));
        }
        this.jYE.hw(width, height);
        this.jYE.L(this.kkr, this.kkq, this.kks, this.kkt);
        if (((double) this.rpz) != 1.0d) {
            this.jYE.zEZ = 1.0f / this.rpz;
            if (!(this.rpA == 0 && this.rpB == 0)) {
                this.jYE.hy(((int) (((float) (this.mmW.getWidth() / 2)) * (1.0f - this.rpz))) + this.rpA, (int) (((float) ((this.mmW.getHeight() / 2) + this.rpB)) - (((float) (height / 2)) * this.rpz)));
            }
        }
        this.jYE.a(this.ruX, this.mmX, new e.b() {
            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                AppMethodBeat.i(39147);
                new ak().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(39146);
                        Intent intent = new Intent();
                        intent.putExtra("sns_update_preview_video_del", SnsOnlineVideoActivity.this.rva);
                        SnsOnlineVideoActivity.this.setResult(-1, intent);
                        SnsOnlineVideoActivity.this.finish();
                        SnsOnlineVideoActivity.this.overridePendingTransition(0, 0);
                        AppMethodBeat.o(39146);
                    }
                });
                AppMethodBeat.o(39147);
            }
        }, null);
        AppMethodBeat.o(39171);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(39172);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ab.d("MicroMsg.SnsOnlineVideoActivity", "dispatchKeyEvent");
            bcW();
            AppMethodBeat.o(39172);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(39172);
        return dispatchKeyEvent;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(39173);
        ab.i("MicroMsg.SnsOnlineVideoActivity", "on activity result reqCode %d resultCode %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (4097 == i && -1 == i2) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            for (String str : bo.P(stringExtra.split(","))) {
                if (this.scene == 0) {
                    n YT = af.cnF().YT(this.czD);
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
                int Xr = i.Xr(this.ePJ);
                if (bo.isNullOrNil(this.thumbPath)) {
                    bau bau = this.cNr;
                    if (bau == null) {
                        stringExtra = "";
                    } else {
                        String fZ = an.fZ(af.getAccSnsPath(), bau.Id);
                        stringExtra = fZ + i.e(bau);
                        ab.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", stringExtra, Boolean.valueOf(com.tencent.mm.vfs.e.ct(stringExtra)));
                        if (!com.tencent.mm.vfs.e.ct(stringExtra)) {
                            stringExtra = fZ + i.n(bau);
                            ab.i("MicroMsg.SnsVideoLogic", "get sns video thumb path %s", stringExtra);
                        }
                    }
                } else {
                    stringExtra = this.thumbPath;
                }
                this.thumbPath = stringExtra;
                ab.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", str, this.ePJ, this.thumbPath, this.cNr.wEO, Integer.valueOf(this.cNr.rEd), Integer.valueOf(Xr));
                com.tencent.mm.plugin.messenger.a.g.bOk().a(this, str, this.ePJ, this.thumbPath, 43, Xr, cqu.rjC);
                if (stringExtra2 != null) {
                    com.tencent.mm.plugin.messenger.a.g.bOk().eZ(stringExtra2, str);
                }
                com.tencent.mm.ui.widget.snackbar.b.i(this, getString(R.string.cbn));
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(39173);
    }

    public final int getForceOrientation() {
        return 2;
    }
}
