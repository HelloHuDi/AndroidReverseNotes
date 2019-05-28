package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.a.i;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.f.j;
import com.google.android.exoplayer2.f.j.a;
import com.google.android.exoplayer2.video.c;
import com.google.android.exoplayer2.video.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class d implements u {
    private final b<com.google.android.exoplayer2.drm.d> aMJ;
    private final int aMK;
    private final long aML;
    private final Context context;

    public d(Context context) {
        this(context, (byte) 0);
    }

    private d(Context context, byte b) {
        this(context, 0);
    }

    private d(Context context, char c) {
        this(context, (short) 0);
    }

    private d(Context context, short s) {
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
            com.tencent.matrix.trace.core.AppMethodBeat.o(94753);
     */
    /* JADX WARNING: Missing block: B:35:0x0186, code skipped:
            throw r3;
     */
    /* JADX WARNING: Missing block: B:39:0x018c, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:40:0x018d, code skipped:
            r3 = new java.lang.RuntimeException(r2);
            com.tencent.matrix.trace.core.AppMethodBeat.o(94753);
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
    public final r[] a(Handler handler, e eVar, com.google.android.exoplayer2.a.e eVar2, a aVar, com.google.android.exoplayer2.metadata.e.a aVar2) {
        int size;
        int i;
        RuntimeException runtimeException;
        r[] rVarArr;
        AppMethodBeat.i(94753);
        ArrayList arrayList = new ArrayList();
        Context context = this.context;
        b bVar = this.aMJ;
        long j = this.aML;
        int i2 = this.aMK;
        arrayList.add(new c(context, com.google.android.exoplayer2.e.c.beM, j, bVar, handler, eVar));
        if (i2 != 0) {
            size = arrayList.size();
            if (i2 == 2) {
                i = size - 1;
            } else {
                i = size;
            }
            try {
                arrayList.add(i, (r) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[]{Boolean.TYPE, Long.TYPE, Handler.class, e.class, Integer.TYPE}).newInstance(new Object[]{Boolean.TRUE, Long.valueOf(j), handler, eVar, Integer.valueOf(50)}));
            } catch (ClassNotFoundException e) {
            } catch (Exception e2) {
                runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(94753);
                throw runtimeException;
            }
        }
        Context context2 = this.context;
        b bVar2 = this.aMJ;
        com.google.android.exoplayer2.a.d[] dVarArr = new com.google.android.exoplayer2.a.d[0];
        int i3 = this.aMK;
        arrayList.add(new i(com.google.android.exoplayer2.e.c.beM, bVar2, handler, eVar2, com.google.android.exoplayer2.a.c.ai(context2), dVarArr));
        if (i3 != 0) {
            int size2 = arrayList.size();
            if (i3 == 2) {
                size2--;
            }
            try {
                i = size2 + 1;
                arrayList.add(size2, (r) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(new Class[]{Handler.class, com.google.android.exoplayer2.a.e.class, com.google.android.exoplayer2.a.d[].class}).newInstance(new Object[]{handler, eVar2, dVarArr}));
                size2 = i;
            } catch (ClassNotFoundException e3) {
                size = size2;
                size2 = size;
                i = size2 + 1;
                arrayList.add(size2, (r) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(new Class[]{Handler.class, com.google.android.exoplayer2.a.e.class, com.google.android.exoplayer2.a.d[].class}).newInstance(new Object[]{handler, eVar2, dVarArr}));
                arrayList.add(i, (r) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(new Class[]{Handler.class, com.google.android.exoplayer2.a.e.class, com.google.android.exoplayer2.a.d[].class}).newInstance(new Object[]{handler, eVar2, dVarArr}));
                arrayList.add(new j(aVar, handler.getLooper()));
                arrayList.add(new com.google.android.exoplayer2.metadata.e(aVar2, handler.getLooper()));
                rVarArr = (r[]) arrayList.toArray(new r[arrayList.size()]);
                AppMethodBeat.o(94753);
                return rVarArr;
            } catch (Exception e4) {
            }
            try {
                i = size2 + 1;
                arrayList.add(size2, (r) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(new Class[]{Handler.class, com.google.android.exoplayer2.a.e.class, com.google.android.exoplayer2.a.d[].class}).newInstance(new Object[]{handler, eVar2, dVarArr}));
            } catch (ClassNotFoundException e5) {
                size = size2;
                i = size;
                arrayList.add(i, (r) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(new Class[]{Handler.class, com.google.android.exoplayer2.a.e.class, com.google.android.exoplayer2.a.d[].class}).newInstance(new Object[]{handler, eVar2, dVarArr}));
                arrayList.add(new j(aVar, handler.getLooper()));
                arrayList.add(new com.google.android.exoplayer2.metadata.e(aVar2, handler.getLooper()));
                rVarArr = (r[]) arrayList.toArray(new r[arrayList.size()]);
                AppMethodBeat.o(94753);
                return rVarArr;
            } catch (Exception e6) {
            }
            try {
                arrayList.add(i, (r) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(new Class[]{Handler.class, com.google.android.exoplayer2.a.e.class, com.google.android.exoplayer2.a.d[].class}).newInstance(new Object[]{handler, eVar2, dVarArr}));
            } catch (ClassNotFoundException e7) {
            } catch (Exception e22) {
                runtimeException = new RuntimeException(e22);
                AppMethodBeat.o(94753);
                throw runtimeException;
            }
        }
        arrayList.add(new j(aVar, handler.getLooper()));
        arrayList.add(new com.google.android.exoplayer2.metadata.e(aVar2, handler.getLooper()));
        rVarArr = (r[]) arrayList.toArray(new r[arrayList.size()]);
        AppMethodBeat.o(94753);
        return rVarArr;
    }
}
