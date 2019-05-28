package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C46729d;
import java.io.BufferedOutputStream;

/* renamed from: com.tencent.wecall.talkroom.model.k */
public final class C41114k {
    static BufferedOutputStream mOutputStream = null;
    public static boolean sZe = false;

    /* renamed from: ju */
    public static int m71547ju(Context context) {
        AppMethodBeat.m2504i(128004);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.m2505o(128004);
            return 0;
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.m2505o(128004);
            return 4;
        } else if (activeNetworkInfo.getSubtype() == 3) {
            AppMethodBeat.m2505o(128004);
            return 3;
        } else if (activeNetworkInfo.getSubtype() <= 0 || activeNetworkInfo.getSubtype() >= 5) {
            try {
                if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                    AppMethodBeat.m2505o(128004);
                    return 3;
                } else if (activeNetworkInfo.getSubtype() >= 13) {
                    AppMethodBeat.m2505o(128004);
                    return 5;
                } else {
                    AppMethodBeat.m2505o(128004);
                    return 2;
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(128004);
                return 2;
            }
        } else {
            AppMethodBeat.m2505o(128004);
            return 1;
        }
    }

    private static int getNetType(Context context) {
        AppMethodBeat.m2504i(128005);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.m2505o(128005);
            return 0;
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.m2505o(128005);
            return 4;
        } else if (activeNetworkInfo.getSubtype() == 3) {
            AppMethodBeat.m2505o(128005);
            return 3;
        } else if (activeNetworkInfo.getSubtype() <= 0 || activeNetworkInfo.getSubtype() >= 5) {
            try {
                if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                    AppMethodBeat.m2505o(128005);
                    return 3;
                } else if (activeNetworkInfo.getSubtype() >= 13) {
                    AppMethodBeat.m2505o(128005);
                    return 5;
                } else {
                    AppMethodBeat.m2505o(128005);
                    return 2;
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(128005);
                return 2;
            }
        } else {
            AppMethodBeat.m2505o(128005);
            return 1;
        }
    }

    public static boolean dTJ() {
        AppMethodBeat.m2504i(128006);
        if (C41114k.getNetType(C46729d.sZj) == 4) {
            AppMethodBeat.m2505o(128006);
            return true;
        }
        AppMethodBeat.m2505o(128006);
        return false;
    }
}
