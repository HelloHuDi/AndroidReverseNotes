package com.tencent.wecall.talkroom.model;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C30916h;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24190am;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.wecall.talkroom.model.g */
public final class C6006g {
    List<C6028a> callbacks = new LinkedList();
    Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: com.tencent.wecall.talkroom.model.g$10 */
    class C600710 implements Runnable {
        C600710() {
        }

        public final void run() {
            AppMethodBeat.m2504i(127957);
            synchronized (C6006g.this.callbacks) {
                try {
                    for (C6028a dTm : C6006g.this.callbacks) {
                        dTm.dTm();
                    }
                } finally {
                    AppMethodBeat.m2505o(127957);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$12 */
    class C600812 implements Runnable {
        C600812() {
        }

        public final void run() {
            AppMethodBeat.m2504i(127959);
            synchronized (C6006g.this.callbacks) {
                try {
                    for (C6028a dTn : C6006g.this.callbacks) {
                        dTn.dTn();
                    }
                } finally {
                    AppMethodBeat.m2505o(127959);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$17 */
    class C601017 implements Runnable {
        final /* synthetic */ byte[] AKO;
        final /* synthetic */ String kAC;

        C601017(String str, byte[] bArr) {
            this.kAC = str;
            this.AKO = bArr;
        }

        public final void run() {
            AppMethodBeat.m2504i(127964);
            synchronized (C6006g.this.callbacks) {
                try {
                    for (C6028a H : C6006g.this.callbacks) {
                        H.mo13173H(this.kAC, this.AKO);
                    }
                } finally {
                    AppMethodBeat.m2505o(127964);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$18 */
    class C601118 implements Runnable {
        C601118() {
        }

        public final void run() {
            AppMethodBeat.m2504i(127965);
            synchronized (C6006g.this.callbacks) {
                try {
                    for (C6028a dTo : C6006g.this.callbacks) {
                        dTo.dTo();
                    }
                } finally {
                    AppMethodBeat.m2505o(127965);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$1 */
    class C60131 implements Runnable {
        final /* synthetic */ int AKJ;

        C60131(int i) {
            this.AKJ = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(127948);
            synchronized (C6006g.this.callbacks) {
                try {
                    for (C6028a ze : C6006g.this.callbacks) {
                        ze.mo13193ze(this.AKJ);
                    }
                } finally {
                    AppMethodBeat.m2505o(127948);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$7 */
    class C60147 implements Runnable {
        final /* synthetic */ MultiTalkGroup oGE;

        C60147(MultiTalkGroup multiTalkGroup) {
            this.oGE = multiTalkGroup;
        }

        public final void run() {
            AppMethodBeat.m2504i(127954);
            synchronized (C6006g.this.callbacks) {
                try {
                    for (C6028a q : C6006g.this.callbacks) {
                        q.mo13192q(this.oGE);
                    }
                } finally {
                    AppMethodBeat.m2505o(127954);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$11 */
    class C601611 implements Runnable {
        final /* synthetic */ List AKM;

        C601611(List list) {
            this.AKM = list;
        }

        public final void run() {
            AppMethodBeat.m2504i(127958);
            synchronized (C6006g.this.callbacks) {
                try {
                    for (C6028a cr : C6006g.this.callbacks) {
                        cr.mo13181cr(this.AKM);
                    }
                } finally {
                    AppMethodBeat.m2505o(127958);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$20 */
    class C601720 implements Runnable {
        final /* synthetic */ MultiTalkGroup oGE;

        C601720(MultiTalkGroup multiTalkGroup) {
            this.oGE = multiTalkGroup;
        }

        public final void run() {
            AppMethodBeat.m2504i(127967);
            synchronized (C6006g.this.callbacks) {
                try {
                    for (C6028a b : C6006g.this.callbacks) {
                        b.mo13178b(this.oGE);
                    }
                } finally {
                    AppMethodBeat.m2505o(127967);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$14 */
    class C601914 implements Runnable {
        final /* synthetic */ boolean kAS;

        C601914(boolean z) {
            this.kAS = z;
        }

        public final void run() {
            AppMethodBeat.m2504i(127961);
            synchronized (C6006g.this.callbacks) {
                try {
                    for (C6028a jg : C6006g.this.callbacks) {
                        jg.mo13188jg(this.kAS);
                    }
                } finally {
                    AppMethodBeat.m2505o(127961);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$15 */
    class C602015 implements Runnable {
        final /* synthetic */ int AKN;

        C602015(int i) {
            this.AKN = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(127962);
            synchronized (C6006g.this.callbacks) {
                try {
                    for (C6028a Sn : C6006g.this.callbacks) {
                        Sn.mo13175Sn(this.AKN);
                    }
                } finally {
                    AppMethodBeat.m2505o(127962);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$16 */
    class C602116 implements Runnable {
        C602116() {
        }

        public final void run() {
            AppMethodBeat.m2504i(127963);
            synchronized (C6006g.this.callbacks) {
                try {
                    for (C6028a bRN : C6006g.this.callbacks) {
                        bRN.bRN();
                    }
                } finally {
                    AppMethodBeat.m2505o(127963);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$2 */
    class C60222 implements Runnable {
        final /* synthetic */ int crd;

        C60222(int i) {
            this.crd = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(127949);
            synchronized (C6006g.this.callbacks) {
                try {
                    for (C6028a Sm : C6006g.this.callbacks) {
                        Sm.mo13174Sm(this.crd);
                    }
                } finally {
                    AppMethodBeat.m2505o(127949);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$6 */
    class C60256 implements Runnable {
        final /* synthetic */ MultiTalkGroup oGE;

        C60256(MultiTalkGroup multiTalkGroup) {
            this.oGE = multiTalkGroup;
        }

        public final void run() {
            AppMethodBeat.m2504i(127953);
            synchronized (C6006g.this.callbacks) {
                try {
                    for (C6028a p : C6006g.this.callbacks) {
                        p.mo13191p(this.oGE);
                    }
                } finally {
                    AppMethodBeat.m2505o(127953);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$3 */
    class C60273 implements Runnable {
        C60273() {
        }

        public final void run() {
            AppMethodBeat.m2504i(127950);
            synchronized (C6006g.this.callbacks) {
                try {
                    for (C6028a akC : C6006g.this.callbacks) {
                        akC.akC();
                    }
                } finally {
                    AppMethodBeat.m2505o(127950);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$a */
    public interface C6028a {
        /* renamed from: H */
        void mo13173H(String str, byte[] bArr);

        /* renamed from: Sm */
        void mo13174Sm(int i);

        /* renamed from: Sn */
        void mo13175Sn(int i);

        /* renamed from: a */
        void mo13176a(int i, MultiTalkGroup multiTalkGroup);

        void akC();

        /* renamed from: b */
        void mo13178b(MultiTalkGroup multiTalkGroup);

        void bRN();

        /* renamed from: cq */
        void mo13180cq(String str, boolean z);

        /* renamed from: cr */
        void mo13181cr(List<C24190am> list);

        void dTm();

        void dTn();

        void dTo();

        /* renamed from: eS */
        void mo13185eS(String str, int i);

        /* renamed from: fF */
        void mo13186fF(List<MultiTalkGroup> list);

        /* renamed from: g */
        void mo13187g(MultiTalkGroup multiTalkGroup);

        /* renamed from: jg */
        void mo13188jg(boolean z);

        /* renamed from: k */
        void mo13189k(int i, Object obj);

        void onStateChanged(int i);

        /* renamed from: p */
        void mo13191p(MultiTalkGroup multiTalkGroup);

        /* renamed from: q */
        void mo13192q(MultiTalkGroup multiTalkGroup);

        /* renamed from: ze */
        void mo13193ze(int i);
    }

    public C6006g() {
        AppMethodBeat.m2504i(127969);
        AppMethodBeat.m2505o(127969);
    }

    /* renamed from: fF */
    public final void mo13148fF(final List<MultiTalkGroup> list) {
        AppMethodBeat.m2504i(127970);
        C601219 c601219 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(127966);
                synchronized (C6006g.this.callbacks) {
                    try {
                        for (C6028a fF : C6006g.this.callbacks) {
                            fF.mo13186fF(list);
                        }
                    } finally {
                        AppMethodBeat.m2505o(127966);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c601219.run();
            AppMethodBeat.m2505o(127970);
            return;
        }
        this.handler.post(c601219);
        AppMethodBeat.m2505o(127970);
    }

    /* renamed from: a */
    public final void mo13144a(final int i, final MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(127971);
        C601821 c601821 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(127968);
                synchronized (C6006g.this.callbacks) {
                    try {
                        for (C6028a a : C6006g.this.callbacks) {
                            a.mo13176a(i, multiTalkGroup);
                        }
                    } finally {
                        AppMethodBeat.m2505o(127968);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c601821.run();
            AppMethodBeat.m2505o(127971);
            return;
        }
        this.handler.post(c601821);
        AppMethodBeat.m2505o(127971);
    }

    /* renamed from: a */
    public final void mo13145a(C6028a c6028a) {
        AppMethodBeat.m2504i(127972);
        synchronized (c6028a) {
            try {
                if (this.callbacks.contains(c6028a)) {
                } else {
                    this.callbacks.add(c6028a);
                    AppMethodBeat.m2505o(127972);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(127972);
            }
        }
    }

    /* renamed from: k */
    public final void mo13150k(final int i, final Object obj) {
        AppMethodBeat.m2504i(127973);
        C60234 c60234 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(127951);
                synchronized (C6006g.this.callbacks) {
                    try {
                        for (C6028a k : C6006g.this.callbacks) {
                            k.mo13189k(i, obj);
                        }
                    } finally {
                        AppMethodBeat.m2505o(127951);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c60234.run();
            AppMethodBeat.m2505o(127973);
            return;
        }
        this.handler.post(c60234);
        AppMethodBeat.m2505o(127973);
    }

    /* renamed from: g */
    public final void mo13149g(final MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(127974);
        C60245 c60245 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(127952);
                synchronized (C6006g.this.callbacks) {
                    try {
                        for (C6028a g : C6006g.this.callbacks) {
                            g.mo13187g(multiTalkGroup);
                        }
                    } finally {
                        AppMethodBeat.m2505o(127952);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c60245.run();
            AppMethodBeat.m2505o(127974);
            return;
        }
        this.handler.post(c60245);
        AppMethodBeat.m2505o(127974);
    }

    /* renamed from: cq */
    public final void mo13146cq(final String str, final boolean z) {
        AppMethodBeat.m2504i(127975);
        C60158 c60158 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(127955);
                synchronized (C6006g.this.callbacks) {
                    try {
                        ArrayList<C6028a> arrayList = new ArrayList(C6006g.this.callbacks);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(127955);
                    }
                }
                for (C6028a cq : arrayList) {
                    cq.mo13180cq(str, z);
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c60158.run();
            AppMethodBeat.m2505o(127975);
            return;
        }
        this.handler.post(c60158);
        AppMethodBeat.m2505o(127975);
    }

    public final void onStateChanged(final int i) {
        AppMethodBeat.m2504i(127976);
        C60099 c60099 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(127956);
                synchronized (C6006g.this.callbacks) {
                    try {
                        for (C6028a onStateChanged : C6006g.this.callbacks) {
                            onStateChanged.onStateChanged(i);
                        }
                    } finally {
                        AppMethodBeat.m2505o(127956);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c60099.run();
            AppMethodBeat.m2505o(127976);
            return;
        }
        this.handler.post(c60099);
        AppMethodBeat.m2505o(127976);
    }

    /* renamed from: eS */
    public final void mo13147eS(final String str, final int i) {
        AppMethodBeat.m2504i(127977);
        C30916h.m49359aB(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(127960);
                synchronized (C6006g.this.callbacks) {
                    try {
                        for (C6028a eS : C6006g.this.callbacks) {
                            eS.mo13185eS(str, i);
                        }
                    } finally {
                        AppMethodBeat.m2505o(127960);
                    }
                }
            }
        });
        AppMethodBeat.m2505o(127977);
    }
}
