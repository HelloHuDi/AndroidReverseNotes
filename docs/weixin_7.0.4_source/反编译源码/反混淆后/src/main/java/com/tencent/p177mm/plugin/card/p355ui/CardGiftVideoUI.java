package com.tencent.p177mm.plugin.card.p355ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.C1321a;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.tools.C30759e;
import com.tencent.p177mm.p612ui.tools.C30759e.C24051b;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.plugin.card.model.C33770m;
import com.tencent.p177mm.plugin.card.model.CardGiftInfo;
import com.tencent.p177mm.plugin.card.p931d.C20130a;
import com.tencent.p177mm.plugin.card.p931d.C20130a.C20132a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoTextureView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5730e;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.card.ui.CardGiftVideoUI */
public class CardGiftVideoUI extends MMActivity implements C20132a, C14981a {
    private C46696j contextMenuHelper;
    int duration = 0;
    private boolean eif;
    private Bundle jWy;
    private boolean jYD = false;
    private C30759e jYE;
    private CardGiftInfo kkk;
    private ImageView kkl;
    private ProgressBar kko;
    private C7306ak kkp = new C7306ak(Looper.getMainLooper());
    private int kkq = 0;
    private int kkr = 0;
    private int kks = 0;
    private int kkt = 0;
    private RelativeLayout klp;
    private C14979e klq;
    private RelativeLayout klr;
    private ImageView kls;
    TextView klt;
    private MMPinProgressBtn klu;
    private TextView klv;
    private C7564ap klw = new C7564ap(new C2760210(), true);
    private String videoPath;

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftVideoUI$6 */
    class C113136 implements OnTouchListener {
        C113136() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(88453);
            CardGiftVideoUI.this.bcW();
            AppMethodBeat.m2505o(88453);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftVideoUI$8 */
    class C201648 implements OnPreDrawListener {
        C201648() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(88455);
            CardGiftVideoUI.this.klp.getViewTreeObserver().removeOnPreDrawListener(this);
            CardGiftVideoUI.this.jYE.mo49166a(CardGiftVideoUI.this.klp, CardGiftVideoUI.this.kkl, null);
            AppMethodBeat.m2505o(88455);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftVideoUI$5 */
    class C276005 implements C5279d {
        C276005() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(88452);
            switch (menuItem.getItemId()) {
                case 0:
                    String uu = C26494u.m42269uu(CardGiftVideoUI.this.videoPath);
                    if (!C5046bo.isNullOrNil(uu)) {
                        Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(C25738R.string.f1d, new Object[]{uu}), 1).show();
                        C14987n.m23300a(uu, CardGiftVideoUI.this);
                        break;
                    }
                    Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(C25738R.string.f1c), 1).show();
                    AppMethodBeat.m2505o(88452);
                    return;
            }
            AppMethodBeat.m2505o(88452);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftVideoUI$7 */
    class C276017 implements OnClickListener {
        C276017() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88454);
            CardGiftVideoUI.this.bcW();
            AppMethodBeat.m2505o(88454);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftVideoUI$10 */
    class C2760210 implements C5015a {
        C2760210() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(88458);
            if (CardGiftVideoUI.this.klq.isPlaying()) {
                CardGiftVideoUI cardGiftVideoUI = CardGiftVideoUI.this;
                int currentPosition = CardGiftVideoUI.this.klq.getCurrentPosition() / 1000;
                if (cardGiftVideoUI.klt != null && cardGiftVideoUI.duration > 0) {
                    currentPosition = cardGiftVideoUI.duration - currentPosition;
                    if (currentPosition < 0) {
                        currentPosition = 0;
                    }
                    cardGiftVideoUI.klt.setText(currentPosition + "\"");
                }
            }
            AppMethodBeat.m2505o(88458);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftVideoUI$12 */
    class C2760312 implements Runnable {
        C2760312() {
        }

        public final void run() {
            AppMethodBeat.m2504i(88460);
            C4990ab.m7410d("MicroMsg.CardGiftVideoUI", "hide loading.");
            if (!(CardGiftVideoUI.this.kko == null || CardGiftVideoUI.this.kko.getVisibility() == 8)) {
                CardGiftVideoUI.this.kko.setVisibility(8);
            }
            if (!(CardGiftVideoUI.this.klu == null || CardGiftVideoUI.this.klu.getVisibility() == 8)) {
                CardGiftVideoUI.this.klu.setVisibility(8);
            }
            AppMethodBeat.m2505o(88460);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftVideoUI$1 */
    class C276041 implements OnCreateContextMenuListener {
        C276041() {
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(88448);
            contextMenu.add(0, 0, 0, CardGiftVideoUI.this.getString(C25738R.string.afp));
            AppMethodBeat.m2505o(88448);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftVideoUI$9 */
    class C276079 implements C24051b {

        /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftVideoUI$9$1 */
        class C113141 implements Runnable {
            C113141() {
            }

            public final void run() {
                AppMethodBeat.m2504i(88456);
                CardGiftVideoUI.this.finish();
                CardGiftVideoUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.m2505o(88456);
            }
        }

        C276079() {
        }

        public final void onAnimationStart() {
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(88457);
            new C7306ak().post(new C113141());
            AppMethodBeat.m2505o(88457);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftVideoUI$11 */
    class C2760811 implements Runnable {
        final /* synthetic */ boolean klz = true;

        C2760811() {
        }

        public final void run() {
            AppMethodBeat.m2504i(88459);
            C4990ab.m7417i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", Integer.valueOf(CardGiftVideoUI.this.hashCode()), Boolean.valueOf(this.klz));
            if (this.klz) {
                ((View) CardGiftVideoUI.this.klq).setVisibility(0);
                CardGiftVideoUI.this.kls.setVisibility(8);
                AppMethodBeat.m2505o(88459);
                return;
            }
            ((View) CardGiftVideoUI.this.klq).setVisibility(8);
            CardGiftVideoUI.this.kls.setVisibility(0);
            AppMethodBeat.m2505o(88459);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardGiftVideoUI() {
        AppMethodBeat.m2504i(88461);
        AppMethodBeat.m2505o(88461);
    }

    /* renamed from: b */
    static /* synthetic */ void m43859b(CardGiftVideoUI cardGiftVideoUI, String str) {
        AppMethodBeat.m2504i(88477);
        cardGiftVideoUI.m43855GT(str);
        AppMethodBeat.m2505o(88477);
    }

    /* renamed from: i */
    static /* synthetic */ void m43866i(CardGiftVideoUI cardGiftVideoUI) {
        AppMethodBeat.m2504i(88478);
        cardGiftVideoUI.bdd();
        AppMethodBeat.m2505o(88478);
    }

    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.m2504i(88462);
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.jWy = bundle;
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        if (C1321a.m2829Ib() != null) {
            C1321a.m2829Ib().mo4649Id();
        }
        this.kkk = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        this.videoPath = getIntent().getStringExtra("key_video_path");
        this.eif = getIntent().getBooleanExtra("key_is_mute", false);
        String str2 = "MicroMsg.CardGiftVideoUI";
        String str3 = "cardGiftInfo %s";
        Object[] objArr = new Object[1];
        if (this.kkk == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = this.kkk.toString();
        }
        objArr[0] = str;
        C4990ab.m7411d(str2, str3, objArr);
        C4990ab.m7411d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", this.videoPath, Boolean.valueOf(this.eif));
        initView();
        C20130a.m31138a(this);
        bdd();
        if (this.kkk == null) {
            C4990ab.m7412e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
            AppMethodBeat.m2505o(88462);
        } else if (C5046bo.isNullOrNil(this.kkk.kco)) {
            C4990ab.m7412e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
            AppMethodBeat.m2505o(88462);
        } else {
            C20130a.m31140g(this.kkk.kcp, this.kkk.kcs, this.kkk.kcB, 2);
            C20130a.m31140g(this.kkk.kco, this.kkk.kcr, this.kkk.kcA, 1);
            AppMethodBeat.m2505o(88462);
        }
    }

    /* renamed from: GT */
    private void m43855GT(String str) {
        AppMethodBeat.m2504i(88463);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.CardGiftVideoUI", "the videoPath is null, fail~!!!");
            setResult(0);
            finish();
            AppMethodBeat.m2505o(88463);
        } else if (C5730e.m8628ct(str)) {
            this.klq.setVideoPath(str);
            AppMethodBeat.m2505o(88463);
        } else {
            C4990ab.m7413e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", str);
            setResult(0);
            finish();
            AppMethodBeat.m2505o(88463);
        }
    }

    private void bdd() {
        AppMethodBeat.m2504i(88464);
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new C46696j(this.mController.ylL);
        }
        if (C5046bo.isNullOrNil(this.videoPath)) {
            C4990ab.m7412e("MicroMsg.CardGiftVideoUI", "videoPath is null");
            AppMethodBeat.m2505o(88464);
            return;
        }
        this.contextMenuHelper.mo75005a((VideoTextureView) this.klq, new C276041(), new C276005());
        AppMethodBeat.m2505o(88464);
    }

    public final void initView() {
        AppMethodBeat.m2504i(88465);
        this.klp = (RelativeLayout) findViewById(2131822132);
        this.klr = (RelativeLayout) findViewById(2131822134);
        this.kls = (ImageView) findViewById(2131822133);
        this.klt = (TextView) findViewById(2131822135);
        this.klu = (MMPinProgressBtn) findViewById(2131822136);
        this.kko = (ProgressBar) findViewById(2131821891);
        this.klv = (TextView) findViewById(2131822138);
        this.klq = new VideoTextureView(this);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.klq.setMute(this.eif);
        this.klq.setVideoCallback(this);
        this.klr.addView((View) this.klq, layoutParams);
        this.kkl = (ImageView) findViewById(2131822079);
        this.kkl.setLayerType(2, null);
        this.klp.setOnTouchListener(new C113136());
        ((View) this.klq).setOnClickListener(new C276017());
        this.jYE = new C30759e(this);
        AppMethodBeat.m2505o(88465);
    }

    public void onStart() {
        AppMethodBeat.m2504i(88466);
        Bundle bundle = this.jWy;
        if (!this.jYD) {
            this.jYD = true;
            if (VERSION.SDK_INT < 12) {
                C4990ab.m7413e("MicroMsg.CardGiftVideoUI", "version is %d, no animation", Integer.valueOf(VERSION.SDK_INT));
            } else {
                this.kkq = getIntent().getIntExtra("img_top", 0);
                this.kkr = getIntent().getIntExtra("img_left", 0);
                this.kks = getIntent().getIntExtra("img_width", 0);
                this.kkt = getIntent().getIntExtra("img_height", 0);
                this.jYE.mo49164L(this.kkr, this.kkq, this.kks, this.kkt);
                if (bundle == null) {
                    this.klp.getViewTreeObserver().addOnPreDrawListener(new C201648());
                }
            }
        }
        super.onStart();
        AppMethodBeat.m2505o(88466);
    }

    public void onResume() {
        AppMethodBeat.m2504i(88467);
        if (!C5046bo.isNullOrNil(this.videoPath)) {
            m43855GT(this.videoPath);
        }
        super.onResume();
        AppMethodBeat.m2505o(88467);
    }

    public void onPause() {
        AppMethodBeat.m2504i(88468);
        this.klq.pause();
        super.onPause();
        AppMethodBeat.m2505o(88468);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88469);
        this.klq.stop();
        this.klw.stopTimer();
        C20130a.m31139b(this);
        super.onDestroy();
        AppMethodBeat.m2505o(88469);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(88470);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            C4990ab.m7410d("MicroMsg.CardGiftVideoUI", "dispatchKeyEvent");
            bcW();
            AppMethodBeat.m2505o(88470);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(88470);
        return dispatchKeyEvent;
    }

    public final void bcW() {
        AppMethodBeat.m2504i(88471);
        this.jYE.mo49164L(this.kkr, this.kkq, this.kks, this.kkt);
        this.jYE.mo49167a(this.klp, this.kkl, new C276079(), null);
        AppMethodBeat.m2505o(88471);
    }

    public final int getLayoutId() {
        return 2130968927;
    }

    public final void onError(int i, int i2) {
        AppMethodBeat.m2504i(88472);
        setResult(0);
        this.klq.stop();
        C4990ab.m7413e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(88472);
    }

    /* renamed from: pL */
    public final void mo8557pL() {
        AppMethodBeat.m2504i(88473);
        setResult(-1);
        this.kkp.post(new C2760811());
        this.kkp.post(new C2760312());
        this.klq.start();
        this.duration = this.klq.getDuration() / 1000;
        this.klw.mo16770ae(500, 500);
        C4990ab.m7417i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", Integer.valueOf(this.duration));
        AppMethodBeat.m2505o(88473);
    }

    /* renamed from: EA */
    public final void mo8553EA() {
        AppMethodBeat.m2504i(88474);
        C4990ab.m7417i("MicroMsg.CardGiftVideoUI", "%d on completion", Integer.valueOf(hashCode()));
        this.klq.mo9052B(0.0d);
        AppMethodBeat.m2505o(88474);
    }

    /* renamed from: dG */
    public final int mo8554dG(int i, int i2) {
        return 0;
    }

    /* renamed from: dH */
    public final void mo8555dH(int i, int i2) {
    }

    /* renamed from: bN */
    public final void mo23013bN(String str, final int i) {
        AppMethodBeat.m2504i(88475);
        if (str.equals(this.kkk.kco)) {
            this.kkp.post(new Runnable() {
                final /* synthetic */ int fFn = 100;

                public final void run() {
                    AppMethodBeat.m2504i(88449);
                    if (CardGiftVideoUI.this.klu != null) {
                        if (this.fFn == 0) {
                            CardGiftVideoUI.this.klu.setVisibility(8);
                            AppMethodBeat.m2505o(88449);
                            return;
                        }
                        if (CardGiftVideoUI.this.klu.getVisibility() != 0) {
                            CardGiftVideoUI.this.klu.setVisibility(0);
                        }
                        C4990ab.m7417i("MicroMsg.CardGiftVideoUI", "update progress %d %d", Integer.valueOf(i), Integer.valueOf(this.fFn));
                        if (CardGiftVideoUI.this.klu.getMax() != this.fFn && this.fFn > 0) {
                            CardGiftVideoUI.this.klu.setMax(this.fFn);
                        }
                        CardGiftVideoUI.this.klu.setProgress(i);
                    }
                    AppMethodBeat.m2505o(88449);
                }
            });
        }
        AppMethodBeat.m2505o(88475);
    }

    /* renamed from: GS */
    public final void mo23012GS(String str) {
    }

    /* renamed from: dr */
    public final void mo23014dr(String str, final String str2) {
        AppMethodBeat.m2504i(88476);
        if (str.equals(this.kkk.kco)) {
            this.kkp.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(88450);
                    CardGiftVideoUI.this.kls.setVisibility(8);
                    CardGiftVideoUI.this.videoPath = str2;
                    CardGiftVideoUI.m43859b(CardGiftVideoUI.this, CardGiftVideoUI.this.videoPath);
                    CardGiftVideoUI.m43866i(CardGiftVideoUI.this);
                    AppMethodBeat.m2505o(88450);
                }
            });
            AppMethodBeat.m2505o(88476);
        } else if (str.equals(this.kkk.kcp)) {
            this.kkp.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(88451);
                    if (C5046bo.isNullOrNil(CardGiftVideoUI.this.videoPath)) {
                        CardGiftVideoUI.this.kls.setVisibility(0);
                        C17927a c17927a = new C17927a();
                        c17927a.ePK = C6457e.eSn;
                        C32291o.ahq();
                        c17927a.ePY = null;
                        c17927a.ePJ = C33770m.m55183Gz(str2);
                        c17927a.fHe = 1;
                        c17927a.ePH = true;
                        c17927a.ePF = true;
                        C32291o.ahp().mo43766a(str2, CardGiftVideoUI.this.kls, c17927a.ahG());
                    }
                    AppMethodBeat.m2505o(88451);
                }
            });
            AppMethodBeat.m2505o(88476);
        } else {
            C4990ab.m7417i("MicroMsg.CardGiftVideoUI", "fieldId:%s is unsuitable", str);
            AppMethodBeat.m2505o(88476);
        }
    }
}
