package com.tencent.mm.sdk;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.am;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public final class b extends am {
    public String xxq = null;
    HashMap<a, LinkedList<Runnable>> xxr = new HashMap();

    class a {
        Runnable callback;
        int what;
        Object xxu;

        public a(int i, Object obj, Runnable runnable) {
            this.what = i;
            this.xxu = obj;
            this.callback = runnable;
        }

        public final int hashCode() {
            int i = 0;
            AppMethodBeat.i(51940);
            int hashCode = this.xxu != null ? this.xxu.hashCode() : 0;
            if (this.callback != null) {
                i = this.callback.hashCode();
            }
            hashCode = (hashCode + i) + this.what;
            AppMethodBeat.o(51940);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (aVar.what == this.what && aVar.callback == this.callback && aVar.xxu == this.xxu) {
                return true;
            }
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(51941);
            String str = "WrapMessage{token=" + this.xxu + ", what=" + this.what + ", callback=" + this.callback + '}';
            AppMethodBeat.o(51941);
            return str;
        }
    }

    public b(String str, Callback callback, com.tencent.mm.sdk.platformtools.am.a aVar) {
        super(Looper.getMainLooper(), callback, aVar);
        AppMethodBeat.i(51942);
        this.xxq = str;
        AppMethodBeat.o(51942);
    }

    public b(com.tencent.mm.sdk.platformtools.am.a aVar) {
        super(aVar);
        AppMethodBeat.i(51943);
        AppMethodBeat.o(51943);
    }

    public b(Looper looper, com.tencent.mm.sdk.platformtools.am.a aVar) {
        super(looper, aVar);
        AppMethodBeat.i(51944);
        AppMethodBeat.o(51944);
    }

    public b(Callback callback, com.tencent.mm.sdk.platformtools.am.a aVar) {
        super(callback, aVar);
        AppMethodBeat.i(51945);
        AppMethodBeat.o(51945);
    }

    public b(Looper looper, Callback callback, com.tencent.mm.sdk.platformtools.am.a aVar) {
        super(looper, callback, aVar);
        AppMethodBeat.i(51946);
        AppMethodBeat.o(51946);
    }

    public final boolean sendMessageAtTime(final Message message, long j) {
        AppMethodBeat.i(51947);
        if (dnJ()) {
            AnonymousClass1 anonymousClass1 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(51939);
                    b.this.dispatchMessage(message);
                    b.a(b.this, message, this);
                    AppMethodBeat.o(51939);
                }
            };
            synchronized (this.xxr) {
                try {
                    LinkedList linkedList;
                    a aVar = new a(message.what, message.obj, message.getCallback());
                    if (this.xxr.containsKey(aVar)) {
                        linkedList = (LinkedList) this.xxr.get(aVar);
                    } else {
                        HashMap hashMap = this.xxr;
                        linkedList = new LinkedList();
                        hashMap.put(aVar, linkedList);
                    }
                    linkedList.add(anonymousClass1);
                } finally {
                    AppMethodBeat.o(51947);
                }
            }
            d.xDH.a(anonymousClass1, this.xxq, j - SystemClock.uptimeMillis());
            return true;
        }
        boolean sendMessageAtTime = super.sendMessageAtTime(message, j);
        AppMethodBeat.o(51947);
        return sendMessageAtTime;
    }

    private List<Runnable> a(Runnable runnable, Object obj) {
        AppMethodBeat.i(51948);
        LinkedList linkedList = new LinkedList();
        synchronized (this.xxr) {
            try {
                Iterator it = this.xxr.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    a aVar = (a) entry.getKey();
                    if ((runnable == null || aVar.callback == runnable) && (obj == null || obj == aVar.xxu)) {
                        linkedList.addAll((Collection) entry.getValue());
                        it.remove();
                    }
                }
            } finally {
                AppMethodBeat.o(51948);
            }
        }
        return linkedList;
    }

    private List<Runnable> n(int i, Object obj) {
        AppMethodBeat.i(51949);
        LinkedList linkedList = new LinkedList();
        synchronized (this.xxr) {
            try {
                Iterator it = this.xxr.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    a aVar = (a) entry.getKey();
                    if (aVar.what == i && (obj == null || obj == aVar.xxu)) {
                        linkedList.addAll((Collection) entry.getValue());
                        it.remove();
                    }
                }
            } finally {
                AppMethodBeat.o(51949);
            }
        }
        return linkedList;
    }

    private boolean o(int i, Object obj) {
        boolean z;
        AppMethodBeat.i(51950);
        synchronized (this.xxr) {
            try {
                for (a aVar : this.xxr.keySet()) {
                    if (aVar.what == i && aVar.xxu == obj) {
                        z = true;
                        break;
                    }
                }
                z = false;
                AppMethodBeat.o(51950);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(51950);
            }
        }
        return z;
    }

    public final boolean dnJ() {
        AppMethodBeat.i(51951);
        if (TextUtils.isEmpty(this.xxq)) {
            AppMethodBeat.o(51951);
            return false;
        }
        AppMethodBeat.o(51951);
        return true;
    }

    public final void ad(Runnable runnable) {
        AppMethodBeat.i(51952);
        if (dnJ()) {
            List<Runnable> a = a(runnable, null);
            for (Runnable al : a) {
                d.xDH.al(al);
            }
            a.clear();
            AppMethodBeat.o(51952);
            return;
        }
        super.removeCallbacks(runnable);
        AppMethodBeat.o(51952);
    }

    public final void b(Runnable runnable, Object obj) {
        AppMethodBeat.i(51953);
        if (dnJ()) {
            List<Runnable> a = a(runnable, obj);
            for (Runnable al : a) {
                d.xDH.al(al);
            }
            a.clear();
            AppMethodBeat.o(51953);
            return;
        }
        super.removeCallbacks(runnable, obj);
        AppMethodBeat.o(51953);
    }

    public final void LT(int i) {
        AppMethodBeat.i(51954);
        if (dnJ()) {
            List<Runnable> n = n(i, null);
            for (Runnable al : n) {
                d.xDH.al(al);
            }
            n.clear();
            AppMethodBeat.o(51954);
            return;
        }
        super.removeMessages(i);
        AppMethodBeat.o(51954);
    }

    public final void p(int i, Object obj) {
        AppMethodBeat.i(51955);
        if (dnJ()) {
            List<Runnable> n = n(i, obj);
            for (Runnable al : n) {
                d.xDH.al(al);
            }
            n.clear();
            AppMethodBeat.o(51955);
            return;
        }
        super.removeMessages(i, obj);
        AppMethodBeat.o(51955);
    }

    public final void cz(Object obj) {
        AppMethodBeat.i(51956);
        if (dnJ()) {
            d.xDG.remove(this.xxq);
            List<Runnable> a = a(null, obj);
            for (Runnable al : a) {
                d.xDH.al(al);
            }
            a.clear();
            AppMethodBeat.o(51956);
            return;
        }
        super.removeCallbacksAndMessages(obj);
        AppMethodBeat.o(51956);
    }

    public final boolean LU(int i) {
        AppMethodBeat.i(51957);
        boolean o;
        if (dnJ()) {
            o = o(i, null);
            AppMethodBeat.o(51957);
            return o;
        }
        o = super.hasMessages(i);
        AppMethodBeat.o(51957);
        return o;
    }

    public final boolean q(int i, Object obj) {
        AppMethodBeat.i(51958);
        boolean o;
        if (dnJ()) {
            o = o(i, obj);
            AppMethodBeat.o(51958);
            return o;
        }
        o = super.hasMessages(i, obj);
        AppMethodBeat.o(51958);
        return o;
    }

    public final Looper dnK() {
        AppMethodBeat.i(51959);
        if (dnJ()) {
            AppMethodBeat.o(51959);
            return null;
        }
        Looper looper = super.getLooper();
        AppMethodBeat.o(51959);
        return looper;
    }

    public final void a(Printer printer, String str) {
        AppMethodBeat.i(51960);
        if (dnJ()) {
            printer.println(str + "use ThreadPool");
            AppMethodBeat.o(51960);
            return;
        }
        super.dump(printer, str);
        AppMethodBeat.o(51960);
    }

    static /* synthetic */ void a(b bVar, Message message, Runnable runnable) {
        AppMethodBeat.i(51961);
        int i = message.what;
        Object obj = message.obj;
        Runnable callback = message.getCallback();
        synchronized (bVar.xxr) {
            try {
                a aVar = new a(i, obj, callback);
                LinkedList linkedList = (LinkedList) bVar.xxr.remove(aVar);
                if (linkedList != null) {
                    linkedList.remove(runnable);
                    if (linkedList.size() > 0) {
                        bVar.xxr.put(aVar, linkedList);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(51961);
            }
        }
    }
}
