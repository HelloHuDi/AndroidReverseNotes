package com.tencent.mm.kernel.b;

import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.j;
import java.util.HashSet;
import junit.framework.Assert;

public abstract class f implements d {
    private static final String TAG = "MMKernel.Plugin";
    private boolean mConfigured = false;
    private boolean mDependencyMade = false;
    private boolean mInstalled = false;
    private boolean mIsPendingPlugin = false;
    private boolean mMakingDependencies = false;
    private HashSet<c> mPins = new HashSet();

    public void invokeInstalled() {
        this.mInstalled = true;
        installed();
        detectAlias();
    }

    private final void detectAlias() {
        for (Class cls : getClass().getInterfaces()) {
            if (a.class.isAssignableFrom(cls)) {
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

    public void configure(g gVar) {
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
        c RL = h.RT().RL();
        if (!RL.eJA.aG(getClass())) {
            Class cls = h.RT().RL().eJD;
            if (cls != null) {
                dependsOn(cls);
                j.i(TAG, "plugin[%s] not specific any depOn, we using default one [%s]", this, cls);
            }
        }
    }

    public void invokeConfigure(g gVar) {
        configure(gVar);
        this.mConfigured = true;
    }

    public void alias(Class<? extends a> cls) {
        Assert.assertNotNull(cls);
        Assert.assertTrue(cls.isInstance(this));
        h.RT().RL().k(getClass(), cls);
    }

    public synchronized void pin(c cVar) {
        if (!this.mPins.contains(cVar)) {
            this.mPins.add(cVar);
            h.RT().RL().a(cVar.getClass(), new e(cVar));
        }
    }

    public synchronized void unpin(c cVar) {
        if (this.mPins.contains(cVar)) {
            this.mPins.remove(cVar);
            h.RT().RL().L(cVar.getClass());
        }
    }

    /* Access modifiers changed, original: protected */
    public void dependsOnRoot() {
        if (this.mMakingDependencies) {
            h.RT().RL().l(getClass(), getClass());
        } else {
            j.w(TAG, "Ignore this dependency. It's not dependency phase now!", new Object[0]);
        }
    }

    /* Access modifiers changed, original: protected */
    public void dependsOn(Class<? extends a> cls) {
        if (this.mMakingDependencies) {
            h.RT().RL().l(getClass(), cls);
        } else {
            j.w(TAG, "Ignore this dependency. It's not dependency phase now!", new Object[0]);
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
