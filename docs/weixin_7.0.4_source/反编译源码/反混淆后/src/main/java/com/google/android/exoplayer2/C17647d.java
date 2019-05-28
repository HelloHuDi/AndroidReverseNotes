package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.drm.C41600b;
import com.google.android.exoplayer2.drm.C44648d;
import com.google.android.exoplayer2.metadata.C37267e;
import com.google.android.exoplayer2.metadata.C37267e.C8694a;
import com.google.android.exoplayer2.p099a.C0826e;
import com.google.android.exoplayer2.p099a.C37229i;
import com.google.android.exoplayer2.p099a.C8639c;
import com.google.android.exoplayer2.p099a.C8640d;
import com.google.android.exoplayer2.p105f.C17661j;
import com.google.android.exoplayer2.p105f.C17661j.C17662a;
import com.google.android.exoplayer2.p797e.C17652c;
import com.google.android.exoplayer2.video.C17693e;
import com.google.android.exoplayer2.video.C37285c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.google.android.exoplayer2.d */
public final class C17647d implements C0883u {
    private final C41600b<C44648d> aMJ;
    private final int aMK;
    private final long aML;
    private final Context context;

    public C17647d(Context context) {
        this(context, (byte) 0);
    }

    private C17647d(Context context, byte b) {
        this(context, 0);
    }

    private C17647d(Context context, char c) {
        this(context, (short) 0);
    }

    private C17647d(Context context, short s) {
        this.context = context;
        this.aMJ = null;
        this.aMK = 0;
        this.aML = 5000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x017a A:{Splitter:B:12:0x009e, ExcHandler: Exception (r2_44 'e' java.lang.Exception)} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x018c A:{Splitter:B:18:0x00d3, ExcHandler: Exception (r2_39 'e' java.lang.Exception)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:33:0x017a, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:34:0x017b, code skipped:
            r3 = new java.lang.RuntimeException(r2);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(94753);
     */
    /* JADX WARNING: Missing block: B:35:0x0186, code skipped:
            throw r3;
     */
    /* JADX WARNING: Missing block: B:39:0x018c, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:40:0x018d, code skipped:
            r3 = new java.lang.RuntimeException(r2);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(94753);
     */
    /* JADX WARNING: Missing block: B:41:0x0198, code skipped:
            throw r3;
     */
    /* JADX WARNING: Missing block: B:47:0x01a9, code skipped:
            r2 = r3;
     */
    /* JADX WARNING: Missing block: B:49:0x01ac, code skipped:
            r2 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final C32069r[] mo2614a(Handler handler, C17693e c17693e, C0826e c0826e, C17662a c17662a, C8694a c8694a) {
        int size;
        int i;
        RuntimeException runtimeException;
        C32069r[] c32069rArr;
        AppMethodBeat.m2504i(94753);
        ArrayList arrayList = new ArrayList();
        Context context = this.context;
        C41600b c41600b = this.aMJ;
        long j = this.aML;
        int i2 = this.aMK;
        arrayList.add(new C37285c(context, C17652c.beM, j, c41600b, handler, c17693e));
        if (i2 != 0) {
            size = arrayList.size();
            if (i2 == 2) {
                i = size - 1;
            } else {
                i = size;
            }
            try {
                arrayList.add(i, (C32069r) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[]{Boolean.TYPE, Long.TYPE, Handler.class, C17693e.class, Integer.TYPE}).newInstance(new Object[]{Boolean.TRUE, Long.valueOf(j), handler, c17693e, Integer.valueOf(50)}));
            } catch (ClassNotFoundException e) {
            } catch (Exception e2) {
                runtimeException = new RuntimeException(e2);
                AppMethodBeat.m2505o(94753);
                throw runtimeException;
            }
        }
        Context context2 = this.context;
        C41600b c41600b2 = this.aMJ;
        C8640d[] c8640dArr = new C8640d[0];
        int i3 = this.aMK;
        arrayList.add(new C37229i(C17652c.beM, c41600b2, handler, c0826e, C8639c.m15297ai(context2), c8640dArr));
        if (i3 != 0) {
            int size2 = arrayList.size();
            if (i3 == 2) {
                size2--;
            }
            try {
                i = size2 + 1;
                arrayList.add(size2, (C32069r) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(new Class[]{Handler.class, C0826e.class, C8640d[].class}).newInstance(new Object[]{handler, c0826e, c8640dArr}));
                size2 = i;
            } catch (ClassNotFoundException e3) {
                size = size2;
                size2 = size;
                i = size2 + 1;
                arrayList.add(size2, (C32069r) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(new Class[]{Handler.class, C0826e.class, C8640d[].class}).newInstance(new Object[]{handler, c0826e, c8640dArr}));
                arrayList.add(i, (C32069r) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(new Class[]{Handler.class, C0826e.class, C8640d[].class}).newInstance(new Object[]{handler, c0826e, c8640dArr}));
                arrayList.add(new C17661j(c17662a, handler.getLooper()));
                arrayList.add(new C37267e(c8694a, handler.getLooper()));
                c32069rArr = (C32069r[]) arrayList.toArray(new C32069r[arrayList.size()]);
                AppMethodBeat.m2505o(94753);
                return c32069rArr;
            } catch (Exception e4) {
            }
            try {
                i = size2 + 1;
                arrayList.add(size2, (C32069r) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(new Class[]{Handler.class, C0826e.class, C8640d[].class}).newInstance(new Object[]{handler, c0826e, c8640dArr}));
            } catch (ClassNotFoundException e5) {
                size = size2;
                i = size;
                arrayList.add(i, (C32069r) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(new Class[]{Handler.class, C0826e.class, C8640d[].class}).newInstance(new Object[]{handler, c0826e, c8640dArr}));
                arrayList.add(new C17661j(c17662a, handler.getLooper()));
                arrayList.add(new C37267e(c8694a, handler.getLooper()));
                c32069rArr = (C32069r[]) arrayList.toArray(new C32069r[arrayList.size()]);
                AppMethodBeat.m2505o(94753);
                return c32069rArr;
            } catch (Exception e6) {
            }
            try {
                arrayList.add(i, (C32069r) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(new Class[]{Handler.class, C0826e.class, C8640d[].class}).newInstance(new Object[]{handler, c0826e, c8640dArr}));
            } catch (ClassNotFoundException e7) {
            } catch (Exception e22) {
                runtimeException = new RuntimeException(e22);
                AppMethodBeat.m2505o(94753);
                throw runtimeException;
            }
        }
        arrayList.add(new C17661j(c17662a, handler.getLooper()));
        arrayList.add(new C37267e(c8694a, handler.getLooper()));
        c32069rArr = (C32069r[]) arrayList.toArray(new C32069r[arrayList.size()]);
        AppMethodBeat.m2505o(94753);
        return c32069rArr;
    }
}
