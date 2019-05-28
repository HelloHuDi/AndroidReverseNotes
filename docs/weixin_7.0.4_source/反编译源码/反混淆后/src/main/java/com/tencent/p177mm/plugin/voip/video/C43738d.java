package com.tencent.p177mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.voip.video.d */
public final class C43738d {
    public static Context mContext;
    private static final HashMap<String, Integer> sZR;
    public Object sZS = new Object();
    public ToneGenerator sZT;
    private final int sZU = 250;

    static {
        AppMethodBeat.m2504i(5056);
        HashMap hashMap = new HashMap();
        sZR = hashMap;
        hashMap.put("1", Integer.valueOf(1));
        sZR.put("2", Integer.valueOf(2));
        sZR.put(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, Integer.valueOf(3));
        sZR.put("4", Integer.valueOf(4));
        sZR.put("5", Integer.valueOf(5));
        sZR.put("6", Integer.valueOf(6));
        sZR.put("7", Integer.valueOf(7));
        sZR.put("8", Integer.valueOf(8));
        sZR.put("9", Integer.valueOf(9));
        sZR.put(AppEventsConstants.EVENT_PARAM_VALUE_NO, Integer.valueOf(0));
        sZR.put("#", Integer.valueOf(11));
        sZR.put("*", Integer.valueOf(10));
        AppMethodBeat.m2505o(5056);
    }

    public C43738d(Context context) {
        AppMethodBeat.m2504i(5052);
        mContext = context;
        if (context != null) {
            try {
                synchronized (this.sZS) {
                    if (C43738d.cLH() && this.sZT == null) {
                        this.sZT = new ToneGenerator(3, 66);
                    }
                }
                AppMethodBeat.m2505o(5052);
                return;
            } catch (Exception e) {
                C4990ab.m7410d("MicroMsg.DTMFToneGenerator", "获取音频发生器单例失败！！！");
                C4990ab.m7410d("MicroMsg.DTMFToneGenerator", e.getMessage());
                this.sZT = null;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(5052);
                    throw th;
                }
            }
        }
        AppMethodBeat.m2505o(5052);
    }

    private C43738d() {
        AppMethodBeat.m2504i(5053);
        AppMethodBeat.m2505o(5053);
    }

    public static boolean cLH() {
        AppMethodBeat.m2504i(5054);
        if (System.getInt(mContext.getContentResolver(), "dtmf_tone", 1) == 1) {
            AppMethodBeat.m2505o(5054);
            return true;
        }
        AppMethodBeat.m2505o(5054);
        return false;
    }

    public static int acb(String str) {
        AppMethodBeat.m2504i(5055);
        if (str == null || str.equals("")) {
            AppMethodBeat.m2505o(5055);
            return -1;
        } else if (sZR.containsKey(str)) {
            int intValue = ((Integer) sZR.get(str)).intValue();
            AppMethodBeat.m2505o(5055);
            return intValue;
        } else {
            AppMethodBeat.m2505o(5055);
            return -1;
        }
    }
}
