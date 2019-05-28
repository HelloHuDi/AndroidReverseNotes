package com.tencent.p177mm.plugin.music.p467ui;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C36071d;
import com.tencent.p177mm.plugin.music.model.C39444d;
import com.tencent.p177mm.plugin.music.model.C39445e;
import com.tencent.p177mm.plugin.music.model.C46105c;
import com.tencent.p177mm.plugin.music.model.C46105c.C12676a;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.plugin.music.model.p466d.C3541d;
import com.tencent.p177mm.plugin.music.p462e.C28559e;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.view.C31128d;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.music.ui.b */
public final class C39449b extends C36071d implements C12676a {
    int count;
    boolean oMH;
    C7306ak oMs = new C7306ak(Looper.getMainLooper());
    final int oOs = C1338a.fromDPToPix(C4996ah.getContext(), 26);
    final int oOt = C1338a.fromDPToPix(C4996ah.getContext(), C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW);
    HashMap<Integer, View> oOu = new HashMap();
    C46105c oOv = new C46105c();
    int oOw;
    int scene;

    /* renamed from: com.tencent.mm.plugin.music.ui.b$a */
    public class C39450a {
        private int mode = 1;
        C28575a oMw;
        View oOA;
        View oOB;
        View oOC;
        CdnImageView oOD;
        TextView oOE;
        TextView oOF;
        LyricView oOG;
        boolean oOH;
        private AnimationListener oOI = new C126903();
        MusicItemLayout oOz;

        /* renamed from: com.tencent.mm.plugin.music.ui.b$a$1 */
        class C126891 extends ShaderFactory {
            final /* synthetic */ int oOJ;

            C126891(int i) {
                this.oOJ = i;
            }

            public final Shader resize(int i, int i2) {
                AppMethodBeat.m2504i(105073);
                float f = 0.0f;
                float f2 = 0.0f;
                LinearGradient linearGradient = new LinearGradient(0.0f, f, f2, (float) i2, new int[]{0, this.oOJ}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
                AppMethodBeat.m2505o(105073);
                return linearGradient;
            }
        }

        /* renamed from: com.tencent.mm.plugin.music.ui.b$a$3 */
        class C126903 implements AnimationListener {
            C126903() {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                C39450a.this.oOH = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.music.ui.b$a$2 */
        class C285872 extends ShaderFactory {
            final /* synthetic */ int oOL;

            C285872(int i) {
                this.oOL = i;
            }

            public final Shader resize(int i, int i2) {
                AppMethodBeat.m2504i(105074);
                float f = 0.0f;
                float f2 = 0.0f;
                LinearGradient linearGradient = new LinearGradient(0.0f, f, f2, (float) i2, new int[]{this.oOL, 0}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
                AppMethodBeat.m2505o(105074);
                return linearGradient;
            }
        }

        /* renamed from: com.tencent.mm.plugin.music.ui.b$a$a */
        public class C39451a extends Animation {
            final int eTj;
            final int oOM;
            View view;

            public C39451a(View view, int i) {
                AppMethodBeat.m2504i(105075);
                this.view = view;
                this.eTj = i;
                this.oOM = view.getHeight();
                AppMethodBeat.m2505o(105075);
            }

            /* Access modifiers changed, original: protected|final */
            public final void applyTransformation(float f, Transformation transformation) {
                AppMethodBeat.m2504i(105076);
                this.view.getLayoutParams().height = (int) (((float) this.oOM) + (((float) (this.eTj - this.oOM)) * f));
                this.view.requestLayout();
                AppMethodBeat.m2505o(105076);
            }

            public final void initialize(int i, int i2, int i3, int i4) {
                AppMethodBeat.m2504i(105077);
                super.initialize(i, i2, i3, i4);
                AppMethodBeat.m2505o(105077);
            }

            public final boolean willChangeBounds() {
                return true;
            }
        }

        public C39450a() {
            AppMethodBeat.m2504i(105078);
            AppMethodBeat.m2505o(105078);
        }

        /* renamed from: d */
        public final void mo62399d(C28575a c28575a, boolean z) {
            AppMethodBeat.m2504i(105079);
            if (c28575a != null) {
                C4990ab.m7417i("MicroMsg.Music.MusicMainAdapter", "updateView %s", c28575a.field_songName);
                this.oMw = c28575a;
                if (C5046bo.isNullOrNil(c28575a.field_songHAlbumUrl)) {
                    ((C28559e) C43329b.m77295ar(C28559e.class)).mo46639a(c28575a, C39449b.this.oMH);
                }
                this.oOz.setTag(this);
                if ((!C39444d.m67386a(c28575a) || C39449b.this.scene == 3) && !C5046bo.isNullOrNil(c28575a.field_songSinger)) {
                    this.oOF.setText(c28575a.field_songSinger);
                    this.oOF.setVisibility(0);
                } else {
                    this.oOF.setVisibility(8);
                }
                this.oOE.setText(c28575a.field_songName);
                this.oOE.setTag(c28575a.field_songName);
                this.oOG.setLyricObj(C39445e.bUk().mo24655b(c28575a, C39449b.this.oMH));
                if (!C39444d.m67386a(c28575a) || C39449b.this.oMH) {
                    this.oOG.setCurrentTime(1);
                }
                bUN();
                C39449b.this.oOv.mo74024a(c28575a, this.oOD, C39449b.this.context, z, C39449b.this.oMH);
            }
            AppMethodBeat.m2505o(105079);
        }

        public final boolean bUM() {
            return this.mode == 2;
        }

        public final void bUN() {
            AppMethodBeat.m2504i(105080);
            if (this.oOH || this.mode == 1) {
                AppMethodBeat.m2505o(105080);
                return;
            }
            C3541d.m5831eJ(3, C39449b.this.scene);
            if (C39449b.this.oOw == 0) {
                C39449b.this.oOw = this.oOA.getMeasuredHeight();
                LayoutParams layoutParams = new LayoutParams(-1, C39449b.this.oOw);
                layoutParams.weight = 0.0f;
                this.oOA.setLayoutParams(layoutParams);
            }
            C3541d.oNj = true;
            C3541d.bUt();
            this.mode = 1;
            this.oOH = true;
            C39451a c39451a = new C39451a(this.oOG, C39449b.this.oOs);
            c39451a.setDuration(500);
            c39451a.setAnimationListener(this.oOI);
            this.oOG.startAnimation(c39451a);
            AppMethodBeat.m2505o(105080);
        }

        public final void bUO() {
            AppMethodBeat.m2504i(105081);
            if (this.oOH || this.mode == 2) {
                AppMethodBeat.m2505o(105081);
                return;
            }
            C3541d.m5831eJ(2, C39449b.this.scene);
            if (C39449b.this.oOw == 0) {
                C39449b.this.oOw = this.oOA.getMeasuredHeight();
                LayoutParams layoutParams = new LayoutParams(-1, C39449b.this.oOw);
                layoutParams.weight = 0.0f;
                this.oOA.setLayoutParams(layoutParams);
            }
            C3541d.oNj = true;
            C3541d.bUt();
            this.mode = 2;
            this.oOH = true;
            C39451a c39451a = new C39451a(this.oOG, C39449b.this.oOt);
            c39451a.setDuration(500);
            c39451a.setAnimationListener(this.oOI);
            this.oOG.startAnimation(c39451a);
            AppMethodBeat.m2505o(105081);
        }

        public final void bUP() {
            AppMethodBeat.m2504i(105082);
            C3541d.oNj = true;
            C3541d.bUt();
            if (this.mode == 1) {
                bUO();
                AppMethodBeat.m2505o(105082);
                return;
            }
            bUN();
            AppMethodBeat.m2505o(105082);
        }
    }

    public C39449b(Context context, int i, boolean z) {
        super(context);
        AppMethodBeat.m2504i(105083);
        this.scene = i;
        this.oMH = z;
        AppMethodBeat.m2505o(105083);
    }

    public final int getCount() {
        return this.count;
    }

    /* renamed from: a */
    public final View mo56916a(View view, ViewGroup viewGroup, int i) {
        Object view2;
        C39450a c39450a;
        AppMethodBeat.m2504i(105084);
        if (view2 == null) {
            view2 = LayoutInflater.from(this.context).inflate(2130970273, viewGroup, false);
            c39450a = new C39450a();
            c39450a.oOz = (MusicItemLayout) view2.findViewById(2131826256);
            c39450a.oOE = (TextView) view2.findViewById(2131826261);
            c39450a.oOG = (LyricView) view2.findViewById(2131826263);
            c39450a.oOA = view2.findViewById(2131826257);
            c39450a.oOB = view2.findViewById(2131826259);
            c39450a.oOC = view2.findViewById(2131826260);
            c39450a.oOD = (CdnImageView) view2.findViewById(2131826258);
            c39450a.oOF = (TextView) view2.findViewById(2131826262);
            view2.setTag(c39450a);
        } else {
            c39450a = (C39450a) view2.getTag();
        }
        List bTW = ((C28559e) C43329b.m77295ar(C28559e.class)).bTW();
        int size = (i - 100000) % bTW.size();
        if (size < 0) {
            size += bTW.size();
        }
        C4990ab.m7411d("MicroMsg.Music.MusicMainAdapter", "play music index %d", Integer.valueOf(size));
        C28575a Tp = C39445e.bUk().mo24653Tp((String) bTW.get(size));
        this.oOu.put(Integer.valueOf(i), view2);
        c39450a.mo62399d(Tp, false);
        AppMethodBeat.m2505o(105084);
        return view2;
    }

    /* renamed from: zU */
    public final void mo56918zU(int i) {
        AppMethodBeat.m2504i(105085);
        this.oOu.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(105085);
    }

    public final int bUL() {
        AppMethodBeat.m2504i(105086);
        int size = ((C28559e) C43329b.m77295ar(C28559e.class)).bTW().size();
        AppMethodBeat.m2505o(105086);
        return size;
    }

    /* renamed from: T */
    public final void mo62394T(final int i, final long j) {
        AppMethodBeat.m2504i(105087);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(105072);
                View view = (View) C39449b.this.oOu.get(Integer.valueOf(i));
                if (view != null) {
                    ((C39450a) view.getTag()).oOG.setCurrentTime(j);
                }
                AppMethodBeat.m2505o(105072);
            }
        });
        AppMethodBeat.m2505o(105087);
    }

    /* renamed from: a */
    public final void mo24643a(C28575a c28575a, int[] iArr) {
        AppMethodBeat.m2504i(105088);
        for (Entry value : this.oOu.entrySet()) {
            C39450a c39450a = (C39450a) ((View) value.getValue()).getTag();
            if (c39450a.oMw.field_musicId.equals(c28575a.field_musicId)) {
                C4990ab.m7417i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", c39450a.oMw.field_songName);
                int i = iArr[0];
                int i2 = iArr[1];
                c39450a.oOz.setBackgroundColor(i);
                c39450a.oOG.setLyricColor(i2);
                c39450a.oOD.setBackgroundColor(i);
                C126891 c126891 = new C126891(i);
                PaintDrawable paintDrawable = new PaintDrawable();
                paintDrawable.setShape(new RectShape());
                paintDrawable.setShaderFactory(c126891);
                c39450a.oOB.setBackgroundDrawable(paintDrawable);
                C285872 c285872 = new C285872((i & 16777215) | 1426063360);
                PaintDrawable paintDrawable2 = new PaintDrawable();
                paintDrawable2.setShape(new RectShape());
                paintDrawable2.setShaderFactory(c285872);
                c39450a.oOC.setBackgroundDrawable(paintDrawable2);
                c39450a.oOE.setTextColor(i2);
                c39450a.oOF.setTextColor(i2);
                ((MusicMainUI) this.context).mo46711i(c28575a);
            }
        }
        AppMethodBeat.m2505o(105088);
    }
}
