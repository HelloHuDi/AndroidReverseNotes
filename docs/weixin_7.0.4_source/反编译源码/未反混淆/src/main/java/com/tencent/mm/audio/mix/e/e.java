package com.tencent.mm.audio.mix.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.c.f;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class e {
    public static int cmY = 18432;
    private int cmQ;
    private int cmR;
    private int cmS;
    private int cmT = 0;
    private ArrayList<String> cmU = new ArrayList();
    private HashMap<String, g> cmV = new HashMap();
    private HashMap<String, byte[]> cmW = new HashMap();
    private HashMap<String, Integer> cmX = new HashMap();
    private i cmq = new d();

    public e() {
        AppMethodBeat.i(137117);
        this.cmq.init();
        AppMethodBeat.o(137117);
    }

    public final void r(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(137118);
        b.i("MicroMsg.Mix.AudioSyncMixController", "init, outSample:%d, outChannel:%d, outBitDepth:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.cmQ = i;
        this.cmR = i2;
        this.cmS = i3;
        this.cmT = i4;
        if (this.cmT <= 0) {
            this.cmT = ((((2 == i3 ? 16 : 8) * (i * i2)) * 20) / 8) / 1000;
        }
        AppMethodBeat.o(137118);
    }

    public final byte[] J(List<d> list) {
        AppMethodBeat.i(137119);
        if (list.isEmpty()) {
            AppMethodBeat.o(137119);
            return null;
        }
        Object obj;
        byte[] bArr;
        ArrayList arrayList = new ArrayList();
        if (list.size() > 1) {
            obj = 1;
        } else {
            obj = null;
        }
        for (Object obj2 : list) {
            if (obj2 == null || obj2.ckv == null || TextUtils.isEmpty(obj2.ckD)) {
                b.i("MicroMsg.Mix.AudioSyncMixController", "track or pcmData is null, or audioId is empty");
            } else {
                g gVar;
                if (this.cmV.containsKey(obj2.ckD)) {
                    gVar = (g) this.cmV.get(obj2.ckD);
                } else {
                    gVar = new f(obj2.ckD, obj2.sampleRate, obj2.channels, obj2.cku, this.cmQ, this.cmR, this.cmS);
                    this.cmV.put(obj2.ckD, gVar);
                }
                d dVar = new d();
                dVar.ckv = gVar.F(obj2.ckv);
                dVar.ckD = obj2.ckD;
                dVar.ckG = obj2.ckG;
                dVar.channels = obj2.channels;
                dVar.sampleRate = obj2.sampleRate;
                dVar.cku = obj2.cku;
                if (obj != null) {
                    byte[] bArr2 = dVar.ckv;
                    if (!(bArr2 == null || bArr2.length == 0)) {
                        Object obj3;
                        int intValue;
                        Object obj4 = null;
                        if (this.cmW.containsKey(dVar.ckD)) {
                            obj3 = (byte[]) this.cmW.get(dVar.ckD);
                            intValue = ((Integer) this.cmX.get(dVar.ckD)).intValue();
                            obj4 = obj3;
                        } else {
                            intValue = 0;
                        }
                        int length;
                        if (intValue > 0 && obj4 != null) {
                            if (bArr2.length <= cmY - intValue) {
                                System.arraycopy(bArr2, 0, obj4, intValue, bArr2.length);
                                length = bArr2.length + intValue;
                            } else {
                                System.arraycopy(bArr2, 0, obj4, intValue, cmY - intValue);
                                length = (cmY - intValue) + intValue;
                            }
                            byte[] bArr3;
                            if (length > this.cmT) {
                                length -= this.cmT;
                                bArr3 = new byte[this.cmT];
                                System.arraycopy(obj4, 0, bArr3, 0, this.cmT);
                                dVar.ckv = bArr3;
                                bArr3 = new byte[length];
                                System.arraycopy(obj4, this.cmT, bArr3, 0, length);
                                Arrays.fill(obj4, 0, cmY, (byte) 0);
                                System.arraycopy(bArr3, 0, obj4, 0, length);
                            } else {
                                bArr3 = new byte[this.cmT];
                                System.arraycopy(obj4, 0, bArr3, 0, length);
                                dVar.ckv = bArr3;
                                length = 0;
                                Arrays.fill(obj4, 0, cmY, (byte) 0);
                            }
                            this.cmX.put(dVar.ckD, Integer.valueOf(length));
                            this.cmW.put(dVar.ckD, obj4);
                        } else if (bArr2.length < this.cmT) {
                            bArr = new byte[this.cmT];
                            Arrays.fill(bArr, 0, this.cmT, (byte) 0);
                            System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
                            dVar.ckv = bArr;
                        } else if (bArr2.length > this.cmT) {
                            bArr = new byte[this.cmT];
                            Arrays.fill(bArr, 0, this.cmT, (byte) 0);
                            System.arraycopy(bArr2, 0, bArr, 0, this.cmT);
                            dVar.ckv = bArr;
                            if (obj4 == null) {
                                length = bArr2.length > cmY ? bArr2.length : cmY;
                                cmY = length;
                                bArr = new byte[length];
                            } else {
                                obj3 = obj4;
                            }
                            Arrays.fill(bArr, 0, cmY, (byte) 0);
                            System.arraycopy(bArr2, this.cmT, bArr, 0, bArr2.length - this.cmT);
                            this.cmX.put(dVar.ckD, Integer.valueOf(bArr2.length - this.cmT));
                            this.cmW.put(dVar.ckD, bArr);
                        }
                    }
                }
                if (dVar.ckv.equals(obj2.ckv)) {
                    bArr = new byte[dVar.ckv.length];
                    System.arraycopy(dVar.ckv, 0, bArr, 0, dVar.ckv.length);
                    dVar.ckv = bArr;
                }
                d obj22 = dVar;
            }
            arrayList.add(obj22);
        }
        bArr = K(arrayList);
        AppMethodBeat.o(137119);
        return bArr;
    }

    public final void release() {
        AppMethodBeat.i(137121);
        b.i("MicroMsg.Mix.AudioSyncMixController", "release, ids size:%d", Integer.valueOf(this.cmU.size()));
        Iterator it = this.cmU.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.cmV.containsKey(str)) {
                g gVar = (g) this.cmV.remove(str);
                if (gVar != null) {
                    gVar.release();
                }
            }
            this.cmW.remove(str);
            this.cmX.remove(str);
        }
        this.cmV.clear();
        this.cmW.clear();
        this.cmX.clear();
        this.cmU.clear();
        if (this.cmq != null) {
            this.cmq = null;
        }
        AppMethodBeat.o(137121);
    }

    private byte[] K(List<d> list) {
        AppMethodBeat.i(137122);
        byte[] bArr;
        if (list.isEmpty()) {
            b.i("MicroMsg.Mix.AudioSyncMixController", "list is invalid");
            AppMethodBeat.o(137122);
            return null;
        } else if (list.size() == 1) {
            bArr = ((d) list.get(0)).ckv;
            AppMethodBeat.o(137122);
            return bArr;
        } else if (this.cmq == null) {
            b.i("MicroMsg.Mix.AudioSyncMixController", "mixer is null");
            AppMethodBeat.o(137122);
            return null;
        } else {
            com.tencent.mm.audio.mix.a.b I = this.cmq.I(list);
            if (I != null) {
                bArr = I.ckv;
                AppMethodBeat.o(137122);
                return bArr;
            }
            AppMethodBeat.o(137122);
            return null;
        }
    }

    public final byte[] Ec() {
        AppMethodBeat.i(137120);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.cmU.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.cmW.containsKey(str)) {
                byte[] bArr = (byte[]) this.cmW.get(str);
                int intValue = ((Integer) this.cmX.get(str)).intValue();
                d dVar = new d();
                byte[] bArr2 = new byte[this.cmT];
                if (intValue > 0 && intValue <= this.cmT) {
                    System.arraycopy(bArr, 0, bArr2, 0, intValue);
                } else if (bArr != null) {
                    System.arraycopy(bArr, 0, bArr2, 0, this.cmT);
                }
                dVar.ckv = bArr2;
                arrayList.add(dVar);
                this.cmX.put(str, Integer.valueOf(0));
                Arrays.fill(bArr, 0, cmY, (byte) 0);
                this.cmW.put(str, bArr);
            }
        }
        byte[] K = K(arrayList);
        AppMethodBeat.o(137120);
        return K;
    }
}
