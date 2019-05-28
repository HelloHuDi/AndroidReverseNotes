package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

/* renamed from: com.tencent.smtt.utils.j */
public class C24278j implements Closeable {
    /* renamed from: a */
    static final char[] f4538a = new char[]{127, 'E', 'L', 'F', 0};
    /* renamed from: b */
    final char[] f4539b = new char[16];
    /* renamed from: c */
    boolean f4540c;
    /* renamed from: d */
    C24276j[] f4541d;
    /* renamed from: e */
    C24277l[] f4542e;
    /* renamed from: f */
    byte[] f4543f;
    /* renamed from: g */
    private final C24273c f4544g;
    /* renamed from: h */
    private final C16156a f4545h;
    /* renamed from: i */
    private final C24282k[] f4546i;
    /* renamed from: j */
    private byte[] f4547j;

    /* renamed from: com.tencent.smtt.utils.j$a */
    public static abstract class C16156a {
        /* renamed from: a */
        short f3039a;
        /* renamed from: b */
        short f3040b;
        /* renamed from: c */
        int f3041c;
        /* renamed from: d */
        int f3042d;
        /* renamed from: e */
        short f3043e;
        /* renamed from: f */
        short f3044f;
        /* renamed from: g */
        short f3045g;
        /* renamed from: h */
        short f3046h;
        /* renamed from: i */
        short f3047i;
        /* renamed from: j */
        short f3048j;

        /* renamed from: a */
        public abstract long mo28979a();

        /* renamed from: b */
        public abstract long mo28980b();
    }

    /* renamed from: com.tencent.smtt.utils.j$d */
    static class C16157d extends C24282k {
        /* renamed from: a */
        int f3049a;
        /* renamed from: b */
        int f3050b;
        /* renamed from: c */
        int f3051c;
        /* renamed from: d */
        int f3052d;
        /* renamed from: e */
        int f3053e;
        /* renamed from: f */
        int f3054f;

        C16157d() {
        }

        /* renamed from: a */
        public int mo28981a() {
            return this.f3052d;
        }

        /* renamed from: b */
        public long mo28982b() {
            return (long) this.f3051c;
        }
    }

    /* renamed from: com.tencent.smtt.utils.j$j */
    static abstract class C24276j {
        /* renamed from: g */
        int f4532g;
        /* renamed from: h */
        int f4533h;

        C24276j() {
        }
    }

    /* renamed from: com.tencent.smtt.utils.j$l */
    static abstract class C24277l {
        /* renamed from: c */
        int f4534c;
        /* renamed from: d */
        char f4535d;
        /* renamed from: e */
        char f4536e;
        /* renamed from: f */
        short f4537f;

        C24277l() {
        }
    }

    /* renamed from: com.tencent.smtt.utils.j$i */
    static class C24279i extends C24277l {
        /* renamed from: a */
        long f4548a;
        /* renamed from: b */
        long f4549b;

        C24279i() {
        }
    }

    /* renamed from: com.tencent.smtt.utils.j$b */
    static class C24280b extends C16156a {
        /* renamed from: k */
        int f4550k;
        /* renamed from: l */
        int f4551l;
        /* renamed from: m */
        int f4552m;

        C24280b() {
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public long mo28979a() {
            return (long) this.f4552m;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: b */
        public long mo28980b() {
            return (long) this.f4551l;
        }
    }

    /* renamed from: com.tencent.smtt.utils.j$c */
    static class C24281c extends C24276j {
        /* renamed from: a */
        int f4553a;
        /* renamed from: b */
        int f4554b;
        /* renamed from: c */
        int f4555c;
        /* renamed from: d */
        int f4556d;
        /* renamed from: e */
        int f4557e;
        /* renamed from: f */
        int f4558f;

        C24281c() {
        }
    }

    /* renamed from: com.tencent.smtt.utils.j$k */
    public static abstract class C24282k {
        /* renamed from: g */
        int f4559g;
        /* renamed from: h */
        int f4560h;
        /* renamed from: i */
        int f4561i;
        /* renamed from: j */
        int f4562j;

        /* renamed from: a */
        public abstract int mo28981a();

        /* renamed from: b */
        public abstract long mo28982b();
    }

    /* renamed from: com.tencent.smtt.utils.j$f */
    static class C24283f extends C16156a {
        /* renamed from: k */
        long f4563k;
        /* renamed from: l */
        long f4564l;
        /* renamed from: m */
        long f4565m;

        C24283f() {
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public long mo28979a() {
            return this.f4565m;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: b */
        public long mo28980b() {
            return this.f4564l;
        }
    }

    /* renamed from: com.tencent.smtt.utils.j$h */
    static class C24284h extends C24282k {
        /* renamed from: a */
        long f4566a;
        /* renamed from: b */
        long f4567b;
        /* renamed from: c */
        long f4568c;
        /* renamed from: d */
        long f4569d;
        /* renamed from: e */
        long f4570e;
        /* renamed from: f */
        long f4571f;

        C24284h() {
        }

        /* renamed from: a */
        public int mo28981a() {
            return (int) this.f4569d;
        }

        /* renamed from: b */
        public long mo28982b() {
            return this.f4568c;
        }
    }

    /* renamed from: com.tencent.smtt.utils.j$e */
    static class C24285e extends C24277l {
        /* renamed from: a */
        int f4572a;
        /* renamed from: b */
        int f4573b;

        C24285e() {
        }
    }

    /* renamed from: com.tencent.smtt.utils.j$g */
    static class C24286g extends C24276j {
        /* renamed from: a */
        long f4574a;
        /* renamed from: b */
        long f4575b;
        /* renamed from: c */
        long f4576c;
        /* renamed from: d */
        long f4577d;
        /* renamed from: e */
        long f4578e;
        /* renamed from: f */
        long f4579f;

        C24286g() {
        }
    }

    public C24278j(File file) {
        AppMethodBeat.m2504i(65211);
        C24273c c24273c = new C24273c(file);
        this.f4544g = c24273c;
        c24273c.mo40362a(this.f4539b);
        UnknownFormatConversionException unknownFormatConversionException;
        if (mo40373a()) {
            c24273c.mo40365a(mo40378e());
            boolean d = mo40377d();
            if (d) {
                C24283f c24283f = new C24283f();
                c24283f.f3039a = c24273c.mo40363a();
                c24283f.f3040b = c24273c.mo40363a();
                c24283f.f3041c = c24273c.mo40366b();
                c24283f.f4563k = c24273c.mo40367c();
                c24283f.f4564l = c24273c.mo40367c();
                c24283f.f4565m = c24273c.mo40367c();
                this.f4545h = c24283f;
            } else {
                C24280b c24280b = new C24280b();
                c24280b.f3039a = c24273c.mo40363a();
                c24280b.f3040b = c24273c.mo40363a();
                c24280b.f3041c = c24273c.mo40366b();
                c24280b.f4550k = c24273c.mo40366b();
                c24280b.f4551l = c24273c.mo40366b();
                c24280b.f4552m = c24273c.mo40366b();
                this.f4545h = c24280b;
            }
            C16156a c16156a = this.f4545h;
            c16156a.f3042d = c24273c.mo40366b();
            c16156a.f3043e = c24273c.mo40363a();
            c16156a.f3044f = c24273c.mo40363a();
            c16156a.f3045g = c24273c.mo40363a();
            c16156a.f3046h = c24273c.mo40363a();
            c16156a.f3047i = c24273c.mo40363a();
            c16156a.f3048j = c24273c.mo40363a();
            this.f4546i = new C24282k[c16156a.f3047i];
            for (short s = (short) 0; s < c16156a.f3047i; s++) {
                c24273c.mo40364a(c16156a.mo28979a() + ((long) (c16156a.f3046h * s)));
                if (d) {
                    C24284h c24284h = new C24284h();
                    c24284h.f4559g = c24273c.mo40366b();
                    c24284h.f4560h = c24273c.mo40366b();
                    c24284h.f4566a = c24273c.mo40367c();
                    c24284h.f4567b = c24273c.mo40367c();
                    c24284h.f4568c = c24273c.mo40367c();
                    c24284h.f4569d = c24273c.mo40367c();
                    c24284h.f4561i = c24273c.mo40366b();
                    c24284h.f4562j = c24273c.mo40366b();
                    c24284h.f4570e = c24273c.mo40367c();
                    c24284h.f4571f = c24273c.mo40367c();
                    this.f4546i[s] = c24284h;
                } else {
                    C16157d c16157d = new C16157d();
                    c16157d.f4559g = c24273c.mo40366b();
                    c16157d.f4560h = c24273c.mo40366b();
                    c16157d.f3049a = c24273c.mo40366b();
                    c16157d.f3050b = c24273c.mo40366b();
                    c16157d.f3051c = c24273c.mo40366b();
                    c16157d.f3052d = c24273c.mo40366b();
                    c16157d.f4561i = c24273c.mo40366b();
                    c16157d.f4562j = c24273c.mo40366b();
                    c16157d.f3053e = c24273c.mo40366b();
                    c16157d.f3054f = c24273c.mo40366b();
                    this.f4546i[s] = c16157d;
                }
            }
            if (c16156a.f3048j < (short) 0 || c16156a.f3048j >= this.f4546i.length) {
                unknownFormatConversionException = new UnknownFormatConversionException("Invalid e_shstrndx=" + c16156a.f3048j);
                AppMethodBeat.m2505o(65211);
                throw unknownFormatConversionException;
            }
            C24282k c24282k = this.f4546i[c16156a.f3048j];
            if (c24282k.f4560h == 3) {
                this.f4547j = new byte[c24282k.mo28981a()];
                c24273c.mo40364a(c24282k.mo28982b());
                c24273c.mo40361a(this.f4547j);
                if (this.f4540c) {
                    m37447f();
                }
                AppMethodBeat.m2505o(65211);
                return;
            }
            unknownFormatConversionException = new UnknownFormatConversionException("Wrong string section e_shstrndx=" + c16156a.f3048j);
            AppMethodBeat.m2505o(65211);
            throw unknownFormatConversionException;
        }
        unknownFormatConversionException = new UnknownFormatConversionException("Invalid elf magic: ".concat(String.valueOf(file)));
        AppMethodBeat.m2505o(65211);
        throw unknownFormatConversionException;
    }

    /* renamed from: a */
    public static boolean m37445a(File file) {
        AppMethodBeat.m2504i(65216);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            long readInt = (long) randomAccessFile.readInt();
            randomAccessFile.close();
            if (readInt == 2135247942) {
                AppMethodBeat.m2505o(65216);
                return true;
            }
            AppMethodBeat.m2505o(65216);
            return false;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(65216);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m37446b(File file) {
        AppMethodBeat.m2504i(65217);
        if (C24278j.m37448g() && C24278j.m37445a(file)) {
            try {
                C24278j c24278j = new C24278j(file);
            } catch (IOException e) {
                new StringBuilder("checkElfFile IOException: ").append(e);
                AppMethodBeat.m2505o(65217);
                return false;
            } catch (UnknownFormatConversionException e2) {
                new StringBuilder("checkElfFile UnknownFormatConversionException: ").append(e2);
            } catch (Throwable th) {
                new StringBuilder("checkElfFile Throwable: ").append(th);
            }
        }
        AppMethodBeat.m2505o(65217);
        return true;
    }

    /* renamed from: f */
    private void m37447f() {
        AppMethodBeat.m2504i(65212);
        C16156a c16156a = this.f4545h;
        C24273c c24273c = this.f4544g;
        boolean d = mo40377d();
        C24282k a = mo40371a(".dynsym");
        if (a != null) {
            c24273c.mo40364a(a.mo28982b());
            int a2 = a.mo28981a() / (d ? 24 : 16);
            this.f4542e = new C24277l[a2];
            char[] cArr = new char[1];
            for (int i = 0; i < a2; i++) {
                if (d) {
                    C24279i c24279i = new C24279i();
                    c24279i.f4534c = c24273c.mo40366b();
                    c24273c.mo40362a(cArr);
                    c24279i.f4535d = cArr[0];
                    c24273c.mo40362a(cArr);
                    c24279i.f4536e = cArr[0];
                    c24279i.f4548a = c24273c.mo40367c();
                    c24279i.f4549b = c24273c.mo40367c();
                    c24279i.f4537f = c24273c.mo40363a();
                    this.f4542e[i] = c24279i;
                } else {
                    C24285e c24285e = new C24285e();
                    c24285e.f4534c = c24273c.mo40366b();
                    c24285e.f4572a = c24273c.mo40366b();
                    c24285e.f4573b = c24273c.mo40366b();
                    c24273c.mo40362a(cArr);
                    c24285e.f4535d = cArr[0];
                    c24273c.mo40362a(cArr);
                    c24285e.f4536e = cArr[0];
                    c24285e.f4537f = c24273c.mo40363a();
                    this.f4542e[i] = c24285e;
                }
            }
            C24282k c24282k = this.f4546i[a.f4561i];
            c24273c.mo40364a(c24282k.mo28982b());
            this.f4543f = new byte[c24282k.mo28981a()];
            c24273c.mo40361a(this.f4543f);
        }
        this.f4541d = new C24276j[c16156a.f3045g];
        for (short s = (short) 0; s < c16156a.f3045g; s++) {
            c24273c.mo40364a(c16156a.mo28980b() + ((long) (c16156a.f3044f * s)));
            if (d) {
                C24286g c24286g = new C24286g();
                c24286g.f4532g = c24273c.mo40366b();
                c24286g.f4533h = c24273c.mo40366b();
                c24286g.f4574a = c24273c.mo40367c();
                c24286g.f4575b = c24273c.mo40367c();
                c24286g.f4576c = c24273c.mo40367c();
                c24286g.f4577d = c24273c.mo40367c();
                c24286g.f4578e = c24273c.mo40367c();
                c24286g.f4579f = c24273c.mo40367c();
                this.f4541d[s] = c24286g;
            } else {
                C24281c c24281c = new C24281c();
                c24281c.f4532g = c24273c.mo40366b();
                c24281c.f4533h = c24273c.mo40366b();
                c24281c.f4553a = c24273c.mo40366b();
                c24281c.f4554b = c24273c.mo40366b();
                c24281c.f4555c = c24273c.mo40366b();
                c24281c.f4556d = c24273c.mo40366b();
                c24281c.f4557e = c24273c.mo40366b();
                c24281c.f4558f = c24273c.mo40366b();
                this.f4541d[s] = c24281c;
            }
        }
        AppMethodBeat.m2505o(65212);
    }

    /* renamed from: g */
    private static boolean m37448g() {
        AppMethodBeat.m2504i(65218);
        String property = System.getProperty("java.vm.version");
        if (property == null || !property.startsWith("2")) {
            AppMethodBeat.m2505o(65218);
            return false;
        }
        AppMethodBeat.m2505o(65218);
        return true;
    }

    /* renamed from: a */
    public final C24282k mo40371a(String str) {
        AppMethodBeat.m2504i(65213);
        for (C24282k c24282k : this.f4546i) {
            if (str.equals(mo40372a(c24282k.f4559g))) {
                AppMethodBeat.m2505o(65213);
                return c24282k;
            }
        }
        AppMethodBeat.m2505o(65213);
        return null;
    }

    /* renamed from: a */
    public final String mo40372a(int i) {
        AppMethodBeat.m2504i(65214);
        if (i == 0) {
            String str = "SHN_UNDEF";
            AppMethodBeat.m2505o(65214);
            return str;
        }
        int i2 = i;
        while (this.f4547j[i2] != (byte) 0) {
            i2++;
        }
        String str2 = new String(this.f4547j, i, i2 - i);
        AppMethodBeat.m2505o(65214);
        return str2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo40373a() {
        return this.f4539b[0] == f4538a[0];
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final char mo40374b() {
        return this.f4539b[4];
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final char mo40375c() {
        return this.f4539b[5];
    }

    public void close() {
        AppMethodBeat.m2504i(65215);
        this.f4544g.close();
        AppMethodBeat.m2505o(65215);
    }

    /* renamed from: d */
    public final boolean mo40377d() {
        AppMethodBeat.m2504i(65209);
        if (mo40374b() == 2) {
            AppMethodBeat.m2505o(65209);
            return true;
        }
        AppMethodBeat.m2505o(65209);
        return false;
    }

    /* renamed from: e */
    public final boolean mo40378e() {
        AppMethodBeat.m2504i(65210);
        if (mo40375c() == 1) {
            AppMethodBeat.m2505o(65210);
            return true;
        }
        AppMethodBeat.m2505o(65210);
        return false;
    }
}
