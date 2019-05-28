package com.tencent.p177mm.sdk.p602d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

/* renamed from: com.tencent.mm.sdk.d.d */
public class C4887d {
    public String mName;
    public volatile C4890c xCt;
    volatile HandlerThread xCu;

    /* renamed from: com.tencent.mm.sdk.d.d$a */
    public static class C4888a {
        private C4886a xCA;
        private C4886a xCB;
        private C4887d xCv;
        private long xCw;
        private int xCx;
        private String xCy;
        private C4886a xCz;

        C4888a(C4887d c4887d, Message message, String str, C4886a c4886a, C4886a c4886a2, C4886a c4886a3) {
            AppMethodBeat.m2504i(52448);
            mo10084a(c4887d, message, str, c4886a, c4886a2, c4886a3);
            AppMethodBeat.m2505o(52448);
        }

        /* renamed from: a */
        public final void mo10084a(C4887d c4887d, Message message, String str, C4886a c4886a, C4886a c4886a2, C4886a c4886a3) {
            AppMethodBeat.m2504i(52449);
            this.xCv = c4887d;
            this.xCw = System.currentTimeMillis();
            this.xCx = message != null ? message.what : 0;
            this.xCy = str;
            this.xCz = c4886a;
            this.xCA = c4886a2;
            this.xCB = c4886a3;
            AppMethodBeat.m2505o(52449);
        }

        public final String toString() {
            AppMethodBeat.m2504i(52450);
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
            AppMethodBeat.m2505o(52450);
            return stringBuilder2;
        }
    }

    /* renamed from: com.tencent.mm.sdk.d.d$b */
    static class C4889b {
        private int mCount;
        private Vector<C4888a> xCC;
        private int xCD;
        private int xCE;
        private boolean xCF;

        /* synthetic */ C4889b(byte b) {
            this();
        }

        private C4889b() {
            AppMethodBeat.m2504i(52451);
            this.xCC = new Vector();
            this.xCD = 20;
            this.xCE = 0;
            this.mCount = 0;
            this.xCF = false;
            AppMethodBeat.m2505o(52451);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized boolean dpR() {
            return this.xCF;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void cleanup() {
            AppMethodBeat.m2504i(52452);
            this.xCC.clear();
            AppMethodBeat.m2505o(52452);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* renamed from: b */
        public final synchronized void mo10086b(C4887d c4887d, Message message, String str, C4886a c4886a, C4886a c4886a2, C4886a c4886a3) {
            AppMethodBeat.m2504i(52453);
            this.mCount++;
            if (this.xCC.size() < this.xCD) {
                this.xCC.add(new C4888a(c4887d, message, str, c4886a, c4886a2, c4886a3));
                AppMethodBeat.m2505o(52453);
            } else {
                C4888a c4888a = (C4888a) this.xCC.get(this.xCE);
                this.xCE++;
                if (this.xCE >= this.xCD) {
                    this.xCE = 0;
                }
                c4888a.mo10084a(c4887d, message, str, c4886a, c4886a2, c4886a3);
                AppMethodBeat.m2505o(52453);
            }
        }
    }

    /* renamed from: com.tencent.mm.sdk.d.d$c */
    public static class C4890c extends Handler {
        private static final Object xCH = new Object();
        private boolean iAB;
        private boolean xCG;
        private Message xCI;
        private C4889b xCJ;
        private boolean xCK;
        private C4892c[] xCL;
        private int xCM;
        private C4892c[] xCN;
        private int xCO;
        private C4893a xCP;
        private C4891b xCQ;
        private HashMap<C7292c, C4892c> xCR;
        private C7292c xCS;
        private C7292c xCT;
        private ArrayList<Message> xCU;
        private C4887d xCv;

        /* renamed from: com.tencent.mm.sdk.d.d$c$b */
        class C4891b extends C7292c {
            private C4891b() {
            }

            /* synthetic */ C4891b(C4890c c4890c, byte b) {
                this();
            }

            /* renamed from: k */
            public final boolean mo10090k(Message message) {
                return false;
            }
        }

        /* renamed from: com.tencent.mm.sdk.d.d$c$c */
        class C4892c {
            boolean active;
            C7292c xCW;
            C4892c xCX;

            private C4892c() {
            }

            /* synthetic */ C4892c(C4890c c4890c, byte b) {
                this();
            }

            public final String toString() {
                String str;
                AppMethodBeat.m2504i(52455);
                StringBuilder append = new StringBuilder("state=").append(this.xCW.getName()).append(",active=").append(this.active).append(",parent=");
                if (this.xCX == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = this.xCX.xCW.getName();
                }
                str = append.append(str).toString();
                AppMethodBeat.m2505o(52455);
                return str;
            }
        }

        /* renamed from: com.tencent.mm.sdk.d.d$c$a */
        class C4893a extends C7292c {
            private C4893a() {
            }

            /* synthetic */ C4893a(C4890c c4890c, byte b) {
                this();
            }

            /* renamed from: k */
            public final boolean mo10090k(Message message) {
                AppMethodBeat.m2504i(52454);
                C4890c.this.xCv;
                AppMethodBeat.m2505o(52454);
                return true;
            }
        }

        /* synthetic */ C4890c(Looper looper, C4887d c4887d, byte b) {
            this(looper, c4887d);
        }

        static {
            AppMethodBeat.m2504i(52472);
            AppMethodBeat.m2505o(52472);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(52456);
            if (!this.iAB) {
                if (this.xCG) {
                    new StringBuilder("handleMessage: E msg.what=").append(message.what);
                }
                this.xCI = message;
                C7292c c7292c = null;
                if (this.xCK) {
                    c7292c = m7283t(message);
                } else if (!this.xCK && this.xCI.what == -2 && this.xCI.obj == xCH) {
                    this.xCK = true;
                    m7268Md(0);
                } else {
                    RuntimeException runtimeException = new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: ".concat(String.valueOf(message)));
                    AppMethodBeat.m2505o(52456);
                    throw runtimeException;
                }
                m7271a(c7292c, message);
            }
            AppMethodBeat.m2505o(52456);
        }

        /* renamed from: a */
        private void m7271a(C7292c c7292c, Message message) {
            C4891b c4891b;
            AppMethodBeat.m2504i(52457);
            C7292c c7292c2 = this.xCL[this.xCM].xCW;
            boolean z = this.xCv.mo10079i(this.xCI) && message.obj != xCH;
            if (this.xCJ.dpR()) {
                if (this.xCT != null) {
                    this.xCJ.mo10086b(this.xCv, this.xCI, "", c7292c, c7292c2, this.xCT);
                }
            } else if (z) {
                this.xCJ.mo10086b(this.xCv, this.xCI, "", c7292c, c7292c2, this.xCT);
            }
            C7292c c7292c3 = this.xCT;
            if (c7292c3 != null) {
                while (true) {
                    c4891b = c7292c3;
                    this.xCO = 0;
                    C4892c c4892c = (C4892c) this.xCR.get(c4891b);
                    do {
                        C4892c[] c4892cArr = this.xCN;
                        int i = this.xCO;
                        this.xCO = i + 1;
                        c4892cArr[i] = c4892c;
                        c4892c = c4892c.xCX;
                        if (c4892c == null) {
                            break;
                        }
                    } while (!c4892c.active);
                    if (this.xCG) {
                        new StringBuilder("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=").append(this.xCO).append(",curStateInfo: ").append(c4892c);
                    }
                    m7272a(c4892c);
                    m7268Md(dpT());
                    dpS();
                    if (c4891b == this.xCT) {
                        break;
                    }
                    c7292c3 = this.xCT;
                }
                this.xCT = null;
            } else {
                C7292c c4891b2 = c7292c3;
            }
            if (c4891b2 != null && c4891b2 == this.xCQ) {
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
            AppMethodBeat.m2505o(52457);
        }

        /* renamed from: t */
        private final C7292c m7283t(Message message) {
            Object obj;
            AppMethodBeat.m2504i(52458);
            C4892c c4892c = this.xCL[this.xCM];
            if (this.xCG) {
                new StringBuilder("processMsg: ").append(c4892c.xCW.getName());
            }
            if (message.what == -1 && message.obj == xCH) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                m7275b(this.xCQ);
            } else {
                while (!c4892c.xCW.mo10090k(message)) {
                    c4892c = c4892c.xCX;
                    if (c4892c == null) {
                        this.xCv.mo10080j(message);
                        break;
                    } else if (this.xCG) {
                        new StringBuilder("processMsg: ").append(c4892c.xCW.getName());
                    }
                }
            }
            if (c4892c != null) {
                C7292c c7292c = c4892c.xCW;
                AppMethodBeat.m2505o(52458);
                return c7292c;
            }
            AppMethodBeat.m2505o(52458);
            return null;
        }

        /* renamed from: a */
        private final void m7272a(C4892c c4892c) {
            AppMethodBeat.m2504i(52459);
            while (this.xCM >= 0 && this.xCL[this.xCM] != c4892c) {
                C7292c c7292c = this.xCL[this.xCM].xCW;
                if (this.xCG) {
                    new StringBuilder("invokeExitMethods: ").append(c7292c.getName());
                }
                c7292c.exit();
                this.xCL[this.xCM].active = false;
                this.xCM--;
            }
            AppMethodBeat.m2505o(52459);
        }

        /* renamed from: Md */
        private final void m7268Md(int i) {
            AppMethodBeat.m2504i(52460);
            while (i <= this.xCM) {
                if (this.xCG) {
                    new StringBuilder("invokeEnterMethods: ").append(this.xCL[i].xCW.getName());
                }
                this.xCL[i].xCW.enter();
                this.xCL[i].active = true;
                i++;
            }
            AppMethodBeat.m2505o(52460);
        }

        private final void dpS() {
            AppMethodBeat.m2504i(52461);
            for (int size = this.xCU.size() - 1; size >= 0; size--) {
                Message message = (Message) this.xCU.get(size);
                if (this.xCG) {
                    new StringBuilder("moveDeferredMessageAtFrontOfQueue; what=").append(message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.xCU.clear();
            AppMethodBeat.m2505o(52461);
        }

        private final int dpT() {
            AppMethodBeat.m2504i(52462);
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
            AppMethodBeat.m2505o(52462);
            return i;
        }

        /* renamed from: c */
        private final C4892c m7278c(C7292c c7292c) {
            AppMethodBeat.m2504i(52463);
            if (this.xCG) {
                new StringBuilder("addStateInternal: E state=").append(c7292c.getName()).append(",parent=");
            }
            C4892c c4892c = (C4892c) this.xCR.get(c7292c);
            if (c4892c == null) {
                c4892c = new C4892c(this, (byte) 0);
                this.xCR.put(c7292c, c4892c);
            }
            if (c4892c.xCX == null || c4892c.xCX == null) {
                c4892c.xCW = c7292c;
                c4892c.xCX = null;
                c4892c.active = false;
                if (this.xCG) {
                    new StringBuilder("addStateInternal: X stateInfo: ").append(c4892c);
                }
                AppMethodBeat.m2505o(52463);
                return c4892c;
            }
            RuntimeException runtimeException = new RuntimeException("state already added");
            AppMethodBeat.m2505o(52463);
            throw runtimeException;
        }

        private C4890c(Looper looper, C4887d c4887d) {
            super(looper);
            AppMethodBeat.m2504i(52464);
            this.iAB = false;
            this.xCG = false;
            this.xCJ = new C4889b();
            this.xCM = -1;
            this.xCP = new C4893a(this, (byte) 0);
            this.xCQ = new C4891b(this, (byte) 0);
            this.xCR = new HashMap();
            this.xCU = new ArrayList();
            this.xCv = c4887d;
            m7278c(this.xCP);
            m7278c(this.xCQ);
            AppMethodBeat.m2505o(52464);
        }

        /* renamed from: b */
        private final void m7275b(C4886a c4886a) {
            AppMethodBeat.m2504i(52465);
            this.xCT = (C7292c) c4886a;
            if (this.xCG) {
                new StringBuilder("transitionTo: destState=").append(this.xCT.getName());
            }
            AppMethodBeat.m2505o(52465);
        }

        /* renamed from: b */
        static /* synthetic */ void m7276b(C4890c c4890c, C7292c c7292c) {
            AppMethodBeat.m2504i(52467);
            if (c4890c.xCG) {
                new StringBuilder("setInitialState: initialState=").append(c7292c.getName());
            }
            c4890c.xCS = c7292c;
            AppMethodBeat.m2505o(52467);
        }

        /* renamed from: e */
        static /* synthetic */ void m7280e(C4890c c4890c) {
            AppMethodBeat.m2504i(52469);
            c4890c.sendMessage(c4890c.obtainMessage(-1, xCH));
            AppMethodBeat.m2505o(52469);
        }

        /* renamed from: f */
        public static /* synthetic */ void m7281f(C4890c c4890c) {
            AppMethodBeat.m2504i(52470);
            c4890c.sendMessageAtFrontOfQueue(c4890c.obtainMessage(-1, xCH));
            AppMethodBeat.m2505o(52470);
        }

        /* renamed from: g */
        static /* synthetic */ void m7282g(C4890c c4890c) {
            C4892c c4892c;
            AppMethodBeat.m2504i(52471);
            int i = 0;
            for (C4892c c4892c2 : c4890c.xCR.values()) {
                int i2;
                int i3 = 0;
                while (c4892c2 != null) {
                    c4892c2 = c4892c2.xCX;
                    i3++;
                }
                if (i < i3) {
                    i2 = i3;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            c4890c.xCL = new C4892c[i];
            c4890c.xCN = new C4892c[i];
            if (c4890c.xCG) {
                new StringBuilder("setupInitialStateStack: E mInitialState=").append(c4890c.xCS.getName());
            }
            c4892c2 = (C4892c) c4890c.xCR.get(c4890c.xCS);
            c4890c.xCO = 0;
            while (c4892c2 != null) {
                c4890c.xCN[c4890c.xCO] = c4892c2;
                c4892c2 = c4892c2.xCX;
                c4890c.xCO++;
            }
            c4890c.xCM = -1;
            c4890c.dpT();
            c4890c.sendMessageAtFrontOfQueue(c4890c.obtainMessage(-2, xCH));
            AppMethodBeat.m2505o(52471);
        }
    }

    protected C4887d(String str, Looper looper) {
        AppMethodBeat.m2504i(52473);
        this.mName = str;
        this.xCt = new C4890c(looper, this, (byte) 0);
        AppMethodBeat.m2505o(52473);
    }

    /* renamed from: a */
    public final void mo10073a(C7292c c7292c) {
        AppMethodBeat.m2504i(52474);
        C4890c.m7269a(this.xCt, c7292c);
        AppMethodBeat.m2505o(52474);
    }

    /* renamed from: b */
    public final void mo10076b(C7292c c7292c) {
        AppMethodBeat.m2504i(52475);
        C4890c.m7276b(this.xCt, c7292c);
        AppMethodBeat.m2505o(52475);
    }

    /* Access modifiers changed, original: protected|final */
    public final Message dpP() {
        AppMethodBeat.m2504i(52476);
        C4890c c4890c = this.xCt;
        if (c4890c == null) {
            AppMethodBeat.m2505o(52476);
            return null;
        }
        Message b = c4890c.xCI;
        AppMethodBeat.m2505o(52476);
        return b;
    }

    public final C4886a dpQ() {
        AppMethodBeat.m2504i(52477);
        C4890c c4890c = this.xCt;
        if (c4890c == null) {
            AppMethodBeat.m2505o(52477);
            return null;
        }
        C4886a c = c4890c.xCL[c4890c.xCM].xCW;
        AppMethodBeat.m2505o(52477);
        return c;
    }

    /* renamed from: b */
    public final void mo10075b(C4886a c4886a) {
        AppMethodBeat.m2504i(52478);
        C4890c.m7273a(this.xCt, c4886a);
        AppMethodBeat.m2505o(52478);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: j */
    public void mo10080j(Message message) {
        AppMethodBeat.m2504i(52479);
        if (this.xCt.xCG) {
            new StringBuilder(" - unhandledMessage: msg.what=").append(message.what);
        }
        AppMethodBeat.m2505o(52479);
    }

    /* Access modifiers changed, original: protected */
    public void avC() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: i */
    public boolean mo10079i(Message message) {
        return true;
    }

    private Message obtainMessage(int i) {
        AppMethodBeat.m2504i(52480);
        Message obtain = Message.obtain(this.xCt, i);
        AppMethodBeat.m2505o(52480);
        return obtain;
    }

    public final void sendMessage(int i) {
        AppMethodBeat.m2504i(52481);
        C4890c c4890c = this.xCt;
        if (c4890c == null) {
            AppMethodBeat.m2505o(52481);
            return;
        }
        c4890c.sendMessage(obtainMessage(i));
        AppMethodBeat.m2505o(52481);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Mc */
    public final void mo10072Mc(int i) {
        AppMethodBeat.m2504i(52482);
        C4890c c4890c = this.xCt;
        if (c4890c == null) {
            AppMethodBeat.m2505o(52482);
            return;
        }
        c4890c.sendMessageAtFrontOfQueue(obtainMessage(i));
        AppMethodBeat.m2505o(52482);
    }

    public final void quit() {
        AppMethodBeat.m2504i(52483);
        C4890c c4890c = this.xCt;
        if (c4890c == null) {
            AppMethodBeat.m2505o(52483);
            return;
        }
        C4890c.m7280e(c4890c);
        AppMethodBeat.m2505o(52483);
    }

    public void start() {
        AppMethodBeat.m2504i(52484);
        C4890c c4890c = this.xCt;
        if (c4890c == null) {
            AppMethodBeat.m2505o(52484);
            return;
        }
        C4890c.m7282g(c4890c);
        AppMethodBeat.m2505o(52484);
    }
}
