package com.tencent.p177mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C9035b;
import com.tencent.p177mm.audio.p195b.C9035b.C9038b;
import com.tencent.p177mm.audio.p195b.C9035b.C9039a;
import com.tencent.p177mm.compatible.p219b.C18168c.C18169a;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.appbrand.media.record.a */
public final class C27199a {
    private static C9035b ikV = null;
    private static String ikW = null;
    private static C27197a ikX = null;
    private static C7564ap ikY = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.a$2 */
    static class C106242 implements C9039a {
        C106242() {
        }

        public final void onError() {
            AppMethodBeat.m2504i(105583);
            C4990ab.m7412e("MicroMsg.Record.AudioRecorder", "onError");
            C27199a.m43218pg(-1);
            AppMethodBeat.m2505o(105583);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.a$a */
    public interface C27197a {
        /* renamed from: ob */
        void mo44863ob(int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.a$1 */
    static class C272001 implements C5015a {
        C272001() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(105582);
            C27199a.m43218pg(1);
            AppMethodBeat.m2505o(105582);
            return false;
        }
    }

    private static void stopTimer() {
        AppMethodBeat.m2504i(105584);
        if (ikY != null) {
            ikY.stopTimer();
        }
        ikY = null;
        AppMethodBeat.m2505o(105584);
    }

    /* renamed from: a */
    public static boolean m43217a(String str, C27197a c27197a, int i) {
        AppMethodBeat.m2504i(105585);
        C4990ab.m7416i("MicroMsg.Record.AudioRecorder", JsApiStartRecordVoice.NAME);
        C27199a.m43218pg(1);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.Record.AudioRecorder", "startRecord, path is null or nil");
            AppMethodBeat.m2505o(105585);
            return false;
        }
        C9035b c9035b = new C9035b(C18169a.SILK);
        ikV = c9035b;
        if (c9035b.cpa == C18169a.AMR) {
            if (c9035b.coY != null) {
                c9035b.coY.reset();
            }
        } else if (c9035b.cpb != C9038b.ERROR) {
            c9035b.release();
            c9035b.mo20471EG();
        }
        ikV.mo20469EE();
        ikV.mo20470EF();
        ikV.mo20468ED();
        ikV.setOutputFile(str);
        ikV.mo20473a(new C106242());
        try {
            ikV.prepare();
            ikV.start();
            ikX = c27197a;
            ikW = str;
            long j = (long) i;
            C27199a.stopTimer();
            C7564ap c7564ap = new C7564ap(new C272001(), false);
            ikY = c7564ap;
            c7564ap.mo16770ae(j, j);
            AppMethodBeat.m2505o(105585);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Record.AudioRecorder", "record prepare, exp = %s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(105585);
            return false;
        }
    }

    /* renamed from: pg */
    public static void m43218pg(int i) {
        AppMethodBeat.m2504i(105586);
        C4990ab.m7417i("MicroMsg.Record.AudioRecorder", "stopRecord what:%d", Integer.valueOf(i));
        if (C5046bo.isNullOrNil(ikW)) {
            AppMethodBeat.m2505o(105586);
        } else if (ikV == null) {
            C4990ab.m7416i("MicroMsg.Record.AudioRecorder", "sRecorder is null,err");
            AppMethodBeat.m2505o(105586);
        } else {
            ikV.mo20472EH();
            ikV.release();
            ikV = null;
            C27199a.stopTimer();
            ikW = null;
            if (ikX != null) {
                ikX.mo44863ob(i);
            }
            ikX = null;
            AppMethodBeat.m2505o(105586);
        }
    }
}
