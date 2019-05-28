package com.tencent.p177mm.hardcoder;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1609b.C1608a;
import com.tencent.p177mm.hardcoder.C1621f.C1619a;
import com.tencent.p177mm.hardcoder.HardCoderJNI.HCPerfManagerThread;
import com.tencent.p177mm.loader.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.hardcoder.a */
public final class C1607a {
    public static boolean eDw = false;
    private static final int[] eDx = new int[]{0, 1, 2, 3};
    private static final int[] eDy = new int[]{0, 1, 2, 3};
    private Thread eDA;
    HCPerfManagerThread eDB;
    LinkedBlockingQueue<Object> eDC = new LinkedBlockingQueue();
    private C1609b eDz;

    /* renamed from: com.tencent.mm.hardcoder.a$a */
    class C1604a implements Runnable {
        private boolean running;

        private C1604a() {
            this.running = false;
        }

        /* synthetic */ C1604a(C1607a c1607a, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(93950);
            C1611c.m3271i("HardCoder.HCPerfManager", String.format("HCPerfManager thread run start, id:%d, name:%s", new Object[]{Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName()}));
            this.running = true;
            HashSet hashSet = new HashSet();
            long j = 30000;
            ArrayList arrayList = new ArrayList();
            long[] PF = C1623g.m3283PF();
            if (PF == null || PF.length < 2) {
                PF = new long[]{0, 0};
                C1611c.m3271i("HardCoder.HardCoderReporter", "process jiffes info is invalid");
            }
            C1611c.m3271i("HardCoder.HardCoderReporter", "process:[" + PF[0] + "," + PF[1] + "]");
            HashMap hashMap = new HashMap();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = hashSet;
            C1605b c1605b = null;
            C1605b c1605b2 = null;
            C1605b c1605b3 = null;
            while (this.running) {
                int i;
                C1605b c1605b4;
                int i2;
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                int size = C1607a.this.eDC.size();
                C1611c.m3269d("HardCoder.HCPerfManager", "startLoop queue:" + size + " startTask:" + arrayList.size() + " nextWakeInterval:" + j);
                int i3 = 0;
                while (true) {
                    if (i3 >= (size == 0 ? 1 : size)) {
                        break;
                    }
                    Object poll;
                    try {
                        poll = C1607a.this.eDC.poll(j, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        C1611c.m3270e("HardCoder.HCPerfManager", "taskQueue poll: " + e.getMessage());
                        poll = null;
                    }
                    if (poll == null) {
                        break;
                    }
                    if (!(poll instanceof C1605b)) {
                        if (!(poll instanceof C1606c)) {
                            if (!HardCoderJNI.isCheckEnv()) {
                                this.running = false;
                                break;
                            }
                            Assert.fail("taskQueue poll invalid object");
                        } else {
                            i = ((C1606c) poll).aBR;
                            if (hashSet2.contains(Integer.valueOf(i))) {
                                hashMap.put(Integer.valueOf(i), (C1606c) poll);
                            }
                        }
                    } else {
                        arrayList.add((C1605b) poll);
                        hashSet2.add(Integer.valueOf(((C1605b) poll).hashCode()));
                    }
                    i3++;
                }
                long j2 = 30000;
                C1605b c1605b5 = null;
                C1605b c1605b6 = null;
                C1605b c1605b7 = null;
                HashSet hashSet4 = new HashSet();
                long currentTimeMillis2 = System.currentTimeMillis();
                C1611c.m3269d("HardCoder.HCPerfManager", "InLoop startSize:" + arrayList.size());
                i = 0;
                while (true) {
                    int i4 = i;
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    c1605b4 = (C1605b) arrayList.get(i4);
                    j = System.currentTimeMillis();
                    if (c1605b4 != null) {
                        if (hashMap.containsKey(Integer.valueOf(c1605b4.hashCode()))) {
                            c1605b4.eDL = j;
                            c1605b4.eDE = ((C1606c) hashMap.get(Integer.valueOf(c1605b4.hashCode()))).eDE;
                            hashMap.remove(Integer.valueOf(c1605b4.hashCode()));
                            C1607a.m3261a(C1607a.this, j, arrayList, -2, -2, -2, null);
                            C1607a.m3262a(C1607a.this, c1605b4);
                        }
                        long j3 = c1605b4.eDL - j;
                        if (j3 <= 0) {
                            C1611c.m3269d("HardCoder.HCPerfManager", "InLoop STOP:" + i4 + "/" + arrayList.size() + " task:" + c1605b4.toString(j));
                            arrayList.remove(c1605b4);
                            hashSet2.remove(Integer.valueOf(c1605b4.hashCode()));
                            i4--;
                        } else {
                            j2 = Math.min(j2, j3);
                            j3 = c1605b4.startTime - j;
                            if (j3 > 0) {
                                C1611c.m3269d("HardCoder.HCPerfManager", "InLoop WAIT:" + i4 + "/" + arrayList.size() + " task:" + c1605b4.toString(j));
                                j2 = Math.min(j2, j3);
                            } else {
                                C1611c.m3269d("HardCoder.HCPerfManager", "InLoop RUN:" + i4 + "/" + arrayList.size() + " task:" + c1605b4.toString(j));
                                if (c1605b4.eDF > 0 && (c1605b5 == null || c1605b5.eDF > c1605b4.eDF || (c1605b5.eDF == c1605b4.eDF && c1605b5.eDL < c1605b4.eDL))) {
                                    c1605b5 = c1605b4;
                                }
                                if (c1605b4.eDG > 0 && (c1605b6 == null || c1605b6.eDG > c1605b4.eDG || (c1605b6.eDG == c1605b4.eDG && c1605b6.eDL < c1605b4.eDL))) {
                                    c1605b6 = c1605b4;
                                }
                                if (c1605b4.eDH > 0 && (c1605b7 == null || c1605b7.eDH > c1605b4.eDH || (c1605b7.eDH == c1605b4.eDH && c1605b7.eDL < c1605b4.eDL))) {
                                    c1605b7 = c1605b4;
                                }
                                for (int size2 : c1605b4.eDI) {
                                    if (size2 > 0) {
                                        hashSet4.add(c1605b4);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    i = i4 + 1;
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                C1611c.m3269d("HardCoder.HCPerfManager", String.format("EndLoop time:[%d,%d] list:%d stop:%d bindCore:%d -> %d", new Object[]{Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis), Integer.valueOf(arrayList.size()), Integer.valueOf(hashMap.size()), Integer.valueOf(hashSet3.size()), Integer.valueOf(hashSet4.size())}));
                String str2 = "HardCoder.HCPerfManager";
                StringBuilder append = new StringBuilder("EndLoop CurrCpu:").append(c1605b3 == null ? BuildConfig.COMMAND : c1605b3.toString(currentTimeMillis2)).append(" -> MaxCpu:");
                if (c1605b5 == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = c1605b5.toString(currentTimeMillis2);
                }
                C1611c.m3269d(str2, append.append(str).toString());
                str2 = "HardCoder.HCPerfManager";
                append = new StringBuilder("EndLoop CurrGpu:").append(c1605b2 == null ? BuildConfig.COMMAND : c1605b2.toString(currentTimeMillis2)).append(" -> MaxGpu:");
                if (c1605b2 == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = c1605b2.toString(currentTimeMillis2);
                }
                C1611c.m3269d(str2, append.append(str).toString());
                str2 = "HardCoder.HCPerfManager";
                append = new StringBuilder("EndLoop CurrIO:").append(c1605b == null ? BuildConfig.COMMAND : c1605b.toString(currentTimeMillis2)).append(" -> MaxIO:");
                if (c1605b7 == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = c1605b7.toString(currentTimeMillis2);
                }
                C1611c.m3269d(str2, append.append(str).toString());
                C1611c.m3269d("HardCoder.HCPerfManager", String.format("EndLoop BindCore.size cur: %d, need: %d", new Object[]{Integer.valueOf(hashSet3.size()), Integer.valueOf(hashSet4.size())}));
                HashSet hashSet5 = new HashSet();
                hashSet5.addAll(hashSet3);
                hashSet5.removeAll(hashSet4);
                if (c1605b5 == c1605b3 && c1605b6 == c1605b2 && c1605b7 == c1605b && hashSet3.size() == hashSet4.size() && hashSet5.isEmpty()) {
                    C1611c.m3269d("HardCoder.HCPerfManager", "EndLoop Nothing Changed, Continue.");
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
                        c1605b4 = (C1605b) it.next();
                        if (c1605b4.eDI != null) {
                            i = c1605b4.eDI.length + i2;
                        } else {
                            i = i2;
                        }
                    }
                    if (i2 > 0) {
                        int[] iArr = new int[i2];
                        Iterator it2 = hashSet5.iterator();
                        i2 = 0;
                        while (it2.hasNext()) {
                            c1605b4 = (C1605b) it2.next();
                            long currentTimeMillis4 = System.currentTimeMillis();
                            C1611c.m3271i("HardCoder.HCPerfManager", "!cancelBindCore task:" + c1605b4.toString(currentTimeMillis4));
                            if (c1605b4.eDL > currentTimeMillis4) {
                                C1611c.m3270e("HardCoder.HCPerfManager", "stopTime:" + (c1605b4.eDL - currentTimeMillis4) + ". Error !");
                            } else {
                                if (!c1605b4.mo5055PD()) {
                                    if (!HardCoderJNI.isCheckEnv()) {
                                        this.running = false;
                                        break;
                                    }
                                    Assert.fail("bindTids:" + c1605b4.mo5056PE());
                                }
                                i = i2;
                                for (int i22 : c1605b4.eDI) {
                                    iArr[i] = i22;
                                    i++;
                                }
                                i22 = i;
                            }
                        }
                        if (!C1607a.eDw && HardCoderJNI.isCheckEnv()) {
                            HardCoderJNI.cancelCpuCoreForThread(iArr, Process.myTid(), SystemClock.elapsedRealtimeNanos());
                        }
                        C1607a.m3261a(C1607a.this, currentTimeMillis2, arrayList, -2, -2, -2, null);
                    }
                    i = 0;
                    it = hashSet4.iterator();
                    while (true) {
                        i22 = i;
                        if (!it.hasNext()) {
                            break;
                        }
                        c1605b4 = (C1605b) it.next();
                        if (c1605b4.eDI != null) {
                            i = c1605b4.eDI.length + i22;
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
                        c1605b4 = (C1605b) it3.next();
                        C1611c.m3271i("HardCoder.HCPerfManager", "requestBindCore task:" + c1605b4.toString(currentTimeMillis2));
                        currentTimeMillis = System.currentTimeMillis();
                        if (c1605b4.eDL <= currentTimeMillis) {
                            C1611c.m3270e("HardCoder.HCPerfManager", "stopTime:" + (c1605b4.eDL - currentTimeMillis) + ". Error !");
                        } else {
                            if (!c1605b4.mo5055PD()) {
                                if (!HardCoderJNI.isCheckEnv()) {
                                    this.running = false;
                                    break;
                                }
                                Assert.fail("bindTids:" + c1605b4.mo5056PE());
                            }
                            for (int i52 : c1605b4.eDI) {
                                iArr2[i22] = i52;
                                i22++;
                            }
                            size2 = c1605b4.scene;
                            j = c1605b4.eDJ;
                            i52 = c1605b4.eDM;
                            i3 = Math.min((int) (c1605b4.eDL - currentTimeMillis2), i3);
                            i9 = i52;
                        }
                    }
                    if (c1605b7 == null) {
                        if (c1605b != null) {
                            C1611c.m3271i("HardCoder.HCPerfManager", "!cancelHighIOFreq task:" + c1605b.toString(currentTimeMillis2));
                            if (!C1607a.eDw && HardCoderJNI.isCheckEnv()) {
                                HardCoderJNI.cancelHighIOFreq(c1605b.eDM, SystemClock.elapsedRealtimeNanos());
                            }
                            C1607a.m3261a(C1607a.this, currentTimeMillis2, arrayList, -2, -2, -1, null);
                        }
                    } else if (c1605b != c1605b7) {
                        str2 = "HardCoder.HCPerfManager";
                        StringBuilder stringBuilder = new StringBuilder("IOReq:");
                        if (c1605b == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = c1605b.toString(currentTimeMillis2);
                        }
                        C1611c.m3269d(str2, stringBuilder.append(str).append(" -> ").append(c1605b7.toString(currentTimeMillis2)).append(" delay:").append(currentTimeMillis3 - c1605b7.startTime).toString());
                    }
                    if (c1605b7 != null) {
                        i52 = c1605b7.eDH;
                        i22 = c1605b7.scene;
                        j = c1605b7.eDJ;
                        i6 = c1605b7.eDM;
                        min = Math.min((int) (c1605b7.eDL - currentTimeMillis2), i3);
                    } else {
                        i22 = size2;
                        i52 = 0;
                        min = i3;
                        i6 = i9;
                    }
                    if (c1605b6 == null) {
                        if (c1605b2 != null) {
                            C1611c.m3271i("HardCoder.HCPerfManager", "!cancelGpuHighFreq task:" + c1605b2.toString(currentTimeMillis2));
                            if (!C1607a.eDw && HardCoderJNI.isCheckEnv()) {
                                HardCoderJNI.cancelGpuHighFreq(c1605b2.eDM, SystemClock.elapsedRealtimeNanos());
                            }
                            C1607a.m3261a(C1607a.this, currentTimeMillis2, arrayList, -2, -1, -2, null);
                        }
                    } else if (c1605b2 != c1605b6) {
                        String str3 = "HardCoder.HCPerfManager";
                        StringBuilder stringBuilder2 = new StringBuilder("GPUReq:");
                        if (c1605b2 == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = c1605b2.toString(currentTimeMillis2);
                        }
                        C1611c.m3269d(str3, stringBuilder2.append(str).append(" -> ").append(c1605b6.toString(currentTimeMillis2)).append(" delay:").append(currentTimeMillis3 - c1605b6.startTime).toString());
                    }
                    if (c1605b6 != null) {
                        i3 = c1605b6.eDG;
                        size2 = c1605b6.scene;
                        long j4 = c1605b6.eDJ;
                        i7 = c1605b6.eDM;
                        i9 = Math.min((int) (c1605b6.eDL - currentTimeMillis2), min);
                        j = j4;
                        i8 = size2;
                        i6 = i7;
                    } else {
                        i8 = i22;
                        i3 = 0;
                        i9 = min;
                    }
                    if (c1605b5 == null) {
                        if (c1605b3 != null) {
                            C1611c.m3271i("HardCoder.HCPerfManager", "!cancelCpuHighFreq task:" + c1605b3.toString(currentTimeMillis2));
                            if (!C1607a.eDw && HardCoderJNI.isCheckEnv()) {
                                HardCoderJNI.cancelCpuHighFreq(c1605b3.eDM, SystemClock.elapsedRealtimeNanos());
                            }
                            C1607a.m3261a(C1607a.this, currentTimeMillis2, arrayList, -1, -2, -2, null);
                        }
                    } else if (c1605b3 != c1605b5) {
                        str2 = "HardCoder.HCPerfManager";
                        StringBuilder stringBuilder3 = new StringBuilder("CPUReq:");
                        if (c1605b3 == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = c1605b3.toString(currentTimeMillis2);
                        }
                        C1611c.m3269d(str2, stringBuilder3.append(str).append(" -> ").append(c1605b5.toString(currentTimeMillis2)).append(" delay:").append(currentTimeMillis3 - c1605b5.startTime).toString());
                    }
                    if (c1605b5 != null) {
                        size2 = c1605b5.eDF;
                        i22 = c1605b5.scene;
                        j = c1605b5.eDJ;
                        i7 = c1605b5.eDM;
                        i9 = Math.min((int) (c1605b5.eDL - currentTimeMillis2), i9);
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
                        if (c1605b5 == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = c1605b5.toString(currentTimeMillis2);
                        }
                        numArr[8] = str;
                        numArr[9] = c1605b6 == null ? BuildConfig.COMMAND : c1605b6.toString(currentTimeMillis2);
                        numArr[10] = c1605b7 == null ? BuildConfig.COMMAND : c1605b7.toString(currentTimeMillis2);
                        if (c1605b5 == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = c1605b5.toString(currentTimeMillis2);
                        }
                        numArr[11] = str;
                        numArr[12] = c1605b6 == null ? BuildConfig.COMMAND : c1605b6.toString(currentTimeMillis2);
                        numArr[13] = c1605b7 == null ? BuildConfig.COMMAND : c1605b7.toString(currentTimeMillis2);
                        C1611c.m3271i(str4, String.format(str5, numArr));
                        Assert.assertTrue(i9 > 0);
                        z = i22 > 0 || j > 0;
                        Assert.assertTrue(z);
                        Assert.assertTrue(i7 > 0);
                        z = size2 > 0 || i3 > 0 || i52 > 0 || iArr2.length > 0;
                        Assert.assertTrue(z);
                        if (!C1607a.eDw && HardCoderJNI.isCheckEnv()) {
                            HardCoderJNI.requestUnifyCpuIOThreadCoreGpu(i22, j, size2, i3, i52, iArr2, i9, i7, SystemClock.elapsedRealtimeNanos());
                            String str6 = "HardCoder.HCPerfManager";
                            str4 = "hardcoder requestUnifyCpuIOThreadCoreGpu reqScene[%d, %d] running[j %b, c %b]";
                            Object[] objArr = new Object[4];
                            objArr[0] = Integer.valueOf(i22);
                            objArr[1] = Long.valueOf(j);
                            objArr[2] = Boolean.valueOf(HardCoderJNI.isHcEnable());
                            z = HardCoderJNI.isCheckEnv() && HardCoderJNI.isRunning() > 0;
                            objArr[3] = Boolean.valueOf(z);
                            C1611c.m3271i(str6, String.format(str4, objArr));
                            if (HardCoderJNI.sceneReportCallback != null) {
                                HardCoderJNI.sceneReportCallback.sceneReport(i22, j);
                            }
                        }
                        C1607a.m3261a(C1607a.this, currentTimeMillis2, arrayList, size2, i3, i52, iArr2);
                    }
                    if (C1607a.eDw) {
                        Assert.assertTrue(c1605b5 == c1605b5);
                        Assert.assertTrue(c1605b7 == c1605b7);
                        if (arrayList.isEmpty()) {
                            Assert.assertTrue(j2 == 30000);
                            Assert.assertTrue(i9 == BaseClientBuilder.API_PRIORITY_OTHER);
                            Assert.assertTrue(hashSet4.isEmpty());
                            Assert.assertTrue(c1605b5 == null);
                            Assert.assertTrue(c1605b6 == null);
                            Assert.assertTrue(c1605b7 == null);
                        }
                        i = 0;
                        while (true) {
                            i22 = i;
                            if (i22 >= arrayList.size()) {
                                break;
                            }
                            c1605b4 = (C1605b) arrayList.get(i22);
                            C1611c.m3269d("HardCoder.HCPerfManager", "CheckTask:" + i22 + "/" + arrayList.size() + " task:" + c1605b4.toString(currentTimeMillis2));
                            boolean z2 = c1605b4.eDF > 0 || c1605b4.eDG > 0 || c1605b4.eDH > 0 || c1605b4.mo5055PD();
                            Assert.assertTrue(z2);
                            z2 = c1605b4.eDJ > 0 || c1605b4.scene > 0;
                            Assert.assertTrue(z2);
                            Assert.assertTrue("taskInintTime:" + (c1605b4.eDK - currentTimeMillis2), c1605b4.eDK <= currentTimeMillis2);
                            Assert.assertTrue("taskStopTime:" + (c1605b4.eDL - currentTimeMillis2), c1605b4.eDL >= currentTimeMillis2);
                            Assert.assertTrue("taskHash:" + c1605b4.hashCode(), !hashMap.containsKey(Integer.valueOf(c1605b4.hashCode())));
                            if (c1605b4.startTime > currentTimeMillis2) {
                                Assert.assertTrue(c1605b4 != c1605b5);
                                Assert.assertTrue(c1605b4 != c1605b6);
                                Assert.assertTrue(c1605b4 != c1605b7);
                                Assert.assertTrue(!hashSet4.contains(c1605b4));
                                String str7 = "next:" + j2 + " start:" + (c1605b4.startTime - currentTimeMillis2);
                                if (j2 <= c1605b4.startTime - currentTimeMillis2) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                Assert.assertTrue(str7, z);
                            } else {
                                Assert.assertTrue("nextWake:" + j2 + " stop:" + (c1605b4.eDL - currentTimeMillis2), j2 <= c1605b4.eDL - currentTimeMillis2);
                                String concat = "reqTimeStamp:".concat(String.valueOf(i9));
                                z2 = i9 > 0 && i9 < BaseClientBuilder.API_PRIORITY_OTHER;
                                Assert.assertTrue(concat, z2);
                                Assert.assertTrue("reqTimeStamp:" + i9 + " stop:" + (c1605b4.eDL - currentTimeMillis2), ((long) i9) <= c1605b4.eDL - currentTimeMillis2);
                                Assert.assertTrue("reqCpu:" + size2 + " task:" + c1605b4.eDF, size2 <= c1605b4.eDF);
                                Assert.assertTrue("reqCpu:" + i3 + " task:" + c1605b4.eDG, i3 <= c1605b4.eDG);
                                Assert.assertTrue("reqIO:" + i52 + " task:" + c1605b4.eDH, i52 <= c1605b4.eDH);
                                if (c1605b4.mo5055PD()) {
                                    Assert.assertTrue(hashSet4.contains(c1605b4));
                                    if (hashSet5.contains(c1605b4)) {
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
                        c1605b = c1605b7;
                        c1605b2 = c1605b6;
                        c1605b3 = c1605b5;
                    } else {
                        j = j2;
                        hashSet3 = hashSet4;
                        c1605b = c1605b7;
                        c1605b2 = c1605b6;
                        c1605b3 = c1605b5;
                    }
                }
            }
            C1611c.m3271i("HardCoder.HCPerfManager", "HCPerfManager thread run end");
            AppMethodBeat.m2505o(93950);
        }
    }

    /* renamed from: com.tencent.mm.hardcoder.a$b */
    public static class C1605b {
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
        public int[] eDP = new int[C1607a.eDx.length];
        public int[] eDQ = new int[C1607a.eDy.length];
        public int[] eDR = null;
        public long[] eDS = null;
        public long[] eDT = null;
        public long eDU = 0;
        public int eDV = 0;
        public long eDW = 0;
        public C1619a eDX = null;
        public C1619a eDY = null;
        public long lastUpdateTime = 0;
        public int scene = 0;
        public long startTime = 0;
        public String tag;

        public C1605b() {
            AppMethodBeat.m2504i(93951);
            AppMethodBeat.m2505o(93951);
        }

        /* renamed from: PD */
        public final boolean mo5055PD() {
            return this.eDI != null && this.eDI.length > 0 && (this.eDI.length != 1 || this.eDI[0] > 0);
        }

        public final String toString(long j) {
            AppMethodBeat.m2504i(93952);
            String format = String.format("hashCode:%x time:[init:%d,start:%d,stop:%d][delay:%d,timeout:%d][scene:%d,action:%d,callerTid:%d][cpu:%d,io:%d,gpu:%d] bindTids:%s [TAG:%s]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(this.eDK - j), Long.valueOf(this.startTime - j), Long.valueOf(this.eDL - j), Integer.valueOf(this.delay), Integer.valueOf(this.azs), Integer.valueOf(this.scene), Long.valueOf(this.eDJ), Integer.valueOf(this.eDM), Integer.valueOf(this.eDF), Integer.valueOf(this.eDH), Integer.valueOf(this.eDG), mo5056PE(), this.tag});
            AppMethodBeat.m2505o(93952);
            return format;
        }

        /* renamed from: PE */
        public final String mo5056PE() {
            AppMethodBeat.m2504i(93953);
            String stringBuilder;
            if (mo5055PD()) {
                StringBuilder stringBuilder2 = new StringBuilder("[");
                for (int i : this.eDI) {
                    stringBuilder2.append(i + " ");
                }
                stringBuilder2.append("]");
                stringBuilder = stringBuilder2.toString();
                AppMethodBeat.m2505o(93953);
                return stringBuilder;
            }
            stringBuilder = "[ ]";
            AppMethodBeat.m2505o(93953);
            return stringBuilder;
        }
    }

    /* renamed from: com.tencent.mm.hardcoder.a$c */
    static final class C1606c {
        public int aBR = 0;
        public long eDE = 0;

        C1606c() {
        }
    }

    public C1607a(HCPerfManagerThread hCPerfManagerThread, Context context) {
        AppMethodBeat.m2504i(93954);
        this.eDz = new C1609b(context);
        this.eDz.start();
        this.eDB = hCPerfManagerThread;
        this.eDA = this.eDB.newThread(new C1604a(this, (byte) 0), "HCPerfManager", 10);
        this.eDA.start();
        C1611c.m3271i("HardCoder.HCPerfManager", String.format("hardcoder HCPerfManager new thread[%s]", new Object[]{this.eDA}));
        AppMethodBeat.m2505o(93954);
    }

    /* renamed from: a */
    public final int mo5058a(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, long j, int i7, String str) {
        AppMethodBeat.m2504i(93955);
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
            C1611c.m3270e(str2, String.format(str3, objArr));
            AppMethodBeat.m2505o(93955);
            return 0;
        }
        C1605b c1605b = new C1605b();
        c1605b.delay = i;
        c1605b.eDF = i2;
        c1605b.eDH = i3;
        c1605b.eDI = (int[]) iArr.clone();
        c1605b.eDG = i4;
        c1605b.azs = i5;
        c1605b.scene = i6;
        c1605b.eDJ = j;
        c1605b.eDM = i7;
        c1605b.eDK = System.currentTimeMillis();
        c1605b.startTime = c1605b.eDK + ((long) i);
        c1605b.eDL = (c1605b.eDK + ((long) i)) + ((long) i5);
        c1605b.tag = str;
        c1605b.lastUpdateTime = c1605b.startTime;
        C1611c.m3269d("HardCoder.HCPerfManager", String.format("start ret:%b ,task:%s", new Object[]{Boolean.valueOf(this.eDC.offer(c1605b)), c1605b.toString(c1605b.eDK)}));
        if (this.eDC.offer(c1605b)) {
            int hashCode = c1605b.hashCode();
            AppMethodBeat.m2505o(93955);
            return hashCode;
        }
        AppMethodBeat.m2505o(93955);
        return 0;
    }

    /* renamed from: a */
    static /* synthetic */ void m3261a(C1607a c1607a, long j, List list, int i, int i2, int i3, int[] iArr) {
        AppMethodBeat.m2504i(93956);
        c1607a.eDz.mo5059an(new C1608a(j, new ArrayList(list), i, i2, i3, iArr));
        AppMethodBeat.m2505o(93956);
    }

    /* renamed from: a */
    static /* synthetic */ void m3262a(C1607a c1607a, C1605b c1605b) {
        AppMethodBeat.m2504i(93957);
        C1611c.m3269d("HardCoder.HCPerfManager", "reportPerformanceTask:" + c1605b.hashCode());
        c1607a.eDz.mo5059an(c1605b);
        AppMethodBeat.m2505o(93957);
    }
}
