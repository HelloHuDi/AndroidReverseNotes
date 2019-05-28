package com.tencent.ttpic.util;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.thread.VideoThreadPool;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class VideoMaterialDecoder {
    public static final String MATERIAL_PREFIX = "video_";
    private static final String TAG = VideoMaterialDecoder.class.getSimpleName();
    private static VideoMaterialDecoder ins = new VideoMaterialDecoder();
    private List<DecodeVideoTask> mTaskList = new ArrayList();

    /* renamed from: com.tencent.ttpic.util.VideoMaterialDecoder$1 */
    class C59871 implements FilenameFilter {
        C59871() {
        }

        public boolean accept(File file, String str) {
            AppMethodBeat.m2504i(84044);
            boolean endsWith = str.endsWith(VideoMaterialUtil.MP4_SUFFIX);
            AppMethodBeat.m2505o(84044);
            return endsWith;
        }
    }

    static class DecodeVideoTask extends AsyncTask<Void, Integer, Boolean> {
        private CountDownLatch countDownLatch;
        private final File dir;
        private final File[] files;

        public DecodeVideoTask(File file, File[] fileArr) {
            this.dir = file;
            this.files = fileArr;
        }

        /* Access modifiers changed, original: protected|varargs */
        public Boolean doInBackground(Void... voidArr) {
            AppMethodBeat.m2504i(84045);
            try {
                File[] fileArr = this.files;
                int length = fileArr.length;
                int i = 0;
                while (i < length) {
                    File file = fileArr[i];
                    FileUtils.deleteFiles(this.dir.getAbsolutePath(), ".png");
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file.getAbsoluteFile(), "r");
                    long length2 = randomAccessFile.length();
                    randomAccessFile.seek(length2 - 4);
                    byte[] bArr = new byte[4];
                    randomAccessFile.read(bArr);
                    int readInt = ByteUtil.readInt(bArr);
                    if (readInt <= 12 || readInt >= 400) {
                        randomAccessFile.close();
                        i++;
                    } else {
                        randomAccessFile.seek((length2 - ((long) readInt)) + 8);
                        length = (readInt - 12) / 4;
                        int[] iArr = new int[length];
                        for (i = 0; i < length; i++) {
                            randomAccessFile.read(bArr);
                            iArr[i] = ByteUtil.readInt(bArr);
                        }
                        ArrayList arrayList = new ArrayList();
                        i = 0;
                        while (true) {
                            arrayList.clear();
                            for (int i2 = 0; i2 < length; i2++) {
                                if (iArr[i2] == i) {
                                    arrayList.add(this.dir.getAbsolutePath() + File.separator + VideoMaterialUtil.getMaterialId(this.dir.getAbsolutePath()) + "_" + i2 + ".png");
                                }
                            }
                            i++;
                        }
                    }
                }
                if (this.countDownLatch != null) {
                    this.countDownLatch.countDown();
                }
            } catch (Exception e) {
                VideoMaterialDecoder.TAG;
                if (this.countDownLatch != null) {
                    this.countDownLatch.countDown();
                }
            } catch (Throwable th) {
                if (this.countDownLatch != null) {
                    this.countDownLatch.countDown();
                }
                AppMethodBeat.m2505o(84045);
            }
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.m2505o(84045);
            return bool;
        }

        public void setCountDownLatch(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }
    }

    static {
        AppMethodBeat.m2504i(84049);
        AppMethodBeat.m2505o(84049);
    }

    public static VideoMaterialDecoder getInstance() {
        return ins;
    }

    private VideoMaterialDecoder() {
        AppMethodBeat.m2504i(84047);
        AppMethodBeat.m2505o(84047);
    }

    public void saveVideoMaterialToImages(String str) {
        AppMethodBeat.m2504i(84048);
        String materialId = VideoMaterialUtil.getMaterialId(str);
        if (materialId == null || !materialId.startsWith("video_")) {
            AppMethodBeat.m2505o(84048);
            return;
        }
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            AppMethodBeat.m2505o(84048);
            return;
        }
        this.mTaskList.clear();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                File[] listFiles2 = file.listFiles(new C59871());
                if (listFiles2 != null) {
                    this.mTaskList.add(new DecodeVideoTask(file, listFiles2));
                }
            }
        }
        if (this.mTaskList.size() == 0) {
            AppMethodBeat.m2505o(84048);
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(this.mTaskList.size());
        for (DecodeVideoTask decodeVideoTask : this.mTaskList) {
            decodeVideoTask.setCountDownLatch(countDownLatch);
            decodeVideoTask.executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
        }
        try {
            countDownLatch.await();
            AppMethodBeat.m2505o(84048);
        } catch (InterruptedException e) {
            AppMethodBeat.m2505o(84048);
        }
    }
}
