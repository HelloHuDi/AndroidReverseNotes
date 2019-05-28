package com.tencent.p177mm.p612ui.chatting.gallery;

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
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.graphics.p234b.C37861c;
import com.tencent.p177mm.graphics.p234b.C42123d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p230g.p231a.C26084ao;
import com.tencent.p177mm.p230g.p231a.C26102cf;
import com.tencent.p177mm.p230g.p231a.C32618pu;
import com.tencent.p177mm.p230g.p231a.C32619pv;
import com.tencent.p177mm.p230g.p231a.C37691an;
import com.tencent.p177mm.p230g.p231a.C41964am;
import com.tencent.p177mm.p230g.p231a.C41968au;
import com.tencent.p177mm.p230g.p231a.C42019kv;
import com.tencent.p177mm.p230g.p231a.C45347np;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p230g.p231a.C9362gs;
import com.tencent.p177mm.p230g.p232b.p233a.C32673k;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMNewPhotoEditUI;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44272g;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.base.MMViewPager;
import com.tencent.p177mm.p612ui.base.MMViewPager.C15525e;
import com.tencent.p177mm.p612ui.base.MMViewPager.C23606c;
import com.tencent.p177mm.p612ui.base.MMViewPager.C23607b;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.base.WxImageView;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.chatting.gallery.C15659h.C15660a;
import com.tencent.p177mm.p612ui.chatting.gallery.C40775c.C40774b;
import com.tencent.p177mm.p612ui.chatting.gallery.C40775c.C40779c;
import com.tencent.p177mm.p612ui.tools.C30759e;
import com.tencent.p177mm.p612ui.tools.C30759e.C24051b;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.comm.p1247a.C20286b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.scanner.C13119a;
import com.tencent.p177mm.plugin.scanner.C43487d;
import com.tencent.p177mm.plugin.scanner.C43488e;
import com.tencent.p177mm.plugin.scanner.p502c.C13123a;
import com.tencent.p177mm.plugin.scanner.p502c.C13123a.C13124a;
import com.tencent.p177mm.plugin.scanner.p502c.C16847b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29970o;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerSeekBar;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

@C18524i
@C5271a(3)
/* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI */
public class ImageGalleryUI extends MMActivity implements OnClickListener, C13124a<String, Integer>, C5015a {
    protected String chatroomName;
    private View contentView;
    public long cvx;
    private int icC;
    private int icD;
    public long jMj;
    Bundle jWy;
    private boolean jYD = false;
    C30759e jYE;
    int kkq = 0;
    int kkr = 0;
    int kks = 0;
    int kkt = 0;
    private C5279d lcJ = new C305099();
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper());
    protected MMViewPager mQT;
    public boolean mgP = false;
    private C4884c mip = new C237711();
    private ImageView mmX;
    private boolean osu;
    private ImageView qbx;
    private ValueAnimator qfZ;
    private C1923n qgg = new C4076819();
    private String riC;
    private boolean riD = false;
    private C4884c riJ = new C4076712();
    private C36356d riy;
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
    public C40775c yTG;
    private final boolean yTR = false;
    private C40774b yVI;
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
    private C13123a<String, Integer> yWf;
    private volatile int yWg;
    private boolean yWh;
    private int yWi = 0;
    private String yWj = null;
    private ImageView yWk;
    private ImageView yWl;
    public C40765a yWm;
    private View yWn;
    private CheckBox yWo;
    private View yWp;
    private boolean yWq = true;
    private C4884c<C32619pv> yWr = new C4076610();
    private int yWs = 0;
    private OnPageChangeListener yWt = new C4075611();
    boolean yWu = false;
    C7564ap yWv = new C7564ap(new C4075713(), false);
    private HashMap<Long, String> yWw = new HashMap();
    private boolean yWx = false;
    private boolean yWy = false;
    private C7564ap yWz;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$20 */
    class C1565020 implements OnClickListener {
        C1565020() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(32220);
            C26084ao c26084ao = new C26084ao();
            c26084ao.ctD.scene = 1;
            c26084ao.ctD.ctE = ImageGalleryUI.this.yWg;
            C4879a.xxA.mo10055m(c26084ao);
            ImageGalleryUI.m70518g(ImageGalleryUI.this);
            ImageGalleryUI.this.yWg = 0;
            AppMethodBeat.m2505o(32220);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$14 */
    class C2376814 implements Runnable {
        C2376814() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32213);
            ImageGalleryUI.this.finish();
            AppMethodBeat.m2505o(32213);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$16 */
    class C2376916 implements AnimationListener {
        C2376916() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(32215);
            ImageGalleryUI.m70482N(ImageGalleryUI.this);
            ImageGalleryUI.this.yWA = false;
            AppMethodBeat.m2505o(32215);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$17 */
    class C2377017 implements AnimationListener {
        C2377017() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(32216);
            if (ImageGalleryUI.m70484P(ImageGalleryUI.this).yVT.getVisibility() != 0) {
                AppMethodBeat.m2505o(32216);
                return;
            }
            ImageGalleryUI.this.dGm();
            ImageGalleryUI.m70484P(ImageGalleryUI.this).yVQ.setVisibility(8);
            ImageGalleryUI.m70479K(ImageGalleryUI.this);
            ImageGalleryUI.m70480L(ImageGalleryUI.this);
            AppMethodBeat.m2505o(32216);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$1 */
    class C237711 extends C4884c<C18346nr> {
        C237711() {
            AppMethodBeat.m2504i(32188);
            this.xxI = C18346nr.class.getName().hashCode();
            AppMethodBeat.m2505o(32188);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(32189);
            C18346nr c18346nr = (C18346nr) c4883b;
            if (ImageGalleryUI.this.riy == null || ImageGalleryUI.this.riz == null) {
                C4990ab.m7412e("MicroMsg.ImageGalleryUI", "not in recoging");
                AppMethodBeat.m2505o(32189);
            } else if (c18346nr == null || !(c18346nr instanceof C18346nr)) {
                C4990ab.m7412e("MicroMsg.ImageGalleryUI", "receive invalid callbak");
                AppMethodBeat.m2505o(32189);
            } else if (c18346nr == null || c18346nr.cJX.filePath.equals(ImageGalleryUI.this.riz)) {
                C4990ab.m7416i("MicroMsg.ImageGalleryUI", "recog result: " + c18346nr.cJX.result);
                if (!C5046bo.isNullOrNil(c18346nr.cJX.result)) {
                    ImageGalleryUI.this.riC = c18346nr.cJX.result;
                    ImageGalleryUI.this.icC = c18346nr.cJX.cvn;
                    ImageGalleryUI.this.icD = c18346nr.cJX.cvo;
                    if (!(ImageGalleryUI.this.riC == null || ImageGalleryUI.this.riy == null)) {
                        ImageGalleryUI.this.riD = true;
                    }
                    ImageGalleryUI.this.mo64284ak(false, false);
                }
                ImageGalleryUI.this.riz = null;
                AppMethodBeat.m2505o(32189);
            } else {
                C4990ab.m7412e("MicroMsg.ImageGalleryUI", "not same filepath");
                AppMethodBeat.m2505o(32189);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$22 */
    class C2377222 implements C15525e {
        C2377222() {
        }

        public final void bcX() {
            AppMethodBeat.m2504i(32222);
            ImageGalleryUI.m70523l(ImageGalleryUI.this);
            AppMethodBeat.m2505o(32222);
        }

        public final void bCN() {
            AppMethodBeat.m2504i(32223);
            ImageGalleryUI.m70524m(ImageGalleryUI.this);
            AppMethodBeat.m2505o(32223);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$2 */
    class C237732 extends AnimatorListenerAdapter {
        C237732() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(32190);
            ImageGalleryUI.this.qbx.setAlpha(0.0f);
            AppMethodBeat.m2505o(32190);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(32191);
            ImageGalleryUI.this.qbx.setAlpha(0.0f);
            AppMethodBeat.m2505o(32191);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$21 */
    class C3050621 implements C40779c {
        C3050621() {
        }

        /* renamed from: pL */
        public final void mo48927pL() {
            AppMethodBeat.m2504i(32221);
            if (ImageGalleryUI.this.yTG == null) {
                AppMethodBeat.m2505o(32221);
                return;
            }
            ImageGalleryUI.m70522k(ImageGalleryUI.this);
            ImageGalleryUI.this.yTG.onPageSelected(100000);
            AppMethodBeat.m2505o(32221);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$9 */
    class C305099 implements C5279d {
        C305099() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(32205);
            C4990ab.m7417i("MicroMsg.ImageGalleryUI", "curTransState %d", Integer.valueOf(ImageGalleryUI.this.yWi));
            C7620bi dFO;
            C26493s ut;
            switch (menuItem.getItemId()) {
                case 0:
                    dFO = ImageGalleryUI.this.yTG.dFO();
                    if (dFO == null || !dFO.bws()) {
                        ImageGalleryUI.this.yTG.mo64303OL(ImageGalleryUI.this.mQT.getCurrentItem());
                        AppMethodBeat.m2505o(32205);
                        return;
                    }
                    ut = C26494u.m42268ut(dFO.field_imgPath);
                    if (ut.status == 199 || ut.status == 199) {
                        ImageGalleryUI.this.yTG.mo64303OL(ImageGalleryUI.this.mQT.getCurrentItem());
                        AppMethodBeat.m2505o(32205);
                        return;
                    }
                    ImageGalleryUI.this.yWj = C26494u.m42249e(dFO.field_msgId, 1);
                    ImageGalleryUI.this.yTG.mo64308OQ(ImageGalleryUI.this.mQT.getCurrentItem());
                    AppMethodBeat.m2505o(32205);
                    return;
                case 1:
                    dFO = ImageGalleryUI.this.yTG.dFO();
                    if (dFO == null || !dFO.bws()) {
                        List arrayList = new ArrayList();
                        arrayList.add(ImageGalleryUI.this.yTG.dFO());
                        C45457b.fRa.mo73252H((C7620bi) arrayList.get(0));
                        C40775c.m70573f(ImageGalleryUI.this.mController.ylL, arrayList);
                        AppMethodBeat.m2505o(32205);
                        return;
                    }
                    ut = C26494u.m42268ut(dFO.field_imgPath);
                    if (ut.status == 199 || ut.status == 199) {
                        List arrayList2 = new ArrayList();
                        arrayList2.add(ImageGalleryUI.this.yTG.dFO());
                        C40775c.m70573f(ImageGalleryUI.this.mController.ylL, arrayList2);
                        AppMethodBeat.m2505o(32205);
                        return;
                    }
                    ImageGalleryUI.this.yWj = C26494u.m42249e(dFO.field_msgId, 2);
                    ImageGalleryUI.this.yTG.mo64308OQ(ImageGalleryUI.this.mQT.getCurrentItem());
                    AppMethodBeat.m2505o(32205);
                    return;
                case 2:
                    if (C25985d.afj("favorite")) {
                        ImageGalleryUI.this.yTG.mo64305ON(ImageGalleryUI.this.mQT.getCurrentItem());
                        AppMethodBeat.m2505o(32205);
                        return;
                    }
                    break;
                case 3:
                    C4990ab.m7416i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
                    C26102cf c26102cf = new C26102cf();
                    c26102cf.cvm.activity = ImageGalleryUI.this;
                    c26102cf.cvm.ctB = ImageGalleryUI.this.riC;
                    c26102cf.cvm.cvn = ImageGalleryUI.this.icC;
                    c26102cf.cvm.cvo = ImageGalleryUI.this.icD;
                    c26102cf.cvm.scene = 37;
                    c26102cf.cvm.cvs = ImageGalleryUI.this.getIntent().getBundleExtra("_stat_obj");
                    ImageGalleryUI.m70496a(ImageGalleryUI.this, c26102cf);
                    ImageGalleryUI.m70505b(ImageGalleryUI.this, c26102cf);
                    C4879a.xxA.mo10055m(c26102cf);
                    AppMethodBeat.m2505o(32205);
                    return;
                case 4:
                    ImageGalleryUI.this.yTG.mo64304OM(ImageGalleryUI.this.mQT.getCurrentItem());
                    AppMethodBeat.m2505o(32205);
                    return;
                case 5:
                    ImageGalleryUI.m70472D(ImageGalleryUI.this);
                    AppMethodBeat.m2505o(32205);
                    return;
                case 6:
                    if (ImageGalleryUI.this.yTG != null) {
                        if (C40775c.m70571c(ImageGalleryUI.this.yTG.dFO())) {
                            ImageGalleryUI.m70473E(ImageGalleryUI.this);
                        }
                        AppMethodBeat.m2505o(32205);
                        return;
                    }
                    break;
                case 7:
                    String F = ImageGalleryUI.m70474F(ImageGalleryUI.this);
                    if ((ImageGalleryUI.this.yWi == 0 || ImageGalleryUI.this.yWi == 2) && !C5046bo.isNullOrNil(F)) {
                        long j;
                        C32673k c32673k = new C32673k();
                        if (ImageGalleryUI.this.yWi == 2) {
                            j = 1;
                        } else {
                            j = 0;
                        }
                        c32673k.cVR = j;
                        c32673k.cVS = 3;
                        c32673k.ajK();
                        ImageGalleryUI.this.yWg = (int) ((((long) C1853r.m3846Yz().hashCode()) + System.currentTimeMillis()) & -1);
                        if (C43488e.cgy().cgD().mo25148Wf(C4995ag.m7428ck(F + C5730e.ata(F))) == null) {
                            ImageGalleryUI.m70476H(ImageGalleryUI.this);
                            C4990ab.m7417i("MicroMsg.ImageGalleryUI", "try to translate img %s, sessionId %d", F, Integer.valueOf(ImageGalleryUI.this.yWg));
                            C32618pu c32618pu = new C32618pu();
                            c32618pu.cLZ.scene = 1;
                            c32618pu.cLZ.filePath = F;
                            c32618pu.cLZ.ctE = ImageGalleryUI.this.yWg;
                            C4879a.xxA.mo10055m(c32618pu);
                            break;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("original_file_path", F);
                        intent.putExtra("msg_id", ImageGalleryUI.this.yTG.mo64312Ou(ImageGalleryUI.this.yWs).field_msgId);
                        ImageGalleryUI.m70497a(ImageGalleryUI.this, TranslationResultUI.class, intent);
                        ImageGalleryUI.this.finish();
                        ImageGalleryUI.this.overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
                        AppMethodBeat.m2505o(32205);
                        return;
                    }
            }
            AppMethodBeat.m2505o(32205);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$11 */
    class C4075611 implements OnPageChangeListener {
        private boolean yWG = false;

        C4075611() {
        }

        public final void onPageScrolled(int i, float f, int i2) {
        }

        public final void onPageSelected(int i) {
            AppMethodBeat.m2504i(32208);
            if (ImageGalleryUI.this.yTG == null) {
                AppMethodBeat.m2505o(32208);
                return;
            }
            if (ImageGalleryUI.this.yWs != i) {
                if (ImageGalleryUI.this.yWi == 1) {
                    ImageGalleryUI.m70518g(ImageGalleryUI.this);
                }
                ImageGalleryUI.this.yWi = 0;
                ImageGalleryUI.this.yWg = 0;
            }
            if (ImageGalleryUI.this.yTG.mo70155Fp(i) == null) {
                C4990ab.m7413e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", Integer.valueOf(i));
            }
            ImageGalleryUI.m70533u(ImageGalleryUI.this);
            ImageGalleryUI.this.yWs = i;
            if (ImageGalleryUI.this.yTG != null) {
                C40775c j = ImageGalleryUI.this.yTG;
                j.yTO.mo27895Du();
                j.yTP.mo48940Du();
                C7620bi Ou = ImageGalleryUI.this.yTG.mo64312Ou(i);
                if (C40775c.m70571c(Ou) || C40775c.m70566bq(Ou)) {
                    View a = ImageGalleryUI.m70492a(ImageGalleryUI.this, ImageGalleryUI.this.yTG, ImageGalleryUI.this.mQT);
                    if (a != null && (a instanceof C44272g)) {
                        if (a instanceof MultiTouchImageView) {
                            ((MultiTouchImageView) a).dzA();
                        } else if (a instanceof WxImageView) {
                            ((WxImageView) a).dzA();
                        }
                    }
                    ((C20286b) C1720g.m3528K(C20286b.class)).mo35522T(Ou);
                }
                if (Ou != null) {
                    ImageGalleryUI.this.mo64297nq(Ou.field_msgId);
                }
                if (ImageGalleryUI.this.yTG != null) {
                    C25822e f = ImageGalleryUI.this.yTG.mo64326f(Ou, false);
                    ImageGalleryUI.this.yTG;
                    if (C40775c.m70564b(Ou, f)) {
                        f = C37478f.m63225a(f);
                        int i2 = f.frO;
                        C4990ab.m7411d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", Integer.valueOf(Math.max(1, (int) (i2 != 0 ? ((((long) f.offset) * 100) / ((long) i2)) - 1 : 0))), Long.valueOf(System.currentTimeMillis()));
                        ImageGalleryUI.this.mo64283Pe(r0);
                    } else if (Ou == null || Ou.bws() || !ImageGalleryUI.this.yTG.mo64315bs(Ou)) {
                        ImageGalleryUI.this.mo64295hG(true);
                    } else {
                        ImageGalleryUI.this.mo64295hG(false);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
                }
                if (Ou == null) {
                    C4990ab.m7412e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = ".concat(String.valueOf(i)));
                } else {
                    ImageGalleryUI.this.mo64285bF(Ou);
                    ImageGalleryUI.m70522k(ImageGalleryUI.this);
                }
            }
            if (ImageGalleryUI.this.yTG != null) {
                ImageGalleryUI.this.yTG.onPageSelected(i);
            }
            AppMethodBeat.m2505o(32208);
        }

        public final void onPageScrollStateChanged(int i) {
            AppMethodBeat.m2504i(32209);
            C4990ab.m7411d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", Integer.valueOf(i));
            if (i == 2) {
                this.yWG = true;
                ImageGalleryUI.m70478J(ImageGalleryUI.this);
                ImageGalleryUI.m70479K(ImageGalleryUI.this);
                ImageGalleryUI.m70480L(ImageGalleryUI.this);
            }
            if (i == 0) {
                if (this.yWG) {
                    ImageGalleryUI.this.dGt();
                }
                this.yWG = false;
            }
            if (ImageGalleryUI.this.yTG != null) {
                C40775c j = ImageGalleryUI.this.yTG;
                if (j.yTN != null) {
                    C40780e c40780e = j.yTN;
                    c40780e.mScrollState = i;
                    if (c40780e.yVa != null) {
                        c40780e.yVa.onPageScrollStateChanged(i);
                    }
                }
            }
            AppMethodBeat.m2505o(32209);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$13 */
    class C4075713 implements C5015a {
        C4075713() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(32212);
            if (ImageGalleryUI.this.yWu) {
                ImageGalleryUI.this.dGm();
            }
            AppMethodBeat.m2505o(32212);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$24 */
    class C4075824 implements Runnable {
        C4075824() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32225);
            if (ImageGalleryUI.this.yTG == null) {
                AppMethodBeat.m2505o(32225);
                return;
            }
            if (C15660a.yVE.mnY && ImageGalleryUI.this.yWo != null) {
                ImageGalleryUI.this.yWo.setChecked(C15660a.yVE.mo27889bE(ImageGalleryUI.this.yTG.dFO()));
                ImageGalleryUI.this.yWp.setOnClickListener(ImageGalleryUI.this);
            }
            if (ImageGalleryUI.this.mQT.getCurrentItem() != 100000) {
                AppMethodBeat.m2505o(32225);
                return;
            }
            ImageGalleryUI.this.dGt();
            C40774b bt = C40775c.m70568bt(ImageGalleryUI.this.yTG.mo64312Ou(100000));
            if (!ImageGalleryUI.this.yWc && bt == C40774b.video) {
                ImageGalleryUI.this.yTG.mo64307OP(100000);
            }
            if (bt == C40774b.sight) {
                ImageGalleryUI.this.yTG.mo64311OT(100000);
            }
            AppMethodBeat.m2505o(32225);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$6 */
    class C407606 implements C24051b {

        /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$6$2 */
        class C407592 implements Runnable {
            C407592() {
            }

            public final void run() {
                AppMethodBeat.m2504i(32200);
                ImageGalleryUI.this.finish();
                ImageGalleryUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.m2505o(32200);
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$6$1 */
        class C407611 implements Runnable {
            C407611() {
            }

            public final void run() {
                AppMethodBeat.m2504i(32199);
                View a = ImageGalleryUI.m70492a(ImageGalleryUI.this, ImageGalleryUI.this.yTG, ImageGalleryUI.this.mQT);
                if (a != null && (a instanceof C44272g)) {
                    if (a instanceof MultiTouchImageView) {
                        ((MultiTouchImageView) a).dzA();
                        AppMethodBeat.m2505o(32199);
                        return;
                    } else if (a instanceof WxImageView) {
                        ((WxImageView) a).dzA();
                    }
                }
                AppMethodBeat.m2505o(32199);
            }
        }

        C407606() {
        }

        public final void onAnimationStart() {
            AppMethodBeat.m2504i(32201);
            ImageGalleryUI.this.suk = true;
            ImageGalleryUI.m70514eO(ImageGalleryUI.this.yVK);
            ImageGalleryUI.m70514eO(ImageGalleryUI.this.yVJ);
            new C7306ak().postDelayed(new C407611(), 20);
            AppMethodBeat.m2505o(32201);
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(32202);
            C4990ab.m7416i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
            ImageGalleryUI.this.mHandler.post(new C407592());
            ImageGalleryUI.this.suk = false;
            AppMethodBeat.m2505o(32202);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$4 */
    class C407634 implements OnPreDrawListener {

        /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$4$1 */
        class C305071 implements C24051b {

            /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$4$1$1 */
            class C305081 implements Runnable {
                C305081() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(32193);
                    if (ImageGalleryUI.this.yWm != null) {
                        ImageGalleryUI.this.yWm.mo48930l(Boolean.FALSE);
                    }
                    AppMethodBeat.m2505o(32193);
                }
            }

            C305071() {
            }

            public final void onAnimationStart() {
                AppMethodBeat.m2504i(32194);
                if (ImageGalleryUI.this.yWm != null) {
                    ImageGalleryUI.this.yWm.mo48930l(Boolean.TRUE);
                }
                AppMethodBeat.m2505o(32194);
            }

            public final void onAnimationEnd() {
                AppMethodBeat.m2504i(32195);
                ImageGalleryUI.this.mHandler.post(new C305081());
                AppMethodBeat.m2505o(32195);
            }
        }

        C407634() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(32196);
            ImageGalleryUI.this.mQT.getViewTreeObserver().removeOnPreDrawListener(this);
            ImageGalleryUI.this.rpw = ImageGalleryUI.this.mQT.getWidth();
            ImageGalleryUI.this.rpx = ImageGalleryUI.this.mQT.getHeight();
            if (ImageGalleryUI.this.yTG.dFO().bwt()) {
                ImageGalleryUI.this.rpx = (int) ((((float) ImageGalleryUI.this.rpw) / ((float) ImageGalleryUI.this.kks)) * ((float) ImageGalleryUI.this.kkt));
            }
            if (ImageGalleryUI.this.yTG.dFO().drE()) {
                C44272g c44272g = (C44272g) ImageGalleryUI.m70492a(ImageGalleryUI.this, ImageGalleryUI.this.yTG, ImageGalleryUI.this.mQT);
                if (c44272g != null) {
                    ImageGalleryUI.this.rpx = (int) (((float) c44272g.getImageHeight()) * (((float) ImageGalleryUI.this.rpw) / ((float) c44272g.getImageWidth())));
                    if (ImageGalleryUI.this.rpx > ImageGalleryUI.this.mQT.getHeight()) {
                        ImageGalleryUI.this.rpx = ImageGalleryUI.this.mQT.getHeight();
                    }
                }
            }
            ImageGalleryUI.this.jYE.mo49168hw(ImageGalleryUI.this.rpw, ImageGalleryUI.this.rpx);
            if (!ImageGalleryUI.this.yWc) {
                ImageGalleryUI.m70528q(ImageGalleryUI.this);
                ImageGalleryUI.this.yWx = false;
                ImageGalleryUI.this.jYE.mo49166a(ImageGalleryUI.this.mQT, ImageGalleryUI.this.mmX, new C305071());
            }
            ImageGalleryUI.m70533u(ImageGalleryUI.this);
            AppMethodBeat.m2505o(32196);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$8 */
    class C407648 implements C15994a {
        C407648() {
        }

        public final void onDismiss() {
            AppMethodBeat.m2504i(32204);
            C37691an c37691an = new C37691an();
            c37691an.ctC.filePath = ImageGalleryUI.this.riz;
            C4879a.xxA.mo10055m(c37691an);
            ImageGalleryUI.this.riy = null;
            ImageGalleryUI.this.riz = null;
            ImageGalleryUI.this.riC = null;
            ImageGalleryUI.this.icC = ImageGalleryUI.this.icD = 0;
            ImageGalleryUI.this.yWh = false;
            ImageGalleryUI.this.riD = false;
            AppMethodBeat.m2505o(32204);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$a */
    public interface C40765a {
        /* renamed from: l */
        void mo48930l(Boolean bool);
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$10 */
    class C4076610 extends C4884c<C32619pv> {
        C4076610() {
            AppMethodBeat.m2504i(32206);
            this.xxI = C32619pv.class.getName().hashCode();
            AppMethodBeat.m2505o(32206);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(32207);
            C32619pv c32619pv = (C32619pv) c4883b;
            C4990ab.m7417i("MicroMsg.ImageGalleryUI", "scanTranslationResult %d, %s", Integer.valueOf(c32619pv.cMa.ctE), Boolean.valueOf(c32619pv.cMa.ctn));
            if (ImageGalleryUI.this.yWg == c32619pv.cMa.ctE) {
                ImageGalleryUI.m70518g(ImageGalleryUI.this);
                if (c32619pv.cMa.ctn) {
                    if (C5730e.m8628ct(c32619pv.cMa.cMb)) {
                        String F = ImageGalleryUI.m70474F(ImageGalleryUI.this);
                        Intent intent = new Intent();
                        intent.putExtra("original_file_path", F);
                        intent.putExtra("msg_id", ImageGalleryUI.this.yTG.mo64312Ou(ImageGalleryUI.this.yWs).field_msgId);
                        ImageGalleryUI.m70506b(ImageGalleryUI.this, TranslationResultUI.class, intent);
                        ImageGalleryUI.this.finish();
                        ImageGalleryUI.this.overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
                        AppMethodBeat.m2505o(32207);
                        return true;
                    }
                    C4990ab.m7421w("MicroMsg.ImageGalleryUI", "trans result path %s not exist!", c32619pv.cMa.cMb);
                }
                ImageGalleryUI.this.yWg = 0;
                C30379h.m48448a(ImageGalleryUI.this, ImageGalleryUI.this.getString(C25738R.string.dyv), "", false, null);
            }
            AppMethodBeat.m2505o(32207);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$12 */
    class C4076712 extends C4884c<C42019kv> {
        C4076712() {
            AppMethodBeat.m2504i(32210);
            this.xxI = C42019kv.class.getName().hashCode();
            AppMethodBeat.m2505o(32210);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(32211);
            C42019kv c42019kv = (C42019kv) c4883b;
            if (c42019kv != null && (c42019kv instanceof C42019kv)) {
                C4990ab.m7417i("MicroMsg.ImageGalleryUI", "notify Event: %d", Integer.valueOf(c42019kv.cGM.cGK));
                if (c42019kv.cGM.activity == ImageGalleryUI.this && c42019kv.cGM.ctB.equals(ImageGalleryUI.this.riC)) {
                    switch (c42019kv.cGM.cGK) {
                        case 3:
                            ImageGalleryUI.this.finish();
                            break;
                    }
                }
                C4990ab.m7412e("MicroMsg.ImageGalleryUI", "not the same");
            } else {
                C4990ab.m7412e("MicroMsg.ImageGalleryUI", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            }
            AppMethodBeat.m2505o(32211);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$19 */
    class C4076819 extends C1924a {

        /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$19$1 */
        class C156491 implements Runnable {
            C156491() {
            }

            public final void run() {
                AppMethodBeat.m2504i(32218);
                if (!(C1720g.m3540Rg().acS() == 6 || C1720g.m3540Rg().acS() == 4 || ImageGalleryUI.this.yWi != 1)) {
                    C30379h.m48461b(ImageGalleryUI.this, ImageGalleryUI.this.getString(C25738R.string.g5c), "", true);
                    ImageGalleryUI.m70518g(ImageGalleryUI.this);
                }
                AppMethodBeat.m2505o(32218);
            }
        }

        C4076819() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(32219);
            C5004al.m7441d(new C156491());
            AppMethodBeat.m2505o(32219);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$23 */
    class C4076923 implements C23606c {
        C4076923() {
        }

        public final void bvE() {
            AppMethodBeat.m2504i(32224);
            if (ImageGalleryUI.this.yWi == 1) {
                AppMethodBeat.m2505o(32224);
            } else if (ImageGalleryUI.this.yWi == 0 || ImageGalleryUI.this.yWi == 2) {
                long j;
                C32673k c32673k = new C32673k();
                if (ImageGalleryUI.this.yWi == 2) {
                    j = 1;
                } else {
                    j = 0;
                }
                c32673k.cVR = j;
                c32673k.cVS = 1;
                c32673k.ajK();
                ImageGalleryUI.this.mo64284ak(true, C43487d.cgx());
                AppMethodBeat.m2505o(32224);
            } else {
                ImageGalleryUI.this.mo64284ak(true, false);
                AppMethodBeat.m2505o(32224);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$25 */
    class C4077025 implements OnTouchListener {
        C4077025() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(32226);
            switch (motionEvent.getAction()) {
                case 0:
                    C32800b y = C37922v.m64076Zp().mo60676y("basescanui@datacenter", true);
                    y.mo53356j("key_basescanui_screen_x", Integer.valueOf((int) motionEvent.getRawX()));
                    y.mo53356j("key_basescanui_screen_y", Integer.valueOf((int) motionEvent.getRawY()));
                    break;
            }
            AppMethodBeat.m2505o(32226);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$5 */
    class C407715 implements C23607b {
        C407715() {
        }

        /* renamed from: aa */
        public final void mo39376aa(float f, float f2) {
            float f3 = 1.0f;
            AppMethodBeat.m2504i(32197);
            float height = 1.0f - (f2 / ((float) ImageGalleryUI.this.mQT.getHeight()));
            if (height <= 1.0f) {
                f3 = height;
            }
            ImageGalleryUI.this.rpz = f3;
            C4990ab.m7411d("MicroMsg.ImageGalleryUI", "alvinluo onGalleryScale tx: %f, ty: %f, scale: %f", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
            ImageGalleryUI.this.contentView = ImageGalleryUI.m70492a(ImageGalleryUI.this, ImageGalleryUI.this.yTG, ImageGalleryUI.this.mQT);
            if (ImageGalleryUI.this.contentView != null) {
                if (f == 0.0f && f2 == 0.0f) {
                    ImageGalleryUI.m70535w(ImageGalleryUI.this);
                } else {
                    ImageGalleryUI.m70528q(ImageGalleryUI.this);
                }
                ImageGalleryUI.this.contentView.setPivotX((float) (ImageGalleryUI.this.mQT.getWidth() / 2));
                ImageGalleryUI.this.contentView.setPivotY((float) (ImageGalleryUI.this.mQT.getHeight() / 2));
                ImageGalleryUI.this.contentView.setScaleX(f3);
                ImageGalleryUI.this.contentView.setScaleY(f3);
                ImageGalleryUI.this.contentView.setTranslationX(f);
                ImageGalleryUI.this.contentView.setTranslationY(f2);
                ImageGalleryUI.this.mmX.setAlpha(f3);
                AppMethodBeat.m2505o(32197);
                return;
            }
            C4990ab.m7410d("MicroMsg.ImageGalleryUI", "runDragAnimation contentView is null !!");
            AppMethodBeat.m2505o(32197);
        }

        /* renamed from: ab */
        public final void mo39377ab(float f, float f2) {
            AppMethodBeat.m2504i(32198);
            ImageGalleryUI.this.rpA = (int) f;
            ImageGalleryUI.this.rpB = (int) f2;
            AppMethodBeat.m2505o(32198);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: y */
    public final /* synthetic */ void mo25150y(Object obj, Object obj2) {
        AppMethodBeat.m2504i(138628);
        String str = (String) obj;
        Integer num = (Integer) obj2;
        C4990ab.m7417i("MicroMsg.ImageGalleryUI", "local translate, img %s, result %d", dGe(), num);
        if (str.equals(dGe()) && num.intValue() != 0 && ((num.intValue() == 1 && !C4988aa.dor().equals("zh_CN")) || (num.intValue() == 2 && !C4988aa.dor().equals("en")))) {
            this.yWh = true;
            mo64284ak(false, false);
        }
        AppMethodBeat.m2505o(138628);
    }

    public ImageGalleryUI() {
        AppMethodBeat.m2504i(32227);
        AppMethodBeat.m2505o(32227);
    }

    /* renamed from: E */
    static /* synthetic */ void m70473E(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(138636);
        imageGalleryUI.dGy();
        AppMethodBeat.m2505o(138636);
    }

    /* renamed from: F */
    static /* synthetic */ String m70474F(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(138637);
        String dGe = imageGalleryUI.dGe();
        AppMethodBeat.m2505o(138637);
        return dGe;
    }

    /* renamed from: J */
    static /* synthetic */ void m70478J(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(32309);
        imageGalleryUI.dGu();
        AppMethodBeat.m2505o(32309);
    }

    /* renamed from: K */
    static /* synthetic */ void m70479K(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(32310);
        imageGalleryUI.dGp();
        AppMethodBeat.m2505o(32310);
    }

    /* renamed from: L */
    static /* synthetic */ void m70480L(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(138641);
        imageGalleryUI.dGq();
        AppMethodBeat.m2505o(138641);
    }

    /* renamed from: N */
    static /* synthetic */ void m70482N(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(138642);
        imageGalleryUI.dGi();
        AppMethodBeat.m2505o(138642);
    }

    /* renamed from: P */
    static /* synthetic */ ImageGalleryUI m70484P(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(138643);
        ImageGalleryUI dFY = imageGalleryUI.dFY();
        AppMethodBeat.m2505o(138643);
        return dFY;
    }

    /* renamed from: b */
    static /* synthetic */ void m70506b(ImageGalleryUI imageGalleryUI, Class cls, Intent intent) {
        AppMethodBeat.m2504i(138640);
        imageGalleryUI.mo17381a(cls, intent);
        AppMethodBeat.m2505o(138640);
    }

    /* renamed from: eO */
    static /* synthetic */ void m70514eO(View view) {
        AppMethodBeat.m2504i(138634);
        ImageGalleryUI.m70500al(view, 8);
        AppMethodBeat.m2505o(138634);
    }

    /* renamed from: g */
    static /* synthetic */ void m70518g(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(32292);
        imageGalleryUI.dGf();
        AppMethodBeat.m2505o(32292);
    }

    /* renamed from: k */
    static /* synthetic */ void m70522k(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(32295);
        imageGalleryUI.dGg();
        AppMethodBeat.m2505o(32295);
    }

    /* renamed from: m */
    static /* synthetic */ void m70524m(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(138629);
        imageGalleryUI.bcW();
        AppMethodBeat.m2505o(138629);
    }

    public void onPause() {
        AppMethodBeat.m2504i(32228);
        C4990ab.m7416i("MicroMsg.ImageGalleryUI", "on pause");
        super.onPause();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        if (!(isFinishing() || this.yTG == null)) {
            C40775c c40775c = this.yTG;
            c40775c.yTO.yWT.sendEmptyMessageDelayed(1, 200);
            c40775c.yTP.mo48940Du();
        }
        if (this.riC != null) {
            C41964am c41964am = new C41964am();
            c41964am.ctA.activity = this;
            c41964am.ctA.ctB = this.riC;
            C4879a.xxA.mo10055m(c41964am);
            this.riC = null;
            this.icD = 0;
            this.icC = 0;
        }
        C42123d.eCO.mo67667Pz();
        if (C37861c.eCI.eCM) {
            C37861c.eCI.stop();
        }
        C29970o.m47417JV(2);
        AppMethodBeat.m2505o(32228);
    }

    /* Access modifiers changed, original: final */
    public final ImageGalleryUI dFY() {
        AppMethodBeat.m2504i(32229);
        if (this.yVQ == null) {
            this.yVQ = ((ViewStub) findViewById(2131824960)).inflate();
            this.yVR = (Button) this.yVQ.findViewById(2131823182);
            this.yVS = (Button) this.yVQ.findViewById(2131824967);
            this.yVT = this.yVQ.findViewById(2131824968);
        }
        AppMethodBeat.m2505o(32229);
        return this;
    }

    /* Access modifiers changed, original: protected|final */
    public final ImageGalleryUI dFZ() {
        AppMethodBeat.m2504i(32230);
        if (this.yVU == null) {
            this.yVU = ((ViewStub) findViewById(2131822904)).inflate();
            this.yVV = (VideoPlayerSeekBar) findViewById(2131822905);
            this.yVV.setPlayBtnOnClickListener(this);
        }
        AppMethodBeat.m2505o(32230);
        return this;
    }

    private ImageGalleryUI dGa() {
        AppMethodBeat.m2504i(32231);
        if (this.yVN == null) {
            this.yVN = (RelativeLayout) ((ViewStub) findViewById(2131824957)).inflate();
        }
        AppMethodBeat.m2505o(32231);
        return this;
    }

    private ImageGalleryUI dGb() {
        AppMethodBeat.m2504i(32232);
        if (this.yVO == null) {
            this.yVO = (RelativeLayout) ((ViewStub) findViewById(2131824961)).inflate();
            this.yVO.findViewById(2131824965).setOnClickListener(this);
        }
        AppMethodBeat.m2505o(32232);
        return this;
    }

    /* renamed from: al */
    private static void m70500al(View view, int i) {
        AppMethodBeat.m2504i(32233);
        if (view != null) {
            view.setVisibility(i);
        }
        AppMethodBeat.m2505o(32233);
    }

    /* renamed from: eN */
    private static int m70513eN(View view) {
        AppMethodBeat.m2504i(32234);
        if (view != null) {
            int visibility = view.getVisibility();
            AppMethodBeat.m2505o(32234);
            return visibility;
        }
        AppMethodBeat.m2505o(32234);
        return 8;
    }

    public final boolean noActionBar() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(32235);
        requestWindowFeature(1);
        long currentTimeMillis = System.currentTimeMillis();
        this.yWq = true;
        super.onCreate(bundle);
        if (C1443d.m3068iW(19)) {
            getWindow().setFlags(201327616, 201327616);
            this.osu = true;
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.osu = false;
        }
        dya();
        initView();
        this.jWy = bundle;
        C4879a.xxA.mo10052c(this.mip);
        C4879a.xxA.mo10052c(this.riJ);
        C4879a.xxA.mo10052c(this.yWr);
        this.suk = false;
        C4990ab.m7411d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(32235);
    }

    public void onResume() {
        AppMethodBeat.m2504i(32236);
        super.onResume();
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        if (!(this.yWq || this.yTG == null)) {
            mo64281Pa(this.mQT.getCurrentItem());
        }
        this.yWq = false;
        if (this.yTG != null) {
            this.yTG.dFQ();
        }
        C1720g.m3535RO().mo5187a(this.qgg);
        C29970o.m47417JV(1);
        AppMethodBeat.m2505o(32236);
    }

    public void onStart() {
        AppMethodBeat.m2504i(32237);
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
                        C7620bi Ou = this.yTG.mo64312Ou(this.mQT.getCurrentItem());
                        if (Ou != null) {
                            C41968au c41968au = new C41968au();
                            c41968au.ctR.csG = Ou;
                            C4879a.xxA.mo10055m(c41968au);
                            this.kks = c41968au.ctS.ctV;
                            this.kkt = c41968au.ctS.ctW;
                            this.kkr = c41968au.ctS.ctT;
                            this.kkq = c41968au.ctS.ctU;
                        }
                    }
                    this.jYE.mo49164L(this.kkr, this.kkq, this.kks, this.kkt);
                    if (bundle == null) {
                        this.mQT.getViewTreeObserver().addOnPreDrawListener(new C407634());
                    }
                }
            }
        }
        super.onStart();
        AppMethodBeat.m2505o(32237);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(32238);
        C4990ab.m7417i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", Integer.valueOf(hashCode()));
        try {
            if (this.yTG != null) {
                this.yTG.detach();
                this.yTG = null;
            }
            dGu();
            this.yWv.stopTimer();
            chI();
            this.qfZ.removeAllUpdateListeners();
            C4879a.xxA.mo10053d(this.mip);
            C4879a.xxA.mo10053d(this.riJ);
            C4879a.xxA.mo10053d(this.yWr);
            C1720g.m3535RO().mo5188b(this.qgg);
            if (this.yVV != null) {
                this.yVV.setPlayBtnOnClickListener(null);
            }
            this.yVV = null;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ImageGalleryUI", e, "", new Object[0]);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(32238);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(32239);
        C4990ab.m7416i("MicroMsg.ImageGalleryUI", "onBackPressed");
        if (this.yWb) {
            m70485Pb(1);
            AppMethodBeat.m2505o(32239);
            return;
        }
        try {
            C15660a.yVE.detach();
            bcW();
            AppMethodBeat.m2505o(32239);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ImageGalleryUI", e.getMessage());
            finish();
            AppMethodBeat.m2505o(32239);
        }
    }

    private String dGc() {
        AppMethodBeat.m2504i(32240);
        String str;
        if (this.chatroomName == null || this.chatroomName.length() <= 0) {
            str = this.talker;
            AppMethodBeat.m2505o(32240);
            return str;
        }
        str = this.chatroomName;
        AppMethodBeat.m2505o(32240);
        return str;
    }

    public final void initView() {
        AppMethodBeat.m2504i(32241);
        this.jYE = new C30759e(this.mController.ylL);
        this.yWz = new C7564ap(this, false);
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
            Assert.assertTrue("MicroMsg.ImageGalleryUI initView, talker is null, stack = " + C5046bo.dpG(), this.talker != null);
        }
        this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
        this.yWc = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        this.yWj = getIntent().getStringExtra("img_gallery_enter_video_opcode");
        boolean booleanExtra = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
        String stringExtra = getIntent().getStringExtra("img_gallery_directly_send_name");
        this.yWk = (ImageView) findViewById(2131824953);
        this.yWl = (ImageView) findViewById(2131824955);
        LayoutParams layoutParams = (LayoutParams) this.yWl.getLayoutParams();
        layoutParams.bottomMargin += C5222ae.m7944fr(this);
        this.yWl.setLayoutParams(layoutParams);
        this.yWl.setOnClickListener(new C1565020());
        dGd();
        this.cvx = getIntent().getLongExtra("img_gallery_msg_id", 0);
        long longExtra = getIntent().getLongExtra("img_gallery_msg_svr_id", 0);
        if (this.cvx > 0 || longExtra != 0) {
            if (this.cvx == 0) {
                C9638aw.m17190ZK();
                this.cvx = C18628c.m29080XO().mo15241Q(dGc(), longExtra).field_msgId;
            }
            C9638aw.m17190ZK();
            C7620bi jf = C18628c.m29080XO().mo15340jf(this.cvx);
            if (jf.field_msgId <= 0) {
                C4990ab.m7412e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.cvx + ", msgSvrId = " + longExtra + ", stack = " + C5046bo.dpG());
                finish();
                AppMethodBeat.m2505o(32241);
                return;
            }
            this.yTG = new C40775c(this, this.cvx, dGc(), this.mgP, this.jMj, booleanExtra, stringExtra, Boolean.valueOf(this.yWc));
            this.yTG.yTR = false;
            this.yTG.yTL = getIntent().getBooleanExtra("start_chatting_ui", true);
            this.yTG.yTQ = new C3050621();
            this.yVJ = (RelativeLayout) findViewById(2131823181);
            this.yVK = (RelativeLayout) findViewById(2131824956);
            int paddingTop = this.yVK.getPaddingTop();
            if (C5222ae.m7950hD(this.mController.ylL)) {
                paddingTop += C5222ae.m7949hC(this.mController.ylL);
            }
            this.yVK.setPadding(0, paddingTop, 0, 0);
            this.yVM = (ImageView) findViewById(2131824958);
            this.yVM.setOnClickListener(this);
            if (m70501av(this)) {
                dGw();
            } else {
                dGx();
            }
            this.mmX = (ImageView) findViewById(2131822079);
            this.mmX.setLayerType(2, null);
            this.mQT = (MMViewPager) findViewById(2131822081);
            this.mQT.setLayerType(2, null);
            this.mQT.setVerticalFadingEdgeEnabled(false);
            this.mQT.setHorizontalFadingEdgeEnabled(false);
            this.mQT.setSingleClickOverListener(new C2377222());
            if (!this.yVL) {
                this.mQT.setOnPageChangeListener(this.yWt);
                this.mQT.setLongClickOverListener(new C4076923());
            }
            this.mQT.setOffscreenPageLimit(1);
            this.mQT.setAdapter(this.yTG);
            mo64281Pa(100000);
            this.mQT.setCurrentItem(100000);
            this.mQT.postDelayed(new C4075824(), 0);
            if (C15660a.yVE.mnY) {
                this.yWn = ((ViewStub) findViewById(2131824952)).inflate();
                this.yWn.setVisibility(0);
                this.yWo = (CheckBox) this.yWn.findViewById(2131823909);
                this.yWp = this.yWn.findViewById(2131823910);
            }
            this.yVY = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
            C25822e f = this.yTG.mo64326f(jf, true);
            if (f == null) {
                C4990ab.m7413e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", Boolean.valueOf(this.yVY));
            }
            if (this.yVY && f != null && f.agP()) {
                dGy();
                this.yVY = false;
            } else if (this.yVY) {
                C4990ab.m7420w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
            }
            this.mQT.setOnTouchListener(new C4077025());
            AppMethodBeat.m2505o(32241);
            return;
        }
        C4990ab.m7412e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.cvx + ", msgSvrId = " + longExtra + ", stack = " + C5046bo.dpG());
        finish();
        AppMethodBeat.m2505o(32241);
    }

    private void dGd() {
        AppMethodBeat.m2504i(32242);
        this.qbx = (ImageView) findViewById(2131824954);
        this.qfZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.qfZ.setDuration(5000);
        this.qfZ.addListener(new C237732());
        final int height = getWindowManager().getDefaultDisplay().getHeight();
        this.qfZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.m2504i(32192);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue <= 0.1f) {
                    ImageGalleryUI.this.qbx.setAlpha(floatValue * 10.0f);
                } else if (floatValue >= 0.9f) {
                    ImageGalleryUI.this.qbx.setAlpha((1.0f - floatValue) * 10.0f);
                }
                ImageGalleryUI.this.qbx.setTranslationY(floatValue * ((float) (height - ImageGalleryUI.this.qbx.getHeight())));
                AppMethodBeat.m2505o(32192);
            }
        });
        AppMethodBeat.m2505o(32242);
    }

    /* renamed from: a */
    private View m70493a(C40775c c40775c, MMViewPager mMViewPager) {
        View view;
        AppMethodBeat.m2504i(32243);
        String str = "MicroMsg.ImageGalleryUI";
        String str2 = "get current view adapter is null %b, gallery is null %b";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(c40775c == null);
        objArr[1] = Boolean.valueOf(mMViewPager == null);
        C4990ab.m7411d(str, str2, objArr);
        if (c40775c == null || mMViewPager == null) {
            C4990ab.m7421w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", Integer.valueOf(hashCode()));
            view = null;
        } else if (c40775c.dFO() == null) {
            AppMethodBeat.m2505o(32243);
            return null;
        } else if (c40775c.dFO().drE() || c40775c.dFO().dtA()) {
            view = c40775c.mo64332wx(mMViewPager.getCurrentItem());
            if (view == null) {
                view = c40775c.mo64333wy(mMViewPager.getCurrentItem());
            }
        } else {
            if (c40775c.dFO().bws() || c40775c.dFO().bwt()) {
                view = c40775c.mo64306OO(mMViewPager.getCurrentItem());
            }
            view = null;
        }
        AppMethodBeat.m2505o(32243);
        return view;
    }

    private void bcW() {
        AppMethodBeat.m2504i(32244);
        if (this.suk || this.yTG == null) {
            C4990ab.m7416i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
            AppMethodBeat.m2505o(32244);
            return;
        }
        dGf();
        if (this.yVL) {
            finish();
            C5274b.m8053hL(this.mController.ylL);
            AppMethodBeat.m2505o(32244);
            return;
        }
        int i;
        int i2;
        int i3;
        C4990ab.m7416i("MicroMsg.ImageGalleryUI", "runExitAnimation");
        int width = this.mQT.getWidth() / 2;
        int height = this.mQT.getHeight() / 2;
        this.yTG.dFM();
        if (this.yWb) {
            C9362gs c9362gs = new C9362gs();
            c9362gs.cBr.cvx = this.yTG.mo64312Ou(this.mQT.getCurrentItem()).field_msgId;
            C4879a.xxA.mo10055m(c9362gs);
            i = c9362gs.cBs.ctV;
            i2 = c9362gs.cBs.ctW;
            width = c9362gs.cBs.ctT;
            i3 = c9362gs.cBs.ctU;
        } else {
            C7620bi Ou = this.yTG.mo64312Ou(this.mQT.getCurrentItem());
            if (Ou != null) {
                C41968au c41968au = new C41968au();
                c41968au.ctR.csG = Ou;
                C4879a.xxA.mo10055m(c41968au);
                i = c41968au.ctS.ctV;
                i2 = c41968au.ctS.ctW;
                width = c41968au.ctS.ctT;
                height = c41968au.ctS.ctU;
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
                        this.yVW = C1338a.fromDPToPix(this.mController.ylL, 5);
                    }
                    if (Ou.field_isSend == 1) {
                        this.yVX = C1338a.fromDPToPix(this.mController.ylL, 5);
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
                C44272g c44272g = (C44272g) m70493a(this.yTG, this.mQT);
                if (c44272g != null) {
                    this.rpx = (int) (((float) c44272g.getImageHeight()) * (((float) this.rpw) / ((float) c44272g.getImageWidth())));
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
        this.jYE.mo49169hx(this.yVW, this.yVX);
        this.jYE.zFd = this.rpy;
        this.jYE.mo49168hw(this.rpw, this.rpx);
        this.jYE.mo49164L(width, i3, i, i2);
        View view = this.mQT;
        View a = m70493a(this.yTG, this.mQT);
        if (a == null) {
            a = view;
        } else if (((double) this.rpz) != 1.0d) {
            this.jYE.zEZ = 1.0f / this.rpz;
            if (!(this.rpA == 0 && this.rpB == 0)) {
                this.jYE.mo49170hy(((int) (((float) (this.mQT.getWidth() / 2)) * (1.0f - this.rpz))) + this.rpA, (int) (((float) ((this.mQT.getHeight() / 2) + this.rpB)) - (((float) (this.rpx / 2)) * this.rpz)));
            }
        }
        this.jYE.mo49167a(a, this.mmX, new C407606(), null);
        AppMethodBeat.m2505o(32244);
    }

    private String dGe() {
        AppMethodBeat.m2504i(32245);
        C7620bi Ou = this.yTG.mo64312Ou(this.yWs);
        String str = null;
        if (C40775c.m70571c(Ou)) {
            C25822e f = this.yTG.mo64326f(Ou, true);
            if (f != null) {
                str = C40780e.m70601a(Ou, f);
            }
        } else if (C40775c.m70567br(Ou)) {
            str = C40775c.m70572e(Ou);
        }
        AppMethodBeat.m2505o(32245);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ak */
    public final void mo64284ak(boolean z, boolean z2) {
        AppMethodBeat.m2504i(138626);
        if (this.yTG == null) {
            AppMethodBeat.m2505o(138626);
        } else if (this.yWs < 0) {
            AppMethodBeat.m2505o(138626);
        } else {
            C7620bi Ou = this.yTG.mo64312Ou(this.yWs);
            int bA = this.yTG.yTN.mo64336bA(Ou);
            if (bA == 5 || bA == 6) {
                C4990ab.m7420w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
                AppMethodBeat.m2505o(138626);
            } else if (this.yTG.mo64315bs(Ou)) {
                C4990ab.m7420w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
                AppMethodBeat.m2505o(138626);
            } else if (C40775c.m70574f(Ou) && C15663j.m23963bG(Ou) == null) {
                C4990ab.m7420w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
                AppMethodBeat.m2505o(138626);
            } else {
                final ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(getString(C25738R.string.dr8));
                if (C25985d.afj("favorite")) {
                    arrayList.add(Integer.valueOf(2));
                    arrayList2.add(getString(C25738R.string.dcq));
                }
                if (C40775c.m70571c(Ou) || C40775c.m70567br(Ou)) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(C25738R.string.dwx));
                } else if (C40775c.m70574f(Ou) || C40775c.m70565bp(Ou)) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(C25738R.string.dx0));
                } else {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(C25738R.string.dwz));
                }
                if (this.yWh && !C5046bo.isNullOrNil(dGe())) {
                    long j;
                    arrayList.add(Integer.valueOf(7));
                    arrayList2.add(getString(C25738R.string.g6e));
                    C32673k c32673k = new C32673k();
                    if (this.yWi == 2) {
                        j = 1;
                    } else {
                        j = 0;
                    }
                    c32673k.cVR = j;
                    c32673k.cVS = 2;
                    c32673k.ajK();
                }
                if (C40775c.m70571c(Ou) || C40775c.m70565bp(Ou)) {
                    C9321dq c9321dq = new C9321dq();
                    c9321dq.cxc.cvx = Ou.field_msgId;
                    C4879a.xxA.mo10055m(c9321dq);
                    if (c9321dq.cxd.cwB || C46494g.m87731ad(this.mController.ylL, Ou.getType())) {
                        arrayList.add(Integer.valueOf(4));
                        arrayList2.add(getString(C25738R.string.amc));
                    }
                }
                if (C40775c.m70571c(Ou)) {
                    if (this.yWe == 1) {
                        bA = 0;
                    } else {
                        bA = 1;
                    }
                    if (bA != 0) {
                        arrayList.add(Integer.valueOf(6));
                        arrayList2.add(getString(C25738R.string.al9));
                    }
                }
                if (this.riC != null && ary(this.riC)) {
                    arrayList.add(Integer.valueOf(3));
                    if (C13119a.m21149BR(this.icC)) {
                        arrayList2.add(getString(C25738R.string.diy));
                    } else if (C13119a.m21150ba(this.icC, this.riC)) {
                        arrayList2.add(getString(C25738R.string.diz));
                    } else if (C13119a.m21148BQ(this.icC)) {
                        arrayList2.add(getString(C25738R.string.dix));
                    } else {
                        arrayList2.add(getString(C25738R.string.diy));
                    }
                }
                if (C1831bh.m3770o(Ou)) {
                    arrayList.clear();
                    arrayList2.clear();
                }
                if (this.yWd || this.yWe == 1 || this.yRs || this.mgP || C15660a.yVE.mnY) {
                    bA = 0;
                } else {
                    bA = 1;
                }
                if (bA != 0) {
                    arrayList.add(Integer.valueOf(5));
                    arrayList2.add(getString(C25738R.string.al8));
                }
                if (this.riy == null) {
                    this.riy = new C36356d(this.mController.ylL, 1, false);
                }
                this.riy.rBl = new C36073c() {
                    /* renamed from: a */
                    public final void mo5746a(C44273l c44273l) {
                        AppMethodBeat.m2504i(32203);
                        c44273l.clear();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < arrayList.size()) {
                                c44273l.mo70068e(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                                i = i2 + 1;
                            } else {
                                AppMethodBeat.m2505o(32203);
                                return;
                            }
                        }
                    }
                };
                if (arrayList.size() == 0) {
                    AppMethodBeat.m2505o(138626);
                    return;
                }
                this.riy.rBm = this.lcJ;
                this.riy.zQf = new C407648();
                this.riy.cpD();
                String dGe = dGe();
                if (!C5046bo.isNullOrNil(dGe)) {
                    if (z && C9638aw.m17182Rg().acS() != 0) {
                        C45347np c45347np = new C45347np();
                        c45347np.cJU.filePath = dGe;
                        this.riz = dGe;
                        C4879a.xxA.mo10055m(c45347np);
                    }
                    if (z2) {
                        if (this.yWf == null) {
                            this.yWf = new C16847b(this);
                        }
                        this.yWf.mo25149a(dGe, this);
                    }
                }
                AppMethodBeat.m2505o(138626);
            }
        }
    }

    private boolean ary(String str) {
        AppMethodBeat.m2504i(32247);
        if (this.yWe == 1) {
            AppMethodBeat.m2505o(32247);
            return false;
        } else if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(32247);
            return false;
        } else if (this.yWd) {
            String[] split = ((String) C1720g.m3536RP().mo5239Ry().get(C5127a.APPBRAND_BLOCK_QRCODE_PREFIX_STRING_SYNC, (Object) "")).split("\\|");
            if (split != null && split.length > 0) {
                int length = split.length;
                int i = 0;
                while (i < length) {
                    String str2 = split[i];
                    if (C5046bo.isNullOrNil(str2) || !str.startsWith(str2)) {
                        i++;
                    } else {
                        C4990ab.m7417i("MicroMsg.ImageGalleryUI", "curDealQBarStr:%s, blockQrcodeStr:%s", str, str2);
                        AppMethodBeat.m2505o(32247);
                        return false;
                    }
                }
            }
            AppMethodBeat.m2505o(32247);
            return true;
        } else {
            AppMethodBeat.m2505o(32247);
            return true;
        }
    }

    private void dGf() {
        AppMethodBeat.m2504i(32248);
        this.yWi = 0;
        this.qbx.setVisibility(8);
        this.yWk.setVisibility(8);
        this.yWl.setVisibility(8);
        dGh();
        dGt();
        mo64295hG(true);
        chI();
        AppMethodBeat.m2505o(32248);
    }

    private void chI() {
        AppMethodBeat.m2504i(32250);
        this.qfZ.setRepeatMode(1);
        this.qfZ.setRepeatCount(0);
        this.qfZ.end();
        AppMethodBeat.m2505o(32250);
    }

    /* renamed from: hG */
    public final void mo64295hG(boolean z) {
        int i = 8;
        AppMethodBeat.m2504i(32251);
        if (this.yVJ == null) {
            AppMethodBeat.m2505o(32251);
        } else if (!(z && this.yVJ.getVisibility() == 0) && (z || this.yVJ.getVisibility() != 8)) {
            RelativeLayout relativeLayout = this.yVJ;
            if (z) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
            this.yVJ.startAnimation(AnimationUtils.loadAnimation(this.mController.ylL, z ? C25738R.anim.f8288n : C25738R.anim.f8289o));
            AppMethodBeat.m2505o(32251);
        } else {
            AppMethodBeat.m2505o(32251);
        }
    }

    public final int getLayoutId() {
        return 2130969843;
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.m2504i(32252);
        super.onCreateBeforeSetContentView();
        AppMethodBeat.m2505o(32252);
    }

    private void dGg() {
        AppMethodBeat.m2504i(32253);
        if (this.yTG == null || this.yVL) {
            AppMethodBeat.m2505o(32253);
        } else if (!this.yTG.dFN()) {
            AppMethodBeat.m2505o(32253);
        } else if (dGa().yVN == null) {
            AppMethodBeat.m2505o(32253);
        } else if (C15660a.yVE.mnY) {
            dGi();
            AppMethodBeat.m2505o(32253);
        } else if (this.yRs) {
            dGi();
            AppMethodBeat.m2505o(32253);
        } else {
            C4990ab.m7411d("MicroMsg.ImageGalleryUI", "%d show enter grid is video %b", Integer.valueOf(hashCode()), Boolean.valueOf(dGj()));
            if (this.yWi == 0 || this.yWi == 2) {
                dGh();
            }
            dGt();
            AppMethodBeat.m2505o(32253);
        }
    }

    private void dGh() {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(32254);
        ImageGalleryUI.m70500al(dGa().yVN, this.yWa ? 0 : 8);
        C7620bi c7620bi = null;
        if (this.yTG != null) {
            c7620bi = this.yTG.dFO();
        }
        int i3 = 1;
        if (this.yVI != C40774b.image) {
            i3 = 0;
        }
        if (c7620bi == null || !C1831bh.m3770o(c7620bi)) {
            i = i3;
        } else {
            i = 0;
        }
        RelativeLayout relativeLayout = dGb().yVO;
        if (i == 0) {
            i2 = 8;
        }
        ImageGalleryUI.m70500al(relativeLayout, i2);
        AppMethodBeat.m2505o(32254);
    }

    private void dGi() {
        AppMethodBeat.m2504i(32255);
        ImageGalleryUI.m70500al(dGa().yVN, 8);
        ImageGalleryUI.m70500al(dGb().yVO, 8);
        AppMethodBeat.m2505o(32255);
    }

    /* renamed from: f */
    private static boolean m70517f(C7620bi c7620bi, C25822e c25822e) {
        AppMethodBeat.m2504i(32256);
        if (c25822e == null) {
            AppMethodBeat.m2505o(32256);
            return false;
        }
        try {
            if (C40775c.m70570c(c7620bi, c25822e) == 0 && c25822e.agQ() && !c7620bi.dtH()) {
                AppMethodBeat.m2505o(32256);
                return true;
            }
        } catch (NullPointerException e) {
            C4990ab.m7412e("MicroMsg.ImageGalleryUI", "error:".concat(String.valueOf(e)));
        }
        AppMethodBeat.m2505o(32256);
        return false;
    }

    /* renamed from: Pa */
    public final void mo64281Pa(int i) {
        AppMethodBeat.m2504i(32257);
        mo64285bF(this.yTG.mo64312Ou(i));
        AppMethodBeat.m2505o(32257);
    }

    private boolean dGj() {
        if (this.yVI == C40774b.video) {
            return true;
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dGk() {
        AppMethodBeat.m2504i(32258);
        if (this.yWu) {
            this.yWv.mo16770ae(4000, 4000);
        }
        AppMethodBeat.m2505o(32258);
    }

    public final void dGl() {
        AppMethodBeat.m2504i(32259);
        C4990ab.m7416i("MicroMsg.ImageGalleryUI", "show video tool bar");
        mo64295hG(true);
        ImageGalleryUI.m70529qw(true);
        ImageGalleryUI.m70500al(this.yVQ, 8);
        ImageGalleryUI.m70500al(dFZ().yVU, 0);
        ImageGalleryUI.m70500al(this.yVM, 0);
        dGa().yVN.clearAnimation();
        if (this.yVL) {
            dGi();
        } else if (this.yWi == 0 || this.yWi == 2) {
            dGh();
        }
        dGu();
        this.yWu = true;
        dGk();
        AppMethodBeat.m2505o(32259);
    }

    public final void dGm() {
        AppMethodBeat.m2504i(32260);
        C4990ab.m7416i("MicroMsg.ImageGalleryUI", "hide video tool bar");
        ImageGalleryUI.m70529qw(false);
        ImageGalleryUI.m70500al(dFZ().yVU, 8);
        ImageGalleryUI.m70500al(this.yVM, 8);
        if (dGj()) {
            dGu();
            dGi();
        }
        this.yWu = false;
        AppMethodBeat.m2505o(32260);
    }

    /* renamed from: qw */
    private static void m70529qw(boolean z) {
        AppMethodBeat.m2504i(32261);
        C4990ab.m7411d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", Boolean.valueOf(z));
        AppMethodBeat.m2505o(32261);
    }

    /* renamed from: bF */
    public final synchronized void mo64285bF(C7620bi c7620bi) {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(32262);
            this.yVI = C40775c.m70568bt(c7620bi);
            C4990ab.m7416i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType : " + this.yVI);
            if (C15660a.yVE.mnY && this.yWo != null) {
                this.yWo.setChecked(C15660a.yVE.mo27889bE(c7620bi));
            }
            switch (this.yVI) {
                case video:
                    dGm();
                    ImageGalleryUI.m70500al(this.yVQ, 8);
                    mo64299qx(true);
                    C26493s bG = C15663j.m23963bG(c7620bi);
                    if (bG != null) {
                        dFZ().yVV.setVideoTotalTime(bG.fXd);
                        try {
                            if (!(this.yTG.dFP() == null || this.yTG.dFP().yXp == null)) {
                                i = this.yTG.dFP().yXp.getCurrentPosition() / 1000;
                            }
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.ImageGalleryUI", e, "", new Object[0]);
                        }
                        dFZ().yVV.seek(i);
                        AppMethodBeat.m2505o(32262);
                        break;
                    }
                    AppMethodBeat.m2505o(32262);
                    break;
                case image:
                    C25822e f = this.yTG.mo64326f(c7620bi, false);
                    dGm();
                    dGg();
                    if (f != null) {
                        this.mQT.getCurrentItem();
                        if (ImageGalleryUI.m70517f(c7620bi, f) && !c7620bi.dtH() && f.agP()) {
                            dFY().yVR.setVisibility(0);
                            dFY().yVS.setVisibility(8);
                            dFY().yVT.setVisibility(8);
                            String str = (String) this.yWw.get(Long.valueOf(f.fDy));
                            if (str == null) {
                                Map z = C5049br.m7595z(f.fDK, "msg");
                                if (z == null) {
                                    C4990ab.m7413e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", f.fDK);
                                    i = -1;
                                } else {
                                    i = C5046bo.getInt((String) z.get(".msg.img.$hdlength"), 0);
                                    if (i == 0) {
                                        i = C5046bo.getInt((String) z.get(".msg.img.$tphdlength"), 0);
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
                            dFY().yVR.setText(getString(C25738R.string.b3v, new Object[]{str}));
                            ImageGalleryUI.m70500al(this.yVQ, 0);
                        } else {
                            ImageGalleryUI.m70500al(this.yVQ, 8);
                        }
                        if (!this.yVY || !f.agP() || this.yTG.dFO() == null || c7620bi.field_msgId != this.yTG.dFO().field_msgId) {
                            C7620bi dFO = this.yTG.dFO();
                            String str2 = "MicroMsg.ImageGalleryUI";
                            String str3 = "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s";
                            Object[] objArr = new Object[4];
                            objArr[0] = Boolean.valueOf(this.yVY);
                            objArr[1] = Long.valueOf(c7620bi.field_msgId);
                            objArr[2] = dFO == null ? BuildConfig.COMMAND : Long.valueOf(dFO.field_msgId);
                            objArr[3] = Boolean.valueOf(f.agP());
                            C4990ab.m7421w(str2, str3, objArr);
                            AppMethodBeat.m2505o(32262);
                            break;
                        }
                        C4990ab.m7417i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", Long.valueOf(c7620bi.field_msgId));
                        dGy();
                        this.yVY = false;
                        AppMethodBeat.m2505o(32262);
                        break;
                    }
                    C4990ab.m7420w("MicroMsg.ImageGalleryUI", "updateFooterInfo img info is null");
                    AppMethodBeat.m2505o(32262);
                    break;
                case appimage:
                    dGm();
                    dGg();
                    AppMethodBeat.m2505o(32262);
                    break;
                case sight:
                    dGm();
                    dGg();
                    ImageGalleryUI.m70500al(this.yVQ, 8);
                    this.yTG.mo64311OT(this.mQT.getCurrentItem());
                    break;
            }
            AppMethodBeat.m2505o(32262);
        }
    }

    /* renamed from: Pb */
    private void m70485Pb(int i) {
        AppMethodBeat.m2504i(32263);
        C4990ab.m7416i("MicroMsg.ImageGalleryUI", "enterGrid source : ".concat(String.valueOf(i)));
        if (this.yTG == null) {
            C4990ab.m7420w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
            AppMethodBeat.m2505o(32263);
            return;
        }
        C7060h.pYm.mo8378a(219, 13, 1, true);
        int realCount = this.yTG.getRealCount();
        if (this.yTG.dFO() == null) {
            C4990ab.m7412e("MicroMsg.ImageGalleryUI", "msgInfo is null");
            AppMethodBeat.m2505o(32263);
            return;
        }
        int OU = this.yTG.yTJ.mo48931OU(this.mQT.getCurrentItem());
        if (this.yWb) {
            bcW();
            AppMethodBeat.m2505o(32263);
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
        this.mHandler.postDelayed(new C2376814(), 50);
        AppMethodBeat.m2505o(32263);
    }

    public final int getCurrentItem() {
        AppMethodBeat.m2504i(139028);
        int currentItem = this.mQT.getCurrentItem();
        AppMethodBeat.m2505o(139028);
        return currentItem;
    }

    public void onClick(View view) {
        boolean z = true;
        AppMethodBeat.m2504i(32265);
        if (this.yTG == null) {
            AppMethodBeat.m2505o(32265);
        } else if (view.getId() == 2131824957) {
            m70485Pb(0);
            AppMethodBeat.m2505o(32265);
        } else if (view.getId() == 2131824965) {
            C4990ab.m7417i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", Integer.valueOf(this.mQT.getCurrentItem()));
            ImageGalleryUI.m70500al(dGb().yVO, 8);
            C7620bi Ou = this.yTG.mo64312Ou(this.mQT.getCurrentItem());
            C25822e f = this.yTG.mo64326f(Ou, false);
            this.mQT.getCurrentItem();
            if (ImageGalleryUI.m70517f(Ou, f) && !Ou.dtH() && f.agP()) {
                this.yTG.mo64314aF(this.mQT.getCurrentItem(), true);
                AppMethodBeat.m2505o(32265);
                return;
            }
            C40775c.m70563b(this.mController.ylL, this.yTG.dFO(), true);
            AppMethodBeat.m2505o(32265);
        } else if (view.getId() == 2131823182) {
            this.yWi = 2;
            this.yWg = 0;
            this.yTG.mo64314aF(this.mQT.getCurrentItem(), false);
            AppMethodBeat.m2505o(32265);
        } else if (view.getId() == 2131824967) {
            this.yTG.mo64310OS(this.mQT.getCurrentItem());
            mo64281Pa(this.mQT.getCurrentItem());
            dGp();
            dGq();
            dGt();
            AppMethodBeat.m2505o(32265);
        } else if (view.getId() == 2131820973) {
            onBackPressed();
            AppMethodBeat.m2505o(32265);
        } else if (view.getId() == 2131824958) {
            onBackPressed();
            AppMethodBeat.m2505o(32265);
        } else if (view.getId() == 2131823910) {
            boolean isChecked = this.yWo.isChecked();
            if (isChecked || C15660a.yVE.mnX.size() < 9) {
                CheckBox checkBox = this.yWo;
                if (isChecked) {
                    z = false;
                }
                checkBox.setChecked(z);
                if (this.yWo.isChecked()) {
                    C15660a.yVE.mo27887bC(this.yTG.dFO());
                    AppMethodBeat.m2505o(32265);
                    return;
                }
                C15660a.yVE.mo27888bD(this.yTG.dFO());
                AppMethodBeat.m2505o(32265);
                return;
            }
            Toast.makeText(this, getResources().getString(C25738R.string.c3z, new Object[]{Integer.valueOf(9)}), 1).show();
            AppMethodBeat.m2505o(32265);
        } else {
            if (view.getId() == 2131821279) {
                this.yTG.mo64307OP(this.mQT.getCurrentItem());
            }
            AppMethodBeat.m2505o(32265);
        }
    }

    /* renamed from: qx */
    public final void mo64299qx(boolean z) {
        AppMethodBeat.m2504i(32266);
        try {
            dFZ().yVV.setIsPlay(!z);
            AppMethodBeat.m2505o(32266);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ImageGalleryUI", "set video state iv error : " + e.toString());
            AppMethodBeat.m2505o(32266);
        }
    }

    public final boolean cGZ() {
        AppMethodBeat.m2504i(32267);
        boolean buH = dFZ().yVV.buH();
        AppMethodBeat.m2505o(32267);
        return buH;
    }

    /* renamed from: Pc */
    public final void mo64282Pc(final int i) {
        AppMethodBeat.m2504i(32268);
        if (dFZ().yVU == null) {
            AppMethodBeat.m2505o(32268);
            return;
        }
        dFZ().yVU.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(32214);
                if (ImageGalleryUI.this.yTG == null) {
                    AppMethodBeat.m2505o(32214);
                    return;
                }
                C40775c j = ImageGalleryUI.this.yTG;
                j.yTO.pause(i);
                AppMethodBeat.m2505o(32214);
            }
        });
        AppMethodBeat.m2505o(32268);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(32269);
        if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1) {
            if (this.riy != null) {
                this.riy.cpE();
                this.riy = null;
            } else if (this.yWi == 0 || this.yWi == 2) {
                mo64284ak(true, C43487d.cgx());
            } else {
                mo64284ak(true, false);
            }
            AppMethodBeat.m2505o(32269);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(32269);
        return dispatchKeyEvent;
    }

    private void dGn() {
        AppMethodBeat.m2504i(32270);
        if (dGa().yVN == null || this.yWA) {
            AppMethodBeat.m2505o(32270);
            return;
        }
        String str = "MicroMsg.ImageGalleryUI";
        String str2 = "fadeOutEnterGirdBtn: %B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.yVN.getVisibility() == 0);
        C4990ab.m7411d(str, str2, objArr);
        Animation Pd = ImageGalleryUI.m70486Pd(300);
        Pd.setFillAfter(false);
        Pd.setAnimationListener(new C2376916());
        dGa().yVN.startAnimation(Pd);
        this.yWA = true;
        AppMethodBeat.m2505o(32270);
    }

    private void dGo() {
        AppMethodBeat.m2504i(32271);
        if (dGa().yVP == null || this.yWB) {
            AppMethodBeat.m2505o(32271);
            return;
        }
        dGa().yVP.startAnimation(ImageGalleryUI.m70486Pd(300));
        this.yWB = true;
        AppMethodBeat.m2505o(32271);
    }

    private void dGp() {
        AppMethodBeat.m2504i(32272);
        if (dGa().yVN == null || !this.yWA || dGj()) {
            AppMethodBeat.m2505o(32272);
            return;
        }
        String str = "MicroMsg.ImageGalleryUI";
        String str2 = "fadeInEnterGirdBtn: %B %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(dGa().yVN.getVisibility() == 0);
        objArr[1] = C5046bo.dpG();
        C4990ab.m7411d(str, str2, objArr);
        dGa().yVN.startAnimation(ImageGalleryUI.dGr());
        dGb().yVO.startAnimation(ImageGalleryUI.dGr());
        this.yWA = false;
        AppMethodBeat.m2505o(32272);
    }

    private void dGq() {
        boolean z = true;
        AppMethodBeat.m2504i(32273);
        if (dGa().yVP == null || !this.yWB) {
            AppMethodBeat.m2505o(32273);
            return;
        }
        String str = "MicroMsg.ImageGalleryUI";
        String str2 = "fadeInPositionAtChatRecordBtn: %B";
        Object[] objArr = new Object[1];
        if (dGa().yVP.getVisibility() != 0) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7411d(str, str2, objArr);
        dGa().yVP.startAnimation(ImageGalleryUI.dGr());
        this.yWB = false;
        AppMethodBeat.m2505o(32273);
    }

    private static Animation dGr() {
        AppMethodBeat.m2504i(32274);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(150);
        alphaAnimation.setFillAfter(true);
        AppMethodBeat.m2505o(32274);
        return alphaAnimation;
    }

    /* renamed from: Pd */
    static Animation m70486Pd(int i) {
        AppMethodBeat.m2504i(32275);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration((long) i);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new AccelerateInterpolator(10.0f));
        AppMethodBeat.m2505o(32275);
        return alphaAnimation;
    }

    /* renamed from: BI */
    public final boolean mo4499BI() {
        AppMethodBeat.m2504i(32276);
        dGn();
        dGo();
        AppMethodBeat.m2505o(32276);
        return false;
    }

    private boolean dGs() {
        AppMethodBeat.m2504i(32277);
        if (ImageGalleryUI.m70513eN(this.yVQ) == 0 && ImageGalleryUI.m70513eN(this.yVR) == 0) {
            AppMethodBeat.m2505o(32277);
            return true;
        }
        AppMethodBeat.m2505o(32277);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dGt() {
        AppMethodBeat.m2504i(32278);
        if (dGs() || this.yTG == null) {
            AppMethodBeat.m2505o(32278);
            return;
        }
        C4990ab.m7410d("MicroMsg.ImageGalleryUI", "jacks start Hide Timer");
        this.yWz.mo16770ae(4000, 4000);
        AppMethodBeat.m2505o(32278);
    }

    private void dGu() {
        AppMethodBeat.m2504i(32279);
        C4990ab.m7410d("MicroMsg.ImageGalleryUI", "jacks stop Hide Timer");
        this.yWz.stopTimer();
        AppMethodBeat.m2505o(32279);
    }

    /* renamed from: Pe */
    public final void mo64283Pe(int i) {
        AppMethodBeat.m2504i(32280);
        mo64295hG(true);
        dGm();
        dFY().yVQ.setVisibility(0);
        dFY().yVR.setVisibility(8);
        dFY().yVS.setVisibility(0);
        dFY().yVT.setVisibility(8);
        dGn();
        dGo();
        dFY().yVS.setText(i + "%");
        AppMethodBeat.m2505o(32280);
    }

    public final void dGv() {
        AppMethodBeat.m2504i(32281);
        mo64295hG(true);
        dGm();
        dFY().yVQ.setVisibility(0);
        dFY().yVR.setVisibility(8);
        dFY().yVS.setVisibility(0);
        dFY().yVT.setVisibility(8);
        dGn();
        dGo();
        dFY().yVS.setText("0%");
        AppMethodBeat.m2505o(32281);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(32282);
        if (i == 82) {
            AppMethodBeat.m2505o(32282);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(32282);
        return onKeyDown;
    }

    public void finish() {
        AppMethodBeat.m2504i(32283);
        this.yOW.clear();
        super.finish();
        AppMethodBeat.m2505o(32283);
    }

    /* renamed from: np */
    public final int mo64296np(long j) {
        AppMethodBeat.m2504i(32284);
        if (C5046bo.isNullOrNil(this.yWj)) {
            AppMethodBeat.m2505o(32284);
            return 0;
        }
        try {
            int f = C26494u.m42251f(j, this.yWj);
            if (f == -1) {
                this.yWj = null;
                f = 0;
            }
            C4990ab.m7411d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", Integer.valueOf(f), this.yWj);
            AppMethodBeat.m2505o(32284);
            return f;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + e.toString());
            AppMethodBeat.m2505o(32284);
            return 0;
        }
    }

    /* renamed from: nq */
    public final void mo64297nq(long j) {
        AppMethodBeat.m2504i(32285);
        if (C5046bo.isNullOrNil(this.yWj) || j == 0) {
            AppMethodBeat.m2505o(32285);
            return;
        }
        if (C26494u.m42251f(j, this.yWj) == -1) {
            this.yWj = null;
            C4990ab.m7411d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", this.yWj);
        }
        AppMethodBeat.m2505o(32285);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(32286);
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            C4990ab.m7411d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", Integer.valueOf(hashCode()));
            dGw();
            AppMethodBeat.m2505o(32286);
        } else if (configuration.orientation == 2) {
            C4990ab.m7411d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", Integer.valueOf(hashCode()));
            dGx();
            AppMethodBeat.m2505o(32286);
        } else {
            AppMethodBeat.m2505o(32286);
        }
    }

    private void dGw() {
        AppMethodBeat.m2504i(32287);
        C4990ab.m7417i("MicroMsg.ImageGalleryUI", "%d handleVerticalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.osu), Boolean.valueOf(C5222ae.m7951hw(this)), Integer.valueOf(C5222ae.m7944fr(this)));
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
        AppMethodBeat.m2505o(32287);
    }

    private void dGx() {
        AppMethodBeat.m2504i(32288);
        boolean hw = C5222ae.m7951hw(this);
        int fr = C5222ae.m7944fr(this);
        C4990ab.m7417i("MicroMsg.ImageGalleryUI", "%d handleHorizontalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.osu), Boolean.valueOf(hw), Integer.valueOf(fr));
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
        AppMethodBeat.m2505o(32288);
    }

    /* renamed from: av */
    private boolean m70501av(Activity activity) {
        AppMethodBeat.m2504i(32289);
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        C4990ab.m7411d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", Integer.valueOf(hashCode()), Integer.valueOf(defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 0), Integer.valueOf(defaultDisplay.getWidth()), Integer.valueOf(defaultDisplay.getHeight()));
        if ((defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 0) == 0) {
            AppMethodBeat.m2505o(32289);
            return false;
        }
        AppMethodBeat.m2505o(32289);
        return true;
    }

    private void dGy() {
        AppMethodBeat.m2504i(32290);
        C7620bi dFO = this.yTG.dFO();
        C25822e d = C40780e.m70619d(dFO);
        C4990ab.m7417i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", C40780e.m70601a(dFO, d), Long.valueOf(dFO.field_msgId));
        m70498a(r2, d);
        AppMethodBeat.m2505o(32290);
    }

    /* renamed from: a */
    private void m70498a(String str, C25822e c25822e) {
        AppMethodBeat.m2504i(32291);
        String stringExtra = getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        C4990ab.m7417i("MicroMsg.ImageGalleryUI", "edit image path:%s", str);
        intent.putExtra("raw_photo_path", str);
        intent.putExtra("raw_photo_img_id", c25822e.fDy);
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("from_scene", 291);
        intent.putExtra("after_photo_edit", "");
        intent.setClass(this, MMNewPhotoEditUI.class);
        startActivityForResult(intent, 4369);
        overridePendingTransition(0, 0);
        AppMethodBeat.m2505o(32291);
    }

    public final int getForceOrientation() {
        return 2;
    }

    /* renamed from: l */
    static /* synthetic */ void m70523l(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(32296);
        C4990ab.m7417i("MicroMsg.ImageGalleryUI", "%d handle single click event.", Integer.valueOf(imageGalleryUI.hashCode()));
        if (imageGalleryUI.dGj()) {
            try {
                if (imageGalleryUI.yTG.dFP().dGH().yXq.getVisibility() == 0) {
                    C4990ab.m7411d("MicroMsg.ImageGalleryUI", "%d handle single click event, it is loading video, don't show toolbar", Integer.valueOf(imageGalleryUI.hashCode()));
                    AppMethodBeat.m2505o(32296);
                    return;
                }
            } catch (Exception e) {
            }
            if (imageGalleryUI.yWu) {
                imageGalleryUI.dGm();
                AppMethodBeat.m2505o(32296);
                return;
            }
            imageGalleryUI.dGl();
            AppMethodBeat.m2505o(32296);
            return;
        }
        if (imageGalleryUI.yWi != 1) {
            imageGalleryUI.onBackPressed();
        }
        AppMethodBeat.m2505o(32296);
    }

    /* renamed from: q */
    static /* synthetic */ void m70528q(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(138631);
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
        AppMethodBeat.m2505o(138631);
    }

    /* renamed from: u */
    static /* synthetic */ void m70533u(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(138632);
        imageGalleryUI.mQT.setGalleryScaleListener(new C407715());
        AppMethodBeat.m2505o(138632);
    }

    /* renamed from: w */
    static /* synthetic */ void m70535w(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(138633);
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
        AppMethodBeat.m2505o(138633);
    }

    /* renamed from: D */
    static /* synthetic */ void m70472D(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(32305);
        if (imageGalleryUI.yTG == null || (imageGalleryUI.yTG != null && imageGalleryUI.yTG.mo64312Ou(imageGalleryUI.yWs) == null)) {
            AppMethodBeat.m2505o(32305);
            return;
        }
        C4990ab.m7417i("MicroMsg.ImageGalleryUI", "enterPositionAtChatRecords-->talker:%s,magId:%d", imageGalleryUI.talker, Long.valueOf(imageGalleryUI.yTG.mo64312Ou(imageGalleryUI.yWs).field_msgId));
        Intent intent = new Intent(imageGalleryUI.mController.ylL, ChattingUI.class);
        intent.putExtra("Chat_User", imageGalleryUI.dGc());
        intent.putExtra("finish_direct", true);
        intent.putExtra("show_search_chat_content_result", true);
        intent.putExtra("key_is_biz_chat", imageGalleryUI.mgP);
        intent.putExtra("key_biz_chat_id", imageGalleryUI.jMj);
        C9638aw.m17190ZK();
        intent.putExtra("need_hight_item", ((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_POSITION_AT_CHATRECORD_FIRST_IN_BOOLEAN, Boolean.TRUE)).booleanValue());
        intent.putExtra("msg_local_id", r4);
        intent.putExtra("img_gallery_enter_from_chatting_ui", true);
        imageGalleryUI.startActivity(intent);
        if (imageGalleryUI.yWb) {
            C7060h.pYm.mo8378a(219, 16, 1, true);
            AppMethodBeat.m2505o(32305);
            return;
        }
        C7060h.pYm.mo8378a(219, 17, 1, true);
        AppMethodBeat.m2505o(32305);
    }

    /* renamed from: H */
    static /* synthetic */ void m70476H(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.m2504i(138639);
        if (C1720g.m3540Rg().acS() == 6 || C1720g.m3540Rg().acS() == 4) {
            imageGalleryUI.yWi = 1;
            imageGalleryUI.qbx.setVisibility(0);
            imageGalleryUI.yWk.setVisibility(0);
            imageGalleryUI.yWl.setVisibility(0);
            imageGalleryUI.dGi();
            imageGalleryUI.dGu();
            imageGalleryUI.mo64295hG(false);
            imageGalleryUI.qfZ.setRepeatMode(1);
            imageGalleryUI.qfZ.setRepeatCount(-1);
            imageGalleryUI.qfZ.start();
            AppMethodBeat.m2505o(138639);
            return;
        }
        C30379h.m48461b((Context) imageGalleryUI, imageGalleryUI.getString(C25738R.string.g5c), "", true);
        imageGalleryUI.dGf();
        AppMethodBeat.m2505o(138639);
    }
}
