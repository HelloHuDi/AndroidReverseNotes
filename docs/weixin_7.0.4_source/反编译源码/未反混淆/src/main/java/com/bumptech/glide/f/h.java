package com.bumptech.glide.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h implements b, c {
    private b aHO;
    private b aHP;
    private final c aHf;
    private boolean isRunning;

    h() {
        this(null);
    }

    public h(c cVar) {
        this.aHf = cVar;
    }

    public final void a(b bVar, b bVar2) {
        this.aHO = bVar;
        this.aHP = bVar2;
    }

    public final boolean nM() {
        AppMethodBeat.i(92521);
        if (of() || nL()) {
            AppMethodBeat.o(92521);
            return true;
        }
        AppMethodBeat.o(92521);
        return false;
    }

    public final void f(b bVar) {
        AppMethodBeat.i(92522);
        if (bVar.equals(this.aHP)) {
            AppMethodBeat.o(92522);
            return;
        }
        if (this.aHf != null) {
            this.aHf.f(this);
        }
        if (!this.aHP.isComplete()) {
            this.aHP.clear();
        }
        AppMethodBeat.o(92522);
    }

    public final void g(b bVar) {
        AppMethodBeat.i(92523);
        if (bVar.equals(this.aHO)) {
            if (this.aHf != null) {
                this.aHf.g(this);
            }
            AppMethodBeat.o(92523);
            return;
        }
        AppMethodBeat.o(92523);
    }

    private boolean of() {
        AppMethodBeat.i(92524);
        if (this.aHf == null || !this.aHf.nM()) {
            AppMethodBeat.o(92524);
            return false;
        }
        AppMethodBeat.o(92524);
        return true;
    }

    public final void begin() {
        AppMethodBeat.i(92525);
        this.isRunning = true;
        if (!(this.aHO.isComplete() || this.aHP.isRunning())) {
            this.aHP.begin();
        }
        if (this.isRunning && !this.aHO.isRunning()) {
            this.aHO.begin();
        }
        AppMethodBeat.o(92525);
    }

    public final void pause() {
        AppMethodBeat.i(92526);
        this.isRunning = false;
        this.aHO.pause();
        this.aHP.pause();
        AppMethodBeat.o(92526);
    }

    public final void clear() {
        AppMethodBeat.i(92527);
        this.isRunning = false;
        this.aHP.clear();
        this.aHO.clear();
        AppMethodBeat.o(92527);
    }

    public final boolean isRunning() {
        AppMethodBeat.i(92528);
        boolean isRunning = this.aHO.isRunning();
        AppMethodBeat.o(92528);
        return isRunning;
    }

    public final boolean isComplete() {
        AppMethodBeat.i(92529);
        if (this.aHO.isComplete() || this.aHP.isComplete()) {
            AppMethodBeat.o(92529);
            return true;
        }
        AppMethodBeat.o(92529);
        return false;
    }

    public final boolean nL() {
        AppMethodBeat.i(92530);
        if (this.aHO.nL() || this.aHP.nL()) {
            AppMethodBeat.o(92530);
            return true;
        }
        AppMethodBeat.o(92530);
        return false;
    }

    public final boolean isCancelled() {
        AppMethodBeat.i(92531);
        boolean isCancelled = this.aHO.isCancelled();
        AppMethodBeat.o(92531);
        return isCancelled;
    }

    public final boolean isFailed() {
        AppMethodBeat.i(92532);
        boolean isFailed = this.aHO.isFailed();
        AppMethodBeat.o(92532);
        return isFailed;
    }

    public final void recycle() {
        AppMethodBeat.i(92533);
        this.aHO.recycle();
        this.aHP.recycle();
        AppMethodBeat.o(92533);
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(92534);
        if (bVar instanceof h) {
            h hVar = (h) bVar;
            if (this.aHO != null ? this.aHO.a(hVar.aHO) : hVar.aHO == null) {
                if (this.aHP != null ? !this.aHP.a(hVar.aHP) : hVar.aHP != null) {
                    AppMethodBeat.o(92534);
                    return true;
                }
            }
            AppMethodBeat.o(92534);
            return false;
        }
        AppMethodBeat.o(92534);
        return false;
    }

    public final boolean b(b bVar) {
        boolean z;
        AppMethodBeat.i(92518);
        if (this.aHf == null || this.aHf.b(this)) {
            z = true;
        } else {
            z = false;
        }
        if (!z || (!bVar.equals(this.aHO) && this.aHO.nL())) {
            AppMethodBeat.o(92518);
            return false;
        }
        AppMethodBeat.o(92518);
        return true;
    }

    public final boolean c(b bVar) {
        boolean z;
        AppMethodBeat.i(92519);
        if (this.aHf == null || this.aHf.c(this)) {
            z = true;
        } else {
            z = false;
        }
        if (z && bVar.equals(this.aHO) && !nM()) {
            AppMethodBeat.o(92519);
            return true;
        }
        AppMethodBeat.o(92519);
        return false;
    }

    public final boolean d(b bVar) {
        boolean z;
        AppMethodBeat.i(92520);
        if (this.aHf == null || this.aHf.d(this)) {
            z = true;
        } else {
            z = false;
        }
        if (z && bVar.equals(this.aHO)) {
            AppMethodBeat.o(92520);
            return true;
        }
        AppMethodBeat.o(92520);
        return false;
    }
}
