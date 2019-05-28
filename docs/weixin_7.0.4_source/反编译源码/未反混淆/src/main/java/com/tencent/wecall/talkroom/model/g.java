package com.tencent.wecall.talkroom.model;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.am;
import com.tencent.pb.common.c.h;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class g {
    List<a> callbacks = new LinkedList();
    Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: com.tencent.wecall.talkroom.model.g$17 */
    class AnonymousClass17 implements Runnable {
        final /* synthetic */ byte[] AKO;
        final /* synthetic */ String kAC;

        AnonymousClass17(String str, byte[] bArr) {
            this.kAC = str;
            this.AKO = bArr;
        }

        public final void run() {
            AppMethodBeat.i(127964);
            synchronized (g.this.callbacks) {
                try {
                    for (a H : g.this.callbacks) {
                        H.H(this.kAC, this.AKO);
                    }
                } finally {
                    AppMethodBeat.o(127964);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int AKJ;

        AnonymousClass1(int i) {
            this.AKJ = i;
        }

        public final void run() {
            AppMethodBeat.i(127948);
            synchronized (g.this.callbacks) {
                try {
                    for (a ze : g.this.callbacks) {
                        ze.ze(this.AKJ);
                    }
                } finally {
                    AppMethodBeat.o(127948);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ MultiTalkGroup oGE;

        AnonymousClass7(MultiTalkGroup multiTalkGroup) {
            this.oGE = multiTalkGroup;
        }

        public final void run() {
            AppMethodBeat.i(127954);
            synchronized (g.this.callbacks) {
                try {
                    for (a q : g.this.callbacks) {
                        q.q(this.oGE);
                    }
                } finally {
                    AppMethodBeat.o(127954);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ List AKM;

        AnonymousClass11(List list) {
            this.AKM = list;
        }

        public final void run() {
            AppMethodBeat.i(127958);
            synchronized (g.this.callbacks) {
                try {
                    for (a cr : g.this.callbacks) {
                        cr.cr(this.AKM);
                    }
                } finally {
                    AppMethodBeat.o(127958);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$20 */
    class AnonymousClass20 implements Runnable {
        final /* synthetic */ MultiTalkGroup oGE;

        AnonymousClass20(MultiTalkGroup multiTalkGroup) {
            this.oGE = multiTalkGroup;
        }

        public final void run() {
            AppMethodBeat.i(127967);
            synchronized (g.this.callbacks) {
                try {
                    for (a b : g.this.callbacks) {
                        b.b(this.oGE);
                    }
                } finally {
                    AppMethodBeat.o(127967);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$14 */
    class AnonymousClass14 implements Runnable {
        final /* synthetic */ boolean kAS;

        AnonymousClass14(boolean z) {
            this.kAS = z;
        }

        public final void run() {
            AppMethodBeat.i(127961);
            synchronized (g.this.callbacks) {
                try {
                    for (a jg : g.this.callbacks) {
                        jg.jg(this.kAS);
                    }
                } finally {
                    AppMethodBeat.o(127961);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$15 */
    class AnonymousClass15 implements Runnable {
        final /* synthetic */ int AKN;

        AnonymousClass15(int i) {
            this.AKN = i;
        }

        public final void run() {
            AppMethodBeat.i(127962);
            synchronized (g.this.callbacks) {
                try {
                    for (a Sn : g.this.callbacks) {
                        Sn.Sn(this.AKN);
                    }
                } finally {
                    AppMethodBeat.o(127962);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int crd;

        AnonymousClass2(int i) {
            this.crd = i;
        }

        public final void run() {
            AppMethodBeat.i(127949);
            synchronized (g.this.callbacks) {
                try {
                    for (a Sm : g.this.callbacks) {
                        Sm.Sm(this.crd);
                    }
                } finally {
                    AppMethodBeat.o(127949);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ MultiTalkGroup oGE;

        AnonymousClass6(MultiTalkGroup multiTalkGroup) {
            this.oGE = multiTalkGroup;
        }

        public final void run() {
            AppMethodBeat.i(127953);
            synchronized (g.this.callbacks) {
                try {
                    for (a p : g.this.callbacks) {
                        p.p(this.oGE);
                    }
                } finally {
                    AppMethodBeat.o(127953);
                }
            }
        }
    }

    public interface a {
        void H(String str, byte[] bArr);

        void Sm(int i);

        void Sn(int i);

        void a(int i, MultiTalkGroup multiTalkGroup);

        void akC();

        void b(MultiTalkGroup multiTalkGroup);

        void bRN();

        void cq(String str, boolean z);

        void cr(List<am> list);

        void dTm();

        void dTn();

        void dTo();

        void eS(String str, int i);

        void fF(List<MultiTalkGroup> list);

        void g(MultiTalkGroup multiTalkGroup);

        void jg(boolean z);

        void k(int i, Object obj);

        void onStateChanged(int i);

        void p(MultiTalkGroup multiTalkGroup);

        void q(MultiTalkGroup multiTalkGroup);

        void ze(int i);
    }

    public g() {
        AppMethodBeat.i(127969);
        AppMethodBeat.o(127969);
    }

    public final void fF(final List<MultiTalkGroup> list) {
        AppMethodBeat.i(127970);
        AnonymousClass19 anonymousClass19 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(127966);
                synchronized (g.this.callbacks) {
                    try {
                        for (a fF : g.this.callbacks) {
                            fF.fF(list);
                        }
                    } finally {
                        AppMethodBeat.o(127966);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass19.run();
            AppMethodBeat.o(127970);
            return;
        }
        this.handler.post(anonymousClass19);
        AppMethodBeat.o(127970);
    }

    public final void a(final int i, final MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(127971);
        AnonymousClass21 anonymousClass21 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(127968);
                synchronized (g.this.callbacks) {
                    try {
                        for (a a : g.this.callbacks) {
                            a.a(i, multiTalkGroup);
                        }
                    } finally {
                        AppMethodBeat.o(127968);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass21.run();
            AppMethodBeat.o(127971);
            return;
        }
        this.handler.post(anonymousClass21);
        AppMethodBeat.o(127971);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(127972);
        synchronized (aVar) {
            try {
                if (this.callbacks.contains(aVar)) {
                } else {
                    this.callbacks.add(aVar);
                    AppMethodBeat.o(127972);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(127972);
            }
        }
    }

    public final void k(final int i, final Object obj) {
        AppMethodBeat.i(127973);
        AnonymousClass4 anonymousClass4 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(127951);
                synchronized (g.this.callbacks) {
                    try {
                        for (a k : g.this.callbacks) {
                            k.k(i, obj);
                        }
                    } finally {
                        AppMethodBeat.o(127951);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass4.run();
            AppMethodBeat.o(127973);
            return;
        }
        this.handler.post(anonymousClass4);
        AppMethodBeat.o(127973);
    }

    public final void g(final MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(127974);
        AnonymousClass5 anonymousClass5 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(127952);
                synchronized (g.this.callbacks) {
                    try {
                        for (a g : g.this.callbacks) {
                            g.g(multiTalkGroup);
                        }
                    } finally {
                        AppMethodBeat.o(127952);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass5.run();
            AppMethodBeat.o(127974);
            return;
        }
        this.handler.post(anonymousClass5);
        AppMethodBeat.o(127974);
    }

    public final void cq(final String str, final boolean z) {
        AppMethodBeat.i(127975);
        AnonymousClass8 anonymousClass8 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(127955);
                synchronized (g.this.callbacks) {
                    try {
                        ArrayList<a> arrayList = new ArrayList(g.this.callbacks);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(127955);
                    }
                }
                for (a cq : arrayList) {
                    cq.cq(str, z);
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass8.run();
            AppMethodBeat.o(127975);
            return;
        }
        this.handler.post(anonymousClass8);
        AppMethodBeat.o(127975);
    }

    public final void onStateChanged(final int i) {
        AppMethodBeat.i(127976);
        AnonymousClass9 anonymousClass9 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(127956);
                synchronized (g.this.callbacks) {
                    try {
                        for (a onStateChanged : g.this.callbacks) {
                            onStateChanged.onStateChanged(i);
                        }
                    } finally {
                        AppMethodBeat.o(127956);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass9.run();
            AppMethodBeat.o(127976);
            return;
        }
        this.handler.post(anonymousClass9);
        AppMethodBeat.o(127976);
    }

    public final void eS(final String str, final int i) {
        AppMethodBeat.i(127977);
        h.aB(new Runnable() {
            public final void run() {
                AppMethodBeat.i(127960);
                synchronized (g.this.callbacks) {
                    try {
                        for (a eS : g.this.callbacks) {
                            eS.eS(str, i);
                        }
                    } finally {
                        AppMethodBeat.o(127960);
                    }
                }
            }
        });
        AppMethodBeat.o(127977);
    }
}
