package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C17895o;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C21925g;
import com.tencent.p177mm.plugin.sns.model.C43558b;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p520ui.C39842f.C39841a;
import com.tencent.p177mm.plugin.sns.p520ui.C39842f.C39843b;
import com.tencent.p177mm.protocal.protobuf.C35917fq;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.sns.ui.ArtistUI */
public class ArtistUI extends MMActivity implements C1202f {
    private SharedPreferences ehZ;
    private ListView gGW;
    C7306ak lda = C13373af.bCo();
    private String nJy = "";
    private C39842f rgL;
    private ArtistHeader rgM;
    private C1207m rgN = null;
    C21925g rgO = C13373af.cnC();
    C43558b rgP = C13373af.cnA();
    private Runnable rgQ = new C291051();
    private Runnable rgR = new C291042();
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.sns.ui.ArtistUI$3 */
    class C219933 implements OnCancelListener {
        C219933() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ArtistUI$4 */
    class C219944 extends C39843b {
        C219944() {
        }

        /* renamed from: DM */
        public final void mo37535DM(int i) {
            AppMethodBeat.m2504i(38116);
            Intent intent = new Intent();
            intent.putExtra("sns_gallery_is_artist", true);
            intent.putExtra("sns_gallery_position", i);
            intent.putExtra("sns_gallery_artist_lan", ArtistUI.this.nJy);
            intent.putExtra("sns_gallery_showtype", 2);
            intent.setClass(ArtistUI.this, ArtistBrowseUI.class);
            ArtistUI.this.startActivity(intent);
            AppMethodBeat.m2505o(38116);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ArtistUI$5 */
    class C219955 implements C39841a {
        C219955() {
        }

        /* renamed from: a */
        public final void mo37536a(C35917fq c35917fq) {
            AppMethodBeat.m2504i(38117);
            if (ArtistUI.this.rgM != null) {
                ArtistUI.this.rgM.setVisibility(0);
                ArtistUI.this.rgM.setUserName(c35917fq);
                String str = c35917fq.Name;
                if (!(str == null || str.equals(""))) {
                    ArtistUI.this.ehZ.edit().putString("artist_name", str).commit();
                }
                if (ArtistUI.this.rgL != null) {
                    ArtistUI.this.rgL.notifyDataSetChanged();
                }
            }
            ArtistUI.this.tipDialog.dismiss();
            AppMethodBeat.m2505o(38117);
        }

        /* renamed from: b */
        public final void mo37537b(C35917fq c35917fq) {
            AppMethodBeat.m2504i(38118);
            if (ArtistUI.this.rgM != null) {
                ArtistUI.this.rgM.setVisibility(0);
                ArtistUI.this.rgM.setUserName(c35917fq);
            }
            AppMethodBeat.m2505o(38118);
        }

        public final void crx() {
            AppMethodBeat.m2504i(38119);
            if (ArtistUI.this.rgN == null && ArtistUI.this.tipDialog != null) {
                C4990ab.m7410d("MicroMsg.ArtistUI", "onNothingBgGet");
                C24826a.gkF.mo38863bj(true);
            }
            AppMethodBeat.m2505o(38119);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ArtistUI$2 */
    class C291042 implements Runnable {
        C291042() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38115);
            if (ArtistUI.this.rgL == null) {
                AppMethodBeat.m2505o(38115);
                return;
            }
            C4990ab.m7410d("MicroMsg.ArtistUI", "will start ImageLoader");
            C13373af.cnC().start();
            ArtistUI.this.rgL.notifyDataSetChanged();
            AppMethodBeat.m2505o(38115);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ArtistUI$1 */
    class C291051 implements Runnable {
        C291051() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38114);
            if (ArtistUI.this.rgL == null) {
                AppMethodBeat.m2505o(38114);
                return;
            }
            C4990ab.m7410d("MicroMsg.ArtistUI", "will pause ImageLoader");
            C13373af.cnC().pause();
            AppMethodBeat.m2505o(38114);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ArtistUI$6 */
    class C291066 implements OnScrollListener {
        C291066() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(38120);
            if (i == 2) {
                if (ArtistUI.this.rgO.qHJ || ArtistUI.this.rgP.qHJ) {
                    ArtistUI.this.lda.removeCallbacks(ArtistUI.this.rgQ);
                    ArtistUI.this.lda.removeCallbacks(ArtistUI.this.rgR);
                    ArtistUI.this.lda.postDelayed(ArtistUI.this.rgQ, 0);
                    AppMethodBeat.m2505o(38120);
                    return;
                }
            } else if (ArtistUI.this.rgO.qHJ && ArtistUI.this.rgP.qHJ) {
                AppMethodBeat.m2505o(38120);
                return;
            } else {
                ArtistUI.this.lda.removeCallbacks(ArtistUI.this.rgQ);
                ArtistUI.this.lda.removeCallbacks(ArtistUI.this.rgR);
                ArtistUI.this.lda.postDelayed(ArtistUI.this.rgR, 0);
            }
            AppMethodBeat.m2505o(38120);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ArtistUI$7 */
    class C291077 implements OnMenuItemClickListener {
        C291077() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(38121);
            ArtistUI.this.finish();
            AppMethodBeat.m2505o(38121);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ArtistUI() {
        AppMethodBeat.m2504i(38122);
        AppMethodBeat.m2505o(38122);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(38123);
        super.onCreate(bundle);
        String g = C4988aa.m7402g(getSharedPreferences(C4996ah.doA(), 0));
        C4990ab.m7410d("MicroMsg.ArtistUI", "filterLan temp ".concat(String.valueOf(g)));
        if (!(g.equals("zh_CN") || g.equals("en") || g.equals("zh_TW"))) {
            g = g.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.nJy = g;
        C4990ab.m7410d("MicroMsg.ArtistUI", "lan " + this.nJy);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (C1202f) this);
        this.ehZ = getSharedPreferences(C4996ah.doA(), 0);
        initView();
        C13373af.cnA().mo69136a(this.rgM);
        AppMethodBeat.m2505o(38123);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(38124);
        super.onDestroy();
        if (this.tipDialog != null) {
            this.tipDialog = null;
        }
        if (this.rgM != null) {
            C13373af.cnA().mo69142b(this.rgM);
        }
        C13373af.cnC().mo37452ab(this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(38124);
    }

    public void onResume() {
        AppMethodBeat.m2504i(38125);
        super.onResume();
        AppMethodBeat.m2505o(38125);
    }

    public void onPause() {
        AppMethodBeat.m2504i(38126);
        super.onPause();
        AppMethodBeat.m2505o(38126);
    }

    public final void initView() {
        AppMethodBeat.m2504i(38127);
        setMMTitle((int) C25738R.string.eat);
        getString(C25738R.string.f9238tz);
        this.tipDialog = C30379h.m48458b((Context) this, getString(C25738R.string.f9161re), true, new C219933());
        this.gGW = (ListView) findViewById(2131827689);
        C24826a.gkF.mo38863bj(false);
        this.rgL = new C39842f(this, this.nJy, new C219944(), new C219955());
        this.gGW.setOnScrollListener(new C291066());
        this.rgM = new ArtistHeader(this);
        this.gGW.addHeaderView(this.rgM);
        this.gGW.setAdapter(this.rgL);
        this.rgL.notifyDataSetChanged();
        this.rgM.setVisibility(8);
        setBackBtn(new C291077());
        AppMethodBeat.m2505o(38127);
    }

    public final int getLayoutId() {
        return 2130970747;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(38128);
        if ((c1207m instanceof C17895o) && ((C17895o) c1207m).acR() == 4) {
            C4990ab.m7416i("MicroMsg.ArtistUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + c1207m.getType() + " @" + hashCode());
            if (i == 0 && i2 == 0) {
                switch (c1207m.getType()) {
                    case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
                        if (this.rgL != null) {
                            this.rgL.mo63031KC();
                        }
                        this.rgN = null;
                        break;
                }
                AppMethodBeat.m2505o(38128);
                return;
            }
            if (c1207m.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX && this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            AppMethodBeat.m2505o(38128);
            return;
        }
        C4990ab.m7410d("MicroMsg.ArtistUI", "another scene");
        AppMethodBeat.m2505o(38128);
    }
}
