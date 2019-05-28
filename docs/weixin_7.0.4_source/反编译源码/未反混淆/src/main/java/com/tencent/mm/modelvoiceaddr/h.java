package com.tencent.mm.modelvoiceaddr;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class h {
    String gbr;
    LinkedHashMap<String, a> gbs = new LinkedHashMap();
    final ReadWriteLock gbt = new ReentrantReadWriteLock();
    private StringBuilder gbu = new StringBuilder();

    public class a {
        public String data;
        public int gbA;
        public boolean gbB;
        public String gbv;
        public boolean gbw;
        public boolean gbx;
        public int gby;
        public int gbz;

        public a() {
            AppMethodBeat.i(116746);
            long nextInt = 4294967295L & ((long) new Random(System.currentTimeMillis()).nextInt());
            long currentTimeMillis = ((4294967295L & System.currentTimeMillis()) << 32) | nextInt;
            if (currentTimeMillis < 0) {
                currentTimeMillis = Math.abs(currentTimeMillis);
            }
            ab.i("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", Long.valueOf(nextInt), Long.toBinaryString(nextInt), Long.valueOf(r2), Long.toBinaryString(r2), Long.valueOf(currentTimeMillis), Long.toBinaryString(currentTimeMillis), h.this.gbr, h.this.gbr + String.valueOf(currentTimeMillis));
            this.gbv = r6;
            this.gbw = false;
            this.gbx = false;
            this.gby = BaseClientBuilder.API_PRIORITY_OTHER;
            this.gbz = 0;
            this.gbA = -1;
            this.data = null;
            this.gbB = false;
            AppMethodBeat.o(116746);
        }
    }

    public h(String str) {
        AppMethodBeat.i(116747);
        this.gbr = str;
        AppMethodBeat.o(116747);
    }

    public final LinkedList<bts> amx() {
        AppMethodBeat.i(116748);
        LinkedList linkedList = new LinkedList();
        this.gbt.readLock().lock();
        for (a aVar : this.gbs.values()) {
            if (aVar.gbw) {
                linkedList.add(new bts().alV(aVar.gbv));
            }
        }
        this.gbt.readLock().unlock();
        AppMethodBeat.o(116748);
        return linkedList;
    }

    public final String getResult() {
        AppMethodBeat.i(116749);
        this.gbu.setLength(0);
        this.gbt.readLock().lock();
        for (a aVar : this.gbs.values()) {
            if (aVar.data != null) {
                this.gbu.append(aVar.data);
            }
        }
        this.gbt.readLock().unlock();
        String stringBuilder = this.gbu.toString();
        AppMethodBeat.o(116749);
        return stringBuilder;
    }

    public final boolean amy() {
        AppMethodBeat.i(116750);
        this.gbt.readLock().lock();
        if (this.gbs.size() == 0) {
            ab.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
            AppMethodBeat.o(116750);
            return false;
        }
        boolean z;
        for (a aVar : this.gbs.values()) {
            ab.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", aVar.gbv, Boolean.valueOf(aVar.gbx), Boolean.valueOf(aVar.gbB));
            if (!((a) r3.next()).gbB) {
                z = false;
                break;
            }
        }
        z = true;
        this.gbt.readLock().unlock();
        AppMethodBeat.o(116750);
        return z;
    }

    public final void am(List<cod> list) {
        int i;
        String str;
        AppMethodBeat.i(116751);
        String str2 = "MicroMsg.ShortSentenceContainer";
        String str3 = "updateVoiceInfoResult respVTList size %s innerContainer %s";
        Object[] objArr = new Object[2];
        if (list == null) {
            i = 0;
        } else {
            i = list.size();
        }
        objArr[0] = Integer.valueOf(i);
        this.gbt.readLock().lock();
        if (this.gbs.size() == 0) {
            this.gbt.readLock().unlock();
            str = "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (a aVar : this.gbs.values()) {
                stringBuilder.append(aVar.gbv).append(", ");
            }
            if (stringBuilder.length() <= 3) {
                this.gbt.readLock().unlock();
                str = stringBuilder.append("]").toString();
            } else {
                stringBuilder.setLength(stringBuilder.length() - 2);
                this.gbt.readLock().unlock();
                str = stringBuilder.append("]").toString();
            }
        }
        objArr[1] = str;
        ab.d(str2, str3, objArr);
        if (list == null || list.size() == 0) {
            ab.i("MicroMsg.ShortSentenceContainer", "respList == null");
            AppMethodBeat.o(116751);
            return;
        }
        this.gbt.readLock().lock();
        for (cod cod : list) {
            if (cod == null) {
                ab.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
            } else {
                a aVar2 = (a) this.gbs.get(cod.vZx);
                if (aVar2 == null) {
                    ab.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", cod.vZx);
                } else if (cod == null) {
                    ab.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
                } else {
                    String str4 = "MicroMsg.ShortSentenceContainer";
                    String str5 = "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s";
                    Object[] objArr2 = new Object[12];
                    objArr2[0] = cod.vZx;
                    objArr2[1] = Integer.valueOf(cod.xlD);
                    Integer valueOf = (cod.xiP == null || cod.xiP.getBuffer() == null) ? null : Integer.valueOf(cod.xiP.getILen());
                    objArr2[2] = valueOf;
                    objArr2[3] = Boolean.valueOf(cod.fJT != 0);
                    objArr2[4] = Integer.valueOf(cod.fJT);
                    objArr2[5] = aVar2.gbv;
                    objArr2[6] = Boolean.valueOf(aVar2.gbw);
                    objArr2[7] = Boolean.valueOf(aVar2.gbx);
                    objArr2[8] = Integer.valueOf(aVar2.gby);
                    objArr2[9] = Integer.valueOf(aVar2.gbA);
                    if (aVar2.data == null) {
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(aVar2.data.length());
                    }
                    objArr2[10] = valueOf;
                    objArr2[11] = Boolean.valueOf(aVar2.gbB);
                    ab.d(str4, str5, objArr2);
                    if (cod.xlD < aVar2.gbA || aVar2.gbB) {
                        ab.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
                    } else {
                        boolean z;
                        int i2;
                        aVar2.gbA = cod.xlD;
                        str3 = (cod.xiP == null || cod.xiP.getBuffer() == null) ? null : cod.xiP.getBuffer().dlY();
                        aVar2.data = str3;
                        if (cod.fJT != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        aVar2.gbB = z;
                        str3 = "MicroMsg.ShortSentenceContainer";
                        str4 = "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s";
                        Object[] objArr3 = new Object[4];
                        objArr3[0] = cod.vZx;
                        objArr3[1] = Integer.valueOf(aVar2.gbA);
                        objArr3[2] = Boolean.valueOf(aVar2.gbB);
                        if (aVar2.data == null) {
                            i2 = -1;
                        } else {
                            i2 = aVar2.data.length();
                        }
                        objArr3[3] = Integer.valueOf(i2);
                        ab.i(str3, str4, objArr3);
                        if (cod.fJT == 2) {
                            ab.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", cod.vZx);
                        }
                    }
                }
            }
        }
        this.gbt.readLock().unlock();
        AppMethodBeat.o(116751);
    }

    public final void mw(int i) {
        AppMethodBeat.i(116752);
        ab.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", Integer.valueOf(i));
        IllegalStateException illegalStateException;
        if (i < 0) {
            illegalStateException = new IllegalStateException("splitShortSentence file mark less than zero. mark: ".concat(String.valueOf(i)));
            AppMethodBeat.o(116752);
            throw illegalStateException;
        }
        this.gbt.readLock().lock();
        if (this.gbs.size() == 0) {
            ab.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
            AppMethodBeat.o(116752);
            return;
        }
        a aVar = null;
        for (a aVar2 : this.gbs.values()) {
        }
        if (aVar2 == null) {
            illegalStateException = new IllegalStateException("splitShortSentence last info is null");
            AppMethodBeat.o(116752);
            throw illegalStateException;
        }
        ab.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", Integer.valueOf(aVar2.gby), aVar2.gbv, Integer.valueOf(i));
        aVar2.gby = i;
        this.gbt.readLock().unlock();
        AppMethodBeat.o(116752);
    }

    public final a mx(int i) {
        AppMethodBeat.i(116753);
        this.gbt.readLock().lock();
        if (this.gbs.size() == 0) {
            AppMethodBeat.o(116753);
            return null;
        }
        for (a aVar : this.gbs.values()) {
            ab.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", Integer.valueOf(i), Integer.valueOf(aVar.gby), Boolean.valueOf(aVar.gbx));
            if (!aVar.gbx && i <= aVar.gby) {
                break;
            }
        }
        a aVar2 = null;
        this.gbt.readLock().unlock();
        AppMethodBeat.o(116753);
        return aVar2;
    }
}
