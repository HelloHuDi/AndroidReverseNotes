package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public interface j {

    public static class b {
        public int bJt = -1;
        public byte[] buffer;
        public int cmdId;
        public long fCv;
        public int id;
        public int oqP;
        public long oqQ;
        public String oqR;
        public String oqS;
        public com.tencent.mm.bt.a oqT;

        public b(int i) {
            this.cmdId = i;
        }

        public int getCmdId() {
            return this.cmdId;
        }

        public final com.tencent.mm.bt.a bOI() {
            return this.oqT;
        }

        public final byte[] getBuffer() {
            AppMethodBeat.i(60022);
            if (this.buffer == null && this.oqT != null) {
                try {
                    this.buffer = this.oqT.toByteArray();
                } catch (IOException e) {
                    ab.e("MicroMsg.OpLog.Operation", "summeroplog Operation toByteArray err: " + e.getMessage());
                }
            }
            byte[] bArr = this.buffer;
            AppMethodBeat.o(60022);
            return bArr;
        }
    }

    public static class a extends b {
        private int cmdId;

        public a(int i, com.tencent.mm.bt.a aVar) {
            super(i);
            this.cmdId = i;
            this.oqT = aVar;
        }

        public final int getCmdId() {
            return this.cmdId;
        }
    }
}
