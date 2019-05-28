package com.tencent.qqmusic.mediaplayer.perf;

import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Xml;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlSerializer;

public class PrefInfoCollector implements PlayerInfoCollector {
    private static final String ENCODING_UTF_8 = "utf-8";
    private static final String FILE_NAME = "pref_infos.xml";
    private static final String NAMESPACE = null;
    private static final String ROOT = "root";
    private static final String TAG = PrefInfoCollector.class.getSimpleName();
    private static PrefInfoCollector instance;
    private HandlerThread mHandlerThread;
    private Handler mReportHandler;
    private FileOutputStream outputStream;
    private HashMap<String, Long> prefInfos;
    private String reportFilePath;
    private XmlSerializer xmlSerializer;

    /* renamed from: com.tencent.qqmusic.mediaplayer.perf.PrefInfoCollector$1 */
    class C161281 implements Comparator<Entry<String, Long>> {
        C161281() {
        }

        public int compare(Entry<String, Long> entry, Entry<String, Long> entry2) {
            AppMethodBeat.m2504i(128436);
            if (((String) entry.getKey()).charAt(0) > ((String) entry2.getKey()).charAt(0)) {
                AppMethodBeat.m2505o(128436);
                return 1;
            } else if (((String) entry.getKey()).charAt(0) == ((String) entry2.getKey()).charAt(0)) {
                AppMethodBeat.m2505o(128436);
                return 0;
            } else {
                AppMethodBeat.m2505o(128436);
                return -1;
            }
        }
    }

    static /* synthetic */ void access$000(PrefInfoCollector prefInfoCollector) {
        AppMethodBeat.m2504i(128415);
        prefInfoCollector.createOutputs();
        AppMethodBeat.m2505o(128415);
    }

    static /* synthetic */ void access$100(PrefInfoCollector prefInfoCollector, AudioInformation audioInformation) {
        AppMethodBeat.m2504i(128416);
        prefInfoCollector.printPrefInfos(audioInformation);
        AppMethodBeat.m2505o(128416);
    }

    static /* synthetic */ void access$200(PrefInfoCollector prefInfoCollector) {
        AppMethodBeat.m2504i(128417);
        prefInfoCollector.upLoadByCommonPost();
        AppMethodBeat.m2505o(128417);
    }

    static {
        AppMethodBeat.m2504i(128418);
        AppMethodBeat.m2505o(128418);
    }

    private PrefInfoCollector() {
        AppMethodBeat.m2504i(128406);
        this.prefInfos = null;
        this.xmlSerializer = null;
        this.prefInfos = new HashMap();
        this.xmlSerializer = Xml.newSerializer();
        AppMethodBeat.m2505o(128406);
    }

    public static synchronized PrefInfoCollector getInstance() {
        PrefInfoCollector prefInfoCollector;
        synchronized (PrefInfoCollector.class) {
            AppMethodBeat.m2504i(128407);
            if (instance == null) {
                instance = new PrefInfoCollector();
            }
            prefInfoCollector = instance;
            AppMethodBeat.m2505o(128407);
        }
        return prefInfoCollector;
    }

    public void putInt(String str, int i) {
    }

    public void putLong(String str, long j) {
        AppMethodBeat.m2504i(128408);
        this.prefInfos.put(str, Long.valueOf(j));
        AppMethodBeat.m2505o(128408);
    }

    public void putBoolean(String str, boolean z) {
    }

    public void putString(String str, String str2) {
    }

    public void putUri(String str, Uri uri) {
    }

    private void createOutputs() {
        RuntimeException runtimeException;
        AppMethodBeat.m2504i(128409);
        try {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), FILE_NAME);
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }
            Logger.m71020d(TAG, "setInstrumentation: outputFile: ".concat(String.valueOf(file)));
            this.reportFilePath = file.getAbsolutePath();
            this.outputStream = new FileOutputStream(file);
            Logger.m71020d(TAG, "setInstrumentation: outputFilepath: " + this.reportFilePath);
            try {
                this.xmlSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                this.xmlSerializer.setOutput(this.outputStream, "utf-8");
                this.xmlSerializer.startDocument("utf-8", Boolean.TRUE);
                AppMethodBeat.m2505o(128409);
            } catch (IOException e) {
                Logger.m71022e(TAG, "Unable to open serializer", e);
                runtimeException = new RuntimeException("Unable to open serializer: " + e.getMessage(), e);
                AppMethodBeat.m2505o(128409);
                throw runtimeException;
            }
        } catch (FileNotFoundException e2) {
            Logger.m71022e(TAG, "Unable to open report file: pref_infos.xml", e2);
            runtimeException = new RuntimeException("Unable to open report file: " + e2.getMessage(), e2);
            AppMethodBeat.m2505o(128409);
            throw runtimeException;
        } catch (IOException e22) {
            Logger.m71022e(TAG, "Unable to create report file: pref_infos.xml", e22);
            runtimeException = new RuntimeException("Unable to create report file: " + e22.getMessage(), e22);
            AppMethodBeat.m2505o(128409);
            throw runtimeException;
        }
    }

    public void printAudioInfomation(AudioInformation audioInformation) {
        AppMethodBeat.m2504i(128410);
        printProperty("audio.format", audioInformation.getAudioType());
        printProperty("audio.sampleRate", audioInformation.getSampleRate());
        printProperty("audio.PlaySample", audioInformation.getPlaySample());
        printProperty("audio.bitDepth", audioInformation.getBitDept());
        printProperty("audio.channels", audioInformation.getChannels());
        printProperty("audio.duration", audioInformation.getDuration());
        printProperty("audio.bitRate", audioInformation.getBitrate());
        AppMethodBeat.m2505o(128410);
    }

    private void printProperty(String str, String str2) {
        AppMethodBeat.m2504i(128411);
        this.xmlSerializer.startTag(NAMESPACE, str);
        this.xmlSerializer.text(str2);
        this.xmlSerializer.endTag(NAMESPACE, str);
        AppMethodBeat.m2505o(128411);
    }

    private void printPrefInfos(AudioInformation audioInformation) {
        AppMethodBeat.m2504i(128412);
        ArrayList<Entry> arrayList = new ArrayList(this.prefInfos.entrySet());
        Collections.sort(arrayList, new C161281());
        if (!arrayList.isEmpty()) {
            this.xmlSerializer.startTag(NAMESPACE, ROOT);
            printProperty("device.manufacturer", Build.MANUFACTURER);
            printProperty("device.model", Build.MODEL);
            printProperty("device.apiLevel", String.valueOf(VERSION.SDK_INT));
            printAudioInfomation(audioInformation);
            for (Entry entry : arrayList) {
                printProperty((String) entry.getKey(), String.valueOf(((Long) entry.getValue()).longValue()));
            }
            this.xmlSerializer.endTag(NAMESPACE, ROOT);
            this.xmlSerializer.endDocument();
            this.xmlSerializer.flush();
        }
        AppMethodBeat.m2505o(128412);
    }

    private void upLoadByCommonPost() {
        AppMethodBeat.m2504i(128413);
        Logger.m71025i(TAG, "upLoadByCommonPost");
        String str = IOUtils.LINE_SEPARATOR_WINDOWS;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(" http://musict.proxy.music.qq.com/qmtm2/PlayPerformanceReport.fcg").openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        httpURLConnection.setRequestProperty("Content-Type", "text/xml");
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        FileInputStream fileInputStream = new FileInputStream(this.reportFilePath);
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                dataOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                dataOutputStream.writeBytes(str);
                dataOutputStream.flush();
                InputStream inputStream = httpURLConnection.getInputStream();
                Logger.m71025i(TAG, "upload result:".concat(String.valueOf(new BufferedReader(new InputStreamReader(inputStream, "UTF-8")).readLine())));
                dataOutputStream.close();
                inputStream.close();
                AppMethodBeat.m2505o(128413);
                return;
            }
        }
    }

    public void upLoadPrefInfos(final AudioInformation audioInformation) {
        AppMethodBeat.m2504i(128414);
        if (this.prefInfos == null || this.prefInfos.isEmpty()) {
            AppMethodBeat.m2505o(128414);
            return;
        }
        if (this.mHandlerThread == null || this.mReportHandler == null) {
            this.mHandlerThread = new HandlerThread("PrefInfoCollector");
            this.mHandlerThread.start();
            this.mReportHandler = new Handler(this.mHandlerThread.getLooper());
        }
        this.mReportHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(128431);
                try {
                    PrefInfoCollector.access$000(PrefInfoCollector.this);
                    PrefInfoCollector.access$100(PrefInfoCollector.this, audioInformation);
                    PrefInfoCollector.access$200(PrefInfoCollector.this);
                    AppMethodBeat.m2505o(128431);
                } catch (Exception e) {
                    Logger.m71024e(PrefInfoCollector.TAG, e);
                    AppMethodBeat.m2505o(128431);
                }
            }
        });
        AppMethodBeat.m2505o(128414);
    }
}
