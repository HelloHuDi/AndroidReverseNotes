package com.tencent.p177mm.sdk;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C7307am;
import com.tencent.p177mm.sdk.platformtools.C7307am.C5006a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.sdk.b */
public final class C7562b extends C7307am {
    public String xxq = null;
    HashMap<C4875a, LinkedList<Runnable>> xxr = new HashMap();

    /* renamed from: com.tencent.mm.sdk.b$a */
    class C4875a {
        Runnable callback;
        int what;
        Object xxu;

        public C4875a(int i, Object obj, Runnable runnable) {
            this.what = i;
            this.xxu = obj;
            this.callback = runnable;
        }

        public final int hashCode() {
            int i = 0;
            AppMethodBeat.m2504i(51940);
            int hashCode = this.xxu != null ? this.xxu.hashCode() : 0;
            if (this.callback != null) {
                i = this.callback.hashCode();
            }
            hashCode = (hashCode + i) + this.what;
            AppMethodBeat.m2505o(51940);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C4875a)) {
                return false;
            }
            C4875a c4875a = (C4875a) obj;
            if (c4875a.what == this.what && c4875a.callback == this.callback && c4875a.xxu == this.xxu) {
                return true;
            }
            return false;
        }

        public final String toString() {
            AppMethodBeat.m2504i(51941);
            String str = "WrapMessage{token=" + this.xxu + ", what=" + this.what + ", callback=" + this.callback + '}';
            AppMethodBeat.m2505o(51941);
            return str;
        }
    }

    public C7562b(String str, Callback callback, C5006a c5006a) {
        super(Looper.getMainLooper(), callback, c5006a);
        AppMethodBeat.m2504i(51942);
        this.xxq = str;
        AppMethodBeat.m2505o(51942);
    }

    public C7562b(C5006a c5006a) {
        super(c5006a);
        AppMethodBeat.m2504i(51943);
        AppMethodBeat.m2505o(51943);
    }

    public C7562b(Looper looper, C5006a c5006a) {
        super(looper, c5006a);
        AppMethodBeat.m2504i(51944);
        AppMethodBeat.m2505o(51944);
    }

    public C7562b(Callback callback, C5006a c5006a) {
        super(callback, c5006a);
        AppMethodBeat.m2504i(51945);
        AppMethodBeat.m2505o(51945);
    }

    public C7562b(Looper looper, Callback callback, C5006a c5006a) {
        super(looper, callback, c5006a);
        AppMethodBeat.m2504i(51946);
        AppMethodBeat.m2505o(51946);
    }

    public final boolean sendMessageAtTime(final Message message, long j) {
        AppMethodBeat.m2504i(51947);
        if (dnJ()) {
            C48741 c48741 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(51939);
                    C7562b.this.dispatchMessage(message);
                    C7562b.m13206a(C7562b.this, message, this);
                    AppMethodBeat.m2505o(51939);
                }
            };
            synchronized (this.xxr) {
                try {
                    LinkedList linkedList;
                    C4875a c4875a = new C4875a(message.what, message.obj, message.getCallback());
                    if (this.xxr.containsKey(c4875a)) {
                        linkedList = (LinkedList) this.xxr.get(c4875a);
                    } else {
                        HashMap hashMap = this.xxr;
                        linkedList = new LinkedList();
                        hashMap.put(c4875a, linkedList);
                    }
                    linkedList.add(c48741);
                } finally {
                    AppMethodBeat.m2505o(51947);
                }
            }
            C7305d.xDH.mo10141a(c48741, this.xxq, j - SystemClock.uptimeMillis());
            return true;
        }
        boolean sendMessageAtTime = super.sendMessageAtTime(message, j);
        AppMethodBeat.m2505o(51947);
        return sendMessageAtTime;
    }

    /* renamed from: a */
    private List<Runnable> m13205a(Runnable runnable, Object obj) {
        AppMethodBeat.m2504i(51948);
        LinkedList linkedList = new LinkedList();
        synchronized (this.xxr) {
            try {
                Iterator it = this.xxr.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    C4875a c4875a = (C4875a) entry.getKey();
                    if ((runnable == null || c4875a.callback == runnable) && (obj == null || obj == c4875a.xxu)) {
                        linkedList.addAll((Collection) entry.getValue());
                        it.remove();
                    }
                }
            } finally {
                AppMethodBeat.m2505o(51948);
            }
        }
        return linkedList;
    }

    /* renamed from: n */
    private List<Runnable> m13207n(int i, Object obj) {
        AppMethodBeat.m2504i(51949);
        LinkedList linkedList = new LinkedList();
        synchronized (this.xxr) {
            try {
                Iterator it = this.xxr.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    C4875a c4875a = (C4875a) entry.getKey();
                    if (c4875a.what == i && (obj == null || obj == c4875a.xxu)) {
                        linkedList.addAll((Collection) entry.getValue());
                        it.remove();
                    }
                }
            } finally {
                AppMethodBeat.m2505o(51949);
            }
        }
        return linkedList;
    }

    /* renamed from: o */
    private boolean m13208o(int i, Object obj) {
        boolean z;
        AppMethodBeat.m2504i(51950);
        synchronized (this.xxr) {
            try {
                for (C4875a c4875a : this.xxr.keySet()) {
                    if (c4875a.what == i && c4875a.xxu == obj) {
                        z = true;
                        break;
                    }
                }
                z = false;
                AppMethodBeat.m2505o(51950);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(51950);
            }
        }
        return z;
    }

    public final boolean dnJ() {
        AppMethodBeat.m2504i(51951);
        if (TextUtils.isEmpty(this.xxq)) {
            AppMethodBeat.m2505o(51951);
            return false;
        }
        AppMethodBeat.m2505o(51951);
        return true;
    }

    /* renamed from: ad */
    public final void mo16750ad(Runnable runnable) {
        AppMethodBeat.m2504i(51952);
        if (dnJ()) {
            List<Runnable> a = m13205a(runnable, null);
            for (Runnable al : a) {
                C7305d.xDH.mo10143al(al);
            }
            a.clear();
            AppMethodBeat.m2505o(51952);
            return;
        }
        super.removeCallbacks(runnable);
        AppMethodBeat.m2505o(51952);
    }

    /* renamed from: b */
    public final void mo16751b(Runnable runnable, Object obj) {
        AppMethodBeat.m2504i(51953);
        if (dnJ()) {
            List<Runnable> a = m13205a(runnable, obj);
            for (Runnable al : a) {
                C7305d.xDH.mo10143al(al);
            }
            a.clear();
            AppMethodBeat.m2505o(51953);
            return;
        }
        super.removeCallbacks(runnable, obj);
        AppMethodBeat.m2505o(51953);
    }

    /* renamed from: LT */
    public final void mo16747LT(int i) {
        AppMethodBeat.m2504i(51954);
        if (dnJ()) {
            List<Runnable> n = m13207n(i, null);
            for (Runnable al : n) {
                C7305d.xDH.mo10143al(al);
            }
            n.clear();
            AppMethodBeat.m2505o(51954);
            return;
        }
        super.removeMessages(i);
        AppMethodBeat.m2505o(51954);
    }

    /* renamed from: p */
    public final void mo16755p(int i, Object obj) {
        AppMethodBeat.m2504i(51955);
        if (dnJ()) {
            List<Runnable> n = m13207n(i, obj);
            for (Runnable al : n) {
                C7305d.xDH.mo10143al(al);
            }
            n.clear();
            AppMethodBeat.m2505o(51955);
            return;
        }
        super.removeMessages(i, obj);
        AppMethodBeat.m2505o(51955);
    }

    /* renamed from: cz */
    public final void mo16752cz(Object obj) {
        AppMethodBeat.m2504i(51956);
        if (dnJ()) {
            C7305d.xDG.remove(this.xxq);
            List<Runnable> a = m13205a(null, obj);
            for (Runnable al : a) {
                C7305d.xDH.mo10143al(al);
            }
            a.clear();
            AppMethodBeat.m2505o(51956);
            return;
        }
        super.removeCallbacksAndMessages(obj);
        AppMethodBeat.m2505o(51956);
    }

    /* renamed from: LU */
    public final boolean mo16748LU(int i) {
        AppMethodBeat.m2504i(51957);
        boolean o;
        if (dnJ()) {
            o = m13208o(i, null);
            AppMethodBeat.m2505o(51957);
            return o;
        }
        o = super.hasMessages(i);
        AppMethodBeat.m2505o(51957);
        return o;
    }

    /* renamed from: q */
    public final boolean mo16756q(int i, Object obj) {
        AppMethodBeat.m2504i(51958);
        boolean o;
        if (dnJ()) {
            o = m13208o(i, obj);
            AppMethodBeat.m2505o(51958);
            return o;
        }
        o = super.hasMessages(i, obj);
        AppMethodBeat.m2505o(51958);
        return o;
    }

    public final Looper dnK() {
        AppMethodBeat.m2504i(51959);
        if (dnJ()) {
            AppMethodBeat.m2505o(51959);
            return null;
        }
        Looper looper = super.getLooper();
        AppMethodBeat.m2505o(51959);
        return looper;
    }

    /* renamed from: a */
    public final void mo16749a(Printer printer, String str) {
        AppMethodBeat.m2504i(51960);
        if (dnJ()) {
            printer.println(str + "use ThreadPool");
            AppMethodBeat.m2505o(51960);
            return;
        }
        super.dump(printer, str);
        AppMethodBeat.m2505o(51960);
    }

    /* renamed from: a */
    static /* synthetic */ void m13206a(C7562b c7562b, Message message, Runnable runnable) {
        AppMethodBeat.m2504i(51961);
        int i = message.what;
        Object obj = message.obj;
        Runnable callback = message.getCallback();
        synchronized (c7562b.xxr) {
            try {
                C4875a c4875a = new C4875a(i, obj, callback);
                LinkedList linkedList = (LinkedList) c7562b.xxr.remove(c4875a);
                if (linkedList != null) {
                    linkedList.remove(runnable);
                    if (linkedList.size() > 0) {
                        c7562b.xxr.put(c4875a, linkedList);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(51961);
            }
        }
    }
}
