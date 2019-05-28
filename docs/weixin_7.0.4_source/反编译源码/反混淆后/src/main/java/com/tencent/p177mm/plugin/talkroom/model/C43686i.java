package com.tencent.p177mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p203bg.C32336d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.talkroom.model.i */
public final class C43686i {
    List<C32336d> callbacks = new LinkedList();
    C7306ak handler = new C7306ak(Looper.getMainLooper());

    /* renamed from: com.tencent.mm.plugin.talkroom.model.i$2 */
    class C139352 implements Runnable {
        C139352() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25848);
            synchronized (C43686i.this.callbacks) {
                try {
                    for (C32336d akF : C43686i.this.callbacks) {
                        akF.akF();
                    }
                } finally {
                    AppMethodBeat.m2505o(25848);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.model.i$4 */
    class C223944 implements Runnable {
        C223944() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25850);
            synchronized (C43686i.this.callbacks) {
                try {
                    for (C32336d akH : C43686i.this.callbacks) {
                        akH.akH();
                    }
                } finally {
                    AppMethodBeat.m2505o(25850);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.model.i$3 */
    class C294213 implements Runnable {
        C294213() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25849);
            synchronized (C43686i.this.callbacks) {
                try {
                    for (C32336d akG : C43686i.this.callbacks) {
                        akG.akG();
                    }
                } finally {
                    AppMethodBeat.m2505o(25849);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.model.i$6 */
    class C352846 implements Runnable {
        C352846() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25852);
            synchronized (C43686i.this.callbacks) {
                try {
                    for (C32336d akD : C43686i.this.callbacks) {
                        akD.akD();
                    }
                } finally {
                    AppMethodBeat.m2505o(25852);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.model.i$10 */
    class C3995410 implements Runnable {
        final /* synthetic */ String nKY;
        final /* synthetic */ String nKZ;

        C3995410(String str, String str2) {
            this.nKY = str;
            this.nKZ = str2;
        }

        public final void run() {
            AppMethodBeat.m2504i(25856);
            synchronized (C43686i.this.callbacks) {
                try {
                    for (C32336d aU : C43686i.this.callbacks) {
                        aU.mo53053aU(this.nKY, this.nKZ);
                    }
                } finally {
                    AppMethodBeat.m2505o(25856);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.model.i$12 */
    class C3995512 implements Runnable {
        C3995512() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25858);
            synchronized (C43686i.this.callbacks) {
                try {
                    for (C32336d akE : C43686i.this.callbacks) {
                        akE.akE();
                    }
                } finally {
                    AppMethodBeat.m2505o(25858);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.model.i$11 */
    class C4368711 implements Runnable {
        final /* synthetic */ String ejI;

        C4368711(String str) {
            this.ejI = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(25857);
            synchronized (C43686i.this.callbacks) {
                try {
                    Iterator it = C43686i.this.callbacks.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } finally {
                    AppMethodBeat.m2505o(25857);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.model.i$1 */
    class C436881 implements Runnable {
        C436881() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25847);
            synchronized (C43686i.this.callbacks) {
                try {
                    for (C32336d akC : C43686i.this.callbacks) {
                        akC.akC();
                    }
                } finally {
                    AppMethodBeat.m2505o(25847);
                }
            }
        }
    }

    public C43686i() {
        AppMethodBeat.m2504i(25859);
        AppMethodBeat.m2505o(25859);
    }

    public final void akC() {
        AppMethodBeat.m2504i(25860);
        C436881 c436881 = new C436881();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c436881.run();
            AppMethodBeat.m2505o(25860);
            return;
        }
        this.handler.post(c436881);
        AppMethodBeat.m2505o(25860);
    }

    /* renamed from: l */
    public final void mo69332l(final String str, final int i, final int i2) {
        AppMethodBeat.m2504i(25861);
        C294225 c294225 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(25851);
                synchronized (C43686i.this.callbacks) {
                    try {
                        for (C32336d l : C43686i.this.callbacks) {
                            l.mo53061l(str, i, i2);
                        }
                    } finally {
                        AppMethodBeat.m2505o(25851);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c294225.run();
            AppMethodBeat.m2505o(25861);
            return;
        }
        this.handler.post(c294225);
        AppMethodBeat.m2505o(25861);
    }

    /* renamed from: mk */
    public final void mo69333mk(final int i) {
        AppMethodBeat.m2504i(25862);
        C352857 c352857 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(25853);
                synchronized (C43686i.this.callbacks) {
                    try {
                        for (C32336d mk : C43686i.this.callbacks) {
                            mk.mo53062mk(i);
                        }
                    } finally {
                        AppMethodBeat.m2505o(25853);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c352857.run();
            AppMethodBeat.m2505o(25862);
            return;
        }
        this.handler.post(c352857);
        AppMethodBeat.m2505o(25862);
    }

    /* renamed from: tO */
    public final void mo69334tO(final String str) {
        AppMethodBeat.m2504i(25863);
        C399568 c399568 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(25854);
                synchronized (C43686i.this.callbacks) {
                    try {
                        for (C32336d tO : C43686i.this.callbacks) {
                            tO.mo53063tO(str);
                        }
                    } finally {
                        AppMethodBeat.m2505o(25854);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c399568.run();
            AppMethodBeat.m2505o(25863);
            return;
        }
        this.handler.post(c399568);
        AppMethodBeat.m2505o(25863);
    }

    /* renamed from: g */
    public final void mo69331g(final int i, final int i2, final String str) {
        AppMethodBeat.m2504i(25864);
        C352869 c352869 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(25855);
                synchronized (C43686i.this.callbacks) {
                    try {
                        for (C32336d g : C43686i.this.callbacks) {
                            g.mo53060g(i, i2, str);
                        }
                    } finally {
                        AppMethodBeat.m2505o(25855);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c352869.run();
            AppMethodBeat.m2505o(25864);
            return;
        }
        this.handler.post(c352869);
        AppMethodBeat.m2505o(25864);
    }

    public final void akE() {
        AppMethodBeat.m2504i(25865);
        C3995512 c3995512 = new C3995512();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c3995512.run();
            AppMethodBeat.m2505o(25865);
            return;
        }
        this.handler.post(c3995512);
        AppMethodBeat.m2505o(25865);
    }

    public final void akH() {
        AppMethodBeat.m2504i(25866);
        C223944 c223944 = new C223944();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c223944.run();
            AppMethodBeat.m2505o(25866);
            return;
        }
        this.handler.post(c223944);
        AppMethodBeat.m2505o(25866);
    }
}
