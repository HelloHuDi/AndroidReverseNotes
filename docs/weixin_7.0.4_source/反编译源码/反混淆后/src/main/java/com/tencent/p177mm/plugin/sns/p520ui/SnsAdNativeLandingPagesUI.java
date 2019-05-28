package com.tencent.p177mm.plugin.sns.p520ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p057v4.app.C31856k;
import android.support.p057v4.app.Fragment;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.content.C37116d;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.view.ViewPager.C0437f;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.support.p069v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.p230g.p231a.C18381qv;
import com.tencent.p177mm.p230g.p231a.C45344ma;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.C5240b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24109b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.C34131v;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.p177mm.plugin.sns.model.AdLandingPagesProxy.C34948e;
import com.tencent.p177mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.C35111a;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.C39836b;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.C46254c;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsAdLandingPageFloatView;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsAdLandingPageFloatView.C137142;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsAdLandingPageFloatView.C351414;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsAdLandingPageFloatView.C351426;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsAdLandingPageFloatView.C351445;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsAdLandingPageFloatView.C40981;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsAdLandingPageFloatView.C40993;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C13469p;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C21939ac;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29060a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C34986x;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39779l;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39780n;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C46232m;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C46233o;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C46234v;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C13437h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C29064ad;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C29068i;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C29068i.C29070a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C39774x;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.C29082b;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.C7521a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3952g;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C39785k;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C21984b.C21987g;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.cdg;
import com.tencent.p177mm.protocal.protobuf.cdh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

@C5271a(32)
/* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI */
public class SnsAdNativeLandingPagesUI extends MMActivity {
    private boolean aGz = false;
    String cFc;
    public int cvd;
    private long edh = 0;
    public String hcx;
    private String hya;
    private long iBA = 0;
    private int ieu;
    private int iev;
    private int kkq = 0;
    private int kkr = 0;
    private int kks = 0;
    private int kkt = 0;
    String lvA;
    String lvz;
    protected C24109b mUw = new C135037();
    private ImageView mmX;
    public String qPj;
    public String qTL;
    private String qTM;
    private int qUA;
    private int qUe;
    String qVw;
    public int qXp;
    public int qXr;
    public Map<String, String> qXs = new HashMap();
    private C21939ac rdd;
    public LinkedList<C3952g> rnM = new LinkedList();
    private ImageView rnN;
    private ImageView rnO;
    private ImageView rnP;
    private TextView rnQ;
    Bundle rnR;
    private boolean rnS = false;
    private String rnT;
    private String rnU;
    private String rnV;
    private String rnW;
    private String rnX;
    private ImageView rnY;
    String rnZ;
    private Map<String, SnsAdLandingPageFloatView> roA = new HashMap();
    private BroadcastReceiver roB = new C135011();
    private BroadcastReceiver roC = new C1351112();
    private C7521a roD = new C1351613();
    private OnPageChangeListener roE = new C1351214();
    private C34948e roF = new C1351915();
    private C4884c<C45344ma> roG = new C1349916();
    private C4884c<C18381qv> roH = new C1350017();
    private Map<Integer, ContentFragment> roI = new HashMap();
    private BroadcastReceiver roJ = new C135089();
    private C29068i roK = null;
    private C44275p roL = null;
    String roa;
    public boolean rob = false;
    C39785k roc = new C39785k();
    boolean rod = false;
    private int roe = 0;
    private boolean rof = false;
    private String rog;
    private String roh;
    private String roi;
    private String roj;
    private AdlandingDummyViewPager rok;
    private int rol;
    private int rom;
    private C7306ak ron = new C7306ak();
    private FrameLayout roo;
    private View rop;
    private View roq;
    private boolean ror = true;
    private C46236n ros;
    private List<C13437h> rot;
    private C39836b rou;
    private C46254c rov;
    private volatile boolean rox;
    private boolean roy;
    public C46234v roz;
    private long startTime;
    public String uin;
    private Map<String, String> values;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$18 */
    class C397118 implements Runnable {
        C397118() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38654);
            SnsAdNativeLandingPagesUI.m21709w(SnsAdNativeLandingPagesUI.this);
            AppMethodBeat.m2505o(38654);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$16 */
    class C1349916 extends C4884c<C45344ma> {
        C1349916() {
            AppMethodBeat.m2504i(38650);
            this.xxI = C45344ma.class.getName().hashCode();
            AppMethodBeat.m2505o(38650);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38651);
            C45344ma c45344ma = (C45344ma) c4883b;
            if (!(SnsAdNativeLandingPagesUI.m21694i(SnsAdNativeLandingPagesUI.this).rcX.rek == null || !SnsAdNativeLandingPagesUI.m21694i(SnsAdNativeLandingPagesUI.this).rcX.rek.containsKey(c45344ma.cHQ.cHR) || SnsAdNativeLandingPagesUI.this.roA.containsKey(c45344ma.cHQ.cHR))) {
                SnsAdNativeLandingPagesUI.m21694i(SnsAdNativeLandingPagesUI.this).onPause();
                Bundle bundle = new Bundle();
                bundle.putString("sns_landing_pages_xml", SnsAdNativeLandingPagesUI.this.rnT);
                bundle.putString("sns_float_component_id", c45344ma.cHQ.cHR);
                bundle.putInt("sns_landing_page_index", SnsAdNativeLandingPagesUI.m21694i(SnsAdNativeLandingPagesUI.this).rcX.f1283id);
                bundle.putString("sns_landing_page_snsId", SnsAdNativeLandingPagesUI.this.cFc);
                bundle.putString("sns_landing_pages_rawSnsId", SnsAdNativeLandingPagesUI.this.roa);
                bundle.putString("sns_landing_pages_ux_info", SnsAdNativeLandingPagesUI.this.qPj);
                bundle.putString("sns_landing_pages_aid", SnsAdNativeLandingPagesUI.this.qTL);
                bundle.putInt("sns_landing_pages_biz_id", SnsAdNativeLandingPagesUI.this.qXr);
                bundle.putString("sns_landing_pages_traceid", SnsAdNativeLandingPagesUI.this.hcx);
                bundle.putInt("sns_landig_pages_from_source", SnsAdNativeLandingPagesUI.this.cvd);
                bundle.putString("sns_landing_pages_xml_prefix", SnsAdNativeLandingPagesUI.this.rnU);
                bundle.putBoolean("sns_landing_is_native_sight_ad", SnsAdNativeLandingPagesUI.this.rob);
                bundle.putString("sns_landing_pages_canvas_ext", SnsAdNativeLandingPagesUI.this.qTM);
                SnsAdLandingPageFloatView snsAdLandingPageFloatView = new SnsAdLandingPageFloatView(SnsAdNativeLandingPagesUI.this);
                snsAdLandingPageFloatView.rnT = bundle.getString("sns_landing_pages_xml");
                snsAdLandingPageFloatView.cHR = bundle.getString("sns_float_component_id");
                snsAdLandingPageFloatView.rMA = bundle.getInt("sns_landing_page_index", -1);
                snsAdLandingPageFloatView.qPj = bundle.getString("sns_landing_pages_ux_info");
                snsAdLandingPageFloatView.rMC = bundle.getString("sns_landing_pages_aid");
                snsAdLandingPageFloatView.hcx = bundle.getString("sns_landing_pages_traceid");
                snsAdLandingPageFloatView.qTM = bundle.getString("sns_landing_pages_canvas_ext");
                if (C5046bo.m7510Q(snsAdLandingPageFloatView.rnT, snsAdLandingPageFloatView.cHR) || snsAdLandingPageFloatView.rMA == -1) {
                    C4990ab.m7412e("MicroMsg.SnsAdLandingPageFloatView", "invalid landing float page data!");
                } else {
                    snsAdLandingPageFloatView.rMB = C5046bo.m7532bc(bundle.getString("sns_landing_pages_xml_prefix"), "adxml");
                    snsAdLandingPageFloatView.rnM = C3953i.m6304gn(snsAdLandingPageFloatView.rnT, snsAdLandingPageFloatView.rMB);
                    if (snsAdLandingPageFloatView.rnM != null && snsAdLandingPageFloatView.rnM.size() > snsAdLandingPageFloatView.rMA) {
                        C3952g c3952g = (C3952g) snsAdLandingPageFloatView.rnM.get(snsAdLandingPageFloatView.rMA);
                        snsAdLandingPageFloatView.rME = new C3952g();
                        snsAdLandingPageFloatView.rME.hfo = c3952g.hfo;
                        C29086r c29086r = (C29086r) c3952g.rek.get(snsAdLandingPageFloatView.cHR);
                        if (C3953i.m6284DD(c29086r.type)) {
                            snsAdLandingPageFloatView.rMD = (C13469p) c29086r;
                            snsAdLandingPageFloatView.rME.rej.add(snsAdLandingPageFloatView.rMD);
                            snsAdLandingPageFloatView.rME.rek.putAll(c3952g.rek);
                        }
                        snsAdLandingPageFloatView.rME.f1283id = 0;
                        snsAdLandingPageFloatView.rME.rel = true;
                    }
                    C4990ab.m7417i("MicroMsg.SnsAdLandingPageFloatView", "[reportInfo] aid %s,traceId %s,uxInfo %s,adCanvasExtXml %s", snsAdLandingPageFloatView.rMC, snsAdLandingPageFloatView.hcx, snsAdLandingPageFloatView.qPj, snsAdLandingPageFloatView.qTM);
                    if (snsAdLandingPageFloatView.rME != null) {
                        if (snsAdLandingPageFloatView.rMD != null) {
                            snsAdLandingPageFloatView.rMF = C43590al.m77980a(snsAdLandingPageFloatView.getContext(), snsAdLandingPageFloatView.rMD, snsAdLandingPageFloatView, Color.parseColor(snsAdLandingPageFloatView.rME.hfo));
                            snsAdLandingPageFloatView.rMF.setBackgroundColor(Color.parseColor(snsAdLandingPageFloatView.rME.hfo));
                            snsAdLandingPageFloatView.rMG = snsAdLandingPageFloatView.rMF.getView();
                            snsAdLandingPageFloatView.addView(snsAdLandingPageFloatView.rMG);
                            snsAdLandingPageFloatView.rMF.cpz();
                            snsAdLandingPageFloatView.setOnTouchListener(new C351426());
                        }
                        snsAdLandingPageFloatView.cvw();
                        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.4f, 0.96f}).setDuration(200);
                        duration.setInterpolator(new OvershootInterpolator());
                        ValueAnimator duration2 = ValueAnimator.ofFloat(new float[]{0.96f, 1.0f}).setDuration(100);
                        duration.addUpdateListener(new C40981());
                        duration2.addUpdateListener(new C137142());
                        snsAdLandingPageFloatView.rMH.playSequentially(new Animator[]{duration, duration2});
                        snsAdLandingPageFloatView.rMH.addListener(new C40993());
                        snsAdLandingPageFloatView.nVR.addUpdateListener(new C351414());
                        snsAdLandingPageFloatView.nVR.addListener(new C351445());
                    }
                }
                snsAdLandingPageFloatView.setBackgroundColor(SnsAdNativeLandingPagesUI.this.getResources().getColor(C25738R.color.a07));
                SnsAdNativeLandingPagesUI.this.roo.addView(snsAdLandingPageFloatView, SnsAdNativeLandingPagesUI.this.roo.getChildCount() - 1, new LayoutParams(-1, -1));
                if (!snsAdLandingPageFloatView.rEC) {
                    snsAdLandingPageFloatView.rMH.start();
                    snsAdLandingPageFloatView.rEC = true;
                }
                SnsAdNativeLandingPagesUI.m21694i(SnsAdNativeLandingPagesUI.this).cqe();
                SnsAdNativeLandingPagesUI.this.roA.put(c45344ma.cHQ.cHR, snsAdLandingPageFloatView);
            }
            AppMethodBeat.m2505o(38651);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$17 */
    class C1350017 extends C4884c<C18381qv> {
        C1350017() {
            AppMethodBeat.m2504i(38652);
            this.xxI = C18381qv.class.getName().hashCode();
            AppMethodBeat.m2505o(38652);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38653);
            C18381qv c18381qv = (C18381qv) c4883b;
            String str = c18381qv.cNa.cNb;
            switch (c18381qv.cNa.state) {
                case 123:
                    if (!C5046bo.isNullOrNil(str) && SnsAdNativeLandingPagesUI.this.roA.containsKey(str)) {
                        SnsAdNativeLandingPagesUI.this.roo.removeView((View) SnsAdNativeLandingPagesUI.this.roA.get(str));
                        SnsAdNativeLandingPagesUI.this.onResume();
                        SnsAdNativeLandingPagesUI.m21694i(SnsAdNativeLandingPagesUI.this).onResume();
                        break;
                    }
            }
            AppMethodBeat.m2505o(38653);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$1 */
    class C135011 extends BroadcastReceiver {
        C135011() {
        }

        public final void onReceive(Context context, Intent intent) {
            boolean z = true;
            AppMethodBeat.m2504i(38621);
            ContentFragment contentFragment = (ContentFragment) ((C31856k) SnsAdNativeLandingPagesUI.this.rok.getAdapter()).getItem(SnsAdNativeLandingPagesUI.this.rok.getCurrentItem());
            C4990ab.m7411d("MicroMsg.SnsAdNativeLandingPagesUI", "recv videoProgressbarStatusChangeReceiver show %d", Integer.valueOf(intent.getIntExtra("show", 0)));
            if (intent.getIntExtra("show", 0) != 1) {
                z = false;
            }
            contentFragment.rdi = z;
            if (!contentFragment.cqf() || z) {
                contentFragment.cqe();
                AppMethodBeat.m2505o(38621);
                return;
            }
            contentFragment.cqd();
            AppMethodBeat.m2505o(38621);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$7 */
    class C135037 implements C24109b {
        C135037() {
        }

        public final void aIu() {
            AppMethodBeat.m2504i(38633);
            try {
                AdLandingPagesProxy.getInstance().favEditTag();
                AppMethodBeat.m2505o(38633);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + e.getMessage());
                AppMethodBeat.m2505o(38633);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$8 */
    class C135048 implements Runnable {
        C135048() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38634);
            if (SnsAdNativeLandingPagesUI.this.mController.ymc != 1) {
                C29064ad.m46205ac(SnsAdNativeLandingPagesUI.this);
            }
            if (!SnsAdNativeLandingPagesUI.this.roy) {
                ArrayList arrayList = new ArrayList();
                for (Fragment fragment : ((C29082b) SnsAdNativeLandingPagesUI.this.rok.getAdapter()).rdA) {
                    ((ContentFragment) fragment).cqb();
                }
            }
            AppMethodBeat.m2505o(38634);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$19 */
    class C1350519 implements OnClickListener {
        C1350519() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38655);
            SnsAdNativeLandingPagesUI.this.mo25676w(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.this.rnW, SnsAdNativeLandingPagesUI.this.rnX);
            AppMethodBeat.m2505o(38655);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$6 */
    class C135076 implements C35111a {
        C135076() {
        }

        public final void onAnimationStart() {
            AppMethodBeat.m2504i(38630);
            C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "sns exit anim start");
            SnsAdNativeLandingPagesUI.this.roq.setVisibility(4);
            AppMethodBeat.m2505o(38630);
        }

        /* renamed from: aZ */
        public final void mo25680aZ(float f) {
            AppMethodBeat.m2504i(38631);
            SnsAdNativeLandingPagesUI.this.mmX.setAlpha(1.0f - f);
            AppMethodBeat.m2505o(38631);
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(38632);
            SnsAdNativeLandingPagesUI.this.rox = false;
            C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "sns exit anim end");
            SnsAdNativeLandingPagesUI.this.finish();
            SnsAdNativeLandingPagesUI.this.overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
            if (SnsAdNativeLandingPagesUI.this.isSupportNavigationSwipeBack()) {
                SnsAdNativeLandingPagesUI.this.getSwipeBackLayout().setEnableGesture(true);
            }
            AppMethodBeat.m2505o(38632);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$9 */
    class C135089 extends BroadcastReceiver {
        C135089() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(38635);
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                C4990ab.m7410d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_OFF");
                AppMethodBeat.m2505o(38635);
                return;
            }
            if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                C4990ab.m7410d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_ON");
                C29064ad.m46205ac(SnsAdNativeLandingPagesUI.this);
            }
            AppMethodBeat.m2505o(38635);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$2 */
    class C135092 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$2$1 */
        class C135021 implements C36073c {
            C135021() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(38622);
                if (SnsAdNativeLandingPagesUI.this.rol == 0 || (SnsAdNativeLandingPagesUI.this.rol & 2) == 0) {
                    c44273l.mo70049a(1, SnsAdNativeLandingPagesUI.this.getString(C25738R.string.dr8), (int) C1318a.bottomsheet_icon_transmit);
                }
                if (SnsAdNativeLandingPagesUI.this.rol == 0 || (SnsAdNativeLandingPagesUI.this.rol & 1) == 0) {
                    c44273l.mo70049a(2, SnsAdNativeLandingPagesUI.this.getString(C25738R.string.ejg), (int) C1318a.bottomsheet_icon_moment);
                }
                if ((SnsAdNativeLandingPagesUI.this.rol == 0 || (SnsAdNativeLandingPagesUI.this.rol & 4) == 0) && SnsAdNativeLandingPagesUI.this.cvd != 7) {
                    c44273l.mo70049a(3, SnsAdNativeLandingPagesUI.this.getString(C25738R.string.akj), (int) C1318a.bottomsheet_icon_fav);
                }
                if ((SnsAdNativeLandingPagesUI.this.rol == 0 || SnsAdNativeLandingPagesUI.m21668A(SnsAdNativeLandingPagesUI.this)) && SnsAdNativeLandingPagesUI.this.qXr == 2 && SnsAdNativeLandingPagesUI.m21669B(SnsAdNativeLandingPagesUI.this)) {
                    c44273l.mo70049a(4, SnsAdNativeLandingPagesUI.this.rnV != null ? SnsAdNativeLandingPagesUI.this.rnV : "", 0);
                }
                AppMethodBeat.m2505o(38622);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$2$2 */
        class C135102 implements C5279d {
            C135102() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(38623);
                C29064ad.m46205ac(SnsAdNativeLandingPagesUI.this);
                if (menuItem != null) {
                    switch (menuItem.getItemId()) {
                        case 1:
                            SnsAdNativeLandingPagesUI.m21671D(SnsAdNativeLandingPagesUI.this);
                            AppMethodBeat.m2505o(38623);
                            return;
                        case 2:
                            SnsAdNativeLandingPagesUI.m21672E(SnsAdNativeLandingPagesUI.this);
                            AppMethodBeat.m2505o(38623);
                            return;
                        case 3:
                            SnsAdNativeLandingPagesUI.m21673F(SnsAdNativeLandingPagesUI.this);
                            AppMethodBeat.m2505o(38623);
                            return;
                        case 4:
                            SnsAdNativeLandingPagesUI.this.mo25676w(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.this.rnW, SnsAdNativeLandingPagesUI.this.rnX);
                            break;
                    }
                }
                AppMethodBeat.m2505o(38623);
            }
        }

        C135092() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38624);
            C36356d c36356d = new C36356d(SnsAdNativeLandingPagesUI.this, 1, false);
            c36356d.rBl = new C135021();
            c36356d.uEP = true;
            c36356d.rBm = new C135102();
            SnsAdNativeLandingPagesUI.this.aqX();
            c36356d.cpD();
            AppMethodBeat.m2505o(38624);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$12 */
    class C1351112 extends BroadcastReceiver {
        C1351112() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(38640);
            C29064ad.m46205ac(SnsAdNativeLandingPagesUI.this);
            AppMethodBeat.m2505o(38640);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$14 */
    class C1351214 extends C0437f {
        C1351214() {
        }

        public final void onPageScrolled(int i, float f, int i2) {
            AppMethodBeat.m2504i(38644);
            super.onPageScrolled(i, f, i2);
            if (SnsAdNativeLandingPagesUI.m21694i(SnsAdNativeLandingPagesUI.this) != null) {
                ContentFragment i3 = SnsAdNativeLandingPagesUI.m21694i(SnsAdNativeLandingPagesUI.this);
                if (i3.caA && i3.rdb != null) {
                    i3.rdb.cpX();
                }
            }
            if (SnsAdNativeLandingPagesUI.this.mController.ymc == 1) {
                SnsAdNativeLandingPagesUI.this.aqX();
            }
            AppMethodBeat.m2505o(38644);
        }

        public final void onPageScrollStateChanged(int i) {
            AppMethodBeat.m2504i(38645);
            super.onPageScrollStateChanged(i);
            SnsAdNativeLandingPagesUI.m21694i(SnsAdNativeLandingPagesUI.this).rdl = i;
            Fragment fragment;
            if (i == 1) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < SnsAdNativeLandingPagesUI.this.rnM.size()) {
                        fragment = (Fragment) SnsAdNativeLandingPagesUI.this.roI.get(Integer.valueOf(((C3952g) SnsAdNativeLandingPagesUI.this.rnM.get(i3)).f1283id));
                        if (fragment != null) {
                            ((ContentFragment) fragment).cqe();
                        }
                        i2 = i3 + 1;
                    } else {
                        C29064ad.m46207eQ(SnsAdNativeLandingPagesUI.this.mController.ylL);
                        AppMethodBeat.m2505o(38645);
                        return;
                    }
                }
            }
            if (i == 0) {
                fragment = (Fragment) SnsAdNativeLandingPagesUI.this.roI.get(Integer.valueOf(((C3952g) SnsAdNativeLandingPagesUI.this.rnM.get(SnsAdNativeLandingPagesUI.this.rok.getCurrentItem())).f1283id));
                if (fragment != null) {
                    ((ContentFragment) fragment).cqd();
                }
            }
            AppMethodBeat.m2505o(38645);
        }

        public final void onPageSelected(int i) {
            AppMethodBeat.m2504i(38646);
            super.onPageSelected(i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < SnsAdNativeLandingPagesUI.this.rnM.size()) {
                    Fragment fragment = (Fragment) SnsAdNativeLandingPagesUI.this.roI.get(Integer.valueOf(((C3952g) SnsAdNativeLandingPagesUI.this.rnM.get(i3)).f1283id));
                    if (fragment != null) {
                        if (i3 == i) {
                            ((ContentFragment) fragment).cqd();
                        } else {
                            ((ContentFragment) fragment).cqe();
                        }
                    }
                    i2 = i3 + 1;
                } else {
                    AppMethodBeat.m2505o(38646);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$3 */
    class C135133 implements OnClickListener {
        C135133() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38625);
            if (SnsAdNativeLandingPagesUI.this.mController.ymc == 1) {
                SnsAdNativeLandingPagesUI.this.aqX();
            }
            SnsAdNativeLandingPagesUI.this.bcW();
            AppMethodBeat.m2505o(38625);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$5 */
    class C135145 implements Runnable {
        C135145() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38629);
            SnsAdNativeLandingPagesUI.m21678J(SnsAdNativeLandingPagesUI.this);
            AppMethodBeat.m2505o(38629);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$a */
    class C13515a {
        public String lvA;
        public String qVw;
        public String qVx;

        private C13515a() {
            this.lvA = "";
            this.qVw = "";
            this.qVx = "";
        }

        /* synthetic */ C13515a(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$13 */
    class C1351613 implements C7521a {
        C1351613() {
        }

        /* renamed from: n */
        public final void mo16744n(ContentFragment contentFragment) {
            RecyclerView recyclerView;
            AppMethodBeat.m2504i(38643);
            if (contentFragment.rdo != null) {
                recyclerView = contentFragment.rdo.iJP;
            } else {
                recyclerView = null;
            }
            if (recyclerView != null) {
                recyclerView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {

                    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$13$1$1 */
                    class C135181 implements Runnable {
                        C135181() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(38641);
                            Bitmap eA = C5056d.m7661eA(SnsAdNativeLandingPagesUI.this.roq);
                            if (eA != null) {
                                SnsAdNativeLandingPagesUI.this.roq.setVisibility(4);
                                SnsAdNativeLandingPagesUI.this.roo.setAlpha(1.0f);
                                SnsAdNativeLandingPagesUI.this.rnP.setImageBitmap(eA);
                                SnsAdNativeLandingPagesUI.m21692g(SnsAdNativeLandingPagesUI.this);
                                AppMethodBeat.m2505o(38641);
                                return;
                            }
                            SnsAdNativeLandingPagesUI.this.roo.setAlpha(1.0f);
                            AppMethodBeat.m2505o(38641);
                        }
                    }

                    public final boolean onPreDraw() {
                        AppMethodBeat.m2504i(38642);
                        C4990ab.m7417i("MicroMsg.SnsAdNativeLandingPagesUI", "onPreDraw %d, %d", Integer.valueOf(SnsAdNativeLandingPagesUI.this.roo.getHeight()), Integer.valueOf(SnsAdNativeLandingPagesUI.this.iev));
                        if (SnsAdNativeLandingPagesUI.this.rnS) {
                            C5004al.m7442n(new C135181(), 50);
                        } else {
                            SnsAdNativeLandingPagesUI.this.rop.setVisibility(0);
                        }
                        recyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
                        AppMethodBeat.m2505o(38642);
                        return false;
                    }
                });
            }
            AppMethodBeat.m2505o(38643);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$15 */
    class C1351915 implements C34948e {
        C1351915() {
        }

        /* renamed from: ao */
        public final void mo25548ao(final Object obj) {
            AppMethodBeat.m2504i(38649);
            SnsAdNativeLandingPagesUI.this.ron.removeCallbacksAndMessages(null);
            SnsAdNativeLandingPagesUI.this.ron.post(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$15$1$1 */
                class C135211 implements Runnable {
                    C135211() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(38647);
                        SnsAdNativeLandingPagesUI.m21701p(SnsAdNativeLandingPagesUI.this);
                        AppMethodBeat.m2505o(38647);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(38648);
                    SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = SnsAdNativeLandingPagesUI.this;
                    String l = SnsAdNativeLandingPagesUI.this.rnT;
                    String m = SnsAdNativeLandingPagesUI.this.rnU;
                    String str = (String) obj;
                    SnsAdNativeLandingPagesUI.this.qTL;
                    SnsAdNativeLandingPagesUI.this.hcx;
                    snsAdNativeLandingPagesUI.rnM = C3953i.m6295ai(l, m, str);
                    C5004al.m7441d(new C135211());
                    AppMethodBeat.m2505o(38648);
                }
            });
            AppMethodBeat.m2505o(38649);
        }

        /* renamed from: f */
        public final void mo25549f(int i, int i2, Object obj) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI$4 */
    class C135224 implements C35111a {
        C135224() {
        }

        public final void onAnimationStart() {
            AppMethodBeat.m2504i(38626);
            C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "sns enter anim start");
            AppMethodBeat.m2505o(38626);
        }

        /* renamed from: aZ */
        public final void mo25680aZ(float f) {
            AppMethodBeat.m2504i(38627);
            SnsAdNativeLandingPagesUI.this.mmX.setAlpha(1.0f - f);
            AppMethodBeat.m2505o(38627);
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(38628);
            SnsAdNativeLandingPagesUI.this.rox = false;
            C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "sns enter anim end");
            SnsAdNativeLandingPagesUI.this.roq.setVisibility(0);
            SnsAdNativeLandingPagesUI.this.rop.setVisibility(0);
            SnsAdNativeLandingPagesUI.m21701p(SnsAdNativeLandingPagesUI.this);
            SnsAdNativeLandingPagesUI.m21676I(SnsAdNativeLandingPagesUI.this);
            if (SnsAdNativeLandingPagesUI.this.isSupportNavigationSwipeBack()) {
                SnsAdNativeLandingPagesUI.this.getSwipeBackLayout().setEnableGesture(true);
            }
            AppMethodBeat.m2505o(38628);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsAdNativeLandingPagesUI() {
        AppMethodBeat.m2504i(38656);
        AppMethodBeat.m2505o(38656);
    }

    /* renamed from: A */
    static /* synthetic */ boolean m21668A(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.m2504i(38693);
        boolean csH = snsAdNativeLandingPagesUI.csH();
        AppMethodBeat.m2505o(38693);
        return csH;
    }

    /* renamed from: B */
    static /* synthetic */ boolean m21669B(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.m2504i(38694);
        boolean csG = snsAdNativeLandingPagesUI.csG();
        AppMethodBeat.m2505o(38694);
        return csG;
    }

    /* renamed from: i */
    static /* synthetic */ ContentFragment m21694i(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.m2504i(38690);
        ContentFragment csI = snsAdNativeLandingPagesUI.csI();
        AppMethodBeat.m2505o(38690);
        return csI;
    }

    /* renamed from: p */
    static /* synthetic */ void m21701p(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.m2504i(38691);
        snsAdNativeLandingPagesUI.csC();
        AppMethodBeat.m2505o(38691);
    }

    /* renamed from: w */
    static /* synthetic */ void m21709w(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.m2504i(38692);
        snsAdNativeLandingPagesUI.csw();
        AppMethodBeat.m2505o(38692);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(38657);
        super.onCreate(bundle);
        this.startTime = System.currentTimeMillis();
        this.edh = System.currentTimeMillis();
        this.roc.edh = this.edh;
        C29064ad.m46205ac(this);
        int[] eP = C29064ad.m46206eP(this);
        this.ieu = eP[0];
        this.iev = eP[1];
        this.rnR = bundle;
        this.mController.hideTitleView();
        this.kkq = getIntent().getIntExtra("img_gallery_top", 0);
        this.kkr = getIntent().getIntExtra("img_gallery_left", 0);
        this.kks = getIntent().getIntExtra("img_gallery_width", 0);
        this.kkt = getIntent().getIntExtra("img_gallery_height", 0);
        getWindow().addFlags(128);
        this.cvd = getIntent().getIntExtra("sns_landig_pages_from_source", 0);
        this.qXp = getIntent().getIntExtra("sns_landig_pages_origin_from_source", 0);
        this.rnT = getIntent().getStringExtra("sns_landing_pages_xml");
        String stringExtra = getIntent().getStringExtra("sns_landing_pages_too_large_xml_path");
        if (C5046bo.isNullOrNil(this.rnT) && !C5046bo.isNullOrNil(stringExtra)) {
            this.rnT = C29064ad.m46203YM(stringExtra);
        }
        if (C5046bo.isNullOrNil(this.rnT)) {
            finish();
        } else {
            this.rnT = this.rnT.replaceAll("</*RecXml[\\s|\\S]*?>", "");
            this.roc.qPm = getIntent().getStringExtra("sns_landing_pages_expid");
            this.rnU = getIntent().getStringExtra("sns_landing_pages_xml_prefix");
            this.cFc = getIntent().getStringExtra("sns_landing_pages_share_sns_id");
            this.roa = getIntent().getStringExtra("sns_landing_pages_rawSnsId");
            this.qPj = getIntent().getStringExtra("sns_landing_pages_ux_info");
            this.qTL = getIntent().getStringExtra("sns_landing_pages_aid");
            this.hcx = getIntent().getStringExtra("sns_landing_pages_traceid");
            stringExtra = getIntent().getStringExtra("sns_landing_pages_search_extra");
            C39785k c39785k = this.roc;
            if (!TextUtils.isEmpty(stringExtra)) {
                if (c39785k.extra.length() > 0) {
                    c39785k.extra += "&";
                }
                c39785k.extra += "searchextra=" + URLEncoder.encode(stringExtra);
            }
            stringExtra = getIntent().getStringExtra("sns_landing_pages_extra");
            c39785k = this.roc;
            if (!TextUtils.isEmpty(stringExtra)) {
                c39785k.extra += "&extra1=" + URLEncoder.encode(stringExtra);
            }
            this.rob = getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
            this.qUA = getIntent().getIntExtra("sns_landing_pages_rec_src", 0);
            this.roe = getIntent().getIntExtra("sns_landing_pages_from_outer_index", 0);
            this.hya = getIntent().getStringExtra("sns_landing_pages_ad_info");
            this.rnS = getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
            if (this.rnS) {
                this.roc.reB = 0;
                this.roc.ecH = 0;
            } else {
                this.roc.reB = 1;
                this.roc.ecH = 1;
            }
            this.roc.lgf = this.cvd;
            this.roc.reC = 0;
            this.roc.reD = 0;
            this.roc.reE = 1;
            this.roc.reF = 0;
            this.roc.qXp = this.qXp;
            if (this.rnU == null || "".equals(this.rnT)) {
                this.rnU = "adxml";
            }
            if (C5046bo.isNullOrNil(this.rnT) || C5046bo.isNullOrNil(this.rnU)) {
                C4990ab.m7412e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.rnT + ",landingPagesXmlPrex is " + this.rnU);
            } else {
                this.values = C5049br.m7595z(this.rnT, this.rnU);
                this.roc.hxZ = C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.canvasId"), "");
            }
        }
        initView();
        if (AdLandingPagesProxy.getInstance().isConnected()) {
            csw();
        } else {
            AdLandingPagesProxy.getInstance().connect(new C397118());
        }
        C4879a.xxA.mo10052c(this.roH);
        AppMethodBeat.m2505o(38657);
    }

    private void csw() {
        AppMethodBeat.m2504i(38658);
        AdlandingRemoteServiceConnectedReceiver.m46133b(C37116d.m62125S(this));
        m21680Kh();
        if (this.rnS) {
            csB();
        } else {
            csC();
        }
        refreshView();
        csy();
        mo25675lg(true);
        this.aGz = true;
        AppMethodBeat.m2505o(38658);
    }

    private void refreshView() {
        AppMethodBeat.m2504i(38659);
        if (this.qXr == 2 && !csF()) {
            LayoutParams layoutParams = (LayoutParams) this.rok.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, C5230ak.m7988fr(this));
            this.rok.setLayoutParams(layoutParams);
        }
        int i = C25738R.color.a69;
        if (!csF()) {
            int color = getResources().getColor(C25738R.color.f11782h4);
            if (this.rnM == null || this.rnM.size() <= 0 || C5046bo.isNullOrNil(((C3952g) this.rnM.getFirst()).hfo)) {
                i = color;
            } else {
                i = Color.parseColor(((C3952g) this.rnM.getFirst()).hfo);
            }
            this.rop.setBackgroundColor(i);
            i = C25738R.color.f11782h4;
        }
        Drawable drawable = this.rnN.getDrawable();
        if (drawable != null) {
            C0280a.m455a(drawable, C0380b.m652i(this, i));
            this.rnN.setImageDrawable(drawable);
        }
        drawable = this.rnO.getDrawable();
        if (drawable != null) {
            C0280a.m455a(drawable, C0380b.m652i(this, i));
            this.rnO.setImageDrawable(drawable);
        }
        if (csG() && !csH() && this.qXr == 2) {
            this.rnO.setVisibility(8);
            this.rnQ.setVisibility(0);
            this.rnQ.setText(this.rnV);
            this.rnQ.setOnClickListener(new C1350519());
            AppMethodBeat.m2505o(38659);
        } else if (csD()) {
            this.rnO.setOnClickListener(new C135092());
            AppMethodBeat.m2505o(38659);
        } else {
            this.rnO.setVisibility(8);
            AppMethodBeat.m2505o(38659);
        }
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(38660);
        getWindow().clearFlags(128);
        if (this.aGz) {
            C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy");
            if (!this.rod) {
                csx();
                m21677IF();
            }
        }
        this.roA.clear();
        ((C29082b) this.rok.getAdapter()).rdA.clear();
        unregisterReceiver(this.roJ);
        C4879a.xxA.mo10053d(this.roH);
        AdLandingPagesProxy.getInstance().clearCallback();
        super.onDestroy();
        AppMethodBeat.m2505o(38660);
    }

    private void csx() {
        AppMethodBeat.m2504i(38661);
        C29082b c29082b = (C29082b) this.rok.getAdapter();
        if (c29082b == null) {
            AppMethodBeat.m2505o(38661);
            return;
        }
        for (Fragment fragment : c29082b.rdA) {
            ((ContentFragment) fragment).cpn();
        }
        AppMethodBeat.m2505o(38661);
    }

    /* renamed from: IF */
    private void m21677IF() {
        AppMethodBeat.m2504i(38662);
        List allComp = getAllComp();
        for (SnsAdLandingPageFloatView allComp2 : this.roA.values()) {
            allComp.addAll(allComp2.getAllComp());
        }
        this.iBA += System.currentTimeMillis() - this.startTime;
        this.roc.reH = (int) this.iBA;
        this.roc.reG = allComp.size();
        this.roc.mo62906dk(allComp);
        C4990ab.m7417i("MicroMsg.SnsAdNativeLandingPagesUI", "landingPage report json %s", this.roc.reK);
        String cqm = this.roc.cqm();
        if (this.qXr == 2) {
            AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, cqm);
            C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: ".concat(String.valueOf(cqm)));
            AppMethodBeat.m2505o(38662);
        } else if (AdLandingPagesProxy.getInstance().isRecExpAd(this.roc.cFc)) {
            C7060h.pYm.mo8374X(14650, cqm);
            C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: ".concat(String.valueOf(cqm)));
            AppMethodBeat.m2505o(38662);
        } else {
            C7060h.pYm.mo8374X(13387, cqm);
            C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: ".concat(String.valueOf(cqm)));
            AppMethodBeat.m2505o(38662);
        }
    }

    private void csy() {
        AppMethodBeat.m2504i(38663);
        if (this.qUA != 2) {
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[7];
            objArr[0] = C29036i.m46117jV(C29036i.m46094Xq(this.roc.cFc));
            objArr[1] = this.qPj == null ? "" : this.qPj;
            objArr[2] = Integer.valueOf(this.roc.reB);
            objArr[3] = Integer.valueOf(this.roc.lgf);
            objArr[4] = Long.valueOf(this.edh);
            objArr[5] = Integer.valueOf(this.qXp);
            objArr[6] = this.roc.hxZ;
            c7060h.mo8381e(14655, objArr);
        }
        AppMethodBeat.m2505o(38663);
    }

    private boolean csz() {
        AppMethodBeat.m2504i(38664);
        if (this.roo.getChildAt(this.roo.getChildCount() - 2) instanceof SnsAdLandingPageFloatView) {
            AppMethodBeat.m2505o(38664);
            return true;
        }
        AppMethodBeat.m2505o(38664);
        return false;
    }

    public void onResume() {
        AppMethodBeat.m2504i(38665);
        C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
        super.onResume();
        C29064ad.m46205ac(this);
        if (csz()) {
            ((SnsAdLandingPageFloatView) this.roo.getChildAt(this.roo.getChildCount() - 2)).onResume();
            AppMethodBeat.m2505o(38665);
            return;
        }
        this.roy = false;
        AdlandingDummyViewPager adlandingDummyViewPager = this.rok;
        adlandingDummyViewPager.rcR.add(this.roE);
        C37116d.m62125S(this).mo59171a(this.roB, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
        C37116d.m62125S(this).mo59171a(this.roC, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
        if (this.aGz) {
            this.startTime = System.currentTimeMillis();
        }
        registerReceiver(this.roJ, new IntentFilter("android.intent.action.SCREEN_ON"));
        C4879a.xxA.mo10052c(this.roG);
        if (this.rof) {
            mo25675lg(false);
        }
        AppMethodBeat.m2505o(38665);
    }

    public void onPause() {
        AppMethodBeat.m2504i(38666);
        super.onPause();
        C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "onPause");
        this.roy = true;
        if (this.aGz) {
            this.iBA += System.currentTimeMillis() - this.startTime;
        }
        if (csz()) {
            for (SnsAdLandingPageFloatView onPause : this.roA.values()) {
                onPause.onPause();
            }
        }
        AdlandingDummyViewPager adlandingDummyViewPager = this.rok;
        adlandingDummyViewPager.rcR.remove(this.roE);
        C37116d.m62125S(this).unregisterReceiver(this.roB);
        C37116d.m62125S(this).unregisterReceiver(this.roC);
        C4879a.xxA.mo10053d(this.roG);
        if (this.roK != null) {
            this.roK.cpE();
        }
        AppMethodBeat.m2505o(38666);
    }

    public void onSwipeBack() {
        AppMethodBeat.m2504i(38667);
        this.roc.ecH = 2;
        C39785k c39785k = this.roc;
        c39785k.reF++;
        super.onSwipeBack();
        AppMethodBeat.m2505o(38667);
    }

    /* renamed from: Kh */
    private void m21680Kh() {
        AppMethodBeat.m2504i(38668);
        this.ros = AdLandingPagesProxy.getInstance().getSnsInfo(this.cFc);
        AdLandingPagesProxy.getInstance().asyncCacheXml(this.cFc);
        if (this.values == null) {
            C4990ab.m7412e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + this.rnT);
            AppMethodBeat.m2505o(38668);
            return;
        }
        String group;
        String str;
        String str2;
        if (this.cvd == 1 || this.cvd == 2 || this.cvd == 16 || this.cvd == 14 || this.cvd == 9 || this.cvd == 10) {
            long j = 0;
            if (this.ros != null) {
                j = this.ros.field_snsId;
                this.qTL = AdLandingPagesProxy.getInstance().getSnsAid(this.cFc);
                this.hcx = AdLandingPagesProxy.getInstance().getSnsTraceid(this.cFc);
                this.qUe = AdLandingPagesProxy.getInstance().getSnsAdType(this.cFc);
                this.qPj = AdLandingPagesProxy.getInstance().getSnsUxInfo(this.cFc);
                this.qTM = AdLandingPagesProxy.getInstance().getSnsAdCanvasExtXml(this.cFc);
            }
            Object valueOf = this.roa != null ? this.roa : String.valueOf(j);
            this.values.put("." + this.rnU + ".originSnsId", valueOf);
            this.values.put("." + this.rnU + ".originUxInfo", this.qPj);
            CharSequence charSequence = ((((("<" + this.rnU + ">") + String.format("<originSnsId>%s</originSnsId>", new Object[]{valueOf})) + String.format("<originUxInfo>%s</originUxInfo>", new Object[]{this.qPj})) + String.format("<originAdType>%d</originAdType>", new Object[]{Integer.valueOf(this.qUe)})) + String.format("<originAid>%s</originAid>", new Object[]{this.qTL})) + String.format("<originTraceId>%s</originTraceId>", new Object[]{this.hcx});
            if (!C5046bo.isNullOrNil(this.qTM)) {
                charSequence = charSequence + String.format("<originAdCanvasExt>%s</originAdCanvasExt>", new Object[]{this.qTM});
            }
            this.rnT = this.rnT.replace("<" + this.rnU + ">", charSequence);
            this.roc.qPj = this.qPj;
            this.roc.cFc = valueOf;
        } else {
            this.roc.cFc = (String) this.values.get("." + this.rnU + ".originSnsId");
            this.roc.qPj = (String) this.values.get("." + this.rnU + ".originUxInfo");
            this.qPj = this.roc.qPj;
            this.roa = this.roc.cFc;
            this.qUe = C5046bo.ank((String) this.values.get("." + this.rnU + ".originAdType"));
            this.qTL = (String) this.values.get("." + this.rnU + ".originAid");
            this.hcx = (String) this.values.get("." + this.rnU + ".originTraceId");
            if (!C5046bo.isNullOrNil(this.hya)) {
                Map z = C5049br.m7595z(this.hya, "ADInfo");
                this.qPj = C5046bo.m7532bc((String) z.get(".ADInfo.uxInfo"), "");
                this.roc.qPj = this.qPj;
                this.qTL = C5046bo.m7532bc((String) z.get(".ADInfo.session_data.aid"), "");
                this.hcx = C5046bo.m7532bc((String) z.get(".ADInfo.session_data.trace_id"), "");
            }
            Matcher matcher = Pattern.compile("<originAdCanvasExt>[\\s\\S]*</originAdCanvasExt>").matcher(this.rnT);
            if (matcher.find()) {
                group = matcher.group();
                if (!C5046bo.isNullOrNil(group)) {
                    this.qTM = group.replaceAll("</?originAdCanvasExt>", "");
                }
            }
        }
        C4990ab.m7417i("MicroMsg.SnsAdNativeLandingPagesUI", "reportInfo aid [%s],traceId [%s],adType [%s],uxInfo [%s],adCanvasExtXml [%s]", this.qTL, this.hcx, Integer.valueOf(this.qUe), this.qPj, this.qTM);
        if (!C5046bo.isNullOrNil(this.qTM)) {
            str = ".adCardItemList.cardItem";
            Map z2 = C5049br.m7595z(this.qTM, "adCardItemList");
            if (z2 != null) {
                int i = 0;
                while (true) {
                    if (i > 0) {
                        str2 = str + i;
                    } else {
                        str2 = str;
                    }
                    if (!z2.containsKey(str2 + ".cardTpId")) {
                        break;
                    }
                    String bc = C5046bo.m7532bc((String) z2.get(str2 + ".cardTpId"), "");
                    group = C5046bo.m7532bc((String) z2.get(str2 + ".cardExt"), "");
                    if (!(C5046bo.isNullOrNil(bc) || C5046bo.isNullOrNil(group))) {
                        this.qXs.put(bc, group);
                    }
                    i++;
                }
            }
        }
        this.roc.reJ = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(C5046bo.anl(this.roc.cFc));
        this.lvA = C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.shareTitle"), "");
        this.lvz = C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.shareWebUrl"), "");
        this.qVw = C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.shareDesc"), "");
        this.qXr = C5046bo.ank(C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.bizId"), ""));
        this.rog = C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.shareAppId"), "");
        this.roh = C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.shareType"), "");
        this.roi = C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.userInfo"), "");
        this.rol = C5046bo.ank(C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.disableShareBitSet"), ""));
        this.rom = C5046bo.ank(C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.statusBarStyle"), ""));
        m21705s(this.values, "." + this.rnU);
        this.uin = AdLandingPagesProxy.getInstance().getUin();
        this.roj = C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.officialSyncBuffer"), "");
        getIntent().putExtra("sns_landing_pages_adType", this.qUe);
        getIntent().putExtra("sns_landing_pages_rawSnsId", this.roc.cFc);
        if (C5046bo.isNullOrNil(this.qTL)) {
            this.qTL = C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".originAid"), "");
        }
        if (C5046bo.isNullOrNil(this.hcx)) {
            this.hcx = C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".originTraceId"), "");
        }
        this.rnM = C3953i.m6304gn(this.rnT, this.rnU);
        if (this.rnM.size() > 0) {
            str2 = "";
            C3952g c3952g = (C3952g) this.rnM.get(0);
            if (c3952g.rej.size() > 0) {
                C29086r c29086r = (C29086r) c3952g.rej.get(0);
                if (c29086r instanceof C39780n) {
                    this.rnZ = ((C39780n) c29086r).qWD;
                } else if (c29086r instanceof C46232m) {
                    this.rnZ = ((C46232m) c29086r).qWD;
                } else if (c29086r instanceof C46233o) {
                    this.rnZ = ((C46233o) c29086r).qWG;
                    str2 = ((C46233o) c29086r).qWF;
                } else if (c29086r instanceof C34986x) {
                    C34986x c34986x = (C34986x) c29086r;
                    if (!c34986x.qWB.isEmpty()) {
                        C39779l c39779l = (C39779l) c34986x.qWB.getFirst();
                        if (!c39779l.qWB.isEmpty()) {
                            c29086r = (C29086r) c39779l.qWB.getFirst();
                            if (c29086r instanceof C39780n) {
                                this.rnZ = ((C39780n) c29086r).qWD;
                            }
                        }
                    }
                }
            }
            if (this.ros != null) {
                TimeLineObject cqu = this.ros.cqu();
                if (!(cqu == null || cqu.xfI == null || cqu.xfI.wbK == null || cqu.xfI.wbK.isEmpty())) {
                    bau bau = (bau) cqu.xfI.wbK.getFirst();
                    str = C3892an.m6198fZ(AdLandingPagesProxy.getInstance().getAccSnsPath(), bau.f17915Id) + C29036i.m46116j(bau);
                    group = bau.Url;
                    if (str2.equals(group)) {
                        group = C13473h.m21626gk("adId", group);
                        if (!C5730e.m8628ct(group) && C5730e.m8628ct(str)) {
                            C4990ab.m7417i("MicroMsg.SnsAdNativeLandingPagesUI", "copy outsideFiel:%s->%s", str, group);
                            C5730e.m8644y(str, group);
                        }
                    }
                }
            }
        }
        this.rnV = C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.rightBarTitle"), "");
        this.rnW = C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.rightBarCanvasId"), "");
        this.rnX = C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.rightBarCanvasExt"), "");
        AppMethodBeat.m2505o(38668);
    }

    /* renamed from: s */
    private void m21705s(Map<String, String> map, String str) {
        AppMethodBeat.m2504i(38669);
        String str2 = (String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
        if (TextUtils.isEmpty(str2)) {
            this.rdd = null;
            AppMethodBeat.m2505o(38669);
            return;
        }
        int i;
        if (this.rdd == null) {
            this.rdd = new C21939ac();
        }
        this.rdd.iconUrl = str2;
        int ank = C5046bo.ank((String) map.get(str + ".adCanvasInfo.sizeType"));
        int ank2 = C5046bo.ank((String) map.get(str + ".adCanvasInfo.basicRootFontSize"));
        int ank3 = C5046bo.ank((String) map.get(str + ".adCanvasInfo.basicWidth"));
        if (ank2 == 0 && ank == 1) {
            i = C3953i.ren;
        } else {
            i = ank2;
        }
        if (ank3 == 0 && ank == 1) {
            ank2 = C3953i.rem;
        } else {
            ank2 = ank3;
        }
        this.rdd.qWR = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), ank, ank2, i);
        this.rdd.width = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), ank, ank2, i);
        this.rdd.height = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), ank, ank2, i);
        AppMethodBeat.m2505o(38669);
    }

    private List<C3952g> csA() {
        AppMethodBeat.m2504i(38670);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.rnM.iterator();
        while (it.hasNext()) {
            C3952g c3952g = (C3952g) it.next();
            if (c3952g.rel) {
                arrayList.add(c3952g);
            }
        }
        AppMethodBeat.m2505o(38670);
        return arrayList;
    }

    private void csB() {
        C29082b c29082b;
        AppMethodBeat.m2504i(38671);
        C29082b c29082b2 = (C29082b) this.rok.getAdapter();
        if (c29082b2 == null) {
            c29082b2 = new C29082b(getSupportFragmentManager(), new ArrayList());
            this.rok.setAdapter(c29082b2);
            c29082b = c29082b2;
        } else {
            c29082b = c29082b2;
        }
        List csA = csA();
        if (csA.size() > 0) {
            C3952g c3952g = (C3952g) csA.get(0);
            C4990ab.m7417i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load id %s", Integer.valueOf(c3952g.f1283id));
            Fragment fragment = (ContentFragment) this.roI.get(Integer.valueOf(c3952g.f1283id));
            if (fragment == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("pageInfo", c3952g);
                hashMap.put("viewPager", this.rok);
                hashMap.put("pageDownIconInfo", this.rdd);
                hashMap.put("is_first_show_page", Boolean.TRUE);
                if (csA.size() == 1) {
                    hashMap.put("is_last_shown_page", Boolean.TRUE);
                }
                hashMap.put("needEnterAnimation", Boolean.valueOf(this.rnS));
                hashMap.put("needDirectionAnimation", Boolean.valueOf(csE()));
                hashMap.put("groupListCompShowIndex", Integer.valueOf(this.roe));
                fragment = new ContentFragment();
                fragment.puc = hashMap;
                fragment.rdn = this.roD;
                this.roI.put(Integer.valueOf(c3952g.f1283id), fragment);
            } else {
                fragment.mo16732a(c3952g);
            }
            if (fragment != null) {
                c29082b.mo47193a(fragment, 0);
            }
            c29082b.notifyDataSetChanged();
            this.rok.setOffscreenPageLimit(csA.size());
        }
        AppMethodBeat.m2505o(38671);
    }

    private void csC() {
        C29082b c29082b;
        AppMethodBeat.m2504i(38672);
        C29082b c29082b2 = (C29082b) this.rok.getAdapter();
        if (c29082b2 == null) {
            c29082b2 = new C29082b(getSupportFragmentManager(), new ArrayList());
            this.rok.setAdapter(c29082b2);
            c29082b = c29082b2;
        } else {
            c29082b = c29082b2;
        }
        List csA = csA();
        for (int i = 0; i < csA.size(); i++) {
            C3952g c3952g = (C3952g) this.rnM.get(i);
            C4990ab.m7417i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load id %s", Integer.valueOf(c3952g.f1283id));
            Fragment fragment = (ContentFragment) this.roI.get(Integer.valueOf(c3952g.f1283id));
            if (fragment == null) {
                boolean z;
                int i2;
                HashMap hashMap = new HashMap();
                hashMap.put("pageInfo", c3952g);
                hashMap.put("viewPager", this.rok);
                hashMap.put("pageDownIconInfo", this.rdd);
                String str = "is_first_show_page";
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                hashMap.put(str, Boolean.valueOf(z));
                str = "is_last_shown_page";
                if (i == csA.size() - 1) {
                    z = true;
                } else {
                    z = false;
                }
                hashMap.put(str, Boolean.valueOf(z));
                hashMap.put("needEnterAnimation", Boolean.valueOf(this.rnS));
                hashMap.put("needDirectionAnimation", Boolean.valueOf(csE()));
                str = "groupListCompShowIndex";
                if (i == 0) {
                    i2 = this.roe;
                } else {
                    i2 = 0;
                }
                hashMap.put(str, Integer.valueOf(i2));
                fragment = new ContentFragment();
                fragment.puc = hashMap;
                if (i == 0) {
                    fragment.rdn = this.roD;
                }
                this.roI.put(Integer.valueOf(c3952g.f1283id), fragment);
            } else {
                fragment.mo16732a(c3952g);
            }
            if (fragment != null) {
                c29082b.mo47193a(fragment, i);
            }
        }
        c29082b.notifyDataSetChanged();
        this.rok.setOffscreenPageLimit(csA.size());
        AppMethodBeat.m2505o(38672);
    }

    private List<C13437h> getAllComp() {
        AppMethodBeat.m2504i(38673);
        this.rot = new ArrayList();
        C29082b c29082b = (C29082b) this.rok.getAdapter();
        if (c29082b != null) {
            for (Fragment fragment : c29082b.rdA) {
                this.rot.addAll(((ContentFragment) fragment).cqa());
            }
        }
        C3953i.m6300dj(this.rot);
        List list = this.rot;
        AppMethodBeat.m2505o(38673);
        return list;
    }

    @TargetApi(16)
    public final void initView() {
        AppMethodBeat.m2504i(38674);
        super.initView();
        this.roo = (FrameLayout) findViewById(2131820987);
        this.roq = findViewById(2131827617);
        this.rok = (AdlandingDummyViewPager) findViewById(2131827657);
        this.rop = findViewById(2131827618);
        if (C5222ae.m7950hD(this.mController.ylL)) {
            LayoutParams layoutParams = (LayoutParams) this.roo.getLayoutParams();
            layoutParams.height = this.iev - C5222ae.m7949hC(this);
            layoutParams.topMargin = C5222ae.m7949hC(this);
            this.roo.setLayoutParams(layoutParams);
            this.mController.mo11249xE(getResources().getColor(C25738R.color.f11695dt));
            C5240b.m8007a(this, true, this.roo);
        } else {
            C5240b.m8007a(this, false, this.roo);
        }
        this.mmX = (ImageView) findViewById(2131822079);
        this.rnP = (ImageView) findViewById(2131827656);
        this.rnN = (ImageView) findViewById(2131827619);
        this.rnN.setOnClickListener(new C135133());
        this.rnO = (ImageView) findViewById(2131827620);
        this.rnQ = (TextView) findViewById(2131827659);
        this.rnY = (ImageView) findViewById(2131827658);
        if (this.rnS) {
            this.roo.setAlpha(0.0f);
            this.mmX.setAlpha(0.0f);
            C5274b.m8045a(this, null);
        }
        AppMethodBeat.m2505o(38674);
    }

    public boolean convertActivityFromTranslucent() {
        return false;
    }

    public final int getLayoutId() {
        return 2130970736;
    }

    private boolean csD() {
        AppMethodBeat.m2504i(38675);
        if (this.rol == 0) {
            AppMethodBeat.m2505o(38675);
            return true;
        } else if ((this.rol & 4) == 0 || (this.rol & 2) == 0 || ((csH() && this.qXr == 2) || (this.rol & 1) == 0)) {
            AppMethodBeat.m2505o(38675);
            return true;
        } else {
            AppMethodBeat.m2505o(38675);
            return false;
        }
    }

    private boolean csE() {
        return (this.rol & 8) == 0;
    }

    private boolean csF() {
        return this.rom == 0;
    }

    private boolean csG() {
        AppMethodBeat.m2504i(38676);
        if (C5046bo.isNullOrNil(this.rnV) || C5046bo.isNullOrNil(this.rnW)) {
            AppMethodBeat.m2505o(38676);
            return false;
        }
        AppMethodBeat.m2505o(38676);
        return true;
    }

    private boolean csH() {
        return (this.rol & 16) == 0;
    }

    public final void bcW() {
        AppMethodBeat.m2504i(38677);
        try {
            for (SnsAdLandingPageFloatView snsAdLandingPageFloatView : this.roA.values()) {
                snsAdLandingPageFloatView.onPause();
                snsAdLandingPageFloatView.setVisibility(8);
            }
            aqX();
            csx();
            m21677IF();
            this.rod = true;
            this.rop.setVisibility(8);
            if (!this.rnS) {
                finish();
                AppMethodBeat.m2505o(38677);
            } else if (this.rox) {
                C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
                AppMethodBeat.m2505o(38677);
            } else {
                C4990ab.m7417i("MicroMsg.SnsAdNativeLandingPagesUI", "run exit animation, %s", Boolean.valueOf(this.rnS));
                this.rox = true;
                if (isSupportNavigationSwipeBack()) {
                    getSwipeBackLayout().setEnableGesture(false);
                }
                for (C13437h c13437h : csI().cqa()) {
                    if (c13437h instanceof C29060a) {
                        ((C29060a) c13437h).coY();
                        c13437h.cpA();
                    }
                }
                C5004al.m7442n(new C135145(), 30);
                AppMethodBeat.m2505o(38677);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SnsAdNativeLandingPagesUI", e, "play exit animation error", new Object[0]);
            finish();
            AppMethodBeat.m2505o(38677);
        }
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(38678);
        bcW();
        AppMethodBeat.m2505o(38678);
    }

    private ContentFragment csI() {
        AppMethodBeat.m2504i(38679);
        ContentFragment contentFragment = null;
        if (this.rnM.size() > 0) {
            contentFragment = (ContentFragment) this.roI.get(Integer.valueOf(((C3952g) this.rnM.get(this.rok.getCurrentItem())).f1283id));
        }
        AppMethodBeat.m2505o(38679);
        return contentFragment;
    }

    private C13515a csJ() {
        AppMethodBeat.m2504i(38680);
        C21984b c21984b = new C21984b(this.rnT);
        if (c21984b.coS()) {
            int adVoteIndex = AdLandingPagesProxy.getInstance().getAdVoteIndex(c21984b.qVh.qVu, this.qPj, this.uin);
            if (adVoteIndex > 0 && adVoteIndex <= c21984b.qVh.qVv.size()) {
                C21987g c21987g = (C21987g) c21984b.qVh.qVv.get(adVoteIndex - 1);
                C13515a c13515a = new C13515a(this, (byte) 0);
                if (C5046bo.isNullOrNil(c21987g.lvA)) {
                    c13515a.lvA = this.lvA;
                } else {
                    c13515a.lvA = c21987g.lvA;
                }
                if (C5046bo.isNullOrNil(c21987g.qVw)) {
                    c13515a.qVw = this.qVw;
                } else {
                    c13515a.qVw = c21987g.qVw;
                }
                if (C5046bo.isNullOrNil(c21987g.qVx)) {
                    c13515a.qVx = this.rnZ;
                } else {
                    c13515a.qVx = c21987g.qVx;
                }
                AppMethodBeat.m2505o(38680);
                return c13515a;
            }
        }
        AppMethodBeat.m2505o(38680);
        return null;
    }

    /* renamed from: ZD */
    private String m21685ZD(String str) {
        AppMethodBeat.m2504i(38681);
        String bc = C5046bo.m7532bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.shareThumbUrl"), "");
        if (C5046bo.isNullOrNil(bc)) {
            AppMethodBeat.m2505o(38681);
            return str;
        }
        AppMethodBeat.m2505o(38681);
        return bc;
    }

    private String csK() {
        AppMethodBeat.m2504i(38682);
        cdg cdg = new cdg();
        cdg.xcS = new cdh();
        cdg.xcS.xcW = this.roc.qPj;
        cdg.xcS.xcV = this.roc.cFc;
        cdg.xcS.qUe = this.qUe;
        String encodeToString;
        try {
            encodeToString = Base64.encodeToString(cdg.toByteArray(), 2);
            AppMethodBeat.m2505o(38682);
            return encodeToString;
        } catch (Exception e) {
            encodeToString = "";
            AppMethodBeat.m2505o(38682);
            return encodeToString;
        }
    }

    private String csL() {
        AppMethodBeat.m2504i(38683);
        String replaceAll = this.rnT.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
        AppMethodBeat.m2505o(38683);
        return replaceAll;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(38684);
        if (i == 1) {
            if (i2 == -1) {
                C30379h.m48465bQ(this.mController.ylL, this.mController.ylL.getString(C25738R.string.f9229to));
            }
        } else if (i == 2) {
            if (intent.getBooleanExtra("kfavorite", false)) {
                ((C34131v) C1720g.m3528K(C34131v.class)).mo27206a(AdLandingPagesProxy.getInstance().doFav(intent, 42), this, this.mUw);
            }
        } else if (i == C39774x.rbL) {
            try {
                String stringExtra = intent.getStringExtra("KComponentCid");
                for (C13437h c13437h : getAllComp()) {
                    if (c13437h.cpy().equals(stringExtra)) {
                        C39774x c39774x = (C39774x) c13437h;
                        int intExtra = intent.getIntExtra("KStreamVideoPlayCount", 0);
                        int intExtra2 = intent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
                        int intExtra3 = intent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
                        c39774x.qEo = intExtra + c39774x.qEo;
                        c39774x.qEp += intExtra2;
                        c39774x.qEq += intExtra3;
                        break;
                    }
                }
            } catch (Exception e) {
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(38684);
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.m2504i(38685);
        super.onKeyboardStateChanged();
        if (this.rok != null) {
            this.rok.postDelayed(new C135048(), 500);
        }
        AppMethodBeat.m2505o(38685);
    }

    /* renamed from: lg */
    public final void mo25675lg(boolean z) {
        AppMethodBeat.m2504i(38686);
        if (z && this.qXr == 1) {
            AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.rog, this.roh, this.roi, this.roF);
        }
        if (this.qXr == 2 && !C5046bo.isNullOrNil(this.roj)) {
            AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.roj, this.roF);
        }
        this.rof = true;
        AppMethodBeat.m2505o(38686);
    }

    /* renamed from: a */
    public final void mo25673a(C29086r c29086r, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(38687);
        if (this.roK == null || z3) {
            final boolean z4 = z3;
            C1349810 c1349810 = new C34948e() {
                /* renamed from: ao */
                public final void mo25548ao(Object obj) {
                }

                /* renamed from: f */
                public final void mo25549f(int i, int i2, Object obj) {
                    AppMethodBeat.m2504i(38636);
                    SnsAdNativeLandingPagesUI.this.mo25675lg(false);
                    if (z4) {
                        if (SnsAdNativeLandingPagesUI.this.roK != null) {
                            SnsAdNativeLandingPagesUI.this.roK.cpE();
                        }
                        if (SnsAdNativeLandingPagesUI.this.roL != null) {
                            SnsAdNativeLandingPagesUI.this.roL.dismiss();
                            SnsAdNativeLandingPagesUI.this.roL = null;
                        }
                    }
                    AppMethodBeat.m2505o(38636);
                }
            };
            if (!z3) {
                C13437h a = C43590al.m77980a(this.mController.ylL, c29086r, new LinearLayout(this.mController.ylL), !C5046bo.isNullOrNil(c29086r.qWX) ? Color.parseColor(c29086r.qWX) : -1);
                this.roK = new C29068i(this.mController.ylL, a, str, str2, str3, z, z2);
                final View view = a.getView();
                this.roK.qZy = new C29070a() {
                    public final void cpF() {
                        AppMethodBeat.m2504i(38637);
                        C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
                        csM();
                        AppMethodBeat.m2505o(38637);
                    }

                    public final void cpG() {
                        AppMethodBeat.m2504i(38638);
                        C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
                        csM();
                        AppMethodBeat.m2505o(38638);
                    }

                    private void csM() {
                        AppMethodBeat.m2504i(38639);
                        if (!(view == null || view.getParent() == null)) {
                            ((ViewGroup) view.getParent()).removeView(view);
                        }
                        SnsAdNativeLandingPagesUI.this.roK = null;
                        AppMethodBeat.m2505o(38639);
                    }
                };
                this.roK.cpD();
            }
            if (!C5046bo.isNullOrNil(str)) {
                AdLandingPagesProxy.getInstance().doFavOfficialItemScene(str, c1349810);
                if (z3) {
                    this.roL = C30379h.m48458b((Context) this, getString(C25738R.string.em7), false, null);
                }
            }
            AppMethodBeat.m2505o(38687);
            return;
        }
        C4990ab.m7420w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
        this.roK.cpE();
        if (this.roL != null) {
            this.roL.dismiss();
            this.roL = null;
        }
        AppMethodBeat.m2505o(38687);
    }

    /* renamed from: w */
    public final void mo25676w(Context context, String str, String str2) {
        AppMethodBeat.m2504i(38688);
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", 14);
        intent.putExtra("sns_landig_pages_origin_from_source", this.qXp == 0 ? this.cvd : this.qXp);
        intent.putExtra("sns_landing_pages_canvasid", str);
        intent.putExtra("sns_landing_pages_canvas_ext", str2);
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        intent.putExtra("sns_landing_pages_no_store", 1);
        String stringExtra = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        String stringExtra2 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", valueOf);
                jSONObject.put("cid", "");
                jSONObject.put("adBuffer", !C5046bo.isNullOrNil(stringExtra2) ? stringExtra2 : "");
                jSONObject.put("preSessionId", stringExtra);
            } catch (Exception e) {
            }
            intent.putExtra("sns_landing_pages_search_extra", jSONObject.toString());
            intent.putExtra("sns_landing_pages_sessionId", valueOf);
            intent.putExtra("sns_landing_pages_ad_buffer", stringExtra2);
        }
        C25985d.m41467b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
        AppMethodBeat.m2505o(38688);
    }

    /* renamed from: g */
    static /* synthetic */ void m21692g(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.m2504i(38689);
        if (snsAdNativeLandingPagesUI.rox) {
            C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
            AppMethodBeat.m2505o(38689);
            return;
        }
        snsAdNativeLandingPagesUI.rox = true;
        if (snsAdNativeLandingPagesUI.isSupportNavigationSwipeBack()) {
            snsAdNativeLandingPagesUI.getSwipeBackLayout().setEnableGesture(false);
            snsAdNativeLandingPagesUI.getSwipeBackLayout().mo11418qX(true);
        }
        if (snsAdNativeLandingPagesUI.rou == null) {
            snsAdNativeLandingPagesUI.rou = new C39836b(snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.rnP);
            AdLandingPagesProxy.getInstance().playTimelineClickAnimation(0);
            Bundle bundle = new Bundle();
            bundle.putInt("param_thumb_left", snsAdNativeLandingPagesUI.kkr);
            bundle.putInt("param_thumb_top", snsAdNativeLandingPagesUI.kkq);
            bundle.putInt("param_thumb_width", snsAdNativeLandingPagesUI.kks);
            bundle.putInt("param_thumb_height", snsAdNativeLandingPagesUI.kkt);
            C39836b c39836b = snsAdNativeLandingPagesUI.rou;
            c39836b.rFP = bundle.getInt("param_thumb_left");
            c39836b.rFQ = bundle.getInt("param_thumb_top");
            c39836b.rFR = bundle.getInt("param_thumb_width");
            c39836b.rFS = bundle.getInt("param_thumb_height");
            C4990ab.m7417i("MicroMsg.SnsAdNativeEnterAnimation", "left %s, top %s, width %s, height %s", Integer.valueOf(c39836b.rFP), Integer.valueOf(c39836b.rFQ), Integer.valueOf(c39836b.rFR), Integer.valueOf(c39836b.rFS));
            snsAdNativeLandingPagesUI.rou.rFT = new C135224();
            C39836b c39836b2 = snsAdNativeLandingPagesUI.rou;
            if (!c39836b2.nVD.isStarted()) {
                c39836b2.nVD.setStartDelay(0);
                c39836b2.nVD.start();
            }
        }
        AppMethodBeat.m2505o(38689);
    }

    /* renamed from: D */
    static /* synthetic */ void m21671D(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.m2504i(38695);
        C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "doTransimt snsAdNativeLadingPagesUI");
        C39785k c39785k = snsAdNativeLandingPagesUI.roc;
        c39785k.meZ++;
        String csK = snsAdNativeLandingPagesUI.csK();
        String csL = snsAdNativeLandingPagesUI.csL();
        C13515a csJ = snsAdNativeLandingPagesUI.csJ();
        if (csJ != null) {
            AdLandingPagesProxy.getInstance().doTransimt(snsAdNativeLandingPagesUI, csL, csJ.lvA, snsAdNativeLandingPagesUI.m21685ZD(csJ.qVx), csJ.qVw, snsAdNativeLandingPagesUI.lvz, csK);
            AppMethodBeat.m2505o(38695);
            return;
        }
        AdLandingPagesProxy.getInstance().doTransimt(snsAdNativeLandingPagesUI, csL, snsAdNativeLandingPagesUI.lvA, snsAdNativeLandingPagesUI.m21685ZD(snsAdNativeLandingPagesUI.rnZ), snsAdNativeLandingPagesUI.qVw, snsAdNativeLandingPagesUI.lvz, csK);
        AppMethodBeat.m2505o(38695);
    }

    /* renamed from: E */
    static /* synthetic */ void m21672E(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.m2504i(38696);
        C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "doShareToTimeline snsAdNativeLadingPagesUI");
        C39785k c39785k = snsAdNativeLandingPagesUI.roc;
        c39785k.mfa++;
        String str = snsAdNativeLandingPagesUI.lvz;
        C13515a csJ = snsAdNativeLandingPagesUI.csJ();
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline fail, link is null");
            AppMethodBeat.m2505o(38696);
            return;
        }
        int i = snsAdNativeLandingPagesUI.kks;
        C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, init intent");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i);
        intent.putExtra("Ksnsupload_height", i);
        intent.putExtra("Ksnsupload_link", snsAdNativeLandingPagesUI.lvz);
        if (csJ != null) {
            intent.putExtra("Ksnsupload_title", csJ.lvA);
            intent.putExtra("Ksnsupload_imgurl", snsAdNativeLandingPagesUI.m21685ZD(csJ.qVx));
        } else {
            intent.putExtra("Ksnsupload_title", snsAdNativeLandingPagesUI.lvA);
            intent.putExtra("Ksnsupload_imgurl", snsAdNativeLandingPagesUI.m21685ZD(snsAdNativeLandingPagesUI.rnZ));
        }
        intent.putExtra("Ksnsupload_canvas_info", snsAdNativeLandingPagesUI.csL());
        intent.putExtra("Ksnsupload_contentattribute", 0);
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        str = snsAdNativeLandingPagesUI.csK();
        if (!C5046bo.isNullOrNil(str)) {
            intent.putExtra("key_snsad_statextstr", str);
        }
        C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, start activity");
        intent.putExtra("need_result", true);
        str = "sns_";
        if (snsAdNativeLandingPagesUI.cvd == 1 || snsAdNativeLandingPagesUI.cvd == 2 || snsAdNativeLandingPagesUI.cvd == 3 || snsAdNativeLandingPagesUI.cvd == 4 || snsAdNativeLandingPagesUI.cvd == 9 || snsAdNativeLandingPagesUI.cvd == 10 || snsAdNativeLandingPagesUI.cvd == 11) {
            str = "sns_" + snsAdNativeLandingPagesUI.cFc;
        } else if (snsAdNativeLandingPagesUI.cvd == 5 || snsAdNativeLandingPagesUI.cvd == 6) {
            str = "msg_".concat(String.valueOf(snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L)));
        } else if (snsAdNativeLandingPagesUI.cvd == 7) {
            str = "fav_".concat(String.valueOf(snsAdNativeLandingPagesUI.getIntent().getExtras().getString("sns_landing_favid")));
        }
        String nW = C37922v.m64078nW(str);
        C37922v.m64076Zp().mo60676y(nW, true).mo53356j("prePublishId", str);
        intent.putExtra("reportSessionId", nW);
        C25985d.m41453a(snsAdNativeLandingPagesUI.mController.ylL, "sns", ".ui.SnsUploadUI", intent, 1, false);
        AppMethodBeat.m2505o(38696);
    }

    /* renamed from: F */
    static /* synthetic */ void m21673F(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.m2504i(38697);
        C39785k c39785k = snsAdNativeLandingPagesUI.roc;
        c39785k.mLz++;
        C4990ab.m7416i("MicroMsg.SnsAdNativeLandingPagesUI", "doFav snsAdNativeLadingPagesUI");
        long j = snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L);
        String str = null;
        if (!C5046bo.isNullOrNil(snsAdNativeLandingPagesUI.cFc)) {
            C46236n snsInfo = AdLandingPagesProxy.getInstance().getSnsInfo(snsAdNativeLandingPagesUI.cFc);
            if (snsInfo != null) {
                str = snsInfo.cqU();
            }
            AppMethodBeat.m2505o(38697);
        }
        String nullAsNil = C5046bo.nullAsNil(snsAdNativeLandingPagesUI.getIntent().getStringExtra("prePublishId"));
        C13515a csJ = snsAdNativeLandingPagesUI.csJ();
        String csK = snsAdNativeLandingPagesUI.csK();
        String csL = snsAdNativeLandingPagesUI.csL();
        if (csJ != null) {
            AdLandingPagesProxy.getInstance().doFavAdlanding(j, str, snsAdNativeLandingPagesUI.cvd, snsAdNativeLandingPagesUI.lvz, nullAsNil, csJ.lvA, csJ.qVw, csL, 34, snsAdNativeLandingPagesUI.m21685ZD(csJ.qVx), csK);
        } else {
            AdLandingPagesProxy.getInstance().doFavAdlanding(j, str, snsAdNativeLandingPagesUI.cvd, snsAdNativeLandingPagesUI.lvz, nullAsNil, snsAdNativeLandingPagesUI.lvA, snsAdNativeLandingPagesUI.qVw, csL, 34, snsAdNativeLandingPagesUI.m21685ZD(snsAdNativeLandingPagesUI.rnZ), csK);
        }
        ((C34131v) C1720g.m3528K(C34131v.class)).mo27206a(0, snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.mUw);
        AppMethodBeat.m2505o(38697);
    }

    /* renamed from: I */
    static /* synthetic */ void m21676I(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.m2504i(38698);
        if (snsAdNativeLandingPagesUI.rnM != null) {
            Iterator it = snsAdNativeLandingPagesUI.rnM.iterator();
            while (it.hasNext()) {
                ContentFragment contentFragment = (ContentFragment) snsAdNativeLandingPagesUI.roI.get(Integer.valueOf(((C3952g) it.next()).f1283id));
                if (contentFragment != null) {
                    contentFragment.rdh = true;
                }
            }
            ((ContentFragment) snsAdNativeLandingPagesUI.roI.get(Integer.valueOf(((C3952g) snsAdNativeLandingPagesUI.rnM.getFirst()).f1283id))).cqd();
        }
        AppMethodBeat.m2505o(38698);
    }

    /* renamed from: J */
    static /* synthetic */ void m21678J(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.m2504i(38699);
        if (snsAdNativeLandingPagesUI.rov == null) {
            snsAdNativeLandingPagesUI.rov = new C46254c(snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.rnP);
            AdLandingPagesProxy.getInstance().playTimelineBackAnimation(0);
            Bundle bundle = new Bundle();
            bundle.putInt("param_thumb_left", snsAdNativeLandingPagesUI.kkr);
            bundle.putInt("param_thumb_top", snsAdNativeLandingPagesUI.kkq);
            bundle.putInt("param_thumb_width", snsAdNativeLandingPagesUI.kks);
            bundle.putInt("param_thumb_height", snsAdNativeLandingPagesUI.kkt);
            C46254c c46254c = snsAdNativeLandingPagesUI.rov;
            c46254c.rFP = bundle.getInt("param_thumb_left");
            c46254c.rFQ = bundle.getInt("param_thumb_top");
            c46254c.rFR = bundle.getInt("param_thumb_width");
            c46254c.rFS = bundle.getInt("param_thumb_height");
            C4990ab.m7417i("MicroMsg.SnsAdNativeExitAnimation", "left %s, top %s, width %s, height %s", Integer.valueOf(c46254c.rFP), Integer.valueOf(c46254c.rFQ), Integer.valueOf(c46254c.rFR), Integer.valueOf(c46254c.rFS));
        }
        Bitmap eA = C5056d.m7661eA(snsAdNativeLandingPagesUI.roq);
        if (eA != null) {
            snsAdNativeLandingPagesUI.rnP.setImageBitmap(eA);
        }
        snsAdNativeLandingPagesUI.rov.rFT = new C135076();
        C46254c c46254c2 = snsAdNativeLandingPagesUI.rov;
        if (!c46254c2.nVD.isStarted()) {
            c46254c2.nVD.setStartDelay(0);
            c46254c2.nVD.start();
        }
        AppMethodBeat.m2505o(38699);
    }
}
