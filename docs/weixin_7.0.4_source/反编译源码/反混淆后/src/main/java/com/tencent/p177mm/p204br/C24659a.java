package com.tencent.p177mm.p204br;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C25784s.C25785a;
import com.tencent.p177mm.api.C32247e;
import com.tencent.p177mm.api.C32249g;
import com.tencent.p177mm.api.C37464n;
import com.tencent.p177mm.api.C8955k;
import com.tencent.p177mm.api.C8956r;
import com.tencent.p177mm.cache.ArtistCacheManager;
import com.tencent.p177mm.cache.ArtistCacheManager.C18126a;
import com.tencent.p177mm.cache.C18128d;
import com.tencent.p177mm.cache.C41918a;
import com.tencent.p177mm.p1525ae.C37434a;
import com.tencent.p177mm.p226e.C1493a;
import com.tencent.p177mm.p226e.C1497c;
import com.tencent.p177mm.p226e.C1497c.C14989;
import com.tencent.p177mm.p226e.C1497c.C14997;
import com.tencent.p177mm.p226e.C1497c.C15025;
import com.tencent.p177mm.p226e.C1497c.C15038;
import com.tencent.p177mm.p226e.C1505d;
import com.tencent.p177mm.p226e.C32495e;
import com.tencent.p177mm.p226e.C32496f;
import com.tencent.p177mm.p226e.C9268b;
import com.tencent.p177mm.p651y.C24186a;
import com.tencent.p177mm.p651y.C36401d.C24187a;
import com.tencent.p177mm.p651y.C36890e;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.view.C16051a;
import com.tencent.p177mm.view.footer.C16070a;
import com.tencent.p177mm.view.footer.SelectColorBar;
import com.tencent.ttpic.util.ActUtil;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.br.a */
public final class C24659a implements C18117b {
    C25785a ccP;
    C16051a vwM;
    HashMap<C32247e, C9268b> vwN;
    LinkedList<C9268b> vwO;
    private C32249g vwP;
    Bitmap vwQ;
    private boolean vwR = true;
    C32247e vwS = C32247e.DEFAULT;
    C32247e vwT = C32247e.DEFAULT;
    C9268b vwU = null;

    /* renamed from: com.tencent.mm.br.a$1 */
    class C13291 implements C8956r {
        C13291() {
        }

        /* renamed from: a */
        public final void mo4525a(C32247e c32247e) {
            AppMethodBeat.m2504i(116303);
            C4990ab.m7417i("MicroMsg.DrawingPresenter", "[onSelectedFeature] features:%s", c32247e);
            if (C24659a.this.vwM.getSelectedFeatureListener() != null) {
                C24659a.this.vwM.getSelectedFeatureListener().mo4525a(c32247e);
            }
            if (c32247e == C32247e.CROP_VIDEO) {
                C24659a.this.vwM.getFooterBg().setVisibility(8);
            }
            C9268b c9268b = (C9268b) C24659a.this.vwN.get(c32247e);
            if (c9268b == null) {
                AppMethodBeat.m2505o(116303);
                return;
            }
            if (c9268b.bZq && !c9268b.isAlive()) {
                c9268b.mo4955zC();
            }
            if (c9268b.mo4943CG() != C1493a.DEFAULT) {
                c9268b.setOneFingerMoveEnable(false);
            }
            c9268b.mo4948CJ();
            C24659a.this.vwU = c9268b;
            switch (C246627.vwX[c32247e.ordinal()]) {
                case 1:
                    ((EditText) C24659a.this.vwM.getTextEditView().findViewById(2131823386)).setTextColor(C16070a.AcD[0]);
                    C24659a.this.mo41541oW(true);
                    C24659a.this.vwM.setFooterVisible(false);
                    break;
                case 2:
                    C24659a.this.vwM.setActionBarVisible(false);
                    C24659a.this.vwM.setFooterVisible(false);
                    C24659a.this.vwM.mo28431rj(false);
                    break;
                case 3:
                    C24659a.this.vwS = C24659a.this.vwT;
                    AppMethodBeat.m2505o(116303);
                    return;
            }
            C24659a.this.vwT = c32247e;
            AppMethodBeat.m2505o(116303);
        }

        /* renamed from: a */
        public final void mo4526a(C32247e c32247e, int i) {
            AppMethodBeat.m2504i(116304);
            C4990ab.m7417i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", c32247e, Integer.valueOf(i));
            if (C24659a.this.vwM.getSelectedFeatureListener() != null) {
                C24659a.this.vwM.getSelectedFeatureListener().mo4526a(c32247e, i);
            }
            C24659a.this.vwU = (C9268b) C24659a.this.vwN.get(c32247e);
            if (C24659a.this.dlU().mo4943CG() == C1493a.DEFAULT) {
                AppMethodBeat.m2505o(116304);
                return;
            }
            if (C24659a.this.vwM.getFooterBg().getVisibility() == 8) {
                C24659a.this.vwM.getFooterBg().setVisibility(0);
            }
            switch (C246627.vwX[c32247e.ordinal()]) {
                case 3:
                    C1497c c1497c = (C1497c) C24659a.this.dlU();
                    float f;
                    if (i != 0) {
                        if (1 != i) {
                            if (2 != i) {
                                if (3 == i) {
                                    C4990ab.m7416i("MicroMsg.CropArtist", "[reset]");
                                    c1497c.cjP = true;
                                    c1497c.cjy.cancel();
                                    if (c1497c.cjM != null) {
                                        c1497c.cjM.cancel();
                                    }
                                    c1497c.cjN.setEmpty();
                                    c1497c.mo4951CT();
                                    c1497c.cjE = false;
                                    c1497c.cjc.dlT().getBaseBoardView().AbT = c1497c.cch;
                                    c1497c.cjc.dlT().getBaseBoardView().mo49332a(new C14997(), c1497c.getRotation(), true);
                                    break;
                                }
                            }
                            C4990ab.m7416i("MicroMsg.CropArtist", "[doCrop]");
                            if (c1497c.cjM != null) {
                                c1497c.cjM.cancel();
                            }
                            if (c1497c.cjy.cco) {
                                c1497c.cjy.f13660uw = null;
                                c1497c.mo4952CU();
                            } else {
                                if (!c1497c.cjy.aFV) {
                                    c1497c.cjy.cancel();
                                    c1497c.cjy.play();
                                }
                                c1497c.cjy.f13660uw = new C15025();
                            }
                            C24659a.this.vwU = (C9268b) C24659a.this.vwN.get(C24659a.this.vwS);
                            C24659a.this.vwM.getBaseFooterView().setCurFeatureType(C24659a.this.vwS);
                            AppMethodBeat.m2505o(116304);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.CropArtist", "[cancel]");
                        c1497c.cjy.cancel();
                        if (c1497c.cjM != null) {
                            c1497c.cjM.cancel();
                        }
                        c1497c.cjc.dlT().getBaseBoardView().AbT = c1497c.cjc.dlT().getBaseBoardView().getRawBoardRect();
                        C24186a Jf = ((C41918a) c1497c.mo20691CI()).mo67563Jf();
                        f = 0.0f;
                        if (Jf != null) {
                            f = c1497c.getRotation() - c1497c.mo20699b(Jf.mMatrix);
                        }
                        if (!(Jf == null || Jf.eHd.isEmpty())) {
                            c1497c.cjc.dlT().getBaseBoardView().mo49350o(Jf.eHd);
                        }
                        c1497c.cjc.dlT().getBaseBoardView().mo49332a(null, f, true);
                        c1497c.cjc.dlT().getActionBar().setVisibility(0);
                        C24659a.this.vwU = (C9268b) C24659a.this.vwN.get(C24659a.this.vwS);
                        C24659a.this.vwM.getBaseFooterView().setCurFeatureType(C24659a.this.vwS);
                        AppMethodBeat.m2505o(116304);
                        return;
                    }
                    c1497c.cjO++;
                    c1497c.cjy.cancel();
                    if (c1497c.cjM != null) {
                        c1497c.cjM.cancel();
                    }
                    Matrix matrix = new Matrix();
                    matrix.postRotate(-90.0f, (float) c1497c.cch.centerX(), (float) c1497c.cch.centerY());
                    if (c1497c.cjN.isEmpty()) {
                        c1497c.cjN.set(c1497c.cch);
                    }
                    RectF rectF = new RectF(c1497c.cjN);
                    matrix.mapRect(rectF);
                    f = (1.0f * ((float) c1497c.cju.width())) / rectF.width();
                    float height = (1.0f * ((float) c1497c.cju.height())) / rectF.height();
                    if (f >= height) {
                        f = height;
                    }
                    matrix.postScale(f, f, (float) c1497c.cch.centerX(), (float) c1497c.cch.centerY());
                    rectF.set(c1497c.cjN);
                    matrix.mapRect(rectF);
                    c1497c.cjN.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    height = (float) c1497c.cch.centerX();
                    float centerY = (float) c1497c.cch.centerY();
                    PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("rotation", new int[]{0, -90});
                    PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("deltaX", new int[]{0, c1497c.cju.centerX() - ((int) height)});
                    PropertyValuesHolder ofInt3 = PropertyValuesHolder.ofInt("deltaY", new int[]{0, c1497c.cju.centerY() - ((int) centerY)});
                    ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt, ofInt2, ofInt3});
                    ofPropertyValuesHolder.addUpdateListener(new C15038(height, centerY, f));
                    ofPropertyValuesHolder.addListener(new C14989());
                    ofPropertyValuesHolder.setDuration(200);
                    ofPropertyValuesHolder.start();
                    AppMethodBeat.m2505o(116304);
                    return;
                    break;
                case 4:
                    C1505d c1505d = (C1505d) C24659a.this.dlU();
                    if (i != -1) {
                        C24659a.this.vwM.getBaseFooterView();
                        c1505d.mColor = C16070a.getColor(i);
                        AppMethodBeat.m2505o(116304);
                        return;
                    }
                    c1505d.mo20695CO();
                    AppMethodBeat.m2505o(116304);
                    return;
                case 5:
                    C32496f c32496f = (C32496f) C24659a.this.dlU();
                    if (i == 0) {
                        c32496f.ckt = C24187a.ONE;
                        AppMethodBeat.m2505o(116304);
                        return;
                    } else if (1 == i) {
                        c32496f.ckt = C24187a.TWO;
                        AppMethodBeat.m2505o(116304);
                        return;
                    } else {
                        c32496f.mo20695CO();
                        AppMethodBeat.m2505o(116304);
                        return;
                    }
            }
            AppMethodBeat.m2505o(116304);
        }

        /* renamed from: bd */
        public final void mo4527bd(boolean z) {
        }
    }

    /* renamed from: com.tencent.mm.br.a$2 */
    class C13302 implements Comparator<C9268b> {
        C13302() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(116305);
            int i = ((C9268b) obj).mo4943CG().value - ((C9268b) obj2).mo4943CG().value;
            AppMethodBeat.m2505o(116305);
            return i;
        }
    }

    /* renamed from: com.tencent.mm.br.a$3 */
    class C181153 implements AnimationListener {

        /* renamed from: com.tencent.mm.br.a$3$1 */
        class C181161 implements Runnable {
            C181161() {
            }

            public final void run() {
                AppMethodBeat.m2504i(116306);
                C24659a.this.vwM.getActionBar().setVisibility(0);
                AppMethodBeat.m2505o(116306);
            }
        }

        C181153() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(116307);
            C24659a.this.vwM.getTextEditView().setVisibility(0);
            EditText editText = (EditText) C24659a.this.vwM.getTextEditView().findViewById(2131823386);
            editText.requestFocus();
            editText.setSelection(editText.length());
            C24659a.this.vwM.getSelectedFeatureListener().mo4527bd(true);
            ((SelectColorBar) C24659a.this.vwM.findViewById(2131823388)).setSelectColor(editText.getCurrentTextColor());
            C24659a.this.vwM.getActionBar().post(new C181161());
            AppMethodBeat.m2505o(116307);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.br.a$5 */
    class C246605 implements AnimationListener {
        C246605() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(116310);
            C24659a.this.vwM.getRubbishView().setVisibility(0);
            AppMethodBeat.m2505o(116310);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.br.a$6 */
    class C246616 implements AnimationListener {
        C246616() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(116311);
            C24659a.this.vwM.getRubbishView().setVisibility(8);
            AppMethodBeat.m2505o(116311);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.br.a$a */
    class C24663a implements C37434a {
        View vwY = C24659a.this.vwM.getRubbishView();
        TextView vwZ = ((TextView) this.vwY.findViewById(2131827174));
        ImageView vxa = ((ImageView) this.vwY.findViewById(2131827173));

        C24663a() {
            AppMethodBeat.m2504i(116313);
            AppMethodBeat.m2505o(116313);
        }

        /* renamed from: ae */
        public final void mo41550ae(float f) {
            AppMethodBeat.m2504i(116314);
            C4990ab.m7417i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", Float.valueOf(f));
            this.vwZ.setText(C24659a.this.vwM.getContext().getString(C25738R.string.dvv));
            this.vxa.setImageResource(C25738R.drawable.bgh);
            AppMethodBeat.m2505o(116314);
        }

        /* renamed from: Ta */
        public final void mo41548Ta() {
            AppMethodBeat.m2504i(116315);
            C4990ab.m7416i("MicroMsg.DrawingPresenter", "[onUnReach]");
            this.vxa.setImageResource(C25738R.drawable.f7024yw);
            this.vwZ.setText(C24659a.this.vwM.getContext().getString(C25738R.string.dvw));
            AppMethodBeat.m2505o(116315);
        }

        public final void onShow() {
            AppMethodBeat.m2504i(116316);
            C24659a.m38438a(C24659a.this, true);
            AppMethodBeat.m2505o(116316);
        }

        public final void onHide() {
            AppMethodBeat.m2504i(116317);
            C24659a.m38438a(C24659a.this, false);
            AppMethodBeat.m2505o(116317);
        }

        /* renamed from: a */
        public final void mo41549a(C36890e c36890e) {
            AppMethodBeat.m2504i(116318);
            EditText editText = (EditText) C24659a.this.vwM.getTextEditView().findViewById(2131823386);
            editText.setText(c36890e.eHF);
            Switch switchR = (Switch) C24659a.this.vwM.findViewById(2131823387);
            SelectColorBar selectColorBar = (SelectColorBar) C24659a.this.vwM.findViewById(2131823388);
            switchR.setChecked(c36890e.eHE != 0);
            if (switchR.isChecked()) {
                selectColorBar.setSelectColor(c36890e.eHE);
            } else {
                selectColorBar.setSelectColor(c36890e.mColor);
            }
            editText.setTextColor(c36890e.mColor);
            editText.setTag(c36890e);
            C24659a.this.mo41541oW(true);
            AppMethodBeat.m2505o(116318);
        }
    }

    /* renamed from: com.tencent.mm.br.a$4 */
    class C246644 implements AnimationListener {
        C246644() {
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(116308);
            C24659a.this.vwM.getSelectedFeatureListener().mo4527bd(false);
            AppMethodBeat.m2505o(116308);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(116309);
            ((EditText) C24659a.this.vwM.getTextEditView().findViewById(2131823386)).setText("");
            C24659a.this.vwM.getTextEditView().setVisibility(8);
            AppMethodBeat.m2505o(116309);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.br.a$b */
    class C24665b implements Runnable {
        C37464n vxb;
        boolean vxc;

        C24665b(C37464n c37464n, boolean z) {
            this.vxb = c37464n;
            this.vxc = z;
        }

        public final void run() {
            AppMethodBeat.m2504i(116319);
            Iterator it;
            Iterator it2;
            try {
                Bitmap bitmap;
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                it = C24659a.this.vwO.iterator();
                while (it.hasNext()) {
                    ((C9268b) it.next()).mo20692CK();
                }
                Bitmap bitmap2 = null;
                if (C24659a.this.vwM.getBaseBoardView().dMM()) {
                    bitmap = C24659a.this.vwQ;
                } else {
                    int width = C24659a.this.vwM.getBaseBoardView().getAliveRect().width();
                    int height = C24659a.this.vwM.getBaseBoardView().getAliveRect().height();
                    if (width > 0 && height > 0) {
                        bitmap2 = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                    }
                    bitmap = bitmap2;
                }
                if (bitmap == null) {
                    this.vxb.onError(new NullPointerException("bitmap is null!"));
                    try {
                        it2 = C24659a.this.vwO.iterator();
                        while (it2.hasNext()) {
                            ((C9268b) it2.next()).onFinish();
                        }
                        C24659a.this.onDestroy();
                        AppMethodBeat.m2505o(116319);
                        return;
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(116319);
                        return;
                    }
                }
                Canvas canvas = new Canvas(bitmap);
                Iterator it3 = C24659a.this.vwO.iterator();
                while (it3.hasNext()) {
                    ((C9268b) it3.next()).mo20691CI().mo33618b(canvas);
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(C24659a.this.ccP.path, options);
                float height2 = (((float) options.outHeight) * 1.0f) / ((float) bitmap.getHeight());
                float width2 = (((float) options.outWidth) * 1.0f) / ((float) bitmap.getWidth());
                if (height2 <= width2) {
                    height2 = width2;
                }
                if (height2 == 0.0f) {
                    height2 = 1.0f;
                }
                float b = C24659a.this.vwM.getBaseBoardView().mo49333b(C24659a.this.vwM.getBaseBoardView().getMainMatrix());
                Matrix matrix = new Matrix();
                matrix.postScale(height2, height2, 0.0f, 0.0f);
                matrix.postRotate(-b);
                Rect rect = new Rect(C24659a.this.vwM.getBaseBoardView().getAliveRect());
                C4990ab.m7417i("MicroMsg.DrawingPresenter", "[saveEditPhoto] clipRectF:%s w:%s h:%s", rect, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
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
                this.vxb.mo7985b(C24665b.m38452a(bitmap, rect, b, options, matrix), this.vxc);
                try {
                    it2 = C24659a.this.vwO.iterator();
                    while (it2.hasNext()) {
                        ((C9268b) it2.next()).onFinish();
                    }
                    C24659a.this.onDestroy();
                    AppMethodBeat.m2505o(116319);
                } catch (Exception e2) {
                    AppMethodBeat.m2505o(116319);
                }
            } catch (Exception e3) {
                this.vxb.onError(e3);
                try {
                    it2 = C24659a.this.vwO.iterator();
                    while (it2.hasNext()) {
                        ((C9268b) it2.next()).onFinish();
                    }
                    C24659a.this.onDestroy();
                    AppMethodBeat.m2505o(116319);
                } catch (Exception e4) {
                    AppMethodBeat.m2505o(116319);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                try {
                    it = C24659a.this.vwO.iterator();
                    while (it.hasNext()) {
                        ((C9268b) it.next()).onFinish();
                    }
                    C24659a.this.onDestroy();
                } catch (Exception e5) {
                }
                AppMethodBeat.m2505o(116319);
            }
        }

        /* renamed from: a */
        private static Bitmap m38452a(Bitmap bitmap, Rect rect, float f, Options options, Matrix matrix) {
            AppMethodBeat.m2504i(116320);
            Bitmap createBitmap;
            try {
                if (bitmap.getWidth() - rect.width() > 9 || bitmap.getHeight() - rect.height() > 9) {
                    createBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
                    AppMethodBeat.m2505o(116320);
                    return createBitmap;
                }
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                AppMethodBeat.m2505o(116320);
                return createBitmap;
            } catch (OutOfMemoryError e) {
                C4990ab.printErrStackTrace("MicroMsg.DrawingPresenter", e, "", new Object[0]);
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

    /* renamed from: a */
    public final void mo33565a(C16051a c16051a) {
        this.vwM = c16051a;
    }

    /* renamed from: a */
    public final void mo33564a(C25785a c25785a) {
        boolean z = true;
        AppMethodBeat.m2504i(116321);
        this.ccP = c25785a;
        this.vwN = new HashMap();
        this.vwO = new LinkedList();
        String str = c25785a.path;
        if (C5046bo.isNullOrNil(str) || !new File(str).exists()) {
            C4990ab.m7421w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", str);
            z = false;
        } else {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (options.outWidth <= 0 || options.outHeight <= 0) {
                C4990ab.m7413e("MicroMsg.DrawingPresenter", "[checkImage] image err! w:%s h:%s path:%s", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), str);
                z = false;
            }
        }
        if (z) {
            this.vwQ = C5056d.m7641ao(C5046bo.m7532bc(c25785a.path, ""), ActUtil.HEIGHT, ActUtil.HEIGHT);
        }
        dlX();
        AppMethodBeat.m2505o(116321);
    }

    public final C32247e[] getFeatures() {
        AppMethodBeat.m2504i(116322);
        C32247e[] features = this.vwM.getFeatures();
        AppMethodBeat.m2505o(116322);
        return features;
    }

    public final C8956r getSelectedFeatureListener() {
        AppMethodBeat.m2504i(116323);
        C13291 c13291 = new C13291();
        AppMethodBeat.m2505o(116323);
        return c13291;
    }

    public final void setActionBarCallback(C32249g c32249g) {
        this.vwP = c32249g;
    }

    public final void setAutoShowFooterAndBar(boolean z) {
        this.vwR = z;
    }

    public final void onExit() {
        AppMethodBeat.m2504i(116324);
        if (this.vwP != null) {
            this.vwP.onExit();
        }
        AppMethodBeat.m2505o(116324);
    }

    public final void onFinish() {
        AppMethodBeat.m2504i(116326);
        if (this.vwP != null) {
            this.vwP.onFinish();
        }
        AppMethodBeat.m2505o(116326);
    }

    /* renamed from: a */
    public final void mo33562a(Editable editable, int i, int i2) {
        AppMethodBeat.m2504i(116327);
        mo41541oW(false);
        this.vwM.setFooterVisible(true);
        C9268b dlU = dlU();
        if (dlU.mo4943CG() == C1493a.EMOJI_AND_TEXT) {
            C32495e c32495e = (C32495e) dlU;
            EditText editText = (EditText) this.vwM.getTextEditView().findViewById(2131823386);
            if (editText.getTag() == null || !(editText.getTag() instanceof C36890e)) {
                c32495e.mo53131a(C44089j.m79292b(this.vwM.getContext(), (CharSequence) editable), i, i2);
            } else {
                c32495e.mo53132a((C36890e) editText.getTag(), C44089j.m79292b(this.vwM.getContext(), (CharSequence) editable), i, i2);
            }
            editText.setTag(null);
        }
        AppMethodBeat.m2505o(116327);
    }

    public final C16051a dlT() {
        return this.vwM;
    }

    public final Context getContext() {
        AppMethodBeat.m2504i(139047);
        Context context = this.vwM.getContext();
        AppMethodBeat.m2505o(139047);
        return context;
    }

    public final C25785a getConfig() {
        return this.ccP;
    }

    public final <T extends C9268b> T dlU() {
        AppMethodBeat.m2504i(116330);
        if (this.vwU != null) {
            C9268b c9268b = this.vwU;
            AppMethodBeat.m2505o(116330);
            return c9268b;
        }
        C4990ab.m7412e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
        T t = C9268b.cjg;
        AppMethodBeat.m2505o(116330);
        return t;
    }

    /* renamed from: a */
    public final void mo33563a(C37464n c37464n, boolean z) {
        AppMethodBeat.m2504i(116333);
        C7305d.post(new C24665b(c37464n, z), "onFinalGenerate");
        AppMethodBeat.m2505o(116333);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(116334);
        Iterator it = this.vwO.iterator();
        while (it.hasNext()) {
            ((C9268b) it.next()).onDestroy();
        }
        this.vwO.clear();
        this.vwN.clear();
        AppMethodBeat.m2505o(116334);
    }

    public final void onAttachedToWindow() {
        AppMethodBeat.m2504i(116335);
        C4990ab.m7416i("MicroMsg.DrawingPresenter", "[onAttachedToWindow]");
        Iterator it = this.vwO.iterator();
        while (it.hasNext()) {
            boolean z;
            C9268b c9268b = (C9268b) it.next();
            ArtistCacheManager Jc = ArtistCacheManager.m28552Jc();
            C1493a CG = c9268b.mo4943CG();
            if (ArtistCacheManager.efj.containsKey(Jc.efl) && ((C18126a) ArtistCacheManager.efj.get(Jc.efl)).efo.containsKey(CG)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                c9268b.mo4955zC();
                c9268b.mo20700bk(true);
                C4990ab.m7417i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", c9268b.mo4943CG());
            }
        }
        if (this.vwM.getBaseBoardView().dMM()) {
            this.vwM.getBaseBoardView().dMN();
            this.vwM.getBaseBoardView().invalidate();
        }
        AppMethodBeat.m2505o(116335);
    }

    public final Bitmap dlV() {
        return this.vwQ;
    }

    public final boolean dlW() {
        AppMethodBeat.m2504i(116336);
        if (dlU().mo4943CG() == C1493a.CROP_PHOTO || !this.vwR) {
            AppMethodBeat.m2505o(116336);
            return false;
        }
        AppMethodBeat.m2505o(116336);
        return true;
    }

    /* renamed from: b */
    public final <T extends C9268b> T mo33566b(C32247e c32247e) {
        AppMethodBeat.m2504i(116337);
        C9268b c9268b = (C9268b) this.vwN.get(c32247e);
        AppMethodBeat.m2505o(116337);
        return c9268b;
    }

    /* renamed from: d */
    public final void mo33567d(C8955k c8955k) {
        AppMethodBeat.m2504i(116338);
        ((C32495e) mo33566b(C32247e.EMOJI)).mo53133b(c8955k);
        AppMethodBeat.m2505o(116338);
    }

    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(116340);
        Iterator it = this.vwO.iterator();
        while (it.hasNext()) {
            C9268b c9268b = (C9268b) it.next();
            if (c9268b.isAlive()) {
                if (dlU().mo4943CG() == c9268b.mo4943CG()) {
                    c9268b.onDraw(canvas);
                } else {
                    canvas.save();
                    canvas.clipRect(this.vwM.getBaseBoardView().getAliveRect());
                    c9268b.mo20698a(canvas);
                    canvas.restore();
                }
            }
        }
        AppMethodBeat.m2505o(116340);
    }

    /* renamed from: a */
    public final C18128d mo33561a(C1493a c1493a) {
        AppMethodBeat.m2504i(116341);
        C18128d a = ArtistCacheManager.m28552Jc().mo33607a(c1493a);
        AppMethodBeat.m2505o(116341);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dlX() {
        AppMethodBeat.m2504i(116342);
        this.vwO.clear();
        this.vwN.clear();
        this.vwN.put(C32247e.DEFAULT, C9268b.cjg);
        for (C32247e c32247e : this.vwM.getFeatures()) {
            Object obj = null;
            switch (c32247e) {
                case TEXT:
                case EMOJI:
                    int i;
                    Iterator it = this.vwO.iterator();
                    while (it.hasNext()) {
                        C9268b c9268b = (C9268b) it.next();
                        if (c9268b.mo4943CG() == C1493a.EMOJI_AND_TEXT) {
                            i = 1;
                            obj = c9268b;
                            if (i == 0) {
                                obj = new C32495e();
                                ((C32495e) obj).ckm = new C24663a();
                                break;
                            }
                        }
                    }
                    i = 0;
                    if (i == 0) {
                    }
                    break;
                case CROP_PHOTO:
                    obj = new C1497c();
                    break;
                case DOODLE:
                    obj = new C1505d();
                    break;
                case MOSAIC:
                    obj = new C32496f();
                    break;
            }
            if (obj != null) {
                if (!this.vwN.containsKey(c32247e)) {
                    this.vwN.put(c32247e, obj);
                }
                if (!this.vwO.contains(obj)) {
                    this.vwO.add(obj);
                    obj.mo4953a(this, this.vwM.getBaseBoardView().getMainMatrix(), this.vwM.getBaseBoardView().getAliveRect());
                }
            }
        }
        Collections.sort(this.vwO, new C13302());
        C4990ab.m7417i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", Integer.valueOf(this.vwN.size() - 1));
        AppMethodBeat.m2505o(116342);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: oW */
    public final void mo41541oW(boolean z) {
        AppMethodBeat.m2504i(116343);
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(this.vwM.getContext(), C25738R.anim.f8375cg);
            loadAnimation.setAnimationListener(new C181153());
            this.vwM.getTextEditView().startAnimation(loadAnimation);
            AppMethodBeat.m2505o(116343);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(this.vwM.getContext(), C25738R.anim.f8373ce);
        loadAnimation.setAnimationListener(new C246644());
        this.vwM.getTextEditView().startAnimation(loadAnimation);
        AppMethodBeat.m2505o(116343);
    }

    /* renamed from: Ab */
    public final boolean mo33559Ab() {
        AppMethodBeat.m2504i(116325);
        if (this.vwM.getTextEditView().getVisibility() == 0) {
            mo41541oW(false);
            this.vwM.setFooterVisible(true);
            AppMethodBeat.m2505o(116325);
            return true;
        } else if (this.vwM.getChatFooterPanel() == null || this.vwM.getChatFooterPanel().getVisibility() != 0) {
            AppMethodBeat.m2505o(116325);
            return false;
        } else {
            this.vwM.mo28431rj(true);
            this.vwM.setFooterVisible(true);
            AppMethodBeat.m2505o(116325);
            return true;
        }
    }

    public final void dlS() {
        AppMethodBeat.m2504i(116328);
        this.vwM.setFooterVisible(true);
        mo41541oW(false);
        AppMethodBeat.m2505o(116328);
    }

    public final float getInitScale() {
        AppMethodBeat.m2504i(116331);
        float initScale = this.vwM.getBaseBoardView().getInitScale();
        AppMethodBeat.m2505o(116331);
        return initScale;
    }

    public final float getCurScale() {
        AppMethodBeat.m2504i(116332);
        float curScale = this.vwM.getBaseBoardView().getCurScale();
        AppMethodBeat.m2505o(116332);
        return curScale;
    }

    /* renamed from: G */
    public final boolean mo33560G(MotionEvent motionEvent) {
        C9268b c9268b;
        boolean z;
        boolean z2 = false;
        AppMethodBeat.m2504i(116339);
        if (!(dlU().mo4943CG() == C1493a.CROP_PHOTO || dlU().mo4943CG() == C1493a.CROP_VIDEO)) {
            c9268b = null;
            if (this.vwN.containsKey(C32247e.TEXT)) {
                c9268b = (C9268b) this.vwN.get(C32247e.TEXT);
            } else if (this.vwN.containsKey(C32247e.EMOJI)) {
                c9268b = (C9268b) this.vwN.get(C32247e.EMOJI);
            }
            if (c9268b != null) {
                z2 = c9268b.mo4954o(motionEvent);
            }
            if (z2) {
                this.vwU = c9268b;
            }
        }
        if (!z2) {
            this.vwU = (C9268b) this.vwN.get(this.vwM.getBaseFooterView().getCurFeatureType());
            Iterator it = this.vwO.iterator();
            while (it.hasNext()) {
                c9268b = (C9268b) it.next();
                if (c9268b.mo4943CG() != C1493a.EMOJI_AND_TEXT && c9268b.mo4954o(motionEvent)) {
                    z = true;
                    break;
                }
            }
        }
        z = z2;
        AppMethodBeat.m2505o(116339);
        return z;
    }
}
