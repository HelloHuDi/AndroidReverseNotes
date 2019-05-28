package com.bumptech.glide.p791f;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.f.a */
public final class C31244a implements C17553b, C25460c {
    private final C25460c aHf;
    private C17553b aHg;
    private C17553b aHh;

    public C31244a(C25460c c25460c) {
        this.aHf = c25460c;
    }

    /* renamed from: a */
    public final void mo51200a(C17553b c17553b, C17553b c17553b2) {
        this.aHg = c17553b;
        this.aHh = c17553b2;
    }

    public final void begin() {
        AppMethodBeat.m2504i(92450);
        if (!this.aHg.isRunning()) {
            this.aHg.begin();
        }
        AppMethodBeat.m2505o(92450);
    }

    public final void pause() {
        AppMethodBeat.m2504i(92451);
        if (!this.aHg.isFailed()) {
            this.aHg.pause();
        }
        if (this.aHh.isRunning()) {
            this.aHh.pause();
        }
        AppMethodBeat.m2505o(92451);
    }

    public final void clear() {
        AppMethodBeat.m2504i(92452);
        this.aHg.clear();
        if (this.aHh.isRunning()) {
            this.aHh.clear();
        }
        AppMethodBeat.m2505o(92452);
    }

    public final boolean isRunning() {
        AppMethodBeat.m2504i(92453);
        boolean isRunning;
        if (this.aHg.isFailed()) {
            isRunning = this.aHh.isRunning();
            AppMethodBeat.m2505o(92453);
            return isRunning;
        }
        isRunning = this.aHg.isRunning();
        AppMethodBeat.m2505o(92453);
        return isRunning;
    }

    public final boolean isComplete() {
        AppMethodBeat.m2504i(92454);
        boolean isComplete;
        if (this.aHg.isFailed()) {
            isComplete = this.aHh.isComplete();
            AppMethodBeat.m2505o(92454);
            return isComplete;
        }
        isComplete = this.aHg.isComplete();
        AppMethodBeat.m2505o(92454);
        return isComplete;
    }

    /* renamed from: nL */
    public final boolean mo31987nL() {
        AppMethodBeat.m2504i(92455);
        boolean nL;
        if (this.aHg.isFailed()) {
            nL = this.aHh.mo31987nL();
            AppMethodBeat.m2505o(92455);
            return nL;
        }
        nL = this.aHg.mo31987nL();
        AppMethodBeat.m2505o(92455);
        return nL;
    }

    public final boolean isCancelled() {
        AppMethodBeat.m2504i(92456);
        boolean isCancelled;
        if (this.aHg.isFailed()) {
            isCancelled = this.aHh.isCancelled();
            AppMethodBeat.m2505o(92456);
            return isCancelled;
        }
        isCancelled = this.aHg.isCancelled();
        AppMethodBeat.m2505o(92456);
        return isCancelled;
    }

    public final boolean isFailed() {
        AppMethodBeat.m2504i(92457);
        if (this.aHg.isFailed() && this.aHh.isFailed()) {
            AppMethodBeat.m2505o(92457);
            return true;
        }
        AppMethodBeat.m2505o(92457);
        return false;
    }

    public final void recycle() {
        AppMethodBeat.m2504i(92458);
        this.aHg.recycle();
        this.aHh.recycle();
        AppMethodBeat.m2505o(92458);
    }

    /* renamed from: a */
    public final boolean mo31980a(C17553b c17553b) {
        AppMethodBeat.m2504i(92459);
        if (c17553b instanceof C31244a) {
            C31244a c31244a = (C31244a) c17553b;
            if (this.aHg.mo31980a(c31244a.aHg) && this.aHh.mo31980a(c31244a.aHh)) {
                AppMethodBeat.m2505o(92459);
                return true;
            }
            AppMethodBeat.m2505o(92459);
            return false;
        }
        AppMethodBeat.m2505o(92459);
        return false;
    }

    /* renamed from: e */
    private boolean m50405e(C17553b c17553b) {
        AppMethodBeat.m2504i(92463);
        if (c17553b.equals(this.aHg) || (this.aHg.isFailed() && c17553b.equals(this.aHh))) {
            AppMethodBeat.m2505o(92463);
            return true;
        }
        AppMethodBeat.m2505o(92463);
        return false;
    }

    /* renamed from: f */
    public final void mo42500f(C17553b c17553b) {
        AppMethodBeat.m2504i(92465);
        if (this.aHf != null) {
            this.aHf.mo42500f(this);
        }
        AppMethodBeat.m2505o(92465);
    }

    /* renamed from: g */
    public final void mo42501g(C17553b c17553b) {
        AppMethodBeat.m2504i(92466);
        if (c17553b.equals(this.aHh)) {
            if (this.aHf != null) {
                this.aHf.mo42501g(this);
            }
            AppMethodBeat.m2505o(92466);
            return;
        }
        if (!this.aHh.isRunning()) {
            this.aHh.begin();
        }
        AppMethodBeat.m2505o(92466);
    }

    /* renamed from: b */
    public final boolean mo42497b(C17553b c17553b) {
        boolean z;
        AppMethodBeat.m2504i(92460);
        if (this.aHf == null || this.aHf.mo42497b(this)) {
            z = true;
        } else {
            z = false;
        }
        if (z && m50405e(c17553b)) {
            AppMethodBeat.m2505o(92460);
            return true;
        }
        AppMethodBeat.m2505o(92460);
        return false;
    }

    /* renamed from: c */
    public final boolean mo42498c(C17553b c17553b) {
        boolean z;
        AppMethodBeat.m2504i(92461);
        if (this.aHf == null || this.aHf.mo42498c(this)) {
            z = true;
        } else {
            z = false;
        }
        if (z && m50405e(c17553b)) {
            AppMethodBeat.m2505o(92461);
            return true;
        }
        AppMethodBeat.m2505o(92461);
        return false;
    }

    /* renamed from: d */
    public final boolean mo42499d(C17553b c17553b) {
        boolean z;
        AppMethodBeat.m2504i(92462);
        if (this.aHf == null || this.aHf.mo42499d(this)) {
            z = true;
        } else {
            z = false;
        }
        if (z && m50405e(c17553b)) {
            AppMethodBeat.m2505o(92462);
            return true;
        }
        AppMethodBeat.m2505o(92462);
        return false;
    }

    /* renamed from: nM */
    public final boolean mo42502nM() {
        boolean z;
        AppMethodBeat.m2504i(92464);
        if (this.aHf == null || !this.aHf.mo42502nM()) {
            z = false;
        } else {
            z = true;
        }
        if (z || mo31987nL()) {
            AppMethodBeat.m2505o(92464);
            return true;
        }
        AppMethodBeat.m2505o(92464);
        return false;
    }
}
