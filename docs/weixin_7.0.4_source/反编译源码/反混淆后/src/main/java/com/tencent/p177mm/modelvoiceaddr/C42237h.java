package com.tencent.p177mm.modelvoiceaddr;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cod;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.tencent.mm.modelvoiceaddr.h */
public final class C42237h {
    String gbr;
    LinkedHashMap<String, C32853a> gbs = new LinkedHashMap();
    final ReadWriteLock gbt = new ReentrantReadWriteLock();
    private StringBuilder gbu = new StringBuilder();

    /* renamed from: com.tencent.mm.modelvoiceaddr.h$a */
    public class C32853a {
        public String data;
        public int gbA;
        public boolean gbB;
        public String gbv;
        public boolean gbw;
        public boolean gbx;
        public int gby;
        public int gbz;

        public C32853a() {
            AppMethodBeat.m2504i(116746);
            long nextInt = 4294967295L & ((long) new Random(System.currentTimeMillis()).nextInt());
            long currentTimeMillis = ((4294967295L & System.currentTimeMillis()) << 32) | nextInt;
            if (currentTimeMillis < 0) {
                currentTimeMillis = Math.abs(currentTimeMillis);
            }
            C4990ab.m7417i("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", Long.valueOf(nextInt), Long.toBinaryString(nextInt), Long.valueOf(r2), Long.toBinaryString(r2), Long.valueOf(currentTimeMillis), Long.toBinaryString(currentTimeMillis), C42237h.this.gbr, C42237h.this.gbr + String.valueOf(currentTimeMillis));
            this.gbv = r6;
            this.gbw = false;
            this.gbx = false;
            this.gby = BaseClientBuilder.API_PRIORITY_OTHER;
            this.gbz = 0;
            this.gbA = -1;
            this.data = null;
            this.gbB = false;
            AppMethodBeat.m2505o(116746);
        }
    }

    public C42237h(String str) {
        AppMethodBeat.m2504i(116747);
        this.gbr = str;
        AppMethodBeat.m2505o(116747);
    }

    public final LinkedList<bts> amx() {
        AppMethodBeat.m2504i(116748);
        LinkedList linkedList = new LinkedList();
        this.gbt.readLock().lock();
        for (C32853a c32853a : this.gbs.values()) {
            if (c32853a.gbw) {
                linkedList.add(new bts().alV(c32853a.gbv));
            }
        }
        this.gbt.readLock().unlock();
        AppMethodBeat.m2505o(116748);
        return linkedList;
    }

    public final String getResult() {
        AppMethodBeat.m2504i(116749);
        this.gbu.setLength(0);
        this.gbt.readLock().lock();
        for (C32853a c32853a : this.gbs.values()) {
            if (c32853a.data != null) {
                this.gbu.append(c32853a.data);
            }
        }
        this.gbt.readLock().unlock();
        String stringBuilder = this.gbu.toString();
        AppMethodBeat.m2505o(116749);
        return stringBuilder;
    }

    public final boolean amy() {
        AppMethodBeat.m2504i(116750);
        this.gbt.readLock().lock();
        if (this.gbs.size() == 0) {
            C4990ab.m7416i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
            AppMethodBeat.m2505o(116750);
            return false;
        }
        boolean z;
        for (C32853a c32853a : this.gbs.values()) {
            C4990ab.m7411d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", c32853a.gbv, Boolean.valueOf(c32853a.gbx), Boolean.valueOf(c32853a.gbB));
            if (!((C32853a) r3.next()).gbB) {
                z = false;
                break;
            }
        }
        z = true;
        this.gbt.readLock().unlock();
        AppMethodBeat.m2505o(116750);
        return z;
    }

    /* renamed from: am */
    public final void mo67761am(List<cod> list) {
        int i;
        String str;
        AppMethodBeat.m2504i(116751);
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
            for (C32853a c32853a : this.gbs.values()) {
                stringBuilder.append(c32853a.gbv).append(", ");
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
        C4990ab.m7411d(str2, str3, objArr);
        if (list == null || list.size() == 0) {
            C4990ab.m7416i("MicroMsg.ShortSentenceContainer", "respList == null");
            AppMethodBeat.m2505o(116751);
            return;
        }
        this.gbt.readLock().lock();
        for (cod cod : list) {
            if (cod == null) {
                C4990ab.m7416i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
            } else {
                C32853a c32853a2 = (C32853a) this.gbs.get(cod.vZx);
                if (c32853a2 == null) {
                    C4990ab.m7417i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", cod.vZx);
                } else if (cod == null) {
                    C4990ab.m7410d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
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
                    objArr2[5] = c32853a2.gbv;
                    objArr2[6] = Boolean.valueOf(c32853a2.gbw);
                    objArr2[7] = Boolean.valueOf(c32853a2.gbx);
                    objArr2[8] = Integer.valueOf(c32853a2.gby);
                    objArr2[9] = Integer.valueOf(c32853a2.gbA);
                    if (c32853a2.data == null) {
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(c32853a2.data.length());
                    }
                    objArr2[10] = valueOf;
                    objArr2[11] = Boolean.valueOf(c32853a2.gbB);
                    C4990ab.m7411d(str4, str5, objArr2);
                    if (cod.xlD < c32853a2.gbA || c32853a2.gbB) {
                        C4990ab.m7410d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
                    } else {
                        boolean z;
                        int i2;
                        c32853a2.gbA = cod.xlD;
                        str3 = (cod.xiP == null || cod.xiP.getBuffer() == null) ? null : cod.xiP.getBuffer().dlY();
                        c32853a2.data = str3;
                        if (cod.fJT != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        c32853a2.gbB = z;
                        str3 = "MicroMsg.ShortSentenceContainer";
                        str4 = "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s";
                        Object[] objArr3 = new Object[4];
                        objArr3[0] = cod.vZx;
                        objArr3[1] = Integer.valueOf(c32853a2.gbA);
                        objArr3[2] = Boolean.valueOf(c32853a2.gbB);
                        if (c32853a2.data == null) {
                            i2 = -1;
                        } else {
                            i2 = c32853a2.data.length();
                        }
                        objArr3[3] = Integer.valueOf(i2);
                        C4990ab.m7417i(str3, str4, objArr3);
                        if (cod.fJT == 2) {
                            C4990ab.m7413e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", cod.vZx);
                        }
                    }
                }
            }
        }
        this.gbt.readLock().unlock();
        AppMethodBeat.m2505o(116751);
    }

    /* renamed from: mw */
    public final void mo67765mw(int i) {
        AppMethodBeat.m2504i(116752);
        C4990ab.m7417i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", Integer.valueOf(i));
        IllegalStateException illegalStateException;
        if (i < 0) {
            illegalStateException = new IllegalStateException("splitShortSentence file mark less than zero. mark: ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(116752);
            throw illegalStateException;
        }
        this.gbt.readLock().lock();
        if (this.gbs.size() == 0) {
            C4990ab.m7412e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
            AppMethodBeat.m2505o(116752);
            return;
        }
        C32853a c32853a = null;
        for (C32853a c32853a2 : this.gbs.values()) {
        }
        if (c32853a2 == null) {
            illegalStateException = new IllegalStateException("splitShortSentence last info is null");
            AppMethodBeat.m2505o(116752);
            throw illegalStateException;
        }
        C4990ab.m7411d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", Integer.valueOf(c32853a2.gby), c32853a2.gbv, Integer.valueOf(i));
        c32853a2.gby = i;
        this.gbt.readLock().unlock();
        AppMethodBeat.m2505o(116752);
    }

    /* renamed from: mx */
    public final C32853a mo67766mx(int i) {
        AppMethodBeat.m2504i(116753);
        this.gbt.readLock().lock();
        if (this.gbs.size() == 0) {
            AppMethodBeat.m2505o(116753);
            return null;
        }
        for (C32853a c32853a : this.gbs.values()) {
            C4990ab.m7411d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", Integer.valueOf(i), Integer.valueOf(c32853a.gby), Boolean.valueOf(c32853a.gbx));
            if (!c32853a.gbx && i <= c32853a.gby) {
                break;
            }
        }
        C32853a c32853a2 = null;
        this.gbt.readLock().unlock();
        AppMethodBeat.m2505o(116753);
        return c32853a2;
    }
}
