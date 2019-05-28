package android.support.v4.app;

public final class g {
    final h<?> mHost;

    g(h<?> hVar) {
        this.mHost = hVar;
    }

    public final Fragment findFragmentByWho(String str) {
        return this.mHost.mFragmentManager.findFragmentByWho(str);
    }

    public final void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }

    public final boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions();
    }
}
