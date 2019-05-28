package com.tencent.liteav.p1167a;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.audio.C8790b;
import com.tencent.liteav.audio.C8792d;
import com.tencent.liteav.audio.impl.Record.C41677e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p811g.C25649b;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.muxer.C8818c;
import com.tencent.liteav.videoencoder.C0982d;
import com.tencent.liteav.videoencoder.C37378a;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.tencent.liteav.a.a */
public class C37346a implements C8792d, C0982d {
    /* renamed from: a */
    private C41677e f15861a = new C41677e();
    /* renamed from: b */
    private C37378a f15862b = new C37378a();
    /* renamed from: c */
    private C8818c f15863c;
    /* renamed from: d */
    private C37345a f15864d;
    /* renamed from: e */
    private C37347b f15865e;
    /* renamed from: f */
    private long f15866f = 0;
    /* renamed from: g */
    private long f15867g = -1;
    /* renamed from: h */
    private boolean f15868h = false;
    /* renamed from: i */
    private Handler f15869i = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            AppMethodBeat.m2504i(66365);
            if (C37346a.this.f15865e != null) {
                switch (message.what) {
                    case 1:
                        C37346a.this.f15865e.mo32903a(((Long) message.obj).longValue());
                        AppMethodBeat.m2505o(66365);
                        return;
                    case 2:
                        TXCLog.m15675d("TXCStreamRecord", "record complete. errcode = " + message.arg1 + ", errmsg = " + ((String) message.obj) + ", outputPath = " + C37346a.this.f15864d.f15856f + ", coverImage = " + C37346a.this.f15864d.f15857g);
                        if (!(message.arg1 != 0 || C37346a.this.f15864d.f15857g == null || C37346a.this.f15864d.f15857g.isEmpty() || C17778b.m27746a(C37346a.this.f15864d.f15856f, C37346a.this.f15864d.f15857g))) {
                            TXCLog.m15676e("TXCStreamRecord", "saveVideoThumb error. sourcePath = " + C37346a.this.f15864d.f15856f + ", coverImagePath = " + C37346a.this.f15864d.f15857g);
                        }
                        if (message.arg1 != 0) {
                            try {
                                File file = new File(C37346a.this.f15864d.f15856f);
                                if (file.exists()) {
                                    file.delete();
                                }
                            } catch (Exception e) {
                            }
                        }
                        C37346a.this.f15865e.mo32902a(message.arg1, (String) message.obj, C37346a.this.f15864d.f15856f, C37346a.this.f15864d.f15857g);
                        break;
                }
            }
            AppMethodBeat.m2505o(66365);
        }
    };

    /* renamed from: com.tencent.liteav.a.a$a */
    public static class C37345a {
        /* renamed from: a */
        public int f15851a = 544;
        /* renamed from: b */
        public int f15852b = VideoFilterUtil.IMAGE_HEIGHT;
        /* renamed from: c */
        public int f15853c = 20;
        /* renamed from: d */
        public int f15854d = 1000;
        /* renamed from: e */
        public EGLContext f15855e;
        /* renamed from: f */
        public String f15856f;
        /* renamed from: g */
        public String f15857g;
        /* renamed from: h */
        public int f15858h = 0;
        /* renamed from: i */
        public int f15859i = 0;
        /* renamed from: j */
        public int f15860j = 16;

        public String toString() {
            AppMethodBeat.m2504i(66366);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TXCStreamRecordParams: [width=" + this.f15851a);
            stringBuilder.append("; height=" + this.f15852b);
            stringBuilder.append("; fps=" + this.f15853c);
            stringBuilder.append("; bitrate=" + this.f15854d);
            stringBuilder.append("; channels=" + this.f15858h);
            stringBuilder.append("; samplerate=" + this.f15859i);
            stringBuilder.append("; bits=" + this.f15860j);
            stringBuilder.append("; EGLContext=" + this.f15855e);
            stringBuilder.append("; coveriamge=" + this.f15857g);
            stringBuilder.append("; outputpath=" + this.f15856f + "]");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(66366);
            return stringBuilder2;
        }
    }

    /* renamed from: com.tencent.liteav.a.a$b */
    public interface C37347b {
        /* renamed from: a */
        void mo32902a(int i, String str, String str2, String str3);

        /* renamed from: a */
        void mo32903a(long j);
    }

    public C37346a(Context context) {
        AppMethodBeat.m2504i(66367);
        this.f15863c = new C8818c(context, 1);
        AppMethodBeat.m2505o(66367);
    }

    /* renamed from: a */
    public void mo60061a(C37347b c37347b) {
        this.f15865e = c37347b;
    }

    /* renamed from: a */
    public void mo60060a(C37345a c37345a) {
        AppMethodBeat.m2504i(66368);
        this.f15864d = c37345a;
        this.f15866f = 0;
        this.f15867g = -1;
        this.f15863c.mo19919a(this.f15864d.f15856f);
        if (c37345a.f15858h > 0 && c37345a.f15859i > 0 && c37345a.f15860j > 0) {
            this.f15861a.mo67224a(C8790b.f2449f, c37345a.f15859i, c37345a.f15858h, c37345a.f15860j, new WeakReference(this));
            this.f15863c.mo19923b(C17778b.m27736a(this.f15864d.f15859i, this.f15864d.f15858h, 2));
            this.f15868h = true;
        }
        this.f15862b.setListener(this);
        TXSVideoEncoderParam tXSVideoEncoderParam = new TXSVideoEncoderParam();
        tXSVideoEncoderParam.width = this.f15864d.f15851a;
        tXSVideoEncoderParam.height = this.f15864d.f15852b;
        tXSVideoEncoderParam.fps = this.f15864d.f15853c;
        tXSVideoEncoderParam.glContext = this.f15864d.f15855e;
        tXSVideoEncoderParam.annexb = true;
        tXSVideoEncoderParam.appendSpsPps = false;
        this.f15862b.setBitrate(this.f15864d.f15854d);
        this.f15862b.start(tXSVideoEncoderParam);
        AppMethodBeat.m2505o(66368);
    }

    /* renamed from: a */
    public void mo60058a() {
        AppMethodBeat.m2504i(66369);
        this.f15868h = false;
        this.f15861a.mo67223a();
        this.f15862b.stop();
        if (this.f15863c.mo19922b() < 0) {
            this.f15869i.sendMessage(Message.obtain(this.f15869i, 2, 1, 0, "mp4合成失败"));
            AppMethodBeat.m2505o(66369);
            return;
        }
        this.f15869i.sendMessage(Message.obtain(this.f15869i, 2, 0, 0, ""));
        AppMethodBeat.m2505o(66369);
    }

    /* renamed from: a */
    public void mo60059a(int i, long j) {
        AppMethodBeat.m2504i(66370);
        this.f15862b.pushVideoFrame(i, this.f15864d.f15851a, this.f15864d.f15852b, j);
        AppMethodBeat.m2505o(66370);
    }

    /* renamed from: a */
    public void mo60062a(byte[] bArr, long j) {
        AppMethodBeat.m2504i(66371);
        if (this.f15868h) {
            this.f15861a.mo67225a(bArr, j);
            AppMethodBeat.m2505o(66371);
            return;
        }
        TXCLog.m15676e("TXCStreamRecord", "drainAudio fail because of not init yet!");
        AppMethodBeat.m2505o(66371);
    }

    /* renamed from: a */
    public static String m62733a(Context context, String str) {
        String str2 = null;
        AppMethodBeat.m2504i(66372);
        if (context == null) {
            AppMethodBeat.m2505o(66372);
        } else {
            try {
                String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(Long.valueOf(String.valueOf(System.currentTimeMillis() / 1000) + "000").longValue()));
                str2 = new File(C37346a.m62732a(context), String.format("TXUGC_%s".concat(String.valueOf(str)), new Object[]{format})).getAbsolutePath();
                AppMethodBeat.m2505o(66372);
            } catch (Exception e) {
                AppMethodBeat.m2505o(66372);
            }
        }
        return str2;
    }

    /* renamed from: a */
    private static String m62732a(Context context) {
        String path;
        AppMethodBeat.m2504i(66373);
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            path = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getPath();
        } else {
            path = context.getFilesDir().getPath();
        }
        AppMethodBeat.m2505o(66373);
        return path;
    }

    /* renamed from: a */
    private String m62731a(int i) {
        Object obj;
        AppMethodBeat.m2504i(66374);
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
        this.f15869i.sendMessage(Message.obtain(this.f15869i, 2, 1, 0, obj));
        AppMethodBeat.m2505o(66374);
        return obj;
    }

    /* renamed from: a */
    public void mo19857a(byte[] bArr, long j, int i, int i2, int i3, boolean z) {
    }

    /* renamed from: a */
    public void mo19856a(byte[] bArr, long j, int i, int i2, int i3) {
    }

    /* renamed from: b */
    public void mo19858b(byte[] bArr, long j, int i, int i2, int i3) {
        AppMethodBeat.m2504i(66375);
        this.f15863c.mo19921a(bArr, 0, bArr.length, 1000 * j, 1);
        AppMethodBeat.m2505o(66375);
    }

    /* renamed from: a */
    public void mo19855a(int i, String str) {
    }

    /* renamed from: a */
    public void mo3950a(C25649b c25649b, int i) {
        AppMethodBeat.m2504i(66376);
        if (i == 0) {
            this.f15863c.mo19925b(c25649b.f5251a, 0, c25649b.f5251a.length, c25649b.f5257g * 1000, c25649b.f5261k.flags);
            if (this.f15867g < 0) {
                this.f15867g = c25649b.f5257g;
            }
            if (c25649b.f5257g > this.f15866f + 500) {
                this.f15869i.sendMessage(Message.obtain(this.f15869i, 1, new Long(c25649b.f5257g - this.f15867g)));
                this.f15866f = c25649b.f5257g;
                AppMethodBeat.m2505o(66376);
                return;
            }
        }
        TXCLog.m15676e("TXCStreamRecord", "video encode error! errmsg: ".concat(String.valueOf(m62731a(i))));
        AppMethodBeat.m2505o(66376);
    }

    /* renamed from: a */
    public void mo3949a(MediaFormat mediaFormat) {
        AppMethodBeat.m2504i(66377);
        this.f15863c.mo19918a(mediaFormat);
        if (this.f15863c.mo19926c() && this.f15863c.mo19917a() < 0) {
            this.f15869i.sendMessage(Message.obtain(this.f15869i, 2, 1, 0, "mp4封装器启动失败"));
        }
        AppMethodBeat.m2505o(66377);
    }
}
