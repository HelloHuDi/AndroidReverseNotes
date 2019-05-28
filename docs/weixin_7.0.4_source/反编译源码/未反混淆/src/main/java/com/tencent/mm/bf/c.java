package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.audio.d.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c implements a {
    public BlockingQueue<g.a> fQA = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    public String mFileName = null;

    public c() {
        AppMethodBeat.i(116541);
        AppMethodBeat.o(116541);
    }

    public final boolean acg() {
        return false;
    }

    public final boolean acf() {
        AppMethodBeat.i(116542);
        ab.d("MicroMsg.SpeexEncoderWorker", "doEncode");
        d dVar = new d();
        String ajO = b.ajO();
        try {
            ab.i("MicroMsg.SpeexEncoderWorker", "path ".concat(String.valueOf(ajO)));
            File file = new File(ajO);
            if (!file.exists()) {
                file.mkdir();
            }
            dVar.eo(ajO + this.mFileName + ".temp");
            while (this.fQA.size() > 0) {
                g.a aVar = (g.a) this.fQA.poll();
                if (aVar.buf != null && aVar.cqs > 0) {
                    dVar.a(aVar, 0, false);
                }
            }
            dVar.Fe();
            try {
                new File(ajO + this.mFileName + ".temp").renameTo(new File(ajO + this.mFileName + ".spx"));
            } catch (Exception e) {
                ab.e("MicroMsg.SpeexEncoderWorker", "exception:%s", bo.l(e));
            }
            e.ajY().start();
        } catch (Exception e2) {
            ab.e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", e2);
        }
        AppMethodBeat.o(116542);
        return true;
    }
}
