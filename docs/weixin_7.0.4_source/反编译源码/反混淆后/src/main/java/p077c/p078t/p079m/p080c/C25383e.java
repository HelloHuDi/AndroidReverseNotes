package p077c.p078t.p079m.p080c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: c.t.m.c.e */
public class C25383e {
    /* renamed from: b */
    private static final byte[] f5199b = new byte[0];
    /* renamed from: j */
    private static C25383e f5200j;
    /* renamed from: a */
    private final String f5201a = "DexAsynchHandler";
    /* renamed from: c */
    private HandlerThread f5202c;
    /* renamed from: d */
    private C25384a f5203d;
    /* renamed from: e */
    private boolean f5204e;
    /* renamed from: f */
    private Context f5205f;
    /* renamed from: g */
    private C31904k f5206g;
    /* renamed from: h */
    private SimpleDateFormat f5207h = new SimpleDateFormat("HHmmss");
    /* renamed from: i */
    private SimpleDateFormat f5208i = new SimpleDateFormat("yyyyMMdd-HHmmss");

    /* renamed from: c.t.m.c.e$a */
    class C25384a extends Handler {
        /* renamed from: b */
        private StringBuilder f5210b = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);

        public C25384a(Looper looper) {
            super(looper);
            AppMethodBeat.m2504i(136343);
            AppMethodBeat.m2505o(136343);
        }

        public void handleMessage(Message message) {
            AppMethodBeat.m2504i(136344);
            super.handleMessage(message);
            mo42402a(message);
            AppMethodBeat.m2505o(136344);
        }

        /* renamed from: a */
        public void mo42402a(Message message) {
            AppMethodBeat.m2504i(136345);
            try {
                switch (message.what) {
                    case 10001:
                        AppMethodBeat.m2505o(136345);
                        return;
                    case 10002:
                        AppMethodBeat.m2505o(136345);
                        return;
                    case 10003:
                        AppMethodBeat.m2505o(136345);
                        return;
                    case 10004:
                        AppMethodBeat.m2505o(136345);
                        return;
                    case 10005:
                        new C31902h(C25383e.this.f5205f).mo52015a();
                        AppMethodBeat.m2505o(136345);
                        return;
                    case 10006:
                        AppMethodBeat.m2505o(136345);
                        return;
                    case CdnLogic.kMediaTypeFavoriteBigFile /*10007*/:
                        AppMethodBeat.m2505o(136345);
                        return;
                    default:
                        AppMethodBeat.m2505o(136345);
                        return;
                }
            } catch (Throwable th) {
                AppMethodBeat.m2505o(136345);
            }
            AppMethodBeat.m2505o(136345);
        }
    }

    private C25383e(Context context) {
        AppMethodBeat.m2504i(136346);
        this.f5205f = context.getApplicationContext();
        this.f5206g = new C31904k(this.f5205f);
        AppMethodBeat.m2505o(136346);
    }

    /* renamed from: a */
    public static C25383e m40076a(Context context) {
        AppMethodBeat.m2504i(136347);
        if (f5200j == null) {
            synchronized (C25383e.class) {
                try {
                    if (f5200j == null) {
                        f5200j = new C25383e(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(136347);
                    }
                }
            }
        }
        C25383e c25383e = f5200j;
        AppMethodBeat.m2505o(136347);
        return c25383e;
    }

    /* renamed from: a */
    public static C25383e m40075a() {
        return f5200j;
    }

    /* renamed from: b */
    public void mo42399b() {
        AppMethodBeat.m2504i(136348);
        if (this.f5204e) {
            AppMethodBeat.m2505o(136348);
            return;
        }
        this.f5202c = new HandlerThread("d_thread");
        this.f5202c.start();
        this.f5203d = new C25384a(this.f5202c.getLooper());
        this.f5204e = true;
        AppMethodBeat.m2505o(136348);
    }

    /* renamed from: a */
    public void mo42397a(String str, String str2) {
    }

    /* renamed from: c */
    public void mo42400c() {
    }

    /* renamed from: a */
    public void mo42396a(String str) {
        AppMethodBeat.m2504i(136349);
        try {
            if (this.f5205f == null || this.f5203d == null || str == null || str.length() == 0) {
                AppMethodBeat.m2505o(136349);
                return;
            }
            C0733p.f1026a = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LOC_CORE,").append(this.f5208i.format(new Date())).append(',').append(C37150q.m62232e(this.f5205f)).append(',').append(C37150q.m62230d(this.f5205f)).append(',').append(C37150q.m62218b()).append(',').append(C37150q.m62204a()).append(',').append(C37150q.m62225c()).append(',').append("COMP").append(str).append("$");
            mo42398a(stringBuilder.toString().getBytes());
            AppMethodBeat.m2505o(136349);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(136349);
        }
    }

    /* renamed from: d */
    public void mo42401d() {
        AppMethodBeat.m2504i(136350);
        if (this.f5205f == null) {
            AppMethodBeat.m2505o(136350);
            return;
        }
        m40077a(10005, null);
        AppMethodBeat.m2505o(136350);
    }

    /* renamed from: a */
    private void m40077a(int i, String str) {
        AppMethodBeat.m2504i(136351);
        C25384a c25384a = this.f5203d;
        if (c25384a != null) {
            Message obtainMessage = c25384a.obtainMessage();
            obtainMessage.obj = str;
            obtainMessage.what = i;
            C0732o.m1687a(c25384a, obtainMessage);
        }
        AppMethodBeat.m2505o(136351);
    }

    /* renamed from: a */
    public boolean mo42398a(byte[] bArr) {
        AppMethodBeat.m2504i(136352);
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    byte[] a = m40078a(bArr, "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
                    if (a == null || a.length == 0) {
                        AppMethodBeat.m2505o(136352);
                        return true;
                    }
                    if (C0733p.m1691a("https://analytics.map.qq.com/tr?mllc", a) == null) {
                        this.f5206g.mo52018a(a);
                    }
                    AppMethodBeat.m2505o(136352);
                    return false;
                }
            } catch (Throwable th) {
                AppMethodBeat.m2505o(136352);
                return false;
            }
        }
        AppMethodBeat.m2505o(136352);
        return true;
    }

    /* renamed from: a */
    private byte[] m40078a(byte[] bArr, String str) {
        AppMethodBeat.m2504i(136353);
        byte[] bArr2;
        if (bArr == null || bArr.length == 0) {
            bArr2 = f5199b;
            AppMethodBeat.m2505o(136353);
            return bArr2;
        }
        byte[] a = C17501m.m27324a(C37150q.m62224b(bArr), str);
        if (a == null || a.length == 0) {
            bArr2 = f5199b;
            AppMethodBeat.m2505o(136353);
            return bArr2;
        }
        bArr2 = new byte[(a.length + 2)];
        System.arraycopy(C37150q.m62215a(a.length), 0, bArr2, 0, 2);
        System.arraycopy(a, 0, bArr2, 2, a.length);
        AppMethodBeat.m2505o(136353);
        return bArr2;
    }
}
