package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.d;
import java.io.BufferedOutputStream;

public final class k {
    static BufferedOutputStream mOutputStream = null;
    public static boolean sZe = false;

    public static int ju(Context context) {
        AppMethodBeat.i(128004);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(128004);
            return 0;
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.o(128004);
            return 4;
        } else if (activeNetworkInfo.getSubtype() == 3) {
            AppMethodBeat.o(128004);
            return 3;
        } else if (activeNetworkInfo.getSubtype() <= 0 || activeNetworkInfo.getSubtype() >= 5) {
            try {
                if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                    AppMethodBeat.o(128004);
                    return 3;
                } else if (activeNetworkInfo.getSubtype() >= 13) {
                    AppMethodBeat.o(128004);
                    return 5;
                } else {
                    AppMethodBeat.o(128004);
                    return 2;
                }
            } catch (Exception e) {
                AppMethodBeat.o(128004);
                return 2;
            }
        } else {
            AppMethodBeat.o(128004);
            return 1;
        }
    }

    private static int getNetType(Context context) {
        AppMethodBeat.i(128005);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(128005);
            return 0;
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.o(128005);
            return 4;
        } else if (activeNetworkInfo.getSubtype() == 3) {
            AppMethodBeat.o(128005);
            return 3;
        } else if (activeNetworkInfo.getSubtype() <= 0 || activeNetworkInfo.getSubtype() >= 5) {
            try {
                if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                    AppMethodBeat.o(128005);
                    return 3;
                } else if (activeNetworkInfo.getSubtype() >= 13) {
                    AppMethodBeat.o(128005);
                    return 5;
                } else {
                    AppMethodBeat.o(128005);
                    return 2;
                }
            } catch (Exception e) {
                AppMethodBeat.o(128005);
                return 2;
            }
        } else {
            AppMethodBeat.o(128005);
            return 1;
        }
    }

    public static boolean dTJ() {
        AppMethodBeat.i(128006);
        if (getNetType(d.sZj) == 4) {
            AppMethodBeat.o(128006);
            return true;
        }
        AppMethodBeat.o(128006);
        return false;
    }
}
