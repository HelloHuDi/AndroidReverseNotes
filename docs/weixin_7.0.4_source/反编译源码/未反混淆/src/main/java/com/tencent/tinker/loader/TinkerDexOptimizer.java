package com.tencent.tinker.loader;

import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class TinkerDexOptimizer {

    static class OptimizeWorker {
        private static String ACC = null;
        private final boolean ABR;
        private final File ACD;
        private final File ACE;
        private final ResultCallback ACF;

        OptimizeWorker(File file, File file2, boolean z, String str, ResultCallback resultCallback) {
            this.ACD = file;
            this.ACE = file2;
            this.ABR = z;
            this.ACF = resultCallback;
            ACC = str;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:38:0x0131=Splitter:B:38:0x0131, B:48:0x015b=Splitter:B:48:0x015b} */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean dSk() {
            try {
                if (SharePatchFileUtil.ap(this.ACD) || this.ACF == null) {
                    if (this.ACF != null) {
                        this.ACF.ai(this.ACD);
                    }
                    String k = SharePatchFileUtil.k(this.ACD, this.ACE);
                    if (this.ABR) {
                        String absolutePath = this.ACD.getAbsolutePath();
                        File file = new File(k);
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                        }
                        File file2 = new File(file.getParentFile(), "interpret.lock");
                        ShareFileLockHelper shareFileLockHelper = null;
                        try {
                            shareFileLockHelper = ShareFileLockHelper.ao(file2);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add("dex2oat");
                            if (VERSION.SDK_INT >= 24) {
                                arrayList.add("--runtime-arg");
                                arrayList.add("-classpath");
                                arrayList.add("--runtime-arg");
                                arrayList.add("&");
                            }
                            arrayList.add("--dex-file=".concat(String.valueOf(absolutePath)));
                            arrayList.add("--oat-file=".concat(String.valueOf(k)));
                            arrayList.add("--instruction-set=" + ACC);
                            if (VERSION.SDK_INT > 25) {
                                arrayList.add("--compiler-filter=quicken");
                            } else {
                                arrayList.add("--compiler-filter=interpret-only");
                            }
                            ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
                            processBuilder.redirectErrorStream(true);
                            Process start = processBuilder.start();
                            StreamConsumer.L(start.getInputStream());
                            StreamConsumer.L(start.getErrorStream());
                            int waitFor = start.waitFor();
                            if (waitFor != 0) {
                                throw new IOException("dex2oat works unsuccessfully, exit code: ".concat(String.valueOf(waitFor)));
                            }
                            try {
                                shareFileLockHelper.close();
                            } catch (IOException e) {
                            }
                        } catch (InterruptedException e2) {
                            throw new IOException("dex2oat is interrupted, msg: " + e2.getMessage(), e2);
                        } catch (Throwable th) {
                            if (shareFileLockHelper != null) {
                                try {
                                    shareFileLockHelper.close();
                                } catch (IOException e3) {
                                }
                            }
                        }
                    } else {
                        DexFile.loadDex(this.ACD.getAbsolutePath(), k, 0);
                    }
                    if (this.ACF != null) {
                        this.ACF.i(this.ACD, new File(k));
                    }
                    return true;
                }
                this.ACF.b(this.ACD, new IOException("dex file " + this.ACD.getAbsolutePath() + " is not exist!"));
                return false;
            } catch (Throwable th2) {
                new StringBuilder("Failed to optimize dex: ").append(this.ACD.getAbsolutePath());
                if (this.ACF != null) {
                    this.ACF.b(this.ACD, th2);
                    return false;
                }
            }
        }
    }

    public interface ResultCallback {
        void ai(File file);

        void b(File file, Throwable th);

        void i(File file, File file2);
    }

    static class StreamConsumer {
        static final Executor ACG = Executors.newSingleThreadExecutor();

        private StreamConsumer() {
        }

        static void L(final InputStream inputStream) {
            ACG.execute(new Runnable() {
                public final void run() {
                    if (inputStream != null) {
                        do {
                            try {
                            } catch (IOException e) {
                                try {
                                    inputStream.close();
                                    return;
                                } catch (Exception e2) {
                                    return;
                                }
                            } catch (Throwable th) {
                                try {
                                    inputStream.close();
                                } catch (Exception e3) {
                                }
                                throw th;
                            }
                        } while (inputStream.read(new byte[256]) > 0);
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                }
            });
        }
    }

    public static boolean a(Collection<File> collection, File file, ResultCallback resultCallback) {
        return a(collection, file, false, null, resultCallback);
    }

    public static boolean a(Collection<File> collection, File file, boolean z, String str, ResultCallback resultCallback) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, new Comparator<File>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                long length = ((File) obj).length() - ((File) obj2).length();
                if (length > 0) {
                    return 1;
                }
                if (length == 0) {
                    return 0;
                }
                return -1;
            }
        });
        Collections.reverse(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!new OptimizeWorker((File) it.next(), file, z, str, resultCallback).dSk()) {
                return false;
            }
        }
        return true;
    }
}
