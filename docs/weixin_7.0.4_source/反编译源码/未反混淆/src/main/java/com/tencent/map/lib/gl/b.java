package com.tencent.map.lib.gl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hi;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Hashtable;
import javax.microedition.khronos.opengles.GL10;

public class b {
    private int a;
    private hi<String> b;
    private Hashtable<String, Integer> c = new Hashtable();
    private IntBuffer d;

    public b(int i) {
        AppMethodBeat.i(98046);
        this.a = i;
        this.b = new hi(i);
        b();
        AppMethodBeat.o(98046);
    }

    private void b() {
        AppMethodBeat.i(98047);
        if (this.d == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.a * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            this.d = allocateDirect.asIntBuffer();
        }
        AppMethodBeat.o(98047);
    }

    public synchronized void a(String str, int i) {
        AppMethodBeat.i(98048);
        if (this.c.size() == this.a) {
            b();
            if (this.d == null) {
                AppMethodBeat.o(98048);
            } else {
                Integer num = (Integer) this.c.remove((String) this.b.a());
                if (this.d.position() < this.a) {
                    this.d.put(num.intValue());
                }
            }
        }
        this.b.a(str);
        this.c.put(str, Integer.valueOf(i));
        AppMethodBeat.o(98048);
    }

    public synchronized int a(String str) {
        int intValue;
        AppMethodBeat.i(98049);
        Integer num = (Integer) this.c.get(str);
        if (num != null) {
            intValue = num.intValue();
            AppMethodBeat.o(98049);
        } else {
            intValue = 0;
            AppMethodBeat.o(98049);
        }
        return intValue;
    }

    public synchronized void a(GL10 gl10) {
        AppMethodBeat.i(98050);
        if (this.d == null) {
            AppMethodBeat.o(98050);
        } else {
            int position = this.d.position();
            if (position > 0) {
                this.d.rewind();
                gl10.glDeleteTextures(position, this.d);
                this.d.clear();
            }
            AppMethodBeat.o(98050);
        }
    }

    public synchronized void a() {
        AppMethodBeat.i(98051);
        this.c.clear();
        this.b.b();
        if (this.d != null) {
            this.d.clear();
        }
        AppMethodBeat.o(98051);
    }

    public synchronized void b(GL10 gl10) {
        AppMethodBeat.i(98052);
        if (this.d != null) {
            for (String str : this.c.keySet()) {
                this.d.put(((Integer) this.c.get(str)).intValue());
            }
            a(gl10);
        }
        this.c.clear();
        this.b.b();
        AppMethodBeat.o(98052);
    }
}
