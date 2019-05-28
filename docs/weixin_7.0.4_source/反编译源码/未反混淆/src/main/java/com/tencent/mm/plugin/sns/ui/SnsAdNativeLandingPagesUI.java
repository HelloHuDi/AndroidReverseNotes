package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.f;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.qv;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.snackbar.a.b;
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

@com.tencent.mm.ui.base.a(32)
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
    protected b mUw = new b() {
        public final void aIu() {
            AppMethodBeat.i(38633);
            try {
                AdLandingPagesProxy.getInstance().favEditTag();
                AppMethodBeat.o(38633);
            } catch (Exception e) {
                ab.e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + e.getMessage());
                AppMethodBeat.o(38633);
            }
        }
    };
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
    private ac rdd;
    public LinkedList<g> rnM = new LinkedList();
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
    private BroadcastReceiver roB = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            boolean z = true;
            AppMethodBeat.i(38621);
            ContentFragment contentFragment = (ContentFragment) ((k) SnsAdNativeLandingPagesUI.this.rok.getAdapter()).getItem(SnsAdNativeLandingPagesUI.this.rok.getCurrentItem());
            ab.d("MicroMsg.SnsAdNativeLandingPagesUI", "recv videoProgressbarStatusChangeReceiver show %d", Integer.valueOf(intent.getIntExtra("show", 0)));
            if (intent.getIntExtra("show", 0) != 1) {
                z = false;
            }
            contentFragment.rdi = z;
            if (!contentFragment.cqf() || z) {
                contentFragment.cqe();
                AppMethodBeat.o(38621);
                return;
            }
            contentFragment.cqd();
            AppMethodBeat.o(38621);
        }
    };
    private BroadcastReceiver roC = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(38640);
            ad.ac(SnsAdNativeLandingPagesUI.this);
            AppMethodBeat.o(38640);
        }
    };
    private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.a roD = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.a() {
        public final void n(ContentFragment contentFragment) {
            RecyclerView recyclerView;
            AppMethodBeat.i(38643);
            if (contentFragment.rdo != null) {
                recyclerView = contentFragment.rdo.iJP;
            } else {
                recyclerView = null;
            }
            if (recyclerView != null) {
                recyclerView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                    public final boolean onPreDraw() {
                        AppMethodBeat.i(38642);
                        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPreDraw %d, %d", Integer.valueOf(SnsAdNativeLandingPagesUI.this.roo.getHeight()), Integer.valueOf(SnsAdNativeLandingPagesUI.this.iev));
                        if (SnsAdNativeLandingPagesUI.this.rnS) {
                            al.n(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(38641);
                                    Bitmap eA = d.eA(SnsAdNativeLandingPagesUI.this.roq);
                                    if (eA != null) {
                                        SnsAdNativeLandingPagesUI.this.roq.setVisibility(4);
                                        SnsAdNativeLandingPagesUI.this.roo.setAlpha(1.0f);
                                        SnsAdNativeLandingPagesUI.this.rnP.setImageBitmap(eA);
                                        SnsAdNativeLandingPagesUI.g(SnsAdNativeLandingPagesUI.this);
                                        AppMethodBeat.o(38641);
                                        return;
                                    }
                                    SnsAdNativeLandingPagesUI.this.roo.setAlpha(1.0f);
                                    AppMethodBeat.o(38641);
                                }
                            }, 50);
                        } else {
                            SnsAdNativeLandingPagesUI.this.rop.setVisibility(0);
                        }
                        recyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
                        AppMethodBeat.o(38642);
                        return false;
                    }
                });
            }
            AppMethodBeat.o(38643);
        }
    };
    private OnPageChangeListener roE = new f() {
        public final void onPageScrolled(int i, float f, int i2) {
            AppMethodBeat.i(38644);
            super.onPageScrolled(i, f, i2);
            if (SnsAdNativeLandingPagesUI.i(SnsAdNativeLandingPagesUI.this) != null) {
                ContentFragment i3 = SnsAdNativeLandingPagesUI.i(SnsAdNativeLandingPagesUI.this);
                if (i3.caA && i3.rdb != null) {
                    i3.rdb.cpX();
                }
            }
            if (SnsAdNativeLandingPagesUI.this.mController.ymc == 1) {
                SnsAdNativeLandingPagesUI.this.aqX();
            }
            AppMethodBeat.o(38644);
        }

        public final void onPageScrollStateChanged(int i) {
            AppMethodBeat.i(38645);
            super.onPageScrollStateChanged(i);
            SnsAdNativeLandingPagesUI.i(SnsAdNativeLandingPagesUI.this).rdl = i;
            Fragment fragment;
            if (i == 1) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < SnsAdNativeLandingPagesUI.this.rnM.size()) {
                        fragment = (Fragment) SnsAdNativeLandingPagesUI.this.roI.get(Integer.valueOf(((g) SnsAdNativeLandingPagesUI.this.rnM.get(i3)).id));
                        if (fragment != null) {
                            ((ContentFragment) fragment).cqe();
                        }
                        i2 = i3 + 1;
                    } else {
                        ad.eQ(SnsAdNativeLandingPagesUI.this.mController.ylL);
                        AppMethodBeat.o(38645);
                        return;
                    }
                }
            }
            if (i == 0) {
                fragment = (Fragment) SnsAdNativeLandingPagesUI.this.roI.get(Integer.valueOf(((g) SnsAdNativeLandingPagesUI.this.rnM.get(SnsAdNativeLandingPagesUI.this.rok.getCurrentItem())).id));
                if (fragment != null) {
                    ((ContentFragment) fragment).cqd();
                }
            }
            AppMethodBeat.o(38645);
        }

        public final void onPageSelected(int i) {
            AppMethodBeat.i(38646);
            super.onPageSelected(i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < SnsAdNativeLandingPagesUI.this.rnM.size()) {
                    Fragment fragment = (Fragment) SnsAdNativeLandingPagesUI.this.roI.get(Integer.valueOf(((g) SnsAdNativeLandingPagesUI.this.rnM.get(i3)).id));
                    if (fragment != null) {
                        if (i3 == i) {
                            ((ContentFragment) fragment).cqd();
                        } else {
                            ((ContentFragment) fragment).cqe();
                        }
                    }
                    i2 = i3 + 1;
                } else {
                    AppMethodBeat.o(38646);
                    return;
                }
            }
        }
    };
    private e roF = new e() {
        public final void ao(final Object obj) {
            AppMethodBeat.i(38649);
            SnsAdNativeLandingPagesUI.this.ron.removeCallbacksAndMessages(null);
            SnsAdNativeLandingPagesUI.this.ron.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38648);
                    SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = SnsAdNativeLandingPagesUI.this;
                    String l = SnsAdNativeLandingPagesUI.this.rnT;
                    String m = SnsAdNativeLandingPagesUI.this.rnU;
                    String str = (String) obj;
                    SnsAdNativeLandingPagesUI.this.qTL;
                    SnsAdNativeLandingPagesUI.this.hcx;
                    snsAdNativeLandingPagesUI.rnM = i.ai(l, m, str);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(38647);
                            SnsAdNativeLandingPagesUI.p(SnsAdNativeLandingPagesUI.this);
                            AppMethodBeat.o(38647);
                        }
                    });
                    AppMethodBeat.o(38648);
                }
            });
            AppMethodBeat.o(38649);
        }

        public final void f(int i, int i2, Object obj) {
        }
    };
    private c<ma> roG = new c<ma>() {
        {
            AppMethodBeat.i(38650);
            this.xxI = ma.class.getName().hashCode();
            AppMethodBeat.o(38650);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38651);
            ma maVar = (ma) bVar;
            if (!(SnsAdNativeLandingPagesUI.i(SnsAdNativeLandingPagesUI.this).rcX.rek == null || !SnsAdNativeLandingPagesUI.i(SnsAdNativeLandingPagesUI.this).rcX.rek.containsKey(maVar.cHQ.cHR) || SnsAdNativeLandingPagesUI.this.roA.containsKey(maVar.cHQ.cHR))) {
                SnsAdNativeLandingPagesUI.i(SnsAdNativeLandingPagesUI.this).onPause();
                Bundle bundle = new Bundle();
                bundle.putString("sns_landing_pages_xml", SnsAdNativeLandingPagesUI.this.rnT);
                bundle.putString("sns_float_component_id", maVar.cHQ.cHR);
                bundle.putInt("sns_landing_page_index", SnsAdNativeLandingPagesUI.i(SnsAdNativeLandingPagesUI.this).rcX.id);
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
                if (bo.Q(snsAdLandingPageFloatView.rnT, snsAdLandingPageFloatView.cHR) || snsAdLandingPageFloatView.rMA == -1) {
                    ab.e("MicroMsg.SnsAdLandingPageFloatView", "invalid landing float page data!");
                } else {
                    snsAdLandingPageFloatView.rMB = bo.bc(bundle.getString("sns_landing_pages_xml_prefix"), "adxml");
                    snsAdLandingPageFloatView.rnM = i.gn(snsAdLandingPageFloatView.rnT, snsAdLandingPageFloatView.rMB);
                    if (snsAdLandingPageFloatView.rnM != null && snsAdLandingPageFloatView.rnM.size() > snsAdLandingPageFloatView.rMA) {
                        g gVar = (g) snsAdLandingPageFloatView.rnM.get(snsAdLandingPageFloatView.rMA);
                        snsAdLandingPageFloatView.rME = new g();
                        snsAdLandingPageFloatView.rME.hfo = gVar.hfo;
                        r rVar = (r) gVar.rek.get(snsAdLandingPageFloatView.cHR);
                        if (i.DD(rVar.type)) {
                            snsAdLandingPageFloatView.rMD = (p) rVar;
                            snsAdLandingPageFloatView.rME.rej.add(snsAdLandingPageFloatView.rMD);
                            snsAdLandingPageFloatView.rME.rek.putAll(gVar.rek);
                        }
                        snsAdLandingPageFloatView.rME.id = 0;
                        snsAdLandingPageFloatView.rME.rel = true;
                    }
                    ab.i("MicroMsg.SnsAdLandingPageFloatView", "[reportInfo] aid %s,traceId %s,uxInfo %s,adCanvasExtXml %s", snsAdLandingPageFloatView.rMC, snsAdLandingPageFloatView.hcx, snsAdLandingPageFloatView.qPj, snsAdLandingPageFloatView.qTM);
                    if (snsAdLandingPageFloatView.rME != null) {
                        if (snsAdLandingPageFloatView.rMD != null) {
                            snsAdLandingPageFloatView.rMF = al.a(snsAdLandingPageFloatView.getContext(), snsAdLandingPageFloatView.rMD, snsAdLandingPageFloatView, Color.parseColor(snsAdLandingPageFloatView.rME.hfo));
                            snsAdLandingPageFloatView.rMF.setBackgroundColor(Color.parseColor(snsAdLandingPageFloatView.rME.hfo));
                            snsAdLandingPageFloatView.rMG = snsAdLandingPageFloatView.rMF.getView();
                            snsAdLandingPageFloatView.addView(snsAdLandingPageFloatView.rMG);
                            snsAdLandingPageFloatView.rMF.cpz();
                            snsAdLandingPageFloatView.setOnTouchListener(new OnTouchListener() {
                                public final boolean onTouch(View view, MotionEvent motionEvent) {
                                    AppMethodBeat.i(40445);
                                    ab.i("MicroMsg.SnsAdLandingPageFloatView", "view area %s, (%f,%f)", new Rect(SnsAdLandingPageFloatView.this.rMF.getView().getLeft(), SnsAdLandingPageFloatView.this.rMF.getView().getTop(), SnsAdLandingPageFloatView.this.rMF.getView().getRight(), SnsAdLandingPageFloatView.this.rMF.getView().getBottom()), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
                                    if (new Rect(SnsAdLandingPageFloatView.this.rMF.getView().getLeft(), SnsAdLandingPageFloatView.this.rMF.getView().getTop(), SnsAdLandingPageFloatView.this.rMF.getView().getRight(), SnsAdLandingPageFloatView.this.rMF.getView().getBottom()).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                                        AppMethodBeat.o(40445);
                                        return false;
                                    }
                                    if (motionEvent.getActionMasked() == 1) {
                                        SnsAdLandingPageFloatView snsAdLandingPageFloatView = SnsAdLandingPageFloatView.this;
                                        if (!snsAdLandingPageFloatView.rEC) {
                                            snsAdLandingPageFloatView.nVR.start();
                                            snsAdLandingPageFloatView.rEC = true;
                                        }
                                    }
                                    AppMethodBeat.o(40445);
                                    return true;
                                }
                            });
                        }
                        snsAdLandingPageFloatView.cvw();
                        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.4f, 0.96f}).setDuration(200);
                        duration.setInterpolator(new OvershootInterpolator());
                        ValueAnimator duration2 = ValueAnimator.ofFloat(new float[]{0.96f, 1.0f}).setDuration(100);
                        duration.addUpdateListener(new AnimatorUpdateListener() {
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AppMethodBeat.i(40438);
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                SnsAdLandingPageFloatView.this.rMG.setScaleX(floatValue);
                                SnsAdLandingPageFloatView.this.rMG.setScaleY(floatValue);
                                AppMethodBeat.o(40438);
                            }
                        });
                        duration2.addUpdateListener(new AnimatorUpdateListener() {
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AppMethodBeat.i(40439);
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                SnsAdLandingPageFloatView.this.rMG.setScaleX(floatValue);
                                SnsAdLandingPageFloatView.this.rMG.setScaleY(floatValue);
                                AppMethodBeat.o(40439);
                            }
                        });
                        snsAdLandingPageFloatView.rMH.playSequentially(new Animator[]{duration, duration2});
                        snsAdLandingPageFloatView.rMH.addListener(new AnimatorListenerAdapter() {
                            public final void onAnimationStart(Animator animator) {
                                AppMethodBeat.i(40440);
                                SnsAdLandingPageFloatView.this.rEC = true;
                                SnsAdLandingPageFloatView.this.onResume();
                                qv qvVar = new qv();
                                qvVar.cNa.cNb = SnsAdLandingPageFloatView.this.cHR;
                                qvVar.cNa.state = 120;
                                a.xxA.m(qvVar);
                                AppMethodBeat.o(40440);
                            }

                            public final void onAnimationEnd(Animator animator) {
                                AppMethodBeat.i(40441);
                                SnsAdLandingPageFloatView.this.rEC = false;
                                qv qvVar = new qv();
                                qvVar.cNa.cNb = SnsAdLandingPageFloatView.this.cHR;
                                qvVar.cNa.state = 121;
                                a.xxA.m(qvVar);
                                AppMethodBeat.o(40441);
                            }
                        });
                        snsAdLandingPageFloatView.nVR.addUpdateListener(new AnimatorUpdateListener() {
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AppMethodBeat.i(40442);
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                SnsAdLandingPageFloatView.this.rMG.setScaleX(floatValue);
                                SnsAdLandingPageFloatView.this.rMG.setScaleY(floatValue);
                                AppMethodBeat.o(40442);
                            }
                        });
                        snsAdLandingPageFloatView.nVR.addListener(new AnimatorListenerAdapter() {
                            public final void onAnimationStart(Animator animator) {
                                AppMethodBeat.i(40443);
                                SnsAdLandingPageFloatView.this.rEC = true;
                                SnsAdLandingPageFloatView.this.isResume = false;
                                SnsAdLandingPageFloatView.this.onPause();
                                qv qvVar = new qv();
                                qvVar.cNa.cNb = SnsAdLandingPageFloatView.this.cHR;
                                qvVar.cNa.state = 122;
                                a.xxA.m(qvVar);
                                AppMethodBeat.o(40443);
                            }

                            public final void onAnimationEnd(Animator animator) {
                                AppMethodBeat.i(40444);
                                SnsAdLandingPageFloatView.this.rMG.setVisibility(8);
                                SnsAdLandingPageFloatView.this.rEC = false;
                                qv qvVar = new qv();
                                qvVar.cNa.cNb = SnsAdLandingPageFloatView.this.cHR;
                                qvVar.cNa.state = 123;
                                a.xxA.m(qvVar);
                                AppMethodBeat.o(40444);
                            }
                        });
                    }
                }
                snsAdLandingPageFloatView.setBackgroundColor(SnsAdNativeLandingPagesUI.this.getResources().getColor(R.color.a07));
                SnsAdNativeLandingPagesUI.this.roo.addView(snsAdLandingPageFloatView, SnsAdNativeLandingPagesUI.this.roo.getChildCount() - 1, new LayoutParams(-1, -1));
                if (!snsAdLandingPageFloatView.rEC) {
                    snsAdLandingPageFloatView.rMH.start();
                    snsAdLandingPageFloatView.rEC = true;
                }
                SnsAdNativeLandingPagesUI.i(SnsAdNativeLandingPagesUI.this).cqe();
                SnsAdNativeLandingPagesUI.this.roA.put(maVar.cHQ.cHR, snsAdLandingPageFloatView);
            }
            AppMethodBeat.o(38651);
            return false;
        }
    };
    private c<qv> roH = new c<qv>() {
        {
            AppMethodBeat.i(38652);
            this.xxI = qv.class.getName().hashCode();
            AppMethodBeat.o(38652);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38653);
            qv qvVar = (qv) bVar;
            String str = qvVar.cNa.cNb;
            switch (qvVar.cNa.state) {
                case 123:
                    if (!bo.isNullOrNil(str) && SnsAdNativeLandingPagesUI.this.roA.containsKey(str)) {
                        SnsAdNativeLandingPagesUI.this.roo.removeView((View) SnsAdNativeLandingPagesUI.this.roA.get(str));
                        SnsAdNativeLandingPagesUI.this.onResume();
                        SnsAdNativeLandingPagesUI.i(SnsAdNativeLandingPagesUI.this).onResume();
                        break;
                    }
            }
            AppMethodBeat.o(38653);
            return false;
        }
    };
    private Map<Integer, ContentFragment> roI = new HashMap();
    private BroadcastReceiver roJ = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(38635);
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                ab.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_OFF");
                AppMethodBeat.o(38635);
                return;
            }
            if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                ab.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_ON");
                ad.ac(SnsAdNativeLandingPagesUI.this);
            }
            AppMethodBeat.o(38635);
        }
    };
    private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i roK = null;
    private com.tencent.mm.ui.base.p roL = null;
    String roa;
    public boolean rob = false;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k roc = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k();
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
    private ak ron = new ak();
    private FrameLayout roo;
    private View rop;
    private View roq;
    private boolean ror = true;
    private n ros;
    private List<h> rot;
    private com.tencent.mm.plugin.sns.ui.b.b rou;
    private com.tencent.mm.plugin.sns.ui.b.c rov;
    private volatile boolean rox;
    private boolean roy;
    public v roz;
    private long startTime;
    public String uin;
    private Map<String, String> values;

    class a {
        public String lvA;
        public String qVw;
        public String qVx;

        private a() {
            this.lvA = "";
            this.qVw = "";
            this.qVx = "";
        }

        /* synthetic */ a(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsAdNativeLandingPagesUI() {
        AppMethodBeat.i(38656);
        AppMethodBeat.o(38656);
    }

    static /* synthetic */ boolean A(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(38693);
        boolean csH = snsAdNativeLandingPagesUI.csH();
        AppMethodBeat.o(38693);
        return csH;
    }

    static /* synthetic */ boolean B(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(38694);
        boolean csG = snsAdNativeLandingPagesUI.csG();
        AppMethodBeat.o(38694);
        return csG;
    }

    static /* synthetic */ ContentFragment i(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(38690);
        ContentFragment csI = snsAdNativeLandingPagesUI.csI();
        AppMethodBeat.o(38690);
        return csI;
    }

    static /* synthetic */ void p(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(38691);
        snsAdNativeLandingPagesUI.csC();
        AppMethodBeat.o(38691);
    }

    static /* synthetic */ void w(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(38692);
        snsAdNativeLandingPagesUI.csw();
        AppMethodBeat.o(38692);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38657);
        super.onCreate(bundle);
        this.startTime = System.currentTimeMillis();
        this.edh = System.currentTimeMillis();
        this.roc.edh = this.edh;
        ad.ac(this);
        int[] eP = ad.eP(this);
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
        if (bo.isNullOrNil(this.rnT) && !bo.isNullOrNil(stringExtra)) {
            this.rnT = ad.YM(stringExtra);
        }
        if (bo.isNullOrNil(this.rnT)) {
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
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k kVar = this.roc;
            if (!TextUtils.isEmpty(stringExtra)) {
                if (kVar.extra.length() > 0) {
                    kVar.extra += "&";
                }
                kVar.extra += "searchextra=" + URLEncoder.encode(stringExtra);
            }
            stringExtra = getIntent().getStringExtra("sns_landing_pages_extra");
            kVar = this.roc;
            if (!TextUtils.isEmpty(stringExtra)) {
                kVar.extra += "&extra1=" + URLEncoder.encode(stringExtra);
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
            if (bo.isNullOrNil(this.rnT) || bo.isNullOrNil(this.rnU)) {
                ab.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.rnT + ",landingPagesXmlPrex is " + this.rnU);
            } else {
                this.values = br.z(this.rnT, this.rnU);
                this.roc.hxZ = bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.canvasId"), "");
            }
        }
        initView();
        if (AdLandingPagesProxy.getInstance().isConnected()) {
            csw();
        } else {
            AdLandingPagesProxy.getInstance().connect(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38654);
                    SnsAdNativeLandingPagesUI.w(SnsAdNativeLandingPagesUI.this);
                    AppMethodBeat.o(38654);
                }
            });
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.roH);
        AppMethodBeat.o(38657);
    }

    private void csw() {
        AppMethodBeat.i(38658);
        AdlandingRemoteServiceConnectedReceiver.b(android.support.v4.content.d.S(this));
        Kh();
        if (this.rnS) {
            csB();
        } else {
            csC();
        }
        refreshView();
        csy();
        lg(true);
        this.aGz = true;
        AppMethodBeat.o(38658);
    }

    private void refreshView() {
        AppMethodBeat.i(38659);
        if (this.qXr == 2 && !csF()) {
            LayoutParams layoutParams = (LayoutParams) this.rok.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, com.tencent.mm.ui.ak.fr(this));
            this.rok.setLayoutParams(layoutParams);
        }
        int i = R.color.a69;
        if (!csF()) {
            int color = getResources().getColor(R.color.h4);
            if (this.rnM == null || this.rnM.size() <= 0 || bo.isNullOrNil(((g) this.rnM.getFirst()).hfo)) {
                i = color;
            } else {
                i = Color.parseColor(((g) this.rnM.getFirst()).hfo);
            }
            this.rop.setBackgroundColor(i);
            i = R.color.h4;
        }
        Drawable drawable = this.rnN.getDrawable();
        if (drawable != null) {
            android.support.v4.a.a.a.a(drawable, android.support.v4.content.b.i(this, i));
            this.rnN.setImageDrawable(drawable);
        }
        drawable = this.rnO.getDrawable();
        if (drawable != null) {
            android.support.v4.a.a.a.a(drawable, android.support.v4.content.b.i(this, i));
            this.rnO.setImageDrawable(drawable);
        }
        if (csG() && !csH() && this.qXr == 2) {
            this.rnO.setVisibility(8);
            this.rnQ.setVisibility(0);
            this.rnQ.setText(this.rnV);
            this.rnQ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(38655);
                    SnsAdNativeLandingPagesUI.this.w(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.this.rnW, SnsAdNativeLandingPagesUI.this.rnX);
                    AppMethodBeat.o(38655);
                }
            });
            AppMethodBeat.o(38659);
        } else if (csD()) {
            this.rnO.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(38624);
                    com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(SnsAdNativeLandingPagesUI.this, 1, false);
                    dVar.rBl = new com.tencent.mm.ui.base.n.c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(38622);
                            if (SnsAdNativeLandingPagesUI.this.rol == 0 || (SnsAdNativeLandingPagesUI.this.rol & 2) == 0) {
                                lVar.a(1, SnsAdNativeLandingPagesUI.this.getString(R.string.dr8), (int) R.raw.bottomsheet_icon_transmit);
                            }
                            if (SnsAdNativeLandingPagesUI.this.rol == 0 || (SnsAdNativeLandingPagesUI.this.rol & 1) == 0) {
                                lVar.a(2, SnsAdNativeLandingPagesUI.this.getString(R.string.ejg), (int) R.raw.bottomsheet_icon_moment);
                            }
                            if ((SnsAdNativeLandingPagesUI.this.rol == 0 || (SnsAdNativeLandingPagesUI.this.rol & 4) == 0) && SnsAdNativeLandingPagesUI.this.cvd != 7) {
                                lVar.a(3, SnsAdNativeLandingPagesUI.this.getString(R.string.akj), (int) R.raw.bottomsheet_icon_fav);
                            }
                            if ((SnsAdNativeLandingPagesUI.this.rol == 0 || SnsAdNativeLandingPagesUI.A(SnsAdNativeLandingPagesUI.this)) && SnsAdNativeLandingPagesUI.this.qXr == 2 && SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this)) {
                                lVar.a(4, SnsAdNativeLandingPagesUI.this.rnV != null ? SnsAdNativeLandingPagesUI.this.rnV : "", 0);
                            }
                            AppMethodBeat.o(38622);
                        }
                    };
                    dVar.uEP = true;
                    dVar.rBm = new com.tencent.mm.ui.base.n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(38623);
                            ad.ac(SnsAdNativeLandingPagesUI.this);
                            if (menuItem != null) {
                                switch (menuItem.getItemId()) {
                                    case 1:
                                        SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this);
                                        AppMethodBeat.o(38623);
                                        return;
                                    case 2:
                                        SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this);
                                        AppMethodBeat.o(38623);
                                        return;
                                    case 3:
                                        SnsAdNativeLandingPagesUI.F(SnsAdNativeLandingPagesUI.this);
                                        AppMethodBeat.o(38623);
                                        return;
                                    case 4:
                                        SnsAdNativeLandingPagesUI.this.w(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.this.rnW, SnsAdNativeLandingPagesUI.this.rnX);
                                        break;
                                }
                            }
                            AppMethodBeat.o(38623);
                        }
                    };
                    SnsAdNativeLandingPagesUI.this.aqX();
                    dVar.cpD();
                    AppMethodBeat.o(38624);
                }
            });
            AppMethodBeat.o(38659);
        } else {
            this.rnO.setVisibility(8);
            AppMethodBeat.o(38659);
        }
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.i(38660);
        getWindow().clearFlags(128);
        if (this.aGz) {
            ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy");
            if (!this.rod) {
                csx();
                IF();
            }
        }
        this.roA.clear();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b) this.rok.getAdapter()).rdA.clear();
        unregisterReceiver(this.roJ);
        com.tencent.mm.sdk.b.a.xxA.d(this.roH);
        AdLandingPagesProxy.getInstance().clearCallback();
        super.onDestroy();
        AppMethodBeat.o(38660);
    }

    private void csx() {
        AppMethodBeat.i(38661);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b) this.rok.getAdapter();
        if (bVar == null) {
            AppMethodBeat.o(38661);
            return;
        }
        for (Fragment fragment : bVar.rdA) {
            ((ContentFragment) fragment).cpn();
        }
        AppMethodBeat.o(38661);
    }

    private void IF() {
        AppMethodBeat.i(38662);
        List allComp = getAllComp();
        for (SnsAdLandingPageFloatView allComp2 : this.roA.values()) {
            allComp.addAll(allComp2.getAllComp());
        }
        this.iBA += System.currentTimeMillis() - this.startTime;
        this.roc.reH = (int) this.iBA;
        this.roc.reG = allComp.size();
        this.roc.dk(allComp);
        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "landingPage report json %s", this.roc.reK);
        String cqm = this.roc.cqm();
        if (this.qXr == 2) {
            AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, cqm);
            ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: ".concat(String.valueOf(cqm)));
            AppMethodBeat.o(38662);
        } else if (AdLandingPagesProxy.getInstance().isRecExpAd(this.roc.cFc)) {
            com.tencent.mm.plugin.report.service.h.pYm.X(14650, cqm);
            ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: ".concat(String.valueOf(cqm)));
            AppMethodBeat.o(38662);
        } else {
            com.tencent.mm.plugin.report.service.h.pYm.X(13387, cqm);
            ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: ".concat(String.valueOf(cqm)));
            AppMethodBeat.o(38662);
        }
    }

    private void csy() {
        AppMethodBeat.i(38663);
        if (this.qUA != 2) {
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
            Object[] objArr = new Object[7];
            objArr[0] = com.tencent.mm.plugin.sns.data.i.jV(com.tencent.mm.plugin.sns.data.i.Xq(this.roc.cFc));
            objArr[1] = this.qPj == null ? "" : this.qPj;
            objArr[2] = Integer.valueOf(this.roc.reB);
            objArr[3] = Integer.valueOf(this.roc.lgf);
            objArr[4] = Long.valueOf(this.edh);
            objArr[5] = Integer.valueOf(this.qXp);
            objArr[6] = this.roc.hxZ;
            hVar.e(14655, objArr);
        }
        AppMethodBeat.o(38663);
    }

    private boolean csz() {
        AppMethodBeat.i(38664);
        if (this.roo.getChildAt(this.roo.getChildCount() - 2) instanceof SnsAdLandingPageFloatView) {
            AppMethodBeat.o(38664);
            return true;
        }
        AppMethodBeat.o(38664);
        return false;
    }

    public void onResume() {
        AppMethodBeat.i(38665);
        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
        super.onResume();
        ad.ac(this);
        if (csz()) {
            ((SnsAdLandingPageFloatView) this.roo.getChildAt(this.roo.getChildCount() - 2)).onResume();
            AppMethodBeat.o(38665);
            return;
        }
        this.roy = false;
        AdlandingDummyViewPager adlandingDummyViewPager = this.rok;
        adlandingDummyViewPager.rcR.add(this.roE);
        android.support.v4.content.d.S(this).a(this.roB, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
        android.support.v4.content.d.S(this).a(this.roC, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
        if (this.aGz) {
            this.startTime = System.currentTimeMillis();
        }
        registerReceiver(this.roJ, new IntentFilter("android.intent.action.SCREEN_ON"));
        com.tencent.mm.sdk.b.a.xxA.c(this.roG);
        if (this.rof) {
            lg(false);
        }
        AppMethodBeat.o(38665);
    }

    public void onPause() {
        AppMethodBeat.i(38666);
        super.onPause();
        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPause");
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
        android.support.v4.content.d.S(this).unregisterReceiver(this.roB);
        android.support.v4.content.d.S(this).unregisterReceiver(this.roC);
        com.tencent.mm.sdk.b.a.xxA.d(this.roG);
        if (this.roK != null) {
            this.roK.cpE();
        }
        AppMethodBeat.o(38666);
    }

    public void onSwipeBack() {
        AppMethodBeat.i(38667);
        this.roc.ecH = 2;
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k kVar = this.roc;
        kVar.reF++;
        super.onSwipeBack();
        AppMethodBeat.o(38667);
    }

    private void Kh() {
        AppMethodBeat.i(38668);
        this.ros = AdLandingPagesProxy.getInstance().getSnsInfo(this.cFc);
        AdLandingPagesProxy.getInstance().asyncCacheXml(this.cFc);
        if (this.values == null) {
            ab.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + this.rnT);
            AppMethodBeat.o(38668);
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
            if (!bo.isNullOrNil(this.qTM)) {
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
            this.qUe = bo.ank((String) this.values.get("." + this.rnU + ".originAdType"));
            this.qTL = (String) this.values.get("." + this.rnU + ".originAid");
            this.hcx = (String) this.values.get("." + this.rnU + ".originTraceId");
            if (!bo.isNullOrNil(this.hya)) {
                Map z = br.z(this.hya, "ADInfo");
                this.qPj = bo.bc((String) z.get(".ADInfo.uxInfo"), "");
                this.roc.qPj = this.qPj;
                this.qTL = bo.bc((String) z.get(".ADInfo.session_data.aid"), "");
                this.hcx = bo.bc((String) z.get(".ADInfo.session_data.trace_id"), "");
            }
            Matcher matcher = Pattern.compile("<originAdCanvasExt>[\\s\\S]*</originAdCanvasExt>").matcher(this.rnT);
            if (matcher.find()) {
                group = matcher.group();
                if (!bo.isNullOrNil(group)) {
                    this.qTM = group.replaceAll("</?originAdCanvasExt>", "");
                }
            }
        }
        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportInfo aid [%s],traceId [%s],adType [%s],uxInfo [%s],adCanvasExtXml [%s]", this.qTL, this.hcx, Integer.valueOf(this.qUe), this.qPj, this.qTM);
        if (!bo.isNullOrNil(this.qTM)) {
            str = ".adCardItemList.cardItem";
            Map z2 = br.z(this.qTM, "adCardItemList");
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
                    String bc = bo.bc((String) z2.get(str2 + ".cardTpId"), "");
                    group = bo.bc((String) z2.get(str2 + ".cardExt"), "");
                    if (!(bo.isNullOrNil(bc) || bo.isNullOrNil(group))) {
                        this.qXs.put(bc, group);
                    }
                    i++;
                }
            }
        }
        this.roc.reJ = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(bo.anl(this.roc.cFc));
        this.lvA = bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.shareTitle"), "");
        this.lvz = bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.shareWebUrl"), "");
        this.qVw = bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.shareDesc"), "");
        this.qXr = bo.ank(bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.bizId"), ""));
        this.rog = bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.shareAppId"), "");
        this.roh = bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.shareType"), "");
        this.roi = bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.userInfo"), "");
        this.rol = bo.ank(bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.disableShareBitSet"), ""));
        this.rom = bo.ank(bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.statusBarStyle"), ""));
        s(this.values, "." + this.rnU);
        this.uin = AdLandingPagesProxy.getInstance().getUin();
        this.roj = bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.officialSyncBuffer"), "");
        getIntent().putExtra("sns_landing_pages_adType", this.qUe);
        getIntent().putExtra("sns_landing_pages_rawSnsId", this.roc.cFc);
        if (bo.isNullOrNil(this.qTL)) {
            this.qTL = bo.bc((String) this.values.get("." + this.rnU + ".originAid"), "");
        }
        if (bo.isNullOrNil(this.hcx)) {
            this.hcx = bo.bc((String) this.values.get("." + this.rnU + ".originTraceId"), "");
        }
        this.rnM = i.gn(this.rnT, this.rnU);
        if (this.rnM.size() > 0) {
            str2 = "";
            g gVar = (g) this.rnM.get(0);
            if (gVar.rej.size() > 0) {
                r rVar = (r) gVar.rej.get(0);
                if (rVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n) {
                    this.rnZ = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n) rVar).qWD;
                } else if (rVar instanceof m) {
                    this.rnZ = ((m) rVar).qWD;
                } else if (rVar instanceof o) {
                    this.rnZ = ((o) rVar).qWG;
                    str2 = ((o) rVar).qWF;
                } else if (rVar instanceof x) {
                    x xVar = (x) rVar;
                    if (!xVar.qWB.isEmpty()) {
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l lVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) xVar.qWB.getFirst();
                        if (!lVar.qWB.isEmpty()) {
                            rVar = (r) lVar.qWB.getFirst();
                            if (rVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n) {
                                this.rnZ = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n) rVar).qWD;
                            }
                        }
                    }
                }
            }
            if (this.ros != null) {
                TimeLineObject cqu = this.ros.cqu();
                if (!(cqu == null || cqu.xfI == null || cqu.xfI.wbK == null || cqu.xfI.wbK.isEmpty())) {
                    bau bau = (bau) cqu.xfI.wbK.getFirst();
                    str = an.fZ(AdLandingPagesProxy.getInstance().getAccSnsPath(), bau.Id) + com.tencent.mm.plugin.sns.data.i.j(bau);
                    group = bau.Url;
                    if (str2.equals(group)) {
                        group = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.gk("adId", group);
                        if (!com.tencent.mm.vfs.e.ct(group) && com.tencent.mm.vfs.e.ct(str)) {
                            ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "copy outsideFiel:%s->%s", str, group);
                            com.tencent.mm.vfs.e.y(str, group);
                        }
                    }
                }
            }
        }
        this.rnV = bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.rightBarTitle"), "");
        this.rnW = bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.rightBarCanvasId"), "");
        this.rnX = bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.rightBarCanvasExt"), "");
        AppMethodBeat.o(38668);
    }

    private void s(Map<String, String> map, String str) {
        AppMethodBeat.i(38669);
        String str2 = (String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
        if (TextUtils.isEmpty(str2)) {
            this.rdd = null;
            AppMethodBeat.o(38669);
            return;
        }
        int i;
        if (this.rdd == null) {
            this.rdd = new ac();
        }
        this.rdd.iconUrl = str2;
        int ank = bo.ank((String) map.get(str + ".adCanvasInfo.sizeType"));
        int ank2 = bo.ank((String) map.get(str + ".adCanvasInfo.basicRootFontSize"));
        int ank3 = bo.ank((String) map.get(str + ".adCanvasInfo.basicWidth"));
        if (ank2 == 0 && ank == 1) {
            i = i.ren;
        } else {
            i = ank2;
        }
        if (ank3 == 0 && ank == 1) {
            ank2 = i.rem;
        } else {
            ank2 = ank3;
        }
        this.rdd.qWR = i.a(bo.anm((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), ank, ank2, i);
        this.rdd.width = i.a(bo.anm((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), ank, ank2, i);
        this.rdd.height = i.a(bo.anm((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), ank, ank2, i);
        AppMethodBeat.o(38669);
    }

    private List<g> csA() {
        AppMethodBeat.i(38670);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.rnM.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (gVar.rel) {
                arrayList.add(gVar);
            }
        }
        AppMethodBeat.o(38670);
        return arrayList;
    }

    private void csB() {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar;
        AppMethodBeat.i(38671);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b) this.rok.getAdapter();
        if (bVar2 == null) {
            bVar2 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
            this.rok.setAdapter(bVar2);
            bVar = bVar2;
        } else {
            bVar = bVar2;
        }
        List csA = csA();
        if (csA.size() > 0) {
            g gVar = (g) csA.get(0);
            ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load id %s", Integer.valueOf(gVar.id));
            Fragment fragment = (ContentFragment) this.roI.get(Integer.valueOf(gVar.id));
            if (fragment == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("pageInfo", gVar);
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
                this.roI.put(Integer.valueOf(gVar.id), fragment);
            } else {
                fragment.a(gVar);
            }
            if (fragment != null) {
                bVar.a(fragment, 0);
            }
            bVar.notifyDataSetChanged();
            this.rok.setOffscreenPageLimit(csA.size());
        }
        AppMethodBeat.o(38671);
    }

    private void csC() {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar;
        AppMethodBeat.i(38672);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b) this.rok.getAdapter();
        if (bVar2 == null) {
            bVar2 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
            this.rok.setAdapter(bVar2);
            bVar = bVar2;
        } else {
            bVar = bVar2;
        }
        List csA = csA();
        for (int i = 0; i < csA.size(); i++) {
            g gVar = (g) this.rnM.get(i);
            ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load id %s", Integer.valueOf(gVar.id));
            Fragment fragment = (ContentFragment) this.roI.get(Integer.valueOf(gVar.id));
            if (fragment == null) {
                boolean z;
                int i2;
                HashMap hashMap = new HashMap();
                hashMap.put("pageInfo", gVar);
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
                this.roI.put(Integer.valueOf(gVar.id), fragment);
            } else {
                fragment.a(gVar);
            }
            if (fragment != null) {
                bVar.a(fragment, i);
            }
        }
        bVar.notifyDataSetChanged();
        this.rok.setOffscreenPageLimit(csA.size());
        AppMethodBeat.o(38672);
    }

    private List<h> getAllComp() {
        AppMethodBeat.i(38673);
        this.rot = new ArrayList();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b) this.rok.getAdapter();
        if (bVar != null) {
            for (Fragment fragment : bVar.rdA) {
                this.rot.addAll(((ContentFragment) fragment).cqa());
            }
        }
        i.dj(this.rot);
        List list = this.rot;
        AppMethodBeat.o(38673);
        return list;
    }

    @TargetApi(16)
    public final void initView() {
        AppMethodBeat.i(38674);
        super.initView();
        this.roo = (FrameLayout) findViewById(R.id.l_);
        this.roq = findViewById(R.id.ef7);
        this.rok = (AdlandingDummyViewPager) findViewById(R.id.eg_);
        this.rop = findViewById(R.id.ef8);
        if (ae.hD(this.mController.ylL)) {
            LayoutParams layoutParams = (LayoutParams) this.roo.getLayoutParams();
            layoutParams.height = this.iev - ae.hC(this);
            layoutParams.topMargin = ae.hC(this);
            this.roo.setLayoutParams(layoutParams);
            this.mController.xE(getResources().getColor(R.color.dt));
            com.tencent.mm.ui.b.a(this, true, this.roo);
        } else {
            com.tencent.mm.ui.b.a(this, false, this.roo);
        }
        this.mmX = (ImageView) findViewById(R.id.adg);
        this.rnP = (ImageView) findViewById(R.id.eg9);
        this.rnN = (ImageView) findViewById(R.id.ef9);
        this.rnN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38625);
                if (SnsAdNativeLandingPagesUI.this.mController.ymc == 1) {
                    SnsAdNativeLandingPagesUI.this.aqX();
                }
                SnsAdNativeLandingPagesUI.this.bcW();
                AppMethodBeat.o(38625);
            }
        });
        this.rnO = (ImageView) findViewById(R.id.ef_);
        this.rnQ = (TextView) findViewById(R.id.egb);
        this.rnY = (ImageView) findViewById(R.id.ega);
        if (this.rnS) {
            this.roo.setAlpha(0.0f);
            this.mmX.setAlpha(0.0f);
            com.tencent.mm.ui.base.b.a(this, null);
        }
        AppMethodBeat.o(38674);
    }

    public boolean convertActivityFromTranslucent() {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.auj;
    }

    private boolean csD() {
        AppMethodBeat.i(38675);
        if (this.rol == 0) {
            AppMethodBeat.o(38675);
            return true;
        } else if ((this.rol & 4) == 0 || (this.rol & 2) == 0 || ((csH() && this.qXr == 2) || (this.rol & 1) == 0)) {
            AppMethodBeat.o(38675);
            return true;
        } else {
            AppMethodBeat.o(38675);
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
        AppMethodBeat.i(38676);
        if (bo.isNullOrNil(this.rnV) || bo.isNullOrNil(this.rnW)) {
            AppMethodBeat.o(38676);
            return false;
        }
        AppMethodBeat.o(38676);
        return true;
    }

    private boolean csH() {
        return (this.rol & 16) == 0;
    }

    public final void bcW() {
        AppMethodBeat.i(38677);
        try {
            for (SnsAdLandingPageFloatView snsAdLandingPageFloatView : this.roA.values()) {
                snsAdLandingPageFloatView.onPause();
                snsAdLandingPageFloatView.setVisibility(8);
            }
            aqX();
            csx();
            IF();
            this.rod = true;
            this.rop.setVisibility(8);
            if (!this.rnS) {
                finish();
                AppMethodBeat.o(38677);
            } else if (this.rox) {
                ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
                AppMethodBeat.o(38677);
            } else {
                ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "run exit animation, %s", Boolean.valueOf(this.rnS));
                this.rox = true;
                if (isSupportNavigationSwipeBack()) {
                    getSwipeBackLayout().setEnableGesture(false);
                }
                for (h hVar : csI().cqa()) {
                    if (hVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) {
                        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) hVar).coY();
                        hVar.cpA();
                    }
                }
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(38629);
                        SnsAdNativeLandingPagesUI.J(SnsAdNativeLandingPagesUI.this);
                        AppMethodBeat.o(38629);
                    }
                }, 30);
                AppMethodBeat.o(38677);
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SnsAdNativeLandingPagesUI", e, "play exit animation error", new Object[0]);
            finish();
            AppMethodBeat.o(38677);
        }
    }

    public void onBackPressed() {
        AppMethodBeat.i(38678);
        bcW();
        AppMethodBeat.o(38678);
    }

    private ContentFragment csI() {
        AppMethodBeat.i(38679);
        ContentFragment contentFragment = null;
        if (this.rnM.size() > 0) {
            contentFragment = (ContentFragment) this.roI.get(Integer.valueOf(((g) this.rnM.get(this.rok.getCurrentItem())).id));
        }
        AppMethodBeat.o(38679);
        return contentFragment;
    }

    private a csJ() {
        AppMethodBeat.i(38680);
        com.tencent.mm.plugin.sns.storage.b bVar = new com.tencent.mm.plugin.sns.storage.b(this.rnT);
        if (bVar.coS()) {
            int adVoteIndex = AdLandingPagesProxy.getInstance().getAdVoteIndex(bVar.qVh.qVu, this.qPj, this.uin);
            if (adVoteIndex > 0 && adVoteIndex <= bVar.qVh.qVv.size()) {
                com.tencent.mm.plugin.sns.storage.b.g gVar = (com.tencent.mm.plugin.sns.storage.b.g) bVar.qVh.qVv.get(adVoteIndex - 1);
                a aVar = new a(this, (byte) 0);
                if (bo.isNullOrNil(gVar.lvA)) {
                    aVar.lvA = this.lvA;
                } else {
                    aVar.lvA = gVar.lvA;
                }
                if (bo.isNullOrNil(gVar.qVw)) {
                    aVar.qVw = this.qVw;
                } else {
                    aVar.qVw = gVar.qVw;
                }
                if (bo.isNullOrNil(gVar.qVx)) {
                    aVar.qVx = this.rnZ;
                } else {
                    aVar.qVx = gVar.qVx;
                }
                AppMethodBeat.o(38680);
                return aVar;
            }
        }
        AppMethodBeat.o(38680);
        return null;
    }

    private String ZD(String str) {
        AppMethodBeat.i(38681);
        String bc = bo.bc((String) this.values.get("." + this.rnU + ".adCanvasInfo.shareThumbUrl"), "");
        if (bo.isNullOrNil(bc)) {
            AppMethodBeat.o(38681);
            return str;
        }
        AppMethodBeat.o(38681);
        return bc;
    }

    private String csK() {
        AppMethodBeat.i(38682);
        cdg cdg = new cdg();
        cdg.xcS = new cdh();
        cdg.xcS.xcW = this.roc.qPj;
        cdg.xcS.xcV = this.roc.cFc;
        cdg.xcS.qUe = this.qUe;
        String encodeToString;
        try {
            encodeToString = Base64.encodeToString(cdg.toByteArray(), 2);
            AppMethodBeat.o(38682);
            return encodeToString;
        } catch (Exception e) {
            encodeToString = "";
            AppMethodBeat.o(38682);
            return encodeToString;
        }
    }

    private String csL() {
        AppMethodBeat.i(38683);
        String replaceAll = this.rnT.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
        AppMethodBeat.o(38683);
        return replaceAll;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(38684);
        if (i == 1) {
            if (i2 == -1) {
                com.tencent.mm.ui.base.h.bQ(this.mController.ylL, this.mController.ylL.getString(R.string.to));
            }
        } else if (i == 2) {
            if (intent.getBooleanExtra("kfavorite", false)) {
                ((com.tencent.mm.plugin.fav.a.v) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.fav.a.v.class)).a(AdLandingPagesProxy.getInstance().doFav(intent, 42), this, this.mUw);
            }
        } else if (i == com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.rbL) {
            try {
                String stringExtra = intent.getStringExtra("KComponentCid");
                for (h hVar : getAllComp()) {
                    if (hVar.cpy().equals(stringExtra)) {
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x xVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x) hVar;
                        int intExtra = intent.getIntExtra("KStreamVideoPlayCount", 0);
                        int intExtra2 = intent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
                        int intExtra3 = intent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
                        xVar.qEo = intExtra + xVar.qEo;
                        xVar.qEp += intExtra2;
                        xVar.qEq += intExtra3;
                        break;
                    }
                }
            } catch (Exception e) {
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(38684);
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.i(38685);
        super.onKeyboardStateChanged();
        if (this.rok != null) {
            this.rok.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38634);
                    if (SnsAdNativeLandingPagesUI.this.mController.ymc != 1) {
                        ad.ac(SnsAdNativeLandingPagesUI.this);
                    }
                    if (!SnsAdNativeLandingPagesUI.this.roy) {
                        ArrayList arrayList = new ArrayList();
                        for (Fragment fragment : ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b) SnsAdNativeLandingPagesUI.this.rok.getAdapter()).rdA) {
                            ((ContentFragment) fragment).cqb();
                        }
                    }
                    AppMethodBeat.o(38634);
                }
            }, 500);
        }
        AppMethodBeat.o(38685);
    }

    public final void lg(boolean z) {
        AppMethodBeat.i(38686);
        if (z && this.qXr == 1) {
            AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.rog, this.roh, this.roi, this.roF);
        }
        if (this.qXr == 2 && !bo.isNullOrNil(this.roj)) {
            AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.roj, this.roF);
        }
        this.rof = true;
        AppMethodBeat.o(38686);
    }

    public final void a(r rVar, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(38687);
        if (this.roK == null || z3) {
            final boolean z4 = z3;
            AnonymousClass10 anonymousClass10 = new e() {
                public final void ao(Object obj) {
                }

                public final void f(int i, int i2, Object obj) {
                    AppMethodBeat.i(38636);
                    SnsAdNativeLandingPagesUI.this.lg(false);
                    if (z4) {
                        if (SnsAdNativeLandingPagesUI.this.roK != null) {
                            SnsAdNativeLandingPagesUI.this.roK.cpE();
                        }
                        if (SnsAdNativeLandingPagesUI.this.roL != null) {
                            SnsAdNativeLandingPagesUI.this.roL.dismiss();
                            SnsAdNativeLandingPagesUI.this.roL = null;
                        }
                    }
                    AppMethodBeat.o(38636);
                }
            };
            if (!z3) {
                h a = al.a(this.mController.ylL, rVar, new LinearLayout(this.mController.ylL), !bo.isNullOrNil(rVar.qWX) ? Color.parseColor(rVar.qWX) : -1);
                this.roK = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i(this.mController.ylL, a, str, str2, str3, z, z2);
                final View view = a.getView();
                this.roK.qZy = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i.a() {
                    public final void cpF() {
                        AppMethodBeat.i(38637);
                        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
                        csM();
                        AppMethodBeat.o(38637);
                    }

                    public final void cpG() {
                        AppMethodBeat.i(38638);
                        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
                        csM();
                        AppMethodBeat.o(38638);
                    }

                    private void csM() {
                        AppMethodBeat.i(38639);
                        if (!(view == null || view.getParent() == null)) {
                            ((ViewGroup) view.getParent()).removeView(view);
                        }
                        SnsAdNativeLandingPagesUI.this.roK = null;
                        AppMethodBeat.o(38639);
                    }
                };
                this.roK.cpD();
            }
            if (!bo.isNullOrNil(str)) {
                AdLandingPagesProxy.getInstance().doFavOfficialItemScene(str, anonymousClass10);
                if (z3) {
                    this.roL = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.em7), false, null);
                }
            }
            AppMethodBeat.o(38687);
            return;
        }
        ab.w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
        this.roK.cpE();
        if (this.roL != null) {
            this.roL.dismiss();
            this.roL = null;
        }
        AppMethodBeat.o(38687);
    }

    public final void w(Context context, String str, String str2) {
        AppMethodBeat.i(38688);
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", 14);
        intent.putExtra("sns_landig_pages_origin_from_source", this.qXp == 0 ? this.cvd : this.qXp);
        intent.putExtra("sns_landing_pages_canvasid", str);
        intent.putExtra("sns_landing_pages_canvas_ext", str2);
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        intent.putExtra("sns_landing_pages_no_store", 1);
        String stringExtra = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        String stringExtra2 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        if (!bo.isNullOrNil(stringExtra)) {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", valueOf);
                jSONObject.put("cid", "");
                jSONObject.put("adBuffer", !bo.isNullOrNil(stringExtra2) ? stringExtra2 : "");
                jSONObject.put("preSessionId", stringExtra);
            } catch (Exception e) {
            }
            intent.putExtra("sns_landing_pages_search_extra", jSONObject.toString());
            intent.putExtra("sns_landing_pages_sessionId", valueOf);
            intent.putExtra("sns_landing_pages_ad_buffer", stringExtra2);
        }
        com.tencent.mm.bp.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
        AppMethodBeat.o(38688);
    }

    static /* synthetic */ void g(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(38689);
        if (snsAdNativeLandingPagesUI.rox) {
            ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
            AppMethodBeat.o(38689);
            return;
        }
        snsAdNativeLandingPagesUI.rox = true;
        if (snsAdNativeLandingPagesUI.isSupportNavigationSwipeBack()) {
            snsAdNativeLandingPagesUI.getSwipeBackLayout().setEnableGesture(false);
            snsAdNativeLandingPagesUI.getSwipeBackLayout().qX(true);
        }
        if (snsAdNativeLandingPagesUI.rou == null) {
            snsAdNativeLandingPagesUI.rou = new com.tencent.mm.plugin.sns.ui.b.b(snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.rnP);
            AdLandingPagesProxy.getInstance().playTimelineClickAnimation(0);
            Bundle bundle = new Bundle();
            bundle.putInt("param_thumb_left", snsAdNativeLandingPagesUI.kkr);
            bundle.putInt("param_thumb_top", snsAdNativeLandingPagesUI.kkq);
            bundle.putInt("param_thumb_width", snsAdNativeLandingPagesUI.kks);
            bundle.putInt("param_thumb_height", snsAdNativeLandingPagesUI.kkt);
            com.tencent.mm.plugin.sns.ui.b.b bVar = snsAdNativeLandingPagesUI.rou;
            bVar.rFP = bundle.getInt("param_thumb_left");
            bVar.rFQ = bundle.getInt("param_thumb_top");
            bVar.rFR = bundle.getInt("param_thumb_width");
            bVar.rFS = bundle.getInt("param_thumb_height");
            ab.i("MicroMsg.SnsAdNativeEnterAnimation", "left %s, top %s, width %s, height %s", Integer.valueOf(bVar.rFP), Integer.valueOf(bVar.rFQ), Integer.valueOf(bVar.rFR), Integer.valueOf(bVar.rFS));
            snsAdNativeLandingPagesUI.rou.rFT = new com.tencent.mm.plugin.sns.ui.b.a() {
                public final void onAnimationStart() {
                    AppMethodBeat.i(38626);
                    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "sns enter anim start");
                    AppMethodBeat.o(38626);
                }

                public final void aZ(float f) {
                    AppMethodBeat.i(38627);
                    SnsAdNativeLandingPagesUI.this.mmX.setAlpha(1.0f - f);
                    AppMethodBeat.o(38627);
                }

                public final void onAnimationEnd() {
                    AppMethodBeat.i(38628);
                    SnsAdNativeLandingPagesUI.this.rox = false;
                    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "sns enter anim end");
                    SnsAdNativeLandingPagesUI.this.roq.setVisibility(0);
                    SnsAdNativeLandingPagesUI.this.rop.setVisibility(0);
                    SnsAdNativeLandingPagesUI.p(SnsAdNativeLandingPagesUI.this);
                    SnsAdNativeLandingPagesUI.I(SnsAdNativeLandingPagesUI.this);
                    if (SnsAdNativeLandingPagesUI.this.isSupportNavigationSwipeBack()) {
                        SnsAdNativeLandingPagesUI.this.getSwipeBackLayout().setEnableGesture(true);
                    }
                    AppMethodBeat.o(38628);
                }
            };
            com.tencent.mm.plugin.sns.ui.b.b bVar2 = snsAdNativeLandingPagesUI.rou;
            if (!bVar2.nVD.isStarted()) {
                bVar2.nVD.setStartDelay(0);
                bVar2.nVD.start();
            }
        }
        AppMethodBeat.o(38689);
    }

    static /* synthetic */ void D(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(38695);
        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTransimt snsAdNativeLadingPagesUI");
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k kVar = snsAdNativeLandingPagesUI.roc;
        kVar.meZ++;
        String csK = snsAdNativeLandingPagesUI.csK();
        String csL = snsAdNativeLandingPagesUI.csL();
        a csJ = snsAdNativeLandingPagesUI.csJ();
        if (csJ != null) {
            AdLandingPagesProxy.getInstance().doTransimt(snsAdNativeLandingPagesUI, csL, csJ.lvA, snsAdNativeLandingPagesUI.ZD(csJ.qVx), csJ.qVw, snsAdNativeLandingPagesUI.lvz, csK);
            AppMethodBeat.o(38695);
            return;
        }
        AdLandingPagesProxy.getInstance().doTransimt(snsAdNativeLandingPagesUI, csL, snsAdNativeLandingPagesUI.lvA, snsAdNativeLandingPagesUI.ZD(snsAdNativeLandingPagesUI.rnZ), snsAdNativeLandingPagesUI.qVw, snsAdNativeLandingPagesUI.lvz, csK);
        AppMethodBeat.o(38695);
    }

    static /* synthetic */ void E(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(38696);
        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "doShareToTimeline snsAdNativeLadingPagesUI");
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k kVar = snsAdNativeLandingPagesUI.roc;
        kVar.mfa++;
        String str = snsAdNativeLandingPagesUI.lvz;
        a csJ = snsAdNativeLandingPagesUI.csJ();
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline fail, link is null");
            AppMethodBeat.o(38696);
            return;
        }
        int i = snsAdNativeLandingPagesUI.kks;
        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, init intent");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i);
        intent.putExtra("Ksnsupload_height", i);
        intent.putExtra("Ksnsupload_link", snsAdNativeLandingPagesUI.lvz);
        if (csJ != null) {
            intent.putExtra("Ksnsupload_title", csJ.lvA);
            intent.putExtra("Ksnsupload_imgurl", snsAdNativeLandingPagesUI.ZD(csJ.qVx));
        } else {
            intent.putExtra("Ksnsupload_title", snsAdNativeLandingPagesUI.lvA);
            intent.putExtra("Ksnsupload_imgurl", snsAdNativeLandingPagesUI.ZD(snsAdNativeLandingPagesUI.rnZ));
        }
        intent.putExtra("Ksnsupload_canvas_info", snsAdNativeLandingPagesUI.csL());
        intent.putExtra("Ksnsupload_contentattribute", 0);
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        str = snsAdNativeLandingPagesUI.csK();
        if (!bo.isNullOrNil(str)) {
            intent.putExtra("key_snsad_statextstr", str);
        }
        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, start activity");
        intent.putExtra("need_result", true);
        str = "sns_";
        if (snsAdNativeLandingPagesUI.cvd == 1 || snsAdNativeLandingPagesUI.cvd == 2 || snsAdNativeLandingPagesUI.cvd == 3 || snsAdNativeLandingPagesUI.cvd == 4 || snsAdNativeLandingPagesUI.cvd == 9 || snsAdNativeLandingPagesUI.cvd == 10 || snsAdNativeLandingPagesUI.cvd == 11) {
            str = "sns_" + snsAdNativeLandingPagesUI.cFc;
        } else if (snsAdNativeLandingPagesUI.cvd == 5 || snsAdNativeLandingPagesUI.cvd == 6) {
            str = "msg_".concat(String.valueOf(snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L)));
        } else if (snsAdNativeLandingPagesUI.cvd == 7) {
            str = "fav_".concat(String.valueOf(snsAdNativeLandingPagesUI.getIntent().getExtras().getString("sns_landing_favid")));
        }
        String nW = com.tencent.mm.model.v.nW(str);
        com.tencent.mm.model.v.Zp().y(nW, true).j("prePublishId", str);
        intent.putExtra("reportSessionId", nW);
        com.tencent.mm.bp.d.a(snsAdNativeLandingPagesUI.mController.ylL, "sns", ".ui.SnsUploadUI", intent, 1, false);
        AppMethodBeat.o(38696);
    }

    static /* synthetic */ void F(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(38697);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k kVar = snsAdNativeLandingPagesUI.roc;
        kVar.mLz++;
        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "doFav snsAdNativeLadingPagesUI");
        long j = snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L);
        String str = null;
        if (!bo.isNullOrNil(snsAdNativeLandingPagesUI.cFc)) {
            n snsInfo = AdLandingPagesProxy.getInstance().getSnsInfo(snsAdNativeLandingPagesUI.cFc);
            if (snsInfo != null) {
                str = snsInfo.cqU();
            }
            AppMethodBeat.o(38697);
        }
        String nullAsNil = bo.nullAsNil(snsAdNativeLandingPagesUI.getIntent().getStringExtra("prePublishId"));
        a csJ = snsAdNativeLandingPagesUI.csJ();
        String csK = snsAdNativeLandingPagesUI.csK();
        String csL = snsAdNativeLandingPagesUI.csL();
        if (csJ != null) {
            AdLandingPagesProxy.getInstance().doFavAdlanding(j, str, snsAdNativeLandingPagesUI.cvd, snsAdNativeLandingPagesUI.lvz, nullAsNil, csJ.lvA, csJ.qVw, csL, 34, snsAdNativeLandingPagesUI.ZD(csJ.qVx), csK);
        } else {
            AdLandingPagesProxy.getInstance().doFavAdlanding(j, str, snsAdNativeLandingPagesUI.cvd, snsAdNativeLandingPagesUI.lvz, nullAsNil, snsAdNativeLandingPagesUI.lvA, snsAdNativeLandingPagesUI.qVw, csL, 34, snsAdNativeLandingPagesUI.ZD(snsAdNativeLandingPagesUI.rnZ), csK);
        }
        ((com.tencent.mm.plugin.fav.a.v) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.fav.a.v.class)).a(0, snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.mUw);
        AppMethodBeat.o(38697);
    }

    static /* synthetic */ void I(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(38698);
        if (snsAdNativeLandingPagesUI.rnM != null) {
            Iterator it = snsAdNativeLandingPagesUI.rnM.iterator();
            while (it.hasNext()) {
                ContentFragment contentFragment = (ContentFragment) snsAdNativeLandingPagesUI.roI.get(Integer.valueOf(((g) it.next()).id));
                if (contentFragment != null) {
                    contentFragment.rdh = true;
                }
            }
            ((ContentFragment) snsAdNativeLandingPagesUI.roI.get(Integer.valueOf(((g) snsAdNativeLandingPagesUI.rnM.getFirst()).id))).cqd();
        }
        AppMethodBeat.o(38698);
    }

    static /* synthetic */ void J(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(38699);
        if (snsAdNativeLandingPagesUI.rov == null) {
            snsAdNativeLandingPagesUI.rov = new com.tencent.mm.plugin.sns.ui.b.c(snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.rnP);
            AdLandingPagesProxy.getInstance().playTimelineBackAnimation(0);
            Bundle bundle = new Bundle();
            bundle.putInt("param_thumb_left", snsAdNativeLandingPagesUI.kkr);
            bundle.putInt("param_thumb_top", snsAdNativeLandingPagesUI.kkq);
            bundle.putInt("param_thumb_width", snsAdNativeLandingPagesUI.kks);
            bundle.putInt("param_thumb_height", snsAdNativeLandingPagesUI.kkt);
            com.tencent.mm.plugin.sns.ui.b.c cVar = snsAdNativeLandingPagesUI.rov;
            cVar.rFP = bundle.getInt("param_thumb_left");
            cVar.rFQ = bundle.getInt("param_thumb_top");
            cVar.rFR = bundle.getInt("param_thumb_width");
            cVar.rFS = bundle.getInt("param_thumb_height");
            ab.i("MicroMsg.SnsAdNativeExitAnimation", "left %s, top %s, width %s, height %s", Integer.valueOf(cVar.rFP), Integer.valueOf(cVar.rFQ), Integer.valueOf(cVar.rFR), Integer.valueOf(cVar.rFS));
        }
        Bitmap eA = d.eA(snsAdNativeLandingPagesUI.roq);
        if (eA != null) {
            snsAdNativeLandingPagesUI.rnP.setImageBitmap(eA);
        }
        snsAdNativeLandingPagesUI.rov.rFT = new com.tencent.mm.plugin.sns.ui.b.a() {
            public final void onAnimationStart() {
                AppMethodBeat.i(38630);
                ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "sns exit anim start");
                SnsAdNativeLandingPagesUI.this.roq.setVisibility(4);
                AppMethodBeat.o(38630);
            }

            public final void aZ(float f) {
                AppMethodBeat.i(38631);
                SnsAdNativeLandingPagesUI.this.mmX.setAlpha(1.0f - f);
                AppMethodBeat.o(38631);
            }

            public final void onAnimationEnd() {
                AppMethodBeat.i(38632);
                SnsAdNativeLandingPagesUI.this.rox = false;
                ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "sns exit anim end");
                SnsAdNativeLandingPagesUI.this.finish();
                SnsAdNativeLandingPagesUI.this.overridePendingTransition(R.anim.s, R.anim.s);
                if (SnsAdNativeLandingPagesUI.this.isSupportNavigationSwipeBack()) {
                    SnsAdNativeLandingPagesUI.this.getSwipeBackLayout().setEnableGesture(true);
                }
                AppMethodBeat.o(38632);
            }
        };
        com.tencent.mm.plugin.sns.ui.b.c cVar2 = snsAdNativeLandingPagesUI.rov;
        if (!cVar2.nVD.isStarted()) {
            cVar2.nVD.setStartDelay(0);
            cVar2.nVD.start();
        }
        AppMethodBeat.o(38699);
    }
}
