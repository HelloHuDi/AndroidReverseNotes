package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    private static b ikV = null;
    private static String ikW = null;
    private static a ikX = null;
    private static ap ikY = null;

    public interface a {
        void ob(int i);
    }

    private static void stopTimer() {
        AppMethodBeat.i(105584);
        if (ikY != null) {
            ikY.stopTimer();
        }
        ikY = null;
        AppMethodBeat.o(105584);
    }

    public static boolean a(String str, a aVar, int i) {
        AppMethodBeat.i(105585);
        ab.i("MicroMsg.Record.AudioRecorder", JsApiStartRecordVoice.NAME);
        pg(1);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.Record.AudioRecorder", "startRecord, path is null or nil");
            AppMethodBeat.o(105585);
            return false;
        }
        b bVar = new b(com.tencent.mm.compatible.b.c.a.SILK);
        ikV = bVar;
        if (bVar.cpa == com.tencent.mm.compatible.b.c.a.AMR) {
            if (bVar.coY != null) {
                bVar.coY.reset();
            }
        } else if (bVar.cpb != b.b.ERROR) {
            bVar.release();
            bVar.EG();
        }
        ikV.EE();
        ikV.EF();
        ikV.ED();
        ikV.setOutputFile(str);
        ikV.a(new com.tencent.mm.audio.b.b.a() {
            public final void onError() {
                AppMethodBeat.i(105583);
                ab.e("MicroMsg.Record.AudioRecorder", "onError");
                a.pg(-1);
                AppMethodBeat.o(105583);
            }
        });
        try {
            ikV.prepare();
            ikV.start();
            ikX = aVar;
            ikW = str;
            long j = (long) i;
            stopTimer();
            ap apVar = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(105582);
                    a.pg(1);
                    AppMethodBeat.o(105582);
                    return false;
                }
            }, false);
            ikY = apVar;
            apVar.ae(j, j);
            AppMethodBeat.o(105585);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.Record.AudioRecorder", "record prepare, exp = %s", bo.l(e));
            AppMethodBeat.o(105585);
            return false;
        }
    }

    public static void pg(int i) {
        AppMethodBeat.i(105586);
        ab.i("MicroMsg.Record.AudioRecorder", "stopRecord what:%d", Integer.valueOf(i));
        if (bo.isNullOrNil(ikW)) {
            AppMethodBeat.o(105586);
        } else if (ikV == null) {
            ab.i("MicroMsg.Record.AudioRecorder", "sRecorder is null,err");
            AppMethodBeat.o(105586);
        } else {
            ikV.EH();
            ikV.release();
            ikV = null;
            stopTimer();
            ikW = null;
            if (ikX != null) {
                ikX.ob(i);
            }
            ikX = null;
            AppMethodBeat.o(105586);
        }
    }
}
