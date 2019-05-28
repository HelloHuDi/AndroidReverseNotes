package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C42192d;
import com.tencent.p177mm.model.C42192d.C42190a;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C26228rf;
import com.tencent.p177mm.p230g.p231a.C32626rb;
import com.tencent.p177mm.p230g.p231a.C37789qx;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C6550tn;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p230g.p231a.C9455rg;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.tools.C30759e;
import com.tencent.p177mm.p612ui.tools.C30759e.C24051b;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.model.C43558b.C43559b;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p1558j.C39739a;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C13354a;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C34928c;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C34929d;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C34930b;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C34931e;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C3863h;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C39726d;
import com.tencent.p177mm.plugin.sns.p514a.p515b.p1501a.C34926a;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C46510q;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C4783p;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoSightView;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.cfh;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.vfs.C5730e;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI */
public class SnsSightPlayerUI extends MMActivity implements C42190a, C43559b {
    private float aKM = 0.0f;
    private float aKN = 0.0f;
    private boolean bZi = false;
    private bau cNr = null;
    private int cPL = 0;
    public C46696j contextMenuHelper;
    private int cvd = 0;
    private String czD = "";
    private int duration = 0;
    private String ePJ = "";
    private boolean foa = false;
    private C42192d iaf;
    private GestureDetector iay;
    private String imagePath = "";
    C5279d jOb = new C350406();
    Bundle jWy;
    private boolean jYD = false;
    C30759e jYE;
    private int kkq = 0;
    private int kkr = 0;
    private int kks = 0;
    private int kkt = 0;
    C14979e klq = null;
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
    private C46236n ros = null;
    private int rpA = 0;
    private int rpB = 0;
    private float rpz = 1.0f;
    private boolean ruY = false;
    private boolean rvb = false;
    private boolean rvc = false;
    private boolean rvd = false;
    private C3863h rwL = new C3863h("SnsSightPlayerUI");
    private String rwM = "";
    private TextView rwN = null;
    private MMPinProgressBtn rwO = null;
    private C21980a rwP = null;
    private String rwQ = "";
    private RelativeLayout rwR;
    OnCreateContextMenuListener rwS = new C398125();
    private String thumbPath = "";

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$1 */
    class C39941 implements OnTouchListener {
        C39941() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(39247);
            SnsSightPlayerUI.this.bcW();
            AppMethodBeat.m2505o(39247);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$2 */
    class C39952 implements Runnable {
        C39952() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39248);
            SnsSightPlayerUI.this.finish();
            AppMethodBeat.m2505o(39248);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$3 */
    class C39963 implements OnPreDrawListener {
        C39963() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(39249);
            SnsSightPlayerUI.this.qzb.getViewTreeObserver().removeOnPreDrawListener(this);
            SnsSightPlayerUI.this.jYE.mo49166a(SnsSightPlayerUI.this.qzb, SnsSightPlayerUI.this.mmX, null);
            AppMethodBeat.m2505o(39249);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$4 */
    class C39974 implements C24051b {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$4$1 */
        class C39981 implements Runnable {
            C39981() {
            }

            public final void run() {
                AppMethodBeat.m2504i(39250);
                SnsSightPlayerUI.this.finish();
                SnsSightPlayerUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.m2505o(39250);
            }
        }

        C39974() {
        }

        public final void onAnimationStart() {
            AppMethodBeat.m2504i(39251);
            if (SnsSightPlayerUI.this.mlK != null) {
                SnsSightPlayerUI.this.mlK.setVisibility(8);
            }
            AppMethodBeat.m2505o(39251);
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(39252);
            new C7306ak().post(new C39981());
            AppMethodBeat.m2505o(39252);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$12 */
    class C1354812 extends SimpleOnGestureListener {
        C1354812() {
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(39265);
            float translationX = (((View) SnsSightPlayerUI.this.klq).getTranslationX() + motionEvent2.getX()) - motionEvent.getX();
            float translationY = (((View) SnsSightPlayerUI.this.klq).getTranslationY() + motionEvent2.getY()) - motionEvent.getY();
            if (SnsSightPlayerUI.this.rvb) {
                ((View) SnsSightPlayerUI.this.klq).setTranslationX(translationX);
                ((View) SnsSightPlayerUI.this.klq).setTranslationY(translationY);
            }
            AppMethodBeat.m2505o(39265);
            return true;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(39266);
            SnsSightPlayerUI.this.rvd = true;
            super.onLongPress(motionEvent);
            AppMethodBeat.m2505o(39266);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$14 */
    class C2202614 implements Runnable {
        C2202614() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39268);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            SnsSightPlayerUI.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            if (SnsSightPlayerUI.this.klq instanceof VideoSightView) {
                ((VideoSightView) SnsSightPlayerUI.this.klq).setDrawableWidth(displayMetrics.widthPixels);
            }
            ((View) SnsSightPlayerUI.this.klq).requestLayout();
            ((View) SnsSightPlayerUI.this.klq).postInvalidate();
            AppMethodBeat.m2505o(39268);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$13 */
    class C2912613 implements OnTouchListener {
        C2912613() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            float f = 1.0f;
            AppMethodBeat.m2504i(39267);
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
                            snsSightPlayerUI.contextMenuHelper = new C46696j(snsSightPlayerUI.mController.ylL);
                        }
                        snsSightPlayerUI.contextMenuHelper.mo75005a((View) snsSightPlayerUI.klq, snsSightPlayerUI.rwS, snsSightPlayerUI.jOb);
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
                        AppMethodBeat.m2505o(39267);
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
                        AppMethodBeat.m2505o(39267);
                        return true;
                    }
                    break;
            }
            AppMethodBeat.m2505o(39267);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$6 */
    class C350406 implements C5279d {
        C350406() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(39254);
            Intent intent;
            switch (menuItem.getItemId()) {
                case 1:
                    intent = new Intent();
                    C46236n YT = C13373af.cnF().mo62918YT(SnsSightPlayerUI.this.czD);
                    if (YT != null) {
                        C4990ab.m7416i("MicroMsg.SnsSightPlayerUI", "expose id " + YT.cqA());
                    }
                    intent.putExtra("k_expose_msg_id", YT == null ? Integer.valueOf(0) : YT.cqA());
                    intent.putExtra("k_username", YT == null ? "" : YT.field_userName);
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                    C25985d.m41467b(SnsSightPlayerUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(39254);
                    return;
                case 2:
                    C46236n YT2 = C13373af.cnF().mo62918YT(SnsSightPlayerUI.this.czD);
                    if (YT2 == null) {
                        AppMethodBeat.m2505o(39254);
                        return;
                    }
                    C45316cl c45316cl = new C45316cl();
                    C39739a.m67958a(c45316cl, YT2);
                    c45316cl.cvA.activity = SnsSightPlayerUI.this;
                    c45316cl.cvA.cvH = 17;
                    C4879a.xxA.mo10055m(c45316cl);
                    if (SnsSightPlayerUI.this.qFG) {
                        C29036i.m46098a(new SnsAdClick(SnsSightPlayerUI.this.cvd, 5, YT2.field_snsId, 11, 0));
                        C34927j.m57343a(C34929d.Sight, C34928c.Fav, C34931e.Full, 0, YT2, SnsSightPlayerUI.this.cvd);
                    }
                    if (SnsSightPlayerUI.this.cvd == 0) {
                        C32626rb c32626rb = new C32626rb();
                        c32626rb.cNg.cwT = YT2.cqU();
                        c32626rb.cNg.cFc = C29036i.m46115j(YT2);
                        C4879a.xxA.mo10055m(c32626rb);
                    }
                    AppMethodBeat.m2505o(39254);
                    return;
                case 3:
                    SnsSightPlayerUI.this.ruY = true;
                    Intent intent2 = new Intent();
                    intent2.putExtra("Select_Conv_Type", 3);
                    intent2.putExtra("select_is_ret", true);
                    intent2.putExtra("mutil_select_is_ret", true);
                    intent2.putExtra("image_path", SnsSightPlayerUI.this.imagePath);
                    intent2.putExtra("Retr_Msg_Type", 11);
                    C25985d.m41466b(SnsSightPlayerUI.this, ".ui.transmit.SelectConversationUI", intent2, 4097);
                    AppMethodBeat.m2505o(39254);
                    return;
                case 4:
                    C46236n YT3 = C13373af.cnF().mo62918YT(SnsSightPlayerUI.this.czD);
                    if (YT3 == null) {
                        AppMethodBeat.m2505o(39254);
                        return;
                    }
                    intent = new Intent();
                    if (YT3.cqu().xfI.wbJ != 15 || ((bau) YT3.cqu().xfI.wbK.get(0)) != null) {
                        intent.putExtra("exdevice_open_scene_type", 2);
                        intent.putExtra("sns_local_id", SnsSightPlayerUI.this.czD);
                        intent.putExtra("sns_send_data_ui_activity", true);
                        C25985d.m41473f(SnsSightPlayerUI.this, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        break;
                    }
                    C4990ab.m7420w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
                    AppMethodBeat.m2505o(39254);
                    return;
                    break;
            }
            AppMethodBeat.m2505o(39254);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$9 */
    class C350429 implements C14981a {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$9$2 */
        class C135492 implements Runnable {
            C135492() {
            }

            public final void run() {
                AppMethodBeat.m2504i(39259);
                if (SnsSightPlayerUI.this.qyR.getVisibility() != 0) {
                    SnsSightPlayerUI.this.qyR.setVisibility(0);
                    SnsSightPlayerUI.this.qyR.startAnimation(AnimationUtils.loadAnimation(SnsSightPlayerUI.this.mController.ylL, C25738R.anim.f8332b5));
                }
                AppMethodBeat.m2505o(39259);
            }
        }

        C350429() {
        }

        /* renamed from: pL */
        public final void mo8557pL() {
            AppMethodBeat.m2504i(39260);
            C4990ab.m7410d("MicroMsg.SnsSightPlayerUI", C1447g.m3074Mp() + " onPrepared");
            SnsSightPlayerUI.m89509a(SnsSightPlayerUI.this, true);
            AppMethodBeat.m2505o(39260);
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.m2504i(39261);
            C4990ab.m7413e("MicroMsg.SnsSightPlayerUI", "on play video error, what %d extra %d", Integer.valueOf(i), Integer.valueOf(i2));
            SnsSightPlayerUI.this.klq.stop();
            if (SnsSightPlayerUI.this.mlN) {
                AppMethodBeat.m2505o(39261);
                return;
            }
            SnsSightPlayerUI.this.mlN = true;
            C4872b.m7233A(Base64.encodeToString((C21846d.ckW() + "[SnsSightPlayerUI] on play video error, what " + i + " extra " + i2 + ", path=" + C5046bo.m7532bc(SnsSightPlayerUI.this.imagePath, "")).getBytes(), 2), "FullScreenPlaySight");
            final String e = SnsSightPlayerUI.this.imagePath;
            final Bitmap a = C32291o.ahl().mo73086a(e, C1338a.getDensity(SnsSightPlayerUI.this.mController.ylL), SnsSightPlayerUI.this.mController.ylL, -1);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(39258);
                    ImageView imageView = (ImageView) SnsSightPlayerUI.this.findViewById(2131823993);
                    if (imageView != null) {
                        imageView.setImageBitmap(a);
                        imageView.setVisibility(0);
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    C15429k.m23712a(SnsSightPlayerUI.this.mController.ylL, intent, C5730e.asY(e), "video/*");
                    try {
                        SnsSightPlayerUI.this.mController.ylL.startActivity(Intent.createChooser(intent, SnsSightPlayerUI.this.mController.ylL.getString(C25738R.string.bs9)));
                        AppMethodBeat.m2505o(39258);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
                        C30379h.m48467g(SnsSightPlayerUI.this.mController.ylL, C25738R.string.bpq, C25738R.string.bpr);
                        AppMethodBeat.m2505o(39258);
                    }
                }
            });
            AppMethodBeat.m2505o(39261);
        }

        /* renamed from: EA */
        public final void mo8553EA() {
            AppMethodBeat.m2504i(39262);
            C4990ab.m7410d("MicroMsg.SnsSightPlayerUI", "on completion");
            if (!SnsSightPlayerUI.this.qFG) {
                SnsSightPlayerUI.this.qyR.post(new C135492());
            }
            SnsSightPlayerUI.this.klq.setLoop(true);
            C34926a c34926a = SnsSightPlayerUI.this.rwL.qEs;
            c34926a.qFp++;
            SnsSightPlayerUI.m89509a(SnsSightPlayerUI.this, false);
            AppMethodBeat.m2505o(39262);
        }

        /* renamed from: dG */
        public final int mo8554dG(int i, int i2) {
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$10 */
    class C3981110 implements OnClickListener {
        C3981110() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39263);
            SnsSightPlayerUI.this.bcW();
            AppMethodBeat.m2505o(39263);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$5 */
    class C398125 implements OnCreateContextMenuListener {
        C398125() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x009d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            int i;
            AppMethodBeat.m2504i(39253);
            if (C5046bo.ank(C26373g.m41964Nu().getValue("SIGHTCannotTransmitForFav")) == 0) {
                C4990ab.m7417i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", Boolean.valueOf(C5730e.m8628ct(SnsSightPlayerUI.this.imagePath)), Boolean.valueOf(C5730e.m8628ct(SnsSightPlayerUI.this.ePJ)));
                if (C5730e.m8628ct(SnsSightPlayerUI.this.imagePath) && r3) {
                    contextMenu.add(0, 3, 0, SnsSightPlayerUI.this.getString(C25738R.string.ejf));
                    i = 1;
                    if (C25985d.afj("favorite")) {
                        contextMenu.add(0, 2, 0, SnsSightPlayerUI.this.getString(C25738R.string.dcq));
                    }
                    if (i != 0) {
                        C9321dq c9321dq = new C9321dq();
                        c9321dq.cxc.cwT = SnsSightPlayerUI.this.czD;
                        C4879a.xxA.mo10055m(c9321dq);
                        if (c9321dq.cxd.cwB) {
                            contextMenu.add(0, 4, 0, SnsSightPlayerUI.this.getString(C25738R.string.f9188s7));
                        }
                    }
                    if (!SnsSightPlayerUI.this.qFG) {
                        contextMenu.add(0, 1, 0, SnsSightPlayerUI.this.mController.ylL.getString(C25738R.string.epl));
                    }
                    AppMethodBeat.m2505o(39253);
                }
            }
            i = 0;
            if (C25985d.afj("favorite")) {
            }
            if (i != 0) {
            }
            if (SnsSightPlayerUI.this.qFG) {
            }
            AppMethodBeat.m2505o(39253);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$8 */
    class C398138 implements OnClickListener {
        C398138() {
        }

        public final void onClick(View view) {
            C37952b lY;
            AppMethodBeat.m2504i(39257);
            if (SnsSightPlayerUI.this.ros.mo74253DI(32)) {
                C34927j.m57341a(C34930b.Sight, C13354a.EnterCompleteVideo, SnsSightPlayerUI.this.ros, SnsSightPlayerUI.this.cvd);
            }
            Intent intent = new Intent();
            String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), SnsSightPlayerUI.this.cNr.f17915Id);
            String k = C29036i.m46119k(SnsSightPlayerUI.this.cNr);
            intent.setClass(SnsSightPlayerUI.this, VideoAdPlayerUI.class);
            intent.putExtra("KFullVideoPath", fZ + k);
            intent.putExtra("KThumbPath", SnsSightPlayerUI.this.imagePath);
            intent.putExtra("IsAd", true);
            intent.putExtra("KStremVideoUrl", SnsSightPlayerUI.this.cNr.wEO);
            intent.putExtra("KThumUrl", C5046bo.isNullOrNil(SnsSightPlayerUI.this.cNr.wER) ? SnsSightPlayerUI.this.cNr.wEH : SnsSightPlayerUI.this.cNr.wER);
            intent.putExtra("KMediaId", SnsSightPlayerUI.this.cNr.f17915Id);
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
            intent.putExtra("KSta_StremVideoPublishId", cqu.f15074Id);
            intent.putExtra("KSta_SourceType", 1);
            intent.putExtra("KSta_Scene", C34930b.Sight.value);
            intent.putExtra("KSta_FromUserName", cqu.jBB);
            intent.putExtra("KSta_SnSId", cqu.f15074Id);
            intent.putExtra("KSta_SnsStatExtStr", cqu.rjC);
            intent.putExtra("KMediaVideoTime", SnsSightPlayerUI.this.cNr.rEd);
            if (C5046bo.isNullOrNil(SnsSightPlayerUI.this.cNr.wES)) {
                fZ = cqu.xfF;
            } else {
                fZ = SnsSightPlayerUI.this.cNr.wES;
            }
            intent.putExtra("KMediaTitle", fZ);
            C21984b cqo = SnsSightPlayerUI.this.ros.cqo();
            if (cqo != null && cqo.qUn == 0) {
                intent.putExtra("StreamWording", cqo.qUo);
                intent.putExtra("StremWebUrl", cqo.qUp);
            }
            C46236n YT = C13373af.cnF().mo62918YT(SnsSightPlayerUI.this.czD);
            if (SnsSightPlayerUI.this.cvd == 0) {
                lY = C37952b.m64170lY(747);
            } else {
                lY = C37952b.m64171lZ(747);
            }
            lY.mo60722tx(C29036i.m46115j(YT)).mo60720mb(YT.field_type).mo60718cS(true).mo60722tx(YT.crc()).mo60720mb(SnsSightPlayerUI.this.cNr.rEd);
            lY.ajK();
            if (SnsSightPlayerUI.this.cvd == 0) {
                lY = C37952b.m64170lY(748);
            } else {
                lY = C37952b.m64171lZ(748);
            }
            lY.mo60722tx(C29036i.m46115j(YT)).mo60720mb(YT.field_type).mo60718cS(true).mo60722tx(YT.crc()).mo60720mb(SnsSightPlayerUI.this.cNr.rEd);
            lY.mo60717b(intent, "intent_key_StatisticsOplog");
            SnsSightPlayerUI.this.startActivity(intent);
            C29036i.m46098a(new SnsAdClick(SnsSightPlayerUI.this.cvd, 5, YT.field_snsId, 14, 0));
            if (SnsSightPlayerUI.this.cvd == 0) {
                C37789qx c37789qx = new C37789qx();
                c37789qx.cNd.cFy = true;
                C4879a.xxA.mo10055m(c37789qx);
            }
            AppMethodBeat.m2505o(39257);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI$11 */
    class C4624211 implements OnClickListener {
        C4624211() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39264);
            SnsSightPlayerUI.this.bcW();
            AppMethodBeat.m2505o(39264);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsSightPlayerUI() {
        AppMethodBeat.m2504i(39269);
        AppMethodBeat.m2505o(39269);
    }

    public void onCreate(Bundle bundle) {
        String fZ;
        AppMethodBeat.m2504i(39270);
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        this.cvd = getIntent().getIntExtra("intent_from_scene", -1);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.mController.hideTitleView();
        C13373af.cnA().mo69136a((C43559b) this);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(C25738R.color.f11782h4));
        }
        if (C1443d.m3068iW(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.jWy = bundle;
        this.iaf = new C42192d();
        this.ePJ = getIntent().getStringExtra("intent_videopath");
        this.imagePath = getIntent().getStringExtra("intent_thumbpath");
        this.czD = getIntent().getStringExtra("intent_localid");
        this.qFG = getIntent().getBooleanExtra("intent_isad", false);
        this.ros = C13373af.cnF().mo62918YT(this.czD);
        if (this.qFG) {
            boolean z;
            if (this.ros == null) {
                z = false;
            } else {
                this.cNr = (bau) this.ros.cqu().xfI.wbK.get(0);
                fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), this.cNr.f17915Id);
                this.rwQ = fZ + C29036i.m46119k(this.cNr);
                this.thumbPath = fZ + C29036i.m46108e(this.cNr);
                z = true;
            }
            if (!z) {
                finish();
                AppMethodBeat.m2505o(39270);
                return;
            }
        }
        if (C35973a.m59175Cc() != null) {
            C35973a.m59175Cc().mo4649Id();
        }
        C21980a cqr = this.ros != null ? this.cvd == 2 ? this.ros.cqr() : this.ros.cqq() : null;
        this.rwP = cqr;
        this.rwL.qEm = C5046bo.m7588yz();
        this.rwR = (RelativeLayout) findViewById(2131821333);
        this.rwR.setOnTouchListener(new C39941());
        C4990ab.m7410d("MicroMsg.SnsSightPlayerUI", C1447g.m3074Mp() + " initView: fullpath:" + this.ePJ + ", imagepath:" + this.imagePath);
        this.jYE = new C30759e(this.mController.ylL);
        this.mmX = (ImageView) findViewById(2131822079);
        this.mmX.setLayerType(2, null);
        this.qyR = (TextView) findViewById(2131823800);
        this.rwO = (MMPinProgressBtn) findViewById(2131827547);
        this.qzb = (ViewGroup) findViewById(2131823992);
        this.klq = C46510q.m87801fT(this.mController.ylL);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        this.mlK = (TextView) findViewById(2131827573);
        this.qzb.addView((View) this.klq, 0, layoutParams);
        this.rwN = (TextView) findViewById(2131827845);
        this.rwN.setText("");
        if (!this.qFG) {
            this.rwN.setVisibility(8);
        }
        if (this.qFG) {
            if (this.cNr == null) {
                this.mlK.setVisibility(8);
            } else if (C5046bo.isNullOrNil(this.cNr.wEO)) {
                C4990ab.m7416i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
                final TimeLineObject cqu = this.ros.cqu();
                C21984b cqo = this.ros.cqo();
                String str = cqo.qUo;
                final String str2 = cqo.qUp;
                if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
                    this.mlK.setVisibility(8);
                } else {
                    this.mlK.setVisibility(0);
                    this.mlK.setText(str);
                    this.mlK.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(39256);
                            if (C34930b.Sight.value != 0) {
                                C34927j.m57340a(C13354a.DetailInVideo, cqu.f15074Id, SnsSightPlayerUI.this.rwP == null ? "" : SnsSightPlayerUI.this.rwP.qPj, 1, C34930b.Sight.value, cqu.jBB, null, cqu.f15074Id, 0, 0, 0);
                            }
                            final Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putString("key_snsad_statextstr", cqu.rjC);
                            intent.putExtra("jsapiargs", bundle);
                            intent.putExtra("rawUrl", str2);
                            intent.putExtra("useJs", true);
                            C29036i.m46098a(new SnsAdClick(SnsSightPlayerUI.this.cvd, 5, SnsSightPlayerUI.this.ros.field_snsId, 18, 0));
                            new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(39255);
                                    C24826a.gkE.mo38924i(intent, SnsSightPlayerUI.this);
                                    SnsSightPlayerUI.this.finish();
                                    AppMethodBeat.m2505o(39255);
                                }
                            });
                            AppMethodBeat.m2505o(39256);
                        }
                    });
                }
            } else {
                fZ = getResources().getString(C25738R.string.ej7);
                if (this.cNr.rEd / 60 > 0) {
                    fZ = fZ + getResources().getString(C25738R.string.ej9, new Object[]{Integer.valueOf(this.cNr.rEd / 60)});
                }
                if (this.cNr.rEd % 60 > 0) {
                    fZ = fZ + getResources().getString(C25738R.string.ej_, new Object[]{Integer.valueOf(this.cNr.rEd % 60)});
                }
                this.mlK.setText(fZ + getResources().getString(C25738R.string.ej8));
                this.mlK.setVisibility(0);
                this.mlK.setOnClickListener(new C398138());
            }
            C4783p.m7142a(this.mlK, (VideoSightView) this.klq);
        } else {
            this.mlK.setVisibility(8);
        }
        this.klq.setVideoCallback(new C350429());
        findViewById(2131823992).setOnClickListener(new C3981110());
        ((View) this.klq).setOnClickListener(new C4624211());
        this.iay = new GestureDetector(this.mController.ylL, new C1354812());
        ((View) this.klq).setOnTouchListener(new C2912613());
        if (C5730e.m8628ct(this.ePJ)) {
            if (this.ePJ != null) {
                this.klq.stop();
                this.klq.setVideoPath(this.ePJ);
            }
            this.rwO.setVisibility(8);
            this.rwL.qEk = 1;
        } else {
            C13373af.cnA().mo69138a(this.cNr, 6, null, C44222az.xYU);
            this.rwO.setVisibility(0);
            this.rwO.dKB();
            this.rwL.qEk = 0;
        }
        C4990ab.m7410d("MicroMsg.SnsSightPlayerUI", (System.currentTimeMillis() - currentTimeMillis) + " initView end");
        C6550tn c6550tn = new C6550tn();
        c6550tn.cPI.type = 1;
        C4879a.xxA.mo10055m(c6550tn);
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new C46696j(this.mController.ylL);
        }
        this.contextMenuHelper.mo75005a((View) this.klq, this.rwS, this.jOb);
        ((View) this.klq).post(new C2202614());
        AppMethodBeat.m2505o(39270);
    }

    public void finish() {
        AppMethodBeat.m2504i(39271);
        if (!this.foa) {
            super.finish();
            this.foa = true;
        }
        AppMethodBeat.m2505o(39271);
    }

    /* renamed from: kB */
    private void m89527kB(boolean z) {
        AppMethodBeat.m2504i(39272);
        this.klq.start();
        this.duration = this.klq.getDuration();
        C4990ab.m7416i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
        this.iaf.mo67732a(this);
        if (z) {
            this.rwL.qEs.qFt = getResources().getConfiguration().orientation == 2 ? 2 : 1;
            this.rwL.qEs.qFu = C5046bo.m7588yz();
            this.rwL.qEs.qFs = 2;
        }
        AppMethodBeat.m2505o(39272);
    }

    private void cpN() {
        AppMethodBeat.m2504i(39273);
        C4990ab.m7416i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
        this.klq.pause();
        this.klq.onDetach();
        this.iaf.mo67733cy(false);
        AppMethodBeat.m2505o(39273);
    }

    public final int getLayoutId() {
        return 2130970797;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39274);
        super.onDestroy();
        if (this.qFG) {
            String str = this.ros == null ? "" : this.rwP.hnw;
            if (this.ros != null) {
                C1332b cqz;
                String cmf = this.rwL.cmf();
                int cre = this.ros == null ? 0 : this.ros.cre();
                long j = ((long) this.rwL.qEl) - this.rwL.fQe;
                if (j < 0) {
                    C4990ab.m7413e("MicroMsg.SnsSightPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", Integer.valueOf(this.rwL.qEl), Long.valueOf(this.rwL.fQe));
                    j = (long) this.rwL.qEl;
                }
                int i = (int) j;
                C1720g.m3537RQ();
                C6300p c6300p = C1720g.m3535RO().eJo;
                int i2 = this.cvd == 0 ? 1 : 2;
                int i3 = this.rwL.qEl;
                C1332b cqy = this.cvd == 2 ? this.ros.crd().cqy() : this.ros.crd().cqw();
                if (this.cvd == 2) {
                    cqz = this.ros.crd().cqz();
                } else {
                    cqz = this.ros.crd().cqx();
                }
                c6300p.mo14541a(new C39726d(str, i2, 2, i3, null, null, 2, cmf, -1, cre, i, i, 0, cqy, cqz), 0);
            }
        }
        C4990ab.m7410d("MicroMsg.SnsSightPlayerUI", "on dismiss");
        if (this.qFG && this.ros != null && this.ros.mo74253DI(32)) {
            C34927j.m57341a(C34930b.Sight, C13354a.LeavelFullScreen, this.ros, this.cvd);
        }
        C13373af.cnA().mo69142b((C43559b) this);
        C37952b u = C37952b.m64173u(getIntent());
        if (u != null) {
            if (this.qFG) {
                u.mo60718cS(!C5046bo.isNullOrNil(this.cNr.wEO));
            } else {
                u.mo60718cS(false);
            }
            u.update();
            u.ajK();
        }
        if (C35973a.m59175Cc() != null) {
            C35973a.m59175Cc().mo4648Ic();
        }
        if (this.klq != null) {
            this.klq.setVideoCallback(null);
            this.klq.stop();
            this.klq.onDetach();
        }
        if (!this.qyS) {
            C6550tn c6550tn = new C6550tn();
            c6550tn.cPI.type = 0;
            c6550tn.cPI.cPJ = this.qxZ;
            c6550tn.cPI.cPK = this.mik;
            c6550tn.cPI.cPL = this.cPL;
            C4879a.xxA.mo10055m(c6550tn);
        }
        this.iaf.mo67733cy(false);
        AppMethodBeat.m2505o(39274);
    }

    public void onStart() {
        AppMethodBeat.m2504i(39275);
        Bundle bundle = this.jWy;
        if (!this.jYD) {
            this.jYD = true;
            if (VERSION.SDK_INT >= 12) {
                this.kkq = getIntent().getIntExtra("img_gallery_top", 0);
                this.kkr = getIntent().getIntExtra("img_gallery_left", 0);
                this.kks = getIntent().getIntExtra("img_gallery_width", 0);
                this.kkt = getIntent().getIntExtra("img_gallery_height", 0);
                this.jYE.mo49164L(this.kkr, this.kkq, this.kks, this.kkt);
                if (bundle == null) {
                    this.qzb.getViewTreeObserver().addOnPreDrawListener(new C39963());
                }
            }
        }
        super.onStart();
        AppMethodBeat.m2505o(39275);
    }

    public void onResume() {
        AppMethodBeat.m2504i(39276);
        super.onResume();
        if (!this.bZi) {
            C4990ab.m7416i("MicroMsg.SnsSightPlayerUI", "initOrientation ".concat(String.valueOf(getResources().getConfiguration().orientation)));
            if (getResources().getConfiguration().orientation == 2) {
                m89510ag(getResources().getConfiguration().orientation, true);
            }
            this.bZi = true;
        }
        if (this.qzk == 0 || this.qzj == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.qzk = displayMetrics.heightPixels;
            this.qzj = displayMetrics.widthPixels;
        }
        if (this.ruY && C5730e.m8628ct(this.ePJ)) {
            m89527kB(false);
            this.ruY = false;
        }
        if (this.rwL != null) {
            this.rwL.onResume();
        }
        AppMethodBeat.m2505o(39276);
    }

    public void onPause() {
        AppMethodBeat.m2504i(39277);
        super.onPause();
        int i = getResources().getConfiguration().orientation;
        C4990ab.m7416i("MicroMsg.SnsSightPlayerUI", "onpause  ".concat(String.valueOf(i)));
        m89504Ef(i);
        if (this.ruY) {
            cpN();
        } else {
            cpN();
            C4990ab.m7418v("check", "onclick");
            new C7306ak().post(new C39952());
        }
        if (this.rwL != null) {
            this.rwL.fQd = C5046bo.m7588yz();
        }
        AppMethodBeat.m2505o(39277);
    }

    public final void bcW() {
        AppMethodBeat.m2504i(39278);
        int width = this.qzb.getWidth();
        int height = this.qzb.getHeight();
        if (!(this.kks == 0 || this.kkt == 0)) {
            height = (int) ((((float) width) / ((float) this.kks)) * ((float) this.kkt));
        }
        this.jYE.mo49168hw(width, height);
        this.jYE.mo49164L(this.kkr, this.kkq, this.kks, this.kkt);
        if (((double) this.rpz) != 1.0d) {
            width = C5222ae.m7944fr(this.mController.ylL);
            this.jYE.zEZ = 1.0f / this.rpz;
            if (!(this.rpA == 0 && this.rpB == 0)) {
                this.jYE.mo49170hy(((int) (((float) (this.qzb.getWidth() / 2)) * (1.0f - this.rpz))) + this.rpA, (int) ((((float) ((width + this.qzb.getHeight()) / 2)) - (((float) (height / 2)) * this.rpz)) + ((float) this.rpB)));
            }
        }
        this.jYE.mo49167a(this.qzb, this.mmX, new C39974(), null);
        AppMethodBeat.m2505o(39278);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(39279);
        bcW();
        AppMethodBeat.m2505o(39279);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(39280);
        if (4097 == i) {
            if (-1 == i2) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str : C5046bo.m7508P(stringExtra.split(","))) {
                    if (this.cvd == 0) {
                        C46236n YT = C13373af.cnF().mo62918YT(this.czD);
                        if (YT != null) {
                            if (C1855t.m3896kH(str)) {
                                C26228rf c26228rf = new C26228rf();
                                c26228rf.cNk.cFc = C29036i.m46115j(YT);
                                c26228rf.cNk.cwT = YT.cqU();
                                C4879a.xxA.mo10055m(c26228rf);
                            } else {
                                C9455rg c9455rg = new C9455rg();
                                c9455rg.cNl.cFc = C29036i.m46115j(YT);
                                c9455rg.cNl.cwT = YT.cqU();
                                C4879a.xxA.mo10055m(c9455rg);
                            }
                        }
                    }
                    TimeLineObject cqu = this.ros.cqu();
                    if (this.qFG) {
                        C21984b cqo = this.ros.cqo();
                        cfh cfh = new cfh();
                        cfh.wid = this.cNr.rEd;
                        cfh.fiG = this.cNr.wEO;
                        if (cqu.xfI.wbJ == 15) {
                            cfh.fiM = this.rwP.qPj;
                            cfh.fiN = cqu.f15074Id;
                        } else {
                            cfh.fiM = cqu.xfN.fiM;
                            cfh.fiN = cqu.xfN.fiN;
                        }
                        cfh.fiI = C5046bo.isNullOrNil(this.cNr.wES) ? cqu.xfF : this.cNr.wES;
                        if (C5046bo.isNullOrNil(this.cNr.wER)) {
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
                        C4990ab.m7417i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", str, this.ePJ, this.imagePath, this.cNr.wEO, Integer.valueOf(this.cNr.rEd), cfh.fiL, Integer.valueOf(C29036i.m46095Xr(this.ePJ)));
                        C12519g.bOk().mo46458a(this, str, this.ePJ, this.imagePath, 43, r6, cfh, cqu.rjC);
                    } else {
                        C4990ab.m7417i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", str, this.ePJ, this.imagePath, Integer.valueOf(C29036i.m46095Xr(this.ePJ)));
                        C12519g.bOk().mo46459a(this, str, this.ePJ, this.imagePath, 43, r6, cqu.rjC);
                    }
                    if (stringExtra2 != null) {
                        C12519g.bOk().mo46461eZ(stringExtra2, str);
                    }
                    C5670b.m8523i(this, getString(C25738R.string.cbn));
                    if (this.qFG) {
                        C34928c c34928c;
                        int mA;
                        C29036i.m46098a(new SnsAdClick(this.cvd, 5, this.ros.field_snsId, 12, 0));
                        boolean kH = C1855t.m3896kH(str);
                        C34929d c34929d = C34929d.Sight;
                        if (kH) {
                            c34928c = C34928c.Chatroom;
                        } else {
                            c34928c = C34928c.Chat;
                        }
                        C34931e c34931e = C34931e.Full;
                        if (kH) {
                            mA = C37921n.m64060mA(str);
                        } else {
                            mA = 0;
                        }
                        C34927j.m57343a(c34929d, c34928c, c34931e, mA, this.ros, this.cvd);
                    }
                }
            } else if (this.qFG) {
                C29036i.m46098a(new SnsAdClick(this.cvd, 5, this.ros.field_snsId, 13, 0));
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(39280);
    }

    /* renamed from: Xw */
    public final void mo17655Xw(String str) {
    }

    /* renamed from: bj */
    public final void mo8771bj(String str, boolean z) {
    }

    public final void cmu() {
    }

    /* renamed from: bk */
    public final void mo8772bk(String str, boolean z) {
        AppMethodBeat.m2504i(39281);
        C4990ab.m7416i("MicroMsg.SnsSightPlayerUI", "onSightFinish ".concat(String.valueOf(str)));
        if (this.qFG && !C5046bo.isNullOrNil(str) && this.cNr != null && str.equals(this.cNr.f17915Id) && C5730e.m8628ct(this.ePJ)) {
            this.rwL.qEk = 1;
            this.klq.setVideoPath(this.ePJ);
            m89527kB(true);
            if (this.rwO != null) {
                this.rwO.setVisibility(8);
            }
        }
        AppMethodBeat.m2505o(39281);
    }

    public final int getForceOrientation() {
        return 7;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(39282);
        super.onConfigurationChanged(configuration);
        C4990ab.m7416i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + configuration.orientation + " " + this.qzr);
        if (this.qzr == configuration.orientation) {
            AppMethodBeat.m2505o(39282);
            return;
        }
        int i = configuration.orientation;
        m89510ag(configuration.orientation, false);
        this.qzr = configuration.orientation;
        AppMethodBeat.m2505o(39282);
    }

    /* renamed from: ag */
    private void m89510ag(int i, boolean z) {
        AppMethodBeat.m2504i(39283);
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
            findViewById(2131823800).setVisibility(0);
        } else {
            layoutParams3.height = this.qzj;
            layoutParams3.width = (int) (((((double) this.qzj) * 1.0d) * 320.0d) / 240.0d);
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(3, 0);
            layoutParams2.addRule(12, -1);
            layoutParams2.addRule(1, this.qzb.getId());
            findViewById(2131823800).setVisibility(8);
        }
        C4990ab.m7416i("MicroMsg.SnsSightPlayerUI", "orientation " + i + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.klq).setLayoutParams(layoutParams3);
        if (this.klq instanceof C34915a) {
            ((C34915a) this.klq).mo8513fi(layoutParams3.width, layoutParams3.height);
        }
        layoutParams.height = layoutParams3.height;
        layoutParams.width = layoutParams3.width;
        this.qyR.setLayoutParams(layoutParams2);
        this.qzb.setLayoutParams(layoutParams);
        ((View) this.klq).requestLayout();
        if (!z) {
            m89504Ef(i);
        }
        AppMethodBeat.m2505o(39283);
    }

    /* renamed from: Ef */
    private void m89504Ef(int i) {
        AppMethodBeat.m2504i(39284);
        if (this.qFG) {
            if (this.klq.isPlaying()) {
                if (this.duration == 0) {
                    this.duration = this.klq.getDuration();
                }
                this.rwL.mo8566CI(this.duration);
                this.rwL.qEs.qFu = C5046bo.m7588yz();
                this.rwL.qEs.qFt = i == 2 ? 2 : 1;
                this.rwL.qEs.qFs = 2;
                C4990ab.m7416i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.rwL.qEs.qFt);
            }
            AppMethodBeat.m2505o(39284);
            return;
        }
        AppMethodBeat.m2505o(39284);
    }
}
