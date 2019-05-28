package com.tencent.p177mm.plugin.luckymoney.f2f.p448ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p1529bw.p1530a.C37623a;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.HorizontalListViewV2;
import com.tencent.p177mm.p612ui.base.HorizontalListViewV2.C36048d;
import com.tencent.p177mm.p612ui.base.HorizontalListViewV2.C36048d.C36049a;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.luckymoney.f2f.C3369a;
import com.tencent.p177mm.plugin.luckymoney.f2f.C3369a.C33701;
import com.tencent.p177mm.plugin.luckymoney.f2f.C3369a.C33712;
import com.tencent.p177mm.plugin.luckymoney.f2f.p1279a.C21196e;
import com.tencent.p177mm.plugin.luckymoney.f2f.p1279a.C39311b;
import com.tencent.p177mm.plugin.luckymoney.f2f.p1279a.C43253a;
import com.tencent.p177mm.plugin.luckymoney.f2f.p448ui.ShuffleView.C3380c;
import com.tencent.p177mm.plugin.luckymoney.f2f.p448ui.ShuffleView.C344375;
import com.tencent.p177mm.plugin.luckymoney.f2f.p448ui.ShuffleView.C34438a;
import com.tencent.p177mm.plugin.luckymoney.f2f.p448ui.ShuffleView.C34439b;
import com.tencent.p177mm.plugin.luckymoney.model.C12425af;
import com.tencent.p177mm.plugin.luckymoney.model.C39323w;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyBaseUI;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyBeforeDetailUI;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyPrepareUI;
import com.tencent.p177mm.plugin.luckymoney.particles.C34448b;
import com.tencent.p177mm.plugin.luckymoney.particles.C39324a;
import com.tencent.p177mm.plugin.luckymoney.particles.p1280a.C21210a;
import com.tencent.p177mm.plugin.luckymoney.particles.p1280a.C28430b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.sdk.platformtools.C30292bc;
import com.tencent.p177mm.sdk.platformtools.C30292bc.C23502a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
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

/* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI */
public class LuckyMoneyF2FQRCodeUI extends LuckyMoneyBaseUI implements C23502a {
    private View abB;
    private SensorManager bCW;
    private int[] gCr;
    private C7564ap gGo;
    private DisplayMetrics ghw;
    private String hwA;
    private C36356d iHZ;
    private C5279d kFW = new C284179();
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
    private C28414a nUQ;
    private TextView nUR;
    private ShuffleView nUS;
    private C3380c nUT;
    private List<View> nUU;
    private ViewGroup nUV;
    private ViewGroup nUW;
    private View nUX;
    private C3369a nUY;
    private long nUZ;
    private String nUs;
    private int nUt;
    private String nVa;
    private ValueAnimator nVb;
    private float nVc;
    private float nVd;
    private float nVe;
    private C1837a nVf = new C284201();
    private C36073c nVg = new C284218();
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
    private C34448b nVt = new C2840910();
    private C34448b nVu = new C2841011();
    final SensorEventListener nVv = new C124187();
    private int retCode;

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$4 */
    class C124164 implements C34438a {
        C124164() {
        }

        /* renamed from: a */
        public final void mo24271a(ValueAnimator valueAnimator, View view) {
            AppMethodBeat.m2504i(42173);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue == 0.0f) {
                LuckyMoneyF2FQRCodeUI.this.nVc = view.getTranslationX();
                LuckyMoneyF2FQRCodeUI.this.nVd = view.getTranslationY();
                view.findViewById(2131825501).setVisibility(0);
            }
            view.setTranslationX((1.0f - floatValue) * LuckyMoneyF2FQRCodeUI.this.nVc);
            view.setTranslationY(((1.0f - floatValue) * LuckyMoneyF2FQRCodeUI.this.nVd) - ((((float) LuckyMoneyF2FQRCodeUI.this.nUS.getHeight()) + (LuckyMoneyF2FQRCodeUI.this.nVd * 8.0f)) * floatValue));
            view.setScaleX((0.5f * floatValue) + 1.0f);
            view.setScaleY((0.5f * floatValue) + 1.0f);
            Pair pair = (Pair) LuckyMoneyF2FQRCodeUI.this.nUP.peek();
            if (!(pair == null || C5046bo.isNullOrNil(LuckyMoneyF2FQRCodeUI.this.nVa) || !LuckyMoneyF2FQRCodeUI.this.nVa.equals(pair.first))) {
                LuckyMoneyF2FQRCodeUI.this.nUX.setAlpha(floatValue);
            }
            C4990ab.m7417i("LuckyMoneyF2FQRCodeUI", "fireworkBottomLayer %f", Float.valueOf(floatValue));
            if (floatValue >= 0.9f) {
                view.setAlpha((1.0f - floatValue) * 10.0f);
                LuckyMoneyF2FQRCodeUI.this.nUF.setAlpha(1.0f - ((1.0f - floatValue) * 10.0f));
                LuckyMoneyF2FQRCodeUI.this.nUF.setScaleX(floatValue);
                LuckyMoneyF2FQRCodeUI.this.nUF.setScaleY(floatValue);
                LuckyMoneyF2FQRCodeUI.this.nUF.setVisibility(0);
            }
            if (floatValue == 1.0f) {
                LuckyMoneyF2FQRCodeUI.this.nUY.mo7780jU("packet_received.m4a");
                LuckyMoneyF2FQRCodeUI.this.nUS.removeView(LuckyMoneyF2FQRCodeUI.this.nUS.getExitView());
                LuckyMoneyF2FQRCodeUI.m45053G(LuckyMoneyF2FQRCodeUI.this);
                LuckyMoneyF2FQRCodeUI.this.nVb.start();
            }
            AppMethodBeat.m2505o(42173);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$5 */
    class C124175 implements C34439b {
        C124175() {
        }

        /* renamed from: er */
        public final void mo24272er(int i, int i2) {
            AppMethodBeat.m2504i(42174);
            int[] I;
            if (i2 == 8) {
                LuckyMoneyF2FQRCodeUI.this.nUY.mo7780jU("music" + (i + 1) + MediaConfig.VIDEO_AAC_FILE_POSTFIX);
                I = LuckyMoneyF2FQRCodeUI.this.gCr;
                I[4] = I[4] + 1;
                AppMethodBeat.m2505o(42174);
                return;
            }
            LuckyMoneyF2FQRCodeUI.this.nUY.mo7780jU("touch_card.m4a");
            I = LuckyMoneyF2FQRCodeUI.this.gCr;
            I[2] = I[2] + 1;
            AppMethodBeat.m2505o(42174);
        }

        /* renamed from: xL */
        public final void mo24274xL(int i) {
            AppMethodBeat.m2504i(42175);
            LuckyMoneyF2FQRCodeUI.m45056J(LuckyMoneyF2FQRCodeUI.this);
            int[] I;
            if (i != 8) {
                LuckyMoneyF2FQRCodeUI.this.nUY.mo7780jU("select_card.m4a");
                I = LuckyMoneyF2FQRCodeUI.this.gCr;
                I[3] = I[3] + 1;
                AppMethodBeat.m2505o(42175);
                return;
            }
            I = LuckyMoneyF2FQRCodeUI.this.gCr;
            I[5] = I[5] + 1;
            AppMethodBeat.m2505o(42175);
        }

        /* renamed from: es */
        public final void mo24273es(int i, int i2) {
            AppMethodBeat.m2504i(42176);
            if (i2 == 8) {
                LuckyMoneyF2FQRCodeUI.this.nUY.mo7780jU("music" + (i + 1) + MediaConfig.VIDEO_AAC_FILE_POSTFIX);
                AppMethodBeat.m2505o(42176);
                return;
            }
            LuckyMoneyF2FQRCodeUI.this.nUY.mo7780jU("select_card.m4a");
            AppMethodBeat.m2505o(42176);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$7 */
    class C124187 implements SensorEventListener {
        final int nVA = 3;
        float nVB = ((float) C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.f9966lo));
        int nVC;
        ValueAnimator nVD;
        float neH;

        /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$7$1 */
        class C124191 implements AnimatorUpdateListener {
            C124191() {
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.m2504i(42178);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LuckyMoneyF2FQRCodeUI.this.nUE.setPadding(LuckyMoneyF2FQRCodeUI.this.nUE.getPaddingLeft(), (int) floatValue, LuckyMoneyF2FQRCodeUI.this.nUE.getPaddingRight(), LuckyMoneyF2FQRCodeUI.this.nUE.getPaddingBottom());
                floatValue /= (float) C124187.this.nVC;
                if (floatValue <= 1.0f) {
                    LuckyMoneyF2FQRCodeUI.this.nUK.setAlpha((1.0f - floatValue) + LuckyMoneyF2FQRCodeUI.this.nVe);
                    LuckyMoneyF2FQRCodeUI.this.nUL.setAlpha(floatValue * LuckyMoneyF2FQRCodeUI.this.nVe);
                    AppMethodBeat.m2505o(42178);
                    return;
                }
                LuckyMoneyF2FQRCodeUI.this.nUK.setAlpha(LuckyMoneyF2FQRCodeUI.this.nVe);
                LuckyMoneyF2FQRCodeUI.this.nUL.setAlpha(LuckyMoneyF2FQRCodeUI.this.nVe);
                AppMethodBeat.m2505o(42178);
            }
        }

        C124187() {
            AppMethodBeat.m2504i(42179);
            AppMethodBeat.m2505o(42179);
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            float f = -3.0f;
            AppMethodBeat.m2504i(42180);
            if (sensorEvent.sensor.getType() == 1) {
                if (LuckyMoneyF2FQRCodeUI.this.nUt <= 0) {
                    AppMethodBeat.m2505o(42180);
                    return;
                }
                if (this.nVC == 0) {
                    this.nVC = C30036f.m47542de(LuckyMoneyF2FQRCodeUI.this) + ((int) this.nVB);
                }
                float f2 = sensorEvent.values[1];
                if (((double) Math.abs(f2 - this.neH)) < 0.05d) {
                    AppMethodBeat.m2505o(42180);
                    return;
                }
                this.neH = f2;
                C4990ab.m7411d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", Float.valueOf(f2));
                if (f2 >= -3.0f) {
                    if (f2 > 0.0f) {
                        f = 0.0f;
                    } else {
                        f = f2;
                    }
                }
                f = ((f / 3.0f) * ((float) this.nVC)) + ((float) this.nVC);
                C4990ab.m7411d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", Float.valueOf(f), Integer.valueOf(LuckyMoneyF2FQRCodeUI.this.nUE.getPaddingTop()));
                if (this.nVD != null) {
                    this.nVD.cancel();
                }
                this.nVD = ValueAnimator.ofFloat(new float[]{(float) LuckyMoneyF2FQRCodeUI.this.nUE.getPaddingTop(), f}).setDuration(200);
                this.nVD.addUpdateListener(new C124191());
                this.nVD.start();
            }
            AppMethodBeat.m2505o(42180);
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
            AppMethodBeat.m2504i(42181);
            C4990ab.m7416i("LuckyMoneyF2FQRCodeUI", "onAccuracyChanged");
            AppMethodBeat.m2505o(42181);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$10 */
    class C2840910 implements C34448b {
        C2840910() {
        }

        /* renamed from: b */
        public final C28430b mo24309b(Random random) {
            AppMethodBeat.m2504i(42184);
            int nextInt = random.nextInt(100);
            C28430b c21210a;
            if (nextInt < 16) {
                if (LuckyMoneyF2FQRCodeUI.this.nVk == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVk = LuckyMoneyF2FQRCodeUI.m45065a(LuckyMoneyF2FQRCodeUI.this, C25738R.drawable.b9_, 36);
                }
                C21210a c21210a2 = new C21210a(LuckyMoneyF2FQRCodeUI.this.nVk);
                AppMethodBeat.m2505o(42184);
                return c21210a2;
            } else if (nextInt < 33) {
                if (LuckyMoneyF2FQRCodeUI.this.nVl == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVl = LuckyMoneyF2FQRCodeUI.m45065a(LuckyMoneyF2FQRCodeUI.this, C25738R.drawable.b9a, 36);
                }
                c21210a = new C21210a(LuckyMoneyF2FQRCodeUI.this.nVl);
                AppMethodBeat.m2505o(42184);
                return c21210a;
            } else if (nextInt < 50) {
                if (LuckyMoneyF2FQRCodeUI.this.nVm == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVm = LuckyMoneyF2FQRCodeUI.m45065a(LuckyMoneyF2FQRCodeUI.this, C25738R.drawable.b9b, 36);
                }
                c21210a = new C21210a(LuckyMoneyF2FQRCodeUI.this.nVm);
                AppMethodBeat.m2505o(42184);
                return c21210a;
            } else if (nextInt < 70) {
                if (LuckyMoneyF2FQRCodeUI.this.nVh == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVh = LuckyMoneyF2FQRCodeUI.m45065a(LuckyMoneyF2FQRCodeUI.this, C25738R.drawable.b95, 36);
                }
                c21210a = new C21210a(LuckyMoneyF2FQRCodeUI.this.nVh);
                AppMethodBeat.m2505o(42184);
                return c21210a;
            } else if (nextInt < 90) {
                if (LuckyMoneyF2FQRCodeUI.this.nVi == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVi = LuckyMoneyF2FQRCodeUI.m45065a(LuckyMoneyF2FQRCodeUI.this, C25738R.drawable.b96, 36);
                }
                c21210a = new C21210a(LuckyMoneyF2FQRCodeUI.this.nVi);
                AppMethodBeat.m2505o(42184);
                return c21210a;
            } else {
                if (LuckyMoneyF2FQRCodeUI.this.nVj == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVj = LuckyMoneyF2FQRCodeUI.m45065a(LuckyMoneyF2FQRCodeUI.this, C25738R.drawable.b97, 36);
                }
                c21210a = new C21210a(LuckyMoneyF2FQRCodeUI.this.nVj);
                AppMethodBeat.m2505o(42184);
                return c21210a;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$11 */
    class C2841011 implements C34448b {
        C2841011() {
        }

        /* renamed from: b */
        public final C28430b mo24309b(Random random) {
            AppMethodBeat.m2504i(42185);
            int nextInt = random.nextInt(100);
            C28430b c21210a;
            if (nextInt < 10) {
                if (LuckyMoneyF2FQRCodeUI.this.nVq == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVq = LuckyMoneyF2FQRCodeUI.m45065a(LuckyMoneyF2FQRCodeUI.this, C25738R.drawable.b9_, 32);
                }
                C21210a c21210a2 = new C21210a(LuckyMoneyF2FQRCodeUI.this.nVq);
                AppMethodBeat.m2505o(42185);
                return c21210a2;
            } else if (nextInt < 20) {
                if (LuckyMoneyF2FQRCodeUI.this.nVr == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVr = LuckyMoneyF2FQRCodeUI.m45065a(LuckyMoneyF2FQRCodeUI.this, C25738R.drawable.b9a, 32);
                }
                c21210a = new C21210a(LuckyMoneyF2FQRCodeUI.this.nVr);
                AppMethodBeat.m2505o(42185);
                return c21210a;
            } else if (nextInt < 30) {
                if (LuckyMoneyF2FQRCodeUI.this.nVs == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVs = LuckyMoneyF2FQRCodeUI.m45065a(LuckyMoneyF2FQRCodeUI.this, C25738R.drawable.b9b, 32);
                }
                c21210a = new C21210a(LuckyMoneyF2FQRCodeUI.this.nVs);
                AppMethodBeat.m2505o(42185);
                return c21210a;
            } else if (nextInt < 50) {
                if (LuckyMoneyF2FQRCodeUI.this.nVn == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVn = LuckyMoneyF2FQRCodeUI.m45065a(LuckyMoneyF2FQRCodeUI.this, C25738R.drawable.b95, 32);
                }
                c21210a = new C21210a(LuckyMoneyF2FQRCodeUI.this.nVn);
                AppMethodBeat.m2505o(42185);
                return c21210a;
            } else if (nextInt < 75) {
                if (LuckyMoneyF2FQRCodeUI.this.nVo == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVo = LuckyMoneyF2FQRCodeUI.m45065a(LuckyMoneyF2FQRCodeUI.this, C25738R.drawable.b96, 32);
                }
                c21210a = new C21210a(LuckyMoneyF2FQRCodeUI.this.nVo);
                AppMethodBeat.m2505o(42185);
                return c21210a;
            } else {
                if (LuckyMoneyF2FQRCodeUI.this.nVp == null) {
                    LuckyMoneyF2FQRCodeUI.this.nVp = LuckyMoneyF2FQRCodeUI.m45065a(LuckyMoneyF2FQRCodeUI.this, C25738R.drawable.b97, 32);
                }
                c21210a = new C21210a(LuckyMoneyF2FQRCodeUI.this.nVp);
                AppMethodBeat.m2505o(42185);
                return c21210a;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$12 */
    class C2841112 implements C5015a {
        C2841112() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(42186);
            LuckyMoneyF2FQRCodeUI.this.mo24301b(new C21196e(), false);
            AppMethodBeat.m2505o(42186);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$13 */
    class C2841213 implements OnItemClickListener {
        C2841213() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(42187);
            Intent intent = new Intent(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyBeforeDetailUI.class);
            intent.putExtra("key_sendid", LuckyMoneyF2FQRCodeUI.this.nSX);
            LuckyMoneyF2FQRCodeUI.this.startActivity(intent);
            AppMethodBeat.m2505o(42187);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$6 */
    class C284136 implements AnimatorUpdateListener {
        C284136() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(42177);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            LuckyMoneyF2FQRCodeUI.this.nUF.setTranslationY((-0.5f * floatValue) * ((float) LuckyMoneyF2FQRCodeUI.this.ghw.heightPixels));
            LuckyMoneyF2FQRCodeUI.this.nUX.setAlpha(1.0f - floatValue);
            if (floatValue == 1.0f) {
                LuckyMoneyF2FQRCodeUI.this.nUF.setVisibility(8);
                LuckyMoneyF2FQRCodeUI.this.nUF.setTranslationY(0.0f);
                LuckyMoneyF2FQRCodeUI.m45058L(LuckyMoneyF2FQRCodeUI.this);
                LuckyMoneyF2FQRCodeUI.this.nUQ.notifyDataSetChanged();
                LuckyMoneyF2FQRCodeUI.this.nUM.dzv();
            }
            AppMethodBeat.m2505o(42177);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$a */
    class C28414a extends BaseAdapter {

        /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$a$a */
        class C12420a {
            ImageView goC;
            ImageView nVF;

            C12420a() {
            }
        }

        private C28414a() {
        }

        /* synthetic */ C28414a(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(42190);
            int size = LuckyMoneyF2FQRCodeUI.this.nUN.size();
            AppMethodBeat.m2505o(42190);
            return size;
        }

        private String getItem(int i) {
            AppMethodBeat.m2504i(42191);
            String str = (String) LuckyMoneyF2FQRCodeUI.this.nUN.get(i);
            AppMethodBeat.m2505o(42191);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C12420a c12420a;
            AppMethodBeat.m2504i(42192);
            if (view == null) {
                view = LayoutInflater.from(LuckyMoneyF2FQRCodeUI.this).inflate(2130969982, null);
                ImageView imageView = (ImageView) view.findViewById(2131825525);
                ImageView imageView2 = (ImageView) view.findViewById(2131825526);
                C12420a c12420a2 = new C12420a();
                c12420a2.goC = imageView;
                c12420a2.nVF = imageView2;
                view.setTag(c12420a2);
                c12420a = c12420a2;
            } else {
                c12420a = (C12420a) view.getTag();
            }
            String str = (String) LuckyMoneyF2FQRCodeUI.this.nUO.get(getItem(i));
            C46063x.m85811b(c12420a.goC, null, str);
            if (C5046bo.isNullOrNil(LuckyMoneyF2FQRCodeUI.this.nVa) || !LuckyMoneyF2FQRCodeUI.this.nVa.equals(str)) {
                c12420a.nVF.setVisibility(4);
            } else {
                c12420a.nVF.setVisibility(0);
            }
            AppMethodBeat.m2505o(42192);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$2 */
    class C284152 implements OnMenuItemClickListener {
        C284152() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42171);
            LuckyMoneyF2FQRCodeUI.this.finish();
            AppMethodBeat.m2505o(42171);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$3 */
    class C284163 implements OnMenuItemClickListener {
        C284163() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42172);
            LuckyMoneyF2FQRCodeUI.this.iHZ = new C36356d(LuckyMoneyF2FQRCodeUI.this, 1, false);
            LuckyMoneyF2FQRCodeUI.this.iHZ.rBl = LuckyMoneyF2FQRCodeUI.this.nVg;
            LuckyMoneyF2FQRCodeUI.this.iHZ.rBm = LuckyMoneyF2FQRCodeUI.this.kFW;
            LuckyMoneyF2FQRCodeUI.this.iHZ.cpD();
            AppMethodBeat.m2505o(42172);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$9 */
    class C284179 implements C5279d {
        C284179() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(42183);
            switch (menuItem.getItemId()) {
                case 1:
                    if (LuckyMoneyF2FQRCodeUI.this.nUt <= 0) {
                        C30379h.m48465bQ(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.this.getString(C25738R.string.cqn));
                        break;
                    }
                    LuckyMoneyF2FQRCodeUI.m45084h(LuckyMoneyF2FQRCodeUI.this);
                    AppMethodBeat.m2505o(42183);
                    return;
            }
            AppMethodBeat.m2505o(42183);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$14 */
    class C2841814 implements C36048d {
        C2841814() {
        }

        /* renamed from: a */
        public final void mo46398a(C36049a c36049a) {
            AppMethodBeat.m2504i(42188);
            if (c36049a == C36049a.SCROLL_STATE_IDLE && LuckyMoneyF2FQRCodeUI.this.nUN.size() >= 5 && ((long) LuckyMoneyF2FQRCodeUI.this.nUN.size()) < LuckyMoneyF2FQRCodeUI.this.nUZ && LuckyMoneyF2FQRCodeUI.this.nUM.getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.this.nUN.size() - 1 && !C5046bo.isNullOrNil(LuckyMoneyF2FQRCodeUI.this.nSX)) {
                LuckyMoneyF2FQRCodeUI.this.mo24304n(new C12425af(LuckyMoneyF2FQRCodeUI.this.nSX, 5, LuckyMoneyF2FQRCodeUI.this.nUN.size(), null, "v1.0"));
            }
            AppMethodBeat.m2505o(42188);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$15 */
    class C2841915 implements OnClickListener {
        C2841915() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42189);
            Intent intent = new Intent(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyPrepareUI.class);
            intent.putExtra("key_from", 2);
            LuckyMoneyF2FQRCodeUI.this.startActivity(intent);
            AppMethodBeat.m2505o(42189);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$1 */
    class C284201 implements C1837a {
        C284201() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(42170);
            Map z = C5049br.m7595z(C1946aa.m4148a(c1197a.eAB.vED), "sysmsg");
            if (z != null) {
                String str = (String) z.get(".sysmsg.sendId");
                final String str2 = (String) z.get(".sysmsg.username");
                final String str3 = (String) z.get(".sysmsg.amount");
                final String str4 = (String) z.get(".sysmsg.receiveId");
                if (C5046bo.getInt((String) z.get(".sysmsg.islucky"), 0) > 0) {
                    LuckyMoneyF2FQRCodeUI.this.nVa = str2;
                }
                if (!C5046bo.m7510Q(str, str2, str3)) {
                    LuckyMoneyF2FQRCodeUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(42169);
                            if (!LuckyMoneyF2FQRCodeUI.this.nUN.contains(str4)) {
                                LuckyMoneyF2FQRCodeUI.this.nUN.add(0, str4);
                                if (!C1855t.m3912mY(str2)) {
                                    C17880h c17880h = new C17880h();
                                    c17880h.username = str2;
                                    C17884o.act().mo33391b(c17880h);
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
                                        c.mo68789xQ(c.nVZ);
                                        if (c.nWc > 0) {
                                            c.nVZ = c.bLm();
                                            c.gCO = (View) c.nVP.get(c.nVZ);
                                        } else {
                                            c.gCO = null;
                                            c.nVZ = 0;
                                        }
                                    } else {
                                        c.mo68788xO(c.bLm());
                                        c.nVX = c.gCO;
                                        c.nVT.addListener(new C344375());
                                    }
                                }
                                LuckyMoneyF2FQRCodeUI.this.nUU.remove(LuckyMoneyF2FQRCodeUI.this.nUS.getExitView());
                                LuckyMoneyF2FQRCodeUI.this.gGo.mo16770ae(0, 60000);
                                LuckyMoneyF2FQRCodeUI.this.nUP.add(new Pair(str2, Integer.valueOf(C5046bo.getInt(str3, 0))));
                            }
                            AppMethodBeat.m2505o(42169);
                        }
                    });
                }
            }
            AppMethodBeat.m2505o(42170);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$8 */
    class C284218 implements C36073c {
        C284218() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(42182);
            c44273l.mo70072hi(1, C25738R.string.cqm);
            AppMethodBeat.m2505o(42182);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LuckyMoneyF2FQRCodeUI() {
        AppMethodBeat.m2504i(42194);
        AppMethodBeat.m2505o(42194);
    }

    /* renamed from: J */
    static /* synthetic */ void m45056J(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        AppMethodBeat.m2504i(42209);
        luckyMoneyF2FQRCodeUI.bLh();
        AppMethodBeat.m2505o(42209);
    }

    /* renamed from: L */
    static /* synthetic */ void m45058L(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        AppMethodBeat.m2504i(42210);
        luckyMoneyF2FQRCodeUI.bLj();
        AppMethodBeat.m2505o(42210);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42195);
        super.onCreate(bundle);
        this.ghw = getResources().getDisplayMetrics();
        this.nUN = new ArrayList();
        this.nUO = new HashMap();
        this.nUP = new LinkedList();
        this.nUU = new ArrayList();
        this.gCr = new int[6];
        int[] iArr = this.gCr;
        iArr[0] = iArr[0] + 1;
        this.gGo = new C7564ap(new C2841112(), true);
        this.abB = findViewById(2131825504);
        this.nUE = findViewById(2131825502);
        this.nUL = (TextView) findViewById(2131825507);
        this.nUK = (TextView) findViewById(2131825505);
        this.nVe = this.nUL.getAlpha();
        this.nUJ = (ImageView) this.abB.findViewById(2131825506);
        this.nUM = (HorizontalListViewV2) findViewById(2131825508);
        this.nUQ = new C28414a(this, (byte) 0);
        this.nUM.setAdapter(this.nUQ);
        this.nUM.setOnItemClickListener(new C2841213());
        this.nUM.setOnScrollStateChangedListener(new C2841814());
        this.nTg = (Button) findViewById(2131825511);
        this.nTg.setOnClickListener(new C2841915());
        this.nUR = (TextView) findViewById(2131825510);
        this.nUF = findViewById(2131825513);
        setBackBtn(new C284152());
        setMMTitle(getString(C25738R.string.cqz));
        addIconOptionMenu(0, C1318a.actionbar_icon_dark_more, new C284163());
        mo17446xE(getResources().getColor(C25738R.color.f12134tl));
        dyb();
        this.nUV = (ViewGroup) findViewById(2131825519);
        this.nUW = (ViewGroup) findViewById(2131825503);
        this.nUX = findViewById(2131825512);
        this.nUX.setAlpha(0.0f);
        this.bCW = (SensorManager) getSystemService("sensor");
        this.bCW.registerListener(this.nVv, this.bCW.getDefaultSensor(1), 3);
        this.nUY = new C3369a();
        this.nUS = (ShuffleView) findViewById(2131825509);
        this.nUT = new C3380c();
        this.nUT.nWr = 4;
        this.nUT.nWp = 2;
        this.nUT.nWq = 4;
        this.nUT.nWs = 300;
        this.nUT.scaleY = 0.0f;
        this.nUS.setShuffleSetting(this.nUT);
        ShuffleView.ghw = this.ghw;
        this.nUS.setExitAnimator(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300));
        this.nUS.setExitAnimatorListener(new C124164());
        this.nUS.setCardListener(new C124175());
        bLi();
        this.nVb = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.nVb.setDuration(300);
        this.nVb.setStartDelay(3000);
        this.nVb.addUpdateListener(new C284136());
        bLh();
        getWindow().addFlags(128);
        AppMethodBeat.m2505o(42195);
    }

    private void bLh() {
        AppMethodBeat.m2504i(42196);
        if (!C5046bo.isNullOrNil(this.lvz)) {
            this.mBitmap = C37623a.m63543bF(this, this.lvz);
            this.nUJ.setImageBitmap(this.mBitmap);
        }
        if (this.nUt <= 0) {
            this.nUJ.setPadding(C1338a.fromDPToPix(this, 5), C1338a.fromDPToPix(this, 5), C1338a.fromDPToPix(this, 5), C1338a.fromDPToPix(this, 5));
            this.nUJ.setImageResource(C25738R.drawable.b94);
            this.nUR.setVisibility(8);
            this.nTg.setVisibility(0);
            this.nUK.setVisibility(4);
            this.nUE.setPadding(this.nUE.getPaddingLeft(), C30036f.m47542de(this), this.nUE.getPaddingRight(), this.nUE.getPaddingBottom());
            if (this.nUN.size() > 0) {
                this.nUL.setText(getString(C25738R.string.cqr));
                AppMethodBeat.m2505o(42196);
                return;
            }
            this.nUL.setText(getString(C25738R.string.cqs));
            AppMethodBeat.m2505o(42196);
            return;
        }
        this.nUJ.setPadding(0, 0, 0, 0);
        this.nUK.setText(getString(C25738R.string.cqx));
        this.nUK.setVisibility(0);
        this.nUL.setText(getString(C25738R.string.cqx));
        this.nUR.setText(getString(C25738R.string.cqw, new Object[]{Integer.valueOf(this.nUt)}));
        this.nUR.setVisibility(0);
        this.nTg.setVisibility(8);
        AppMethodBeat.m2505o(42196);
    }

    private void bLi() {
        AppMethodBeat.m2504i(42197);
        HashSet hashSet = new HashSet();
        hashSet.add("touch_card.m4a");
        hashSet.add("select_card.m4a");
        for (int i = 1; i <= 8; i++) {
            hashSet.add("music" + i + MediaConfig.VIDEO_AAC_FILE_POSTFIX);
        }
        hashSet.add("packet_received.m4a");
        hashSet.add("most_lucky.m4a");
        hashSet.add("whistle.m4a");
        C3369a c3369a = this.nUY;
        C1720g.m3539RS().mo10302aa(new C33701(hashSet, new WeakReference(this)));
        c3369a.nTR.setOnLoadCompleteListener(new C33712());
        AppMethodBeat.m2505o(42197);
    }

    private void bLj() {
        AppMethodBeat.m2504i(42198);
        int width = this.nUM.getWidth() - (this.nUN.size() * getResources().getDimensionPixelSize(C25738R.dimen.f9724dp));
        if (width > 0) {
            this.nUM.setPadding(width / 2, 0, width / 2, 0);
            AppMethodBeat.m2505o(42198);
            return;
        }
        this.nUM.setPadding(0, 0, 0, 0);
        AppMethodBeat.m2505o(42198);
    }

    private void bLk() {
        AppMethodBeat.m2504i(42199);
        if (this.nUU.size() != this.nUt) {
            C4990ab.m7417i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", Integer.valueOf(this.nUU.size()), Integer.valueOf(this.nUt));
            this.nUU.clear();
            for (int i = 0; i < this.nUt; i++) {
                View inflate = LayoutInflater.from(this).inflate(2130969979, this.nUS, false);
                ((LayoutParams) inflate.getLayoutParams()).gravity = 81;
                this.nUU.add(inflate);
            }
            this.nUS.setAllShuffleCards(this.nUU);
        }
        AppMethodBeat.m2505o(42199);
    }

    public void onResume() {
        AppMethodBeat.m2504i(42200);
        super.onResume();
        mo24301b(new C21196e(), true);
        this.gGo.mo16770ae(60000, 60000);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("ffopenwxhb", this.nVf, true);
        mo24305nf(1990);
        mo24305nf(1987);
        mo24305nf(1971);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        C30292bc.m48192a(this, this);
        if (this.bCW != null) {
            this.bCW.registerListener(this.nVv, this.bCW.getDefaultSensor(1), 3);
        }
        AppMethodBeat.m2505o(42200);
    }

    public void onStop() {
        AppMethodBeat.m2504i(42201);
        super.onStop();
        this.gGo.stopTimer();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("ffopenwxhb", this.nVf, true);
        mo24306ng(1990);
        mo24306ng(1987);
        mo24306ng(1971);
        C30292bc.m48192a(this, null);
        AppMethodBeat.m2505o(42201);
    }

    public void onPause() {
        AppMethodBeat.m2504i(42202);
        super.onPause();
        if (this.bCW != null) {
            this.bCW.unregisterListener(this.nVv);
        }
        AppMethodBeat.m2505o(42202);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(42203);
        C7060h.pYm.mo8381e(14007, Integer.valueOf(this.gCr[0]), Integer.valueOf(this.gCr[1]), Integer.valueOf(this.gCr[2]), Integer.valueOf(this.gCr[3]), Integer.valueOf(this.gCr[4]), Integer.valueOf(this.gCr[5]));
        C3369a c3369a = this.nUY;
        c3369a.jxQ = true;
        c3369a.nTR.release();
        getWindow().clearFlags(128);
        super.onDestroy();
        AppMethodBeat.m2505o(42203);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return 2130969980;
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, C1207m c1207m) {
        int i3 = 0;
        AppMethodBeat.m2504i(42204);
        C4990ab.m7417i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C21196e) {
                C4990ab.m7410d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.nSX);
                if (!(C5046bo.m7510Q(this.nSX, ((C21196e) c1207m).nSX) || this.nSX.equals(((C21196e) c1207m).nSX))) {
                    this.nUN.clear();
                    this.nUO.clear();
                    this.nUP.clear();
                    this.nUQ.notifyDataSetChanged();
                    this.nVa = "";
                }
                if (!C5046bo.isNullOrNil(((C21196e) c1207m).nSX)) {
                    this.nSX = ((C21196e) c1207m).nSX;
                }
                this.lvz = ((C21196e) c1207m).lvz;
                this.nUt = ((C21196e) c1207m).nUt;
                this.nUs = ((C21196e) c1207m).nUs;
                bLh();
                bLk();
                if (this.nUt == 0) {
                    this.gGo.stopTimer();
                }
                if (this.nUN.size() == 0 && !C5046bo.isNullOrNil(this.nSX)) {
                    mo24301b(new C12425af(this.nSX, 5, 0, null, "v1.0"), false);
                }
            } else if (c1207m instanceof C43253a) {
                this.nSX = "";
                this.lvz = "";
                this.nUt = 0;
                this.nUN.clear();
                this.nVa = "";
                this.nUQ.notifyDataSetChanged();
                bLh();
                bLk();
                this.gGo.stopTimer();
                if (!C5046bo.isNullOrNil(this.nUs)) {
                    C30379h.m48465bQ(this, this.nUs);
                }
            } else if (c1207m instanceof C12425af) {
                this.nUZ = ((C12425af) c1207m).nYn.nWU;
                LinkedList linkedList = ((C12425af) c1207m).nYn.nXj;
                if (linkedList != null && linkedList.size() > 0) {
                    while (i3 < linkedList.size()) {
                        C39323w c39323w = (C39323w) linkedList.get(i3);
                        if (!(C5046bo.isNullOrNil(c39323w.nWX) || this.nUN.contains(c39323w.nWX))) {
                            this.nUN.add(c39323w.nWX);
                            String str2 = c39323w.userName;
                            if (!C5046bo.isNullOrNil(c39323w.nYc)) {
                                this.nVa = str2;
                            }
                            this.nUO.put(c39323w.nWX, str2);
                        }
                        i3++;
                    }
                    bLj();
                    this.nUQ.notifyDataSetChanged();
                }
            } else if (c1207m instanceof C39311b) {
                C4990ab.m7416i("LuckyMoneyF2FQRCodeUI", "onSceneEnd NetSceneF2FLuckyMoneyInvalid");
                this.retCode = ((C39311b) c1207m).kCl;
                this.hwA = ((C39311b) c1207m).kCm;
                C4990ab.m7417i("LuckyMoneyF2FQRCodeUI", "retcode:%d", Integer.valueOf(i), Integer.valueOf(i2), str);
            }
        } else if (!C5046bo.isNullOrNil(str)) {
            C30379h.m48461b((Context) this, str, getString(C25738R.string.f9238tz), true);
        }
        AppMethodBeat.m2505o(42204);
        return true;
    }

    public final void aNW() {
        AppMethodBeat.m2504i(42205);
        C4990ab.m7416i("LuckyMoneyF2FQRCodeUI", "screenShot");
        if (this.nUt > 0) {
            String str = this.lvz;
            C4990ab.m7416i("LuckyMoneyF2FQRCodeUI", "invalidQRCode");
            mo24301b(new C39311b(str), false);
            C4990ab.m7416i("LuckyMoneyF2FQRCodeUI", "getQRCode");
            mo24301b(new C21196e(), false);
            bLh();
            int[] iArr = this.gCr;
            iArr[1] = iArr[1] + 1;
            C30379h.m48461b((Context) this, getString(C25738R.string.cqy), null, true);
        }
        AppMethodBeat.m2505o(42205);
    }

    /* renamed from: h */
    static /* synthetic */ void m45084h(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        AppMethodBeat.m2504i(42206);
        luckyMoneyF2FQRCodeUI.mo24301b(new C43253a(luckyMoneyF2FQRCodeUI.nSX), false);
        AppMethodBeat.m2505o(42206);
    }

    /* renamed from: a */
    static /* synthetic */ Bitmap m45065a(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI, int i, int i2) {
        AppMethodBeat.m2504i(42207);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(luckyMoneyF2FQRCodeUI.getResources(), i), i2, i2, false);
        AppMethodBeat.m2505o(42207);
        return createScaledBitmap;
    }

    /* renamed from: G */
    static /* synthetic */ void m45053G(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        AppMethodBeat.m2504i(42208);
        luckyMoneyF2FQRCodeUI.nUG = (ImageView) luckyMoneyF2FQRCodeUI.nUF.findViewById(2131825516);
        luckyMoneyF2FQRCodeUI.nUH = (TextView) luckyMoneyF2FQRCodeUI.nUF.findViewById(2131825517);
        luckyMoneyF2FQRCodeUI.nUI = (TextView) luckyMoneyF2FQRCodeUI.nUF.findViewById(2131825518);
        Pair pair = (Pair) luckyMoneyF2FQRCodeUI.nUP.poll();
        if (pair != null) {
            C46063x.m85811b(luckyMoneyF2FQRCodeUI.nUG, null, (String) pair.first);
            C46063x.m85800a((Context) luckyMoneyF2FQRCodeUI, luckyMoneyF2FQRCodeUI.nUH, C46063x.m85824mI((String) pair.first));
            luckyMoneyF2FQRCodeUI.nUI.setText(C36391e.m59971F(((double) ((Integer) pair.second).intValue()) / 100.0d));
            if (!C5046bo.isNullOrNil(luckyMoneyF2FQRCodeUI.nVa) && luckyMoneyF2FQRCodeUI.nVa.equals(pair.first)) {
                C39324a.m67000a(luckyMoneyF2FQRCodeUI.nUV, luckyMoneyF2FQRCodeUI.nVt).mo62213P(800, 100);
                C39324a.m67000a(luckyMoneyF2FQRCodeUI.nUW, luckyMoneyF2FQRCodeUI.nVu).mo62213P(800, 100);
                luckyMoneyF2FQRCodeUI.nUY.mo7780jU("most_lucky.m4a");
                if (((Integer) pair.second).intValue() >= 19000) {
                    luckyMoneyF2FQRCodeUI.nUY.mo7780jU("whistle.m4a");
                }
            }
        }
        AppMethodBeat.m2505o(42208);
    }
}
