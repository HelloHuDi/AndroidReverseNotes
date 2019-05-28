package com.tencent.mm.plugin.music.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class b extends d implements com.tencent.mm.plugin.music.model.c.a {
    int count;
    boolean oMH;
    ak oMs = new ak(Looper.getMainLooper());
    final int oOs = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 26);
    final int oOt = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW);
    HashMap<Integer, View> oOu = new HashMap();
    c oOv = new c();
    int oOw;
    int scene;

    public class a {
        private int mode = 1;
        com.tencent.mm.plugin.music.model.e.a oMw;
        View oOA;
        View oOB;
        View oOC;
        CdnImageView oOD;
        TextView oOE;
        TextView oOF;
        LyricView oOG;
        boolean oOH;
        private AnimationListener oOI = new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                a.this.oOH = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        };
        MusicItemLayout oOz;

        /* renamed from: com.tencent.mm.plugin.music.ui.b$a$1 */
        class AnonymousClass1 extends ShaderFactory {
            final /* synthetic */ int oOJ;

            AnonymousClass1(int i) {
                this.oOJ = i;
            }

            public final Shader resize(int i, int i2) {
                AppMethodBeat.i(105073);
                float f = 0.0f;
                float f2 = 0.0f;
                LinearGradient linearGradient = new LinearGradient(0.0f, f, f2, (float) i2, new int[]{0, this.oOJ}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
                AppMethodBeat.o(105073);
                return linearGradient;
            }
        }

        /* renamed from: com.tencent.mm.plugin.music.ui.b$a$2 */
        class AnonymousClass2 extends ShaderFactory {
            final /* synthetic */ int oOL;

            AnonymousClass2(int i) {
                this.oOL = i;
            }

            public final Shader resize(int i, int i2) {
                AppMethodBeat.i(105074);
                float f = 0.0f;
                float f2 = 0.0f;
                LinearGradient linearGradient = new LinearGradient(0.0f, f, f2, (float) i2, new int[]{this.oOL, 0}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
                AppMethodBeat.o(105074);
                return linearGradient;
            }
        }

        public class a extends Animation {
            final int eTj;
            final int oOM;
            View view;

            public a(View view, int i) {
                AppMethodBeat.i(105075);
                this.view = view;
                this.eTj = i;
                this.oOM = view.getHeight();
                AppMethodBeat.o(105075);
            }

            /* Access modifiers changed, original: protected|final */
            public final void applyTransformation(float f, Transformation transformation) {
                AppMethodBeat.i(105076);
                this.view.getLayoutParams().height = (int) (((float) this.oOM) + (((float) (this.eTj - this.oOM)) * f));
                this.view.requestLayout();
                AppMethodBeat.o(105076);
            }

            public final void initialize(int i, int i2, int i3, int i4) {
                AppMethodBeat.i(105077);
                super.initialize(i, i2, i3, i4);
                AppMethodBeat.o(105077);
            }

            public final boolean willChangeBounds() {
                return true;
            }
        }

        public a() {
            AppMethodBeat.i(105078);
            AppMethodBeat.o(105078);
        }

        public final void d(com.tencent.mm.plugin.music.model.e.a aVar, boolean z) {
            AppMethodBeat.i(105079);
            if (aVar != null) {
                ab.i("MicroMsg.Music.MusicMainAdapter", "updateView %s", aVar.field_songName);
                this.oMw = aVar;
                if (bo.isNullOrNil(aVar.field_songHAlbumUrl)) {
                    ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).a(aVar, b.this.oMH);
                }
                this.oOz.setTag(this);
                if ((!com.tencent.mm.plugin.music.model.d.a(aVar) || b.this.scene == 3) && !bo.isNullOrNil(aVar.field_songSinger)) {
                    this.oOF.setText(aVar.field_songSinger);
                    this.oOF.setVisibility(0);
                } else {
                    this.oOF.setVisibility(8);
                }
                this.oOE.setText(aVar.field_songName);
                this.oOE.setTag(aVar.field_songName);
                this.oOG.setLyricObj(com.tencent.mm.plugin.music.model.e.bUk().b(aVar, b.this.oMH));
                if (!com.tencent.mm.plugin.music.model.d.a(aVar) || b.this.oMH) {
                    this.oOG.setCurrentTime(1);
                }
                bUN();
                b.this.oOv.a(aVar, this.oOD, b.this.context, z, b.this.oMH);
            }
            AppMethodBeat.o(105079);
        }

        public final boolean bUM() {
            return this.mode == 2;
        }

        public final void bUN() {
            AppMethodBeat.i(105080);
            if (this.oOH || this.mode == 1) {
                AppMethodBeat.o(105080);
                return;
            }
            com.tencent.mm.plugin.music.model.d.d.eJ(3, b.this.scene);
            if (b.this.oOw == 0) {
                b.this.oOw = this.oOA.getMeasuredHeight();
                LayoutParams layoutParams = new LayoutParams(-1, b.this.oOw);
                layoutParams.weight = 0.0f;
                this.oOA.setLayoutParams(layoutParams);
            }
            com.tencent.mm.plugin.music.model.d.d.oNj = true;
            com.tencent.mm.plugin.music.model.d.d.bUt();
            this.mode = 1;
            this.oOH = true;
            a aVar = new a(this.oOG, b.this.oOs);
            aVar.setDuration(500);
            aVar.setAnimationListener(this.oOI);
            this.oOG.startAnimation(aVar);
            AppMethodBeat.o(105080);
        }

        public final void bUO() {
            AppMethodBeat.i(105081);
            if (this.oOH || this.mode == 2) {
                AppMethodBeat.o(105081);
                return;
            }
            com.tencent.mm.plugin.music.model.d.d.eJ(2, b.this.scene);
            if (b.this.oOw == 0) {
                b.this.oOw = this.oOA.getMeasuredHeight();
                LayoutParams layoutParams = new LayoutParams(-1, b.this.oOw);
                layoutParams.weight = 0.0f;
                this.oOA.setLayoutParams(layoutParams);
            }
            com.tencent.mm.plugin.music.model.d.d.oNj = true;
            com.tencent.mm.plugin.music.model.d.d.bUt();
            this.mode = 2;
            this.oOH = true;
            a aVar = new a(this.oOG, b.this.oOt);
            aVar.setDuration(500);
            aVar.setAnimationListener(this.oOI);
            this.oOG.startAnimation(aVar);
            AppMethodBeat.o(105081);
        }

        public final void bUP() {
            AppMethodBeat.i(105082);
            com.tencent.mm.plugin.music.model.d.d.oNj = true;
            com.tencent.mm.plugin.music.model.d.d.bUt();
            if (this.mode == 1) {
                bUO();
                AppMethodBeat.o(105082);
                return;
            }
            bUN();
            AppMethodBeat.o(105082);
        }
    }

    public b(Context context, int i, boolean z) {
        super(context);
        AppMethodBeat.i(105083);
        this.scene = i;
        this.oMH = z;
        AppMethodBeat.o(105083);
    }

    public final int getCount() {
        return this.count;
    }

    public final View a(View view, ViewGroup viewGroup, int i) {
        Object view2;
        a aVar;
        AppMethodBeat.i(105084);
        if (view2 == null) {
            view2 = LayoutInflater.from(this.context).inflate(R.layout.ai2, viewGroup, false);
            aVar = new a();
            aVar.oOz = (MusicItemLayout) view2.findViewById(R.id.dfe);
            aVar.oOE = (TextView) view2.findViewById(R.id.dfj);
            aVar.oOG = (LyricView) view2.findViewById(R.id.dfl);
            aVar.oOA = view2.findViewById(R.id.dff);
            aVar.oOB = view2.findViewById(R.id.dfh);
            aVar.oOC = view2.findViewById(R.id.dfi);
            aVar.oOD = (CdnImageView) view2.findViewById(R.id.dfg);
            aVar.oOF = (TextView) view2.findViewById(R.id.dfk);
            view2.setTag(aVar);
        } else {
            aVar = (a) view2.getTag();
        }
        List bTW = ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTW();
        int size = (i - 100000) % bTW.size();
        if (size < 0) {
            size += bTW.size();
        }
        ab.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", Integer.valueOf(size));
        com.tencent.mm.plugin.music.model.e.a Tp = com.tencent.mm.plugin.music.model.e.bUk().Tp((String) bTW.get(size));
        this.oOu.put(Integer.valueOf(i), view2);
        aVar.d(Tp, false);
        AppMethodBeat.o(105084);
        return view2;
    }

    public final void zU(int i) {
        AppMethodBeat.i(105085);
        this.oOu.remove(Integer.valueOf(i));
        AppMethodBeat.o(105085);
    }

    public final int bUL() {
        AppMethodBeat.i(105086);
        int size = ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTW().size();
        AppMethodBeat.o(105086);
        return size;
    }

    public final void T(final int i, final long j) {
        AppMethodBeat.i(105087);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(105072);
                View view = (View) b.this.oOu.get(Integer.valueOf(i));
                if (view != null) {
                    ((a) view.getTag()).oOG.setCurrentTime(j);
                }
                AppMethodBeat.o(105072);
            }
        });
        AppMethodBeat.o(105087);
    }

    public final void a(com.tencent.mm.plugin.music.model.e.a aVar, int[] iArr) {
        AppMethodBeat.i(105088);
        for (Entry value : this.oOu.entrySet()) {
            a aVar2 = (a) ((View) value.getValue()).getTag();
            if (aVar2.oMw.field_musicId.equals(aVar.field_musicId)) {
                ab.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", aVar2.oMw.field_songName);
                int i = iArr[0];
                int i2 = iArr[1];
                aVar2.oOz.setBackgroundColor(i);
                aVar2.oOG.setLyricColor(i2);
                aVar2.oOD.setBackgroundColor(i);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(i);
                PaintDrawable paintDrawable = new PaintDrawable();
                paintDrawable.setShape(new RectShape());
                paintDrawable.setShaderFactory(anonymousClass1);
                aVar2.oOB.setBackgroundDrawable(paintDrawable);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2((i & 16777215) | 1426063360);
                PaintDrawable paintDrawable2 = new PaintDrawable();
                paintDrawable2.setShape(new RectShape());
                paintDrawable2.setShaderFactory(anonymousClass2);
                aVar2.oOC.setBackgroundDrawable(paintDrawable2);
                aVar2.oOE.setTextColor(i2);
                aVar2.oOF.setTextColor(i2);
                ((MusicMainUI) this.context).i(aVar);
            }
        }
        AppMethodBeat.o(105088);
    }
}
