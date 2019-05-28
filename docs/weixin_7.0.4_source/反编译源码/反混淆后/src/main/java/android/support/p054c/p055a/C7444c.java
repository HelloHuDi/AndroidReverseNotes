package android.support.p054c.p055a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.p057v4.content.p062a.C0379c;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.p065f.C6197a;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.c.a.c */
public final class C7444c extends C6164h implements C0231b {
    private Context mContext;
    /* renamed from: uu */
    private C0233a f2024uu;
    /* renamed from: uv */
    private ArgbEvaluator f2025uv;
    /* renamed from: uw */
    private AnimatorListener f2026uw;
    /* renamed from: ux */
    private ArrayList<Object> f2027ux;
    /* renamed from: uy */
    final Callback f2028uy;

    /* renamed from: android.support.c.a.c$1 */
    class C02321 implements Callback {
        C02321() {
        }

        public final void invalidateDrawable(Drawable drawable) {
            C7444c.this.invalidateSelf();
        }

        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            C7444c.this.scheduleSelf(runnable, j);
        }

        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            C7444c.this.unscheduleSelf(runnable);
        }
    }

    /* renamed from: android.support.c.a.c$a */
    static class C0233a extends ConstantState {
        int mChangingConfigurations;
        /* renamed from: uA */
        C7445i f49uA;
        /* renamed from: uB */
        AnimatorSet f50uB;
        /* renamed from: uC */
        ArrayList<Animator> f51uC;
        /* renamed from: uD */
        C6197a<Animator, String> f52uD;

        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public final int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }
    }

    /* renamed from: android.support.c.a.c$b */
    static class C0234b extends ConstantState {
        /* renamed from: uE */
        private final ConstantState f53uE;

        public C0234b(ConstantState constantState) {
            this.f53uE = constantState;
        }

        public final Drawable newDrawable() {
            C7444c c7444c = new C7444c();
            c7444c.f1703uJ = this.f53uE.newDrawable();
            c7444c.f1703uJ.setCallback(c7444c.f2028uy);
            return c7444c;
        }

        public final Drawable newDrawable(Resources resources) {
            C7444c c7444c = new C7444c();
            c7444c.f1703uJ = this.f53uE.newDrawable(resources);
            c7444c.f1703uJ.setCallback(c7444c.f2028uy);
            return c7444c;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            C7444c c7444c = new C7444c();
            c7444c.f1703uJ = this.f53uE.newDrawable(resources, theme);
            c7444c.f1703uJ.setCallback(c7444c.f2028uy);
            return c7444c;
        }

        public final boolean canApplyTheme() {
            return this.f53uE.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.f53uE.getChangingConfigurations();
        }
    }

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    C7444c() {
        this(null, (byte) 0);
    }

    private C7444c(Context context) {
        this(context, (byte) 0);
    }

    private C7444c(Context context, byte b) {
        this.f2025uv = null;
        this.f2026uw = null;
        this.f2027ux = null;
        this.f2028uy = new C02321();
        this.mContext = context;
        this.f2024uu = new C0233a();
    }

    public final Drawable mutate() {
        if (this.f1703uJ != null) {
            this.f1703uJ.mutate();
        }
        return this;
    }

    /* renamed from: a */
    public static C7444c m12686a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C7444c c7444c = new C7444c(context);
        c7444c.inflate(resources, xmlPullParser, attributeSet, theme);
        return c7444c;
    }

    public final ConstantState getConstantState() {
        if (this.f1703uJ == null || VERSION.SDK_INT < 24) {
            return null;
        }
        return new C0234b(this.f1703uJ.getConstantState());
    }

    public final int getChangingConfigurations() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f2024uu.mChangingConfigurations;
    }

    public final void draw(Canvas canvas) {
        if (this.f1703uJ != null) {
            this.f1703uJ.draw(canvas);
            return;
        }
        this.f2024uu.f49uA.draw(canvas);
        if (this.f2024uu.f50uB.isStarted()) {
            invalidateSelf();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBoundsChange(Rect rect) {
        if (this.f1703uJ != null) {
            this.f1703uJ.setBounds(rect);
        } else {
            this.f2024uu.f49uA.setBounds(rect);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean onStateChange(int[] iArr) {
        if (this.f1703uJ != null) {
            return this.f1703uJ.setState(iArr);
        }
        return this.f2024uu.f49uA.setState(iArr);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean onLevelChange(int i) {
        if (this.f1703uJ != null) {
            return this.f1703uJ.setLevel(i);
        }
        return this.f2024uu.f49uA.setLevel(i);
    }

    public final int getAlpha() {
        if (this.f1703uJ != null) {
            return C0280a.m464c(this.f1703uJ);
        }
        return this.f2024uu.f49uA.getAlpha();
    }

    public final void setAlpha(int i) {
        if (this.f1703uJ != null) {
            this.f1703uJ.setAlpha(i);
        } else {
            this.f2024uu.f49uA.setAlpha(i);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f1703uJ != null) {
            this.f1703uJ.setColorFilter(colorFilter);
        } else {
            this.f2024uu.f49uA.setColorFilter(colorFilter);
        }
    }

    public final void setTint(int i) {
        if (this.f1703uJ != null) {
            C0280a.m455a(this.f1703uJ, i);
        } else {
            this.f2024uu.f49uA.setTint(i);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.f1703uJ != null) {
            C0280a.m457a(this.f1703uJ, colorStateList);
        } else {
            this.f2024uu.f49uA.setTintList(colorStateList);
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.f1703uJ != null) {
            C0280a.m460a(this.f1703uJ, mode);
        } else {
            this.f2024uu.f49uA.setTintMode(mode);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.f1703uJ != null) {
            return this.f1703uJ.setVisible(z, z2);
        }
        this.f2024uu.f49uA.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public final boolean isStateful() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.isStateful();
        }
        return this.f2024uu.f49uA.isStateful();
    }

    public final int getOpacity() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.getOpacity();
        }
        return this.f2024uu.f49uA.getOpacity();
    }

    public final int getIntrinsicWidth() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.getIntrinsicWidth();
        }
        return this.f2024uu.f49uA.getIntrinsicWidth();
    }

    public final int getIntrinsicHeight() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.getIntrinsicHeight();
        }
        return this.f2024uu.f49uA.getIntrinsicHeight();
    }

    public final boolean isAutoMirrored() {
        if (this.f1703uJ != null) {
            return C0280a.m462b(this.f1703uJ);
        }
        return this.f2024uu.f49uA.isAutoMirrored();
    }

    public final void setAutoMirrored(boolean z) {
        if (this.f1703uJ != null) {
            C0280a.m461a(this.f1703uJ, z);
        } else {
            this.f2024uu.f49uA.setAutoMirrored(z);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.f1703uJ != null) {
            C0280a.m459a(this.f1703uJ, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a = C0379c.m638a(resources, theme, attributeSet, C0230a.f40ul);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C7445i a2 = C7445i.m12689a(resources, resourceId, theme);
                        a2.f2034uP = false;
                        a2.setCallback(this.f2028uy);
                        if (this.f2024uu.f49uA != null) {
                            this.f2024uu.f49uA.setCallback(null);
                        }
                        this.f2024uu.f49uA = a2;
                    }
                    a.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, C0230a.f41um);
                    String string = obtainAttributes.getString(0);
                    eventType = obtainAttributes.getResourceId(1, 0);
                    if (eventType != 0) {
                        if (this.mContext != null) {
                            Animator loadAnimator;
                            Context context = this.mContext;
                            if (VERSION.SDK_INT >= 24) {
                                loadAnimator = AnimatorInflater.loadAnimator(context, eventType);
                            } else {
                                loadAnimator = C0237e.m348a(context, context.getResources(), context.getTheme(), eventType);
                            }
                            loadAnimator.setTarget(this.f2024uu.f49uA.f2030uL.f85vG.f76vF.get(string));
                            if (VERSION.SDK_INT < 21) {
                                m12687a(loadAnimator);
                            }
                            if (this.f2024uu.f51uC == null) {
                                this.f2024uu.f51uC = new ArrayList();
                                this.f2024uu.f52uD = new C6197a();
                            }
                            this.f2024uu.f51uC.add(loadAnimator);
                            this.f2024uu.f52uD.put(loadAnimator, string);
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        C0233a c0233a = this.f2024uu;
        if (c0233a.f50uB == null) {
            c0233a.f50uB = new AnimatorSet();
        }
        c0233a.f50uB.playTogether(c0233a.f51uC);
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public final void applyTheme(Theme theme) {
        if (this.f1703uJ != null) {
            C0280a.m458a(this.f1703uJ, theme);
        }
    }

    public final boolean canApplyTheme() {
        if (this.f1703uJ != null) {
            return C0280a.m465d(this.f1703uJ);
        }
        return false;
    }

    /* renamed from: a */
    private void m12687a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            ArrayList childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= childAnimations.size()) {
                        break;
                    }
                    m12687a((Animator) childAnimations.get(i2));
                    i = i2 + 1;
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f2025uv == null) {
                    this.f2025uv = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f2025uv);
            }
        }
    }

    public final boolean isRunning() {
        if (this.f1703uJ != null) {
            return ((AnimatedVectorDrawable) this.f1703uJ).isRunning();
        }
        return this.f2024uu.f50uB.isRunning();
    }

    public final void start() {
        if (this.f1703uJ != null) {
            ((AnimatedVectorDrawable) this.f1703uJ).start();
        } else if (!this.f2024uu.f50uB.isStarted()) {
            this.f2024uu.f50uB.start();
            invalidateSelf();
        }
    }

    public final void stop() {
        if (this.f1703uJ != null) {
            ((AnimatedVectorDrawable) this.f1703uJ).stop();
        } else {
            this.f2024uu.f50uB.end();
        }
    }
}
