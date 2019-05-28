package com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.messenger.foundation.a.a.j */
public interface C3464j {

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.a.a.j$b */
    public static class C3463b {
        public int bJt = -1;
        public byte[] buffer;
        public int cmdId;
        public long fCv;
        /* renamed from: id */
        public int f1272id;
        public int oqP;
        public long oqQ;
        public String oqR;
        public String oqS;
        public C1331a oqT;

        public C3463b(int i) {
            this.cmdId = i;
        }

        public int getCmdId() {
            return this.cmdId;
        }

        public final C1331a bOI() {
            return this.oqT;
        }

        public final byte[] getBuffer() {
            AppMethodBeat.m2504i(60022);
            if (this.buffer == null && this.oqT != null) {
                try {
                    this.buffer = this.oqT.toByteArray();
                } catch (IOException e) {
                    C4990ab.m7412e("MicroMsg.OpLog.Operation", "summeroplog Operation toByteArray err: " + e.getMessage());
                }
            }
            byte[] bArr = this.buffer;
            AppMethodBeat.m2505o(60022);
            return bArr;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.a.a.j$a */
    public static class C3465a extends C3463b {
        private int cmdId;

        public C3465a(int i, C1331a c1331a) {
            super(i);
            this.cmdId = i;
            this.oqT = c1331a;
        }

        public final int getCmdId() {
            return this.cmdId;
        }
    }
}
