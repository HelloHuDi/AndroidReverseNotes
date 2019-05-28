package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.luckymoney.f2f.a.e;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.particles.b;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.ttpic.config.MediaConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class LuckyMoneyF2FQRCodeUI extends LuckyMoneyBaseUI implements com.tencent.mm.sdk.platformtools.bc.a {
    private View abB;
    private SensorManager bCW;
    private int[] gCr;
    private ap gGo;
    private DisplayMetrics ghw;
    private String hwA;
    private d iHZ;
    private n.d kFW = new n.d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(42183);
            switch (menuItem.getItemId()) {
                case 1:
                    if (LuckyMoneyF2FQRCodeUI.this.nUt <= 0) {
                        h.bQ(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.this.getString(R.string.cqn));
                        break;
                    }
                    LuckyMoneyF2FQRCodeUI.h(LuckyMoneyF2FQRCodeUI.this);
                    AppMethodBeat.o(42183);
                    return;
            }
            AppMethodBeat.o(42183);
        }
    };
    private String lvz;
    private Bitmap mBitmap;
    private String nSX;
    private Button nTg;
    private View nUE;
    private View nUF;
    private ImageView nUG;
    private TextView nUH;
    private TextView nUI;
    private ImageView nUJ;
    private TextView nUK;
    private TextView nUL;
    private HorizontalListViewV2 nUM;
    private List<String> nUN;
    private Map<String, String> nUO;
    private Queue<Pair<String, Integer>> nUP;
    private a nUQ;
    private TextView nUR;
    private ShuffleView nUS;
    private c nUT;
    private List<View> nUU;
    private ViewGroup nUV;
    private ViewGroup nUW;
    private View nUX;
    private com.tencent.mm.plugin.luckymoney.f2f.a nUY;
    private long nUZ;
    private String nUs;
    private int nUt;
    private String nVa;
    private ValueAnimator nVb;
    private float nVc;
    private float nVd;
    private float nVe;
    private com.tencent.mm.model.bz.a nVf = new com.tencent.mm.model.bz.a() {
        public final void a(com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(42170);
            Map z = br.z(aa.a(aVar.eAB.vED), "sysmsg");
            if (z != null) {
                String str = (String) z.get(".sysmsg.sendId");
                final String str2 = (String) z.get(".sysmsg.username");
                final String str3 = (String) z.get(".sysmsg.amount");
                final String str4 = (String) z.get(".sysmsg.receiveId");
                if (bo.getInt((String) z.get(".sysmsg.islucky"), 0) > 0) {
                    LuckyMoneyF2FQRCodeUI.this.nVa = str2;
                }
                if (!bo.Q(str, str2, str3)) {
                    LuckyMoneyF2FQRCodeUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42169);
                            if (!LuckyMoneyF2FQRCodeUI.this.nUN.contains(str4)) {
                                LuckyMoneyF2FQRCodeUI.this.nUN.add(0, str4);
                                if (!t.mY(str2)) {
                                    com.tencent.mm.ah.h hVar = new com.tencent.mm.ah.h();
                                    hVar.username = str2;
                                    o.act().b(hVar);
                                }
                                LuckyMoneyF2FQRCodeUI.this.nUO.put(str4, str2);
                                ShuffleView c = LuckyMoneyF2FQRCodeUI.this.nUS;
                                if (c.nVP.size() > 0) {
                                    if (c.nVT.isStarted()) {
                                        c.nVT.end();
                                    }
                                    if (c.lgH.isStarted()) {
                                        c.lgH.end();
                                    }
                                    if (c.gCO != null) {
                                        c.nVX = c.gCO;
                                        c.nVP.remove(c.nVX);
                                        if (c.nVR != null) {
                                            c.nVR.start();
                                        }
                                        c.xQ(c.nVZ);
                                        if (c.nWc > 0) {
                                            c.nVZ = c.bLm();
                                            c.gCO = (View) c.nVP.get(c.nVZ);
                                        } else {
                                            c.gCO = null;
                                            c.nVZ = 0;
                                        }
                                    } else {
                                        c.xO(c.bLm());
                                        c.nVX = c.gCO;
                                        c.nVT.addListener(new AnimatorListener() {
                                            public final void onAnimationStart(Animator animator) {
                                            }

                                            public final void onAnimationEnd(Animator animator) {
                                                AppMethodBeat.i(42230);
                                                ShuffleView.this.nVP.remove(ShuffleView.this.nVX);
                                                if (ShuffleView.this.nVR != null) {
                                                    ShuffleView.this.nVR.start();
                                                }
                                                ShuffleView.f(ShuffleView.this, ShuffleView.this.nVZ);
                                                if (ShuffleView.this.nWc > 0) {
                                                    ShuffleView.this.nVZ = ShuffleView.y(ShuffleView.this);
                                                    ShuffleView.this.gCO = (View) ShuffleView.this.nVP.get(ShuffleView.this.nVZ);
                                                    AppMethodBeat.o(42230);
                                                    return;
                                                }
                                                ShuffleView.this.gCO = null;
                                                ShuffleView.this.nVZ = 0;
                                                AppMethodBeat.o(42230);
                                            }

                                            public final void onAnimationCancel(Animator animator) {
                                            }

                                            public final void onAnimationRepeat(Animator animator) {
                                            }
                                        });
                                    }
                                }
                                LuckyMoneyF2FQRCodeUI.this.nUU.remove(LuckyMoneyF2FQRCodeUI.this.nUS.getExitView());
                                LuckyMoneyF2FQRCodeUI.this.gGo.ae(0, 60000);
                                LuckyMoneyF2FQRCodeUI.this.nUP.add(new Pair(str2, Integer.valueOf(bo.getInt(str3, 0))));
                            }
                            AppMethodBeat.o(42169);
                        }
                    });
                }
            }
            AppMethodBeat.o(42170);
        }
    };
    private c nVg = new c() {
        public final void a(l lVar) {
            AppMethodBeat.i(42182);
            lVar.hi(1, R.string.cqm);
            AppMethodBeat.o(42182);
        }
    };
    private Bitmap nVh;
    private Bitmap nVi;
    private Bitmap nVj;
    private Bitmap nVk;
    private Bitmap nVl;
    private Bitmap nVm;
    private Bitmap nVn;
    private Bitmap nVo;
    private Bitmap nVp;
    private Bitmap nVq;
    private Bitmap nVr;
    private Bitmap nVs;
    private b nVt = new b() {
        public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            AppMethodBeat.i(42184);
            int nextInt = random.nextInt(100);
            com.tencent.mm.plugin.luckymoney.particles.a.b aVar;
            if (nextInt < 16) {
                if (LuckyMoneyF2FQRCodeUI.this.nVk == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVk = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.b9_, 36);
                }
                com.tencent.mm.plugin.luckymoney.particles.a.a aVar2 = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.nVk);
                AppMethodBeat.o(42184);
                return aVar2;
            } else if (nextInt < 33) {
                if (LuckyMoneyF2FQRCodeUI.this.nVl == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVl = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.b9a, 36);
                }
                aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.nVl);
                AppMethodBeat.o(42184);
                return aVar;
            } else if (nextInt < 50) {
                if (LuckyMoneyF2FQRCodeUI.this.nVm == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVm = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.b9b, 36);
                }
                aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.nVm);
                AppMethodBeat.o(42184);
                return aVar;
            } else if (nextInt < 70) {
                if (LuckyMoneyF2FQRCodeUI.this.nVh == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVh = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.b95, 36);
                }
                aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.nVh);
                AppMethodBeat.o(42184);
                return aVar;
            } else if (nextInt < 90) {
                if (LuckyMoneyF2FQRCodeUI.this.nVi == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVi = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.b96, 36);
                }
                aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.nVi);
                AppMethodBeat.o(42184);
                return aVar;
            } else {
                if (LuckyMoneyF2FQRCodeUI.this.nVj == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVj = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.b97, 36);
                }
                aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.nVj);
                AppMethodBeat.o(42184);
                return aVar;
            }
        }
    };
    private b nVu = new b() {
        public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            AppMethodBeat.i(42185);
            int nextInt = random.nextInt(100);
            com.tencent.mm.plugin.luckymoney.particles.a.b aVar;
            if (nextInt < 10) {
                if (LuckyMoneyF2FQRCodeUI.this.nVq == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVq = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.b9_, 32);
                }
                com.tencent.mm.plugin.luckymoney.particles.a.a aVar2 = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.nVq);
                AppMethodBeat.o(42185);
                return aVar2;
            } else if (nextInt < 20) {
                if (LuckyMoneyF2FQRCodeUI.this.nVr == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVr = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.b9a, 32);
                }
                aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.nVr);
                AppMethodBeat.o(42185);
                return aVar;
            } else if (nextInt < 30) {
                if (LuckyMoneyF2FQRCodeUI.this.nVs == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVs = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.b9b, 32);
                }
                aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.nVs);
                AppMethodBeat.o(42185);
                return aVar;
            } else if (nextInt < 50) {
                if (LuckyMoneyF2FQRCodeUI.this.nVn == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVn = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.b95, 32);
                }
                aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.nVn);
                AppMethodBeat.o(42185);
                return aVar;
            } else if (nextInt < 75) {
                if (LuckyMoneyF2FQRCodeUI.this.nVo == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVo = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.b96, 32);
                }
                aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.nVo);
                AppMethodBeat.o(42185);
                return aVar;
            } else {
                if (LuckyMoneyF2FQRCodeUI.this.nVp == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVp = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.b97, 32);
                }
                aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.nVp);
                AppMethodBeat.o(42185);
                return aVar;
            }
        }
    };
    final SensorEventListener nVv = new SensorEventListener() {
        final int nVA = 3;
        float nVB = ((float) com.tencent.mm.bz.a.al(ah.getContext(), R.dimen.lo));
        int nVC;
        ValueAnimator nVD;
        float neH;

        {
            AppMethodBeat.i(42179);
            AppMethodBeat.o(42179);
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            float f = -3.0f;
            AppMethodBeat.i(42180);
            if (sensorEvent.sensor.getType() == 1) {
                if (LuckyMoneyF2FQRCodeUI.this.nUt <= 0) {
                    AppMethodBeat.o(42180);
                    return;
                }
                if (this.nVC == 0) {
                    this.nVC = f.de(LuckyMoneyF2FQRCodeUI.this) + ((int) this.nVB);
                }
                float f2 = sensorEvent.values[1];
                if (((double) Math.abs(f2 - this.neH)) < 0.05d) {
                    AppMethodBeat.o(42180);
                    return;
                }
                this.neH = f2;
                ab.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", Float.valueOf(f2));
                if (f2 >= -3.0f) {
                    if (f2 > 0.0f) {
                        f = 0.0f;
                    } else {
                        f = f2;
                    }
                }
                f = ((f / 3.0f) * ((float) this.nVC)) + ((float) this.nVC);
                ab.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", Float.valueOf(f), Integer.valueOf(LuckyMoneyF2FQRCodeUI.this.nUE.getPaddingTop()));
                if (this.nVD != null) {
                    this.nVD.cancel();
                }
                this.nVD = ValueAnimator.ofFloat(new float[]{(float) LuckyMoneyF2FQRCodeUI.this.nUE.getPaddingTop(), f}).setDuration(200);
                this.nVD.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(42178);
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        LuckyMoneyF2FQRCodeUI.this.nUE.setPadding(LuckyMoneyF2FQRCodeUI.this.nUE.getPaddingLeft(), (int) floatValue, LuckyMoneyF2FQRCodeUI.this.nUE.getPaddingRight(), LuckyMoneyF2FQRCodeUI.this.nUE.getPaddingBottom());
                        floatValue /= (float) AnonymousClass7.this.nVC;
                        if (floatValue <= 1.0f) {
                            LuckyMoneyF2FQRCodeUI.this.nUK.setAlpha((1.0f - floatValue) + LuckyMoneyF2FQRCodeUI.this.nVe);
                            LuckyMoneyF2FQRCodeUI.this.nUL.setAlpha(floatValue * LuckyMoneyF2FQRCodeUI.this.nVe);
                            AppMethodBeat.o(42178);
                            return;
                        }
                        LuckyMoneyF2FQRCodeUI.this.nUK.setAlpha(LuckyMoneyF2FQRCodeUI.this.nVe);
                        LuckyMoneyF2FQRCodeUI.this.nUL.setAlpha(LuckyMoneyF2FQRCodeUI.this.nVe);
                        AppMethodBeat.o(42178);
                    }
                });
                this.nVD.start();
            }
            AppMethodBeat.o(42180);
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
            AppMethodBeat.i(42181);
            ab.i("LuckyMoneyF2FQRCodeUI", "onAccuracyChanged");
            AppMethodBeat.o(42181);
        }
    };
    private int retCode;

    class a extends BaseAdapter {

        class a {
            ImageView goC;
            ImageView nVF;

            a() {
            }
        }

        private a() {
        }

        /* synthetic */ a(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(42190);
            int size = LuckyMoneyF2FQRCodeUI.this.nUN.size();
            AppMethodBeat.o(42190);
            return size;
        }

        private String getItem(int i) {
            AppMethodBeat.i(42191);
            String str = (String) LuckyMoneyF2FQRCodeUI.this.nUN.get(i);
            AppMethodBeat.o(42191);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(42192);
            if (view == null) {
                view = LayoutInflater.from(LuckyMoneyF2FQRCodeUI.this).inflate(R.layout.aa7, null);
                ImageView imageView = (ImageView) view.findViewById(R.id.cwn);
                ImageView imageView2 = (ImageView) view.findViewById(R.id.cwo);
                a aVar2 = new a();
                aVar2.goC = imageView;
                aVar2.nVF = imageView2;
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            String str = (String) LuckyMoneyF2FQRCodeUI.this.nUO.get(getItem(i));
            x.b(aVar.goC, null, str);
            if (bo.isNullOrNil(LuckyMoneyF2FQRCodeUI.this.nVa) || !LuckyMoneyF2FQRCodeUI.this.nVa.equals(str)) {
                aVar.nVF.setVisibility(4);
            } else {
                aVar.nVF.setVisibility(0);
            }
            AppMethodBeat.o(42192);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyF2FQRCodeUI() {
        AppMethodBeat.i(42194);
        AppMethodBeat.o(42194);
    }

    static /* synthetic */ void J(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        AppMethodBeat.i(42209);
        luckyMoneyF2FQRCodeUI.bLh();
        AppMethodBeat.o(42209);
    }

    static /* synthetic */ void L(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        AppMethodBeat.i(42210);
        luckyMoneyF2FQRCodeUI.bLj();
        AppMethodBeat.o(42210);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42195);
        super.onCreate(bundle);
        this.ghw = getResources().getDisplayMetrics();
        this.nUN = new ArrayList();
        this.nUO = new HashMap();
        this.nUP = new LinkedList();
        this.nUU = new ArrayList();
        this.gCr = new int[6];
        int[] iArr = this.gCr;
        iArr[0] = iArr[0] + 1;
        this.gGo = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(42186);
                LuckyMoneyF2FQRCodeUI.this.b(new e(), false);
                AppMethodBeat.o(42186);
                return true;
            }
        }, true);
        this.abB = findViewById(R.id.cw3);
        this.nUE = findViewById(R.id.cw1);
        this.nUL = (TextView) findViewById(R.id.cw6);
        this.nUK = (TextView) findViewById(R.id.cw4);
        this.nVe = this.nUL.getAlpha();
        this.nUJ = (ImageView) this.abB.findViewById(R.id.cw5);
        this.nUM = (HorizontalListViewV2) findViewById(R.id.cw7);
        this.nUQ = new a(this, (byte) 0);
        this.nUM.setAdapter(this.nUQ);
        this.nUM.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(42187);
                Intent intent = new Intent(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyBeforeDetailUI.class);
                intent.putExtra("key_sendid", LuckyMoneyF2FQRCodeUI.this.nSX);
                LuckyMoneyF2FQRCodeUI.this.startActivity(intent);
                AppMethodBeat.o(42187);
            }
        });
        this.nUM.setOnScrollStateChangedListener(new HorizontalListViewV2.d() {
            public final void a(com.tencent.mm.ui.base.HorizontalListViewV2.d.a aVar) {
                AppMethodBeat.i(42188);
                if (aVar == com.tencent.mm.ui.base.HorizontalListViewV2.d.a.SCROLL_STATE_IDLE && LuckyMoneyF2FQRCodeUI.this.nUN.size() >= 5 && ((long) LuckyMoneyF2FQRCodeUI.this.nUN.size()) < LuckyMoneyF2FQRCodeUI.this.nUZ && LuckyMoneyF2FQRCodeUI.this.nUM.getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.this.nUN.size() - 1 && !bo.isNullOrNil(LuckyMoneyF2FQRCodeUI.this.nSX)) {
                    LuckyMoneyF2FQRCodeUI.this.n(new af(LuckyMoneyF2FQRCodeUI.this.nSX, 5, LuckyMoneyF2FQRCodeUI.this.nUN.size(), null, "v1.0"));
                }
                AppMethodBeat.o(42188);
            }
        });
        this.nTg = (Button) findViewById(R.id.cw_);
        this.nTg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42189);
                Intent intent = new Intent(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyPrepareUI.class);
                intent.putExtra("key_from", 2);
                LuckyMoneyF2FQRCodeUI.this.startActivity(intent);
                AppMethodBeat.o(42189);
            }
        });
        this.nUR = (TextView) findViewById(R.id.cw9);
        this.nUF = findViewById(R.id.cwb);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42171);
                LuckyMoneyF2FQRCodeUI.this.finish();
                AppMethodBeat.o(42171);
                return true;
            }
        });
        setMMTitle(getString(R.string.cqz));
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42172);
                LuckyMoneyF2FQRCodeUI.this.iHZ = new d(LuckyMoneyF2FQRCodeUI.this, 1, false);
                LuckyMoneyF2FQRCodeUI.this.iHZ.rBl = LuckyMoneyF2FQRCodeUI.this.nVg;
                LuckyMoneyF2FQRCodeUI.this.iHZ.rBm = LuckyMoneyF2FQRCodeUI.this.kFW;
                LuckyMoneyF2FQRCodeUI.this.iHZ.cpD();
                AppMethodBeat.o(42172);
                return true;
            }
        });
        xE(getResources().getColor(R.color.tl));
        dyb();
        this.nUV = (ViewGroup) findViewById(R.id.cwh);
        this.nUW = (ViewGroup) findViewById(R.id.cw2);
        this.nUX = findViewById(R.id.cwa);
        this.nUX.setAlpha(0.0f);
        this.bCW = (SensorManager) getSystemService("sensor");
        this.bCW.registerListener(this.nVv, this.bCW.getDefaultSensor(1), 3);
        this.nUY = new com.tencent.mm.plugin.luckymoney.f2f.a();
        this.nUS = (ShuffleView) findViewById(R.id.cw8);
        this.nUT = new c();
        this.nUT.nWr = 4;
        this.nUT.nWp = 2;
        this.nUT.nWq = 4;
        this.nUT.nWs = 300;
        this.nUT.scaleY = 0.0f;
        this.nUS.setShuffleSetting(this.nUT);
        ShuffleView.ghw = this.ghw;
        this.nUS.setExitAnimator(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300));
        this.nUS.setExitAnimatorListener(new a() {
            public final void a(ValueAnimator valueAnimator, View view) {
                AppMethodBeat.i(42173);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue == 0.0f) {
                    LuckyMoneyF2FQRCodeUI.this.nVc = view.getTranslationX();
                    LuckyMoneyF2FQRCodeUI.this.nVd = view.getTranslationY();
                    view.findViewById(R.id.cw0).setVisibility(0);
                }
                view.setTranslationX((1.0f - floatValue) * LuckyMoneyF2FQRCodeUI.this.nVc);
                view.setTranslationY(((1.0f - floatValue) * LuckyMoneyF2FQRCodeUI.this.nVd) - ((((float) LuckyMoneyF2FQRCodeUI.this.nUS.getHeight()) + (LuckyMoneyF2FQRCodeUI.this.nVd * 8.0f)) * floatValue));
                view.setScaleX((0.5f * floatValue) + 1.0f);
                view.setScaleY((0.5f * floatValue) + 1.0f);
                Pair pair = (Pair) LuckyMoneyF2FQRCodeUI.this.nUP.peek();
                if (!(pair == null || bo.isNullOrNil(LuckyMoneyF2FQRCodeUI.this.nVa) || !LuckyMoneyF2FQRCodeUI.this.nVa.equals(pair.first))) {
                    LuckyMoneyF2FQRCodeUI.this.nUX.setAlpha(floatValue);
                }
                ab.i("LuckyMoneyF2FQRCodeUI", "fireworkBottomLayer %f", Float.valueOf(floatValue));
                if (floatValue >= 0.9f) {
                    view.setAlpha((1.0f - floatValue) * 10.0f);
                    LuckyMoneyF2FQRCodeUI.this.nUF.setAlpha(1.0f - ((1.0f - floatValue) * 10.0f));
                    LuckyMoneyF2FQRCodeUI.this.nUF.setScaleX(floatValue);
                    LuckyMoneyF2FQRCodeUI.this.nUF.setScaleY(floatValue);
                    LuckyMoneyF2FQRCodeUI.this.nUF.setVisibility(0);
                }
                if (floatValue == 1.0f) {
                    LuckyMoneyF2FQRCodeUI.this.nUY.jU("packet_received.m4a");
                    LuckyMoneyF2FQRCodeUI.this.nUS.removeView(LuckyMoneyF2FQRCodeUI.this.nUS.getExitView());
                    LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this);
                    LuckyMoneyF2FQRCodeUI.this.nVb.start();
                }
                AppMethodBeat.o(42173);
            }
        });
        this.nUS.setCardListener(new b() {
            public final void er(int i, int i2) {
                AppMethodBeat.i(42174);
                int[] I;
                if (i2 == 8) {
                    LuckyMoneyF2FQRCodeUI.this.nUY.jU("music" + (i + 1) + MediaConfig.VIDEO_AAC_FILE_POSTFIX);
                    I = LuckyMoneyF2FQRCodeUI.this.gCr;
                    I[4] = I[4] + 1;
                    AppMethodBeat.o(42174);
                    return;
                }
                LuckyMoneyF2FQRCodeUI.this.nUY.jU("touch_card.m4a");
                I = LuckyMoneyF2FQRCodeUI.this.gCr;
                I[2] = I[2] + 1;
                AppMethodBeat.o(42174);
            }

            public final void xL(int i) {
                AppMethodBeat.i(42175);
                LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
                int[] I;
                if (i != 8) {
                    LuckyMoneyF2FQRCodeUI.this.nUY.jU("select_card.m4a");
                    I = LuckyMoneyF2FQRCodeUI.this.gCr;
                    I[3] = I[3] + 1;
                    AppMethodBeat.o(42175);
                    return;
                }
                I = LuckyMoneyF2FQRCodeUI.this.gCr;
                I[5] = I[5] + 1;
                AppMethodBeat.o(42175);
            }

            public final void es(int i, int i2) {
                AppMethodBeat.i(42176);
                if (i2 == 8) {
                    LuckyMoneyF2FQRCodeUI.this.nUY.jU("music" + (i + 1) + MediaConfig.VIDEO_AAC_FILE_POSTFIX);
                    AppMethodBeat.o(42176);
                    return;
                }
                LuckyMoneyF2FQRCodeUI.this.nUY.jU("select_card.m4a");
                AppMethodBeat.o(42176);
            }
        });
        bLi();
        this.nVb = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.nVb.setDuration(300);
        this.nVb.setStartDelay(3000);
        this.nVb.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(42177);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LuckyMoneyF2FQRCodeUI.this.nUF.setTranslationY((-0.5f * floatValue) * ((float) LuckyMoneyF2FQRCodeUI.this.ghw.heightPixels));
                LuckyMoneyF2FQRCodeUI.this.nUX.setAlpha(1.0f - floatValue);
                if (floatValue == 1.0f) {
                    LuckyMoneyF2FQRCodeUI.this.nUF.setVisibility(8);
                    LuckyMoneyF2FQRCodeUI.this.nUF.setTranslationY(0.0f);
                    LuckyMoneyF2FQRCodeUI.L(LuckyMoneyF2FQRCodeUI.this);
                    LuckyMoneyF2FQRCodeUI.this.nUQ.notifyDataSetChanged();
                    LuckyMoneyF2FQRCodeUI.this.nUM.dzv();
                }
                AppMethodBeat.o(42177);
            }
        });
        bLh();
        getWindow().addFlags(128);
        AppMethodBeat.o(42195);
    }

    private void bLh() {
        AppMethodBeat.i(42196);
        if (!bo.isNullOrNil(this.lvz)) {
            this.mBitmap = com.tencent.mm.bw.a.a.bF(this, this.lvz);
            this.nUJ.setImageBitmap(this.mBitmap);
        }
        if (this.nUt <= 0) {
            this.nUJ.setPadding(com.tencent.mm.bz.a.fromDPToPix(this, 5), com.tencent.mm.bz.a.fromDPToPix(this, 5), com.tencent.mm.bz.a.fromDPToPix(this, 5), com.tencent.mm.bz.a.fromDPToPix(this, 5));
            this.nUJ.setImageResource(R.drawable.b94);
            this.nUR.setVisibility(8);
            this.nTg.setVisibility(0);
            this.nUK.setVisibility(4);
            this.nUE.setPadding(this.nUE.getPaddingLeft(), f.de(this), this.nUE.getPaddingRight(), this.nUE.getPaddingBottom());
            if (this.nUN.size() > 0) {
                this.nUL.setText(getString(R.string.cqr));
                AppMethodBeat.o(42196);
                return;
            }
            this.nUL.setText(getString(R.string.cqs));
            AppMethodBeat.o(42196);
            return;
        }
        this.nUJ.setPadding(0, 0, 0, 0);
        this.nUK.setText(getString(R.string.cqx));
        this.nUK.setVisibility(0);
        this.nUL.setText(getString(R.string.cqx));
        this.nUR.setText(getString(R.string.cqw, new Object[]{Integer.valueOf(this.nUt)}));
        this.nUR.setVisibility(0);
        this.nTg.setVisibility(8);
        AppMethodBeat.o(42196);
    }

    private void bLi() {
        AppMethodBeat.i(42197);
        HashSet hashSet = new HashSet();
        hashSet.add("touch_card.m4a");
        hashSet.add("select_card.m4a");
        for (int i = 1; i <= 8; i++) {
            hashSet.add("music" + i + MediaConfig.VIDEO_AAC_FILE_POSTFIX);
        }
        hashSet.add("packet_received.m4a");
        hashSet.add("most_lucky.m4a");
        hashSet.add("whistle.m4a");
        com.tencent.mm.plugin.luckymoney.f2f.a aVar = this.nUY;
        g.RS().aa(new com.tencent.mm.plugin.luckymoney.f2f.a.AnonymousClass1(hashSet, new WeakReference(this)));
        aVar.nTR.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
                AppMethodBeat.i(42142);
                if (i2 == 0) {
                    a.this.nTT.put(Integer.valueOf(i), Boolean.TRUE);
                    AppMethodBeat.o(42142);
                    return;
                }
                a.this.nTT.put(Integer.valueOf(i), Boolean.FALSE);
                AppMethodBeat.o(42142);
            }
        });
        AppMethodBeat.o(42197);
    }

    private void bLj() {
        AppMethodBeat.i(42198);
        int width = this.nUM.getWidth() - (this.nUN.size() * getResources().getDimensionPixelSize(R.dimen.dp));
        if (width > 0) {
            this.nUM.setPadding(width / 2, 0, width / 2, 0);
            AppMethodBeat.o(42198);
            return;
        }
        this.nUM.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(42198);
    }

    private void bLk() {
        AppMethodBeat.i(42199);
        if (this.nUU.size() != this.nUt) {
            ab.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", Integer.valueOf(this.nUU.size()), Integer.valueOf(this.nUt));
            this.nUU.clear();
            for (int i = 0; i < this.nUt; i++) {
                View inflate = LayoutInflater.from(this).inflate(R.layout.aa4, this.nUS, false);
                ((LayoutParams) inflate.getLayoutParams()).gravity = 81;
                this.nUU.add(inflate);
            }
            this.nUS.setAllShuffleCards(this.nUU);
        }
        AppMethodBeat.o(42199);
    }

    public void onResume() {
        AppMethodBeat.i(42200);
        super.onResume();
        b(new e(), true);
        this.gGo.ae(60000, 60000);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("ffopenwxhb", this.nVf, true);
        nf(1990);
        nf(1987);
        nf(1971);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        bc.a(this, this);
        if (this.bCW != null) {
            this.bCW.registerListener(this.nVv, this.bCW.getDefaultSensor(1), 3);
        }
        AppMethodBeat.o(42200);
    }

    public void onStop() {
        AppMethodBeat.i(42201);
        super.onStop();
        this.gGo.stopTimer();
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("ffopenwxhb", this.nVf, true);
        ng(1990);
        ng(1987);
        ng(1971);
        bc.a(this, null);
        AppMethodBeat.o(42201);
    }

    public void onPause() {
        AppMethodBeat.i(42202);
        super.onPause();
        if (this.bCW != null) {
            this.bCW.unregisterListener(this.nVv);
        }
        AppMethodBeat.o(42202);
    }

    public void onDestroy() {
        AppMethodBeat.i(42203);
        com.tencent.mm.plugin.report.service.h.pYm.e(14007, Integer.valueOf(this.gCr[0]), Integer.valueOf(this.gCr[1]), Integer.valueOf(this.gCr[2]), Integer.valueOf(this.gCr[3]), Integer.valueOf(this.gCr[4]), Integer.valueOf(this.gCr[5]));
        com.tencent.mm.plugin.luckymoney.f2f.a aVar = this.nUY;
        aVar.jxQ = true;
        aVar.nTR.release();
        getWindow().clearFlags(128);
        super.onDestroy();
        AppMethodBeat.o(42203);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return R.layout.aa5;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        int i3 = 0;
        AppMethodBeat.i(42204);
        ab.i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof e) {
                ab.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.nSX);
                if (!(bo.Q(this.nSX, ((e) mVar).nSX) || this.nSX.equals(((e) mVar).nSX))) {
                    this.nUN.clear();
                    this.nUO.clear();
                    this.nUP.clear();
                    this.nUQ.notifyDataSetChanged();
                    this.nVa = "";
                }
                if (!bo.isNullOrNil(((e) mVar).nSX)) {
                    this.nSX = ((e) mVar).nSX;
                }
                this.lvz = ((e) mVar).lvz;
                this.nUt = ((e) mVar).nUt;
                this.nUs = ((e) mVar).nUs;
                bLh();
                bLk();
                if (this.nUt == 0) {
                    this.gGo.stopTimer();
                }
                if (this.nUN.size() == 0 && !bo.isNullOrNil(this.nSX)) {
                    b(new af(this.nSX, 5, 0, null, "v1.0"), false);
                }
            } else if (mVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a) {
                this.nSX = "";
                this.lvz = "";
                this.nUt = 0;
                this.nUN.clear();
                this.nVa = "";
                this.nUQ.notifyDataSetChanged();
                bLh();
                bLk();
                this.gGo.stopTimer();
                if (!bo.isNullOrNil(this.nUs)) {
                    h.bQ(this, this.nUs);
                }
            } else if (mVar instanceof af) {
                this.nUZ = ((af) mVar).nYn.nWU;
                LinkedList linkedList = ((af) mVar).nYn.nXj;
                if (linkedList != null && linkedList.size() > 0) {
                    while (i3 < linkedList.size()) {
                        w wVar = (w) linkedList.get(i3);
                        if (!(bo.isNullOrNil(wVar.nWX) || this.nUN.contains(wVar.nWX))) {
                            this.nUN.add(wVar.nWX);
                            String str2 = wVar.userName;
                            if (!bo.isNullOrNil(wVar.nYc)) {
                                this.nVa = str2;
                            }
                            this.nUO.put(wVar.nWX, str2);
                        }
                        i3++;
                    }
                    bLj();
                    this.nUQ.notifyDataSetChanged();
                }
            } else if (mVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.b) {
                ab.i("LuckyMoneyF2FQRCodeUI", "onSceneEnd NetSceneF2FLuckyMoneyInvalid");
                this.retCode = ((com.tencent.mm.plugin.luckymoney.f2f.a.b) mVar).kCl;
                this.hwA = ((com.tencent.mm.plugin.luckymoney.f2f.a.b) mVar).kCm;
                ab.i("LuckyMoneyF2FQRCodeUI", "retcode:%d", Integer.valueOf(i), Integer.valueOf(i2), str);
            }
        } else if (!bo.isNullOrNil(str)) {
            h.b((Context) this, str, getString(R.string.tz), true);
        }
        AppMethodBeat.o(42204);
        return true;
    }

    public final void aNW() {
        AppMethodBeat.i(42205);
        ab.i("LuckyMoneyF2FQRCodeUI", "screenShot");
        if (this.nUt > 0) {
            String str = this.lvz;
            ab.i("LuckyMoneyF2FQRCodeUI", "invalidQRCode");
            b(new com.tencent.mm.plugin.luckymoney.f2f.a.b(str), false);
            ab.i("LuckyMoneyF2FQRCodeUI", "getQRCode");
            b(new e(), false);
            bLh();
            int[] iArr = this.gCr;
            iArr[1] = iArr[1] + 1;
            h.b((Context) this, getString(R.string.cqy), null, true);
        }
        AppMethodBeat.o(42205);
    }

    static /* synthetic */ void h(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        AppMethodBeat.i(42206);
        luckyMoneyF2FQRCodeUI.b(new com.tencent.mm.plugin.luckymoney.f2f.a.a(luckyMoneyF2FQRCodeUI.nSX), false);
        AppMethodBeat.o(42206);
    }

    static /* synthetic */ Bitmap a(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI, int i, int i2) {
        AppMethodBeat.i(42207);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(luckyMoneyF2FQRCodeUI.getResources(), i), i2, i2, false);
        AppMethodBeat.o(42207);
        return createScaledBitmap;
    }

    static /* synthetic */ void G(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        AppMethodBeat.i(42208);
        luckyMoneyF2FQRCodeUI.nUG = (ImageView) luckyMoneyF2FQRCodeUI.nUF.findViewById(R.id.cwe);
        luckyMoneyF2FQRCodeUI.nUH = (TextView) luckyMoneyF2FQRCodeUI.nUF.findViewById(R.id.cwf);
        luckyMoneyF2FQRCodeUI.nUI = (TextView) luckyMoneyF2FQRCodeUI.nUF.findViewById(R.id.cwg);
        Pair pair = (Pair) luckyMoneyF2FQRCodeUI.nUP.poll();
        if (pair != null) {
            x.b(luckyMoneyF2FQRCodeUI.nUG, null, (String) pair.first);
            x.a((Context) luckyMoneyF2FQRCodeUI, luckyMoneyF2FQRCodeUI.nUH, x.mI((String) pair.first));
            luckyMoneyF2FQRCodeUI.nUI.setText(com.tencent.mm.wallet_core.ui.e.F(((double) ((Integer) pair.second).intValue()) / 100.0d));
            if (!bo.isNullOrNil(luckyMoneyF2FQRCodeUI.nVa) && luckyMoneyF2FQRCodeUI.nVa.equals(pair.first)) {
                com.tencent.mm.plugin.luckymoney.particles.a.a(luckyMoneyF2FQRCodeUI.nUV, luckyMoneyF2FQRCodeUI.nVt).P(800, 100);
                com.tencent.mm.plugin.luckymoney.particles.a.a(luckyMoneyF2FQRCodeUI.nUW, luckyMoneyF2FQRCodeUI.nVu).P(800, 100);
                luckyMoneyF2FQRCodeUI.nUY.jU("most_lucky.m4a");
                if (((Integer) pair.second).intValue() >= 19000) {
                    luckyMoneyF2FQRCodeUI.nUY.jU("whistle.m4a");
                }
            }
        }
        AppMethodBeat.o(42208);
    }
}
