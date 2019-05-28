package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.e.b;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

@a(3)
public class CardGiftVideoUI extends MMActivity implements com.tencent.mm.plugin.card.d.a.a, e.a {
    private j contextMenuHelper;
    int duration = 0;
    private boolean eif;
    private Bundle jWy;
    private boolean jYD = false;
    private com.tencent.mm.ui.tools.e jYE;
    private CardGiftInfo kkk;
    private ImageView kkl;
    private ProgressBar kko;
    private ak kkp = new ak(Looper.getMainLooper());
    private int kkq = 0;
    private int kkr = 0;
    private int kks = 0;
    private int kkt = 0;
    private RelativeLayout klp;
    private e klq;
    private RelativeLayout klr;
    private ImageView kls;
    TextView klt;
    private MMPinProgressBtn klu;
    private TextView klv;
    private ap klw = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(88458);
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
            AppMethodBeat.o(88458);
            return true;
        }
    }, true);
    private String videoPath;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardGiftVideoUI() {
        AppMethodBeat.i(88461);
        AppMethodBeat.o(88461);
    }

    static /* synthetic */ void b(CardGiftVideoUI cardGiftVideoUI, String str) {
        AppMethodBeat.i(88477);
        cardGiftVideoUI.GT(str);
        AppMethodBeat.o(88477);
    }

    static /* synthetic */ void i(CardGiftVideoUI cardGiftVideoUI) {
        AppMethodBeat.i(88478);
        cardGiftVideoUI.bdd();
        AppMethodBeat.o(88478);
    }

    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(88462);
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.jWy = bundle;
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        if (com.tencent.mm.booter.a.Ib() != null) {
            com.tencent.mm.booter.a.Ib().Id();
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
        ab.d(str2, str3, objArr);
        ab.d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", this.videoPath, Boolean.valueOf(this.eif));
        initView();
        com.tencent.mm.plugin.card.d.a.a(this);
        bdd();
        if (this.kkk == null) {
            ab.e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
            AppMethodBeat.o(88462);
        } else if (bo.isNullOrNil(this.kkk.kco)) {
            ab.e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
            AppMethodBeat.o(88462);
        } else {
            com.tencent.mm.plugin.card.d.a.g(this.kkk.kcp, this.kkk.kcs, this.kkk.kcB, 2);
            com.tencent.mm.plugin.card.d.a.g(this.kkk.kco, this.kkk.kcr, this.kkk.kcA, 1);
            AppMethodBeat.o(88462);
        }
    }

    private void GT(String str) {
        AppMethodBeat.i(88463);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.CardGiftVideoUI", "the videoPath is null, fail~!!!");
            setResult(0);
            finish();
            AppMethodBeat.o(88463);
        } else if (com.tencent.mm.vfs.e.ct(str)) {
            this.klq.setVideoPath(str);
            AppMethodBeat.o(88463);
        } else {
            ab.e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", str);
            setResult(0);
            finish();
            AppMethodBeat.o(88463);
        }
    }

    private void bdd() {
        AppMethodBeat.i(88464);
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new j(this.mController.ylL);
        }
        if (bo.isNullOrNil(this.videoPath)) {
            ab.e("MicroMsg.CardGiftVideoUI", "videoPath is null");
            AppMethodBeat.o(88464);
            return;
        }
        this.contextMenuHelper.a((VideoTextureView) this.klq, new OnCreateContextMenuListener() {
            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(88448);
                contextMenu.add(0, 0, 0, CardGiftVideoUI.this.getString(R.string.afp));
                AppMethodBeat.o(88448);
            }
        }, new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(88452);
                switch (menuItem.getItemId()) {
                    case 0:
                        String uu = u.uu(CardGiftVideoUI.this.videoPath);
                        if (!bo.isNullOrNil(uu)) {
                            Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(R.string.f1d, new Object[]{uu}), 1).show();
                            n.a(uu, CardGiftVideoUI.this);
                            break;
                        }
                        Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(R.string.f1c), 1).show();
                        AppMethodBeat.o(88452);
                        return;
                }
                AppMethodBeat.o(88452);
            }
        });
        AppMethodBeat.o(88464);
    }

    public final void initView() {
        AppMethodBeat.i(88465);
        this.klp = (RelativeLayout) findViewById(R.id.aew);
        this.klr = (RelativeLayout) findViewById(R.id.aey);
        this.kls = (ImageView) findViewById(R.id.aex);
        this.klt = (TextView) findViewById(R.id.aez);
        this.klu = (MMPinProgressBtn) findViewById(R.id.af0);
        this.kko = (ProgressBar) findViewById(R.id.a9d);
        this.klv = (TextView) findViewById(R.id.af2);
        this.klq = new VideoTextureView(this);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.klq.setMute(this.eif);
        this.klq.setVideoCallback(this);
        this.klr.addView((View) this.klq, layoutParams);
        this.kkl = (ImageView) findViewById(R.id.adg);
        this.kkl.setLayerType(2, null);
        this.klp.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(88453);
                CardGiftVideoUI.this.bcW();
                AppMethodBeat.o(88453);
                return true;
            }
        });
        ((View) this.klq).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(88454);
                CardGiftVideoUI.this.bcW();
                AppMethodBeat.o(88454);
            }
        });
        this.jYE = new com.tencent.mm.ui.tools.e(this);
        AppMethodBeat.o(88465);
    }

    public void onStart() {
        AppMethodBeat.i(88466);
        Bundle bundle = this.jWy;
        if (!this.jYD) {
            this.jYD = true;
            if (VERSION.SDK_INT < 12) {
                ab.e("MicroMsg.CardGiftVideoUI", "version is %d, no animation", Integer.valueOf(VERSION.SDK_INT));
            } else {
                this.kkq = getIntent().getIntExtra("img_top", 0);
                this.kkr = getIntent().getIntExtra("img_left", 0);
                this.kks = getIntent().getIntExtra("img_width", 0);
                this.kkt = getIntent().getIntExtra("img_height", 0);
                this.jYE.L(this.kkr, this.kkq, this.kks, this.kkt);
                if (bundle == null) {
                    this.klp.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                        public final boolean onPreDraw() {
                            AppMethodBeat.i(88455);
                            CardGiftVideoUI.this.klp.getViewTreeObserver().removeOnPreDrawListener(this);
                            CardGiftVideoUI.this.jYE.a(CardGiftVideoUI.this.klp, CardGiftVideoUI.this.kkl, null);
                            AppMethodBeat.o(88455);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
        AppMethodBeat.o(88466);
    }

    public void onResume() {
        AppMethodBeat.i(88467);
        if (!bo.isNullOrNil(this.videoPath)) {
            GT(this.videoPath);
        }
        super.onResume();
        AppMethodBeat.o(88467);
    }

    public void onPause() {
        AppMethodBeat.i(88468);
        this.klq.pause();
        super.onPause();
        AppMethodBeat.o(88468);
    }

    public void onDestroy() {
        AppMethodBeat.i(88469);
        this.klq.stop();
        this.klw.stopTimer();
        com.tencent.mm.plugin.card.d.a.b(this);
        super.onDestroy();
        AppMethodBeat.o(88469);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(88470);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ab.d("MicroMsg.CardGiftVideoUI", "dispatchKeyEvent");
            bcW();
            AppMethodBeat.o(88470);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(88470);
        return dispatchKeyEvent;
    }

    public final void bcW() {
        AppMethodBeat.i(88471);
        this.jYE.L(this.kkr, this.kkq, this.kks, this.kkt);
        this.jYE.a(this.klp, this.kkl, new b() {
            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                AppMethodBeat.i(88457);
                new ak().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(88456);
                        CardGiftVideoUI.this.finish();
                        CardGiftVideoUI.this.overridePendingTransition(0, 0);
                        AppMethodBeat.o(88456);
                    }
                });
                AppMethodBeat.o(88457);
            }
        }, null);
        AppMethodBeat.o(88471);
    }

    public final int getLayoutId() {
        return R.layout.is;
    }

    public final void onError(int i, int i2) {
        AppMethodBeat.i(88472);
        setResult(0);
        this.klq.stop();
        ab.e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(88472);
    }

    public final void pL() {
        AppMethodBeat.i(88473);
        setResult(-1);
        this.kkp.post(new Runnable() {
            final /* synthetic */ boolean klz = true;

            public final void run() {
                AppMethodBeat.i(88459);
                ab.i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", Integer.valueOf(CardGiftVideoUI.this.hashCode()), Boolean.valueOf(this.klz));
                if (this.klz) {
                    ((View) CardGiftVideoUI.this.klq).setVisibility(0);
                    CardGiftVideoUI.this.kls.setVisibility(8);
                    AppMethodBeat.o(88459);
                    return;
                }
                ((View) CardGiftVideoUI.this.klq).setVisibility(8);
                CardGiftVideoUI.this.kls.setVisibility(0);
                AppMethodBeat.o(88459);
            }
        });
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(88460);
                ab.d("MicroMsg.CardGiftVideoUI", "hide loading.");
                if (!(CardGiftVideoUI.this.kko == null || CardGiftVideoUI.this.kko.getVisibility() == 8)) {
                    CardGiftVideoUI.this.kko.setVisibility(8);
                }
                if (!(CardGiftVideoUI.this.klu == null || CardGiftVideoUI.this.klu.getVisibility() == 8)) {
                    CardGiftVideoUI.this.klu.setVisibility(8);
                }
                AppMethodBeat.o(88460);
            }
        });
        this.klq.start();
        this.duration = this.klq.getDuration() / 1000;
        this.klw.ae(500, 500);
        ab.i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", Integer.valueOf(this.duration));
        AppMethodBeat.o(88473);
    }

    public final void EA() {
        AppMethodBeat.i(88474);
        ab.i("MicroMsg.CardGiftVideoUI", "%d on completion", Integer.valueOf(hashCode()));
        this.klq.B(0.0d);
        AppMethodBeat.o(88474);
    }

    public final int dG(int i, int i2) {
        return 0;
    }

    public final void dH(int i, int i2) {
    }

    public final void bN(String str, final int i) {
        AppMethodBeat.i(88475);
        if (str.equals(this.kkk.kco)) {
            this.kkp.post(new Runnable() {
                final /* synthetic */ int fFn = 100;

                public final void run() {
                    AppMethodBeat.i(88449);
                    if (CardGiftVideoUI.this.klu != null) {
                        if (this.fFn == 0) {
                            CardGiftVideoUI.this.klu.setVisibility(8);
                            AppMethodBeat.o(88449);
                            return;
                        }
                        if (CardGiftVideoUI.this.klu.getVisibility() != 0) {
                            CardGiftVideoUI.this.klu.setVisibility(0);
                        }
                        ab.i("MicroMsg.CardGiftVideoUI", "update progress %d %d", Integer.valueOf(i), Integer.valueOf(this.fFn));
                        if (CardGiftVideoUI.this.klu.getMax() != this.fFn && this.fFn > 0) {
                            CardGiftVideoUI.this.klu.setMax(this.fFn);
                        }
                        CardGiftVideoUI.this.klu.setProgress(i);
                    }
                    AppMethodBeat.o(88449);
                }
            });
        }
        AppMethodBeat.o(88475);
    }

    public final void GS(String str) {
    }

    public final void dr(String str, final String str2) {
        AppMethodBeat.i(88476);
        if (str.equals(this.kkk.kco)) {
            this.kkp.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(88450);
                    CardGiftVideoUI.this.kls.setVisibility(8);
                    CardGiftVideoUI.this.videoPath = str2;
                    CardGiftVideoUI.b(CardGiftVideoUI.this, CardGiftVideoUI.this.videoPath);
                    CardGiftVideoUI.i(CardGiftVideoUI.this);
                    AppMethodBeat.o(88450);
                }
            });
            AppMethodBeat.o(88476);
        } else if (str.equals(this.kkk.kcp)) {
            this.kkp.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(88451);
                    if (bo.isNullOrNil(CardGiftVideoUI.this.videoPath)) {
                        CardGiftVideoUI.this.kls.setVisibility(0);
                        c.a aVar = new c.a();
                        aVar.ePK = com.tencent.mm.compatible.util.e.eSn;
                        o.ahq();
                        aVar.ePY = null;
                        aVar.ePJ = m.Gz(str2);
                        aVar.fHe = 1;
                        aVar.ePH = true;
                        aVar.ePF = true;
                        o.ahp().a(str2, CardGiftVideoUI.this.kls, aVar.ahG());
                    }
                    AppMethodBeat.o(88451);
                }
            });
            AppMethodBeat.o(88476);
        } else {
            ab.i("MicroMsg.CardGiftVideoUI", "fieldId:%s is unsuitable", str);
            AppMethodBeat.o(88476);
        }
    }
}
