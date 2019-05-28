package com.tencent.p177mm.plugin.downloader.p376d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p209c.C45276l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Properties;

/* renamed from: com.tencent.mm.plugin.downloader.d.f */
public final class C45829f {
    private static final C45276l kMe = new C45276l(38650);
    Properties kMf = new Properties();
    byte[] kMg;

    public C45829f() {
        AppMethodBeat.m2504i(2315);
        AppMethodBeat.m2505o(2315);
    }

    static {
        AppMethodBeat.m2504i(2320);
        AppMethodBeat.m2505o(2320);
    }

    /* renamed from: F */
    public final void mo73630F(Map<String, String> map) {
        AppMethodBeat.m2504i(2316);
        this.kMf.putAll(map);
        AppMethodBeat.m2505o(2316);
    }

    /* renamed from: E */
    public final void mo73629E(byte[] bArr) {
        AppMethodBeat.m2504i(2317);
        if (bArr == null) {
            C4990ab.m7420w("MicroMsg.Channel.GameComment", "decode, data is null");
            AppMethodBeat.m2505o(2317);
            return;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        byte[] bArr2 = new byte[2];
        wrap.get(bArr2);
        if (!kMe.equals(new C45276l(bArr2))) {
            C4990ab.m7412e("MicroMsg.Channel.GameComment", "decode, unknow protocol");
        }
        if (bArr.length - 2 <= 2) {
            C4990ab.m7412e("MicroMsg.Channel.GameComment", "decode, data.length - headLength <= 2");
            AppMethodBeat.m2505o(2317);
            return;
        }
        bArr2 = new byte[2];
        wrap.get(bArr2);
        int i = new C45276l(bArr2).value;
        if ((bArr.length - 2) - 2 < i) {
            C4990ab.m7412e("MicroMsg.Channel.GameComment", "decode, cooment content is empty");
            AppMethodBeat.m2505o(2317);
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
        AppMethodBeat.m2505o(2317);
    }

    /* renamed from: AL */
    public final byte[] mo73628AL() {
        byte[] bytes;
        AppMethodBeat.m2504i(2318);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(kMe.getBytes());
            String str = "";
            for (Object next : this.kMf.keySet()) {
                str = str + next + "=" + this.kMf.getProperty((String) next) + IOUtils.LINE_SEPARATOR_WINDOWS;
            }
            bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(new C45276l(bytes.length).getBytes());
            byteArrayOutputStream.write(bytes);
            if (this.kMg != null) {
                byteArrayOutputStream.write(this.kMg);
            }
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.Channel.GameComment", "encode, error: %s", e.getMessage());
        }
        bytes = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(2318);
        return bytes;
    }

    public final String toString() {
        AppMethodBeat.m2504i(2319);
        String str = "GameComment [p=" + this.kMf + ", otherData=" + (this.kMg == null ? "" : new String(this.kMg)) + "]";
        AppMethodBeat.m2505o(2319);
        return str;
    }
}
