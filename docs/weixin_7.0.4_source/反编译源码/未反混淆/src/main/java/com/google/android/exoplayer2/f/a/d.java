package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.e;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class d implements e {
    private long bfY;
    private final LinkedList<h> bmv = new LinkedList();
    final LinkedList<i> bmw;
    private final PriorityQueue<h> bmx;
    private h bmy;

    public abstract void a(h hVar);

    public abstract boolean sL();

    public abstract com.google.android.exoplayer2.f.d sM();

    public d() {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            this.bmv.add(new h());
        }
        this.bmw = new LinkedList();
        while (i < 2) {
            this.bmw.add(new e(this));
            i++;
        }
        this.bmx = new PriorityQueue();
    }

    public void ai(long j) {
        this.bfY = j;
    }

    /* renamed from: sQ */
    public h qI() {
        a.checkState(this.bmy == null);
        if (this.bmv.isEmpty()) {
            return null;
        }
        this.bmy = (h) this.bmv.pollFirst();
        return this.bmy;
    }

    /* renamed from: b */
    public void ad(h hVar) {
        a.checkArgument(hVar == this.bmy);
        if (hVar.qF()) {
            c(hVar);
        } else {
            this.bmx.add(hVar);
        }
        this.bmy = null;
    }

    /* renamed from: sP */
    public i qJ() {
        if (this.bmw.isEmpty()) {
            return null;
        }
        while (!this.bmx.isEmpty() && ((h) this.bmx.peek()).aSk <= this.bfY) {
            h hVar = (h) this.bmx.poll();
            i iVar;
            if (hVar.qG()) {
                iVar = (i) this.bmw.pollFirst();
                iVar.dB(4);
                c(hVar);
                return iVar;
            }
            a(hVar);
            if (sL()) {
                com.google.android.exoplayer2.f.d sM = sM();
                if (!hVar.qF()) {
                    iVar = (i) this.bmw.pollFirst();
                    iVar.a(hVar.aSk, sM, Long.MAX_VALUE);
                    c(hVar);
                    return iVar;
                }
            }
            c(hVar);
        }
        return null;
    }

    private void c(h hVar) {
        hVar.clear();
        this.bmv.add(hVar);
    }

    public void flush() {
        this.bfY = 0;
        while (!this.bmx.isEmpty()) {
            c((h) this.bmx.poll());
        }
        if (this.bmy != null) {
            c(this.bmy);
            this.bmy = null;
        }
    }

    public void release() {
    }
}
