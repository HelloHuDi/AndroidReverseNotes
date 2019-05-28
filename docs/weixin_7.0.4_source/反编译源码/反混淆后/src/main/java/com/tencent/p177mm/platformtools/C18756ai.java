package com.tencent.p177mm.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* renamed from: com.tencent.mm.platformtools.ai */
public final class C18756ai {

    /* renamed from: com.tencent.mm.platformtools.ai$c */
    public static class C18757c {
        public final String ceO;
        public final int gjI;
        public final String gjJ;

        public C18757c(String str, int i, String str2) {
            this.ceO = str;
            this.gjI = i;
            this.gjJ = str2;
        }
    }

    /* renamed from: com.tencent.mm.platformtools.ai$b */
    public static class C18758b {
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00d9 A:{SYNTHETIC, Splitter:B:39:0x00d9} */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00de A:{SYNTHETIC, Splitter:B:42:0x00de} */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00d9 A:{SYNTHETIC, Splitter:B:39:0x00d9} */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00de A:{SYNTHETIC, Splitter:B:42:0x00de} */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00d9 A:{SYNTHETIC, Splitter:B:39:0x00d9} */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00de A:{SYNTHETIC, Splitter:B:42:0x00de} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: A */
        public static String m29308A(File file) {
            Throwable e;
            InputStream inputStream;
            AppMethodBeat.m2504i(16710);
            JarFile jarFile;
            InputStream inputStream2;
            try {
                jarFile = new JarFile(file);
                try {
                    X509Certificate x509Certificate;
                    String w;
                    byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                    Enumeration entries = jarFile.entries();
                    X509Certificate x509Certificate2 = null;
                    inputStream2 = null;
                    while (entries.hasMoreElements()) {
                        try {
                            JarEntry jarEntry = (JarEntry) entries.nextElement();
                            if (!(jarEntry.isDirectory() || jarEntry.getName().startsWith("META-INF/"))) {
                                String name = jarEntry.getName();
                                if (!("resources.arsc".equals(name) || "AndroidManifest.xml".equals(name) || jarEntry.getSize() > 5120)) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    C4990ab.m7410d("voken", "name = ".concat(String.valueOf(name)));
                                    inputStream2 = jarFile.getInputStream(jarEntry);
                                    C4990ab.m7410d("voken", "get is cost " + (System.currentTimeMillis() - currentTimeMillis));
                                    if (inputStream2 != null) {
                                        do {
                                        } while (inputStream2.read(bArr, 0, Utility.DEFAULT_STREAM_BUFFER_SIZE) != -1);
                                        inputStream2.close();
                                    }
                                    Certificate[] certificates = jarEntry.getCertificates();
                                    if (certificates == null || certificates.length == 0) {
                                        SecurityException securityException = new SecurityException("The apk file has unsigned res:" + jarEntry.getName());
                                        AppMethodBeat.m2505o(16710);
                                        throw securityException;
                                    }
                                    if (x509Certificate2 == null) {
                                        x509Certificate = (X509Certificate) certificates[0];
                                        if (x509Certificate != null) {
                                            break;
                                        }
                                    }
                                    x509Certificate = x509Certificate2;
                                    x509Certificate2 = x509Certificate;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = inputStream2;
                            try {
                                C4990ab.printErrStackTrace("MicroMsg.YYBMarketVerify", e, "", new Object[0]);
                                AppMethodBeat.m2505o(16710);
                                throw e;
                            } catch (Throwable th) {
                                e = th;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                }
                                if (jarFile != null) {
                                }
                                AppMethodBeat.m2505o(16710);
                                throw e;
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            if (inputStream2 != null) {
                            }
                            if (jarFile != null) {
                            }
                            AppMethodBeat.m2505o(16710);
                            throw e;
                        }
                    }
                    x509Certificate = x509Certificate2;
                    if (x509Certificate != null) {
                        w = C4995ag.m7429w(new String(C18758b.m29309ae(x509Certificate.getEncoded())).getBytes());
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e3) {
                                C4990ab.printErrStackTrace("MicroMsg.YYBMarketVerify", e3, "", new Object[0]);
                            }
                        }
                        try {
                            jarFile.close();
                        } catch (IOException e32) {
                            C4990ab.printErrStackTrace("MicroMsg.YYBMarketVerify", e32, "", new Object[0]);
                        }
                        AppMethodBeat.m2505o(16710);
                    } else {
                        w = "";
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e322) {
                                C4990ab.printErrStackTrace("MicroMsg.YYBMarketVerify", e322, "", new Object[0]);
                            }
                        }
                        try {
                            jarFile.close();
                        } catch (IOException e3222) {
                            C4990ab.printErrStackTrace("MicroMsg.YYBMarketVerify", e3222, "", new Object[0]);
                        }
                        AppMethodBeat.m2505o(16710);
                    }
                    return w;
                } catch (Exception e4) {
                    e = e4;
                    inputStream = null;
                    C4990ab.printErrStackTrace("MicroMsg.YYBMarketVerify", e, "", new Object[0]);
                    AppMethodBeat.m2505o(16710);
                    throw e;
                } catch (Throwable th3) {
                    e = th3;
                    inputStream2 = null;
                    if (inputStream2 != null) {
                    }
                    if (jarFile != null) {
                    }
                    AppMethodBeat.m2505o(16710);
                    throw e;
                }
            } catch (Exception e5) {
                e = e5;
                inputStream = null;
                jarFile = null;
                C4990ab.printErrStackTrace("MicroMsg.YYBMarketVerify", e, "", new Object[0]);
                AppMethodBeat.m2505o(16710);
                throw e;
            } catch (Throwable th4) {
                e = th4;
                inputStream2 = null;
                jarFile = null;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e32222) {
                        C4990ab.printErrStackTrace("MicroMsg.YYBMarketVerify", e32222, "", new Object[0]);
                    }
                }
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (IOException e322222) {
                        C4990ab.printErrStackTrace("MicroMsg.YYBMarketVerify", e322222, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(16710);
                throw e;
            }
        }

        /* renamed from: ae */
        private static char[] m29309ae(byte[] bArr) {
            int length = bArr.length;
            char[] cArr = new char[(length * 2)];
            for (int i = 0; i < length; i++) {
                byte b = bArr[i];
                int i2 = (b >> 4) & 15;
                cArr[i * 2] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
                i2 = b & 15;
                int i3 = (i * 2) + 1;
                if (i2 >= 10) {
                    i2 = (i2 + 97) - 10;
                } else {
                    i2 += 48;
                }
                cArr[i3] = (char) i2;
            }
            return cArr;
        }
    }

    /* renamed from: com.tencent.mm.platformtools.ai$a */
    public static class C18759a {
        /*  JADX ERROR: NullPointerException in pass: ProcessVariables
            java.lang.NullPointerException
            	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:271)
            	at jadx.core.dex.visitors.regions.ProcessVariables.access$000(ProcessVariables.java:31)
            	at jadx.core.dex.visitors.regions.ProcessVariables$CollectUsageRegionVisitor.processInsn(ProcessVariables.java:163)
            	at jadx.core.dex.visitors.regions.ProcessVariables$CollectUsageRegionVisitor.processBlockTraced(ProcessVariables.java:129)
            	at jadx.core.dex.visitors.regions.TracedRegionVisitor.processBlock(TracedRegionVisitor.java:23)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:53)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal$$Lambda$83/241324478.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal$$Lambda$83/241324478.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal$$Lambda$83/241324478.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal$$Lambda$83/241324478.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal$$Lambda$83/241324478.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal$$Lambda$83/241324478.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal$$Lambda$83/241324478.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal$$Lambda$83/241324478.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal$$Lambda$83/241324478.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal$$Lambda$83/241324478.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
            	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:183)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal$$Lambda$62/242951823.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at jadx.core.dex.visitors.DepthTraversal$$Lambda$61/384311550.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            */
        /* JADX WARNING: Missing block: B:18:?, code skipped:
            r1 = r2.nextToken();
     */
        /* JADX WARNING: Missing block: B:37:0x009d, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:39:?, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.YYBMarketVerify", r3, "", new java.lang.Object[0]);
     */
        /* JADX WARNING: Missing block: B:43:0x00c2, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:45:?, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.YYBMarketVerify", r3, "", new java.lang.Object[0]);
     */
        /* renamed from: N */
        public static int m29310N(android.content.Context r9, java.lang.String r10) {
            /*
            r2 = 0;
            r8 = 16707; // 0x4143 float:2.3411E-41 double:8.2544E-320;
            r0 = 0;
            com.tencent.matrix.trace.core.AppMethodBeat.m2504i(r8);
            r1 = 0;
            r1 = r9.createPackageContext(r10, r1);	 Catch:{ NameNotFoundException -> 0x0012 }
        L_0x000c:
            if (r1 != 0) goto L_0x0020;
        L_0x000e:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
        L_0x0011:
            return r0;
        L_0x0012:
            r1 = move-exception;
            r3 = "MicroMsg.YYBMarketVerify";
            r4 = "";
            r5 = new java.lang.Object[r0];
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace(r3, r1, r4, r5);
            r1 = r2;
            goto L_0x000c;
        L_0x0020:
            r3 = r1.getAssets();
            r4 = new android.content.res.Resources;
            r5 = r9.getResources();
            r5 = r5.getDisplayMetrics();
            r4.<init>(r3, r5, r2);
            r2 = com.tencent.p177mm.platformtools.C18756ai.C18759a.m29311a(r1, r3);	 Catch:{ IOException -> 0x00ab }
            if (r2 != 0) goto L_0x0040;
        L_0x0037:
            if (r2 == 0) goto L_0x003c;
        L_0x0039:
            r2.close();
        L_0x003c:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
            goto L_0x0011;
        L_0x0040:
            r1 = r2.getEventType();	 Catch:{ XmlPullParserException -> 0x004f }
        L_0x0044:
            r3 = 1;
            if (r1 == r3) goto L_0x00db;
        L_0x0047:
            switch(r1) {
                case 2: goto L_0x005e;
                default: goto L_0x004a;
            };
        L_0x004a:
            r1 = r2.nextToken();	 Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x00c2 }
            goto L_0x0044;
        L_0x004f:
            r1 = move-exception;
            r3 = "MicroMsg.YYBMarketVerify";	 Catch:{ IOException -> 0x00ab }
            r5 = "";	 Catch:{ IOException -> 0x00ab }
            r6 = 0;	 Catch:{ IOException -> 0x00ab }
            r6 = new java.lang.Object[r6];	 Catch:{ IOException -> 0x00ab }
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace(r3, r1, r5, r6);	 Catch:{ IOException -> 0x00ab }
            r1 = r0;	 Catch:{ IOException -> 0x00ab }
            goto L_0x0044;	 Catch:{ IOException -> 0x00ab }
        L_0x005e:
            r3 = r2.getName();	 Catch:{ IOException -> 0x00ab }
            r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ IOException -> 0x00ab }
            if (r5 != 0) goto L_0x004a;	 Catch:{ IOException -> 0x00ab }
        L_0x0068:
            r5 = "manifest";	 Catch:{ IOException -> 0x00ab }
            r3 = r3.equals(r5);	 Catch:{ IOException -> 0x00ab }
            if (r3 == 0) goto L_0x004a;	 Catch:{ IOException -> 0x00ab }
        L_0x0071:
            r1 = "versionCode";	 Catch:{ IOException -> 0x00ab }
            r3 = "http://schemas.android.com/apk/res/android";	 Catch:{ IOException -> 0x00ab }
            r1 = r2.getAttributeValue(r3, r1);	 Catch:{ IOException -> 0x00ab }
            r1 = com.tencent.p177mm.platformtools.C18756ai.C18759a.m29312a(r1, r4);	 Catch:{ IOException -> 0x00ab }
            r3 = android.text.TextUtils.isEmpty(r1);	 Catch:{ IOException -> 0x00ab }
            if (r3 == 0) goto L_0x008e;
        L_0x0085:
            if (r2 == 0) goto L_0x008a;
        L_0x0087:
            r2.close();
        L_0x008a:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
            goto L_0x0011;
        L_0x008e:
            r3 = 0;
            r0 = com.tencent.p177mm.platformtools.C42252ah.getInt(r1, r3);	 Catch:{ IOException -> 0x00ab }
            if (r2 == 0) goto L_0x0098;
        L_0x0095:
            r2.close();
        L_0x0098:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
            goto L_0x0011;
        L_0x009d:
            r3 = move-exception;
            r5 = "MicroMsg.YYBMarketVerify";	 Catch:{ IOException -> 0x00ab }
            r6 = "";	 Catch:{ IOException -> 0x00ab }
            r7 = 0;	 Catch:{ IOException -> 0x00ab }
            r7 = new java.lang.Object[r7];	 Catch:{ IOException -> 0x00ab }
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace(r5, r3, r6, r7);	 Catch:{ IOException -> 0x00ab }
            goto L_0x0044;
        L_0x00ab:
            r1 = move-exception;
            r3 = "MicroMsg.YYBMarketVerify";	 Catch:{ all -> 0x00d1 }
            r4 = "";	 Catch:{ all -> 0x00d1 }
            r5 = 0;	 Catch:{ all -> 0x00d1 }
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00d1 }
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace(r3, r1, r4, r5);	 Catch:{ all -> 0x00d1 }
            if (r2 == 0) goto L_0x00bd;
        L_0x00ba:
            r2.close();
        L_0x00bd:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
            goto L_0x0011;
        L_0x00c2:
            r3 = move-exception;
            r5 = "MicroMsg.YYBMarketVerify";	 Catch:{ IOException -> 0x00ab }
            r6 = "";	 Catch:{ IOException -> 0x00ab }
            r7 = 0;	 Catch:{ IOException -> 0x00ab }
            r7 = new java.lang.Object[r7];	 Catch:{ IOException -> 0x00ab }
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace(r5, r3, r6, r7);	 Catch:{ IOException -> 0x00ab }
            goto L_0x0044;
        L_0x00d1:
            r0 = move-exception;
            if (r2 == 0) goto L_0x00d7;
        L_0x00d4:
            r2.close();
        L_0x00d7:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
            throw r0;
        L_0x00db:
            if (r2 == 0) goto L_0x00bd;
        L_0x00dd:
            r2.close();
            goto L_0x00bd;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.p177mm.platformtools.C18756ai$C18759a.m29310N(android.content.Context, java.lang.String):int");
        }

        /* renamed from: a */
        private static XmlResourceParser m29311a(Context context, AssetManager assetManager) {
            XmlResourceParser openXmlResourceParser;
            int i = 1;
            AppMethodBeat.m2504i(16708);
            try {
                String str = (String) Context.class.getMethod("getPackageResourcePath", new Class[0]).invoke(context, new Object[0]);
                Method method = AssetManager.class.getMethod("getCookieName", new Class[]{Integer.TYPE});
                if (str == null && context.getPackageName().equals("android")) {
                    str = "/system/framework/framework-res.apk";
                }
                while (i < 20) {
                    if (str != null) {
                        if (str.equals(method.invoke(assetManager, new Object[]{Integer.valueOf(i)}))) {
                            openXmlResourceParser = assetManager.openXmlResourceParser(i, "AndroidManifest.xml");
                            AppMethodBeat.m2505o(16708);
                            return openXmlResourceParser;
                        }
                    }
                    i++;
                }
            } catch (Exception e) {
            }
            openXmlResourceParser = assetManager.openXmlResourceParser("AndroidManifest.xml");
            AppMethodBeat.m2505o(16708);
            return openXmlResourceParser;
        }

        /* renamed from: a */
        private static String m29312a(String str, Resources resources) {
            AppMethodBeat.m2504i(16709);
            if (str == null || !str.startsWith("@")) {
                AppMethodBeat.m2505o(16709);
            } else {
                try {
                    str = resources.getString(Integer.parseInt(str.substring(1)));
                    AppMethodBeat.m2505o(16709);
                } catch (NumberFormatException e) {
                    AppMethodBeat.m2505o(16709);
                } catch (NotFoundException e2) {
                    AppMethodBeat.m2505o(16709);
                }
            }
            return str;
        }
    }

    /* renamed from: a */
    public static boolean m29307a(Context context, ArrayList<C18757c> arrayList, boolean z) {
        AppMethodBeat.m2504i(16711);
        if (arrayList.size() == 0) {
            AppMethodBeat.m2505o(16711);
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C18757c c18757c = (C18757c) it.next();
            if (!TextUtils.isEmpty(c18757c.ceO)) {
                String replace;
                String str = c18757c.ceO;
                ArrayList<String> arrayList2 = new ArrayList();
                String packageResourcePath = context.getPackageResourcePath();
                String str2;
                int i;
                if (VERSION.SDK_INT >= 21) {
                    String[] split = packageResourcePath.split("/");
                    str2 = "";
                    if (split != null) {
                        CharSequence charSequence;
                        for (i = 0; i < split.length; i++) {
                            if (split[i].contains(context.getPackageName())) {
                                charSequence = split[i];
                                break;
                            }
                        }
                        Object charSequence2 = str2;
                        if (!TextUtils.isEmpty(charSequence2)) {
                            str2 = packageResourcePath.replace(charSequence2, str + "-1");
                            if (new File(str2).exists()) {
                                arrayList2.add(str2);
                            }
                            replace = packageResourcePath.replace(charSequence2, str + "-2");
                            if (new File(replace).exists()) {
                                arrayList2.add(replace);
                            }
                        }
                    }
                } else {
                    String[] split2 = packageResourcePath.split("/");
                    if (split2 != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (i = 0; i < split2.length; i++) {
                            if (i != split2.length - 1) {
                                stringBuilder.append(split2[i]);
                                stringBuilder.append("/");
                            }
                        }
                        replace = stringBuilder.toString();
                        str2 = replace + str + "-1.apk";
                        if (new File(str2).exists()) {
                            arrayList2.add(str2);
                        }
                        replace = replace + str + "-2.apk";
                        if (new File(replace).exists()) {
                            arrayList2.add(replace);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    for (String replace2 : arrayList2) {
                        File file = new File(replace2);
                        if (file.exists()) {
                            try {
                                CharSequence charSequence3;
                                replace2 = "";
                                long currentTimeMillis = System.currentTimeMillis();
                                if (z) {
                                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(c18757c.ceO, 64);
                                    if (packageInfo.signatures.length > 0) {
                                        replace2 = C4995ag.m7428ck(packageInfo.signatures[packageInfo.signatures.length - 1].toCharsString());
                                    }
                                    charSequence3 = replace2;
                                } else {
                                    Object charSequence32 = C18758b.m29308A(file.getAbsoluteFile());
                                }
                                String str3 = "MicroMsg.YYBMarketVerify";
                                String str4 = "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infoMD5[%s], sigMD5[%s], equal[%b], takes[%d]ms";
                                Object[] objArr = new Object[6];
                                objArr[0] = Boolean.valueOf(z);
                                objArr[1] = c18757c.ceO;
                                objArr[2] = c18757c.gjJ;
                                objArr[3] = charSequence32;
                                boolean z2 = !TextUtils.isEmpty(charSequence32) && charSequence32.equalsIgnoreCase(c18757c.gjJ);
                                objArr[4] = Boolean.valueOf(z2);
                                objArr[5] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                C4990ab.m7417i(str3, str4, objArr);
                                if (!TextUtils.isEmpty(charSequence32) && charSequence32.equalsIgnoreCase(c18757c.gjJ)) {
                                    int i2;
                                    currentTimeMillis = System.currentTimeMillis();
                                    if (z) {
                                        i2 = context.getPackageManager().getPackageInfo(c18757c.ceO, 0).versionCode;
                                    } else {
                                        i2 = C18759a.m29310N(context, c18757c.ceO);
                                    }
                                    str3 = "MicroMsg.YYBMarketVerify";
                                    str4 = "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infovc[%d], versionCode[%d], less[%b], takes[%d]ms";
                                    objArr = new Object[6];
                                    objArr[0] = Boolean.valueOf(z);
                                    objArr[1] = c18757c.ceO;
                                    objArr[2] = Integer.valueOf(c18757c.gjI);
                                    objArr[3] = Integer.valueOf(i2);
                                    objArr[4] = Boolean.valueOf(i2 <= c18757c.gjI);
                                    objArr[5] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                    C4990ab.m7417i(str3, str4, objArr);
                                    if (i2 <= c18757c.gjI) {
                                        AppMethodBeat.m2505o(16711);
                                        return true;
                                    }
                                }
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.YYBMarketVerify", e, "", new Object[0]);
                            }
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        AppMethodBeat.m2505o(16711);
        return false;
    }
}
