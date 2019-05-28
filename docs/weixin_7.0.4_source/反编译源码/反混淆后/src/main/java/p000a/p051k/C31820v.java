package p000a.p051k;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.C31826o;
import p000a.C8312u;
import p000a.p001a.C25033k;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C36913i;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p009h.C0016h;
import p000a.p009h.C31599d;
import p000a.p009h.C36938b;
import p000a.p009h.C36938b.C36939a;
import p000a.p050j.C17348n;
import p000a.p050j.C44937h;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\n\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\u001c\u001a:\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006\u001a4\u0010 \u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\b¢\u0006\u0002\u0010%\u001a4\u0010&\u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\b¢\u0006\u0002\u0010%\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b)\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010+\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010+\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u0010.\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u0010/\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u00100\u001a\u00020\r*\u00020\u0002H\b\u001a \u00101\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00102\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00103\u001a\u000204*\u00020\u0002H\u0002\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00106\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u00106\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00107\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u0002\u001a\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u0002\u001a\u0015\u0010;\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\f\u001a\u000f\u0010<\u001a\u00020\n*\u0004\u0018\u00010\nH\b\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010=\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001aG\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010F\u001a=\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u0006\u0010B\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\bE\u001a4\u0010G\u001a\u00020\r*\u00020\u00022\u0006\u0010H\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010J\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u0002\u001a\u0012\u0010J\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u0002\u001a\u001a\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006\u001a\u0012\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\b\u001a\u0015\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001H\b\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a+\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00020SH\b\u001a\u001d\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\b\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001d\u0010[\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\b\u001a\"\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002\u001a%\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002H\b\u001a\u001d\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002H\b\u001a=\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010^\u001a0\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a/\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010P\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\b_\u001a%\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010D\u001a\u00020\u0006H\b\u001a=\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010a\u001a0\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010c\u001a\u00020\u0002*\u00020\n2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u0006H\b\u001a\u001f\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u0006H\b\u001a\u0012\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u0012\u0010f\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\n\u0010k\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010k\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010k\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010k\u001a\u00020\n*\u00020\nH\b\u001a!\u0010k\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010k\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010m\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010m\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010m\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010m\u001a\u00020\n*\u00020\nH\b\u001a!\u0010m\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010m\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010n\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010n\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010n\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010n\u001a\u00020\n*\u00020\nH\b\u001a!\u0010n\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010n\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006o"}, dWq = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, dWr = 1)
/* renamed from: a.k.v */
public class C31820v extends C6163u {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"})
    /* renamed from: a.k.v$b */
    static final class C24630b extends C25053k implements C17126b<C31599d, String> {
        final /* synthetic */ CharSequence BPo;

        C24630b(CharSequence charSequence) {
            this.BPo = charSequence;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(56344);
            C31599d c31599d = (C31599d) obj;
            C25052j.m39376p(c31599d, "it");
            String a = C31820v.m51521a(this.BPo, c31599d);
            AppMethodBeat.m2505o(56344);
            return a;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"})
    /* renamed from: a.k.v$a */
    static final class C31821a extends C25053k implements C31591m<CharSequence, Integer, C31826o<? extends Integer, ? extends Integer>> {
        final /* synthetic */ List BPm;
        final /* synthetic */ boolean BPn;

        C31821a(List list, boolean z) {
            this.BPm = list;
            this.BPn = z;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            C31826o c31826o;
            AppMethodBeat.m2504i(56305);
            CharSequence charSequence = (CharSequence) obj;
            int intValue = ((Number) obj2).intValue();
            C25052j.m39376p(charSequence, "receiver$0");
            Collection collection = this.BPm;
            boolean z = this.BPn;
            if (z || collection.size() != 1) {
                C36938b c31599d = new C31599d(C0016h.m19im(intValue, 0), charSequence.length());
                int i;
                int i2;
                int i3;
                int i4;
                String str;
                Object obj3;
                if (!(charSequence instanceof String)) {
                    i = c31599d.AVJ;
                    i2 = c31599d.AVK;
                    i3 = c31599d.hzv;
                    if (i3 > 0) {
                        if (i <= i2) {
                            i4 = i;
                        }
                        c31826o = null;
                    } else {
                        if (i >= i2) {
                            i4 = i;
                        }
                        c31826o = null;
                    }
                    while (true) {
                        for (Object next : collection) {
                            str = (String) next;
                            if (C31820v.m51525a((CharSequence) str, charSequence, i4, str.length(), z)) {
                                obj3 = next;
                                break;
                            }
                        }
                        obj3 = null;
                        str = (String) obj3;
                        if (str == null) {
                            if (i4 == i2) {
                                break;
                            }
                            i4 += i3;
                        } else {
                            c31826o = C8312u.m14628I(Integer.valueOf(i4), str);
                            break;
                        }
                    }
                }
                i = c31599d.AVJ;
                i2 = c31599d.AVK;
                i3 = c31599d.hzv;
                if (i3 > 0) {
                    if (i <= i2) {
                        i4 = i;
                    }
                    c31826o = null;
                } else {
                    if (i >= i2) {
                        i4 = i;
                    }
                    c31826o = null;
                }
                while (true) {
                    for (Object next2 : collection) {
                        str = (String) next2;
                        if (C6163u.m9835a(str, (String) charSequence, i4, str.length(), z)) {
                            obj3 = next2;
                            break;
                        }
                    }
                    obj3 = null;
                    str = (String) obj3;
                    if (str == null) {
                        if (i4 == i2) {
                            break;
                        }
                        i4 += i3;
                    } else {
                        c31826o = C8312u.m14628I(Integer.valueOf(i4), str);
                        break;
                    }
                }
            }
            String str2 = (String) C25035t.m39345h((Iterable) collection);
            intValue = C31820v.m51518a(charSequence, str2, intValue, false, 4);
            if (intValue >= 0) {
                c31826o = C8312u.m14628I(Integer.valueOf(intValue), str2);
            }
            c31826o = null;
            if (c31826o != null) {
                C31826o I = C8312u.m14628I(c31826o.first, Integer.valueOf(((String) c31826o.second).length()));
                AppMethodBeat.m2505o(56305);
                return I;
            }
            AppMethodBeat.m2505o(56305);
            return null;
        }
    }

    /* renamed from: as */
    public static final C31599d m51529as(CharSequence charSequence) {
        AppMethodBeat.m2504i(56307);
        C25052j.m39376p(charSequence, "receiver$0");
        C31599d c31599d = new C31599d(0, charSequence.length() - 1);
        AppMethodBeat.m2505o(56307);
        return c31599d;
    }

    /* renamed from: at */
    public static final int m51530at(CharSequence charSequence) {
        AppMethodBeat.m2504i(56308);
        C25052j.m39376p(charSequence, "receiver$0");
        int length = charSequence.length() - 1;
        AppMethodBeat.m2505o(56308);
        return length;
    }

    /* renamed from: jd */
    public static final String m51541jd(String str, String str2) {
        AppMethodBeat.m2504i(56310);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(str2, "missingDelimiterValue");
        int a = C31820v.m51514a((CharSequence) str, '<', 0, 6);
        if (a == -1) {
            AppMethodBeat.m2505o(56310);
            return str2;
        }
        str2 = str.substring(0, a);
        C25052j.m39375o(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.m2505o(56310);
        return str2;
    }

    /* renamed from: je */
    public static /* synthetic */ String m51542je(String str, String str2) {
        AppMethodBeat.m2504i(56312);
        String aJ = C31820v.m51527aJ(str, str2, str);
        AppMethodBeat.m2505o(56312);
        return aJ;
    }

    /* renamed from: aJ */
    public static final String m51527aJ(String str, String str2, String str3) {
        AppMethodBeat.m2504i(56311);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(str2, "delimiter");
        C25052j.m39376p(str3, "missingDelimiterValue");
        int a = C31820v.m51518a((CharSequence) str, str2, 0, false, 6);
        if (a == -1) {
            AppMethodBeat.m2505o(56311);
            return str3;
        }
        str3 = str.substring(0, a);
        C25052j.m39375o(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.m2505o(56311);
        return str3;
    }

    /* renamed from: jf */
    public static /* synthetic */ String m51543jf(String str, String str2) {
        AppMethodBeat.m2504i(56314);
        String aK = C31820v.m51528aK(str, str2, str);
        AppMethodBeat.m2505o(56314);
        return aK;
    }

    /* renamed from: aK */
    public static final String m51528aK(String str, String str2, String str3) {
        AppMethodBeat.m2504i(56313);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(str2, "delimiter");
        C25052j.m39376p(str3, "missingDelimiterValue");
        int a = C31820v.m51518a((CharSequence) str, str2, 0, false, 6);
        if (a == -1) {
            AppMethodBeat.m2505o(56313);
            return str3;
        }
        str3 = str.substring(a + str2.length(), str.length());
        C25052j.m39375o(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.m2505o(56313);
        return str3;
    }

    /* renamed from: jg */
    public static final String m51544jg(String str, String str2) {
        AppMethodBeat.m2504i(56315);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(str2, "missingDelimiterValue");
        int a = C31820v.m51512a((CharSequence) str, (char) IOUtils.DIR_SEPARATOR_UNIX);
        if (a == -1) {
            AppMethodBeat.m2505o(56315);
            return str2;
        }
        str2 = str.substring(0, a);
        C25052j.m39375o(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.m2505o(56315);
        return str2;
    }

    /* renamed from: a */
    public static final String m51523a(String str, char c, String str2) {
        AppMethodBeat.m2504i(56316);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(str2, "missingDelimiterValue");
        int a = C31820v.m51512a((CharSequence) str, c);
        if (a == -1) {
            AppMethodBeat.m2505o(56316);
            return str2;
        }
        str2 = str.substring(a + 1, str.length());
        C25052j.m39375o(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.m2505o(56316);
        return str2;
    }

    /* renamed from: b */
    public static final String m51535b(String str, CharSequence charSequence) {
        AppMethodBeat.m2504i(56318);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(charSequence, "prefix");
        if (C31820v.m51538c((CharSequence) str, charSequence)) {
            str = str.substring(charSequence.length());
            C25052j.m39375o(str, "(this as java.lang.String).substring(startIndex)");
            AppMethodBeat.m2505o(56318);
            return str;
        }
        AppMethodBeat.m2505o(56318);
        return str;
    }

    /* renamed from: a */
    public static final boolean m51525a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(56319);
        C25052j.m39376p(charSequence, "receiver$0");
        C25052j.m39376p(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (i < 0 || charSequence.length() - i2 < 0 || i > charSequence2.length() - i2) {
            AppMethodBeat.m2505o(56319);
            return false;
        }
        int i3 = 0;
        while (i3 < i2) {
            if (C25272c.m39838a(charSequence.charAt(i3 + 0), charSequence2.charAt(i + i3), z)) {
                i3++;
            } else {
                AppMethodBeat.m2505o(56319);
                return false;
            }
        }
        AppMethodBeat.m2505o(56319);
        return true;
    }

    /* renamed from: au */
    public static final boolean m51531au(CharSequence charSequence) {
        AppMethodBeat.m2504i(56320);
        C25052j.m39376p(charSequence, "receiver$0");
        if (charSequence.length() <= 0 || !C25272c.m39838a(charSequence.charAt(0), '0', false)) {
            AppMethodBeat.m2505o(56320);
            return false;
        }
        AppMethodBeat.m2505o(56320);
        return true;
    }

    /* renamed from: c */
    public static final boolean m51538c(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.m2504i(56321);
        C25052j.m39376p(charSequence, "receiver$0");
        C25052j.m39376p(charSequence2, "prefix");
        boolean jb;
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            jb = C6163u.m9839jb((String) charSequence, (String) charSequence2);
            AppMethodBeat.m2505o(56321);
            return jb;
        }
        jb = C31820v.m51525a(charSequence, charSequence2, 0, charSequence2.length(), false);
        AppMethodBeat.m2505o(56321);
        return jb;
    }

    /* renamed from: b */
    private static /* synthetic */ int m51533b(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(56323);
        int a = C31820v.m51515a(charSequence, charSequence2, i, i2, z, false);
        AppMethodBeat.m2505o(56323);
        return a;
    }

    /* renamed from: a */
    private static final int m51515a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        int in;
        int im;
        C36938b aP;
        AppMethodBeat.m2504i(56322);
        if (z2) {
            in = C0016h.m20in(i, C31820v.m51530at(charSequence));
            im = C0016h.m19im(i2, 0);
            C36939a c36939a = C36938b.AVL;
            aP = C36939a.m61713aP(in, im, -1);
        } else {
            aP = new C31599d(C0016h.m19im(i, 0), C0016h.m20in(i2, charSequence.length()));
        }
        int i3;
        int i4;
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            im = aP.AVJ;
            i3 = aP.AVK;
            int i5 = aP.hzv;
            if (i5 > 0) {
                if (im <= i3) {
                    i4 = im;
                }
            } else if (im >= i3) {
                i4 = im;
            }
            while (!C6163u.m9835a((String) charSequence2, (String) charSequence, i4, charSequence2.length(), z)) {
                if (i4 != i3) {
                    i4 += i5;
                }
            }
            AppMethodBeat.m2505o(56322);
            return i4;
        }
        im = aP.AVJ;
        i4 = aP.AVK;
        i3 = aP.hzv;
        if (i3 > 0) {
            if (im <= i4) {
                in = im;
            }
        } else if (im >= i4) {
            in = im;
        }
        while (!C31820v.m51525a(charSequence2, charSequence, in, charSequence2.length(), z)) {
            if (in != i4) {
                in += i3;
            }
        }
        AppMethodBeat.m2505o(56322);
        return in;
        AppMethodBeat.m2505o(56322);
        return -1;
    }

    /* renamed from: a */
    public static final int m51513a(CharSequence charSequence, char c, int i) {
        AppMethodBeat.m2504i(56324);
        C25052j.m39376p(charSequence, "receiver$0");
        int indexOf;
        if (charSequence instanceof String) {
            indexOf = ((String) charSequence).indexOf(c, i);
            AppMethodBeat.m2505o(56324);
            return indexOf;
        }
        char[] cArr = new char[]{c};
        C25052j.m39376p(charSequence, "receiver$0");
        C25052j.m39376p(cArr, "chars");
        if (charSequence instanceof String) {
            indexOf = ((String) charSequence).indexOf(C36913i.m61693b(cArr), i);
            AppMethodBeat.m2505o(56324);
            return indexOf;
        }
        indexOf = C0016h.m19im(i, 0);
        int at = C31820v.m51530at(charSequence);
        if (indexOf <= at) {
            while (true) {
                int i2;
                char charAt = charSequence.charAt(indexOf);
                for (i2 = 0; i2 <= 0; i2++) {
                    if (C25272c.m39838a(cArr[i2], charAt, false)) {
                        i2 = 1;
                        break;
                    }
                }
                i2 = 0;
                if (i2 == 0) {
                    if (indexOf == at) {
                        break;
                    }
                    indexOf++;
                } else {
                    AppMethodBeat.m2505o(56324);
                    return indexOf;
                }
            }
        }
        AppMethodBeat.m2505o(56324);
        return -1;
    }

    /* renamed from: a */
    public static final int m51517a(CharSequence charSequence, String str, int i, boolean z) {
        AppMethodBeat.m2504i(56326);
        C25052j.m39376p(charSequence, "receiver$0");
        C25052j.m39376p(str, "string");
        int b;
        if (z || !(charSequence instanceof String)) {
            b = C31820v.m51533b(charSequence, str, i, charSequence.length(), z);
            AppMethodBeat.m2505o(56326);
            return b;
        }
        b = ((String) charSequence).indexOf(str, i);
        AppMethodBeat.m2505o(56326);
        return b;
    }

    /* renamed from: b */
    public static final int m51532b(CharSequence charSequence, char c, int i) {
        AppMethodBeat.m2504i(56328);
        C25052j.m39376p(charSequence, "receiver$0");
        int lastIndexOf;
        if (charSequence instanceof String) {
            lastIndexOf = ((String) charSequence).lastIndexOf(c, i);
            AppMethodBeat.m2505o(56328);
            return lastIndexOf;
        }
        char[] cArr = new char[]{c};
        C25052j.m39376p(charSequence, "receiver$0");
        C25052j.m39376p(cArr, "chars");
        if (charSequence instanceof String) {
            lastIndexOf = ((String) charSequence).lastIndexOf(C36913i.m61693b(cArr), i);
            AppMethodBeat.m2505o(56328);
            return lastIndexOf;
        }
        for (lastIndexOf = C0016h.m20in(i, C31820v.m51530at(charSequence)); lastIndexOf >= 0; lastIndexOf--) {
            int i2;
            char charAt = charSequence.charAt(lastIndexOf);
            for (i2 = 0; i2 <= 0; i2++) {
                if (C25272c.m39838a(cArr[i2], charAt, false)) {
                    i2 = 1;
                    break;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                AppMethodBeat.m2505o(56328);
                return lastIndexOf;
            }
        }
        AppMethodBeat.m2505o(56328);
        return -1;
    }

    /* renamed from: a */
    public static final int m51516a(CharSequence charSequence, String str, int i) {
        AppMethodBeat.m2504i(56330);
        C25052j.m39376p(charSequence, "receiver$0");
        C25052j.m39376p(str, "string");
        int lastIndexOf;
        if (charSequence instanceof String) {
            lastIndexOf = ((String) charSequence).lastIndexOf(str, i);
            AppMethodBeat.m2505o(56330);
            return lastIndexOf;
        }
        lastIndexOf = C31820v.m51515a(charSequence, str, i, 0, false, true);
        AppMethodBeat.m2505o(56330);
        return lastIndexOf;
    }

    /* renamed from: a */
    public static final boolean m51526a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        AppMethodBeat.m2504i(56332);
        C25052j.m39376p(charSequence, "receiver$0");
        C25052j.m39376p(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (charSequence2 instanceof String) {
            if (C31820v.m51518a(charSequence, (String) charSequence2, 0, z, 2) >= 0) {
                AppMethodBeat.m2505o(56332);
                return true;
            }
            AppMethodBeat.m2505o(56332);
            return false;
        } else if (C31820v.m51533b(charSequence, charSequence2, 0, charSequence.length(), z) >= 0) {
            AppMethodBeat.m2505o(56332);
            return true;
        } else {
            AppMethodBeat.m2505o(56332);
            return false;
        }
    }

    /* renamed from: b */
    public static final boolean m51536b(CharSequence charSequence, char c) {
        AppMethodBeat.m2504i(56334);
        C25052j.m39376p(charSequence, "receiver$0");
        if (C31820v.m51514a(charSequence, c, 0, 2) >= 0) {
            AppMethodBeat.m2505o(56334);
            return true;
        }
        AppMethodBeat.m2505o(56334);
        return false;
    }

    /* renamed from: b */
    public static final C44937h<String> m51534b(CharSequence charSequence, String[] strArr, boolean z) {
        AppMethodBeat.m2504i(56337);
        C25052j.m39376p(charSequence, "receiver$0");
        C25052j.m39376p(strArr, "delimiters");
        C44937h d = C17348n.m26863d(C31820v.m51519a(charSequence, strArr, z), new C24630b(charSequence));
        AppMethodBeat.m2505o(56337);
        return d;
    }

    /* renamed from: a */
    public static final List<String> m51524a(CharSequence charSequence, String[] strArr) {
        int i;
        AppMethodBeat.m2504i(56339);
        C25052j.m39376p(charSequence, "receiver$0");
        C25052j.m39376p(strArr, "delimiters");
        String str = strArr[0];
        if (str.length() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        List<String> list;
        if (i == 0) {
            int a = C31820v.m51517a(charSequence, str, 0, false);
            if (a == -1) {
                List listOf = C25033k.listOf(charSequence.toString());
                AppMethodBeat.m2505o(56339);
                return listOf;
            }
            ArrayList arrayList = new ArrayList(10);
            int i2 = 0;
            do {
                arrayList.add(charSequence.subSequence(i2, a).toString());
                i2 = str.length() + a;
                a = C31820v.m51517a(charSequence, str, i2, false);
            } while (a != -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            list = arrayList;
            AppMethodBeat.m2505o(56339);
            return list;
        }
        Iterable<C31599d> f = C17348n.m26867f(C31820v.m51519a(charSequence, strArr, false));
        Collection arrayList2 = new ArrayList(C25034m.m39318d(f));
        for (C31599d a2 : f) {
            arrayList2.add(C31820v.m51521a(charSequence, a2));
        }
        list = (List) arrayList2;
        AppMethodBeat.m2505o(56339);
        return list;
    }

    public static final CharSequence trim(CharSequence charSequence) {
        AppMethodBeat.m2504i(56306);
        C25052j.m39376p(charSequence, "receiver$0");
        int length = charSequence.length() - 1;
        Object obj = null;
        int i = 0;
        while (i <= length) {
            boolean isWhitespace = C17354b.isWhitespace(charSequence.charAt(obj == null ? i : length));
            if (obj != null) {
                if (!isWhitespace) {
                    break;
                }
                length--;
            } else if (isWhitespace) {
                i++;
            } else {
                obj = 1;
            }
        }
        CharSequence subSequence = charSequence.subSequence(i, length + 1);
        AppMethodBeat.m2505o(56306);
        return subSequence;
    }

    /* renamed from: a */
    public static final String m51521a(CharSequence charSequence, C31599d c31599d) {
        AppMethodBeat.m2504i(56309);
        C25052j.m39376p(charSequence, "receiver$0");
        C25052j.m39376p(c31599d, "range");
        String obj = charSequence.subSequence(c31599d.AVJ, c31599d.AVK + 1).toString();
        AppMethodBeat.m2505o(56309);
        return obj;
    }
}
