package android.support.p057v4.app;

/* renamed from: android.support.v4.app.g */
public final class C0332g {
    final C6186h<?> mHost;

    C0332g(C6186h<?> c6186h) {
        this.mHost = c6186h;
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
