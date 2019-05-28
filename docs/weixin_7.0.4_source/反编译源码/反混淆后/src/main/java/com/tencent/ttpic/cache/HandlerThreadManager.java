package com.tencent.ttpic.cache;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HandlerThreadManager {
    private static HandlerThreadManager instance = new HandlerThreadManager();
    private Map<String, HandlerThread> map = new ConcurrentHashMap();

    static {
        AppMethodBeat.m2504i(81767);
        AppMethodBeat.m2505o(81767);
    }

    public static HandlerThreadManager getInstance() {
        return instance;
    }

    private HandlerThreadManager() {
        AppMethodBeat.m2504i(81764);
        AppMethodBeat.m2505o(81764);
    }

    public HandlerThread getHanderThread(String str) {
        AppMethodBeat.m2504i(81765);
        HandlerThread handlerThread = (HandlerThread) this.map.get(str);
        if (handlerThread == null) {
            handlerThread = new HandlerThread(str);
            handlerThread.start();
            this.map.put(str, handlerThread);
        }
        AppMethodBeat.m2505o(81765);
        return handlerThread;
    }

    public void destroy() {
        AppMethodBeat.m2504i(81766);
        for (HandlerThread quit : this.map.values()) {
            quit.quit();
        }
        this.map.clear();
        AppMethodBeat.m2505o(81766);
    }
}
