package com.tencent.map.lib.p822gl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44520hi;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Hashtable;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.map.lib.gl.b */
public class C17851b {
    /* renamed from: a */
    private int f4294a;
    /* renamed from: b */
    private C44520hi<String> f4295b;
    /* renamed from: c */
    private Hashtable<String, Integer> f4296c = new Hashtable();
    /* renamed from: d */
    private IntBuffer f4297d;

    public C17851b(int i) {
        AppMethodBeat.m2504i(98046);
        this.f4294a = i;
        this.f4295b = new C44520hi(i);
        m27937b();
        AppMethodBeat.m2505o(98046);
    }

    /* renamed from: b */
    private void m27937b() {
        AppMethodBeat.m2504i(98047);
        if (this.f4297d == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f4294a * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            this.f4297d = allocateDirect.asIntBuffer();
        }
        AppMethodBeat.m2505o(98047);
    }

    /* renamed from: a */
    public synchronized void mo33214a(String str, int i) {
        AppMethodBeat.m2504i(98048);
        if (this.f4296c.size() == this.f4294a) {
            m27937b();
            if (this.f4297d == null) {
                AppMethodBeat.m2505o(98048);
            } else {
                Integer num = (Integer) this.f4296c.remove((String) this.f4295b.mo70900a());
                if (this.f4297d.position() < this.f4294a) {
                    this.f4297d.put(num.intValue());
                }
            }
        }
        this.f4295b.mo70901a(str);
        this.f4296c.put(str, Integer.valueOf(i));
        AppMethodBeat.m2505o(98048);
    }

    /* renamed from: a */
    public synchronized int mo33212a(String str) {
        int intValue;
        AppMethodBeat.m2504i(98049);
        Integer num = (Integer) this.f4296c.get(str);
        if (num != null) {
            intValue = num.intValue();
            AppMethodBeat.m2505o(98049);
        } else {
            intValue = 0;
            AppMethodBeat.m2505o(98049);
        }
        return intValue;
    }

    /* renamed from: a */
    public synchronized void mo33215a(GL10 gl10) {
        AppMethodBeat.m2504i(98050);
        if (this.f4297d == null) {
            AppMethodBeat.m2505o(98050);
        } else {
            int position = this.f4297d.position();
            if (position > 0) {
                this.f4297d.rewind();
                gl10.glDeleteTextures(position, this.f4297d);
                this.f4297d.clear();
            }
            AppMethodBeat.m2505o(98050);
        }
    }

    /* renamed from: a */
    public synchronized void mo33213a() {
        AppMethodBeat.m2504i(98051);
        this.f4296c.clear();
        this.f4295b.mo70902b();
        if (this.f4297d != null) {
            this.f4297d.clear();
        }
        AppMethodBeat.m2505o(98051);
    }

    /* renamed from: b */
    public synchronized void mo33216b(GL10 gl10) {
        AppMethodBeat.m2504i(98052);
        if (this.f4297d != null) {
            for (String str : this.f4296c.keySet()) {
                this.f4297d.put(((Integer) this.f4296c.get(str)).intValue());
            }
            mo33215a(gl10);
        }
        this.f4296c.clear();
        this.f4295b.mo70902b();
        AppMethodBeat.m2505o(98052);
    }
}
