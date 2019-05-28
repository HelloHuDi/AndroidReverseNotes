package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.al */
public final class C31018al {
    /* renamed from: e */
    private static HashMap<String, byte[]> f14037e = null;
    /* renamed from: a */
    private HashMap<String, byte[]> f14038a = new HashMap();
    /* renamed from: b */
    private C41028ai f14039b = new C41028ai();
    /* renamed from: c */
    private String f14040c = "GBK";
    /* renamed from: d */
    private C16206am f14041d = new C16206am();

    public C31018al() {
        AppMethodBeat.m2504i(98467);
        AppMethodBeat.m2505o(98467);
    }

    /* renamed from: a */
    public final void mo50337a() {
        this.f14041d.f3130b = 1;
    }

    /* renamed from: a */
    public final void mo50338a(String str) {
        this.f14041d.f3132d = str;
    }

    /* renamed from: b */
    public final void mo50342b(String str) {
        this.f14041d.f3131c = str;
    }

    /* renamed from: a */
    public final <T> void mo50339a(String str, T t) {
        AppMethodBeat.m2504i(98468);
        IllegalArgumentException illegalArgumentException;
        if (str == null) {
            illegalArgumentException = new IllegalArgumentException("put key can not is null");
            AppMethodBeat.m2505o(98468);
            throw illegalArgumentException;
        } else if (t == null) {
            illegalArgumentException = new IllegalArgumentException("put value can not is null");
            AppMethodBeat.m2505o(98468);
            throw illegalArgumentException;
        } else if (t instanceof Set) {
            illegalArgumentException = new IllegalArgumentException("can not support Set");
            AppMethodBeat.m2505o(98468);
            throw illegalArgumentException;
        } else {
            C46767aj c46767aj = new C46767aj();
            c46767aj.mo75323a(this.f14040c);
            c46767aj.mo75328a((Object) t, 0);
            ByteBuffer a = c46767aj.mo75324a();
            byte[] bArr = new byte[a.position()];
            System.arraycopy(a.array(), 0, bArr, 0, bArr.length);
            this.f14038a.put(str, bArr);
            AppMethodBeat.m2505o(98468);
        }
    }

    /* renamed from: b */
    public final byte[] mo50343b() {
        AppMethodBeat.m2504i(98469);
        C46767aj c46767aj = new C46767aj(0);
        c46767aj.mo75323a(this.f14040c);
        c46767aj.mo75331a(this.f14038a, 0);
        this.f14041d.f3129a = (short) 3;
        C16206am c16206am = this.f14041d;
        ByteBuffer a = c46767aj.mo75324a();
        byte[] bArr = new byte[a.position()];
        System.arraycopy(a.array(), 0, bArr, 0, bArr.length);
        c16206am.f3133e = bArr;
        c46767aj = new C46767aj(0);
        c46767aj.mo75323a(this.f14040c);
        this.f14041d.mo12388a(c46767aj);
        a = c46767aj.mo75324a();
        byte[] bArr2 = new byte[a.position()];
        System.arraycopy(a.array(), 0, bArr2, 0, bArr2.length);
        int length = bArr2.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(bArr2).flip();
        byte[] array = allocate.array();
        AppMethodBeat.m2505o(98469);
        return array;
    }

    /* renamed from: a */
    public final void mo50340a(byte[] bArr) {
        AppMethodBeat.m2504i(98470);
        if (bArr.length < 4) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("decode package must include size head");
            AppMethodBeat.m2505o(98470);
            throw illegalArgumentException;
        }
        try {
            C41028ai c41028ai = new C41028ai(bArr, (byte) 0);
            c41028ai.mo65102a(this.f14040c);
            this.f14041d.mo12387a(c41028ai);
            c41028ai = new C41028ai(this.f14041d.f3133e);
            c41028ai.mo65102a(this.f14040c);
            if (f14037e == null) {
                HashMap hashMap = new HashMap();
                f14037e = hashMap;
                hashMap.put("", new byte[0]);
            }
            this.f14038a = c41028ai.mo65106a(f14037e);
            AppMethodBeat.m2505o(98470);
        } catch (Exception e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(98470);
            throw runtimeException;
        }
    }

    /* renamed from: b */
    public final <T> T mo50341b(String str, T t) {
        AppMethodBeat.m2504i(98471);
        if (this.f14038a.containsKey(str)) {
            try {
                this.f14039b.mo65108a((byte[]) this.f14038a.get(str));
                this.f14039b.mo65102a(this.f14040c);
                T a = this.f14039b.mo65104a((Object) t, 0, true);
                AppMethodBeat.m2505o(98471);
                return a;
            } catch (Exception e) {
                Exception exception = new Exception(e);
                AppMethodBeat.m2505o(98471);
                throw exception;
            }
        }
        AppMethodBeat.m2505o(98471);
        return null;
    }
}
