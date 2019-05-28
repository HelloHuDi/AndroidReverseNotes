package com.github.henryye.nativeiv.p794b;

import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.github.henryye.nativeiv.b.a */
public final class C8636a {
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078 A:{Splitter:B:6:0x0031, ExcHandler: IOException (r0_10 'e' java.io.IOException)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:20:0x0078, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27913a("Ni.ByteBufferUtil", r0, "hy: allocateByteBufferFromStream IOException", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            r11.reset();
     */
    /* JADX WARNING: Missing block: B:26:0x008d, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:27:0x008e, code skipped:
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27913a("Ni.ByteBufferUtil", r0, "hy: exception in finally!", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            r11.reset();
     */
    /* JADX WARNING: Missing block: B:39:0x00bd, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(115772);
     */
    /* JADX WARNING: Missing block: B:41:0x00c1, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:42:0x00c2, code skipped:
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27913a("Ni.ByteBufferUtil", r1, "hy: exception in finally!", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:43:0x00ce, code skipped:
            r1 = e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public static ByteBuffer m15268f(InputStream inputStream) {
        AppMethodBeat.m2504i(115772);
        if (!inputStream.markSupported()) {
            inputStream = C45013d.m82444h(inputStream);
            C45013d.m82445i(inputStream);
        }
        if (inputStream == null) {
            AppMethodBeat.m2505o(115772);
            return null;
        }
        ByteBuffer allocateDirect;
        byte[] bArr = new byte[Downloads.MIN_WAIT_FOR_NETWORK];
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(100000);
        allocateDirect2.order(ByteOrder.nativeOrder());
        int i = 100000;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                i2 += read;
                if (i2 > i) {
                    allocateDirect = ByteBuffer.allocateDirect(allocateDirect2.capacity() + 100000);
                    allocateDirect.order(ByteOrder.nativeOrder());
                    allocateDirect2.position(0);
                    allocateDirect.put(allocateDirect2);
                    i = allocateDirect.capacity();
                } else {
                    allocateDirect = allocateDirect2;
                }
                if (read < 0) {
                    break;
                }
                allocateDirect.position(i3);
                allocateDirect.put(bArr, 0, read);
                i3 += read;
                allocateDirect2 = allocateDirect;
            } catch (IOException e) {
            } catch (BufferOverflowException e2) {
                Throwable e3 = e2;
                allocateDirect = allocateDirect2;
                C17837c.m27913a("Ni.ByteBufferUtil", e3, "hy: allocateByteBufferFromStream BufferOverflowException", new Object[0]);
                try {
                    inputStream.reset();
                } catch (Exception e4) {
                    C17837c.m27913a("Ni.ByteBufferUtil", e4, "hy: exception in finally!", new Object[0]);
                }
                AppMethodBeat.m2505o(115772);
                return allocateDirect;
            }
        }
        allocateDirect.position(0);
        try {
            inputStream.reset();
        } catch (Exception e42) {
            C17837c.m27913a("Ni.ByteBufferUtil", e42, "hy: exception in finally!", new Object[0]);
        }
        AppMethodBeat.m2505o(115772);
        return allocateDirect;
        AppMethodBeat.m2505o(115772);
        return null;
    }
}
