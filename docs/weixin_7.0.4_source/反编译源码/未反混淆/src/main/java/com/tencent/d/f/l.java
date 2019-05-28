package com.tencent.d.f;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class l {
    static HashMap<String, byte[]> AuE = null;
    protected String AuA = "UTF-8";
    protected RequestPacket AuB = new RequestPacket();
    protected HashMap<String, byte[]> AuC = new HashMap();
    private HashMap<String, Object> AuD = new HashMap();

    public l() {
        AppMethodBeat.i(114622);
        AppMethodBeat.o(114622);
    }

    public final void atW(String str) {
        this.AuA = str;
    }

    public final void atX(String str) {
        this.AuB.sServantName = str;
    }

    public final void atY(String str) {
        this.AuB.sFuncName = str;
    }

    public final void dQJ() {
        this.AuB.iRequestId = 3;
    }

    public final <T> void put(String str, T t) {
        AppMethodBeat.i(114623);
        if (str.startsWith(".") || t == null || (t instanceof Set)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("wup put err");
            AppMethodBeat.o(114623);
            throw illegalArgumentException;
        }
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding(this.AuA);
        jceOutputStream.write((Object) t, 0);
        this.AuC.put(str, JceUtil.getJceBufArray(jceOutputStream.getByteBuffer()));
        AppMethodBeat.o(114623);
    }

    public final byte[] AL() {
        AppMethodBeat.i(114624);
        if (this.AuB.sServantName == null) {
            this.AuB.sServantName = "";
        }
        if (this.AuB.sFuncName == null) {
            this.AuB.sFuncName = "";
        }
        JceOutputStream jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.AuA);
        jceOutputStream.write(this.AuC, 0);
        this.AuB.sBuffer = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.AuA);
        this.AuB.writeTo(jceOutputStream);
        byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        int length = jceBufArray.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(jceBufArray).flip();
        jceBufArray = allocate.array();
        AppMethodBeat.o(114624);
        return jceBufArray;
    }
}
