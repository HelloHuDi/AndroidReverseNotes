package com.tencent.mm.ab;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.math.BigInteger;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000z\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\b¢\u0006\u0002\u0010\u0004\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\b¢\u0006\u0002\u0010\u0007\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\"\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0003\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f\u001a\"\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0006\u001a\"\u0010\u0013\u001a\u00020\t\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0006\u001a\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015\u001a\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015\u001a\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015\u001a\"\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0003\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f\u001a\u001c\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u001a\u0014\u0010\u001d\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u001a\u001c\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u001a\u000e\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u001f\u001a\u0011\u0010\"\u001a\u0004\u0018\u00010#*\u0004\u0018\u00010$H\b\u001a(\u0010%\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020&*\u0002H\r2\b\u0010'\u001a\u0004\u0018\u00010#H\b¢\u0006\u0002\u0010(\u001aH\u0010%\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020&*\u0002H\r2\b\u0010'\u001a\u0004\u0018\u00010#2!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\t0)¢\u0006\u0002\u0010.\u001a-\u0010/\u001a\u00020\t\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\t0)H\b\u001aB\u00102\u001a\u00020\t\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r002'\u00101\u001a#\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\t03H\b¨\u00065"}, dWq = {"codeConsume", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "tag", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "commonShadow", "", "textView", "Landroid/widget/TextView;", "consumeList", "T", "list", "", "freeMMHandlerThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "threadName", "freeThread", "opAddFlag", "", "value", "flag", "opCheckFlag", "", "opCleanFlag", "reverseConsumeList", "threadPool", "uiThread", "delay", "", "ulonglong", "seq", "safeBufferToByte", "", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "safeParser", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "byteArray", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[B)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/ParameterName;", "name", "e", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[BLkotlin/jvm/functions/Function1;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "synchronizedForEach", "", "action", "synchronizedForEachIndexed", "Lkotlin/Function2;", "index", "libktcomm_release"})
public final class b {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, dWq = {"<no name provided>", "T", "invoke", "()Ljava/lang/Object;"})
    public static final class a extends k implements a.f.a.a<T> {
        final /* synthetic */ a.f.b.u.b eOo;
        final /* synthetic */ List eOp;

        public a(a.f.b.u.b bVar, List list) {
            this.eOo = bVar;
            this.eOp = list;
            super(0);
        }

        public final T invoke() {
            AppMethodBeat.i(114169);
            if (this.eOo.AVD < 0 || this.eOo.AVD >= this.eOp.size()) {
                AppMethodBeat.o(114169);
                return null;
            }
            List list = this.eOp;
            a.f.b.u.b bVar = this.eOo;
            int i = bVar.AVD;
            bVar.AVD = i + 1;
            T t = list.get(i);
            AppMethodBeat.o(114169);
            return t;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "R", "run"})
    static final class c implements Runnable {
        final /* synthetic */ a.f.a.a eOq;
        final /* synthetic */ al eOr;

        c(a.f.a.a aVar, al alVar) {
            this.eOq = aVar;
            this.eOr = alVar;
        }

        public final void run() {
            AppMethodBeat.i(114171);
            this.eOq.invoke();
            this.eOr.quit();
            AppMethodBeat.o(114171);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "R", "run"})
    static final class b implements Runnable {
        final /* synthetic */ a.f.a.a eOq;

        b(a.f.a.a aVar) {
            this.eOq = aVar;
        }

        public final void run() {
            AppMethodBeat.i(114170);
            this.eOq.invoke();
            AppMethodBeat.o(114170);
        }
    }

    public static final void a(a.f.a.a<y> aVar) {
        AppMethodBeat.i(114173);
        j.p(aVar, "block");
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        j.o(mainLooper, "Looper.getMainLooper()");
        if (j.j(currentThread, mainLooper.getThread())) {
            aVar.invoke();
            AppMethodBeat.o(114173);
            return;
        }
        al.d(new c(aVar));
        AppMethodBeat.o(114173);
    }

    public static final void a(long j, a.f.a.a<y> aVar) {
        AppMethodBeat.i(114174);
        j.p(aVar, "block");
        al.n(new c(aVar), j);
        AppMethodBeat.o(114174);
    }

    public static final void a(String str, a.f.a.a<y> aVar) {
        AppMethodBeat.i(114175);
        j.p(str, "threadName");
        j.p(aVar, "block");
        d.post(new c(aVar), str);
        AppMethodBeat.o(114175);
    }

    public static final <R> void a(a.f.a.a<? extends R> aVar, String str) {
        AppMethodBeat.i(114176);
        j.p(aVar, "block");
        j.p(str, "threadName");
        al alVar = new al(str);
        alVar.aa(new c(aVar, alVar));
        AppMethodBeat.o(114176);
    }

    public static final <R> al b(a.f.a.a<? extends R> aVar, String str) {
        AppMethodBeat.i(114177);
        j.p(aVar, "block");
        j.p(str, "threadName");
        al alVar = new al(str);
        alVar.aa(new b(aVar));
        AppMethodBeat.o(114177);
        return alVar;
    }

    public static final boolean cf(int i, int i2) {
        return (i & i2) > 0;
    }

    public static final <T extends com.tencent.mm.bt.a> T a(T t, byte[] bArr, a.f.a.b<? super Exception, y> bVar) {
        AppMethodBeat.i(114178);
        j.p(t, "receiver$0");
        j.p(bVar, "block");
        try {
            t.parseFrom(bArr);
            AppMethodBeat.o(114178);
            return t;
        } catch (Exception e) {
            ab.b("safeParser", "", e);
            bVar.am(e);
            AppMethodBeat.o(114178);
            return null;
        }
    }

    public static final String fe(long j) {
        AppMethodBeat.i(114179);
        String bigInteger = new BigInteger(Long.toBinaryString(j), 2).toString();
        j.o(bigInteger, "big.toString()");
        AppMethodBeat.o(114179);
        return bigInteger;
    }

    public static final void f(TextView textView) {
        AppMethodBeat.i(114180);
        j.p(textView, "textView");
        textView.setShadowLayer((float) com.tencent.mm.bz.a.fromDPToPix(textView.getContext(), 3), 0.0f, (float) com.tencent.mm.bz.a.fromDPToPix(textView.getContext(), 1), android.support.v4.widget.j.INVALID_ID);
        AppMethodBeat.o(114180);
    }
}
