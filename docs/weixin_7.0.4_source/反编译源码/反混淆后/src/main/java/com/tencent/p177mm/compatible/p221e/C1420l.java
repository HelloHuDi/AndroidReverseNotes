package com.tencent.p177mm.compatible.p221e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.compatible.e.l */
public final class C1420l {
    private static C1420l esK = null;
    private boolean esJ = false;
    private String filePath = "";
    private Map<Integer, Object> values;

    /* renamed from: Lu */
    public static synchronized C1420l m3008Lu() {
        C1420l c1420l;
        synchronized (C1420l.class) {
            AppMethodBeat.m2504i(92935);
            if (esK == null) {
                esK = new C1420l(C6457e.eSj + "CompatibleInfo.cfg");
            }
            c1420l = esK;
            AppMethodBeat.m2505o(92935);
        }
        return c1420l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c A:{SYNTHETIC, Splitter:B:29:0x008c} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0091 A:{SYNTHETIC, Splitter:B:32:0x0091} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c A:{SYNTHETIC, Splitter:B:29:0x008c} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0091 A:{SYNTHETIC, Splitter:B:32:0x0091} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b4 A:{SYNTHETIC, Splitter:B:41:0x00b4} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b9 A:{SYNTHETIC, Splitter:B:44:0x00b9} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b4 A:{SYNTHETIC, Splitter:B:41:0x00b4} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b9 A:{SYNTHETIC, Splitter:B:44:0x00b9} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C1420l(String str) {
        Throwable e;
        AppMethodBeat.m2504i(92936);
        this.filePath = str;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            File file = new File(this.filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.length() == 0) {
                this.values = new HashMap();
            } else {
                fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        this.values = (Map) objectInputStream.readObject();
                        objectInputStream.close();
                        fileInputStream.close();
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2, "", new Object[0]);
                        }
                        try {
                            objectInputStream.close();
                        } catch (IOException e22) {
                            C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e22, "", new Object[0]);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            this.values = new HashMap();
                            C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e, "", new Object[0]);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e222) {
                                    C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e222, "", new Object[0]);
                                }
                            }
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e2222) {
                                    C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2222, "", new Object[0]);
                                }
                            }
                            this.esJ = false;
                            AppMethodBeat.m2505o(92936);
                        } catch (Throwable th) {
                            e = th;
                            if (fileInputStream != null) {
                            }
                            if (objectInputStream != null) {
                            }
                            AppMethodBeat.m2505o(92936);
                            throw e;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    objectInputStream = null;
                    this.values = new HashMap();
                    C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e, "", new Object[0]);
                    if (fileInputStream != null) {
                    }
                    if (objectInputStream != null) {
                    }
                    this.esJ = false;
                    AppMethodBeat.m2505o(92936);
                } catch (Throwable th2) {
                    e = th2;
                    objectInputStream = null;
                    if (fileInputStream != null) {
                    }
                    if (objectInputStream != null) {
                    }
                    AppMethodBeat.m2505o(92936);
                    throw e;
                }
            }
        } catch (Exception e5) {
            e = e5;
            objectInputStream = null;
            fileInputStream = null;
            this.values = new HashMap();
            C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e, "", new Object[0]);
            if (fileInputStream != null) {
            }
            if (objectInputStream != null) {
            }
            this.esJ = false;
            AppMethodBeat.m2505o(92936);
        } catch (Throwable th3) {
            e = th3;
            objectInputStream = null;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e6, "", new Object[0]);
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e7) {
                    C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e7, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(92936);
            throw e;
        }
        this.esJ = false;
        AppMethodBeat.m2505o(92936);
    }

    public final synchronized void set(int i, Object obj) {
        AppMethodBeat.m2504i(92937);
        this.values.put(Integer.valueOf(i), obj);
        if (!this.esJ) {
            m3009Lv();
        }
        AppMethodBeat.m2505o(92937);
    }

    public final Object get(int i) {
        AppMethodBeat.m2504i(92938);
        Object obj = this.values.get(Integer.valueOf(i));
        AppMethodBeat.m2505o(92938);
        return obj;
    }

    /* renamed from: aH */
    public final Object mo4866aH(int i) {
        AppMethodBeat.m2504i(92939);
        Object obj = this.values.get(Integer.valueOf(i));
        if (obj == null) {
            AppMethodBeat.m2505o(92939);
            return null;
        }
        AppMethodBeat.m2505o(92939);
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x009c A:{SYNTHETIC, Splitter:B:49:0x009c} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a1 A:{SYNTHETIC, Splitter:B:52:0x00a1} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066 A:{SYNTHETIC, Splitter:B:34:0x0066} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c7 A:{Catch:{ IOException -> 0x0030 }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006b A:{SYNTHETIC, Splitter:B:37:0x006b} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066 A:{SYNTHETIC, Splitter:B:34:0x0066} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006b A:{SYNTHETIC, Splitter:B:37:0x006b} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c7 A:{Catch:{ IOException -> 0x0030 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009c A:{SYNTHETIC, Splitter:B:49:0x009c} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a1 A:{SYNTHETIC, Splitter:B:52:0x00a1} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Lv */
    private synchronized void m3009Lv() {
        ObjectOutputStream objectOutputStream;
        Throwable e;
        AppMethodBeat.m2504i(92940);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(this.filePath);
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            } catch (IOException e2) {
                e = e2;
                objectOutputStream = null;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                    }
                    if (objectOutputStream != null) {
                    }
                    return;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e3, "", new Object[0]);
                        }
                    }
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e4) {
                            C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e4, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(92940);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                objectOutputStream = null;
                if (fileOutputStream != null) {
                }
                if (objectOutputStream != null) {
                }
                AppMethodBeat.m2505o(92940);
                throw e;
            }
            try {
                objectOutputStream.writeObject(this.values);
                objectOutputStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e5, "", new Object[0]);
                }
                try {
                    objectOutputStream.close();
                    AppMethodBeat.m2505o(92940);
                } catch (IOException e52) {
                    C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e52, "", new Object[0]);
                    AppMethodBeat.m2505o(92940);
                }
            } catch (IOException e6) {
                e = e6;
                C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e, "", new Object[0]);
                if (fileOutputStream != null) {
                }
                if (objectOutputStream != null) {
                }
                return;
            }
        } catch (IOException e7) {
            e = e7;
            objectOutputStream = null;
            fileOutputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e, "", new Object[0]);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e522) {
                    C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e522, "", new Object[0]);
                }
            }
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                    AppMethodBeat.m2505o(92940);
                } catch (IOException e5222) {
                    C4990ab.printErrStackTrace("MicroMsg.CompatibleFileStorage", e5222, "", new Object[0]);
                    AppMethodBeat.m2505o(92940);
                }
            } else {
                AppMethodBeat.m2505o(92940);
            }
            return;
        } catch (Throwable th3) {
            e = th3;
            objectOutputStream = null;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            if (objectOutputStream != null) {
            }
            AppMethodBeat.m2505o(92940);
            throw e;
        }
        return;
    }
}
