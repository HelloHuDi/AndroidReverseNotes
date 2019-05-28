package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcel;
import android.os.Process;
import android.os.SystemClock;
import android.support.p069v7.app.ActionBar;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.C1060a;
import com.tencent.matrix.trace.C7466a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.p174e.C1153b;
import com.tencent.matrix.trace.p175f.C7469c;
import com.tencent.p127d.p135f.C8769e;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C18175j;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.kiss.WxPresenterActivity;
import com.tencent.p177mm.kiss.widget.textview.C37873c;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C42185ar;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelsns.C32830c;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p215cf.C37632b;
import com.tencent.p177mm.p230g.p231a.C18312lc;
import com.tencent.p177mm.p230g.p231a.C18384ro;
import com.tencent.p177mm.p230g.p231a.C26187lb;
import com.tencent.p177mm.p230g.p231a.C26211ou;
import com.tencent.p177mm.p230g.p231a.C26228rf;
import com.tencent.p177mm.p230g.p231a.C26231rh;
import com.tencent.p177mm.p230g.p231a.C32626rb;
import com.tencent.p177mm.p230g.p231a.C37697bz;
import com.tencent.p177mm.p230g.p231a.C37755kw;
import com.tencent.p177mm.p230g.p231a.C37789qx;
import com.tencent.p177mm.p230g.p231a.C37795ru;
import com.tencent.p177mm.p230g.p231a.C45342li;
import com.tencent.p177mm.p230g.p231a.C45363rm;
import com.tencent.p177mm.p230g.p231a.C6543ra;
import com.tencent.p177mm.p230g.p231a.C6545sa;
import com.tencent.p177mm.p230g.p231a.C6550tn;
import com.tencent.p177mm.p230g.p231a.C9326e;
import com.tencent.p177mm.p230g.p231a.C9362gs;
import com.tencent.p177mm.p230g.p231a.C9405ks;
import com.tencent.p177mm.p230g.p231a.C9455rg;
import com.tencent.p177mm.p230g.p231a.C9482tw;
import com.tencent.p177mm.p230g.p232b.p233a.C32661ah;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5240b;
import com.tencent.p177mm.p612ui.C5510e;
import com.tencent.p177mm.p612ui.C5536q;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44274m;
import com.tencent.p177mm.p612ui.base.MMPullDownView;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5263f;
import com.tencent.p177mm.p612ui.statusbar.C5544c;
import com.tencent.p177mm.p612ui.statusbar.C5544c.C5543a;
import com.tencent.p177mm.p612ui.statusbar.C5546d;
import com.tencent.p177mm.p612ui.widget.QFadeImageView;
import com.tencent.p177mm.p612ui.widget.QImageView.C15991a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.abtest.C21865a;
import com.tencent.p177mm.plugin.sns.abtest.C34932c;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C13417av;
import com.tencent.p177mm.plugin.sns.model.C21925g;
import com.tencent.p177mm.plugin.sns.model.C3889am;
import com.tencent.p177mm.plugin.sns.model.C39756at;
import com.tencent.p177mm.plugin.sns.model.C43558b;
import com.tencent.p177mm.plugin.sns.model.C46224r;
import com.tencent.p177mm.plugin.sns.model.C46225y;
import com.tencent.p177mm.plugin.sns.model.C7101u;
import com.tencent.p177mm.plugin.sns.p1024b.C39728h.C39729a;
import com.tencent.p177mm.plugin.sns.p1025h.C21896c;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C13342g;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C13348i.C133495;
import com.tencent.p177mm.plugin.sns.p516g.C21884c;
import com.tencent.p177mm.plugin.sns.p516g.C21890d;
import com.tencent.p177mm.plugin.sns.p516g.C31408b;
import com.tencent.p177mm.plugin.sns.p517i.C13363a;
import com.tencent.p177mm.plugin.sns.p517i.C13363a.C13364b;
import com.tencent.p177mm.plugin.sns.p517i.C13363a.C13365a;
import com.tencent.p177mm.plugin.sns.p517i.C24827g;
import com.tencent.p177mm.plugin.sns.p517i.C43548b;
import com.tencent.p177mm.plugin.sns.p517i.C43548b.C38712;
import com.tencent.p177mm.plugin.sns.p517i.C43549e;
import com.tencent.p177mm.plugin.sns.p518k.C34939a;
import com.tencent.p177mm.plugin.sns.p518k.C3874b;
import com.tencent.p177mm.plugin.sns.p518k.C3877c.C3878a;
import com.tencent.p177mm.plugin.sns.p518k.C3877c.C3879b;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au.C13632a;
import com.tencent.p177mm.plugin.sns.p520ui.C46256bd.C220771;
import com.tencent.p177mm.plugin.sns.p520ui.C46256bd.C22078a;
import com.tencent.p177mm.plugin.sns.p520ui.SnsUIAction.C13559a;
import com.tencent.p177mm.plugin.sns.p520ui.TestTimeForSns.C29165a;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.p520ui.p1027a.C29169a;
import com.tencent.p177mm.plugin.sns.p520ui.p1027a.p1028a.C13618a;
import com.tencent.p177mm.plugin.sns.p520ui.p1027a.p1028a.C13619b;
import com.tencent.p177mm.plugin.sns.p520ui.p1027a.p1300b.C39821d;
import com.tencent.p177mm.plugin.sns.p520ui.p1027a.p1300b.C43587b;
import com.tencent.p177mm.plugin.sns.p520ui.p1413e.C29210a;
import com.tencent.p177mm.plugin.sns.p520ui.view.SnsStoryHeaderView.C29246a;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C35146c;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C35147e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C46616n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vending.app.C16025a.C16028b;
import com.tencent.p177mm.vending.p635a.C41350b.C41351a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p642h.C5703d;
import com.tencent.p177mm.vending.p642h.C7366b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.util.ActUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@C18524i
/* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI */
public class SnsTimeLineUI extends WxPresenterActivity implements C1202f, C42185ar, C39729a, C43609t {
    /* renamed from: h */
    private static Handler f15065h = new Handler(rzk.getLooper());
    public static final Boolean rza = Boolean.FALSE;
    private static HandlerThread rzk;
    private static final Set<Activity> sUILeaksRoutineEnsuranceRef = new HashSet();
    private long eEO;
    private int ehv;
    private long fAq;
    private String hcl;
    private String igi;
    private ActionBar mActionBar;
    private int mScreenHeight;
    private int mScreenWidth;
    private SnsUIAction mUIAction;
    private C1153b mnM;
    private int oOX;
    private long oes;
    private View plv;
    private C5543a plx;
    private C4884c qMM;
    private boolean qQu;
    private boolean rhv;
    private boolean rjn;
    protected C13342g rqn;
    private C13417av ryA;
    private C39756at ryB;
    private String ryC;
    private boolean ryD;
    private int ryE;
    private String ryF;
    private String ryG;
    private C35071c ryH;
    private Runnable ryI;
    private C4884c ryJ;
    private C4884c ryK;
    private boolean ryL;
    private C4884c ryM;
    private C4884c ryN;
    private C4884c ryO;
    private C4884c ryP;
    private C4884c ryQ;
    private C4884c ryR;
    private C4884c ryS;
    private C4884c ryT;
    private C4884c ryU;
    private C4884c ryV;
    private C4884c ryW;
    private C4884c ryX;
    private C4884c ryY;
    private C4884c ryZ;
    private final long ryi = 300;
    private long ryj = SystemClock.elapsedRealtime();
    private C3874b ryk = ((C3874b) mo20831V(C3874b.class));
    private C34939a ryl;
    private C13619b rym;
    private C29169a ryn;
    private LinearLayout ryo;
    private LinearLayout ryp;
    private QFadeImageView ryq;
    private boolean ryr;
    private boolean rys;
    private C29220i ryt;
    private C35069a ryu;
    private TestTimeForSns ryv;
    private int ryw;
    private boolean ryx;
    private String ryy;
    private C13363a ryz;
    private long rzb;
    boolean rzc;
    Runnable rzd;
    Runnable rze;
    private Handler rzf;
    private Runnable rzg;
    private C13559a rzh;
    private C16028b rzi;
    boolean rzj;
    int rzl;
    private OnMenuItemClickListener rzm;
    private ImageView rzn;
    private View rzo;
    private C29199ax rzp;
    private OnClickListener rzq;
    private boolean rzr;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$22 */
    class C400322 implements Runnable {
        C400322() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39486);
            C37632b.dvU();
            AppMethodBeat.m2505o(39486);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$38 */
    class C400538 implements C5263f {
        C400538() {
        }

        /* renamed from: ba */
        public final void mo8846ba(float f) {
            AppMethodBeat.m2504i(39511);
            SnsTimeLineUI.m57616J(SnsTimeLineUI.this);
            if (SnsTimeLineUI.rza.booleanValue()) {
                C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "mUIAction.header.getTop %s originalHeaderTop %s distanceY %s", Integer.valueOf(SnsTimeLineUI.this.mUIAction.qQt.getTop()), Integer.valueOf(SnsTimeLineUI.this.ryu.rzX), Float.valueOf(f));
            }
            if (SnsTimeLineUI.this.mUIAction.qQt.getTop() >= SnsTimeLineUI.this.ryu.rzX || f > 0.0f) {
                SnsTimeLineUI.this.ryu.mo55701bb(f);
            }
            SnsTimeLineUI.this.ryt.crD();
            SnsTimeLineUI.this.crO();
            SnsTimeLineUI.this.ryt.rhr.cuL();
            AppMethodBeat.m2505o(39511);
        }

        public final void cuq() {
            AppMethodBeat.m2504i(39512);
            SnsTimeLineUI.this.ryu.cut();
            AppMethodBeat.m2505o(39512);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$39 */
    class C400639 implements Runnable {
        C400639() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39513);
            C18175j.m28619r(SnsTimeLineUI.this);
            AppMethodBeat.m2505o(39513);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$23 */
    class C713023 extends C4884c<C37795ru> {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$23$1 */
        class C71311 implements C5681a<Void, Void> {
            C71311() {
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(39487);
                Void voidR = (Void) obj;
                C29169a a = SnsTimeLineUI.this.ryn;
                if (a != null) {
                    a.rEB.mo37602PA();
                    a.rEB.notifyVendingDataChange();
                }
                AppMethodBeat.m2505o(39487);
                return voidR;
            }
        }

        C713023() {
            AppMethodBeat.m2504i(39488);
            this.xxI = C37795ru.class.getName().hashCode();
            AppMethodBeat.m2505o(39488);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39489);
            C37795ru c37795ru = (C37795ru) c4883b;
            if (SnsTimeLineUI.this.mController.ylL == null || SnsTimeLineUI.this.mController.ylL.isFinishing()) {
                AppMethodBeat.m2505o(39489);
            } else {
                if (!c37795ru.cNM.cNN) {
                    C5698f.dMn().mo15893d(new C71311());
                }
                AppMethodBeat.m2505o(39489);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$60 */
    class C713260 extends C4884c<C37755kw> {
        C713260() {
            AppMethodBeat.m2504i(39536);
            this.xxI = C37755kw.class.getName().hashCode();
            AppMethodBeat.m2505o(39536);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39537);
            C37755kw c37755kw = (C37755kw) c4883b;
            SnsTimeLineUI.this.qQu = true;
            SnsTimeLineUI.this.ryz.qQu = SnsTimeLineUI.this.qQu;
            SnsTimeLineUI.m57628a(SnsTimeLineUI.this, c37755kw.cGO.position);
            AppMethodBeat.m2505o(39537);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$10 */
    class C1355510 extends C4884c<C26231rh> {
        C1355510() {
            AppMethodBeat.m2504i(39459);
            this.xxI = C26231rh.class.getName().hashCode();
            AppMethodBeat.m2505o(39459);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39460);
            C26231rh c26231rh = (C26231rh) c4883b;
            if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                C43548b c43548b = SnsTimeLineUI.this.ryt.rhn.qMn;
                c43548b.qSo.add(c26231rh.cNm.cFc);
            }
            AppMethodBeat.m2505o(39460);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$12 */
    class C1355612 extends C4884c<C9482tw> {
        C1355612() {
            AppMethodBeat.m2504i(39462);
            this.xxI = C9482tw.class.getName().hashCode();
            AppMethodBeat.m2505o(39462);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39463);
            SnsTimeLineUI.this.mo20830SK().mo28389aG(C3879b.class);
            AppMethodBeat.m2505o(39463);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$49 */
    class C1355749 implements OnCancelListener {
        C1355749() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(39523);
            SnsTimeLineUI.this.ryH.mo55708Ei(10);
            SnsTimeLineUI.m57634b(SnsTimeLineUI.this.ryH);
            AppMethodBeat.m2505o(39523);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$17 */
    class C2203617 implements Runnable {
        C2203617() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39469);
            if (SnsTimeLineUI.this.ryn == null) {
                AppMethodBeat.m2505o(39469);
                return;
            }
            if (SnsTimeLineUI.this.rzc) {
                C13373af.cnC().pause();
            }
            AppMethodBeat.m2505o(39469);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$18 */
    class C2203718 implements Runnable {
        C2203718() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39470);
            if (SnsTimeLineUI.this.ryn == null) {
                AppMethodBeat.m2505o(39470);
                return;
            }
            if (!SnsTimeLineUI.this.rzc) {
                C4990ab.m7419v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", Integer.valueOf(SnsTimeLineUI.this.mUIAction.nDp.getFirstVisiblePosition() - SnsTimeLineUI.this.mUIAction.nDp.getHeaderViewsCount()));
                C13373af.cnC().start();
                SnsTimeLineUI.this.ryn.rEA.cub();
            }
            AppMethodBeat.m2505o(39470);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$19 */
    class C2203819 implements Runnable {
        C2203819() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39471);
            C5536q c5536q = SnsTimeLineUI.this.mController;
            if (c5536q.mContext != null) {
                c5536q.mo11188ap(c5536q.ylL);
            }
            SnsTimeLineUI.m57657t(SnsTimeLineUI.this);
            SnsTimeLineUI.m57658u(SnsTimeLineUI.this);
            SnsTimeLineUI.this.setMMTitle(SnsTimeLineUI.this.getString(C25738R.string.eq0));
            SnsTimeLineUI.this.rzb = 0;
            SnsTimeLineUI.this.oOX = SnsTimeLineUI.this.mUIAction.nDp.getFirstVisiblePosition();
            AppMethodBeat.m2505o(39471);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$1 */
    class C220391 implements Runnable {
        C220391() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39442);
            C29169a a = SnsTimeLineUI.this.ryn;
            if (a != null) {
                a.rEB.ctK();
                a.rEB.notifyVendingDataChange();
            }
            AppMethodBeat.m2505o(39442);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$25 */
    class C2204025 implements C29246a {
        C2204025() {
        }

        public final void cun() {
            AppMethodBeat.m2504i(39493);
            C35069a h = SnsTimeLineUI.this.ryu;
            if (SnsTimeLineUI.this.ryq.getVisibility() == 0) {
                h.init();
                SnsTimeLineUI.this.ryq.clearAnimation();
                SnsTimeLineUI.this.ryq.startAnimation(h);
                h.mo55707kK((long) (h.DELAY_TIME + 100));
                h.rzW = false;
            }
            AppMethodBeat.m2505o(39493);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$36 */
    class C2204136 implements OnTouchListener {
        C2204136() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(39509);
            if (motionEvent.getAction() == 1) {
                SnsTimeLineUI.this.crO();
                if (SnsTimeLineUI.this.mUIAction.nDp != null && SnsTimeLineUI.this.mUIAction.nDp.getFirstVisiblePosition() == 0) {
                    C4990ab.m7410d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
                }
                SnsTimeLineUI.this.ryu.cut();
            }
            if (motionEvent.getAction() == 0) {
                if (SnsTimeLineUI.this.mUIAction.nDp != null) {
                    SnsTimeLineUI.this.mUIAction.nDp.getFirstVisiblePosition();
                }
                SnsTimeLineUI.this.ryt.crD();
                SnsTimeLineUI.this.ryt.rhr.cuL();
            }
            AppMethodBeat.m2505o(39509);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$41 */
    class C2204241 implements Runnable {
        C2204241() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39515);
            SnsTimeLineUI.this.crO();
            AppMethodBeat.m2505o(39515);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$42 */
    class C2204342 implements Runnable {
        C2204342() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39516);
            SnsTimeLineUI.m57617K(SnsTimeLineUI.this);
            AppMethodBeat.m2505o(39516);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$44 */
    class C2204444 implements Runnable {
        C2204444() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39518);
            SnsTimeLineUI.m57617K(SnsTimeLineUI.this);
            AppMethodBeat.m2505o(39518);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$54 */
    class C2204554 implements Runnable {
        C2204554() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39528);
            if (SnsTimeLineUI.this.ryn != null) {
                SnsTimeLineUI.this.ryn.rEB.notifyVendingDataChange();
            }
            SnsTimeLineUI.this.rzr = false;
            AppMethodBeat.m2505o(39528);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$56 */
    class C2204656 extends C4884c<C9405ks> {
        C2204656() {
            AppMethodBeat.m2504i(39531);
            this.xxI = C9405ks.class.getName().hashCode();
            AppMethodBeat.m2505o(39531);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39532);
            SnsTimeLineUI.this.ryL = true;
            AppMethodBeat.m2505o(39532);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$57 */
    class C2204757 implements Runnable {
        C2204757() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39533);
            SnsTimeLineUI.this.aqX();
            AppMethodBeat.m2505o(39533);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$62 */
    class C2204862 extends C4884c<C6543ra> {
        C2204862() {
            AppMethodBeat.m2504i(39540);
            this.xxI = C6543ra.class.getName().hashCode();
            AppMethodBeat.m2505o(39540);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39541);
            C6543ra c6543ra = (C6543ra) c4883b;
            if (SnsTimeLineUI.this.ryt != null) {
                C43548b c43548b = SnsTimeLineUI.this.ryt.rhn.qMn;
                String str = c6543ra.cNe.cNf;
                c43548b.qSm.add(c6543ra.cNe.cFc);
                c43548b.qSu.add(str);
                c43548b.qQW = c43548b.qSu.size();
            }
            AppMethodBeat.m2505o(39541);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$9 */
    class C220499 extends C4884c<C9455rg> {
        C220499() {
            AppMethodBeat.m2504i(39457);
            this.xxI = C9455rg.class.getName().hashCode();
            AppMethodBeat.m2505o(39457);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39458);
            C9455rg c9455rg = (C9455rg) c4883b;
            if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                C43548b c43548b = SnsTimeLineUI.this.ryt.rhn.qMn;
                c43548b.qSr.add(c9455rg.cNl.cFc);
            }
            AppMethodBeat.m2505o(39458);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$24 */
    class C2914824 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$24$1 */
        class C291471 implements DialogInterface.OnClickListener {
            C291471() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(39490);
                C4879a.xxA.mo10055m(new C26211ou());
                AppMethodBeat.m2505o(39490);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$24$2 */
        class C291492 implements DialogInterface.OnClickListener {
            C291492() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(39491);
                C4879a.xxA.mo10055m(new C45342li());
                AppMethodBeat.m2505o(39491);
            }
        }

        C2914824() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39492);
            C30379h.m48466d(SnsTimeLineUI.this, SnsTimeLineUI.this.getString(C25738R.string.d9p), "", SnsTimeLineUI.this.getString(C25738R.string.d9q), SnsTimeLineUI.this.getString(C25738R.string.f9076or), new C291471(), new C291492());
            AppMethodBeat.m2505o(39492);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$2 */
    class C291502 extends C4884c<C18384ro> {
        C291502() {
            AppMethodBeat.m2504i(39443);
            this.xxI = C18384ro.class.getName().hashCode();
            AppMethodBeat.m2505o(39443);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39444);
            C18384ro c18384ro = (C18384ro) c4883b;
            if (SnsTimeLineUI.this.ryt != null) {
                C43548b c43548b;
                if (c18384ro.cNw.cNx) {
                    c43548b = SnsTimeLineUI.this.ryt.rhn.qMn;
                    c43548b.qSw.add(c18384ro.cNw.username);
                    c43548b.qQY = c43548b.qSw.size();
                } else {
                    c43548b = SnsTimeLineUI.this.ryt.rhn.qMn;
                    c43548b.qSx.add(c18384ro.cNw.username);
                    c43548b.qQZ = c43548b.qSx.size();
                }
            }
            AppMethodBeat.m2505o(39444);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$30 */
    class C2915130 implements Runnable {
        C2915130() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39498);
            C4990ab.m7416i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + SnsTimeLineUI.this.rys);
            if (SnsTimeLineUI.this.rys) {
                SnsTimeLineUI.this.rys = false;
                SnsTimeLineUI.this.ryu.cur();
            }
            AppMethodBeat.m2505o(39498);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$37 */
    class C2915237 implements Runnable {
        C2915237() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39510);
            if (SnsTimeLineUI.this.ryt == null) {
                AppMethodBeat.m2505o(39510);
                return;
            }
            SnsTimeLineUI.this.ryt.rhr.rpW = SnsTimeLineUI.this.mUIAction.nDp.getBottom();
            SnsTimeLineUI.this.ryt.rhr.rDO = SnsTimeLineUI.this.mUIAction.ooW.getTop();
            SnsTimeLineUI.this.ryu.rzX = SnsTimeLineUI.this.mUIAction.qQt.getTop();
            AppMethodBeat.m2505o(39510);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$3 */
    class C291533 extends C4884c<C45363rm> {
        C291533() {
            AppMethodBeat.m2504i(39445);
            this.xxI = C45363rm.class.getName().hashCode();
            AppMethodBeat.m2505o(39445);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39446);
            SnsTimeLineUI.this.ryn.rEB.notifyVendingDataChange();
            AppMethodBeat.m2505o(39446);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$43 */
    class C2915443 implements OnMenuItemClickListener {
        C2915443() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39517);
            SnsTimeLineUI.this.aqX();
            SnsTimeLineUI.this.finish();
            AppMethodBeat.m2505o(39517);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$61 */
    class C2915761 extends C4884c<C6545sa> {
        C2915761() {
            AppMethodBeat.m2504i(39538);
            this.xxI = C6545sa.class.getName().hashCode();
            AppMethodBeat.m2505o(39538);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39539);
            if (SnsTimeLineUI.this.ryt != null) {
                C43548b c43548b = SnsTimeLineUI.this.ryt.rhn.qMn;
                c43548b.qQV++;
                SnsTimeLineUI.this.ryt.rhn.qMn.mo69109kO(false);
            }
            AppMethodBeat.m2505o(39539);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$20 */
    class C3504520 implements C13559a {
        private int rzB = 0;
        private int rzC = 0;

        C3504520() {
        }

        public final void cuh() {
            AppMethodBeat.m2504i(39473);
            C13619b o = SnsTimeLineUI.this.rym;
            SnsTimeLineUI.this.rzh;
            o.mo25824e(SnsTimeLineUI.this.igi, SnsTimeLineUI.this.ryD, false, SnsTimeLineUI.this.ryE);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, Integer.valueOf(3));
            C4990ab.m7410d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
            if (SnsTimeLineUI.this.rzf == null) {
                C4990ab.m7412e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
                AppMethodBeat.m2505o(39473);
                return;
            }
            if (SnsTimeLineUI.this.ryt != null) {
                SnsTimeLineUI.this.rzf.removeCallbacks(SnsTimeLineUI.this.ryI);
                SnsTimeLineUI.this.rzf.postDelayed(SnsTimeLineUI.this.ryI, 3000);
            }
            AppMethodBeat.m2505o(39473);
        }

        public final ListView getSnsListView() {
            AppMethodBeat.m2504i(39474);
            if (SnsTimeLineUI.this.ryt.nDp == null) {
                SnsTimeLineUI.this.ryt.nDp = (ListView) SnsTimeLineUI.this.findViewById(2131827740);
            }
            ListView listView = SnsTimeLineUI.this.ryt.nDp;
            AppMethodBeat.m2505o(39474);
            return listView;
        }

        public final View cui() {
            AppMethodBeat.m2504i(39475);
            if (SnsTimeLineUI.this.ryt.qOM == null) {
                SnsTimeLineUI.this.ryt.qOM = (FrameLayout) SnsTimeLineUI.this.findViewById(2131822759);
            }
            FrameLayout frameLayout = SnsTimeLineUI.this.ryt.qOM;
            AppMethodBeat.m2505o(39475);
            return frameLayout;
        }

        public final View getMaskView() {
            AppMethodBeat.m2504i(39476);
            View findViewById = SnsTimeLineUI.this.findViewById(2131827838);
            AppMethodBeat.m2505o(39476);
            return findViewById;
        }

        public final MMPullDownView cuj() {
            AppMethodBeat.m2504i(39477);
            MMPullDownView mMPullDownView = (MMPullDownView) SnsTimeLineUI.this.findViewById(2131822761);
            AppMethodBeat.m2505o(39477);
            return mMPullDownView;
        }

        public final int getType() {
            if (SnsTimeLineUI.this.rzl == 1) {
                return 2;
            }
            return 1;
        }

        /* renamed from: b */
        public final void mo25742b(int i, List<Integer> list, List<Integer> list2) {
            int i2 = 1;
            AppMethodBeat.m2504i(39478);
            if (i > 0) {
                C46236n DK = C13373af.cnF().mo62914DK(i);
                if (DK != null) {
                    if (DK.field_pravited > 0) {
                        Toast.makeText(SnsTimeLineUI.this, C25738R.string.el5, 1).show();
                    }
                    if (DK.field_pravited == 1) {
                        i2 = 0;
                    }
                }
            }
            if (i2 != 0) {
                C4978c.m7375a(SnsTimeLineUI.this.mUIAction.nDp);
            }
            if (SnsTimeLineUI.this.ryn != null) {
                SnsTimeLineUI.this.ryn.rEB.notifyVendingDataChange();
            }
            AppMethodBeat.m2505o(39478);
        }

        public final boolean cuk() {
            AppMethodBeat.m2504i(39479);
            boolean z = SnsTimeLineUI.this.rhv;
            AppMethodBeat.m2505o(39479);
            return z;
        }

        public final void cul() {
            AppMethodBeat.m2504i(39480);
            C4990ab.m7410d("MicroMsg.SnsTimeLineUI", "onLoadingTap");
            SnsTimeLineUI.this.crO();
            if (SnsTimeLineUI.this.ryq != null) {
                C4990ab.m7410d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
                SnsTimeLineUI.m57636b(SnsTimeLineUI.this, 0);
            }
            C13619b o = SnsTimeLineUI.this.rym;
            SnsTimeLineUI.this.rzh;
            o.mo25823d(SnsTimeLineUI.this.igi, SnsTimeLineUI.this.ryD, SnsTimeLineUI.this.rjn, SnsTimeLineUI.this.ryE);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, Integer.valueOf(2));
            AppMethodBeat.m2505o(39480);
        }

        public final void cum() {
            AppMethodBeat.m2504i(39481);
            SnsTimeLineUI.this.crO();
            AppMethodBeat.m2505o(39481);
        }

        /* renamed from: Eh */
        public final void mo25740Eh(int i) {
            AppMethodBeat.m2504i(39482);
            int firstVisiblePosition = SnsTimeLineUI.this.mUIAction.nDp.getFirstVisiblePosition();
            int lastVisiblePosition = SnsTimeLineUI.this.mUIAction.nDp.getLastVisiblePosition();
            if (firstVisiblePosition == this.rzB && lastVisiblePosition == this.rzC) {
                AppMethodBeat.m2505o(39482);
                return;
            }
            this.rzB = firstVisiblePosition;
            this.rzC = lastVisiblePosition;
            C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "onListViewScoll %s %s %s", Integer.valueOf(firstVisiblePosition), Integer.valueOf(lastVisiblePosition), Integer.valueOf(i));
            if (i == 2) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, SnsTimeLineUI.this.ehv);
                SnsTimeLineUI.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcSNSScrollEnable, WXHardCoderJNI.hcSNSScrollDelay, WXHardCoderJNI.hcSNSScrollCPU, WXHardCoderJNI.hcSNSScrollIO, WXHardCoderJNI.hcSNSScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcSNSScrollTimeout, 701, WXHardCoderJNI.hcSNSScrollAction, "MicroMsg.SnsTimeLineUI");
                C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "summer hardcoder sns startPerformance [%s]", Integer.valueOf(SnsTimeLineUI.this.ehv));
            }
            if (i == 0 && SnsTimeLineUI.this.ryn != null) {
                C29169a a = SnsTimeLineUI.this.ryn;
                if (lastVisiblePosition >= firstVisiblePosition) {
                    LinkedList linkedList = new LinkedList();
                    for (int i2 = firstVisiblePosition; i2 <= lastVisiblePosition; i2++) {
                        C46236n DP = a.mo47320DP(i2);
                        if (DP != null) {
                            TimeLineObject cqu = DP.cqu();
                            if (cqu != null && cqu.xfI.wbJ == 3) {
                                firstVisiblePosition = -1;
                                if (cqu.xfI.wbN != null) {
                                    firstVisiblePosition = cqu.xfI.wbN.vGc;
                                }
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(cqu.f15074Id);
                                arrayList.add(C5046bo.m7532bc(cqu.xfI.Url, ""));
                                arrayList.add(String.valueOf(firstVisiblePosition));
                                linkedList.add(arrayList);
                            }
                        }
                    }
                    ((C20023b) C1720g.m3528K(C20023b.class)).mo6757i(linkedList, 2);
                }
            }
            if (SnsTimeLineUI.this.ryn != null) {
                final C13365a a2 = SnsTimeLineUI.this.ryz.mo25474a(SnsTimeLineUI.this.ryn.rEA);
                C5698f.dMn().mo15893d(new C5681a<Void, Void>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.m2504i(39472);
                        Void voidR = (Void) obj;
                        if (a2 != null) {
                            C13365a c13365a = a2;
                            C37952b lY = C37952b.m64170lY(501);
                            lY.timeStamp = c13365a.qQv;
                            lY.mo60720mb(c13365a.mScreenWidth).mo60720mb(c13365a.mScreenHeight);
                            lY.mo60720mb(c13365a.qQx);
                            lY.mo60720mb(0);
                            lY.mo60720mb(c13365a.qQw);
                            lY.mo60720mb(c13365a.aaF);
                            lY.ajK();
                            if (c13365a.qQy != null) {
                                for (C13364b c13364b : c13365a.qQy) {
                                    C37952b lY2 = C37952b.m64170lY(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                                    lY2.timeStamp = c13365a.qQv;
                                    lY2.mo60722tx(c13364b.qQD).mo60720mb(c13364b.qQB).mo60718cS(c13364b.qQC).mo60720mb(c13364b.qQA).mo60720mb(c13364b.qQz).mo60720mb(c13364b.aKu).mo60720mb(c13364b.aKv);
                                    lY2.ajK();
                                    C4990ab.m7419v("MicroMsg.CaptureSnsHelper", "rootview top left %s %s viewWidth: %s viewHeight: %s", Integer.valueOf(c13364b.qQz), Integer.valueOf(c13364b.qQA), Integer.valueOf(c13364b.aKu), Integer.valueOf(c13364b.aKv));
                                    C4990ab.m7419v("MicroMsg.CaptureSnsHelper", "like %s %s likeheight: %s likewidth: %s", Integer.valueOf(c13364b.qQG), Integer.valueOf(c13364b.qQH), Integer.valueOf(c13364b.qQJ), Integer.valueOf(c13364b.qQI));
                                    C4990ab.m7419v("MicroMsg.CaptureSnsHelper", "comment %s %s commentheight: %s commentwidth: %s", Integer.valueOf(c13364b.qQK), Integer.valueOf(c13364b.qQL), Integer.valueOf(c13364b.qQN), Integer.valueOf(c13364b.qQM));
                                    if (c13364b.qQF != 0) {
                                        lY2 = C37952b.m64170lY(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
                                        lY2.timeStamp = c13365a.qQv;
                                        lY2.mo60722tx(c13364b.qQD).mo60720mb(c13364b.qQB).mo60718cS(c13364b.qQC).mo60720mb(c13364b.qQF).mo60720mb(c13364b.qQH).mo60720mb(c13364b.qQG).mo60720mb(c13364b.qQI).mo60720mb(c13364b.qQJ);
                                        lY2.ajK();
                                    }
                                    if (c13364b.qQE != 0) {
                                        lY2 = C37952b.m64170lY(504);
                                        lY2.timeStamp = c13365a.qQv;
                                        lY2.mo60722tx(c13364b.qQD).mo60720mb(c13364b.qQB).mo60718cS(c13364b.qQC).mo60720mb(c13364b.qQE).mo60720mb(c13364b.qQL).mo60720mb(c13364b.qQK).mo60720mb(c13364b.qQM).mo60720mb(c13364b.qQN);
                                        lY2.ajK();
                                    }
                                }
                            }
                            lY = C37952b.m64170lY(506);
                            lY.timeStamp = c13365a.qQv;
                            lY.ajK();
                        }
                        AppMethodBeat.m2505o(39472);
                        return voidR;
                    }
                });
            }
            AppMethodBeat.m2505o(39482);
        }

        /* renamed from: ad */
        public final void mo25741ad(int i, boolean z) {
            AppMethodBeat.m2504i(39483);
            if (SnsTimeLineUI.this.ryn != null) {
                SnsTimeLineUI.this.ryn.rEB.notifyVendingDataChange();
            }
            if (!z) {
                SnsTimeLineUI.this.mo20830SK().mo28389aG(C3879b.class);
            }
            AppMethodBeat.m2505o(39483);
        }

        /* renamed from: ln */
        public final void mo25753ln(boolean z) {
            AppMethodBeat.m2504i(39484);
            SnsTimeLineUI snsTimeLineUI = SnsTimeLineUI.this;
            snsTimeLineUI.rzc = z;
            C7306ak bCo = C13373af.bCo();
            C21925g cnC = C13373af.cnC();
            C43558b cnA = C13373af.cnA();
            if (z) {
                if (cnC.qHJ || cnA.qHJ) {
                    bCo.removeCallbacks(snsTimeLineUI.rzd);
                    bCo.removeCallbacks(snsTimeLineUI.rze);
                    bCo.postDelayed(snsTimeLineUI.rzd, 0);
                    AppMethodBeat.m2505o(39484);
                    return;
                }
            } else if (!(cnC.qHJ && cnA.qHJ)) {
                bCo.removeCallbacks(snsTimeLineUI.rzd);
                bCo.removeCallbacks(snsTimeLineUI.rze);
                bCo.postDelayed(snsTimeLineUI.rze, 0);
            }
            AppMethodBeat.m2505o(39484);
        }

        /* renamed from: fA */
        public final void mo25749fA(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$21 */
    class C3504721 implements C16028b<C3879b> {
        C3504721() {
        }

        /* renamed from: bj */
        public final /* synthetic */ void mo28394bj(Object obj) {
            AppMethodBeat.m2504i(39485);
            C3879b c3879b = (C3879b) obj;
            if (c3879b != null) {
                if (c3879b.rNt > 0 || ((c3879b.rNu != null && c3879b.rNu.size() > 0) || (SnsTimeLineUI.this.mUIAction.qQt != null && SnsTimeLineUI.this.mUIAction.qQt.ctj()))) {
                    SnsTimeLineUI.this.ryo.setVisibility(0);
                } else {
                    SnsTimeLineUI.this.ryo.setVisibility(8);
                }
                if (c3879b.rNt <= 0 || SnsTimeLineUI.this.rzl != 0) {
                    SnsTimeLineUI.this.ryo.findViewById(2131827778).setVisibility(8);
                } else {
                    SnsTimeLineUI.m57631a(SnsTimeLineUI.this, c3879b);
                    SnsTimeLineUI.this.ryo.findViewById(2131827778).setVisibility(0);
                }
                if (c3879b.rNu == null || c3879b.rNu.size() <= 0) {
                    SnsTimeLineUI.this.ryp.setVisibility(8);
                } else {
                    SnsTimeLineUI.this.ryp.setVisibility(0);
                    SnsTimeLineUI.this.ryp.removeAllViews();
                    for (Long longValue : c3879b.rNu) {
                        SnsTimeLineUI.m57630a(SnsTimeLineUI.this, longValue.longValue());
                    }
                }
                if (SnsTimeLineUI.this.ryn != null && SnsTimeLineUI.this.ryv.hasDrawed()) {
                    SnsTimeLineUI.this.ryn.rEB.notifyVendingDataChange();
                    C4990ab.m7416i("MicroMsg.SnsTimeLineUI", "has not show view, pass");
                }
            }
            AppMethodBeat.m2505o(39485);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$28 */
    class C3504828 implements OnLongClickListener {
        C3504828() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(39496);
            if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                SnsTimeLineUI.this.ryt.rhn.qMn.mo69109kO(true);
            }
            C1720g.m3537RQ();
            boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(7490, Boolean.TRUE)).booleanValue();
            C1720g.m3537RQ();
            String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, null);
            if (!C5046bo.isNullOrNil(str)) {
                byte[] atV = C8769e.atV(str);
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(atV, 0, atV.length);
                obtain.setDataPosition(0);
                try {
                    SnsTimeLineUI.this.startActivityForResult((Intent) Intent.CREATOR.createFromParcel(obtain), 9);
                    AppMethodBeat.m2505o(39496);
                } catch (Exception e) {
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, (Object) "");
                }
                return true;
            }
            if (booleanValue) {
                SnsTimeLineUI.this.startActivity(new Intent().setClass(SnsTimeLineUI.this, SnsLongMsgUI.class));
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(7490, Boolean.FALSE);
            } else {
                Intent intent = new Intent();
                intent.setClass(SnsTimeLineUI.this, SnsUploadUI.class);
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", C5046bo.anT());
                intent.putExtra("sns_comment_type", 1);
                intent.putExtra("Ksnsupload_type", 9);
                C37952b lY = C37952b.m64170lY(705);
                lY.mo60721mc(lY.fQh).mo60723ty(System.currentTimeMillis()).mo60721mc(lY.fQi).mo60721mc(1);
                lY = C24827g.qTp.mo37378b(lY);
                lY.ajK();
                lY.mo60717b(intent, "intent_key_StatisticsOplog");
                SnsTimeLineUI.this.startActivityForResult(intent, 9);
            }
            AppMethodBeat.m2505o(39496);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$29 */
    class C3504929 extends C1153b {
        C3504929() {
        }

        /* renamed from: a */
        public final void mo4386a(String str, long j, int i) {
            AppMethodBeat.m2504i(39497);
            super.mo4386a(str, j, i);
            if (i > 0 && !C5046bo.isNullOrNil(str) && str.endsWith(SnsTimeLineUI.this.getClass().getSimpleName())) {
                SnsTimeLineUI.this.eEO = SnsTimeLineUI.this.eEO + ((long) i);
            }
            AppMethodBeat.m2505o(39497);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$33 */
    class C3505033 implements C41351a {
        C3505033() {
        }

        public final void cuo() {
            AppMethodBeat.m2504i(39503);
            C34830g.m57194BN(14);
            AppMethodBeat.m2505o(39503);
        }

        public final void cup() {
            AppMethodBeat.m2504i(39504);
            C34830g.m57195BO(14);
            AppMethodBeat.m2505o(39504);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$27 */
    class C3505227 implements OnMenuItemClickListener {
        C3505227() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39495);
            SnsTimeLineUI.m57610E(SnsTimeLineUI.this);
            AppMethodBeat.m2505o(39495);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$31 */
    class C3505331 implements AnimationListener {
        C3505331() {
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(39499);
            C4990ab.m7416i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
            AppMethodBeat.m2505o(39499);
        }

        public final void onAnimationRepeat(Animation animation) {
            AppMethodBeat.m2504i(39500);
            C4990ab.m7416i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
            AppMethodBeat.m2505o(39500);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(39501);
            C4990ab.m7416i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
            AppMethodBeat.m2505o(39501);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$32 */
    class C3505432 implements C13632a {
        C3505432() {
        }

        public final boolean cud() {
            AppMethodBeat.m2504i(39502);
            SnsTimeLineUI.this.mo20830SK().mo28389aG(C3879b.class);
            AppMethodBeat.m2505o(39502);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$34 */
    class C3505534 extends C4884c<C26187lb> {
        C3505534() {
            AppMethodBeat.m2504i(39505);
            this.xxI = C26187lb.class.getName().hashCode();
            AppMethodBeat.m2505o(39505);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39506);
            C26187lb c26187lb = (C26187lb) c4883b;
            C4990ab.m7410d("MicroMsg.SnsTimeLineUI", "notifyTimelineFpListener callback");
            if (c26187lb instanceof C26187lb) {
                SnsTimeLineUI.m57635b(SnsTimeLineUI.this);
                SnsTimeLineUI.this.ryn.rEB.notifyVendingDataChange();
            }
            AppMethodBeat.m2505o(39506);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$51 */
    class C3505751 implements DialogInterface.OnClickListener {
        C3505751() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39525);
            if (SnsTimeLineUI.this.ryH.scene != 3) {
                if (i == 0) {
                    SnsTimeLineUI.this.ryH.mo55710Ek(3);
                } else {
                    SnsTimeLineUI.this.ryH.mo55710Ek(2);
                }
                SnsTimeLineUI.m57634b(SnsTimeLineUI.this.ryH);
            }
            AppMethodBeat.m2505o(39525);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$53 */
    class C3505853 implements Runnable {
        C3505853() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39527);
            SnsTimeLineUI.this.mUIAction.nDp.setSelection(0);
            C35069a h = SnsTimeLineUI.this.ryu;
            if (h.rzY) {
                if (SnsTimeLineUI.rza.booleanValue()) {
                    C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "force init %s %s %s", Boolean.valueOf(h.rzY), Float.valueOf(h.rAb), Integer.valueOf(h.rzZ));
                }
                LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.this.ryq.getLayoutParams();
                layoutParams.y = h.rzZ;
                SnsTimeLineUI.this.ryq.setLayoutParams(layoutParams);
                h.rzO = h.rAa;
                h.rzS = h.rAb;
            }
            SnsTimeLineUI.this.ryu.cur();
            C13619b o = SnsTimeLineUI.this.rym;
            SnsTimeLineUI.this.rzh;
            o.mo25823d(SnsTimeLineUI.this.igi, SnsTimeLineUI.this.ryD, SnsTimeLineUI.this.rjn, SnsTimeLineUI.this.ryE);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, Integer.valueOf(2));
            AppMethodBeat.m2505o(39527);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$16 */
    class C3505916 implements C5543a {
        C3505916() {
        }

        /* renamed from: pO */
        public final void mo11252pO(int i) {
            AppMethodBeat.m2504i(39468);
            SnsTimeLineUI.this.plv.setPadding(0, i, 0, 0);
            AppMethodBeat.m2505o(39468);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$40 */
    class C3506040 implements OnClickListener {
        C3506040() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39514);
            if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                SnsTimeLineUI.this.ryt.rhn.qMn.mo69108kN(true);
            }
            C3879b c3879b = (C3879b) SnsTimeLineUI.this.mo20830SK().mo28391x(C3879b.class);
            C37952b lY = C37952b.m64170lY(725);
            lY.mo60720mb(c3879b.rNt);
            lY.ajK();
            Intent intent = new Intent();
            intent.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
            SnsTimeLineUI.this.startActivityForResult(intent, 13);
            AppMethodBeat.m2505o(39514);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$45 */
    class C3506145 extends C4884c<C18312lc> {
        C3506145() {
            AppMethodBeat.m2504i(39519);
            this.xxI = C18312lc.class.getName().hashCode();
            AppMethodBeat.m2505o(39519);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39520);
            SnsTimeLineUI.this.ryn.rEB.notifyVendingDataChange();
            AppMethodBeat.m2505o(39520);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$4 */
    class C350624 extends C4884c<C9362gs> {
        C350624() {
            AppMethodBeat.m2504i(39447);
            this.xxI = C9362gs.class.getName().hashCode();
            AppMethodBeat.m2505o(39447);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39448);
            C9362gs c9362gs = (C9362gs) c4883b;
            SnsTimeLineUI.m57629a(SnsTimeLineUI.this, c9362gs.cBr.cBu, c9362gs.cBr.cBt, c9362gs);
            AppMethodBeat.m2505o(39448);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$58 */
    class C3506358 implements DialogInterface.OnClickListener {
        C3506358() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39534);
            dialogInterface.dismiss();
            SnsTimeLineUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(39534);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$59 */
    class C3506459 implements DialogInterface.OnClickListener {
        C3506459() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39535);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(39535);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$5 */
    class C350655 extends C4884c<C9326e> {
        C350655() {
            AppMethodBeat.m2504i(39449);
            this.xxI = C9326e.class.getName().hashCode();
            AppMethodBeat.m2505o(39449);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            boolean z = true;
            AppMethodBeat.m2504i(39450);
            C9326e c9326e = (C9326e) c4883b;
            if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                C43548b c43548b = SnsTimeLineUI.this.ryt.rhn.qMn;
                boolean z2 = c9326e.crS.active;
                String str = c9326e.crS.className;
                if (str.toLowerCase().indexOf("sns") < 0 && str.toLowerCase().indexOf("sightuploadui") < 0 && !str.contains("WebViewUI")) {
                    z = false;
                }
                if (!z) {
                    C4990ab.m7410d("MicroMsg.SnsBrowseInfoHelper", "handleActivityStatusChanged, not sns scene, className" + str + ",_active=" + z2);
                } else if (!z2) {
                    c43548b.qRA = System.currentTimeMillis();
                } else if (c43548b.qRA > 0) {
                    c43548b.qRz += System.currentTimeMillis() - c43548b.qRA;
                    c43548b.qRA = 0;
                }
            }
            AppMethodBeat.m2505o(39450);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$6 */
    class C350666 extends C4884c<C37789qx> {
        C350666() {
            AppMethodBeat.m2504i(39451);
            this.xxI = C37789qx.class.getName().hashCode();
            AppMethodBeat.m2505o(39451);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39452);
            if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                SnsTimeLineUI.this.ryt.rhn.qMn.mo69118kX(true);
            }
            AppMethodBeat.m2505o(39452);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$7 */
    class C350677 extends C4884c<C32626rb> {
        C350677() {
            AppMethodBeat.m2504i(39453);
            this.xxI = C32626rb.class.getName().hashCode();
            AppMethodBeat.m2505o(39453);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39454);
            C32626rb c32626rb = (C32626rb) c4883b;
            if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                SnsTimeLineUI.this.ryt.rhn.qMn.mo69104gg(c32626rb.cNg.cwT, c32626rb.cNg.cFc);
            }
            AppMethodBeat.m2505o(39454);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$8 */
    class C350688 extends C4884c<C26228rf> {
        C350688() {
            AppMethodBeat.m2504i(39455);
            this.xxI = C26228rf.class.getName().hashCode();
            AppMethodBeat.m2505o(39455);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39456);
            C26228rf c26228rf = (C26228rf) c4883b;
            if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                C43548b c43548b = SnsTimeLineUI.this.ryt.rhn.qMn;
                c43548b.qSs.add(c26228rf.cNk.cFc);
            }
            AppMethodBeat.m2505o(39456);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$a */
    class C35069a extends Animation {
        int DELAY_TIME = 600;
        private ListView nDp;
        float rAa = 0.0f;
        float rAb = 0.0f;
        float rAc = 0.0f;
        float rAd = 0.0f;
        private float rzM;
        private float rzN;
        float rzO = -1.0f;
        float rzP;
        private float rzQ = 50.0f;
        private float rzR = 10.0f;
        float rzS = 0.0f;
        private float rzT = 0.0f;
        private float rzU;
        private float rzV;
        boolean rzW;
        int rzX;
        boolean rzY = false;
        int rzZ = 0;

        public C35069a(ListView listView) {
            this.nDp = listView;
        }

        /* renamed from: bb */
        public final void mo55701bb(float f) {
            AppMethodBeat.m2504i(39542);
            if (this.nDp != null) {
                if (this.nDp.getFirstVisiblePosition() != 0) {
                    SnsTimeLineUI.m57636b(SnsTimeLineUI.this, 8);
                } else if (SnsTimeLineUI.this.mUIAction.qQt.getTop() >= SnsTimeLineUI.this.ryu.rzX) {
                    SnsTimeLineUI.m57636b(SnsTimeLineUI.this, 0);
                }
            }
            if (SnsTimeLineUI.rza.booleanValue()) {
                C4990ab.m7411d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s", Float.valueOf(f), Float.valueOf(this.rzP), Float.valueOf(this.rzO));
            }
            if (SnsTimeLineUI.this.ryq.getVisibility() != 0) {
                AppMethodBeat.m2505o(39542);
                return;
            }
            SnsTimeLineUI.this.ryq.clearAnimation();
            init();
            if (f <= (-this.rzQ)) {
                f = -this.rzQ;
            }
            if (f >= this.rzQ) {
                f = this.rzQ;
            }
            if (f < 0.0f) {
                this.rzS -= f * 2.0f;
            } else {
                this.rzS -= f / 2.0f;
            }
            float f2 = this.rzS;
            if (f2 < this.rzP) {
                f2 = this.rzP;
                this.rzS = this.rzP;
            }
            if (f2 > this.rzO) {
                f2 = this.rzO;
                this.rzS = this.rzO;
            }
            float f3 = f2;
            if (SnsTimeLineUI.rza.booleanValue()) {
                C4990ab.m7411d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s sumY %s translateY %s distanceY %s", Float.valueOf(f), Float.valueOf(this.rzP), Float.valueOf(this.rzO), Float.valueOf(this.rzS), Float.valueOf(f3), Float.valueOf(this.rzQ));
            }
            if (f3 == this.rzO) {
                f2 = f * 2.0f;
            } else {
                f2 = 5.0f * f;
            }
            SnsTimeLineUI.this.ryq.setScaleType(C15991a.MATRIX);
            SnsTimeLineUI.this.ryq.getImageMatrix().postRotate(f2, this.rzM, this.rzN);
            SnsTimeLineUI.this.ryq.setImageResource(C1318a.friendactivity_refresh);
            LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.this.ryq.getLayoutParams();
            layoutParams.y = (int) f3;
            SnsTimeLineUI.this.ryq.setLayoutParams(layoutParams);
            SnsTimeLineUI.this.ryq.invalidate();
            AppMethodBeat.m2505o(39542);
        }

        public final void cur() {
            AppMethodBeat.m2504i(39543);
            if (SnsTimeLineUI.rza.booleanValue()) {
                C4990ab.m7410d("MicroMsg.RefreshAnim", "animtest playLoading");
            }
            if (SnsTimeLineUI.this.ryq.getVisibility() != 0) {
                AppMethodBeat.m2505o(39543);
                return;
            }
            init();
            this.rzS = this.rzO + 20.0f;
            LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.this.ryq.getLayoutParams();
            layoutParams.y = (int) this.rzO;
            SnsTimeLineUI.this.ryq.setLayoutParams(layoutParams);
            cut();
            AppMethodBeat.m2505o(39543);
        }

        public final void cus() {
            AppMethodBeat.m2504i(39544);
            if (SnsTimeLineUI.rza.booleanValue()) {
                C4990ab.m7417i("MicroMsg.RefreshAnim", "play end vis: %d, sumY %f MAX_Y %f", Integer.valueOf(SnsTimeLineUI.this.ryq.getVisibility()), Float.valueOf(this.rzS), Float.valueOf(this.rzO));
            }
            if (SnsTimeLineUI.this.ryq.getVisibility() != 0) {
                AppMethodBeat.m2505o(39544);
                return;
            }
            init();
            if (this.rzS < this.rzO - this.rzR) {
                AppMethodBeat.m2505o(39544);
                return;
            }
            SnsTimeLineUI.this.ryq.clearAnimation();
            mo55707kK((long) (this.DELAY_TIME + 100));
            SnsTimeLineUI.this.ryq.startAnimation(this);
            this.rzW = false;
            AppMethodBeat.m2505o(39544);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: kK */
        public final void mo55707kK(long j) {
            AppMethodBeat.m2504i(39545);
            if (SnsTimeLineUI.rza.booleanValue()) {
                C4990ab.m7411d("MicroMsg.RefreshAnim", "setDurationTime durationMillis %s %s", Long.valueOf(j), C5046bo.dpG().toString());
            }
            setDuration(j);
            AppMethodBeat.m2505o(39545);
        }

        public final void cut() {
            AppMethodBeat.m2504i(39546);
            if (SnsTimeLineUI.rza.booleanValue()) {
                C4990ab.m7410d("MicroMsg.RefreshAnim", "animtest setAcitonUp");
            }
            if (SnsTimeLineUI.this.ryq.getVisibility() != 0) {
                AppMethodBeat.m2505o(39546);
                return;
            }
            init();
            SnsTimeLineUI.this.ryq.clearAnimation();
            if (SnsTimeLineUI.rza.booleanValue()) {
                C4990ab.m7419v("MicroMsg.RefreshAnim", "setAcitonUp1 sumY  %s MAX_Y %s %s", Float.valueOf(this.rzS), Float.valueOf(this.rzO), C5046bo.dpG().toString());
            }
            SnsTimeLineUI.this.ryq.startAnimation(this);
            if (this.rzS >= this.rzO - this.rzR) {
                mo55707kK(20000);
                this.rzW = false;
                AppMethodBeat.m2505o(39546);
                return;
            }
            mo55707kK((long) (this.DELAY_TIME + 100));
            this.rzW = true;
            AppMethodBeat.m2505o(39546);
        }

        /* Access modifiers changed, original: final */
        public final void init() {
            AppMethodBeat.m2504i(39547);
            if (this.rzO == -1.0f || ((double) this.rzN) < 0.1d) {
                this.rzO = (float) C4977b.m7371b(SnsTimeLineUI.this, 70.0f);
                this.rzQ = (float) C4977b.m7371b(SnsTimeLineUI.this, 16.0f);
                this.rzM = (float) (SnsTimeLineUI.this.ryq.getWidth() / 2);
                this.rzN = (float) (SnsTimeLineUI.this.ryq.getHeight() / 2);
                this.rzT = (float) ((-SnsTimeLineUI.this.ryq.getHeight()) * 2);
                if (this.rzT == 0.0f) {
                    this.rzT = (float) (-C4977b.m7371b(SnsTimeLineUI.this, 40.0f));
                }
                this.rzP = this.rzT;
                if (SnsTimeLineUI.rza.booleanValue()) {
                    C4990ab.m7411d("MicroMsg.RefreshAnim", "init MIN_Y %s MAX_Y %s targetInitY %s distanceY %s", Float.valueOf(this.rzP), Float.valueOf(this.rzO), Float.valueOf(this.rzT), Float.valueOf(this.rzQ));
                }
                this.rzS = this.rzP;
                if (!this.rzY) {
                    if (SnsTimeLineUI.rza.booleanValue()) {
                        C4990ab.m7416i("MicroMsg.RefreshAnim", "initState");
                    }
                    this.rzZ = ((LayoutParams) SnsTimeLineUI.this.ryq.getLayoutParams()).y;
                    this.rAa = this.rzO;
                    this.rAb = this.rzS;
                }
                this.rzY = true;
            }
            AppMethodBeat.m2505o(39547);
        }

        /* Access modifiers changed, original: protected|final */
        public final void applyTransformation(float f, Transformation transformation) {
            AppMethodBeat.m2504i(39548);
            if (SnsTimeLineUI.rza.booleanValue()) {
                C4990ab.m7411d("MicroMsg.RefreshAnim", "animtest applyTransformation vis %s interpolatedTime %s isJustUp %s", Integer.valueOf(SnsTimeLineUI.this.ryq.getVisibility()), Float.valueOf(f), Boolean.valueOf(this.rzW));
            }
            if (SnsTimeLineUI.this.ryq.getVisibility() != 0) {
                AppMethodBeat.m2505o(39548);
                return;
            }
            float duration = (f - this.rzU) * ((float) getDuration());
            if (duration < 2.0f) {
                if (SnsTimeLineUI.rza.booleanValue()) {
                    C4990ab.m7411d("MicroMsg.RefreshAnim", "applyTransformation wawawa %s", Float.valueOf(duration));
                }
                AppMethodBeat.m2505o(39548);
                return;
            }
            this.rzU = f;
            SnsTimeLineUI.this.ryq.setImageResource(C1318a.friendactivity_refresh);
            SnsTimeLineUI.this.ryq.setScaleType(C15991a.MATRIX);
            if (((float) getDuration()) * f >= ((float) (getDuration() - ((long) this.DELAY_TIME))) || this.rzW) {
                LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.this.ryq.getLayoutParams();
                if (((float) layoutParams.y) <= this.rzT) {
                    AppMethodBeat.m2505o(39548);
                    return;
                }
                if (this.rAc == 0.0f) {
                    this.rAc = (-this.rzT) + ((float) layoutParams.y);
                    this.rAd = (float) layoutParams.y;
                    this.rzV = f;
                }
                float f2 = this.rAd - (this.rAc * ((f - this.rzV) / (1.0f - this.rzV)));
                if (SnsTimeLineUI.rza.booleanValue()) {
                    C4990ab.m7417i("MicroMsg.RefreshAnim", "animcheck interpolatedTime y %s duration %s factor %s residualTime %s pass %s ", Float.valueOf(f2), Long.valueOf(getDuration()), Float.valueOf(r1), Float.valueOf(r2), Float.valueOf(this.rzV * ((float) getDuration())));
                }
                if (((float) layoutParams.y) > f2) {
                    layoutParams.y = (int) f2;
                }
                this.rzS = (float) layoutParams.y;
                SnsTimeLineUI.this.ryq.setLayoutParams(layoutParams);
            } else {
                if (SnsTimeLineUI.rza.booleanValue()) {
                    C4990ab.m7410d("MicroMsg.RefreshAnim", "animcheck delt Rotate " + (duration / 2.5f));
                }
                SnsTimeLineUI.this.ryq.getImageMatrix().postRotate(duration / 2.5f, this.rzM, this.rzN);
            }
            SnsTimeLineUI.this.ryq.invalidate();
            AppMethodBeat.m2505o(39548);
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(39549);
            super.initialize(i, i2, i3, i4);
            if (SnsTimeLineUI.rza.booleanValue()) {
                C4990ab.m7417i("MicroMsg.RefreshAnim", "anim initialize %s", C5046bo.dpG().toString());
            }
            this.rzU = 0.0f;
            this.rzV = 0.0f;
            this.rAc = 0.0f;
            this.rAd = 0.0f;
            AppMethodBeat.m2505o(39549);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$b */
    class C35070b {
        public int rAe;
        public int type;

        private C35070b() {
            this.type = 0;
        }

        /* synthetic */ C35070b(SnsTimeLineUI snsTimeLineUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$c */
    class C35071c {
        public boolean active;
        public String rAf;
        public long rAg;
        public int rAh;
        public int rAi;
        public long rAj;
        public long rAk;
        public int rAl;
        public long rAm;
        public int rAn;
        public long rAo;
        public int scene;

        private C35071c() {
            this.active = true;
            this.rAf = "";
        }

        /* synthetic */ C35071c(SnsTimeLineUI snsTimeLineUI, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void reset() {
            this.scene = 0;
            this.rAg = 0;
            this.rAh = -1;
            this.rAi = 0;
            this.rAj = 0;
            this.rAk = 0;
            this.rAl = 0;
            this.rAm = 0;
            this.rAn = 0;
            this.rAo = 0;
        }

        /* renamed from: Ei */
        public final void mo55708Ei(int i) {
            AppMethodBeat.m2504i(39550);
            if (this.active) {
                this.rAi = i;
                this.rAj = C5046bo.anU();
                AppMethodBeat.m2505o(39550);
                return;
            }
            AppMethodBeat.m2505o(39550);
        }

        /* renamed from: Ej */
        public final void mo55709Ej(int i) {
            AppMethodBeat.m2504i(39551);
            if (this.active) {
                reset();
                this.scene = 2;
                this.rAk = C5046bo.anU();
                this.rAl = i;
                AppMethodBeat.m2505o(39551);
                return;
            }
            AppMethodBeat.m2505o(39551);
        }

        /* renamed from: Ek */
        public final void mo55710Ek(int i) {
            AppMethodBeat.m2504i(39552);
            if (this.active) {
                reset();
                this.scene = 3;
                this.rAm = C5046bo.anU();
                this.rAo = 0;
                this.rAn = i;
                AppMethodBeat.m2505o(39552);
                return;
            }
            AppMethodBeat.m2505o(39552);
        }

        public final String toString() {
            AppMethodBeat.m2504i(39553);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.rAf).append(",").append(this.scene).append(",").append(this.rAg).append(",").append(this.rAh).append(",").append(this.rAi).append(",").append(this.rAj).append(",").append(this.rAk).append(",").append(this.rAl).append(",").append(this.rAm).append(",").append(this.rAn).append(",").append(this.rAo);
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(39553);
            return stringBuilder2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$26 */
    class C3507426 implements OnMenuItemClickListener {
        C3507426() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39494);
            Intent intent = new Intent();
            intent.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
            intent.putExtra("sns_msg_force_show_all", true);
            SnsTimeLineUI.this.startActivityForResult(intent, 8);
            AppMethodBeat.m2505o(39494);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$35 */
    class C3507535 implements C29165a {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$35$1 */
        class C40041 implements Runnable {
            C40041() {
            }

            public final void run() {
                AppMethodBeat.m2504i(39507);
                if (SnsTimeLineUI.this.ryn == null || SnsTimeLineUI.this.ryv == null) {
                    C4990ab.m7416i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
                    AppMethodBeat.m2505o(39507);
                    return;
                }
                SnsTimeLineUI.this.ryv.setListener(null);
                SnsTimeLineUI.this.rhv = SnsTimeLineUI.this.ryr;
                if (SnsTimeLineUI.this.ryx) {
                    C4990ab.m7420w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
                    AppMethodBeat.m2505o(39507);
                    return;
                }
                if (SnsTimeLineUI.this.rhv) {
                    C13373af.cnv().mo8613B(C13373af.cnM().qMB, -1);
                }
                if (!SnsTimeLineUI.this.rhv) {
                    C4990ab.m7416i("MicroMsg.SnsTimeLineUI", "onViewDrawed doFpList");
                    C13619b o = SnsTimeLineUI.this.rym;
                    SnsTimeLineUI.this.rzh;
                    o.mo25823d(SnsTimeLineUI.this.igi, SnsTimeLineUI.this.ryD, SnsTimeLineUI.this.rjn, SnsTimeLineUI.this.ryE);
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, Integer.valueOf(1));
                }
                SnsTimeLineUI.this.rhv = false;
                if (SnsTimeLineUI.this.rqn != null) {
                    SnsTimeLineUI.this.rqn.mo25442kH(false);
                }
                AppMethodBeat.m2505o(39507);
            }
        }

        C3507535() {
        }

        public final void bCv() {
            AppMethodBeat.m2504i(39508);
            C4990ab.m7416i("MicroMsg.SnsTimeLineUI", "sns has drawed");
            SnsTimeLineUI.this.ryv.post(new C40041());
            AppMethodBeat.m2505o(39508);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$46 */
    class C3507646 implements Runnable {
        C3507646() {
        }

        public final void run() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUI$52 */
    class C3507952 implements OnClickListener {
        C3507952() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39526);
            if (SystemClock.elapsedRealtime() - SnsTimeLineUI.this.ryj < 300) {
                SnsTimeLineUI.m57617K(SnsTimeLineUI.this);
            }
            SnsTimeLineUI.this.ryj = SystemClock.elapsedRealtime();
            C13373af.bCo().removeCallbacks(SnsTimeLineUI.this.rzg);
            SnsTimeLineUI.this.rzg.run();
            AppMethodBeat.m2505o(39526);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsTimeLineUI() {
        AppMethodBeat.m2504i(39554);
        this.ryl = this.ryk != null ? this.ryk.cvE() : null;
        this.rym = new C13619b();
        this.ryr = false;
        this.rys = false;
        this.rhv = false;
        this.ryw = 0;
        this.ryx = false;
        this.ryy = "";
        this.ryz = new C13363a();
        this.rqn = new C13342g(1);
        this.ryA = new C13417av();
        this.ryB = new C39756at();
        this.ryG = "";
        this.ryH = new C35071c(this, (byte) 0);
        this.ryI = new C220391();
        this.ryJ = new C1355612();
        this.ryK = new C713023();
        this.ryL = false;
        this.qQu = false;
        this.ryM = new C3505534();
        this.ryN = new C3506145();
        this.ryO = new C2204656();
        this.ryP = new C713260();
        this.ryQ = new C2915761();
        this.ryR = new C2204862();
        this.ryS = new C291502();
        this.ryT = new C291533();
        this.ryU = new C350624();
        this.qMM = new C350655();
        this.ryV = new C350666();
        this.ryW = new C350677();
        this.ryX = new C350688();
        this.ryY = new C220499();
        this.ryZ = new C1355510();
        this.rzb = 0;
        this.rzc = false;
        this.oOX = 0;
        this.rzd = new C2203617();
        this.rze = new C2203718();
        this.rzf = ((C7366b) C5703d.zYq.zYv).f2007a;
        this.rzg = new C2203819();
        this.rzh = new C3504520();
        this.rzi = new C3504721();
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.rzj = true;
        this.oes = 0;
        this.eEO = 0;
        this.fAq = 0;
        this.mnM = new C3504929();
        this.rzl = 0;
        this.rzm = new C2915443();
        this.rzp = null;
        this.rzq = new C3507952();
        this.rzr = false;
        AppMethodBeat.m2505o(39554);
    }

    /* renamed from: M */
    static /* synthetic */ void m57619M(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.m2504i(39598);
        snsTimeLineUI.cug();
        AppMethodBeat.m2505o(39598);
    }

    /* renamed from: t */
    static /* synthetic */ void m57657t(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.m2504i(39590);
        snsTimeLineUI.cuf();
        AppMethodBeat.m2505o(39590);
    }

    /* renamed from: u */
    static /* synthetic */ void m57658u(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.m2504i(39591);
        snsTimeLineUI.cue();
        AppMethodBeat.m2505o(39591);
    }

    /* renamed from: a */
    public final void mo17657a(boolean z, boolean z2, final String str, boolean z3, boolean z4, int i, long j, String str2) {
        AppMethodBeat.m2504i(39555);
        this.rzf.removeCallbacks(this.ryI);
        final boolean z5 = z2;
        final int i2 = i;
        final String str3 = str2;
        final boolean z6 = z;
        C5698f.dMn().mo15893d(new C5681a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(39464);
                Void voidR = (Void) obj;
                C29169a a = SnsTimeLineUI.this.ryn;
                if (a != null) {
                    a.rEB.mo37603ZK(str);
                    a.rEB.mo37602PA();
                    a.rEB.notifyVendingDataChange();
                }
                AppMethodBeat.m2505o(39464);
                return voidR;
            }
        }).mo15896f(new C5681a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(39461);
                Void voidR = (Void) obj;
                if (SnsTimeLineUI.this.ryu != null) {
                    SnsTimeLineUI.this.rys = false;
                    SnsTimeLineUI.this.ryu.cus();
                }
                SnsTimeLineUI.this.mUIAction.koC = z5;
                if (z5) {
                    SnsTimeLineUI.this.mUIAction.mo25760lc(false);
                    if (SnsTimeLineUI.this.rzl == 1) {
                        SnsTimeLineUI.this.mUIAction.mo25757bf(i2, str3);
                    }
                } else if (z6) {
                    C13619b o = SnsTimeLineUI.this.rym;
                    SnsTimeLineUI.this.rzh;
                    o.mo25824e(SnsTimeLineUI.this.igi, SnsTimeLineUI.this.ryD, SnsTimeLineUI.this.rjn, 0);
                }
                AppMethodBeat.m2505o(39461);
                return voidR;
            }
        });
        AppMethodBeat.m2505o(39555);
    }

    /* renamed from: a */
    public final void mo17656a(boolean z, final String str, boolean z2, boolean z3, int i, long j, String str2) {
        AppMethodBeat.m2504i(39556);
        this.rzf.removeCallbacks(this.ryI);
        final boolean z4 = z;
        final boolean z5 = z3;
        final int i2 = i;
        final String str3 = str2;
        final long j2 = j;
        final boolean z6 = z2;
        C5698f.dMn().mo15893d(new C5681a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(39467);
                Void voidR = (Void) obj;
                C29169a a = SnsTimeLineUI.this.ryn;
                if (a != null) {
                    a.rEB.mo37603ZK(str);
                    a.rEB.ctK();
                    a.rEB.notifyVendingDataChange();
                }
                AppMethodBeat.m2505o(39467);
                return voidR;
            }
        }).mo15896f(new C5681a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(39466);
                Void a = m57673a((Void) obj);
                AppMethodBeat.m2505o(39466);
                return a;
            }

            /* renamed from: a */
            private Void m57673a(Void voidR) {
                AppMethodBeat.m2504i(39465);
                if (SnsTimeLineUI.this.ryu != null) {
                    SnsTimeLineUI.this.rys = false;
                    SnsTimeLineUI.this.ryu.cus();
                }
                SnsTimeLineUI.this.mUIAction.koC = z4;
                if (SnsTimeLineUI.this.rzl == 0) {
                    C4990ab.m7411d("MicroMsg.SnsTimeLineUI", "onNpSize %s", Boolean.valueOf(z4));
                    if (z4) {
                        SnsTimeLineUI.this.mUIAction.mo25760lc(false);
                    }
                    AppMethodBeat.m2505o(39465);
                } else {
                    if (!z5 || SnsTimeLineUI.this.ryC.equals(SnsTimeLineUI.this.igi)) {
                        if (SnsTimeLineUI.this.ryC.equals(SnsTimeLineUI.this.igi) && j2 != 0) {
                            C1720g.m3537RQ();
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(j2));
                        }
                        if (z4) {
                            SnsTimeLineUI.this.mUIAction.mo25760lc(z6);
                        }
                    } else {
                        SnsTimeLineUI.this.mUIAction.koC = true;
                        SnsTimeLineUI.this.mUIAction.mo25757bf(i2, str3);
                    }
                    AppMethodBeat.m2505o(39465);
                }
                return voidR;
            }
        });
        AppMethodBeat.m2505o(39556);
    }

    /* renamed from: xE */
    public final void mo17446xE(int i) {
        AppMethodBeat.m2504i(39557);
        super.mo17446xE(i);
        if (VERSION.SDK_INT >= 21 && this.plv != null) {
            this.plv.setBackgroundColor(getWindow().getStatusBarColor());
            C5546d.m8368a(getWindow());
        }
        AppMethodBeat.m2505o(39557);
    }

    static {
        AppMethodBeat.m2504i(39602);
        HandlerThread handlerThread = new HandlerThread("sns");
        rzk = handlerThread;
        handlerThread.start();
        AppMethodBeat.m2505o(39602);
    }

    /* renamed from: Eg */
    private void m57611Eg(int i) {
        AppMethodBeat.m2504i(39558);
        if (rza.booleanValue()) {
            boolean z;
            String str = "MicroMsg.SnsTimeLineUI";
            String str2 = "setRefreshAnimVisible %s %s";
            Object[] objArr = new Object[2];
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = C5046bo.dpG().toString();
            C4990ab.m7417i(str, str2, objArr);
        }
        this.ryq.setVisibility(i);
        AppMethodBeat.m2505o(39558);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        AppMethodBeat.m2504i(39559);
        C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", keyEvent.toString());
        int i2 = this.mController.ymc;
        C29220i c29220i = this.ryt;
        if (keyEvent.getKeyCode() == 4 && c29220i.rhq.getVisibility() == 0) {
            c29220i.rhq.setVisibility(8);
            i = 1;
        }
        if (i == 0 || i2 != 2) {
            boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.m2505o(39559);
            return dispatchKeyEvent;
        }
        AppMethodBeat.m2505o(39559);
        return true;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39560);
        if (this.mController != null) {
            this.mController.mo11176aC(2, true);
        }
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        C30036f.m47544m(this);
        this.ylm = true;
        super.onCreate(bundle);
        if (C1720g.m3534RN().mo5161QY()) {
            C34939a cvE;
            C3878a c3878a;
            this.plv = findViewById(2131820940);
            if (this.plv != null && C5544c.zzP) {
                C5544c az = C5544c.m8364az(this);
                C3505916 c3505916 = new C3505916();
                this.plx = c3505916;
                az.mo11253a(c3505916);
                getWindow().getDecorView().requestApplyInsets();
                C5546d.m8368a(getWindow());
            }
            getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
            C5240b.m8009c(this, false);
            mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.a3p));
            dyb();
            this.rzl = getIntent().getIntExtra("sns_adapter_type", 0);
            this.rys = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
            this.mActionBar = getSupportActionBar();
            int en = C18624c.abj().mo39176en("Sns_Private_Recent_Setting_Guide", 0);
            C4990ab.m7416i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = ".concat(String.valueOf(en)));
            if (en == 1) {
                C1720g.m3537RQ();
                if (!C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_SNS_INTRODUCE_SETTING_DISPLAY_BOOLEAN_SYNC, false)) {
                    Intent intent = getIntent();
                    intent.setClass(this.mController.ylL, SnsSettingIntroduceUI.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    finish();
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_INTRODUCE_SETTING_DISPLAY_BOOLEAN_SYNC, Boolean.TRUE);
                }
            }
            C7305d.xDG.execute(new C400322());
            this.ryl.mo28388a(C3879b.class, this.rzi);
            C13619b c13619b = this.rym;
            en = this.rzl;
            Intent intent2 = getIntent();
            C3874b c3874b = this.ryk;
            c13619b.rzl = en;
            c13619b.hasInit = true;
            if (en == 0) {
                C13618a c13618a = c13619b.rEQ;
                c13618a.ryk = c3874b;
                if (c3874b != null) {
                    cvE = c3874b.cvE();
                } else {
                    cvE = null;
                }
                c13618a.ryl = cvE;
                c13619b.rEQ.ryl.mo55524a(this);
            } else {
                c13619b.rER = new C3878a();
                c13619b.rER.igi = intent2.getStringExtra("sns_userName");
                c13619b.rER.ryC = C1853r.m3846Yz();
                C3878a c3878a2 = c13619b.rER;
                C1720g.m3537RQ();
                c3878a2.ryD = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoJ(c13619b.rER.igi);
                c13619b.rER.rjn = C1853r.m3846Yz().equals(c13619b.rER.igi);
                c13619b.rER.ryE = intent2.getIntExtra("sns_source", 0);
                c13619b.rER.gHT = C5046bo.m7532bc(intent2.getStringExtra("sns_nickName"), "");
                c13619b.rER.mSignature = C5046bo.m7532bc(intent2.getStringExtra("sns_signature"), "");
            }
            C13619b c13619b2 = this.rym;
            if (c13619b2.rzl == 0) {
                c3878a = (C3878a) c13619b2.rEQ.ryl.mo28391x(C3878a.class);
            } else {
                c3878a = c13619b2.rER;
            }
            this.igi = c3878a.igi;
            this.ryC = c3878a.ryC;
            this.ryD = c3878a.ryD;
            this.rjn = c3878a.rjn;
            this.ryE = c3878a.ryE;
            String str = c3878a.gHT;
            String str2 = c3878a.mSignature;
            this.hcl = C5510e.aqC("123");
            this.ryF = String.valueOf(System.currentTimeMillis());
            this.mUIAction = new SnsUIAction(this);
            this.mUIAction.setSessionId(this.hcl);
            this.mUIAction.qSf = this.ryF;
            this.mUIAction.rBP = this.rzh;
            this.mUIAction.rBQ = this.mActionBar.getCustomView();
            ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41581il(2);
            C35147e.cvB().rMP = 0;
            C35146c.cvy().rMP = 0;
            C32830c c32830c = C32830c.fQs;
            C32830c.ajL();
            this.ryt = new C29220i(this, getIntent().getBooleanExtra("is_sns_notify_open", true) ? 1 : 0, C5046bo.m7532bc(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0), this.ryF);
            this.rhv = getIntent().getBooleanExtra("sns_resume_state", true);
            if (C13373af.cnn()) {
                this.rhv = false;
            } else if (this.rhv) {
                this.rhv = C13373af.cnM().csu();
            }
            this.ryr = this.rhv;
            this.mUIAction.mo25755a(this.ryC, this.igi, str, str2, this.ryD, this.rjn, this.ryE);
            this.mUIAction.onCreate();
            C21884c cnw = C13373af.cnw();
            ArrayList arrayList = new ArrayList();
            for (C5141c c5141c : C18624c.abi().aof("10001").values()) {
                C21890d c21890d = new C21890d();
                if (c5141c == null) {
                    C4990ab.m7416i("MicroMsg.SnsABTestStrategy", "abtest is null");
                } else if (c5141c.isValid()) {
                    Map dru = c5141c.dru();
                    if (dru != null) {
                        Object obj;
                        C4990ab.m7416i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + c5141c.field_expId + " " + c5141c.field_layerId + " " + c5141c.field_startTime + " " + c5141c.field_endTime);
                        c21890d.mo37376h(c5141c.field_layerId, c5141c.field_expId, dru);
                        if (!c21890d.cwB || c21890d.qPP == null || c21890d.qPP.size() <= 0) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj != null) {
                            arrayList.add(c21890d);
                        }
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
                }
            }
            cnw.qPp = arrayList;
            cnw.qPs.clear();
            cnw.qPt.clear();
            cnw.qPv.clear();
            cnw.qJD = null;
            if (!(cnw.qPp == null || cnw.qPp.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder stringBuilder = new StringBuilder();
                C1720g.m3537RQ();
                String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().cachePath).append("ws_1100004").toString();
                C4990ab.m7416i("MicroMsg.SnSABTestMgr", "filepath to list  ".concat(String.valueOf(stringBuilder2)));
                byte[] e = C5730e.m8632e(stringBuilder2, 0, -1);
                if (e != null) {
                    try {
                        cnw.qJD = (C21896c) new C21896c().parseFrom(e);
                        C4990ab.m7416i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                        if (cnw.qJD == null) {
                            C4990ab.m7416i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
                        } else {
                            C4990ab.m7416i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + cnw.qJD.qQf.size());
                        }
                    } catch (IOException e2) {
                        C4990ab.printErrStackTrace("MicroMsg.SnSABTestMgr", e2, "", new Object[0]);
                        C5730e.deleteFile(stringBuilder2);
                    }
                }
            }
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(213, (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(682, (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(218, (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(211, (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(683, (C1202f) this);
            initView();
            C21884c cnw2 = C13373af.cnw();
            ListView listView = this.mUIAction.nDp;
            C46251au c46251au = this.ryn.rEA;
            cnw2.qPq = listView;
            cnw2.qPr = c46251au;
            C1202f cnw3 = C13373af.cnw();
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(291, cnw3);
            this.ryt.mmO = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
            if (C13373af.cnn()) {
                this.rhv = false;
            } else if (this.rhv) {
                this.rhv = C13373af.cnM().csu();
            }
            cvE = this.ryl;
            cvE.rEB = this.ryn.rEB;
            cvE.zWY.keep(cvE.rEB);
            if (this.rhv && this.rzl == 0) {
                this.rys = false;
                en = C13373af.cnM().position;
                this.ryn.rEB.mo37604ZL(C13373af.cnM().lQD);
                this.ryn.rEB.mo37603ZK(C13373af.cnM().rmL);
                this.ryn.rEB.cuQ();
                this.ryn.mo47329sg();
                if (en >= this.ryn.getCount()) {
                    en = this.ryn.getCount() - 1;
                    C4990ab.m7413e("MicroMsg.SnsTimeLineUI", "error position %s", Integer.valueOf(this.ryn.getCount()));
                }
                this.mUIAction.nDp.setAdapter(this.ryn);
                C4990ab.m7411d("MicroMsg.SnsTimeLineUI", "resume position %s", Integer.valueOf(C13373af.cnM().rmM));
                this.mUIAction.nDp.setSelectionFromTop(en, C13373af.cnM().rmM);
                m57611Eg(4);
            } else {
                this.mUIAction.nDp.setAdapter(this.ryn);
                m57611Eg(0);
                this.ryn.mo47329sg();
            }
            int count = this.ryn.getCount();
            en = this.mUIAction.nDp.getFirstVisiblePosition();
            if (en < count) {
                this.ryy = C29036i.m46115j(this.ryn.mo47320DP(en));
            }
            C1720g.m3537RQ();
            this.ryw = ((Integer) C1720g.m3536RP().mo5239Ry().get(327776, Integer.valueOf(0))).intValue();
            this.ryt.rhx = new C46256bd(this, this.ryn.rEA, this.ryt.qOM);
            this.ryt.rhz = new C31408b(this, this.ryn.rEA.qOL, this.ryt.qOM);
            this.ryt.rhy = new C4045b(this, this.ryn.rEA.qOL, this.ryt.qOM, this.ryt.rhz);
            if (this.ryB != null) {
                this.ryB.mo62858a(this.ryt.rhz);
            }
            if (count > 0) {
                C46236n DP = this.ryn.mo47320DP(0);
                if (!(this.ryt.rhn == null || this.ryt.rhn.qMn == null)) {
                    this.ryt.rhn.qMn.qQP = DP.field_snsId;
                }
                C43549e c43549e = C43549e.qTd;
                if (c43549e.eFs != 0) {
                    if (c43549e.qTe.isEmpty()) {
                        c43549e.ecO.setLong(2, C5046bo.anT());
                        c43549e.qTf.clear();
                    }
                    C4990ab.m7417i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", Integer.valueOf(c43549e.qTe.size()));
                }
            }
            C7060h.pYm.mo8374X(13312, "1," + C5046bo.anU());
            C4879a.xxA.mo10052c(this.ryJ);
            if (getIntent().getBooleanExtra("is_need_resend_sns", false)) {
                C5004al.m7442n(new C2914824(), 500);
                getIntent().putExtra("is_need_resend_sns", false);
            }
            C1720g.m3537RQ();
            if (C1720g.m3534RN().mo5161QY()) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(589825, Boolean.FALSE);
            }
            this.ryt.rhm = this.rqn;
            this.rqn.mo25430a(this.mUIAction.qDc, this.mActionBar.getCustomView(), this);
            C4879a.xxA.mo10052c(this.ryO);
            C4879a.xxA.mo10052c(this.ryP);
            C4879a.xxA.mo10052c(this.ryQ);
            C4879a.xxA.mo10052c(this.ryR);
            C4879a.xxA.mo10052c(this.ryS);
            C4879a.xxA.mo10052c(this.ryU);
            C4879a.xxA.mo10052c(this.ryT);
            C4879a.xxA.mo10052c(this.qMM);
            C4879a.xxA.mo10052c(this.ryV);
            C4879a.xxA.mo10052c(this.ryW);
            C4879a.xxA.mo10052c(this.ryY);
            C4879a.xxA.mo10052c(this.ryX);
            C4879a.xxA.mo10052c(this.ryZ);
            C34932c.cmb();
            C21865a.m33416c((Context) this, this.ryt.qOM);
            if (this.ryz != null) {
                C13363a c13363a = this.ryz;
                listView = this.mUIAction.nDp;
                SnsHeader snsHeader = this.mUIAction.qQt;
                c13363a.gKd = listView;
                c13363a.qQt = snsHeader;
            }
            if (!(this.ryt == null || this.ryt.rhn == null)) {
                C43548b c43548b = this.ryt.rhn.qMn;
                C4990ab.m7416i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
                c43548b.qQO = true;
                c43548b.qSM = System.currentTimeMillis();
            }
            boolean booleanExtra = getIntent().getBooleanExtra("enter_by_red", false);
            if (!(this.ryt == null || this.ryt.rhn == null)) {
                C43548b c43548b2 = this.ryt.rhn.qMn;
                if (booleanExtra) {
                    en = 1;
                } else {
                    en = 0;
                }
                c43548b2.qRb = en;
            }
            C13373af.cnC().qIc.clear();
            if (!(this.mUIAction == null || this.mUIAction.qQt == null)) {
                this.mUIAction.qQt.setStoryAction(new C2204025());
            }
            C4879a.xxA.mo10052c(this.ryK);
            AppMethodBeat.m2505o(39560);
            return;
        }
        finish();
        AppMethodBeat.m2505o(39560);
    }

    private void cue() {
        AppMethodBeat.m2504i(39561);
        if (this.rzl != 1) {
            addIconOptionMenu(0, C25738R.string.eio, C1318a.icons_filled_camera, new C3505227(), new C3504828());
            AppMethodBeat.m2505o(39561);
        } else if (this.rjn) {
            mo17393b(getString(C25738R.string.emv), (int) C1318a.actionbar_list_icon, (OnMenuItemClickListener) new C3507426());
            AppMethodBeat.m2505o(39561);
        } else {
            enableOptionMenu(false);
            AppMethodBeat.m2505o(39561);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(39562);
        super.onConfigurationChanged(configuration);
        C4990ab.m7416i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
        C4879a.xxA.mo10055m(new C37697bz());
        C35147e.cvB().rMP = 0;
        C35146c.cvy().rMP = 0;
        C37873c.eNj.mo60602SN();
        this.ryn.rEA.ctW();
        this.ryn.rEB.resolvedClear();
        AppMethodBeat.m2505o(39562);
    }

    public void onDestroy() {
        int i;
        long j;
        int i2;
        int i3;
        String str;
        AppMethodBeat.m2504i(39563);
        this.ryx = true;
        C4990ab.m7416i("MicroMsg.SnsTimeLineUI", "timeline on destroy");
        C4879a.xxA.mo10053d(this.ryO);
        C4879a.xxA.mo10053d(this.ryP);
        C4879a.xxA.mo10053d(this.ryQ);
        C4879a.xxA.mo10053d(this.ryR);
        C4879a.xxA.mo10053d(this.ryS);
        C4879a.xxA.mo10053d(this.ryU);
        C4879a.xxA.mo10053d(this.ryT);
        C4879a.xxA.mo10053d(this.qMM);
        C4879a.xxA.mo10053d(this.ryV);
        C4879a.xxA.mo10053d(this.ryW);
        C4879a.xxA.mo10053d(this.ryX);
        C4879a.xxA.mo10053d(this.ryY);
        C4879a.xxA.mo10053d(this.ryZ);
        C4879a.xxA.mo10053d(this.ryK);
        C29210a.cvo();
        if (!(this.ryt == null || this.ryt.rhn == null)) {
            C43548b c43548b = this.ryt.rhn.qMn;
            if (this.ryL) {
                i = 1;
            } else {
                i = 0;
            }
            c43548b.qRc = i;
        }
        C43549e c43549e = C43549e.qTd;
        if (c43549e.eFs != 0) {
            C4990ab.m7417i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d, exposureAppIdSize %d", Integer.valueOf(c43549e.qTe.size()), Integer.valueOf(c43549e.qTf.size()));
            j = c43549e.ecO.getLong(2, 0);
            if (c43549e.qTe.isEmpty() || (c43549e.qTe.size() <= c43549e.qTj && C5046bo.m7549fp(j) <= ((long) c43549e.qTk))) {
                c43549e.ecO.set(3, c43549e.qTe);
                c43549e.ecO.set(4, c43549e.qTf);
                c43549e.ecO.set(5, c43549e.qTg);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                i2 = 0;
                i3 = 0;
                for (String str2 : c43549e.qTe.keySet()) {
                    str = (String) c43549e.qTf.get(str2);
                    if (C5046bo.isNullOrNil(str)) {
                        str = "";
                    } else {
                        i3 = 1;
                    }
                    stringBuffer.append(str2 + "#" + c43549e.qTe.get(str2) + "#" + str + "#" + (c43549e.qTg.contains(str2) ? 1 : 0) + "|");
                    i2++;
                }
                stringBuffer.append("," + j + "," + C5046bo.anT() + ",1," + i3 + "," + i2 + ",1");
                C4990ab.m7419v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", Integer.valueOf(13226), stringBuffer);
                C7060h.pYm.mo8374X(13226, stringBuffer.toString());
                c43549e.ecO.set(3, null);
                c43549e.ecO.set(4, null);
                c43549e.qTe.clear();
                c43549e.qTf.clear();
                c43549e.qTg.clear();
                c43549e.ecO.setLong(2, C5046bo.anT());
            }
            c43549e.coG();
        }
        C1720g.m3537RQ();
        String str22 = (String) C1720g.m3536RP().mo5239Ry().get(68377, null);
        i3 = this.ryn.getCount();
        str = "";
        C46236n c46236n = null;
        if (i3 > 0) {
            c46236n = this.ryn.mo47320DP(i3 - 1);
            str = C29036i.m46115j(c46236n);
        }
        if (!(this.ryt == null || this.ryt.rhn == null)) {
            C43548b c43548b2 = this.ryt.rhn.qMn;
            if (c46236n == null) {
                i2 = -1;
            } else {
                i2 = c46236n.field_createTime;
            }
            C4990ab.m7416i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
            long currentTimeMillis = System.currentTimeMillis() - c43548b2.qSM;
            c43548b2.qQQ += currentTimeMillis;
            C4990ab.m7416i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + currentTimeMillis + " BrowseTime: " + c43548b2.qQQ + "BackgroundTime: " + c43548b2.qRz);
            C4946a cns = C13373af.cns();
            if (cns != null) {
                cns.execute(new C38712(i2));
            }
            c43548b2.qQO = false;
        }
        C37952b lY = C37952b.m64170lY(704);
        if (lY.ajG()) {
            lY.mo60718cS(this.ryL);
            lY.mo60718cS(!C5046bo.isNullOrNil(str22));
            lY.mo60722tx(this.ryy);
            lY.mo60722tx(str);
            lY.mo60722tx(str);
            lY.mo60720mb(this.mUIAction.rBO);
            lY.mo60722tx("");
            C37952b.ajJ();
            lY.ajK();
        }
        AdListView adListView = (AdListView) this.mUIAction.getSnsListView();
        this.ryB.qNf.clear();
        C13373af.cnw().clean();
        C13373af.cns().execute(new C133495());
        adListView.rfN.clear();
        adListView.rfN = null;
        adListView.rfO.cmU();
        adListView.rfO = null;
        C7101u.cmZ();
        if (!C13373af.cnn()) {
            this.rzf.removeCallbacks(this.ryI);
        }
        C1720g.m3537RQ();
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(213, (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(682, (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(218, (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(211, (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(683, (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(327776, Integer.valueOf(this.ryw));
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(589825, Boolean.FALSE);
        }
        if (this.ryt != null) {
            C29220i c29220i = this.ryt;
            c29220i.rhA.removeListener();
            if (c29220i.rhq != null) {
                c29220i.rhq.bMO();
            }
            C4879a.xxA.mo10053d(c29220i.rhC);
            C4879a.xxA.mo10053d(c29220i.rhD);
        }
        C13373af.bCo().removeCallbacks(this.rzg);
        if (this.ryn != null) {
            i2 = this.mUIAction.nDp.getFirstVisiblePosition();
            int i4 = 0;
            for (i = 0; i < this.mUIAction.nDp.getCount(); i++) {
                View childAt = this.mUIAction.nDp.getChildAt(i);
                if (childAt != null && this.mUIAction.nDp.getPositionForView(childAt) == i2) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    C4990ab.m7411d("MicroMsg.SnsTimeLineUI", "this is the pos for view %d x %d y %d", Integer.valueOf(r4), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                    i4 = iArr[1];
                }
            }
            i = getResources().getDimensionPixelSize(C25738R.dimen.a9h);
            if (!(C13373af.cnn() || this.ryl.cnv() == null || this.rzl != 0)) {
                C43588ai cnM = C13373af.cnM();
                String cuO = this.ryn.rEB.cuO();
                String cuP = this.ryn.rEB.cuP();
                j = this.ryl.cnv().qMB;
                int i5 = i4 - i;
                cnM.rmK = C5046bo.m7588yz();
                cnM.lQD = cuO;
                cnM.rmL = cuP;
                cnM.qMB = j;
                cnM.position = i2;
                cnM.rmM = i5;
                C4990ab.m7417i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", Long.valueOf(cnM.rmK), cuO, cuP, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(cnM.rmM));
            }
            C4990ab.m7411d("MicroMsg.SnsTimeLineUI", "top h %d", Integer.valueOf(i4 - i));
            C4879a.xxA.mo10053d(this.ryn.rEA.hAA);
            if (C13373af.cnn()) {
                C4990ab.m7412e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
            } else {
                C13373af.cnC();
            }
            C46251au c46251au = this.ryn.rEA;
            if (c46251au.rqd != null) {
                c46251au.rqd.activity = null;
            }
            C4879a.xxA.mo10053d(this.ryn.rEA.hAA);
            this.ryn.rEA.ctZ();
        }
        C29198aw.clean();
        C4879a.xxA.mo10053d(this.ryJ);
        C1720g.m3537RQ();
        if (C1720g.m3534RN().mo5161QY()) {
            C13373af.cnC().qIc.clear();
        }
        C29169a c29169a = this.ryn;
        c29169a.rEB.removeVendingDataChangedCallback(c29169a.rED);
        c29169a.rED = null;
        this.ryn = null;
        this.ryt = null;
        C29169a.cuM();
        C34932c.cmc();
        C1202f cnw = C13373af.cnw();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(291, cnw);
        C21865a.clean();
        this.mUIAction.onDestroy();
        super.onDestroy();
        C37873c.eNj.mo60602SN();
        C13619b c13619b = this.rym;
        c13619b.rER = null;
        c13619b.hasInit = false;
        C43558b cnA = C13373af.cnA();
        if (!cnA.qHN.isEmpty()) {
            cnA.qHN.clear();
        }
        cnA = C13373af.cnA();
        if (!cnA.qHO.isEmpty()) {
            cnA.qHO.clear();
        }
        AppMethodBeat.m2505o(39563);
    }

    public void onResume() {
        int count;
        AppMethodBeat.m2504i(39564);
        this.fAq = C5046bo.anT();
        if (C1060a.isInstalled() && C1060a.m2339yK().mo4192F(C7466a.class) != null) {
            C7469c c7469c = ((C7466a) C1060a.m2339yK().mo4192F(C7466a.class)).bYx;
            if (c7469c != null) {
                c7469c.mo16643a(this.mnM);
            }
        }
        if (C4872b.dnO() && C4872b.dnM()) {
            sUILeaksRoutineEnsuranceRef.add(this);
        }
        this.mUIAction.onResume();
        super.onResume();
        this.oes = C5046bo.anT();
        if (this.rzj) {
            this.rzj = false;
            count = this.ryn.getCount();
            if (getIntent().getBooleanExtra("is_from_find_more", false)) {
                C37952b c = C37952b.m64169c(getIntent(), "enter_log");
                if (c != null) {
                    if (count > 0) {
                        C46236n DP = this.ryn.mo47320DP(0);
                        c.mo60722tx(DP == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : C29036i.m46117jV(DP.field_snsId));
                        c.mo60722tx(DP == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : DP.field_createTime);
                        c.mo60722tx(String.valueOf(count));
                    } else {
                        c.mo60722tx("");
                        c.mo60722tx("");
                        c.mo60722tx(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    }
                    c.ajK();
                }
            }
        }
        if (this.mScreenWidth == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mScreenHeight = displayMetrics.heightPixels;
            C13363a c13363a = this.ryz;
            count = this.mScreenWidth;
            int i = this.mScreenHeight;
            c13363a.mScreenWidth = count;
            c13363a.mScreenHeight = i;
        }
        if (C13373af.cnn()) {
            finish();
        }
        C13373af.cnC().qIe = this.ryn.rEA;
        mo20830SK().mo28389aG(C3879b.class);
        C7101u.m11894a((C42185ar) this);
        if (this.rys) {
            this.ryq.post(new C2915130());
        } else {
            C35069a c35069a = this.ryu;
            if (SnsTimeLineUI.this.ryq.getVisibility() == 0) {
                c35069a.init();
                LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.this.ryq.getLayoutParams();
                layoutParams.y = (int) c35069a.rzP;
                SnsTimeLineUI.this.ryq.setLayoutParams(layoutParams);
                SnsTimeLineUI.this.ryq.invalidate();
            }
        }
        C6550tn c6550tn = new C6550tn();
        c6550tn.cPI.cPJ = this.mUIAction.nDp.getFirstVisiblePosition();
        c6550tn.cPI.cPK = this.mUIAction.nDp.getLastVisiblePosition();
        c6550tn.cPI.cPL = this.mUIAction.nDp.getHeaderViewsCount();
        c6550tn.cPI.type = 0;
        C4879a.xxA.mo10055m(c6550tn);
        if (!(this.ryt == null || this.ryt.rhm == null)) {
            this.ryt.rhm.onResume();
        }
        if (this.ryn != null) {
            C46251au c46251au = this.ryn.rEA;
            C4879a.xxA.mo10052c(c46251au.rqz);
            C4879a.xxA.mo10052c(c46251au.rqy);
            C4879a.xxA.mo10052c(c46251au.rqA);
        }
        if (!(this.ryt == null || this.ryt.rhn == null)) {
            this.ryt.rhn.qMn.mo69105kK(true);
            this.ryt.rhn.qMn.mo69106kL(false);
            this.ryt.rhn.qMn.mo69107kM(false);
            this.ryt.rhn.qMn.mo69108kN(false);
            this.ryt.rhn.qMn.mo69118kX(false);
            C43548b c43548b = this.ryt.rhn.qMn;
            c43548b.mo69116kV(false);
            c43548b.mo69117kW(false);
            c43548b.mo69110kP(false);
            c43548b.mo69115kU(false);
            c43548b.mo69113kS(false);
            c43548b.mo69115kU(false);
            c43548b.mo69119kY(false);
            c43548b.mo69114kT(false);
            c43548b.mo69115kU(false);
            c43548b.mo69111kQ(false);
            c43548b.mo69112kR(false);
        }
        C21925g cnC = C13373af.cnC();
        cnC.qIf = 0;
        cnC.qIg = 0;
        C4879a.xxA.mo10052c(this.ryN);
        C4879a.xxA.mo10052c(this.ryM);
        AppMethodBeat.m2505o(39564);
    }

    public void onStart() {
        AppMethodBeat.m2504i(39565);
        super.onStart();
        AppMethodBeat.m2505o(39565);
    }

    public void onStop() {
        AppMethodBeat.m2504i(39566);
        super.onStop();
        AppMethodBeat.m2505o(39566);
    }

    public void onPause() {
        AppMethodBeat.m2504i(39567);
        this.ryq.clearAnimation();
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, this.ehv);
        this.ehv = 0;
        C7101u.m11897b((C42185ar) this);
        C13373af.cnC().qIe = null;
        C6550tn c6550tn = new C6550tn();
        c6550tn.cPI.type = 1;
        C4879a.xxA.mo10055m(c6550tn);
        if (this.ryn != null) {
            C46251au c46251au = this.ryn.rEA;
            C4879a.xxA.mo10053d(c46251au.rqz);
            C4879a.xxA.mo10053d(c46251au.rqy);
            C4879a.xxA.mo10053d(c46251au.rqA);
        }
        if (!(this.ryt == null || this.ryt.rhm == null)) {
            this.ryt.rhm.onPause();
        }
        if (!(this.ryt == null || this.ryt.rhn == null)) {
            this.ryt.rhn.qMn.mo69105kK(false);
        }
        C26483d.m42198h("SnsTimeLineUI", this.oes, C5046bo.anT());
        this.mUIAction.onPause();
        super.onPause();
        C4879a.xxA.mo10053d(this.ryN);
        C4879a.xxA.mo10053d(this.ryM);
        if (C1060a.isInstalled() && C1060a.m2339yK().mo4192F(C7466a.class) != null) {
            C7469c c7469c = ((C7466a) C1060a.m2339yK().mo4192F(C7466a.class)).bYx;
            if (c7469c != null) {
                c7469c.mo16644b(this.mnM);
            }
        }
        this.fAq = C5046bo.anT() > this.fAq ? C5046bo.anT() - this.fAq : 1;
        WXHardCoderJNI.reportFPS(701, WXHardCoderJNI.hcSNSScrollAction, 1, this.eEO, this.fAq);
        this.eEO = 0;
        this.fAq = 0;
        AppMethodBeat.m2505o(39567);
    }

    public final int getLayoutId() {
        return 2130970823;
    }

    public final void initView() {
        AppMethodBeat.m2504i(39568);
        this.mUIAction.qQt.setDrawingCacheEnabled(false);
        this.ryt.qOM = (FrameLayout) findViewById(2131822759);
        int i = C13373af.cnM().position;
        AdListView adListView = (AdListView) this.mUIAction.getSnsListView();
        adListView.rfN = this.rqn;
        adListView.setTimelineStat(this.ryA);
        adListView.setTimelineEvent(this.ryB);
        this.ryB.mo62858a(C13373af.cnw());
        C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.rhv, Integer.valueOf(i));
        this.ryq = (QFadeImageView) findViewById(2131827926);
        this.ryq.setImageResource(C1318a.friendactivity_refresh);
        this.ryu = new C35069a(this.mUIAction.getSnsListView());
        this.ryu.setInterpolator(new LinearInterpolator());
        this.ryu.setAnimationListener(new C3505331());
        C43587b c43587b = null;
        if (this.rzl == 1) {
            this.rys = true;
            c43587b = new C39821d(this.igi, this.rjn);
        }
        this.ryn = new C29169a(this, this.mUIAction.getSnsListView(), this.ryt.rhA, this.ryt, this.ryC, c43587b);
        this.ryt.rhA.rKo = new C3505432();
        this.ryt.qPr = this.ryn.rEA;
        this.ryn.rEB.zXa = new C3505033();
        this.ryv = (TestTimeForSns) this.ryt.qOM;
        this.ryv.setListener(new C3507535());
        this.mUIAction.nDp.setOnTouchListener(new C2204136());
        this.mUIAction.nDp.post(new C2915237());
        this.mUIAction.ooW.setOnSrcollDistance(new C400538());
        this.ryt.rhq = (SnsCommentFooter) findViewById(2131822763);
        this.ryt.rhq.post(new C400639());
        this.ryt.rhr = new C39839be(this.mUIAction.nDp, this.ryt.rhq);
        this.ryo = (LinearLayout) this.mUIAction.qQt.findViewById(2131827775);
        this.ryo.findViewById(2131827778).setOnClickListener(new C3506040());
        this.ryp = (LinearLayout) this.mUIAction.qQt.findViewById(2131827777);
        this.ryt.rhs = new C22062an(this);
        cue();
        cuf();
        if (this.rzl == 0) {
            setMMTitle((int) C25738R.string.eq0);
            AppMethodBeat.m2505o(39568);
            return;
        }
        if (this.rjn) {
            setMMTitle((int) C25738R.string.enj);
        } else {
            CharSequence Oj;
            C4990ab.m7411d("MicroMsg.SnsTimeLineUI", "SnsUserUI, userName:%s, title:%s", this.igi, this.mUIAction.title);
            C7616ad aoO = C13373af.cnt().aoO(this.igi);
            if (aoO != null) {
                C4990ab.m7410d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is not null");
                Oj = aoO.mo16707Oj();
            } else {
                C4990ab.m7411d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is null, title:%s", this.mUIAction.title);
                Oj = this.mUIAction.title;
            }
            setMMTitle(C29036i.m46075K(Oj));
        }
        m57611Eg(8);
        AppMethodBeat.m2505o(39568);
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.m2504i(39569);
        super.onKeyboardStateChanged();
        C5004al.m7441d(new C2204241());
        if (this.mController.ymc == 2) {
            if (!(this.ryt == null || this.ryt.rhq == null || this.ryt.rhq.cte())) {
                C4990ab.m7416i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
                AppMethodBeat.m2505o(39569);
                return;
            }
        } else if (this.mController.ymc == 1 && this.ryt != null) {
            C29220i c29220i = this.ryt;
            if (c29220i.rho) {
                c29220i.rho = false;
                c29220i.rhr.cuK();
            }
        }
        AppMethodBeat.m2505o(39569);
    }

    public boolean supportNavigationSwipeBack() {
        AppMethodBeat.m2504i(39570);
        boolean supportNavigationSwipeBack = super.supportNavigationSwipeBack();
        AppMethodBeat.m2505o(39570);
        return supportNavigationSwipeBack;
    }

    private void cuf() {
        AppMethodBeat.m2504i(39571);
        mo17392b(new C2204444(), new C3507646());
        setBackBtn(this.rzm, C1318a.actionbar_icon_dark_back);
        AppMethodBeat.m2505o(39571);
    }

    private void cug() {
        AppMethodBeat.m2504i(39572);
        if (C35973a.m59177bH(this)) {
            AppMethodBeat.m2505o(39572);
            return;
        }
        C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.CAMERA", 18, "", "")), C5046bo.dpG(), this);
        if (C35805b.m58707a(this, "android.permission.CAMERA", 18, "", "")) {
            C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 18, "", "")), C5046bo.dpG(), this);
            if (C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 18, "", "")) {
                C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", C5046bo.anU() + "_" + C5046bo.m7507Mb(5));
                C7060h.pYm.mo8381e(13822, Integer.valueOf(1), Integer.valueOf(2), r0, Long.valueOf(C5046bo.anT()));
                C14987n.m23312c(this.mController.ylL, new Intent(), r0);
                AppMethodBeat.m2505o(39572);
                return;
            }
            AppMethodBeat.m2505o(39572);
            return;
        }
        AppMethodBeat.m2505o(39572);
    }

    /* renamed from: dM */
    public final boolean mo55688dM(View view) {
        AppMethodBeat.m2504i(39573);
        this.ryt.rhy.cox();
        C46256bd c46256bd = this.ryt.rhx;
        if (view.getTag() instanceof BaseViewHolder) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            String str = baseViewHolder.cwT;
            if (c46256bd.rDJ != null) {
                if (c46256bd.rDJ.getTag() instanceof C22078a) {
                    C22078a c22078a = (C22078a) c46256bd.rDJ.getTag();
                    if (c22078a.qPg.equals(str)) {
                        c46256bd.mo74361dP(c22078a.qCZ);
                        AppMethodBeat.m2505o(39573);
                        return true;
                    }
                    c46256bd.crO();
                }
                c46256bd.rDJ = null;
            }
            c46256bd.rDJ = new SnsCommentShowAbLayout(c46256bd.mContext);
            C46616n.m88170ci(c46256bd.rDJ);
            c46256bd.rDJ.setId(2131820733);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            c46256bd.qOM.addView(c46256bd.rDJ);
            int b = C4977b.m7371b(c46256bd.mContext, 192.0f);
            int b2 = C4977b.m7371b(c46256bd.mContext, 76.0f);
            C4977b.m7371b(c46256bd.mContext, 20.0f);
            int b3 = C4977b.m7371b(c46256bd.mContext, 12.0f);
            int b4 = C4977b.m7371b(c46256bd.mContext, 40.0f);
            View inflate = C5616v.m8409hu(c46256bd.mContext).inflate(2130970750, null);
            Rect rect = new Rect();
            int[] iArr = new int[2];
            C30036f.m47543fD(c46256bd.mContext);
            int fromDPToPix = C1338a.fromDPToPix(c46256bd.mContext, 6);
            view.getLocationInWindow(iArr);
            c46256bd.qDY = C5222ae.m7947hA(c46256bd.mContext);
            C4990ab.m7410d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + iArr[0] + "  " + iArr[1] + " height: " + fromDPToPix + " height_hardcode:" + b2 + " statusBarHeight: " + c46256bd.qDY);
            LayoutParams layoutParams2 = new LayoutParams(-2, -2, (iArr[0] - b) + b3, (iArr[1] - fromDPToPix) - ((b4 / 2) - (view.getMeasuredHeight() / 2)));
            c46256bd.rDJ.setTag(new C22078a(str, inflate));
            c46256bd.rDJ.addView(inflate, layoutParams2);
            if (baseViewHolder.klY == 10) {
                inflate.findViewById(2131821027).setBackgroundResource(C25738R.drawable.bme);
            }
            inflate.setVisibility(8);
            new C7306ak().post(new C220771(view, inflate));
            AppMethodBeat.m2505o(39573);
            return true;
        }
        C4990ab.m7412e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
        AppMethodBeat.m2505o(39573);
        return false;
    }

    public final boolean crO() {
        AppMethodBeat.m2504i(39574);
        if (this.ryt == null || this.ryt.rhx == null) {
            AppMethodBeat.m2505o(39574);
            return false;
        }
        if (!(this.ryt == null || this.ryt.rhy == null)) {
            this.ryt.rhy.cox();
        }
        C21865a.clW();
        boolean crO = this.ryt.rhx.crO();
        AppMethodBeat.m2505o(39574);
        return crO;
    }

    /* renamed from: Zx */
    public final void mo55684Zx() {
        AppMethodBeat.m2504i(39575);
        mo20830SK().mo28389aG(C3879b.class);
        AppMethodBeat.m2505o(39575);
    }

    /* renamed from: Zy */
    public final void mo55685Zy() {
    }

    /* renamed from: Zz */
    public final void mo55686Zz() {
        AppMethodBeat.m2504i(39576);
        if (this.rzr) {
            AppMethodBeat.m2505o(39576);
            return;
        }
        C4990ab.m7418v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
        this.rzr = true;
        C13373af.bCo().postDelayed(new C2204554(), 1000);
        AppMethodBeat.m2505o(39576);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(39577);
        C4990ab.m7416i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + c1207m.getType());
        if (c1207m.getType() == 218) {
            C46224r c46224r = (C46224r) c1207m;
            if ((c46224r.type == 1 || c46224r.type == 6 || c46224r.type == 4) && this.ryt.rhB != null) {
                this.ryt.rhB.dismiss();
            }
            if (c46224r.type == 11) {
                if (this.mUIAction.tipDialog != null) {
                    this.mUIAction.tipDialog.dismiss();
                }
                if (this.rzn != null) {
                    this.rzn.setImageResource(C1318a.icons_outlined_camera);
                }
            }
        }
        if (this.ryn != null) {
            this.ryn.rEB.notifyVendingDataChange();
        }
        if (c1207m.getType() == 211) {
            C46225y c46225y = (C46225y) c1207m;
            C37952b lY;
            if (c46225y.qIW) {
                lY = C37952b.m64170lY(727);
                lY.mo60720mb(this.ryn.getCount()).mo60720mb(c46225y.afg);
                lY.ajK();
            } else {
                lY = C37952b.m64170lY(728);
                lY.mo60720mb(this.ryn.getCount()).mo60720mb(c46225y.afg).mo60720mb(0);
                lY.ajK();
            }
            if (this.ryu != null) {
                this.rys = false;
                this.ryu.cus();
            }
        }
        AppMethodBeat.m2505o(39577);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(39578);
        C4990ab.m7410d("MicroMsg.SnsTimeLineUI", "finalize");
        super.finalize();
        AppMethodBeat.m2505o(39578);
    }

    /* renamed from: ZA */
    public final void mo55683ZA() {
        AppMethodBeat.m2504i(39579);
        mo20830SK().mo28389aG(C3879b.class);
        AppMethodBeat.m2505o(39579);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(39580);
        finish();
        AppMethodBeat.m2505o(39580);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(39581);
        C4990ab.m7419v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 15) {
            if (!(this.ryt == null || this.ryt.rhA == null || this.ryt.rhA.rJH == null)) {
                this.ryt.rhA.rJH.onActivityResult(i, i2, intent);
                C5004al.m7442n(new C2204757(), 300);
            }
            AppMethodBeat.m2505o(39581);
        } else if (i == 16) {
            C4990ab.m7416i("MicroMsg.SnsTimeLineUI", "REQUEST_CODE_FOR_FULLSCREEN");
            AppMethodBeat.m2505o(39581);
        } else {
            if (i == 2333 && intent != null) {
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    String[] split = stringExtra.split(",");
                    if (split.length > 0) {
                        this.ryt.rhq.crP.showVKB();
                        stringExtra = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(split[0]);
                        if (!C5046bo.isNullOrNil(stringExtra)) {
                            this.ryt.rhq.ctg();
                            this.ryt.rhq.setText("@" + stringExtra + " ");
                            this.ryt.rhq.setCommentAtPrefix("@" + stringExtra + " ");
                            this.ryt.rhq.setCommentInfo(new cat());
                            this.ryt.rhq.getCommentInfo().vHl = split[0];
                            this.ryt.rhq.setCommentFlag(8);
                        }
                    }
                }
            }
            super.onActivityResult(i, i2, intent);
            this.mUIAction.onActivityResult(i, i2, intent);
            if (i == 11) {
                this.rym.mo25823d(this.igi, this.ryD, this.rjn, this.ryE);
                AppMethodBeat.m2505o(39581);
                return;
            }
            AppMethodBeat.m2505o(39581);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(39582);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(39582);
            return;
        }
        C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 18:
                if (iArr[0] != 0) {
                    int i2 = "android.permission.CAMERA".equals(strArr[0]) ? C25738R.string.dbs : C25738R.string.dc0;
                    if (iArr[0] != 0) {
                        C30379h.m48445a((Context) this, getString(i2), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C3506358(), new C3506459());
                        break;
                    }
                }
                cug();
                AppMethodBeat.m2505o(39582);
                return;
                break;
        }
        AppMethodBeat.m2505o(39582);
    }

    public void onDrag() {
        AppMethodBeat.m2504i(39583);
        super.onDrag();
        AppMethodBeat.m2505o(39583);
    }

    /* renamed from: lm */
    public final void mo55690lm(boolean z) {
        AppMethodBeat.m2504i(39584);
        if (this.ryn != null) {
            C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "set play animation %s", Boolean.valueOf(z));
            C29169a c29169a = this.ryn;
            c29169a.rEC = z;
            if (!z) {
                c29169a.notifyDataSetChanged();
            }
        }
        AppMethodBeat.m2505o(39584);
    }

    /* renamed from: a */
    private static void m57627a(C35071c c35071c) {
        AppMethodBeat.m2504i(39585);
        if (c35071c.active) {
            C4990ab.m7411d("MicroMsg.SnsTimeLineUI", "report weishi: %s", c35071c.toString());
            C7060h.pYm.mo8374X(15827, c35071c.toString());
        }
        AppMethodBeat.m2505o(39585);
    }

    /* renamed from: a */
    static /* synthetic */ void m57629a(SnsTimeLineUI snsTimeLineUI, int i, int i2, C9362gs c9362gs) {
        AppMethodBeat.m2504i(39588);
        int firstVisiblePosition = snsTimeLineUI.ryt.nDp.getFirstVisiblePosition();
        int headerViewsCount = snsTimeLineUI.ryt.nDp.getHeaderViewsCount();
        C46236n DP = snsTimeLineUI.ryt.qPr.mo74340DP(i2);
        if (DP != null) {
            TimeLineObject cqu = DP.cqu();
            if (cqu.xfI.wbJ == 1 && cqu.xfI.wbK.size() == 4 && i > 1) {
                i++;
            }
        } else {
            C4990ab.m7412e("MicroMsg.SnsTimeLineUI", "snsInfo is null");
        }
        View childAt = snsTimeLineUI.ryt.nDp.getChildAt((i2 - firstVisiblePosition) + headerViewsCount);
        if (!(childAt == null || childAt.getTag() == null || !(childAt.getTag() instanceof BaseViewHolder))) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) childAt.getTag();
            childAt = baseViewHolder.rHT != null ? baseViewHolder.rHT.mo8755DT(i) : baseViewHolder.rIn != null ? baseViewHolder.rHF : null;
            if (childAt != null) {
                int[] iArr = new int[2];
                childAt.getLocationInWindow(iArr);
                c9362gs.cBs.ctT = iArr[0];
                c9362gs.cBs.ctU = iArr[1];
                c9362gs.cBs.ctV = childAt.getWidth();
                c9362gs.cBs.ctW = childAt.getHeight();
            }
        }
        AppMethodBeat.m2505o(39588);
    }

    /* renamed from: E */
    static /* synthetic */ void m57610E(SnsTimeLineUI snsTimeLineUI) {
        C44274m c44274m;
        AppMethodBeat.m2504i(39594);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, null);
        if (!C5046bo.isNullOrNil(str)) {
            C1720g.m3537RQ();
            String str2 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_LAST_SESSIONID_STRING, (Object) "");
            new C32661ah().mo53150Fs().mo53151fk(str2).ajK();
            byte[] atV = C8769e.atV(str);
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(atV, 0, atV.length);
            obtain.setDataPosition(0);
            try {
                Intent intent = (Intent) Intent.CREATOR.createFromParcel(obtain);
                intent.addFlags(268435456);
                intent.setClass(snsTimeLineUI, SnsUploadUI.class);
                intent.putExtra("KSessionID", str2);
                snsTimeLineUI.startActivity(intent);
                AppMethodBeat.m2505o(39594);
                return;
            } catch (Exception e) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, (Object) "");
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_LAST_SESSIONID_STRING, (Object) "");
            }
        }
        if (snsTimeLineUI.rzo != null) {
            snsTimeLineUI.rzo.setVisibility(8);
        }
        if (!(snsTimeLineUI.ryt == null || snsTimeLineUI.ryt.rhn == null)) {
            snsTimeLineUI.ryt.rhn.qMn.mo69109kO(true);
        }
        final C37952b lY = C37952b.m64170lY(705);
        lY.mo60721mc(lY.fQh).mo60723ty(System.currentTimeMillis()).mo60721mc(lY.fQi).mo60721mc(1);
        final ArrayList arrayList = new ArrayList();
        if (!C1947ae.gjt) {
            c44274m = new C44274m(snsTimeLineUI, 3, 0);
            c44274m.setTitle(snsTimeLineUI.getString(C25738R.string.f9121q4));
            arrayList.add(c44274m);
        }
        c44274m = new C44274m(snsTimeLineUI, 1, 0);
        c44274m.setTitle(snsTimeLineUI.getString(C25738R.string.f9126qa));
        arrayList.add(c44274m);
        if (C3889am.coc()) {
            snsTimeLineUI.ryH.active = true;
            c44274m = new C44274m(snsTimeLineUI, 4, 0);
            c44274m.setTitle(snsTimeLineUI.getString(C25738R.string.f9138qo));
            arrayList.add(c44274m);
        } else {
            snsTimeLineUI.ryH.active = false;
        }
        snsTimeLineUI.rzp = new C29199ax(snsTimeLineUI);
        snsTimeLineUI.rzp.rBl = new C36073c() {
            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(39521);
                for (C44274m i : arrayList) {
                    c44273l.mo70073i(i);
                }
                AppMethodBeat.m2505o(39521);
            }
        };
        snsTimeLineUI.rzp.mo47368c(3, snsTimeLineUI.mController.ylL.getString(C25738R.string.f9124q9));
        snsTimeLineUI.rzp.mo47368c(4, snsTimeLineUI.mController.ylL.getString(C25738R.string.f9139qp));
        snsTimeLineUI.rzp.rBm = new C5279d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(39522);
                switch (menuItem.getItemId()) {
                    case 1:
                        C7060h.pYm.mo8381e(13822, Integer.valueOf(2), Integer.valueOf(2));
                        C24827g.qTp.mo37378b(lY);
                        lY.ajK();
                        SnsTimeLineUI.this.mUIAction.rCd = lY;
                        SnsTimeLineUI.this.mUIAction.mo25754Em(1);
                        SnsTimeLineUI.this.ryH.mo55708Ei(2);
                        SnsTimeLineUI.m57634b(SnsTimeLineUI.this.ryH);
                        AppMethodBeat.m2505o(39522);
                        return;
                    case 3:
                        SnsTimeLineUI.this.ryH.mo55708Ei(1);
                        SnsTimeLineUI.m57634b(SnsTimeLineUI.this.ryH);
                        SnsTimeLineUI.m57619M(SnsTimeLineUI.this);
                        AppMethodBeat.m2505o(39522);
                        return;
                    case 4:
                        SnsTimeLineUI.this.ryH.mo55708Ei(3);
                        SnsTimeLineUI.m57634b(SnsTimeLineUI.this.ryH);
                        SnsTimeLineUI.m57620N(SnsTimeLineUI.this);
                        break;
                }
                AppMethodBeat.m2505o(39522);
            }
        };
        C29199ax c29199ax = snsTimeLineUI.rzp;
        c29199ax.rBk.setOnCancelListener(new C1355749());
        snsTimeLineUI.rzp.cuu();
        C35071c c35071c = snsTimeLineUI.ryH;
        if (c35071c.active) {
            c35071c.reset();
            c35071c.rAf = C5046bo.anU() + "_" + C5046bo.m7507Mb(5);
            c35071c.scene = 1;
            c35071c.rAg = C5046bo.anU();
            C1720g.m3537RQ();
            c35071c.rAh = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEISHI_EXPOSE_COUNT_INT_SYNC, Integer.valueOf(0))).intValue();
        }
        AppMethodBeat.m2505o(39594);
    }

    /* renamed from: J */
    static /* synthetic */ void m57616J(SnsTimeLineUI snsTimeLineUI) {
        int i = 1;
        AppMethodBeat.m2504i(39595);
        if (snsTimeLineUI.ryw <= 3) {
            int firstVisiblePosition = snsTimeLineUI.mUIAction.nDp.getFirstVisiblePosition();
            if (System.currentTimeMillis() - snsTimeLineUI.rzb > 1000 || firstVisiblePosition > snsTimeLineUI.oOX) {
                snsTimeLineUI.rzb = 0;
                snsTimeLineUI.oOX = snsTimeLineUI.mUIAction.nDp.getFirstVisiblePosition();
            }
            snsTimeLineUI.rzb = System.currentTimeMillis();
            if (snsTimeLineUI.oOX - firstVisiblePosition >= 10 && firstVisiblePosition > 10) {
                C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "showTopTip %d", Integer.valueOf(snsTimeLineUI.ryw));
                if (snsTimeLineUI.ryw <= 3) {
                    C5536q c5536q = snsTimeLineUI.mController;
                    if (c5536q.mActionBar == null || c5536q.mActionBar.getCustomView() == null || c5536q.mActionBar.getCustomView().findViewById(2131820985) == null) {
                        i = 0;
                    }
                    if (i == 0) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(snsTimeLineUI.mController.ylL, C25738R.anim.f8372cd);
                        String string = snsTimeLineUI.getString(C25738R.string.ejy);
                        C5536q c5536q2 = snsTimeLineUI.mController;
                        if (c5536q2.mActionBar != null) {
                            c5536q2.mActionBar.setCustomView(C5536q.ylZ);
                            TextView textView = (TextView) c5536q2.mActionBar.getCustomView().findViewById(2131820985);
                            if (textView != null) {
                                textView.clearAnimation();
                                if (loadAnimation != null) {
                                    textView.startAnimation(loadAnimation);
                                }
                                if (!C5046bo.isNullOrNil(string)) {
                                    textView.setText(string);
                                }
                            }
                        }
                        snsTimeLineUI.mController.removeAllOptionMenu();
                        snsTimeLineUI.removeOptionMenu(16908332);
                        snsTimeLineUI.setTitleBarDoubleClickListener(new C2204342());
                        snsTimeLineUI.ryw++;
                        C13373af.bCo().removeCallbacks(snsTimeLineUI.rzg);
                        C13373af.bCo().postDelayed(snsTimeLineUI.rzg, 4000);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(39595);
    }

    /* renamed from: K */
    static /* synthetic */ void m57617K(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.m2504i(39596);
        C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "double click， first visible：%s", Integer.valueOf(snsTimeLineUI.mUIAction.nDp.getFirstVisiblePosition()));
        C4978c.m7375a(snsTimeLineUI.mUIAction.nDp);
        snsTimeLineUI.m57611Eg(0);
        if (snsTimeLineUI.mUIAction.nDp.getFirstVisiblePosition() != 0) {
            snsTimeLineUI.rzg.run();
        }
        snsTimeLineUI.ryt.crD();
        snsTimeLineUI.crO();
        new C7306ak().postDelayed(new C3505853(), 300);
        AppMethodBeat.m2505o(39596);
    }

    /* renamed from: N */
    static /* synthetic */ void m57620N(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.m2504i(39599);
        final C35070b c35070b = new C35070b(snsTimeLineUI, (byte) 0);
        if (C3889am.m6180eO(snsTimeLineUI)) {
            c35070b.rAe = C25738R.string.f9137qn;
            c35070b.type = 2;
            snsTimeLineUI.ryH.mo55709Ej(1);
        } else {
            c35070b.rAe = C25738R.string.f9136qm;
            c35070b.type = 0;
            snsTimeLineUI.ryH.mo55709Ej(2);
        }
        SnsTimeLineUI.m57627a(snsTimeLineUI.ryH);
        C30379h.m48428a((Context) snsTimeLineUI, c35070b.rAe, (int) C25738R.string.f9238tz, (int) C25738R.string.f9187s6, (int) C25738R.string.f9076or, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(39524);
                SnsTimeLineUI.this.ryH.mo55710Ek(1);
                SnsTimeLineUI.m57634b(SnsTimeLineUI.this.ryH);
                switch (c35070b.type) {
                    case 0:
                        SnsTimeLineUI.m57622P(SnsTimeLineUI.this);
                        break;
                    case 2:
                        SnsTimeLineUI.m57621O(SnsTimeLineUI.this);
                        AppMethodBeat.m2505o(39524);
                        return;
                }
                AppMethodBeat.m2505o(39524);
            }
        }, new C3505751());
        AppMethodBeat.m2505o(39599);
    }

    /* renamed from: O */
    static /* synthetic */ void m57621O(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.m2504i(39600);
        if (!C35973a.m59177bH(snsTimeLineUI)) {
            C4990ab.m7417i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", C5046bo.anU() + "_" + C5046bo.m7507Mb(5));
            C7060h.pYm.mo8381e(13822, Integer.valueOf(1), Integer.valueOf(2), r0, Long.valueOf(C5046bo.anT()));
            C14987n.m23318f(snsTimeLineUI.mController.ylL, new Intent(), r0);
        }
        AppMethodBeat.m2505o(39600);
    }

    /* renamed from: P */
    static /* synthetic */ void m57622P(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.m2504i(39601);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://mobile.qzone.qq.com/l?g=4991");
        C25985d.m41467b((Context) snsTimeLineUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(39601);
    }
}
