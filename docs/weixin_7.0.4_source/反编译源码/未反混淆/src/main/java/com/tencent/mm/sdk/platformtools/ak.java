package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ak implements com.tencent.mm.sdk.platformtools.am.a {
    private static final String TAG = "MicroMsg.MMHandler";
    private static b sLogCallback;
    private com.tencent.mm.sdk.b handler;
    private int latestSize;
    private LinkedList<WeakReference<aq>> latestTasks = new LinkedList();
    private ConcurrentHashMap<Runnable, WeakReference<aq>> map = new ConcurrentHashMap();
    private String toStringResult = null;

    public interface a extends Callback {
    }

    public interface b {
        void a(Message message, Runnable runnable, Thread thread, long j, long j2, float f);
    }

    public ak() {
        AppMethodBeat.i(52066);
        if (Looper.myLooper() == null) {
            ab.w(TAG, "[MMHandler] myLooper() == null loopTag:%s", com.tencent.mm.sdk.g.a.getTag());
            this.handler = new com.tencent.mm.sdk.b(bo.bc(com.tencent.mm.sdk.g.a.getTag(), TAG), null, (com.tencent.mm.sdk.platformtools.am.a) this);
            AppMethodBeat.o(52066);
            return;
        }
        this.handler = new com.tencent.mm.sdk.b(this);
        if (getLooper().getThread().getName().equals("initThread")) {
            ab.e(TAG, "MMHandler can not init handler with initThread looper, stack %s", bo.dpG());
        }
        AppMethodBeat.o(52066);
    }

    public ak(Looper looper) {
        AppMethodBeat.i(52067);
        this.handler = new com.tencent.mm.sdk.b(looper, (com.tencent.mm.sdk.platformtools.am.a) this);
        if (looper.getThread().getName().equals("initThread")) {
            ab.e(TAG, "MMHandler can not init handler with initThread looper, stack %s", bo.dpG());
        }
        AppMethodBeat.o(52067);
    }

    public ak(a aVar) {
        AppMethodBeat.i(52068);
        if (Looper.myLooper() == null) {
            ab.w(TAG, "[MMHandler] myLooper() == null loopTag:%s", com.tencent.mm.sdk.g.a.getTag());
            this.handler = new com.tencent.mm.sdk.b(bo.bc(com.tencent.mm.sdk.g.a.getTag(), TAG), (Callback) aVar, (com.tencent.mm.sdk.platformtools.am.a) this);
            AppMethodBeat.o(52068);
            return;
        }
        this.handler = new com.tencent.mm.sdk.b((Callback) aVar, (com.tencent.mm.sdk.platformtools.am.a) this);
        if (getLooper().getThread().getName().equals("initThread")) {
            ab.e(TAG, "MMHandler can not init handler with initThread looper, stack %s", bo.dpG());
        }
        AppMethodBeat.o(52068);
    }

    public ak(Looper looper, a aVar) {
        AppMethodBeat.i(52069);
        this.handler = new com.tencent.mm.sdk.b(looper, (Callback) aVar, (com.tencent.mm.sdk.platformtools.am.a) this);
        if (looper.getThread().getName().equals("initThread")) {
            ab.e(TAG, "MMHandler can not init handler with initThread looper, stack %s", bo.dpG());
        }
        AppMethodBeat.o(52069);
    }

    public ak(String str, a aVar) {
        AppMethodBeat.i(52070);
        this.handler = new com.tencent.mm.sdk.b(str, (Callback) aVar, (com.tencent.mm.sdk.platformtools.am.a) this);
        AppMethodBeat.o(52070);
    }

    public ak(String str) {
        AppMethodBeat.i(52071);
        this.handler = new com.tencent.mm.sdk.b(str, null, (com.tencent.mm.sdk.platformtools.am.a) this);
        AppMethodBeat.o(52071);
    }

    public String getLoopTag() {
        return this.handler.xxq;
    }

    @TargetApi(14)
    public String getMessageName(Message message) {
        AppMethodBeat.i(52072);
        String messageName;
        if (VERSION.SDK_INT >= 14) {
            messageName = this.handler.getMessageName(message);
            AppMethodBeat.o(52072);
            return messageName;
        } else if (message.getCallback() != null) {
            messageName = message.getCallback().getClass().getName();
            AppMethodBeat.o(52072);
            return messageName;
        } else {
            messageName = "0x" + Integer.toHexString(message.what);
            AppMethodBeat.o(52072);
            return messageName;
        }
    }

    public final Message obtainMessage() {
        AppMethodBeat.i(52073);
        Message obtainMessage = this.handler.obtainMessage();
        AppMethodBeat.o(52073);
        return obtainMessage;
    }

    public final Message obtainMessage(int i) {
        AppMethodBeat.i(52074);
        Message obtainMessage = this.handler.obtainMessage(i);
        AppMethodBeat.o(52074);
        return obtainMessage;
    }

    public final Message obtainMessage(int i, Object obj) {
        AppMethodBeat.i(52075);
        Message obtainMessage = this.handler.obtainMessage(i, obj);
        AppMethodBeat.o(52075);
        return obtainMessage;
    }

    public final Message obtainMessage(int i, int i2, int i3) {
        AppMethodBeat.i(52076);
        Message obtainMessage = this.handler.obtainMessage(i, i2, i3);
        AppMethodBeat.o(52076);
        return obtainMessage;
    }

    public final Message obtainMessage(int i, int i2, int i3, Object obj) {
        AppMethodBeat.i(52077);
        Message obtainMessage = this.handler.obtainMessage(i, i2, i3, obj);
        AppMethodBeat.o(52077);
        return obtainMessage;
    }

    public final boolean post(Runnable runnable) {
        AppMethodBeat.i(52078);
        boolean post = this.handler.post(runnable);
        AppMethodBeat.o(52078);
        return post;
    }

    public final boolean postAtTime(Runnable runnable, long j) {
        AppMethodBeat.i(52079);
        boolean postAtTime = this.handler.postAtTime(runnable, j);
        AppMethodBeat.o(52079);
        return postAtTime;
    }

    public final boolean postAtTime(Runnable runnable, Object obj, long j) {
        AppMethodBeat.i(52080);
        boolean postAtTime = this.handler.postAtTime(runnable, obj, j);
        AppMethodBeat.o(52080);
        return postAtTime;
    }

    public final boolean postDelayed(Runnable runnable, long j) {
        AppMethodBeat.i(52081);
        boolean postDelayed = this.handler.postDelayed(runnable, j);
        AppMethodBeat.o(52081);
        return postDelayed;
    }

    public final boolean postAtFrontOfQueue(Runnable runnable) {
        AppMethodBeat.i(52082);
        boolean postAtFrontOfQueue = this.handler.postAtFrontOfQueue(runnable);
        AppMethodBeat.o(52082);
        return postAtFrontOfQueue;
    }

    public final boolean postAtFrontOfQueueV2(Runnable runnable) {
        AppMethodBeat.i(52083);
        boolean sendMessageAtTime = this.handler.sendMessageAtTime(Message.obtain(this.handler, runnable), 0);
        AppMethodBeat.o(52083);
        return sendMessageAtTime;
    }

    public final void removeCallbacks(Runnable runnable) {
        AppMethodBeat.i(52084);
        if (runnable == null) {
            AppMethodBeat.o(52084);
        } else if (this.handler.dnJ()) {
            this.handler.ad(runnable);
            AppMethodBeat.o(52084);
        } else {
            WeakReference weakReference = (WeakReference) this.map.get(runnable);
            if (!(weakReference == null || weakReference.get() == null)) {
                this.handler.ad((Runnable) weakReference.get());
            }
            this.map.remove(runnable);
            AppMethodBeat.o(52084);
        }
    }

    public final void removeCallbacks(Runnable runnable, Object obj) {
        AppMethodBeat.i(52085);
        if (runnable == null) {
            AppMethodBeat.o(52085);
        } else if (this.handler.dnJ()) {
            this.handler.ad(runnable);
            AppMethodBeat.o(52085);
        } else {
            WeakReference weakReference = (WeakReference) this.map.get(runnable);
            if (!(weakReference == null || weakReference.get() == null || (obj != null && ((aq) weakReference.get()).xxu != obj))) {
                this.handler.b((Runnable) weakReference.get(), obj);
            }
            this.map.remove(runnable);
            AppMethodBeat.o(52085);
        }
    }

    public final boolean sendMessage(Message message) {
        AppMethodBeat.i(52086);
        boolean sendMessage = this.handler.sendMessage(message);
        AppMethodBeat.o(52086);
        return sendMessage;
    }

    public final boolean sendEmptyMessage(int i) {
        AppMethodBeat.i(52087);
        boolean sendEmptyMessage = this.handler.sendEmptyMessage(i);
        AppMethodBeat.o(52087);
        return sendEmptyMessage;
    }

    public final boolean sendEmptyMessageDelayed(int i, long j) {
        AppMethodBeat.i(52088);
        boolean sendEmptyMessageDelayed = this.handler.sendEmptyMessageDelayed(i, j);
        AppMethodBeat.o(52088);
        return sendEmptyMessageDelayed;
    }

    public final boolean sendEmptyMessageAtTime(int i, long j) {
        AppMethodBeat.i(52089);
        boolean sendEmptyMessageAtTime = this.handler.sendEmptyMessageAtTime(i, j);
        AppMethodBeat.o(52089);
        return sendEmptyMessageAtTime;
    }

    public final boolean sendMessageDelayed(Message message, long j) {
        AppMethodBeat.i(52090);
        boolean sendMessageDelayed = this.handler.sendMessageDelayed(message, j);
        AppMethodBeat.o(52090);
        return sendMessageDelayed;
    }

    public boolean sendMessageAtTime(Message message, long j) {
        AppMethodBeat.i(52091);
        boolean sendMessageAtTime = this.handler.sendMessageAtTime(message, j);
        AppMethodBeat.o(52091);
        return sendMessageAtTime;
    }

    public final boolean sendMessageAtFrontOfQueue(Message message) {
        AppMethodBeat.i(52092);
        boolean sendMessageAtFrontOfQueue = this.handler.sendMessageAtFrontOfQueue(message);
        AppMethodBeat.o(52092);
        return sendMessageAtFrontOfQueue;
    }

    public final void removeMessages(int i) {
        AppMethodBeat.i(52093);
        this.handler.LT(i);
        AppMethodBeat.o(52093);
    }

    public final void removeMessages(int i, Object obj) {
        AppMethodBeat.i(52094);
        this.handler.p(i, obj);
        AppMethodBeat.o(52094);
    }

    public final void removeCallbacksAndMessages(Object obj) {
        AppMethodBeat.i(52095);
        this.handler.cz(obj);
        if (obj == null) {
            this.map.clear();
            AppMethodBeat.o(52095);
            return;
        }
        Iterator it = this.map.entrySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry != null) {
                    WeakReference weakReference = (WeakReference) entry.getValue();
                    if (!(weakReference == null || weakReference.get() == null || ((aq) weakReference.get()).xxu != obj)) {
                        it.remove();
                    }
                }
            }
        }
        AppMethodBeat.o(52095);
    }

    public final boolean hasMessages(int i) {
        AppMethodBeat.i(52096);
        boolean LU = this.handler.LU(i);
        AppMethodBeat.o(52096);
        return LU;
    }

    public final boolean hasMessages(int i, Object obj) {
        AppMethodBeat.i(52097);
        boolean q = this.handler.q(i, obj);
        AppMethodBeat.o(52097);
        return q;
    }

    public final Looper getLooper() {
        AppMethodBeat.i(52098);
        Looper dnK = this.handler.dnK();
        AppMethodBeat.o(52098);
        return dnK;
    }

    public final void dump(Printer printer, String str) {
        AppMethodBeat.i(52099);
        this.handler.a(printer, str);
        AppMethodBeat.o(52099);
    }

    public String toString() {
        AppMethodBeat.i(52100);
        if (this.toStringResult == null) {
            this.toStringResult = "MMHandler(" + getClass().getName() + ")";
        }
        String str = this.toStringResult;
        AppMethodBeat.o(52100);
        return str;
    }

    public void handleMessage(Message message) {
    }

    public void onTaskAdded(Runnable runnable, aq aqVar) {
        AppMethodBeat.i(52101);
        this.map.put(runnable, new WeakReference(aqVar));
        AppMethodBeat.o(52101);
    }

    public void onTaskRunEnd(Runnable runnable, aq aqVar) {
        AppMethodBeat.i(52102);
        WeakReference weakReference = (WeakReference) this.map.get(runnable);
        if (!(weakReference == null || weakReference.get() == null || weakReference.get() != aqVar)) {
            this.map.remove(runnable);
            if (this.latestSize > 0) {
                if (this.latestTasks.size() == this.latestSize) {
                    this.latestTasks.pop();
                }
                this.latestTasks.add(weakReference);
            }
        }
        AppMethodBeat.o(52102);
    }

    public static Handler fetchFreeHandler() {
        AppMethodBeat.i(52103);
        Handler handler = new Handler();
        AppMethodBeat.o(52103);
        return handler;
    }

    public static Handler fetchFreeHandler(Looper looper) {
        AppMethodBeat.i(52104);
        Handler handler = new Handler(looper);
        AppMethodBeat.o(52104);
        return handler;
    }

    public static Handler fetchFreeHandler(a aVar) {
        AppMethodBeat.i(52105);
        Handler handler = new Handler(aVar);
        AppMethodBeat.o(52105);
        return handler;
    }

    public static Handler fetchFreeHandler(Looper looper, a aVar) {
        AppMethodBeat.i(52106);
        Handler handler = new Handler(looper, aVar);
        AppMethodBeat.o(52106);
        return handler;
    }

    public static void setLogCallback(b bVar) {
        sLogCallback = bVar;
    }

    public void onLog(Message message, Runnable runnable, Thread thread, long j, long j2, long j3, float f) {
        AppMethodBeat.i(52107);
        if (sLogCallback != null) {
            sLogCallback.a(message, runnable, thread, j, j2, f);
        }
        AppMethodBeat.o(52107);
    }

    public void setLatestSize(int i) {
        this.latestSize = i;
    }

    public String dumpLatestTasks(boolean z) {
        AppMethodBeat.i(52108);
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList linkedList = new LinkedList(this.latestTasks);
        stringBuilder.append("|MMHandler latest(" + linkedList.size() + ") tasks done info");
        Iterator it = linkedList.iterator();
        int i = 0;
        if (it != null) {
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) it.next();
                if (!(weakReference == null || weakReference.get() == null)) {
                    stringBuilder.append("[index = " + i2 + "|task=" + ((aq) weakReference.get()).dump(z) + "]");
                }
                i = i2 + 1;
            }
        }
        linkedList.clear();
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(52108);
        return stringBuilder2;
    }

    public String dump(boolean z) {
        AppMethodBeat.i(52109);
        StringBuilder stringBuilder = new StringBuilder();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(this.map);
        stringBuilder.append("tasks info size = " + concurrentHashMap.size() + 10);
        Iterator it = concurrentHashMap.values().iterator();
        int i = 0;
        if (it != null) {
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) it.next();
                if (!(weakReference == null || weakReference.get() == null)) {
                    stringBuilder.append("[index = " + i2 + " | taskinfo:" + ((aq) weakReference.get()).dump(z) + "]\n");
                }
                i = i2 + 1;
            }
        }
        concurrentHashMap.clear();
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(52109);
        return stringBuilder2;
    }

    public static String dump(Runnable runnable, boolean z) {
        AppMethodBeat.i(52110);
        String str;
        if (runnable == null) {
            str = "";
            AppMethodBeat.o(52110);
            return str;
        } else if (runnable instanceof aq) {
            str = ((aq) runnable).dump(z);
            AppMethodBeat.o(52110);
            return str;
        } else {
            str = runnable.toString();
            AppMethodBeat.o(52110);
            return str;
        }
    }

    public Runnable findTaskByRunTime(long j) {
        AppMethodBeat.i(52111);
        Iterator it = new ConcurrentHashMap(this.map).values().iterator();
        long currentTimeMillis = System.currentTimeMillis();
        if (it != null) {
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (!(weakReference == null || weakReference.get() == null)) {
                    aq aqVar = (aq) weakReference.get();
                    if (aqVar.started && aqVar.fpi >= aqVar.cmn && currentTimeMillis - aqVar.fpi > j) {
                        ab.i(TAG, "findTaskByRunTime limit: %d, found task info: %s", Long.valueOf(j), aqVar.dump(true));
                        AppMethodBeat.o(52111);
                        return aqVar;
                    }
                }
            }
        }
        ab.i(TAG, "findTaskByRunTime limit: %d, not found!", Long.valueOf(j));
        AppMethodBeat.o(52111);
        return null;
    }

    public Runnable findTaskByName(String str) {
        AppMethodBeat.i(52112);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(52112);
            return null;
        }
        Iterator it = new ConcurrentHashMap(this.map).values().iterator();
        if (it != null) {
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (!(weakReference == null || weakReference.get() == null)) {
                    aq aqVar = (aq) weakReference.get();
                    if (aqVar.eOn.equals(str)) {
                        ab.i(TAG, "findTaskByName: %s, found task info: %s", str, aqVar.dump(true));
                        AppMethodBeat.o(52112);
                        return aqVar;
                    }
                }
            }
        }
        ab.i(TAG, "findTaskByName: %s, not found!", str);
        AppMethodBeat.o(52112);
        return null;
    }
}
