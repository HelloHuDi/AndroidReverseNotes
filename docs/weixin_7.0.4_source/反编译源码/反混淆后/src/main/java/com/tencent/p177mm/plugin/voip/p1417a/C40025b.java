package com.tencent.p177mm.plugin.voip.p1417a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.view.C31128d;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.voip.a.b */
public final class C40025b {
    private static Map<Integer, String> sZh;

    static {
        AppMethodBeat.m2504i(ReaderCallback.COPY_SELECT_TEXT);
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
        sZh.put(Integer.valueOf(C31128d.MIC_PTU_ZIPAI_TOKYO), "CALLED_STATE_VOICE_INVITING");
        sZh.put(Integer.valueOf(C31128d.MIC_PTU_ZIPAI_SAPPORO), "CALLED_STATE_VIDEO_CONNECTING");
        sZh.put(Integer.valueOf(C31128d.MIC_PTU_ZIPAI_MEDSEA), "CALLED_STATE_VOICE_CONNECTING");
        sZh.put(Integer.valueOf(C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW), "CALLED_STATE_VIDEO_TALKING");
        sZh.put(Integer.valueOf(C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW), "CALLED_STATE_VOICE_TALKING");
        sZh.put(Integer.valueOf(C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM), "CALLED_STATE_FINISH");
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
        AppMethodBeat.m2505o(ReaderCallback.COPY_SELECT_TEXT);
    }

    /* renamed from: GK */
    public static String m68545GK(int i) {
        AppMethodBeat.m2504i(5000);
        String str;
        if (sZh.containsKey(Integer.valueOf(i))) {
            str = (String) sZh.get(Integer.valueOf(i));
            AppMethodBeat.m2505o(5000);
            return str;
        }
        str = "no found value";
        AppMethodBeat.m2505o(5000);
        return str;
    }

    /* renamed from: GL */
    public static C29487c m68546GL(int i) {
        AppMethodBeat.m2504i(ReaderCallback.HIDDEN_BAR);
        C29487c c29487c = new C29487c(i);
        c29487c.mo47749al(256, 4098, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(256, 4099, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(256, 4105, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(256, 4106, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(256, 4107, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(256, 4108, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(256, 4109, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(256, 4100, C31128d.MIC_PTU_ZIPAI_SAPPORO);
        c29487c.mo47749al(256, 4101, C31128d.MIC_PTU_ZIPAI_TOKYO);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_TOKYO, 4100, C31128d.MIC_PTU_ZIPAI_MEDSEA);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_TOKYO, 4098, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_TOKYO, 4099, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_TOKYO, 4105, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_TOKYO, 4106, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_TOKYO, 4107, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_TOKYO, 4108, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_TOKYO, 4109, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_SAPPORO, 4098, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_SAPPORO, 4106, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_SAPPORO, 4107, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_SAPPORO, 4103, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_SAPPORO, 4109, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_SAPPORO, 4102, C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_MEDSEA, 4102, C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_MEDSEA, 4098, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_MEDSEA, 4106, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_MEDSEA, 4107, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_MEDSEA, 4103, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_MEDSEA, 4109, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW, 4101, C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW, 4103, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW, 4104, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW, 4106, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW, 4107, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW, 4109, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW, 4103, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW, 4104, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW, 4106, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW, 4107, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        c29487c.mo47749al(C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW, 4109, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
        AppMethodBeat.m2505o(ReaderCallback.HIDDEN_BAR);
        return c29487c;
    }

    /* renamed from: GM */
    public static C29487c m68547GM(int i) {
        AppMethodBeat.m2504i(ReaderCallback.SHOW_BAR);
        C29487c c29487c = new C29487c(i);
        c29487c.mo47749al(0, 4098, 8);
        c29487c.mo47749al(0, 4106, 8);
        c29487c.mo47749al(0, 4107, 8);
        c29487c.mo47749al(0, 4109, 8);
        c29487c.mo47749al(0, 4097, 2);
        c29487c.mo47749al(0, 4101, 1);
        c29487c.mo47749al(1, 4097, 3);
        c29487c.mo47749al(1, 4098, 8);
        c29487c.mo47749al(1, 4106, 8);
        c29487c.mo47749al(1, 4107, 8);
        c29487c.mo47749al(1, 4109, 8);
        c29487c.mo47749al(2, 4098, 8);
        c29487c.mo47749al(2, 4099, 8);
        c29487c.mo47749al(2, 4105, 8);
        c29487c.mo47749al(2, 4106, 8);
        c29487c.mo47749al(2, 4107, 8);
        c29487c.mo47749al(2, 4109, 8);
        c29487c.mo47749al(2, 4100, 4);
        c29487c.mo47749al(2, 4101, 3);
        c29487c.mo47749al(3, 4100, 5);
        c29487c.mo47749al(3, 4098, 8);
        c29487c.mo47749al(3, 4099, 8);
        c29487c.mo47749al(3, 4105, 8);
        c29487c.mo47749al(3, 4106, 8);
        c29487c.mo47749al(3, 4107, 8);
        c29487c.mo47749al(3, 4109, 8);
        c29487c.mo47749al(4, 4102, 6);
        c29487c.mo47749al(4, 4101, 5);
        c29487c.mo47749al(5, 4102, 7);
        c29487c.mo47749al(6, 4103, 8);
        c29487c.mo47749al(6, 4104, 8);
        c29487c.mo47749al(6, 4106, 8);
        c29487c.mo47749al(6, 4107, 8);
        c29487c.mo47749al(6, 4109, 8);
        c29487c.mo47749al(6, 4101, 7);
        c29487c.mo47749al(7, 4103, 8);
        c29487c.mo47749al(7, 4104, 8);
        c29487c.mo47749al(7, 4106, 8);
        c29487c.mo47749al(7, 4107, 8);
        c29487c.mo47749al(7, 4109, 8);
        c29487c.mo47749al(4, 4098, 8);
        c29487c.mo47749al(4, 4099, 8);
        c29487c.mo47749al(4, 4106, 8);
        c29487c.mo47749al(4, 4107, 8);
        c29487c.mo47749al(4, 4103, 8);
        c29487c.mo47749al(4, 4109, 8);
        c29487c.mo47749al(5, 4098, 8);
        c29487c.mo47749al(5, 4099, 8);
        c29487c.mo47749al(5, 4106, 8);
        c29487c.mo47749al(5, 4107, 8);
        c29487c.mo47749al(5, 4103, 8);
        c29487c.mo47749al(5, 4109, 8);
        c29487c.mo47749al(0, 4110, 4);
        c29487c.mo47749al(1, 4110, 5);
        AppMethodBeat.m2505o(ReaderCallback.SHOW_BAR);
        return c29487c;
    }

    /* renamed from: GN */
    public static boolean m68548GN(int i) {
        return C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW == i || C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW == i || 6 == i || 7 == i;
    }

    /* renamed from: GO */
    public static boolean m68549GO(int i) {
        return i == 0 || 2 == i || 4 == i || 6 == i || 256 == i || C31128d.MIC_PTU_ZIPAI_SAPPORO == i || C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW == i;
    }

    /* renamed from: GP */
    public static boolean m68550GP(int i) {
        return 1 == i || i == 0 || 2 == i || 3 == i;
    }

    /* renamed from: T */
    public static int m68551T(boolean z, boolean z2) {
        if (true == z && true == z2) {
            return 0;
        }
        if (true == z && !z2) {
            return 1;
        }
        if (z || true != z2) {
            return C31128d.MIC_PTU_ZIPAI_TOKYO;
        }
        return 256;
    }
}
