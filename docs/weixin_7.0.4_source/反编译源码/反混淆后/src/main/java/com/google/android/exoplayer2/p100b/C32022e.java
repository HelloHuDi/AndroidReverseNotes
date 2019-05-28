package com.google.android.exoplayer2.p100b;

import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.exoplayer2.b.e */
public class C32022e extends C25513a {
    public ByteBuffer aEY;
    public final C0835b aSj = new C0835b();
    public long aSk;
    public final int aSl;

    public C32022e(int i) {
        AppMethodBeat.m2504i(94739);
        this.aSl = i;
        AppMethodBeat.m2505o(94739);
    }

    /* renamed from: dD */
    public final void mo52315dD(int i) {
        AppMethodBeat.m2504i(94740);
        if (this.aEY == null) {
            this.aEY = m51999dE(i);
            AppMethodBeat.m2505o(94740);
            return;
        }
        int capacity = this.aEY.capacity();
        int position = this.aEY.position();
        int i2 = position + i;
        if (capacity >= i2) {
            AppMethodBeat.m2505o(94740);
            return;
        }
        ByteBuffer dE = m51999dE(i2);
        if (position > 0) {
            this.aEY.position(0);
            this.aEY.limit(position);
            dE.put(this.aEY);
        }
        this.aEY = dE;
        AppMethodBeat.m2505o(94740);
    }

    /* renamed from: qK */
    public final boolean mo52316qK() {
        AppMethodBeat.m2504i(94741);
        boolean dC = mo42772dC(ErrorDialogData.SUPPRESSED);
        AppMethodBeat.m2505o(94741);
        return dC;
    }

    /* renamed from: qL */
    public final void mo52317qL() {
        AppMethodBeat.m2504i(94742);
        this.aEY.flip();
        AppMethodBeat.m2505o(94742);
    }

    public final void clear() {
        AppMethodBeat.m2504i(94743);
        super.clear();
        if (this.aEY != null) {
            this.aEY.clear();
        }
        AppMethodBeat.m2505o(94743);
    }

    /* renamed from: dE */
    private ByteBuffer m51999dE(int i) {
        AppMethodBeat.m2504i(94744);
        ByteBuffer allocate;
        if (this.aSl == 1) {
            allocate = ByteBuffer.allocate(i);
            AppMethodBeat.m2505o(94744);
            return allocate;
        } else if (this.aSl == 2) {
            allocate = ByteBuffer.allocateDirect(i);
            AppMethodBeat.m2505o(94744);
            return allocate;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Buffer too small (" + (this.aEY == null ? 0 : this.aEY.capacity()) + " < " + i + ")");
            AppMethodBeat.m2505o(94744);
            throw illegalStateException;
        }
    }
}
