package com.bumptech.glide.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements b, c {
    private final c aHf;
    private b aHg;
    private b aHh;

    public a(c cVar) {
        this.aHf = cVar;
    }

    public final void a(b bVar, b bVar2) {
        this.aHg = bVar;
        this.aHh = bVar2;
    }

    public final void begin() {
        AppMethodBeat.i(92450);
        if (!this.aHg.isRunning()) {
            this.aHg.begin();
        }
        AppMethodBeat.o(92450);
    }

    public final void pause() {
        AppMethodBeat.i(92451);
        if (!this.aHg.isFailed()) {
            this.aHg.pause();
        }
        if (this.aHh.isRunning()) {
            this.aHh.pause();
        }
        AppMethodBeat.o(92451);
    }

    public final void clear() {
        AppMethodBeat.i(92452);
        this.aHg.clear();
        if (this.aHh.isRunning()) {
            this.aHh.clear();
        }
        AppMethodBeat.o(92452);
    }

    public final boolean isRunning() {
        AppMethodBeat.i(92453);
        boolean isRunning;
        if (this.aHg.isFailed()) {
            isRunning = this.aHh.isRunning();
            AppMethodBeat.o(92453);
            return isRunning;
        }
        isRunning = this.aHg.isRunning();
        AppMethodBeat.o(92453);
        return isRunning;
    }

    public final boolean isComplete() {
        AppMethodBeat.i(92454);
        boolean isComplete;
        if (this.aHg.isFailed()) {
            isComplete = this.aHh.isComplete();
            AppMethodBeat.o(92454);
            return isComplete;
        }
        isComplete = this.aHg.isComplete();
        AppMethodBeat.o(92454);
        return isComplete;
    }

    public final boolean nL() {
        AppMethodBeat.i(92455);
        boolean nL;
        if (this.aHg.isFailed()) {
            nL = this.aHh.nL();
            AppMethodBeat.o(92455);
            return nL;
        }
        nL = this.aHg.nL();
        AppMethodBeat.o(92455);
        return nL;
    }

    public final boolean isCancelled() {
        AppMethodBeat.i(92456);
        boolean isCancelled;
        if (this.aHg.isFailed()) {
            isCancelled = this.aHh.isCancelled();
            AppMethodBeat.o(92456);
            return isCancelled;
        }
        isCancelled = this.aHg.isCancelled();
        AppMethodBeat.o(92456);
        return isCancelled;
    }

    public final boolean isFailed() {
        AppMethodBeat.i(92457);
        if (this.aHg.isFailed() && this.aHh.isFailed()) {
            AppMethodBeat.o(92457);
            return true;
        }
        AppMethodBeat.o(92457);
        return false;
    }

    public final void recycle() {
        AppMethodBeat.i(92458);
        this.aHg.recycle();
        this.aHh.recycle();
        AppMethodBeat.o(92458);
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(92459);
        if (bVar instanceof a) {
            a aVar = (a) bVar;
            if (this.aHg.a(aVar.aHg) && this.aHh.a(aVar.aHh)) {
                AppMethodBeat.o(92459);
                return true;
            }
            AppMethodBeat.o(92459);
            return false;
        }
        AppMethodBeat.o(92459);
        return false;
    }

    private boolean e(b bVar) {
        AppMethodBeat.i(92463);
        if (bVar.equals(this.aHg) || (this.aHg.isFailed() && bVar.equals(this.aHh))) {
            AppMethodBeat.o(92463);
            return true;
        }
        AppMethodBeat.o(92463);
        return false;
    }

    public final void f(b bVar) {
        AppMethodBeat.i(92465);
        if (this.aHf != null) {
            this.aHf.f(this);
        }
        AppMethodBeat.o(92465);
    }

    public final void g(b bVar) {
        AppMethodBeat.i(92466);
        if (bVar.equals(this.aHh)) {
            if (this.aHf != null) {
                this.aHf.g(this);
            }
            AppMethodBeat.o(92466);
            return;
        }
        if (!this.aHh.isRunning()) {
            this.aHh.begin();
        }
        AppMethodBeat.o(92466);
    }

    public final boolean b(b bVar) {
        boolean z;
        AppMethodBeat.i(92460);
        if (this.aHf == null || this.aHf.b(this)) {
            z = true;
        } else {
            z = false;
        }
        if (z && e(bVar)) {
            AppMethodBeat.o(92460);
            return true;
        }
        AppMethodBeat.o(92460);
        return false;
    }

    public final boolean c(b bVar) {
        boolean z;
        AppMethodBeat.i(92461);
        if (this.aHf == null || this.aHf.c(this)) {
            z = true;
        } else {
            z = false;
        }
        if (z && e(bVar)) {
            AppMethodBeat.o(92461);
            return true;
        }
        AppMethodBeat.o(92461);
        return false;
    }

    public final boolean d(b bVar) {
        boolean z;
        AppMethodBeat.i(92462);
        if (this.aHf == null || this.aHf.d(this)) {
            z = true;
        } else {
            z = false;
        }
        if (z && e(bVar)) {
            AppMethodBeat.o(92462);
            return true;
        }
        AppMethodBeat.o(92462);
        return false;
    }

    public final boolean nM() {
        boolean z;
        AppMethodBeat.i(92464);
        if (this.aHf == null || !this.aHf.nM()) {
            z = false;
        } else {
            z = true;
        }
        if (z || nL()) {
            AppMethodBeat.o(92464);
            return true;
        }
        AppMethodBeat.o(92464);
        return false;
    }
}
