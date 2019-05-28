package com.tencent.p177mm.plugin.music.p467ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.p230g.p231a.C9357gk;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.music.model.C39441b;
import com.tencent.p177mm.plugin.music.model.C39444d;
import com.tencent.p177mm.plugin.music.model.C39445e;
import com.tencent.p177mm.plugin.music.model.C46105c;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.plugin.music.model.p466d.C3541d;
import com.tencent.p177mm.plugin.music.p462e.C28559e;
import com.tencent.p177mm.plugin.music.p462e.C39435k;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.plugin.music.p463f.p464a.C34578d.C34579a;
import com.tencent.p177mm.plugin.music.p467ui.C39449b.C39450a;
import com.tencent.p177mm.plugin.music.p467ui.MusicSeekBar.C12687a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1082i.C30050d;
import com.tencent.p177mm.pluginsdk.p1082i.C30050d.C30051a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.music.ui.MusicMainUI */
public class MusicMainUI extends MMActivity implements OnPageChangeListener, C1202f {
    private C7306ak eet = new C7306ak(Looper.getMainLooper());
    private C4884c hAA = new C69873();
    private long mfT;
    private int mode;
    private C34579a oKa = new C285838();
    private boolean oMH;
    private CheckBox oON;
    private ImageButton oOO;
    private ImageButton oOP;
    private MusicSeekBar oOQ;
    private MusicViewPager oOR;
    private C30050d oOS;
    private C39449b oOT;
    private boolean oOU;
    private int oOV = 0;
    private Timer oOW;
    private int oOX = -1;
    private C7306ak oOY = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(105104);
            if (message.what == 1) {
                MusicMainUI.m45402p(MusicMainUI.this);
            }
            AppMethodBeat.m2505o(105104);
        }
    };
    private int scene;

    /* renamed from: com.tencent.mm.plugin.music.ui.MusicMainUI$3 */
    class C69873 extends C4884c<C37752ke> {

        /* renamed from: com.tencent.mm.plugin.music.ui.MusicMainUI$3$5 */
        class C69885 implements Runnable {
            C69885() {
            }

            public final void run() {
                AppMethodBeat.m2504i(105095);
                MusicMainUI.this.oOR.setCurrentItem(MusicMainUI.this.oOR.getCurrentItem() - 1);
                AppMethodBeat.m2505o(105095);
            }
        }

        /* renamed from: com.tencent.mm.plugin.music.ui.MusicMainUI$3$6 */
        class C69906 implements Runnable {
            C69906() {
            }

            public final void run() {
                AppMethodBeat.m2504i(105096);
                MusicMainUI.this.oOR.setCurrentItem(MusicMainUI.this.oOR.getCurrentItem() + 1);
                AppMethodBeat.m2505o(105096);
            }
        }

        /* renamed from: com.tencent.mm.plugin.music.ui.MusicMainUI$3$3 */
        class C69923 implements Runnable {
            C69923() {
            }

            public final void run() {
                AppMethodBeat.m2504i(105093);
                MusicMainUI musicMainUI = MusicMainUI.this;
                if (((Boolean) C1720g.m3536RP().mo5239Ry().get(82, Boolean.TRUE)).booleanValue()) {
                    C1720g.m3536RP().mo5239Ry().set(82, Boolean.FALSE);
                    switch (((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_musicType) {
                        case 0:
                            C39444d.m67383S(musicMainUI, C25738R.string.eee);
                            break;
                        case 1:
                        case 8:
                            C39444d.m67383S(musicMainUI, C25738R.string.eeh);
                            break;
                        case 4:
                            C39444d.m67383S(musicMainUI, C25738R.string.eeg);
                            break;
                        case 6:
                            C39444d.m67383S(musicMainUI, C25738R.string.eef);
                            break;
                    }
                } else if (((C28559e) C43329b.m77295ar(C28559e.class)).getMode() == 2) {
                    Toast.makeText(C4996ah.getContext(), C25738R.string.eu5, 0).show();
                } else {
                    Toast.makeText(C4996ah.getContext(), C25738R.string.eu6, 0).show();
                }
                MusicMainUI.m45397k(MusicMainUI.this);
                AppMethodBeat.m2505o(105093);
            }
        }

        /* renamed from: com.tencent.mm.plugin.music.ui.MusicMainUI$3$2 */
        class C69932 implements Runnable {
            C69932() {
            }

            public final void run() {
                AppMethodBeat.m2504i(105092);
                MusicMainUI.this.oOR.setCurrentItem(MusicMainUI.this.oOR.getCurrentItem() + 1);
                AppMethodBeat.m2505o(105092);
            }
        }

        C69873() {
            AppMethodBeat.m2504i(105097);
            this.xxI = C37752ke.class.getName().hashCode();
            AppMethodBeat.m2505o(105097);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(105098);
            final C37752ke c37752ke = (C37752ke) c4883b;
            switch (c37752ke.cFH.action) {
                case 0:
                case 1:
                    MusicMainUI.this.oON.setChecked(false);
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(105091);
                            if (c37752ke.cFH.action == 0 && ((C28559e) C43329b.m77295ar(C28559e.class)).getMode() != 2) {
                                MusicMainUI.this.oOR.setAdapter(MusicMainUI.this.oOT);
                                MusicMainUI.this.oOR.setCurrentItem(((C28559e) C43329b.m77295ar(C28559e.class)).bUa() + 100000);
                            }
                            MusicMainUI.m45397k(MusicMainUI.this);
                            AppMethodBeat.m2505o(105091);
                        }
                    });
                    break;
                case 2:
                case 3:
                case 4:
                    MusicMainUI.this.oON.setChecked(true);
                    break;
                case 5:
                    C35988ay.m59201au(MusicMainUI.this.mController.ylL, C25738R.string.ef_);
                    C5004al.m7441d(new C69923());
                    break;
                case 6:
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            boolean z;
                            AppMethodBeat.m2504i(105094);
                            C39449b i = MusicMainUI.this.oOT;
                            String str = c37752ke.cFH.cFI;
                            boolean z2 = false;
                            Iterator it = i.oOu.entrySet().iterator();
                            while (true) {
                                z = z2;
                                if (!it.hasNext()) {
                                    break;
                                }
                                C39450a c39450a = (C39450a) ((View) ((Entry) it.next()).getValue()).getTag();
                                if (c39450a.oMw.field_musicId.equals(str)) {
                                    c39450a.mo62399d(C39445e.bUk().mo24653Tp(str), true);
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                            }
                            if (!z) {
                                C4990ab.m7416i("MicroMsg.Music.MusicMainAdapter", "holder song id is not exist, do refresh all");
                                i.notifyDataSetChanged();
                            }
                            AppMethodBeat.m2505o(105094);
                        }
                    });
                    break;
                case 7:
                    if (((C28559e) C43329b.m77295ar(C28559e.class)).getMode() != 2) {
                        MusicMainUI.this.oON.setChecked(true);
                        break;
                    }
                    C5004al.m7441d(new C69932());
                    break;
                case 8:
                    MusicMainUI.this.oOQ.mo24660jA(false);
                    break;
                case 13:
                    if (((C28559e) C43329b.m77295ar(C28559e.class)).getMode() == 2) {
                        C5004al.m7441d(new C69885());
                        break;
                    }
                    break;
                case 14:
                    if (((C28559e) C43329b.m77295ar(C28559e.class)).getMode() == 2) {
                        C5004al.m7441d(new C69906());
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(105098);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.ui.MusicMainUI$1 */
    class C126821 implements OnClickListener {
        C126821() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(105089);
            MusicMainUI.m45385a(MusicMainUI.this);
            if (MusicMainUI.this.oON.isChecked()) {
                C37494a.m63277KX();
                MusicMainUI.this.oON.setChecked(true);
                AppMethodBeat.m2505o(105089);
                return;
            }
            MusicMainUI.this.oOU = true;
            if (C39435k.bUf().bTS().aig()) {
                C39435k.bUf().bTS().resume();
            } else {
                C39435k.bUf().mo62388p(null);
            }
            MusicMainUI.this.oON.setChecked(false);
            AppMethodBeat.m2505o(105089);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.ui.MusicMainUI$2 */
    class C126832 implements C12687a {
        C126832() {
        }

        /* renamed from: zV */
        public final void mo24659zV(int i) {
            AppMethodBeat.m2504i(105090);
            C37494a.m63283lP(i);
            MusicMainUI.this.oOQ.setProgress(i);
            MusicMainUI.this.oOQ.mo24660jA(true);
            AppMethodBeat.m2505o(105090);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.ui.MusicMainUI$4 */
    class C285794 extends TimerTask {
        C285794() {
        }

        public final void run() {
            AppMethodBeat.m2504i(105099);
            MusicMainUI.this.oKa.mo46715dN(0, 0);
            AppMethodBeat.m2505o(105099);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.ui.MusicMainUI$8 */
    class C285838 implements C34579a {
        C285838() {
        }

        /* renamed from: dN */
        public final void mo46715dN(int i, int i2) {
            AppMethodBeat.m2504i(105103);
            if (MusicMainUI.this.mode == 1 && !MusicMainUI.this.oOU) {
                float floatExtra = MusicMainUI.this.getIntent().getFloatExtra("key_offset", 0.0f);
                floatExtra *= 1000.0f;
                long currentTimeMillis = (long) (floatExtra + ((float) (System.currentTimeMillis() - MusicMainUI.this.getIntent().getLongExtra("music_player_beg_time", 0))));
                if (currentTimeMillis >= 0) {
                    MusicMainUI.this.oOT.mo62394T(MusicMainUI.this.oOR.getCurrentItem(), currentTimeMillis + 200);
                }
            } else if (i >= 0 && i2 > 0) {
                MusicMainUI.this.oOT.mo62394T(MusicMainUI.this.oOR.getCurrentItem(), (long) i);
            }
            Message message = new Message();
            message.what = 1;
            MusicMainUI.this.oOY.sendMessage(message);
            AppMethodBeat.m2505o(105103);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.ui.MusicMainUI$a */
    class C28584a implements Runnable {
        int position;

        public C28584a(int i) {
            this.position = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(105105);
            ((C28559e) C43329b.m77295ar(C28559e.class)).mo46651zH(this.position);
            C28575a bTU = ((C28559e) C43329b.m77295ar(C28559e.class)).bTU();
            if (bTU == null) {
                AppMethodBeat.m2505o(105105);
                return;
            }
            if (bTU.bUu()) {
                MusicMainUI.this.mo46711i(bTU);
            }
            if (((C28559e) C43329b.m77295ar(C28559e.class)).bUc()) {
                MusicMainUI.this.oOR.setCanSlide(true);
            }
            MusicMainUI.m45386a(MusicMainUI.this, bTU);
            AppMethodBeat.m2505o(105105);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.ui.MusicMainUI$b */
    class C28585b extends C30051a {
        private C28585b() {
        }

        /* synthetic */ C28585b(MusicMainUI musicMainUI, byte b) {
            this();
        }

        public final void bUT() {
            AppMethodBeat.m2504i(105106);
            C4990ab.m7417i("MicroMsg.Music.MusicMainUI", "shake %b", Boolean.TRUE);
            long az = C5046bo.m7525az(MusicMainUI.this.mfT);
            if (az < 1200) {
                C4990ab.m7416i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:".concat(String.valueOf(az)));
                AppMethodBeat.m2505o(105106);
                return;
            }
            C4990ab.m7420w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:".concat(String.valueOf(az)));
            MusicMainUI.this.mfT = C5046bo.m7588yz();
            MusicMainUI.this.oOV = MusicMainUI.this.oOV + 1;
            if (MusicMainUI.this.oOV % 2 == 0) {
                ((C28559e) C43329b.m77295ar(C28559e.class)).mo46650xs(MusicMainUI.this.scene);
            }
            AppMethodBeat.m2505o(105106);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MusicMainUI() {
        AppMethodBeat.m2504i(105107);
        AppMethodBeat.m2505o(105107);
    }

    /* renamed from: a */
    static /* synthetic */ void m45385a(MusicMainUI musicMainUI) {
        AppMethodBeat.m2504i(105121);
        musicMainUI.bUR();
        AppMethodBeat.m2505o(105121);
    }

    /* renamed from: k */
    static /* synthetic */ void m45397k(MusicMainUI musicMainUI) {
        AppMethodBeat.m2504i(105122);
        musicMainUI.bUQ();
        AppMethodBeat.m2505o(105122);
    }

    /* renamed from: p */
    static /* synthetic */ void m45402p(MusicMainUI musicMainUI) {
        AppMethodBeat.m2504i(105124);
        musicMainUI.bUS();
        AppMethodBeat.m2505o(105124);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(105108);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        getWindow().setFlags(67109888, 67109888);
        this.mode = getIntent().getIntExtra("key_mode", 2);
        this.scene = getIntent().getIntExtra("key_scene", 0);
        this.oMH = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
        this.oOR = (MusicViewPager) findViewById(2131826264);
        this.oOT = new C39449b(this, this.scene, this.oMH);
        this.oOR.setAdapter(this.oOT);
        this.oOR.setOnPageChangeListener(this);
        this.oOR.setSystemUiVisibility(4096);
        this.oOO = (ImageButton) findViewById(2131826267);
        this.oOP = (ImageButton) findViewById(2131826268);
        LayoutParams layoutParams = (LayoutParams) this.oOO.getLayoutParams();
        int i = layoutParams.topMargin;
        if (C5222ae.m7950hD(this.mController.ylL)) {
            i += C5222ae.getStatusBarHeight(this.mController.ylL);
        }
        layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
        this.oOO.setLayoutParams(layoutParams);
        layoutParams = (LayoutParams) this.oOP.getLayoutParams();
        i = layoutParams.topMargin;
        if (C5222ae.m7950hD(this.mController.ylL)) {
            i += C5222ae.getStatusBarHeight(this.mController.ylL);
        }
        layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
        this.oOP.setLayoutParams(layoutParams);
        this.oON = (CheckBox) findViewById(2131826265);
        this.oON.setChecked(!C39435k.bUf().bTS().aie());
        this.oOS = new C30050d(this);
        this.oON.setOnClickListener(new C126821());
        C4879a.xxA.mo10052c(this.hAA);
        this.oOQ = (MusicSeekBar) findViewById(2131826266);
        this.oOQ.setOnSeekBarChange(new C126832());
        if (!this.oOS.diK()) {
            C4990ab.m7420w("MicroMsg.Music.MusicMainUI", "not support shake");
        }
        bUQ();
        this.oOR.setCurrentItem(((C28559e) C43329b.m77295ar(C28559e.class)).bUa() + 100000);
        i = this.scene;
        if (((C28559e) C43329b.m77295ar(C28559e.class)).bTU() != null) {
            C4990ab.m7419v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", Integer.valueOf(13041), Integer.valueOf(i), ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_musicId, ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_songName, ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_songAlbum, Integer.valueOf(((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_songId), ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_songSinger, ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_appId);
            C7060h.pYm.mo8381e(13041, Integer.valueOf(i), r0.field_musicId, r0.field_songName, r0.field_songAlbum, Integer.valueOf(r0.field_songId), r0.field_songSinger, r0.field_appId);
        }
        C7060h.pYm.mo8378a(285, 1, 1, false);
        C28575a bTU = ((C28559e) C43329b.m77295ar(C28559e.class)).bTU();
        if (bTU == null) {
            finish();
            AppMethodBeat.m2505o(105108);
            return;
        }
        if (this.scene == 4 && ((C28559e) C43329b.m77295ar(C28559e.class)).getMode() == 2) {
            int i2 = C1720g.m3536RP().mo5239Ry().getInt(83, 0);
            if (i2 < 3) {
                Toast.makeText(this, C25738R.string.c2c, 0).show();
                C1720g.m3536RP().mo5239Ry().set(83, Integer.valueOf(i2 + 1));
            }
        }
        if (this.scene == 5) {
            C3541d.m5829a(0, bTU);
        }
        m45394h(bTU);
        if (this.mode == 1) {
            if (this.oOW == null) {
                this.oOW = new Timer();
            }
            this.oOW.schedule(new C285794(), 0, 500);
        }
        AppMethodBeat.m2505o(105108);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
    }

    public void onResume() {
        AppMethodBeat.m2504i(105109);
        super.onResume();
        if (!((C28559e) C43329b.m77295ar(C28559e.class)).bTV()) {
            C4990ab.m7416i("MicroMsg.Music.MusicMainUI", "no need to shake music");
            ((C28559e) C43329b.m77295ar(C28559e.class)).bTX();
        } else if (!this.oMH) {
            if (!(this.oOS == null || !this.oOS.diK() || this.oOS.diI())) {
                this.oOS.mo48276a(new C28585b(this, (byte) 0));
            }
            this.mfT = C5046bo.m7588yz();
        }
        C39435k.bUf().bTS().mo55147a(this.oKa);
        bUS();
        AppMethodBeat.m2505o(105109);
    }

    public void onPause() {
        AppMethodBeat.m2504i(105110);
        super.onPause();
        if (this.oOS != null) {
            this.oOS.bgr();
        }
        C39435k.bUf().bTS().mo55147a(null);
        AppMethodBeat.m2505o(105110);
    }

    private void bUQ() {
        AppMethodBeat.m2504i(105111);
        C43329b.m77295ar(C28559e.class);
        this.oOT.count = 200000;
        this.oOT.notifyDataSetChanged();
        if (((C28559e) C43329b.m77295ar(C28559e.class)).bUc()) {
            this.oOR.setCanSlide(true);
            AppMethodBeat.m2505o(105111);
            return;
        }
        this.oOR.setCanSlide(false);
        AppMethodBeat.m2505o(105111);
    }

    private void bUR() {
        AppMethodBeat.m2504i(105112);
        if (this.oOW != null) {
            this.oOW.cancel();
        }
        this.oOW = null;
        AppMethodBeat.m2505o(105112);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(105113);
        super.onDestroy();
        if (this.oOS != null) {
            this.oOS.bgr();
        }
        if (this.oOT != null) {
            C39449b c39449b = this.oOT;
            c39449b.oMs.removeCallbacksAndMessages(null);
            C46105c c46105c = c39449b.oOv;
            c46105c.oMs.removeCallbacksAndMessages(null);
            c46105c.edn.clear();
        }
        if (this.oOQ != null) {
            this.oOQ.mo24660jA(false);
        }
        bUR();
        C4879a.xxA.mo10053d(this.hAA);
        C39435k.bUf().bTS().mo55147a(null);
        if (!C39435k.bUf().bTS().aie()) {
            C39435k.bUf().bTS().stopPlay();
        }
        ((C28559e) C43329b.m77295ar(C28559e.class)).bUb();
        AppMethodBeat.m2505o(105113);
    }

    public void onClickBack(View view) {
        AppMethodBeat.m2504i(105114);
        finish();
        AppMethodBeat.m2505o(105114);
    }

    public final int getLayoutId() {
        return 2130970274;
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    /* renamed from: h */
    private void m45394h(C28575a c28575a) {
        AppMethodBeat.m2504i(105116);
        if (!C39444d.m67386a(c28575a) || this.oMH) {
            this.oON.setVisibility(8);
            this.oOP.setVisibility(8);
            AppMethodBeat.m2505o(105116);
            return;
        }
        this.oON.setVisibility(0);
        this.oOP.setVisibility(0);
        AppMethodBeat.m2505o(105116);
    }

    public void onPageSelected(int i) {
        AppMethodBeat.m2504i(105117);
        C4990ab.m7417i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", Integer.valueOf(i));
        if (((C28559e) C43329b.m77295ar(C28559e.class)).bUc()) {
            this.oOR.setCanSlide(false);
        }
        this.eet.removeCallbacksAndMessages(null);
        this.eet.postDelayed(new C28584a(i), 500);
        if (this.oOX == -1) {
            this.oOX = i;
        }
        if (this.oOX != i) {
            this.oOX = i;
            C3541d.oNi = true;
            C7060h.pYm.mo8378a(285, 3, 1, false);
            C3541d.m5831eJ(1, this.scene);
        }
        AppMethodBeat.m2505o(105117);
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(105118);
        if (-1 == i2 && 1 == i) {
            C9058e bTQ = C39435k.bUf().bTQ();
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            WXMusicObject wXMusicObject = new WXMusicObject();
            wXMusicObject.musicUrl = bTQ.fKc;
            wXMusicObject.musicDataUrl = bTQ.fKa;
            wXMusicObject.musicLowBandUrl = bTQ.fKb;
            wXMusicObject.musicLowBandDataUrl = bTQ.fKb;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXMusicObject;
            wXMediaMessage.title = bTQ.fJW;
            wXMediaMessage.description = bTQ.fJX;
            Bitmap bitmap = null;
            String u = C39444d.m67389u(bTQ);
            if (u != null && C5730e.m8628ct(u)) {
                int dimension = (int) getResources().getDimension(C25738R.dimen.f9972lw);
                bitmap = C5056d.m7642ap(u, dimension, dimension);
            }
            if (bitmap != null) {
                wXMediaMessage.thumbData = C5046bo.m7522an(bitmap);
            } else {
                wXMediaMessage.thumbData = C5046bo.m7522an(C5056d.m7610LV(C25738R.drawable.b27));
            }
            C39441b.gkE.mo38900a(this, C39444d.m67390v(bTQ), wXMediaMessage, stringExtra, C39444d.m67391w(bTQ));
            C4990ab.m7417i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", stringExtra);
            AppMethodBeat.m2505o(105118);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(105118);
    }

    private void bUS() {
        AppMethodBeat.m2504i(105119);
        int bTi = C39435k.bUf().bTS().bTi();
        int duration = C39435k.bUf().bTS().getDuration();
        if (bTi > 0 && duration > 0) {
            this.oOQ.setProgress(bTi);
            this.oOQ.setMaxProgress(duration);
        }
        AppMethodBeat.m2505o(105119);
    }

    /* renamed from: i */
    public final void mo46711i(C28575a c28575a) {
        AppMethodBeat.m2504i(105120);
        C28575a bTU = ((C28559e) C43329b.m77295ar(C28559e.class)).bTU();
        if (bTU == null) {
            AppMethodBeat.m2505o(105120);
            return;
        }
        if (!(!bTU.mo46708g(c28575a) || this.oOP == null || this.oOO == null || this.oON == null || this.oOP.getBackground() == null || this.oOO.getBackground() == null || this.oON.getBackground() == null || this.oOQ == null)) {
            if (c28575a.bUu()) {
                int i = c28575a.field_songLyricColor;
                this.oOP.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.oOO.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.oON.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.oOQ.setColor(i);
                AppMethodBeat.m2505o(105120);
                return;
            }
            this.oOP.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.oOO.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.oON.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.oOQ.setColor(-1);
        }
        AppMethodBeat.m2505o(105120);
    }

    public void onClickSend(View view) {
        AppMethodBeat.m2504i(105115);
        final C9058e bTQ = C39435k.bUf().bTQ();
        C4990ab.m7417i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", Integer.valueOf(bTQ.fJS), bTQ.fKc);
        if (bTQ.fJS == 11) {
            C9357gk c9357gk = new C9357gk();
            C4879a.xxA.mo10055m(c9357gk);
            final String str = c9357gk.cBa.appId;
            String str2 = c9357gk.cBa.cwz;
            final String str3 = c9357gk.cBa.cBb;
            final int i = c9357gk.cBa.cBc;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            C4990ab.m7417i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", str, str2, Integer.valueOf(i), str3);
            str2 = getString(C25738R.string.c9v, new Object[]{str2});
            if (TextUtils.isEmpty(bTQ.fKc)) {
                String[] strArr = new String[]{str2};
                new ArrayList().add(Integer.valueOf(0));
                C30379h.m48422a((Context) this, "", strArr, "", new C30391c() {
                    /* renamed from: iE */
                    public final void mo7700iE(int i) {
                        AppMethodBeat.m2504i(105101);
                        switch (i) {
                            case 0:
                                C39444d.m67382H(str, str3, i);
                                break;
                        }
                        AppMethodBeat.m2505o(105101);
                    }
                });
                AppMethodBeat.m2505o(105115);
                return;
            }
            ArrayList arrayList = new ArrayList();
            String[] strArr2 = new String[]{getString(C25738R.string.d44), getString(C25738R.string.d45), getString(C25738R.string.akj), str2};
            arrayList.add(Integer.valueOf(0));
            arrayList.add(Integer.valueOf(1));
            arrayList.add(Integer.valueOf(2));
            arrayList.add(Integer.valueOf(3));
            C30379h.m48422a((Context) this, "", strArr2, "", new C30391c() {
                /* renamed from: iE */
                public final void mo7700iE(int i) {
                    AppMethodBeat.m2504i(105100);
                    switch (i) {
                        case 0:
                            C39444d.m67384S(MusicMainUI.this);
                            C3541d.m5834zO(MusicMainUI.this.scene);
                            C3541d.m5836zQ(2);
                            AppMethodBeat.m2505o(105100);
                            return;
                        case 1:
                            C39444d.m67387b(bTQ, MusicMainUI.this);
                            C3541d.m5835zP(MusicMainUI.this.scene);
                            C3541d.m5836zQ(1);
                            AppMethodBeat.m2505o(105100);
                            return;
                        case 2:
                            C39444d.m67385a(bTQ, MusicMainUI.this);
                            C3541d.m5836zQ(3);
                            AppMethodBeat.m2505o(105100);
                            return;
                        case 3:
                            C39444d.m67382H(str, str3, i);
                            break;
                    }
                    AppMethodBeat.m2505o(105100);
                }
            });
            AppMethodBeat.m2505o(105115);
            return;
        }
        if (!TextUtils.isEmpty(bTQ.fKc)) {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr3 = new String[]{getString(C25738R.string.d44), getString(C25738R.string.d45), getString(C25738R.string.akj), getString(C25738R.string.bnj)};
            arrayList2.add(Integer.valueOf(0));
            arrayList2.add(Integer.valueOf(1));
            arrayList2.add(Integer.valueOf(2));
            arrayList2.add(Integer.valueOf(3));
            C30379h.m48422a((Context) this, "", strArr3, "", new C30391c() {
                /* renamed from: iE */
                public final void mo7700iE(int i) {
                    AppMethodBeat.m2504i(105102);
                    switch (i) {
                        case 0:
                            C39444d.m67384S(MusicMainUI.this);
                            C3541d.m5834zO(MusicMainUI.this.scene);
                            C3541d.m5836zQ(2);
                            AppMethodBeat.m2505o(105102);
                            return;
                        case 1:
                            C39444d.m67387b(bTQ, MusicMainUI.this);
                            C3541d.m5835zP(MusicMainUI.this.scene);
                            C3541d.m5836zQ(1);
                            AppMethodBeat.m2505o(105102);
                            return;
                        case 2:
                            C39444d.m67385a(bTQ, MusicMainUI.this);
                            C3541d.m5836zQ(3);
                            AppMethodBeat.m2505o(105102);
                            return;
                        case 3:
                            C9058e c9058e = bTQ;
                            Context context = MusicMainUI.this;
                            C7060h.pYm.mo8374X(10910, "4");
                            if (c9058e != null) {
                                String str;
                                String str2 = c9058e.fKc;
                                int indexOf = str2 == null ? -1 : str2.indexOf("#p=");
                                if (indexOf < 0) {
                                    str = null;
                                } else {
                                    str = str2.substring(indexOf + 3);
                                }
                                if (str == null) {
                                    C4990ab.m7413e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", str2);
                                    str = "androidqqmusic://";
                                } else {
                                    C4990ab.m7417i("MicroMsg.Music.MusicUtil", "get qq music data %s", str);
                                    str = String.format("androidqqmusic://from=webPlayer&data=%s", new Object[]{str});
                                }
                                Uri parse = Uri.parse(str);
                                if (parse == null) {
                                    C4990ab.m7421w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", str);
                                } else {
                                    C37494a.aic();
                                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                                    intent.addFlags(268435456);
                                    if (C5046bo.m7572k(context, intent)) {
                                        context.startActivity(intent);
                                    } else {
                                        intent = new Intent();
                                        intent.putExtra("rawUrl", str2);
                                        C39441b.gkE.mo38924i(intent, context);
                                    }
                                }
                            }
                            C3541d.m5836zQ(4);
                            break;
                    }
                    AppMethodBeat.m2505o(105102);
                }
            });
        }
        AppMethodBeat.m2505o(105115);
    }
}
