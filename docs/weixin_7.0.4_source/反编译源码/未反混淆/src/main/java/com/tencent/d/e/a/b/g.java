package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class g extends JceStruct {
    static Map<Integer, ArrayList<f>> Aus;
    public int AtW = 0;
    public int AtX = 0;
    public int AtY = 0;
    public int AtZ = 0;
    public long Aup = 0;
    public Map<Integer, ArrayList<f>> Auq = null;
    public int Aur = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(114586);
        jceOutputStream.write(this.Aup, 0);
        jceOutputStream.write(this.Auq, 1);
        jceOutputStream.write(this.AtW, 2);
        jceOutputStream.write(this.AtX, 3);
        jceOutputStream.write(this.AtY, 4);
        jceOutputStream.write(this.AtZ, 5);
        if (this.Aur != 0) {
            jceOutputStream.write(this.Aur, 6);
        }
        AppMethodBeat.o(114586);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(114587);
        this.Aup = jceInputStream.read(this.Aup, 0, true);
        if (Aus == null) {
            Aus = new HashMap();
            Integer valueOf = Integer.valueOf(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new f());
            Aus.put(valueOf, arrayList);
        }
        this.Auq = (Map) jceInputStream.read(Aus, 1, true);
        this.AtW = jceInputStream.read(this.AtW, 2, false);
        this.AtX = jceInputStream.read(this.AtX, 3, false);
        this.AtY = jceInputStream.read(this.AtY, 4, false);
        this.AtZ = jceInputStream.read(this.AtZ, 5, false);
        this.Aur = jceInputStream.read(this.Aur, 6, false);
        AppMethodBeat.o(114587);
    }
}
