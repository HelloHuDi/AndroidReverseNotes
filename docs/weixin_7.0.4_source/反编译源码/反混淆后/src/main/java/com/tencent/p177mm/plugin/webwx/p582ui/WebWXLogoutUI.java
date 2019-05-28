package com.tencent.p177mm.plugin.webwx.p582ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1815as;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C32822ab;
import com.tencent.p177mm.modelsimple.C6685l;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C9470sk;
import com.tencent.p177mm.p249m.C18559f;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.webwx.C4660a;
import com.tencent.p177mm.plugin.webwx.p1071a.C40356b;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI */
public class WebWXLogoutUI extends MMActivity implements C1202f, C1815as {
    private boolean jZK;
    private C4884c qLL = new C72319();
    private ProgressDialog qlZ = null;
    private ImageView uLA;
    private int uLB;
    private int uLC;
    private int uLD;
    private Animator uLE;
    private int uLF;
    private boolean uLr = false;
    private boolean uLx;
    private ImageButton uLy;
    private ImageButton uLz;

    /* renamed from: com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI$2 */
    class C46612 implements OnClickListener {
        C46612() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26539);
            WebWXLogoutUI.this.uLx = !WebWXLogoutUI.this.uLx;
            WebWXLogoutUI.m14049b(WebWXLogoutUI.this, WebWXLogoutUI.this.uLx);
            WebWXLogoutUI.m14050b(WebWXLogoutUI.this);
            AppMethodBeat.m2505o(26539);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI$9 */
    class C72319 extends C4884c<C9470sk> {
        C72319() {
            AppMethodBeat.m2504i(26547);
            this.xxI = C9470sk.class.getName().hashCode();
            AppMethodBeat.m2505o(26547);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26548);
            C9470sk c9470sk = (C9470sk) c4883b;
            C4990ab.m7410d("MicroMsg.WebWXLogoutUI", "status Notify function");
            if (c9470sk.cOH.czE == 8) {
                WebWXLogoutUI.this.finish();
            }
            AppMethodBeat.m2505o(26548);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI$1 */
    class C79011 implements OnMenuItemClickListener {
        C79011() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(26538);
            WebWXLogoutUI.this.finish();
            AppMethodBeat.m2505o(26538);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI$8 */
    class C79028 implements DialogInterface.OnClickListener {
        C79028() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(26546);
            final C1207m c32822ab = new C32822ab(1);
            C9638aw.m17182Rg().mo14541a(c32822ab, 0);
            WebWXLogoutUI webWXLogoutUI = WebWXLogoutUI.this;
            Context context = WebWXLogoutUI.this.mController.ylL;
            WebWXLogoutUI.this.getString(C25738R.string.f9238tz);
            webWXLogoutUI.qlZ = C30379h.m48458b(context, null, true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(26545);
                    C9638aw.m17182Rg().mo14547c(c32822ab);
                    if (WebWXLogoutUI.this.qlZ != null) {
                        WebWXLogoutUI.this.qlZ.cancel();
                    }
                    AppMethodBeat.m2505o(26545);
                }
            });
            AppMethodBeat.m2505o(26546);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI$3 */
    class C79043 extends AnimatorListenerAdapter {
        C79043() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(26540);
            super.onAnimationEnd(animator);
            WebWXLogoutUI.m14051c(WebWXLogoutUI.this, WebWXLogoutUI.this.jZK);
            AppMethodBeat.m2505o(26540);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI$5 */
    class C79065 implements OnClickListener {
        C79065() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26542);
            Intent intent = new Intent();
            intent.putExtra("Chat_User", "filehelper");
            intent.putExtra("key_show_bottom_app_panel", true);
            C4660a.gkE.mo38915d(intent, WebWXLogoutUI.this);
            C4990ab.m7410d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
            WebWXLogoutUI.this.finish();
            AppMethodBeat.m2505o(26542);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI$6 */
    class C79076 implements OnClickListener {
        C79076() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26543);
            C4990ab.m7410d("MicroMsg.WebWXLogoutUI", "logout webwx");
            WebWXLogoutUI.m14055f(WebWXLogoutUI.this);
            AppMethodBeat.m2505o(26543);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI$7 */
    class C79087 implements Runnable {
        C79087() {
        }

        public final void run() {
            AppMethodBeat.m2504i(26544);
            WebWXLogoutUI.this.uLD = WebWXLogoutUI.m14056g(WebWXLogoutUI.this);
            WebWXLogoutUI.m14057h(WebWXLogoutUI.this);
            AppMethodBeat.m2505o(26544);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WebWXLogoutUI() {
        AppMethodBeat.m2504i(26549);
        AppMethodBeat.m2505o(26549);
    }

    /* renamed from: b */
    static /* synthetic */ void m14049b(WebWXLogoutUI webWXLogoutUI, boolean z) {
        AppMethodBeat.m2504i(26561);
        webWXLogoutUI.m14060oh(z);
        AppMethodBeat.m2505o(26561);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m14050b(WebWXLogoutUI webWXLogoutUI) {
        AppMethodBeat.m2504i(26562);
        boolean ddi = webWXLogoutUI.ddi();
        AppMethodBeat.m2505o(26562);
        return ddi;
    }

    /* renamed from: c */
    static /* synthetic */ void m14051c(WebWXLogoutUI webWXLogoutUI, boolean z) {
        AppMethodBeat.m2504i(26563);
        webWXLogoutUI.m14059og(z);
        AppMethodBeat.m2505o(26563);
    }

    /* renamed from: h */
    static /* synthetic */ void m14057h(WebWXLogoutUI webWXLogoutUI) {
        AppMethodBeat.m2504i(26567);
        webWXLogoutUI.aMk();
        AppMethodBeat.m2505o(26567);
    }

    public final int getLayoutId() {
        return 2130971221;
    }

    public void finish() {
        AppMethodBeat.m2504i(26550);
        super.finish();
        overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8373ce);
        AppMethodBeat.m2505o(26550);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(26551);
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.uLF = getIntent().getIntExtra("intent.key.online_version", 0);
        }
        initView();
        overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8293s);
        C9638aw.m17182Rg().mo14539a((int) C31128d.MIC_PTU_TRANS_KONGCHENG, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(792, (C1202f) this);
        C9638aw.m17190ZK();
        C18628c.m29103a(this);
        C4879a.xxA.mo10052c(this.qLL);
        AppMethodBeat.m2505o(26551);
    }

    public void onPause() {
        AppMethodBeat.m2504i(26552);
        super.onPause();
        if (this.uLr && C9638aw.m17179RK()) {
            act act = new act();
            act.wkw = 27;
            act.pvD = C1853r.m3855ku(C1853r.m3824YF()) ? 1 : 2;
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C3465a(23, act));
            this.uLr = false;
        }
        AppMethodBeat.m2505o(26552);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(26553);
        super.onDestroy();
        overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8373ce);
        C9638aw.m17182Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(792, (C1202f) this);
        C9638aw.m17190ZK();
        C18628c.m29104b(this);
        C4879a.xxA.mo10053d(this.qLL);
        AppMethodBeat.m2505o(26553);
    }

    public final void initView() {
        AppMethodBeat.m2504i(26554);
        setMMTitle("");
        setBackBtn(new C79011(), C1318a.actionbar_icon_close_black);
        dyb();
        if (C37885a.m63950MC()) {
            this.uLz = (ImageButton) findViewById(2131829192);
            if (C1853r.m3855ku(C1853r.m3824YF())) {
                this.uLx = true;
            } else {
                this.uLx = false;
            }
            m14060oh(this.uLx);
            this.uLz.setOnClickListener(new C46612());
        } else {
            findViewById(2131829191).setVisibility(8);
            this.uLx = false;
        }
        this.uLA = (ImageView) findViewById(2131823276);
        C4990ab.m7410d("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + C6685l.ajj());
        if (C6685l.ajj()) {
            findViewById(2131829194).setVisibility(8);
        } else {
            final Animator loadAnimator = AnimatorInflater.loadAnimator(this, C25738R.animator.f8458b);
            loadAnimator.setTarget(findViewById(2131829196));
            this.uLE = AnimatorInflater.loadAnimator(this, C25738R.animator.f8459c);
            this.uLE.setTarget(findViewById(2131829196));
            this.uLE.addListener(new C79043());
            this.jZK = C6685l.ajh();
            this.uLy = (ImageButton) findViewById(2131829195);
            m14059og(this.jZK);
            this.uLy.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(26541);
                    if (WebWXLogoutUI.this.jZK) {
                        WebWXLogoutUI.this.uLy.setImageResource(C1318a.connect_icon_lock_on_regular);
                    } else {
                        WebWXLogoutUI.this.uLy.setImageResource(C1318a.connect_icon_lock_off_regular);
                    }
                    WebWXLogoutUI.m14054e(WebWXLogoutUI.this);
                    WebWXLogoutUI.this.findViewById(2131829196).setVisibility(0);
                    loadAnimator.start();
                    AppMethodBeat.m2505o(26541);
                }
            });
        }
        ImageButton imageButton = (ImageButton) findViewById(2131829198);
        C4990ab.m7410d("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + C6685l.ajk());
        if (C6685l.ajk()) {
            imageButton.setVisibility(8);
        } else {
            imageButton.setOnClickListener(new C79065());
        }
        Button button = (Button) findViewById(2131829199);
        button.setText(C6685l.fOX);
        button.setOnClickListener(new C79076());
        Drawable drawable;
        Drawable drawable2;
        if (C6685l.ajf() == 1) {
            drawable = getResources().getDrawable(C1318a.connect_pc);
            drawable2 = getResources().getDrawable(C1318a.connect_pc_mute);
            if (!(drawable == null || drawable2 == null)) {
                this.uLB = drawable.getIntrinsicWidth();
                this.uLC = drawable2.getIntrinsicWidth();
            }
        } else if (C6685l.ajf() == 2) {
            drawable = getResources().getDrawable(C1318a.connect_mac);
            drawable2 = getResources().getDrawable(C1318a.connect_mac_mute);
            if (!(drawable == null || drawable2 == null)) {
                this.uLB = drawable.getIntrinsicWidth();
                this.uLC = drawable2.getIntrinsicWidth();
            }
        }
        this.uLA.post(new C79087());
        AppMethodBeat.m2505o(26554);
    }

    private void aMk() {
        AppMethodBeat.m2504i(26555);
        if (!C5046bo.isNullOrNil(C6685l.fOP)) {
            ((TextView) findViewById(2131829189)).setText(C6685l.fOP);
            if (C6685l.ajf() == 1) {
                if (!this.uLx) {
                    this.uLA.setImageResource(C1318a.connect_pc_mute);
                    this.uLA.setPadding(this.uLC - this.uLB, this.uLD, 0, 0);
                    AppMethodBeat.m2505o(26555);
                    return;
                }
            } else if (C6685l.ajf() == 2) {
                if (this.uLx) {
                    ((TextView) findViewById(2131829190)).setText(C25738R.string.g06);
                } else if (!C37885a.m63950MC()) {
                    ((TextView) findViewById(2131829190)).setText("");
                }
                if (this.jZK) {
                    ((TextView) findViewById(2131829189)).setText(getString(C25738R.string.fzq, new Object[]{"Mac"}));
                    this.uLA.setImageResource(C1318a.connect_mac_lock);
                    this.uLA.setPadding(0, this.uLD, 0, 0);
                    if (C37885a.m63950MC() && !this.uLx) {
                        ((TextView) findViewById(2131829190)).setText(C25738R.string.fzm);
                        this.uLA.setImageResource(C1318a.connect_mac_mute_lock);
                        this.uLA.setPadding(this.uLC - this.uLB, this.uLD, 0, 0);
                        AppMethodBeat.m2505o(26555);
                        return;
                    }
                }
                ((TextView) findViewById(2131829189)).setText(getString(C25738R.string.fzt, new Object[]{"Mac"}));
                this.uLA.setImageResource(C1318a.connect_mac);
                this.uLA.setPadding(0, this.uLD, 0, 0);
                if (C37885a.m63950MC() && !this.uLx) {
                    ((TextView) findViewById(2131829190)).setText(C25738R.string.fzm);
                    this.uLA.setImageResource(C1318a.connect_mac_mute);
                    this.uLA.setPadding(this.uLC - this.uLB, this.uLD, 0, 0);
                    AppMethodBeat.m2505o(26555);
                    return;
                }
            } else if (C6685l.ajf() == 3) {
                this.uLA.setImageResource(C1318a.connect_ipad);
                this.uLA.setPadding(0, this.uLD, 0, 0);
                AppMethodBeat.m2505o(26555);
                return;
            }
            this.uLA.setImageResource(C1318a.connect_pc);
            this.uLA.setPadding(0, this.uLD, 0, 0);
        }
        AppMethodBeat.m2505o(26555);
    }

    /* renamed from: og */
    private void m14059og(boolean z) {
        AppMethodBeat.m2504i(26556);
        if (this.uLy != null) {
            if (z) {
                this.uLy.setImageResource(C25738R.drawable.bm6);
                ((TextView) findViewById(2131829197)).setText(C25738R.string.g07);
                AppMethodBeat.m2505o(26556);
                return;
            }
            this.uLy.setImageResource(C25738R.drawable.bm4);
            ((TextView) findViewById(2131829197)).setText(C25738R.string.fzp);
        }
        AppMethodBeat.m2505o(26556);
    }

    /* renamed from: oh */
    private void m14060oh(boolean z) {
        AppMethodBeat.m2504i(26557);
        if (this.uLz != null) {
            if (z) {
                this.uLz.setImageResource(C25738R.drawable.bm2);
                AppMethodBeat.m2505o(26557);
                return;
            }
            this.uLz.setImageResource(C25738R.drawable.bm5);
        }
        AppMethodBeat.m2505o(26557);
    }

    private boolean ddi() {
        AppMethodBeat.m2504i(26558);
        if (C9638aw.m17179RK()) {
            int YF = C1853r.m3824YF();
            if (this.uLx) {
                YF |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            } else {
                YF &= -8193;
            }
            C18559f.m28901iZ(YF);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(40, Integer.valueOf(YF));
            this.uLr = true;
            aMk();
            AppMethodBeat.m2505o(26558);
            return true;
        }
        AppMethodBeat.m2505o(26558);
        return false;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(26559);
        if (this.qlZ != null) {
            this.qlZ.dismiss();
            this.qlZ = null;
        }
        if (c1207m.getType() == C31128d.MIC_PTU_TRANS_KONGCHENG) {
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this, C25738R.string.g04, 1).show();
            }
            finish();
            AppMethodBeat.m2505o(26559);
            return;
        }
        if (c1207m.getType() == 792) {
            int i3 = ((C40356b) c1207m).czE;
            if (this.uLE != null) {
                this.uLE.start();
            }
            if (i == 0 && i2 == 0) {
                this.jZK = i3 == 1;
                C6685l.m11102cR(this.jZK);
                aMk();
                String str2 = "MicroMsg.WebWXLogoutUI";
                String str3 = "%s extDevice success";
                Object[] objArr = new Object[1];
                objArr[0] = this.jZK ? "lock" : "unlock";
                C4990ab.m7411d(str2, str3, objArr);
            } else if (i3 == 1) {
                Toast.makeText(this, C25738R.string.fzr, 0).show();
                AppMethodBeat.m2505o(26559);
                return;
            } else {
                Toast.makeText(this, C25738R.string.g08, 0).show();
                AppMethodBeat.m2505o(26559);
                return;
            }
        }
        AppMethodBeat.m2505o(26559);
    }

    /* renamed from: ZB */
    public final void mo5390ZB() {
        AppMethodBeat.m2504i(26560);
        C9638aw.m17190ZK();
        if (C18628c.m29074XI()) {
            if (C6685l.ajh() && !this.jZK) {
                C4990ab.m7410d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
                this.jZK = true;
                m14059og(this.jZK);
                aMk();
            }
            AppMethodBeat.m2505o(26560);
            return;
        }
        finish();
        AppMethodBeat.m2505o(26560);
    }

    /* renamed from: e */
    static /* synthetic */ void m14054e(WebWXLogoutUI webWXLogoutUI) {
        AppMethodBeat.m2504i(26564);
        if (webWXLogoutUI.jZK) {
            C9638aw.m17182Rg().mo14541a(new C40356b(2), 0);
            C4990ab.m7410d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : UNLOCK");
            AppMethodBeat.m2505o(26564);
            return;
        }
        C9638aw.m17182Rg().mo14541a(new C40356b(1), 0);
        C4990ab.m7410d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : LOCK");
        AppMethodBeat.m2505o(26564);
    }

    /* renamed from: f */
    static /* synthetic */ boolean m14055f(WebWXLogoutUI webWXLogoutUI) {
        AppMethodBeat.m2504i(26565);
        if (webWXLogoutUI.uLF == C6685l.aji()) {
            C30379h.m48466d(webWXLogoutUI.mController.ylL, C6685l.fOU, webWXLogoutUI.getString(C25738R.string.f9238tz), webWXLogoutUI.getString(C25738R.string.g03), webWXLogoutUI.getString(C25738R.string.f9076or), new C79028(), null);
        } else {
            webWXLogoutUI.finish();
        }
        AppMethodBeat.m2505o(26565);
        return true;
    }

    /* renamed from: g */
    static /* synthetic */ int m14056g(WebWXLogoutUI webWXLogoutUI) {
        AppMethodBeat.m2504i(26566);
        int de = C5230ak.m7987de(webWXLogoutUI.mController.ylL);
        int hF = C5230ak.m7989hF(webWXLogoutUI.mController.ylL);
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            webWXLogoutUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            webWXLogoutUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        C4990ab.m7411d("MicroMsg.WebWXLogoutUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", Integer.valueOf(hF), Integer.valueOf(point.y), Integer.valueOf(de));
        de = (((int) (((double) r2) / 4.0d)) - hF) - de;
        AppMethodBeat.m2505o(26566);
        return de;
    }
}
