package android.support.c.a;

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
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public final class c extends h implements b {
    private Context mContext;
    private a uu;
    private ArgbEvaluator uv;
    private AnimatorListener uw;
    private ArrayList<Object> ux;
    final Callback uy;

    static class a extends ConstantState {
        int mChangingConfigurations;
        i uA;
        AnimatorSet uB;
        ArrayList<Animator> uC;
        android.support.v4.f.a<Animator, String> uD;

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

    static class b extends ConstantState {
        private final ConstantState uE;

        public b(ConstantState constantState) {
            this.uE = constantState;
        }

        public final Drawable newDrawable() {
            c cVar = new c();
            cVar.uJ = this.uE.newDrawable();
            cVar.uJ.setCallback(cVar.uy);
            return cVar;
        }

        public final Drawable newDrawable(Resources resources) {
            c cVar = new c();
            cVar.uJ = this.uE.newDrawable(resources);
            cVar.uJ.setCallback(cVar.uy);
            return cVar;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            c cVar = new c();
            cVar.uJ = this.uE.newDrawable(resources, theme);
            cVar.uJ.setCallback(cVar.uy);
            return cVar;
        }

        public final boolean canApplyTheme() {
            return this.uE.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.uE.getChangingConfigurations();
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

    c() {
        this(null, (byte) 0);
    }

    private c(Context context) {
        this(context, (byte) 0);
    }

    private c(Context context, byte b) {
        this.uv = null;
        this.uw = null;
        this.ux = null;
        this.uy = new Callback() {
            public final void invalidateDrawable(Drawable drawable) {
                c.this.invalidateSelf();
            }

            public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                c.this.scheduleSelf(runnable, j);
            }

            public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                c.this.unscheduleSelf(runnable);
            }
        };
        this.mContext = context;
        this.uu = new a();
    }

    public final Drawable mutate() {
        if (this.uJ != null) {
            this.uJ.mutate();
        }
        return this;
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    public final ConstantState getConstantState() {
        if (this.uJ == null || VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(this.uJ.getConstantState());
    }

    public final int getChangingConfigurations() {
        if (this.uJ != null) {
            return this.uJ.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.uu.mChangingConfigurations;
    }

    public final void draw(Canvas canvas) {
        if (this.uJ != null) {
            this.uJ.draw(canvas);
            return;
        }
        this.uu.uA.draw(canvas);
        if (this.uu.uB.isStarted()) {
            invalidateSelf();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBoundsChange(Rect rect) {
        if (this.uJ != null) {
            this.uJ.setBounds(rect);
        } else {
            this.uu.uA.setBounds(rect);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean onStateChange(int[] iArr) {
        if (this.uJ != null) {
            return this.uJ.setState(iArr);
        }
        return this.uu.uA.setState(iArr);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean onLevelChange(int i) {
        if (this.uJ != null) {
            return this.uJ.setLevel(i);
        }
        return this.uu.uA.setLevel(i);
    }

    public final int getAlpha() {
        if (this.uJ != null) {
            return android.support.v4.a.a.a.c(this.uJ);
        }
        return this.uu.uA.getAlpha();
    }

    public final void setAlpha(int i) {
        if (this.uJ != null) {
            this.uJ.setAlpha(i);
        } else {
            this.uu.uA.setAlpha(i);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.uJ != null) {
            this.uJ.setColorFilter(colorFilter);
        } else {
            this.uu.uA.setColorFilter(colorFilter);
        }
    }

    public final void setTint(int i) {
        if (this.uJ != null) {
            android.support.v4.a.a.a.a(this.uJ, i);
        } else {
            this.uu.uA.setTint(i);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.uJ != null) {
            android.support.v4.a.a.a.a(this.uJ, colorStateList);
        } else {
            this.uu.uA.setTintList(colorStateList);
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.uJ != null) {
            android.support.v4.a.a.a.a(this.uJ, mode);
        } else {
            this.uu.uA.setTintMode(mode);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.uJ != null) {
            return this.uJ.setVisible(z, z2);
        }
        this.uu.uA.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public final boolean isStateful() {
        if (this.uJ != null) {
            return this.uJ.isStateful();
        }
        return this.uu.uA.isStateful();
    }

    public final int getOpacity() {
        if (this.uJ != null) {
            return this.uJ.getOpacity();
        }
        return this.uu.uA.getOpacity();
    }

    public final int getIntrinsicWidth() {
        if (this.uJ != null) {
            return this.uJ.getIntrinsicWidth();
        }
        return this.uu.uA.getIntrinsicWidth();
    }

    public final int getIntrinsicHeight() {
        if (this.uJ != null) {
            return this.uJ.getIntrinsicHeight();
        }
        return this.uu.uA.getIntrinsicHeight();
    }

    public final boolean isAutoMirrored() {
        if (this.uJ != null) {
            return android.support.v4.a.a.a.b(this.uJ);
        }
        return this.uu.uA.isAutoMirrored();
    }

    public final void setAutoMirrored(boolean z) {
        if (this.uJ != null) {
            android.support.v4.a.a.a.a(this.uJ, z);
        } else {
            this.uu.uA.setAutoMirrored(z);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.uJ != null) {
            android.support.v4.a.a.a.a(this.uJ, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a = android.support.v4.content.a.c.a(resources, theme, attributeSet, a.ul);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i a2 = i.a(resources, resourceId, theme);
                        a2.uP = false;
                        a2.setCallback(this.uy);
                        if (this.uu.uA != null) {
                            this.uu.uA.setCallback(null);
                        }
                        this.uu.uA = a2;
                    }
                    a.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.um);
                    String string = obtainAttributes.getString(0);
                    eventType = obtainAttributes.getResourceId(1, 0);
                    if (eventType != 0) {
                        if (this.mContext != null) {
                            Animator loadAnimator;
                            Context context = this.mContext;
                            if (VERSION.SDK_INT >= 24) {
                                loadAnimator = AnimatorInflater.loadAnimator(context, eventType);
                            } else {
                                loadAnimator = e.a(context, context.getResources(), context.getTheme(), eventType);
                            }
                            loadAnimator.setTarget(this.uu.uA.uL.vG.vF.get(string));
                            if (VERSION.SDK_INT < 21) {
                                a(loadAnimator);
                            }
                            if (this.uu.uC == null) {
                                this.uu.uC = new ArrayList();
                                this.uu.uD = new android.support.v4.f.a();
                            }
                            this.uu.uC.add(loadAnimator);
                            this.uu.uD.put(loadAnimator, string);
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
        a aVar = this.uu;
        if (aVar.uB == null) {
            aVar.uB = new AnimatorSet();
        }
        aVar.uB.playTogether(aVar.uC);
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public final void applyTheme(Theme theme) {
        if (this.uJ != null) {
            android.support.v4.a.a.a.a(this.uJ, theme);
        }
    }

    public final boolean canApplyTheme() {
        if (this.uJ != null) {
            return android.support.v4.a.a.a.d(this.uJ);
        }
        return false;
    }

    private void a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            ArrayList childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= childAnimations.size()) {
                        break;
                    }
                    a((Animator) childAnimations.get(i2));
                    i = i2 + 1;
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.uv == null) {
                    this.uv = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.uv);
            }
        }
    }

    public final boolean isRunning() {
        if (this.uJ != null) {
            return ((AnimatedVectorDrawable) this.uJ).isRunning();
        }
        return this.uu.uB.isRunning();
    }

    public final void start() {
        if (this.uJ != null) {
            ((AnimatedVectorDrawable) this.uJ).start();
        } else if (!this.uu.uB.isStarted()) {
            this.uu.uB.start();
            invalidateSelf();
        }
    }

    public final void stop() {
        if (this.uJ != null) {
            ((AnimatedVectorDrawable) this.uJ).stop();
        } else {
            this.uu.uB.end();
        }
    }
}
