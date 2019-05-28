package com.tencent.mm.ui.chatting.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.f;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.g.b.a.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMNewPhotoEditUI;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.tools.e;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

@i
@com.tencent.mm.ui.base.a(3)
public class ImageGalleryUI extends MMActivity implements OnClickListener, com.tencent.mm.plugin.scanner.c.a.a<String, Integer>, com.tencent.mm.sdk.platformtools.ap.a {
    protected String chatroomName;
    private View contentView;
    public long cvx;
    private int icC;
    private int icD;
    public long jMj;
    Bundle jWy;
    private boolean jYD = false;
    e jYE;
    int kkq = 0;
    int kkr = 0;
    int kks = 0;
    int kkt = 0;
    private d lcJ = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(32205);
            ab.i("MicroMsg.ImageGalleryUI", "curTransState %d", Integer.valueOf(ImageGalleryUI.this.yWi));
            bi dFO;
            s ut;
            switch (menuItem.getItemId()) {
                case 0:
                    dFO = ImageGalleryUI.this.yTG.dFO();
                    if (dFO == null || !dFO.bws()) {
                        ImageGalleryUI.this.yTG.OL(ImageGalleryUI.this.mQT.getCurrentItem());
                        AppMethodBeat.o(32205);
                        return;
                    }
                    ut = u.ut(dFO.field_imgPath);
                    if (ut.status == 199 || ut.status == 199) {
                        ImageGalleryUI.this.yTG.OL(ImageGalleryUI.this.mQT.getCurrentItem());
                        AppMethodBeat.o(32205);
                        return;
                    }
                    ImageGalleryUI.this.yWj = u.e(dFO.field_msgId, 1);
                    ImageGalleryUI.this.yTG.OQ(ImageGalleryUI.this.mQT.getCurrentItem());
                    AppMethodBeat.o(32205);
                    return;
                case 1:
                    dFO = ImageGalleryUI.this.yTG.dFO();
                    if (dFO == null || !dFO.bws()) {
                        List arrayList = new ArrayList();
                        arrayList.add(ImageGalleryUI.this.yTG.dFO());
                        b.fRa.H((bi) arrayList.get(0));
                        c.f(ImageGalleryUI.this.mController.ylL, arrayList);
                        AppMethodBeat.o(32205);
                        return;
                    }
                    ut = u.ut(dFO.field_imgPath);
                    if (ut.status == 199 || ut.status == 199) {
                        List arrayList2 = new ArrayList();
                        arrayList2.add(ImageGalleryUI.this.yTG.dFO());
                        c.f(ImageGalleryUI.this.mController.ylL, arrayList2);
                        AppMethodBeat.o(32205);
                        return;
                    }
                    ImageGalleryUI.this.yWj = u.e(dFO.field_msgId, 2);
                    ImageGalleryUI.this.yTG.OQ(ImageGalleryUI.this.mQT.getCurrentItem());
                    AppMethodBeat.o(32205);
                    return;
                case 2:
                    if (com.tencent.mm.bp.d.afj("favorite")) {
                        ImageGalleryUI.this.yTG.ON(ImageGalleryUI.this.mQT.getCurrentItem());
                        AppMethodBeat.o(32205);
                        return;
                    }
                    break;
                case 3:
                    ab.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
                    cf cfVar = new cf();
                    cfVar.cvm.activity = ImageGalleryUI.this;
                    cfVar.cvm.ctB = ImageGalleryUI.this.riC;
                    cfVar.cvm.cvn = ImageGalleryUI.this.icC;
                    cfVar.cvm.cvo = ImageGalleryUI.this.icD;
                    cfVar.cvm.scene = 37;
                    cfVar.cvm.cvs = ImageGalleryUI.this.getIntent().getBundleExtra("_stat_obj");
                    ImageGalleryUI.a(ImageGalleryUI.this, cfVar);
                    ImageGalleryUI.b(ImageGalleryUI.this, cfVar);
                    com.tencent.mm.sdk.b.a.xxA.m(cfVar);
                    AppMethodBeat.o(32205);
                    return;
                case 4:
                    ImageGalleryUI.this.yTG.OM(ImageGalleryUI.this.mQT.getCurrentItem());
                    AppMethodBeat.o(32205);
                    return;
                case 5:
                    ImageGalleryUI.D(ImageGalleryUI.this);
                    AppMethodBeat.o(32205);
                    return;
                case 6:
                    if (ImageGalleryUI.this.yTG != null) {
                        if (c.c(ImageGalleryUI.this.yTG.dFO())) {
                            ImageGalleryUI.E(ImageGalleryUI.this);
                        }
                        AppMethodBeat.o(32205);
                        return;
                    }
                    break;
                case 7:
                    String F = ImageGalleryUI.F(ImageGalleryUI.this);
                    if ((ImageGalleryUI.this.yWi == 0 || ImageGalleryUI.this.yWi == 2) && !bo.isNullOrNil(F)) {
                        long j;
                        k kVar = new k();
                        if (ImageGalleryUI.this.yWi == 2) {
                            j = 1;
                        } else {
                            j = 0;
                        }
                        kVar.cVR = j;
                        kVar.cVS = 3;
                        kVar.ajK();
                        ImageGalleryUI.this.yWg = (int) ((((long) r.Yz().hashCode()) + System.currentTimeMillis()) & -1);
                        if (com.tencent.mm.plugin.scanner.e.cgy().cgD().Wf(ag.ck(F + com.tencent.mm.vfs.e.ata(F))) == null) {
                            ImageGalleryUI.H(ImageGalleryUI.this);
                            ab.i("MicroMsg.ImageGalleryUI", "try to translate img %s, sessionId %d", F, Integer.valueOf(ImageGalleryUI.this.yWg));
                            pu puVar = new pu();
                            puVar.cLZ.scene = 1;
                            puVar.cLZ.filePath = F;
                            puVar.cLZ.ctE = ImageGalleryUI.this.yWg;
                            com.tencent.mm.sdk.b.a.xxA.m(puVar);
                            break;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("original_file_path", F);
                        intent.putExtra("msg_id", ImageGalleryUI.this.yTG.Ou(ImageGalleryUI.this.yWs).field_msgId);
                        ImageGalleryUI.a(ImageGalleryUI.this, TranslationResultUI.class, intent);
                        ImageGalleryUI.this.finish();
                        ImageGalleryUI.this.overridePendingTransition(R.anim.s, R.anim.s);
                        AppMethodBeat.o(32205);
                        return;
                    }
            }
            AppMethodBeat.o(32205);
        }
    };
    private ak mHandler = new ak(Looper.getMainLooper());
    protected MMViewPager mQT;
    public boolean mgP = false;
    private c mip = new c<nr>() {
        {
            AppMethodBeat.i(32188);
            this.xxI = nr.class.getName().hashCode();
            AppMethodBeat.o(32188);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(32189);
            nr nrVar = (nr) bVar;
            if (ImageGalleryUI.this.riy == null || ImageGalleryUI.this.riz == null) {
                ab.e("MicroMsg.ImageGalleryUI", "not in recoging");
                AppMethodBeat.o(32189);
            } else if (nrVar == null || !(nrVar instanceof nr)) {
                ab.e("MicroMsg.ImageGalleryUI", "receive invalid callbak");
                AppMethodBeat.o(32189);
            } else if (nrVar == null || nrVar.cJX.filePath.equals(ImageGalleryUI.this.riz)) {
                ab.i("MicroMsg.ImageGalleryUI", "recog result: " + nrVar.cJX.result);
                if (!bo.isNullOrNil(nrVar.cJX.result)) {
                    ImageGalleryUI.this.riC = nrVar.cJX.result;
                    ImageGalleryUI.this.icC = nrVar.cJX.cvn;
                    ImageGalleryUI.this.icD = nrVar.cJX.cvo;
                    if (!(ImageGalleryUI.this.riC == null || ImageGalleryUI.this.riy == null)) {
                        ImageGalleryUI.this.riD = true;
                    }
                    ImageGalleryUI.this.ak(false, false);
                }
                ImageGalleryUI.this.riz = null;
                AppMethodBeat.o(32189);
            } else {
                ab.e("MicroMsg.ImageGalleryUI", "not same filepath");
                AppMethodBeat.o(32189);
            }
            return false;
        }
    };
    private ImageView mmX;
    private boolean osu;
    private ImageView qbx;
    private ValueAnimator qfZ;
    private n qgg = new com.tencent.mm.network.n.a() {
        public final void gl(int i) {
            AppMethodBeat.i(32219);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(32218);
                    if (!(g.Rg().acS() == 6 || g.Rg().acS() == 4 || ImageGalleryUI.this.yWi != 1)) {
                        h.b(ImageGalleryUI.this, ImageGalleryUI.this.getString(R.string.g5c), "", true);
                        ImageGalleryUI.g(ImageGalleryUI.this);
                    }
                    AppMethodBeat.o(32218);
                }
            });
            AppMethodBeat.o(32219);
        }
    };
    private String riC;
    private boolean riD = false;
    private c riJ = new c<kv>() {
        {
            AppMethodBeat.i(32210);
            this.xxI = kv.class.getName().hashCode();
            AppMethodBeat.o(32210);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(32211);
            kv kvVar = (kv) bVar;
            if (kvVar != null && (kvVar instanceof kv)) {
                ab.i("MicroMsg.ImageGalleryUI", "notify Event: %d", Integer.valueOf(kvVar.cGM.cGK));
                if (kvVar.cGM.activity == ImageGalleryUI.this && kvVar.cGM.ctB.equals(ImageGalleryUI.this.riC)) {
                    switch (kvVar.cGM.cGK) {
                        case 3:
                            ImageGalleryUI.this.finish();
                            break;
                    }
                }
                ab.e("MicroMsg.ImageGalleryUI", "not the same");
            } else {
                ab.e("MicroMsg.ImageGalleryUI", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            }
            AppMethodBeat.o(32211);
            return false;
        }
    };
    private com.tencent.mm.ui.widget.a.d riy;
    private String riz;
    private int rpA = 0;
    private int rpB = 0;
    int rpw;
    int rpx;
    int rpy = 0;
    private float rpz = 1.0f;
    private boolean suk = false;
    protected String talker;
    private HashSet<Long> yOW = new HashSet();
    private boolean yRs = false;
    protected boolean yRt = false;
    public c yTG;
    private final boolean yTR = false;
    private c.b yVI;
    private RelativeLayout yVJ;
    private RelativeLayout yVK;
    private boolean yVL;
    private ImageView yVM;
    private RelativeLayout yVN;
    private RelativeLayout yVO;
    private FrameLayout yVP;
    View yVQ;
    Button yVR;
    Button yVS;
    View yVT;
    private View yVU;
    protected VideoPlayerSeekBar yVV;
    int yVW = 0;
    int yVX = 0;
    boolean yVY;
    ArrayList<Integer> yVZ = new ArrayList();
    private boolean yWA = false;
    private boolean yWB = false;
    private boolean yWa;
    protected boolean yWb = false;
    protected boolean yWc = false;
    private boolean yWd;
    private int yWe;
    private com.tencent.mm.plugin.scanner.c.a<String, Integer> yWf;
    private volatile int yWg;
    private boolean yWh;
    private int yWi = 0;
    private String yWj = null;
    private ImageView yWk;
    private ImageView yWl;
    public a yWm;
    private View yWn;
    private CheckBox yWo;
    private View yWp;
    private boolean yWq = true;
    private c<pv> yWr = new c<pv>() {
        {
            AppMethodBeat.i(32206);
            this.xxI = pv.class.getName().hashCode();
            AppMethodBeat.o(32206);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(32207);
            pv pvVar = (pv) bVar;
            ab.i("MicroMsg.ImageGalleryUI", "scanTranslationResult %d, %s", Integer.valueOf(pvVar.cMa.ctE), Boolean.valueOf(pvVar.cMa.ctn));
            if (ImageGalleryUI.this.yWg == pvVar.cMa.ctE) {
                ImageGalleryUI.g(ImageGalleryUI.this);
                if (pvVar.cMa.ctn) {
                    if (com.tencent.mm.vfs.e.ct(pvVar.cMa.cMb)) {
                        String F = ImageGalleryUI.F(ImageGalleryUI.this);
                        Intent intent = new Intent();
                        intent.putExtra("original_file_path", F);
                        intent.putExtra("msg_id", ImageGalleryUI.this.yTG.Ou(ImageGalleryUI.this.yWs).field_msgId);
                        ImageGalleryUI.b(ImageGalleryUI.this, TranslationResultUI.class, intent);
                        ImageGalleryUI.this.finish();
                        ImageGalleryUI.this.overridePendingTransition(R.anim.s, R.anim.s);
                        AppMethodBeat.o(32207);
                        return true;
                    }
                    ab.w("MicroMsg.ImageGalleryUI", "trans result path %s not exist!", pvVar.cMa.cMb);
                }
                ImageGalleryUI.this.yWg = 0;
                h.a(ImageGalleryUI.this, ImageGalleryUI.this.getString(R.string.dyv), "", false, null);
            }
            AppMethodBeat.o(32207);
            return false;
        }
    };
    private int yWs = 0;
    private OnPageChangeListener yWt = new OnPageChangeListener() {
        private boolean yWG = false;

        public final void onPageScrolled(int i, float f, int i2) {
        }

        public final void onPageSelected(int i) {
            AppMethodBeat.i(32208);
            if (ImageGalleryUI.this.yTG == null) {
                AppMethodBeat.o(32208);
                return;
            }
            if (ImageGalleryUI.this.yWs != i) {
                if (ImageGalleryUI.this.yWi == 1) {
                    ImageGalleryUI.g(ImageGalleryUI.this);
                }
                ImageGalleryUI.this.yWi = 0;
                ImageGalleryUI.this.yWg = 0;
            }
            if (ImageGalleryUI.this.yTG.Fp(i) == null) {
                ab.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", Integer.valueOf(i));
            }
            ImageGalleryUI.u(ImageGalleryUI.this);
            ImageGalleryUI.this.yWs = i;
            if (ImageGalleryUI.this.yTG != null) {
                c j = ImageGalleryUI.this.yTG;
                j.yTO.Du();
                j.yTP.Du();
                bi Ou = ImageGalleryUI.this.yTG.Ou(i);
                if (c.c(Ou) || c.bq(Ou)) {
                    View a = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.yTG, ImageGalleryUI.this.mQT);
                    if (a != null && (a instanceof com.tencent.mm.ui.base.g)) {
                        if (a instanceof MultiTouchImageView) {
                            ((MultiTouchImageView) a).dzA();
                        } else if (a instanceof WxImageView) {
                            ((WxImageView) a).dzA();
                        }
                    }
                    ((com.tencent.mm.plugin.comm.a.b) g.K(com.tencent.mm.plugin.comm.a.b.class)).T(Ou);
                }
                if (Ou != null) {
                    ImageGalleryUI.this.nq(Ou.field_msgId);
                }
                if (ImageGalleryUI.this.yTG != null) {
                    com.tencent.mm.at.e f = ImageGalleryUI.this.yTG.f(Ou, false);
                    ImageGalleryUI.this.yTG;
                    if (c.b(Ou, f)) {
                        f = f.a(f);
                        int i2 = f.frO;
                        ab.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", Integer.valueOf(Math.max(1, (int) (i2 != 0 ? ((((long) f.offset) * 100) / ((long) i2)) - 1 : 0))), Long.valueOf(System.currentTimeMillis()));
                        ImageGalleryUI.this.Pe(r0);
                    } else if (Ou == null || Ou.bws() || !ImageGalleryUI.this.yTG.bs(Ou)) {
                        ImageGalleryUI.this.hG(true);
                    } else {
                        ImageGalleryUI.this.hG(false);
                    }
                } else {
                    ab.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
                }
                if (Ou == null) {
                    ab.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = ".concat(String.valueOf(i)));
                } else {
                    ImageGalleryUI.this.bF(Ou);
                    ImageGalleryUI.k(ImageGalleryUI.this);
                }
            }
            if (ImageGalleryUI.this.yTG != null) {
                ImageGalleryUI.this.yTG.onPageSelected(i);
            }
            AppMethodBeat.o(32208);
        }

        public final void onPageScrollStateChanged(int i) {
            AppMethodBeat.i(32209);
            ab.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", Integer.valueOf(i));
            if (i == 2) {
                this.yWG = true;
                ImageGalleryUI.J(ImageGalleryUI.this);
                ImageGalleryUI.K(ImageGalleryUI.this);
                ImageGalleryUI.L(ImageGalleryUI.this);
            }
            if (i == 0) {
                if (this.yWG) {
                    ImageGalleryUI.this.dGt();
                }
                this.yWG = false;
            }
            if (ImageGalleryUI.this.yTG != null) {
                c j = ImageGalleryUI.this.yTG;
                if (j.yTN != null) {
                    e eVar = j.yTN;
                    eVar.mScrollState = i;
                    if (eVar.yVa != null) {
                        eVar.yVa.onPageScrollStateChanged(i);
                    }
                }
            }
            AppMethodBeat.o(32209);
        }
    };
    boolean yWu = false;
    ap yWv = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(32212);
            if (ImageGalleryUI.this.yWu) {
                ImageGalleryUI.this.dGm();
            }
            AppMethodBeat.o(32212);
            return false;
        }
    }, false);
    private HashMap<Long, String> yWw = new HashMap();
    private boolean yWx = false;
    private boolean yWy = false;
    private ap yWz;

    public interface a {
        void l(Boolean bool);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final /* synthetic */ void y(Object obj, Object obj2) {
        AppMethodBeat.i(138628);
        String str = (String) obj;
        Integer num = (Integer) obj2;
        ab.i("MicroMsg.ImageGalleryUI", "local translate, img %s, result %d", dGe(), num);
        if (str.equals(dGe()) && num.intValue() != 0 && ((num.intValue() == 1 && !aa.dor().equals("zh_CN")) || (num.intValue() == 2 && !aa.dor().equals("en")))) {
            this.yWh = true;
            ak(false, false);
        }
        AppMethodBeat.o(138628);
    }

    public ImageGalleryUI() {
        AppMethodBeat.i(32227);
        AppMethodBeat.o(32227);
    }

    static /* synthetic */ void E(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(138636);
        imageGalleryUI.dGy();
        AppMethodBeat.o(138636);
    }

    static /* synthetic */ String F(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(138637);
        String dGe = imageGalleryUI.dGe();
        AppMethodBeat.o(138637);
        return dGe;
    }

    static /* synthetic */ void J(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(32309);
        imageGalleryUI.dGu();
        AppMethodBeat.o(32309);
    }

    static /* synthetic */ void K(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(32310);
        imageGalleryUI.dGp();
        AppMethodBeat.o(32310);
    }

    static /* synthetic */ void L(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(138641);
        imageGalleryUI.dGq();
        AppMethodBeat.o(138641);
    }

    static /* synthetic */ void N(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(138642);
        imageGalleryUI.dGi();
        AppMethodBeat.o(138642);
    }

    static /* synthetic */ ImageGalleryUI P(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(138643);
        ImageGalleryUI dFY = imageGalleryUI.dFY();
        AppMethodBeat.o(138643);
        return dFY;
    }

    static /* synthetic */ void b(ImageGalleryUI imageGalleryUI, Class cls, Intent intent) {
        AppMethodBeat.i(138640);
        imageGalleryUI.a(cls, intent);
        AppMethodBeat.o(138640);
    }

    static /* synthetic */ void eO(View view) {
        AppMethodBeat.i(138634);
        al(view, 8);
        AppMethodBeat.o(138634);
    }

    static /* synthetic */ void g(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(32292);
        imageGalleryUI.dGf();
        AppMethodBeat.o(32292);
    }

    static /* synthetic */ void k(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(32295);
        imageGalleryUI.dGg();
        AppMethodBeat.o(32295);
    }

    static /* synthetic */ void m(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(138629);
        imageGalleryUI.bcW();
        AppMethodBeat.o(138629);
    }

    public void onPause() {
        AppMethodBeat.i(32228);
        ab.i("MicroMsg.ImageGalleryUI", "on pause");
        super.onPause();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        if (!(isFinishing() || this.yTG == null)) {
            c cVar = this.yTG;
            cVar.yTO.yWT.sendEmptyMessageDelayed(1, 200);
            cVar.yTP.Du();
        }
        if (this.riC != null) {
            am amVar = new am();
            amVar.ctA.activity = this;
            amVar.ctA.ctB = this.riC;
            com.tencent.mm.sdk.b.a.xxA.m(amVar);
            this.riC = null;
            this.icD = 0;
            this.icC = 0;
        }
        com.tencent.mm.graphics.b.d.eCO.Pz();
        if (com.tencent.mm.graphics.b.c.eCI.eCM) {
            com.tencent.mm.graphics.b.c.eCI.stop();
        }
        o.JV(2);
        AppMethodBeat.o(32228);
    }

    /* Access modifiers changed, original: final */
    public final ImageGalleryUI dFY() {
        AppMethodBeat.i(32229);
        if (this.yVQ == null) {
            this.yVQ = ((ViewStub) findViewById(R.id.chc)).inflate();
            this.yVR = (Button) this.yVQ.findViewById(R.id.b7a);
            this.yVS = (Button) this.yVQ.findViewById(R.id.chj);
            this.yVT = this.yVQ.findViewById(R.id.chk);
        }
        AppMethodBeat.o(32229);
        return this;
    }

    /* Access modifiers changed, original: protected|final */
    public final ImageGalleryUI dFZ() {
        AppMethodBeat.i(32230);
        if (this.yVU == null) {
            this.yVU = ((ViewStub) findViewById(R.id.azs)).inflate();
            this.yVV = (VideoPlayerSeekBar) findViewById(R.id.azt);
            this.yVV.setPlayBtnOnClickListener(this);
        }
        AppMethodBeat.o(32230);
        return this;
    }

    private ImageGalleryUI dGa() {
        AppMethodBeat.i(32231);
        if (this.yVN == null) {
            this.yVN = (RelativeLayout) ((ViewStub) findViewById(R.id.ch_)).inflate();
        }
        AppMethodBeat.o(32231);
        return this;
    }

    private ImageGalleryUI dGb() {
        AppMethodBeat.i(32232);
        if (this.yVO == null) {
            this.yVO = (RelativeLayout) ((ViewStub) findViewById(R.id.chd)).inflate();
            this.yVO.findViewById(R.id.chh).setOnClickListener(this);
        }
        AppMethodBeat.o(32232);
        return this;
    }

    private static void al(View view, int i) {
        AppMethodBeat.i(32233);
        if (view != null) {
            view.setVisibility(i);
        }
        AppMethodBeat.o(32233);
    }

    private static int eN(View view) {
        AppMethodBeat.i(32234);
        if (view != null) {
            int visibility = view.getVisibility();
            AppMethodBeat.o(32234);
            return visibility;
        }
        AppMethodBeat.o(32234);
        return 8;
    }

    public final boolean noActionBar() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(32235);
        requestWindowFeature(1);
        long currentTimeMillis = System.currentTimeMillis();
        this.yWq = true;
        super.onCreate(bundle);
        if (com.tencent.mm.compatible.util.d.iW(19)) {
            getWindow().setFlags(201327616, 201327616);
            this.osu = true;
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.osu = false;
        }
        dya();
        initView();
        this.jWy = bundle;
        com.tencent.mm.sdk.b.a.xxA.c(this.mip);
        com.tencent.mm.sdk.b.a.xxA.c(this.riJ);
        com.tencent.mm.sdk.b.a.xxA.c(this.yWr);
        this.suk = false;
        ab.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(32235);
    }

    public void onResume() {
        AppMethodBeat.i(32236);
        super.onResume();
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        if (!(this.yWq || this.yTG == null)) {
            Pa(this.mQT.getCurrentItem());
        }
        this.yWq = false;
        if (this.yTG != null) {
            this.yTG.dFQ();
        }
        g.RO().a(this.qgg);
        o.JV(1);
        AppMethodBeat.o(32236);
    }

    public void onStart() {
        AppMethodBeat.i(32237);
        this.yWc = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        if (!this.yVL) {
            Bundle bundle = this.jWy;
            if (!this.jYD) {
                this.jYD = true;
                if (VERSION.SDK_INT >= 12) {
                    this.kkq = getIntent().getIntExtra("img_gallery_top", 0);
                    this.kkr = getIntent().getIntExtra("img_gallery_left", 0);
                    this.kks = getIntent().getIntExtra("img_gallery_width", 0);
                    this.kkt = getIntent().getIntExtra("img_gallery_height", 0);
                    if (this.kkq == 0 && this.kkr == 0 && this.kks == 0 && this.kkt == 0) {
                        bi Ou = this.yTG.Ou(this.mQT.getCurrentItem());
                        if (Ou != null) {
                            au auVar = new au();
                            auVar.ctR.csG = Ou;
                            com.tencent.mm.sdk.b.a.xxA.m(auVar);
                            this.kks = auVar.ctS.ctV;
                            this.kkt = auVar.ctS.ctW;
                            this.kkr = auVar.ctS.ctT;
                            this.kkq = auVar.ctS.ctU;
                        }
                    }
                    this.jYE.L(this.kkr, this.kkq, this.kks, this.kkt);
                    if (bundle == null) {
                        this.mQT.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                            public final boolean onPreDraw() {
                                AppMethodBeat.i(32196);
                                ImageGalleryUI.this.mQT.getViewTreeObserver().removeOnPreDrawListener(this);
                                ImageGalleryUI.this.rpw = ImageGalleryUI.this.mQT.getWidth();
                                ImageGalleryUI.this.rpx = ImageGalleryUI.this.mQT.getHeight();
                                if (ImageGalleryUI.this.yTG.dFO().bwt()) {
                                    ImageGalleryUI.this.rpx = (int) ((((float) ImageGalleryUI.this.rpw) / ((float) ImageGalleryUI.this.kks)) * ((float) ImageGalleryUI.this.kkt));
                                }
                                if (ImageGalleryUI.this.yTG.dFO().drE()) {
                                    com.tencent.mm.ui.base.g gVar = (com.tencent.mm.ui.base.g) ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.yTG, ImageGalleryUI.this.mQT);
                                    if (gVar != null) {
                                        ImageGalleryUI.this.rpx = (int) (((float) gVar.getImageHeight()) * (((float) ImageGalleryUI.this.rpw) / ((float) gVar.getImageWidth())));
                                        if (ImageGalleryUI.this.rpx > ImageGalleryUI.this.mQT.getHeight()) {
                                            ImageGalleryUI.this.rpx = ImageGalleryUI.this.mQT.getHeight();
                                        }
                                    }
                                }
                                ImageGalleryUI.this.jYE.hw(ImageGalleryUI.this.rpw, ImageGalleryUI.this.rpx);
                                if (!ImageGalleryUI.this.yWc) {
                                    ImageGalleryUI.q(ImageGalleryUI.this);
                                    ImageGalleryUI.this.yWx = false;
                                    ImageGalleryUI.this.jYE.a(ImageGalleryUI.this.mQT, ImageGalleryUI.this.mmX, new e.b() {
                                        public final void onAnimationStart() {
                                            AppMethodBeat.i(32194);
                                            if (ImageGalleryUI.this.yWm != null) {
                                                ImageGalleryUI.this.yWm.l(Boolean.TRUE);
                                            }
                                            AppMethodBeat.o(32194);
                                        }

                                        public final void onAnimationEnd() {
                                            AppMethodBeat.i(32195);
                                            ImageGalleryUI.this.mHandler.post(new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(32193);
                                                    if (ImageGalleryUI.this.yWm != null) {
                                                        ImageGalleryUI.this.yWm.l(Boolean.FALSE);
                                                    }
                                                    AppMethodBeat.o(32193);
                                                }
                                            });
                                            AppMethodBeat.o(32195);
                                        }
                                    });
                                }
                                ImageGalleryUI.u(ImageGalleryUI.this);
                                AppMethodBeat.o(32196);
                                return true;
                            }
                        });
                    }
                }
            }
        }
        super.onStart();
        AppMethodBeat.o(32237);
    }

    public void onDestroy() {
        AppMethodBeat.i(32238);
        ab.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", Integer.valueOf(hashCode()));
        try {
            if (this.yTG != null) {
                this.yTG.detach();
                this.yTG = null;
            }
            dGu();
            this.yWv.stopTimer();
            chI();
            this.qfZ.removeAllUpdateListeners();
            com.tencent.mm.sdk.b.a.xxA.d(this.mip);
            com.tencent.mm.sdk.b.a.xxA.d(this.riJ);
            com.tencent.mm.sdk.b.a.xxA.d(this.yWr);
            g.RO().b(this.qgg);
            if (this.yVV != null) {
                this.yVV.setPlayBtnOnClickListener(null);
            }
            this.yVV = null;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ImageGalleryUI", e, "", new Object[0]);
        }
        super.onDestroy();
        AppMethodBeat.o(32238);
    }

    public void onBackPressed() {
        AppMethodBeat.i(32239);
        ab.i("MicroMsg.ImageGalleryUI", "onBackPressed");
        if (this.yWb) {
            Pb(1);
            AppMethodBeat.o(32239);
            return;
        }
        try {
            com.tencent.mm.ui.chatting.gallery.h.a.yVE.detach();
            bcW();
            AppMethodBeat.o(32239);
        } catch (Exception e) {
            ab.e("MicroMsg.ImageGalleryUI", e.getMessage());
            finish();
            AppMethodBeat.o(32239);
        }
    }

    private String dGc() {
        AppMethodBeat.i(32240);
        String str;
        if (this.chatroomName == null || this.chatroomName.length() <= 0) {
            str = this.talker;
            AppMethodBeat.o(32240);
            return str;
        }
        str = this.chatroomName;
        AppMethodBeat.o(32240);
        return str;
    }

    public final void initView() {
        AppMethodBeat.i(32241);
        this.jYE = new e(this.mController.ylL);
        this.yWz = new ap(this, false);
        this.jYD = false;
        this.talker = getIntent().getStringExtra("img_gallery_talker");
        this.yWb = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
        this.yRt = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
        this.yWd = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
        this.yRs = getIntent().getBooleanExtra("show_search_chat_content_result", false);
        this.yWa = getIntent().getBooleanExtra("show_enter_grid", true);
        this.mgP = getIntent().getBooleanExtra("key_is_biz_chat", false);
        this.jMj = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.yVL = getIntent().getBooleanExtra("img_preview_only", false);
        this.yWe = getIntent().getIntExtra("img_gallery_enter_from_scene", 0);
        if (!this.yVL) {
            Assert.assertTrue("MicroMsg.ImageGalleryUI initView, talker is null, stack = " + bo.dpG(), this.talker != null);
        }
        this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
        this.yWc = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        this.yWj = getIntent().getStringExtra("img_gallery_enter_video_opcode");
        boolean booleanExtra = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
        String stringExtra = getIntent().getStringExtra("img_gallery_directly_send_name");
        this.yWk = (ImageView) findViewById(R.id.ch6);
        this.yWl = (ImageView) findViewById(R.id.ch8);
        LayoutParams layoutParams = (LayoutParams) this.yWl.getLayoutParams();
        layoutParams.bottomMargin += ae.fr(this);
        this.yWl.setLayoutParams(layoutParams);
        this.yWl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(32220);
                ao aoVar = new ao();
                aoVar.ctD.scene = 1;
                aoVar.ctD.ctE = ImageGalleryUI.this.yWg;
                com.tencent.mm.sdk.b.a.xxA.m(aoVar);
                ImageGalleryUI.g(ImageGalleryUI.this);
                ImageGalleryUI.this.yWg = 0;
                AppMethodBeat.o(32220);
            }
        });
        dGd();
        this.cvx = getIntent().getLongExtra("img_gallery_msg_id", 0);
        long longExtra = getIntent().getLongExtra("img_gallery_msg_svr_id", 0);
        if (this.cvx > 0 || longExtra != 0) {
            if (this.cvx == 0) {
                aw.ZK();
                this.cvx = com.tencent.mm.model.c.XO().Q(dGc(), longExtra).field_msgId;
            }
            aw.ZK();
            bi jf = com.tencent.mm.model.c.XO().jf(this.cvx);
            if (jf.field_msgId <= 0) {
                ab.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.cvx + ", msgSvrId = " + longExtra + ", stack = " + bo.dpG());
                finish();
                AppMethodBeat.o(32241);
                return;
            }
            this.yTG = new c(this, this.cvx, dGc(), this.mgP, this.jMj, booleanExtra, stringExtra, Boolean.valueOf(this.yWc));
            this.yTG.yTR = false;
            this.yTG.yTL = getIntent().getBooleanExtra("start_chatting_ui", true);
            this.yTG.yTQ = new c.c() {
                public final void pL() {
                    AppMethodBeat.i(32221);
                    if (ImageGalleryUI.this.yTG == null) {
                        AppMethodBeat.o(32221);
                        return;
                    }
                    ImageGalleryUI.k(ImageGalleryUI.this);
                    ImageGalleryUI.this.yTG.onPageSelected(100000);
                    AppMethodBeat.o(32221);
                }
            };
            this.yVJ = (RelativeLayout) findViewById(R.id.b7_);
            this.yVK = (RelativeLayout) findViewById(R.id.ch9);
            int paddingTop = this.yVK.getPaddingTop();
            if (ae.hD(this.mController.ylL)) {
                paddingTop += ae.hC(this.mController.ylL);
            }
            this.yVK.setPadding(0, paddingTop, 0, 0);
            this.yVM = (ImageView) findViewById(R.id.cha);
            this.yVM.setOnClickListener(this);
            if (av(this)) {
                dGw();
            } else {
                dGx();
            }
            this.mmX = (ImageView) findViewById(R.id.adg);
            this.mmX.setLayerType(2, null);
            this.mQT = (MMViewPager) findViewById(R.id.adi);
            this.mQT.setLayerType(2, null);
            this.mQT.setVerticalFadingEdgeEnabled(false);
            this.mQT.setHorizontalFadingEdgeEnabled(false);
            this.mQT.setSingleClickOverListener(new MMViewPager.e() {
                public final void bcX() {
                    AppMethodBeat.i(32222);
                    ImageGalleryUI.l(ImageGalleryUI.this);
                    AppMethodBeat.o(32222);
                }

                public final void bCN() {
                    AppMethodBeat.i(32223);
                    ImageGalleryUI.m(ImageGalleryUI.this);
                    AppMethodBeat.o(32223);
                }
            });
            if (!this.yVL) {
                this.mQT.setOnPageChangeListener(this.yWt);
                this.mQT.setLongClickOverListener(new MMViewPager.c() {
                    public final void bvE() {
                        AppMethodBeat.i(32224);
                        if (ImageGalleryUI.this.yWi == 1) {
                            AppMethodBeat.o(32224);
                        } else if (ImageGalleryUI.this.yWi == 0 || ImageGalleryUI.this.yWi == 2) {
                            long j;
                            k kVar = new k();
                            if (ImageGalleryUI.this.yWi == 2) {
                                j = 1;
                            } else {
                                j = 0;
                            }
                            kVar.cVR = j;
                            kVar.cVS = 1;
                            kVar.ajK();
                            ImageGalleryUI.this.ak(true, com.tencent.mm.plugin.scanner.d.cgx());
                            AppMethodBeat.o(32224);
                        } else {
                            ImageGalleryUI.this.ak(true, false);
                            AppMethodBeat.o(32224);
                        }
                    }
                });
            }
            this.mQT.setOffscreenPageLimit(1);
            this.mQT.setAdapter(this.yTG);
            Pa(100000);
            this.mQT.setCurrentItem(100000);
            this.mQT.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(32225);
                    if (ImageGalleryUI.this.yTG == null) {
                        AppMethodBeat.o(32225);
                        return;
                    }
                    if (com.tencent.mm.ui.chatting.gallery.h.a.yVE.mnY && ImageGalleryUI.this.yWo != null) {
                        ImageGalleryUI.this.yWo.setChecked(com.tencent.mm.ui.chatting.gallery.h.a.yVE.bE(ImageGalleryUI.this.yTG.dFO()));
                        ImageGalleryUI.this.yWp.setOnClickListener(ImageGalleryUI.this);
                    }
                    if (ImageGalleryUI.this.mQT.getCurrentItem() != 100000) {
                        AppMethodBeat.o(32225);
                        return;
                    }
                    ImageGalleryUI.this.dGt();
                    c.b bt = c.bt(ImageGalleryUI.this.yTG.Ou(100000));
                    if (!ImageGalleryUI.this.yWc && bt == c.b.video) {
                        ImageGalleryUI.this.yTG.OP(100000);
                    }
                    if (bt == c.b.sight) {
                        ImageGalleryUI.this.yTG.OT(100000);
                    }
                    AppMethodBeat.o(32225);
                }
            }, 0);
            if (com.tencent.mm.ui.chatting.gallery.h.a.yVE.mnY) {
                this.yWn = ((ViewStub) findViewById(R.id.ch5)).inflate();
                this.yWn.setVisibility(0);
                this.yWo = (CheckBox) this.yWn.findViewById(R.id.bpy);
                this.yWp = this.yWn.findViewById(R.id.bpz);
            }
            this.yVY = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
            com.tencent.mm.at.e f = this.yTG.f(jf, true);
            if (f == null) {
                ab.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", Boolean.valueOf(this.yVY));
            }
            if (this.yVY && f != null && f.agP()) {
                dGy();
                this.yVY = false;
            } else if (this.yVY) {
                ab.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
            }
            this.mQT.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(32226);
                    switch (motionEvent.getAction()) {
                        case 0:
                            v.b y = v.Zp().y("basescanui@datacenter", true);
                            y.j("key_basescanui_screen_x", Integer.valueOf((int) motionEvent.getRawX()));
                            y.j("key_basescanui_screen_y", Integer.valueOf((int) motionEvent.getRawY()));
                            break;
                    }
                    AppMethodBeat.o(32226);
                    return false;
                }
            });
            AppMethodBeat.o(32241);
            return;
        }
        ab.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.cvx + ", msgSvrId = " + longExtra + ", stack = " + bo.dpG());
        finish();
        AppMethodBeat.o(32241);
    }

    private void dGd() {
        AppMethodBeat.i(32242);
        this.qbx = (ImageView) findViewById(R.id.ch7);
        this.qfZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.qfZ.setDuration(5000);
        this.qfZ.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(32190);
                ImageGalleryUI.this.qbx.setAlpha(0.0f);
                AppMethodBeat.o(32190);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(32191);
                ImageGalleryUI.this.qbx.setAlpha(0.0f);
                AppMethodBeat.o(32191);
            }
        });
        final int height = getWindowManager().getDefaultDisplay().getHeight();
        this.qfZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(32192);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue <= 0.1f) {
                    ImageGalleryUI.this.qbx.setAlpha(floatValue * 10.0f);
                } else if (floatValue >= 0.9f) {
                    ImageGalleryUI.this.qbx.setAlpha((1.0f - floatValue) * 10.0f);
                }
                ImageGalleryUI.this.qbx.setTranslationY(floatValue * ((float) (height - ImageGalleryUI.this.qbx.getHeight())));
                AppMethodBeat.o(32192);
            }
        });
        AppMethodBeat.o(32242);
    }

    private View a(c cVar, MMViewPager mMViewPager) {
        View view;
        AppMethodBeat.i(32243);
        String str = "MicroMsg.ImageGalleryUI";
        String str2 = "get current view adapter is null %b, gallery is null %b";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(cVar == null);
        objArr[1] = Boolean.valueOf(mMViewPager == null);
        ab.d(str, str2, objArr);
        if (cVar == null || mMViewPager == null) {
            ab.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", Integer.valueOf(hashCode()));
            view = null;
        } else if (cVar.dFO() == null) {
            AppMethodBeat.o(32243);
            return null;
        } else if (cVar.dFO().drE() || cVar.dFO().dtA()) {
            view = cVar.wx(mMViewPager.getCurrentItem());
            if (view == null) {
                view = cVar.wy(mMViewPager.getCurrentItem());
            }
        } else {
            if (cVar.dFO().bws() || cVar.dFO().bwt()) {
                view = cVar.OO(mMViewPager.getCurrentItem());
            }
            view = null;
        }
        AppMethodBeat.o(32243);
        return view;
    }

    private void bcW() {
        AppMethodBeat.i(32244);
        if (this.suk || this.yTG == null) {
            ab.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
            AppMethodBeat.o(32244);
            return;
        }
        dGf();
        if (this.yVL) {
            finish();
            com.tencent.mm.ui.base.b.hL(this.mController.ylL);
            AppMethodBeat.o(32244);
            return;
        }
        int i;
        int i2;
        int i3;
        ab.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
        int width = this.mQT.getWidth() / 2;
        int height = this.mQT.getHeight() / 2;
        this.yTG.dFM();
        if (this.yWb) {
            gs gsVar = new gs();
            gsVar.cBr.cvx = this.yTG.Ou(this.mQT.getCurrentItem()).field_msgId;
            com.tencent.mm.sdk.b.a.xxA.m(gsVar);
            i = gsVar.cBs.ctV;
            i2 = gsVar.cBs.ctW;
            width = gsVar.cBs.ctT;
            i3 = gsVar.cBs.ctU;
        } else {
            bi Ou = this.yTG.Ou(this.mQT.getCurrentItem());
            if (Ou != null) {
                au auVar = new au();
                auVar.ctR.csG = Ou;
                com.tencent.mm.sdk.b.a.xxA.m(auVar);
                i = auVar.ctS.ctV;
                i2 = auVar.ctS.ctW;
                width = auVar.ctS.ctT;
                height = auVar.ctS.ctU;
            } else {
                i2 = 0;
                i = 0;
            }
            if (width == 0 && height == 0) {
                width = this.mQT.getWidth() / 2;
                i3 = this.mQT.getHeight() / 2;
            } else {
                if (Ou != null) {
                    if (Ou.field_isSend == 0) {
                        this.yVW = com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 5);
                    }
                    if (Ou.field_isSend == 1) {
                        this.yVX = com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 5);
                    }
                }
                i3 = height;
            }
        }
        this.rpw = this.mQT.getWidth();
        this.rpx = this.mQT.getHeight();
        if (this.yTG.dFO() != null) {
            if (this.yTG.dFO().bwt() || this.yTG.dFO().bws()) {
                this.rpx = (int) ((((float) this.rpw) / ((float) i)) * ((float) i2));
            }
            if (this.yTG.dFO().drE() || this.yTG.dFO().dtA()) {
                com.tencent.mm.ui.base.g gVar = (com.tencent.mm.ui.base.g) a(this.yTG, this.mQT);
                if (gVar != null) {
                    this.rpx = (int) (((float) gVar.getImageHeight()) * (((float) this.rpw) / ((float) gVar.getImageWidth())));
                    if (this.rpx > this.mQT.getHeight()) {
                        if (((double) this.rpx) < ((double) this.mQT.getHeight()) * 1.5d) {
                            if (this.yWb) {
                                this.rpy = this.rpx - this.mQT.getHeight();
                            } else {
                                i2 = (this.mQT.getHeight() * i2) / this.rpx;
                            }
                        }
                        this.rpx = this.mQT.getHeight();
                    }
                }
            }
        }
        this.jYE.hx(this.yVW, this.yVX);
        this.jYE.zFd = this.rpy;
        this.jYE.hw(this.rpw, this.rpx);
        this.jYE.L(width, i3, i, i2);
        View view = this.mQT;
        View a = a(this.yTG, this.mQT);
        if (a == null) {
            a = view;
        } else if (((double) this.rpz) != 1.0d) {
            this.jYE.zEZ = 1.0f / this.rpz;
            if (!(this.rpA == 0 && this.rpB == 0)) {
                this.jYE.hy(((int) (((float) (this.mQT.getWidth() / 2)) * (1.0f - this.rpz))) + this.rpA, (int) (((float) ((this.mQT.getHeight() / 2) + this.rpB)) - (((float) (this.rpx / 2)) * this.rpz)));
            }
        }
        this.jYE.a(a, this.mmX, new e.b() {
            public final void onAnimationStart() {
                AppMethodBeat.i(32201);
                ImageGalleryUI.this.suk = true;
                ImageGalleryUI.eO(ImageGalleryUI.this.yVK);
                ImageGalleryUI.eO(ImageGalleryUI.this.yVJ);
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(32199);
                        View a = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.yTG, ImageGalleryUI.this.mQT);
                        if (a != null && (a instanceof com.tencent.mm.ui.base.g)) {
                            if (a instanceof MultiTouchImageView) {
                                ((MultiTouchImageView) a).dzA();
                                AppMethodBeat.o(32199);
                                return;
                            } else if (a instanceof WxImageView) {
                                ((WxImageView) a).dzA();
                            }
                        }
                        AppMethodBeat.o(32199);
                    }
                }, 20);
                AppMethodBeat.o(32201);
            }

            public final void onAnimationEnd() {
                AppMethodBeat.i(32202);
                ab.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
                ImageGalleryUI.this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(32200);
                        ImageGalleryUI.this.finish();
                        ImageGalleryUI.this.overridePendingTransition(0, 0);
                        AppMethodBeat.o(32200);
                    }
                });
                ImageGalleryUI.this.suk = false;
                AppMethodBeat.o(32202);
            }
        }, null);
        AppMethodBeat.o(32244);
    }

    private String dGe() {
        AppMethodBeat.i(32245);
        bi Ou = this.yTG.Ou(this.yWs);
        String str = null;
        if (c.c(Ou)) {
            com.tencent.mm.at.e f = this.yTG.f(Ou, true);
            if (f != null) {
                str = e.a(Ou, f);
            }
        } else if (c.br(Ou)) {
            str = c.e(Ou);
        }
        AppMethodBeat.o(32245);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final void ak(boolean z, boolean z2) {
        AppMethodBeat.i(138626);
        if (this.yTG == null) {
            AppMethodBeat.o(138626);
        } else if (this.yWs < 0) {
            AppMethodBeat.o(138626);
        } else {
            bi Ou = this.yTG.Ou(this.yWs);
            int bA = this.yTG.yTN.bA(Ou);
            if (bA == 5 || bA == 6) {
                ab.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
                AppMethodBeat.o(138626);
            } else if (this.yTG.bs(Ou)) {
                ab.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
                AppMethodBeat.o(138626);
            } else if (c.f(Ou) && j.bG(Ou) == null) {
                ab.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
                AppMethodBeat.o(138626);
            } else {
                final ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(getString(R.string.dr8));
                if (com.tencent.mm.bp.d.afj("favorite")) {
                    arrayList.add(Integer.valueOf(2));
                    arrayList2.add(getString(R.string.dcq));
                }
                if (c.c(Ou) || c.br(Ou)) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.string.dwx));
                } else if (c.f(Ou) || c.bp(Ou)) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.string.dx0));
                } else {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.string.dwz));
                }
                if (this.yWh && !bo.isNullOrNil(dGe())) {
                    long j;
                    arrayList.add(Integer.valueOf(7));
                    arrayList2.add(getString(R.string.g6e));
                    k kVar = new k();
                    if (this.yWi == 2) {
                        j = 1;
                    } else {
                        j = 0;
                    }
                    kVar.cVR = j;
                    kVar.cVS = 2;
                    kVar.ajK();
                }
                if (c.c(Ou) || c.bp(Ou)) {
                    dq dqVar = new dq();
                    dqVar.cxc.cvx = Ou.field_msgId;
                    com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                    if (dqVar.cxd.cwB || com.tencent.mm.pluginsdk.model.app.g.ad(this.mController.ylL, Ou.getType())) {
                        arrayList.add(Integer.valueOf(4));
                        arrayList2.add(getString(R.string.amc));
                    }
                }
                if (c.c(Ou)) {
                    if (this.yWe == 1) {
                        bA = 0;
                    } else {
                        bA = 1;
                    }
                    if (bA != 0) {
                        arrayList.add(Integer.valueOf(6));
                        arrayList2.add(getString(R.string.al9));
                    }
                }
                if (this.riC != null && ary(this.riC)) {
                    arrayList.add(Integer.valueOf(3));
                    if (com.tencent.mm.plugin.scanner.a.BR(this.icC)) {
                        arrayList2.add(getString(R.string.diy));
                    } else if (com.tencent.mm.plugin.scanner.a.ba(this.icC, this.riC)) {
                        arrayList2.add(getString(R.string.diz));
                    } else if (com.tencent.mm.plugin.scanner.a.BQ(this.icC)) {
                        arrayList2.add(getString(R.string.dix));
                    } else {
                        arrayList2.add(getString(R.string.diy));
                    }
                }
                if (bh.o(Ou)) {
                    arrayList.clear();
                    arrayList2.clear();
                }
                if (this.yWd || this.yWe == 1 || this.yRs || this.mgP || com.tencent.mm.ui.chatting.gallery.h.a.yVE.mnY) {
                    bA = 0;
                } else {
                    bA = 1;
                }
                if (bA != 0) {
                    arrayList.add(Integer.valueOf(5));
                    arrayList2.add(getString(R.string.al8));
                }
                if (this.riy == null) {
                    this.riy = new com.tencent.mm.ui.widget.a.d(this.mController.ylL, 1, false);
                }
                this.riy.rBl = new com.tencent.mm.ui.base.n.c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(32203);
                        lVar.clear();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < arrayList.size()) {
                                lVar.e(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                                i = i2 + 1;
                            } else {
                                AppMethodBeat.o(32203);
                                return;
                            }
                        }
                    }
                };
                if (arrayList.size() == 0) {
                    AppMethodBeat.o(138626);
                    return;
                }
                this.riy.rBm = this.lcJ;
                this.riy.zQf = new com.tencent.mm.ui.widget.a.d.a() {
                    public final void onDismiss() {
                        AppMethodBeat.i(32204);
                        an anVar = new an();
                        anVar.ctC.filePath = ImageGalleryUI.this.riz;
                        com.tencent.mm.sdk.b.a.xxA.m(anVar);
                        ImageGalleryUI.this.riy = null;
                        ImageGalleryUI.this.riz = null;
                        ImageGalleryUI.this.riC = null;
                        ImageGalleryUI.this.icC = ImageGalleryUI.this.icD = 0;
                        ImageGalleryUI.this.yWh = false;
                        ImageGalleryUI.this.riD = false;
                        AppMethodBeat.o(32204);
                    }
                };
                this.riy.cpD();
                String dGe = dGe();
                if (!bo.isNullOrNil(dGe)) {
                    if (z && aw.Rg().acS() != 0) {
                        np npVar = new np();
                        npVar.cJU.filePath = dGe;
                        this.riz = dGe;
                        com.tencent.mm.sdk.b.a.xxA.m(npVar);
                    }
                    if (z2) {
                        if (this.yWf == null) {
                            this.yWf = new com.tencent.mm.plugin.scanner.c.b(this);
                        }
                        this.yWf.a(dGe, this);
                    }
                }
                AppMethodBeat.o(138626);
            }
        }
    }

    private boolean ary(String str) {
        AppMethodBeat.i(32247);
        if (this.yWe == 1) {
            AppMethodBeat.o(32247);
            return false;
        } else if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(32247);
            return false;
        } else if (this.yWd) {
            String[] split = ((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.APPBRAND_BLOCK_QRCODE_PREFIX_STRING_SYNC, (Object) "")).split("\\|");
            if (split != null && split.length > 0) {
                int length = split.length;
                int i = 0;
                while (i < length) {
                    String str2 = split[i];
                    if (bo.isNullOrNil(str2) || !str.startsWith(str2)) {
                        i++;
                    } else {
                        ab.i("MicroMsg.ImageGalleryUI", "curDealQBarStr:%s, blockQrcodeStr:%s", str, str2);
                        AppMethodBeat.o(32247);
                        return false;
                    }
                }
            }
            AppMethodBeat.o(32247);
            return true;
        } else {
            AppMethodBeat.o(32247);
            return true;
        }
    }

    private void dGf() {
        AppMethodBeat.i(32248);
        this.yWi = 0;
        this.qbx.setVisibility(8);
        this.yWk.setVisibility(8);
        this.yWl.setVisibility(8);
        dGh();
        dGt();
        hG(true);
        chI();
        AppMethodBeat.o(32248);
    }

    private void chI() {
        AppMethodBeat.i(32250);
        this.qfZ.setRepeatMode(1);
        this.qfZ.setRepeatCount(0);
        this.qfZ.end();
        AppMethodBeat.o(32250);
    }

    public final void hG(boolean z) {
        int i = 8;
        AppMethodBeat.i(32251);
        if (this.yVJ == null) {
            AppMethodBeat.o(32251);
        } else if (!(z && this.yVJ.getVisibility() == 0) && (z || this.yVJ.getVisibility() != 8)) {
            RelativeLayout relativeLayout = this.yVJ;
            if (z) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
            this.yVJ.startAnimation(AnimationUtils.loadAnimation(this.mController.ylL, z ? R.anim.n : R.anim.o));
            AppMethodBeat.o(32251);
        } else {
            AppMethodBeat.o(32251);
        }
    }

    public final int getLayoutId() {
        return R.layout.a7f;
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(32252);
        super.onCreateBeforeSetContentView();
        AppMethodBeat.o(32252);
    }

    private void dGg() {
        AppMethodBeat.i(32253);
        if (this.yTG == null || this.yVL) {
            AppMethodBeat.o(32253);
        } else if (!this.yTG.dFN()) {
            AppMethodBeat.o(32253);
        } else if (dGa().yVN == null) {
            AppMethodBeat.o(32253);
        } else if (com.tencent.mm.ui.chatting.gallery.h.a.yVE.mnY) {
            dGi();
            AppMethodBeat.o(32253);
        } else if (this.yRs) {
            dGi();
            AppMethodBeat.o(32253);
        } else {
            ab.d("MicroMsg.ImageGalleryUI", "%d show enter grid is video %b", Integer.valueOf(hashCode()), Boolean.valueOf(dGj()));
            if (this.yWi == 0 || this.yWi == 2) {
                dGh();
            }
            dGt();
            AppMethodBeat.o(32253);
        }
    }

    private void dGh() {
        int i;
        int i2 = 0;
        AppMethodBeat.i(32254);
        al(dGa().yVN, this.yWa ? 0 : 8);
        bi biVar = null;
        if (this.yTG != null) {
            biVar = this.yTG.dFO();
        }
        int i3 = 1;
        if (this.yVI != c.b.image) {
            i3 = 0;
        }
        if (biVar == null || !bh.o(biVar)) {
            i = i3;
        } else {
            i = 0;
        }
        RelativeLayout relativeLayout = dGb().yVO;
        if (i == 0) {
            i2 = 8;
        }
        al(relativeLayout, i2);
        AppMethodBeat.o(32254);
    }

    private void dGi() {
        AppMethodBeat.i(32255);
        al(dGa().yVN, 8);
        al(dGb().yVO, 8);
        AppMethodBeat.o(32255);
    }

    private static boolean f(bi biVar, com.tencent.mm.at.e eVar) {
        AppMethodBeat.i(32256);
        if (eVar == null) {
            AppMethodBeat.o(32256);
            return false;
        }
        try {
            if (c.c(biVar, eVar) == 0 && eVar.agQ() && !biVar.dtH()) {
                AppMethodBeat.o(32256);
                return true;
            }
        } catch (NullPointerException e) {
            ab.e("MicroMsg.ImageGalleryUI", "error:".concat(String.valueOf(e)));
        }
        AppMethodBeat.o(32256);
        return false;
    }

    public final void Pa(int i) {
        AppMethodBeat.i(32257);
        bF(this.yTG.Ou(i));
        AppMethodBeat.o(32257);
    }

    private boolean dGj() {
        if (this.yVI == c.b.video) {
            return true;
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dGk() {
        AppMethodBeat.i(32258);
        if (this.yWu) {
            this.yWv.ae(4000, 4000);
        }
        AppMethodBeat.o(32258);
    }

    public final void dGl() {
        AppMethodBeat.i(32259);
        ab.i("MicroMsg.ImageGalleryUI", "show video tool bar");
        hG(true);
        qw(true);
        al(this.yVQ, 8);
        al(dFZ().yVU, 0);
        al(this.yVM, 0);
        dGa().yVN.clearAnimation();
        if (this.yVL) {
            dGi();
        } else if (this.yWi == 0 || this.yWi == 2) {
            dGh();
        }
        dGu();
        this.yWu = true;
        dGk();
        AppMethodBeat.o(32259);
    }

    public final void dGm() {
        AppMethodBeat.i(32260);
        ab.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
        qw(false);
        al(dFZ().yVU, 8);
        al(this.yVM, 8);
        if (dGj()) {
            dGu();
            dGi();
        }
        this.yWu = false;
        AppMethodBeat.o(32260);
    }

    private static void qw(boolean z) {
        AppMethodBeat.i(32261);
        ab.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", Boolean.valueOf(z));
        AppMethodBeat.o(32261);
    }

    public final synchronized void bF(bi biVar) {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(32262);
            this.yVI = c.bt(biVar);
            ab.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType : " + this.yVI);
            if (com.tencent.mm.ui.chatting.gallery.h.a.yVE.mnY && this.yWo != null) {
                this.yWo.setChecked(com.tencent.mm.ui.chatting.gallery.h.a.yVE.bE(biVar));
            }
            switch (this.yVI) {
                case video:
                    dGm();
                    al(this.yVQ, 8);
                    qx(true);
                    s bG = j.bG(biVar);
                    if (bG != null) {
                        dFZ().yVV.setVideoTotalTime(bG.fXd);
                        try {
                            if (!(this.yTG.dFP() == null || this.yTG.dFP().yXp == null)) {
                                i = this.yTG.dFP().yXp.getCurrentPosition() / 1000;
                            }
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.ImageGalleryUI", e, "", new Object[0]);
                        }
                        dFZ().yVV.seek(i);
                        AppMethodBeat.o(32262);
                        break;
                    }
                    AppMethodBeat.o(32262);
                    break;
                case image:
                    com.tencent.mm.at.e f = this.yTG.f(biVar, false);
                    dGm();
                    dGg();
                    if (f != null) {
                        this.mQT.getCurrentItem();
                        if (f(biVar, f) && !biVar.dtH() && f.agP()) {
                            dFY().yVR.setVisibility(0);
                            dFY().yVS.setVisibility(8);
                            dFY().yVT.setVisibility(8);
                            String str = (String) this.yWw.get(Long.valueOf(f.fDy));
                            if (str == null) {
                                Map z = br.z(f.fDK, "msg");
                                if (z == null) {
                                    ab.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", f.fDK);
                                    i = -1;
                                } else {
                                    i = bo.getInt((String) z.get(".msg.img.$hdlength"), 0);
                                    if (i == 0) {
                                        i = bo.getInt((String) z.get(".msg.img.$tphdlength"), 0);
                                    }
                                }
                                long j = (long) i;
                                if (j < 0) {
                                    str = "";
                                } else {
                                    BigDecimal bigDecimal = new BigDecimal(j);
                                    float floatValue = bigDecimal.divide(new BigDecimal(1048576), 2, 0).floatValue();
                                    if (floatValue > 1.0f) {
                                        str = ((int) floatValue) + "M";
                                    } else {
                                        str = ((int) bigDecimal.divide(new BigDecimal(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), 2, 0).floatValue()) + "K";
                                    }
                                }
                                this.yWw.put(Long.valueOf(f.fDy), str);
                            }
                            dFY().yVR.setText(getString(R.string.b3v, new Object[]{str}));
                            al(this.yVQ, 0);
                        } else {
                            al(this.yVQ, 8);
                        }
                        if (!this.yVY || !f.agP() || this.yTG.dFO() == null || biVar.field_msgId != this.yTG.dFO().field_msgId) {
                            bi dFO = this.yTG.dFO();
                            String str2 = "MicroMsg.ImageGalleryUI";
                            String str3 = "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s";
                            Object[] objArr = new Object[4];
                            objArr[0] = Boolean.valueOf(this.yVY);
                            objArr[1] = Long.valueOf(biVar.field_msgId);
                            objArr[2] = dFO == null ? BuildConfig.COMMAND : Long.valueOf(dFO.field_msgId);
                            objArr[3] = Boolean.valueOf(f.agP());
                            ab.w(str2, str3, objArr);
                            AppMethodBeat.o(32262);
                            break;
                        }
                        ab.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", Long.valueOf(biVar.field_msgId));
                        dGy();
                        this.yVY = false;
                        AppMethodBeat.o(32262);
                        break;
                    }
                    ab.w("MicroMsg.ImageGalleryUI", "updateFooterInfo img info is null");
                    AppMethodBeat.o(32262);
                    break;
                case appimage:
                    dGm();
                    dGg();
                    AppMethodBeat.o(32262);
                    break;
                case sight:
                    dGm();
                    dGg();
                    al(this.yVQ, 8);
                    this.yTG.OT(this.mQT.getCurrentItem());
                    break;
            }
            AppMethodBeat.o(32262);
        }
    }

    private void Pb(int i) {
        AppMethodBeat.i(32263);
        ab.i("MicroMsg.ImageGalleryUI", "enterGrid source : ".concat(String.valueOf(i)));
        if (this.yTG == null) {
            ab.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
            AppMethodBeat.o(32263);
            return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(219, 13, 1, true);
        int realCount = this.yTG.getRealCount();
        if (this.yTG.dFO() == null) {
            ab.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
            AppMethodBeat.o(32263);
            return;
        }
        int OU = this.yTG.yTJ.OU(this.mQT.getCurrentItem());
        if (this.yWb) {
            bcW();
            AppMethodBeat.o(32263);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.mController.ylL, MediaHistoryGalleryUI.class);
        intent.addFlags(67108864);
        intent.putExtra("kintent_intent_source", i);
        intent.putExtra("kintent_talker", dGc());
        intent.putExtra("kintent_image_count", realCount);
        intent.putExtra("kintent_image_index", OU);
        intent.putExtra("key_biz_chat_id", this.jMj);
        intent.putExtra("key_is_biz_chat", this.mgP);
        startActivity(intent);
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(32213);
                ImageGalleryUI.this.finish();
                AppMethodBeat.o(32213);
            }
        }, 50);
        AppMethodBeat.o(32263);
    }

    public final int getCurrentItem() {
        AppMethodBeat.i(139028);
        int currentItem = this.mQT.getCurrentItem();
        AppMethodBeat.o(139028);
        return currentItem;
    }

    public void onClick(View view) {
        boolean z = true;
        AppMethodBeat.i(32265);
        if (this.yTG == null) {
            AppMethodBeat.o(32265);
        } else if (view.getId() == R.id.ch_) {
            Pb(0);
            AppMethodBeat.o(32265);
        } else if (view.getId() == R.id.chh) {
            ab.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", Integer.valueOf(this.mQT.getCurrentItem()));
            al(dGb().yVO, 8);
            bi Ou = this.yTG.Ou(this.mQT.getCurrentItem());
            com.tencent.mm.at.e f = this.yTG.f(Ou, false);
            this.mQT.getCurrentItem();
            if (f(Ou, f) && !Ou.dtH() && f.agP()) {
                this.yTG.aF(this.mQT.getCurrentItem(), true);
                AppMethodBeat.o(32265);
                return;
            }
            c.b(this.mController.ylL, this.yTG.dFO(), true);
            AppMethodBeat.o(32265);
        } else if (view.getId() == R.id.b7a) {
            this.yWi = 2;
            this.yWg = 0;
            this.yTG.aF(this.mQT.getCurrentItem(), false);
            AppMethodBeat.o(32265);
        } else if (view.getId() == R.id.chj) {
            this.yTG.OS(this.mQT.getCurrentItem());
            Pa(this.mQT.getCurrentItem());
            dGp();
            dGq();
            dGt();
            AppMethodBeat.o(32265);
        } else if (view.getId() == R.id.kw) {
            onBackPressed();
            AppMethodBeat.o(32265);
        } else if (view.getId() == R.id.cha) {
            onBackPressed();
            AppMethodBeat.o(32265);
        } else if (view.getId() == R.id.bpz) {
            boolean isChecked = this.yWo.isChecked();
            if (isChecked || com.tencent.mm.ui.chatting.gallery.h.a.yVE.mnX.size() < 9) {
                CheckBox checkBox = this.yWo;
                if (isChecked) {
                    z = false;
                }
                checkBox.setChecked(z);
                if (this.yWo.isChecked()) {
                    com.tencent.mm.ui.chatting.gallery.h.a.yVE.bC(this.yTG.dFO());
                    AppMethodBeat.o(32265);
                    return;
                }
                com.tencent.mm.ui.chatting.gallery.h.a.yVE.bD(this.yTG.dFO());
                AppMethodBeat.o(32265);
                return;
            }
            Toast.makeText(this, getResources().getString(R.string.c3z, new Object[]{Integer.valueOf(9)}), 1).show();
            AppMethodBeat.o(32265);
        } else {
            if (view.getId() == R.id.t6) {
                this.yTG.OP(this.mQT.getCurrentItem());
            }
            AppMethodBeat.o(32265);
        }
    }

    public final void qx(boolean z) {
        AppMethodBeat.i(32266);
        try {
            dFZ().yVV.setIsPlay(!z);
            AppMethodBeat.o(32266);
        } catch (Exception e) {
            ab.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + e.toString());
            AppMethodBeat.o(32266);
        }
    }

    public final boolean cGZ() {
        AppMethodBeat.i(32267);
        boolean buH = dFZ().yVV.buH();
        AppMethodBeat.o(32267);
        return buH;
    }

    public final void Pc(final int i) {
        AppMethodBeat.i(32268);
        if (dFZ().yVU == null) {
            AppMethodBeat.o(32268);
            return;
        }
        dFZ().yVU.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(32214);
                if (ImageGalleryUI.this.yTG == null) {
                    AppMethodBeat.o(32214);
                    return;
                }
                c j = ImageGalleryUI.this.yTG;
                j.yTO.pause(i);
                AppMethodBeat.o(32214);
            }
        });
        AppMethodBeat.o(32268);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(32269);
        if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1) {
            if (this.riy != null) {
                this.riy.cpE();
                this.riy = null;
            } else if (this.yWi == 0 || this.yWi == 2) {
                ak(true, com.tencent.mm.plugin.scanner.d.cgx());
            } else {
                ak(true, false);
            }
            AppMethodBeat.o(32269);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(32269);
        return dispatchKeyEvent;
    }

    private void dGn() {
        AppMethodBeat.i(32270);
        if (dGa().yVN == null || this.yWA) {
            AppMethodBeat.o(32270);
            return;
        }
        String str = "MicroMsg.ImageGalleryUI";
        String str2 = "fadeOutEnterGirdBtn: %B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.yVN.getVisibility() == 0);
        ab.d(str, str2, objArr);
        Animation Pd = Pd(300);
        Pd.setFillAfter(false);
        Pd.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(32215);
                ImageGalleryUI.N(ImageGalleryUI.this);
                ImageGalleryUI.this.yWA = false;
                AppMethodBeat.o(32215);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        dGa().yVN.startAnimation(Pd);
        this.yWA = true;
        AppMethodBeat.o(32270);
    }

    private void dGo() {
        AppMethodBeat.i(32271);
        if (dGa().yVP == null || this.yWB) {
            AppMethodBeat.o(32271);
            return;
        }
        dGa().yVP.startAnimation(Pd(300));
        this.yWB = true;
        AppMethodBeat.o(32271);
    }

    private void dGp() {
        AppMethodBeat.i(32272);
        if (dGa().yVN == null || !this.yWA || dGj()) {
            AppMethodBeat.o(32272);
            return;
        }
        String str = "MicroMsg.ImageGalleryUI";
        String str2 = "fadeInEnterGirdBtn: %B %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(dGa().yVN.getVisibility() == 0);
        objArr[1] = bo.dpG();
        ab.d(str, str2, objArr);
        dGa().yVN.startAnimation(dGr());
        dGb().yVO.startAnimation(dGr());
        this.yWA = false;
        AppMethodBeat.o(32272);
    }

    private void dGq() {
        boolean z = true;
        AppMethodBeat.i(32273);
        if (dGa().yVP == null || !this.yWB) {
            AppMethodBeat.o(32273);
            return;
        }
        String str = "MicroMsg.ImageGalleryUI";
        String str2 = "fadeInPositionAtChatRecordBtn: %B";
        Object[] objArr = new Object[1];
        if (dGa().yVP.getVisibility() != 0) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.d(str, str2, objArr);
        dGa().yVP.startAnimation(dGr());
        this.yWB = false;
        AppMethodBeat.o(32273);
    }

    private static Animation dGr() {
        AppMethodBeat.i(32274);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(150);
        alphaAnimation.setFillAfter(true);
        AppMethodBeat.o(32274);
        return alphaAnimation;
    }

    static Animation Pd(int i) {
        AppMethodBeat.i(32275);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration((long) i);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new AccelerateInterpolator(10.0f));
        AppMethodBeat.o(32275);
        return alphaAnimation;
    }

    public final boolean BI() {
        AppMethodBeat.i(32276);
        dGn();
        dGo();
        AppMethodBeat.o(32276);
        return false;
    }

    private boolean dGs() {
        AppMethodBeat.i(32277);
        if (eN(this.yVQ) == 0 && eN(this.yVR) == 0) {
            AppMethodBeat.o(32277);
            return true;
        }
        AppMethodBeat.o(32277);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dGt() {
        AppMethodBeat.i(32278);
        if (dGs() || this.yTG == null) {
            AppMethodBeat.o(32278);
            return;
        }
        ab.d("MicroMsg.ImageGalleryUI", "jacks start Hide Timer");
        this.yWz.ae(4000, 4000);
        AppMethodBeat.o(32278);
    }

    private void dGu() {
        AppMethodBeat.i(32279);
        ab.d("MicroMsg.ImageGalleryUI", "jacks stop Hide Timer");
        this.yWz.stopTimer();
        AppMethodBeat.o(32279);
    }

    public final void Pe(int i) {
        AppMethodBeat.i(32280);
        hG(true);
        dGm();
        dFY().yVQ.setVisibility(0);
        dFY().yVR.setVisibility(8);
        dFY().yVS.setVisibility(0);
        dFY().yVT.setVisibility(8);
        dGn();
        dGo();
        dFY().yVS.setText(i + "%");
        AppMethodBeat.o(32280);
    }

    public final void dGv() {
        AppMethodBeat.i(32281);
        hG(true);
        dGm();
        dFY().yVQ.setVisibility(0);
        dFY().yVR.setVisibility(8);
        dFY().yVS.setVisibility(0);
        dFY().yVT.setVisibility(8);
        dGn();
        dGo();
        dFY().yVS.setText("0%");
        AppMethodBeat.o(32281);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(32282);
        if (i == 82) {
            AppMethodBeat.o(32282);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(32282);
        return onKeyDown;
    }

    public void finish() {
        AppMethodBeat.i(32283);
        this.yOW.clear();
        super.finish();
        AppMethodBeat.o(32283);
    }

    public final int np(long j) {
        AppMethodBeat.i(32284);
        if (bo.isNullOrNil(this.yWj)) {
            AppMethodBeat.o(32284);
            return 0;
        }
        try {
            int f = u.f(j, this.yWj);
            if (f == -1) {
                this.yWj = null;
                f = 0;
            }
            ab.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", Integer.valueOf(f), this.yWj);
            AppMethodBeat.o(32284);
            return f;
        } catch (Exception e) {
            ab.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + e.toString());
            AppMethodBeat.o(32284);
            return 0;
        }
    }

    public final void nq(long j) {
        AppMethodBeat.i(32285);
        if (bo.isNullOrNil(this.yWj) || j == 0) {
            AppMethodBeat.o(32285);
            return;
        }
        if (u.f(j, this.yWj) == -1) {
            this.yWj = null;
            ab.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", this.yWj);
        }
        AppMethodBeat.o(32285);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(32286);
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            ab.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", Integer.valueOf(hashCode()));
            dGw();
            AppMethodBeat.o(32286);
        } else if (configuration.orientation == 2) {
            ab.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", Integer.valueOf(hashCode()));
            dGx();
            AppMethodBeat.o(32286);
        } else {
            AppMethodBeat.o(32286);
        }
    }

    private void dGw() {
        AppMethodBeat.i(32287);
        ab.i("MicroMsg.ImageGalleryUI", "%d handleVerticalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.osu), Boolean.valueOf(ae.hw(this)), Integer.valueOf(ae.fr(this)));
        if (this.osu && r0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.yVJ.getLayoutParams());
            layoutParams.addRule(12);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, r1);
            this.yVJ.setLayoutParams(layoutParams);
            layoutParams = new RelativeLayout.LayoutParams(this.yVK.getLayoutParams());
            layoutParams.addRule(10);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, layoutParams.bottomMargin);
            this.yVK.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(32287);
    }

    private void dGx() {
        AppMethodBeat.i(32288);
        boolean hw = ae.hw(this);
        int fr = ae.fr(this);
        ab.i("MicroMsg.ImageGalleryUI", "%d handleHorizontalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.osu), Boolean.valueOf(hw), Integer.valueOf(fr));
        if (this.osu && hw) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.yVJ.getLayoutParams());
            layoutParams.addRule(12);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, fr, 0);
            this.yVJ.setLayoutParams(layoutParams);
            layoutParams = new RelativeLayout.LayoutParams(this.yVK.getLayoutParams());
            layoutParams.addRule(10);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, fr, layoutParams.bottomMargin);
            this.yVK.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(32288);
    }

    private boolean av(Activity activity) {
        AppMethodBeat.i(32289);
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        ab.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", Integer.valueOf(hashCode()), Integer.valueOf(defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 0), Integer.valueOf(defaultDisplay.getWidth()), Integer.valueOf(defaultDisplay.getHeight()));
        if ((defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 0) == 0) {
            AppMethodBeat.o(32289);
            return false;
        }
        AppMethodBeat.o(32289);
        return true;
    }

    private void dGy() {
        AppMethodBeat.i(32290);
        bi dFO = this.yTG.dFO();
        com.tencent.mm.at.e d = e.d(dFO);
        ab.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", e.a(dFO, d), Long.valueOf(dFO.field_msgId));
        a(r2, d);
        AppMethodBeat.o(32290);
    }

    private void a(String str, com.tencent.mm.at.e eVar) {
        AppMethodBeat.i(32291);
        String stringExtra = getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        ab.i("MicroMsg.ImageGalleryUI", "edit image path:%s", str);
        intent.putExtra("raw_photo_path", str);
        intent.putExtra("raw_photo_img_id", eVar.fDy);
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("from_scene", 291);
        intent.putExtra("after_photo_edit", "");
        intent.setClass(this, MMNewPhotoEditUI.class);
        startActivityForResult(intent, 4369);
        overridePendingTransition(0, 0);
        AppMethodBeat.o(32291);
    }

    public final int getForceOrientation() {
        return 2;
    }

    static /* synthetic */ void l(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(32296);
        ab.i("MicroMsg.ImageGalleryUI", "%d handle single click event.", Integer.valueOf(imageGalleryUI.hashCode()));
        if (imageGalleryUI.dGj()) {
            try {
                if (imageGalleryUI.yTG.dFP().dGH().yXq.getVisibility() == 0) {
                    ab.d("MicroMsg.ImageGalleryUI", "%d handle single click event, it is loading video, don't show toolbar", Integer.valueOf(imageGalleryUI.hashCode()));
                    AppMethodBeat.o(32296);
                    return;
                }
            } catch (Exception e) {
            }
            if (imageGalleryUI.yWu) {
                imageGalleryUI.dGm();
                AppMethodBeat.o(32296);
                return;
            }
            imageGalleryUI.dGl();
            AppMethodBeat.o(32296);
            return;
        }
        if (imageGalleryUI.yWi != 1) {
            imageGalleryUI.onBackPressed();
        }
        AppMethodBeat.o(32296);
    }

    static /* synthetic */ void q(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(138631);
        if (imageGalleryUI.dGj()) {
            try {
                if (imageGalleryUI.yTG.dFP().dGH().yXo.getVisibility() == 0) {
                    imageGalleryUI.yTG.dFP().dGH().yXo.setVisibility(8);
                    imageGalleryUI.yWx = true;
                }
            } catch (Exception e) {
            }
        }
        if (imageGalleryUI.yWu) {
            imageGalleryUI.dGm();
            imageGalleryUI.yWy = true;
        }
        AppMethodBeat.o(138631);
    }

    static /* synthetic */ void u(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(138632);
        imageGalleryUI.mQT.setGalleryScaleListener(new MMViewPager.b() {
            public final void aa(float f, float f2) {
                float f3 = 1.0f;
                AppMethodBeat.i(32197);
                float height = 1.0f - (f2 / ((float) ImageGalleryUI.this.mQT.getHeight()));
                if (height <= 1.0f) {
                    f3 = height;
                }
                ImageGalleryUI.this.rpz = f3;
                ab.d("MicroMsg.ImageGalleryUI", "alvinluo onGalleryScale tx: %f, ty: %f, scale: %f", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
                ImageGalleryUI.this.contentView = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.yTG, ImageGalleryUI.this.mQT);
                if (ImageGalleryUI.this.contentView != null) {
                    if (f == 0.0f && f2 == 0.0f) {
                        ImageGalleryUI.w(ImageGalleryUI.this);
                    } else {
                        ImageGalleryUI.q(ImageGalleryUI.this);
                    }
                    ImageGalleryUI.this.contentView.setPivotX((float) (ImageGalleryUI.this.mQT.getWidth() / 2));
                    ImageGalleryUI.this.contentView.setPivotY((float) (ImageGalleryUI.this.mQT.getHeight() / 2));
                    ImageGalleryUI.this.contentView.setScaleX(f3);
                    ImageGalleryUI.this.contentView.setScaleY(f3);
                    ImageGalleryUI.this.contentView.setTranslationX(f);
                    ImageGalleryUI.this.contentView.setTranslationY(f2);
                    ImageGalleryUI.this.mmX.setAlpha(f3);
                    AppMethodBeat.o(32197);
                    return;
                }
                ab.d("MicroMsg.ImageGalleryUI", "runDragAnimation contentView is null !!");
                AppMethodBeat.o(32197);
            }

            public final void ab(float f, float f2) {
                AppMethodBeat.i(32198);
                ImageGalleryUI.this.rpA = (int) f;
                ImageGalleryUI.this.rpB = (int) f2;
                AppMethodBeat.o(32198);
            }
        });
        AppMethodBeat.o(138632);
    }

    static /* synthetic */ void w(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(138633);
        if (imageGalleryUI.dGj() && imageGalleryUI.yWx) {
            try {
                if (imageGalleryUI.yTG.dFP().dGH().yXo.getVisibility() == 8) {
                    imageGalleryUI.yTG.dFP().dGH().yXo.setVisibility(0);
                    imageGalleryUI.yWx = false;
                }
            } catch (Exception e) {
            }
        }
        if (imageGalleryUI.yWy) {
            imageGalleryUI.dGl();
            imageGalleryUI.yWy = false;
        }
        AppMethodBeat.o(138633);
    }

    static /* synthetic */ void D(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(32305);
        if (imageGalleryUI.yTG == null || (imageGalleryUI.yTG != null && imageGalleryUI.yTG.Ou(imageGalleryUI.yWs) == null)) {
            AppMethodBeat.o(32305);
            return;
        }
        ab.i("MicroMsg.ImageGalleryUI", "enterPositionAtChatRecords-->talker:%s,magId:%d", imageGalleryUI.talker, Long.valueOf(imageGalleryUI.yTG.Ou(imageGalleryUI.yWs).field_msgId));
        Intent intent = new Intent(imageGalleryUI.mController.ylL, ChattingUI.class);
        intent.putExtra("Chat_User", imageGalleryUI.dGc());
        intent.putExtra("finish_direct", true);
        intent.putExtra("show_search_chat_content_result", true);
        intent.putExtra("key_is_biz_chat", imageGalleryUI.mgP);
        intent.putExtra("key_biz_chat_id", imageGalleryUI.jMj);
        aw.ZK();
        intent.putExtra("need_hight_item", ((Boolean) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_POSITION_AT_CHATRECORD_FIRST_IN_BOOLEAN, Boolean.TRUE)).booleanValue());
        intent.putExtra("msg_local_id", r4);
        intent.putExtra("img_gallery_enter_from_chatting_ui", true);
        imageGalleryUI.startActivity(intent);
        if (imageGalleryUI.yWb) {
            com.tencent.mm.plugin.report.service.h.pYm.a(219, 16, 1, true);
            AppMethodBeat.o(32305);
            return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(219, 17, 1, true);
        AppMethodBeat.o(32305);
    }

    static /* synthetic */ void H(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(138639);
        if (g.Rg().acS() == 6 || g.Rg().acS() == 4) {
            imageGalleryUI.yWi = 1;
            imageGalleryUI.qbx.setVisibility(0);
            imageGalleryUI.yWk.setVisibility(0);
            imageGalleryUI.yWl.setVisibility(0);
            imageGalleryUI.dGi();
            imageGalleryUI.dGu();
            imageGalleryUI.hG(false);
            imageGalleryUI.qfZ.setRepeatMode(1);
            imageGalleryUI.qfZ.setRepeatCount(-1);
            imageGalleryUI.qfZ.start();
            AppMethodBeat.o(138639);
            return;
        }
        h.b((Context) imageGalleryUI, imageGalleryUI.getString(R.string.g5c), "", true);
        imageGalleryUI.dGf();
        AppMethodBeat.o(138639);
    }
}
