package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p231a.C26228rf;
import com.tencent.p177mm.p230g.p231a.C6550tn;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p230g.p231a.C9365gt;
import com.tencent.p177mm.p230g.p231a.C9455rg;
import com.tencent.p177mm.p230g.p231a.C9463sb;
import com.tencent.p177mm.p230g.p231a.C9463sb.C9464a;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.tools.C30759e;
import com.tencent.p177mm.p612ui.tools.C30759e.C24051b;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C34957aq;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29970o;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.C7252av;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity */
public class SnsOnlineVideoActivity extends MMActivity {
    private float aKM = 0.0f;
    private float aKN = 0.0f;
    private bau cNr;
    private String czD;
    private String ePJ;
    private boolean eif;
    private GestureDetector iay;
    C5279d jOb = new C220206();
    private Bundle jWy;
    private boolean jYD = false;
    private C30759e jYE;
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
    private C36356d riy;
    private boolean rkM = false;
    private C46236n ros;
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
    C36073c rve = new C220195();
    private int scene = 0;
    private String thumbPath;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$14 */
    class C399314 implements Runnable {
        C399314() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39161);
            SnsOnlineVideoActivity.this.finish();
            AppMethodBeat.m2505o(39161);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$2 */
    class C220172 implements Runnable {
        C220172() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39143);
            SnsOnlineVideoActivity.this.finish();
            AppMethodBeat.m2505o(39143);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$5 */
    class C220195 implements C36073c {
        C220195() {
        }

        /* JADX WARNING: Missing block: B:4:0x0054, code skipped:
            if (r3 != false) goto L_0x0056;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            int i = 1;
            AppMethodBeat.m2504i(39148);
            if (C5046bo.ank(C26373g.m41964Nu().getValue("SIGHTCannotTransmitForFav")) == 0) {
                C4990ab.m7417i("MicroMsg.SnsOnlineVideoActivity", "config can forward sight, thumb existed %B, video existed %B", Boolean.valueOf(C5730e.m8628ct(SnsOnlineVideoActivity.this.thumbPath)), Boolean.valueOf(C5730e.m8628ct(SnsOnlineVideoActivity.this.ePJ)));
                c44273l.add(0, 3, 0, SnsOnlineVideoActivity.this.getString(C25738R.string.ejf));
                if (C5730e.m8628ct(SnsOnlineVideoActivity.this.thumbPath)) {
                }
            }
            i = 0;
            if (C25985d.afj("favorite")) {
                c44273l.add(0, 2, 0, SnsOnlineVideoActivity.this.getString(C25738R.string.dcq));
            }
            c44273l.add(0, 5, 0, SnsOnlineVideoActivity.this.getString(C25738R.string.dx0));
            if (i != 0) {
                C9321dq c9321dq = new C9321dq();
                c9321dq.cxc.cwT = SnsOnlineVideoActivity.this.czD;
                C4879a.xxA.mo10055m(c9321dq);
                if (c9321dq.cxd.cwB) {
                    c44273l.add(0, 4, 0, SnsOnlineVideoActivity.this.getString(C25738R.string.f9188s7));
                }
            }
            AppMethodBeat.m2505o(39148);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$6 */
    class C220206 implements C5279d {
        C220206() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            boolean z = false;
            AppMethodBeat.m2504i(39149);
            Intent intent;
            C9463sb c9463sb;
            switch (menuItem.getItemId()) {
                case 1:
                    intent = new Intent();
                    C46236n YT = C13373af.cnF().mo62918YT(SnsOnlineVideoActivity.this.czD);
                    if (YT != null) {
                        C4990ab.m7416i("MicroMsg.SnsOnlineVideoActivity", "expose id " + YT.cqA());
                    }
                    intent.putExtra("k_expose_msg_id", YT == null ? Integer.valueOf(0) : YT.cqA());
                    intent.putExtra("k_username", YT == null ? "" : YT.field_userName);
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                    C25985d.m41467b(SnsOnlineVideoActivity.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(39149);
                    return;
                case 2:
                    C9463sb c9463sb2 = new C9463sb();
                    c9463sb2.cNV.cAd = 2;
                    c9463sb2.cNV.cNW = 17;
                    C9464a c9464a = c9463sb2.cNV;
                    if (SnsOnlineVideoActivity.this.scene == 0) {
                        z = true;
                    }
                    c9464a.cNX = z;
                    c9463sb2.cNV.czD = SnsOnlineVideoActivity.this.czD;
                    C4879a.xxA.mo10055m(c9463sb2);
                    AppMethodBeat.m2505o(39149);
                    return;
                case 3:
                    SnsOnlineVideoActivity.this.ruY = true;
                    c9463sb = new C9463sb();
                    c9463sb.cNV.cAd = 1;
                    c9463sb.cNV.cNY = 4097;
                    c9463sb.cNV.czD = SnsOnlineVideoActivity.this.czD;
                    C4879a.xxA.mo10055m(c9463sb);
                    AppMethodBeat.m2505o(39149);
                    return;
                case 4:
                    C46236n YT2 = C13373af.cnF().mo62918YT(SnsOnlineVideoActivity.this.czD);
                    if (YT2 == null) {
                        AppMethodBeat.m2505o(39149);
                        return;
                    }
                    intent = new Intent();
                    if (YT2.cqu().xfI.wbJ == 15 && ((bau) YT2.cqu().xfI.wbK.get(0)) == null) {
                        C4990ab.m7420w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
                        AppMethodBeat.m2505o(39149);
                        return;
                    }
                    intent.putExtra("exdevice_open_scene_type", 2);
                    intent.putExtra("sns_local_id", SnsOnlineVideoActivity.this.czD);
                    intent.putExtra("sns_send_data_ui_activity", true);
                    C25985d.m41473f(SnsOnlineVideoActivity.this, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                    AppMethodBeat.m2505o(39149);
                    return;
                case 5:
                    c9463sb = new C9463sb();
                    c9463sb.cNV.cAd = 3;
                    c9463sb.cNV.czD = SnsOnlineVideoActivity.this.czD;
                    C4879a.xxA.mo10055m(c9463sb);
                    break;
            }
            AppMethodBeat.m2505o(39149);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$4 */
    class C248304 implements C24051b {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$4$1 */
        class C220181 implements Runnable {
            C220181() {
            }

            public final void run() {
                AppMethodBeat.m2504i(39146);
                Intent intent = new Intent();
                intent.putExtra("sns_update_preview_video_del", SnsOnlineVideoActivity.this.rva);
                SnsOnlineVideoActivity.this.setResult(-1, intent);
                SnsOnlineVideoActivity.this.finish();
                SnsOnlineVideoActivity.this.overridePendingTransition(0, 0);
                AppMethodBeat.m2505o(39146);
            }
        }

        C248304() {
        }

        public final void onAnimationStart() {
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(39147);
            new C7306ak().post(new C220181());
            AppMethodBeat.m2505o(39147);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$11 */
    class C3503611 implements OnMenuItemClickListener {
        C3503611() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39157);
            SnsOnlineVideoActivity.this.bcW();
            AppMethodBeat.m2505o(39157);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$13 */
    class C3503713 implements OnLongClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$13$1 */
        class C350381 implements C15994a {
            C350381() {
            }

            public final void onDismiss() {
                AppMethodBeat.m2504i(39159);
                SnsOnlineVideoActivity.this.riy = null;
                AppMethodBeat.m2505o(39159);
            }
        }

        C3503713() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(39160);
            SnsOnlineVideoActivity.this.riy = new C36356d(SnsOnlineVideoActivity.this.mController.ylL, 1, false);
            SnsOnlineVideoActivity.this.riy.rBl = SnsOnlineVideoActivity.this.rve;
            SnsOnlineVideoActivity.this.riy.rBm = SnsOnlineVideoActivity.this.jOb;
            SnsOnlineVideoActivity.this.riy.zQf = new C350381();
            SnsOnlineVideoActivity.this.riy.cpD();
            AppMethodBeat.m2505o(39160);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$3 */
    class C350393 implements OnPreDrawListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$3$1 */
        class C135461 implements C24051b {
            C135461() {
            }

            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                AppMethodBeat.m2504i(39144);
                if (SnsOnlineVideoActivity.this.ruX != null) {
                    SnsOnlineVideoActivity.this.ruX.onResume();
                }
                AppMethodBeat.m2505o(39144);
            }
        }

        C350393() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(39145);
            SnsOnlineVideoActivity.this.ruX.getViewTreeObserver().removeOnPreDrawListener(this);
            SnsOnlineVideoActivity.this.jYE.mo49166a(SnsOnlineVideoActivity.this.ruX, SnsOnlineVideoActivity.this.mmX, new C135461());
            AppMethodBeat.m2505o(39145);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$10 */
    class C3980810 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$10$2 */
        class C135452 implements OnClickListener {
            C135452() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$10$1 */
        class C350351 implements OnClickListener {
            C350351() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(39155);
                SnsOnlineVideoActivity.this.rva = true;
                SnsOnlineVideoActivity.this.bcW();
                AppMethodBeat.m2505o(39155);
            }
        }

        C3980810() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39156);
            C30379h.m48432a(SnsOnlineVideoActivity.this, (int) C25738R.string.eqa, (int) C25738R.string.f9238tz, new C350351(), new C135452());
            AppMethodBeat.m2505o(39156);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$9 */
    class C398109 implements OnTouchListener {
        C398109() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            float f = 1.0f;
            AppMethodBeat.m2504i(39154);
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
                        SnsOnlineVideoActivity.m86568i(SnsOnlineVideoActivity.this);
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
                        AppMethodBeat.m2505o(39154);
                        return true;
                    } else if (!SnsOnlineVideoActivity.this.rvb || SnsOnlineVideoActivity.this.rvd) {
                        SnsOnlineVideoActivity.this.rvd = false;
                        break;
                    } else {
                        SnsOnlineVideoActivity.this.bcW();
                        SnsOnlineVideoActivity.this.rvd = false;
                        AppMethodBeat.m2505o(39154);
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
                    C4990ab.m7411d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", Boolean.valueOf(SnsOnlineVideoActivity.this.rvb), Float.valueOf(translationX), Float.valueOf(translationY), Integer.valueOf(xVelocity), Integer.valueOf(yVelocity));
                    if ((Math.abs(translationX) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || SnsOnlineVideoActivity.this.rvd) && !SnsOnlineVideoActivity.this.rvb) {
                        SnsOnlineVideoActivity.this.rvb = false;
                    } else {
                        translationX = 1.0f - (translationY / ((float) SnsOnlineVideoActivity.this.mmW.getHeight()));
                        if (translationX <= 1.0f) {
                            f = translationX;
                        }
                        if (((yVelocity > 0 && f < SnsOnlineVideoActivity.this.rpz) || yVelocity < 0) && ((double) f) >= 0.5d) {
                            C4990ab.m7411d("MicroMsg.SnsOnlineVideoActivity", "dancy scale:%s", Float.valueOf(f));
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
                        AppMethodBeat.m2505o(39154);
                        return true;
                    }
                    break;
            }
            AppMethodBeat.m2505o(39154);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$1 */
    class C435821 implements View.OnClickListener {
        C435821() {
        }

        public final void onClick(View view) {
            int i;
            boolean z = false;
            AppMethodBeat.m2504i(39142);
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
            AppMethodBeat.m2505o(39142);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$7 */
    class C435837 implements OnTouchListener {
        C435837() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(39150);
            SnsOnlineVideoActivity.this.bcW();
            AppMethodBeat.m2505o(39150);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity$8 */
    class C462418 extends SimpleOnGestureListener {
        C462418() {
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(39151);
            float rawX = motionEvent2.getRawX() - motionEvent.getRawX();
            float rawY = motionEvent2.getRawY() - motionEvent.getRawY();
            if (Math.abs(rawX) <= ((float) SnsOnlineVideoActivity.this.mmW.getWidth()) && Math.abs(rawY) <= ((float) SnsOnlineVideoActivity.this.mmW.getHeight()) && SnsOnlineVideoActivity.this.rvb) {
                SnsOnlineVideoActivity.this.ruX.setTranslationX(rawX);
                SnsOnlineVideoActivity.this.ruX.setTranslationY(rawY);
            }
            AppMethodBeat.m2505o(39151);
            return true;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(39152);
            SnsOnlineVideoActivity.this.rvd = true;
            super.onLongPress(motionEvent);
            AppMethodBeat.m2505o(39152);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(39153);
            if (!SnsOnlineVideoActivity.this.mOO) {
                SnsOnlineVideoActivity.this.bcW();
            }
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            AppMethodBeat.m2505o(39153);
            return onSingleTapUp;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsOnlineVideoActivity() {
        AppMethodBeat.m2504i(39162);
        AppMethodBeat.m2505o(39162);
    }

    /* renamed from: i */
    static /* synthetic */ void m86568i(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        AppMethodBeat.m2504i(39174);
        snsOnlineVideoActivity.bdd();
        AppMethodBeat.m2505o(39174);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39163);
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        super.onCreate(bundle);
        this.jWy = bundle;
        this.thumbPath = getIntent().getStringExtra("intent_thumbpath");
        this.czD = getIntent().getStringExtra("intent_localid");
        this.scene = getIntent().getIntExtra("intent_from_scene", -1);
        this.mOO = getIntent().getBooleanExtra("intent_ispreview", false);
        this.eif = getIntent().getBooleanExtra("intent_ismute", false);
        this.rkM = getIntent().getBooleanExtra("KBlockAdd", false);
        C4990ab.m7417i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", this.thumbPath, this.czD, Integer.valueOf(this.scene), Boolean.valueOf(this.mOO), Boolean.valueOf(this.eif), getIntent().getStringExtra("intent_videopath"));
        if (this.mOO) {
            this.ePJ = r0;
        } else {
            try {
                this.ros = C13373af.cnF().mo62918YT(this.czD);
                this.cNr = (bau) this.ros.cqu().xfI.wbK.get(0);
                this.ePJ = C3892an.m6198fZ(C13373af.getAccSnsPath(), this.cNr.f17915Id) + C29036i.m46116j(this.cNr);
                C4990ab.m7417i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", this.ros.cqU());
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + e.toString());
            }
        }
        try {
            if (C1443d.m3068iW(19)) {
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
            C4990ab.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", e2, "", new Object[0]);
        }
        this.mmW = (RelativeLayout) findViewById(2131822132);
        this.ruX = (OnlineVideoView) findViewById(2131821402);
        if (this.mOO) {
            OnlineVideoView onlineVideoView = this.ruX;
            String str = this.ePJ;
            String str2 = this.thumbPath;
            onlineVideoView.rlg = str;
            onlineVideoView.mOO = true;
            onlineVideoView.mmB.setImageBitmap(C4977b.m7374i(str2, 1.0f));
            C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d set preview video %s isPreview %b ", Integer.valueOf(onlineVideoView.hashCode()), str, Boolean.valueOf(onlineVideoView.mOO));
        } else {
            this.ruX.mo55602a(this.cNr, this.ros.cqU(), this.ros.field_createTime);
        }
        this.ruX.setMute(this.eif);
        this.mmX = (ImageView) findViewById(2131822079);
        this.mmX.setLayerType(2, null);
        if (this.mOO) {
            setMMTitle((int) C25738R.string.f8823g1);
            this.ruX.setOnClickListener(new C435821());
        } else {
            this.mController.hideTitleView();
            this.mmW.setOnTouchListener(new C435837());
        }
        this.iay = new GestureDetector(this.mController.ylL, new C462418());
        this.ruX.setOnTouchListener(new C398109());
        this.jYE = new C30759e(this.mController.ylL);
        C46236n c46236n = this.ros;
        if (c46236n == null) {
            C4990ab.m7416i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
        } else {
            this.rpq = (Button) findViewById(2131827691);
            final TimeLineObject cqu = c46236n.cqu();
            final C7252av c7252av = cqu != null ? cqu.qNO : null;
            C13633av c13633av = new C13633av();
            C22055af.m33675a(this, c13633av, cqu.qNO);
            if (c13633av.rBh) {
                this.rpq.setVisibility(0);
                this.rpq.setText(c13633av.rBi);
                this.rpq.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(39158);
                        if (c7252av.vCy == null) {
                            AppMethodBeat.m2505o(39158);
                            return;
                        }
                        SnsOnlineVideoActivity.this.ruZ = true;
                        String df = C24826a.gkF.mo38864df(c7252av.vCy.fKh);
                        int i = 0;
                        if (cqu.xfI.wbJ == 1) {
                            i = 2;
                        } else if (cqu.xfI.wbJ == 3) {
                            i = 5;
                        } else if (cqu.xfI.wbJ == 15) {
                            i = 38;
                        }
                        if (C3953i.m6294a(cqu, SnsOnlineVideoActivity.this)) {
                            C24826a.gkF.mo38855a(SnsOnlineVideoActivity.this, c7252av.vCy.fKh, df, cqu.jBB, i, 19, 9, c7252av.vCy.vCs, cqu.f15074Id);
                            AppMethodBeat.m2505o(39158);
                            return;
                        }
                        C9365gt c9365gt;
                        switch (c7252av.jCt) {
                            case 4:
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", c7252av.Url);
                                C24826a.gkE.mo38924i(intent, SnsOnlineVideoActivity.this);
                                C24826a.gkF.mo38855a(SnsOnlineVideoActivity.this, c7252av.vCy.fKh, df, cqu.jBB, i, 19, 1, c7252av.vCy.vCs, cqu.f15074Id);
                                AppMethodBeat.m2505o(39158);
                                return;
                            case 5:
                                if (c7252av.Scene == 1) {
                                    c9365gt = new C9365gt();
                                    c9365gt.cBv.actionCode = 2;
                                    c9365gt.cBv.scene = 3;
                                    c9365gt.cBv.appId = c7252av.vCy.fKh;
                                    c9365gt.cBv.context = SnsOnlineVideoActivity.this;
                                    C4879a.xxA.mo10055m(c9365gt);
                                    C24826a.gkF.mo38855a(SnsOnlineVideoActivity.this, c7252av.vCy.fKh, df, cqu.jBB, i, 19, 6, c7252av.vCy.vCs, cqu.f15074Id);
                                    AppMethodBeat.m2505o(39158);
                                    return;
                                }
                                break;
                            case 6:
                                int a = C22055af.m33674a(SnsOnlineVideoActivity.this, c7252av);
                                if (a != 1) {
                                    if (a == 2) {
                                        C9365gt c9365gt2 = new C9365gt();
                                        c9365gt2.cBv.context = SnsOnlineVideoActivity.this;
                                        c9365gt2.cBv.actionCode = 1;
                                        c9365gt2.cBv.appId = c7252av.vCy.fKh;
                                        c9365gt2.cBv.messageAction = c7252av.vCy.vCu;
                                        c9365gt2.cBv.messageExt = c7252av.vCy.vCt;
                                        c9365gt2.cBv.scene = 3;
                                        C4879a.xxA.mo10055m(c9365gt2);
                                        C24826a.gkF.mo38855a(SnsOnlineVideoActivity.this, c7252av.vCy.fKh, df, cqu.jBB, i, 19, 3, c7252av.vCy.vCs, cqu.f15074Id);
                                        break;
                                    }
                                }
                                c9365gt = new C9365gt();
                                c9365gt.cBv.context = SnsOnlineVideoActivity.this;
                                c9365gt.cBv.actionCode = 2;
                                c9365gt.cBv.appId = c7252av.vCy.fKh;
                                c9365gt.cBv.messageAction = c7252av.vCy.vCu;
                                c9365gt.cBv.messageExt = c7252av.vCy.vCt;
                                c9365gt.cBv.scene = 3;
                                C4879a.xxA.mo10055m(c9365gt);
                                C24826a.gkF.mo38855a(SnsOnlineVideoActivity.this, c7252av.vCy.fKh, df, cqu.jBB, i, 19, 6, c7252av.vCy.vCs, cqu.f15074Id);
                                AppMethodBeat.m2505o(39158);
                                return;
                                break;
                        }
                        AppMethodBeat.m2505o(39158);
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
                addIconOptionMenu(0, C25738R.string.f9088p4, C25738R.drawable.aiy, new C3980810());
            }
            setBackBtn(new C3503611());
        }
        bdd();
        C6550tn c6550tn = new C6550tn();
        c6550tn.cPI.type = 1;
        C4879a.xxA.mo10055m(c6550tn);
        AppMethodBeat.m2505o(39163);
    }

    public final int getLayoutId() {
        return 2130970830;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(39164);
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            C4990ab.m7410d("MicroMsg.SnsOnlineVideoActivity", "vertical orientation");
            ctH();
            AppMethodBeat.m2505o(39164);
        } else if (configuration.orientation == 2) {
            C4990ab.m7410d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
            if (this.rpq != null && this.rpq.getVisibility() == 0) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.rpq.getLayoutParams();
                if (marginLayoutParams.bottomMargin != getResources().getDimensionPixelSize(C25738R.dimen.a96)) {
                    marginLayoutParams.bottomMargin = getResources().getDimensionPixelSize(C25738R.dimen.a96);
                    this.rpq.setLayoutParams(marginLayoutParams);
                }
            }
            AppMethodBeat.m2505o(39164);
        } else {
            AppMethodBeat.m2505o(39164);
        }
    }

    private void ctH() {
        AppMethodBeat.m2504i(39165);
        boolean hw = C5222ae.m7951hw(this);
        int fr = C5222ae.m7944fr(this);
        if (this.osu && hw && this.rpq != null && this.rpq.getVisibility() == 0) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.rpq.getLayoutParams();
            marginLayoutParams.bottomMargin = fr + marginLayoutParams.bottomMargin;
            this.rpq.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.m2505o(39165);
    }

    private void bdd() {
        AppMethodBeat.m2504i(39166);
        if (this.mOO) {
            C4990ab.m7416i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
            AppMethodBeat.m2505o(39166);
            return;
        }
        this.ruX.setOnLongClickListener(new C3503713());
        AppMethodBeat.m2505o(39166);
    }

    public void onStart() {
        AppMethodBeat.m2504i(39167);
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
                    this.ruX.getViewTreeObserver().addOnPreDrawListener(new C350393());
                }
            }
        }
        super.onStart();
        AppMethodBeat.m2505o(39167);
    }

    public void onResume() {
        AppMethodBeat.m2504i(39168);
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
        C29970o.m47417JV(1);
        AppMethodBeat.m2505o(39168);
    }

    public void onPause() {
        AppMethodBeat.m2504i(39169);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        this.ruX.onPause();
        if (!this.ruY) {
            C4990ab.m7410d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
            if (this.ruZ) {
                new C7306ak().postDelayed(new C399314(), 500);
            } else {
                new C7306ak().post(new C220172());
            }
        }
        super.onPause();
        C29970o.m47417JV(2);
        AppMethodBeat.m2505o(39169);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39170);
        this.ruX.onDestroy();
        try {
            getWindow().clearFlags(128);
        } catch (Exception e) {
        }
        super.onDestroy();
        if (this.ros != null && this.ros.cqu().xfI.wbK.size() > 0) {
            String str = ((bau) this.ros.cqu().xfI.wbK.get(0)).Url;
            int i = this.ros.cqu().xfP;
            C26494u.m42241a(C34957aq.m57411D((bau) this.ros.cqu().xfI.wbK.get(0)), new PInt(), new PInt());
            int playVideoDuration = this.ruX.getPlayVideoDuration();
            C7060h.pYm.mo8381e(15534, str, this.ros.cqu().f15074Id, Integer.valueOf(i), Integer.valueOf(r3.value * 1000), Integer.valueOf(playVideoDuration * 1000));
        }
        AppMethodBeat.m2505o(39170);
    }

    public final void bcW() {
        AppMethodBeat.m2504i(39171);
        if (this.rpq != null && this.rpq.getVisibility() == 0) {
            this.rpq.setVisibility(8);
        }
        int width = this.mmW.getWidth();
        int height = this.mmW.getHeight();
        if (!(this.kks == 0 || this.kkt == 0)) {
            height = (int) ((((float) width) / ((float) this.kks)) * ((float) this.kkt));
        }
        this.jYE.mo49168hw(width, height);
        this.jYE.mo49164L(this.kkr, this.kkq, this.kks, this.kkt);
        if (((double) this.rpz) != 1.0d) {
            this.jYE.zEZ = 1.0f / this.rpz;
            if (!(this.rpA == 0 && this.rpB == 0)) {
                this.jYE.mo49170hy(((int) (((float) (this.mmW.getWidth() / 2)) * (1.0f - this.rpz))) + this.rpA, (int) (((float) ((this.mmW.getHeight() / 2) + this.rpB)) - (((float) (height / 2)) * this.rpz)));
            }
        }
        this.jYE.mo49167a(this.ruX, this.mmX, new C248304(), null);
        AppMethodBeat.m2505o(39171);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(39172);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            C4990ab.m7410d("MicroMsg.SnsOnlineVideoActivity", "dispatchKeyEvent");
            bcW();
            AppMethodBeat.m2505o(39172);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(39172);
        return dispatchKeyEvent;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(39173);
        C4990ab.m7417i("MicroMsg.SnsOnlineVideoActivity", "on activity result reqCode %d resultCode %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (4097 == i && -1 == i2) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            for (String str : C5046bo.m7508P(stringExtra.split(","))) {
                if (this.scene == 0) {
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
                int Xr = C29036i.m46095Xr(this.ePJ);
                if (C5046bo.isNullOrNil(this.thumbPath)) {
                    bau bau = this.cNr;
                    if (bau == null) {
                        stringExtra = "";
                    } else {
                        String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
                        stringExtra = fZ + C29036i.m46108e(bau);
                        C4990ab.m7411d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", stringExtra, Boolean.valueOf(C5730e.m8628ct(stringExtra)));
                        if (!C5730e.m8628ct(stringExtra)) {
                            stringExtra = fZ + C29036i.m46123n(bau);
                            C4990ab.m7417i("MicroMsg.SnsVideoLogic", "get sns video thumb path %s", stringExtra);
                        }
                    }
                } else {
                    stringExtra = this.thumbPath;
                }
                this.thumbPath = stringExtra;
                C4990ab.m7417i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", str, this.ePJ, this.thumbPath, this.cNr.wEO, Integer.valueOf(this.cNr.rEd), Integer.valueOf(Xr));
                C12519g.bOk().mo46459a(this, str, this.ePJ, this.thumbPath, 43, Xr, cqu.rjC);
                if (stringExtra2 != null) {
                    C12519g.bOk().mo46461eZ(stringExtra2, str);
                }
                C5670b.m8523i(this, getString(C25738R.string.cbn));
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(39173);
    }

    public final int getForceOrientation() {
        return 2;
    }
}
