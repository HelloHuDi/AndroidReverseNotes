package c.t.m.c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class e {
    private static final byte[] b = new byte[0];
    private static e j;
    private final String a = "DexAsynchHandler";
    private HandlerThread c;
    private a d;
    private boolean e;
    private Context f;
    private k g;
    private SimpleDateFormat h = new SimpleDateFormat("HHmmss");
    private SimpleDateFormat i = new SimpleDateFormat("yyyyMMdd-HHmmss");

    class a extends Handler {
        private StringBuilder b = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);

        public a(Looper looper) {
            super(looper);
            AppMethodBeat.i(136343);
            AppMethodBeat.o(136343);
        }

        public void handleMessage(Message message) {
            AppMethodBeat.i(136344);
            super.handleMessage(message);
            a(message);
            AppMethodBeat.o(136344);
        }

        public void a(Message message) {
            AppMethodBeat.i(136345);
            try {
                switch (message.what) {
                    case 10001:
                        AppMethodBeat.o(136345);
                        return;
                    case 10002:
                        AppMethodBeat.o(136345);
                        return;
                    case 10003:
                        AppMethodBeat.o(136345);
                        return;
                    case 10004:
                        AppMethodBeat.o(136345);
                        return;
                    case 10005:
                        new h(e.this.f).a();
                        AppMethodBeat.o(136345);
                        return;
                    case 10006:
                        AppMethodBeat.o(136345);
                        return;
                    case CdnLogic.kMediaTypeFavoriteBigFile /*10007*/:
                        AppMethodBeat.o(136345);
                        return;
                    default:
                        AppMethodBeat.o(136345);
                        return;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(136345);
            }
            AppMethodBeat.o(136345);
        }
    }

    private e(Context context) {
        AppMethodBeat.i(136346);
        this.f = context.getApplicationContext();
        this.g = new k(this.f);
        AppMethodBeat.o(136346);
    }

    public static e a(Context context) {
        AppMethodBeat.i(136347);
        if (j == null) {
            synchronized (e.class) {
                try {
                    if (j == null) {
                        j = new e(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(136347);
                    }
                }
            }
        }
        e eVar = j;
        AppMethodBeat.o(136347);
        return eVar;
    }

    public static e a() {
        return j;
    }

    public void b() {
        AppMethodBeat.i(136348);
        if (this.e) {
            AppMethodBeat.o(136348);
            return;
        }
        this.c = new HandlerThread("d_thread");
        this.c.start();
        this.d = new a(this.c.getLooper());
        this.e = true;
        AppMethodBeat.o(136348);
    }

    public void a(String str, String str2) {
    }

    public void c() {
    }

    public void a(String str) {
        AppMethodBeat.i(136349);
        try {
            if (this.f == null || this.d == null || str == null || str.length() == 0) {
                AppMethodBeat.o(136349);
                return;
            }
            p.a = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LOC_CORE,").append(this.i.format(new Date())).append(',').append(q.e(this.f)).append(',').append(q.d(this.f)).append(',').append(q.b()).append(',').append(q.a()).append(',').append(q.c()).append(',').append("COMP").append(str).append("$");
            a(stringBuilder.toString().getBytes());
            AppMethodBeat.o(136349);
        } catch (Throwable th) {
            AppMethodBeat.o(136349);
        }
    }

    public void d() {
        AppMethodBeat.i(136350);
        if (this.f == null) {
            AppMethodBeat.o(136350);
            return;
        }
        a(10005, null);
        AppMethodBeat.o(136350);
    }

    private void a(int i, String str) {
        AppMethodBeat.i(136351);
        a aVar = this.d;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage();
            obtainMessage.obj = str;
            obtainMessage.what = i;
            o.a(aVar, obtainMessage);
        }
        AppMethodBeat.o(136351);
    }

    public boolean a(byte[] bArr) {
        AppMethodBeat.i(136352);
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    byte[] a = a(bArr, "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
                    if (a == null || a.length == 0) {
                        AppMethodBeat.o(136352);
                        return true;
                    }
                    if (p.a("https://analytics.map.qq.com/tr?mllc", a) == null) {
                        this.g.a(a);
                    }
                    AppMethodBeat.o(136352);
                    return false;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(136352);
                return false;
            }
        }
        AppMethodBeat.o(136352);
        return true;
    }

    private byte[] a(byte[] bArr, String str) {
        AppMethodBeat.i(136353);
        byte[] bArr2;
        if (bArr == null || bArr.length == 0) {
            bArr2 = b;
            AppMethodBeat.o(136353);
            return bArr2;
        }
        byte[] a = m.a(q.b(bArr), str);
        if (a == null || a.length == 0) {
            bArr2 = b;
            AppMethodBeat.o(136353);
            return bArr2;
        }
        bArr2 = new byte[(a.length + 2)];
        System.arraycopy(q.a(a.length), 0, bArr2, 0, 2);
        System.arraycopy(a, 0, bArr2, 2, a.length);
        AppMethodBeat.o(136353);
        return bArr2;
    }
}
