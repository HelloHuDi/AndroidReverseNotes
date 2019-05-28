package com.tencent.p177mm.plugin.story.p529a;

import android.animation.AnimatorSet;
import android.support.p057v4.view.C0477s;
import android.view.View;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u000fJ\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH$J\u0006\u0010 \u001a\u00020\u001aJ\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010#\u001a\u00020\u001aJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u000fJ\u000e\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0011J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0011J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u000fJ\u000e\u0010/\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u00100\u001a\u00020\u001aR(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0011\u0010\r\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u00062"}, dWq = {"Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator;", "", "()V", "<set-?>", "Landroid/animation/AnimatorSet;", "animatorAgent", "getAnimatorAgent", "()Landroid/animation/AnimatorSet;", "setAnimatorAgent", "(Landroid/animation/AnimatorSet;)V", "isRunning", "", "()Z", "isStarted", "mDuration", "", "mRepeatMode", "", "mRepeatTimes", "startDelay", "getStartDelay", "()J", "addAnimatorListener", "l", "Landroid/animation/Animator$AnimatorListener;", "animate", "", "cancel", "getDuration", "prepare", "target", "Landroid/view/View;", "removeAllListener", "removeAnimatorListener", "reset", "restart", "setDuration", "duration", "setInterpolator", "interpolator", "Landroid/view/animation/Interpolator;", "setRepeatMode", "repeatMode", "setRepeatTimes", "repeatTimes", "setStartDelay", "delay", "setTarget", "start", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.a.a */
public abstract class C4105a {
    private static final long rQx = 1000;
    public static final C4106a rQy = new C4106a();
    public long mDuration = rQx;
    public AnimatorSet rQu = new AnimatorSet();
    public int rQv;
    public int rQw = 1;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator$Companion;", "", "()V", "DURATION", "", "getDURATION", "()J", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.a.a$a */
    public static final class C4106a {
        private C4106a() {
        }

        public /* synthetic */ C4106a(byte b) {
            this();
        }
    }

    /* renamed from: eb */
    public abstract void mo8977eb(View view);

    /* renamed from: ec */
    public final C4105a mo8978ec(View view) {
        C25052j.m39376p(view, "target");
        C25052j.m39376p(view, "target");
        C0477s.m941e(view, 1.0f);
        C0477s.m943f(view, 1.0f);
        C0477s.m944g(view, 1.0f);
        C0477s.m911ac(view);
        C0477s.m938d(view, 0.0f);
        C0477s.m912ad(view);
        C0477s.m914af(view);
        C0477s.m913ae(view);
        mo8977eb(view);
        return this;
    }
}
