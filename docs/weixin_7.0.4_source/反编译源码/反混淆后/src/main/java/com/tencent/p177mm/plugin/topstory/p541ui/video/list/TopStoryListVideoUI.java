package com.tencent.p177mm.plugin.topstory.p541ui.video.list;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.System;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C16681c;
import com.tencent.p177mm.plugin.boots.p348a.C20015c;
import com.tencent.p177mm.plugin.boots.p348a.C27502b;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C13944f;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C35293j;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13954d;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13986n;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13986n.C139871;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C39991p;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4233e;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C46927h;
import com.tencent.p177mm.plugin.topstory.p541ui.video.TopStoryBaseVideoUI;
import com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs.C13958d;
import com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs.C43696b;
import com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs.C43698c;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.C40003c;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.C40003c.C40004a;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.C4251f;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.TopStoryCommentFloatDialog;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.TopStoryCommentFloatDialog.C14003a;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C14419a;
import com.tencent.p177mm.protocal.protobuf.C23447tn;
import com.tencent.p177mm.protocal.protobuf.bzs;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.xwalk.core.Log;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI */
public class TopStoryListVideoUI extends TopStoryBaseVideoUI implements C13969b {
    C40003c sGA;
    View sGB;
    TopStoryCommentFloatDialog sGC;
    private boolean sGD;
    private ProgressDialog sGu;
    private View sGv;
    private View sGw;
    private View sGx;
    private Button sGy;
    View sGz;
    private View sHg;
    private TextView sHh;
    private C13973e sHi;
    private C13958d sHj;
    private View sHk;
    private View sHl;
    View sHm;
    C40003c sHn;
    View sHo;
    private long sHp = 0;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI$12 */
    class C424212 implements OnClickListener {
        C424212() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(2111);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_SHORT_VIDEO_FS_SCROLL_TIPS_INT, Integer.valueOf(1));
            TopStoryListVideoUI.this.sEn.cEf();
            TopStoryListVideoUI.this.sGx.setVisibility(8);
            TopStoryListVideoUI.this.sEe.mo26188b(TopStoryListVideoUI.this);
            AppMethodBeat.m2505o(2111);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI$5 */
    class C42455 implements OnCancelListener {
        C42455() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(TXLiveConstants.PLAY_WARNING_VIDEO_PLAY_LAG);
            TopStoryListVideoUI.this.finish();
            AppMethodBeat.m2505o(TXLiveConstants.PLAY_WARNING_VIDEO_PLAY_LAG);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI$6 */
    class C42466 implements Runnable {
        C42466() {
        }

        public final void run() {
            AppMethodBeat.m2504i(TXLiveConstants.PLAY_WARNING_HW_ACCELERATION_FAIL);
            TopStoryListVideoUI.this.sEl.cGS();
            AppMethodBeat.m2505o(TXLiveConstants.PLAY_WARNING_HW_ACCELERATION_FAIL);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI$7 */
    class C42477 implements OnTouchListener {
        C42477() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY);
            if (TopStoryListVideoUI.this.sGz.getVisibility() == 0) {
                if (TopStoryListVideoUI.m89567g(TopStoryListVideoUI.this.sGB, motionEvent.getX(), motionEvent.getY())) {
                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryVideoUI", "touch in mContentViewNotFull");
                    AppMethodBeat.m2505o(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY);
                    return false;
                }
                TopStoryListVideoUI.this.sGz.setVisibility(8);
            }
            AppMethodBeat.m2505o(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI$11 */
    class C1396811 implements OnTouchListener {
        C1396811() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI$3 */
    class C353133 implements Runnable {
        C353133() {
        }

        public final void run() {
            AppMethodBeat.m2504i(TXLiveConstants.PLAY_WARNING_VIDEO_DECODE_FAIL);
            if (TopStoryListVideoUI.this.sHm.getVisibility() == 0) {
                TopStoryListVideoUI.this.sHm.setVisibility(8);
            }
            AppMethodBeat.m2505o(TXLiveConstants.PLAY_WARNING_VIDEO_DECODE_FAIL);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI$9 */
    class C399859 implements Runnable {
        C399859() {
        }

        public final void run() {
            AppMethodBeat.m2504i(2109);
            if (TopStoryListVideoUI.this.sEt) {
                TopStoryListVideoUI.this.sHl.setVisibility(4);
                TopStoryListVideoUI.this.sHk.setVisibility(4);
                TopStoryListVideoUI.this.sEb.mo66329a(0, 3, null);
            } else {
                TopStoryListVideoUI.this.sGw.setVisibility(4);
                TopStoryListVideoUI.this.sGv.setVisibility(4);
            }
            if (TopStoryListVideoUI.this.sGu != null) {
                TopStoryListVideoUI.this.sGu.dismiss();
                TopStoryListVideoUI.this.sGu = null;
            }
            AppMethodBeat.m2505o(2109);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI$1 */
    class C463061 implements OnClickListener {
        C463061() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(2097);
            if (TopStoryListVideoUI.this.sEn.sFw && TopStoryListVideoUI.this.sEn.sFu.getItemUIComponent() != null) {
                TopStoryListVideoUI.this.sEn.sFu.getItemUIComponent().cFO();
                TopStoryListVideoUI.this.sEn.sFu.getItemUIComponent().cFN();
            }
            AppMethodBeat.m2505o(2097);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI$8 */
    class C463078 implements OnTouchListener {
        C463078() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(TXLiveConstants.PLAY_WARNING_FIRST_IDR_HW_DECODE_FAIL);
            if (TopStoryListVideoUI.this.sHm.getVisibility() == 0) {
                if (TopStoryListVideoUI.m89567g(TopStoryListVideoUI.this.sHo, motionEvent.getX(), motionEvent.getY())) {
                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryVideoUI", "touch in mContentViewFull");
                    AppMethodBeat.m2505o(TXLiveConstants.PLAY_WARNING_FIRST_IDR_HW_DECODE_FAIL);
                    return false;
                }
                TopStoryListVideoUI.this.sHm.setVisibility(8);
            }
            AppMethodBeat.m2505o(TXLiveConstants.PLAY_WARNING_FIRST_IDR_HW_DECODE_FAIL);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(2112);
        if (VERSION.SDK_INT >= 28) {
            this.ylm = true;
        }
        super.onCreate(bundle);
        ((C20015c) C1720g.m3528K(C20015c.class)).mo6742dC(C27502b.jJr, 885);
        C14419a.m22633kT(13);
        AppMethodBeat.m2505o(2112);
    }

    /* renamed from: Kh */
    public final void mo74478Kh() {
        AppMethodBeat.m2504i(2113);
        super.mo74478Kh();
        if (cFT().xgH != null) {
            this.sEo.mo26224d(cFT().xgH);
        }
        AppMethodBeat.m2505o(2113);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(2115);
        C39991p.sFq.mo63212a(this, i, i2, intent);
        if (i == 10001) {
            C41531v f = C29456d.m46780f(this);
            if (f != null && (f instanceof C46927h)) {
                ((C46927h) f).mo47707mc(false);
            }
            if (!(intent == null || !intent.hasExtra("isMute") || this.sBa == null)) {
                mo74490me(intent.getBooleanExtra("isMute", this.sBa.eif));
            }
            if (!(intent == null || !intent.hasExtra("MOBILE_CHECK_FLAG") || this.sBa == null)) {
                mo9159FE(intent.getIntExtra("MOBILE_CHECK_FLAG", this.sBa.xgO));
            }
        }
        AppMethodBeat.m2505o(2115);
    }

    public final void cGD() {
        AppMethodBeat.m2504i(2117);
        super.cGD();
        this.sGx = findViewById(2131828300);
        this.sGy = (Button) findViewById(2131828301);
        this.sHg = findViewById(2131828340);
        this.sHg.setOnClickListener(new C463061());
        overridePendingTransition(C5206a.ync, C5206a.ynd);
        if (cFT().xgI != null) {
            this.gnB.setVisibility(8);
        }
        this.sEl.sFo = 2;
        if (!cGI()) {
            this.sGw.setVisibility(4);
            this.sGv.setVisibility(4);
        } else if (this.sEk.isConnected()) {
            cHg();
            this.sGD = false;
            if (cFT().scene != 21 && cFT().xgI == null) {
                this.sGu = C30379h.m48458b((Context) this, getString(C25738R.string.cn5), true, new C42455());
            }
        } else {
            Toast.makeText(this, C25738R.string.dj3, 1).show();
            this.sGD = true;
        }
        this.sHi.sGI = true;
        if (cFT().xgJ) {
            this.sEk.sEM = true;
        }
        this.sDY.post(new C42466());
        new C16896c(this).mo26237i(this.sDY);
        new C43696b().mo26237i(this.sEb);
        this.sGz = findViewById(2131828304);
        this.sGB = findViewById(2131828305);
        this.sGz.setVisibility(8);
        this.sHm = findViewById(2131828341);
        this.sHo = findViewById(2131828342);
        this.sHm.setVisibility(8);
        this.sGz.setOnTouchListener(new C42477());
        this.sHm.setOnTouchListener(new C463078());
        this.sGC = (TopStoryCommentFloatDialog) findViewById(2131828306);
        this.sGC.setVisibility(8);
        this.sGC.mo69382k(this);
        AppMethodBeat.m2505o(2117);
    }

    public final C13954d cGE() {
        AppMethodBeat.m2504i(2118);
        C29456d c29456d = new C29456d();
        AppMethodBeat.m2505o(2118);
        return c29456d;
    }

    /* renamed from: fP */
    public final void mo47665fP(int i, int i2) {
        AppMethodBeat.m2504i(2121);
        if ((i2 == 2 || i2 == 1) && this.sGD) {
            cHg();
        }
        super.mo47665fP(i, i2);
        AppMethodBeat.m2505o(2121);
    }

    public final int getLayoutId() {
        return 2130970959;
    }

    public final void cFO() {
        AppMethodBeat.m2504i(2123);
        this.qpb.animate().cancel();
        this.qpb.setAlpha(1.0f);
        if (!(cFT().xgI == null || this.sHh == null)) {
            this.sHh.setAlpha(1.0f);
        }
        AppMethodBeat.m2505o(2123);
    }

    public final void cGG() {
        AppMethodBeat.m2504i(2124);
        super.cGG();
        if (!(this.sEt || this.sHg.getAlpha() == 0.0f)) {
            this.sHg.animate().cancel();
            this.sHg.setAlpha(0.0f);
        }
        AppMethodBeat.m2505o(2124);
    }

    /* renamed from: FC */
    public final boolean mo9157FC(int i) {
        AppMethodBeat.m2504i(2125);
        this.sGz.setVisibility(8);
        this.sHm.setVisibility(8);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoUI", "tryToPlayPositionVideo %d", Integer.valueOf(i));
        try {
            if (this.sEt) {
                if (i < (this.sEd.getItemCount() - this.sEd.getFootersCount()) - this.sEd.getHeadersCount()) {
                    this.sEb.smoothScrollToPosition(i);
                    AppMethodBeat.m2505o(2125);
                    return true;
                }
                C4990ab.m7421w("MicroMsg.TopStory.TopStoryVideoUI", "tryToPlayPositionVideo fullScreen, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", Integer.valueOf(i), Integer.valueOf(this.sEd.getItemCount()), Integer.valueOf(this.sEd.getFootersCount()), Integer.valueOf(this.sEd.getHeadersCount()));
                AppMethodBeat.m2505o(2125);
                return false;
            } else if (i < (this.sHi.getItemCount() - this.sHi.getFootersCount()) - this.sHi.getHeadersCount()) {
                this.sEa.mo26187a(this, this.sHi.getHeadersCount() + i);
                AppMethodBeat.m2505o(2125);
                return true;
            } else {
                C4990ab.m7421w("MicroMsg.TopStory.TopStoryVideoUI", "tryToPlayPositionVideo, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", Integer.valueOf(i), Integer.valueOf(this.sHi.getItemCount()), Integer.valueOf(this.sHi.getFootersCount()), Integer.valueOf(this.sHi.getHeadersCount()));
                AppMethodBeat.m2505o(2125);
                return false;
            }
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.TopStory.TopStoryVideoUI", "tryToPlayPositionVideo Exception:%s", e.getMessage());
        }
    }

    /* renamed from: i */
    public final void mo9194i(List<chw> list, boolean z) {
        AppMethodBeat.m2504i(2126);
        super.mo9194i(list, z);
        C5004al.m7442n(new C399859(), 50);
        AppMethodBeat.m2505o(2126);
    }

    public final void abH(final String str) {
        AppMethodBeat.m2504i(2127);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2110);
                if (TopStoryListVideoUI.this.sEt) {
                    TopStoryListVideoUI.this.sHl.setVisibility(4);
                    TopStoryListVideoUI.this.sHk.setVisibility(4);
                } else {
                    TopStoryListVideoUI.this.sGw.setVisibility(4);
                    TopStoryListVideoUI.this.sGv.setVisibility(4);
                }
                if (TopStoryListVideoUI.this.sGu != null) {
                    TopStoryListVideoUI.this.sGu.dismiss();
                    TopStoryListVideoUI.this.sGu = null;
                }
                TopStoryListVideoUI.m89560a(TopStoryListVideoUI.this, str);
                AppMethodBeat.m2505o(2110);
            }
        });
        AppMethodBeat.m2505o(2127);
    }

    /* renamed from: FJ */
    public final void mo74477FJ(int i) {
        AppMethodBeat.m2504i(2128);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoUI", "onDeviceOrientationChange, orientation: %s sysOrienOn: %s", Integer.valueOf(i), Boolean.valueOf(System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1));
        if (System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1) {
            if (i == 90 || i == 270) {
                if (this.sEt) {
                    AppMethodBeat.m2505o(2128);
                    return;
                }
                aFH();
                AppMethodBeat.m2505o(2128);
                return;
            } else if (i == 180 || i == 0) {
                if (this.sEt) {
                    cGf();
                } else {
                    AppMethodBeat.m2505o(2128);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(2128);
    }

    public final C4233e cGJ() {
        AppMethodBeat.m2504i(2129);
        this.sHi = new C13973e(this);
        C13973e c13973e = this.sHi;
        View inflate = LayoutInflater.from(this).inflate(2130970956, null);
        inflate.setClickable(false);
        inflate.setFocusableInTouchMode(false);
        inflate.setFocusable(false);
        View findViewById = inflate.findViewById(2131828331);
        View findViewById2 = inflate.findViewById(2131828332);
        if (cFT().xgI != null) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(0);
            this.sHh = (TextView) inflate.findViewById(2131828333);
            this.sHh.setText(cFT().xgI.title);
            TextView textView = (TextView) inflate.findViewById(2131828334);
            if (C5046bo.isNullOrNil(cFT().xgI.jcF)) {
                textView.setVisibility(8);
            } else {
                textView.setText(cFT().xgI.jcF);
            }
        } else {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(8);
        }
        inflate.setLayoutParams(new LayoutParams(-1, -2));
        c13973e.addHeaderView(inflate);
        C13973e c13973e2 = this.sHi;
        View inflate2 = LayoutInflater.from(this).inflate(2130970958, null);
        inflate2.setPadding(0, 0, 0, ((C1338a.m2869ge(this.mController.ylL) * 2) / 5) - getResources().getDimensionPixelSize(C25738R.dimen.a_t));
        inflate2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.sGw = inflate2.findViewById(2131828338);
        this.sGv = inflate2.findViewById(2131824238);
        c13973e2.mo9202ei(inflate2);
        c13973e2 = this.sHi;
        AppMethodBeat.m2505o(2129);
        return c13973e2;
    }

    public final C4233e cGK() {
        AppMethodBeat.m2504i(2130);
        this.sHj = new C13958d(this);
        C13958d c13958d = this.sHj;
        View inflate = LayoutInflater.from(this).inflate(2130970958, null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.sHl = inflate.findViewById(2131828338);
        this.sHk = inflate.findViewById(2131824238);
        c13958d.mo9202ei(inflate);
        c13958d = this.sHj;
        AppMethodBeat.m2505o(2130);
        return c13958d;
    }

    public final void aFH() {
        AppMethodBeat.m2504i(2131);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.sHp < 1000) {
            AppMethodBeat.m2505o(2131);
            return;
        }
        this.sHp = currentTimeMillis;
        C4990ab.m7410d("MicroMsg.TopStory.TopStoryVideoUI", "enterFullScreen");
        if (this.sEn.sFu != null) {
            this.sBa.xgM = this.sEn.sFu.getControlBar().getmPosition();
            if (this.sEn.sFu.getControlBar().getVideoTotalTime() - this.sBa.xgM < 2) {
                AppMethodBeat.m2505o(2131);
                return;
            }
        }
        mo74489md(false);
        this.sEt = true;
        this.sHm.setVisibility(8);
        this.sGz.setVisibility(8);
        if (!cGb()) {
            setRequestedOrientation(0);
        }
        if (this.sEq != null && this.sEq.isShowing()) {
            this.sEq.dismiss();
            this.sEq = null;
        }
        this.sHg.setVisibility(8);
        this.gnB.setVisibility(8);
        this.sDW.setVisibility(8);
        this.sDY.setVisibility(8);
        this.sEb.setVisibility(0);
        this.sHi.aop.notifyChanged();
        if (C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_TOP_STORY_SHORT_VIDEO_FS_SCROLL_TIPS_INT, 0) == 0) {
            this.sEn.cpN();
            this.sGx.setVisibility(0);
            this.sGx.setOnTouchListener(new C1396811());
            this.sGy.setOnClickListener(new C424212());
        } else {
            this.sGx.setVisibility(8);
        }
        this.sHj.sFI = true;
        this.sEc.mo1757ah(cFT().xgL, 0);
        getSwipeBackLayout().setEnableGesture(false);
        mo74489md(true);
        AppMethodBeat.m2505o(2131);
    }

    public final void cGf() {
        AppMethodBeat.m2504i(2132);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.sHp < 1000) {
            AppMethodBeat.m2505o(2132);
            return;
        }
        this.sHp = currentTimeMillis;
        C4990ab.m7410d("MicroMsg.TopStory.TopStoryVideoUI", "exitFullScreen");
        if (this.sEn.sFu != null) {
            this.sBa.xgM = this.sEn.sFu.getControlBar().getmPosition();
            if (this.sEn.sFu.getControlBar().getVideoTotalTime() - this.sBa.xgM < 2) {
                AppMethodBeat.m2505o(2132);
                return;
            }
        }
        mo74489md(false);
        this.sEt = false;
        this.sHm.setVisibility(8);
        this.sGz.setVisibility(8);
        if (!cGb()) {
            setRequestedOrientation(1);
        }
        if (this.sEq != null && this.sEq.isShowing()) {
            this.sEq.dismiss();
            this.sEq = null;
        }
        this.sHg.setVisibility(0);
        if (cFT().xgI == null) {
            this.gnB.setVisibility(0);
        }
        this.sDY.setVisibility(0);
        this.sEb.setVisibility(8);
        this.sHj.aop.notifyChanged();
        this.sGx.setVisibility(8);
        this.sHi.sGP = true;
        this.qYS.mo1757ah(cFT().xgL + this.sHi.getHeadersCount(), TopStoryBaseVideoUI.sDT);
        getSwipeBackLayout().setEnableGesture(true);
        mo74489md(true);
        AppMethodBeat.m2505o(2132);
    }

    /* renamed from: fS */
    public final boolean mo9189fS(int i, int i2) {
        AppMethodBeat.m2504i(2134);
        if (cFT().xgI != null) {
            AppMethodBeat.m2505o(2134);
            return true;
        } else if (i <= 30 || ((float) i) / ((float) i2) <= 0.65f) {
            AppMethodBeat.m2505o(2134);
            return false;
        } else {
            C13986n c13986n = this.sEo;
            chv chv = this.sBa;
            String str = this.sEo.mo26218FL(cFY()).xgS;
            int cGR = this.sEo.cGR();
            chv = C39964g.m68428a(chv);
            chv.offset = cGR;
            C1207m c35293j = new C35293j(chv, c13986n.sDo.cFY(), str);
            C1720g.m3540Rg().mo14541a(c35293j, 0);
            C1720g.m3540Rg().mo14539a(1943, new C139871(c35293j));
            AppMethodBeat.m2505o(2134);
            return true;
        }
    }

    public final int cGk() {
        return 0;
    }

    public final C13954d cGF() {
        AppMethodBeat.m2504i(2135);
        C43698c c43698c = new C43698c();
        AppMethodBeat.m2505o(2135);
        return c43698c;
    }

    /* renamed from: a */
    public final void mo74479a(final chw chw, View view, boolean z) {
        AppMethodBeat.m2504i(2136);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", chw.xgS, Boolean.valueOf(z));
        if (z) {
            int i;
            String str = System.currentTimeMillis();
            String str2 = chw.ubA;
            String str3 = "";
            String str4 = "";
            String str5 = "";
            String str6 = "";
            String str7 = chw.title;
            String str8 = cFT().hlm;
            int i2 = cFT().scene;
            if (cGb()) {
                i = 318;
            } else {
                i = C16681c.CTRL_INDEX;
            }
            C13944f c13944f = new C13944f(str, str2, str3, str4, str5, str6, str7, str8, i2, i, chw.xgS, chw.xhi);
            if (this.sEt) {
                this.sHm.setVisibility(0);
                this.sGz.setVisibility(8);
                this.sHn = new C40003c(this.sHo, new C40004a() {

                    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI$2$1 */
                    class C353121 implements C14003a {
                        C353121() {
                        }

                        public final void onDismiss() {
                            AppMethodBeat.m2504i(2098);
                            TopStoryListVideoUI.this.sEn.cEf();
                            AppMethodBeat.m2505o(2098);
                        }

                        public final void cHi() {
                            AppMethodBeat.m2504i(2099);
                            TopStoryListVideoUI.this.sHm.setVisibility(8);
                            TopStoryListVideoUI.this.sGz.setVisibility(8);
                            AppMethodBeat.m2505o(2099);
                        }
                    }

                    /* renamed from: a */
                    public final void mo9227a(C13944f c13944f) {
                        AppMethodBeat.m2504i(2100);
                        TopStoryListVideoUI.this.sGC.mo69378a(c13944f, new C353121(), (int) TopStoryListVideoUI.this.sBa.xgG, chw.xgW);
                        if (TopStoryListVideoUI.this.sEn.cGZ()) {
                            TopStoryListVideoUI.this.sEn.cpN();
                        }
                        AppMethodBeat.m2505o(2100);
                    }
                }, c13944f, chw.xgS);
                C40003c c40003c = this.sHn;
                Context context = view.getContext();
                View view2 = c40003c.contentView;
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                view.getLocationInWindow(iArr2);
                view.getHeight();
                int width = view.getWidth();
                int i3 = C5222ae.m7953hy(context).x;
                view2.measure(0, 0);
                int measuredHeight = view2.getMeasuredHeight();
                int measuredWidth = view2.getMeasuredWidth();
                iArr[0] = ((width / 2) + iArr2[0]) - (measuredWidth / 2);
                iArr[1] = iArr2[1] - measuredHeight;
                Log.m81049i("PopupUtil", "window pos x:" + iArr[0] + ", windowWidth:" + measuredWidth + ", screenWidth:" + i3);
                if (iArr[0] + measuredWidth > i3) {
                    iArr[0] = i3 - measuredWidth;
                }
                iArr[0] = iArr[0] + 0;
                iArr[1] = iArr[1] + 0;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c40003c.contentView.getLayoutParams();
                layoutParams.leftMargin = iArr[0];
                layoutParams.topMargin = iArr[1];
                c40003c.contentView.setLayoutParams(layoutParams);
                this.sHm.postDelayed(new C353133(), 1800);
                AppMethodBeat.m2505o(2136);
                return;
            }
            this.sHm.setVisibility(8);
            this.sGz.setVisibility(0);
            this.sGA = new C40003c(this.sGB, new C40004a() {

                /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI$4$1 */
                class C42441 implements C14003a {
                    C42441() {
                    }

                    public final void onDismiss() {
                        AppMethodBeat.m2504i(TXLiveConstants.PLAY_WARNING_AUDIO_DECODE_FAIL);
                        TopStoryListVideoUI.this.sEn.cEf();
                        AppMethodBeat.m2505o(TXLiveConstants.PLAY_WARNING_AUDIO_DECODE_FAIL);
                    }

                    public final void cHi() {
                        AppMethodBeat.m2504i(TXLiveConstants.PLAY_WARNING_RECONNECT);
                        TopStoryListVideoUI.this.sHm.setVisibility(8);
                        TopStoryListVideoUI.this.sGz.setVisibility(8);
                        AppMethodBeat.m2505o(TXLiveConstants.PLAY_WARNING_RECONNECT);
                    }
                }

                /* renamed from: a */
                public final void mo9227a(C13944f c13944f) {
                    AppMethodBeat.m2504i(TXLiveConstants.PLAY_WARNING_RECV_DATA_LAG);
                    TopStoryListVideoUI.this.sGC.mo69378a(c13944f, new C42441(), (int) TopStoryListVideoUI.this.sBa.xgG, chw.xgW);
                    if (TopStoryListVideoUI.this.sEn.cGZ()) {
                        TopStoryListVideoUI.this.sEn.cpN();
                    }
                    AppMethodBeat.m2505o(TXLiveConstants.PLAY_WARNING_RECV_DATA_LAG);
                }
            }, c13944f, chw.xgS);
            this.sGA.mo63238a(view, false, 0 - C4251f.dip2px(this, 10.0f));
            AppMethodBeat.m2505o(2136);
            return;
        }
        if (this.sHm.getVisibility() == 0) {
            if (!(this.sHn == null || this.sHn.fgd == null || !this.sHn.fgd.equals(chw.xgS))) {
                this.sHm.setVisibility(8);
                AppMethodBeat.m2505o(2136);
                return;
            }
        } else if (this.sGz.getVisibility() == 0 && this.sGA != null && this.sGA.fgd != null && this.sGA.fgd.equals(chw.xgS)) {
            this.sGz.setVisibility(8);
        }
        AppMethodBeat.m2505o(2136);
    }

    public void onPause() {
        AppMethodBeat.m2504i(2137);
        super.onPause();
        this.sGC.onPause();
        AppMethodBeat.m2505o(2137);
    }

    public void onResume() {
        AppMethodBeat.m2504i(2138);
        super.onResume();
        this.sGC.onResume();
        AppMethodBeat.m2505o(2138);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(2139);
        super.onDestroy();
        this.sGC.sIl.close();
        AppMethodBeat.m2505o(2139);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(2140);
        if (i == 4 && this.sGC.getVisibility() == 0) {
            this.sGC.hide();
            AppMethodBeat.m2505o(2140);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(2140);
        return onKeyDown;
    }

    public final int getForceOrientation() {
        AppMethodBeat.m2504i(2114);
        if (!this.sEt || cGb()) {
            AppMethodBeat.m2505o(2114);
            return 1;
        }
        AppMethodBeat.m2505o(2114);
        return 0;
    }

    public final void cGC() {
        AppMethodBeat.m2504i(2116);
        if (this.sEt) {
            cGf();
            AppMethodBeat.m2505o(2116);
            return;
        }
        if (this.sBa != null) {
            Intent intent = new Intent();
            intent.putExtra("isMute", this.sBa.eif);
            intent.putExtra("MOBILE_CHECK_FLAG", this.sBa.xgO);
            setResult(-1, intent);
        }
        finish();
        AppMethodBeat.m2505o(2116);
    }

    public final void cGH() {
        AppMethodBeat.m2504i(2119);
        if (this.sEt) {
            this.sHl.setVisibility(0);
            this.sHk.setVisibility(0);
        } else {
            this.sGw.setVisibility(0);
            this.sGv.setVisibility(0);
        }
        this.sEo.mo26219FM(this.sEo.cGR());
        AppMethodBeat.m2505o(2119);
    }

    private void cHg() {
        AppMethodBeat.m2504i(2120);
        if (this.sEt) {
            this.sHl.setVisibility(0);
            this.sHk.setVisibility(0);
        } else {
            this.sGw.setVisibility(0);
            this.sGv.setVisibility(0);
        }
        this.sEo.mo26219FM(0);
        AppMethodBeat.m2505o(2120);
    }

    public final void cFN() {
        AppMethodBeat.m2504i(2122);
        if (this.sEt) {
            this.sHm.setVisibility(8);
        } else {
            this.sHg.animate().alpha(1.0f).setDuration(200).setStartDelay(1800);
        }
        this.qpb.animate().alpha(0.1f).setDuration(200).setStartDelay(1800);
        if (!(cFT().xgI == null || this.sHh == null)) {
            this.sHh.animate().alpha(0.1f).setDuration(200).setStartDelay(1800);
        }
        AppMethodBeat.m2505o(2122);
    }

    /* renamed from: a */
    public final void mo9160a(bzs bzs) {
        C23447tn c23447tn;
        boolean z;
        AppMethodBeat.m2504i(2133);
        if (this.sEt) {
            cGf();
        }
        this.sEk.sEM = true;
        this.sEn.stopPlay();
        chw FL = this.sEo.mo26218FL(cFY());
        chv a = C39964g.m68428a(cFT());
        a.xgj = UUID.randomUUID().toString();
        a.xgC = FL.xgS;
        a.xgG = bzs.wYN;
        a.xgH = null;
        a.xgI = bzs;
        a.xgJ = this.sEk.sEM;
        Iterator it = a.tZG.iterator();
        while (it.hasNext()) {
            c23447tn = (C23447tn) it.next();
            if ("show_tag_list".equals(c23447tn.key)) {
                c23447tn.waE = bzs.f4415id;
                z = true;
                break;
            }
        }
        z = false;
        if (!z) {
            c23447tn = new C23447tn();
            c23447tn.key = "show_tag_list";
            c23447tn.waE = bzs.f4415id;
            a.tZG.add(c23447tn);
        }
        C46400aa.m87322a((Activity) this, a);
        C14419a.m22633kT(28);
        ((C13943b) C1720g.m3530M(C13943b.class)).getReporter().mo9124a(cFT(), FL, cFY(), 4, bzs.cEh + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bzs.f4415id);
        AppMethodBeat.m2505o(2133);
    }

    /* renamed from: g */
    static /* synthetic */ boolean m89567g(View view, float f, float f2) {
        AppMethodBeat.m2504i(2141);
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int measuredWidth = view.getMeasuredWidth() + i;
            int measuredHeight = view.getMeasuredHeight() + i2;
            if (f2 >= ((float) i2) && f2 <= ((float) measuredHeight) && f >= ((float) i) && f <= ((float) measuredWidth)) {
                AppMethodBeat.m2505o(2141);
                return true;
            }
        }
        AppMethodBeat.m2505o(2141);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m89560a(TopStoryListVideoUI topStoryListVideoUI, String str) {
        AppMethodBeat.m2504i(2142);
        if (!C5023at.isNetworkConnected(topStoryListVideoUI)) {
            Toast.makeText(topStoryListVideoUI, topStoryListVideoUI.getString(C25738R.string.dj1), 1).show();
            AppMethodBeat.m2505o(2142);
        } else if (C5046bo.isNullOrNil(str)) {
            Toast.makeText(topStoryListVideoUI, topStoryListVideoUI.getString(C25738R.string.dj2), 1).show();
            AppMethodBeat.m2505o(2142);
        } else {
            Toast.makeText(topStoryListVideoUI, str, 1).show();
            AppMethodBeat.m2505o(2142);
        }
    }
}
