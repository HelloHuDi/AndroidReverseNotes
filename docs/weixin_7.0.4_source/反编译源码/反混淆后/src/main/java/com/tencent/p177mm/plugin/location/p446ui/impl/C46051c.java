package com.tencent.p177mm.plugin.location.p446ui.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMLoadMoreListView;
import com.tencent.p177mm.p612ui.base.MMLoadMoreListView.C36055a;
import com.tencent.p177mm.p612ui.tools.ActionBarSearchView;
import com.tencent.p177mm.p612ui.tools.ActionBarSearchView.C5553a;
import com.tencent.p177mm.p612ui.tools.ActionBarSearchView.C5554b;
import com.tencent.p177mm.plugin.location.model.C21170h;
import com.tencent.p177mm.plugin.location.p446ui.C12383g;
import com.tencent.p177mm.plugin.location.p446ui.C3339e;
import com.tencent.p177mm.plugin.location.p446ui.C34412d;
import com.tencent.p177mm.plugin.location.p446ui.PoiHeaderView;
import com.tencent.p177mm.plugin.location.p446ui.SimpleImageView;
import com.tencent.p177mm.plugin.location.p446ui.SimpleImageView.C34410a;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.p443k.C28354d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.location.LocationIntent;
import com.tencent.p177mm.protocal.protobuf.alt;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.location.ui.impl.c */
public final class C46051c extends C21179b implements C1202f {
    private static int nPR = 11;
    private static int nPS = 12;
    private static int nPT = 13;
    private static int nPU = 14;
    private C42206a ecy = new C344189();
    private String fMh = "";
    private double lat = -85.0d;
    private double lng = -1000.0d;
    private ImageView lnh;
    private String nJJ = "";
    private int nJK = 1;
    FrameLayout nOX;
    private boolean nPA = false;
    private int nPB = 0;
    private RelativeLayout nPC;
    private int nPD;
    private int nPE;
    private int nPF;
    private boolean nPG = true;
    private boolean nPH = false;
    private boolean nPI = false;
    private FrameLayout nPJ;
    private float nPK;
    private float nPL;
    private int nPM = 0;
    private long nPN = -1;
    private long nPO = -1;
    private long nPP = -1;
    private int nPQ = -1;
    private boolean nPV = false;
    private boolean nPW;
    private boolean nPX;
    protected PoiHeaderView nPg;
    private PickPoi nPh;
    private MMLoadMoreListView nPi;
    private MMLoadMoreListView nPj;
    private View nPk;
    private C46052e nPl;
    private C46052e nPm;
    private View nPn;
    private ImageButton nPo;
    private C21170h nPp = null;
    private C43245f nPq = null;
    private View nPr;
    private ImageButton nPs;
    ActionBarSearchView nPt;
    private TextView nPu;
    private LinearLayout nPv;
    private C3339e nPw;
    private C12383g nPx;
    private double nPy = -85.0d;
    private double nPz = -1000.0d;
    private TextView titleView;

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$11 */
    class C334911 implements OnClickListener {
        C334911() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113606);
            C4990ab.m7411d("MicroMsg.MMPoiMapUI", "click lat: %s, lng: %s", Double.valueOf(C46051c.this.nPy), Double.valueOf(C46051c.this.nPz));
            if (C46051c.this.nPy == -85.0d || C46051c.this.nPz == -1000.0d) {
                C4990ab.m7416i("MicroMsg.MMPoiMapUI", "invalid lat lng");
                AppMethodBeat.m2505o(113606);
                return;
            }
            C46051c.this.nMj.getIController().animateTo(C46051c.this.nPy, C46051c.this.nPz);
            C46051c.this.lat = C46051c.this.nPy;
            C46051c.this.lng = C46051c.this.nPz;
            C46051c.this.nPh.mo73944l(C46051c.this.lat, C46051c.this.lng);
            C46051c.this.nPo.setBackgroundResource(C25738R.drawable.b7y);
            C46051c.this.nPo.setEnabled(true);
            C46051c.m85757m(C46051c.this);
            C46051c.this.nPV = false;
            C46051c.this.nPl.nPV = false;
            AppMethodBeat.m2505o(113606);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$8 */
    class C33508 implements Runnable {
        C33508() {
        }

        public final void run() {
            AppMethodBeat.m2504i(113602);
            C46051c.this.nPt.dJt();
            C46051c.this.showVKB();
            AppMethodBeat.m2505o(113602);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$a */
    class C3351a extends TranslateAnimation {
        private List<View> nQd = new ArrayList();

        public C3351a(float f) {
            super(0.0f, 0.0f, 0.0f, f);
            AppMethodBeat.m2504i(113614);
            AppMethodBeat.m2505o(113614);
        }

        public final C3351a bKw() {
            AppMethodBeat.m2504i(113615);
            setFillEnabled(true);
            setFillAfter(true);
            AppMethodBeat.m2505o(113615);
            return this;
        }

        /* renamed from: dm */
        public final C3351a mo7758dm(View view) {
            AppMethodBeat.m2504i(113616);
            this.nQd.add(view);
            AppMethodBeat.m2505o(113616);
            return this;
        }

        public final void bKx() {
            AppMethodBeat.m2504i(113617);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nQd.size()) {
                    ((View) this.nQd.get(i2)).startAnimation(this);
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(113617);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$10 */
    class C1238710 implements C36055a {
        C1238710() {
        }

        /* renamed from: KB */
        public final void mo8166KB() {
            AppMethodBeat.m2504i(113605);
            C46051c.m85746f(C46051c.this);
            AppMethodBeat.m2505o(113605);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$12 */
    class C1238812 implements OnClickListener {
        C1238812() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113607);
            C46051c.m85728a(C46051c.this, C46051c.nPS, C46051c.this.nPl.llU, false);
            C46051c.this.aqX();
            C46051c.this.activity.finish();
            AppMethodBeat.m2505o(113607);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$5 */
    class C123895 implements OnItemClickListener {
        C123895() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(113599);
            C43245f c43245f = null;
            if (i >= 0 && i < C46051c.this.nPm.getCount()) {
                c43245f = C46051c.this.nPm.mo73961xG(i);
            }
            C46051c.this.nPq = c43245f;
            C46051c.m85729a(C46051c.this, c43245f);
            AppMethodBeat.m2505o(113599);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$6 */
    class C123906 implements OnTouchListener {
        C123906() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(113600);
            C46051c.this.aqX();
            AppMethodBeat.m2505o(113600);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$7 */
    class C123917 implements OnFocusChangeListener {
        C123917() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(113601);
            if (z) {
                C46051c.this.showVKB();
            }
            AppMethodBeat.m2505o(113601);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$13 */
    class C3441313 implements OnClickListener {
        C3441313() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113608);
            C46051c.m85760p(C46051c.this);
            AppMethodBeat.m2505o(113608);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$14 */
    class C3441414 implements OnItemClickListener {
        C3441414() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(113609);
            C4990ab.m7411d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", Integer.valueOf(i));
            if (!C46051c.this.nPA) {
                if (i >= C46051c.this.nPl.getCount()) {
                    C4990ab.m7416i("MicroMsg.MMPoiMapUI", "wrong position");
                    AppMethodBeat.m2505o(113609);
                    return;
                }
                C43245f xG = C46051c.this.nPl.mo73961xG(i);
                if (xG.type == 0) {
                    C12383g r = C46051c.this.nPx;
                    double d = xG.bDG;
                    double d2 = xG.bDH;
                    if (r.nLR) {
                        r.nMj.updateLocaitonPinLayout(r, d, d2);
                    } else {
                        r.nLR = true;
                        r.nMj.addPinView(r, d, d2);
                    }
                    C46051c.this.nPo.setBackgroundResource(C25738R.drawable.b7x);
                } else {
                    C46051c.this.nPx.remove();
                    C46051c.this.nPo.setEnabled(true);
                }
                C46051c.this.nMj.getIController().animateTo(xG.bDG, xG.bDH);
                C46051c.this.nPl.llU = i;
                C46051c.this.nPl.notifyDataSetChanged();
            }
            C46051c.this.nPV = false;
            AppMethodBeat.m2505o(113609);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$16 */
    class C3441616 implements OnClickListener {
        C3441616() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113612);
            if (!C46051c.this.nPA) {
                C46051c.m85765u(C46051c.this);
            }
            C46051c.this.nPm.clean();
            C46051c.this.nPj.setAdapter(C46051c.this.nPm);
            C46051c.this.nPm.notifyDataSetChanged();
            C46051c.this.nPk.setVisibility(8);
            AppMethodBeat.m2505o(113612);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$17 */
    class C3441717 implements C5553a {
        C3441717() {
        }

        public final void bKv() {
            AppMethodBeat.m2504i(113613);
            C4990ab.m7410d("MicroMsg.MMPoiMapUI", "back pressed");
            C46051c.m85728a(C46051c.this, C46051c.nPU, C46051c.this.nPm.llU, true);
            C46051c.m85729a(C46051c.this, null);
            AppMethodBeat.m2505o(113613);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$9 */
    class C344189 implements C42206a {

        /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$9$1 */
        class C344191 implements DialogInterface.OnClickListener {
            C344191() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(113603);
                C26443d.m42103bX(C46051c.this.activity);
                AppMethodBeat.m2505o(113603);
            }
        }

        C344189() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(113604);
            if (z) {
                if (C46051c.this.nPy == -85.0d || C46051c.this.nPz == -1000.0d) {
                    C4990ab.m7410d("MicroMsg.MMPoiMapUI", "first get location");
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LAST_LOCATION_STRING, ((int) (1000000.0f * f2)) + "," + ((int) (1000000.0f * f)));
                    C46051c.this.nPy = (double) f2;
                    C46051c.this.nPz = (double) f;
                    C46051c.this.nPK = f2;
                    C46051c.this.nPL = f;
                    C46051c.this.lat = C46051c.this.nPy;
                    C46051c.this.lng = C46051c.this.nPz;
                    C46051c.this.nPh.mo73944l(C46051c.this.lat, C46051c.this.lng);
                    C46051c.this.nMj.getIController().animateTo(C46051c.this.nPy, C46051c.this.nPz, C34412d.bJM());
                    if (!C46051c.this.nPA) {
                        C46051c.m85757m(C46051c.this);
                    }
                }
                AppMethodBeat.m2505o(113604);
                return true;
            }
            if (!(C46051c.this.nPX || C26443d.agA())) {
                C46051c.this.nPX = true;
                C30379h.m48445a(C46051c.this.activity, C46051c.this.activity.getString(C25738R.string.c9z), C46051c.this.activity.getString(C25738R.string.f9238tz), C46051c.this.activity.getString(C25738R.string.ckr), C46051c.this.activity.getString(C25738R.string.f9076or), false, new C344191(), null);
            }
            AppMethodBeat.m2505o(113604);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$1 */
    class C392911 implements OnTouchListener {
        private float nPY;
        private short nPZ = (short) 0;

        C392911() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(113594);
            if (C46051c.this.nPG) {
                switch (motionEvent.getAction()) {
                    case 0:
                        C4990ab.m7411d("MicroMsg.MMPoiMapUI", "newpoi action down %s", Float.valueOf(motionEvent.getRawY()));
                        this.nPY = motionEvent.getRawY();
                        C46051c.this.nPH = false;
                        break;
                    case 1:
                        C4990ab.m7410d("MicroMsg.MMPoiMapUI", "newpoi action up ");
                        C46051c.this.nPH = false;
                        break;
                    case 2:
                        C4990ab.m7411d("MicroMsg.MMPoiMapUI", "newpoi action move %s", Float.valueOf(motionEvent.getRawY()));
                        if (C46051c.this.nPH) {
                            C4990ab.m7410d("MicroMsg.MMPoiMapUI", "newpoi blocked");
                            C46051c.this.nPi.setSelection(0);
                        }
                        float rawY = this.nPY - motionEvent.getRawY();
                        if (Math.abs(rawY) < ((float) C4977b.m7371b(C46051c.this.activity, 20.0f))) {
                            this.nPZ = (short) 0;
                        } else if (rawY > 0.0f) {
                            this.nPZ = (short) 1;
                        } else {
                            this.nPZ = (short) -1;
                        }
                        if ((C46051c.this.bKr() <= C46051c.this.nPE && this.nPZ == (short) 1) || ((!C46051c.this.nPi.getScroll2Top() && this.nPZ == (short) -1 && C46051c.this.bKr() < C46051c.this.nPD) || (this.nPZ == (short) -1 && C46051c.this.bKr() >= C46051c.this.nPD))) {
                            AppMethodBeat.m2505o(113594);
                            return false;
                        } else if (!C46051c.this.nPG || this.nPZ == (short) 0) {
                            AppMethodBeat.m2505o(113594);
                            return true;
                        } else {
                            C4990ab.m7411d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", Short.valueOf(this.nPZ));
                            if (this.nPZ == (short) 1) {
                                C46051c.m85737b(C46051c.this, true);
                                AppMethodBeat.m2505o(113594);
                                return false;
                            }
                            C46051c.m85737b(C46051c.this, false);
                            AppMethodBeat.m2505o(113594);
                            return false;
                        }
                }
                AppMethodBeat.m2505o(113594);
                return false;
            }
            AppMethodBeat.m2505o(113594);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$3 */
    class C392923 implements C5554b {
        C392923() {
        }

        public final void bKt() {
        }

        /* renamed from: Qa */
        public final void mo11263Qa(String str) {
            AppMethodBeat.m2504i(113596);
            C4990ab.m7411d("MicroMsg.MMPoiMapUI", "searchText: %s", str);
            C46051c.this.fMh = str;
            C46051c.this.nPj.dzO();
            C46051c.this.nPu.setVisibility(8);
            if (C5046bo.isNullOrNil(str)) {
                C46051c.this.nPm.clean();
                C46051c.this.nPm.notifyDataSetChanged();
                AppMethodBeat.m2505o(113596);
                return;
            }
            C46051c.m85771z(C46051c.this);
            AppMethodBeat.m2505o(113596);
        }

        public final void apq() {
            AppMethodBeat.m2504i(113597);
            C4990ab.m7410d("MicroMsg.MMPoiMapUI", "clear btn click");
            C46051c.this.nPm.clean();
            C46051c.this.nPm.notifyDataSetChanged();
            AppMethodBeat.m2505o(113597);
        }

        public final void bKu() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$2 */
    class C460492 implements OnEditorActionListener {
        C460492() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(113595);
            C4990ab.m7410d("MicroMsg.MMPoiMapUI", "keyboard action");
            if (3 == i) {
                C46051c.m85757m(C46051c.this);
            }
            AppMethodBeat.m2505o(113595);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$4 */
    class C460504 implements C36055a {
        C460504() {
        }

        /* renamed from: KB */
        public final void mo8166KB() {
            AppMethodBeat.m2504i(113598);
            C46051c.m85746f(C46051c.this);
            AppMethodBeat.m2505o(113598);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m85728a(C46051c c46051c, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(113640);
        c46051c.m85756m(i, i2, z);
        AppMethodBeat.m2505o(113640);
    }

    /* renamed from: z */
    static /* synthetic */ void m85771z(C46051c c46051c) {
        AppMethodBeat.m2504i(113644);
        c46051c.m85749hM(true);
        AppMethodBeat.m2505o(113644);
    }

    public C46051c(Activity activity) {
        super(activity);
        AppMethodBeat.m2504i(113618);
        AppMethodBeat.m2505o(113618);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(113619);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a(457, (C1202f) this);
        this.nPQ = (int) (System.currentTimeMillis() / 1000);
        this.nPv = (LinearLayout) findViewById(2131825945);
        this.titleView = (TextView) findViewById(2131825948);
        this.titleView.setText(getString(C25738R.string.cnp));
        this.nPC = (RelativeLayout) findViewById(2131826548);
        this.nPi = (MMLoadMoreListView) this.activity.findViewById(2131826550);
        this.nPj = (MMLoadMoreListView) this.activity.findViewById(2131826552);
        this.nPk = this.activity.findViewById(2131826554);
        this.nPu = (TextView) findViewById(2131826553);
        this.nPo = (ImageButton) findViewById(2131824674);
        this.nPo.setContentDescription(getString(C25738R.string.cn6));
        this.nPg = (PoiHeaderView) findViewById(2131826549);
        this.nMj.setBuiltInZoomControls(false);
        this.nOX = (FrameLayout) findViewById(2131824671);
        this.nPw = new C3339e(this.activity, this.nMj);
        this.nPx = new C12383g(this.activity, this.nMj);
        this.nPh = new PickPoi(this.activity);
        this.nPh.setLocationArrow(C25738R.drawable.bmf);
        this.nOX.addView(this.nPh);
        this.nPn = findViewById(2131826551);
        this.lnh = (ImageView) this.activity.findViewById(2131825947);
        this.nPr = (LinearLayout) this.activity.findViewById(2131825952);
        this.nPr.setVisibility(0);
        switch (this.type) {
            case 0:
                ((TextView) findViewById(2131820958)).setText(C25738R.string.cno);
                break;
            case 3:
                ((TextView) findViewById(2131820958)).setText(C25738R.string.f9182s1);
                break;
            case 8:
                ((TextView) findViewById(2131820958)).setText(C25738R.string.f9142qt);
                break;
        }
        this.nPs = (ImageButton) findViewById(2131825950);
        this.nPs.setContentDescription(getString(C25738R.string.e0v));
        this.nPt = (ActionBarSearchView) findViewById(2131826546);
        m85752iG(false);
        this.nPl = new C46052e(this.activity);
        this.nPm = new C46052e(this.activity);
        this.nPm.gxV = true;
        this.nPm.llU = -1;
        this.nPh.setAdapter(this.nPl);
        this.nPi.setAdapter(this.nPl);
        this.nPi.setOnTouchListener(new C392911());
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LAST_LOCATION_STRING, (Object) "");
        if (!C5046bo.isNullOrNil(str) && (this.nPy == -85.0d || this.nPz == -1000.0d)) {
            String[] split = str.split(",");
            C4990ab.m7416i("MicroMsg.MMPoiMapUI", "lastlocationinfo ".concat(String.valueOf(str)));
            if (split.length == 2) {
                this.nMj.getIController().setCenter((double) ((float) ((((double) C5046bo.ank(split[0])) * 1.0d) / 1000000.0d)), (double) ((float) ((((double) C5046bo.ank(split[1])) * 1.0d) / 1000000.0d)));
            }
        }
        this.nPi.setOnLoadMoreListener(new C1238710());
        this.nPo.setOnClickListener(new C334911());
        this.lnh.setOnClickListener(new C1238812());
        this.nPr.setOnClickListener(new C3441313());
        this.nPi.setOnItemClickListener(new C3441414());
        this.nPs.setOnClickListener(new C3441616());
        this.nPt.setHint(getString(C25738R.string.cnl));
        this.nPt.mo11322qN(false);
        this.nPt.setBackClickCallback(new C3441717());
        this.nPt.setOnEditorActionListener(new C460492());
        this.nPt.setCallBack(new C392923());
        this.nPJ = (FrameLayout) findViewById(2131826547);
        m85769xE(C4996ah.getResources().getColor(C25738R.color.f12206vy));
        this.nPD = C4977b.m7371b(this.activity, 280.0f);
        this.nPE = C4977b.m7371b(this.activity, 150.0f);
        int ge = C1338a.m2869ge(this.activity);
        int identifier = C4996ah.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            identifier = C4996ah.getResources().getDimensionPixelSize(identifier);
        } else {
            identifier = 0;
        }
        ge = ((ge - this.nPE) - identifier) - C1338a.m2856al(this.activity, C25738R.dimen.f9778fd);
        if (ge > C1338a.m2856al(this.activity, C25738R.dimen.a83)) {
            C4990ab.m7417i("MicroMsg.MMPoiMapUI", "reset listview height: %s, statusBar: %s, actionBar: %s", Integer.valueOf(ge), Integer.valueOf(identifier), Integer.valueOf(r3));
            LayoutParams layoutParams = this.nPC.getLayoutParams();
            layoutParams.height = ge;
            this.nPC.setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(113619);
    }

    public final C28354d bKo() {
        AppMethodBeat.m2504i(113620);
        C28354d c28354d = (C28354d) this.activity.findViewById(2131820622);
        AppMethodBeat.m2505o(113620);
        return c28354d;
    }

    /* renamed from: xE */
    private void m85769xE(int i) {
        AppMethodBeat.m2504i(113621);
        this.nPv.setBackgroundColor(i);
        this.nPt.setBackgroundColor(i);
        Boolean valueOf = Boolean.valueOf(C5225ah.m7958Nw(i));
        if (valueOf.booleanValue()) {
            this.lnh.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            this.nPs.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            this.titleView.setTextColor(C4996ah.getResources().getColor(C25738R.color.a6a));
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = this.activity.getWindow();
            window.clearFlags(201326592);
            window.addFlags(C8415j.INVALID_ID);
            if (VERSION.SDK_INT < 23 || C1448h.m3077Mt()) {
                i = VERSION.SDK_INT >= 21 ? C5225ah.m7964s(this.activity.getResources().getColor(C25738R.color.a1h), i) : 0;
            }
            this.activity.getWindow().setStatusBarColor(i);
            if (VERSION.SDK_INT >= 23) {
                View decorView = this.activity.getWindow().getDecorView();
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (valueOf.booleanValue()) {
                    systemUiVisibility &= -8193;
                } else {
                    systemUiVisibility |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                }
                decorView.setSystemUiVisibility(systemUiVisibility);
            }
        }
        AppMethodBeat.m2505o(113621);
    }

    /* renamed from: iF */
    private void m85751iF(final boolean z) {
        C3351a c3351a;
        C3351a c3351a2;
        AppMethodBeat.m2504i(113622);
        this.nPG = false;
        if (z) {
            c3351a = new C3351a((float) (-(bKr() - this.nPE)));
            c3351a2 = new C3351a((float) ((-(bKr() - this.nPE)) / 2));
        } else {
            c3351a = new C3351a((float) (this.nPD - bKr()));
            c3351a2 = new C3351a((float) ((this.nPD - bKr()) / 2));
        }
        C3441515 c3441515 = new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.m2504i(113610);
                C4990ab.m7411d("MicroMsg.MMPoiMapUI", "newpoi start animation %s", Long.valueOf(System.currentTimeMillis()));
                C46051c.this.nPG = false;
                C46051c.this.nPH = true;
                AppMethodBeat.m2505o(113610);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(113611);
                C46051c.this.nPG = true;
                if (z) {
                    C46051c.this.mo73950xF(C46051c.this.nPE);
                    C46051c.this.nPI = true;
                } else {
                    C46051c.this.mo73950xF(C46051c.this.nPD);
                    C46051c.this.nPI = false;
                }
                C46051c.this.nPC.clearAnimation();
                C46051c.this.nPo.clearAnimation();
                C46051c.this.nPJ.clearAnimation();
                C46051c.this.nPi.clearFocus();
                AppMethodBeat.m2505o(113611);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        };
        c3351a.setDuration(200);
        c3351a = c3351a.bKw();
        c3351a.setAnimationListener(c3441515);
        c3351a.mo7758dm(this.nPC).mo7758dm(this.nPo).bKx();
        c3351a2.setDuration(200);
        c3351a2.bKw().mo7758dm(this.nPJ).bKx();
        AppMethodBeat.m2505o(113622);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(113623);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            C4990ab.m7410d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent");
            if (this.nPA) {
                m85730a(null);
                m85756m(nPU, this.nPm.llU, true);
                AppMethodBeat.m2505o(113623);
                return false;
            }
            m85756m(nPS, this.nPl.llU, false);
            this.activity.finish();
            AppMethodBeat.m2505o(113623);
            return true;
        }
        AppMethodBeat.m2505o(113623);
        return false;
    }

    /* renamed from: a */
    private void m85730a(C43245f c43245f) {
        AppMethodBeat.m2504i(113624);
        if (this.nPW) {
            m85769xE(C4996ah.getResources().getColor(C25738R.color.f11906l8));
        } else {
            m85769xE(C4996ah.getResources().getColor(C25738R.color.f12206vy));
        }
        this.fMh = "";
        this.nPA = false;
        this.nPk.setVisibility(8);
        this.nPj.setVisibility(8);
        this.nPt.setVisibility(8);
        this.nPt.setSearchContent("");
        this.nPu.setVisibility(8);
        this.nPi.setVisibility(0);
        this.nPi.setAdapter(this.nPl);
        this.nPl.notifyDataSetChanged();
        this.nPv.setVisibility(0);
        aqX();
        if (c43245f != null) {
            this.nMj.getIController().setCenter(c43245f.bDG, c43245f.bDH);
            this.lat = c43245f.bDG;
            this.lng = c43245f.bDH;
            this.nPh.mo73945m(this.lat, this.lng);
            m85749hM(false);
        }
        AppMethodBeat.m2505o(113624);
    }

    public final void bKp() {
        AppMethodBeat.m2504i(113625);
        PickPoi pickPoi = this.nPh;
        pickPoi.nLu.clearAnimation();
        pickPoi.nLu.startAnimation(pickPoi.f17899De);
        this.lat = ((double) this.nMj.getMapCenterX()) / 1000000.0d;
        this.lng = ((double) this.nMj.getMapCenterY()) / 1000000.0d;
        this.nPh.mo73944l(this.lat, this.lng);
        this.nPo.setBackgroundResource(C25738R.drawable.b7x);
        if (this.nPI) {
            m85751iF(false);
        }
        m85749hM(false);
        this.nPV = false;
        this.nPl.nPV = false;
        AppMethodBeat.m2505o(113625);
    }

    /* renamed from: b */
    private String m85736b(double d, String str) {
        AppMethodBeat.m2504i(113626);
        String str2 = ((int) (d * 1000000.0d)) + "_" + ((int) (this.lng * 1000000.0d)) + "_" + str;
        AppMethodBeat.m2505o(113626);
        return str2;
    }

    private void bKq() {
        AppMethodBeat.m2504i(113627);
        if (this.nPh.nQh) {
            this.nPl.mo73953b(this.nPh.getPoi());
        }
        AppMethodBeat.m2505o(113627);
    }

    /* renamed from: hM */
    private void m85749hM(boolean z) {
        AppMethodBeat.m2504i(113628);
        if (this.nPx != null) {
            this.nPx.remove();
        }
        this.nJJ = m85736b(this.lat, this.fMh);
        if (this.nJJ.equals(this.nPl.key)) {
            C4990ab.m7417i("MicroMsg.MMPoiMapUI", "same key passed it ", this.nJJ);
            AppMethodBeat.m2505o(113628);
            return;
        }
        byte[] bArr = null;
        Object obj = 1;
        if (!this.nPA) {
            this.nPi.dzO();
            this.nPl.clean();
            this.nPl.mo73951Qb(this.nJJ);
            this.nPl.notifyDataSetChanged();
            bArr = this.nPl.buffer;
            this.nPn.setVisibility(0);
            m85752iG(false);
            bKq();
        } else if (this.nJK > 0 && z) {
            this.nPj.dzO();
            this.nPm.bKy();
            this.nPm.mo73951Qb(this.nJJ);
            this.nPm.kPJ = this.fMh;
            bArr = this.nPm.buffer;
        } else if (z) {
            obj = null;
        } else {
            this.nPj.dzO();
            this.nPm.clean();
            this.nPm.mo73951Qb(this.nJJ);
            this.nPm.kPJ = this.fMh;
            bArr = this.nPm.buffer;
            this.nPm.notifyDataSetChanged();
        }
        if (obj != null) {
            this.nPp = new C21170h(bArr, this.lat, this.lng, this.nPB == 0 ? 0 : 1, this.nPA ? 0 : 1, (double) this.nPL, (double) this.nPK, this.nJJ, this.fMh, z);
            C1720g.m3540Rg().mo14541a(this.nPp, 0);
            this.nPM++;
            if (this.nPP == -1) {
                this.nPP = System.currentTimeMillis();
            }
            AppMethodBeat.m2505o(113628);
            return;
        }
        C4990ab.m7417i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", Integer.valueOf(this.nJK));
        AppMethodBeat.m2505o(113628);
    }

    /* renamed from: m */
    private void m85756m(int i, int i2, boolean z) {
        String str;
        Object obj;
        Object obj2;
        AppMethodBeat.m2504i(113629);
        if (this.nPy == -85.0d || this.nPz == -1000.0d) {
            str = "null/null";
        } else {
            str = String.format("%f/%f", new Object[]{Double.valueOf(this.nPy), Double.valueOf(this.nPz)});
        }
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String obj3;
        if (z) {
            if (i2 >= 0 && this.nPm.llU < this.nPm.getCount()) {
                str2 = this.nPm.mo73961xG(this.nPm.llU).nQA;
                obj3 = this.nPm.mo73961xG(this.nPm.llU).nQq;
            }
            obj3 = str3;
        } else {
            if (this.nPl.llU < this.nPl.getCount()) {
                str2 = this.nPl.mo73961xG(this.nPl.llU).nQA;
                obj3 = this.nPl.mo73961xG(this.nPl.llU).nQq;
            }
            obj3 = str3;
        }
        if (i2 == 0 && C5046bo.isNullOrNil(r1) && this.nPl.getCount() > 1) {
            C4990ab.m7410d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str2 = this.nPl.mo73961xG(1).nQA;
        }
        if (this.nPl.getCount() <= 0 || z) {
            str3 = str4;
        } else {
            C4990ab.m7411d("MicroMsg.MMPoiMapUI", "set request id at index: %s", Integer.valueOf(i2));
            obj2 = this.nPl.mo73961xG(0).nQB;
        }
        if (i2 == 0 && !z && this.nPl.getCount() > 0) {
            int i3 = this.nPl.mo73961xG(0).nQC;
            if (i3 >= 0) {
                C4990ab.m7411d("MicroMsg.MMPoiMapUI", "change to search index: %s", Integer.valueOf(i3));
                i2 = i3;
            }
        }
        C4990ab.m7411d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s, requestId: %s", Integer.valueOf(i), Integer.valueOf(i2 + 1), Long.valueOf(this.nPP), Long.valueOf(this.nPO), Long.valueOf(this.nPN), Integer.valueOf(this.nPM), str, Integer.valueOf(this.nPQ), str2, obj2);
        C7060h.pYm.mo8381e(11135, Integer.valueOf(i), Integer.valueOf(i2 + 1), Long.valueOf(this.nPP), Long.valueOf(this.nPO), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.nPN), Integer.valueOf(this.nPM), str, obj3, Integer.valueOf(this.nPQ), str2, C1427q.m3026LK(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), obj2);
        AppMethodBeat.m2505o(113629);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(113630);
        super.onResume();
        C26443d.agz().mo44207b(this.ecy, true);
        C3339e c3339e = this.nPw;
        c3339e.nLP.mo44207b(c3339e.ecy, true);
        AppMethodBeat.m2505o(113630);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(113631);
        super.onPause();
        C26443d.agz().mo44208c(this.ecy);
        C3339e c3339e = this.nPw;
        c3339e.nLP.mo44208c(c3339e.ecy);
        AppMethodBeat.m2505o(113631);
    }

    /* renamed from: iG */
    private void m85752iG(boolean z) {
        AppMethodBeat.m2504i(113632);
        C4990ab.m7411d("MicroMsg.MMPoiMapUI", "enable send.. %b", Boolean.valueOf(z));
        this.nPr.setEnabled(z);
        findViewById(2131820958).setEnabled(z);
        this.nPs.setEnabled(z);
        AppMethodBeat.m2505o(113632);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(113633);
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(457, (C1202f) this);
        AppMethodBeat.m2505o(113633);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(113634);
        if (c1207m.getType() == 457) {
            if (i == 0 && i2 == 0) {
                this.nPp = null;
                C21170h c21170h = (C21170h) c1207m;
                if (c21170h.nJJ.equals(this.nJJ)) {
                    C4990ab.m7416i("MicroMsg.MMPoiMapUI", "isend " + c21170h.eTf + "searchId: " + c21170h.hlm);
                    if (this.nPN == -1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        this.nPO = currentTimeMillis;
                        this.nPN = currentTimeMillis;
                    } else {
                        this.nPO = System.currentTimeMillis();
                    }
                    this.nJK = c21170h.nJK;
                    if (this.nPA) {
                        this.nPk.setVisibility(8);
                        if (this.nPm.getCount() == 0 && c21170h.list != null && c21170h.list.size() == 0) {
                            this.nPu.setVisibility(0);
                            this.nPj.dzO();
                            AppMethodBeat.m2505o(113634);
                            return;
                        }
                        C4990ab.m7411d("MicroMsg.MMPoiMapUI", "search is first: %s", Boolean.valueOf(c21170h.isFirst()));
                        if (c21170h.isFirst()) {
                            this.nPm.nQk.clear();
                        }
                        this.nPm.mo73952a(c21170h.list, c21170h.nJI, c21170h.eTf, c21170h.nJJ);
                        if (this.nPm.eTf) {
                            this.nPj.dzO();
                            AppMethodBeat.m2505o(113634);
                            return;
                        }
                        this.nPj.dzN();
                        this.nPj.dzP();
                        AppMethodBeat.m2505o(113634);
                        return;
                    }
                    if (this.nPg != null) {
                        alt alt = (alt) c21170h.ehh.fsH.fsP;
                        PoiHeaderView poiHeaderView = this.nPg;
                        String str2 = alt.wdK;
                        String str3 = alt.wpY;
                        String str4 = alt.Url;
                        String XW = C43217c.m76863XW();
                        C4990ab.m7411d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", str3, str4);
                        poiHeaderView.nMe = str4;
                        poiHeaderView.nMf = "";
                        if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
                            poiHeaderView.setVisibility(8);
                            poiHeaderView.eku.setVisibility(8);
                            poiHeaderView.nMg.setVisibility(8);
                        } else {
                            poiHeaderView.setVisibility(0);
                            poiHeaderView.eku.setVisibility(0);
                            poiHeaderView.nMg.setVisibility(0);
                            poiHeaderView.eku.setText(str2);
                            SimpleImageView simpleImageView = poiHeaderView.nMg;
                            simpleImageView.imagePath = XW;
                            simpleImageView.url = str3;
                            simpleImageView.eTi = 0;
                            simpleImageView.eTj = 0;
                            Bitmap decodeFile;
                            if (str3 == null || str3.length() == 0) {
                                simpleImageView.setVisibility(8);
                            } else if (str3.startsWith("http")) {
                                decodeFile = BitmapFactory.decodeFile(simpleImageView.imagePath + C1178g.m2591x(str3.getBytes()));
                                if (decodeFile != null) {
                                    if (simpleImageView.eTi > 0 && simpleImageView.eTj > 0) {
                                        decodeFile = C5056d.m7615a(decodeFile, simpleImageView.eTi, simpleImageView.eTj, true, false);
                                    }
                                    simpleImageView.setImageBitmap(decodeFile);
                                } else {
                                    C7305d.post(new C34410a(str3, simpleImageView.handler), "SimpleImageView_download");
                                }
                            } else if (C5730e.m8628ct(str3)) {
                                if (simpleImageView.eTi <= 0 || simpleImageView.eTj <= 0) {
                                    decodeFile = C5056d.aml(str3);
                                } else {
                                    decodeFile = C5056d.m7659d(str3, simpleImageView.eTi, simpleImageView.eTj, true);
                                }
                                if (decodeFile == null) {
                                    simpleImageView.setVisibility(8);
                                } else {
                                    simpleImageView.setImageBitmap(decodeFile);
                                }
                            } else {
                                simpleImageView.setVisibility(8);
                            }
                        }
                    }
                    this.nPn.setVisibility(8);
                    m85752iG(true);
                    if (this.nPq != null) {
                        for (C43245f c43245f : c21170h.list) {
                            if (c43245f.nQp != null && c43245f.mName != null && c43245f.nQp.equals(this.nPq.nQp) && c43245f.mName.equals(this.nPq.mName)) {
                                c21170h.list.remove(c43245f);
                                break;
                            }
                        }
                        this.nPl.mo73953b(this.nPq);
                        this.nPq = null;
                        this.nPV = true;
                        this.nPl.nPV = true;
                    }
                    this.nPl.mo73952a(c21170h.list, c21170h.nJI, c21170h.eTf, c21170h.nJJ);
                    this.nPl.llU = 0;
                    this.nPl.notifyDataSetChanged();
                    if (this.nPl.eTf) {
                        this.nPi.dzO();
                    } else {
                        this.nPi.dzN();
                        this.nPi.dzP();
                        AppMethodBeat.m2505o(113634);
                        return;
                    }
                }
                C4990ab.m7416i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.nJJ + " " + c21170h.nJJ);
                AppMethodBeat.m2505o(113634);
                return;
            }
            AppMethodBeat.m2505o(113634);
            return;
        }
        AppMethodBeat.m2505o(113634);
    }

    /* renamed from: xF */
    public final void mo73950xF(int i) {
        AppMethodBeat.m2504i(113635);
        ((FrameLayout.LayoutParams) this.nPC.getLayoutParams()).topMargin = i;
        ((FrameLayout.LayoutParams) this.nPo.getLayoutParams()).topMargin = i - C4977b.m7371b(this.activity, 65.0f);
        int i2 = (i - this.nPF) / 2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nPJ.getLayoutParams();
        if (i == this.nPE) {
            layoutParams.topMargin = C4977b.m7371b(this.activity, -65.0f);
        } else if (i == this.nPD) {
            layoutParams.topMargin = 0;
        } else {
            layoutParams.topMargin = i2 + layoutParams.topMargin;
        }
        this.nPJ.requestLayout();
        this.nPF = i;
        this.nPC.requestLayout();
        this.nPo.requestLayout();
        AppMethodBeat.m2505o(113635);
    }

    public final int bKr() {
        AppMethodBeat.m2504i(113636);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.nPC.getLayoutParams();
        this.nPF = marginLayoutParams.topMargin;
        int i = marginLayoutParams.topMargin;
        AppMethodBeat.m2505o(113636);
        return i;
    }

    /* renamed from: f */
    static /* synthetic */ void m85746f(C46051c c46051c) {
        AppMethodBeat.m2504i(113638);
        C4990ab.m7416i("MicroMsg.MMPoiMapUI", "loadingmore");
        if (c46051c.nPp != null) {
            C4990ab.m7416i("MicroMsg.MMPoiMapUI", "scene is doing");
            AppMethodBeat.m2505o(113638);
            return;
        }
        byte[] bArr;
        if (c46051c.nPA) {
            if (c46051c.nPm.buffer == null) {
                C4990ab.m7416i("MicroMsg.MMPoiMapUI", "buffer is null");
                AppMethodBeat.m2505o(113638);
                return;
            }
            bArr = c46051c.nPm.buffer;
        } else if (c46051c.nPl.buffer == null) {
            C4990ab.m7416i("MicroMsg.MMPoiMapUI", "buffer is null");
            AppMethodBeat.m2505o(113638);
            return;
        } else {
            bArr = c46051c.nPl.buffer;
        }
        c46051c.nPp = new C21170h(bArr, c46051c.lat, c46051c.lng, c46051c.nPB == 0 ? 0 : 1, c46051c.nPA ? 0 : 1, (double) c46051c.nPL, (double) c46051c.nPK, c46051c.nJJ, c46051c.fMh, false);
        C1720g.m3540Rg().mo14541a(c46051c.nPp, 0);
        c46051c.nPM++;
        AppMethodBeat.m2505o(113638);
    }

    /* renamed from: m */
    static /* synthetic */ void m85757m(C46051c c46051c) {
        AppMethodBeat.m2504i(113639);
        c46051c.m85749hM(false);
        AppMethodBeat.m2505o(113639);
    }

    /* renamed from: p */
    static /* synthetic */ void m85760p(C46051c c46051c) {
        AppMethodBeat.m2504i(113641);
        int i = c46051c.nPl.llU;
        Intent intent = new Intent();
        LocationIntent locationIntent = new LocationIntent();
        if (i >= 0 && i < c46051c.nPl.getCount()) {
            C43245f xG = c46051c.nPl.mo73961xG(i);
            locationIntent.lat = xG.bDG;
            locationIntent.lng = xG.bDH;
            locationIntent.fBB = xG.nQz;
            locationIntent.eUu = xG.mName;
            locationIntent.label = xG.nQp;
            locationIntent.nJz = xG.nQq;
            locationIntent.vaP = xG.type;
            locationIntent.cED = c46051c.nMj.getZoomLevel();
            locationIntent.nJB = xG.nQq;
            switch (c46051c.type) {
                case 0:
                    i = nPR;
                    int i2 = c46051c.nPl.llU;
                    if (c46051c.nPV) {
                        i = nPT;
                    }
                    c46051c.m85756m(i, i2, false);
                    break;
            }
            intent.putExtra("KLocationIntent", locationIntent);
            c46051c.activity.setResult(-1, intent);
            c46051c.activity.finish();
        }
        AppMethodBeat.m2505o(113641);
    }

    /* renamed from: u */
    static /* synthetic */ void m85765u(C46051c c46051c) {
        AppMethodBeat.m2504i(113642);
        c46051c.m85769xE(C4996ah.getResources().getColor(C25738R.color.f12206vy));
        c46051c.nPA = true;
        c46051c.nPj.dzO();
        c46051c.nPj.setOnLoadMoreListener(new C460504());
        c46051c.nPj.setOnItemClickListener(new C123895());
        c46051c.nPj.setOnTouchListener(new C123906());
        c46051c.nPi.setVisibility(8);
        c46051c.nPj.setVisibility(0);
        c46051c.nPj.setAdapter(c46051c.nPm);
        c46051c.nPj.dzO();
        c46051c.nPv.setVisibility(8);
        c46051c.nPt.setVisibility(0);
        c46051c.nPt.setFocusChangeListener(new C123917());
        new C7306ak().post(new C33508());
        AppMethodBeat.m2505o(113642);
    }
}
