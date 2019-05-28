package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.location.ui.e;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.ActionBarSearchView;
import java.util.ArrayList;
import java.util.List;

public final class c extends b implements f {
    private static int nPR = 11;
    private static int nPS = 12;
    private static int nPT = 13;
    private static int nPU = 14;
    private com.tencent.mm.modelgeo.b.a ecy = new com.tencent.mm.modelgeo.b.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(113604);
            if (z) {
                if (c.this.nPy == -85.0d || c.this.nPz == -1000.0d) {
                    ab.d("MicroMsg.MMPoiMapUI", "first get location");
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_LAST_LOCATION_STRING, ((int) (1000000.0f * f2)) + "," + ((int) (1000000.0f * f)));
                    c.this.nPy = (double) f2;
                    c.this.nPz = (double) f;
                    c.this.nPK = f2;
                    c.this.nPL = f;
                    c.this.lat = c.this.nPy;
                    c.this.lng = c.this.nPz;
                    c.this.nPh.l(c.this.lat, c.this.lng);
                    c.this.nMj.getIController().animateTo(c.this.nPy, c.this.nPz, d.bJM());
                    if (!c.this.nPA) {
                        c.m(c.this);
                    }
                }
                AppMethodBeat.o(113604);
                return true;
            }
            if (!(c.this.nPX || com.tencent.mm.modelgeo.d.agA())) {
                c.this.nPX = true;
                h.a(c.this.activity, c.this.activity.getString(R.string.c9z), c.this.activity.getString(R.string.tz), c.this.activity.getString(R.string.ckr), c.this.activity.getString(R.string.or), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(113603);
                        com.tencent.mm.modelgeo.d.bX(c.this.activity);
                        AppMethodBeat.o(113603);
                    }
                }, null);
            }
            AppMethodBeat.o(113604);
            return false;
        }
    };
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
    private e nPl;
    private e nPm;
    private View nPn;
    private ImageButton nPo;
    private com.tencent.mm.plugin.location.model.h nPp = null;
    private f nPq = null;
    private View nPr;
    private ImageButton nPs;
    ActionBarSearchView nPt;
    private TextView nPu;
    private LinearLayout nPv;
    private e nPw;
    private com.tencent.mm.plugin.location.ui.g nPx;
    private double nPy = -85.0d;
    private double nPz = -1000.0d;
    private TextView titleView;

    class a extends TranslateAnimation {
        private List<View> nQd = new ArrayList();

        public a(float f) {
            super(0.0f, 0.0f, 0.0f, f);
            AppMethodBeat.i(113614);
            AppMethodBeat.o(113614);
        }

        public final a bKw() {
            AppMethodBeat.i(113615);
            setFillEnabled(true);
            setFillAfter(true);
            AppMethodBeat.o(113615);
            return this;
        }

        public final a dm(View view) {
            AppMethodBeat.i(113616);
            this.nQd.add(view);
            AppMethodBeat.o(113616);
            return this;
        }

        public final void bKx() {
            AppMethodBeat.i(113617);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nQd.size()) {
                    ((View) this.nQd.get(i2)).startAnimation(this);
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(113617);
                    return;
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar, int i, int i2, boolean z) {
        AppMethodBeat.i(113640);
        cVar.m(i, i2, z);
        AppMethodBeat.o(113640);
    }

    static /* synthetic */ void z(c cVar) {
        AppMethodBeat.i(113644);
        cVar.hM(true);
        AppMethodBeat.o(113644);
    }

    public c(Activity activity) {
        super(activity);
        AppMethodBeat.i(113618);
        AppMethodBeat.o(113618);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(113619);
        super.onCreate(bundle);
        g.Rg().a(457, (f) this);
        this.nPQ = (int) (System.currentTimeMillis() / 1000);
        this.nPv = (LinearLayout) findViewById(R.id.d80);
        this.titleView = (TextView) findViewById(R.id.d83);
        this.titleView.setText(getString(R.string.cnp));
        this.nPC = (RelativeLayout) findViewById(R.id.dna);
        this.nPi = (MMLoadMoreListView) this.activity.findViewById(R.id.dnc);
        this.nPj = (MMLoadMoreListView) this.activity.findViewById(R.id.dne);
        this.nPk = this.activity.findViewById(R.id.dng);
        this.nPu = (TextView) findViewById(R.id.dnf);
        this.nPo = (ImageButton) findViewById(R.id.c_m);
        this.nPo.setContentDescription(getString(R.string.cn6));
        this.nPg = (PoiHeaderView) findViewById(R.id.dnb);
        this.nMj.setBuiltInZoomControls(false);
        this.nOX = (FrameLayout) findViewById(R.id.c_j);
        this.nPw = new e(this.activity, this.nMj);
        this.nPx = new com.tencent.mm.plugin.location.ui.g(this.activity, this.nMj);
        this.nPh = new PickPoi(this.activity);
        this.nPh.setLocationArrow(R.drawable.bmf);
        this.nOX.addView(this.nPh);
        this.nPn = findViewById(R.id.dnd);
        this.lnh = (ImageView) this.activity.findViewById(R.id.d82);
        this.nPr = (LinearLayout) this.activity.findViewById(R.id.d87);
        this.nPr.setVisibility(0);
        switch (this.type) {
            case 0:
                ((TextView) findViewById(R.id.kh)).setText(R.string.cno);
                break;
            case 3:
                ((TextView) findViewById(R.id.kh)).setText(R.string.s1);
                break;
            case 8:
                ((TextView) findViewById(R.id.kh)).setText(R.string.qt);
                break;
        }
        this.nPs = (ImageButton) findViewById(R.id.d85);
        this.nPs.setContentDescription(getString(R.string.e0v));
        this.nPt = (ActionBarSearchView) findViewById(R.id.dn9);
        iG(false);
        this.nPl = new e(this.activity);
        this.nPm = new e(this.activity);
        this.nPm.gxV = true;
        this.nPm.llU = -1;
        this.nPh.setAdapter(this.nPl);
        this.nPi.setAdapter(this.nPl);
        this.nPi.setOnTouchListener(new OnTouchListener() {
            private float nPY;
            private short nPZ = (short) 0;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(113594);
                if (c.this.nPG) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            ab.d("MicroMsg.MMPoiMapUI", "newpoi action down %s", Float.valueOf(motionEvent.getRawY()));
                            this.nPY = motionEvent.getRawY();
                            c.this.nPH = false;
                            break;
                        case 1:
                            ab.d("MicroMsg.MMPoiMapUI", "newpoi action up ");
                            c.this.nPH = false;
                            break;
                        case 2:
                            ab.d("MicroMsg.MMPoiMapUI", "newpoi action move %s", Float.valueOf(motionEvent.getRawY()));
                            if (c.this.nPH) {
                                ab.d("MicroMsg.MMPoiMapUI", "newpoi blocked");
                                c.this.nPi.setSelection(0);
                            }
                            float rawY = this.nPY - motionEvent.getRawY();
                            if (Math.abs(rawY) < ((float) b.b(c.this.activity, 20.0f))) {
                                this.nPZ = (short) 0;
                            } else if (rawY > 0.0f) {
                                this.nPZ = (short) 1;
                            } else {
                                this.nPZ = (short) -1;
                            }
                            if ((c.this.bKr() <= c.this.nPE && this.nPZ == (short) 1) || ((!c.this.nPi.getScroll2Top() && this.nPZ == (short) -1 && c.this.bKr() < c.this.nPD) || (this.nPZ == (short) -1 && c.this.bKr() >= c.this.nPD))) {
                                AppMethodBeat.o(113594);
                                return false;
                            } else if (!c.this.nPG || this.nPZ == (short) 0) {
                                AppMethodBeat.o(113594);
                                return true;
                            } else {
                                ab.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", Short.valueOf(this.nPZ));
                                if (this.nPZ == (short) 1) {
                                    c.b(c.this, true);
                                    AppMethodBeat.o(113594);
                                    return false;
                                }
                                c.b(c.this, false);
                                AppMethodBeat.o(113594);
                                return false;
                            }
                    }
                    AppMethodBeat.o(113594);
                    return false;
                }
                AppMethodBeat.o(113594);
                return true;
            }
        });
        String str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_LAST_LOCATION_STRING, (Object) "");
        if (!bo.isNullOrNil(str) && (this.nPy == -85.0d || this.nPz == -1000.0d)) {
            String[] split = str.split(",");
            ab.i("MicroMsg.MMPoiMapUI", "lastlocationinfo ".concat(String.valueOf(str)));
            if (split.length == 2) {
                this.nMj.getIController().setCenter((double) ((float) ((((double) bo.ank(split[0])) * 1.0d) / 1000000.0d)), (double) ((float) ((((double) bo.ank(split[1])) * 1.0d) / 1000000.0d)));
            }
        }
        this.nPi.setOnLoadMoreListener(new com.tencent.mm.ui.base.MMLoadMoreListView.a() {
            public final void KB() {
                AppMethodBeat.i(113605);
                c.f(c.this);
                AppMethodBeat.o(113605);
            }
        });
        this.nPo.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113606);
                ab.d("MicroMsg.MMPoiMapUI", "click lat: %s, lng: %s", Double.valueOf(c.this.nPy), Double.valueOf(c.this.nPz));
                if (c.this.nPy == -85.0d || c.this.nPz == -1000.0d) {
                    ab.i("MicroMsg.MMPoiMapUI", "invalid lat lng");
                    AppMethodBeat.o(113606);
                    return;
                }
                c.this.nMj.getIController().animateTo(c.this.nPy, c.this.nPz);
                c.this.lat = c.this.nPy;
                c.this.lng = c.this.nPz;
                c.this.nPh.l(c.this.lat, c.this.lng);
                c.this.nPo.setBackgroundResource(R.drawable.b7y);
                c.this.nPo.setEnabled(true);
                c.m(c.this);
                c.this.nPV = false;
                c.this.nPl.nPV = false;
                AppMethodBeat.o(113606);
            }
        });
        this.lnh.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113607);
                c.a(c.this, c.nPS, c.this.nPl.llU, false);
                c.this.aqX();
                c.this.activity.finish();
                AppMethodBeat.o(113607);
            }
        });
        this.nPr.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113608);
                c.p(c.this);
                AppMethodBeat.o(113608);
            }
        });
        this.nPi.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(113609);
                ab.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", Integer.valueOf(i));
                if (!c.this.nPA) {
                    if (i >= c.this.nPl.getCount()) {
                        ab.i("MicroMsg.MMPoiMapUI", "wrong position");
                        AppMethodBeat.o(113609);
                        return;
                    }
                    f xG = c.this.nPl.xG(i);
                    if (xG.type == 0) {
                        com.tencent.mm.plugin.location.ui.g r = c.this.nPx;
                        double d = xG.bDG;
                        double d2 = xG.bDH;
                        if (r.nLR) {
                            r.nMj.updateLocaitonPinLayout(r, d, d2);
                        } else {
                            r.nLR = true;
                            r.nMj.addPinView(r, d, d2);
                        }
                        c.this.nPo.setBackgroundResource(R.drawable.b7x);
                    } else {
                        c.this.nPx.remove();
                        c.this.nPo.setEnabled(true);
                    }
                    c.this.nMj.getIController().animateTo(xG.bDG, xG.bDH);
                    c.this.nPl.llU = i;
                    c.this.nPl.notifyDataSetChanged();
                }
                c.this.nPV = false;
                AppMethodBeat.o(113609);
            }
        });
        this.nPs.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113612);
                if (!c.this.nPA) {
                    c.u(c.this);
                }
                c.this.nPm.clean();
                c.this.nPj.setAdapter(c.this.nPm);
                c.this.nPm.notifyDataSetChanged();
                c.this.nPk.setVisibility(8);
                AppMethodBeat.o(113612);
            }
        });
        this.nPt.setHint(getString(R.string.cnl));
        this.nPt.qN(false);
        this.nPt.setBackClickCallback(new com.tencent.mm.ui.tools.ActionBarSearchView.a() {
            public final void bKv() {
                AppMethodBeat.i(113613);
                ab.d("MicroMsg.MMPoiMapUI", "back pressed");
                c.a(c.this, c.nPU, c.this.nPm.llU, true);
                c.a(c.this, null);
                AppMethodBeat.o(113613);
            }
        });
        this.nPt.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(113595);
                ab.d("MicroMsg.MMPoiMapUI", "keyboard action");
                if (3 == i) {
                    c.m(c.this);
                }
                AppMethodBeat.o(113595);
                return false;
            }
        });
        this.nPt.setCallBack(new ActionBarSearchView.b() {
            public final void bKt() {
            }

            public final void Qa(String str) {
                AppMethodBeat.i(113596);
                ab.d("MicroMsg.MMPoiMapUI", "searchText: %s", str);
                c.this.fMh = str;
                c.this.nPj.dzO();
                c.this.nPu.setVisibility(8);
                if (bo.isNullOrNil(str)) {
                    c.this.nPm.clean();
                    c.this.nPm.notifyDataSetChanged();
                    AppMethodBeat.o(113596);
                    return;
                }
                c.z(c.this);
                AppMethodBeat.o(113596);
            }

            public final void apq() {
                AppMethodBeat.i(113597);
                ab.d("MicroMsg.MMPoiMapUI", "clear btn click");
                c.this.nPm.clean();
                c.this.nPm.notifyDataSetChanged();
                AppMethodBeat.o(113597);
            }

            public final void bKu() {
            }
        });
        this.nPJ = (FrameLayout) findViewById(R.id.dn_);
        xE(ah.getResources().getColor(R.color.vy));
        this.nPD = b.b(this.activity, 280.0f);
        this.nPE = b.b(this.activity, 150.0f);
        int ge = com.tencent.mm.bz.a.ge(this.activity);
        int identifier = ah.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            identifier = ah.getResources().getDimensionPixelSize(identifier);
        } else {
            identifier = 0;
        }
        ge = ((ge - this.nPE) - identifier) - com.tencent.mm.bz.a.al(this.activity, R.dimen.fd);
        if (ge > com.tencent.mm.bz.a.al(this.activity, R.dimen.a83)) {
            ab.i("MicroMsg.MMPoiMapUI", "reset listview height: %s, statusBar: %s, actionBar: %s", Integer.valueOf(ge), Integer.valueOf(identifier), Integer.valueOf(r3));
            LayoutParams layoutParams = this.nPC.getLayoutParams();
            layoutParams.height = ge;
            this.nPC.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(113619);
    }

    public final com.tencent.mm.plugin.k.d bKo() {
        AppMethodBeat.i(113620);
        com.tencent.mm.plugin.k.d dVar = (com.tencent.mm.plugin.k.d) this.activity.findViewById(R.id.be);
        AppMethodBeat.o(113620);
        return dVar;
    }

    private void xE(int i) {
        AppMethodBeat.i(113621);
        this.nPv.setBackgroundColor(i);
        this.nPt.setBackgroundColor(i);
        Boolean valueOf = Boolean.valueOf(com.tencent.mm.ui.ah.Nw(i));
        if (valueOf.booleanValue()) {
            this.lnh.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            this.nPs.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            this.titleView.setTextColor(ah.getResources().getColor(R.color.a6a));
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = this.activity.getWindow();
            window.clearFlags(201326592);
            window.addFlags(j.INVALID_ID);
            if (VERSION.SDK_INT < 23 || com.tencent.mm.compatible.util.h.Mt()) {
                i = VERSION.SDK_INT >= 21 ? com.tencent.mm.ui.ah.s(this.activity.getResources().getColor(R.color.a1h), i) : 0;
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
        AppMethodBeat.o(113621);
    }

    private void iF(final boolean z) {
        a aVar;
        a aVar2;
        AppMethodBeat.i(113622);
        this.nPG = false;
        if (z) {
            aVar = new a((float) (-(bKr() - this.nPE)));
            aVar2 = new a((float) ((-(bKr() - this.nPE)) / 2));
        } else {
            aVar = new a((float) (this.nPD - bKr()));
            aVar2 = new a((float) ((this.nPD - bKr()) / 2));
        }
        AnonymousClass15 anonymousClass15 = new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(113610);
                ab.d("MicroMsg.MMPoiMapUI", "newpoi start animation %s", Long.valueOf(System.currentTimeMillis()));
                c.this.nPG = false;
                c.this.nPH = true;
                AppMethodBeat.o(113610);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(113611);
                c.this.nPG = true;
                if (z) {
                    c.this.xF(c.this.nPE);
                    c.this.nPI = true;
                } else {
                    c.this.xF(c.this.nPD);
                    c.this.nPI = false;
                }
                c.this.nPC.clearAnimation();
                c.this.nPo.clearAnimation();
                c.this.nPJ.clearAnimation();
                c.this.nPi.clearFocus();
                AppMethodBeat.o(113611);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        };
        aVar.setDuration(200);
        aVar = aVar.bKw();
        aVar.setAnimationListener(anonymousClass15);
        aVar.dm(this.nPC).dm(this.nPo).bKx();
        aVar2.setDuration(200);
        aVar2.bKw().dm(this.nPJ).bKx();
        AppMethodBeat.o(113622);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(113623);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ab.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent");
            if (this.nPA) {
                a(null);
                m(nPU, this.nPm.llU, true);
                AppMethodBeat.o(113623);
                return false;
            }
            m(nPS, this.nPl.llU, false);
            this.activity.finish();
            AppMethodBeat.o(113623);
            return true;
        }
        AppMethodBeat.o(113623);
        return false;
    }

    private void a(f fVar) {
        AppMethodBeat.i(113624);
        if (this.nPW) {
            xE(ah.getResources().getColor(R.color.l8));
        } else {
            xE(ah.getResources().getColor(R.color.vy));
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
        if (fVar != null) {
            this.nMj.getIController().setCenter(fVar.bDG, fVar.bDH);
            this.lat = fVar.bDG;
            this.lng = fVar.bDH;
            this.nPh.m(this.lat, this.lng);
            hM(false);
        }
        AppMethodBeat.o(113624);
    }

    public final void bKp() {
        AppMethodBeat.i(113625);
        PickPoi pickPoi = this.nPh;
        pickPoi.nLu.clearAnimation();
        pickPoi.nLu.startAnimation(pickPoi.De);
        this.lat = ((double) this.nMj.getMapCenterX()) / 1000000.0d;
        this.lng = ((double) this.nMj.getMapCenterY()) / 1000000.0d;
        this.nPh.l(this.lat, this.lng);
        this.nPo.setBackgroundResource(R.drawable.b7x);
        if (this.nPI) {
            iF(false);
        }
        hM(false);
        this.nPV = false;
        this.nPl.nPV = false;
        AppMethodBeat.o(113625);
    }

    private String b(double d, String str) {
        AppMethodBeat.i(113626);
        String str2 = ((int) (d * 1000000.0d)) + "_" + ((int) (this.lng * 1000000.0d)) + "_" + str;
        AppMethodBeat.o(113626);
        return str2;
    }

    private void bKq() {
        AppMethodBeat.i(113627);
        if (this.nPh.nQh) {
            this.nPl.b(this.nPh.getPoi());
        }
        AppMethodBeat.o(113627);
    }

    private void hM(boolean z) {
        AppMethodBeat.i(113628);
        if (this.nPx != null) {
            this.nPx.remove();
        }
        this.nJJ = b(this.lat, this.fMh);
        if (this.nJJ.equals(this.nPl.key)) {
            ab.i("MicroMsg.MMPoiMapUI", "same key passed it ", this.nJJ);
            AppMethodBeat.o(113628);
            return;
        }
        byte[] bArr = null;
        Object obj = 1;
        if (!this.nPA) {
            this.nPi.dzO();
            this.nPl.clean();
            this.nPl.Qb(this.nJJ);
            this.nPl.notifyDataSetChanged();
            bArr = this.nPl.buffer;
            this.nPn.setVisibility(0);
            iG(false);
            bKq();
        } else if (this.nJK > 0 && z) {
            this.nPj.dzO();
            this.nPm.bKy();
            this.nPm.Qb(this.nJJ);
            this.nPm.kPJ = this.fMh;
            bArr = this.nPm.buffer;
        } else if (z) {
            obj = null;
        } else {
            this.nPj.dzO();
            this.nPm.clean();
            this.nPm.Qb(this.nJJ);
            this.nPm.kPJ = this.fMh;
            bArr = this.nPm.buffer;
            this.nPm.notifyDataSetChanged();
        }
        if (obj != null) {
            this.nPp = new com.tencent.mm.plugin.location.model.h(bArr, this.lat, this.lng, this.nPB == 0 ? 0 : 1, this.nPA ? 0 : 1, (double) this.nPL, (double) this.nPK, this.nJJ, this.fMh, z);
            g.Rg().a(this.nPp, 0);
            this.nPM++;
            if (this.nPP == -1) {
                this.nPP = System.currentTimeMillis();
            }
            AppMethodBeat.o(113628);
            return;
        }
        ab.i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", Integer.valueOf(this.nJK));
        AppMethodBeat.o(113628);
    }

    private void m(int i, int i2, boolean z) {
        String str;
        Object obj;
        Object obj2;
        AppMethodBeat.i(113629);
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
                str2 = this.nPm.xG(this.nPm.llU).nQA;
                obj3 = this.nPm.xG(this.nPm.llU).nQq;
            }
            obj3 = str3;
        } else {
            if (this.nPl.llU < this.nPl.getCount()) {
                str2 = this.nPl.xG(this.nPl.llU).nQA;
                obj3 = this.nPl.xG(this.nPl.llU).nQq;
            }
            obj3 = str3;
        }
        if (i2 == 0 && bo.isNullOrNil(r1) && this.nPl.getCount() > 1) {
            ab.d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str2 = this.nPl.xG(1).nQA;
        }
        if (this.nPl.getCount() <= 0 || z) {
            str3 = str4;
        } else {
            ab.d("MicroMsg.MMPoiMapUI", "set request id at index: %s", Integer.valueOf(i2));
            obj2 = this.nPl.xG(0).nQB;
        }
        if (i2 == 0 && !z && this.nPl.getCount() > 0) {
            int i3 = this.nPl.xG(0).nQC;
            if (i3 >= 0) {
                ab.d("MicroMsg.MMPoiMapUI", "change to search index: %s", Integer.valueOf(i3));
                i2 = i3;
            }
        }
        ab.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s, requestId: %s", Integer.valueOf(i), Integer.valueOf(i2 + 1), Long.valueOf(this.nPP), Long.valueOf(this.nPO), Long.valueOf(this.nPN), Integer.valueOf(this.nPM), str, Integer.valueOf(this.nPQ), str2, obj2);
        com.tencent.mm.plugin.report.service.h.pYm.e(11135, Integer.valueOf(i), Integer.valueOf(i2 + 1), Long.valueOf(this.nPP), Long.valueOf(this.nPO), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.nPN), Integer.valueOf(this.nPM), str, obj3, Integer.valueOf(this.nPQ), str2, q.LK(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), obj2);
        AppMethodBeat.o(113629);
    }

    public final void onResume() {
        AppMethodBeat.i(113630);
        super.onResume();
        com.tencent.mm.modelgeo.d.agz().b(this.ecy, true);
        e eVar = this.nPw;
        eVar.nLP.b(eVar.ecy, true);
        AppMethodBeat.o(113630);
    }

    public final void onPause() {
        AppMethodBeat.i(113631);
        super.onPause();
        com.tencent.mm.modelgeo.d.agz().c(this.ecy);
        e eVar = this.nPw;
        eVar.nLP.c(eVar.ecy);
        AppMethodBeat.o(113631);
    }

    private void iG(boolean z) {
        AppMethodBeat.i(113632);
        ab.d("MicroMsg.MMPoiMapUI", "enable send.. %b", Boolean.valueOf(z));
        this.nPr.setEnabled(z);
        findViewById(R.id.kh).setEnabled(z);
        this.nPs.setEnabled(z);
        AppMethodBeat.o(113632);
    }

    public final void onDestroy() {
        AppMethodBeat.i(113633);
        super.onDestroy();
        g.Rg().b(457, (f) this);
        AppMethodBeat.o(113633);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(113634);
        if (mVar.getType() == 457) {
            if (i == 0 && i2 == 0) {
                this.nPp = null;
                com.tencent.mm.plugin.location.model.h hVar = (com.tencent.mm.plugin.location.model.h) mVar;
                if (hVar.nJJ.equals(this.nJJ)) {
                    ab.i("MicroMsg.MMPoiMapUI", "isend " + hVar.eTf + "searchId: " + hVar.hlm);
                    if (this.nPN == -1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        this.nPO = currentTimeMillis;
                        this.nPN = currentTimeMillis;
                    } else {
                        this.nPO = System.currentTimeMillis();
                    }
                    this.nJK = hVar.nJK;
                    if (this.nPA) {
                        this.nPk.setVisibility(8);
                        if (this.nPm.getCount() == 0 && hVar.list != null && hVar.list.size() == 0) {
                            this.nPu.setVisibility(0);
                            this.nPj.dzO();
                            AppMethodBeat.o(113634);
                            return;
                        }
                        ab.d("MicroMsg.MMPoiMapUI", "search is first: %s", Boolean.valueOf(hVar.isFirst()));
                        if (hVar.isFirst()) {
                            this.nPm.nQk.clear();
                        }
                        this.nPm.a(hVar.list, hVar.nJI, hVar.eTf, hVar.nJJ);
                        if (this.nPm.eTf) {
                            this.nPj.dzO();
                            AppMethodBeat.o(113634);
                            return;
                        }
                        this.nPj.dzN();
                        this.nPj.dzP();
                        AppMethodBeat.o(113634);
                        return;
                    }
                    if (this.nPg != null) {
                        alt alt = (alt) hVar.ehh.fsH.fsP;
                        PoiHeaderView poiHeaderView = this.nPg;
                        String str2 = alt.wdK;
                        String str3 = alt.wpY;
                        String str4 = alt.Url;
                        String XW = com.tencent.mm.plugin.i.c.XW();
                        ab.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", str3, str4);
                        poiHeaderView.nMe = str4;
                        poiHeaderView.nMf = "";
                        if (bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
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
                                decodeFile = BitmapFactory.decodeFile(simpleImageView.imagePath + com.tencent.mm.a.g.x(str3.getBytes()));
                                if (decodeFile != null) {
                                    if (simpleImageView.eTi > 0 && simpleImageView.eTj > 0) {
                                        decodeFile = com.tencent.mm.sdk.platformtools.d.a(decodeFile, simpleImageView.eTi, simpleImageView.eTj, true, false);
                                    }
                                    simpleImageView.setImageBitmap(decodeFile);
                                } else {
                                    com.tencent.mm.sdk.g.d.post(new com.tencent.mm.plugin.location.ui.SimpleImageView.a(str3, simpleImageView.handler), "SimpleImageView_download");
                                }
                            } else if (com.tencent.mm.vfs.e.ct(str3)) {
                                if (simpleImageView.eTi <= 0 || simpleImageView.eTj <= 0) {
                                    decodeFile = com.tencent.mm.sdk.platformtools.d.aml(str3);
                                } else {
                                    decodeFile = com.tencent.mm.sdk.platformtools.d.d(str3, simpleImageView.eTi, simpleImageView.eTj, true);
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
                    iG(true);
                    if (this.nPq != null) {
                        for (f fVar : hVar.list) {
                            if (fVar.nQp != null && fVar.mName != null && fVar.nQp.equals(this.nPq.nQp) && fVar.mName.equals(this.nPq.mName)) {
                                hVar.list.remove(fVar);
                                break;
                            }
                        }
                        this.nPl.b(this.nPq);
                        this.nPq = null;
                        this.nPV = true;
                        this.nPl.nPV = true;
                    }
                    this.nPl.a(hVar.list, hVar.nJI, hVar.eTf, hVar.nJJ);
                    this.nPl.llU = 0;
                    this.nPl.notifyDataSetChanged();
                    if (this.nPl.eTf) {
                        this.nPi.dzO();
                    } else {
                        this.nPi.dzN();
                        this.nPi.dzP();
                        AppMethodBeat.o(113634);
                        return;
                    }
                }
                ab.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.nJJ + " " + hVar.nJJ);
                AppMethodBeat.o(113634);
                return;
            }
            AppMethodBeat.o(113634);
            return;
        }
        AppMethodBeat.o(113634);
    }

    public final void xF(int i) {
        AppMethodBeat.i(113635);
        ((FrameLayout.LayoutParams) this.nPC.getLayoutParams()).topMargin = i;
        ((FrameLayout.LayoutParams) this.nPo.getLayoutParams()).topMargin = i - b.b(this.activity, 65.0f);
        int i2 = (i - this.nPF) / 2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nPJ.getLayoutParams();
        if (i == this.nPE) {
            layoutParams.topMargin = b.b(this.activity, -65.0f);
        } else if (i == this.nPD) {
            layoutParams.topMargin = 0;
        } else {
            layoutParams.topMargin = i2 + layoutParams.topMargin;
        }
        this.nPJ.requestLayout();
        this.nPF = i;
        this.nPC.requestLayout();
        this.nPo.requestLayout();
        AppMethodBeat.o(113635);
    }

    public final int bKr() {
        AppMethodBeat.i(113636);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.nPC.getLayoutParams();
        this.nPF = marginLayoutParams.topMargin;
        int i = marginLayoutParams.topMargin;
        AppMethodBeat.o(113636);
        return i;
    }

    static /* synthetic */ void f(c cVar) {
        AppMethodBeat.i(113638);
        ab.i("MicroMsg.MMPoiMapUI", "loadingmore");
        if (cVar.nPp != null) {
            ab.i("MicroMsg.MMPoiMapUI", "scene is doing");
            AppMethodBeat.o(113638);
            return;
        }
        byte[] bArr;
        if (cVar.nPA) {
            if (cVar.nPm.buffer == null) {
                ab.i("MicroMsg.MMPoiMapUI", "buffer is null");
                AppMethodBeat.o(113638);
                return;
            }
            bArr = cVar.nPm.buffer;
        } else if (cVar.nPl.buffer == null) {
            ab.i("MicroMsg.MMPoiMapUI", "buffer is null");
            AppMethodBeat.o(113638);
            return;
        } else {
            bArr = cVar.nPl.buffer;
        }
        cVar.nPp = new com.tencent.mm.plugin.location.model.h(bArr, cVar.lat, cVar.lng, cVar.nPB == 0 ? 0 : 1, cVar.nPA ? 0 : 1, (double) cVar.nPL, (double) cVar.nPK, cVar.nJJ, cVar.fMh, false);
        g.Rg().a(cVar.nPp, 0);
        cVar.nPM++;
        AppMethodBeat.o(113638);
    }

    static /* synthetic */ void m(c cVar) {
        AppMethodBeat.i(113639);
        cVar.hM(false);
        AppMethodBeat.o(113639);
    }

    static /* synthetic */ void p(c cVar) {
        AppMethodBeat.i(113641);
        int i = cVar.nPl.llU;
        Intent intent = new Intent();
        LocationIntent locationIntent = new LocationIntent();
        if (i >= 0 && i < cVar.nPl.getCount()) {
            f xG = cVar.nPl.xG(i);
            locationIntent.lat = xG.bDG;
            locationIntent.lng = xG.bDH;
            locationIntent.fBB = xG.nQz;
            locationIntent.eUu = xG.mName;
            locationIntent.label = xG.nQp;
            locationIntent.nJz = xG.nQq;
            locationIntent.vaP = xG.type;
            locationIntent.cED = cVar.nMj.getZoomLevel();
            locationIntent.nJB = xG.nQq;
            switch (cVar.type) {
                case 0:
                    i = nPR;
                    int i2 = cVar.nPl.llU;
                    if (cVar.nPV) {
                        i = nPT;
                    }
                    cVar.m(i, i2, false);
                    break;
            }
            intent.putExtra("KLocationIntent", locationIntent);
            cVar.activity.setResult(-1, intent);
            cVar.activity.finish();
        }
        AppMethodBeat.o(113641);
    }

    static /* synthetic */ void u(c cVar) {
        AppMethodBeat.i(113642);
        cVar.xE(ah.getResources().getColor(R.color.vy));
        cVar.nPA = true;
        cVar.nPj.dzO();
        cVar.nPj.setOnLoadMoreListener(new com.tencent.mm.ui.base.MMLoadMoreListView.a() {
            public final void KB() {
                AppMethodBeat.i(113598);
                c.f(c.this);
                AppMethodBeat.o(113598);
            }
        });
        cVar.nPj.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(113599);
                f fVar = null;
                if (i >= 0 && i < c.this.nPm.getCount()) {
                    fVar = c.this.nPm.xG(i);
                }
                c.this.nPq = fVar;
                c.a(c.this, fVar);
                AppMethodBeat.o(113599);
            }
        });
        cVar.nPj.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(113600);
                c.this.aqX();
                AppMethodBeat.o(113600);
                return false;
            }
        });
        cVar.nPi.setVisibility(8);
        cVar.nPj.setVisibility(0);
        cVar.nPj.setAdapter(cVar.nPm);
        cVar.nPj.dzO();
        cVar.nPv.setVisibility(8);
        cVar.nPt.setVisibility(0);
        cVar.nPt.setFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(113601);
                if (z) {
                    c.this.showVKB();
                }
                AppMethodBeat.o(113601);
            }
        });
        new ak().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(113602);
                c.this.nPt.dJt();
                c.this.showVKB();
                AppMethodBeat.o(113602);
            }
        });
        AppMethodBeat.o(113642);
    }
}
