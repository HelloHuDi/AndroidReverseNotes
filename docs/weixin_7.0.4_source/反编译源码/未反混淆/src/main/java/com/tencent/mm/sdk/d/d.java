package com.tencent.mm.sdk.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

public class d {
    public String mName;
    public volatile c xCt;
    volatile HandlerThread xCu;

    public static class a {
        private a xCA;
        private a xCB;
        private d xCv;
        private long xCw;
        private int xCx;
        private String xCy;
        private a xCz;

        a(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
            AppMethodBeat.i(52448);
            a(dVar, message, str, aVar, aVar2, aVar3);
            AppMethodBeat.o(52448);
        }

        public final void a(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
            AppMethodBeat.i(52449);
            this.xCv = dVar;
            this.xCw = System.currentTimeMillis();
            this.xCx = message != null ? message.what : 0;
            this.xCy = str;
            this.xCz = aVar;
            this.xCA = aVar2;
            this.xCB = aVar3;
            AppMethodBeat.o(52449);
        }

        public final String toString() {
            AppMethodBeat.i(52450);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("time=");
            Calendar.getInstance().setTimeInMillis(this.xCw);
            stringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[]{r0, r0, r0, r0, r0, r0}));
            stringBuilder.append(" processed=");
            stringBuilder.append(this.xCz == null ? "<null>" : this.xCz.getName());
            stringBuilder.append(" org=");
            stringBuilder.append(this.xCA == null ? "<null>" : this.xCA.getName());
            stringBuilder.append(" dest=");
            stringBuilder.append(this.xCB == null ? "<null>" : this.xCB.getName());
            stringBuilder.append(" what=");
            CharSequence charSequence = this.xCv != null ? null : "";
            if (TextUtils.isEmpty(charSequence)) {
                stringBuilder.append(this.xCx);
                stringBuilder.append("(0x");
                stringBuilder.append(Integer.toHexString(this.xCx));
                stringBuilder.append(")");
            } else {
                stringBuilder.append(charSequence);
            }
            if (!TextUtils.isEmpty(this.xCy)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.xCy);
            }
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(52450);
            return stringBuilder2;
        }
    }

    static class b {
        private int mCount;
        private Vector<a> xCC;
        private int xCD;
        private int xCE;
        private boolean xCF;

        /* synthetic */ b(byte b) {
            this();
        }

        private b() {
            AppMethodBeat.i(52451);
            this.xCC = new Vector();
            this.xCD = 20;
            this.xCE = 0;
            this.mCount = 0;
            this.xCF = false;
            AppMethodBeat.o(52451);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized boolean dpR() {
            return this.xCF;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void cleanup() {
            AppMethodBeat.i(52452);
            this.xCC.clear();
            AppMethodBeat.o(52452);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void b(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
            AppMethodBeat.i(52453);
            this.mCount++;
            if (this.xCC.size() < this.xCD) {
                this.xCC.add(new a(dVar, message, str, aVar, aVar2, aVar3));
                AppMethodBeat.o(52453);
            } else {
                a aVar4 = (a) this.xCC.get(this.xCE);
                this.xCE++;
                if (this.xCE >= this.xCD) {
                    this.xCE = 0;
                }
                aVar4.a(dVar, message, str, aVar, aVar2, aVar3);
                AppMethodBeat.o(52453);
            }
        }
    }

    public static class c extends Handler {
        private static final Object xCH = new Object();
        private boolean iAB;
        private boolean xCG;
        private Message xCI;
        private b xCJ;
        private boolean xCK;
        private c[] xCL;
        private int xCM;
        private c[] xCN;
        private int xCO;
        private a xCP;
        private b xCQ;
        private HashMap<c, c> xCR;
        private c xCS;
        private c xCT;
        private ArrayList<Message> xCU;
        private d xCv;

        class b extends c {
            private b() {
            }

            /* synthetic */ b(c cVar, byte b) {
                this();
            }

            public final boolean k(Message message) {
                return false;
            }
        }

        class c {
            boolean active;
            c xCW;
            c xCX;

            private c() {
            }

            /* synthetic */ c(c cVar, byte b) {
                this();
            }

            public final String toString() {
                String str;
                AppMethodBeat.i(52455);
                StringBuilder append = new StringBuilder("state=").append(this.xCW.getName()).append(",active=").append(this.active).append(",parent=");
                if (this.xCX == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = this.xCX.xCW.getName();
                }
                str = append.append(str).toString();
                AppMethodBeat.o(52455);
                return str;
            }
        }

        class a extends c {
            private a() {
            }

            /* synthetic */ a(c cVar, byte b) {
                this();
            }

            public final boolean k(Message message) {
                AppMethodBeat.i(52454);
                c.this.xCv;
                AppMethodBeat.o(52454);
                return true;
            }
        }

        /* synthetic */ c(Looper looper, d dVar, byte b) {
            this(looper, dVar);
        }

        static {
            AppMethodBeat.i(52472);
            AppMethodBeat.o(52472);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(52456);
            if (!this.iAB) {
                if (this.xCG) {
                    new StringBuilder("handleMessage: E msg.what=").append(message.what);
                }
                this.xCI = message;
                c cVar = null;
                if (this.xCK) {
                    cVar = t(message);
                } else if (!this.xCK && this.xCI.what == -2 && this.xCI.obj == xCH) {
                    this.xCK = true;
                    Md(0);
                } else {
                    RuntimeException runtimeException = new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: ".concat(String.valueOf(message)));
                    AppMethodBeat.o(52456);
                    throw runtimeException;
                }
                a(cVar, message);
            }
            AppMethodBeat.o(52456);
        }

        private void a(c cVar, Message message) {
            b bVar;
            AppMethodBeat.i(52457);
            c cVar2 = this.xCL[this.xCM].xCW;
            boolean z = this.xCv.i(this.xCI) && message.obj != xCH;
            if (this.xCJ.dpR()) {
                if (this.xCT != null) {
                    this.xCJ.b(this.xCv, this.xCI, "", cVar, cVar2, this.xCT);
                }
            } else if (z) {
                this.xCJ.b(this.xCv, this.xCI, "", cVar, cVar2, this.xCT);
            }
            c cVar3 = this.xCT;
            if (cVar3 != null) {
                while (true) {
                    bVar = cVar3;
                    this.xCO = 0;
                    c cVar4 = (c) this.xCR.get(bVar);
                    do {
                        c[] cVarArr = this.xCN;
                        int i = this.xCO;
                        this.xCO = i + 1;
                        cVarArr[i] = cVar4;
                        cVar4 = cVar4.xCX;
                        if (cVar4 == null) {
                            break;
                        }
                    } while (!cVar4.active);
                    if (this.xCG) {
                        new StringBuilder("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=").append(this.xCO).append(",curStateInfo: ").append(cVar4);
                    }
                    a(cVar4);
                    Md(dpT());
                    dpS();
                    if (bVar == this.xCT) {
                        break;
                    }
                    cVar3 = this.xCT;
                }
                this.xCT = null;
            } else {
                c bVar2 = cVar3;
            }
            if (bVar2 != null && bVar2 == this.xCQ) {
                this.xCv.avC();
                if (this.xCv.xCu != null) {
                    getLooper().quit();
                    this.xCv.xCu = null;
                }
                this.xCv.xCt = null;
                this.xCv = null;
                this.xCI = null;
                this.xCJ.cleanup();
                this.xCL = null;
                this.xCN = null;
                this.xCR.clear();
                this.xCS = null;
                this.xCT = null;
                this.xCU.clear();
                this.iAB = true;
            }
            AppMethodBeat.o(52457);
        }

        private final c t(Message message) {
            Object obj;
            AppMethodBeat.i(52458);
            c cVar = this.xCL[this.xCM];
            if (this.xCG) {
                new StringBuilder("processMsg: ").append(cVar.xCW.getName());
            }
            if (message.what == -1 && message.obj == xCH) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                b(this.xCQ);
            } else {
                while (!cVar.xCW.k(message)) {
                    cVar = cVar.xCX;
                    if (cVar == null) {
                        this.xCv.j(message);
                        break;
                    } else if (this.xCG) {
                        new StringBuilder("processMsg: ").append(cVar.xCW.getName());
                    }
                }
            }
            if (cVar != null) {
                c cVar2 = cVar.xCW;
                AppMethodBeat.o(52458);
                return cVar2;
            }
            AppMethodBeat.o(52458);
            return null;
        }

        private final void a(c cVar) {
            AppMethodBeat.i(52459);
            while (this.xCM >= 0 && this.xCL[this.xCM] != cVar) {
                c cVar2 = this.xCL[this.xCM].xCW;
                if (this.xCG) {
                    new StringBuilder("invokeExitMethods: ").append(cVar2.getName());
                }
                cVar2.exit();
                this.xCL[this.xCM].active = false;
                this.xCM--;
            }
            AppMethodBeat.o(52459);
        }

        private final void Md(int i) {
            AppMethodBeat.i(52460);
            while (i <= this.xCM) {
                if (this.xCG) {
                    new StringBuilder("invokeEnterMethods: ").append(this.xCL[i].xCW.getName());
                }
                this.xCL[i].xCW.enter();
                this.xCL[i].active = true;
                i++;
            }
            AppMethodBeat.o(52460);
        }

        private final void dpS() {
            AppMethodBeat.i(52461);
            for (int size = this.xCU.size() - 1; size >= 0; size--) {
                Message message = (Message) this.xCU.get(size);
                if (this.xCG) {
                    new StringBuilder("moveDeferredMessageAtFrontOfQueue; what=").append(message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.xCU.clear();
            AppMethodBeat.o(52461);
        }

        private final int dpT() {
            AppMethodBeat.i(52462);
            int i = this.xCM + 1;
            int i2 = i;
            for (int i3 = this.xCO - 1; i3 >= 0; i3--) {
                if (this.xCG) {
                    new StringBuilder("moveTempStackToStateStack: i=").append(i3).append(",j=").append(i2);
                }
                this.xCL[i2] = this.xCN[i3];
                i2++;
            }
            this.xCM = i2 - 1;
            if (this.xCG) {
                new StringBuilder("moveTempStackToStateStack: X mStateStackTop=").append(this.xCM).append(",startingIndex=").append(i).append(",Top=").append(this.xCL[this.xCM].xCW.getName());
            }
            AppMethodBeat.o(52462);
            return i;
        }

        private final c c(c cVar) {
            AppMethodBeat.i(52463);
            if (this.xCG) {
                new StringBuilder("addStateInternal: E state=").append(cVar.getName()).append(",parent=");
            }
            c cVar2 = (c) this.xCR.get(cVar);
            if (cVar2 == null) {
                cVar2 = new c(this, (byte) 0);
                this.xCR.put(cVar, cVar2);
            }
            if (cVar2.xCX == null || cVar2.xCX == null) {
                cVar2.xCW = cVar;
                cVar2.xCX = null;
                cVar2.active = false;
                if (this.xCG) {
                    new StringBuilder("addStateInternal: X stateInfo: ").append(cVar2);
                }
                AppMethodBeat.o(52463);
                return cVar2;
            }
            RuntimeException runtimeException = new RuntimeException("state already added");
            AppMethodBeat.o(52463);
            throw runtimeException;
        }

        private c(Looper looper, d dVar) {
            super(looper);
            AppMethodBeat.i(52464);
            this.iAB = false;
            this.xCG = false;
            this.xCJ = new b();
            this.xCM = -1;
            this.xCP = new a(this, (byte) 0);
            this.xCQ = new b(this, (byte) 0);
            this.xCR = new HashMap();
            this.xCU = new ArrayList();
            this.xCv = dVar;
            c(this.xCP);
            c(this.xCQ);
            AppMethodBeat.o(52464);
        }

        private final void b(a aVar) {
            AppMethodBeat.i(52465);
            this.xCT = (c) aVar;
            if (this.xCG) {
                new StringBuilder("transitionTo: destState=").append(this.xCT.getName());
            }
            AppMethodBeat.o(52465);
        }

        static /* synthetic */ void b(c cVar, c cVar2) {
            AppMethodBeat.i(52467);
            if (cVar.xCG) {
                new StringBuilder("setInitialState: initialState=").append(cVar2.getName());
            }
            cVar.xCS = cVar2;
            AppMethodBeat.o(52467);
        }

        static /* synthetic */ void e(c cVar) {
            AppMethodBeat.i(52469);
            cVar.sendMessage(cVar.obtainMessage(-1, xCH));
            AppMethodBeat.o(52469);
        }

        public static /* synthetic */ void f(c cVar) {
            AppMethodBeat.i(52470);
            cVar.sendMessageAtFrontOfQueue(cVar.obtainMessage(-1, xCH));
            AppMethodBeat.o(52470);
        }

        static /* synthetic */ void g(c cVar) {
            c cVar2;
            AppMethodBeat.i(52471);
            int i = 0;
            for (c cVar22 : cVar.xCR.values()) {
                int i2;
                int i3 = 0;
                while (cVar22 != null) {
                    cVar22 = cVar22.xCX;
                    i3++;
                }
                if (i < i3) {
                    i2 = i3;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            cVar.xCL = new c[i];
            cVar.xCN = new c[i];
            if (cVar.xCG) {
                new StringBuilder("setupInitialStateStack: E mInitialState=").append(cVar.xCS.getName());
            }
            cVar22 = (c) cVar.xCR.get(cVar.xCS);
            cVar.xCO = 0;
            while (cVar22 != null) {
                cVar.xCN[cVar.xCO] = cVar22;
                cVar22 = cVar22.xCX;
                cVar.xCO++;
            }
            cVar.xCM = -1;
            cVar.dpT();
            cVar.sendMessageAtFrontOfQueue(cVar.obtainMessage(-2, xCH));
            AppMethodBeat.o(52471);
        }
    }

    protected d(String str, Looper looper) {
        AppMethodBeat.i(52473);
        this.mName = str;
        this.xCt = new c(looper, this, (byte) 0);
        AppMethodBeat.o(52473);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(52474);
        c.a(this.xCt, cVar);
        AppMethodBeat.o(52474);
    }

    public final void b(c cVar) {
        AppMethodBeat.i(52475);
        c.b(this.xCt, cVar);
        AppMethodBeat.o(52475);
    }

    /* Access modifiers changed, original: protected|final */
    public final Message dpP() {
        AppMethodBeat.i(52476);
        c cVar = this.xCt;
        if (cVar == null) {
            AppMethodBeat.o(52476);
            return null;
        }
        Message b = cVar.xCI;
        AppMethodBeat.o(52476);
        return b;
    }

    public final a dpQ() {
        AppMethodBeat.i(52477);
        c cVar = this.xCt;
        if (cVar == null) {
            AppMethodBeat.o(52477);
            return null;
        }
        a c = cVar.xCL[cVar.xCM].xCW;
        AppMethodBeat.o(52477);
        return c;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(52478);
        c.a(this.xCt, aVar);
        AppMethodBeat.o(52478);
    }

    /* Access modifiers changed, original: protected */
    public void j(Message message) {
        AppMethodBeat.i(52479);
        if (this.xCt.xCG) {
            new StringBuilder(" - unhandledMessage: msg.what=").append(message.what);
        }
        AppMethodBeat.o(52479);
    }

    /* Access modifiers changed, original: protected */
    public void avC() {
    }

    /* Access modifiers changed, original: protected */
    public boolean i(Message message) {
        return true;
    }

    private Message obtainMessage(int i) {
        AppMethodBeat.i(52480);
        Message obtain = Message.obtain(this.xCt, i);
        AppMethodBeat.o(52480);
        return obtain;
    }

    public final void sendMessage(int i) {
        AppMethodBeat.i(52481);
        c cVar = this.xCt;
        if (cVar == null) {
            AppMethodBeat.o(52481);
            return;
        }
        cVar.sendMessage(obtainMessage(i));
        AppMethodBeat.o(52481);
    }

    /* Access modifiers changed, original: protected|final */
    public final void Mc(int i) {
        AppMethodBeat.i(52482);
        c cVar = this.xCt;
        if (cVar == null) {
            AppMethodBeat.o(52482);
            return;
        }
        cVar.sendMessageAtFrontOfQueue(obtainMessage(i));
        AppMethodBeat.o(52482);
    }

    public final void quit() {
        AppMethodBeat.i(52483);
        c cVar = this.xCt;
        if (cVar == null) {
            AppMethodBeat.o(52483);
            return;
        }
        c.e(cVar);
        AppMethodBeat.o(52483);
    }

    public void start() {
        AppMethodBeat.i(52484);
        c cVar = this.xCt;
        if (cVar == null) {
            AppMethodBeat.o(52484);
            return;
        }
        c.g(cVar);
        AppMethodBeat.o(52484);
    }
}
