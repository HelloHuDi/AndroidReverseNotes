package com.tencent.liteav.a;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.impl.Record.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.muxer.c;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.microedition.khronos.egl.EGLContext;

public class a implements d, com.tencent.liteav.videoencoder.d {
    private e a = new e();
    private com.tencent.liteav.videoencoder.a b = new com.tencent.liteav.videoencoder.a();
    private c c;
    private a d;
    private b e;
    private long f = 0;
    private long g = -1;
    private boolean h = false;
    private Handler i = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            AppMethodBeat.i(66365);
            if (a.this.e != null) {
                switch (message.what) {
                    case 1:
                        a.this.e.a(((Long) message.obj).longValue());
                        AppMethodBeat.o(66365);
                        return;
                    case 2:
                        TXCLog.d("TXCStreamRecord", "record complete. errcode = " + message.arg1 + ", errmsg = " + ((String) message.obj) + ", outputPath = " + a.this.d.f + ", coverImage = " + a.this.d.g);
                        if (!(message.arg1 != 0 || a.this.d.g == null || a.this.d.g.isEmpty() || com.tencent.liteav.basic.util.b.a(a.this.d.f, a.this.d.g))) {
                            TXCLog.e("TXCStreamRecord", "saveVideoThumb error. sourcePath = " + a.this.d.f + ", coverImagePath = " + a.this.d.g);
                        }
                        if (message.arg1 != 0) {
                            try {
                                File file = new File(a.this.d.f);
                                if (file.exists()) {
                                    file.delete();
                                }
                            } catch (Exception e) {
                            }
                        }
                        a.this.e.a(message.arg1, (String) message.obj, a.this.d.f, a.this.d.g);
                        break;
                }
            }
            AppMethodBeat.o(66365);
        }
    };

    public static class a {
        public int a = 544;
        public int b = VideoFilterUtil.IMAGE_HEIGHT;
        public int c = 20;
        public int d = 1000;
        public EGLContext e;
        public String f;
        public String g;
        public int h = 0;
        public int i = 0;
        public int j = 16;

        public String toString() {
            AppMethodBeat.i(66366);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TXCStreamRecordParams: [width=" + this.a);
            stringBuilder.append("; height=" + this.b);
            stringBuilder.append("; fps=" + this.c);
            stringBuilder.append("; bitrate=" + this.d);
            stringBuilder.append("; channels=" + this.h);
            stringBuilder.append("; samplerate=" + this.i);
            stringBuilder.append("; bits=" + this.j);
            stringBuilder.append("; EGLContext=" + this.e);
            stringBuilder.append("; coveriamge=" + this.g);
            stringBuilder.append("; outputpath=" + this.f + "]");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(66366);
            return stringBuilder2;
        }
    }

    public interface b {
        void a(int i, String str, String str2, String str3);

        void a(long j);
    }

    public a(Context context) {
        AppMethodBeat.i(66367);
        this.c = new c(context, 1);
        AppMethodBeat.o(66367);
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public void a(a aVar) {
        AppMethodBeat.i(66368);
        this.d = aVar;
        this.f = 0;
        this.g = -1;
        this.c.a(this.d.f);
        if (aVar.h > 0 && aVar.i > 0 && aVar.j > 0) {
            this.a.a(com.tencent.liteav.audio.b.f, aVar.i, aVar.h, aVar.j, new WeakReference(this));
            this.c.b(com.tencent.liteav.basic.util.b.a(this.d.i, this.d.h, 2));
            this.h = true;
        }
        this.b.setListener(this);
        TXSVideoEncoderParam tXSVideoEncoderParam = new TXSVideoEncoderParam();
        tXSVideoEncoderParam.width = this.d.a;
        tXSVideoEncoderParam.height = this.d.b;
        tXSVideoEncoderParam.fps = this.d.c;
        tXSVideoEncoderParam.glContext = this.d.e;
        tXSVideoEncoderParam.annexb = true;
        tXSVideoEncoderParam.appendSpsPps = false;
        this.b.setBitrate(this.d.d);
        this.b.start(tXSVideoEncoderParam);
        AppMethodBeat.o(66368);
    }

    public void a() {
        AppMethodBeat.i(66369);
        this.h = false;
        this.a.a();
        this.b.stop();
        if (this.c.b() < 0) {
            this.i.sendMessage(Message.obtain(this.i, 2, 1, 0, "mp4合成失败"));
            AppMethodBeat.o(66369);
            return;
        }
        this.i.sendMessage(Message.obtain(this.i, 2, 0, 0, ""));
        AppMethodBeat.o(66369);
    }

    public void a(int i, long j) {
        AppMethodBeat.i(66370);
        this.b.pushVideoFrame(i, this.d.a, this.d.b, j);
        AppMethodBeat.o(66370);
    }

    public void a(byte[] bArr, long j) {
        AppMethodBeat.i(66371);
        if (this.h) {
            this.a.a(bArr, j);
            AppMethodBeat.o(66371);
            return;
        }
        TXCLog.e("TXCStreamRecord", "drainAudio fail because of not init yet!");
        AppMethodBeat.o(66371);
    }

    public static String a(Context context, String str) {
        String str2 = null;
        AppMethodBeat.i(66372);
        if (context == null) {
            AppMethodBeat.o(66372);
        } else {
            try {
                String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(Long.valueOf(String.valueOf(System.currentTimeMillis() / 1000) + "000").longValue()));
                str2 = new File(a(context), String.format("TXUGC_%s".concat(String.valueOf(str)), new Object[]{format})).getAbsolutePath();
                AppMethodBeat.o(66372);
            } catch (Exception e) {
                AppMethodBeat.o(66372);
            }
        }
        return str2;
    }

    private static String a(Context context) {
        String path;
        AppMethodBeat.i(66373);
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            path = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getPath();
        } else {
            path = context.getFilesDir().getPath();
        }
        AppMethodBeat.o(66373);
        return path;
    }

    private String a(int i) {
        Object obj;
        AppMethodBeat.i(66374);
        switch (i) {
            case 10000002:
                obj = "未启动视频编码器";
                break;
            case 10000003:
                obj = "非法视频输入参数";
                break;
            case 10000004:
                obj = "视频编码初始化失败";
                break;
            case 10000005:
                obj = "视频编码失败";
                break;
            default:
                obj = "";
                break;
        }
        this.i.sendMessage(Message.obtain(this.i, 2, 1, 0, obj));
        AppMethodBeat.o(66374);
        return obj;
    }

    public void a(byte[] bArr, long j, int i, int i2, int i3, boolean z) {
    }

    public void a(byte[] bArr, long j, int i, int i2, int i3) {
    }

    public void b(byte[] bArr, long j, int i, int i2, int i3) {
        AppMethodBeat.i(66375);
        this.c.a(bArr, 0, bArr.length, 1000 * j, 1);
        AppMethodBeat.o(66375);
    }

    public void a(int i, String str) {
    }

    public void a(com.tencent.liteav.basic.g.b bVar, int i) {
        AppMethodBeat.i(66376);
        if (i == 0) {
            this.c.b(bVar.a, 0, bVar.a.length, bVar.g * 1000, bVar.k.flags);
            if (this.g < 0) {
                this.g = bVar.g;
            }
            if (bVar.g > this.f + 500) {
                this.i.sendMessage(Message.obtain(this.i, 1, new Long(bVar.g - this.g)));
                this.f = bVar.g;
                AppMethodBeat.o(66376);
                return;
            }
        }
        TXCLog.e("TXCStreamRecord", "video encode error! errmsg: ".concat(String.valueOf(a(i))));
        AppMethodBeat.o(66376);
    }

    public void a(MediaFormat mediaFormat) {
        AppMethodBeat.i(66377);
        this.c.a(mediaFormat);
        if (this.c.c() && this.c.a() < 0) {
            this.i.sendMessage(Message.obtain(this.i, 2, 1, 0, "mp4封装器启动失败"));
        }
        AppMethodBeat.o(66377);
    }
}
