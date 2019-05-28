package com.tencent.mm.ui.chatting.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.b.a.k;
import com.tencent.mm.g.c.eb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.vfs.e;

@com.tencent.mm.ui.base.a(35)
public class TranslationResultUI extends MMActivity {
    private String cvZ;
    private long cvx;
    private float eX;
    private float eY;
    private int fgI;
    private int fgJ;
    private View jWH;
    private MultiTouchImageView mSF;
    private ImageView mmX;
    private Bitmap qfU;
    private MMGestureGallery qfY;
    private boolean qrd;
    private float scaleX;
    private float scaleY;
    private String yYb;
    private eb yYc;
    private a yYd;
    private View yYe;
    private int yYf;
    private int yYg;
    private ValueAnimator yYh;

    class a extends BaseAdapter {
        Bitmap bitmap;

        private a() {
        }

        /* synthetic */ a(TranslationResultUI translationResultUI, byte b) {
            this();
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(138652);
            if (TranslationResultUI.this.mSF == null) {
                TranslationResultUI.this.mSF = new MultiTouchImageView(TranslationResultUI.this, 0, 0);
                TranslationResultUI.this.mSF.setLayoutParams(new LayoutParams(-1, -1));
                TranslationResultUI.this.mSF.dzA();
            }
            if (this.bitmap != null) {
                TranslationResultUI.this.mSF.setImageBitmap(this.bitmap);
                TranslationResultUI.this.mSF.bW(this.bitmap.getWidth(), this.bitmap.getHeight());
            }
            MultiTouchImageView f = TranslationResultUI.this.mSF;
            AppMethodBeat.o(138652);
            return f;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(138653);
        requestWindowFeature(1);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(138653);
    }

    public final void initView() {
        AppMethodBeat.i(138654);
        this.jWH = findViewById(R.id.bhm);
        this.yYe = ((ViewStub) findViewById(R.id.cip)).inflate();
        this.mmX = (ImageView) findViewById(R.id.adg);
        this.yYb = getIntent().getStringExtra("original_file_path");
        this.cvx = getIntent().getLongExtra("msg_id", -1);
        ab.i("MicroMsg.TranslationResultUI", "file path %s", this.yYb);
        if (e.ct(this.yYb)) {
            this.cvZ = ag.ck(this.yYb + e.ata(this.yYb));
            ab.i("MicroMsg.TranslationResultUI", "md5 %s", this.cvZ);
        } else {
            ab.e("MicroMsg.TranslationResultUI", "translation original file not exist!");
        }
        View findViewById = findViewById(R.id.cio);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.bottomMargin += ae.fr(this);
        findViewById.setLayoutParams(layoutParams);
        getSupportActionBar().hide();
        this.mController.l(this, getResources().getColor(R.color.a3p));
        this.mController.Nb(getResources().getColor(R.color.a3p));
        this.qfY = (MMGestureGallery) findViewById(R.id.cin);
        this.yYd = new a(this, (byte) 0);
        this.qfY.setAdapter(this.yYd);
        this.qfY.setSingleClickOverListener(new f() {
            public final void bcX() {
                AppMethodBeat.i(138644);
                TranslationResultUI.a(TranslationResultUI.this);
                AppMethodBeat.o(138644);
            }
        });
        this.yYc = com.tencent.mm.plugin.scanner.e.cgy().cgD().Wf(this.cvZ);
        if (this.yYc != null) {
            if (this.qfU == null) {
                d.g(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(138646);
                        TranslationResultUI.this.qfU = com.tencent.mm.sdk.platformtools.d.decodeFile(TranslationResultUI.this.yYc.field_resultFile, null);
                        if (TranslationResultUI.this.qfU != null) {
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(138645);
                                    TranslationResultUI.this.yYd.bitmap = TranslationResultUI.this.qfU;
                                    TranslationResultUI.this.yYd.notifyDataSetChanged();
                                    AppMethodBeat.o(138645);
                                }
                            });
                        }
                        AppMethodBeat.o(138646);
                    }
                }, "decode_translate_result_img");
            } else {
                this.yYd.bitmap = this.qfU;
                this.yYd.notifyDataSetChanged();
            }
            this.yYe.findViewById(R.id.chh).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(138647);
                    k kVar = new k();
                    kVar.cVS = 7;
                    kVar.ajK();
                    TranslationResultUI.a(TranslationResultUI.this, TranslationResultUI.this.yYc.field_resultFile);
                    AppMethodBeat.o(138647);
                }
            });
            this.yYe.setVisibility(0);
            dGT();
            dGU();
            AppMethodBeat.o(138654);
            return;
        }
        ab.e("MicroMsg.TranslationResultUI", "translation result not found!");
        dGV();
        AppMethodBeat.o(138654);
    }

    public void onResume() {
        AppMethodBeat.i(138655);
        super.onResume();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setBackgroundDrawable(null);
        View decorView = getWindow().getDecorView();
        int i = 1796;
        if (VERSION.SDK_INT >= 19) {
            i = 5892;
        }
        decorView.setSystemUiVisibility(i);
        AppMethodBeat.o(138655);
    }

    private void dGT() {
        AppMethodBeat.i(138656);
        this.qfY.setGalleryScaleListener(new b() {
            public final void aa(float f, float f2) {
                float f3 = 1.0f;
                AppMethodBeat.i(138648);
                float height = 1.0f - (f2 / ((float) TranslationResultUI.this.qfY.getHeight()));
                if (height <= 1.0f) {
                    f3 = height;
                }
                ab.d("MicroMsg.TranslationResultUI", "onGalleryScale tx: %f, ty: %f, scale: %f", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
                if (TranslationResultUI.this.mSF != null) {
                    if (f == 0.0f && f2 == 0.0f) {
                        TranslationResultUI.this.yYe.setVisibility(0);
                    } else {
                        TranslationResultUI.this.yYe.setVisibility(8);
                    }
                    TranslationResultUI.this.mSF.setPivotX((float) (TranslationResultUI.this.qfY.getWidth() / 2));
                    TranslationResultUI.this.mSF.setPivotY((float) (TranslationResultUI.this.qfY.getHeight() / 2));
                    TranslationResultUI.this.mSF.setScaleX(f3);
                    TranslationResultUI.this.mSF.setScaleY(f3);
                    TranslationResultUI.this.mSF.setTranslationX(f);
                    TranslationResultUI.this.mSF.setTranslationY(f2);
                    TranslationResultUI.this.jWH.setAlpha(f3);
                    AppMethodBeat.o(138648);
                    return;
                }
                ab.d("MicroMsg.TranslationResultUI", "runDragAnimation contentView is null !!");
                AppMethodBeat.o(138648);
            }

            public final void ab(float f, float f2) {
            }
        });
        AppMethodBeat.o(138656);
    }

    private void dGU() {
        AppMethodBeat.i(138657);
        this.yYh = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.yYh.setDuration(200).setInterpolator(new DecelerateInterpolator(1.2f));
        this.yYh.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(138649);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) TranslationResultUI.this.qfY.getLayoutParams();
                layoutParams.leftMargin = (int) (((float) TranslationResultUI.this.yYf) * floatValue);
                layoutParams.topMargin = (int) (((float) TranslationResultUI.this.yYg) * floatValue);
                layoutParams.rightMargin = (int) (((((float) TranslationResultUI.this.jWH.getWidth()) * floatValue) - (((float) TranslationResultUI.this.fgJ) * floatValue)) - ((float) layoutParams.leftMargin));
                layoutParams.bottomMargin = (int) (((((float) TranslationResultUI.this.jWH.getHeight()) * floatValue) - (((float) TranslationResultUI.this.fgI) * floatValue)) - ((float) layoutParams.topMargin));
                TranslationResultUI.this.qfY.setLayoutParams(layoutParams);
                TranslationResultUI.this.mSF.setTranslationX(TranslationResultUI.this.eX * (1.0f - floatValue));
                TranslationResultUI.this.mSF.setTranslationY(TranslationResultUI.this.eY * (1.0f - floatValue));
                TranslationResultUI.this.mSF.setScaleX(((1.0f - floatValue) * TranslationResultUI.this.scaleX) + floatValue);
                TranslationResultUI.this.mSF.setScaleY(((1.0f - floatValue) * TranslationResultUI.this.scaleY) + floatValue);
                TranslationResultUI.this.mmX.setAlpha(1.0f - floatValue);
                AppMethodBeat.o(138649);
            }
        });
        this.yYh.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(138650);
                super.onAnimationStart(animator);
                if (TranslationResultUI.this.mSF.getScale() > 1.0f) {
                    TranslationResultUI.this.mSF.dzA();
                }
                TranslationResultUI.this.eX = TranslationResultUI.this.mSF.getTranslationX();
                TranslationResultUI.this.eY = TranslationResultUI.this.mSF.getTranslationY();
                TranslationResultUI.this.scaleX = TranslationResultUI.this.mSF.getScaleX();
                TranslationResultUI.this.scaleY = TranslationResultUI.this.mSF.getScaleY();
                AppMethodBeat.o(138650);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(138651);
                super.onAnimationEnd(animator);
                TranslationResultUI.this.finish();
                TranslationResultUI.this.overridePendingTransition(R.anim.s, R.anim.s);
                AppMethodBeat.o(138651);
            }
        });
        AppMethodBeat.o(138657);
    }

    public boolean convertActivityFromTranslucent() {
        return false;
    }

    private void dGV() {
        AppMethodBeat.i(138658);
        if (this.qrd) {
            AppMethodBeat.o(138658);
            return;
        }
        this.qrd = true;
        ab.i("MicroMsg.TranslationResultUI", "runExitAnimation");
        this.fgJ = 0;
        this.fgI = 0;
        this.yYf = this.qfY.getWidth() / 2;
        this.yYg = this.qfY.getHeight() / 2;
        bi jf = ((j) g.K(j.class)).bOr().jf(this.cvx);
        au auVar = new au();
        auVar.ctR.csG = jf;
        com.tencent.mm.sdk.b.a.xxA.m(auVar);
        this.fgJ = auVar.ctS.ctV;
        this.fgI = auVar.ctS.ctW;
        this.yYf = auVar.ctS.ctT;
        this.yYg = auVar.ctS.ctU;
        if (this.yYf == 0 && this.yYg == 0) {
            this.yYf = this.qfY.getWidth() / 2;
            this.yYg = this.qfY.getHeight() / 2;
        }
        ab.i("MicroMsg.TranslationResultUI", "thumbLeft %d, thumbTop %d, thumbWidth %d, thumbHeight %d", Integer.valueOf(this.yYf), Integer.valueOf(this.yYg), Integer.valueOf(this.fgJ), Integer.valueOf(this.fgI));
        this.yYh.start();
        AppMethodBeat.o(138658);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(138659);
        if (i == 4) {
            dGV();
            AppMethodBeat.o(138659);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(138659);
        return onKeyDown;
    }

    public void onDestroy() {
        AppMethodBeat.i(138660);
        super.onDestroy();
        this.qfU = null;
        AppMethodBeat.o(138660);
    }

    public final int getLayoutId() {
        return R.layout.a7z;
    }

    static /* synthetic */ void a(TranslationResultUI translationResultUI) {
        AppMethodBeat.i(138661);
        translationResultUI.dGV();
        AppMethodBeat.o(138661);
    }
}
