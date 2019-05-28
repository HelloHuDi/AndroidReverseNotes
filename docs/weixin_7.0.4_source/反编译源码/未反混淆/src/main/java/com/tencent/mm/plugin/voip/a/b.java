package com.tencent.mm.plugin.voip.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.view.d;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static Map<Integer, String> sZh;

    static {
        AppMethodBeat.i(ReaderCallback.COPY_SELECT_TEXT);
        HashMap hashMap = new HashMap();
        sZh = hashMap;
        hashMap.put(Integer.valueOf(0), "CALLING_STATE_VIDEO_INVITING");
        sZh.put(Integer.valueOf(1), "CALLING_STATE_VOICE_INVITING");
        sZh.put(Integer.valueOf(2), "CALLING_STATE_VIDEO_WAITTING_ACCEPT");
        sZh.put(Integer.valueOf(3), "CALLING_STATE_VOICE_WAITTING_ACCEPT");
        sZh.put(Integer.valueOf(4), "CALLING_STATE_VIDEO_CONNECTING");
        sZh.put(Integer.valueOf(5), "CALLING_STATE_VOICE_CONNECTING");
        sZh.put(Integer.valueOf(6), "CALLING_STATE_VIDEO_TALKING");
        sZh.put(Integer.valueOf(7), "CALLING_STATE_VOICE_TALKING");
        sZh.put(Integer.valueOf(8), "CALLING_STATE_FINISH");
        sZh.put(Integer.valueOf(256), "CALLED_STATE_VIDEO_INVITING");
        sZh.put(Integer.valueOf(d.MIC_PTU_ZIPAI_TOKYO), "CALLED_STATE_VOICE_INVITING");
        sZh.put(Integer.valueOf(d.MIC_PTU_ZIPAI_SAPPORO), "CALLED_STATE_VIDEO_CONNECTING");
        sZh.put(Integer.valueOf(d.MIC_PTU_ZIPAI_MEDSEA), "CALLED_STATE_VOICE_CONNECTING");
        sZh.put(Integer.valueOf(d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW), "CALLED_STATE_VIDEO_TALKING");
        sZh.put(Integer.valueOf(d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW), "CALLED_STATE_VOICE_TALKING");
        sZh.put(Integer.valueOf(d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM), "CALLED_STATE_FINISH");
        sZh.put(Integer.valueOf(4096), "ACTION_NOP");
        sZh.put(Integer.valueOf(4097), "ACTION_INVITE_RESPOND");
        sZh.put(Integer.valueOf(4098), "ACTION_CANCEL_INVITE");
        sZh.put(Integer.valueOf(4099), "ACTION_REJECT_INVITE");
        sZh.put(Integer.valueOf(4100), "ACTION_ACCEPT_INVITE");
        sZh.put(Integer.valueOf(4101), "ACTION_CLOSE_CAMERA");
        sZh.put(Integer.valueOf(4102), "ACTION_CONNECT_SUCC");
        sZh.put(Integer.valueOf(4103), "ACTION_SELF_HANGUP");
        sZh.put(Integer.valueOf(4104), "ACTION_ANOTHER_HANGUP");
        sZh.put(Integer.valueOf(4105), "ACTION_INVITE_TIMEOUT");
        sZh.put(Integer.valueOf(4106), "ACTION_SO_SHUTDOWN");
        sZh.put(Integer.valueOf(4107), "ACTION_PHONE_COMING");
        sZh.put(Integer.valueOf(4108), "ACTION_IGNORE_INVITE");
        sZh.put(Integer.valueOf(4109), "ACTION_ON_ERROR");
        sZh.put(Integer.valueOf(4110), "ACTION_SESSION_CALLED");
        AppMethodBeat.o(ReaderCallback.COPY_SELECT_TEXT);
    }

    public static String GK(int i) {
        AppMethodBeat.i(5000);
        String str;
        if (sZh.containsKey(Integer.valueOf(i))) {
            str = (String) sZh.get(Integer.valueOf(i));
            AppMethodBeat.o(5000);
            return str;
        }
        str = "no found value";
        AppMethodBeat.o(5000);
        return str;
    }

    public static c GL(int i) {
        AppMethodBeat.i(ReaderCallback.HIDDEN_BAR);
        c cVar = new c(i);
        cVar.al(256, 4098, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(256, 4099, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(256, 4105, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(256, 4106, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(256, 4107, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(256, 4108, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(256, 4109, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(256, 4100, d.MIC_PTU_ZIPAI_SAPPORO);
        cVar.al(256, 4101, d.MIC_PTU_ZIPAI_TOKYO);
        cVar.al(d.MIC_PTU_ZIPAI_TOKYO, 4100, d.MIC_PTU_ZIPAI_MEDSEA);
        cVar.al(d.MIC_PTU_ZIPAI_TOKYO, 4098, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_TOKYO, 4099, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_TOKYO, 4105, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_TOKYO, 4106, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_TOKYO, 4107, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_TOKYO, 4108, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_TOKYO, 4109, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_SAPPORO, 4098, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_SAPPORO, 4106, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_SAPPORO, 4107, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_SAPPORO, 4103, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_SAPPORO, 4109, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_SAPPORO, 4102, d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW);
        cVar.al(d.MIC_PTU_ZIPAI_MEDSEA, 4102, d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW);
        cVar.al(d.MIC_PTU_ZIPAI_MEDSEA, 4098, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_MEDSEA, 4106, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_MEDSEA, 4107, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_MEDSEA, 4103, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_MEDSEA, 4109, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW, 4101, d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW);
        cVar.al(d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW, 4103, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW, 4104, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW, 4106, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW, 4107, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW, 4109, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW, 4103, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW, 4104, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW, 4106, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW, 4107, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        cVar.al(d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW, 4109, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        AppMethodBeat.o(ReaderCallback.HIDDEN_BAR);
        return cVar;
    }

    public static c GM(int i) {
        AppMethodBeat.i(ReaderCallback.SHOW_BAR);
        c cVar = new c(i);
        cVar.al(0, 4098, 8);
        cVar.al(0, 4106, 8);
        cVar.al(0, 4107, 8);
        cVar.al(0, 4109, 8);
        cVar.al(0, 4097, 2);
        cVar.al(0, 4101, 1);
        cVar.al(1, 4097, 3);
        cVar.al(1, 4098, 8);
        cVar.al(1, 4106, 8);
        cVar.al(1, 4107, 8);
        cVar.al(1, 4109, 8);
        cVar.al(2, 4098, 8);
        cVar.al(2, 4099, 8);
        cVar.al(2, 4105, 8);
        cVar.al(2, 4106, 8);
        cVar.al(2, 4107, 8);
        cVar.al(2, 4109, 8);
        cVar.al(2, 4100, 4);
        cVar.al(2, 4101, 3);
        cVar.al(3, 4100, 5);
        cVar.al(3, 4098, 8);
        cVar.al(3, 4099, 8);
        cVar.al(3, 4105, 8);
        cVar.al(3, 4106, 8);
        cVar.al(3, 4107, 8);
        cVar.al(3, 4109, 8);
        cVar.al(4, 4102, 6);
        cVar.al(4, 4101, 5);
        cVar.al(5, 4102, 7);
        cVar.al(6, 4103, 8);
        cVar.al(6, 4104, 8);
        cVar.al(6, 4106, 8);
        cVar.al(6, 4107, 8);
        cVar.al(6, 4109, 8);
        cVar.al(6, 4101, 7);
        cVar.al(7, 4103, 8);
        cVar.al(7, 4104, 8);
        cVar.al(7, 4106, 8);
        cVar.al(7, 4107, 8);
        cVar.al(7, 4109, 8);
        cVar.al(4, 4098, 8);
        cVar.al(4, 4099, 8);
        cVar.al(4, 4106, 8);
        cVar.al(4, 4107, 8);
        cVar.al(4, 4103, 8);
        cVar.al(4, 4109, 8);
        cVar.al(5, 4098, 8);
        cVar.al(5, 4099, 8);
        cVar.al(5, 4106, 8);
        cVar.al(5, 4107, 8);
        cVar.al(5, 4103, 8);
        cVar.al(5, 4109, 8);
        cVar.al(0, 4110, 4);
        cVar.al(1, 4110, 5);
        AppMethodBeat.o(ReaderCallback.SHOW_BAR);
        return cVar;
    }

    public static boolean GN(int i) {
        return d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW == i || d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW == i || 6 == i || 7 == i;
    }

    public static boolean GO(int i) {
        return i == 0 || 2 == i || 4 == i || 6 == i || 256 == i || d.MIC_PTU_ZIPAI_SAPPORO == i || d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW == i;
    }

    public static boolean GP(int i) {
        return 1 == i || i == 0 || 2 == i || 3 == i;
    }

    public static int T(boolean z, boolean z2) {
        if (true == z && true == z2) {
            return 0;
        }
        if (true == z && !z2) {
            return 1;
        }
        if (z || true != z2) {
            return d.MIC_PTU_ZIPAI_TOKYO;
        }
        return 256;
    }
}
