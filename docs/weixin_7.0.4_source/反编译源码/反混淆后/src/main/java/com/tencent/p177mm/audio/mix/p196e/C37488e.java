package com.tencent.p177mm.audio.mix.p196e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1183c.C17956g;
import com.tencent.p177mm.audio.mix.p1183c.C25026f;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C25836b;
import com.tencent.p177mm.audio.mix.p830a.C45164d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.audio.mix.e.e */
public final class C37488e {
    public static int cmY = 18432;
    private int cmQ;
    private int cmR;
    private int cmS;
    private int cmT = 0;
    private ArrayList<String> cmU = new ArrayList();
    private HashMap<String, C17956g> cmV = new HashMap();
    private HashMap<String, byte[]> cmW = new HashMap();
    private HashMap<String, Integer> cmX = new HashMap();
    private C25842i cmq = new C45168d();

    public C37488e() {
        AppMethodBeat.m2504i(137117);
        this.cmq.init();
        AppMethodBeat.m2505o(137117);
    }

    /* renamed from: r */
    public final void mo60418r(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(137118);
        C45174b.m83210i("MicroMsg.Mix.AudioSyncMixController", "init, outSample:%d, outChannel:%d, outBitDepth:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.cmQ = i;
        this.cmR = i2;
        this.cmS = i3;
        this.cmT = i4;
        if (this.cmT <= 0) {
            this.cmT = ((((2 == i3 ? 16 : 8) * (i * i2)) * 20) / 8) / 1000;
        }
        AppMethodBeat.m2505o(137118);
    }

    /* renamed from: J */
    public final byte[] mo60417J(List<C45164d> list) {
        AppMethodBeat.m2504i(137119);
        if (list.isEmpty()) {
            AppMethodBeat.m2505o(137119);
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
                C45174b.m83209i("MicroMsg.Mix.AudioSyncMixController", "track or pcmData is null, or audioId is empty");
            } else {
                C17956g c17956g;
                if (this.cmV.containsKey(obj2.ckD)) {
                    c17956g = (C17956g) this.cmV.get(obj2.ckD);
                } else {
                    c17956g = new C25026f(obj2.ckD, obj2.sampleRate, obj2.channels, obj2.cku, this.cmQ, this.cmR, this.cmS);
                    this.cmV.put(obj2.ckD, c17956g);
                }
                C45164d c45164d = new C45164d();
                c45164d.ckv = c17956g.mo33489F(obj2.ckv);
                c45164d.ckD = obj2.ckD;
                c45164d.ckG = obj2.ckG;
                c45164d.channels = obj2.channels;
                c45164d.sampleRate = obj2.sampleRate;
                c45164d.cku = obj2.cku;
                if (obj != null) {
                    byte[] bArr2 = c45164d.ckv;
                    if (!(bArr2 == null || bArr2.length == 0)) {
                        Object obj3;
                        int intValue;
                        Object obj4 = null;
                        if (this.cmW.containsKey(c45164d.ckD)) {
                            obj3 = (byte[]) this.cmW.get(c45164d.ckD);
                            intValue = ((Integer) this.cmX.get(c45164d.ckD)).intValue();
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
                                c45164d.ckv = bArr3;
                                bArr3 = new byte[length];
                                System.arraycopy(obj4, this.cmT, bArr3, 0, length);
                                Arrays.fill(obj4, 0, cmY, (byte) 0);
                                System.arraycopy(bArr3, 0, obj4, 0, length);
                            } else {
                                bArr3 = new byte[this.cmT];
                                System.arraycopy(obj4, 0, bArr3, 0, length);
                                c45164d.ckv = bArr3;
                                length = 0;
                                Arrays.fill(obj4, 0, cmY, (byte) 0);
                            }
                            this.cmX.put(c45164d.ckD, Integer.valueOf(length));
                            this.cmW.put(c45164d.ckD, obj4);
                        } else if (bArr2.length < this.cmT) {
                            bArr = new byte[this.cmT];
                            Arrays.fill(bArr, 0, this.cmT, (byte) 0);
                            System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
                            c45164d.ckv = bArr;
                        } else if (bArr2.length > this.cmT) {
                            bArr = new byte[this.cmT];
                            Arrays.fill(bArr, 0, this.cmT, (byte) 0);
                            System.arraycopy(bArr2, 0, bArr, 0, this.cmT);
                            c45164d.ckv = bArr;
                            if (obj4 == null) {
                                length = bArr2.length > cmY ? bArr2.length : cmY;
                                cmY = length;
                                bArr = new byte[length];
                            } else {
                                obj3 = obj4;
                            }
                            Arrays.fill(bArr, 0, cmY, (byte) 0);
                            System.arraycopy(bArr2, this.cmT, bArr, 0, bArr2.length - this.cmT);
                            this.cmX.put(c45164d.ckD, Integer.valueOf(bArr2.length - this.cmT));
                            this.cmW.put(c45164d.ckD, bArr);
                        }
                    }
                }
                if (c45164d.ckv.equals(obj2.ckv)) {
                    bArr = new byte[c45164d.ckv.length];
                    System.arraycopy(c45164d.ckv, 0, bArr, 0, c45164d.ckv.length);
                    c45164d.ckv = bArr;
                }
                C45164d obj22 = c45164d;
            }
            arrayList.add(obj22);
        }
        bArr = m63268K(arrayList);
        AppMethodBeat.m2505o(137119);
        return bArr;
    }

    public final void release() {
        AppMethodBeat.m2504i(137121);
        C45174b.m83210i("MicroMsg.Mix.AudioSyncMixController", "release, ids size:%d", Integer.valueOf(this.cmU.size()));
        Iterator it = this.cmU.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.cmV.containsKey(str)) {
                C17956g c17956g = (C17956g) this.cmV.remove(str);
                if (c17956g != null) {
                    c17956g.release();
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
        AppMethodBeat.m2505o(137121);
    }

    /* renamed from: K */
    private byte[] m63268K(List<C45164d> list) {
        AppMethodBeat.m2504i(137122);
        byte[] bArr;
        if (list.isEmpty()) {
            C45174b.m83209i("MicroMsg.Mix.AudioSyncMixController", "list is invalid");
            AppMethodBeat.m2505o(137122);
            return null;
        } else if (list.size() == 1) {
            bArr = ((C45164d) list.get(0)).ckv;
            AppMethodBeat.m2505o(137122);
            return bArr;
        } else if (this.cmq == null) {
            C45174b.m83209i("MicroMsg.Mix.AudioSyncMixController", "mixer is null");
            AppMethodBeat.m2505o(137122);
            return null;
        } else {
            C25836b I = this.cmq.mo43832I(list);
            if (I != null) {
                bArr = I.ckv;
                AppMethodBeat.m2505o(137122);
                return bArr;
            }
            AppMethodBeat.m2505o(137122);
            return null;
        }
    }

    /* renamed from: Ec */
    public final byte[] mo60416Ec() {
        AppMethodBeat.m2504i(137120);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.cmU.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.cmW.containsKey(str)) {
                byte[] bArr = (byte[]) this.cmW.get(str);
                int intValue = ((Integer) this.cmX.get(str)).intValue();
                C45164d c45164d = new C45164d();
                byte[] bArr2 = new byte[this.cmT];
                if (intValue > 0 && intValue <= this.cmT) {
                    System.arraycopy(bArr, 0, bArr2, 0, intValue);
                } else if (bArr != null) {
                    System.arraycopy(bArr, 0, bArr2, 0, this.cmT);
                }
                c45164d.ckv = bArr2;
                arrayList.add(c45164d);
                this.cmX.put(str, Integer.valueOf(0));
                Arrays.fill(bArr, 0, cmY, (byte) 0);
                this.cmW.put(str, bArr);
            }
        }
        byte[] K = m63268K(arrayList);
        AppMethodBeat.m2505o(137120);
        return K;
    }
}
