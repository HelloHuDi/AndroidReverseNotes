package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.storage.y */
public class C5144y {
    private boolean esJ = false;
    private String filePath = "";
    private Map<Integer, Object> values;
    public boolean xIr = false;
    public boolean xIs = false;

    public C5144y(String str) {
        AppMethodBeat.m2504i(58952);
        if (!new File(str).exists()) {
            C4990ab.m7413e("MicroMsg.ConfigFileStorage", "ConfigFileStorage not exit path[%s]", str);
        }
        this.filePath = str;
        dsa();
        this.esJ = false;
        AppMethodBeat.m2505o(58952);
    }

    public final synchronized void set(int i, Object obj) {
        AppMethodBeat.m2504i(58953);
        this.values.put(Integer.valueOf(i), obj);
        if (!this.esJ) {
            m7824Lv();
        }
        AppMethodBeat.m2505o(58953);
    }

    public final synchronized Object get(int i) {
        Object obj;
        AppMethodBeat.m2504i(58954);
        obj = this.values.get(Integer.valueOf(i));
        AppMethodBeat.m2505o(58954);
        return obj;
    }

    public final synchronized Object get(int i, Object obj) {
        AppMethodBeat.m2504i(58955);
        Object obj2 = this.values.get(Integer.valueOf(i));
        if (obj2 == null) {
            AppMethodBeat.m2505o(58955);
        } else {
            AppMethodBeat.m2505o(58955);
            obj = obj2;
        }
        return obj;
    }

    public final synchronized void doc() {
        this.esJ = true;
    }

    public final synchronized void drZ() {
        AppMethodBeat.m2504i(58956);
        this.esJ = false;
        m7824Lv();
        AppMethodBeat.m2505o(58956);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bc A:{SYNTHETIC, Splitter:B:40:0x00bc} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c1 A:{Catch:{ Exception -> 0x00cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d8 A:{SYNTHETIC, Splitter:B:52:0x00d8} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00dd A:{Catch:{ Exception -> 0x00e7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bc A:{SYNTHETIC, Splitter:B:40:0x00bc} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c1 A:{Catch:{ Exception -> 0x00cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d8 A:{SYNTHETIC, Splitter:B:52:0x00d8} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00dd A:{Catch:{ Exception -> 0x00e7 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void dsa() {
        Throwable e;
        AppMethodBeat.m2504i(58957);
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            File file = new File(this.filePath);
            if (!file.exists()) {
                boolean createNewFile = file.createNewFile();
                C4990ab.m7421w("MicroMsg.ConfigFileStorage", "ConfigFileStorage openCfg not exit path[%s], created[%b]", this.filePath, Boolean.valueOf(createNewFile));
            }
            if (file.length() == 0) {
                this.values = new HashMap();
                C4990ab.m7421w("MicroMsg.ConfigFileStorage", "ConfigFileStorage openCfg file len == 0 path[%s]", this.filePath);
                AppMethodBeat.m2505o(58957);
            } else {
                fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        this.values = (Map) objectInputStream.readObject();
                        C4990ab.m7417i("MicroMsg.ConfigFileStorage", "openCfg end, keys count:%d", Integer.valueOf(this.values.size()));
                        this.xIr = false;
                        try {
                            objectInputStream.close();
                            fileInputStream.close();
                            AppMethodBeat.m2505o(58957);
                        } catch (Exception e2) {
                            AppMethodBeat.m2505o(58957);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            this.values = new HashMap();
                            C4990ab.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "openCfg Exception!", new Object[0]);
                            this.xIr = true;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Exception e4) {
                                    AppMethodBeat.m2505o(58957);
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            AppMethodBeat.m2505o(58957);
                            return;
                        } catch (Throwable th) {
                            e = th;
                            if (objectInputStream != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            AppMethodBeat.m2505o(58957);
                            throw e;
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    objectInputStream = null;
                    this.values = new HashMap();
                    C4990ab.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "openCfg Exception!", new Object[0]);
                    this.xIr = true;
                    if (objectInputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(58957);
                    return;
                } catch (Throwable th2) {
                    e = th2;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e6) {
                            AppMethodBeat.m2505o(58957);
                            throw e;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    AppMethodBeat.m2505o(58957);
                    throw e;
                }
            }
        } catch (Exception e7) {
            e = e7;
            objectInputStream = null;
            fileInputStream = null;
            this.values = new HashMap();
            C4990ab.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "openCfg Exception!", new Object[0]);
            this.xIr = true;
            if (objectInputStream != null) {
            }
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(58957);
            return;
        } catch (Throwable th3) {
            e = th3;
            objectInputStream = null;
            fileInputStream = null;
            if (objectInputStream != null) {
            }
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(58957);
            throw e;
        }
        return;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098 A:{SYNTHETIC, Splitter:B:30:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009d A:{Catch:{ Exception -> 0x00a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b4 A:{SYNTHETIC, Splitter:B:42:0x00b4} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b9 A:{Catch:{ Exception -> 0x00c3 }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b4 A:{SYNTHETIC, Splitter:B:42:0x00b4} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b9 A:{Catch:{ Exception -> 0x00c3 }} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098 A:{SYNTHETIC, Splitter:B:30:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009d A:{Catch:{ Exception -> 0x00a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b4 A:{SYNTHETIC, Splitter:B:42:0x00b4} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b9 A:{Catch:{ Exception -> 0x00c3 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Lv */
    private synchronized void m7824Lv() {
        Throwable e;
        ObjectOutputStream objectOutputStream;
        FileOutputStream fileOutputStream;
        AppMethodBeat.m2504i(58958);
        FileOutputStream fileOutputStream2;
        ObjectOutputStream objectOutputStream2;
        try {
            long anU = C5046bo.anU();
            fileOutputStream2 = new FileOutputStream(this.filePath);
            try {
                objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);
                try {
                    objectOutputStream2.writeObject(this.values);
                    fileOutputStream2.flush();
                    this.xIs = false;
                    C4990ab.m7411d("MicroMsg.ConfigFileStorage", "writeCfg end, keys count:%d time:%d", Integer.valueOf(this.values.keySet().toArray().length), Long.valueOf(C5046bo.m7566gb(anU)));
                    try {
                        objectOutputStream2.close();
                        fileOutputStream2.close();
                        AppMethodBeat.m2505o(58958);
                    } catch (Exception e2) {
                        AppMethodBeat.m2505o(58958);
                    }
                } catch (IOException e3) {
                    e = e3;
                    objectOutputStream = objectOutputStream2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        C4990ab.m7413e("MicroMsg.ConfigFileStorage", "exception:%s", C5046bo.m7574l(e));
                        C4990ab.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "writeCfg", new Object[0]);
                        C7053e.pXa.mo8378a(1041, 19, 1, true);
                        this.xIs = true;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e4) {
                                AppMethodBeat.m2505o(58958);
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        AppMethodBeat.m2505o(58958);
                        return;
                    } catch (Throwable th) {
                        e = th;
                        objectOutputStream2 = objectOutputStream;
                        fileOutputStream2 = fileOutputStream;
                        if (objectOutputStream2 != null) {
                        }
                        if (fileOutputStream2 != null) {
                        }
                        AppMethodBeat.m2505o(58958);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (Exception e5) {
                            AppMethodBeat.m2505o(58958);
                            throw e;
                        }
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    AppMethodBeat.m2505o(58958);
                    throw e;
                }
            } catch (IOException e6) {
                e = e6;
                objectOutputStream = null;
                fileOutputStream = fileOutputStream2;
                C4990ab.m7413e("MicroMsg.ConfigFileStorage", "exception:%s", C5046bo.m7574l(e));
                C4990ab.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "writeCfg", new Object[0]);
                C7053e.pXa.mo8378a(1041, 19, 1, true);
                this.xIs = true;
                if (objectOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(58958);
                return;
            } catch (Throwable th3) {
                e = th3;
                objectOutputStream2 = null;
                if (objectOutputStream2 != null) {
                }
                if (fileOutputStream2 != null) {
                }
                AppMethodBeat.m2505o(58958);
                throw e;
            }
        } catch (IOException e7) {
            e = e7;
            objectOutputStream = null;
            fileOutputStream = null;
            C4990ab.m7413e("MicroMsg.ConfigFileStorage", "exception:%s", C5046bo.m7574l(e));
            C4990ab.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "writeCfg", new Object[0]);
            C7053e.pXa.mo8378a(1041, 19, 1, true);
            this.xIs = true;
            if (objectOutputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            AppMethodBeat.m2505o(58958);
            return;
        } catch (Throwable th4) {
            e = th4;
            objectOutputStream2 = null;
            fileOutputStream2 = null;
            if (objectOutputStream2 != null) {
            }
            if (fileOutputStream2 != null) {
            }
            AppMethodBeat.m2505o(58958);
            throw e;
        }
        return;
    }

    public final synchronized void reset() {
        AppMethodBeat.m2504i(58959);
        C4990ab.m7416i("MicroMsg.ConfigFileStorage", "ConfigFileStorage reset ");
        File file = new File(this.filePath);
        if (file.exists()) {
            file.delete();
        }
        this.values = new HashMap();
        AppMethodBeat.m2505o(58959);
    }

    public final synchronized void setInt(int i, int i2) {
        AppMethodBeat.m2504i(58960);
        set(i, Integer.valueOf(i2));
        AppMethodBeat.m2505o(58960);
    }

    /* renamed from: Ml */
    public final synchronized int mo10573Ml(int i) {
        int i2;
        AppMethodBeat.m2504i(58961);
        Integer num = (Integer) get(i);
        if (num == null) {
            i2 = 0;
            AppMethodBeat.m2505o(58961);
        } else {
            i2 = num.intValue();
            AppMethodBeat.m2505o(58961);
        }
        return i2;
    }

    public final synchronized void setLong(int i, long j) {
        AppMethodBeat.m2504i(58962);
        set(i, Long.valueOf(j));
        AppMethodBeat.m2505o(58962);
    }

    public synchronized long getLong(int i, long j) {
        AppMethodBeat.m2504i(58963);
        Long l = (Long) get(i);
        if (l == null) {
            AppMethodBeat.m2505o(58963);
        } else {
            j = l.longValue();
            AppMethodBeat.m2505o(58963);
        }
        return j;
    }
}
