package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.ttpic.util.VideoMaterialUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 a2\u00020\u00012\u00020\u0002:\u0001aB\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\n\u0010?\u001a\u0004\u0018\u00010@H\u0016J\n\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010C\u001a\u00020\u00122\b\u0010D\u001a\u0004\u0018\u00010=H\u0002J\n\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u0004\u0018\u000100J\u0006\u0010H\u001a\u00020\nJ\b\u0010I\u001a\u00020&H\u0016J\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0014J\u0010\u0010N\u001a\u00020&2\u0006\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020KH\u0016J\b\u0010R\u001a\u00020KH\u0002J\b\u0010S\u001a\u00020KH\u0002J\u0018\u0010T\u001a\u00020K2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\nH\u0002J\b\u0010W\u001a\u00020KH\u0016J\u0010\u0010X\u001a\u00020K2\u0006\u0010Y\u001a\u00020&H\u0016J\u0018\u0010Z\u001a\u00020K2\u0006\u0010[\u001a\u00020#2\u0006\u0010\\\u001a\u00020\u0017H\u0016J\b\u0010]\u001a\u00020KH\u0002J \u0010^\u001a\u00020K2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010_\u001a\u00020\n2\u0006\u0010`\u001a\u00020&R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0\u0011X\u000e¢\u0006\u0004\n\u0002\u0010>¨\u0006b"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "bitmapOffset", "Landroid/graphics/PointF;", "bottomMargin", "", "clipPath", "Landroid/graphics/Path;", "contentPadding", "drawingOffset", "fontPaths", "[Ljava/lang/String;", "framePadding", "framePaint", "Landroid/graphics/Paint;", "framePath", "framePathRect", "Landroid/graphics/RectF;", "frameStrokeWidth", "isClipping", "", "isEditing", "isEditingBeforeTouch", "isValid", "maxScale", "minScale", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "touchDownX", "touchDownY", "touchMoved", "touchSlop", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "typefaceIndex", "validRect", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "createTextBitmap", "typeface", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getText", "getTextColor", "handleRemove", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "preSetMatrix", "refresh", "resetFrame", "contentWidth", "contentHeight", "resume", "setEditing", "editing", "setValidArea", "bounds", "radius", "switchFont", "updateText", "color", "change", "Companion", "plugin-emojicapture_release"})
public final class TextEditorItemView extends View implements com.tencent.mm.plugin.emojicapture.c.c.b {
    public static final a loz = new a();
    private final String TAG;
    private float aJf;
    private float aJg;
    private boolean bYN;
    private final float eVg;
    private final float jgH;
    private final com.tencent.mm.media.editor.c.c lkf;
    private final Path lkh;
    private boolean lkj;
    private boolean lkk;
    private RectF lnL;
    private com.tencent.mm.plugin.emojicapture.ui.editor.a.c lod;
    private String[] lof;
    private Typeface[] loh;
    private int loi;
    private final Runnable loj;
    private final Paint lok;
    private final float lol;
    private final Path lom;
    private final RectF lon;
    private final int loo;
    private int lop;
    private final Bitmap[] loq;
    private final float lor;
    private boolean los;
    private float lot;
    private float lou;
    private boolean lov;
    private final float low;
    private final PointF lox;
    private final PointF loy;
    private int strokeColor;
    private CharSequence text;
    private int textColor;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView$Companion;", "", "()V", "ANIM_INTERVAL", "", "TEXT_COLOR_INVALID", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
    static final class c extends k implements a.f.a.b<Matrix, y> {
        final /* synthetic */ TextEditorItemView loA;

        c(TextEditorItemView textEditorItemView) {
            this.loA = textEditorItemView;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(3111);
            Matrix matrix = (Matrix) obj;
            j.p(matrix, "it");
            if (this.loA.bYN) {
                this.loA.lkf.aKk.set(matrix);
                this.loA.invalidate();
            }
            y yVar = y.AUy;
            AppMethodBeat.o(3111);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ TextEditorItemView loA;

        b(TextEditorItemView textEditorItemView) {
            this.loA = textEditorItemView;
        }

        public final void run() {
            AppMethodBeat.i(3110);
            EditorItemContainer itemContainer = this.loA.getItemContainer();
            if (itemContainer != null) {
                itemContainer.setEditing(this.loA);
                AppMethodBeat.o(3110);
                return;
            }
            AppMethodBeat.o(3110);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ TextEditorItemView loA;

        d(TextEditorItemView textEditorItemView) {
            this.loA = textEditorItemView;
        }

        public final void run() {
            AppMethodBeat.i(3112);
            TextEditorItemView.c(this.loA);
            AppMethodBeat.o(3112);
        }
    }

    static {
        AppMethodBeat.i(3129);
        AppMethodBeat.o(3129);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e7 A:{LOOP_END, LOOP:1: B:21:0x00e5->B:22:0x00e7} */
    /* JADX WARNING: Missing block: B:15:0x00cb, code skipped:
            if (r0.equals("zh_HK") != false) goto L_0x00cd;
     */
    /* JADX WARNING: Missing block: B:16:0x00cd, code skipped:
            r0 = 0;
     */
    /* JADX WARNING: Missing block: B:18:0x00d6, code skipped:
            if (r0.equals("zh_TW") != false) goto L_0x00cd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextEditorItemView(Context context, AttributeSet attributeSet, int i) {
        int i2;
        int length;
        Bitmap[] bitmapArr;
        ViewConfiguration viewConfiguration;
        super(context, attributeSet, i);
        AppMethodBeat.i(3128);
        this.TAG = "MicroMsg.TextEditorItemView";
        this.loj = new d(this);
        this.lok = new Paint(1);
        this.lom = new Path();
        this.lon = new RectF();
        this.lnL = new RectF();
        this.textColor = -1;
        this.strokeColor = -1;
        this.lox = new PointF();
        this.loy = new PointF();
        this.lkf = new com.tencent.mm.media.editor.c.c();
        this.lkh = new Path();
        this.aJf = 2.0f;
        this.aJg = 0.25f;
        if (context == null) {
            j.dWJ();
        }
        float dimension = context.getResources().getDimension(R.dimen.a01);
        if (com.tencent.mm.ao.b.afY().agb()) {
            com.tencent.mm.plugin.emojicapture.model.c.a aVar = com.tencent.mm.plugin.emojicapture.model.c.lhw;
            String dor = aa.dor();
            if (dor != null) {
                switch (dor.hashCode()) {
                    case 115861428:
                        break;
                    case 115861812:
                        break;
                }
            }
            i2 = 1;
            if (i2 != 0) {
                j.o(com.tencent.mm.ao.b.afY(), "FontResLogic.getInstance()");
                String[] agc = com.tencent.mm.ao.b.agc();
                j.o(agc, "FontResLogic.getInstance().fontPath");
                this.lof = agc;
                aVar = com.tencent.mm.plugin.emojicapture.model.c.lhw;
                this.lod = new com.tencent.mm.plugin.emojicapture.ui.editor.a.b(this.lof, (int) dimension);
                length = this.lof.length;
                Typeface[] typefaceArr = new Typeface[length];
                for (i2 = 0; i2 < length; i2++) {
                    typefaceArr[i2] = Typeface.createFromFile(this.lof[i2]);
                }
                this.loh = typefaceArr;
                this.loo = this.loh.length;
                length = this.loo;
                bitmapArr = new Bitmap[length];
                for (i2 = 0; i2 < length; i2++) {
                    bitmapArr[i2] = null;
                }
                this.loq = bitmapArr;
                boc();
                this.eVg = getResources().getDimension(R.dimen.zy);
                this.lol = getResources().getDimension(R.dimen.zz);
                this.lok.setColor(-1);
                this.lok.setStyle(Style.STROKE);
                this.lok.setStrokeWidth(this.lol);
                this.loy.set(this.eVg, this.eVg);
                this.low = getResources().getDimension(R.dimen.zx);
                this.lor = getResources().getDimension(R.dimen.a00);
                viewConfiguration = ViewConfiguration.get(context);
                j.o(viewConfiguration, "ViewConfiguration.get(context)");
                this.jgH = (float) viewConfiguration.getScaledTouchSlop();
                this.lkf.aJf = this.aJf;
                this.lkf.aJg = this.aJg;
                AppMethodBeat.o(3128);
            }
        }
        this.lof = new String[]{""};
        h.pYm.z(933, 3);
        this.lod = new com.tencent.mm.plugin.emojicapture.ui.editor.a.a();
        this.loh = new Typeface[]{null};
        this.loo = this.loh.length;
        length = this.loo;
        bitmapArr = new Bitmap[length];
        while (i2 < length) {
        }
        this.loq = bitmapArr;
        boc();
        this.eVg = getResources().getDimension(R.dimen.zy);
        this.lol = getResources().getDimension(R.dimen.zz);
        this.lok.setColor(-1);
        this.lok.setStyle(Style.STROKE);
        this.lok.setStrokeWidth(this.lol);
        this.loy.set(this.eVg, this.eVg);
        this.low = getResources().getDimension(R.dimen.zx);
        this.lor = getResources().getDimension(R.dimen.a00);
        viewConfiguration = ViewConfiguration.get(context);
        j.o(viewConfiguration, "ViewConfiguration.get(context)");
        this.jgH = (float) viewConfiguration.getScaledTouchSlop();
        this.lkf.aJf = this.aJf;
        this.lkf.aJg = this.aJg;
        AppMethodBeat.o(3128);
    }

    public static final /* synthetic */ void c(TextEditorItemView textEditorItemView) {
        AppMethodBeat.i(3130);
        textEditorItemView.boc();
        AppMethodBeat.o(3130);
    }

    public final com.tencent.mm.media.editor.a.a UJ() {
        return null;
    }

    public TextEditorItemView(Context context) {
        this(context, null);
    }

    public TextEditorItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void resume() {
        AppMethodBeat.i(3113);
        boc();
        AppMethodBeat.o(3113);
    }

    public final void pause() {
        AppMethodBeat.i(3114);
        removeCallbacks(this.loj);
        AppMethodBeat.o(3114);
    }

    public final void a(RectF rectF, float f) {
        AppMethodBeat.i(3115);
        j.p(rectF, "bounds");
        this.lnL.set(rectF);
        this.lkh.addRoundRect(new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom), f, f, Direction.CW);
        this.lox.set((rectF.left + (rectF.width() / 2.0f)) - (this.lon.width() / 2.0f), (rectF.bottom - this.low) - this.lon.height());
        bod();
        AppMethodBeat.o(3115);
    }

    public final void setEditing(boolean z) {
        AppMethodBeat.i(3116);
        this.lkj = z;
        postInvalidate();
        AppMethodBeat.o(3116);
    }

    public final boolean bob() {
        AppMethodBeat.i(3117);
        a("", 0, true);
        post(new b(this));
        AppMethodBeat.o(3117);
        return true;
    }

    public final CharSequence getText() {
        return this.bYN ? this.text : null;
    }

    public final void a(CharSequence charSequence, int i, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(3118);
        if (z) {
            boolean z3;
            this.text = charSequence;
            this.textColor = i;
            this.strokeColor = com.tencent.mm.plugin.emojicapture.ui.a.uB(this.textColor);
            if (charSequence == null || charSequence.length() == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                z2 = false;
            }
            this.bYN = z2;
            refresh();
        }
        AppMethodBeat.o(3118);
    }

    public final int getTextColor() {
        return this.bYN ? this.textColor : 0;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(3119);
        j.p(motionEvent, "event");
        boolean u = this.lkf.u(motionEvent);
        if (u) {
            postInvalidate();
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.los = this.lkj;
                    this.lov = false;
                    this.lot = motionEvent.getX();
                    this.lou = motionEvent.getY();
                    this.lkk = true;
                    break;
                case 1:
                case 3:
                    this.lkk = true;
                    if ((!this.bYN || this.los) && !this.lov) {
                        performClick();
                    }
                    com.tencent.mm.media.editor.c.a aVar = new com.tencent.mm.media.editor.c.a();
                    aVar.aJg = this.aJg;
                    aVar.aJf = this.aJf;
                    aVar.g(new float[]{this.lon.width() / 2.0f, this.lon.height() / 2.0f});
                    aVar.b(new RectF(this.lnL.left, this.lnL.top, this.lnL.right, this.lnL.bottom));
                    aVar.a(this.lkf.aKk, new c(this));
                    break;
                case 2:
                    this.lkk = false;
                    if (Math.abs(motionEvent.getX() - this.lot) > this.jgH || Math.abs(motionEvent.getY() - this.lou) > this.jgH) {
                        this.lov = true;
                        break;
                    }
                case 5:
                case 6:
                    if (!this.bYN) {
                        AppMethodBeat.o(3119);
                        return false;
                    }
                    break;
            }
            if (this.bYN) {
                EditorItemContainer itemContainer = getItemContainer();
                if (itemContainer != null) {
                    itemContainer.a((a) this, motionEvent);
                }
            } else {
                bod();
            }
            AppMethodBeat.o(3119);
            return u;
        }
        AppMethodBeat.o(3119);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(3120);
        j.p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        if (this.lkk) {
            canvas.clipPath(this.lkh);
        }
        canvas.save();
        canvas.concat(this.lkf.aKk);
        if (this.lkj) {
            canvas.drawPath(this.lom, this.lok);
        }
        Bitmap bitmap = this.loq[this.lop];
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.loy.x, this.loy.y, null);
        }
        canvas.restore();
        AppMethodBeat.o(3120);
    }

    private final void refresh() {
        AppMethodBeat.i(3121);
        a.a.h.K(this.loq);
        this.lop = 0;
        this.loi = 0;
        boc();
        AppMethodBeat.o(3121);
    }

    public final void boc() {
        AppMethodBeat.i(3122);
        Typeface typeface;
        Bitmap d;
        if (this.bYN) {
            this.lop++;
            this.lop %= this.loo;
            typeface = this.loh[this.loi];
            this.lod.Kd(this.lof[this.loi]);
            this.loi++;
            this.loi %= this.loh.length;
            if (this.loq[this.lop] == null) {
                d = d(typeface);
                this.loq[this.lop] = d;
                dX(d.getWidth(), d.getHeight());
            }
            removeCallbacks(this.loj);
            postDelayed(this.loj, 100);
        } else if (this.loq[this.lop] == null) {
            typeface = this.loh[0];
            this.lod.Kd(this.lof[this.loi]);
            d = d(typeface);
            this.loq[this.lop] = d;
            dX(d.getWidth(), d.getHeight());
        }
        invalidate();
        AppMethodBeat.o(3122);
    }

    private final void dX(int i, int i2) {
        AppMethodBeat.i(3123);
        float f = ((float) i) + (this.eVg * 2.0f);
        float f2 = ((float) i2) + (this.eVg * 2.0f);
        float width = this.lon.width();
        float height = this.lon.height();
        if (this.lon.isEmpty()) {
            this.lox.offset(f / 2.0f, -f2);
        } else {
            this.lox.offset((width - f) / 2.0f, (height - f2) / 2.0f);
        }
        this.lon.set(0.0f, 0.0f, f, f2);
        this.lom.reset();
        this.lom.addRoundRect(this.lon, this.eVg, this.eVg, Direction.CW);
        this.lkf.aKk.preTranslate((((float) this.lkf.width) - f) / 2.0f, ((float) this.lkf.height) - f2);
        if (!this.bYN) {
            bod();
        }
        this.lkf.width = (int) f;
        this.lkf.height = (int) f2;
        AppMethodBeat.o(3123);
    }

    private final void bod() {
        AppMethodBeat.i(3124);
        this.lkf.aKk.setTranslate(this.lox.x, this.lox.y);
        AppMethodBeat.o(3124);
    }

    private final Bitmap d(Typeface typeface) {
        AppMethodBeat.i(3125);
        FontTextView fontTextView = new FontTextView(getContext());
        fontTextView.setMaxWidth(this.lnL.width());
        fontTextView.setTextDrawer(this.lod);
        fontTextView.setTypeface(typeface);
        fontTextView.d(this.text, this.textColor, this.strokeColor);
        fontTextView.measure(MeasureSpec.makeMeasureSpec((int) (this.lnL.width() - (2.0f * this.lor)), android.support.v4.widget.j.INVALID_ID), 0);
        Bitmap createBitmap = Bitmap.createBitmap(fontTextView.getMeasuredWidth(), fontTextView.getMeasuredHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.save();
        fontTextView.draw(canvas);
        canvas.restore();
        j.o(createBitmap, "bitmap");
        AppMethodBeat.o(3125);
        return createBitmap;
    }

    public final EditorItemContainer getItemContainer() {
        AppMethodBeat.i(3126);
        ViewParent parent = getParent();
        j.o(parent, "parent");
        if (parent.getParent() instanceof EditorItemContainer) {
            parent = getParent();
            j.o(parent, "parent");
            parent = parent.getParent();
            if (parent == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
                AppMethodBeat.o(3126);
                throw vVar;
            }
            EditorItemContainer editorItemContainer = (EditorItemContainer) parent;
            AppMethodBeat.o(3126);
            return editorItemContainer;
        }
        AppMethodBeat.o(3126);
        return null;
    }

    public final com.tencent.mm.media.editor.a.b UI() {
        AppMethodBeat.i(3127);
        if (this.bYN) {
            Matrix matrix = new Matrix();
            matrix.postConcat(this.lkf.aKk);
            matrix.postTranslate(this.loy.x, this.loy.y);
            com.tencent.mm.media.editor.a.b cVar = new com.tencent.mm.media.editor.a.c(this.loq, matrix);
            AppMethodBeat.o(3127);
            return cVar;
        }
        AppMethodBeat.o(3127);
        return null;
    }
}
