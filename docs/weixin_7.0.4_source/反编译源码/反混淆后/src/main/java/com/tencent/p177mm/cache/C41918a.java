package com.tencent.p177mm.cache;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p651y.C24186a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Stack;

/* renamed from: com.tencent.mm.cache.a */
public final class C41918a implements C18128d<C24186a> {
    public Stack<C24186a> efp;
    private Stack<C24186a> efq;
    public Matrix efr = new Matrix();
    private int efs;

    public C41918a() {
        AppMethodBeat.m2504i(116215);
        AppMethodBeat.m2505o(116215);
    }

    public final /* synthetic */ void add(Object obj) {
        AppMethodBeat.m2504i(116224);
        mo67565a((C24186a) obj);
        AppMethodBeat.m2505o(116224);
    }

    public final /* synthetic */ Object pop() {
        AppMethodBeat.m2504i(116225);
        C24186a Jf = mo67563Jf();
        AppMethodBeat.m2505o(116225);
        return Jf;
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(116216);
        C4990ab.m7416i("MicroMsg.CropCache", "[onCreate]");
        this.efp = new Stack();
        AppMethodBeat.m2505o(116216);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(116217);
        if (this.efp != null) {
            this.efp.clear();
        }
        if (this.efq != null) {
            this.efq.clear();
        }
        this.efr.reset();
        AppMethodBeat.m2505o(116217);
    }

    /* renamed from: by */
    public final void mo33619by(boolean z) {
        AppMethodBeat.m2504i(116218);
        C4990ab.m7417i("MicroMsg.CropCache", "[onSave] size:%s", Integer.valueOf(this.efp.size()));
        if (this.efq != null) {
            this.efq.clear();
        }
        this.efq = (Stack) this.efp.clone();
        if (z) {
            this.efp.clear();
        }
        AppMethodBeat.m2505o(116218);
    }

    /* renamed from: Je */
    public final void mo33614Je() {
        AppMethodBeat.m2504i(116219);
        C4990ab.m7417i("MicroMsg.CropCache", "[onRestore] size:%s", Integer.valueOf(this.efp.size()));
        this.efp.clear();
        if (this.efq != null) {
            C4990ab.m7417i("MicroMsg.CropCache", "[onRestore] %s", Integer.valueOf(this.efq.size()));
            this.efp.addAll(this.efq);
        }
        AppMethodBeat.m2505o(116219);
    }

    /* renamed from: a */
    public final void mo33615a(Canvas canvas, boolean z) {
    }

    /* renamed from: b */
    public final void mo33618b(Canvas canvas) {
    }

    /* renamed from: Jf */
    public final C24186a mo67563Jf() {
        AppMethodBeat.m2504i(116220);
        if (this.efp.size() <= 0) {
            C4990ab.m7412e("MicroMsg.CropCache", "[pop]");
            AppMethodBeat.m2505o(116220);
            return null;
        }
        C24186a c24186a = (C24186a) this.efp.pop();
        AppMethodBeat.m2505o(116220);
        return c24186a;
    }

    /* renamed from: a */
    public final void mo67565a(C24186a c24186a) {
        AppMethodBeat.m2504i(116221);
        if (this.efp != null) {
            this.efp.push(c24186a);
        }
        AppMethodBeat.m2505o(116221);
    }

    /* renamed from: Jg */
    public final C24186a mo67564Jg() {
        AppMethodBeat.m2504i(116222);
        if (this.efp == null || this.efp.size() <= 0) {
            AppMethodBeat.m2505o(116222);
            return null;
        }
        C24186a c24186a = (C24186a) this.efp.peek();
        AppMethodBeat.m2505o(116222);
        return c24186a;
    }

    /* renamed from: ac */
    public final int mo33616ac(boolean z) {
        AppMethodBeat.m2504i(116223);
        int size;
        if (z) {
            if (this.efp != null) {
                size = this.efp.size();
                AppMethodBeat.m2505o(116223);
                return size;
            }
            AppMethodBeat.m2505o(116223);
            return 0;
        } else if (this.efq != null) {
            size = this.efq.size();
            AppMethodBeat.m2505o(116223);
            return size;
        } else {
            AppMethodBeat.m2505o(116223);
            return 0;
        }
    }

    /* renamed from: CO */
    public final void mo33613CO() {
        this.efs++;
    }
}
