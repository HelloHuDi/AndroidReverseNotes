package com.tencent.p177mm.p202bf;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p1180d.C41768d;
import com.tencent.p177mm.audio.p195b.C32304g.C32305a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.tencent.mm.bf.c */
public final class C37511c implements C23499a {
    public BlockingQueue<C32305a> fQA = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    public String mFileName = null;

    /* renamed from: com.tencent.mm.bf.c$1 */
    public class C90741 implements Runnable {

        /* renamed from: com.tencent.mm.bf.c$1$1 */
        class C90731 implements IdleHandler {
            C90731() {
            }

            public final boolean queueIdle() {
                AppMethodBeat.m2504i(116539);
                C4990ab.m7410d("MicroMsg.SpeexEncoderWorker", "queueIdle  ");
                C9077e.ajY().mo20553b(C37511c.this);
                AppMethodBeat.m2505o(116539);
                return false;
            }
        }

        public final void run() {
            AppMethodBeat.m2504i(116540);
            Looper.myQueue().addIdleHandler(new C90731());
            AppMethodBeat.m2505o(116540);
        }
    }

    public C37511c() {
        AppMethodBeat.m2504i(116541);
        AppMethodBeat.m2505o(116541);
    }

    public final boolean acg() {
        return false;
    }

    public final boolean acf() {
        AppMethodBeat.m2504i(116542);
        C4990ab.m7410d("MicroMsg.SpeexEncoderWorker", "doEncode");
        C41768d c41768d = new C41768d();
        String ajO = C32334b.ajO();
        try {
            C4990ab.m7416i("MicroMsg.SpeexEncoderWorker", "path ".concat(String.valueOf(ajO)));
            File file = new File(ajO);
            if (!file.exists()) {
                file.mkdir();
            }
            c41768d.mo43824eo(ajO + this.mFileName + ".temp");
            while (this.fQA.size() > 0) {
                C32305a c32305a = (C32305a) this.fQA.poll();
                if (c32305a.buf != null && c32305a.cqs > 0) {
                    c41768d.mo43823a(c32305a, 0, false);
                }
            }
            c41768d.mo43820Fe();
            try {
                new File(ajO + this.mFileName + ".temp").renameTo(new File(ajO + this.mFileName + ".spx"));
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SpeexEncoderWorker", "exception:%s", C5046bo.m7574l(e));
            }
            C9077e.ajY().start();
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", e2);
        }
        AppMethodBeat.m2505o(116542);
        return true;
    }
}
