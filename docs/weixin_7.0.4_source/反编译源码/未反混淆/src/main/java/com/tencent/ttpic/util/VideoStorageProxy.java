package com.tencent.ttpic.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class VideoStorageProxy {
    private static final String COLON = ":";
    private static final String DEV_MOUNT = "dev_mount";
    private static final String READ_COMMAND = "cat /etc/vold.fstab";
    private static final String TAG = VideoStorageProxy.class.getSimpleName();
    private static final String VOLD_FSTAB_FILE = "/etc/vold.fstab";

    static {
        AppMethodBeat.i(84228);
        AppMethodBeat.o(84228);
    }

    private static ArrayList<String> readEtcFstabFile() {
        AppMethodBeat.i(84224);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(READ_COMMAND).getInputStream()));
            ArrayList<String> arrayList = new ArrayList(5);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    AppMethodBeat.o(84224);
                    return arrayList;
                } else if (!readLine.startsWith("#") && readLine.contains(DEV_MOUNT)) {
                    String[] split = readLine.split("\\s+");
                    if (split != null && split.length >= 3) {
                        arrayList.add(removePathColon(split[2]));
                    }
                }
            }
        } catch (IOException e) {
            AppMethodBeat.o(84224);
            return null;
        }
    }

    private static ArrayList<String> getExternalStoragePathEx(Context context) {
        AppMethodBeat.i(84225);
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        Class cls = storageManager.getClass();
        ArrayList<String> arrayList = new ArrayList(5);
        try {
            String[] strArr = (String[]) cls.getMethod("getVolumePaths", null).invoke(storageManager, null);
            new StringBuilder("paths.size = ").append(strArr.length);
            for (String removePathColon : strArr) {
                arrayList.add(removePathColon(removePathColon));
            }
            AppMethodBeat.o(84225);
            return arrayList;
        } catch (Exception e) {
            AppMethodBeat.o(84225);
            return null;
        }
    }

    public static ArrayList<String> getAvailableStorage(Context context) {
        ArrayList<String> externalStoragePathEx;
        AppMethodBeat.i(84226);
        if (VERSION.SDK_INT >= 11) {
            externalStoragePathEx = getExternalStoragePathEx(context);
        } else {
            externalStoragePathEx = readEtcFstabFile();
        }
        if (externalStoragePathEx == null || externalStoragePathEx.size() == 0) {
            AppMethodBeat.o(84226);
            return null;
        }
        Iterator it = externalStoragePathEx.iterator();
        while (it.hasNext()) {
            if (!new File((String) it.next()).exists()) {
                it.remove();
            }
        }
        AppMethodBeat.o(84226);
        return externalStoragePathEx;
    }

    private static String removePathColon(String str) {
        AppMethodBeat.i(84227);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(84227);
            return str;
        }
        int indexOf = str.indexOf(":");
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
            AppMethodBeat.o(84227);
            return str;
        }
        AppMethodBeat.o(84227);
        return str;
    }
}
