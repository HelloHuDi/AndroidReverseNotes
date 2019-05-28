package com.tencent.mars;

import android.content.Context;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.Arrays;

public class Mars {
    private static volatile boolean hasInitialized = false;
    private static ArrayList<String[]> libModules = new ArrayList();

    public static void loadDefaultMarsLibrary() {
        try {
            System.loadLibrary("c++_shared");
        } catch (Throwable th) {
        }
    }

    public static synchronized void checkLoadedModules(ArrayList<String> arrayList, String str) {
        synchronized (Mars.class) {
            if (arrayList != null) {
                String[] strArr = new String[0];
                C4990ab.m7416i(str, "loaded modules: " + Arrays.toString(arrayList.toArray(strArr)));
                Arrays.sort(strArr);
                libModules.add(strArr);
                int i = 0;
                Object obj = 1;
                while (i < libModules.size()) {
                    Object obj2;
                    if (Arrays.equals((Object[]) libModules.get(i), (Object[]) libModules.get(0))) {
                        obj2 = obj;
                    } else {
                        obj2 = null;
                    }
                    i++;
                    obj = obj2;
                }
                if (obj == null) {
                    for (i = 0; i < libModules.size(); i++) {
                        for (int i2 = i + 1; i2 < libModules.size(); i2++) {
                            if (hasInterSection((String[]) libModules.get(i), (String[]) libModules.get(i2))) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            if (obj == null) {
                                break;
                            }
                        }
                        if (obj == null) {
                            break;
                        }
                    }
                }
                if (obj == null) {
                    throw new IllegalStateException("mars lib module custom made error, pls check your *.so.");
                }
            }
        }
    }

    public static void init(Context context, C7306ak c7306ak) {
        PlatformComm.init(context, c7306ak);
        hasInitialized = true;
    }

    public static void onCreate(boolean z) {
        if (z && hasInitialized) {
            BaseEvent.onCreate();
        } else if (z) {
            throw new IllegalStateException("function MarsCore.init must be executed before Mars.onCreate when application firststartup.");
        } else {
            BaseEvent.onCreate();
        }
    }

    public static void onDestroy() {
        BaseEvent.onDestroy();
    }

    private static boolean hasInterSection(String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (Object add : strArr) {
            arrayList.add(add);
        }
        for (Object add2 : strArr2) {
            if (arrayList.contains(add2)) {
                return true;
            }
        }
        return false;
    }
}
