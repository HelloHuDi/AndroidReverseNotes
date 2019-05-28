package com.tencent.p177mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p651y.C5755b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.Stack;

/* renamed from: com.tencent.mm.cache.b */
public final class C26001b implements C18128d<C5755b> {
    private Stack<C5755b> efp;
    public Stack<C5755b> efq;
    public int efs;

    public final /* synthetic */ void add(Object obj) {
        AppMethodBeat.m2504i(116233);
        C5755b c5755b = (C5755b) obj;
        if (this.efp != null) {
            this.efp.push(c5755b);
        }
        AppMethodBeat.m2505o(116233);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(116226);
        this.efp = new Stack();
        AppMethodBeat.m2505o(116226);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(116227);
        C4990ab.m7416i("MicroMsg.DoodleCache", "[onDestroy]");
        if (this.efp != null) {
            this.efp.clear();
        }
        if (this.efq != null) {
            this.efq.clear();
        }
        AppMethodBeat.m2505o(116227);
    }

    /* renamed from: by */
    public final void mo33619by(boolean z) {
        AppMethodBeat.m2504i(116228);
        C4990ab.m7417i("MicroMsg.DoodleCache", "[onSave] size:%s", Integer.valueOf(this.efp.size()));
        if (this.efq != null) {
            this.efq.clear();
        }
        this.efq = (Stack) this.efp.clone();
        if (z) {
            this.efp.clear();
        }
        AppMethodBeat.m2505o(116228);
    }

    /* renamed from: Je */
    public final void mo33614Je() {
        AppMethodBeat.m2504i(116229);
        C4990ab.m7417i("MicroMsg.DoodleCache", "[onRestore] size:%s", Integer.valueOf(this.efp.size()));
        this.efp.clear();
        if (this.efq != null) {
            C4990ab.m7417i("MicroMsg.DoodleCache", "[onRestore] %s", Integer.valueOf(this.efq.size()));
            this.efp.addAll(this.efq);
        }
        AppMethodBeat.m2505o(116229);
    }

    /* renamed from: a */
    public final void mo33615a(Canvas canvas, boolean z) {
        AppMethodBeat.m2504i(116230);
        if (z) {
            canvas.drawColor(0, Mode.CLEAR);
            Iterator it = this.efp.iterator();
            while (it.hasNext()) {
                ((C5755b) it.next()).draw(canvas);
            }
            AppMethodBeat.m2505o(116230);
            return;
        }
        C5755b c5755b;
        if (this.efp == null || this.efp.size() <= 0) {
            c5755b = null;
        } else {
            c5755b = (C5755b) this.efp.peek();
        }
        if (c5755b != null) {
            c5755b.draw(canvas);
        }
        AppMethodBeat.m2505o(116230);
    }

    /* renamed from: b */
    public final void mo33618b(Canvas canvas) {
        AppMethodBeat.m2504i(116231);
        Iterator it = this.efp.iterator();
        while (it.hasNext()) {
            ((C5755b) it.next()).draw(canvas);
        }
        AppMethodBeat.m2505o(116231);
    }

    /* renamed from: ac */
    public final int mo33616ac(boolean z) {
        AppMethodBeat.m2504i(116232);
        int size;
        if (z) {
            if (this.efp != null) {
                size = this.efp.size();
                AppMethodBeat.m2505o(116232);
                return size;
            }
            AppMethodBeat.m2505o(116232);
            return 0;
        } else if (this.efq != null) {
            size = this.efq.size();
            AppMethodBeat.m2505o(116232);
            return size;
        } else {
            AppMethodBeat.m2505o(116232);
            return 0;
        }
    }

    /* renamed from: CO */
    public final void mo33613CO() {
        this.efs++;
    }

    public final /* synthetic */ Object pop() {
        AppMethodBeat.m2504i(116234);
        if (this.efp.size() <= 0) {
            AppMethodBeat.m2505o(116234);
            return null;
        }
        C5755b c5755b = (C5755b) this.efp.pop();
        AppMethodBeat.m2505o(116234);
        return c5755b;
    }
}
