package a.k;

import a.a.i;
import a.a.t;
import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.h.d;
import a.h.h;
import a.j.n;
import a.l;
import a.o;
import a.u;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\n\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\u001c\u001a:\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006\u001a4\u0010 \u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\b¢\u0006\u0002\u0010%\u001a4\u0010&\u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\b¢\u0006\u0002\u0010%\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b)\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010+\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010+\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u0010.\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u0010/\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u00100\u001a\u00020\r*\u00020\u0002H\b\u001a \u00101\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00102\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00103\u001a\u000204*\u00020\u0002H\u0002\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00106\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u00106\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00107\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u0002\u001a\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u0002\u001a\u0015\u0010;\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\f\u001a\u000f\u0010<\u001a\u00020\n*\u0004\u0018\u00010\nH\b\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010=\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001aG\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010F\u001a=\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u0006\u0010B\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\bE\u001a4\u0010G\u001a\u00020\r*\u00020\u00022\u0006\u0010H\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010J\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u0002\u001a\u0012\u0010J\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u0002\u001a\u001a\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006\u001a\u0012\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\b\u001a\u0015\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001H\b\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a+\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00020SH\b\u001a\u001d\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\b\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001d\u0010[\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\b\u001a\"\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002\u001a%\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002H\b\u001a\u001d\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002H\b\u001a=\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010^\u001a0\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a/\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010P\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\b_\u001a%\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010D\u001a\u00020\u0006H\b\u001a=\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010a\u001a0\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010c\u001a\u00020\u0002*\u00020\n2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u0006H\b\u001a\u001f\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u0006H\b\u001a\u0012\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u0012\u0010f\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\n\u0010k\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010k\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010k\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010k\u001a\u00020\n*\u00020\nH\b\u001a!\u0010k\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010k\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010m\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010m\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010m\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010m\u001a\u00020\n*\u00020\nH\b\u001a!\u0010m\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010m\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010n\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010n\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010n\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010n\u001a\u00020\n*\u00020\nH\b\u001a!\u0010n\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010n\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006o"}, dWq = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, dWr = 1)
public class v extends u {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"})
    static final class b extends k implements a.f.a.b<d, String> {
        final /* synthetic */ CharSequence BPo;

        b(CharSequence charSequence) {
            this.BPo = charSequence;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(56344);
            d dVar = (d) obj;
            j.p(dVar, "it");
            String a = v.a(this.BPo, dVar);
            AppMethodBeat.o(56344);
            return a;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"})
    static final class a extends k implements m<CharSequence, Integer, o<? extends Integer, ? extends Integer>> {
        final /* synthetic */ List BPm;
        final /* synthetic */ boolean BPn;

        a(List list, boolean z) {
            this.BPm = list;
            this.BPn = z;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            o oVar;
            AppMethodBeat.i(56305);
            CharSequence charSequence = (CharSequence) obj;
            int intValue = ((Number) obj2).intValue();
            j.p(charSequence, "receiver$0");
            Collection collection = this.BPm;
            boolean z = this.BPn;
            if (z || collection.size() != 1) {
                a.h.b dVar = new d(h.im(intValue, 0), charSequence.length());
                int i;
                int i2;
                int i3;
                int i4;
                String str;
                Object obj3;
                if (!(charSequence instanceof String)) {
                    i = dVar.AVJ;
                    i2 = dVar.AVK;
                    i3 = dVar.hzv;
                    if (i3 > 0) {
                        if (i <= i2) {
                            i4 = i;
                        }
                        oVar = null;
                    } else {
                        if (i >= i2) {
                            i4 = i;
                        }
                        oVar = null;
                    }
                    while (true) {
                        for (Object next : collection) {
                            str = (String) next;
                            if (v.a((CharSequence) str, charSequence, i4, str.length(), z)) {
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
                            oVar = u.I(Integer.valueOf(i4), str);
                            break;
                        }
                    }
                }
                i = dVar.AVJ;
                i2 = dVar.AVK;
                i3 = dVar.hzv;
                if (i3 > 0) {
                    if (i <= i2) {
                        i4 = i;
                    }
                    oVar = null;
                } else {
                    if (i >= i2) {
                        i4 = i;
                    }
                    oVar = null;
                }
                while (true) {
                    for (Object next2 : collection) {
                        str = (String) next2;
                        if (u.a(str, (String) charSequence, i4, str.length(), z)) {
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
                        oVar = u.I(Integer.valueOf(i4), str);
                        break;
                    }
                }
            }
            String str2 = (String) t.h((Iterable) collection);
            intValue = v.a(charSequence, str2, intValue, false, 4);
            if (intValue >= 0) {
                oVar = u.I(Integer.valueOf(intValue), str2);
            }
            oVar = null;
            if (oVar != null) {
                o I = u.I(oVar.first, Integer.valueOf(((String) oVar.second).length()));
                AppMethodBeat.o(56305);
                return I;
            }
            AppMethodBeat.o(56305);
            return null;
        }
    }

    public static final d as(CharSequence charSequence) {
        AppMethodBeat.i(56307);
        j.p(charSequence, "receiver$0");
        d dVar = new d(0, charSequence.length() - 1);
        AppMethodBeat.o(56307);
        return dVar;
    }

    public static final int at(CharSequence charSequence) {
        AppMethodBeat.i(56308);
        j.p(charSequence, "receiver$0");
        int length = charSequence.length() - 1;
        AppMethodBeat.o(56308);
        return length;
    }

    public static final String jd(String str, String str2) {
        AppMethodBeat.i(56310);
        j.p(str, "receiver$0");
        j.p(str2, "missingDelimiterValue");
        int a = a((CharSequence) str, '<', 0, 6);
        if (a == -1) {
            AppMethodBeat.o(56310);
            return str2;
        }
        str2 = str.substring(0, a);
        j.o(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(56310);
        return str2;
    }

    public static /* synthetic */ String je(String str, String str2) {
        AppMethodBeat.i(56312);
        String aJ = aJ(str, str2, str);
        AppMethodBeat.o(56312);
        return aJ;
    }

    public static final String aJ(String str, String str2, String str3) {
        AppMethodBeat.i(56311);
        j.p(str, "receiver$0");
        j.p(str2, "delimiter");
        j.p(str3, "missingDelimiterValue");
        int a = a((CharSequence) str, str2, 0, false, 6);
        if (a == -1) {
            AppMethodBeat.o(56311);
            return str3;
        }
        str3 = str.substring(0, a);
        j.o(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(56311);
        return str3;
    }

    public static /* synthetic */ String jf(String str, String str2) {
        AppMethodBeat.i(56314);
        String aK = aK(str, str2, str);
        AppMethodBeat.o(56314);
        return aK;
    }

    public static final String aK(String str, String str2, String str3) {
        AppMethodBeat.i(56313);
        j.p(str, "receiver$0");
        j.p(str2, "delimiter");
        j.p(str3, "missingDelimiterValue");
        int a = a((CharSequence) str, str2, 0, false, 6);
        if (a == -1) {
            AppMethodBeat.o(56313);
            return str3;
        }
        str3 = str.substring(a + str2.length(), str.length());
        j.o(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(56313);
        return str3;
    }

    public static final String jg(String str, String str2) {
        AppMethodBeat.i(56315);
        j.p(str, "receiver$0");
        j.p(str2, "missingDelimiterValue");
        int a = a((CharSequence) str, (char) IOUtils.DIR_SEPARATOR_UNIX);
        if (a == -1) {
            AppMethodBeat.o(56315);
            return str2;
        }
        str2 = str.substring(0, a);
        j.o(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(56315);
        return str2;
    }

    public static final String a(String str, char c, String str2) {
        AppMethodBeat.i(56316);
        j.p(str, "receiver$0");
        j.p(str2, "missingDelimiterValue");
        int a = a((CharSequence) str, c);
        if (a == -1) {
            AppMethodBeat.o(56316);
            return str2;
        }
        str2 = str.substring(a + 1, str.length());
        j.o(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(56316);
        return str2;
    }

    public static final String b(String str, CharSequence charSequence) {
        AppMethodBeat.i(56318);
        j.p(str, "receiver$0");
        j.p(charSequence, "prefix");
        if (c((CharSequence) str, charSequence)) {
            str = str.substring(charSequence.length());
            j.o(str, "(this as java.lang.String).substring(startIndex)");
            AppMethodBeat.o(56318);
            return str;
        }
        AppMethodBeat.o(56318);
        return str;
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z) {
        AppMethodBeat.i(56319);
        j.p(charSequence, "receiver$0");
        j.p(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (i < 0 || charSequence.length() - i2 < 0 || i > charSequence2.length() - i2) {
            AppMethodBeat.o(56319);
            return false;
        }
        int i3 = 0;
        while (i3 < i2) {
            if (c.a(charSequence.charAt(i3 + 0), charSequence2.charAt(i + i3), z)) {
                i3++;
            } else {
                AppMethodBeat.o(56319);
                return false;
            }
        }
        AppMethodBeat.o(56319);
        return true;
    }

    public static final boolean au(CharSequence charSequence) {
        AppMethodBeat.i(56320);
        j.p(charSequence, "receiver$0");
        if (charSequence.length() <= 0 || !c.a(charSequence.charAt(0), '0', false)) {
            AppMethodBeat.o(56320);
            return false;
        }
        AppMethodBeat.o(56320);
        return true;
    }

    public static final boolean c(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(56321);
        j.p(charSequence, "receiver$0");
        j.p(charSequence2, "prefix");
        boolean jb;
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            jb = u.jb((String) charSequence, (String) charSequence2);
            AppMethodBeat.o(56321);
            return jb;
        }
        jb = a(charSequence, charSequence2, 0, charSequence2.length(), false);
        AppMethodBeat.o(56321);
        return jb;
    }

    private static /* synthetic */ int b(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z) {
        AppMethodBeat.i(56323);
        int a = a(charSequence, charSequence2, i, i2, z, false);
        AppMethodBeat.o(56323);
        return a;
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        int in;
        int im;
        a.h.b aP;
        AppMethodBeat.i(56322);
        if (z2) {
            in = h.in(i, at(charSequence));
            im = h.im(i2, 0);
            a.h.b.a aVar = a.h.b.AVL;
            aP = a.h.b.a.aP(in, im, -1);
        } else {
            aP = new d(h.im(i, 0), h.in(i2, charSequence.length()));
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
            while (!u.a((String) charSequence2, (String) charSequence, i4, charSequence2.length(), z)) {
                if (i4 != i3) {
                    i4 += i5;
                }
            }
            AppMethodBeat.o(56322);
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
        while (!a(charSequence2, charSequence, in, charSequence2.length(), z)) {
            if (in != i4) {
                in += i3;
            }
        }
        AppMethodBeat.o(56322);
        return in;
        AppMethodBeat.o(56322);
        return -1;
    }

    public static final int a(CharSequence charSequence, char c, int i) {
        AppMethodBeat.i(56324);
        j.p(charSequence, "receiver$0");
        int indexOf;
        if (charSequence instanceof String) {
            indexOf = ((String) charSequence).indexOf(c, i);
            AppMethodBeat.o(56324);
            return indexOf;
        }
        char[] cArr = new char[]{c};
        j.p(charSequence, "receiver$0");
        j.p(cArr, "chars");
        if (charSequence instanceof String) {
            indexOf = ((String) charSequence).indexOf(i.b(cArr), i);
            AppMethodBeat.o(56324);
            return indexOf;
        }
        indexOf = h.im(i, 0);
        int at = at(charSequence);
        if (indexOf <= at) {
            while (true) {
                int i2;
                char charAt = charSequence.charAt(indexOf);
                for (i2 = 0; i2 <= 0; i2++) {
                    if (c.a(cArr[i2], charAt, false)) {
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
                    AppMethodBeat.o(56324);
                    return indexOf;
                }
            }
        }
        AppMethodBeat.o(56324);
        return -1;
    }

    public static final int a(CharSequence charSequence, String str, int i, boolean z) {
        AppMethodBeat.i(56326);
        j.p(charSequence, "receiver$0");
        j.p(str, "string");
        int b;
        if (z || !(charSequence instanceof String)) {
            b = b(charSequence, str, i, charSequence.length(), z);
            AppMethodBeat.o(56326);
            return b;
        }
        b = ((String) charSequence).indexOf(str, i);
        AppMethodBeat.o(56326);
        return b;
    }

    public static final int b(CharSequence charSequence, char c, int i) {
        AppMethodBeat.i(56328);
        j.p(charSequence, "receiver$0");
        int lastIndexOf;
        if (charSequence instanceof String) {
            lastIndexOf = ((String) charSequence).lastIndexOf(c, i);
            AppMethodBeat.o(56328);
            return lastIndexOf;
        }
        char[] cArr = new char[]{c};
        j.p(charSequence, "receiver$0");
        j.p(cArr, "chars");
        if (charSequence instanceof String) {
            lastIndexOf = ((String) charSequence).lastIndexOf(i.b(cArr), i);
            AppMethodBeat.o(56328);
            return lastIndexOf;
        }
        for (lastIndexOf = h.in(i, at(charSequence)); lastIndexOf >= 0; lastIndexOf--) {
            int i2;
            char charAt = charSequence.charAt(lastIndexOf);
            for (i2 = 0; i2 <= 0; i2++) {
                if (c.a(cArr[i2], charAt, false)) {
                    i2 = 1;
                    break;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                AppMethodBeat.o(56328);
                return lastIndexOf;
            }
        }
        AppMethodBeat.o(56328);
        return -1;
    }

    public static final int a(CharSequence charSequence, String str, int i) {
        AppMethodBeat.i(56330);
        j.p(charSequence, "receiver$0");
        j.p(str, "string");
        int lastIndexOf;
        if (charSequence instanceof String) {
            lastIndexOf = ((String) charSequence).lastIndexOf(str, i);
            AppMethodBeat.o(56330);
            return lastIndexOf;
        }
        lastIndexOf = a(charSequence, str, i, 0, false, true);
        AppMethodBeat.o(56330);
        return lastIndexOf;
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        AppMethodBeat.i(56332);
        j.p(charSequence, "receiver$0");
        j.p(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (charSequence2 instanceof String) {
            if (a(charSequence, (String) charSequence2, 0, z, 2) >= 0) {
                AppMethodBeat.o(56332);
                return true;
            }
            AppMethodBeat.o(56332);
            return false;
        } else if (b(charSequence, charSequence2, 0, charSequence.length(), z) >= 0) {
            AppMethodBeat.o(56332);
            return true;
        } else {
            AppMethodBeat.o(56332);
            return false;
        }
    }

    public static final boolean b(CharSequence charSequence, char c) {
        AppMethodBeat.i(56334);
        j.p(charSequence, "receiver$0");
        if (a(charSequence, c, 0, 2) >= 0) {
            AppMethodBeat.o(56334);
            return true;
        }
        AppMethodBeat.o(56334);
        return false;
    }

    public static final a.j.h<String> b(CharSequence charSequence, String[] strArr, boolean z) {
        AppMethodBeat.i(56337);
        j.p(charSequence, "receiver$0");
        j.p(strArr, "delimiters");
        a.j.h d = n.d(a(charSequence, strArr, z), new b(charSequence));
        AppMethodBeat.o(56337);
        return d;
    }

    public static final List<String> a(CharSequence charSequence, String[] strArr) {
        int i;
        AppMethodBeat.i(56339);
        j.p(charSequence, "receiver$0");
        j.p(strArr, "delimiters");
        String str = strArr[0];
        if (str.length() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        List<String> list;
        if (i == 0) {
            int a = a(charSequence, str, 0, false);
            if (a == -1) {
                List listOf = a.a.k.listOf(charSequence.toString());
                AppMethodBeat.o(56339);
                return listOf;
            }
            ArrayList arrayList = new ArrayList(10);
            int i2 = 0;
            do {
                arrayList.add(charSequence.subSequence(i2, a).toString());
                i2 = str.length() + a;
                a = a(charSequence, str, i2, false);
            } while (a != -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            list = arrayList;
            AppMethodBeat.o(56339);
            return list;
        }
        Iterable<d> f = n.f(a(charSequence, strArr, false));
        Collection arrayList2 = new ArrayList(a.a.m.d(f));
        for (d a2 : f) {
            arrayList2.add(a(charSequence, a2));
        }
        list = (List) arrayList2;
        AppMethodBeat.o(56339);
        return list;
    }

    public static final CharSequence trim(CharSequence charSequence) {
        AppMethodBeat.i(56306);
        j.p(charSequence, "receiver$0");
        int length = charSequence.length() - 1;
        Object obj = null;
        int i = 0;
        while (i <= length) {
            boolean isWhitespace = b.isWhitespace(charSequence.charAt(obj == null ? i : length));
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
        AppMethodBeat.o(56306);
        return subSequence;
    }

    public static final String a(CharSequence charSequence, d dVar) {
        AppMethodBeat.i(56309);
        j.p(charSequence, "receiver$0");
        j.p(dVar, "range");
        String obj = charSequence.subSequence(dVar.AVJ, dVar.AVK + 1).toString();
        AppMethodBeat.o(56309);
        return obj;
    }
}
