package com.tencent.recovery.report;

import android.content.Context;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryPersistentItem;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class RecoveryReporter {
    private static File iA(Context context) {
        File file = new File(context.getFilesDir(), "recovery");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0077 A:{SYNTHETIC, Splitter:B:20:0x0077} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081 A:{SYNTHETIC, Splitter:B:26:0x0081} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(Context context, String str, RecoveryPersistentItem recoveryPersistentItem) {
        Throwable e;
        File iA = iA(context);
        RecoveryLog.i("Recovery.RecoveryReporter", "addItem %s", recoveryPersistentItem.dQf());
        File file = new File(iA, str);
        if (file.length() > 2097152) {
            RecoveryLog.i("Recovery.RecoveryReporter", "addItem file size large than 5MB", new Object[0]);
            file.delete();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
            }
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            try {
                fileOutputStream.write((r3 + IOUtils.LINE_SEPARATOR_UNIX).getBytes());
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    RecoveryLog.printErrStackTrace("Recovery.RecoveryReporter", e, "addItem", new Object[0]);
                    if (fileOutputStream != null) {
                    }
                    return true;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                    }
                    throw e;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            RecoveryLog.printErrStackTrace("Recovery.RecoveryReporter", e, "addItem", new Object[0]);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                }
            }
            return true;
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e7) {
                }
            }
            throw e;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008e A:{SYNTHETIC, Splitter:B:20:0x008e} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009f A:{SYNTHETIC, Splitter:B:31:0x009f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(Context context, String str, List<? extends RecoveryPersistentItem> list) {
        Throwable e;
        RecoveryLog.i("Recovery.RecoveryReporter", "addItemList %s %d", str, Integer.valueOf(list.size()));
        File file = new File(iA(context), str);
        if (file.length() > 2097152) {
            RecoveryLog.i("Recovery.RecoveryReporter", "addItem file size large than 5MB", new Object[0]);
            file.delete();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
            }
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            try {
                for (RecoveryPersistentItem dQf : list) {
                    fileOutputStream.write((dQf.dQf() + IOUtils.LINE_SEPARATOR_UNIX).getBytes());
                }
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    RecoveryLog.printErrStackTrace("Recovery.RecoveryReporter", e, "addItem %s", str);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    return true;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e7) {
            e = e7;
            fileOutputStream = null;
            RecoveryLog.printErrStackTrace("Recovery.RecoveryReporter", e, "addItem %s", str);
            if (fileOutputStream != null) {
            }
            return true;
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw e;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e A:{SYNTHETIC, Splitter:B:19:0x006e} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af A:{SYNTHETIC, Splitter:B:32:0x00af} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends RecoveryPersistentItem> List<T> a(Context context, String str, Class<T> cls) {
        Throwable e;
        File iA = iA(context);
        LinkedList linkedList = new LinkedList();
        File file = new File(iA, str);
        if (file.length() > 2097152) {
            RecoveryLog.i("Recovery.RecoveryReporter", "getItemList file size large than 5MB", new Object[0]);
            file.delete();
            return linkedList;
        } else if (file.exists()) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    int read;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
                    byte[] bArr = new byte[4096];
                    while (true) {
                        read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    for (String atL : new String(byteArrayOutputStream.toByteArray()).split(IOUtils.LINE_SEPARATOR_UNIX)) {
                        RecoveryPersistentItem recoveryPersistentItem = (RecoveryPersistentItem) cls.newInstance();
                        if (recoveryPersistentItem.atL(atL)) {
                            linkedList.add(recoveryPersistentItem);
                        } else {
                            RecoveryLog.e("Recovery.RecoveryReporter", "parse item error %s", r4[r3]);
                        }
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        RecoveryLog.printErrStackTrace("Recovery.RecoveryReporter", e, "getItemList", new Object[0]);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        return linkedList;
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                        }
                        throw e;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
                RecoveryLog.printErrStackTrace("Recovery.RecoveryReporter", e, "getItemList", new Object[0]);
                if (fileInputStream != null) {
                }
                return linkedList;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                    }
                }
                throw e;
            }
            return linkedList;
        } else {
            RecoveryLog.i("Recovery.RecoveryReporter", "getItemList file not exist %s", str);
            return linkedList;
        }
    }

    public static void bX(Context context, String str) {
        new File(iA(context), str).delete();
    }
}
