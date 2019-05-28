package com.tencent.p177mm.p612ui.chatting.gallery;

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
import android.widget.FrameLayout.LayoutParams;
import android.widget.Gallery;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C41968au;
import com.tencent.p177mm.p230g.p232b.p233a.C32673k;
import com.tencent.p177mm.p230g.p711c.C9529eb;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30745f;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30748b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.scanner.C43488e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;

@C5271a(35)
/* renamed from: com.tencent.mm.ui.chatting.gallery.TranslationResultUI */
public class TranslationResultUI extends MMActivity {
    private String cvZ;
    private long cvx;
    /* renamed from: eX */
    private float f15087eX;
    /* renamed from: eY */
    private float f15088eY;
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
    private C9529eb yYc;
    private C36171a yYd;
    private View yYe;
    private int yYf;
    private int yYg;
    private ValueAnimator yYh;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.TranslationResultUI$2 */
    class C156512 implements Runnable {

        /* renamed from: com.tencent.mm.ui.chatting.gallery.TranslationResultUI$2$1 */
        class C156521 implements Runnable {
            C156521() {
            }

            public final void run() {
                AppMethodBeat.m2504i(138645);
                TranslationResultUI.this.yYd.bitmap = TranslationResultUI.this.qfU;
                TranslationResultUI.this.yYd.notifyDataSetChanged();
                AppMethodBeat.m2505o(138645);
            }
        }

        C156512() {
        }

        public final void run() {
            AppMethodBeat.m2504i(138646);
            TranslationResultUI.this.qfU = C5056d.decodeFile(TranslationResultUI.this.yYc.field_resultFile, null);
            if (TranslationResultUI.this.qfU != null) {
                C5004al.m7441d(new C156521());
            }
            AppMethodBeat.m2505o(138646);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.TranslationResultUI$1 */
    class C237761 implements C30745f {
        C237761() {
        }

        public final void bcX() {
            AppMethodBeat.m2504i(138644);
            TranslationResultUI.m59533a(TranslationResultUI.this);
            AppMethodBeat.m2505o(138644);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.TranslationResultUI$4 */
    class C361684 implements C30748b {
        C361684() {
        }

        /* renamed from: aa */
        public final void mo26118aa(float f, float f2) {
            float f3 = 1.0f;
            AppMethodBeat.m2504i(138648);
            float height = 1.0f - (f2 / ((float) TranslationResultUI.this.qfY.getHeight()));
            if (height <= 1.0f) {
                f3 = height;
            }
            C4990ab.m7411d("MicroMsg.TranslationResultUI", "onGalleryScale tx: %f, ty: %f, scale: %f", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
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
                AppMethodBeat.m2505o(138648);
                return;
            }
            C4990ab.m7410d("MicroMsg.TranslationResultUI", "runDragAnimation contentView is null !!");
            AppMethodBeat.m2505o(138648);
        }

        /* renamed from: ab */
        public final void mo26119ab(float f, float f2) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.TranslationResultUI$5 */
    class C361695 implements AnimatorUpdateListener {
        C361695() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(138649);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            LayoutParams layoutParams = (LayoutParams) TranslationResultUI.this.qfY.getLayoutParams();
            layoutParams.leftMargin = (int) (((float) TranslationResultUI.this.yYf) * floatValue);
            layoutParams.topMargin = (int) (((float) TranslationResultUI.this.yYg) * floatValue);
            layoutParams.rightMargin = (int) (((((float) TranslationResultUI.this.jWH.getWidth()) * floatValue) - (((float) TranslationResultUI.this.fgJ) * floatValue)) - ((float) layoutParams.leftMargin));
            layoutParams.bottomMargin = (int) (((((float) TranslationResultUI.this.jWH.getHeight()) * floatValue) - (((float) TranslationResultUI.this.fgI) * floatValue)) - ((float) layoutParams.topMargin));
            TranslationResultUI.this.qfY.setLayoutParams(layoutParams);
            TranslationResultUI.this.mSF.setTranslationX(TranslationResultUI.this.f15087eX * (1.0f - floatValue));
            TranslationResultUI.this.mSF.setTranslationY(TranslationResultUI.this.f15088eY * (1.0f - floatValue));
            TranslationResultUI.this.mSF.setScaleX(((1.0f - floatValue) * TranslationResultUI.this.scaleX) + floatValue);
            TranslationResultUI.this.mSF.setScaleY(((1.0f - floatValue) * TranslationResultUI.this.scaleY) + floatValue);
            TranslationResultUI.this.mmX.setAlpha(1.0f - floatValue);
            AppMethodBeat.m2505o(138649);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.TranslationResultUI$6 */
    class C361706 extends AnimatorListenerAdapter {
        C361706() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(138650);
            super.onAnimationStart(animator);
            if (TranslationResultUI.this.mSF.getScale() > 1.0f) {
                TranslationResultUI.this.mSF.dzA();
            }
            TranslationResultUI.this.f15087eX = TranslationResultUI.this.mSF.getTranslationX();
            TranslationResultUI.this.f15088eY = TranslationResultUI.this.mSF.getTranslationY();
            TranslationResultUI.this.scaleX = TranslationResultUI.this.mSF.getScaleX();
            TranslationResultUI.this.scaleY = TranslationResultUI.this.mSF.getScaleY();
            AppMethodBeat.m2505o(138650);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(138651);
            super.onAnimationEnd(animator);
            TranslationResultUI.this.finish();
            TranslationResultUI.this.overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
            AppMethodBeat.m2505o(138651);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.TranslationResultUI$a */
    class C36171a extends BaseAdapter {
        Bitmap bitmap;

        private C36171a() {
        }

        /* synthetic */ C36171a(TranslationResultUI translationResultUI, byte b) {
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
            AppMethodBeat.m2504i(138652);
            if (TranslationResultUI.this.mSF == null) {
                TranslationResultUI.this.mSF = new MultiTouchImageView(TranslationResultUI.this, 0, 0);
                TranslationResultUI.this.mSF.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                TranslationResultUI.this.mSF.dzA();
            }
            if (this.bitmap != null) {
                TranslationResultUI.this.mSF.setImageBitmap(this.bitmap);
                TranslationResultUI.this.mSF.mo71980bW(this.bitmap.getWidth(), this.bitmap.getHeight());
            }
            MultiTouchImageView f = TranslationResultUI.this.mSF;
            AppMethodBeat.m2505o(138652);
            return f;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.TranslationResultUI$3 */
    class C361723 implements OnClickListener {
        C361723() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138647);
            C32673k c32673k = new C32673k();
            c32673k.cVS = 7;
            c32673k.ajK();
            TranslationResultUI.m59534a(TranslationResultUI.this, TranslationResultUI.this.yYc.field_resultFile);
            AppMethodBeat.m2505o(138647);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(138653);
        requestWindowFeature(1);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(138653);
    }

    public final void initView() {
        AppMethodBeat.m2504i(138654);
        this.jWH = findViewById(2131823601);
        this.yYe = ((ViewStub) findViewById(2131825010)).inflate();
        this.mmX = (ImageView) findViewById(2131822079);
        this.yYb = getIntent().getStringExtra("original_file_path");
        this.cvx = getIntent().getLongExtra("msg_id", -1);
        C4990ab.m7417i("MicroMsg.TranslationResultUI", "file path %s", this.yYb);
        if (C5730e.m8628ct(this.yYb)) {
            this.cvZ = C4995ag.m7428ck(this.yYb + C5730e.ata(this.yYb));
            C4990ab.m7417i("MicroMsg.TranslationResultUI", "md5 %s", this.cvZ);
        } else {
            C4990ab.m7412e("MicroMsg.TranslationResultUI", "translation original file not exist!");
        }
        View findViewById = findViewById(2131825009);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        layoutParams.bottomMargin += C5222ae.m7944fr(this);
        findViewById.setLayoutParams(layoutParams);
        getSupportActionBar().hide();
        this.mController.mo11216l(this, getResources().getColor(C25738R.color.a3p));
        this.mController.mo11170Nb(getResources().getColor(C25738R.color.a3p));
        this.qfY = (MMGestureGallery) findViewById(2131825008);
        this.yYd = new C36171a(this, (byte) 0);
        this.qfY.setAdapter(this.yYd);
        this.qfY.setSingleClickOverListener(new C237761());
        this.yYc = C43488e.cgy().cgD().mo25148Wf(this.cvZ);
        if (this.yYc != null) {
            if (this.qfU == null) {
                C7305d.m12299g(new C156512(), "decode_translate_result_img");
            } else {
                this.yYd.bitmap = this.qfU;
                this.yYd.notifyDataSetChanged();
            }
            this.yYe.findViewById(2131824965).setOnClickListener(new C361723());
            this.yYe.setVisibility(0);
            dGT();
            dGU();
            AppMethodBeat.m2505o(138654);
            return;
        }
        C4990ab.m7412e("MicroMsg.TranslationResultUI", "translation result not found!");
        dGV();
        AppMethodBeat.m2505o(138654);
    }

    public void onResume() {
        AppMethodBeat.m2504i(138655);
        super.onResume();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setBackgroundDrawable(null);
        View decorView = getWindow().getDecorView();
        int i = 1796;
        if (VERSION.SDK_INT >= 19) {
            i = 5892;
        }
        decorView.setSystemUiVisibility(i);
        AppMethodBeat.m2505o(138655);
    }

    private void dGT() {
        AppMethodBeat.m2504i(138656);
        this.qfY.setGalleryScaleListener(new C361684());
        AppMethodBeat.m2505o(138656);
    }

    private void dGU() {
        AppMethodBeat.m2504i(138657);
        this.yYh = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.yYh.setDuration(200).setInterpolator(new DecelerateInterpolator(1.2f));
        this.yYh.addUpdateListener(new C361695());
        this.yYh.addListener(new C361706());
        AppMethodBeat.m2505o(138657);
    }

    public boolean convertActivityFromTranslucent() {
        return false;
    }

    private void dGV() {
        AppMethodBeat.m2504i(138658);
        if (this.qrd) {
            AppMethodBeat.m2505o(138658);
            return;
        }
        this.qrd = true;
        C4990ab.m7416i("MicroMsg.TranslationResultUI", "runExitAnimation");
        this.fgJ = 0;
        this.fgI = 0;
        this.yYf = this.qfY.getWidth() / 2;
        this.yYg = this.qfY.getHeight() / 2;
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.cvx);
        C41968au c41968au = new C41968au();
        c41968au.ctR.csG = jf;
        C4879a.xxA.mo10055m(c41968au);
        this.fgJ = c41968au.ctS.ctV;
        this.fgI = c41968au.ctS.ctW;
        this.yYf = c41968au.ctS.ctT;
        this.yYg = c41968au.ctS.ctU;
        if (this.yYf == 0 && this.yYg == 0) {
            this.yYf = this.qfY.getWidth() / 2;
            this.yYg = this.qfY.getHeight() / 2;
        }
        C4990ab.m7417i("MicroMsg.TranslationResultUI", "thumbLeft %d, thumbTop %d, thumbWidth %d, thumbHeight %d", Integer.valueOf(this.yYf), Integer.valueOf(this.yYg), Integer.valueOf(this.fgJ), Integer.valueOf(this.fgI));
        this.yYh.start();
        AppMethodBeat.m2505o(138658);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(138659);
        if (i == 4) {
            dGV();
            AppMethodBeat.m2505o(138659);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(138659);
        return onKeyDown;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(138660);
        super.onDestroy();
        this.qfU = null;
        AppMethodBeat.m2505o(138660);
    }

    public final int getLayoutId() {
        return 2130969863;
    }

    /* renamed from: a */
    static /* synthetic */ void m59533a(TranslationResultUI translationResultUI) {
        AppMethodBeat.m2504i(138661);
        translationResultUI.dGV();
        AppMethodBeat.m2505o(138661);
    }
}
