package com.tencent.mm.hardcoder;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI.HCPerfManagerThread;
import com.tencent.mm.loader.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public final class a {
    public static boolean eDw = false;
    private static final int[] eDx = new int[]{0, 1, 2, 3};
    private static final int[] eDy = new int[]{0, 1, 2, 3};
    private Thread eDA;
    HCPerfManagerThread eDB;
    LinkedBlockingQueue<Object> eDC = new LinkedBlockingQueue();
    private b eDz;

    class a implements Runnable {
        private boolean running;

        private a() {
            this.running = false;
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(93950);
            c.i("HardCoder.HCPerfManager", String.format("HCPerfManager thread run start, id:%d, name:%s", new Object[]{Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName()}));
            this.running = true;
            HashSet hashSet = new HashSet();
            long j = 30000;
            ArrayList arrayList = new ArrayList();
            long[] PF = g.PF();
            if (PF == null || PF.length < 2) {
                PF = new long[]{0, 0};
                c.i("HardCoder.HardCoderReporter", "process jiffes info is invalid");
            }
            c.i("HardCoder.HardCoderReporter", "process:[" + PF[0] + "," + PF[1] + "]");
            HashMap hashMap = new HashMap();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = hashSet;
            b bVar = null;
            b bVar2 = null;
            b bVar3 = null;
            while (this.running) {
                int i;
                b bVar4;
                int i2;
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                int size = a.this.eDC.size();
                c.d("HardCoder.HCPerfManager", "startLoop queue:" + size + " startTask:" + arrayList.size() + " nextWakeInterval:" + j);
                int i3 = 0;
                while (true) {
                    if (i3 >= (size == 0 ? 1 : size)) {
                        break;
                    }
                    Object poll;
                    try {
                        poll = a.this.eDC.poll(j, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        c.e("HardCoder.HCPerfManager", "taskQueue poll: " + e.getMessage());
                        poll = null;
                    }
                    if (poll == null) {
                        break;
                    }
                    if (!(poll instanceof b)) {
                        if (!(poll instanceof c)) {
                            if (!HardCoderJNI.isCheckEnv()) {
                                this.running = false;
                                break;
                            }
                            Assert.fail("taskQueue poll invalid object");
                        } else {
                            i = ((c) poll).aBR;
                            if (hashSet2.contains(Integer.valueOf(i))) {
                                hashMap.put(Integer.valueOf(i), (c) poll);
                            }
                        }
                    } else {
                        arrayList.add((b) poll);
                        hashSet2.add(Integer.valueOf(((b) poll).hashCode()));
                    }
                    i3++;
                }
                long j2 = 30000;
                b bVar5 = null;
                b bVar6 = null;
                b bVar7 = null;
                HashSet hashSet4 = new HashSet();
                long currentTimeMillis2 = System.currentTimeMillis();
                c.d("HardCoder.HCPerfManager", "InLoop startSize:" + arrayList.size());
                i = 0;
                while (true) {
                    int i4 = i;
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    bVar4 = (b) arrayList.get(i4);
                    j = System.currentTimeMillis();
                    if (bVar4 != null) {
                        if (hashMap.containsKey(Integer.valueOf(bVar4.hashCode()))) {
                            bVar4.eDL = j;
                            bVar4.eDE = ((c) hashMap.get(Integer.valueOf(bVar4.hashCode()))).eDE;
                            hashMap.remove(Integer.valueOf(bVar4.hashCode()));
                            a.a(a.this, j, arrayList, -2, -2, -2, null);
                            a.a(a.this, bVar4);
                        }
                        long j3 = bVar4.eDL - j;
                        if (j3 <= 0) {
                            c.d("HardCoder.HCPerfManager", "InLoop STOP:" + i4 + "/" + arrayList.size() + " task:" + bVar4.toString(j));
                            arrayList.remove(bVar4);
                            hashSet2.remove(Integer.valueOf(bVar4.hashCode()));
                            i4--;
                        } else {
                            j2 = Math.min(j2, j3);
                            j3 = bVar4.startTime - j;
                            if (j3 > 0) {
                                c.d("HardCoder.HCPerfManager", "InLoop WAIT:" + i4 + "/" + arrayList.size() + " task:" + bVar4.toString(j));
                                j2 = Math.min(j2, j3);
                            } else {
                                c.d("HardCoder.HCPerfManager", "InLoop RUN:" + i4 + "/" + arrayList.size() + " task:" + bVar4.toString(j));
                                if (bVar4.eDF > 0 && (bVar5 == null || bVar5.eDF > bVar4.eDF || (bVar5.eDF == bVar4.eDF && bVar5.eDL < bVar4.eDL))) {
                                    bVar5 = bVar4;
                                }
                                if (bVar4.eDG > 0 && (bVar6 == null || bVar6.eDG > bVar4.eDG || (bVar6.eDG == bVar4.eDG && bVar6.eDL < bVar4.eDL))) {
                                    bVar6 = bVar4;
                                }
                                if (bVar4.eDH > 0 && (bVar7 == null || bVar7.eDH > bVar4.eDH || (bVar7.eDH == bVar4.eDH && bVar7.eDL < bVar4.eDL))) {
                                    bVar7 = bVar4;
                                }
                                for (int size2 : bVar4.eDI) {
                                    if (size2 > 0) {
                                        hashSet4.add(bVar4);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    i = i4 + 1;
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                c.d("HardCoder.HCPerfManager", String.format("EndLoop time:[%d,%d] list:%d stop:%d bindCore:%d -> %d", new Object[]{Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis), Integer.valueOf(arrayList.size()), Integer.valueOf(hashMap.size()), Integer.valueOf(hashSet3.size()), Integer.valueOf(hashSet4.size())}));
                String str2 = "HardCoder.HCPerfManager";
                StringBuilder append = new StringBuilder("EndLoop CurrCpu:").append(bVar3 == null ? BuildConfig.COMMAND : bVar3.toString(currentTimeMillis2)).append(" -> MaxCpu:");
                if (bVar5 == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = bVar5.toString(currentTimeMillis2);
                }
                c.d(str2, append.append(str).toString());
                str2 = "HardCoder.HCPerfManager";
                append = new StringBuilder("EndLoop CurrGpu:").append(bVar2 == null ? BuildConfig.COMMAND : bVar2.toString(currentTimeMillis2)).append(" -> MaxGpu:");
                if (bVar2 == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = bVar2.toString(currentTimeMillis2);
                }
                c.d(str2, append.append(str).toString());
                str2 = "HardCoder.HCPerfManager";
                append = new StringBuilder("EndLoop CurrIO:").append(bVar == null ? BuildConfig.COMMAND : bVar.toString(currentTimeMillis2)).append(" -> MaxIO:");
                if (bVar7 == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = bVar7.toString(currentTimeMillis2);
                }
                c.d(str2, append.append(str).toString());
                c.d("HardCoder.HCPerfManager", String.format("EndLoop BindCore.size cur: %d, need: %d", new Object[]{Integer.valueOf(hashSet3.size()), Integer.valueOf(hashSet4.size())}));
                HashSet hashSet5 = new HashSet();
                hashSet5.addAll(hashSet3);
                hashSet5.removeAll(hashSet4);
                if (bVar5 == bVar3 && bVar6 == bVar2 && bVar7 == bVar && hashSet3.size() == hashSet4.size() && hashSet5.isEmpty()) {
                    c.d("HardCoder.HCPerfManager", "EndLoop Nothing Changed, Continue.");
                    j = j2;
                } else {
                    int i5;
                    int i6;
                    int min;
                    int i7;
                    int i8;
                    boolean z;
                    i = 0;
                    Iterator it = hashSet5.iterator();
                    while (true) {
                        i2 = i;
                        if (!it.hasNext()) {
                            break;
                        }
                        bVar4 = (b) it.next();
                        if (bVar4.eDI != null) {
                            i = bVar4.eDI.length + i2;
                        } else {
                            i = i2;
                        }
                    }
                    if (i2 > 0) {
                        int[] iArr = new int[i2];
                        Iterator it2 = hashSet5.iterator();
                        i2 = 0;
                        while (it2.hasNext()) {
                            bVar4 = (b) it2.next();
                            long currentTimeMillis4 = System.currentTimeMillis();
                            c.i("HardCoder.HCPerfManager", "!cancelBindCore task:" + bVar4.toString(currentTimeMillis4));
                            if (bVar4.eDL > currentTimeMillis4) {
                                c.e("HardCoder.HCPerfManager", "stopTime:" + (bVar4.eDL - currentTimeMillis4) + ". Error !");
                            } else {
                                if (!bVar4.PD()) {
                                    if (!HardCoderJNI.isCheckEnv()) {
                                        this.running = false;
                                        break;
                                    }
                                    Assert.fail("bindTids:" + bVar4.PE());
                                }
                                i = i2;
                                for (int i22 : bVar4.eDI) {
                                    iArr[i] = i22;
                                    i++;
                                }
                                i22 = i;
                            }
                        }
                        if (!a.eDw && HardCoderJNI.isCheckEnv()) {
                            HardCoderJNI.cancelCpuCoreForThread(iArr, Process.myTid(), SystemClock.elapsedRealtimeNanos());
                        }
                        a.a(a.this, currentTimeMillis2, arrayList, -2, -2, -2, null);
                    }
                    i = 0;
                    it = hashSet4.iterator();
                    while (true) {
                        i22 = i;
                        if (!it.hasNext()) {
                            break;
                        }
                        bVar4 = (b) it.next();
                        if (bVar4.eDI != null) {
                            i = bVar4.eDI.length + i22;
                        } else {
                            i = i22;
                        }
                    }
                    int[] iArr2 = new int[i22];
                    Iterator it3 = hashSet4.iterator();
                    i22 = 0;
                    j = 0;
                    size2 = 0;
                    i3 = BaseClientBuilder.API_PRIORITY_OTHER;
                    int i9 = 0;
                    while (it3.hasNext()) {
                        bVar4 = (b) it3.next();
                        c.i("HardCoder.HCPerfManager", "requestBindCore task:" + bVar4.toString(currentTimeMillis2));
                        currentTimeMillis = System.currentTimeMillis();
                        if (bVar4.eDL <= currentTimeMillis) {
                            c.e("HardCoder.HCPerfManager", "stopTime:" + (bVar4.eDL - currentTimeMillis) + ". Error !");
                        } else {
                            if (!bVar4.PD()) {
                                if (!HardCoderJNI.isCheckEnv()) {
                                    this.running = false;
                                    break;
                                }
                                Assert.fail("bindTids:" + bVar4.PE());
                            }
                            for (int i52 : bVar4.eDI) {
                                iArr2[i22] = i52;
                                i22++;
                            }
                            size2 = bVar4.scene;
                            j = bVar4.eDJ;
                            i52 = bVar4.eDM;
                            i3 = Math.min((int) (bVar4.eDL - currentTimeMillis2), i3);
                            i9 = i52;
                        }
                    }
                    if (bVar7 == null) {
                        if (bVar != null) {
                            c.i("HardCoder.HCPerfManager", "!cancelHighIOFreq task:" + bVar.toString(currentTimeMillis2));
                            if (!a.eDw && HardCoderJNI.isCheckEnv()) {
                                HardCoderJNI.cancelHighIOFreq(bVar.eDM, SystemClock.elapsedRealtimeNanos());
                            }
                            a.a(a.this, currentTimeMillis2, arrayList, -2, -2, -1, null);
                        }
                    } else if (bVar != bVar7) {
                        str2 = "HardCoder.HCPerfManager";
                        StringBuilder stringBuilder = new StringBuilder("IOReq:");
                        if (bVar == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = bVar.toString(currentTimeMillis2);
                        }
                        c.d(str2, stringBuilder.append(str).append(" -> ").append(bVar7.toString(currentTimeMillis2)).append(" delay:").append(currentTimeMillis3 - bVar7.startTime).toString());
                    }
                    if (bVar7 != null) {
                        i52 = bVar7.eDH;
                        i22 = bVar7.scene;
                        j = bVar7.eDJ;
                        i6 = bVar7.eDM;
                        min = Math.min((int) (bVar7.eDL - currentTimeMillis2), i3);
                    } else {
                        i22 = size2;
                        i52 = 0;
                        min = i3;
                        i6 = i9;
                    }
                    if (bVar6 == null) {
                        if (bVar2 != null) {
                            c.i("HardCoder.HCPerfManager", "!cancelGpuHighFreq task:" + bVar2.toString(currentTimeMillis2));
                            if (!a.eDw && HardCoderJNI.isCheckEnv()) {
                                HardCoderJNI.cancelGpuHighFreq(bVar2.eDM, SystemClock.elapsedRealtimeNanos());
                            }
                            a.a(a.this, currentTimeMillis2, arrayList, -2, -1, -2, null);
                        }
                    } else if (bVar2 != bVar6) {
                        String str3 = "HardCoder.HCPerfManager";
                        StringBuilder stringBuilder2 = new StringBuilder("GPUReq:");
                        if (bVar2 == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = bVar2.toString(currentTimeMillis2);
                        }
                        c.d(str3, stringBuilder2.append(str).append(" -> ").append(bVar6.toString(currentTimeMillis2)).append(" delay:").append(currentTimeMillis3 - bVar6.startTime).toString());
                    }
                    if (bVar6 != null) {
                        i3 = bVar6.eDG;
                        size2 = bVar6.scene;
                        long j4 = bVar6.eDJ;
                        i7 = bVar6.eDM;
                        i9 = Math.min((int) (bVar6.eDL - currentTimeMillis2), min);
                        j = j4;
                        i8 = size2;
                        i6 = i7;
                    } else {
                        i8 = i22;
                        i3 = 0;
                        i9 = min;
                    }
                    if (bVar5 == null) {
                        if (bVar3 != null) {
                            c.i("HardCoder.HCPerfManager", "!cancelCpuHighFreq task:" + bVar3.toString(currentTimeMillis2));
                            if (!a.eDw && HardCoderJNI.isCheckEnv()) {
                                HardCoderJNI.cancelCpuHighFreq(bVar3.eDM, SystemClock.elapsedRealtimeNanos());
                            }
                            a.a(a.this, currentTimeMillis2, arrayList, -1, -2, -2, null);
                        }
                    } else if (bVar3 != bVar5) {
                        str2 = "HardCoder.HCPerfManager";
                        StringBuilder stringBuilder3 = new StringBuilder("CPUReq:");
                        if (bVar3 == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = bVar3.toString(currentTimeMillis2);
                        }
                        c.d(str2, stringBuilder3.append(str).append(" -> ").append(bVar5.toString(currentTimeMillis2)).append(" delay:").append(currentTimeMillis3 - bVar5.startTime).toString());
                    }
                    if (bVar5 != null) {
                        size2 = bVar5.eDF;
                        i22 = bVar5.scene;
                        j = bVar5.eDJ;
                        i7 = bVar5.eDM;
                        i9 = Math.min((int) (bVar5.eDL - currentTimeMillis2), i9);
                    } else {
                        i22 = i8;
                        size2 = 0;
                        i7 = i6;
                    }
                    if (i9 < BaseClientBuilder.API_PRIORITY_OTHER) {
                        String str4 = "HardCoder.HCPerfManager";
                        String str5 = "!UnifyRequest [%d,%d,%d] [%d,%d,%d,%d] TO:%d max CPU:%s GPU:%s IO:%s cur CPU:%s GPU:%s IO:%s";
                        Integer[] numArr = new Object[14];
                        numArr[0] = Integer.valueOf(i22);
                        numArr[1] = Long.valueOf(j);
                        numArr[2] = Integer.valueOf(i7);
                        numArr[3] = Integer.valueOf(size2);
                        numArr[4] = Integer.valueOf(i3);
                        numArr[5] = Integer.valueOf(i52);
                        numArr[6] = Integer.valueOf(iArr2.length);
                        numArr[7] = Integer.valueOf(i9);
                        if (bVar5 == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = bVar5.toString(currentTimeMillis2);
                        }
                        numArr[8] = str;
                        numArr[9] = bVar6 == null ? BuildConfig.COMMAND : bVar6.toString(currentTimeMillis2);
                        numArr[10] = bVar7 == null ? BuildConfig.COMMAND : bVar7.toString(currentTimeMillis2);
                        if (bVar5 == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = bVar5.toString(currentTimeMillis2);
                        }
                        numArr[11] = str;
                        numArr[12] = bVar6 == null ? BuildConfig.COMMAND : bVar6.toString(currentTimeMillis2);
                        numArr[13] = bVar7 == null ? BuildConfig.COMMAND : bVar7.toString(currentTimeMillis2);
                        c.i(str4, String.format(str5, numArr));
                        Assert.assertTrue(i9 > 0);
                        z = i22 > 0 || j > 0;
                        Assert.assertTrue(z);
                        Assert.assertTrue(i7 > 0);
                        z = size2 > 0 || i3 > 0 || i52 > 0 || iArr2.length > 0;
                        Assert.assertTrue(z);
                        if (!a.eDw && HardCoderJNI.isCheckEnv()) {
                            HardCoderJNI.requestUnifyCpuIOThreadCoreGpu(i22, j, size2, i3, i52, iArr2, i9, i7, SystemClock.elapsedRealtimeNanos());
                            String str6 = "HardCoder.HCPerfManager";
                            str4 = "hardcoder requestUnifyCpuIOThreadCoreGpu reqScene[%d, %d] running[j %b, c %b]";
                            Object[] objArr = new Object[4];
                            objArr[0] = Integer.valueOf(i22);
                            objArr[1] = Long.valueOf(j);
                            objArr[2] = Boolean.valueOf(HardCoderJNI.isHcEnable());
                            z = HardCoderJNI.isCheckEnv() && HardCoderJNI.isRunning() > 0;
                            objArr[3] = Boolean.valueOf(z);
                            c.i(str6, String.format(str4, objArr));
                            if (HardCoderJNI.sceneReportCallback != null) {
                                HardCoderJNI.sceneReportCallback.sceneReport(i22, j);
                            }
                        }
                        a.a(a.this, currentTimeMillis2, arrayList, size2, i3, i52, iArr2);
                    }
                    if (a.eDw) {
                        Assert.assertTrue(bVar5 == bVar5);
                        Assert.assertTrue(bVar7 == bVar7);
                        if (arrayList.isEmpty()) {
                            Assert.assertTrue(j2 == 30000);
                            Assert.assertTrue(i9 == BaseClientBuilder.API_PRIORITY_OTHER);
                            Assert.assertTrue(hashSet4.isEmpty());
                            Assert.assertTrue(bVar5 == null);
                            Assert.assertTrue(bVar6 == null);
                            Assert.assertTrue(bVar7 == null);
                        }
                        i = 0;
                        while (true) {
                            i22 = i;
                            if (i22 >= arrayList.size()) {
                                break;
                            }
                            bVar4 = (b) arrayList.get(i22);
                            c.d("HardCoder.HCPerfManager", "CheckTask:" + i22 + "/" + arrayList.size() + " task:" + bVar4.toString(currentTimeMillis2));
                            boolean z2 = bVar4.eDF > 0 || bVar4.eDG > 0 || bVar4.eDH > 0 || bVar4.PD();
                            Assert.assertTrue(z2);
                            z2 = bVar4.eDJ > 0 || bVar4.scene > 0;
                            Assert.assertTrue(z2);
                            Assert.assertTrue("taskInintTime:" + (bVar4.eDK - currentTimeMillis2), bVar4.eDK <= currentTimeMillis2);
                            Assert.assertTrue("taskStopTime:" + (bVar4.eDL - currentTimeMillis2), bVar4.eDL >= currentTimeMillis2);
                            Assert.assertTrue("taskHash:" + bVar4.hashCode(), !hashMap.containsKey(Integer.valueOf(bVar4.hashCode())));
                            if (bVar4.startTime > currentTimeMillis2) {
                                Assert.assertTrue(bVar4 != bVar5);
                                Assert.assertTrue(bVar4 != bVar6);
                                Assert.assertTrue(bVar4 != bVar7);
                                Assert.assertTrue(!hashSet4.contains(bVar4));
                                String str7 = "next:" + j2 + " start:" + (bVar4.startTime - currentTimeMillis2);
                                if (j2 <= bVar4.startTime - currentTimeMillis2) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                Assert.assertTrue(str7, z);
                            } else {
                                Assert.assertTrue("nextWake:" + j2 + " stop:" + (bVar4.eDL - currentTimeMillis2), j2 <= bVar4.eDL - currentTimeMillis2);
                                String concat = "reqTimeStamp:".concat(String.valueOf(i9));
                                z2 = i9 > 0 && i9 < BaseClientBuilder.API_PRIORITY_OTHER;
                                Assert.assertTrue(concat, z2);
                                Assert.assertTrue("reqTimeStamp:" + i9 + " stop:" + (bVar4.eDL - currentTimeMillis2), ((long) i9) <= bVar4.eDL - currentTimeMillis2);
                                Assert.assertTrue("reqCpu:" + size2 + " task:" + bVar4.eDF, size2 <= bVar4.eDF);
                                Assert.assertTrue("reqCpu:" + i3 + " task:" + bVar4.eDG, i3 <= bVar4.eDG);
                                Assert.assertTrue("reqIO:" + i52 + " task:" + bVar4.eDH, i52 <= bVar4.eDH);
                                if (bVar4.PD()) {
                                    Assert.assertTrue(hashSet4.contains(bVar4));
                                    if (hashSet5.contains(bVar4)) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    Assert.assertTrue(z);
                                }
                            }
                            i = i22 + 1;
                        }
                        j = j2;
                        hashSet3 = hashSet4;
                        bVar = bVar7;
                        bVar2 = bVar6;
                        bVar3 = bVar5;
                    } else {
                        j = j2;
                        hashSet3 = hashSet4;
                        bVar = bVar7;
                        bVar2 = bVar6;
                        bVar3 = bVar5;
                    }
                }
            }
            c.i("HardCoder.HCPerfManager", "HCPerfManager thread run end");
            AppMethodBeat.o(93950);
        }
    }

    public static class b {
        public int azs = 0;
        public int delay = 0;
        public long eDE = 0;
        public int eDF = 0;
        public int eDG = 0;
        public int eDH = 0;
        public int[] eDI = null;
        public long eDJ = 0;
        public long eDK = 0;
        public long eDL = 0;
        public int eDM = 0;
        public int eDN = 0;
        public int eDO = 0;
        public int[] eDP = new int[a.eDx.length];
        public int[] eDQ = new int[a.eDy.length];
        public int[] eDR = null;
        public long[] eDS = null;
        public long[] eDT = null;
        public long eDU = 0;
        public int eDV = 0;
        public long eDW = 0;
        public com.tencent.mm.hardcoder.f.a eDX = null;
        public com.tencent.mm.hardcoder.f.a eDY = null;
        public long lastUpdateTime = 0;
        public int scene = 0;
        public long startTime = 0;
        public String tag;

        public b() {
            AppMethodBeat.i(93951);
            AppMethodBeat.o(93951);
        }

        public final boolean PD() {
            return this.eDI != null && this.eDI.length > 0 && (this.eDI.length != 1 || this.eDI[0] > 0);
        }

        public final String toString(long j) {
            AppMethodBeat.i(93952);
            String format = String.format("hashCode:%x time:[init:%d,start:%d,stop:%d][delay:%d,timeout:%d][scene:%d,action:%d,callerTid:%d][cpu:%d,io:%d,gpu:%d] bindTids:%s [TAG:%s]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(this.eDK - j), Long.valueOf(this.startTime - j), Long.valueOf(this.eDL - j), Integer.valueOf(this.delay), Integer.valueOf(this.azs), Integer.valueOf(this.scene), Long.valueOf(this.eDJ), Integer.valueOf(this.eDM), Integer.valueOf(this.eDF), Integer.valueOf(this.eDH), Integer.valueOf(this.eDG), PE(), this.tag});
            AppMethodBeat.o(93952);
            return format;
        }

        public final String PE() {
            AppMethodBeat.i(93953);
            String stringBuilder;
            if (PD()) {
                StringBuilder stringBuilder2 = new StringBuilder("[");
                for (int i : this.eDI) {
                    stringBuilder2.append(i + " ");
                }
                stringBuilder2.append("]");
                stringBuilder = stringBuilder2.toString();
                AppMethodBeat.o(93953);
                return stringBuilder;
            }
            stringBuilder = "[ ]";
            AppMethodBeat.o(93953);
            return stringBuilder;
        }
    }

    static final class c {
        public int aBR = 0;
        public long eDE = 0;

        c() {
        }
    }

    public a(HCPerfManagerThread hCPerfManagerThread, Context context) {
        AppMethodBeat.i(93954);
        this.eDz = new b(context);
        this.eDz.start();
        this.eDB = hCPerfManagerThread;
        this.eDA = this.eDB.newThread(new a(this, (byte) 0), "HCPerfManager", 10);
        this.eDA.start();
        c.i("HardCoder.HCPerfManager", String.format("hardcoder HCPerfManager new thread[%s]", new Object[]{this.eDA}));
        AppMethodBeat.o(93954);
    }

    public final int a(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, long j, int i7, String str) {
        AppMethodBeat.i(93955);
        if (i < 0 || i2 < 0 || i4 < 0 || i3 < 0 || iArr == null || iArr.length <= 0 || i5 <= 0 || (i2 == 0 && i3 == 0 && i4 == 0 && iArr.length == 1 && iArr[0] == 0)) {
            String str2 = "HardCoder.HCPerfManager";
            String str3 = "start error params, ignore this task! delay:%d, [cpu:%d, io:%d, gpu:%d], bindTids:%d, timeout:%d";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = Integer.valueOf(i4);
            objArr[4] = Integer.valueOf(iArr == null ? 0 : iArr.length);
            objArr[5] = Integer.valueOf(i5);
            c.e(str2, String.format(str3, objArr));
            AppMethodBeat.o(93955);
            return 0;
        }
        b bVar = new b();
        bVar.delay = i;
        bVar.eDF = i2;
        bVar.eDH = i3;
        bVar.eDI = (int[]) iArr.clone();
        bVar.eDG = i4;
        bVar.azs = i5;
        bVar.scene = i6;
        bVar.eDJ = j;
        bVar.eDM = i7;
        bVar.eDK = System.currentTimeMillis();
        bVar.startTime = bVar.eDK + ((long) i);
        bVar.eDL = (bVar.eDK + ((long) i)) + ((long) i5);
        bVar.tag = str;
        bVar.lastUpdateTime = bVar.startTime;
        c.d("HardCoder.HCPerfManager", String.format("start ret:%b ,task:%s", new Object[]{Boolean.valueOf(this.eDC.offer(bVar)), bVar.toString(bVar.eDK)}));
        if (this.eDC.offer(bVar)) {
            int hashCode = bVar.hashCode();
            AppMethodBeat.o(93955);
            return hashCode;
        }
        AppMethodBeat.o(93955);
        return 0;
    }

    static /* synthetic */ void a(a aVar, long j, List list, int i, int i2, int i3, int[] iArr) {
        AppMethodBeat.i(93956);
        aVar.eDz.an(new com.tencent.mm.hardcoder.b.a(j, new ArrayList(list), i, i2, i3, iArr));
        AppMethodBeat.o(93956);
    }

    static /* synthetic */ void a(a aVar, b bVar) {
        AppMethodBeat.i(93957);
        c.d("HardCoder.HCPerfManager", "reportPerformanceTask:" + bVar.hashCode());
        aVar.eDz.an(bVar);
        AppMethodBeat.o(93957);
    }
}
