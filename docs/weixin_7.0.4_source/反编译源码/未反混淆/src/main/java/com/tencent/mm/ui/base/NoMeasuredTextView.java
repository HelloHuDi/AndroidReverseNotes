package com.tencent.mm.ui.base;

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
import android.support.v4.widget.j;
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
import com.tencent.mm.sdk.platformtools.bo;

@SuppressLint({"ResourceAsColor"})
public class NoMeasuredTextView extends View {
    private static final Metrics yAd = new Metrics();
    private int Hu;
    private int dg;
    private int di;
    private ColorStateList lP;
    private boolean mSingleLine;
    private CharSequence mText;
    private TextPaint oz;
    private int yAa;
    private int yAb;
    private c yAc;
    private String ysq;
    private int ysr;
    private int yss;
    private a yzA;
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
    private b yzT;
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

    public enum a {
        NORMAL,
        SPANNABLE,
        EDITABLE;

        static {
            AppMethodBeat.o(107003);
        }
    }

    public interface c {
        CharSequence a(NoMeasuredTextView noMeasuredTextView, CharSequence charSequence, String str, int i, int i2);
    }

    class b {
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

        b() {
            AppMethodBeat.i(107004);
            AppMethodBeat.o(107004);
        }
    }

    public void setDrawLeftDrawable(boolean z) {
        AppMethodBeat.i(107005);
        if (this.yzU != z) {
            invalidate();
        }
        this.yzU = z;
        AppMethodBeat.o(107005);
    }

    public void setDrawRightDrawable(boolean z) {
        AppMethodBeat.i(107006);
        if (this.yzV != z) {
            invalidate();
        }
        this.yzV = z;
        AppMethodBeat.o(107006);
    }

    public void setDrawTopDrawable(boolean z) {
        AppMethodBeat.i(107007);
        if (this.yzW != z) {
            invalidate();
        }
        this.yzW = z;
        AppMethodBeat.o(107007);
    }

    public void setDrawDownDrawable(boolean z) {
        AppMethodBeat.i(107008);
        if (this.yzX != z) {
            invalidate();
        }
        this.yzX = z;
        AppMethodBeat.o(107008);
    }

    static {
        AppMethodBeat.i(107081);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.measureText("H");
        AppMethodBeat.o(107081);
    }

    public void setShouldEllipsize(boolean z) {
        this.yzS = z;
    }

    public NoMeasuredTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107009);
        this.yzw = Factory.getInstance();
        this.yzx = Spannable.Factory.getInstance();
        this.yzy = null;
        this.yzA = a.NORMAL;
        this.Hu = 51;
        this.yzD = 1.0f;
        this.yzE = 0.0f;
        this.yzF = BaseClientBuilder.API_PRIORITY_OTHER;
        this.yzG = 1;
        this.yzH = 0;
        this.yzI = 1;
        this.di = BaseClientBuilder.API_PRIORITY_OTHER;
        this.yzJ = false;
        this.dg = 0;
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
        this.oz = new TextPaint(1);
        this.oz.density = getResources().getDisplayMetrics().density;
        setDrawingCacheEnabled(false);
        this.yzQ = this.oz.getFontMetricsInt();
        dAs();
        setSingleLine(true);
        setEllipsize(null);
        AppMethodBeat.o(107009);
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
        AppMethodBeat.i(107010);
        int round = Math.round((((float) this.oz.getFontMetricsInt(null)) * this.yzD) + this.yzE);
        AppMethodBeat.o(107010);
        return round;
    }

    public final Layout getLayout() {
        return this.yzC;
    }

    private void a(Drawable drawable, Drawable drawable2) {
        AppMethodBeat.i(107011);
        b bVar = this.yzT;
        int i = (drawable == null && drawable2 == null) ? 0 : 1;
        if (i != 0) {
            if (bVar == null) {
                bVar = new b();
                this.yzT = bVar;
            }
            if (!(bVar.yAl == drawable || bVar.yAl == null)) {
                bVar.yAl.setCallback(null);
            }
            bVar.yAl = drawable;
            if (!(bVar.yAj == null || bVar.yAj == null)) {
                bVar.yAj.setCallback(null);
            }
            bVar.yAj = null;
            if (!(bVar.yAm == drawable2 || bVar.yAm == null)) {
                bVar.yAm.setCallback(null);
            }
            bVar.yAm = drawable2;
            if (!(bVar.yAk == null || bVar.yAk == null)) {
                bVar.yAk.setCallback(null);
            }
            bVar.yAk = null;
            Rect rect = bVar.yAi;
            int[] drawableState = getDrawableState();
            if (drawable != null) {
                drawable.setState(drawableState);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                bVar.yAp = rect.width();
                bVar.yAt = rect.height();
            } else {
                bVar.yAt = 0;
                bVar.yAp = 0;
            }
            if (drawable2 != null) {
                drawable2.setState(drawableState);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                bVar.yAq = rect.width();
                bVar.yAu = rect.height();
                bVar.yAr = 0;
                bVar.yAn = 0;
                bVar.yAs = 0;
                bVar.yAo = 0;
            }
            bVar.yAu = 0;
            bVar.yAq = 0;
            bVar.yAr = 0;
            bVar.yAn = 0;
            bVar.yAs = 0;
            bVar.yAo = 0;
        } else if (bVar != null) {
            if (bVar.yAv == 0) {
                this.yzT = null;
            } else {
                if (bVar.yAl != null) {
                    bVar.yAl.setCallback(null);
                }
                bVar.yAl = null;
                if (bVar.yAj != null) {
                    bVar.yAj.setCallback(null);
                }
                bVar.yAj = null;
                if (bVar.yAm != null) {
                    bVar.yAm.setCallback(null);
                }
                bVar.yAm = null;
                if (bVar.yAk != null) {
                    bVar.yAk.setCallback(null);
                }
                bVar.yAk = null;
                bVar.yAt = 0;
                bVar.yAp = 0;
                bVar.yAu = 0;
                bVar.yAq = 0;
                bVar.yAr = 0;
                bVar.yAn = 0;
                bVar.yAs = 0;
                bVar.yAo = 0;
            }
        }
        invalidate();
        AppMethodBeat.o(107011);
    }

    public void setCompoundLeftDrawablesWithIntrinsicBounds(Drawable drawable) {
        AppMethodBeat.i(107012);
        if (drawable == null) {
            AppMethodBeat.o(107012);
        } else if (this.yzT == null || this.yzT.yAl != drawable) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            a(drawable, null);
            AppMethodBeat.o(107012);
        } else {
            AppMethodBeat.o(107012);
        }
    }

    public void setCompoundRightDrawablesWithIntrinsicBounds(Drawable drawable) {
        AppMethodBeat.i(107013);
        if (drawable == null) {
            AppMethodBeat.o(107013);
        } else if (this.yzT == null || this.yzT.yAm != drawable) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            a(null, drawable);
            AppMethodBeat.o(107013);
        } else {
            AppMethodBeat.o(107013);
        }
    }

    public void setCompoundLeftDrawablesWithIntrinsicBounds(int i) {
        AppMethodBeat.i(107014);
        if (i != this.yzY) {
            this.yzY = i;
            setCompoundLeftDrawablesWithIntrinsicBounds(getResources().getDrawable(i));
        }
        AppMethodBeat.o(107014);
    }

    public void setCompoundRightDrawablesWithIntrinsicBounds(int i) {
        AppMethodBeat.i(107015);
        if (i != this.yzZ) {
            this.yzZ = i;
            setCompoundRightDrawablesWithIntrinsicBounds(getResources().getDrawable(i));
        }
        AppMethodBeat.o(107015);
    }

    public Drawable[] getCompoundDrawables() {
        if (this.yzT != null) {
            return new Drawable[]{this.yzT.yAl, this.yzT.yAj, this.yzT.yAm, this.yzT.yAk};
        }
        return new Drawable[]{null, null, null, null};
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        AppMethodBeat.i(107016);
        super.drawableStateChanged();
        if (this.lP != null && this.lP.isStateful()) {
            updateTextColors();
        }
        b bVar = this.yzT;
        if (bVar != null) {
            int[] drawableState = getDrawableState();
            if (bVar.yAj != null && bVar.yAj.isStateful()) {
                bVar.yAj.setState(drawableState);
            }
            if (bVar.yAk != null && bVar.yAk.isStateful()) {
                bVar.yAk.setState(drawableState);
            }
            if (bVar.yAl != null && bVar.yAl.isStateful()) {
                bVar.yAl.setState(drawableState);
            }
            if (bVar.yAm != null && bVar.yAm.isStateful()) {
                bVar.yAm.setState(drawableState);
            }
        }
        AppMethodBeat.o(107016);
    }

    /* Access modifiers changed, original: protected */
    public boolean verifyDrawable(Drawable drawable) {
        AppMethodBeat.i(107017);
        boolean verifyDrawable = super.verifyDrawable(drawable);
        if (verifyDrawable || this.yzT == null) {
            AppMethodBeat.o(107017);
            return verifyDrawable;
        } else if (drawable == this.yzT.yAl || drawable == this.yzT.yAj || drawable == this.yzT.yAm || drawable == this.yzT.yAk) {
            AppMethodBeat.o(107017);
            return true;
        } else {
            AppMethodBeat.o(107017);
            return false;
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        AppMethodBeat.i(107018);
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            b bVar = this.yzT;
            if (bVar != null) {
                int compoundPaddingTop;
                if (drawable == bVar.yAl) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    scrollX += getPaddingLeft();
                    scrollY += (((((getBottom() - getTop()) - getCompoundPaddingBottom()) - compoundPaddingTop) - bVar.yAt) / 2) + compoundPaddingTop;
                } else if (drawable == bVar.yAm) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    scrollX += ((getRight() - getLeft()) - getPaddingRight()) - bVar.yAq;
                    scrollY += (((((getBottom() - getTop()) - getCompoundPaddingBottom()) - compoundPaddingTop) - bVar.yAu) / 2) + compoundPaddingTop;
                } else if (drawable == bVar.yAj) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    scrollX += (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingTop) - bVar.yAr) / 2) + compoundPaddingTop;
                    scrollY += getPaddingTop();
                } else if (drawable == bVar.yAk) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    scrollX += compoundPaddingTop + (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingTop) - bVar.yAs) / 2);
                    scrollY += ((getBottom() - getTop()) - getPaddingBottom()) - bVar.yAo;
                }
            }
            invalidate(bounds.left + scrollX, bounds.top + scrollY, scrollX + bounds.right, scrollY + bounds.bottom);
        }
        AppMethodBeat.o(107018);
    }

    /* JADX WARNING: Missing block: B:2:0x000a, code skipped:
            if (r0 != null) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCompoundDrawablePadding(int i) {
        AppMethodBeat.i(107019);
        b bVar = this.yzT;
        if (i != 0) {
            if (bVar == null) {
                bVar = new b();
                this.yzT = bVar;
            }
        }
        bVar.yAv = i;
        invalidate();
        requestLayout();
        AppMethodBeat.o(107019);
    }

    public int getCompoundDrawablePadding() {
        b bVar = this.yzT;
        return bVar != null ? bVar.yAv : 0;
    }

    public int getCompoundPaddingTop() {
        AppMethodBeat.i(107020);
        b bVar = this.yzT;
        int paddingTop;
        if (bVar == null || bVar.yAj == null || !this.yzW) {
            paddingTop = getPaddingTop();
            AppMethodBeat.o(107020);
            return paddingTop;
        }
        paddingTop = bVar.yAn + (getPaddingTop() + bVar.yAv);
        AppMethodBeat.o(107020);
        return paddingTop;
    }

    public int getCompoundPaddingBottom() {
        AppMethodBeat.i(107021);
        b bVar = this.yzT;
        int paddingBottom;
        if (bVar == null || bVar.yAk == null || !this.yzX) {
            paddingBottom = getPaddingBottom();
            AppMethodBeat.o(107021);
            return paddingBottom;
        }
        paddingBottom = bVar.yAo + (getPaddingBottom() + bVar.yAv);
        AppMethodBeat.o(107021);
        return paddingBottom;
    }

    public int getCompoundPaddingLeft() {
        AppMethodBeat.i(107022);
        b bVar = this.yzT;
        int paddingLeft;
        if (bVar == null || bVar.yAl == null || !this.yzU) {
            paddingLeft = getPaddingLeft();
            AppMethodBeat.o(107022);
            return paddingLeft;
        }
        paddingLeft = bVar.yAp + (getPaddingLeft() + bVar.yAv);
        AppMethodBeat.o(107022);
        return paddingLeft;
    }

    public int getCompoundPaddingRight() {
        AppMethodBeat.i(107023);
        b bVar = this.yzT;
        int paddingRight;
        if (bVar == null || bVar.yAm == null || !this.yzV) {
            paddingRight = getPaddingRight();
            AppMethodBeat.o(107023);
            return paddingRight;
        }
        paddingRight = bVar.yAq + (getPaddingRight() + bVar.yAv);
        AppMethodBeat.o(107023);
        return paddingRight;
    }

    public int getExtendedPaddingTop() {
        AppMethodBeat.i(107024);
        int compoundPaddingTop;
        if (this.yzC == null || this.yzG != 1) {
            compoundPaddingTop = getCompoundPaddingTop();
            AppMethodBeat.o(107024);
            return compoundPaddingTop;
        } else if (this.yzC.getLineCount() <= this.yzF) {
            compoundPaddingTop = getCompoundPaddingTop();
            AppMethodBeat.o(107024);
            return compoundPaddingTop;
        } else {
            compoundPaddingTop = getCompoundPaddingTop();
            int height = (getHeight() - compoundPaddingTop) - getCompoundPaddingBottom();
            int lineTop = this.yzC.getLineTop(this.yzF);
            if (lineTop >= height) {
                AppMethodBeat.o(107024);
                return compoundPaddingTop;
            }
            int i = this.Hu & 112;
            if (i == 48) {
                AppMethodBeat.o(107024);
                return compoundPaddingTop;
            } else if (i == 80) {
                compoundPaddingTop = (compoundPaddingTop + height) - lineTop;
                AppMethodBeat.o(107024);
                return compoundPaddingTop;
            } else {
                compoundPaddingTop += (height - lineTop) / 2;
                AppMethodBeat.o(107024);
                return compoundPaddingTop;
            }
        }
    }

    public int getExtendedPaddingBottom() {
        AppMethodBeat.i(107025);
        int compoundPaddingBottom;
        if (this.yzC == null || this.yzG != 1) {
            compoundPaddingBottom = getCompoundPaddingBottom();
            AppMethodBeat.o(107025);
            return compoundPaddingBottom;
        } else if (this.yzC.getLineCount() <= this.yzF) {
            compoundPaddingBottom = getCompoundPaddingBottom();
            AppMethodBeat.o(107025);
            return compoundPaddingBottom;
        } else {
            int compoundPaddingTop = getCompoundPaddingTop();
            compoundPaddingBottom = getCompoundPaddingBottom();
            compoundPaddingTop = (getHeight() - compoundPaddingTop) - compoundPaddingBottom;
            int lineTop = this.yzC.getLineTop(this.yzF);
            if (lineTop >= compoundPaddingTop) {
                AppMethodBeat.o(107025);
                return compoundPaddingBottom;
            }
            int i = this.Hu & 112;
            if (i == 48) {
                compoundPaddingBottom = (compoundPaddingBottom + compoundPaddingTop) - lineTop;
                AppMethodBeat.o(107025);
                return compoundPaddingBottom;
            } else if (i == 80) {
                AppMethodBeat.o(107025);
                return compoundPaddingBottom;
            } else {
                compoundPaddingBottom += (compoundPaddingTop - lineTop) / 2;
                AppMethodBeat.o(107025);
                return compoundPaddingBottom;
            }
        }
    }

    public int getTotalPaddingLeft() {
        AppMethodBeat.i(107026);
        int compoundPaddingLeft = getCompoundPaddingLeft();
        AppMethodBeat.o(107026);
        return compoundPaddingLeft;
    }

    public int getTotalPaddingRight() {
        AppMethodBeat.i(107027);
        int compoundPaddingRight = getCompoundPaddingRight();
        AppMethodBeat.o(107027);
        return compoundPaddingRight;
    }

    public int getTotalPaddingTop() {
        AppMethodBeat.i(107028);
        int extendedPaddingTop = getExtendedPaddingTop() + getVerticalOffset$1385f2();
        AppMethodBeat.o(107028);
        return extendedPaddingTop;
    }

    public int getTotalPaddingBottom() {
        AppMethodBeat.i(107029);
        int extendedPaddingBottom = getExtendedPaddingBottom();
        int i = 0;
        int i2 = this.Hu & 112;
        Layout layout = this.yzC;
        if (i2 != 80) {
            int measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
            int height = layout.getHeight();
            if (height < measuredHeight) {
                i = i2 == 48 ? measuredHeight - height : (measuredHeight - height) >> 1;
            }
        }
        i += extendedPaddingBottom;
        AppMethodBeat.o(107029);
        return i;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(107030);
        if (!(i == getPaddingLeft() && i3 == getPaddingRight() && i2 == getPaddingTop() && i4 == getPaddingBottom())) {
            dAq();
        }
        super.setPadding(i, i2, i3, i4);
        invalidate();
        AppMethodBeat.o(107030);
    }

    public float getTextSize() {
        AppMethodBeat.i(107031);
        float textSize = this.oz.getTextSize();
        AppMethodBeat.o(107031);
        return textSize;
    }

    public void setTextSize(float f) {
        AppMethodBeat.i(107032);
        setTextSize(2, f);
        AppMethodBeat.o(107032);
    }

    public final void setTextSize(int i, float f) {
        Resources system;
        AppMethodBeat.i(107033);
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        AppMethodBeat.o(107033);
    }

    private void setRawTextSize(float f) {
        AppMethodBeat.i(107034);
        if (f != this.oz.getTextSize()) {
            this.oz.setTextSize(f);
            this.yzQ = this.oz.getFontMetricsInt();
            this.yzP = (int) (Math.ceil((double) (this.yzQ.descent - this.yzQ.ascent)) + 2.0d);
            if (this.yzC != null) {
                dAq();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(107034);
    }

    public float getTextScaleX() {
        AppMethodBeat.i(107035);
        float textScaleX = this.oz.getTextScaleX();
        AppMethodBeat.o(107035);
        return textScaleX;
    }

    public void setTypeface(Typeface typeface) {
        AppMethodBeat.i(107036);
        if (this.oz.getTypeface() != typeface) {
            this.oz.setTypeface(typeface);
            if (this.yzC != null) {
                dAq();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(107036);
    }

    public Typeface getTypeface() {
        AppMethodBeat.i(107037);
        Typeface typeface = this.oz.getTypeface();
        AppMethodBeat.o(107037);
        return typeface;
    }

    public void setTextColor(int i) {
        AppMethodBeat.i(107038);
        this.lP = ColorStateList.valueOf(i);
        updateTextColors();
        AppMethodBeat.o(107038);
    }

    public void setTextColor(ColorStateList colorStateList) {
        AppMethodBeat.i(107039);
        if (colorStateList == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(107039);
            throw nullPointerException;
        } else if (this.lP == colorStateList) {
            AppMethodBeat.o(107039);
        } else {
            this.lP = colorStateList;
            updateTextColors();
            AppMethodBeat.o(107039);
        }
    }

    public final ColorStateList getTextColors() {
        return this.lP;
    }

    public final int getCurrentTextColor() {
        return this.yzv;
    }

    public TextPaint getPaint() {
        return this.oz;
    }

    public void setGravity(int i) {
        int i2;
        AppMethodBeat.i(107040);
        if ((i & 7) == 0) {
            i2 = i | 3;
        } else {
            i2 = i;
        }
        if ((i2 & 112) == 0) {
            i2 |= 48;
        }
        Object obj = null;
        if ((i2 & 7) != (this.Hu & 7)) {
            obj = 1;
        }
        if (i2 != this.Hu) {
            invalidate();
        }
        this.Hu = i2;
        if (!(this.yzC == null || obj == null)) {
            hl(this.yzC.getWidth(), (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight());
        }
        AppMethodBeat.o(107040);
    }

    public int getGravity() {
        return this.Hu;
    }

    public int getPaintFlags() {
        AppMethodBeat.i(107041);
        int flags = this.oz.getFlags();
        AppMethodBeat.o(107041);
        return flags;
    }

    public void setPaintFlags(int i) {
        AppMethodBeat.i(107042);
        if (this.oz.getFlags() != i) {
            this.oz.setFlags(i);
            if (this.yzC != null) {
                dAq();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(107042);
    }

    public void setMinLines(int i) {
        AppMethodBeat.i(107043);
        this.yzH = i;
        this.yzI = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.o(107043);
    }

    public void setMinHeight(int i) {
        AppMethodBeat.i(107044);
        this.yzH = i;
        this.yzI = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.o(107044);
    }

    public void setMaxLines(int i) {
        AppMethodBeat.i(107045);
        this.yzF = i;
        this.yzG = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.o(107045);
    }

    public void setMaxHeight(int i) {
        AppMethodBeat.i(107046);
        this.yzF = i;
        this.yzG = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.o(107046);
    }

    public void setLines(int i) {
        AppMethodBeat.i(107047);
        this.yzH = i;
        this.yzF = i;
        this.yzI = 1;
        this.yzG = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.o(107047);
    }

    public void setHeight(int i) {
        AppMethodBeat.i(107048);
        this.yzH = i;
        this.yzF = i;
        this.yzI = 2;
        this.yzG = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.o(107048);
    }

    public void setMinWidth(int i) {
        AppMethodBeat.i(107049);
        this.dg = i;
        this.yzK = true;
        requestLayout();
        invalidate();
        AppMethodBeat.o(107049);
    }

    public void setMaxWidth(int i) {
        AppMethodBeat.i(107050);
        this.di = i;
        this.yzJ = true;
        requestLayout();
        invalidate();
        AppMethodBeat.o(107050);
    }

    public void setWidth(int i) {
        AppMethodBeat.i(107051);
        this.dg = i;
        this.di = i;
        this.yzK = true;
        this.yzJ = true;
        requestLayout();
        invalidate();
        AppMethodBeat.o(107051);
    }

    private void updateTextColors() {
        int i = 0;
        AppMethodBeat.i(107052);
        int colorForState = this.lP.getColorForState(getDrawableState(), 0);
        if (colorForState != this.yzv) {
            this.yzv = colorForState;
            i = 1;
        }
        if (i != 0) {
            invalidate();
        }
        AppMethodBeat.o(107052);
    }

    public final void setEditableFactory(Factory factory) {
        AppMethodBeat.i(107053);
        this.yzw = factory;
        setText(this.mText);
        AppMethodBeat.o(107053);
    }

    public final void setSpannableFactory(Spannable.Factory factory) {
        AppMethodBeat.i(107054);
        this.yzx = factory;
        setText(this.mText);
        AppMethodBeat.o(107054);
    }

    public final void setText(CharSequence charSequence) {
        AppMethodBeat.i(107055);
        a(charSequence, this.yzA);
        AppMethodBeat.o(107055);
    }

    public final void setTextKeepState(CharSequence charSequence) {
        AppMethodBeat.i(107056);
        a aVar = this.yzA;
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        int length = charSequence.length();
        a(charSequence, aVar);
        if ((selectionStart >= 0 || selectionEnd >= 0) && (this.mText instanceof Spannable)) {
            Selection.setSelection((Spannable) this.mText, Math.max(0, Math.min(selectionStart, length)), Math.max(0, Math.min(selectionEnd, length)));
        }
        AppMethodBeat.o(107056);
    }

    private void a(CharSequence charSequence, a aVar) {
        CharSequence charSequence2;
        AppMethodBeat.i(107057);
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence;
        }
        if (charSequence2.equals(this.mText)) {
            AppMethodBeat.o(107057);
            return;
        }
        if (!(getMeasuredWidth() <= 0 || this.yAc == null || bo.isNullOrNil(this.ysq))) {
            charSequence2 = this.yAc.a(this, charSequence2, this.ysq, this.ysr, this.yss);
            this.ysq = null;
        }
        if (charSequence2 instanceof Spanned) {
            this.yzO = false;
        } else {
            this.yzO = true;
        }
        if (aVar == a.EDITABLE || this.yzB != null) {
            charSequence2 = this.yzw.newEditable(charSequence2);
        } else if (aVar == a.SPANNABLE) {
            charSequence2 = this.yzx.newSpannable(charSequence2);
        }
        int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
        if (this.yzS) {
            if (this.yzJ) {
                int i = this.di;
                if (getMeasuredWidth() > 0) {
                    i = Math.min(this.di, getMeasuredWidth());
                }
                charSequence2 = TextUtils.ellipsize(charSequence2, this.oz, (float) (i - compoundPaddingLeft), TruncateAt.END);
            } else if (getMeasuredWidth() > 0) {
                charSequence2 = TextUtils.ellipsize(charSequence2, this.oz, (float) (getMeasuredWidth() - compoundPaddingLeft), TruncateAt.END);
            } else {
                this.yzR = true;
            }
        }
        this.yzA = aVar;
        this.mText = charSequence2;
        this.yzz = charSequence2;
        NK(compoundPaddingLeft);
        AppMethodBeat.o(107057);
    }

    public final void au(String str, int i, int i2) {
        this.ysq = str;
        this.ysr = i;
        this.yss = i2;
    }

    public void setLayoutCallback(c cVar) {
        this.yAc = cVar;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(107058);
        super.onLayout(z, i, i2, i3, i4);
        if (this.yzR && getMeasuredWidth() > 0) {
            if (bo.isNullOrNil(this.ysq) || this.yAc == null) {
                setText(TextUtils.ellipsize(this.mText, getPaint(), (float) ((getMeasuredWidth() - getCompoundPaddingRight()) - getCompoundPaddingLeft()), TruncateAt.END));
            } else {
                CharSequence a = this.yAc.a(this, this.mText, this.ysq, this.ysr, this.yss);
                this.ysq = null;
                setText(a);
            }
            this.yzR = false;
        }
        AppMethodBeat.o(107058);
    }

    public final void setText(int i) {
        AppMethodBeat.i(107059);
        setText(getContext().getResources().getText(i));
        AppMethodBeat.o(107059);
    }

    private int getVerticalOffset$1385f2() {
        AppMethodBeat.i(107060);
        int i = 0;
        int i2 = this.Hu & 112;
        Layout layout = this.yzC;
        if (i2 != 48) {
            int measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
            int height = layout.getHeight();
            if (height < measuredHeight) {
                i = i2 == 80 ? measuredHeight - height : (measuredHeight - height) >> 1;
            }
        }
        AppMethodBeat.o(107060);
        return i;
    }

    private int getBottomVerticalOffset$1385f2() {
        AppMethodBeat.i(139074);
        int i = 0;
        int i2 = this.Hu & 112;
        Layout layout = this.yzC;
        if (i2 != 80) {
            int measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
            int height = layout.getHeight();
            if (height < measuredHeight) {
                i = i2 == 48 ? measuredHeight - height : (measuredHeight - height) >> 1;
            }
        }
        AppMethodBeat.o(139074);
        return i;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(107062);
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
        b bVar = this.yzT;
        float f = -1.0f;
        if (bVar != null) {
            int i = ((bottom - top) - compoundPaddingBottom) - compoundPaddingTop;
            int i2 = ((right - left) - compoundPaddingRight) - compoundPaddingLeft;
            if (this.yzU && bVar.yAl != null) {
                canvas.save();
                canvas.translate((float) (getPaddingLeft() + scrollX), (float) ((scrollY + compoundPaddingTop) + ((i - bVar.yAt) / 2)));
                bVar.yAl.draw(canvas);
                canvas.restore();
            }
            if (this.yzV && bVar.yAm != null) {
                float f2;
                float f3;
                canvas.save();
                if (this.yzO) {
                    f = this.oz.measureText(this.mText, 0, this.mText.length());
                    f2 = f;
                    f3 = f;
                } else {
                    f2 = (float) Math.ceil((double) Layout.getDesiredWidth(this.yzz, this.oz));
                    f3 = -1.0f;
                }
                canvas.translate((f2 + ((float) scrollX)) - ((float) getPaddingRight()), (float) ((scrollY + compoundPaddingTop) + ((i - bVar.yAu) / 2)));
                bVar.yAm.draw(canvas);
                canvas.restore();
                f = f3;
            }
            if (this.yzW && bVar.yAj != null) {
                canvas.save();
                canvas.translate((float) ((scrollX + compoundPaddingLeft) + ((i2 - bVar.yAr) / 2)), (float) (getPaddingTop() + scrollY));
                bVar.yAj.draw(canvas);
                canvas.restore();
            }
            if (this.yzX && bVar.yAk != null) {
                canvas.save();
                canvas.translate((float) ((scrollX + compoundPaddingLeft) + ((i2 - bVar.yAs) / 2)), (float) ((((scrollY + bottom) - top) - getPaddingBottom()) - bVar.yAo));
                bVar.yAk.draw(canvas);
                canvas.restore();
            }
        }
        this.oz.setColor(this.yzv);
        this.oz.drawableState = getDrawableState();
        canvas.save();
        compoundPaddingTop = getExtendedPaddingTop();
        Canvas canvas2 = canvas;
        float f4 = (float) (compoundPaddingTop + scrollY);
        canvas2.clipRect((float) (compoundPaddingLeft + scrollX), f4, (float) (((right - left) - compoundPaddingRight) + scrollX), (float) (((bottom - top) - getExtendedPaddingBottom()) + scrollY));
        int i3 = 0;
        compoundPaddingBottom = 0;
        if ((this.Hu & 112) != 48) {
            i3 = getVerticalOffset$1385f2();
            compoundPaddingBottom = getVerticalOffset$1385f2();
        }
        canvas.translate((float) compoundPaddingLeft, (float) (compoundPaddingTop + i3));
        if (this.yzO) {
            float f5 = (float) (((height - (this.yzQ.bottom - this.yzQ.top)) / 2) - this.yzQ.top);
            compoundPaddingBottom = 0;
            if ((this.Hu & 7) != 3) {
                switch (this.Hu & 7) {
                    case 1:
                        if (f == -1.0f) {
                            f = this.oz.measureText(this.mText, 0, this.mText.length());
                        }
                        compoundPaddingBottom = ((int) (((float) (width - getPaddingRight())) - f)) / 2;
                        break;
                    case 5:
                        if (f == -1.0f) {
                            f = this.oz.measureText(this.mText, 0, this.mText.length());
                        }
                        compoundPaddingBottom = (int) (((float) (width - getPaddingRight())) - f);
                        break;
                }
            }
            canvas.drawText(this.mText, 0, this.mText.length(), (float) compoundPaddingBottom, f5, this.oz);
        } else {
            if (this.yzC == null) {
                dAr();
            }
            this.yzC.draw(canvas, null, null, compoundPaddingBottom - i3);
        }
        canvas.restore();
        AppMethodBeat.o(107062);
    }

    public void getFocusedRect(Rect rect) {
        AppMethodBeat.i(107063);
        if (this.yzC == null) {
            super.getFocusedRect(rect);
            AppMethodBeat.o(107063);
            return;
        }
        int selectionEnd = getSelectionEnd();
        if (selectionEnd < 0) {
            super.getFocusedRect(rect);
            AppMethodBeat.o(107063);
            return;
        }
        int lineForOffset = this.yzC.getLineForOffset(selectionEnd);
        rect.top = this.yzC.getLineTop(lineForOffset);
        rect.bottom = this.yzC.getLineBottom(lineForOffset);
        rect.left = (int) this.yzC.getPrimaryHorizontal(selectionEnd);
        rect.right = rect.left + 1;
        lineForOffset = getCompoundPaddingLeft();
        selectionEnd = getExtendedPaddingTop();
        if ((this.Hu & 112) != 48) {
            selectionEnd += getVerticalOffset$1385f2();
        }
        rect.offset(lineForOffset, selectionEnd);
        AppMethodBeat.o(107063);
    }

    public int getLineCount() {
        AppMethodBeat.i(107064);
        if (this.yzC != null) {
            int lineCount = this.yzC.getLineCount();
            AppMethodBeat.o(107064);
            return lineCount;
        }
        AppMethodBeat.o(107064);
        return 0;
    }

    public int getBaseline() {
        AppMethodBeat.i(107065);
        int baseline;
        if (this.yzC == null) {
            baseline = super.getBaseline();
            AppMethodBeat.o(107065);
            return baseline;
        }
        if ((this.Hu & 112) != 48) {
            baseline = getVerticalOffset$1385f2();
        } else {
            baseline = 0;
        }
        baseline = (baseline + getExtendedPaddingTop()) + this.yzC.getLineBaseline(0);
        AppMethodBeat.o(107065);
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
        AppMethodBeat.i(107066);
        if (this.yzJ) {
            compoundPaddingLeft = (this.di - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        } else {
            compoundPaddingLeft = ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        }
        if (compoundPaddingLeft <= 0) {
            compoundPaddingLeft = 0;
        }
        hl(compoundPaddingLeft, compoundPaddingLeft);
        AppMethodBeat.o(107066);
    }

    private void hl(int i, int i2) {
        int i3;
        Alignment alignment;
        int i4;
        AppMethodBeat.i(107067);
        if (i < 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        switch (this.Hu & 7) {
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
            this.yzC = new StaticLayout(this.yzz, 0, this.yzz.length(), this.oz, i3, alignment, this.yzD, this.yzE, this.yzM, this.yzy, i2);
            AppMethodBeat.o(107067);
            return;
        }
        this.yzC = new StaticLayout(this.yzz, this.oz, i3, alignment, this.yzD, this.yzE, this.yzM);
        AppMethodBeat.o(107067);
    }

    public void setIncludeFontPadding(boolean z) {
        AppMethodBeat.i(107068);
        this.yzM = z;
        if (this.yzC != null) {
            dAq();
            requestLayout();
            invalidate();
        }
        AppMethodBeat.o(107068);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(107069);
        MeasureSpec.getMode(i);
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (size == 0) {
            setMeasuredDimension(size, this.yzP);
            AppMethodBeat.o(107069);
        } else if (this.yzO) {
            if (this.yzP == 0) {
                dAs();
            }
            setMeasuredDimension(size, this.yzP);
            AppMethodBeat.o(107069);
        } else {
            int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.yzJ) {
                compoundPaddingLeft = this.di - compoundPaddingLeft;
            } else {
                compoundPaddingLeft = size - compoundPaddingLeft;
            }
            if (this.yzC == null) {
                hl(compoundPaddingLeft, compoundPaddingLeft);
            } else {
                int i3;
                if (this.yzC.getWidth() != compoundPaddingLeft) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    hl(compoundPaddingLeft, compoundPaddingLeft);
                }
            }
            if (mode == ErrorDialogData.SUPPRESSED) {
                this.yzL = -1;
                compoundPaddingLeft = size2;
            } else {
                compoundPaddingLeft = getDesiredHeight();
                this.yzL = compoundPaddingLeft;
                if (mode == j.INVALID_ID) {
                    compoundPaddingLeft = Math.min(compoundPaddingLeft, size2);
                }
            }
            scrollTo(0, 0);
            setMeasuredDimension(size, compoundPaddingLeft);
            AppMethodBeat.o(107069);
        }
    }

    private int getDesiredHeight() {
        AppMethodBeat.i(107070);
        Layout layout = this.yzC;
        if (layout == null) {
            AppMethodBeat.o(107070);
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
        AppMethodBeat.o(107070);
        return lineTop;
    }

    private void dAs() {
        AppMethodBeat.i(107071);
        if (this.yzP == 0) {
            this.yzP = (int) (Math.ceil((double) (this.yzQ.descent - this.yzQ.ascent)) + 2.0d);
        }
        AppMethodBeat.o(107071);
    }

    private void NK(int i) {
        AppMethodBeat.i(107072);
        if (this.yzO) {
            dAs();
            invalidate();
            AppMethodBeat.o(107072);
        } else if (getWidth() == 0) {
            requestLayout();
            invalidate();
            AppMethodBeat.o(107072);
        } else if (this.yzC == null) {
            dAr();
            if (this.yzC.getHeight() != getHeight()) {
                requestLayout();
            }
            invalidate();
            AppMethodBeat.o(107072);
        } else {
            int height = this.yzC.getHeight();
            int width = this.yzC.getWidth();
            hl(width, width - i);
            if (this.yzy != TruncateAt.MARQUEE) {
                if (getLayoutParams().height == -2 || getLayoutParams().height == -1) {
                    width = this.yzC.getHeight();
                    if (width == height && width == getHeight()) {
                        invalidate();
                        AppMethodBeat.o(107072);
                        return;
                    }
                }
                invalidate();
                AppMethodBeat.o(107072);
                return;
            }
            requestLayout();
            invalidate();
            AppMethodBeat.o(107072);
        }
    }

    @ExportedProperty
    public int getSelectionStart() {
        AppMethodBeat.i(107073);
        int selectionStart = Selection.getSelectionStart(getText());
        AppMethodBeat.o(107073);
        return selectionStart;
    }

    @ExportedProperty
    public int getSelectionEnd() {
        AppMethodBeat.i(107074);
        int selectionEnd = Selection.getSelectionEnd(getText());
        AppMethodBeat.o(107074);
        return selectionEnd;
    }

    public void setEllipsize(TruncateAt truncateAt) {
        AppMethodBeat.i(107076);
        this.yzy = truncateAt;
        if (this.yzC != null) {
            dAq();
            requestLayout();
            invalidate();
        }
        AppMethodBeat.o(107076);
    }

    @ExportedProperty
    public TruncateAt getEllipsize() {
        return this.yzy;
    }

    /* Access modifiers changed, original: protected */
    public int computeHorizontalScrollRange() {
        AppMethodBeat.i(107077);
        int width;
        if (this.yzC != null) {
            width = this.yzC.getWidth();
            AppMethodBeat.o(107077);
            return width;
        }
        width = super.computeHorizontalScrollRange();
        AppMethodBeat.o(107077);
        return width;
    }

    /* Access modifiers changed, original: protected */
    public int computeVerticalScrollRange() {
        AppMethodBeat.i(107078);
        int height;
        if (this.yzC != null) {
            height = this.yzC.getHeight();
            AppMethodBeat.o(107078);
            return height;
        }
        height = super.computeVerticalScrollRange();
        AppMethodBeat.o(107078);
        return height;
    }

    /* Access modifiers changed, original: protected */
    public int computeVerticalScrollExtent() {
        AppMethodBeat.i(107079);
        int height = (getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
        AppMethodBeat.o(107079);
        return height;
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.i(107080);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CharSequence contentDescription = getContentDescription();
        if (bo.isNullOrNil((String) contentDescription)) {
            contentDescription = getText();
        }
        accessibilityNodeInfo.setText(contentDescription);
        AppMethodBeat.o(107080);
    }

    public void setSingleLine(boolean z) {
        AppMethodBeat.i(107075);
        this.mSingleLine = z;
        if (z) {
            setLines(1);
            AppMethodBeat.o(107075);
            return;
        }
        setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
        AppMethodBeat.o(107075);
    }
}
