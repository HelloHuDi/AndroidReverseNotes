package com.tencent.p177mm.p612ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.p057v4.widget.C8415j;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.KeyListener;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@SuppressLint({"ResourceAsColor"})
/* renamed from: com.tencent.mm.ui.base.NoMeasuredTextView */
public class NoMeasuredTextView extends View {
    private static final Metrics yAd = new Metrics();
    /* renamed from: Hu */
    private int f17246Hu;
    /* renamed from: dg */
    private int f17247dg;
    /* renamed from: di */
    private int f17248di;
    /* renamed from: lP */
    private ColorStateList f17249lP;
    private boolean mSingleLine;
    private CharSequence mText;
    /* renamed from: oz */
    private TextPaint f17250oz;
    private int yAa;
    private int yAb;
    private C40667c yAc;
    private String ysq;
    private int ysr;
    private int yss;
    private C40666a yzA;
    private KeyListener yzB;
    private Layout yzC;
    private float yzD;
    private float yzE;
    private int yzF;
    private int yzG;
    private int yzH;
    private int yzI;
    private boolean yzJ;
    private boolean yzK;
    private int yzL;
    private boolean yzM;
    private BoringLayout yzN;
    private boolean yzO;
    private int yzP;
    private FontMetricsInt yzQ;
    private boolean yzR;
    private boolean yzS;
    private C44271b yzT;
    private boolean yzU;
    public boolean yzV;
    private boolean yzW;
    private boolean yzX;
    private int yzY;
    private int yzZ;
    private int yzv;
    private Factory yzw;
    private Spannable.Factory yzx;
    private TruncateAt yzy;
    private CharSequence yzz;

    /* renamed from: com.tencent.mm.ui.base.NoMeasuredTextView$a */
    public enum C40666a {
        NORMAL,
        SPANNABLE,
        EDITABLE;

        static {
            AppMethodBeat.m2505o(107003);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.NoMeasuredTextView$c */
    public interface C40667c {
        /* renamed from: a */
        CharSequence mo28106a(NoMeasuredTextView noMeasuredTextView, CharSequence charSequence, String str, int i, int i2);
    }

    /* renamed from: com.tencent.mm.ui.base.NoMeasuredTextView$b */
    class C44271b {
        final Rect yAi = new Rect();
        Drawable yAj;
        Drawable yAk;
        Drawable yAl;
        Drawable yAm;
        int yAn;
        int yAo;
        int yAp;
        int yAq;
        int yAr;
        int yAs;
        int yAt;
        int yAu;
        int yAv;

        C44271b() {
            AppMethodBeat.m2504i(107004);
            AppMethodBeat.m2505o(107004);
        }
    }

    public void setDrawLeftDrawable(boolean z) {
        AppMethodBeat.m2504i(107005);
        if (this.yzU != z) {
            invalidate();
        }
        this.yzU = z;
        AppMethodBeat.m2505o(107005);
    }

    public void setDrawRightDrawable(boolean z) {
        AppMethodBeat.m2504i(107006);
        if (this.yzV != z) {
            invalidate();
        }
        this.yzV = z;
        AppMethodBeat.m2505o(107006);
    }

    public void setDrawTopDrawable(boolean z) {
        AppMethodBeat.m2504i(107007);
        if (this.yzW != z) {
            invalidate();
        }
        this.yzW = z;
        AppMethodBeat.m2505o(107007);
    }

    public void setDrawDownDrawable(boolean z) {
        AppMethodBeat.m2504i(107008);
        if (this.yzX != z) {
            invalidate();
        }
        this.yzX = z;
        AppMethodBeat.m2505o(107008);
    }

    static {
        AppMethodBeat.m2504i(107081);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.measureText("H");
        AppMethodBeat.m2505o(107081);
    }

    public void setShouldEllipsize(boolean z) {
        this.yzS = z;
    }

    public NoMeasuredTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107009);
        this.yzw = Factory.getInstance();
        this.yzx = Spannable.Factory.getInstance();
        this.yzy = null;
        this.yzA = C40666a.NORMAL;
        this.f17246Hu = 51;
        this.yzD = 1.0f;
        this.yzE = 0.0f;
        this.yzF = BaseClientBuilder.API_PRIORITY_OTHER;
        this.yzG = 1;
        this.yzH = 0;
        this.yzI = 1;
        this.f17248di = BaseClientBuilder.API_PRIORITY_OTHER;
        this.yzJ = false;
        this.f17247dg = 0;
        this.yzK = false;
        this.yzL = -1;
        this.yzM = true;
        this.yzO = false;
        this.yzR = false;
        this.yzS = false;
        this.yzU = false;
        this.yzV = false;
        this.yzW = false;
        this.yzX = false;
        this.yzY = -1;
        this.yzZ = -1;
        this.yAa = -1;
        this.yAb = -1;
        this.mText = "";
        this.yzz = "";
        this.f17250oz = new TextPaint(1);
        this.f17250oz.density = getResources().getDisplayMetrics().density;
        setDrawingCacheEnabled(false);
        this.yzQ = this.f17250oz.getFontMetricsInt();
        dAs();
        setSingleLine(true);
        setEllipsize(null);
        AppMethodBeat.m2505o(107009);
    }

    /* Access modifiers changed, original: protected */
    public boolean getDefaultEditable() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public MovementMethod getDefaultMovementMethod() {
        return null;
    }

    @CapturedViewProperty
    public CharSequence getText() {
        return this.mText;
    }

    public Editable getEditableText() {
        return this.mText instanceof Editable ? (Editable) this.mText : null;
    }

    public int getLineHeight() {
        AppMethodBeat.m2504i(107010);
        int round = Math.round((((float) this.f17250oz.getFontMetricsInt(null)) * this.yzD) + this.yzE);
        AppMethodBeat.m2505o(107010);
        return round;
    }

    public final Layout getLayout() {
        return this.yzC;
    }

    /* renamed from: a */
    private void m79946a(Drawable drawable, Drawable drawable2) {
        AppMethodBeat.m2504i(107011);
        C44271b c44271b = this.yzT;
        int i = (drawable == null && drawable2 == null) ? 0 : 1;
        if (i != 0) {
            if (c44271b == null) {
                c44271b = new C44271b();
                this.yzT = c44271b;
            }
            if (!(c44271b.yAl == drawable || c44271b.yAl == null)) {
                c44271b.yAl.setCallback(null);
            }
            c44271b.yAl = drawable;
            if (!(c44271b.yAj == null || c44271b.yAj == null)) {
                c44271b.yAj.setCallback(null);
            }
            c44271b.yAj = null;
            if (!(c44271b.yAm == drawable2 || c44271b.yAm == null)) {
                c44271b.yAm.setCallback(null);
            }
            c44271b.yAm = drawable2;
            if (!(c44271b.yAk == null || c44271b.yAk == null)) {
                c44271b.yAk.setCallback(null);
            }
            c44271b.yAk = null;
            Rect rect = c44271b.yAi;
            int[] drawableState = getDrawableState();
            if (drawable != null) {
                drawable.setState(drawableState);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                c44271b.yAp = rect.width();
                c44271b.yAt = rect.height();
            } else {
                c44271b.yAt = 0;
                c44271b.yAp = 0;
            }
            if (drawable2 != null) {
                drawable2.setState(drawableState);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                c44271b.yAq = rect.width();
                c44271b.yAu = rect.height();
                c44271b.yAr = 0;
                c44271b.yAn = 0;
                c44271b.yAs = 0;
                c44271b.yAo = 0;
            }
            c44271b.yAu = 0;
            c44271b.yAq = 0;
            c44271b.yAr = 0;
            c44271b.yAn = 0;
            c44271b.yAs = 0;
            c44271b.yAo = 0;
        } else if (c44271b != null) {
            if (c44271b.yAv == 0) {
                this.yzT = null;
            } else {
                if (c44271b.yAl != null) {
                    c44271b.yAl.setCallback(null);
                }
                c44271b.yAl = null;
                if (c44271b.yAj != null) {
                    c44271b.yAj.setCallback(null);
                }
                c44271b.yAj = null;
                if (c44271b.yAm != null) {
                    c44271b.yAm.setCallback(null);
                }
                c44271b.yAm = null;
                if (c44271b.yAk != null) {
                    c44271b.yAk.setCallback(null);
                }
                c44271b.yAk = null;
                c44271b.yAt = 0;
                c44271b.yAp = 0;
                c44271b.yAu = 0;
                c44271b.yAq = 0;
                c44271b.yAr = 0;
                c44271b.yAn = 0;
                c44271b.yAs = 0;
                c44271b.yAo = 0;
            }
        }
        invalidate();
        AppMethodBeat.m2505o(107011);
    }

    public void setCompoundLeftDrawablesWithIntrinsicBounds(Drawable drawable) {
        AppMethodBeat.m2504i(107012);
        if (drawable == null) {
            AppMethodBeat.m2505o(107012);
        } else if (this.yzT == null || this.yzT.yAl != drawable) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            m79946a(drawable, null);
            AppMethodBeat.m2505o(107012);
        } else {
            AppMethodBeat.m2505o(107012);
        }
    }

    public void setCompoundRightDrawablesWithIntrinsicBounds(Drawable drawable) {
        AppMethodBeat.m2504i(107013);
        if (drawable == null) {
            AppMethodBeat.m2505o(107013);
        } else if (this.yzT == null || this.yzT.yAm != drawable) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            m79946a(null, drawable);
            AppMethodBeat.m2505o(107013);
        } else {
            AppMethodBeat.m2505o(107013);
        }
    }

    public void setCompoundLeftDrawablesWithIntrinsicBounds(int i) {
        AppMethodBeat.m2504i(107014);
        if (i != this.yzY) {
            this.yzY = i;
            setCompoundLeftDrawablesWithIntrinsicBounds(getResources().getDrawable(i));
        }
        AppMethodBeat.m2505o(107014);
    }

    public void setCompoundRightDrawablesWithIntrinsicBounds(int i) {
        AppMethodBeat.m2504i(107015);
        if (i != this.yzZ) {
            this.yzZ = i;
            setCompoundRightDrawablesWithIntrinsicBounds(getResources().getDrawable(i));
        }
        AppMethodBeat.m2505o(107015);
    }

    public Drawable[] getCompoundDrawables() {
        if (this.yzT != null) {
            return new Drawable[]{this.yzT.yAl, this.yzT.yAj, this.yzT.yAm, this.yzT.yAk};
        }
        return new Drawable[]{null, null, null, null};
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        AppMethodBeat.m2504i(107016);
        super.drawableStateChanged();
        if (this.f17249lP != null && this.f17249lP.isStateful()) {
            updateTextColors();
        }
        C44271b c44271b = this.yzT;
        if (c44271b != null) {
            int[] drawableState = getDrawableState();
            if (c44271b.yAj != null && c44271b.yAj.isStateful()) {
                c44271b.yAj.setState(drawableState);
            }
            if (c44271b.yAk != null && c44271b.yAk.isStateful()) {
                c44271b.yAk.setState(drawableState);
            }
            if (c44271b.yAl != null && c44271b.yAl.isStateful()) {
                c44271b.yAl.setState(drawableState);
            }
            if (c44271b.yAm != null && c44271b.yAm.isStateful()) {
                c44271b.yAm.setState(drawableState);
            }
        }
        AppMethodBeat.m2505o(107016);
    }

    /* Access modifiers changed, original: protected */
    public boolean verifyDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(107017);
        boolean verifyDrawable = super.verifyDrawable(drawable);
        if (verifyDrawable || this.yzT == null) {
            AppMethodBeat.m2505o(107017);
            return verifyDrawable;
        } else if (drawable == this.yzT.yAl || drawable == this.yzT.yAj || drawable == this.yzT.yAm || drawable == this.yzT.yAk) {
            AppMethodBeat.m2505o(107017);
            return true;
        } else {
            AppMethodBeat.m2505o(107017);
            return false;
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(107018);
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            C44271b c44271b = this.yzT;
            if (c44271b != null) {
                int compoundPaddingTop;
                if (drawable == c44271b.yAl) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    scrollX += getPaddingLeft();
                    scrollY += (((((getBottom() - getTop()) - getCompoundPaddingBottom()) - compoundPaddingTop) - c44271b.yAt) / 2) + compoundPaddingTop;
                } else if (drawable == c44271b.yAm) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    scrollX += ((getRight() - getLeft()) - getPaddingRight()) - c44271b.yAq;
                    scrollY += (((((getBottom() - getTop()) - getCompoundPaddingBottom()) - compoundPaddingTop) - c44271b.yAu) / 2) + compoundPaddingTop;
                } else if (drawable == c44271b.yAj) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    scrollX += (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingTop) - c44271b.yAr) / 2) + compoundPaddingTop;
                    scrollY += getPaddingTop();
                } else if (drawable == c44271b.yAk) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    scrollX += compoundPaddingTop + (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingTop) - c44271b.yAs) / 2);
                    scrollY += ((getBottom() - getTop()) - getPaddingBottom()) - c44271b.yAo;
                }
            }
            invalidate(bounds.left + scrollX, bounds.top + scrollY, scrollX + bounds.right, scrollY + bounds.bottom);
        }
        AppMethodBeat.m2505o(107018);
    }

    /* JADX WARNING: Missing block: B:2:0x000a, code skipped:
            if (r0 != null) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCompoundDrawablePadding(int i) {
        AppMethodBeat.m2504i(107019);
        C44271b c44271b = this.yzT;
        if (i != 0) {
            if (c44271b == null) {
                c44271b = new C44271b();
                this.yzT = c44271b;
            }
        }
        c44271b.yAv = i;
        invalidate();
        requestLayout();
        AppMethodBeat.m2505o(107019);
    }

    public int getCompoundDrawablePadding() {
        C44271b c44271b = this.yzT;
        return c44271b != null ? c44271b.yAv : 0;
    }

    public int getCompoundPaddingTop() {
        AppMethodBeat.m2504i(107020);
        C44271b c44271b = this.yzT;
        int paddingTop;
        if (c44271b == null || c44271b.yAj == null || !this.yzW) {
            paddingTop = getPaddingTop();
            AppMethodBeat.m2505o(107020);
            return paddingTop;
        }
        paddingTop = c44271b.yAn + (getPaddingTop() + c44271b.yAv);
        AppMethodBeat.m2505o(107020);
        return paddingTop;
    }

    public int getCompoundPaddingBottom() {
        AppMethodBeat.m2504i(107021);
        C44271b c44271b = this.yzT;
        int paddingBottom;
        if (c44271b == null || c44271b.yAk == null || !this.yzX) {
            paddingBottom = getPaddingBottom();
            AppMethodBeat.m2505o(107021);
            return paddingBottom;
        }
        paddingBottom = c44271b.yAo + (getPaddingBottom() + c44271b.yAv);
        AppMethodBeat.m2505o(107021);
        return paddingBottom;
    }

    public int getCompoundPaddingLeft() {
        AppMethodBeat.m2504i(107022);
        C44271b c44271b = this.yzT;
        int paddingLeft;
        if (c44271b == null || c44271b.yAl == null || !this.yzU) {
            paddingLeft = getPaddingLeft();
            AppMethodBeat.m2505o(107022);
            return paddingLeft;
        }
        paddingLeft = c44271b.yAp + (getPaddingLeft() + c44271b.yAv);
        AppMethodBeat.m2505o(107022);
        return paddingLeft;
    }

    public int getCompoundPaddingRight() {
        AppMethodBeat.m2504i(107023);
        C44271b c44271b = this.yzT;
        int paddingRight;
        if (c44271b == null || c44271b.yAm == null || !this.yzV) {
            paddingRight = getPaddingRight();
            AppMethodBeat.m2505o(107023);
            return paddingRight;
        }
        paddingRight = c44271b.yAq + (getPaddingRight() + c44271b.yAv);
        AppMethodBeat.m2505o(107023);
        return paddingRight;
    }

    public int getExtendedPaddingTop() {
        AppMethodBeat.m2504i(107024);
        int compoundPaddingTop;
        if (this.yzC == null || this.yzG != 1) {
            compoundPaddingTop = getCompoundPaddingTop();
            AppMethodBeat.m2505o(107024);
            return compoundPaddingTop;
        } else if (this.yzC.getLineCount() <= this.yzF) {
            compoundPaddingTop = getCompoundPaddingTop();
            AppMethodBeat.m2505o(107024);
            return compoundPaddingTop;
        } else {
            compoundPaddingTop = getCompoundPaddingTop();
            int height = (getHeight() - compoundPaddingTop) - getCompoundPaddingBottom();
            int lineTop = this.yzC.getLineTop(this.yzF);
            if (lineTop >= height) {
                AppMethodBeat.m2505o(107024);
                return compoundPaddingTop;
            }
            int i = this.f17246Hu & 112;
            if (i == 48) {
                AppMethodBeat.m2505o(107024);
                return compoundPaddingTop;
            } else if (i == 80) {
                compoundPaddingTop = (compoundPaddingTop + height) - lineTop;
                AppMethodBeat.m2505o(107024);
                return compoundPaddingTop;
            } else {
                compoundPaddingTop += (height - lineTop) / 2;
                AppMethodBeat.m2505o(107024);
                return compoundPaddingTop;
            }
        }
    }

    public int getExtendedPaddingBottom() {
        AppMethodBeat.m2504i(107025);
        int compoundPaddingBottom;
        if (this.yzC == null || this.yzG != 1) {
            compoundPaddingBottom = getCompoundPaddingBottom();
            AppMethodBeat.m2505o(107025);
            return compoundPaddingBottom;
        } else if (this.yzC.getLineCount() <= this.yzF) {
            compoundPaddingBottom = getCompoundPaddingBottom();
            AppMethodBeat.m2505o(107025);
            return compoundPaddingBottom;
        } else {
            int compoundPaddingTop = getCompoundPaddingTop();
            compoundPaddingBottom = getCompoundPaddingBottom();
            compoundPaddingTop = (getHeight() - compoundPaddingTop) - compoundPaddingBottom;
            int lineTop = this.yzC.getLineTop(this.yzF);
            if (lineTop >= compoundPaddingTop) {
                AppMethodBeat.m2505o(107025);
                return compoundPaddingBottom;
            }
            int i = this.f17246Hu & 112;
            if (i == 48) {
                compoundPaddingBottom = (compoundPaddingBottom + compoundPaddingTop) - lineTop;
                AppMethodBeat.m2505o(107025);
                return compoundPaddingBottom;
            } else if (i == 80) {
                AppMethodBeat.m2505o(107025);
                return compoundPaddingBottom;
            } else {
                compoundPaddingBottom += (compoundPaddingTop - lineTop) / 2;
                AppMethodBeat.m2505o(107025);
                return compoundPaddingBottom;
            }
        }
    }

    public int getTotalPaddingLeft() {
        AppMethodBeat.m2504i(107026);
        int compoundPaddingLeft = getCompoundPaddingLeft();
        AppMethodBeat.m2505o(107026);
        return compoundPaddingLeft;
    }

    public int getTotalPaddingRight() {
        AppMethodBeat.m2504i(107027);
        int compoundPaddingRight = getCompoundPaddingRight();
        AppMethodBeat.m2505o(107027);
        return compoundPaddingRight;
    }

    public int getTotalPaddingTop() {
        AppMethodBeat.m2504i(107028);
        int extendedPaddingTop = getExtendedPaddingTop() + getVerticalOffset$1385f2();
        AppMethodBeat.m2505o(107028);
        return extendedPaddingTop;
    }

    public int getTotalPaddingBottom() {
        AppMethodBeat.m2504i(107029);
        int extendedPaddingBottom = getExtendedPaddingBottom();
        int i = 0;
        int i2 = this.f17246Hu & 112;
        Layout layout = this.yzC;
        if (i2 != 80) {
            int measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
            int height = layout.getHeight();
            if (height < measuredHeight) {
                i = i2 == 48 ? measuredHeight - height : (measuredHeight - height) >> 1;
            }
        }
        i += extendedPaddingBottom;
        AppMethodBeat.m2505o(107029);
        return i;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(107030);
        if (!(i == getPaddingLeft() && i3 == getPaddingRight() && i2 == getPaddingTop() && i4 == getPaddingBottom())) {
            dAq();
        }
        super.setPadding(i, i2, i3, i4);
        invalidate();
        AppMethodBeat.m2505o(107030);
    }

    public float getTextSize() {
        AppMethodBeat.m2504i(107031);
        float textSize = this.f17250oz.getTextSize();
        AppMethodBeat.m2505o(107031);
        return textSize;
    }

    public void setTextSize(float f) {
        AppMethodBeat.m2504i(107032);
        setTextSize(2, f);
        AppMethodBeat.m2505o(107032);
    }

    public final void setTextSize(int i, float f) {
        Resources system;
        AppMethodBeat.m2504i(107033);
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        AppMethodBeat.m2505o(107033);
    }

    private void setRawTextSize(float f) {
        AppMethodBeat.m2504i(107034);
        if (f != this.f17250oz.getTextSize()) {
            this.f17250oz.setTextSize(f);
            this.yzQ = this.f17250oz.getFontMetricsInt();
            this.yzP = (int) (Math.ceil((double) (this.yzQ.descent - this.yzQ.ascent)) + 2.0d);
            if (this.yzC != null) {
                dAq();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.m2505o(107034);
    }

    public float getTextScaleX() {
        AppMethodBeat.m2504i(107035);
        float textScaleX = this.f17250oz.getTextScaleX();
        AppMethodBeat.m2505o(107035);
        return textScaleX;
    }

    public void setTypeface(Typeface typeface) {
        AppMethodBeat.m2504i(107036);
        if (this.f17250oz.getTypeface() != typeface) {
            this.f17250oz.setTypeface(typeface);
            if (this.yzC != null) {
                dAq();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.m2505o(107036);
    }

    public Typeface getTypeface() {
        AppMethodBeat.m2504i(107037);
        Typeface typeface = this.f17250oz.getTypeface();
        AppMethodBeat.m2505o(107037);
        return typeface;
    }

    public void setTextColor(int i) {
        AppMethodBeat.m2504i(107038);
        this.f17249lP = ColorStateList.valueOf(i);
        updateTextColors();
        AppMethodBeat.m2505o(107038);
    }

    public void setTextColor(ColorStateList colorStateList) {
        AppMethodBeat.m2504i(107039);
        if (colorStateList == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(107039);
            throw nullPointerException;
        } else if (this.f17249lP == colorStateList) {
            AppMethodBeat.m2505o(107039);
        } else {
            this.f17249lP = colorStateList;
            updateTextColors();
            AppMethodBeat.m2505o(107039);
        }
    }

    public final ColorStateList getTextColors() {
        return this.f17249lP;
    }

    public final int getCurrentTextColor() {
        return this.yzv;
    }

    public TextPaint getPaint() {
        return this.f17250oz;
    }

    public void setGravity(int i) {
        int i2;
        AppMethodBeat.m2504i(107040);
        if ((i & 7) == 0) {
            i2 = i | 3;
        } else {
            i2 = i;
        }
        if ((i2 & 112) == 0) {
            i2 |= 48;
        }
        Object obj = null;
        if ((i2 & 7) != (this.f17246Hu & 7)) {
            obj = 1;
        }
        if (i2 != this.f17246Hu) {
            invalidate();
        }
        this.f17246Hu = i2;
        if (!(this.yzC == null || obj == null)) {
            m79948hl(this.yzC.getWidth(), (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight());
        }
        AppMethodBeat.m2505o(107040);
    }

    public int getGravity() {
        return this.f17246Hu;
    }

    public int getPaintFlags() {
        AppMethodBeat.m2504i(107041);
        int flags = this.f17250oz.getFlags();
        AppMethodBeat.m2505o(107041);
        return flags;
    }

    public void setPaintFlags(int i) {
        AppMethodBeat.m2504i(107042);
        if (this.f17250oz.getFlags() != i) {
            this.f17250oz.setFlags(i);
            if (this.yzC != null) {
                dAq();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.m2505o(107042);
    }

    public void setMinLines(int i) {
        AppMethodBeat.m2504i(107043);
        this.yzH = i;
        this.yzI = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(107043);
    }

    public void setMinHeight(int i) {
        AppMethodBeat.m2504i(107044);
        this.yzH = i;
        this.yzI = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(107044);
    }

    public void setMaxLines(int i) {
        AppMethodBeat.m2504i(107045);
        this.yzF = i;
        this.yzG = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(107045);
    }

    public void setMaxHeight(int i) {
        AppMethodBeat.m2504i(107046);
        this.yzF = i;
        this.yzG = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(107046);
    }

    public void setLines(int i) {
        AppMethodBeat.m2504i(107047);
        this.yzH = i;
        this.yzF = i;
        this.yzI = 1;
        this.yzG = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(107047);
    }

    public void setHeight(int i) {
        AppMethodBeat.m2504i(107048);
        this.yzH = i;
        this.yzF = i;
        this.yzI = 2;
        this.yzG = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(107048);
    }

    public void setMinWidth(int i) {
        AppMethodBeat.m2504i(107049);
        this.f17247dg = i;
        this.yzK = true;
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(107049);
    }

    public void setMaxWidth(int i) {
        AppMethodBeat.m2504i(107050);
        this.f17248di = i;
        this.yzJ = true;
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(107050);
    }

    public void setWidth(int i) {
        AppMethodBeat.m2504i(107051);
        this.f17247dg = i;
        this.f17248di = i;
        this.yzK = true;
        this.yzJ = true;
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(107051);
    }

    private void updateTextColors() {
        int i = 0;
        AppMethodBeat.m2504i(107052);
        int colorForState = this.f17249lP.getColorForState(getDrawableState(), 0);
        if (colorForState != this.yzv) {
            this.yzv = colorForState;
            i = 1;
        }
        if (i != 0) {
            invalidate();
        }
        AppMethodBeat.m2505o(107052);
    }

    public final void setEditableFactory(Factory factory) {
        AppMethodBeat.m2504i(107053);
        this.yzw = factory;
        setText(this.mText);
        AppMethodBeat.m2505o(107053);
    }

    public final void setSpannableFactory(Spannable.Factory factory) {
        AppMethodBeat.m2504i(107054);
        this.yzx = factory;
        setText(this.mText);
        AppMethodBeat.m2505o(107054);
    }

    public final void setText(CharSequence charSequence) {
        AppMethodBeat.m2504i(107055);
        m79947a(charSequence, this.yzA);
        AppMethodBeat.m2505o(107055);
    }

    public final void setTextKeepState(CharSequence charSequence) {
        AppMethodBeat.m2504i(107056);
        C40666a c40666a = this.yzA;
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        int length = charSequence.length();
        m79947a(charSequence, c40666a);
        if ((selectionStart >= 0 || selectionEnd >= 0) && (this.mText instanceof Spannable)) {
            Selection.setSelection((Spannable) this.mText, Math.max(0, Math.min(selectionStart, length)), Math.max(0, Math.min(selectionEnd, length)));
        }
        AppMethodBeat.m2505o(107056);
    }

    /* renamed from: a */
    private void m79947a(CharSequence charSequence, C40666a c40666a) {
        CharSequence charSequence2;
        AppMethodBeat.m2504i(107057);
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence;
        }
        if (charSequence2.equals(this.mText)) {
            AppMethodBeat.m2505o(107057);
            return;
        }
        if (!(getMeasuredWidth() <= 0 || this.yAc == null || C5046bo.isNullOrNil(this.ysq))) {
            charSequence2 = this.yAc.mo28106a(this, charSequence2, this.ysq, this.ysr, this.yss);
            this.ysq = null;
        }
        if (charSequence2 instanceof Spanned) {
            this.yzO = false;
        } else {
            this.yzO = true;
        }
        if (c40666a == C40666a.EDITABLE || this.yzB != null) {
            charSequence2 = this.yzw.newEditable(charSequence2);
        } else if (c40666a == C40666a.SPANNABLE) {
            charSequence2 = this.yzx.newSpannable(charSequence2);
        }
        int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
        if (this.yzS) {
            if (this.yzJ) {
                int i = this.f17248di;
                if (getMeasuredWidth() > 0) {
                    i = Math.min(this.f17248di, getMeasuredWidth());
                }
                charSequence2 = TextUtils.ellipsize(charSequence2, this.f17250oz, (float) (i - compoundPaddingLeft), TruncateAt.END);
            } else if (getMeasuredWidth() > 0) {
                charSequence2 = TextUtils.ellipsize(charSequence2, this.f17250oz, (float) (getMeasuredWidth() - compoundPaddingLeft), TruncateAt.END);
            } else {
                this.yzR = true;
            }
        }
        this.yzA = c40666a;
        this.mText = charSequence2;
        this.yzz = charSequence2;
        m79945NK(compoundPaddingLeft);
        AppMethodBeat.m2505o(107057);
    }

    /* renamed from: au */
    public final void mo69968au(String str, int i, int i2) {
        this.ysq = str;
        this.ysr = i;
        this.yss = i2;
    }

    public void setLayoutCallback(C40667c c40667c) {
        this.yAc = c40667c;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(107058);
        super.onLayout(z, i, i2, i3, i4);
        if (this.yzR && getMeasuredWidth() > 0) {
            if (C5046bo.isNullOrNil(this.ysq) || this.yAc == null) {
                setText(TextUtils.ellipsize(this.mText, getPaint(), (float) ((getMeasuredWidth() - getCompoundPaddingRight()) - getCompoundPaddingLeft()), TruncateAt.END));
            } else {
                CharSequence a = this.yAc.mo28106a(this, this.mText, this.ysq, this.ysr, this.yss);
                this.ysq = null;
                setText(a);
            }
            this.yzR = false;
        }
        AppMethodBeat.m2505o(107058);
    }

    public final void setText(int i) {
        AppMethodBeat.m2504i(107059);
        setText(getContext().getResources().getText(i));
        AppMethodBeat.m2505o(107059);
    }

    private int getVerticalOffset$1385f2() {
        AppMethodBeat.m2504i(107060);
        int i = 0;
        int i2 = this.f17246Hu & 112;
        Layout layout = this.yzC;
        if (i2 != 48) {
            int measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
            int height = layout.getHeight();
            if (height < measuredHeight) {
                i = i2 == 80 ? measuredHeight - height : (measuredHeight - height) >> 1;
            }
        }
        AppMethodBeat.m2505o(107060);
        return i;
    }

    private int getBottomVerticalOffset$1385f2() {
        AppMethodBeat.m2504i(139074);
        int i = 0;
        int i2 = this.f17246Hu & 112;
        Layout layout = this.yzC;
        if (i2 != 80) {
            int measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
            int height = layout.getHeight();
            if (height < measuredHeight) {
                i = i2 == 48 ? measuredHeight - height : (measuredHeight - height) >> 1;
            }
        }
        AppMethodBeat.m2505o(139074);
        return i;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(107062);
        super.onDraw(canvas);
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingRight = getCompoundPaddingRight();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int right = getRight();
        int left = getLeft();
        int bottom = getBottom();
        int top = getTop();
        int width = getWidth();
        int height = getHeight();
        C44271b c44271b = this.yzT;
        float f = -1.0f;
        if (c44271b != null) {
            int i = ((bottom - top) - compoundPaddingBottom) - compoundPaddingTop;
            int i2 = ((right - left) - compoundPaddingRight) - compoundPaddingLeft;
            if (this.yzU && c44271b.yAl != null) {
                canvas.save();
                canvas.translate((float) (getPaddingLeft() + scrollX), (float) ((scrollY + compoundPaddingTop) + ((i - c44271b.yAt) / 2)));
                c44271b.yAl.draw(canvas);
                canvas.restore();
            }
            if (this.yzV && c44271b.yAm != null) {
                float f2;
                float f3;
                canvas.save();
                if (this.yzO) {
                    f = this.f17250oz.measureText(this.mText, 0, this.mText.length());
                    f2 = f;
                    f3 = f;
                } else {
                    f2 = (float) Math.ceil((double) Layout.getDesiredWidth(this.yzz, this.f17250oz));
                    f3 = -1.0f;
                }
                canvas.translate((f2 + ((float) scrollX)) - ((float) getPaddingRight()), (float) ((scrollY + compoundPaddingTop) + ((i - c44271b.yAu) / 2)));
                c44271b.yAm.draw(canvas);
                canvas.restore();
                f = f3;
            }
            if (this.yzW && c44271b.yAj != null) {
                canvas.save();
                canvas.translate((float) ((scrollX + compoundPaddingLeft) + ((i2 - c44271b.yAr) / 2)), (float) (getPaddingTop() + scrollY));
                c44271b.yAj.draw(canvas);
                canvas.restore();
            }
            if (this.yzX && c44271b.yAk != null) {
                canvas.save();
                canvas.translate((float) ((scrollX + compoundPaddingLeft) + ((i2 - c44271b.yAs) / 2)), (float) ((((scrollY + bottom) - top) - getPaddingBottom()) - c44271b.yAo));
                c44271b.yAk.draw(canvas);
                canvas.restore();
            }
        }
        this.f17250oz.setColor(this.yzv);
        this.f17250oz.drawableState = getDrawableState();
        canvas.save();
        compoundPaddingTop = getExtendedPaddingTop();
        Canvas canvas2 = canvas;
        float f4 = (float) (compoundPaddingTop + scrollY);
        canvas2.clipRect((float) (compoundPaddingLeft + scrollX), f4, (float) (((right - left) - compoundPaddingRight) + scrollX), (float) (((bottom - top) - getExtendedPaddingBottom()) + scrollY));
        int i3 = 0;
        compoundPaddingBottom = 0;
        if ((this.f17246Hu & 112) != 48) {
            i3 = getVerticalOffset$1385f2();
            compoundPaddingBottom = getVerticalOffset$1385f2();
        }
        canvas.translate((float) compoundPaddingLeft, (float) (compoundPaddingTop + i3));
        if (this.yzO) {
            float f5 = (float) (((height - (this.yzQ.bottom - this.yzQ.top)) / 2) - this.yzQ.top);
            compoundPaddingBottom = 0;
            if ((this.f17246Hu & 7) != 3) {
                switch (this.f17246Hu & 7) {
                    case 1:
                        if (f == -1.0f) {
                            f = this.f17250oz.measureText(this.mText, 0, this.mText.length());
                        }
                        compoundPaddingBottom = ((int) (((float) (width - getPaddingRight())) - f)) / 2;
                        break;
                    case 5:
                        if (f == -1.0f) {
                            f = this.f17250oz.measureText(this.mText, 0, this.mText.length());
                        }
                        compoundPaddingBottom = (int) (((float) (width - getPaddingRight())) - f);
                        break;
                }
            }
            canvas.drawText(this.mText, 0, this.mText.length(), (float) compoundPaddingBottom, f5, this.f17250oz);
        } else {
            if (this.yzC == null) {
                dAr();
            }
            this.yzC.draw(canvas, null, null, compoundPaddingBottom - i3);
        }
        canvas.restore();
        AppMethodBeat.m2505o(107062);
    }

    public void getFocusedRect(Rect rect) {
        AppMethodBeat.m2504i(107063);
        if (this.yzC == null) {
            super.getFocusedRect(rect);
            AppMethodBeat.m2505o(107063);
            return;
        }
        int selectionEnd = getSelectionEnd();
        if (selectionEnd < 0) {
            super.getFocusedRect(rect);
            AppMethodBeat.m2505o(107063);
            return;
        }
        int lineForOffset = this.yzC.getLineForOffset(selectionEnd);
        rect.top = this.yzC.getLineTop(lineForOffset);
        rect.bottom = this.yzC.getLineBottom(lineForOffset);
        rect.left = (int) this.yzC.getPrimaryHorizontal(selectionEnd);
        rect.right = rect.left + 1;
        lineForOffset = getCompoundPaddingLeft();
        selectionEnd = getExtendedPaddingTop();
        if ((this.f17246Hu & 112) != 48) {
            selectionEnd += getVerticalOffset$1385f2();
        }
        rect.offset(lineForOffset, selectionEnd);
        AppMethodBeat.m2505o(107063);
    }

    public int getLineCount() {
        AppMethodBeat.m2504i(107064);
        if (this.yzC != null) {
            int lineCount = this.yzC.getLineCount();
            AppMethodBeat.m2505o(107064);
            return lineCount;
        }
        AppMethodBeat.m2505o(107064);
        return 0;
    }

    public int getBaseline() {
        AppMethodBeat.m2504i(107065);
        int baseline;
        if (this.yzC == null) {
            baseline = super.getBaseline();
            AppMethodBeat.m2505o(107065);
            return baseline;
        }
        if ((this.f17246Hu & 112) != 48) {
            baseline = getVerticalOffset$1385f2();
        } else {
            baseline = 0;
        }
        baseline = (baseline + getExtendedPaddingTop()) + this.yzC.getLineBaseline(0);
        AppMethodBeat.m2505o(107065);
        return baseline;
    }

    private void dAq() {
        if ((this.yzC instanceof BoringLayout) && this.yzN == null) {
            this.yzN = (BoringLayout) this.yzC;
        }
        this.yzC = null;
    }

    private void dAr() {
        int compoundPaddingLeft;
        AppMethodBeat.m2504i(107066);
        if (this.yzJ) {
            compoundPaddingLeft = (this.f17248di - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        } else {
            compoundPaddingLeft = ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        }
        if (compoundPaddingLeft <= 0) {
            compoundPaddingLeft = 0;
        }
        m79948hl(compoundPaddingLeft, compoundPaddingLeft);
        AppMethodBeat.m2505o(107066);
    }

    /* renamed from: hl */
    private void m79948hl(int i, int i2) {
        int i3;
        Alignment alignment;
        int i4;
        AppMethodBeat.m2504i(107067);
        if (i < 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        switch (this.f17246Hu & 7) {
            case 1:
                alignment = Alignment.ALIGN_CENTER;
                break;
            case 5:
                alignment = Alignment.ALIGN_OPPOSITE;
                break;
            default:
                alignment = Alignment.ALIGN_NORMAL;
                break;
        }
        if (this.yzy == null || this.yzB != null) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        if (i4 != 0) {
            this.yzC = new StaticLayout(this.yzz, 0, this.yzz.length(), this.f17250oz, i3, alignment, this.yzD, this.yzE, this.yzM, this.yzy, i2);
            AppMethodBeat.m2505o(107067);
            return;
        }
        this.yzC = new StaticLayout(this.yzz, this.f17250oz, i3, alignment, this.yzD, this.yzE, this.yzM);
        AppMethodBeat.m2505o(107067);
    }

    public void setIncludeFontPadding(boolean z) {
        AppMethodBeat.m2504i(107068);
        this.yzM = z;
        if (this.yzC != null) {
            dAq();
            requestLayout();
            invalidate();
        }
        AppMethodBeat.m2505o(107068);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(107069);
        MeasureSpec.getMode(i);
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (size == 0) {
            setMeasuredDimension(size, this.yzP);
            AppMethodBeat.m2505o(107069);
        } else if (this.yzO) {
            if (this.yzP == 0) {
                dAs();
            }
            setMeasuredDimension(size, this.yzP);
            AppMethodBeat.m2505o(107069);
        } else {
            int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.yzJ) {
                compoundPaddingLeft = this.f17248di - compoundPaddingLeft;
            } else {
                compoundPaddingLeft = size - compoundPaddingLeft;
            }
            if (this.yzC == null) {
                m79948hl(compoundPaddingLeft, compoundPaddingLeft);
            } else {
                int i3;
                if (this.yzC.getWidth() != compoundPaddingLeft) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    m79948hl(compoundPaddingLeft, compoundPaddingLeft);
                }
            }
            if (mode == ErrorDialogData.SUPPRESSED) {
                this.yzL = -1;
                compoundPaddingLeft = size2;
            } else {
                compoundPaddingLeft = getDesiredHeight();
                this.yzL = compoundPaddingLeft;
                if (mode == C8415j.INVALID_ID) {
                    compoundPaddingLeft = Math.min(compoundPaddingLeft, size2);
                }
            }
            scrollTo(0, 0);
            setMeasuredDimension(size, compoundPaddingLeft);
            AppMethodBeat.m2505o(107069);
        }
    }

    private int getDesiredHeight() {
        AppMethodBeat.m2504i(107070);
        Layout layout = this.yzC;
        if (layout == null) {
            AppMethodBeat.m2505o(107070);
            return 0;
        }
        int lineCount = layout.getLineCount();
        int compoundPaddingBottom = getCompoundPaddingBottom() + getCompoundPaddingTop();
        int lineTop = layout.getLineTop(lineCount) + compoundPaddingBottom;
        if (this.yzG != 1) {
            lineTop = Math.min(lineTop, this.yzF);
        } else if (lineCount > this.yzF) {
            lineTop = (layout.getLineTop(this.yzF) + layout.getBottomPadding()) + compoundPaddingBottom;
            lineCount = this.yzF;
        }
        if (this.yzI != 1) {
            lineTop = Math.max(lineTop, this.yzH);
        } else if (lineCount < this.yzH) {
            lineTop += (this.yzH - lineCount) * getLineHeight();
        }
        lineTop = Math.max(lineTop, getSuggestedMinimumHeight());
        AppMethodBeat.m2505o(107070);
        return lineTop;
    }

    private void dAs() {
        AppMethodBeat.m2504i(107071);
        if (this.yzP == 0) {
            this.yzP = (int) (Math.ceil((double) (this.yzQ.descent - this.yzQ.ascent)) + 2.0d);
        }
        AppMethodBeat.m2505o(107071);
    }

    /* renamed from: NK */
    private void m79945NK(int i) {
        AppMethodBeat.m2504i(107072);
        if (this.yzO) {
            dAs();
            invalidate();
            AppMethodBeat.m2505o(107072);
        } else if (getWidth() == 0) {
            requestLayout();
            invalidate();
            AppMethodBeat.m2505o(107072);
        } else if (this.yzC == null) {
            dAr();
            if (this.yzC.getHeight() != getHeight()) {
                requestLayout();
            }
            invalidate();
            AppMethodBeat.m2505o(107072);
        } else {
            int height = this.yzC.getHeight();
            int width = this.yzC.getWidth();
            m79948hl(width, width - i);
            if (this.yzy != TruncateAt.MARQUEE) {
                if (getLayoutParams().height == -2 || getLayoutParams().height == -1) {
                    width = this.yzC.getHeight();
                    if (width == height && width == getHeight()) {
                        invalidate();
                        AppMethodBeat.m2505o(107072);
                        return;
                    }
                }
                invalidate();
                AppMethodBeat.m2505o(107072);
                return;
            }
            requestLayout();
            invalidate();
            AppMethodBeat.m2505o(107072);
        }
    }

    @ExportedProperty
    public int getSelectionStart() {
        AppMethodBeat.m2504i(107073);
        int selectionStart = Selection.getSelectionStart(getText());
        AppMethodBeat.m2505o(107073);
        return selectionStart;
    }

    @ExportedProperty
    public int getSelectionEnd() {
        AppMethodBeat.m2504i(107074);
        int selectionEnd = Selection.getSelectionEnd(getText());
        AppMethodBeat.m2505o(107074);
        return selectionEnd;
    }

    public void setEllipsize(TruncateAt truncateAt) {
        AppMethodBeat.m2504i(107076);
        this.yzy = truncateAt;
        if (this.yzC != null) {
            dAq();
            requestLayout();
            invalidate();
        }
        AppMethodBeat.m2505o(107076);
    }

    @ExportedProperty
    public TruncateAt getEllipsize() {
        return this.yzy;
    }

    /* Access modifiers changed, original: protected */
    public int computeHorizontalScrollRange() {
        AppMethodBeat.m2504i(107077);
        int width;
        if (this.yzC != null) {
            width = this.yzC.getWidth();
            AppMethodBeat.m2505o(107077);
            return width;
        }
        width = super.computeHorizontalScrollRange();
        AppMethodBeat.m2505o(107077);
        return width;
    }

    /* Access modifiers changed, original: protected */
    public int computeVerticalScrollRange() {
        AppMethodBeat.m2504i(107078);
        int height;
        if (this.yzC != null) {
            height = this.yzC.getHeight();
            AppMethodBeat.m2505o(107078);
            return height;
        }
        height = super.computeVerticalScrollRange();
        AppMethodBeat.m2505o(107078);
        return height;
    }

    /* Access modifiers changed, original: protected */
    public int computeVerticalScrollExtent() {
        AppMethodBeat.m2504i(107079);
        int height = (getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
        AppMethodBeat.m2505o(107079);
        return height;
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.m2504i(107080);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CharSequence contentDescription = getContentDescription();
        if (C5046bo.isNullOrNil((String) contentDescription)) {
            contentDescription = getText();
        }
        accessibilityNodeInfo.setText(contentDescription);
        AppMethodBeat.m2505o(107080);
    }

    public void setSingleLine(boolean z) {
        AppMethodBeat.m2504i(107075);
        this.mSingleLine = z;
        if (z) {
            setLines(1);
            AppMethodBeat.m2505o(107075);
            return;
        }
        setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
        AppMethodBeat.m2505o(107075);
    }
}
