package com.tencent.p177mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.C7562b;
import com.tencent.p177mm.sdk.p604g.C4945a;
import com.tencent.p177mm.sdk.platformtools.C7307am.C5006a;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.sdk.platformtools.ak */
public class C7306ak implements C5006a {
    private static final String TAG = "MicroMsg.MMHandler";
    private static C4999b sLogCallback;
    private C7562b handler;
    private int latestSize;
    private LinkedList<WeakReference<C5017aq>> latestTasks = new LinkedList();
    private ConcurrentHashMap<Runnable, WeakReference<C5017aq>> map = new ConcurrentHashMap();
    private String toStringResult = null;

    /* renamed from: com.tencent.mm.sdk.platformtools.ak$a */
    public interface C4998a extends Callback {
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.ak$b */
    public interface C4999b {
        /* renamed from: a */
        void mo5424a(Message message, Runnable runnable, Thread thread, long j, long j2, float f);
    }

    public C7306ak() {
        AppMethodBeat.m2504i(52066);
        if (Looper.myLooper() == null) {
            C4990ab.m7421w(TAG, "[MMHandler] myLooper() == null loopTag:%s", C4945a.getTag());
            this.handler = new C7562b(C5046bo.m7532bc(C4945a.getTag(), TAG), null, (C5006a) this);
            AppMethodBeat.m2505o(52066);
            return;
        }
        this.handler = new C7562b(this);
        if (getLooper().getThread().getName().equals("initThread")) {
            C4990ab.m7413e(TAG, "MMHandler can not init handler with initThread looper, stack %s", C5046bo.dpG());
        }
        AppMethodBeat.m2505o(52066);
    }

    public C7306ak(Looper looper) {
        AppMethodBeat.m2504i(52067);
        this.handler = new C7562b(looper, (C5006a) this);
        if (looper.getThread().getName().equals("initThread")) {
            C4990ab.m7413e(TAG, "MMHandler can not init handler with initThread looper, stack %s", C5046bo.dpG());
        }
        AppMethodBeat.m2505o(52067);
    }

    public C7306ak(C4998a c4998a) {
        AppMethodBeat.m2504i(52068);
        if (Looper.myLooper() == null) {
            C4990ab.m7421w(TAG, "[MMHandler] myLooper() == null loopTag:%s", C4945a.getTag());
            this.handler = new C7562b(C5046bo.m7532bc(C4945a.getTag(), TAG), (Callback) c4998a, (C5006a) this);
            AppMethodBeat.m2505o(52068);
            return;
        }
        this.handler = new C7562b((Callback) c4998a, (C5006a) this);
        if (getLooper().getThread().getName().equals("initThread")) {
            C4990ab.m7413e(TAG, "MMHandler can not init handler with initThread looper, stack %s", C5046bo.dpG());
        }
        AppMethodBeat.m2505o(52068);
    }

    public C7306ak(Looper looper, C4998a c4998a) {
        AppMethodBeat.m2504i(52069);
        this.handler = new C7562b(looper, (Callback) c4998a, (C5006a) this);
        if (looper.getThread().getName().equals("initThread")) {
            C4990ab.m7413e(TAG, "MMHandler can not init handler with initThread looper, stack %s", C5046bo.dpG());
        }
        AppMethodBeat.m2505o(52069);
    }

    public C7306ak(String str, C4998a c4998a) {
        AppMethodBeat.m2504i(52070);
        this.handler = new C7562b(str, (Callback) c4998a, (C5006a) this);
        AppMethodBeat.m2505o(52070);
    }

    public C7306ak(String str) {
        AppMethodBeat.m2504i(52071);
        this.handler = new C7562b(str, null, (C5006a) this);
        AppMethodBeat.m2505o(52071);
    }

    public String getLoopTag() {
        return this.handler.xxq;
    }

    @TargetApi(14)
    public String getMessageName(Message message) {
        AppMethodBeat.m2504i(52072);
        String messageName;
        if (VERSION.SDK_INT >= 14) {
            messageName = this.handler.getMessageName(message);
            AppMethodBeat.m2505o(52072);
            return messageName;
        } else if (message.getCallback() != null) {
            messageName = message.getCallback().getClass().getName();
            AppMethodBeat.m2505o(52072);
            return messageName;
        } else {
            messageName = "0x" + Integer.toHexString(message.what);
            AppMethodBeat.m2505o(52072);
            return messageName;
        }
    }

    public final Message obtainMessage() {
        AppMethodBeat.m2504i(52073);
        Message obtainMessage = this.handler.obtainMessage();
        AppMethodBeat.m2505o(52073);
        return obtainMessage;
    }

    public final Message obtainMessage(int i) {
        AppMethodBeat.m2504i(52074);
        Message obtainMessage = this.handler.obtainMessage(i);
        AppMethodBeat.m2505o(52074);
        return obtainMessage;
    }

    public final Message obtainMessage(int i, Object obj) {
        AppMethodBeat.m2504i(52075);
        Message obtainMessage = this.handler.obtainMessage(i, obj);
        AppMethodBeat.m2505o(52075);
        return obtainMessage;
    }

    public final Message obtainMessage(int i, int i2, int i3) {
        AppMethodBeat.m2504i(52076);
        Message obtainMessage = this.handler.obtainMessage(i, i2, i3);
        AppMethodBeat.m2505o(52076);
        return obtainMessage;
    }

    public final Message obtainMessage(int i, int i2, int i3, Object obj) {
        AppMethodBeat.m2504i(52077);
        Message obtainMessage = this.handler.obtainMessage(i, i2, i3, obj);
        AppMethodBeat.m2505o(52077);
        return obtainMessage;
    }

    public final boolean post(Runnable runnable) {
        AppMethodBeat.m2504i(52078);
        boolean post = this.handler.post(runnable);
        AppMethodBeat.m2505o(52078);
        return post;
    }

    public final boolean postAtTime(Runnable runnable, long j) {
        AppMethodBeat.m2504i(52079);
        boolean postAtTime = this.handler.postAtTime(runnable, j);
        AppMethodBeat.m2505o(52079);
        return postAtTime;
    }

    public final boolean postAtTime(Runnable runnable, Object obj, long j) {
        AppMethodBeat.m2504i(52080);
        boolean postAtTime = this.handler.postAtTime(runnable, obj, j);
        AppMethodBeat.m2505o(52080);
        return postAtTime;
    }

    public final boolean postDelayed(Runnable runnable, long j) {
        AppMethodBeat.m2504i(52081);
        boolean postDelayed = this.handler.postDelayed(runnable, j);
        AppMethodBeat.m2505o(52081);
        return postDelayed;
    }

    public final boolean postAtFrontOfQueue(Runnable runnable) {
        AppMethodBeat.m2504i(52082);
        boolean postAtFrontOfQueue = this.handler.postAtFrontOfQueue(runnable);
        AppMethodBeat.m2505o(52082);
        return postAtFrontOfQueue;
    }

    public final boolean postAtFrontOfQueueV2(Runnable runnable) {
        AppMethodBeat.m2504i(52083);
        boolean sendMessageAtTime = this.handler.sendMessageAtTime(Message.obtain(this.handler, runnable), 0);
        AppMethodBeat.m2505o(52083);
        return sendMessageAtTime;
    }

    public final void removeCallbacks(Runnable runnable) {
        AppMethodBeat.m2504i(52084);
        if (runnable == null) {
            AppMethodBeat.m2505o(52084);
        } else if (this.handler.dnJ()) {
            this.handler.mo16750ad(runnable);
            AppMethodBeat.m2505o(52084);
        } else {
            WeakReference weakReference = (WeakReference) this.map.get(runnable);
            if (!(weakReference == null || weakReference.get() == null)) {
                this.handler.mo16750ad((Runnable) weakReference.get());
            }
            this.map.remove(runnable);
            AppMethodBeat.m2505o(52084);
        }
    }

    public final void removeCallbacks(Runnable runnable, Object obj) {
        AppMethodBeat.m2504i(52085);
        if (runnable == null) {
            AppMethodBeat.m2505o(52085);
        } else if (this.handler.dnJ()) {
            this.handler.mo16750ad(runnable);
            AppMethodBeat.m2505o(52085);
        } else {
            WeakReference weakReference = (WeakReference) this.map.get(runnable);
            if (!(weakReference == null || weakReference.get() == null || (obj != null && ((C5017aq) weakReference.get()).xxu != obj))) {
                this.handler.mo16751b((Runnable) weakReference.get(), obj);
            }
            this.map.remove(runnable);
            AppMethodBeat.m2505o(52085);
        }
    }

    public final boolean sendMessage(Message message) {
        AppMethodBeat.m2504i(52086);
        boolean sendMessage = this.handler.sendMessage(message);
        AppMethodBeat.m2505o(52086);
        return sendMessage;
    }

    public final boolean sendEmptyMessage(int i) {
        AppMethodBeat.m2504i(52087);
        boolean sendEmptyMessage = this.handler.sendEmptyMessage(i);
        AppMethodBeat.m2505o(52087);
        return sendEmptyMessage;
    }

    public final boolean sendEmptyMessageDelayed(int i, long j) {
        AppMethodBeat.m2504i(52088);
        boolean sendEmptyMessageDelayed = this.handler.sendEmptyMessageDelayed(i, j);
        AppMethodBeat.m2505o(52088);
        return sendEmptyMessageDelayed;
    }

    public final boolean sendEmptyMessageAtTime(int i, long j) {
        AppMethodBeat.m2504i(52089);
        boolean sendEmptyMessageAtTime = this.handler.sendEmptyMessageAtTime(i, j);
        AppMethodBeat.m2505o(52089);
        return sendEmptyMessageAtTime;
    }

    public final boolean sendMessageDelayed(Message message, long j) {
        AppMethodBeat.m2504i(52090);
        boolean sendMessageDelayed = this.handler.sendMessageDelayed(message, j);
        AppMethodBeat.m2505o(52090);
        return sendMessageDelayed;
    }

    public boolean sendMessageAtTime(Message message, long j) {
        AppMethodBeat.m2504i(52091);
        boolean sendMessageAtTime = this.handler.sendMessageAtTime(message, j);
        AppMethodBeat.m2505o(52091);
        return sendMessageAtTime;
    }

    public final boolean sendMessageAtFrontOfQueue(Message message) {
        AppMethodBeat.m2504i(52092);
        boolean sendMessageAtFrontOfQueue = this.handler.sendMessageAtFrontOfQueue(message);
        AppMethodBeat.m2505o(52092);
        return sendMessageAtFrontOfQueue;
    }

    public final void removeMessages(int i) {
        AppMethodBeat.m2504i(52093);
        this.handler.mo16747LT(i);
        AppMethodBeat.m2505o(52093);
    }

    public final void removeMessages(int i, Object obj) {
        AppMethodBeat.m2504i(52094);
        this.handler.mo16755p(i, obj);
        AppMethodBeat.m2505o(52094);
    }

    public final void removeCallbacksAndMessages(Object obj) {
        AppMethodBeat.m2504i(52095);
        this.handler.mo16752cz(obj);
        if (obj == null) {
            this.map.clear();
            AppMethodBeat.m2505o(52095);
            return;
        }
        Iterator it = this.map.entrySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry != null) {
                    WeakReference weakReference = (WeakReference) entry.getValue();
                    if (!(weakReference == null || weakReference.get() == null || ((C5017aq) weakReference.get()).xxu != obj)) {
                        it.remove();
                    }
                }
            }
        }
        AppMethodBeat.m2505o(52095);
    }

    public final boolean hasMessages(int i) {
        AppMethodBeat.m2504i(52096);
        boolean LU = this.handler.mo16748LU(i);
        AppMethodBeat.m2505o(52096);
        return LU;
    }

    public final boolean hasMessages(int i, Object obj) {
        AppMethodBeat.m2504i(52097);
        boolean q = this.handler.mo16756q(i, obj);
        AppMethodBeat.m2505o(52097);
        return q;
    }

    public final Looper getLooper() {
        AppMethodBeat.m2504i(52098);
        Looper dnK = this.handler.dnK();
        AppMethodBeat.m2505o(52098);
        return dnK;
    }

    public final void dump(Printer printer, String str) {
        AppMethodBeat.m2504i(52099);
        this.handler.mo16749a(printer, str);
        AppMethodBeat.m2505o(52099);
    }

    public String toString() {
        AppMethodBeat.m2504i(52100);
        if (this.toStringResult == null) {
            this.toStringResult = "MMHandler(" + getClass().getName() + ")";
        }
        String str = this.toStringResult;
        AppMethodBeat.m2505o(52100);
        return str;
    }

    public void handleMessage(Message message) {
    }

    public void onTaskAdded(Runnable runnable, C5017aq c5017aq) {
        AppMethodBeat.m2504i(52101);
        this.map.put(runnable, new WeakReference(c5017aq));
        AppMethodBeat.m2505o(52101);
    }

    public void onTaskRunEnd(Runnable runnable, C5017aq c5017aq) {
        AppMethodBeat.m2504i(52102);
        WeakReference weakReference = (WeakReference) this.map.get(runnable);
        if (!(weakReference == null || weakReference.get() == null || weakReference.get() != c5017aq)) {
            this.map.remove(runnable);
            if (this.latestSize > 0) {
                if (this.latestTasks.size() == this.latestSize) {
                    this.latestTasks.pop();
                }
                this.latestTasks.add(weakReference);
            }
        }
        AppMethodBeat.m2505o(52102);
    }

    public static Handler fetchFreeHandler() {
        AppMethodBeat.m2504i(52103);
        Handler handler = new Handler();
        AppMethodBeat.m2505o(52103);
        return handler;
    }

    public static Handler fetchFreeHandler(Looper looper) {
        AppMethodBeat.m2504i(52104);
        Handler handler = new Handler(looper);
        AppMethodBeat.m2505o(52104);
        return handler;
    }

    public static Handler fetchFreeHandler(C4998a c4998a) {
        AppMethodBeat.m2504i(52105);
        Handler handler = new Handler(c4998a);
        AppMethodBeat.m2505o(52105);
        return handler;
    }

    public static Handler fetchFreeHandler(Looper looper, C4998a c4998a) {
        AppMethodBeat.m2504i(52106);
        Handler handler = new Handler(looper, c4998a);
        AppMethodBeat.m2505o(52106);
        return handler;
    }

    public static void setLogCallback(C4999b c4999b) {
        sLogCallback = c4999b;
    }

    public void onLog(Message message, Runnable runnable, Thread thread, long j, long j2, long j3, float f) {
        AppMethodBeat.m2504i(52107);
        if (sLogCallback != null) {
            sLogCallback.mo5424a(message, runnable, thread, j, j2, f);
        }
        AppMethodBeat.m2505o(52107);
    }

    public void setLatestSize(int i) {
        this.latestSize = i;
    }

    public String dumpLatestTasks(boolean z) {
        AppMethodBeat.m2504i(52108);
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
                    stringBuilder.append("[index = " + i2 + "|task=" + ((C5017aq) weakReference.get()).dump(z) + "]");
                }
                i = i2 + 1;
            }
        }
        linkedList.clear();
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(52108);
        return stringBuilder2;
    }

    public String dump(boolean z) {
        AppMethodBeat.m2504i(52109);
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
                    stringBuilder.append("[index = " + i2 + " | taskinfo:" + ((C5017aq) weakReference.get()).dump(z) + "]\n");
                }
                i = i2 + 1;
            }
        }
        concurrentHashMap.clear();
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(52109);
        return stringBuilder2;
    }

    public static String dump(Runnable runnable, boolean z) {
        AppMethodBeat.m2504i(52110);
        String str;
        if (runnable == null) {
            str = "";
            AppMethodBeat.m2505o(52110);
            return str;
        } else if (runnable instanceof C5017aq) {
            str = ((C5017aq) runnable).dump(z);
            AppMethodBeat.m2505o(52110);
            return str;
        } else {
            str = runnable.toString();
            AppMethodBeat.m2505o(52110);
            return str;
        }
    }

    public Runnable findTaskByRunTime(long j) {
        AppMethodBeat.m2504i(52111);
        Iterator it = new ConcurrentHashMap(this.map).values().iterator();
        long currentTimeMillis = System.currentTimeMillis();
        if (it != null) {
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (!(weakReference == null || weakReference.get() == null)) {
                    C5017aq c5017aq = (C5017aq) weakReference.get();
                    if (c5017aq.started && c5017aq.fpi >= c5017aq.cmn && currentTimeMillis - c5017aq.fpi > j) {
                        C4990ab.m7417i(TAG, "findTaskByRunTime limit: %d, found task info: %s", Long.valueOf(j), c5017aq.dump(true));
                        AppMethodBeat.m2505o(52111);
                        return c5017aq;
                    }
                }
            }
        }
        C4990ab.m7417i(TAG, "findTaskByRunTime limit: %d, not found!", Long.valueOf(j));
        AppMethodBeat.m2505o(52111);
        return null;
    }

    public Runnable findTaskByName(String str) {
        AppMethodBeat.m2504i(52112);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(52112);
            return null;
        }
        Iterator it = new ConcurrentHashMap(this.map).values().iterator();
        if (it != null) {
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (!(weakReference == null || weakReference.get() == null)) {
                    C5017aq c5017aq = (C5017aq) weakReference.get();
                    if (c5017aq.eOn.equals(str)) {
                        C4990ab.m7417i(TAG, "findTaskByName: %s, found task info: %s", str, c5017aq.dump(true));
                        AppMethodBeat.m2505o(52112);
                        return c5017aq;
                    }
                }
            }
        }
        C4990ab.m7417i(TAG, "findTaskByName: %s, not found!", str);
        AppMethodBeat.m2505o(52112);
        return null;
    }
}
