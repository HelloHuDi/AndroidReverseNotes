package com.tencent.p177mm.p823ab;

import android.os.Looper;
import android.support.p057v4.widget.C8415j;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.math.BigInteger;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C41381u.C41380b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000z\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\b¢\u0006\u0002\u0010\u0004\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\b¢\u0006\u0002\u0010\u0007\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\"\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0003\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f\u001a\"\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0006\u001a\"\u0010\u0013\u001a\u00020\t\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0006\u001a\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015\u001a\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015\u001a\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015\u001a\"\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0003\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f\u001a\u001c\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u001a\u0014\u0010\u001d\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u001a\u001c\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u001a\u000e\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u001f\u001a\u0011\u0010\"\u001a\u0004\u0018\u00010#*\u0004\u0018\u00010$H\b\u001a(\u0010%\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020&*\u0002H\r2\b\u0010'\u001a\u0004\u0018\u00010#H\b¢\u0006\u0002\u0010(\u001aH\u0010%\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020&*\u0002H\r2\b\u0010'\u001a\u0004\u0018\u00010#2!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\t0)¢\u0006\u0002\u0010.\u001a-\u0010/\u001a\u00020\t\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\t0)H\b\u001aB\u00102\u001a\u00020\t\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r002'\u00101\u001a#\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\t03H\b¨\u00065"}, dWq = {"codeConsume", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "tag", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "commonShadow", "", "textView", "Landroid/widget/TextView;", "consumeList", "T", "list", "", "freeMMHandlerThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "threadName", "freeThread", "opAddFlag", "", "value", "flag", "opCheckFlag", "", "opCleanFlag", "reverseConsumeList", "threadPool", "uiThread", "delay", "", "ulonglong", "seq", "safeBufferToByte", "", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "safeParser", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "byteArray", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[B)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/ParameterName;", "name", "e", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[BLkotlin/jvm/functions/Function1;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "synchronizedForEach", "", "action", "synchronizedForEachIndexed", "Lkotlin/Function2;", "index", "libktcomm_release"})
/* renamed from: com.tencent.mm.ab.b */
public final class C8902b {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, dWq = {"<no name provided>", "T", "invoke", "()Ljava/lang/Object;"})
    /* renamed from: com.tencent.mm.ab.b$a */
    public static final class C8903a extends C25053k implements C31214a<T> {
        final /* synthetic */ C41380b eOo;
        final /* synthetic */ List eOp;

        public C8903a(C41380b c41380b, List list) {
            this.eOo = c41380b;
            this.eOp = list;
            super(0);
        }

        public final T invoke() {
            AppMethodBeat.m2504i(114169);
            if (this.eOo.AVD < 0 || this.eOo.AVD >= this.eOp.size()) {
                AppMethodBeat.m2505o(114169);
                return null;
            }
            List list = this.eOp;
            C41380b c41380b = this.eOo;
            int i = c41380b.AVD;
            c41380b.AVD = i + 1;
            T t = list.get(i);
            AppMethodBeat.m2505o(114169);
            return t;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "R", "run"})
    /* renamed from: com.tencent.mm.ab.b$c */
    static final class C8904c implements Runnable {
        final /* synthetic */ C31214a eOq;
        final /* synthetic */ C5004al eOr;

        C8904c(C31214a c31214a, C5004al c5004al) {
            this.eOq = c31214a;
            this.eOr = c5004al;
        }

        public final void run() {
            AppMethodBeat.m2504i(114171);
            this.eOq.invoke();
            this.eOr.quit();
            AppMethodBeat.m2505o(114171);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "R", "run"})
    /* renamed from: com.tencent.mm.ab.b$b */
    static final class C8905b implements Runnable {
        final /* synthetic */ C31214a eOq;

        C8905b(C31214a c31214a) {
            this.eOq = c31214a;
        }

        public final void run() {
            AppMethodBeat.m2504i(114170);
            this.eOq.invoke();
            AppMethodBeat.m2505o(114170);
        }
    }

    /* renamed from: a */
    public static final void m16042a(C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(114173);
        C25052j.m39376p(c31214a, "block");
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        C25052j.m39375o(mainLooper, "Looper.getMainLooper()");
        if (C25052j.m39373j(currentThread, mainLooper.getThread())) {
            c31214a.invoke();
            AppMethodBeat.m2505o(114173);
            return;
        }
        C5004al.m7441d(new C25743c(c31214a));
        AppMethodBeat.m2505o(114173);
    }

    /* renamed from: a */
    public static final void m16041a(long j, C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(114174);
        C25052j.m39376p(c31214a, "block");
        C5004al.m7442n(new C25743c(c31214a), j);
        AppMethodBeat.m2505o(114174);
    }

    /* renamed from: a */
    public static final void m16044a(String str, C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(114175);
        C25052j.m39376p(str, "threadName");
        C25052j.m39376p(c31214a, "block");
        C7305d.post(new C25743c(c31214a), str);
        AppMethodBeat.m2505o(114175);
    }

    /* renamed from: a */
    public static final <R> void m16043a(C31214a<? extends R> c31214a, String str) {
        AppMethodBeat.m2504i(114176);
        C25052j.m39376p(c31214a, "block");
        C25052j.m39376p(str, "threadName");
        C5004al c5004al = new C5004al(str);
        c5004al.mo10302aa(new C8904c(c31214a, c5004al));
        AppMethodBeat.m2505o(114176);
    }

    /* renamed from: b */
    public static final <R> C5004al m16045b(C31214a<? extends R> c31214a, String str) {
        AppMethodBeat.m2504i(114177);
        C25052j.m39376p(c31214a, "block");
        C25052j.m39376p(str, "threadName");
        C5004al c5004al = new C5004al(str);
        c5004al.mo10302aa(new C8905b(c31214a));
        AppMethodBeat.m2505o(114177);
        return c5004al;
    }

    /* renamed from: cf */
    public static final boolean m16046cf(int i, int i2) {
        return (i & i2) > 0;
    }

    /* renamed from: a */
    public static final <T extends C1331a> T m16040a(T t, byte[] bArr, C17126b<? super Exception, C37091y> c17126b) {
        AppMethodBeat.m2504i(114178);
        C25052j.m39376p(t, "receiver$0");
        C25052j.m39376p(c17126b, "block");
        try {
            t.parseFrom(bArr);
            AppMethodBeat.m2505o(114178);
            return t;
        } catch (Exception e) {
            C4990ab.m7408b("safeParser", "", e);
            c17126b.mo50am(e);
            AppMethodBeat.m2505o(114178);
            return null;
        }
    }

    /* renamed from: fe */
    public static final String m16048fe(long j) {
        AppMethodBeat.m2504i(114179);
        String bigInteger = new BigInteger(Long.toBinaryString(j), 2).toString();
        C25052j.m39375o(bigInteger, "big.toString()");
        AppMethodBeat.m2505o(114179);
        return bigInteger;
    }

    /* renamed from: f */
    public static final void m16047f(TextView textView) {
        AppMethodBeat.m2504i(114180);
        C25052j.m39376p(textView, "textView");
        textView.setShadowLayer((float) C1338a.fromDPToPix(textView.getContext(), 3), 0.0f, (float) C1338a.fromDPToPix(textView.getContext(), 1), C8415j.INVALID_ID);
        AppMethodBeat.m2505o(114180);
    }
}
