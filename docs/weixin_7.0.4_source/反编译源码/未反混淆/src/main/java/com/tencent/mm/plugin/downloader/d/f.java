package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Properties;

public final class f {
    private static final l kMe = new l(38650);
    Properties kMf = new Properties();
    byte[] kMg;

    public f() {
        AppMethodBeat.i(2315);
        AppMethodBeat.o(2315);
    }

    static {
        AppMethodBeat.i(2320);
        AppMethodBeat.o(2320);
    }

    public final void F(Map<String, String> map) {
        AppMethodBeat.i(2316);
        this.kMf.putAll(map);
        AppMethodBeat.o(2316);
    }

    public final void E(byte[] bArr) {
        AppMethodBeat.i(2317);
        if (bArr == null) {
            ab.w("MicroMsg.Channel.GameComment", "decode, data is null");
            AppMethodBeat.o(2317);
            return;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        byte[] bArr2 = new byte[2];
        wrap.get(bArr2);
        if (!kMe.equals(new l(bArr2))) {
            ab.e("MicroMsg.Channel.GameComment", "decode, unknow protocol");
        }
        if (bArr.length - 2 <= 2) {
            ab.e("MicroMsg.Channel.GameComment", "decode, data.length - headLength <= 2");
            AppMethodBeat.o(2317);
            return;
        }
        bArr2 = new byte[2];
        wrap.get(bArr2);
        int i = new l(bArr2).value;
        if ((bArr.length - 2) - 2 < i) {
            ab.e("MicroMsg.Channel.GameComment", "decode, cooment content is empty");
            AppMethodBeat.o(2317);
            return;
        }
        byte[] bArr3 = new byte[i];
        wrap.get(bArr3);
        try {
            this.kMf.load(new InputStreamReader(new ByteArrayInputStream(bArr3), "UTF-8"));
        } catch (IOException e) {
        }
        i = ((bArr.length - 2) - i) - 2;
        if (i > 0) {
            this.kMg = new byte[i];
            wrap.get(this.kMg);
        }
        AppMethodBeat.o(2317);
    }

    public final byte[] AL() {
        byte[] bytes;
        AppMethodBeat.i(2318);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(kMe.getBytes());
            String str = "";
            for (Object next : this.kMf.keySet()) {
                str = str + next + "=" + this.kMf.getProperty((String) next) + IOUtils.LINE_SEPARATOR_WINDOWS;
            }
            bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(new l(bytes.length).getBytes());
            byteArrayOutputStream.write(bytes);
            if (this.kMg != null) {
                byteArrayOutputStream.write(this.kMg);
            }
        } catch (IOException e) {
            ab.e("MicroMsg.Channel.GameComment", "encode, error: %s", e.getMessage());
        }
        bytes = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(2318);
        return bytes;
    }

    public final String toString() {
        AppMethodBeat.i(2319);
        String str = "GameComment [p=" + this.kMf + ", otherData=" + (this.kMg == null ? "" : new String(this.kMg)) + "]";
        AppMethodBeat.o(2319);
        return str;
    }
}
