package com.tencent.p177mm.kernel.p241b;

import com.tencent.p177mm.kernel.C1699c;
import com.tencent.p177mm.kernel.C1728h;
import com.tencent.p177mm.kernel.C1736j;
import com.tencent.p177mm.kernel.p242c.C6625e;
import java.util.HashSet;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.kernel.b.f */
public abstract class C7597f implements C7481d {
    private static final String TAG = "MMKernel.Plugin";
    private boolean mConfigured = false;
    private boolean mDependencyMade = false;
    private boolean mInstalled = false;
    private boolean mIsPendingPlugin = false;
    private boolean mMakingDependencies = false;
    private HashSet<C6617c> mPins = new HashSet();

    public void invokeInstalled() {
        this.mInstalled = true;
        installed();
        detectAlias();
    }

    private final void detectAlias() {
        for (Class cls : getClass().getInterfaces()) {
            if (C1677a.class.isAssignableFrom(cls)) {
                alias(cls);
            }
        }
    }

    public void markAsPendingPlugin() {
        this.mIsPendingPlugin = true;
    }

    public boolean isPendingPlugin() {
        return this.mIsPendingPlugin;
    }

    public void installed() {
    }

    public void dependency() {
    }

    public void configure(C1681g c1681g) {
    }

    public void uninstalled() {
        this.mConfigured = false;
        this.mInstalled = false;
    }

    public void invokeDependency() {
        this.mMakingDependencies = true;
        dependency();
        checkIfNeedDefaultDependency();
        this.mDependencyMade = true;
        this.mMakingDependencies = false;
    }

    private void checkIfNeedDefaultDependency() {
        C1699c RL = C1728h.m3566RT().mo5265RL();
        if (!RL.eJA.mo5119aG(getClass())) {
            Class cls = C1728h.m3566RT().mo5265RL().eJD;
            if (cls != null) {
                dependsOn(cls);
                C1736j.m3587i(TAG, "plugin[%s] not specific any depOn, we using default one [%s]", this, cls);
            }
        }
    }

    public void invokeConfigure(C1681g c1681g) {
        configure(c1681g);
        this.mConfigured = true;
    }

    public void alias(Class<? extends C1677a> cls) {
        Assert.assertNotNull(cls);
        Assert.assertTrue(cls.isInstance(this));
        C1728h.m3566RT().mo5265RL().mo5220k(getClass(), cls);
    }

    public synchronized void pin(C6617c c6617c) {
        if (!this.mPins.contains(c6617c)) {
            this.mPins.add(c6617c);
            C1728h.m3566RT().mo5265RL().mo5219a(c6617c.getClass(), new C6625e(c6617c));
        }
    }

    public synchronized void unpin(C6617c c6617c) {
        if (this.mPins.contains(c6617c)) {
            this.mPins.remove(c6617c);
            C1728h.m3566RT().mo5265RL().mo5215L(c6617c.getClass());
        }
    }

    /* Access modifiers changed, original: protected */
    public void dependsOnRoot() {
        if (this.mMakingDependencies) {
            C1728h.m3566RT().mo5265RL().mo5221l(getClass(), getClass());
        } else {
            C1736j.m3590w(TAG, "Ignore this dependency. It's not dependency phase now!", new Object[0]);
        }
    }

    /* Access modifiers changed, original: protected */
    public void dependsOn(Class<? extends C1677a> cls) {
        if (this.mMakingDependencies) {
            C1728h.m3566RT().mo5265RL().mo5221l(getClass(), cls);
        } else {
            C1736j.m3590w(TAG, "Ignore this dependency. It's not dependency phase now!", new Object[0]);
        }
    }

    public String identify() {
        return getClass().getSimpleName();
    }

    public boolean isConfigured() {
        return this.mConfigured;
    }

    public boolean isDependencyMade() {
        return this.mDependencyMade;
    }

    public String name() {
        return toString();
    }

    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(super.hashCode());
    }

    public String[] ofProcesses() {
        return new String[0];
    }

    public int hashCode() {
        return name().hashCode();
    }
}
