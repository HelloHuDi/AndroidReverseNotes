package com.google.android.exoplayer2.p105f.p798a;

import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C41606e;
import com.google.android.exoplayer2.p105f.C41610h;
import com.google.android.exoplayer2.p105f.C41611i;
import com.google.android.exoplayer2.p111i.C45039a;
import java.util.LinkedList;
import java.util.PriorityQueue;

/* renamed from: com.google.android.exoplayer2.f.a.d */
abstract class C32043d implements C41606e {
    private long bfY;
    private final LinkedList<C41610h> bmv = new LinkedList();
    final LinkedList<C41611i> bmw;
    private final PriorityQueue<C41610h> bmx;
    private C41610h bmy;

    /* renamed from: a */
    public abstract void mo19178a(C41610h c41610h);

    /* renamed from: sL */
    public abstract boolean mo19181sL();

    /* renamed from: sM */
    public abstract C17659d mo19182sM();

    public C32043d() {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            this.bmv.add(new C41610h());
        }
        this.bmw = new LinkedList();
        while (i < 2) {
            this.bmw.add(new C45030e(this));
            i++;
        }
        this.bmx = new PriorityQueue();
    }

    /* renamed from: ai */
    public void mo19179ai(long j) {
        this.bfY = j;
    }

    /* renamed from: sQ */
    public C41610h mo19142qI() {
        C45039a.checkState(this.bmy == null);
        if (this.bmv.isEmpty()) {
            return null;
        }
        this.bmy = (C41610h) this.bmv.pollFirst();
        return this.bmy;
    }

    /* renamed from: b */
    public void mo19140ad(C41610h c41610h) {
        C45039a.checkArgument(c41610h == this.bmy);
        if (c41610h.mo42773qF()) {
            m52078c(c41610h);
        } else {
            this.bmx.add(c41610h);
        }
        this.bmy = null;
    }

    /* renamed from: sP */
    public C41611i mo19143qJ() {
        if (this.bmw.isEmpty()) {
            return null;
        }
        while (!this.bmx.isEmpty() && ((C41610h) this.bmx.peek()).aSk <= this.bfY) {
            C41610h c41610h = (C41610h) this.bmx.poll();
            C41611i c41611i;
            if (c41610h.mo42774qG()) {
                c41611i = (C41611i) this.bmw.pollFirst();
                c41611i.mo42771dB(4);
                m52078c(c41610h);
                return c41611i;
            }
            mo19178a(c41610h);
            if (mo19181sL()) {
                C17659d sM = mo19182sM();
                if (!c41610h.mo42773qF()) {
                    c41611i = (C41611i) this.bmw.pollFirst();
                    c41611i.mo66740a(c41610h.aSk, sM, Long.MAX_VALUE);
                    m52078c(c41610h);
                    return c41611i;
                }
            }
            m52078c(c41610h);
        }
        return null;
    }

    /* renamed from: c */
    private void m52078c(C41610h c41610h) {
        c41610h.clear();
        this.bmv.add(c41610h);
    }

    public void flush() {
        this.bfY = 0;
        while (!this.bmx.isEmpty()) {
            m52078c((C41610h) this.bmx.poll());
        }
        if (this.bmy != null) {
            m52078c(this.bmy);
            this.bmy = null;
        }
    }

    public void release() {
    }
}
