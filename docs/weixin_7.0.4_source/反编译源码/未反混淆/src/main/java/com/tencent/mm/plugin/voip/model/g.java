package com.tencent.mm.plugin.voip.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class g {
    public int sOC = 0;

    public static byte[] F(InputStream inputStream) {
        int i = 0;
        AppMethodBeat.i(4355);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        j jVar = new j(inputStream, byteArrayOutputStream);
        jVar.FY(8);
        jVar.FY(8);
        jVar.FY(8);
        jVar.FY(8);
        jVar.FY(8);
        int cIx = (int) jVar.cIx();
        jVar.FY(8);
        jVar.cIx();
        jVar.cIB();
        if (cIx == 100 || cIx == 110 || cIx == 122 || cIx == 144) {
            if (jVar.cIA() == 3) {
                jVar.FY(1);
            }
            jVar.cIB();
            jVar.cIB();
            jVar.FY(1);
            if (jVar.ml(true)) {
                for (cIx = 0; cIx < 8; cIx++) {
                    if (jVar.ml(true)) {
                        if (cIx < 6) {
                            jVar.FZ(16);
                        } else {
                            jVar.FZ(64);
                        }
                    }
                }
            }
        }
        jVar.cIB();
        cIx = jVar.cIA();
        if (cIx == 0) {
            jVar.cIB();
        } else if (cIx == 1) {
            jVar.FY(1);
            jVar.cIB();
            jVar.cIB();
            int cIA = jVar.cIA();
            for (cIx = 0; cIx < cIA; cIx++) {
                new StringBuilder("SPS: offsetForRefFrame [").append(cIx).append("]");
                jVar.cIB();
            }
        }
        jVar.cIB();
        jVar.FY(1);
        jVar.cIB();
        jVar.cIB();
        if (!jVar.ml(true)) {
            jVar.FY(1);
        }
        jVar.FY(1);
        if (jVar.ml(true)) {
            jVar.cIB();
            jVar.cIB();
            jVar.cIB();
            jVar.cIB();
        }
        if (jVar.ml(false)) {
            ab.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! modify max_dec_frame_buffering");
            jVar.mn(true);
            if (jVar.ml(true) && ((int) jVar.cIx()) == 255) {
                jVar.FY(16);
                jVar.FY(16);
            }
            if (jVar.ml(true)) {
                jVar.FY(1);
            }
            if (jVar.ml(true)) {
                jVar.FY(3);
                jVar.FY(1);
                if (jVar.ml(true)) {
                    jVar.FY(8);
                    jVar.FY(8);
                    jVar.FY(8);
                }
            }
            if (jVar.ml(true)) {
                jVar.cIB();
                jVar.cIB();
            }
            if (jVar.ml(true)) {
                jVar.FY(32);
                jVar.FY(32);
                jVar.FY(1);
            }
            boolean ml = jVar.ml(true);
            if (ml) {
                a(jVar);
            }
            boolean ml2 = jVar.ml(true);
            if (ml2) {
                a(jVar);
            }
            if (ml || ml2) {
                jVar.FY(1);
            }
            jVar.FY(1);
            if (jVar.ml(false)) {
                ab.d("TAG", "steve:VUI has bs restriction!!");
                jVar.mn(true);
                jVar.ml(true);
                jVar.cIB();
                jVar.cIB();
                jVar.cIB();
                jVar.cIB();
                jVar.cIB();
                jVar.Gc(1);
            } else {
                ab.d("TAG", "steve:VUI has NO bs restriction!!");
                jVar.mn(true);
                jVar.mn(true);
                jVar.Gc(0);
                jVar.Gc(0);
                jVar.Gc(10);
                jVar.Gc(10);
                jVar.Gc(0);
                jVar.Gc(1);
            }
        } else {
            ab.d("[H264SPSModifier]", "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering");
            jVar.mn(true);
            jVar.mn(false);
            jVar.mn(false);
            jVar.mn(false);
            jVar.mn(false);
            jVar.mn(false);
            jVar.mn(false);
            jVar.mn(false);
            jVar.mn(false);
            jVar.mn(true);
            jVar.mn(true);
            jVar.Gc(0);
            jVar.Gc(0);
            jVar.Gc(10);
            jVar.Gc(10);
            jVar.Gc(0);
            jVar.Gc(1);
        }
        jVar.Ga(1);
        jVar.G(0, 8 - jVar.sOK);
        jVar.flush();
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        String str = "";
        while (i < toByteArray.length) {
            String toHexString = Integer.toHexString(toByteArray[i] & 255);
            if (toHexString.length() == 1) {
                toHexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(toHexString));
            }
            str = str + " " + toHexString;
            i++;
        }
        ab.d("TAG", "new SPS:".concat(String.valueOf(str)));
        AppMethodBeat.o(4355);
        return toByteArray;
    }

    public final boolean G(InputStream inputStream) {
        AppMethodBeat.i(4356);
        j jVar = new j(inputStream);
        jVar.FX(8);
        jVar.FX(8);
        jVar.FX(8);
        jVar.FX(8);
        jVar.FX(8);
        int cIx = (int) jVar.cIx();
        if (cIx == 66) {
            this.sOC |= 1;
            AppMethodBeat.o(4356);
            return false;
        }
        jVar.FX(8);
        jVar.cIx();
        jVar.cIz();
        if (cIx == 100 || cIx == 110 || cIx == 122 || cIx == 144) {
            if (jVar.cIA() == 3) {
                jVar.FX(1);
            }
            jVar.cIz();
            jVar.cIz();
            jVar.FX(1);
            if (jVar.ml(true)) {
                for (cIx = 0; cIx < 8; cIx++) {
                    if (jVar.ml(true)) {
                        if (cIx < 6) {
                            jVar.FZ(16);
                        } else {
                            jVar.FZ(64);
                        }
                    }
                }
            }
        }
        jVar.cIz();
        cIx = jVar.cIA();
        if (cIx == 0) {
            jVar.cIz();
        } else if (cIx == 1) {
            jVar.FX(1);
            jVar.cIz();
            jVar.cIz();
            int cIA = jVar.cIA();
            for (cIx = 0; cIx < cIA; cIx++) {
                new StringBuilder("SPS: offsetForRefFrame [").append(cIx).append("]");
                jVar.cIB();
            }
        }
        if (jVar.cIA() >= 2) {
            this.sOC |= 2;
        }
        jVar.FY(1);
        jVar.cIB();
        jVar.cIB();
        if (!jVar.ml(true)) {
            jVar.FY(1);
        }
        jVar.FY(1);
        if (jVar.ml(true)) {
            jVar.cIB();
            jVar.cIB();
            jVar.cIB();
            jVar.cIB();
        }
        if (jVar.ml(true)) {
            ab.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! read num_reorder_frames");
            if (jVar.ml(true) && ((int) jVar.cIx()) == 255) {
                jVar.FY(16);
                jVar.FY(16);
            }
            if (jVar.ml(true)) {
                jVar.FY(1);
            }
            if (jVar.ml(true)) {
                jVar.FY(3);
                jVar.FY(1);
                if (jVar.ml(true)) {
                    jVar.FY(8);
                    jVar.FY(8);
                    jVar.FY(8);
                }
            }
            if (jVar.ml(true)) {
                jVar.cIB();
                jVar.cIB();
            }
            if (jVar.ml(true)) {
                jVar.FY(32);
                jVar.FY(32);
                jVar.FY(1);
            }
            boolean ml = jVar.ml(true);
            if (ml) {
                a(jVar);
            }
            boolean ml2 = jVar.ml(true);
            if (ml2) {
                a(jVar);
            }
            if (ml || ml2) {
                jVar.FY(1);
            }
            jVar.FY(1);
            if (jVar.ml(true)) {
                jVar.ml(true);
                jVar.cIB();
                jVar.cIB();
                jVar.cIB();
                jVar.cIB();
                cIx = jVar.cIA();
                int cIA2 = jVar.cIA();
                if (cIx != 0) {
                    ab.d("[H264SPSModifier]", "steve: reorder_frame =" + cIx + ", mac_dec_buffering=" + cIA2);
                    this.sOC |= 4;
                    AppMethodBeat.o(4356);
                    return true;
                }
            }
        }
        AppMethodBeat.o(4356);
        return false;
    }

    private static void a(j jVar) {
        AppMethodBeat.i(4357);
        int cIA = jVar.cIA();
        jVar.FX(4);
        jVar.FX(4);
        for (int i = 0; i <= cIA; i++) {
            jVar.cIz();
            jVar.cIz();
            jVar.FX(1);
        }
        jVar.FX(5);
        jVar.FX(5);
        jVar.FX(5);
        jVar.FX(5);
        AppMethodBeat.o(4357);
    }
}
