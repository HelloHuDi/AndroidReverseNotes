package com.tencent.p177mm.plugin.voip.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.voip.model.g */
public final class C46322g {
    public int sOC = 0;

    /* renamed from: F */
    public static byte[] m87001F(InputStream inputStream) {
        int i = 0;
        AppMethodBeat.m2504i(4355);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C29499j c29499j = new C29499j(inputStream, byteArrayOutputStream);
        c29499j.mo47762FY(8);
        c29499j.mo47762FY(8);
        c29499j.mo47762FY(8);
        c29499j.mo47762FY(8);
        c29499j.mo47762FY(8);
        int cIx = (int) c29499j.cIx();
        c29499j.mo47762FY(8);
        c29499j.cIx();
        c29499j.cIB();
        if (cIx == 100 || cIx == 110 || cIx == 122 || cIx == 144) {
            if (c29499j.cIA() == 3) {
                c29499j.mo47762FY(1);
            }
            c29499j.cIB();
            c29499j.cIB();
            c29499j.mo47762FY(1);
            if (c29499j.mo47772ml(true)) {
                for (cIx = 0; cIx < 8; cIx++) {
                    if (c29499j.mo47772ml(true)) {
                        if (cIx < 6) {
                            c29499j.mo47763FZ(16);
                        } else {
                            c29499j.mo47763FZ(64);
                        }
                    }
                }
            }
        }
        c29499j.cIB();
        cIx = c29499j.cIA();
        if (cIx == 0) {
            c29499j.cIB();
        } else if (cIx == 1) {
            c29499j.mo47762FY(1);
            c29499j.cIB();
            c29499j.cIB();
            int cIA = c29499j.cIA();
            for (cIx = 0; cIx < cIA; cIx++) {
                new StringBuilder("SPS: offsetForRefFrame [").append(cIx).append("]");
                c29499j.cIB();
            }
        }
        c29499j.cIB();
        c29499j.mo47762FY(1);
        c29499j.cIB();
        c29499j.cIB();
        if (!c29499j.mo47772ml(true)) {
            c29499j.mo47762FY(1);
        }
        c29499j.mo47762FY(1);
        if (c29499j.mo47772ml(true)) {
            c29499j.cIB();
            c29499j.cIB();
            c29499j.cIB();
            c29499j.cIB();
        }
        if (c29499j.mo47772ml(false)) {
            C4990ab.m7410d("[H264SPSModifier]", "vui_parameters_present_flag exist!! modify max_dec_frame_buffering");
            c29499j.mo47773mn(true);
            if (c29499j.mo47772ml(true) && ((int) c29499j.cIx()) == 255) {
                c29499j.mo47762FY(16);
                c29499j.mo47762FY(16);
            }
            if (c29499j.mo47772ml(true)) {
                c29499j.mo47762FY(1);
            }
            if (c29499j.mo47772ml(true)) {
                c29499j.mo47762FY(3);
                c29499j.mo47762FY(1);
                if (c29499j.mo47772ml(true)) {
                    c29499j.mo47762FY(8);
                    c29499j.mo47762FY(8);
                    c29499j.mo47762FY(8);
                }
            }
            if (c29499j.mo47772ml(true)) {
                c29499j.cIB();
                c29499j.cIB();
            }
            if (c29499j.mo47772ml(true)) {
                c29499j.mo47762FY(32);
                c29499j.mo47762FY(32);
                c29499j.mo47762FY(1);
            }
            boolean ml = c29499j.mo47772ml(true);
            if (ml) {
                C46322g.m87002a(c29499j);
            }
            boolean ml2 = c29499j.mo47772ml(true);
            if (ml2) {
                C46322g.m87002a(c29499j);
            }
            if (ml || ml2) {
                c29499j.mo47762FY(1);
            }
            c29499j.mo47762FY(1);
            if (c29499j.mo47772ml(false)) {
                C4990ab.m7410d("TAG", "steve:VUI has bs restriction!!");
                c29499j.mo47773mn(true);
                c29499j.mo47772ml(true);
                c29499j.cIB();
                c29499j.cIB();
                c29499j.cIB();
                c29499j.cIB();
                c29499j.cIB();
                c29499j.mo47766Gc(1);
            } else {
                C4990ab.m7410d("TAG", "steve:VUI has NO bs restriction!!");
                c29499j.mo47773mn(true);
                c29499j.mo47773mn(true);
                c29499j.mo47766Gc(0);
                c29499j.mo47766Gc(0);
                c29499j.mo47766Gc(10);
                c29499j.mo47766Gc(10);
                c29499j.mo47766Gc(0);
                c29499j.mo47766Gc(1);
            }
        } else {
            C4990ab.m7410d("[H264SPSModifier]", "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering");
            c29499j.mo47773mn(true);
            c29499j.mo47773mn(false);
            c29499j.mo47773mn(false);
            c29499j.mo47773mn(false);
            c29499j.mo47773mn(false);
            c29499j.mo47773mn(false);
            c29499j.mo47773mn(false);
            c29499j.mo47773mn(false);
            c29499j.mo47773mn(false);
            c29499j.mo47773mn(true);
            c29499j.mo47773mn(true);
            c29499j.mo47766Gc(0);
            c29499j.mo47766Gc(0);
            c29499j.mo47766Gc(10);
            c29499j.mo47766Gc(10);
            c29499j.mo47766Gc(0);
            c29499j.mo47766Gc(1);
        }
        c29499j.mo47765Ga(1);
        c29499j.mo47764G(0, 8 - c29499j.sOK);
        c29499j.flush();
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
        C4990ab.m7410d("TAG", "new SPS:".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(4355);
        return toByteArray;
    }

    /* renamed from: G */
    public final boolean mo74512G(InputStream inputStream) {
        AppMethodBeat.m2504i(4356);
        C29499j c29499j = new C29499j(inputStream);
        c29499j.mo47761FX(8);
        c29499j.mo47761FX(8);
        c29499j.mo47761FX(8);
        c29499j.mo47761FX(8);
        c29499j.mo47761FX(8);
        int cIx = (int) c29499j.cIx();
        if (cIx == 66) {
            this.sOC |= 1;
            AppMethodBeat.m2505o(4356);
            return false;
        }
        c29499j.mo47761FX(8);
        c29499j.cIx();
        c29499j.cIz();
        if (cIx == 100 || cIx == 110 || cIx == 122 || cIx == 144) {
            if (c29499j.cIA() == 3) {
                c29499j.mo47761FX(1);
            }
            c29499j.cIz();
            c29499j.cIz();
            c29499j.mo47761FX(1);
            if (c29499j.mo47772ml(true)) {
                for (cIx = 0; cIx < 8; cIx++) {
                    if (c29499j.mo47772ml(true)) {
                        if (cIx < 6) {
                            c29499j.mo47763FZ(16);
                        } else {
                            c29499j.mo47763FZ(64);
                        }
                    }
                }
            }
        }
        c29499j.cIz();
        cIx = c29499j.cIA();
        if (cIx == 0) {
            c29499j.cIz();
        } else if (cIx == 1) {
            c29499j.mo47761FX(1);
            c29499j.cIz();
            c29499j.cIz();
            int cIA = c29499j.cIA();
            for (cIx = 0; cIx < cIA; cIx++) {
                new StringBuilder("SPS: offsetForRefFrame [").append(cIx).append("]");
                c29499j.cIB();
            }
        }
        if (c29499j.cIA() >= 2) {
            this.sOC |= 2;
        }
        c29499j.mo47762FY(1);
        c29499j.cIB();
        c29499j.cIB();
        if (!c29499j.mo47772ml(true)) {
            c29499j.mo47762FY(1);
        }
        c29499j.mo47762FY(1);
        if (c29499j.mo47772ml(true)) {
            c29499j.cIB();
            c29499j.cIB();
            c29499j.cIB();
            c29499j.cIB();
        }
        if (c29499j.mo47772ml(true)) {
            C4990ab.m7410d("[H264SPSModifier]", "vui_parameters_present_flag exist!! read num_reorder_frames");
            if (c29499j.mo47772ml(true) && ((int) c29499j.cIx()) == 255) {
                c29499j.mo47762FY(16);
                c29499j.mo47762FY(16);
            }
            if (c29499j.mo47772ml(true)) {
                c29499j.mo47762FY(1);
            }
            if (c29499j.mo47772ml(true)) {
                c29499j.mo47762FY(3);
                c29499j.mo47762FY(1);
                if (c29499j.mo47772ml(true)) {
                    c29499j.mo47762FY(8);
                    c29499j.mo47762FY(8);
                    c29499j.mo47762FY(8);
                }
            }
            if (c29499j.mo47772ml(true)) {
                c29499j.cIB();
                c29499j.cIB();
            }
            if (c29499j.mo47772ml(true)) {
                c29499j.mo47762FY(32);
                c29499j.mo47762FY(32);
                c29499j.mo47762FY(1);
            }
            boolean ml = c29499j.mo47772ml(true);
            if (ml) {
                C46322g.m87002a(c29499j);
            }
            boolean ml2 = c29499j.mo47772ml(true);
            if (ml2) {
                C46322g.m87002a(c29499j);
            }
            if (ml || ml2) {
                c29499j.mo47762FY(1);
            }
            c29499j.mo47762FY(1);
            if (c29499j.mo47772ml(true)) {
                c29499j.mo47772ml(true);
                c29499j.cIB();
                c29499j.cIB();
                c29499j.cIB();
                c29499j.cIB();
                cIx = c29499j.cIA();
                int cIA2 = c29499j.cIA();
                if (cIx != 0) {
                    C4990ab.m7410d("[H264SPSModifier]", "steve: reorder_frame =" + cIx + ", mac_dec_buffering=" + cIA2);
                    this.sOC |= 4;
                    AppMethodBeat.m2505o(4356);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(4356);
        return false;
    }

    /* renamed from: a */
    private static void m87002a(C29499j c29499j) {
        AppMethodBeat.m2504i(4357);
        int cIA = c29499j.cIA();
        c29499j.mo47761FX(4);
        c29499j.mo47761FX(4);
        for (int i = 0; i <= cIA; i++) {
            c29499j.cIz();
            c29499j.cIz();
            c29499j.mo47761FX(1);
        }
        c29499j.mo47761FX(5);
        c29499j.mo47761FX(5);
        c29499j.mo47761FX(5);
        c29499j.mo47761FX(5);
        AppMethodBeat.m2505o(4357);
    }
}
