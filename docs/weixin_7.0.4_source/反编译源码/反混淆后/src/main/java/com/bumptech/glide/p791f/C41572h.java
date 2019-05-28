package com.bumptech.glide.p791f;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.f.h */
public final class C41572h implements C17553b, C25460c {
    private C17553b aHO;
    private C17553b aHP;
    private final C25460c aHf;
    private boolean isRunning;

    C41572h() {
        this(null);
    }

    public C41572h(C25460c c25460c) {
        this.aHf = c25460c;
    }

    /* renamed from: a */
    public final void mo66599a(C17553b c17553b, C17553b c17553b2) {
        this.aHO = c17553b;
        this.aHP = c17553b2;
    }

    /* renamed from: nM */
    public final boolean mo42502nM() {
        AppMethodBeat.m2504i(92521);
        if (m72785of() || mo31987nL()) {
            AppMethodBeat.m2505o(92521);
            return true;
        }
        AppMethodBeat.m2505o(92521);
        return false;
    }

    /* renamed from: f */
    public final void mo42500f(C17553b c17553b) {
        AppMethodBeat.m2504i(92522);
        if (c17553b.equals(this.aHP)) {
            AppMethodBeat.m2505o(92522);
            return;
        }
        if (this.aHf != null) {
            this.aHf.mo42500f(this);
        }
        if (!this.aHP.isComplete()) {
            this.aHP.clear();
        }
        AppMethodBeat.m2505o(92522);
    }

    /* renamed from: g */
    public final void mo42501g(C17553b c17553b) {
        AppMethodBeat.m2504i(92523);
        if (c17553b.equals(this.aHO)) {
            if (this.aHf != null) {
                this.aHf.mo42501g(this);
            }
            AppMethodBeat.m2505o(92523);
            return;
        }
        AppMethodBeat.m2505o(92523);
    }

    /* renamed from: of */
    private boolean m72785of() {
        AppMethodBeat.m2504i(92524);
        if (this.aHf == null || !this.aHf.mo42502nM()) {
            AppMethodBeat.m2505o(92524);
            return false;
        }
        AppMethodBeat.m2505o(92524);
        return true;
    }

    public final void begin() {
        AppMethodBeat.m2504i(92525);
        this.isRunning = true;
        if (!(this.aHO.isComplete() || this.aHP.isRunning())) {
            this.aHP.begin();
        }
        if (this.isRunning && !this.aHO.isRunning()) {
            this.aHO.begin();
        }
        AppMethodBeat.m2505o(92525);
    }

    public final void pause() {
        AppMethodBeat.m2504i(92526);
        this.isRunning = false;
        this.aHO.pause();
        this.aHP.pause();
        AppMethodBeat.m2505o(92526);
    }

    public final void clear() {
        AppMethodBeat.m2504i(92527);
        this.isRunning = false;
        this.aHP.clear();
        this.aHO.clear();
        AppMethodBeat.m2505o(92527);
    }

    public final boolean isRunning() {
        AppMethodBeat.m2504i(92528);
        boolean isRunning = this.aHO.isRunning();
        AppMethodBeat.m2505o(92528);
        return isRunning;
    }

    public final boolean isComplete() {
        AppMethodBeat.m2504i(92529);
        if (this.aHO.isComplete() || this.aHP.isComplete()) {
            AppMethodBeat.m2505o(92529);
            return true;
        }
        AppMethodBeat.m2505o(92529);
        return false;
    }

    /* renamed from: nL */
    public final boolean mo31987nL() {
        AppMethodBeat.m2504i(92530);
        if (this.aHO.mo31987nL() || this.aHP.mo31987nL()) {
            AppMethodBeat.m2505o(92530);
            return true;
        }
        AppMethodBeat.m2505o(92530);
        return false;
    }

    public final boolean isCancelled() {
        AppMethodBeat.m2504i(92531);
        boolean isCancelled = this.aHO.isCancelled();
        AppMethodBeat.m2505o(92531);
        return isCancelled;
    }

    public final boolean isFailed() {
        AppMethodBeat.m2504i(92532);
        boolean isFailed = this.aHO.isFailed();
        AppMethodBeat.m2505o(92532);
        return isFailed;
    }

    public final void recycle() {
        AppMethodBeat.m2504i(92533);
        this.aHO.recycle();
        this.aHP.recycle();
        AppMethodBeat.m2505o(92533);
    }

    /* renamed from: a */
    public final boolean mo31980a(C17553b c17553b) {
        AppMethodBeat.m2504i(92534);
        if (c17553b instanceof C41572h) {
            C41572h c41572h = (C41572h) c17553b;
            if (this.aHO != null ? this.aHO.mo31980a(c41572h.aHO) : c41572h.aHO == null) {
                if (this.aHP != null ? !this.aHP.mo31980a(c41572h.aHP) : c41572h.aHP != null) {
                    AppMethodBeat.m2505o(92534);
                    return true;
                }
            }
            AppMethodBeat.m2505o(92534);
            return false;
        }
        AppMethodBeat.m2505o(92534);
        return false;
    }

    /* renamed from: b */
    public final boolean mo42497b(C17553b c17553b) {
        boolean z;
        AppMethodBeat.m2504i(92518);
        if (this.aHf == null || this.aHf.mo42497b(this)) {
            z = true;
        } else {
            z = false;
        }
        if (!z || (!c17553b.equals(this.aHO) && this.aHO.mo31987nL())) {
            AppMethodBeat.m2505o(92518);
            return false;
        }
        AppMethodBeat.m2505o(92518);
        return true;
    }

    /* renamed from: c */
    public final boolean mo42498c(C17553b c17553b) {
        boolean z;
        AppMethodBeat.m2504i(92519);
        if (this.aHf == null || this.aHf.mo42498c(this)) {
            z = true;
        } else {
            z = false;
        }
        if (z && c17553b.equals(this.aHO) && !mo42502nM()) {
            AppMethodBeat.m2505o(92519);
            return true;
        }
        AppMethodBeat.m2505o(92519);
        return false;
    }

    /* renamed from: d */
    public final boolean mo42499d(C17553b c17553b) {
        boolean z;
        AppMethodBeat.m2504i(92520);
        if (this.aHf == null || this.aHf.mo42499d(this)) {
            z = true;
        } else {
            z = false;
        }
        if (z && c17553b.equals(this.aHO)) {
            AppMethodBeat.m2505o(92520);
            return true;
        }
        AppMethodBeat.m2505o(92520);
        return false;
    }
}
