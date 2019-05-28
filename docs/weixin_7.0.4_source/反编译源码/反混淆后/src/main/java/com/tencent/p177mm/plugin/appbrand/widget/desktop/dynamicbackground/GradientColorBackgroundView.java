package com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0012\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\tJ\u001a\u0010\u001f\u001a\u00020\u00172\b\b\u0001\u0010\r\u001a\u00020\t2\b\b\u0001\u0010\u000e\u001a\u00020\tR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GradientColorBackgroundView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backGradient", "Landroid/graphics/LinearGradient;", "beginColor", "endColor", "mColorHelper", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundColorHelper;", "mLastUpdateColorTime", "", "paint", "Landroid/graphics/Paint;", "updateMode", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "resetGradient", "needInvalidate", "", "setUpdateMode", "updateColor", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GradientColorBackgroundView */
public final class GradientColorBackgroundView extends View {
    public static final C2551a jam = new C2551a();
    private Paint aFY = new Paint();
    private int beginColor = -5778734;
    private int cdh;
    private int endColor = -14072734;
    private LinearGradient jaj;
    private C27376a jak = new C27376a();
    private long jal = -1;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GradientColorBackgroundView$Companion;", "", "()V", "TAG", "", "UPDATE_COLOR_MIN_TWEENS_IN_MS", "", "UPDATE_MODE_ANDROID", "UPDATE_MODE_NATIVE", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GradientColorBackgroundView$a */
    public static final class C2551a {
        private C2551a() {
        }

        public /* synthetic */ C2551a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(135262);
        AppMethodBeat.m2505o(135262);
    }

    public GradientColorBackgroundView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attributeSet");
        super(context, attributeSet);
        AppMethodBeat.m2504i(135260);
        init();
        AppMethodBeat.m2505o(135260);
    }

    public GradientColorBackgroundView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attributeSet");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(135261);
        init();
        AppMethodBeat.m2505o(135261);
    }

    private final void init() {
        AppMethodBeat.m2504i(135256);
        this.cdh = 1;
        this.jak.aPy();
        this.beginColor = C27376a.m43454i(this.jak.aPx().iZb);
        this.endColor = C27376a.m43454i(this.jak.aPx().iZc);
        AppMethodBeat.m2505o(135256);
    }

    public final void setUpdateMode(int i) {
        AppMethodBeat.m2504i(135257);
        C4990ab.m7417i("MicroMsg.GradientColorBackgroundView", "alvinluo setUpdateMode: %d", Integer.valueOf(i));
        if (this.cdh != i) {
            this.cdh = i;
            this.jal = -1;
            this.jaj = null;
        }
        AppMethodBeat.m2505o(135257);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(135258);
        super.onDraw(canvas);
        if (this.cdh == 1) {
            if (this.jal == -1 || System.currentTimeMillis() - this.jal >= 60000) {
                this.jal = System.currentTimeMillis();
                this.jak.aPy();
                this.beginColor = C27376a.m43454i(this.jak.aPx().iZb);
                this.endColor = C27376a.m43454i(this.jak.aPx().iZc);
                m30729eX(false);
            }
        } else if (this.jaj == null) {
            m30729eX(true);
        }
        if (canvas != null) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.aFY);
            AppMethodBeat.m2505o(135258);
            return;
        }
        AppMethodBeat.m2505o(135258);
    }

    /* renamed from: eX */
    private final void m30729eX(boolean z) {
        AppMethodBeat.m2504i(135259);
        this.jaj = new LinearGradient(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.beginColor, this.endColor, TileMode.CLAMP);
        this.aFY.setShader(this.jaj);
        if (z) {
            invalidate();
        }
        AppMethodBeat.m2505o(135259);
    }
}
