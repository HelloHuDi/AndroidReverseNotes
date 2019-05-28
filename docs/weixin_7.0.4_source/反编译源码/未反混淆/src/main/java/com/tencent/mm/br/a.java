package com.tencent.mm.br;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.e;
import com.tencent.mm.api.g;
import com.tencent.mm.api.k;
import com.tencent.mm.api.n;
import com.tencent.mm.api.r;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.a;
import com.tencent.mm.e.c;
import com.tencent.mm.e.c.AnonymousClass8;
import com.tencent.mm.e.f;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.view.footer.SelectColorBar;
import com.tencent.ttpic.util.ActUtil;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements b {
    com.tencent.mm.api.s.a ccP;
    com.tencent.mm.view.a vwM;
    HashMap<e, com.tencent.mm.e.b> vwN;
    LinkedList<com.tencent.mm.e.b> vwO;
    private g vwP;
    Bitmap vwQ;
    private boolean vwR = true;
    e vwS = e.DEFAULT;
    e vwT = e.DEFAULT;
    com.tencent.mm.e.b vwU = null;

    class a implements com.tencent.mm.ae.a {
        View vwY = a.this.vwM.getRubbishView();
        TextView vwZ = ((TextView) this.vwY.findViewById(R.id.e48));
        ImageView vxa = ((ImageView) this.vwY.findViewById(R.id.e47));

        a() {
            AppMethodBeat.i(116313);
            AppMethodBeat.o(116313);
        }

        public final void ae(float f) {
            AppMethodBeat.i(116314);
            ab.i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", Float.valueOf(f));
            this.vwZ.setText(a.this.vwM.getContext().getString(R.string.dvv));
            this.vxa.setImageResource(R.drawable.bgh);
            AppMethodBeat.o(116314);
        }

        public final void Ta() {
            AppMethodBeat.i(116315);
            ab.i("MicroMsg.DrawingPresenter", "[onUnReach]");
            this.vxa.setImageResource(R.drawable.yw);
            this.vwZ.setText(a.this.vwM.getContext().getString(R.string.dvw));
            AppMethodBeat.o(116315);
        }

        public final void onShow() {
            AppMethodBeat.i(116316);
            a.a(a.this, true);
            AppMethodBeat.o(116316);
        }

        public final void onHide() {
            AppMethodBeat.i(116317);
            a.a(a.this, false);
            AppMethodBeat.o(116317);
        }

        public final void a(com.tencent.mm.y.e eVar) {
            AppMethodBeat.i(116318);
            EditText editText = (EditText) a.this.vwM.getTextEditView().findViewById(R.id.bbt);
            editText.setText(eVar.eHF);
            Switch switchR = (Switch) a.this.vwM.findViewById(R.id.bbu);
            SelectColorBar selectColorBar = (SelectColorBar) a.this.vwM.findViewById(R.id.bbv);
            switchR.setChecked(eVar.eHE != 0);
            if (switchR.isChecked()) {
                selectColorBar.setSelectColor(eVar.eHE);
            } else {
                selectColorBar.setSelectColor(eVar.mColor);
            }
            editText.setTextColor(eVar.mColor);
            editText.setTag(eVar);
            a.this.oW(true);
            AppMethodBeat.o(116318);
        }
    }

    class b implements Runnable {
        n vxb;
        boolean vxc;

        b(n nVar, boolean z) {
            this.vxb = nVar;
            this.vxc = z;
        }

        public final void run() {
            AppMethodBeat.i(116319);
            Iterator it;
            Iterator it2;
            try {
                Bitmap bitmap;
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                it = a.this.vwO.iterator();
                while (it.hasNext()) {
                    ((com.tencent.mm.e.b) it.next()).CK();
                }
                Bitmap bitmap2 = null;
                if (a.this.vwM.getBaseBoardView().dMM()) {
                    bitmap = a.this.vwQ;
                } else {
                    int width = a.this.vwM.getBaseBoardView().getAliveRect().width();
                    int height = a.this.vwM.getBaseBoardView().getAliveRect().height();
                    if (width > 0 && height > 0) {
                        bitmap2 = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                    }
                    bitmap = bitmap2;
                }
                if (bitmap == null) {
                    this.vxb.onError(new NullPointerException("bitmap is null!"));
                    try {
                        it2 = a.this.vwO.iterator();
                        while (it2.hasNext()) {
                            ((com.tencent.mm.e.b) it2.next()).onFinish();
                        }
                        a.this.onDestroy();
                        AppMethodBeat.o(116319);
                        return;
                    } catch (Exception e) {
                        AppMethodBeat.o(116319);
                        return;
                    }
                }
                Canvas canvas = new Canvas(bitmap);
                Iterator it3 = a.this.vwO.iterator();
                while (it3.hasNext()) {
                    ((com.tencent.mm.e.b) it3.next()).CI().b(canvas);
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(a.this.ccP.path, options);
                float height2 = (((float) options.outHeight) * 1.0f) / ((float) bitmap.getHeight());
                float width2 = (((float) options.outWidth) * 1.0f) / ((float) bitmap.getWidth());
                if (height2 <= width2) {
                    height2 = width2;
                }
                if (height2 == 0.0f) {
                    height2 = 1.0f;
                }
                float b = a.this.vwM.getBaseBoardView().b(a.this.vwM.getBaseBoardView().getMainMatrix());
                Matrix matrix = new Matrix();
                matrix.postScale(height2, height2, 0.0f, 0.0f);
                matrix.postRotate(-b);
                Rect rect = new Rect(a.this.vwM.getBaseBoardView().getAliveRect());
                ab.i("MicroMsg.DrawingPresenter", "[saveEditPhoto] clipRectF:%s w:%s h:%s", rect, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                if (rect.left < 0) {
                    rect.left = 0;
                }
                if (rect.top < 0) {
                    rect.top = 0;
                }
                if (rect.bottom < 0) {
                    rect.bottom = 0;
                }
                if (rect.right < 0) {
                    rect.right = 0;
                }
                if (rect.bottom > bitmap.getHeight()) {
                    rect.bottom = bitmap.getHeight();
                }
                if (rect.right > bitmap.getWidth()) {
                    rect.right = bitmap.getWidth();
                }
                this.vxb.b(a(bitmap, rect, b, options, matrix), this.vxc);
                try {
                    it2 = a.this.vwO.iterator();
                    while (it2.hasNext()) {
                        ((com.tencent.mm.e.b) it2.next()).onFinish();
                    }
                    a.this.onDestroy();
                    AppMethodBeat.o(116319);
                } catch (Exception e2) {
                    AppMethodBeat.o(116319);
                }
            } catch (Exception e3) {
                this.vxb.onError(e3);
                try {
                    it2 = a.this.vwO.iterator();
                    while (it2.hasNext()) {
                        ((com.tencent.mm.e.b) it2.next()).onFinish();
                    }
                    a.this.onDestroy();
                    AppMethodBeat.o(116319);
                } catch (Exception e4) {
                    AppMethodBeat.o(116319);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                try {
                    it = a.this.vwO.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mm.e.b) it.next()).onFinish();
                    }
                    a.this.onDestroy();
                } catch (Exception e5) {
                }
                AppMethodBeat.o(116319);
            }
        }

        private static Bitmap a(Bitmap bitmap, Rect rect, float f, Options options, Matrix matrix) {
            AppMethodBeat.i(116320);
            Bitmap createBitmap;
            try {
                if (bitmap.getWidth() - rect.width() > 9 || bitmap.getHeight() - rect.height() > 9) {
                    createBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
                    AppMethodBeat.o(116320);
                    return createBitmap;
                }
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                AppMethodBeat.o(116320);
                return createBitmap;
            } catch (OutOfMemoryError e) {
                ab.printErrStackTrace("MicroMsg.DrawingPresenter", e, "", new Object[0]);
                float f2 = 1920.0f / ((float) options.outHeight);
                float f3 = 1920.0f / ((float) options.outWidth);
                if (f2 <= f3) {
                    f2 = f3;
                }
                matrix.reset();
                matrix.postScale(f2, f2, 0.0f, 0.0f);
                matrix.postRotate(-f);
                if (bitmap.getWidth() - rect.width() > 9 || bitmap.getHeight() - rect.height() > 9) {
                    createBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
                } else {
                    createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            }
        }
    }

    public final void a(com.tencent.mm.view.a aVar) {
        this.vwM = aVar;
    }

    public final void a(com.tencent.mm.api.s.a aVar) {
        boolean z = true;
        AppMethodBeat.i(116321);
        this.ccP = aVar;
        this.vwN = new HashMap();
        this.vwO = new LinkedList();
        String str = aVar.path;
        if (bo.isNullOrNil(str) || !new File(str).exists()) {
            ab.w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", str);
            z = false;
        } else {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (options.outWidth <= 0 || options.outHeight <= 0) {
                ab.e("MicroMsg.DrawingPresenter", "[checkImage] image err! w:%s h:%s path:%s", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), str);
                z = false;
            }
        }
        if (z) {
            this.vwQ = d.ao(bo.bc(aVar.path, ""), ActUtil.HEIGHT, ActUtil.HEIGHT);
        }
        dlX();
        AppMethodBeat.o(116321);
    }

    public final e[] getFeatures() {
        AppMethodBeat.i(116322);
        e[] features = this.vwM.getFeatures();
        AppMethodBeat.o(116322);
        return features;
    }

    public final r getSelectedFeatureListener() {
        AppMethodBeat.i(116323);
        AnonymousClass1 anonymousClass1 = new r() {
            public final void a(e eVar) {
                AppMethodBeat.i(116303);
                ab.i("MicroMsg.DrawingPresenter", "[onSelectedFeature] features:%s", eVar);
                if (a.this.vwM.getSelectedFeatureListener() != null) {
                    a.this.vwM.getSelectedFeatureListener().a(eVar);
                }
                if (eVar == e.CROP_VIDEO) {
                    a.this.vwM.getFooterBg().setVisibility(8);
                }
                com.tencent.mm.e.b bVar = (com.tencent.mm.e.b) a.this.vwN.get(eVar);
                if (bVar == null) {
                    AppMethodBeat.o(116303);
                    return;
                }
                if (bVar.bZq && !bVar.isAlive()) {
                    bVar.zC();
                }
                if (bVar.CG() != com.tencent.mm.e.a.DEFAULT) {
                    bVar.setOneFingerMoveEnable(false);
                }
                bVar.CJ();
                a.this.vwU = bVar;
                switch (AnonymousClass7.vwX[eVar.ordinal()]) {
                    case 1:
                        ((EditText) a.this.vwM.getTextEditView().findViewById(R.id.bbt)).setTextColor(com.tencent.mm.view.footer.a.AcD[0]);
                        a.this.oW(true);
                        a.this.vwM.setFooterVisible(false);
                        break;
                    case 2:
                        a.this.vwM.setActionBarVisible(false);
                        a.this.vwM.setFooterVisible(false);
                        a.this.vwM.rj(false);
                        break;
                    case 3:
                        a.this.vwS = a.this.vwT;
                        AppMethodBeat.o(116303);
                        return;
                }
                a.this.vwT = eVar;
                AppMethodBeat.o(116303);
            }

            public final void a(e eVar, int i) {
                AppMethodBeat.i(116304);
                ab.i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", eVar, Integer.valueOf(i));
                if (a.this.vwM.getSelectedFeatureListener() != null) {
                    a.this.vwM.getSelectedFeatureListener().a(eVar, i);
                }
                a.this.vwU = (com.tencent.mm.e.b) a.this.vwN.get(eVar);
                if (a.this.dlU().CG() == com.tencent.mm.e.a.DEFAULT) {
                    AppMethodBeat.o(116304);
                    return;
                }
                if (a.this.vwM.getFooterBg().getVisibility() == 8) {
                    a.this.vwM.getFooterBg().setVisibility(0);
                }
                switch (AnonymousClass7.vwX[eVar.ordinal()]) {
                    case 3:
                        c cVar = (c) a.this.dlU();
                        float f;
                        if (i != 0) {
                            if (1 != i) {
                                if (2 != i) {
                                    if (3 == i) {
                                        ab.i("MicroMsg.CropArtist", "[reset]");
                                        cVar.cjP = true;
                                        cVar.cjy.cancel();
                                        if (cVar.cjM != null) {
                                            cVar.cjM.cancel();
                                        }
                                        cVar.cjN.setEmpty();
                                        cVar.CT();
                                        cVar.cjE = false;
                                        cVar.cjc.dlT().getBaseBoardView().AbT = cVar.cch;
                                        cVar.cjc.dlT().getBaseBoardView().a(new com.tencent.mm.view.b.a.b() {
                                            public final void CV() {
                                                AppMethodBeat.i(116160);
                                                c.this.getMainMatrix().set(((a) c.this.CI()).efr);
                                                c.this.CQ();
                                                c.a(c.this, 300, false, false);
                                                AppMethodBeat.o(116160);
                                            }

                                            public final void onStart() {
                                                AppMethodBeat.i(116161);
                                                c.this.cjw = false;
                                                AppMethodBeat.o(116161);
                                            }
                                        }, cVar.getRotation(), true);
                                        break;
                                    }
                                }
                                ab.i("MicroMsg.CropArtist", "[doCrop]");
                                if (cVar.cjM != null) {
                                    cVar.cjM.cancel();
                                }
                                if (cVar.cjy.cco) {
                                    cVar.cjy.uw = null;
                                    cVar.CU();
                                } else {
                                    if (!cVar.cjy.aFV) {
                                        cVar.cjy.cancel();
                                        cVar.cjy.play();
                                    }
                                    cVar.cjy.uw = new AnimatorListener() {
                                        public final void onAnimationStart(Animator animator) {
                                        }

                                        public final void onAnimationEnd(Animator animator) {
                                            AppMethodBeat.i(116157);
                                            c.this.cjy.uw = null;
                                            c.c(c.this);
                                            AppMethodBeat.o(116157);
                                        }

                                        public final void onAnimationCancel(Animator animator) {
                                            AppMethodBeat.i(116158);
                                            c.this.cjy.uw = null;
                                            AppMethodBeat.o(116158);
                                        }

                                        public final void onAnimationRepeat(Animator animator) {
                                        }
                                    };
                                }
                                a.this.vwU = (com.tencent.mm.e.b) a.this.vwN.get(a.this.vwS);
                                a.this.vwM.getBaseFooterView().setCurFeatureType(a.this.vwS);
                                AppMethodBeat.o(116304);
                                return;
                            }
                            ab.i("MicroMsg.CropArtist", "[cancel]");
                            cVar.cjy.cancel();
                            if (cVar.cjM != null) {
                                cVar.cjM.cancel();
                            }
                            cVar.cjc.dlT().getBaseBoardView().AbT = cVar.cjc.dlT().getBaseBoardView().getRawBoardRect();
                            com.tencent.mm.y.a Jf = ((com.tencent.mm.cache.a) cVar.CI()).Jf();
                            f = 0.0f;
                            if (Jf != null) {
                                f = cVar.getRotation() - cVar.b(Jf.mMatrix);
                            }
                            if (!(Jf == null || Jf.eHd.isEmpty())) {
                                cVar.cjc.dlT().getBaseBoardView().o(Jf.eHd);
                            }
                            cVar.cjc.dlT().getBaseBoardView().a(null, f, true);
                            cVar.cjc.dlT().getActionBar().setVisibility(0);
                            a.this.vwU = (com.tencent.mm.e.b) a.this.vwN.get(a.this.vwS);
                            a.this.vwM.getBaseFooterView().setCurFeatureType(a.this.vwS);
                            AppMethodBeat.o(116304);
                            return;
                        }
                        cVar.cjO++;
                        cVar.cjy.cancel();
                        if (cVar.cjM != null) {
                            cVar.cjM.cancel();
                        }
                        Matrix matrix = new Matrix();
                        matrix.postRotate(-90.0f, (float) cVar.cch.centerX(), (float) cVar.cch.centerY());
                        if (cVar.cjN.isEmpty()) {
                            cVar.cjN.set(cVar.cch);
                        }
                        RectF rectF = new RectF(cVar.cjN);
                        matrix.mapRect(rectF);
                        f = (1.0f * ((float) cVar.cju.width())) / rectF.width();
                        float height = (1.0f * ((float) cVar.cju.height())) / rectF.height();
                        if (f >= height) {
                            f = height;
                        }
                        matrix.postScale(f, f, (float) cVar.cch.centerX(), (float) cVar.cch.centerY());
                        rectF.set(cVar.cjN);
                        matrix.mapRect(rectF);
                        cVar.cjN.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                        height = (float) cVar.cch.centerX();
                        float centerY = (float) cVar.cch.centerY();
                        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("rotation", new int[]{0, -90});
                        PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("deltaX", new int[]{0, cVar.cju.centerX() - ((int) height)});
                        PropertyValuesHolder ofInt3 = PropertyValuesHolder.ofInt("deltaY", new int[]{0, cVar.cju.centerY() - ((int) centerY)});
                        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt, ofInt2, ofInt3});
                        ofPropertyValuesHolder.addUpdateListener(new AnonymousClass8(height, centerY, f));
                        ofPropertyValuesHolder.addListener(new AnimatorListener() {
                            public final void onAnimationStart(Animator animator) {
                                AppMethodBeat.i(116164);
                                c.this.cjw = false;
                                c.this.cjE = true;
                                c.this.cjx = true;
                                AppMethodBeat.o(116164);
                            }

                            public final void onAnimationEnd(Animator animator) {
                                AppMethodBeat.i(116165);
                                ab.i("MicroMsg.CropArtist", "onAnimationEnd");
                                c.this.cjO = c.this.cjO - 1;
                                if (c.this.cjO == 0) {
                                    c.this.cjx = false;
                                    RectF rectF = new RectF();
                                    rectF.set(c.this.cch);
                                    c.this.cjp.mapRect(rectF);
                                    c.this.cjp.reset();
                                    c.this.cch.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                                    c.this.CS();
                                }
                                c.a(c.this, 200, false, true);
                                AppMethodBeat.o(116165);
                            }

                            public final void onAnimationCancel(Animator animator) {
                            }

                            public final void onAnimationRepeat(Animator animator) {
                            }
                        });
                        ofPropertyValuesHolder.setDuration(200);
                        ofPropertyValuesHolder.start();
                        AppMethodBeat.o(116304);
                        return;
                        break;
                    case 4:
                        com.tencent.mm.e.d dVar = (com.tencent.mm.e.d) a.this.dlU();
                        if (i != -1) {
                            a.this.vwM.getBaseFooterView();
                            dVar.mColor = com.tencent.mm.view.footer.a.getColor(i);
                            AppMethodBeat.o(116304);
                            return;
                        }
                        dVar.CO();
                        AppMethodBeat.o(116304);
                        return;
                    case 5:
                        f fVar = (f) a.this.dlU();
                        if (i == 0) {
                            fVar.ckt = com.tencent.mm.y.d.a.ONE;
                            AppMethodBeat.o(116304);
                            return;
                        } else if (1 == i) {
                            fVar.ckt = com.tencent.mm.y.d.a.TWO;
                            AppMethodBeat.o(116304);
                            return;
                        } else {
                            fVar.CO();
                            AppMethodBeat.o(116304);
                            return;
                        }
                }
                AppMethodBeat.o(116304);
            }

            public final void bd(boolean z) {
            }
        };
        AppMethodBeat.o(116323);
        return anonymousClass1;
    }

    public final void setActionBarCallback(g gVar) {
        this.vwP = gVar;
    }

    public final void setAutoShowFooterAndBar(boolean z) {
        this.vwR = z;
    }

    public final void onExit() {
        AppMethodBeat.i(116324);
        if (this.vwP != null) {
            this.vwP.onExit();
        }
        AppMethodBeat.o(116324);
    }

    public final void onFinish() {
        AppMethodBeat.i(116326);
        if (this.vwP != null) {
            this.vwP.onFinish();
        }
        AppMethodBeat.o(116326);
    }

    public final void a(Editable editable, int i, int i2) {
        AppMethodBeat.i(116327);
        oW(false);
        this.vwM.setFooterVisible(true);
        com.tencent.mm.e.b dlU = dlU();
        if (dlU.CG() == com.tencent.mm.e.a.EMOJI_AND_TEXT) {
            com.tencent.mm.e.e eVar = (com.tencent.mm.e.e) dlU;
            EditText editText = (EditText) this.vwM.getTextEditView().findViewById(R.id.bbt);
            if (editText.getTag() == null || !(editText.getTag() instanceof com.tencent.mm.y.e)) {
                eVar.a(j.b(this.vwM.getContext(), (CharSequence) editable), i, i2);
            } else {
                eVar.a((com.tencent.mm.y.e) editText.getTag(), j.b(this.vwM.getContext(), (CharSequence) editable), i, i2);
            }
            editText.setTag(null);
        }
        AppMethodBeat.o(116327);
    }

    public final com.tencent.mm.view.a dlT() {
        return this.vwM;
    }

    public final Context getContext() {
        AppMethodBeat.i(139047);
        Context context = this.vwM.getContext();
        AppMethodBeat.o(139047);
        return context;
    }

    public final com.tencent.mm.api.s.a getConfig() {
        return this.ccP;
    }

    public final <T extends com.tencent.mm.e.b> T dlU() {
        AppMethodBeat.i(116330);
        if (this.vwU != null) {
            com.tencent.mm.e.b bVar = this.vwU;
            AppMethodBeat.o(116330);
            return bVar;
        }
        ab.e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
        T t = com.tencent.mm.e.b.cjg;
        AppMethodBeat.o(116330);
        return t;
    }

    public final void a(n nVar, boolean z) {
        AppMethodBeat.i(116333);
        com.tencent.mm.sdk.g.d.post(new b(nVar, z), "onFinalGenerate");
        AppMethodBeat.o(116333);
    }

    public final void onDestroy() {
        AppMethodBeat.i(116334);
        Iterator it = this.vwO.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.e.b) it.next()).onDestroy();
        }
        this.vwO.clear();
        this.vwN.clear();
        AppMethodBeat.o(116334);
    }

    public final void onAttachedToWindow() {
        AppMethodBeat.i(116335);
        ab.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow]");
        Iterator it = this.vwO.iterator();
        while (it.hasNext()) {
            boolean z;
            com.tencent.mm.e.b bVar = (com.tencent.mm.e.b) it.next();
            ArtistCacheManager Jc = ArtistCacheManager.Jc();
            com.tencent.mm.e.a CG = bVar.CG();
            if (ArtistCacheManager.efj.containsKey(Jc.efl) && ((com.tencent.mm.cache.ArtistCacheManager.a) ArtistCacheManager.efj.get(Jc.efl)).efo.containsKey(CG)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                bVar.zC();
                bVar.bk(true);
                ab.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", bVar.CG());
            }
        }
        if (this.vwM.getBaseBoardView().dMM()) {
            this.vwM.getBaseBoardView().dMN();
            this.vwM.getBaseBoardView().invalidate();
        }
        AppMethodBeat.o(116335);
    }

    public final Bitmap dlV() {
        return this.vwQ;
    }

    public final boolean dlW() {
        AppMethodBeat.i(116336);
        if (dlU().CG() == com.tencent.mm.e.a.CROP_PHOTO || !this.vwR) {
            AppMethodBeat.o(116336);
            return false;
        }
        AppMethodBeat.o(116336);
        return true;
    }

    public final <T extends com.tencent.mm.e.b> T b(e eVar) {
        AppMethodBeat.i(116337);
        com.tencent.mm.e.b bVar = (com.tencent.mm.e.b) this.vwN.get(eVar);
        AppMethodBeat.o(116337);
        return bVar;
    }

    public final void d(k kVar) {
        AppMethodBeat.i(116338);
        ((com.tencent.mm.e.e) b(e.EMOJI)).b(kVar);
        AppMethodBeat.o(116338);
    }

    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(116340);
        Iterator it = this.vwO.iterator();
        while (it.hasNext()) {
            com.tencent.mm.e.b bVar = (com.tencent.mm.e.b) it.next();
            if (bVar.isAlive()) {
                if (dlU().CG() == bVar.CG()) {
                    bVar.onDraw(canvas);
                } else {
                    canvas.save();
                    canvas.clipRect(this.vwM.getBaseBoardView().getAliveRect());
                    bVar.a(canvas);
                    canvas.restore();
                }
            }
        }
        AppMethodBeat.o(116340);
    }

    public final com.tencent.mm.cache.d a(com.tencent.mm.e.a aVar) {
        AppMethodBeat.i(116341);
        com.tencent.mm.cache.d a = ArtistCacheManager.Jc().a(aVar);
        AppMethodBeat.o(116341);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dlX() {
        AppMethodBeat.i(116342);
        this.vwO.clear();
        this.vwN.clear();
        this.vwN.put(e.DEFAULT, com.tencent.mm.e.b.cjg);
        for (e eVar : this.vwM.getFeatures()) {
            Object obj = null;
            switch (eVar) {
                case TEXT:
                case EMOJI:
                    int i;
                    Iterator it = this.vwO.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.e.b bVar = (com.tencent.mm.e.b) it.next();
                        if (bVar.CG() == com.tencent.mm.e.a.EMOJI_AND_TEXT) {
                            i = 1;
                            obj = bVar;
                            if (i == 0) {
                                obj = new com.tencent.mm.e.e();
                                ((com.tencent.mm.e.e) obj).ckm = new a();
                                break;
                            }
                        }
                    }
                    i = 0;
                    if (i == 0) {
                    }
                    break;
                case CROP_PHOTO:
                    obj = new c();
                    break;
                case DOODLE:
                    obj = new com.tencent.mm.e.d();
                    break;
                case MOSAIC:
                    obj = new f();
                    break;
            }
            if (obj != null) {
                if (!this.vwN.containsKey(eVar)) {
                    this.vwN.put(eVar, obj);
                }
                if (!this.vwO.contains(obj)) {
                    this.vwO.add(obj);
                    obj.a(this, this.vwM.getBaseBoardView().getMainMatrix(), this.vwM.getBaseBoardView().getAliveRect());
                }
            }
        }
        Collections.sort(this.vwO, new Comparator<com.tencent.mm.e.b>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(116305);
                int i = ((com.tencent.mm.e.b) obj).CG().value - ((com.tencent.mm.e.b) obj2).CG().value;
                AppMethodBeat.o(116305);
                return i;
            }
        });
        ab.i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", Integer.valueOf(this.vwN.size() - 1));
        AppMethodBeat.o(116342);
    }

    /* Access modifiers changed, original: final */
    public final void oW(boolean z) {
        AppMethodBeat.i(116343);
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(this.vwM.getContext(), R.anim.cg);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(116307);
                    a.this.vwM.getTextEditView().setVisibility(0);
                    EditText editText = (EditText) a.this.vwM.getTextEditView().findViewById(R.id.bbt);
                    editText.requestFocus();
                    editText.setSelection(editText.length());
                    a.this.vwM.getSelectedFeatureListener().bd(true);
                    ((SelectColorBar) a.this.vwM.findViewById(R.id.bbv)).setSelectColor(editText.getCurrentTextColor());
                    a.this.vwM.getActionBar().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(116306);
                            a.this.vwM.getActionBar().setVisibility(0);
                            AppMethodBeat.o(116306);
                        }
                    });
                    AppMethodBeat.o(116307);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.vwM.getTextEditView().startAnimation(loadAnimation);
            AppMethodBeat.o(116343);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(this.vwM.getContext(), R.anim.ce);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(116308);
                a.this.vwM.getSelectedFeatureListener().bd(false);
                AppMethodBeat.o(116308);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(116309);
                ((EditText) a.this.vwM.getTextEditView().findViewById(R.id.bbt)).setText("");
                a.this.vwM.getTextEditView().setVisibility(8);
                AppMethodBeat.o(116309);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.vwM.getTextEditView().startAnimation(loadAnimation);
        AppMethodBeat.o(116343);
    }

    public final boolean Ab() {
        AppMethodBeat.i(116325);
        if (this.vwM.getTextEditView().getVisibility() == 0) {
            oW(false);
            this.vwM.setFooterVisible(true);
            AppMethodBeat.o(116325);
            return true;
        } else if (this.vwM.getChatFooterPanel() == null || this.vwM.getChatFooterPanel().getVisibility() != 0) {
            AppMethodBeat.o(116325);
            return false;
        } else {
            this.vwM.rj(true);
            this.vwM.setFooterVisible(true);
            AppMethodBeat.o(116325);
            return true;
        }
    }

    public final void dlS() {
        AppMethodBeat.i(116328);
        this.vwM.setFooterVisible(true);
        oW(false);
        AppMethodBeat.o(116328);
    }

    public final float getInitScale() {
        AppMethodBeat.i(116331);
        float initScale = this.vwM.getBaseBoardView().getInitScale();
        AppMethodBeat.o(116331);
        return initScale;
    }

    public final float getCurScale() {
        AppMethodBeat.i(116332);
        float curScale = this.vwM.getBaseBoardView().getCurScale();
        AppMethodBeat.o(116332);
        return curScale;
    }

    public final boolean G(MotionEvent motionEvent) {
        com.tencent.mm.e.b bVar;
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(116339);
        if (!(dlU().CG() == com.tencent.mm.e.a.CROP_PHOTO || dlU().CG() == com.tencent.mm.e.a.CROP_VIDEO)) {
            bVar = null;
            if (this.vwN.containsKey(e.TEXT)) {
                bVar = (com.tencent.mm.e.b) this.vwN.get(e.TEXT);
            } else if (this.vwN.containsKey(e.EMOJI)) {
                bVar = (com.tencent.mm.e.b) this.vwN.get(e.EMOJI);
            }
            if (bVar != null) {
                z2 = bVar.o(motionEvent);
            }
            if (z2) {
                this.vwU = bVar;
            }
        }
        if (!z2) {
            this.vwU = (com.tencent.mm.e.b) this.vwN.get(this.vwM.getBaseFooterView().getCurFeatureType());
            Iterator it = this.vwO.iterator();
            while (it.hasNext()) {
                bVar = (com.tencent.mm.e.b) it.next();
                if (bVar.CG() != com.tencent.mm.e.a.EMOJI_AND_TEXT && bVar.o(motionEvent)) {
                    z = true;
                    break;
                }
            }
        }
        z = z2;
        AppMethodBeat.o(116339);
        return z;
    }
}
