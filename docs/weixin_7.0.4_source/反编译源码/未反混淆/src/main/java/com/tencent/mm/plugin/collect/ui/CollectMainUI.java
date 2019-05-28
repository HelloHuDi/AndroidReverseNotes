package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.collect.model.t;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.oy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(0)
public class CollectMainUI extends WalletPreferenceUI implements com.tencent.mm.plugin.collect.model.d.a, com.tencent.mm.sdk.platformtools.bc.a {
    private static int kGN;
    private static int kHh = -1;
    private static int kHi = -1;
    private static int kHj = -1;
    private static int kHk = -1;
    private int cQG;
    private f iFE = null;
    private Vibrator iVt;
    protected ScrollView kEu = null;
    private long kFU;
    protected TextView kGA;
    private RelativeLayout kGB;
    private Bitmap kGC = null;
    protected String kGD = null;
    protected String kGE = null;
    protected String kGF = null;
    private String kGG = null;
    private List<a> kGH = new LinkedList();
    private double kGI;
    private String kGJ = null;
    private String kGK = null;
    protected boolean kGL = false;
    private long kGM;
    private View kGO;
    private b kGP = new b(this, (byte) 0);
    private SpannableStringBuilder kGQ;
    private SpannableStringBuilder kGR;
    private com.tencent.mm.plugin.collect.model.f kGS;
    private int kGT = 0;
    private String kGU;
    private String kGV;
    private String kGW;
    protected CdnImageView kGX;
    protected TextView kGY;
    protected TextView kGZ;
    private ImageView kGi = null;
    private TextView kGj = null;
    private WalletTextView kGk = null;
    private TextView kGl = null;
    private TextView kGm = null;
    private TextView kGn = null;
    private RelativeLayout kGo = null;
    private View kGp = null;
    private TextView kGq = null;
    private Dialog kGr = null;
    private View kGs = null;
    private View kGt = null;
    private boolean kGu = false;
    private View kGv = null;
    private ImageView kGw;
    private TextView kGx;
    private TextView kGy;
    private TextView kGz;
    protected ImageView kHa;
    protected ViewGroup kHb;
    protected View kHc;
    private boolean kHd = false;
    private int kHe = 0;
    private bbj kHf;
    private com.tencent.mm.platformtools.x.a kHg = new com.tencent.mm.platformtools.x.a() {
        public final void m(String str, Bitmap bitmap) {
            AppMethodBeat.i(41264);
            if (str == null || CollectMainUI.this.kGW == null) {
                AppMethodBeat.o(41264);
                return;
            }
            if (str.equals(CollectMainUI.this.kGW)) {
                ab.i("MicroMsg.CollectMainUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", CollectMainUI.this.kGW, str);
                CollectMainUI.this.bhs();
            }
            AppMethodBeat.o(41264);
        }
    };

    class a extends t {
        public boolean jYD = false;

        public a(t tVar) {
            this.username = tVar.username;
            this.cAa = tVar.cAa;
            this.kCJ = tVar.kCJ;
            this.timestamp = tVar.timestamp;
            this.scene = tVar.scene;
            this.status = tVar.status;
            this.eoz = tVar.eoz;
        }
    }

    class b {
        boolean kHw;
        LinkedList<a> kHx;

        private b() {
            AppMethodBeat.i(41283);
            this.kHx = new LinkedList();
            AppMethodBeat.o(41283);
        }

        /* synthetic */ b(CollectMainUI collectMainUI, byte b) {
            this();
        }

        private int tK(int i) {
            AppMethodBeat.i(41284);
            float height = 0.0f + ((float) (CollectMainUI.this.kGs.getHeight() / 2));
            if (CollectMainUI.this.kGp.getVisibility() == 0) {
                height += (float) CollectMainUI.this.kGp.getHeight();
            }
            height += (float) ((CollectMainUI.kHi * i) + (CollectMainUI.kHi / 2));
            int[] iArr = new int[2];
            CollectMainUI.this.kGs.getLocationInWindow(iArr);
            int bhA = (int) (height + ((float) (iArr[1] - CollectMainUI.kGN)));
            AppMethodBeat.o(41284);
            return bhA;
        }

        public final void bhF() {
            AppMethodBeat.i(41285);
            if (this.kHw) {
                ab.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.kHx.size());
            } else if (!this.kHx.isEmpty()) {
                a((a) this.kHx.poll());
                AppMethodBeat.o(41285);
                return;
            }
            AppMethodBeat.o(41285);
        }

        private void a(final a aVar) {
            AppMethodBeat.i(41286);
            this.kHw = true;
            CollectMainUI.l(CollectMainUI.this);
            CollectMainUI.this.kGv.setLayoutParams(new LayoutParams(CollectMainUI.this.kGs.getWidth(), CollectMainUI.this.kGs.getHeight()));
            if (CollectMainUI.this.kGL) {
                CollectMainUI.this.kGv.setPadding(0, CollectMainUI.kHk, 0, 0);
            } else {
                CollectMainUI.this.kGv.setPadding(0, CollectMainUI.kHj, 0, 0);
            }
            CollectMainUI.this.kGx.setText(j.b(CollectMainUI.this.mController.ylL, aVar.eoz, CollectMainUI.this.kGx.getTextSize()));
            com.tencent.mm.pluginsdk.ui.a.b.b(CollectMainUI.this.kGw, aVar.username);
            CollectMainUI.this.kGy.setText(e.e(aVar.kCJ, aVar.cuZ));
            CollectMainUI.this.kGv.setVisibility(0);
            final AnimationSet animationSet = new AnimationSet(false);
            animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f));
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < CollectMainUI.this.kGH.size()) {
                    if (((a) CollectMainUI.this.kGH.get(i3)).cAa.equals(aVar.cAa)) {
                        i = i3;
                    }
                    i2 = i3 + 1;
                } else {
                    animationSet.addAnimation(new TranslateAnimation(0.0f, (float) CollectMainUI.kHh, 0.0f, (float) tK(i)));
                    animationSet.setDuration(300);
                    animationSet.setInterpolator(new DecelerateInterpolator());
                    animationSet.setAnimationListener(new AnimationListener() {
                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(41280);
                            CollectMainUI.this.kGv.setVisibility(8);
                            ab.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animation end. TransId=" + aVar.cAa);
                            for (int i = 0; i < CollectMainUI.this.kGH.size(); i++) {
                                if (((a) CollectMainUI.this.kGH.get(i)).cAa.equals(aVar.cAa)) {
                                    ((a) CollectMainUI.this.kGH.get(i)).jYD = true;
                                    ab.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Update msg animation status. TransId=" + aVar.cAa);
                                    break;
                                }
                            }
                            CollectMainUI.l(CollectMainUI.this);
                            b.this.kHw = false;
                            b.this.bhF();
                            AppMethodBeat.o(41280);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationStart(Animation animation) {
                        }
                    });
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setDuration(300);
                    scaleAnimation.setInterpolator(new LinearInterpolator());
                    scaleAnimation.setAnimationListener(new AnimationListener() {
                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(41281);
                            animationSet.setStartOffset(1700);
                            CollectMainUI.this.kGv.startAnimation(animationSet);
                            AppMethodBeat.o(41281);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationStart(Animation animation) {
                            AppMethodBeat.i(41282);
                            CollectMainUI.this.kGv.setVisibility(0);
                            AppMethodBeat.o(41282);
                        }
                    });
                    CollectMainUI.this.kGv.startAnimation(scaleAnimation);
                    AppMethodBeat.o(41286);
                    return;
                }
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CollectMainUI() {
        AppMethodBeat.i(41287);
        AppMethodBeat.o(41287);
    }

    static /* synthetic */ bbc bhD() {
        AppMethodBeat.i(41317);
        bbc bhx = bhx();
        AppMethodBeat.o(41317);
        return bhx;
    }

    static /* synthetic */ List bhE() {
        AppMethodBeat.i(41318);
        List bhy = bhy();
        AppMethodBeat.o(41318);
        return bhy;
    }

    static /* synthetic */ void c(CollectMainUI collectMainUI) {
        AppMethodBeat.i(41312);
        collectMainUI.fX(false);
        AppMethodBeat.o(41312);
    }

    static /* synthetic */ void h(CollectMainUI collectMainUI) {
        AppMethodBeat.i(41315);
        collectMainUI.bhu();
        AppMethodBeat.o(41315);
    }

    static /* synthetic */ void l(CollectMainUI collectMainUI) {
        AppMethodBeat.i(41316);
        collectMainUI.bhv();
        AppMethodBeat.o(41316);
    }

    public final void bht() {
        AppMethodBeat.i(41289);
        xE(getResources().getColor(R.color.aw));
        AppMethodBeat.o(41289);
    }

    public void onDestroy() {
        AppMethodBeat.i(41290);
        if (this.kGi != null) {
            this.kGi.setImageBitmap(null);
        }
        Bitmap bitmap = this.kGC;
        if (!(bitmap == null || bitmap.isRecycled())) {
            ab.i("MicroMsg.CollectMainUI", "bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        if (this.kGr != null) {
            this.kGr.dismiss();
        }
        com.tencent.mm.plugin.collect.a.a.bgv();
        com.tencent.mm.plugin.collect.a.a.bgw().kaD.remove(this);
        this.iVt.cancel();
        if (this.kGS != null) {
            com.tencent.mm.ai.f fVar = this.kGS;
            for (Entry entry : fVar.jxd.entrySet()) {
                ab.i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
                g.RQ();
                g.RO().eJo.c((m) entry.getKey());
            }
            fVar.jxd.clear();
            g.RQ();
            g.RO().eJo.b(1588, fVar);
        }
        x.c(this.kHg);
        super.onDestroy();
        AppMethodBeat.o(41290);
    }

    public final void initView() {
        AppMethodBeat.i(41291);
        setMMTitle((int) R.string.daa);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(41268);
                CollectMainUI.this.finish();
                AppMethodBeat.o(41268);
                return true;
            }
        });
        this.iFE = this.yCw;
        this.kGo = (RelativeLayout) findViewById(R.id.l_);
        this.kGp = findViewById(R.id.ayz);
        this.kHc = findViewById(R.id.az0);
        this.kGk = (WalletTextView) findViewById(R.id.aym);
        this.kGj = (TextView) findViewById(R.id.ayn);
        this.kGl = (TextView) findViewById(R.id.ayl);
        this.kGm = (TextView) findViewById(R.id.az1);
        this.kGA = (TextView) findViewById(R.id.a2f);
        this.kGs = (RelativeLayout) findViewById(R.id.aye);
        this.kGt = findViewById(R.id.az2);
        this.kGO = LayoutInflater.from(this).inflate(R.layout.p2, null, false);
        this.kGn = (TextView) findViewById(R.id.ays);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.asd));
        spannableStringBuilder.setSpan(new o(new com.tencent.mm.plugin.wallet_core.ui.o.a() {
            public final void df(View view) {
                AppMethodBeat.i(41270);
                if (CollectMainUI.this.kHe == 1) {
                    CollectMainUI.c(CollectMainUI.this);
                    h.a(CollectMainUI.this.mController.ylL, CollectMainUI.this.getString(R.string.asm), "", CollectMainUI.this.getString(R.string.asl), CollectMainUI.this.getString(R.string.or), true, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(41269);
                            ab.i("MicroMsg.CollectMainUI", "save code from click");
                            if (CollectMainUI.this.kHf != null) {
                                CollectMainUI.dB(CollectMainUI.this.kHf.username, CollectMainUI.this.kHf.iAb);
                                com.tencent.mm.plugin.report.service.h.pYm.e(15387, Integer.valueOf(2));
                            }
                            AppMethodBeat.o(41269);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    CollectMainUI.e(CollectMainUI.this);
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(13944, Integer.valueOf(5));
                AppMethodBeat.o(41270);
            }
        }), 0, spannableStringBuilder.length(), 18);
        this.kGn.setText(spannableStringBuilder);
        this.kGn.setClickable(true);
        this.kGn.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(this));
        this.nDp.addFooterView(this.kGO, null, false);
        this.nDp.setFooterDividersEnabled(false);
        this.kGi = (ImageView) findViewById(R.id.ayp);
        this.kGq = (TextView) findViewById(R.id.ayh);
        this.kGz = (TextView) findViewById(R.id.ayr);
        this.kGz.setClickable(true);
        this.kGz.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(this));
        this.kGQ = new SpannableStringBuilder(getString(R.string.as2));
        this.kGR = new SpannableStringBuilder(getString(R.string.as3));
        final o oVar = new o(new com.tencent.mm.plugin.wallet_core.ui.o.a() {
            public final void df(View view) {
                AppMethodBeat.i(41271);
                Intent intent = new Intent();
                intent.setClass(CollectMainUI.this.mController.ylL, CollectCreateQRCodeUI.class);
                intent.putExtra("key_currency_unit", CollectMainUI.this.kGF);
                CollectMainUI.this.startActivityForResult(intent, 4096);
                AppMethodBeat.o(41271);
            }
        });
        final o oVar2 = new o(new com.tencent.mm.plugin.wallet_core.ui.o.a() {
            public final void df(View view) {
                AppMethodBeat.i(41272);
                CollectMainUI.this.kGL = false;
                CollectMainUI.this.bhs();
                CollectMainUI.this.kGz.setText(CollectMainUI.this.kGQ);
                CollectMainUI.h(CollectMainUI.this);
                AppMethodBeat.o(41272);
            }
        });
        this.kGQ.setSpan(oVar, 0, this.kGQ.length(), 18);
        if (com.tencent.mm.ui.a.a.a.yqY.dzj()) {
            this.kGz.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(41273);
                    if (CollectMainUI.this.kGz.getText().toString().equals(CollectMainUI.this.kGR)) {
                        oVar.onClick(view);
                        AppMethodBeat.o(41273);
                        return;
                    }
                    oVar2.onClick(view);
                    AppMethodBeat.o(41273);
                }
            });
        }
        this.kGR.setSpan(oVar2, 0, this.kGR.length(), 18);
        this.kGz.setText(this.kGQ);
        this.kGB = (RelativeLayout) findViewById(R.id.ayg);
        this.kGi.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(41278);
                if (CollectMainUI.this.kHe == 0) {
                    com.tencent.mm.ui.tools.j jVar = new com.tencent.mm.ui.tools.j(CollectMainUI.this.mController.ylL);
                    jVar.rBl = new c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(41274);
                            lVar.e(0, CollectMainUI.this.getString(R.string.asa));
                            AppMethodBeat.o(41274);
                        }
                    };
                    jVar.rBm = new d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(41275);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    CollectMainUI.e(CollectMainUI.this);
                                    break;
                                case 1:
                                    if (CollectMainUI.this.kHf != null) {
                                        CollectMainUI.dB(CollectMainUI.this.kHf.username, CollectMainUI.this.kHf.iAb);
                                        AppMethodBeat.o(41275);
                                        return;
                                    }
                                    break;
                            }
                            AppMethodBeat.o(41275);
                        }
                    };
                    jVar.cuu();
                } else {
                    com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(CollectMainUI.this.mController.ylL, 1, false);
                    dVar.rBl = new c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(41276);
                            lVar.e(1, CollectMainUI.this.getString(R.string.ask));
                            lVar.e(0, CollectMainUI.this.getString(R.string.asn));
                            AppMethodBeat.o(41276);
                        }
                    };
                    dVar.rBm = new d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(41277);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    CollectMainUI.e(CollectMainUI.this);
                                    break;
                                case 1:
                                    if (CollectMainUI.this.kHf != null) {
                                        CollectMainUI.dB(CollectMainUI.this.kHf.username, CollectMainUI.this.kHf.iAb);
                                        com.tencent.mm.plugin.report.service.h.pYm.e(15387, Integer.valueOf(1));
                                        AppMethodBeat.o(41277);
                                        return;
                                    }
                                    break;
                            }
                            AppMethodBeat.o(41277);
                        }
                    };
                    dVar.cpD();
                }
                AppMethodBeat.o(41278);
                return true;
            }
        });
        this.kGv = findViewById(R.id.ay_);
        this.kGw = (ImageView) findViewById(R.id.aya);
        this.kGx = (TextView) findViewById(R.id.ayb);
        this.kGy = (TextView) findViewById(R.id.ayc);
        this.kGX = (CdnImageView) findViewById(R.id.ayv);
        this.kGY = (TextView) findViewById(R.id.ayw);
        this.kGZ = (TextView) findViewById(R.id.ayx);
        this.kHa = (ImageView) findViewById(R.id.ayy);
        this.kHb = (ViewGroup) findViewById(R.id.ayu);
        this.kGs.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(41279);
                int[] iArr = new int[2];
                CollectMainUI.this.kGs.getLocationInWindow(iArr);
                CollectMainUI.kGN = iArr[1];
                AppMethodBeat.o(41279);
            }
        }, 300);
        final uo uoVar = new uo();
        uoVar.cQJ.cQL = "8";
        uoVar.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(41253);
                if (bo.isNullOrNil(uoVar.cQK.cQM)) {
                    ab.i("MicroMsg.CollectMainUI", "no bulletin data");
                    AppMethodBeat.o(41253);
                    return;
                }
                e.a((TextView) CollectMainUI.this.findViewById(R.id.a2f), uoVar.cQK.cQM, uoVar.cQK.content, uoVar.cQK.url);
                AppMethodBeat.o(41253);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.m(uoVar);
        AppMethodBeat.o(41291);
    }

    private void fX(final boolean z) {
        AppMethodBeat.i(41292);
        if (this.kGC == null || this.kGC.isRecycled()) {
            ab.w("MicroMsg.CollectMainUI", "save ftf pay qrcode failed: bmp null");
            Toast.makeText(this.mController.ylL, getString(R.string.asq), 1).show();
        } else {
            Object obj;
            Bitmap a = com.tencent.mm.plugin.collect.model.b.a(this, this.kGD, r.Yz(), this.kGT, this.kGW, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b((Context) this, 197.0f), this.kHg, false);
            if (a == null || a.isRecycled()) {
                obj = null;
            } else {
                int i;
                if (this.kGL) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(11343, Integer.valueOf(1), Integer.valueOf((int) Math.round(this.kGI * 100.0d)));
                } else {
                    com.tencent.mm.plugin.report.service.h.pYm.e(11343, Integer.valueOf(0));
                }
                if (this.kGu) {
                    i = 0;
                } else {
                    this.kEu = (ScrollView) ((ViewStub) findViewById(R.id.ay9)).inflate();
                    bhr();
                    this.kGu = true;
                    i = 250;
                }
                this.kEu.setVisibility(4);
                ((ImageView) this.kEu.findViewById(R.id.az_)).setImageBitmap(this.kGC);
                TextView textView = (TextView) this.kEu.findViewById(R.id.aza);
                TextView textView2 = (TextView) this.kEu.findViewById(R.id.azb);
                final LinearLayout linearLayout = (LinearLayout) this.kEu.findViewById(R.id.az4);
                LinearLayout linearLayout2 = (LinearLayout) this.kEu.findViewById(R.id.az6);
                TextView textView3 = (TextView) this.kEu.findViewById(R.id.az8);
                TextView textView4 = (TextView) this.kEu.findViewById(R.id.az9);
                TextView textView5 = (TextView) this.kEu.findViewById(R.id.az7);
                CharSequence eK = e.eK(e.mJ(r.Yz()), 10);
                if (!bo.isNullOrNil(bhp())) {
                    eK = eK + getString(R.string.asc, new Object[]{r9});
                }
                if (this.kGT != 1) {
                    textView.setText(j.b((Context) this, eK, textView.getTextSize()));
                } else if (bo.isNullOrNil(this.kGV)) {
                    textView.setText(j.b((Context) this, eK, textView.getTextSize()));
                } else {
                    textView.setText(this.kGV);
                    textView2.setText(j.b((Context) this, eK, textView2.getTextSize()));
                    textView2.setVisibility(0);
                }
                if (this.kGL) {
                    if (bo.isNullOrNil(this.kGK)) {
                        textView4.setVisibility(8);
                    } else {
                        textView4.setText(this.kGK);
                        textView4.setVisibility(0);
                    }
                    textView3.setText(bhq());
                    textView5.setText(e.F(this.kGI));
                    linearLayout2.setVisibility(0);
                } else {
                    linearLayout2.setVisibility(8);
                }
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(41256);
                        ab.d("MicroMsg.CollectMainUI", "height: %d, width: %d", Integer.valueOf(linearLayout.getHeight()), Integer.valueOf(linearLayout.getWidth()));
                        Bitmap createBitmap = Bitmap.createBitmap(linearLayout.getWidth(), linearLayout.getHeight(), Config.ARGB_8888);
                        linearLayout.draw(new Canvas(createBitmap));
                        try {
                            String str = n.dly() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
                            com.tencent.mm.sdk.platformtools.d.a(createBitmap, 100, CompressFormat.PNG, str, false);
                            if (z) {
                                Toast.makeText(CollectMainUI.this.mController.ylL, CollectMainUI.this.getString(R.string.fdw, new Object[]{str}), 1).show();
                            }
                            n.a(str, CollectMainUI.this.mController.ylL);
                        } catch (Exception e) {
                            ab.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + e.getMessage());
                        }
                        CollectMainUI.this.kEu.setVisibility(8);
                        AppMethodBeat.o(41256);
                    }
                }, (long) i);
                obj = 1;
            }
            if (obj == null) {
                Toast.makeText(this.mController.ylL, getString(R.string.asq), 1).show();
            }
        }
        this.yCw.notifyDataSetChanged();
        AppMethodBeat.o(41292);
    }

    /* Access modifiers changed, original: protected|final */
    public final void refreshView() {
        AppMethodBeat.i(41293);
        if (bo.isNullOrNil(this.kGD)) {
            ab.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
            AppMethodBeat.o(41293);
            return;
        }
        if (this.kGT == 1) {
            if (!bo.isNullOrNil(this.kGU)) {
                this.kGq.setText(this.kGU);
            }
            if (!bo.isNullOrNil(this.kGV)) {
                TextView textView = (TextView) findViewById(R.id.ayi);
                textView.setText(this.kGV);
                textView.setVisibility(0);
            }
        }
        bhs();
        bhv();
        bhw();
        AppMethodBeat.o(41293);
    }

    /* Access modifiers changed, original: protected */
    public void bhs() {
        AppMethodBeat.i(41294);
        this.kGi.setImageBitmap(null);
        if (this.kGL) {
            if (bo.isNullOrNil(this.kGG)) {
                ab.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
                AppMethodBeat.o(41294);
                return;
            }
            this.kGC = Id(this.kGG);
        } else if (bo.isNullOrNil(this.kGD)) {
            ab.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
            AppMethodBeat.o(41294);
            return;
        } else {
            this.kGC = Id(this.kGD);
        }
        if (this.kGC == null || this.kGC.isRecycled()) {
            ab.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + bo.nullAsNil(this.kGG));
        } else {
            this.kGi.setImageBitmap(this.kGC);
        }
        if (this.kGL) {
            this.kGk.setPrefix(bhq());
            this.kGk.setText(e.F(this.kGI));
            this.kGk.setVisibility(0);
            if (bo.isNullOrNil(this.kGK)) {
                this.kGj.setVisibility(8);
            } else {
                this.kGj.setText(j.b(this.mController.ylL, this.kGK, this.kGj.getTextSize()));
                this.kGj.setVisibility(0);
            }
            findViewById(R.id.ayj).setVisibility(0);
            AppMethodBeat.o(41294);
            return;
        }
        this.kGl.setVisibility(8);
        this.kGk.setVisibility(8);
        this.kGj.setVisibility(8);
        findViewById(R.id.ayj).setVisibility(8);
        AppMethodBeat.o(41294);
    }

    private void bhu() {
        AppMethodBeat.i(41295);
        getWindow().getDecorView().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(41254);
                int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(CollectMainUI.this.mController.ylL, 37);
                ViewGroup.LayoutParams layoutParams = CollectMainUI.this.kGO.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fromDPToPix;
                    CollectMainUI.this.kGO.setLayoutParams(layoutParams);
                    CollectMainUI.this.kGO.requestLayout();
                }
                AppMethodBeat.o(41254);
            }
        });
        AppMethodBeat.o(41295);
    }

    private void bhv() {
        double d;
        AppMethodBeat.i(41296);
        if (this.kGH == null || this.kGH.size() <= 0) {
            d = 0.0d;
        } else {
            this.kGs.setBackgroundResource(R.drawable.jo);
            this.iFE.removeAll();
            d = 0.0d;
            for (int i = 0; i < this.kGH.size(); i++) {
                c cVar;
                a aVar = (a) this.kGH.get(i);
                String valueOf = String.valueOf(i);
                if (i == this.kGH.size() - 1) {
                    cVar = new c(this, (byte) 0);
                } else {
                    cVar = new c(this);
                }
                cVar.setKey(valueOf);
                valueOf = aVar.eoz;
                if (bo.isNullOrNil(valueOf) && !bo.isNullOrNil(aVar.username)) {
                    valueOf = e.mJ(aVar.username);
                }
                cVar.mTitle = valueOf;
                cVar.edV = aVar.username;
                if (aVar.status == 0) {
                    cVar.setSummary((int) R.string.as9);
                } else if (aVar.status == 1) {
                    if (aVar.jYD) {
                        d += aVar.kCJ;
                        cVar.setSummary((CharSequence) e.e(aVar.kCJ, aVar.cuZ));
                    } else {
                        cVar.setSummary((int) R.string.as8);
                    }
                    this.iFE.b(cVar);
                } else if (aVar.status == 2) {
                    cVar.setSummary((int) R.string.as7);
                }
                this.iFE.b(cVar);
            }
            this.iFE.notifyDataSetChanged();
            this.kGm.setText(e.e(d, ((a) this.kGH.get(0)).cuZ));
            this.kGm.setVisibility(0);
        }
        if (this.kGH == null || this.kGH.size() <= 0) {
            this.kGm.setVisibility(8);
            this.kGp.setVisibility(8);
            this.kGt.setVisibility(8);
        } else {
            this.kHb.setBackgroundResource(R.drawable.jp);
            this.kGp.setVisibility(0);
            if (d > 0.0d && this.kGH.size() > 0) {
                this.kHc.setVisibility(0);
                this.kGt.setVisibility(0);
                AppMethodBeat.o(41296);
                return;
            }
        }
        AppMethodBeat.o(41296);
    }

    public final int getLayoutId() {
        return R.layout.p1;
    }

    public final int JC() {
        return R.xml.q;
    }

    public final int aWi() {
        return R.layout.p3;
    }

    public boolean f(int i, int i2, String str, m mVar) {
        return false;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    private Bitmap Id(String str) {
        AppMethodBeat.i(41297);
        Bitmap a = com.tencent.mm.plugin.collect.model.b.a(this, str, r.Yz(), this.kGT, this.kGW, this.kHg);
        AppMethodBeat.o(41297);
        return a;
    }

    public final void a(t tVar) {
        Object obj = null;
        AppMethodBeat.i(41298);
        ab.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
        if (((this.cQG == 1 || this.cQG == 0) && tVar.msgType == 9) || (this.cQG == 8 && tVar.msgType == 26)) {
            if (this.iVt != null) {
                this.iVt.vibrate(50);
            }
            if (((long) tVar.timestamp) < this.kGM) {
                ab.d("MicroMsg.CollectMainUI", "Recieve but time out ");
                AppMethodBeat.o(41298);
                return;
            }
            Object obj2;
            int i = 0;
            while (i < this.kGH.size()) {
                if (tVar.status == 0 && bo.nullAsNil(tVar.username).equals(((a) this.kGH.get(i)).username) && ((a) this.kGH.get(i)).status == 2) {
                    this.kGH.remove(i);
                    this.kGH.add(i, new a(tVar));
                    obj2 = 1;
                    break;
                } else if (tVar.cAa.equals(((a) this.kGH.get(i)).cAa)) {
                    ab.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + tVar.cAa);
                    if (((a) this.kGH.get(i)).status == 0) {
                        ((a) this.kGH.get(i)).status = tVar.status;
                        ((a) this.kGH.get(i)).kCJ = tVar.kCJ;
                        ((a) this.kGH.get(i)).cuZ = tVar.cuZ;
                        if (tVar.status == 1) {
                            a aVar = (a) this.kGH.get(i);
                            this.kGP.kHx.add(aVar);
                        }
                    }
                    int obj22 = 1;
                } else {
                    i++;
                }
            }
            obj22 = null;
            if (obj22 == null) {
                for (i = 0; i < this.kGH.size(); i++) {
                    if (tVar.timestamp > ((t) this.kGH.get(i)).timestamp) {
                        this.kGH.add(i, new a(tVar));
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    this.kGH.add(new a(tVar));
                }
            }
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(41255);
                    CollectMainUI.l(CollectMainUI.this);
                    CollectMainUI.this.kGP.bhF();
                    CollectMainUI.h(CollectMainUI.this);
                    AppMethodBeat.o(41255);
                }
            });
        }
        AppMethodBeat.o(41298);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(41299);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 4096:
                if (i2 != -1 || intent == null) {
                    this.kGL = false;
                } else {
                    this.kGG = intent.getStringExtra("ftf_pay_url");
                    this.kGI = intent.getDoubleExtra("ftf_fixed_fee", 0.0d);
                    this.kGJ = intent.getStringExtra("ftf_fixed_fee_type");
                    this.kGK = intent.getStringExtra("ftf_fixed_desc");
                    this.kGF = intent.getStringExtra("key_currency_unit");
                    this.kGz.setText(this.kGR);
                    this.kGL = true;
                }
                refreshView();
                bhu();
                AppMethodBeat.o(41299);
                return;
            case 4097:
                this.kFU = r.YE();
                break;
        }
        AppMethodBeat.o(41299);
    }

    public void onResume() {
        AppMethodBeat.i(41300);
        super.onResume();
        bc.a(this, this);
        AppMethodBeat.o(41300);
    }

    public void onPause() {
        AppMethodBeat.i(41301);
        super.onPause();
        bc.a(this, null);
        AppMethodBeat.o(41301);
    }

    public final void aNW() {
        AppMethodBeat.i(41302);
        ab.i("MicroMsg.CollectMainUI", "do screen shot");
        com.tencent.mm.plugin.report.service.h.pYm.e(13944, Integer.valueOf(9));
        if (this.kHd) {
            ab.i("MicroMsg.CollectMainUI", "onScreenShot() realNameVerifying == true ");
            AppMethodBeat.o(41302);
        } else if (this.kHe == 1) {
            com.tencent.mm.ui.widget.a.e.a aVar = new com.tencent.mm.ui.widget.a.e.a(this.mController.ylL);
            com.tencent.mm.ui.widget.a.e.a asL = aVar.asL(getString(R.string.aso));
            asL.vkm.zQe.zOU = true;
            asL.zQL = true;
            asL.zQK = getString(R.string.ask);
            asL.zQJ = getString(R.string.asn);
            asL.Qh(getResources().getColor(R.color.w4)).re(true).a(new com.tencent.mm.ui.widget.a.e.c() {
                public final void d(boolean z, String str) {
                    AppMethodBeat.i(41257);
                    if (CollectMainUI.this.kHf != null) {
                        CollectMainUI.dB(CollectMainUI.this.kHf.username, CollectMainUI.this.kHf.iAb);
                        com.tencent.mm.plugin.report.service.h.pYm.e(15387, Integer.valueOf(3));
                    }
                    AppMethodBeat.o(41257);
                }
            }, new com.tencent.mm.ui.widget.a.e.c() {
                public final void d(boolean z, String str) {
                    AppMethodBeat.i(41258);
                    CollectMainUI.e(CollectMainUI.this);
                    AppMethodBeat.o(41258);
                }
            });
            aVar.show();
            AppMethodBeat.o(41302);
        } else {
            h.a(this.mController.ylL, getString(R.string.ash), "", getString(R.string.asg), getString(R.string.or), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(41259);
                    CollectMainUI.e(CollectMainUI.this);
                    com.tencent.mm.plugin.report.service.h.pYm.e(13944, Integer.valueOf(10));
                    AppMethodBeat.o(41259);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(41302);
        }
    }

    public void finish() {
        AppMethodBeat.i(41303);
        super.finish();
        overridePendingTransition(R.anim.db, R.anim.dg);
        AppMethodBeat.o(41303);
    }

    private void bhw() {
        AppMethodBeat.i(41304);
        aw cPy = k.cPy();
        int i = this.kGL ? 33 : 32;
        if (cPy != null) {
            com.tencent.mm.plugin.report.service.h.pYm.e(13447, Integer.valueOf(i), cPy.vCF, cPy.vCG, this.kGD, Double.valueOf(this.kGI), Long.valueOf(bo.anT()), Long.valueOf(cPy.vCE), cPy.vCH, cPy.vCI);
        }
        AppMethodBeat.o(41304);
    }

    private static bbc bhx() {
        AppMethodBeat.i(41306);
        try {
            g.RQ();
            bbc Q = Q(new JSONObject((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_F2F_COLLECT_BOTTOM_MENU_STRING_SYNC, (Object) "")));
            AppMethodBeat.o(41306);
            return Q;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CollectMainUI", e, "", new Object[0]);
            AppMethodBeat.o(41306);
            return null;
        }
    }

    private static List<bbc> bhy() {
        AppMethodBeat.i(41307);
        ArrayList arrayList = new ArrayList();
        try {
            g.RQ();
            String str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_F2F_COLLECT_UPRIGHT_MENU_STRING_SYNC, (Object) "");
            if (!bo.isNullOrNil(str)) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Q(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CollectMainUI", e, "", new Object[0]);
        }
        AppMethodBeat.o(41307);
        return arrayList;
    }

    private static bbc Q(JSONObject jSONObject) {
        AppMethodBeat.i(41308);
        bbc bbc = new bbc();
        bbc.type = jSONObject.optInt("type", -1);
        bbc.url = jSONObject.optString("url", "");
        bbc.cEh = jSONObject.optString("wording", "");
        bbc.wFS = jSONObject.optString("waapp_username", "");
        bbc.wFT = jSONObject.optString("waapp_path", "");
        AppMethodBeat.o(41308);
        return bbc;
    }

    /* Access modifiers changed, original: protected */
    public String bhp() {
        AppMethodBeat.i(41309);
        if (bo.isNullOrNil(this.kGE)) {
            this.kGE = com.tencent.mm.plugin.wallet_core.model.r.cPI().bhp();
            this.kGE = e.att(this.kGE);
        }
        String str = this.kGE;
        AppMethodBeat.o(41309);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public String bhq() {
        AppMethodBeat.i(41310);
        String atq = e.atq(this.kGJ);
        AppMethodBeat.o(41310);
        return atq;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bq(final List<bbc> list) {
        AppMethodBeat.i(41311);
        if (list != null) {
            for (bbc bbc : list) {
                if (bbc.type == 1) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(14526, Integer.valueOf(2), Integer.valueOf(1), bbc.cEh, "", "", "", Integer.valueOf(1));
                } else if (bbc.type == 2) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(14526, Integer.valueOf(2), Integer.valueOf(2), bbc.cEh, "", "", bbc.url, Integer.valueOf(1));
                } else if (bbc.type == 3) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(14526, Integer.valueOf(2), Integer.valueOf(3), bbc.cEh, bbc.wFS, bbc.wFT, "", Integer.valueOf(1));
                }
            }
        }
        this.kGB.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41267);
                com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(CollectMainUI.this.mController.ylL, 1, false);
                dVar.rBl = new c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(41265);
                        com.tencent.mm.plugin.collect.a.a.bgv();
                        if (com.tencent.mm.plugin.collect.a.a.bgx()) {
                            lVar.add(0, 1, 0, (int) R.string.arv);
                        } else {
                            lVar.add(0, 1, 0, (int) R.string.as5);
                        }
                        if (list != null) {
                            for (int i = 0; i < list.size(); i++) {
                                bbc bbc = (bbc) list.get(i);
                                if (!bo.isNullOrNil(bbc.cEh)) {
                                    lVar.add(0, (i + 1) + 1, 0, bbc.cEh);
                                }
                            }
                        }
                        AppMethodBeat.o(41265);
                    }
                };
                dVar.rBm = new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(41266);
                        switch (menuItem.getItemId()) {
                            case 1:
                                com.tencent.mm.plugin.collect.a.a.bgv();
                                if (com.tencent.mm.plugin.collect.a.a.bgx()) {
                                    CollectMainUI.x(CollectMainUI.this);
                                    Toast.makeText(CollectMainUI.this.mController.ylL, R.string.arw, 1).show();
                                    com.tencent.mm.plugin.report.service.h.pYm.e(13944, Integer.valueOf(8));
                                    AppMethodBeat.o(41266);
                                    return;
                                }
                                CollectMainUI.y(CollectMainUI.this);
                                Toast.makeText(CollectMainUI.this.mController.ylL, R.string.as6, 1).show();
                                com.tencent.mm.plugin.collect.model.voice.a.bgJ().bgK();
                                com.tencent.mm.plugin.report.service.h.pYm.e(13944, Integer.valueOf(7));
                                AppMethodBeat.o(41266);
                                return;
                            default:
                                int itemId = (menuItem.getItemId() - 1) - 1;
                                if (itemId < 0) {
                                    ab.w("MicroMsg.CollectMainUI", "illegal pos: %s", Integer.valueOf(itemId));
                                    AppMethodBeat.o(41266);
                                    return;
                                }
                                bbc bbc = (bbc) list.get(itemId);
                                if (bbc.type == 1) {
                                    ab.w("MicroMsg.CollectMainUI", "wrong native type: %s", bbc.url);
                                    com.tencent.mm.plugin.report.service.h.pYm.e(14526, Integer.valueOf(2), Integer.valueOf(1), bbc.cEh, "", "", "", Integer.valueOf(2));
                                    AppMethodBeat.o(41266);
                                    return;
                                }
                                if (bbc.type == 2) {
                                    if (!bo.isNullOrNil(bbc.url)) {
                                        e.n(CollectMainUI.this.mController.ylL, bbc.url, false);
                                        com.tencent.mm.plugin.report.service.h.pYm.e(14526, Integer.valueOf(2), Integer.valueOf(2), bbc.cEh, "", "", bbc.url, Integer.valueOf(2));
                                        AppMethodBeat.o(41266);
                                        return;
                                    }
                                } else if (bbc.type == 3) {
                                    se seVar = new se();
                                    seVar.cOf.userName = bbc.wFS;
                                    seVar.cOf.cOh = bo.bc(bbc.wFT, "");
                                    seVar.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_MUDAN;
                                    seVar.cOf.cOi = 0;
                                    com.tencent.mm.sdk.b.a.xxA.m(seVar);
                                    com.tencent.mm.plugin.report.service.h.pYm.e(14526, Integer.valueOf(2), Integer.valueOf(3), bbc.cEh, bbc.wFS, bbc.wFT, "", Integer.valueOf(2));
                                }
                                AppMethodBeat.o(41266);
                                return;
                        }
                    }
                };
                dVar.cpD();
                AppMethodBeat.o(41267);
            }
        });
        AppMethodBeat.o(41311);
    }

    /* Access modifiers changed, original: protected */
    public void bhr() {
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41288);
        this.yll = true;
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        pO(true);
        dyb();
        g.RQ();
        this.cQG = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        this.kFU = r.YE();
        int intExtra = getIntent().getIntExtra("key_from_scene", 1);
        com.tencent.mm.plugin.report.service.h.pYm.e(14021, Integer.valueOf(2), Integer.valueOf(intExtra));
        overridePendingTransition(R.anim.df, R.anim.dc);
        com.tencent.mm.plugin.collect.a.a.bgv();
        com.tencent.mm.plugin.collect.model.d bgw = com.tencent.mm.plugin.collect.a.a.bgw();
        if (!bgw.kaD.contains(this)) {
            bgw.kaD.add(this);
        }
        initView();
        bho();
        refreshView();
        this.iVt = (Vibrator) getSystemService("vibrator");
        this.kGM = bo.anT();
        if (kHh < 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            kHh = (displayMetrics.widthPixels / 2) - com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mController.ylL, 20.0f);
            kHi = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mController.ylL, 60.0f);
            kHj = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mController.ylL, 40.0f);
            kHk = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mController.ylL, 70.0f);
        }
        bhu();
        z.hL(16, 0);
        AppMethodBeat.o(41288);
    }

    /* Access modifiers changed, original: protected */
    public void bho() {
        AppMethodBeat.i(41305);
        if (com.tencent.mm.plugin.collect.model.f.kBJ == null) {
            com.tencent.mm.plugin.collect.model.f.kBJ = new com.tencent.mm.plugin.collect.model.f();
        }
        this.kGS = com.tencent.mm.plugin.collect.model.f.kBJ;
        com.tencent.mm.ai.f fVar = this.kGS;
        g.RQ();
        g.RO().eJo.a(1588, fVar);
        com.tencent.mm.plugin.collect.model.f fVar2 = this.kGS;
        AnonymousClass10 anonymousClass10 = new com.tencent.mm.plugin.collect.model.f.a() {
            public final void dz(String str, String str2) {
                AppMethodBeat.i(41261);
                ab.i("MicroMsg.CollectMainUI", "get cache: %s, %s", str, str2);
                CollectMainUI.this.kGo.setVisibility(0);
                CollectMainUI.this.kGD = str;
                CollectMainUI.this.kGE = str2;
                bbc bhD = CollectMainUI.bhD();
                List bhE = CollectMainUI.bhE();
                CollectMainUI.a(CollectMainUI.this, bhD);
                CollectMainUI.this.bq(bhE);
                if (CollectMainUI.this.cQG == 1) {
                    CollectMainUI collectMainUI = CollectMainUI.this;
                    g.RQ();
                    collectMainUI.kGT = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_COLLECT_BUSITYPE_INT_SYNC, Integer.valueOf(-1))).intValue();
                    collectMainUI = CollectMainUI.this;
                    g.RQ();
                    collectMainUI.kGW = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_COLLECT_BUSIURL_STRING_SYNC, (Object) "");
                }
                AppMethodBeat.o(41261);
            }

            public final void a(boolean z, oy oyVar) {
                AppMethodBeat.i(41262);
                String str = "MicroMsg.CollectMainUI";
                String str2 = "get from cgi: %s resp.retcode: %s";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = oyVar == null ? BuildConfig.COMMAND : Integer.valueOf(oyVar.kCl);
                ab.i(str, str2, objArr);
                if (z) {
                    if (oyVar == null || oyVar.kCl != 416) {
                        CollectMainUI.v(CollectMainUI.this);
                        CollectMainUI.this.kGo.setVisibility(0);
                        CollectMainUI.this.kHd = false;
                        CollectMainUI.this.kGD = oyVar.url;
                        CollectMainUI.this.kGE = oyVar.twd;
                        CollectMainUI.this.kGT = oyVar.pPV;
                        CollectMainUI.this.kGV = oyVar.pPW;
                        CollectMainUI.this.kGW = oyVar.pPX;
                        CollectMainUI.this.kGU = oyVar.vWc;
                        CollectMainUI.a(CollectMainUI.this, oyVar.vVZ);
                        CollectMainUI.this.bq(oyVar.vVY);
                        CollectMainUI.this.kHe = oyVar.vWd;
                        CollectMainUI.this.kHf = oyVar.vWe;
                        ab.d("MicroMsg.CollectMainUI", "flag: %s", Integer.valueOf(CollectMainUI.this.kHe));
                        g.RQ();
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_COLLECT_BUSITYPE_INT_SYNC, Integer.valueOf(CollectMainUI.this.kGT));
                        g.RQ();
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_COLLECT_BUSIURL_STRING_SYNC, CollectMainUI.this.kGW);
                        CollectMainUI.this.refreshView();
                    } else {
                        boolean z2;
                        str = "MicroMsg.CollectMainUI";
                        str2 = "realNameInfo:%s";
                        objArr = new Object[1];
                        if (oyVar.vWf == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objArr[0] = Boolean.valueOf(z2);
                        ab.d(str, str2, objArr);
                        CollectMainUI.this.kGo.setVisibility(4);
                        CollectMainUI.this.kHd = true;
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.CollectMainUI");
                        bundle.putString("realname_verify_process_jump_plugin", "collect");
                        Activity activity = CollectMainUI.this;
                        int i = oyVar.kCl;
                        bpt bpt = oyVar.vWf;
                        AnonymousClass1 anonymousClass1 = new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(41260);
                                ab.i("MicroMsg.CollectMainUI", "RealnameVerifyUtil cancel");
                                AppMethodBeat.o(41260);
                            }
                        };
                        com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, i, bpt, bundle, 1010);
                        AppMethodBeat.o(41262);
                        return;
                    }
                }
                AppMethodBeat.o(41262);
            }
        };
        g.RQ();
        String str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_F2F_COLLECT_PAY_URL_STRING_SYNC, (Object) "");
        g.RQ();
        String str2 = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_F2F_COLLECT_TRUE_NAME_STRING_SYNC, (Object) "");
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
            str = com.tencent.mm.plugin.wallet_core.model.r.cPI().cQn();
        }
        anonymousClass10.dz(str, str2);
        m lVar = new com.tencent.mm.plugin.collect.model.l();
        fVar2.jxd.put(lVar, anonymousClass10);
        g.RQ();
        g.RO().eJo.a(lVar, 0);
        AppMethodBeat.o(41305);
    }

    static /* synthetic */ void dB(String str, String str2) {
        AppMethodBeat.i(41313);
        if (!bo.isNullOrNil(str)) {
            se seVar = new se();
            seVar.cOf.userName = str;
            seVar.cOf.cOh = bo.bc(str2, "");
            seVar.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_MUDAN;
            seVar.cOf.cOi = 0;
            com.tencent.mm.sdk.b.a.xxA.m(seVar);
        }
        AppMethodBeat.o(41313);
    }

    static /* synthetic */ void e(CollectMainUI collectMainUI) {
        AppMethodBeat.i(41314);
        collectMainUI.fX(true);
        AppMethodBeat.o(41314);
    }

    static /* synthetic */ void v(CollectMainUI collectMainUI) {
        AppMethodBeat.i(41320);
        g.RQ();
        if (((String) g.RP().Ry().get(327731, AppEventsConstants.EVENT_PARAM_VALUE_NO)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            int i;
            Context context = collectMainUI.mController.ylL;
            if (r.YM()) {
                i = R.string.ary;
            } else {
                i = R.string.arx;
            }
            h.a(context, i, (int) R.string.arz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            g.RQ();
            g.RP().Ry().set(327731, (Object) "1");
            g.RQ();
            g.RP().Ry().dsb();
        }
        AppMethodBeat.o(41320);
    }

    static /* synthetic */ void x(CollectMainUI collectMainUI) {
        AppMethodBeat.i(41321);
        collectMainUI.kFU &= -32769;
        g.RQ();
        g.RP().Ry().set(147457, Long.valueOf(collectMainUI.kFU));
        bci bci = new bci();
        bci.pXD = 2;
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(209, bci));
        com.tencent.mm.plugin.collect.a.a.bgv().bgz();
        AppMethodBeat.o(41321);
    }

    static /* synthetic */ void y(CollectMainUI collectMainUI) {
        AppMethodBeat.i(41322);
        collectMainUI.kFU |= 32768;
        g.RQ();
        g.RP().Ry().set(147457, Long.valueOf(collectMainUI.kFU));
        bci bci = new bci();
        bci.pXD = 1;
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(209, bci));
        com.tencent.mm.plugin.collect.a.a.bgv().bgy();
        AppMethodBeat.o(41322);
    }
}
